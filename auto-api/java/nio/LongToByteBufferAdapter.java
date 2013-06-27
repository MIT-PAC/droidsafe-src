package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.770 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.771 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "57E6A47D4A49ACF7C2EEBE80CADCBC3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.772 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "DE5698FECB8A627C6D32FC853199CFD7")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1801976317 = null; //Variable for return #1
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        varB4EAC82CA7396A68D541C85D26508E83_1801976317 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_1801976317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1801976317;
        // ---------- Original Method ----------
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.784 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "45117C99CD54CAF1C86B5A2CB2275B6D")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_109686001 = null; //Variable for return #1
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1333787852 = (byteBuffer.isReadOnly());
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
        varB4EAC82CA7396A68D541C85D26508E83_109686001 = this;
        varB4EAC82CA7396A68D541C85D26508E83_109686001.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_109686001;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.784 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "143E6F4FCE365FADD05E8B4AA5067BC6")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_402416672 = null; //Variable for return #1
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        varB4EAC82CA7396A68D541C85D26508E83_402416672 = buf;
        varB4EAC82CA7396A68D541C85D26508E83_402416672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402416672;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.784 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "3D6066F85D9259C952B679E893542E8D")
    @Override
    public long get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        long varDCE94F842B30BE56FD0BC4850A846E4B_1818370117 = (byteBuffer.getLong(position++ * SizeOf.LONG));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1250229885 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1250229885;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.791 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "1DCCD35B54EEF1DA187E028DDCC03712")
    @Override
    public long get(int index) {
        checkIndex(index);
        long var506B8B5E6E1E832DCB35F22FB6DE70FB_1500731048 = (byteBuffer.getLong(index * SizeOf.LONG));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_569135361 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_569135361;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getLong(index * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.792 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "D97EC7041C4463BB0F9E0B771FEDF892")
    @Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1853129168 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1853129168 = this;
        addTaint(dst[0]);
        addTaint(dstOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1853129168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853129168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.793 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "64899523005A89EA6A74555BF2240F8E")
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_1142171529 = (byteBuffer.isDirect());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593701268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593701268;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.793 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "32F899117004418C6FF6C316B808EA99")
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_602341703 = (byteBuffer.isReadOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912596498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912596498;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.803 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "0E9A859251C4E3CE26A5468901DEDC47")
    @Override
    public ByteOrder order() {
        ByteOrder varB4EAC82CA7396A68D541C85D26508E83_805092126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_805092126 = byteBuffer.order();
        varB4EAC82CA7396A68D541C85D26508E83_805092126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_805092126;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.803 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "EADABB4D77DD513BB51F4CFF85A97C39")
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_598588166 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_598588166;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.807 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "CDE71FF5DA62DFD77F7D1A4FDC412866")
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318057500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318057500;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.807 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "11A18A3C21C4D2B2A8CA370C473E5E7F")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105183952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105183952;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.808 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "857B8412C4673E73FA189A86654751C5")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_281862880 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_281862880 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_281862880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_281862880;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putLong(position++ * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.808 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "BF37467406B8B99A79C82904C2F0201C")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1283788262 = null; //Variable for return #1
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        varB4EAC82CA7396A68D541C85D26508E83_1283788262 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1283788262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283788262;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putLong(index * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.809 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "40CA4B4DD8C96ADA69E622F76D2404CA")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1542236941 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        this.position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1542236941 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1542236941.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1542236941;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.821 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "9413A797AFEEA1F54568E10D5A6C13E5")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1678707064 = null; //Variable for return #1
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result;
        result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
        varB4EAC82CA7396A68D541C85D26508E83_1678707064 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1678707064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678707064;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //LongBuffer result = new LongToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

