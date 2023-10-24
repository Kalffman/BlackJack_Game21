package com.kalffman.projects.game21.usecase.model.common;

import com.kalffman.projects.game21.domain.model.Card;
import com.kalffman.projects.game21.domain.model.common.ShuffleStyle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManualShuffleStyle implements ShuffleStyle {

    @Override
    public List<Card> doShuffle(List<Card> cards) {
        return null;
    }
}
