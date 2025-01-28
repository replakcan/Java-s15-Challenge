package exception;

public class LibrarianExceptionResponse {
    private String message;
    private Long timestamp;

    public LibrarianExceptionResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
