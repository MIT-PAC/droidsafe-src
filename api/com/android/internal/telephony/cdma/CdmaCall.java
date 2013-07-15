package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.Call.State;

public final class CdmaCall extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.831 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.831 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "B9A7F7508B0B5FA0BFE8695446A61CF7")

    State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.831 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.831 -0400", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "9420100303E5D0809E6EDE6F78536020")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.832 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.832 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "E379CA6201CEC2974815BDDA2CE0BE7E")
    public List<Connection> getConnections() {
List<Connection> varD8B91E18CFFE05D77A84C03EDA812BE2_1082908797 =         connections;
        varD8B91E18CFFE05D77A84C03EDA812BE2_1082908797.addTaint(taint);
        return varD8B91E18CFFE05D77A84C03EDA812BE2_1082908797;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.832 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "DF5143EAF34FF78CA967FCB394D41E85")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1010576815 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1010576815.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1010576815;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.833 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "98697A28E3AD2946FA418C17AF4D095D")
    public Phone getPhone() {
Phone var184C3BF9D73535588B22D3939CD1F578_1407726038 =         owner.phone;
        var184C3BF9D73535588B22D3939CD1F578_1407726038.addTaint(taint);
        return var184C3BF9D73535588B22D3939CD1F578_1407726038;
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.833 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "5FC04860FDE0596F4D93DD601E83C7F6")
    public boolean isMultiparty() {
        boolean var29D4E14E3A46A0A5CCEDD95593D030FA_1641437721 = (connections.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510697573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510697573;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.833 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.833 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "A73E71AE6A8F6012FE791833B605EAA7")
    public String toString() {
String var03910CD76C0E5BA32DFF47134AABAD32_873388329 =         state.toString();
        var03910CD76C0E5BA32DFF47134AABAD32_873388329.addTaint(taint);
        return var03910CD76C0E5BA32DFF47134AABAD32_873388329;
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.834 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "22AAC99E45C90029960E2F69AB5EA92D")
     void attach(Connection conn, DriverCall dc) {
        addTaint(conn.getTaint());
        connections.add(conn);
        state = stateFromDCState (dc.state);
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.835 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "F17A54287702BEEEEE53D672240B962B")
     void attachFake(Connection conn, State state) {
        addTaint(conn.getTaint());
        connections.add(conn);
        this.state = state;
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.835 -0400", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "F67D8A925EEEA797937A43631E35B78D")
     void connectionDisconnected(CdmaConnection conn) {
        addTaint(conn.getTaint());
    if(state != State.DISCONNECTED)        
        {
            boolean hasOnlyDisconnectedConnections = true;
for(int i = 0, s = connections.size();i < s;i ++)
            {
    if(connections.get(i).getState()
                    != State.DISCONNECTED)                
                {
                    hasOnlyDisconnectedConnections = false;
                    break;
                } //End block
            } //End block
    if(hasOnlyDisconnectedConnections)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.836 -0400", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "B2350A40156F2BD9101E3397A3AFED70")
     void detach(CdmaConnection conn) {
        addTaint(conn.getTaint());
        connections.remove(conn);
    if(connections.size() == 0)        
        {
            state = State.IDLE;
        } //End block
        // ---------- Original Method ----------
        //connections.remove(conn);
        //if (connections.size() == 0) {
            //state = State.IDLE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.837 -0400", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "52BD140B2DF4D96FBA55F2CE85BE1F00")
     boolean update(CdmaConnection conn, DriverCall dc) {
        addTaint(dc.getTaint());
        addTaint(conn.getTaint());
        State newState;
        boolean changed = false;
        newState = stateFromDCState(dc.state);
    if(newState != state)        
        {
            state = newState;
            changed = true;
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1847131176 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_234389619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_234389619;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.837 -0400", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "B58C6241EF27920C94083FDE06C69555")
     boolean isFull() {
        boolean var0C9294BE7F8A42493544D3634F51C6C1_225390363 = (connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969207582 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969207582;
        // ---------- Original Method ----------
        //return connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.837 -0400", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "BCE23747EA4487F06E6D73081A19303C")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
for(int i = 0, s = connections.size();i < s;i++)
        {
            CdmaConnection cn = (CdmaConnection)connections.get(i);
            cn.onHangupLocal();
        } //End block
        state = State.DISCONNECTING;
        // ---------- Original Method ----------
        //for (int i = 0, s = connections.size(); i < s; i++) {
            //CdmaConnection cn = (CdmaConnection)connections.get(i);
            //cn.onHangupLocal();
        //}
        //state = State.DISCONNECTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:24.838 -0400", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "521F7300810B1FFBDD639FC4813AC6F5")
     void clearDisconnected() {
for(int i = connections.size() - 1;i >= 0;i--)
        {
            CdmaConnection cn = (CdmaConnection)connections.get(i);
    if(cn.getState() == State.DISCONNECTED)            
            {
                connections.remove(i);
            } //End block
        } //End block
    if(connections.size() == 0)        
        {
            state = State.IDLE;
        } //End block
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

