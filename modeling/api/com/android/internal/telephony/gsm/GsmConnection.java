package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.SystemClock;
import android.telephony.PhoneNumberUtils;
import android.telephony.ServiceState;
import android.util.Log;

import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;

public class GsmConnection extends Connection {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.325 -0500", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "2C7138DB4A9526DAF974103E40C81A8A")
    
static boolean
    equalsHandlesNulls (Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.244 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.292 -0500", hash_original_field = "9DEE625DEB66F1732549A58AF1C8973F", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.294 -0500", hash_original_field = "93ECE39BAE4F4558E5EDF101E65B36CA", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.297 -0500", hash_original_field = "2E31C70A59617814D2A55152CD827E3C", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.299 -0500", hash_original_field = "D37B58DAA289ADBEC891FA151103DC69", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.302 -0500", hash_original_field = "547C4C991A158C1FA0EE210BD4EB1D84", hash_generated_field = "03FF742B1D8A48B6BE32674B6F48BF75")

    static final int PAUSE_DELAY_FIRST_MILLIS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.304 -0500", hash_original_field = "86C9C404CCD2CB18824622BC59A89236", hash_generated_field = "C6EAA5B8EED26E74A3179FF8DE2F06A0")

    static final int PAUSE_DELAY_MILLIS = 3 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.306 -0500", hash_original_field = "1DA53076837CBD8789185EAE15BB3870", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.246 -0500", hash_original_field = "B6239D6F2AF1190D06AAF0170D315E18", hash_generated_field = "B6239D6F2AF1190D06AAF0170D315E18")

    GsmCallTracker owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.248 -0500", hash_original_field = "EC13D736730A652A8D5F62206A0EDCDD", hash_generated_field = "EC13D736730A652A8D5F62206A0EDCDD")

    GsmCall parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.251 -0500", hash_original_field = "815EECE17AF4BC840D4544A9ECB9EACD", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")

    String address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.253 -0500", hash_original_field = "F515901190E6B9979D62CEFE77655CD0", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.255 -0500", hash_original_field = "8276078622B570793705E396A0D7F62F", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.257 -0500", hash_original_field = "4C77869A4C7C09DEF349ED266B2A3A42", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.259 -0500", hash_original_field = "0A66E61F25EE1D53440481E40AA3E515", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.261 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.263 -0500", hash_original_field = "88A71A811D0CFD868BD514D9A7A9DADE", hash_generated_field = "D3A438A68DF5311E0B9C48DC32212255")

                        // The GSM index is 1 + this

    /*
     * These time/timespan values are based on System.currentTimeMillis(),
     * i.e., "wall clock" time.
     */
    long createTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.265 -0500", hash_original_field = "4688FD5CCB150978DDBAC76460D6A697", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.267 -0500", hash_original_field = "6F4281795E649655EEAED8CC4AFFA7C4", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.269 -0500", hash_original_field = "FB007E1B198D105ABB5DFCFDF540B71E", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.272 -0500", hash_original_field = "55107CF285B030B92DD9E509D85ADD9E", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.274 -0500", hash_original_field = "39B3C41F5817B2E3B391281A0E9E890F", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.276 -0500", hash_original_field = "6EBA36FD71F695F0A7004724AFD9D8F8", hash_generated_field = "C1E13AD275293435ED8EAB8BE0D4E663")

                            // into HOLDING

    int nextPostDialChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.279 -0500", hash_original_field = "846032E4A4EEA9EEF5F261B33CBAFAE8", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")

    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.281 -0500", hash_original_field = "12225F767E33A7C05BECAD37785471A6", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.283 -0500", hash_original_field = "34BF499978B1A906EDC3EA4DB0168C11", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.285 -0500", hash_original_field = "34C14CFE94A5D0F7C643E2D0DC23FCE9", hash_generated_field = "34C14CFE94A5D0F7C643E2D0DC23FCE9")

    UUSInfo uusInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.287 -0500", hash_original_field = "47D42CB1DCDC1AD18224D34E3D8719BD", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")

    Handler h;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.290 -0500", hash_original_field = "DD211FB7C7A1365A3C66A0CF1B432479", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")

    private PowerManager.WakeLock mPartialWakeLock;

    //***** Constructors

    /** This is probably an MT call that we first saw in a CLCC response */
    /*package*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.317 -0500", hash_original_method = "A76DAF9D6C007596CB909A2D96D7B6D3", hash_generated_method = "A76DAF9D6C007596CB909A2D96D7B6D3")
    
GsmConnection (Context context, DriverCall dc, GsmCallTracker ct, int index) {
        createWakeLock(context);
        acquireWakeLock();

        owner = ct;
        h = new MyHandler(owner.getLooper());

        address = dc.number;

        isIncoming = dc.isMT;
        createTime = System.currentTimeMillis();
        numberPresentation = dc.numberPresentation;
        uusInfo = dc.uusInfo;

        this.index = index;

        parent = parentFromDCState (dc.state);
        parent.attach(this, dc);
    }

    /** This is an MO call, created when dialing */
    /*package*/
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.320 -0500", hash_original_method = "1891CC0C108558254961316EC04BF5C2", hash_generated_method = "1891CC0C108558254961316EC04BF5C2")
    
