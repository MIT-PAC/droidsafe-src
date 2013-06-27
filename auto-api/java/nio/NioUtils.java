package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.FileDescriptor;
import java.nio.channels.FileChannel;

public final class NioUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.840 -0400", hash_original_method = "8E7A8D6DFD82A6BAC9AB3CD54CF31BDC", hash_generated_method = "0EA9CC78AA483B22B86873E261FF908D")
    private  NioUtils() {
        // ---------- Original Method ----------
    }

    
        public static int getDirectBufferAddress(Buffer buffer) {
        return buffer.effectiveDirectAddress;
    }

    
        public static void freeDirectBuffer(ByteBuffer buffer) {
        if (buffer == null) {
            return;
        }
        if (buffer instanceof DirectByteBuffer) {
            ((DirectByteBuffer) buffer).free();
        } else if (buffer instanceof MappedByteBuffer) {
            ((MappedByteBufferAdapter) buffer).free();
        } else {
            throw new AssertionError();
        }
    }

    
        public static FileDescriptor getFD(FileChannel fc) {
        return ((FileChannelImpl) fc).getFD();
    }

    
        public static FileChannel newFileChannel(Object stream, FileDescriptor fd, int mode) {
        return new FileChannelImpl(stream, fd, mode);
    }

    
        public static byte[] unsafeArray(ByteBuffer b) {
        return ((HeapByteBuffer) b).backingArray;
    }

    
        public static int unsafeArrayOffset(ByteBuffer b) {
        return ((HeapByteBuffer) b).offset;
    }

    
}

