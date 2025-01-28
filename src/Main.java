import entity.*;
import entity.book.Book;
import entity.book.BookType;
import entity.user.Client;
import entity.user.Librarian;
import service.ClientService;
import service.ClientServiceImpl;
import service.LibrarianService;
import service.LibrarianServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Client alper = new Client("Alper", "Akcan", 28, new Address("Visnelik", "Odunpazari", 26123), new ArrayList<>());
        Librarian rustem = new Librarian("Rustem", "Abi", 54, new Address("Beypazari", "Mecidiye", 25352), new Library(new HashMap<>(), new Address("kutuphane", "hanekutup", 1234)), new HashMap<>());
        Library davutPasha = rustem.getLibrary();

        LibrarianService librarianService = new LibrarianServiceImpl(rustem);
        ClientService clientService = new ClientServiceImpl(alper, librarianService);

        Book book_0 =new Book ("Sadece Şeyma", "Şeyma Subaşı", 0D, 1, BookType.NOVEL);
        Book book_1 = new Book("Bad Little Kid", "Stephen King", 32d, 2, BookType.NOVEL);
        Book book_2 = new Book("The Aftermath", "Stephen King", 94d, 2, BookType.NOVEL);
        Book book_3 = new Book("IT", "Stephen King", 39.4d, 2, BookType.NOVEL);
        Book book_4 = new Book("Bag of Bones", "selami", 58d, 2, BookType.NOVEL);
        Book book_5 = new Book("Bilim ve Teknik", "TUBITAK", 12d, 2, BookType.MAGAZINE);
        Book book_6 = new Book("National Geographic", "White House", 12d, 2, BookType.MAGAZINE);
        Book book_7 = new Book("Adım Adım Matematik", "KitapeviYayinlari", 12d, 2, BookType.STUDY_BOOK);

        librarianService.addBook(book_0);
        librarianService.addBook(book_1);
        librarianService.addBook(book_2);
        librarianService.addBook(book_3);
        librarianService.addBook(book_4);
        librarianService.addBook(book_5);
        librarianService.addBook(book_6);
        librarianService.addBook(book_7);

        // librarian operations
        librarianService.invoice(alper, book_2, 5);
        librarianService.invoice(alper, book_5, 12);
        librarianService.removeBookById(book_7.getId());
        librarianService.displayBookList();
        librarianService.displayBorrowList();
        librarianService.takeBackBook(alper, book_2);
        librarianService.displayBookList();

        //client operations
        clientService.addCredit(244d);
        clientService.findAllBooks(davutPasha);
        clientService.searchBookByTitle(davutPasha, "Sadece Şeyma");
        clientService.searchBookByAuthor(davutPasha, "Stephen King");
        clientService.sortBooksByPrice(davutPasha);
        clientService.sortBooksByPriceDesc(davutPasha);
        clientService.sortBooksByTitle(davutPasha);
        clientService.searchBooksByCategory(davutPasha, BookType.MAGAZINE);


    }
}