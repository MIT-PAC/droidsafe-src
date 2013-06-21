package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Stack<E> extends Vector<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.669 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    @DSModeled(DSC.SAFE)
    public Stack() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.670 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "1515E1C604C11272B26F173A83A7BFE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean empty() {
        boolean var01C4B8CA5F9B0005C1DAF7083100DB15_427725347 = (isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.670 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "BB1848B70AC98B4515BA38C55BCBAC63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.670 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "3A7900C4E358BD5D57B346D876311A13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        int index;
        index = --elementCount;
        E obj;
        obj = (E) elementData[index];
        elementData[index] = null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.670 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "E9378772B16FACE2999E83B2FEF00522")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E push(E object) {
        dsTaint.addTaint(object.dsTaint);
        addElement(object);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.671 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "8EBB7D83C405C62E566994FCBB7D513C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int search(Object o) {
        dsTaint.addTaint(o.dsTaint);
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
                        boolean var06A92C5E21E25F3BAB1286AD17EBE32A_1687564101 = (o.equals(dumpArray[i]));
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

    
    private static final long serialVersionUID = 1224463164541339165L;
}

