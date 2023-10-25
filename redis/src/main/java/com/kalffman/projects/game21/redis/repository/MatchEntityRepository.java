package com.kalffman.projects.game21.redis.repository;

import com.kalffman.projects.game21.redis.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MatchEntityRepository extends CrudRepository<MatchEntity, String> {
}
