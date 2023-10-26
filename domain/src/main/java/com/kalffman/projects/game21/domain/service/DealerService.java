package com.kalffman.projects.game21.domain.service;

import com.kalffman.projects.game21.domain.model.Dealer;
import com.kalffman.projects.game21.domain.model.enums.DealerType;

/**
 * Class that creates a types of cards shuffling
 */
public interface DealerService {

    /**
     * Factory method that retrieve shuffler by type
     */
    Dealer callDealer(DealerType dealerType);

}
