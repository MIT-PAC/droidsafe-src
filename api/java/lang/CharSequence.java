package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface CharSequence {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public int length();
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.ABSTRACT_METHOD)
    public char charAt(int index);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public CharSequence subSequence(int start, int end);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public String toString();
}
