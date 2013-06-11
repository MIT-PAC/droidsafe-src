package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class InterruptedException extends Exception {
    private static final long serialVersionUID = 6700697376100628473L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.283 -0400", hash_original_method = "276D0C061081F968E041F3504D86F3DC", hash_generated_method = "A0677C6C02C681984FC37366B048D559")
    @DSModeled(DSC.SAFE)
    public InterruptedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.285 -0400", hash_original_method = "47A24B4A9D41770C1E928AFF25C6693A", hash_generated_method = "25E1C2156FD01CEC4FA6468A876F26DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InterruptedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


