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
    protected List<Connection> connections = new ArrayList<Connection>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.110 -0400", hash_original_method = "C19A928E9B7F79A0623F03AD7B4C1C9A", hash_generated_method = "C19A928E9B7F79A0623F03AD7B4C1C9A")
        public SipCallBase ()
    {
    }


    protected abstract void setState(State newState);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.110 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "4F22A491BCE8B1633D346B0D6460A3C6")
    @DSModeled(DSC.SAFE)
    public List<Connection> getConnections() {
        return (List<Connection>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.110 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "3203AB70371E8F3801AF6DF2546093D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1036419592 = (connections.size() > 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.111 -0400", hash_original_method = "7D1F122E9D021AC073DB09CCD6084B65", hash_generated_method = "1BDC7DA091CD1CA5DE5EB22345A8E811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varAC66C43B3552A025EB19579AC5B03512_731248694 = (state.toString() + ":" + super.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return state.toString() + ":" + super.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.111 -0400", hash_original_method = "2179B35862415320201802CDBF1F003D", hash_generated_method = "2496FC76790524DFF0653AEC4BBC3355")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearDisconnected() {
        {
            Iterator<Connection> it;
            it = connections.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_2018964107 = (it.hasNext());
            {
                Connection c;
                c = it.next();
                {
                    boolean var7F0A0A3A4DD6BACF25D64645EE90F711_220443595 = (c.getState() == State.DISCONNECTED);
                    it.remove();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2324698538BDC9FC3023E76E4A1AF1EB_1779292695 = (connections.isEmpty());
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

