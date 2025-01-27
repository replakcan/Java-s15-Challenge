package entity;

public class Magazine extends Book{

    public Magazine(Long id, String title, String author, Double price, Integer edition) {
        super(id, title, author, price, edition, BookType.MAGAZINE);
    }
}
