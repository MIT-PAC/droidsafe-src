package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Buffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "2016342B58ED3C0B49BEDE5E54A68A45", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "C96EE4AC8F4CC27B0B64279117650777", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

    int _elementSizeShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "74061CC9716705B5DAF7FFAEDC404616", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.784 -0400", hash_original_field = "14511F2F5564650D129CA7CABC333278", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.785 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "442BA2CCEB1767D661092BC7A5C56A48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.787 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "FFC5E8F1CB7AE6782661DA76AA3BA0D0")
    public final int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147274977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147274977;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.795 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "C5AFD8F7DCB7410760F2912B877C34A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.796 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "F45759FD603D0E8CA094E6D5E948B3F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.796 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "B6F53FBD71FF5124CF5A56ABBF2F4AEE")
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1555527692 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873468949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873468949;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.815 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "242EA15BD226FAE42F8DF14FEDEB4C17")
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1818726117 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_744113831 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215286800 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215286800;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.815 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "E5C5E7BC200BE16D990076D42146B643")
     void checkStartEndRemaining(int start, int end) {
        {
            boolean varE1A6830CB4AFEE77D5B9A4BD05B2AA83_946169178 = (end < start || start < 0 || end > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.816 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "6AB2C41CB3BECE5D8F6427499DFFE21A")
    public final Buffer clear() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_283567270 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
        varB4EAC82CA7396A68D541C85D26508E83_283567270 = this;
        varB4EAC82CA7396A68D541C85D26508E83_283567270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_283567270;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.821 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "B50417CFE518879C4E864E3FCE0A585A")
    public final Buffer flip() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_918199515 = null; //Variable for return #1
        limit = position;
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_918199515 = this;
        varB4EAC82CA7396A68D541C85D26508E83_918199515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918199515;
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    public abstract boolean hasArray();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.839 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "9E0FBA756DABE8423B684D4B5BCCC8CF")
    public final boolean hasRemaining() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297575349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297575349;
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.841 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "D49B65970B6B319AF0CD16E7FB3E77C8")
    final void checkWritable() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_679694656 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("read-only buffer");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.841 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "E0C533E58DFD986E0A3802F0AAFDC51A")
    public final int limit() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21511274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21511274;
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.849 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "D3F7C899886FAE197F584408CFC02BE7")
    public final Buffer limit(int newLimit) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_125800830 = null; //Variable for return #1
        limitImpl(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_125800830 = this;
        addTaint(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_125800830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_125800830;
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.851 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "F09C105136093183BC42464D6AC2BEB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.878 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "230DBA499AFA7B4F2CEBDA722094387D")
    public final Buffer mark() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1094765801 = null; //Variable for return #1
        mark = position;
        varB4EAC82CA7396A68D541C85D26508E83_1094765801 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1094765801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1094765801;
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.878 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "08AEEC9377B324EB74879F12FF6A22B7")
    public final int position() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593469704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593469704;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.879 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "574F7F41A86D1E067630EA251E2A70AE")
    public final Buffer position(int newPosition) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1669796458 = null; //Variable for return #1
        positionImpl(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_1669796458 = this;
        addTaint(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_1669796458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1669796458;
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.879 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "982A4E84573831FBC048FE55FA4935DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.879 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "B0E81E34E4FE1DF154C4A6B3600D1B63")
    public final int remaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168750490 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168750490;
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.880 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "B1CEFB7D05E2466C854D1C9EF17391CD")
    public final Buffer reset() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1755450370 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidMarkException("Mark not set");
        } //End block
        position = mark;
        varB4EAC82CA7396A68D541C85D26508E83_1755450370 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1755450370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1755450370;
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.880 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "97AEDC44F02CFE46EF4201ADCAF458B0")
    public final Buffer rewind() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1821095262 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1821095262 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1821095262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821095262;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.881 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "073BA39490D9F45EF82EDEB9F240AECE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2047068277 = null; //Variable for return #1
        StringBuilder buf;
        buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
        varB4EAC82CA7396A68D541C85D26508E83_2047068277 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2047068277.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047068277;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:43.881 -0400", hash_original_field = "57E95BA22E5793F24DB37B9112030613", hash_generated_field = "90D88E72C76AA0D65C966EAE061DEDE7")

    static int UNSET_MARK = -1;
}

