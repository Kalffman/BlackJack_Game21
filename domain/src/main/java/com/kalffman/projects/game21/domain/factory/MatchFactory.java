package com.kalffman.projects.game21.domain.factory;

import com.kalffman.projects.game21.domain.model.Match;

/** Class that can create tables for play */
public interface MatchFactory {

    /** Factory method to generate new table for gaming */
    Match ganerateNewMatch();
}
