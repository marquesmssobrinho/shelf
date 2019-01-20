package br.com.shelf.services;

import br.com.shelf.models.Book;
import br.com.shelf.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
    }

    public Book update(Long id, Book book) {
        Book bookDb = findById(id);
        bookDb.update(book);

        return save(bookDb);
    }

    public void delete(Long id) {
        Book bookDb = findById(id);

        bookRepository.delete(bookDb);
    }
}
