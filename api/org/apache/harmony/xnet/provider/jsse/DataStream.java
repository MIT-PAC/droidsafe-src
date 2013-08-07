package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DataStream {

    
    public boolean hasData();

    
    public byte[] getData(int length);

}
