package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface DataOutput {

    
    public abstract void write(byte[] buffer) throws IOException;

    
    public abstract void write(byte[] buffer, int offset, int count) throws IOException;

    
    public abstract void write(int oneByte) throws IOException;

    
    public abstract void writeBoolean(boolean val) throws IOException;

    
    public abstract void writeByte(int val) throws IOException;

    
    public abstract void writeBytes(String str) throws IOException;

    
    public abstract void writeChar(int val) throws IOException;

    
    public abstract void writeChars(String str) throws IOException;

    
    public abstract void writeDouble(double val) throws IOException;

    
    public abstract void writeFloat(float val) throws IOException;

    
    public abstract void writeInt(int val) throws IOException;

    
    public abstract void writeLong(long val) throws IOException;

    
    public abstract void writeShort(int val) throws IOException;

    
    public abstract void writeUTF(String str) throws IOException;
}
