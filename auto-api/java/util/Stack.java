package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Stack<E> extends Vector<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.427 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    public  Stack() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.427 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "FB65FB4A0A31FB321273BEC21974D921")
    public boolean empty() {
        boolean var01C4B8CA5F9B0005C1DAF7083100DB15_2024938704 = (isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443717629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443717629;
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.432 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "C64058D498EA0152B0D3B4FE8C2F4295")
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_2119896777 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2119896777 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2119896777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119896777;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new EmptyStackException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.433 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "058CEC79174421009667D6FBE7081667")
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_1486459800 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        int index;
        index = --elementCount;
        E obj;
        obj = (E) elementData[index];
        elementData[index] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1486459800 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_1486459800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486459800;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.441 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "6C1F9F05590D921565355E66356FA6D1")
    public E push(E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_1532028223 = null; //Variable for return #1
        addElement(object);
        varB4EAC82CA7396A68D541C85D26508E83_1532028223 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1532028223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532028223;
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.441 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "4B5B956250F895689F1181A92537037A")
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
                        boolean var06A92C5E21E25F3BAB1286AD17EBE32A_1574760474 = (o.equals(dumpArray[i]));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619639258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619639258;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:53.441 -0400", hash_original_field = "FB71933909E079B5587A84A46C0F4F2C", hash_generated_field = "CF025E7400F64B2F67C7750E15C5176B")

    private static long serialVersionUID = 1224463164541339165L;
}

