package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class RegionIterator {
    private int mNativeIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.807 -0400", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "DFAF8990AC4AD0280BD5349FFFFADAD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RegionIterator(Region region) {
        dsTaint.addTaint(region.dsTaint);
        mNativeIter = nativeConstructor(region.ni());
        // ---------- Original Method ----------
        //mNativeIter = nativeConstructor(region.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.807 -0400", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "92E5DC5BD159A556425574A29927760C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean next(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The Rect must be provided");
        } //End block
        boolean var553B837B0A2C8A33B5BEB135F0094AEE_1868773116 = (nativeNext(mNativeIter, r));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException("The Rect must be provided");
        //}
        //return nativeNext(mNativeIter, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:47.807 -0400", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "53E4248613FD2167FADC1CDA5F4F8DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

