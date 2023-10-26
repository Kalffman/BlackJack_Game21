package com.kalffman.projects.game21.usecase.adapter.model;

import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.Dealer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class ManualDealer implements Dealer {

    @Override
    public void shuffleCards(Match match) {
        log.debug("c=ManualShuffleStyle m=doShuffle status=started cards={}", match.getDeck());

        var r = new Random();
        int size = match.getDeck().size();

        for (int i = size - 1; i > 0; i--) {

            int j = r.nextInt(i + 1);

            var temp = match.getDeck().get(i);
            match.getDeck().set(i, match.getDeck().get(j));
            match.getDeck().set(j, temp);
        }

        log.debug("c=ManualShuffleStyle m=doShuffle status=finished cards={}", match.getDeck());
    }
}
