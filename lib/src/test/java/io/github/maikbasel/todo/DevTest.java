package io.github.maikbasel.todo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DevTest {

    @Test
    void should_throw_not_implemented_exception() {
        assertThatThrownBy(Dev::todo)
                .isInstanceOf(NotImplementedException.class)
                .hasMessage("Not implemented yet.");
    }

    @Test
    void should_throw_not_implemented_exception_with_provided_message() {
        assertThatThrownBy(() -> Dev.todo("Cool message."))
                .isInstanceOf(NotImplementedException.class)
                .hasMessage("Cool message.");
    }
}
