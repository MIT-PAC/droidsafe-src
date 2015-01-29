package dk.brics.string.annotation;

import java.lang.annotation.*;

/**
 * Denotes that the annotated field, parameter, or return type must only be assigned to a string
 * matching the specified regular expression.
 * <p/>
 * Note that a field's initial value of <tt>null</tt> will not be considered a violation
 * of this type. This means that even if no violations were found, a field may still be 
 * a null-pointer when read.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface Type {
	String value();
}
