package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.159 -0400", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "FBE6D4444647FC0D91F17CC3B3839210")
      ReadWriteIntArrayBuffer(int[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.160 -0400", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "D5824848B8F8069FF2A536AD7318DD6E")
      ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.160 -0400", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "B4197CE0626BFED899EC8E81591F4CD1")
      ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(arrayOffset);
        addTaint(backingArray[0]);
        addTaint(capacity);
        
    }

    
        static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.161 -0400", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "549D76CFCF803859342C0305ED3EDEED")
    @Override
    public IntBuffer asReadOnlyBuffer() {
IntBuffer var27CE609FBF62030B05AE33DF0C3AF2E2_1253348701 =         ReadOnlyIntArrayBuffer.copy(this, mark);
        var27CE609FBF62030B05AE33DF0C3AF2E2_1253348701.addTaint(taint);
        return var27CE609FBF62030B05AE33DF0C3AF2E2_1253348701;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.162 -0400", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "EF6F369C7EE0FE9C4F1CD13C9815A5B8")
    @Override
    public IntBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_83833569 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_83833569.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_83833569;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.162 -0400", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "7CF30CD2A3B4CAEF10C9AED66E52AF94")
    @Override
    public IntBuffer duplicate() {
IntBuffer var6ED4708F04CD11720ECFFDBFD927116F_3723741 =         copy(this, mark);
        var6ED4708F04CD11720ECFFDBFD927116F_3723741.addTaint(taint);
        return var6ED4708F04CD11720ECFFDBFD927116F_3723741;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.162 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "5AD1EE2BBA43389CF6888D55254ACA35")
    @Override
    public boolean isReadOnly() {
        boolean var68934A3E9455FA72420237EB05902327_1528136679 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283455459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_283455459;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.163 -0400", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "A8F8474A2290D91DEA2FB3ECA322AE0D")
    @Override
    protected int[] protectedArray() {
        int[] var8D50CD27AA8B6BEC65C484FFCC5B2334_1379379578 = (backingArray);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_993827826 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_993827826;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.163 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "89620A89FB351AA3A24918F06FB71C36")
    @Override
    protected int protectedArrayOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1184588618 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817513353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817513353;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.163 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "587230C9B5FC79867A587A7D6AAE8EA8")
    @Override
    protected boolean protectedHasArray() {
        boolean varB326B5062B2F0E69046810717534CB09_600091829 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862885103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862885103;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.164 -0400", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "FAF6A58A9472770E1DE00EEA5DCE54E5")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1729799443 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1729799443.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1729799443;
        } 
        backingArray[offset + position++] = c;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_947549324 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_947549324.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_947549324;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.164 -0400", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "3888F5F075CF009EC7F6C5F82E6D388D")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        backingArray[offset + index] = c;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1747980618 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1747980618.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1747980618;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.165 -0400", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "D207C289190BC07937C2EF8C0557F609")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
    if(intCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_967590445 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_967590445.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_967590445;
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_2035572713 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2035572713.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2035572713;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.165 -0400", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "80F7CA96B1CA8A7A01DC3621AADB7654")
    @Override
    public IntBuffer slice() {
IntBuffer varA43FC06BBC64B3D53A6DC8E7E28077E2_191016198 =         new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
        varA43FC06BBC64B3D53A6DC8E7E28077E2_191016198.addTaint(taint);
        return varA43FC06BBC64B3D53A6DC8E7E28077E2_191016198;
        
        
    }

    
}

