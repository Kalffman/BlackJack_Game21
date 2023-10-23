package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.enums.CardType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {

    private String name;
    private List<Card> hands;

    public int getPoints() {
        List<Card> numberCards = hands.stream().filter(c -> c.getType() == CardType.NUMBER).toList();
        List<Card> figureCards = hands.stream().filter(c -> c.getType() == CardType.FIGURE && c.getValue() > 1).toList();
        List<Card> aceCards = hands.stream().filter(c -> c.getType() == CardType.FIGURE && c.getValue() == 1).toList();

        int sumNumberCards = numberCards.stream().mapToInt(Card::getValue).sum();

        int sumFigureCards = figureCards.size() * 10;

        int partialSum = sumNumberCards + sumFigureCards;

        return sumAceCardPoints(partialSum, aceCards.size());
    }

    private int sumAceCardPoints(Integer partialSum, Integer qtdACards) {
        if (qtdACards == 0) return partialSum;

        boolean aceOnePoint = partialSum > 11;

        partialSum += (aceOnePoint ? 1 : 10);

        return sumAceCardPoints(partialSum, qtdACards - 1);
    }
}
