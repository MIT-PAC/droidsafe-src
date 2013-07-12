package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface CharacterIterator extends Cloneable {

    
    public static final char DONE = '\uffff';

    
    public Object clone();

    
    public char current();

    
    public char first();

    
    public int getBeginIndex();

    
    public int getEndIndex();

    
    public int getIndex();

    
    public char last();

    
    public char next();

    
    public char previous();

    
    public char setIndex(int location);
}
