package java.io;

// Droidsafe Imports

public interface Externalizable extends Serializable {
    
    public void readExternal(ObjectInput input) throws IOException,
            ClassNotFoundException;

    
    public void writeExternal(ObjectOutput output) throws IOException;
}
