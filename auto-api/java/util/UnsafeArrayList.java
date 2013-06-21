package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public class UnsafeArrayList<T> extends AbstractList<T> {
    private Class<T> elementType;
    private T[] array;
    private int size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.147 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "5B1C9A3CB6499DCBB9C0A883A3655DC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(elementType.dsTaint);
        this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.147 -0400", hash_original_method = "B6C593001C4EDD88B75B904464FE5D63", hash_generated_method = "B8E0031FBB75A5568868A563C55E1904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(T element) {
        dsTaint.addTaint(element.dsTaint);
        {
            T[] newArray;
            newArray = (T[]) Array.newInstance(elementType, size * 2);
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        } //End block
        array[size++] = element;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.147 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "379446B88D880E00B60C7CE775479577")
    @DSModeled(DSC.SAFE)
    public T[] array() {
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.148 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "B6347D55F36096CEE3920CAC0BB89594")
    @DSModeled(DSC.SAFE)
    public T get(int i) {
        dsTaint.addTaint(i);
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return array[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.148 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5952D8F6ECECE9C90DA6440092EF19A0")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
}

