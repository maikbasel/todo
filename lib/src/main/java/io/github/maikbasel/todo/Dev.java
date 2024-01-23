package io.github.maikbasel.todo;

import io.github.maikbasel.todo.internal.NotImplementedException;

public final class Dev {

    private Dev() {
    }

    public static void todo() {
        throw new NotImplementedException();
    }

    public static void todo(String message) {
        throw new NotImplementedException(message);
    }
}
