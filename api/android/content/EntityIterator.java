package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public interface EntityIterator extends Iterator<Entity> {
    
    public void reset();

    
    public void close();
}
