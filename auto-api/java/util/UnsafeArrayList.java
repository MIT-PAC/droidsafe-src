package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.reflect.Array;

public class UnsafeArrayList<T> extends AbstractList<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.456 -0400", hash_original_field = "481A5F16B24D461E31D85ABA607238B8", hash_generated_field = "42DB228EAC7DA8545EB1D1E5B9915BD3")

    private Class<T> elementType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.456 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "87F498EE2D482CA5067EA4360008A092")

    private T[] array;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.456 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.457 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "F07679F0FB5C7D0607D217046F47FB25")
    public  UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        this.elementType = elementType;
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.470 -0400", hash_original_method = "B6C593001C4EDD88B75B904464FE5D63", hash_generated_method = "A733179FA74A69459340258DADDF0BAF")
    @Override
    public boolean add(T element) {
        {
            T[] newArray;
            newArray = (T[]) Array.newInstance(elementType, size * 2);
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        } //End block
        array[size++] = element;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657349915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657349915;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.472 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "8E5FC38D3F4F21213ABD445EDB0D3A8C")
    public T[] array() {
        T[] varB4EAC82CA7396A68D541C85D26508E83_993204748 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_993204748 = array;
        varB4EAC82CA7396A68D541C85D26508E83_993204748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_993204748;
        // ---------- Original Method ----------
        //return array;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.474 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "7152D83D3EF1122710749F8E0F170950")
    public T get(int i) {
        T varB4EAC82CA7396A68D541C85D26508E83_2080251582 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2080251582 = array[i];
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_2080251582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2080251582;
        // ---------- Original Method ----------
        //return array[i];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.480 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "66771A13935FBD4E75D20B7D50E1D0A5")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429667477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429667477;
        // ---------- Original Method ----------
        //return size;
    }

    
}

