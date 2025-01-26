package entity;

import java.util.List;

public class Client extends Person{

    private List<Book> books;

    public Client(String firstName, String lastName, Integer age, Address address) {
        super(firstName, lastName, age, address, Role.CLIENT);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
