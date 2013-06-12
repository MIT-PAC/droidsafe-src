package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;

public abstract class Connection {
    public static int PRESENTATION_ALLOWED = 1;
    public static int PRESENTATION_RESTRICTED = 2;
    public static int PRESENTATION_UNKNOWN = 3;
    public static int PRESENTATION_PAYPHONE = 4;
    private static String LOG_TAG = "TelephonyConnection";
    Object userData;
    
    public abstract String getAddress();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "4A95D59E906B108C9226F213328F4341")
    @DSModeled(DSC.SAFE)
    public String getCnapName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "5E964AC6A9ED6CD9FEAC257802EC6048")
    @DSModeled(DSC.SAFE)
    public String getOrigDialString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "7B3BF7D957C5B0D58BBA763BC089D1CA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "E188F9D2E18A55A535A793D6A2674DD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Call.State getState() {
        Call c;
        c = getCall();
        {
            Call.State var494FB6DC3B9EE1DFE2032171ED07A7FC_1914804960 = (c.getState());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "11B5377EB3AF88913E3C1B5CC1F3128B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAlive() {
        boolean varCBB99CBE92B42C6B5CF33515B6DC2D0A_196329775 = (getState().isAlive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isAlive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "E41D1C18AA48394C76DA291A0D37A51B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isRinging() {
        boolean varA5B5B8E5598F4DA7A9B0210CD17D8F3C_1091655724 = (getState().isRinging());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getState().isRinging();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "1D27128CC4B38816D12273603048045D")
    @DSModeled(DSC.SAFE)
    public Object getUserData() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return userData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "11808F01F3C268AF230AD628E6206C80")
    @DSModeled(DSC.SAFE)
    public void setUserData(Object userdata) {
        dsTaint.addTaint(userdata.dsTaint);
        // ---------- Original Method ----------
        //this.userData = userdata;
    }

    
    public abstract void hangup() throws CallStateException;

    
    public abstract void separate() throws CallStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "4D8826580318E8A08A7F46F6D7C32FE4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.744 -0400", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "7AF25E06C0E717A563D6621D18149296")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder str;
        str = new StringBuilder(128);
        {
            boolean var41DDA978D177BB6D9A9F84ED4EF8C052_177281831 = (Log.isLoggable(LOG_TAG, Log.DEBUG));
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
        String varCDF926920844FBB113EB20FEB0C3BED9_607502728 = (str.toString());
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

    
}


