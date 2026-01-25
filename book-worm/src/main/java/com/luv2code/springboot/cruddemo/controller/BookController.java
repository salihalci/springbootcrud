package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        // Get books from database
        List<Book> books = bookService.findAll();

        // If database is empty, add sample books for demonstration
        if (books.isEmpty()) {
            books = getSampleBooks();
        }

        model.addAttribute("books", books);
        return "books/book-list";
    }

    // Sample books with thumbnail URLs
    private List<Book> getSampleBooks() {
        List<Book> sampleBooks = new ArrayList<>();

        sampleBooks.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald",
            "https://via.placeholder.com/80x120?text=Great+Gatsby"));

        sampleBooks.add(new Book(2, "To Kill a Mockingbird", "Harper Lee",
            "https://via.placeholder.com/80x120?text=Mockingbird"));

        sampleBooks.add(new Book(3, "1984", "George Orwell",
            "https://via.placeholder.com/80x120?text=1984"));

        sampleBooks.add(new Book(4, "Pride and Prejudice", "Jane Austen",
            "https://via.placeholder.com/80x120?text=Pride"));

        sampleBooks.add(new Book(5, "The Catcher in the Rye", "J.D. Salinger",
            "https://via.placeholder.com/80x120?text=Catcher"));

        sampleBooks.add(new Book(6, "Brave New World", "Aldous Huxley",
            "https://via.placeholder.com/80x120?text=Brave"));

        return sampleBooks;
    }

}
