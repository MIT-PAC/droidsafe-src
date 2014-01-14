package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.DataUsageFeedback;
import android.text.TextUtils;

import com.android.internal.telephony.CallerInfo;
import com.android.internal.telephony.Connection;

public class CallLog {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.790 -0500", hash_original_field = "7D8B302CF1ACA6A4BAD6C21A54A8ACB5", hash_generated_field = "987F87B7D47FA52A14E198986D714BCB")

    public static final String AUTHORITY = "call_log";

    public static class Calls implements BaseColumns {

        /**
         * Adds a call to the call log.
         *
         * @param ci the CallerInfo object to get the target contact from.  Can be null
         * if the contact is unknown.
         * @param context the context used to get the ContentResolver
         * @param number the phone number to be added to the calls db
         * @param presentation the number presenting rules set by the network for
         *        "allowed", "payphone", "restricted" or "unknown"
         * @param callType enumerated values for "incoming", "outgoing", or "missed"
         * @param start time stamp for the call in milliseconds
         * @param duration call duration in seconds
         *
         * {@hide}
         */
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.868 -0500", hash_original_method = "74620372DF35852D8DF70C07592BB0DB", hash_generated_method = "C57146249214A5E939B067E9007562C8")
        
public static Uri addCall(CallerInfo ci, Context context, String number,
                int presentation, int callType, long start, int duration) {
            final ContentResolver resolver = context.getContentResolver();

            // If this is a private number then set the number to Private, otherwise check
            // if the number field is empty and set the number to Unavailable
            if (presentation == Connection.PRESENTATION_RESTRICTED) {
                number = CallerInfo.PRIVATE_NUMBER;
                if (ci != null) ci.name = "";
            } else if (presentation == Connection.PRESENTATION_PAYPHONE) {
                number = CallerInfo.PAYPHONE_NUMBER;
                if (ci != null) ci.name = "";
            } else if (TextUtils.isEmpty(number)
                    || presentation == Connection.PRESENTATION_UNKNOWN) {
                number = CallerInfo.UNKNOWN_NUMBER;
                if (ci != null) ci.name = "";
            }

            ContentValues values = new ContentValues(5);

            values.put(NUMBER, number);
            values.put(TYPE, Integer.valueOf(callType));
            values.put(DATE, Long.valueOf(start));
            values.put(DURATION, Long.valueOf(duration));
            values.put(NEW, Integer.valueOf(1));
            if (callType == MISSED_TYPE) {
                values.put(IS_READ, Integer.valueOf(0));
            }
            if (ci != null) {
                values.put(CACHED_NAME, ci.name);
                values.put(CACHED_NUMBER_TYPE, ci.numberType);
                values.put(CACHED_NUMBER_LABEL, ci.numberLabel);
            }

            if ((ci != null) && (ci.person_id > 0)) {
                // Update usage information for the number associated with the contact ID.
                // We need to use both the number and the ID for obtaining a data ID since other
                // contacts may have the same number.

                final Cursor cursor;

                // We should prefer normalized one (probably coming from
                // Phone.NORMALIZED_NUMBER column) first. If it isn't available try others.
                if (ci.normalizedNumber != null) {
                    final String normalizedPhoneNumber = ci.normalizedNumber;
                    cursor = resolver.query(Phone.CONTENT_URI,
                            new String[] { Phone._ID },
                            Phone.CONTACT_ID + " =? AND " + Phone.NORMALIZED_NUMBER + " =?",
                            new String[] { String.valueOf(ci.person_id), normalizedPhoneNumber},
                            null);
                } else {
                    final String phoneNumber = ci.phoneNumber != null ? ci.phoneNumber : number;
                    cursor = resolver.query(Phone.CONTENT_URI,
                            new String[] { Phone._ID },
                            Phone.CONTACT_ID + " =? AND " + Phone.NUMBER + " =?",
                            new String[] { String.valueOf(ci.person_id), phoneNumber},
                            null);
                }

                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                            final Uri feedbackUri = DataUsageFeedback.FEEDBACK_URI.buildUpon()
                                    .appendPath(cursor.getString(0))
                                    .appendQueryParameter(DataUsageFeedback.USAGE_TYPE,
                                                DataUsageFeedback.USAGE_TYPE_CALL)
                                    .build();
                            resolver.update(feedbackUri, new ContentValues(), null, null);
                        }
                    } finally {
                        cursor.close();
                    }
                }
            }

            Uri result = resolver.insert(CONTENT_URI, values);

            removeExpiredEntries(context);

            return result;
        }

        /**
         * Query the call log database for the last dialed number.
         * @param context Used to get the content resolver.
         * @return The last phone number dialed (outgoing) or an empty
         * string if none exist yet.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.871 -0500", hash_original_method = "1042605925515703D39AFE4A37293EE2", hash_generated_method = "5200EB6B67949FD50EC02D2AADD3B16C")
        
public static String getLastOutgoingCall(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            Cursor c = null;
            try {
                c = resolver.query(
                    CONTENT_URI,
                    new String[] {NUMBER},
                    TYPE + " = " + OUTGOING_TYPE,
                    null,
                    DEFAULT_SORT_ORDER + " LIMIT 1");
                if (c == null || !c.moveToFirst()) {
                    return "";
                }
                return c.getString(0);
            } finally {
                if (c != null) c.close();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.873 -0500", hash_original_method = "E49FD2EBB5DF26A9EAF75051416A16BA", hash_generated_method = "E8D346CDF75EBA404884537B0949CB1C")
        
private static void removeExpiredEntries(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.delete(CONTENT_URI, "_id IN " +
                    "(SELECT _id FROM calls ORDER BY " + DEFAULT_SORT_ORDER
                    + " LIMIT -1 OFFSET 500)", null);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.797 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "CAC38F5D9603A51E678E221EBC178C48")

        public static final Uri CONTENT_URI =
                Uri.parse("content://call_log/calls");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.799 -0500", hash_original_field = "DFB49FE4A5BA9FC1B5373D88A9D1C8CE", hash_generated_field = "45C94B037DAEB18A1DB94980F8E014D6")

        public static final Uri CONTENT_FILTER_URI =
                Uri.parse("content://call_log/calls/filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.802 -0500", hash_original_field = "0BC3C6386115851033A7F6B282841FD2", hash_generated_field = "EDB33797405798F7464E980CF780C594")

        public static final String ALLOW_VOICEMAILS_PARAM_KEY = "allow_voicemails";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.804 -0500", hash_original_field = "2EEAF9E91AB86033A78D46730D6F5C79", hash_generated_field = "38AF17981EA594ABC0FDE070BC7DF7DB")

        public static final Uri CONTENT_URI_WITH_VOICEMAIL = CONTENT_URI.buildUpon()
                .appendQueryParameter(ALLOW_VOICEMAILS_PARAM_KEY, "true")
                .build();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.807 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.809 -0500", hash_original_field = "39C9151A03484B5A3E685DAA20C9B413", hash_generated_field = "1CDEC54DDEB2A49C77C7020C37521533")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/calls";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.812 -0500", hash_original_field = "BBCF2A2F353DD878F7DD74BDE8678E1E", hash_generated_field = "6C744BC8399B88080C23AB7CE06EE249")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.814 -0500", hash_original_field = "2280480E1208717EAE9778EC9DC63E6D", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.817 -0500", hash_original_field = "28C420D38F99C7766184CE761CAF98BF", hash_generated_field = "F618762E05A7376181584B861DB937F5")

        public static final int INCOMING_TYPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.819 -0500", hash_original_field = "C07F20DC62FDBA6C651641ACE44DB609", hash_generated_field = "7808F2B3B097303F23C3B4C89BE9F7F9")

        public static final int OUTGOING_TYPE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.822 -0500", hash_original_field = "7C7D90F1FC82E2B389604B9351D1E62D", hash_generated_field = "506E4A324171E52485D756458CBD610F")

        public static final int MISSED_TYPE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.824 -0500", hash_original_field = "DA61705E10274AD2623AD4900D764F4D", hash_generated_field = "7BE55ED442F01B858859F78F23380EF5")

        public static final int VOICEMAIL_TYPE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.826 -0500", hash_original_field = "4D0561A33768FC99239D229ECBB5E8EE", hash_generated_field = "3808C95497BF3A863D267480A226478B")

        public static final String NUMBER = "number";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.828 -0500", hash_original_field = "E09580B942B4982C3EE90E27E00D1A6D", hash_generated_field = "0E793CB23992310CFA8613C8268614D8")

        public static final String COUNTRY_ISO = "countryiso";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.831 -0500", hash_original_field = "5B6FCEF8C44CB783DFFC37049083A6ED", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.833 -0500", hash_original_field = "DD3D3C287DEDDAA5E4CDB58BDA0563B7", hash_generated_field = "7EEDC36F9B355462B2B6A1B5716031CA")

        public static final String DURATION = "duration";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.836 -0500", hash_original_field = "E539F1DEDB847A2CEDE31D51C69BB970", hash_generated_field = "22598556B347941265ECFCC804153EBF")

        public static final String NEW = "new";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.839 -0500", hash_original_field = "9497D9A328A337B4BC414EE852B35CEE", hash_generated_field = "2412BCD310FC080CDF680C631DF994A9")

        public static final String CACHED_NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.841 -0500", hash_original_field = "F796590220A20DB7457A69E7FE0D24EF", hash_generated_field = "992804A4017175A6A3BFD0811656A9FD")

        public static final String CACHED_NUMBER_TYPE = "numbertype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.845 -0500", hash_original_field = "5B9F4A0A52B0BA8DBD9B832D6491818D", hash_generated_field = "4D1E26746BD4CBFF1B74FE54C0A587E1")

        public static final String CACHED_NUMBER_LABEL = "numberlabel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.847 -0500", hash_original_field = "92B1D6EAE13DD58DC0E6D4D95C960B2F", hash_generated_field = "93ED8118F1C5A0761F9FE4A032B6C8C1")

        public static final String VOICEMAIL_URI = "voicemail_uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.850 -0500", hash_original_field = "AF9A83ED95F6DAB436FDC341B1D2BB6E", hash_generated_field = "472C2B10CBB781F23780EBEBA3F15DAD")

        public static final String IS_READ = "is_read";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.852 -0500", hash_original_field = "950FB4C7F3865ADEA7A723AAE44911BC", hash_generated_field = "EFE1380E6C29C11B17E15016AD67FA7C")

        public static final String GEOCODED_LOCATION = "geocoded_location";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.855 -0500", hash_original_field = "5A41AAF2353BB46F28C0CB3F4D1434B9", hash_generated_field = "F2C2B5EA743D3271A3CEEDF79ABB780F")

        public static final String CACHED_LOOKUP_URI = "lookup_uri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.857 -0500", hash_original_field = "E6DA00D3AC646718154357E24B7693C5", hash_generated_field = "9A1A1943DD7E3F20EA4C2DD553CCAEBA")

        public static final String CACHED_MATCHED_NUMBER = "matched_number";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.859 -0500", hash_original_field = "FE53F898A8DF7E23FB7112A874DC75A2", hash_generated_field = "ACEF105CFC56C22F33A0A761D63639F2")

        public static final String CACHED_NORMALIZED_NUMBER = "normalized_number";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.862 -0500", hash_original_field = "22C5C708114E95D2447F2913A7A786C5", hash_generated_field = "4CFA92B5C0FF40271E7526060762580E")

        public static final String CACHED_PHOTO_ID = "photo_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.864 -0500", hash_original_field = "1DD090F91133031097BFBBB2085C81E5", hash_generated_field = "D806B6D11CCD4F0CE94A125CFD3EA887")

        public static final String CACHED_FORMATTED_NUMBER = "formatted_number";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.097 -0400", hash_original_method = "E2028324A117DAF09158B486FB038B63", hash_generated_method = "E2028324A117DAF09158B486FB038B63")
        public Calls ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:55.793 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "D118CEA06FF497F93B41482BB0D0564B")

    public static final Uri CONTENT_URI =
        Uri.parse("content://" + AUTHORITY);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.096 -0400", hash_original_method = "EA6E95983D6BBE8DD1267831A542BD27", hash_generated_method = "EA6E95983D6BBE8DD1267831A542BD27")
    public CallLog ()
    {
        //Synthesized constructor
    }
}

