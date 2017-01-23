package com.truskawki.mw.operations;

import com.truskawki.mw.constants.DatabaseOperationResultEnum;
import com.truskawki.mw.constants.Strings;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class DatabaseOperation {
    private final Logger logger = Logger.getLogger(DatabaseOperation.class);
    private static HashMap<DatabaseOperationResultEnum, Integer> responseMap = new HashMap<>();

    static{
        responseMap.put(DatabaseOperationResultEnum.VEHICLE_REGISTERED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.VEHICLE_REGISTER_ATTEMPT_FAILED_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseMap.put(DatabaseOperationResultEnum.VEHICLE_FETCHED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.VEHICLE_NOT_FETCHED_PROPERLY_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseMap.put(DatabaseOperationResultEnum.OWNER_FETCHED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.OWNER_NOT_FETCHED_PROPERLY_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseMap.put(DatabaseOperationResultEnum.OWNERS_FOR_POLICEMAN_FETCHED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.OWNERS_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseMap.put(DatabaseOperationResultEnum.VEHICLES_FOR_POLICEMAN_FETCHED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.VEHICLES_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseMap.put(DatabaseOperationResultEnum.PRZEGLADY_FOR_POLICEMAN_FETCHED_PROPERLY, HttpServletResponse.SC_OK);
        responseMap.put(DatabaseOperationResultEnum.PRZEGLADY_FOR_POLICEMAN_NOT_FETCHED_PROPERLY_DUE_TO_ERROR, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    protected DatabaseOperationResultEnum databaseOperationResultEnum;

    protected SqlSession establishSession(InputStream inputStream){
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    protected InputStream openInputStream(){
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(Strings.MYBATIS_CONFIG_FILE_NAME);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
        }

        return inputStream;
    }

    protected void closeInputStream(InputStream inputStream){
        try {
            inputStream.close();
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
        }
    }

    protected boolean getBoolean(int dual){
        if(dual == 1)
            return true;
        else
            return false;
    }

    protected int getResultCode() {
        logger.log(Level.INFO, databaseOperationResultEnum.getName());
        return responseMap.get(databaseOperationResultEnum);
    }
}
