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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.576 -0400", hash_original_field = "3C2D99B5275A90DCEE818DED7CDA5744", hash_generated_field = "1B483DA67C4F6DE71E44B6CDA63B2927")

    private Dialog m_dialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.576 -0400", hash_original_field = "E931E918EB241942D130F1ECAC790EF1", hash_generated_field = "6C57BA42DC64512F5471CFD9846CD8F5")

    private Reason m_reason = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.577 -0400", hash_original_method = "3B858FD9FEE5DA9FA545213DB80889DF", hash_generated_method = "8AA4DB8EFFF02B3B73605C5DE8B4F2A8")
    public  DialogTimeoutEvent(Object source, Dialog dialog, Reason reason) {
        super(source);
        m_dialog = dialog;
        m_reason = reason;
        addTaint(source.getTaint());
        // ---------- Original Method ----------
        //m_dialog = dialog;
        //m_reason = reason;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.579 -0400", hash_original_method = "7F25FD43FBEFC286B46F28F64DA890F2", hash_generated_method = "147FF317DB3D1F8E691DBF5431A0D58B")
    public Dialog getDialog() {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1030786827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1030786827 = m_dialog;
        varB4EAC82CA7396A68D541C85D26508E83_1030786827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1030786827;
        // ---------- Original Method ----------
        //return m_dialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.594 -0400", hash_original_method = "212BB72EC2D919554993B4E6C5F238C1", hash_generated_method = "71434382CD0684DF94481DDB3E999456")
    public Reason getReason() {
        Reason varB4EAC82CA7396A68D541C85D26508E83_195290957 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_195290957 = m_reason;
        varB4EAC82CA7396A68D541C85D26508E83_195290957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_195290957;
        // ---------- Original Method ----------
        //return m_reason;
    }

    
    public enum Reason {AckNotReceived, AckNotSent,ReInviteTimeout}

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.595 -0400", hash_original_field = "2FC38FF943D9F9D81C0DE2E10591D466", hash_generated_field = "9D20EDF8A388C5F4A6080D0577E9DF2C")

    private static long serialVersionUID = -2514000059989311925L;
}

