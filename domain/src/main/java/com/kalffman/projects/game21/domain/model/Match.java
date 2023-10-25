package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Match {

    private UUID id;
    private ShufflerType shufflerType;
    private List<Card> deck;
    private List<Player> players = new ArrayList<>();
    private Integer round = 1;

    public Match(ShufflerType shufflerType, List<Card> deck) {
        this.id = UUID.randomUUID();
        this.shufflerType = shufflerType;
        this.deck = deck;
    }

    public void sigInPlayer(Player player) {
        this.players.add(player);
    }

    public void checkRound() {
        checkPlayers();

        var winner = getWinner();

        if (winner != null) {

        } else {
            this.round += 1;
        }
    }

    private Player getWinner() {
        var winner = this.players.stream()
                .filter(p -> p.getStatus() == PlayerStatus.WIN)
                .findFirst();

        return winner.orElse(null);
    }

    private void checkPlayers() {
        this.players.forEach(Player::update);
    }
}
