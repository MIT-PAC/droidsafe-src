package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface CharSequence {

    
    public int length();

    
    public char charAt(int index);

    
    public CharSequence subSequence(int start, int end);

    
    public String toString();
}
