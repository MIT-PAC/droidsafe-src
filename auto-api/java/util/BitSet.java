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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.999 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.999 -0400", hash_original_field = "B7881959E051E122A93F0F4BB9A45AB8", hash_generated_field = "DC80EF19CD932E16185FEB519D23D494")

    private transient int longCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.000 -0400", hash_original_method = "36F48153593A7027DE7089606CF225FB", hash_generated_method = "613602062985992FB8430672E70C7481")
    public  BitSet() {
        this(new long[1]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.000 -0400", hash_original_method = "12ED281EDA73627C34F706B1E8393C0F", hash_generated_method = "C7CD726103BF2541C7B3FDDBCF45C69E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.000 -0400", hash_original_method = "F5397E49D432953D65E6CB2ED1150384", hash_generated_method = "1C0E37C5115CD13FD56B4BE776F6A166")
    private  BitSet(long[] bits) {
        this.bits = bits;
        this.longCount = bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //this.bits = bits;
        //this.longCount = bits.length;
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.000 -0400", hash_original_method = "2E0FE194508C45AD5184DCF0A152D7A0", hash_generated_method = "2824BBF287F92F88C53D065A3A219FAA")
    private void shrinkSize() {
        int i = longCount - 1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.001 -0400", hash_original_method = "C5612661FC3C49DB4DB071789CF210EF", hash_generated_method = "786436EBD91ED71DEC31BE23AEF13733")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1109861326 = null; //Variable for return #1
        try 
        {
            BitSet clone = (BitSet) super.clone();
            clone.bits = bits.clone();
            clone.shrinkSize();
            varB4EAC82CA7396A68D541C85D26508E83_1109861326 = clone;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1109861326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109861326;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.001 -0400", hash_original_method = "82791B0EBFB6ED23064857D8180EA65E", hash_generated_method = "62D41601C9E208390B38E437A9C6B132")
    @Override
    public boolean equals(Object o) {
        BitSet lhs = (BitSet) o;
        {
            int i = 0;
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_788544789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_788544789;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.002 -0400", hash_original_method = "FD70AAE85AF9795828FE994C30CD34E8", hash_generated_method = "07C92075C71405D1DA2B0647390865D9")
    private void ensureCapacity(int desiredLongCount) {
        int newLength = Math.max(desiredLongCount, bits.length * 2);
        long[] newBits = new long[newLength];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.003 -0400", hash_original_method = "4E772724E1A92C93EB62C933BC27FE7C", hash_generated_method = "43815A1C6DD5CA4D23B95FE95739FC43")
    @Override
    public int hashCode() {
        long x = 1234;
        {
            int i = 0;
            {
                x ^= bits[i] * (i + 1);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205652845 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_205652845;
        // ---------- Original Method ----------
        //long x = 1234;
        //for (int i = 0; i < longCount; ++i) {
            //x ^= bits[i] * (i + 1);
        //}
        //return (int) ((x >> 32) ^ x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.003 -0400", hash_original_method = "95B4B3127159370AD2A9AF3A9CB73F00", hash_generated_method = "B54B3603980BCA8D4D5936B57BF8AE09")
    public boolean get(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157535724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157535724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.004 -0400", hash_original_method = "3D2EC51930163E4AB4304E4F9059CB5F", hash_generated_method = "1717D41B4FB64884E131134C8B287A5E")
    public void set(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.004 -0400", hash_original_method = "D4755629803CE3870851808B06FB6C2C", hash_generated_method = "8F3127DDDD344ADAFE2960E88A96CF88")
    public void clear(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.005 -0400", hash_original_method = "BA9F6F086346AF8289CA95B11E39C3E4", hash_generated_method = "6E9980D04C24873ECEE444F5E954991C")
    public void flip(int index) {
        {
            checkIndex(index);
        } //End block
        int arrayIndex = index / 64;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.005 -0400", hash_original_method = "71550A783E2339080C93A6660DB93338", hash_generated_method = "A5C7A229482D3796C88FC767F70B01D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.005 -0400", hash_original_method = "87A456FF76D283B2A0EA4C0CB9963D07", hash_generated_method = "FFA03A6B642D6FA5935E9C0993D1F80B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.007 -0400", hash_original_method = "5C76FE7FFACA682F8E2DA192826E5D27", hash_generated_method = "3773956136A6C344A38C94ED06B312AB")
    public BitSet get(int fromIndex, int toIndex) {
        BitSet varB4EAC82CA7396A68D541C85D26508E83_608230015 = null; //Variable for return #1
        BitSet varB4EAC82CA7396A68D541C85D26508E83_1461810869 = null; //Variable for return #2
        BitSet varB4EAC82CA7396A68D541C85D26508E83_944185742 = null; //Variable for return #3
        BitSet varB4EAC82CA7396A68D541C85D26508E83_601205655 = null; //Variable for return #4
        checkRange(fromIndex, toIndex);
        int last = 64 * longCount;
        {
            varB4EAC82CA7396A68D541C85D26508E83_608230015 = new BitSet(0);
        } //End block
        {
            toIndex = last;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        {
            long result = (bits[firstArrayIndex] & (lowMask & highMask)) >>> fromIndex;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1461810869 = new BitSet(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_944185742 = new BitSet(new long[] { result });
        } //End block
        long[] newBits = new long[lastArrayIndex - firstArrayIndex + 1];
        newBits[0] = bits[firstArrayIndex] & lowMask;
        newBits[newBits.length - 1] = bits[lastArrayIndex] & highMask;
        {
            int i = 1;
            {
                newBits[i] = bits[firstArrayIndex + i];
            } //End block
        } //End collapsed parenthetic
        int numBitsToShift = fromIndex % 64;
        int actualLen = newBits.length;
        {
            {
                int i = 0;
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
        varB4EAC82CA7396A68D541C85D26508E83_601205655 = new BitSet(newBits);
        addTaint(fromIndex);
        addTaint(toIndex);
        BitSet varA7E53CE21691AB073D9660D615818899_1117285687; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1117285687 = varB4EAC82CA7396A68D541C85D26508E83_608230015;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1117285687 = varB4EAC82CA7396A68D541C85D26508E83_1461810869;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1117285687 = varB4EAC82CA7396A68D541C85D26508E83_944185742;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1117285687 = varB4EAC82CA7396A68D541C85D26508E83_601205655;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1117285687.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1117285687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.007 -0400", hash_original_method = "74386BE28B96B2445F889AFAD9F88AFA", hash_generated_method = "A3BFCA509C93347D763172D8864B59C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.007 -0400", hash_original_method = "9EFB812AD22830556B4E1C754018229D", hash_generated_method = "E55195D50C0E6114CB8C94974EDC543C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.008 -0400", hash_original_method = "8EA7A389047D1FB0971FCD5F7482B28A", hash_generated_method = "2309BC392D8D2DE8CDACCC9A041B29DF")
    public void clear() {
        Arrays.fill(bits, 0, longCount, 0L);
        longCount = 0;
        // ---------- Original Method ----------
        //Arrays.fill(bits, 0, longCount, 0L);
        //longCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.008 -0400", hash_original_method = "A26503DA159C46EB79782AEABE473F9D", hash_generated_method = "F5D8872EBA228677BE9C143E3D2996F3")
    public void set(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] |= (lowMask & highMask);
        } //End block
        {
            int i = firstArrayIndex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.009 -0400", hash_original_method = "C97E5F07F0FAAF9942FBF154783DA0BB", hash_generated_method = "3FB00EBF529D6623D91988812CF2CB8A")
    public void clear(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int last = 64 * longCount;
        {
            toIndex = last;
        } //End block
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] &= ~(lowMask & highMask);
        } //End block
        {
            int i = firstArrayIndex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.009 -0400", hash_original_method = "AF219115F487DC5279F51F56FAD6576B", hash_generated_method = "64EAED965033EB4EC4BC017FFB29F9F6")
    public void flip(int fromIndex, int toIndex) {
        checkRange(fromIndex, toIndex);
        int firstArrayIndex = fromIndex / 64;
        int lastArrayIndex = (toIndex - 1) / 64;
        {
            ensureCapacity(lastArrayIndex + 1);
        } //End block
        long lowMask = ALL_ONES << fromIndex;
        long highMask = ALL_ONES >>> -toIndex;
        {
            bits[firstArrayIndex] ^= (lowMask & highMask);
        } //End block
        {
            int i = firstArrayIndex;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.010 -0400", hash_original_method = "F6E914263E6B2AC21BC763D068DFC9F2", hash_generated_method = "6CD566BAC2DD6A443E3516DC8F1279C2")
    public boolean intersects(BitSet bs) {
        long[] bsBits = bs.bits;
        int length = Math.min(this.longCount, bs.longCount);
        {
            int i = 0;
        } //End collapsed parenthetic
        addTaint(bs.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984326658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984326658;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.010 -0400", hash_original_method = "83F89EEE7E2D54034E7D4AA2FF619E80", hash_generated_method = "214FA4C7C675E980C4B32233C17CBBAD")
    public void and(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.010 -0400", hash_original_method = "6AEA541E74DD35C186C561500AE782A6", hash_generated_method = "8950038FC1DEB22D0C9268EA80567B6B")
    public void andNot(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.011 -0400", hash_original_method = "BEA444ABE4A457608A295CEBFA17C48D", hash_generated_method = "B38D553B9B8A7AE8891C41CEC594E704")
    public void or(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.011 -0400", hash_original_method = "E1F10E844B44799F9E6FF97093185186", hash_generated_method = "D586090C82D9EB6D99D5A225676159FB")
    public void xor(BitSet bs) {
        int minSize = Math.min(this.longCount, bs.longCount);
        int maxSize = Math.max(this.longCount, bs.longCount);
        ensureCapacity(maxSize);
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.012 -0400", hash_original_method = "F33E07354BDEEAA3CDE5DA5EA8779C95", hash_generated_method = "5C29DFE5FAD71394FE1C67B3A4D6F88D")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938297180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938297180;
        // ---------- Original Method ----------
        //return bits.length * 64;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.012 -0400", hash_original_method = "6F3396C6D4F506441C95587742A4BBC3", hash_generated_method = "57967E03514D20BFA6E42056CEF9F35E")
    public int length() {
        int var8DDE3DB99F8E017D590E08915D9DE94D_240609607 = (64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1])));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525403779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525403779;
        // ---------- Original Method ----------
        //if (longCount == 0) {
            //return 0;
        //}
        //return 64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.013 -0400", hash_original_method = "A54CE267AEC3D3118A3C3A52C928D20A", hash_generated_method = "5A25B6FDA4140607A4526D727B25470E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1528734910 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(longCount / 2);
        sb.append('{');
        boolean comma = false;
        {
            int i = 0;
            {
                {
                    {
                        int j = 0;
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
        varB4EAC82CA7396A68D541C85D26508E83_1528734910 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1528734910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1528734910;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.014 -0400", hash_original_method = "9B70742E631D0FF7E36300CA25C790B5", hash_generated_method = "D17BA757E97AD16F9FCD05DCFD757A83")
    public int nextSetBit(int index) {
        checkIndex(index);
        int arrayIndex = index / 64;
        long mask = ALL_ONES << index;
        {
            int varD43158D00A08A92927E533B87144802C_1795603465 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask));
        } //End block
        int varC011A1606C203AD5B16168BBCBDCB4E1_1297126139 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621560214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1621560214;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.015 -0400", hash_original_method = "B6E36E70EF447F6B993A99CF808640C0", hash_generated_method = "9F4130E3446D64A171DE31CF390D2993")
    public int nextClearBit(int index) {
        checkIndex(index);
        int arrayIndex = index / 64;
        long mask = ALL_ONES << index;
        {
            int var52BAF9B064911EB34A3604F2E011FF1B_1055278333 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask));
        } //End block
        {
            int var30B6C663C2B6D2AFA1DA9F62CE96F495_1402121946 = (size());
        } //End block
        int var88FEEF922745B43160A9B451ED95D469_684579439 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263816514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263816514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.016 -0400", hash_original_method = "BDE3A7C277C6F771330A08D119C9767D", hash_generated_method = "F9EFF8938F7E8387DE00B2A9E23B2F2B")
    public int previousSetBit(int index) {
        checkIndex(index);
        {
            int i = index;
            {
                {
                    boolean var1225DD33B9BD6400B5B7107AF96C3D7B_1712649655 = (get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001701179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1001701179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.017 -0400", hash_original_method = "4D910DE065D256451DE439F25B5A6A08", hash_generated_method = "3FB80A947120D27F9312A9803F53BF94")
    public int previousClearBit(int index) {
        checkIndex(index);
        {
            int i = index;
            {
                {
                    boolean varB73C00E6C21E0B274528170F6662ADEC_462540739 = (!get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928396468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1928396468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.017 -0400", hash_original_method = "F34A10F6A3FF7AEAC6E09DDBD9741E2B", hash_generated_method = "E98ED5BC872B1092A7421DB966EABC37")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927466425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927466425;
        // ---------- Original Method ----------
        //return (longCount == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.018 -0400", hash_original_method = "5D3E782DB55862032A3B0CF1D30A4050", hash_generated_method = "26D2EDBE6E6FFA361B5C176BE3E2B92E")
    public int cardinality() {
        int result = 0;
        {
            int i = 0;
            {
                result += Long.bitCount(bits[i]);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216246307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216246307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.019 -0400", hash_original_method = "87C10E36682237AA1B22F77F460E655A", hash_generated_method = "DBF0C9DD4404EAAC2CED029E5D2902AB")
    public long[] toLongArray() {
        long[] var6DF8F488F88B02867D1476840B5A40C1_1636840429 = (Arrays.copyOf(bits, longCount));
        long[] var3908C7C3AF5171CEE1F112DAE77A5C4D_399294903 = {getTaintLong()};
        return var3908C7C3AF5171CEE1F112DAE77A5C4D_399294903;
        // ---------- Original Method ----------
        //return Arrays.copyOf(bits, longCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.019 -0400", hash_original_method = "BCE80AE7073A25796C80405F8FB14636", hash_generated_method = "7CECBF5F9732142C0981D8D6245E9A95")
    public byte[] toByteArray() {
        int bitCount = length();
        byte[] result = new byte[(bitCount + 7)/ 8];
        {
            int i = 0;
            {
                int lowBit = 8 * i;
                int arrayIndex = lowBit / 64;
                result[i] = (byte) (bits[arrayIndex] >>> lowBit);
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_214982254 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_214982254;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.019 -0400", hash_original_method = "928646C6EBB028EB87EF1072BE151B53", hash_generated_method = "47FB0E7BEF2E22FC40C66E1A790811BB")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.019 -0400", hash_original_field = "1746B9E5B72A597D589BE87B4E70F48A", hash_generated_field = "975BBBA7B21A6881F86AABFE03BF689A")

    private static final long serialVersionUID = 7997698588986878753L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:01.019 -0400", hash_original_field = "550DEA04DA165D0625CB0E2028B4AB38", hash_generated_field = "BC830E41BA8334B8E98728347067D4B9")

    private static final long ALL_ONES = ~0L;
}

