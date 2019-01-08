package br.com.shelf.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Author(String name) {
        this.name = name;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    private void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
