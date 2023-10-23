package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.exception.InvalidCardValueException;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.CardType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private String name;
    private CardSuit suit;
    private CardType type;
    private int value;

    public Card(int value, CardSuit suit) {
        if(value < 1 || value > 13) {
            throw new InvalidCardValueException(value);
        }

        this.name = switch (value) {
            case 1 -> "ás";
            case 11 -> "valete";
            case 12 -> "dama";
            case 13 -> "reis";
            default -> String.valueOf(value);
        } + " de " + suit.getTitle();

        this.type = switch (value) {
            case 1, 11, 12, 13 -> CardType.FIGURE;
            default -> CardType.NUMBER;
        };

        this.suit = suit;
        this.value = value;
    }
}
