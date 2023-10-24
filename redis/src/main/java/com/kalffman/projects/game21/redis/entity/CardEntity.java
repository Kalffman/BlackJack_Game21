package com.kalffman.projects.game21.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {
    private String name;
    private String suit;
    private String type;
    private Integer value;
}
