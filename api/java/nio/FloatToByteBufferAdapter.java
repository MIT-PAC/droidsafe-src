package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class FloatToByteBufferAdapter extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.049 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.050 -0400", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "FC9D382F68DC054BA01D6ECD3665B29E")
      FloatToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.FLOAT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new FloatToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.051 -0400", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "6172AB5614A880B1F315F558628849D4")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
FloatBuffer var0D8E466677B8F245666E1A4B1E0924E6_542590624 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_542590624.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_542590624;
        // ---------- Original Method ----------
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.052 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "BA63AC6EA736A6E95D009DB5F0D5C9FB")
    @Override
    public FloatBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1734461346 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1734461346.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1734461346;
        } //End block
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_420388553 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_420388553.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_420388553;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.052 -0400", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "05F2B2A7224E49E282E924315C62E6A0")
    @Override
    public FloatBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
FloatBuffer var0D8E466677B8F245666E1A4B1E0924E6_1700755035 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1700755035.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1700755035;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.053 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "ABD008CB430D35718954ECBC0E4A5FAE")
    @Override
    public float get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_2101461010 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_2101461010.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_2101461010;
        } //End block
        float var38A66EC096483ACD31AB466C1BB052EF_1693628738 = (byteBuffer.getFloat(position++ * SizeOf.FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_1499148980 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1499148980;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.054 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "F870B6F3C50CE348CA07265D75E77123")
    @Override
    public float get(int index) {
        addTaint(index);
        checkIndex(index);
        float var32E8A96724E14C300F7B9E1CA2C8C6F0_677725857 = (byteBuffer.getFloat(index * SizeOf.FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_597070776 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_597070776;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.055 -0400", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "0F89F9FF7672AF5A976A6281F457790F")
    @Override
    public FloatBuffer get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        } //End block
        this.position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_404789400 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_404789400.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_404789400;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.055 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "D8AA6DC5B841C8D1AF1B77DBD6844B7D")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1486973569 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375532828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375532828;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.056 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "E6B2758D55DABD6EF88C2DD65F7C800B")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1623451539 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973321310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973321310;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.056 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "35215D0D98743E26FFDB4ADE25048A4D")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1081774637 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1081774637.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1081774637;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.056 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "0197CB3E76D9C5E2E5A36C8D26BE7BE9")
    @Override
    protected float[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_672704536 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_672704536.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_672704536;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.057 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "2B1EEF269C66D778C66C8A9EA7E4F170")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_109037072 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_109037072.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_109037072;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.057 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "5E7E2A6D65D7822E7E79CBFA7F2FE28C")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_721565356 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671904837 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_671904837;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.057 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "3905C28FAAD37FFCA9DA1947A71AB03C")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1656773707 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1656773707.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1656773707;
        } //End block
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_448555155 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_448555155.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_448555155;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.058 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "E2D2B442750F66454290791592A40CDC")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_412885813 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_412885813.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_412885813;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.058 -0400", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "3BF33CE332BD4225911F375C774D3013")
    @Override
    public FloatBuffer put(float[] src, int srcOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        } //End block
        this.position += floatCount;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_384366487 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_384366487.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_384366487;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, floatCount);
        //}
        //this.position += floatCount;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.059 -0400", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "376659B63EB04B3ED580298E88459B3A")
    @Override
    public FloatBuffer slice() {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
FloatBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_18589673 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_18589673.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_18589673;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //FloatBuffer result = new FloatToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

