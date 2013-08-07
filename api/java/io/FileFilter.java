package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface FileFilter {

    
    public abstract boolean accept(File pathname);
}
