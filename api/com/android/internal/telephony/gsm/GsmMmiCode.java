package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_DATA;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_DATA_ASYNC;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_DATA_SYNC;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_FAX;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_MAX;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_NONE;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_PACKET;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_PAD;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_SMS;
import static com.android.internal.telephony.CommandsInterface.SERVICE_CLASS_VOICE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;

import com.android.internal.telephony.CallForwardInfo;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.CommandsInterface;
import com.android.internal.telephony.MmiCode;






public final class GsmMmiCode extends Handler implements MmiCode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")

    GSMPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "8D111C48FFCFB880A1878EEA7D383221", hash_generated_field = "75B5B7D441FCCB2BF9802C8C7F593C9E")

    private boolean isPendingUSSD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "07574527064CCEC9D1F5EEA5FA7C4751", hash_generated_field = "A601B09474CCCD19D7EF905D10ED4B31")

    private boolean isUssdRequest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.961 -0400", hash_original_method = "1F245899EC025E108E5BE08C8380C5BD", hash_generated_method = "AE1A92BE86BC124C3840C6CA8E93CC5D")
      GsmMmiCode(GSMPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
        // ---------- Original Method ----------
        //this.phone = phone;
        //this.context = phone.getContext();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    static GsmMmiCode newFromUssdUserInput(String ussdMessge, GSMPhone phone) {
        GsmMmiCode ret = new GsmMmiCode(phone);
        ret.message = ussdMessge;
        ret.state = State.PENDING;
        ret.isPendingUSSD = true;
        return ret;
    }

    
    @DSModeled(DSC.BAN)
    private static String makeEmptyNull(String s) {
        if (s != null && s.length() == 0) return null;
        return s;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isEmptyOrNull(CharSequence s) {
        return s == null || (s.length() == 0);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static int siToTime(String si) {
        if (si == null || si.length() == 0) {
            return 0;
        } else {
            return Integer.parseInt(si, 10);
        }
    }

    
    @DSModeled(DSC.BAN)
    static boolean isServiceCodeCallForwarding(String sc) {
        return sc != null &&
                (sc.equals(SC_CFU)
                || sc.equals(SC_CFB) || sc.equals(SC_CFNRy)
                || sc.equals(SC_CFNR) || sc.equals(SC_CF_All)
                || sc.equals(SC_CF_All_Conditional));
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "B99BC26C6529322F56D2C3594AA3660B")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_1304110748 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1304110748.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1304110748;
        // ---------- Original Method ----------
        //return state;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "1D0D268C659202596960EDD6606F848E")
    public CharSequence getMessage() {
CharSequence varFD182D7074F3848E773A38B067BBB880_1878263229 =         message;
        varFD182D7074F3848E773A38B067BBB880_1878263229.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_1878263229;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "E883165C6689A3782C7AFFDB1FCF97C2", hash_generated_method = "69C120AF8FBBD4F9A9C72DE5B0200F28")
    public void cancel() {
        if(state == State.COMPLETE || state == State.FAILED)        
        {
            return;
        } //End block
        state = State.CANCELLED;
        if(isPendingUSSD)        
        {
            phone.mCM.cancelPendingUssd(obtainMessage(EVENT_USSD_CANCEL_COMPLETE, this));
        } //End block
        else
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "248235E8DF3E05BA5583B3AF86C41C77", hash_generated_method = "DFCEEEBB82790E1CD5AA64CA9AFD78A1")
    public boolean isCancelable() {
        boolean var8D111C48FFCFB880A1878EEA7D383221_172437520 = (isPendingUSSD);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555702497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555702497;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C", hash_generated_method = "5E40258BFC3CF42C8244580FD92948EF")
     boolean isMMI() {
        boolean varFA8A19485DF9D2474D2439AA7B853812_1260076448 = (poundString != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530293218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530293218;
        // ---------- Original Method ----------
        //return poundString != null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.964 -0400", hash_original_method = "C27864618833FAFE773E7DA58094B237", hash_generated_method = "396CB5E44471CCA1F913376AD9C9CA23")
     boolean isShortCode() {
        boolean var111A3A83B84F6CE86C4BA71405D3BB20_1754645319 = (poundString == null
                    && dialingNumber != null && dialingNumber.length() <= 2);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980597855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980597855;
        // ---------- Original Method ----------
        //return poundString == null
                    //&& dialingNumber != null && dialingNumber.length() <= 2;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "59EBB8632489E0E4FC2DAAE2E73A576E", hash_generated_method = "5B2891107524BEC9D3BCA7C6AF57392F")
     boolean isPinCommand() {
        boolean var13F0F8A2CEF4DD01F0592E9E21113FAC_161294940 = (sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              || sc.equals(SC_PUK) || sc.equals(SC_PUK2)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867695368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867695368;
        // ---------- Original Method ----------
        //return sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              //|| sc.equals(SC_PUK) || sc.equals(SC_PUK2));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "38FEBB881BBF680269ABAA58BA7CAEF9", hash_generated_method = "D88A338F66483B7A4F03E258BF96FF27")
     boolean isTemporaryModeCLIR() {
        boolean var1A4AA322E278790E1200DFA1AC78BAD5_1048551731 = (sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                && (isActivate() || isDeactivate()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_245931565 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_245931565;
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                //&& (isActivate() || isDeactivate());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "29290542493AE0E5F1628242CAC04AE5", hash_generated_method = "9BD41467CFC533057098DDD53C3B3832")
     int getCLIRMode() {
        if(sc != null && sc.equals(SC_CLIR))        
        {
            if(isActivate())            
            {
                int varD38B27557D595B778DCFAE299AD92029_2076144334 = (CommandsInterface.CLIR_SUPPRESSION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460465586 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460465586;
            } //End block
            else
            if(isDeactivate())            
            {
                int varA3FE8AA79AD35CC33958C8A8D3703FFE_556526074 = (CommandsInterface.CLIR_INVOCATION);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544514341 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544514341;
            } //End block
        } //End block
        int varD7A3850F0E720499810E0323D2FBBEBF_756338484 = (CommandsInterface.CLIR_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894080997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894080997;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "68E2406D480606BAD5624672FC8435A4", hash_generated_method = "9C4892851B749195697F4369096115E0")
     boolean isActivate() {
        boolean varD51B6B7143DCE4C416EB68FBE2262A64_1408650948 = (action != null && action.equals(ACTION_ACTIVATE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769705643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_769705643;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ACTIVATE);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "83961E295B5FE9A8E52B830AEEEC29A1", hash_generated_method = "EEBDCB855E2A4D27AC3EA26807D17A5A")
     boolean isDeactivate() {
        boolean var356C7756771A8BB8E836AC8D33500DBC_1273793905 = (action != null && action.equals(ACTION_DEACTIVATE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718943331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718943331;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_DEACTIVATE);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "E588DEB258357C4BFC7DA2575588FA46", hash_generated_method = "73DDD5B834612C3F03CB30707D6955E9")
     boolean isInterrogate() {
        boolean var18153B4C33E04B05BBB237A6E5701168_1033361528 = (action != null && action.equals(ACTION_INTERROGATE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912411344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912411344;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_INTERROGATE);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.965 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "ED2483731DD2F8C500CEA4A87FB2CF7C")
     boolean isRegister() {
        boolean var8AFE299431940E3F9012D8FC2BB2FDCF_1175379672 = (action != null && action.equals(ACTION_REGISTER));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018883478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018883478;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.966 -0400", hash_original_method = "BEEEFB61222182AD97B0B2576158AC2D", hash_generated_method = "38314A784556FAB743E8D49FD3110962")
     boolean isErasure() {
        boolean var3CF522A21BDFB54475D8AFDFA2BB1D25_1707529188 = (action != null && action.equals(ACTION_ERASURE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238563067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238563067;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ERASURE);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.966 -0400", hash_original_method = "18A8B0A5C57D2FDE667C353F321E4EE3", hash_generated_method = "184C9682BB38BBFE0EA6452E5BF93CCD")
    public boolean isPendingUSSD() {
        boolean var8D111C48FFCFB880A1878EEA7D383221_1629404923 = (isPendingUSSD);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_202021362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_202021362;
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.966 -0400", hash_original_method = "29AF801768BF493864C8071B1DB2A48B", hash_generated_method = "6FEF2341D99F4B6D5340FC4D0203BB7B")
    public boolean isUssdRequest() {
        boolean var07574527064CCEC9D1F5EEA5FA7C4751_2005263958 = (isUssdRequest);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337342664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337342664;
        // ---------- Original Method ----------
        //return isUssdRequest;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.968 -0400", hash_original_method = "889EE3022DF864BE1DEDCF5E80AD4B15", hash_generated_method = "3B0C94060606CD508619A2F509FCBE37")
     void processCode() {
        try 
        {
            if(isShortCode())            
            {
                Log.d(LOG_TAG, "isShortCode");
                sendUssd(dialingNumber);
            } //End block
            else
            if(dialingNumber != null)            
            {
                RuntimeException var2E49DDD3355A805A242019B4EA18BC60_798822586 = new RuntimeException ("Invalid or Unsupported MMI Code");
                var2E49DDD3355A805A242019B4EA18BC60_798822586.addTaint(taint);
                throw var2E49DDD3355A805A242019B4EA18BC60_798822586;
            } //End block
            else
            if(sc != null && sc.equals(SC_CLIP))            
            {
                Log.d(LOG_TAG, "is CLIP");
                if(isInterrogate())                
                {
                    phone.mCM.queryCLIP(
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_1168115764 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_1168115764.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_1168115764;
                } //End block
            } //End block
            else
            if(sc != null && sc.equals(SC_CLIR))            
            {
                Log.d(LOG_TAG, "is CLIR");
                if(isActivate())                
                {
                    phone.mCM.setCLIR(CommandsInterface.CLIR_INVOCATION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                } //End block
                else
                if(isDeactivate())                
                {
                    phone.mCM.setCLIR(CommandsInterface.CLIR_SUPPRESSION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                } //End block
                else
                if(isInterrogate())                
                {
                    phone.mCM.getCLIR(
                        obtainMessage(EVENT_GET_CLIR_COMPLETE, this));
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_1135560739 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_1135560739.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_1135560739;
                } //End block
            } //End block
            else
            if(isServiceCodeCallForwarding(sc))            
            {
                Log.d(LOG_TAG, "is CF");
                String dialingNumber = sia;
                int serviceClass = siToServiceClass(sib);
                int reason = scToCallForwardReason(sc);
                int time = siToTime(sic);
                if(isInterrogate())                
                {
                    phone.mCM.queryCallForwardStatus(
                            reason, serviceClass,  dialingNumber,
                                obtainMessage(EVENT_QUERY_CF_COMPLETE, this));
                } //End block
                else
                {
                    int cfAction;
                    if(isActivate())                    
                    {
                        cfAction = CommandsInterface.CF_ACTION_ENABLE;
                    } //End block
                    else
                    if(isDeactivate())                    
                    {
                        cfAction = CommandsInterface.CF_ACTION_DISABLE;
                    } //End block
                    else
                    if(isRegister())                    
                    {
                        cfAction = CommandsInterface.CF_ACTION_REGISTRATION;
                    } //End block
                    else
                    if(isErasure())                    
                    {
                        cfAction = CommandsInterface.CF_ACTION_ERASURE;
                    } //End block
                    else
                    {
                        RuntimeException varBE297E2E2298C577E9B1609E5D2C9636_1447105386 = new RuntimeException ("invalid action");
                        varBE297E2E2298C577E9B1609E5D2C9636_1447105386.addTaint(taint);
                        throw varBE297E2E2298C577E9B1609E5D2C9636_1447105386;
                    } //End block
                    int isSettingUnconditionalVoice = (((reason == CommandsInterface.CF_REASON_UNCONDITIONAL) ||
                                (reason == CommandsInterface.CF_REASON_ALL)) &&
                                (((serviceClass & CommandsInterface.SERVICE_CLASS_VOICE) != 0) ||
                                 (serviceClass == CommandsInterface.SERVICE_CLASS_NONE))) ? 1 : 0;
                    int isEnableDesired = ((cfAction == CommandsInterface.CF_ACTION_ENABLE) ||
                                (cfAction == CommandsInterface.CF_ACTION_REGISTRATION)) ? 1 : 0;
                    Log.d(LOG_TAG, "is CF setCallForward");
                    phone.mCM.setCallForward(cfAction, reason, serviceClass,
                            dialingNumber, time, obtainMessage(
                                    EVENT_SET_CFF_COMPLETE,
                                    isSettingUnconditionalVoice,
                                    isEnableDesired, this));
                } //End block
            } //End block
            else
            if(isServiceCodeCallBarring(sc))            
            {
                String password = sia;
                int serviceClass = siToServiceClass(sib);
                String facility = scToBarringFacility(sc);
                if(isInterrogate())                
                {
                    phone.mCM.queryFacilityLock(facility, password,
                            serviceClass, obtainMessage(EVENT_QUERY_COMPLETE, this));
                } //End block
                else
                if(isActivate() || isDeactivate())                
                {
                    phone.mCM.setFacilityLock(facility, isActivate(), password,
                            serviceClass, obtainMessage(EVENT_SET_COMPLETE, this));
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_84971569 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_84971569.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_84971569;
                } //End block
            } //End block
            else
            if(sc != null && sc.equals(SC_PWD))            
            {
                String facility;
                String oldPwd = sib;
                String newPwd = sic;
                if(isActivate() || isRegister())                
                {
                    action = ACTION_REGISTER;
                    if(sia == null)                    
                    {
                        facility = CommandsInterface.CB_FACILITY_BA_ALL;
                    } //End block
                    else
                    {
                        facility = scToBarringFacility(sia);
                    } //End block
                    if(newPwd.equals(pwd))                    
                    {
                        phone.mCM.changeBarringPassword(facility, oldPwd,
                                newPwd, obtainMessage(EVENT_SET_COMPLETE, this));
                    } //End block
                    else
                    {
                        handlePasswordError(com.android.internal.R.string.passwordIncorrect);
                    } //End block
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_94725273 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_94725273.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_94725273;
                } //End block
            } //End block
            else
            if(sc != null && sc.equals(SC_WAIT))            
            {
                int serviceClass = siToServiceClass(sia);
                if(isActivate() || isDeactivate())                
                {
                    phone.mCM.setCallWaiting(isActivate(), serviceClass,
                            obtainMessage(EVENT_SET_COMPLETE, this));
                } //End block
                else
                if(isInterrogate())                
                {
                    phone.mCM.queryCallWaiting(serviceClass,
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_296798343 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_296798343.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_296798343;
                } //End block
            } //End block
            else
            if(isPinCommand())            
            {
                String oldPinOrPuk = sia;
                String newPin = sib;
                int pinLen = newPin.length();
                if(isRegister())                
                {
                    if(!newPin.equals(sic))                    
                    {
                        handlePasswordError(com.android.internal.R.string.mismatchPin);
                    } //End block
                    else
                    if(pinLen < 4 || pinLen > 8)                    
                    {
                        handlePasswordError(com.android.internal.R.string.invalidPin);
                    } //End block
                    else
                    if(sc.equals(SC_PIN) &&
                               phone.mIccCard.getState() == SimCard.State.PUK_REQUIRED)                    
                    {
                        handlePasswordError(com.android.internal.R.string.needPuk);
                    } //End block
                    else
                    {
                        if(sc.equals(SC_PIN))                        
                        {
                            phone.mCM.changeIccPin(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } //End block
                        else
                        if(sc.equals(SC_PIN2))                        
                        {
                            phone.mCM.changeIccPin2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } //End block
                        else
                        if(sc.equals(SC_PUK))                        
                        {
                            phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } //End block
                        else
                        if(sc.equals(SC_PUK2))                        
                        {
                            phone.mCM.supplyIccPuk2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } //End block
                    } //End block
                } //End block
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_464617080 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_464617080.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_464617080;
                } //End block
            } //End block
            else
            if(poundString != null)            
            {
                sendUssd(poundString);
            } //End block
            else
            {
                RuntimeException var2E49DDD3355A805A242019B4EA18BC60_966294138 = new RuntimeException ("Invalid or Unsupported MMI Code");
                var2E49DDD3355A805A242019B4EA18BC60_966294138.addTaint(taint);
                throw var2E49DDD3355A805A242019B4EA18BC60_966294138;
            } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.969 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "8D5D96E26CBDDA8A4D99891B21FC6323")
    private void handlePasswordError(int res) {
        addTaint(res);
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        //state = State.FAILED;
        //StringBuilder sb = new StringBuilder(getScString());
        //sb.append("\n");
        //sb.append(context.getText(res));
        //message = sb;
        //phone.onMMIDone(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.969 -0400", hash_original_method = "A7DAC75B31530E6CD4845B1030678B66", hash_generated_method = "C3D13BA2A2AC3FDB3D4B1F4B0F6DB9E6")
     void onUssdFinished(String ussdMessage, boolean isUssdRequest) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(state == State.PENDING)        
        {
            if(ussdMessage == null)            
            {
                message = context.getText(com.android.internal.R.string.mmiComplete);
            } //End block
            else
            {
                message = ussdMessage;
            } //End block
            this.isUssdRequest = isUssdRequest;
            if(!isUssdRequest)            
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.969 -0400", hash_original_method = "6CB35EDB68C77D37EFB134F2D3B374DA", hash_generated_method = "29CB3DD3195A2DFA68F54C3B4624BDDA")
     void onUssdFinishedError() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(state == State.PENDING)        
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.970 -0400", hash_original_method = "91A2759A8D20AD291EA9305932FA3032", hash_generated_method = "26B56314674E59602C6CBC0D096E42F9")
     void sendUssd(String ussdMessage) {
        addTaint(ussdMessage.getTaint());
        isPendingUSSD = true;
        phone.mCM.sendUSSD(ussdMessage,
            obtainMessage(EVENT_USSD_COMPLETE, this));
        // ---------- Original Method ----------
        //isPendingUSSD = true;
        //phone.mCM.sendUSSD(ussdMessage,
            //obtainMessage(EVENT_USSD_COMPLETE, this));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.970 -0400", hash_original_method = "5C6BF8BFD3AA6C53F0FB54F2701C6A7B", hash_generated_method = "CA24843F68CF3143583FC9293170609A")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_SET_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        onSetComplete(ar);
        break;
        case EVENT_SET_CFF_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        if((ar.exception == null) && (msg.arg1 == 1))        
        {
            boolean cffEnabled = (msg.arg2 == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        } //End block
        onSetComplete(ar);
        break;
        case EVENT_GET_CLIR_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        onGetClirComplete(ar);
        break;
        case EVENT_QUERY_CF_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        onQueryCfComplete(ar);
        break;
        case EVENT_QUERY_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        onQueryComplete(ar);
        break;
        case EVENT_USSD_COMPLETE:
        ar = (AsyncResult) (msg.obj);
        if(ar.exception != null)        
        {
            state = State.FAILED;
            message = getErrorMessage(ar);
            phone.onMMIDone(this);
        } //End block
        break;
        case EVENT_USSD_CANCEL_COMPLETE:
        phone.onMMIDone(this);
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.970 -0400", hash_original_method = "6FA8450E92822795C4AD46C68EFB0477", hash_generated_method = "9C86C33046D90C86289EB9D1546F281B")
    private CharSequence getErrorMessage(AsyncResult ar) {
        addTaint(ar.getTaint());
        if(ar.exception instanceof CommandException)        
        {
            CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
            if(err == CommandException.Error.FDN_CHECK_FAILURE)            
            {
CharSequence var7546541A18C8CA4977196FFAB1512D14_1135213482 =                 context.getText(com.android.internal.R.string.mmiFdnError);
                var7546541A18C8CA4977196FFAB1512D14_1135213482.addTaint(taint);
                return var7546541A18C8CA4977196FFAB1512D14_1135213482;
            } //End block
        } //End block
CharSequence varE3E2A91E37966F79091D0455567D108C_220169175 =         context.getText(com.android.internal.R.string.mmiError);
        varE3E2A91E37966F79091D0455567D108C_220169175.addTaint(taint);
        return varE3E2A91E37966F79091D0455567D108C_220169175;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.971 -0400", hash_original_method = "F062B7C9E966AA410521C905675EBDA7", hash_generated_method = "57ADA0E6D1D74AA788FCD32093640443")
    private CharSequence getScString() {
        if(sc != null)        
        {
            if(isServiceCodeCallBarring(sc))            
            {
CharSequence var4A219DBE1020D00C65614989003A417F_147895371 =                 context.getText(com.android.internal.R.string.BaMmi);
                var4A219DBE1020D00C65614989003A417F_147895371.addTaint(taint);
                return var4A219DBE1020D00C65614989003A417F_147895371;
            } //End block
            else
            if(isServiceCodeCallForwarding(sc))            
            {
CharSequence var0AD241621EC157480BDF093743E656D7_1834930569 =                 context.getText(com.android.internal.R.string.CfMmi);
                var0AD241621EC157480BDF093743E656D7_1834930569.addTaint(taint);
                return var0AD241621EC157480BDF093743E656D7_1834930569;
            } //End block
            else
            if(sc.equals(SC_CLIP))            
            {
CharSequence varF9D4057DC71DAAF42812A4FDFA85D981_1018972980 =                 context.getText(com.android.internal.R.string.ClipMmi);
                varF9D4057DC71DAAF42812A4FDFA85D981_1018972980.addTaint(taint);
                return varF9D4057DC71DAAF42812A4FDFA85D981_1018972980;
            } //End block
            else
            if(sc.equals(SC_CLIR))            
            {
CharSequence var3B89DE57E1E9329284D992EA4D22610A_1149217964 =                 context.getText(com.android.internal.R.string.ClirMmi);
                var3B89DE57E1E9329284D992EA4D22610A_1149217964.addTaint(taint);
                return var3B89DE57E1E9329284D992EA4D22610A_1149217964;
            } //End block
            else
            if(sc.equals(SC_PWD))            
            {
CharSequence var0F4FB2DC421820976ED3BB3C99D0704C_1603290304 =                 context.getText(com.android.internal.R.string.PwdMmi);
                var0F4FB2DC421820976ED3BB3C99D0704C_1603290304.addTaint(taint);
                return var0F4FB2DC421820976ED3BB3C99D0704C_1603290304;
            } //End block
            else
            if(sc.equals(SC_WAIT))            
            {
CharSequence var2C556777341C88B98256CC700C9D9AD1_8532645 =                 context.getText(com.android.internal.R.string.CwMmi);
                var2C556777341C88B98256CC700C9D9AD1_8532645.addTaint(taint);
                return var2C556777341C88B98256CC700C9D9AD1_8532645;
            } //End block
            else
            if(isPinCommand())            
            {
CharSequence varC01B34D797D5ECB0C81BDA0577666337_1800486325 =                 context.getText(com.android.internal.R.string.PinMmi);
                varC01B34D797D5ECB0C81BDA0577666337_1800486325.addTaint(taint);
                return varC01B34D797D5ECB0C81BDA0577666337_1800486325;
            } //End block
        } //End block
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1199425086 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1199425086.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1199425086;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.971 -0400", hash_original_method = "86E59952328AB1858ED821151A4A3DAE", hash_generated_method = "72DA66FC41DA63F6A45EEB9BED890277")
    private void onSetComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        if(ar.exception != null)        
        {
            state = State.FAILED;
            if(ar.exception instanceof CommandException)            
            {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
                if(err == CommandException.Error.PASSWORD_INCORRECT)                
                {
                    if(isPinCommand())                    
                    {
                        if(sc.equals(SC_PUK) || sc.equals(SC_PUK2))                        
                        {
                            sb.append(context.getText(
                                    com.android.internal.R.string.badPuk));
                        } //End block
                        else
                        {
                            sb.append(context.getText(
                                    com.android.internal.R.string.badPin));
                        } //End block
                    } //End block
                    else
                    {
                        sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                    } //End block
                } //End block
                else
                if(err == CommandException.Error.SIM_PUK2)                
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.badPin));
                    sb.append("\n");
                    sb.append(context.getText(
                            com.android.internal.R.string.needPuk2));
                } //End block
                else
                if(err == CommandException.Error.FDN_CHECK_FAILURE)                
                {
                    sb.append(context.getText(com.android.internal.R.string.mmiFdnError));
                } //End block
                else
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                } //End block
            } //End block
            else
            {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            } //End block
        } //End block
        else
        if(isActivate())        
        {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceEnabled));
            if(sc.equals(SC_CLIR))            
            {
                phone.saveClirSetting(CommandsInterface.CLIR_INVOCATION);
            } //End block
        } //End block
        else
        if(isDeactivate())        
        {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceDisabled));
            if(sc.equals(SC_CLIR))            
            {
                phone.saveClirSetting(CommandsInterface.CLIR_SUPPRESSION);
            } //End block
        } //End block
        else
        if(isRegister())        
        {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
        } //End block
        else
        if(isErasure())        
        {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceErased));
        } //End block
        else
        {
            state = State.FAILED;
            sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
        } //End block
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.972 -0400", hash_original_method = "E00F9D791A3B8B3DD19100E46A3BBC7E", hash_generated_method = "C14F21D7036AD251CC817E51F061C364")
    private void onGetClirComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        if(ar.exception != null)        
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        else
        {
            int clirArgs[];
            clirArgs = (int[])ar.result;
switch(clirArgs[1]){
            case 0:
            sb.append(context.getText(
                                com.android.internal.R.string.serviceNotProvisioned));
            state = State.COMPLETE;
            break;
            case 1:
            sb.append(context.getText(
                                com.android.internal.R.string.CLIRPermanent));
            state = State.COMPLETE;
            break;
            case 2:
            sb.append(context.getText(
                                com.android.internal.R.string.mmiError));
            state = State.FAILED;
            break;
            case 3:
switch(clirArgs[0]){
            default:
            case 0:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
            break;
            case 1:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
            break;
            case 2:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOff));
            break;
}            state = State.COMPLETE;
            break;
            case 4:
switch(clirArgs[0]){
            default:
            case 0:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
            break;
            case 1:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOn));
            break;
            case 2:
            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
            break;
}            state = State.COMPLETE;
            break;
}
        } //End block
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.972 -0400", hash_original_method = "8B6CA3810AD4ECA237178B5B4043C8E2", hash_generated_method = "312ACBC7EE053A813726024FD12D6920")
    private CharSequence serviceClassToCFString(int serviceClass) {
        addTaint(serviceClass);
switch(serviceClass){
        case SERVICE_CLASS_VOICE:
CharSequence varFF54E87D2E0E544CE42D209B62BE906F_1947676800 =         context.getText(com.android.internal.R.string.serviceClassVoice);
        varFF54E87D2E0E544CE42D209B62BE906F_1947676800.addTaint(taint);
        return varFF54E87D2E0E544CE42D209B62BE906F_1947676800;
        case SERVICE_CLASS_DATA:
CharSequence varC7AE682EEFB8DD18B620D8062E669A7C_1136336201 =         context.getText(com.android.internal.R.string.serviceClassData);
        varC7AE682EEFB8DD18B620D8062E669A7C_1136336201.addTaint(taint);
        return varC7AE682EEFB8DD18B620D8062E669A7C_1136336201;
        case SERVICE_CLASS_FAX:
CharSequence var85335132685F70084C63EB344A1EF39F_596384735 =         context.getText(com.android.internal.R.string.serviceClassFAX);
        var85335132685F70084C63EB344A1EF39F_596384735.addTaint(taint);
        return var85335132685F70084C63EB344A1EF39F_596384735;
        case SERVICE_CLASS_SMS:
CharSequence var8D5C16A0957AD852D16D857A10534712_2022590669 =         context.getText(com.android.internal.R.string.serviceClassSMS);
        var8D5C16A0957AD852D16D857A10534712_2022590669.addTaint(taint);
        return var8D5C16A0957AD852D16D857A10534712_2022590669;
        case SERVICE_CLASS_DATA_SYNC:
CharSequence varDAFEA5AB5B57B8D6C57532F76ADE6D62_1272207411 =         context.getText(com.android.internal.R.string.serviceClassDataSync);
        varDAFEA5AB5B57B8D6C57532F76ADE6D62_1272207411.addTaint(taint);
        return varDAFEA5AB5B57B8D6C57532F76ADE6D62_1272207411;
        case SERVICE_CLASS_DATA_ASYNC:
CharSequence var85B115499EA3716710A403CA79D98650_1758184004 =         context.getText(com.android.internal.R.string.serviceClassDataAsync);
        var85B115499EA3716710A403CA79D98650_1758184004.addTaint(taint);
        return var85B115499EA3716710A403CA79D98650_1758184004;
        case SERVICE_CLASS_PACKET:
CharSequence var89CDAFFB46A2035ACE8334A7BE85B52C_804084934 =         context.getText(com.android.internal.R.string.serviceClassPacket);
        var89CDAFFB46A2035ACE8334A7BE85B52C_804084934.addTaint(taint);
        return var89CDAFFB46A2035ACE8334A7BE85B52C_804084934;
        case SERVICE_CLASS_PAD:
CharSequence varF9B18B8D12BC5BE7E2E4098B2E06D733_567225847 =         context.getText(com.android.internal.R.string.serviceClassPAD);
        varF9B18B8D12BC5BE7E2E4098B2E06D733_567225847.addTaint(taint);
        return varF9B18B8D12BC5BE7E2E4098B2E06D733_567225847;
        default:
CharSequence var540C13E9E156B687226421B24F2DF178_1995004638 =         null;
        var540C13E9E156B687226421B24F2DF178_1995004638.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1995004638;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.973 -0400", hash_original_method = "ECAE8AA4EBDE1134552CC635B1F3D0F6", hash_generated_method = "3BF84B42A4ADBC323722D70748BD21E7")
    private CharSequence makeCFQueryResultMessage(CallForwardInfo info, int serviceClassMask) {
        addTaint(serviceClassMask);
        addTaint(info.getTaint());
        CharSequence template;
        String sources[] = {"{0}", "{1}", "{2}"};
        CharSequence destinations[] = new CharSequence[3];
        boolean needTimeTemplate;
        needTimeTemplate =
            (info.reason == CommandsInterface.CF_REASON_NO_REPLY);
        if(info.status == 1)        
        {
            if(needTimeTemplate)            
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwardedTime);
            } //End block
            else
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwarded);
            } //End block
        } //End block
        else
        if(info.status == 0 && isEmptyOrNull(info.number))        
        {
            template = context.getText(
                        com.android.internal.R.string.cfTemplateNotForwarded);
        } //End block
        else
        {
            if(needTimeTemplate)            
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateRegisteredTime);
            } //End block
            else
            {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateRegistered);
            } //End block
        } //End block
        destinations[0] = serviceClassToCFString(info.serviceClass & serviceClassMask);
        destinations[1] = PhoneNumberUtils.stringFromStringAndTOA(info.number, info.toa);
        destinations[2] = Integer.toString(info.timeSeconds);
        if(info.reason == CommandsInterface.CF_REASON_UNCONDITIONAL &&
                (info.serviceClass & serviceClassMask)
                        == CommandsInterface.SERVICE_CLASS_VOICE)        
        {
            boolean cffEnabled = (info.status == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        } //End block
CharSequence varCC00AC05189E4C48DCF26ECA130B36A6_282295775 =         TextUtils.replace(template, sources, destinations);
        varCC00AC05189E4C48DCF26ECA130B36A6_282295775.addTaint(taint);
        return varCC00AC05189E4C48DCF26ECA130B36A6_282295775;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.974 -0400", hash_original_method = "5082D13BAC647DFAEF8F3236E64BC951", hash_generated_method = "6DB41983D5E0E4F723A47281CAC55512")
    private void onQueryCfComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        if(ar.exception != null)        
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        else
        {
            CallForwardInfo infos[];
            infos = (CallForwardInfo[]) ar.result;
            if(infos.length == 0)            
            {
                sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                phone.mIccRecords.setVoiceCallForwardingFlag(1, false);
            } //End block
            else
            {
                SpannableStringBuilder tb = new SpannableStringBuilder();
for(int serviceClassMask = 1;serviceClassMask <= SERVICE_CLASS_MAX;serviceClassMask <<= 1)
                {
for(int i = 0, s = infos.length;i < s;i++)
                    {
                        if((serviceClassMask & infos[i].serviceClass) != 0)                        
                        {
                            tb.append(makeCFQueryResultMessage(infos[i],
                                            serviceClassMask));
                            tb.append("\n");
                        } //End block
                    } //End block
                } //End block
                sb.append(tb);
            } //End block
            state = State.COMPLETE;
        } //End block
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.974 -0400", hash_original_method = "34E140E893F772F43554211DC345FDB0", hash_generated_method = "31B33ACCF86E4A4767DBAF42DDAE8BBF")
    private void onQueryComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        if(ar.exception != null)        
        {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } //End block
        else
        {
            int[] ints = (int[])ar.result;
            if(ints.length != 0)            
            {
                if(ints[0] == 0)                
                {
                    sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                } //End block
                else
                if(sc.equals(SC_WAIT))                
                {
                    sb.append(createQueryCallWaitingResultMessage(ints[1]));
                } //End block
                else
                if(isServiceCodeCallBarring(sc))                
                {
                    sb.append(createQueryCallBarringResultMessage(ints[0]));
                } //End block
                else
                if(ints[0] == 1)                
                {
                    sb.append(context.getText(com.android.internal.R.string.serviceEnabled));
                } //End block
                else
                {
                    sb.append(context.getText(com.android.internal.R.string.mmiError));
                } //End block
            } //End block
            else
            {
                sb.append(context.getText(com.android.internal.R.string.mmiError));
            } //End block
            state = State.COMPLETE;
        } //End block
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_method = "8FB50CB401051839B48C4DBAEAA3D5D3", hash_generated_method = "C5C53F38FCCCB2B36DC3A3E3646F2B62")
    private CharSequence createQueryCallWaitingResultMessage(int serviceClass) {
        addTaint(serviceClass);
        StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
for(int classMask = 1;classMask <= SERVICE_CLASS_MAX;classMask <<= 1)
        {
            if((classMask & serviceClass) != 0)            
            {
                sb.append("\n");
                sb.append(serviceClassToCFString(classMask & serviceClass));
            } //End block
        } //End block
CharSequence var8C7F5CF7BA5191ABF78E376D65A0039D_639784672 =         sb;
        var8C7F5CF7BA5191ABF78E376D65A0039D_639784672.addTaint(taint);
        return var8C7F5CF7BA5191ABF78E376D65A0039D_639784672;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_method = "C357AC638D1646361DDD93B23863C2E5", hash_generated_method = "C2370D1016E4F243E580FD27D4A0F2EF")
    private CharSequence createQueryCallBarringResultMessage(int serviceClass) {
        addTaint(serviceClass);
        StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));
for(int classMask = 1;classMask <= SERVICE_CLASS_MAX;classMask <<= 1)
        {
            if((classMask & serviceClass) != 0)            
            {
                sb.append("\n");
                sb.append(serviceClassToCFString(classMask & serviceClass));
            } //End block
        } //End block
CharSequence var8C7F5CF7BA5191ABF78E376D65A0039D_1567293346 =         sb;
        var8C7F5CF7BA5191ABF78E376D65A0039D_1567293346.addTaint(taint);
        return var8C7F5CF7BA5191ABF78E376D65A0039D_1567293346;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_method = "4616EBEA9D2FF88EEA02D51F5D1F1A7C", hash_generated_method = "CB3BD43A675D97A77344770CAFA88BE4")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GsmMmiCode {");
        sb.append("State=" + getState());
        if(action != null)        
        sb.append(" action=" + action);
        if(sc != null)        
        sb.append(" sc=" + sc);
        if(sia != null)        
        sb.append(" sia=" + sia);
        if(sib != null)        
        sb.append(" sib=" + sib);
        if(sic != null)        
        sb.append(" sic=" + sic);
        if(poundString != null)        
        sb.append(" poundString=" + poundString);
        if(dialingNumber != null)        
        sb.append(" dialingNumber=" + dialingNumber);
        if(pwd != null)        
        sb.append(" pwd=" + pwd);
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_495599625 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_495599625.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_495599625;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "9A3C08FC3E505EA59A036940348ACC20", hash_generated_field = "84380FB2A501B00185F3C8C921C42CD0")

    static final int MAX_LENGTH_SHORT_CODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "C03AB9291666D1A3221E51755E6E283F", hash_generated_field = "D2F2A0356ABABF263CD1876D3484452A")

    static final char END_OF_USSD_COMMAND = '#';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "A537752B1259F88AC18F76D3115FF078", hash_generated_field = "18F682957DD333F418DC1E51CABE0145")

    static final String ACTION_ACTIVATE = "*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "6D54A4CFA33154B4F25361364F9EBBFD", hash_generated_field = "E3284E18102DE7D7C6F38C074B8DCE9F")

    static final String ACTION_DEACTIVATE = "#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "25583D22F5D13B64BA6FE4B3EE60AC86", hash_generated_field = "D264585CD251BCD3ABEAC4C7825F93F9")

    static final String ACTION_INTERROGATE = "*#";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A747A2BA07E0220107EEBEA1B6706D02")

    static final String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.975 -0400", hash_original_field = "3A1254E19648A61BA480A107270318F9", hash_generated_field = "32CD02DE89D027BB80525CC133B872CA")

    static final String ACTION_ERASURE = "##";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "B506035B8DD0DBA2172D0BA0EEC13A88", hash_generated_field = "A51D4720DC81AC3C4C86A4D8412F140A")

    static final String SC_CLIP = "30";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "EC8AA66BEF533B273213E6DB0BBF8ADF", hash_generated_field = "E644B736CD2A9C2179B5ADA66B2BD371")

    static final String SC_CLIR = "31";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "ABC9C4C74D231F8ABA6F93F413FB3FD0", hash_generated_field = "A0A984619995E559906729FB0885BD37")

    static final String SC_CFU = "21";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "9454383467543242D669ED87F248413F", hash_generated_field = "162AB085207CEB2C27F8FDC8BF9ECDF2")

    static final String SC_CFB = "67";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "283733E2C01965DFD9773570E027EE6F", hash_generated_field = "188B5492DB9239773311815652D08E1E")

    static final String SC_CFNRy = "61";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "9639B61E8C19778C436B9EB92511C44A", hash_generated_field = "970B94E83FA60DC84055EBAC72BEA6A7")

    static final String SC_CFNR = "62";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "F3E9FC00FA6C76B92C393B7FEAAD3FA6", hash_generated_field = "AAACA7CABEBB58D4DBEDA093B2CDF4C5")

    static final String SC_CF_All = "002";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "536F482EC4EF47627A43E2F42C660DAC", hash_generated_field = "E97209C1CAD929CA0DC97B53BB34B72F")

    static final String SC_CF_All_Conditional = "004";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "66E77556273BFCA545031190388E9C77", hash_generated_field = "7E42427065171F529F659EBE79102742")

    static final String SC_WAIT = "43";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "974BB9052E8EDAB3B8DB0339197E7AE0", hash_generated_field = "EB539ECDFB664D7B6F97071235485A9F")

    static final String SC_BAOC = "33";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "30AA7D36FDDA5FDE334B45C22EF77A0F", hash_generated_field = "E42D4E647E8ACC2C103C2935E6E0CE74")

    static final String SC_BAOIC = "331";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "FD10E90BD126124E5850D6F4CCEAD16B", hash_generated_field = "91A59766F8A5C17F073F097729110BA1")

    static final String SC_BAOICxH = "332";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "E17BDC7554CEA6F3DB3F5A99ADC0DF37", hash_generated_field = "8A5B8B89DDC698F51EFD8240BA01409D")

    static final String SC_BAIC = "35";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "590580DA02A1809E7C37E217AC28C3AA", hash_generated_field = "481173BEDB5B2B2B9B6107CCDD3C1DFB")

    static final String SC_BAICr = "351";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "2D6A703DBB1F260ACFD5648813B27270", hash_generated_field = "2118AEBDF2A411624DDAA38436B55831")

    static final String SC_BA_ALL = "330";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "E6C14FB76617FAC17954B4D2D9BA77D7", hash_generated_field = "78090C0D99EB492E8EA3B970D8545B61")

    static final String SC_BA_MO = "333";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "A1749A6E67C7A811178C645BF395C965", hash_generated_field = "D87B853EA32848746BBA1779B8A2EE68")

    static final String SC_BA_MT = "353";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "35425CC920C614B65CECDD2A8D8F526F", hash_generated_field = "67CCC016F241E1D4CFD0A5CE5C530D23")

    static final String SC_PWD = "03";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "D7B4EA3A3E3449565EA9B1BFEC63FCAD", hash_generated_field = "EEE3024D1CF5D84AF8F4CB01077B8E95")

    static final String SC_PIN = "04";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "68C3A8A262F7F737FB51D8F10B96BE6C", hash_generated_field = "7A8798943D2B724D80E98EC6B7CB93B6")

    static final String SC_PIN2 = "042";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "D00C049CD89213BBED85DA008A8C0664", hash_generated_field = "B746ACB42145A31CD109C60F14BFE667")

    static final String SC_PUK2 = "052";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")

    static final int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "EAB3780CCE31DBB465E64A2CD46D2990", hash_generated_field = "9829C51898ECEEF688DC24D5C6D88094")

    static final int EVENT_GET_CLIR_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "6093DB005424AB007B12DCE4B4BC126C", hash_generated_field = "7AFF40CB3CEB21DFC3DD957EE7B8EBBC")

    static final int EVENT_QUERY_CF_COMPLETE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "6B552A15FE79814FE37ADA5EB027B548", hash_generated_field = "D739A36AE28735AFC84C598B959E4F6E")

    static final int EVENT_USSD_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "E6D8D584F5F0A4F20E7A8840538FA1EA", hash_generated_field = "72ABCFECA11B8C5650C5459A9D911C41")

    static final int EVENT_QUERY_COMPLETE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "CB9C1EA429412F1AE1D5CE68B2BCB19C", hash_generated_field = "D47F75990E603624F182DA469CF653E4")

    static final int EVENT_SET_CFF_COMPLETE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "4C6E6B70640FA17BEF8F121BA52ED445", hash_generated_field = "1A3F2D11BE99F10E9049869D455AA7BC")

    static final int EVENT_USSD_CANCEL_COMPLETE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "3902BAEB69E5FDBE62258952DBE89AF9", hash_generated_field = "5990EA0198CB826DF3EBD44395CC5B38")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")

    static final int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")

    static final int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.976 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")

    static final int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.977 -0400", hash_original_field = "2727DAB650F3A79EA96DFB00B503B05E", hash_generated_field = "55E2DF2087007B0F74B525D8CFC27B5F")

    static private String[] sTwoDigitNumberPattern;
}

