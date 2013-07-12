package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Array;

public class UnsafeArrayList<T> extends AbstractList<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.828 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "42DB228EAC7DA8545EB1D1E5B9915BD3")

    private Class<T> elementType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.828 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "87F498EE2D482CA5067EA4360008A092")

    private T[] array;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.828 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.829 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "F07679F0FB5C7D0607D217046F47FB25")
    public  UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        this.elementType = elementType;
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.829 -0400", hash_original_method = "B6C593001C4EDD88B75B904464FE5D63", hash_generated_method = "CB67701AF325264B5E67360510A4FEAF")
    @Override
    public boolean add(T element) {
    if(size == array.length)        
        {
            T[] newArray = (T[]) Array.newInstance(elementType, size * 2);
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        } //End block
        array[size++] = element;
        ++modCount;
        boolean varB326B5062B2F0E69046810717534CB09_675212374 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291987912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291987912;
        // ---------- Original Method ----------
        //if (size == array.length) {
            //T[] newArray = (T[]) Array.newInstance(elementType, size * 2);
            //System.arraycopy(array, 0, newArray, 0, size);
            //array = newArray;
        //}
        //array[size++] = element;
        //++modCount;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.830 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "C0CC67D35C3A3B5B90067243EC76244D")
    public T[] array() {
T[] var1270D5B74B756F17D644A15D775499D9_830415236 =         array;
        var1270D5B74B756F17D644A15D775499D9_830415236.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_830415236;
        // ---------- Original Method ----------
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.830 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "E54DC9E4E1A6A8CD4D6DD349D43F0D5E")
    public T get(int i) {
        addTaint(i);
T varF21683B7BF428041682AC146600794E7_295478551 =         array[i];
        varF21683B7BF428041682AC146600794E7_295478551.addTaint(taint);
        return varF21683B7BF428041682AC146600794E7_295478551;
        // ---------- Original Method ----------
        //return array[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.830 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "97EFD0817708B083C9CA6C0BB60BCDD5")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1213634774 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991847385 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1991847385;
        // ---------- Original Method ----------
        //return size;
    }

    
}

