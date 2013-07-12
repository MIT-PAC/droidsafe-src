package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface DataStream {

    
    public boolean hasData();

    
    public byte[] getData(int length);

}
