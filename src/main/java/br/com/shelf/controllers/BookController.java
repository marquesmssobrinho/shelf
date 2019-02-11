package br.com.shelf.controllers;

import br.com.shelf.models.Book;
import br.com.shelf.requests.BookRequest;
import br.com.shelf.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) { this.bookService = bookService; }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookRequest bookRequest) {

        return new ResponseEntity<>(bookService.save(bookRequest), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody BookRequest bookRequest) {

        return new ResponseEntity<>(bookService.update(id, bookRequest), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        bookService.delete(id);
    }


}
