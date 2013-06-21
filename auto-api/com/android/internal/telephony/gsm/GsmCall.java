package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import java.util.ArrayList;
import java.util.List;

class GsmCall extends Call {
    ArrayList<Connection> connections = new ArrayList<Connection>();
    GsmCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.128 -0400", hash_original_method = "28231960C31A4F9365B5A7FC4FD91175", hash_generated_method = "DE38E51798C4C188FE79BABC554C5D08")
    @DSModeled(DSC.SAFE)
     GsmCall(GsmCallTracker owner) {
        dsTaint.addTaint(owner.dsTaint);
        // ---------- Original Method ----------
        //this.owner = owner;
    }

    
        static State stateFromDCState(DriverCall.State dcState) {
        switch (dcState) {
            case ACTIVE:        return State.ACTIVE;
            case HOLDING:       return State.HOLDING;
            case DIALING:       return State.DIALING;
            case ALERTING:      return State.ALERTING;
            case INCOMING:      return State.INCOMING;
            case WAITING:       return State.WAITING;
            default:            throw new RuntimeException ("illegal call state:" + dcState);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.128 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "4F22A491BCE8B1633D346B0D6460A3C6")
    @DSModeled(DSC.SAFE)
    public List<Connection> getConnections() {
        return (List<Connection>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "6DAE36C7FCE1ADB4E0F4B65FA789928E")
    @DSModeled(DSC.SAFE)
    public Phone getPhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "62EC9617E897B5AE95DD7F1047A5CF21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1024035054 = (connections.size() > 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "72B5A14F8230914B8BB84B66BFD2DD54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var5EF4649C78F5CB0BBE023751D2BCF5D7_1725908948 = (state.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.129 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "7EE29B2E705E4F50E03C5F8F2A33B038")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void attach(Connection conn, DriverCall dc) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(conn.dsTaint);
        connections.add(conn);
        state = stateFromDCState (dc.state);
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.130 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "1D473989869F9E810C2444183C3EE5F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void attachFake(Connection conn, State state) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        connections.add(conn);
        this.state = state;
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.130 -0400", hash_original_method = "6CF66D622F9C9313C400A181CC9C1077", hash_generated_method = "546C0F02EDBE4D989041868132561618")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void connectionDisconnected(GsmConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        {
            boolean hasOnlyDisconnectedConnections;
            hasOnlyDisconnectedConnections = true;
            {
                int i, s;
                i = 0;
                s = connections.size();
                {
                    {
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_944551091 = (connections.get(i).getState()
                    != State.DISCONNECTED);
                        {
                            hasOnlyDisconnectedConnections = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                state = State.DISCONNECTED;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (state != State.DISCONNECTED) {
            //boolean hasOnlyDisconnectedConnections = true;
            //for (int i = 0, s = connections.size()  ; i < s; i ++) {
                //if (connections.get(i).getState()
                    //!= State.DISCONNECTED
                //) {
                    //hasOnlyDisconnectedConnections = false;
                    //break;
                //}
            //}
            //if (hasOnlyDisconnectedConnections) {
                //state = State.DISCONNECTED;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.130 -0400", hash_original_method = "D8060A2D244E5FF428DF6CE721032DF1", hash_generated_method = "F2B6AABE7DD1F5E4E53CE6605A958FD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void detach(GsmConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_77311962 = (connections.size() == 0);
            {
                state = State.IDLE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //connections.remove(conn);
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.130 -0400", hash_original_method = "B7010AC293AED59823FAEF8D2AD3B969", hash_generated_method = "1687DC8DB464E5AC11EFEFA6589CFCA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean update(GsmConnection conn, DriverCall dc) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(conn.dsTaint);
        State newState;
        boolean changed;
        changed = false;
        newState = stateFromDCState(dc.state);
        {
            state = newState;
            changed = true;
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //State newState;
        //boolean changed = false;
        //newState = stateFromDCState(dc.state);
        //if (newState != state) {
            //state = newState;
            //changed = true;
        //}
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.131 -0400", hash_original_method = "8D2922917355F4AB0DD299BF5AB22FDE", hash_generated_method = "ABEBDFD0623DCE20E705BC337CAF4728")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isFull() {
        boolean var2DF79FCB526F8B8B7AF2EB3786378692_185660750 = (connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.131 -0400", hash_original_method = "B742BF2BEC1472EF6E9612211814463C", hash_generated_method = "ACEC69C81800DED71743CFE7619A0D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int i, s;
            i = 0;
            s = connections.size();
            {
                GsmConnection cn;
                cn = (GsmConnection)connections.get(i);
                cn.onHangupLocal();
            } //End block
        } //End collapsed parenthetic
        state = State.DISCONNECTING;
        // ---------- Original Method ----------
        //for (int i = 0, s = connections.size()
                //; i < s; i++
        //) {
            //GsmConnection cn = (GsmConnection)connections.get(i);
            //cn.onHangupLocal();
        //}
        //state = State.DISCONNECTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.131 -0400", hash_original_method = "001DBBEE7493D5C83D8EF835ED579635", hash_generated_method = "3AD4751E8824A6B396D22A6293313116")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearDisconnected() {
        {
            int i;
            i = connections.size() - 1;
            {
                GsmConnection cn;
                cn = (GsmConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_1262307309 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var92053B84273B30E40984664E5B7D0B68_1527954151 = (connections.size() == 0);
            {
                state = State.IDLE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = connections.size() - 1 ; i >= 0 ; i--) {
            //GsmConnection cn = (GsmConnection)connections.get(i);
            //if (cn.getState() == State.DISCONNECTED) {
                //connections.remove(i);
            //}
        //}
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
}

