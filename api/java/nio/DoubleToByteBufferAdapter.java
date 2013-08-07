package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class DoubleToByteBufferAdapter extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.618 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.618 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6CAAD45A3D270E301643B5D0616EFF17")
    private  DoubleToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.DOUBLE);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    static DoubleBuffer asDoubleBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new DoubleToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.620 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "0641C772DA9DBDBF8034905600D1D1F4")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
DoubleBuffer var0D8E466677B8F245666E1A4B1E0924E6_998309477 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_998309477.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_998309477;
        // ---------- Original Method ----------
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.620 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "EA58F1BD89B9E5F9CFE668A14DF48AFA")
    @Override
    public DoubleBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1903741178 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1903741178.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1903741178;
        } //End block
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1362076342 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1362076342.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1362076342;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.621 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "C576C9EF668B6690F5A1C71758FF5A6B")
    @Override
    public DoubleBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
DoubleBuffer var0D8E466677B8F245666E1A4B1E0924E6_389926827 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_389926827.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_389926827;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.621 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "184BA0A6FB8D607A3061B0637F789195")
    @Override
    public double get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1911484776 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1911484776.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1911484776;
        } //End block
        double var6499EB3D445CA4BBA260002A97B6C75C_2076103785 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1205313168 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1205313168;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.622 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "A5DE7C0BCEE9E60202BF8AE6EA182513")
    @Override
    public double get(int index) {
        addTaint(index);
        checkIndex(index);
        double varED893DA31338596FCB6461229BF0765C_706868517 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_345300771 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_345300771;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.623 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "5E4562DE7EBE22B4BD2831545FA25B6D")
    @Override
    public DoubleBuffer get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        } //End block
        this.position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1335843873 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1335843873.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1335843873;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.623 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "579B50DDFCF1E33EE39736E00B401573")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_250501294 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498773733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498773733;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.623 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "1F81491834DBFDF40F09C3131DE7AE07")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_645612524 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968950541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968950541;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.624 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "52CCCD99F9FC72650D3CFC045221EFAC")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1755298447 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1755298447.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1755298447;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.624 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "095D636A0B424701DB0D099AF670258F")
    @Override
    protected double[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_397401189 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_397401189.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_397401189;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.624 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "12EAA4D30BBB165737DA5DBBD4E77717")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_843204552 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_843204552.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_843204552;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.625 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "9D955E086DCA7E9E579B43B3EC6E9587")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_162085030 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531350587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531350587;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.625 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "703FC59E1CEEE8642F8126DABC55D03D")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1371782058 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1371782058.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1371782058;
        } //End block
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1410391332 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1410391332.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1410391332;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.626 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "ACB9A55B6C946481873112D3DFCDD94A")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_189777118 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_189777118.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_189777118;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.627 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "CBF16E45FFB1C2F75145298A64A30F75")
    @Override
    public DoubleBuffer put(double[] src, int srcOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        } //End block
        this.position += doubleCount;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1201814165 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1201814165.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1201814165;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, doubleCount);
        //}
        //this.position += doubleCount;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.627 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "D78B3E804F081DA596954833084647CE")
    @Override
    public DoubleBuffer slice() {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
DoubleBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_855074371 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_855074371.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_855074371;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

