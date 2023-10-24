package com.kalffman.projects.game21.usecase.util;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Table;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.input.dto.CardInputDTO;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.TableInputDTO;

public final class MapperUtil {

    public static Table toTable(TableInputDTO dto) {
        return new Table(
                ShufflerType.valueOf(dto.shufflerType()),
                dto.deck().stream().map(MapperUtil::toCard).toList(),
                dto.players().stream().map(MapperUtil::toPlayer).toList(),
                dto.round()
        );
    }

    public static TableInputDTO toTableInputDTO(Table domain) {
        return new TableInputDTO(
                domain.getId(),
                domain.getShufflerType().name(),
                domain.getDeck().stream().map(MapperUtil::toCardInputDTO).toList(),
                domain.getPlayers().stream().map(MapperUtil::toPlayerInputDTO).toList(),
                domain.getRound()
        );
    }

    public static Card toCard(CardInputDTO dto) {
        return new Card(dto.value(), CardSuit.valueOf(dto.suit()));
    }

    public static CardInputDTO toCardInputDTO(Card domain) {
        return new CardInputDTO(
                domain.getName(),
                domain.getSuit().name(),
                domain.getValue()
        );
    }

    public static Player toPlayer(PlayerInputDTO dto) {
        return new Player(
                dto.name(),
                dto.hands().stream().map(MapperUtil::toCard).toList(),
                dto.points(),
                PlayerStatus.valueOf(dto.status())
        );
    }

    public static PlayerInputDTO toPlayerInputDTO(Player domain) {
        return new PlayerInputDTO(
                domain.getName(),
                domain.getHands().stream().map(MapperUtil::toCardInputDTO).toList(),
                domain.getPoints(),
                domain.getStatus().name()
        );
    }
}
