package com.kalffman.projects.game21.domain.exception;

import java.util.UUID;

import static java.lang.String.format;

public class MatchNotFoundException extends DomainException {

    public MatchNotFoundException(UUID id) {
        super("match.not.found", format("Match with id \"%s\" not found", id));
    }
}
