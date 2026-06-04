package com.devsuperior.clientescrud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

    private final List<FieldMessages> errors = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessages> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String fieldMessage) {
        errors.add(new FieldMessages(fieldName, fieldMessage));
    }
}
