package com.client.clientapi.exception.clinic;

public class ClinicNotFoundException extends RuntimeException {

    public ClinicNotFoundException(Long id) {
        super("Not found clinic with id: " + id);
    }
}
