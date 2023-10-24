package com.kalffman.projects.game21.rest.controller.v1.match;

import com.kalffman.projects.game21.input.MatchInputService;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/match", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class MatchV1Controller {

    private final MatchInputService matchService;

    public MatchV1Controller(MatchInputService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/new")
    public ResponseEntity<MatchInputDTO> createNewMatch() {
        log.debug("[CONTROLLER][CREATE_NEW_MATCH]");

        MatchInputDTO createdMatch = matchService.createNewMatch();

        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdMatch.id())
                .toUri();

        return ResponseEntity.created(location).body(createdMatch);
    }

    @PutMapping("/signIn")
    public ResponseEntity<MatchInputDTO> signInPlayer(
            @RequestHeader UUID matchId,
            @RequestBody PlayerInputDTO player
    ) {
        log.debug("[CONTROLLER][SIGN_IN_PLAYER_MATCH] matchId={} player={}", matchId, player);

        return ResponseEntity.ok(matchService.joinPlayerInMatch(player, matchId));
    }
}
