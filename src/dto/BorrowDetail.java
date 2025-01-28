package dto;

public record BorrowDetail(String clientName, String bookId, Integer daysRentedFor, Double price, Long timestamp) {
    @Override
    public String clientName() {
        return clientName;
    }

    @Override
    public String bookId() {
        return bookId;
    }

    @Override
    public Integer daysRentedFor() {
        return daysRentedFor;
    }

    @Override
    public Double price() {
        return price;
    }

    @Override
    public Long timestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "BorrowDetail{" +
                "clientName='" + clientName + '\'' +
                ", bookId='" + bookId + '\'' +
                ", daysRentedFor=" + daysRentedFor +
                ", price=" + price +
                ", timestamp=" + timestamp +
                '}';
    }
}
