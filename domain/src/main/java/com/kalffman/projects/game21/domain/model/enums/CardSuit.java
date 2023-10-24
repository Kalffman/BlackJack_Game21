package com.kalffman.projects.game21.domain.model.enums;

import lombok.Getter;

@Getter
public enum CardSuit {
    CLUBS("paus"),
    HEARTS("copas"),
    SPADES("espadas"),
    DIAMONDS("ouro");

    private final String title;

    CardSuit(String title) {
        this.title = title;
    }
}
