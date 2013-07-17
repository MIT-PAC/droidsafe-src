package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AbstractMethodError extends IncompatibleClassChangeError {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.838 -0400", hash_original_method = "4F4F671C3B04BA3CBFE40382F9999EB7", hash_generated_method = "3CD8DA6655C9083356BB3F4CDAD51E26")
    public  AbstractMethodError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.839 -0400", hash_original_method = "08FCF39731DB3AF551E2B6A840F345BE", hash_generated_method = "645F6516657B311DD7CBBE44A9CA73E1")
    public  AbstractMethodError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.839 -0400", hash_original_field = "B141EA7B0EA17A68E8A276FAE396D6F0", hash_generated_field = "B59137EDC0BBD16080EB2D2BEDE487F9")

    private static final long serialVersionUID = -1654391082989018462L;
}

