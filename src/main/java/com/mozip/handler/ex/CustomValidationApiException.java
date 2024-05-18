package com.mozip.handler.ex;

import java.util.HashMap;
import java.util.Map;

public class CustomValidationApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Map<String, String> errorMap = new HashMap<>();

    public CustomValidationApiException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

    public CustomValidationApiException(String message) {
        super(message);
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}
