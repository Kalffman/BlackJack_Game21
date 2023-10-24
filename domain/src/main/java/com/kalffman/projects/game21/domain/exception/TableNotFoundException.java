package com.kalffman.projects.game21.domain.exception;

import java.util.UUID;

import static java.lang.String.format;

public class TableNotFoundException extends RuntimeException {

    public TableNotFoundException(UUID id) {
        super(format("Table with id \"%s\" not was not founded", id));
    }
}
