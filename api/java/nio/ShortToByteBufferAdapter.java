package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class ShortToByteBufferAdapter extends ShortBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.357 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.357 -0400", hash_original_method = "A7ACA037BB98388A15E54FB4598E481B", hash_generated_method = "99030E6A8F05267CDC21391C0846AEB3")
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

    
        static ShortBuffer asShortBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new ShortToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.359 -0400", hash_original_method = "D0F8AEC70CAA4378FE6A82AD4DA3E011", hash_generated_method = "352078D81DCB5596D396252314EB6ADD")
    @Override
    public ShortBuffer asReadOnlyBuffer() {
        ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
ShortBuffer var0D8E466677B8F245666E1A4B1E0924E6_268975840 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_268975840.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_268975840;
        // ---------- Original Method ----------
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.359 -0400", hash_original_method = "05DE7B6CED27ACAA0A9F6BF73EB6C673", hash_generated_method = "9058C3A2704B1407350E51743223DA9B")
    @Override
    public ShortBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2061527932 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_2061527932.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_2061527932;
        } //End block
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_283154808 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_283154808.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_283154808;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.360 -0400", hash_original_method = "D125FE991C052B0355B5B7F2D7D9870F", hash_generated_method = "DB4C3C6C364E2690FAFA97B29638EFC1")
    @Override
    public ShortBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
ShortBuffer var0D8E466677B8F245666E1A4B1E0924E6_68203803 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_68203803.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_68203803;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //ShortToByteBufferAdapter buf = new ShortToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.360 -0400", hash_original_method = "7C4E3224E8CBDBDF522D2B052ECE14D8", hash_generated_method = "454662DF9C543268BD750F6453F3BF33")
    @Override
    public short get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1596218834 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1596218834.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1596218834;
        } //End block
        short varBC5721166B3E66068CCCA27B2D8A97A7_1399024674 = (byteBuffer.getShort(position++ * SizeOf.SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1761901958 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1761901958;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getShort(position++ * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.361 -0400", hash_original_method = "99D353FC1689A601B3A3A0ABA15D7065", hash_generated_method = "FD5F447411BB8BBF4A448EAD9D524D45")
    @Override
    public short get(int index) {
        addTaint(index);
        checkIndex(index);
        short var6828221A5657FFA34FF2E2744DA9629B_338945734 = (byteBuffer.getShort(index * SizeOf.SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_2135660905 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2135660905;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getShort(index * SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.362 -0400", hash_original_method = "01D384F7005F01D67D604B15B569F233", hash_generated_method = "CBC4B6C16E6D0E7D4499CFA834445022")
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
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_604426173 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_604426173.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_604426173;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.362 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "EAF8A2FA69DFAD5BB7EA980124328C52")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_135652049 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025661149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025661149;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.362 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "FA06CDA94037D6DDDF67E24CA44AE900")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1850583157 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556003558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556003558;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.363 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "E4BA966306E4ACF7C8BB60A67DC5780D")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_155711828 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_155711828.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_155711828;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.363 -0400", hash_original_method = "797461B8F23A38201C61F803B025213F", hash_generated_method = "AC52DD9FA8127FCEFA9ECBA7A45D94E9")
    @Override
    protected short[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1015267052 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1015267052.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1015267052;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.363 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "186CD9D54132E0E1839A1AB65FD03141")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2116776038 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2116776038.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2116776038;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.364 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "2921AFF470AEFBC6E7215B1CEC307C3A")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_173369627 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_743636160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_743636160;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.364 -0400", hash_original_method = "BED9261A5E47204D4C26D68EDDB52578", hash_generated_method = "318F2D65E8A5B11F0847C537A0A0B717")
    @Override
    public ShortBuffer put(short c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1832135450 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1832135450.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1832135450;
        } //End block
        byteBuffer.putShort(position++ * SizeOf.SHORT, c);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_773143712 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_773143712.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_773143712;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putShort(position++ * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.365 -0400", hash_original_method = "81BB381464177DAD01780ED6CBAA4133", hash_generated_method = "9ACEB7853640D3456657E0112858F861")
    @Override
    public ShortBuffer put(int index, short c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putShort(index * SizeOf.SHORT, c);
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_1625289084 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1625289084.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1625289084;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putShort(index * SizeOf.SHORT, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.365 -0400", hash_original_method = "513A20FF10AFB87C25A95801BCBD1A6B", hash_generated_method = "F86A5F2592FBD58801C826F6FF15DFCF")
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
ShortBuffer var72A74007B2BE62B849F475C7BDA4658B_459088684 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_459088684.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_459088684;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.366 -0400", hash_original_method = "1D11F07A1825F4A6C771FB33ADDF613C", hash_generated_method = "876AA7A588A2C6D0E20CEFE2704AC08C")
    @Override
    public ShortBuffer slice() {
        byteBuffer.limit(limit * SizeOf.SHORT);
        byteBuffer.position(position * SizeOf.SHORT);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        ShortBuffer result = new ShortToByteBufferAdapter(bb);
        byteBuffer.clear();
ShortBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_492405077 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_492405077.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_492405077;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.SHORT);
        //byteBuffer.position(position * SizeOf.SHORT);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //ShortBuffer result = new ShortToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
}

