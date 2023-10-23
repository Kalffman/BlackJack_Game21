package com.kalffman.projects.game21.usecase.adapter.factory;

import com.kalffman.projects.game21.domain.factory.DeckFactory;
import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DeckFactoryImpl implements DeckFactory {

    @Override
    public List<Card> createFullDeckOfCards() {
        List<Card> fullDeck = new ArrayList<>();

        fullDeck.addAll(createSuitDeckOfCards(CardSuit.CLUBS));
        fullDeck.addAll(createSuitDeckOfCards(CardSuit.HEARTS));
        fullDeck.addAll(createSuitDeckOfCards(CardSuit.SPADES));
        fullDeck.addAll(createSuitDeckOfCards(CardSuit.DIAMONDS));

        return fullDeck;
    }

    @Override
    public List<Card> createSuitDeckOfCards(CardSuit suit) {
        return IntStream.rangeClosed(1, 13)
                .boxed()
                .map(cardValue -> new Card(cardValue, suit))
                .collect(Collectors.toList());
    }
}
