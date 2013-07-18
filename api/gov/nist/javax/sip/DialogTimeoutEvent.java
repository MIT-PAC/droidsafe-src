package gov.nist.javax.sip;

// Droidsafe Imports
import java.util.EventObject;

import javax.sip.Dialog;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DialogTimeoutEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.333 -0400", hash_original_field = "3C2D99B5275A90DCEE818DED7CDA5744", hash_generated_field = "1B483DA67C4F6DE71E44B6CDA63B2927")

    private Dialog m_dialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.333 -0400", hash_original_field = "E931E918EB241942D130F1ECAC790EF1", hash_generated_field = "6C57BA42DC64512F5471CFD9846CD8F5")

    private Reason m_reason = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.333 -0400", hash_original_method = "3B858FD9FEE5DA9FA545213DB80889DF", hash_generated_method = "14471048012D6A06997B28DDCA617E16")
    public  DialogTimeoutEvent(Object source, Dialog dialog, Reason reason) {
        super(source);
        addTaint(source.getTaint());
        m_dialog = dialog;
        m_reason = reason;
        // ---------- Original Method ----------
        //m_dialog = dialog;
        //m_reason = reason;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.334 -0400", hash_original_method = "7F25FD43FBEFC286B46F28F64DA890F2", hash_generated_method = "43BF3B24F614FE51B5C5B9BE5FA705F0")
    public Dialog getDialog() {
Dialog varFB8739F13FF6A3985D561FE385D47DA0_2035449690 =         m_dialog;
        varFB8739F13FF6A3985D561FE385D47DA0_2035449690.addTaint(taint);
        return varFB8739F13FF6A3985D561FE385D47DA0_2035449690;
        // ---------- Original Method ----------
        //return m_dialog;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.334 -0400", hash_original_method = "212BB72EC2D919554993B4E6C5F238C1", hash_generated_method = "B432ACC07266A897C5A2A8BB61A0035E")
    public Reason getReason() {
Reason var062EAAC5E59BAAF23B89004CBF874C08_1697545837 =         m_reason;
        var062EAAC5E59BAAF23B89004CBF874C08_1697545837.addTaint(taint);
        return var062EAAC5E59BAAF23B89004CBF874C08_1697545837;
        // ---------- Original Method ----------
        //return m_reason;
    }

    
    public enum Reason {AckNotReceived, AckNotSent,ReInviteTimeout}

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.334 -0400", hash_original_field = "2FC38FF943D9F9D81C0DE2E10591D466", hash_generated_field = "4FAFB1344CC4F2D19A9E7C7572E679D4")

    private static final long serialVersionUID = -2514000059989311925L;
}

