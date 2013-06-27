package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class RegionIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.936 -0400", hash_original_field = "7F5AA68CE18446242148BB8FE22648B9", hash_generated_field = "E1D7CD06343707E8A73E705F1CEC05A1")

    private int mNativeIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.937 -0400", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "79006011C2E682714FDDFBE507D6EEAE")
    public  RegionIterator(Region region) {
        mNativeIter = nativeConstructor(region.ni());
        // ---------- Original Method ----------
        //mNativeIter = nativeConstructor(region.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.937 -0400", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "4617C972E5C7696FADC93DCC44B18723")
    public final boolean next(Rect r) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The Rect must be provided");
        } //End block
        boolean var553B837B0A2C8A33B5BEB135F0094AEE_796155283 = (nativeNext(mNativeIter, r));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192391878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192391878;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException("The Rect must be provided");
        //}
        //return nativeNext(mNativeIter, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:12.938 -0400", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "53E4248613FD2167FADC1CDA5F4F8DB7")
    protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
        // ---------- Original Method ----------
        //nativeDestructor(mNativeIter);
    }

    
        private static int nativeConstructor(int native_region) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDestructor(int native_iter) {
    }

    
        private static boolean nativeNext(int native_iter, Rect r) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
}

