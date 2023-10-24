package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.exception.InvalidCardValueException;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.CardType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {-1, 0, 14})
    void shouldThrowExceptionWhenInvalidCardValueProvided(int cardValue) {
        assertThrows(InvalidCardValueException.class, ()-> {
            new Card(cardValue, CardSuit.SPADES);
        });
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {1, 6, 10})
    void shouldNotThrowExceptionWhenValidCardValueProvided(int cardValue) {
        assertDoesNotThrow(() -> {
            new Card(cardValue, CardSuit.SPADES);
        });
    }

    @Test
    void shouldValidateAttributesWhenCardValueProvided() {
        Card card = new Card(1, CardSuit.SPADES);

        assertEquals("ás de espadas", card.getName());
        assertEquals(CardType.FIGURE, card.getType());
    }
}
