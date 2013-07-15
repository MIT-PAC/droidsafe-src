package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.199 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.200 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "2F67B7CA47AEA759E493A44C419680DB")
    protected  DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        long baseSize = block.getSize();
    if(baseSize >= 0 && (capacity + offset) > baseSize)        
        {
            IllegalArgumentException varD7DCE5792BF1B8D39906B96FBABAFF8E_1794955234 = new IllegalArgumentException("capacity + offset > baseSize");
            varD7DCE5792BF1B8D39906B96FBABAFF8E_1794955234.addTaint(taint);
            throw varD7DCE5792BF1B8D39906B96FBABAFF8E_1794955234;
        } //End block
        this.offset = offset;
        this.effectiveDirectAddress = block.toInt() + offset;
        // ---------- Original Method ----------
        //long baseSize = block.getSize();
        //if (baseSize >= 0 && (capacity + offset) > baseSize) {
            //throw new IllegalArgumentException("capacity + offset > baseSize");
        //}
        //this.offset = offset;
        //this.effectiveDirectAddress = block.toInt() + offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.201 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "27608027942EBCF2DD39720CF7493A3A")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1668423608 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1668423608.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1668423608;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.201 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "9B521FFC3A3E94894C4D50F30426F414")
    final void get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //this.block.peekCharArray(offset + position, dst, dstOffset, charCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.202 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "176BA05F6EB357104CD12502AD0096EA")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //this.block.peekDoubleArray(offset + position, dst, dstOffset, doubleCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.202 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "AC3570B4BADB57ABA839D624063F822C")
    final void get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //this.block.peekFloatArray(offset + position, dst, dstOffset, floatCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.203 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "9B95039658C6215A632514718613FC79")
    final void get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //this.block.peekIntArray(offset + position, dst, dstOffset, intCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.204 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "8EBC25C3E4463E5DCF3BF2FA1F23C0FF")
    final void get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //this.block.peekLongArray(offset + position, dst, dstOffset, longCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.204 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "2DE7C1009C4112209DD39AFF67DF8FA3")
    final void get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //this.block.peekShortArray(offset + position, dst, dstOffset, shortCount, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.204 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "8252AF9D06E886AB270A63D5A338AB00")
    @Override
    public final byte get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_767879425 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_767879425.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_767879425;
        } //End block
        byte varA08452AFA6D8011A0D3E4D41831C9EAC_740432556 = (this.block.peekByte(offset + position++));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_740055704 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_740055704;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.205 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "4AF54DBCE1219C1B6F90C1B4999FCEC9")
    @Override
    public final byte get(int index) {
        addTaint(index);
        checkIndex(index);
        byte var88AA2F6E38A7EAB39B9E0F4EAA7CD1BC_1871411583 = (this.block.peekByte(offset + index));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1593416135 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1593416135;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.205 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "5C9B4565422B5CFE16819A1ACA56422A")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_488700831 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_488700831.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_488700831;
        } //End block
        char result = (char) this.block.peekShort(offset + position, order);
        position = newPosition;
        char varB4A88417B3D0170D754C647C30B7216A_2072335416 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1187880203 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1187880203;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.206 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "6FCBD6E2A8631F55F72415BFDD3742B2")
    @Override
    public final char getChar(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char varA01E2054467F2DF20E1DDE990695149E_854624797 = ((char) this.block.peekShort(offset + index, order));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1005854466 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1005854466;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.206 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "D85FD9E275FF5DBC0696D39D7A1048D0")
    @Override
    public final double getDouble() {
        int newPosition = position + SizeOf.DOUBLE;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1099593775 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1099593775.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1099593775;
        } //End block
        double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        position = newPosition;
        double varB4A88417B3D0170D754C647C30B7216A_448356844 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1692171615 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1692171615;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.207 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "A656DA4F1B48F6370D3B6257B0CF09F6")
    @Override
    public final double getDouble(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        double var2CDDA551B91DF1B7D28A42662D7D189E_203922151 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1072106231 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1072106231;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.207 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "65EBEADFCD420E33693B1D612DBD8731")
    @Override
    public final float getFloat() {
        int newPosition = position + SizeOf.FLOAT;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_432244889 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_432244889.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_432244889;
        } //End block
        float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        position = newPosition;
        float varB4A88417B3D0170D754C647C30B7216A_277745558 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_415896577 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_415896577;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.208 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "8049840753DDE61D43E4BF9CBD3923ED")
    @Override
    public final float getFloat(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        float var4B655F805984C54ECC62A9DB7F6C0B53_555601613 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
                float var546ADE640B6EDFBC8A086EF31347E768_171260772 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_171260772;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.208 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "B0E36F862436248C9FDC10F157BB87C9")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1770466896 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1770466896.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1770466896;
        } //End block
        int result = this.block.peekInt(offset + position, order);
        position = newPosition;
        int varB4A88417B3D0170D754C647C30B7216A_1638781739 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654615682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_654615682;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = this.block.peekInt(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.209 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "21A3EBA3E485F278EC6945B2F2CF8172")
    @Override
    public final int getInt(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var06814749BB2A5D3BFFCE308DC6BBB9AA_1288207382 = (this.block.peekInt(offset + index, order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674617180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_674617180;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.209 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "CDC593FDB4FDCB3BC69FCA378ACD3FB0")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_245341890 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_245341890.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_245341890;
        } //End block
        long result = this.block.peekLong(offset + position, order);
        position = newPosition;
        long varB4A88417B3D0170D754C647C30B7216A_1319146552 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1021530115 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1021530115;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = this.block.peekLong(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.210 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "9990A90A67D2129A4DEF21CB67025E49")
    @Override
    public final long getLong(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long var59D4F21C7AC5495801C02D696BA69797_589594476 = (this.block.peekLong(offset + index, order));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_692883491 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_692883491;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.210 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "46EB13545A05701AE337099814578C90")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_319845983 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_319845983.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_319845983;
        } //End block
        short result = this.block.peekShort(offset + position, order);
        position = newPosition;
        short varB4A88417B3D0170D754C647C30B7216A_934304562 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1349794569 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1349794569;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.210 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "0A7AD6AEE395B0E4F8076BDDF0859E04")
    @Override
    public final short getShort(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var94E022CB291C0ED0048A8D580395EFB6_467622766 = (this.block.peekShort(offset + index, order));
                short var4F09DAA9D95BCB166A302407A0E0BABE_75224060 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_75224060;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.211 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "AE11416DD92DE58C912404C91D1050FB")
    @Override
    public final boolean isDirect() {
        boolean varB326B5062B2F0E69046810717534CB09_148232498 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410265335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410265335;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.211 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.212 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "D293FFFAB4AE0E16B24D77143075BB0A")
    @Override
    protected byte[] protectedArray() {
        byte[] array = this.block.array();
    if(array == null)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_389820531 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_389820531.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_389820531;
        } //End block
        byte[] varF1F713C9E000F5D3F280ADBD124DF4F5_352923680 = (array);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_604539532 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_604539532;
        // ---------- Original Method ----------
        //byte[] array = this.block.array();
        //if (array == null) {
            //throw new UnsupportedOperationException();
        //}
        //return array;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.212 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "ACF10DE12CA463C1B6584374D140AF0A")
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1883424615 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205064308 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1205064308;
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.212 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "74FAB615B7427912BFA6F7F27EED481E")
    @Override
    protected boolean protectedHasArray() {
        boolean var17A645D7E84FD941A25274813BAD1414_705339760 = (protectedArray() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646976339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646976339;
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}

