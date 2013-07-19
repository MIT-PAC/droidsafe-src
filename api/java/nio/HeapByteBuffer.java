package java.nio;

// Droidsafe Imports
import libcore.io.Memory;
import libcore.io.SizeOf;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract class HeapByteBuffer extends BaseByteBuffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.086 -0400", hash_original_field = "8D50CD27AA8B6BEC65C484FFCC5B2334", hash_generated_field = "09D04850ECF89DF686CB8B497D53F4F4")

    byte[] backingArray;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.086 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.086 -0400", hash_original_method = "E17EA7652E4F5A67C65770DE13DD4AE3", hash_generated_method = "4FA8540A9DD1600A999EF445349CC6BD")
      HeapByteBuffer(byte[] backingArray) {
        this(backingArray, backingArray.length, 0);
        addTaint(backingArray[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.087 -0400", hash_original_method = "720B251A66EBAD61E39D94F5757C7908", hash_generated_method = "64F667538DCF04571002FE958EFD5EA7")
      HeapByteBuffer(int capacity) {
        this(new byte[capacity], capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.088 -0400", hash_original_method = "7E0C48043B88A8991A81994678604015", hash_generated_method = "129CE4FF3CBF7E5558DF0B267E8A3215")
      HeapByteBuffer(byte[] backingArray, int capacity, int offset) {
        super(capacity, null);
        addTaint(capacity);
        this.backingArray = backingArray;
        this.offset = offset;
        if(offset + capacity > backingArray.length)        
        {
            IndexOutOfBoundsException varA140FD613E7280215771A1DD51AD7887_1102665641 = new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    ", capacity=" + capacity + ", offset=" + offset);
            varA140FD613E7280215771A1DD51AD7887_1102665641.addTaint(taint);
            throw varA140FD613E7280215771A1DD51AD7887_1102665641;
        } //End block
        // ---------- Original Method ----------
        //this.backingArray = backingArray;
        //this.offset = offset;
        //if (offset + capacity > backingArray.length) {
            //throw new IndexOutOfBoundsException("backingArray.length=" + backingArray.length +
                    //", capacity=" + capacity + ", offset=" + offset);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.089 -0400", hash_original_method = "A92B26D30665425608E93AFD3985B529", hash_generated_method = "3C279E6EC6713684AECACF8A02BF71E8")
    @Override
    public final ByteBuffer get(byte[] dst, int dstOffset, int byteCount) {
        addTaint(byteCount);
        addTaint(dstOffset);
        addTaint(dst[0]);
        checkGetBounds(1, dst.length, dstOffset, byteCount);
        System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        position += byteCount;
ByteBuffer var72A74007B2BE62B849F475C7BDA4658B_1405131957 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1405131957.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1405131957;
        // ---------- Original Method ----------
        //checkGetBounds(1, dst.length, dstOffset, byteCount);
        //System.arraycopy(backingArray, offset + position, dst, dstOffset, byteCount);
        //position += byteCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.089 -0400", hash_original_method = "ADCC30D9FE17E9265DD10F45753F8D68", hash_generated_method = "FCE93A3E89527B5C45AA4CAD03B88E0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.090 -0400", hash_original_method = "83F82E1C4D1B0FECE4775D0F7331C2A9", hash_generated_method = "C5EE43AE3882CB7E6455A6F762627866")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.091 -0400", hash_original_method = "28783106EE8F5B0602DB80B1FE3018CE", hash_generated_method = "0981394B5C7CBBEA83437E2184E1AE86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.092 -0400", hash_original_method = "8AC7AD179B2BD3799E5966071FB1A6E9", hash_generated_method = "4B8B9D0607E57FD9063D9687B94D7191")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.093 -0400", hash_original_method = "3C880FD9EFF1926FF9582E7F1291E034", hash_generated_method = "1FA1950758A7E6EB92742AB9F09DBBB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.093 -0400", hash_original_method = "89F4F4A0F85F41D910E8D20C3ACD7123", hash_generated_method = "13BC898C801FD5BF7A63895FE79D26A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.094 -0400", hash_original_method = "CB9AAD8BA04B2044061C99EDA53631A5", hash_generated_method = "7D68859E3E2C7CE281B721B835BCB886")
    @Override
    public final byte get() {
        if(position == limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_426084662 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_426084662.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_426084662;
        } //End block
        byte varD1A88672373807059A15983DE4C2AC9F_1742594945 = (backingArray[offset + position++]);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_477579603 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_477579603;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferUnderflowException();
        //}
        //return backingArray[offset + position++];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.095 -0400", hash_original_method = "9AAE834531B3F44ED7B8F1D4ABA54327", hash_generated_method = "3282FAE36499EDCBA27CCF4D966ABB48")
    @Override
    public final byte get(int index) {
        addTaint(index);
        checkIndex(index);
        byte varF4617D5762E2F642102CBB5F4FA87F0A_1824715461 = (backingArray[offset + index]);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_194267729 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_194267729;
        // ---------- Original Method ----------
        //checkIndex(index);
        //return backingArray[offset + index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.095 -0400", hash_original_method = "A30CF2DCEAEB1ADBE9659D1E77D9D3A8", hash_generated_method = "E2B15B182C592AF47866F0CB467B7D5B")
    @Override
    public final char getChar() {
        int newPosition = position + SizeOf.CHAR;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1613417832 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1613417832.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1613417832;
        } //End block
        char result = (char) Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        char varB4A88417B3D0170D754C647C30B7216A_1673408206 = (result);
                char varA87DEB01C5F539E6BDA34829C8EF2368_352570789 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_352570789;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.CHAR;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //char result = (char) Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.096 -0400", hash_original_method = "9FC96B9C645980EC4C42FC8A098BD17B", hash_generated_method = "D826F0756AEC38E789BF49B0107FAC34")
    @Override
    public final char getChar(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.CHAR);
        char var3FFE2EDD535AAC6A09854906122D6020_751990730 = ((char) Memory.peekShort(backingArray, offset + index, order));
                char varA87DEB01C5F539E6BDA34829C8EF2368_357338723 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_357338723;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.CHAR);
        //return (char) Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.096 -0400", hash_original_method = "15CD222F9D1D43117CE6FF35DE1821E1", hash_generated_method = "393E682818BFB0113A0527A9C314A362")
    @Override
    public final double getDouble() {
        double var7C3EC81C2F8E6C8D7188C0D093ADF925_1534116238 = (Double.longBitsToDouble(getLong()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_661703450 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_661703450;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.096 -0400", hash_original_method = "2A94C74E4D47B2870E4CD8E58AB3C61D", hash_generated_method = "5DE42BF19EEEC8B573E195AF748713C4")
    @Override
    public final double getDouble(int index) {
        addTaint(index);
        double varE02CC5BEFA832A5E267A97C32205EE06_960501568 = (Double.longBitsToDouble(getLong(index)));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1055633997 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1055633997;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(getLong(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.097 -0400", hash_original_method = "47893679DF29F9C7305C0FEFB94D5263", hash_generated_method = "A88E50717BD1548BCA3E514E38ACA012")
    @Override
    public final float getFloat() {
        float var79C8AD123DE89C49D5CF75CD701AB8B1_1154916934 = (Float.intBitsToFloat(getInt()));
                float var546ADE640B6EDFBC8A086EF31347E768_1667345121 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1667345121;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.097 -0400", hash_original_method = "416C4BCEE10AD6D26C3C84E2597AE8E2", hash_generated_method = "9FFEBEF72E88341359619FAB70B6D976")
    @Override
    public final float getFloat(int index) {
        addTaint(index);
        float varCF50211A41435D3C0E3F6678E8DA12F5_1457457033 = (Float.intBitsToFloat(getInt(index)));
                float var546ADE640B6EDFBC8A086EF31347E768_1883202984 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1883202984;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(getInt(index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.097 -0400", hash_original_method = "915288BFB7584CF14BE85156D3784045", hash_generated_method = "EC6D4EEF2569381DD0939A808EC87721")
    @Override
    public final int getInt() {
        int newPosition = position + SizeOf.INT;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1575753160 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1575753160.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1575753160;
        } //End block
        int result = Memory.peekInt(backingArray, offset + position, order);
        position = newPosition;
        int varB4A88417B3D0170D754C647C30B7216A_483557437 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261705571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261705571;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.INT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //int result = Memory.peekInt(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.098 -0400", hash_original_method = "458AAE21B6E3B170135E629CE400B5BC", hash_generated_method = "C217AE5ED470FBC99BA999C05361BD40")
    @Override
    public final int getInt(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.INT);
        int var992FA0F7B0599EC3A2009C4999D79B1D_1804044356 = (Memory.peekInt(backingArray, offset + index, order));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924980619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1924980619;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.INT);
        //return Memory.peekInt(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.099 -0400", hash_original_method = "8649950490E02A38495D16EDE99C5440", hash_generated_method = "C7C1337462B8F1C1F9B8D7214EFD0EFE")
    @Override
    public final long getLong() {
        int newPosition = position + SizeOf.LONG;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_2037855396 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_2037855396.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_2037855396;
        } //End block
        long result = Memory.peekLong(backingArray, offset + position, order);
        position = newPosition;
        long varB4A88417B3D0170D754C647C30B7216A_1287138825 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1140940143 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1140940143;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.LONG;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //long result = Memory.peekLong(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.099 -0400", hash_original_method = "DA73492717D47126159C560DCCEA76B8", hash_generated_method = "FB6D3659A13874A77D32196D33757277")
    @Override
    public final long getLong(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.LONG);
        long varEF935AA337B009A70942511AB114C941_149605718 = (Memory.peekLong(backingArray, offset + index, order));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1252540487 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1252540487;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.LONG);
        //return Memory.peekLong(backingArray, offset + index, order);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.100 -0400", hash_original_method = "D81DB9BF3EF98746269534EE74DB9F13", hash_generated_method = "6893646E761DA2DC77D82C102E0D90F2")
    @Override
    public final short getShort() {
        int newPosition = position + SizeOf.SHORT;
        if(newPosition > limit)        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_1656512420 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_1656512420.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_1656512420;
        } //End block
        short result = Memory.peekShort(backingArray, offset + position, order);
        position = newPosition;
        short varB4A88417B3D0170D754C647C30B7216A_774752994 = (result);
                short var4F09DAA9D95BCB166A302407A0E0BABE_2136696851 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2136696851;
        // ---------- Original Method ----------
        //int newPosition = position + SizeOf.SHORT;
        //if (newPosition > limit) {
            //throw new BufferUnderflowException();
        //}
        //short result = Memory.peekShort(backingArray, offset + position, order);
        //position = newPosition;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.100 -0400", hash_original_method = "1734D425058DF9CB5EF1DD869B4BCEDF", hash_generated_method = "F52D799AD2386DE38117396D108EB30E")
    @Override
    public final short getShort(int index) {
        addTaint(index);
        checkIndex(index, SizeOf.SHORT);
        short var119FE6C282731AD533EAA7FA019621E0_1171886304 = (Memory.peekShort(backingArray, offset + index, order));
                short var4F09DAA9D95BCB166A302407A0E0BABE_871254783 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_871254783;
        // ---------- Original Method ----------
        //checkIndex(index, SizeOf.SHORT);
        //return Memory.peekShort(backingArray, offset + index, order);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.100 -0400", hash_original_method = "5B6C9F359344527666A57577F107BCAE", hash_generated_method = "24D6864F0AB52BE2BAA865D42CFA713F")
    @Override
    public final boolean isDirect() {
        boolean var68934A3E9455FA72420237EB05902327_793772235 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369797438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369797438;
        // ---------- Original Method ----------
        //return false;
    }

    
}

