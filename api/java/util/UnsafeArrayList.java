package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.reflect.Array;

public class UnsafeArrayList<T> extends AbstractList<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.679 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "42DB228EAC7DA8545EB1D1E5B9915BD3")

    private Class<T> elementType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.680 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "87F498EE2D482CA5067EA4360008A092")

    private T[] array;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.680 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.681 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "F07679F0FB5C7D0607D217046F47FB25")
    public  UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        this.elementType = elementType;
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.683 -0400", hash_original_method = "B6C593001C4EDD88B75B904464FE5D63", hash_generated_method = "703522A6E20453B61CEB13690A4997A1")
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
        boolean varB326B5062B2F0E69046810717534CB09_1266660465 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465193413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465193413;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.684 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "40D98EA0615F2F0B20C0561C28BE4E38")
    public T[] array() {
T[] var1270D5B74B756F17D644A15D775499D9_153365462 =         array;
        var1270D5B74B756F17D644A15D775499D9_153365462.addTaint(taint);
        return var1270D5B74B756F17D644A15D775499D9_153365462;
        // ---------- Original Method ----------
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.685 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "A9974704F73CEA49F0CF514F31EB009D")
    public T get(int i) {
        addTaint(i);
T varF21683B7BF428041682AC146600794E7_1669991070 =         array[i];
        varF21683B7BF428041682AC146600794E7_1669991070.addTaint(taint);
        return varF21683B7BF428041682AC146600794E7_1669991070;
        // ---------- Original Method ----------
        //return array[i];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.685 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "E6774A30C8018F172FD33A40684E425D")
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_809394960 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411303269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411303269;
        // ---------- Original Method ----------
        //return size;
    }

    
}

