package com.kalffman.projects.game21.rest.controller.v1.table;

import com.kalffman.projects.game21.input.TableInputService;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.TableInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/table", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class TableV1Controller {

    private final TableInputService tableService;

    public TableV1Controller(TableInputService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/default")
    public ResponseEntity<TableInputDTO> createDefaultTable() {
        log.debug("[CONTROLLER][CREATE_DEFAULT_TABLE]");

        TableInputDTO createdTable = tableService.createEmptyTable();

        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTable.id())
                .toUri();

        return ResponseEntity.created(location).body(createdTable);
    }

    @PutMapping("/signIn")
    public ResponseEntity<TableInputDTO> signInPlayer(
            @RequestHeader UUID tableId,
            @RequestBody PlayerInputDTO playerDto
    ) {
        return ResponseEntity.ok(tableService.joinPlayerInTable(playerDto, tableId));
    }
}
