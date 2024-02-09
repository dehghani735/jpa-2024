package org.example.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "booksList")
    private List<Author> authorList; // authors

    @ManyToMany(mappedBy = "booksList")
    private List<BookShop> bookShopList; // books

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<BookShop> getBookShopList() {
        return bookShopList;
    }

    public void setBookShopList(List<BookShop> bookShopList) {
        this.bookShopList = bookShopList;
    }

    @Override
    public String toString() {
        return "Book{" +
               "id=" + id +
               '}';
    }
}
