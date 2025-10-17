package com.isaachome.eshop.api.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public  ResourceNotFoundException(ErrorCode errorCode){
        super(errorCode.getErrMsgKey());
        this.errMsgKey = errorCode.getErrMsgKey();
        this.errorCode = errorCode.getErrCode();
    }
    public ResourceNotFoundException(final String message){
        super(message);
        this.errMsgKey = ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.RESOURCE_NOT_FOUND.getErrCode();
    }
    public String getErrMsgKey() {
        return  errMsgKey;
    }
    public String getErrCode() {
        return errorCode;
    }
}
