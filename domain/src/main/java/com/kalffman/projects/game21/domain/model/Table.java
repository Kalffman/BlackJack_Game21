package com.kalffman.projects.game21.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Table {

    private List<Card> availableCards;
    private List<Player> players = new ArrayList<>();
    private int round = 1;

    public Table(List<Card> fullDeck, Player... players) {
        this.availableCards = fullDeck;
        this.players.addAll(Arrays.stream(players).toList());
    }
}
