package com.truskawki.mw.operations;

import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import org.apache.ibatis.annotations.Mapper;

public abstract class DatabaseComplexResponseOperation <T extends Mapper>  extends DatabaseOperation {
    protected T mapper;
    private Class<T> mapperType;

    public DatabaseComplexResponseOperation(Class<T> mapperType){
        this.mapperType = mapperType;
    }

    public TruskawkiSimpleResponse performAction() {
//        InputStream inputStream = openInputStream();
//        SqlSession session = establishSession(inputStream);
//        mapper = session.getMapper(mapperType);
//
//        MalinkiComplexResponse malinkiComplexResponse;
//
//        malinkiComplexResponse = mainAction();
//        session.commit();
//        malinkiComplexResponse.setResult(getResultCode());
//
//        session.close();
//        closeInputStream(inputStream);

        return new TruskawkiSimpleResponse();
    }

    abstract protected TruskawkiSimpleResponse mainAction();
}
