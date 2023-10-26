package com.kalffman.projects.game21.domain.exception;

import static java.lang.String.format;

public class SignInNotAllowedException extends DomainException {

    public SignInNotAllowedException() {
        super("sign-in.not.allowed", "Given match already started");
    }
}
