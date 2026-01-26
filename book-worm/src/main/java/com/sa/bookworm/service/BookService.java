package com.sa.bookworm.service;

import com.sa.bookworm.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    Book saveBook(Book theBook);

    void deleteById(int theId);
}
