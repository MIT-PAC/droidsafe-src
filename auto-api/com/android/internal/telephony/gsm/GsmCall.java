package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import java.util.ArrayList;
import java.util.List;

class GsmCall extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.123 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.123 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.124 -0400", hash_original_method = "28231960C31A4F9365B5A7FC4FD91175", hash_generated_method = "408E6705D70E74F4400D6AF6E976C261")
      GsmCall(GsmCallTracker owner) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.124 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.124 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "8AF97C87DBCB968CC62ABB0294D1B06A")
    public List<Connection> getConnections() {
        List<Connection> varB4EAC82CA7396A68D541C85D26508E83_1386773209 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1386773209 = connections;
        varB4EAC82CA7396A68D541C85D26508E83_1386773209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1386773209;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.125 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "0C4EFCE49C1DA0FD426B54BAAABAACE4")
    public Phone getPhone() {
        Phone varB4EAC82CA7396A68D541C85D26508E83_1108675872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1108675872 = owner.phone;
        varB4EAC82CA7396A68D541C85D26508E83_1108675872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1108675872;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.125 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "6E2B36F38504F9DFE8655EC8C686EA2C")
    public boolean isMultiparty() {
        boolean var52647A12D2BB0BA84480F9E34372A169_1422223296 = (connections.size() > 1);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958963352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958963352;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.125 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.126 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "2AA70803CC69752BCB6B25464BEC22D9")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_924312414 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_924312414 = state.toString();
        varB4EAC82CA7396A68D541C85D26508E83_924312414.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_924312414;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.126 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "E1D6DE3DB4F8E09EF74D5A336B63CF81")
     void attach(Connection conn, DriverCall dc) {
        connections.add(conn);
        state = stateFromDCState (dc.state);
        addTaint(conn.getTaint());
        addTaint(dc.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.127 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "415FA717321E9F355787A9DBB86120EB")
     void attachFake(Connection conn, State state) {
        connections.add(conn);
        this.state = state;
        addTaint(conn.getTaint());
        addTaint(state.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.128 -0400", hash_original_method = "6CF66D622F9C9313C400A181CC9C1077", hash_generated_method = "3E549CCF2102A027D914A6A3B1504FB1")
     void connectionDisconnected(GsmConnection conn) {
        {
            boolean hasOnlyDisconnectedConnections = true;
            {
                int i = 0;
                int s = connections.size();
                {
                    {
                        boolean var04AFE2A5134EA8ACC0F9B0C19F48FDDB_121845688 = (connections.get(i).getState()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.128 -0400", hash_original_method = "D8060A2D244E5FF428DF6CE721032DF1", hash_generated_method = "D8F97316784CC2466462A55B6B9D1FC2")
     void detach(GsmConnection conn) {
        connections.remove(conn);
        {
            boolean var92053B84273B30E40984664E5B7D0B68_309369668 = (connections.size() == 0);
            {
                state = State.IDLE;
            } 
        } 
        addTaint(conn.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.129 -0400", hash_original_method = "B7010AC293AED59823FAEF8D2AD3B969", hash_generated_method = "252990A5BB953ED3FED207AA49D2F9C7")
     boolean update(GsmConnection conn, DriverCall dc) {
        State newState;
        boolean changed = false;
        newState = stateFromDCState(dc.state);
        {
            state = newState;
            changed = true;
        } 
        addTaint(conn.getTaint());
        addTaint(dc.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229235;
        
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.129 -0400", hash_original_method = "8D2922917355F4AB0DD299BF5AB22FDE", hash_generated_method = "610129ACFF26ED6B4A88550927A320EC")
     boolean isFull() {
        boolean var2DF79FCB526F8B8B7AF2EB3786378692_293511514 = (connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8906822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8906822;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.129 -0400", hash_original_method = "B742BF2BEC1472EF6E9612211814463C", hash_generated_method = "C65A880D35ED85B0E5E950784165E560")
     void onHangupLocal() {
        
        {
            int i = 0;
            int s = connections.size();
            {
                GsmConnection cn = (GsmConnection)connections.get(i);
                cn.onHangupLocal();
            } 
        } 
        state = State.DISCONNECTING;
        
        
                
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:28.130 -0400", hash_original_method = "001DBBEE7493D5C83D8EF835ED579635", hash_generated_method = "FA110A826DD195443BB63D77D727CF5D")
     void clearDisconnected() {
        {
            int i = connections.size() - 1;
            {
                GsmConnection cn = (GsmConnection)connections.get(i);
                {
                    boolean var21929D219ECCE9FD7C6256E3BD60435E_1990403045 = (cn.getState() == State.DISCONNECTED);
                    {
                        connections.remove(i);
                    } 
                } 
            } 
        } 
        {
            boolean var92053B84273B30E40984664E5B7D0B68_1554811231 = (connections.size() == 0);
            {
                state = State.IDLE;
            } 
        } 
        
        
            
            
                
            
        
        
            
        
    }

    
}

