package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;

public abstract class Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.689 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.689 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
    public Connection ()
    {
        //Synthesized constructor
    }


    public abstract String getAddress();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.691 -0400", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "A0BFBAA5E15E22828EC1EFF095DDD9B2")
    public String getCnapName() {
String var540C13E9E156B687226421B24F2DF178_1393502514 =         null;
        var540C13E9E156B687226421B24F2DF178_1393502514.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1393502514;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.691 -0400", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "71E437312CEED40BAF2B24BF12DA3F94")
    public String getOrigDialString() {
String var540C13E9E156B687226421B24F2DF178_1203208709 =         null;
        var540C13E9E156B687226421B24F2DF178_1203208709.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1203208709;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.691 -0400", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "AE61E0F25EBAA53E5379AB5C61E1C6ED")
    public int getCnapNamePresentation() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1468047434 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123646743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2123646743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.694 -0400", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "D3A02F562607BFB2134E939D8763DDBA")
    public Call.State getState() {
        Call c;
        c = getCall();
        if(c == null)        
        {
Call.State varFE024FD31643F7C6DFE624852D2887B2_1371195844 =             Call.State.IDLE;
            varFE024FD31643F7C6DFE624852D2887B2_1371195844.addTaint(taint);
            return varFE024FD31643F7C6DFE624852D2887B2_1371195844;
        } //End block
        else
        {
Call.State varB35ECCCBCBE811C03907584456C32BD3_1046619453 =             c.getState();
            varB35ECCCBCBE811C03907584456C32BD3_1046619453.addTaint(taint);
            return varB35ECCCBCBE811C03907584456C32BD3_1046619453;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.694 -0400", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "C246BEEE32026247FA55299CED9F43D9")
    public boolean isAlive() {
        boolean varE6F07A787781536ED97E7FF34498F89F_1249555429 = (getState().isAlive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_802239701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_802239701;
        // ---------- Original Method ----------
        //return getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.695 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "725CA0EC70DAFB86647F90C49127BFBE")
    public boolean isRinging() {
        boolean varE5A9397BC8DB5D2D7096BFF8E63CC3A1_453858893 = (getState().isRinging());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133027669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133027669;
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.695 -0400", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "207B75643E78647C67E8637A037541AA")
    public Object getUserData() {
Object var9007C9FCC94862CF7404FC37365C2BDF_1547609712 =         userData;
        var9007C9FCC94862CF7404FC37365C2BDF_1547609712.addTaint(taint);
        return var9007C9FCC94862CF7404FC37365C2BDF_1547609712;
        // ---------- Original Method ----------
        //return userData;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.695 -0400", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "DA96F33A9905D9C28F1D373D4DFB95DB")
    public void setUserData(Object userdata) {
        this.userData = userdata;
        // ---------- Original Method ----------
        //this.userData = userdata;
    }

    
    public abstract void hangup() throws CallStateException;

    
    public abstract void separate() throws CallStateException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.697 -0400", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "6791C272C5B27827C93CE851BE8811EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.699 -0400", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "A669F9A9AEDBD0DB9780C4241EAE22D8")
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
String var24D7484D779E22452A6C5FBC9AEC25FA_1525303168 =         str.toString();
        var24D7484D779E22452A6C5FBC9AEC25FA_1525303168.addTaint(taint);
        return var24D7484D779E22452A6C5FBC9AEC25FA_1525303168;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.700 -0400", hash_original_field = "1E2B855B487D599657DAAFA5EF7F1A8F", hash_generated_field = "2944D6D43F9722429002C93372937A63")

    public static int PRESENTATION_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.700 -0400", hash_original_field = "6F9C9F51A277FDA72AC9DEC8D2DCE0ED", hash_generated_field = "DC5FE1F1D0B2E2EB594EDB52A7E72820")

    public static int PRESENTATION_RESTRICTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.700 -0400", hash_original_field = "95679F9EBE963CDF1B8DD29DB6E9C71D", hash_generated_field = "D9CB1D4D6380800A47967F2876260731")

    public static int PRESENTATION_UNKNOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.700 -0400", hash_original_field = "2D5A2D97E466FB2A4D8BB3F684AD4EC0", hash_generated_field = "9E985EF00A943E841C1AE4F8F26CFDF8")

    public static int PRESENTATION_PAYPHONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.700 -0400", hash_original_field = "581F2506941CB0D80E71187F5533B5B1", hash_generated_field = "AB451A1790C4E4E4C5C7D334B79A3916")

    private static String LOG_TAG = "TelephonyConnection";
}

