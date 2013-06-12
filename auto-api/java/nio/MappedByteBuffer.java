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
    DirectByteBuffer wrapped;
    private MapMode mapMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.277 -0400", hash_original_method = "B4624F88D9C5C045F8BDE794FFD519CF", hash_generated_method = "B1F94ADF82334D450DE0CECE7C225970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MappedByteBuffer(ByteBuffer directBuffer) {
        super(directBuffer.capacity, directBuffer.block);
        dsTaint.addTaint(directBuffer.dsTaint);
        {
            boolean varDC8DBD478B08EB0C265C25CC94CB6B1C_1519942322 = (!directBuffer.isDirect());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.283 -0400", hash_original_method = "638BC1993DAD17C2741F99B13CBD8BD7", hash_generated_method = "7C46F88A65073230A71A304057EE6EDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     MappedByteBuffer(MemoryBlock block, int capacity, int offset, MapMode mapMode) {
        super(capacity, block);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(mapMode.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.294 -0400", hash_original_method = "C9D4A4A6949ED0E6DB022AC73D44B615", hash_generated_method = "C3BE1FDC9BE666F6DCAD7429052A13BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.304 -0400", hash_original_method = "61E403E118E1A4E788B2CC284AD4ABD1", hash_generated_method = "2FDE652F2C5993E597A10A266703875F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MappedByteBuffer load() {
        try 
        {
            Libcore.os.mlock(block.toInt(), block.getSize());
            Libcore.os.munlock(block.toInt(), block.getSize());
        } //End block
        catch (ErrnoException ignored)
        { }
        return (MappedByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mlock(block.toInt(), block.getSize());
            //Libcore.os.munlock(block.toInt(), block.getSize());
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.306 -0400", hash_original_method = "F84161825A8E4C54BC8547EBE9290572", hash_generated_method = "8AAD7AC172369804A4C7B2877FB4AF0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final MappedByteBuffer force() {
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
        return (MappedByteBuffer)dsTaint.getTaint();
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


