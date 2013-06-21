package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Annotation {
    private Object value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.666 -0400", hash_original_method = "B1453DDFF141446D32AF844E0A6591E8", hash_generated_method = "AF74C15C5E0CEDA435387711DE6A5DCC")
    @DSModeled(DSC.SAFE)
    public Annotation(Object attribute) {
        dsTaint.addTaint(attribute.dsTaint);
        // ---------- Original Method ----------
        //value = attribute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.666 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "1BC31AFC0C9ADF065609ED88658AD7B4")
    @DSModeled(DSC.SAFE)
    public Object getValue() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.667 -0400", hash_original_method = "439CE19804D9002003DD6A4835AE4496", hash_generated_method = "53A73A82A68C2B936CF57495796D4C67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var9CC72E1CA438A4D46FC4EBABA3409994_213503812 = (getClass().getName() + "[value=" + value + ']');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[value=" + value + ']';
    }

    
}

