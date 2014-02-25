package android.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_ICC_OPERATOR_ISO_COUNTRY;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_IDP_STRING;
import static com.android.internal.telephony.TelephonyProperties.PROPERTY_OPERATOR_ISO_COUNTRY;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneNumberUtils {

    /** True if c is ISO-LATIN characters 0-9 */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.330 -0500", hash_original_method = "8DDD4F1B3EBA46E6AD9B7725CB8B68AA", hash_generated_method = "0046DE65F5CD007858ACDC75E81673B2")
    
public static boolean
    isISODigit (char c) {
        return c >= '0' && c <= '9';
    }

    /** True if c is ISO-LATIN characters 0-9, *, # */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.333 -0500", hash_original_method = "1F784E81F2EDB796AFED78AD0553EEBB", hash_generated_method = "CF2B33FE12DFFCA467EB4D8132098B98")
    
public final static boolean
    is12Key(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#';
    }

    /** True if c is ISO-LATIN characters 0-9, *, # , +, WILD  */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.338 -0500", hash_original_method = "862168FA5BAB349E5C10CD857946505D", hash_generated_method = "E03AFF4D69A7D2042BC424EE0AB65B98")
    
public final static boolean
    isDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+' || c == WILD;
    }

    /** True if c is ISO-LATIN characters 0-9, *, # , + (no WILD)  */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.342 -0500", hash_original_method = "6972D922287D01B71E2745DD45EB4146", hash_generated_method = "5E9A9C7FD8A953A20EB598C331BCC83F")
    
public final static boolean
    isReallyDialable(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+';
    }

    /** True if c is ISO-LATIN characters 0-9, *, # , +, WILD, WAIT, PAUSE   */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.345 -0500", hash_original_method = "B7263687C68C93D629EB8C9647AA7093", hash_generated_method = "CD4254960B8C26FE0B0A2F5E8C89E642")
    
public final static boolean
    isNonSeparator(char c) {
        return (c >= '0' && c <= '9') || c == '*' || c == '#' || c == '+'
                || c == WILD || c == WAIT || c == PAUSE;
    }

    /** This any anything to the right of this char is part of the
     *  post-dial string (eg this is PAUSE or WAIT)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.349 -0500", hash_original_method = "E56C1DBFA6D115BECC52B4F023195FFE", hash_generated_method = "98D37AC4AE7F45F8ACA53A1010D4A644")
    
public final static boolean
    isStartsPostDial (char c) {
        return c == PAUSE || c == WAIT;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.352 -0500", hash_original_method = "F868AE21EB899FB020DEBC936A6E152B", hash_generated_method = "45D8A4D90DFC1AA886B53ECAF916CC8F")
    
private static boolean
    isPause (char c){
        return c == 'p'||c == 'P';
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.355 -0500", hash_original_method = "77D30713D05D4ED1DFAEEC063717084F", hash_generated_method = "3DE7FDC95044758285A39F217E3251C6")
    
private static boolean
    isToneWait (char c){
        return c == 'w'||c == 'W';
    }

    /** Returns true if ch is not dialable or alpha char */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.358 -0500", hash_original_method = "85CF1420537B9541711C4FCF41BF1A25", hash_generated_method = "1F51162AE5FD7B556E7AFBCB3F1A3D3C")
    
