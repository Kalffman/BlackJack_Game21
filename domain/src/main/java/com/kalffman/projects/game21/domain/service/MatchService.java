package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;

import java.util.UUID;

public interface MatchService {

    Match createDefaultMatch();

    Match retrieveMatch(UUID matchId);

    Match signInPlayer(Player player, UUID matchId);
}
