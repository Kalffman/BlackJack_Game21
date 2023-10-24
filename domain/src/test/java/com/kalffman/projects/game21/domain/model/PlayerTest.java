package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    void shouldGiveCorrectPointsToGivenCards() {
        Player jeff = new Player("Jeff");

        jeff.takeCard(new Card(2, CardSuit.SPADES));
        jeff.takeCard(new Card(3, CardSuit.HEARTS));
        jeff.takeCard(new Card(11, CardSuit.CLUBS));

        jeff.updatePoints();

        assertEquals(15, jeff.getPoints());
    }

    @Test
    void shouldGiveCorrectPointsAndStatusWinnerToGivenAceCards() {
        Player jeff = new Player("Jeff");

        jeff.takeCard(new Card(1, CardSuit.SPADES));
        jeff.takeCard(new Card(1, CardSuit.HEARTS));
        jeff.takeCard(new Card(1, CardSuit.CLUBS));

        jeff.update();

        assertEquals(21, jeff.getPoints());
        assertEquals(PlayerStatus.WIN, jeff.getStatus());
    }

    @Test
    void shouldGiveCorrectPointsAndStatusLoserToGivenAceCards() {
        Player jeff = new Player("Jeff");

        jeff.takeCard(new Card(1, CardSuit.SPADES));
        jeff.takeCard(new Card(1, CardSuit.HEARTS));
        jeff.takeCard(new Card(1, CardSuit.CLUBS));
        jeff.takeCard(new Card(1, CardSuit.DIAMONDS));

        jeff.update();

        assertEquals(22, jeff.getPoints());
        assertEquals(PlayerStatus.LOSE, jeff.getStatus());
    }
}
