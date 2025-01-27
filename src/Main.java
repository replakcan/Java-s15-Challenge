import entity.*;
import entity.book.Book;
import entity.book.BookType;
import entity.user.Client;
import entity.user.Librarian;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Client client = new Client("Alper", "Akcan", 28, new Address("Visnelik", "Odunpazari", 26123), new ArrayList<>());

        Librarian librarian = new Librarian("Rustem", "Abi", 54, new Address("Beypazari", "Mecidiye", 25352), new Library(new ArrayList<>(), new Address("kutuphane", "hanekutup", 1234)), new HashMap<>());

        librarian.addBook(2L, "Sadece Şeyma", "Şeyma Subaşı", 0D, 1, BookType.MAGAZINE);

        System.out.println(librarian.getLibrary().getBookList());

        Book book = new Book(3L, "abc", "selami", 12d, 2, BookType.MAGAZINE);

        BorrowDetail newBorrow =  librarian.invoice(client, book, 5);

        BorrowDetail newNewBorrow =  librarian.invoice(client, book, 5);

        System.out.println(librarian.getBorrowList());
        System.out.println(client.getBooks());
    }
}