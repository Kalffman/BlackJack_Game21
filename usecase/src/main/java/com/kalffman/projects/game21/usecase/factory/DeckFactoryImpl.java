package com.kalffman.projects.game21.usecase.factory;

import com.kalffman.projects.game21.domain.factory.DeckFactory;
import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class DeckFactoryImpl implements DeckFactory {

    @Override
    public List<Card> createFullDeck() {
        log.debug("c=DeckFactoryImpl m=createFullDeck status=started");

        List<Card> fullDeck = new ArrayList<>();

        fullDeck.addAll(createSuitDeck(CardSuit.CLUBS));
        fullDeck.addAll(createSuitDeck(CardSuit.HEARTS));
        fullDeck.addAll(createSuitDeck(CardSuit.SPADES));
        fullDeck.addAll(createSuitDeck(CardSuit.DIAMONDS));

        log.debug("c=DeckFactoryImpl m=createFullDeck status=finished");
        return fullDeck;
    }

    @Override
    public List<Card> createSuitDeck(CardSuit suit) {
        log.debug("c=DeckFactoryImpl m=createFullDeck status=called");

        return IntStream.rangeClosed(1, 13)
                .boxed()
                .map(cardValue -> new Card(cardValue, suit))
                .collect(Collectors.toList());
    }
}
