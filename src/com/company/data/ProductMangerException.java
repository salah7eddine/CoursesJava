package com.company.data;

public class ProductMangerException extends Exception {

    public ProductMangerException() {
    }

    public ProductMangerException(String message) {
        super(message);
    }

    public ProductMangerException(String message, Throwable cause) {
        super(message, cause);
    }
}
