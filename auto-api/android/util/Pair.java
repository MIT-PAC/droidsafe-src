package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Pair<F, S> {
    public final F first;
    public final S second;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.649 -0400", hash_original_method = "2958ED2AC94D7F1EF56F55D0DF355D40", hash_generated_method = "548AEFF8C242ADF30D23014C0415DD4D")
    @DSModeled(DSC.SAFE)
    public Pair(F first, S second) {
        dsTaint.addTaint(second.dsTaint);
        dsTaint.addTaint(first.dsTaint);
        this.first = first;
        this.second = second;
        // ---------- Original Method ----------
        //this.first = first;
        //this.second = second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.649 -0400", hash_original_method = "A022862730CB324FED346DC42742A154", hash_generated_method = "EAB247FDC708C238F77CC086BD5FEA00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        final Pair<F, S> other;
        try 
        {
            other = (Pair<F, S>) o;
        } //End block
        catch (ClassCastException e)
        { return dsTaint.getTaintBoolean(); }
        boolean varDF09936121BF85C1B6748C3B6E7F9A70_1478943056 = (first.equals(other.first) && second.equals(other.second));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.649 -0400", hash_original_method = "7E2E6D9DD55E11668C618EBE33FB07A0", hash_generated_method = "5B555DD65BB23C8CDB2DDB69D4879EFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.649 -0400", hash_original_method = "C8700861007BBF9A3FCD00DFA8512080", hash_generated_method = "73C92DD32636619653CE245140CEB613")
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }

    
}


