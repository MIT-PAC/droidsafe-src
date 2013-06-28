package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Buffer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "0B1D26332B4020647655E70C20DE6D8D")

    int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "136FDC88CA742E83C109AD31983DA2BF")

    int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "2016342B58ED3C0B49BEDE5E54A68A45", hash_generated_field = "F4125C160956CCDB3F5B836CF165E567")

    int mark = UNSET_MARK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "B0CD1B3F8E4067A68C294939F6EB1E36")

    int position = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "C96EE4AC8F4CC27B0B64279117650777", hash_generated_field = "AC48A19F4743BE2D100608593BADD722")

    int _elementSizeShift;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "74061CC9716705B5DAF7FFAEDC404616", hash_generated_field = "8BF4E4D6767B9222837C08D79533D1FA")

    int effectiveDirectAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.740 -0400", hash_original_field = "14511F2F5564650D129CA7CABC333278", hash_generated_field = "2536D72C0292B1D797C3E93689D5E5F8")

    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.741 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "442BA2CCEB1767D661092BC7A5C56A48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.741 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "E7E526D6772136DA186224D7E4F4C7B1")
    public final int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988123086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988123086;
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.741 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "C5AFD8F7DCB7410760F2912B877C34A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.741 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "F45759FD603D0E8CA094E6D5E948B3F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.742 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "52ABEAA6213599B269CB5AC66F6816A9")
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_271378801 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445225851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445225851;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.742 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "D281536605858BC3DDBAF34CB81D5431")
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        int byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1445311956 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_2112257086 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        addTaint(bytesPerElement);
        addTaint(length);
        addTaint(offset);
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435576905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435576905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.743 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "EDFDF27B958F0776298D733B380032C9")
     void checkStartEndRemaining(int start, int end) {
        {
            boolean varE1A6830CB4AFEE77D5B9A4BD05B2AA83_1193090971 = (end < start || start < 0 || end > remaining());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.744 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "6AA179E10071F1FF0DD5E2BB81780105")
    public final Buffer clear() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1161064082 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
        varB4EAC82CA7396A68D541C85D26508E83_1161064082 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1161064082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1161064082;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.746 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "76ACE281BEA7A546D79D45732E3145F3")
    public final Buffer flip() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_563792291 = null; //Variable for return #1
        limit = position;
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_563792291 = this;
        varB4EAC82CA7396A68D541C85D26508E83_563792291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_563792291;
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    public abstract boolean hasArray();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.746 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "C55F466CBF582FC7F81E972B03660F44")
    public final boolean hasRemaining() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265875138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_265875138;
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.747 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "257ED5E9689D14F45BDFA5B751D3D821")
    final void checkWritable() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_757167095 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("read-only buffer");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.747 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "888C2B2D3A6DA4BD03D98CFD37F64AE3")
    public final int limit() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828569973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828569973;
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.747 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "D00CBE0EE40351020C0149D1D8FDEA6F")
    public final Buffer limit(int newLimit) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_2057528807 = null; //Variable for return #1
        limitImpl(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_2057528807 = this;
        addTaint(newLimit);
        varB4EAC82CA7396A68D541C85D26508E83_2057528807.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2057528807;
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.747 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "F09C105136093183BC42464D6AC2BEB3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.748 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "75C5398D4DFFBC3E50DB860E8A80B9E5")
    public final Buffer mark() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_439844908 = null; //Variable for return #1
        mark = position;
        varB4EAC82CA7396A68D541C85D26508E83_439844908 = this;
        varB4EAC82CA7396A68D541C85D26508E83_439844908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_439844908;
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.748 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "CA63D717381090AA0BCE4C4D33FAD14C")
    public final int position() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540570492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540570492;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.749 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "A46F35A20D36D426F422938ADDC4F964")
    public final Buffer position(int newPosition) {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_332031707 = null; //Variable for return #1
        positionImpl(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_332031707 = this;
        addTaint(newPosition);
        varB4EAC82CA7396A68D541C85D26508E83_332031707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332031707;
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.749 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "982A4E84573831FBC048FE55FA4935DA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.749 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "6B7CE230D5F85FE39F1F8232DA7CF035")
    public final int remaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062060903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062060903;
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.749 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "4C90B6B9C099D8B6B4C824CFAA3A5683")
    public final Buffer reset() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_917875233 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidMarkException("Mark not set");
        } //End block
        position = mark;
        varB4EAC82CA7396A68D541C85D26508E83_917875233 = this;
        varB4EAC82CA7396A68D541C85D26508E83_917875233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_917875233;
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.750 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "69711DF4201F1650B59F8A45DE8412CF")
    public final Buffer rewind() {
        Buffer varB4EAC82CA7396A68D541C85D26508E83_1938827014 = null; //Variable for return #1
        position = 0;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1938827014 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1938827014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938827014;
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.750 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "326E2FBB69CCE09DCE70A373DCAA62E1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1394558559 = null; //Variable for return #1
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
        varB4EAC82CA7396A68D541C85D26508E83_1394558559 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1394558559.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1394558559;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.750 -0400", hash_original_field = "57E95BA22E5793F24DB37B9112030613", hash_generated_field = "4FD98D60CF309FB8A0BDD7D63A79939A")

    static final int UNSET_MARK = -1;
}

