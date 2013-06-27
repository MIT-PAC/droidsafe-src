package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.951 -0400", hash_original_method = "C217C684C5DFBD85DAC953DA8CC4F355", hash_generated_method = "93F2DD63715923600709B7631E351B21")
      ReadOnlyLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        // ---------- Original Method ----------
    }

    
        static ReadOnlyLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadOnlyLongArrayBuffer buf =
                new ReadOnlyLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.951 -0400", hash_original_method = "9283ADC80310F7E479295F96D960F17D", hash_generated_method = "EAA75331BC113ADA89CD4BFCF10A2805")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_220524299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_220524299 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_220524299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_220524299;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.952 -0400", hash_original_method = "0AF2CD05C541DF81A768714F9C7047F3", hash_generated_method = "0261403F38597F486CC0FE43BF14B03D")
    @Override
    public LongBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.952 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "12B64E9F342CAA8112340F7684F7049F")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_486477095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_486477095 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_486477095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_486477095;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.953 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "D89C07DDE031E79CB1E2DBFC9144B8F8")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934285666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_934285666;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.953 -0400", hash_original_method = "4182362C5B9492F840FDEB2D9E41E07C", hash_generated_method = "B1B24AFA9AEA8A58CDE7223480BCB29D")
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1141371342 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1141371342;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.961 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "C4AEA020A43180844DBDF9E1C21A7B01")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564164072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564164072;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.961 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "58410CEFC8FDCB90FFA72E589FF4B377")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797164750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797164750;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.961 -0400", hash_original_method = "7393DFCF52569FCC2605F08F020574B2", hash_generated_method = "07375FFB098B6397D97C45485E4069D9")
    @Override
    public LongBuffer put(long c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.962 -0400", hash_original_method = "E5FA3278A640CB37396E7D9BDEEA6C53", hash_generated_method = "304BEC084591573323972DB4A9B4E108")
    @Override
    public LongBuffer put(int index, long c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.962 -0400", hash_original_method = "30B5D6EAC290C108C17070B0EA497381", hash_generated_method = "81C3342B3DE08F9D9C3266938728ABE0")
    @Override
    public LongBuffer put(LongBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.962 -0400", hash_original_method = "216FEF8EB820A47DE670615020EB98B3", hash_generated_method = "4C920EA1F4A6C569999747418AF487C8")
    @Override
    public final LongBuffer put(long[] src, int srcOffset, int longCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.980 -0400", hash_original_method = "B55D734F8AFBBB86296CAB7433B17B3B", hash_generated_method = "844A8755CD3327BA0467CF53FAE72D9E")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_761800906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_761800906 = new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_761800906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_761800906;
        // ---------- Original Method ----------
        //return new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