private static boolean isSeparator(char ch) {
        return !isDialable(ch) && !(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'));
    }

    /** Extracts the phone number from an Intent.
     *
     * @param intent the intent to get the number of
     * @param context a context to use for database access
     *
     * @return the phone number that would be called by the intent, or
     *         <code>null</code> if the number cannot be found.
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.363 -0500", hash_original_method = "E0640A2FD798FB776FD3E9A9E45506D7", hash_generated_method = "E3C6CFE82D3887F98159B08DA505B9A0")
    
public static String getNumberFromIntent(Intent intent, Context context) {
        String number = null;

        Uri uri = intent.getData();
        String scheme = uri.getScheme();

        if (scheme.equals("tel") || scheme.equals("sip")) {
            return uri.getSchemeSpecificPart();
        }

        // TODO: We don't check for SecurityException here (requires
        // CALL_PRIVILEGED permission).
        if (scheme.equals("voicemail")) {
            return TelephonyManager.getDefault().getCompleteVoiceMailNumber();
        }

        if (context == null) {
            return null;
        }

        String type = intent.resolveType(context);
        String phoneColumn = null;

        // Correctly read out the phone entry based on requested provider
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

    /** Extracts the network address portion and canonicalizes
     *  (filters out separators.)
     *  Network address portion is everything up to DTMF control digit
     *  separators (pause or wait), but without non-dialable characters.
     *
     *  Please note that the GSM wild character is allowed in the result.
     *  This must be resolved before dialing.
     *
     *  Returns null if phoneNumber == null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.367 -0500", hash_original_method = "85594AF52A8DC28CABB86FCCC3D624C3", hash_generated_method = "D20666622A0B86A22EA9D270C887E52F")
    
public static String
    extractNetworkPortion(String phoneNumber) {
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

    /**
     * Extracts the network address portion and canonicalize.
     *
     * This function is equivalent to extractNetworkPortion(), except
     * for allowing the PLUS character to occur at arbitrary positions
     * in the address portion, not just the first position.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.371 -0500", hash_original_method = "8E0188E751AB8076E783C3AD5EFABF59", hash_generated_method = "D119BB75F3BE6BD72E10D84892164EBE")
    
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

    /**
     * Strips separators from a phone number string.
     * @param phoneNumber phone number to strip.
     * @return phone string stripped of separators.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.374 -0500", hash_original_method = "232A1CFA6D80CA7330EFAD4BFAE5B761", hash_generated_method = "FD34A2227005D779019D5DA5D9DC12A9")
    
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

    /**
     * Converts pause and tonewait pause characters
     * to Android representation.
     * RFC 3601 says pause is 'p' and tonewait is 'w'.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.378 -0500", hash_original_method = "212FDF834FF8F6725237F29A41B6704B", hash_generated_method = "46C0413BA03B9DE945DBF06FA8B5E0CE")
    
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

    /** or -1 if both are negative */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.382 -0500", hash_original_method = "45612293FA8EEDD0211FEABD43E17C97", hash_generated_method = "3C831CA419EC7CE3748EE0A6F05278B1")
    
static private int
    minPositive (int a, int b) {
        if (a >= 0 && b >= 0) {
            return (a < b) ? a : b;
        } else if (a >= 0) { /* && b < 0 */
            return a;
        } else if (b >= 0) { /* && a < 0 */
            return b;
        } else { /* a < 0 && b < 0 */
            return -1;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.385 -0500", hash_original_method = "DB05E60B51779EDEE5A85D6BA3688CBD", hash_generated_method = "73D02F89C31E4EF7887EA5B6EB937838")
    
private static void log(String msg) {
        Log.d(LOG_TAG, msg);
    }
    /** index of the last character of the network portion
     *  (eg anything after is a post-dial string)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.388 -0500", hash_original_method = "CA3503A44AF2EBF75D9BE6634816F5BD", hash_generated_method = "2F1D840268C9E28C26FC89221FEC809F")
    
static private int
    indexOfLastNetworkChar(String a) {
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

    /** GSM codes
     *  Finds if a GSM code includes the international prefix (+).
     *
     * @param number the number to dial.
     *
     * @return the position where the + char will be inserted, -1 if the GSM code was not found.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.392 -0500", hash_original_method = "5412F78A6FFD23BF6E67569C9C7086D9", hash_generated_method = "A1A47654BACAD454A83B86CF81070850")
    
private static int
    addPlusChar(String number) {
        int pos = -1;

        if (number.startsWith(CLIR_OFF)) {
            pos = CLIR_OFF.length() - 1;
        }

        if (number.startsWith(CLIR_ON)) {
            pos = CLIR_ON.length() - 1;
        }

        return pos;
    }

    /**
     * Extracts the post-dial sequence of DTMF control digits, pauses, and
     * waits. Strips separators. This string may be empty, but will not be null
     * unless phoneNumber == null.
     *
     * Returns null if phoneNumber == null
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.396 -0500", hash_original_method = "4F2019AF1701903E5EF27732AE7CF8E2", hash_generated_method = "16E2097032ADBC16FC2957CA6B31353D")
    
public static String
    extractPostDialPortion(String phoneNumber) {
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

    /**
     * Compare phone numbers a and b, return true if they're identical enough for caller ID purposes.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.399 -0500", hash_original_method = "448A5F7926670D54885C01A1388DB100", hash_generated_method = "19F13777886CC7C0DB1DF14622F244BF")
    
public static boolean compare(String a, String b) {
        // We've used loose comparation at least Eclair, which may change in the future.

        return compare(a, b, false);
    }

    /**
     * Compare phone numbers a and b, and return true if they're identical
     * enough for caller ID purposes. Checks a resource to determine whether
     * to use a strict or loose comparison algorithm.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.403 -0500", hash_original_method = "FAC0E437D1666841C3F351749EE85C53", hash_generated_method = "4D0435CC2E5475DDCCDB8B40A240E271")
    
public static boolean compare(Context context, String a, String b) {
        boolean useStrict = context.getResources().getBoolean(
               com.android.internal.R.bool.config_use_strict_phone_number_comparation);
        return compare(a, b, useStrict);
    }

    /**
     * @hide only for testing.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.406 -0500", hash_original_method = "367B284A9371AD494F48AAD9523ABA01", hash_generated_method = "A806BE37D44FCFF0044AFFEDBF82AE71")
    
public static boolean compare(String a, String b, boolean useStrictComparation) {
        return (useStrictComparation ? compareStrictly(a, b) : compareLoosely(a, b));
    }

    /**
     * Compare phone numbers a and b, return true if they're identical
     * enough for caller ID purposes.
     *
     * - Compares from right to left
     * - requires MIN_MATCH (7) characters to match
     * - handles common trunk prefixes and international prefixes
     *   (basically, everything except the Russian trunk prefix)
     *
     * Note that this method does not return false even when the two phone numbers
     * are not exactly same; rather; we can call this method "similar()", not "equals()".
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.412 -0500", hash_original_method = "8F5CD7EECBE2A2BA521BCB26962910D6", hash_generated_method = "E466FD376B9C60C0AEA7E8D5D7A10988")
    
public static boolean
    compareLoosely(String a, String b) {
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

            // if the number of dialable chars in a and b match, but the matched chars < MIN_MATCH,
            // treat them as equal (i.e. 404-04 and 40404)
            if (effectiveALen == effectiveBLen && effectiveALen == matched) {
                return true;
            }

            return false;
        }

        // At least one string has matched completely;
        if (matched >= MIN_MATCH && (ia < 0 || ib < 0)) {
            return true;
        }

        /*
         * Now, what remains must be one of the following for a
         * match:
         *
         *  - a '+' on one and a '00' or a '011' on the other
         *  - a '0' on one and a (+,00)<country code> on the other
         *     (for this, a '0' and a '00' prefix would have succeeded above)
         */

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

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.415 -0500", hash_original_method = "4C9BF85CCF4A05C05A692B20618E9342", hash_generated_method = "05FC5A7C9C29FF6AEB98920AB607EA82")
    
public static boolean
    compareStrictly(String a, String b) {
        return compareStrictly(a, b, true);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.422 -0500", hash_original_method = "4EDBDF4132895DDD5559995EAE3F6530", hash_generated_method = "4D0891F5C76129CA3A768E1B9208AA41")
    
public static boolean
    compareStrictly(String a, String b, boolean acceptInvalidCCCPrefix) {
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
                // Different Country Calling Code. Must be different phone number.
                return false;
            }
            // When both have ccc, do not ignore trunk prefix. Without this,
            // "+81123123" becomes same as "+810123123" (+81 == Japan)
            okToIgnorePrefix = false;
            bothHasCountryCallingCode = true;
            forwardIndexA = cccA.newIndex;
            forwardIndexB = cccB.newIndex;
        } else if (cccA == null && cccB == null) {
            // When both do not have ccc, do not ignore trunk prefix. Without this,
            // "123123" becomes same as "0123123"
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
                    // Maybe the code handling the special case for Thailand makes the
                    // result garbled, so disable the code and try again.
                    // e.g. "16610001234" must equal to "6610001234", but with
                    //      Thailand-case handling code, they become equal to each other.
                    //
                    // Note: we select simplicity rather than adding some complicated
                    //       logic here for performance(like "checking whether remaining
                    //       numbers are just 66 or not"), assuming inputs are small
                    //       enough.
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
            // In the US, 1-650-555-1234 must be equal to 650-555-1234,
            // while 090-1234-1234 must not be equal to 90-1234-1234 in Japan.
            // This request exists just in US (with 1 trunk (NDD) prefix).
            // In addition, "011 11 7005554141" must not equal to "+17005554141",
            // while "011 1 7005554141" must equal to "+17005554141"
            //
            // In this comparison, we ignore the prefix '1' just once, when
            // - at least either does not have CCC, or
            // - the remaining non-separator number is 1
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

    /**
     * Returns the rightmost MIN_MATCH (5) characters in the network portion
     * in *reversed* order
     *
     * This can be used to do a database lookup against the column
     * that stores getStrippedReversed()
     *
     * Returns null if phoneNumber == null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.425 -0500", hash_original_method = "930DD52B84605C74F4CF39C7CC283746", hash_generated_method = "25376D0D6F4E43BFA7DF4F7F9D511468")
    
public static String
    toCallerIDMinMatch(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);
        return internalGetStrippedReversed(np, MIN_MATCH);
    }

    /**
     * Returns the network portion reversed.
     * This string is intended to go into an index column for a
     * database lookup.
     *
     * Returns null if phoneNumber == null
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.430 -0500", hash_original_method = "D2BEAEC3FE32EF1C76508600B5DF4065", hash_generated_method = "88CDDE2AB55F2970EE715A7DD4A18D76")
    
public static String
    getStrippedReversed(String phoneNumber) {
        String np = extractNetworkPortionAlt(phoneNumber);

        if (np == null) return null;

        return internalGetStrippedReversed(np, np.length());
    }

    /**
     * Returns the last numDigits of the reversed phone number
     * Returns null if np == null
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.433 -0500", hash_original_method = "D354471DE97D7AAEA65C4CC9D8664F81", hash_generated_method = "6B46BEC57DF751E8331C0A6B42230C36")
    
private static String
    internalGetStrippedReversed(String np, int numDigits) {
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

    /**
     * Basically: makes sure there's a + in front of a
     * TOA_International number
     *
     * Returns null if s == null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.436 -0500", hash_original_method = "DA26E8679FA547BA71428FCE4B001FC5", hash_generated_method = "821B809869E5DBFA77CA94C895EDB626")
    
public static String
    stringFromStringAndTOA(String s, int TOA) {
        if (s == null) return null;

        if (TOA == TOA_International && s.length() > 0 && s.charAt(0) != '+') {
            return "+" + s;
        }

        return s;
    }

    /**
     * Returns the TOA for the given dial string
     * Basically, returns TOA_International if there's a + prefix
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.440 -0500", hash_original_method = "742B342269A43CEE9B6B4FB04BAA47B5", hash_generated_method = "0A7ABDB13E39D8843019F448D0B1F42C")
    
public static int
    toaFromString(String s) {
        if (s != null && s.length() > 0 && s.charAt(0) == '+') {
            return TOA_International;
        }

        return TOA_Unknown;
    }

    /**
     *  3GPP TS 24.008 10.5.4.7
     *  Called Party BCD Number
     *
     *  See Also TS 51.011 10.5.1 "dialing number/ssc string"
     *  and TS 11.11 "10.3.1 EF adn (Abbreviated dialing numbers)"
     *
     * @param bytes the data buffer
     * @param offset should point to the TOA (aka. TON/NPI) octet after the length byte
     * @param length is the number of bytes including TOA byte
     *                and must be at least 2
     *
     * @return partial string on invalid decode
     *
     * FIXME(mkf) support alphanumeric address type
     *  currently implemented in SMSMessage.getAddress()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.446 -0500", hash_original_method = "370BD6969A31137A90CC0B60704C81A4", hash_generated_method = "B76F40EA234CA6A63A1A5C4741829C5E")
    
public static String
    calledPartyBCDToString (byte[] bytes, int offset, int length) {
        boolean prependPlus = false;
        StringBuilder ret = new StringBuilder(1 + length * 2);

        if (length < 2) {
            return "";
        }

        //Only TON field should be taken in consideration
        if ((bytes[offset] & 0xf0) == (TOA_International & 0xf0)) {
            prependPlus = true;
        }

        internalCalledPartyBCDFragmentToString(
                ret, bytes, offset + 1, length - 1);

        if (prependPlus && ret.length() == 0) {
            // If the only thing there is a prepended plus, return ""
            return "";
        }

        if (prependPlus) {
            // This is an "international number" and should have
            // a plus prepended to the dialing number. But there
            // can also be GSM MMI codes as defined in TS 22.030 6.5.2
            // so we need to handle those also.
            //
            // http://web.telia.com/~u47904776/gsmkode.htm
            // has a nice list of some of these GSM codes.
            //
            // Examples are:
            //   **21*+886988171479#
            //   **21*8311234567#
            //   *21#
            //   #21#
            //   *#21#
            //   *31#+11234567890
            //   #31#+18311234567
            //   #31#8311234567
            //   18311234567
            //   +18311234567#
            //   +18311234567
            // Odd ball cases that some phones handled
            // where there is no dialing number so they
            // append the "+"
            //   *21#+
            //   **21#+
            String retString = ret.toString();
            Pattern p = Pattern.compile("(^[#*])(.*)([#*])(.*)(#)$");
            Matcher m = p.matcher(retString);
            if (m.matches()) {
                if ("".equals(m.group(2))) {
                    // Started with two [#*] ends with #
                    // So no dialing number and we'll just
                    // append a +, this handles **21#+
                    ret = new StringBuilder();
                    ret.append(m.group(1));
                    ret.append(m.group(3));
                    ret.append(m.group(4));
                    ret.append(m.group(5));
                    ret.append("+");
                } else {
                    // Starts with [#*] and ends with #
                    // Assume group 4 is a dialing number
                    // such as *21*+1234554#
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
                    // Starts with [#*] and only one other [#*]
                    // Assume the data after last [#*] is dialing
                    // number (i.e. group 4) such as *31#+11234567890.
                    // This also includes the odd ball *21#+
                    ret = new StringBuilder();
                    ret.append(m.group(1));
                    ret.append(m.group(2));
                    ret.append(m.group(3));
                    ret.append("+");
                    ret.append(m.group(4));
                } else {
                    // Does NOT start with [#*] just prepend '+'
                    ret = new StringBuilder();
                    ret.append('+');
                    ret.append(retString);
                }
            }
        }

        return ret.toString();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.450 -0500", hash_original_method = "1DA55FF5FC6AC864C1B47D3450B3A6D6", hash_generated_method = "4BC5BAFB70888ACA5A632C4653E2EF6C")
    
private static void
    internalCalledPartyBCDFragmentToString(
        StringBuilder sb, byte [] bytes, int offset, int length) {
        for (int i = offset ; i < length + offset ; i++) {
            byte b;
            char c;

            c = bcdToChar((byte)(bytes[i] & 0xf));

            if (c == 0) {
                return;
            }
            sb.append(c);

            // FIXME(mkf) TS 23.040 9.1.2.3 says
            // "if a mobile receives 1111 in a position prior to
            // the last semi-octet then processing shall commence with
            // the next semi-octet and the intervening
            // semi-octet shall be ignored"
            // How does this jive with 24.008 10.5.4.7

            b = (byte)((bytes[i] >> 4) & 0xf);

            if (b == 0xf && i + 1 == length + offset) {
                //ignore final 0xf
                break;
            }

            c = bcdToChar(b);
            if (c == 0) {
                return;
            }

            sb.append(c);
        }

    }

    /**
     * Like calledPartyBCDToString, but field does not start with a
     * TOA byte. For example: SIM ADN extension fields
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.454 -0500", hash_original_method = "AC6F2BD2CEECA2EAA4423AB8E7E6F05C", hash_generated_method = "56F2D1EF60CB50C41C74D9436CBA7553")
    
public static String
    calledPartyBCDFragmentToString(byte [] bytes, int offset, int length) {
        StringBuilder ret = new StringBuilder(length * 2);

        internalCalledPartyBCDFragmentToString(ret, bytes, offset, length);

        return ret.toString();
    }

    /** returns 0 on invalid value */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.458 -0500", hash_original_method = "6BBF92D1C6E8D0EDE6C4F442992FDCAA", hash_generated_method = "D96361B18913B1B8DF9154B1BFF13F95")
    
private static char
    bcdToChar(byte b) {
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.462 -0500", hash_original_method = "D9B38AE621A94A7D136B7ACCE59CB7FC", hash_generated_method = "F3FBFED8F593EBD723AB49B6A7ADA562")
    
private static int
    charToBCD(char c) {
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

    /**
     * Return true iff the network portion of <code>address</code> is,
     * as far as we can tell on the device, suitable for use as an SMS
     * destination address.
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.466 -0500", hash_original_method = "A988E80FBF926E38476CB13622AE0017", hash_generated_method = "7C5E5705B6EC3452A5193A1A55FAF86A")
    
public static boolean isWellFormedSmsAddress(String address) {
        String networkPortion =
                PhoneNumberUtils.extractNetworkPortion(address);

        return (!(networkPortion.equals("+")
                  || TextUtils.isEmpty(networkPortion)))
               && isDialable(networkPortion);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.469 -0500", hash_original_method = "9FED45E4C5931DED3A7CDAD84E36E48F", hash_generated_method = "CF57E3F57F0DA5634424CBA3CD5763CA")
    
public static boolean isGlobalPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }

        Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return match.matches();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.473 -0500", hash_original_method = "F10D97D241B233A1AD5555B2D68CA84D", hash_generated_method = "0F9D58D8547059E91A29E5A581488E6B")
    
private static boolean isDialable(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isDialable(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.477 -0500", hash_original_method = "164C0FF3751154C0A9BD1D63E5C99981", hash_generated_method = "15BB8E90268AD9473CDFF40B889D0D32")
    
private static boolean isNonSeparator(String address) {
        for (int i = 0, count = address.length(); i < count; i++) {
            if (!isNonSeparator(address.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /**
     * Note: calls extractNetworkPortion(), so do not use for
     * SIM EF[ADN] style records
     *
     * Returns null if network portion is empty.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.480 -0500", hash_original_method = "AF7754C02AEA7A015FB424C581D10AD2", hash_generated_method = "FD9BF84B8C812B5C208BF3E65AA98275")
    
public static byte[]
    networkPortionToCalledPartyBCD(String s) {
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, false);
    }

    /**
     * Same as {@link #networkPortionToCalledPartyBCD}, but includes a
     * one-byte length prefix.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.484 -0500", hash_original_method = "53FAAB919D090E6E7EF0B0376A95BD6B", hash_generated_method = "A6151625BD87F00B194EBC8CCF6C1190")
    
public static byte[]
    networkPortionToCalledPartyBCDWithLength(String s) {
        String networkPortion = extractNetworkPortion(s);
        return numberToCalledPartyBCDHelper(networkPortion, true);
    }

    /**
     * Convert a dialing number to BCD byte array
     *
     * @param number dialing number string
     *        if the dialing number starts with '+', set to international TOA
     * @return BCD byte array
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.487 -0500", hash_original_method = "46011790469F97E3B0CE4186D5C8E763", hash_generated_method = "235F8733C111298DA75197392233021F")
    
public static byte[]
    numberToCalledPartyBCD(String number) {
        return numberToCalledPartyBCDHelper(number, false);
    }

    /**
     * If includeLength is true, prepend a one-byte length value to
     * the return array.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.491 -0500", hash_original_method = "3389153632676598B3C0211E28EEF1DE", hash_generated_method = "09BFC38811F1849F3C035834F695D5CF")
    
private static byte[]
    numberToCalledPartyBCDHelper(String number, boolean includeLength) {
        int numberLenReal = number.length();
        int numberLenEffective = numberLenReal;
        boolean hasPlus = number.indexOf('+') != -1;
        if (hasPlus) numberLenEffective--;

        if (numberLenEffective == 0) return null;

        int resultLen = (numberLenEffective + 1) / 2;  // Encoded numbers require only 4 bits each.
        int extraBytes = 1;                            // Prepended TOA byte.
        if (includeLength) extraBytes++;               // Optional prepended length byte.
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

        // 1-fill any trailing odd nibble/quartet.
        if ((digitCount & 0x01) == 1) result[extraBytes + (digitCount >> 1)] |= 0xF0;

        int offset = 0;
        if (includeLength) result[offset++] = (byte)(resultLen - 1);
        result[offset] = (byte)(hasPlus ? TOA_International : TOA_Unknown);

        return result;
    }

    /**
     * Breaks the given number down and formats it according to the rules
     * for the country the number is from.
     *
     * @param source The phone number to format
     * @return A locally acceptable formatting of the input, or the raw input if
     *  formatting rules aren't known for the number
     */
    @DSComment("Utility function")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.510 -0500", hash_original_method = "F559913F36966A96ABB20C01E67F5DD8", hash_generated_method = "AB4056F3A6E3A769AE23A235BAD6EBBE")
    
public static String formatNumber(String source) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, getFormatTypeForLocale(Locale.getDefault()));
        return text.toString();
    }

    /**
     * Formats the given number with the given formatting type. Currently
     * {@link #FORMAT_NANP} and {@link #FORMAT_JAPAN} are supported as a formating type.
     *
     * @param source the phone number to format
     * @param defaultFormattingType The default formatting rules to apply if the number does
     * not begin with +[country_code]
     * @return The phone number formatted with the given formatting type.
     *
     * @hide TODO: Should be unhidden.
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.513 -0500", hash_original_method = "A28BEF976D7AD72608E8693C01B15E97", hash_generated_method = "1747FF79977D1D6D80FDB3C041399E3E")
    
public static String formatNumber(String source, int defaultFormattingType) {
        SpannableStringBuilder text = new SpannableStringBuilder(source);
        formatNumber(text, defaultFormattingType);
        return text.toString();
    }

    /**
     * Returns the phone number formatting type for the given locale.
     *
     * @param locale The locale of interest, usually {@link Locale#getDefault()}
     * @return The formatting type for the given locale, or FORMAT_UNKNOWN if the formatting
     * rules are not known for the given locale
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.516 -0500", hash_original_method = "2035A43BA247538550AB3B62E959FF45", hash_generated_method = "732EDFC543A716276529B9845579B8CC")
    
public static int getFormatTypeForLocale(Locale locale) {
        String country = locale.getCountry();

        return getFormatTypeFromCountryCode(country);
    }

    /**
     * Formats a phone number in-place. Currently {@link #FORMAT_JAPAN} and {@link #FORMAT_NANP}
     * is supported as a second argument.
     *
     * @param text The number to be formatted, will be modified with the formatting
     * @param defaultFormattingType The default formatting rules to apply if the number does
     * not begin with +[country_code]
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.520 -0500", hash_original_method = "F478444122BC83D34781A111CA26291E", hash_generated_method = "1A66F58E10D618B5AC146E8E7434C960")
    
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

    /**
     * Formats a phone number in-place using the NANP formatting rules. Numbers will be formatted
     * as:
     *
     * <p><code>
     * xxxxx
     * xxx-xxxx
     * xxx-xxx-xxxx
     * 1-xxx-xxx-xxxx
     * +1-xxx-xxx-xxxx
     * </code></p>
     *
     * @param text the number to be formatted, will be modified with the formatting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.540 -0500", hash_original_method = "375626B12DD2ECC6EA0EE4FF36348A38", hash_generated_method = "36ED22457B4A4433F7027CC629462ADA")
    
public static void formatNanpNumber(Editable text) {
        int length = text.length();
        if (length > "+1-nnn-nnn-nnnn".length()) {
            // The string is too long to be formatted
            return;
        } else if (length <= 5) {
            // The string is either a shortcode or too short to be formatted
            return;
        }

        CharSequence saved = text.subSequence(0, length);

        // Strip the dashes first, as we're going to add them back
        removeDashes(text);
        length = text.length();

        // When scanning the number we record where dashes need to be added,
        // if they're non-0 at the end of the scan the dashes will be added in
        // the proper places.
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
                    // fall through
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
                        // Only NANP number supported for now
                        text.replace(0, length, saved);
                        return;
                    } else if (state == NANP_STATE_ONE) {
                        // Found either +1 or 1, follow it up with a dash
                        dashPositions[numDashes++] = i;
                    } else if (state != NANP_STATE_DASH && (numDigits == 3 || numDigits == 6)) {
                        // Found a digit that should be after a dash that isn't
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
                        // Plus is only allowed as the first character
                        state = NANP_STATE_PLUS;
                        break;
                    }
                    // Fall through
                default:
                    // Unknown character, bail on formatting
                    text.replace(0, length, saved);
                    return;
            }
        }

        if (numDigits == 7) {
            // With 7 digits we want xxx-xxxx, not xxx-xxx-x
            numDashes--;
        }

        // Actually put the dashes in place
        for (int i = 0; i < numDashes; i++) {
            int pos = dashPositions[i];
            text.replace(pos + i, pos + i, "-");
        }

        // Remove trailing dashes
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

    /**
     * Formats a phone number in-place using the Japanese formatting rules.
     * Numbers will be formatted as:
     *
     * <p><code>
     * 03-xxxx-xxxx
     * 090-xxxx-xxxx
     * 0120-xxx-xxx
     * +81-3-xxxx-xxxx
     * +81-90-xxxx-xxxx
     * </code></p>
     *
     * @param text the number to be formatted, will be modified with
     * the formatting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.543 -0500", hash_original_method = "831FDF191B22FA73D71F28C227E32FDE", hash_generated_method = "BBC3894E3BBE101FBE98BDC338697EAF")
    
public static void formatJapaneseNumber(Editable text) {
        JapanesePhoneNumberFormatter.format(text);
    }

    /**
     * Removes all dashes from the number.
     *
     * @param text the number to clear from dashes
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.547 -0500", hash_original_method = "298AB552332245AFF95538EA4279D4D4", hash_generated_method = "50D1BFC7AAECE48C025D94DD177D8F93")
    
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

    /**
     * Format the given phoneNumber to the E.164 representation.
     * <p>
     * The given phone number must have an area code and could have a country
     * code.
     * <p>
     * The defaultCountryIso is used to validate the given number and generate
     * the E.164 phone number if the given number doesn't have a country code.
     *
     * @param phoneNumber
     *            the phone number to format
     * @param defaultCountryIso
     *            the ISO 3166-1 two letters country code
     * @return the E.164 representation, or null if the given phone number is
     *         not valid.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.550 -0500", hash_original_method = "D633463C720A911377C680E8AA0DAE0C", hash_generated_method = "E4AE7F97116A9A6E76E29F66F26D5110")
    
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

    /**
     * Format a phone number.
     * <p>
     * If the given number doesn't have the country code, the phone will be
     * formatted to the default country's convention.
     *
     * @param phoneNumber
     *            the number to be formatted.
     * @param defaultCountryIso
     *            the ISO 3166-1 two letters country code whose convention will
     *            be used if the given number doesn't have the country code.
     * @return the formatted number, or null if the given number is not valid.
     *
     * @hide
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.555 -0500", hash_original_method = "A7ACF6BA9DDECE3E31DBB8A7DF4DF0DB", hash_generated_method = "8924B0BC1D30B617CA248F7E362509B4")
    
public static String formatNumber(String phoneNumber, String defaultCountryIso) {
        // Do not attempt to format numbers that start with a hash or star symbol.
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

    /**
     * Format the phone number only if the given number hasn't been formatted.
     * <p>
     * The number which has only dailable character is treated as not being
     * formatted.
     *
     * @param phoneNumber
     *            the number to be formatted.
     * @param phoneNumberE164
     *            the E164 format number whose country code is used if the given
     *            phoneNumber doesn't have the country code.
     * @param defaultCountryIso
     *            the ISO 3166-1 two letters country code whose convention will
     *            be used if the phoneNumberE164 is null or invalid.
     * @return the formatted number if the given number has been formatted,
     *            otherwise, return the given number.
     *
     * @hide
     */
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.559 -0500", hash_original_method = "7DEA5A41C8CF38812E48507218F476CC", hash_generated_method = "BEE13F965138C88900A72C83D720ADE8")
    
public static String formatNumber(
            String phoneNumber, String phoneNumberE164, String defaultCountryIso) {
        int len = phoneNumber.length();
        for (int i = 0; i < len; i++) {
            if (!isDialable(phoneNumber.charAt(i))) {
                return phoneNumber;
            }
        }
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        // Get the country code from phoneNumberE164
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

    /**
     * Normalize a phone number by removing the characters other than digits. If
     * the given number has keypad letters, the letters will be converted to
     * digits first.
     *
     * @param phoneNumber
     *            the number to be normalized.
     * @return the normalized number.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.562 -0500", hash_original_method = "2AE8554E2C6CFEA55F148AAA6C526165", hash_generated_method = "974D64E5B862CB1550A41D214F458228")
    
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

    /**
     * Checks a given number against the list of
     * emergency numbers provided by the RIL and SIM card.
     *
     * @param number the number to look up.
     * @return true if the number is in the list of emergency numbers
     *         listed in the RIL / SIM, otherwise return false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.569 -0500", hash_original_method = "FB7235E779930AE81382F4B3EEC25C67", hash_generated_method = "0A790F42CE5E31E9588F729F11C59D56")
    
public static boolean isEmergencyNumber(String number) {
        // Return true only if the specified number *exactly* matches
        // one of the emergency numbers listed by the RIL / SIM.
        return isEmergencyNumberInternal(number, true /* useExactMatch */);
    }

    /**
     * Checks if given number might *potentially* result in
     * a call to an emergency service on the current network.
     *
     * Specifically, this method will return true if the specified number
     * is an emergency number according to the list managed by the RIL or
     * SIM, *or* if the specified number simply starts with the same
     * digits as any of the emergency numbers listed in the RIL / SIM.
     *
     * This method is intended for internal use by the phone app when
     * deciding whether to allow ACTION_CALL intents from 3rd party apps
     * (where we're required to *not* allow emergency calls to be placed.)
     *
     * @param number the number to look up.
     * @return true if the number is in the list of emergency numbers
     *         listed in the RIL / SIM, *or* if the number starts with the
     *         same digits as any of those emergency numbers.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.572 -0500", hash_original_method = "F300FF32E0091AB2C24307358D9DBEF4", hash_generated_method = "B12EBE8CBD10D6776801D1AE7C3F1A73")
    
public static boolean isPotentialEmergencyNumber(String number) {
        // Check against the emergency numbers listed by the RIL / SIM,
        // and *don't* require an exact match.
        return isEmergencyNumberInternal(number, false /* useExactMatch */);
    }

    /**
     * Helper function for isEmergencyNumber(String) and
     * isPotentialEmergencyNumber(String).
     *
     * @param number the number to look up.
     *
     * @param useExactMatch if true, consider a number to be an emergency
     *           number only if it *exactly* matches a number listed in
     *           the RIL / SIM.  If false, a number is considered to be an
     *           emergency number if it simply starts with the same digits
     *           as any of the emergency numbers listed in the RIL / SIM.
     *           (Setting useExactMatch to false allows you to identify
     *           number that could *potentially* result in emergency calls
     *           since many networks will actually ignore trailing digits
     *           after a valid emergency number.)
     *
     * @return true if the number is in the list of emergency numbers
     *         listed in the RIL / sim, otherwise return false.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.576 -0500", hash_original_method = "37285ED747A36960374A3465C356C231", hash_generated_method = "3827DF70E72AE91F10D6EDEE1DD6AF1F")
    
private static boolean isEmergencyNumberInternal(String number, boolean useExactMatch) {
        // If the number passed in is null, just return false:
        if (number == null) return false;

        // If the number passed in is a SIP address, return false, since the
        // concept of "emergency numbers" is only meaningful for calls placed
        // over the cell network.
        // (Be sure to do this check *before* calling extractNetworkPortionAlt(),
        // since the whole point of extractNetworkPortionAlt() is to filter out
        // any non-dialable characters (which would turn 'abc911def@example.com'
        // into '911', for example.))
        if (isUriNumber(number)) {
            return false;
        }

        // Strip the separators from the number before comparing it
        // to the list.
        number = extractNetworkPortionAlt(number);

        // retrieve the list of emergency numbers
        // check read-write ecclist property first
        String numbers = SystemProperties.get("ril.ecclist");
        if (TextUtils.isEmpty(numbers)) {
            // then read-only ecclist property since old RIL only uses this
            numbers = SystemProperties.get("ro.ril.ecclist");
        }

        if (!TextUtils.isEmpty(numbers)) {
            // searches through the comma-separated list for a match,
            // return true if one is found.
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
            // no matches found against the list!
            return false;
        }

        // No ecclist system property, so use our own list.
        if (useExactMatch) {
            return (number.equals("112") || number.equals("911"));
        } else {
            return (number.startsWith("112") || number.startsWith("911"));
        }
    }

    /**
     * Checks if a given number is an emergency number for a specific country.
     *
     * @param number the number to look up.
     * @param defaultCountryIso the specific country which the number should be checked against
     * @return if the number is an emergency number for the specific country, then return true,
     * otherwise false
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.579 -0500", hash_original_method = "23B47A857E4542DE9F8AF3FFA1A4FD79", hash_generated_method = "80C28A92B5530B0A051DCE6A3362D766")
    
public static boolean isEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         true /* useExactMatch */);
    }

    /**
     * Checks if a given number might *potentially* result in a call to an
     * emergency service, for a specific country.
     *
     * Specifically, this method will return true if the specified number
     * is an emergency number in the specified country, *or* if the number
     * simply starts with the same digits as any emergency number for that
     * country.
     *
     * This method is intended for internal use by the phone app when
     * deciding whether to allow ACTION_CALL intents from 3rd party apps
     * (where we're required to *not* allow emergency calls to be placed.)
     *
     * @param number the number to look up.
     * @param defaultCountryIso the specific country which the number should be checked against
     * @return true if the number is an emergency number for the specific
     *         country, *or* if the number starts with the same digits as
     *         any of those emergency numbers.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.582 -0500", hash_original_method = "0880441C47E987D03FC49C5FE19093F0", hash_generated_method = "069562DD73DDF8FDE0A01B2B114B24A5")
    
public static boolean isPotentialEmergencyNumber(String number, String defaultCountryIso) {
        return isEmergencyNumberInternal(number,
                                         defaultCountryIso,
                                         false /* useExactMatch */);
    }

    /**
     * Helper function for isEmergencyNumber(String, String) and
     * isPotentialEmergencyNumber(String, String).
     *
     * @param number the number to look up.
     * @param defaultCountryIso the specific country which the number should be checked against
     * @param useExactMatch if true, consider a number to be an emergency
     *           number only if it *exactly* matches a number listed in
     *           the RIL / SIM.  If false, a number is considered to be an
     *           emergency number if it simply starts with the same digits
     *           as any of the emergency numbers listed in the RIL / SIM.
     *
     * @return true if the number is an emergency number for the specified country.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.586 -0500", hash_original_method = "CB79FF72E5AA03B786B465A966D1C6DF", hash_generated_method = "81C80B715F622ABB2CBDA87FD4BB7C6D")
    
private static boolean isEmergencyNumberInternal(String number,
                                                     String defaultCountryIso,
                                                     boolean useExactMatch) {
        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        try {
            PhoneNumber pn = util.parse(number, defaultCountryIso);
            // libphonenumber guarantees short numbers such as emergency numbers are classified as
            // invalid. Therefore, if the number passes the validation test, we believe it is not an
            // emergency number.
            // TODO: Compare against a list of country-specific known emergency numbers instead, once
            // that has been collected.
            if (util.isValidNumber(pn)) {
                return false;
            } else if ("BR".equalsIgnoreCase(defaultCountryIso) && number.length() >= 8) {
                // This is to prevent Brazilian local numbers which start with 911 being incorrectly
                // classified as emergency numbers. 911 is not an emergency number in Brazil; it is also
                // not possible to append additional digits to an emergency number to dial the number in
                // Brazil - it won't connect.
                // TODO: Clean this up once a list of country-specific known emergency numbers is
                // collected.
                return false;
            }
        } catch (NumberParseException e) {
        }
        return isEmergencyNumberInternal(number, useExactMatch);
    }

    /**
     * Checks if a given number is an emergency number for the country that the user is in. The
     * current country is determined using the CountryDetector.
     *
     * @param number the number to look up.
     * @param context the specific context which the number should be checked against
     * @return true if the specified number is an emergency number for a local country, based on the
     *              CountryDetector.
     *
     * @see android.location.CountryDetector
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.589 -0500", hash_original_method = "2C93EF10C01AE643F78F003A0BECAC73", hash_generated_method = "294280ED8CDC389357E4F36D66292F13")
    
public static boolean isLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              true /* useExactMatch */);
    }

    /**
     * Checks if a given number might *potentially* result in a call to an
     * emergency service, for the country that the user is in. The current
     * country is determined using the CountryDetector.
     *
     * Specifically, this method will return true if the specified number
     * is an emergency number in the current country, *or* if the number
     * simply starts with the same digits as any emergency number for the
     * current country.
     *
     * This method is intended for internal use by the phone app when
     * deciding whether to allow ACTION_CALL intents from 3rd party apps
     * (where we're required to *not* allow emergency calls to be placed.)
     *
     * @param number the number to look up.
     * @param context the specific context which the number should be checked against
     * @return true if the specified number is an emergency number for a local country, based on the
     *              CountryDetector.
     *
     * @see android.location.CountryDetector
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.593 -0500", hash_original_method = "81A59D28753D7C567B4B024877A8C6E6", hash_generated_method = "BC97FE5BB7BDA9266C70122C43ED9172")
    
public static boolean isPotentialLocalEmergencyNumber(String number, Context context) {
        return isLocalEmergencyNumberInternal(number,
                                              context,
                                              false /* useExactMatch */);
    }

    /**
     * Helper function for isLocalEmergencyNumber() and
     * isPotentialLocalEmergencyNumber().
     *
     * @param number the number to look up.
     * @param context the specific context which the number should be checked against
     * @param useExactMatch if true, consider a number to be an emergency
     *           number only if it *exactly* matches a number listed in
     *           the RIL / SIM.  If false, a number is considered to be an
     *           emergency number if it simply starts with the same digits
     *           as any of the emergency numbers listed in the RIL / SIM.
     *
     * @return true if the specified number is an emergency number for a
     *              local country, based on the CountryDetector.
     *
     * @see android.location.CountryDetector
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.597 -0500", hash_original_method = "96612C398F49F406D66C3575CAB886FB", hash_generated_method = "3009211BA40AE2579361B1980C938E79")
    
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

    /**
     * isVoiceMailNumber: checks a given number against the voicemail
     *   number provided by the RIL and SIM card. The caller must have
     *   the READ_PHONE_STATE credential.
     *
     * @param number the number to look up.
     * @return true if the number is in the list of voicemail. False
     * otherwise, including if the caller does not have the permission
     * to read the VM number.
     * @hide TODO: pending API Council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.601 -0500", hash_original_method = "F89FCCC7DAC3DDDECFBD90C73C53D5D4", hash_generated_method = "C51DFADEAB1B13B537F0BA3C3E95F6E1")
    
public static boolean isVoiceMailNumber(String number) {
        String vmNumber;

        try {
            vmNumber = TelephonyManager.getDefault().getVoiceMailNumber();
        } catch (SecurityException ex) {
            return false;
        }

        // Strip the separators from the number before comparing it
        // to the list.
        number = extractNetworkPortionAlt(number);

        // compare tolerates null so we need to make sure that we
        // don't return true when both are null.
        return !TextUtils.isEmpty(number) && compare(number, vmNumber);
    }

    /**
     * Translates any alphabetic letters (i.e. [A-Za-z]) in the
     * specified phone number into the equivalent numeric digits,
     * according to the phone keypad letter mapping described in
     * ITU E.161 and ISO/IEC 9995-8.
     *
     * @return the input string, with alpha letters converted to numeric
     *         digits using the phone keypad letter mapping.  For example,
     *         an input of "1-800-GOOG-411" will return "1-800-4664-411".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.605 -0500", hash_original_method = "C19DA42AB571E96824BDE2AB4D9CB311", hash_generated_method = "88B07071FEA72C990EF2B30E64B194D7")
    
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
            // If this char isn't in KEYPAD_MAP at all, just leave it alone.
            out[i] = (char) KEYPAD_MAP.get(c, c);
        }

        return new String(out);
    }

    /**
     * This function checks if there is a plus sign (+) in the passed-in dialing number.
     * If there is, it processes the plus sign based on the default telephone
     * numbering plan of the system when the phone is activated and the current
     * telephone numbering plan of the system that the phone is camped on.
     * Currently, we only support the case that the default and current telephone
     * numbering plans are North American Numbering Plan(NANP).
     *
     * The passed-in dialStr should only contain the valid format as described below,
     * 1) the 1st character in the dialStr should be one of the really dialable
     *    characters listed below
     *    ISO-LATIN characters 0-9, *, # , +
     * 2) the dialStr should already strip out the separator characters,
     *    every character in the dialStr should be one of the non separator characters
     *    listed below
     *    ISO-LATIN characters 0-9, *, # , +, WILD, WAIT, PAUSE
     *
     * Otherwise, this function returns the dial string passed in
     *
     * @param dialStr the original dial string
     * @return the converted dial string if the current/default countries belong to NANP,
     * and if there is the "+" in the original dial string. Otherwise, the original dial
     * string returns.
     *
     * This API is for CDMA only
     *
     * @hide TODO: pending API Council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.626 -0500", hash_original_method = "1A1413577F7152F2ECD6922D2D24CEE2", hash_generated_method = "950DE6C5B1F761D93F899644CB882D70")
    
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

    /**
     * This function should be called from checkAndProcessPlusCode only
     * And it is used for test purpose also.
     *
     * It checks the dial string by looping through the network portion,
     * post dial portion 1, post dial porting 2, etc. If there is any
     * plus sign, then process the plus sign.
     * Currently, this function supports the plus sign conversion within NANP only.
     * Specifically, it handles the plus sign in the following ways:
     * 1)+1NANP,remove +, e.g.
     *   +18475797000 is converted to 18475797000,
     * 2)+NANP or +non-NANP Numbers,replace + with the current NANP IDP, e.g,
     *   +8475797000 is converted to 0118475797000,
     *   +11875767800 is converted to 01111875767800
     * 3)+1NANP in post dial string(s), e.g.
     *   8475797000;+18475231753 is converted to 8475797000;18475231753
     *
     *
     * @param dialStr the original dial string
     * @param currFormat the numbering system of the current country that the phone is camped on
     * @param defaultFormat the numbering system of the country that the phone is activated on
     * @return the converted dial string if the current/default countries belong to NANP,
     * and if there is the "+" in the original dial string. Otherwise, the original dial
     * string returns.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.631 -0500", hash_original_method = "8B3D064358571DB7A73FB86148106DC9", hash_generated_method = "E9C8CD1A2CE20039CC4E15154E6F786F")
    
public static String
    cdmaCheckAndProcessPlusCodeByNumberFormat(String dialStr,int currFormat,int defaultFormat) {
        String retStr = dialStr;

        // Checks if the plus sign character is in the passed-in dial string
        if (dialStr != null &&
            dialStr.lastIndexOf(PLUS_SIGN_STRING) != -1) {
            // Format the string based on the rules for the country the number is from,
            // and the current country the phone is camped on.
            if ((currFormat == defaultFormat) && (currFormat == FORMAT_NANP)) {
                // Handle case where default and current telephone numbering plans are NANP.
                String postDialStr = null;
                String tempDialStr = dialStr;

                // Sets the retStr to null since the conversion will be performed below.
                retStr = null;
                if (DBG) log("checkAndProcessPlusCode,dialStr=" + dialStr);
                // This routine is to process the plus sign in the dial string by loop through
                // the network portion, post dial portion 1, post dial portion 2... etc. if
                // applied
                do {
                    String networkDialStr;
                    networkDialStr = extractNetworkPortion(tempDialStr);
                    // Handles the conversion within NANP
                    networkDialStr = processPlusCodeWithinNanp(networkDialStr);

                    // Concatenates the string that is converted from network portion
                    if (!TextUtils.isEmpty(networkDialStr)) {
                        if (retStr == null) {
                            retStr = networkDialStr;
                        } else {
                            retStr = retStr.concat(networkDialStr);
                        }
                    } else {
                        // This should never happen since we checked the if dialStr is null
                        // and if it contains the plus sign in the beginning of this function.
                        // The plus sign is part of the network portion.
                        Log.e("checkAndProcessPlusCode: null newDialStr", networkDialStr);
                        return dialStr;
                    }
                    postDialStr = extractPostDialPortion(tempDialStr);
                    if (!TextUtils.isEmpty(postDialStr)) {
                        int dialableIndex = findDialableIndexFromPostDialStr(postDialStr);

                        // dialableIndex should always be greater than 0
                        if (dialableIndex >= 1) {
                            retStr = appendPwCharBackToOrigDialStr(dialableIndex,
                                     retStr,postDialStr);
                            // Skips the P/W character, extracts the dialable portion
                            tempDialStr = postDialStr.substring(dialableIndex);
                        } else {
                            // Non-dialable character such as P/W should not be at the end of
                            // the dial string after P/W processing in CdmaConnection.java
                            // Set the postDialStr to "" to break out of the loop
                            if (dialableIndex < 0) {
                                postDialStr = "";
                            }
                            Log.e("wrong postDialStr=", postDialStr);
                        }
                    }
                    if (DBG) log("checkAndProcessPlusCode,postDialStr=" + postDialStr);
                } while (!TextUtils.isEmpty(postDialStr) && !TextUtils.isEmpty(tempDialStr));
            } else {
                // TODO: Support NANP international conversion and other telephone numbering plans.
                // Currently the phone is never used in non-NANP system, so return the original
                // dial string.
                Log.e("checkAndProcessPlusCode:non-NANP not supported", dialStr);
            }
        }
        return retStr;
     }

    // This function gets the default international dialing prefix
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.635 -0500", hash_original_method = "CE701E93949872446157BBE9ECAD64D2", hash_generated_method = "5C783DC2B0314289305BE0318C5A16AA")
    
private static String getDefaultIdp( ) {
        String ps = null;
        SystemProperties.get(PROPERTY_IDP_STRING, ps);
        if (TextUtils.isEmpty(ps)) {
            ps = NANP_IDP_STRING;
        }
        return ps;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.639 -0500", hash_original_method = "8B2A426364680DCC80D51C3F849C284B", hash_generated_method = "D2B8ACE6C711ACEF4529BB28202DCF47")
    
private static boolean isTwoToNine (char c) {
        if (c >= '2' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.642 -0500", hash_original_method = "532A9297847E5A4BD7745A9593C301A6", hash_generated_method = "133F0A6AB3218927173898344EE66A1A")
    
private static int getFormatTypeFromCountryCode (String country) {
        // Check for the NANP countries
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

    /**
     * This function checks if the passed in string conforms to the NANP format
     * i.e. NXX-NXX-XXXX, N is any digit 2-9 and X is any digit 0-9
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.646 -0500", hash_original_method = "429014701CBDF3E63C4D942F6F6D141A", hash_generated_method = "B62EF7D8E52E9EF213344FDB1A7B0FF5")
    
private static boolean isNanp (String dialStr) {
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

   /**
    * This function checks if the passed in string conforms to 1-NANP format
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.649 -0500", hash_original_method = "4C14D29B81253845991BCF5FA05DF332", hash_generated_method = "1335544A869314E10256A75BC226BC6C")
    
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

    /**
     * Determines if the specified number is actually a URI
     * (i.e. a SIP address) rather than a regular PSTN phone number,
     * based on whether or not the number contains an "@" character.
     *
     * @hide
     * @param number
     * @return true if number contains @
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.652 -0500", hash_original_method = "CC3E46D1D493D55DA8F3552367CC9130", hash_generated_method = "E0385A33F0C22FF7EEC5439C9D4367A2")
    
public static boolean isUriNumber(String number) {
        // Note we allow either "@" or "%40" to indicate a URI, in case
        // the passed-in string is URI-escaped.  (Neither "@" nor "%40"
        // will ever be found in a legal PSTN number.)
        return number != null && (number.contains("@") || number.contains("%40"));
    }

    /**
     * @return the "username" part of the specified SIP address,
     *         i.e. the part before the "@" character (or "%40").
     *
     * @param number SIP address of the form "username@domainname"
     *               (or the URI-escaped equivalent "username%40domainname")
     * @see isUriNumber
     *
     * @hide
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.655 -0500", hash_original_method = "F030E804700DAC1BD311652B4F54A186", hash_generated_method = "B84CFD60AD1D8FE61F8617DA040FF80B")
    
public static String getUsernameFromUriNumber(String number) {
        // The delimiter between username and domain name can be
        // either "@" or "%40" (the URI-escaped equivalent.)
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

    /**
     * This function handles the plus code conversion within NANP CDMA network
     * If the number format is
     * 1)+1NANP,remove +,
     * 2)other than +1NANP, any + numbers,replace + with the current IDP
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.659 -0500", hash_original_method = "84C5DF0BB814E2B994CF01B1B056D342", hash_generated_method = "376E7DFE8900D748A8960D497FE30420")
    
private static String processPlusCodeWithinNanp(String networkDialStr) {
        String retStr = networkDialStr;

        if (DBG) log("processPlusCodeWithinNanp,networkDialStr=" + networkDialStr);
        // If there is a plus sign at the beginning of the dial string,
        // Convert the plus sign to the default IDP since it's an international number
        if (networkDialStr != null &&
            networkDialStr.charAt(0) == PLUS_SIGN_CHAR &&
            networkDialStr.length() > 1) {
            String newStr = networkDialStr.substring(1);
            if (isOneNanp(newStr)) {
                // Remove the leading plus sign
                retStr = newStr;
             } else {
                 String idpStr = getDefaultIdp();
                 // Replaces the plus sign with the default IDP
                 retStr = networkDialStr.replaceFirst("[+]", idpStr);
            }
        }
        if (DBG) log("processPlusCodeWithinNanp,retStr=" + retStr);
        return retStr;
    }

    // This function finds the index of the dialable character(s)
    // in the post dial string
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.663 -0500", hash_original_method = "BD4A493D09E16FABF648801F72081EA4", hash_generated_method = "75C8551D7D331A82F79BA05D08FFE6BD")
    
private static int findDialableIndexFromPostDialStr(String postDialStr) {
        for (int index = 0;index < postDialStr.length();index++) {
             char c = postDialStr.charAt(index);
             if (isReallyDialable(c)) {
                return index;
             }
        }
        return -1;
    }

    // This function appends the non-dialable P/W character to the original
    // dial string based on the dialable index passed in
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.667 -0500", hash_original_method = "41DC2CC4DA802A8544E430BC872F3EFD", hash_generated_method = "EB3957498AE44F7D7BE0A56618ECFA28")
    
private static String
    appendPwCharBackToOrigDialStr(int dialableIndex,String origStr, String dialStr) {
        String retStr;

        // There is only 1 P/W character before the dialable characters
        if (dialableIndex == 1) {
            StringBuilder ret = new StringBuilder(origStr);
            ret = ret.append(dialStr.charAt(0));
            retStr = ret.toString();
        } else {
            // It means more than 1 P/W characters in the post dial string,
            // appends to retStr
            String nonDigitStr = dialStr.substring(0,dialableIndex);
            retStr = origStr.concat(nonDigitStr);
        }
        return retStr;
    }

    //===== Beginning of utility methods used in compareLoosely() =====

    /**
     * Phone numbers are stored in "lookup" form in the database
     * as reversed strings to allow for caller ID lookup
     *
     * This method takes a phone number and makes a valid SQL "LIKE"
     * string that will match the lookup form
     *
     */
    /** all of a up to len must be an international prefix or
     *  separators/non-dialing digits
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.670 -0500", hash_original_method = "36F66EFD343D5849BA1CADCA9AD61546", hash_generated_method = "00B5D6CFCA14C26B8E390C5A28B6B3D7")
    
private static boolean
    matchIntlPrefix(String a, int len) {
        /* '([^0-9*#+pwn]\+[^0-9*#+pwn] | [^0-9*#+pwn]0(0|11)[^0-9*#+pwn] )$' */
        /*        0       1                           2 3 45               */

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

    /** all of 'a' up to len must be a (+|00|011)country code)
     *  We're fast and loose with the country code. Any \d{1,3} matches */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.674 -0500", hash_original_method = "4F741A7A51F1E923707F3A08CA0DFA64", hash_generated_method = "9E5C03E7E7BFA769A4FA8DD1E313E1E2")
    
