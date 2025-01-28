package entity.book;

public class StudyBook extends Book {

    public StudyBook(String title, String author, Double price, Integer edition) {
        super(title, author, price, edition, BookType.STUDY_BOOK);
    }
}
