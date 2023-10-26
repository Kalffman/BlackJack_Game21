package com.kalffman.projects.game21.usecase.util;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.enums.CardSuit;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.DealerType;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
import com.kalffman.projects.game21.input.dto.SignInPlayerInputDTO;
import com.kalffman.projects.game21.output.dto.CardOutputDTO;
import com.kalffman.projects.game21.output.dto.PlayerOutputDTO;
import com.kalffman.projects.game21.output.dto.MatchOutputDTO;

import java.util.ArrayList;
import java.util.HashSet;

public final class MapperUtil {

    public static Match toMatch(MatchOutputDTO dto) {
        return new Match(
                dto.id(),
                DealerType.valueOf(dto.shufflerType()),
                new ArrayList<>(dto.deck().stream().map(MapperUtil::toCard).toList()),
                new HashSet<>(dto.players().stream().map(MapperUtil::toPlayer).toList()),
                dto.round(),
                dto.started(),
                dto.finished()
        );
    }

    public static MatchInputDTO toMatchInputDTO(Match model) {
        return new MatchInputDTO(
                model.getId(),
                model.getDealerType().toString(),
                model.getPlayers().stream().map(MapperUtil::toPlayerInputDTO).toList(),
                model.getRound(),
                model.getStarted(),
                model.getFinished()
        );
    }

    public static MatchOutputDTO toMatchOutputDTO(Match model) {
        return new MatchOutputDTO(
                model.getId(),
                model.getDealerType().toString(),
                model.getDeck().stream().map(MapperUtil::toCardOutputDTO).toList(),
                model.getPlayers().stream().map(MapperUtil::toPlayerOutputDTO).toList(),
                model.getRound(),
                model.getStarted(),
                model.getFinished()
        );
    }

    public static Card toCard(CardOutputDTO dto) {
        return new Card(dto.value(), CardSuit.valueOf(dto.suit()));
    }

    public static CardOutputDTO toCardOutputDTO(Card model) {
        return new CardOutputDTO(model.getSuit().toString(), model.getValue());
    }

    public static Player toPlayer(SignInPlayerInputDTO dto) {
        return new Player(dto.name());
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
                model.getHands().stream().map(Card::getName).toList(),
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
