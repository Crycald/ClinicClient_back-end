package com.client.clientapi.exception.customer;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id) {
        super("Not found customer with id: " + id);
    }
}
