package entity.book;

public class Magazine extends Book {

    public Magazine(String title, String author, Double price, Integer edition) {
        super(title, author, price, edition, BookType.MAGAZINE);
    }
}
