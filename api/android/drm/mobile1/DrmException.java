package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DrmException extends Exception {
    // TODO: add more specific DRM error codes.
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.109 -0500", hash_original_method = "DE31351B18888D140C40B16D35F58F0A", hash_generated_method = "99A95BAFBF43DE9F8A08126933237001")
    
private DrmException() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.112 -0500", hash_original_method = "8E7A7AD1E370694486A4B27CB4185F34", hash_generated_method = "3096C622627001639EFA03283A23642E")
    
public DrmException(String message) {
        super(message);
    }
    
}

