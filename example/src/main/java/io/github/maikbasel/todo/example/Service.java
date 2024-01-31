package io.github.maikbasel.todo.example;

import io.github.maikbasel.todo.Dev;
import io.github.maikbasel.todo.Todo;

public class Service {

    @Todo
    public void process1() {
    }

    public void process2() {
        Dev.todo();
    }
}
