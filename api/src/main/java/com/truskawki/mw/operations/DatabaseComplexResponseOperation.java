package com.truskawki.mw.operations;

import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.io.InputStream;

public abstract class DatabaseComplexResponseOperation <T extends Mapper>  extends DatabaseOperation {
    protected T mapper;
    private Class<T> mapperType;

    public DatabaseComplexResponseOperation(Class<T> mapperType){
        this.mapperType = mapperType;
    }

    public TruskawkiSimpleResponse performAction() {
        InputStream inputStream = openInputStream();
        SqlSession session = establishSession(inputStream);
        mapper = session.getMapper(mapperType);

        TruskawkiSimpleResponse truskawkiSimpleResponse;

        truskawkiSimpleResponse = mainAction();
        session.commit();

        truskawkiSimpleResponse.setResult(getResultCode());

        session.close();
        closeInputStream(inputStream);

        return truskawkiSimpleResponse;
    }

    abstract protected TruskawkiSimpleResponse mainAction();
}
