package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventObject;

public class DialogTerminatedEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.235 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "D9FAD0C1386FC50E3C837906841C2A70")

    private Dialog mDialog;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.235 -0400", hash_original_method = "29E943173FC1AF8A051089F6D7E9A828", hash_generated_method = "8A216BDC0B3DD2900C130B8363BD7220")
    public  DialogTerminatedEvent(Object source, Dialog dialog) {
        super(source);
        addTaint(source.getTaint());
        mDialog = dialog;
        // ---------- Original Method ----------
        //mDialog = dialog;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.236 -0400", hash_original_method = "BFDF5D83CE787BE21817622D7064532F", hash_generated_method = "B3D298B7398D37B7495D21C9E5AC5D1F")
    public Dialog getDialog() {
Dialog var91E8306796CF70F787962B1CE02ED969_1363394129 =         mDialog;
        var91E8306796CF70F787962B1CE02ED969_1363394129.addTaint(taint);
        return var91E8306796CF70F787962B1CE02ED969_1363394129;
        // ---------- Original Method ----------
        //return mDialog;
    }

    
}

