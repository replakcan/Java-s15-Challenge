package service;

import dto.BorrowDetail;
import entity.book.Book;
import entity.book.BookType;
import entity.book.Status;
import entity.user.Client;
import entity.user.Librarian;
import exception.LibrarianException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LibrarianServiceImpl implements LibrarianService{

    private Librarian librarian;

    public LibrarianServiceImpl(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public Book removeBook(Book book) {
        this.librarian.getLibrary().getBookList().remove(book);

        return book;
    }

    @Override
    public Book addBook(Book book) {
        Map<String, Book> bookList = this.librarian.getLibrary().getBookList();
        bookList.put(UUID.randomUUID().toString(), book);

        return book;
    }

    @Override
    public Book addBook(Long id, String title, String author, Double price, Integer edition, BookType bookType) {
        Book book = new Book(title, author, price, edition, bookType);
        book.setStatus(Status.AVAILABLE);

        Map<String, Book> bookList = this.librarian.getLibrary().getBookList();
        bookList.put(UUID.randomUUID().toString(), book);

        return book;
    }

    @Override
    public BorrowDetail invoice(Client client, Book book, Integer period) {
        if(book.getStatus() == Status.UNAVAILABLE) {
            throw new LibrarianException("Kitap baskasi tarafindan kiralanmis.");
        }

        book.setStatus(Status.UNAVAILABLE);

        BorrowDetail borrowDetail = new BorrowDetail(client.getFirstName() + " " + client.getLastName(), book.getId(), period, period * 5d, System.currentTimeMillis());

        String invoiceId = UUID.randomUUID().toString();
        this.librarian.getBorrowList().put(invoiceId, borrowDetail);

        client.rentBook(book);
        return borrowDetail;
    }

    @Override
    public Book removeBookById(String bookId) {
        Map<String, Book> libraryBooks = this.librarian.getLibrary().getBookList();
        Book book = libraryBooks.get(bookId);
        if (book != null) {
            libraryBooks.remove(bookId);
            System.out.println(book.getTitle() + " sistemden silindi.");
            return book;
        }
        throw new LibrarianException("Couldn't find any book with given id");
    }

    @Override
    public void displayBookList() {
        List<Book> libraryBookList = this.librarian.getLibrary().getBookList().values().stream().toList();
        int range = libraryBookList.size();
        System.out.println("LIBRARY_BOOK_LIST:\n------------------------------------------------------------------------");
        for (int i = 0; i < range; i++) {
            System.out.println(libraryBookList.get(i));
        }
        System.out.println("------------------------------------------------------------------------");
    }

    @Override
    public void displayBorrowList() {
        Map<String, BorrowDetail> libraryBorrowList = this.librarian.getBorrowList();
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
        this.librarian.getLibrary().setRegister(this.librarian.getLibrary().getRegister() - book.getPrice());

        List<BorrowDetail> borrowDetails = this.librarian.getBorrowList().values().stream().toList();
        Iterator<BorrowDetail> iterator = borrowDetails.iterator();
        while(iterator.hasNext()) {
            BorrowDetail borrowDetail = iterator.next();
            if (borrowDetail.clientName().equals(client.getFirstName() + client.getLastName())) {
                this.librarian.getBorrowList().remove(borrowDetail);
            }
        }

        return book;
    }
}
