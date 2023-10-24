package com.kalffman.projects.game21.usecase.adapter.input;

import com.kalffman.projects.game21.domain.model.Table;
import com.kalffman.projects.game21.domain.service.TableService;
import com.kalffman.projects.game21.input.TableInputService;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.TableInputDTO;
import com.kalffman.projects.game21.usecase.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TableInputServiceImpl implements TableInputService {

    private final TableService domainService;

    public TableInputServiceImpl(TableService domainService) {
        this.domainService = domainService;
    }

    @Override
    public TableInputDTO createEmptyTable() {
        log.info("[INPUT_USE_CASE][CREATE_DEFAULT_TABLE] status=started");

        Table domainTable = domainService.createEmptyTable();

        log.info("[INPUT_USE_CASE][CREATE_DEFAULT_TABLE] status=finished");
        return MapperUtil.toTableInputDTO(domainTable);
    }

    @Override
    public TableInputDTO joinPlayerInTable(PlayerInputDTO player, UUID tableId) {
        log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=started");

        Table domainTable = domainService.signInPlayer(MapperUtil.toPlayer(player), tableId);

        log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=finished");

        return MapperUtil.toTableInputDTO(domainTable);
    }
}
