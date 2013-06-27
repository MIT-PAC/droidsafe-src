package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class CharToByteBufferAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.076 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.086 -0400", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "7B64404964C0A8F96913AC03401200AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.087 -0400", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "033B40AA996CFA2B97C96B4063EC0F4A")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_581508984 = null; //Variable for return #1
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_581508984 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_581508984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_581508984;
        // ---------- Original Method ----------
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.088 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "627990DA2822FB6E45F2A3E7C5D7F3DC")
    @Override
    public CharBuffer compact() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_767101495 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_2034934281 = (byteBuffer.isReadOnly());
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
        varB4EAC82CA7396A68D541C85D26508E83_767101495 = this;
        varB4EAC82CA7396A68D541C85D26508E83_767101495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_767101495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.105 -0400", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "C4BD9A709BA0812242EC213ED47DC878")
    @Override
    public CharBuffer duplicate() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1338426760 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf;
        buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1338426760 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1338426760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338426760;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.105 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "866EA24A69B763F6B8304E2A761F4542")
    @Override
    public char get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        char varA3995E5AEF4DE9E279E678289D32918E_230251130 = (byteBuffer.getChar(position++ * SizeOf.CHAR));
        char varA87DEB01C5F539E6BDA34829C8EF2368_703196540 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_703196540;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.105 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "6F856A5782E851F369783705093A87B8")
    @Override
    public char get(int index) {
        checkIndex(index);
        char var0C79692AD26E6EBE72EB349871353E9E_779573769 = (byteBuffer.getChar(index * SizeOf.CHAR));
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1663876170 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1663876170;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.107 -0400", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "764490C6E9E4357EFDEBED44197466A2")
    @Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_415471201 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        this.position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_415471201 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_415471201.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_415471201;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.107 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "E02FF5C1ED6D1D41D2D275A87D84F15F")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_640646900 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924301070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_924301070;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.125 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "0B2A1F306B78BEED74126E3B75A9C9EC")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_1561300435 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247995787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247995787;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.126 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "C9BBB04A7DC37EE4263C58FBED954A53")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1855868593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1855868593 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_1855868593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1855868593;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.127 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "53128DDF1607A3E3EDD4A5357A18A7E9")
    @Override
    protected char[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_819400998 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_819400998;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.127 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "541BE54E82115D034C937C7C11A4CB82")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129869872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129869872;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.127 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "FA9FEF1A82873D301D0FF7FA478AE4A5")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067620951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067620951;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.128 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "2AAFAFB37EC76F6507631AE41678D0D7")
    @Override
    public CharBuffer put(char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_704306367 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        varB4EAC82CA7396A68D541C85D26508E83_704306367 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_704306367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_704306367;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.129 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "B8269D659625B82BA6EC86B2DCB29C8C")
    @Override
    public CharBuffer put(int index, char c) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_560490401 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
        varB4EAC82CA7396A68D541C85D26508E83_560490401 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_560490401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560490401;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putChar(index * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.145 -0400", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "3C2649D542B441F030D46A62D1B3F1EF")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_956625249 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        this.position += charCount;
        varB4EAC82CA7396A68D541C85D26508E83_956625249 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(charCount);
        varB4EAC82CA7396A68D541C85D26508E83_956625249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_956625249;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.146 -0400", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "E79BB69F0F779198694DAC835917991F")
    @Override
    public CharBuffer slice() {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_662765856 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result;
        result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_662765856 = result;
        varB4EAC82CA7396A68D541C85D26508E83_662765856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_662765856;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //CharBuffer result = new CharToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.146 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "0AC449F15E14C4C7C76BDA78C1D903AE")
    @Override
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1330966366 = null; //Variable for return #1
        checkStartEndRemaining(start, end);
        CharBuffer result;
        result = duplicate();
        result.limit(position + end);
        result.position(position + start);
        varB4EAC82CA7396A68D541C85D26508E83_1330966366 = result;
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1330966366.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330966366;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
}

