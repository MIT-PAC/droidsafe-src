package javax.annotation.meta;

// Droidsafe Imports
import java.lang.annotation.Annotation;
// needed for enhanced for control translations

public interface TypeQualifierValidator<A extends Annotation> {
    
    public @Nonnull
    When forConstantValue(@Nonnull A annotation, Object value);
}
