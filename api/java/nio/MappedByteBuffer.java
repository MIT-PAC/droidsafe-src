package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.channels.FileChannel.MapMode;
import libcore.io.ErrnoException;
import libcore.io.Libcore;
import libcore.io.Memory;
import static libcore.io.OsConstants.*;

public abstract class MappedByteBuffer extends ByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.804 -0400", hash_original_field = "D6ABAEBF6F398D52A8B336BB018AF0B8", hash_generated_field = "D7679EF467A9ABFED1C67E3C246585AB")

    DirectByteBuffer wrapped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.804 -0400", hash_original_field = "54E7387E52E874C96887778FCFC7FAC0", hash_generated_field = "2A1F112DD9317D05E828544B748EF0B7")

    private MapMode mapMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.805 -0400", hash_original_method = "B4624F88D9C5C045F8BDE794FFD519CF", hash_generated_method = "6FC7ED69725E936A6C0418E01B3FE653")
      MappedByteBuffer(ByteBuffer directBuffer) {
        super(directBuffer.capacity, directBuffer.block);
    if(!directBuffer.isDirect())        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1288287207 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1288287207.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1288287207;
        } //End block
        this.wrapped = (DirectByteBuffer) directBuffer;
        this.mapMode = null;
        // ---------- Original Method ----------
        //if (!directBuffer.isDirect()) {
            //throw new IllegalArgumentException();
        //}
        //this.wrapped = (DirectByteBuffer) directBuffer;
        //this.mapMode = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.806 -0400", hash_original_method = "638BC1993DAD17C2741F99B13CBD8BD7", hash_generated_method = "2ABBBCDBFD55D1960409517B4B6C481D")
      MappedByteBuffer(MemoryBlock block, int capacity, int offset, MapMode mapMode) {
        super(capacity, block);
        this.mapMode = mapMode;
    if(mapMode == MapMode.READ_ONLY)        
        {
            wrapped = new ReadOnlyDirectByteBuffer(block, capacity, offset);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.806 -0400", hash_original_method = "C9D4A4A6949ED0E6DB022AC73D44B615", hash_generated_method = "0ACEF6DCB0DD5E54AB92E1B9F620AEE2")
    public final boolean isLoaded() {
        long address = block.toInt();
        long size = block.getSize();
    if(size == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_995824992 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666025929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_666025929;
        } //End block
        try 
        {
            int pageSize = (int) Libcore.os.sysconf(_SC_PAGE_SIZE);
            int pageOffset = (int) (address % pageSize);
            address -= pageOffset;
            size += pageOffset;
            int pageCount = (int) ((size + pageSize - 1) / pageSize);
            byte[] vector = new byte[pageCount];
            Libcore.os.mincore(address, size, vector);
for(int i = 0;i < vector.length;++i)
            {
    if((vector[i] & 1) != 1)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1238948918 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264587879 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264587879;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_720052568 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174812338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174812338;
        } //End block
        catch (ErrnoException errnoException)
        {
            boolean var68934A3E9455FA72420237EB05902327_1007036330 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87622233 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_87622233;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.807 -0400", hash_original_method = "61E403E118E1A4E788B2CC284AD4ABD1", hash_generated_method = "B2B3454BCCD0B9246CCB95CB61CA93E6")
    public final MappedByteBuffer load() {
        try 
        {
            Libcore.os.mlock(block.toInt(), block.getSize());
            Libcore.os.munlock(block.toInt(), block.getSize());
        } //End block
        catch (ErrnoException ignored)
        {
        } //End block
MappedByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1152484532 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1152484532.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1152484532;
        // ---------- Original Method ----------
        //try {
            //Libcore.os.mlock(block.toInt(), block.getSize());
            //Libcore.os.munlock(block.toInt(), block.getSize());
        //} catch (ErrnoException ignored) {
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.808 -0400", hash_original_method = "F84161825A8E4C54BC8547EBE9290572", hash_generated_method = "36E014600139C39BB032FAECBBAC9568")
    public final MappedByteBuffer force() {
    if(mapMode == MapMode.READ_WRITE)        
        {
            try 
            {
                Libcore.os.msync(block.toInt(), block.getSize(), MS_SYNC);
            } //End block
            catch (ErrnoException errnoException)
            {
                AssertionError var8D75DBC63153835F7D08A31E99200A1F_1619096995 = new AssertionError(errnoException);
                var8D75DBC63153835F7D08A31E99200A1F_1619096995.addTaint(taint);
                throw var8D75DBC63153835F7D08A31E99200A1F_1619096995;
            } //End block
        } //End block
MappedByteBuffer var72A74007B2BE62B849F475C7BDA4658B_142115960 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_142115960.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_142115960;
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

