package dk.brics.string.annotation;

import java.lang.annotation.*;

/**
 * Denotes that the specified field, parameter, or return type must only be assigned to a string
 * accepted by the serialized automaton located at the specified path.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface LoadType {
	String value();
}
