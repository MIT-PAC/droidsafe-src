package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accounts.Account;
import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorEntityIterator;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ContactsContract {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.898 -0400", hash_original_method = "DE2ED6AA3D68F52B4EF025394B7016A4", hash_generated_method = "DE2ED6AA3D68F52B4EF025394B7016A4")
        public ContactsContract ()
    {
    }


        public static boolean isProfileId(long id) {
        return id >= Profile.MIN_ID;
    }

    
        public static String snippetize(String content, String displayName, String query,
            char snippetStartMatch, char snippetEndMatch, String snippetEllipsis,
            int snippetMaxTokens) {
        String lowerQuery = query != null ? query.toLowerCase() : null;
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(query) ||
                TextUtils.isEmpty(displayName) || !content.toLowerCase().contains(lowerQuery)) {
            return null;
        }
        String lowerDisplayName = displayName != null ? displayName.toLowerCase() : "";
        List<String> nameTokens = new ArrayList<String>();
        List<Integer> nameTokenOffsets = new ArrayList<Integer>();
        split(lowerDisplayName.trim(), nameTokens, nameTokenOffsets);
        for (String nameToken : nameTokens) {
            if (nameToken.startsWith(lowerQuery)) {
                return null;
            }
        }
        String[] contentLines = content.split("\n");
        for (String contentLine : contentLines) {
            if (contentLine.toLowerCase().contains(lowerQuery)) {
                List<String> lineTokens = new ArrayList<String>();
                List<Integer> tokenOffsets = new ArrayList<Integer>();
                split(contentLine.trim(), lineTokens, tokenOffsets);
                List<String> markedTokens = new ArrayList<String>();
                int firstToken = -1;
                int lastToken = -1;
                for (int i = 0; i < lineTokens.size(); i++) {
                    String token = lineTokens.get(i);
                    String lowerToken = token.toLowerCase();
                    if (lowerToken.startsWith(lowerQuery)) {
                        markedTokens.add(snippetStartMatch + token + snippetEndMatch);
                        if (firstToken == -1) {
                            firstToken =
                                    Math.max(0, i - (int) Math.floor(
                                            Math.abs(snippetMaxTokens)
                                            / 2.0));
                            lastToken =
                                    Math.min(lineTokens.size(), firstToken +
                                            Math.abs(snippetMaxTokens));
                        }
                    } else {
                        markedTokens.add(token);
                    }
                }
                if (firstToken > -1) {
                    StringBuilder sb = new StringBuilder();
                    if (firstToken > 0) {
                        sb.append(snippetEllipsis);
                    }
                    for (int i = firstToken; i < lastToken; i++) {
                        String markedToken = markedTokens.get(i);
                        String originalToken = lineTokens.get(i);
                        sb.append(markedToken);
                        if (i < lastToken - 1) {
                            sb.append(contentLine.substring(
                                    tokenOffsets.get(i) + originalToken.length(),
                                    tokenOffsets.get(i + 1)));
                        }
                    }
                    if (lastToken < lineTokens.size()) {
                        sb.append(snippetEllipsis);
                    }
                    return sb.toString();
                }
            }
        }
        return null;
    }

    
        private static void split(String content, List<String> tokens, List<Integer> offsets) {
        Matcher matcher = SPLIT_PATTERN.matcher(content);
        while (matcher.find()) {
            tokens.add(matcher.group());
            offsets.add(matcher.start());
        }
    }

    
    public static final class Authorization {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.899 -0400", hash_original_method = "460893BF8B7147DB04A39628F031E773", hash_generated_method = "460893BF8B7147DB04A39628F031E773")
                public Authorization ()
        {
        }


        public static final String AUTHORIZATION_METHOD = "authorize";
        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";
        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
    }


    
    public static final class Preferences {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.899 -0400", hash_original_method = "F56ABB7FD848C190C791B36E6DBA54ED", hash_generated_method = "F56ABB7FD848C190C791B36E6DBA54ED")
                public Preferences ()
        {
        }


        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
        public static final int SORT_ORDER_PRIMARY = 1;
        public static final int SORT_ORDER_ALTERNATIVE = 2;
        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
        public static final int DISPLAY_ORDER_PRIMARY = 1;
        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
    }


    
    public static final class Directory implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.899 -0400", hash_original_method = "C1FAFD7F8C25A27903905826E99B3CB4", hash_generated_method = "32027E1E1476A00A97D4C9A87338A0EE")
        @DSModeled(DSC.SAFE)
        private Directory() {
            // ---------- Original Method ----------
        }

        
                public static void notifyDirectoryChange(ContentResolver resolver) {
            ContentValues contentValues = new ContentValues();
            resolver.update(Directory.CONTENT_URI, contentValues, null, null);
        }

        
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "directories");
        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/contact_directories";
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contact_directory";
        public static final long DEFAULT = 0;
        public static final long LOCAL_INVISIBLE = 1;
        public static final String PACKAGE_NAME = "packageName";
        public static final String TYPE_RESOURCE_ID = "typeResourceId";
        public static final String DISPLAY_NAME = "displayName";
        public static final String DIRECTORY_AUTHORITY = "authority";
        public static final String ACCOUNT_TYPE = "accountType";
        public static final String ACCOUNT_NAME = "accountName";
        public static final String EXPORT_SUPPORT = "exportSupport";
        public static final int EXPORT_SUPPORT_NONE = 0;
        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
        public static final int SHORTCUT_SUPPORT_NONE = 0;
        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
        public static final int SHORTCUT_SUPPORT_FULL = 2;
        public static final String PHOTO_SUPPORT = "photoSupport";
        public static final int PHOTO_SUPPORT_NONE = 0;
        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
        public static final int PHOTO_SUPPORT_FULL = 3;
    }


    
    public static final class SyncState implements SyncStateContract.Columns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.899 -0400", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "7C56DAB1CC85D73593C30D4266013E44")
        @DSModeled(DSC.SAFE)
        private SyncState() {
            // ---------- Original Method ----------
        }

        
                public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
                public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
                public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
                public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
    }


    
    public static final class ProfileSyncState implements SyncStateContract.Columns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.900 -0400", hash_original_method = "1AF1C4539078F536A57F5CC0E82C2CE1", hash_generated_method = "62C098D2F6555C9344B4BEE7E8733390")
        @DSModeled(DSC.SAFE)
        private ProfileSyncState() {
            // ---------- Original Method ----------
        }

        
                public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
                public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
                public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
                public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, CONTENT_DIRECTORY);
    }


    
    public final static class ContactCounts {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.901 -0400", hash_original_method = "E1917A0FB6C6615BBBC7A1650D47A092", hash_generated_method = "E1917A0FB6C6615BBBC7A1650D47A092")
                public ContactCounts ()
        {
        }


        public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "address_book_index_titles";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "address_book_index_counts";
    }


    
    public static class Contacts implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.901 -0400", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "EBAB9AC2EF768DD752DA8373D9E74008")
        @DSModeled(DSC.SAFE)
        private Contacts() {
            // ---------- Original Method ----------
        }

        
                public static Uri getLookupUri(ContentResolver resolver, Uri contactUri) {
            final Cursor c = resolver.query(contactUri, new String[] {
                    Contacts.LOOKUP_KEY, Contacts._ID
            }, null, null, null);
            if (c == null) {
                return null;
            }
            try {
                if (c.moveToFirst()) {
                    final String lookupKey = c.getString(0);
                    final long contactId = c.getLong(1);
                    return getLookupUri(contactId, lookupKey);
                }
            } finally {
                c.close();
            }
            return null;
        }

        
                public static Uri getLookupUri(long contactId, String lookupKey) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(Contacts.CONTENT_LOOKUP_URI,
                    lookupKey), contactId);
        }

        
                public static Uri lookupContact(ContentResolver resolver, Uri lookupUri) {
            if (lookupUri == null) {
                return null;
            }
            Cursor c = resolver.query(lookupUri, new String[]{Contacts._ID}, null, null, null);
            if (c == null) {
                return null;
            }
            try {
                if (c.moveToFirst()) {
                    long contactId = c.getLong(0);
                    return ContentUris.withAppendedId(Contacts.CONTENT_URI, contactId);
                }
            } finally {
                c.close();
            }
            return null;
        }

        
                public static void markAsContacted(ContentResolver resolver, long contactId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, contactId);
            ContentValues values = new ContentValues();
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        
                public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri,
                boolean preferHighres) {
            if (preferHighres) {
                final Uri displayPhotoUri = Uri.withAppendedPath(contactUri,
                        Contacts.Photo.DISPLAY_PHOTO);
                InputStream inputStream;
                try {
                    AssetFileDescriptor fd = cr.openAssetFileDescriptor(displayPhotoUri, "r");
                    return fd.createInputStream();
                } catch (IOException e) {
                }
           }
            Uri photoUri = Uri.withAppendedPath(contactUri, Photo.CONTENT_DIRECTORY);
            if (photoUri == null) {
                return null;
            }
            Cursor cursor = cr.query(photoUri,
                    new String[] {
                        ContactsContract.CommonDataKinds.Photo.PHOTO
                    }, null, null, null);
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
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        
                public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri) {
            return openContactPhotoInputStream(cr, contactUri, false);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.902 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
            @DSModeled(DSC.SAFE)
            private Data() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "data";
        }


        
        public static final class Entity implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.902 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "72BDB032AD922DE54B8D777470530676")
            @DSModeled(DSC.SAFE)
            private Entity() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "entities";
            public static final String RAW_CONTACT_ID = "raw_contact_id";
            public static final String DATA_ID = "data_id";
        }


        
        public static final class StreamItems implements StreamItemsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.903 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
            @DSModeled(DSC.SAFE)
            private StreamItems() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "stream_items";
        }


        
        public static final class AggregationSuggestions implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.903 -0400", hash_original_method = "35E5891C5F5088704DD7A6D202E906B4", hash_generated_method = "466C7EBC7F53D00329A79C14605D9051")
            @DSModeled(DSC.SAFE)
            private AggregationSuggestions() {
                // ---------- Original Method ----------
            }

            
                        public static final Builder builder() {
                return new Builder();
            }

            
            public static final class Builder {
                private long mContactId;
                private ArrayList<String> mKinds = new ArrayList<String>();
                private ArrayList<String> mValues = new ArrayList<String>();
                private int mLimit;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.903 -0400", hash_original_method = "E3E7F27996F0F2E94367F4C927CC51AE", hash_generated_method = "E3E7F27996F0F2E94367F4C927CC51AE")
                                public Builder ()
                {
                }


                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.903 -0400", hash_original_method = "9AAB1F7A5A7D8D5960972B4CBC4F52B3", hash_generated_method = "60A4DDE5F6CF4E6DBD1C351588D074BB")
                @DSModeled(DSC.SAFE)
                public Builder setContactId(long contactId) {
                    dsTaint.addTaint(contactId);
                    return (Builder)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //this.mContactId = contactId;
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.904 -0400", hash_original_method = "C32C8611EF5F2627AFE89485D07DC5FB", hash_generated_method = "AF7543D9D3507E952A0CE7FFEB73B716")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public Builder addParameter(String kind, String value) {
                    dsTaint.addTaint(value);
                    dsTaint.addTaint(kind);
                    {
                        boolean varD361F572B1E67BC677F2A4DD67C6D3CF_469032767 = (!TextUtils.isEmpty(value));
                        {
                            mKinds.add(kind);
                            mValues.add(value);
                        } //End block
                    } //End collapsed parenthetic
                    return (Builder)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (!TextUtils.isEmpty(value)) {
                        //mKinds.add(kind);
                        //mValues.add(value);
                    //}
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.904 -0400", hash_original_method = "C603E268BE9EB815AE093A2C036882D2", hash_generated_method = "647B2A9FFAA00B08353A2DE44982021E")
                @DSModeled(DSC.SAFE)
                public Builder setLimit(int limit) {
                    dsTaint.addTaint(limit);
                    return (Builder)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //mLimit = limit;
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.904 -0400", hash_original_method = "CC75446D812A1F4BC170E31BF0668A44", hash_generated_method = "D4B68AD0FD7893DA52F6CE0B8CF40BC6")
                @DSModeled(DSC.SPEC)
                public Uri build() {
                    android.net.Uri.Builder builder;
                    builder = Contacts.CONTENT_URI.buildUpon();
                    builder.appendEncodedPath(String.valueOf(mContactId));
                    builder.appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY);
                    {
                        builder.appendQueryParameter("limit", String.valueOf(mLimit));
                    } //End block
                    int count;
                    count = mKinds.size();
                    {
                        int i;
                        i = 0;
                        {
                            builder.appendQueryParameter("query", mKinds.get(i) + ":" + mValues.get(i));
                        } //End block
                    } //End collapsed parenthetic
                    Uri varFEE94907A62FB2E049F7AD84119F88A7_130233238 = (builder.build());
                    return (Uri)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //android.net.Uri.Builder builder = Contacts.CONTENT_URI.buildUpon();
                    //builder.appendEncodedPath(String.valueOf(mContactId));
                    //builder.appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY);
                    //if (mLimit != 0) {
                        //builder.appendQueryParameter("limit", String.valueOf(mLimit));
                    //}
                    //int count = mKinds.size();
                    //for (int i = 0; i < count; i++) {
                        //builder.appendQueryParameter("query", mKinds.get(i) + ":" + mValues.get(i));
                    //}
                    //return builder.build();
                }

                
            }


            
            public static final String CONTENT_DIRECTORY = "suggestions";
            public static final String PARAMETER_MATCH_NAME = "name";
            public static final String PARAMETER_MATCH_EMAIL = "email";
            public static final String PARAMETER_MATCH_PHONE = "phone";
            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
        }


        
        public static final class Photo implements BaseColumns, DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.905 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6353485435339DC025174C823A75D00F")
            @DSModeled(DSC.SAFE)
            private Photo() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "photo";
            public static final String DISPLAY_PHOTO = "display_photo";
            public static final String PHOTO_FILE_ID = DATA14;
            public static final String PHOTO = DATA15;
        }


        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "contacts");
        public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                "lookup");
        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
        public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";
        public static final Uri CONTENT_MULTI_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_multi_vcard");
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_URI, "filter");
        public static final Uri CONTENT_STREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "strequent");
        public static final Uri CONTENT_FREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "frequent");
        public static final Uri CONTENT_STREQUENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_STREQUENT_URI, "filter");
        public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(
                CONTENT_URI, "group");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
    }


    
    public static final class Profile implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.905 -0400", hash_original_method = "B87424FB8F4DF05D98854CA5453341A1", hash_generated_method = "F0740920D8E660C3FAFA79C0F30FDA26")
        @DSModeled(DSC.SAFE)
        private Profile() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "profile");
        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
        public static final Uri CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI,
                "raw_contacts");
        public static final long MIN_ID = Long.MAX_VALUE - (long) Integer.MAX_VALUE;
    }


    
    public static final class RawContacts implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.905 -0400", hash_original_method = "6107CD4B76D912ACDA57642552743C0C", hash_generated_method = "005A36265C3975138432C36B012CB07D")
        @DSModeled(DSC.SAFE)
        private RawContacts() {
            // ---------- Original Method ----------
        }

        
                public static Uri getContactLookupUri(ContentResolver resolver, Uri rawContactUri) {
            final Uri dataUri = Uri.withAppendedPath(rawContactUri, Data.CONTENT_DIRECTORY);
            final Cursor cursor = resolver.query(dataUri, new String[] {
                    RawContacts.CONTACT_ID, Contacts.LOOKUP_KEY
            }, null, null, null);
            Uri lookupUri = null;
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    final long contactId = cursor.getLong(0);
                    final String lookupKey = cursor.getString(1);
                    return Contacts.getLookupUri(contactId, lookupKey);
                }
            } finally {
                if (cursor != null) cursor.close();
            }
            return lookupUri;
        }

        
                public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.906 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
            @DSModeled(DSC.SAFE)
            private Data() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "data";
        }


        
        public static final class Entity implements BaseColumns, DataColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.906 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "72BDB032AD922DE54B8D777470530676")
            @DSModeled(DSC.SAFE)
            private Entity() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "entity";
            public static final String DATA_ID = "data_id";
        }


        
        public static final class StreamItems implements BaseColumns, StreamItemsColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.906 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
            @DSModeled(DSC.SAFE)
            private StreamItems() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "stream_items";
        }


        
        public static final class DisplayPhoto {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.906 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "B2E13164C0532FB7A083C12460677DAB")
            @DSModeled(DSC.SAFE)
            private DisplayPhoto() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "display_photo";
        }


        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.906 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "E6BE4064EE211A3FD662F23DCF234396")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                dsTaint.addTaint(cursor.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.908 -0400", hash_original_method = "BE255AFD270DEBC5451268E05A1F1326", hash_generated_method = "37D1298B15B40A09B1D3CB27B316F12C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                dsTaint.addTaint(cursor.dsTaint);
                int columnRawContactId;
                columnRawContactId = cursor.getColumnIndexOrThrow(RawContacts._ID);
                long rawContactId;
                rawContactId = cursor.getLong(columnRawContactId);
                ContentValues cv;
                cv = new ContentValues();
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, ACCOUNT_NAME);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, ACCOUNT_TYPE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, DATA_SET);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, _ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, DIRTY);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, VERSION);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SOURCE_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC4);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, DELETED);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, CONTACT_ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, STARRED);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, cv, NAME_VERIFIED);
                android.content.Entity contact;
                contact = new android.content.Entity(cv);
                {
                    {
                        boolean varB99BF263731FCDD1B7D97568AF1A5FAF_23142086 = (rawContactId != cursor.getLong(columnRawContactId));
                    } //End collapsed parenthetic
                    cv = new ContentValues();
                    cv.put(Data._ID, cursor.getLong(cursor.getColumnIndexOrThrow(Entity.DATA_ID)));
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            Data.RES_PACKAGE);
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, Data.MIMETYPE);
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, Data.IS_PRIMARY);
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv,
                            Data.IS_SUPER_PRIMARY);
                    DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, Data.DATA_VERSION);
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            CommonDataKinds.GroupMembership.GROUP_SOURCE_ID);
                    DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            Data.DATA_VERSION);
                    {
                        Iterator<String> varA6BF6BB8A5490D54E38BAEF6FB4093F0_135184805 = (DATA_KEYS).iterator();
                        varA6BF6BB8A5490D54E38BAEF6FB4093F0_135184805.hasNext();
                        String key = varA6BF6BB8A5490D54E38BAEF6FB4093F0_135184805.next();
                        {
                            int columnIndex;
                            columnIndex = cursor.getColumnIndexOrThrow(key);
                            {
                                Object varEC1574263D651B776F9708DA9F11928E_1278945703 = (cursor.getType(columnIndex));
                                //Begin case Cursor.FIELD_TYPE_INTEGER Cursor.FIELD_TYPE_FLOAT Cursor.FIELD_TYPE_STRING 
                                cv.put(key, cursor.getString(columnIndex));
                                //End case Cursor.FIELD_TYPE_INTEGER Cursor.FIELD_TYPE_FLOAT Cursor.FIELD_TYPE_STRING 
                                //Begin case Cursor.FIELD_TYPE_BLOB 
                                cv.put(key, cursor.getBlob(columnIndex));
                                //End case Cursor.FIELD_TYPE_BLOB 
                                //Begin case default 
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Invalid or unhandled data type");
                                //End case default 
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    contact.addSubValue(ContactsContract.Data.CONTENT_URI, cv);
                } //End block
                {
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_1342760827 = (cursor.moveToNext());
                } //End collapsed parenthetic
                return (android.content.Entity)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            private static final String[] DATA_KEYS = new String[]{
                    Data.DATA1,
                    Data.DATA2,
                    Data.DATA3,
                    Data.DATA4,
                    Data.DATA5,
                    Data.DATA6,
                    Data.DATA7,
                    Data.DATA8,
                    Data.DATA9,
                    Data.DATA10,
                    Data.DATA11,
                    Data.DATA12,
                    Data.DATA13,
                    Data.DATA14,
                    Data.DATA15,
                    Data.SYNC1,
                    Data.SYNC2,
                    Data.SYNC3,
                    Data.SYNC4};
        }


        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "raw_contacts");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        public static final int AGGREGATION_MODE_DEFAULT = 0;
        @Deprecated public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        public static final int AGGREGATION_MODE_SUSPENDED = 2;
        public static final int AGGREGATION_MODE_DISABLED = 3;
    }


    
    public static final class StreamItems implements BaseColumns, StreamItemsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.908 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
        @DSModeled(DSC.SAFE)
        private StreamItems() {
            // ---------- Original Method ----------
        }

        
        public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.909 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "802E4A54077CF0761BF1353DB1940447")
            @DSModeled(DSC.SAFE)
            private StreamItemPhotos() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_DIRECTORY = "photo";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";
            public static final String CONTENT_ITEM_TYPE
                    = "vnd.android.cursor.item/stream_item_photo";
        }


        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "stream_items");
        public static final Uri CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
        public static final Uri CONTENT_LIMIT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "stream_items_limit");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        public static final String MAX_ITEMS = "max_items";
    }


    
    public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.909 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "802E4A54077CF0761BF1353DB1940447")
        @DSModeled(DSC.SAFE)
        private StreamItemPhotos() {
            // ---------- Original Method ----------
        }

        
        public static final String PHOTO = "photo";
    }


    
    public static final class PhotoFiles implements BaseColumns, PhotoFilesColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.909 -0400", hash_original_method = "68B58AFB95B4CB9CF9AA43D4A8112325", hash_generated_method = "059107858AF90ED764E5882C1FCC748C")
        @DSModeled(DSC.SAFE)
        private PhotoFiles() {
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class Data implements DataColumnsWithJoins {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.909 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
        @DSModeled(DSC.SAFE)
        private Data() {
            // ---------- Original Method ----------
        }

        
                public static Uri getContactLookupUri(ContentResolver resolver, Uri dataUri) {
            final Cursor cursor = resolver.query(dataUri, new String[] {
                    RawContacts.CONTACT_ID, Contacts.LOOKUP_KEY
            }, null, null, null);
            Uri lookupUri = null;
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    final long contactId = cursor.getLong(0);
                    final String lookupKey = cursor.getString(1);
                    return Contacts.getLookupUri(contactId, lookupKey);
                }
            } finally {
                if (cursor != null) cursor.close();
            }
            return lookupUri;
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "data");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
    }


    
    public final static class RawContactsEntity implements BaseColumns, DataColumns, RawContactsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.910 -0400", hash_original_method = "F8C55B41037119D58D30171BDB7F39D2", hash_generated_method = "B8AC49C785E02A24876BA7954CC9671E")
        @DSModeled(DSC.SAFE)
        private RawContactsEntity() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "raw_contact_entities");
        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
        public static final String FOR_EXPORT_ONLY = "for_export_only";
        public static final String DATA_ID = "data_id";
    }


    
    public static final class PhoneLookup implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.910 -0400", hash_original_method = "D1B05D947AED4866E4130EF727A894C9", hash_generated_method = "CEF12FA719FCE0616B6F9109D727ED4D")
        @DSModeled(DSC.SAFE)
        private PhoneLookup() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "phone_lookup");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";
    }


    
    public static class StatusUpdates implements StatusColumns, PresenceColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.910 -0400", hash_original_method = "5AF8C140309DC273491B33B4E92E1FA7", hash_generated_method = "F61E7CF0B8D56F58CA9C892D1715AD61")
        @DSModeled(DSC.SAFE)
        private StatusUpdates() {
            // ---------- Original Method ----------
        }

        
                public static final int getPresenceIconResourceId(int status) {
            switch (status) {
                case AVAILABLE:
                    return android.R.drawable.presence_online;
                case IDLE:
                case AWAY:
                    return android.R.drawable.presence_away;
                case DO_NOT_DISTURB:
                    return android.R.drawable.presence_busy;
                case INVISIBLE:
                    return android.R.drawable.presence_invisible;
                case OFFLINE:
                default:
                    return android.R.drawable.presence_offline;
            }
        }

        
                public static final int getPresencePrecedence(int status) {
            return status;
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "status_updates");
        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
    }


    
    public static final class Presence extends StatusUpdates {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.911 -0400", hash_original_method = "AF71AE7F9B40D333BE404BDE10FDE89F", hash_generated_method = "AF71AE7F9B40D333BE404BDE10FDE89F")
                public Presence ()
        {
        }


    }


    
    public static class SearchSnippetColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.911 -0400", hash_original_method = "54D04D1ED0AD28A61B11FDFDE926885E", hash_generated_method = "54D04D1ED0AD28A61B11FDFDE926885E")
                public SearchSnippetColumns ()
        {
        }


        public static final String SNIPPET = "snippet";
        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
    }


    
    public static final class CommonDataKinds {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.911 -0400", hash_original_method = "3EB47618DCA126249F6622B558B44C8E", hash_generated_method = "17AE15FF7C1A5C629F88953C9F30A23B")
        @DSModeled(DSC.SAFE)
        private CommonDataKinds() {
            // ---------- Original Method ----------
        }

        
        public static final class StructuredName implements DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.911 -0400", hash_original_method = "3FC3D91ED9F213084C3DE2075E5DC6AD", hash_generated_method = "CE1EF34405CD085F5E1F4B00ACF1AACC")
            @DSModeled(DSC.SAFE)
            private StructuredName() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
            public static final String DISPLAY_NAME = DATA1;
            public static final String GIVEN_NAME = DATA2;
            public static final String FAMILY_NAME = DATA3;
            public static final String PREFIX = DATA4;
            public static final String MIDDLE_NAME = DATA5;
            public static final String SUFFIX = DATA6;
            public static final String PHONETIC_GIVEN_NAME = DATA7;
            public static final String PHONETIC_MIDDLE_NAME = DATA8;
            public static final String PHONETIC_FAMILY_NAME = DATA9;
            public static final String FULL_NAME_STYLE = DATA10;
            public static final String PHONETIC_NAME_STYLE = DATA11;
        }


        
        public static final class Nickname implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.911 -0400", hash_original_method = "C2B5C7987B903EB42CE1EDEA1961E0EA", hash_generated_method = "32E284B5312A7E0C5334C9B07602E0ED")
            @DSModeled(DSC.SAFE)
            private Nickname() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            public static final int TYPE_DEFAULT = 1;
            public static final int TYPE_OTHER_NAME = 2;
            public static final int TYPE_MAIDEN_NAME = 3;
            @Deprecated public static final int TYPE_MAINDEN_NAME = 3;
            public static final int TYPE_SHORT_NAME = 4;
            public static final int TYPE_INITIALS = 5;
            public static final String NAME = DATA;
        }


        
        public static final class Phone implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.912 -0400", hash_original_method = "8C72E3409D1DFC404D9CBFEE30B178A0", hash_generated_method = "5D173D82F090B2D243AF646F29A6957E")
            @DSModeled(DSC.SAFE)
            private Phone() {
                // ---------- Original Method ----------
            }

            
                        @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label, CharSequence[] labelArray) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
                        @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.phoneTypeHome;
                    case TYPE_MOBILE: return com.android.internal.R.string.phoneTypeMobile;
                    case TYPE_WORK: return com.android.internal.R.string.phoneTypeWork;
                    case TYPE_FAX_WORK: return com.android.internal.R.string.phoneTypeFaxWork;
                    case TYPE_FAX_HOME: return com.android.internal.R.string.phoneTypeFaxHome;
                    case TYPE_PAGER: return com.android.internal.R.string.phoneTypePager;
                    case TYPE_OTHER: return com.android.internal.R.string.phoneTypeOther;
                    case TYPE_CALLBACK: return com.android.internal.R.string.phoneTypeCallback;
                    case TYPE_CAR: return com.android.internal.R.string.phoneTypeCar;
                    case TYPE_COMPANY_MAIN: return com.android.internal.R.string.phoneTypeCompanyMain;
                    case TYPE_ISDN: return com.android.internal.R.string.phoneTypeIsdn;
                    case TYPE_MAIN: return com.android.internal.R.string.phoneTypeMain;
                    case TYPE_OTHER_FAX: return com.android.internal.R.string.phoneTypeOtherFax;
                    case TYPE_RADIO: return com.android.internal.R.string.phoneTypeRadio;
                    case TYPE_TELEX: return com.android.internal.R.string.phoneTypeTelex;
                    case TYPE_TTY_TDD: return com.android.internal.R.string.phoneTypeTtyTdd;
                    case TYPE_WORK_MOBILE: return com.android.internal.R.string.phoneTypeWorkMobile;
                    case TYPE_WORK_PAGER: return com.android.internal.R.string.phoneTypeWorkPager;
                    case TYPE_ASSISTANT: return com.android.internal.R.string.phoneTypeAssistant;
                    case TYPE_MMS: return com.android.internal.R.string.phoneTypeMms;
                    default: return com.android.internal.R.string.phoneTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if ((type == TYPE_CUSTOM || type == TYPE_ASSISTANT) && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "phones");
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
            public static final int TYPE_HOME = 1;
            public static final int TYPE_MOBILE = 2;
            public static final int TYPE_WORK = 3;
            public static final int TYPE_FAX_WORK = 4;
            public static final int TYPE_FAX_HOME = 5;
            public static final int TYPE_PAGER = 6;
            public static final int TYPE_OTHER = 7;
            public static final int TYPE_CALLBACK = 8;
            public static final int TYPE_CAR = 9;
            public static final int TYPE_COMPANY_MAIN = 10;
            public static final int TYPE_ISDN = 11;
            public static final int TYPE_MAIN = 12;
            public static final int TYPE_OTHER_FAX = 13;
            public static final int TYPE_RADIO = 14;
            public static final int TYPE_TELEX = 15;
            public static final int TYPE_TTY_TDD = 16;
            public static final int TYPE_WORK_MOBILE = 17;
            public static final int TYPE_WORK_PAGER = 18;
            public static final int TYPE_ASSISTANT = 19;
            public static final int TYPE_MMS = 20;
            public static final String NUMBER = DATA;
            public static final String NORMALIZED_NUMBER = DATA4;
        }


        
        public static final class Email implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.913 -0400", hash_original_method = "4685E1971C120F244FF83B34E469953F", hash_generated_method = "AE4BB686E4A7B4068C4E01F323C0B09B")
            @DSModeled(DSC.SAFE)
            private Email() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.emailTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.emailTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.emailTypeOther;
                    case TYPE_MOBILE: return com.android.internal.R.string.emailTypeMobile;
                    default: return com.android.internal.R.string.emailTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "emails");
            public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                    "lookup");
            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
            public static final String ADDRESS = DATA1;
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;
            public static final int TYPE_MOBILE = 4;
            public static final String DISPLAY_NAME = DATA4;
        }


        
        public static final class StructuredPostal implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.913 -0400", hash_original_method = "C8D888449545672CEC46DD26E7BDDD9A", hash_generated_method = "6863A6EEFAC7C6659E60E563C7E51932")
            @DSModeled(DSC.SAFE)
            private StructuredPostal() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.postalTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.postalTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.postalTypeOther;
                    default: return com.android.internal.R.string.postalTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/postal-address_v2";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";
            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "postals");
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;
            public static final String FORMATTED_ADDRESS = DATA;
            public static final String STREET = DATA4;
            public static final String POBOX = DATA5;
            public static final String NEIGHBORHOOD = DATA6;
            public static final String CITY = DATA7;
            public static final String REGION = DATA8;
            public static final String POSTCODE = DATA9;
            public static final String COUNTRY = DATA10;
        }


        
        public static final class Im implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.914 -0400", hash_original_method = "7F43853CDED9232ACA3765709B5C5CC7", hash_generated_method = "3D120A0520BAC27E9D81D0F0F88DB3FD")
            @DSModeled(DSC.SAFE)
            private Im() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.imTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.imTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.imTypeOther;
                    default: return com.android.internal.R.string.imTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
                        public static final int getProtocolLabelResource(int type) {
                switch (type) {
                    case PROTOCOL_AIM: return com.android.internal.R.string.imProtocolAim;
                    case PROTOCOL_MSN: return com.android.internal.R.string.imProtocolMsn;
                    case PROTOCOL_YAHOO: return com.android.internal.R.string.imProtocolYahoo;
                    case PROTOCOL_SKYPE: return com.android.internal.R.string.imProtocolSkype;
                    case PROTOCOL_QQ: return com.android.internal.R.string.imProtocolQq;
                    case PROTOCOL_GOOGLE_TALK: return com.android.internal.R.string.imProtocolGoogleTalk;
                    case PROTOCOL_ICQ: return com.android.internal.R.string.imProtocolIcq;
                    case PROTOCOL_JABBER: return com.android.internal.R.string.imProtocolJabber;
                    case PROTOCOL_NETMEETING: return com.android.internal.R.string.imProtocolNetMeeting;
                    default: return com.android.internal.R.string.imProtocolCustom;
                }
            }

            
                        public static final CharSequence getProtocolLabel(Resources res, int type,
                    CharSequence label) {
                if (type == PROTOCOL_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getProtocolLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;
            public static final String PROTOCOL = DATA5;
            public static final String CUSTOM_PROTOCOL = DATA6;
            public static final int PROTOCOL_CUSTOM = -1;
            public static final int PROTOCOL_AIM = 0;
            public static final int PROTOCOL_MSN = 1;
            public static final int PROTOCOL_YAHOO = 2;
            public static final int PROTOCOL_SKYPE = 3;
            public static final int PROTOCOL_QQ = 4;
            public static final int PROTOCOL_GOOGLE_TALK = 5;
            public static final int PROTOCOL_ICQ = 6;
            public static final int PROTOCOL_JABBER = 7;
            public static final int PROTOCOL_NETMEETING = 8;
        }


        
        public static final class Organization implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.916 -0400", hash_original_method = "DB9E0507E0CFF6D3A6878FC813F638FB", hash_generated_method = "24D678582F58DD0084445608A443E82F")
            @DSModeled(DSC.SAFE)
            private Organization() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_WORK: return com.android.internal.R.string.orgTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.orgTypeOther;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
            public static final int TYPE_WORK = 1;
            public static final int TYPE_OTHER = 2;
            public static final String COMPANY = DATA;
            public static final String TITLE = DATA4;
            public static final String DEPARTMENT = DATA5;
            public static final String JOB_DESCRIPTION = DATA6;
            public static final String SYMBOL = DATA7;
            public static final String PHONETIC_NAME = DATA8;
            public static final String OFFICE_LOCATION = DATA9;
            public static final String PHONETIC_NAME_STYLE = DATA10;
        }


        
        public static final class Relation implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.917 -0400", hash_original_method = "AB820511C2318175DFB023ADDE00500D", hash_generated_method = "004DD1D842B963562C78785064E7989B")
            @DSModeled(DSC.SAFE)
            private Relation() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_ASSISTANT: return com.android.internal.R.string.relationTypeAssistant;
                    case TYPE_BROTHER: return com.android.internal.R.string.relationTypeBrother;
                    case TYPE_CHILD: return com.android.internal.R.string.relationTypeChild;
                    case TYPE_DOMESTIC_PARTNER:
                            return com.android.internal.R.string.relationTypeDomesticPartner;
                    case TYPE_FATHER: return com.android.internal.R.string.relationTypeFather;
                    case TYPE_FRIEND: return com.android.internal.R.string.relationTypeFriend;
                    case TYPE_MANAGER: return com.android.internal.R.string.relationTypeManager;
                    case TYPE_MOTHER: return com.android.internal.R.string.relationTypeMother;
                    case TYPE_PARENT: return com.android.internal.R.string.relationTypeParent;
                    case TYPE_PARTNER: return com.android.internal.R.string.relationTypePartner;
                    case TYPE_REFERRED_BY:
                            return com.android.internal.R.string.relationTypeReferredBy;
                    case TYPE_RELATIVE: return com.android.internal.R.string.relationTypeRelative;
                    case TYPE_SISTER: return com.android.internal.R.string.relationTypeSister;
                    case TYPE_SPOUSE: return com.android.internal.R.string.relationTypeSpouse;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
            public static final int TYPE_ASSISTANT = 1;
            public static final int TYPE_BROTHER = 2;
            public static final int TYPE_CHILD = 3;
            public static final int TYPE_DOMESTIC_PARTNER = 4;
            public static final int TYPE_FATHER = 5;
            public static final int TYPE_FRIEND = 6;
            public static final int TYPE_MANAGER = 7;
            public static final int TYPE_MOTHER = 8;
            public static final int TYPE_PARENT = 9;
            public static final int TYPE_PARTNER = 10;
            public static final int TYPE_REFERRED_BY = 11;
            public static final int TYPE_RELATIVE = 12;
            public static final int TYPE_SISTER = 13;
            public static final int TYPE_SPOUSE = 14;
            public static final String NAME = DATA;
        }


        
        public static final class Event implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.917 -0400", hash_original_method = "D3DDD15A13BA6EC1D9CD48C2CCCFE0B4", hash_generated_method = "F9069AC01DFBB6E335236591397070B2")
            @DSModeled(DSC.SAFE)
            private Event() {
                // ---------- Original Method ----------
            }

            
                        public static int getTypeResource(Integer type) {
                if (type == null) {
                    return com.android.internal.R.string.eventTypeOther;
                }
                switch (type) {
                    case TYPE_ANNIVERSARY:
                        return com.android.internal.R.string.eventTypeAnniversary;
                    case TYPE_BIRTHDAY: return com.android.internal.R.string.eventTypeBirthday;
                    case TYPE_OTHER: return com.android.internal.R.string.eventTypeOther;
                    default: return com.android.internal.R.string.eventTypeCustom;
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            public static final int TYPE_ANNIVERSARY = 1;
            public static final int TYPE_OTHER = 2;
            public static final int TYPE_BIRTHDAY = 3;
            public static final String START_DATE = DATA;
        }


        
        public static final class Photo implements DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.918 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6353485435339DC025174C823A75D00F")
            @DSModeled(DSC.SAFE)
            private Photo() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            public static final String PHOTO_FILE_ID = DATA14;
            public static final String PHOTO = DATA15;
        }


        
        public static final class Note implements DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.918 -0400", hash_original_method = "EBAE52FCFF9289B17EA2262C75B6F6C0", hash_generated_method = "22ECB65A834798A58E72F146C908C2C8")
            @DSModeled(DSC.SAFE)
            private Note() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            public static final String NOTE = DATA1;
        }


        
        public static final class GroupMembership implements DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.918 -0400", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "428CD6B4AF8D64BBC7FE2E70673D8538")
            @DSModeled(DSC.SAFE)
            private GroupMembership() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/group_membership";
            public static final String GROUP_ROW_ID = DATA1;
            public static final String GROUP_SOURCE_ID = "group_sourceid";
        }


        
        public static final class Website implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.918 -0400", hash_original_method = "CC2DAF060546DD565E4193F5085BC2F2", hash_generated_method = "95610DE2A4CA3A3ED50311363B3F2A27")
            @DSModeled(DSC.SAFE)
            private Website() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            public static final int TYPE_HOMEPAGE = 1;
            public static final int TYPE_BLOG = 2;
            public static final int TYPE_PROFILE = 3;
            public static final int TYPE_HOME = 4;
            public static final int TYPE_WORK = 5;
            public static final int TYPE_FTP = 6;
            public static final int TYPE_OTHER = 7;
            public static final String URL = DATA;
        }


        
        public static final class SipAddress implements DataColumnsWithJoins, CommonColumns {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.919 -0400", hash_original_method = "7307A74E42B27B76827D43357DA8B367", hash_generated_method = "EF707E530C2FC911E23A8D91CEFB5F2B")
            @DSModeled(DSC.SAFE)
            private SipAddress() {
                // ---------- Original Method ----------
            }

            
                        public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.sipAddressTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.sipAddressTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.sipAddressTypeOther;
                    default: return com.android.internal.R.string.sipAddressTypeCustom;
                }
            }

            
                        public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;
            public static final String SIP_ADDRESS = DATA1;
        }


        
        public static final class Identity implements DataColumnsWithJoins {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.919 -0400", hash_original_method = "CB97BE8665681C1FD82290A9CE03A1A5", hash_generated_method = "EAF95E91D3C42B1A473D86AA0DA890E2")
            @DSModeled(DSC.SAFE)
            private Identity() {
                // ---------- Original Method ----------
            }

            
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            public static final String IDENTITY = DataColumns.DATA1;
            public static final String NAMESPACE = DataColumns.DATA2;
        }


        
        public interface BaseTypes {
            
            public static int TYPE_CUSTOM = 0;
        }
        
        protected interface CommonColumns extends BaseTypes {
            
            public static final String DATA = DataColumns.DATA1;

            
            public static final String TYPE = DataColumns.DATA2;

            
            public static final String LABEL = DataColumns.DATA3;
        }
        
        public static final String PACKAGE_COMMON = "common";
    }


    
    public static final class Groups implements BaseColumns, GroupsColumns, SyncColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.919 -0400", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "4AF005563E89F66C166EA0E603C46AC1")
        @DSModeled(DSC.SAFE)
        private Groups() {
            // ---------- Original Method ----------
        }

        
                public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.920 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "E6BE4064EE211A3FD662F23DCF234396")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                dsTaint.addTaint(cursor.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.920 -0400", hash_original_method = "DDAF6836AC46D694049E3DD971FAB2B5", hash_generated_method = "A0D94741EA0CBA94EC9C58BD3B5B015E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                dsTaint.addTaint(cursor.dsTaint);
                ContentValues values;
                values = new ContentValues();
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, _ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, ACCOUNT_NAME);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, ACCOUNT_TYPE);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, DIRTY);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, VERSION);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SOURCE_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, RES_PACKAGE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, TITLE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, TITLE_RES);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, GROUP_VISIBLE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC4);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYSTEM_ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, DELETED);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, NOTES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SHOULD_SYNC);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, FAVORITES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, AUTO_ADD);
                cursor.moveToNext();
                Entity varB61519D85100DB0A4303B499E710283C_1942946485 = (new Entity(values));
                return (Entity)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "groups");
        public static final Uri CONTENT_SUMMARY_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "groups_summary");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
    }


    
    public static final class AggregationExceptions implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.920 -0400", hash_original_method = "AEC5F5D30A84CFEC2D9D1903833FB78B", hash_generated_method = "ED7E5F4AC17489A373923084FD271B08")
        @DSModeled(DSC.SAFE)
        private AggregationExceptions() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "aggregation_exceptions");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/aggregation_exception";
        public static final String TYPE = "type";
        public static final int TYPE_AUTOMATIC = 0;
        public static final int TYPE_KEEP_TOGETHER = 1;
        public static final int TYPE_KEEP_SEPARATE = 2;
        public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
        public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
    }


    
    public static final class Settings implements SettingsColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.921 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "2C16D3C86A761A9DF5E58231442F813C")
        @DSModeled(DSC.SAFE)
        private Settings() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "settings");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
    }


    
    public static final class ProviderStatus {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.921 -0400", hash_original_method = "795A4A88B7E0FFCBF277CCA1899F11E6", hash_generated_method = "31F9DB0C46ADEE3AB9E7AC4FBB60BDC4")
        @DSModeled(DSC.SAFE)
        private ProviderStatus() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "provider_status");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";
        public static final String STATUS = "status";
        public static final int STATUS_NORMAL = 0;
        public static final int STATUS_UPGRADING = 1;
        public static final int STATUS_UPGRADE_OUT_OF_MEMORY = 2;
        public static final int STATUS_CHANGING_LOCALE = 3;
        public static final int STATUS_NO_ACCOUNTS_NO_CONTACTS = 4;
        public static final String DATA1 = "data1";
    }


    
    public static final class DataUsageFeedback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.921 -0400", hash_original_method = "BEB0B4B11EAAF2CBA3A75F70D7ACF1F2", hash_generated_method = "BEB0B4B11EAAF2CBA3A75F70D7ACF1F2")
                public DataUsageFeedback ()
        {
        }


        public static final Uri FEEDBACK_URI =
                Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
        public static final String USAGE_TYPE = "type";
        public static final String USAGE_TYPE_CALL = "call";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
    }


    
    public static final class QuickContact {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.921 -0400", hash_original_method = "B8AA0779852F22CBD95581123836D7A0", hash_generated_method = "B8AA0779852F22CBD95581123836D7A0")
                public QuickContact ()
        {
        }


                public static void showQuickContact(Context context, View target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            final float appScale = context.getResources().getCompatibilityInfo().applicationScale;
            final int[] pos = new int[2];
            target.getLocationOnScreen(pos);
            final Rect rect = new Rect();
            rect.left = (int) (pos[0] * appScale + 0.5f);
            rect.top = (int) (pos[1] * appScale + 0.5f);
            rect.right = (int) ((pos[0] + target.getWidth()) * appScale + 0.5f);
            rect.bottom = (int) ((pos[1] + target.getHeight()) * appScale + 0.5f);
            showQuickContact(context, rect, lookupUri, mode, excludeMimes);
        }

        
                public static void showQuickContact(Context context, Rect target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            final Intent intent = new Intent(ACTION_QUICK_CONTACT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            intent.setData(lookupUri);
            intent.setSourceBounds(target);
            intent.putExtra(EXTRA_MODE, mode);
            intent.putExtra(EXTRA_EXCLUDE_MIMES, excludeMimes);
            context.startActivity(intent);
        }

        
        public static final String ACTION_QUICK_CONTACT =
                "com.android.contacts.action.QUICK_CONTACT";
        @Deprecated public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final String EXTRA_MODE = "mode";
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        public static final int MODE_SMALL = 1;
        public static final int MODE_MEDIUM = 2;
        public static final int MODE_LARGE = 3;
    }


    
    public static final class DisplayPhoto {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.922 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "B2E13164C0532FB7A083C12460677DAB")
        @DSModeled(DSC.SAFE)
        private DisplayPhoto() {
            // ---------- Original Method ----------
        }

        
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "display_photo");
        public static final Uri CONTENT_MAX_DIMENSIONS_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "photo_dimensions");
        public static final String DISPLAY_MAX_DIM = "display_max_dim";
        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
    }


    
    public static final class Intents {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.922 -0400", hash_original_method = "FD95D140BFADEB4CFA03E1D7AD3D1B16", hash_generated_method = "FD95D140BFADEB4CFA03E1D7AD3D1B16")
                public Intents ()
        {
        }


        public static final class UI {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.922 -0400", hash_original_method = "FBD9B6F08D1222C15E507E68DED61A3A", hash_generated_method = "FBD9B6F08D1222C15E507E68DED61A3A")
                        public UI ()
            {
            }


            public static final String LIST_DEFAULT =
                    "com.android.contacts.action.LIST_DEFAULT";
            public static final String LIST_GROUP_ACTION =
                    "com.android.contacts.action.LIST_GROUP";
            public static final String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";
            public static final String LIST_ALL_CONTACTS_ACTION =
                    "com.android.contacts.action.LIST_ALL_CONTACTS";
            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
            public static final String LIST_STARRED_ACTION =
                    "com.android.contacts.action.LIST_STARRED";
            public static final String LIST_FREQUENT_ACTION =
                    "com.android.contacts.action.LIST_FREQUENT";
            public static final String LIST_STREQUENT_ACTION =
                    "com.android.contacts.action.LIST_STREQUENT";
            public static final String TITLE_EXTRA_KEY =
                    "com.android.contacts.extra.TITLE_EXTRA";
            public static final String FILTER_CONTACTS_ACTION =
                    "com.android.contacts.action.FILTER_CONTACTS";
            public static final String FILTER_TEXT_EXTRA_KEY =
                    "com.android.contacts.extra.FILTER_TEXT";
        }


        
        public static final class Insert {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.922 -0400", hash_original_method = "7C6323E6962BB80DF6B7F45EE17A4436", hash_generated_method = "7C6323E6962BB80DF6B7F45EE17A4436")
                        public Insert ()
            {
            }


            public static final String ACTION = Intent.ACTION_INSERT;
            public static final String FULL_MODE = "full_mode";
            public static final String NAME = "name";
            public static final String PHONETIC_NAME = "phonetic_name";
            public static final String COMPANY = "company";
            public static final String JOB_TITLE = "job_title";
            public static final String NOTES = "notes";
            public static final String PHONE = "phone";
            public static final String PHONE_TYPE = "phone_type";
            public static final String PHONE_ISPRIMARY = "phone_isprimary";
            public static final String SECONDARY_PHONE = "secondary_phone";
            public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
            public static final String TERTIARY_PHONE = "tertiary_phone";
            public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
            public static final String EMAIL = "email";
            public static final String EMAIL_TYPE = "email_type";
            public static final String EMAIL_ISPRIMARY = "email_isprimary";
            public static final String SECONDARY_EMAIL = "secondary_email";
            public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
            public static final String TERTIARY_EMAIL = "tertiary_email";
            public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
            public static final String POSTAL = "postal";
            public static final String POSTAL_TYPE = "postal_type";
            public static final String POSTAL_ISPRIMARY = "postal_isprimary";
            public static final String IM_HANDLE = "im_handle";
            public static final String IM_PROTOCOL = "im_protocol";
            public static final String IM_ISPRIMARY = "im_isprimary";
            public static final String DATA = "data";
            public static final String ACCOUNT = "com.android.contacts.extra.ACCOUNT";
            public static final String DATA_SET = "com.android.contacts.extra.DATA_SET";
        }


        
        public static final String SEARCH_SUGGESTION_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        public static final String ATTACH_IMAGE =
                "com.android.contacts.action.ATTACH_IMAGE";
        public static final String INVITE_CONTACT =
                "com.android.contacts.action.INVITE_CONTACT";
        public static final String SHOW_OR_CREATE_CONTACT =
                "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
        public static final String ACTION_GET_MULTIPLE_PHONES =
                "com.android.contacts.action.GET_MULTIPLE_PHONES";
        public static final String EXTRA_FORCE_CREATE =
                "com.android.contacts.action.FORCE_CREATE";
        public static final String EXTRA_CREATE_DESCRIPTION =
            "com.android.contacts.action.CREATE_DESCRIPTION";
        public static final String EXTRA_PHONE_URIS =
            "com.android.contacts.extra.PHONE_URIS";
        @Deprecated public static final String EXTRA_TARGET_RECT = "target_rect";
        @Deprecated public static final String EXTRA_MODE = "mode";
        @Deprecated public static final int MODE_SMALL = 1;
        @Deprecated public static final int MODE_MEDIUM = 2;
        @Deprecated public static final int MODE_LARGE = 3;
        @Deprecated public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
    }


    
    @Deprecated public interface SyncStateColumns extends SyncStateContract.Columns {
    }
    
    protected interface BaseSyncColumns {

        
        public static final String SYNC1 = "sync1";
        
        public static final String SYNC2 = "sync2";
        
        public static final String SYNC3 = "sync3";
        
        public static final String SYNC4 = "sync4";
    }
    
    protected interface SyncColumns extends BaseSyncColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String SOURCE_ID = "sourceid";

        
        public static final String VERSION = "version";

        
        public static final String DIRTY = "dirty";
    }
    
    protected interface ContactOptionsColumns {
        
        public static final String TIMES_CONTACTED = "times_contacted";

        
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";

        
        public static final String STARRED = "starred";

        
        public static final String CUSTOM_RINGTONE = "custom_ringtone";

        
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
    }
    
    protected interface ContactsColumns {
        
        public static final String DISPLAY_NAME = ContactNameColumns.DISPLAY_NAME_PRIMARY;

        
        public static final String NAME_RAW_CONTACT_ID = "name_raw_contact_id";

        
        public static final String PHOTO_ID = "photo_id";

        
        public static final String PHOTO_FILE_ID = "photo_file_id";

        
        public static final String PHOTO_URI = "photo_uri";

        
        public static final String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";

        
        public static final String IN_VISIBLE_GROUP = "in_visible_group";

        
        public static final String IS_USER_PROFILE = "is_user_profile";

        
        public static final String HAS_PHONE_NUMBER = "has_phone_number";

        
        public static final String LOOKUP_KEY = "lookup";
    }
    
    protected interface ContactStatusColumns {
        
        public static final String CONTACT_PRESENCE = "contact_presence";

        
        public static final String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";

        
        public static final String CONTACT_STATUS = "contact_status";

        
        public static final String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";

        
        public static final String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";

        
        public static final String CONTACT_STATUS_LABEL = "contact_status_label";

        
        public static final String CONTACT_STATUS_ICON = "contact_status_icon";
    }
    
    public interface FullNameStyle {
        public static final int UNDEFINED = 0;
        public static final int WESTERN = 1;

        
        public static final int CJK = 2;

        public static final int CHINESE = 3;
        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
    }
    
    public interface PhoneticNameStyle {
        public static final int UNDEFINED = 0;

        
        public static final int PINYIN = 3;

        
        public static final int JAPANESE = 4;

        
        public static final int KOREAN = 5;
    }
    
    public interface DisplayNameSources {
        public static final int UNDEFINED = 0;
        public static final int EMAIL = 10;
        public static final int PHONE = 20;
        public static final int ORGANIZATION = 30;
        public static final int NICKNAME = 35;
        public static final int STRUCTURED_NAME = 40;
    }
    
    protected interface ContactNameColumns {

        
        public static final String DISPLAY_NAME_SOURCE = "display_name_source";

        
        public static final String DISPLAY_NAME_PRIMARY = "display_name";

        
        public static final String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";

        
        public static final String PHONETIC_NAME_STYLE = "phonetic_name_style";

        
        public static final String PHONETIC_NAME = "phonetic_name";

        
        public static final String SORT_KEY_PRIMARY = "sort_key";

        
        public static final String SORT_KEY_ALTERNATIVE = "sort_key_alt";
    }
    
    protected interface RawContactsColumns {
        
        public static final String CONTACT_ID = "contact_id";

        
        public static final String DATA_SET = "data_set";

        
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";

        
        public static final String AGGREGATION_MODE = "aggregation_mode";

        
        public static final String DELETED = "deleted";

        
        public static final String NAME_VERIFIED = "name_verified";

        
        public static final String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";

        
        public static final String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
    }
    
    protected interface StatusColumns {
        
        public static final String PRESENCE = "mode";

        
        @Deprecated
        public static final String PRESENCE_STATUS = PRESENCE;

        
        int OFFLINE = 0;

        
        int INVISIBLE = 1;

        
        int AWAY = 2;

        
        int IDLE = 3;

        
        int DO_NOT_DISTURB = 4;

        
        int AVAILABLE = 5;

        
        public static final String STATUS = "status";

        
        @Deprecated
        public static final String PRESENCE_CUSTOM_STATUS = STATUS;

        
        public static final String STATUS_TIMESTAMP = "status_ts";

        
        public static final String STATUS_RES_PACKAGE = "status_res_package";

        
        public static final String STATUS_LABEL = "status_label";

        
        public static final String STATUS_ICON = "status_icon";

        
        public static final String CHAT_CAPABILITY = "chat_capability";

        
        public static final int CAPABILITY_HAS_VOICE = 1;

        
        public static final int CAPABILITY_HAS_VIDEO = 2;

        
        public static final int CAPABILITY_HAS_CAMERA = 4;
    }
    
    protected interface StreamItemsColumns {
        
        public static final String CONTACT_ID = "contact_id";

        
        public static final String CONTACT_LOOKUP_KEY = "contact_lookup";

        
        public static final String RAW_CONTACT_ID = "raw_contact_id";

        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String DATA_SET = "data_set";

        
        public static final String RAW_CONTACT_SOURCE_ID = "raw_contact_source_id";

        
        public static final String RES_ICON = "icon";

        
        public static final String RES_LABEL = "label";

        
        public static final String TEXT = "text";

        
        public static final String TIMESTAMP = "timestamp";

        
        public static final String COMMENTS = "comments";

        
        public static final String SYNC1 = "stream_item_sync1";
        
        public static final String SYNC2 = "stream_item_sync2";
        
        public static final String SYNC3 = "stream_item_sync3";
        
        public static final String SYNC4 = "stream_item_sync4";
    }
    
    protected interface StreamItemPhotosColumns {
        
        public static final String STREAM_ITEM_ID = "stream_item_id";

        
        public static final String SORT_INDEX = "sort_index";

        
        public static final String PHOTO_FILE_ID = "photo_file_id";

        
        public static final String PHOTO_URI = "photo_uri";

        
        public static final String SYNC1 = "stream_item_photo_sync1";
        
        public static final String SYNC2 = "stream_item_photo_sync2";
        
        public static final String SYNC3 = "stream_item_photo_sync3";
        
        public static final String SYNC4 = "stream_item_photo_sync4";
    }
    
    protected interface PhotoFilesColumns {

        
        public static final String HEIGHT = "height";

        
        public static final String WIDTH = "width";

        
        public static final String FILESIZE = "filesize";
    }
    
    protected interface DataColumns {
        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String MIMETYPE = "mimetype";

        
        public static final String RAW_CONTACT_ID = "raw_contact_id";

        
        public static final String IS_PRIMARY = "is_primary";

        
        public static final String IS_SUPER_PRIMARY = "is_super_primary";

        
        public static final String IS_READ_ONLY = "is_read_only";

        
        public static final String DATA_VERSION = "data_version";

        
        public static final String DATA1 = "data1";
        
        public static final String DATA2 = "data2";
        
        public static final String DATA3 = "data3";
        
        public static final String DATA4 = "data4";
        
        public static final String DATA5 = "data5";
        
        public static final String DATA6 = "data6";
        
        public static final String DATA7 = "data7";
        
        public static final String DATA8 = "data8";
        
        public static final String DATA9 = "data9";
        
        public static final String DATA10 = "data10";
        
        public static final String DATA11 = "data11";
        
        public static final String DATA12 = "data12";
        
        public static final String DATA13 = "data13";
        
        public static final String DATA14 = "data14";
        
        public static final String DATA15 = "data15";

        
        public static final String SYNC1 = "data_sync1";
        
        public static final String SYNC2 = "data_sync2";
        
        public static final String SYNC3 = "data_sync3";
        
        public static final String SYNC4 = "data_sync4";
    }
    
    protected interface DataColumnsWithJoins extends BaseColumns, DataColumns, StatusColumns,
            RawContactsColumns, ContactsColumns, ContactNameColumns, ContactOptionsColumns,
            ContactStatusColumns {
    }
    
    protected interface PhoneLookupColumns {
        
        public static final String NUMBER = "number";

        
        public static final String TYPE = "type";

        
        public static final String LABEL = "label";

        
        public static final String NORMALIZED_NUMBER = "normalized_number";
    }
    
    protected interface PresenceColumns {

        
        public static final String DATA_ID = "presence_data_id";

        
        public static final String PROTOCOL = "protocol";

        
        public static final String CUSTOM_PROTOCOL = "custom_protocol";

        
        public static final String IM_HANDLE = "im_handle";

        
        public static final String IM_ACCOUNT = "im_account";
    }
    
    protected interface GroupsColumns {
        
        public static final String DATA_SET = "data_set";

        
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";

        
        public static final String TITLE = "title";

        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String TITLE_RES = "title_res";

        
        public static final String NOTES = "notes";

        
        public static final String SYSTEM_ID = "system_id";

        
        public static final String SUMMARY_COUNT = "summ_count";

        
        public static final String PARAM_RETURN_GROUP_COUNT_PER_ACCOUNT =
                "return_group_count_per_account";

        
        public static final String SUMMARY_GROUP_COUNT_PER_ACCOUNT = "group_count_per_account";

        
        public static final String SUMMARY_WITH_PHONES = "summ_phones";

        
        public static final String GROUP_VISIBLE = "group_visible";

        
        public static final String DELETED = "deleted";

        
        public static final String SHOULD_SYNC = "should_sync";

        
        public static final String AUTO_ADD = "auto_add";

        
        public static final String FAVORITES = "favorites";

        
        public static final String GROUP_IS_READ_ONLY = "group_is_read_only";
    }
    
    protected interface SettingsColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String DATA_SET = "data_set";

        
        public static final String SHOULD_SYNC = "should_sync";

        
        public static final String UNGROUPED_VISIBLE = "ungrouped_visible";

        
        public static final String ANY_UNSYNCED = "any_unsynced";

        
        public static final String UNGROUPED_COUNT = "summ_count";

        
        public static final String UNGROUPED_WITH_PHONES = "summ_phones";
    }
    
    public static final String AUTHORITY = "com.android.contacts";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    public static final String DIRECTORY_PARAM_KEY = "directory";
    public static final String LIMIT_PARAM_KEY = "limit";
    public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
    public static final String STREQUENT_PHONE_ONLY = "strequent_phone_only";
    public static final String DEFERRED_SNIPPETING = "deferred_snippeting";
    public static final String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";
    public static final String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";
    private static Pattern SPLIT_PATTERN =
        Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
}

