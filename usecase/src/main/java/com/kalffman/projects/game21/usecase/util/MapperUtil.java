package com.kalffman.projects.game21.usecase.util;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.input.dto.CardInputDTO;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
import com.kalffman.projects.game21.output.dto.CardOutputDTO;
import com.kalffman.projects.game21.output.dto.PlayerOutputDTO;
import com.kalffman.projects.game21.output.dto.MatchOutputDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class MapperUtil {

    public static Match toMatch(MatchOutputDTO dto) {
        return new Match(
                dto.id(),
                ShufflerType.valueOf(dto.shufflerType()),
                new ArrayList<>(dto.deck().stream().map(MapperUtil::toCard).toList()),
                new ArrayList<>(dto.players().stream().map(MapperUtil::toPlayer).toList()),
                dto.round()
        );
    }

    public static MatchInputDTO toMatchInputDTO(Match model) {
        return new MatchInputDTO(
                model.getId(),
                model.getShufflerType().toString(),
                model.getPlayers().stream().map(MapperUtil::toPlayerInputDTO).toList(),
                model.getRound()
        );
    }

    public static MatchOutputDTO toMatchOutputDTO(Match model) {
        return new MatchOutputDTO(
                model.getId(),
                model.getShufflerType().toString(),
                model.getDeck().stream().map(MapperUtil::toCardOutputDTO).toList(),
                model.getPlayers().stream().map(MapperUtil::toPlayerOutputDTO).toList(),
                model.getRound()
        );
    }

    public static Card toCard(CardInputDTO dto) {
        return new Card(dto.value(), CardSuit.valueOf(dto.suit()));
    }

    public static Card toCard(CardOutputDTO dto) {
        return new Card(dto.value(), CardSuit.valueOf(dto.suit()));
    }

    public static CardInputDTO toCardInputDTO(Card model) {
        return new CardInputDTO(
                model.getName(),
                model.getSuit().toString(),
                model.getValue()
        );
    }

    public static CardOutputDTO toCardOutputDTO(Card model) {
        return new CardOutputDTO(model.getSuit().toString(), model.getValue());
    }

    public static Player toPlayer(PlayerInputDTO dto) {
        return new Player(
                dto.name(),
                new ArrayList<>(dto.hands() != null ? dto.hands().stream().map(MapperUtil::toCard).toList() : List.of()),
                dto.points() != null ? dto.points() : 0,
                dto.status() != null ? PlayerStatus.valueOf(dto.status()) : PlayerStatus.CAN_PLAY
        );
    }

    public static Player toPlayer(PlayerOutputDTO dto) {
        return new Player(
                dto.name(),
                new ArrayList<>(dto.hands().stream().map(MapperUtil::toCard).toList()),
                dto.points(),
                PlayerStatus.valueOf(dto.status())
        );
    }

    public static PlayerInputDTO toPlayerInputDTO(Player model) {
        return new PlayerInputDTO(
                model.getName(),
                model.getHands().stream().map(MapperUtil::toCardInputDTO).toList(),
                model.getPoints(),
                model.getStatus().toString()
        );
    }

    public static PlayerOutputDTO toPlayerOutputDTO(Player model) {
        return new PlayerOutputDTO(
                model.getName(),
                model.getHands().stream().map(MapperUtil::toCardOutputDTO).toList(),
                model.getPoints(),
                model.getStatus().toString()
        );
    }
}
