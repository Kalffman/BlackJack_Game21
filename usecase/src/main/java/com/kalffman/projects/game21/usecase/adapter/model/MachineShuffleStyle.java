package com.kalffman.projects.game21.usecase.adapter.model;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.ShuffleStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class MachineShuffleStyle implements ShuffleStyle {
    @Override
    public List<Card> doShuffle(List<Card> cards) {
        log.debug("c=MachineShuffleStyle m=doShuffle status=started cards={}", cards);

        Collections.shuffle(cards);

        log.debug("c=MachineShuffleStyle m=doShuffle status=finished cards={}", cards);
        return cards;
    }
}
