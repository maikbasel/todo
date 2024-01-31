package io.github.maikbasel.todo.example;

import io.github.maikbasel.todo.NotImplementedException;

public class Main {

    public static void main(String[] args) {
        var service = new Service();
        try {
            service.process1();
        } catch (NotImplementedException e) {
            System.out.println("It works!");
        }

        try {
            service.process2();
        } catch (NotImplementedException e) {
            System.out.println("It still works!");
        }
    }
}
