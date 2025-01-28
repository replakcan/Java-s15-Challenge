package entity.user;

import entity.*;
import entity.book.Book;
import entity.book.BookType;
import entity.book.Status;
import userInterfaces.Manageable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Librarian extends User implements Manageable {

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
    public Book removeBook(Book book) {
        this.library.getBookList().remove(book);

        return book;
    }

    @Override
    public Book addBook(Book book) {
        Map<String, Book> bookList = this.library.getBookList();
        bookList.put(UUID.randomUUID().toString(), book);

        return book;
    }

    @Override
    public Book addBook(Long id, String title, String author, Double price, Integer edition, BookType bookType) {
        Book book = new Book(title, author, price, edition, bookType);
        book.setStatus(Status.AVAILABLE);

        Map<String, Book> bookList = this.library.getBookList();
        bookList.put(UUID.randomUUID().toString(), book);

        return book;
    }

    @Override
    public BorrowDetail invoice(Client client, Book book, Integer period) {
        if(book.getStatus() == Status.UNAVAILABLE) {
            throw new RuntimeException("Kitap baskasi tarafindan kiralanmis.");
        }

        book.setStatus(Status.UNAVAILABLE);

        BorrowDetail borrowDetail = new BorrowDetail(client.getFirstName() + " " + client.getLastName(), book.getId(), period, period * 5d, System.currentTimeMillis());

        String invoiceId = UUID.randomUUID().toString();
        this.borrowList.put(invoiceId, borrowDetail);

        client.rentBook(book);
        return borrowDetail;
    }

    @Override
    public Book removeBookById(String bookId) {
        Map<String, Book> libraryBooks = this.getLibrary().getBookList();
        Book book = libraryBooks.get(bookId);
        if (book != null) {
            libraryBooks.remove(bookId);
            System.out.println(book.getTitle() + " sistemden silindi.");
            return book;
        }
        throw new RuntimeException("couldn't find a book with given id");
    }

    @Override
    public void displayBookList() {
        List<Book> libraryBookList = this.library.getBookList().values().stream().toList();
        int range = libraryBookList.size();
        System.out.println("LIBRARY_BOOK_LIST:\n------------------------------------------------------------------------");
        for (int i = 0; i < range; i++) {
            System.out.println(libraryBookList.get(i));
        }
        System.out.println("------------------------------------------------------------------------");
    }

    @Override
    public void displayBorrowList() {
        Map<String, BorrowDetail> libraryBorrowList = this.getBorrowList();
        int range = libraryBorrowList.size();
        System.out.println("LIBRARY_BORROW_LIST:\n------------------------------------------------------------------------");
        for (String key : libraryBorrowList.keySet()) {
            System.out.println(libraryBorrowList.get(key));
        }
        System.out.println("------------------------------------------------------------------------");
    }

    @Override
    public Book takeBackBook(Client client, Book book) {
        book.setStatus(Status.AVAILABLE);
        this.library.setRegister(this.library.getRegister() - book.getPrice());

        List<BorrowDetail> borrowDetails = this.borrowList.values().stream().toList();
        Iterator<BorrowDetail> iterator = borrowDetails.iterator();
        while(iterator.hasNext()) {
            BorrowDetail borrowDetail = iterator.next();
            if (borrowDetail.clientName().equals(client.getFirstName() + client.getLastName())) {
                this.borrowList.remove(borrowDetail);
            }
        }

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
