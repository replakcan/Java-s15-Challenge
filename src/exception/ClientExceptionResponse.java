package exception;

public class ClientExceptionResponse {
    private String message;
    private Long timestamp;

    public ClientExceptionResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
