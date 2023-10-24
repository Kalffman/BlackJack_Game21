package com.kalffman.projects.game21.domain.exception;

import java.util.UUID;

import static java.lang.String.format;

public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(UUID id) {
        super(format("Match with id \"%s\" not was not founded", id));
    }
}
