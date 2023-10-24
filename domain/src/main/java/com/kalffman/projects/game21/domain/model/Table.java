package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class Table {

    private final UUID id = UUID.randomUUID();
    private ShufflerType shufflerType;
    private List<Card> deck;
    private List<Player> players = new ArrayList<>();
    private int round = 1;

    public Table(ShufflerType shufflerType, List<Card> deck) {
        this.shufflerType = shufflerType;
        this.deck = deck;
    }

    public void signInPlayer(Player player) {
        this.players.add(player);
    }

    public void checkRound() {
        checkPlayers();

        Player winner = getWinner();

        if (winner != null) {

        } else {
            this.round += 1;
        }
    }

    private Player getWinner() {
        Optional<Player> winner = this.players.stream()
                .filter(p -> p.getStatus() == PlayerStatus.WIN)
                .findFirst();

        return winner.orElse(null);
    }

    private void checkPlayers() {
        this.players.forEach(Player::update);
    }
}
