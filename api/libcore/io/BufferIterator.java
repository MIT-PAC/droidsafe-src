package libcore.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class BufferIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:15.379 -0400", hash_original_method = "D18BB79D0D4A277413AB03F78A6D226A", hash_generated_method = "D18BB79D0D4A277413AB03F78A6D226A")
    public BufferIterator ()
    {
        
    }


    public abstract void seek(int offset);

    
    public abstract void skip(int byteCount);

    
    public abstract void readByteArray(byte[] dst, int dstOffset, int byteCount);

    
    public abstract byte readByte();

    
    public abstract int readInt();

    
    public abstract void readIntArray(int[] dst, int dstOffset, int intCount);

    
    public abstract short readShort();

    
}

