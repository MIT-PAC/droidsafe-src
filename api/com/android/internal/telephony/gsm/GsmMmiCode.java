package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    //***** Public Class methods

    /**
     * Some dial strings in GSM are defined to do non-call setup
     * things, such as modify or query supplementary service settings (eg, call
     * forwarding). These are generally referred to as "MMI codes".
     * We look to see if the dial string contains a valid MMI code (potentially
     * with a dial string at the end as well) and return info here.
     *
     * If the dial string contains no MMI code, we return an instance with
     * only "dialingNumber" set
     *
     * Please see flow chart in TS 22.030 6.5.3.2
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.278 -0500", hash_original_method = "8402B39923C22D1FB24B49B49F1F42A8", hash_generated_method = "48A29604CC980B78A222C3033D186876")
    static GsmMmiCode
    newFromDialString(String dialString, GSMPhone phone) {
        Matcher m;
        GsmMmiCode ret = null;

        m = sPatternSuppService.matcher(dialString);

        // Is this formatted like a standard supplementary service code?
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
            // TS 22.030 sec 6.5.3.2
            // "Entry of any characters defined in the 3GPP TS 23.038 [8] Default Alphabet
            // (up to the maximum defined in 3GPP TS 24.080 [10]), followed by #SEND".

            ret = new GsmMmiCode(phone);
            ret.poundString = dialString;
        } else if (isTwoDigitShortCode(phone.getContext(), dialString)) {
            //Is a country-specific exception to short codes as defined in TS 22.030, 6.5.3.2
            ret = null;
        } else if (isShortCode(dialString, phone)) {
            // this may be a short code, as defined in TS 22.030, 6.5.3.2
            ret = new GsmMmiCode(phone);
            ret.dialingNumber = dialString;
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.279 -0500", hash_original_method = "0ECC34E099BFC30724AE0A4CC772E58D", hash_generated_method = "72A4120A864FF0B7D60D5A6ECE0BAF91")
    static GsmMmiCode
    newNetworkInitiatedUssd (String ussdMessage,
                                boolean isUssdRequest, GSMPhone phone) {
        GsmMmiCode ret;

        ret = new GsmMmiCode(phone);

        ret.message = ussdMessage;
        ret.isUssdRequest = isUssdRequest;

        // If it's a request, set to PENDING so that it's cancelable.
        if (isUssdRequest) {
            ret.isPendingUSSD = true;
            ret.state = State.PENDING;
        } else {
            ret.state = State.COMPLETE;
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.280 -0500", hash_original_method = "C9AE55E83FE984FC7070B7FB8E416C0A", hash_generated_method = "5C5E157873A71CC21DCBA9D2BDD7459F")
    static GsmMmiCode newFromUssdUserInput(String ussdMessge, GSMPhone phone) {
        GsmMmiCode ret = new GsmMmiCode(phone);

        ret.message = ussdMessge;
        ret.state = State.PENDING;
        ret.isPendingUSSD = true;

        return ret;
    }

    //***** Private Class methods

    /** make empty strings be null.
     *  Regexp returns empty strings for empty groups
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.280 -0500", hash_original_method = "2FD14CE5C15BA6F91A4A0B21760850CD", hash_generated_method = "D25CF56895B420B545C3566DEEFBA18C")
    private static String
    makeEmptyNull (String s) {
        if (s != null && s.length() == 0) return null;

        return s;
    }

    /** returns true of the string is empty or null */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.281 -0500", hash_original_method = "C737E8C6932B9A7F9D7E9BE338A74764", hash_generated_method = "764BD918E60B6F85278690B0F168DBDB")
    private static boolean
    isEmptyOrNull(CharSequence s) {
        return s == null || (s.length() == 0);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.282 -0500", hash_original_method = "B6A5C1E21C62418D5B30EDC2AB73589C", hash_generated_method = "7EF02D02CD4DEA0B338E59111A74239C")
    private static int
    scToCallForwardReason(String sc) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.283 -0500", hash_original_method = "8B9DC5B6762101793E2CAD9D3137B31F", hash_generated_method = "D36853DB0F9D1F80FAD05DA3335D05DA")
    private static int
    siToServiceClass(String si) {
        if (si == null || si.length() == 0) {
                return  SERVICE_CLASS_NONE;
        } else {
            // NumberFormatException should cause MMI fail
            int serviceCode = Integer.parseInt(si, 10);

            switch (serviceCode) {
                case 10: return SERVICE_CLASS_SMS + SERVICE_CLASS_FAX  + SERVICE_CLASS_VOICE;
                case 11: return SERVICE_CLASS_VOICE;
                case 12: return SERVICE_CLASS_SMS + SERVICE_CLASS_FAX;
                case 13: return SERVICE_CLASS_FAX;

                case 16: return SERVICE_CLASS_SMS;

                case 19: return SERVICE_CLASS_FAX + SERVICE_CLASS_VOICE;
/*
    Note for code 20:
     From TS 22.030 Annex C:
                "All GPRS bearer services" are not included in "All tele and bearer services"
                    and "All bearer services"."
....so SERVICE_CLASS_DATA, which (according to 27.007) includes GPRS
*/
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.284 -0500", hash_original_method = "EA9F11340147CBA8D74274830A59B495", hash_generated_method = "52ABF45805D5CA0E1004B5AFE5630596")
    private static int
    siToTime (String si) {
        if (si == null || si.length() == 0) {
            return 0;
        } else {
            // NumberFormatException should cause MMI fail
            return Integer.parseInt(si, 10);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.285 -0500", hash_original_method = "DDD4E529F8327EB1554D742EA61797EC", hash_generated_method = "3139451D0999C3D0AE9ED731CDC2851B")
    static boolean
    isServiceCodeCallForwarding(String sc) {
        return sc != null &&
                (sc.equals(SC_CFU)
                || sc.equals(SC_CFB) || sc.equals(SC_CFNRy)
                || sc.equals(SC_CFNR) || sc.equals(SC_CF_All)
                || sc.equals(SC_CF_All_Conditional));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.286 -0500", hash_original_method = "9491969B9286960E82D81E41AFE0D57E", hash_generated_method = "E3E044B7BF2B6F84364786AA0DDF3BC7")
    static boolean
    isServiceCodeCallBarring(String sc) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.287 -0500", hash_original_method = "4485119A2DB806ECBE33AB8A65DBB159", hash_generated_method = "3D186E5804FDA20E149F46FD9E44957F")
    static String
    scToBarringFacility(String sc) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.294 -0500", hash_original_method = "2143E40C80F989FD6F6995F18C601DFB", hash_generated_method = "E2E8C9E657A68C732E9D6E365E184FC8")
    static private boolean
    isTwoDigitShortCode(Context context, String dialString) {
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

    /**
     * Helper function for newFromDialString. Returns true if dialString appears
     * to be a short code AND conditions are correct for it to be treated as
     * such.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.295 -0500", hash_original_method = "7C078FD6C37638384F8322CDEBAF3CFB", hash_generated_method = "08075CE8CD7971BB2DB7E904E4F83711")
    static private boolean isShortCode(String dialString, GSMPhone phone) {
        // Refer to TS 22.030 Figure 3.5.3.2:
        if (dialString == null) {
            return false;
        }

        // Illegal dial string characters will give a ZERO length.
        // At this point we do not want to crash as any application with
        // call privileges may send a non dial string.
        // It return false as when the dialString is equal to NULL.
        if (dialString.length() == 0) {
            return false;
        }

        if (PhoneNumberUtils.isLocalEmergencyNumber(dialString, phone.getContext())) {
            return false;
        } else {
            return isShortCodeUSSD(dialString, phone);
        }
    }

    /**
     * Helper function for isShortCode. Returns true if dialString appears to be
     * a short code and it is a USSD structure
     *
     * According to the 3PGG TS 22.030 specification Figure 3.5.3.2: A 1 or 2
     * digit "short code" is treated as USSD if it is entered while on a call or
     * does not satisfy the condition (exactly 2 digits && starts with '1'), there
     * are however exceptions to this rule (see below)
     *
     * Exception (1) to Call initiation is: If the user of the device is already in a call
     * and enters a Short String without any #-key at the end and the length of the Short String is
     * equal or less then the MAX_LENGTH_SHORT_CODE [constant that is equal to 2]
     *
     * The phone shall initiate a USSD/SS commands.
     *
     * Exception (2) to Call initiation is: If the user of the device enters one
     * Digit followed by the #-key. This rule defines this String as the
     * #-String which is a USSD/SS command.
     *
     * The phone shall initiate a USSD/SS command.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.296 -0500", hash_original_method = "B3A89783274A7AC251D385A3D94E9779", hash_generated_method = "2DF5B9E59D09FF1236C5A7118EDA6FF2")
    static private boolean isShortCodeUSSD(String dialString, GSMPhone phone) {
        if (dialString != null) {
            if (phone.isInCall()) {
                // The maximum length of a Short Code (aka Short String) is 2
                if (dialString.length() <= MAX_LENGTH_SHORT_CODE) {
                    return true;
                }
            }

            // The maximum length of a Short Code (aka Short String) is 2
            if (dialString.length() <= MAX_LENGTH_SHORT_CODE) {
                if (dialString.charAt(dialString.length() - 1) == END_OF_USSD_COMMAND) {
                    return true;
                }
            }
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.231 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.232 -0500", hash_original_field = "387E66CAC1433A4CC248AE5093674573", hash_generated_field = "CD257D5D924AB184D1C0DDA10D6CB542")


    // Max Size of the Short Code (aka Short String from TS 22.030 6.5.2)
    static final int MAX_LENGTH_SHORT_CODE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.232 -0500", hash_original_field = "5EC657818EA4AC9F301C143FF601487F", hash_generated_field = "0C36A7337276036614EF5E0CA17164B6")

    // (known as #-String)
    static final char END_OF_USSD_COMMAND = '#';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.233 -0500", hash_original_field = "641B8014452EC0715E1DE888641CCEDD", hash_generated_field = "18F682957DD333F418DC1E51CABE0145")

    static final String ACTION_ACTIVATE = "*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.234 -0500", hash_original_field = "2BAF0FA5912D4E8BD37845CDC7E91AB0", hash_generated_field = "E3284E18102DE7D7C6F38C074B8DCE9F")

    static final String ACTION_DEACTIVATE = "#";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.235 -0500", hash_original_field = "86C40878EF9FC5D9231B844EEE70D81C", hash_generated_field = "D264585CD251BCD3ABEAC4C7825F93F9")

    static final String ACTION_INTERROGATE = "*#";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.236 -0500", hash_original_field = "508EDED9B330FEB251BB9AFD01FC4828", hash_generated_field = "A747A2BA07E0220107EEBEA1B6706D02")

    static final String ACTION_REGISTER = "**";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.236 -0500", hash_original_field = "241C0C650FF9023C89967F0AD49AE9B7", hash_generated_field = "32CD02DE89D027BB80525CC133B872CA")

    static final String ACTION_ERASURE = "##";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.237 -0500", hash_original_field = "C426B7759EE9F55423F727A1FFAA1002", hash_generated_field = "91D50570B5A7B080C473D2A0C4A496C9")


    //Called line presentation
    static final String SC_CLIP    = "30";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.238 -0500", hash_original_field = "B86FCA89322683298DF59970D5E4D321", hash_generated_field = "E644B736CD2A9C2179B5ADA66B2BD371")

    static final String SC_CLIR    = "31";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.238 -0500", hash_original_field = "A5AC15DF6C544F3C920F303C1B16F8CC", hash_generated_field = "A0A984619995E559906729FB0885BD37")

    static final String SC_CFU     = "21";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.239 -0500", hash_original_field = "92D43903F9956CBD2496380DE948FBDE", hash_generated_field = "162AB085207CEB2C27F8FDC8BF9ECDF2")

    static final String SC_CFB     = "67";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.240 -0500", hash_original_field = "B64F6363A363513B6A278DABC0165C8D", hash_generated_field = "188B5492DB9239773311815652D08E1E")

    static final String SC_CFNRy   = "61";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.241 -0500", hash_original_field = "E6F44E8DD463F9ABABAAE1DF54A0934D", hash_generated_field = "970B94E83FA60DC84055EBAC72BEA6A7")

    static final String SC_CFNR    = "62";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.242 -0500", hash_original_field = "FF7497471F1B5A557C4C19DD9E2245DC", hash_generated_field = "AAACA7CABEBB58D4DBEDA093B2CDF4C5")


    static final String SC_CF_All = "002";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.242 -0500", hash_original_field = "C74998AAED687220B9385B5E68CC3412", hash_generated_field = "E97209C1CAD929CA0DC97B53BB34B72F")

    static final String SC_CF_All_Conditional = "004";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.243 -0500", hash_original_field = "75E40F8FDBDD6AD289667C8CFDE8D699", hash_generated_field = "7E42427065171F529F659EBE79102742")

    static final String SC_WAIT     = "43";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.244 -0500", hash_original_field = "897B24EBABDD0F76EBB3155FEC3E2D2B", hash_generated_field = "EB539ECDFB664D7B6F97071235485A9F")

    static final String SC_BAOC         = "33";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.245 -0500", hash_original_field = "C2D6C8F321EF9A9CB95226F3A5EC2F69", hash_generated_field = "E42D4E647E8ACC2C103C2935E6E0CE74")

    static final String SC_BAOIC        = "331";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.246 -0500", hash_original_field = "E76B969C5AA762FADAF6AA5C719ED3CF", hash_generated_field = "91A59766F8A5C17F073F097729110BA1")

    static final String SC_BAOICxH      = "332";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.247 -0500", hash_original_field = "D244BA9D5BC95CDC5759A4D35ECF7E66", hash_generated_field = "8A5B8B89DDC698F51EFD8240BA01409D")

    static final String SC_BAIC         = "35";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.248 -0500", hash_original_field = "AE8A5B2C19F9FEA95B0F4635B85FCEF5", hash_generated_field = "481173BEDB5B2B2B9B6107CCDD3C1DFB")

    static final String SC_BAICr        = "351";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.248 -0500", hash_original_field = "F314116652F12F4B6221B71A81DF7815", hash_generated_field = "2118AEBDF2A411624DDAA38436B55831")


    static final String SC_BA_ALL       = "330";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.249 -0500", hash_original_field = "058A0029485C4CC97F1C0932DE814BDE", hash_generated_field = "78090C0D99EB492E8EA3B970D8545B61")

    static final String SC_BA_MO        = "333";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.250 -0500", hash_original_field = "B677F32C036ACE7250AFF4FFE2E75B19", hash_generated_field = "D87B853EA32848746BBA1779B8A2EE68")

    static final String SC_BA_MT        = "353";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.251 -0500", hash_original_field = "3D22E65CF603F8F06DEAAA6D416EE985", hash_generated_field = "67CCC016F241E1D4CFD0A5CE5C530D23")

    static final String SC_PWD          = "03";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.252 -0500", hash_original_field = "1455A4C01AE39063F10489A9DA3EF617", hash_generated_field = "EEE3024D1CF5D84AF8F4CB01077B8E95")

    static final String SC_PIN          = "04";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.252 -0500", hash_original_field = "F81AD2D6A903169C88ABC20B28D8E3DB", hash_generated_field = "7A8798943D2B724D80E98EC6B7CB93B6")

    static final String SC_PIN2         = "042";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.253 -0500", hash_original_field = "A5BE53B19A33B16E1807824A89B907AF", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK          = "05";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.254 -0500", hash_original_field = "AB8A24AE3FF007DA51AAB7592A8F2878", hash_generated_field = "B746ACB42145A31CD109C60F14BFE667")

    static final String SC_PUK2         = "052";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.255 -0500", hash_original_field = "EAC576E559D59F0C7D0950B0EFCE6458", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")


    static final int EVENT_SET_COMPLETE         = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.256 -0500", hash_original_field = "E003AE4E424E78C273CC71EA849159FA", hash_generated_field = "9829C51898ECEEF688DC24D5C6D88094")

    static final int EVENT_GET_CLIR_COMPLETE    = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.256 -0500", hash_original_field = "BB8784120CA22534DD3A78C36A36A4BC", hash_generated_field = "7AFF40CB3CEB21DFC3DD957EE7B8EBBC")

    static final int EVENT_QUERY_CF_COMPLETE    = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.257 -0500", hash_original_field = "AAD0C7C6F7ED93D5A9F1DC9036B7D3CB", hash_generated_field = "D739A36AE28735AFC84C598B959E4F6E")

    static final int EVENT_USSD_COMPLETE        = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.258 -0500", hash_original_field = "780B6D1227A23947ED4C7CFE80C01259", hash_generated_field = "72ABCFECA11B8C5650C5459A9D911C41")

    static final int EVENT_QUERY_COMPLETE       = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.259 -0500", hash_original_field = "97775180DBAC0367C42DC2030DC51919", hash_generated_field = "D47F75990E603624F182DA469CF653E4")

    static final int EVENT_SET_CFF_COMPLETE     = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.260 -0500", hash_original_field = "8C38E5FF337C52530C46E530A01DD757", hash_generated_field = "1A3F2D11BE99F10E9049869D455AA7BC")

    static final int EVENT_USSD_CANCEL_COMPLETE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.269 -0500", hash_original_field = "28E607B4DA054BDAA834BD0FF0CEFF04", hash_generated_field = "A4C35E6D22BA5C03878070B5B0777BAC")



    // See TS 22.030 6.5.2 "Structure of the MMI"

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)([^#]*)");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.270 -0500", hash_original_field = "B70DD7A805C09DAF4B85DF3F2AA1E1D2", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")


    static final int MATCH_GROUP_POUND_STRING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.271 -0500", hash_original_field = "3A1ADB951719F3F4638A18B5533A24F9", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")


    static final int MATCH_GROUP_ACTION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.272 -0500", hash_original_field = "60DFF95A3FBFA52E5839032FA5DAE64A", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")


    static final int MATCH_GROUP_SERVICE_CODE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.272 -0500", hash_original_field = "EC2B3FF25577BFAE4A7B9A3F0F49F4FE", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.273 -0500", hash_original_field = "2799B5FF8FF9569940BCDE317ED8FCE7", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.274 -0500", hash_original_field = "A4A50B05D3EB1967EB1A68ADBA889CAF", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.275 -0500", hash_original_field = "543F51CD9008EAB9A82A82F8EE24DDF0", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.276 -0500", hash_original_field = "51D74AE56D031EF54174D999E1A2AD8E", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.277 -0500", hash_original_field = "ADF375A1971A318C9C035BAFB43159A1", hash_generated_field = "55E2DF2087007B0F74B525D8CFC27B5F")

    static private String[] sTwoDigitNumberPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.260 -0500", hash_original_field = "690DC9441FA6BD04E0472B4DF9E035F8", hash_generated_field = "690DC9441FA6BD04E0472B4DF9E035F8")


    GSMPhone phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.261 -0500", hash_original_field = "571FE4403DDA9BF54693EBF4F0D6639D", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.262 -0500", hash_original_field = "F0D53334D1D58D4E79746838A9C851E9", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")


    String action;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.263 -0500", hash_original_field = "1F12170F3EB5D5C8E81971C7E7A70DEB", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:24.960 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.264 -0500", hash_original_field = "BB2724DBDDFCC035B982DADDB95A1B73", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.265 -0500", hash_original_field = "8E3BE840A192C669D20F33CA83223066", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.266 -0500", hash_original_field = "389FC73FC9600F29B99C9C32C4AF72ED", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.266 -0500", hash_original_field = "496E26F99587CBF2F8FF7AB1D21C3B65", hash_generated_field = "FD36BB7FA9FBFFEC127B7CBE3DF124C1")


    /** Set to true in processCode, not at newFromDialString time */
    private boolean isPendingUSSD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.267 -0500", hash_original_field = "73DC0F18CBA621540B9C94D28696A483", hash_generated_field = "A601B09474CCCD19D7EF905D10ED4B31")


    private boolean isUssdRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.268 -0500", hash_original_field = "1C260AF567CCE39E2DADC6C6A5D564F0", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")


    State state = State.PENDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.268 -0500", hash_original_field = "422FD4BFD34A850AED895188AD7E511B", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;

    //***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.288 -0500", hash_original_method = "1F245899EC025E108E5BE08C8380C5BD", hash_generated_method = "E4C34B655AA5B88E581DE0A82EE2B6F8")
    GsmMmiCode (GSMPhone phone) {
        // The telephony unit-test cases may create GsmMmiCode's
        // in secondary threads
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
    }

    //***** MmiCode implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.288 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    public State
    getState() {
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.290 -0500", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "5CEF4B02F22CFEE27A7F9878596252B0")
    public CharSequence
    getMessage() {
        return message;
    }

    // inherited javadoc suffices
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.291 -0500", hash_original_method = "E883165C6689A3782C7AFFDB1FCF97C2", hash_generated_method = "B32FA2E6CF549D583F9ED41EFB83034D")
    public void
    cancel() {
        // Complete or failed cannot be cancelled
        if (state == State.COMPLETE || state == State.FAILED) {
            return;
        }

        state = State.CANCELLED;

        if (isPendingUSSD) {
            /*
             * There can only be one pending USSD session, so tell the radio to
             * cancel it.
             */
            phone.mCM.cancelPendingUssd(obtainMessage(EVENT_USSD_CANCEL_COMPLETE, this));

            /*
             * Don't call phone.onMMIDone here; wait for CANCEL_COMPLETE notice
             * from RIL.
             */
        } else {
            // TODO in cases other than USSD, it would be nice to cancel
            // the pending radio operation. This requires RIL cancellation
            // support, which does not presently exist.

            phone.onMMIDone (this);
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.291 -0500", hash_original_method = "248235E8DF3E05BA5583B3AF86C41C77", hash_generated_method = "170F3390CAF277892E32FE45958455A8")
    public boolean isCancelable() {
        /* Can only cancel pending USSD sessions. */
        return isPendingUSSD;
    }

    //***** Instance Methods

    /** Does this dial string contain a structured or unstructured MMI code? */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.292 -0500", hash_original_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C", hash_generated_method = "C3EFABB6ACCE73BCC8BAFC802C5DCA3C")
    boolean
    isMMI() {
        return poundString != null;
    }

    /* Is this a 1 or 2 digit "short code" as defined in TS 22.030 sec 6.5.3.2? */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.293 -0500", hash_original_method = "C27864618833FAFE773E7DA58094B237", hash_generated_method = "C27864618833FAFE773E7DA58094B237")
    boolean
    isShortCode() {
        return poundString == null
                    && dialingNumber != null && dialingNumber.length() <= 2;

    }

    /**
     * @return true if the Service Code is PIN/PIN2/PUK/PUK2-related
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.296 -0500", hash_original_method = "59EBB8632489E0E4FC2DAAE2E73A576E", hash_generated_method = "59EBB8632489E0E4FC2DAAE2E73A576E")
    boolean isPinCommand() {
        return sc != null && (sc.equals(SC_PIN) || sc.equals(SC_PIN2)
                              || sc.equals(SC_PUK) || sc.equals(SC_PUK2));
     }

    /**
     * See TS 22.030 Annex B.
     * In temporary mode, to suppress CLIR for a single call, enter:
     *      " * 31 # [called number] SEND "
     *  In temporary mode, to invoke CLIR for a single call enter:
     *       " # 31 # [called number] SEND "
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.297 -0500", hash_original_method = "38FEBB881BBF680269ABAA58BA7CAEF9", hash_generated_method = "38FEBB881BBF680269ABAA58BA7CAEF9")
    boolean
    isTemporaryModeCLIR() {
        return sc != null && sc.equals(SC_CLIR) && dialingNumber != null
                && (isActivate() || isDeactivate());
    }

    /**
     * returns CommandsInterface.CLIR_*
     * See also isTemporaryModeCLIR()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.298 -0500", hash_original_method = "29290542493AE0E5F1628242CAC04AE5", hash_generated_method = "29290542493AE0E5F1628242CAC04AE5")
    int
    getCLIRMode() {
        if (sc != null && sc.equals(SC_CLIR)) {
            if (isActivate()) {
                return CommandsInterface.CLIR_SUPPRESSION;
            } else if (isDeactivate()) {
                return CommandsInterface.CLIR_INVOCATION;
            }
        }

        return CommandsInterface.CLIR_DEFAULT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.299 -0500", hash_original_method = "68E2406D480606BAD5624672FC8435A4", hash_generated_method = "68E2406D480606BAD5624672FC8435A4")
    boolean isActivate() {
        return action != null && action.equals(ACTION_ACTIVATE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.299 -0500", hash_original_method = "83961E295B5FE9A8E52B830AEEEC29A1", hash_generated_method = "83961E295B5FE9A8E52B830AEEEC29A1")
    boolean isDeactivate() {
        return action != null && action.equals(ACTION_DEACTIVATE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.300 -0500", hash_original_method = "E588DEB258357C4BFC7DA2575588FA46", hash_generated_method = "E588DEB258357C4BFC7DA2575588FA46")
    boolean isInterrogate() {
        return action != null && action.equals(ACTION_INTERROGATE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.301 -0500", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "CA7357DC4342746EF1FE3C742A9E7FC8")
    boolean isRegister() {
        return action != null && action.equals(ACTION_REGISTER);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.302 -0500", hash_original_method = "BEEEFB61222182AD97B0B2576158AC2D", hash_generated_method = "BEEEFB61222182AD97B0B2576158AC2D")
    boolean isErasure() {
        return action != null && action.equals(ACTION_ERASURE);
    }

    /**
     * Returns true if this is a USSD code that's been submitted to the
     * network...eg, after processCode() is called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.302 -0500", hash_original_method = "18A8B0A5C57D2FDE667C353F321E4EE3", hash_generated_method = "91E7C04675C1665D2072E8C650ADA4D1")
    public boolean isPendingUSSD() {
        return isPendingUSSD;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.303 -0500", hash_original_method = "29AF801768BF493864C8071B1DB2A48B", hash_generated_method = "7A2A1E0E202CE0FB5A4ACCE18AEBC96E")
    public boolean isUssdRequest() {
        return isUssdRequest;
    }

    /** Process a MMI code or short code...anything that isn't a dialing number */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.306 -0500", hash_original_method = "889EE3022DF864BE1DEDCF5E80AD4B15", hash_generated_method = "A50B455E9322BBD2149A22537B8DDF3E")
    void
    processCode () {
        try {
            if (isShortCode()) {
                Log.d(LOG_TAG, "isShortCode");
                // These just get treated as USSD.
                sendUssd(dialingNumber);
            } else if (dialingNumber != null) {
                // We should have no dialing numbers here
                throw new RuntimeException ("Invalid or Unsupported MMI Code");
            } else if (sc != null && sc.equals(SC_CLIP)) {
                Log.d(LOG_TAG, "is CLIP");
                if (isInterrogate()) {
                    phone.mCM.queryCLIP(
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }
            } else if (sc != null && sc.equals(SC_CLIR)) {
                Log.d(LOG_TAG, "is CLIR");
                if (isActivate()) {
                    phone.mCM.setCLIR(CommandsInterface.CLIR_INVOCATION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                } else if (isDeactivate()) {
                    phone.mCM.setCLIR(CommandsInterface.CLIR_SUPPRESSION,
                        obtainMessage(EVENT_SET_COMPLETE, this));
                } else if (isInterrogate()) {
                    phone.mCM.getCLIR(
                        obtainMessage(EVENT_GET_CLIR_COMPLETE, this));
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }
            } else if (isServiceCodeCallForwarding(sc)) {
                Log.d(LOG_TAG, "is CF");

                String dialingNumber = sia;
                int serviceClass = siToServiceClass(sib);
                int reason = scToCallForwardReason(sc);
                int time = siToTime(sic);

                if (isInterrogate()) {
                    phone.mCM.queryCallForwardStatus(
                            reason, serviceClass,  dialingNumber,
                                obtainMessage(EVENT_QUERY_CF_COMPLETE, this));
                } else {
                    int cfAction;

                    if (isActivate()) {
                        cfAction = CommandsInterface.CF_ACTION_ENABLE;
                    } else if (isDeactivate()) {
                        cfAction = CommandsInterface.CF_ACTION_DISABLE;
                    } else if (isRegister()) {
                        cfAction = CommandsInterface.CF_ACTION_REGISTRATION;
                    } else if (isErasure()) {
                        cfAction = CommandsInterface.CF_ACTION_ERASURE;
                    } else {
                        throw new RuntimeException ("invalid action");
                    }

                    int isSettingUnconditionalVoice =
                        (((reason == CommandsInterface.CF_REASON_UNCONDITIONAL) ||
                                (reason == CommandsInterface.CF_REASON_ALL)) &&
                                (((serviceClass & CommandsInterface.SERVICE_CLASS_VOICE) != 0) ||
                                 (serviceClass == CommandsInterface.SERVICE_CLASS_NONE))) ? 1 : 0;

                    int isEnableDesired =
                        ((cfAction == CommandsInterface.CF_ACTION_ENABLE) ||
                                (cfAction == CommandsInterface.CF_ACTION_REGISTRATION)) ? 1 : 0;

                    Log.d(LOG_TAG, "is CF setCallForward");
                    phone.mCM.setCallForward(cfAction, reason, serviceClass,
                            dialingNumber, time, obtainMessage(
                                    EVENT_SET_CFF_COMPLETE,
                                    isSettingUnconditionalVoice,
                                    isEnableDesired, this));
                }
            } else if (isServiceCodeCallBarring(sc)) {
                // sia = password
                // sib = basic service group

                String password = sia;
                int serviceClass = siToServiceClass(sib);
                String facility = scToBarringFacility(sc);

                if (isInterrogate()) {
                    phone.mCM.queryFacilityLock(facility, password,
                            serviceClass, obtainMessage(EVENT_QUERY_COMPLETE, this));
                } else if (isActivate() || isDeactivate()) {
                    phone.mCM.setFacilityLock(facility, isActivate(), password,
                            serviceClass, obtainMessage(EVENT_SET_COMPLETE, this));
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }

            } else if (sc != null && sc.equals(SC_PWD)) {
                // sia = fac
                // sib = old pwd
                // sic = new pwd
                // pwd = new pwd
                String facility;
                String oldPwd = sib;
                String newPwd = sic;
                if (isActivate() || isRegister()) {
                    // Even though ACTIVATE is acceptable, this is really termed a REGISTER
                    action = ACTION_REGISTER;

                    if (sia == null) {
                        // If sc was not specified, treat it as BA_ALL.
                        facility = CommandsInterface.CB_FACILITY_BA_ALL;
                    } else {
                        facility = scToBarringFacility(sia);
                    }
                    if (newPwd.equals(pwd)) {
                        phone.mCM.changeBarringPassword(facility, oldPwd,
                                newPwd, obtainMessage(EVENT_SET_COMPLETE, this));
                    } else {
                        // password mismatch; return error
                        handlePasswordError(com.android.internal.R.string.passwordIncorrect);
                    }
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }

            } else if (sc != null && sc.equals(SC_WAIT)) {
                // sia = basic service group
                int serviceClass = siToServiceClass(sia);

                if (isActivate() || isDeactivate()) {
                    phone.mCM.setCallWaiting(isActivate(), serviceClass,
                            obtainMessage(EVENT_SET_COMPLETE, this));
                } else if (isInterrogate()) {
                    phone.mCM.queryCallWaiting(serviceClass,
                            obtainMessage(EVENT_QUERY_COMPLETE, this));
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }
            } else if (isPinCommand()) {
                // sia = old PIN or PUK
                // sib = new PIN
                // sic = new PIN
                String oldPinOrPuk = sia;
                String newPin = sib;
                int pinLen = newPin.length();
                if (isRegister()) {
                    if (!newPin.equals(sic)) {
                        // password mismatch; return error
                        handlePasswordError(com.android.internal.R.string.mismatchPin);
                    } else if (pinLen < 4 || pinLen > 8 ) {
                        // invalid length
                        handlePasswordError(com.android.internal.R.string.invalidPin);
                    } else if (sc.equals(SC_PIN) &&
                               phone.mIccCard.getState() == SimCard.State.PUK_REQUIRED ) {
                        // Sim is puk-locked
                        handlePasswordError(com.android.internal.R.string.needPuk);
                    } else {
                        // pre-checks OK
                        if (sc.equals(SC_PIN)) {
                            phone.mCM.changeIccPin(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } else if (sc.equals(SC_PIN2)) {
                            phone.mCM.changeIccPin2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } else if (sc.equals(SC_PUK)) {
                            phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        } else if (sc.equals(SC_PUK2)) {
                            phone.mCM.supplyIccPuk2(oldPinOrPuk, newPin,
                                    obtainMessage(EVENT_SET_COMPLETE, this));
                        }
                    }
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }
            } else if (poundString != null) {
                sendUssd(poundString);
            } else {
                throw new RuntimeException ("Invalid or Unsupported MMI Code");
            }
        } catch (RuntimeException exc) {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.307 -0500", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "6899933A4B68D0B99E8CE0B6EB2588C0")
    private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
    }

    /**
     * Called from GSMPhone
     *
     * An unsolicited USSD NOTIFY or REQUEST has come in matching
     * up with this pending USSD request
     *
     * Note: If REQUEST, this exchange is complete, but the session remains
     *       active (ie, the network expects user input).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.308 -0500", hash_original_method = "A7DAC75B31530E6CD4845B1030678B66", hash_generated_method = "9B207B429FF314BC173047239A3E4983")
    void
    onUssdFinished(String ussdMessage, boolean isUssdRequest) {
        if (state == State.PENDING) {
            if (ussdMessage == null) {
                message = context.getText(com.android.internal.R.string.mmiComplete);
            } else {
                message = ussdMessage;
            }
            this.isUssdRequest = isUssdRequest;
            // If it's a request, leave it PENDING so that it's cancelable.
            if (!isUssdRequest) {
                state = State.COMPLETE;
            }

            phone.onMMIDone(this);
        }
    }

    /**
     * Called from GSMPhone
     *
     * The radio has reset, and this is still pending
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.309 -0500", hash_original_method = "6CB35EDB68C77D37EFB134F2D3B374DA", hash_generated_method = "6CB35EDB68C77D37EFB134F2D3B374DA")
    void
    onUssdFinishedError() {
        if (state == State.PENDING) {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);

            phone.onMMIDone(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.310 -0500", hash_original_method = "91A2759A8D20AD291EA9305932FA3032", hash_generated_method = "E5DC71336FFD98159B30588C53B82F38")
    void sendUssd(String ussdMessage) {
        // Treat this as a USSD string
        isPendingUSSD = true;

        // Note that unlike most everything else, the USSD complete
        // response does not complete this MMI code...we wait for
        // an unsolicited USSD "Notify" or "Request".
        // The matching up of this is done in GSMPhone.

        phone.mCM.sendUSSD(ussdMessage,
            obtainMessage(EVENT_USSD_COMPLETE, this));
    }

    /** Called from GSMPhone.handleMessage; not a Handler subclass */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.311 -0500", hash_original_method = "5C6BF8BFD3AA6C53F0FB54F2701C6A7B", hash_generated_method = "88312878C1FA4C538B0BDCFF79C890AD")
    public void
    handleMessage (Message msg) {
        AsyncResult ar;

        switch (msg.what) {
            case EVENT_SET_COMPLETE:
                ar = (AsyncResult) (msg.obj);

                onSetComplete(ar);
                break;

            case EVENT_SET_CFF_COMPLETE:
                ar = (AsyncResult) (msg.obj);

                /*
                * msg.arg1 = 1 means to set unconditional voice call forwarding
                * msg.arg2 = 1 means to enable voice call forwarding
                */
                if ((ar.exception == null) && (msg.arg1 == 1)) {
                    boolean cffEnabled = (msg.arg2 == 1);
                    phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
                }

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

                if (ar.exception != null) {
                    state = State.FAILED;
                    message = getErrorMessage(ar);

                    phone.onMMIDone(this);
                }

                // Note that unlike most everything else, the USSD complete
                // response does not complete this MMI code...we wait for
                // an unsolicited USSD "Notify" or "Request".
                // The matching up of this is done in GSMPhone.

            break;

            case EVENT_USSD_CANCEL_COMPLETE:
                phone.onMMIDone(this);
            break;
        }
    }
    //***** Private instance methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.312 -0500", hash_original_method = "6FA8450E92822795C4AD46C68EFB0477", hash_generated_method = "D8A369482CE656CCBA9516D025A5576B")
    private CharSequence getErrorMessage(AsyncResult ar) {

        if (ar.exception instanceof CommandException) {
            CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
            if (err == CommandException.Error.FDN_CHECK_FAILURE) {
                Log.i(LOG_TAG, "FDN_CHECK_FAILURE");
                return context.getText(com.android.internal.R.string.mmiFdnError);
            }
        }

        return context.getText(com.android.internal.R.string.mmiError);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.313 -0500", hash_original_method = "F062B7C9E966AA410521C905675EBDA7", hash_generated_method = "8435AB4A680772890DF4C5A672ACCB9A")
    private CharSequence getScString() {
        if (sc != null) {
            if (isServiceCodeCallBarring(sc)) {
                return context.getText(com.android.internal.R.string.BaMmi);
            } else if (isServiceCodeCallForwarding(sc)) {
                return context.getText(com.android.internal.R.string.CfMmi);
            } else if (sc.equals(SC_CLIP)) {
                return context.getText(com.android.internal.R.string.ClipMmi);
            } else if (sc.equals(SC_CLIR)) {
                return context.getText(com.android.internal.R.string.ClirMmi);
            } else if (sc.equals(SC_PWD)) {
                return context.getText(com.android.internal.R.string.PwdMmi);
            } else if (sc.equals(SC_WAIT)) {
                return context.getText(com.android.internal.R.string.CwMmi);
            } else if (isPinCommand()) {
                return context.getText(com.android.internal.R.string.PinMmi);
            }
        }

        return "";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.314 -0500", hash_original_method = "86E59952328AB1858ED821151A4A3DAE", hash_generated_method = "C5D5F9A9961679E095671E544B95BAFE")
    private void
    onSetComplete(AsyncResult ar){
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");

        if (ar.exception != null) {
            state = State.FAILED;
            if (ar.exception instanceof CommandException) {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
                if (err == CommandException.Error.PASSWORD_INCORRECT) {
                    if (isPinCommand()) {
                        // look specifically for the PUK commands and adjust
                        // the message accordingly.
                        if (sc.equals(SC_PUK) || sc.equals(SC_PUK2)) {
                            sb.append(context.getText(
                                    com.android.internal.R.string.badPuk));
                        } else {
                            sb.append(context.getText(
                                    com.android.internal.R.string.badPin));
                        }
                    } else {
                        sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                    }
                } else if (err == CommandException.Error.SIM_PUK2) {
                    sb.append(context.getText(
                            com.android.internal.R.string.badPin));
                    sb.append("\n");
                    sb.append(context.getText(
                            com.android.internal.R.string.needPuk2));
                } else if (err == CommandException.Error.FDN_CHECK_FAILURE) {
                    Log.i(LOG_TAG, "FDN_CHECK_FAILURE");
                    sb.append(context.getText(com.android.internal.R.string.mmiFdnError));
                } else {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                }
            } else {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            }
        } else if (isActivate()) {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceEnabled));
            // Record CLIR setting
            if (sc.equals(SC_CLIR)) {
                phone.saveClirSetting(CommandsInterface.CLIR_INVOCATION);
            }
        } else if (isDeactivate()) {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceDisabled));
            // Record CLIR setting
            if (sc.equals(SC_CLIR)) {
                phone.saveClirSetting(CommandsInterface.CLIR_SUPPRESSION);
            }
        } else if (isRegister()) {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
        } else if (isErasure()) {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceErased));
        } else {
            state = State.FAILED;
            sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
        }

        message = sb;
        phone.onMMIDone(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.316 -0500", hash_original_method = "E00F9D791A3B8B3DD19100E46A3BBC7E", hash_generated_method = "5F8D19ECC29AB15AE09C3EB8D5C341AE")
    private void
    onGetClirComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");

        if (ar.exception != null) {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } else {
            int clirArgs[];

            clirArgs = (int[])ar.result;

            // the 'm' parameter from TS 27.007 7.7
            switch (clirArgs[1]) {
                case 0: // CLIR not provisioned
                    sb.append(context.getText(
                                com.android.internal.R.string.serviceNotProvisioned));
                    state = State.COMPLETE;
                break;

                case 1: // CLIR provisioned in permanent mode
                    sb.append(context.getText(
                                com.android.internal.R.string.CLIRPermanent));
                    state = State.COMPLETE;
                break;

                case 2: // unknown (e.g. no network, etc.)
                    sb.append(context.getText(
                                com.android.internal.R.string.mmiError));
                    state = State.FAILED;
                break;

                case 3: // CLIR temporary mode presentation restricted

                    // the 'n' parameter from TS 27.007 7.7
                    switch (clirArgs[0]) {
                        default:
                        case 0: // Default
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
                        break;
                        case 1: // CLIR invocation
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOn));
                        break;
                        case 2: // CLIR suppression
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOnNextCallOff));
                        break;
                    }
                    state = State.COMPLETE;
                break;

                case 4: // CLIR temporary mode presentation allowed
                    // the 'n' parameter from TS 27.007 7.7
                    switch (clirArgs[0]) {
                        default:
                        case 0: // Default
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
                        break;
                        case 1: // CLIR invocation
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOn));
                        break;
                        case 2: // CLIR suppression
                            sb.append(context.getText(
                                    com.android.internal.R.string.CLIRDefaultOffNextCallOff));
                        break;
                    }

                    state = State.COMPLETE;
                break;
            }
        }

        message = sb;
        phone.onMMIDone(this);
    }

    /**
     * @param serviceClass 1 bit of the service class bit vectory
     * @return String to be used for call forward query MMI response text.
     *        Returns null if unrecognized
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.317 -0500", hash_original_method = "8B6CA3810AD4ECA237178B5B4043C8E2", hash_generated_method = "235901CF7FB95C93A25BCBD859C37F3E")
    private CharSequence
    serviceClassToCFString (int serviceClass) {
        switch (serviceClass) {
            case SERVICE_CLASS_VOICE:
                return context.getText(com.android.internal.R.string.serviceClassVoice);
            case SERVICE_CLASS_DATA:
                return context.getText(com.android.internal.R.string.serviceClassData);
            case SERVICE_CLASS_FAX:
                return context.getText(com.android.internal.R.string.serviceClassFAX);
            case SERVICE_CLASS_SMS:
                return context.getText(com.android.internal.R.string.serviceClassSMS);
            case SERVICE_CLASS_DATA_SYNC:
                return context.getText(com.android.internal.R.string.serviceClassDataSync);
            case SERVICE_CLASS_DATA_ASYNC:
                return context.getText(com.android.internal.R.string.serviceClassDataAsync);
            case SERVICE_CLASS_PACKET:
                return context.getText(com.android.internal.R.string.serviceClassPacket);
            case SERVICE_CLASS_PAD:
                return context.getText(com.android.internal.R.string.serviceClassPAD);
            default:
                return null;
        }
    }


    /** one CallForwardInfo + serviceClassMask -> one line of text */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.318 -0500", hash_original_method = "ECAE8AA4EBDE1134552CC635B1F3D0F6", hash_generated_method = "E0291B4EB05BB6C8E09669CB5621340B")
    private CharSequence
    makeCFQueryResultMessage(CallForwardInfo info, int serviceClassMask) {
        CharSequence template;
        String sources[] = {"{0}", "{1}", "{2}"};
        CharSequence destinations[] = new CharSequence[3];
        boolean needTimeTemplate;

        // CF_REASON_NO_REPLY also has a time value associated with
        // it. All others don't.

        needTimeTemplate =
            (info.reason == CommandsInterface.CF_REASON_NO_REPLY);

        if (info.status == 1) {
            if (needTimeTemplate) {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwardedTime);
            } else {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateForwarded);
            }
        } else if (info.status == 0 && isEmptyOrNull(info.number)) {
            template = context.getText(
                        com.android.internal.R.string.cfTemplateNotForwarded);
        } else { /* (info.status == 0) && !isEmptyOrNull(info.number) */
            // A call forward record that is not active but contains
            // a phone number is considered "registered"

            if (needTimeTemplate) {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateRegisteredTime);
            } else {
                template = context.getText(
                        com.android.internal.R.string.cfTemplateRegistered);
            }
        }

        // In the template (from strings.xmls)
        //         {0} is one of "bearerServiceCode*"
        //        {1} is dialing number
        //      {2} is time in seconds

        destinations[0] = serviceClassToCFString(info.serviceClass & serviceClassMask);
        destinations[1] = PhoneNumberUtils.stringFromStringAndTOA(info.number, info.toa);
        destinations[2] = Integer.toString(info.timeSeconds);

        if (info.reason == CommandsInterface.CF_REASON_UNCONDITIONAL &&
                (info.serviceClass & serviceClassMask)
                        == CommandsInterface.SERVICE_CLASS_VOICE) {
            boolean cffEnabled = (info.status == 1);
            phone.mIccRecords.setVoiceCallForwardingFlag(1, cffEnabled);
        }

        return TextUtils.replace(template, sources, destinations);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.319 -0500", hash_original_method = "5082D13BAC647DFAEF8F3236E64BC951", hash_generated_method = "A27594460A6FCEB5A9A6650E3CFE7B6D")
    private void
    onQueryCfComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");

        if (ar.exception != null) {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } else {
            CallForwardInfo infos[];

            infos = (CallForwardInfo[]) ar.result;

            if (infos.length == 0) {
                // Assume the default is not active
                sb.append(context.getText(com.android.internal.R.string.serviceDisabled));

                // Set unconditional CFF in SIM to false
                phone.mIccRecords.setVoiceCallForwardingFlag(1, false);
            } else {

                SpannableStringBuilder tb = new SpannableStringBuilder();

                // Each bit in the service class gets its own result line
                // The service classes may be split up over multiple
                // CallForwardInfos. So, for each service class, find out
                // which CallForwardInfo represents it and then build
                // the response text based on that

                for (int serviceClassMask = 1
                            ; serviceClassMask <= SERVICE_CLASS_MAX
                            ; serviceClassMask <<= 1
                ) {
                    for (int i = 0, s = infos.length; i < s ; i++) {
                        if ((serviceClassMask & infos[i].serviceClass) != 0) {
                            tb.append(makeCFQueryResultMessage(infos[i],
                                            serviceClassMask));
                            tb.append("\n");
                        }
                    }
                }
                sb.append(tb);
            }

            state = State.COMPLETE;
        }

        message = sb;
        phone.onMMIDone(this);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.320 -0500", hash_original_method = "34E140E893F772F43554211DC345FDB0", hash_generated_method = "95D592B775780845CE2507817216982D")
    private void
    onQueryComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");

        if (ar.exception != null) {
            state = State.FAILED;
            sb.append(getErrorMessage(ar));
        } else {
            int[] ints = (int[])ar.result;

            if (ints.length != 0) {
                if (ints[0] == 0) {
                    sb.append(context.getText(com.android.internal.R.string.serviceDisabled));
                } else if (sc.equals(SC_WAIT)) {
                    // Call Waiting includes additional data in the response.
                    sb.append(createQueryCallWaitingResultMessage(ints[1]));
                } else if (isServiceCodeCallBarring(sc)) {
                    // ints[0] for Call Barring is a bit vector of services
                    sb.append(createQueryCallBarringResultMessage(ints[0]));
                } else if (ints[0] == 1) {
                    // for all other services, treat it as a boolean
                    sb.append(context.getText(com.android.internal.R.string.serviceEnabled));
                } else {
                    sb.append(context.getText(com.android.internal.R.string.mmiError));
                }
            } else {
                sb.append(context.getText(com.android.internal.R.string.mmiError));
            }
            state = State.COMPLETE;
        }

        message = sb;
        phone.onMMIDone(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.321 -0500", hash_original_method = "8FB50CB401051839B48C4DBAEAA3D5D3", hash_generated_method = "001858C56266FEDDA4E3DD1CEA1CDC42")
    private CharSequence
    createQueryCallWaitingResultMessage(int serviceClass) {
        StringBuilder sb =
                new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));

        for (int classMask = 1
                    ; classMask <= SERVICE_CLASS_MAX
                    ; classMask <<= 1
        ) {
            if ((classMask & serviceClass) != 0) {
                sb.append("\n");
                sb.append(serviceClassToCFString(classMask & serviceClass));
            }
        }
        return sb;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.322 -0500", hash_original_method = "C357AC638D1646361DDD93B23863C2E5", hash_generated_method = "D735F54BADE790EE7C49824F1D39D294")
    private CharSequence
    createQueryCallBarringResultMessage(int serviceClass)
    {
        StringBuilder sb = new StringBuilder(context.getText(com.android.internal.R.string.serviceEnabledFor));

        for (int classMask = 1
                    ; classMask <= SERVICE_CLASS_MAX
                    ; classMask <<= 1
        ) {
            if ((classMask & serviceClass) != 0) {
                sb.append("\n");
                sb.append(serviceClassToCFString(classMask & serviceClass));
            }
        }
        return sb;
    }

    /***
     * TODO: It would be nice to have a method here that can take in a dialstring and
     * figure out if there is an MMI code embedded within it.  This code would replace
     * some of the string parsing functionality in the Phone App's
     * SpecialCharSequenceMgr class.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:11.323 -0500", hash_original_method = "4616EBEA9D2FF88EEA02D51F5D1F1A7C", hash_generated_method = "F722B0DF9628C717F5A61713FDCA07A3")
    @Override
public String toString() {
        StringBuilder sb = new StringBuilder("GsmMmiCode {");

        sb.append("State=" + getState());
        if (action != null) sb.append(" action=" + action);
        if (sc != null) sb.append(" sc=" + sc);
        if (sia != null) sb.append(" sia=" + sia);
        if (sib != null) sb.append(" sib=" + sib);
        if (sic != null) sb.append(" sic=" + sic);
        if (poundString != null) sb.append(" poundString=" + poundString);
        if (dialingNumber != null) sb.append(" dialingNumber=" + dialingNumber);
        if (pwd != null) sb.append(" pwd=" + pwd);
        sb.append("}");
        return sb.toString();
    }
}

