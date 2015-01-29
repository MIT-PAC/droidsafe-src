package droidsafe.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface DSGeneratedField {
	String tool_name();
	String tool_version();
	String generated_on();
	String hash_original_field();
	String hash_generated_field();

}
