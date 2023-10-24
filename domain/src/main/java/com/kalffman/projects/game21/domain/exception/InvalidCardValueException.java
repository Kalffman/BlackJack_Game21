package com.kalffman.projects.game21.domain.exception;

import static java.lang.String.format;

public class InvalidCardValueException extends DomainException {
    public InvalidCardValueException(int invalidNumber) {
        super("invalid.card.value.provided", format("\"%d\" is not a valid card value", invalidNumber));
    }
}
