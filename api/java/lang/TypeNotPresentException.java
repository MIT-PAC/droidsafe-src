package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class TypeNotPresentException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.969 -0500", hash_original_field = "EBF563A5B6DDA62D1601288798990D1D", hash_generated_field = "52B7B4456FF9EC4629580090450082F9")

    private static final long serialVersionUID = -5101214195716534496L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.970 -0500", hash_original_field = "585C5F628C300BCA9980197A904C62B8", hash_generated_field = "DAFE675943633FA9AA0F7DE9E967D92B")


    private String typeName;

    /**
     * Constructs a new {@code TypeNotPresentException} with the current stack
     * trace, a detail message that includes the name of the type that could not
     * be found and the {@code Throwable} that caused this exception.
     *
     * @param typeName
     *            the fully qualified name of the type that could not be found.
     * @param cause
     *            the optional cause of this exception, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.971 -0500", hash_original_method = "8F99105588FC99ADE0A826CA1D876689", hash_generated_method = "2BCFE584BA35CCAD344EF3CDCD0B917A")
    public TypeNotPresentException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
        this.typeName = typeName;
    }

    /**
     * Gets the fully qualified name of the type that could not be found.
     *
     * @return the name of the type that caused this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:25.972 -0500", hash_original_method = "4654D488024911B4CA912D2186B5898B", hash_generated_method = "343275828C51915E5F1AFC6F2DBFD430")
    public String typeName() {
        return typeName;
    }
}

