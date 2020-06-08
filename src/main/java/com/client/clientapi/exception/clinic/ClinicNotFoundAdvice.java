package com.client.clientapi.exception.clinic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClinicNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ClinicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String clinicNotFoundHandler(ClinicNotFoundException exception) {
        return exception.getMessage();
    }
}
