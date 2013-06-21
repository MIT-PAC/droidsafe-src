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
    GSMPhone phone;
    Context context;
    String action;
    String sc;
    String sia, sib, sic;
    String poundString;
    String dialingNumber;
    String pwd;
    private boolean isPendingUSSD;
    private boolean isUssdRequest;
    State state = State.PENDING;
    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.896 -0400", hash_original_method = "1F245899EC025E108E5BE08C8380C5BD", hash_generated_method = "8C1CD8CFAE84BCF1F7C7DBB2018EE973")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GsmMmiCode(GSMPhone phone) {
        super(phone.getHandler().getLooper());
        dsTaint.addTaint(phone.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.898 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "F5E227F5D2B96691C815C4C56ED31889")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.898 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "F66C4D887CEB386B9EEE5F07E323C620")
    @DSModeled(DSC.SAFE)
    public CharSequence getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.899 -0400", hash_original_method = "E883165C6689A3782C7AFFDB1FCF97C2", hash_generated_method = "DDD294D2F15DC82E2D473B5D0C41FEB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.899 -0400", hash_original_method = "248235E8DF3E05BA5583B3AF86C41C77", hash_generated_method = "081C0FACF5601FEE916A283960D970E3")
    @DSModeled(DSC.SAFE)
    public boolean isCancelable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.899 -0400", hash_original_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C", hash_generated_method = "FDA54C4813D8CF93C85C132A02E432A9")
    @DSModeled(DSC.SAFE)
     boolean isMMI() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return poundString != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.899 -0400", hash_original_method = "C27864618833FAFE773E7DA58094B237", hash_generated_method = "4BB84D9F8C6AB49A09A0C314B195AA45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isShortCode() {
        boolean var5484DF39387CF98FB51501CB4001F9FA_1355377302 = (poundString == null
                    && dialingNumber != null && dialingNumber.length() <= 2);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.900 -0400", hash_original_method = "59EBB8632489E0E4FC2DAAE2E73A576E", hash_generated_method = "5047CB2567072F010C676B63CF432716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isPinCommand() {
        boolean varFF503AA9A44C28D3C7411096077FB957_913324981 = (sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              || sc.equals(SC_PUK) || sc.equals(SC_PUK2)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              //|| sc.equals(SC_PUK) || sc.equals(SC_PUK2));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.900 -0400", hash_original_method = "38FEBB881BBF680269ABAA58BA7CAEF9", hash_generated_method = "EDCC6AA75A1C7402B05F92292A3F671C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isTemporaryModeCLIR() {
        boolean var544696A52FC0DFD167FF01D5AB5C7E65_585974839 = (sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                && (isActivate() || isDeactivate()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                //&& (isActivate() || isDeactivate());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.901 -0400", hash_original_method = "29290542493AE0E5F1628242CAC04AE5", hash_generated_method = "071219C85156D163B5E88AB7E28DF697")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int getCLIRMode() {
        {
            boolean var34648CEF6B66EF75C2E3E4FDB714C6B5_891462091 = (sc != null && sc.equals(SC_CLIR));
            {
                {
                    boolean var6DAE9187104E5001F23DD333FAAFF7E8_1211652632 = (isActivate());
                    {
                        boolean var60B1109AE4AFCE40EC270D9BE8674276_397420348 = (isDeactivate());
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.901 -0400", hash_original_method = "68E2406D480606BAD5624672FC8435A4", hash_generated_method = "649914129497FF1E3F9D4FAC8E3EBAFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isActivate() {
        boolean varDA9476B1A494F0D070B1BF7D372D3355_1134108915 = (action != null && action.equals(ACTION_ACTIVATE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.901 -0400", hash_original_method = "83961E295B5FE9A8E52B830AEEEC29A1", hash_generated_method = "5B4FE7C100FF4842F2D5DE0AC636637D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isDeactivate() {
        boolean varE0E3F7818F99EE86F25A069D66EF50F8_387981892 = (action != null && action.equals(ACTION_DEACTIVATE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_DEACTIVATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.901 -0400", hash_original_method = "E588DEB258357C4BFC7DA2575588FA46", hash_generated_method = "A84CCFC9D7C969955857FDC203F9598D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isInterrogate() {
        boolean var80F2797A4F74689C3AE333F5C724FB3D_828746760 = (action != null && action.equals(ACTION_INTERROGATE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_INTERROGATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.901 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "F1D4D9436E78FD876988DF83D8FD5C6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_218956324 = (action != null && action.equals(ACTION_REGISTER));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.902 -0400", hash_original_method = "BEEEFB61222182AD97B0B2576158AC2D", hash_generated_method = "9D4D872E4C412D0073DB1DE900EF64D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isErasure() {
        boolean var26E8FF1C98185BC2E63EA43F2B1F6AA7_2050844046 = (action != null && action.equals(ACTION_ERASURE));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_ERASURE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.902 -0400", hash_original_method = "18A8B0A5C57D2FDE667C353F321E4EE3", hash_generated_method = "5B34BF7CF12A999480D06E7274D16EE4")
    @DSModeled(DSC.SAFE)
    public boolean isPendingUSSD() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isPendingUSSD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.902 -0400", hash_original_method = "29AF801768BF493864C8071B1DB2A48B", hash_generated_method = "A0C675E234D076264532B5FEF8757525")
    @DSModeled(DSC.SAFE)
    public boolean isUssdRequest() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isUssdRequest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.904 -0400", hash_original_method = "889EE3022DF864BE1DEDCF5E80AD4B15", hash_generated_method = "29395E5144D4C3B95924F1D41F7EA55B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processCode() {
        try 
        {
            {
                boolean var8D3139A2E490A629DC2B2B2E088002D1_1498408510 = (isShortCode());
                {
                    Log.d(LOG_TAG, "isShortCode");
                    sendUssd(dialingNumber);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                } //End block
                {
                    boolean varD990A9821BF7C1A6CEBB4AF3A08286F4_1890838526 = (sc != null && sc.equals(SC_CLIP));
                    {
                        Log.d(LOG_TAG, "is CLIP");
                        {
                            boolean var2CCA4E10A7F30CA1D898E5A5AC1ABD11_974253721 = (isInterrogate());
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
                        boolean var0812373E25987806BA10DCBE1830B470_525023362 = (sc != null && sc.equals(SC_CLIR));
                        {
                            Log.d(LOG_TAG, "is CLIR");
                            {
                                boolean var660F9C4115C74CCDF15C3870AE7DD93D_703658650 = (isActivate());
                                {
                                    phone.mCM.setCLIR(CommandsInterface.CLIR_INVOCATION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                } //End block
                                {
                                    boolean varDA9013164DD6CF176DBD049823930B6B_1916503470 = (isDeactivate());
                                    {
                                        phone.mCM.setCLIR(CommandsInterface.CLIR_SUPPRESSION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                                    } //End block
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_1602125651 = (isInterrogate());
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
                            boolean var7312C42DD719B1CD668FCA247DDADED7_1931459090 = (isServiceCodeCallForwarding(sc));
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
                                    boolean var61B524360B73CC876F21BB5D0DD14CDF_797502855 = (isInterrogate());
                                    {
                                        phone.mCM.queryCallForwardStatus(
                            reason, serviceClass,  dialingNumber,
                                obtainMessage(EVENT_QUERY_CF_COMPLETE, this));
                                    } //End block
                                    {
                                        int cfAction;
                                        {
                                            boolean var4E150FF745CF73441F17C76F3D37B88B_319618738 = (isActivate());
                                            {
                                                cfAction = CommandsInterface.CF_ACTION_ENABLE;
                                            } //End block
                                            {
                                                boolean var933AF435450C733B38ACA41F2D3FCAF9_821924901 = (isDeactivate());
                                                {
                                                    cfAction = CommandsInterface.CF_ACTION_DISABLE;
                                                } //End block
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_316967768 = (isRegister());
                                                    {
                                                        cfAction = CommandsInterface.CF_ACTION_REGISTRATION;
                                                    } //End block
                                                    {
                                                        boolean var25ADF80BDE86F8A8B3E8088E4D221AE4_1700192862 = (isErasure());
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
                                boolean var12C22BB7EEA013327BEDC89EF49EBBAB_1405399624 = (isServiceCodeCallBarring(sc));
                                {
                                    String password;
                                    password = sia;
                                    int serviceClass;
                                    serviceClass = siToServiceClass(sib);
                                    String facility;
                                    facility = scToBarringFacility(sc);
                                    {
                                        boolean var18717314843932DC2BFAB4258F743FFD_1964858472 = (isInterrogate());
                                        {
                                            phone.mCM.queryFacilityLock(facility, password,
                            serviceClass, obtainMessage(EVENT_QUERY_COMPLETE, this));
                                        } //End block
                                        {
                                            boolean var119A5D265CCF4791E780BDE84928E729_74712467 = (isActivate() || isDeactivate());
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
                                    boolean varCDD454EC464ABD0A8BFA09F4744BB0C5_865658766 = (sc != null && sc.equals(SC_PWD));
                                    {
                                        String facility;
                                        String oldPwd;
                                        oldPwd = sib;
                                        String newPwd;
                                        newPwd = sic;
                                        {
                                            boolean varED52A25A69DBFEC36BAE7920F2260BF9_1204248476 = (isActivate() || isRegister());
                                            {
                                                action = ACTION_REGISTER;
                                                {
                                                    facility = CommandsInterface.CB_FACILITY_BA_ALL;
                                                } //End block
                                                {
                                                    facility = scToBarringFacility(sia);
                                                } //End block
                                                {
                                                    boolean var0391FAAA3FE1381FC688FE40567A50CA_234435259 = (newPwd.equals(pwd));
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
                                        boolean var572741C1390D1648B95B43B4EB591AAD_618153715 = (sc != null && sc.equals(SC_WAIT));
                                        {
                                            int serviceClass;
                                            serviceClass = siToServiceClass(sia);
                                            {
                                                boolean var2FD224AA61CCD0ABD56110F8F107990B_2076894707 = (isActivate() || isDeactivate());
                                                {
                                                    phone.mCM.setCallWaiting(isActivate(), serviceClass,
                            obtainMessage(EVENT_SET_COMPLETE, this));
                                                } //End block
                                                {
                                                    boolean var75AAC492F8B008891AB83B5FB4B29791_1006896934 = (isInterrogate());
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
                                            boolean varE9E9769B3965CB509E03E906501C297B_2002208060 = (isPinCommand());
                                            {
                                                String oldPinOrPuk;
                                                oldPinOrPuk = sia;
                                                String newPin;
                                                newPin = sib;
                                                int pinLen;
                                                pinLen = newPin.length();
                                                {
                                                    boolean varB2A81FB350799613F9E2D67A1BA1D4A7_1535952317 = (isRegister());
                                                    {
                                                        {
                                                            boolean var8AAFFDB78603D28040F2394F0AD529DA_2062774781 = (!newPin.equals(sic));
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.mismatchPin);
                                                            } //End block
                                                            {
                                                                handlePasswordError(com.android.internal.R.string.invalidPin);
                                                            } //End block
                                                            {
                                                                boolean varB803AB2D427385C9994C2A4CADA7A133_293393548 = (sc.equals(SC_PIN) &&
                               phone.mIccCard.getState() == SimCard.State.PUK_REQUIRED);
                                                                {
                                                                    handlePasswordError(com.android.internal.R.string.needPuk);
                                                                } //End block
                                                                {
                                                                    {
                                                                        boolean var1EDE5DF632D5A9C013C23432D6E0A17F_637073727 = (sc.equals(SC_PIN));
                                                                        {
                                                                            phone.mCM.changeIccPin(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                        } //End block
                                                                        {
                                                                            boolean var0BF913DF155AAE543691723B891AE7DB_435034754 = (sc.equals(SC_PIN2));
                                                                            {
                                                                                phone.mCM.changeIccPin2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                            } //End block
                                                                            {
                                                                                boolean var3FF6DE7548056294F609BF66B6EE3C0F_170278987 = (sc.equals(SC_PUK));
                                                                                {
                                                                                    phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                                                                                } //End block
                                                                                {
                                                                                    boolean var5F1753C6264CCB0AFA8B9E811C51CEDC_1404541060 = (sc.equals(SC_PUK2));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.904 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "9FDE71BB93423304BC5C1C23A2BDA87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handlePasswordError(int res) {
        dsTaint.addTaint(res);
        state = State.FAILED;
        StringBuilder sb;
        sb = new StringBuilder(getScString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.905 -0400", hash_original_method = "A7DAC75B31530E6CD4845B1030678B66", hash_generated_method = "62E3DEE76AA51FF6EB08E0FF803784ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void onUssdFinished(String ussdMessage, boolean isUssdRequest) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(ussdMessage);
        dsTaint.addTaint(isUssdRequest);
        {
            {
                message = context.getText(com.android.internal.R.string.mmiComplete);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.905 -0400", hash_original_method = "6CB35EDB68C77D37EFB134F2D3B374DA", hash_generated_method = "D9A37A1161AFF010CC3D3C13DFD41836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.905 -0400", hash_original_method = "91A2759A8D20AD291EA9305932FA3032", hash_generated_method = "AF248753DAF335572AD1DEF1B141499F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void sendUssd(String ussdMessage) {
        dsTaint.addTaint(ussdMessage);
        isPendingUSSD = true;
        phone.mCM.sendUSSD(ussdMessage,
            obtainMessage(EVENT_USSD_COMPLETE, this));
        // ---------- Original Method ----------
        //isPendingUSSD = true;
        //phone.mCM.sendUSSD(ussdMessage,
            //obtainMessage(EVENT_USSD_COMPLETE, this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.906 -0400", hash_original_method = "5C6BF8BFD3AA6C53F0FB54F2701C6A7B", hash_generated_method = "100087E15406D599A505C5FF45C25A22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.907 -0400", hash_original_method = "6FA8450E92822795C4AD46C68EFB0477", hash_generated_method = "2B6C11F8803E86C948598480B66C92B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getErrorMessage(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
        {
            CommandException.Error err;
            err = ((CommandException)(ar.exception)).getCommandError();
            {
                CharSequence var52DDF7F49327155AD65F070A1293D58F_799483871 = (context.getText(com.android.internal.R.string.mmiFdnError));
            } //End block
        } //End block
        CharSequence var48CACEBCBF4AC5FB8FB09E8724EFA58D_1956031070 = (context.getText(com.android.internal.R.string.mmiError));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.908 -0400", hash_original_method = "F062B7C9E966AA410521C905675EBDA7", hash_generated_method = "924CC28DED89CADFEDCEAA022997E497")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getScString() {
        {
            {
                boolean varCCA5F2A13C1993EFC5A1CF2F0165F813_872175917 = (isServiceCodeCallBarring(sc));
                {
                    CharSequence var25031973F8DF324F9D4793AA2A5BE8F3_339054804 = (context.getText(com.android.internal.R.string.BaMmi));
                } //End block
                {
                    boolean var32DC5B084701CD8CD9A8C906B0EEBD05_1067236579 = (isServiceCodeCallForwarding(sc));
                    {
                        CharSequence varFFDA2854B48A2667C82A10C349277EB6_646518927 = (context.getText(com.android.internal.R.string.CfMmi));
                    } //End block
                    {
                        boolean var6914B4EC879BBBF42E2E74E4C168A160_2094735345 = (sc.equals(SC_CLIP));
                        {
                            CharSequence varEAB3AF3638F49749B00B2D3B9F2997D3_2059199262 = (context.getText(com.android.internal.R.string.ClipMmi));
                        } //End block
                        {
                            boolean var0623604252E0864F742051097B6173BA_1182040522 = (sc.equals(SC_CLIR));
                            {
                                CharSequence var21D864B6BF590D44F707C45AD70119B6_809814722 = (context.getText(com.android.internal.R.string.ClirMmi));
                            } //End block
                            {
                                boolean var5C676F9701A0966D4E94DEF50F123275_670457391 = (sc.equals(SC_PWD));
                                {
                                    CharSequence var076424A4E5936F01964F33C6E6B9E767_1670731907 = (context.getText(com.android.internal.R.string.PwdMmi));
                                } //End block
                                {
                                    boolean varDA6852543E26402D459735260F444175_1289760363 = (sc.equals(SC_WAIT));
                                    {
                                        CharSequence var88023C2DA7755068619F9BD2AE12DB39_1531003927 = (context.getText(com.android.internal.R.string.CwMmi));
                                    } //End block
                                    {
                                        boolean varD1C658B382FEF05BC29F9D45B74B0428_457341802 = (isPinCommand());
                                        {
                                            CharSequence varFF174FAA21A4E7B858F36A7D7194C048_111099948 = (context.getText(com.android.internal.R.string.PinMmi));
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.909 -0400", hash_original_method = "86E59952328AB1858ED821151A4A3DAE", hash_generated_method = "24AF6C53B4802556F384C894870496AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSetComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
                        boolean varE9FBF60BA382E5447A6974F53D0FF9D9_598384284 = (isPinCommand());
                        {
                            {
                                boolean var542A32D8FD5F06047C25109609B431AB_1414887098 = (sc.equals(SC_PUK) || sc.equals(SC_PUK2));
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
            boolean varD4B13402CFA6A550CEC0E5DDCA20FC61_1159620283 = (isActivate());
            {
                state = State.COMPLETE;
                sb.append(context.getText(
                    com.android.internal.R.string.serviceEnabled));
                {
                    boolean var963F1E632E68242542E9A5B1692F1816_1965301646 = (sc.equals(SC_CLIR));
                    {
                        phone.saveClirSetting(CommandsInterface.CLIR_INVOCATION);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var0FE307E32DF6975EC6641BDD38B8A41D_190369222 = (isDeactivate());
                {
                    state = State.COMPLETE;
                    sb.append(context.getText(
                    com.android.internal.R.string.serviceDisabled));
                    {
                        boolean var767B63B127ECD6CE628AB160BBB58776_1838731696 = (sc.equals(SC_CLIR));
                        {
                            phone.saveClirSetting(CommandsInterface.CLIR_SUPPRESSION);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varACC7E5A3F90406763366F9A6873CC87D_540671059 = (isRegister());
                    {
                        state = State.COMPLETE;
                        sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
                    } //End block
                    {
                        boolean var4C83CC598DD8ACFB794FA2BD7EA1E761_489074738 = (isErasure());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.910 -0400", hash_original_method = "E00F9D791A3B8B3DD19100E46A3BBC7E", hash_generated_method = "A00E0D4FC2C9E5899EBBA2B30CC85701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onGetClirComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.910 -0400", hash_original_method = "8B6CA3810AD4ECA237178B5B4043C8E2", hash_generated_method = "84D9B740C502E19437418832DB51BC79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence serviceClassToCFString(int serviceClass) {
        dsTaint.addTaint(serviceClass);
        //Begin case SERVICE_CLASS_VOICE 
        CharSequence var98BFE83DB9419EE7D18CC67384BDD231_33494912 = (context.getText(com.android.internal.R.string.serviceClassVoice));
        //End case SERVICE_CLASS_VOICE 
        //Begin case SERVICE_CLASS_DATA 
        CharSequence varB1F11F1A3E874A15B301ABA43C1BA168_681157980 = (context.getText(com.android.internal.R.string.serviceClassData));
        //End case SERVICE_CLASS_DATA 
        //Begin case SERVICE_CLASS_FAX 
        CharSequence var57316F2BABC9D0D8081DA29CB03DB220_1026315164 = (context.getText(com.android.internal.R.string.serviceClassFAX));
        //End case SERVICE_CLASS_FAX 
        //Begin case SERVICE_CLASS_SMS 
        CharSequence varBA117B082FCD1E3CAD3B28D939EF7C6F_2093546807 = (context.getText(com.android.internal.R.string.serviceClassSMS));
        //End case SERVICE_CLASS_SMS 
        //Begin case SERVICE_CLASS_DATA_SYNC 
        CharSequence var24C66BD4A6BA311FDAAFF70A6E2EAFEE_1361606004 = (context.getText(com.android.internal.R.string.serviceClassDataSync));
        //End case SERVICE_CLASS_DATA_SYNC 
        //Begin case SERVICE_CLASS_DATA_ASYNC 
        CharSequence varC4C935E43F084F6BB2B88EAC8E3968C9_1298245829 = (context.getText(com.android.internal.R.string.serviceClassDataAsync));
        //End case SERVICE_CLASS_DATA_ASYNC 
        //Begin case SERVICE_CLASS_PACKET 
        CharSequence varC07937BA4F50C68BB6CCECEC5FDB4F7F_227288086 = (context.getText(com.android.internal.R.string.serviceClassPacket));
        //End case SERVICE_CLASS_PACKET 
        //Begin case SERVICE_CLASS_PAD 
        CharSequence var6BB50D345D996E058828253B2FF8270B_2073501122 = (context.getText(com.android.internal.R.string.serviceClassPAD));
        //End case SERVICE_CLASS_PAD 
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.911 -0400", hash_original_method = "ECAE8AA4EBDE1134552CC635B1F3D0F6", hash_generated_method = "04066B26C9CB7F48D8FAC6EC703969C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence makeCFQueryResultMessage(CallForwardInfo info, int serviceClassMask) {
        dsTaint.addTaint(serviceClassMask);
        dsTaint.addTaint(info.dsTaint);
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
            boolean var8E4CE04EDC775CBCECD23931344407DA_737437477 = (info.status == 0 && isEmptyOrNull(info.number));
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
        CharSequence varE3513565037F57205C902E80D0E280D0_1864278093 = (TextUtils.replace(template, sources, destinations));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.912 -0400", hash_original_method = "5082D13BAC647DFAEF8F3236E64BC951", hash_generated_method = "EF1C791A44C1C8BF851B8350BA1D48D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onQueryCfComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.913 -0400", hash_original_method = "34E140E893F772F43554211DC345FDB0", hash_generated_method = "69E30E6F2A9D9E88855C98EEFB39DAB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onQueryComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
                    boolean var080A5A128C565A100A91BE3125C6E632_567032391 = (sc.equals(SC_WAIT));
                    {
                        sb.append(createQueryCallWaitingResultMessage(ints[1]));
                    } //End block
                    {
                        boolean var5C4CEC64D984C092A00EC9F31984726F_1843935980 = (isServiceCodeCallBarring(sc));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.913 -0400", hash_original_method = "8FB50CB401051839B48C4DBAEAA3D5D3", hash_generated_method = "C2AF655F17897B86488FAB331B199934")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence createQueryCallWaitingResultMessage(int serviceClass) {
        dsTaint.addTaint(serviceClass);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.914 -0400", hash_original_method = "C357AC638D1646361DDD93B23863C2E5", hash_generated_method = "C98E5AA83DCF8E1A0AC92B76565861C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence createQueryCallBarringResultMessage(int serviceClass) {
        dsTaint.addTaint(serviceClass);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.914 -0400", hash_original_method = "4616EBEA9D2FF88EEA02D51F5D1F1A7C", hash_generated_method = "D7FE833A98E4D960A148717D884E047C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_289355007 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    static final String LOG_TAG = "GSM";
    static final int MAX_LENGTH_SHORT_CODE = 2;
    static final char END_OF_USSD_COMMAND = '#';
    static final String ACTION_ACTIVATE = "*";
    static final String ACTION_DEACTIVATE = "#";
    static final String ACTION_INTERROGATE = "*#";
    static final String ACTION_REGISTER = "**";
    static final String ACTION_ERASURE = "##";
    static final String SC_CLIP    = "30";
    static final String SC_CLIR    = "31";
    static final String SC_CFU     = "21";
    static final String SC_CFB     = "67";
    static final String SC_CFNRy   = "61";
    static final String SC_CFNR    = "62";
    static final String SC_CF_All = "002";
    static final String SC_CF_All_Conditional = "004";
    static final String SC_WAIT     = "43";
    static final String SC_BAOC         = "33";
    static final String SC_BAOIC        = "331";
    static final String SC_BAOICxH      = "332";
    static final String SC_BAIC         = "35";
    static final String SC_BAICr        = "351";
    static final String SC_BA_ALL       = "330";
    static final String SC_BA_MO        = "333";
    static final String SC_BA_MT        = "353";
    static final String SC_PWD          = "03";
    static final String SC_PIN          = "04";
    static final String SC_PIN2         = "042";
    static final String SC_PUK          = "05";
    static final String SC_PUK2         = "052";
    static final int EVENT_SET_COMPLETE         = 1;
    static final int EVENT_GET_CLIR_COMPLETE    = 2;
    static final int EVENT_QUERY_CF_COMPLETE    = 3;
    static final int EVENT_USSD_COMPLETE        = 4;
    static final int EVENT_QUERY_COMPLETE       = 5;
    static final int EVENT_SET_CFF_COMPLETE     = 6;
    static final int EVENT_USSD_CANCEL_COMPLETE = 7;
    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
    static final int MATCH_GROUP_POUND_STRING = 1;
    static final int MATCH_GROUP_ACTION = 2;
    static final int MATCH_GROUP_SERVICE_CODE = 3;
    static final int MATCH_GROUP_SIA = 5;
    static final int MATCH_GROUP_SIB = 7;
    static final int MATCH_GROUP_SIC = 9;
    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    static final int MATCH_GROUP_DIALING_NUMBER = 12;
    static private String[] sTwoDigitNumberPattern;
}

