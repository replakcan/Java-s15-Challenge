package entity;

import java.util.List;

public class Library {

    private List<Book> bookList;
    private Address address;

    public Library(List<Book> bookList, Address address) {
        this.bookList = bookList;
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
