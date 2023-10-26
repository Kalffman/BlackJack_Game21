package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void shouldGiveCorrectPointsToGivenCards() {
        Player jeff = new Player("Jeff");

        jeff.pullCard(new Card(2, CardSuit.SPADES));
        jeff.pullCard(new Card(3, CardSuit.HEARTS));
        jeff.pullCard(new Card(11, CardSuit.CLUBS));

        jeff.updatePoints();

        assertEquals(15, jeff.getPoints());
    }

    @Test
    void shouldGiveCorrectPointsAndStatusWinnerToGivenAceCards() {
        Player jeff = new Player("Jeff");

        jeff.pullCard(new Card(1, CardSuit.SPADES));
        jeff.pullCard(new Card(1, CardSuit.HEARTS));
        jeff.pullCard(new Card(1, CardSuit.CLUBS));

        jeff.updateStatus();

        assertEquals(21, jeff.getPoints());
        assertEquals(PlayerStatus.WIN, jeff.getStatus());
    }

    @Test
    void shouldGiveCorrectPointsAndStatusLoserToGivenAceCards() {
        Player jeff = new Player("Jeff");

        jeff.pullCard(new Card(1, CardSuit.SPADES));
        jeff.pullCard(new Card(1, CardSuit.HEARTS));
        jeff.pullCard(new Card(1, CardSuit.CLUBS));
        jeff.pullCard(new Card(1, CardSuit.DIAMONDS));

        jeff.updateStatus();

        assertEquals(22, jeff.getPoints());
        assertEquals(PlayerStatus.LOSE, jeff.getStatus());
    }

    @Test
    void shouldGiveCorrectPointsAndStatusWinToGivenFigureCards() {
        Player jeff = new Player("jeff");

        jeff.pullCard(new Card(1, CardSuit.SPADES));
        jeff.pullCard(new Card(11, CardSuit.SPADES));
        jeff.pullCard(new Card(12, CardSuit.SPADES));

        jeff.updateStatus();

        assertEquals(21, jeff.getPoints());
        assertEquals(PlayerStatus.WIN, jeff.getStatus());
    }
}
