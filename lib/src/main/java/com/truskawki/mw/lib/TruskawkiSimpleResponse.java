package com.truskawki.mw.lib;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class TruskawkiSimpleResponse {
    private List<String> responseList;
    private int result;

    public TruskawkiSimpleResponse() {
        this.result = HttpServletResponse.SC_BAD_REQUEST;
    }

    public List<String> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<String> responseList) {
        this.responseList = responseList;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}