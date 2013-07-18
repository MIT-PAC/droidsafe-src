package android.util;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class Pair<F, S> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.960 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "11C830DF6FB4A823C0844ADD83C166D2")

    public F first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.960 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "594420204FA1F806800D783DC05892CC")

    public S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.961 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "4E1A27179863EFB2E9934E958579E449")
    public  Pair(F first, S second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.961 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "4920A6136D5713DF097D78032C9A80FE")
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1729910025 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_82087322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_82087322;
        }
        if(!(o instanceof Pair))        
        {
        boolean var68934A3E9455FA72420237EB05902327_424580152 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080901841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080901841;
        }
        Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } //End block
        catch (ClassCastException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1969428500 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18513011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18513011;
        } //End block
        boolean var7204782B993AA31869DD0A2FEBF55CFC_2007343908 = (first.equals(other.first) && second.equals(other.second));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350862811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350862811;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof Pair)) return false;
        //final Pair<F, S> other;
        //try {
            //other = (Pair<F, S>) o;
        //} catch (ClassCastException e) {
            //return false;
        //}
        //return first.equals(other.first) && second.equals(other.second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.961 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "A4E3CBA2EAFA94266DDD28732AD5B477")
    public int hashCode() {
        int result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        int varB4A88417B3D0170D754C647C30B7216A_1541668423 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413782752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413782752;
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + first.hashCode();
        //result = 31 * result + second.hashCode();
        //return result;
    }

    
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    
}

