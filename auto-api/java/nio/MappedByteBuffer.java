package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public abstract class MappedByteBuffer extends ByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.751 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "D7679EF467A9ABFED1C67E3C246585AB")

    DirectByteBuffer wrapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.752 -0400", hash_original_field = "54E7387E52E874C96887778FCFC7FAC0", hash_generated_field = "2A1F112DD9317D05E828544B748EF0B7")

    private MapMode mapMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.761 -0400", hash_original_method = "B4624F88D9C5C045F8BDE794FFD519CF", hash_generated_method = "592F47ECEE49D493C4D649EB670BB79D")
      MappedByteBuffer(ByteBuffer directBuffer) {
        super(directBuffer.capacity, directBuffer.block);
        {
            boolean varDC8DBD478B08EB0C265C25CC94CB6B1C_455574979 = (!directBuffer.isDirect());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        this.wrapped = (DirectByteBuffer) directBuffer;
        this.mapMode = null;
        // ---------- Original Method ----------
        //if (!directBuffer.isDirect()) {
            //throw new IllegalArgumentException();
        //}
        //this.wrapped = (DirectByteBuffer) directBuffer;
        //this.mapMode = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.762 -0400", hash_original_method = "638BC1993DAD17C2741F99B13CBD8BD7", hash_generated_method = "3696F6B779A20513AF0D49CF8B1A093E")
      MappedByteBuffer(MemoryBlock block, int capacity, int offset, MapMode mapMode) {
        super(capacity, block);
        this.mapMode = mapMode;
        {
            wrapped = new ReadOnlyDirectByteBuffer(block, capacity, offset);
        } //End block
        {
            wrapped = new ReadWriteDirectByteBuffer(block, capacity, offset);
        } //End block
        // ---------- Original Method ----------
        //this.mapMode = mapMode;
        //if (mapMode == MapMode.READ_ONLY) {
            //wrapped = new ReadOnlyDirectByteBuffer(block, capacity, offset);
        //} else {
            //wrapped = new ReadWriteDirectByteBuffer(block, capacity, offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.763 -0400", hash_original_method = "C9D4A4A6949ED0E6DB022AC73D44B615", hash_generated_method = "F3F77E4C7E2A018CF7C7F69531EE334F")
    public final boolean isLoaded() {
        long address;
        address = block.toInt();
        long size;
        size = block.getSize();
        try 
        {
            int pageSize;
            pageSize = (int) Libcore.os.sysconf(_SC_PAGE_SIZE);
            int pageOffset;
            pageOffset = (int) (address % pageSize);
            address -= pageOffset;
            size += pageOffset;
            int pageCount;
            pageCount = (int) ((size + pageSize - 1) / pageSize);
            byte[] vector;
            vector = new byte[pageCount];
            Libcore.os.mincore(address, size, vector);
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        catch (ErrnoException errnoException)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1815586654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1815586654;
        // ---------- Original Method ----------
        //long address = block.toInt();
        //long size = block.getSize();
        //if (size == 0) {
            //return true;
        //}
        //try {
            //int pageSize = (int) Libcore.os.sysconf(_SC_PAGE_SIZE);
            //int pageOffset = (int) (address % pageSize);
            //address -= pageOffset;
            //size += pageOffset;
            //int pageCount = (int) ((size + pageSize - 1) / pageSize);
            //byte[] vector = new byte[pageCount];
            //Libcore.os.mincore(address, size, vector);
            //for (int i = 0; i < vector.length; ++i) {
                //if ((vector[i] & 1) != 1) {
                    //return false;
                //}
            //}
            //return true;
        //} catch (ErrnoException errnoException) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.763 -0400", hash_original_method = "61E403E118E1A4E788B2CC284AD4ABD1", hash_generated_method = "0CD1EBEB9619F3C4C49AE8C451FF612F")
    public final MappedByteBuffer load() {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1344410676 = null; //Variable for return #1
        try 
        {
            Libcore.os.mlock(block.toInt(), block.getSize());
            Libcore.os.munlock(block.toInt(), block.getSize());
        } //End block
        catch (ErrnoException ignored)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1344410676 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1344410676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344410676;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mlock(block.toInt(), block.getSize());
            //Libcore.os.munlock(block.toInt(), block.getSize());
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.782 -0400", hash_original_method = "F84161825A8E4C54BC8547EBE9290572", hash_generated_method = "CC27EB38C094FEA4DCA878ACDAFA2BA7")
    public final MappedByteBuffer force() {
        MappedByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1468475517 = null; //Variable for return #1
        {
            try 
            {
                Libcore.os.msync(block.toInt(), block.getSize(), MS_SYNC);
            } //End block
            catch (ErrnoException errnoException)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(errnoException);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1468475517 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1468475517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468475517;
        // ---------- Original Method ----------
        //if (mapMode == MapMode.READ_WRITE) {
            //try {
                //Libcore.os.msync(block.toInt(), block.getSize(), MS_SYNC);
            //} catch (ErrnoException errnoException) {
                //throw new AssertionError(errnoException);
            //}
        //}
        //return this;
    }

    
}

