package com.truskawki.mw.lib;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class TruskawkiSimpleResponse <T> {
    private T response;

    private int result;

    public TruskawkiSimpleResponse() {
        this.result = HttpServletResponse.SC_BAD_REQUEST;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
