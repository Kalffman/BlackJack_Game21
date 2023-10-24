package com.kalffman.projects.game21.usecase.factory;

import com.kalffman.projects.game21.domain.factory.ShufflerFactory;
import com.kalffman.projects.game21.domain.model.common.ShuffleStyle;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.usecase.model.common.ManualShuffleStyle;
import com.kalffman.projects.game21.usecase.model.common.MachineShuffleStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ShufflerFactoryImpl implements ShufflerFactory {

    private final Map<ShufflerType, ShuffleStyle> shufflers;

    public ShufflerFactoryImpl(ManualShuffleStyle manualShuffleStyle, MachineShuffleStyle machineShuffleStyle) {
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
