package com.example.restfulwebservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNOtFoundException extends RuntimeException {
    public UserNOtFoundException(String message) {
        super(message);
    }
}
