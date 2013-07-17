package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

abstract class IntArrayBuffer extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.109 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "04E795690AE1E5BC2E4466B25302D831")

    protected int[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.109 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.110 -0400", hash_original_method = "D18B871637BEEEB2AE768346D692C9D7", hash_generated_method = "25468EA3ECB2C85286991D054DD5BEAB")
      IntArrayBuffer(int[] array) {
        this(array.length, array, 0);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.110 -0400", hash_original_method = "64ADCEABF0045F3DCF099C9C9B4F7808", hash_generated_method = "F393261691B5336A002C11C65715A42E")
      IntArrayBuffer(int capacity) {
        this(capacity, new int[capacity], 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.111 -0400", hash_original_method = "8D85757E2A089A86486F1DA1C7B27DB7", hash_generated_method = "8BB268A4C4257A422792D6B23437FFA3")
      IntArrayBuffer(int capacity, int[] backingArray, int offset) {
        super(capacity);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.111 -0400", hash_original_method = "2EA67F38ECDA332174959B54F9DC216E", hash_generated_method = "CB33C4789DDB5B12480FBEAAB1610324")
    @Override
    public final int get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_891443867 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_891443867.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_891443867;
        } //End block
        int varD1A88672373807059A15983DE4C2AC9F_214437243 = (backingArray[offset + position++]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963811166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963811166;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.112 -0400", hash_original_method = "BB46C2F433DB7E33613C9314C6AAA302", hash_generated_method = "A3777E1F466A16D6963C744C4842420A")
    @Override
    public final int get(int index) {
        addTaint(index);
        checkIndex(index);
        int varF4617D5762E2F642102CBB5F4FA87F0A_2093565660 = (backingArray[offset + index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564167172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564167172;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.112 -0400", hash_original_method = "CF9BFE676211E932B27B1BA0A79794E4", hash_generated_method = "54397EB07B7B8EE35A47D37D44537C4C")
    @Override
    public final IntBuffer get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        if(intCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_2010764707 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_2010764707.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_2010764707;
        } //End block
        System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1076850090 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1076850090.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1076850090;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.113 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "061F41B56DEF3C98B610DE8739A259F4")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_1789409026 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947691564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947691564;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.113 -0400", hash_original_method = "A08DEC6C777D2C1D29E23F2F39FEA4AD", hash_generated_method = "CDD1EC3E688B15BB4D9FB78C9582BFF2")
    @Override
    public final ByteOrder order() {
ByteOrder var1B533639214E0AD13A9C318946B77D59_1219688967 =         ByteOrder.nativeOrder();
        var1B533639214E0AD13A9C318946B77D59_1219688967.addTaint(taint);
        return var1B533639214E0AD13A9C318946B77D59_1219688967;
        // ---------- Original Method ----------
        //return ByteOrder.nativeOrder();
    }

    
}

