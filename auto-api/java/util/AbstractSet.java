package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.304 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "A8736630CE265077CC61C66B2FF38B3E")
    @DSModeled(DSC.SAFE)
    protected AbstractSet() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.304 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "83CF89A4B0BCB8ED30F7017939FBD8F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Set<?> s;
            s = (Set<?>) object;
            try 
            {
                boolean var3CB8A00E2BE8AA7C9FFA8BA1183D5A88_2033655524 = (size() == s.size() && containsAll(s));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.304 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "1106FBE72F236A071DE0D49C3F728D82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 0;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_131151835 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.304 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "90CB2E82B1EE4A7A465938C64D12EABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean result;
        result = false;
        {
            boolean var61BE98A221B974C561DFA1C3C81630B9_200105315 = (size() <= collection.size());
            {
                Iterator<?> it;
                it = iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1939153735 = (it.hasNext());
                    {
                        {
                            boolean varD4980F0B0F9E3ED72ED3F79203D70B7F_574589687 = (collection.contains(it.next()));
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
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_745479253 = (it.hasNext());
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


