package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Stack<E> extends Vector<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.715 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    public  Stack() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.715 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "CA3955F9E71C3F10ADB5BB0D1D95069A")
    public boolean empty() {
        boolean var01C4B8CA5F9B0005C1DAF7083100DB15_455045770 = (isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1569364952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1569364952;
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.716 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "19F6D030A853F23D81DEFAE375E43FDC")
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1610784146 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1610784146 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1610784146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610784146;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new EmptyStackException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.717 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "669CCFE2B3210EEC39494A80530C470C")
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_138067704 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        final int index = --elementCount;
        final E obj = (E) elementData[index];
        elementData[index] = null;
        varB4EAC82CA7396A68D541C85D26508E83_138067704 = obj;
        varB4EAC82CA7396A68D541C85D26508E83_138067704.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138067704;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.718 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "0F00252253253452F58A76050CB54BCD")
    public E push(E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_2096824499 = null; //Variable for return #1
        addElement(object);
        varB4EAC82CA7396A68D541C85D26508E83_2096824499 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2096824499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2096824499;
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.719 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "EEAD9122B2361862F4E3D216C2A4823D")
    public synchronized int search(Object o) {
        final Object[] dumpArray = elementData;
        final int size = elementCount;
        {
            {
                int i = size - 1;
                {
                    {
                        boolean var06A92C5E21E25F3BAB1286AD17EBE32A_496941288 = (o.equals(dumpArray[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i = size - 1;
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589329630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_589329630;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:11.719 -0400", hash_original_field = "FB71933909E079B5587A84A46C0F4F2C", hash_generated_field = "B114A5411C4CC65AB8A6E3407B2F7E77")

    private static final long serialVersionUID = 1224463164541339165L;
}

