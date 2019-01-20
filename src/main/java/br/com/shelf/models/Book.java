package br.com.shelf.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String isbn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Book(String title, String description, String isbn) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public Book(){}

    public void update(Book book) {
        this.title = book.getTitle();
        this.description = book.getDescription();
        this.isbn = book.getIsbn();
    }


    @PreUpdate
    private void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
