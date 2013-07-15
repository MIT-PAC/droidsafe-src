package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Formattable {

    
    void formatTo(Formatter formatter, int flags, int width, int precision)
            throws IllegalFormatException;
}
