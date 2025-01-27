package entity.user;

import entity.*;
import entity.book.Book;
import entity.book.BookType;
import entity.book.Status;

import java.util.List;
import java.util.Map;

// TODO [Alper] update removeBook method
public class Librarian extends User {

    private Library library;
    private Map<Integer, BorrowDetail> borrowList;

    private static int borrowListId;

    public Librarian(String firstName, String lastName, Integer age, Address address, Library library, Map<Integer, BorrowDetail> borrowList) {
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

    public Map<Integer, BorrowDetail> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(Map<Integer, BorrowDetail> borrowList) {
        this.borrowList = borrowList;
    }

    public Book addBook(Long id, String title, String author, Double price, Integer edition, BookType bookType) {
        Book newBook = new Book(id, title, author, price, edition, bookType);
        newBook.setStatus(Status.AVAILABLE);

        List<Book> bookList = this.library.getBookList();
        bookList.add(newBook);

        return newBook;
    }

    public BorrowDetail invoice(Client client, Book book, Integer period) {
        if(book.getStatus() == Status.UNAVAILABLE) {
            System.out.println("Kitap su an kullanim disi");
            return null;
        }

        book.setStatus(Status.UNAVAILABLE);

        BorrowDetail borrowDetail = new BorrowDetail(client.getFirstName() + " " + client.getLastName(), book.getId(), period, period * 5d, System.currentTimeMillis());

        int invoiceId = borrowListId++;
        this.borrowList.put(invoiceId, borrowDetail);

        client.rentBook(book);

        return borrowDetail;
    }

    public Book removeBook(Book book) {
        List<Book> bookList = this.library.getBookList();
        bookList.remove(book);

        return book;
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
