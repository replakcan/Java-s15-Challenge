package entity;

import entity.book.Book;

import java.util.Map;

public class Library {

    private Map<String, Book> bookList;
    private Address address;
    private Double register;

    public void setRegister(Double register) {
        this.register = register;
    }

    public Double getRegister() {
        return register;
    }

    public Library(Map<String, Book> bookList, Address address) {
        this.bookList = bookList;
        this.address = address;
        this.register = 1000000.0;
    }

    public Map<String, Book> getBookList() {
        return this.bookList;
    }

    public void setBookList(Map<String, Book> bookList) {
        this.bookList = bookList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", address=" + address +
                '}';
    }
}
