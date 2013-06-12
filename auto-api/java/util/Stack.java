package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Stack<E> extends Vector<E> {
    private static final long serialVersionUID = 1224463164541339165L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "B7A8D4F7258DC2E318AC32EB246BB471")
    @DSModeled(DSC.SAFE)
    public Stack() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "F0C21648DDF732226F1BB51711F8A71F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean empty() {
        boolean var01C4B8CA5F9B0005C1DAF7083100DB15_466294694 = (isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "E779835E077ED545D7DE1D1E56A16B6D")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new EmptyStackException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "53F559972B8F26C34BB5985B5C26E28F")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        if (DroidSafeAndroidRuntime.control) {
            throw new EmptyStackException();
        } //End block
        final int index;
        index = --elementCount;
        final E obj;
        obj = (E) elementData[index];
        elementData[index] = null;
        modCount++;
        return (E)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "278D005F1A060EAFC7FCC6E2A7E6433E")
    @DSModeled(DSC.SAFE)
    public E push(E object) {
        dsTaint.addTaint(object.dsTaint);
        addElement(object);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.173 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "1D304371CCE9C6969686854547733EC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int search(Object o) {
        dsTaint.addTaint(o.dsTaint);
        final Object[] dumpArray;
        dumpArray = elementData;
        final int size;
        size = elementCount;
        {
            {
                int i;
                i = size - 1;
                {
                    {
                        boolean var06A92C5E21E25F3BAB1286AD17EBE32A_942737710 = (o.equals(dumpArray[i]));
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
        return dsTaint.getTaintInt();
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

    
}


