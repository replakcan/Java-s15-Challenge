package entity;

public record BorrowDetail(String clientName, Long bookId, Integer daysRentedFor, Double price, Long timestamp) {
}
