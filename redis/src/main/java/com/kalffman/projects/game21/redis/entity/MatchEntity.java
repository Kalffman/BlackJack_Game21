package com.kalffman.projects.game21.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Match")
public class MatchEntity {
    private UUID id;
    private String shufflerType;
    private List<CardEntity> deck;
    private List<PlayerEntity> players;
    private Integer round;
}
