package entity;

import java.util.List;

public class Client extends User {

    private List<Book> books;

    public Client(String firstName, String lastName, Integer age, Address address, List<Book> books) {
        super(firstName, lastName, age, address, Role.CLIENT);
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book rentBook(Book book) {
        this.books.add(book);

        return book;
    }
}
