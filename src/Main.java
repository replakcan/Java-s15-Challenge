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

        Librarian kutuphaneciRustemAbi = new Librarian("Rustem", "Abi", 54, new Address("Beypazari", "Mecidiye", 25352), new Library(new HashMap<>(), new Address("kutuphane", "hanekutup", 1234)), new HashMap<>());

        Library davutPasha = kutuphaneciRustemAbi.getLibrary();

        Book book_0 =new Book ("Sadece Şeyma", "Şeyma Subaşı", 0D, 1, BookType.NOVEL);
        Book book_1 = new Book("Bad Little Kid", "Stephen King", 32d, 2, BookType.NOVEL);
        Book book_2 = new Book("The Aftermath", "Stephen King", 94d, 2, BookType.NOVEL);
        Book book_3 = new Book("IT", "Stephen King", 39.4d, 2, BookType.NOVEL);
        Book book_4 = new Book("Bag of Bones", "selami", 58d, 2, BookType.NOVEL);
        Book book_5 = new Book("Bilim ve Teknik", "TUBITAK", 12d, 2, BookType.MAGAZINE);
        Book book_6 = new Book("National Geographic", "White House", 12d, 2, BookType.MAGAZINE);
        Book book_7 = new Book("Adım Adım Matematik", "KitapeviYayinlari", 12d, 2, BookType.STUDY_BOOK);


        kutuphaneciRustemAbi.addBook(book_0);
        kutuphaneciRustemAbi.addBook(book_1);
        kutuphaneciRustemAbi.addBook(book_2);
        kutuphaneciRustemAbi.addBook(book_3);
        kutuphaneciRustemAbi.addBook(book_4);
        kutuphaneciRustemAbi.addBook(book_5);
        kutuphaneciRustemAbi.addBook(book_6);
        kutuphaneciRustemAbi.addBook(book_7);

        kutuphaneciRustemAbi.invoice(client, book_2, 5);
        kutuphaneciRustemAbi.invoice(client, book_5, 12);


        kutuphaneciRustemAbi.displayBookList();
        kutuphaneciRustemAbi.displayBorrowList();

        /*client.searchBookByTitle(davutPasha, "Sadece Şeyma");
        client.searchBookByAuthor(davutPasha, "Stephen King");*/
        client.sortBooksByPrice(davutPasha);
        client.sortBooksByTitle(davutPasha);
        client.searchBooksByCategory(davutPasha, BookType.NOVEL);
    }
}