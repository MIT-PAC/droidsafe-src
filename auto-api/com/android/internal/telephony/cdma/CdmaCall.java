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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.773 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.773 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "B9A7F7508B0B5FA0BFE8695446A61CF7")

    State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.773 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.774 -0400", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "9420100303E5D0809E6EDE6F78536020")
      CdmaCall(CdmaCallTracker owner) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.774 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.775 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "8B0DC2C608E82EAF211B8AAC76F30D8A")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_207792326 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_207792326 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_207792326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207792326;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.775 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "1144A14E516BA0FBF5E04E3DA8C8B297")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_245875784 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_245875784 = state;
        varB4EAC82CA7396A68D541C85D26508E83_245875784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_245875784;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.788 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "F0F981FE26E56556CABABB4B229EE0AB")
    public Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_2115408291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115408291 = owner.phone;
        varB4EAC82CA7396A68D541C85D26508E83_2115408291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115408291;
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.788 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "EC6A2F1EA9713C5DB42AFE3838460AE0")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1127551826 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739897969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739897969;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.788 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.789 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "446A7F1821097D8C3DF368853C2BE59C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_536721151 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_536721151 = state.toString();
        varB4EAC82CA7396A68D541C85D26508E83_536721151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_536721151;
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.792 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "CA3BFFAFC1C36E78B0478C3FF716B23A")
     void attach(Connection conn, DriverCall dc) {
        connections.add(conn);
        state = stateFromDCState (dc.state);
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.805 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "060448F3048ABDD756C3C83A86C7C637")
     void attachFake(Connection conn, State state) {
        connections.add(conn);
        this.state = state;
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.812 -0400", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "F3934D0FFBD8A842CC97C545D4D5AF12")
     void connectionDisconnected(CdmaConnection conn) {
        {
            boolean hasOnlyDisconnectedConnections;
            hasOnlyDisconnectedConnections = true;
            {
                int i, s;
                i = 0;
                s = connections.size();
                {
                    {
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_1707064432 = (connections.get(i).getState()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.812 -0400", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "61B51D21BE8513877749C85475BAC919")
     void detach(CdmaConnection conn) {
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_94123397 = (connections.size() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.813 -0400", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "75A3F26EE12C8F533AB6D2C47CAD8C74")
     boolean update(CdmaConnection conn, DriverCall dc) {
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908027449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908027449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.813 -0400", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "C96CFCEAB163A80A941FF4F733977791")
     boolean isFull() {
        boolean varC5489A296DC91591FD5D45FE337F3741_1700485246 = (connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907347754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907347754;
        // ---------- Original Method ----------
        //return connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.815 -0400", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "3EA2F4CFB54B0F07D9AAD6AD7069BFD2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.829 -0400", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "DE0ABA84FCB5A5A0DFA80F6CFE137852")
     void clearDisconnected() {
        {
            int i;
            i = connections.size() - 1;
            {
                CdmaConnection cn;
                cn = (CdmaConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_611874520 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var92053B84273B30E40984664E5B7D0B68_682804322 = (connections.size() == 0);
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

