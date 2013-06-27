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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.476 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.476 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.480 -0400", hash_original_method = "28231960C31A4F9365B5A7FC4FD91175", hash_generated_method = "408E6705D70E74F4400D6AF6E976C261")
      GsmCall(GsmCallTracker owner) {
        this.owner = owner;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.481 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.481 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "C65C5041F9B424C7E841BCBAA45569A7")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_1325970679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1325970679 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_1325970679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1325970679;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.482 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "FB6843AAA8FB5F755E9B916E9D203346")
    public Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1032919374 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032919374 = owner.phone;
        varB4EAC82CA7396A68D541C85D26508E83_1032919374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032919374;
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.482 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "291DBEFAD7EC51529612C3C1F83E51C3")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1832710388 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034705166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034705166;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.487 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.488 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "AA292B53388881A7AC8A46FCD7F924CC")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_596887721 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_596887721 = state.toString();
        varB4EAC82CA7396A68D541C85D26508E83_596887721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_596887721;
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.488 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "E1D6DE3DB4F8E09EF74D5A336B63CF81")
     void attach(Connection conn, DriverCall dc) {
        connections.add(conn);
        state = stateFromDCState (dc.state);
        addTaint(conn.getTaint());
        addTaint(dc.getTaint());
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.489 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "415FA717321E9F355787A9DBB86120EB")
     void attachFake(Connection conn, State state) {
        connections.add(conn);
        this.state = state;
        addTaint(conn.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.494 -0400", hash_original_method = "6CF66D622F9C9313C400A181CC9C1077", hash_generated_method = "A2CD16F7D7B82C68487B21E3B8FC6827")
     void connectionDisconnected(GsmConnection conn) {
        {
            boolean hasOnlyDisconnectedConnections;
            hasOnlyDisconnectedConnections = true;
            {
                int i, s;
                i = 0;
                s = connections.size();
                {
                    {
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_2072830767 = (connections.get(i).getState()
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
        addTaint(conn.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.494 -0400", hash_original_method = "D8060A2D244E5FF428DF6CE721032DF1", hash_generated_method = "EAA923C1E0FAB345220D3C977F4EA35B")
     void detach(GsmConnection conn) {
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_16531921 = (connections.size() == 0);
            {
                state = State.IDLE;
            } //End block
        } //End collapsed parenthetic
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //connections.remove(conn);
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.496 -0400", hash_original_method = "B7010AC293AED59823FAEF8D2AD3B969", hash_generated_method = "854EA44083718AD13B8EA9FCDF60EFC9")
     boolean update(GsmConnection conn, DriverCall dc) {
        State newState;
        boolean changed;
        changed = false;
        newState = stateFromDCState(dc.state);
        {
            state = newState;
            changed = true;
        } //End block
        addTaint(conn.getTaint());
        addTaint(dc.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883378491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883378491;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.497 -0400", hash_original_method = "8D2922917355F4AB0DD299BF5AB22FDE", hash_generated_method = "EDD09C399636800F0F156108A6146E79")
     boolean isFull() {
        boolean var2DF79FCB526F8B8B7AF2EB3786378692_1034845925 = (connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1050717107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1050717107;
        // ---------- Original Method ----------
        //return connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.497 -0400", hash_original_method = "B742BF2BEC1472EF6E9612211814463C", hash_generated_method = "ACEC69C81800DED71743CFE7619A0D0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.503 -0400", hash_original_method = "001DBBEE7493D5C83D8EF835ED579635", hash_generated_method = "7F951A4B8AED87523801CA068F229A20")
     void clearDisconnected() {
        {
            int i;
            i = connections.size() - 1;
            {
                GsmConnection cn;
                cn = (GsmConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_837154025 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var92053B84273B30E40984664E5B7D0B68_1195568916 = (connections.size() == 0);
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

