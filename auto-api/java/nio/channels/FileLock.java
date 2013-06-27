package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class FileLock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.514 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.515 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.515 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.515 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.516 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "61492B07ADA6BD789C319D7FA4983B8B")
    protected  FileLock(FileChannel channel, long position, long size, boolean shared) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
        // ---------- Original Method ----------
        //if (position < 0 || size < 0 || position + size < 0) {
            //throw new IllegalArgumentException();
        //}
        //this.channel = channel;
        //this.position = position;
        //this.size = size;
        //this.shared = shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.527 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "D1E1E96D514932A3EEA90775B5EFABC7")
    public final FileChannel channel() {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_549645072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_549645072 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_549645072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_549645072;
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.527 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "29D03F67EF2BB9CC3BC453D4A4D99A3F")
    public final long position() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1418329260 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1418329260;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.527 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "FEED55DE5163FE19EBD67FA104775EFA")
    public final long size() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1392561661 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1392561661;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.528 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "04BE6C54E063C9FA5B32060818E6AEBB")
    public final boolean isShared() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378025075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378025075;
        // ---------- Original Method ----------
        //return shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.529 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "9322BCB5E3D3533D92897D66C9AAD9B0")
    public final boolean overlaps(long start, long length) {
        long end;
        end = position + size - 1;
        long newEnd;
        newEnd = start + length - 1;
        addTaint(start);
        addTaint(length);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015085044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015085044;
        // ---------- Original Method ----------
        //final long end = position + size - 1;
        //final long newEnd = start + length - 1;
        //if (end < start || position > newEnd) {
            //return false;
        //}
        //return true;
    }

    
    public abstract boolean isValid();

    
    public abstract void release() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.533 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "BD8F94FCA37F034C3CFD71A2FAAF2145")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1699217554 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1699217554 = "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1699217554.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1699217554;
        // ---------- Original Method ----------
        //return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }

    
}

