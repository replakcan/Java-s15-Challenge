package service;

import entity.Library;
import entity.book.Book;
import entity.book.BookType;
import entity.user.Client;
import entity.user.Librarian;

import java.util.*;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private Client client;
    private LibrarianService librarianService;

    public ClientServiceImpl(Client client, LibrarianService librarianService) {
        this.client = client;
        this.librarianService = librarianService;
    }

    @Override
    public Book returnBook(Librarian librarian, String bookId) {
        Map<String, Book> libraryBookList = librarian.getLibrary().getBookList();
        Iterator<Book> iterator = this.client.getBooks().iterator();
        while(iterator.hasNext()) {
            Book book = iterator.next();
            if(book.getId().equals(bookId)) {
                this.client.getBooks().remove(book);
                libraryBookList.put(UUID.randomUUID().toString(), book);
                this.librarianService.takeBackBook(this.client, book);
                this.client.setWallet(this.client.getWallet() + book.getPrice());
                System.out.println("Kitap geri iade edildi");
                return book;
            }
        }
        throw new RuntimeException("There is no book with given id");
    }

    @Override
    public List<Book> findAllBooks(Library library) {
        return library.getBookList().values().stream().toList();
    }

    @Override
    public Book searchBookByTitle(Library library, String title) {
        List<Book> bookList = library.getBookList().values().stream().toList();

        for (Book book : bookList) {
            if (book.getTitle() == title) {
                System.out.println(book);
                return book;
            }
        }
        throw new RuntimeException("There is no book in the system with given title");
    }

    @Override
    public List<Book> searchBookByAuthor(Library library, String author) {
        List<Book> bookList = library.getBookList().values().stream().toList();
        List<Book> resultList = new ArrayList<>();

        Iterator<Book> iterator = bookList.iterator();
        while(iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getAuthor().equals(author)) {
                resultList.add(book);
            }
        }

        if (resultList.size() == 0) throw new RuntimeException("There are no books with provided author name");

        System.out.println(resultList);
        return resultList;
    }

    @Override
    public List<Book> sortBooksByPrice(Library library) {
        List<Book> bookList = library.getBookList().values().stream().toList();
        List<Book> sortedList = bookList.stream().sorted().toList();
        int range = sortedList.size();
        System.out.println("SORTED_BY_PRICE:\n------------------------------------------------------------------------");
        for (int i = 0; i < range; i++) {
            System.out.println(sortedList.get(i));
        }
        System.out.println("------------------------------------------------------------------------");

        return sortedList;
    }

    @Override
    public List<Book> sortBooksByTitle(Library library) {
        List<Book> bookList = library.getBookList().values().stream().toList();
        List<Book> sortedList = bookList.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toUnmodifiableList());
        Iterator<Book> iterator = sortedList.iterator();
        System.out.println("SORTED_BY_TITLE:\n------------------------------------------------------------------------");
        while(iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
        System.out.println("------------------------------------------------------------------------");

        return sortedList;
    }

    @Override
    public List<Book> searchBooksByCategory(Library library, BookType bookType) {
        List<Book> bookList = library.getBookList().values().stream().toList();
        List<Book> categoryList = new ArrayList<>();
        Iterator<Book> iterator = bookList.iterator();
        System.out.println("BOOKS_WITH_CATEGORY_" + bookType + ":\n------------------------------------------------------------------------");
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBookType().equals(bookType)) {
                categoryList.add(book);
                System.out.println(book);
            }
        }

        if (categoryList.size() == 0) throw new RuntimeException("There are no books with provided category");

        return categoryList;
    }
}
