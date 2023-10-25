package com.kalffman.projects.game21.input;

import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;

import java.util.UUID;

public interface MatchInputService {

    MatchInputDTO createDefaultMatch();

    MatchInputDTO retrieveMatch(UUID matchId);

    MatchInputDTO joinPlayerInMatch(PlayerInputDTO player, UUID matchId);
}
