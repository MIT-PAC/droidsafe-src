package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.600 -0400", hash_original_method = "422EAA7182FF45B88C4EE6C211DE4EBB", hash_generated_method = "370CF36F1557D7355E48B1CB7D8F5E8D")
    protected  AbstractSet() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.600 -0400", hash_original_method = "8965F512606A1DFD0C1662786439C503", hash_generated_method = "034B7973FA87D9C80674A91DFA4C09FD")
    @Override
    public boolean equals(Object object) {
        {
            Set<?> s = (Set<?>) object;
            try 
            {
                boolean var3CB8A00E2BE8AA7C9FFA8BA1183D5A88_1562582777 = (size() == s.size() && containsAll(s));
            } 
            catch (NullPointerException ignored)
            { }
            catch (ClassCastException ignored)
            { }
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845888880 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845888880;
        
        
            
        
        
            
            
                
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.601 -0400", hash_original_method = "CFEA0B963C36C0E6CA161741555B0EDA", hash_generated_method = "8F7873DD5C48E834906FB87AD96C7C6A")
    @Override
    public int hashCode() {
        int result = 0;
        Iterator<?> it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1285324476 = (it.hasNext());
            {
                Object next = it.next();
                result += next == null ? 0 : next.hashCode();
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644821748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644821748;
        
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.601 -0400", hash_original_method = "6793D4CBA252A26447B19640912FAD83", hash_generated_method = "C9128D311664763BB6EF17E6B45FE647")
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean result = false;
        {
            boolean var61BE98A221B974C561DFA1C3C81630B9_864205639 = (size() <= collection.size());
            {
                Iterator<?> it = iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_633520455 = (it.hasNext());
                    {
                        {
                            boolean varD4980F0B0F9E3ED72ED3F79203D70B7F_1211292950 = (collection.contains(it.next()));
                            {
                                it.remove();
                                result = true;
                            } 
                        } 
                    } 
                } 
            } 
            {
                Iterator<?> it = collection.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_615107386 = (it.hasNext());
                    {
                        result = remove(it.next()) || result;
                    } 
                } 
            } 
        } 
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73461212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_73461212;
        
        
        
            
            
                
                    
                    
                
            
        
            
            
                
            
        
        
    }

    
}

