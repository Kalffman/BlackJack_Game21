package com.kalffman.projects.game21.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("matches")
public class MatchEntity {

    @Id
    private String id;
    private String shufflerType;
    private List<CardEntity> deck = new ArrayList<>();
    private List<PlayerEntity> players = new ArrayList<>();
    private Integer round;
}
