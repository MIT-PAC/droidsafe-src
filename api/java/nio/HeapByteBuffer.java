package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.io.SizeOf;
import libcore.io.Memory;

abstract class HeapByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.598 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "09D04850ECF89DF686CB8B497D53F4F4")

    byte[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.598 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.598 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "4FA8540A9DD1600A999EF445349CC6BD")
      HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.599 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "64F667538DCF04571002FE958EFD5EA7")
      HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.600 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "6FA9919B580D3D6FD98C90C95AE79160")
      HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
    if(offset + capacity > backingArray.length)        
        {
            IndexOutOfBoundsException varA140FD613E7280215771A1DD51AD7887_1475248688 = new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    ", capacity=" + capacity + ", offset=" + offset);
            varA140FD613E7280215771A1DD51AD7887_1475248688.addTaint(taint);
            throw varA140FD613E7280215771A1DD51AD7887_1475248688;
        } //End block
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
        //if (offset + capacity > backingArray.length) {
            //throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    //", capacity=" + capacity + ", offset=" + offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.602 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "D0996B34875252D85AE88CCEF95CBFB7")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_315523770 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_315523770.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_315523770;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.604 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "FCE93A3E89527B5C45AA4CAD03B88E0C")
    final void get(char[] dst, int dstOffset, int charCount) {
        addTaint(charCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.CHAR, dst.length, dstOffset, charCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.CHAR, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.604 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "C5EE43AE3882CB7E6455A6F762627866")
    final void get(double[] dst, int dstOffset, int doubleCount) {
        addTaint(doubleCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.DOUBLE, dst.length, dstOffset, doubleCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.DOUBLE, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.605 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "0981394B5C7CBBEA83437E2184E1AE86")
    final void get(float[] dst, int dstOffset, int floatCount) {
        addTaint(floatCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.FLOAT, dst.length, dstOffset, floatCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.FLOAT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.606 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "4B8B9D0607E57FD9063D9687B94D7191")
    final void get(int[] dst, int dstOffset, int intCount) {
        addTaint(intCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.INT, dst.length, dstOffset, intCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.INT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.606 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "1FA1950758A7E6EB92742AB9F09DBBB3")
    final void get(long[] dst, int dstOffset, int longCount) {
        addTaint(longCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.LONG, dst.length, dstOffset, longCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.LONG, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.607 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "13BC898C801FD5BF7A63895FE79D26A1")
    final void get(short[] dst, int dstOffset, int shortCount) {
        addTaint(shortCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        position += byteCount;
        // ---------- Original Method ----------
        //int byteCount = checkGetBounds(SizeOf.SHORT, dst.length, dstOffset, shortCount);
        //Memory.unsafeBulkGet(dst, dstOffset, byteCount, backingArray, offset + position, SizeOf.SHORT, order.needsSwap);
        //position += byteCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.607 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "A3038CEA5239C005E293CADF6A157C8E")
    @Override
    public final byte get() {
    if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1077531689 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1077531689.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1077531689;
        } //End block
        byte varD1A88672373807059A15983DE4C2AC9F_1827906166 = (backingArray[offset + position++]);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1244721168 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1244721168;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.608 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "3E55ECFE5B168D03EBC96BDB181FD2CE")
    @Override
    public final byte get(int index) {
        addTaint(index);
        checkIndex(index);
        byte varF4617D5762E2F642102CBB5F4FA87F0A_1600514541 = (backingArray[offset + index]);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_410925712 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_410925712;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.608 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "DD3BFB7DEDD8A5F946F967985ED90DD6")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_9607278 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_9607278.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_9607278;
        } //End block
        char result = (char) Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        char varB4A88417B3D0170D754C647C30B7216A_98466140 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_588998055 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_588998055;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.609 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "85979E870EC5509106F033D35F02357D")
    @Override
    public final char getChar(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var3FFE2EDD535AAC6A09854906122D6020_561608574 = ((char) Memory.peekShort(backingArray, offset + index, order));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1231310906 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1231310906;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.609 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "B378779F3A4D7FEE28F33150333AF32B")
    @Override
    public final double getDouble() {
        double var7C3EC81C2F8E6C8D7188C0D093ADF925_1852147651 = (Double.longBitsToDouble(getLong()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_941606865 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_941606865;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.610 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "F151F3769A598C435E885A96EB9831D7")
    @Override
    public final double getDouble(int index) {
        addTaint(index);
        double varE02CC5BEFA832A5E267A97C32205EE06_2031280199 = (Double.longBitsToDouble(getLong(index)));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1532431398 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1532431398;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.610 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "4661739008B64FC36D3D6A5C058A6123")
    @Override
    public final float getFloat() {
        float var79C8AD123DE89C49D5CF75CD701AB8B1_407954373 = (Float.intBitsToFloat(getInt()));
                float var546ADE640B6EDFBC8A086EF31347E768_1465655702 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1465655702;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.610 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "9555249A07A407E6BD42F51AD700D69C")
    @Override
    public final float getFloat(int index) {
        addTaint(index);
        float varCF50211A41435D3C0E3F6678E8DA12F5_1325856638 = (Float.intBitsToFloat(getInt(index)));
                float var546ADE640B6EDFBC8A086EF31347E768_488387685 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_488387685;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.611 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "BBFC06030B81B9F703A90FE69E412AB1")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_57592732 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_57592732.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_57592732;
        } //End block
        int result = Memory.peekInt(backingArray, offset + position, order);
        position = newPosition;
        int varB4A88417B3D0170D754C647C30B7216A_762441541 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356171559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356171559;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = Memory.peekInt(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.612 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "03F7A22B06092892ED64FC39CFAA5332")
    @Override
    public final int getInt(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var992FA0F7B0599EC3A2009C4999D79B1D_726854431 = (Memory.peekInt(backingArray, offset + index, order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862205777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_862205777;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return Memory.peekInt(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.613 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "D3D3927C45C42F43AE3632F2869A5FFA")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_578964267 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_578964267.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_578964267;
        } //End block
        long result = Memory.peekLong(backingArray, offset + position, order);
        position = newPosition;
        long varB4A88417B3D0170D754C647C30B7216A_2123978618 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_832187331 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_832187331;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = Memory.peekLong(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.613 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "44019BF9C780946336C9CDC0F0216574")
    @Override
    public final long getLong(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long varEF935AA337B009A70942511AB114C941_392951413 = (Memory.peekLong(backingArray, offset + index, order));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1711082908 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1711082908;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return Memory.peekLong(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.614 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "698661B575305D2CC698554C5BA66A2C")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
    if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_258360807 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_258360807.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_258360807;
        } //End block
        short result = Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        short varB4A88417B3D0170D754C647C30B7216A_24816447 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1272596010 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1272596010;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.615 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "631B0D4FDFAE67FBF9E477B663F53C57")
    @Override
    public final short getShort(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var119FE6C282731AD533EAA7FA019621E0_1203025496 = (Memory.peekShort(backingArray, offset + index, order));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1270786138 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1270786138;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:51.615 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "2AF94142923016795823F16E2B06C651")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_90168618 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000884289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000884289;
        // ---------- Original Method ----------
        //return false;
    }

    
}

