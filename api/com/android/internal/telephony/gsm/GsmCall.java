package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;

class GsmCall extends Call {

    /***************************** Class Methods *****************************/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.986 -0500", hash_original_method = "4EE79409E957004105525310D650EB01", hash_generated_method = "529539D458B0DF619AD23836E4AF8D3C")
    
static State
    stateFromDCState (DriverCall.State dcState) {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.981 -0500", hash_original_field = "2814A276BAC6C190BAEC9128FA3036E9", hash_generated_field = "93F634A2071B9C2571F503F2B2EDDC64")

    /*package*/ ArrayList<Connection> connections = new ArrayList<Connection>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.983 -0500", hash_original_field = "B6239D6F2AF1190D06AAF0170D315E18", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")
 GsmCallTracker owner;

    /****************************** Constructors *****************************/
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.989 -0500", hash_original_method = "28231960C31A4F9365B5A7FC4FD91175", hash_generated_method = "28231960C31A4F9365B5A7FC4FD91175")
    
GsmCall (GsmCallTracker owner) {
        this.owner = owner;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.991 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    /************************** Overridden from Call *************************/

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.994 -0500", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "B2D46C83F0D5D8DC52CF45AA8A64DAEC")
    
public List<Connection>
    getConnections() {
        // FIXME should return Collections.unmodifiableList();
        return connections;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.997 -0500", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "547D71B78517F12CFEE316EB1FBD48D5")
    
public Phone
    getPhone() {
        return owner.phone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.000 -0500", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "2CA3BDACC129D60EAE4D95F06A3D2F50")
    
public boolean
    isMultiparty() {
        return connections.size() > 1;
    }

    /** Please note: if this is the foreground call and a
     *  background call exists, the background call will be resumed
     *  because an AT+CHLD=1 will be sent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.004 -0500", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "1BD1699667D9B50F813761DAFD73391A")
    
public void
    hangup() throws CallStateException {
        owner.hangup(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.006 -0500", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "4A7059719275EFBA493EA97F0FA75C18")
    
public String
    toString() {
        return state.toString();
    }

    //***** Called from GsmConnection

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.009 -0500", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "ADEE6A90086841672D212D83F619D5B4")
    
void
    attach(Connection conn, DriverCall dc) {
        connections.add(conn);

        state = stateFromDCState (dc.state);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.011 -0500", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "1D150B86FE35D9DF33C56E5123257F96")
    
void
    attachFake(Connection conn, State state) {
        connections.add(conn);

        this.state = state;
    }

    /**
     * Called by GsmConnection when it has disconnected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.014 -0500", hash_original_method = "6CF66D622F9C9313C400A181CC9C1077", hash_generated_method = "C0929D6422F5D3C11AC276F36853FA1D")
    
void
    connectionDisconnected(GsmConnection conn) {
        if (state != State.DISCONNECTED) {
            /* If only disconnected connections remain, we are disconnected*/

            boolean hasOnlyDisconnectedConnections = true;

            for (int i = 0, s = connections.size()  ; i < s; i ++) {
                if (connections.get(i).getState()
                    != State.DISCONNECTED
                ) {
                    hasOnlyDisconnectedConnections = false;
                    break;
                }
            }

            if (hasOnlyDisconnectedConnections) {
                state = State.DISCONNECTED;
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.016 -0500", hash_original_method = "D8060A2D244E5FF428DF6CE721032DF1", hash_generated_method = "D8060A2D244E5FF428DF6CE721032DF1")
    
void
    detach(GsmConnection conn) {
        connections.remove(conn);

        if (connections.size() == 0) {
            state = State.IDLE;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.019 -0500", hash_original_method = "B7010AC293AED59823FAEF8D2AD3B969", hash_generated_method = "B7010AC293AED59823FAEF8D2AD3B969")
    
boolean
    update (GsmConnection conn, DriverCall dc) {
        State newState;
        boolean changed = false;

        newState = stateFromDCState(dc.state);

        if (newState != state) {
            state = newState;
            changed = true;
        }

        return changed;
    }

    /**
     * @return true if there's no space in this call for additional
     * connections to be added via "conference"
     */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.021 -0500", hash_original_method = "8D2922917355F4AB0DD299BF5AB22FDE", hash_generated_method = "8D2922917355F4AB0DD299BF5AB22FDE")
    
boolean
    isFull() {
        return connections.size() == GsmCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    //***** Called from GsmCallTracker

    /**
     * Called when this Call is being hung up locally (eg, user pressed "end")
     * Note that at this point, the hangup request has been dispatched to the radio
     * but no response has yet been received so update() has not yet been called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.024 -0500", hash_original_method = "B742BF2BEC1472EF6E9612211814463C", hash_generated_method = "B742BF2BEC1472EF6E9612211814463C")
    
void
    onHangupLocal() {
        for (int i = 0, s = connections.size()
                ; i < s; i++
        ) {
            GsmConnection cn = (GsmConnection)connections.get(i);

            cn.onHangupLocal();
        }
        state = State.DISCONNECTING;
    }

    /**
     * Called when it's time to clean up disconnected Connection objects
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:20.026 -0500", hash_original_method = "001DBBEE7493D5C83D8EF835ED579635", hash_generated_method = "001DBBEE7493D5C83D8EF835ED579635")
    
void
    clearDisconnected() {
        for (int i = connections.size() - 1 ; i >= 0 ; i--) {
            GsmConnection cn = (GsmConnection)connections.get(i);

            if (cn.getState() == State.DISCONNECTED) {
                connections.remove(i);
            }
        }

        if (connections.size() == 0) {
            state = State.IDLE;
        }
    }
    
}

