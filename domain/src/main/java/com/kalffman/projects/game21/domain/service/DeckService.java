package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;

import java.util.List;

/**
 * Class that can create deck of cards
 */
public interface DeckService {

    /**
     * Factory method to generate a default deck of cards
     */
    List<Card> createFullDeck();

    /**
     * Factory method to generate a suit deck of cards
     */
    List<Card> createSuitDeck(CardSuit suit);
}
