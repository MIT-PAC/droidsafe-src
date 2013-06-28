package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class IntArrayBuffer extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.471 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "04E795690AE1E5BC2E4466B25302D831")

    protected int[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.471 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.472 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "25468EA3ECB2C85286991D054DD5BEAB")
      IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.472 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "F393261691B5336A002C11C65715A42E")
      IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.472 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "D154A8AAAE4754DC986ED05C5486A361")
      IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.472 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "AC60D199AEAD3C99BE4311A85B335BB9")
    @Override
    public final int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499795277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499795277;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.473 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "B5DEC08952EB909F0B14000B012C1D2B")
    @Override
    public final int get(int index) {
        checkIndex(index);
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895368068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895368068;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.474 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "6455F637C3FE2207BB47B5D23E1CFFAE")
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1391593268 = null; //Variable for return #1
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1775194203 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1391593268 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1391593268.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391593268;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.474 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "558B111F051E0647612E4446EA42F1A9")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201242537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201242537;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:55.475 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "40484277E926459A63881B5B3CD4A528")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_240733672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_240733672 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_240733672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240733672;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

