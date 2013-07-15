package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

final class CharToByteBufferAdapter extends CharBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.085 -0400", hash_original_field = "73D79CD15754C8F39826976EB3E77012", hash_generated_field = "34B9235D8E87AE2A76AC711395EEC0EB")

    private ByteBuffer byteBuffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.085 -0400", hash_original_method = "20CC34DEF3812E72CBA72992E239D17C", hash_generated_method = "7B64404964C0A8F96913AC03401200AD")
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

    
        static CharBuffer asCharBuffer(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        slice.order(byteBuffer.order());
        return new CharToByteBufferAdapter(slice);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.087 -0400", hash_original_method = "38E7AC500E9C1BA37DDE4BE628E69019", hash_generated_method = "2633761305906CF0DD7D641BBF1CEA60")
    @Override
    public CharBuffer asReadOnlyBuffer() {
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
        buf.byteBuffer.order = byteBuffer.order;
CharBuffer var0D8E466677B8F245666E1A4B1E0924E6_1417820403 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1417820403.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1417820403;
        // ---------- Original Method ----------
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(byteBuffer.asReadOnlyBuffer());
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //buf.byteBuffer.order = byteBuffer.order;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.087 -0400", hash_original_method = "2B216932B774F9FB3B903B024B1F44DD", hash_generated_method = "9403A071062710A7334A8A3F2CECA1E8")
    @Override
    public CharBuffer compact() {
    if(byteBuffer.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2147420728 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_2147420728.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_2147420728;
        } //End block
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        byteBuffer.compact();
        byteBuffer.clear();
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_732640618 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_732640618.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_732640618;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.088 -0400", hash_original_method = "D6132370D2375183CB2B2E07203B0DEF", hash_generated_method = "BE2C5CC031871151C2362B53F6C94EDE")
    @Override
    public CharBuffer duplicate() {
        ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        buf.limit = limit;
        buf.position = position;
        buf.mark = mark;
CharBuffer var0D8E466677B8F245666E1A4B1E0924E6_1424161695 =         buf;
        var0D8E466677B8F245666E1A4B1E0924E6_1424161695.addTaint(taint);
        return var0D8E466677B8F245666E1A4B1E0924E6_1424161695;
        // ---------- Original Method ----------
        //ByteBuffer bb = byteBuffer.duplicate().order(byteBuffer.order());
        //CharToByteBufferAdapter buf = new CharToByteBufferAdapter(bb);
        //buf.limit = limit;
        //buf.position = position;
        //buf.mark = mark;
        //return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.089 -0400", hash_original_method = "E3B7C628ECBF1BA157CEBCB59E54138B", hash_generated_method = "1D6C2466112ECA0153810E1D1D4BF5F7")
    @Override
    public char get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_796001014 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_796001014.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_796001014;
        } //End block
        char var0C7531E888F788E7ED252F876B176246_1182533981 = (byteBuffer.getChar(position++ * SizeOf.CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_741515452 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_741515452;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return byteBuffer.getChar(position++ * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.089 -0400", hash_original_method = "2E9BB5D57AAEB3C216C710BA88C55EF9", hash_generated_method = "0D106B9B9DBE42A6F5F2A63515875F5A")
    @Override
    public char get(int index) {
        addTaint(index);
        checkIndex(index);
        char varDB86469F4E5E54A3CC257A3876C8E811_1503310195 = (byteBuffer.getChar(index * SizeOf.CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_692300547 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_692300547;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return byteBuffer.getChar(index * SizeOf.CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.090 -0400", hash_original_method = "CD7E402824D81A34C6B45148A4A0EA7C", hash_generated_method = "634D3629387F6A78C7A3E54EF259EB9F")
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
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1915339561 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1915339561.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1915339561;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.090 -0400", hash_original_method = "78E98F36E3D964482B56C152BAA7846E", hash_generated_method = "C414630BDED41C45388553F96D53729D")
    @Override
    public boolean isDirect() {
        boolean var418C9026FB66B06011A0A6A75660D0BA_892620462 = (byteBuffer.isDirect());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509021661 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509021661;
        // ---------- Original Method ----------
        //return byteBuffer.isDirect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.090 -0400", hash_original_method = "A5873C4C7FD9475A7CC3E2D0E938541A", hash_generated_method = "F917A326A6520C3797DA6C6D3AE98EC4")
    @Override
    public boolean isReadOnly() {
        boolean varD09365DD25410F8B7D3D50C2BC7CE0DE_1042159448 = (byteBuffer.isReadOnly());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610943410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610943410;
        // ---------- Original Method ----------
        //return byteBuffer.isReadOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.091 -0400", hash_original_method = "DBC83B570884A1A98A3F46EF314D6E4A", hash_generated_method = "BCC413CA76D6A60E66A68C57F45E0679")
    @Override
    public ByteOrder order() {
ByteOrder var8FE5BB77B415046634F1C7025935FA68_1913012187 =         byteBuffer.order();
        var8FE5BB77B415046634F1C7025935FA68_1913012187.addTaint(taint);
        return var8FE5BB77B415046634F1C7025935FA68_1913012187;
        // ---------- Original Method ----------
        //return byteBuffer.order();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.091 -0400", hash_original_method = "5163488AC40767F8F030E728692C8A7E", hash_generated_method = "6C2E730E90A4F88B3DDBFF8D4A225549")
    @Override
    protected char[] protectedArray() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1525180702 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1525180702.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1525180702;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.092 -0400", hash_original_method = "11D0A2FFE917F2CC89FA6C9EBE3FCE7F", hash_generated_method = "87A65935D31FFC049B169E50E4E5E699")
    @Override
    protected int protectedArrayOffset() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_720742838 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_720742838.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_720742838;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.092 -0400", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "1F1B58DB59182B72D05C836C600C31D0")
    @Override
    protected boolean protectedHasArray() {
        boolean var68934A3E9455FA72420237EB05902327_2046013960 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788576470 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788576470;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.092 -0400", hash_original_method = "A46BC55FC455B05EF747C70552AAC069", hash_generated_method = "F0CB60C74F1E372AC186BF73970DA60D")
    @Override
    public CharBuffer put(char c) {
        addTaint(c);
    if(position == limit)        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1094727210 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1094727210.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1094727210;
        } //End block
        byteBuffer.putChar(position++ * SizeOf.CHAR, c);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1791350628 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1791350628.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1791350628;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //byteBuffer.putChar(position++ * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.093 -0400", hash_original_method = "3E41BE4D2E49CC352D854BBBF4557ADA", hash_generated_method = "3E4A44DE7718E195AF7A4F1F1A6E4517")
    @Override
    public CharBuffer put(int index, char c) {
        addTaint(c);
        addTaint(index);
        checkIndex(index);
        byteBuffer.putChar(index * SizeOf.CHAR, c);
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1683983158 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1683983158.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1683983158;
        // ---------- Original Method ----------
        //checkIndex(index);
        //byteBuffer.putChar(index * SizeOf.CHAR, c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.093 -0400", hash_original_method = "25F0118CCA8CBA4D22EEA9D027B39A5B", hash_generated_method = "11455CBDCF530CE9B6972665CB5FF58D")
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
CharBuffer var72A74007B2BE62B849F475C7BDA4658B_1727507953 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1727507953.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1727507953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.094 -0400", hash_original_method = "990BBC721EFE340A5DC5CE5D5661B284", hash_generated_method = "652198FA4277523BDE719CC169B69776")
    @Override
    public CharBuffer slice() {
        byteBuffer.limit(limit * SizeOf.CHAR);
        byteBuffer.position(position * SizeOf.CHAR);
        ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        CharBuffer result = new CharToByteBufferAdapter(bb);
        byteBuffer.clear();
CharBuffer varDC838461EE2FA0CA4C9BBB70A15456B0_1277356735 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1277356735.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1277356735;
        // ---------- Original Method ----------
        //byteBuffer.limit(limit * SizeOf.CHAR);
        //byteBuffer.position(position * SizeOf.CHAR);
        //ByteBuffer bb = byteBuffer.slice().order(byteBuffer.order());
        //CharBuffer result = new CharToByteBufferAdapter(bb);
        //byteBuffer.clear();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.094 -0400", hash_original_method = "4B1929E0A98D3F3896D7290A74598BEB", hash_generated_method = "145257948A54344C052A5DCCDC50E228")
    @Override
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
        checkStartEndRemaining(start, end);
        CharBuffer result = duplicate();
        result.limit(position + end);
        result.position(position + start);
CharSequence varDC838461EE2FA0CA4C9BBB70A15456B0_2011006904 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2011006904.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2011006904;
        // ---------- Original Method ----------
        //checkStartEndRemaining(start, end);
        //CharBuffer result = duplicate();
        //result.limit(position + end);
        //result.position(position + start);
        //return result;
    }

    
}

