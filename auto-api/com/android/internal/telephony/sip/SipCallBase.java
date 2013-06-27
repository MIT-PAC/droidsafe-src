package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import android.net.sip.SipManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class SipCallBase extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.593 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.593 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        //Synthesized constructor
    }


    protected abstract void setState(State newState);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.594 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "5D5E6BCA44189EDFDBDADFEE1AE26D61")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_2019749064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2019749064 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_2019749064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2019749064;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.601 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "446C7F1C76EFEBE7AAC44948B7EF1E71")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1378832022 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179540490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179540490;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.602 -0400", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "EF57273C184D8CFEB9278A36FAB18260")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1137569523 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1137569523 = state.toString() + ":" + super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1137569523.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137569523;
        // ---------- Original Method ----------
        //return state.toString() + ":" + super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.602 -0400", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "35A71A2E7032BCF51089ECB8AB5AD166")
     void clearDisconnected() {
        {
            Iterator<Connection> it;
            it = connections.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_215959698 = (it.hasNext());
            {
                Connection c;
                c = it.next();
                {
                    boolean var7F0A0A3A4DD6BACF25D64645EE90F711_1436732974 = (c.getState() == State.DISCONNECTED);
                    it.remove();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2324698538BDC9FC3023E76E4A1AF1EB_941061698 = (connections.isEmpty());
            setState(State.IDLE);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Iterator<Connection> it = connections.iterator(); it.hasNext(); ) {
            //Connection c = it.next();
            //if (c.getState() == State.DISCONNECTED) it.remove();
        //}
        //if (connections.isEmpty()) setState(State.IDLE);
    }

    
}

