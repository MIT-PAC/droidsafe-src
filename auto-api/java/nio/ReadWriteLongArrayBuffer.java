package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.162 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "0BF1E72F9CDE48CDFF9B1041B1117CC0")
      ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.163 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "12326B1AE0736FDED662AAC5D35BA336")
      ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.163 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "320D622C16E158AC75A4CDE278E017C9")
      ReadWriteLongArrayBuffer(int capacity, long[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
        addTaint(capacity);
        addTaint(backingArray[0]);
        addTaint(arrayOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.175 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "F715277A752B1247A1AAACB869B8FE54")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_377224943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_377224943 = ReadOnlyLongArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_377224943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377224943;
        // ---------- Original Method ----------
        //return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.176 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "E33894F3CCF1998485F3744FFDA1B417")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_843672320 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_843672320 = this;
        varB4EAC82CA7396A68D541C85D26508E83_843672320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843672320;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.176 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "C43D38994A6F1F796CE033492F6D060E")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_2019998680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2019998680 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_2019998680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2019998680;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.176 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "0E1074CABBDB380C8D04750661BA8DA6")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010572740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010572740;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.177 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "33655C2F76FFA9890D934CC34E2F2E2F")
    @Override
    protected long[] protectedArray() {
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_1351395309 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_1351395309;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.177 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "FC840AB870CA4E39CD6612C35E04B417")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702133592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702133592;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.178 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "115BD616ACF24790B34A9F8E52DF2972")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115960054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115960054;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.178 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "84FF2262D04409162640332CC1750918")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_257377210 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_257377210 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_257377210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_257377210;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.179 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "56769C98C26321260517526DCD7C83CA")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1117188284 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1117188284 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1117188284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117188284;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.180 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "C8B16F17DB921693EA6F715F52EEF24E")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1602923305 = null; //Variable for return #1
        {
            boolean var689C4001D724360528D46748438966DA_2139887012 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1602923305 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1602923305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1602923305;
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.199 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "EE503F97DE41258167638E7D7B4606CC")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1423665183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1423665183 = new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1423665183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423665183;
        // ---------- Original Method ----------
        //return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

