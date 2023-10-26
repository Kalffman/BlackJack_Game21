package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.exception.DomainException;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;

import java.util.UUID;

/**
 * Interface that represents a communication to external boundaries with domain
 */
public interface MatchService {

    Match createDefaultMatch();

    Match retrieveMatch(UUID matchId);

    Match signInPlayer(Player player, UUID matchId) throws DomainException;

    Match pullCardInMatch(String playerName, UUID matchId) throws DomainException;
}
