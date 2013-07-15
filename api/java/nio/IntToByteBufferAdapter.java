package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class IntToByteBufferAdapter extends IntBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.690 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.691 -0400", hash_original_method = "0E7C7C86CACD977D9C0D85465EADD9B5", hash_generated_method = "6657DCBFFBE0C8453AA9452787423263")
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

    
        static IntBuffer asIntBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new IntToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.692 -0400", hash_original_method = "3B6C20C87137502BB674F780046CDA86", hash_generated_method = "F0985C5699E830B67B2AB37B8AEF14AF")
    @Override
    public IntBuffer asReadOnlyBuffer() {
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
IntBuffer var0D8E466677B8F245666E1A4B1E0924E6_952308029 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_952308029.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_952308029;
        // ---------- Original Method ----------
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.693 -0400", hash_original_method = "D18BA662CC63D97B7B456C28811B5740", hash_generated_method = "C25CAA6E4CE83793C47C995053332AC9")
    @Override
    public IntBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_350331270 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_350331270.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_350331270;
        } //End block
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_2033210754 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2033210754.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2033210754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.694 -0400", hash_original_method = "E4BE94C048430920FB1F32A36A3DD508", hash_generated_method = "C98E83A1CD0BCDA603754E923F126F65")
    @Override
    public IntBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
IntBuffer var0D8E466677B8F245666E1A4B1E0924E6_1848945310 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1848945310.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1848945310;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //IntToByteBufferAdapter buf = new IntToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.695 -0400", hash_original_method = "B6C265DA3B3DAD372E7C00DDFF580FE2", hash_generated_method = "81A2422422EA9A20293A279D5E5D89F9")
    @Override
    public int get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1858562383 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1858562383.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1858562383;
        } //End block
        int varB3D393D893BFA3585CCF771E1EA9301E_1905140045 = (byteBuffer.getInt(position++ * SizeOf.INT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963084060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963084060;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getInt(position++ * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.695 -0400", hash_original_method = "A308FF9E693AF460AC240055AB8B4E4F", hash_generated_method = "DAECA366E7D2C8D423FE032B6FEDB3C9")
    @Override
    public int get(int index) {
        addTaint(index);
        checkIndex(index);
        int var14ABD525B54C62B76E4647142FD0AB3E_1493907305 = (byteBuffer.getInt(index * SizeOf.INT));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601836986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601836986;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getInt(index * SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.696 -0400", hash_original_method = "C677A64CEDCCE4923055860B8C2E3944", hash_generated_method = "77CFCA3EB3F5045F24698298A9BBDB48")
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
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_516668569 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_516668569.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_516668569;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.696 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "8D961DB9191B66C31D153B0903EF6C1E")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_815866849 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895855670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895855670;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.697 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "0AA2942A9BC0BA178B3D2DF08320ECF9")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_274597558 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497400873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497400873;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.697 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "C5CEAB8E95955889E29325D8DC922B0C")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_78987824 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_78987824.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_78987824;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.697 -0400", hash_original_method = "B5E68F6CE1B6AAF4D730BB4F773E288A", hash_generated_method = "2B1202DC6CED9386591E899E14016AF9")
    @Override
    protected int[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1995647354 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1995647354.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1995647354;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.698 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "DBD8673AF7A04508369A46F511393AFD")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_836768757 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_836768757.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_836768757;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.698 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "3061D407C4D829DC1F56D16D9BA10A8A")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1877427824 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266436974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266436974;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.698 -0400", hash_original_method = "3F86EA2C1F796EC91605CF34A16A44E5", hash_generated_method = "2E9FD5414FC32E20A60B34BA95486021")
    @Override
    public IntBuffer put(int c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_799554254 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_799554254.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_799554254;
        } //End block
        byteBuffer.putInt(position++ * SizeOf.INT, c);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1687201629 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1687201629.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1687201629;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putInt(position++ * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.699 -0400", hash_original_method = "3231AAB5D18FCEA9F424FA8559AECE08", hash_generated_method = "1CE92ADFDA19541101410B08A420ECA1")
    @Override
    public IntBuffer put(int index, int c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putInt(index * SizeOf.INT, c);
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_1133921406 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1133921406.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1133921406;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putInt(index * SizeOf.INT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.701 -0400", hash_original_method = "DC03F153D09213907F9D5CD0A27C6001", hash_generated_method = "F9705049F273C9E5DE7DA377A66B968A")
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
IntBuffer var72A74007B2BE62B849F475C7BDA4658B_931311719 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_931311719.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_931311719;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.703 -0400", hash_original_method = "9FAC3500FD67AB6DCB59E60DAE965917", hash_generated_method = "C591EC956671A558DB86917350373997")
    @Override
    public IntBuffer slice() {
        byteBuffer.limit(limit * SizeOf.INT);
        byteBuffer.position(position * SizeOf.INT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        IntBuffer result = new IntToByteBufferAdapter(bb);
        byteBuffer.clear();
IntBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_351107880 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_351107880.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_351107880;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.INT);
        //byteBuffer.position(position * SizeOf.INT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //IntBuffer result = new IntToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

