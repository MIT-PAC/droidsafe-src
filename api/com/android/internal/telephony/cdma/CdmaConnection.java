package com.android.internal.telephony.cdma;

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
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.CallStateException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.DriverCall;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;






public class CdmaConnection extends Connection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.282 -0500", hash_original_method = "BC145A1DE2472995676ED9A315FB0956", hash_generated_method = "2C7138DB4A9526DAF974103E40C81A8A")
    static boolean
    equalsHandlesNulls (Object a, Object b) {
        return (a == null) ? (b == null) : a.equals (b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.319 -0500", hash_original_method = "F49BC8816CA47BDF6EE8606ECBE847B9", hash_generated_method = "6E36953EE68D98E9B786004AA124917B")
    private static boolean isPause(char c) {
        return c == PhoneNumberUtils.PAUSE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.320 -0500", hash_original_method = "AB354DE59CC4C5E04FCC9F1BE9EF5108", hash_generated_method = "CCC2E9539011D8576E609E4DB82E0420")
    private static boolean isWait(char c) {
        return c == PhoneNumberUtils.WAIT;
    }

    // This function is to find the next PAUSE character index if
    // multiple pauses in a row. Otherwise it finds the next non PAUSE or
    // non WAIT character index.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.321 -0500", hash_original_method = "CCF495396849100A49F08885D961310A", hash_generated_method = "0047B72DC4AB13616299F049FAE6A0C2")
    private static int
    findNextPCharOrNonPOrNonWCharIndex(String phoneNumber, int currIndex) {
        boolean wMatched = isWait(phoneNumber.charAt(currIndex));
        int index = currIndex + 1;
        int length = phoneNumber.length();
        while (index < length) {
            char cNext = phoneNumber.charAt(index);
            // if there is any W inside P/W sequence,mark it
            if (isWait(cNext)) {
                wMatched = true;
            }
            // if any characters other than P/W chars after P/W sequence
            // we break out the loop and append the correct
            if (!isWait(cNext) && !isPause(cNext)) {
                break;
            }
            index++;
        }

        // It means the PAUSE character(s) is in the middle of dial string
        // and it needs to be handled one by one.
        if ((index < length) && (index > (currIndex + 1))  &&
            ((wMatched == false) && isPause(phoneNumber.charAt(currIndex)))) {
            return (currIndex + 1);
        }
        return index;
    }

    // This function returns either PAUSE or WAIT character to append.
    // It is based on the next non PAUSE/WAIT character in the phoneNumber and the
    // index for the current PAUSE/WAIT character
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.322 -0500", hash_original_method = "CE89486D83ED31EF15987ED57125D91D", hash_generated_method = "6841E48D36212E920A5CB8AFDE0526A7")
    private static char
    findPOrWCharToAppend(String phoneNumber, int currPwIndex, int nextNonPwCharIndex) {
        char c = phoneNumber.charAt(currPwIndex);
        char ret;

        // Append the PW char
        ret = (isPause(c)) ? PhoneNumberUtils.PAUSE : PhoneNumberUtils.WAIT;

        // If the nextNonPwCharIndex is greater than currPwIndex + 1,
        // it means the PW sequence contains not only P characters.
        // Since for the sequence that only contains P character,
        // the P character is handled one by one, the nextNonPwCharIndex
        // equals to currPwIndex + 1.
        // In this case, skip P, append W.
        if (nextNonPwCharIndex > (currPwIndex + 1)) {
            ret = PhoneNumberUtils.WAIT;
        }
        return ret;
    }

    /**
     * format original dial string
     * 1) convert international dialing prefix "+" to
     *    string specified per region
     *
     * 2) handle corner cases for PAUSE/WAIT dialing:
     *
     *    If PAUSE/WAIT sequence at the end, ignore them.
     *
     *    If consecutive PAUSE/WAIT sequence in the middle of the string,
     *    and if there is any WAIT in PAUSE/WAIT sequence, treat them like WAIT.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.323 -0500", hash_original_method = "35294A0559DAA88DB9CC9AAC3B460FD6", hash_generated_method = "7030EA3ABA20521440FB5E77762084C9")
    public static String formatDialString(String phoneNumber) {
        /**
         * TODO(cleanup): This function should move to PhoneNumberUtils, and
         * tests should be added.
         */

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
                    // if PW not at the end
                    int nextIndex = findNextPCharOrNonPOrNonWCharIndex(phoneNumber, currIndex);
                    // If there is non PW char following PW sequence
                    if (nextIndex < length) {
                        char pC = findPOrWCharToAppend(phoneNumber, currIndex, nextIndex);
                        ret.append(pC);
                        // If PW char sequence has more than 2 PW characters,
                        // skip to the last PW character since the sequence already be
                        // converted to WAIT character
                        if (nextIndex > (currIndex + 1)) {
                            currIndex = nextIndex - 1;
                        }
                    } else if (nextIndex == length) {
                        // It means PW characters at the end, ignore
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.253 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.270 -0500", hash_original_field = "9DEE625DEB66F1732549A58AF1C8973F", hash_generated_field = "AD4EF3B653B1F446B8FA7843CFFAD818")

    static final int EVENT_DTMF_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.271 -0500", hash_original_field = "93ECE39BAE4F4558E5EDF101E65B36CA", hash_generated_field = "F19A70AEE44F70E9F9AB2D881026646D")

    static final int EVENT_PAUSE_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.271 -0500", hash_original_field = "2E31C70A59617814D2A55152CD827E3C", hash_generated_field = "1395A858C4D8C99CD84001F45B673737")

    static final int EVENT_NEXT_POST_DIAL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.272 -0500", hash_original_field = "D37B58DAA289ADBEC891FA151103DC69", hash_generated_field = "AF2C1E898DEDA846B0C4068422E6DE77")

    static final int EVENT_WAKE_LOCK_TIMEOUT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.273 -0500", hash_original_field = "1DA53076837CBD8789185EAE15BB3870", hash_generated_field = "8FB6FF16EB57719AC4F4A81C86A57CA0")

    static final int WAKE_LOCK_TIMEOUT_MILLIS = 60*1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.274 -0500", hash_original_field = "0F016183A51A7ADD1C22535BB2140223", hash_generated_field = "32583EE0477EC212D3437226C61913CB")

    static final int PAUSE_DELAY_MILLIS = 2 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.254 -0500", hash_original_field = "3927F28CE0F1F17A9255E7EFC415C1BF", hash_generated_field = "3927F28CE0F1F17A9255E7EFC415C1BF")


    CdmaCallTracker owner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.255 -0500", hash_original_field = "0FC853D69B46537C5EADDE1D3144A296", hash_generated_field = "0FC853D69B46537C5EADDE1D3144A296")

    CdmaCall parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.255 -0500", hash_original_field = "815EECE17AF4BC840D4544A9ECB9EACD", hash_generated_field = "815EECE17AF4BC840D4544A9ECB9EACD")



    String address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.256 -0500", hash_original_field = "F515901190E6B9979D62CEFE77655CD0", hash_generated_field = "F515901190E6B9979D62CEFE77655CD0")

    String dialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.257 -0500", hash_original_field = "8276078622B570793705E396A0D7F62F", hash_generated_field = "8276078622B570793705E396A0D7F62F")

    String postDialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.257 -0500", hash_original_field = "4C77869A4C7C09DEF349ED266B2A3A42", hash_generated_field = "4C77869A4C7C09DEF349ED266B2A3A42")

    boolean isIncoming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.258 -0500", hash_original_field = "0A66E61F25EE1D53440481E40AA3E515", hash_generated_field = "0A66E61F25EE1D53440481E40AA3E515")

    boolean disconnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.259 -0500", hash_original_field = "A86CFAAA1D8CDA1D974D232F92D46C54", hash_generated_field = "A86CFAAA1D8CDA1D974D232F92D46C54")

    String cnapName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.259 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.260 -0500", hash_original_field = "88A71A811D0CFD868BD514D9A7A9DADE", hash_generated_field = "E6D9FD62976ABFC51B4942290AD91A59")


    /*
     * These time/timespan values are based on System.currentTimeMillis(),
     * i.e., "wall clock" time.
     */
    long createTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.261 -0500", hash_original_field = "4688FD5CCB150978DDBAC76460D6A697", hash_generated_field = "4688FD5CCB150978DDBAC76460D6A697")

    long connectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.261 -0500", hash_original_field = "6F4281795E649655EEAED8CC4AFFA7C4", hash_generated_field = "6F4281795E649655EEAED8CC4AFFA7C4")

    long disconnectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.262 -0500", hash_original_field = "FB007E1B198D105ABB5DFCFDF540B71E", hash_generated_field = "FB007E1B198D105ABB5DFCFDF540B71E")

    long connectTimeReal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.263 -0500", hash_original_field = "55107CF285B030B92DD9E509D85ADD9E", hash_generated_field = "55107CF285B030B92DD9E509D85ADD9E")

    long duration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.263 -0500", hash_original_field = "39B3C41F5817B2E3B391281A0E9E890F", hash_generated_field = "39B3C41F5817B2E3B391281A0E9E890F")

    long holdingStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.264 -0500", hash_original_field = "6EBA36FD71F695F0A7004724AFD9D8F8", hash_generated_field = "C1E13AD275293435ED8EAB8BE0D4E663")

                            // into HOLDING

    int nextPostDialChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.265 -0500", hash_original_field = "846032E4A4EEA9EEF5F261B33CBAFAE8", hash_generated_field = "846032E4A4EEA9EEF5F261B33CBAFAE8")


    DisconnectCause cause = DisconnectCause.NOT_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.266 -0500", hash_original_field = "12225F767E33A7C05BECAD37785471A6", hash_generated_field = "12225F767E33A7C05BECAD37785471A6")

    PostDialState postDialState = PostDialState.NOT_STARTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.267 -0500", hash_original_field = "34BF499978B1A906EDC3EA4DB0168C11", hash_generated_field = "34BF499978B1A906EDC3EA4DB0168C11")

    int numberPresentation = Connection.PRESENTATION_ALLOWED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.267 -0500", hash_original_field = "C4B8315EB90D5A6B253E1367ECCBDAE5", hash_generated_field = "C4B8315EB90D5A6B253E1367ECCBDAE5")

    int cnapNamePresentation  = Connection.PRESENTATION_ALLOWED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.268 -0500", hash_original_field = "47D42CB1DCDC1AD18224D34E3D8719BD", hash_generated_field = "47D42CB1DCDC1AD18224D34E3D8719BD")



    Handler h;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.269 -0500", hash_original_field = "DD211FB7C7A1365A3C66A0CF1B432479", hash_generated_field = "FBF2003A3FDB636C3C20603FE4A47D62")


    private PowerManager.WakeLock mPartialWakeLock;

    //***** Constructors

    /** This is probably an MT call that we first saw in a CLCC response */
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.277 -0500", hash_original_method = "252146C166F3942BC369E08F0120D87D", hash_generated_method = "252146C166F3942BC369E08F0120D87D")
    CdmaConnection (Context context, DriverCall dc, CdmaCallTracker ct, int index) {
        createWakeLock(context);
        acquireWakeLock();

        owner = ct;
        h = new MyHandler(owner.getLooper());

        address = dc.number;

        isIncoming = dc.isMT;
        createTime = System.currentTimeMillis();
        cnapName = dc.name;
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;

        this.index = index;

        parent = parentFromDCState (dc.state);
        parent.attach(this, dc);
    }

    /** This is an MO call/three way call, created when dialing */
    /*package*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.279 -0500", hash_original_method = "2CBB8BA051416BBE1CBD482FDF45ADE6", hash_generated_method = "FE6D14DB988140C70DE8975E0CE436AC")
    CdmaConnection(Context context, String dialString, CdmaCallTracker ct, CdmaCall parent) {
        createWakeLock(context);
        acquireWakeLock();

        owner = ct;
        h = new MyHandler(owner.getLooper());

        this.dialString = dialString;
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

        if (parent != null) {
            this.parent = parent;

            //for the three way call case, not change parent state
            if (parent.state == CdmaCall.State.ACTIVE) {
                parent.attachFake(this, CdmaCall.State.ACTIVE);
            } else {
                parent.attachFake(this, CdmaCall.State.DIALING);
            }
        }
    }

    /** This is a Call waiting call*/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.280 -0500", hash_original_method = "5BADF30C241906ADFE33CA4BF6040CF6", hash_generated_method = "5BADF30C241906ADFE33CA4BF6040CF6")
    CdmaConnection(Context context, CdmaCallWaitingNotification cw, CdmaCallTracker ct,
            CdmaCall parent) {
        createWakeLock(context);
        acquireWakeLock();

        owner = ct;
        h = new MyHandler(owner.getLooper());
        address = cw.number;
        numberPresentation = cw.numberPresentation;
        cnapName = cw.name;
        cnapNamePresentation = cw.namePresentation;
        index = -1;
        isIncoming = true;
        createTime = System.currentTimeMillis();
        connectTime = 0;
        this.parent = parent;
        parent.attachFake(this, CdmaCall.State.WAITING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.281 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    public void dispose() {
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.283 -0500", hash_original_method = "0553AC873EBF02DCE0ECDD52D690154B", hash_generated_method = "065B6A32C6CA7063A00EB20821FEE8BC")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.283 -0500", hash_original_method = "6F928BB99E2E6BC2006496B43FE5B2BF", hash_generated_method = "DBBDA58DEEBF55C34D5BEB75B3F597B1")
    public String getOrigDialString(){
        return dialString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.284 -0500", hash_original_method = "1A89DAB454CED0757504258169B34CDA", hash_generated_method = "9D79DFDD8EA73AA9BC42783E0AB77415")
    public String getAddress() {
        return address;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.285 -0500", hash_original_method = "4560204D66D34538CD3AB1593D4A1973", hash_generated_method = "D7F1113C541CC402EEBEE7632B7C5D8A")
    public String getCnapName() {
        return cnapName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.286 -0500", hash_original_method = "6FC157D9E3C072CC35BEF8FF58FADB81", hash_generated_method = "23E2E258D4BD9AF8367146BC7957A370")
    public int getCnapNamePresentation() {
        return cnapNamePresentation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.286 -0500", hash_original_method = "937C2C323E4DD6DAF328A1D3C89DA773", hash_generated_method = "76B56C54CA221FC9697555991BA5A1A1")
    public CdmaCall getCall() {
        return parent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.287 -0500", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "A28981F024E432A69A5EE6C2C2A713AE")
    public long getCreateTime() {
        return createTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.288 -0500", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "F3878C4EA8EC161DB4C86B7EE0828514")
    public long getConnectTime() {
        return connectTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.289 -0500", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "B4593A4A250C143E07993447C4BE4305")
    public long getDisconnectTime() {
        return disconnectTime;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.289 -0500", hash_original_method = "BD4C2261BA208AFE25AC1FD20DCCA9E3", hash_generated_method = "CF314DE5EA8CCD1CF80C405480A4ED6D")
    public long getDurationMillis() {
        if (connectTimeReal == 0) {
            return 0;
        } else if (duration == 0) {
            return SystemClock.elapsedRealtime() - connectTimeReal;
        } else {
            return duration;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.290 -0500", hash_original_method = "34EF3C96D32FA03DD59341E50744B728", hash_generated_method = "2583FED46A8ECBE5646568C473EF4089")
    public long getHoldDurationMillis() {
        if (getState() != CdmaCall.State.HOLDING) {
            // If not holding, return 0
            return 0;
        } else {
            return SystemClock.elapsedRealtime() - holdingStartTime;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.291 -0500", hash_original_method = "217FE2B36472CD2DEDDE3A4CE2A1C951", hash_generated_method = "9282122F6BAD3F883AADDAE6681CD7D5")
    public DisconnectCause getDisconnectCause() {
        return cause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.292 -0500", hash_original_method = "7EA17727186891EE64F6BAA03D5CD808", hash_generated_method = "30744870D5463E3A1E2FF89E6E52472D")
    public boolean isIncoming() {
        return isIncoming;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.293 -0500", hash_original_method = "9E47A22386C6805D766AB39B80135287", hash_generated_method = "9A9F23094CC31CF2216430D3C9A16645")
    public CdmaCall.State getState() {
        if (disconnected) {
            return CdmaCall.State.DISCONNECTED;
        } else {
            return super.getState();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.294 -0500", hash_original_method = "D57E67C02460F6585EAC58BAB884B4F4", hash_generated_method = "4CF1FE8A4888E47AA493321FE63615C0")
    public void hangup() throws CallStateException {
        if (!disconnected) {
            owner.hangup(this);
        } else {
            throw new CallStateException ("disconnected");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.295 -0500", hash_original_method = "35A05AA5488BBB104981851B538690A0", hash_generated_method = "4C27373F4B78030B0B1D4BBE76B84F15")
    public void separate() throws CallStateException {
        if (!disconnected) {
            owner.separate(this);
        } else {
            throw new CallStateException ("disconnected");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.296 -0500", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "9FE402970AA08455EE526E2EA42EFD5E")
    public PostDialState getPostDialState() {
        return postDialState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.297 -0500", hash_original_method = "9CB0C2169F8DC9A190B4B58A2920953F", hash_generated_method = "92DCD30CA6ADD71B52122676B1A561AF")
    public void proceedAfterWaitChar() {
        if (postDialState != PostDialState.WAIT) {
            Log.w(LOG_TAG, "CdmaConnection.proceedAfterWaitChar(): Expected "
                + "getPostDialState() to be WAIT but was " + postDialState);
            return;
        }

        setPostDialState(PostDialState.STARTED);

        processNextPostDialChar();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.298 -0500", hash_original_method = "F5AACA76A39AA5565E13BE5EAE20DB2C", hash_generated_method = "860F5D86614B3257B58BDFCBDC34B707")
    public void proceedAfterWildChar(String str) {
        if (postDialState != PostDialState.WILD) {
            Log.w(LOG_TAG, "CdmaConnection.proceedAfterWaitChar(): Expected "
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.298 -0500", hash_original_method = "679645DC6ABB08169BFD07038B9B2F3F", hash_generated_method = "F55D1C15AE51897B81A42C8B6C6E9B67")
    public void cancelPostDial() {
        setPostDialState(PostDialState.CANCELLED);
    }

    /**
     * Called when this Connection is being hung up locally (eg, user pressed "end")
     * Note that at this point, the hangup request has been dispatched to the radio
     * but no response has yet been received so update() has not yet been called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.299 -0500", hash_original_method = "1D26914F95E4E8CAB857832B14C412F2", hash_generated_method = "1D26914F95E4E8CAB857832B14C412F2")
    void
    onHangupLocal() {
        cause = DisconnectCause.LOCAL;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.300 -0500", hash_original_method = "A61D9E53307E65432299CCBF8D846DEE", hash_generated_method = "5146EBAF816234ADAFDD07631477B15A")
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
                return DisconnectCause.CONGESTION;
            case CallFailCause.ACM_LIMIT_EXCEEDED:
                return DisconnectCause.LIMIT_EXCEEDED;
            case CallFailCause.CALL_BARRED:
                return DisconnectCause.CALL_BARRED;
            case CallFailCause.FDN_BLOCKED:
                return DisconnectCause.FDN_BLOCKED;
            case CallFailCause.CDMA_LOCKED_UNTIL_POWER_CYCLE:
                return DisconnectCause.CDMA_LOCKED_UNTIL_POWER_CYCLE;
            case CallFailCause.CDMA_DROP:
                return DisconnectCause.CDMA_DROP;
            case CallFailCause.CDMA_INTERCEPT:
                return DisconnectCause.CDMA_INTERCEPT;
            case CallFailCause.CDMA_REORDER:
                return DisconnectCause.CDMA_REORDER;
            case CallFailCause.CDMA_SO_REJECT:
                return DisconnectCause.CDMA_SO_REJECT;
            case CallFailCause.CDMA_RETRY_ORDER:
                return DisconnectCause.CDMA_RETRY_ORDER;
            case CallFailCause.CDMA_ACCESS_FAILURE:
                return DisconnectCause.CDMA_ACCESS_FAILURE;
            case CallFailCause.CDMA_PREEMPTED:
                return DisconnectCause.CDMA_PREEMPTED;
            case CallFailCause.CDMA_NOT_EMERGENCY:
                return DisconnectCause.CDMA_NOT_EMERGENCY;
            case CallFailCause.CDMA_ACCESS_BLOCKED:
                return DisconnectCause.CDMA_ACCESS_BLOCKED;
            case CallFailCause.ERROR_UNSPECIFIED:
            case CallFailCause.NORMAL_CLEARING:
            default:
                CDMAPhone phone = owner.phone;
                int serviceState = phone.getServiceState().getState();
                if (serviceState == ServiceState.STATE_POWER_OFF) {
                    return DisconnectCause.POWER_OFF;
                } else if (serviceState == ServiceState.STATE_OUT_OF_SERVICE
                        || serviceState == ServiceState.STATE_EMERGENCY_ONLY) {
                    return DisconnectCause.OUT_OF_SERVICE;
                } else if (phone.mCM.getNvState() != CommandsInterface.RadioState.NV_READY
                        && phone.getIccCard().getState() != RuimCard.State.READY) {
                    return DisconnectCause.ICC_ERROR;
                } else if (causeCode==CallFailCause.NORMAL_CLEARING) {
                    return DisconnectCause.NORMAL;
                } else {
                    return DisconnectCause.ERROR_UNSPECIFIED;
                }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.301 -0500", hash_original_method = "6DD0016A82A0EEA168B83665DD86A0FB", hash_generated_method = "6DD0016A82A0EEA168B83665DD86A0FB")
    void
    onRemoteDisconnect(int causeCode) {
        onDisconnect(disconnectCauseFromCode(causeCode));
    }

    /** Called when the radio indicates the connection has been disconnected */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.302 -0500", hash_original_method = "A0289A7B3A70CC200EF898FF0A442041", hash_generated_method = "A0289A7B3A70CC200EF898FF0A442041")
    void
    onDisconnect(DisconnectCause cause) {
        this.cause = cause;

        if (!disconnected) {
            doDisconnect();
            if (false) Log.d(LOG_TAG,
                    "[CDMAConn] onDisconnect: cause=" + cause);

            owner.phone.notifyDisconnect(this);

            if (parent != null) {
                parent.connectionDisconnected(this);
            }
        }
        releaseWakeLock();
    }

    /** Called when the call waiting connection has been hung up */
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.302 -0500", hash_original_method = "26AAE16553DBF302B5AA3D0248CB78BC", hash_generated_method = "26AAE16553DBF302B5AA3D0248CB78BC")
    void
    onLocalDisconnect() {
        if (!disconnected) {
            doDisconnect();
            if (false) Log.d(LOG_TAG,
                    "[CDMAConn] onLoalDisconnect" );

            if (parent != null) {
                parent.detach(this);
            }
        }
        releaseWakeLock();
    }

    // Returns true if state has changed, false if nothing changed
    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.303 -0500", hash_original_method = "4236BCB2C869FC2E101A72CBA66F1959", hash_generated_method = "81BF2206D25F21807CCFA4C17FB5EC28")
    boolean
    update (DriverCall dc) {
        CdmaCall newParent;
        boolean changed = false;
        boolean wasConnectingInOrOut = isConnectingInOrOut();
        boolean wasHolding = (getState() == CdmaCall.State.HOLDING);

        newParent = parentFromDCState(dc.state);

        if (Phone.DEBUG_PHONE) log("parent= " +parent +", newParent= " + newParent);

        if (!equalsHandlesNulls(address, dc.number)) {
            if (Phone.DEBUG_PHONE) log("update: phone # changed!");
            address = dc.number;
            changed = true;
        }

        // A null cnapName should be the same as ""
        if (TextUtils.isEmpty(dc.name)) {
            if (!TextUtils.isEmpty(cnapName)) {
                changed = true;
                cnapName = "";
            }
        } else if (!dc.name.equals(cnapName)) {
            changed = true;
            cnapName = dc.name;
        }

        if (Phone.DEBUG_PHONE) log("--dssds----"+cnapName);
        cnapNamePresentation = dc.namePresentation;
        numberPresentation = dc.numberPresentation;

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
                "Update, wasConnectingInOrOut=" + wasConnectingInOrOut +
                ", wasHolding=" + wasHolding +
                ", isConnectingInOrOut=" + isConnectingInOrOut() +
                ", changed=" + changed);


        if (wasConnectingInOrOut && !isConnectingInOrOut()) {
            onConnectedInOrOut();
        }

        if (changed && !wasHolding && (getState() == CdmaCall.State.HOLDING)) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.304 -0500", hash_original_method = "2801C91DD04690F39967B3B139B04FC8", hash_generated_method = "2801C91DD04690F39967B3B139B04FC8")
    void
    fakeHoldBeforeDial() {
        if (parent != null) {
            parent.detach(this);
        }

        parent = owner.backgroundCall;
        parent.attachFake(this, CdmaCall.State.HOLDING);

        onStartedHolding();
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.305 -0500", hash_original_method = "94F7523429B223E41798A5302127009B", hash_generated_method = "94F7523429B223E41798A5302127009B")
    int
    getCDMAIndex() throws CallStateException {
        if (index >= 0) {
            return index + 1;
        } else {
            throw new CallStateException ("CDMA connection index not assigned");
        }
    }

    /**
     * An incoming or outgoing call has connected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.306 -0500", hash_original_method = "42698948AA1B3CB52B9A6434DAA41A35", hash_generated_method = "23050AD49C3D1619F91265D3530DC78F")
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
        } else {
            // Only release wake lock for incoming calls, for outgoing calls the wake lock
            // will be released after any pause-dial is completed
            releaseWakeLock();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.307 -0500", hash_original_method = "0E9E222A942778E934D11665B83572CB", hash_generated_method = "50401168B52C3C5FA50B12B05890A416")
    private void
    doDisconnect() {
       index = -1;
       disconnectTime = System.currentTimeMillis();
       duration = SystemClock.elapsedRealtime() - connectTimeReal;
       disconnected = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.308 -0500", hash_original_method = "347BE2897DC754C8C9568E8ADC73CA48", hash_generated_method = "6EA028C22A00C67FA168002DDA2CF290")
    private void
    onStartedHolding() {
        holdingStartTime = SystemClock.elapsedRealtime();
    }
    /**
     * Performs the appropriate action for a post-dial char, but does not
     * notify application. returns false if the character is invalid and
     * should be ignored
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.309 -0500", hash_original_method = "DEA7A97D3D4EC63922E017A45C0AA963", hash_generated_method = "F0DCFEFD15110B1D5758A76020B55CFF")
    private boolean
    processPostDialChar(char c) {
        if (PhoneNumberUtils.is12Key(c)) {
            owner.cm.sendDtmf(c, h.obtainMessage(EVENT_DTMF_DONE));
        } else if (c == PhoneNumberUtils.PAUSE) {
            setPostDialState(PostDialState.PAUSE);

            // Upon occurrences of the separator, the UE shall
            // pause again for 2 seconds before sending any
            // further DTMF digits.
            h.sendMessageDelayed(h.obtainMessage(EVENT_PAUSE_DONE),
                                            PAUSE_DELAY_MILLIS);
        } else if (c == PhoneNumberUtils.WAIT) {
            setPostDialState(PostDialState.WAIT);
        } else if (c == PhoneNumberUtils.WILD) {
            setPostDialState(PostDialState.WILD);
        } else {
            return false;
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.310 -0500", hash_original_method = "5249FEA4AA339015595CA186429F9201", hash_generated_method = "FD96968B234F3C04DC131E4845C7C7FE")
    public String getRemainingPostDialString() {
        if (postDialState == PostDialState.CANCELLED
                || postDialState == PostDialState.COMPLETE
                || postDialString == null
                || postDialString.length() <= nextPostDialChar) {
            return "";
        }

        String subStr = postDialString.substring(nextPostDialChar);
        if (subStr != null) {
            int wIndex = subStr.indexOf(PhoneNumberUtils.WAIT);
            int pIndex = subStr.indexOf(PhoneNumberUtils.PAUSE);

            if (wIndex > 0 && (wIndex < pIndex || pIndex <= 0)) {
                subStr = subStr.substring(0, wIndex);
            } else if (pIndex > 0) {
                subStr = subStr.substring(0, pIndex);
            }
        }
        return subStr;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.311 -0500", hash_original_method = "EF4409185398C31E88F7CD7AC688130B", hash_generated_method = "DBB2FCB3047B60BF545F898C67AF56CD")
    public void updateParent(CdmaCall oldParent, CdmaCall newParent){
        if (newParent != oldParent) {
            if (oldParent != null) {
                oldParent.detach(this);
            }
            newParent.attachFake(this, CdmaCall.State.ACTIVE);
            parent = newParent;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.312 -0500", hash_original_method = "5655DC41B31D0FB22D5FC53E0B7ADD4A", hash_generated_method = "D87042DE1FFE48AA01A04FF54AA3C113")
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
            Log.e(LOG_TAG, "[CdmaConn] UNEXPECTED; mPartialWakeLock is held when finalizing.");
        }
        releaseWakeLock();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.313 -0500", hash_original_method = "EB1ACECD3BB7B8254CD65689A960D6CE", hash_generated_method = "71BAD093FD9E68977142B030D286C4D9")
    void processNextPostDialChar() {
        char c = 0;
        Registrant postDialHandler;

        if (postDialState == PostDialState.CANCELLED) {
            releaseWakeLock();
            //Log.v("CDMA", "##### processNextPostDialChar: postDialState == CANCELLED, bail");
            return;
        }

        if (postDialString == null ||
                postDialString.length() <= nextPostDialChar) {
            setPostDialState(PostDialState.COMPLETE);

            // We were holding a wake lock until pause-dial was complete, so give it up now
            releaseWakeLock();

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
                Log.e("CDMA", "processNextPostDialChar: c=" + c + " isn't valid!");
                return;
            }
        }

        postDialHandler = owner.phone.mPostDialHandler;

        Message notifyMessage;

        if (postDialHandler != null &&
                (notifyMessage = postDialHandler.messageForRegistrant()) != null) {
            // The AsyncResult.result is the Connection object
            PostDialState state = postDialState;
            AsyncResult ar = AsyncResult.forMessage(notifyMessage);
            ar.result = this;
            ar.userObj = state;

            // arg1 is the character that was/is being processed
            notifyMessage.arg1 = c;

            notifyMessage.sendToTarget();
        }
    }


    /** "connecting" means "has never been ACTIVE" for both incoming
     *  and outgoing calls
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.314 -0500", hash_original_method = "EBFF7E74C490A6457BB1227BB1C69161", hash_generated_method = "CFA67350936CB116E605A59CB3576D4B")
    private boolean
    isConnectingInOrOut() {
        return parent == null || parent == owner.ringingCall
            || parent.state == CdmaCall.State.DIALING
            || parent.state == CdmaCall.State.ALERTING;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.315 -0500", hash_original_method = "52FAD8AAB1788292D1998385AF3423D2", hash_generated_method = "E9A46F2871CC6D51BF8B6A174FF40CC3")
    private CdmaCall
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

    
    class MyHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.275 -0500", hash_original_method = "2B93823BE9CDEC6A395C6867AE57FF4F", hash_generated_method = "2B93823BE9CDEC6A395C6867AE57FF4F")
        MyHandler(Looper l) {super(l);}

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.276 -0500", hash_original_method = "E8F40E6883CDABD6C8E283CE0D2B4E28", hash_generated_method = "9AEB0D6EEF8F90C85341CDE5285B08AA")
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

    /**
     * Set post dial state and acquire wake lock while switching to "started" or "wait"
     * state, the wake lock will be released if state switches out of "started" or "wait"
     * state or after WAKE_LOCK_TIMEOUT_MILLIS.
     * @param s new PostDialState
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.316 -0500", hash_original_method = "FF12FA2494FF1BBACACCAD317AF3BA4C", hash_generated_method = "228D1782AC0930E0381344AC8C57344C")
    private void setPostDialState(PostDialState s) {
        if (s == PostDialState.STARTED ||
                s == PostDialState.PAUSE) {
            synchronized (mPartialWakeLock) {
                if (mPartialWakeLock.isHeld()) {
                    h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
                } else {
                    acquireWakeLock();
                }
                Message msg = h.obtainMessage(EVENT_WAKE_LOCK_TIMEOUT);
                h.sendMessageDelayed(msg, WAKE_LOCK_TIMEOUT_MILLIS);
            }
        } else {
            h.removeMessages(EVENT_WAKE_LOCK_TIMEOUT);
            releaseWakeLock();
        }
        postDialState = s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.317 -0500", hash_original_method = "CB8FDA401075BC400671977D794CC25C", hash_generated_method = "01B3024D6E6F76F8BF272926384E7FD0")
    private void createWakeLock(Context context) {
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mPartialWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, LOG_TAG);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.317 -0500", hash_original_method = "0032D3EFE2E921D247B095F82BB6680D", hash_generated_method = "7D3BB473778370AB10F49ACE2D6940AB")
    private void acquireWakeLock() {
        log("acquireWakeLock");
        mPartialWakeLock.acquire();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.318 -0500", hash_original_method = "EF603679E4FE39B900CF6CFCDD40B49D", hash_generated_method = "83369E3B16CB50E336C377050161880E")
    private void releaseWakeLock() {
        synchronized (mPartialWakeLock) {
            if (mPartialWakeLock.isHeld()) {
                log("releaseWakeLock");
                mPartialWakeLock.release();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.324 -0500", hash_original_method = "8DB105505540FC3FC6E637FFB094FC3A", hash_generated_method = "4E727B3C854B2B30B55A6C4DFD328957")
    private void log(String msg) {
        Log.d(LOG_TAG, "[CDMAConn] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.325 -0500", hash_original_method = "B2C780D7BF03A84FC8B3CC6F33ADADA1", hash_generated_method = "3CE0451A12E5CCA47D0CDA3753FACBAF")
    @Override
public int getNumberPresentation() {
        return numberPresentation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:21.326 -0500", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "59C272D085C12CF443E0D702BB83E292")
    @Override
public UUSInfo getUUSInfo() {
        // UUS information not supported in CDMA
        return null;
    }
}

