package com.kalffman.projects.game21.redis.adapter.repository;

import com.kalffman.projects.game21.domain.exception.TableNotFoundException;
import com.kalffman.projects.game21.domain.model.Table;
import com.kalffman.projects.game21.domain.repository.TableRepository;
import com.kalffman.projects.game21.redis.repository.TableEntityRepository;
import com.kalffman.projects.game21.redis.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
@Slf4j
public class TableRepositoryImpl implements TableRepository {

    private final TableEntityRepository entityRepository;

    public TableRepositoryImpl(TableEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Table retrieveTable(UUID tableId) {
        log.info("[REPOSITORY_USE_CASE][RETRIEVE_TABLE] status=started tableId={}", tableId);

        var entity = entityRepository.findById(tableId);

        if (entity.isPresent()) {
            log.info("[REPOSITORY_USE_CASE][RETRIEVE_TABLE] status=finished tableId={}", tableId);

            return MapperUtil.toTable(entity.get());
        } else {
            log.error("[REPOSITORY_USE_CASE][RETRIEVE_TABLE] status=error tableId={}", tableId);

            throw new TableNotFoundException(tableId);
        }

    }

    @Override
    public Table persistTable(Table table) {
        log.info("[REPOSITORY_USE_CASE][PERSIST_TABLE] status=started");

        var entity = MapperUtil.toTableEntity(table);

        log.info("[REPOSITORY_USE_CASE][PERSIST_TABLE] status=finished");
        return MapperUtil.toTable(entityRepository.save(entity));
    }

}
