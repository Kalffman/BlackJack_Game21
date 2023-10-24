package com.kalffman.projects.game21.domain.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    private final String code;

    public DomainException(String code, String message) {
        super(message);
        this.code = code;
    }
}
