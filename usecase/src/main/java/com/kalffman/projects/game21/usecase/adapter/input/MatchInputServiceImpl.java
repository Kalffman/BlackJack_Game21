package com.kalffman.projects.game21.usecase.adapter.input;

import com.kalffman.projects.game21.domain.exception.DomainException;
import com.kalffman.projects.game21.domain.service.MatchService;
import com.kalffman.projects.game21.input.MatchInputService;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.SignInPlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
import com.kalffman.projects.game21.input.exception.InputException;
import com.kalffman.projects.game21.usecase.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class MatchInputServiceImpl implements MatchInputService {

    private final MatchService domainService;

    public MatchInputServiceImpl(MatchService domainService) {
        this.domainService = domainService;
    }

    @Override
    public MatchInputDTO createDefaultMatch() {
        log.info("[INPUT_USE_CASE][CREATE_NEW_MATCH] status=started");

        var domainMatch = domainService.createDefaultMatch();

        log.info("[INPUT_USE_CASE][CREATE_NEW_MATCH] status=created matchId={}", domainMatch.getId());
        return MapperUtil.toMatchInputDTO(domainMatch);
    }

    @Override
    public MatchInputDTO retrieveMatch(UUID matchId) {
        log.info("[INPUT_USE_CASE][RETRIEVE_MATCH] status=started matchId={}", matchId);

        var domainMatch = domainService.retrieveMatch(matchId);

        if(domainMatch != null) {
            log.info("[INPUT_USE_CASE][RETRIEVE_MATCH] status=finished matchId={}", matchId);

            return MapperUtil.toMatchInputDTO(domainMatch);
        } else {
            log.warn("[INPUT_USE_CASE][RETRIEVE_MATCH] status=not_found matchId={}", matchId);

            return null;
        }
    }

    @Override
    public MatchInputDTO joinPlayerInMatch(PlayerInputDTO player, UUID matchId) {
        try {
            log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=started");

            var domainMatch = domainService.signInPlayer(MapperUtil.toPlayer(player), matchId);

            log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=finished");

            return MapperUtil.toMatchInputDTO(domainMatch);
        } catch (DomainException e) {
            log.error("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=error", e);

            throw new InputException(e.getCode(), e);
        }
    }
    @Override
    public MatchInputDTO joinPlayerInMatch(SignInPlayerInputDTO player, UUID matchId) {
        return joinPlayerInMatch(new PlayerInputDTO(player.name(), null, null, null), matchId);
    }
}
