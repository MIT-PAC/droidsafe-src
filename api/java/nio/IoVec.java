package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.Libcore;
import libcore.io.ErrnoException;

final class IoVec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "1BCBC3F3B6DC171723792DD8598DF826", hash_generated_field = "8F7E59474A3A47E6FACE7437BBBF16C4")

    private ByteBuffer[] byteBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "52E664008CA2784B46D47A0B7D2EBB74", hash_generated_field = "D602CF0E0740AAEDFC4DEF8987780EF2")

    private int bufferCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "4945AAAE447C6AA7892F322E59AA507A", hash_generated_field = "27EC5D44122911539EEF00080CA2291C")

    private Object[] ioBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "F12DCB6E1A25DCBAE9609B573208F002", hash_generated_field = "8F6C8CDE5390F607AD0E24ACD9D6AB82")

    private int[] byteCounts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.206 -0400", hash_original_field = "EF72C37BE9D1B9E6E5BBD6EF09448ABE", hash_generated_field = "AD22A97F29292C6D1CAA320C6112ECB5")

    private Direction direction;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.209 -0400", hash_original_method = "79FA89440D1C6736393E7E6CE16B2553", hash_generated_method = "202BD0CFA645C0A9325FB09F7D29AF1B")
      IoVec(ByteBuffer[] byteBuffers, int offset, int bufferCount, Direction direction) {
        this.byteBuffers = byteBuffers;
        this.offset = offset;
        this.bufferCount = bufferCount;
        this.direction = direction;
        this.ioBuffers = new Object[bufferCount];
        this.offsets = new int[bufferCount];
        this.byteCounts = new int[bufferCount];
        // ---------- Original Method ----------
        //this.byteBuffers = byteBuffers;
        //this.offset = offset;
        //this.bufferCount = bufferCount;
        //this.direction = direction;
        //this.ioBuffers = new Object[bufferCount];
        //this.offsets = new int[bufferCount];
        //this.byteCounts = new int[bufferCount];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.211 -0400", hash_original_method = "0C69B202E78D62C368E6E03D03D6C92B", hash_generated_method = "A095A1F47ABA13D40CCF93A86E718694")
     int init() {
        int totalRemaining = 0;
for(int i = 0;i < bufferCount;++i)
        {
            ByteBuffer b = byteBuffers[i + offset];
            if(direction == Direction.READV)            
            {
                b.checkWritable();
            } //End block
            int remaining = b.remaining();
            if(b.isDirect())            
            {
                ioBuffers[i] = b;
                offsets[i] = b.position();
            } //End block
            else
            {
                ioBuffers[i] = NioUtils.unsafeArray(b);
                offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
            } //End block
            byteCounts[i] = remaining;
            totalRemaining += remaining;
        } //End block
        int var21FD3288307141A440FA39989E78E6C8_900449966 = (totalRemaining);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184770811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184770811;
        // ---------- Original Method ----------
        //int totalRemaining = 0;
        //for (int i = 0; i < bufferCount; ++i) {
            //ByteBuffer b = byteBuffers[i + offset];
            //if (direction == Direction.READV) {
                //b.checkWritable();
            //}
            //int remaining = b.remaining();
            //if (b.isDirect()) {
                //ioBuffers[i] = b;
                //offsets[i] = b.position();
            //} else {
                //ioBuffers[i] = NioUtils.unsafeArray(b);
                //offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
            //}
            //byteCounts[i] = remaining;
            //totalRemaining += remaining;
        //}
        //return totalRemaining;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.218 -0400", hash_original_method = "A7EE0836183CE06C4386DE620F235FAB", hash_generated_method = "8AC1A0E29A3BCD4A0D2B4EBF34C353FA")
     int doTransfer(FileDescriptor fd) throws IOException {
        addTaint(fd.getTaint());
        try 
        {
            if(direction == Direction.READV)            
            {
                int result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                if(result == 0)                
                {
                    result = -1;
                } //End block
                int varB4A88417B3D0170D754C647C30B7216A_1995321108 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711511241 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711511241;
            } //End block
            else
            {
                int var0FEE25386FB9D23B81A4B531CDBF1B6D_2116082361 = (Libcore.os.writev(fd, ioBuffers, offsets, byteCounts));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185424989 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185424989;
            } //End block
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1046509605 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1046509605.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1046509605;
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (direction == Direction.READV) {
                //int result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                //if (result == 0) {
                    //result = -1;
                //}
                //return result;
            //} else {
                //return Libcore.os.writev(fd, ioBuffers, offsets, byteCounts);
            //}
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.220 -0400", hash_original_method = "EBAF870E907233DA47B6BC3AD10EE875", hash_generated_method = "DE63A292B99FEB33B2C92DFFC3D4ECDB")
     void didTransfer(int byteCount) {
        addTaint(byteCount);
for(int i = 0;byteCount > 0 && i < bufferCount;++i)
        {
            ByteBuffer b = byteBuffers[i + offset];
            if(byteCounts[i] < byteCount)            
            {
                b.position(b.limit());
                byteCount -= byteCounts[i];
            } //End block
            else
            {
                b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                byteCount = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; byteCount > 0 && i < bufferCount; ++i) {
            //ByteBuffer b = byteBuffers[i + offset];
            //if (byteCounts[i] < byteCount) {
                //b.position(b.limit());
                //byteCount -= byteCounts[i];
            //} else {
                //b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                //byteCount = 0;
            //}
        //}
    }

    
    enum Direction { READV, WRITEV }

    
}

