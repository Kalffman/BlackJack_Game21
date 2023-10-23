package com.kalffman.projects.game21.domain.model.enums;

import lombok.Getter;

@Getter
public enum CardSuit {
    CLUBS("Paus"),
    HEARTS("Copas"),
    SPADES("Espadas"),
    DIAMONDS("Ouro");

    private final String title;

    CardSuit(String title) {
        this.title = title;
    }
}
