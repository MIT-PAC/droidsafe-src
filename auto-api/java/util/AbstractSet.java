package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.332 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "370CF36F1557D7355E48B1CB7D8F5E8D")
    protected  AbstractSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.333 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "8AA8DA318A47B35661EC8C6F8BEC3AC1")
    @Override
    public boolean equals(Object object) {
        {
            Set<?> s;
            s = (Set<?>) object;
            try 
            {
                boolean var3CB8A00E2BE8AA7C9FFA8BA1183D5A88_1180615544 = (size() == s.size() && containsAll(s));
            } //End block
            catch (NullPointerException ignored)
            { }
            catch (ClassCastException ignored)
            { }
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475664401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475664401;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.334 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "8C3EF0923470F32807A2C8C9E6B9A63F")
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_672115411 = (it.hasNext());
            {
                Object next;
                next = it.next();
                result += next == null ? 0 : next.hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797645535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797645535;
        // ---------- Original Method ----------
        //int result = 0;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object next = it.next();
            //result += next == null ? 0 : next.hashCode();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.334 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "061E6E7738478EE8B3D92AEFB6A3CAD4")
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result;
        result = false;
        {
            boolean var61BE98A221B974C561DFA1C3C81630B9_2006346682 = (size() <= collection.size());
            {
                Iterator<?> it;
                it = iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1731229164 = (it.hasNext());
                    {
                        {
                            boolean varD4980F0B0F9E3ED72ED3F79203D70B7F_325796571 = (collection.contains(it.next()));
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
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_905641073 = (it.hasNext());
                    {
                        result = remove(it.next()) || result;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946639315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946639315;
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

