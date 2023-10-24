package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.CardType;
import com.kalffman.projects.game21.domain.model.enums.PlayerStatus;
import com.kalffman.projects.game21.domain.util.DomainUtil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "name")
public class Player {

    private String name;
    private List<Card> hands = new ArrayList<>();
    private int points = 0;
    private PlayerStatus status = PlayerStatus.CAN_PLAY;

    public Player(String name) {
        this.name = name;
    }

    public void update() {
        this.updatePoints();
        this.updateStatus();
    }

    public void updatePoints() {
        List<Card> numberCards = hands.stream().filter(c -> c.getType() == CardType.NUMBER).toList();
        List<Card> figureCards = hands.stream().filter(c -> c.getType() == CardType.FIGURE && c.getValue() > 1).toList();
        List<Card> aceCards = hands.stream().filter(c -> c.getType() == CardType.FIGURE && c.getValue() == 1).toList();

        int sumNumberCards = numberCards.stream().mapToInt(Card::getValue).sum();

        int sumFigureCards = figureCards.size() * 10;

        int partialSum = sumNumberCards + sumFigureCards;

        this.points = DomainUtil.sumAceCardPoints(partialSum, aceCards.size());
    }

    public void updateStatus() {
        int actualPoints = this.points;

        if (actualPoints < 21) {
            this.status = PlayerStatus.CAN_PLAY;
        } else if (actualPoints == 21) {
            this.status = PlayerStatus.WIN;
        } else {
            this.status = PlayerStatus.LOSE;
        }
    }

    public void takeCard(Card card) {
        this.hands.add(card);
    }
}
