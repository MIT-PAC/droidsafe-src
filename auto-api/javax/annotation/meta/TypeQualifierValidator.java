package javax.annotation.meta;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

public interface TypeQualifierValidator<A extends Annotation> {
    
    public @Nonnull
    When forConstantValue(@Nonnull A annotation, Object value);
}
