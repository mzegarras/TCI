package com.tci.controller;


import com.tci.Exception.CustomerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {



    @Value("${error.message01}")
    private String message01;

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<VndErrors> notFoundException(final CustomerNotFoundException e) {
        logger.error("Customer no found",e);
        return error(e, HttpStatus.NOT_FOUND, e.getId().toString());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
        return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());

    }

    @ExceptionHandler(RuntimeException.class)
    /*@ExceptionHandler({ NullPointerException.class,
            NullPointerException1.class})*/
    public ResponseEntity<VndErrors> assertionRuntimeException(final RuntimeException e) {
        logger.error("Runtime error",e);
        return error(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());

    }


    private ResponseEntity<VndErrors> error(
            final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }



}
