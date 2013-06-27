package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadOnlyLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.022 -0400", hash_original_method = "C217C684C5DFBD85DAC953DA8CC4F355", hash_generated_method = "93F2DD63715923600709B7631E351B21")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.022 -0400", hash_original_method = "9283ADC80310F7E479295F96D960F17D", hash_generated_method = "9D50939CD25A5BA518FAEBCD6EF9BCC6")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_161114009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_161114009 = duplicate();
        varB4EAC82CA7396A68D541C85D26508E83_161114009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_161114009;
        // ---------- Original Method ----------
        //return duplicate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.023 -0400", hash_original_method = "0AF2CD05C541DF81A768714F9C7047F3", hash_generated_method = "0261403F38597F486CC0FE43BF14B03D")
    @Override
    public LongBuffer compact() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.023 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "3E5BA80A5A6BD8CB113FBA05EA294222")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_509165380 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_509165380 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_509165380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_509165380;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.024 -0400", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "B78134C0AF5A7E8FC1BA7DA323711A58")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818795166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_818795166;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.024 -0400", hash_original_method = "4182362C5B9492F840FDEB2D9E41E07C", hash_generated_method = "31D390D48084B4CAD9FC91DCD21E8259")
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_986076038 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_986076038;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.025 -0400", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "F17E23959F3F2F552342620EBC2FBA86")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452559299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452559299;
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.040 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "46FCAF119D766E47719397874084F83A")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986620451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986620451;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.041 -0400", hash_original_method = "7393DFCF52569FCC2605F08F020574B2", hash_generated_method = "07375FFB098B6397D97C45485E4069D9")
    @Override
    public LongBuffer put(long c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.048 -0400", hash_original_method = "E5FA3278A640CB37396E7D9BDEEA6C53", hash_generated_method = "304BEC084591573323972DB4A9B4E108")
    @Override
    public LongBuffer put(int index, long c) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(index);
        addTaint(c);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.049 -0400", hash_original_method = "30B5D6EAC290C108C17070B0EA497381", hash_generated_method = "81C3342B3DE08F9D9C3266938728ABE0")
    @Override
    public LongBuffer put(LongBuffer buf) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.049 -0400", hash_original_method = "216FEF8EB820A47DE670615020EB98B3", hash_generated_method = "4C920EA1F4A6C569999747418AF487C8")
    @Override
    public final LongBuffer put(long[] src, int srcOffset, int longCount) {
        if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        // ---------- Original Method ----------
        //throw new ReadOnlyBufferException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.050 -0400", hash_original_method = "B55D734F8AFBBB86296CAB7433B17B3B", hash_generated_method = "55B1DBB00F1EA7232987E749154BFA3F")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_933467545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_933467545 = new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_933467545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933467545;
        // ---------- Original Method ----------
        //return new ReadOnlyLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

