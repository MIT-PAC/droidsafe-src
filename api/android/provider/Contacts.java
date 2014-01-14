package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;

import com.android.internal.R;

public class Contacts {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.483 -0500", hash_original_field = "BC23690C82568110C6C939C8D483D07C", hash_generated_field = "A7B167268FF1FCDA1ADE660DDE40AF42")

    private static final String TAG = "Contacts";
    
    public static final class Settings implements BaseColumns, SettingsColumns {

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.529 -0500", hash_original_method = "5973496923CC631047F98EE9B88FBD33", hash_generated_method = "7AF81ABDD0AF5532ECED969748843EC8")
        
@Deprecated
        public static String getSetting(ContentResolver cr, String account, String key) {
            // For now we only support a single account and the UI doesn't know what
            // the account name is, so we're using a global setting for SYNC_EVERYTHING.
            // Some day when we add multiple accounts to the UI this should honor the account
            // that was asked for.
            String selectString;
            String[] selectArgs;
            if (false) {
                selectString = (account == null)
                        ? "_sync_account is null AND key=?"
                        : "_sync_account=? AND key=?";
//                : "_sync_account=? AND _sync_account_type=? AND key=?";
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

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSink({DSSinkKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.532 -0500", hash_original_method = "99C82D4214524155DAD3BF65C95C7ABA", hash_generated_method = "3105C1F67670AF6E8D1EF739E653D9F7")
        
@Deprecated
        public static void setSetting(ContentResolver cr, String account, String key,
                String value) {
            ContentValues values = new ContentValues();
            // For now we only support a single account and the UI doesn't know what
            // the account name is, so we're using a global setting for SYNC_EVERYTHING.
            // Some day when we add multiple accounts to the UI this should honor the account
            // that was asked for.
            //values.put(_SYNC_ACCOUNT, account.mName);
            //values.put(_SYNC_ACCOUNT_TYPE, account.mType);
            values.put(KEY, key);
            values.put(VALUE, value);
            cr.update(Settings.CONTENT_URI, values, null, null);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.517 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "9ECB68910875FE88EFDEC7EF6E96167F")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/settings");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.520 -0500", hash_original_field = "B5CB552D68A3A9018981042C74DB6779", hash_generated_field = "9258C12BA7C322E44B0DBA40A422B570")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "settings";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.523 -0500", hash_original_field = "4FFD341AC246C0D22713C10503ECB5F4", hash_generated_field = "C065F04982F6FE33BC6504F9BAFFFC6D")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "key ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.526 -0500", hash_original_field = "45DEF51F4D0E8ED475BBD3D64A3A92EB", hash_generated_field = "64D627A90B551B606915AF039CE1DE3C")

        @Deprecated
        public static final String SYNC_EVERYTHING = "syncEverything";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.514 -0500", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "59B3C6A592AE63BEE2BC1CC1723B36DF")
        
private Settings() {}
    }
    
    public static final class People implements BaseColumns, SyncConstValue, PeopleColumns, PhonesColumns, PresenceColumns {

        /**
         * Mark a person as having been contacted.
         *
         * @param resolver the ContentResolver to use
         * @param personId the person who was contacted
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.583 -0500", hash_original_method = "1F4F3F0FABB4A48916F6AF62043D55D9", hash_generated_method = "337E6C8E38657B615A724219FD4B7A13")
        
@Deprecated
        public static void markAsContacted(ContentResolver resolver, long personId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, personId);
            uri = Uri.withAppendedPath(uri, "update_contact_time");
            ContentValues values = new ContentValues();
            // There is a trigger in place that will update TIMES_CONTACTED when
            // LAST_TIME_CONTACTED is modified.
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        /**
         * @hide Used in vCard parser code.
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.586 -0500", hash_original_method = "3CCBD42AC579830F9F873C0E8E0D59CE", hash_generated_method = "8218AD0872E037DC74692F26BB609A75")
        
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

        /**
         * Adds a person to the My Contacts group.
         *
         * @param resolver the resolver to use
         * @param personId the person to add to the group
         * @return the URI of the group membership row
         * @throws IllegalStateException if the My Contacts group can't be found
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.589 -0500", hash_original_method = "3A5282E15CEE22EBD4B3059F6543301A", hash_generated_method = "A41902CC088B7F31C09F291B7A79AD58")
        
@Deprecated
        public static Uri addToMyContactsGroup(ContentResolver resolver, long personId) {
            long groupId = tryGetMyContactsGroupId(resolver);
            if (groupId == 0) {
                throw new IllegalStateException("Failed to find the My Contacts group");
            }

            return addToGroup(resolver, personId, groupId);
        }

        /**
         * Adds a person to a group referred to by name.
         *
         * @param resolver the resolver to use
         * @param personId the person to add to the group
         * @param groupName the name of the group to add the contact to
         * @return the URI of the group membership row
         * @throws IllegalStateException if the group can't be found
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.592 -0500", hash_original_method = "4B575D0B1951007B3070BB5D97839CB3", hash_generated_method = "98F0ABAF4C6F0C4447D99323EA8403DE")
        
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

        /**
         * Adds a person to a group.
         *
         * @param resolver the resolver to use
         * @param personId the person to add to the group
         * @param groupId the group to add the person to
         * @return the URI of the group membership row
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.595 -0500", hash_original_method = "968792542D44AC477F2A3D6E8EC18199", hash_generated_method = "582ED73B9C814A91D150B866160080F7")
        
@Deprecated
        public static Uri addToGroup(ContentResolver resolver, long personId, long groupId) {
            ContentValues values = new ContentValues();
            values.put(GroupMembership.PERSON_ID, personId);
            values.put(GroupMembership.GROUP_ID, groupId);
            return resolver.insert(GroupMembership.CONTENT_URI, values);
        }

        /**
         * Creates a new contacts and adds it to the "My Contacts" group.
         *
         * @param resolver the ContentResolver to use
         * @param values the values to use when creating the contact
         * @return the URI of the contact, or null if the operation fails
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.600 -0500", hash_original_method = "1719055BB7B83C8257DECB960F96EA3B", hash_generated_method = "057AC4294C52FE0AC14AB3E2D4532546")
        
@Deprecated
        public static Uri createPersonInMyContactsGroup(ContentResolver resolver,
                ContentValues values) {

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

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.603 -0500", hash_original_method = "29F7E3FAB1A70735CD2895CF88304289", hash_generated_method = "1C4B13C4ECAF45161678185D3F4BCF2F")
        
@Deprecated
        public static Cursor queryGroups(ContentResolver resolver, long person) {
            return resolver.query(GroupMembership.CONTENT_URI, null, "person=?",
                    new String[]{String.valueOf(person)}, Groups.DEFAULT_SORT_ORDER);
        }

        /**
         * Set the photo for this person. data may be null
         * @param cr the ContentResolver to use
         * @param person the Uri of the person whose photo is to be updated
         * @param data the byte[] that represents the photo
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSink({DSSinkKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.606 -0500", hash_original_method = "E1EC7DAC113BEA053C3C92256F092BD9", hash_generated_method = "F5021A5E353FD1015A287A10966DEC2B")
        
@Deprecated
        public static void setPhotoData(ContentResolver cr, Uri person, byte[] data) {
            Uri photoUri = Uri.withAppendedPath(person, Contacts.Photos.CONTENT_DIRECTORY);
            ContentValues values = new ContentValues();
            values.put(Photos.DATA, data);
            cr.update(photoUri, values, null, null);
        }

        /**
         * Opens an InputStream for the person's photo and returns the photo as a Bitmap.
         * If the person's photo isn't present returns the placeholderImageResource instead.
         * @param person the person whose photo should be used
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.609 -0500", hash_original_method = "BCA4FB51D104561172D0471430841C22", hash_generated_method = "2A1260E6CCD1B80DCF11F08A821E4B48")
        
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

        /**
         * Opens an InputStream for the person's photo and returns the photo as a Bitmap.
         * If the person's photo isn't present returns the placeholderImageResource instead.
         * @param context the Context
         * @param person the person whose photo should be used
         * @param placeholderImageResource the image resource to use if the person doesn't
         *   have a photo
         * @param options the decoding options, can be set to null
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.612 -0500", hash_original_method = "50F8519255BFC8FA08076C6C60F3293C", hash_generated_method = "256A2A02373F69088619FBBAA5BA9D8B")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.614 -0500", hash_original_method = "0212085D868EA31B6E294335A2EDC932", hash_generated_method = "21672A62600FCDFF8D6D5D2A316B5AF0")
        
private static Bitmap loadPlaceholderPhoto(int placeholderImageResource, Context context,
                BitmapFactory.Options options) {
            if (placeholderImageResource == 0) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(),
                    placeholderImageResource, options);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.552 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "A0006ED5D40B349F632A8DB10A789813")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/people");
        
        public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.621 -0500", hash_original_field = "DCD13422E5AA9D1C547858B3A2EEB0D5", hash_generated_field = "03899653BD7A43165B1BA23AC996EC8A")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "phones";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.624 -0500", hash_original_field = "259167308CB96097F418B2D44F2E9E0D", hash_generated_field = "531395448D0CC5B8081F32EAD4B05B2A")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "number ASC";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.697 -0500", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "CC6CEBA9DCDFB3B56E2148C7707A4E32")
        
private Phones() {}
        }
        
        public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.632 -0500", hash_original_field = "2D259964D5424E85163A2AC197D5B31D", hash_generated_field = "81E2CC782A6DDAF41E6473EED78C8F8B")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "contact_methods";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.635 -0500", hash_original_field = "10C66862383407A1C61427F4FD6B607F", hash_generated_field = "2A6A3242CA201C4CA7E6E3B9B06640F9")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "data ASC";

        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.809 -0500", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "DDCD510819A32FF7BD9558A5CE176D29")
        
private ContactMethods() {}
        }
        
        public static class Extensions implements BaseColumns, ExtensionsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.643 -0500", hash_original_field = "43E33C8D20BA80197F062DEB32B111CE", hash_generated_field = "CDC7C7C6EDE1E66AA7583233A60C794A")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "extensions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.646 -0500", hash_original_field = "B35A3A6BAF22D1C87EA853747BFEE8EF", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "name ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.929 -0500", hash_original_field = "D8F917F1A49DF1BE412728B267C7821E", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.917 -0500", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "627F9C594B5D3368AD9A21A5E43D2CB8")
        
private Extensions() {}
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.554 -0500", hash_original_field = "DFB49FE4A5BA9FC1B5373D88A9D1C8CE", hash_generated_field = "C326E9963D0B0F8829ABDD8D411B753A")

        @Deprecated
        public static final Uri CONTENT_FILTER_URI =
            Uri.parse("content://contacts/people/filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.557 -0500", hash_original_field = "50BAB06D2D2C90CF30610CFADBE94F69", hash_generated_field = "59039863AF0EA2D46DBAB64A9D80DDE2")

        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_people");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.560 -0500", hash_original_field = "B67F46FC7414770B37609C6A83DCE4D4", hash_generated_field = "585F41258E719DBA310CDE449E0AC433")

        @Deprecated
        public static final Uri WITH_EMAIL_OR_IM_FILTER_URI =
            Uri.parse("content://contacts/people/with_email_or_im_filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.563 -0500", hash_original_field = "CB890B25CDEF0E7995A8CC6C1A7BE6F5", hash_generated_field = "8DEB59CC7A7E46DEB194AFC58F311217")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/person";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.566 -0500", hash_original_field = "E4AF63DC3DB36576CD091DC4D1B1F3DA", hash_generated_field = "3209195D73C6562DA3DC16072766F893")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/person";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.568 -0500", hash_original_field = "412C59845FDAA67A0327F7AB69D8F047", hash_generated_field = "B2240268B9111906821A235B6ACEEA7A")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = People.NAME + " ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.571 -0500", hash_original_field = "70A43DD3693DF36AF7EA86B9BA518DA8", hash_generated_field = "774CF16EB3DEA62FEED14349A9DCF233")

        @Deprecated
        public static final String PRIMARY_PHONE_ID = "primary_phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.573 -0500", hash_original_field = "05E00770BABEC8F9C7965AB08B703DB9", hash_generated_field = "78EEE4364584BB341AE4BBE294388B9F")

        @Deprecated
        public static final String PRIMARY_EMAIL_ID = "primary_email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.576 -0500", hash_original_field = "09D17FE95052B10F2B74CE0516850676", hash_generated_field = "A34816071C276225A0D70A64143E80A1")

        @Deprecated
        public static final String PRIMARY_ORGANIZATION_ID = "primary_organization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.598 -0500", hash_original_field = "D8603C42D21B86F67193094503EACCF5", hash_generated_field = "E5BEDAC320AE20FE752EE3B126329BE3")

        private static final String[] GROUPS_PROJECTION = new String[] {
            Groups._ID,
        };
        /**
         * no public constructor since this is a utility class
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.548 -0500", hash_original_method = "17F062BF4D2F442415926444A39FDFDD", hash_generated_method = "6F1590C8847D50A735421102F36289E2")
        
private People() {}
    }
    
    public static final class Groups implements BaseColumns, SyncConstValue, GroupsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.666 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "23A9691CB89BBA676305D424A759F3A9")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groups");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.668 -0500", hash_original_field = "50BAB06D2D2C90CF30610CFADBE94F69", hash_generated_field = "FD40B474FE8C1E22A27B306A23E14123")

        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_groups");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.671 -0500", hash_original_field = "976D629413B7DFF89C46D26A876EC74E", hash_generated_field = "D763B222A94439FC4F07267581C3DEC8")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.674 -0500", hash_original_field = "0E86A3451608A41D23856909C4891729", hash_generated_field = "5653DB5716D31CC3C3E3D90E598D50E4")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.677 -0500", hash_original_field = "F9F35B304FE38B40ABED13E6FA6073B0", hash_generated_field = "F9636372D0FD14C0236E36C561539D4B")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = NAME + " ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.680 -0500", hash_original_field = "EC406A981BF4AE720C8ABEC038D95125", hash_generated_field = "B2DEA429FB24C35B6649D7E9623AD778")

        @Deprecated
        public static final String GROUP_ANDROID_STARRED = "Starred in Android";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.683 -0500", hash_original_field = "25A8E7DC94F368DA550A7FDB3749FB88", hash_generated_field = "66111B481D00B5BD07048DB53DE0D6A2")

        @Deprecated
        public static final String GROUP_MY_CONTACTS = "Contacts";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.663 -0500", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "3D1B22AE31FE9AB2658DC3713C91A6C9")
        
private Groups() {}
    }
    
    public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.700 -0500", hash_original_method = "47C658D10C7FF6AFCE9B91D6C434ADDC", hash_generated_method = "27BB02CE86DEC990C9D56E4E3086F939")
        
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

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.703 -0500", hash_original_method = "4BFBBB1A99B20F000C01E55DF4773309", hash_generated_method = "83A79B941A8054E2F7C92228A01B766E")
        
@Deprecated
        public static final CharSequence getDisplayLabel(Context context, int type,
                CharSequence label) {
            return getDisplayLabel(context, type, label, null);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.706 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "C808A0DE273DF067AF275761C7FA0777")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/phones");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.709 -0500", hash_original_field = "FD045A8E7FDF1C9E94566AEACD6E0169", hash_generated_field = "CE4CBA65EABC23B095A1080F3A1FF1E2")

        @Deprecated
        public static final Uri CONTENT_FILTER_URL =
            Uri.parse("content://contacts/phones/filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.711 -0500", hash_original_field = "445A4E91BF4294A2793D94F048BB8EF7", hash_generated_field = "6AE3D9221905D0724D6FEEC635C6F81A")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.714 -0500", hash_original_field = "E5D549B00745BD7C4E32FA0E9A206397", hash_generated_field = "4D8B917148194561CC7042E5B444A946")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.716 -0500", hash_original_field = "B35A3A6BAF22D1C87EA853747BFEE8EF", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.719 -0500", hash_original_field = "D8F917F1A49DF1BE412728B267C7821E", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.192 -0400", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "E3DEAC6FD2C25762C8DA6828EC61294E")
        private  Phones() {
            // ---------- Original Method ----------
        }
    }
    
    public static final class GroupMembership implements BaseColumns, GroupsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.728 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "6B56E2959B81E3675B2CD31121EA2F41")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groupmembership");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.731 -0500", hash_original_field = "4C4811D0EFCCE67C434B8AD48E38B658", hash_generated_field = "2AC0D6133CFB1443EE0F7AEC7FE4F1E4")

        @Deprecated
        public static final Uri RAW_CONTENT_URI =
            Uri.parse("content://contacts/groupmembershipraw");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.733 -0500", hash_original_field = "5B0DFD72CE220FFBAFBC38ADB6FDDFA2", hash_generated_field = "CB59E6C939320DA30C9A4A05DD9E626E")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "groupmembership";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.736 -0500", hash_original_field = "F98EC042C285FFA4E5BDB4E3CB69B02F", hash_generated_field = "8AFFFFBCFB7AE41C6821C119992BB1EC")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroupmembership";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.739 -0500", hash_original_field = "A02025C0C76C644C18DBE707F54CDD50", hash_generated_field = "737A88A46CF31760D6A1020C824AF9EA")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contactsgroupmembership";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.741 -0500", hash_original_field = "FB0156AE89BE6E8A8FD3BD110D57FB77", hash_generated_field = "948D867DAB91EEC09F9A33836AF33379")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "group_id ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.744 -0500", hash_original_field = "F56A5CBCA5EB0898FBEF8EF7A5EB6244", hash_generated_field = "F2516A35ABCD3A17755816388898E4A2")

        @Deprecated
        public static final String GROUP_ID = "group_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.747 -0500", hash_original_field = "C3604BBA3234F81DE5C599E998BD5A39", hash_generated_field = "F9ED79409C01A8DC8B204294EB7B555B")

        @Deprecated
        public static final String GROUP_SYNC_ID = "group_sync_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.749 -0500", hash_original_field = "73250459B6FCADF65E36521A16C6A715", hash_generated_field = "1B52CA84105F082C35EC026A02DA67AB")

        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT = "group_sync_account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.753 -0500", hash_original_field = "4BCAEF0709597FF4CF72034E4D3610C5", hash_generated_field = "8C84F85941183FE16D9989182709A59A")

        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT_TYPE = "group_sync_account_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.755 -0500", hash_original_field = "D8F917F1A49DF1BE412728B267C7821E", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.726 -0500", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "CD57B10B47E4384F9C72F867F5045C16")
        
private GroupMembership() {}
    }
    
    public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.796 -0500", hash_original_method = "20EDB941242725D8BA303E2B860FE539", hash_generated_method = "CCE123AF9C0FCAD4502254BE643632CE")
        
@Deprecated
        public static String encodePredefinedImProtocol(int protocol) {
            return "pre:" + protocol;
        }

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.799 -0500", hash_original_method = "8BC78B797CC232A68DBC3E50049E83C3", hash_generated_method = "720DFE2B20CC6F16C9104872CE4EA60C")
        
@Deprecated
        public static String encodeCustomImProtocol(String protocolString) {
            return "custom:" + protocolString;
        }

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.801 -0500", hash_original_method = "D65E9D02F8AECAEE3697B543ED9D1C0D", hash_generated_method = "02BFBAC1B60115184B80578DDB31F69B")
        
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

        /**
         * This looks up the provider name defined in
         * from the predefined IM protocol id.
         * This is used for interacting with the IM application.
         *
         * @param protocol the protocol ID
         * @return the provider name the IM app uses for the given protocol, or null if no
         * provider is defined for the given protocol
         * @deprecated see {@link android.provider.ContactsContract}
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.807 -0500", hash_original_method = "71E6FB134E3F8929FE201B0D15431D0F", hash_generated_method = "3E798F46F6654ECB3DE3CF8AC41C1333")
        
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

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.813 -0500", hash_original_method = "E53FDAD74C5D20D2E7D8CB826DDE0DF9", hash_generated_method = "273F9BDCB1E873F32D2A6734B118D960")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.770 -0500", hash_original_field = "44C9A95DC252C764B53D7A33D22C92FF", hash_generated_field = "378391ED9BFF3D96FBC9F39F0B5D2048")

        @Deprecated
        public static final String POSTAL_LOCATION_LATITUDE = DATA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.773 -0500", hash_original_field = "0E26E234AB6BF147E54B9CDC224602FA", hash_generated_field = "D30B8862F4C7D043F6642AEE7CA4F428")

        @Deprecated
        public static final String POSTAL_LOCATION_LONGITUDE = AUX_DATA;
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.775 -0500", hash_original_field = "79B2B9CAAEAA134E05FDD247D583ADD4", hash_generated_field = "224045813CAB992845F74B167604361E")

        @Deprecated
        public static final int PROTOCOL_AIM = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.778 -0500", hash_original_field = "330C863744DA00915C180579F6A490BE", hash_generated_field = "F295A47D26C6CE71BE9A2FEFAC56708A")

        @Deprecated
        public static final int PROTOCOL_MSN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.780 -0500", hash_original_field = "3D3325C7611522397E8696F42E9755A3", hash_generated_field = "904E5A5ED5954215B78008CFF2A2C834")

        @Deprecated
        public static final int PROTOCOL_YAHOO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.783 -0500", hash_original_field = "2F2E331429DBF1C59E1B562B1E5E5571", hash_generated_field = "01FC769F186261B809109926E1C49B63")

        @Deprecated
        public static final int PROTOCOL_SKYPE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.786 -0500", hash_original_field = "2566A8E0647B70A3D130F749FFDF6564", hash_generated_field = "C00865D362C57785B9E4A85385266ED0")

        @Deprecated
        public static final int PROTOCOL_QQ = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.788 -0500", hash_original_field = "B11CFBF8636DCCCBEBC9147CD967976A", hash_generated_field = "1C975BA0DCF8D550112F55B5320C16D1")

        @Deprecated
        public static final int PROTOCOL_GOOGLE_TALK = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.791 -0500", hash_original_field = "57F36706B23CA069E871CB39520ECC14", hash_generated_field = "03A393EBA72855EE647CC3912C24BCF8")

        @Deprecated
        public static final int PROTOCOL_ICQ = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.794 -0500", hash_original_field = "F06DD118F43BEC1F3B9FF73DF38B3885", hash_generated_field = "C78F2B7B59A8155908CDE45BA5974FD5")

        @Deprecated
        public static final int PROTOCOL_JABBER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.819 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "341E3D2AEB380AE600A4AE839E324D33")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/contact_methods");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.821 -0500", hash_original_field = "15F192F8691AF0568687008F59DB60CC", hash_generated_field = "5D6DED4244C2C9DD44EA88EF4DEC1F33")

        @Deprecated
        public static final Uri CONTENT_EMAIL_URI =
            Uri.parse("content://contacts/contact_methods/email");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.824 -0500", hash_original_field = "041915029C0585119AADF6380BE1B14A", hash_generated_field = "7B25134746B8D1E7CE6DE8E4E6D262A8")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact-methods";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.827 -0500", hash_original_field = "11050A7EABE2DD49238C22B20E8FEC67", hash_generated_field = "EF8853A8E61B4C35F2A9895275F51AF3")

        @Deprecated
        public static final String CONTENT_EMAIL_TYPE = "vnd.android.cursor.dir/email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.830 -0500", hash_original_field = "68E9566E02793748ECE8454B7E31C6AA", hash_generated_field = "DDA96C1B11A33A9329C9492E498AE32B")

        @Deprecated
        public static final String CONTENT_POSTAL_TYPE = "vnd.android.cursor.dir/postal-address";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.833 -0500", hash_original_field = "88ED16CD17B5F9BE920206E007E2F36A", hash_generated_field = "3941B227662D80A9F0FAE27C32769090")

        @Deprecated
        public static final String CONTENT_EMAIL_ITEM_TYPE = "vnd.android.cursor.item/email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.835 -0500", hash_original_field = "631CC7942445B433B47029CADE372748", hash_generated_field = "DEBE4299E99A74D8ECDC8777F803946D")

        @Deprecated
        public static final String CONTENT_POSTAL_ITEM_TYPE
                = "vnd.android.cursor.item/postal-address";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.838 -0500", hash_original_field = "A939FBF46030D8B4004D7526AC9BEBA4", hash_generated_field = "C74FE4E8AFE0661EF9BC80B5C5DEDE83")

        @Deprecated
        public static final String CONTENT_IM_ITEM_TYPE = "vnd.android.cursor.item/jabber-im";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.841 -0500", hash_original_field = "B35A3A6BAF22D1C87EA853747BFEE8EF", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.843 -0500", hash_original_field = "D8F917F1A49DF1BE412728B267C7821E", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.193 -0400", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "D063488DC4FB276BA82857C6DD5F45E0")
        private  ContactMethods() {
            // ---------- Original Method ----------
        }

        /**
         * Add a longitude and latitude location to a postal address.
         *
         * @param context the context to use when updating the database
         * @param postalId the address to update
         * @param latitude the latitude for the address
         * @param longitude the longitude for the address
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSink({DSSinkKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.816 -0500", hash_original_method = "64D6AFA8C969AE169E36B8E60F49300F", hash_generated_method = "E8827757AFCAECC6C86DA304122A27FD")
        
@Deprecated
        public void addPostalLocation(Context context, long postalId,
                double latitude, double longitude) {
            final ContentResolver resolver = context.getContentResolver();
            // Insert the location
            ContentValues values = new ContentValues(2);
            values.put(POSTAL_LOCATION_LATITUDE, latitude);
            values.put(POSTAL_LOCATION_LONGITUDE, longitude);
            Uri loc = resolver.insert(CONTENT_URI, values);
            long locId = ContentUris.parseId(loc);

            // Update the postal address
            values.clear();
            values.put(AUX_DATA, locId);
            resolver.update(ContentUris.withAppendedId(CONTENT_URI, postalId), values, null, null);
        }
    }
    
    public static final class Presence implements BaseColumns, PresenceColumns, PeopleColumns {

        /**
         * Gets the resource ID for the proper presence icon.
         *
         * @param status the status to get the icon for
         * @return the resource ID for the proper presence icon
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.861 -0500", hash_original_method = "7EE4E3CCF43EB81D44329F2E3E3F365D", hash_generated_method = "63A230CC2ECAB896E16F1700BD94592F")
        
@Deprecated
        public static final int getPresenceIconResourceId(int status) {
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

        /**
         * Sets a presence icon to the proper graphic
         *
         * @param icon the icon to to set
         * @param serverStatus that status
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.864 -0500", hash_original_method = "4AA055776FE2314C158C2CC547E29433", hash_generated_method = "13A66009913AD2A58685755F7E6D939B")
        
@Deprecated
        public static final void setPresenceIcon(ImageView icon, int serverStatus) {
            icon.setImageResource(getPresenceIconResourceId(serverStatus));
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.855 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "B87AB588725DCC682EE6059AE3916563")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/presence");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.858 -0500", hash_original_field = "D8F917F1A49DF1BE412728B267C7821E", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.194 -0400", hash_original_method = "FECDF62B9774A3653EF2E5C629F7A49B", hash_generated_method = "FECDF62B9774A3653EF2E5C629F7A49B")
        public Presence ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Organizations implements BaseColumns, OrganizationColumns {

        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.880 -0500", hash_original_method = "0F2FD9D44DD3D01797BBF65E808710CE", hash_generated_method = "26A7D404DEC02F7963E3CB73E48456F0")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.883 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "AF84B2628553B146851696DE7E47839F")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/organizations");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.886 -0500", hash_original_field = "7FED476E56871E94C872C391DDF6A8AA", hash_generated_field = "B488E16BB78D66FC9F705C632EB4E771")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "organizations";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.888 -0500", hash_original_field = "AA37A555E7A5C160884FA269339104F7", hash_generated_field = "9D5369E329C8FFC02D3BD245FEA6F1DA")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "company, title, isprimary ASC";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.877 -0500", hash_original_method = "6B80070A6DD2FB0EB3D1E45B8D1F67CF", hash_generated_method = "2A1ECFC7445D74F90AF7029089D02160")
        
private Organizations() {}
    }
    
    public static final class Photos implements BaseColumns, PhotosColumns, SyncConstValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.903 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "1E6F62FC0740C6E1E47B36F2927E14A2")

        @Deprecated
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/photos");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.905 -0500", hash_original_field = "FE3767F034EDE64D3E36F26FDB2DD64E", hash_generated_field = "425C2A44796EA555DC9BE042C8042CE2")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "photo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.908 -0500", hash_original_field = "C3E22DF116F55ABE19452A9D1B8DDDE3", hash_generated_field = "4FFBF8322F924DDF3D93A9BEBBB16892")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person ASC";
        /**
         * no public constructor since this is a utility class
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.900 -0500", hash_original_method = "BDD10C58ECCC962A5941D61E3DCCB1CC", hash_generated_method = "CC96DF6BBA141BCD4483A4EED9B38592")
        
private Photos() {}
    }
    
    public static final class Extensions implements BaseColumns, ExtensionsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.919 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "1BA09A34C7792B6178C2A245D81010D1")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/extensions");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.922 -0500", hash_original_field = "F720C2C43C16511473DE314327D4460E", hash_generated_field = "1D2597714764A6635E4A746A115A8652")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_extensions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.924 -0500", hash_original_field = "0327120D6CC3D21455376ED7C61128CA", hash_generated_field = "33709222718038E2EEFBC6AC45B8B9D8")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_extensions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.927 -0500", hash_original_field = "610CB985BB1EADBBF939FAE003AA9EAD", hash_generated_field = "F909140799CA99848FEE6738B33DCAC2")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person, name ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.195 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:29.195 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "2F76D83BC2CB495AB0D58C050F1DA969")
        private  Extensions() {
            // ---------- Original Method ----------
        }
    }
    
    public static final class Intents {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.937 -0500", hash_original_field = "33CFDB338A6D1AB5FC4A11EE40CF181B", hash_generated_field = "04E12F2FF0507DD0A5D05C6AF1ED87B7")

        @Deprecated
        public static final String SEARCH_SUGGESTION_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CLICKED;
        
        public static final class UI {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.964 -0500", hash_original_field = "14AD1BF563D94345932A65D730FD14F0", hash_generated_field = "EC442A7E3DA716150058E48B0D4F24F0")

            @Deprecated
            public static final String LIST_DEFAULT = ContactsContract.Intents.UI.LIST_DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.966 -0500", hash_original_field = "AB10B948DBB4F55132385812FBC2CAB0", hash_generated_field = "BDF813696078116587679D09245279B4")

            @Deprecated
            public static final String LIST_GROUP_ACTION =
                    ContactsContract.Intents.UI.LIST_GROUP_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.969 -0500", hash_original_field = "BA260E5B961DACDA4B71ADA33F5FEAEA", hash_generated_field = "1F1FC102CEF7150E68743BFF41E24C78")

            @Deprecated
            public static final String GROUP_NAME_EXTRA_KEY =
                    ContactsContract.Intents.UI.GROUP_NAME_EXTRA_KEY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.971 -0500", hash_original_field = "D4DC999402A959A28925A1120F8D8E35", hash_generated_field = "E691E1CC8B3E57A064A6FA42B618984D")

            @Deprecated
            public static final String LIST_ALL_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.LIST_ALL_CONTACTS_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.976 -0500", hash_original_field = "40127C29A4F44EC5ADAD6C71F6491D72", hash_generated_field = "A7D94D347849807CD276933AA02F6F3E")

            @Deprecated
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    ContactsContract.Intents.UI.LIST_CONTACTS_WITH_PHONES_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.978 -0500", hash_original_field = "6D5004F1A026543F9D73F0B0642B6467", hash_generated_field = "DC8009999163F97529CC2B439248161C")

            @Deprecated
            public static final String LIST_STARRED_ACTION =
                    ContactsContract.Intents.UI.LIST_STARRED_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.981 -0500", hash_original_field = "8FA4EBA837001BECD5FE7527739A7B2B", hash_generated_field = "92B5139D5E071594E3502CDD6909B726")

            @Deprecated
            public static final String LIST_FREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_FREQUENT_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.984 -0500", hash_original_field = "A6142C20BE725F2A6DE555068E6F77EA", hash_generated_field = "3DA9C1003D058FCB91F29E0E5457A60D")

            @Deprecated
            public static final String LIST_STREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_STREQUENT_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.987 -0500", hash_original_field = "45C70906CFE3468D73466D549A83EBF9", hash_generated_field = "5A669F0D1F8CB8ADB7C369D459D1097F")

            @Deprecated
            public static final String TITLE_EXTRA_KEY =
                    ContactsContract.Intents.UI.TITLE_EXTRA_KEY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.989 -0500", hash_original_field = "BBD00B0B9F1F5E276C8A43410AA9831E", hash_generated_field = "C2DAD90DF64A4A1E19978334DF2802EA")

            @Deprecated
            public static final String FILTER_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.FILTER_CONTACTS_ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.992 -0500", hash_original_field = "D834F3DC85593F5302720486C3205736", hash_generated_field = "DAC03B28D6C88649F5DED50540B6664D")

            @Deprecated
            public static final String FILTER_TEXT_EXTRA_KEY =
                    ContactsContract.Intents.UI.FILTER_TEXT_EXTRA_KEY;
            /**
             * @deprecated see {@link android.provider.ContactsContract}
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.961 -0500", hash_original_method = "998C7BFCEA8419BCEF695E421ACA0417", hash_generated_method = "3F4F6D30B2B30561ABE2BF8F1FBA4719")
            
@Deprecated
            public UI() {
            }
        }
        
        public static final class Insert {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.002 -0500", hash_original_field = "CE94026F103DDD2DCBDC4D71CB4287FF", hash_generated_field = "BC69E830B187181CA8FDFC1C9BCEE680")

            @Deprecated
            public static final String ACTION = ContactsContract.Intents.Insert.ACTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.005 -0500", hash_original_field = "DE30A329155756CE36E6BD647234431E", hash_generated_field = "DB529DBCBD1DD0C3FFAF96510DDB0814")

            @Deprecated
            public static final String FULL_MODE = ContactsContract.Intents.Insert.FULL_MODE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.008 -0500", hash_original_field = "DC834685A04F62E61436F0AC0C037300", hash_generated_field = "EA6CAA5EA1BF7C67B616C2888E688578")

            @Deprecated
            public static final String NAME = ContactsContract.Intents.Insert.NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.011 -0500", hash_original_field = "0C0E9F63C17D8D81AFAA66276522B5BE", hash_generated_field = "5D15C2F2364EE1C701F37B470007B5F9")

            @Deprecated
            public static final String PHONETIC_NAME =
                    ContactsContract.Intents.Insert.PHONETIC_NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.014 -0500", hash_original_field = "AA32EFE1E5D66E460EAF64E3D44CF4E9", hash_generated_field = "C70CCA753DA54DF204B1BE213C543B94")

            @Deprecated
            public static final String COMPANY = ContactsContract.Intents.Insert.COMPANY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.016 -0500", hash_original_field = "30BF1F2C0A9E27FCC71EB3623574B0A8", hash_generated_field = "CFF99ECFFD934CC41EF209DEFB02FE8E")

            @Deprecated
            public static final String JOB_TITLE = ContactsContract.Intents.Insert.JOB_TITLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.019 -0500", hash_original_field = "95D33B95F806AC7CE4412CC36E2DA34E", hash_generated_field = "247EE8F8222F6465F0179301A8B0D4A5")

            @Deprecated
            public static final String NOTES = ContactsContract.Intents.Insert.NOTES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.023 -0500", hash_original_field = "486B7BB4070A6F5830C7EA5589015399", hash_generated_field = "FAE092BD399869ED3D4FDB0BE35368EB")

            @Deprecated
            public static final String PHONE = ContactsContract.Intents.Insert.PHONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.025 -0500", hash_original_field = "09CCCB953F5160666F12C4ABFB3E4720", hash_generated_field = "FBCE5453A6EEFB7FAEBD14D43C5CF21A")

            @Deprecated
            public static final String PHONE_TYPE = ContactsContract.Intents.Insert.PHONE_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.028 -0500", hash_original_field = "2717338C925EAF944C91CD150CD27B9F", hash_generated_field = "24A2D166955D62D89677FC5DA832CCAD")

            @Deprecated
            public static final String PHONE_ISPRIMARY =
                    ContactsContract.Intents.Insert.PHONE_ISPRIMARY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.031 -0500", hash_original_field = "B1F2B6CB49CC3A54C4D0CB5C6B456F97", hash_generated_field = "AA4B0EB5D35A3F830330A46612D49514")

            @Deprecated
            public static final String SECONDARY_PHONE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.034 -0500", hash_original_field = "84829D02F4BF32527F6731B9A31B1B8A", hash_generated_field = "B54EAF6A54D892A9304AFF237C419CF4")

            @Deprecated
            public static final String SECONDARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.037 -0500", hash_original_field = "1DC2BD473730344B45601ECAE7378029", hash_generated_field = "37A565C6E17D9BE70B6343B2857483A3")

            @Deprecated
            public static final String TERTIARY_PHONE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.039 -0500", hash_original_field = "DBDEFDE3851020BACBA3AD22A2692C37", hash_generated_field = "8ED8290890EB64CE4F3E3BFC1E04CBC4")

            @Deprecated
            public static final String TERTIARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.042 -0500", hash_original_field = "ABCC09CD2ACCACB6A31FA02D6F091369", hash_generated_field = "1BCAEE4EC0E12CC6F8E5188CA7658001")

            @Deprecated
            public static final String EMAIL = ContactsContract.Intents.Insert.EMAIL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.045 -0500", hash_original_field = "A058795F4922D2CC1A3B85234B846438", hash_generated_field = "4B1311BF6D37BF70571127FB407CC45B")

            @Deprecated
            public static final String EMAIL_TYPE = ContactsContract.Intents.Insert.EMAIL_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.048 -0500", hash_original_field = "933E0461EAE16314527200E9A201E858", hash_generated_field = "84EEA545B6B5EF0FE17C3ABE6EA890AB")

            @Deprecated
            public static final String EMAIL_ISPRIMARY =
                    ContactsContract.Intents.Insert.EMAIL_ISPRIMARY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.052 -0500", hash_original_field = "483918170FECBA635C2A08943378EBC6", hash_generated_field = "679481EF13AE69B616C49507210D8B1F")

            @Deprecated
            public static final String SECONDARY_EMAIL =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.055 -0500", hash_original_field = "8C8B2358D8DCE5695ECE813B0B8638B5", hash_generated_field = "D148791F0A4C2AF4FCDB430CD310968D")

            @Deprecated
            public static final String SECONDARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.057 -0500", hash_original_field = "7B4E306EA71C45484DF99AF341F8BD73", hash_generated_field = "4E407CC17D412E259962C699065AAC86")

            @Deprecated
            public static final String TERTIARY_EMAIL =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.060 -0500", hash_original_field = "998647AE0B0FDE6EED10A1E4D78212B4", hash_generated_field = "900B18130ABA0EBE3AC4A78085683B42")

            @Deprecated
            public static final String TERTIARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.062 -0500", hash_original_field = "48468F094FC08706FD7A8E6CB1B0130B", hash_generated_field = "B7C46C1E7C0D10329CB09F1FA53AD551")

            @Deprecated
            public static final String POSTAL = ContactsContract.Intents.Insert.POSTAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.066 -0500", hash_original_field = "4CF6D6473102865E1004E59E4420B480", hash_generated_field = "3DCBDE69B6B6EF226C029B620DBA771B")

            @Deprecated
            public static final String POSTAL_TYPE = ContactsContract.Intents.Insert.POSTAL_TYPE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.069 -0500", hash_original_field = "21FA84DF4DBE8039CA9D0DA07B053032", hash_generated_field = "5FA1CE6EA1FE1916AEE1200F8F482D6D")

            @Deprecated
            public static final String POSTAL_ISPRIMARY = ContactsContract.Intents.Insert.POSTAL_ISPRIMARY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.071 -0500", hash_original_field = "E4735330367DA9DBCE04EF3D6A4CDC5E", hash_generated_field = "03FF81C80810881D6080CA9BEB9CBFBF")

            @Deprecated
            public static final String IM_HANDLE = ContactsContract.Intents.Insert.IM_HANDLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.074 -0500", hash_original_field = "2524C48EBC7F58A79DC6E1B83362BEAB", hash_generated_field = "BBBC1E2615A7C3E9DC3F0C525911E4D9")

            @Deprecated
            public static final String IM_PROTOCOL = ContactsContract.Intents.Insert.IM_PROTOCOL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:00.077 -0500", hash_original_field = "F204CD3DC89EFBA9752387521860F54A", hash_generated_field = "BB40CC005EDFA31C3F9210DB144DC44E")

            @Deprecated
            public static final String IM_ISPRIMARY = ContactsContract.Intents.Insert.IM_ISPRIMARY;
            /**
             * @deprecated see {@link android.provider.ContactsContract}
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.999 -0500", hash_original_method = "B1003A1FA6FEB1932A0DC162C3E36DDF", hash_generated_method = "E8C8BD9ACDC3EA0449D793FD195D9C41")
            
@Deprecated
            public Insert() {
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.940 -0500", hash_original_field = "6FBB385098E8B6764E4F44DDFE1F55D0", hash_generated_field = "9BD1766D25ABC5072D61E9C95A360AE6")

        @Deprecated
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.943 -0500", hash_original_field = "B9CCFC7507280E14911001C4E75BA2D2", hash_generated_field = "0AA0DD6BCE12FBD53A2753FF6F9ED4B7")

        @Deprecated
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.945 -0500", hash_original_field = "23D2679F2DF8B62252E9D30A9DE6D22D", hash_generated_field = "812715B154C0CFAC45E69DCBFFDB9301")

        @Deprecated
        public static final String ATTACH_IMAGE = ContactsContract.Intents.ATTACH_IMAGE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.949 -0500", hash_original_field = "A67C3C2AE9972FAF675154C1B0C019BF", hash_generated_field = "8E6BC080C0AC22BDCF8899AB7191ADD7")

        @Deprecated
        public static final String SHOW_OR_CREATE_CONTACT =
                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.952 -0500", hash_original_field = "5B018129CE9ACAAE60D7E45299C92233", hash_generated_field = "5B0F2CE372610A9CF8A76AC9E5E0E39E")

        @Deprecated
        public static final String EXTRA_FORCE_CREATE = ContactsContract.Intents.EXTRA_FORCE_CREATE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.954 -0500", hash_original_field = "08E4E76A10FFC51082C657708FEB218C", hash_generated_field = "CDA31384B06E8FFA18AAE152D997454D")

        @Deprecated
        public static final String EXTRA_CREATE_DESCRIPTION =
                ContactsContract.Intents.EXTRA_CREATE_DESCRIPTION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.957 -0500", hash_original_field = "8F2B3EC3E59B92731550DAAACD239F4C", hash_generated_field = "A6938FC5975623C7C234562BD57BF569")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = ContactsContract.Intents.EXTRA_TARGET_RECT;
        /**
         * @deprecated see {@link android.provider.ContactsContract}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.935 -0500", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "B37546EBBF8A5FDAC2AD283667E9B99B")
        
@Deprecated
        public Intents() {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.486 -0500", hash_original_field = "49D9571C7B3DDD710D6334FB0F8827C8", hash_generated_field = "B258124744B00E4365C658238E7725AC")

    @Deprecated
    public static final String AUTHORITY = "contacts";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.488 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "401ACB505704719ECABC29479D6743C9")

    @Deprecated
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.491 -0500", hash_original_field = "A56E58EFD45921EA502AFE0725255AFA", hash_generated_field = "224169F58667E9B90C215571040939E6")

    @Deprecated
    public static final int KIND_EMAIL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.494 -0500", hash_original_field = "4CF00E5D2085E3A5900EC6D49A0D2ECD", hash_generated_field = "51D60E671C997C144AE6EF6E3A6E83E3")

    @Deprecated
    public static final int KIND_POSTAL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.497 -0500", hash_original_field = "FEE898F9493DCA07952F5DE5CA04B9FC", hash_generated_field = "78EB8F522B27ADBF312B31AC99406902")

    @Deprecated
    public static final int KIND_IM = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.499 -0500", hash_original_field = "5D1738AC3564674E74F5B9BB01514CCD", hash_generated_field = "B6B0F9C94DDBD96F4C3CCC1B5649D3E0")

    @Deprecated
    public static final int KIND_ORGANIZATION = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.502 -0500", hash_original_field = "84530E932B10345138A9D8C07FF945CF", hash_generated_field = "B9F3672C79000CC77B081E5611B58E69")

    @Deprecated
    public static final int KIND_PHONE = 5;

    /**
     * no public constructor since this is a utility class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.504 -0500", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "47D4A76F75042B03A266F16D90E98429")
    
private Contacts() {}
}

