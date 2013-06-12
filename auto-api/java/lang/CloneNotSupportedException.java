package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class CloneNotSupportedException extends Exception {
    private static final long serialVersionUID = 5195511250079656443L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.364 -0400", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "AFF926411CD6A3826CAFFE94D1A6469B")
    @DSModeled(DSC.SAFE)
    public CloneNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:45.372 -0400", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "1E9E8CC87B3CA91EF22B4F58FE65B0AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


