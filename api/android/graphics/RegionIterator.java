package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




import droidsafe.helpers.DSUtils;

public class RegionIterator {

    
    @DSModeled(DSC.SAFE)
    private static int nativeConstructor(int native_region) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDestructor(int native_iter) {
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeNext(int native_iter, Rect r) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:07.013 -0500", hash_original_field = "3718B7AC5E828F6E59131B9828863051", hash_generated_field = "E1D7CD06343707E8A73E705F1CEC05A1")

    
    private  int mNativeIter;

    /**
     * Construct an iterator for all of the rectangles in a region. This
     * effectively makes a private copy of the region, so any subsequent edits
     * to region will not affect the iterator.
     *
     * @param region the region that will be iterated
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.994 -0500", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "32463E99A7706C050DBDE46DC7BF00CC")
    
public RegionIterator(Region region) {
        mNativeIter = nativeConstructor(region.ni());
    }

    /**
     * Return the next rectangle in the region. If there are no more rectangles
     * this returns false and r is unchanged. If there is at least one more,
     * this returns true and r is set to that rectangle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.996 -0500", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "242BD38E13C711DF2EE3EE4F074FB23D")
    
public final boolean next(Rect r) {
        if (r == null) {
            throw new NullPointerException("The Rect must be provided");
        }
        return nativeNext(mNativeIter, r);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:06.999 -0500", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "A408DD68206E064D4D1E1D3E0B3A0A3D")
    
protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
    }

    
}

