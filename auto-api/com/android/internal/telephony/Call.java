package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.List;
import android.util.Log;

public abstract class Call {
    public State state = State.IDLE;
    protected boolean isGeneric = false;
    protected final String LOG_TAG = "Call";
    
    public abstract List<Connection> getConnections();

    
    public abstract Phone getPhone();

    
    public abstract boolean isMultiparty();

    
    public abstract void hangup() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "662F0E8496FE1A8D4FA04A1B042BCE20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasConnection(Connection c) {
        dsTaint.addTaint(c.dsTaint);
        boolean var55436ED00E4A388847DD6F1A0A73151E_2039017851 = (c.getCall() == this);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return c.getCall() == this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "DC7444B74994E8A5669C2DB7ADFB009B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasConnections() {
        List connections;
        connections = getConnections();
        boolean var19E6D303B61D79EE799E22D77B251D15_1291088554 = (connections.size() > 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //List connections = getConnections();
        //if (connections == null) {
            //return false;
        //}
        //return connections.size() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "8133026F827EEDDA12F622808DEDA458")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "B22F257DF6A6498F22DC234213D60DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isIdle() {
        boolean var285DB4CFA4C51F0FABAF97FE009E40A6_2034109370 = (!getState().isAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "5A6E778BE7E04F26C1C4660C7A25A4B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection getEarliestConnection() {
        List l;
        long time;
        time = Long.MAX_VALUE;
        Connection c;
        Connection earliest;
        earliest = null;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_137488378 = (l.size() == 0);
        } //End collapsed parenthetic
        {
            int i, s;
            i = 0;
            s = l.size();
            {
                c = (Connection) l.get(i);
                long t;
                t = c.getCreateTime();
                {
                    earliest = c;
                    time = t;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List l;
        //long time = Long.MAX_VALUE;
        //Connection c;
        //Connection earliest = null;
        //l = getConnections();
        //if (l.size() == 0) {
            //return null;
        //}
        //for (int i = 0, s = l.size() ; i < s ; i++) {
            //c = (Connection) l.get(i);
            //long t;
            //t = c.getCreateTime();
            //if (t < time) {
                //earliest = c;
                //time = t;
            //}
        //}
        //return earliest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "1E2B7C08E8643E7C1CC2C0F7EB7AF74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getEarliestCreateTime() {
        List l;
        long time;
        time = Long.MAX_VALUE;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1309432072 = (l.size() == 0);
        } //End collapsed parenthetic
        {
            int i, s;
            i = 0;
            s = l.size();
            {
                Connection c;
                c = (Connection) l.get(i);
                long t;
                t = c.getCreateTime();
                time = t < time ? t : time;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //List l;
        //long time = Long.MAX_VALUE;
        //l = getConnections();
        //if (l.size() == 0) {
            //return 0;
        //}
        //for (int i = 0, s = l.size() ; i < s ; i++) {
            //Connection c = (Connection) l.get(i);
            //long t;
            //t = c.getCreateTime();
            //time = t < time ? t : time;
        //}
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "C9EF32D8344F669D08A588A9DB7482B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getEarliestConnectTime() {
        long time;
        time = Long.MAX_VALUE;
        List l;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1345152608 = (l.size() == 0);
        } //End collapsed parenthetic
        {
            int i, s;
            i = 0;
            s = l.size();
            {
                Connection c;
                c = (Connection) l.get(i);
                long t;
                t = c.getConnectTime();
                time = t < time ? t : time;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long time = Long.MAX_VALUE;
        //List l = getConnections();
        //if (l.size() == 0) {
            //return 0;
        //}
        //for (int i = 0, s = l.size() ; i < s ; i++) {
            //Connection c = (Connection) l.get(i);
            //long t;
            //t = c.getConnectTime();
            //time = t < time ? t : time;
        //}
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "1B35E7986290D013A0AC4508060DAE11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDialingOrAlerting() {
        boolean var4891BE681B8E73045981C6F526C7E15A_442778287 = (getState().isDialing());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isDialing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.604 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "F1E5902910E58148DF56D3985CA91323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_1629143672 = (getState().isRinging());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.605 -0400", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "1559865906600D883AD9220035D793C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Connection getLatestConnection() {
        List l;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1215455729 = (l.size() == 0);
        } //End collapsed parenthetic
        long time;
        time = 0;
        Connection latest;
        latest = null;
        {
            int i, s;
            i = 0;
            s = l.size();
            {
                Connection c;
                c = (Connection) l.get(i);
                long t;
                t = c.getCreateTime();
                {
                    latest = c;
                    time = t;
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (Connection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List l = getConnections();
        //if (l.size() == 0) {
            //return null;
        //}
        //long time = 0;
        //Connection latest = null;
        //for (int i = 0, s = l.size() ; i < s ; i++) {
            //Connection c = (Connection) l.get(i);
            //long t = c.getCreateTime();
            //if (t > time) {
                //latest = c;
                //time = t;
            //}
        //}
        //return latest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.605 -0400", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "CEF511E1D25361B5CAE5D51D294F3E58")
    @DSModeled(DSC.SAFE)
    public boolean isGeneric() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isGeneric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.605 -0400", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "AE53604D9590279F1895BD1A12A6DDDA")
    @DSModeled(DSC.SAFE)
    public void setGeneric(boolean generic) {
        dsTaint.addTaint(generic);
        // ---------- Original Method ----------
        //isGeneric = generic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.605 -0400", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "9C940A6B642E5891F09F19619EEC030F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hangupIfAlive() {
        {
            boolean var9E19D3C659A4F7F587B0E2ED224F58BA_940766744 = (getState().isAlive());
            {
                try 
                {
                    hangup();
                } //End block
                catch (CallStateException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (getState().isAlive()) {
            //try {
                //hangup();
            //} catch (CallStateException ex) {
                //Log.w(LOG_TAG, " hangupIfActive: caught " + ex);
            //}
        //}
    }

    
    public enum State {
        IDLE, ACTIVE, HOLDING, DIALING, ALERTING, INCOMING, WAITING, DISCONNECTED, DISCONNECTING;
        public boolean isAlive() {
            return !(this == IDLE || this == DISCONNECTED || this == DISCONNECTING);
        }
        public boolean isRinging() {
            return this == INCOMING || this == WAITING;
        }
        public boolean isDialing() {
            return this == DIALING || this == ALERTING;
        }
    }

    
}


