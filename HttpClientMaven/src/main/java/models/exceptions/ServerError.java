package models.exceptions;

public class ServerError extends Exception {
    private int code;
    private String message = null;
    public ServerError(int code) {
        super("Code: " + String.valueOf(code));
    }
    public ServerError(int code, String message) {
        super("Code: " + String.valueOf(code) + " Message: " + message);
    }
}
