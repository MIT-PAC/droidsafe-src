package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;




public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.656 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "370CF36F1557D7355E48B1CB7D8F5E8D")
    protected  AbstractSet() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.657 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "F562AD9D6FCD2DAE6CC8714D342120D2")
    @Override
    public boolean equals(Object object) {
        return super.isEqualTo(object);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.658 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "4329886434D842FF3EFF045E72E15555")
    @Override
    public int hashCode() {
        int result = 0;
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
            Object next = it.next();
            result += next == null ? 0 : next.hashCode();
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_554553828 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019373771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019373771;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object next = it.next();
            //result += next == null ? 0 : next.hashCode();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.659 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "3340A7706F9D036C2E7AF8AB63DB5D19")
    @Override
    public boolean removeAll(Collection<?> collection) {
        return super.removeAll(collection);
    }
    
    /**
     * Overiding to help keeping it unique
     */
    @Override
    @DSModeled(DSC.SAFE)
    public boolean add(E object) {
       if (super.getIndexOf(object) != -1) 
           return super.add(object);
       return getTaintBoolean();
    }

    
}

