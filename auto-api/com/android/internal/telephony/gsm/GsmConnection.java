package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.util.Log;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import com.android.internal.telephony.*;

public class GsmConnection extends Connection {
    GsmCallTracker owner;
    GsmCall parent;
    String address;
    String dialString;
    String postDialString;
    boolean isIncoming;
    boolean disconnected;
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
    UUSInfo uusInfo;
    Handler h;
    private PowerManager.WakeLock mPartialWakeLock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.289 -0400", hash_original_method = "A76DAF9D6C007596CB909A2D96D7B6D3", hash_generated_method = "6C2EB2D7F0720F1F3E03A51FBC24533B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GsmConnection(Context context, DriverCall dc, GsmCallTracker ct, int index) {
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
        numberPresentation = dc.numberPresentation;
        uusInfo = dc.uusInfo;
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
        //numberPresentation = dc.numberPresentation;
        //uusInfo = dc.uusInfo;
        //this.index = index;
        //parent = parentFromDCState (dc.state);
        //parent.attach(this, dc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.290 -0400", hash_original_method = "1891CC0C108558254961316EC04BF5C2", hash_generated_method = "25BE87B51713A013105CDAD4A993282D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GsmConnection(Context context, String dialString, GsmCallTracker ct, GsmCall parent) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(dialString);
        dsTaint.addTaint(ct.dsTaint);
        createWakeLock(context);
        acquireWakeLock();
        h = new MyHandler(owner.getLooper());
        this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        index = -1;
        isIncoming = false;
        createTime = System.currentTimeMillis();
        parent.attachFake(this, GsmCall.State.DIALING);
        // ---------- Original Method ----------
        //createWakeLock(context);
        //acquireWakeLock();
        //owner = ct;
        //h = new MyHandler(owner.getLooper());
        //this.dialString = dialString;
        //this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        //this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);
        //index = -1;
        //isIncoming = false;
        //createTime = System.currentTimeMillis();
        //this.parent = parent;
        //parent.attachFake(this, GsmCall.State.DIALING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.290 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
        static boolean equalsHandlesNulls(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.290 -0400", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "97B3A17DC329E1DA145B22D0923344CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean compareTo(DriverCall c) {
        dsTaint.addTaint(c.dsTaint);
        String cAddress;
        cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        boolean var6A332DE396C17CD19C189EA4D870C286_1115757334 = (isIncoming == c.isMT && equalsHandlesNulls(address, cAddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (! (isIncoming || c.isMT)) return true;
        //String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        //return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "2DD09D86D550975B55052A6EEF6C3156")
    @DSModeled(DSC.SAFE)
    public String getAddress() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "B5FB9A2BDC3179E224BACAD787EF2D05", hash_generated_method = "ECA0F2F40D32995BA275E38217C6B0B0")
    @DSModeled(DSC.SAFE)
    public GsmCall getCall() {
        return (GsmCall)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "757EE1B0AB6C5A5234D521762CBF03D0")
    @DSModeled(DSC.SAFE)
    public long getCreateTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return createTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "CE355AC1212A3438732A194E41D7BC33")
    @DSModeled(DSC.SAFE)
    public long getConnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return connectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "9494539C3E418CB54E14DB9B543C3B50")
    @DSModeled(DSC.SAFE)
    public long getDisconnectTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return disconnectTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.291 -0400", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "DBF907A9614A8B1161BEC49267A71C15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getDurationMillis() {
        {
            long var2E584F737203A878ED4A9BB9708321A8_1265473012 = (SystemClock.elapsedRealtime() - connectTimeReal);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "7462D7508B2729C8A635CC5C7FC6CE68", hash_generated_method = "71A67D4720FE6F6D04F2FF997D80D6DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getHoldDurationMillis() {
        {
            boolean var1FCDEA306A526D01DBB4ECC8B843377F_1461199891 = (getState() != GsmCall.State.HOLDING);
            {
                long var2C126D63011C35D772AC44944CB08D74_163985944 = (SystemClock.elapsedRealtime() - holdingStartTime);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (getState() != GsmCall.State.HOLDING) {
            //return 0;
        //} else {
            //return SystemClock.elapsedRealtime() - holdingStartTime;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "9FC40A186005F970B1585088DF55868F")
    @DSModeled(DSC.SAFE)
    public DisconnectCause getDisconnectCause() {
        return (DisconnectCause)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "9720E3BA05EE58EFF958F925FE350B15")
    @DSModeled(DSC.SAFE)
    public boolean isIncoming() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isIncoming;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "398AF7C0214E451C29E7D60E02DBA909", hash_generated_method = "A89A824B7C9032AE916EF4719131662C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GsmCall.State getState() {
        {
            GsmCall.State var85633779C9C1785ADAF1DE8B686337A0_2138313778 = (super.getState());
        } //End block
        return (GsmCall.State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (disconnected) {
            //return GsmCall.State.DISCONNECTED;
        //} else {
            //return super.getState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "95C25B9F17CBA9FBBFEE5D205D9A3D89")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.292 -0400", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "9EA3AEE9D5903810DE288024DD91C72F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.293 -0400", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "97E44C0F5B9A6B70902CBA869C71CF87")
    @DSModeled(DSC.SAFE)
    public PostDialState getPostDialState() {
        return (PostDialState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return postDialState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.293 -0400", hash_original_method = "7FC9A5882D286ABFCC1FEE503B1B4BF9", hash_generated_method = "24F6AE4A8387FAA7DFEF7282333F8267")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceedAfterWaitChar() {
        setPostDialState(PostDialState.STARTED);
        processNextPostDialChar();
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.WAIT) {
            //Log.w(LOG_TAG, "GsmConnection.proceedAfterWaitChar(): Expected "
                //+ "getPostDialState() to be WAIT but was " + postDialState);
            //return;
        //}
        //setPostDialState(PostDialState.STARTED);
        //processNextPostDialChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.293 -0400", hash_original_method = "0C656170567C6DC06B89DB468E951CD9", hash_generated_method = "E3A9F0F29CDEC01870B36BF7A735841B")
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
                        boolean var3511F6C9B7B285C8848DD8FAF73BEEA8_258812975 = (PhoneNumberUtils.is12Key(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.293 -0400", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "26C36C50E9E751F3C65FE2DB8C4256D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
        // ---------- Original Method ----------
        //setPostDialState(PostDialState.CANCELLED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.294 -0400", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "AF613E28B4B81657ADA567229F15BFC2")
    @DSModeled(DSC.SAFE)
     void onHangupLocal() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cause = DisconnectCause.LOCAL;
        // ---------- Original Method ----------
        //cause = DisconnectCause.LOCAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.294 -0400", hash_original_method = "DC25F8C05B93479710BEF2CD72CB101B", hash_generated_method = "C7E02E08B6968660751E7978F1C54E06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DisconnectCause disconnectCauseFromCode(int causeCode) {
        dsTaint.addTaint(causeCode);
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        GSMPhone phone;
        phone = owner.phone;
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        int serviceState;
        serviceState = phone.getServiceState().getState();
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        //Begin case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        {
            boolean var5091C793378400668FE72A97939F15D8_745676923 = (phone.getIccCard().getState() != SimCard.State.READY);
            {
                {
                    boolean varA62FA2C2A980B99629B7CC6E6F15EA85_1350324981 = (phone.mSST.mRestrictedState.isCsRestricted());
                    {
                        boolean var37D2C9FD99D48B594DA94EC7638810B2_744547428 = (phone.mSST.mRestrictedState.isCsEmergencyRestricted());
                        {
                            boolean var9C5241B1025C58944F71E411BAB0F18A_1722688994 = (phone.mSST.mRestrictedState.isCsNormalRestricted());
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        //End case CallFailCause.ERROR_UNSPECIFIED CallFailCause.NORMAL_CLEARING default 
        return (DisconnectCause)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.294 -0400", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "79DD08BA84758D04C8F167DB8D5F0A04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onRemoteDisconnect(int causeCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(causeCode);
        onDisconnect(disconnectCauseFromCode(causeCode));
        // ---------- Original Method ----------
        //onDisconnect(disconnectCauseFromCode(causeCode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.295 -0400", hash_original_method = "9BE79A12D6DD94045CB54AF328E4EC88", hash_generated_method = "A15B8617666FB22C6B408AF59985027F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onDisconnect(DisconnectCause cause) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cause.dsTaint);
        {
            index = -1;
            disconnectTime = System.currentTimeMillis();
            duration = SystemClock.elapsedRealtime() - connectTimeReal;
            disconnected = true;
            Log.d(LOG_TAG,
                    "[GSMConn] onDisconnect: cause=" + cause);
            owner.phone.notifyDisconnect(this);
            {
                parent.connectionDisconnected(this);
            } //End block
        } //End block
        releaseWakeLock();
        // ---------- Original Method ----------
        //this.cause = cause;
        //if (!disconnected) {
            //index = -1;
            //disconnectTime = System.currentTimeMillis();
            //duration = SystemClock.elapsedRealtime() - connectTimeReal;
            //disconnected = true;
            //if (false) Log.d(LOG_TAG,
                    //"[GSMConn] onDisconnect: cause=" + cause);
            //owner.phone.notifyDisconnect(this);
            //if (parent != null) {
                //parent.connectionDisconnected(this);
            //}
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.295 -0400", hash_original_method = "96B42EEDFF6F1EDC58573CD6BAE53841", hash_generated_method = "381A6DA316B45E61E3DD14F33CF7959D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean update(DriverCall dc) {
        dsTaint.addTaint(dc.dsTaint);
        GsmCall newParent;
        boolean changed;
        changed = false;
        boolean wasConnectingInOrOut;
        wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding;
        wasHolding = (getState() == GsmCall.State.HOLDING);
        newParent = parentFromDCState(dc.state);
        {
            boolean varE881044A72B93B862D308B06B4E2C746_346762380 = (!equalsHandlesNulls(address, dc.number));
            {
                log("update: phone # changed!");
                address = dc.number;
                changed = true;
            } //End block
        } //End collapsed parenthetic
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
                "update: parent=" + parent +
                ", hasNewParent=" + (newParent != parent) +
                ", wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);
        {
            boolean var06589BF74DE5997C8FC534FD1B427681_1757581128 = (wasConnectingInOrOut && !isConnectingInOrOut());
            {
                onConnectedInOrOut();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var39CF314BB7DEE265CDCBB3C2022EA156_910107185 = (changed && !wasHolding && (getState() == GsmCall.State.HOLDING));
            {
                onStartedHolding();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.295 -0400", hash_original_method = "C488B13192B412621BF84C3D483CEE4F", hash_generated_method = "C1C80616B902D36A79AE71F71724562E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fakeHoldBeforeDial() {
        {
            parent.detach(this);
        } //End block
        parent = owner.backgroundCall;
        parent.attachFake(this, GsmCall.State.HOLDING);
        onStartedHolding();
        // ---------- Original Method ----------
        //if (parent != null) {
            //parent.detach(this);
        //}
        //parent = owner.backgroundCall;
        //parent.attachFake(this, GsmCall.State.HOLDING);
        //onStartedHolding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.296 -0400", hash_original_method = "CA6F3BC3A0E7C25CF1D3A00C4B3FEC79", hash_generated_method = "3E431D5B55DEAE7C471239DE087F2A09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getGSMIndex() throws CallStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new CallStateException ("GSM index not yet assigned");
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index >= 0) {
            //return index + 1;
        //} else {
            //throw new CallStateException ("GSM index not yet assigned");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.296 -0400", hash_original_method = "ABFB0B36CEC0E1D483C56AE8A85E75EC", hash_generated_method = "E7EC8F4C90562CAF5D52E074F56A5E58")
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
        releaseWakeLock();
        // ---------- Original Method ----------
        //connectTime = System.currentTimeMillis();
        //connectTimeReal = SystemClock.elapsedRealtime();
        //duration = 0;
        //if (Phone.DEBUG_PHONE) {
            //log("onConnectedInOrOut: connectTime=" + connectTime);
        //}
        //if (!isIncoming) {
            //processNextPostDialChar();
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.296 -0400", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "4CC0128FFB204771391C6A749ADF62F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
        // ---------- Original Method ----------
        //holdingStartTime = SystemClock.elapsedRealtime();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.296 -0400", hash_original_method = "ED55B5B85F7807A50A99A17BF067C0B0", hash_generated_method = "4B59F7F0F4A79292F7CEC51A6A7E9C8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean processPostDialChar(char c) {
        dsTaint.addTaint(c);
        {
            boolean var5BF2C5BE7CCD2082ACD6C3DE182DDC82_698722201 = (PhoneNumberUtils.is12Key(c));
            {
                owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
            } //End block
            {
                {
                    h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_FIRST_MILLIS);
                } //End block
                {
                    h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
                } //End block
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
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.297 -0400", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "454C9DCB1B3F8E99ADC61701A1FE774D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getRemainingPostDialString() {
        {
            boolean varCBE29C650BD63B7D36FF87F87B8A05C3_2112834436 = (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar);
        } //End collapsed parenthetic
        String var52C9357568FD82A03712A00BCB4BC900_1291588725 = (postDialString.substring(nextPostDialChar));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (postDialState == PostDialState.CANCELLED
            //|| postDialState == PostDialState.COMPLETE
            //|| postDialString == null
            //|| postDialString.length() <= nextPostDialChar
        //) {
            //return "";
        //}
        //return postDialString.substring(nextPostDialChar);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.297 -0400", hash_original_method = "0A00BE85F59605F9BA59170C28959531", hash_generated_method = "7D7C9EBD33731D872522A45BC233DE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        {
            boolean varF1FD10BC172E73DC685D38B97B6A381A_1184975138 = (mPartialWakeLock.isHeld());
        } //End collapsed parenthetic
        releaseWakeLock();
        // ---------- Original Method ----------
        //if (mPartialWakeLock.isHeld()) {
            //Log.e(LOG_TAG, "[GSMConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        //}
        //releaseWakeLock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.297 -0400", hash_original_method = "B0F082CCF01CD3AE555892AF55A9C3FC", hash_generated_method = "4F4D0474C9724BC57C9C88AD5020CE22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processNextPostDialChar() {
        char c;
        c = 0;
        Registrant postDialHandler;
        {
            boolean var8A7CFCBE4CC8CF2E3FB4275E7C0B692F_164332761 = (postDialString == null ||
                postDialString.length() <= nextPostDialChar);
            {
                setPostDialState(PostDialState.COMPLETE);
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
            boolean varB7D67D389C6A58715F3756EDB58E607E_1662532171 = (postDialHandler != null
                && (notifyMessage = postDialHandler.messageForRegistrant()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.298 -0400", hash_original_method = "42A83CA5C5D82F280A6650571B6091DC", hash_generated_method = "EF88F49A6A5844A2CB37DF2631F66681")
    @DSModeled(DSC.SAFE)
    private boolean isConnectingInOrOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parent == null || parent == owner.ringingCall
            //|| parent.state == GsmCall.State.DIALING
            //|| parent.state == GsmCall.State.ALERTING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.298 -0400", hash_original_method = "0BC976C46EE0BD1C914FEB75FAA745AD", hash_generated_method = "012C33954EB8CCE7142FFF26E9F93839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private GsmCall parentFromDCState(DriverCall.State state) {
        dsTaint.addTaint(state.dsTaint);
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("illegal call state: " + state);
        //End case default 
        return (GsmCall)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.298 -0400", hash_original_method = "845314D50CD91AD375633BF061F59C00", hash_generated_method = "B2D6FC1A8970F24ECDF9A4B16EB8B800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setPostDialState(PostDialState s) {
        dsTaint.addTaint(s.dsTaint);
        {
            acquireWakeLock();
            Message msg;
            msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        } //End block
        {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        } //End block
        // ---------- Original Method ----------
        //if (postDialState != PostDialState.STARTED
                //&& s == PostDialState.STARTED) {
            //acquireWakeLock();
            //Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            //h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        //} else if (postDialState == PostDialState.STARTED
                //&& s != PostDialState.STARTED) {
            //h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            //releaseWakeLock();
        //}
        //postDialState = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.298 -0400", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "9548152CA08E0E08E5F4D52CC8459CC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createWakeLock(Context context) {
        dsTaint.addTaint(context.dsTaint);
        PowerManager pm;
        pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.298 -0400", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "10254D45B38927398E7A300A74D0442A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
        // ---------- Original Method ----------
        //log("acquireWakeLock");
        //mPartialWakeLock.acquire();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.299 -0400", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "1BA79705A25E9DF7C52E477F39D52308")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void releaseWakeLock() {
        {
            {
                boolean var7AF9E96BF041CFB5FB2EBC225EA829D3_240484479 = (mPartialWakeLock.isHeld());
                {
                    log("releaseWakeLock");
                    mPartialWakeLock.release();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mPartialWakeLock) {
            //if (mPartialWakeLock.isHeld()) {
                //log("releaseWakeLock");
                //mPartialWakeLock.release();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.299 -0400", hash_original_method = "7502A69F3ECD37971405A81286CC5AAF", hash_generated_method = "AF17E15C0ED63EE726AB4C08DD40BFE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[GSMConn] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[GSMConn] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.299 -0400", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "A5F141B90481F1F129EAE84EC9C590DB")
    @DSModeled(DSC.SAFE)
    @Override
    public int getNumberPresentation() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return numberPresentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.299 -0400", hash_original_method = "00708DAD150C484ADEE163A005CDF57B", hash_generated_method = "D1D340BA3A575E89BC0AB51B5AB9024A")
    @DSModeled(DSC.SAFE)
    @Override
    public UUSInfo getUUSInfo() {
        return (UUSInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return uusInfo;
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.299 -0400", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "61D16609ECCFD9159F55B7598393EB4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper l) {
            super(l);
            dsTaint.addTaint(l.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.300 -0400", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "40F779E4B7C4470A1945974AB10D7485")
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


    
    static final String LOG_TAG = "GSM";
    static final int EVENT_DTMF_DONE = 1;
    static final int EVENT_PAUSE_DONE = 2;
    static final int EVENT_NEXT_POST_DIAL = 3;
    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
    static final int PAUSE_DELAY_FIRST_MILLIS = 100;
    static final int PAUSE_DELAY_MILLIS = 3 * 1000;
    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
}

