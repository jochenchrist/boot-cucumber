package de.jochenchrist.acceptance.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "tasks")
public class Task {

    @Id
    private UUID id = UUID.randomUUID();

    @NotEmpty
    private String name;

    private boolean completed;

    private String owner;

    public Task() {
    }

    public Task(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
