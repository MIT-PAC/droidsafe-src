package com.android.internal.telephony.cdma;

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






public final class CdmaCall extends Call {

    /***************************** Class Methods *****************************/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.857 -0500", hash_original_method = "4EE79409E957004105525310D650EB01", hash_generated_method = "529539D458B0DF619AD23836E4AF8D3C")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.855 -0500", hash_original_field = "2814A276BAC6C190BAEC9128FA3036E9", hash_generated_field = "93F634A2071B9C2571F503F2B2EDDC64")


    /*package*/ ArrayList<Connection> connections = new ArrayList<Connection>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.856 -0500", hash_original_field = "B9A7F7508B0B5FA0BFE8695446A61CF7", hash_generated_field = "B9A7F7508B0B5FA0BFE8695446A61CF7")
 State state = State.IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.857 -0500", hash_original_field = "3927F28CE0F1F17A9255E7EFC415C1BF", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")
 CdmaCallTracker owner;


    /****************************** Constructors *****************************/
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.858 -0500", hash_original_method = "D729656758C665C5D95A9ED02FF27E98", hash_generated_method = "D729656758C665C5D95A9ED02FF27E98")
    CdmaCall (CdmaCallTracker owner) {
        this.owner = owner;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.859 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    public void dispose() {
    }

    /************************** Overridden from Call *************************/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.860 -0500", hash_original_method = "DA46D72C53A8C0722B0E4038E55B8A9F", hash_generated_method = "B2D46C83F0D5D8DC52CF45AA8A64DAEC")
    public List<Connection>
    getConnections() {
        // FIXME should return Collections.unmodifiableList();
        return connections;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.861 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    public State
    getState() {
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.861 -0500", hash_original_method = "3D84383237FBED33FD2CE3B737BA6B20", hash_generated_method = "547D71B78517F12CFEE316EB1FBD48D5")
    public Phone
    getPhone() {
        return owner.phone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.862 -0500", hash_original_method = "E944BDEAA6C46A001782606E74F9EFB0", hash_generated_method = "2CA3BDACC129D60EAE4D95F06A3D2F50")
    public boolean isMultiparty() {
        return connections.size() > 1;
    }

    /** Please note: if this is the foreground call and a
     *  background call exists, the background call will be resumed
     *  because an AT+CHLD=1 will be sent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.863 -0500", hash_original_method = "BD4623110C086A165B3AF83FA1BCBA34", hash_generated_method = "1BD1699667D9B50F813761DAFD73391A")
    public void
    hangup() throws CallStateException {
        owner.hangup(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.864 -0500", hash_original_method = "A7B99D81B12619E0B5BB79286D622078", hash_generated_method = "4A7059719275EFBA493EA97F0FA75C18")
    public String
    toString() {
        return state.toString();
    }

    //***** Called from CdmaConnection

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.865 -0500", hash_original_method = "ADEE6A90086841672D212D83F619D5B4", hash_generated_method = "ADEE6A90086841672D212D83F619D5B4")
    void
    attach(Connection conn, DriverCall dc) {
        connections.add(conn);

        state = stateFromDCState (dc.state);
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.866 -0500", hash_original_method = "1D150B86FE35D9DF33C56E5123257F96", hash_generated_method = "1D150B86FE35D9DF33C56E5123257F96")
    void
    attachFake(Connection conn, State state) {
        connections.add(conn);

        this.state = state;
    }

    /**
     * Called by CdmaConnection when it has disconnected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.867 -0500", hash_original_method = "A46A7B47E3DFA1A951D01F8316BDCB63", hash_generated_method = "491CC6FAE4970D8E92826D7160056A71")
    void
    connectionDisconnected(CdmaConnection conn) {
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


    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.868 -0500", hash_original_method = "1EA8F68D5A466EEC41832970B917D4DC", hash_generated_method = "1EA8F68D5A466EEC41832970B917D4DC")
    void
    detach(CdmaConnection conn) {
        connections.remove(conn);

        if (connections.size() == 0) {
            state = State.IDLE;
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.868 -0500", hash_original_method = "653CAD94409C4BC1F3DC33028F34238B", hash_generated_method = "653CAD94409C4BC1F3DC33028F34238B")
    boolean
    update (CdmaConnection conn, DriverCall dc) {
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
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.869 -0500", hash_original_method = "1C46465CDA75E6DA5CCE62BB3DA600A6", hash_generated_method = "1C46465CDA75E6DA5CCE62BB3DA600A6")
    boolean
    isFull() {
        return connections.size() == CdmaCallTracker.MAX_CONNECTIONS_PER_CALL;
    }

    //***** Called from CdmaCallTracker


    /**
     * Called when this Call is being hung up locally (eg, user pressed "end")
     * Note that at this point, the hangup request has been dispatched to the radio
     * but no response has yet been received so update() has not yet been called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.870 -0500", hash_original_method = "A6EB616B9F71A14D95ECE60CFCB290DD", hash_generated_method = "A6EB616B9F71A14D95ECE60CFCB290DD")
    void
    onHangupLocal() {
        for (int i = 0, s = connections.size(); i < s; i++) {
            CdmaConnection cn = (CdmaConnection)connections.get(i);

            cn.onHangupLocal();
        }
        state = State.DISCONNECTING;
    }

    /**
     * Called when it's time to clean up disconnected Connection objects
     */
   @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.871 -0500", hash_original_method = "C72D64DE5C06A555CE5E29E3236A56AC", hash_generated_method = "C72D64DE5C06A555CE5E29E3236A56AC")
    void clearDisconnected() {
        for (int i = connections.size() - 1 ; i >= 0 ; i--) {
        CdmaConnection cn = (CdmaConnection)connections.get(i);

            if (cn.getState() == State.DISCONNECTED) {
                connections.remove(i);
            }
        }

        if (connections.size() == 0) {
            state = State.IDLE;
        }
    }

    
}

