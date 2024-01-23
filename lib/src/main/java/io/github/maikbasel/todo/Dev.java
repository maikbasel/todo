package io.github.maikbasel.todo;

import io.github.maikbasel.todo.internal.NotImplementedException;

/**
 * The Dev class provides methods for marking a method as a placeholder for future implementation.
 * When called, the marked method will throw a {@link NotImplementedException}.
 * Use the methods in this class to indicate that a certain functionality is not yet implemented.
 */
public final class Dev {

    private Dev() {
    }

    /**
     * Marks a method as a placeholder for future implementation. When called, it will throw a {@link NotImplementedException}.
     * Use this method to indicate that a certain functionality is not yet implemented.
     *
     * @throws NotImplementedException when the method is called
     */
    public static void todo() {
        throw new NotImplementedException();
    }

    /**
     * Marks a method as a placeholder for future implementation.
     * When called, it will throw a {@link NotImplementedException}.
     * Use this method to indicate that a certain functionality is not yet implemented.
     *
     * @param message to be included in the {@link NotImplementedException} when the method is called.
     * @throws NotImplementedException when the method is called
     */
    public static void todo(String message) {
        throw new NotImplementedException(message);
    }
}
