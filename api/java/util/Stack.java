package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Stack<E> extends Vector<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.662 -0400", hash_original_method = "625E2B3812BBF73AC690F7D19F4288A9", hash_generated_method = "C931746C59237A3AA8E23B4112671D1E")
    public  Stack() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.663 -0400", hash_original_method = "3F97FF544B92201B8032D3FE94BC3E20", hash_generated_method = "33FEBD006D96C89DA461A1FF73D711F3")
    public boolean empty() {
        boolean var2FFE4DE88739498F1C07BDE62E7A2403_1848317059 = (isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105674157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105674157;
        // ---------- Original Method ----------
        //return isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.663 -0400", hash_original_method = "FF35E7A3F40F4BCE3A9B7A35AFC11586", hash_generated_method = "7C90504E75E5E499EA22E5ABCB11419B")
    @SuppressWarnings("unchecked")
    public synchronized E peek() {
        try 
        {
E var844EE4F2CEF6A403C269534F85F70712_1713897715 =             (E) elementData[elementCount - 1];
            var844EE4F2CEF6A403C269534F85F70712_1713897715.addTaint(taint);
            return var844EE4F2CEF6A403C269534F85F70712_1713897715;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            EmptyStackException varD2F310AAC69D0B44FED139E8A8976F2D_1740638549 = new EmptyStackException();
            varD2F310AAC69D0B44FED139E8A8976F2D_1740638549.addTaint(taint);
            throw varD2F310AAC69D0B44FED139E8A8976F2D_1740638549;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new EmptyStackException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.663 -0400", hash_original_method = "47AB8756F2D7E98B3A47AFF9902921A8", hash_generated_method = "38E61709EBEF3FDCF0B098CB249ECE4A")
    @SuppressWarnings("unchecked")
    public synchronized E pop() {
    if(elementCount == 0)        
        {
            EmptyStackException varD2F310AAC69D0B44FED139E8A8976F2D_741868900 = new EmptyStackException();
            varD2F310AAC69D0B44FED139E8A8976F2D_741868900.addTaint(taint);
            throw varD2F310AAC69D0B44FED139E8A8976F2D_741868900;
        } //End block
        final int index = --elementCount;
        final E obj = (E) elementData[index];
        elementData[index] = null;
        modCount++;
E var2FDE1120F80AA4E8798ECDBDB1C0E85C_50304203 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_50304203.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_50304203;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.663 -0400", hash_original_method = "FB7AFAD158F104C5EE0D062F7452B9D0", hash_generated_method = "DD5764A9FA7CB257C01D374F54243C21")
    public E push(E object) {
        addTaint(object.getTaint());
        addElement(object);
E var6F3B27511D98F0E852A24482F031265F_1170225929 =         object;
        var6F3B27511D98F0E852A24482F031265F_1170225929.addTaint(taint);
        return var6F3B27511D98F0E852A24482F031265F_1170225929;
        // ---------- Original Method ----------
        //addElement(object);
        //return object;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.664 -0400", hash_original_method = "F96799DE4EC4413EE3D35D731594FD43", hash_generated_method = "46E6BE37E53091826612E140AAD89B2C")
    public synchronized int search(Object o) {
        addTaint(o.getTaint());
        final Object[] dumpArray = elementData;
        final int size = elementCount;
    if(o != null)        
        {
for(int i = size - 1;i >= 0;i--)
            {
    if(o.equals(dumpArray[i]))                
                {
                    int var4B8BAF9108930ACDE4BF5A3B3612ED26_1808071214 = (size - i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127878853 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_127878853;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = size - 1;i >= 0;i--)
            {
    if(dumpArray[i] == null)                
                {
                    int var4B8BAF9108930ACDE4BF5A3B3612ED26_640310928 = (size - i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913053020 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913053020;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_753053405 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505828746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505828746;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:13.664 -0400", hash_original_field = "FB71933909E079B5587A84A46C0F4F2C", hash_generated_field = "B114A5411C4CC65AB8A6E3407B2F7E77")

    private static final long serialVersionUID = 1224463164541339165L;
}

