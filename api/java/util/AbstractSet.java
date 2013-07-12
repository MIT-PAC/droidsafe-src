package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.289 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "370CF36F1557D7355E48B1CB7D8F5E8D")
    protected  AbstractSet() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.290 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "24BB3F415C56C73FEEF98BA9C84212B6")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_533869892 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102534499 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_102534499;
        } 
    if(object instanceof Set)        
        {
            Set<?> s = (Set<?>) object;
            try 
            {
                boolean varF7695CAF5A9CB346DC0805A64AAE8DF9_668780601 = (size() == s.size() && containsAll(s));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808062794 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_808062794;
            } 
            catch (NullPointerException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_2100470006 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859625984 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859625984;
            } 
            catch (ClassCastException ignored)
            {
                boolean var68934A3E9455FA72420237EB05902327_1282571864 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65609883 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_65609883;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_231600849 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112277057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112277057;
        
        
            
        
        
            
            
                
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.291 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "A932B71A4D0C0B01614858C5FB3CC3CB")
    @Override
    public int hashCode() {
        int result = 0;
        Iterator<?> it = iterator();
        while
(it.hasNext())        
        {
            Object next = it.next();
            result += next == null ? 0 : next.hashCode();
        } 
        int varB4A88417B3D0170D754C647C30B7216A_1999902209 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416542900 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1416542900;
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:55.292 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "E45562D93476DB3DBE95CDC9E49D1AE1")
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
                } 
            } 
        } 
        else
        {
            Iterator<?> it = collection.iterator();
            while
(it.hasNext())            
            {
                result = remove(it.next()) || result;
            } 
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_2046825607 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227396963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227396963;
        
        
        
            
            
                
                    
                    
                
            
        
            
            
                
            
        
        
    }

    
}

