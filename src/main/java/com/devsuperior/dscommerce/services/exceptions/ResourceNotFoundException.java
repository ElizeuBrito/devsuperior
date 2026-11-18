package com.devsuperior.dscommerce.services.exceptions;

//Runtime exception does not require try/catch block during compilation
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
