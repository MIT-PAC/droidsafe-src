package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class DoubleToByteBufferAdapter extends DoubleBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.271 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.272 -0400", hash_original_method = "3C3F64E3DFEA19E69D83DE032CD69444", hash_generated_method = "6CAAD45A3D270E301643B5D0616EFF17")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.274 -0400", hash_original_method = "66F1F6EEFF46B34AB7A86EE28CB8A669", hash_generated_method = "375B9164454E363B8AB3A56D6D600775")
    @Override
    public DoubleBuffer asReadOnlyBuffer() {
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
DoubleBuffer var0D8E466677B8F245666E1A4B1E0924E6_1135684197 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1135684197.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1135684197;
        // ---------- Original Method ----------
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.277 -0400", hash_original_method = "A0960685ED8E4B90630D067C0149A7A7", hash_generated_method = "22F23E210317B81DE39CC35158000240")
    @Override
    public DoubleBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_502901657 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_502901657.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_502901657;
        } //End block
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1090322398 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1090322398.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1090322398;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.278 -0400", hash_original_method = "FD4932C207B542FC04D0525E47AC3161", hash_generated_method = "8DB025CCB677941ADECDB2014A59DB45")
    @Override
    public DoubleBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
DoubleBuffer var0D8E466677B8F245666E1A4B1E0924E6_1709607675 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1709607675.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1709607675;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //DoubleToByteBufferAdapter buf = new DoubleToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.278 -0400", hash_original_method = "0C75853E3C2CF6732FFCF6E98F870BD4", hash_generated_method = "B67F4EB88CC2912697A5680F134B277A")
    @Override
    public double get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_114226000 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_114226000.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_114226000;
        } //End block
        double var6499EB3D445CA4BBA260002A97B6C75C_709893085 = (byteBuffer.getDouble(position++ * SizeOf.DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_2029132410 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2029132410;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getDouble(position++ * SizeOf.DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.278 -0400", hash_original_method = "E6FEAF9DCFF95E07F26C5202FDF2E7B8", hash_generated_method = "BA0662CE13F35F2300AF38360F8D8B57")
    @Override
    public double get(int index) {
        addTaint(index);
        checkIndex(index);
        double varED893DA31338596FCB6461229BF0765C_2086904432 = (byteBuffer.getDouble(index * SizeOf.DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_2095509064 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2095509064;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getDouble(index * SizeOf.DOUBLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.279 -0400", hash_original_method = "D37CED54394BDE1310F07C3D0EF5D332", hash_generated_method = "AC3B3F0F0615C70D76B88B4FAA97EE03")
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
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_443470137 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_443470137.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_443470137;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.279 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "04165EF94F28DA681066136257B65935")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1725446506 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910355904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910355904;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.279 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "211DB02185BEC283A661389660F1D8EB")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1322510388 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83939372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83939372;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.279 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "B61C7AF6490FE7F8A94EFFD3320F88CE")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1226901163 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1226901163.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1226901163;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.280 -0400", hash_original_method = "74B676FF851868B6C558CA9DCC9A472E", hash_generated_method = "497BF00B1ECF81C5A82768E250B7914D")
    @Override
    protected double[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_936533476 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_936533476.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_936533476;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.280 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "0459C0E63F26D14070CF8BB5614A4D08")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_901655720 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_901655720.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_901655720;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.280 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "C7CD5D49034C18D0BB3B68C98BA09000")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_392463337 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583701715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583701715;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.280 -0400", hash_original_method = "40AF4DBB8CAF825D560827D27834F61A", hash_generated_method = "D5D2DBD7E13E39EFD214A91771A0AA66")
    @Override
    public DoubleBuffer put(double c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1723471159 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1723471159.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1723471159;
        } //End block
        byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1895745373 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1895745373.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1895745373;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putDouble(position++ * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.280 -0400", hash_original_method = "86E534F052F254A7B02EA4C07E94BFA8", hash_generated_method = "BFB092536AEBB9EDE794AD29F8FAC7FB")
    @Override
    public DoubleBuffer put(int index, double c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1766370729 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1766370729.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1766370729;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putDouble(index * SizeOf.DOUBLE, c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.281 -0400", hash_original_method = "9EEEA82F785CE6D4D72E12428428FA8D", hash_generated_method = "7E740EEBEF98DBFE4AF8BAD27C8CBE3B")
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
DoubleBuffer var72A74007B2BE62B849F475C7BDA4658B_1980847632 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1980847632.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1980847632;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.281 -0400", hash_original_method = "22A6C9D0B842A6C5A7761EE0E7412B6B", hash_generated_method = "27B74AEEB82C0A702A5FEF14045677B7")
    @Override
    public DoubleBuffer slice() {
        byteBuffer.limit(limit * SizeOf.DOUBLE);
        byteBuffer.position(position * SizeOf.DOUBLE);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        byteBuffer.clear();
DoubleBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1629486027 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1629486027.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1629486027;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.DOUBLE);
        //byteBuffer.position(position * SizeOf.DOUBLE);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //DoubleBuffer result = new DoubleToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

