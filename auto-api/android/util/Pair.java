package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Pair<F, S> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.912 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "11C830DF6FB4A823C0844ADD83C166D2")

    public F first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.912 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "594420204FA1F806800D783DC05892CC")

    public S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.925 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "4E1A27179863EFB2E9934E958579E449")
    public  Pair(F first, S second) {
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.926 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "6366566092F13E997AB11A28B2679F66")
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_760327900 = (o == this);
        } //End collapsed parenthetic
        Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } //End block
        catch (ClassCastException e)
        { }
        boolean varDF09936121BF85C1B6748C3B6E7F9A70_1200571320 = (first.equals(other.first) && second.equals(other.second));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418870377 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418870377;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:46.927 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "ACDA411F17D5FD4CA8D6E758BB41A7F5")
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518222948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1518222948;
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

