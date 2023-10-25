package com.kalffman.projects.game21.rest.controller.v1.match;

import com.kalffman.projects.game21.input.MatchInputService;
import com.kalffman.projects.game21.input.dto.SignInPlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController("matchControllerV1")
@RequestMapping(value = "/v1/match", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class MatchController {

    private final MatchInputService matchService;

    public MatchController(MatchInputService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchInputDTO> getMatch(@PathVariable UUID id) {
        log.debug("[CONTROLLER][GET_MATCH]");

        var match = matchService.retrieveMatch(id);

        if(match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/default")
    public ResponseEntity<MatchInputDTO> createDefaultMatch() {
        log.debug("[CONTROLLER][CREATE_NEW_MATCH]");

        var createdMatch = matchService.createDefaultMatch();

        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdMatch.id())
                .toUri();

        return ResponseEntity.created(location).body(createdMatch);
    }

    @PostMapping("/signIn")
    public ResponseEntity<MatchInputDTO> signInPlayer(
            @RequestHeader UUID matchId,
            @RequestBody SignInPlayerInputDTO player
    ) {
        log.debug("[CONTROLLER][SIGN_IN_PLAYER_MATCH] matchId={} player={}", matchId, player);

        return ResponseEntity.ok(matchService.joinPlayerInMatch(player, matchId));
    }
}
