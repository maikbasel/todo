package io.github.maikbasel.todo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TodoAspect {

    @Pointcut("@annotation(todo)")
    public void todoPointcut(Todo todo) {
    }

    @Before("todoPointcut(todo)")
    public void before(JoinPoint jp, Todo todo) {
        throw new NotImplementedException(todo.value());
    }
}
