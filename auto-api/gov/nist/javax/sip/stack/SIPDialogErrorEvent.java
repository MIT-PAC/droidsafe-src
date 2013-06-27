package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventObject;

public class SIPDialogErrorEvent extends EventObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.047 -0400", hash_original_field = "90EF706EA3C5F1087D72CE0C7E7231EE", hash_generated_field = "CA6E243727AC764060BF1536B58E325A")

    private int errorID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.047 -0400", hash_original_method = "63B6C69AA01911B678EB33AE8A4167CE", hash_generated_method = "DC238B59F72F8469C91CECA766531A29")
      SIPDialogErrorEvent(
        SIPDialog sourceDialog,
        int dialogErrorID) {
        super(sourceDialog);
        errorID = dialogErrorID;
        addTaint(sourceDialog.getTaint());
        // ---------- Original Method ----------
        //errorID = dialogErrorID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.048 -0400", hash_original_method = "0519EBFB6DA70B425C38921D23DA7A64", hash_generated_method = "802C97A941F8E063E3A3C2DE3F22924F")
    public int getErrorID() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411465922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411465922;
        // ---------- Original Method ----------
        //return errorID;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.048 -0400", hash_original_field = "CDE8D05AE558006D8C6D89A0F6682BEA", hash_generated_field = "1114A70B449A938175EAD82492CF8BE8")

    public static final int DIALOG_ACK_NOT_RECEIVED_TIMEOUT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.048 -0400", hash_original_field = "3658A2E66C77840BBFED818960D10473", hash_generated_field = "A8906351F5DF1D3C4CD5261710E4A09F")

    public static final int DIALOG_ACK_NOT_SENT_TIMEOUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:35.048 -0400", hash_original_field = "A113C71A01FE4CEAA060C2EFB14ACA14", hash_generated_field = "7B2972FA2C4C6425C27AD10065E88AB6")

    public static final int DIALOG_REINVITE_TIMEOUT = 3;
}

