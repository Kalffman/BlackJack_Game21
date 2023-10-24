package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Table;

import java.util.UUID;

public interface TableService {

    Table createEmptyTable();

    Table signInPlayer(Player player, UUID tableId);
}
