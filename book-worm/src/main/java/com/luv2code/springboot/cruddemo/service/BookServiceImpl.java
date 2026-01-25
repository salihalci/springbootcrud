package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.BookRepository;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }
    @Override
    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook= result.get();
        }else{
            throw new RuntimeException("Did not find book id - " + theId);
        }
        return theBook;
    }

    @Override
    public Book saveBook(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}
