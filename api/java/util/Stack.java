package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public class Stack<E> extends Vector<E> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.605 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    public  Stack() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.605 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "86C35B7C3A64A4D9AC5FCD2E9E672478")
    public boolean empty() {
        return isEmpty();
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.607 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "5B156394BA2F14B3BF8F5A0147788BFD")
    public E push(E object) {
        addTaint(object.getTaint());
        addElement(object);
        E var6F3B27511D98F0E852A24482F031265F_1455572488 =         object;
        var6F3B27511D98F0E852A24482F031265F_1455572488.addTaint(taint);
        return var6F3B27511D98F0E852A24482F031265F_1455572488;
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.607 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "B0B6D4D19115A554C7607E38136D7394")
    public synchronized int search(Object o) {
        addTaint(o.getTaint());
        return super.getLastIndexOf(o);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:11.608 -0400", hash_original_field = "FB71933909E079B5587A84A46C0F4F2C", hash_generated_field = "B114A5411C4CC65AB8A6E3407B2F7E77")

    private static final long serialVersionUID = 1224463164541339165L;
}

