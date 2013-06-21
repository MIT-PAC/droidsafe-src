package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class Connection {
    Object userData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.802 -0400", hash_original_method = "F7537526BDBAE098BDB45EAA1AFC2E53", hash_generated_method = "F7537526BDBAE098BDB45EAA1AFC2E53")
        public Connection ()
    {
    }


    public abstract String getAddress();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.802 -0400", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "E093180044F919D04A253EBBC0447EED")
    @DSModeled(DSC.SAFE)
    public String getCnapName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.802 -0400", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "4CC91AFB3A186513B5575ADE57E90151")
    @DSModeled(DSC.SAFE)
    public String getOrigDialString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.802 -0400", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "60618AF6371CA5903A0716F1B9102013")
    @DSModeled(DSC.SAFE)
    public int getCnapNamePresentation() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.803 -0400", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "6DFB326426D372C6CD0EBF906C731EAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call.State getState() {
        Call c;
        c = getCall();
        {
            Call.State var494FB6DC3B9EE1DFE2032171ED07A7FC_185676812 = (c.getState());
        } //End block
        return (Call.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Call c;
        //c = getCall();
        //if (c == null) {
            //return Call.State.IDLE;
        //} else {
            //return c.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.803 -0400", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "A6B07FA58558B7D718976B98F04DDC6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAlive() {
        boolean varCBB99CBE92B42C6B5CF33515B6DC2D0A_13705054 = (getState().isAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.804 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "D78EB20431B7E458CF3B73774CAB4430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_161118476 = (getState().isRinging());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.804 -0400", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "80966A2533B3389EEF23F59E3A1E52F4")
    @DSModeled(DSC.SAFE)
    public Object getUserData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.804 -0400", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "B90D31E158BFFB08571D4A5950834F90")
    @DSModeled(DSC.SAFE)
    public void setUserData(Object userdata) {
        dsTaint.addTaint(userdata.dsTaint);
        // ---------- Original Method ----------
        //this.userData = userdata;
    }

    
    public abstract void hangup() throws CallStateException;

    
    public abstract void separate() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.804 -0400", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "6791C272C5B27827C93CE851BE8811EA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.806 -0400", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "97F2D35357783CB5C4627E0A0D3DE7FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder str;
        str = new StringBuilder(128);
        {
            boolean var41DDA978D177BB6D9A9F84ED4EF8C052_1054247859 = (Log.isLoggable(LOG_TAG, Log.DEBUG));
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
        String varCDF926920844FBB113EB20FEB0C3BED9_374342781 = (str.toString());
        return dsTaint.getTaintString();
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

    
    public static int PRESENTATION_ALLOWED = 1;
    public static int PRESENTATION_RESTRICTED = 2;
    public static int PRESENTATION_UNKNOWN = 3;
    public static int PRESENTATION_PAYPHONE = 4;
    private static String LOG_TAG = "TelephonyConnection";
}

