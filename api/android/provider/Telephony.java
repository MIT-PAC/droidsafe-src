package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

public final class Telephony {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.499 -0500", hash_original_field = "D931A40C2887EFBBFF2F87E737A651E0", hash_generated_field = "77836E000F3832B9A06FE340F2EDE5DC")

    private static final String TAG = "Telephony";
    
    public static final class Sms implements BaseColumns, TextBasedSmsColumns {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.524 -0500", hash_original_method = "91491FADEEC62466B0F9FF75744CEEB2", hash_generated_method = "4116C537EA1E1C0A55E8CE52971B78AD")
        
public static final Cursor query(ContentResolver cr, String[] projection) {
            return cr.query(CONTENT_URI, projection, null, null, DEFAULT_SORT_ORDER);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.527 -0500", hash_original_method = "B0F13298A0CBF5A4AA63780A1FEDFE05", hash_generated_method = "FB43394C3A2ED7C0643EFD2496CAF1D5")
        
public static final Cursor query(ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return cr.query(CONTENT_URI, projection, where,
                                         null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
        }

        /**
         * Add an SMS to the given URI.
         *
         * @param resolver the content resolver to use
         * @param uri the URI to add the message to
         * @param address the address of the sender
         * @param body the body of the message
         * @param subject the psuedo-subject of the message
         * @param date the timestamp for the message
         * @param read true if the message has been read, false if not
         * @param deliveryReport true if a delivery report was requested, false if not
         * @return the URI for the new message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.535 -0500", hash_original_method = "90E3D05E7FA8C4A5A0CC776C9A15B4D4", hash_generated_method = "638BC91476844A0336C657D1247F41AF")
        
public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport) {
            return addMessageToUri(resolver, uri, address, body, subject,
                    date, read, deliveryReport, -1L);
        }

        /**
         * Add an SMS to the given URI with thread_id specified.
         *
         * @param resolver the content resolver to use
         * @param uri the URI to add the message to
         * @param address the address of the sender
         * @param body the body of the message
         * @param subject the psuedo-subject of the message
         * @param date the timestamp for the message
         * @param read true if the message has been read, false if not
         * @param deliveryReport true if a delivery report was requested, false if not
         * @param threadId the thread_id of the message
         * @return the URI for the new message
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.537 -0500", hash_original_method = "9A391F653EB77CB550BC26AB7CC01602", hash_generated_method = "A608344FBF0D790676D8628D631977D9")
        
public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport, long threadId) {
            ContentValues values = new ContentValues(7);

            values.put(ADDRESS, address);
            if (date != null) {
                values.put(DATE, date);
            }
            values.put(READ, read ? Integer.valueOf(1) : Integer.valueOf(0));
            values.put(SUBJECT, subject);
            values.put(BODY, body);
            if (deliveryReport) {
                values.put(STATUS, STATUS_PENDING);
            }
            if (threadId != -1L) {
                values.put(THREAD_ID, threadId);
            }
            return resolver.insert(uri, values);
        }

        /**
         * Move a message to the given folder.
         *
         * @param context the context to use
         * @param uri the message to move
         * @param folder the folder to move to
         * @return true if the operation succeeded
         */
        @DSSink({DSSinkKind.SMS_MMS})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.540 -0500", hash_original_method = "0C99D40A04CE0C54D0586AC5BB676809", hash_generated_method = "FABA5607187BC6A04AE4466752028609")
        
public static boolean moveMessageToFolder(Context context,
                Uri uri, int folder, int error) {
            if (uri == null) {
                return false;
            }

            boolean markAsUnread = false;
            boolean markAsRead = false;
            switch(folder) {
            case MESSAGE_TYPE_INBOX:
            case MESSAGE_TYPE_DRAFT:
                break;
            case MESSAGE_TYPE_OUTBOX:
            case MESSAGE_TYPE_SENT:
                markAsRead = true;
                break;
            case MESSAGE_TYPE_FAILED:
            case MESSAGE_TYPE_QUEUED:
                markAsUnread = true;
                break;
            default:
                return false;
            }

            ContentValues values = new ContentValues(3);

            values.put(TYPE, folder);
            if (markAsUnread) {
                values.put(READ, Integer.valueOf(0));
            } else if (markAsRead) {
                values.put(READ, Integer.valueOf(1));
            }
            values.put(ERROR_CODE, error);

            return 1 == SqliteWrapper.update(context, context.getContentResolver(),
                            uri, values, null, null);
        }

        /**
         * Returns true iff the folder (message type) identifies an
         * outgoing message.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.542 -0500", hash_original_method = "1CCE7318461ADE9CB53CE2EA893C8873", hash_generated_method = "90A482B97B590AF1BE73CDF7AA7E340D")
        
public static boolean isOutgoingFolder(int messageType) {
            return  (messageType == MESSAGE_TYPE_FAILED)
                    || (messageType == MESSAGE_TYPE_OUTBOX)
                    || (messageType == MESSAGE_TYPE_SENT)
                    || (messageType == MESSAGE_TYPE_QUEUED);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.530 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "5E4676401D5C3305160757D85A228BC4")

        public static final Uri CONTENT_URI =
            Uri.parse("content://sms");
        
        public static final class Inbox implements BaseColumns, TextBasedSmsColumns {

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @param read true if the message has been read, false if not
             * @return the URI for the new message
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.552 -0500", hash_original_method = "24A367F278E951BFB0108340D732C0BD", hash_generated_method = "91C312071CD24E43C61BF1F37B0EC04E")
            
public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean read) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, read, false);
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.760 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "F9CAEE6005B47FC2B06B1883EC29741D")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/inbox");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.762 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.891 -0400", hash_original_method = "141F91EDC6AE2D7033D3DA3E508699AC", hash_generated_method = "141F91EDC6AE2D7033D3DA3E508699AC")
            public Inbox ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Sent implements BaseColumns, TextBasedSmsColumns {

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @return the URI for the new message
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.563 -0500", hash_original_method = "B05C371FE3D3E8ED1D5DB9B0F1B6DE4B", hash_generated_method = "4473028CCD135DEA7DEAAF783BCB6AF9")
            
public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.767 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "D3824F01E3D7A102678F440DA457F6A8")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/sent");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.770 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.892 -0400", hash_original_method = "01BACB9453826DDA962919BC9AB080EE", hash_generated_method = "01BACB9453826DDA962919BC9AB080EE")
            public Sent ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Draft implements BaseColumns, TextBasedSmsColumns {

            /**
             * Add an SMS to the Draft box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @return the URI for the new message
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.573 -0500", hash_original_method = "B05C371FE3D3E8ED1D5DB9B0F1B6DE4B", hash_generated_method = "4473028CCD135DEA7DEAAF783BCB6AF9")
            
public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }

            /**
             * Save over an existing draft message.
             *
             * @param resolver the content resolver to use
             * @param uri of existing message
             * @param body the new body for the draft message
             * @return true is successful, false otherwise
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.576 -0500", hash_original_method = "B78F91348B547B443EE01569E11C3D93", hash_generated_method = "9B48A3A4C5FF372CC1729573D67368C2")
            
public static boolean saveMessage(ContentResolver resolver,
                    Uri uri, String body) {
                ContentValues values = new ContentValues(2);
                values.put(BODY, body);
                values.put(DATE, System.currentTimeMillis());
                return resolver.update(uri, values, null, null) == 1;
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.775 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "53485244D30DB502EB53C7D4D28015BF")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/drafts");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.778 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.892 -0400", hash_original_method = "30DD07C39D661987683E6A54087310F0", hash_generated_method = "30DD07C39D661987683E6A54087310F0")
            public Draft ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Outbox implements BaseColumns, TextBasedSmsColumns {

            /**
             * Add an SMS to the Out box.
             *
             * @param resolver the content resolver to use
             * @param address the address of the sender
             * @param body the body of the message
             * @param subject the psuedo-subject of the message
             * @param date the timestamp for the message
             * @param deliveryReport whether a delivery report was requested for the message
             * @return the URI for the new message
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.586 -0500", hash_original_method = "F8B592BECD63B81B7040E19C27BB214C", hash_generated_method = "FA02E7F418AA98558E4D9BFA87F69268")
            
public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean deliveryReport, long threadId) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, deliveryReport, threadId);
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.784 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "F3FBAECD1A011C6A74E382A1F3A3BF03")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/outbox");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.786 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.893 -0400", hash_original_method = "06FAB0A617CEB33215E397D9BFE9D152", hash_generated_method = "06FAB0A617CEB33215E397D9BFE9D152")
            public Outbox ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Conversations implements BaseColumns, TextBasedSmsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.592 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "16EFBE7184DEEDC0AADC8DE7C8F9E970")

            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/conversations");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.595 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.597 -0500", hash_original_field = "87FCA52EA58A2965EB4E1E9BA6CFAFF9", hash_generated_field = "461E02376DD761106C9F50F56F21857C")

            public static final String SNIPPET = "snippet";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.601 -0500", hash_original_field = "1D4E8A96E744EFAD8C2F0EA5174A33A4", hash_generated_field = "AD44C5230C665F737EB24B33F905C77C")

            public static final String MESSAGE_COUNT = "msg_count";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.893 -0400", hash_original_method = "6984BA613DF71E17158BEA5BF9053437", hash_generated_method = "6984BA613DF71E17158BEA5BF9053437")
            public Conversations ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Intents {

            /**
             * Read the PDUs out of an {@link #SMS_RECEIVED_ACTION} or a
             * {@link #DATA_SMS_RECEIVED_ACTION} intent.
             *
             * @param intent the intent to read from
             * @return an array of SmsMessages for the PDUs
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.637 -0500", hash_original_method = "30B8C5FF17840C780307DC9CA4EA96D5", hash_generated_method = "B4D9EFA98711619F8882196BFB843AEA")
            
public static SmsMessage[] getMessagesFromIntent(
                    Intent intent) {
                Object[] messages = (Object[]) intent.getSerializableExtra("pdus");
                String format = intent.getStringExtra("format");
                byte[][] pduObjs = new byte[messages.length][];

                for (int i = 0; i < messages.length; i++) {
                    pduObjs[i] = (byte[]) messages[i];
                }
                byte[][] pdus = new byte[pduObjs.length][];
                int pduCount = pdus.length;
                SmsMessage[] msgs = new SmsMessage[pduCount];
                for (int i = 0; i < pduCount; i++) {
                    pdus[i] = pduObjs[i];
                    msgs[i] = SmsMessage.createFromPdu(pdus[i], format);
                }
                return msgs;
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.606 -0500", hash_original_field = "32155326F1EC144D975A2213B1D2723B", hash_generated_field = "F3ADB15FC42BA451861D8CE0DD67EADC")

            public static final int RESULT_SMS_HANDLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.609 -0500", hash_original_field = "3C9BC2256FDD308DCEAFA9F0FF1251C7", hash_generated_field = "9D88CC26E2D60D826B2D5688D983A2E3")

            public static final int RESULT_SMS_GENERIC_ERROR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.611 -0500", hash_original_field = "9A19A59290517E2E185D1C4CFC496FD4", hash_generated_field = "5217C1622863BE20DD7880B1ECDAB840")

            public static final int RESULT_SMS_OUT_OF_MEMORY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.614 -0500", hash_original_field = "D15802CA921FD77FF44314CF8E3FBDCF", hash_generated_field = "652B641018CAC11B8365BB138255CAB0")

            public static final int RESULT_SMS_UNSUPPORTED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.617 -0500", hash_original_field = "A1B215BF36A07BA341D22462BDA1C8E6", hash_generated_field = "B6DC26DA2462F0444538513A5810D7C2")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_RECEIVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.620 -0500", hash_original_field = "4CA5B192FE3653E76B832169C5A1782B", hash_generated_field = "0725F550AB537507121D73D8B328F5B3")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String DATA_SMS_RECEIVED_ACTION =
                    "android.intent.action.DATA_SMS_RECEIVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.623 -0500", hash_original_field = "DA7E14B1B7B536262918D4442C1644EF", hash_generated_field = "0D0F6D80E4CA3809B3343310CFE36931")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String WAP_PUSH_RECEIVED_ACTION =
                    "android.provider.Telephony.WAP_PUSH_RECEIVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.625 -0500", hash_original_field = "D1D9F5C497D734C2329E230D4BCB0619", hash_generated_field = "F1BC5F1D5E509125630B9F8ED16F8CB5")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_CB_RECEIVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.628 -0500", hash_original_field = "61B810EDB47D179A78002F4183B03587", hash_generated_field = "D837B19557264CD31F4B7887321EC9B7")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_EMERGENCY_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.631 -0500", hash_original_field = "6EB450A7481B914284B94C4A9C025945", hash_generated_field = "4E03BDF282E90EEDE2E9DD0D0612CB52")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SIM_FULL_ACTION =
                    "android.provider.Telephony.SIM_FULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.633 -0500", hash_original_field = "3C698B0DA6F460CFE787E499766C524B", hash_generated_field = "CF2E0AD427CE0F354C11FE6A4A4661DF")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_REJECTED_ACTION =
                "android.provider.Telephony.SMS_REJECTED";
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.035 -0500", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "133FD0D647CE3722D1F195582DF3CC61")
        
private Intents() {
            // Not instantiable
        }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.532 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.889 -0400", hash_original_method = "6F79CFAC0C9D88274D278FEEB27D8B11", hash_generated_method = "6F79CFAC0C9D88274D278FEEB27D8B11")
        public Sms ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Threads implements ThreadsColumns {

        /**
         * This is a single-recipient version of
         * getOrCreateThreadId.  It's convenient for use with SMS
         * messages.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.719 -0500", hash_original_method = "D36339876722268ADD72D9390788DF4A", hash_generated_method = "E3AC7FDC3914C3AABCD9217339F48988")
        
public static long getOrCreateThreadId(Context context, String recipient) {
            Set<String> recipients = new HashSet<String>();

            recipients.add(recipient);
            return getOrCreateThreadId(context, recipients);
        }

        /**
         * Given the recipients list and subject of an unsaved message,
         * return its thread ID.  If the message starts a new thread,
         * allocate a new thread ID.  Otherwise, use the appropriate
         * existing thread ID.
         *
         * Find the thread ID of the same set of recipients (in
         * any order, without any additions). If one
         * is found, return it.  Otherwise, return a unique thread ID.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.722 -0500", hash_original_method = "D4D7C19F5599D44D3DC4D465F273833D", hash_generated_method = "F073065A5E56CF2C2917959E759B6817")
        
public static long getOrCreateThreadId(
                Context context, Set<String> recipients) {
            Uri.Builder uriBuilder = THREAD_ID_CONTENT_URI.buildUpon();

            for (String recipient : recipients) {
                if (Mms.isEmailAddress(recipient)) {
                    recipient = Mms.extractAddrSpec(recipient);
                }

                uriBuilder.appendQueryParameter("recipient", recipient);
            }

            Uri uri = uriBuilder.build();
            //if (DEBUG) Log.v(TAG, "getOrCreateThreadId uri: " + uri);

            Cursor cursor = SqliteWrapper.query(context, context.getContentResolver(),
                    uri, ID_PROJECTION, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        return cursor.getLong(0);
                    } else {
                        Log.e(TAG, "getOrCreateThreadId returned no rows!");
                    }
                } finally {
                    cursor.close();
                }
            }

            Log.e(TAG, "getOrCreateThreadId failed with uri " + uri.toString());
            throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.699 -0500", hash_original_field = "31CE48B6BD6B1D9BC9A346EDC4E41550", hash_generated_field = "8352A6E8399E272B46A14174ED6516E0")

        private static final String[] ID_PROJECTION = { BaseColumns._ID };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.702 -0500", hash_original_field = "8077930CCD1A90350B531D690259F853", hash_generated_field = "01F22596571F5B47B496D99E20B085C9")

        private static final String STANDARD_ENCODING = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.704 -0500", hash_original_field = "6870292C93CE93059285DF72B4811E4C", hash_generated_field = "48B4BF377FF6FB0F649F9E30B8559E5B")

        private static final Uri THREAD_ID_CONTENT_URI = Uri.parse(
                "content://mms-sms/threadID");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.707 -0500", hash_original_field = "7EFFCBB027F24B9516D291FD961D9CE6", hash_generated_field = "E3839B0DEB12C7380DC01093452D8B2B")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(
                MmsSms.CONTENT_URI, "conversations");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.710 -0500", hash_original_field = "2ACE43E6021868C1C4B186253042B2A8", hash_generated_field = "16CC9E01E76C7FFCA89F24312CAF2FF4")

        public static final Uri OBSOLETE_THREADS_URI = Uri.withAppendedPath(
                CONTENT_URI, "obsolete");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.713 -0500", hash_original_field = "F5E57FFCEE1C7F760811356F9D0B435E", hash_generated_field = "0EA950CFA852D09F85620C3D83F9B1D2")

        public static final int COMMON_THREAD    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.715 -0500", hash_original_field = "BB76718EEC267557456B299BBECA868C", hash_generated_field = "E361587D52F3A07F5B27324A4A0F7CFC")

        public static final int BROADCAST_THREAD = 1;

        // No one should construct an instance of this class.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.717 -0500", hash_original_method = "45D6965ABD617E611598473C57FD4F7C", hash_generated_method = "80AB08BF868BD8350BB4DDEADEDC38FA")
        
private Threads() {
        }
    }
    
    public static final class Mms implements BaseMmsColumns {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.743 -0500", hash_original_method = "91491FADEEC62466B0F9FF75744CEEB2", hash_generated_method = "4116C537EA1E1C0A55E8CE52971B78AD")
        
public static final Cursor query(
                ContentResolver cr, String[] projection) {
            return cr.query(CONTENT_URI, projection, null, null, DEFAULT_SORT_ORDER);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.746 -0500", hash_original_method = "B0F13298A0CBF5A4AA63780A1FEDFE05", hash_generated_method = "FB43394C3A2ED7C0643EFD2496CAF1D5")
        
public static final Cursor query(
                ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return cr.query(CONTENT_URI, projection,
                    where, null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.749 -0500", hash_original_method = "6DB13AD38B4DC3E9CBC9DA281EEB426F", hash_generated_method = "4652DF285AB1742B5F40F80951719A49")
        
public static final String getMessageBoxName(int msgBox) {
            switch (msgBox) {
                case MESSAGE_BOX_ALL:
                    return "all";
                case MESSAGE_BOX_INBOX:
                    return "inbox";
                case MESSAGE_BOX_SENT:
                    return "sent";
                case MESSAGE_BOX_DRAFTS:
                    return "drafts";
                case MESSAGE_BOX_OUTBOX:
                    return "outbox";
                default:
                    throw new IllegalArgumentException("Invalid message box: " + msgBox);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.752 -0500", hash_original_method = "CCA57381283D62D095D139A9A920A036", hash_generated_method = "8033A4802D183ED4B77A615B7A76D850")
        
public static String extractAddrSpec(String address) {
            Matcher match = NAME_ADDR_EMAIL_PATTERN.matcher(address);

            if (match.matches()) {
                return match.group(2);
            }
            return address;
        }

        /**
         * Returns true if the address is an email address
         *
         * @param address the input address to be tested
         * @return true if address is an email address
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.754 -0500", hash_original_method = "E723E071866ECCDFA5A86BCF8A6012B5", hash_generated_method = "C38F869CE1A4085986CDE3EF2701AD8C")
        
public static boolean isEmailAddress(String address) {
            if (TextUtils.isEmpty(address)) {
                return false;
            }

            String s = extractAddrSpec(address);
            Matcher match = Patterns.EMAIL_ADDRESS.matcher(s);
            return match.matches();
        }

        /**
         * Returns true if the number is a Phone number
         *
         * @param number the input number to be tested
         * @return true if number is a Phone number
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.757 -0500", hash_original_method = "48737B27A1984E395C1B06BCA471AE58", hash_generated_method = "FAF14C1DCEFEFDE472765199E90BD518")
        
public static boolean isPhoneNumber(String number) {
            if (TextUtils.isEmpty(number)) {
                return false;
            }

            Matcher match = Patterns.PHONE.matcher(number);
            return match.matches();
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.728 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "743596F13702A332C2F6A82A0F5E0A20")

        public static final Uri CONTENT_URI = Uri.parse("content://mms");
        
        public static final class Inbox implements BaseMmsColumns {

            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.895 -0400", hash_original_field = "FD3D4A47B4184A3B945239F90C0175E6", hash_generated_field = "F9CAEE6005B47FC2B06B1883EC29741D")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/inbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.895 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.895 -0400", hash_original_method = "141F91EDC6AE2D7033D3DA3E508699AC", hash_generated_method = "141F91EDC6AE2D7033D3DA3E508699AC")
            public Inbox ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Sent implements BaseMmsColumns {

            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "DF98B3D332181ACB689001F11EB24FAB", hash_generated_field = "D3824F01E3D7A102678F440DA457F6A8")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/sent");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.895 -0400", hash_original_method = "01BACB9453826DDA962919BC9AB080EE", hash_generated_method = "01BACB9453826DDA962919BC9AB080EE")
            public Sent ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Draft implements BaseMmsColumns {

            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "3FCD34586749C5F3E29E6DBF260C2CAE", hash_generated_field = "53485244D30DB502EB53C7D4D28015BF")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/drafts");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_method = "30DD07C39D661987683E6A54087310F0", hash_generated_method = "30DD07C39D661987683E6A54087310F0")
            public Draft ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Outbox implements BaseMmsColumns {

            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "F53553E0A43669B3D7D858B918DCEFB3", hash_generated_field = "F3FBAECD1A011C6A74E382A1F3A3BF03")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/outbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_method = "06FAB0A617CEB33215E397D9BFE9D152", hash_generated_method = "06FAB0A617CEB33215E397D9BFE9D152")
            public Outbox ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Addr implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.791 -0500", hash_original_field = "7AD05DB3B51D85224F3A0AD07834E1F3", hash_generated_field = "E860CDD6A108651539360F1130ED0B2A")

            public static final String MSG_ID = "msg_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.794 -0500", hash_original_field = "95BAFF84AFAEB9CC61C198AE05DB3526", hash_generated_field = "5384CF6C6A85CA6A30531E3C944068D3")

            public static final String CONTACT_ID = "contact_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.796 -0500", hash_original_field = "7A8C66F541E270FBD98ECD2FB61BFA00", hash_generated_field = "BEA83639AA525DC7F82CC0B39D80C6ED")

            public static final String ADDRESS = "address";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.799 -0500", hash_original_field = "2280480E1208717EAE9778EC9DC63E6D", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

            public static final String TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.801 -0500", hash_original_field = "875D94DE58C9465990C21459B217C5EF", hash_generated_field = "087203CA483BFA4282CC523544C8FADB")

            public static final String CHARSET = "charset";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_method = "240C49CE2280315AC94999B4C3BDDDB9", hash_generated_method = "240C49CE2280315AC94999B4C3BDDDB9")
            public Addr ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Part implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.807 -0500", hash_original_field = "27DFA19B9F7B0F76FAA8699FBC85CC25", hash_generated_field = "8E870E8CB9A3CF8AA38AD6C4448728E0")

            public static final String MSG_ID = "mid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.809 -0500", hash_original_field = "00E19438BCB6A23F0326491719B8811B", hash_generated_field = "B3B4F0AB1734E253732F5195B4201B41")

            public static final String SEQ = "seq";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.812 -0500", hash_original_field = "6AB5002C364053F31F734E8B9809E9E5", hash_generated_field = "3D053512A06F67E25428FE33AC1E0FF7")

            public static final String CONTENT_TYPE = "ct";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.814 -0500", hash_original_field = "11F7D90F715D916A63D5FB3D55CA93F4", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

            public static final String NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.818 -0500", hash_original_field = "F633ED35913EF51360600AE068E68B30", hash_generated_field = "F19BBF6000780F9703F0AD970B6ED23A")

            public static final String CHARSET = "chset";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.820 -0500", hash_original_field = "2FEED1B254631F9F7D9BE6A23A181A69", hash_generated_field = "034347C41CBDBFCB27A264F7CFD0BE08")

            public static final String FILENAME = "fn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.823 -0500", hash_original_field = "52ADF14FE63DA035F02D1C1F3EC6406A", hash_generated_field = "FBAB6BA0513ED7FE7A09AE5E4B2E7FDF")

            public static final String CONTENT_DISPOSITION = "cd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.825 -0500", hash_original_field = "0779DF19E0C8004FC9AAB39E9A06DB07", hash_generated_field = "FB3535DF43B2F9EBAB6CE9D55270D006")

            public static final String CONTENT_ID = "cid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.828 -0500", hash_original_field = "9F37C54582F80A9F3DC1F607C670E579", hash_generated_field = "01CC779370BD03928AB110C6429E9BE0")

            public static final String CONTENT_LOCATION = "cl";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.831 -0500", hash_original_field = "AB4D75FE371587D7D8A32EDBB859D5F7", hash_generated_field = "63050F47D1635B2D6423AB9F39AC8970")

            public static final String CT_START = "ctt_s";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.833 -0500", hash_original_field = "F29F9CAB6A588EE3F38266954A4FAE2C", hash_generated_field = "54F96DCDA030C4DE5824FD842CC19D05")

            public static final String CT_TYPE = "ctt_t";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.836 -0500", hash_original_field = "6627A0AE689A0C6C1260E2B9DD1E3940", hash_generated_field = "6019C57F4087C2B434AB905CD1126FDC")

            public static final String _DATA = "_data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.839 -0500", hash_original_field = "35E1FC63B0BE370DC076530339F88DF8", hash_generated_field = "7F68E2947E21BC10A9CA9D937E2EFCEB")

            public static final String TEXT = "text";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.896 -0400", hash_original_method = "9A3D51732327B3711C976CCE6283B7F6", hash_generated_method = "9A3D51732327B3711C976CCE6283B7F6")
            public Part ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Rate {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.844 -0500", hash_original_field = "C3D465F525188BA0C162388F0B5EEBA4", hash_generated_field = "C73AB89F9797F2712EA638E4BF187501")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    Mms.CONTENT_URI, "rate");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.847 -0500", hash_original_field = "247FC8207739D8D94A45DEFEE0D731CC", hash_generated_field = "EDBEDB95540CA570BB8435CA63159001")

            public static final String SENT_TIME = "sent_time";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.897 -0400", hash_original_method = "8DE7FBCF11006E383291B1DA82AD2709", hash_generated_method = "8DE7FBCF11006E383291B1DA82AD2709")
            public Rate ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Intents {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.854 -0500", hash_original_field = "2FD3AEFEC9AB81A589D86C39111FFBE2", hash_generated_field = "6F1537B0D20DA96C878B5C71EA17FA48")

            public static final String EXTRA_CONTENTS = "contents";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.857 -0500", hash_original_field = "0A5BF0ED631632CE144FA1DE2A365C29", hash_generated_field = "112351A2319F01A5AD654CB608E1D733")

            public static final String EXTRA_TYPES    = "types";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.860 -0500", hash_original_field = "37EC3D1275AF23CD9BB76023BE57B039", hash_generated_field = "4923428C2F05859A662AFB1418FE907A")

            public static final String EXTRA_CC       = "cc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.863 -0500", hash_original_field = "C3C6E2648A960CE44A439F516CFF8028", hash_generated_field = "F8A508D5ED6945D974DECCC56AD35166")

            public static final String EXTRA_BCC      = "bcc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.866 -0500", hash_original_field = "4EAB7F7A2E6BDAFD7E4C606D075E05A6", hash_generated_field = "EDC63051572D26FFD697DBF50DD6BF56")

            public static final String EXTRA_SUBJECT  = "subject";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.869 -0500", hash_original_field = "F8F7F7E89513DE70E00E844FEBCFB82E", hash_generated_field = "921FF0F260C29F8B3FACE564E15BF593")

            public static final String
            CONTENT_CHANGED_ACTION = "android.intent.action.CONTENT_CHANGED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.871 -0500", hash_original_field = "19E0AC5CEB01876D91CB69E352D7A7E6", hash_generated_field = "D69BD2570D1982720AE320E3BA14DBFE")

            public static final String DELETED_CONTENTS = "deleted_contents";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.897 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
            private  Intents() {
                // ---------- Original Method ----------
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.731 -0500", hash_original_field = "9944F65AF9B45371F3D9BDD04887349B", hash_generated_field = "055A393B2924B35F63A91789B785D1D3")

        public static final Uri REPORT_REQUEST_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-request");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.733 -0500", hash_original_field = "7ED3A4F5ECF06257652700E15E5CE11D", hash_generated_field = "2B742DCB087975A88B80D98C0B3DB168")

        public static final Uri REPORT_STATUS_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-status");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.736 -0500", hash_original_field = "37DEDE1DCB9F6F6E9384B67BBEBF370B", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.738 -0500", hash_original_field = "F6EF5FFB4FA26FCC80851CB893537AE1", hash_generated_field = "B92D7F293C4D0907D348382C719CDDE8")

        public static final Pattern NAME_ADDR_EMAIL_PATTERN =
                Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.741 -0500", hash_original_field = "6C4CCA732F8C775508761CF4DE8FEB2E", hash_generated_field = "D97B56BA1675A61156419B8C11EC688A")

        public static final Pattern QUOTED_STRING_PATTERN =
                Pattern.compile("\\s*\"([^\"]*)\"\\s*");
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.895 -0400", hash_original_method = "59489CF231D229E8B793F6BB93F87558", hash_generated_method = "59489CF231D229E8B793F6BB93F87558")
        public Mms ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class MmsSms implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.880 -0500", hash_original_field = "B82FAAC158690FDD879555C162D51A10", hash_generated_field = "8294BF03F1BCCC1A530C57E7DBE14CC8")

        public static final String TYPE_DISCRIMINATOR_COLUMN =
                "transport_type";

        public static final class PendingMessages implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.927 -0500", hash_original_field = "B75D6636BBED728623A9905740367708", hash_generated_field = "A45CA31EB044CE870CDE0E8E242D7E4B")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    MmsSms.CONTENT_URI, "pending");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.929 -0500", hash_original_field = "744FBCA75A345110D90B00DEB236ACD8", hash_generated_field = "DDCA1A3660B15140C626BBC5A81F0499")

            public static final String PROTO_TYPE = "proto_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.932 -0500", hash_original_field = "7AD05DB3B51D85224F3A0AD07834E1F3", hash_generated_field = "E860CDD6A108651539360F1130ED0B2A")

            public static final String MSG_ID = "msg_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.936 -0500", hash_original_field = "FA30420FCF92FC0F4134C3BD379F1E22", hash_generated_field = "DF1CED8D10D9FE4A1B53B70E1F019B9E")

            public static final String MSG_TYPE = "msg_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.938 -0500", hash_original_field = "998D4A28663DEED4F9DCB5331432F6BA", hash_generated_field = "559E9403DFCBFDD9D0A32254097A8A67")

            public static final String ERROR_TYPE = "err_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.941 -0500", hash_original_field = "25D6CDBEA0CA1EA3F35C29DDE16EC9C8", hash_generated_field = "047B5E7CC71849654879C7AE09B3F4F8")

            public static final String ERROR_CODE = "err_code";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.943 -0500", hash_original_field = "010A1E0144ACECFDC4501AB296CF7337", hash_generated_field = "9DDF25C408D54C2921F50E476BB1303B")

            public static final String RETRY_INDEX = "retry_index";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.945 -0500", hash_original_field = "91ED8E48CDF36D96DCDE7D87E43EB577", hash_generated_field = "2CACB59A3AF3C33685576A2601F55F7C")

            public static final String DUE_TIME = "due_time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.948 -0500", hash_original_field = "46CE8A708FF7E602E6F94CDA9C433600", hash_generated_field = "995B3F5B5B885A05029EB4556D8ADE54")

            public static final String LAST_TRY = "last_try";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.898 -0400", hash_original_method = "170CA936DAF3534DFB0A0B79794E3A00", hash_generated_method = "170CA936DAF3534DFB0A0B79794E3A00")
            public PendingMessages ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class WordsTable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.954 -0500", hash_original_field = "F0D3FDD50AE0B4B355D4DA426C7375CD", hash_generated_field = "3C2D71BF930B87FEECA9710D884C1BB3")

            public static final String ID = "_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.956 -0500", hash_original_field = "D368562895A94A8C2666C4BA4BE5E852", hash_generated_field = "D5203D02067622E5461610FA9E0ED4F0")

            public static final String SOURCE_ROW_ID = "source_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.959 -0500", hash_original_field = "E34D4A29A90593FADFE02A7288C04433", hash_generated_field = "178E47738C14553382EE1E9ABE2AB8B3")

            public static final String TABLE_ID = "table_to_use";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.962 -0500", hash_original_field = "BFA6E01DCAD5B7285D39D327C4FB815D", hash_generated_field = "C40C91A1D34AC70A6AA26AD824441031")

            public static final String INDEXED_TEXT = "index_text";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.899 -0400", hash_original_method = "480A168A1C6BA9EBC664C3157DB5A59D", hash_generated_method = "480A168A1C6BA9EBC664C3157DB5A59D")
            public WordsTable ()
            {
                //Synthesized constructor
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.883 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "725D49CB9A779935D7438B22EE5EF841")

        public static final Uri CONTENT_URI = Uri.parse("content://mms-sms/");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.885 -0500", hash_original_field = "DC0C2B3E544D28B0DBCF7107EF95CB37", hash_generated_field = "C59F3E84EBBB0AC1380C88A59475A3A8")

        public static final Uri CONTENT_CONVERSATIONS_URI = Uri.parse(
                "content://mms-sms/conversations");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.888 -0500", hash_original_field = "2E4B17E9023F0072EF064876178DCD09", hash_generated_field = "C254F7847DB4E69055614E014ECAD96B")

        public static final Uri CONTENT_FILTER_BYPHONE_URI = Uri.parse(
                "content://mms-sms/messages/byphone");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.891 -0500", hash_original_field = "FB251C4D31F4FF8A1EEAA3D76A8F84A7", hash_generated_field = "5A2955C176679B662C0C17C048B26518")

        public static final Uri CONTENT_UNDELIVERED_URI = Uri.parse(
                "content://mms-sms/undelivered");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.894 -0500", hash_original_field = "13DF0094AB878A3BF30D030F974B1233", hash_generated_field = "4F59FF53C38C1BDA527B0BED040B8736")

        public static final Uri CONTENT_DRAFT_URI = Uri.parse(
                "content://mms-sms/draft");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.896 -0500", hash_original_field = "B062DF05D120B4F380A08235E7BFEC4F", hash_generated_field = "0560816728199652A5CB6C27D362699C")

        public static final Uri CONTENT_LOCKED_URI = Uri.parse(
                "content://mms-sms/locked");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.898 -0500", hash_original_field = "3C1E7D3DB75CFC781A2E1DAE0A25FA1A", hash_generated_field = "C7EF221ABCA99183E3EA2867726E141E")

        public static final Uri SEARCH_URI = Uri.parse(
                "content://mms-sms/search");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.901 -0500", hash_original_field = "968D098F5923E0857A2B33DC7A663D87", hash_generated_field = "A0B445A2BFE3ABFB7A5E3ED5BCC4E4C1")

        public static final int SMS_PROTO = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.903 -0500", hash_original_field = "C9DD563D3E87E16DDDDAA4D8D5ABFC97", hash_generated_field = "BC9D1CC8090F1A13F4525AD5BFE08179")

        public static final int MMS_PROTO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.906 -0500", hash_original_field = "3619BBC96356F263661221785A00D6E9", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR                      = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.908 -0500", hash_original_field = "9158B9A93A7D11D2CF4FD8DBE6227075", hash_generated_field = "A0E4EEB9435E3B4EA81275AEB6BD0AD6")

        public static final int ERR_TYPE_GENERIC              = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.911 -0500", hash_original_field = "97A372A7314FFE1724E81B5EADC0CED1", hash_generated_field = "0ABC2012161C81438CE079E3282EC3B2")

        public static final int ERR_TYPE_SMS_PROTO_TRANSIENT  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.913 -0500", hash_original_field = "EB74B6F31757A20A578F7A6FF3D95ADA", hash_generated_field = "F4308D0192C6A19EF045E7440BB4B92C")

        public static final int ERR_TYPE_MMS_PROTO_TRANSIENT  = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.916 -0500", hash_original_field = "828AEF7B599418BFA144AF105D379957", hash_generated_field = "8F0C54AA7F843B1A03524B8476A2C7F6")

        public static final int ERR_TYPE_TRANSPORT_FAILURE    = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.918 -0500", hash_original_field = "1697D959E2F75529E98B7930E27A780B", hash_generated_field = "47C87217CD5222AED2A5BA2C96EA04F1")

        public static final int ERR_TYPE_GENERIC_PERMANENT    = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.921 -0500", hash_original_field = "20F6F76337BCB89E09BF964DF1B31FDD", hash_generated_field = "51D9C54EA11627D2231A722A33BE5B99")

        public static final int ERR_TYPE_SMS_PROTO_PERMANENT  = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.923 -0500", hash_original_field = "8D9E567352880EDCAF66B712EB66448C", hash_generated_field = "666D817A76159035D9ED782E6EB7B1F9")

        public static final int ERR_TYPE_MMS_PROTO_PERMANENT  = 12;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.897 -0400", hash_original_method = "9BF54BA5F2455087717E5B05EBB691D5", hash_generated_method = "9BF54BA5F2455087717E5B05EBB691D5")
        public MmsSms ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Carriers implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.970 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "B83F159B5508CA04D478D2F19B7BC0B7")

        public static final Uri CONTENT_URI =
            Uri.parse("content://telephony/carriers");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.972 -0500", hash_original_field = "B35A3A6BAF22D1C87EA853747BFEE8EF", hash_generated_field = "9CB03A1E7A96D497D2A20539B2DA9F7D")

        public static final String DEFAULT_SORT_ORDER = "name ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.974 -0500", hash_original_field = "11F7D90F715D916A63D5FB3D55CA93F4", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

        public static final String NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.976 -0500", hash_original_field = "9C2B4BA2E4F3F3F9106F4C32B1FE7D66", hash_generated_field = "F300D686F5A12199946063E3A258481F")

        public static final String APN = "apn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.979 -0500", hash_original_field = "CDC29751501C83289A46E83AC430B92B", hash_generated_field = "4B15713FC5C43FDE94601F76F5DBD23D")

        public static final String PROXY = "proxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.982 -0500", hash_original_field = "F93951ACBA3476738EE5602D5DFD815A", hash_generated_field = "99DCABF3DA7F9D1D88CC95B61DFB04A9")

        public static final String PORT = "port";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.984 -0500", hash_original_field = "B72B3B6FEE92149BEA0F7C3A186177BA", hash_generated_field = "C182EEEECAE2F461BF2A41DF367D73EC")

        public static final String MMSPROXY = "mmsproxy";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.987 -0500", hash_original_field = "ED3779D68DD9BAE863F37733F152AF37", hash_generated_field = "8F3193E08FE92B96D7D5643DC6A92A95")

        public static final String MMSPORT = "mmsport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.989 -0500", hash_original_field = "B03FCAF99FFCA7EEF0AAF1ADAB5517BC", hash_generated_field = "9C32C8BBED42D75F080E14E6DA9B790C")

        public static final String SERVER = "server";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.991 -0500", hash_original_field = "7623BEF341D152A0D4FEB02810549B81", hash_generated_field = "834D644845EB5ED38B265C95BBA49CB4")

        public static final String USER = "user";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.994 -0500", hash_original_field = "C70E4611E6ECE0D53ADE50E36E0EDF03", hash_generated_field = "CBB5222D1140EC3444B2A0FD7AD4FE88")

        public static final String PASSWORD = "password";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.996 -0500", hash_original_field = "C0C90F33D07231A46D20074925A2A973", hash_generated_field = "6EC7E1D83CD69F9BC43F1655B9CBF19F")

        public static final String MMSC = "mmsc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.999 -0500", hash_original_field = "8351B245FB197F0A968C9BC421304A36", hash_generated_field = "C487DD96CBAD610F74EC365BEA80962D")

        public static final String MCC = "mcc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.001 -0500", hash_original_field = "34634A2141543B5BAC263632D7364B8C", hash_generated_field = "822D32F51A87BFC1642F46FB088FE20A")

        public static final String MNC = "mnc";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.004 -0500", hash_original_field = "BCF8053865B04CE0723AA5086866BB7E", hash_generated_field = "084A9800CBA32160C0F4D0927F523ACE")

        public static final String NUMERIC = "numeric";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.007 -0500", hash_original_field = "6F4CFA856B2BFF58AF6CC04EF4FC4021", hash_generated_field = "7F6EF22DA072B11AE4CEA166BF6DBADD")

        public static final String AUTH_TYPE = "authtype";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.009 -0500", hash_original_field = "2280480E1208717EAE9778EC9DC63E6D", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.012 -0500", hash_original_field = "5A982076116FC957D450ABDABD88C314", hash_generated_field = "2B595158C181DC1628EB9A295127ADAA")

        public static final String INACTIVE_TIMER = "inactivetimer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.014 -0500", hash_original_field = "85E2D4AE3EBDF73C06E5CE29B08EA9A0", hash_generated_field = "38B59F865EC8485B65B816B06D008AB8")

        public static final String ENABLED = "enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.017 -0500", hash_original_field = "BAFC76781B257687579ED5421887A99C", hash_generated_field = "74E32F478BCE7B6EBA1201E01506F685")

        public static final String CLASS = "class";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.019 -0500", hash_original_field = "F597C22BCCE75DC0EC3286F8FB73F41D", hash_generated_field = "8B629361886A9352455859D3FDF79949")

        public static final String PROTOCOL = "protocol";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.021 -0500", hash_original_field = "1BEB46E147B39D2C1CB76927F59C921D", hash_generated_field = "11E51D76C955DAD413581C2CA1BFB651")

        public static final String ROAMING_PROTOCOL = "roaming_protocol";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.024 -0500", hash_original_field = "4077EABEC784173C7466769398DB7ABB", hash_generated_field = "59BA209EAF04B1C0A5952989A6ACC6C5")

        public static final String CURRENT = "current";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.027 -0500", hash_original_field = "A0F3F1795949E05FE722902BBFA9F5C5", hash_generated_field = "BC1608B5480B870191D648F68C4136A8")

        public static final String CARRIER_ENABLED = "carrier_enabled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.029 -0500", hash_original_field = "FD2BA64CABF9B50B17FA7BC606F3E944", hash_generated_field = "862209E7F6CB1BB56AAA8EB7E027E87B")

        public static final String BEARER = "bearer";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.900 -0400", hash_original_method = "6476EDBFB29271C848491911726650D3", hash_generated_method = "6476EDBFB29271C848491911726650D3")
        public Carriers ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Intents {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.037 -0500", hash_original_field = "788B854B75A3D9FA9717FE62A549F0BB", hash_generated_field = "01669067B5317112DD0057A9B1FE9009")

        public static final String SECRET_CODE_ACTION =
                "android.provider.Telephony.SECRET_CODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.040 -0500", hash_original_field = "E5553DC1C605CD1E06A5915A99AA6CB3", hash_generated_field = "40776CD3668AC5CF392E1D3DE7F42EDA")

        public static final String SPN_STRINGS_UPDATED_ACTION =
                "android.provider.Telephony.SPN_STRINGS_UPDATED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.042 -0500", hash_original_field = "1046C40C45BEDE0B1F842791D81D33A7", hash_generated_field = "35D93941BBB76FB59A8BAC9F6C8D581B")

        public static final String EXTRA_SHOW_PLMN  = "showPlmn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.044 -0500", hash_original_field = "AF5F4DB4DCF3B6A6DA186222D3F047C1", hash_generated_field = "26980D0EFE6BDF43AF9F26E0F475BC60")

        public static final String EXTRA_PLMN       = "plmn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.047 -0500", hash_original_field = "1B3E569A5DDAFA47E9869FAC8E5D2F4C", hash_generated_field = "0A2A2EFF31246EB3A6185CE2663CBB9F")

        public static final String EXTRA_SHOW_SPN   = "showSpn";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:04.049 -0500", hash_original_field = "E26A2DCF7D78203F5C991AA0ECC169D0", hash_generated_field = "D20853DD357283639E7C34C01D65DC68")

        public static final String EXTRA_SPN        = "spn";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.901 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
        private  Intents() {
            // ---------- Original Method ----------
        }
    }
    
    public interface TextBasedSmsColumns {
        
        public static final String TYPE = "type";

        public static final int MESSAGE_TYPE_ALL    = 0;
        public static final int MESSAGE_TYPE_INBOX  = 1;
        public static final int MESSAGE_TYPE_SENT   = 2;
        public static final int MESSAGE_TYPE_DRAFT  = 3;
        public static final int MESSAGE_TYPE_OUTBOX = 4;
        public static final int MESSAGE_TYPE_FAILED = 5; 
        public static final int MESSAGE_TYPE_QUEUED = 6;
        
        public static final String THREAD_ID = "thread_id";
        
        public static final String ADDRESS = "address";
        
        public static final String PERSON_ID = "person";
        
        public static final String DATE = "date";
        
        public static final String DATE_SENT = "date_sent";
        
        public static final String READ = "read";
        
        public static final String SEEN = "seen";
        
        public static final String STATUS = "status";

        public static final int STATUS_NONE = -1;
        public static final int STATUS_COMPLETE = 0;
        public static final int STATUS_PENDING = 32;
        public static final int STATUS_FAILED = 64;
        
        public static final String SUBJECT = "subject";
        
        public static final String BODY = "body";
        
        public static final String PERSON = "person";
        
        public static final String PROTOCOL = "protocol";
        
        public static final String REPLY_PATH_PRESENT = "reply_path_present";
        
        public static final String SERVICE_CENTER = "service_center";
        
        public static final String LOCKED = "locked";
        
        public static final String ERROR_CODE = "error_code";
        
        public static final String META_DATA = "meta_data";
}
    
    public interface BaseMmsColumns extends BaseColumns {

        public static final int MESSAGE_BOX_ALL    = 0;
        public static final int MESSAGE_BOX_INBOX  = 1;
        public static final int MESSAGE_BOX_SENT   = 2;
        public static final int MESSAGE_BOX_DRAFTS = 3;
        public static final int MESSAGE_BOX_OUTBOX = 4;
        
        public static final String DATE = "date";
        
        public static final String DATE_SENT = "date_sent";
        
        public static final String MESSAGE_BOX = "msg_box";
        
        public static final String READ = "read";
        
        public static final String SEEN = "seen";
        
        public static final String MESSAGE_ID = "m_id";
        
        public static final String SUBJECT = "sub";
        
        public static final String SUBJECT_CHARSET = "sub_cs";
        
        public static final String CONTENT_TYPE = "ct_t";
        
        public static final String CONTENT_LOCATION = "ct_l";
        
        public static final String FROM = "from";
        
        public static final String TO = "to";
        
        public static final String CC = "cc";
        
        public static final String BCC = "bcc";
        
        public static final String EXPIRY = "exp";
        
        public static final String MESSAGE_CLASS = "m_cls";
        
        public static final String MESSAGE_TYPE = "m_type";
        
        public static final String MMS_VERSION = "v";
        
        public static final String MESSAGE_SIZE = "m_size";
        
        public static final String PRIORITY = "pri";
        
        public static final String READ_REPORT = "rr";
        
        public static final String REPORT_ALLOWED = "rpt_a";
        
        public static final String RESPONSE_STATUS = "resp_st";
        
        public static final String STATUS = "st";
        
        public static final String TRANSACTION_ID = "tr_id";
        
        public static final String RETRIEVE_STATUS = "retr_st";
        
        public static final String RETRIEVE_TEXT = "retr_txt";
        
        public static final String RETRIEVE_TEXT_CHARSET = "retr_txt_cs";
        
        public static final String READ_STATUS = "read_status";
        
        public static final String CONTENT_CLASS = "ct_cls";
        
        public static final String DELIVERY_REPORT = "d_rpt";
        
        public static final String DELIVERY_TIME_TOKEN = "d_tm_tok";
        
        public static final String DELIVERY_TIME = "d_tm";
        
        public static final String RESPONSE_TEXT = "resp_txt";
        
        public static final String SENDER_VISIBILITY = "s_vis";
        
        public static final String REPLY_CHARGING = "r_chg";
        
        public static final String REPLY_CHARGING_DEADLINE_TOKEN = "r_chg_dl_tok";
        
        public static final String REPLY_CHARGING_DEADLINE = "r_chg_dl";
        
        public static final String REPLY_CHARGING_ID = "r_chg_id";
        
        public static final String REPLY_CHARGING_SIZE = "r_chg_sz";
        
        public static final String PREVIOUSLY_SENT_BY = "p_s_by";
        
        public static final String PREVIOUSLY_SENT_DATE = "p_s_d";
        
        public static final String STORE = "store";
        
        public static final String MM_STATE = "mm_st";
        
        public static final String MM_FLAGS_TOKEN = "mm_flg_tok";
        
        public static final String MM_FLAGS = "mm_flg";
        
        public static final String STORE_STATUS = "store_st";
        
        public static final String STORE_STATUS_TEXT = "store_st_txt";
        
        public static final String STORED = "stored";
        
        public static final String TOTALS = "totals";
        
        public static final String MBOX_TOTALS = "mb_t";
        
        public static final String MBOX_TOTALS_TOKEN = "mb_t_tok";
        
        public static final String QUOTAS = "qt";
        
        public static final String MBOX_QUOTAS = "mb_qt";
        
        public static final String MBOX_QUOTAS_TOKEN = "mb_qt_tok";
        
        public static final String MESSAGE_COUNT = "m_cnt";
        
        public static final String START = "start";
        
        public static final String DISTRIBUTION_INDICATOR = "d_ind";
        
        public static final String ELEMENT_DESCRIPTOR = "e_des";
        
        public static final String LIMIT = "limit";
        
        public static final String RECOMMENDED_RETRIEVAL_MODE = "r_r_mod";
        
        public static final String RECOMMENDED_RETRIEVAL_MODE_TEXT = "r_r_mod_txt";
        
        public static final String STATUS_TEXT = "st_txt";
        
        public static final String APPLIC_ID = "apl_id";
        
        public static final String REPLY_APPLIC_ID = "r_apl_id";
        
        public static final String AUX_APPLIC_ID = "aux_apl_id";
        
        public static final String DRM_CONTENT = "drm_c";
        
        public static final String ADAPTATION_ALLOWED = "adp_a";
        
        public static final String REPLACE_ID = "repl_id";
        
        public static final String CANCEL_ID = "cl_id";
        
        public static final String CANCEL_STATUS = "cl_st";
        
        public static final String THREAD_ID = "thread_id";
        
        public static final String LOCKED = "locked";
        
        public static final String META_DATA = "meta_data";
    }
    
    public interface CanonicalAddressesColumns extends BaseColumns {
        
        public static final String ADDRESS = "address";
    }
    
    public interface ThreadsColumns extends BaseColumns {
        
        public static final String DATE = "date";
        
        public static final String RECIPIENT_IDS = "recipient_ids";
        
        public static final String MESSAGE_COUNT = "message_count";
        
        public static final String READ = "read";
        
        public static final String SNIPPET = "snippet";
        
        public static final String SNIPPET_CHARSET = "snippet_cs";
        
        public static final String TYPE = "type";
        
        public static final String ERROR = "error";
        
        public static final String HAS_ATTACHMENT = "has_attachment";
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.501 -0500", hash_original_field = "9C97D618612CFF386E7AF19655372855", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.504 -0500", hash_original_field = "745FE27F6621B49CB7F0165D799C0855", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;

    // Constructor
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.506 -0500", hash_original_method = "2CAFC6EF3CCF11FE20893B46D3EAF4A2", hash_generated_method = "02158B301D581EDC7CDC2F4792882F93")
    
public Telephony() {
    }
}

