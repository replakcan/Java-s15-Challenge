package entity.book;

public class Journal extends Book {

    public Journal(String title, String author, Double price, Integer edition) {
        super(title, author, price, edition, BookType.JOURNAL);
    }
}
