package com.kalffman.projects.game21.usecase.model.common;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.common.ShuffleStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class MachineShuffleStyle implements ShuffleStyle {
    @Override
    public List<Card> doShuffle(List<Card> cards) {
        log.debug("c=MachineShuffleStyle m=doShuffle status=started cards_size={}", cards.size());

        Collections.shuffle(cards);

        log.debug("c=MachineShuffleStyle m=doShuffle status=finished cards_size={}", cards.size());
        return cards;
    }
}
