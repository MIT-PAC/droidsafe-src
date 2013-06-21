package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.*;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Log;
import android.text.TextUtils;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import com.android.internal.telephony.TelephonyProperties;

public class CdmaConnection extends Connection {
    CdmaCallTracker owner;
    CdmaCall parent;
    String address;
    String dialString;
    String postDialString;
    boolean isIncoming;
    boolean disconnected;
    String cnapName;
    int index;
    long createTime;
    long connectTime;
    long disconnectTime;
    long connectTimeReal;
    long duration;
    long holdingStartTime;
    int nextPostDialChar;
    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
    PostDialState postDialState = PostDialState.NOT_STARTED;
    int numberPresentation = Connection.PRESENTATION_ALLOWED;
    int cnapNamePresentation  = Connection.PRESENTATION_ALLOWED;
    Handler h;
    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.360 -0400", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "EBB581CECD2E64619EA6C2D42D7C3316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaConnection(Context context, DriverCall dc, CdmaCallTracker ct, int index) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(ct.dsTaint);
        createWakeLock(context);
        acquireWakeLock();
        h = new MyHandler(owner.getLooper());
        address = dc.number;
        isIncoming = dc.isMT;
        createTime = System.currentTimeMillis();
        cnapName = dc.name;
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;
        parent = parentFromDCState (dc.state);
        parent.attach(this, dc);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //address = dc.number;
        //isIncoming = dc.isMT;
        //createTime = System.currentTimeMillis();
        //cnapName = dc.name;
        //cnapNamePresentation = dc.namePresentation;
        //numberPresentation = dc.numberPresentation;
        //this.index = index;
        //parent = parentFromDCState (dc.state);
        //parent.attach(this, dc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.361 -0400", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "FBBD44637E9F76E6CF90BBD66D7FF3A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaConnection(Context context, String dialString, CdmaCallTracker ct, CdmaCall parent) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(dialString);
        dsTaint.addTaint(ct.dsTaint);
        createWakeLock(context);
        acquireWakeLock();
        h = new MyHandler(owner.getLooper());
        Log.d(LOG_TAG, "[CDMAConn] CdmaConnection: dialString=" + dialString);
        dialString = formatDialString(dialString);
        Log.d(LOG_TAG, "[CDMAConn] CdmaConnection:formated dialString=" + dialString);
        this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        index = -1;
        isIncoming = false;
        cnapName = null;
        cnapNamePresentation = Connection.PRESENTATION_ALLOWED;
        numberPresentation = Connection.PRESENTATION_ALLOWED;
        createTime = System.currentTimeMillis();
        {
            {
                parent.attachFake(this, CdmaCall.State.ACTIVE);
            } //End block
            {
                parent.attachFake(this, CdmaCall.State.DIALING);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.361 -0400", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "BD9EAE3AC415B908C9982088BB92DB70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaConnection(Context context, CdmaCallWaitingNotification cw, CdmaCallTracker ct,
            CdmaCall parent) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(cw.dsTaint);
        dsTaint.addTaint(ct.dsTaint);
        createWakeLock(context);
        acquireWakeLock();
        h = new MyHandler(owner.getLooper());
        address = cw.number;
        numberPresentation = cw.numberPresentation;
        cnapName = cw.name;
        cnapNamePresentation = cw.namePresentation;
        index = -1;
        isIncoming = true;
        createTime = System.currentTimeMillis();
        connectTime = 0;
        parent.attachFake(this, CdmaCall.State.WAITING);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //address = cw.number;
        //numberPresentation = cw.numberPresentation;
        //cnapName = cw.name;
        //cnapNamePresentation = cw.namePresentation;
        //index = -1;
        //isIncoming = true;
        //createTime = System.currentTimeMillis();
        //connectTime = 0;
        //this.parent = parent;
        //parent.attachFake(this, CdmaCall.State.WAITING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.361 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
        static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.362 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "64C792D327D68BC978B3315D1C7CB87F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean compareTo(DriverCall c) {
        dsTaint.addTaint(c.dsTaint);
        String cAddress;
        cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean var6A332DE396C17CD19C189EA4D870C286_1749540941 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.362 -0400", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "BD2CA47095B74BEA0DF6AF76C505BDA0")
    @DSModeled(DSC.SAFE)
    public String getOrigDialString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return dialString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.362 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "2DD09D86D550975B55052A6EEF6C3156")
    @DSModeled(DSC.SAFE)
    public String getAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.362 -0400", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "7648F59C8AC76EDDA03F24BBE5D5713C")
    @DSModeled(DSC.SAFE)
    public String getCnapName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return cnapName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.362 -0400", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "C089F84030C3BF843BEA5C8FF5F0512D")
    @DSModeled(DSC.SAFE)
    public int getCnapNamePresentation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return cnapNamePresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "E75164845D1A3149D640618EF6C35CCE")
    @DSModeled(DSC.SAFE)
    public CdmaCall getCall() {
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "757EE1B0AB6C5A5234D521762CBF03D0")
    @DSModeled(DSC.SAFE)
    public long getCreateTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "CE355AC1212A3438732A194E41D7BC33")
    @DSModeled(DSC.SAFE)
    public long getConnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "9494539C3E418CB54E14DB9B543C3B50")
    @DSModeled(DSC.SAFE)
    public long getDisconnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "33E8F461BD1ACC682B5774188F7A5727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_1575410112 = (SystemClock.elapsedRealtime() - connectTimeReal);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (connectTimeReal == 0) {
            //return 0;
        //} else if (duration == 0) {
            //return SystemClock.elapsedRealtime() - connectTimeReal;
        //} else {
            //return duration;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.363 -0400", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "E8F676CFBD02CF0678E63E7D8CB4B6E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getHoldDurationMillis() {
        {
            boolean var3DCCE9B94C5A4DB6DBDF4AE746672EAF_990997730 = (getState() != CdmaCall.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_1679126944 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (getState() != CdmaCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "9FC40A186005F970B1585088DF55868F")
    @DSModeled(DSC.SAFE)
    public DisconnectCause getDisconnectCause() {
        return (DisconnectCause)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "9720E3BA05EE58EFF958F925FE350B15")
    @DSModeled(DSC.SAFE)
    public boolean isIncoming() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "D37BB04DCA1F498DB58659C54363E833")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CdmaCall.State getState() {
        {
            CdmaCall.State var85633779C9C1785ADAF1DE8B686337A0_29815155 = (super.getState());
        } //End block
        return (CdmaCall.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (disconnected) {
            //return CdmaCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "95C25B9F17CBA9FBBFEE5D205D9A3D89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hangup() throws CallStateException {
        {
            owner.hangup(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("disconnected");
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.hangup(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "9EA3AEE9D5903810DE288024DD91C72F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void separate() throws CallStateException {
        {
            owner.separate(this);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("disconnected");
        } //End block
        // ---------- Original Method ----------
        //if (!disconnected) {
            //owner.separate(this);
        //} else {
            //throw new CallStateException ("disconnected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.364 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "97E44C0F5B9A6B70902CBA869C71CF87")
    @DSModeled(DSC.SAFE)
    public PostDialState getPostDialState() {
        return (PostDialState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.365 -0400", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "B5A5F43B2D6BA699B87F1C4A827A83D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceedAfterWaitChar() {
        setPostDialState(PostDialState.STARTED);
        processNextPostDialChar();
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.WAIT) {
            //Log.w(LOG_TAG, "CdmaConnection.proceedAfterWaitChar(): Expected "
                //+ "getPostDialState() to be WAIT but was " + postDialState);
            //return;
        //}
        //setPostDialState(PostDialState.STARTED);
        //processNextPostDialChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.365 -0400", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "260154653D3D3BC94D01D72B6473B79E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceedAfterWildChar(String str) {
        dsTaint.addTaint(str);
        setPostDialState(PostDialState.STARTED);
        {
            boolean playedTone;
            playedTone = false;
            int len;
            len = (str != null ? str.length() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
            {
                int i;
                i = 0;
                {
                    char c;
                    c = str.charAt(i);
                    Message msg;
                    msg = null;
                    {
                        msg = h.obtainMessage(EVENT_DTMF_DONE);
                    } //End block
                    {
                        boolean var3511F6C9B7B285C8848DD8FAF73BEEA8_1649351246 = (PhoneNumberUtils.is12Key(c));
                        {
                            owner.cm.sendDtmf(c, msg);
                            playedTone = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                processNextPostDialChar();
            } //End block
        } //End block
        {
            StringBuilder buf;
            buf = new StringBuilder(str);
            buf.append(postDialString.substring(nextPostDialChar));
            postDialString = buf.toString();
            nextPostDialChar = 0;
            {
                log("proceedAfterWildChar: new postDialString is " +
                        postDialString);
            } //End block
            processNextPostDialChar();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.365 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.365 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
    @DSModeled(DSC.SAFE)
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.366 -0400", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "70ED9E6F2DC614FBEA556A8BDCB6AB47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        dsTaint.addTaint(causeCode);
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        CDMAPhone phone;
        phone = owner.phone;
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        int serviceState;
        serviceState = phone.getServiceState().getState();
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        {
            boolean var5318065248B225746CCB04257EE4FCAF_482428271 = (phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY);
        } //End collapsed parenthetic
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        return (DisconnectCause)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.366 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "79DD08BA84758D04C8F167DB8D5F0A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(causeCode);
        onDisconnect(disconnectCauseFromCode(causeCode));
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.366 -0400", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "49FD6A68142C3E2503BEF0E38D4F508D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cause.dsTaint);
        {
            doDisconnect();
            Log.d(LOG_TAG,
                    "[CDMAConn] onDisconnect: cause=" + cause);
            owner.phone.notifyDisconnect(this);
            {
                parent.connectionDisconnected(this);
            } //End block
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //this.cause = cause;
        //if (!disconnected) {
            //doDisconnect();
            //if (false) Log.d(LOG_TAG,
                    //"[CDMAConn] onDisconnect: cause=" + cause);
            //owner.phone.notifyDisconnect(this);
            //if (parent != null) {
                //parent.connectionDisconnected(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.367 -0400", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "CF8681A9D50E00434CB753048BF5237A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onLocalDisconnect() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            doDisconnect();
            Log.d(LOG_TAG,
                    "[CDMAConn] onLoalDisconnect" );
            {
                parent.detach(this);
            } //End block
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (!disconnected) {
            //doDisconnect();
            //if (false) Log.d(LOG_TAG,
                    //"[CDMAConn] onLoalDisconnect" );
            //if (parent != null) {
                //parent.detach(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.367 -0400", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "593E1214D1A08856C496A0E1FC456AEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean update(DriverCall dc) {
        dsTaint.addTaint(dc.dsTaint);
        CdmaCall newParent;
        boolean changed;
        changed = false;
        boolean wasConnectingInOrOut;
        wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding;
        wasHolding = (getState() == CdmaCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
        log("parent= " +parent +", newParent= " + newParent);
        {
            boolean varE881044A72B93B862D308B06B4E2C746_1453115125 = (!equalsHandlesNulls(address, dc.number));
            {
                log("update: phone # changed!");
                address = dc.number;
                changed = true;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDF66A5F27CBDFB14ABE33A4866161657_1991905412 = (TextUtils.isEmpty(dc.name));
            {
                {
                    boolean var7C19AFEC02610CDDD59D911E3D26C4DA_764939054 = (!TextUtils.isEmpty(cnapName));
                    {
                        changed = true;
                        cnapName = "";
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varF0DFECF36FC63723F9C46BF83DB19F78_986779155 = (!dc.name.equals(cnapName));
                {
                    changed = true;
                    cnapName = dc.name;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        log("--dssds----"+cnapName);
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;
        {
            {
                parent.detach(this);
            } //End block
            newParent.attach(this, dc);
            parent = newParent;
            changed = true;
        } //End block
        {
            boolean parentStateChange;
            parentStateChange = parent.update (this, dc);
            changed = changed || parentStateChange;
        } //End block
        log(
                "Update, wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
        {
            boolean var06589BF74DE5997C8FC534FD1B427681_25209195 = (wasConnectingInOrOut && !isConnectingInOrOut());
            {
                onConnectedInOrOut();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3036BA6BA6AAD044DE061F78357C6B88_1458942097 = (changed && !wasHolding && (getState() == CdmaCall.State.HOLDING));
            {
                onStartedHolding();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.367 -0400", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "22169BE4E2819F9F2B45393E43081B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fakeHoldBeforeDial() {
        {
            parent.detach(this);
        } //End block
        parent = owner.backgroundCall;
        parent.attachFake(this, CdmaCall.State.HOLDING);
        onStartedHolding();
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.detach(this);
        //}
        //parent = owner.backgroundCall;
        //parent.attachFake(this, CdmaCall.State.HOLDING);
        //onStartedHolding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.368 -0400", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "CDE35FAABB3015C663354F54A77878EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getCDMAIndex() throws CallStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("CDMA connection index not assigned");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("CDMA connection index not assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.368 -0400", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "72C1AAD866A2C25266FF38699D7AD211")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onConnectedInOrOut() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        connectTime = System.currentTimeMillis();
        connectTimeReal = SystemClock.elapsedRealtime();
        duration = 0;
        {
            log("onConnectedInOrOut: connectTime=" + connectTime);
        } //End block
        {
            processNextPostDialChar();
        } //End block
        {
            releaseWakeLock();
        } //End block
        // ---------- Original Method ----------
        //connectTime = System.currentTimeMillis();
        //connectTimeReal = SystemClock.elapsedRealtime();
        //duration = 0;
        //if (Phone.DEBUG_PHONE) {
            //log("onConnectedInOrOut: connectTime=" + connectTime);
        //}
        //if (!isIncoming) {
            //processNextPostDialChar();
        //} else {
            //releaseWakeLock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.368 -0400", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "21162B02B62CC3BB8D40FD8D893D1D38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doDisconnect() {
        index = -1;
        disconnectTime = System.currentTimeMillis();
        duration = SystemClock.elapsedRealtime() - connectTimeReal;
        disconnected = true;
        // ---------- Original Method ----------
        //index = -1;
        //disconnectTime = System.currentTimeMillis();
        //duration = SystemClock.elapsedRealtime() - connectTimeReal;
        //disconnected = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.368 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.369 -0400", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "6619F28A5C73698FCD5493C80ABEF86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processPostDialChar(char c) {
        dsTaint.addTaint(c);
        {
            boolean var5BF2C5BE7CCD2082ACD6C3DE182DDC82_1568555989 = (PhoneNumberUtils.is12Key(c));
            {
                owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
            } //End block
            {
                setPostDialState(PostDialState.PAUSE);
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
            } //End block
            {
                setPostDialState(PostDialState.WAIT);
            } //End block
            {
                setPostDialState(PostDialState.WILD);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (PhoneNumberUtils.is12Key(c)) {
            //owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        //} else if (c == PhoneNumberUtils.PAUSE) {
            //setPostDialState(PostDialState.PAUSE);
            //h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            //PAUSE_DELAY_MILLIS);
        //} else if (c == PhoneNumberUtils.WAIT) {
            //setPostDialState(PostDialState.WAIT);
        //} else if (c == PhoneNumberUtils.WILD) {
            //setPostDialState(PostDialState.WILD);
        //} else {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.369 -0400", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "A5A5A498784B719275456B7E320AEFCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRemainingPostDialString() {
        {
            boolean var78E7EE5EE640C52F974C3F3F0E9A201B_1272304571 = (postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar);
        } //End collapsed parenthetic
        String subStr;
        subStr = postDialString.substring(nextPostDialChar);
        {
            int wIndex;
            wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            int pIndex;
            pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
            {
                subStr = subStr.substring(0, wIndex);
            } //End block
            {
                subStr = subStr.substring(0, pIndex);
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
                //|| postDialState == PostDialState.COMPLETE
                //|| postDialString == null
                //|| postDialString.length() <= nextPostDialChar) {
            //return "";
        //}
        //String subStr = postDialString.substring(nextPostDialChar);
        //if (subStr != null) {
            //int wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            //int pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);
            //if (wIndex > 0 && (wIndex < pIndex || pIndex <= 0)) {
                //subStr = subStr.substring(0, wIndex);
            //} else if (pIndex > 0) {
                //subStr = subStr.substring(0, pIndex);
            //}
        //}
        //return subStr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.369 -0400", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "E4490AE1721DC6374C5346C34A73795A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateParent(CdmaCall oldParent, CdmaCall newParent) {
        dsTaint.addTaint(oldParent.dsTaint);
        dsTaint.addTaint(newParent.dsTaint);
        {
            {
                oldParent.detach(this);
            } //End block
            newParent.attachFake(this, CdmaCall.State.ACTIVE);
        } //End block
        // ---------- Original Method ----------
        //if (newParent != oldParent) {
            //if (oldParent != null) {
                //oldParent.detach(this);
            //}
            //newParent.attachFake(this, CdmaCall.State.ACTIVE);
            //parent = newParent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.369 -0400", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "7D061850BDB03CBC602587D1DA6F8B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        {
            boolean varF1FD10BC172E73DC685D38B97B6A381A_1948363134 = (mPartialWakeLock.isHeld());
        } //End collapsed parenthetic
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.370 -0400", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "7DC7FBB0BCF89398F2C0C836F242D3EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processNextPostDialChar() {
        char c;
        c = 0;
        Registrant postDialHandler;
        {
            releaseWakeLock();
        } //End block
        {
            boolean var8A7CFCBE4CC8CF2E3FB4275E7C0B692F_1918704169 = (postDialString == null ||
                postDialString.length() <= nextPostDialChar);
            {
                setPostDialState(PostDialState.COMPLETE);
                releaseWakeLock();
                c = 0;
            } //End block
            {
                boolean isValid;
                setPostDialState(PostDialState.STARTED);
                c = postDialString.charAt(nextPostDialChar++);
                isValid = processPostDialChar(c);
                {
                    h.obtainMessage(EVENT_NEXT_POST_DIAL).sendToTarget();
                } //End block
            } //End block
        } //End collapsed parenthetic
        postDialHandler = owner.phone.mPostDialHandler;
        Message notifyMessage;
        {
            boolean var12510AAE23ED58E74D3CE982EB9B37AD_1577554240 = (postDialHandler != null &&
                (notifyMessage = postDialHandler.messageForRegistrant()) != null);
            {
                PostDialState state;
                state = postDialState;
                AsyncResult ar;
                ar = AsyncResult.forMessage(notifyMessage);
                ar.result = this;
                ar.userObj = state;
                notifyMessage.arg1 = c;
                notifyMessage.sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.370 -0400", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "D5B8EC3A8EC69A2BAFBBF9ED433249F4")
    @DSModeled(DSC.SAFE)
    private boolean isConnectingInOrOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == CdmaCall.State.DIALING
            //|| parent.state == CdmaCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.370 -0400", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "5C86217857B60320DABA5B39759BDEC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CdmaCall parentFromDCState(DriverCall.State state) {
        dsTaint.addTaint(state.dsTaint);
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("illegal call state: " + state);
        //End case default 
        return (CdmaCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //switch (state) {
            //case ACTIVE:
            //case DIALING:
            //case ALERTING:
                //return owner.foregroundCall;
            //case HOLDING:
                //return owner.backgroundCall;
            //case INCOMING:
            //case WAITING:
                //return owner.ringingCall;
            //default:
                //throw new RuntimeException("illegal call state: " + state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.371 -0400", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "0A74AC6CB1C6BFFE0B4E250302682CF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPostDialState(PostDialState s) {
        dsTaint.addTaint(s.dsTaint);
        {
            {
                {
                    boolean var6C6587FD0E036C04321BAEEA5C3E9D65_1633542918 = (mPartialWakeLock.isHeld());
                    {
                        h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                    } //End block
                    {
                        acquireWakeLock();
                    } //End block
                } //End collapsed parenthetic
                Message msg;
                msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            } //End block
        } //End block
        {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        } //End block
        // ---------- Original Method ----------
        //if (s == PostDialState.STARTED ||
                //s == PostDialState.PAUSE) {
            //synchronized (mPartialWakeLock) {
                //if (mPartialWakeLock.isHeld()) {
                    //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                //} else {
                    //acquireWakeLock();
                //}
                //Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                //h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            //}
        //} else {
            //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            //releaseWakeLock();
        //}
        //postDialState = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.371 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "9548152CA08E0E08E5F4D52CC8459CC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createWakeLock(Context context) {
        dsTaint.addTaint(context.dsTaint);
        PowerManager pm;
        pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.371 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.371 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "7DBC0830BEC936E2BFEE2DCDD2FC9DBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseWakeLock() {
        {
            {
                boolean var7AF9E96BF041CFB5FB2EBC225EA829D3_1798149870 = (mPartialWakeLock.isHeld());
                {
                    log("releaseWakeLock");
                    mPartialWakeLock.release();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
        private static boolean isPause(char c) {
        return c == PhoneNumberUtils.PAUSE;
    }

    
        private static boolean isWait(char c) {
        return c == PhoneNumberUtils.WAIT;
    }

    
        private static int findNextPCharOrNonPOrNonWCharIndex(String phoneNumber, int currIndex) {
        boolean wMatched = isWait(phoneNumber.charAt(currIndex));
        int index = currIndex + 1;
        int length = phoneNumber.length();
        while (index < length) {
            char cNext = phoneNumber.charAt(index);
            if (isWait(cNext)) {
                wMatched = true;
            }
            if (!isWait(cNext) && !isPause(cNext)) {
                break;
            }
            index++;
        }
        if ((index < length) && (index > (currIndex + 1))  &&
            ((wMatched == false) && isPause(phoneNumber.charAt(currIndex)))) {
            return (currIndex + 1);
        }
        return index;
    }

    
        private static char findPOrWCharToAppend(String phoneNumber, int currPwIndex, int nextNonPwCharIndex) {
        char c = phoneNumber.charAt(currPwIndex);
        char ret;
        ret = (isPause(c)) ? PhoneNumberUtils.PAUSE : PhoneNumberUtils.WAIT;
        if (nextNonPwCharIndex > (currPwIndex + 1)) {
            ret = PhoneNumberUtils.WAIT;
        }
        return ret;
    }

    
        public static String formatDialString(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        int length = phoneNumber.length();
        StringBuilder ret = new StringBuilder();
        char c;
        int currIndex = 0;
        while (currIndex < length) {
            c = phoneNumber.charAt(currIndex);
            if (isPause(c) || isWait(c)) {
                if (currIndex < length - 1) {
                    int nextIndex = findNextPCharOrNonPOrNonWCharIndex(phoneNumber, currIndex);
                    if (nextIndex < length) {
                        char pC = findPOrWCharToAppend(phoneNumber, currIndex, nextIndex);
                        ret.append(pC);
                        if (nextIndex > (currIndex + 1)) {
                            currIndex = nextIndex - 1;
                        }
                    } else if (nextIndex == length) {
                        currIndex = length - 1;
                    }
                }
            } else {
                ret.append(c);
            }
            currIndex++;
        }
        return PhoneNumberUtils.cdmaCheckAndProcessPlusCode(ret.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.372 -0400", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "10F0E547A5B116A1F69DE9ACA75539F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.372 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "A5F141B90481F1F129EAE84EC9C590DB")
    @DSModeled(DSC.SAFE)
    @Override
    public int getNumberPresentation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.372 -0400", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "57050A85BCEB502EAD33C56980557185")
    @DSModeled(DSC.SAFE)
    @Override
    public UUSInfo getUUSInfo() {
        return (UUSInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.373 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "61D16609ECCFD9159F55B7598393EB4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.373 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "40F779E4B7C4470A1945974AB10D7485")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case EVENT_NEXT_POST_DIAL EVENT_DTMF_DONE EVENT_PAUSE_DONE 
            processNextPostDialChar();
            //End case EVENT_NEXT_POST_DIAL EVENT_DTMF_DONE EVENT_PAUSE_DONE 
            //Begin case EVENT_WAKE_LOCK_TIMEOUT 
            releaseWakeLock();
            //End case EVENT_WAKE_LOCK_TIMEOUT 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case EVENT_NEXT_POST_DIAL:
                //case EVENT_DTMF_DONE:
                //case EVENT_PAUSE_DONE:
                    //processNextPostDialChar();
                    //break;
                //case EVENT_WAKE_LOCK_TIMEOUT:
                    //releaseWakeLock();
                    //break;
            //}
        }

        
    }


    
    static final String LOG_TAG = "CDMA";
    static final int EVENT_DTMF_DONE = 1;
    static final int EVENT_PAUSE_DONE = 2;
    static final int EVENT_NEXT_POST_DIAL = 3;
    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
    static final int PAUSE_DELAY_MILLIS = 2 * 1000;
}

