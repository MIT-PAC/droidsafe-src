package android.content;

// Droidsafe Imports
import java.util.Iterator;

public interface EntityIterator extends Iterator<Entity> {
    
    public void reset();

    
    public void close();
}
