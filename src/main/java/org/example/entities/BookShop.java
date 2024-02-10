package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book_shops")
public class BookShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Book> booksList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return booksList;
    }

    public void setBookList(List<Book> bookList) {
        this.booksList = bookList;
    }
}
