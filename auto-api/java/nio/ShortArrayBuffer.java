package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class ShortArrayBuffer extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.398 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "D6BFE43B0E3E7A05E4F673EAC5DBB347")

    protected short[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.398 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.398 -0400", hash_original_method = "2309FEF74B5324CE6644430AA32CE10F", hash_generated_method = "FF0F9A06C16F267BF5CA0F550B350245")
      ShortArrayBuffer(short[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.398 -0400", hash_original_method = "83C4FE898A0AB05D8AFE678BFD611891", hash_generated_method = "1665ACB846300A3BE1C2B7D1195FF044")
      ShortArrayBuffer(int capacity) {
        this(capacity, new short[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.398 -0400", hash_original_method = "6241269CB95A33BDF406F3571CF80FE7", hash_generated_method = "3175BB77919E9E2635EF1BE8755F8B3B")
      ShortArrayBuffer(int capacity, short[] backingArray, int offset) {
        super(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        addTaint(capacity);
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.399 -0400", hash_original_method = "3107E6B251B23EDC44F5CD8DFDAAC4B8", hash_generated_method = "404320596BE664538C296A1292BB01A9")
    @Override
    public final short get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        short var4F09DAA9D95BCB166A302407A0E0BABE_436084211 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_436084211;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.399 -0400", hash_original_method = "C45D95B915B8493973D4F3C69BA81F93", hash_generated_method = "72C73419A410C0A7CF827F4EE47F9524")
    @Override
    public final short get(int index) {
        checkIndex(index);
        addTaint(index);
        short var4F09DAA9D95BCB166A302407A0E0BABE_479906691 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_479906691;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.400 -0400", hash_original_method = "89DFF38986FFC53F43866053D7635804", hash_generated_method = "EFD39D9AC2AA3E2642D59E532DFF266C")
    @Override
    public final ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        ShortBuffer varB4EAC82CA7396A68D541C85D26508E83_1544202352 = null; //Variable for return #1
        {
            boolean varD727A1D2181C264BA4333582F807AE27_402112836 = (shortCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        position += shortCount;
        varB4EAC82CA7396A68D541C85D26508E83_1544202352 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(shortCount);
        varB4EAC82CA7396A68D541C85D26508E83_1544202352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544202352;
        // ---------- Original Method ----------
        //if (shortCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, shortCount);
        //position += shortCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.400 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "68B4A13D692362169F31E7CE7DEC170E")
    @Override
    public final boolean isDirect() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337615527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337615527;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.401 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "AEF6376A3BD47B0E39E4C283C3E39858")
    @Override
    public final ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_573760899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_573760899 = ByteOrder.nativeOrder();
        varB4EAC82CA7396A68D541C85D26508E83_573760899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573760899;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

