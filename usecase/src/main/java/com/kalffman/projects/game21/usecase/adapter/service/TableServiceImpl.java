package com.kalffman.projects.game21.usecase.adapter.service;

import com.kalffman.projects.game21.domain.model.Player;
import com.kalffman.projects.game21.domain.model.Table;
import com.kalffman.projects.game21.domain.model.enums.ShufflerType;
import com.kalffman.projects.game21.domain.repository.TableRepository;
import com.kalffman.projects.game21.domain.service.DeckService;
import com.kalffman.projects.game21.domain.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TableServiceImpl implements TableService {

    private final DeckService deckService;
    private final TableRepository repository;

    public TableServiceImpl(DeckService deckService, TableRepository repository) {
        this.deckService = deckService;
        this.repository = repository;
    }

    @Override
    public Table createEmptyTable() {
        log.info("[DOMAIN_USE_CASE][CREATE_DEFAULT_TABLE] status=started");

        var table = new Table(ShufflerType.MANUAL, deckService.createFullDeck());

        log.info("[DOMAIN_USE_CASE][CREATE_DEFAULT_TABLE] status=finished");
        return table;
    }

    @Override
    public Table signInPlayer(Player player, UUID tableId) {
        log.info("[DOMAIN_USE_CASE][SIGN_IN_PLAYER] status=started");

        Table domainTable = repository.retrieveTable(tableId);

        domainTable.sigInPlayer(player);

        log.info("[DOMAIN_USE_CASE][SIGN_IN_PLAYER] status=finished");
        return domainTable;
    }
}
