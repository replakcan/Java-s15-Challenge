package entity.book;

public class StudyBook extends Book {

    public StudyBook(Long id, String title, String author, Double price, Integer edition) {
        super(id, title, author, price, edition, BookType.STUDY_BOOK);
    }
}
