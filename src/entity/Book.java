package entity;

import java.util.Date;

public class Book {

    private Long id;
    private String title;
    private String author;
    private Double price;
    private Status status;
    private Integer edition;

    public Book(Long id, String title, String author, Double price, Status status, Integer edition) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.status = status;
        this.edition = edition;
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
}
