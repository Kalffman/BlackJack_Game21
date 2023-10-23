package com.kalffman.projects.game21.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Match {
    private final UUID id = UUID.randomUUID();
    private Table table;
    private final Map<Player, Integer> playersRound = new HashMap<>();
    private boolean started = false;


}
