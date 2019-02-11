package br.com.shelf.repositories;

import br.com.shelf.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT b from Book b JOIN b.authors a ON a.id = ?1")
    List<Book> findByAuthorId(Long authorId);
}
