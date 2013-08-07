package libcore.io;

// Droidsafe Imports
import droidsafe.annotations.*;




public abstract class BufferIterator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.996 -0400", hash_original_method = "D18BB79D0D4A277413AB03F78A6D226A", hash_generated_method = "D18BB79D0D4A277413AB03F78A6D226A")
    public BufferIterator ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void seek(int offset);

    
    @DSModeled(DSC.SAFE)
    public abstract void skip(int byteCount);

    
    @DSModeled(DSC.SAFE)
    public abstract void readByteArray(byte[] dst, int dstOffset, int byteCount);

    
    @DSModeled(DSC.SAFE)
    public abstract byte readByte();

    
    @DSModeled(DSC.SAFE)
    public abstract int readInt();

    
    @DSModeled(DSC.SAFE)
    public abstract void readIntArray(int[] dst, int dstOffset, int intCount);

    
    @DSModeled(DSC.SAFE)
    public abstract short readShort();

    
}

