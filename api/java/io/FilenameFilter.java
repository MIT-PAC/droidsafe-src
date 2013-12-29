package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface FilenameFilter {

    
    public abstract boolean accept(File dir, String filename);
}
