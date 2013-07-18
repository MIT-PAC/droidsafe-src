package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports

public interface DataStream {

    
    public boolean hasData();

    
    public byte[] getData(int length);

}
