package exception;

public class GlobalExceptionHandler {

    public ClientExceptionResponse clientExceptionHandler(ClientException clientException) {
        ClientExceptionResponse clientExceptionResponse = new ClientExceptionResponse(clientException.getMessage(), System.currentTimeMillis());

        return clientExceptionResponse;
    }

    public LibrarianExceptionResponse clientExceptionHandler(LibrarianException librarianException) {
        LibrarianExceptionResponse librarianExceptionResponse = new LibrarianExceptionResponse(librarianException.getMessage(), System.currentTimeMillis());

        return librarianExceptionResponse;
    }

    public LibrarianExceptionResponse globalExceptionHandler(Exception exception) {
        LibrarianExceptionResponse librarianExceptionResponse = new LibrarianExceptionResponse(exception.getMessage(), System.currentTimeMillis());

        return librarianExceptionResponse;
    }
}
