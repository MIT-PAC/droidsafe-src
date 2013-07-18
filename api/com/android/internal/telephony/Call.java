package com.android.internal.telephony;

// Droidsafe Imports
import java.util.List;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.400 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "682AB4A75DC1B6B1A2EFDFBB9B599B89")

    public State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.400 -0400", hash_original_field = "145F45FAD3D9A65F2E45DF93DC09017A", hash_generated_field = "508CDFD163A234BDAF6D1151B8AC029E")

    protected boolean isGeneric = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.400 -0400", hash_original_field = "2C3C4BA0AA1A67B454D055C30572EBF9", hash_generated_field = "548675245A66AB01BBAEC34E10E70E57")

    protected final String LOG_TAG = "Call";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.400 -0400", hash_original_method = "CB9B9DF7FC21F16DE5B641A13D14D68A", hash_generated_method = "CB9B9DF7FC21F16DE5B641A13D14D68A")
    public Call ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract List<Connection> getConnections();

    
    @DSModeled(DSC.SAFE)
    public abstract Phone getPhone();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isMultiparty();

    
    @DSModeled(DSC.SAFE)
    public abstract void hangup() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.401 -0400", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "A432F0B23FA63583077EF7072F9C8E74")
    public boolean hasConnection(Connection c) {
        addTaint(c.getTaint());
        boolean var1168F189F58E3D4181DDE034FBA7C215_1540727801 = (c.getCall() == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516729554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516729554;
        // ---------- Original Method ----------
        //return c.getCall() == this;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.401 -0400", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "AF31948EE0CC6D2970F09233C997A098")
    public boolean hasConnections() {
        List connections = getConnections();
        if(connections == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_760017514 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755364118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_755364118;
        } //End block
        boolean var7131198802DA91AA759B575093AA1237_628910482 = (connections.size() > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863667956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863667956;
        // ---------- Original Method ----------
        //List connections = getConnections();
        //if (connections == null) {
            //return false;
        //}
        //return connections.size() > 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.401 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "36AED765918A785CA984A1B88A57B154")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_590701294 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_590701294.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_590701294;
        // ---------- Original Method ----------
        //return state;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.402 -0400", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "87F61A60DE801F8CA836BEBD99FA0BEA")
    public boolean isIdle() {
        boolean var61C8D6A3C0D4E365494B575547857403_935213119 = (!getState().isAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319962351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319962351;
        // ---------- Original Method ----------
        //return !getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.402 -0400", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "9248AAB924CF4BDDBA1D7208620F69AE")
    public Connection getEarliestConnection() {
        List l;
        long time = Long.MAX_VALUE;
        Connection c;
        Connection earliest = null;
        l = getConnections();
        if(l.size() == 0)        
        {
Connection var540C13E9E156B687226421B24F2DF178_1610054845 =             null;
            var540C13E9E156B687226421B24F2DF178_1610054845.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1610054845;
        } //End block
for(int i = 0, s = l.size();i < s;i++)
        {
            c = (Connection) l.get(i);
            long t;
            t = c.getCreateTime();
            if(t < time)            
            {
                earliest = c;
                time = t;
            } //End block
        } //End block
Connection var08C156C8405B8BDA5372F9AB088F4AC3_561090970 =         earliest;
        var08C156C8405B8BDA5372F9AB088F4AC3_561090970.addTaint(taint);
        return var08C156C8405B8BDA5372F9AB088F4AC3_561090970;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.402 -0400", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "9A59452D71A1DA1B97F777120E2D5A30")
    public long getEarliestCreateTime() {
        List l;
        long time = Long.MAX_VALUE;
        l = getConnections();
        if(l.size() == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_541807172 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_616781287 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_616781287;
        } //End block
for(int i = 0, s = l.size();i < s;i++)
        {
            Connection c = (Connection) l.get(i);
            long t;
            t = c.getCreateTime();
            time = t < time ? t : time;
        } //End block
        long var07CC694B9B3FC636710FA08B6922C42B_1101410488 = (time);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1058230780 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1058230780;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.403 -0400", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "3641F79E9A74B465E247AF31E77E5998")
    public long getEarliestConnectTime() {
        long time = Long.MAX_VALUE;
        List l = getConnections();
        if(l.size() == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_118055187 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_52163144 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_52163144;
        } //End block
for(int i = 0, s = l.size();i < s;i++)
        {
            Connection c = (Connection) l.get(i);
            long t;
            t = c.getConnectTime();
            time = t < time ? t : time;
        } //End block
        long var07CC694B9B3FC636710FA08B6922C42B_1489948116 = (time);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_651197606 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_651197606;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.403 -0400", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "9660EB084B60FA1CEFE4B79994BC8EA0")
    public boolean isDialingOrAlerting() {
        boolean var34F2B9FD0C38D520E0A06319B251A34B_351587727 = (getState().isDialing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557427760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557427760;
        // ---------- Original Method ----------
        //return getState().isDialing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.403 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "C1A6F1F45ECEF09D758EFE95C6DA91F0")
    public boolean isRinging() {
        boolean varE5A9397BC8DB5D2D7096BFF8E63CC3A1_736909542 = (getState().isRinging());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029895212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029895212;
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.478 -0400", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "EAE04E3DBAB3BCE210DFF1EAE87007ED")
    public Connection getLatestConnection() {
        List l = getConnections();
        if(l.size() == 0)        
        {
Connection var540C13E9E156B687226421B24F2DF178_1179760589 =             null;
            var540C13E9E156B687226421B24F2DF178_1179760589.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1179760589;
        } //End block
        long time = 0;
        Connection latest = null;
for(int i = 0, s = l.size();i < s;i++)
        {
            Connection c = (Connection) l.get(i);
            long t = c.getCreateTime();
            if(t > time)            
            {
                latest = c;
                time = t;
            } //End block
        } //End block
Connection varDEE35CB9DB0BFEF9D56920E04FD88CE7_103872785 =         latest;
        varDEE35CB9DB0BFEF9D56920E04FD88CE7_103872785.addTaint(taint);
        return varDEE35CB9DB0BFEF9D56920E04FD88CE7_103872785;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.478 -0400", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "5D54331D30B7216EC440CD1B03E60221")
    public boolean isGeneric() {
        boolean varF023E590C1EFC66385B243FFA97DE5FF_1431863371 = (isGeneric);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005941163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005941163;
        // ---------- Original Method ----------
        //return isGeneric;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.478 -0400", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "514423FE597FCFBA9E7023F2C6BFEFDF")
    public void setGeneric(boolean generic) {
        isGeneric = generic;
        // ---------- Original Method ----------
        //isGeneric = generic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.478 -0400", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "0D68816A75687EB3E8BD81C8D179F1F1")
    public void hangupIfAlive() {
        if(getState().isAlive())        
        {
            try 
            {
                hangup();
            } //End block
            catch (CallStateException ex)
            {
            } //End block
        } //End block
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
        @DSModeled(DSC.SAFE)
        public boolean isAlive() {
            return !(this == IDLE || this == DISCONNECTED || this == DISCONNECTING);
        }
        @DSModeled(DSC.SAFE)
        public boolean isRinging() {
            return this == INCOMING || this == WAITING;
        }
        @DSModeled(DSC.SAFE)
        public boolean isDialing() {
            return this == DIALING || this == ALERTING;
        }
    }

    
}

