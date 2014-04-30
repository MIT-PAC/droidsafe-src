package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Log;

public abstract class Connection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.330 -0500", hash_original_field = "AF729385361AB0B4287C952B8D880BA4", hash_generated_field = "2944D6D43F9722429002C93372937A63")

    public static int PRESENTATION_ALLOWED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.333 -0500", hash_original_field = "9A205C2BC2B808B34B425DB8BFB452C9", hash_generated_field = "DC5FE1F1D0B2E2EB594EDB52A7E72820")

    public static int PRESENTATION_RESTRICTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.335 -0500", hash_original_field = "74040F5148DB272062165A16A44C032E", hash_generated_field = "D9CB1D4D6380800A47967F2876260731")

    public static int PRESENTATION_UNKNOWN = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.337 -0500", hash_original_field = "D10F790924621230C254F60B5DC76D06", hash_generated_field = "9E985EF00A943E841C1AE4F8F26CFDF8")

    public static int PRESENTATION_PAYPHONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.340 -0500", hash_original_field = "9AD55EDBB606505974CFD56061ACEED2", hash_generated_field = "AB451A1790C4E4E4C5C7D334B79A3916")

    private static String LOG_TAG = "TelephonyConnection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.346 -0500", hash_original_field = "64F9C8FFBF59E1349A604124A0E0710A", hash_generated_field = "64F9C8FFBF59E1349A604124A0E0710A")

    Object userData;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.689 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
    public Connection ()
    {
        //Synthesized constructor
    }

    /* Instance Methods */

    /**
     * Gets address (e.g. phone number) associated with connection.
     * TODO: distinguish reasons for unavailability
     *
     * @return address or null if unavailable
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.348 -0500", hash_original_method = "463155DAD6692D5B7B592B5147CDA452", hash_generated_method = "0D0803E9D74A2F65E4AC3CC4F90BBC35")
    
public abstract String getAddress();

    /**
     * Gets CDMA CNAP name associated with connection.
     * @return cnap name or null if unavailable
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.350 -0500", hash_original_method = "2C38CD1ADD524A252486CD5B36783C9F", hash_generated_method = "977B46BF7C6BECB233470445DAA69B61")
    
public String getCnapName() {
        return null;
    }

    /**
     * Get original dial string.
     * @return original dial string or null if unavailable
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.352 -0500", hash_original_method = "451C5F2C0CC4276FE6380FF80081B9A6", hash_generated_method = "E1B4B45B5D082442182B78D1A2D1DC36")
    
public String getOrigDialString(){
        return null;
    }

    /**
     * Gets CDMA CNAP presentation associated with connection.
     * @return cnap name or null if unavailable
     */

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.355 -0500", hash_original_method = "2E0374E6F9E8D6BE31ABEC176AD57E5E", hash_generated_method = "78A115B1616402C8FA483E3309971C35")
    
