package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Buffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.905 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "2016342B58ED3C0B49BEDE5E54A68A45", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "C96EE4AC8F4CC27B0B64279117650777", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

    int _elementSizeShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "74061CC9716705B5DAF7FFAEDC404616", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.906 -0400", hash_original_field = "14511F2F5564650D129CA7CABC333278", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.907 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "3F8B53B48DB0B6C64E91696C0546528F")
      Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        this._elementSizeShift = elementSizeShift;
    if(capacity < 0)        
        {
            IllegalArgumentException varA12B62205B960623EBBA8A01150F526D_2098226338 = new IllegalArgumentException("capacity < 0: " + capacity);
            varA12B62205B960623EBBA8A01150F526D_2098226338.addTaint(taint);
            throw varA12B62205B960623EBBA8A01150F526D_2098226338;
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

    
    public abstract Object array();

    
    public abstract int arrayOffset();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.908 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "BF3144C1677CDB153CCDD57C2B726B0E")
    public final int capacity() {
        int var7BD14A231864E618E1840C7E117E59C1_1771715487 = (capacity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198596944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198596944;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.908 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "27184481590EE77CFDA8E01F0F0114F4")
     void checkIndex(int index) {
        addTaint(index);
    if(index < 0 || index >= limit)        
        {
            IndexOutOfBoundsException var2AE91013EDA9724F76B2720BFFF37786_5798349 = new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
            var2AE91013EDA9724F76B2720BFFF37786_5798349.addTaint(taint);
            throw var2AE91013EDA9724F76B2720BFFF37786_5798349;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index >= limit) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.909 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "C96D0819366AEFD532676220D66EC4A6")
     void checkIndex(int index, int sizeOfType) {
        addTaint(sizeOfType);
        addTaint(index);
    if(index < 0 || index > limit - sizeOfType)        
        {
            IndexOutOfBoundsException var485B03E5FC6C5A45B069E745C3202EE8_1040959439 = new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
            var485B03E5FC6C5A45B069E745C3202EE8_1040959439.addTaint(taint);
            throw var485B03E5FC6C5A45B069E745C3202EE8_1040959439;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index > limit - sizeOfType) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    //", size of type=" + sizeOfType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.910 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "DAFA0E19E47E74F10ADC36F7175073B4")
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(length);
        addTaint(bytesPerElement);
        int byteCount = bytesPerElement * count;
    if((offset | count) < 0 || offset > length || length - offset < count)        
        {
            IndexOutOfBoundsException var237C2E3911559A7B9C5446946C75A3B3_1220663142 = new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
            var237C2E3911559A7B9C5446946C75A3B3_1220663142.addTaint(taint);
            throw var237C2E3911559A7B9C5446946C75A3B3_1220663142;
        } //End block
    if(byteCount > remaining())        
        {
            BufferUnderflowException var77B0EAE3DCF68E57AAEF834AFBC7D762_248498997 = new BufferUnderflowException();
            var77B0EAE3DCF68E57AAEF834AFBC7D762_248498997.addTaint(taint);
            throw var77B0EAE3DCF68E57AAEF834AFBC7D762_248498997;
        } //End block
        int varA43EF6D60A83013EA1A61A23BDB16029_1912024274 = (byteCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200604337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200604337;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.910 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "B11A120B89E487961CADD3FF0798AB14")
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        addTaint(count);
        addTaint(offset);
        addTaint(length);
        addTaint(bytesPerElement);
        int byteCount = bytesPerElement * count;
    if((offset | count) < 0 || offset > length || length - offset < count)        
        {
            IndexOutOfBoundsException var237C2E3911559A7B9C5446946C75A3B3_1253439009 = new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
            var237C2E3911559A7B9C5446946C75A3B3_1253439009.addTaint(taint);
            throw var237C2E3911559A7B9C5446946C75A3B3_1253439009;
        } //End block
    if(byteCount > remaining())        
        {
            BufferOverflowException var773478A23217201B18B531915D367F31_1956322073 = new BufferOverflowException();
            var773478A23217201B18B531915D367F31_1956322073.addTaint(taint);
            throw var773478A23217201B18B531915D367F31_1956322073;
        } //End block
    if(isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_1082859061 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_1082859061.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_1082859061;
        } //End block
        int varA43EF6D60A83013EA1A61A23BDB16029_905379740 = (byteCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234238251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1234238251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.911 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "1691C4166EEB896F8D603005A38033DA")
     void checkStartEndRemaining(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(end < start || start < 0 || end > remaining())        
        {
            IndexOutOfBoundsException var2952B7EF9E478CBDEDD85E1CD117B0D4_1268299281 = new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
            var2952B7EF9E478CBDEDD85E1CD117B0D4_1268299281.addTaint(taint);
            throw var2952B7EF9E478CBDEDD85E1CD117B0D4_1268299281;
        } //End block
        // ---------- Original Method ----------
        //if (end < start || start < 0 || end > remaining()) {
            //throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    //", remaining()=" + remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.912 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "78B0CF5A61FD02BE9A6FE601CACC33EC")
    public final Buffer clear() {
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
Buffer var72A74007B2BE62B849F475C7BDA4658B_1747391336 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1747391336.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1747391336;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.912 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "A417C8A9F7B6329A0EE3B5E9715B4CE7")
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = UNSET_MARK;
Buffer var72A74007B2BE62B849F475C7BDA4658B_1845156139 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1845156139.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1845156139;
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    public abstract boolean hasArray();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.913 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "BE456EE774861AD8EAAAB1AE595F88F0")
    public final boolean hasRemaining() {
        boolean varA311A48D68DFAB1F8655269A7132150E_1826682193 = (position < limit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1096295708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1096295708;
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.913 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "A3349E07337410593DDF626A4390E971")
    final void checkWritable() {
    if(isReadOnly())        
        {
            IllegalArgumentException var7D6FDD050D09806E382B195E32E4AE58_1431355408 = new IllegalArgumentException("read-only buffer");
            var7D6FDD050D09806E382B195E32E4AE58_1431355408.addTaint(taint);
            throw var7D6FDD050D09806E382B195E32E4AE58_1431355408;
        } //End block
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.914 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "7828B59E841A555149C82DEE38F2FCCD")
    public final int limit() {
        int varAA9F73EEA60A006820D0F8768BC8A3FC_856865572 = (limit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722065922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722065922;
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.914 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "89542CB11A9EDA7576A5D10E245FD76E")
    public final Buffer limit(int newLimit) {
        addTaint(newLimit);
        limitImpl(newLimit);
Buffer var72A74007B2BE62B849F475C7BDA4658B_1744665609 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1744665609.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1744665609;
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.915 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "624F9D6A51257FE8ED44C1358F939DFD")
     void limitImpl(int newLimit) {
    if(newLimit < 0 || newLimit > capacity)        
        {
            IllegalArgumentException varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1368696376 = new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
            varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1368696376.addTaint(taint);
            throw varD3FA4DEA64B9805FF2C288BBDE7E9B4C_1368696376;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.916 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "C97B505145CED376F4AC29A0D3B2E0D0")
    public final Buffer mark() {
        mark = position;
Buffer var72A74007B2BE62B849F475C7BDA4658B_650346877 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_650346877.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_650346877;
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.916 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "3427BC54912C64D20A0F587E70FD7587")
    public final int position() {
        int var4757FE07FD492A8BE0EA6A760D683D6E_1773080333 = (position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830604415 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830604415;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.917 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "F05DA0221D5F5F770ADA1E83117BBFD7")
    public final Buffer position(int newPosition) {
        addTaint(newPosition);
        positionImpl(newPosition);
Buffer var72A74007B2BE62B849F475C7BDA4658B_149826459 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_149826459.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_149826459;
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.918 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "D43158302179FB9AAA124DB49AE5DE97")
     void positionImpl(int newPosition) {
    if(newPosition < 0 || newPosition > limit)        
        {
            IllegalArgumentException var6A7339BB80AF6B4E498E98C57B9CBD80_569412501 = new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
            var6A7339BB80AF6B4E498E98C57B9CBD80_569412501.addTaint(taint);
            throw var6A7339BB80AF6B4E498E98C57B9CBD80_569412501;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.918 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "E65A600325E104B5A94E3D3782760144")
    public final int remaining() {
        int var09EF638EAE66D4F89E996C4321DBBCF9_823197784 = (limit - position);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327812903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327812903;
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.919 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "FC8D096E1405886FB8A1EB10F76B2B72")
    public final Buffer reset() {
    if(mark == UNSET_MARK)        
        {
            InvalidMarkException varBC1D4459167B8D7C6C46A334BE610185_806315328 = new InvalidMarkException("Mark not set");
            varBC1D4459167B8D7C6C46A334BE610185_806315328.addTaint(taint);
            throw varBC1D4459167B8D7C6C46A334BE610185_806315328;
        } //End block
        position = mark;
Buffer var72A74007B2BE62B849F475C7BDA4658B_594263460 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_594263460.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_594263460;
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.919 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "4DEE2B778F50F489568E45036F7CEA1E")
    public final Buffer rewind() {
        position = 0;
        mark = UNSET_MARK;
Buffer var72A74007B2BE62B849F475C7BDA4658B_763283914 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_763283914.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_763283914;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.920 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "980C63FDD7E09380B0E467022332EE23")
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
String var4FC680801218E6372BC708D6FA44AE60_1885059017 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1885059017.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1885059017;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.920 -0400", hash_original_field = "57E95BA22E5793F24DB37B9112030613", hash_generated_field = "4FD98D60CF309FB8A0BDD7D63A79939A")

    static final int UNSET_MARK = -1;
}

