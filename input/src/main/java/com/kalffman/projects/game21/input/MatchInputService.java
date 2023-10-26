package com.kalffman.projects.game21.input;

import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.SignInPlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;

import java.util.UUID;

public interface MatchInputService {

    MatchInputDTO createDefaultMatch();

    MatchInputDTO retrieveMatch(UUID matchId);

    MatchInputDTO joinPlayerInMatch(SignInPlayerInputDTO player, UUID matchId);

    MatchInputDTO pullCardInMatch(String playerName, UUID matchId);
}
