package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class FloatToByteBufferAdapter extends FloatBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.560 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.561 -0400", hash_original_method = "810EBC63174C0FA8B04ABE1EAC99DA74", hash_generated_method = "FC9D382F68DC054BA01D6ECD3665B29E")
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

    
        static FloatBuffer asFloatBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new FloatToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.563 -0400", hash_original_method = "3FF4AF57EF2BE2D13954C1B0FC09E489", hash_generated_method = "37037484DF7C9CD39550E9068A177C53")
    @Override
    public FloatBuffer asReadOnlyBuffer() {
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
FloatBuffer var0D8E466677B8F245666E1A4B1E0924E6_1816259787 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1816259787.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1816259787;
        // ---------- Original Method ----------
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.564 -0400", hash_original_method = "FBAC0D7CFE3E15F2BC0CE6753022B0DD", hash_generated_method = "CE156ADC287989D970461218DE89E3F7")
    @Override
    public FloatBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_269683935 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_269683935.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_269683935;
        } //End block
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1469071595 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1469071595.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1469071595;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.565 -0400", hash_original_method = "2336A0F3EA16333D5C7B2B5772DB119B", hash_generated_method = "DF449F19599C7B457EC7270D02090719")
    @Override
    public FloatBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
FloatBuffer var0D8E466677B8F245666E1A4B1E0924E6_461533909 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_461533909.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_461533909;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //FloatToByteBufferAdapter buf = new FloatToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.565 -0400", hash_original_method = "B6EAE0A3183D6C7B7623279A287B061F", hash_generated_method = "1CD67BEDB46421F58012E275A408751B")
    @Override
    public float get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1212115612 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1212115612.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1212115612;
        } //End block
        float var38A66EC096483ACD31AB466C1BB052EF_1080410070 = (byteBuffer.getFloat(position++ * SizeOf.FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_1346549357 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1346549357;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getFloat(position++ * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.566 -0400", hash_original_method = "230A68E38935998751EB725110E55452", hash_generated_method = "2BB5C64CD33651D267E64EEAA00F789D")
    @Override
    public float get(int index) {
        addTaint(index);
        checkIndex(index);
        float var32E8A96724E14C300F7B9E1CA2C8C6F0_1611012222 = (byteBuffer.getFloat(index * SizeOf.FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_1776198839 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1776198839;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getFloat(index * SizeOf.FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.566 -0400", hash_original_method = "D58B2A76A0F3A395BA7B6FFCBE67E2EB", hash_generated_method = "C5816FD56145DAEF04D0E43ED9503030")
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
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_2026184583 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2026184583.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2026184583;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.567 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "F407C10A9FC814A81A09C8C41B01C88B")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1961258404 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037221328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037221328;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.567 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "E1FF470CFABC4DB28854D4F51907DBBC")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1558399055 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109071694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109071694;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.568 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "CBA368915F87B1A4E33CA9062607F5B7")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_542896031 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_542896031.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_542896031;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.568 -0400", hash_original_method = "B84097C1EE35CBEC4451B3A83458D5FB", hash_generated_method = "10E284BC92D3CA5ED0BB614791F892FE")
    @Override
    protected float[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1355235453 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1355235453.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1355235453;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.569 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "90C8F224D06EBDCA05C524ECCC257D85")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1096719660 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1096719660.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1096719660;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.569 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "ACF14C649DD52551D02B34949A7964FE")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1171214671 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863369642 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863369642;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.570 -0400", hash_original_method = "BFCE73D0BEC9C4C5044FD718D90FCD3E", hash_generated_method = "C71B6A7A338FDA17D96F2042B82709F2")
    @Override
    public FloatBuffer put(float c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1578537689 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1578537689.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1578537689;
        } //End block
        byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1256440138 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1256440138.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1256440138;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putFloat(position++ * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.570 -0400", hash_original_method = "031128B9243B4CE1487F7A32DBB76678", hash_generated_method = "1C49DFF780165ED970B4C9E708411562")
    @Override
    public FloatBuffer put(int index, float c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putFloat(index * SizeOf.FLOAT, c);
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1593774513 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1593774513.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1593774513;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putFloat(index * SizeOf.FLOAT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.571 -0400", hash_original_method = "3BDFA2137C718F8287015587FF612D27", hash_generated_method = "0E4BE72C9A0F96FFECAECFE01433AC99")
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
FloatBuffer var72A74007B2BE62B849F475C7BDA4658B_1402881965 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1402881965.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1402881965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.572 -0400", hash_original_method = "72D0D38C2A2E773EAB91888933B787B4", hash_generated_method = "052B1539BF5FA4711665C00D6DEAC8A3")
    @Override
    public FloatBuffer slice() {
        byteBuffer.limit(limit * SizeOf.FLOAT);
        byteBuffer.position(position * SizeOf.FLOAT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        FloatBuffer result = new FloatToByteBufferAdapter(bb);
        byteBuffer.clear();
FloatBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1720805149 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1720805149.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1720805149;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.FLOAT);
        //byteBuffer.position(position * SizeOf.FLOAT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //FloatBuffer result = new FloatToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

