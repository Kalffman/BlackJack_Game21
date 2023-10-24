package com.kalffman.projects.game21.output;

import com.kalffman.projects.game21.output.dto.MatchOutputDTO;

import java.util.UUID;

public interface MatchOutputService {

    MatchOutputDTO retrieveMatch(UUID matchId);

    MatchOutputDTO persistMatch(MatchOutputDTO match);
}
