package droidsafe.android.app.resources;

import java.lang.annotation.*;

/** Marks a field as being set by an XML Attribute **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Attribute {
}
