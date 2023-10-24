package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.ShuffleStyle;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;

/**
 * Class that creates a types of cards shuffling
 */
public interface ShuffleStyleService {

    /**
     * Factory method that retrieve shuffler by type
     */
    ShuffleStyle retrieveShuffleStyle(ShufflerType shufflerType);

}
