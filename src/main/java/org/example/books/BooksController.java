package org.example.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> getAll() {
        return booksService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            Books foundBook = booksService.findById(id);
            return new ResponseEntity<>(foundBook, HttpStatus.OK);
        } catch (BooksException ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Ошибка", ex.getMessage(),
                            "jwtError", "Добавьте jwt токен пожалуйста"
                    ));
        }
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Books book) {
        try {
            Books savedBook = booksService.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (BooksException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Такого автора не существует", "Book", book));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Books book) {
        try {
            book.setBookId(id);
            booksService.save(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (BooksException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Такого автора не существует", "Book", book));
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable Integer id, @RequestBody Books book) {
        try {
            booksService.patch(id, book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (BooksException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Такого автора не существует", "Book", book));
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        booksService.delete(id);
    }
}
