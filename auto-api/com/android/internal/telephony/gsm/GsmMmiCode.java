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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "8D111C48FFCFB880A1878EEA7D383221", hash_generated_field = "75B5B7D441FCCB2BF9802C8C7F593C9E")

    private boolean isPendingUSSD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "07574527064CCEC9D1F5EEA5FA7C4751", hash_generated_field = "A601B09474CCCD19D7EF905D10ED4B31")

    private boolean isUssdRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.392 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.393 -0400", hash_original_method = "1F245899EC025E108E5BE08C8380C5BD", hash_generated_method = "AE1A92BE86BC124C3840C6CA8E93CC5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.408 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "D391745022455B382754DBC3D8803F74")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_270154184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_270154184 = state;
        varB4EAC82CA7396A68D541C85D26508E83_270154184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_270154184;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.408 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "DE93565BE5533BC5DA30057501053160")
    public CharSequence getMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_296725416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_296725416 = message;
        varB4EAC82CA7396A68D541C85D26508E83_296725416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_296725416;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.417 -0400", hash_original_method = "E883165C6689A3782C7AFFDB1FCF97C2", hash_generated_method = "DDD294D2F15DC82E2D473B5D0C41FEB6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.417 -0400", hash_original_method = "248235E8DF3E05BA5583B3AF86C41C77", hash_generated_method = "F86D1424E8B7EE18F12740AF5380C730")
    public boolean isCancelable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2105427814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2105427814;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.417 -0400", hash_original_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C", hash_generated_method = "FCAFE961D351C19EB5285998553F3FD1")
     boolean isMMI() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902770136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_902770136;
        // ---------- Original Method ----------
        //return poundString != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.421 -0400", hash_original_method = "C27864618833FAFE773E7DA58094B237", hash_generated_method = "EE08B629237A1804F4BA8B70BC58FCA5")
     boolean isShortCode() {
        boolean var5484DF39387CF98FB51501CB4001F9FA_1565520617 = (poundString == null
                    && dialingNumber != null && dialingNumber.length() <= 2);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079462717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079462717;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.427 -0400", hash_original_method = "59EBB8632489E0E4FC2DAAE2E73A576E", hash_generated_method = "8F7BCC4C7DF19526F88FBEC0452DD2DF")
     boolean isPinCommand() {
        boolean varFF503AA9A44C28D3C7411096077FB957_1296772222 = (sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              || sc.equals(SC_PUK) || sc.equals(SC_PUK2)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100512632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100512632;
        // ---------- Original Method ----------
        //return sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              //|| sc.equals(SC_PUK) || sc.equals(SC_PUK2));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.432 -0400", hash_original_method = "38FEBB881BBF680269ABAA58BA7CAEF9", hash_generated_method = "32402FAF83730B40AD9D02379D21281D")
     boolean isTemporaryModeCLIR() {
        boolean var544696A52FC0DFD167FF01D5AB5C7E65_1694251339 = (sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                && (isActivate() || isDeactivate()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70273187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70273187;
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                //&& (isActivate() || isDeactivate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.433 -0400", hash_original_method = "29290542493AE0E5F1628242CAC04AE5", hash_generated_method = "8E13DBC7DDD313F82FD6FB774FF27C2C")
     int getCLIRMode() {
        {
            boolean var34648CEF6B66EF75C2E3E4FDB714C6B5_341059512 = (sc != null && sc.equals(SC_CLIR));
            {
                {
                    boolean var6DAE9187104E5001F23DD333FAAFF7E8_1134483392 = (isActivate());
                    {
                        boolean var60B1109AE4AFCE40EC270D9BE8674276_720931081 = (isDeactivate());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663193802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663193802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.434 -0400", hash_original_method = "68E2406D480606BAD5624672FC8435A4", hash_generated_method = "C2C07C219F313C8FECD64E049C9BA668")
     boolean isActivate() {
        boolean varDA9476B1A494F0D070B1BF7D372D3355_1595225642 = (action != null && action.equals(ACTION_ACTIVATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918298891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_918298891;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.440 -0400", hash_original_method = "83961E295B5FE9A8E52B830AEEEC29A1", hash_generated_method = "EAE71E0027E3D31C3631A56FE6839EA2")
     boolean isDeactivate() {
        boolean varE0E3F7818F99EE86F25A069D66EF50F8_404754833 = (action != null && action.equals(ACTION_DEACTIVATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750655634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750655634;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_DEACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.440 -0400", hash_original_method = "E588DEB258357C4BFC7DA2575588FA46", hash_generated_method = "4E4345F192FC1D2CBA4C814A84959E07")
     boolean isInterrogate() {
        boolean var80F2797A4F74689C3AE333F5C724FB3D_1709654008 = (action != null && action.equals(ACTION_INTERROGATE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773319107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773319107;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_INTERROGATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.440 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "E1A95B0BE1B23736A40D8391AB91257E")
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_980665364 = (action != null && action.equals(ACTION_REGISTER));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_103717665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_103717665;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.443 -0400", hash_original_method = "BEEEFB61222182AD97B0B2576158AC2D", hash_generated_method = "962705E5BE16F12FFABC556D2122D5AC")
     boolean isErasure() {
        boolean var26E8FF1C98185BC2E63EA43F2B1F6AA7_3989738 = (action != null && action.equals(ACTION_ERASURE));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625680386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625680386;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ERASURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.443 -0400", hash_original_method = "18A8B0A5C57D2FDE667C353F321E4EE3", hash_generated_method = "7D5850A0092C2A46CEE97C211A90B236")
    public boolean isPendingUSSD() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819213023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819213023;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.443 -0400", hash_original_method = "29AF801768BF493864C8071B1DB2A48B", hash_generated_method = "9656C82800B466AE15FB59F9A8AD25DD")
    public boolean isUssdRequest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669927925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669927925;
        // ---------- Original Method ----------
        //return isUssdRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.458 -0400", hash_original_method = "889EE3022DF864BE1DEDCF5E80AD4B15", hash_generated_method = "8C207788FE8781FAA119EB6940B0A6D6")
     void processCode() {
        try 
        {
            {
                boolean var8D3139A2E490A629DC2B2B2E088002D1_481981345 = (isShortCode());
                {
                    Log.d(LOG_TAG, "isShortCode");
                    sendUssd(dialingNumber);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                } //End block
                {
                    boolean varD990A9821BF7C1A6CEBB4AF3A08286F4_2144406424 = (sc != null && sc.equals(SC_CLIP));
                    {
                        Log.d(LOG_TAG, "is CLIP");
                        {
                            boolean var2CCA4E10A7F30CA1D898E5A5AC1ABD11_1399412862 = (isInterrogate());
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
                        boolean var0812373E25987806BA10DCBE1830B470_1139630120 = (sc != null && sc.equals(SC_CLIR));
                        {
                            Log.d(LOG_TAG, "is CLIR");
                            {
                                boolean var660F9C4115C74CCDF15C3870AE7DD93D_1384643500 = (isActivate());
                                {
                                    phone.mCM.setCLIR(CommandsInterface.CLIR_INVOCATION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                } //End block
                                {
                                    boolean varDA9013164DD6CF176DBD049823930B6B_1219158820 = (isDeactivate());
                                    {
                                        phone.mCM.setCLIR(CommandsInterface.CLIR_SUPPRESSION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                    } //End block
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_281261305 = (isInterrogate());
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
                            boolean var7312C42DD719B1CD668FCA247DDADED7_1059378272 = (isServiceCodeCallForwarding(sc));
                            {
                                Log.d(LOG_TAG, "is CF");
                                String dialingNumber;
                                dialingNumber = sia;
                                int serviceClass;
                                serviceClass = siToServiceClass(sib);
                                int reason;
                                reason = scToCallForwardReason(sc);
                                int time;
                                time = siToTime(sic);
                                {
                                    boolean var61B524360B73CC876F21BB5D0DD14CDF_152466526 = (isInterrogate());
                                    {
                                        phone.mCM.queryCallForwardStatus(
                            reason, serviceClass,  dialingNumber,
                                obtainMessage(EVENT_QUERY_CF_COMPLETE, this));
                                    } //End block
                                    {
                                        int cfAction;
                                        {
                                            boolean var4E150FF745CF73441F17C76F3D37B88B_717273549 = (isActivate());
                                            {
                                                cfAction = CommandsInterface.CF_ACTION_ENABLE;
                                            } //End block
                                            {
                                                boolean var933AF435450C733B38ACA41F2D3FCAF9_471342882 = (isDeactivate());
                                                {
                                                    cfAction = CommandsInterface.CF_ACTION_DISABLE;
                                                } //End block
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_98814406 = (isRegister());
                                                    {
                                                        cfAction = CommandsInterface.CF_ACTION_REGISTRATION;
                                                    } //End block
                                                    {
                                                        boolean var25ADF80BDE86F8A8B3E8088E4D221AE4_1225555963 = (isErasure());
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
                                boolean var12C22BB7EEA013327BEDC89EF49EBBAB_450970015 = (isServiceCodeCallBarring(sc));
                                {
                                    String password;
                                    password = sia;
                                    int serviceClass;
                                    serviceClass = siToServiceClass(sib);
                                    String facility;
                                    facility = scToBarringFacility(sc);
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_508164930 = (isInterrogate());
                                        {
                                            phone.mCM.queryFacilityLock(facility, password,
                            serviceClass, obtainMessage(EVENT_QUERY_COMPLETE, this));
                                        } //End block
                                        {
                                            boolean var119A5D265CCF4791E780BDE84928E729_627121351 = (isActivate() || isDeactivate());
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
                                    boolean varCDD454EC464ABD0A8BFA09F4744BB0C5_389212254 = (sc != null && sc.equals(SC_PWD));
                                    {
                                        String facility;
                                        String oldPwd;
                                        oldPwd = sib;
                                        String newPwd;
                                        newPwd = sic;
                                        {
                                            boolean varED52A25A69DBFEC36BAE7920F2260BF9_961695341 = (isActivate() || isRegister());
                                            {
                                                action = ACTION_REGISTER;
                                                {
                                                    facility = CommandsInterface.CB_FACILITY_BA_ALL;
                                                } //End block
                                                {
                                                    facility = scToBarringFacility(sia);
                                                } //End block
                                                {
                                                    boolean var0391FAAA3FE1381FC688FE40567A50CA_1563864849 = (newPwd.equals(pwd));
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
                                        boolean var572741C1390D1648B95B43B4EB591AAD_755114352 = (sc != null && sc.equals(SC_WAIT));
                                        {
                                            int serviceClass;
                                            serviceClass = siToServiceClass(sia);
                                            {
                                                boolean var2FD224AA61CCD0ABD56110F8F107990B_315441427 = (isActivate() || isDeactivate());
                                                {
                                                    phone.mCM.setCallWaiting(isActivate(), serviceClass,
                            obtainMessage(EVENT_SET_COMPLETE, this));
                                                } //End block
                                                {
                                                    boolean var75AAC492F8B008891AB83B5FB4B29791_2133625048 = (isInterrogate());
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
                                            boolean varE9E9769B3965CB509E03E906501C297B_323265622 = (isPinCommand());
                                            {
                                                String oldPinOrPuk;
                                                oldPinOrPuk = sia;
                                                String newPin;
                                                newPin = sib;
                                                int pinLen;
                                                pinLen = newPin.length();
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_888904258 = (isRegister());
                                                    {
                                                        {
                                                            boolean var8AAFFDB78603D28040F2394F0AD529DA_1461211516 = (!newPin.equals(sic));
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.mismatchPin);
                                                            } //End block
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.invalidPin);
                                                            } //End block
                                                            {
                                                                boolean varB803AB2D427385C9994C2A4CADA7A133_1445930941 = (sc.equals(SC_PIN) &&
                               phone.mIccCard.getState() == SimCard.State.PUK_REQUIRED);
                                                                {
                                                                    handlePasswordError(com.android.internal.R.string.needPuk);
                                                                } //End block
                                                                {
                                                                    {
                                                                        boolean var1EDE5DF632D5A9C013C23432D6E0A17F_1757344386 = (sc.equals(SC_PIN));
                                                                        {
                                                                            phone.mCM.changeIccPin(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                        } //End block
                                                                        {
                                                                            boolean var0BF913DF155AAE543691723B891AE7DB_154362345 = (sc.equals(SC_PIN2));
                                                                            {
                                                                                phone.mCM.changeIccPin2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                            } //End block
                                                                            {
                                                                                boolean var3FF6DE7548056294F609BF66B6EE3C0F_1141560522 = (sc.equals(SC_PUK));
                                                                                {
                                                                                    phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                                } //End block
                                                                                {
                                                                                    boolean var5F1753C6264CCB0AFA8B9E811C51CEDC_194071791 = (sc.equals(SC_PUK2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.543 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "AF6C40B6962A4F309E3E610CFAB2D730")
    private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb;
        sb = new StringBuilder(getScString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.544 -0400", hash_original_method = "A7DAC75B31530E6CD4845B1030678B66", hash_generated_method = "F06561A698D09354C2DBFD6BEBEC4386")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.545 -0400", hash_original_method = "6CB35EDB68C77D37EFB134F2D3B374DA", hash_generated_method = "D9A37A1161AFF010CC3D3C13DFD41836")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.545 -0400", hash_original_method = "91A2759A8D20AD291EA9305932FA3032", hash_generated_method = "B3165A145D90C0F89CBDFABEBF5B57F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.546 -0400", hash_original_method = "5C6BF8BFD3AA6C53F0FB54F2701C6A7B", hash_generated_method = "5552A626DC2AAE69634D19C178B447C6")
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
            boolean cffEnabled;
            cffEnabled = (msg.arg2 == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.547 -0400", hash_original_method = "6FA8450E92822795C4AD46C68EFB0477", hash_generated_method = "208607A1CDDF120BDC52E4F45E714C9B")
    private CharSequence getErrorMessage(AsyncResult ar) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1613443707 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1130984421 = null; //Variable for return #2
        {
            CommandException.Error err;
            err = ((CommandException)(ar.exception)).getCommandError();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1613443707 = context.getText(com.android.internal.R.string.mmiFdnError);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1130984421 = context.getText(com.android.internal.R.string.mmiError);
        addTaint(ar.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1812159667; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1812159667 = varB4EAC82CA7396A68D541C85D26508E83_1613443707;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1812159667 = varB4EAC82CA7396A68D541C85D26508E83_1130984421;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1812159667.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1812159667;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.549 -0400", hash_original_method = "F062B7C9E966AA410521C905675EBDA7", hash_generated_method = "AB57FE52CEBE1A072F825C8DC6F33483")
    private CharSequence getScString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_448578083 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1421887754 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_353741641 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_212276901 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1378989421 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_856403512 = null; //Variable for return #6
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1322405579 = null; //Variable for return #7
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1151289182 = null; //Variable for return #8
        {
            {
                boolean varCCA5F2A13C1993EFC5A1CF2F0165F813_818715951 = (isServiceCodeCallBarring(sc));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_448578083 = context.getText(com.android.internal.R.string.BaMmi);
                } //End block
                {
                    boolean var32DC5B084701CD8CD9A8C906B0EEBD05_1796399901 = (isServiceCodeCallForwarding(sc));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1421887754 = context.getText(com.android.internal.R.string.CfMmi);
                    } //End block
                    {
                        boolean var6914B4EC879BBBF42E2E74E4C168A160_1564468518 = (sc.equals(SC_CLIP));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_353741641 = context.getText(com.android.internal.R.string.ClipMmi);
                        } //End block
                        {
                            boolean var0623604252E0864F742051097B6173BA_1118982702 = (sc.equals(SC_CLIR));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_212276901 = context.getText(com.android.internal.R.string.ClirMmi);
                            } //End block
                            {
                                boolean var5C676F9701A0966D4E94DEF50F123275_2090595149 = (sc.equals(SC_PWD));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1378989421 = context.getText(com.android.internal.R.string.PwdMmi);
                                } //End block
                                {
                                    boolean varDA6852543E26402D459735260F444175_1663963175 = (sc.equals(SC_WAIT));
                                    {
                                        varB4EAC82CA7396A68D541C85D26508E83_856403512 = context.getText(com.android.internal.R.string.CwMmi);
                                    } //End block
                                    {
                                        boolean varD1C658B382FEF05BC29F9D45B74B0428_1076966644 = (isPinCommand());
                                        {
                                            varB4EAC82CA7396A68D541C85D26508E83_1322405579 = context.getText(com.android.internal.R.string.PinMmi);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1151289182 = "";
        CharSequence varA7E53CE21691AB073D9660D615818899_1225131761; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_448578083;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_1421887754;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_353741641;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_212276901;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_1378989421;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_856403512;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_1322405579;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1225131761 = varB4EAC82CA7396A68D541C85D26508E83_1151289182;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1225131761.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1225131761;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.562 -0400", hash_original_method = "86E59952328AB1858ED821151A4A3DAE", hash_generated_method = "DECB17F4225652E539B0AEC09502F639")
    private void onSetComplete(AsyncResult ar) {
        StringBuilder sb;
        sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            {
                CommandException.Error err;
                err = ((CommandException)(ar.exception)).getCommandError();
                {
                    {
                        boolean varE9FBF60BA382E5447A6974F53D0FF9D9_1257353131 = (isPinCommand());
                        {
                            {
                                boolean var542A32D8FD5F06047C25109609B431AB_566065551 = (sc.equals(SC_PUK) || sc.equals(SC_PUK2));
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
            boolean varD4B13402CFA6A550CEC0E5DDCA20FC61_2072916774 = (isActivate());
            {
                state = State.COMPLETE;
                sb.append(context.getText(
                    com.android.internal.R.string.serviceEnabled));
                {
                    boolean var963F1E632E68242542E9A5B1692F1816_909674430 = (sc.equals(SC_CLIR));
                    {
                        phone.saveClirSetting(CommandsInterface.CLIR_INVOCATION);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var0FE307E32DF6975EC6641BDD38B8A41D_1421832101 = (isDeactivate());
                {
                    state = State.COMPLETE;
                    sb.append(context.getText(
                    com.android.internal.R.string.serviceDisabled));
                    {
                        boolean var767B63B127ECD6CE628AB160BBB58776_1050037277 = (sc.equals(SC_CLIR));
                        {
                            phone.saveClirSetting(CommandsInterface.CLIR_SUPPRESSION);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varACC7E5A3F90406763366F9A6873CC87D_2025594338 = (isRegister());
                    {
                        state = State.COMPLETE;
                        sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
                    } //End block
                    {
                        boolean var4C83CC598DD8ACFB794FA2BD7EA1E761_1534968515 = (isErasure());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.576 -0400", hash_original_method = "E00F9D791A3B8B3DD19100E46A3BBC7E", hash_generated_method = "581FCF4D51EB7258ECF32B2045A9ED29")
    private void onGetClirComplete(AsyncResult ar) {
        StringBuilder sb;
        sb = new StringBuilder(getScString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.582 -0400", hash_original_method = "8B6CA3810AD4ECA237178B5B4043C8E2", hash_generated_method = "35D22BC9CEA02AC588DC23C228973EE7")
    private CharSequence serviceClassToCFString(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1733033121 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1145065763 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2129136286 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_856362636 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1518169326 = null; //Variable for return #5
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_833788290 = null; //Variable for return #6
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1274459518 = null; //Variable for return #7
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1401759757 = null; //Variable for return #8
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1661210992 = null; //Variable for return #9
        //Begin case SERVICE_CLASS_VOICE 
        varB4EAC82CA7396A68D541C85D26508E83_1733033121 = context.getText(com.android.internal.R.string.serviceClassVoice);
        //End case SERVICE_CLASS_VOICE 
        //Begin case SERVICE_CLASS_DATA 
        varB4EAC82CA7396A68D541C85D26508E83_1145065763 = context.getText(com.android.internal.R.string.serviceClassData);
        //End case SERVICE_CLASS_DATA 
        //Begin case SERVICE_CLASS_FAX 
        varB4EAC82CA7396A68D541C85D26508E83_2129136286 = context.getText(com.android.internal.R.string.serviceClassFAX);
        //End case SERVICE_CLASS_FAX 
        //Begin case SERVICE_CLASS_SMS 
        varB4EAC82CA7396A68D541C85D26508E83_856362636 = context.getText(com.android.internal.R.string.serviceClassSMS);
        //End case SERVICE_CLASS_SMS 
        //Begin case SERVICE_CLASS_DATA_SYNC 
        varB4EAC82CA7396A68D541C85D26508E83_1518169326 = context.getText(com.android.internal.R.string.serviceClassDataSync);
        //End case SERVICE_CLASS_DATA_SYNC 
        //Begin case SERVICE_CLASS_DATA_ASYNC 
        varB4EAC82CA7396A68D541C85D26508E83_833788290 = context.getText(com.android.internal.R.string.serviceClassDataAsync);
        //End case SERVICE_CLASS_DATA_ASYNC 
        //Begin case SERVICE_CLASS_PACKET 
        varB4EAC82CA7396A68D541C85D26508E83_1274459518 = context.getText(com.android.internal.R.string.serviceClassPacket);
        //End case SERVICE_CLASS_PACKET 
        //Begin case SERVICE_CLASS_PAD 
        varB4EAC82CA7396A68D541C85D26508E83_1401759757 = context.getText(com.android.internal.R.string.serviceClassPAD);
        //End case SERVICE_CLASS_PAD 
        //Begin case default 
        varB4EAC82CA7396A68D541C85D26508E83_1661210992 = null;
        //End case default 
        addTaint(serviceClass);
        CharSequence varA7E53CE21691AB073D9660D615818899_515832857; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1733033121;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1145065763;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_2129136286;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_856362636;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1518169326;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_833788290;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1274459518;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1401759757;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_515832857 = varB4EAC82CA7396A68D541C85D26508E83_1661210992;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_515832857.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_515832857;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.598 -0400", hash_original_method = "ECAE8AA4EBDE1134552CC635B1F3D0F6", hash_generated_method = "ACA1715250EA77F4EB50698CF2C418FA")
    private CharSequence makeCFQueryResultMessage(CallForwardInfo info, int serviceClassMask) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1543939960 = null; //Variable for return #1
        CharSequence template;
        String sources[];
        CharSequence destinations[];
        destinations = new CharSequence[3];
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
            boolean var8E4CE04EDC775CBCECD23931344407DA_489308676 = (info.status == 0 && isEmptyOrNull(info.number));
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
            boolean cffEnabled;
            cffEnabled = (info.status == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1543939960 = TextUtils.replace(template, sources, destinations);
        addTaint(info.getTaint());
        addTaint(serviceClassMask);
        varB4EAC82CA7396A68D541C85D26508E83_1543939960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1543939960;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.599 -0400", hash_original_method = "5082D13BAC647DFAEF8F3236E64BC951", hash_generated_method = "08E9521DEA7FCBFAD096B8ADA0250B1F")
    private void onQueryCfComplete(AsyncResult ar) {
        StringBuilder sb;
        sb = new StringBuilder(getScString());
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
                SpannableStringBuilder tb;
                tb = new SpannableStringBuilder();
                {
                    int serviceClassMask;
                    serviceClassMask = 1;
                    serviceClassMask <<= 1;
                    {
                        {
                            int i, s;
                            i = 0;
                            s = infos.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.600 -0400", hash_original_method = "34E140E893F772F43554211DC345FDB0", hash_generated_method = "629667CA5BA4D249495897BDFBA061E3")
    private void onQueryComplete(AsyncResult ar) {
        StringBuilder sb;
        sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        {
            int[] ints;
            ints = (int[])ar.result;
            {
                {
                    sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                } //End block
                {
                    boolean var080A5A128C565A100A91BE3125C6E632_1272254076 = (sc.equals(SC_WAIT));
                    {
                        sb.append(createQueryCallWaitingResultMessage(ints[1]));
                    } //End block
                    {
                        boolean var5C4CEC64D984C092A00EC9F31984726F_375895321 = (isServiceCodeCallBarring(sc));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.607 -0400", hash_original_method = "8FB50CB401051839B48C4DBAEAA3D5D3", hash_generated_method = "40F17C4E3DB2FDE6532E09F625351D20")
    private CharSequence createQueryCallWaitingResultMessage(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2132515609 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        {
            int classMask;
            classMask = 1;
            classMask <<= 1;
            {
                {
                    sb.append("\n");
                    sb.append(serviceClassToCFString(classMask & serviceClass));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2132515609 = sb;
        addTaint(serviceClass);
        varB4EAC82CA7396A68D541C85D26508E83_2132515609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2132515609;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.608 -0400", hash_original_method = "C357AC638D1646361DDD93B23863C2E5", hash_generated_method = "477E4474A40E35A1410EF67FED8C6E19")
    private CharSequence createQueryCallBarringResultMessage(int serviceClass) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1766146102 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
        {
            int classMask;
            classMask = 1;
            classMask <<= 1;
            {
                {
                    sb.append("\n");
                    sb.append(serviceClassToCFString(classMask & serviceClass));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1766146102 = sb;
        addTaint(serviceClass);
        varB4EAC82CA7396A68D541C85D26508E83_1766146102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766146102;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.608 -0400", hash_original_method = "4616EBEA9D2FF88EEA02D51F5D1F1A7C", hash_generated_method = "8166D177455841A474BE7423500C122A")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1597397284 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder("GsmMmiCode {");
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
        varB4EAC82CA7396A68D541C85D26508E83_1597397284 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1597397284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597397284;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "9A3C08FC3E505EA59A036940348ACC20", hash_generated_field = "8264E3351B5C334170EC1611134B4013")

    static int MAX_LENGTH_SHORT_CODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "C03AB9291666D1A3221E51755E6E283F", hash_generated_field = "76B431A3D01E09E3B02448BB9638E796")

    static char END_OF_USSD_COMMAND = '#';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "A537752B1259F88AC18F76D3115FF078", hash_generated_field = "5AECC7DC0D470BF7DFF478CC59C2E8F4")

    static String ACTION_ACTIVATE = "*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "6D54A4CFA33154B4F25361364F9EBBFD", hash_generated_field = "DDF2F0E0B32AA1AA01B9B2CEAD1E5AA6")

    static String ACTION_DEACTIVATE = "#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "25583D22F5D13B64BA6FE4B3EE60AC86", hash_generated_field = "89D6EE21D6883DAD6AA8BC11DB744367")

    static String ACTION_INTERROGATE = "*#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A7C2819604CBED112A4FCD46FBEE7793")

    static String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "3A1254E19648A61BA480A107270318F9", hash_generated_field = "065DAAC4F13F3F86BFD5C9E9E2E2703E")

    static String ACTION_ERASURE = "##";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "B506035B8DD0DBA2172D0BA0EEC13A88", hash_generated_field = "9D92A2B0E8B1E636D975A1F47278B30E")

    static String SC_CLIP = "30";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "EC8AA66BEF533B273213E6DB0BBF8ADF", hash_generated_field = "6C1A2B8A59AED075D16EC690DBEDA5B3")

    static String SC_CLIR = "31";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "ABC9C4C74D231F8ABA6F93F413FB3FD0", hash_generated_field = "FBA4096D307D2B8864AD2B1604F9920F")

    static String SC_CFU = "21";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "9454383467543242D669ED87F248413F", hash_generated_field = "F2E546F3016B7EFB62D40AD597971149")

    static String SC_CFB = "67";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "283733E2C01965DFD9773570E027EE6F", hash_generated_field = "90CDB85A8269D4D59D8D5328431715A1")

    static String SC_CFNRy = "61";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "9639B61E8C19778C436B9EB92511C44A", hash_generated_field = "AEB3C88EEEDE1490E70F908659F69520")

    static String SC_CFNR = "62";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "F3E9FC00FA6C76B92C393B7FEAAD3FA6", hash_generated_field = "BBCCB358DA9D9AD857AF7B963F3AA4BF")

    static String SC_CF_All = "002";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "536F482EC4EF47627A43E2F42C660DAC", hash_generated_field = "C1D3EEE1BAE5B4117DA12DD03F5F5E30")

    static String SC_CF_All_Conditional = "004";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "66E77556273BFCA545031190388E9C77", hash_generated_field = "6DE84E57C2896FACDF96D24E49EAADA0")

    static String SC_WAIT = "43";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "974BB9052E8EDAB3B8DB0339197E7AE0", hash_generated_field = "D1C262E2E7F5EB8FA40FF0D9C0B50244")

    static String SC_BAOC = "33";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "30AA7D36FDDA5FDE334B45C22EF77A0F", hash_generated_field = "2AC8FBF67EACEC01A1933A6EFC932C09")

    static String SC_BAOIC = "331";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "FD10E90BD126124E5850D6F4CCEAD16B", hash_generated_field = "939109847DF5BA936B6E69688556F84F")

    static String SC_BAOICxH = "332";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "E17BDC7554CEA6F3DB3F5A99ADC0DF37", hash_generated_field = "F35941F10D153D9E6E659143FA680739")

    static String SC_BAIC = "35";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "590580DA02A1809E7C37E217AC28C3AA", hash_generated_field = "53DB5988ED7A526D2F8B97FA8B2E4741")

    static String SC_BAICr = "351";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "2D6A703DBB1F260ACFD5648813B27270", hash_generated_field = "1380B925B9B91D230A94218DCF2E989B")

    static String SC_BA_ALL = "330";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "E6C14FB76617FAC17954B4D2D9BA77D7", hash_generated_field = "3671C1991C4AF571143363F370B56533")

    static String SC_BA_MO = "333";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.609 -0400", hash_original_field = "A1749A6E67C7A811178C645BF395C965", hash_generated_field = "53AD2C73E24E851A30AA6A92847BA583")

    static String SC_BA_MT = "353";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.619 -0400", hash_original_field = "35425CC920C614B65CECDD2A8D8F526F", hash_generated_field = "957EC6AC4F75F6EE9B8416C5F2595965")

    static String SC_PWD = "03";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.619 -0400", hash_original_field = "D7B4EA3A3E3449565EA9B1BFEC63FCAD", hash_generated_field = "74DD469242D71839C1AEFF6A3BCE62F8")

    static String SC_PIN = "04";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.619 -0400", hash_original_field = "68C3A8A262F7F737FB51D8F10B96BE6C", hash_generated_field = "60050BC4DACDB08773185FF1E948A307")

    static String SC_PIN2 = "042";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.619 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "52D6EA3DA97CB2F6CC9A378A79272126")

    static String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "D00C049CD89213BBED85DA008A8C0664", hash_generated_field = "53D357AE6165562FB769D93A8DD05230")

    static String SC_PUK2 = "052";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "C28C6E89E5E737E3205DD6BF7D09334C")

    static int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "EAB3780CCE31DBB465E64A2CD46D2990", hash_generated_field = "108DC006C3BD0A199194CA96D360A07F")

    static int EVENT_GET_CLIR_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "6093DB005424AB007B12DCE4B4BC126C", hash_generated_field = "D03F4B39FDEA9ED30884D07844E1E2BC")

    static int EVENT_QUERY_CF_COMPLETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "6B552A15FE79814FE37ADA5EB027B548", hash_generated_field = "7768B750FE2B123A9009E3E0E43C786D")

    static int EVENT_USSD_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "E6D8D584F5F0A4F20E7A8840538FA1EA", hash_generated_field = "34C4A62BBD0F6C0938CC31475B1D7CFF")

    static int EVENT_QUERY_COMPLETE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "CB9C1EA429412F1AE1D5CE68B2BCB19C", hash_generated_field = "AB482C97F3B520BC2E7ED7C1FA52E1F3")

    static int EVENT_SET_CFF_COMPLETE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "4C6E6B70640FA17BEF8F121BA52ED445", hash_generated_field = "9279B05B40D35AE0AE8483E3742C4568")

    static int EVENT_USSD_CANCEL_COMPLETE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "3902BAEB69E5FDBE62258952DBE89AF9", hash_generated_field = "5990EA0198CB826DF3EBD44395CC5B38")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "67A82B8D8FFD3CEB2AC78DA930FA08EA")

    static int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "3967DC6CB27B4A176DB06BB6965EA740")

    static int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "8DF1955D2A80A64DF6CA9D07E7279925")

    static int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "2DE2E56A202D75EA6DBC7E02F9C168B1")

    static int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "727CAF1B82B6257573EF47EE75C4ECA5")

    static int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "9D7105B73000DCD3E53DB6C109CCDA24")

    static int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "B4452B6B6B57FCBB2B8E7D60831D61DB")

    static int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "12AF7E84BC19F5E3B62CF4AF7BE7F361")

    static int MATCH_GROUP_DIALING_NUMBER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:21.620 -0400", hash_original_field = "2727DAB650F3A79EA96DFB00B503B05E", hash_generated_field = "55E2DF2087007B0F74B525D8CFC27B5F")

    static private String[] sTwoDigitNumberPattern;
}

