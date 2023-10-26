package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.exception.DomainException;
import com.kalffman.projects.game21.domain.exception.GiveCardNotAllowedException;
import com.kalffman.projects.game21.domain.exception.MatchNotFoundException;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.enums.DealerType;
import com.kalffman.projects.game21.domain.service.DealerService;
import com.kalffman.projects.game21.output.MatchOutputService;
import com.kalffman.projects.game21.domain.service.DeckService;
import com.kalffman.projects.game21.domain.service.MatchService;
import com.kalffman.projects.game21.usecase.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class MatchServiceImpl implements MatchService {

    private final String applicationShuffler;
    private final DeckService deckService;
    private final MatchOutputService outputService;
    private final DealerService dealerService;

    public MatchServiceImpl(
            @Value("${application.config.shuffler}")
            String applicationShuffler,
            DeckService deckService,
            MatchOutputService outputService,
            DealerService dealerService) {
        this.applicationShuffler = applicationShuffler;
        this.deckService = deckService;
        this.outputService = outputService;
        this.dealerService = dealerService;
    }

    @Override
    public Match createDefaultMatch() {
        log.info("[DOMAIN_USE_CASE][CREATE_NEW_MATCH] status=started");

        var match = new Match(DealerType.valueOf(applicationShuffler), deckService.createFullDeck());

        var dealer = dealerService.callDealer(match.getDealerType());

        dealer.shuffleCards(match);

        outputService.persistMatch(MapperUtil.toMatchOutputDTO(match));

        log.info("[DOMAIN_USE_CASE][CREATE_NEW_MATCH] status=created matchId={}", match.getId());
        return match;
    }

    @Override
    public Match retrieveMatch(UUID matchId) {
        log.info("[DOMAIN_USE_CASE][RETRIEVE_MATCH] status=started matchId={}", matchId);

        var output = outputService.retrieveMatch(matchId);

        if(output == null){
            log.warn("[DOMAIN_USE_CASE][RETRIEVE_MATCH] status=not_found matchId={}", matchId);

            return null;
        } else {
            log.info("[DOMAIN_USE_CASE][RETRIEVE_MATCH] status=finished matchId={}", matchId);

            return MapperUtil.toMatch(output);
        }
    }

    @Override
    public Match signInPlayer(Player player, UUID matchId) {
        log.info("[DOMAIN_USE_CASE][SIGN_IN_PLAYER] status=started matchId={}", matchId);

        var matchOutput = outputService.retrieveMatch(matchId);

        if(matchOutput == null) {
            throw new MatchNotFoundException(matchId);
        }

        var domainMatch = MapperUtil.toMatch(matchOutput);

        domainMatch.sigInPlayer(player);

        outputService.persistMatch(MapperUtil.toMatchOutputDTO(domainMatch));

        log.info("[DOMAIN_USE_CASE][SIGN_IN_PLAYER] status=finished matchId={}", matchId);
        return domainMatch;
    }

    @Override
    public Match pullCardInMatch(String playerName, UUID matchId) throws DomainException {
        log.info("[DOMAIN_USE_CASE][PLAYER_ACTION] status=started playerName={} matchId={}", playerName, matchId);

        var matchOutput = outputService.retrieveMatch(matchId);

        if(matchOutput == null) {
            throw new MatchNotFoundException(matchId);
        }

        var match = MapperUtil.toMatch(matchOutput);

        var player = match.findPlayerInMatch(playerName);

        var dealer = dealerService.callDealer(match.getDealerType());

        if(!dealer.shouldGiveCard(player, match)) {
            throw new GiveCardNotAllowedException();
        }

        player.pullCard(dealer.giveCard(match));

        match.updatePlayer(player);

        match.checkRound();

        outputService.persistMatch(MapperUtil.toMatchOutputDTO(match));

        log.info("[DOMAIN_USE_CASE][PLAYER_ACTION] status=finished playerName={} matchId={}", playerName, matchId);
        return match;
    }
}
