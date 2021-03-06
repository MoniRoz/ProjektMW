package com.truskawki.mw;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truskawki.mw.lib.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SKPService {

    @Autowired
    private SKPRepository SKPRepository;

    private Logger logger = Logger.getLogger(StarostaService.class);

    public void addPrzeglad(String requestBody, HttpServletResponse response) {
        PrzegladPOST przegladPOST = parseToPrzegladPost(requestBody);

        TruskawkiSimpleResponse truskawkiSimpleResponse;
        truskawkiSimpleResponse = SKPRepository.addPrzeglad(przegladPOST.getVin(), przegladPOST.getPrzeglad());

        response.setStatus(truskawkiSimpleResponse.getResult());
    }


    private PrzegladPOST parseToPrzegladPost(String requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PrzegladPOST przegladPOST = null;

        try {
            przegladPOST = mapper.readValue(requestBody, PrzegladPOST.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.toString());
            throw new RuntimeException();
        }

        return przegladPOST;
    }
}
