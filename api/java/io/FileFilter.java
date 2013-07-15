package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface FileFilter {

    
    public abstract boolean accept(File pathname);
}
