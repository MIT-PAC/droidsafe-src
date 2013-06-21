package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;
import javax.sip.Dialog;

public class DialogTimeoutEvent extends EventObject {
    private Dialog m_dialog = null;
    private Reason m_reason = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.088 -0400", hash_original_method = "3B858FD9FEE5DA9FA545213DB80889DF", hash_generated_method = "65CBCA06D4DEAF2D20B21BD9CE384E9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DialogTimeoutEvent(Object source, Dialog dialog, Reason reason) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(reason.dsTaint);
        dsTaint.addTaint(dialog.dsTaint);
        // ---------- Original Method ----------
        //m_dialog = dialog;
        //m_reason = reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.088 -0400", hash_original_method = "7F25FD43FBEFC286B46F28F64DA890F2", hash_generated_method = "BB42B701CA5F0CED0BA615659DCFC91B")
    @DSModeled(DSC.SAFE)
    public Dialog getDialog() {
        return (Dialog)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return m_dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.088 -0400", hash_original_method = "212BB72EC2D919554993B4E6C5F238C1", hash_generated_method = "A3DBC2E6A27D0544C77D30EEE98FAB4A")
    @DSModeled(DSC.SAFE)
    public Reason getReason() {
        return (Reason)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return m_reason;
    }

    
    public enum Reason {AckNotReceived, AckNotSent,ReInviteTimeout}

    
    private static final long serialVersionUID = -2514000059989311925L;
}

