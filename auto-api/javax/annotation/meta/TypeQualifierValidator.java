package javax.annotation.meta;


import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;



public interface TypeQualifierValidator<A extends Annotation> {
    
    public @Nonnull
    When forConstantValue(@Nonnull A annotation, Object value);
}
