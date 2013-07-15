package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import java.util.ArrayList;
import java.util.List;

class GsmCall extends Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.764 -0400", hash_original_field = "EC0FEA7E6F8E16E3471486B698ED3A9D", hash_generated_field = "2814A276BAC6C190BAEC9128FA3036E9")

    ArrayList<Connection> connections = new ArrayList<Connection>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.764 -0400", hash_original_field = "72122CE96BFEC66E2396D2E25225D70A", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.765 -0400", hash_original_method = "28231960C31A4F9365B5A7FC4FD91175", hash_generated_method = "408E6705D70E74F4400D6AF6E976C261")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.766 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.766 -0400", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "7A9D76ED4C7E654363DB89E47E184CCE")
    public List<Connection> getConnections() {
List<Connection> varD8B91E18CFFE05D77A84C03EDA812BE2_1679725699 =         connections;
        varD8B91E18CFFE05D77A84C03EDA812BE2_1679725699.addTaint(taint);
        return varD8B91E18CFFE05D77A84C03EDA812BE2_1679725699;
        // ---------- Original Method ----------
        //return connections;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.766 -0400", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "71408A30DA1C2419F9C1B87389E76E72")
    public Phone getPhone() {
Phone var184C3BF9D73535588B22D3939CD1F578_770883104 =         owner.phone;
        var184C3BF9D73535588B22D3939CD1F578_770883104.addTaint(taint);
        return var184C3BF9D73535588B22D3939CD1F578_770883104;
        // ---------- Original Method ----------
        //return owner.phone;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.766 -0400", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "D3B4BCD47739498FA46BC49D571918BD")
    public boolean isMultiparty() {
        boolean var29D4E14E3A46A0A5CCEDD95593D030FA_907017286 = (connections.size() > 1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_549388759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_549388759;
        // ---------- Original Method ----------
        //return connections.size() > 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.766 -0400", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "5E905B16961B21B9CFA064E867BE77FF")
    public void hangup() throws CallStateException {
        owner.hangup(this);
        // ---------- Original Method ----------
        //owner.hangup(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.767 -0400", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "47592A5C4DE8D357DFEA637B53A131C0")
    public String toString() {
String var03910CD76C0E5BA32DFF47134AABAD32_552502065 =         state.toString();
        var03910CD76C0E5BA32DFF47134AABAD32_552502065.addTaint(taint);
        return var03910CD76C0E5BA32DFF47134AABAD32_552502065;
        // ---------- Original Method ----------
        //return state.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.767 -0400", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "1EA511AE55869B542F3AF0F88DEAA479")
     void attach(Connection conn, DriverCall dc) {
        addTaint(dc.getTaint());
        addTaint(conn.getTaint());
        connections.add(conn);
        state = stateFromDCState (dc.state);
        // ---------- Original Method ----------
        //connections.add(conn);
        //state = stateFromDCState (dc.state);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.767 -0400", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "F25E6E7715232EACCE5B85735F6ED78B")
     void attachFake(Connection conn, State state) {
        addTaint(state.getTaint());
        addTaint(conn.getTaint());
        connections.add(conn);
        this.state = state;
        // ---------- Original Method ----------
        //connections.add(conn);
        //this.state = state;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.768 -0400", hash_original_method = "6CF66D622F9C9313C400A181CC9C1077", hash_generated_method = "F513AC6FDA6110EB6F7EF0C63E06F5A0")
     void connectionDisconnected(GsmConnection conn) {
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.768 -0400", hash_original_method = "D8060A2D244E5FF428DF6CE721032DF1", hash_generated_method = "7FA6F22FF331101849029B2C04AF9BFD")
     void detach(GsmConnection conn) {
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.769 -0400", hash_original_method = "B7010AC293AED59823FAEF8D2AD3B969", hash_generated_method = "3FFAD2A7E18F826C42B789A4BAECA5D6")
     boolean update(GsmConnection conn, DriverCall dc) {
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
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1739457114 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068705466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068705466;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.769 -0400", hash_original_method = "8D2922917355F4AB0DD299BF5AB22FDE", hash_generated_method = "F94FCCA6272649A47ECB6F9DB2C3F8CE")
     boolean isFull() {
        boolean var87A40A3B673CDD3F8EDC668F98471211_106908980 = (connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999286506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999286506;
        // ---------- Original Method ----------
        //return connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.770 -0400", hash_original_method = "B742BF2BEC1472EF6E9612211814463C", hash_generated_method = "77D803A0E471ACC0DB8995ED4134CFF6")
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
for(int i = 0, s = connections.size();i < s;i++)
        {
            GsmConnection cn = (GsmConnection)connections.get(i);
            cn.onHangupLocal();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:26.770 -0400", hash_original_method = "001DBBEE7493D5C83D8EF835ED579635", hash_generated_method = "D88A649E223C5963F4A95B4936EC10AE")
     void clearDisconnected() {
for(int i = connections.size() - 1;i >= 0;i--)
        {
            GsmConnection cn = (GsmConnection)connections.get(i);
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

