package com.kalffman.projects.game21.usecase.adapter.model;

import com.kalffman.projects.game21.domain.model.Match;
import com.kalffman.projects.game21.domain.model.Dealer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class MachineDealer implements Dealer {
    @Override
    public void shuffleCards(Match match) {
        log.debug("c=MachineShuffleStyle m=doShuffle status=started cards={}", match.getDeck());

        Collections.shuffle(match.getDeck());

        log.debug("c=MachineShuffleStyle m=doShuffle status=finished cards={}", match.getDeck());
    }
}
