package com.isaachome.eshop.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.Error;
import java.util.Locale;

@RestControllerAdvice
public class RestApiErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(RestApiErrorHandler.class);
    private final MessageSource messageSource;
    public RestApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Generic Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<java.lang.Error> handleException(HttpServletRequest req, Exception ex, Locale locale) {
        var error = ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(),
                ErrorCode.GENERIC_ERROR.getErrCode(),
                HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setUrl(req.getRequestURL().toString())
                .setRequestMethod(req.getMethod());
        return  new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotSupportException(
            HttpServletRequest request,
            HttpMediaTypeNotSupportedException ex,
            Locale locale
    ){
        var error = ErrorUtils
                .createError(
                        ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                .setUrl(request.getRequestURI().toString())
                .setRequestMethod(request.getMethod());
        log.info("HttpMediaTypeNotSupportedException :: request.getMethod(): {}",request.getMethod());
        return  new ResponseEntity<>(error, HttpStatus.UNSUPPORTED_MEDIA_TYPE);

    }
}
