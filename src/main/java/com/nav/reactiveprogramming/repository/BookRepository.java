package com.nav.reactiveprogramming.repository;

import com.nav.reactiveprogramming.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
}
