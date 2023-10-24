package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.service.DeckService;
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
public class DeckServiceImpl implements DeckService {

    @Override
    public List<Card> createFullDeck() {
        log.info("[DOMAIN_USE_CASE][CREATE_FULL_DECK] status=started");

        List<Card> fullDeck = new ArrayList<>();

        fullDeck.addAll(createSuitDeck(CardSuit.CLUBS));
        fullDeck.addAll(createSuitDeck(CardSuit.HEARTS));
        fullDeck.addAll(createSuitDeck(CardSuit.SPADES));
        fullDeck.addAll(createSuitDeck(CardSuit.DIAMONDS));

        log.info("[DOMAIN_USE_CASE][CREATE_FULL_DECK] status=finished");
        return fullDeck;
    }

    @Override
    public List<Card> createSuitDeck(CardSuit suit){
        return IntStream.rangeClosed(1, 13)
                .boxed()
                .map(cardValue -> new Card(cardValue, suit))
                .collect(Collectors.toList());
    }
}
