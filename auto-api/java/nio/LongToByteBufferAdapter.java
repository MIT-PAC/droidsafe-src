package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {
    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.808 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "36BE546BCACB52AA7995999FD3B0C305")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private LongToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        dsTaint.addTaint(byteBuffer.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.809 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "F65FEDE3E90E47140E9F26DBDC955807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.809 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "1B71D54EBF9CC2AE2BF443CC3C1FA2AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer compact() {
        {
            boolean varD77B6130B34264A0EF448C4235FCDE48_1947937980 = (byteBuffer.isReadOnly());
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
        return (LongBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.809 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "C4662AA333184F95534BFDA2EB4A617F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer duplicate() {
        ByteBuffer bb;
        bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf;
        buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.810 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "9187BBD1AD7923777BA1967200EE6795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long get() {
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
        } //End block
        long varDCE94F842B30BE56FD0BC4850A846E4B_1854134538 = (byteBuffer.getLong(position++ * SizeOf.LONG));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.810 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "76662BFDC7F6DE606605B32B2282D873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long get(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        long var506B8B5E6E1E832DCB35F22FB6DE70FB_1025102042 = (byteBuffer.getLong(index * SizeOf.LONG));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getLong(index * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.810 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "5FE4F7A8FBD768CE4A59FA12DA35370C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(dstOffset);
        dsTaint.addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        this.position += longCount;
        return (LongBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.810 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "6F25C887C72C5CEDD505CB97D12E6BEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isDirect() {
        boolean var6A38F61B252C327C2F003ABEEAE77D3E_5129381 = (byteBuffer.isDirect());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.810 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "A2E8948B6323EA1F7FFD071D94FCA8DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isReadOnly() {
        boolean varB84E0A3CE12C63F21B1E15D856C3A969_984135730 = (byteBuffer.isReadOnly());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.811 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "E59EC0A904D8A1959AD029BC0A38F424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ByteOrder order() {
        ByteOrder var19C5E1CA5343F3A40725401EF91DEFCC_1970116303 = (byteBuffer.order());
        return (ByteOrder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.811 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "A2EA18D1136A4E27AD9B4C7D764D0F8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected long[] protectedArray() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.811 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "C73FA96390820A77974587B22AF4696E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected int protectedArrayOffset() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.811 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ABBE1C4E781471842A6D95D790DBFBEE")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.811 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "1FD2DCA3F80258229D0CB1DD7195EA26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(long c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putLong(position++ * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.812 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "EC42065E10F48B7F5434F1CB9C7BD375")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(int index, long c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putLong(index * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.812 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "3375193765699BC633F317A38A5B2C65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        this.position += longCount;
        return (LongBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.812 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "2888B753DFF34BA4E57B46135FD66CFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer slice() {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb;
        bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result;
        result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //LongBuffer result = new LongToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

