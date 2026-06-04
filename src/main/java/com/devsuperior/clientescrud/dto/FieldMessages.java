package com.devsuperior.clientescrud.dto;

public class FieldMessages {

    private final String fieldName;
    private final String message;

    public FieldMessages(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
