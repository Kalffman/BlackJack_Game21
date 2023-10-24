package com.kalffman.projects.game21.input;

import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.TableInputDTO;

import java.util.UUID;

public interface TableInputService {

    TableInputDTO createEmptyTable();

    TableInputDTO joinPlayerInTable(PlayerInputDTO player, UUID tableId);
}
