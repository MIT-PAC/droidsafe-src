package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalFormatWidthException extends IllegalFormatException {
    private int w;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.491 -0400", hash_original_method = "3E51700FF2AA6FFF2196939892FEBA05", hash_generated_method = "B35F9ACCAA4B07F9D4A185B5CB7AA502")
    @DSModeled(DSC.SAFE)
    public IllegalFormatWidthException(int w) {
        dsTaint.addTaint(w);
        // ---------- Original Method ----------
        //this.w = w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.491 -0400", hash_original_method = "E748E6398AAC681AB6A0D4D76FADF497", hash_generated_method = "11FB4699CB37A5A07B8B84B9E0489870")
    @DSModeled(DSC.SAFE)
    public int getWidth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.492 -0400", hash_original_method = "DC0A01255F859E7DE489CAE4D4B39EB6", hash_generated_method = "151CF6499472BA179B1E8CCCE200BC70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String var2038EB1A95E38A603B533B0B2D7487B5_890412124 = (Integer.toString(w));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(w);
    }

    
    private static final long serialVersionUID = 16660902L;
}

