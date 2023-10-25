package com.kalffman.projects.game21.redis.util;

import com.kalffman.projects.game21.output.dto.CardOutputDTO;
import com.kalffman.projects.game21.output.dto.PlayerOutputDTO;
import com.kalffman.projects.game21.output.dto.MatchOutputDTO;
import com.kalffman.projects.game21.redis.entity.CardEntity;
import com.kalffman.projects.game21.redis.entity.PlayerEntity;
import com.kalffman.projects.game21.redis.entity.MatchEntity;

import java.util.UUID;

public final class MapperUtil {

    public static MatchOutputDTO toMatchOutputDTO(MatchEntity entity) {
        return new MatchOutputDTO(
                UUID.fromString(entity.getId()),
                entity.getShufflerType(),
                entity.getDeck().stream().map(MapperUtil::toCardOutputDTO).toList(),
                entity.getPlayers().stream().map(MapperUtil::toPlayerOutputDTO).toList(),
                entity.getRound()
        );
    }

    public static MatchEntity toMatchEntity(MatchOutputDTO model) {
        return new MatchEntity(
                model.id().toString(),
                model.shufflerType(),
                model.deck().stream().map(MapperUtil::toCardEntity).toList(),
                model.players().stream().map(MapperUtil::toPlayerEntity).toList(),
                model.round()
        );
    }

    public static CardOutputDTO toCardOutputDTO(CardEntity entity) {
        return new CardOutputDTO(entity.getSuit(), entity.getValue());
    }

    public static CardEntity toCardEntity(CardOutputDTO model) {
        return new CardEntity(
                model.suit(),
                model.value()
        );
    }

    public static PlayerOutputDTO toPlayerOutputDTO(PlayerEntity entity) {
        return new PlayerOutputDTO(
                entity.getName(),
                entity.getHands().stream().map(MapperUtil::toCardOutputDTO).toList(),
                entity.getPoints(),
                entity.getName()
        );
    }

    public static PlayerEntity toPlayerEntity(PlayerOutputDTO model) {
        return new PlayerEntity(
                model.name(),
                model.hands().stream().map(MapperUtil::toCardEntity).toList(),
                model.points(),
                model.status()
        );
    }
}
