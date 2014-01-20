package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.List;

public abstract class Call {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.352 -0500", hash_original_field = "B9A7F7508B0B5FA0BFE8695446A61CF7", hash_generated_field = "682AB4A75DC1B6B1A2EFDFBB9B599B89")

    public State state = State.IDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.355 -0500", hash_original_field = "7D8BB6ADB117CDA5A7D86665AF4C7DC1", hash_generated_field = "A3D78BB4BFE03BD2029C37858ABFEC15")

    // is accurate. If false the information is known to be accurate.
    //
    // For CDMA, during call waiting/3 way, there is no network response
    // if call waiting is answered, network timed out, dropped, 3 way
    // merged, etc.
    protected boolean isGeneric = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.359 -0500", hash_original_field = "AA82415423A161F79EE53609FCB2BED1", hash_generated_field = "548675245A66AB01BBAEC34E10E70E57")

    protected final String LOG_TAG = "Call";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.400 -0400", hash_original_method = "CB9B9DF7FC21F16DE5B641A13D14D68A", hash_generated_method = "CB9B9DF7FC21F16DE5B641A13D14D68A")
    public Call ()
    {
        //Synthesized constructor
    }

    /* Instance Methods */

    /** Do not modify the List result!!! This list is not yours to keep
     *  It will change across event loop iterations            top
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.361 -0500", hash_original_method = "0089893DA47F1B14AB96BC8B40B81502", hash_generated_method = "9372FCFEA6B5445E00ABA77EFD3B2BFF")
    
public abstract List<Connection> getConnections();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.364 -0500", hash_original_method = "2934325051523620DCD2F62BF84383AD", hash_generated_method = "12BBA2D21C9A07EF05F8A8A5DD085730")
    
public abstract Phone getPhone();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.368 -0500", hash_original_method = "1BE345EF59716A496590A9770EF7112C", hash_generated_method = "D52C554226BFE13E03B63E4EFC6DB11B")
    
public abstract boolean isMultiparty();
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.371 -0500", hash_original_method = "75701B1B375E0F543AC12EA12A4A97FB", hash_generated_method = "A317DEC2810CF43CE258BB1AF0C61528")
    
public abstract void hangup() throws CallStateException;

    /**
     * hasConnection
     *
     * @param c a Connection object
     * @return true if the call contains the connection object passed in
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.373 -0500", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "391B247D022234278D64880D30747BF5")
    
public boolean hasConnection(Connection c) {
        return c.getCall() == this;
    }

    /**
     * hasConnections
     * @return true if the call contains one or more connections
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.381 -0500", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "DE5769FF6F1025FE3BBD898EED09357F")
    
public boolean hasConnections() {
        List connections = getConnections();

        if (connections == null) {
            return false;
        }

        return connections.size() > 0;
    }

    /**
     * getState
     * @return state of class call
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.384 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    
public State getState() {
        return state;
    }

    /**
     * isIdle
     *
     * FIXME rename
     * @return true if the call contains only disconnected connections (if any)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.387 -0500", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "14E698170DA8EF81F24A285BFB033922")
    
public boolean isIdle() {
        return !getState().isAlive();
    }

    /**
     * Returns the Connection associated with this Call that was created
     * first, or null if there are no Connections in this Call
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.390 -0500", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "ACEB13664304309AF4846C775A69615B")
    
public Connection
    getEarliestConnection() {
        List l;
        long time = Long.MAX_VALUE;
        Connection c;
        Connection earliest = null;

        l = getConnections();

        if (l.size() == 0) {
            return null;
        }

        for (int i = 0, s = l.size() ; i < s ; i++) {
            c = (Connection) l.get(i);
            long t;

            t = c.getCreateTime();

            if (t < time) {
                earliest = c;
                time = t;
            }
        }

        return earliest;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.394 -0500", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "694B93E1CD996C155FD6BF023A5236CA")
    
public long
    getEarliestCreateTime() {
        List l;
        long time = Long.MAX_VALUE;

        l = getConnections();

        if (l.size() == 0) {
            return 0;
        }

        for (int i = 0, s = l.size() ; i < s ; i++) {
            Connection c = (Connection) l.get(i);
            long t;

            t = c.getCreateTime();

            time = t < time ? t : time;
        }

        return time;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.397 -0500", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "70C8DDCABB05E4F8DC7A0DAFCFE8C149")
    
public long
    getEarliestConnectTime() {
        long time = Long.MAX_VALUE;
        List l = getConnections();

        if (l.size() == 0) {
            return 0;
        }

        for (int i = 0, s = l.size() ; i < s ; i++) {
            Connection c = (Connection) l.get(i);
            long t;

            t = c.getConnectTime();

            time = t < time ? t : time;
        }

        return time;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.400 -0500", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "45B471CBFE7BC9E8B7652A10E092F8EC")
    
public boolean
    isDialingOrAlerting() {
        return getState().isDialing();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.404 -0500", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "16CC1CFC6180AB1043D126A8812C5EFC")
    
public boolean
    isRinging() {
        return getState().isRinging();
    }

    /**
     * Returns the Connection associated with this Call that was created
     * last, or null if there are no Connections in this Call
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.407 -0500", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "4558929149DE334138F10DA6DC7EFE45")
    
public Connection
    getLatestConnection() {
        List l = getConnections();
        if (l.size() == 0) {
            return null;
        }

        long time = 0;
        Connection latest = null;
        for (int i = 0, s = l.size() ; i < s ; i++) {
            Connection c = (Connection) l.get(i);
            long t = c.getCreateTime();

            if (t > time) {
                latest = c;
                time = t;
            }
        }

        return latest;
    }

    /**
     * To indicate if the connection information is accurate
     * or not. false means accurate. Only used for CDMA.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.410 -0500", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "F76B3EF97DFFD5F77988BC6C90671EA5")
    
public boolean isGeneric() {
        return isGeneric;
    }

    /**
     * Set the generic instance variable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.418 -0500", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "A949705BC8CF208A1380770E49D5F6E9")
    
public void setGeneric(boolean generic) {
        isGeneric = generic;
    }

    /**
     * Hangup call if it is alive
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.421 -0500", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "AC12E6F6AC57236A975CEB81D563ABEC")
    
public void hangupIfAlive() {
        if (getState().isAlive()) {
            try {
                hangup();
            } catch (CallStateException ex) {
                Log.w(LOG_TAG, " hangupIfActive: caught " + ex);
            }
        }
    }
    
    public enum State {
        IDLE, ACTIVE, HOLDING, DIALING, ALERTING, INCOMING, WAITING, DISCONNECTED, DISCONNECTING;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.342 -0500", hash_original_method = "1D40ACE3FD32D34B0C7713C126ACAA55", hash_generated_method = "D39F0E5131016197FC464FFBF3F71C0D")
            
public boolean isAlive() {
            return !(this == IDLE || this == DISCONNECTED || this == DISCONNECTING);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.344 -0500", hash_original_method = "53E09777680EBEF4D68A789F8A3DB035", hash_generated_method = "9E54D0DBC2503603DC7827809E47ADAF")
            
public boolean isRinging() {
            return this == INCOMING || this == WAITING;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.346 -0500", hash_original_method = "69A5378B3F729753228D086FBB596C88", hash_generated_method = "57AED8D3463E439DC15CD1FDBC06B749")
            
public boolean isDialing() {
            return this == DIALING || this == ALERTING;
        }
    }
    
}

