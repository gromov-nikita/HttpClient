package models.exceptions;

public class ClientError extends Exception {
    private int code;
    private String message = null;
    public ClientError(int code) {
        super("Code: " + String.valueOf(code));
    }
    public ClientError(int code, String message) {
        super("Code: " + String.valueOf(code) + " Message: " + message);
    }
}
