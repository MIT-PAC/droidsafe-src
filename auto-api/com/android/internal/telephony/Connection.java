package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class Connection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.900 -0400", hash_original_field = "56491F2E1C74898E18BB6E47D2425B19", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.900 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
    public Connection ()
    {
        //Synthesized constructor
    }


    public abstract String getAddress();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.959 -0400", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "6B400D2661782E46E5A26D3C9A561A80")
    public String getCnapName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1765473085 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1765473085 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1765473085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1765473085;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.960 -0400", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "192FED54B8A65AF1BD74F977F4E61EE6")
    public String getOrigDialString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2027554711 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2027554711 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2027554711.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2027554711;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.960 -0400", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "BD4C4105519D496C3E949B87A7B250C9")
    public int getCnapNamePresentation() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103817762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103817762;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.967 -0400", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "B08C487725EEED387599AAD50F48E182")
    public Call.State getState() {
        Call.State varB4EAC82CA7396A68D541C85D26508E83_732304207 = null; //Variable for return #1
        Call.State varB4EAC82CA7396A68D541C85D26508E83_197791759 = null; //Variable for return #2
        Call c;
        c = getCall();
        {
            varB4EAC82CA7396A68D541C85D26508E83_732304207 = Call.State.IDLE;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_197791759 = c.getState();
        } //End block
        Call.State varA7E53CE21691AB073D9660D615818899_1675224821; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1675224821 = varB4EAC82CA7396A68D541C85D26508E83_732304207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1675224821 = varB4EAC82CA7396A68D541C85D26508E83_197791759;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1675224821.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1675224821;
        // ---------- Original Method ----------
        //Call c;
        //c = getCall();
        //if (c == null) {
            //return Call.State.IDLE;
        //} else {
            //return c.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.967 -0400", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "EDE17307E2D3E437EAEC91A19BEBAC5E")
    public boolean isAlive() {
        boolean varCBB99CBE92B42C6B5CF33515B6DC2D0A_605683374 = (getState().isAlive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735308790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_735308790;
        // ---------- Original Method ----------
        //return getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.968 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "5FC3AEF6C9867EBB2A92BDC3616EC88A")
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_1727499457 = (getState().isRinging());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316102679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316102679;
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.968 -0400", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "8E1A44CD9E8DF6CB8CAA6984B765C042")
    public Object getUserData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_977314385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_977314385 = userData;
        varB4EAC82CA7396A68D541C85D26508E83_977314385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_977314385;
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.982 -0400", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "DA96F33A9905D9C28F1D373D4DFB95DB")
    public void setUserData(Object userdata) {
        this.userData = userdata;
        // ---------- Original Method ----------
        //this.userData = userdata;
    }

    
    public abstract void hangup() throws CallStateException;

    
    public abstract void separate() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.983 -0400", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "6791C272C5B27827C93CE851BE8811EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "8A0C247E9999511E926C8E03D2BDE645")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_10127389 = null; //Variable for return #1
        StringBuilder str;
        str = new StringBuilder(128);
        {
            boolean var41DDA978D177BB6D9A9F84ED4EF8C052_243702194 = (Log.isLoggable(LOG_TAG, Log.DEBUG));
            {
                str.append("addr: " + getAddress())
                    .append(" pres.: " + getNumberPresentation())
                    .append(" dial: " + getOrigDialString())
                    .append(" postdial: " + getRemainingPostDialString())
                    .append(" cnap name: " + getCnapName())
                    .append("(" + getCnapNamePresentation() + ")");
            } //End block
        } //End collapsed parenthetic
        str.append(" incoming: " + isIncoming())
                .append(" state: " + getState())
                .append(" post dial state: " + getPostDialState());
        varB4EAC82CA7396A68D541C85D26508E83_10127389 = str.toString();
        varB4EAC82CA7396A68D541C85D26508E83_10127389.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_10127389;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_field = "1E2B855B487D599657DAAFA5EF7F1A8F", hash_generated_field = "2944D6D43F9722429002C93372937A63")

    public static int PRESENTATION_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_field = "6F9C9F51A277FDA72AC9DEC8D2DCE0ED", hash_generated_field = "DC5FE1F1D0B2E2EB594EDB52A7E72820")

    public static int PRESENTATION_RESTRICTED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_field = "95679F9EBE963CDF1B8DD29DB6E9C71D", hash_generated_field = "D9CB1D4D6380800A47967F2876260731")

    public static int PRESENTATION_UNKNOWN = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_field = "2D5A2D97E466FB2A4D8BB3F684AD4EC0", hash_generated_field = "9E985EF00A943E841C1AE4F8F26CFDF8")

    public static int PRESENTATION_PAYPHONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.985 -0400", hash_original_field = "581F2506941CB0D80E71187F5533B5B1", hash_generated_field = "AB451A1790C4E4E4C5C7D334B79A3916")

    private static String LOG_TAG = "TelephonyConnection";
}

