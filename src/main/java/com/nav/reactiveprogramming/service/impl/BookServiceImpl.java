package com.nav.reactiveprogramming.service.impl;

import com.nav.reactiveprogramming.entity.Book;
import com.nav.reactiveprogramming.repository.BookRepository;
import com.nav.reactiveprogramming.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> getById(Integer bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Book> updateById(Book book, Integer bookId) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(b1 -> {
            b1.setName(book.getName());
            b1.setDescription(book.getDescription());
            b1.setPublisher(book.getPublisher());
            b1.setAuthor(book.getAuthor());
            return bookRepository.save(b1); 
        });
    }

    @Override
    public Mono<Void> deleteById(Integer bookId) {
        return bookRepository.deleteById(bookId);
    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }

    @Override
    public Mono<Book> save(Book book) {
       return  bookRepository.save(book);
    }
}
