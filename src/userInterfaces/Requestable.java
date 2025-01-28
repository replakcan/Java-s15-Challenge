package userInterfaces;

import entity.Library;
import entity.book.Book;
import entity.book.BookType;
import entity.user.Librarian;

import java.util.List;
import java.util.Set;

public interface Requestable {

    Book rentBook(Book book);
    Book returnBook(Librarian librarian, String  bookId);
    List<Book> findAllBooks(Library library);
    Book searchBookByTitle(Library library, String title);
    List<Book> searchBookByAuthor(Library library, String author);
    List<Book> sortBooksByPrice(Library library);
    List<Book> sortBooksByTitle(Library library);
    List<Book> searchBooksByCategory(Library library, BookType bookType);
}
