package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Contacts {
    private static final String TAG = "Contacts";
    @Deprecated
    public static final String AUTHORITY = "contacts";
    @Deprecated
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    @Deprecated
    public static final int KIND_EMAIL = 1;
    @Deprecated
    public static final int KIND_POSTAL = 2;
    @Deprecated
    public static final int KIND_IM = 3;
    @Deprecated
    public static final int KIND_ORGANIZATION = 4;
    @Deprecated
    public static final int KIND_PHONE = 5;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.114 -0400", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "B7BFE0CB877BB67929CBA3A0EFBDC212")
    @DSModeled(DSC.SAFE)
    private Contacts() {
        // ---------- Original Method ----------
    }

    
    public static final class Settings implements BaseColumns, SettingsColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/settings");
        @Deprecated
        public static final String CONTENT_DIRECTORY = "settings";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "key ASC";
        @Deprecated
        public static final String SYNC_EVERYTHING = "syncEverything";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "365127D9A7AD23806BCE93C671023170")
        @DSModeled(DSC.SAFE)
        private Settings() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "5973496923CC631047F98EE9B88FBD33", hash_generated_method = "90F8A1865EA504A4F1B358220130D9C2")
        @Deprecated
        public static String getSetting(ContentResolver cr, String account, String key) {
            String selectString;
            String[] selectArgs;
            if (false) {
                selectString = (account == null)
                        ? "_sync_account is null AND key=?"
                        : "_sync_account=? AND key=?";
                selectArgs = (account == null)
                ? new String[]{key}
                : new String[]{account, key};
            } else {
                selectString = "key=?";
                selectArgs = new String[] {key};
            }
            Cursor cursor = cr.query(Settings.CONTENT_URI, new String[]{VALUE},
                    selectString, selectArgs, null);
            try {
                if (!cursor.moveToNext()) return null;
                return cursor.getString(0);
            } finally {
                cursor.close();
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "99C82D4214524155DAD3BF65C95C7ABA", hash_generated_method = "BAAAED78C0AD54F0BFC22D8482A4CD14")
        @Deprecated
        public static void setSetting(ContentResolver cr, String account, String key,
                String value) {
            ContentValues values = new ContentValues();
            values.put(KEY, key);
            values.put(VALUE, value);
            cr.update(Settings.CONTENT_URI, values, null, null);
        }

        
    }


    
    public static final class People implements BaseColumns, SyncConstValue, PeopleColumns, PhonesColumns, PresenceColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/people");
        @Deprecated
        public static final Uri CONTENT_FILTER_URI =
            Uri.parse("content://contacts/people/filter");
        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_people");
        @Deprecated
        public static final Uri WITH_EMAIL_OR_IM_FILTER_URI =
            Uri.parse("content://contacts/people/with_email_or_im_filter");
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/person";
        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/person";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = People.NAME + " ASC";
        @Deprecated
        public static final String PRIMARY_PHONE_ID = "primary_phone";
        @Deprecated
        public static final String PRIMARY_EMAIL_ID = "primary_email";
        @Deprecated
        public static final String PRIMARY_ORGANIZATION_ID = "primary_organization";
        private static final String[] GROUPS_PROJECTION = new String[] {
            Groups._ID,
        };
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "17F062BF4D2F442415926444A39FDFDD", hash_generated_method = "FFEEE2C645E664A6DE55BADA27A726EA")
        @DSModeled(DSC.SAFE)
        private People() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "1F4F3F0FABB4A48916F6AF62043D55D9", hash_generated_method = "A58BD133F043240B5F7EDDDA299AF9BF")
        @Deprecated
        public static void markAsContacted(ContentResolver resolver, long personId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, personId);
            uri = Uri.withAppendedPath(uri, "update_contact_time");
            ContentValues values = new ContentValues();
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "3CCBD42AC579830F9F873C0E8E0D59CE", hash_generated_method = "8218AD0872E037DC74692F26BB609A75")
        @Deprecated
        public static long tryGetMyContactsGroupId(ContentResolver resolver) {
            Cursor groupsCursor = resolver.query(Groups.CONTENT_URI, GROUPS_PROJECTION,
                    Groups.SYSTEM_ID + "='" + Groups.GROUP_MY_CONTACTS + "'", null, null);
            if (groupsCursor != null) {
                try {
                    if (groupsCursor.moveToFirst()) {
                        return groupsCursor.getLong(0);
                    }
                } finally {
                    groupsCursor.close();
                }
            }
            return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.115 -0400", hash_original_method = "3A5282E15CEE22EBD4B3059F6543301A", hash_generated_method = "A41902CC088B7F31C09F291B7A79AD58")
        @Deprecated
        public static Uri addToMyContactsGroup(ContentResolver resolver, long personId) {
            long groupId = tryGetMyContactsGroupId(resolver);
            if (groupId == 0) {
                throw new IllegalStateException("Failed to find the My Contacts group");
            }
            return addToGroup(resolver, personId, groupId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "4B575D0B1951007B3070BB5D97839CB3", hash_generated_method = "98F0ABAF4C6F0C4447D99323EA8403DE")
        @Deprecated
        public static Uri addToGroup(ContentResolver resolver, long personId, String groupName) {
            long groupId = 0;
            Cursor groupsCursor = resolver.query(Groups.CONTENT_URI, GROUPS_PROJECTION,
                    Groups.NAME + "=?", new String[] { groupName }, null);
            if (groupsCursor != null) {
                try {
                    if (groupsCursor.moveToFirst()) {
                        groupId = groupsCursor.getLong(0);
                    }
                } finally {
                    groupsCursor.close();
                }
            }
            if (groupId == 0) {
                throw new IllegalStateException("Failed to find the My Contacts group");
            }
            return addToGroup(resolver, personId, groupId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "968792542D44AC477F2A3D6E8EC18199", hash_generated_method = "582ED73B9C814A91D150B866160080F7")
        @Deprecated
        public static Uri addToGroup(ContentResolver resolver, long personId, long groupId) {
            ContentValues values = new ContentValues();
            values.put(GroupMembership.PERSON_ID, personId);
            values.put(GroupMembership.GROUP_ID, groupId);
            return resolver.insert(GroupMembership.CONTENT_URI, values);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "1719055BB7B83C8257DECB960F96EA3B", hash_generated_method = "A8F0E1F0EF4A1ECDC529ABFE5CB85984")
        @Deprecated
        public static Uri createPersonInMyContactsGroup(ContentResolver resolver,
                ContentValues values) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            Uri contactUri = resolver.insert(People.CONTENT_URI, values);
            if (contactUri == null) {
                Log.e(TAG, "Failed to create the contact");
                return null;
            }
            if (addToMyContactsGroup(resolver, ContentUris.parseId(contactUri)) == null) {
                resolver.delete(contactUri, null, null);
                return null;
            }
            return contactUri;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "29F7E3FAB1A70735CD2895CF88304289", hash_generated_method = "1C4B13C4ECAF45161678185D3F4BCF2F")
        @Deprecated
        public static Cursor queryGroups(ContentResolver resolver, long person) {
            return resolver.query(GroupMembership.CONTENT_URI, null, "person=?",
                    new String[]{String.valueOf(person)}, Groups.DEFAULT_SORT_ORDER);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "E1EC7DAC113BEA053C3C92256F092BD9", hash_generated_method = "F5021A5E353FD1015A287A10966DEC2B")
        @Deprecated
        public static void setPhotoData(ContentResolver cr, Uri person, byte[] data) {
            Uri photoUri = Uri.withAppendedPath(person, Contacts.Photos.CONTENT_DIRECTORY);
            ContentValues values = new ContentValues();
            values.put(Photos.DATA, data);
            cr.update(photoUri, values, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "BCA4FB51D104561172D0471430841C22", hash_generated_method = "2A1260E6CCD1B80DCF11F08A821E4B48")
        @Deprecated
        public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri person) {
            Uri photoUri = Uri.withAppendedPath(person, Contacts.Photos.CONTENT_DIRECTORY);
            Cursor cursor = cr.query(photoUri, new String[]{Photos.DATA}, null, null, null);
            try {
                if (cursor == null || !cursor.moveToNext()) {
                    return null;
                }
                byte[] data = cursor.getBlob(0);
                if (data == null) {
                    return null;
                }
                return new ByteArrayInputStream(data);
            } finally {
                if (cursor != null) cursor.close();
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "50F8519255BFC8FA08076C6C60F3293C", hash_generated_method = "256A2A02373F69088619FBBAA5BA9D8B")
        @Deprecated
        public static Bitmap loadContactPhoto(Context context, Uri person,
                int placeholderImageResource, BitmapFactory.Options options) {
            if (person == null) {
                return loadPlaceholderPhoto(placeholderImageResource, context, options);
            }
            InputStream stream = openContactPhotoInputStream(context.getContentResolver(), person);
            Bitmap bm = stream != null ? BitmapFactory.decodeStream(stream, null, options) : null;
            if (bm == null) {
                bm = loadPlaceholderPhoto(placeholderImageResource, context, options);
            }
            return bm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "0212085D868EA31B6E294335A2EDC932", hash_generated_method = "21672A62600FCDFF8D6D5D2A316B5AF0")
        private static Bitmap loadPlaceholderPhoto(int placeholderImageResource, Context context,
                BitmapFactory.Options options) {
            if (placeholderImageResource == 0) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(),
                    placeholderImageResource, options);
        }

        
        public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "phones";
            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "number ASC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.116 -0400", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "17BC6CDCCB56159636EA0D8391829ECE")
            @DSModeled(DSC.SAFE)
            private Phones() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "contact_methods";
            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "data ASC";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "35837FA43A7C803BC2164DBD1B548A22")
            @DSModeled(DSC.SAFE)
            private ContactMethods() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static class Extensions implements BaseColumns, ExtensionsColumns {
            @Deprecated
            public static final String CONTENT_DIRECTORY = "extensions";
            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "name ASC";
            @Deprecated
            public static final String PERSON_ID = "person";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "816E3F3F5D843BF8F23C21E19862654D")
            @DSModeled(DSC.SAFE)
            private Extensions() {
                // ---------- Original Method ----------
            }

            
        }


        
    }


    
    public static final class Groups implements BaseColumns, SyncConstValue, GroupsColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groups");
        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_groups");
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroup";
        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroup";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = NAME + " ASC";
        @Deprecated
        public static final String GROUP_ANDROID_STARRED = "Starred in Android";
        @Deprecated
        public static final String GROUP_MY_CONTACTS = "Contacts";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "E58712013FF7B36A6658A1494B5BFC26")
        @DSModeled(DSC.SAFE)
        private Groups() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/phones");
        @Deprecated
        public static final Uri CONTENT_FILTER_URL =
            Uri.parse("content://contacts/phones/filter");
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone";
        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "17BC6CDCCB56159636EA0D8391829ECE")
        @DSModeled(DSC.SAFE)
        private Phones() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "47C658D10C7FF6AFCE9B91D6C434ADDC", hash_generated_method = "27BB02CE86DEC990C9D56E4E3086F939")
        @Deprecated
        public static final CharSequence getDisplayLabel(Context context, int type,
                CharSequence label, CharSequence[] labelArray) {
            CharSequence display = "";
            if (type != People.Phones.TYPE_CUSTOM) {
                CharSequence[] labels = labelArray != null? labelArray
                        : context.getResources().getTextArray(
                                com.android.internal.R.array.phoneTypes);
                try {
                    display = labels[type - 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    display = labels[People.Phones.TYPE_HOME - 1];
                }
            } else {
                if (!TextUtils.isEmpty(label)) {
                    display = label;
                }
            }
            return display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "4BFBBB1A99B20F000C01E55DF4773309", hash_generated_method = "83A79B941A8054E2F7C92228A01B766E")
        @Deprecated
        public static final CharSequence getDisplayLabel(Context context, int type,
                CharSequence label) {
            return getDisplayLabel(context, type, label, null);
        }

        
    }


    
    public static final class GroupMembership implements BaseColumns, GroupsColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groupmembership");
        @Deprecated
        public static final Uri RAW_CONTENT_URI =
            Uri.parse("content://contacts/groupmembershipraw");
        @Deprecated
        public static final String CONTENT_DIRECTORY = "groupmembership";
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroupmembership";
        @Deprecated
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contactsgroupmembership";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "group_id ASC";
        @Deprecated
        public static final String GROUP_ID = "group_id";
        @Deprecated
        public static final String GROUP_SYNC_ID = "group_sync_id";
        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT = "group_sync_account";
        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT_TYPE = "group_sync_account_type";
        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "6455CBCB097771EA280C661AD3A32623")
        @DSModeled(DSC.SAFE)
        private GroupMembership() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {
        @Deprecated
        public static final String POSTAL_LOCATION_LATITUDE = DATA;
        @Deprecated
        public static final String POSTAL_LOCATION_LONGITUDE = AUX_DATA;
        @Deprecated
        public static final int PROTOCOL_AIM = 0;
        @Deprecated
        public static final int PROTOCOL_MSN = 1;
        @Deprecated
        public static final int PROTOCOL_YAHOO = 2;
        @Deprecated
        public static final int PROTOCOL_SKYPE = 3;
        @Deprecated
        public static final int PROTOCOL_QQ = 4;
        @Deprecated
        public static final int PROTOCOL_GOOGLE_TALK = 5;
        @Deprecated
        public static final int PROTOCOL_ICQ = 6;
        @Deprecated
        public static final int PROTOCOL_JABBER = 7;
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/contact_methods");
        @Deprecated
        public static final Uri CONTENT_EMAIL_URI =
            Uri.parse("content://contacts/contact_methods/email");
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact-methods";
        @Deprecated
        public static final String CONTENT_EMAIL_TYPE = "vnd.android.cursor.dir/email";
        @Deprecated
        public static final String CONTENT_POSTAL_TYPE = "vnd.android.cursor.dir/postal-address";
        @Deprecated
        public static final String CONTENT_EMAIL_ITEM_TYPE = "vnd.android.cursor.item/email";
        @Deprecated
        public static final String CONTENT_POSTAL_ITEM_TYPE
                = "vnd.android.cursor.item/postal-address";
        @Deprecated
        public static final String CONTENT_IM_ITEM_TYPE = "vnd.android.cursor.item/jabber-im";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "35837FA43A7C803BC2164DBD1B548A22")
        @DSModeled(DSC.SAFE)
        private ContactMethods() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "20EDB941242725D8BA303E2B860FE539", hash_generated_method = "CCE123AF9C0FCAD4502254BE643632CE")
        @Deprecated
        public static String encodePredefinedImProtocol(int protocol) {
            return "pre:" + protocol;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.117 -0400", hash_original_method = "8BC78B797CC232A68DBC3E50049E83C3", hash_generated_method = "720DFE2B20CC6F16C9104872CE4EA60C")
        @Deprecated
        public static String encodeCustomImProtocol(String protocolString) {
            return "custom:" + protocolString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "D65E9D02F8AECAEE3697B543ED9D1C0D", hash_generated_method = "02BFBAC1B60115184B80578DDB31F69B")
        @Deprecated
        public static Object decodeImProtocol(String encodedString) {
            if (encodedString == null) {
                return null;
            }
            if (encodedString.startsWith("pre:")) {
                return Integer.parseInt(encodedString.substring(4));
            }
            if (encodedString.startsWith("custom:")) {
                return encodedString.substring(7);
            }
            throw new IllegalArgumentException(
                    "the value is not a valid encoded protocol, " + encodedString);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "71E6FB134E3F8929FE201B0D15431D0F", hash_generated_method = "3E798F46F6654ECB3DE3CF8AC41C1333")
        @Deprecated
        public static String lookupProviderNameFromId(int protocol) {
            switch (protocol) {
                case PROTOCOL_GOOGLE_TALK:
                    return ProviderNames.GTALK;
                case PROTOCOL_AIM:
                    return ProviderNames.AIM;
                case PROTOCOL_MSN:
                    return ProviderNames.MSN;
                case PROTOCOL_YAHOO:
                    return ProviderNames.YAHOO;
                case PROTOCOL_ICQ:
                    return ProviderNames.ICQ;
                case PROTOCOL_JABBER:
                    return ProviderNames.JABBER;
                case PROTOCOL_SKYPE:
                    return ProviderNames.SKYPE;
                case PROTOCOL_QQ:
                    return ProviderNames.QQ;
            }
            return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "E53FDAD74C5D20D2E7D8CB826DDE0DF9", hash_generated_method = "273F9BDCB1E873F32D2A6734B118D960")
        @Deprecated
        public static final CharSequence getDisplayLabel(Context context, int kind,
                int type, CharSequence label) {
            CharSequence display = "";
            switch (kind) {
                case KIND_EMAIL: {
                    if (type != People.ContactMethods.TYPE_CUSTOM) {
                        CharSequence[] labels = context.getResources().getTextArray(
                                com.android.internal.R.array.emailAddressTypes);
                        try {
                            display = labels[type - 1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            display = labels[ContactMethods.TYPE_HOME - 1];
                        }
                    } else {
                        if (!TextUtils.isEmpty(label)) {
                            display = label;
                        }
                    }
                    break;
                }
                case KIND_POSTAL: {
                    if (type != People.ContactMethods.TYPE_CUSTOM) {
                        CharSequence[] labels = context.getResources().getTextArray(
                                com.android.internal.R.array.postalAddressTypes);
                        try {
                            display = labels[type - 1];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            display = labels[ContactMethods.TYPE_HOME - 1];
                        }
                    } else {
                        if (!TextUtils.isEmpty(label)) {
                            display = label;
                        }
                    }
                    break;
                }
                default:
                    display = context.getString(R.string.untitled);
            }
            return display;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "64D6AFA8C969AE169E36B8E60F49300F", hash_generated_method = "DCE76BA656E30FB5CFF4DA20B44DBCC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Deprecated
        public void addPostalLocation(Context context, long postalId,
                double latitude, double longitude) {
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(postalId);
            dsTaint.addTaint(longitude);
            dsTaint.addTaint(latitude);
            final ContentResolver resolver;
            resolver = context.getContentResolver();
            ContentValues values;
            values = new ContentValues(2);
            values.put(POSTAL_LOCATION_LATITUDE, latitude);
            values.put(POSTAL_LOCATION_LONGITUDE, longitude);
            Uri loc;
            loc = resolver.insert(CONTENT_URI, values);
            long locId;
            locId = ContentUris.parseId(loc);
            values.clear();
            values.put(AUX_DATA, locId);
            resolver.update(ContentUris.withAppendedId(CONTENT_URI, postalId), values, null, null);
            // ---------- Original Method ----------
            //final ContentResolver resolver = context.getContentResolver();
            //ContentValues values = new ContentValues(2);
            //values.put(POSTAL_LOCATION_LATITUDE, latitude);
            //values.put(POSTAL_LOCATION_LONGITUDE, longitude);
            //Uri loc = resolver.insert(CONTENT_URI, values);
            //long locId = ContentUris.parseId(loc);
            //values.clear();
            //values.put(AUX_DATA, locId);
            //resolver.update(ContentUris.withAppendedId(CONTENT_URI, postalId), values, null, null);
        }

        
        interface ProviderNames {
            
            
            
            String YAHOO = "Yahoo";
            String GTALK = "GTalk";
            String MSN = "MSN";
            String ICQ = "ICQ";
            String AIM = "AIM";
            String XMPP = "XMPP";
            String JABBER = "JABBER";
            String SKYPE = "SKYPE";
            String QQ = "QQ";
        }
        
    }


    
    public static final class Presence implements BaseColumns, PresenceColumns, PeopleColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/presence");
        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "7EE4E3CCF43EB81D44329F2E3E3F365D", hash_generated_method = "3D7B7310295EF63DE36CEB4B0717CC26")
        @Deprecated
        public static final int getPresenceIconResourceId(int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            switch (status) {
                case Contacts.People.AVAILABLE:
                    return com.android.internal.R.drawable.presence_online;
                case Contacts.People.IDLE:
                case Contacts.People.AWAY:
                    return com.android.internal.R.drawable.presence_away;
                case Contacts.People.DO_NOT_DISTURB:
                    return com.android.internal.R.drawable.presence_busy;
                case Contacts.People.INVISIBLE:
                    return com.android.internal.R.drawable.presence_invisible;
                case Contacts.People.OFFLINE:
                default:
                    return com.android.internal.R.drawable.presence_offline;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "4AA055776FE2314C158C2CC547E29433", hash_generated_method = "13A66009913AD2A58685755F7E6D939B")
        @Deprecated
        public static final void setPresenceIcon(ImageView icon, int serverStatus) {
            icon.setImageResource(getPresenceIconResourceId(serverStatus));
        }

        
    }


    
    public static final class Organizations implements BaseColumns, OrganizationColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/organizations");
        @Deprecated
        public static final String CONTENT_DIRECTORY = "organizations";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "company, title, isprimary ASC";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.118 -0400", hash_original_method = "6B80070A6DD2FB0EB3D1E45B8D1F67CF", hash_generated_method = "C5C88C20EE307141E7CC0D6FA86F0953")
        @DSModeled(DSC.SAFE)
        private Organizations() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "0F2FD9D44DD3D01797BBF65E808710CE", hash_generated_method = "26A7D404DEC02F7963E3CB73E48456F0")
        @Deprecated
        public static final CharSequence getDisplayLabel(Context context, int type,
                CharSequence label) {
            CharSequence display = "";
            if (type != TYPE_CUSTOM) {
                CharSequence[] labels = context.getResources().getTextArray(
                        com.android.internal.R.array.organizationTypes);
                try {
                    display = labels[type - 1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    display = labels[Organizations.TYPE_WORK - 1];
                }
            } else {
                if (!TextUtils.isEmpty(label)) {
                    display = label;
                }
            }
            return display;
        }

        
    }


    
    public static final class Photos implements BaseColumns, PhotosColumns, SyncConstValue {
        @Deprecated
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/photos");
        @Deprecated
        public static final String CONTENT_DIRECTORY = "photo";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person ASC";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "BDD10C58ECCC962A5941D61E3DCCB1CC", hash_generated_method = "8829B40F7E0D6F701E9748B15BD44BFF")
        @DSModeled(DSC.SAFE)
        private Photos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Extensions implements BaseColumns, ExtensionsColumns {
        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/extensions");
        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_extensions";
        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_extensions";
        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person, name ASC";
        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "816E3F3F5D843BF8F23C21E19862654D")
        @DSModeled(DSC.SAFE)
        private Extensions() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Intents {
        @Deprecated
        public static final String SEARCH_SUGGESTION_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CLICKED;
        @Deprecated
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED;
        @Deprecated
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED;
        @Deprecated
        public static final String ATTACH_IMAGE = ContactsContract.Intents.ATTACH_IMAGE;
        @Deprecated
        public static final String SHOW_OR_CREATE_CONTACT =
                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT;
        @Deprecated
        public static final String EXTRA_FORCE_CREATE = ContactsContract.Intents.EXTRA_FORCE_CREATE;
        @Deprecated
        public static final String EXTRA_CREATE_DESCRIPTION =
                ContactsContract.Intents.EXTRA_CREATE_DESCRIPTION;
        @Deprecated
        public static final String EXTRA_TARGET_RECT = ContactsContract.Intents.EXTRA_TARGET_RECT;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "460EB50DD0A9584549D51C7E6E7E37D1")
        @DSModeled(DSC.SAFE)
        @Deprecated
        public Intents() {
            // ---------- Original Method ----------
        }

        
        public static final class UI {
            @Deprecated
            public static final String LIST_DEFAULT = ContactsContract.Intents.UI.LIST_DEFAULT;
            @Deprecated
            public static final String LIST_GROUP_ACTION =
                    ContactsContract.Intents.UI.LIST_GROUP_ACTION;
            @Deprecated
            public static final String GROUP_NAME_EXTRA_KEY =
                    ContactsContract.Intents.UI.GROUP_NAME_EXTRA_KEY;
            @Deprecated
            public static final String LIST_ALL_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.LIST_ALL_CONTACTS_ACTION;
            @Deprecated
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    ContactsContract.Intents.UI.LIST_CONTACTS_WITH_PHONES_ACTION;
            @Deprecated
            public static final String LIST_STARRED_ACTION =
                    ContactsContract.Intents.UI.LIST_STARRED_ACTION;
            @Deprecated
            public static final String LIST_FREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_FREQUENT_ACTION;
            @Deprecated
            public static final String LIST_STREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_STREQUENT_ACTION;
            @Deprecated
            public static final String TITLE_EXTRA_KEY =
                    ContactsContract.Intents.UI.TITLE_EXTRA_KEY;
            @Deprecated
            public static final String FILTER_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.FILTER_CONTACTS_ACTION;
            @Deprecated
            public static final String FILTER_TEXT_EXTRA_KEY =
                    ContactsContract.Intents.UI.FILTER_TEXT_EXTRA_KEY;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "998C7BFCEA8419BCEF695E421ACA0417", hash_generated_method = "4DA5098C3B258B36CCD43036FF66659B")
            @DSModeled(DSC.SAFE)
            @Deprecated
            public UI() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Insert {
            @Deprecated
            public static final String ACTION = ContactsContract.Intents.Insert.ACTION;
            @Deprecated
            public static final String FULL_MODE = ContactsContract.Intents.Insert.FULL_MODE;
            @Deprecated
            public static final String NAME = ContactsContract.Intents.Insert.NAME;
            @Deprecated
            public static final String PHONETIC_NAME =
                    ContactsContract.Intents.Insert.PHONETIC_NAME;
            @Deprecated
            public static final String COMPANY = ContactsContract.Intents.Insert.COMPANY;
            @Deprecated
            public static final String JOB_TITLE = ContactsContract.Intents.Insert.JOB_TITLE;
            @Deprecated
            public static final String NOTES = ContactsContract.Intents.Insert.NOTES;
            @Deprecated
            public static final String PHONE = ContactsContract.Intents.Insert.PHONE;
            @Deprecated
            public static final String PHONE_TYPE = ContactsContract.Intents.Insert.PHONE_TYPE;
            @Deprecated
            public static final String PHONE_ISPRIMARY =
                    ContactsContract.Intents.Insert.PHONE_ISPRIMARY;
            @Deprecated
            public static final String SECONDARY_PHONE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE;
            @Deprecated
            public static final String SECONDARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE;
            @Deprecated
            public static final String TERTIARY_PHONE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE;
            @Deprecated
            public static final String TERTIARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE_TYPE;
            @Deprecated
            public static final String EMAIL = ContactsContract.Intents.Insert.EMAIL;
            @Deprecated
            public static final String EMAIL_TYPE = ContactsContract.Intents.Insert.EMAIL_TYPE;
            @Deprecated
            public static final String EMAIL_ISPRIMARY =
                    ContactsContract.Intents.Insert.EMAIL_ISPRIMARY;
            @Deprecated
            public static final String SECONDARY_EMAIL =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL;
            @Deprecated
            public static final String SECONDARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL_TYPE;
            @Deprecated
            public static final String TERTIARY_EMAIL =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL;
            @Deprecated
            public static final String TERTIARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL_TYPE;
            @Deprecated
            public static final String POSTAL = ContactsContract.Intents.Insert.POSTAL;
            @Deprecated
            public static final String POSTAL_TYPE = ContactsContract.Intents.Insert.POSTAL_TYPE;
            @Deprecated
            public static final String POSTAL_ISPRIMARY = ContactsContract.Intents.Insert.POSTAL_ISPRIMARY;
            @Deprecated
            public static final String IM_HANDLE = ContactsContract.Intents.Insert.IM_HANDLE;
            @Deprecated
            public static final String IM_PROTOCOL = ContactsContract.Intents.Insert.IM_PROTOCOL;
            @Deprecated
            public static final String IM_ISPRIMARY = ContactsContract.Intents.Insert.IM_ISPRIMARY;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.119 -0400", hash_original_method = "B1003A1FA6FEB1932A0DC162C3E36DDF", hash_generated_method = "464A3FFE247186743B00D7DB1E252A2F")
            @DSModeled(DSC.SAFE)
            @Deprecated
            public Insert() {
                // ---------- Original Method ----------
            }

            
        }


        
    }


    
    @Deprecated public interface SettingsColumns {
        
        @Deprecated
        public static final String _SYNC_ACCOUNT = "_sync_account";

        
        @Deprecated
        public static final String _SYNC_ACCOUNT_TYPE = "_sync_account_type";

        
        @Deprecated
        public static final String KEY = "key";

        
        @Deprecated
        public static final String VALUE = "value";
    }
    
    @Deprecated public interface PeopleColumns {
        
        @Deprecated
        public static final String NAME = "name";

        
        @Deprecated
        public static final String PHONETIC_NAME = "phonetic_name";

        
        @Deprecated
        public static final String DISPLAY_NAME = "display_name";

        
        @Deprecated
        public static final String SORT_STRING = "sort_string";

        
        @Deprecated
        public static final String NOTES = "notes";

        
        @Deprecated
        public static final String TIMES_CONTACTED = "times_contacted";

        
        @Deprecated
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";

        
        @Deprecated
        public static final String CUSTOM_RINGTONE = "custom_ringtone";

        
        @Deprecated
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";

        
        @Deprecated
        public static final String STARRED = "starred";

        
        @Deprecated
        public static final String PHOTO_VERSION = "photo_version";
    }
    
    @Deprecated public interface GroupsColumns {
        
        @Deprecated
        public static final String NAME = "name";

        
        @Deprecated
        public static final String NOTES = "notes";

        
        @Deprecated
        public static final String SHOULD_SYNC = "should_sync";

        
        @Deprecated
        public static final String SYSTEM_ID = "system_id";
    }
    
    @Deprecated public interface PhonesColumns {
        
        @Deprecated
        public static final String TYPE = "type";

        
        @Deprecated
        public static final int TYPE_CUSTOM = 0;
        
        @Deprecated
        public static final int TYPE_HOME = 1;
        
        @Deprecated
        public static final int TYPE_MOBILE = 2;
        
        @Deprecated
        public static final int TYPE_WORK = 3;
        
        @Deprecated
        public static final int TYPE_FAX_WORK = 4;
        
        @Deprecated
        public static final int TYPE_FAX_HOME = 5;
        
        @Deprecated
        public static final int TYPE_PAGER = 6;
        
        @Deprecated
        public static final int TYPE_OTHER = 7;

        
        @Deprecated
        public static final String LABEL = "label";

        
        @Deprecated
        public static final String NUMBER = "number";

        
        @Deprecated
        public static final String NUMBER_KEY = "number_key";

        
        @Deprecated
        public static final String ISPRIMARY = "isprimary";
    }
    
    @Deprecated public interface ContactMethodsColumns {
        
        @Deprecated
        public static final String KIND = "kind";

        
        @Deprecated
        public static final String TYPE = "type";
        
        @Deprecated
        public static final int TYPE_CUSTOM = 0;
        
        @Deprecated
        public static final int TYPE_HOME = 1;
        
        @Deprecated
        public static final int TYPE_WORK = 2;
        
        @Deprecated
        public static final int TYPE_OTHER = 3;

        
        @Deprecated
        public static final int MOBILE_EMAIL_TYPE_INDEX = 2;

        
        @Deprecated
        public static final String MOBILE_EMAIL_TYPE_NAME = "_AUTO_CELL";

        
        @Deprecated
        public static final String LABEL = "label";

        
        @Deprecated
        public static final String DATA = "data";

        
        @Deprecated
        public static final String AUX_DATA = "aux_data";

        
        @Deprecated
        public static final String ISPRIMARY = "isprimary";
    }
    
    @Deprecated public interface PresenceColumns {
        
        String PRIORITY = "priority";

        
        String PRESENCE_STATUS = ContactsContract.StatusUpdates.PRESENCE;

        
        int OFFLINE = ContactsContract.StatusUpdates.OFFLINE;
        int INVISIBLE = ContactsContract.StatusUpdates.INVISIBLE;
        int AWAY = ContactsContract.StatusUpdates.AWAY;
        int IDLE = ContactsContract.StatusUpdates.IDLE;
        int DO_NOT_DISTURB = ContactsContract.StatusUpdates.DO_NOT_DISTURB;
        int AVAILABLE = ContactsContract.StatusUpdates.AVAILABLE;

        
        String PRESENCE_CUSTOM_STATUS = ContactsContract.StatusUpdates.STATUS;

        
        @Deprecated
        public static final String IM_PROTOCOL = "im_protocol";

        
        @Deprecated
        public static final String IM_HANDLE = "im_handle";

        
        @Deprecated
        public static final String IM_ACCOUNT = "im_account";
    }
    
    @Deprecated public interface OrganizationColumns {
        
        @Deprecated
        public static final String TYPE = "type";

        
        @Deprecated
        public static final int TYPE_CUSTOM = 0;
        
        @Deprecated
        public static final int TYPE_WORK = 1;
        
        @Deprecated
        public static final int TYPE_OTHER = 2;

        
        @Deprecated
        public static final String LABEL = "label";

        
        @Deprecated
        public static final String COMPANY = "company";

        
        @Deprecated
        public static final String TITLE = "title";

        
        @Deprecated
        public static final String PERSON_ID = "person";

        
        @Deprecated
        public static final String ISPRIMARY = "isprimary";
    }
    
    @Deprecated public interface PhotosColumns {
        
        @Deprecated
        public static final String LOCAL_VERSION = "local_version";

        
        @Deprecated
        public static final String PERSON_ID = "person";

        
        @Deprecated
        public static final String DOWNLOAD_REQUIRED = "download_required";

        
        @Deprecated
        public static final String EXISTS_ON_SERVER = "exists_on_server";

        
        @Deprecated
        public static final String SYNC_ERROR = "sync_error";

        
        @Deprecated
        public static final String DATA = "data";

    }
    
    @Deprecated public interface ExtensionsColumns {
        
        @Deprecated
        public static final String NAME = "name";

        
        @Deprecated
        public static final String VALUE = "value";
    }
    
}


