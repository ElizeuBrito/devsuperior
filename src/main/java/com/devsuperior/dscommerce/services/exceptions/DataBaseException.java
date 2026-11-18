package com.devsuperior.dscommerce.services.exceptions;

//Runtime exception does not require try/catch block during compilation
public class DataBaseException extends RuntimeException {

    public DataBaseException(String msg) {
        super(msg);
    }
}
