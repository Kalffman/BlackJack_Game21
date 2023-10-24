package com.kalffman.projects.game21.domain.factory;

import com.kalffman.projects.game21.domain.model.common.ShuffleStyle;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;

/**
 * Class that creates a types of cards shuffling
 */
public interface ShufflerFactory {

    /**
     * Factory method that retrieve shuffler by type
     */
    ShuffleStyle retrieveShuffleStyle(ShufflerType shufflerType);

}
