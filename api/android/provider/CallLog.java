package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.CallerInfo;
import com.android.internal.telephony.Connection;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.DataUsageFeedback;
import android.text.TextUtils;

public class CallLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.986 -0400", hash_original_method = "EA6E95983D6BBE8DD1267831A542BD27", hash_generated_method = "EA6E95983D6BBE8DD1267831A542BD27")
    public CallLog ()
    {
        //Synthesized constructor
    }


    public static class Calls implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.987 -0400", hash_original_method = "E2028324A117DAF09158B486FB038B63", hash_generated_method = "E2028324A117DAF09158B486FB038B63")
        public Calls ()
        {
            //Synthesized constructor
        }


                public static Uri addCall(CallerInfo ci, Context context, String number,
                int presentation, int callType, long start, int duration) {
            final ContentResolver resolver = context.getContentResolver();
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
                final Cursor cursor;
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

        
                private static void removeExpiredEntries(Context context) {
            final ContentResolver resolver = context.getContentResolver();
            resolver.delete(CONTENT_URI, "_id IN " +
                    "(SELECT _id FROM calls ORDER BY " + DEFAULT_SORT_ORDER
                    + " LIMIT -1 OFFSET 500)", null);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "153249C665F5448863BB2653FD694744", hash_generated_field = "CAC38F5D9603A51E678E221EBC178C48")

        public static final Uri CONTENT_URI =
                Uri.parse("content://call_log/calls");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "1F3BA6DBCF4070DE2DE35E77B13B73BB", hash_generated_field = "45C94B037DAEB18A1DB94980F8E014D6")

        public static final Uri CONTENT_FILTER_URI =
                Uri.parse("content://call_log/calls/filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "2462CBD6ACF90DE085A5F9B2A9B75826", hash_generated_field = "EDB33797405798F7464E980CF780C594")

        public static final String ALLOW_VOICEMAILS_PARAM_KEY = "allow_voicemails";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "DBF711667EDC9F2F01E2B4A8563150F9", hash_generated_field = "38AF17981EA594ABC0FDE070BC7DF7DB")

        public static final Uri CONTENT_URI_WITH_VOICEMAIL = CONTENT_URI.buildUpon()
                .appendQueryParameter(ALLOW_VOICEMAILS_PARAM_KEY, "true")
                .build();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "50FB9118AACAD9EA63B6A3A51CE6180C", hash_generated_field = "1CDEC54DDEB2A49C77C7020C37521533")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/calls";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.989 -0400", hash_original_field = "ADBC3BFF5917606C4C3A18414C502277", hash_generated_field = "6C744BC8399B88080C23AB7CE06EE249")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/calls";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "3A93FC6551B100BB870FF7F82CF9B7F1", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "B0BCD542CB2A22B1201E548C36D2CCB6", hash_generated_field = "F618762E05A7376181584B861DB937F5")

        public static final int INCOMING_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "ACAD0B07830F2EEE784226AD2BEA369C", hash_generated_field = "7808F2B3B097303F23C3B4C89BE9F7F9")

        public static final int OUTGOING_TYPE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "53EB9DF32F5CBB2FD8059A5BC82CFD03", hash_generated_field = "506E4A324171E52485D756458CBD610F")

        public static final int MISSED_TYPE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "6976EA3C7EAE52AE15530BECB0EBD71E", hash_generated_field = "7BE55ED442F01B858859F78F23380EF5")

        public static final int VOICEMAIL_TYPE = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "8663F16736685D3CA4C4B875BEE0226E", hash_generated_field = "3808C95497BF3A863D267480A226478B")

        public static final String NUMBER = "number";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "CE5A8C4E918AF9219A4FDD00BC227680", hash_generated_field = "0E793CB23992310CFA8613C8268614D8")

        public static final String COUNTRY_ISO = "countryiso";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "F0E69C8EA78964FE5493D0AE61D90B08", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "23FB4634947E2079559441F67EC8DEEE", hash_generated_field = "7EEDC36F9B355462B2B6A1B5716031CA")

        public static final String DURATION = "duration";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "2E527DD01AF241B089F9A8949A00BC60", hash_generated_field = "22598556B347941265ECFCC804153EBF")

        public static final String NEW = "new";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "B56E3EA5BE3DB2F91309BFBFD16A114D", hash_generated_field = "2412BCD310FC080CDF680C631DF994A9")

        public static final String CACHED_NAME = "name";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.990 -0400", hash_original_field = "3CED9C8457978ACB7C43545E731AE8CF", hash_generated_field = "992804A4017175A6A3BFD0811656A9FD")

        public static final String CACHED_NUMBER_TYPE = "numbertype";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "A154CA5CC48B8235E814739DA692B282", hash_generated_field = "4D1E26746BD4CBFF1B74FE54C0A587E1")

        public static final String CACHED_NUMBER_LABEL = "numberlabel";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "5932584E87DD06C001A71B0B7EF45954", hash_generated_field = "93ED8118F1C5A0761F9FE4A032B6C8C1")

        public static final String VOICEMAIL_URI = "voicemail_uri";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "C2F694F57F94B275C3C4D7E00FBA1626", hash_generated_field = "472C2B10CBB781F23780EBEBA3F15DAD")

        public static final String IS_READ = "is_read";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "C2494E2035F082249D7912D10E9967BA", hash_generated_field = "EFE1380E6C29C11B17E15016AD67FA7C")

        public static final String GEOCODED_LOCATION = "geocoded_location";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "EA466B6901A8CFC11851D0ABF6FB0F6F", hash_generated_field = "F2C2B5EA743D3271A3CEEDF79ABB780F")

        public static final String CACHED_LOOKUP_URI = "lookup_uri";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "070B94AAAE14663AFBE5E3FD74FE035C", hash_generated_field = "9A1A1943DD7E3F20EA4C2DD553CCAEBA")

        public static final String CACHED_MATCHED_NUMBER = "matched_number";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "43593BE6440F5D96C9998AFB5AA3466B", hash_generated_field = "ACEF105CFC56C22F33A0A761D63639F2")

        public static final String CACHED_NORMALIZED_NUMBER = "normalized_number";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "3B1205B94DE016F920D353516EFED404", hash_generated_field = "4CFA92B5C0FF40271E7526060762580E")

        public static final String CACHED_PHOTO_ID = "photo_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "E258B137F78ECE03F4C155A713AC389B", hash_generated_field = "D806B6D11CCD4F0CE94A125CFD3EA887")

        public static final String CACHED_FORMATTED_NUMBER = "formatted_number";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "FA48C0AC92AB4CD71F50F750083FC02B", hash_generated_field = "987F87B7D47FA52A14E198986D714BCB")

    public static final String AUTHORITY = "call_log";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:34.991 -0400", hash_original_field = "083A9A6E0091C7159BC5D55CE6FC0135", hash_generated_field = "D118CEA06FF497F93B41482BB0D0564B")

    public static final Uri CONTENT_URI =
        Uri.parse("content://" + AUTHORITY);
}

