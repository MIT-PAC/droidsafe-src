package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class LongToByteBufferAdapter extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.786 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.787 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "57E6A47D4A49ACF7C2EEBE80CADCBC3B")
    private  LongToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.LONG);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        
        
        
        
    }

    
        static LongBuffer asLongBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new LongToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.788 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "33BDC27BF0F3A94BF7F0234121F4BD9C")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
LongBuffer var0D8E466677B8F245666E1A4B1E0924E6_623597668 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_623597668.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_623597668;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.789 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "B41AF4B97F4000937B2F7FC58631B7E8")
    @Override
    public LongBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_778321033 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_778321033.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_778321033;
        } 
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1319450499 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1319450499.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1319450499;
        
        
            
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.790 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "398AB6479ADC1B130EDD137ABE7C0642")
    @Override
    public LongBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
LongBuffer var0D8E466677B8F245666E1A4B1E0924E6_392604442 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_392604442.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_392604442;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.790 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "D212E8D6DE2C88115B1B283831BE879A")
    @Override
    public long get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_798741601 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_798741601.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_798741601;
        } 
        long var4E2F67F49E4924DD90222B94AF69D75C_569536131 = (byteBuffer.getLong(position++ * SizeOf.LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1239706871 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1239706871;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.790 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "F28E358659EB2857F117472E9590A94B")
    @Override
    public long get(int index) {
        addTaint(index);
        checkIndex(index);
        long var3996BDDD354D2BBA3E0D638EAB77CECA_1339758632 = (byteBuffer.getLong(index * SizeOf.LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_326355263 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_326355263;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.791 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "898489AF3E7C9F2E501FC5BCC7E8BA14")
    @Override
    public LongBuffer get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
    if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } 
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } 
        this.position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1632811246 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1632811246.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1632811246;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.792 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "4972E7FBF062B290A446B37CE42F5819")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1736706788 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112214669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112214669;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.792 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "76979A11F9734927D8498B6FACCE51E9")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1246842057 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190005834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190005834;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.792 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "80962471922716106FEB25327CC549D0")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_855022004 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_855022004.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_855022004;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.793 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "E2951698108A261A649280B535E094B7")
    @Override
    protected long[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_700612963 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_700612963.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_700612963;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.793 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "A61B0C44D1565DC572A1AD8185B1D3C9")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1520241263 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1520241263.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1520241263;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.793 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "D3511721FEBE90C93037E4ADB7F6A9C8")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1083235531 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803935290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803935290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.794 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "4EC205C9501604DEB0701BA70257D83F")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1379599489 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1379599489.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1379599489;
        } 
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1939329383 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1939329383.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1939329383;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.794 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "5F5B5252F5009B437C2C1D54AB5F54F2")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1477463288 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1477463288.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1477463288;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.795 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "E46446E97505584511AE72595329D8AD")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        addTaint(longCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
    if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } 
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } 
        this.position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1102838397 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1102838397.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1102838397;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.795 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "BD7A48485D6784C755C9528D2A7DFF7F")
    @Override
    public LongBuffer slice() {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
LongBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1981673564 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1981673564.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1981673564;
        
        
        
        
        
        
        
    }

    
}

