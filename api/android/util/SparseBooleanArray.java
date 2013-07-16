package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.ArrayUtils;

public class SparseBooleanArray implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.288 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "61AC896AB2732D0B3CF0262159DAE2AD")

    private int[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.288 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "A2C25611A545F26A4C8405C4B8B577DD")

    private boolean[] mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.288 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "1ADF00AF1A5D84662F00519BAA6EB9C0")

    private int mSize;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.288 -0400", hash_original_method = "8D15548F78BDFDD752295E5C53E86F2F", hash_generated_method = "615FAF32D19F7E913E71139FAA2C7BA8")
    public  SparseBooleanArray() {
        this(10);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.289 -0400", hash_original_method = "A6A3EB653943D50370F97C74C514666D", hash_generated_method = "C46C350968A04AE428E20A28C4AC075E")
    public  SparseBooleanArray(int initialCapacity) {
        initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        mKeys = new int[initialCapacity];
        mValues = new boolean[initialCapacity];
        mSize = 0;
        // ---------- Original Method ----------
        //initialCapacity = ArrayUtils.idealIntArraySize(initialCapacity);
        //mKeys = new int[initialCapacity];
        //mValues = new boolean[initialCapacity];
        //mSize = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.290 -0400", hash_original_method = "F55567A3E3F95227EEE521C36E220AEC", hash_generated_method = "B718E5497CCE7D7295E3FA73A34F2871")
    @Override
    public SparseBooleanArray clone() {
        SparseBooleanArray clone = null;
        try 
        {
            clone = (SparseBooleanArray) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } //End block
        catch (CloneNotSupportedException cnse)
        {
        } //End block
SparseBooleanArray var3DE52045BFD3C1BF3742F994ED6139AD_154192975 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_154192975.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_154192975;
        // ---------- Original Method ----------
        //SparseBooleanArray clone = null;
        //try {
            //clone = (SparseBooleanArray) super.clone();
            //clone.mKeys = mKeys.clone();
            //clone.mValues = mValues.clone();
        //} catch (CloneNotSupportedException cnse) {
        //}
        //return clone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.290 -0400", hash_original_method = "1186B1642AA4116A541B7A05AB024C1E", hash_generated_method = "02BC1485E5FA53F92262184247AD851A")
    public boolean get(int key) {
        addTaint(key);
        boolean var7FDE2CA40EF19A2CA6A7C75ED483F94B_850515633 = (get(key, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047526435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047526435;
        // ---------- Original Method ----------
        //return get(key, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.291 -0400", hash_original_method = "421C2461F361B34EC4C9F82A0C8C35E5", hash_generated_method = "C13FAB2658673448D20967A7AE1ECF22")
    public boolean get(int key, boolean valueIfKeyNotFound) {
        addTaint(valueIfKeyNotFound);
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i < 0)        
        {
            boolean var993854ACC78701A1DDC4D2270D676BF7_1613681548 = (valueIfKeyNotFound);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092146231 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092146231;
        } //End block
        else
        {
            boolean var838C6F69E6EC457E9BF3DAB6E87CEB43_1834243530 = (mValues[i]);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073946130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073946130;
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i < 0) {
            //return valueIfKeyNotFound;
        //} else {
            //return mValues[i];
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.291 -0400", hash_original_method = "18B11B5534C55393394DE082DEBB04D1", hash_generated_method = "3C72FEDD304301BB9CA4A1B86CA40DCF")
    public void delete(int key) {
        addTaint(key);
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            mSize--;
        } //End block
        // ---------- Original Method ----------
        //int i = binarySearch(mKeys, 0, mSize, key);
        //if (i >= 0) {
            //System.arraycopy(mKeys, i + 1, mKeys, i, mSize - (i + 1));
            //System.arraycopy(mValues, i + 1, mValues, i, mSize - (i + 1));
            //mSize--;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.293 -0400", hash_original_method = "D051F7BD1248EC7F2DE7541E7D2B2D2A", hash_generated_method = "41704751587ECE283C4D0EA5C5304009")
    public void put(int key, boolean value) {
        int i = binarySearch(mKeys, 0, mSize, key);
    if(i >= 0)        
        {
            mValues[i] = value;
        } //End block
        else
        {
            i = ~i;
    if(mSize >= mKeys.length)            
            {
                int n = ArrayUtils.idealIntArraySize(mSize + 1);
                int[] nkeys = new int[n];
                boolean[] nvalues = new boolean[n];
                System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
                System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
                mKeys = nkeys;
                mValues = nvalues;
            } //End block
    if(mSize - i != 0)            
            {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            } //End block
            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.293 -0400", hash_original_method = "9550C69BAA91C5298BA75D226127D5FF", hash_generated_method = "E54F3BC80F5EB9B218FDE19DC18918FB")
    public int size() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_874187463 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890215872 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890215872;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.294 -0400", hash_original_method = "A3423B1919CBB5E5DDAE8E35A522AED2", hash_generated_method = "1B8E606B6B440B51BD5878A2112CD84F")
    public int keyAt(int index) {
        addTaint(index);
        int var3A009E05729778D41B3FA1B029E6698B_1089572792 = (mKeys[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500705977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500705977;
        // ---------- Original Method ----------
        //return mKeys[index];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.294 -0400", hash_original_method = "29A1BAF882E385B3C84A3B34D45CFC9E", hash_generated_method = "40762A12C5A2A9378201474C1A33D645")
    public boolean valueAt(int index) {
        addTaint(index);
        boolean var6FB1DFB969E1EF0A685B48F18F0AD9D2_600071758 = (mValues[index]);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790456303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790456303;
        // ---------- Original Method ----------
        //return mValues[index];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.295 -0400", hash_original_method = "AE2F6996EFD9E2EE7383268F20118C3E", hash_generated_method = "5680B29633BB59343AD3F755658A92B3")
    public int indexOfKey(int key) {
        addTaint(key);
        int var3C05684F465B8C390E8426D688C55DF4_468478207 = (binarySearch(mKeys, 0, mSize, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508701554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508701554;
        // ---------- Original Method ----------
        //return binarySearch(mKeys, 0, mSize, key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.296 -0400", hash_original_method = "7EFAF81E1CDED3A683A46526F2D63473", hash_generated_method = "1C62BDC67DCE40DF2EB44E07499C7131")
    public int indexOfValue(boolean value) {
        addTaint(value);
for(int i = 0;i < mSize;i++)
    if(mValues[i] == value)        
        {
        int var865C0C0B4AB0E063E5CAA3387C1A8741_72565966 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830522792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830522792;
        }
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1895095507 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662576984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_662576984;
        // ---------- Original Method ----------
        //for (int i = 0; i < mSize; i++)
            //if (mValues[i] == value)
                //return i;
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.297 -0400", hash_original_method = "78B640B3511AD026106C387D36058FFC", hash_generated_method = "2F55AFCAF967A1646FEBDAF6AC2C8455")
    public void clear() {
        mSize = 0;
        // ---------- Original Method ----------
        //mSize = 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.299 -0400", hash_original_method = "1A2B721538032798B5FC0916FF4BED9A", hash_generated_method = "9977A5B2E75382EB32270E2B6859C96E")
    public void append(int key, boolean value) {
    if(mSize != 0 && key <= mKeys[mSize - 1])        
        {
            put(key, value);
            return;
        } //End block
        int pos = mSize;
    if(pos >= mKeys.length)        
        {
            int n = ArrayUtils.idealIntArraySize(pos + 1);
            int[] nkeys = new int[n];
            boolean[] nvalues = new boolean[n];
            System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            mKeys = nkeys;
            mValues = nvalues;
        } //End block
        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
        // ---------- Original Method ----------
        //if (mSize != 0 && key <= mKeys[mSize - 1]) {
            //put(key, value);
            //return;
        //}
        //int pos = mSize;
        //if (pos >= mKeys.length) {
            //int n = ArrayUtils.idealIntArraySize(pos + 1);
            //int[] nkeys = new int[n];
            //boolean[] nvalues = new boolean[n];
            //System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
            //System.arraycopy(mValues, 0, nvalues, 0, mValues.length);
            //mKeys = nkeys;
            //mValues = nvalues;
        //}
        //mKeys[pos] = key;
        //mValues[pos] = value;
        //mSize = pos + 1;
    }

    
        @DSModeled(DSC.SAFE)
    private static int binarySearch(int[] a, int start, int len, int key) {
        int high = start + len, low = start - 1, guess;
        while (high - low > 1) {
            guess = (high + low) / 2;
            if (a[guess] < key)
                low = guess;
            else
                high = guess;
        }
        if (high == start + len)
            return ~(start + len);
        else if (a[high] == key)
            return high;
        else
            return ~high;
    }

    
}

