package android.graphics;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation


public class RegionIterator {
    private final int mNativeIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "BDF69DE9EABA62FDB0618B5FBDEF3F0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RegionIterator(Region region) {
        dsTaint.addTaint(region.dsTaint);
        mNativeIter = nativeConstructor(region.ni());
        // ---------- Original Method ----------
        //mNativeIter = nativeConstructor(region.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "6588DD312B08374FF919843D77C84E30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean next(Rect r) {
        dsTaint.addTaint(r.dsTaint);
        if (DroidSafeAndroidRuntime.control)
        {
            throw new NullPointerException("The Rect must be provided");
        } //End block
        boolean var553B837B0A2C8A33B5BEB135F0094AEE_2143877144 = (nativeNext(mNativeIter, r));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException("The Rect must be provided");
        //}
        //return nativeNext(mNativeIter, r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "6B090B1C401462F19FA270F8280D0144")
    @DSModeled(DSC.SAFE)
    protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
        // ---------- Original Method ----------
        //nativeDestructor(mNativeIter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "374F0FDA6E44206EA6BEC38C6D5993CD", hash_generated_method = "4C03CFC3661CF9D305F0CF1DAB1671CD")
    private static int nativeConstructor(int native_region) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "3A8EBC44CA812E88AF7F8D162E2E9942", hash_generated_method = "9E5497174D4F1A79D030EF9DEB363104")
    private static void nativeDestructor(int native_iter) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.466 -0400", hash_original_method = "D5EE9EFAB7181DFECE80A89AC7AC9705", hash_generated_method = "65638F52B687C2C1D1D4781F720C480A")
    private static boolean nativeNext(int native_iter, Rect r) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
}


