package io.github.maikbasel.todo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code Todo} annotation is used to mark methods or classes that are not implemented yet.
 * It is typically used as a placeholder for future development.
 *
 * <p>Usage example:
 * <pre>
 *     &#064;Todo
 *     public void process() {
 *         // Implementation pending
 *     }
 * </pre>
 *
 * <p>The value of the {@code Todo} annotation can be specified to provide additional information
 * about the task that needs to be implemented.
 *
 * <p>Usage example with custom message:
 * <pre>
 *     &#064;Todo("Cool message.")
 *     public void process() {
 *         // Implementation pending
 *     }
 * </pre>
 *
 * <p>When a method or class marked with the {@code Todo} annotation is called, it will throw
 * a {@code NotImplementedException} with the specified message or the default message
 * "Not implemented yet." if no message is provided.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {

    String value() default "Not implemented yet.";
}
