package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface DataInput {
    
    public abstract boolean readBoolean() throws IOException;

    
    public abstract byte readByte() throws IOException;

    
    public abstract char readChar() throws IOException;

    
    public abstract double readDouble() throws IOException;

    
    public abstract float readFloat() throws IOException;

    
    public abstract void readFully(byte[] dst) throws IOException;

    
    public abstract void readFully(byte[] dst, int offset, int byteCount) throws IOException;

    
    public abstract int readInt() throws IOException;

    
    public abstract String readLine() throws IOException;

    
    public abstract long readLong() throws IOException;

    
    public abstract short readShort() throws IOException;

    
    public abstract int readUnsignedByte() throws IOException;

    
    public abstract int readUnsignedShort() throws IOException;

    
    public abstract String readUTF() throws IOException;

    
    public abstract int skipBytes(int count) throws IOException;
}
