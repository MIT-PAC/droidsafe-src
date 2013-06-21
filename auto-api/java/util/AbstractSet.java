package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.871 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "370CF36F1557D7355E48B1CB7D8F5E8D")
    @DSModeled(DSC.SAFE)
    protected AbstractSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.872 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "5AC66ED4780724B3FEBB441F68784D45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Set<?> s;
            s = (Set<?>) object;
            try 
            {
                boolean var3CB8A00E2BE8AA7C9FFA8BA1183D5A88_1002379678 = (size() == s.size() && containsAll(s));
            } //End block
            catch (NullPointerException ignored)
            { }
            catch (ClassCastException ignored)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof Set) {
            //Set<?> s = (Set<?>) object;
            //try {
                //return size() == s.size() && containsAll(s);
            //} catch (NullPointerException ignored) {
                //return false;
            //} catch (ClassCastException ignored) {
                //return false;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.872 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "F4EAB0367AD94AFBBE83B7901E3E347C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1089953546 = (it.hasNext());
            {
                Object next;
                next = it.next();
                result += next == null ? 0 : next.hashCode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object next = it.next();
            //result += next == null ? 0 : next.hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.872 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "EAC6B334A0270E68D17699C8D893B9F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        {
            boolean var61BE98A221B974C561DFA1C3C81630B9_1031315976 = (size() <= collection.size());
            {
                Iterator<?> it;
                it = iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1334871005 = (it.hasNext());
                    {
                        {
                            boolean varD4980F0B0F9E3ED72ED3F79203D70B7F_945331999 = (collection.contains(it.next()));
                            {
                                it.remove();
                                result = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                Iterator<?> it;
                it = collection.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_267169513 = (it.hasNext());
                    {
                        result = remove(it.next()) || result;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //if (size() <= collection.size()) {
            //Iterator<?> it = iterator();
            //while (it.hasNext()) {
                //if (collection.contains(it.next())) {
                    //it.remove();
                    //result = true;
                //}
            //}
        //} else {
            //Iterator<?> it = collection.iterator();
            //while (it.hasNext()) {
                //result = remove(it.next()) || result;
            //}
        //}
        //return result;
    }

    
}

