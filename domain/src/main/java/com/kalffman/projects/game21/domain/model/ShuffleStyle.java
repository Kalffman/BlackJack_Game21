package com.kalffman.projects.game21.domain.model;

import com.kalffman.projects.game21.domain.model.Card;

import java.util.List;

public interface ShuffleStyle {
    List<Card> doShuffle(List<Card> cards);
}
