package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Externalizable extends Serializable {
    
    public void readExternal(ObjectInput input) throws IOException,
            ClassNotFoundException;

    
    public void writeExternal(ObjectOutput output) throws IOException;
}
