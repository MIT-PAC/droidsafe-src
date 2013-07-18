package java.nio;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Buffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.208 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.208 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.208 -0400", hash_original_field = "2016342B58ED3C0B49BEDE5E54A68A45", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.209 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.209 -0400", hash_original_field = "C96EE4AC8F4CC27B0B64279117650777", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

    int _elementSizeShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.209 -0400", hash_original_field = "74061CC9716705B5DAF7FFAEDC404616", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.209 -0400", hash_original_field = "14511F2F5564650D129CA7CABC333278", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.210 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "C95F234BA0C2821AC6A3116D9CA2D382")
      Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        this._elementSizeShift = elementSizeShift;
        if(capacity < 0)        
        {
            IllegalArgumentException varA12B62205B960623EBBA8A01150F526D_1667936816 = new IllegalArgumentException("capacity < 0: " + capacity);
            varA12B62205B960623EBBA8A01150F526D_1667936816.addTaint(taint);
            throw varA12B62205B960623EBBA8A01150F526D_1667936816;
        } //End block
        this.capacity = this.limit = capacity;
        this.block = block;
        // ---------- Original Method ----------
        //this._elementSizeShift = elementSizeShift;
        //if (capacity < 0) {
            //throw new IllegalArgumentException("capacity < 0: " + capacity);
        //}
        //this.capacity = this.limit = capacity;
        //this.block = block;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Object array();

    
    @DSModeled(DSC.SAFE)
    public abstract int arrayOffset();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.211 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "643FC94C8784ECE0CFC79152355069BB")
    public final int capacity() {
        int var7BD14A231864E618E1840C7E117E59C1_686211902 = (capacity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386818930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_386818930;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.212 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "531E6FA709678E5EB4057BD1EE9A7465")
     void checkIndex(int index) {
        addTaint(index);
        if(index < 0 || index >= limit)        
        {
            IndexOutOfBoundsException var2AE91013EDA9724F76B2720BFFF37786_875804911 = new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
            var2AE91013EDA9724F76B2720BFFF37786_875804911.addTaint(taint);
            throw var2AE91013EDA9724F76B2720BFFF37786_875804911;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index >= limit) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.212 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "EE36C7161684EC3EAC8880B933ABB948")
     void checkIndex(int index, int sizeOfType) {
        addTaint(sizeOfType);
        addTaint(index);
        if(index < 0 || index > limit - sizeOfType)        
        {
            IndexOutOfBoundsException var485B03E5FC6C5A45B069E745C3202EE8_1548442381 = new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
            var485B03E5FC6C5A45B069E745C3202EE8_1548442381.addTaint(taint);
            throw var485B03E5FC6C5A45B069E745C3202EE8_1548442381;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index > limit - sizeOfType) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    //", size of type=" + sizeOfType);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.213 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "FBEA05D46A2B5653DD9269F1C1074E98")
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(length);
        addTaint(bytesPerElement);
        int byteCount = bytesPerElement * count;
        if((offset | count) < 0 || offset > length || length - offset < count)        
        {
            IndexOutOfBoundsException var237C2E3911559A7B9C5446946C75A3B3_86598984 = new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
            var237C2E3911559A7B9C5446946C75A3B3_86598984.addTaint(taint);
            throw var237C2E3911559A7B9C5446946C75A3B3_86598984;
        } //End block
        if(byteCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_410095992 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_410095992.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_410095992;
        } //End block
        int varA43EF6D60A83013EA1A61A23BDB16029_39697478 = (byteCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070188071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1070188071;
        // ---------- Original Method ----------
        //int byteCount = bytesPerElement * count;
        //if ((offset | count) < 0 || offset > length || length - offset < count) {
            //throw new IndexOutOfBoundsException("offset=" + offset +
                    //", count=" + count + ", length=" + length);
        //}
        //if (byteCount > remaining()) {
            //throw new BufferUnderflowException();
        //}
        //return byteCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.214 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "2A7DE8E6888AF3DDFCF81298076E8593")
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(length);
        addTaint(bytesPerElement);
        int byteCount = bytesPerElement * count;
        if((offset | count) < 0 || offset > length || length - offset < count)        
        {
            IndexOutOfBoundsException var237C2E3911559A7B9C5446946C75A3B3_355817890 = new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
            var237C2E3911559A7B9C5446946C75A3B3_355817890.addTaint(taint);
            throw var237C2E3911559A7B9C5446946C75A3B3_355817890;
        } //End block
        if(byteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_811103886 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_811103886.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_811103886;
        } //End block
        if(isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1162898952 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1162898952.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1162898952;
        } //End block
        int varA43EF6D60A83013EA1A61A23BDB16029_1061289177 = (byteCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421665611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_421665611;
        // ---------- Original Method ----------
        //int byteCount = bytesPerElement * count;
        //if ((offset | count) < 0 || offset > length || length - offset < count) {
            //throw new IndexOutOfBoundsException("offset=" + offset +
                    //", count=" + count + ", length=" + length);
        //}
        //if (byteCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //if (isReadOnly()) {
            //throw new ReadOnlyBufferException();
        //}
        //return byteCount;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.215 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "74514D9CB1D595F711F614E747EA84BF")
     void checkStartEndRemaining(int start, int end) {
        addTaint(end);
        addTaint(start);
        if(end < start || start < 0 || end > remaining())        
        {
            IndexOutOfBoundsException var2952B7EF9E478CBDEDD85E1CD117B0D4_1295598548 = new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
            var2952B7EF9E478CBDEDD85E1CD117B0D4_1295598548.addTaint(taint);
            throw var2952B7EF9E478CBDEDD85E1CD117B0D4_1295598548;
        } //End block
        // ---------- Original Method ----------
        //if (end < start || start < 0 || end > remaining()) {
            //throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    //", remaining()=" + remaining());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.216 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "A5A91B9B3125D1EEA6D8F59E5B2DCE13")
    public final Buffer clear() {
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
Buffer var72A74007B2BE62B849F475C7BDA4658B_1858140566 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1858140566.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1858140566;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.217 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "302FD9F3AAF288CB227C7776BEE4A8D1")
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = UNSET_MARK;
Buffer var72A74007B2BE62B849F475C7BDA4658B_2113616573 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2113616573.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2113616573;
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean hasArray();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.218 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "27C4F005325A344587C3BEA3C5E685A7")
    public final boolean hasRemaining() {
        boolean varA311A48D68DFAB1F8655269A7132150E_1524649912 = (position < limit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403813473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403813473;
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isDirect();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.219 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "4F0920F368BDEF5E4446F67809338FD9")
    final void checkWritable() {
        if(isReadOnly())        
        {
            IllegalArgumentException var7D6FDD050D09806E382B195E32E4AE58_746274835 = new IllegalArgumentException("read-only buffer");
            var7D6FDD050D09806E382B195E32E4AE58_746274835.addTaint(taint);
            throw var7D6FDD050D09806E382B195E32E4AE58_746274835;
        } //End block
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.219 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "33D7600FBFD296245299D51429F32444")
    public final int limit() {
        int varAA9F73EEA60A006820D0F8768BC8A3FC_1043395320 = (limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056015246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2056015246;
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.220 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "242146ABFA1861F6B35098E2112B71C3")
    public final Buffer limit(int newLimit) {
        addTaint(newLimit);
        limitImpl(newLimit);
Buffer var72A74007B2BE62B849F475C7BDA4658B_859251701 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_859251701.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_859251701;
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.220 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "C7E63BF741100C9481A05E6C57AD7203")
     void limitImpl(int newLimit) {
        if(newLimit < 0 || newLimit > capacity)        
        {
            IllegalArgumentException varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1367143488 = new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
            varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1367143488.addTaint(taint);
            throw varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1367143488;
        } //End block
        limit = newLimit;
        if(position > newLimit)        
        {
            position = newLimit;
        } //End block
        if((mark != UNSET_MARK) && (mark > newLimit))        
        {
            mark = UNSET_MARK;
        } //End block
        // ---------- Original Method ----------
        //if (newLimit < 0 || newLimit > capacity) {
            //throw new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
        //}
        //limit = newLimit;
        //if (position > newLimit) {
            //position = newLimit;
        //}
        //if ((mark != UNSET_MARK) && (mark > newLimit)) {
            //mark = UNSET_MARK;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.221 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "E4229F9F9375D4C6F407D3A060B76DBC")
    public final Buffer mark() {
        mark = position;
Buffer var72A74007B2BE62B849F475C7BDA4658B_850260538 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_850260538.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_850260538;
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.221 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "F6B1D08188E952589E767D5A604EF0E1")
    public final int position() {
        int var4757FE07FD492A8BE0EA6A760D683D6E_122506492 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647613523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647613523;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.222 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "A017FE68A22AA263274246607FDFEEDE")
    public final Buffer position(int newPosition) {
        addTaint(newPosition);
        positionImpl(newPosition);
Buffer var72A74007B2BE62B849F475C7BDA4658B_1809890890 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1809890890.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1809890890;
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.222 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "2A7411ADE82067CA5F8EDA4354A8F26A")
     void positionImpl(int newPosition) {
        if(newPosition < 0 || newPosition > limit)        
        {
            IllegalArgumentException var6A7339BB80AF6B4E498E98C57B9CBD80_1588756859 = new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
            var6A7339BB80AF6B4E498E98C57B9CBD80_1588756859.addTaint(taint);
            throw var6A7339BB80AF6B4E498E98C57B9CBD80_1588756859;
        } //End block
        position = newPosition;
        if((mark != UNSET_MARK) && (mark > position))        
        {
            mark = UNSET_MARK;
        } //End block
        // ---------- Original Method ----------
        //if (newPosition < 0 || newPosition > limit) {
            //throw new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
        //}
        //position = newPosition;
        //if ((mark != UNSET_MARK) && (mark > position)) {
            //mark = UNSET_MARK;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.223 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "72AEDF53D8E6F16ADB6199294AFED2D9")
    public final int remaining() {
        int var09EF638EAE66D4F89E996C4321DBBCF9_382647427 = (limit - position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561929676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561929676;
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.223 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "8EED8562DDAAE30D9CA79193E872C99C")
    public final Buffer reset() {
        if(mark == UNSET_MARK)        
        {
            InvalidMarkException varBC1D4459167B8D7C6C46A334BE610185_331592597 = new InvalidMarkException("Mark not set");
            varBC1D4459167B8D7C6C46A334BE610185_331592597.addTaint(taint);
            throw varBC1D4459167B8D7C6C46A334BE610185_331592597;
        } //End block
        position = mark;
Buffer var72A74007B2BE62B849F475C7BDA4658B_1703920142 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1703920142.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1703920142;
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.223 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "6FFC6D8ED95D38D0CD9DBEB6983B5B86")
    public final Buffer rewind() {
        position = 0;
        mark = UNSET_MARK;
Buffer var72A74007B2BE62B849F475C7BDA4658B_1677243002 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1677243002.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1677243002;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.223 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "BBEB1413A37309968CAC33EDF65B6B8B")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
String var4FC680801218E6372BC708D6FA44AE60_1998852061 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1998852061.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1998852061;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder();
        //buf.append(getClass().getName());
        //buf.append(", status: capacity=");
        //buf.append(capacity);
        //buf.append(" position=");
        //buf.append(position);
        //buf.append(" limit=");
        //buf.append(limit);
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.223 -0400", hash_original_field = "57E95BA22E5793F24DB37B9112030613", hash_generated_field = "4FD98D60CF309FB8A0BDD7D63A79939A")

    static final int UNSET_MARK = -1;
}

