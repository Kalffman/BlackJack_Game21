package com.kalffman.projects.game21.input.dto;

import java.util.List;

public record PlayerInputDTO(
        String name,
        List<CardInputDTO> hands,
        Integer points,
        String status
) {
}
