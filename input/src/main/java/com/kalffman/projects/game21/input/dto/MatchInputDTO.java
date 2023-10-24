package com.kalffman.projects.game21.input.dto;

import java.util.List;
import java.util.UUID;

public record MatchInputDTO(
    UUID id,
    String shufflerType,
    List<PlayerInputDTO> players,
    Integer round
) {
}