private static boolean
    matchIntlPrefixAndCC(String a, int len) {
        /*  [^0-9*#+pwn]*(\+|0(0|11)\d\d?\d? [^0-9*#+pwn] $ */
        /*      0          1 2 3 45  6 7  8                 */

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

    /** all of 'a' up to len must match non-US trunk prefix ('0') */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.677 -0500", hash_original_method = "B4C70E997EC0CC2FE1FB1672C0894635", hash_generated_method = "21CC7EDAE46841C772E9773A5857CEF0")
    
private static boolean
    matchTrunkPrefix(String a, int len) {
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

    /**
     * @return true when input is valid Country Calling Code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.689 -0500", hash_original_method = "DC8924E535E3BE7CAEA9A9E1FDE1AD0C", hash_generated_method = "33E44EBFF435564B163E850435844C94")
    
private static boolean isCountryCallingCode(int countryCallingCodeCandidate) {
        return countryCallingCodeCandidate > 0 && countryCallingCodeCandidate < CCC_LENGTH &&
                COUNTRY_CALLING_CALL[countryCallingCodeCandidate];
    }

    /**
     * Returns integer corresponding to the input if input "ch" is
     * ISO-LATIN characters 0-9.
     * Returns -1 otherwise
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.692 -0500", hash_original_method = "076AF69FA4452B4975423A6D4D7C01B2", hash_generated_method = "DC94DD6546D86B4681C6341FA8C70624")
    
private static int tryGetISODigit(char ch) {
        if ('0' <= ch && ch <= '9') {
            return ch - '0';
        } else {
            return -1;
        }
    }

    /*
     * Note that this function does not strictly care the country calling code with
     * 3 length (like Morocco: +212), assuming it is enough to use the first two
     * digit to compare two phone numbers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.710 -0500", hash_original_method = "06EBA22D5380C04BCA1473269198766F", hash_generated_method = "5414980A6C181C1C60E3A833AB795764")
    
private static CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex(
        String str, boolean acceptThailandCase) {
        // Rough regexp:
        //  ^[^0-9*#+]*((\+|0(0|11)\d\d?|166) [^0-9*#+] $
        //         0        1 2 3 45  6 7  89
        //
        // In all the states, this function ignores separator characters.
        // "166" is the special case for the call from Thailand to the US. Uguu!
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

    /**
     * Currently this function simply ignore the first digit assuming it is
     * trunk prefix. Actually trunk prefix is different in each country.
     *
     * e.g.
     * "+79161234567" equals "89161234567" (Russian trunk digit is 8)
     * "+33123456789" equals "0123456789" (French trunk digit is 0)
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.715 -0500", hash_original_method = "66C826C8182942443823887EE81BC356", hash_generated_method = "351CEC1938395954E97E0058ADAC50B4")
    
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

    /**
     * Return true if the prefix of "str" is "ignorable". Here, "ignorable" means
     * that "str" has only one digit and separator characters. The one digit is
     * assumed to be trunk prefix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.718 -0500", hash_original_method = "142EC47724C15FE9B1D0347516282D9A", hash_generated_method = "EF227FDC3F1D7E747D5CE0A86B18FB30")
    
private static boolean checkPrefixIsIgnorable(final String str,
            int forwardIndex, int backwardIndex) {
        boolean trunk_prefix_was_read = false;
        while (backwardIndex >= forwardIndex) {
            if (tryGetISODigit(str.charAt(backwardIndex)) >= 0) {
                if (trunk_prefix_was_read) {
                    // More than one digit appeared, meaning that "a" and "b"
                    // is different.
                    return false;
                } else {
                    // Ignore just one digit, assuming it is trunk prefix.
                    trunk_prefix_was_read = true;
                }
            } else if (isDialable(str.charAt(backwardIndex))) {
                // Trunk prefix is a digit, not "*", "#"...
                return false;
            }
            backwardIndex--;
        }

        return true;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.296 -0500", hash_original_field = "A6FB204819A8699A976195514879641E", hash_generated_field = "9592BDC3C222BAB87D6921536B386F02")

    public static final char PAUSE = ',';
    
    private static class CountryCallingCodeAndNewIndex {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.696 -0500", hash_original_field = "7A11634F20F39AF3448FB685B8352A3F", hash_generated_field = "3AFE52867FA7D6A4E2F06FCBB6E2D3AB")

        public  int countryCallingCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.699 -0500", hash_original_field = "84D00158DB42D7B85C4498EB33A3DD4C", hash_generated_field = "E475F8F2EFBA505C94E4C7ABFF34FE12")

        public  int newIndex;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.704 -0500", hash_original_method = "5DCA5F364592872E4B4A5AF571961FBD", hash_generated_method = "62BDE7D0D7F7D2C3928479244080543C")
        
public CountryCallingCodeAndNewIndex(int countryCode, int newIndex) {
            this.countryCallingCode = countryCode;
            this.newIndex = newIndex;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.299 -0500", hash_original_field = "8D458F01853313ABEA98A88F7EE3478A", hash_generated_field = "B5DAD0C77E5093BF168B416C17DBD0D4")

    public static final char WAIT = ';';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.303 -0500", hash_original_field = "354EB01FA9836404D20EFFB73F10153B", hash_generated_field = "4508CC8F7BCD4D71006CDE5EE7139083")

    public static final char WILD = 'N';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.306 -0500", hash_original_field = "6DF26E0D66A9C2BD1DEBDA71160C72F0", hash_generated_field = "41733512B7356A6F1169DE28E49240D0")

    private static final String CLIR_ON = "*31#+";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.310 -0500", hash_original_field = "980E5ED491340997CB19E43F85C48B78", hash_generated_field = "21107701FB725EBBB1A8151BF10DD146")

    private static final String CLIR_OFF = "#31#+";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.313 -0500", hash_original_field = "D460A557DE4B2B6B0F17CB90D777D757", hash_generated_field = "06787C0184484B4BFBBF1E2A65382041")

    public static final int TOA_International = 0x91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.317 -0500", hash_original_field = "A41FC6203F01AAE64D9C80DCAA94422A", hash_generated_field = "243A93021F2325560EC4F5DCB5A791CB")

    public static final int TOA_Unknown = 0x81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.320 -0500", hash_original_field = "403F795B9AFF87DA5236729C537FAA39", hash_generated_field = "66F1D08002084ED372C413B449756379")

    static final String LOG_TAG = "PhoneNumberUtils";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.324 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.327 -0500", hash_original_field = "727025E963A1BD0325D822A41BF6D557", hash_generated_field = "9026E5CF572994614C2F0E9A1C451C00")

    private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN =
            Pattern.compile("[\\+]?[0-9.-]+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.495 -0500", hash_original_field = "DEA5E53A3DD9D15707DBB3267861907A", hash_generated_field = "75D48D38CDAAF3E8AF823720AEFD507B")

    /** The current locale is unknown, look for a country code or don't format */
    public static final int FORMAT_UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.498 -0500", hash_original_field = "C8BCCD2498C924F3D0FCBA327BFEEA24", hash_generated_field = "46986CCD2F846A62FECAEC81C1FCD118")

    public static final int FORMAT_NANP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.502 -0500", hash_original_field = "9A44B597A082B6707393C662885FA0D5", hash_generated_field = "4BC9003279A4C6063E53C49E257506ED")

    public static final int FORMAT_JAPAN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.506 -0500", hash_original_field = "0D5A6B696279D0BB26D54309EAE3D676", hash_generated_field = "C6629FA1FDD3D8798F28510C613FFADF")

    private static final String[] NANP_COUNTRIES = new String[] {
        "US", // United States
        "CA", // Canada
        "AS", // American Samoa
        "AI", // Anguilla
        "AG", // Antigua and Barbuda
        "BS", // Bahamas
        "BB", // Barbados
        "BM", // Bermuda
        "VG", // British Virgin Islands
        "KY", // Cayman Islands
        "DM", // Dominica
        "DO", // Dominican Republic
        "GD", // Grenada
        "GU", // Guam
        "JM", // Jamaica
        "PR", // Puerto Rico
        "MS", // Montserrat
        "MP", // Northern Mariana Islands
        "KN", // Saint Kitts and Nevis
        "LC", // Saint Lucia
        "VC", // Saint Vincent and the Grenadines
        "TT", // Trinidad and Tobago
        "TC", // Turks and Caicos Islands
        "VI", // U.S. Virgin Islands
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.523 -0500", hash_original_field = "655910138B9EB02069D7FF3E386896BF", hash_generated_field = "97E60B6F9174D822AC0B50ACF1DFAB18")

    private static final int NANP_STATE_DIGIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.527 -0500", hash_original_field = "D24967CB28CFFB9B53B628032D4462C6", hash_generated_field = "D8B6E15CB39EE1B396190326022E5992")

    private static final int NANP_STATE_PLUS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.531 -0500", hash_original_field = "5869BD8B957F3DF825C8ACF0CD1126D2", hash_generated_field = "6912B97017383BE61F75EF2B91107E34")

    private static final int NANP_STATE_ONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.534 -0500", hash_original_field = "540A48F9459F2097C68AA10FF0A81248", hash_generated_field = "CCB97240D79A883AF68A6A38F3462C75")

    private static final int NANP_STATE_DASH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.566 -0500", hash_original_field = "4EB3A5C2F58E27652B584BCB89B2BDE2", hash_generated_field = "AB10594DE4554D168F14A3D3CA95B0F3")

    // or 3-6 digit addresses from the network (eg carrier-originated SMS messages) should
    // not match.
    //
    // This constant used to be 5, but SMS short codes has increased in length and
    // can be easily 6 digits now days. Most countries have SMS short code length between
    // 3 to 6 digits. The exceptions are
    //
    // Australia: Short codes are six or eight digits in length, starting with the prefix "19"
    //            followed by an additional four or six digits and two.
    // Czech Republic: Codes are seven digits in length for MO and five (not billed) or
    //            eight (billed) for MT direction
    //
    // see http://en.wikipedia.org/wiki/Short_code#Regional_differences for reference
    //
    // However, in order to loose match 650-555-1212 and 555-1212, we need to set the min match
    // to 7.
    static final int MIN_MATCH = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.608 -0500", hash_original_field = "861C05B9DE0CC09F1AC2BCBD4A464728", hash_generated_field = "7C8D51C46A0626FE47244FF96E4E521F")

    private static final SparseIntArray KEYPAD_MAP = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.613 -0500", hash_original_field = "B9FA1EA491518FB0753A019C639EB8AE", hash_generated_field = "2A181750D519F673E8388310FF30197F")

    private static final char PLUS_SIGN_CHAR = '+';
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.616 -0500", hash_original_field = "4BD7861052230830B04AF17F1195561F", hash_generated_field = "E5F293939EB869982108989CED040CCD")

    private static final String PLUS_SIGN_STRING = "+";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.620 -0500", hash_original_field = "6C4272A0A9C5FD8347D762EC040BF0FC", hash_generated_field = "65419F0E81B4FB3437C262BDF238DE93")

    private static final String NANP_IDP_STRING = "011";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.623 -0500", hash_original_field = "58C4E55163979DD2C2123B4D8CA41157", hash_generated_field = "0EAB7D348935210D0FF303321B37482A")

    private static final int NANP_LENGTH = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.682 -0500", hash_original_field = "38B80DF00A5A91E51BBE4E6988DE0AF9", hash_generated_field = "7BBE712A9274E1A48A8FA3DFB5721C10")

    //===== Beginning of utility methods used only in compareStrictly() ====

    /*
     * If true, the number is country calling code.
     */
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:51.686 -0500", hash_original_field = "92AD8E5391B2401FFBE1412C55BA8E37", hash_generated_field = "D5735316F828A4C0760841299861CAB7")

    private static final int CCC_LENGTH = COUNTRY_CALLING_CALL.length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.335 -0400", hash_original_method = "0471222FC8B1AE7B60D0D4D370DECD9E", hash_generated_method = "0471222FC8B1AE7B60D0D4D370DECD9E")
    public PhoneNumberUtils ()
    {
        //Synthesized constructor
    }
}

