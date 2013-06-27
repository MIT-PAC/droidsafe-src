package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Buffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.770 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.773 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.774 -0400", hash_original_field = "2016342B58ED3C0B49BEDE5E54A68A45", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.774 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.774 -0400", hash_original_field = "C96EE4AC8F4CC27B0B64279117650777", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

    int _elementSizeShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.776 -0400", hash_original_field = "74061CC9716705B5DAF7FFAEDC404616", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.778 -0400", hash_original_field = "14511F2F5564650D129CA7CABC333278", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.778 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "442BA2CCEB1767D661092BC7A5C56A48")
      Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        this._elementSizeShift = elementSizeShift;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("capacity < 0: " + capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.782 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "68A7C7B504A92736A66F0CED4FA165D4")
    public final int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065191362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065191362;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.791 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "C5AFD8F7DCB7410760F2912B877C34A4")
     void checkIndex(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //if (index < 0 || index >= limit) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.791 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "F45759FD603D0E8CA094E6D5E948B3F0")
     void checkIndex(int index, int sizeOfType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
        } //End block
        addTaint(index);
        addTaint(sizeOfType);
        // ---------- Original Method ----------
        //if (index < 0 || index > limit - sizeOfType) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    //", size of type=" + sizeOfType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.798 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "7D3BB6DA37F35AB274297643B53AA848")
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1227231520 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545171549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545171549;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.803 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "3EDD1AB06C81302A134F77125BEB127A")
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1850477532 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_629213155 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24715589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24715589;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.804 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "6C9D165A63B4BAB2F5515C6FC298FD48")
     void checkStartEndRemaining(int start, int end) {
        {
            boolean varE1A6830CB4AFEE77D5B9A4BD05B2AA83_402752463 = (end < start || start < 0 || end > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (end < start || start < 0 || end > remaining()) {
            //throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    //", remaining()=" + remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.805 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "70D41D5C38CEB6B01D8BBA9D96C92DDE")
    public final Buffer clear() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_2094390073 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
        varB4EAC82CA7396A68D541C85D26508E83_2094390073 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2094390073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2094390073;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.826 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "1A9BAEB4245B883A8B6A5C6200CFA686")
    public final Buffer flip() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_349281703 = null; //Variable for return #1
        limit = position;
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_349281703 = this;
        varB4EAC82CA7396A68D541C85D26508E83_349281703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_349281703;
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    public abstract boolean hasArray();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.826 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "8BDC0E10501C51AE6FAA261ABD894554")
    public final boolean hasRemaining() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63640151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63640151;
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.827 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "4FA8E78AEC5C443C70683EC7B5B7519D")
    final void checkWritable() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_533780139 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("read-only buffer");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.827 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "10C3835F54BD2C6058D38DA42479FFDB")
    public final int limit() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596826379 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_596826379;
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.828 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "AA6E39FC99D5E07044E165CB489BC6EF")
    public final Buffer limit(int newLimit) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1978355735 = null; //Variable for return #1
        limitImpl(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_1978355735 = this;
        addTaint(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_1978355735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978355735;
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.831 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "F09C105136093183BC42464D6AC2BEB3")
     void limitImpl(int newLimit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
        } //End block
        limit = newLimit;
        {
            position = newLimit;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.842 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "825C08F8BF0B6AD7F5E3C35FFC7C46FE")
    public final Buffer mark() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1978027314 = null; //Variable for return #1
        mark = position;
        varB4EAC82CA7396A68D541C85D26508E83_1978027314 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1978027314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1978027314;
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.843 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "DBE9FF492924F3C60289121D6CA51EE0")
    public final int position() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625141111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625141111;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.844 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "2C71D8042AE22E882B6DCE8B0E71BB0E")
    public final Buffer position(int newPosition) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1746579883 = null; //Variable for return #1
        positionImpl(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_1746579883 = this;
        addTaint(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_1746579883.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1746579883;
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.844 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "982A4E84573831FBC048FE55FA4935DA")
     void positionImpl(int newPosition) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
        } //End block
        position = newPosition;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.845 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "5F40DFE08E2A0ECD8C9AD5FBB658BDE0")
    public final int remaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414343832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414343832;
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.867 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "64F027C0FE020B0303A96B98F957365C")
    public final Buffer reset() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_2135495865 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidMarkException("Mark not set");
        } //End block
        position = mark;
        varB4EAC82CA7396A68D541C85D26508E83_2135495865 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2135495865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2135495865;
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.868 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "E441A21EFEED695E59B7F9DB0474DEC1")
    public final Buffer rewind() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1646729690 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1646729690 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1646729690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1646729690;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.884 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "3C191682B749827C1103DA2F550AE36D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_82766306 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
        varB4EAC82CA7396A68D541C85D26508E83_82766306 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_82766306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_82766306;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.884 -0400", hash_original_field = "57E95BA22E5793F24DB37B9112030613", hash_generated_field = "90D88E72C76AA0D65C966EAE061DEDE7")

    static int UNSET_MARK = -1;
}

