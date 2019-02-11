package br.com.shelf.services;

import br.com.shelf.models.Author;
import br.com.shelf.models.Book;
import br.com.shelf.repositories.BookRepository;
import br.com.shelf.requests.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book save(BookRequest bookRequest) {

        List<Author> authors = findAuthors(bookRequest.getAuthorsId());

        Book book = createBook(bookRequest, authors);

        return bookRepository.save(book);
    }

    private Book createBook(BookRequest bookRequest, List<Author> authors) {
        return new Book(bookRequest.getTitle(), bookRequest.getDescription(), bookRequest.getIsbn(), authors);
    }

    private List<Author> findAuthors(List<Long> authorsId) {
        return authorsId.stream()
                .map(authorService::findById)
                .collect(Collectors.toList());
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
    }

    public Book update(Long id, BookRequest bookRequest) {
        Book bookDb = findById(id);
        List<Author> authors = findAuthors(bookRequest.getAuthorsId());
        bookDb.update(createBook(bookRequest, authors));

        return bookRepository.save(bookDb);
    }

    public void delete(Long id) {
        Book bookDb = findById(id);

        bookRepository.delete(bookDb);
    }

    void deleteAuthorFromBook(Author author) {

        List<Book> books = bookRepository.findByAuthorId(author.getId());

        books.forEach(book -> book.getAuthors().remove(author));

        books.forEach(book -> {
            if (book.getAuthors().isEmpty()) {
                bookRepository.delete(book);
            } else {
                bookRepository.save(book);
            }
        });
    }
}
