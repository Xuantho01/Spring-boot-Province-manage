package com.province.demo.servicies;

import com.province.demo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book save(Book book);

    void remove(Long id);

}
