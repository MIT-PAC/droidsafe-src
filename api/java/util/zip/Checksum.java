package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Checksum {

    
    public long getValue();

    
    public void reset();

    
    public void update(byte[] buf, int off, int nbytes);

    
    public void update(int val);
}
