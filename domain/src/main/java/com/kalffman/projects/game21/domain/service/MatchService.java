package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;

import java.util.UUID;

public interface MatchService {

    Match createNewMatch();

    Match signInPlayer(Player player, UUID matchId);
}
