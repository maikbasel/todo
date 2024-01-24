package io.github.maikbasel.todo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TodoAspectTest {

    @Test
    void should_throw_not_implemented_exception() {
        var dummyService = new DummyService();

        assertThatThrownBy(dummyService::dummy1)
                .isInstanceOf(NotImplementedException.class)
                .hasMessage("Not implemented yet.");
    }

    @Test
    void should_throw_not_implemented_exception_with_provided_message() {
        var dummyService = new DummyService();

        assertThatThrownBy(dummyService::dummy2)
                .isInstanceOf(NotImplementedException.class)
                .hasMessage("Cool message.");
    }
}