package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Formattable {

    
    void formatTo(Formatter formatter, int flags, int width, int precision)
            throws IllegalFormatException;
}
