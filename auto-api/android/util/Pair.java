package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Pair<F, S> {
    public F first;
    public S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.300 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "DEACB37F320C8E8D079429290581F4F5")
    @DSModeled(DSC.SAFE)
    public Pair(F first, S second) {
        dsTaint.addTaint(second.dsTaint);
        dsTaint.addTaint(first.dsTaint);
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.301 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "9AEE0E424F40DEFF6A229E91ED8184E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1556071232 = (o == this);
        } //End collapsed parenthetic
        Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } //End block
        catch (ClassCastException e)
        { }
        boolean varDF09936121BF85C1B6748C3B6E7F9A70_1247508812 = (first.equals(other.first) && second.equals(other.second));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.301 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "668945CF3090BFAD12B4D535A7C63B89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        return dsTaint.getTaintInt();
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

