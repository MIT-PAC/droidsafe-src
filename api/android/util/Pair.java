package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class Pair<F, S> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.104 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "11C830DF6FB4A823C0844ADD83C166D2")

    public F first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.104 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "594420204FA1F806800D783DC05892CC")

    public S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.104 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "4E1A27179863EFB2E9934E958579E449")
    public  Pair(F first, S second) {
        this.first = first;
        this.second = second;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.105 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "68C91D78DC87AC6542B5B905C341D688")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1628054546 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872896524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872896524;
        }
    if(!(o instanceof Pair))        
        {
        boolean var68934A3E9455FA72420237EB05902327_365606567 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940646650 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940646650;
        }
        Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } 
        catch (ClassCastException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_514816225 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177820458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177820458;
        } 
        boolean var7204782B993AA31869DD0A2FEBF55CFC_1936170401 = (first.equals(other.first) && second.equals(other.second));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903793828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903793828;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.106 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "A8E61D8670B4712B8BA22C357C192949")
    public int hashCode() {
        int result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_824549214 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677820613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1677820613;
        
        
        
        
        
    }

    
        public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    
}

