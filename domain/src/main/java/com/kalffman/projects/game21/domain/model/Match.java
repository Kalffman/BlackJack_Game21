package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.exception.PlayerNotFoundException;
import com.kalffman.projects.game21.domain.exception.SignInNotAllowedException;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.model.enums.DealerType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Match {

    private UUID id;
    private DealerType dealerType;
    private List<Card> deck;
    private Set<Player> players = new HashSet<>();
    private Integer round;
    private Boolean started;
    private Boolean finished;

    public Match(DealerType dealerType, List<Card> deck) {
        this.id = UUID.randomUUID();
        this.dealerType = dealerType;
        this.deck = deck;
        this.round = 1;
        this.started = false;
        this.finished = false;
    }

    public void sigInPlayer(Player player) {
        if(this.started) {
            throw new SignInNotAllowedException();
        } else {
            this.players.add(player);
        }
    }

    public Player findPlayerInMatch(String playerName) {
        return this.players.stream()
                .filter(p -> p.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(playerName));
    }

    public void updatePlayer(Player player) {
        this.players.add(player);

        checkPlayers();
    }

    public void checkRound() {
        checkPlayers();

        if (getWinner() != null) {
            this.finished = true;
        } else if (isAllPlayersLose()) {
            this.finished = true;
        } else {
            if (isSomeOnePulled()) {
                this.started = true;
            }
            if(allPlayersPulledInRound()) {
                this.round += 1;
            }
        }
    }

    private Player getWinner() {
        var winner = this.players.stream()
                .filter(p -> p.getStatus() == PlayerStatus.WIN)
                .findFirst();

        return winner.orElse(null);
    }

    private boolean isAllPlayersLose() {
        return this.players.stream().allMatch(p -> p.getStatus() == PlayerStatus.LOSE);
    }

    private boolean isSomeOnePulled() {
        return this.players.stream().anyMatch(p -> !p.getHands().isEmpty());
    }

    public boolean allPlayersPulledInRound() {
        return this.players.stream().allMatch(p -> p.getHands().size() == this.round);
    }

    private void checkPlayers() {
        this.players.forEach(Player::updateStatus);
    }
}
