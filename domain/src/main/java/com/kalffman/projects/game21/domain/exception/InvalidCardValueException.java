package com.kalffman.projects.game21.domain.exception;

import static java.lang.String.format;

public class InvalidCardValueException extends RuntimeException {
    public InvalidCardValueException(int invalidNumber) {
        super(format("\"%d\" is not a valid card value", invalidNumber));
    }
}
