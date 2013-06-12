package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class BufferIterator {
    
    public abstract void seek(int offset);

    
    public abstract void skip(int byteCount);

    
    public abstract void readByteArray(byte[] dst, int dstOffset, int byteCount);

    
    public abstract byte readByte();

    
    public abstract int readInt();

    
    public abstract void readIntArray(int[] dst, int dstOffset, int intCount);

    
    public abstract short readShort();

    
}


