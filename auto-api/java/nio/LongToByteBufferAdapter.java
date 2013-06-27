package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.745 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.755 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "57E6A47D4A49ACF7C2EEBE80CADCBC3B")
    private  LongToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
        static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new LongToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.756 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "DFA5B138923EF985E1121BDB91735B38")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_304828282 = null; //Variable for return #1
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_304828282 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_304828282.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304828282;
        // ---------- Original Method ----------
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.757 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "C59788FBC985D3C0285E87AF47BFCF16")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1812302727 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_993540862 = (byteBuffer.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1812302727 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1812302727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1812302727;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.764 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "49CDDE129CACB8CC2B0F305B57AFCA0C")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1226773749 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1226773749 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1226773749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226773749;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.765 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "4C79A22986126B5738D130CC396BB864")
    @Override
    public long get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        long varDCE94F842B30BE56FD0BC4850A846E4B_307140269 = (byteBuffer.getLong(position++ * SizeOf.LONG));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_439426104 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_439426104;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.765 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "22C15C03205E95D258040CD798DAE815")
    @Override
    public long get(int index) {
        checkIndex(index);
        long var506B8B5E6E1E832DCB35F22FB6DE70FB_825325774 = (byteBuffer.getLong(index * SizeOf.LONG));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1775875936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1775875936;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getLong(index * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.773 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "C9E76450FD01CFFCA510A3FB364B774C")
    @Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_646933257 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_646933257 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_646933257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646933257;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        //}
        //this.position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.773 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "95240A01AB6C6BCC59F5A4E666B320F6")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_371656117 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481053030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481053030;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.773 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "885814EA3F623E93ABF66E346AC1E213")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_280549647 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352284369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352284369;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.774 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "C458C27AA252FE0E2EEE663FD6AF22D5")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_1211900990 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1211900990 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_1211900990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1211900990;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.774 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "BE936000001CDD2CCF5CCFBCACA25B8D")
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1939114836 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1939114836;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.774 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "2D46D971D08B6C886826ECCED1699063")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798704658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1798704658;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.774 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "51A3E304C62888F2B79C2EA0FA36BE29")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1590132845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1590132845;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.790 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "E7B2BFD14320932239312D4799FBBFE6")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_582940014 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_582940014 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_582940014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582940014;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putLong(position++ * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.790 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "87659AD197EAAB9D40CA4BF0DFD0A25E")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_384528616 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_384528616 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_384528616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_384528616;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putLong(index * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.791 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "323D97096918BC3A4635200710E0FA89")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_473552852 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_473552852 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_473552852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_473552852;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        //}
        //this.position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.802 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "044EBBE465AF0BDD87940B2936475800")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_916742131 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result;
        result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_916742131 = result;
        varB4EAC82CA7396A68D541C85D26508E83_916742131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916742131;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //LongBuffer result = new LongToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

