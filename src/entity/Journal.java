package entity;

public class Journal extends Book{

    public Journal(Long id, String title, String author, Double price, Status status, Integer edition) {
        super(id, title, author, price, status, edition);
    }
}
