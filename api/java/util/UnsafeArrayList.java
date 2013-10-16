package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.reflect.Array;






public class UnsafeArrayList<T> extends AbstractList<T> {
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.681 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "F07679F0FB5C7D0607D217046F47FB25")
    public  UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        super.requestCapacity(initialCapacity);
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.684 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "40D98EA0615F2F0B20C0561C28BE4E38")
    public T[] array() {
        return (T[])super.toArray();
        // ---------- Original Method ----------
        //return array;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.685 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "A9974704F73CEA49F0CF514F31EB009D")
    public T get(int i) {
        addTaint(i);
        return super.getElementAt(i);
        // ---------- Original Method ----------
        //return array[i];
    }
}

