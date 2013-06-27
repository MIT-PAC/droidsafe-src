package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import libcore.io.SizeOf;

public class BitSet implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.845 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.845 -0400", hash_original_field = "B7881959E051E122A93F0F4BB9A45AB8", hash_generated_field = "DC80EF19CD932E16185FEB519D23D494")

    private transient int longCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.857 -0400", hash_original_method = "36F48153593A7027DE7089606CF225FB", hash_generated_method = "613602062985992FB8430672E70C7481")
    public  BitSet() {
        this(new long[1]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.858 -0400", hash_original_method = "12ED281EDA73627C34F706B1E8393C0F", hash_generated_method = "C7CD726103BF2541C7B3FDDBCF45C69E")
    public  BitSet(int bitCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NegativeArraySizeException();
        } //End block
        this.bits = arrayForBits(bitCount);
        this.longCount = 0;
        // ---------- Original Method ----------
        //if (bitCount < 0) {
            //throw new NegativeArraySizeException();
        //}
        //this.bits = arrayForBits(bitCount);
        //this.longCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.859 -0400", hash_original_method = "F5397E49D432953D65E6CB2ED1150384", hash_generated_method = "1C0E37C5115CD13FD56B4BE776F6A166")
    private  BitSet(long[] bits) {
        this.bits = bits;
        this.longCount = bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //this.bits = bits;
        //this.longCount = bits.length;
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.859 -0400", hash_original_method = "2E0FE194508C45AD5184DCF0A152D7A0", hash_generated_method = "9F473D6240FACDC65C66DAAD4186DF40")
    private void shrinkSize() {
        int i;
        i = longCount - 1;
        this.longCount = i + 1;
        // ---------- Original Method ----------
        //int i = longCount - 1;
        //while (i >= 0 && bits[i] == 0) {
            //--i;
        //}
        //this.longCount = i + 1;
    }

    
        private static long[] arrayForBits(int bitCount) {
        return new long[(bitCount + 63)/ 64];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.864 -0400", hash_original_method = "C5612661FC3C49DB4DB071789CF210EF", hash_generated_method = "32CC565178535FB3D7DFA8CDEF0C2F03")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_590490402 = null; //Variable for return #1
        try 
        {
            BitSet clone;
            clone = (BitSet) super.clone();
            clone.bits = bits.clone();
            clone.shrinkSize();
            varB4EAC82CA7396A68D541C85D26508E83_590490402 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_590490402.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_590490402;
        // ---------- Original Method ----------
        //try {
            //BitSet clone = (BitSet) super.clone();
            //clone.bits = bits.clone();
            //clone.shrinkSize();
            //return clone;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.865 -0400", hash_original_method = "82791B0EBFB6ED23064857D8180EA65E", hash_generated_method = "6EA1A22CDE8698309F3CC9269362A749")
    @Override
    public boolean equals(Object o) {
        BitSet lhs;
        lhs = (BitSet) o;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359315374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359315374;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (!(o instanceof BitSet)) {
            //return false;
        //}
        //BitSet lhs = (BitSet) o;
        //if (this.longCount != lhs.longCount) {
            //return false;
        //}
        //for (int i = 0; i < longCount; ++i) {
            //if (bits[i] != lhs.bits[i]) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.871 -0400", hash_original_method = "FD70AAE85AF9795828FE994C30CD34E8", hash_generated_method = "65C18A20B632F1D3F59ECBDE33D28EEF")
    private void ensureCapacity(int desiredLongCount) {
        int newLength;
        newLength = Math.max(desiredLongCount, bits.length * 2);
        long[] newBits;
        newBits = new long[newLength];
        System.arraycopy(bits, 0, newBits, 0, longCount);
        this.bits = newBits;
        addTaint(desiredLongCount);
        // ---------- Original Method ----------
        //if (desiredLongCount <= bits.length) {
            //return;
        //}
        //int newLength = Math.max(desiredLongCount, bits.length * 2);
        //long[] newBits = new long[newLength];
        //System.arraycopy(bits, 0, newBits, 0, longCount);
        //this.bits = newBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.872 -0400", hash_original_method = "4E772724E1A92C93EB62C933BC27FE7C", hash_generated_method = "C993B9D997B50DAB29EDCC30F8E275F4")
    @Override
    public int hashCode() {
        long x;
        x = 1234;
        {
            int i;
            i = 0;
            {
                x ^= bits[i] * (i + 1);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064129348 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2064129348;
        // ---------- Original Method ----------
        //long x = 1234;
        //for (int i = 0; i < longCount; ++i) {
            //x ^= bits[i] * (i + 1);
        //}
        //return (int) ((x >> 32) ^ x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.884 -0400", hash_original_method = "95B4B3127159370AD2A9AF3A9CB73F00", hash_generated_method = "F14831CE68BD48D7AA6851ADD3E6E0B6")
    public boolean get(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex;
        arrayIndex = index / 64;
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040553476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040553476;
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return false;
        //}
        //return (bits[arrayIndex] & (1L << index)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.884 -0400", hash_original_method = "3D2EC51930163E4AB4304E4F9059CB5F", hash_generated_method = "8D3F0EE35881ED8DF55D37B759EF3B68")
    public void set(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex;
        arrayIndex = index / 64;
        {
            ensureCapacity(arrayIndex + 1);
        } //End block
        bits[arrayIndex] |= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= bits.length) {
            //ensureCapacity(arrayIndex + 1);
        //}
        //bits[arrayIndex] |= (1L << index);
        //longCount = Math.max(longCount, arrayIndex + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.885 -0400", hash_original_method = "D4755629803CE3870851808B06FB6C2C", hash_generated_method = "311406C4AC993ABC93E4505C996C51AA")
    public void clear(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex;
        arrayIndex = index / 64;
        bits[arrayIndex] &= ~(1L << index);
        shrinkSize();
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return;
        //}
        //bits[arrayIndex] &= ~(1L << index);
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.885 -0400", hash_original_method = "BA9F6F086346AF8289CA95B11E39C3E4", hash_generated_method = "D58FCBAE71DF2FD99C37CA7EB15929DE")
    public void flip(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex;
        arrayIndex = index / 64;
        {
            ensureCapacity(arrayIndex + 1);
        } //End block
        bits[arrayIndex] ^= (1L << index);
        longCount = Math.max(longCount, arrayIndex + 1);
        shrinkSize();
        // ---------- Original Method ----------
        //if (index < 0) { 
            //checkIndex(index);
        //}
        //int arrayIndex = index / 64;
        //if (arrayIndex >= bits.length) {
            //ensureCapacity(arrayIndex + 1);
        //}
        //bits[arrayIndex] ^= (1L << index);
        //longCount = Math.max(longCount, arrayIndex + 1);
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.886 -0400", hash_original_method = "71550A783E2339080C93A6660DB93338", hash_generated_method = "A5C7A229482D3796C88FC767F70B01D0")
    private void checkIndex(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index < 0: " + index);
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IndexOutOfBoundsException("index < 0: " + index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.886 -0400", hash_original_method = "87A456FF76D283B2A0EA4C0CB9963D07", hash_generated_method = "FFA03A6B642D6FA5935E9C0993D1F80B")
    private void checkRange(int fromIndex, int toIndex) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        } //End block
        addTaint(fromIndex);
        addTaint(toIndex);
        // ---------- Original Method ----------
        //if ((fromIndex | toIndex) < 0 || toIndex < fromIndex) {
            //throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.900 -0400", hash_original_method = "5C76FE7FFACA682F8E2DA192826E5D27", hash_generated_method = "D42B708B1745B1EAD940CD3C7D20B08C")
    public BitSet get(int fromIndex, int toIndex) {
        BitSet varB4EAC82CA7396A68D541C85D26508E83_1350940550 = null; //Variable for return #1
        BitSet varB4EAC82CA7396A68D541C85D26508E83_1445738058 = null; //Variable for return #2
        BitSet varB4EAC82CA7396A68D541C85D26508E83_621289614 = null; //Variable for return #3
        BitSet varB4EAC82CA7396A68D541C85D26508E83_1023611692 = null; //Variable for return #4
        checkRange(fromIndex, toIndex);
        int last;
        last = 64 * longCount;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1350940550 = new BitSet(0);
        } //End block
        {
            toIndex = last;
        } //End block
        int firstArrayIndex;
        firstArrayIndex = fromIndex / 64;
        int lastArrayIndex;
        lastArrayIndex = (toIndex - 1) / 64;
        long lowMask;
        lowMask = ALL_ONES << fromIndex;
        long highMask;
        highMask = ALL_ONES >>> -toIndex;
        {
            long result;
            result = (bits[firstArrayIndex] & (lowMask & highMask)) >>> fromIndex;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1445738058 = new BitSet(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_621289614 = new BitSet(new long[] { result });
        } //End block
        long[] newBits;
        newBits = new long[lastArrayIndex - firstArrayIndex + 1];
        newBits[0] = bits[firstArrayIndex] & lowMask;
        newBits[newBits.length - 1] = bits[lastArrayIndex] & highMask;
        {
            int i;
            i = 1;
            {
                newBits[i] = bits[firstArrayIndex + i];
            } //End block
        } //End collapsed parenthetic
        int numBitsToShift;
        numBitsToShift = fromIndex % 64;
        int actualLen;
        actualLen = newBits.length;
        {
            {
                int i;
                i = 0;
                {
                    newBits[i] = newBits[i] >>> (numBitsToShift);
                    {
                        newBits[i] |= newBits[i + 1] << -numBitsToShift;
                    } //End block
                    {
                        actualLen = i + 1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1023611692 = new BitSet(newBits);
        addTaint(fromIndex);
        addTaint(toIndex);
        BitSet varA7E53CE21691AB073D9660D615818899_115665602; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_115665602 = varB4EAC82CA7396A68D541C85D26508E83_1350940550;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_115665602 = varB4EAC82CA7396A68D541C85D26508E83_1445738058;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_115665602 = varB4EAC82CA7396A68D541C85D26508E83_621289614;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_115665602 = varB4EAC82CA7396A68D541C85D26508E83_1023611692;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_115665602.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_115665602;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.904 -0400", hash_original_method = "74386BE28B96B2445F889AFAD9F88AFA", hash_generated_method = "A3BFCA509C93347D763172D8864B59C5")
    public void set(int index, boolean state) {
        {
            set(index);
        } //End block
        {
            clear(index);
        } //End block
        addTaint(index);
        addTaint(state);
        // ---------- Original Method ----------
        //if (state) {
            //set(index);
        //} else {
            //clear(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.904 -0400", hash_original_method = "9EFB812AD22830556B4E1C754018229D", hash_generated_method = "E55195D50C0E6114CB8C94974EDC543C")
    public void set(int fromIndex, int toIndex, boolean state) {
        {
            set(fromIndex, toIndex);
        } //End block
        {
            clear(fromIndex, toIndex);
        } //End block
        addTaint(fromIndex);
        addTaint(toIndex);
        addTaint(state);
        // ---------- Original Method ----------
        //if (state) {
            //set(fromIndex, toIndex);
        //} else {
            //clear(fromIndex, toIndex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.915 -0400", hash_original_method = "8EA7A389047D1FB0971FCD5F7482B28A", hash_generated_method = "2309BC392D8D2DE8CDACCC9A041B29DF")
    public void clear() {
        Arrays.fill(bits, 0, longCount, 0L);
        longCount = 0;
        // ---------- Original Method ----------
        //Arrays.fill(bits, 0, longCount, 0L);
        //longCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.915 -0400", hash_original_method = "A26503DA159C46EB79782AEABE473F9D", hash_generated_method = "DC2A7919855595A04864318262FFA29E")
    public void set(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int firstArrayIndex;
        firstArrayIndex = fromIndex / 64;
        int lastArrayIndex;
        lastArrayIndex = (toIndex - 1) / 64;
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask;
        lowMask = ALL_ONES << fromIndex;
        long highMask;
        highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] |= (lowMask & highMask);
        } //End block
        {
            int i;
            i = firstArrayIndex;
            bits[i++] |= lowMask;
            {
                bits[i++] |= ALL_ONES;
            } //End block
            bits[i++] |= highMask;
        } //End block
        longCount = Math.max(longCount, lastArrayIndex + 1);
        addTaint(fromIndex);
        addTaint(toIndex);
        // ---------- Original Method ----------
        //checkRange(fromIndex, toIndex);
        //if (fromIndex == toIndex) {
            //return;
        //}
        //int firstArrayIndex = fromIndex / 64;
        //int lastArrayIndex = (toIndex - 1) / 64;
        //if (lastArrayIndex >= bits.length) {
            //ensureCapacity(lastArrayIndex + 1);
        //}
        //long lowMask = ALL_ONES << fromIndex;
        //long highMask = ALL_ONES >>> -toIndex;
        //if (firstArrayIndex == lastArrayIndex) {
            //bits[firstArrayIndex] |= (lowMask & highMask);
        //} else {
            //int i = firstArrayIndex;
            //bits[i++] |= lowMask;
            //while (i < lastArrayIndex) {
                //bits[i++] |= ALL_ONES;
            //}
            //bits[i++] |= highMask;
        //}
        //longCount = Math.max(longCount, lastArrayIndex + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.917 -0400", hash_original_method = "C97E5F07F0FAAF9942FBF154783DA0BB", hash_generated_method = "A82CCC829979F0681D18750A95FE7AF8")
    public void clear(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int last;
        last = 64 * longCount;
        {
            toIndex = last;
        } //End block
        int firstArrayIndex;
        firstArrayIndex = fromIndex / 64;
        int lastArrayIndex;
        lastArrayIndex = (toIndex - 1) / 64;
        long lowMask;
        lowMask = ALL_ONES << fromIndex;
        long highMask;
        highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] &= ~(lowMask & highMask);
        } //End block
        {
            int i;
            i = firstArrayIndex;
            bits[i++] &= ~lowMask;
            {
                bits[i++] = 0L;
            } //End block
            bits[i++] &= ~highMask;
        } //End block
        shrinkSize();
        addTaint(fromIndex);
        addTaint(toIndex);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.918 -0400", hash_original_method = "AF219115F487DC5279F51F56FAD6576B", hash_generated_method = "F2205D991363A8B665FEA16E0E6FE8A7")
    public void flip(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int firstArrayIndex;
        firstArrayIndex = fromIndex / 64;
        int lastArrayIndex;
        lastArrayIndex = (toIndex - 1) / 64;
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask;
        lowMask = ALL_ONES << fromIndex;
        long highMask;
        highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] ^= (lowMask & highMask);
        } //End block
        {
            int i;
            i = firstArrayIndex;
            bits[i++] ^= lowMask;
            {
                bits[i++] ^= ALL_ONES;
            } //End block
            bits[i++] ^= highMask;
        } //End block
        longCount = Math.max(longCount, lastArrayIndex + 1);
        shrinkSize();
        addTaint(fromIndex);
        addTaint(toIndex);
        // ---------- Original Method ----------
        //checkRange(fromIndex, toIndex);
        //if (fromIndex == toIndex) {
            //return;
        //}
        //int firstArrayIndex = fromIndex / 64;
        //int lastArrayIndex = (toIndex - 1) / 64;
        //if (lastArrayIndex >= bits.length) {
            //ensureCapacity(lastArrayIndex + 1);
        //}
        //long lowMask = ALL_ONES << fromIndex;
        //long highMask = ALL_ONES >>> -toIndex;
        //if (firstArrayIndex == lastArrayIndex) {
            //bits[firstArrayIndex] ^= (lowMask & highMask);
        //} else {
            //int i = firstArrayIndex;
            //bits[i++] ^= lowMask;
            //while (i < lastArrayIndex) {
                //bits[i++] ^= ALL_ONES;
            //}
            //bits[i++] ^= highMask;
        //}
        //longCount = Math.max(longCount, lastArrayIndex + 1);
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.921 -0400", hash_original_method = "F6E914263E6B2AC21BC763D068DFC9F2", hash_generated_method = "DFB0061412CB15B3270C7B4F1DDAA4F5")
    public boolean intersects(BitSet bs) {
        long[] bsBits;
        bsBits = bs.bits;
        int length;
        length = Math.min(this.longCount, bs.longCount);
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(bs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107695519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_107695519;
        // ---------- Original Method ----------
        //long[] bsBits = bs.bits;
        //int length = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < length; ++i) {
            //if ((bits[i] & bsBits[i]) != 0L) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.922 -0400", hash_original_method = "83F89EEE7E2D54034E7D4AA2FF619E80", hash_generated_method = "5623C77D097FBD58C0BDAB8E1DB68A50")
    public void and(BitSet bs) {
        int minSize;
        minSize = Math.min(this.longCount, bs.longCount);
        {
            int i;
            i = 0;
            {
                bits[i] &= bs.bits[i];
            } //End block
        } //End collapsed parenthetic
        Arrays.fill(bits, minSize, longCount, 0L);
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] &= bs.bits[i];
        //}
        //Arrays.fill(bits, minSize, longCount, 0L);
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.922 -0400", hash_original_method = "6AEA541E74DD35C186C561500AE782A6", hash_generated_method = "C7C1D252A839C17EC60A6E57E722FB9C")
    public void andNot(BitSet bs) {
        int minSize;
        minSize = Math.min(this.longCount, bs.longCount);
        {
            int i;
            i = 0;
            {
                bits[i] &= ~bs.bits[i];
            } //End block
        } //End collapsed parenthetic
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] &= ~bs.bits[i];
        //}
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.923 -0400", hash_original_method = "BEA444ABE4A457608A295CEBFA17C48D", hash_generated_method = "172DB4202DA2E2B9F5391833C38B630F")
    public void or(BitSet bs) {
        int minSize;
        minSize = Math.min(this.longCount, bs.longCount);
        int maxSize;
        maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        {
            int i;
            i = 0;
            {
                bits[i] |= bs.bits[i];
            } //End block
        } //End collapsed parenthetic
        {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        } //End block
        longCount = maxSize;
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //int maxSize = Math.max(this.longCount, bs.longCount);
        //ensureCapacity(maxSize);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] |= bs.bits[i];
        //}
        //if (bs.longCount > minSize) {
            //System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        //}
        //longCount = maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.931 -0400", hash_original_method = "E1F10E844B44799F9E6FF97093185186", hash_generated_method = "588371BA9F1515AA5BA4D9607853FA16")
    public void xor(BitSet bs) {
        int minSize;
        minSize = Math.min(this.longCount, bs.longCount);
        int maxSize;
        maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        {
            int i;
            i = 0;
            {
                bits[i] ^= bs.bits[i];
            } //End block
        } //End collapsed parenthetic
        {
            System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        } //End block
        longCount = maxSize;
        shrinkSize();
        // ---------- Original Method ----------
        //int minSize = Math.min(this.longCount, bs.longCount);
        //int maxSize = Math.max(this.longCount, bs.longCount);
        //ensureCapacity(maxSize);
        //for (int i = 0; i < minSize; ++i) {
            //bits[i] ^= bs.bits[i];
        //}
        //if (bs.longCount > minSize) {
            //System.arraycopy(bs.bits, minSize, bits, minSize, maxSize - minSize);
        //}
        //longCount = maxSize;
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.932 -0400", hash_original_method = "F33E07354BDEEAA3CDE5DA5EA8779C95", hash_generated_method = "61C503A9AD4EBBFEE519640A923F6455")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569323714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569323714;
        // ---------- Original Method ----------
        //return bits.length * 64;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.932 -0400", hash_original_method = "6F3396C6D4F506441C95587742A4BBC3", hash_generated_method = "7DF3189D225D66AA7B5BFD4B5823507D")
    public int length() {
        int var8DDE3DB99F8E017D590E08915D9DE94D_488130269 = (64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1])));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553741223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1553741223;
        // ---------- Original Method ----------
        //if (longCount == 0) {
            //return 0;
        //}
        //return 64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.940 -0400", hash_original_method = "A54CE267AEC3D3118A3C3A52C928D20A", hash_generated_method = "091B8B4A27ECAF281F2569EB5CD75DCC")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1980400561 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(longCount / 2);
        sb.append('{');
        boolean comma;
        comma = false;
        {
            int i;
            i = 0;
            {
                {
                    {
                        int j;
                        j = 0;
                        {
                            {
                                {
                                    sb.append(", ");
                                } //End block
                                {
                                    comma = true;
                                } //End block
                                sb.append(64 * i + j);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_1980400561 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1980400561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980400561;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(longCount / 2);
        //sb.append('{');
        //boolean comma = false;
        //for (int i = 0; i < longCount; ++i) {
            //if (bits[i] != 0) {
                //for (int j = 0; j < 64; ++j) {
                    //if ((bits[i] & 1L << j) != 0) {
                        //if (comma) {
                            //sb.append(", ");
                        //} else {
                            //comma = true;
                        //}
                        //sb.append(64 * i + j);
                    //}
                //}
            //}
        //}
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.946 -0400", hash_original_method = "9B70742E631D0FF7E36300CA25C790B5", hash_generated_method = "30FDF0B721007B8AB7B0604AB3FB2EC9")
    public int nextSetBit(int index) {
        checkIndex(index);
        int arrayIndex;
        arrayIndex = index / 64;
        long mask;
        mask = ALL_ONES << index;
        {
            int varD43158D00A08A92927E533B87144802C_1473715375 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask));
        } //End block
        int varC011A1606C203AD5B16168BBCBDCB4E1_314376730 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866037236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866037236;
        // ---------- Original Method ----------
        //checkIndex(index);
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return -1;
        //}
        //long mask = ALL_ONES << index;
        //if ((bits[arrayIndex] & mask) != 0) {
            //return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask);
        //}
        //while (++arrayIndex < longCount && bits[arrayIndex] == 0) {
        //}
        //if (arrayIndex == longCount) {
            //return -1;
        //}
        //return 64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.951 -0400", hash_original_method = "B6E36E70EF447F6B993A99CF808640C0", hash_generated_method = "F9C874AE9AF82EA2DDCC6886FE973009")
    public int nextClearBit(int index) {
        checkIndex(index);
        int arrayIndex;
        arrayIndex = index / 64;
        long mask;
        mask = ALL_ONES << index;
        {
            int var52BAF9B064911EB34A3604F2E011FF1B_1428465061 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask));
        } //End block
        {
            int var30B6C663C2B6D2AFA1DA9F62CE96F495_1967161919 = (size());
        } //End block
        int var88FEEF922745B43160A9B451ED95D469_1493727367 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613805711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613805711;
        // ---------- Original Method ----------
        //checkIndex(index);
        //int arrayIndex = index / 64;
        //if (arrayIndex >= longCount) {
            //return index;
        //}
        //long mask = ALL_ONES << index;
        //if ((~bits[arrayIndex] & mask) != 0) {
            //return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask);
        //}
        //while (++arrayIndex < longCount && bits[arrayIndex] == ALL_ONES) {
        //}
        //if (arrayIndex == longCount) {
            //return size();
        //}
        //return 64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.952 -0400", hash_original_method = "BDE3A7C277C6F771330A08D119C9767D", hash_generated_method = "C1FD6CE5B384E8B05328B3F538B5D440")
    public int previousSetBit(int index) {
        checkIndex(index);
        {
            int i;
            i = index;
            {
                {
                    boolean var1225DD33B9BD6400B5B7107AF96C3D7B_4085019 = (get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307838252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1307838252;
        // ---------- Original Method ----------
        //if (index == -1) {
            //return -1;
        //}
        //checkIndex(index);
        //for (int i = index; i >= 0; --i) {
            //if (get(i)) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.953 -0400", hash_original_method = "4D910DE065D256451DE439F25B5A6A08", hash_generated_method = "5A644421B240295F064027FF101F848D")
    public int previousClearBit(int index) {
        checkIndex(index);
        {
            int i;
            i = index;
            {
                {
                    boolean varB73C00E6C21E0B274528170F6662ADEC_298328364 = (!get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715991377 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715991377;
        // ---------- Original Method ----------
        //if (index == -1) {
            //return -1;
        //}
        //checkIndex(index);
        //for (int i = index; i >= 0; --i) {
            //if (!get(i)) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.953 -0400", hash_original_method = "F34A10F6A3FF7AEAC6E09DDBD9741E2B", hash_generated_method = "44734F122852BAC39E29CAF73EF77FC2")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709760385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709760385;
        // ---------- Original Method ----------
        //return (longCount == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.968 -0400", hash_original_method = "5D3E782DB55862032A3B0CF1D30A4050", hash_generated_method = "4014849C1DDFB13B622D907735FCBE4C")
    public int cardinality() {
        int result;
        result = 0;
        {
            int i;
            i = 0;
            {
                result += Long.bitCount(bits[i]);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993893560 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993893560;
        // ---------- Original Method ----------
        //int result = 0;
        //for (int i = 0; i < longCount; ++i) {
            //result += Long.bitCount(bits[i]);
        //}
        //return result;
    }

    
        public static BitSet valueOf(long[] longs) {
        return new BitSet(longs.clone());
    }

    
        public static BitSet valueOf(LongBuffer longBuffer) {
        long[] longs = new long[longBuffer.remaining()];
        for (int i = 0; i < longs.length; ++i) {
            longs[i] = longBuffer.get(longBuffer.position() + i);
        }
        return BitSet.valueOf(longs);
    }

    
        public static BitSet valueOf(byte[] bytes) {
        return BitSet.valueOf(ByteBuffer.wrap(bytes));
    }

    
        public static BitSet valueOf(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN);
        long[] longs = arrayForBits(byteBuffer.remaining() * 8);
        int i = 0;
        while (byteBuffer.remaining() >= SizeOf.LONG) {
            longs[i++] = byteBuffer.getLong();
        }
        for (int j = 0; byteBuffer.hasRemaining(); ++j) {
            longs[i] |= ((((long) byteBuffer.get()) & 0xff) << (8*j));
        }
        return BitSet.valueOf(longs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.969 -0400", hash_original_method = "87C10E36682237AA1B22F77F460E655A", hash_generated_method = "15163D6BE08558984440AFAB66926330")
    public long[] toLongArray() {
        long[] var6DF8F488F88B02867D1476840B5A40C1_691025920 = (Arrays.copyOf(bits, longCount));
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_171160190 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_171160190;
        // ---------- Original Method ----------
        //return Arrays.copyOf(bits, longCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.970 -0400", hash_original_method = "BCE80AE7073A25796C80405F8FB14636", hash_generated_method = "9AE57CA564E8364E265E54FBF677A4C8")
    public byte[] toByteArray() {
        int bitCount;
        bitCount = length();
        byte[] result;
        result = new byte[(bitCount + 7)/ 8];
        {
            int i;
            i = 0;
            {
                int lowBit;
                lowBit = 8 * i;
                int arrayIndex;
                arrayIndex = lowBit / 64;
                result[i] = (byte) (bits[arrayIndex] >>> lowBit);
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1496498414 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1496498414;
        // ---------- Original Method ----------
        //int bitCount = length();
        //byte[] result = new byte[(bitCount + 7)/ 8];
        //for (int i = 0; i < result.length; ++i) {
            //int lowBit = 8 * i;
            //int arrayIndex = lowBit / 64;
            //result[i] = (byte) (bits[arrayIndex] >>> lowBit);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.970 -0400", hash_original_method = "928646C6EBB028EB87EF1072BE151B53", hash_generated_method = "47FB0E7BEF2E22FC40C66E1A790811BB")
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        this.longCount = this.bits.length;
        shrinkSize();
        addTaint(ois.getTaint());
        // ---------- Original Method ----------
        //ois.defaultReadObject();
        //this.longCount = this.bits.length;
        //shrinkSize();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.970 -0400", hash_original_field = "1746B9E5B72A597D589BE87B4E70F48A", hash_generated_field = "8272F9B481A41816654BD8EB9D79476D")

    private static long serialVersionUID = 7997698588986878753L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.970 -0400", hash_original_field = "550DEA04DA165D0625CB0E2028B4AB38", hash_generated_field = "11649759CC8717A92B0AF9CF9804D30B")

    private static long ALL_ONES = ~0L;
}

