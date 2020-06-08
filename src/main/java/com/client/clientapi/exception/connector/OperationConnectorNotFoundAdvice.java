package com.client.clientapi.exception.connector;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class OperationConnectorNotFoundAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OperationConnectorNotFoundException.class)
    public String operationConnectorNotFoundExceptionHandler(OperationConnectorNotFoundException exception) {
        return exception.getMessage();
    }
}
