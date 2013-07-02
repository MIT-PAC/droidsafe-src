package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class ReadWriteCharArrayBuffer extends CharArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.001 -0400", hash_original_method = "0630B531F09F4BDCAC95566C749465B0", hash_generated_method = "B6FB4023B182229615CC0744C948C988")
      ReadWriteCharArrayBuffer(char[] array) {
        super(array);
        addTaint(array[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.002 -0400", hash_original_method = "818D04612A5488A8EF47518DF8152754", hash_generated_method = "6F7DBD898BDA1001DEF746EF80CCC230")
      ReadWriteCharArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.002 -0400", hash_original_method = "44E079FDDD8CFD80B0248AA4E3DA3A3F", hash_generated_method = "7311D068D571957BB4530D893DE1BB74")
      ReadWriteCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
        
    }

    
    @DSModeled(DSC.SAFE)
    static ReadWriteCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadWriteCharArrayBuffer buf =
                new ReadWriteCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.003 -0400", hash_original_method = "ACF2009427E3EF6DAD4B7F3E78A7296D", hash_generated_method = "DBCC6DC628F8921C17E61C6F7485385C")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_367393792 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_367393792 = ReadOnlyCharArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_367393792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_367393792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.005 -0400", hash_original_method = "2217DC8E6F603B0A8DFB635A1BB06CA2", hash_generated_method = "D14E336ABA01F44025142CE099F18C00")
    @Override
    public CharBuffer compact() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_263516518 = null; 
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_263516518 = this;
        varB4EAC82CA7396A68D541C85D26508E83_263516518.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_263516518;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.007 -0400", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "750F4040742CAC91EEDC8DDC07A1035F")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1961825736 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1961825736 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_1961825736.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1961825736;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.008 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "FB2DABFBC5EEE0DEFDAC352772D543AB")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930358236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930358236;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.009 -0400", hash_original_method = "6989B404B9CBE6C8C0C27A3F3280C746", hash_generated_method = "1773362A33228C654503FE2C00B78E4C")
    @Override
    protected char[] protectedArray() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_749613641 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_749613641;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.011 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "57C2F6A1D8C5CC60ABF393DEED992527")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797244593 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797244593;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.012 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "E0388DFE61ACE62F0088CBC5AB591A0B")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100576901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100576901;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.013 -0400", hash_original_method = "BCF668C88F0582882A83FAE19696C98E", hash_generated_method = "DBF26A2ED4ACBA1D4CC23C951BB8E6E0")
    @Override
    public CharBuffer put(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_269148675 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } 
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_269148675 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_269148675.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_269148675;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.013 -0400", hash_original_method = "F160357793F9CF9C4361A956C61F810C", hash_generated_method = "086119159C61B1BB6ED0AE9704860AF2")
    @Override
    public CharBuffer put(int index, char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_697470406 = null; 
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_697470406 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_697470406.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_697470406;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.014 -0400", hash_original_method = "F185C844C40257FD948EFFAB7DA8DE68", hash_generated_method = "3F4D2BB871721FAAF496B257A9E7267C")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1415321096 = null; 
        {
            boolean varD6CE167C3592D038C7B14F59C84C4F0D_1154807161 = (charCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } 
        } 
        System.arraycopy(src, srcOffset, backingArray, offset + position, charCount);
        position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_1415321096 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1415321096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1415321096;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.015 -0400", hash_original_method = "B445BD4E0B93C5941BD1A67927E72611", hash_generated_method = "39356429EF0051D8AF1F76EBD1449C7E")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_496491073 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_496491073 = new ReadWriteCharArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_496491073.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_496491073;
        
        
    }

    
}

