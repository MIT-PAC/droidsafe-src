package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.location.CountryDetector;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.RawContacts;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;

public class CallerInfo {

    /**
     * getCallerInfo given a Cursor.
     * @param context the context used to retrieve string constants
     * @param contactRef the URI to attach to this CallerInfo object
     * @param cursor the first object in the cursor is used to build the CallerInfo object.
     * @return the CallerInfo which contains the caller id for the given
     * number. The returned CallerInfo is null if no number is supplied.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.400 -0500", hash_original_method = "5A41265338B441253D84C904D0572F1D", hash_generated_method = "D527D4D2440A499A7FDB9223A8D1728A")
    
public static CallerInfo getCallerInfo(Context context, Uri contactRef, Cursor cursor) {
        CallerInfo info = new CallerInfo();
        info.photoResource = 0;
        info.phoneLabel = null;
        info.numberType = 0;
        info.numberLabel = null;
        info.cachedPhoto = null;
        info.isCachedPhotoCurrent = false;
        info.contactExists = false;

        if (VDBG) Log.v(TAG, "getCallerInfo() based on cursor...");

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // TODO: photo_id is always available but not taken
                // care of here. Maybe we should store it in the
                // CallerInfo object as well.

                int columnIndex;

                // Look for the name
                columnIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
                if (columnIndex != -1) {
                    info.name = cursor.getString(columnIndex);
                }

                // Look for the number
                columnIndex = cursor.getColumnIndex(PhoneLookup.NUMBER);
                if (columnIndex != -1) {
                    info.phoneNumber = cursor.getString(columnIndex);
                }

                // Look for the normalized number
                columnIndex = cursor.getColumnIndex(PhoneLookup.NORMALIZED_NUMBER);
                if (columnIndex != -1) {
                    info.normalizedNumber = cursor.getString(columnIndex);
                }

                // Look for the label/type combo
                columnIndex = cursor.getColumnIndex(PhoneLookup.LABEL);
                if (columnIndex != -1) {
                    int typeColumnIndex = cursor.getColumnIndex(PhoneLookup.TYPE);
                    if (typeColumnIndex != -1) {
                        info.numberType = cursor.getInt(typeColumnIndex);
                        info.numberLabel = cursor.getString(columnIndex);
                        info.phoneLabel = Phone.getDisplayLabel(context,
                                info.numberType, info.numberLabel)
                                .toString();
                    }
                }

                // Look for the person_id.
                columnIndex = getColumnIndexForPersonId(contactRef, cursor);
                if (columnIndex != -1) {
                    info.person_id = cursor.getLong(columnIndex);
                    if (VDBG) Log.v(TAG, "==> got info.person_id: " + info.person_id);
                } else {
                    // No valid columnIndex, so we can't look up person_id.
                    Log.w(TAG, "Couldn't find person_id column for " + contactRef);
                    // Watch out: this means that anything that depends on
                    // person_id will be broken (like contact photo lookups in
                    // the in-call UI, for example.)
                }

                // look for the custom ringtone, create from the string stored
                // in the database.
                columnIndex = cursor.getColumnIndex(PhoneLookup.CUSTOM_RINGTONE);
                if ((columnIndex != -1) && (cursor.getString(columnIndex) != null)) {
                    info.contactRingtoneUri = Uri.parse(cursor.getString(columnIndex));
                } else {
                    info.contactRingtoneUri = null;
                }

                // look for the send to voicemail flag, set it to true only
                // under certain circumstances.
                columnIndex = cursor.getColumnIndex(PhoneLookup.SEND_TO_VOICEMAIL);
                info.shouldSendToVoicemail = (columnIndex != -1) &&
                        ((cursor.getInt(columnIndex)) == 1);
                info.contactExists = true;
            }
            cursor.close();
        }

        info.needUpdate = false;
        info.name = normalize(info.name);
        info.contactRefUri = contactRef;

        return info;
    }

    /**
     * getCallerInfo given a URI, look up in the call-log database
     * for the uri unique key.
     * @param context the context used to get the ContentResolver
     * @param contactRef the URI used to lookup caller id
     * @return the CallerInfo which contains the caller id for the given
     * number. The returned CallerInfo is null if no number is supplied.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.403 -0500", hash_original_method = "C8DFF2D0C3894E1B9175858C5EE3D3BB", hash_generated_method = "237AEB559BC360557812F8BE65E7FC45")
    
public static CallerInfo getCallerInfo(Context context, Uri contactRef) {

        return getCallerInfo(context, contactRef,
                context.getContentResolver().query(contactRef, null, null, null, null));
    }

    /**
     * getCallerInfo given a phone number, look up in the call-log database
     * for the matching caller id info.
     * @param context the context used to get the ContentResolver
     * @param number the phone number used to lookup caller id
     * @return the CallerInfo which contains the caller id for the given
     * number. The returned CallerInfo is null if no number is supplied. If
     * a matching number is not found, then a generic caller info is returned,
     * with all relevant fields empty or null.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.406 -0500", hash_original_method = "B6705B43DEEA0F2192B48F9F777B01B4", hash_generated_method = "FE8D81ECCCA8A8D5C94A6A43ADF78785")
    
public static CallerInfo getCallerInfo(Context context, String number) {
        if (VDBG) Log.v(TAG, "getCallerInfo() based on number...");

        if (TextUtils.isEmpty(number)) {
            return null;
        }

        // Change the callerInfo number ONLY if it is an emergency number
        // or if it is the voicemail number.  If it is either, take a
        // shortcut and skip the query.
        if (PhoneNumberUtils.isLocalEmergencyNumber(number, context)) {
            return new CallerInfo().markAsEmergency(context);
        } else if (PhoneNumberUtils.isVoiceMailNumber(number)) {
            return new CallerInfo().markAsVoiceMail();
        }

        Uri contactUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));

        CallerInfo info = getCallerInfo(context, contactUri);
        info = doSecondaryLookupIfNecessary(context, number, info);

        // if no query results were returned with a viable number,
        // fill in the original number value we used to query with.
        if (TextUtils.isEmpty(info.phoneNumber)) {
            info.phoneNumber = number;
        }

        return info;
    }

    /**
     * Performs another lookup if previous lookup fails and it's a SIP call
     * and the peer's username is all numeric. Look up the username as it
     * could be a PSTN number in the contact database.
     *
     * @param context the query context
     * @param number the original phone number, could be a SIP URI
     * @param previousResult the result of previous lookup
     * @return previousResult if it's not the case
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.408 -0500", hash_original_method = "2C00C7AAB5402D365DFE9454D01A448E", hash_generated_method = "7E78560CD6C15B30DB0177E24FE61CB0")
    
static CallerInfo doSecondaryLookupIfNecessary(Context context,
            String number, CallerInfo previousResult) {
        if (!previousResult.contactExists
                && PhoneNumberUtils.isUriNumber(number)) {
            String username = PhoneNumberUtils.getUsernameFromUriNumber(number);
            if (PhoneNumberUtils.isGlobalPhoneNumber(username)) {
                previousResult = getCallerInfo(context,
                        Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI,
                                Uri.encode(username)));
            }
        }
        return previousResult;
    }

    /**
     * getCallerId: a convenience method to get the caller id for a given
     * number.
     *
     * @param context the context used to get the ContentResolver.
     * @param number a phone number.
     * @return if the number belongs to a contact, the contact's name is
     * returned; otherwise, the number itself is returned.
     *
     * TODO NOTE: This MAY need to refer to the Asynchronous Query API
     * [startQuery()], instead of getCallerInfo, but since it looks like
     * it is only being used by the provider calls in the messaging app:
     *   1. android.provider.Telephony.Mms.getDisplayAddress()
     *   2. android.provider.Telephony.Sms.getDisplayAddress()
     * We may not need to make the change.
     */
    @DSSource({DSSourceKind.UNIQUE_IDENTIFIER})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.411 -0500", hash_original_method = "AE0F6FD0A3800B899159B72DD57AA38C", hash_generated_method = "88815FCB5523578FB3BBEA604044CB5D")
    
public static String getCallerId(Context context, String number) {
        CallerInfo info = getCallerInfo(context, number);
        String callerID = null;

        if (info != null) {
            String name = info.name;

            if (!TextUtils.isEmpty(name)) {
                callerID = name;
            } else {
                callerID = number;
            }
        }

        return callerID;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.423 -0500", hash_original_method = "71A6B1217E93364C7D01FED08EAA4DA2", hash_generated_method = "45B1D7824A9F151C89386B31B7CDCF36")
    
private static String normalize(String s) {
        if (s == null || s.length() > 0) {
            return s;
        } else {
            return null;
        }
    }

    /**
     * Returns the column index to use to find the "person_id" field in
     * the specified cursor, based on the contact URI that was originally
     * queried.
     *
     * This is a helper function for the getCallerInfo() method that takes
     * a Cursor.  Looking up the person_id is nontrivial (compared to all
     * the other CallerInfo fields) since the column we need to use
     * depends on what query we originally ran.
     *
     * Watch out: be sure to not do any database access in this method, since
     * it's run from the UI thread (see comments below for more info.)
     *
     * @return the columnIndex to use (with cursor.getLong()) to get the
     * person_id, or -1 if we couldn't figure out what colum to use.
     *
     * TODO: Add a unittest for this method.  (This is a little tricky to
     * test, since we'll need a live contacts database to test against,
     * preloaded with at least some phone numbers and SIP addresses.  And
     * we'll probably have to hardcode the column indexes we expect, so
     * the test might break whenever the contacts schema changes.  But we
     * can at least make sure we handle all the URI patterns we claim to,
     * and that the mime types match what we expect...)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.426 -0500", hash_original_method = "97B5B13CD9531D9C33606FD55C18B289", hash_generated_method = "708E7269CAE868800938544CD9E20D21")
    
private static int getColumnIndexForPersonId(Uri contactRef, Cursor cursor) {
        // TODO: This is pretty ugly now, see bug 2269240 for
        // more details. The column to use depends upon the type of URL:
        // - content://com.android.contacts/data/phones ==> use the "contact_id" column
        // - content://com.android.contacts/phone_lookup ==> use the "_ID" column
        // - content://com.android.contacts/data ==> use the "contact_id" column
        // If it's none of the above, we leave columnIndex=-1 which means
        // that the person_id field will be left unset.
        //
        // The logic here *used* to be based on the mime type of contactRef
        // (for example Phone.CONTENT_ITEM_TYPE would tell us to use the
        // RawContacts.CONTACT_ID column).  But looking up the mime type requires
        // a call to context.getContentResolver().getType(contactRef), which
        // isn't safe to do from the UI thread since it can cause an ANR if
        // the contacts provider is slow or blocked (like during a sync.)
        //
        // So instead, figure out the column to use for person_id by just
        // looking at the URI itself.

        if (VDBG) Log.v(TAG, "- getColumnIndexForPersonId: contactRef URI = '"
                        + contactRef + "'...");
        // Warning: Do not enable the following logging (due to ANR risk.)
        // if (VDBG) Log.v(TAG, "- MIME type: "
        //                 + context.getContentResolver().getType(contactRef));

        String url = contactRef.toString();
        String columnName = null;
        if (url.startsWith("content://com.android.contacts/data/phones")) {
            // Direct lookup in the Phone table.
            // MIME type: Phone.CONTENT_ITEM_TYPE (= "vnd.android.cursor.item/phone_v2")
            if (VDBG) Log.v(TAG, "'data/phones' URI; using RawContacts.CONTACT_ID");
            columnName = RawContacts.CONTACT_ID;
        } else if (url.startsWith("content://com.android.contacts/data")) {
            // Direct lookup in the Data table.
            // MIME type: Data.CONTENT_TYPE (= "vnd.android.cursor.dir/data")
            if (VDBG) Log.v(TAG, "'data' URI; using Data.CONTACT_ID");
            // (Note Data.CONTACT_ID and RawContacts.CONTACT_ID are equivalent.)
            columnName = Data.CONTACT_ID;
        } else if (url.startsWith("content://com.android.contacts/phone_lookup")) {
            // Lookup in the PhoneLookup table, which provides "fuzzy matching"
            // for phone numbers.
            // MIME type: PhoneLookup.CONTENT_TYPE (= "vnd.android.cursor.dir/phone_lookup")
            if (VDBG) Log.v(TAG, "'phone_lookup' URI; using PhoneLookup._ID");
            columnName = PhoneLookup._ID;
        } else {
            Log.w(TAG, "Unexpected prefix for contactRef '" + url + "'");
        }
        int columnIndex = (columnName != null) ? cursor.getColumnIndex(columnName) : -1;
        if (VDBG) Log.v(TAG, "==> Using column '" + columnName
                        + "' (columnIndex = " + columnIndex + ") for person_id lookup...");
        return columnIndex;
    }

    /**
     * @return a geographical description string for the specified number.
     * @see com.android.i18n.phonenumbers.PhoneNumberOfflineGeocoder
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.433 -0500", hash_original_method = "4B8F82068E1A8ACD295433986C1E11C8", hash_generated_method = "E14D0297110973E7DC1BD55768C4078F")
    
private static String getGeoDescription(Context context, String number) {
        if (VDBG) Log.v(TAG, "getGeoDescription('" + number + "')...");

        if (TextUtils.isEmpty(number)) {
            return null;
        }

        PhoneNumberUtil util = PhoneNumberUtil.getInstance();
        PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();

        Locale locale = context.getResources().getConfiguration().locale;
        String countryIso = getCurrentCountryIso(context, locale);
        PhoneNumber pn = null;
        try {
            if (VDBG) Log.v(TAG, "parsing '" + number
                            + "' for countryIso '" + countryIso + "'...");
            pn = util.parse(number, countryIso);
            if (VDBG) Log.v(TAG, "- parsed number: " + pn);
        } catch (NumberParseException e) {
            Log.w(TAG, "getGeoDescription: NumberParseException for incoming number '" + number + "'");
        }

        if (pn != null) {
            String description = geocoder.getDescriptionForNumber(pn, locale);
            if (VDBG) Log.v(TAG, "- got description: '" + description + "'");
            return description;
        } else {
            return null;
        }
    }

    /**
     * @return The ISO 3166-1 two letters country code of the country the user
     *         is in.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.436 -0500", hash_original_method = "0D5401F0D97863706C064268E937371A", hash_generated_method = "0C80639C06ED731977181720804DDAFB")
    
private static String getCurrentCountryIso(Context context, Locale locale) {
      String countryIso;
      CountryDetector detector = (CountryDetector) context.getSystemService(
          Context.COUNTRY_DETECTOR);
      if (detector != null) {
        countryIso = detector.detectCountry().getCountryIso();
      } else {
        countryIso = locale.getCountry();
        Log.w(TAG, "No CountryDetector; falling back to countryIso based on locale: "
              + countryIso);
      }
      return countryIso;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.332 -0500", hash_original_field = "24F2322836AB1B8A7BD0513635DB2C39", hash_generated_field = "C5F3F4D6C7BF19031224AC54C88CAD76")

    private static final String TAG = "CallerInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.334 -0500", hash_original_field = "D5BCFD9D55F5E2FDD0A34ACE949618EF", hash_generated_field = "CD7C09194C67AD23C544256A6D8EFBB5")

    private static final boolean VDBG = Log.isLoggable(TAG, Log.VERBOSE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.337 -0500", hash_original_field = "88E44D205DD4CD062C11D9A9EBE039D4", hash_generated_field = "14B5286CD5D74D78D60A61E8C23808CE")

    public static final String UNKNOWN_NUMBER = "-1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.340 -0500", hash_original_field = "400A8812536EC2D8A5A82ED8FC0A8857", hash_generated_field = "F1BFDCCA16CC5317696C3F332263F25D")

    public static final String PRIVATE_NUMBER = "-2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.343 -0500", hash_original_field = "572D897123F626D02CFB052CCD7E3FAB", hash_generated_field = "AD763B8C4A748AFE8A010B8438E44320")

    public static final String PAYPHONE_NUMBER = "-3";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.345 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.348 -0500", hash_original_field = "A04F843FCA6ED01F4CA0662FF1DB199D", hash_generated_field = "440AA77A6AFE31BB4A89DD3D69494FCC")

    public String phoneNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.350 -0500", hash_original_field = "E21455718ED54AF9066F8010A3E5E3B6", hash_generated_field = "1FCAC956C55CA8FE65CE95314F7F25A5")

    public String normalizedNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.352 -0500", hash_original_field = "8BCBB81FE2872579625B63FCCBF9BA9B", hash_generated_field = "B0F47A76CE370376335E2E3B255A2766")

    public String geoDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.354 -0500", hash_original_field = "A86CFAAA1D8CDA1D974D232F92D46C54", hash_generated_field = "B239E8D02EB187DB23B68D6C87ACA90A")

    public String cnapName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.357 -0500", hash_original_field = "091FFF931E0CD34BE4923BA987466B67", hash_generated_field = "6CB3D906347F781338EC2DA9AF9D3365")

    public int numberPresentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.360 -0500", hash_original_field = "721EAC59B6591E31E8992E203B2B56AC", hash_generated_field = "7E759DEFD9070D930A5C3E6F52204FE3")

    public int namePresentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.362 -0500", hash_original_field = "FEA319BCF25E7974B5CF54A6AB87B266", hash_generated_field = "BA5FDC53005F54B6481D897E9773C1AD")

    public boolean contactExists;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.364 -0500", hash_original_field = "95C16318AFD6918358C801BB8461E342", hash_generated_field = "B16EA2F1B36E8F31FFFDD25645C62D92")

    public String phoneLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.366 -0500", hash_original_field = "E16E5C9061E3FE5EA676B56B8F3FE12A", hash_generated_field = "CB2493E4DE6F750739F3F00C76D6A18B")

    public int    numberType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.369 -0500", hash_original_field = "AC150EDA039E39FC33F6127CA31D7746", hash_generated_field = "DC003E91EAF2F383F99FD982D8286299")

    public String numberLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.371 -0500", hash_original_field = "E040943544417634A9F8730D6BF32FF4", hash_generated_field = "7D7BB200679F8010347C035166402B92")

    public int photoResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.373 -0500", hash_original_field = "D890AD54D13DB50B764EDF26A6912FAE", hash_generated_field = "FDDDE3BF3B641EAA1034B3C7122F3126")

    public long person_id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.376 -0500", hash_original_field = "E7876C24AC2FEF19279BE93301995D9B", hash_generated_field = "17EB7188E1B1D845DEEC396DC31CC981")

    public boolean needUpdate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.379 -0500", hash_original_field = "E6FE2C85BD8AED1A45E92536CB58EF94", hash_generated_field = "612D6F5E16D520A8FBC35209D3A929E0")

    public Uri contactRefUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.381 -0500", hash_original_field = "97C454826C52D464945775EACEF122CD", hash_generated_field = "9866CCD528FD6B9BE8BC0A1FABA8076F")

    // including the send to voicemail flag and the ringtone
    // uri reference.
    public Uri contactRingtoneUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.384 -0500", hash_original_field = "30A988FA21E597576878E9B257F59B69", hash_generated_field = "B5047F13B9C79DABFA54CBD97E311123")

    public boolean shouldSendToVoicemail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.386 -0500", hash_original_field = "7C3670BB92C33909031315997ABEA84E", hash_generated_field = "BD5B69D3766879CD2CBA19452914957C")

    public Drawable cachedPhoto;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.388 -0500", hash_original_field = "AD8B69B9C3B44F0BDE9948BD83993F25", hash_generated_field = "BAFA7F448C3A70043BC325312AF1D8E9")

    public boolean isCachedPhotoCurrent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.391 -0500", hash_original_field = "79ACDEE21348FCBA838FCD3882A1E1F2", hash_generated_field = "A071CE64713D0CEBE0F796AE77A242C0")

    private boolean mIsEmergency;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.393 -0500", hash_original_field = "FC816548BA48F427434856E62F32DAFD", hash_generated_field = "FDF7722A08FE4E08F4285E4AC4744B13")

    private boolean mIsVoiceMail;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.395 -0500", hash_original_method = "35A0AB919675AC2E6DFA09874C99CFA1", hash_generated_method = "3203BA7BAB90011193C0ECF77A188AB3")
    
public CallerInfo() {
        // TODO: Move all the basic initialization here?
        mIsEmergency = false;
        mIsVoiceMail = false;
    }

    // Accessors

    /**
     * @return true if the caller info is an emergency number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.414 -0500", hash_original_method = "949F12A508ED637C7BFB9FE80F3ED419", hash_generated_method = "02824529B8E2768EC15C370229C0E676")
    
public boolean isEmergencyNumber() {
        return mIsEmergency;
    }

    /**
     * @return true if the caller info is a voicemail number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.416 -0500", hash_original_method = "61436A0A05C2AD638DF9E2E803CA6155", hash_generated_method = "84A96A2BC608CC5A2D95B9C31C7E5E7D")
    
public boolean isVoiceMailNumber() {
        return mIsVoiceMail;
    }

    /**
     * Mark this CallerInfo as an emergency call.
     * @param context To lookup the localized 'Emergency Number' string.
     * @return this instance.
     */
    // TODO: Note we're setting the phone number here (refer to
    // javadoc comments at the top of CallerInfo class) to a localized
    // string 'Emergency Number'. This is pretty bad because we are
    // making UI work here instead of just packaging the data. We
    // should set the phone number to the dialed number and name to
    // 'Emergency Number' and let the UI make the decision about what
    // should be displayed.
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.418 -0500", hash_original_method = "0EF2E0F94875209BDFD349217543907F", hash_generated_method = "0EF2E0F94875209BDFD349217543907F")
    
CallerInfo markAsEmergency(Context context) {
        phoneNumber = context.getString(
            com.android.internal.R.string.emergency_call_dialog_number_for_display);
        photoResource = com.android.internal.R.drawable.picture_emergency;
        mIsEmergency = true;
        return this;
    }

    /**
     * Mark this CallerInfo as a voicemail call. The voicemail label
     * is obtained from the telephony manager. Caller must hold the
     * READ_PHONE_STATE permission otherwise the phoneNumber will be
     * set to null.
     * @return this instance.
     */
    // TODO: As in the emergency number handling, we end up writing a
    // string in the phone number field.
    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.421 -0500", hash_original_method = "E50E44C9D86336E922CA2AE8F511D506", hash_generated_method = "80AC8B6BE9B156C3EE30B3EFE4A2A8F1")
    
CallerInfo markAsVoiceMail() {
        mIsVoiceMail = true;

        try {
            String voiceMailLabel = TelephonyManager.getDefault().getVoiceMailAlphaTag();

            phoneNumber = voiceMailLabel;
        } catch (SecurityException se) {
            // Should never happen: if this process does not have
            // permission to retrieve VM tag, it should not have
            // permission to retrieve VM number and would not call
            // this method.
            // Leave phoneNumber untouched.
            Log.e(TAG, "Cannot access VoiceMail.", se);
        }
        // TODO: There is no voicemail picture?
        // FIXME: FIND ANOTHER ICON
        // photoResource = android.R.drawable.badge_voicemail;
        return this;
    }

    /**
     * Updates this CallerInfo's geoDescription field, based on the raw
     * phone number in the phoneNumber field.
     *
     * (Note that the various getCallerInfo() methods do *not* set the
     * geoDescription automatically; you need to call this method
     * explicitly to get it.)
     *
     * @param context the context used to look up the current locale / country
     * @param fallbackNumber if this CallerInfo's phoneNumber field is empty,
     *        this specifies a fallback number to use instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.429 -0500", hash_original_method = "3180F1E37BC19852F53F68E8E13D968F", hash_generated_method = "142D116AA6B903156CA8D0D1CDF95D3B")
    
public void updateGeoDescription(Context context, String fallbackNumber) {
        String number = TextUtils.isEmpty(phoneNumber) ? fallbackNumber : phoneNumber;
        geoDescription = getGeoDescription(context, number);
    }

    /**
     * @return a string debug representation of this instance.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:46.440 -0500", hash_original_method = "B2E8AF8AE71BB271A220763604B9FEA5", hash_generated_method = "7A65E4C100BDD67B7E46680E057873AC")
    
public String toString() {
        // Warning: never check in this file with VERBOSE_DEBUG = true
        // because that will result in PII in the system log.
        final boolean VERBOSE_DEBUG = false;

        if (VERBOSE_DEBUG) {
            return new StringBuilder(384)
                    .append(super.toString() + " { ")
                    .append("\nname: " + name)
                    .append("\nphoneNumber: " + phoneNumber)
                    .append("\nnormalizedNumber: " + normalizedNumber)
                    .append("\ngeoDescription: " + geoDescription)
                    .append("\ncnapName: " + cnapName)
                    .append("\nnumberPresentation: " + numberPresentation)
                    .append("\nnamePresentation: " + namePresentation)
                    .append("\ncontactExits: " + contactExists)
                    .append("\nphoneLabel: " + phoneLabel)
                    .append("\nnumberType: " + numberType)
                    .append("\nnumberLabel: " + numberLabel)
                    .append("\nphotoResource: " + photoResource)
                    .append("\nperson_id: " + person_id)
                    .append("\nneedUpdate: " + needUpdate)
                    .append("\ncontactRefUri: " + contactRefUri)
                    .append("\ncontactRingtoneUri: " + contactRefUri)
                    .append("\nshouldSendToVoicemail: " + shouldSendToVoicemail)
                    .append("\ncachedPhoto: " + cachedPhoto)
                    .append("\nisCachedPhotoCurrent: " + isCachedPhotoCurrent)
                    .append("\nemergency: " + mIsEmergency)
                    .append("\nvoicemail " + mIsVoiceMail)
                    .append("\ncontactExists " + contactExists)
                    .append(" }")
                    .toString();
        } else {
            return new StringBuilder(128)
                    .append(super.toString() + " { ")
                    .append("name " + ((name == null) ? "null" : "non-null"))
                    .append(", phoneNumber " + ((phoneNumber == null) ? "null" : "non-null"))
                    .append(" }")
                    .toString();
        }
    }
}

