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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.465 -0400", hash_original_method = "8E7A8D6DFD82A6BAC9AB3CD54CF31BDC", hash_generated_method = "5734809D5FC651B417E3C930B97C62F6")
    @DSModeled(DSC.SAFE)
    private NioUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.466 -0400", hash_original_method = "6FD5A6B6EFE1B654EBBB85A447B00936", hash_generated_method = "B1EC0440B234EDBF99B5A433B378CE46")
    public static int getDirectBufferAddress(Buffer buffer) {
        return buffer.effectiveDirectAddress;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.467 -0400", hash_original_method = "0317201F8BF863383AD73DA0A92FFDF2", hash_generated_method = "E6C10C6DF1801BD646FF159D787C2339")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.470 -0400", hash_original_method = "EDFF18FC78F4764F7133825B9C3635B5", hash_generated_method = "209B46B133CA6BF5240477E289D3CD74")
    public static FileDescriptor getFD(FileChannel fc) {
        return ((FileChannelImpl) fc).getFD();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.471 -0400", hash_original_method = "36934C37A2F983F9B004D8F963783105", hash_generated_method = "FCC64B53C0D1519E199C7FE2CAF59931")
    public static FileChannel newFileChannel(Object stream, FileDescriptor fd, int mode) {
        return new FileChannelImpl(stream, fd, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.472 -0400", hash_original_method = "7D240E99D6029C73158519B20A0F21EF", hash_generated_method = "94762D1C307E5FEE551265262BD093BF")
    public static byte[] unsafeArray(ByteBuffer b) {
        return ((HeapByteBuffer) b).backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.473 -0400", hash_original_method = "2FFF8F204F2E28FEC7295F423960F22A", hash_generated_method = "9780990C20FA425691B10159F7452F6E")
    public static int unsafeArrayOffset(ByteBuffer b) {
        return ((HeapByteBuffer) b).offset;
    }

    
}


