package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class IntArrayBuffer extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.505 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "04E795690AE1E5BC2E4466B25302D831")

    protected int[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.505 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.506 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "25468EA3ECB2C85286991D054DD5BEAB")
      IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.506 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "F393261691B5336A002C11C65715A42E")
      IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.506 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "D154A8AAAE4754DC986ED05C5486A361")
      IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.533 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "CC3C5E9C4FAA5890C856B2057270A63B")
    @Override
    public final int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683317927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_683317927;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.534 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "6B487C0388B5401D7B48FF6A60D813F4")
    @Override
    public final int get(int index) {
        checkIndex(index);
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146673379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146673379;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.534 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "AF12B1F5E9956292B0606AD0A2F7BAC3")
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_1762453666 = null; //Variable for return #1
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_1707440218 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_1762453666 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_1762453666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762453666;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.534 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "DB989F2DF3894321152BA06B005029B9")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199558300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199558300;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.535 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "A706ECB8C3B40C2AEC8BF0C07838D91B")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_373315481 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_373315481 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_373315481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_373315481;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

