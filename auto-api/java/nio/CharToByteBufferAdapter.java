package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class CharToByteBufferAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.076 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.083 -0400", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "7B64404964C0A8F96913AC03401200AD")
    private  CharToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.CHAR);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new CharToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.084 -0400", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "8111EFD6A7CFDEE49E63012BE2BB8012")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1881019857 = null; //Variable for return #1
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1881019857 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1881019857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1881019857;
        // ---------- Original Method ----------
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.085 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "9EE2AFFEA564FAE627EE3C1DC6D88F9D")
    @Override
    public CharBuffer compact() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1138195883 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1613900269 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1138195883 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1138195883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1138195883;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.085 -0400", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "5E2A641466E129C48CD2CD12AD679A88")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_2024409248 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_2024409248 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_2024409248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2024409248;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.092 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "E6AFBFF2D8BCD66F0B29FF4321CBDCDF")
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char varA3995E5AEF4DE9E279E678289D32918E_373810310 = (byteBuffer.getChar(position++ * SizeOf.CHAR));
        char varA87DEB01C5F539E6BDA34829C8EF2368_858080650 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_858080650;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.093 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "6092BED803C5C652AA478DD987FFB6BB")
    @Override
    public char get(int index) {
        checkIndex(index);
        char var0C79692AD26E6EBE72EB349871353E9E_1736492835 = (byteBuffer.getChar(index * SizeOf.CHAR));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1257262238 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1257262238;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.094 -0400", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "C298F1F7EAB72195E4958797BE2E54F0")
    @Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1851099382 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        this.position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_1851099382 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1851099382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851099382;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.094 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "97C6A036A1D8163C5BFC614B7382B2BD")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_876486585 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356957536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356957536;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.095 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "7991E6F5269FD84A0D9F4A63C0894671")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1996619445 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048114839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048114839;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.095 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "FF865C99E845B8B64621A61F259023DD")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_2123351624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2123351624 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_2123351624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2123351624;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.114 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "A78663D9E02CB91FCB7CE9E0EB357E59")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_565174835 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_565174835;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.114 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "E57672F28FA98CA20DE859FDC19D8B46")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990942005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990942005;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.114 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "D973D7483E9B78AA52244AB07F02AC05")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805296851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805296851;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.115 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "780F96D6374448B4FF9336B90EBEE830")
    @Override
    public CharBuffer put(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_424115196 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        varB4EAC82CA7396A68D541C85D26508E83_424115196 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_424115196.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_424115196;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.115 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "E1F75F38BFAB39FC429B17233DB53F4D")
    @Override
    public CharBuffer put(int index, char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1002555981 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
        varB4EAC82CA7396A68D541C85D26508E83_1002555981 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1002555981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1002555981;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putChar(index * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.116 -0400", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "959347B93196CB30CDC7218A1783DEDB")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1362848358 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        this.position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_1362848358 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_1362848358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362848358;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.124 -0400", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "AFC940ECE55F21F59A9B92659577F526")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_584251171 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result;
        result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_584251171 = result;
        varB4EAC82CA7396A68D541C85D26508E83_584251171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_584251171;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //CharBuffer result = new CharToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.124 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "31EFB92B39D75CF19ACE9B4B9B4ACA3F")
    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_816126739 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharBuffer result;
        result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        varB4EAC82CA7396A68D541C85D26508E83_816126739 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_816126739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_816126739;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
}

