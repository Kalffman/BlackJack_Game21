package com.kalffman.projects.game21.input.exception;

import lombok.Getter;

@Getter
public class InputException extends RuntimeException {

    private final String code;
    public InputException(String code, Throwable throwable) {
        super(throwable.getMessage(), throwable);
        this.code = code;
    }
}
