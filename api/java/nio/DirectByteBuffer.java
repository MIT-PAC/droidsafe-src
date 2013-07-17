package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;

abstract class DirectByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.523 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "22BBBB3BDBDCD622FED3EBF1A70B4EC5")

    protected int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.524 -0400", hash_original_method = "474B95A59FDFCBE6BE31B5807DAED730", hash_generated_method = "6A61B09F75DFE3016FA31BD930001AD8")
    protected  DirectByteBuffer(MemoryBlock block, int capacity, int offset) {
        super(capacity, block);
        addTaint(capacity);
        addTaint(block.getTaint());
        long baseSize = block.getSize();
        if(baseSize >= 0 && (capacity + offset) > baseSize)        
        {
            IllegalArgumentException varD7DCE5792BF1B8D39906B96FBABAFF8E_516745506 = new IllegalArgumentException("capacity + offset > baseSize");
            varD7DCE5792BF1B8D39906B96FBABAFF8E_516745506.addTaint(taint);
            throw varD7DCE5792BF1B8D39906B96FBABAFF8E_516745506;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.524 -0400", hash_original_method = "05EA367CE37FB792328EB9B5E5178E53", hash_generated_method = "A9C32B7EC5C2EF9242C40D5B9E0A8DB4")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_430572679 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_430572679.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_430572679;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //this.block.peekByteArray(offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.525 -0400", hash_original_method = "5166EE5E9707A9E6D584C615F445133C", hash_generated_method = "9B521FFC3A3E94894C4D50F30426F414")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.526 -0400", hash_original_method = "ADD0EB5B665BFADA07EEB34F0C07C866", hash_generated_method = "176BA05F6EB357104CD12502AD0096EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.526 -0400", hash_original_method = "6E512C073258D3379E68BD1EE70E834D", hash_generated_method = "AC3570B4BADB57ABA839D624063F822C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.527 -0400", hash_original_method = "C51D1E84C7192049016360AA331FDA28", hash_generated_method = "9B95039658C6215A632514718613FC79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.527 -0400", hash_original_method = "3F36E5287836D62D1612D85220FCD9CD", hash_generated_method = "8EBC25C3E4463E5DCF3BF2FA1F23C0FF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.528 -0400", hash_original_method = "95F33E34C92C83F601EF4DD99BC92C04", hash_generated_method = "2DE7C1009C4112209DD39AFF67DF8FA3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.528 -0400", hash_original_method = "FD6E107A3BCF0EDBECB1B5D0CCC3DC10", hash_generated_method = "67E4AE0DA7AE5ADDBBE3D956ED76908B")
    @Override
    public final byte get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_935013857 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_935013857.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_935013857;
        } //End block
        byte varA08452AFA6D8011A0D3E4D41831C9EAC_725516789 = (this.block.peekByte(offset + position++));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1919439056 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1919439056;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return this.block.peekByte(offset + position++);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.528 -0400", hash_original_method = "4EC80D94823705ACCC824037AEC83986", hash_generated_method = "41F2296FCAD8D55587407DF7A9A062D2")
    @Override
    public final byte get(int index) {
        addTaint(index);
        checkIndex(index);
        byte var88AA2F6E38A7EAB39B9E0F4EAA7CD1BC_1341618573 = (this.block.peekByte(offset + index));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1627511631 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1627511631;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return this.block.peekByte(offset + index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.529 -0400", hash_original_method = "24C7DEF0B0564BDE5B8AAC76D5D642E1", hash_generated_method = "E5829C4AE8FA099CE3B69B437E4047D5")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_2075953319 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_2075953319.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_2075953319;
        } //End block
        char result = (char) this.block.peekShort(offset + position, order);
        position = newPosition;
        char varB4A88417B3D0170D754C647C30B7216A_1549227252 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_22805461 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_22805461;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.529 -0400", hash_original_method = "5FBE332600F81DB9B06A8F423199602B", hash_generated_method = "AA538B634B0771C065227EBAC2CCD2F1")
    @Override
    public final char getChar(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char varA01E2054467F2DF20E1DDE990695149E_863991790 = ((char) this.block.peekShort(offset + index, order));
                char varA87DEB01C5F539E6BDA34829C8EF2368_691219776 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_691219776;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) this.block.peekShort(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.530 -0400", hash_original_method = "5EFA43D409368A8372AA180C23146E16", hash_generated_method = "313EB24B58E9E7474F51567774E20497")
    @Override
    public final double getDouble() {
        int newPosition = position + SizeOf.DOUBLE;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_695504659 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_695504659.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_695504659;
        } //End block
        double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        position = newPosition;
        double varB4A88417B3D0170D754C647C30B7216A_1402422863 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_938620450 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_938620450;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.DOUBLE;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //double result = Double.longBitsToDouble(this.block.peekLong(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.530 -0400", hash_original_method = "96FC6E541F1994B391122E02AC73326B", hash_generated_method = "B6BF28212BD4933229F3798CE06F2703")
    @Override
    public final double getDouble(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.DOUBLE);
        double var2CDDA551B91DF1B7D28A42662D7D189E_1240415546 = (Double.longBitsToDouble(this.block.peekLong(offset + index, order)));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1976932281 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1976932281;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.DOUBLE);
        //return Double.longBitsToDouble(this.block.peekLong(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.531 -0400", hash_original_method = "2EE285AEEA4FEACBF45EAADB7A9A5368", hash_generated_method = "B68A5FD5E7F57B55EB46C93CBB6DBE6F")
    @Override
    public final float getFloat() {
        int newPosition = position + SizeOf.FLOAT;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_756452566 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_756452566.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_756452566;
        } //End block
        float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        position = newPosition;
        float varB4A88417B3D0170D754C647C30B7216A_1427224674 = (result);
                float var546ADE640B6EDFBC8A086EF31347E768_1577992867 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1577992867;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.FLOAT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //float result = Float.intBitsToFloat(this.block.peekInt(offset + position, order));
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.531 -0400", hash_original_method = "050B7A76EC6791ECC7468C2E0B06A7E7", hash_generated_method = "CD5E63954BF0D0974E8ABA6AF978A0AE")
    @Override
    public final float getFloat(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.FLOAT);
        float var4B655F805984C54ECC62A9DB7F6C0B53_956778385 = (Float.intBitsToFloat(this.block.peekInt(offset + index, order)));
                float var546ADE640B6EDFBC8A086EF31347E768_1399208020 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1399208020;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.FLOAT);
        //return Float.intBitsToFloat(this.block.peekInt(offset + index, order));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.532 -0400", hash_original_method = "D5783EC3520BA4180543335F9AE942E7", hash_generated_method = "FC337CF7E940A21D7D29A7CBE868D44F")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1076167199 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1076167199.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1076167199;
        } //End block
        int result = this.block.peekInt(offset + position, order);
        position = newPosition;
        int varB4A88417B3D0170D754C647C30B7216A_605768656 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265099005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265099005;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = this.block.peekInt(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.533 -0400", hash_original_method = "A56F512613C67F8975E594518A590248", hash_generated_method = "741362848F4A0B58A14CD49E55D20410")
    @Override
    public final int getInt(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var06814749BB2A5D3BFFCE308DC6BBB9AA_330901519 = (this.block.peekInt(offset + index, order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817784854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1817784854;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return this.block.peekInt(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.533 -0400", hash_original_method = "8F4B5A1B3C9B20E6E7648EDEC4DC7AE6", hash_generated_method = "386B7CB4F380F04C37D50930BA122F5E")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_373635306 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_373635306.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_373635306;
        } //End block
        long result = this.block.peekLong(offset + position, order);
        position = newPosition;
        long varB4A88417B3D0170D754C647C30B7216A_703371961 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_650526938 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_650526938;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = this.block.peekLong(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.533 -0400", hash_original_method = "94B0F156AE4944E60A0908AA30F792C3", hash_generated_method = "EC80B1557F50E0FEC0699837A3331F01")
    @Override
    public final long getLong(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long var59D4F21C7AC5495801C02D696BA69797_921151624 = (this.block.peekLong(offset + index, order));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_259735780 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_259735780;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return this.block.peekLong(offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.534 -0400", hash_original_method = "A23C234E65EF1DC26A40AB6396A2664F", hash_generated_method = "2685FE980DEC5C631BB5BA21AE755611")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1654144271 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1654144271.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1654144271;
        } //End block
        short result = this.block.peekShort(offset + position, order);
        position = newPosition;
        short varB4A88417B3D0170D754C647C30B7216A_439370493 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1119836298 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1119836298;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = this.block.peekShort(offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.534 -0400", hash_original_method = "3D46A49BA7FE751296135E85F30A2B25", hash_generated_method = "5D586F86F3C1C8BEF5483591D52664BB")
    @Override
    public final short getShort(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var94E022CB291C0ED0048A8D580395EFB6_1929024767 = (this.block.peekShort(offset + index, order));
                short var4F09DAA9D95BCB166A302407A0E0BABE_231801281 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_231801281;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return this.block.peekShort(offset + index, order);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.535 -0400", hash_original_method = "E1FB1E1D5A4E2DA2FDB3B2E50C938B59", hash_generated_method = "E09A64BFAA9352A2F59D32EED3ADD127")
    @Override
    public final boolean isDirect() {
        boolean varB326B5062B2F0E69046810717534CB09_1365086949 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790384764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790384764;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.535 -0400", hash_original_method = "B372104876D32901CA696FF1048C8368", hash_generated_method = "F9713BDBA9CA6D5B4ADE6EB061597987")
    public final void free() {
        block.free();
        // ---------- Original Method ----------
        //block.free();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.535 -0400", hash_original_method = "6C3FEAC6B139FD6B0B9CDBF24FD25811", hash_generated_method = "84BC4BB003B96FC512388C207F812DC5")
    @Override
    protected byte[] protectedArray() {
        byte[] array = this.block.array();
        if(array == null)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1635299239 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1635299239.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1635299239;
        } //End block
        byte[] varF1F713C9E000F5D3F280ADBD124DF4F5_254346775 = (array);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1730912116 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1730912116;
        // ---------- Original Method ----------
        //byte[] array = this.block.array();
        //if (array == null) {
            //throw new UnsupportedOperationException();
        //}
        //return array;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.536 -0400", hash_original_method = "BE42CB64719A7E35581BD2552BC2391A", hash_generated_method = "FBFB479C7B875FC91B958323B03B1BC2")
    @Override
    protected int protectedArrayOffset() {
        protectedArray();
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_549423877 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547390205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_547390205;
        // ---------- Original Method ----------
        //protectedArray();
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.536 -0400", hash_original_method = "F879D2589AC497F37E3C882F528D27BC", hash_generated_method = "FC6EF7BDE8B3654D0AE6B7D266A6B1E4")
    @Override
    protected boolean protectedHasArray() {
        boolean var17A645D7E84FD941A25274813BAD1414_223988904 = (protectedArray() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_478828966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_478828966;
        // ---------- Original Method ----------
        //return protectedArray() != null;
    }

    
}

