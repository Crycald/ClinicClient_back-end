package com.client.clientapi.exception.connector;

public class OperationConnectorNotFoundException extends RuntimeException{
    public OperationConnectorNotFoundException(long id) {
        super("Not found operation list with id: " + id);
    }
}
