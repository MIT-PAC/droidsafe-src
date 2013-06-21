package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import android.os.Environment;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Telephony {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.081 -0400", hash_original_method = "2CAFC6EF3CCF11FE20893B46D3EAF4A2", hash_generated_method = "A6723A410EBE39DDFE0725B9413E935E")
    @DSModeled(DSC.SAFE)
    public Telephony() {
        // ---------- Original Method ----------
    }

    
    public static final class Sms implements BaseColumns, TextBasedSmsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.082 -0400", hash_original_method = "6829BA2F4FD673BBA0D9AF4706DFB2B5", hash_generated_method = "6829BA2F4FD673BBA0D9AF4706DFB2B5")
                public Sms ()
        {
        }


                public static final Cursor query(ContentResolver cr, String[] projection) {
            return cr.query(CONTENT_URI, projection, null, null, DEFAULT_SORT_ORDER);
        }

        
                public static final Cursor query(ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return cr.query(CONTENT_URI, projection, where,
                                         null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
        }

        
                public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport) {
            return addMessageToUri(resolver, uri, address, body, subject,
                    date, read, deliveryReport, -1L);
        }

        
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

        
                public static boolean isOutgoingFolder(int messageType) {
            return  (messageType == MESSAGE_TYPE_FAILED)
                    || (messageType == MESSAGE_TYPE_OUTBOX)
                    || (messageType == MESSAGE_TYPE_SENT)
                    || (messageType == MESSAGE_TYPE_QUEUED);
        }

        
        public static final class Inbox implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.083 -0400", hash_original_method = "20ABA847644C6179AB5A3586E0076328", hash_generated_method = "20ABA847644C6179AB5A3586E0076328")
                        public Inbox ()
            {
            }


                        public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean read) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, read, false);
            }

            
            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/inbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Sent implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.083 -0400", hash_original_method = "41FD6FEE7053C56AB006CC2648CC328A", hash_generated_method = "41FD6FEE7053C56AB006CC2648CC328A")
                        public Sent ()
            {
            }


                        public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }

            
            public static final Uri CONTENT_URI =
                    Uri.parse("content://sms/sent");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Draft implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.083 -0400", hash_original_method = "5D4B4431A7D4E124E70BFCFABE5A0431", hash_generated_method = "5D4B4431A7D4E124E70BFCFABE5A0431")
                        public Draft ()
            {
            }


                        public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }

            
                        public static boolean saveMessage(ContentResolver resolver,
                    Uri uri, String body) {
                ContentValues values = new ContentValues(2);
                values.put(BODY, body);
                values.put(DATE, System.currentTimeMillis());
                return resolver.update(uri, values, null, null) == 1;
            }

            
            public static final Uri CONTENT_URI =
                    Uri.parse("content://sms/draft");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Outbox implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.083 -0400", hash_original_method = "6421BC7B8652A2EE064B19667FC00891", hash_generated_method = "6421BC7B8652A2EE064B19667FC00891")
                        public Outbox ()
            {
            }


                        public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean deliveryReport, long threadId) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, deliveryReport, threadId);
            }

            
            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/outbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Conversations implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.084 -0400", hash_original_method = "350981951DFFFA5BCCA87B49119500E7", hash_generated_method = "350981951DFFFA5BCCA87B49119500E7")
                        public Conversations ()
            {
            }


            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/conversations");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
            public static final String SNIPPET = "snippet";
            public static final String MESSAGE_COUNT = "msg_count";
        }


        
        public static final class Intents {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.084 -0400", hash_original_method = "FD95D140BFADEB4CFA03E1D7AD3D1B16", hash_generated_method = "FD95D140BFADEB4CFA03E1D7AD3D1B16")
                        public Intents ()
            {
            }


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

            
            public static final int RESULT_SMS_HANDLED = 1;
            public static final int RESULT_SMS_GENERIC_ERROR = 2;
            public static final int RESULT_SMS_OUT_OF_MEMORY = 3;
            public static final int RESULT_SMS_UNSUPPORTED = 4;
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SMS_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_RECEIVED";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String DATA_SMS_RECEIVED_ACTION =
                    "android.intent.action.DATA_SMS_RECEIVED";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String WAP_PUSH_RECEIVED_ACTION =
                    "android.provider.Telephony.WAP_PUSH_RECEIVED";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SMS_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_CB_RECEIVED";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SMS_EMERGENCY_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SIM_FULL_ACTION =
                    "android.provider.Telephony.SIM_FULL";
            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String SMS_REJECTED_ACTION =
                "android.provider.Telephony.SMS_REJECTED";
        }


        
        public static final Uri CONTENT_URI =
            Uri.parse("content://sms");
        public static final String DEFAULT_SORT_ORDER = "date DESC";
    }


    
    public static final class Threads implements ThreadsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.084 -0400", hash_original_method = "45D6965ABD617E611598473C57FD4F7C", hash_generated_method = "082B4F6FF5F0018201C341C776361FB0")
        @DSModeled(DSC.SAFE)
        private Threads() {
            // ---------- Original Method ----------
        }

        
                public static long getOrCreateThreadId(Context context, String recipient) {
            Set<String> recipients = new HashSet<String>();
            recipients.add(recipient);
            return getOrCreateThreadId(context, recipients);
        }

        
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

        
        private static final String[] ID_PROJECTION = { BaseColumns._ID };
        private static final String STANDARD_ENCODING = "UTF-8";
        private static final Uri THREAD_ID_CONTENT_URI = Uri.parse(
                "content://mms-sms/threadID");
        public static final Uri CONTENT_URI = Uri.withAppendedPath(
                MmsSms.CONTENT_URI, "conversations");
        public static final Uri OBSOLETE_THREADS_URI = Uri.withAppendedPath(
                CONTENT_URI, "obsolete");
        public static final int COMMON_THREAD    = 0;
        public static final int BROADCAST_THREAD = 1;
    }


    
    public static final class Mms implements BaseMmsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.085 -0400", hash_original_method = "9C1DE143FF3A8E7B94174DD56D606D53", hash_generated_method = "9C1DE143FF3A8E7B94174DD56D606D53")
                public Mms ()
        {
        }


                public static final Cursor query(
                ContentResolver cr, String[] projection) {
            return cr.query(CONTENT_URI, projection, null, null, DEFAULT_SORT_ORDER);
        }

        
                public static final Cursor query(
                ContentResolver cr, String[] projection,
                String where, String orderBy) {
            return cr.query(CONTENT_URI, projection,
                    where, null, orderBy == null ? DEFAULT_SORT_ORDER : orderBy);
        }

        
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

        
                public static String extractAddrSpec(String address) {
            Matcher match = NAME_ADDR_EMAIL_PATTERN.matcher(address);
            if (match.matches()) {
                return match.group(2);
            }
            return address;
        }

        
                public static boolean isEmailAddress(String address) {
            if (TextUtils.isEmpty(address)) {
                return false;
            }
            String s = extractAddrSpec(address);
            Matcher match = Patterns.EMAIL_ADDRESS.matcher(s);
            return match.matches();
        }

        
                public static boolean isPhoneNumber(String number) {
            if (TextUtils.isEmpty(number)) {
                return false;
            }
            Matcher match = Patterns.PHONE.matcher(number);
            return match.matches();
        }

        
        public static final class Inbox implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.086 -0400", hash_original_method = "20ABA847644C6179AB5A3586E0076328", hash_generated_method = "20ABA847644C6179AB5A3586E0076328")
                        public Inbox ()
            {
            }


            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/inbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Sent implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.093 -0400", hash_original_method = "41FD6FEE7053C56AB006CC2648CC328A", hash_generated_method = "41FD6FEE7053C56AB006CC2648CC328A")
                        public Sent ()
            {
            }


            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/sent");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Draft implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "5D4B4431A7D4E124E70BFCFABE5A0431", hash_generated_method = "5D4B4431A7D4E124E70BFCFABE5A0431")
                        public Draft ()
            {
            }


            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/drafts");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Outbox implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "6421BC7B8652A2EE064B19667FC00891", hash_generated_method = "6421BC7B8652A2EE064B19667FC00891")
                        public Outbox ()
            {
            }


            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/outbox");
            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Addr implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "C723C7FC256368D165BE4A59AD483152", hash_generated_method = "C723C7FC256368D165BE4A59AD483152")
                        public Addr ()
            {
            }


            public static final String MSG_ID = "msg_id";
            public static final String CONTACT_ID = "contact_id";
            public static final String ADDRESS = "address";
            public static final String TYPE = "type";
            public static final String CHARSET = "charset";
        }


        
        public static final class Part implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "5A016F84BF5EC8BA99ACC9805438FA5D", hash_generated_method = "5A016F84BF5EC8BA99ACC9805438FA5D")
                        public Part ()
            {
            }


            public static final String MSG_ID = "mid";
            public static final String SEQ = "seq";
            public static final String CONTENT_TYPE = "ct";
            public static final String NAME = "name";
            public static final String CHARSET = "chset";
            public static final String FILENAME = "fn";
            public static final String CONTENT_DISPOSITION = "cd";
            public static final String CONTENT_ID = "cid";
            public static final String CONTENT_LOCATION = "cl";
            public static final String CT_START = "ctt_s";
            public static final String CT_TYPE = "ctt_t";
            public static final String _DATA = "_data";
            public static final String TEXT = "text";
        }


        
        public static final class Rate {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "747921686999CBC86B7FC4C313931235", hash_generated_method = "747921686999CBC86B7FC4C313931235")
                        public Rate ()
            {
            }


            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    Mms.CONTENT_URI, "rate");
            public static final String SENT_TIME = "sent_time";
        }


        
        public static final class Intents {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
            @DSModeled(DSC.SAFE)
            private Intents() {
                // ---------- Original Method ----------
            }

            
            public static final String EXTRA_CONTENTS = "contents";
            public static final String EXTRA_TYPES    = "types";
            public static final String EXTRA_CC       = "cc";
            public static final String EXTRA_BCC      = "bcc";
            public static final String EXTRA_SUBJECT  = "subject";
            public static final String
            CONTENT_CHANGED_ACTION = "android.intent.action.CONTENT_CHANGED";
            public static final String DELETED_CONTENTS = "deleted_contents";
        }


        
        public static final Uri CONTENT_URI = Uri.parse("content://mms");
        public static final Uri REPORT_REQUEST_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-request");
        public static final Uri REPORT_STATUS_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-status");
        public static final String DEFAULT_SORT_ORDER = "date DESC";
        public static final Pattern NAME_ADDR_EMAIL_PATTERN =
                Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
        public static final Pattern QUOTED_STRING_PATTERN =
                Pattern.compile("\\s*\"([^\"]*)\"\\s*");
    }


    
    public static final class MmsSms implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.094 -0400", hash_original_method = "983D4F6B9EDC094AE28C05EBBA20A57C", hash_generated_method = "983D4F6B9EDC094AE28C05EBBA20A57C")
                public MmsSms ()
        {
        }


        public static final class PendingMessages implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.095 -0400", hash_original_method = "FAF402554F7AD1D23E115D486CC038D4", hash_generated_method = "FAF402554F7AD1D23E115D486CC038D4")
                        public PendingMessages ()
            {
            }


            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    MmsSms.CONTENT_URI, "pending");
            public static final String PROTO_TYPE = "proto_type";
            public static final String MSG_ID = "msg_id";
            public static final String MSG_TYPE = "msg_type";
            public static final String ERROR_TYPE = "err_type";
            public static final String ERROR_CODE = "err_code";
            public static final String RETRY_INDEX = "retry_index";
            public static final String DUE_TIME = "due_time";
            public static final String LAST_TRY = "last_try";
        }


        
        public static final class WordsTable {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.095 -0400", hash_original_method = "5B18C6639285C639D79D448EA64D4CA1", hash_generated_method = "5B18C6639285C639D79D448EA64D4CA1")
                        public WordsTable ()
            {
            }


            public static final String ID = "_id";
            public static final String SOURCE_ROW_ID = "source_id";
            public static final String TABLE_ID = "table_to_use";
            public static final String INDEXED_TEXT = "index_text";
        }


        
        public static final String TYPE_DISCRIMINATOR_COLUMN =
                "transport_type";
        public static final Uri CONTENT_URI = Uri.parse("content://mms-sms/");
        public static final Uri CONTENT_CONVERSATIONS_URI = Uri.parse(
                "content://mms-sms/conversations");
        public static final Uri CONTENT_FILTER_BYPHONE_URI = Uri.parse(
                "content://mms-sms/messages/byphone");
        public static final Uri CONTENT_UNDELIVERED_URI = Uri.parse(
                "content://mms-sms/undelivered");
        public static final Uri CONTENT_DRAFT_URI = Uri.parse(
                "content://mms-sms/draft");
        public static final Uri CONTENT_LOCKED_URI = Uri.parse(
                "content://mms-sms/locked");
        public static final Uri SEARCH_URI = Uri.parse(
                "content://mms-sms/search");
        public static final int SMS_PROTO = 0;
        public static final int MMS_PROTO = 1;
        public static final int NO_ERROR                      = 0;
        public static final int ERR_TYPE_GENERIC              = 1;
        public static final int ERR_TYPE_SMS_PROTO_TRANSIENT  = 2;
        public static final int ERR_TYPE_MMS_PROTO_TRANSIENT  = 3;
        public static final int ERR_TYPE_TRANSPORT_FAILURE    = 4;
        public static final int ERR_TYPE_GENERIC_PERMANENT    = 10;
        public static final int ERR_TYPE_SMS_PROTO_PERMANENT  = 11;
        public static final int ERR_TYPE_MMS_PROTO_PERMANENT  = 12;
    }


    
    public static final class Carriers implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.095 -0400", hash_original_method = "BB8C0C3ED33513D8E449DC4720B84D04", hash_generated_method = "BB8C0C3ED33513D8E449DC4720B84D04")
                public Carriers ()
        {
        }


        public static final Uri CONTENT_URI =
            Uri.parse("content://telephony/carriers");
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        public static final String NAME = "name";
        public static final String APN = "apn";
        public static final String PROXY = "proxy";
        public static final String PORT = "port";
        public static final String MMSPROXY = "mmsproxy";
        public static final String MMSPORT = "mmsport";
        public static final String SERVER = "server";
        public static final String USER = "user";
        public static final String PASSWORD = "password";
        public static final String MMSC = "mmsc";
        public static final String MCC = "mcc";
        public static final String MNC = "mnc";
        public static final String NUMERIC = "numeric";
        public static final String AUTH_TYPE = "authtype";
        public static final String TYPE = "type";
        public static final String INACTIVE_TIMER = "inactivetimer";
        public static final String ENABLED = "enabled";
        public static final String CLASS = "class";
        public static final String PROTOCOL = "protocol";
        public static final String ROAMING_PROTOCOL = "roaming_protocol";
        public static final String CURRENT = "current";
        public static final String CARRIER_ENABLED = "carrier_enabled";
        public static final String BEARER = "bearer";
    }


    
    public static final class Intents {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.101 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
        @DSModeled(DSC.SAFE)
        private Intents() {
            // ---------- Original Method ----------
        }

        
        public static final String SECRET_CODE_ACTION =
                "android.provider.Telephony.SECRET_CODE";
        public static final String SPN_STRINGS_UPDATED_ACTION =
                "android.provider.Telephony.SPN_STRINGS_UPDATED";
        public static final String EXTRA_SHOW_PLMN  = "showPlmn";
        public static final String EXTRA_PLMN       = "plmn";
        public static final String EXTRA_SHOW_SPN   = "showSpn";
        public static final String EXTRA_SPN        = "spn";
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
    
    private static final String TAG = "Telephony";
    private static final boolean DEBUG = true;
    private static final boolean LOCAL_LOGV = false;
}

