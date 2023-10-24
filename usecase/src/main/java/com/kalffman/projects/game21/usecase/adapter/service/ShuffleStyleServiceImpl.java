package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.service.ShuffleStyleService;
import com.kalffman.projects.game21.domain.model.ShuffleStyle;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.usecase.adapter.model.MachineShuffleStyle;
import com.kalffman.projects.game21.usecase.adapter.model.ManualShuffleStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ShuffleStyleServiceImpl implements ShuffleStyleService {

    private final Map<ShufflerType, ShuffleStyle> shufflers;

    public ShuffleStyleServiceImpl(ManualShuffleStyle manualShuffleStyle, MachineShuffleStyle machineShuffleStyle) {
        this.shufflers = new HashMap<>();
        this.shufflers.put(ShufflerType.MANUAL, manualShuffleStyle);
        this.shufflers.put(ShufflerType.MACHINE, machineShuffleStyle);
    }
    @Override
    public ShuffleStyle retrieveShuffleStyle(ShufflerType shufflerType) {
        log.debug("c=ShufflerFactoryImpl m=retrieveShuffleStyle status=called shuffle_style={}", shufflerType);
        return this.shufflers.get(shufflerType);
    }
}
