package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.756 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "FBE6D4444647FC0D91F17CC3B3839210")
      ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.757 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "D5824848B8F8069FF2A536AD7318DD6E")
      ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.757 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "B4197CE0626BFED899EC8E81591F4CD1")
      ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.757 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "85CE4E1EABFAC052D5D4943A3344BF81")
    @Override
    public IntBuffer asReadOnlyBuffer() {
IntBuffer var27CE609FBF62030B05AE33DF0C3AF2E2_1321892644 =         ReadOnlyIntArrayBuffer.copy(this, mark);
        var27CE609FBF62030B05AE33DF0C3AF2E2_1321892644.addTaint(taint);
        return var27CE609FBF62030B05AE33DF0C3AF2E2_1321892644;
        // ---------- Original Method ----------
        //return ReadOnlyIntArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.758 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "E65ECCC6A596B7BA14E82F58DFD543D1")
    @Override
    public IntBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_702587103 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_702587103.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_702587103;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.758 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "488A1E7B1DF7E8C1C307627F29D26247")
    @Override
    public IntBuffer duplicate() {
IntBuffer var6ED4708F04CD11720ECFFDBFD927116F_39198345 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_39198345.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_39198345;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.758 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "36369CA46092FFFBE840990A22C16CF7")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_851414688 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322195442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322195442;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.759 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "73196A24E341B012106CECCBFB5AEFD1")
    @Override
    protected int[] protectedArray() {
        int[] var8D50CD27AA8B6BEC65C484FFCC5B2334_508856378 = (backingArray);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1534984661 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1534984661;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.759 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "8A36585902BCCA760E2C64402AA4FFF0")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1210716879 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431939466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431939466;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.759 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "14322E08F75AADB7867FB4BAF274579B")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_905511695 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1553552050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1553552050;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.760 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "C3EFA3A10859CC123DE5CA48B043919B")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1608800154 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1608800154.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1608800154;
        } //End block
        backingArray[offset + position++] = c;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_296104377 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_296104377.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_296104377;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.760 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "7C96F8D8CD60B7F211185B76E88E286A")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_593546681 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_593546681.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_593546681;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.761 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "2EA89F46509448139BD2913AE48A458A")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        if(intCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1469517705 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1469517705.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1469517705;
        } //End block
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_413610508 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_413610508.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_413610508;
        // ---------- Original Method ----------
        //if (intCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        //position += intCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.761 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "56CBC7B70AF60C136092843EDF7F1D4D")
    @Override
    public IntBuffer slice() {
IntBuffer varA43FC06BBC64B3D53A6DC8E7E28077E2_1832240049 =         new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
        varA43FC06BBC64B3D53A6DC8E7E28077E2_1832240049.addTaint(taint);
        return varA43FC06BBC64B3D53A6DC8E7E28077E2_1832240049;
        // ---------- Original Method ----------
        //return new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

