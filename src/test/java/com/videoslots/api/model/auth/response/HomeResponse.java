package com.videoslots.api.model.auth.response;

public class HomeResponse {

    private  int statusCode;

    public HomeResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    public HomeResponse(){}

    public int getStatusCode() {
        return statusCode;
    }
}
