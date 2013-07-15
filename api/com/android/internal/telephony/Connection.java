package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;

public abstract class Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.190 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.190 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
    public Connection ()
    {
        //Synthesized constructor
    }


    public abstract String getAddress();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.190 -0400", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "2053269B1DE259C170699FD7C45B086A")
    public String getCnapName() {
String var540C13E9E156B687226421B24F2DF178_1468343352 =         null;
        var540C13E9E156B687226421B24F2DF178_1468343352.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1468343352;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.190 -0400", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "2610E815C854724C6E644B5A42385214")
    public String getOrigDialString() {
String var540C13E9E156B687226421B24F2DF178_533871726 =         null;
        var540C13E9E156B687226421B24F2DF178_533871726.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_533871726;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.191 -0400", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "F9F94B7C5743935E0D390ADC84C13156")
    public int getCnapNamePresentation() {
        int varCFCD208495D565EF66E7DFF9F98764DA_96718879 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538858346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538858346;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public abstract Call getCall();

    
    public abstract long getCreateTime();

    
    public abstract long getConnectTime();

    
    public abstract long getDisconnectTime();

    
    public abstract long getDurationMillis();

    
    public abstract long getHoldDurationMillis();

    
    public abstract DisconnectCause getDisconnectCause();

    
    public abstract boolean isIncoming();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.193 -0400", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "DAF98ECFD833040365B25C795677FE1F")
    public Call.State getState() {
        Call c;
        c = getCall();
    if(c == null)        
        {
Call.State varFE024FD31643F7C6DFE624852D2887B2_424989496 =             Call.State.IDLE;
            varFE024FD31643F7C6DFE624852D2887B2_424989496.addTaint(taint);
            return varFE024FD31643F7C6DFE624852D2887B2_424989496;
        } //End block
        else
        {
Call.State varB35ECCCBCBE811C03907584456C32BD3_927868199 =             c.getState();
            varB35ECCCBCBE811C03907584456C32BD3_927868199.addTaint(taint);
            return varB35ECCCBCBE811C03907584456C32BD3_927868199;
        } //End block
        // ---------- Original Method ----------
        //Call c;
        //c = getCall();
        //if (c == null) {
            //return Call.State.IDLE;
        //} else {
            //return c.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.193 -0400", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "DF11FE5328FC7BAFA252AAF23B835233")
    public boolean isAlive() {
        boolean varE6F07A787781536ED97E7FF34498F89F_703642500 = (getState().isAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106442992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106442992;
        // ---------- Original Method ----------
        //return getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.194 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "667D731DA1BF53CDBCD65C4CD5C7892A")
    public boolean isRinging() {
        boolean varE5A9397BC8DB5D2D7096BFF8E63CC3A1_1641313482 = (getState().isRinging());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380981111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380981111;
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.194 -0400", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "3FE49831D46C682F36DA5DD87D2F172A")
    public Object getUserData() {
Object var9007C9FCC94862CF7404FC37365C2BDF_677848448 =         userData;
        var9007C9FCC94862CF7404FC37365C2BDF_677848448.addTaint(taint);
        return var9007C9FCC94862CF7404FC37365C2BDF_677848448;
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.194 -0400", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "DA96F33A9905D9C28F1D373D4DFB95DB")
    public void setUserData(Object userdata) {
        this.userData = userdata;
        // ---------- Original Method ----------
        //this.userData = userdata;
    }

    
    public abstract void hangup() throws CallStateException;

    
    public abstract void separate() throws CallStateException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.195 -0400", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "6791C272C5B27827C93CE851BE8811EA")
    public void clearUserData() {
        userData = null;
        // ---------- Original Method ----------
        //userData = null;
    }

    
    public abstract PostDialState getPostDialState();

    
    public abstract String getRemainingPostDialString();

    
    public abstract void proceedAfterWaitChar();

    
    public abstract void proceedAfterWildChar(String str);

    
    public abstract void cancelPostDial();

    
    public abstract int getNumberPresentation();

    
    public abstract UUSInfo getUUSInfo();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.197 -0400", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "D7742D70C120ECA4C36C9DCAA6B7F46C")
    public String toString() {
        StringBuilder str = new StringBuilder(128);
    if(Log.isLoggable(LOG_TAG, Log.DEBUG))        
        {
            str.append("addr: " + getAddress())
                    .append(" pres.: " + getNumberPresentation())
                    .append(" dial: " + getOrigDialString())
                    .append(" postdial: " + getRemainingPostDialString())
                    .append(" cnap name: " + getCnapName())
                    .append("(" + getCnapNamePresentation() + ")");
        } //End block
        str.append(" incoming: " + isIncoming())
                .append(" state: " + getState())
                .append(" post dial state: " + getPostDialState());
String var24D7484D779E22452A6C5FBC9AEC25FA_1750623617 =         str.toString();
        var24D7484D779E22452A6C5FBC9AEC25FA_1750623617.addTaint(taint);
        return var24D7484D779E22452A6C5FBC9AEC25FA_1750623617;
        // ---------- Original Method ----------
        //StringBuilder str = new StringBuilder(128);
        //if (Log.isLoggable(LOG_TAG, Log.DEBUG)) {
            //str.append("addr: " + getAddress())
                    //.append(" pres.: " + getNumberPresentation())
                    //.append(" dial: " + getOrigDialString())
                    //.append(" postdial: " + getRemainingPostDialString())
                    //.append(" cnap name: " + getCnapName())
                    //.append("(" + getCnapNamePresentation() + ")");
        //}
        //str.append(" incoming: " + isIncoming())
                //.append(" state: " + getState())
                //.append(" post dial state: " + getPostDialState());
        //return str.toString();
    }

    
    public enum DisconnectCause {
        NOT_DISCONNECTED,               
        INCOMING_MISSED,                
        NORMAL,                         
        LOCAL,                          
        BUSY,                           
        CONGESTION,                     
        MMI,                            
        INVALID_NUMBER,                 
        NUMBER_UNREACHABLE,             
        SERVER_UNREACHABLE,             
        INVALID_CREDENTIALS,            
        OUT_OF_NETWORK,                 
        SERVER_ERROR,                   
        TIMED_OUT,                      
        LOST_SIGNAL,
        LIMIT_EXCEEDED,                 
        INCOMING_REJECTED,              
        POWER_OFF,                      
        OUT_OF_SERVICE,                 
        ICC_ERROR,                      
        CALL_BARRED,                    
        FDN_BLOCKED,                    
        CS_RESTRICTED,                  
        CS_RESTRICTED_NORMAL,           
        CS_RESTRICTED_EMERGENCY,        
        UNOBTAINABLE_NUMBER,            
        CDMA_LOCKED_UNTIL_POWER_CYCLE,  
        CDMA_DROP,
        CDMA_INTERCEPT,                 
        CDMA_REORDER,                   
        CDMA_SO_REJECT,                 
        CDMA_RETRY_ORDER,               
        CDMA_ACCESS_FAILURE,
        CDMA_PREEMPTED,
        CDMA_NOT_EMERGENCY,              
        CDMA_ACCESS_BLOCKED,            
        ERROR_UNSPECIFIED
    }

    
    public enum PostDialState {
        NOT_STARTED,    
        STARTED,        
        WAIT,           
        WILD,           
        COMPLETE,       
        CANCELLED,       
        PAUSE           
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.198 -0400", hash_original_field = "1E2B855B487D599657DAAFA5EF7F1A8F", hash_generated_field = "2944D6D43F9722429002C93372937A63")

    public static int PRESENTATION_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.198 -0400", hash_original_field = "6F9C9F51A277FDA72AC9DEC8D2DCE0ED", hash_generated_field = "DC5FE1F1D0B2E2EB594EDB52A7E72820")

    public static int PRESENTATION_RESTRICTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.198 -0400", hash_original_field = "95679F9EBE963CDF1B8DD29DB6E9C71D", hash_generated_field = "D9CB1D4D6380800A47967F2876260731")

    public static int PRESENTATION_UNKNOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.198 -0400", hash_original_field = "2D5A2D97E466FB2A4D8BB3F684AD4EC0", hash_generated_field = "9E985EF00A943E841C1AE4F8F26CFDF8")

    public static int PRESENTATION_PAYPHONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.198 -0400", hash_original_field = "581F2506941CB0D80E71187F5533B5B1", hash_generated_field = "AB451A1790C4E4E4C5C7D334B79A3916")

    private static String LOG_TAG = "TelephonyConnection";
}

