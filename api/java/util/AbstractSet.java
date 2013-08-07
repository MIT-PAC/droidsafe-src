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
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_912764069 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712191046 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712191046;
        } //End block
        if(object instanceof Set)        
        {
            Set<?> s = (Set<?>) object;
            try 
            {
                boolean varF7695CAF5A9CB346DC0805A64AAE8DF9_159810235 = (size() == s.size() && containsAll(s));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798261613 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798261613;
            } //End block
            catch (NullPointerException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_395958906 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333996458 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333996458;
            } //End block
            catch (ClassCastException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_646753934 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506475887 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_506475887;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1218782334 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691824157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691824157;
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
        addTaint(collection.getTaint());
        boolean result = false;
        if(size() <= collection.size())        
        {
            Iterator<?> it = iterator();
            while
(it.hasNext())            
            {
                if(collection.contains(it.next()))                
                {
                    it.remove();
                    result = true;
                } //End block
            } //End block
        } //End block
        else
        {
            Iterator<?> it = collection.iterator();
            while
(it.hasNext())            
            {
                result = remove(it.next()) || result;
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1642279308 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986545679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_986545679;
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

