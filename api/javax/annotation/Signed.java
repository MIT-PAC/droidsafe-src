package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;



@Documented
@TypeQualifierNickname
@Nonnegative(when = When.UNKNOWN)
@Retention(RetentionPolicy.RUNTIME)
public @interface Signed {

}
