package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Buffer {
    static final int UNSET_MARK = -1;
    final int capacity;
    int limit;
    int mark = UNSET_MARK;
    int position = 0;
    final int _elementSizeShift;
    int effectiveDirectAddress;
    final MemoryBlock block;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.465 -0400", hash_original_method = "2FDB6310072AD349AB73186351A07476", hash_generated_method = "E391AAF83B9F3FC0ED204643E6AF016D")
    @DSModeled(DSC.SAFE)
     Buffer(int elementSizeShift, int capacity, MemoryBlock block) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(block.dsTaint);
        dsTaint.addTaint(elementSizeShift);
        {
            throw new IllegalArgumentException("capacity < 0: " + capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.465 -0400", hash_original_method = "BDE11E8E3D76C140A59ECD57AE712B97", hash_generated_method = "82773967EE05FCB1991AEE782EFF592B")
    @DSModeled(DSC.SAFE)
    public final int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.465 -0400", hash_original_method = "3713E0ECC304C61FA995548AAE6F6858", hash_generated_method = "3FDBEF9DF4BA2AE3C01C5A29BE0D46B0")
    @DSModeled(DSC.SAFE)
     void checkIndex(int index) {
        dsTaint.addTaint(index);
        {
            throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index >= limit) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.465 -0400", hash_original_method = "E27C706F4FA27A5F90FA0BA455FA267B", hash_generated_method = "DA0C00E8C974C2A681CF6C5E9F4481F8")
    @DSModeled(DSC.SAFE)
     void checkIndex(int index, int sizeOfType) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(sizeOfType);
        {
            throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    ", size of type=" + sizeOfType);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index > limit - sizeOfType) {
            //throw new IndexOutOfBoundsException("index=" + index + ", limit=" + limit +
                    //", size of type=" + sizeOfType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.465 -0400", hash_original_method = "BA880ED8E3C58CA5885B3C340E7A6A66", hash_generated_method = "05F2ADB8F64C7267FAB2D7558EDF5ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int checkGetBounds(int bytesPerElement, int length, int offset, int count) {
        dsTaint.addTaint(bytesPerElement);
        dsTaint.addTaint(count);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_1981531211 = (byteCount > remaining());
            {
                throw new BufferUnderflowException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "A9251187BC2FC71988179BCFBD0F334A", hash_generated_method = "4177475F3A84504980A9E070DC7D6C7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int checkPutBounds(int bytesPerElement, int length, int offset, int count) {
        dsTaint.addTaint(bytesPerElement);
        dsTaint.addTaint(count);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        int byteCount;
        byteCount = bytesPerElement * count;
        {
            throw new IndexOutOfBoundsException("offset=" + offset +
                    ", count=" + count + ", length=" + length);
        } //End block
        {
            boolean varB9787195162C3B0FEC3FB85BC4A74CE2_465751335 = (byteCount > remaining());
            {
                throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_1007345744 = (isReadOnly());
            {
                throw new ReadOnlyBufferException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "37F8609F5279E5BC0D8BC318C47B5ADC", hash_generated_method = "F5CDF599BC9D5FEA00806309C2FDDE17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkStartEndRemaining(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean varE1A6830CB4AFEE77D5B9A4BD05B2AA83_1535737422 = (end < start || start < 0 || end > remaining());
            {
                throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    ", remaining()=" + remaining());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (end < start || start < 0 || end > remaining()) {
            //throw new IndexOutOfBoundsException("start=" + start + ", end=" + end +
                    //", remaining()=" + remaining());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "7210DA7B6C2A4BE4693F950CE68DF306", hash_generated_method = "B41FF19A7CD3F9B80D09C52DFA0C6D6E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "A8519E3C9C4A5F3DEEC9F7CACEDF020E", hash_generated_method = "49E7C91BA34FB6DBA33E7075A269C9F4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "13F7C083DDE22C46FB0AD1170426F423", hash_generated_method = "A5B0E2175E01924BF907FE3AB8023642")
    @DSModeled(DSC.SAFE)
    public final boolean hasRemaining() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return position < limit;
    }

    
    public abstract boolean isDirect();

    
    public abstract boolean isReadOnly();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "08F9CA73B929B3F2D88417804C3457BC", hash_generated_method = "EEBB6075EAFE6E3BA85A78B9CC1A5D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void checkWritable() {
        {
            boolean varAC4B8D6BC6438967D655421106AB549D_1048431978 = (isReadOnly());
            {
                throw new IllegalArgumentException("read-only buffer");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReadOnly()) {
            //throw new IllegalArgumentException("read-only buffer");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "D5C1223BE3A23A4695C92DD81173DEDC", hash_generated_method = "E493CEA9A33BDAE9C82A85F17A9F7628")
    @DSModeled(DSC.SAFE)
    public final int limit() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return limit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "44A9FE5FA1BE9CFEEC46842C8860150F", hash_generated_method = "F166543204F8C3976C469F66BA9983D8")
    @DSModeled(DSC.SAFE)
    public final Buffer limit(int newLimit) {
        dsTaint.addTaint(newLimit);
        limitImpl(newLimit);
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //limitImpl(newLimit);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "513739890B0FB1849008B6B4DB830FEC", hash_generated_method = "9B1D6401AA377E580859CD92C3D3E73D")
    @DSModeled(DSC.SAFE)
     void limitImpl(int newLimit) {
        dsTaint.addTaint(newLimit);
        {
            throw new IllegalArgumentException("Bad limit (capacity " + capacity + "): " + newLimit);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "A81425374E4EA5264849380D40913956", hash_generated_method = "48BCC97AE60CE545A428C42067688613")
    @DSModeled(DSC.SAFE)
    public final Buffer mark() {
        mark = position;
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mark = position;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "DAD201A4DC24D53E1106EBA819979825", hash_generated_method = "F4F529FE3DBEAA043F76E4773DC61729")
    @DSModeled(DSC.SAFE)
    public final int position() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "E134461CBBE71A88508EDF7172D7480E", hash_generated_method = "F640B3484871E3602BA53516BF9BF35A")
    @DSModeled(DSC.SAFE)
    public final Buffer position(int newPosition) {
        dsTaint.addTaint(newPosition);
        positionImpl(newPosition);
        return (Buffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //positionImpl(newPosition);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "291AA3CEE66D23BDF7C966DCE30CC485", hash_generated_method = "135F2DC2EEF766684CF3776DE81EB4BB")
    @DSModeled(DSC.SAFE)
     void positionImpl(int newPosition) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newPosition);
        {
            throw new IllegalArgumentException("Bad position (limit " + limit + "): " + newPosition);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.466 -0400", hash_original_method = "BFA4599854F3739E9A14ABA863ADA9FF", hash_generated_method = "1E29B539F191FF4AEEDD7859E63D2C0B")
    @DSModeled(DSC.SAFE)
    public final int remaining() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return limit - position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.467 -0400", hash_original_method = "2BE1864DF6C90B2A62411C9F7C095DEC", hash_generated_method = "A0006B427EA7946F8E203A363B5C7DB9")
    @DSModeled(DSC.SAFE)
    public final Buffer reset() {
        {
            throw new InvalidMarkException("Mark not set");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.467 -0400", hash_original_method = "533909B48B402AC142AA1672CC89D5CC", hash_generated_method = "0C960E9B8F5E7005E86B5BE1B3C2CC4B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.467 -0400", hash_original_method = "E469E128CB7197E7BD730454D1CDC172", hash_generated_method = "AB8A4509746955A761D0063C501EBB30")
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
        String var0C174602EFE4BFBCB80A7056CFA680FB_450079703 = (buf.toString());
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

    
}


