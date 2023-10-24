package com.kalffman.projects.game21.input.dto;

import java.util.List;
import java.util.UUID;

public record TableInputDTO(
    UUID id,
    String shufflerType,
    List<CardInputDTO> deck,
    List<PlayerInputDTO> players,
    Integer round
) {
}
