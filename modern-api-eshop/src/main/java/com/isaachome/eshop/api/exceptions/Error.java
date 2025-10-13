package com.isaachome.eshop.api.exceptions;

import org.apache.logging.log4j.util.Strings;

public class Error {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String message;
    private Integer status;
    private String url = "Not available";
    private String reqMethod = "Not Available";

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getReqMethod() {
        return reqMethod;
    }
    public Error setUrl(String url){
        if(Strings.isNotBlank(url)){
            this.url = url;
        }
        return this;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Error setRequestMethod(String reqMethod) {
        if(Strings.isEmpty(reqMethod)) {
            this.reqMethod = reqMethod;
        }
        return this;
    }
}
