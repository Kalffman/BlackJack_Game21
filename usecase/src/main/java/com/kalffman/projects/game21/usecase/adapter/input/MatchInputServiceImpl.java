package com.kalffman.projects.game21.usecase.adapter.input;

import com.kalffman.projects.game21.domain.service.MatchService;
import com.kalffman.projects.game21.input.MatchInputService;
import com.kalffman.projects.game21.input.dto.PlayerInputDTO;
import com.kalffman.projects.game21.input.dto.MatchInputDTO;
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
    public MatchInputDTO createNewMatch() {
        log.info("[INPUT_USE_CASE][CREATE_NEW_MATCH] status=started");

        var domainMatch = domainService.createNewMatch();

        log.info("[INPUT_USE_CASE][CREATE_NEW_MATCH] status=finished");
        return MapperUtil.toMatchInputDTO(domainMatch);
    }

    @Override
    public MatchInputDTO joinPlayerInMatch(PlayerInputDTO player, UUID matchId) {
        log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=started");

        var domainMatch = domainService.signInPlayer(MapperUtil.toPlayer(player), matchId);

        log.info("[INPUT_USE_CASE][SIGN_IN_PLAYER] status=finished");

        return MapperUtil.toMatchInputDTO(domainMatch);
    }
}
