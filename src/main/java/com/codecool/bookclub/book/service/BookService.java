package com.codecool.bookclub.book.service;

import com.codecool.bookclub.book.model.Book;

import java.util.List;

public interface BookService {

    Book getById(Long id);// todo Optional<Book>
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByTitle(String title);

    List<Book> findTopFourBooks();

    List<Book> searchBooks(String query);
}
