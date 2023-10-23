package com.kalffman.projects.game21.usecase.adapter.factory;

import com.kalffman.projects.game21.domain.factory.MatchFactory;
import com.kalffman.projects.game21.domain.model.Match;
import org.springframework.stereotype.Service;

@Service
public class MatchFactoryImpl implements MatchFactory {

    @Override
    public Match ganerateNewMatch() {
        return null;
    }
}
