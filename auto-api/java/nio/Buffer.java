package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Buffer {
    int capacity;
    int limit;
    int mark = UNSET_MARK;
    int position = 0;
    int _elementSizeShift;
    int effectiveDirectAddress;
    MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.460 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "040BC15D3D7883134A5BFDCC17AFA81E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(elementSizeShift);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("capacity < 0: " + capacity);
        } //End block
        this.capacity = this.limit = capacity;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.460 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "6430ACE1430AB9BF6CF2288048933EBB")
    @DSModeled(DSC.SAFE)
    public final int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.460 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "52A50EDD8A93B4C2C140D7F87731C97E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkIndex(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index >= limit) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.460 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "D5856BBE543C3F460323531AD0F8797E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkIndex(int index, int sizeOfType) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(sizeOfType);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index > limit - sizeOfType) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    //", size of type=" + sizeOfType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.461 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "0C14F4F4E1A4369B9F9F921492ED972E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(bytesPerElement);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_800709912 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferUnderflowException();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.461 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "BFD7570C4686072E56DC066FAFFD4E64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        dsTaint.addTaint(count);
        dsTaint.addTaint(bytesPerElement);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1047914720 = (byteCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_286767179 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.461 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "39CAA16F9C15FC7C45915A9D0059970C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkStartEndRemaining(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean varE1A6830CB4AFEE77D5B9A4BD05B2AA83_828457530 = (end < start || start < 0 || end > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (end < start || start < 0 || end > remaining()) {
            //throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    //", remaining()=" + remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.462 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "6B7E288F63FFD22775A69891468EAADE")
    @DSModeled(DSC.SAFE)
    public final Buffer clear() {
        position = 0;
        mark = UNSET_MARK;
        limit = capacity;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //limit = capacity;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.463 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "0E4B453C945E4DF60B540D8A405E5341")
    @DSModeled(DSC.SAFE)
    public final Buffer flip() {
        limit = position;
        position = 0;
        mark = UNSET_MARK;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //limit = position;
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    public abstract boolean hasArray();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.463 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "6E47EE9979240433A915412EB4DE24D1")
    @DSModeled(DSC.SAFE)
    public final boolean hasRemaining() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.464 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "400D4A5239B57C144609B2CDA2BD86EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void checkWritable() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_98657394 = (isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("read-only buffer");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.464 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "3163E2E04C8C39D864A93BAF913AF9A8")
    @DSModeled(DSC.SAFE)
    public final int limit() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.464 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "1CD3AE87186E8031785B4DC230DBD1D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Buffer limit(int newLimit) {
        dsTaint.addTaint(newLimit);
        limitImpl(newLimit);
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.465 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "5DFEBDB8CAE5687A489BC015068727E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void limitImpl(int newLimit) {
        dsTaint.addTaint(newLimit);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.465 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "E2A47DCD22FFF012C6F1BC3D4104C393")
    @DSModeled(DSC.SAFE)
    public final Buffer mark() {
        mark = position;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.465 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "903CD85BE6330DEE691F840ACC1AEF3E")
    @DSModeled(DSC.SAFE)
    public final int position() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.465 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "A20A2C5E9B8E1413B9DC778C4554476A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Buffer position(int newPosition) {
        dsTaint.addTaint(newPosition);
        positionImpl(newPosition);
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.466 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "AFA177C6BE712341D4FA18A9DB5FBA19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void positionImpl(int newPosition) {
        dsTaint.addTaint(newPosition);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.466 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "C9DD8A18C26A3EF0057698ED454F5BCF")
    @DSModeled(DSC.SAFE)
    public final int remaining() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.466 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "CA91CA1C07C3F7C835F56E37251F5F6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Buffer reset() {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidMarkException("Mark not set");
        } //End block
        position = mark;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mark == UNSET_MARK) {
            //throw new InvalidMarkException("Mark not set");
        //}
        //position = mark;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.466 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "935B957A3173C3197ACB469C6D4D3FEF")
    @DSModeled(DSC.SAFE)
    public final Buffer rewind() {
        position = 0;
        mark = UNSET_MARK;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //position = 0;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.466 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "66C7A26CB1D27AFBC1970AE9843BE122")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buf;
        buf = new StringBuilder();
        buf.append(getClass().getName());
        buf.append(", status: capacity=");
        buf.append(capacity);
        buf.append(" position=");
        buf.append(position);
        buf.append(" limit=");
        buf.append(limit);
        String var0C174602EFE4BFBCB80A7056CFA680FB_391929303 = (buf.toString());
        return dsTaint.getTaintString();
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

    
    static final int UNSET_MARK = -1;
}

