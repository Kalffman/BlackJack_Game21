package com.kalffman.projects.game21.input;

import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;

import java.util.UUID;

public interface MatchInputService {

    MatchInputDTO createNewMatch();

    MatchInputDTO joinPlayerInMatch(PlayerInputDTO player, UUID matchId);
}
