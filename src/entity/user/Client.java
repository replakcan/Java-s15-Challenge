package entity.user;

import entity.Address;
import entity.book.Book;

import java.util.*;

public class Client extends User {

    private List<Book> books;
    private Double wallet;

    public Client(String firstName, String lastName, Integer age, Address address, List<Book> books) {
        super(firstName, lastName, age, address, Role.CLIENT);
        this.books = books;
        this.wallet = 5000d;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book rentBook(Book book) {
        this.getBooks().add(book);
        this.setWallet(this.getWallet() - book.getPrice());
        return book;
    }

}
