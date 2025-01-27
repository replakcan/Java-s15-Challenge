package entity.book;

public class Book {

    private Long id;
    private String title;
    private String author;
    private Double price;
    private Status status;
    private Integer edition;
    private BookType bookType;

    public Book(Long id, String title, String author, Double price, Integer edition, BookType bookType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.bookType = bookType;
        this.status = Status.AVAILABLE;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", bookType=" + bookType +
                '}';
    }
}
