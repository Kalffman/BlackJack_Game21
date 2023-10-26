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
                entity.getRound(),
                entity.getStarted(),
                entity.getFinished()
        );
    }

    public static MatchEntity toMatchEntity(MatchOutputDTO dto) {
        return new MatchEntity(
                dto.id().toString(),
                dto.shufflerType(),
                dto.deck().stream().map(MapperUtil::toCardEntity).toList(),
                dto.players().stream().map(MapperUtil::toPlayerEntity).toList(),
                dto.round(),
                dto.started(),
                dto.finished()
        );
    }

    public static CardOutputDTO toCardOutputDTO(CardEntity entity) {
        return new CardOutputDTO(entity.getSuit(), entity.getValue());
    }

    public static CardEntity toCardEntity(CardOutputDTO dto) {
        return new CardEntity(
                dto.suit(),
                dto.value()
        );
    }

    public static PlayerOutputDTO toPlayerOutputDTO(PlayerEntity entity) {
        return new PlayerOutputDTO(
                entity.getName(),
                entity.getHands().stream().map(MapperUtil::toCardOutputDTO).toList(),
                entity.getPoints(),
                entity.getStatus()
        );
    }

    public static PlayerEntity toPlayerEntity(PlayerOutputDTO dto) {
        return new PlayerEntity(
                dto.name(),
                dto.hands().stream().map(MapperUtil::toCardEntity).toList(),
                dto.points(),
                dto.status()
        );
    }
}
