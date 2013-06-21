package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;
import android.net.sip.SipAudioCall;
import android.os.SystemClock;
import android.util.Log;
import android.telephony.PhoneNumberUtils;

abstract class SipConnectionBase extends Connection {
    private SipAudioCall mSipAudioCall;
    private String dialString;
    private String postDialString;
    private int nextPostDialChar;
    private boolean isIncoming;
    private long createTime;
    private long connectTime;
    private long disconnectTime;
    private long connectTimeReal;
    private long duration = -1L;
    private long holdingStartTime;
    private DisconnectCause mCause = DisconnectCause.NOT_DISCONNECTED;
    private PostDialState postDialState = PostDialState.NOT_STARTED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.186 -0400", hash_original_method = "D12ADA666E21FFAC81BC845F1B1B388F", hash_generated_method = "639CD4E88CAE94859556EEDF8BFC6F57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SipConnectionBase(String dialString) {
        dsTaint.addTaint(dialString);
        postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        isIncoming = false;
        createTime = System.currentTimeMillis();
        // ---------- Original Method ----------
        //this.dialString = dialString;
        //postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        //isIncoming = false;
        //createTime = System.currentTimeMillis();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.189 -0400", hash_original_method = "9D87CB1ACC156683FA215308BE25D1D9", hash_generated_method = "94D969ACE90B655C611974F6E85C7A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setState(Call.State state) {
        dsTaint.addTaint(state.dsTaint);
        //Begin case ACTIVE 
        {
            connectTimeReal = SystemClock.elapsedRealtime();
            connectTime = System.currentTimeMillis();
        } //End block
        //End case ACTIVE 
        //Begin case DISCONNECTED 
        duration = getDurationMillis();
        //End case DISCONNECTED 
        //Begin case DISCONNECTED 
        disconnectTime = System.currentTimeMillis();
        //End case DISCONNECTED 
        //Begin case HOLDING 
        holdingStartTime = SystemClock.elapsedRealtime();
        //End case HOLDING 
        // ---------- Original Method ----------
        //switch (state) {
            //case ACTIVE:
                //if (connectTime == 0) {
                    //connectTimeReal = SystemClock.elapsedRealtime();
                    //connectTime = System.currentTimeMillis();
                //}
                //break;
            //case DISCONNECTED:
                //duration = getDurationMillis();
                //disconnectTime = System.currentTimeMillis();
                //break;
            //case HOLDING:
                //holdingStartTime = SystemClock.elapsedRealtime();
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.190 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "F53590FDAA675305D1DD3BBA4D01F4D4")
    @DSModeled(DSC.SAFE)
    @Override
    public long getCreateTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.190 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "BD7CDFC6540886D375F3A5C1EA8E3034")
    @DSModeled(DSC.SAFE)
    @Override
    public long getConnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.190 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "87C2A1FB7FA89F6C5365FD0FDBFDCF2B")
    @DSModeled(DSC.SAFE)
    @Override
    public long getDisconnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.193 -0400", hash_original_method = "8E0034C90F1E75659D16C0CDCE6F5793", hash_generated_method = "21A6CC8D56E522EFDAD7F5186C0E5B3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_1076353173 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration < 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.193 -0400", hash_original_method = "2CFF5FB4AC83B238AC9B892D795EB1DE", hash_generated_method = "BCA3F922E110DD277E7F91235C9770F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public long getHoldDurationMillis() {
        {
            boolean var65303E1BDDCE597941A633CC414B8ACE_6186976 = (getState() != Call.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_850876270 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (getState() != Call.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.193 -0400", hash_original_method = "28455B27DA94996FB17C07BF72898FB4", hash_generated_method = "9F6922638241E4B89619B999AB052182")
    @DSModeled(DSC.SAFE)
    @Override
    public DisconnectCause getDisconnectCause() {
        return (DisconnectCause)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.194 -0400", hash_original_method = "04AFA3AB4AAFB99A0A1522AC045EFCCB", hash_generated_method = "052C427261C10A61E11E8F761A7F4F23")
    @DSModeled(DSC.SAFE)
     void setDisconnectCause(DisconnectCause cause) {
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
        //mCause = cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.194 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "40DF77FEB8231DDE8FBE4D5F801A7A68")
    @DSModeled(DSC.SAFE)
    @Override
    public PostDialState getPostDialState() {
        return (PostDialState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.195 -0400", hash_original_method = "0751315CA6FC4E16145F947C7FEC6A28", hash_generated_method = "BB3C4E9784C28AF1655F838F726D7EED")
    @DSModeled(DSC.SAFE)
    @Override
    public void proceedAfterWaitChar() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.196 -0400", hash_original_method = "1CC81519C3754B491F6AACE2E776B1AA", hash_generated_method = "D47144307E2536C902F99BF841304BCE")
    @DSModeled(DSC.SAFE)
    @Override
    public void proceedAfterWildChar(String str) {
        dsTaint.addTaint(str);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.197 -0400", hash_original_method = "A990DB72552DFD3D94264491EEB59CEC", hash_generated_method = "34D7B16591BBD4AA8BCBE387281F2D17")
    @DSModeled(DSC.SAFE)
    @Override
    public void cancelPostDial() {
        // ---------- Original Method ----------
    }

    
    protected abstract Phone getPhone();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.198 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "5F25FBABCAB1C57DD5FBFE3B135C3CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getRemainingPostDialString() {
        {
            boolean varCBE29C650BD63B7D36FF87F87B8A05C3_1497865778 = (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar);
        } //End collapsed parenthetic
        String var52C9357568FD82A03712A00BCB4BC900_1498908928 = (postDialString.substring(nextPostDialChar));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
            //|| postDialState == PostDialState.COMPLETE
            //|| postDialString == null
            //|| postDialString.length() <= nextPostDialChar) {
            //return "";
        //}
        //return postDialString.substring(nextPostDialChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.198 -0400", hash_original_method = "780D5AE6347C99C37A99BA1F1D4E1D8E", hash_generated_method = "9F379E9C6A5ACEB0B8AC1F18C3B63200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[SipConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SipConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.198 -0400", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "15A583D18305CA197A26A69A2B43151A")
    @DSModeled(DSC.SAFE)
    @Override
    public int getNumberPresentation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Connection.PRESENTATION_ALLOWED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.198 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "57050A85BCEB502EAD33C56980557185")
    @DSModeled(DSC.SAFE)
    @Override
    public UUSInfo getUUSInfo() {
        return (UUSInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    private static final String LOG_TAG = "SIP_CONN";
}