public int getCnapNamePresentation() {
       return 0;
    }

    /**
     * @return Call that owns this Connection, or null if none
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.357 -0500", hash_original_method = "BE586F528B18F18AB0603C213246DEEC", hash_generated_method = "B3425FECC55DFD92957BD9906FEF896A")
    
public abstract Call getCall();

    /**
     * Connection create time in currentTimeMillis() format
     * Basically, set when object is created.
     * Effectively, when an incoming call starts ringing or an
     * outgoing call starts dialing
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.360 -0500", hash_original_method = "0094C7B2C7DA3827EC25CEE108F9D719", hash_generated_method = "13CD0BB425FCADF5D54706ACEE2745CA")
    
public abstract long getCreateTime();

    /**
     * Connection connect time in currentTimeMillis() format.
     * For outgoing calls: Begins at (DIALING|ALERTING) -> ACTIVE transition.
     * For incoming calls: Begins at (INCOMING|WAITING) -> ACTIVE transition.
     * Returns 0 before then.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.362 -0500", hash_original_method = "EA713A81F3013421921AFF50C60B2D72", hash_generated_method = "F0FBC58DA65E1535E8664E9B0F04B2E6")
    
public abstract long getConnectTime();

    /**
     * Disconnect time in currentTimeMillis() format.
     * The time when this Connection makes a transition into ENDED or FAIL.
     * Returns 0 before then.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.364 -0500", hash_original_method = "34769166A3E550CB65044289AF6A6CF1", hash_generated_method = "BE5BA068702424419E84A7A402C7AEAB")
    
public abstract long getDisconnectTime();

    /**
     * Returns the number of milliseconds the call has been connected,
     * or 0 if the call has never connected.
     * If the call is still connected, then returns the elapsed
     * time since connect.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.367 -0500", hash_original_method = "8D2EDC3C5A540E34E794CA8886CDDCBF", hash_generated_method = "261788DD668D4BBDEC56DA412B5C7473")
    
public abstract long getDurationMillis();

    /**
     * If this connection is HOLDING, return the number of milliseconds
     * that it has been on hold for (approximately).
     * If this connection is in any other state, return 0.
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.369 -0500", hash_original_method = "5175C91AAA3357B8DB1CAA498B0363B1", hash_generated_method = "E0B2E5F3E6834F9C20882DD8310709CC")
    
public abstract long getHoldDurationMillis();

    /**
     * Returns "NOT_DISCONNECTED" if not yet disconnected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.372 -0500", hash_original_method = "4C1D393A976B3FAAD44E2EFDEDF910B2", hash_generated_method = "906E6EBB48048697B381D1D8F0C923F8")
    
public abstract DisconnectCause getDisconnectCause();

    /**
     * Returns true of this connection originated elsewhere
     * ("MT" or mobile terminated; another party called this terminal)
     * or false if this call originated here (MO or mobile originated).
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.374 -0500", hash_original_method = "3F0CEE47B9175DD512A0C55C0A192A04", hash_generated_method = "9964E5021306AC14E7DD512FB6D64523")
    
public abstract boolean isIncoming();

    /**
     * If this Connection is connected, then it is associated with
     * a Call.
     *
     * Returns getCall().getState() or Call.State.IDLE if not
     * connected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.376 -0500", hash_original_method = "4CE00628B80D46300E7B51FD87FF1859", hash_generated_method = "9B2F4091E14F9F4343848795479B9838")
    
public Call.State getState() {
        Call c;

        c = getCall();

        if (c == null) {
            return Call.State.IDLE;
        } else {
            return c.getState();
        }
    }

    /**
     * isAlive()
     *
     * @return true if the connection isn't disconnected
     * (could be active, holding, ringing, dialing, etc)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.379 -0500", hash_original_method = "A1440D6E1CF31EDB06C1A447FF7580AA", hash_generated_method = "297568258D026FC561894D9991615B1E")
    
public boolean
    isAlive() {
        return getState().isAlive();
    }

    /**
     * Returns true if Connection is connected and is INCOMING or WAITING
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.381 -0500", hash_original_method = "96B3DDBB3E5543868B63A237A2C7B56D", hash_generated_method = "16CC1CFC6180AB1043D126A8812C5EFC")
    
public boolean
    isRinging() {
        return getState().isRinging();
    }

    /**
     *
     * @return the userdata set in setUserData()
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.383 -0500", hash_original_method = "E65D3701CFC74E9E6B255CE6C7739495", hash_generated_method = "2F8A7CB1E20B4B0B7AAD4274D395C82D")
    
public Object getUserData() {
        return userData;
    }

    /**
     *
     * @param userdata user can store an any userdata in the Connection object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.385 -0500", hash_original_method = "02A60C1B56AFD4C316BCBE2C50A969C7", hash_generated_method = "8977E89A6696EFF6551ACDDA106F19EA")
    
public void setUserData(Object userdata) {
        this.userData = userdata;
    }

    /**
     * Hangup individual Connection
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.388 -0500", hash_original_method = "75701B1B375E0F543AC12EA12A4A97FB", hash_generated_method = "A317DEC2810CF43CE258BB1AF0C61528")
    
public abstract void hangup() throws CallStateException;

    /**
     * Separate this call from its owner Call and assigns it to a new Call
     * (eg if it is currently part of a Conference call
     * TODO: Throw exception? Does GSM require error display on failure here?
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.391 -0500", hash_original_method = "4C875AF139C81EE675F9DA949951B018", hash_generated_method = "A9EB43436898418FCB356770A704BE70")
    
public abstract void separate() throws CallStateException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.395 -0500", hash_original_method = "46262E10525A1E414BE5248C4690B238", hash_generated_method = "49F076CF4F73D2C70F41956E4A46CA74")
    
public void clearUserData(){
        userData = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.397 -0500", hash_original_method = "BA8A6818BF8323915F90E25B40B1EC42", hash_generated_method = "C240EE430FBE5A9378C3260B94DFC955")
    
public abstract PostDialState getPostDialState();

    /**
     * Returns the portion of the post dial string that has not
     * yet been dialed, or "" if none
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.400 -0500", hash_original_method = "587CE99BB7FEBC003E2A7D380ABF5F54", hash_generated_method = "4FD52CCF600F54BA37A8D7F93EFB0549")
    
public abstract String getRemainingPostDialString();

    /**
     * See Phone.setOnPostDialWaitCharacter()
     */

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.402 -0500", hash_original_method = "31AF75546DFC3949CB261375B85CB8DE", hash_generated_method = "100208BAA07A3235842CAE38ADA66493")
    
