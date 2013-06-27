package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Stack<E> extends Vector<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.390 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    public  Stack() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.390 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "3256D76DD0C93B3F51C53FC38EA1DB32")
    public boolean empty() {
        boolean var01C4B8CA5F9B0005C1DAF7083100DB15_417155862 = (isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515715324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_515715324;
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.391 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "1FA63036E9964AC92E5AE6799748B00C")
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_620507407 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_620507407 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_620507407.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_620507407;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new EmptyStackException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.471 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "B9CC66AF9403B816F8947872DD0A4EC9")
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_748325195 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        int index;
        index = --elementCount;
        E obj;
        obj = (E) elementData[index];
        elementData[index] = null;
        varB4EAC82CA7396A68D541C85D26508E83_748325195 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_748325195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748325195;
        // ---------- Original Method ----------
        //if (elementCount == 0) {
            //throw new EmptyStackException();
        //}
        //final int index = --elementCount;
        //final E obj = (E) elementData[index];
        //elementData[index] = null;
        //modCount++;
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.472 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "7E2406C25F7FDB70714A3D2AF44B6E72")
    public E push(E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_790040891 = null; //Variable for return #1
        addElement(object);
        varB4EAC82CA7396A68D541C85D26508E83_790040891 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_790040891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_790040891;
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.476 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "6C569E7D3A09A4028862078A4576C910")
    public synchronized int search(Object o) {
        Object[] dumpArray;
        dumpArray = elementData;
        int size;
        size = elementCount;
        {
            {
                int i;
                i = size - 1;
                {
                    {
                        boolean var06A92C5E21E25F3BAB1286AD17EBE32A_1403497390 = (o.equals(dumpArray[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = size - 1;
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689709118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689709118;
        // ---------- Original Method ----------
        //final Object[] dumpArray = elementData;
        //final int size = elementCount;
        //if (o != null) {
            //for (int i = size - 1; i >= 0; i--) {
                //if (o.equals(dumpArray[i])) {
                    //return size - i;
                //}
            //}
        //} else {
            //for (int i = size - 1; i >= 0; i--) {
                //if (dumpArray[i] == null) {
                    //return size - i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.476 -0400", hash_original_field = "FB71933909E079B5587A84A46C0F4F2C", hash_generated_field = "CF025E7400F64B2F67C7750E15C5176B")

    private static long serialVersionUID = 1224463164541339165L;
}

