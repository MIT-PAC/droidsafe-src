package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Locale;

public class CallerInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "C9AA10B21BC611B05B1D8E0C01E5D397", hash_generated_field = "440AA77A6AFE31BB4A89DD3D69494FCC")

    public String phoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "C114141BFE3BC6FDD56AED00DC448ADE", hash_generated_field = "1FCAC956C55CA8FE65CE95314F7F25A5")

    public String normalizedNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "CDB8D222ACA67FF09D8089731C878093", hash_generated_field = "B0F47A76CE370376335E2E3B255A2766")

    public String geoDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "05B2F7F3A77F16B32088D3A5F859DA1D", hash_generated_field = "B239E8D02EB187DB23B68D6C87ACA90A")

    public String cnapName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "F00A6033EECCE0EBD17BDAAC2E6671A9", hash_generated_field = "6CB3D906347F781338EC2DA9AF9D3365")

    public int numberPresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "2EA6554455FD669EC0582028CFF50FED", hash_generated_field = "7E759DEFD9070D930A5C3E6F52204FE3")

    public int namePresentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "575EAA188F5AFC5576C746A9B16FF554", hash_generated_field = "BA5FDC53005F54B6481D897E9773C1AD")

    public boolean contactExists;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "A6E1333E7C7DF540FCBAC999B871D5D2", hash_generated_field = "B16EA2F1B36E8F31FFFDD25645C62D92")

    public String phoneLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "C96EC7AE450E302C973C98A94F4C4F8E", hash_generated_field = "CB2493E4DE6F750739F3F00C76D6A18B")

    public int numberType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "19789316F27DD72CAD6704F393DBCD98", hash_generated_field = "DC003E91EAF2F383F99FD982D8286299")

    public String numberLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "F552EBBF7088E9FBBC94484D8415B926", hash_generated_field = "7D7BB200679F8010347C035166402B92")

    public int photoResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "A8452CA7C1312F959E1307FE2D017EB0", hash_generated_field = "FDDDE3BF3B641EAA1034B3C7122F3126")

    public long person_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "16501DD19601E7EF2AA421BF34585F73", hash_generated_field = "17EB7188E1B1D845DEEC396DC31CC981")

    public boolean needUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "6836761401024E3A571DCC238DC95557", hash_generated_field = "612D6F5E16D520A8FBC35209D3A929E0")

    public Uri contactRefUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "D99CB9FD030B240963A5842DDBF476F4", hash_generated_field = "40E4CFFDC861CB7D8A3A28A79FE8B4E5")

    public Uri contactRingtoneUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "EA6B3607E408CD3F2FD02E4E65968491", hash_generated_field = "B5047F13B9C79DABFA54CBD97E311123")

    public boolean shouldSendToVoicemail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "C409C4D7582ADF222CAF71808869B31F", hash_generated_field = "BD5B69D3766879CD2CBA19452914957C")

    public Drawable cachedPhoto;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "A14B1CB28C7C251E6859B9F351B19B21", hash_generated_field = "BAFA7F448C3A70043BC325312AF1D8E9")

    public boolean isCachedPhotoCurrent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "7376A55F5290745246270E1790E042B5", hash_generated_field = "A071CE64713D0CEBE0F796AE77A242C0")

    private boolean mIsEmergency;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_field = "4452D8CFC3290241F7E75DF22D239FD7", hash_generated_field = "FDF7722A08FE4E08F4285E4AC4744B13")

    private boolean mIsVoiceMail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.577 -0400", hash_original_method = "35A0AB919675AC2E6DFA09874C99CFA1", hash_generated_method = "7EF09FC36F6EA834DB6A5FF04EABDDBC")
    public  CallerInfo() {
        mIsEmergency = false;
        mIsVoiceMail = false;
        // ---------- Original Method ----------
        //mIsEmergency = false;
        //mIsVoiceMail = false;
    }

    
    @DSModeled(DSC.SPEC)
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
                int columnIndex;
                columnIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
                if (columnIndex != -1) {
                    info.name = cursor.getString(columnIndex);
                }
                columnIndex = cursor.getColumnIndex(PhoneLookup.NUMBER);
                if (columnIndex != -1) {
                    info.phoneNumber = cursor.getString(columnIndex);
                }
                columnIndex = cursor.getColumnIndex(PhoneLookup.NORMALIZED_NUMBER);
                if (columnIndex != -1) {
                    info.normalizedNumber = cursor.getString(columnIndex);
                }
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
                columnIndex = getColumnIndexForPersonId(contactRef, cursor);
                if (columnIndex != -1) {
                    info.person_id = cursor.getLong(columnIndex);
                    if (VDBG) Log.v(TAG, "==> got info.person_id: " + info.person_id);
                } else {
                    Log.w(TAG, "Couldn't find person_id column for " + contactRef);
                }
                columnIndex = cursor.getColumnIndex(PhoneLookup.CUSTOM_RINGTONE);
                if ((columnIndex != -1) && (cursor.getString(columnIndex) != null)) {
                    info.contactRingtoneUri = Uri.parse(cursor.getString(columnIndex));
                } else {
                    info.contactRingtoneUri = null;
                }
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

    
    @DSModeled(DSC.SPEC)
    public static CallerInfo getCallerInfo(Context context, Uri contactRef) {
        return getCallerInfo(context, contactRef,
                context.getContentResolver().query(contactRef, null, null, null, null));
    }

    
    @DSModeled(DSC.SPEC)
    public static CallerInfo getCallerInfo(Context context, String number) {
        if (VDBG) Log.v(TAG, "getCallerInfo() based on number...");
        if (TextUtils.isEmpty(number)) {
            return null;
        }
        if (PhoneNumberUtils.isLocalEmergencyNumber(number, context)) {
            return new CallerInfo().markAsEmergency(context);
        } else if (PhoneNumberUtils.isVoiceMailNumber(number)) {
            return new CallerInfo().markAsVoiceMail();
        }
        Uri contactUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        CallerInfo info = getCallerInfo(context, contactUri);
        info = doSecondaryLookupIfNecessary(context, number, info);
        if (TextUtils.isEmpty(info.phoneNumber)) {
            info.phoneNumber = number;
        }
        return info;
    }

    
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.578 -0400", hash_original_method = "949F12A508ED637C7BFB9FE80F3ED419", hash_generated_method = "37FA2DA01082417026523AF47BA0779F")
    public boolean isEmergencyNumber() {
        boolean var7376A55F5290745246270E1790E042B5_690769222 = (mIsEmergency);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566582224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_566582224;
        // ---------- Original Method ----------
        //return mIsEmergency;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.578 -0400", hash_original_method = "61436A0A05C2AD638DF9E2E803CA6155", hash_generated_method = "5D7D3D54D64F05799111E78C5175F45E")
    public boolean isVoiceMailNumber() {
        boolean var4452D8CFC3290241F7E75DF22D239FD7_623479805 = (mIsVoiceMail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966114545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966114545;
        // ---------- Original Method ----------
        //return mIsVoiceMail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.578 -0400", hash_original_method = "0EF2E0F94875209BDFD349217543907F", hash_generated_method = "680AF92753A12CD38D8F57C4697879D6")
     CallerInfo markAsEmergency(Context context) {
        phoneNumber = context.getString(
            com.android.internal.R.string.emergency_call_dialog_number_for_display);
        photoResource = com.android.internal.R.drawable.picture_emergency;
        mIsEmergency = true;
CallerInfo var72A74007B2BE62B849F475C7BDA4658B_1616552895 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1616552895.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1616552895;
        // ---------- Original Method ----------
        //phoneNumber = context.getString(
            //com.android.internal.R.string.emergency_call_dialog_number_for_display);
        //photoResource = com.android.internal.R.drawable.picture_emergency;
        //mIsEmergency = true;
        //return this;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.578 -0400", hash_original_method = "E50E44C9D86336E922CA2AE8F511D506", hash_generated_method = "4BD684E00DB08079E2E6C45704D4A3A8")
     CallerInfo markAsVoiceMail() {
        mIsVoiceMail = true;
        try 
        {
            String voiceMailLabel = TelephonyManager.getDefault().getVoiceMailAlphaTag();
            phoneNumber = voiceMailLabel;
        } //End block
        catch (SecurityException se)
        {
        } //End block
CallerInfo var72A74007B2BE62B849F475C7BDA4658B_1258116002 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1258116002.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1258116002;
        // ---------- Original Method ----------
        //mIsVoiceMail = true;
        //try {
            //String voiceMailLabel = TelephonyManager.getDefault().getVoiceMailAlphaTag();
            //phoneNumber = voiceMailLabel;
        //} catch (SecurityException se) {
            //Log.e(TAG, "Cannot access VoiceMail.", se);
        //}
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    private static String normalize(String s) {
        if (s == null || s.length() > 0) {
            return s;
        } else {
            return null;
        }
    }

    
    @DSModeled(DSC.SPEC)
    private static int getColumnIndexForPersonId(Uri contactRef, Cursor cursor) {
        if (VDBG) Log.v(TAG, "- getColumnIndexForPersonId: contactRef URI = '"
                        + contactRef + "'...");
        String url = contactRef.toString();
        String columnName = null;
        if (url.startsWith("content://com.android.contacts/data/phones")) {
            if (VDBG) Log.v(TAG, "'data/phones' URI; using RawContacts.CONTACT_ID");
            columnName = RawContacts.CONTACT_ID;
        } else if (url.startsWith("content://com.android.contacts/data")) {
            if (VDBG) Log.v(TAG, "'data' URI; using Data.CONTACT_ID");
            columnName = Data.CONTACT_ID;
        } else if (url.startsWith("content://com.android.contacts/phone_lookup")) {
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.579 -0400", hash_original_method = "3180F1E37BC19852F53F68E8E13D968F", hash_generated_method = "4C6D13AE6F83DD7FE5892D790FE2AE9F")
    public void updateGeoDescription(Context context, String fallbackNumber) {
        addTaint(fallbackNumber.getTaint());
        String number = TextUtils.isEmpty(phoneNumber) ? fallbackNumber : phoneNumber;
        geoDescription = getGeoDescription(context, number);
        // ---------- Original Method ----------
        //String number = TextUtils.isEmpty(phoneNumber) ? fallbackNumber : phoneNumber;
        //geoDescription = getGeoDescription(context, number);
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.580 -0400", hash_original_method = "B2E8AF8AE71BB271A220763604B9FEA5", hash_generated_method = "1016AA1CC9C20FA62A99D0AAB6DF1DB8")
    public String toString() {
        final boolean VERBOSE_DEBUG = false;
        if(VERBOSE_DEBUG)        
        {
String varB0E974098EC24B66E77031F32EEA3BB7_827666372 =             new StringBuilder(384)
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
            varB0E974098EC24B66E77031F32EEA3BB7_827666372.addTaint(taint);
            return varB0E974098EC24B66E77031F32EEA3BB7_827666372;
        } //End block
        else
        {
String varEB68FA4DA29D6D2DA3AE46CB2065A18F_1323246221 =             new StringBuilder(128)
                    .append(super.toString() + " { ")
                    .append("name " + ((name == null) ? "null" : "non-null"))
                    .append(", phoneNumber " + ((phoneNumber == null) ? "null" : "non-null"))
                    .append(" }")
                    .toString();
            varEB68FA4DA29D6D2DA3AE46CB2065A18F_1323246221.addTaint(taint);
            return varEB68FA4DA29D6D2DA3AE46CB2065A18F_1323246221;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.581 -0400", hash_original_field = "B4956EA7908FECA8BF408633E06F5234", hash_generated_field = "C5F3F4D6C7BF19031224AC54C88CAD76")

    private static final String TAG = "CallerInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.581 -0400", hash_original_field = "0BC31D132ED22BDCCE73050D2E753EDE", hash_generated_field = "CD7C09194C67AD23C544256A6D8EFBB5")

    private static final boolean VDBG = Log.isLoggable(TAG, Log.VERBOSE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.581 -0400", hash_original_field = "86FBD2801D6BC73E16D3D03603642188", hash_generated_field = "14B5286CD5D74D78D60A61E8C23808CE")

    public static final String UNKNOWN_NUMBER = "-1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.581 -0400", hash_original_field = "44E8780CF940019656CD29807BC39C33", hash_generated_field = "F1BFDCCA16CC5317696C3F332263F25D")

    public static final String PRIVATE_NUMBER = "-2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.581 -0400", hash_original_field = "B57F7F5D5DF09506AE80865F0E28CBA7", hash_generated_field = "AD763B8C4A748AFE8A010B8438E44320")

    public static final String PAYPHONE_NUMBER = "-3";
}

