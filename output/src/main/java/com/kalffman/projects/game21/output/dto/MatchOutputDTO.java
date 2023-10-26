package com.kalffman.projects.game21.output.dto;

import java.util.List;
import java.util.UUID;

public record MatchOutputDTO(
    UUID id,
    String shufflerType,
    List<CardOutputDTO> deck,
    List<PlayerOutputDTO> players,
    Integer round,
    Boolean started,
    Boolean finished
) {
}
