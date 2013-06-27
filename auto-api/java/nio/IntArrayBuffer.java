package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class IntArrayBuffer extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.597 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "04E795690AE1E5BC2E4466B25302D831")

    protected int[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.597 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.597 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "25468EA3ECB2C85286991D054DD5BEAB")
      IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.597 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "F393261691B5336A002C11C65715A42E")
      IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.607 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "D154A8AAAE4754DC986ED05C5486A361")
      IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.608 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "348D729E03AE08BB35B42DD0A8A2943B")
    @Override
    public final int get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564939333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564939333;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.608 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "818CBD8BC2F7301C3E714C75BE45D2E2")
    @Override
    public final int get(int index) {
        checkIndex(index);
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934921456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934921456;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.609 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "1D771DB24B4D52B3DDF7712A302844C0")
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        IntBuffer varB4EAC82CA7396A68D541C85D26508E83_818216210 = null; //Variable for return #1
        {
            boolean var88D58DBFE8E26BEBC18FDE3265CF76EF_706636680 = (intCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
        varB4EAC82CA7396A68D541C85D26508E83_818216210 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(intCount);
        varB4EAC82CA7396A68D541C85D26508E83_818216210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_818216210;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.609 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "88E81FF45FA8BCD901F431118AAFACCE")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1270743984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1270743984;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.620 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "034581FB22F916B719BC80115AEEA22E")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_2145848252 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2145848252 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_2145848252.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145848252;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

