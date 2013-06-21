package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.Call.State;

public final class CdmaCall extends Call {
    ArrayList<Connection> connections = new ArrayList<Connection>();
    State state = State.IDLE;
    CdmaCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.166 -0400", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "92BB0CA0052A58228A9B86F4D88DB124")
    @DSModeled(DSC.SAFE)
     CdmaCall(CdmaCallTracker owner) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.167 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.167 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "4F22A491BCE8B1633D346B0D6460A3C6")
    @DSModeled(DSC.SAFE)
    public List<Connection> getConnections() {
        return (List<Connection>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.167 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "F5E227F5D2B96691C815C4C56ED31889")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.167 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "6DAE36C7FCE1ADB4E0F4B65FA789928E")
    @DSModeled(DSC.SAFE)
    public Phone getPhone() {
        return (Phone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.167 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "34D63542768E3D7203CD68B51757023F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_127866904 = (connections.size() > 1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.168 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.168 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "849675E365ED3B5799D05A521A602B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var5EF4649C78F5CB0BBE023751D2BCF5D7_1306647545 = (state.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.168 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "7EE29B2E705E4F50E03C5F8F2A33B038")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.168 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "418C96BFE0285CF290AAAE147C82C9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void attachFake(Connection conn, State state) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        connections.add(conn);
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.169 -0400", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "31B06068F632915282E97643DBB04BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void connectionDisconnected(CdmaConnection conn) {
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
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_1774262062 = (connections.get(i).getState()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.169 -0400", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "854FBD3FE9C3263D9EAF4894D4F9802F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void detach(CdmaConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_1223853617 = (connections.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.169 -0400", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "06939A5CD965601ABEC4F63988ECB4AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean update(CdmaConnection conn, DriverCall dc) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.169 -0400", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "19967B7115E6A3D9E99A2D094E77ABAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isFull() {
        boolean varC5489A296DC91591FD5D45FE337F3741_1950398772 = (connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.169 -0400", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "3EA2F4CFB54B0F07D9AAD6AD7069BFD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int i, s;
            i = 0;
            s = connections.size();
            {
                CdmaConnection cn;
                cn = (CdmaConnection)connections.get(i);
                cn.onHangupLocal();
            } //End block
        } //End collapsed parenthetic
        state = State.DISCONNECTING;
        // ---------- Original Method ----------
        //for (int i = 0, s = connections.size(); i < s; i++) {
            //CdmaConnection cn = (CdmaConnection)connections.get(i);
            //cn.onHangupLocal();
        //}
        //state = State.DISCONNECTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.170 -0400", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "C452BB895925980C67E53349A6A97A2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void clearDisconnected() {
        {
            int i;
            i = connections.size() - 1;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_1002699859 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var92053B84273B30E40984664E5B7D0B68_1728111223 = (connections.size() == 0);
            {
                state = State.IDLE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = connections.size() - 1 ; i >= 0 ; i--) {
        //CdmaConnection cn = (CdmaConnection)connections.get(i);
            //if (cn.getState() == State.DISCONNECTED) {
                //connections.remove(i);
            //}
        //}
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
}

