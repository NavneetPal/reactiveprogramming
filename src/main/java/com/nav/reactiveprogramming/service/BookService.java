package com.nav.reactiveprogramming.service;

import com.nav.reactiveprogramming.entity.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    public Flux<Book> getAll();
    public Mono<Book> getById(Integer bookId);
    public Mono<Book> updateById(Book book, Integer bookId);
    public Mono<Void> deleteById(Integer bookId);
    public Flux<Book> search(String query);
    public Mono<Book> save(Book book);
}
