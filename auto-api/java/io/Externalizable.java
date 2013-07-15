package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Externalizable extends Serializable {
    
    public void readExternal(ObjectInput input) throws IOException,
            ClassNotFoundException;

    
    public void writeExternal(ObjectOutput output) throws IOException;
}
