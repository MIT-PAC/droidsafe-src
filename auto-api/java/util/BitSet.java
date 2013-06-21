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
    private long[] bits;
    private transient int longCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.073 -0400", hash_original_method = "36F48153593A7027DE7089606CF225FB", hash_generated_method = "613602062985992FB8430672E70C7481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitSet() {
        this(new long[1]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.073 -0400", hash_original_method = "12ED281EDA73627C34F706B1E8393C0F", hash_generated_method = "35A3A7929BF60C14F96226B49C451C39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitSet(int bitCount) {
        dsTaint.addTaint(bitCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.074 -0400", hash_original_method = "F5397E49D432953D65E6CB2ED1150384", hash_generated_method = "1D8D3E58391A61F03C77FD581F9C5F63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BitSet(long[] bits) {
        dsTaint.addTaint(bits[0]);
        this.longCount = bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //this.bits = bits;
        //this.longCount = bits.length;
        //shrinkSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.074 -0400", hash_original_method = "2E0FE194508C45AD5184DCF0A152D7A0", hash_generated_method = "9F473D6240FACDC65C66DAAD4186DF40")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.074 -0400", hash_original_method = "C5612661FC3C49DB4DB071789CF210EF", hash_generated_method = "823069630CF76F9F6F803FA95F4B751B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            BitSet clone;
            clone = (BitSet) super.clone();
            clone.bits = bits.clone();
            clone.shrinkSize();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.075 -0400", hash_original_method = "82791B0EBFB6ED23064857D8180EA65E", hash_generated_method = "E723C4EF1862B8A8F47FB6E0B3FB4147")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        BitSet lhs;
        lhs = (BitSet) o;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.075 -0400", hash_original_method = "FD70AAE85AF9795828FE994C30CD34E8", hash_generated_method = "369688FB561C196945E4F7A3938D3FCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureCapacity(int desiredLongCount) {
        dsTaint.addTaint(desiredLongCount);
        int newLength;
        newLength = Math.max(desiredLongCount, bits.length * 2);
        long[] newBits;
        newBits = new long[newLength];
        System.arraycopy(bits, 0, newBits, 0, longCount);
        this.bits = newBits;
        // ---------- Original Method ----------
        //if (desiredLongCount <= bits.length) {
            //return;
        //}
        //int newLength = Math.max(desiredLongCount, bits.length * 2);
        //long[] newBits = new long[newLength];
        //System.arraycopy(bits, 0, newBits, 0, longCount);
        //this.bits = newBits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.075 -0400", hash_original_method = "4E772724E1A92C93EB62C933BC27FE7C", hash_generated_method = "A7AA73B9B245F656C497405997ADEA8F")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //long x = 1234;
        //for (int i = 0; i < longCount; ++i) {
            //x ^= bits[i] * (i + 1);
        //}
        //return (int) ((x >> 32) ^ x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.076 -0400", hash_original_method = "95B4B3127159370AD2A9AF3A9CB73F00", hash_generated_method = "31B108517B1289DF78F6FEE05825A376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean get(int index) {
        dsTaint.addTaint(index);
        {
            checkIndex(index);
        } //End block
        int arrayIndex;
        arrayIndex = index / 64;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.077 -0400", hash_original_method = "3D2EC51930163E4AB4304E4F9059CB5F", hash_generated_method = "A994BEE06B9AD32B2C36E2932AA75690")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(int index) {
        dsTaint.addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.078 -0400", hash_original_method = "D4755629803CE3870851808B06FB6C2C", hash_generated_method = "F0CBF659E21B6065DF01803F64AA93C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear(int index) {
        dsTaint.addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.078 -0400", hash_original_method = "BA9F6F086346AF8289CA95B11E39C3E4", hash_generated_method = "5D1BA9FDA9D65CDFEF3D53F7E68E83ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flip(int index) {
        dsTaint.addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.078 -0400", hash_original_method = "71550A783E2339080C93A6660DB93338", hash_generated_method = "299F918B2D8A25177458D78C71F66A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkIndex(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index < 0: " + index);
        } //End block
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IndexOutOfBoundsException("index < 0: " + index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.079 -0400", hash_original_method = "87A456FF76D283B2A0EA4C0CB9963D07", hash_generated_method = "37F68AA9DAF707167A11EF00BC209199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkRange(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        } //End block
        // ---------- Original Method ----------
        //if ((fromIndex | toIndex) < 0 || toIndex < fromIndex) {
            //throw new IndexOutOfBoundsException("fromIndex=" + fromIndex + " toIndex=" + toIndex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.079 -0400", hash_original_method = "5C76FE7FFACA682F8E2DA192826E5D27", hash_generated_method = "D573D95F453EDBF9A28085705780A7AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BitSet get(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
        checkRange(fromIndex, toIndex);
        int last;
        last = 64 * longCount;
        {
            BitSet varA1BC6EC1B1E2CA9063763A1C08E0AFFF_103347676 = (new BitSet(0));
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
                BitSet var6C160C3BA3A7CF38BB14DE2137217A60_1152083530 = (new BitSet(0));
            } //End block
            BitSet var5E364A6D610B86E453D8BFF8CA41AB83_1432100521 = (new BitSet(new long[] { result }));
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
        BitSet var1A02F800AF4EDE0E4659E3D1AB42BDF8_1909944768 = (new BitSet(newBits));
        return (BitSet)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.080 -0400", hash_original_method = "74386BE28B96B2445F889AFAD9F88AFA", hash_generated_method = "A67505DCD5ACCFA5D386F61F1E5E471C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(int index, boolean state) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(state);
        {
            set(index);
        } //End block
        {
            clear(index);
        } //End block
        // ---------- Original Method ----------
        //if (state) {
            //set(index);
        //} else {
            //clear(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.080 -0400", hash_original_method = "9EFB812AD22830556B4E1C754018229D", hash_generated_method = "C0E3B92B527BFE01D79E9CFB7F31B98F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(int fromIndex, int toIndex, boolean state) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(state);
        dsTaint.addTaint(toIndex);
        {
            set(fromIndex, toIndex);
        } //End block
        {
            clear(fromIndex, toIndex);
        } //End block
        // ---------- Original Method ----------
        //if (state) {
            //set(fromIndex, toIndex);
        //} else {
            //clear(fromIndex, toIndex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.080 -0400", hash_original_method = "8EA7A389047D1FB0971FCD5F7482B28A", hash_generated_method = "2309BC392D8D2DE8CDACCC9A041B29DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        Arrays.fill(bits, 0, longCount, 0L);
        longCount = 0;
        // ---------- Original Method ----------
        //Arrays.fill(bits, 0, longCount, 0L);
        //longCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.080 -0400", hash_original_method = "A26503DA159C46EB79782AEABE473F9D", hash_generated_method = "659DC0DCEDEFAFD6D00F326CE7B96B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.081 -0400", hash_original_method = "C97E5F07F0FAAF9942FBF154783DA0BB", hash_generated_method = "9D484AFFA7501EC01032D4CCA9DFCAA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.081 -0400", hash_original_method = "AF219115F487DC5279F51F56FAD6576B", hash_generated_method = "CEE556C0C6229A04BD28A2D3DF310985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flip(int fromIndex, int toIndex) {
        dsTaint.addTaint(fromIndex);
        dsTaint.addTaint(toIndex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.081 -0400", hash_original_method = "F6E914263E6B2AC21BC763D068DFC9F2", hash_generated_method = "267E3D30223410B713EB13AE3FB61976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean intersects(BitSet bs) {
        dsTaint.addTaint(bs.dsTaint);
        long[] bsBits;
        bsBits = bs.bits;
        int length;
        length = Math.min(this.longCount, bs.longCount);
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.082 -0400", hash_original_method = "83F89EEE7E2D54034E7D4AA2FF619E80", hash_generated_method = "F802D4A2E41D83E642021B60127E3FCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void and(BitSet bs) {
        dsTaint.addTaint(bs.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.082 -0400", hash_original_method = "6AEA541E74DD35C186C561500AE782A6", hash_generated_method = "867A2AAE8422FFF2962B693339B5566D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void andNot(BitSet bs) {
        dsTaint.addTaint(bs.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.082 -0400", hash_original_method = "BEA444ABE4A457608A295CEBFA17C48D", hash_generated_method = "429388B7D8E9427F80F29C456BEE1223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void or(BitSet bs) {
        dsTaint.addTaint(bs.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.082 -0400", hash_original_method = "E1F10E844B44799F9E6FF97093185186", hash_generated_method = "646C52C10F61CB1E7E6AA810591CCF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void xor(BitSet bs) {
        dsTaint.addTaint(bs.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.083 -0400", hash_original_method = "F33E07354BDEEAA3CDE5DA5EA8779C95", hash_generated_method = "AA050156A5F084BBF2D98F5637BC631A")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return bits.length * 64;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.083 -0400", hash_original_method = "6F3396C6D4F506441C95587742A4BBC3", hash_generated_method = "A03AA2F4673469E75D80368D38F911F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int length() {
        int var8DDE3DB99F8E017D590E08915D9DE94D_208327345 = (64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1])));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (longCount == 0) {
            //return 0;
        //}
        //return 64 * (longCount - 1) + (64 - Long.numberOfLeadingZeros(bits[longCount - 1]));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.083 -0400", hash_original_method = "A54CE267AEC3D3118A3C3A52C928D20A", hash_generated_method = "42B274CABB0B1473629351FC9D0CBAEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_1434191098 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.084 -0400", hash_original_method = "9B70742E631D0FF7E36300CA25C790B5", hash_generated_method = "808AE65B6D0FC7B839D7A49FCDB048CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextSetBit(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        int arrayIndex;
        arrayIndex = index / 64;
        long mask;
        mask = ALL_ONES << index;
        {
            int varD43158D00A08A92927E533B87144802C_2035421295 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex] & mask));
        } //End block
        int varC011A1606C203AD5B16168BBCBDCB4E1_1157929638 = (64 * arrayIndex + Long.numberOfTrailingZeros(bits[arrayIndex]));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.084 -0400", hash_original_method = "B6E36E70EF447F6B993A99CF808640C0", hash_generated_method = "E7DB0098B66093F4C1CE0AA4ECC28257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextClearBit(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        int arrayIndex;
        arrayIndex = index / 64;
        long mask;
        mask = ALL_ONES << index;
        {
            int var52BAF9B064911EB34A3604F2E011FF1B_1272581929 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex] & mask));
        } //End block
        {
            int var30B6C663C2B6D2AFA1DA9F62CE96F495_1986533420 = (size());
        } //End block
        int var88FEEF922745B43160A9B451ED95D469_603478897 = (64 * arrayIndex + Long.numberOfTrailingZeros(~bits[arrayIndex]));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.085 -0400", hash_original_method = "BDE3A7C277C6F771330A08D119C9767D", hash_generated_method = "4F0ACC756CC9E24137721AD590A463CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previousSetBit(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        {
            int i;
            i = index;
            {
                {
                    boolean var1225DD33B9BD6400B5B7107AF96C3D7B_944325029 = (get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.085 -0400", hash_original_method = "4D910DE065D256451DE439F25B5A6A08", hash_generated_method = "8A03984757DF34B94EB2AF09E4797623")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int previousClearBit(int index) {
        dsTaint.addTaint(index);
        checkIndex(index);
        {
            int i;
            i = index;
            {
                {
                    boolean varB73C00E6C21E0B274528170F6662ADEC_1833112231 = (!get(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.085 -0400", hash_original_method = "F34A10F6A3FF7AEAC6E09DDBD9741E2B", hash_generated_method = "B2FF89CDF6173525AB8C5F40326114F5")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (longCount == 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.085 -0400", hash_original_method = "5D3E782DB55862032A3B0CF1D30A4050", hash_generated_method = "6C9B01E296A1FD89E4AF7B92D7C55572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.086 -0400", hash_original_method = "87C10E36682237AA1B22F77F460E655A", hash_generated_method = "E4C1821B354D5B13D2D0D781083E4D94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long[] toLongArray() {
        long[] var6DF8F488F88B02867D1476840B5A40C1_2113418636 = (Arrays.copyOf(bits, longCount));
        long[] retVal = new long[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return Arrays.copyOf(bits, longCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.086 -0400", hash_original_method = "BCE80AE7073A25796C80405F8FB14636", hash_generated_method = "9F9F551B394BDF458CD174BD13B88E8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:31.086 -0400", hash_original_method = "928646C6EBB028EB87EF1072BE151B53", hash_generated_method = "E285299C583103942F731F9808B11873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(ois.dsTaint);
        ois.defaultReadObject();
        this.longCount = this.bits.length;
        shrinkSize();
        // ---------- Original Method ----------
        //ois.defaultReadObject();
        //this.longCount = this.bits.length;
        //shrinkSize();
    }

    
    private static final long serialVersionUID = 7997698588986878753L;
    private static final long ALL_ONES = ~0L;
}

