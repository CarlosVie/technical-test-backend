package com.playtomic.tests.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -4013009075081629571L;

    private String id;

    public DataNotFoundException(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
