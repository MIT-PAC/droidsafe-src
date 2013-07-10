package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public abstract class FileLock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.637 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.637 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.637 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.637 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.638 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "61492B07ADA6BD789C319D7FA4983B8B")
    protected  FileLock(FileChannel channel, long position, long size, boolean shared) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.639 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "8A03CC959047613AFB2348FC512E2111")
    public final FileChannel channel() {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1618250745 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1618250745 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_1618250745.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1618250745;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.639 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "CF0764ADBF808D7BD521E6A19CD1124B")
    public final long position() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1145208767 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1145208767;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.639 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "A512C48F59EB2384A4E667FD46A245C3")
    public final long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1216956136 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1216956136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.639 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "8EA161894B058A67A66F2EC0293B74EE")
    public final boolean isShared() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528917161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528917161;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.640 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "4E77D62AA5B12EAF5EF65FCF9729F12B")
    public final boolean overlaps(long start, long length) {
        final long end = position + size - 1;
        final long newEnd = start + length - 1;
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087565272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087565272;
        
        
        
        
            
        
        
    }

    
    public abstract boolean isValid();

    
    public abstract void release() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.640 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "D70FD532C896798BCCD65D81C7794A5F")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_923136628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_923136628 = "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
        varB4EAC82CA7396A68D541C85D26508E83_923136628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_923136628;
        
        
    }

    
}

