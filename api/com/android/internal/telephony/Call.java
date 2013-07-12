package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;
import android.util.Log;

public abstract class Call {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.980 -0400", hash_original_field = "1A5BE9871FF7E0AB5805D64E8617FA11", hash_generated_field = "682AB4A75DC1B6B1A2EFDFBB9B599B89")

    public State state = State.IDLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.980 -0400", hash_original_field = "145F45FAD3D9A65F2E45DF93DC09017A", hash_generated_field = "508CDFD163A234BDAF6D1151B8AC029E")

    protected boolean isGeneric = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.980 -0400", hash_original_field = "2C3C4BA0AA1A67B454D055C30572EBF9", hash_generated_field = "548675245A66AB01BBAEC34E10E70E57")

    protected final String LOG_TAG = "Call";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.981 -0400", hash_original_method = "CB9B9DF7FC21F16DE5B641A13D14D68A", hash_generated_method = "CB9B9DF7FC21F16DE5B641A13D14D68A")
    public Call ()
    {
        
    }


    public abstract List<Connection> getConnections();

    
    public abstract Phone getPhone();

    
    public abstract boolean isMultiparty();

    
    public abstract void hangup() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.981 -0400", hash_original_method = "2FDAA23821BA4C24A2BE1E56579DB7F5", hash_generated_method = "24BC1DE65E00A0667DA006B0B6A230B5")
    public boolean hasConnection(Connection c) {
        addTaint(c.getTaint());
        boolean var1168F189F58E3D4181DDE034FBA7C215_1935322706 = (c.getCall() == this);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445440294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445440294;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.982 -0400", hash_original_method = "2C555626402D649349C7BBEAA2F56B58", hash_generated_method = "731BCA96425C23FC58318524BA009299")
    public boolean hasConnections() {
        List connections = getConnections();
    if(connections == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_938654560 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312047188 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_312047188;
        } 
        boolean var7131198802DA91AA759B575093AA1237_2046474623 = (connections.size() > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805104358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805104358;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.982 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "E37E3535EA07F9390B9991812880AF11")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1336782150 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1336782150.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1336782150;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.982 -0400", hash_original_method = "647027C18C356B0A148CD756E9A6C1F9", hash_generated_method = "8B321507C3C644570A239ECAD7CFFD2D")
    public boolean isIdle() {
        boolean var61C8D6A3C0D4E365494B575547857403_1228081488 = (!getState().isAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345350865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345350865;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.984 -0400", hash_original_method = "EADA1B2297DA3CAB3CFE5B591670DF74", hash_generated_method = "46AC74F1AC1E69A6C38C4BC1C9E5AD33")
    public Connection getEarliestConnection() {
        List l;
        long time = Long.MAX_VALUE;
        Connection c;
        Connection earliest = null;
        l = getConnections();
    if(l.size() == 0)        
        {
Connection var540C13E9E156B687226421B24F2DF178_134869534 =             null;
            var540C13E9E156B687226421B24F2DF178_134869534.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_134869534;
        } 
for(int i = 0, s = l.size();i < s;i++)
        {
            c = (Connection) l.get(i);
            long t;
            t = c.getCreateTime();
    if(t < time)            
            {
                earliest = c;
                time = t;
            } 
        } 
Connection var08C156C8405B8BDA5372F9AB088F4AC3_159494240 =         earliest;
        var08C156C8405B8BDA5372F9AB088F4AC3_159494240.addTaint(taint);
        return var08C156C8405B8BDA5372F9AB088F4AC3_159494240;
        
        
        
        
        
        
        
            
        
        
            
            
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.985 -0400", hash_original_method = "259AE56D0CCB8C7D336EA51014BAFBD4", hash_generated_method = "A239AED289AC6F0DD038C4A51EE2F88E")
    public long getEarliestCreateTime() {
        List l;
        long time = Long.MAX_VALUE;
        l = getConnections();
    if(l.size() == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1747670163 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_754797891 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_754797891;
        } 
for(int i = 0, s = l.size();i < s;i++)
        {
            Connection c = (Connection) l.get(i);
            long t;
            t = c.getCreateTime();
            time = t < time ? t : time;
        } 
        long var07CC694B9B3FC636710FA08B6922C42B_1754585091 = (time);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1141973508 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1141973508;
        
        
        
        
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.986 -0400", hash_original_method = "4FCBF4743EBF22DA857FFD7B3BA209EB", hash_generated_method = "8CE4E8C21184F555493CBED06E25FCD2")
    public long getEarliestConnectTime() {
        long time = Long.MAX_VALUE;
        List l = getConnections();
    if(l.size() == 0)        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_1509915172 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_700360845 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_700360845;
        } 
for(int i = 0, s = l.size();i < s;i++)
        {
            Connection c = (Connection) l.get(i);
            long t;
            t = c.getConnectTime();
            time = t < time ? t : time;
        } 
        long var07CC694B9B3FC636710FA08B6922C42B_1099701526 = (time);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_646099191 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_646099191;
        
        
        
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.986 -0400", hash_original_method = "0639B31F7C82A2CFB39F855F1440727E", hash_generated_method = "EB1101888A79890A3CF1F883C9835C7C")
    public boolean isDialingOrAlerting() {
        boolean var34F2B9FD0C38D520E0A06319B251A34B_631789495 = (getState().isDialing());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234482187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234482187;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.986 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "2E5834732FB99A85C66E51E9014689A1")
    public boolean isRinging() {
        boolean varE5A9397BC8DB5D2D7096BFF8E63CC3A1_40332383 = (getState().isRinging());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1898799769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1898799769;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.987 -0400", hash_original_method = "D3D12A7045E5E26EBF89650CB45460A7", hash_generated_method = "28C50AC794742F9948887712C824B29D")
    public Connection getLatestConnection() {
        List l = getConnections();
    if(l.size() == 0)        
        {
Connection var540C13E9E156B687226421B24F2DF178_1256448146 =             null;
            var540C13E9E156B687226421B24F2DF178_1256448146.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1256448146;
        } 
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
            } 
        } 
Connection varDEE35CB9DB0BFEF9D56920E04FD88CE7_1694810233 =         latest;
        varDEE35CB9DB0BFEF9D56920E04FD88CE7_1694810233.addTaint(taint);
        return varDEE35CB9DB0BFEF9D56920E04FD88CE7_1694810233;
        
        
        
            
        
        
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.987 -0400", hash_original_method = "26476B959AA4096CC4669AF0A1E29ED1", hash_generated_method = "D6252F568DA99D53DC4E80E776F76B2A")
    public boolean isGeneric() {
        boolean varF023E590C1EFC66385B243FFA97DE5FF_1782335090 = (isGeneric);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_652939701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_652939701;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.988 -0400", hash_original_method = "3EA9E9B35830CEB0D3B80D105DCC59E2", hash_generated_method = "514423FE597FCFBA9E7023F2C6BFEFDF")
    public void setGeneric(boolean generic) {
        isGeneric = generic;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.988 -0400", hash_original_method = "595BC30A45DB7D292DF19DA7A823683F", hash_generated_method = "0D68816A75687EB3E8BD81C8D179F1F1")
    public void hangupIfAlive() {
    if(getState().isAlive())        
        {
            try 
            {
                hangup();
            } 
            catch (CallStateException ex)
            {
            } 
        } 
        
        
            
                
            
                
            
        
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

