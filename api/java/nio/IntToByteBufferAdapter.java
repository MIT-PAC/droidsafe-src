package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class IntToByteBufferAdapter extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.177 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.177 -0400", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "6657DCBFFBE0C8453AA9452787423263")
    private  IntToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.INT);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new IntToByteBufferAdapter(slice);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.178 -0400", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "424C9CC530DABB919CA3ED50739FAB64")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
IntBuffer var0D8E466677B8F245666E1A4B1E0924E6_866253544 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_866253544.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_866253544;
        // ---------- Original Method ----------
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.179 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "0AF7E5990BA7EB00EDF800CF5B4B128D")
    @Override
    public IntBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1442318219 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1442318219.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1442318219;
        } //End block
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1391118842 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1391118842.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1391118842;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.180 -0400", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "8DAEF4E40678AB1D9E1E7A3D39848A53")
    @Override
    public IntBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
IntBuffer var0D8E466677B8F245666E1A4B1E0924E6_573792552 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_573792552.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_573792552;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.180 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "F51F03D8539E24D164944AB8FD8C7794")
    @Override
    public int get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1343281786 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1343281786.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1343281786;
        } //End block
        int varB3D393D893BFA3585CCF771E1EA9301E_2085751029 = (byteBuffer.getInt(position++ * SizeOf.INT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160461067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160461067;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.180 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "3FD702D059541A81604FA504E8D34AF7")
    @Override
    public int get(int index) {
        addTaint(index);
        checkIndex(index);
        int var14ABD525B54C62B76E4647142FD0AB3E_1538132002 = (byteBuffer.getInt(index * SizeOf.INT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682928835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682928835;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getInt(index * SizeOf.INT);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.181 -0400", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "9F9BAE846A7BE1B39CC6B9C3A00F1A40")
    @Override
    public IntBuffer get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        } //End block
        this.position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_601162415 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_601162415.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_601162415;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.181 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "1E830464861AB414319D4ABBC9FC64F3")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1851000979 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647403075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_647403075;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.182 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "1502CCE135DE381A3F4BC043C8A7BFA9")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_9241870 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937452695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_937452695;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.182 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "241CB361A6FF90D8A5A80F5D56E32F4C")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1767099706 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1767099706.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1767099706;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.182 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "0137064E1376E7C5B72BEE4A651C082D")
    @Override
    protected int[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_74683295 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_74683295.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_74683295;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.183 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "BB0551EC406D6738271710058394FB6E")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_184675209 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_184675209.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_184675209;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.183 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "7183871FFBF2A8F07C494B25C5A19FAC")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_841597290 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577560780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577560780;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.183 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "C6CC966BC502172AAFF077B9A26D6AD9")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1014333475 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1014333475.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1014333475;
        } //End block
        byteBuffer.putInt(position++ * SizeOf.INT, c);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_668017303 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_668017303.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_668017303;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putInt(position++ * SizeOf.INT, c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.184 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "C6AF0D7EDF8C6F5FC351E86480E03FF6")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_146890310 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_146890310.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_146890310;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putInt(index * SizeOf.INT, c);
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.184 -0400", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "CA1D1230986EAC663B2AEEFC1531C517")
    @Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        addTaint(intCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        } //End block
        this.position += intCount;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_379757982 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_379757982.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_379757982;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, intCount);
        //}
        //this.position += intCount;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.185 -0400", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "893BF013E7C073525578EAF3C74A7BDF")
    @Override
    public IntBuffer slice() {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
IntBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1253757428 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1253757428.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1253757428;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //IntBuffer result = new IntToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

