package com.kalffman.projects.game21.domain.repository;

import com.kalffman.projects.game21.domain.model.Table;

import java.util.UUID;

public interface TableRepository {

    Table retrieveTable(UUID tableId);
}
