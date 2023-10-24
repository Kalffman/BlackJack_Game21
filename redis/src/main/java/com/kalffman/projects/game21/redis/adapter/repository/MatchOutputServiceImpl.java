package com.kalffman.projects.game21.redis.adapter.repository;

import com.kalffman.projects.game21.output.MatchOutputService;
import com.kalffman.projects.game21.output.dto.MatchOutputDTO;
import com.kalffman.projects.game21.redis.repository.MatchEntityRepository;
import com.kalffman.projects.game21.redis.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public class MatchOutputServiceImpl implements MatchOutputService {

    private final MatchEntityRepository entityRepository;

    public MatchOutputServiceImpl(MatchEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public MatchOutputDTO retrieveMatch(UUID matchId) {
        log.info("[REPOSITORY_USE_CASE][RETRIEVE_MATCH] status=started matchId={}", matchId);

        var entity = entityRepository.findById(matchId);

        if (entity.isPresent()) {
            log.info("[REPOSITORY_USE_CASE][RETRIEVE_MATCH] status=finished matchId={}", matchId);

            return MapperUtil.toMatchOutputDTO(entity.get());
        } else {
            log.error("[REPOSITORY_USE_CASE][RETRIEVE_MATCH] status=error matchId={}", matchId);

            return null;
        }

    }

    @Override
    public MatchOutputDTO persistMatch(MatchOutputDTO match) {
        log.info("[REPOSITORY_USE_CASE][PERSIST_MATCH] status=started");

        var entity = MapperUtil.toMatchEntity(match);

        log.info("[REPOSITORY_USE_CASE][PERSIST_MATCH] status=finished");
        return MapperUtil.toMatchOutputDTO(entityRepository.save(entity));
    }

}
