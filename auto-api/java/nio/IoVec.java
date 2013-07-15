package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.Libcore;
import libcore.io.ErrnoException;

final class IoVec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "1BCBC3F3B6DC171723792DD8598DF826", hash_generated_field = "8F7E59474A3A47E6FACE7437BBBF16C4")

    private ByteBuffer[] byteBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "52E664008CA2784B46D47A0B7D2EBB74", hash_generated_field = "D602CF0E0740AAEDFC4DEF8987780EF2")

    private int bufferCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "4945AAAE447C6AA7892F322E59AA507A", hash_generated_field = "27EC5D44122911539EEF00080CA2291C")

    private Object[] ioBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "831BD6D82461A6164F50E583F8749188", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private int[] offsets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "F12DCB6E1A25DCBAE9609B573208F002", hash_generated_field = "8F6C8CDE5390F607AD0E24ACD9D6AB82")

    private int[] byteCounts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.587 -0400", hash_original_field = "EF72C37BE9D1B9E6E5BBD6EF09448ABE", hash_generated_field = "AD22A97F29292C6D1CAA320C6112ECB5")

    private Direction direction;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.588 -0400", hash_original_method = "79FA89440D1C6736393E7E6CE16B2553", hash_generated_method = "202BD0CFA645C0A9325FB09F7D29AF1B")
      IoVec(ByteBuffer[] byteBuffers, int offset, int bufferCount, Direction direction) {
        this.byteBuffers = byteBuffers;
        this.offset = offset;
        this.bufferCount = bufferCount;
        this.direction = direction;
        this.ioBuffers = new Object[bufferCount];
        this.offsets = new int[bufferCount];
        this.byteCounts = new int[bufferCount];
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.590 -0400", hash_original_method = "0C69B202E78D62C368E6E03D03D6C92B", hash_generated_method = "13C7B33E3B214455BD98A9EA08D5BB4B")
     int init() {
        int totalRemaining = 0;
        {
            int i = 0;
            {
                ByteBuffer b = byteBuffers[i + offset];
                {
                    b.checkWritable();
                } 
                int remaining = b.remaining();
                {
                    boolean var485497B2C9BE8560C87D0DBBE26ABBEA_763082764 = (b.isDirect());
                    {
                        ioBuffers[i] = b;
                        offsets[i] = b.position();
                    } 
                    {
                        ioBuffers[i] = NioUtils.unsafeArray(b);
                        offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
                    } 
                } 
                byteCounts[i] = remaining;
                totalRemaining += remaining;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52836387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_52836387;
        
        
        
            
            
                
            
            
            
                
                
            
                
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.591 -0400", hash_original_method = "A7EE0836183CE06C4386DE620F235FAB", hash_generated_method = "D47440A27B0EF4214B64B8937022F950")
     int doTransfer(FileDescriptor fd) throws IOException {
        try 
        {
            {
                int result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                {
                    result = -1;
                } 
            } 
            {
                int var74139DC41892DAA1E1523A68BE0BA9F9_570994815 = (Libcore.os.writev(fd, ioBuffers, offsets, byteCounts));
            } 
        } 
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } 
        addTaint(fd.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826572869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826572869;
        
        
            
                
                
                    
                
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.591 -0400", hash_original_method = "EBAF870E907233DA47B6BC3AD10EE875", hash_generated_method = "2F034FF23DD97D0851736A7DDDD7FDFC")
     void didTransfer(int byteCount) {
        {
            int i = 0;
            {
                ByteBuffer b = byteBuffers[i + offset];
                {
                    b.position(b.limit());
                    byteCount -= byteCounts[i];
                } 
                {
                    b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                    byteCount = 0;
                } 
            } 
        } 
        addTaint(byteCount);
        
        
            
            
                
                
            
                
                
            
        
    }

    
    enum Direction { READV, WRITEV }

    
}

