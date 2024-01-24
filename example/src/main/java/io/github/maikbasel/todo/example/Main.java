package io.github.maikbasel.todo.example;

import io.github.maikbasel.todo.NotImplementedException;

public class Main {

    public static void main(String[] args) {
        var service = new Service();
        try {
            service.process();
        } catch (NotImplementedException e) {
            System.out.println("It works!");
        }
    }
}
