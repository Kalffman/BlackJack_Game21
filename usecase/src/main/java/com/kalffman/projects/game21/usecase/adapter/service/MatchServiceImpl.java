package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.exception.MatchNotFoundException;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.domain.service.ShuffleStyleService;
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
    private final ShuffleStyleService shuffleStyleService;

    public MatchServiceImpl(
            @Value("${application.config.shuffler}")
            String applicationShuffler,
            DeckService deckService,
            MatchOutputService outputService,
            ShuffleStyleService shuffleStyleService) {
        this.applicationShuffler = applicationShuffler;
        this.deckService = deckService;
        this.outputService = outputService;
        this.shuffleStyleService = shuffleStyleService;
    }

    @Override
    public Match createDefaultMatch() {
        log.info("[DOMAIN_USE_CASE][CREATE_NEW_MATCH] status=started");

        var match = new Match(ShufflerType.valueOf(applicationShuffler), deckService.createFullDeck());

        var shuffler = shuffleStyleService.retrieveShuffleStyle(match.getShufflerType());

        var shuffledDeck = shuffler.doShuffle(match.getDeck());

        match.setDeck(shuffledDeck);

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

        var output = outputService.retrieveMatch(matchId);

        if(output == null) {
            throw new MatchNotFoundException(matchId);
        }

        var domainMatch = MapperUtil.toMatch(output);

        domainMatch.sigInPlayer(player);

        outputService.persistMatch(MapperUtil.toMatchOutputDTO(domainMatch));

        log.info("[DOMAIN_USE_CASE][SIGN_IN_PLAYER] status=finished matchId={}", matchId);
        return domainMatch;
    }
}
