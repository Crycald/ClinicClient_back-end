package com.client.clientapi.exception.operation;

public class OperationNotFoundException extends RuntimeException {
    public OperationNotFoundException(Long id) {
        super("Not found operation with id: " + id);
    }
}
