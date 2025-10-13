package com.isaachome.eshop.api.exceptions;

import java.lang.Error;

public class ErrorUtils {
    private ErrorUtils() {}

    /**
     *  Creates and return an error object
     * @param errMsgKey
     * @param errorCode
     * @param httpStatusCode
     * @param
     * @return error
     */
    public static java.lang.Error createError(final String errMsgKey, final String errorCode,
                                              final Integer httpStatusCode) {
        java.lang.Error error = new Error();
        error.setMessage(errMsgKey);
        error.setErrorCode(errorCode);
        error.setStatus(httpStatusCode);
        return error;
    }

}
