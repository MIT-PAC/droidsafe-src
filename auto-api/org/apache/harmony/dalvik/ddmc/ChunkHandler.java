package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class ChunkHandler {
    public static final ByteOrder CHUNK_ORDER = ByteOrder.BIG_ENDIAN;
    public static final int CHUNK_FAIL = type("FAIL");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "0BD4350C5F4AC480382F0B830C677606", hash_generated_method = "A1D9F40D33FAD2208F03D121C5440DA4")
    @DSModeled(DSC.SAFE)
    public ChunkHandler() {
        // ---------- Original Method ----------
    }

    
    public abstract void connected();

    
    public abstract void disconnected();

    
    public abstract Chunk handleChunk(Chunk request);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "C46188873CD65BE8F631FA87BDDC740C", hash_generated_method = "8FC1905650EED8AC87EAA7B03A44957E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "9A4D440DF1CB896120B5FA72FC432167", hash_generated_method = "63F47057B2C06C1B3FF74C90271A6BA4")
    public static ByteBuffer wrapChunk(Chunk request) {
        ByteBuffer in;
        in = ByteBuffer.wrap(request.data, request.offset, request.length);
        in.order(CHUNK_ORDER);
        return in;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "FA7A7F05DB2FE31EEF2BA4F265625DB1", hash_generated_method = "280A70AC481DC324250E99E3A8171D50")
    public static String getString(ByteBuffer buf, int len) {
        char[] data = new char[len];
        for (int i = 0; i < len; i++)
            data[i] = buf.getChar();
        return new String(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "51F0DCFDF89FF963EFE3BF68BCC9050B", hash_generated_method = "5116DFEA43567FED39E3E3E398E2FE24")
    public static void putString(ByteBuffer buf, String str) {
        int len = str.length();
        for (int i = 0; i < len; i++)
            buf.putChar(str.charAt(i));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "80416961D3D462799397D4BBBFCDEABD", hash_generated_method = "31D3B2F5FDE5951818C240C80F8775C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.558 -0400", hash_original_method = "1E2D02BC8FB8E252FF49DCB34C7A3DA2", hash_generated_method = "F455ECFED3A613CA2E8F838B3A946E0C")
    public static String name(int type) {
        char[] ascii = new char[4];
        ascii[0] = (char) ((type >> 24) & 0xff);
        ascii[1] = (char) ((type >> 16) & 0xff);
        ascii[2] = (char) ((type >> 8) & 0xff);
        ascii[3] = (char) (type & 0xff);
        return new String(ascii);
    }

    
}


