package com.kalffman.projects.game21.usecase.adapter.model;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.ShuffleStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class ManualShuffleStyle implements ShuffleStyle {

    @Override
    public List<Card> doShuffle(List<Card> cards) {
        log.debug("c=ManualShuffleStyle m=doShuffle status=started cards={}", cards);

        Random r = new Random();
        int size = cards.size();

        for (int i = size - 1; i > 0; i--) {

            int j = r.nextInt(i + 1);

            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }

        log.debug("c=ManualShuffleStyle m=doShuffle status=finished cards={}", cards);
        return cards;
    }
}
