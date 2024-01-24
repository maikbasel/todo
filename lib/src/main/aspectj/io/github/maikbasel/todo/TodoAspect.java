package io.github.maikbasel.todo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The {@code TodoAspect} class is an aspect that handles methods or classes marked with
 * the {@code Todo} annotation. It throws a {@code NotImplementedException} when the
 * annotated method or class is called.
 *
 * @see Todo
 * @see NotImplementedException
 */
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
