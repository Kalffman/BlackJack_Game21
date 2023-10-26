package com.kalffman.projects.game21.domain.exception;

public class GiveCardNotAllowedException extends DomainException {

    public GiveCardNotAllowedException() {
        super("give.card.not.allowed", "Dealer decided not give a card");
    }
}
