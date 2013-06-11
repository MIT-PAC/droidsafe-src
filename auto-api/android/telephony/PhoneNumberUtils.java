package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.CountryDetector;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_IDP_STRING;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtils {
    public static final char PAUSE = ',';
    public static final char WAIT = ';';
    public static final char WILD = 'N';
    private static final String CLIR_ON = "*31#+";
    private static final String CLIR_OFF = "#31#+";
    public static final int TOA_International = 0x91;
    public static final int TOA_Unknown = 0x81;
    static final String LOG_TAG = "PhoneNumberUtils";
    private static final boolean DBG = false;
    private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN =
            Pattern.compile("[\\+]?[0-9.-]+");
    public static final int FORMAT_UNKNOWN = 0;
    public static final int FORMAT_NANP = 1;
    public static final int FORMAT_JAPAN = 2;
    private static final String[] NANP_COUNTRIES = new String[] {
        "US", 
        "CA", 
        "AS", 
        "AI", 
        "AG", 
        "BS", 
        "BB", 
        "BM", 
        "VG", 
        "KY", 
        "DM", 
        "DO", 
        "GD", 
        "GU", 
        "JM", 
        "PR", 
        "MS", 
        "MP", 
        "KN", 
        "LC", 
        "VC", 
        "TT", 
        "TC", 
        "VI", 
    };
    private static final int NANP_STATE_DIGIT = 1;
    private static final int NANP_STATE_PLUS = 2;
    private static final int NANP_STATE_ONE = 3;
    private static final int NANP_STATE_DASH = 4;
    static final int MIN_MATCH = 7;
    private static final SparseIntArray KEYPAD_MAP = new SparseIntArray();
    private static final char PLUS_SIGN_CHAR = '+';
    private static final String PLUS_SIGN_STRING = "+";
    private static final String NANP_IDP_STRING = "011";
    private static final int NANP_LENGTH = 10;
    private static final boolean COUNTRY_CALLING_CALL[] = {
        true, true, false, false, false, false, false, true, false, false,
        false, false, false, false, false, false, false, false, false, false,
        true, false, false, false, false, false, false, true, true, false,
        true, true, true, true, true, false, true, false, false, true,
        true, false, false, true, true, true, true, true, true, true,
        false, true, true, true, true, true, true, true, true, false,
        true, true, true, true, true, true, true, false, false, false,
        false, false, false, false, false, false, false, false, false, false,
        false, true, true, true, true, false, true, false, false, true,
        true, true, true, true, true, true, false, false, true, false,
    };
    private static final int CCC_LENGTH = COUNTRY_CALLING_CALL.length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "8DDD4F1B3EBA46E6AD9B7725CB8B68AA", hash_generated_method = "0046DE65F5CD007858ACDC75E81673B2")
    public static boolean isISODigit(char c) {
        return c >= '0' && c <= '9';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "1F784E81F2EDB796AFED78AD0553EEBB", hash_generated_method = "CF2B33FE12DFFCA467EB4D8132098B98")
    public final static boolean is12Key(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "862168FA5BAB349E5C10CD857946505D", hash_generated_method = "E03AFF4D69A7D2042BC424EE0AB65B98")
    public final static boolean isDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+' || c == WILD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "6972D922287D01B71E2745DD45EB4146", hash_generated_method = "5E9A9C7FD8A953A20EB598C331BCC83F")
    public final static boolean isReallyDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "B7263687C68C93D629EB8C9647AA7093", hash_generated_method = "2582F329FDFD0E39033F1B56630000DC")
    public final static boolean isNonSeparator(char c) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+'
                || c == WILD || c == WAIT || c == PAUSE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "E56C1DBFA6D115BECC52B4F023195FFE", hash_generated_method = "98D37AC4AE7F45F8ACA53A1010D4A644")
    public final static boolean isStartsPostDial(char c) {
        return c == PAUSE || c == WAIT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "F868AE21EB899FB020DEBC936A6E152B", hash_generated_method = "45D8A4D90DFC1AA886B53ECAF916CC8F")
    private static boolean isPause(char c) {
        return c == 'p'||c == 'P';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "77D30713D05D4ED1DFAEEC063717084F", hash_generated_method = "3DE7FDC95044758285A39F217E3251C6")
    private static boolean isToneWait(char c) {
        return c == 'w'||c == 'W';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.532 -0400", hash_original_method = "85CF1420537B9541711C4FCF41BF1A25", hash_generated_method = "1F51162AE5FD7B556E7AFBCB3F1A3D3C")
    private static boolean isSeparator(char ch) {
        return !isDialable(ch) && !(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "E0640A2FD798FB776FD3E9A9E45506D7", hash_generated_method = "62E31BD5F2C4BB4E0ED377A13FDC017E")
    public static String getNumberFromIntent(Intent intent, Context context) {
        String number = null;
        Uri uri = intent.getData();
        String scheme = uri.getScheme();
        if (scheme.equals("tel") || scheme.equals("sip")) {
            return uri.getSchemeSpecificPart();
        }
        if (scheme.equals("voicemail")) {
            return TelephonyManager.getDefault().getCompleteVoiceMailNumber();
        }
        if (context == null) {
            return null;
        }
        String type = intent.resolveType(context);
        String phoneColumn = null;
        final String authority = uri.getAuthority();
        if (Contacts.AUTHORITY.equals(authority)) {
            phoneColumn = Contacts.People.Phones.NUMBER;
        } else if (ContactsContract.AUTHORITY.equals(authority)) {
            phoneColumn = ContactsContract.CommonDataKinds.Phone.NUMBER;
        }
        final Cursor c = context.getContentResolver().query(uri, new String[] {
            phoneColumn
        }, null, null, null);
        if (c != null) {
            try {
                if (c.moveToFirst()) {
                    number = c.getString(c.getColumnIndex(phoneColumn));
                }
            } finally {
                c.close();
            }
        }
        return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "85594AF52A8DC28CABB86FCCC3D624C3", hash_generated_method = "D20666622A0B86A22EA9D270C887E52F")
    public static String extractNetworkPortion(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        int len = phoneNumber.length();
        StringBuilder ret = new StringBuilder(len);
        boolean firstCharAdded = false;
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if (isDialable(c) && (c != '+' || !firstCharAdded)) {
                firstCharAdded = true;
                ret.append(c);
            } else if (isStartsPostDial (c)) {
                break;
            }
        }
        int pos = addPlusChar(phoneNumber);
        if (pos >= 0 && ret.length() > pos) {
            ret.insert(pos, '+');
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "8E0188E751AB8076E783C3AD5EFABF59", hash_generated_method = "947491EBC56B7148D08E27D9A40DC08D")
    public static String extractNetworkPortionAlt(String phoneNumber) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (phoneNumber == null) {
            return null;
        }
        int len = phoneNumber.length();
        StringBuilder ret = new StringBuilder(len);
        boolean haveSeenPlus = false;
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if (c == '+') {
                if (haveSeenPlus) {
                    continue;
                }
                haveSeenPlus = true;
            }
            if (isDialable(c)) {
                ret.append(c);
            } else if (isStartsPostDial (c)) {
                break;
            }
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "232A1CFA6D80CA7330EFAD4BFAE5B761", hash_generated_method = "FD34A2227005D779019D5DA5D9DC12A9")
    public static String stripSeparators(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        int len = phoneNumber.length();
        StringBuilder ret = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if (isNonSeparator(c)) {
                ret.append(c);
            }
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "212FDF834FF8F6725237F29A41B6704B", hash_generated_method = "46C0413BA03B9DE945DBF06FA8B5E0CE")
    public static String convertPreDial(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        int len = phoneNumber.length();
        StringBuilder ret = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if (isPause(c)) {
                c = PAUSE;
            } else if (isToneWait(c)) {
                c = WAIT;
            }
            ret.append(c);
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "45612293FA8EEDD0211FEABD43E17C97", hash_generated_method = "4B6F401DAAA5FE88BB25E0BCEA9FB6AC")
    static private int minPositive(int a, int b) {
        if (a >= 0 && b >= 0) {
            return (a < b) ? a : b;
        } else if (a >= 0) { 
            return a;
        } else if (b >= 0) { 
            return b;
        } else { 
            return -1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "DB05E60B51779EDEE5A85D6BA3688CBD", hash_generated_method = "73D02F89C31E4EF7887EA5B6EB937838")
    private static void log(String msg) {
        Log.d(LOG_TAG, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.533 -0400", hash_original_method = "CA3503A44AF2EBF75D9BE6634816F5BD", hash_generated_method = "2F1D840268C9E28C26FC89221FEC809F")
    static private int indexOfLastNetworkChar(String a) {
        int pIndex, wIndex;
        int origLength;
        int trimIndex;
        origLength = a.length();
        pIndex = a.indexOf(PAUSE);
        wIndex = a.indexOf(WAIT);
        trimIndex = minPositive(pIndex, wIndex);
        if (trimIndex < 0) {
            return origLength - 1;
        } else {
            return trimIndex - 1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "5412F78A6FFD23BF6E67569C9C7086D9", hash_generated_method = "A1A47654BACAD454A83B86CF81070850")
    private static int addPlusChar(String number) {
        int pos = -1;
        if (number.startsWith(CLIR_OFF)) {
            pos = CLIR_OFF.length() - 1;
        }
        if (number.startsWith(CLIR_ON)) {
            pos = CLIR_ON.length() - 1;
        }
        return pos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "4F2019AF1701903E5EF27732AE7CF8E2", hash_generated_method = "16E2097032ADBC16FC2957CA6B31353D")
    public static String extractPostDialPortion(String phoneNumber) {
        if (phoneNumber == null) return null;
        int trimIndex;
        StringBuilder ret = new StringBuilder();
        trimIndex = indexOfLastNetworkChar (phoneNumber);
        for (int i = trimIndex + 1, s = phoneNumber.length()
                ; i < s; i++
        ) {
            char c = phoneNumber.charAt(i);
            if (isNonSeparator(c)) {
                ret.append(c);
            }
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "448A5F7926670D54885C01A1388DB100", hash_generated_method = "EA173ED08BAA12966F6AD78B4A8B398D")
    public static boolean compare(String a, String b) {
        return compare(a, b, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "FAC0E437D1666841C3F351749EE85C53", hash_generated_method = "4D0435CC2E5475DDCCDB8B40A240E271")
    public static boolean compare(Context context, String a, String b) {
        boolean useStrict = context.getResources().getBoolean(
               com.android.internal.R.bool.config_use_strict_phone_number_comparation);
        return compare(a, b, useStrict);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "367B284A9371AD494F48AAD9523ABA01", hash_generated_method = "A806BE37D44FCFF0044AFFEDBF82AE71")
    public static boolean compare(String a, String b, boolean useStrictComparation) {
        return (useStrictComparation ? compareStrictly(a, b) : compareLoosely(a, b));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "8F5CD7EECBE2A2BA521BCB26962910D6", hash_generated_method = "5DABAF80098801E30BA35CF13709325A")
    public static boolean compareLoosely(String a, String b) {
        int ia, ib;
        int matched;
        int numNonDialableCharsInA = 0;
        int numNonDialableCharsInB = 0;
        if (a == null || b == null) return a == b;
        if (a.length() == 0 || b.length() == 0) {
            return false;
        }
        ia = indexOfLastNetworkChar (a);
        ib = indexOfLastNetworkChar (b);
        matched = 0;
        while (ia >= 0 && ib >=0) {
            char ca, cb;
            boolean skipCmp = false;
            ca = a.charAt(ia);
            if (!isDialable(ca)) {
                ia--;
                skipCmp = true;
                numNonDialableCharsInA++;
            }
            cb = b.charAt(ib);
            if (!isDialable(cb)) {
                ib--;
                skipCmp = true;
                numNonDialableCharsInB++;
            }
            if (!skipCmp) {
                if (cb != ca && ca != WILD && cb != WILD) {
                    break;
                }
                ia--; ib--; matched++;
            }
        }
        if (matched < MIN_MATCH) {
            int effectiveALen = a.length() - numNonDialableCharsInA;
            int effectiveBLen = b.length() - numNonDialableCharsInB;
            if (effectiveALen == effectiveBLen && effectiveALen == matched) {
                return true;
            }
            return false;
        }
        if (matched >= MIN_MATCH && (ia < 0 || ib < 0)) {
            return true;
        }
        if (matchIntlPrefix(a, ia + 1)
            && matchIntlPrefix (b, ib +1)
        ) {
            return true;
        }
        if (matchTrunkPrefix(a, ia + 1)
            && matchIntlPrefixAndCC(b, ib +1)
        ) {
            return true;
        }
        if (matchTrunkPrefix(b, ib + 1)
            && matchIntlPrefixAndCC(a, ia +1)
        ) {
            return true;
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "4C9BF85CCF4A05C05A692B20618E9342", hash_generated_method = "05FC5A7C9C29FF6AEB98920AB607EA82")
    public static boolean compareStrictly(String a, String b) {
        return compareStrictly(a, b, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.534 -0400", hash_original_method = "4EDBDF4132895DDD5559995EAE3F6530", hash_generated_method = "23A1C47E9CBD82424FDFEE2E5C07AB7C")
    public static boolean compareStrictly(String a, String b, boolean acceptInvalidCCCPrefix) {
        if (a == null || b == null) {
            return a == b;
        } else if (a.length() == 0 && b.length() == 0) {
            return false;
        }
        int forwardIndexA = 0;
        int forwardIndexB = 0;
        CountryCallingCodeAndNewIndex cccA =
            tryGetCountryCallingCodeAndNewIndex(a, acceptInvalidCCCPrefix);
        CountryCallingCodeAndNewIndex cccB =
            tryGetCountryCallingCodeAndNewIndex(b, acceptInvalidCCCPrefix);
        boolean bothHasCountryCallingCode = false;
        boolean okToIgnorePrefix = true;
        boolean trunkPrefixIsOmittedA = false;
        boolean trunkPrefixIsOmittedB = false;
        if (cccA != null && cccB != null) {
            if (cccA.countryCallingCode != cccB.countryCallingCode) {
                return false;
            }
            okToIgnorePrefix = false;
            bothHasCountryCallingCode = true;
            forwardIndexA = cccA.newIndex;
            forwardIndexB = cccB.newIndex;
        } else if (cccA == null && cccB == null) {
            okToIgnorePrefix = false;
        } else {
            if (cccA != null) {
                forwardIndexA = cccA.newIndex;
            } else {
                int tmp = tryGetTrunkPrefixOmittedIndex(b, 0);
                if (tmp >= 0) {
                    forwardIndexA = tmp;
                    trunkPrefixIsOmittedA = true;
                }
            }
            if (cccB != null) {
                forwardIndexB = cccB.newIndex;
            } else {
                int tmp = tryGetTrunkPrefixOmittedIndex(b, 0);
                if (tmp >= 0) {
                    forwardIndexB = tmp;
                    trunkPrefixIsOmittedB = true;
                }
            }
        }
        int backwardIndexA = a.length() - 1;
        int backwardIndexB = b.length() - 1;
        while (backwardIndexA >= forwardIndexA && backwardIndexB >= forwardIndexB) {
            boolean skip_compare = false;
            final char chA = a.charAt(backwardIndexA);
            final char chB = b.charAt(backwardIndexB);
            if (isSeparator(chA)) {
                backwardIndexA--;
                skip_compare = true;
            }
            if (isSeparator(chB)) {
                backwardIndexB--;
                skip_compare = true;
            }
            if (!skip_compare) {
                if (chA != chB) {
                    return false;
                }
                backwardIndexA--;
                backwardIndexB--;
            }
        }
        if (okToIgnorePrefix) {
            if ((trunkPrefixIsOmittedA && forwardIndexA <= backwardIndexA) ||
                !checkPrefixIsIgnorable(a, forwardIndexA, backwardIndexA)) {
                if (acceptInvalidCCCPrefix) {
                    return compare(a, b, false);
                } else {
                    return false;
                }
            }
            if ((trunkPrefixIsOmittedB && forwardIndexB <= backwardIndexB) ||
                !checkPrefixIsIgnorable(b, forwardIndexA, backwardIndexB)) {
                if (acceptInvalidCCCPrefix) {
                    return compare(a, b, false);
                } else {
                    return false;
                }
            }
        } else {
            boolean maybeNamp = !bothHasCountryCallingCode;
            while (backwardIndexA >= forwardIndexA) {
                final char chA = a.charAt(backwardIndexA);
                if (isDialable(chA)) {
                    if (maybeNamp && tryGetISODigit(chA) == 1) {
                        maybeNamp = false;
                    } else {
                        return false;
                    }
                }
                backwardIndexA--;
            }
            while (backwardIndexB >= forwardIndexB) {
                final char chB = b.charAt(backwardIndexB);
                if (isDialable(chB)) {
                    if (maybeNamp && tryGetISODigit(chB) == 1) {
                        maybeNamp = false;
                    } else {
                        return false;
                    }
                }
                backwardIndexB--;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "930DD52B84605C74F4CF39C7CC283746", hash_generated_method = "25376D0D6F4E43BFA7DF4F7F9D511468")
    public static String toCallerIDMinMatch(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);
        return internalGetStrippedReversed(np, MIN_MATCH);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "D2BEAEC3FE32EF1C76508600B5DF4065", hash_generated_method = "88CDDE2AB55F2970EE715A7DD4A18D76")
    public static String getStrippedReversed(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);
        if (np == null) return null;
        return internalGetStrippedReversed(np, np.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "D354471DE97D7AAEA65C4CC9D8664F81", hash_generated_method = "6B46BEC57DF751E8331C0A6B42230C36")
    private static String internalGetStrippedReversed(String np, int numDigits) {
        if (np == null) return null;
        StringBuilder ret = new StringBuilder(numDigits);
        int length = np.length();
        for (int i = length - 1, s = length
            ; i >= 0 && (s - i) <= numDigits ; i--
        ) {
            char c = np.charAt(i);
            ret.append(c);
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "DA26E8679FA547BA71428FCE4B001FC5", hash_generated_method = "821B809869E5DBFA77CA94C895EDB626")
    public static String stringFromStringAndTOA(String s, int TOA) {
        if (s == null) return null;
        if (TOA == TOA_International && s.length() > 0 && s.charAt(0) != '+') {
            return "+" + s;
        }
        return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "742B342269A43CEE9B6B4FB04BAA47B5", hash_generated_method = "0A7ABDB13E39D8843019F448D0B1F42C")
    public static int toaFromString(String s) {
        if (s != null && s.length() > 0 && s.charAt(0) == '+') {
            return TOA_International;
        }
        return TOA_Unknown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "370BD6969A31137A90CC0B60704C81A4", hash_generated_method = "F053DE628C29E3D270F4C8FC6AEE85DC")
    public static String calledPartyBCDToString(byte[] bytes, int offset, int length) {
        boolean prependPlus = false;
        StringBuilder ret = new StringBuilder(1 + length * 2);
        if (length < 2) {
            return "";
        }
        if ((bytes[offset] & 0xf0) == (TOA_International & 0xf0)) {
            prependPlus = true;
        }
        internalCalledPartyBCDFragmentToString(
                ret, bytes, offset + 1, length - 1);
        if (prependPlus && ret.length() == 0) {
            return "";
        }
        if (prependPlus) {
            String retString = ret.toString();
            Pattern p = Pattern.compile("(^[#*])(.*)([#*])(.*)(#)$");
            Matcher m = p.matcher(retString);
            if (m.matches()) {
                if ("".equals(m.group(2))) {
                    ret = new StringBuilder();
                    ret.append(m.group(1));
                    ret.append(m.group(3));
                    ret.append(m.group(4));
                    ret.append(m.group(5));
                    ret.append("+");
                } else {
                    ret = new StringBuilder();
                    ret.append(m.group(1));
                    ret.append(m.group(2));
                    ret.append(m.group(3));
                    ret.append("+");
                    ret.append(m.group(4));
                    ret.append(m.group(5));
                }
            } else {
                p = Pattern.compile("(^[#*])(.*)([#*])(.*)");
                m = p.matcher(retString);
                if (m.matches()) {
                    ret = new StringBuilder();
                    ret.append(m.group(1));
                    ret.append(m.group(2));
                    ret.append(m.group(3));
                    ret.append("+");
                    ret.append(m.group(4));
                } else {
                    ret = new StringBuilder();
                    ret.append('+');
                    ret.append(retString);
                }
            }
        }
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "1DA55FF5FC6AC864C1B47D3450B3A6D6", hash_generated_method = "73239236F73F680CB23EC6BDAA4CC404")
    private static void internalCalledPartyBCDFragmentToString(
        StringBuilder sb, byte [] bytes, int offset, int length) {
        for (int i = offset ; i < length + offset ; i++) {
            byte b;
            char c;
            c = bcdToChar((byte)(bytes[i] & 0xf));
            if (c == 0) {
                return;
            }
            sb.append(c);
            b = (byte)((bytes[i] >> 4) & 0xf);
            if (b == 0xf && i + 1 == length + offset) {
                break;
            }
            c = bcdToChar(b);
            if (c == 0) {
                return;
            }
            sb.append(c);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "AC6F2BD2CEECA2EAA4423AB8E7E6F05C", hash_generated_method = "56F2D1EF60CB50C41C74D9436CBA7553")
    public static String calledPartyBCDFragmentToString(byte [] bytes, int offset, int length) {
        StringBuilder ret = new StringBuilder(length * 2);
        internalCalledPartyBCDFragmentToString(ret, bytes, offset, length);
        return ret.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "6BBF92D1C6E8D0EDE6C4F442992FDCAA", hash_generated_method = "D96361B18913B1B8DF9154B1BFF13F95")
    private static char bcdToChar(byte b) {
        if (b < 0xa) {
            return (char)('0' + b);
        } else switch (b) {
            case 0xa: return '*';
            case 0xb: return '#';
            case 0xc: return PAUSE;
            case 0xd: return WILD;
            default: return 0;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.535 -0400", hash_original_method = "D9B38AE621A94A7D136B7ACCE59CB7FC", hash_generated_method = "F3FBFED8F593EBD723AB49B6A7ADA562")
    private static int charToBCD(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c == '*') {
            return 0xa;
        } else if (c == '#') {
            return 0xb;
        } else if (c == PAUSE) {
            return 0xc;
        } else if (c == WILD) {
            return 0xd;
        } else {
            throw new RuntimeException ("invalid char for BCD " + c);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "A988E80FBF926E38476CB13622AE0017", hash_generated_method = "7C5E5705B6EC3452A5193A1A55FAF86A")
    public static boolean isWellFormedSmsAddress(String address) {
        String networkPortion =
                PhoneNumberUtils.extractNetworkPortion(address);
        return (!(networkPortion.equals("+")
                  || TextUtils.isEmpty(networkPortion)))
               && isDialable(networkPortion);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "9FED45E4C5931DED3A7CDAD84E36E48F", hash_generated_method = "CF57E3F57F0DA5634424CBA3CD5763CA")
    public static boolean isGlobalPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }
        Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return match.matches();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "F10D97D241B233A1AD5555B2D68CA84D", hash_generated_method = "0F9D58D8547059E91A29E5A581488E6B")
    private static boolean isDialable(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isDialable(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "164C0FF3751154C0A9BD1D63E5C99981", hash_generated_method = "15BB8E90268AD9473CDFF40B889D0D32")
    private static boolean isNonSeparator(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isNonSeparator(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "AF7754C02AEA7A015FB424C581D10AD2", hash_generated_method = "53623794260D741565AA1804CA11DC3D")
    public static byte[] networkPortionToCalledPartyBCD(String s) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "53FAAB919D090E6E7EF0B0376A95BD6B", hash_generated_method = "005A8B5306D21EB9F17390903000B4A1")
    public static byte[] networkPortionToCalledPartyBCDWithLength(String s) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "46011790469F97E3B0CE4186D5C8E763", hash_generated_method = "235F8733C111298DA75197392233021F")
    public static byte[] numberToCalledPartyBCD(String number) {
        return numberToCalledPartyBCDHelper(number, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "3389153632676598B3C0211E28EEF1DE", hash_generated_method = "5EE557EBD26B23126B110EE3CFD8565A")
    private static byte[] numberToCalledPartyBCDHelper(String number, boolean includeLength) {
        int numberLenReal = number.length();
        int numberLenEffective = numberLenReal;
        boolean hasPlus = number.indexOf('+') != -1;
        if (hasPlus) numberLenEffective--;
        if (numberLenEffective == 0) return null;
        int resultLen = (numberLenEffective + 1) / 2;
        int extraBytes = 1;
        if (includeLength) extraBytes++;
        resultLen += extraBytes;
        byte[] result = new byte[resultLen];
        int digitCount = 0;
        for (int i = 0; i < numberLenReal; i++) {
            char c = number.charAt(i);
            if (c == '+') continue;
            int shift = ((digitCount & 0x01) == 1) ? 4 : 0;
            result[extraBytes + (digitCount >> 1)] |= (byte)((charToBCD(c) & 0x0F) << shift);
            digitCount++;
        }
        if ((digitCount & 0x01) == 1) result[extraBytes + (digitCount >> 1)] |= 0xF0;
        int offset = 0;
        if (includeLength) result[offset++] = (byte)(resultLen - 1);
        result[offset] = (byte)(hasPlus ? TOA_International : TOA_Unknown);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "F559913F36966A96ABB20C01E67F5DD8", hash_generated_method = "AB4056F3A6E3A769AE23A235BAD6EBBE")
    public static String formatNumber(String source) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, getFormatTypeForLocale(Locale.getDefault()));
        return text.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "A28BEF976D7AD72608E8693C01B15E97", hash_generated_method = "1747FF79977D1D6D80FDB3C041399E3E")
    public static String formatNumber(String source, int defaultFormattingType) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, defaultFormattingType);
        return text.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "2035A43BA247538550AB3B62E959FF45", hash_generated_method = "732EDFC543A716276529B9845579B8CC")
    public static int getFormatTypeForLocale(Locale locale) {
        String country = locale.getCountry();
        return getFormatTypeFromCountryCode(country);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.536 -0400", hash_original_method = "F478444122BC83D34781A111CA26291E", hash_generated_method = "1A66F58E10D618B5AC146E8E7434C960")
    public static void formatNumber(Editable text, int defaultFormattingType) {
        int formatType = defaultFormattingType;
        if (text.length() > 2 && text.charAt(0) == '+') {
            if (text.charAt(1) == '1') {
                formatType = FORMAT_NANP;
            } else if (text.length() >= 3 && text.charAt(1) == '8'
                && text.charAt(2) == '1') {
                formatType = FORMAT_JAPAN;
            } else {
                formatType = FORMAT_UNKNOWN;
            }
        }
        switch (formatType) {
            case FORMAT_NANP:
                formatNanpNumber(text);
                return;
            case FORMAT_JAPAN:
                formatJapaneseNumber(text);
                return;
            case FORMAT_UNKNOWN:
                removeDashes(text);
                return;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "375626B12DD2ECC6EA0EE4FF36348A38", hash_generated_method = "5937F30807B8131A120BD5E33307F10F")
    public static void formatNanpNumber(Editable text) {
        int length = text.length();
        if (length > "+1-nnn-nnn-nnnn".length()) {
            return;
        } else if (length <= 5) {
            return;
        }
        CharSequence saved = text.subSequence(0, length);
        removeDashes(text);
        length = text.length();
        int dashPositions[] = new int[3];
        int numDashes = 0;
        int state = NANP_STATE_DIGIT;
        int numDigits = 0;
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            switch (c) {
                case '1':
                    if (numDigits == 0 || state == NANP_STATE_PLUS) {
                        state = NANP_STATE_ONE;
                        break;
                    }
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    if (state == NANP_STATE_PLUS) {
                        text.replace(0, length, saved);
                        return;
                    } else if (state == NANP_STATE_ONE) {
                        dashPositions[numDashes++] = i;
                    } else if (state != NANP_STATE_DASH && (numDigits == 3 || numDigits == 6)) {
                        dashPositions[numDashes++] = i;
                    }
                    state = NANP_STATE_DIGIT;
                    numDigits++;
                    break;
                case '-':
                    state = NANP_STATE_DASH;
                    break;
                case '+':
                    if (i == 0) {
                        state = NANP_STATE_PLUS;
                        break;
                    }
                default:
                    text.replace(0, length, saved);
                    return;
            }
        }
        if (numDigits == 7) {
            numDashes--;
        }
        for (int i = 0; i < numDashes; i++) {
            int pos = dashPositions[i];
            text.replace(pos + i, pos + i, "-");
        }
        int len = text.length();
        while (len > 0) {
            if (text.charAt(len - 1) == '-') {
                text.delete(len - 1, len);
                len--;
            } else {
                break;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "831FDF191B22FA73D71F28C227E32FDE", hash_generated_method = "BBC3894E3BBE101FBE98BDC338697EAF")
    public static void formatJapaneseNumber(Editable text) {
        JapanesePhoneNumberFormatter.format(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "298AB552332245AFF95538EA4279D4D4", hash_generated_method = "50D1BFC7AAECE48C025D94DD177D8F93")
    private static void removeDashes(Editable text) {
        int p = 0;
        while (p < text.length()) {
            if (text.charAt(p) == '-') {
                text.delete(p, p + 1);
           } else {
                p++;
           }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "D633463C720A911377C680E8AA0DAE0C", hash_generated_method = "E4AE7F97116A9A6E76E29F66F26D5110")
    public static String formatNumberToE164(String phoneNumber, String defaultCountryIso) {
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        String result = null;
        try {
            PhoneNumber pn = util.parse(phoneNumber, defaultCountryIso);
            if (util.isValidNumber(pn)) {
                result = util.format(pn, PhoneNumberFormat.E164);
            }
        } catch (NumberParseException e) {
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "A7ACF6BA9DDECE3E31DBB8A7DF4DF0DB", hash_generated_method = "76484F706BF4B941A352453AFD848243")
    public static String formatNumber(String phoneNumber, String defaultCountryIso) {
        if (phoneNumber.startsWith("#") || phoneNumber.startsWith("*")) {
            return phoneNumber;
        }
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        String result = null;
        try {
            PhoneNumber pn = util.parseAndKeepRawInput(phoneNumber, defaultCountryIso);
            result = util.formatInOriginalFormat(pn, defaultCountryIso);
        } catch (NumberParseException e) {
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "7DEA5A41C8CF38812E48507218F476CC", hash_generated_method = "084ECDDBEB1D0062F81D82998CF2AF11")
    public static String formatNumber(
            String phoneNumber, String phoneNumberE164, String defaultCountryIso) {
        int len = phoneNumber.length();
        for (int i = 0; i < len; i++) {
            if (!isDialable(phoneNumber.charAt(i))) {
                return phoneNumber;
            }
        }
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        if (phoneNumberE164 != null && phoneNumberE164.length() >= 2
                && phoneNumberE164.charAt(0) == '+') {
            try {
                PhoneNumber pn = util.parse(phoneNumberE164, defaultCountryIso);
                String regionCode = util.getRegionCodeForNumber(pn);
                if (!TextUtils.isEmpty(regionCode)) {
                    defaultCountryIso = regionCode;
                }
            } catch (NumberParseException e) {
            }
        }
        String result = formatNumber(phoneNumber, defaultCountryIso);
        return result != null ? result : phoneNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "2AE8554E2C6CFEA55F148AAA6C526165", hash_generated_method = "974D64E5B862CB1550A41D214F458228")
    public static String normalizeNumber(String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        int len = phoneNumber.length();
        for (int i = 0; i < len; i++) {
            char c = phoneNumber.charAt(i);
            if ((i == 0 && c == '+') || PhoneNumberUtils.isISODigit(c)) {
                sb.append(c);
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return normalizeNumber(PhoneNumberUtils.convertKeypadLettersToDigits(phoneNumber));
            }
        }
        return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "FB7235E779930AE81382F4B3EEC25C67", hash_generated_method = "04AFF21829E361B0548DAA6F279FC48A")
    public static boolean isEmergencyNumber(String number) {
        return isEmergencyNumberInternal(number, true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "F300FF32E0091AB2C24307358D9DBEF4", hash_generated_method = "A964AEF735618E6C0ACBA9B0605A9303")
    public static boolean isPotentialEmergencyNumber(String number) {
        return isEmergencyNumberInternal(number, false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "37285ED747A36960374A3465C356C231", hash_generated_method = "A3A51D69C78372AC9911C89A7C942666")
    private static boolean isEmergencyNumberInternal(String number, boolean useExactMatch) {
        if (number == null) return false;
        if (isUriNumber(number)) {
            return false;
        }
        number = extractNetworkPortionAlt(number);
        String numbers = SystemProperties.get("ril.ecclist");
        if (TextUtils.isEmpty(numbers)) {
            numbers = SystemProperties.get("ro.ril.ecclist");
        }
        if (!TextUtils.isEmpty(numbers)) {
            for (String emergencyNum : numbers.split(",")) {
                if (useExactMatch) {
                    if (number.equals(emergencyNum)) {
                        return true;
                    }
                } else {
                    if (number.startsWith(emergencyNum)) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (useExactMatch) {
            return (number.equals("112") || number.equals("911"));
        } else {
            return (number.startsWith("112") || number.startsWith("911"));
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.537 -0400", hash_original_method = "23B47A857E4542DE9F8AF3FFA1A4FD79", hash_generated_method = "5A91B15328E54E0DC8DF2C4DB820EB16")
    public static boolean isEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "0880441C47E987D03FC49C5FE19093F0", hash_generated_method = "ABE3C4A94889A6E18C9D576E5E7B202C")
    public static boolean isPotentialEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "CB79FF72E5AA03B786B465A966D1C6DF", hash_generated_method = "F24A395E3CA77219061A70FAFB2FC333")
    private static boolean isEmergencyNumberInternal(String number,
                                                     String defaultCountryIso,
                                                     boolean useExactMatch) {
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        try {
            PhoneNumber pn = util.parse(number, defaultCountryIso);
            if (util.isValidNumber(pn)) {
                return false;
            } else if ("BR".equalsIgnoreCase(defaultCountryIso) && number.length() >= 8) {
                return false;
            }
        } catch (NumberParseException e) {
        }
        return isEmergencyNumberInternal(number, useExactMatch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "2C93EF10C01AE643F78F003A0BECAC73", hash_generated_method = "64EF6E58DDD3A00CD82B9168551F56F5")
    public static boolean isLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              true );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "81A59D28753D7C567B4B024877A8C6E6", hash_generated_method = "6D0E3002313043BFAE7E69DB2D9476F1")
    public static boolean isPotentialLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              false );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "96612C398F49F406D66C3575CAB886FB", hash_generated_method = "3009211BA40AE2579361B1980C938E79")
    private static boolean isLocalEmergencyNumberInternal(String number,
                                                          Context context,
                                                          boolean useExactMatch) {
        String countryIso;
        CountryDetector detector = (CountryDetector) context.getSystemService(
                Context.COUNTRY_DETECTOR);
        if (detector != null) {
            countryIso = detector.detectCountry().getCountryIso();
        } else {
            Locale locale = context.getResources().getConfiguration().locale;
            countryIso = locale.getCountry();
            Log.w(LOG_TAG, "No CountryDetector; falling back to countryIso based on locale: "
                    + countryIso);
        }
        return isEmergencyNumberInternal(number, countryIso, useExactMatch);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "F89FCCC7DAC3DDDECFBD90C73C53D5D4", hash_generated_method = "07B87F2F4AA52F3E58A2D18DB687A77F")
    public static boolean isVoiceMailNumber(String number) {
        String vmNumber;
        try {
            vmNumber = TelephonyManager.getDefault().getVoiceMailNumber();
        } catch (SecurityException ex) {
            return false;
        }
        number = extractNetworkPortionAlt(number);
        return !TextUtils.isEmpty(number) && compare(number, vmNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "C19DA42AB571E96824BDE2AB4D9CB311", hash_generated_method = "DB6BD13189E6148E95CA64BA326C0C64")
    public static String convertKeypadLettersToDigits(String input) {
        if (input == null) {
            return input;
        }
        int len = input.length();
        if (len == 0) {
            return input;
        }
        char[] out = input.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = out[i];
            out[i] = (char) KEYPAD_MAP.get(c, c);
        }
        return new String(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "1A1413577F7152F2ECD6922D2D24CEE2", hash_generated_method = "950DE6C5B1F761D93F899644CB882D70")
    public static String cdmaCheckAndProcessPlusCode(String dialStr) {
        if (!TextUtils.isEmpty(dialStr)) {
            if (isReallyDialable(dialStr.charAt(0)) &&
                isNonSeparator(dialStr)) {
                String currIso = SystemProperties.get(PROPERTY_OPERATOR_ISO_COUNTRY, "");
                String defaultIso = SystemProperties.get(PROPERTY_ICC_OPERATOR_ISO_COUNTRY, "");
                if (!TextUtils.isEmpty(currIso) && !TextUtils.isEmpty(defaultIso)) {
                    return cdmaCheckAndProcessPlusCodeByNumberFormat(dialStr,
                            getFormatTypeFromCountryCode(currIso),
                            getFormatTypeFromCountryCode(defaultIso));
                }
            }
        }
        return dialStr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "8B3D064358571DB7A73FB86148106DC9", hash_generated_method = "72B55158652350410B34DF0869F10898")
    public static String cdmaCheckAndProcessPlusCodeByNumberFormat(String dialStr,int currFormat,int defaultFormat) {
        String retStr = dialStr;
        if (dialStr != null &&
            dialStr.lastIndexOf(PLUS_SIGN_STRING) != -1) {
            if ((currFormat == defaultFormat) && (currFormat == FORMAT_NANP)) {
                String postDialStr = null;
                String tempDialStr = dialStr;
                retStr = null;
                if (DBG) log("checkAndProcessPlusCode,dialStr=" + dialStr);
                do {
                    String networkDialStr;
                    networkDialStr = extractNetworkPortion(tempDialStr);
                    networkDialStr = processPlusCodeWithinNanp(networkDialStr);
                    if (!TextUtils.isEmpty(networkDialStr)) {
                        if (retStr == null) {
                            retStr = networkDialStr;
                        } else {
                            retStr = retStr.concat(networkDialStr);
                        }
                    } else {
                        Log.e("checkAndProcessPlusCode: null newDialStr", networkDialStr);
                        return dialStr;
                    }
                    postDialStr = extractPostDialPortion(tempDialStr);
                    if (!TextUtils.isEmpty(postDialStr)) {
                        int dialableIndex = findDialableIndexFromPostDialStr(postDialStr);
                        if (dialableIndex >= 1) {
                            retStr = appendPwCharBackToOrigDialStr(dialableIndex,
                                     retStr,postDialStr);
                            tempDialStr = postDialStr.substring(dialableIndex);
                        } else {
                            if (dialableIndex < 0) {
                                postDialStr = "";
                            }
                            Log.e("wrong postDialStr=", postDialStr);
                        }
                    }
                    if (DBG) log("checkAndProcessPlusCode,postDialStr=" + postDialStr);
                } while (!TextUtils.isEmpty(postDialStr) && !TextUtils.isEmpty(tempDialStr));
            } else {
                Log.e("checkAndProcessPlusCode:non-NANP not supported", dialStr);
            }
        }
        return retStr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "CE701E93949872446157BBE9ECAD64D2", hash_generated_method = "5C783DC2B0314289305BE0318C5A16AA")
    private static String getDefaultIdp( ) {
        String ps = null;
        SystemProperties.get(PROPERTY_IDP_STRING, ps);
        if (TextUtils.isEmpty(ps)) {
            ps = NANP_IDP_STRING;
        }
        return ps;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.538 -0400", hash_original_method = "8B2A426364680DCC80D51C3F849C284B", hash_generated_method = "D2B8ACE6C711ACEF4529BB28202DCF47")
    private static boolean isTwoToNine(char c) {
        if (c >= '2' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "532A9297847E5A4BD7745A9593C301A6", hash_generated_method = "8C03BE4B95D2A54C9272BD2FB5A6243A")
    private static int getFormatTypeFromCountryCode(String country) {
        int length = NANP_COUNTRIES.length;
        for (int i = 0; i < length; i++) {
            if (NANP_COUNTRIES[i].compareToIgnoreCase(country) == 0) {
                return FORMAT_NANP;
            }
        }
        if ("jp".compareToIgnoreCase(country) == 0) {
            return FORMAT_JAPAN;
        }
        return FORMAT_UNKNOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "429014701CBDF3E63C4D942F6F6D141A", hash_generated_method = "B62EF7D8E52E9EF213344FDB1A7B0FF5")
    private static boolean isNanp(String dialStr) {
        boolean retVal = false;
        if (dialStr != null) {
            if (dialStr.length() == NANP_LENGTH) {
                if (isTwoToNine(dialStr.charAt(0)) &&
                    isTwoToNine(dialStr.charAt(3))) {
                    retVal = true;
                    for (int i=1; i<NANP_LENGTH; i++ ) {
                        char c=dialStr.charAt(i);
                        if (!PhoneNumberUtils.isISODigit(c)) {
                            retVal = false;
                            break;
                        }
                    }
                }
            }
        } else {
            Log.e("isNanp: null dialStr passed in", dialStr);
        }
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "4C14D29B81253845991BCF5FA05DF332", hash_generated_method = "1335544A869314E10256A75BC226BC6C")
    private static boolean isOneNanp(String dialStr) {
        boolean retVal = false;
        if (dialStr != null) {
            String newDialStr = dialStr.substring(1);
            if ((dialStr.charAt(0) == '1') && isNanp(newDialStr)) {
                retVal = true;
            }
        } else {
            Log.e("isOneNanp: null dialStr passed in", dialStr);
        }
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "CC3E46D1D493D55DA8F3552367CC9130", hash_generated_method = "83647AC3EB801AEA1D716B0A142A0EDB")
    public static boolean isUriNumber(String number) {
        return number != null && (number.contains("@") || number.contains("%40"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "F030E804700DAC1BD311652B4F54A186", hash_generated_method = "910F393F0C4A38BA28BE0A3308FB961D")
    public static String getUsernameFromUriNumber(String number) {
        int delimiterIndex = number.indexOf('@');
        if (delimiterIndex < 0) {
            delimiterIndex = number.indexOf("%40");
        }
        if (delimiterIndex < 0) {
            Log.w(LOG_TAG,
                  "getUsernameFromUriNumber: no delimiter found in SIP addr '" + number + "'");
            delimiterIndex = number.length();
        }
        return number.substring(0, delimiterIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "84C5DF0BB814E2B994CF01B1B056D342", hash_generated_method = "EBBC7588A4BA0A01AD56B26D7A3CF511")
    private static String processPlusCodeWithinNanp(String networkDialStr) {
        String retStr = networkDialStr;
        if (DBG) log("processPlusCodeWithinNanp,networkDialStr=" + networkDialStr);
        if (networkDialStr != null &&
            networkDialStr.charAt(0) == PLUS_SIGN_CHAR &&
            networkDialStr.length() > 1) {
            String newStr = networkDialStr.substring(1);
            if (isOneNanp(newStr)) {
                retStr = newStr;
             } else {
                 String idpStr = getDefaultIdp();
                 retStr = networkDialStr.replaceFirst("[+]", idpStr);
            }
        }
        if (DBG) log("processPlusCodeWithinNanp,retStr=" + retStr);
        return retStr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "BD4A493D09E16FABF648801F72081EA4", hash_generated_method = "75C8551D7D331A82F79BA05D08FFE6BD")
    private static int findDialableIndexFromPostDialStr(String postDialStr) {
        for (int index = 0;index < postDialStr.length();index++) {
             char c = postDialStr.charAt(index);
             if (isReallyDialable(c)) {
                return index;
             }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "41DC2CC4DA802A8544E430BC872F3EFD", hash_generated_method = "C481C46D0661C03CE69C531A3953ACAC")
    private static String appendPwCharBackToOrigDialStr(int dialableIndex,String origStr, String dialStr) {
        String retStr;
        if (dialableIndex == 1) {
            StringBuilder ret = new StringBuilder(origStr);
            ret = ret.append(dialStr.charAt(0));
            retStr = ret.toString();
        } else {
            String nonDigitStr = dialStr.substring(0,dialableIndex);
            retStr = origStr.concat(nonDigitStr);
        }
        return retStr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "36F66EFD343D5849BA1CADCA9AD61546", hash_generated_method = "AE303810284E53B91E36B84CEC6ACA09")
    private static boolean matchIntlPrefix(String a, int len) {
        int state = 0;
        for (int i = 0 ; i < len ; i++) {
            char c = a.charAt(i);
            switch (state) {
                case 0:
                    if      (c == '+') state = 1;
                    else if (c == '0') state = 2;
                    else if (isNonSeparator(c)) return false;
                break;
                case 2:
                    if      (c == '0') state = 3;
                    else if (c == '1') state = 4;
                    else if (isNonSeparator(c)) return false;
                break;
                case 4:
                    if      (c == '1') state = 5;
                    else if (isNonSeparator(c)) return false;
                break;
                default:
                    if (isNonSeparator(c)) return false;
                break;
            }
        }
        return state == 1 || state == 3 || state == 5;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.539 -0400", hash_original_method = "4F741A7A51F1E923707F3A08CA0DFA64", hash_generated_method = "5A11F3E15FC467EE72EBD8CE46BAA2F9")
    private static boolean matchIntlPrefixAndCC(String a, int len) {
        int state = 0;
        for (int i = 0 ; i < len ; i++ ) {
            char c = a.charAt(i);
            switch (state) {
                case 0:
                    if      (c == '+') state = 1;
                    else if (c == '0') state = 2;
                    else if (isNonSeparator(c)) return false;
                break;
                case 2:
                    if      (c == '0') state = 3;
                    else if (c == '1') state = 4;
                    else if (isNonSeparator(c)) return false;
                break;
                case 4:
                    if      (c == '1') state = 5;
                    else if (isNonSeparator(c)) return false;
                break;
                case 1:
                case 3:
                case 5:
                    if      (isISODigit(c)) state = 6;
                    else if (isNonSeparator(c)) return false;
                break;
                case 6:
                case 7:
                    if      (isISODigit(c)) state++;
                    else if (isNonSeparator(c)) return false;
                break;
                default:
                    if (isNonSeparator(c)) return false;
            }
        }
        return state == 6 || state == 7 || state == 8;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "B4C70E997EC0CC2FE1FB1672C0894635", hash_generated_method = "21CC7EDAE46841C772E9773A5857CEF0")
    private static boolean matchTrunkPrefix(String a, int len) {
        boolean found;
        found = false;
        for (int i = 0 ; i < len ; i++) {
            char c = a.charAt(i);
            if (c == '0' && !found) {
                found = true;
            } else if (isNonSeparator(c)) {
                return false;
            }
        }
        return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "DC8924E535E3BE7CAEA9A9E1FDE1AD0C", hash_generated_method = "33E44EBFF435564B163E850435844C94")
    private static boolean isCountryCallingCode(int countryCallingCodeCandidate) {
        return countryCallingCodeCandidate > 0 && countryCallingCodeCandidate < CCC_LENGTH &&
                COUNTRY_CALLING_CALL[countryCallingCodeCandidate];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "076AF69FA4452B4975423A6D4D7C01B2", hash_generated_method = "DC94DD6546D86B4681C6341FA8C70624")
    private static int tryGetISODigit(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return -1;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "06EBA22D5380C04BCA1473269198766F", hash_generated_method = "32BFDB40165F796935C81BDAC227AB15")
    private static CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex(
        String str, boolean acceptThailandCase) {
        int state = 0;
        int ccc = 0;
        final int length = str.length();
        for (int i = 0 ; i < length ; i++ ) {
            char ch = str.charAt(i);
            switch (state) {
                case 0:
                    if      (ch == '+') state = 1;
                    else if (ch == '0') state = 2;
                    else if (ch == '1') {
                        if (acceptThailandCase) {
                            state = 8;
                        } else {
                            return null;
                        }
                    } else if (isDialable(ch)) {
                        return null;
                    }
                break;
                case 2:
                    if      (ch == '0') state = 3;
                    else if (ch == '1') state = 4;
                    else if (isDialable(ch)) {
                        return null;
                    }
                break;
                case 4:
                    if      (ch == '1') state = 5;
                    else if (isDialable(ch)) {
                        return null;
                    }
                break;
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                    {
                        int ret = tryGetISODigit(ch);
                        if (ret > 0) {
                            ccc = ccc * 10 + ret;
                            if (ccc >= 100 || isCountryCallingCode(ccc)) {
                                return new CountryCallingCodeAndNewIndex(ccc, i + 1);
                            }
                            if (state == 1 || state == 3 || state == 5) {
                                state = 6;
                            } else {
                                state++;
                            }
                        } else if (isDialable(ch)) {
                            return null;
                        }
                    }
                    break;
                case 8:
                    if (ch == '6') state = 9;
                    else if (isDialable(ch)) {
                        return null;
                    }
                    break;
                case 9:
                    if (ch == '6') {
                        return new CountryCallingCodeAndNewIndex(66, i + 1);
                    } else {
                        return null;
                    }
                default:
                    return null;
            }
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "66C826C8182942443823887EE81BC356", hash_generated_method = "351CEC1938395954E97E0058ADAC50B4")
    private static int tryGetTrunkPrefixOmittedIndex(String str, int currentIndex) {
        int length = str.length();
        for (int i = currentIndex ; i < length ; i++) {
            final char ch = str.charAt(i);
            if (tryGetISODigit(ch) >= 0) {
                return i + 1;
            } else if (isDialable(ch)) {
                return -1;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "142EC47724C15FE9B1D0347516282D9A", hash_generated_method = "3D7885C34798D73F29C97D509AD9144B")
    private static boolean checkPrefixIsIgnorable(final String str,
            int forwardIndex, int backwardIndex) {
        boolean trunk_prefix_was_read = false;
        while (backwardIndex >= forwardIndex) {
            if (tryGetISODigit(str.charAt(backwardIndex)) >= 0) {
                if (trunk_prefix_was_read) {
                    return false;
                } else {
                    trunk_prefix_was_read = true;
                }
            } else if (isDialable(str.charAt(backwardIndex))) {
                return false;
            }
            backwardIndex--;
        }
        return true;
    }

    
    private static class CountryCallingCodeAndNewIndex {
        public final int countryCallingCode;
        public final int newIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.540 -0400", hash_original_method = "5DCA5F364592872E4B4A5AF571961FBD", hash_generated_method = "D6BBA71BC8FAC0D9D027D17C45177149")
        @DSModeled(DSC.SAFE)
        public CountryCallingCodeAndNewIndex(int countryCode, int newIndex) {
            dsTaint.addTaint(countryCode);
            dsTaint.addTaint(newIndex);
            // ---------- Original Method ----------
            //this.countryCallingCode = countryCode;
            //this.newIndex = newIndex;
        }

        
    }


    
    static {
        KEYPAD_MAP.put('a', '2'); KEYPAD_MAP.put('b', '2'); KEYPAD_MAP.put('c', '2');
        KEYPAD_MAP.put('A', '2'); KEYPAD_MAP.put('B', '2'); KEYPAD_MAP.put('C', '2');
        KEYPAD_MAP.put('d', '3'); KEYPAD_MAP.put('e', '3'); KEYPAD_MAP.put('f', '3');
        KEYPAD_MAP.put('D', '3'); KEYPAD_MAP.put('E', '3'); KEYPAD_MAP.put('F', '3');
        KEYPAD_MAP.put('g', '4'); KEYPAD_MAP.put('h', '4'); KEYPAD_MAP.put('i', '4');
        KEYPAD_MAP.put('G', '4'); KEYPAD_MAP.put('H', '4'); KEYPAD_MAP.put('I', '4');
        KEYPAD_MAP.put('j', '5'); KEYPAD_MAP.put('k', '5'); KEYPAD_MAP.put('l', '5');
        KEYPAD_MAP.put('J', '5'); KEYPAD_MAP.put('K', '5'); KEYPAD_MAP.put('L', '5');
        KEYPAD_MAP.put('m', '6'); KEYPAD_MAP.put('n', '6'); KEYPAD_MAP.put('o', '6');
        KEYPAD_MAP.put('M', '6'); KEYPAD_MAP.put('N', '6'); KEYPAD_MAP.put('O', '6');
        KEYPAD_MAP.put('p', '7'); KEYPAD_MAP.put('q', '7'); KEYPAD_MAP.put('r', '7'); KEYPAD_MAP.put('s', '7');
        KEYPAD_MAP.put('P', '7'); KEYPAD_MAP.put('Q', '7'); KEYPAD_MAP.put('R', '7'); KEYPAD_MAP.put('S', '7');
        KEYPAD_MAP.put('t', '8'); KEYPAD_MAP.put('u', '8'); KEYPAD_MAP.put('v', '8');
        KEYPAD_MAP.put('T', '8'); KEYPAD_MAP.put('U', '8'); KEYPAD_MAP.put('V', '8');
        KEYPAD_MAP.put('w', '9'); KEYPAD_MAP.put('x', '9'); KEYPAD_MAP.put('y', '9'); KEYPAD_MAP.put('z', '9');
        KEYPAD_MAP.put('W', '9'); KEYPAD_MAP.put('X', '9'); KEYPAD_MAP.put('Y', '9'); KEYPAD_MAP.put('Z', '9');
    }
    
}


