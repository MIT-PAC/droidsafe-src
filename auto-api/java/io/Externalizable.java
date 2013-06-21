package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface Externalizable extends Serializable {
    
    public void readExternal(ObjectInput input) throws IOException,
            ClassNotFoundException;

    
    public void writeExternal(ObjectOutput output) throws IOException;
}
