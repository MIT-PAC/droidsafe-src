package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class DialogTerminatedEvent extends EventObject {
    private Dialog mDialog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.230 -0400", hash_original_method = "29E943173FC1AF8A051089F6D7E9A828", hash_generated_method = "0299141D03D3963417388B0C91AB61CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DialogTerminatedEvent(Object source, Dialog dialog) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        // ---------- Original Method ----------
        //mDialog = dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.231 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "4F073E538789CB30D5A56AE8F87B31D1")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDialog;
    }

    
}

