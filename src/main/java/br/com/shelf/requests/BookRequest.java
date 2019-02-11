package br.com.shelf.requests;

import java.util.List;

public class BookRequest {

    private String title;

    private String description;

    private String isbn;

    private List<Long> authorsId;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Long> getAuthorsId() {
        return authorsId;
    }
}
