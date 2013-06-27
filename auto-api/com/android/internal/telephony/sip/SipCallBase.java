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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.230 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "8202D840EE6CEF3CCCA47896EED71E34")

    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.230 -0400", hash_original_method = "0EF508E50423F81ECC9230D92981C1BD", hash_generated_method = "0EF508E50423F81ECC9230D92981C1BD")
    public SipCallBase ()
    {
        //Synthesized constructor
    }


    protected abstract void setState(State newState);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.231 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "DEDC0CFB2464F8333F717ED4A38A4CDB")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_1946158674 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1946158674 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_1946158674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1946158674;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.235 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "1425FC5D0A226A6F2AF7C121D2D2C1B3")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1000952883 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8531791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8531791;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.256 -0400", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "BF934CA6E292A8B909482F5409DD82CC")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_973091693 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_973091693 = state.toString() + ":" + super.toString();
        varB4EAC82CA7396A68D541C85D26508E83_973091693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_973091693;
        // ---------- Original Method ----------
        //return state.toString() + ":" + super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:22.256 -0400", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "1E2E60DDD3858C040DB99D95485B30F7")
     void clearDisconnected() {
        {
            Iterator<Connection> it;
            it = connections.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1748797579 = (it.hasNext());
            {
                Connection c;
                c = it.next();
                {
                    boolean var7F0A0A3A4DD6BACF25D64645EE90F711_1116793820 = (c.getState() == State.DISCONNECTED);
                    it.remove();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2324698538BDC9FC3023E76E4A1AF1EB_952999819 = (connections.isEmpty());
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

