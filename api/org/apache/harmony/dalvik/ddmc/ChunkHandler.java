package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class ChunkHandler {

    /**
     * Create a FAIL chunk.  The "handleChunk" methods can use this to
     * return an error message when they are not able to process a chunk.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.493 -0500", hash_original_method = "C46188873CD65BE8F631FA87BDDC740C", hash_generated_method = "8FC1905650EED8AC87EAA7B03A44957E")
    
public static Chunk createFailChunk(int errorCode, String msg) {
        if (msg == null)
            msg = "";

        ByteBuffer out = ByteBuffer.allocate(8 + msg.length() * 2);
        out.order(ChunkHandler.CHUNK_ORDER);
        out.putInt(errorCode);
        out.putInt(msg.length());
        putString(out, msg);

        return new Chunk(CHUNK_FAIL, out);
    }

    /**
     * Utility function to wrap a ByteBuffer around a Chunk.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.495 -0500", hash_original_method = "9A4D440DF1CB896120B5FA72FC432167", hash_generated_method = "63F47057B2C06C1B3FF74C90271A6BA4")
    
public static ByteBuffer wrapChunk(Chunk request) {
        ByteBuffer in;

        in = ByteBuffer.wrap(request.data, request.offset, request.length);
        in.order(CHUNK_ORDER);
        return in;
    }

    /**
     * Utility function to copy a String out of a ByteBuffer.
     *
     * This is here because multiple chunk handlers can make use of it,
     * and there's nowhere better to put it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.498 -0500", hash_original_method = "FA7A7F05DB2FE31EEF2BA4F265625DB1", hash_generated_method = "280A70AC481DC324250E99E3A8171D50")
    
public static String getString(ByteBuffer buf, int len) {
        char[] data = new char[len];
        for (int i = 0; i < len; i++)
            data[i] = buf.getChar();
        return new String(data);
    }

    /**
     * Utility function to copy a String into a ByteBuffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.500 -0500", hash_original_method = "51F0DCFDF89FF963EFE3BF68BCC9050B", hash_generated_method = "5116DFEA43567FED39E3E3E398E2FE24")
    
public static void putString(ByteBuffer buf, String str) {
        int len = str.length();
        for (int i = 0; i < len; i++)
            buf.putChar(str.charAt(i));
    }

    /**
     * Convert a 4-character string to a 32-bit type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.503 -0500", hash_original_method = "80416961D3D462799397D4BBBFCDEABD", hash_generated_method = "31D3B2F5FDE5951818C240C80F8775C9")
    
public static int type(String typeName) {
        if (typeName.length() != 4) {
            throw new IllegalArgumentException("Bad type name: " + typeName);
        }
        int result = 0;
        for (int i = 0; i < 4; ++i) {
            result = ((result << 8) | (typeName.charAt(i) & 0xff));
        }
        return result;
    }

    /**
     * Convert an integer type to a 4-character string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.506 -0500", hash_original_method = "1E2D02BC8FB8E252FF49DCB34C7A3DA2", hash_generated_method = "F455ECFED3A613CA2E8F838B3A946E0C")
    
public static String name(int type)
    {
        char[] ascii = new char[4];

        ascii[0] = (char) ((type >> 24) & 0xff);
        ascii[1] = (char) ((type >> 16) & 0xff);
        ascii[2] = (char) ((type >> 8) & 0xff);
        ascii[3] = (char) (type & 0xff);

        return new String(ascii);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.478 -0500", hash_original_field = "2496B3C5135989F3D2ADF2C4C881E55D", hash_generated_field = "A2C17307B2D961989393A7361B1B3146")

    public static final ByteOrder CHUNK_ORDER = ByteOrder.BIG_ENDIAN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.480 -0500", hash_original_field = "07EA4913F42C7E451CF1F131F0F5E47E", hash_generated_field = "87F77568F8CFE33172C27D380CE00E97")

    public static final int CHUNK_FAIL = type("FAIL");

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.483 -0500", hash_original_method = "0BD4350C5F4AC480382F0B830C677606", hash_generated_method = "8C7D92051A6E50910F5A66858FFA4A09")
    
public ChunkHandler() {}

    /**
     * Called when the DDM server connects.  The handler is allowed to
     * send messages to the server.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.486 -0500", hash_original_method = "F8778661F062D65184BDE4E1FC57A2A5", hash_generated_method = "D3AD816D5A1FD5740389E5B94B8A9ABA")
    
public abstract void connected();

    /**
     * Called when the DDM server disconnects.  Can be used to disable
     * periodic transmissions or clean up saved state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.488 -0500", hash_original_method = "810314C01C4508E83D83EEDA6FA417D5", hash_generated_method = "5EE59171C2C1381561F50D4DEC0791A4")
    
public abstract void disconnected();

    /**
     * Handle a single chunk of data.  "request" includes the type and
     * the chunk payload.
     *
     * Returns a response in a Chunk.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.490 -0500", hash_original_method = "1554C45CF6A8284D65A689A77C8DBE40", hash_generated_method = "165C8CBCAA6CA401C4B805858E7B51D2")
    
public abstract Chunk handleChunk(Chunk request);
}

