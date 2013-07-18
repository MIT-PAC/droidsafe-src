package java.nio;

// Droidsafe Imports
import libcore.io.SizeOf;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class LongToByteBufferAdapter extends LongBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.292 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.293 -0400", hash_original_method = "7BE681F333C6F648B89AD219E60BA2F8", hash_generated_method = "57E6A47D4A49ACF7C2EEBE80CADCBC3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.294 -0400", hash_original_method = "D050B63E2506664B1FB8FA5AF2DF1745", hash_generated_method = "57BC81F2DA5CE65BB8372D5B1F1866BE")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
LongBuffer var0D8E466677B8F245666E1A4B1E0924E6_1939068352 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1939068352.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1939068352;
        // ---------- Original Method ----------
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.295 -0400", hash_original_method = "B90A69906FF2A7DF6CFB9034F84C98E2", hash_generated_method = "CE15BE0169E1B7E3F8290E3BE5AF6F18")
    @Override
    public LongBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1169835045 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1169835045.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1169835045;
        } //End block
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1161982369 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1161982369.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1161982369;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.296 -0400", hash_original_method = "43AC1DE0A2813C7EA603135E834FD979", hash_generated_method = "B0D1D973DA2F944D1B2F2E15038389D7")
    @Override
    public LongBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
LongBuffer var0D8E466677B8F245666E1A4B1E0924E6_2116548898 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_2116548898.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_2116548898;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //LongToByteBufferAdapter buf = new LongToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.297 -0400", hash_original_method = "69EF1CD1610BDC80B0B9220CD61D963E", hash_generated_method = "E433A539B5E1CD41E561ECE9B2BA8F97")
    @Override
    public long get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1135585496 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1135585496.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1135585496;
        } //End block
        long var4E2F67F49E4924DD90222B94AF69D75C_1322473664 = (byteBuffer.getLong(position++ * SizeOf.LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_236539243 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_236539243;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getLong(position++ * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.297 -0400", hash_original_method = "89069B89A0801CA51434AC3AB566C55F", hash_generated_method = "1AFA5DBE0AD561A2A2F46E9C114B6BA2")
    @Override
    public long get(int index) {
        addTaint(index);
        checkIndex(index);
        long var3996BDDD354D2BBA3E0D638EAB77CECA_2144275767 = (byteBuffer.getLong(index * SizeOf.LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_374804523 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_374804523;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getLong(index * SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.298 -0400", hash_original_method = "D4236D431748AB12467DF84CDEDC66D3", hash_generated_method = "082AD41FD5D1A55DC4A1C9F74171B8E7")
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
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, longCount);
        } //End block
        this.position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1003764056 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1003764056.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1003764056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.299 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "596301BAC21FF323741E57684699C22D")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1288875349 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36250657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_36250657;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.299 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "3E6DAC1FBE30FD15E723C5352355ED88")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1155838824 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550306792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550306792;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.299 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "5DD540CFE9E626198D095DA8D81E518E")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1492501200 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1492501200.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1492501200;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.299 -0400", hash_original_method = "BB4072AD98AEBDD15F1C2BE658CD1C60", hash_generated_method = "28A74E1CCB237A7F66E45441E9E36A2D")
    @Override
    protected long[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_629927466 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_629927466.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_629927466;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.300 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "F371506D34BA9BB12C93DB29E87C9BCD")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_579051406 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_579051406.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_579051406;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.300 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "F07E0A3B5C2F79EC22EB16E18524A0AB")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1893353607 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592963051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592963051;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.300 -0400", hash_original_method = "87F5FD3E4F89C8080D5C7CCD57D2DD50", hash_generated_method = "BCB50FE4727877F4C9E33B961C1680A9")
    @Override
    public LongBuffer put(long c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_249126268 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_249126268.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_249126268;
        } //End block
        byteBuffer.putLong(position++ * SizeOf.LONG, c);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_2023420967 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2023420967.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2023420967;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putLong(position++ * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.300 -0400", hash_original_method = "CF44390369F77E5D846E6D2329A6B3BC", hash_generated_method = "55C9A30C6364726472B3C1B97A59AE3A")
    @Override
    public LongBuffer put(int index, long c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putLong(index * SizeOf.LONG, c);
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1019039182 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1019039182.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1019039182;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putLong(index * SizeOf.LONG, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.301 -0400", hash_original_method = "95A4CBB7FC306D23EF877E74124EDB15", hash_generated_method = "C72A46F54EF744788AA31CB696998E63")
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
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, longCount);
        } //End block
        this.position += longCount;
LongBuffer var72A74007B2BE62B849F475C7BDA4658B_1071803330 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1071803330.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1071803330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.301 -0400", hash_original_method = "456A8EB98AABFAF4E458EC4948195D08", hash_generated_method = "4E31BFB526D81DCE8641739B9F927A25")
    @Override
    public LongBuffer slice() {
        byteBuffer.limit(limit * SizeOf.LONG);
        byteBuffer.position(position * SizeOf.LONG);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        LongBuffer result = new LongToByteBufferAdapter(bb);
        byteBuffer.clear();
LongBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1252941250 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1252941250.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1252941250;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.LONG);
        //byteBuffer.position(position * SizeOf.LONG);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //LongBuffer result = new LongToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

