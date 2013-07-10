package android.provider;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.003 -0400", hash_original_method = "2CAFC6EF3CCF11FE20893B46D3EAF4A2", hash_generated_method = "A6723A410EBE39DDFE0725B9413E935E")
    public  Telephony() {
        
    }

    
    public static final class Sms implements BaseColumns, TextBasedSmsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.003 -0400", hash_original_method = "6F79CFAC0C9D88274D278FEEB27D8B11", hash_generated_method = "6F79CFAC0C9D88274D278FEEB27D8B11")
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

        
        @DSModeled(DSC.SPEC)
        public static Uri addMessageToUri(ContentResolver resolver,
                Uri uri, String address, String body, String subject,
                Long date, boolean read, boolean deliveryReport) {
            return addMessageToUri(resolver, uri, address, body, subject,
                    date, read, deliveryReport, -1L);
        }

        
        @DSModeled(DSC.SPEC)
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

        
        @DSModeled(DSC.SPEC)
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

        
        @DSModeled(DSC.SAFE)
        public static boolean isOutgoingFolder(int messageType) {
            return  (messageType == MESSAGE_TYPE_FAILED)
                    || (messageType == MESSAGE_TYPE_OUTBOX)
                    || (messageType == MESSAGE_TYPE_SENT)
                    || (messageType == MESSAGE_TYPE_QUEUED);
        }

        
        public static final class Inbox implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_method = "141F91EDC6AE2D7033D3DA3E508699AC", hash_generated_method = "141F91EDC6AE2D7033D3DA3E508699AC")
            public Inbox ()
            {
                
            }


            @DSModeled(DSC.SPEC)
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean read) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, read, false);
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_field = "78165DB38BE02BDE0148C2C3684715D4", hash_generated_field = "8F9F3983C32E942AD3AA334A0ACD8FF0")

            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/inbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Sent implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_method = "01BACB9453826DDA962919BC9AB080EE", hash_generated_method = "01BACB9453826DDA962919BC9AB080EE")
            public Sent ()
            {
                
            }


            @DSModeled(DSC.SPEC)
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_field = "E7BF8E235E7E3D28E785256C1EEF5976", hash_generated_field = "9830D39B7AEC0D2EF53002B242BC36C0")

            public static final Uri CONTENT_URI =
                    Uri.parse("content://sms/sent");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Draft implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.004 -0400", hash_original_method = "30DD07C39D661987683E6A54087310F0", hash_generated_method = "30DD07C39D661987683E6A54087310F0")
            public Draft ()
            {
                
            }


            @DSModeled(DSC.SPEC)
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, false);
            }

            
            @DSModeled(DSC.SPEC)
            public static boolean saveMessage(ContentResolver resolver,
                    Uri uri, String body) {
                ContentValues values = new ContentValues(2);
                values.put(BODY, body);
                values.put(DATE, System.currentTimeMillis());
                return resolver.update(uri, values, null, null) == 1;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "6BF0DBC50F2E1F69588347596769F056", hash_generated_field = "76B5C5D923A4786F7C708B2A7C50DCF6")

            public static final Uri CONTENT_URI =
                    Uri.parse("content://sms/draft");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Outbox implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_method = "06FAB0A617CEB33215E397D9BFE9D152", hash_generated_method = "06FAB0A617CEB33215E397D9BFE9D152")
            public Outbox ()
            {
                
            }


            @DSModeled(DSC.SPEC)
            public static Uri addMessage(ContentResolver resolver,
                    String address, String body, String subject, Long date,
                    boolean deliveryReport, long threadId) {
                return addMessageToUri(resolver, CONTENT_URI, address, body,
                        subject, date, true, deliveryReport, threadId);
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "ACE1724BEDD084EA7A1558FEB3E889A9", hash_generated_field = "CA70398127D2B0ADC3C34AC6FEB0C52A")

            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/outbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Conversations implements BaseColumns, TextBasedSmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_method = "6984BA613DF71E17158BEA5BF9053437", hash_generated_method = "6984BA613DF71E17158BEA5BF9053437")
            public Conversations ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "468AFB201361A9BE7B40A3943B4D6804", hash_generated_field = "16EFBE7184DEEDC0AADC8DE7C8F9E970")

            public static final Uri CONTENT_URI =
                Uri.parse("content://sms/conversations");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "B594A60FB28847C1B35EC0A7E03D9B59", hash_generated_field = "461E02376DD761106C9F50F56F21857C")

            public static final String SNIPPET = "snippet";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_field = "5A1243863BFB09F6F3358288EE67EB45", hash_generated_field = "AD44C5230C665F737EB24B33F905C77C")

            public static final String MESSAGE_COUNT = "msg_count";
        }


        
        public static final class Intents {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.006 -0400", hash_original_method = "1E952476DD941AF572EDA8AC50686906", hash_generated_method = "1E952476DD941AF572EDA8AC50686906")
            public Intents ()
            {
                
            }


            @DSModeled(DSC.SPEC)
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

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "4D46BD1A7AC902BB565CBD34C7BADFDA", hash_generated_field = "F3ADB15FC42BA451861D8CE0DD67EADC")

            public static final int RESULT_SMS_HANDLED = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "B95850668DD2DF3353689360760E9EBE", hash_generated_field = "9D88CC26E2D60D826B2D5688D983A2E3")

            public static final int RESULT_SMS_GENERIC_ERROR = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "71AB40B57277BF8C2329D500E19F4DC4", hash_generated_field = "5217C1622863BE20DD7880B1ECDAB840")

            public static final int RESULT_SMS_OUT_OF_MEMORY = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "0C821A6E1CF6EE0F8587F4E7205A37A1", hash_generated_field = "652B641018CAC11B8365BB138255CAB0")

            public static final int RESULT_SMS_UNSUPPORTED = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "804CF1286E9C53108EDE2535CE08907F", hash_generated_field = "B6DC26DA2462F0444538513A5810D7C2")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_RECEIVED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "62D2200E73E5FD0C7C8BF02C64A8E607", hash_generated_field = "0725F550AB537507121D73D8B328F5B3")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String DATA_SMS_RECEIVED_ACTION =
                    "android.intent.action.DATA_SMS_RECEIVED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "C6E64FC3512615E923F3F263F6B8A920", hash_generated_field = "0D0F6D80E4CA3809B3343310CFE36931")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String WAP_PUSH_RECEIVED_ACTION =
                    "android.provider.Telephony.WAP_PUSH_RECEIVED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "3EB0E5DD61E7D85887468C4EF515C1C3", hash_generated_field = "F1BC5F1D5E509125630B9F8ED16F8CB5")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_CB_RECEIVED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "EC413A59507B458636E4825618A632D8", hash_generated_field = "D837B19557264CD31F4B7887321EC9B7")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_EMERGENCY_CB_RECEIVED_ACTION =
                    "android.provider.Telephony.SMS_EMERGENCY_CB_RECEIVED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.007 -0400", hash_original_field = "72A48C04BDCA39D4013386A895D7FF66", hash_generated_field = "4E03BDF282E90EEDE2E9DD0D0612CB52")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SIM_FULL_ACTION =
                    "android.provider.Telephony.SIM_FULL";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.026 -0400", hash_original_field = "B0BDEA39E0FD2A202BB62A4AF8E0D434", hash_generated_field = "CF2E0AD427CE0F354C11FE6A4A4661DF")

            @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
            public static final String SMS_REJECTED_ACTION =
                "android.provider.Telephony.SMS_REJECTED";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.026 -0400", hash_original_field = "EDBEC9D0D95DDC27A634617DF325949A", hash_generated_field = "5E4676401D5C3305160757D85A228BC4")

        public static final Uri CONTENT_URI =
            Uri.parse("content://sms");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.026 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
    }


    
    public static final class Threads implements ThreadsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.026 -0400", hash_original_method = "45D6965ABD617E611598473C57FD4F7C", hash_generated_method = "082B4F6FF5F0018201C341C776361FB0")
        private  Threads() {
            
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "A861712F7725F2738ABAB62D420E3A18", hash_generated_field = "8352A6E8399E272B46A14174ED6516E0")

        private static final String[] ID_PROJECTION = { BaseColumns._ID };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "19A8EA95C7F16F568E0F8499CF6B4FCD", hash_generated_field = "01F22596571F5B47B496D99E20B085C9")

        private static final String STANDARD_ENCODING = "UTF-8";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "267F0952CFD2BC6077C0DAB4ACE09D0B", hash_generated_field = "48B4BF377FF6FB0F649F9E30B8559E5B")

        private static final Uri THREAD_ID_CONTENT_URI = Uri.parse(
                "content://mms-sms/threadID");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "64E6CA358CBE9C6AB0E39384E790B4F6", hash_generated_field = "E3839B0DEB12C7380DC01093452D8B2B")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(
                MmsSms.CONTENT_URI, "conversations");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "DAD0BF79F0CA53635B372DEAABE47A47", hash_generated_field = "16CC9E01E76C7FFCA89F24312CAF2FF4")

        public static final Uri OBSOLETE_THREADS_URI = Uri.withAppendedPath(
                CONTENT_URI, "obsolete");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "C44FB67B1EEECD9BDB71B9F79E615E44", hash_generated_field = "0EA950CFA852D09F85620C3D83F9B1D2")

        public static final int COMMON_THREAD    = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_field = "9C2A929B8E331851AF4E36D434556447", hash_generated_field = "E361587D52F3A07F5B27324A4A0F7CFC")

        public static final int BROADCAST_THREAD = 1;
    }


    
    public static final class Mms implements BaseMmsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.027 -0400", hash_original_method = "59489CF231D229E8B793F6BB93F87558", hash_generated_method = "59489CF231D229E8B793F6BB93F87558")
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_method = "141F91EDC6AE2D7033D3DA3E508699AC", hash_generated_method = "141F91EDC6AE2D7033D3DA3E508699AC")
            public Inbox ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "FD3D4A47B4184A3B945239F90C0175E6", hash_generated_field = "F9CAEE6005B47FC2B06B1883EC29741D")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/inbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Sent implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_method = "01BACB9453826DDA962919BC9AB080EE", hash_generated_method = "01BACB9453826DDA962919BC9AB080EE")
            public Sent ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "DF98B3D332181ACB689001F11EB24FAB", hash_generated_field = "D3824F01E3D7A102678F440DA457F6A8")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/sent");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Draft implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_method = "30DD07C39D661987683E6A54087310F0", hash_generated_method = "30DD07C39D661987683E6A54087310F0")
            public Draft ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "3FCD34586749C5F3E29E6DBF260C2CAE", hash_generated_field = "53485244D30DB502EB53C7D4D28015BF")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/drafts");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Outbox implements BaseMmsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_method = "06FAB0A617CEB33215E397D9BFE9D152", hash_generated_method = "06FAB0A617CEB33215E397D9BFE9D152")
            public Outbox ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "F53553E0A43669B3D7D858B918DCEFB3", hash_generated_field = "F3FBAECD1A011C6A74E382A1F3A3BF03")

            public static final Uri
                    CONTENT_URI = Uri.parse("content://mms/outbox");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.028 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

            public static final String DEFAULT_SORT_ORDER = "date DESC";
        }


        
        public static final class Addr implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_method = "240C49CE2280315AC94999B4C3BDDDB9", hash_generated_method = "240C49CE2280315AC94999B4C3BDDDB9")
            public Addr ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "B03EC63021F450101C1A0970B73AD265", hash_generated_field = "E860CDD6A108651539360F1130ED0B2A")

            public static final String MSG_ID = "msg_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "0CE2A8DD6475F91BC8653AC669995D85", hash_generated_field = "5384CF6C6A85CA6A30531E3C944068D3")

            public static final String CONTACT_ID = "contact_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "BB02CBDBA8E73953B493E6049E6740D4", hash_generated_field = "BEA83639AA525DC7F82CC0B39D80C6ED")

            public static final String ADDRESS = "address";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "3A93FC6551B100BB870FF7F82CF9B7F1", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

            public static final String TYPE = "type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "5E12DB3C55EC74B8311FCFF8B780A34F", hash_generated_field = "087203CA483BFA4282CC523544C8FADB")

            public static final String CHARSET = "charset";
        }


        
        public static final class Part implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_method = "9A3D51732327B3711C976CCE6283B7F6", hash_generated_method = "9A3D51732327B3711C976CCE6283B7F6")
            public Part ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "86ACCFBC8C460AA87CE34A023278EC3E", hash_generated_field = "8E870E8CB9A3CF8AA38AD6C4448728E0")

            public static final String MSG_ID = "mid";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "B16B52A8F87AC9A3E7DF5716D500E167", hash_generated_field = "B3B4F0AB1734E253732F5195B4201B41")

            public static final String SEQ = "seq";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "BED8008B139730D5AC1F68F212002EE4", hash_generated_field = "3D053512A06F67E25428FE33AC1E0FF7")

            public static final String CONTENT_TYPE = "ct";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "DF93ACD53BD3A496BAA30564AD0C5925", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

            public static final String NAME = "name";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "D64098EA8A664D05CA2EA74FCC045176", hash_generated_field = "F19BBF6000780F9703F0AD970B6ED23A")

            public static final String CHARSET = "chset";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "72BDFA9ADDC48D34202DEA72AD7BACDE", hash_generated_field = "034347C41CBDBFCB27A264F7CFD0BE08")

            public static final String FILENAME = "fn";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "7E5034205CFCA6935474C799E26F159C", hash_generated_field = "FBAB6BA0513ED7FE7A09AE5E4B2E7FDF")

            public static final String CONTENT_DISPOSITION = "cd";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "FFB103F5896C0E7C48F08D4DEC7552A3", hash_generated_field = "FB3535DF43B2F9EBAB6CE9D55270D006")

            public static final String CONTENT_ID = "cid";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "56EA935AEF3979EF183F439A46D5EAAD", hash_generated_field = "01CC779370BD03928AB110C6429E9BE0")

            public static final String CONTENT_LOCATION = "cl";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "148DDCBCCABB2B6815781C8FF918388D", hash_generated_field = "63050F47D1635B2D6423AB9F39AC8970")

            public static final String CT_START = "ctt_s";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "F389460ED16FCF2FC96E1A35A15E0693", hash_generated_field = "54F96DCDA030C4DE5824FD842CC19D05")

            public static final String CT_TYPE = "ctt_t";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "18906D7639726B192F36BA34222E9041", hash_generated_field = "6019C57F4087C2B434AB905CD1126FDC")

            public static final String _DATA = "_data";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "7ADEA73777B72C185F1B9573B31A997D", hash_generated_field = "7F68E2947E21BC10A9CA9D937E2EFCEB")

            public static final String TEXT = "text";
        }


        
        public static final class Rate {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_method = "8DE7FBCF11006E383291B1DA82AD2709", hash_generated_method = "8DE7FBCF11006E383291B1DA82AD2709")
            public Rate ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "02C4EB7EAD6989FDC4A9A6DA7F3190BB", hash_generated_field = "C73AB89F9797F2712EA638E4BF187501")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    Mms.CONTENT_URI, "rate");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.029 -0400", hash_original_field = "02DA297BF6980DBDA27CA0098F5493CB", hash_generated_field = "EDBEDB95540CA570BB8435CA63159001")

            public static final String SENT_TIME = "sent_time";
        }


        
        public static final class Intents {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
            private  Intents() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "6778850B42968AE7ED9E5EF19A663591", hash_generated_field = "6F1537B0D20DA96C878B5C71EA17FA48")

            public static final String EXTRA_CONTENTS = "contents";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "F3F6C939B8735DB514BA5D6D861A4D73", hash_generated_field = "112351A2319F01A5AD654CB608E1D733")

            public static final String EXTRA_TYPES    = "types";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "2AABF75E32734D9B08D8BCA96E1A75AF", hash_generated_field = "4923428C2F05859A662AFB1418FE907A")

            public static final String EXTRA_CC       = "cc";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "6CE18813E5802CD7FAD7D9F9D43E9B06", hash_generated_field = "F8A508D5ED6945D974DECCC56AD35166")

            public static final String EXTRA_BCC      = "bcc";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "03CCD80C503409FD5F6DA9B303D4BCA3", hash_generated_field = "EDC63051572D26FFD697DBF50DD6BF56")

            public static final String EXTRA_SUBJECT  = "subject";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "9815111B07612033B8F175976D42AA2A", hash_generated_field = "921FF0F260C29F8B3FACE564E15BF593")

            public static final String
            CONTENT_CHANGED_ACTION = "android.intent.action.CONTENT_CHANGED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "0ED134330492532D320C308EE0568906", hash_generated_field = "D69BD2570D1982720AE320E3BA14DBFE")

            public static final String DELETED_CONTENTS = "deleted_contents";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "0ACF18EAEA94E9214BEEB975FAFC80FA", hash_generated_field = "743596F13702A332C2F6A82A0F5E0A20")

        public static final Uri CONTENT_URI = Uri.parse("content://mms");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "A4BF07CD81BB52485E260AC6617B2129", hash_generated_field = "055A393B2924B35F63A91789B785D1D3")

        public static final Uri REPORT_REQUEST_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-request");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "678F8BAECD994FE918DCA38E54DD6692", hash_generated_field = "2B742DCB087975A88B80D98C0B3DB168")

        public static final Uri REPORT_STATUS_URI = Uri.withAppendedPath(
                                            CONTENT_URI, "report-status");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "860A09739374169FF1957C8D25D0893D", hash_generated_field = "4926448D7594E8866DDEBE0B8E79C7BF")

        public static final String DEFAULT_SORT_ORDER = "date DESC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "1E9246126298EAC498BA26D18A5881AC", hash_generated_field = "B92D7F293C4D0907D348382C719CDDE8")

        public static final Pattern NAME_ADDR_EMAIL_PATTERN =
                Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "DB3DA9483E9CB5E78EF1906572E6FC59", hash_generated_field = "D97B56BA1675A61156419B8C11EC688A")

        public static final Pattern QUOTED_STRING_PATTERN =
                Pattern.compile("\\s*\"([^\"]*)\"\\s*");
    }


    
    public static final class MmsSms implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_method = "9BF54BA5F2455087717E5B05EBB691D5", hash_generated_method = "9BF54BA5F2455087717E5B05EBB691D5")
        public MmsSms ()
        {
            
        }


        public static final class PendingMessages implements BaseColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_method = "170CA936DAF3534DFB0A0B79794E3A00", hash_generated_method = "170CA936DAF3534DFB0A0B79794E3A00")
            public PendingMessages ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "D9103A508498D4F1146E585AB89456D6", hash_generated_field = "A45CA31EB044CE870CDE0E8E242D7E4B")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(
                    MmsSms.CONTENT_URI, "pending");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "A6067106411A5D48A9CCCE31C8FB5A13", hash_generated_field = "DDCA1A3660B15140C626BBC5A81F0499")

            public static final String PROTO_TYPE = "proto_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "B03EC63021F450101C1A0970B73AD265", hash_generated_field = "E860CDD6A108651539360F1130ED0B2A")

            public static final String MSG_ID = "msg_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "99DE1E1B29EB20B893F6C9F4B8CE8ACB", hash_generated_field = "DF1CED8D10D9FE4A1B53B70E1F019B9E")

            public static final String MSG_TYPE = "msg_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "A49E8D3AD601A72535674A00ED8BFFA1", hash_generated_field = "559E9403DFCBFDD9D0A32254097A8A67")

            public static final String ERROR_TYPE = "err_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "E58FE9A44CAD177CA307E5516D5A00E8", hash_generated_field = "047B5E7CC71849654879C7AE09B3F4F8")

            public static final String ERROR_CODE = "err_code";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "DD8853DBFD93B50D833F051EDEF6C0AB", hash_generated_field = "9DDF25C408D54C2921F50E476BB1303B")

            public static final String RETRY_INDEX = "retry_index";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "A6B63617FF994B38C7112CB3AC50E2F0", hash_generated_field = "2CACB59A3AF3C33685576A2601F55F7C")

            public static final String DUE_TIME = "due_time";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "2E3819A4EE43E853A0767353E2558003", hash_generated_field = "995B3F5B5B885A05029EB4556D8ADE54")

            public static final String LAST_TRY = "last_try";
        }


        
        public static final class WordsTable {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_method = "480A168A1C6BA9EBC664C3157DB5A59D", hash_generated_method = "480A168A1C6BA9EBC664C3157DB5A59D")
            public WordsTable ()
            {
                
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "7E5E2750791E8E194A5E2FDF6565BB0B", hash_generated_field = "3C2D71BF930B87FEECA9710D884C1BB3")

            public static final String ID = "_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "C7B519FA4C875AEA69D73B5B8A85A1DB", hash_generated_field = "D5203D02067622E5461610FA9E0ED4F0")

            public static final String SOURCE_ROW_ID = "source_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "65FDFE9DC674D60553556A5C07806F10", hash_generated_field = "178E47738C14553382EE1E9ABE2AB8B3")

            public static final String TABLE_ID = "table_to_use";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "403DCAF675330F99863A19EEFC233004", hash_generated_field = "C40C91A1D34AC70A6AA26AD824441031")

            public static final String INDEXED_TEXT = "index_text";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "21D4E12E682E097461B30A64107F002D", hash_generated_field = "8294BF03F1BCCC1A530C57E7DBE14CC8")

        public static final String TYPE_DISCRIMINATOR_COLUMN =
                "transport_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "9CC4F002120A634CE43F1E8918A411C1", hash_generated_field = "725D49CB9A779935D7438B22EE5EF841")

        public static final Uri CONTENT_URI = Uri.parse("content://mms-sms/");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.030 -0400", hash_original_field = "B7D40DF70E03A7D4D7E22E3B0FA802BA", hash_generated_field = "C59F3E84EBBB0AC1380C88A59475A3A8")

        public static final Uri CONTENT_CONVERSATIONS_URI = Uri.parse(
                "content://mms-sms/conversations");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "FA485AD0AFE93B52C18B31996491F989", hash_generated_field = "C254F7847DB4E69055614E014ECAD96B")

        public static final Uri CONTENT_FILTER_BYPHONE_URI = Uri.parse(
                "content://mms-sms/messages/byphone");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "37C83A71545AD99680D13D14BD2D1DBD", hash_generated_field = "5A2955C176679B662C0C17C048B26518")

        public static final Uri CONTENT_UNDELIVERED_URI = Uri.parse(
                "content://mms-sms/undelivered");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "94B0634FA5A9A009E7BB611487044759", hash_generated_field = "4F59FF53C38C1BDA527B0BED040B8736")

        public static final Uri CONTENT_DRAFT_URI = Uri.parse(
                "content://mms-sms/draft");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "6EDB599F71B977240691CEAA6C893297", hash_generated_field = "0560816728199652A5CB6C27D362699C")

        public static final Uri CONTENT_LOCKED_URI = Uri.parse(
                "content://mms-sms/locked");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "D6F8270E30D4C8FC27E03258252A6E30", hash_generated_field = "C7EF221ABCA99183E3EA2867726E141E")

        public static final Uri SEARCH_URI = Uri.parse(
                "content://mms-sms/search");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "AB264FFD1F62F0DF7A40B92F3C0CE0C8", hash_generated_field = "A0B445A2BFE3ABFB7A5E3ED5BCC4E4C1")

        public static final int SMS_PROTO = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "FD2253AD127A69F78D4FAFEAB92FC322", hash_generated_field = "BC9D1CC8090F1A13F4525AD5BFE08179")

        public static final int MMS_PROTO = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "1B1949A508D4DA61D498C0A487C31F8F", hash_generated_field = "B8303B3F0D63DDF614BF107FEB77E81A")

        public static final int NO_ERROR                      = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "4BE54F9741F55D9EE76EAFDF699070C0", hash_generated_field = "A0E4EEB9435E3B4EA81275AEB6BD0AD6")

        public static final int ERR_TYPE_GENERIC              = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "1AFD731FB4F4395F38C6026C1172CBB4", hash_generated_field = "0ABC2012161C81438CE079E3282EC3B2")

        public static final int ERR_TYPE_SMS_PROTO_TRANSIENT  = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "EB0876F2F18746963D3841005FDF7BF8", hash_generated_field = "F4308D0192C6A19EF045E7440BB4B92C")

        public static final int ERR_TYPE_MMS_PROTO_TRANSIENT  = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "8A8106DB7490A53B943A57393326C360", hash_generated_field = "8F0C54AA7F843B1A03524B8476A2C7F6")

        public static final int ERR_TYPE_TRANSPORT_FAILURE    = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "BF6757A86756CC513E678120CBE005CD", hash_generated_field = "47C87217CD5222AED2A5BA2C96EA04F1")

        public static final int ERR_TYPE_GENERIC_PERMANENT    = 10;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "408E62DCA6F894387E40BC2F2ED0A727", hash_generated_field = "51D9C54EA11627D2231A722A33BE5B99")

        public static final int ERR_TYPE_SMS_PROTO_PERMANENT  = 11;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "DF2D459D127E99131F226332227A65CC", hash_generated_field = "666D817A76159035D9ED782E6EB7B1F9")

        public static final int ERR_TYPE_MMS_PROTO_PERMANENT  = 12;
    }


    
    public static final class Carriers implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_method = "6476EDBFB29271C848491911726650D3", hash_generated_method = "6476EDBFB29271C848491911726650D3")
        public Carriers ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "6025BEDB9A6C166F611D1122692FC6BD", hash_generated_field = "B83F159B5508CA04D478D2F19B7BC0B7")

        public static final Uri CONTENT_URI =
            Uri.parse("content://telephony/carriers");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "58DB5BEFA9854519A985688728683A1A", hash_generated_field = "9CB03A1E7A96D497D2A20539B2DA9F7D")

        public static final String DEFAULT_SORT_ORDER = "name ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "DF93ACD53BD3A496BAA30564AD0C5925", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

        public static final String NAME = "name";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "A38265A057F4043CA390207C7C0E4C0A", hash_generated_field = "F300D686F5A12199946063E3A258481F")

        public static final String APN = "apn";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "4FC21F49004EB5889E89886E9BEDAA7A", hash_generated_field = "4B15713FC5C43FDE94601F76F5DBD23D")

        public static final String PROXY = "proxy";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "AD5A3E7E04C7742731C923504A48183F", hash_generated_field = "99DCABF3DA7F9D1D88CC95B61DFB04A9")

        public static final String PORT = "port";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "513F98CB3F336B8A0BFEC531BF098C09", hash_generated_field = "C182EEEECAE2F461BF2A41DF367D73EC")

        public static final String MMSPROXY = "mmsproxy";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "2FA2F93073838EE6AD33AE728B11D26B", hash_generated_field = "8F3193E08FE92B96D7D5643DC6A92A95")

        public static final String MMSPORT = "mmsport";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "346CA9D5638D6472ABE367727CF2D359", hash_generated_field = "9C32C8BBED42D75F080E14E6DA9B790C")

        public static final String SERVER = "server";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "2F525D63281BEC6D002BC4263B4225A0", hash_generated_field = "834D644845EB5ED38B265C95BBA49CB4")

        public static final String USER = "user";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "5A516F106D6653FF16ED640D89DC0AC1", hash_generated_field = "CBB5222D1140EC3444B2A0FD7AD4FE88")

        public static final String PASSWORD = "password";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "839E781D3888E98C29B8B18884FBBB87", hash_generated_field = "6EC7E1D83CD69F9BC43F1655B9CBF19F")

        public static final String MMSC = "mmsc";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "39C85DE96688A47DF5EB3DF994528DBD", hash_generated_field = "C487DD96CBAD610F74EC365BEA80962D")

        public static final String MCC = "mcc";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "DE788E8361664A5F0BD71277CE3D5765", hash_generated_field = "822D32F51A87BFC1642F46FB088FE20A")

        public static final String MNC = "mnc";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "7CF1A9F95D70562604998A85040C3982", hash_generated_field = "084A9800CBA32160C0F4D0927F523ACE")

        public static final String NUMERIC = "numeric";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "7ABF693DABDDC18C1F6634BD8F914F86", hash_generated_field = "7F6EF22DA072B11AE4CEA166BF6DBADD")

        public static final String AUTH_TYPE = "authtype";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "3A93FC6551B100BB870FF7F82CF9B7F1", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "EB8535D2195DE87D57B485D34EC9E3E8", hash_generated_field = "2B595158C181DC1628EB9A295127ADAA")

        public static final String INACTIVE_TIMER = "inactivetimer";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "BB0D7FCC1021579B2EBCA8FB32B9A014", hash_generated_field = "38B59F865EC8485B65B816B06D008AB8")

        public static final String ENABLED = "enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "FC007E825E38A8407E642A890ABB6F0F", hash_generated_field = "74E32F478BCE7B6EBA1201E01506F685")

        public static final String CLASS = "class";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "17C8FF340144973957086F1BD1BE3274", hash_generated_field = "8B629361886A9352455859D3FDF79949")

        public static final String PROTOCOL = "protocol";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "E07261A091199E6F64A075286D2E84EF", hash_generated_field = "11E51D76C955DAD413581C2CA1BFB651")

        public static final String ROAMING_PROTOCOL = "roaming_protocol";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "38FBAAD3A725CAE8756AFC33063E8717", hash_generated_field = "59BA209EAF04B1C0A5952989A6ACC6C5")

        public static final String CURRENT = "current";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "F2152C0ABCD7F6CE1D6252A199F4A576", hash_generated_field = "BC1608B5480B870191D648F68C4136A8")

        public static final String CARRIER_ENABLED = "carrier_enabled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.031 -0400", hash_original_field = "4D47EC4D628A536FA7FDAF1690417F78", hash_generated_field = "862209E7F6CB1BB56AAA8EB7E027E87B")

        public static final String BEARER = "bearer";
    }


    
    public static final class Intents {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "EA72F3CC8155CC6EE36EFFE9F5347D99")
        private  Intents() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "7C42D04D11C66DF7D40973C702F74198", hash_generated_field = "01669067B5317112DD0057A9B1FE9009")

        public static final String SECRET_CODE_ACTION =
                "android.provider.Telephony.SECRET_CODE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "37DBEB6020596100235760A8ECD22AB0", hash_generated_field = "40776CD3668AC5CF392E1D3DE7F42EDA")

        public static final String SPN_STRINGS_UPDATED_ACTION =
                "android.provider.Telephony.SPN_STRINGS_UPDATED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "504E820DF515F2C1995342FA3EEC729E", hash_generated_field = "35D93941BBB76FB59A8BAC9F6C8D581B")

        public static final String EXTRA_SHOW_PLMN  = "showPlmn";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "7D6402E6D7C227B60DC1F8BDA7D60188", hash_generated_field = "26980D0EFE6BDF43AF9F26E0F475BC60")

        public static final String EXTRA_PLMN       = "plmn";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "74C8C20CEF9866276AECB0816994902C", hash_generated_field = "0A2A2EFF31246EB3A6185CE2663CBB9F")

        public static final String EXTRA_SHOW_SPN   = "showSpn";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "B61F720C5185AF85151150179873453A", hash_generated_field = "D20853DD357283639E7C34C01D65DC68")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "B373D963FCFB1F90129B85702FED714E", hash_generated_field = "77836E000F3832B9A06FE340F2EDE5DC")

    private static final String TAG = "Telephony";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")

    private static final boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.032 -0400", hash_original_field = "AAFDAF871858750A211AC8DBE6D1B76E", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
}

