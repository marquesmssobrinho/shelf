package br.com.shelf.services;

import br.com.shelf.models.Author;
import br.com.shelf.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final BookService bookService;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, @Lazy BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro"));
    }

    public Author update(Long id, Author author) {
        Author authorDb = findById(id);
        authorDb.update(author);

        return save(authorDb);
    }

    public void delete(Long id) {

        Author authorDb = findById(id);

        bookService.deleteAuthorFromBook(authorDb);

        authorRepository.delete(authorDb);
    }

}
