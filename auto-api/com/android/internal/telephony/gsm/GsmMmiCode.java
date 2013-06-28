package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import com.android.internal.telephony.*;
import android.os.*;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import static com.android.internal.telephony.CommandsInterface.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class GsmMmiCode extends Handler implements MmiCode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "8D111C48FFCFB880A1878EEA7D383221", hash_generated_field = "75B5B7D441FCCB2BF9802C8C7F593C9E")

    private boolean isPendingUSSD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "07574527064CCEC9D1F5EEA5FA7C4751", hash_generated_field = "A601B09474CCCD19D7EF905D10ED4B31")

    private boolean isUssdRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.324 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.325 -0400", hash_original_method = "1F245899EC025E108E5BE08C8380C5BD", hash_generated_method = "AE1A92BE86BC124C3840C6CA8E93CC5D")
      GsmMmiCode(GSMPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
        // ---------- Original Method ----------
        //this.phone = phone;
        //this.context = phone.getContext();
    }

    
    static GsmMmiCode newFromDialString(String dialString, GSMPhone phone) {
        Matcher m;
        GsmMmiCode ret = null;
        m = sPatternSuppService.matcher(dialString);
        if (m.matches()) {
            ret = new GsmMmiCode(phone);
            ret.poundString = makeEmptyNull(m.group(MATCH_GROUP_POUND_STRING));
            ret.action = makeEmptyNull(m.group(MATCH_GROUP_ACTION));
            ret.sc = makeEmptyNull(m.group(MATCH_GROUP_SERVICE_CODE));
            ret.sia = makeEmptyNull(m.group(MATCH_GROUP_SIA));
            ret.sib = makeEmptyNull(m.group(MATCH_GROUP_SIB));
            ret.sic = makeEmptyNull(m.group(MATCH_GROUP_SIC));
            ret.pwd = makeEmptyNull(m.group(MATCH_GROUP_PWD_CONFIRM));
            ret.dialingNumber = makeEmptyNull(m.group(MATCH_GROUP_DIALING_NUMBER));
        } else if (dialString.endsWith("#")) {
            ret = new GsmMmiCode(phone);
            ret.poundString = dialString;
        } else if (isTwoDigitShortCode(phone.getContext(), dialString)) {
            ret = null;
        } else if (isShortCode(dialString, phone)) {
            ret = new GsmMmiCode(phone);
            ret.dialingNumber = dialString;
        }
        return ret;
    }

    
    static GsmMmiCode newNetworkInitiatedUssd(String ussdMessage,
                                boolean isUssdRequest, GSMPhone phone) {
        GsmMmiCode ret;
        ret = new GsmMmiCode(phone);
        ret.message = ussdMessage;
        ret.isUssdRequest = isUssdRequest;
        if (isUssdRequest) {
            ret.isPendingUSSD = true;
            ret.state = State.PENDING;
        } else {
            ret.state = State.COMPLETE;
        }
        return ret;
    }

    
    static GsmMmiCode newFromUssdUserInput(String ussdMessge, GSMPhone phone) {
        GsmMmiCode ret = new GsmMmiCode(phone);
        ret.message = ussdMessge;
        ret.state = State.PENDING;
        ret.isPendingUSSD = true;
        return ret;
    }

    
    private static String makeEmptyNull(String s) {
        if (s != null && s.length() == 0) return null;
        return s;
    }

    
    private static boolean isEmptyOrNull(CharSequence s) {
        return s == null || (s.length() == 0);
    }

    
    private static int scToCallForwardReason(String sc) {
        if (sc == null) {
            throw new RuntimeException ("invalid call forward sc");
        }
        if (sc.equals(SC_CF_All)) {
           return CommandsInterface.CF_REASON_ALL;
        } else if (sc.equals(SC_CFU)) {
            return CommandsInterface.CF_REASON_UNCONDITIONAL;
        } else if (sc.equals(SC_CFB)) {
            return CommandsInterface.CF_REASON_BUSY;
        } else if (sc.equals(SC_CFNR)) {
            return CommandsInterface.CF_REASON_NOT_REACHABLE;
        } else if (sc.equals(SC_CFNRy)) {
            return CommandsInterface.CF_REASON_NO_REPLY;
        } else if (sc.equals(SC_CF_All_Conditional)) {
           return CommandsInterface.CF_REASON_ALL_CONDITIONAL;
        } else {
            throw new RuntimeException ("invalid call forward sc");
        }
    }

    
    private static int siToServiceClass(String si) {
        if (si == null || si.length() == 0) {
                return  SERVICE_CLASS_NONE;
        } else {
            int serviceCode = Integer.parseInt(si, 10);
            switch (serviceCode) {
                case 10: return SERVICE_CLASS_SMS + SERVICE_CLASS_FAX  + SERVICE_CLASS_VOICE;
                case 11: return SERVICE_CLASS_VOICE;
                case 12: return SERVICE_CLASS_SMS + SERVICE_CLASS_FAX;
                case 13: return SERVICE_CLASS_FAX;
                case 16: return SERVICE_CLASS_SMS;
                case 19: return SERVICE_CLASS_FAX + SERVICE_CLASS_VOICE;
                case 20: return SERVICE_CLASS_DATA_ASYNC + SERVICE_CLASS_DATA_SYNC;
                case 21: return SERVICE_CLASS_PAD + SERVICE_CLASS_DATA_ASYNC;
                case 22: return SERVICE_CLASS_PACKET + SERVICE_CLASS_DATA_SYNC;
                case 24: return SERVICE_CLASS_DATA_SYNC;
                case 25: return SERVICE_CLASS_DATA_ASYNC;
                case 26: return SERVICE_CLASS_DATA_SYNC + SERVICE_CLASS_VOICE;
                case 99: return SERVICE_CLASS_PACKET;
                default:
                    throw new RuntimeException("unsupported MMI service code " + si);
            }
        }
    }

    
    private static int siToTime(String si) {
        if (si == null || si.length() == 0) {
            return 0;
        } else {
            return Integer.parseInt(si, 10);
        }
    }

    
    static boolean isServiceCodeCallForwarding(String sc) {
        return sc != null &&
                (sc.equals(SC_CFU)
                || sc.equals(SC_CFB) || sc.equals(SC_CFNRy)
                || sc.equals(SC_CFNR) || sc.equals(SC_CF_All)
                || sc.equals(SC_CF_All_Conditional));
    }

    
    static boolean isServiceCodeCallBarring(String sc) {
        return sc != null &&
                (sc.equals(SC_BAOC)
                || sc.equals(SC_BAOIC)
                || sc.equals(SC_BAOICxH)
                || sc.equals(SC_BAIC)
                || sc.equals(SC_BAICr)
                || sc.equals(SC_BA_ALL)
                || sc.equals(SC_BA_MO)
                || sc.equals(SC_BA_MT));
    }

    
    static String scToBarringFacility(String sc) {
        if (sc == null) {
            throw new RuntimeException ("invalid call barring sc");
        }
        if (sc.equals(SC_BAOC)) {
            return CommandsInterface.CB_FACILITY_BAOC;
        } else if (sc.equals(SC_BAOIC)) {
            return CommandsInterface.CB_FACILITY_BAOIC;
        } else if (sc.equals(SC_BAOICxH)) {
            return CommandsInterface.CB_FACILITY_BAOICxH;
        } else if (sc.equals(SC_BAIC)) {
            return CommandsInterface.CB_FACILITY_BAIC;
        } else if (sc.equals(SC_BAICr)) {
            return CommandsInterface.CB_FACILITY_BAICr;
        } else if (sc.equals(SC_BA_ALL)) {
            return CommandsInterface.CB_FACILITY_BA_ALL;
        } else if (sc.equals(SC_BA_MO)) {
            return CommandsInterface.CB_FACILITY_BA_MO;
        } else if (sc.equals(SC_BA_MT)) {
            return CommandsInterface.CB_FACILITY_BA_MT;
        } else {
            throw new RuntimeException ("invalid call barring sc");
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.327 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "3A4A5397EDADC8AB93C0DBF42D244541")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_280571811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_280571811 = state;
        varB4EAC82CA7396A68D541C85D26508E83_280571811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_280571811;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.328 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "C2BAC143CB326917BA7450A9135B6E32")
    public CharSequence getMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1994533820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1994533820 = message;
        varB4EAC82CA7396A68D541C85D26508E83_1994533820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1994533820;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.329 -0400", hash_original_method = "E883165C6689A3782C7AFFDB1FCF97C2", hash_generated_method = "DDD294D2F15DC82E2D473B5D0C41FEB6")
    public void cancel() {
        state = State.CANCELLED;
        {
            phone.mCM.cancelPendingUssd(obtainMessage(EVENT_USSD_CANCEL_COMPLETE, this));
        } //End block
        {
            phone.onMMIDone (this);
        } //End block
        // ---------- Original Method ----------
        //if (state == State.COMPLETE || state == State.FAILED) {
            //return;
        //}
        //state = State.CANCELLED;
        //if (isPendingUSSD) {
            //phone.mCM.cancelPendingUssd(obtainMessage(EVENT_USSD_CANCEL_COMPLETE, this));
        //} else {
            //phone.onMMIDone (this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.330 -0400", hash_original_method = "248235E8DF3E05BA5583B3AF86C41C77", hash_generated_method = "9FFDDB23492F7408CE2A882FB265C7E8")
    public boolean isCancelable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1470174279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1470174279;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.330 -0400", hash_original_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C", hash_generated_method = "F7D7899B4CBAEC49B78B7217F1DE3B28")
     boolean isMMI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087834489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087834489;
        // ---------- Original Method ----------
        //return poundString != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.330 -0400", hash_original_method = "C27864618833FAFE773E7DA58094B237", hash_generated_method = "8D1FC91F18B01C311F2320C64A60684B")
     boolean isShortCode() {
        boolean var5484DF39387CF98FB51501CB4001F9FA_1173795792 = (poundString == null
                    && dialingNumber != null && dialingNumber.length() <= 2);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659468070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659468070;
        // ---------- Original Method ----------
        //return poundString == null
                    //&& dialingNumber != null && dialingNumber.length() <= 2;
    }

    
    static private boolean isTwoDigitShortCode(Context context, String dialString) {
        Log.d(LOG_TAG, "isTwoDigitShortCode");
        if (dialString == null || dialString.length() != 2) return false;
        if (sTwoDigitNumberPattern == null) {
            sTwoDigitNumberPattern = context.getResources().getStringArray(
                    com.android.internal.R.array.config_twoDigitNumberPattern);
        }
        for (String dialnumber : sTwoDigitNumberPattern) {
            Log.d(LOG_TAG, "Two Digit Number Pattern " + dialnumber);
            if (dialString.equals(dialnumber)) {
                Log.d(LOG_TAG, "Two Digit Number Pattern -true");
                return true;
            }
        }
        Log.d(LOG_TAG, "Two Digit Number Pattern -false");
        return false;
    }

    
    static private boolean isShortCode(String dialString, GSMPhone phone) {
        if (dialString == null) {
            return false;
        }
        if (dialString.length() == 0) {
            return false;
        }
        if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            return false;
        } else {
            return isShortCodeUSSD(dialString, phone);
        }
    }

    
    static private boolean isShortCodeUSSD(String dialString, GSMPhone phone) {
        if (dialString != null) {
            if (phone.isInCall()) {
                if (dialString.length() <= MAX_LENGTH_SHORT_CODE) {
                    return true;
                }
            }
            if (dialString.length() <= MAX_LENGTH_SHORT_CODE) {
                if (dialString.charAt(dialString.length() - 1) == END_OF_USSD_COMMAND) {
                    return true;
                }
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.331 -0400", hash_original_method = "59EBB8632489E0E4FC2DAAE2E73A576E", hash_generated_method = "BA3F61C3F21C9BBD5C33088CA620E266")
     boolean isPinCommand() {
        boolean varFF503AA9A44C28D3C7411096077FB957_1396578321 = (sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              || sc.equals(SC_PUK) || sc.equals(SC_PUK2)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344814274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_344814274;
        // ---------- Original Method ----------
        //return sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              //|| sc.equals(SC_PUK) || sc.equals(SC_PUK2));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.332 -0400", hash_original_method = "38FEBB881BBF680269ABAA58BA7CAEF9", hash_generated_method = "FEA36A2D634DCF6A0D4E20C69832AF7F")
     boolean isTemporaryModeCLIR() {
        boolean var544696A52FC0DFD167FF01D5AB5C7E65_2147315006 = (sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                && (isActivate() || isDeactivate()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424975325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424975325;
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                //&& (isActivate() || isDeactivate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.332 -0400", hash_original_method = "29290542493AE0E5F1628242CAC04AE5", hash_generated_method = "ABB627CC2E9D6A9AE12A65DD6F8A4B28")
     int getCLIRMode() {
        {
            boolean var34648CEF6B66EF75C2E3E4FDB714C6B5_63057920 = (sc != null && sc.equals(SC_CLIR));
            {
                {
                    boolean var6DAE9187104E5001F23DD333FAAFF7E8_1183723610 = (isActivate());
                    {
                        boolean var60B1109AE4AFCE40EC270D9BE8674276_1646929952 = (isDeactivate());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206469659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206469659;
        // ---------- Original Method ----------
        //if (sc != null && sc.equals(SC_CLIR)) {
            //if (isActivate()) {
                //return CommandsInterface.CLIR_SUPPRESSION;
            //} else if (isDeactivate()) {
                //return CommandsInterface.CLIR_INVOCATION;
            //}
        //}
        //return CommandsInterface.CLIR_DEFAULT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.332 -0400", hash_original_method = "68E2406D480606BAD5624672FC8435A4", hash_generated_method = "0E996CEB488D2C200234DE66D8E33B8C")
     boolean isActivate() {
        boolean varDA9476B1A494F0D070B1BF7D372D3355_2035787202 = (action != null && action.equals(ACTION_ACTIVATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_936041155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_936041155;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.332 -0400", hash_original_method = "83961E295B5FE9A8E52B830AEEEC29A1", hash_generated_method = "942DD7600A5B457DEF6A17F534DB1C82")
     boolean isDeactivate() {
        boolean varE0E3F7818F99EE86F25A069D66EF50F8_83512068 = (action != null && action.equals(ACTION_DEACTIVATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904352423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904352423;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_DEACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.333 -0400", hash_original_method = "E588DEB258357C4BFC7DA2575588FA46", hash_generated_method = "B01678E1B7093EDD9215298C8F7E2CFF")
     boolean isInterrogate() {
        boolean var80F2797A4F74689C3AE333F5C724FB3D_1051719499 = (action != null && action.equals(ACTION_INTERROGATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951812484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951812484;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_INTERROGATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.333 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "431AF2C1BDD35CE394877291F0311D16")
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_1879095913 = (action != null && action.equals(ACTION_REGISTER));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114961260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114961260;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.333 -0400", hash_original_method = "BEEEFB61222182AD97B0B2576158AC2D", hash_generated_method = "B5701B6D849147E4020A5D4A28A9D669")
     boolean isErasure() {
        boolean var26E8FF1C98185BC2E63EA43F2B1F6AA7_1922398954 = (action != null && action.equals(ACTION_ERASURE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555081962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555081962;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ERASURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.333 -0400", hash_original_method = "18A8B0A5C57D2FDE667C353F321E4EE3", hash_generated_method = "0710A6DB87B4A791B823921F8A9D4B65")
    public boolean isPendingUSSD() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_353892404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_353892404;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.334 -0400", hash_original_method = "29AF801768BF493864C8071B1DB2A48B", hash_generated_method = "CC71A1522F361C33A2246A5BCBE7CCDB")
    public boolean isUssdRequest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1321798400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1321798400;
        // ---------- Original Method ----------
        //return isUssdRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.335 -0400", hash_original_method = "889EE3022DF864BE1DEDCF5E80AD4B15", hash_generated_method = "E9703E832B9BFC0C607A1D54AE982C49")
     void processCode() {
        try 
        {
            {
                boolean var8D3139A2E490A629DC2B2B2E088002D1_2059111569 = (isShortCode());
                {
                    Log.d(LOG_TAG, "isShortCode");
                    sendUssd(dialingNumber);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                } //End block
                {
                    boolean varD990A9821BF7C1A6CEBB4AF3A08286F4_2085069446 = (sc != null && sc.equals(SC_CLIP));
                    {
                        Log.d(LOG_TAG, "is CLIP");
                        {
                            boolean var2CCA4E10A7F30CA1D898E5A5AC1ABD11_384850370 = (isInterrogate());
                            {
                                phone.mCM.queryCLIP(
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                            } //End block
                            {
                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var0812373E25987806BA10DCBE1830B470_846569644 = (sc != null && sc.equals(SC_CLIR));
                        {
                            Log.d(LOG_TAG, "is CLIR");
                            {
                                boolean var660F9C4115C74CCDF15C3870AE7DD93D_1812715866 = (isActivate());
                                {
                                    phone.mCM.setCLIR(CommandsInterface.CLIR_INVOCATION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                } //End block
                                {
                                    boolean varDA9013164DD6CF176DBD049823930B6B_1758668458 = (isDeactivate());
                                    {
                                        phone.mCM.setCLIR(CommandsInterface.CLIR_SUPPRESSION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                    } //End block
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_1822526408 = (isInterrogate());
                                        {
                                            phone.mCM.getCLIR(
                        obtainMessage(EVENT_GET_CLIR_COMPLETE, this));
                                        } //End block
                                        {
                                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var7312C42DD719B1CD668FCA247DDADED7_1847230007 = (isServiceCodeCallForwarding(sc));
                            {
                                Log.d(LOG_TAG, "is CF");
                                String dialingNumber = sia;
                                int serviceClass = siToServiceClass(sib);
                                int reason = scToCallForwardReason(sc);
                                int time = siToTime(sic);
                                {
                                    boolean var61B524360B73CC876F21BB5D0DD14CDF_1482144875 = (isInterrogate());
                                    {
                                        phone.mCM.queryCallForwardStatus(
                            reason, serviceClass,  dialingNumber,
                                obtainMessage(EVENT_QUERY_CF_COMPLETE, this));
                                    } //End block
                                    {
                                        int cfAction;
                                        {
                                            boolean var4E150FF745CF73441F17C76F3D37B88B_1873976385 = (isActivate());
                                            {
                                                cfAction = CommandsInterface.CF_ACTION_ENABLE;
                                            } //End block
                                            {
                                                boolean var933AF435450C733B38ACA41F2D3FCAF9_1858073704 = (isDeactivate());
                                                {
                                                    cfAction = CommandsInterface.CF_ACTION_DISABLE;
                                                } //End block
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_718274003 = (isRegister());
                                                    {
                                                        cfAction = CommandsInterface.CF_ACTION_REGISTRATION;
                                                    } //End block
                                                    {
                                                        boolean var25ADF80BDE86F8A8B3E8088E4D221AE4_433056109 = (isErasure());
                                                        {
                                                            cfAction = CommandsInterface.CF_ACTION_ERASURE;
                                                        } //End block
                                                        {
                                                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("invalid action");
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                        int isSettingUnconditionalVoice;
                                        isSettingUnconditionalVoice = 1;
                                        isSettingUnconditionalVoice = 0;
                                        int isEnableDesired;
                                        isEnableDesired = 1;
                                        isEnableDesired = 0;
                                        Log.d(LOG_TAG, "is CF setCallForward");
                                        phone.mCM.setCallForward(cfAction, reason, serviceClass,
                            dialingNumber, time, obtainMessage(
                                    EVENT_SET_CFF_COMPLETE,
                                    isSettingUnconditionalVoice,
                                    isEnableDesired, this));
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var12C22BB7EEA013327BEDC89EF49EBBAB_2020243367 = (isServiceCodeCallBarring(sc));
                                {
                                    String password = sia;
                                    int serviceClass = siToServiceClass(sib);
                                    String facility = scToBarringFacility(sc);
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_2015475645 = (isInterrogate());
                                        {
                                            phone.mCM.queryFacilityLock(facility, password,
                            serviceClass, obtainMessage(EVENT_QUERY_COMPLETE, this));
                                        } //End block
                                        {
                                            boolean var119A5D265CCF4791E780BDE84928E729_1877965030 = (isActivate() || isDeactivate());
                                            {
                                                phone.mCM.setFacilityLock(facility, isActivate(), password,
                            serviceClass, obtainMessage(EVENT_SET_COMPLETE, this));
                                            } //End block
                                            {
                                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    boolean varCDD454EC464ABD0A8BFA09F4744BB0C5_2127458343 = (sc != null && sc.equals(SC_PWD));
                                    {
                                        String facility;
                                        String oldPwd = sib;
                                        String newPwd = sic;
                                        {
                                            boolean varED52A25A69DBFEC36BAE7920F2260BF9_407693552 = (isActivate() || isRegister());
                                            {
                                                action = ACTION_REGISTER;
                                                {
                                                    facility = CommandsInterface.CB_FACILITY_BA_ALL;
                                                } //End block
                                                {
                                                    facility = scToBarringFacility(sia);
                                                } //End block
                                                {
                                                    boolean var0391FAAA3FE1381FC688FE40567A50CA_626627433 = (newPwd.equals(pwd));
                                                    {
                                                        phone.mCM.changeBarringPassword(facility, oldPwd,
                                newPwd, obtainMessage(EVENT_SET_COMPLETE, this));
                                                    } //End block
                                                    {
                                                        handlePasswordError(com.android.internal.R.string.passwordIncorrect);
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        boolean var572741C1390D1648B95B43B4EB591AAD_1611296713 = (sc != null && sc.equals(SC_WAIT));
                                        {
                                            int serviceClass = siToServiceClass(sia);
                                            {
                                                boolean var2FD224AA61CCD0ABD56110F8F107990B_1820426122 = (isActivate() || isDeactivate());
                                                {
                                                    phone.mCM.setCallWaiting(isActivate(), serviceClass,
                            obtainMessage(EVENT_SET_COMPLETE, this));
                                                } //End block
                                                {
                                                    boolean var75AAC492F8B008891AB83B5FB4B29791_1641567778 = (isInterrogate());
                                                    {
                                                        phone.mCM.queryCallWaiting(serviceClass,
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                                                    } //End block
                                                    {
                                                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean varE9E9769B3965CB509E03E906501C297B_951426170 = (isPinCommand());
                                            {
                                                String oldPinOrPuk = sia;
                                                String newPin = sib;
                                                int pinLen = newPin.length();
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_883106367 = (isRegister());
                                                    {
                                                        {
                                                            boolean var8AAFFDB78603D28040F2394F0AD529DA_196366262 = (!newPin.equals(sic));
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.mismatchPin);
                                                            } //End block
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.invalidPin);
                                                            } //End block
                                                            {
                                                                boolean varB803AB2D427385C9994C2A4CADA7A133_442039311 = (sc.equals(SC_PIN) &&
                               phone.mIccCard.getState() == SimCard.State.PUK_REQUIRED);
                                                                {
                                                                    handlePasswordError(com.android.internal.R.string.needPuk);
                                                                } //End block
                                                                {
                                                                    {
                                                                        boolean var1EDE5DF632D5A9C013C23432D6E0A17F_488474890 = (sc.equals(SC_PIN));
                                                                        {
                                                                            phone.mCM.changeIccPin(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                        } //End block
                                                                        {
                                                                            boolean var0BF913DF155AAE543691723B891AE7DB_112939085 = (sc.equals(SC_PIN2));
                                                                            {
                                                                                phone.mCM.changeIccPin2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                            } //End block
                                                                            {
                                                                                boolean var3FF6DE7548056294F609BF66B6EE3C0F_1791487580 = (sc.equals(SC_PUK));
                                                                                {
                                                                                    phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                                } //End block
                                                                                {
                                                                                    boolean var5F1753C6264CCB0AFA8B9E811C51CEDC_133638745 = (sc.equals(SC_PUK2));
                                                                                    {
                                                                                        phone.mCM.supplyIccPuk2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                                    } //End block
                                                                                } //End collapsed parenthetic
                                                                            } //End collapsed parenthetic
                                                                        } //End collapsed parenthetic
                                                                    } //End collapsed parenthetic
                                                                } //End block
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                                    } //End block
                                                } //End collapsed parenthetic
                                            } //End block
                                            {
                                                sendUssd(poundString);
                                            } //End block
                                            {
                                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (RuntimeException exc)
        {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.336 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "878F8042D8FA72C244D61D1029C0968B")
    private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        addTaint(res);
        // ---------- Original Method ----------
        //state = State.FAILED;
        //StringBuilder sb = new StringBuilder(getScString());
        //sb.append("\n");
        //sb.append(context.getText(res));
        //message = sb;
        //phone.onMMIDone(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.337 -0400", hash_original_method = "A7DAC75B31530E6CD4845B1030678B66", hash_generated_method = "F06561A698D09354C2DBFD6BEBEC4386")
     void onUssdFinished(String ussdMessage, boolean isUssdRequest) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                message = context.getText(com.android.internal.R.string.mmiComplete);
            } //End block
            {
                message = ussdMessage;
            } //End block
            this.isUssdRequest = isUssdRequest;
            {
                state = State.COMPLETE;
            } //End block
            phone.onMMIDone(this);
        } //End block
        // ---------- Original Method ----------
        //if (state == State.PENDING) {
            //if (ussdMessage == null) {
                //message = context.getText(com.android.internal.R.string.mmiComplete);
            //} else {
                //message = ussdMessage;
            //}
            //this.isUssdRequest = isUssdRequest;
            //if (!isUssdRequest) {
                //state = State.COMPLETE;
            //}
            //phone.onMMIDone(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.337 -0400", hash_original_method = "6CB35EDB68C77D37EFB134F2D3B374DA", hash_generated_method = "D9A37A1161AFF010CC3D3C13DFD41836")
     void onUssdFinishedError() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        } //End block
        // ---------- Original Method ----------
        //if (state == State.PENDING) {
            //state = State.FAILED;
            //message = context.getText(com.android.internal.R.string.mmiError);
            //phone.onMMIDone(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.337 -0400", hash_original_method = "91A2759A8D20AD291EA9305932FA3032", hash_generated_method = "B3165A145D90C0F89CBDFABEBF5B57F5")
     void sendUssd(String ussdMessage) {
        isPendingUSSD = true;
        phone.mCM.sendUSSD(ussdMessage,
            obtainMessage(EVENT_USSD_COMPLETE, this));
        addTaint(ussdMessage.getTaint());
        // ---------- Original Method ----------
        //isPendingUSSD = true;
        //phone.mCM.sendUSSD(ussdMessage,
            //obtainMessage(EVENT_USSD_COMPLETE, this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.338 -0400", hash_original_method = "5C6BF8BFD3AA6C53F0FB54F2701C6A7B", hash_generated_method = "D54984FD8A04A6E2A5E4C8F825A8D64C")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        //Begin case EVENT_SET_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_SET_COMPLETE 
        //Begin case EVENT_SET_COMPLETE 
        onSetComplete(ar);
        //End case EVENT_SET_COMPLETE 
        //Begin case EVENT_SET_CFF_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_SET_CFF_COMPLETE 
        //Begin case EVENT_SET_CFF_COMPLETE 
        {
            boolean cffEnabled = (msg.arg2 == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        } //End block
        //End case EVENT_SET_CFF_COMPLETE 
        //Begin case EVENT_SET_CFF_COMPLETE 
        onSetComplete(ar);
        //End case EVENT_SET_CFF_COMPLETE 
        //Begin case EVENT_GET_CLIR_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_GET_CLIR_COMPLETE 
        //Begin case EVENT_GET_CLIR_COMPLETE 
        onGetClirComplete(ar);
        //End case EVENT_GET_CLIR_COMPLETE 
        //Begin case EVENT_QUERY_CF_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_QUERY_CF_COMPLETE 
        //Begin case EVENT_QUERY_CF_COMPLETE 
        onQueryCfComplete(ar);
        //End case EVENT_QUERY_CF_COMPLETE 
        //Begin case EVENT_QUERY_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_QUERY_COMPLETE 
        //Begin case EVENT_QUERY_COMPLETE 
        onQueryComplete(ar);
        //End case EVENT_QUERY_COMPLETE 
        //Begin case EVENT_USSD_COMPLETE 
        ar = (AsyncResult) (msg.obj);
        //End case EVENT_USSD_COMPLETE 
        //Begin case EVENT_USSD_COMPLETE 
        {
            state = State.FAILED;
            message = getErrorMessage(ar);
            phone.onMMIDone(this);
        } //End block
        //End case EVENT_USSD_COMPLETE 
        //Begin case EVENT_USSD_CANCEL_COMPLETE 
        phone.onMMIDone(this);
        //End case EVENT_USSD_CANCEL_COMPLETE 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.339 -0400", hash_original_method = "6FA8450E92822795C4AD46C68EFB0477", hash_generated_method = "DF7C512790D23D4AE2861750C57869EE")
    private CharSequence getErrorMessage(AsyncResult ar) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_233001841 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1360579128 = null; //Variable for return #2
        {
            CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
            {
                varB4EAC82CA7396A68D541C85D26508E83_233001841 = context.getText(com.android.internal.R.string.mmiFdnError);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1360579128 = context.getText(com.android.internal.R.string.mmiError);
        addTaint(ar.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_973526793; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_973526793 = varB4EAC82CA7396A68D541C85D26508E83_233001841;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_973526793 = varB4EAC82CA7396A68D541C85D26508E83_1360579128;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_973526793.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_973526793;
        // ---------- Original Method ----------
        //if (ar.exception instanceof CommandException) {
            //CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
            //if (err == CommandException.Error.FDN_CHECK_FAILURE) {
                //Log.i(LOG_TAG, "FDN_CHECK_FAILURE");
                //return context.getText(com.android.internal.R.string.mmiFdnError);
            //}
        //}
        //return context.getText(com.android.internal.R.string.mmiError);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.342 -0400", hash_original_method = "F062B7C9E966AA410521C905675EBDA7", hash_generated_method = "9463DB9B8565F013578995852158A8E1")
    private CharSequence getScString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1081797190 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_557707486 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1594352242 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1358373700 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1753276209 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1724083110 = null; //Variable for return #6
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_973268245 = null; //Variable for return #7
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1349489358 = null; //Variable for return #8
        {
            {
                boolean varCCA5F2A13C1993EFC5A1CF2F0165F813_269822741 = (isServiceCodeCallBarring(sc));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1081797190 = context.getText(com.android.internal.R.string.BaMmi);
                } //End block
                {
                    boolean var32DC5B084701CD8CD9A8C906B0EEBD05_1432476076 = (isServiceCodeCallForwarding(sc));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_557707486 = context.getText(com.android.internal.R.string.CfMmi);
                    } //End block
                    {
                        boolean var6914B4EC879BBBF42E2E74E4C168A160_948556835 = (sc.equals(SC_CLIP));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1594352242 = context.getText(com.android.internal.R.string.ClipMmi);
                        } //End block
                        {
                            boolean var0623604252E0864F742051097B6173BA_702793125 = (sc.equals(SC_CLIR));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1358373700 = context.getText(com.android.internal.R.string.ClirMmi);
                            } //End block
                            {
                                boolean var5C676F9701A0966D4E94DEF50F123275_983452504 = (sc.equals(SC_PWD));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1753276209 = context.getText(com.android.internal.R.string.PwdMmi);
                                } //End block
                                {
                                    boolean varDA6852543E26402D459735260F444175_148500221 = (sc.equals(SC_WAIT));
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_1724083110 = context.getText(com.android.internal.R.string.CwMmi);
                                    } //End block
                                    {
                                        boolean varD1C658B382FEF05BC29F9D45B74B0428_566835170 = (isPinCommand());
                                        {
                                            varB4EAC82CA7396A68D541C85D26508E83_973268245 = context.getText(com.android.internal.R.string.PinMmi);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1349489358 = "";
        CharSequence varA7E53CE21691AB073D9660D615818899_302561465; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1081797190;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_557707486;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1594352242;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1358373700;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1753276209;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1724083110;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_973268245;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_302561465 = varB4EAC82CA7396A68D541C85D26508E83_1349489358;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_302561465.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_302561465;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.343 -0400", hash_original_method = "86E59952328AB1858ED821151A4A3DAE", hash_generated_method = "42331B7E0B587ADBA2F9AFA3909FB614")
    private void onSetComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
                {
                    {
                        boolean varE9FBF60BA382E5447A6974F53D0FF9D9_278890537 = (isPinCommand());
                        {
                            {
                                boolean var542A32D8FD5F06047C25109609B431AB_1326087047 = (sc.equals(SC_PUK) || sc.equals(SC_PUK2));
                                {
                                    sb.append(context.getText(
                                    com.android.internal.R.string.badPuk));
                                } //End block
                                {
                                    sb.append(context.getText(
                                    com.android.internal.R.string.badPin));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.badPin));
                    sb.append("\n");
                    sb.append(context.getText(
                            com.android.internal.R.string.needPuk2));
                } //End block
                {
                    sb.append(context.getText(com.android.internal.R.string.mmiFdnError));
                } //End block
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                } //End block
            } //End block
            {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            } //End block
        } //End block
        {
            boolean varD4B13402CFA6A550CEC0E5DDCA20FC61_322165858 = (isActivate());
            {
                state = State.COMPLETE;
                sb.append(context.getText(
                    com.android.internal.R.string.serviceEnabled));
                {
                    boolean var963F1E632E68242542E9A5B1692F1816_1023944219 = (sc.equals(SC_CLIR));
                    {
                        phone.saveClirSetting(CommandsInterface.CLIR_INVOCATION);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var0FE307E32DF6975EC6641BDD38B8A41D_854345263 = (isDeactivate());
                {
                    state = State.COMPLETE;
                    sb.append(context.getText(
                    com.android.internal.R.string.serviceDisabled));
                    {
                        boolean var767B63B127ECD6CE628AB160BBB58776_581394014 = (sc.equals(SC_CLIR));
                        {
                            phone.saveClirSetting(CommandsInterface.CLIR_SUPPRESSION);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varACC7E5A3F90406763366F9A6873CC87D_920668707 = (isRegister());
                    {
                        state = State.COMPLETE;
                        sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
                    } //End block
                    {
                        boolean var4C83CC598DD8ACFB794FA2BD7EA1E761_1092950244 = (isErasure());
                        {
                            state = State.COMPLETE;
                            sb.append(context.getText(
                    com.android.internal.R.string.serviceErased));
                        } //End block
                        {
                            state = State.FAILED;
                            sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.345 -0400", hash_original_method = "E00F9D791A3B8B3DD19100E46A3BBC7E", hash_generated_method = "3BCEDCB9E8486F8B6B0CD0752DB13127")
    private void onGetClirComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        {
            int clirArgs[];
            clirArgs = (int[])ar.result;
            //Begin case 0 
            sb.append(context.getText(
                                com.android.internal.R.string.serviceNotProvisioned));
            //End case 0 
            //Begin case 0 
            state = State.COMPLETE;
            //End case 0 
            //Begin case 1 
            sb.append(context.getText(
                                com.android.internal.R.string.CLIRPermanent));
            //End case 1 
            //Begin case 1 
            state = State.COMPLETE;
            //End case 1 
            //Begin case 2 
            sb.append(context.getText(
                                com.android.internal.R.string.mmiError));
            //End case 2 
            //Begin case 2 
            state = State.FAILED;
            //End case 2 
            //Begin case 3 
            //Begin case default 0 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
            //End case default 0 
            //Begin case 1 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
            //End case 1 
            //Begin case 2 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOff));
            //End case 2 
            //End case 3 
            //Begin case 3 
            state = State.COMPLETE;
            //End case 3 
            //Begin case 4 
            //Begin case default 0 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
            //End case default 0 
            //Begin case 1 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOn));
            //End case 1 
            //Begin case 2 
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
            //End case 2 
            //End case 4 
            //Begin case 4 
            state = State.COMPLETE;
            //End case 4 
        } //End block
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.346 -0400", hash_original_method = "8B6CA3810AD4ECA237178B5B4043C8E2", hash_generated_method = "6DAF461CE6E1063494235A1CCAA54A06")
    private CharSequence serviceClassToCFString(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_17881490 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_45169067 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1831165433 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_236588258 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_322427114 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1146237191 = null; //Variable for return #6
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_840481117 = null; //Variable for return #7
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_631830526 = null; //Variable for return #8
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_793227656 = null; //Variable for return #9
        //Begin case SERVICE_CLASS_VOICE 
        varB4EAC82CA7396A68D541C85D26508E83_17881490 = context.getText(com.android.internal.R.string.serviceClassVoice);
        //End case SERVICE_CLASS_VOICE 
        //Begin case SERVICE_CLASS_DATA 
        varB4EAC82CA7396A68D541C85D26508E83_45169067 = context.getText(com.android.internal.R.string.serviceClassData);
        //End case SERVICE_CLASS_DATA 
        //Begin case SERVICE_CLASS_FAX 
        varB4EAC82CA7396A68D541C85D26508E83_1831165433 = context.getText(com.android.internal.R.string.serviceClassFAX);
        //End case SERVICE_CLASS_FAX 
        //Begin case SERVICE_CLASS_SMS 
        varB4EAC82CA7396A68D541C85D26508E83_236588258 = context.getText(com.android.internal.R.string.serviceClassSMS);
        //End case SERVICE_CLASS_SMS 
        //Begin case SERVICE_CLASS_DATA_SYNC 
        varB4EAC82CA7396A68D541C85D26508E83_322427114 = context.getText(com.android.internal.R.string.serviceClassDataSync);
        //End case SERVICE_CLASS_DATA_SYNC 
        //Begin case SERVICE_CLASS_DATA_ASYNC 
        varB4EAC82CA7396A68D541C85D26508E83_1146237191 = context.getText(com.android.internal.R.string.serviceClassDataAsync);
        //End case SERVICE_CLASS_DATA_ASYNC 
        //Begin case SERVICE_CLASS_PACKET 
        varB4EAC82CA7396A68D541C85D26508E83_840481117 = context.getText(com.android.internal.R.string.serviceClassPacket);
        //End case SERVICE_CLASS_PACKET 
        //Begin case SERVICE_CLASS_PAD 
        varB4EAC82CA7396A68D541C85D26508E83_631830526 = context.getText(com.android.internal.R.string.serviceClassPAD);
        //End case SERVICE_CLASS_PAD 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_793227656 = null;
        //End case default 
        addTaint(serviceClass);
        CharSequence varA7E53CE21691AB073D9660D615818899_536913980; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_17881490;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_45169067;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_1831165433;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_236588258;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_322427114;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_1146237191;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_840481117;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_631830526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_536913980 = varB4EAC82CA7396A68D541C85D26508E83_793227656;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_536913980.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_536913980;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.348 -0400", hash_original_method = "ECAE8AA4EBDE1134552CC635B1F3D0F6", hash_generated_method = "C6FC8B34101C158F6410D4A561E71652")
    private CharSequence makeCFQueryResultMessage(CallForwardInfo info, int serviceClassMask) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_226358780 = null; //Variable for return #1
        CharSequence template;
        String sources[] = {"{0}", "{1}", "{2}"};
        CharSequence destinations[] = new CharSequence[3];
        boolean needTimeTemplate;
        needTimeTemplate =
            (info.reason == CommandsInterface.CF_REASON_NO_REPLY);
        {
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwardedTime);
            } //End block
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwarded);
            } //End block
        } //End block
        {
            boolean var8E4CE04EDC775CBCECD23931344407DA_2102997395 = (info.status == 0 && isEmptyOrNull(info.number));
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateNotForwarded);
            } //End block
            {
                {
                    template = context.getText(
                        com.android.internal.R.string.cfTemplateRegisteredTime);
                } //End block
                {
                    template = context.getText(
                        com.android.internal.R.string.cfTemplateRegistered);
                } //End block
            } //End block
        } //End collapsed parenthetic
        destinations[0] = serviceClassToCFString(info.serviceClass & serviceClassMask);
        destinations[1] = PhoneNumberUtils.stringFromStringAndTOA(info.number, info.toa);
        destinations[2] = Integer.toString(info.timeSeconds);
        {
            boolean cffEnabled = (info.status == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_226358780 = TextUtils.replace(template, sources, destinations);
        addTaint(info.getTaint());
        addTaint(serviceClassMask);
        varB4EAC82CA7396A68D541C85D26508E83_226358780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_226358780;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.350 -0400", hash_original_method = "5082D13BAC647DFAEF8F3236E64BC951", hash_generated_method = "97E753E0D6C42AD836BBB9B6C20A79BD")
    private void onQueryCfComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        {
            CallForwardInfo infos[];
            infos = (CallForwardInfo[]) ar.result;
            {
                sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                phone.mIccRecords.setVoiceCallForwardingFlag(1, false);
            } //End block
            {
                SpannableStringBuilder tb = new SpannableStringBuilder();
                {
                    int serviceClassMask = 1;
                    serviceClassMask <<= 1;
                    {
                        {
                            int i = 0;
                            int s = infos.length;
                            {
                                {
                                    tb.append(makeCFQueryResultMessage(infos[i],
                                            serviceClassMask));
                                    tb.append("\n");
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                sb.append(tb);
            } //End block
            state = State.COMPLETE;
        } //End block
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.351 -0400", hash_original_method = "34E140E893F772F43554211DC345FDB0", hash_generated_method = "C3FD401C88BDD58D785DE45636968931")
    private void onQueryComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        {
            int[] ints = (int[])ar.result;
            {
                {
                    sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                } //End block
                {
                    boolean var080A5A128C565A100A91BE3125C6E632_254156049 = (sc.equals(SC_WAIT));
                    {
                        sb.append(createQueryCallWaitingResultMessage(ints[1]));
                    } //End block
                    {
                        boolean var5C4CEC64D984C092A00EC9F31984726F_1841995772 = (isServiceCodeCallBarring(sc));
                        {
                            sb.append(createQueryCallBarringResultMessage(ints[0]));
                        } //End block
                        {
                            sb.append(context.getText(com.android.internal.R.string.serviceEnabled));
                        } //End block
                        {
                            sb.append(context.getText(com.android.internal.R.string.mmiError));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                sb.append(context.getText(com.android.internal.R.string.mmiError));
            } //End block
            state = State.COMPLETE;
        } //End block
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.355 -0400", hash_original_method = "8FB50CB401051839B48C4DBAEAA3D5D3", hash_generated_method = "F1BF189F16C77F9718700E93FEFD0C75")
    private CharSequence createQueryCallWaitingResultMessage(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2060092274 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        {
            int classMask = 1;
            classMask <<= 1;
            {
                {
                    sb.append("\n");
                    sb.append(serviceClassToCFString(classMask & serviceClass));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2060092274 = sb;
        addTaint(serviceClass);
        varB4EAC82CA7396A68D541C85D26508E83_2060092274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2060092274;
        // ---------- Original Method ----------
        //StringBuilder sb =
                //new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        //for (int classMask = 1
                    //; classMask <= SERVICE_CLASS_MAX
                    //; classMask <<= 1
        //) {
            //if ((classMask & serviceClass) != 0) {
                //sb.append("\n");
                //sb.append(serviceClassToCFString(classMask & serviceClass));
            //}
        //}
        //return sb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.357 -0400", hash_original_method = "C357AC638D1646361DDD93B23863C2E5", hash_generated_method = "017561D57D97658AB7F896E8159837F0")
    private CharSequence createQueryCallBarringResultMessage(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1823456359 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        {
            int classMask = 1;
            classMask <<= 1;
            {
                {
                    sb.append("\n");
                    sb.append(serviceClassToCFString(classMask & serviceClass));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1823456359 = sb;
        addTaint(serviceClass);
        varB4EAC82CA7396A68D541C85D26508E83_1823456359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1823456359;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        //for (int classMask = 1
                    //; classMask <= SERVICE_CLASS_MAX
                    //; classMask <<= 1
        //) {
            //if ((classMask & serviceClass) != 0) {
                //sb.append("\n");
                //sb.append(serviceClassToCFString(classMask & serviceClass));
            //}
        //}
        //return sb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_method = "4616EBEA9D2FF88EEA02D51F5D1F1A7C", hash_generated_method = "98B27A77727AFB65F74FED4DC5E38878")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1783217405 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder("GsmMmiCode {");
        sb.append("State=" + getState());
        sb.append(" action=" + action);
        sb.append(" sc=" + sc);
        sb.append(" sia=" + sia);
        sb.append(" sib=" + sib);
        sb.append(" sic=" + sic);
        sb.append(" poundString=" + poundString);
        sb.append(" dialingNumber=" + dialingNumber);
        sb.append(" pwd=" + pwd);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1783217405 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1783217405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783217405;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder("GsmMmiCode {");
        //sb.append("State=" + getState());
        //if (action != null) sb.append(" action=" + action);
        //if (sc != null) sb.append(" sc=" + sc);
        //if (sia != null) sb.append(" sia=" + sia);
        //if (sib != null) sb.append(" sib=" + sib);
        //if (sic != null) sb.append(" sic=" + sic);
        //if (poundString != null) sb.append(" poundString=" + poundString);
        //if (dialingNumber != null) sb.append(" dialingNumber=" + dialingNumber);
        //if (pwd != null) sb.append(" pwd=" + pwd);
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "9A3C08FC3E505EA59A036940348ACC20", hash_generated_field = "84380FB2A501B00185F3C8C921C42CD0")

    static final int MAX_LENGTH_SHORT_CODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "C03AB9291666D1A3221E51755E6E283F", hash_generated_field = "D2F2A0356ABABF263CD1876D3484452A")

    static final char END_OF_USSD_COMMAND = '#';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "A537752B1259F88AC18F76D3115FF078", hash_generated_field = "18F682957DD333F418DC1E51CABE0145")

    static final String ACTION_ACTIVATE = "*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "6D54A4CFA33154B4F25361364F9EBBFD", hash_generated_field = "E3284E18102DE7D7C6F38C074B8DCE9F")

    static final String ACTION_DEACTIVATE = "#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "25583D22F5D13B64BA6FE4B3EE60AC86", hash_generated_field = "D264585CD251BCD3ABEAC4C7825F93F9")

    static final String ACTION_INTERROGATE = "*#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A747A2BA07E0220107EEBEA1B6706D02")

    static final String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "3A1254E19648A61BA480A107270318F9", hash_generated_field = "32CD02DE89D027BB80525CC133B872CA")

    static final String ACTION_ERASURE = "##";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "B506035B8DD0DBA2172D0BA0EEC13A88", hash_generated_field = "A51D4720DC81AC3C4C86A4D8412F140A")

    static final String SC_CLIP = "30";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "EC8AA66BEF533B273213E6DB0BBF8ADF", hash_generated_field = "E644B736CD2A9C2179B5ADA66B2BD371")

    static final String SC_CLIR = "31";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "ABC9C4C74D231F8ABA6F93F413FB3FD0", hash_generated_field = "A0A984619995E559906729FB0885BD37")

    static final String SC_CFU = "21";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "9454383467543242D669ED87F248413F", hash_generated_field = "162AB085207CEB2C27F8FDC8BF9ECDF2")

    static final String SC_CFB = "67";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "283733E2C01965DFD9773570E027EE6F", hash_generated_field = "188B5492DB9239773311815652D08E1E")

    static final String SC_CFNRy = "61";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "9639B61E8C19778C436B9EB92511C44A", hash_generated_field = "970B94E83FA60DC84055EBAC72BEA6A7")

    static final String SC_CFNR = "62";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "F3E9FC00FA6C76B92C393B7FEAAD3FA6", hash_generated_field = "AAACA7CABEBB58D4DBEDA093B2CDF4C5")

    static final String SC_CF_All = "002";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "536F482EC4EF47627A43E2F42C660DAC", hash_generated_field = "E97209C1CAD929CA0DC97B53BB34B72F")

    static final String SC_CF_All_Conditional = "004";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "66E77556273BFCA545031190388E9C77", hash_generated_field = "7E42427065171F529F659EBE79102742")

    static final String SC_WAIT = "43";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.359 -0400", hash_original_field = "974BB9052E8EDAB3B8DB0339197E7AE0", hash_generated_field = "EB539ECDFB664D7B6F97071235485A9F")

    static final String SC_BAOC = "33";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "30AA7D36FDDA5FDE334B45C22EF77A0F", hash_generated_field = "E42D4E647E8ACC2C103C2935E6E0CE74")

    static final String SC_BAOIC = "331";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "FD10E90BD126124E5850D6F4CCEAD16B", hash_generated_field = "91A59766F8A5C17F073F097729110BA1")

    static final String SC_BAOICxH = "332";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "E17BDC7554CEA6F3DB3F5A99ADC0DF37", hash_generated_field = "8A5B8B89DDC698F51EFD8240BA01409D")

    static final String SC_BAIC = "35";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "590580DA02A1809E7C37E217AC28C3AA", hash_generated_field = "481173BEDB5B2B2B9B6107CCDD3C1DFB")

    static final String SC_BAICr = "351";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "2D6A703DBB1F260ACFD5648813B27270", hash_generated_field = "2118AEBDF2A411624DDAA38436B55831")

    static final String SC_BA_ALL = "330";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "E6C14FB76617FAC17954B4D2D9BA77D7", hash_generated_field = "78090C0D99EB492E8EA3B970D8545B61")

    static final String SC_BA_MO = "333";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "A1749A6E67C7A811178C645BF395C965", hash_generated_field = "D87B853EA32848746BBA1779B8A2EE68")

    static final String SC_BA_MT = "353";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "35425CC920C614B65CECDD2A8D8F526F", hash_generated_field = "67CCC016F241E1D4CFD0A5CE5C530D23")

    static final String SC_PWD = "03";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "D7B4EA3A3E3449565EA9B1BFEC63FCAD", hash_generated_field = "EEE3024D1CF5D84AF8F4CB01077B8E95")

    static final String SC_PIN = "04";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "68C3A8A262F7F737FB51D8F10B96BE6C", hash_generated_field = "7A8798943D2B724D80E98EC6B7CB93B6")

    static final String SC_PIN2 = "042";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "D00C049CD89213BBED85DA008A8C0664", hash_generated_field = "B746ACB42145A31CD109C60F14BFE667")

    static final String SC_PUK2 = "052";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")

    static final int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "EAB3780CCE31DBB465E64A2CD46D2990", hash_generated_field = "9829C51898ECEEF688DC24D5C6D88094")

    static final int EVENT_GET_CLIR_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "6093DB005424AB007B12DCE4B4BC126C", hash_generated_field = "7AFF40CB3CEB21DFC3DD957EE7B8EBBC")

    static final int EVENT_QUERY_CF_COMPLETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "6B552A15FE79814FE37ADA5EB027B548", hash_generated_field = "D739A36AE28735AFC84C598B959E4F6E")

    static final int EVENT_USSD_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "E6D8D584F5F0A4F20E7A8840538FA1EA", hash_generated_field = "72ABCFECA11B8C5650C5459A9D911C41")

    static final int EVENT_QUERY_COMPLETE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "CB9C1EA429412F1AE1D5CE68B2BCB19C", hash_generated_field = "D47F75990E603624F182DA469CF653E4")

    static final int EVENT_SET_CFF_COMPLETE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "4C6E6B70640FA17BEF8F121BA52ED445", hash_generated_field = "1A3F2D11BE99F10E9049869D455AA7BC")

    static final int EVENT_USSD_CANCEL_COMPLETE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "3902BAEB69E5FDBE62258952DBE89AF9", hash_generated_field = "5990EA0198CB826DF3EBD44395CC5B38")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")

    static final int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")

    static final int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")

    static final int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:29.360 -0400", hash_original_field = "2727DAB650F3A79EA96DFB00B503B05E", hash_generated_field = "55E2DF2087007B0F74B525D8CFC27B5F")

    static private String[] sTwoDigitNumberPattern;
}

