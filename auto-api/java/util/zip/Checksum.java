package java.util.zip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Checksum {

    
    public long getValue();

    
    public void reset();

    
    public void update(byte[] buf, int off, int nbytes);

    
    public void update(int val);
}
