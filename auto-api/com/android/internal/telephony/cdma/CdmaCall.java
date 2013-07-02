package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.098 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.098 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "B9A7F7508B0B5FA0BFE8695446A61CF7")

    State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.098 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")

    CdmaCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.098 -0400", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "9420100303E5D0809E6EDE6F78536020")
      CdmaCall(CdmaCallTracker owner) {
        this.owner = owner;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.099 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.099 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "DE53ACEEEDC5E10F4BFCDFDBF30C4420")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_400297322 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_400297322 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_400297322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_400297322;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.100 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "359BE96B13E2AF54C70329954DC7DE7E")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_1252590909 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1252590909 = state;
        varB4EAC82CA7396A68D541C85D26508E83_1252590909.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1252590909;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.100 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "51BE27924AC59A892E6FA66361AF5DFD")
    public Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1295562254 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1295562254 = owner.phone;
        varB4EAC82CA7396A68D541C85D26508E83_1295562254.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1295562254;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.100 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "5AA655CD7C74700400817C7D665C650B")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1383186805 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300662466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300662466;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.101 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.102 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "CFAE9BC43845592D2F20B19455AE3463")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1208874117 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1208874117 = state.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1208874117.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1208874117;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.102 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "CA3BFFAFC1C36E78B0478C3FF716B23A")
     void attach(Connection conn, DriverCall dc) {
        connections.add(conn);
        state = stateFromDCState (dc.state);
        addTaint(conn.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.102 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "060448F3048ABDD756C3C83A86C7C637")
     void attachFake(Connection conn, State state) {
        connections.add(conn);
        this.state = state;
        addTaint(conn.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.103 -0400", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "F3196313006C584A8A84449793438942")
     void connectionDisconnected(CdmaConnection conn) {
        {
            boolean hasOnlyDisconnectedConnections = true;
            {
                int i = 0;
                int s = connections.size();
                {
                    {
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_683530226 = (connections.get(i).getState()
                    != State.DISCONNECTED);
                        {
                            hasOnlyDisconnectedConnections = false;
                        } 
                    } 
                } 
            } 
            {
                state = State.DISCONNECTED;
            } 
        } 
        addTaint(conn.getTaint());
        
        
            
            
                
                    
                
                    
                    
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.103 -0400", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "37A1788C267AED1820241FCE2D09F48E")
     void detach(CdmaConnection conn) {
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_120900314 = (connections.size() == 0);
            {
                state = State.IDLE;
            } 
        } 
        addTaint(conn.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.104 -0400", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "19270C2BE2E318FD0DE3DC9C4E4BD9C7")
     boolean update(CdmaConnection conn, DriverCall dc) {
        State newState;
        boolean changed = false;
        newState = stateFromDCState(dc.state);
        {
            state = newState;
            changed = true;
        } 
        addTaint(conn.getTaint());
        addTaint(dc.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741460375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741460375;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.104 -0400", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "9012E3EA6832F3C328F12440EDFAE5CC")
     boolean isFull() {
        boolean varC5489A296DC91591FD5D45FE337F3741_1487748145 = (connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661685255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661685255;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.104 -0400", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "8EC14E3027B2DF53B77BDFF0A926AD53")
     void onHangupLocal() {
        
        {
            int i = 0;
            int s = connections.size();
            {
                CdmaConnection cn = (CdmaConnection)connections.get(i);
                cn.onHangupLocal();
            } 
        } 
        state = State.DISCONNECTING;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:26.105 -0400", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "62B460D0B199B833A1AEB318EC103483")
     void clearDisconnected() {
        {
            int i = connections.size() - 1;
            {
                CdmaConnection cn = (CdmaConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_1257024809 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } 
                } 
            } 
        } 
        {
            boolean var92053B84273B30E40984664E5B7D0B68_368637815 = (connections.size() == 0);
            {
                state = State.IDLE;
            } 
        } 
        
        
        
            
                
            
        
        
            
        
    }

    
}

