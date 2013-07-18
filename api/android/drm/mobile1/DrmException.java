package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class DrmException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.337 -0400", hash_original_method = "DE31351B18888D140C40B16D35F58F0A", hash_generated_method = "BBDC82AA5C084132898FACE097BB6BF4")
    private  DrmException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.338 -0400", hash_original_method = "8E7A7AD1E370694486A4B27CB4185F34", hash_generated_method = "E708A30560EB3C2DDDB508C610106F04")
    public  DrmException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

