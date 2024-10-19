package com.nav.reactiveprogramming.controller;


import com.nav.reactiveprogramming.entity.Book;
import com.nav.reactiveprogramming.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Mono<Book> createBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public Flux<Book> getall(){
        return bookService.getAll();
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getBook(@PathVariable Integer bookId){
        return bookService.getById(bookId);
    }

    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@RequestBody Book book,@PathVariable Integer bookId){
        return bookService.updateById(book,bookId);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> updateBook(@PathVariable Integer bookId){
        return bookService.deleteById(bookId);
    }
}
