package com.kalffman.projects.game21.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    private String name;
    private List<CardEntity> hands;
    private Integer points;
    private String status;
}
