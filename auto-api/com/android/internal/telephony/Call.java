package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import android.util.Log;

public abstract class Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "682AB4A75DC1B6B1A2EFDFBB9B599B89")

    public State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_field = "145F45FAD3D9A65F2E45DF93DC09017A", hash_generated_field = "508CDFD163A234BDAF6D1151B8AC029E")

    protected boolean isGeneric = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_field = "2C3C4BA0AA1A67B454D055C30572EBF9", hash_generated_field = "9609A132D9AD99904E7D106C3DB80085")

    protected String LOG_TAG = "Call";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.779 -0400", hash_original_method = "CB9B9DF7FC21F16DE5B641A13D14D68A", hash_generated_method = "CB9B9DF7FC21F16DE5B641A13D14D68A")
    public Call ()
    {
        //Synthesized constructor
    }


    public abstract List<Connection> getConnections();

    
    public abstract Phone getPhone();

    
    public abstract boolean isMultiparty();

    
    public abstract void hangup() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.780 -0400", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "4CE450D9CDA956C7B990B3449F589871")
    public boolean hasConnection(Connection c) {
        boolean var55436ED00E4A388847DD6F1A0A73151E_1225050567 = (c.getCall() == this);
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039335916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039335916;
        // ---------- Original Method ----------
        //return c.getCall() == this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.789 -0400", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "0FA65C95D757F561E268C5B27367DFE8")
    public boolean hasConnections() {
        List connections;
        connections = getConnections();
        boolean var19E6D303B61D79EE799E22D77B251D15_311964713 = (connections.size() > 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292660572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292660572;
        // ---------- Original Method ----------
        //List connections = getConnections();
        //if (connections == null) {
            //return false;
        //}
        //return connections.size() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.789 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "ABF15858CF268231F950F2D1FC92C6CF")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_97500203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97500203 = state;
        varB4EAC82CA7396A68D541C85D26508E83_97500203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97500203;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.795 -0400", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "B0CF631DEC7F9E5CC7B4C0E88019EAEE")
    public boolean isIdle() {
        boolean var285DB4CFA4C51F0FABAF97FE009E40A6_1637009610 = (!getState().isAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500259495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500259495;
        // ---------- Original Method ----------
        //return !getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.795 -0400", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "37D6627053A618402CDE87B7B65F34B4")
    public Connection getEarliestConnection() {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1709322954 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_802392464 = null; //Variable for return #2
        List l;
        long time;
        time = Long.MAX_VALUE;
        Connection c;
        Connection earliest;
        earliest = null;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1400265541 = (l.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1709322954 = null;
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_802392464 = earliest;
        Connection varA7E53CE21691AB073D9660D615818899_1000195400; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1000195400 = varB4EAC82CA7396A68D541C85D26508E83_1709322954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1000195400 = varB4EAC82CA7396A68D541C85D26508E83_802392464;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1000195400.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1000195400;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.799 -0400", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "F6D11285581F56F03463A732C0FFEFBA")
    public long getEarliestCreateTime() {
        List l;
        long time;
        time = Long.MAX_VALUE;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_736008835 = (l.size() == 0);
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1286197052 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1286197052;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.800 -0400", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "0CD5CDA9A7F0594ABD01CDE19827FBC3")
    public long getEarliestConnectTime() {
        long time;
        time = Long.MAX_VALUE;
        List l;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_1807172493 = (l.size() == 0);
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_718856906 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_718856906;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.811 -0400", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "07E34726E19B564E6A8DE7CE7F47B67C")
    public boolean isDialingOrAlerting() {
        boolean var4891BE681B8E73045981C6F526C7E15A_1639534408 = (getState().isDialing());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110616215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110616215;
        // ---------- Original Method ----------
        //return getState().isDialing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.811 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "8FD419D1EA9695104DC6C90A8333C1BF")
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_1754934068 = (getState().isRinging());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865522401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_865522401;
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.813 -0400", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "E48DEA1359EF82B51AB0A45C23EA4974")
    public Connection getLatestConnection() {
        Connection varB4EAC82CA7396A68D541C85D26508E83_1499922674 = null; //Variable for return #1
        Connection varB4EAC82CA7396A68D541C85D26508E83_1909088710 = null; //Variable for return #2
        List l;
        l = getConnections();
        {
            boolean var1A9DA883DBC13D58FC54AA1FCA7E70FB_201928159 = (l.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1499922674 = null;
            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1909088710 = latest;
        Connection varA7E53CE21691AB073D9660D615818899_1679580625; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1679580625 = varB4EAC82CA7396A68D541C85D26508E83_1499922674;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1679580625 = varB4EAC82CA7396A68D541C85D26508E83_1909088710;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1679580625.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1679580625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.814 -0400", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "F1FE712C3B853A584E76834110FB32CC")
    public boolean isGeneric() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1418809927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1418809927;
        // ---------- Original Method ----------
        //return isGeneric;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.814 -0400", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "514423FE597FCFBA9E7023F2C6BFEFDF")
    public void setGeneric(boolean generic) {
        isGeneric = generic;
        // ---------- Original Method ----------
        //isGeneric = generic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.819 -0400", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "53F62A77EC0F0DE7772013B6A5CCDB51")
    public void hangupIfAlive() {
        {
            boolean var9E19D3C659A4F7F587B0E2ED224F58BA_1766007293 = (getState().isAlive());
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

