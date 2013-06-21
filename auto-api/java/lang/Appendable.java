package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public interface Appendable {

    
    Appendable append(char c) throws IOException;

    
    Appendable append(CharSequence csq) throws IOException;

    
    Appendable append(CharSequence csq, int start, int end) throws IOException;
}
