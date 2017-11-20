package de.jochenchrist.acceptance.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> {
    List<Task> findAllByOwnerAndCompleted(String owner, boolean completed);
}
