package entity.user;

import entity.*;
import dto.BorrowDetail;

import java.util.Map;

public class Librarian extends User{

    private Library library;
    private Map<String, BorrowDetail> borrowList;

    public Librarian(String firstName, String lastName, Integer age, Address address, Library library, Map<String, BorrowDetail> borrowList) {
        super(firstName, lastName, age, address, Role.LIBRARIAN);
        this.library = library;
        this.borrowList = borrowList;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Map<String , BorrowDetail> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(Map<String , BorrowDetail> borrowList) {
        this.borrowList = borrowList;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", age=" + this.getAge() +
                ", address=" + this.getAddress() +
                ", role=" + this.getRole() +
                ", library=" + this.getLibrary() +
                '}';
    }
}
