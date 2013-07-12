package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface FilenameFilter {

    
    public abstract boolean accept(File dir, String filename);
}
