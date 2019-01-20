package br.com.shelf.controllers;

import br.com.shelf.models.Author;
import br.com.shelf.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authors")
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author) {

        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {

        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author) {

        return new ResponseEntity<>(authorService.update(id, author), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

        authorService.delete(id);
    }
}
