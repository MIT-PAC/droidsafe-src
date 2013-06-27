package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Pair<F, S> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.216 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "11C830DF6FB4A823C0844ADD83C166D2")

    public F first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.216 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "594420204FA1F806800D783DC05892CC")

    public S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.217 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "4E1A27179863EFB2E9934E958579E449")
    public  Pair(F first, S second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.229 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "FFB392308DEB922A3680B66B76DBC658")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1757394745 = (o == this);
        } //End collapsed parenthetic
        Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } //End block
        catch (ClassCastException e)
        { }
        boolean varDF09936121BF85C1B6748C3B6E7F9A70_778922789 = (first.equals(other.first) && second.equals(other.second));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484774991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484774991;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:45.230 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "0ED2D13C723177A855726C91E0A6DAB7")
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542175796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1542175796;
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

