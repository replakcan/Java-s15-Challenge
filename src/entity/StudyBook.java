package entity;

public class StudyBook extends Book{

    public StudyBook(Long id, String title, String author, Double price, Status status, Integer edition) {
        super(id, title, author, price, status, edition);
    }
}
