package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.957 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "C27D238208D4D637D32849EAB5BCA7A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        dsTaint.addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.957 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "E2334C6251E0F621C32DF977BDCE9CC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.957 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "9BB9D353D03294AD8FF6C117868DA469")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReadWriteLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        dsTaint.addTaint(backingArray[0]);
        dsTaint.addTaint(arrayOffset);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        static ReadWriteLongArrayBuffer copy(LongArrayBuffer other, int markOfOther) {
        ReadWriteLongArrayBuffer buf =
                new ReadWriteLongArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "EC754C03B00DE943F4A43168B49591E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer var32BDD3F25BA798F99FD5F99CF1998845_1277966907 = (ReadOnlyLongArrayBuffer.copy(this, mark));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "794EBF55CBE1A8780E0A832A88D02AB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "D1DE59A4D931FFCE8537D44308DB2772")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer duplicate() {
        LongBuffer var8C82ED9E4FDE12C9486E1252174918B6_77861187 = (copy(this, mark));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "1F2BF0EB1F192C8C411CC0427A2B9F5B")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "FB3A0845AFF85DE72909E3A568468446")
    @DSModeled(DSC.SAFE)
    @Override
    protected long[] protectedArray() {
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.958 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "B6AF1441163DC81E5A7523DBEAED19DC")
    @DSModeled(DSC.SAFE)
    @Override
    protected int protectedArrayOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.959 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F14C0EBC785314AEABBE7CBCFAB3FB1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean protectedHasArray() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.959 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "C98FE9246C5CB2D9FA2CAEB18C131858")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(long c) {
        dsTaint.addTaint(c);
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.959 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "BA669BCA7E63439A907F96767E9C7520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(int index, long c) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(c);
        checkIndex(index);
        backingArray[offset + index] = c;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.959 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "EF97F48F0C3DC5ECD9DFB1D6974485F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        dsTaint.addTaint(longCount);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(src[0]);
        {
            boolean var689C4001D724360528D46748438966DA_902250948 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.959 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "5E1339351FBBCE2401B40B3EA508AF76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public LongBuffer slice() {
        LongBuffer var9C48EDEE95450473CF8559F4A621DF02_1632834481 = (new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position));
        return (LongBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

