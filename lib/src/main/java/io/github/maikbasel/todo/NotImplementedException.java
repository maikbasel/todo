package io.github.maikbasel.todo;

/**
 * The {@code NotImplementedException} class is an exception that can be thrown to indicate that a certain functionality is not yet implemented.
 * It extends the {@code RuntimeException} class, making it an unchecked exception.
 *
 * <p>Usage example:
 * <pre>
 *     throw new NotImplementedException();
 * </pre>
 *
 * <p>The {@code NotImplementedException} class provides two constructors:
 * <ul>
 *     <li>{@code NotImplementedException()} - Constructs a new {@code NotImplementedException} with the default message "Not implemented yet."</li>
 *     <li>{@code NotImplementedException(String message)} - Constructs a new {@code NotImplementedException} with the specified message.</li>
 * </ul>
 *
 * <p>When an instance of the {@code NotImplementedException} class is thrown, it will contain the provided message or the default message.
 * The message can be accessed using the {@code getMessage()} method inherited from the {@code Throwable} class.
 */
public class NotImplementedException extends RuntimeException {

    public NotImplementedException() {
        super("Not implemented yet.");
    }

    public NotImplementedException(String message) {
        super(message);
    }
}
