package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Formattable {

    
    void formatTo(Formatter formatter, int flags, int width, int precision)
            throws IllegalFormatException;
}
