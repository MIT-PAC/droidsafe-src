package android.provider;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.083 -0400", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "EBAB9AC2EF768DD752DA8373D9E74008")
    private  Contacts() {
        
    }

    
    public static final class Settings implements BaseColumns, SettingsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.084 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "2C16D3C86A761A9DF5E58231442F813C")
        private  Settings() {
            
        }

        
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

        
                @Deprecated
        public static void setSetting(ContentResolver cr, String account, String key,
                String value) {
            ContentValues values = new ContentValues();
            values.put(KEY, key);
            values.put(VALUE, value);
            cr.update(Settings.CONTENT_URI, values, null, null);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.085 -0400", hash_original_field = "07DEC8A596847B8E70E6B89DCD3374FC", hash_generated_field = "9ECB68910875FE88EFDEC7EF6E96167F")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/settings");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.085 -0400", hash_original_field = "C8973570F6B21001A3614ADC6BB5D529", hash_generated_field = "9258C12BA7C322E44B0DBA40A422B570")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "settings";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.085 -0400", hash_original_field = "4D2A8BBC64EA7C9EF3B493CD491B4B0B", hash_generated_field = "C065F04982F6FE33BC6504F9BAFFFC6D")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "key ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.085 -0400", hash_original_field = "8B81F79D517F9CD28388913CAC47A780", hash_generated_field = "64D627A90B551B606915AF039CE1DE3C")

        @Deprecated
        public static final String SYNC_EVERYTHING = "syncEverything";
    }


    
    public static final class People implements BaseColumns, SyncConstValue, PeopleColumns, PhonesColumns, PresenceColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.085 -0400", hash_original_method = "17F062BF4D2F442415926444A39FDFDD", hash_generated_method = "C216C0213EB56168D334ECD3F7BAB76F")
        private  People() {
            
        }

        
                @Deprecated
        public static void markAsContacted(ContentResolver resolver, long personId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, personId);
            uri = Uri.withAppendedPath(uri, "update_contact_time");
            ContentValues values = new ContentValues();
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        
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

        
                @DSModeled(DSC.SPEC)
        @Deprecated
        public static Uri addToMyContactsGroup(ContentResolver resolver, long personId) {
            long groupId = tryGetMyContactsGroupId(resolver);
            if (groupId == 0) {
                throw new IllegalStateException("Failed to find the My Contacts group");
            }
            return addToGroup(resolver, personId, groupId);
        }

        
                @DSModeled(DSC.SPEC)
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

        
                @DSModeled(DSC.SPEC)
        @Deprecated
        public static Uri addToGroup(ContentResolver resolver, long personId, long groupId) {
            ContentValues values = new ContentValues();
            values.put(GroupMembership.PERSON_ID, personId);
            values.put(GroupMembership.GROUP_ID, groupId);
            return resolver.insert(GroupMembership.CONTENT_URI, values);
        }

        
                @DSModeled(DSC.SPEC)
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

        
                @Deprecated
        public static Cursor queryGroups(ContentResolver resolver, long person) {
            return resolver.query(GroupMembership.CONTENT_URI, null, "person=?",
                    new String[]{String.valueOf(person)}, Groups.DEFAULT_SORT_ORDER);
        }

        
                @DSModeled(DSC.SPEC)
        @Deprecated
        public static void setPhotoData(ContentResolver cr, Uri person, byte[] data) {
            Uri photoUri = Uri.withAppendedPath(person, Contacts.Photos.CONTENT_DIRECTORY);
            ContentValues values = new ContentValues();
            values.put(Photos.DATA, data);
            cr.update(photoUri, values, null, null);
        }

        
                @DSModeled(DSC.SPEC)
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

        
                @DSModeled(DSC.SPEC)
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

        
                private static Bitmap loadPlaceholderPhoto(int placeholderImageResource, Context context,
                BitmapFactory.Options options) {
            if (placeholderImageResource == 0) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(),
                    placeholderImageResource, options);
        }

        
        public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "E3DEAC6FD2C25762C8DA6828EC61294E")
            private  Phones() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "3C7EF5A7D1AB922D2548C0CABA18ADC7", hash_generated_field = "03899653BD7A43165B1BA23AC996EC8A")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "phones";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "2372511D72B159D203F344095EA1C4A4", hash_generated_field = "531395448D0CC5B8081F32EAD4B05B2A")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "number ASC";
        }


        
        public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "D063488DC4FB276BA82857C6DD5F45E0")
            private  ContactMethods() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "8F5390661F2CD08A00607CEBEA262809", hash_generated_field = "81E2CC782A6DDAF41E6473EED78C8F8B")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "contact_methods";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "B0EF8126BEE7F263D6045219658C0D26", hash_generated_field = "2A6A3242CA201C4CA7E6E3B9B06640F9")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "data ASC";
        }


        
        public static class Extensions implements BaseColumns, ExtensionsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "2F76D83BC2CB495AB0D58C050F1DA969")
            private  Extensions() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "9553EFC54F45BA3622976E4AFFCC74EC", hash_generated_field = "CDC7C7C6EDE1E66AA7583233A60C794A")

            @Deprecated
            public static final String CONTENT_DIRECTORY = "extensions";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.087 -0400", hash_original_field = "58DB5BEFA9854519A985688728683A1A", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

            @Deprecated
            public static final String DEFAULT_SORT_ORDER = "name ASC";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

            @Deprecated
            public static final String PERSON_ID = "person";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "AC33D4844D524EB3BBC471202AAE6C32", hash_generated_field = "A0006ED5D40B349F632A8DB10A789813")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/people");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "0A9525A85771714F974686DC73E6CAFD", hash_generated_field = "C326E9963D0B0F8829ABDD8D411B753A")

        @Deprecated
        public static final Uri CONTENT_FILTER_URI =
            Uri.parse("content://contacts/people/filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "1C1389299B89763E86E1B864E2D30A82", hash_generated_field = "59039863AF0EA2D46DBAB64A9D80DDE2")

        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_people");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "771326B0FBF9D5CF1AB099B63C5D236B", hash_generated_field = "585F41258E719DBA310CDE449E0AC433")

        @Deprecated
        public static final Uri WITH_EMAIL_OR_IM_FILTER_URI =
            Uri.parse("content://contacts/people/with_email_or_im_filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "D23B253702F1F57D4EACA9D8FB0BB4EA", hash_generated_field = "8DEB59CC7A7E46DEB194AFC58F311217")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/person";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "704B760D06A49ADA329049A876EC4EE6", hash_generated_field = "3209195D73C6562DA3DC16072766F893")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/person";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "BBD4020DCA68144F08966A84C1A98A59", hash_generated_field = "B2240268B9111906821A235B6ACEEA7A")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = People.NAME + " ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "F2F5265815F9F19AAEC389686BD46076", hash_generated_field = "774CF16EB3DEA62FEED14349A9DCF233")

        @Deprecated
        public static final String PRIMARY_PHONE_ID = "primary_phone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "1D15C8B2ECAFB1CD0D3AE6949DB1DB1A", hash_generated_field = "78EEE4364584BB341AE4BBE294388B9F")

        @Deprecated
        public static final String PRIMARY_EMAIL_ID = "primary_email";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "51CFA124E0D82EB80CB652434FF6F943", hash_generated_field = "A34816071C276225A0D70A64143E80A1")

        @Deprecated
        public static final String PRIMARY_ORGANIZATION_ID = "primary_organization";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "A3F3EC098B322268D51F871FBF1B3DCD", hash_generated_field = "E5BEDAC320AE20FE752EE3B126329BE3")

        private static final String[] GROUPS_PROJECTION = new String[] {
            Groups._ID,
        };
    }


    
    public static final class Groups implements BaseColumns, SyncConstValue, GroupsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "4AF005563E89F66C166EA0E603C46AC1")
        private  Groups() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.088 -0400", hash_original_field = "A792C39080FDB657EA91F0D2DC90FC8D", hash_generated_field = "23A9691CB89BBA676305D424A759F3A9")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groups");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "A590A2C111403F17B813E8B96259AC56", hash_generated_field = "FD40B474FE8C1E22A27B306A23E14123")

        @Deprecated
        public static final Uri DELETED_CONTENT_URI =
            Uri.parse("content://contacts/deleted_groups");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "DDCC43C28FE3F2BA652570576071E1C8", hash_generated_field = "D763B222A94439FC4F07267581C3DEC8")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroup";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "044C892D691F14F33929617CF20EB0EB", hash_generated_field = "5653DB5716D31CC3C3E3D90E598D50E4")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contactsgroup";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "BAAC1804AE99BFF86AAB446E87ADA343", hash_generated_field = "F9636372D0FD14C0236E36C561539D4B")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = NAME + " ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "D1C2CF427B4F4F6D1C390ABBFB672B43", hash_generated_field = "B2DEA429FB24C35B6649D7E9623AD778")

        @Deprecated
        public static final String GROUP_ANDROID_STARRED = "Starred in Android";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "7F0120D2CE7BAA209CD7E1AAE3511454", hash_generated_field = "66111B481D00B5BD07048DB53DE0D6A2")

        @Deprecated
        public static final String GROUP_MY_CONTACTS = "Contacts";
    }


    
    public static final class Phones implements BaseColumns, PhonesColumns, PeopleColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_method = "311A54F6C4195C76C43F2FC2F7A3A3E0", hash_generated_method = "E3DEAC6FD2C25762C8DA6828EC61294E")
        private  Phones() {
            
        }

        
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

        
                @Deprecated
        public static final CharSequence getDisplayLabel(Context context, int type,
                CharSequence label) {
            return getDisplayLabel(context, type, label, null);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "CC45187EEE280B726EE53D94B59D23FE", hash_generated_field = "C808A0DE273DF067AF275761C7FA0777")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/phones");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "7F4BDA5B6483678BA86032B11F8BEF70", hash_generated_field = "CE4CBA65EABC23B095A1080F3A1FF1E2")

        @Deprecated
        public static final Uri CONTENT_FILTER_URL =
            Uri.parse("content://contacts/phones/filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "66432D9283275A6FF90C2CC03464E3B4", hash_generated_field = "6AE3D9221905D0724D6FEEC635C6F81A")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "327E0AEA5CED3BC92E6CF5DE4C7A5414", hash_generated_field = "4D8B917148194561CC7042E5B444A946")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "58DB5BEFA9854519A985688728683A1A", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.089 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
    }


    
    public static final class GroupMembership implements BaseColumns, GroupsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "428CD6B4AF8D64BBC7FE2E70673D8538")
        private  GroupMembership() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "D1A8ABD107100B5AE3D74A0B51079350", hash_generated_field = "6B56E2959B81E3675B2CD31121EA2F41")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/groupmembership");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "7A893A2BD9FA32E9CB39F2CCBBCC0463", hash_generated_field = "2AC0D6133CFB1443EE0F7AEC7FE4F1E4")

        @Deprecated
        public static final Uri RAW_CONTENT_URI =
            Uri.parse("content://contacts/groupmembershipraw");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "84D4730CA4E5E954A2761F3C53B30846", hash_generated_field = "CB59E6C939320DA30C9A4A05DD9E626E")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "groupmembership";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "64DDCEFA34AF557C4543933A9A400DF6", hash_generated_field = "8AFFFFBCFB7AE41C6821C119992BB1EC")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contactsgroupmembership";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "8D2E01F4E142D3C532A333D81C745E46", hash_generated_field = "737A88A46CF31760D6A1020C824AF9EA")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contactsgroupmembership";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "C87753529BE0DDF6739EDC991A2B1039", hash_generated_field = "948D867DAB91EEC09F9A33836AF33379")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "group_id ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "85F6458FACFA3518DC4A39832F18D1DC", hash_generated_field = "F2516A35ABCD3A17755816388898E4A2")

        @Deprecated
        public static final String GROUP_ID = "group_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "CAAA05A6E1A1D49D98E50E05B261F284", hash_generated_field = "F9ED79409C01A8DC8B204294EB7B555B")

        @Deprecated
        public static final String GROUP_SYNC_ID = "group_sync_id";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "D1ED2F039430E602668FD157C6274140", hash_generated_field = "1B52CA84105F082C35EC026A02DA67AB")

        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT = "group_sync_account";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "5182A6A318C3DE625EDD7D05AD488DF5", hash_generated_field = "8C84F85941183FE16D9989182709A59A")

        @Deprecated
        public static final String GROUP_SYNC_ACCOUNT_TYPE = "group_sync_account_type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
    }


    
    public static final class ContactMethods implements BaseColumns, ContactMethodsColumns, PeopleColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.090 -0400", hash_original_method = "AC0A5CAC5D79A50D0A1A1A7D60109A25", hash_generated_method = "D063488DC4FB276BA82857C6DD5F45E0")
        private  ContactMethods() {
            
        }

        
                @Deprecated
        public static String encodePredefinedImProtocol(int protocol) {
            return "pre:" + protocol;
        }

        
                @Deprecated
        public static String encodeCustomImProtocol(String protocolString) {
            return "custom:" + protocolString;
        }

        
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

        
                @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.091 -0400", hash_original_method = "64D6AFA8C969AE169E36B8E60F49300F", hash_generated_method = "484F8B23CBA615FA58C42259036DBFDA")
        @Deprecated
        public void addPostalLocation(Context context, long postalId,
                double latitude, double longitude) {
            addTaint(longitude);
            addTaint(latitude);
            addTaint(postalId);
            addTaint(context.getTaint());
            final ContentResolver resolver = context.getContentResolver();
            ContentValues values = new ContentValues(2);
            values.put(POSTAL_LOCATION_LATITUDE, latitude);
            values.put(POSTAL_LOCATION_LONGITUDE, longitude);
            Uri loc = resolver.insert(CONTENT_URI, values);
            long locId = ContentUris.parseId(loc);
            values.clear();
            values.put(AUX_DATA, locId);
            resolver.update(ContentUris.withAppendedId(CONTENT_URI, postalId), values, null, null);
            
            
            
            
            
            
            
            
            
            
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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.091 -0400", hash_original_field = "47CC9A938DBD8ABE96AA31851CF4F652", hash_generated_field = "378391ED9BFF3D96FBC9F39F0B5D2048")

        @Deprecated
        public static final String POSTAL_LOCATION_LATITUDE = DATA;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "57CBB69FDD2B038B013789D8017C2387", hash_generated_field = "D30B8862F4C7D043F6642AEE7CA4F428")

        @Deprecated
        public static final String POSTAL_LOCATION_LONGITUDE = AUX_DATA;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "78C6D35977A891DE3665B9F1F950141C", hash_generated_field = "224045813CAB992845F74B167604361E")

        @Deprecated
        public static final int PROTOCOL_AIM = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "311403E66F28494A32BED88E16FB4BE8", hash_generated_field = "F295A47D26C6CE71BE9A2FEFAC56708A")

        @Deprecated
        public static final int PROTOCOL_MSN = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "C1CA61239451035D4D8A344ACBF163DC", hash_generated_field = "904E5A5ED5954215B78008CFF2A2C834")

        @Deprecated
        public static final int PROTOCOL_YAHOO = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "C3719A096786B9C9181FCFBF549FCED9", hash_generated_field = "01FC769F186261B809109926E1C49B63")

        @Deprecated
        public static final int PROTOCOL_SKYPE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "B342E0C0E93EDFEF1746942A34DA4174", hash_generated_field = "C00865D362C57785B9E4A85385266ED0")

        @Deprecated
        public static final int PROTOCOL_QQ = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "11A2907CB4D1ECDE73E5031A56F3CC5F", hash_generated_field = "1C975BA0DCF8D550112F55B5320C16D1")

        @Deprecated
        public static final int PROTOCOL_GOOGLE_TALK = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "8202593655107BD41A3A1403857849FF", hash_generated_field = "03A393EBA72855EE647CC3912C24BCF8")

        @Deprecated
        public static final int PROTOCOL_ICQ = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "A5D3C52882F414D055BDE44504230919", hash_generated_field = "C78F2B7B59A8155908CDE45BA5974FD5")

        @Deprecated
        public static final int PROTOCOL_JABBER = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "3D863301302CD408C8FE92B468494DF3", hash_generated_field = "341E3D2AEB380AE600A4AE839E324D33")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/contact_methods");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "B23446D7149F2F3C58FC42F164C920FB", hash_generated_field = "5D6DED4244C2C9DD44EA88EF4DEC1F33")

        @Deprecated
        public static final Uri CONTENT_EMAIL_URI =
            Uri.parse("content://contacts/contact_methods/email");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "5F4AEF10043991BFA06318F564E11DBF", hash_generated_field = "7B25134746B8D1E7CE6DE8E4E6D262A8")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact-methods";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "D8AD8405FE90383EC5E9A4D58592E098", hash_generated_field = "EF8853A8E61B4C35F2A9895275F51AF3")

        @Deprecated
        public static final String CONTENT_EMAIL_TYPE = "vnd.android.cursor.dir/email";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "798DD28A77C28897D0B2DEF37D1546F4", hash_generated_field = "DDA96C1B11A33A9329C9492E498AE32B")

        @Deprecated
        public static final String CONTENT_POSTAL_TYPE = "vnd.android.cursor.dir/postal-address";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "9E3DB9F0F48478DC01AF01E97B5A5E2F", hash_generated_field = "3941B227662D80A9F0FAE27C32769090")

        @Deprecated
        public static final String CONTENT_EMAIL_ITEM_TYPE = "vnd.android.cursor.item/email";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "80049EFA106FF50F9476A85A99D91EBB", hash_generated_field = "DEBE4299E99A74D8ECDC8777F803946D")

        @Deprecated
        public static final String CONTENT_POSTAL_ITEM_TYPE
                = "vnd.android.cursor.item/postal-address";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "CD9FC1F3B60D0B57A535E2334CD6AD7C", hash_generated_field = "C74FE4E8AFE0661EF9BC80B5C5DEDE83")

        @Deprecated
        public static final String CONTENT_IM_ITEM_TYPE = "vnd.android.cursor.item/jabber-im";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "58DB5BEFA9854519A985688728683A1A", hash_generated_field = "CB453AE078443ECDCDE8D1E940342776")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "name ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.092 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
    }


    
    public static final class Presence implements BaseColumns, PresenceColumns, PeopleColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_method = "FECDF62B9774A3653EF2E5C629F7A49B", hash_generated_method = "FECDF62B9774A3653EF2E5C629F7A49B")
        public Presence ()
        {
            
        }


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

        
                @Deprecated
        public static final void setPresenceIcon(ImageView icon, int serverStatus) {
            icon.setImageResource(getPresenceIconResourceId(serverStatus));
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "C862861FB1CE85F916C11148AADBC65E", hash_generated_field = "B87AB588725DCC682EE6059AE3916563")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/presence");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
    }


    
    public static final class Organizations implements BaseColumns, OrganizationColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_method = "6B80070A6DD2FB0EB3D1E45B8D1F67CF", hash_generated_method = "E40E7E0EEA87F947049763533B6A22FF")
        private  Organizations() {
            
        }

        
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "A45E29B7D11FE91E6415704265E597FF", hash_generated_field = "AF84B2628553B146851696DE7E47839F")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/organizations");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "A3548CBDF741CAF520E23A494E0F0952", hash_generated_field = "B488E16BB78D66FC9F705C632EB4E771")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "organizations";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "7D3F7969689D913BE3168B8438A077B5", hash_generated_field = "9D5369E329C8FFC02D3BD245FEA6F1DA")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "company, title, isprimary ASC";
    }


    
    public static final class Photos implements BaseColumns, PhotosColumns, SyncConstValue {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_method = "BDD10C58ECCC962A5941D61E3DCCB1CC", hash_generated_method = "579E283B127B698CEAE38F45D6F0F217")
        private  Photos() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "88D821F28AEB10987AECCABDC3A83763", hash_generated_field = "1E6F62FC0740C6E1E47B36F2927E14A2")

        @Deprecated
        public static final Uri CONTENT_URI = Uri.parse("content://contacts/photos");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "D7765A9417F60D3FDE570697DF8AE20E", hash_generated_field = "425C2A44796EA555DC9BE042C8042CE2")

        @Deprecated
        public static final String CONTENT_DIRECTORY = "photo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.093 -0400", hash_original_field = "A2EE97BD5211EEC33AD0E867163738C1", hash_generated_field = "4FFBF8322F924DDF3D93A9BEBBB16892")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person ASC";
    }


    
    public static final class Extensions implements BaseColumns, ExtensionsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "2F76D83BC2CB495AB0D58C050F1DA969")
        private  Extensions() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "C1D280BBF9543C930D06990A487B8BC6", hash_generated_field = "1BA09A34C7792B6178C2A245D81010D1")

        @Deprecated
        public static final Uri CONTENT_URI =
            Uri.parse("content://contacts/extensions");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "F72FAAE819ECB521ACB0CFAD2D258768", hash_generated_field = "1D2597714764A6635E4A746A115A8652")

        @Deprecated
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact_extensions";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "E62D2E2E38A8F43CFB6C3FD9DDCA733E", hash_generated_field = "33709222718038E2EEFBC6AC45B8B9D8")

        @Deprecated
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_extensions";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "0F5928716CE4DDADA7E21E94E990E11C", hash_generated_field = "F909140799CA99848FEE6738B33DCAC2")

        @Deprecated
        public static final String DEFAULT_SORT_ORDER = "person, name ASC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "4BB02E721BB24A5EBE529206379E6DEE", hash_generated_field = "B13FFE2CB0029C425DA640942E7C49C2")

        @Deprecated
        public static final String PERSON_ID = "person";
    }


    
    public static final class Intents {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_method = "23EEC61853691C96DADBA42E1C0CC78D", hash_generated_method = "B7DECF74799960B181BE08CCA219039E")
        @Deprecated
        public  Intents() {
            
        }

        
        public static final class UI {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_method = "998C7BFCEA8419BCEF695E421ACA0417", hash_generated_method = "BF48FE538E58A03F5DCFCF8BB9DE75AF")
            @Deprecated
            public  UI() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "76F618B8B52D4CE49C75DA6161E93EBA", hash_generated_field = "EC442A7E3DA716150058E48B0D4F24F0")

            @Deprecated
            public static final String LIST_DEFAULT = ContactsContract.Intents.UI.LIST_DEFAULT;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "EF67BE207E957066B2FDF1703A795ADA", hash_generated_field = "BDF813696078116587679D09245279B4")

            @Deprecated
            public static final String LIST_GROUP_ACTION =
                    ContactsContract.Intents.UI.LIST_GROUP_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "7479AC8E8D99E430090C593A9C328B69", hash_generated_field = "1F1FC102CEF7150E68743BFF41E24C78")

            @Deprecated
            public static final String GROUP_NAME_EXTRA_KEY =
                    ContactsContract.Intents.UI.GROUP_NAME_EXTRA_KEY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "44D23F269AAFBD0FF7E635D2F2C1595C", hash_generated_field = "E691E1CC8B3E57A064A6FA42B618984D")

            @Deprecated
            public static final String LIST_ALL_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.LIST_ALL_CONTACTS_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "A7ECB8E3F082BC5483CBD076B55AEFB8", hash_generated_field = "A7D94D347849807CD276933AA02F6F3E")

            @Deprecated
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    ContactsContract.Intents.UI.LIST_CONTACTS_WITH_PHONES_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "C91079E150BF867B97BB73AACF730A4B", hash_generated_field = "DC8009999163F97529CC2B439248161C")

            @Deprecated
            public static final String LIST_STARRED_ACTION =
                    ContactsContract.Intents.UI.LIST_STARRED_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "3E191EE44019167A1CEBB0662CF5AABD", hash_generated_field = "92B5139D5E071594E3502CDD6909B726")

            @Deprecated
            public static final String LIST_FREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_FREQUENT_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "A27AE7323063625698E88D6E12B24DC9", hash_generated_field = "3DA9C1003D058FCB91F29E0E5457A60D")

            @Deprecated
            public static final String LIST_STREQUENT_ACTION =
                    ContactsContract.Intents.UI.LIST_STREQUENT_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "4DB716D8DF7D84282EC15F09779E912D", hash_generated_field = "5A669F0D1F8CB8ADB7C369D459D1097F")

            @Deprecated
            public static final String TITLE_EXTRA_KEY =
                    ContactsContract.Intents.UI.TITLE_EXTRA_KEY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.094 -0400", hash_original_field = "03EF47F86B0C2A4C17BE4B5BE9AEC5AB", hash_generated_field = "C2DAD90DF64A4A1E19978334DF2802EA")

            @Deprecated
            public static final String FILTER_CONTACTS_ACTION =
                    ContactsContract.Intents.UI.FILTER_CONTACTS_ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "484CDB71C48C35EC1C48BE49089E26FA", hash_generated_field = "DAC03B28D6C88649F5DED50540B6664D")

            @Deprecated
            public static final String FILTER_TEXT_EXTRA_KEY =
                    ContactsContract.Intents.UI.FILTER_TEXT_EXTRA_KEY;
        }


        
        public static final class Insert {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_method = "B1003A1FA6FEB1932A0DC162C3E36DDF", hash_generated_method = "610703DEED34482762A474154980001E")
            @Deprecated
            public  Insert() {
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "7A7B4495A9D0EE14E4E767B5DDAF582F", hash_generated_field = "BC69E830B187181CA8FDFC1C9BCEE680")

            @Deprecated
            public static final String ACTION = ContactsContract.Intents.Insert.ACTION;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "C4200AAD366609AF4299531666C1E795", hash_generated_field = "DB529DBCBD1DD0C3FFAF96510DDB0814")

            @Deprecated
            public static final String FULL_MODE = ContactsContract.Intents.Insert.FULL_MODE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "01FB18C52605C79194F750645C5BF2CA", hash_generated_field = "EA6CAA5EA1BF7C67B616C2888E688578")

            @Deprecated
            public static final String NAME = ContactsContract.Intents.Insert.NAME;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "2EC8DEC1C2AB384893F361C6D8E6F2C9", hash_generated_field = "5D15C2F2364EE1C701F37B470007B5F9")

            @Deprecated
            public static final String PHONETIC_NAME =
                    ContactsContract.Intents.Insert.PHONETIC_NAME;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "F96B52D7F77BF8DC7A1751F9A2C02C43", hash_generated_field = "C70CCA753DA54DF204B1BE213C543B94")

            @Deprecated
            public static final String COMPANY = ContactsContract.Intents.Insert.COMPANY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "978983D5D9FF421782A6592F21C8C787", hash_generated_field = "CFF99ECFFD934CC41EF209DEFB02FE8E")

            @Deprecated
            public static final String JOB_TITLE = ContactsContract.Intents.Insert.JOB_TITLE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "F4510C858F2744D59B7E5D052BECEAF2", hash_generated_field = "247EE8F8222F6465F0179301A8B0D4A5")

            @Deprecated
            public static final String NOTES = ContactsContract.Intents.Insert.NOTES;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "F7324CC7737CA7040FC32BA549BFE82D", hash_generated_field = "FAE092BD399869ED3D4FDB0BE35368EB")

            @Deprecated
            public static final String PHONE = ContactsContract.Intents.Insert.PHONE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "F99B53BB3D15BC180453FA0EA03353C1", hash_generated_field = "FBCE5453A6EEFB7FAEBD14D43C5CF21A")

            @Deprecated
            public static final String PHONE_TYPE = ContactsContract.Intents.Insert.PHONE_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "C95B8E83185FEB5023C82691C543F292", hash_generated_field = "24A2D166955D62D89677FC5DA832CCAD")

            @Deprecated
            public static final String PHONE_ISPRIMARY =
                    ContactsContract.Intents.Insert.PHONE_ISPRIMARY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "AFCB629F2E417314074B8A7208A06E2F", hash_generated_field = "AA4B0EB5D35A3F830330A46612D49514")

            @Deprecated
            public static final String SECONDARY_PHONE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "C0C54FE75465D7BC84D91201AFC91600", hash_generated_field = "B54EAF6A54D892A9304AFF237C419CF4")

            @Deprecated
            public static final String SECONDARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "A75D1FE745EFCAB45F275DA9CE016B10", hash_generated_field = "37A565C6E17D9BE70B6343B2857483A3")

            @Deprecated
            public static final String TERTIARY_PHONE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "1D8D91A5A915270FC187F19D0E2EB12F", hash_generated_field = "8ED8290890EB64CE4F3E3BFC1E04CBC4")

            @Deprecated
            public static final String TERTIARY_PHONE_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_PHONE_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.095 -0400", hash_original_field = "1FFD13752AE9E832991DEC4EA89FE7DB", hash_generated_field = "1BCAEE4EC0E12CC6F8E5188CA7658001")

            @Deprecated
            public static final String EMAIL = ContactsContract.Intents.Insert.EMAIL;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "D088F23C1512F431971E601983D9447E", hash_generated_field = "4B1311BF6D37BF70571127FB407CC45B")

            @Deprecated
            public static final String EMAIL_TYPE = ContactsContract.Intents.Insert.EMAIL_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "2E059E74A5EE32237A8EDBFC7B2069B6", hash_generated_field = "84EEA545B6B5EF0FE17C3ABE6EA890AB")

            @Deprecated
            public static final String EMAIL_ISPRIMARY =
                    ContactsContract.Intents.Insert.EMAIL_ISPRIMARY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "EA549FB4416E4431B858DE57EEB37F84", hash_generated_field = "679481EF13AE69B616C49507210D8B1F")

            @Deprecated
            public static final String SECONDARY_EMAIL =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "B6394ECC5304109546ECF36153A40363", hash_generated_field = "D148791F0A4C2AF4FCDB430CD310968D")

            @Deprecated
            public static final String SECONDARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.SECONDARY_EMAIL_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "FCFAB48A8D086C87DDE5CE596BC6B07C", hash_generated_field = "4E407CC17D412E259962C699065AAC86")

            @Deprecated
            public static final String TERTIARY_EMAIL =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "133D2A905A6A5B05243019A7A9C2CA06", hash_generated_field = "900B18130ABA0EBE3AC4A78085683B42")

            @Deprecated
            public static final String TERTIARY_EMAIL_TYPE =
                    ContactsContract.Intents.Insert.TERTIARY_EMAIL_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "245A4EC3557021B1960C3D415E341838", hash_generated_field = "B7C46C1E7C0D10329CB09F1FA53AD551")

            @Deprecated
            public static final String POSTAL = ContactsContract.Intents.Insert.POSTAL;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "C62B277C08C6C9CA714C8EE8BA8CCA57", hash_generated_field = "3DCBDE69B6B6EF226C029B620DBA771B")

            @Deprecated
            public static final String POSTAL_TYPE = ContactsContract.Intents.Insert.POSTAL_TYPE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "1A852F0A52425B6AFD9D1BC50FFFD1E5", hash_generated_field = "5FA1CE6EA1FE1916AEE1200F8F482D6D")

            @Deprecated
            public static final String POSTAL_ISPRIMARY = ContactsContract.Intents.Insert.POSTAL_ISPRIMARY;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "42929DEBF4C8A896DDDC0AE18DB9C327", hash_generated_field = "03FF81C80810881D6080CA9BEB9CBFBF")

            @Deprecated
            public static final String IM_HANDLE = ContactsContract.Intents.Insert.IM_HANDLE;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "022F4DE92C4DBA0F95A8BD12838BCDA7", hash_generated_field = "BBBC1E2615A7C3E9DC3F0C525911E4D9")

            @Deprecated
            public static final String IM_PROTOCOL = ContactsContract.Intents.Insert.IM_PROTOCOL;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "1BECE5E4ECE5C9452ADCFB10BAF83B45", hash_generated_field = "BB40CC005EDFA31C3F9210DB144DC44E")

            @Deprecated
            public static final String IM_ISPRIMARY = ContactsContract.Intents.Insert.IM_ISPRIMARY;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "3EA58DCFE09EFA0C7BA5D9BF6F9CFF87", hash_generated_field = "04E12F2FF0507DD0A5D05C6AF1ED87B7")

        @Deprecated
        public static final String SEARCH_SUGGESTION_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CLICKED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "2E37E585B36E90AEC2463DACE1646FEC", hash_generated_field = "9BD1766D25ABC5072D61E9C95A360AE6")

        @Deprecated
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "662CBB5A2374B8FE7D1CBBF716E67335", hash_generated_field = "0AA0DD6BCE12FBD53A2753FF6F9ED4B7")

        @Deprecated
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                ContactsContract.Intents.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "909F025D664C10FFF103DD9BFB5BD507", hash_generated_field = "812715B154C0CFAC45E69DCBFFDB9301")

        @Deprecated
        public static final String ATTACH_IMAGE = ContactsContract.Intents.ATTACH_IMAGE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "8E5C5999B6A63465B7E618E4A716E4A0", hash_generated_field = "8E6BC080C0AC22BDCF8899AB7191ADD7")

        @Deprecated
        public static final String SHOW_OR_CREATE_CONTACT =
                ContactsContract.Intents.SHOW_OR_CREATE_CONTACT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "F9C0D3E859B957AF2BF57CB1F4800688", hash_generated_field = "5B0F2CE372610A9CF8A76AC9E5E0E39E")

        @Deprecated
        public static final String EXTRA_FORCE_CREATE = ContactsContract.Intents.EXTRA_FORCE_CREATE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "277DEB0690C4E67938F4E8CFB726324D", hash_generated_field = "CDA31384B06E8FFA18AAE152D997454D")

        @Deprecated
        public static final String EXTRA_CREATE_DESCRIPTION =
                ContactsContract.Intents.EXTRA_CREATE_DESCRIPTION;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.096 -0400", hash_original_field = "CDE50206D71AB38B44734DC706FA6B3B", hash_generated_field = "A6938FC5975623C7C234562BD57BF569")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = ContactsContract.Intents.EXTRA_TARGET_RECT;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "D8466B6193A1EEB9CAE2A2FA91B6F653", hash_generated_field = "A7B167268FF1FCDA1ADE660DDE40AF42")

    private static final String TAG = "Contacts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "C33A47189B2E5D27838D70D0525D8CD4", hash_generated_field = "B258124744B00E4365C658238E7725AC")

    @Deprecated
    public static final String AUTHORITY = "contacts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "083A9A6E0091C7159BC5D55CE6FC0135", hash_generated_field = "401ACB505704719ECABC29479D6743C9")

    @Deprecated
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "4FE3A9B750F13D9FD0BFB7B1EDE48BC7", hash_generated_field = "224169F58667E9B90C215571040939E6")

    @Deprecated
    public static final int KIND_EMAIL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "E4860E8B9F868C7509CE5E604B8277B4", hash_generated_field = "51D60E671C997C144AE6EF6E3A6E83E3")

    @Deprecated
    public static final int KIND_POSTAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "3A7CC62E2F08AE566A6821B5EE095914", hash_generated_field = "78EB8F522B27ADBF312B31AC99406902")

    @Deprecated
    public static final int KIND_IM = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "DB7083EFF39FE37D53BFBE6DD6A5E995", hash_generated_field = "B6B0F9C94DDBD96F4C3CCC1B5649D3E0")

    @Deprecated
    public static final int KIND_ORGANIZATION = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:35.097 -0400", hash_original_field = "8B122E629B1FD5CB7C73530C06573AE2", hash_generated_field = "B9F3672C79000CC77B081E5611B58E69")

    @Deprecated
    public static final int KIND_PHONE = 5;
}

