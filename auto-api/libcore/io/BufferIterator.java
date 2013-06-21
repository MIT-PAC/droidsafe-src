package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class BufferIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:38.788 -0400", hash_original_method = "0D48E83ED50D873F1B5E6B77EEDA24F6", hash_generated_method = "0D48E83ED50D873F1B5E6B77EEDA24F6")
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

