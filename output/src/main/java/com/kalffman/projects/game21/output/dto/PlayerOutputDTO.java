package com.kalffman.projects.game21.output.dto;

import java.util.List;

public record PlayerOutputDTO(
        String name,
        List<CardOutputDTO> hands,
        Integer points,
        String status
) {
}