GsmConnection (Context context, String dialString, GsmCallTracker ct, GsmCall parent) {
        createWakeLock(context);
        acquireWakeLock();

        owner = ct;
        h = new MyHandler(owner.getLooper());

        this.dialString = dialString;

        this.address = PhoneNumberUtils.extractNetworkPortionAlt(dialString);
        this.postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);

        index = -1;

        isIncoming = false;
        createTime = System.currentTimeMillis();

        this.parent = parent;
        parent.attachFake(this, GsmCall.State.DIALING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.322 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.327 -0500", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "065B6A32C6CA7063A00EB20821FEE8BC")
    
boolean
    compareTo(DriverCall c) {
        // On mobile originated (MO) calls, the phone number may have changed
        // due to a SIM Toolkit call control modification.
        //
        // We assume we know when MO calls are created (since we created them)
        // and therefore don't need to compare the phone number anyway.
        if (! (isIncoming || c.isMT)) return true;

        // ... but we can compare phone numbers on MT calls, and we have
        // no control over when they begin, so we might as well

        String cAddress = PhoneNumberUtils.stringFromStringAndTOA(c.number, c.TOA);
        return isIncoming == c.isMT && equalsHandlesNulls(address, cAddress);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.329 -0500", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "9D79DFDD8EA73AA9BC42783E0AB77415")
    
public String getAddress() {
        return address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.331 -0500", hash_original_method = "B5FB9A2BDC3179E224BACAD787EF2D05", hash_generated_method = "EC5851E2ACE4A430846637EA5EF5C08C")
    
public GsmCall getCall() {
        return parent;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.334 -0500", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "A28981F024E432A69A5EE6C2C2A713AE")
    
public long getCreateTime() {
        return createTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.336 -0500", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "F3878C4EA8EC161DB4C86B7EE0828514")
    
public long getConnectTime() {
        return connectTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.338 -0500", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "B4593A4A250C143E07993447C4BE4305")
    
public long getDisconnectTime() {
        return disconnectTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.341 -0500", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "CF314DE5EA8CCD1CF80C405480A4ED6D")
    
public long getDurationMillis() {
        if (connectTimeReal == 0) {
            return 0;
        } else if (duration == 0) {
            return SystemClock.elapsedRealtime() - connectTimeReal;
        } else {
            return duration;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.343 -0500", hash_original_method = "7462D7508B2729C8A635CC5C7FC6CE68", hash_generated_method = "A5156AEED4B42DB6AFD522974FEB6AFC")
    
public long getHoldDurationMillis() {
        if (getState() != GsmCall.State.HOLDING) {
            // If not holding, return 0
            return 0;
        } else {
            return SystemClock.elapsedRealtime() - holdingStartTime;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.346 -0500", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "9282122F6BAD3F883AADDAE6681CD7D5")
    
public DisconnectCause getDisconnectCause() {
        return cause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.349 -0500", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "30744870D5463E3A1E2FF89E6E52472D")
    
public boolean isIncoming() {
        return isIncoming;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.351 -0500", hash_original_method = "398AF7C0214E451C29E7D60E02DBA909", hash_generated_method = "9BB0D613B6935F1836FC4E26605D4A52")
    
public GsmCall.State getState() {
        if (disconnected) {
            return GsmCall.State.DISCONNECTED;
        } else {
            return super.getState();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.353 -0500", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "4CF1FE8A4888E47AA493321FE63615C0")
    
public void hangup() throws CallStateException {
        if (!disconnected) {
            owner.hangup(this);
        } else {
            throw new CallStateException ("disconnected");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.355 -0500", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "4C27373F4B78030B0B1D4BBE76B84F15")
    
public void separate() throws CallStateException {
        if (!disconnected) {
            owner.separate(this);
        } else {
            throw new CallStateException ("disconnected");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.357 -0500", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "9FE402970AA08455EE526E2EA42EFD5E")
    
public PostDialState getPostDialState() {
        return postDialState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.360 -0500", hash_original_method = "7FC9A5882D286ABFCC1FEE503B1B4BF9", hash_generated_method = "A93614C215733B00306B474B02D8B2E2")
    
public void proceedAfterWaitChar() {
        if (postDialState != PostDialState.WAIT) {
            Log.w(LOG_TAG, "GsmConnection.proceedAfterWaitChar(): Expected "
                + "getPostDialState() to be WAIT but was " + postDialState);
            return;
        }

        setPostDialState(PostDialState.STARTED);

        processNextPostDialChar();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.363 -0500", hash_original_method = "0C656170567C6DC06B89DB468E951CD9", hash_generated_method = "7DB86B2DC72EAD1C38B0FBCAE22B384E")
    
public void proceedAfterWildChar(String str) {
        if (postDialState != PostDialState.WILD) {
            Log.w(LOG_TAG, "GsmConnection.proceedAfterWaitChar(): Expected "
                + "getPostDialState() to be WILD but was " + postDialState);
            return;
        }

        setPostDialState(PostDialState.STARTED);

        if (false) {
            boolean playedTone = false;
            int len = (str != null ? str.length() : 0);

            for (int i=0; i<len; i++) {
                char c = str.charAt(i);
                Message msg = null;

                if (i == len-1) {
                    msg = h.obtainMessage(EVENT_DTMF_DONE);
                }

                if (PhoneNumberUtils.is12Key(c)) {
                    owner.cm.sendDtmf(c, msg);
                    playedTone = true;
                }
            }

            if (!playedTone) {
                processNextPostDialChar();
            }
        } else {
            // make a new postDialString, with the wild char replacement string
            // at the beginning, followed by the remaining postDialString.

            StringBuilder buf = new StringBuilder(str);
            buf.append(postDialString.substring(nextPostDialChar));
            postDialString = buf.toString();
            nextPostDialChar = 0;
            if (Phone.DEBUG_PHONE) {
                log("proceedAfterWildChar: new postDialString is " +
                        postDialString);
            }

            processNextPostDialChar();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.366 -0500", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "F55D1C15AE51897B81A42C8B6C6E9B67")
    
public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
    }

    /**
     * Called when this Connection is being hung up locally (eg, user pressed "end")
     * Note that at this point, the hangup request has been dispatched to the radio
     * but no response has yet been received so update() has not yet been called
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.368 -0500", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "1D26914F95E4E8CAB857832B14C412F2")
    
void
    onHangupLocal() {
        cause = DisconnectCause.LOCAL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.371 -0500", hash_original_method = "DC25F8C05B93479710BEF2CD72CB101B", hash_generated_method = "CB59418C9CCD9CEB756DB16F3F5EF781")
    
DisconnectCause
    disconnectCauseFromCode(int causeCode) {
        /**
         * See 22.001 Annex F.4 for mapping of cause codes
         * to local tones
         */

        switch (causeCode) {
            case CallFailCause.USER_BUSY:
                return DisconnectCause.BUSY;

            case CallFailCause.NO_CIRCUIT_AVAIL:
            case CallFailCause.TEMPORARY_FAILURE:
            case CallFailCause.SWITCHING_CONGESTION:
            case CallFailCause.CHANNEL_NOT_AVAIL:
            case CallFailCause.QOS_NOT_AVAIL:
            case CallFailCause.BEARER_NOT_AVAIL:
                return DisconnectCause.CONGESTION;

            case CallFailCause.ACM_LIMIT_EXCEEDED:
                return DisconnectCause.LIMIT_EXCEEDED;

            case CallFailCause.CALL_BARRED:
                return DisconnectCause.CALL_BARRED;

            case CallFailCause.FDN_BLOCKED:
                return DisconnectCause.FDN_BLOCKED;

            case CallFailCause.UNOBTAINABLE_NUMBER:
                return DisconnectCause.UNOBTAINABLE_NUMBER;

            case CallFailCause.ERROR_UNSPECIFIED:
            case CallFailCause.NORMAL_CLEARING:
            default:
                GSMPhone phone = owner.phone;
                int serviceState = phone.getServiceState().getState();
                if (serviceState == ServiceState.STATE_POWER_OFF) {
                    return DisconnectCause.POWER_OFF;
                } else if (serviceState == ServiceState.STATE_OUT_OF_SERVICE
                        || serviceState == ServiceState.STATE_EMERGENCY_ONLY ) {
                    return DisconnectCause.OUT_OF_SERVICE;
                } else if (phone.getIccCard().getState() != SimCard.State.READY) {
                    return DisconnectCause.ICC_ERROR;
                } else if (causeCode == CallFailCause.ERROR_UNSPECIFIED) {
                    if (phone.mSST.mRestrictedState.isCsRestricted()) {
                        return DisconnectCause.CS_RESTRICTED;
                    } else if (phone.mSST.mRestrictedState.isCsEmergencyRestricted()) {
                        return DisconnectCause.CS_RESTRICTED_EMERGENCY;
                    } else if (phone.mSST.mRestrictedState.isCsNormalRestricted()) {
                        return DisconnectCause.CS_RESTRICTED_NORMAL;
                    } else {
                        return DisconnectCause.ERROR_UNSPECIFIED;
                    }
                } else if (causeCode == CallFailCause.NORMAL_CLEARING) {
                    return DisconnectCause.NORMAL;
                } else {
                    // If nothing else matches, report unknown call drop reason
                    // to app, not NORMAL call end.
                    return DisconnectCause.ERROR_UNSPECIFIED;
                }
        }
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.373 -0500", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "6DD0016A82A0EEA168B83665DD86A0FB")
    
void
    onRemoteDisconnect(int causeCode) {
        onDisconnect(disconnectCauseFromCode(causeCode));
    }

    /** Called when the radio indicates the connection has been disconnected */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.376 -0500", hash_original_method = "9BE79A12D6DD94045CB54AF328E4EC88", hash_generated_method = "9BE79A12D6DD94045CB54AF328E4EC88")
    
void
    onDisconnect(DisconnectCause cause) {
        this.cause = cause;

        if (!disconnected) {
            index = -1;

            disconnectTime = System.currentTimeMillis();
            duration = SystemClock.elapsedRealtime() - connectTimeReal;
            disconnected = true;

            if (false) Log.d(LOG_TAG,
                    "[GSMConn] onDisconnect: cause=" + cause);

            owner.phone.notifyDisconnect(this);

            if (parent != null) {
                parent.connectionDisconnected(this);
            }
        }
        releaseWakeLock();
    }

    // Returns true if state has changed, false if nothing changed
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.379 -0500", hash_original_method = "96B42EEDFF6F1EDC58573CD6BAE53841", hash_generated_method = "FB7DF053BF1718E28F7722E2563ED114")
    
boolean
    update (DriverCall dc) {
        GsmCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == GsmCall.State.HOLDING);

        newParent = parentFromDCState(dc.state);

        if (!equalsHandlesNulls(address, dc.number)) {
            if (Phone.DEBUG_PHONE) log("update: phone # changed!");
            address = dc.number;
            changed = true;
        }

        if (newParent != parent) {
            if (parent != null) {
                parent.detach(this);
            }
            newParent.attach(this, dc);
            parent = newParent;
            changed = true;
        } else {
            boolean parentStateChange;
            parentStateChange = parent.update (this, dc);
            changed = changed || parentStateChange;
        }

        /** Some state-transition events */

        if (Phone.DEBUG_PHONE) log(
                "update: parent=" + parent +
                ", hasNewParent=" + (newParent != parent) +
                ", wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);

        if (wasConnectingInOrOut && !isConnectingInOrOut()) {
            onConnectedInOrOut();
        }

        if (changed && !wasHolding && (getState() == GsmCall.State.HOLDING)) {
            // We've transitioned into HOLDING
            onStartedHolding();
        }

        return changed;
    }

    /**
     * Called when this Connection is in the foregroundCall
     * when a dial is initiated.
     * We know we're ACTIVE, and we know we're going to end up
     * HOLDING in the backgroundCall
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.382 -0500", hash_original_method = "C488B13192B412621BF84C3D483CEE4F", hash_generated_method = "C488B13192B412621BF84C3D483CEE4F")
    
void
    fakeHoldBeforeDial() {
        if (parent != null) {
            parent.detach(this);
        }

        parent = owner.backgroundCall;
        parent.attachFake(this, GsmCall.State.HOLDING);

        onStartedHolding();
    }

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.384 -0500", hash_original_method = "CA6F3BC3A0E7C25CF1D3A00C4B3FEC79", hash_generated_method = "CA6F3BC3A0E7C25CF1D3A00C4B3FEC79")
    
int
    getGSMIndex() throws CallStateException {
        if (index >= 0) {
            return index + 1;
        } else {
            throw new CallStateException ("GSM index not yet assigned");
        }
    }

    /**
     * An incoming or outgoing call has connected
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.386 -0500", hash_original_method = "ABFB0B36CEC0E1D483C56AE8A85E75EC", hash_generated_method = "AE82E35E09B52D83A2FD40E3CC9579E6")
    
void
    onConnectedInOrOut() {
        connectTime = System.currentTimeMillis();
        connectTimeReal = SystemClock.elapsedRealtime();
        duration = 0;

        // bug #678474: incoming call interpreted as missed call, even though
        // it sounds like the user has picked up the call.
        if (Phone.DEBUG_PHONE) {
            log("onConnectedInOrOut: connectTime=" + connectTime);
        }

        if (!isIncoming) {
            // outgoing calls only
            processNextPostDialChar();
        }
        releaseWakeLock();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.389 -0500", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "6EA028C22A00C67FA168002DDA2CF290")
    
private void
    onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
    }
    /**
     * Performs the appropriate action for a post-dial char, but does not
     * notify application. returns false if the character is invalid and
     * should be ignored
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.392 -0500", hash_original_method = "ED55B5B85F7807A50A99A17BF067C0B0", hash_generated_method = "754163234CFE1A6C580CF5F819A95EA5")
    
private boolean
    processPostDialChar(char c) {
        if (PhoneNumberUtils.is12Key(c)) {
            owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        } else if (c == PhoneNumberUtils.PAUSE) {
            // From TS 22.101:

            // "The first occurrence of the "DTMF Control Digits Separator"
            //  shall be used by the ME to distinguish between the addressing
            //  digits (i.e. the phone number) and the DTMF digits...."

            if (nextPostDialChar == 1) {
                // The first occurrence.
                // We don't need to pause here, but wait for just a bit anyway
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_FIRST_MILLIS);
            } else {
                // It continues...
                // "Upon subsequent occurrences of the separator, the UE shall
                //  pause again for 3 seconds (\u00B1 20 %) before sending any
                //  further DTMF digits."
                h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
            }
        } else if (c == PhoneNumberUtils.WAIT) {
            setPostDialState(PostDialState.WAIT);
        } else if (c == PhoneNumberUtils.WILD) {
            setPostDialState(PostDialState.WILD);
        } else {
            return false;
        }

        return true;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.394 -0500", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "42A7DBBBB5A1243A18658BBC84FC9C4B")
    
public String
    getRemainingPostDialString() {
        if (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar
        ) {
            return "";
        }

        return postDialString.substring(nextPostDialChar);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.397 -0500", hash_original_method = "0A00BE85F59605F9BA59170C28959531", hash_generated_method = "4FEB61AEBAF4A4963F4ED85ED374C4D0")
    
@Override
    protected void finalize()
    {
        /**
         * It is understood that This finializer is not guaranteed
         * to be called and the release lock call is here just in
         * case there is some path that doesn't call onDisconnect
         * and or onConnectedInOrOut.
         */
        if (mPartialWakeLock.isHeld()) {
            Log.e(LOG_TAG, "[GSMConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        }
        releaseWakeLock();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.400 -0500", hash_original_method = "B0F082CCF01CD3AE555892AF55A9C3FC", hash_generated_method = "E9A8DFF3605DB95AA3DD31340E5442B1")
    
private void
    processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;

        if (postDialState == PostDialState.CANCELLED) {
            //Log.v("GSM", "##### processNextPostDialChar: postDialState == CANCELLED, bail");
            return;
        }

        if (postDialString == null ||
                postDialString.length() <= nextPostDialChar) {
            setPostDialState(PostDialState.COMPLETE);

            // notifyMessage.arg1 is 0 on complete
            c = 0;
        } else {
            boolean isValid;

            setPostDialState(PostDialState.STARTED);

            c = postDialString.charAt(nextPostDialChar++);

            isValid = processPostDialChar(c);

            if (!isValid) {
                // Will call processNextPostDialChar
                h.obtainMessage(EVENT_NEXT_POST_DIAL).sendToTarget();
                // Don't notify application
                Log.e("GSM", "processNextPostDialChar: c=" + c + " isn't valid!");
                return;
            }
        }

        postDialHandler = owner.phone.mPostDialHandler;

        Message notifyMessage;

        if (postDialHandler != null
                && (notifyMessage = postDialHandler.messageForRegistrant()) != null) {
            // The AsyncResult.result is the Connection object
            PostDialState state = postDialState;
            AsyncResult ar = AsyncResult.forMessage(notifyMessage);
            ar.result = this;
            ar.userObj = state;

            // arg1 is the character that was/is being processed
            notifyMessage.arg1 = c;

            //Log.v("GSM", "##### processNextPostDialChar: send msg to postDialHandler, arg1=" + c);
            notifyMessage.sendToTarget();
        }
    }

    /** "connecting" means "has never been ACTIVE" for both incoming
     *  and outgoing calls
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.402 -0500", hash_original_method = "42A83CA5C5D82F280A6650571B6091DC", hash_generated_method = "9EA11A633B494EDD36EEB255596A1D17")
    
private boolean
    isConnectingInOrOut() {
        return parent == null || parent == owner.ringingCall
            || parent.state == GsmCall.State.DIALING
            || parent.state == GsmCall.State.ALERTING;
    }
    
    class MyHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.309 -0500", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "2B93823BE9CDEC6A395C6867AE57FF4F")
        
MyHandler(Looper l) {super(l);}

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.311 -0500", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "9AEB0D6EEF8F90C85341CDE5285B08AA")
        
public void
        handleMessage(Message msg) {

            switch (msg.what) {
                case EVENT_NEXT_POST_DIAL:
                case EVENT_DTMF_DONE:
                case EVENT_PAUSE_DONE:
                    processNextPostDialChar();
                    break;
                case EVENT_WAKE_LOCK_TIMEOUT:
                    releaseWakeLock();
                    break;
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.404 -0500", hash_original_method = "0BC976C46EE0BD1C914FEB75FAA745AD", hash_generated_method = "74E853FC4606B9790817FFA235454542")
    
private GsmCall
    parentFromDCState (DriverCall.State state) {
        switch (state) {
            case ACTIVE:
            case DIALING:
            case ALERTING:
                return owner.foregroundCall;
            //break;

            case HOLDING:
                return owner.backgroundCall;
            //break;

            case INCOMING:
            case WAITING:
                return owner.ringingCall;
            //break;

            default:
                throw new RuntimeException("illegal call state: " + state);
        }
    }

    /**
     * Set post dial state and acquire wake lock while switching to "started"
     * state, the wake lock will be released if state switches out of "started"
     * state or after WAKE_LOCK_TIMEOUT_MILLIS.
     * @param s new PostDialState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.408 -0500", hash_original_method = "845314D50CD91AD375633BF061F59C00", hash_generated_method = "E7DE6A90BDBACCBBD0630A7E2280EFBA")
    
private void setPostDialState(PostDialState s) {
        if (postDialState != PostDialState.STARTED
                && s == PostDialState.STARTED) {
            acquireWakeLock();
            Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
            h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
        } else if (postDialState == PostDialState.STARTED
                && s != PostDialState.STARTED) {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        }
        postDialState = s;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.410 -0500", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "01B3024D6E6F76F8BF272926384E7FD0")
    
private void
    createWakeLock(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.412 -0500", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "7D3BB473778370AB10F49ACE2D6940AB")
    
private void
    acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.415 -0500", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "83369E3B16CB50E336C377050161880E")
    
private void
    releaseWakeLock() {
        synchronized(mPartialWakeLock) {
            if (mPartialWakeLock.isHeld()) {
                log("releaseWakeLock");
                mPartialWakeLock.release();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.417 -0500", hash_original_method = "7502A69F3ECD37971405A81286CC5AAF", hash_generated_method = "025E009FF96031D50F5B1EC684F50BAB")
    
private void log(String msg) {
        Log.d(LOG_TAG, "[GSMConn] " + msg);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.420 -0500", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "3CE0451A12E5CCA47D0CDA3753FACBAF")
    
@Override
    public int getNumberPresentation() {
        return numberPresentation;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.422 -0500", hash_original_method = "00708DAD150C484ADEE163A005CDF57B", hash_generated_method = "1542BF195939D818ECEF141CA5A831A7")
    
@Override
    public UUSInfo getUUSInfo() {
        return uusInfo;
    }
}

