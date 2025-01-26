package entity;

public class Librarian extends Person {

    private Library library;

    public Librarian(String firstName, String lastName, Integer age, Address address, Library library) {
        super(firstName, lastName, age, address, Role.LIBRARIAN);
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
