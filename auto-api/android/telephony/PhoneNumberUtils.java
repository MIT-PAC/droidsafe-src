package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.504 -0400", hash_original_method = "938930684BD6A2B19115CAC83A3A947F", hash_generated_method = "938930684BD6A2B19115CAC83A3A947F")
        public PhoneNumberUtils ()
    {
    }


        public static boolean isISODigit(char c) {
        return c >= '0' && c <= '9';
    }

    
        public final static boolean is12Key(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#';
    }

    
        public final static boolean isDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+' || c == WILD;
    }

    
        public final static boolean isReallyDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+';
    }

    
        public final static boolean isNonSeparator(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+'
                || c == WILD || c == WAIT || c == PAUSE;
    }

    
        public final static boolean isStartsPostDial(char c) {
        return c == PAUSE || c == WAIT;
    }

    
        private static boolean isPause(char c) {
        return c == 'p'||c == 'P';
    }

    
        private static boolean isToneWait(char c) {
        return c == 'w'||c == 'W';
    }

    
        private static boolean isSeparator(char ch) {
        return !isDialable(ch) && !(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'));
    }

    
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

    
        public static String extractNetworkPortionAlt(String phoneNumber) {
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

    
        private static void log(String msg) {
        Log.d(LOG_TAG, msg);
    }

    
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

    
        public static boolean compare(String a, String b) {
        return compare(a, b, false);
    }

    
        public static boolean compare(Context context, String a, String b) {
        boolean useStrict = context.getResources().getBoolean(
               com.android.internal.R.bool.config_use_strict_phone_number_comparation);
        return compare(a, b, useStrict);
    }

    
        public static boolean compare(String a, String b, boolean useStrictComparation) {
        return (useStrictComparation ? compareStrictly(a, b) : compareLoosely(a, b));
    }

    
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

    
        public static boolean compareStrictly(String a, String b) {
        return compareStrictly(a, b, true);
    }

    
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

    
        public static String toCallerIDMinMatch(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);
        return internalGetStrippedReversed(np, MIN_MATCH);
    }

    
        public static String getStrippedReversed(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);
        if (np == null) return null;
        return internalGetStrippedReversed(np, np.length());
    }

    
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

    
        public static String stringFromStringAndTOA(String s, int TOA) {
        if (s == null) return null;
        if (TOA == TOA_International && s.length() > 0 && s.charAt(0) != '+') {
            return "+" + s;
        }
        return s;
    }

    
        public static int toaFromString(String s) {
        if (s != null && s.length() > 0 && s.charAt(0) == '+') {
            return TOA_International;
        }
        return TOA_Unknown;
    }

    
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

    
        public static String calledPartyBCDFragmentToString(byte [] bytes, int offset, int length) {
        StringBuilder ret = new StringBuilder(length * 2);
        internalCalledPartyBCDFragmentToString(ret, bytes, offset, length);
        return ret.toString();
    }

    
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

    
        public static boolean isWellFormedSmsAddress(String address) {
        String networkPortion =
                PhoneNumberUtils.extractNetworkPortion(address);
        return (!(networkPortion.equals("+")
                  || TextUtils.isEmpty(networkPortion)))
               && isDialable(networkPortion);
    }

    
        public static boolean isGlobalPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }
        Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return match.matches();
    }

    
        private static boolean isDialable(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isDialable(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
        private static boolean isNonSeparator(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isNonSeparator(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    
        public static byte[] networkPortionToCalledPartyBCD(String s) {
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, false);
    }

    
        public static byte[] networkPortionToCalledPartyBCDWithLength(String s) {
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, true);
    }

    
        public static byte[] numberToCalledPartyBCD(String number) {
        return numberToCalledPartyBCDHelper(number, false);
    }

    
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

    
        public static String formatNumber(String source) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, getFormatTypeForLocale(Locale.getDefault()));
        return text.toString();
    }

    
        public static String formatNumber(String source, int defaultFormattingType) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, defaultFormattingType);
        return text.toString();
    }

    
        public static int getFormatTypeForLocale(Locale locale) {
        String country = locale.getCountry();
        return getFormatTypeFromCountryCode(country);
    }

    
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

    
        public static void formatJapaneseNumber(Editable text) {
        JapanesePhoneNumberFormatter.format(text);
    }

    
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

    
        public static boolean isEmergencyNumber(String number) {
        return isEmergencyNumberInternal(number, true );
    }

    
        public static boolean isPotentialEmergencyNumber(String number) {
        return isEmergencyNumberInternal(number, false );
    }

    
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

    
        public static boolean isEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         true );
    }

    
        public static boolean isPotentialEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         false );
    }

    
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

    
        public static boolean isLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              true );
    }

    
        public static boolean isPotentialLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              false );
    }

    
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

    
        private static String getDefaultIdp( ) {
        String ps = null;
        SystemProperties.get(PROPERTY_IDP_STRING, ps);
        if (TextUtils.isEmpty(ps)) {
            ps = NANP_IDP_STRING;
        }
        return ps;
    }

    
        private static boolean isTwoToNine(char c) {
        if (c >= '2' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    
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

    
        public static boolean isUriNumber(String number) {
        return number != null && (number.contains("@") || number.contains("%40"));
    }

    
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

    
        private static int findDialableIndexFromPostDialStr(String postDialStr) {
        for (int index = 0;index < postDialStr.length();index++) {
             char c = postDialStr.charAt(index);
             if (isReallyDialable(c)) {
                return index;
             }
        }
        return -1;
    }

    
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

    
        private static boolean isCountryCallingCode(int countryCallingCodeCandidate) {
        return countryCallingCodeCandidate > 0 && countryCallingCodeCandidate < CCC_LENGTH &&
                COUNTRY_CALLING_CALL[countryCallingCodeCandidate];
    }

    
        private static int tryGetISODigit(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return -1;
        }
    }

    
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
        public int countryCallingCode;
        public int newIndex;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.523 -0400", hash_original_method = "5DCA5F364592872E4B4A5AF571961FBD", hash_generated_method = "554DFED27B2BAC67C6F12B17A9A14D54")
        @DSModeled(DSC.SAFE)
        public CountryCallingCodeAndNewIndex(int countryCode, int newIndex) {
            dsTaint.addTaint(countryCode);
            dsTaint.addTaint(newIndex);
            // ---------- Original Method ----------
            //this.countryCallingCode = countryCode;
            //this.newIndex = newIndex;
        }

        
    }


    
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
}

