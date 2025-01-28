package userInterfaces;

import entity.BorrowDetail;
import entity.book.Book;
import entity.book.BookType;
import entity.user.Client;

public interface Manageable {

    Book removeBook(Book book);
    Book addBook(Book book);
    Book addBook(Long id, String title, String author, Double price, Integer edition, BookType bookType);
    BorrowDetail invoice(Client client, Book book, Integer period);
    Book removeBookById(String bookId);
    void displayBookList();
    void displayBorrowList();
    Book takeBackBook(Client client, Book book);
}
