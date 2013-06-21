package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface CharSequence {

    
    public int length();

    
    public char charAt(int index);

    
    public CharSequence subSequence(int start, int end);

    
    public String toString();
}
