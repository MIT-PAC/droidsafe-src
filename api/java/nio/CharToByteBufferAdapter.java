package java.nio;

// Droidsafe Imports
import droidsafe.annotations.*;
import libcore.io.SizeOf;





final class CharToByteBufferAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.397 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.398 -0400", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "7B64404964C0A8F96913AC03401200AD")
    private  CharToByteBufferAdapter(ByteBuffer byteBuffer) {
        super(byteBuffer.capacity() / SizeOf.CHAR);
        this.byteBuffer = byteBuffer;
        this.byteBuffer.clear();
        this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
        // ---------- Original Method ----------
        //this.byteBuffer = byteBuffer;
        //this.byteBuffer.clear();
        //this.effectiveDirectAddress = byteBuffer.effectiveDirectAddress;
    }

    
    @DSModeled(DSC.SAFE)
    static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new CharToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.399 -0400", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "BD8DDA3FE01B4B163206ECBFC26A1461")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
CharBuffer var0D8E466677B8F245666E1A4B1E0924E6_415431484 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_415431484.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_415431484;
        // ---------- Original Method ----------
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.400 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "9283B466EF0131BA0557892D587F5FB9")
    @Override
    public CharBuffer compact() {
        if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_353626564 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_353626564.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_353626564;
        } //End block
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_601529645 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_601529645.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_601529645;
        // ---------- Original Method ----------
        //if (byteBuffer.isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //byteBuffer.compact();
        //byteBuffer.clear();
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.401 -0400", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "22DDCB9A53610F2F8AF5D28F35056B3A")
    @Override
    public CharBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
CharBuffer var0D8E466677B8F245666E1A4B1E0924E6_1205376736 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1205376736.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1205376736;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.401 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "1B41B34471BD428A840F1C26FF81E284")
    @Override
    public char get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1620814491 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1620814491.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1620814491;
        } //End block
        char var0C7531E888F788E7ED252F876B176246_1803698852 = (byteBuffer.getChar(position++ * SizeOf.CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_761292905 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_761292905;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.401 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "D59889BA2C55DEA13EAC9C853697B3DB")
    @Override
    public char get(int index) {
        addTaint(index);
        checkIndex(index);
        char varDB86469F4E5E54A3CC257A3876C8E811_289746161 = (byteBuffer.getChar(index * SizeOf.CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1688202945 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1688202945;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.402 -0400", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "16FE6E5E47EDA1873DDBAE79EF0C18CA")
    @Override
    public CharBuffer get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if(byteBuffer instanceof DirectByteBuffer)        
        {
            ((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        else
        {
            ((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        } //End block
        this.position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_635653630 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_635653630.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_635653630;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof DirectByteBuffer) {
            //((DirectByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //} else {
            //((HeapByteBuffer) byteBuffer).get(dst, dstOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.403 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "50F130686B12338284445E51C7D276C8")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_1762239822 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97971165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97971165;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.403 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "A73AD2BEE2E41A4E059B6DDBB97BF208")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_250718949 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073790130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073790130;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.403 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "D3C6BA286AD49A17A8DFD6CD4C1DC8DB")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1110972308 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1110972308.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1110972308;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.404 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "ECCEA0BF4A87FAFD3A6808EA8B655030")
    @Override
    protected char[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2098688119 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2098688119.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2098688119;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.404 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "7180EBDCB6CF833DFE72DF9B82B84F97")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1707775843 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1707775843.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1707775843;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.404 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "3417FB6B843FFB4BDFF2F9674E07B2FF")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_1873676299 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961256726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961256726;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.405 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "56D0E0F3AB0ACA5D8CA92F4E23BCC1D9")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
        if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1316846329 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1316846329.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1316846329;
        } //End block
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_2116646922 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2116646922.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2116646922;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.405 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "E6CC86279E7D7FA7F540B96EDA121F8D")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_72068449 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_72068449.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_72068449;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putChar(index * SizeOf.CHAR, c);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.406 -0400", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "94C385CBB7305D0F5CCC7F5546D26C64")
    @Override
    public CharBuffer put(char[] src, int srcOffset, int charCount) {
        addTaint(charCount);
        addTaint(srcOffset);
        addTaint(src[0]);
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        if(byteBuffer instanceof ReadWriteDirectByteBuffer)        
        {
            ((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        else
        {
            ((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        } //End block
        this.position += charCount;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_445692416 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_445692416.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_445692416;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //if (byteBuffer instanceof ReadWriteDirectByteBuffer) {
            //((ReadWriteDirectByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //} else {
            //((ReadWriteHeapByteBuffer) byteBuffer).put(src, srcOffset, charCount);
        //}
        //this.position += charCount;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.406 -0400", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "A6C80C042555527D5C3C14909E2414CA")
    @Override
    public CharBuffer slice() {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
CharBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1863632839 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1863632839.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1863632839;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //CharBuffer result = new CharToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.407 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "3A9B8135E9D0DFE4F37CF12D4295FD34")
    @Override
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_221828439 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_221828439.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_221828439;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
}

