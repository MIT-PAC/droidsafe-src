package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Stack<E> extends Vector<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.932 -0500", hash_original_field = "7B45B91C3E17EC3DBBE0867E23E6214B", hash_generated_field = "B114A5411C4CC65AB8A6E3407B2F7E77")

    private static final long serialVersionUID = 1224463164541339165L;

    /**
     * Constructs a stack with the default size of {@code Vector}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.934 -0500", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "929D9277DEEF374CC6B17326832CDE90")
    
public Stack() {
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.605 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "86C35B7C3A64A4D9AC5FCD2E9E672478")
    public boolean empty() {
        return isEmpty();
        // ---------- Original Method ----------
        //return isEmpty();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.606 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "EAE9722EE9383D5958156EB7C1DF1FAB")
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        if (isEmpty()) {
            EmptyStackException varD2F310AAC69D0B44FED139E8A8976F2D_500805259 = new EmptyStackException();
            varD2F310AAC69D0B44FED139E8A8976F2D_500805259.addTaint(taint);
            throw varD2F310AAC69D0B44FED139E8A8976F2D_500805259; 
        }
        return getLastElement();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.606 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "86A6868C7D8AEBB6A709DB23A19CCF42")
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
        if (isEmpty()) {
            EmptyStackException varD2F310AAC69D0B44FED139E8A8976F2D_500805259 = new EmptyStackException();
            varD2F310AAC69D0B44FED139E8A8976F2D_500805259.addTaint(taint);
            throw varD2F310AAC69D0B44FED139E8A8976F2D_500805259; 
        }
        return removeLastElement();
    }

    /**
     * Pushes the specified object onto the top of the stack.
     *
     * @param object
     *            The object to be added on top of the stack.
     * @return the object argument.
     * @see #peek
     * @see #pop
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:23.944 -0500", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "F0F6FE2D7660908EBD9C2CBA85446EC1")
    
public E push(E object) {
        addElement(object);
        return object;
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.607 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "B0B6D4D19115A554C7607E38136D7394")
    public synchronized int search(Object o) {
        addTaint(o.getTaint());
        return super.getLastIndexOf(o);
    }
}

