package droidsafe.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface DSGenerator {
	String tool_name();
	String tool_version();
	String generated_on();
	String hash_original_method();
	String hash_generated_method();

}
