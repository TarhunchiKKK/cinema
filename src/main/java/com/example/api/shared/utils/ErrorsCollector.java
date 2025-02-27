package com.example.api.shared.utils;

import java.util.HashMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorsCollector {
    private HashMap<String, String> errors;

    public ErrorsCollector(BindingResult bindingResult) {
        this.errors = new HashMap<String, String>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                this.errors.put(error.getField(), error.getDefaultMessage());
            }
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}
