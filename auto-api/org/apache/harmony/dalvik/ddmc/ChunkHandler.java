package org.apache.harmony.dalvik.ddmc;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class ChunkHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.039 -0400", hash_original_method = "0BD4350C5F4AC480382F0B830C677606", hash_generated_method = "85D4A412A038AD8195337BC6AC5AD626")
    public  ChunkHandler() {
        
    }

    
    public abstract void connected();

    
    public abstract void disconnected();

    
    public abstract Chunk handleChunk(Chunk request);

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static ByteBuffer wrapChunk(Chunk request) {
        ByteBuffer in;
        in = ByteBuffer.wrap(request.data, request.offset, request.length);
        in.order(CHUNK_ORDER);
        return in;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getString(ByteBuffer buf, int len) {
        char[] data = new char[len];
        for (int i = 0; i < len; i++)
            data[i] = buf.getChar();
        return new String(data);
    }

    
    @DSModeled(DSC.SAFE)
    public static void putString(ByteBuffer buf, String str) {
        int len = str.length();
        for (int i = 0; i < len; i++)
            buf.putChar(str.charAt(i));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static String name(int type) {
        char[] ascii = new char[4];
        ascii[0] = (char) ((type >> 24) & 0xff);
        ascii[1] = (char) ((type >> 16) & 0xff);
        ascii[2] = (char) ((type >> 8) & 0xff);
        ascii[3] = (char) (type & 0xff);
        return new String(ascii);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.041 -0400", hash_original_field = "46A63A0B1FE335CA411CDC37C8B4C323", hash_generated_field = "A2C17307B2D961989393A7361B1B3146")

    public static final ByteOrder CHUNK_ORDER = ByteOrder.BIG_ENDIAN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.041 -0400", hash_original_field = "CF649E15C7ED8616BA88686838F6DD5A", hash_generated_field = "87F77568F8CFE33172C27D380CE00E97")

    public static final int CHUNK_FAIL = type("FAIL");
}

