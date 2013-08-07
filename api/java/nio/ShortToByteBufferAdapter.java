package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class ShortToByteBufferAdapter extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.013 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.014 -0400", hash_original_method = "A7ACA037BB98388A15E54FB4598E481B", hash_generated_method = "99030E6A8F05267CDC21391C0846AEB3")
    private  ShortToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.SHORT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ShortToByteBufferAdapter(slice);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.017 -0400", hash_original_method = "D0F8AEC70CAA4378FE6A82AD4DA3E011", hash_generated_method = "45AC242C232A8E595818216F22EF3DEE")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
ShortBuffer var0D8E466677B8F245666E1A4B1E0924E6_553673221 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_553673221.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_553673221;
        // ---------- Original Method ----------
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.018 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "6CAECC168758573B4520681FC7D32068")
    @Override
    public ShortBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_861276017 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_861276017.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_861276017;
        } //End block
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_356723660 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_356723660.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_356723660;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.020 -0400", hash_original_method = "D125FE991C052B0355B5B7F2D7D9870F", hash_generated_method = "F3B6C8144013B39AB5C6EF1010F9A633")
    @Override
    public ShortBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
ShortBuffer var0D8E466677B8F245666E1A4B1E0924E6_2128275657 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_2128275657.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_2128275657;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.021 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "FFF0CA5C5E14F0EE3535060EDBF3CA2F")
    @Override
    public short get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_278637678 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_278637678.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_278637678;
        } //End block
        short varBC5721166B3E66068CCCA27B2D8A97A7_1235016697 = (byteBuffer.getShort(position++ * SizeOf.SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1895932287 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1895932287;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.022 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "86D7D4C51E900494B5A2F09144ED7FA5")
    @Override
    public short get(int index) {
        addTaint(index);
        checkIndex(index);
        short var6828221A5657FFA34FF2E2744DA9629B_1778663012 = (byteBuffer.getShort(index * SizeOf.SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1230174157 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1230174157;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.023 -0400", hash_original_method = "01D384F7005F01D67D604B15B569F233", hash_generated_method = "5E04511ED97DCD390D518477B1F5FBC3")
    @Override
    public ShortBuffer get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        } //End block
        this.position += shortCount;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1244659540 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1244659540.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1244659540;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.024 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "FC44D583566968CCB5AF7521CD5BB60E")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_378866307 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353408139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353408139;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.024 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "8DED784D084CEBD9D46A077AAD9DD52E")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1482699717 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133753425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133753425;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.024 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "9F68870D33D8274488EF6535296428AF")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1500579186 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1500579186.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1500579186;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.026 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "9844A83E4EF3DD26026AEC8A6527598B")
    @Override
    protected short[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_120307659 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_120307659.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_120307659;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.026 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "7B7A2F048D747DC0E0F05E1D78A04907")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_357215025 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_357215025.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_357215025;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.027 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "EA39E5D0982FFA90F88B7323C256EE2F")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_684668798 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299146983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299146983;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.027 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "057A0694C296C603120FC864E67630DB")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1326623143 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1326623143.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1326623143;
        } //End block
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_198128058 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_198128058.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_198128058;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.028 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "7579E473A272E3F4E6932F8DB7351022")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_2052952886 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2052952886.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2052952886;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putShort(index * SizeOf.SHORT, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.029 -0400", hash_original_method = "513A20FF10AFB87C25A95801BCBD1A6B", hash_generated_method = "29D165BCF935FC3662CD783FA4505327")
    @Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        } //End block
        this.position += shortCount;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1213918222 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1213918222.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1213918222;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, shortCount);
        //}
        //this.position += shortCount;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.029 -0400", hash_original_method = "1D11F07A1825F4A6C771FB33ADDF613C", hash_generated_method = "9315F6324DA9907D51E32DCC3BEA8706")
    @Override
    public ShortBuffer slice() {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result = new ShortToByteBufferAdapter(bb);
        byteBuffer.clear();
ShortBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1157040564 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1157040564.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1157040564;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //ShortBuffer result = new ShortToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

