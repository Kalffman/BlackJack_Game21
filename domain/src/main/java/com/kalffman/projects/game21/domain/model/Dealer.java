package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;

public interface Dealer {

    void shuffleCards(Match match);

    default boolean shouldGiveCard(Player player, Match match) {
        if(match.getFinished()) {
            return false;
        } else if(player.getStatus() == PlayerStatus.LOSE) {
            return false;
        } else {
            return player.getHands().size() < match.getRound();
        }
    }

    default Card giveCard(Match match) {
        return match.getDeck().remove(0);
    }
}
