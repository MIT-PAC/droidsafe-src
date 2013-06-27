package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class ReadWriteLongArrayBuffer extends LongArrayBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.093 -0400", hash_original_method = "834F92961971218638A9D7B65E865A6A", hash_generated_method = "0BF1E72F9CDE48CDFF9B1041B1117CC0")
      ReadWriteLongArrayBuffer(long[] array) {
        super(array);
        addTaint(array[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.093 -0400", hash_original_method = "B372464DEEDD255C23B3D6D2F6AC357B", hash_generated_method = "12326B1AE0736FDED662AAC5D35BA336")
      ReadWriteLongArrayBuffer(int capacity) {
        super(capacity);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.093 -0400", hash_original_method = "D4CFA6531161D5EBB7847D86519768A8", hash_generated_method = "320D622C16E158AC75A4CDE278E017C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.094 -0400", hash_original_method = "491DB95BA7040FC98389856362623E65", hash_generated_method = "986B88C89D1DFE4A5AC0B1BB6EAF892D")
    @Override
    public LongBuffer asReadOnlyBuffer() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_764530336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_764530336 = ReadOnlyLongArrayBuffer.copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_764530336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_764530336;
        // ---------- Original Method ----------
        //return ReadOnlyLongArrayBuffer.copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.094 -0400", hash_original_method = "060222CDD5267DE677B9C3E035FABA38", hash_generated_method = "90F134706B8B6F4DB9ACF367997EF879")
    @Override
    public LongBuffer compact() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1212272046 = null; //Variable for return #1
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        varB4EAC82CA7396A68D541C85D26508E83_1212272046 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1212272046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212272046;
        // ---------- Original Method ----------
        //System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        //position = limit - position;
        //limit = capacity;
        //mark = UNSET_MARK;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.095 -0400", hash_original_method = "BCAEF14AE65D2F213653B4CB45E8B265", hash_generated_method = "6F6E8C0BC813C66D12E0BF93101AFABB")
    @Override
    public LongBuffer duplicate() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_44435507 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44435507 = copy(this, mark);
        varB4EAC82CA7396A68D541C85D26508E83_44435507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44435507;
        // ---------- Original Method ----------
        //return copy(this, mark);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.097 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "47B7D4B35E3136D1248AD8475C1DEEAE")
    @Override
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725359691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725359691;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.098 -0400", hash_original_method = "7F3F8A80822D5A0A92B191B6CC171534", hash_generated_method = "9FF686DD5D2428D01CC9C46684470703")
    @Override
    protected long[] protectedArray() {
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_197209680 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_197209680;
        // ---------- Original Method ----------
        //return backingArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.098 -0400", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "EFA1DCC9E05D9C6F860CC97D14FD8F17")
    @Override
    protected int protectedArrayOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538807996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538807996;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.098 -0400", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "F68B51DCCCEEF61940D63FFD3E2F36C3")
    @Override
    protected boolean protectedHasArray() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309392130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309392130;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.099 -0400", hash_original_method = "425DFBE2ED449316EC67E343889A606E", hash_generated_method = "B3A4D41CEC09C3F4CC1ABA29C9AA4010")
    @Override
    public LongBuffer put(long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1678408319 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
        } //End block
        backingArray[offset + position++] = c;
        varB4EAC82CA7396A68D541C85D26508E83_1678408319 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_1678408319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678408319;
        // ---------- Original Method ----------
        //if (position == limit) {
            //throw new BufferOverflowException();
        //}
        //backingArray[offset + position++] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.099 -0400", hash_original_method = "1D23D6036C356E1E5C3421A08A3084B8", hash_generated_method = "471F1C6B8AD735504A46A45632B19CFF")
    @Override
    public LongBuffer put(int index, long c) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_889289334 = null; //Variable for return #1
        checkIndex(index);
        backingArray[offset + index] = c;
        varB4EAC82CA7396A68D541C85D26508E83_889289334 = this;
        addTaint(index);
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_889289334.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889289334;
        // ---------- Original Method ----------
        //checkIndex(index);
        //backingArray[offset + index] = c;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.113 -0400", hash_original_method = "DEBADA2447C09B43BF32BF5E36B4652E", hash_generated_method = "D99ADE6066F0512264773DC34BF64F69")
    @Override
    public LongBuffer put(long[] src, int srcOffset, int longCount) {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1022638375 = null; //Variable for return #1
        {
            boolean var689C4001D724360528D46748438966DA_1671791657 = (longCount > remaining());
            {
                if (DroidSafeAndroidRuntime.control) throw new BufferOverflowException();
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        position += longCount;
        varB4EAC82CA7396A68D541C85D26508E83_1022638375 = this;
        addTaint(src[0]);
        addTaint(srcOffset);
        addTaint(longCount);
        varB4EAC82CA7396A68D541C85D26508E83_1022638375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1022638375;
        // ---------- Original Method ----------
        //if (longCount > remaining()) {
            //throw new BufferOverflowException();
        //}
        //System.arraycopy(src, srcOffset, backingArray, offset + position, longCount);
        //position += longCount;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.131 -0400", hash_original_method = "66DF3FBD18C3DE0FC10F7184B9F43E0E", hash_generated_method = "C0E04EC05CCECB89EC3FD4A143C8A4E5")
    @Override
    public LongBuffer slice() {
        LongBuffer varB4EAC82CA7396A68D541C85D26508E83_1890874271 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1890874271 = new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
        varB4EAC82CA7396A68D541C85D26508E83_1890874271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890874271;
        // ---------- Original Method ----------
        //return new ReadWriteLongArrayBuffer(remaining(), backingArray, offset + position);
    }

    
}

