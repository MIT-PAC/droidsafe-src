package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public abstract class MappedByteBuffer extends ByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.702 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "D7679EF467A9ABFED1C67E3C246585AB")

    DirectByteBuffer wrapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.702 -0400", hash_original_field = "54E7387E52E874C96887778FCFC7FAC0", hash_generated_field = "2A1F112DD9317D05E828544B748EF0B7")

    private MapMode mapMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.702 -0400", hash_original_method = "B4624F88D9C5C045F8BDE794FFD519CF", hash_generated_method = "02D8726EEA215BE950E8139BFA998E3B")
      MappedByteBuffer(ByteBuffer directBuffer) {
        super(directBuffer.capacity, directBuffer.block);
        {
            boolean varDC8DBD478B08EB0C265C25CC94CB6B1C_1312516253 = (!directBuffer.isDirect());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
        } 
        this.wrapped = (DirectByteBuffer) directBuffer;
        this.mapMode = null;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.703 -0400", hash_original_method = "638BC1993DAD17C2741F99B13CBD8BD7", hash_generated_method = "3696F6B779A20513AF0D49CF8B1A093E")
      MappedByteBuffer(MemoryBlock block, int capacity, int offset, MapMode mapMode) {
        super(capacity, block);
        this.mapMode = mapMode;
        {
            wrapped = new ReadOnlyDirectByteBuffer(block, capacity, offset);
        } 
        {
            wrapped = new ReadWriteDirectByteBuffer(block, capacity, offset);
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.704 -0400", hash_original_method = "C9D4A4A6949ED0E6DB022AC73D44B615", hash_generated_method = "C160DE86CBAC2205AC96B2FCD215527E")
    public final boolean isLoaded() {
        long address = block.toInt();
        long size = block.getSize();
        try 
        {
            int pageSize = (int) Libcore.os.sysconf(_SC_PAGE_SIZE);
            int pageOffset = (int) (address % pageSize);
            address -= pageOffset;
            size += pageOffset;
            int pageCount = (int) ((size + pageSize - 1) / pageSize);
            byte[] vector = new byte[pageCount];
            Libcore.os.mincore(address, size, vector);
            {
                int i = 0;
            } 
        } 
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015466321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015466321;
        
        
        
        
            
        
        
            
            
            
            
            
            
            
            
                
                    
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.706 -0400", hash_original_method = "61E403E118E1A4E788B2CC284AD4ABD1", hash_generated_method = "9C3F7BC174DE050BDB912A82BED06C51")
    public final MappedByteBuffer load() {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_115587893 = null; 
        try 
        {
            Libcore.os.mlock(block.toInt(), block.getSize());
            Libcore.os.munlock(block.toInt(), block.getSize());
        } 
        catch (ErrnoException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_115587893 = this;
        varB4EAC82CA7396A68D541C85D26508E83_115587893.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_115587893;
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.708 -0400", hash_original_method = "F84161825A8E4C54BC8547EBE9290572", hash_generated_method = "014D2F200EA65990B5E076C23E331FCA")
    public final MappedByteBuffer force() {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_790670949 = null; 
        {
            try 
            {
                Libcore.os.msync(block.toInt(), block.getSize(), MS_SYNC);
            } 
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_790670949 = this;
        varB4EAC82CA7396A68D541C85D26508E83_790670949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_790670949;
        
        
            
                
            
                
            
        
        
    }

    
}

