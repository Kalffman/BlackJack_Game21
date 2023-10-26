package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.service.DealerService;
import com.kalffman.projects.game21.domain.model.Dealer;
import com.kalffman.projects.game21.domain.model.enums.DealerType;
import com.kalffman.projects.game21.usecase.adapter.model.MachineDealer;
import com.kalffman.projects.game21.usecase.adapter.model.ManualDealer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DealerServiceImpl implements DealerService {

    private final Map<DealerType, Dealer> shufflers;

    public DealerServiceImpl(ManualDealer manualDealer, MachineDealer machineDealer) {
        this.shufflers = new HashMap<>();
        this.shufflers.put(DealerType.MANUAL, manualDealer);
        this.shufflers.put(DealerType.MACHINE, machineDealer);
    }
    @Override
    public Dealer callDealer(DealerType dealerType) {
        log.debug("c=ShufflerFactoryImpl m=retrieveShuffleStyle status=called shuffle_style={}", dealerType);
        return this.shufflers.get(dealerType);
    }
}
