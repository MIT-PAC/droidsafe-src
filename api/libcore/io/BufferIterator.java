package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public abstract class BufferIterator {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:23.996 -0400", hash_original_method = "D18BB79D0D4A277413AB03F78A6D226A", hash_generated_method = "D18BB79D0D4A277413AB03F78A6D226A")
    public BufferIterator ()
    {
        //Synthesized constructor
    }
    /**
     * Seeks to the absolute position {@code offset}, measured in bytes from the start.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.996 -0500", hash_original_method = "B1655DB4B03BAF0CB71C346A2CB0A771", hash_generated_method = "35BD1C3575B86A0A46D1AF8BA93E0AF9")
    public abstract void seek(int offset);

    /**
     * Skips forwards or backwards {@code byteCount} bytes from the current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.997 -0500", hash_original_method = "CC5615186705CFDADB8C29CFF5127EEC", hash_generated_method = "A60039E417E9A76F3DC099155D350439")
    public abstract void skip(int byteCount);

    /**
     * Copies {@code byteCount} bytes from the current position into {@code dst}, starting at
     * {@code dstOffset}, and advances the current position {@code byteCount} bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.997 -0500", hash_original_method = "5B01B26AB573F1731BA9CC67B9FD2A67", hash_generated_method = "F399B0B9F8DEEBF1FFE942EC22E65968")
    public abstract void readByteArray(byte[] dst, int dstOffset, int byteCount);

    /**
     * Returns the byte at the current position, and advances the current position one byte.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.998 -0500", hash_original_method = "312C8CD55B22F35D0367E41AADEB2D90", hash_generated_method = "995CB8823C249C5AD966F3422FBB53EA")
    public abstract byte readByte();

    /**
     * Returns the 32-bit int at the current position, and advances the current position four bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:39.999 -0500", hash_original_method = "97FB920EA9544B24495059FF8518145E", hash_generated_method = "F9CE40910F4BE47045E60285653C98F0")
    public abstract int readInt();

    /**
     * Copies {@code intCount} 32-bit ints from the current position into {@code dst}, starting at
     * {@code dstOffset}, and advances the current position {@code 4 * intCount} bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.000 -0500", hash_original_method = "25B81B8C8DB0E69F07028BC2D8BF5A20", hash_generated_method = "10897E9DD414F65452F9CE1BC92526E3")
    public abstract void readIntArray(int[] dst, int dstOffset, int intCount);

    /**
     * Returns the 16-bit short at the current position, and advances the current position two bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:40.001 -0500", hash_original_method = "79F6E5E535CEEE85EF82C58CF2026A77", hash_generated_method = "20EB2E694EC60D5039A074E2AD400C12")
    public abstract short readShort();

    
}

