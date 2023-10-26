package com.kalffman.projects.game21.domain.exception;

import static java.lang.String.format;

public class PlayerNotFoundException extends DomainException {

    public PlayerNotFoundException(String name) {
        super("player.not.found", format("Player with name \"%s\" not found in this match", name));
    }
}