public abstract void proceedAfterWaitChar();
    
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

    /**
     * See Phone.setOnPostDialWildCharacter()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.405 -0500", hash_original_method = "960DE7BF3AB96E89A93E092B3069D99A", hash_generated_method = "B4EB2CC4F2A7AA385AAD7E1FC09B5138")
    
public abstract void proceedAfterWildChar(String str);
    /**
     * Cancel any post
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.407 -0500", hash_original_method = "746E048D2666CCD55B03E27E9F1267A5", hash_generated_method = "8F2D4B9D9E8DD71EA237F93933731C5C")
    
public abstract void cancelPostDial();

    /**
     * Returns the caller id presentation type for incoming and waiting calls
     * @return one of PRESENTATION_*
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.409 -0500", hash_original_method = "D08565902D5E7531CD6EE031895AE87B", hash_generated_method = "D31B1F8B0E2C3993CECD04CB0848FBDA")
    
public abstract int getNumberPresentation();

    /**
     * Returns the User to User Signaling (UUS) information associated with
     * incoming and waiting calls
     * @return UUSInfo containing the UUS userdata.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.411 -0500", hash_original_method = "043AFAE41B2359435CE63B006FA27061", hash_generated_method = "922A9F25FF1ABF048AABC48BB690FA52")
    
public abstract UUSInfo getUUSInfo();

    /**
     * Build a human representation of a connection instance, suitable for debugging.
     * Don't log personal stuff unless in debug mode.
     * @return a string representing the internal state of this connection.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:19.414 -0500", hash_original_method = "81B11B98158DBCB6EBD3953D4E6C7CF3", hash_generated_method = "F9D02C82B1FE8820E8127AA89EF8D779")
    
public String toString() {
        StringBuilder str = new StringBuilder(128);

        if (Log.isLoggable(LOG_TAG, Log.DEBUG)) {
            str.append("addr: " + getAddress())
                    .append(" pres.: " + getNumberPresentation())
                    .append(" dial: " + getOrigDialString())
                    .append(" postdial: " + getRemainingPostDialString())
                    .append(" cnap name: " + getCnapName())
                    .append("(" + getCnapNamePresentation() + ")");
        }
        str.append(" incoming: " + isIncoming())
                .append(" state: " + getState())
                .append(" post dial state: " + getPostDialState());
        return str.toString();
    }
}

