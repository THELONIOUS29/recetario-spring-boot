package net.osgg.crudthymeleaf.service;

public class FileStorageException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructor con mensaje
    public FileStorageException(String message) {
        super(message);
    }

    // Constructor con mensaje y causa (Throwable)
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
