package com.kalffman.projects.game21.redis.util;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Table;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.redis.entity.CardEntity;
import com.kalffman.projects.game21.redis.entity.PlayerEntity;
import com.kalffman.projects.game21.redis.entity.TableEntity;

public final class MapperUtil {

    public static Table toTable(TableEntity entity) {
        return new Table(
                ShufflerType.valueOf(entity.getShufflerType()),
                entity.getDeck().stream().map(MapperUtil::toCard).toList(),
                entity.getPlayers().stream().map(MapperUtil::toPlayer).toList(),
                entity.getRound()
        );
    }

    public static TableEntity toTableEntity(Table model) {
        return new TableEntity(
                model.getId(),
                model.getShufflerType().toString(),
                model.getDeck().stream().map(MapperUtil::toCardEntity).toList(),
                model.getPlayers().stream().map(MapperUtil::toPlayerEntity).toList(),
                model.getRound()
        );
    }

    public static Card toCard(CardEntity entity) {
        return new Card(entity.getValue(), CardSuit.valueOf(entity.getSuit()));
    }

    public static CardEntity toCardEntity(Card model) {
        return new CardEntity(
                model.getName(),
                model.getSuit().toString(),
                model.getType().toString(),
                model.getValue()
        );
    }

    public static Player toPlayer(PlayerEntity entity) {
        return new Player(
                entity.getName(),
                entity.getHands().stream().map(MapperUtil::toCard).toList(),
                entity.getPoints(),
                PlayerStatus.valueOf(entity.getName())
        );
    }

    public static PlayerEntity toPlayerEntity(Player model) {
        return new PlayerEntity(
                model.getName(),
                model.getHands().stream().map(MapperUtil::toCardEntity).toList(),
                model.getPoints(),
                model.getStatus().toString()
        );
    }
}
