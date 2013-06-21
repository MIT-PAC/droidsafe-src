package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Iterator;

public interface EntityIterator extends Iterator<Entity> {
    
    public void reset();

    
    public void close();
}
