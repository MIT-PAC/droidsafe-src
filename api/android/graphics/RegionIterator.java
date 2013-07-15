package android.graphics;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class RegionIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.324 -0400", hash_original_field = "7F5AA68CE18446242148BB8FE22648B9", hash_generated_field = "E1D7CD06343707E8A73E705F1CEC05A1")

    private int mNativeIter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.325 -0400", hash_original_method = "8221B1C759F7AE45DFBE3F2918777459", hash_generated_method = "79006011C2E682714FDDFBE507D6EEAE")
    public  RegionIterator(Region region) {
        mNativeIter = nativeConstructor(region.ni());
        // ---------- Original Method ----------
        //mNativeIter = nativeConstructor(region.ni());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.325 -0400", hash_original_method = "93D64F5EF378037039049B9C8BD2BE17", hash_generated_method = "97816931C080ACF20E9ED14C0322C1C6")
    public final boolean next(Rect r) {
        addTaint(r.getTaint());
    if(r == null)        
        {
            NullPointerException varFC8C8C558367CA16CA6B45324C278234_723104169 = new NullPointerException("The Rect must be provided");
            varFC8C8C558367CA16CA6B45324C278234_723104169.addTaint(taint);
            throw varFC8C8C558367CA16CA6B45324C278234_723104169;
        } //End block
        boolean var7FC3484CABDCF3A2E3955129CC26B05C_466469405 = (nativeNext(mNativeIter, r));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551458591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_551458591;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException("The Rect must be provided");
        //}
        //return nativeNext(mNativeIter, r);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:19.326 -0400", hash_original_method = "ED5A48D85C90AAF769D53509399DCB2D", hash_generated_method = "53E4248613FD2167FADC1CDA5F4F8DB7")
    protected void finalize() throws Throwable {
        nativeDestructor(mNativeIter);
        // ---------- Original Method ----------
        //nativeDestructor(mNativeIter);
    }

    
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

    
}

