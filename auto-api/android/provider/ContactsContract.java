package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.185 -0400", hash_original_method = "0941112ABD9069C80C65289B6D5666C2", hash_generated_method = "2B2E591A90F2D66450BD3C85D36EE73D")
    public static boolean isProfileId(long id) {
        return id >= Profile.MIN_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.185 -0400", hash_original_method = "BBD9B5CD65A55FC3201E30C2D0E96E71", hash_generated_method = "AE2BAF3D8CFE03FA01456F64B6681992")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.185 -0400", hash_original_method = "712ABC4CE2C3A9D659D9E51530EC203D", hash_generated_method = "190F3C53417FE6D5980891B58347F2FB")
    private static void split(String content, List<String> tokens, List<Integer> offsets) {
        Matcher matcher = SPLIT_PATTERN.matcher(content);
        while (matcher.find()) {
            tokens.add(matcher.group());
            offsets.add(matcher.start());
        }
    }

    
    public static final class Authorization {
        public static final String AUTHORIZATION_METHOD = "authorize";
        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";
        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
        
    }


    
    public static final class Preferences {
        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
        public static final int SORT_ORDER_PRIMARY = 1;
        public static final int SORT_ORDER_ALTERNATIVE = 2;
        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
        public static final int DISPLAY_ORDER_PRIMARY = 1;
        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
        
    }


    
    public static final class Directory implements BaseColumns {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "C1FAFD7F8C25A27903905826E99B3CB4", hash_generated_method = "DA73FD90234FC4BE012C1AE709342E4C")
        @DSModeled(DSC.SAFE)
        private Directory() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "6D608DB52AC8952A89B8472446A9496C", hash_generated_method = "D71015D103F5403B70A115DAA5CEE7B6")
        public static void notifyDirectoryChange(ContentResolver resolver) {
            ContentValues contentValues = new ContentValues();
            resolver.update(Directory.CONTENT_URI, contentValues, null, null);
        }

        
    }


    
    public static final class SyncState implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "E5FA8B7167A782C4D192D2EE83D7166D")
        @DSModeled(DSC.SAFE)
        private SyncState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "466578A19F0FCF2DD10FDB6DAFFC0887", hash_generated_method = "2968688090F0A89899005B639287D49D")
        public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "B9E8FB5AB055D4E1E45E9949F3C016CF", hash_generated_method = "6E822DD6634A9EBA8F5FA49F5EB38784")
        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "579F427E12689D3799FB7240CB2CED7E", hash_generated_method = "0929C6A0E720D5E2073DF205F65D7551")
        public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "4E10B60B39C26218926D7406FB7CC71E", hash_generated_method = "4874286873285082166E1414165C7F12")
        public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
    }


    
    public static final class ProfileSyncState implements SyncStateContract.Columns {
        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, CONTENT_DIRECTORY);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "1AF1C4539078F536A57F5CC0E82C2CE1", hash_generated_method = "3EDFEEA4475387220DCAD005AE3CCE1C")
        @DSModeled(DSC.SAFE)
        private ProfileSyncState() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "466578A19F0FCF2DD10FDB6DAFFC0887", hash_generated_method = "2968688090F0A89899005B639287D49D")
        public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "B9E8FB5AB055D4E1E45E9949F3C016CF", hash_generated_method = "6E822DD6634A9EBA8F5FA49F5EB38784")
        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.186 -0400", hash_original_method = "579F427E12689D3799FB7240CB2CED7E", hash_generated_method = "0929C6A0E720D5E2073DF205F65D7551")
        public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "4E10B60B39C26218926D7406FB7CC71E", hash_generated_method = "4874286873285082166E1414165C7F12")
        public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
    }


    
    public final static class ContactCounts {
        public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "address_book_index_titles";
        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "address_book_index_counts";
        
    }


    
    public static class Contacts implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "B7BFE0CB877BB67929CBA3A0EFBDC212")
        @DSModeled(DSC.SAFE)
        private Contacts() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "297CD8052D16F966DA20463FE5C9F18D", hash_generated_method = "E132A7F36CE1995AD84D3CA4E748E1F1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "0E35577C3A2634FAB6CE2A7C0110A8D4", hash_generated_method = "7A2D838CE8D4D565E159F4336E306008")
        public static Uri getLookupUri(long contactId, String lookupKey) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(Contacts.CONTENT_LOOKUP_URI,
                    lookupKey), contactId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "4F238AFCA9F990B01002B079DB33FCDE", hash_generated_method = "6BC905CC6054CBBC02A4C6C4B960B080")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "EA7A02146AEC4BB6B360E334F2919FC1", hash_generated_method = "42C78D1BFC696157921943AD8E80F582")
        public static void markAsContacted(ContentResolver resolver, long contactId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, contactId);
            ContentValues values = new ContentValues();
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "39CCF57C11710ED9D7B06C24BDE6652B", hash_generated_method = "9A2A4D019DB2AEB88056535D3154458E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "38D81F9B93E07ADE0E2E072FADEAEAB2", hash_generated_method = "366EB5E49CE660D34F00F358317E4C64")
        public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri) {
            return openContactPhotoInputStream(cr, contactUri, false);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "data";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.187 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "DE7A34A900372B7572DE779BBF70EB12")
            @DSModeled(DSC.SAFE)
            private Data() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Entity implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns {
            public static final String CONTENT_DIRECTORY = "entities";
            public static final String RAW_CONTACT_ID = "raw_contact_id";
            public static final String DATA_ID = "data_id";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "8D879C3001A6BEC9B7598231AC21E7B0")
            @DSModeled(DSC.SAFE)
            private Entity() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class StreamItems implements StreamItemsColumns {
            public static final String CONTENT_DIRECTORY = "stream_items";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "354370F6EFAA994E1B0309101BC73A16")
            @DSModeled(DSC.SAFE)
            private StreamItems() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class AggregationSuggestions implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {
            public static final String CONTENT_DIRECTORY = "suggestions";
            public static final String PARAMETER_MATCH_NAME = "name";
            public static final String PARAMETER_MATCH_EMAIL = "email";
            public static final String PARAMETER_MATCH_PHONE = "phone";
            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "35E5891C5F5088704DD7A6D202E906B4", hash_generated_method = "1E2F973CBF4BCF1F80E6F9F4FF532E66")
            @DSModeled(DSC.SAFE)
            private AggregationSuggestions() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "B7290700D54BBB985B4CC30322753CF6", hash_generated_method = "C24B0573979CF7DEB9AEBD50BF3FB4FB")
            public static final Builder builder() {
                return new Builder();
            }

            
            public static final class Builder {
                private long mContactId;
                private ArrayList<String> mKinds = new ArrayList<String>();
                private ArrayList<String> mValues = new ArrayList<String>();
                private int mLimit;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "9AAB1F7A5A7D8D5960972B4CBC4F52B3", hash_generated_method = "A14CDE0CA0F63C6356C07689F49A9890")
                @DSModeled(DSC.SAFE)
                public Builder setContactId(long contactId) {
                    dsTaint.addTaint(contactId);
                    return (Builder)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //this.mContactId = contactId;
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "C32C8611EF5F2627AFE89485D07DC5FB", hash_generated_method = "A81274F0579669B028952395620833F8")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public Builder addParameter(String kind, String value) {
                    dsTaint.addTaint(value);
                    dsTaint.addTaint(kind);
                    {
                        boolean varD361F572B1E67BC677F2A4DD67C6D3CF_529792628 = (!TextUtils.isEmpty(value));
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

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "C603E268BE9EB815AE093A2C036882D2", hash_generated_method = "0884197288167F6AA7053C9BFE68C4E8")
                @DSModeled(DSC.SAFE)
                public Builder setLimit(int limit) {
                    dsTaint.addTaint(limit);
                    return (Builder)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //mLimit = limit;
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.188 -0400", hash_original_method = "CC75446D812A1F4BC170E31BF0668A44", hash_generated_method = "6817D37318F34F451293F8F5B1BE2F9F")
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
                    Uri varFEE94907A62FB2E049F7AD84119F88A7_1624179198 = (builder.build());
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


            
        }


        
        public static final class Photo implements BaseColumns, DataColumnsWithJoins {
            public static final String CONTENT_DIRECTORY = "photo";
            public static final String DISPLAY_PHOTO = "display_photo";
            public static final String PHOTO_FILE_ID = DATA14;
            public static final String PHOTO = DATA15;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "2D85DD80A144D36F33275D4A6419D75B")
            @DSModeled(DSC.SAFE)
            private Photo() {
                // ---------- Original Method ----------
            }

            
        }


        
    }


    
    public static final class Profile implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "profile");
        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
        public static final Uri CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI,
                "raw_contacts");
        public static final long MIN_ID = Long.MAX_VALUE - (long) Integer.MAX_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "B87424FB8F4DF05D98854CA5453341A1", hash_generated_method = "05CA6694745671FBA7DA4CC7D9B9D110")
        @DSModeled(DSC.SAFE)
        private Profile() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class RawContacts implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "raw_contacts");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        public static final int AGGREGATION_MODE_DEFAULT = 0;
        @Deprecated
        public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        public static final int AGGREGATION_MODE_SUSPENDED = 2;
        public static final int AGGREGATION_MODE_DISABLED = 3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "6107CD4B76D912ACDA57642552743C0C", hash_generated_method = "0808D93202C62DFC45F7A1E22478ED56")
        @DSModeled(DSC.SAFE)
        private RawContacts() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "4F63AD3366CF1143E7246464BD728917", hash_generated_method = "8E7F0FBB009CEA016C37BBBBB31D551A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "7C8784537648600B4251C9E262BFEFC5", hash_generated_method = "9F167F07FC0CADA08203BAA255DB9A81")
        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "data";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "DE7A34A900372B7572DE779BBF70EB12")
            @DSModeled(DSC.SAFE)
            private Data() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Entity implements BaseColumns, DataColumns {
            public static final String CONTENT_DIRECTORY = "entity";
            public static final String DATA_ID = "data_id";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "8D879C3001A6BEC9B7598231AC21E7B0")
            @DSModeled(DSC.SAFE)
            private Entity() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class StreamItems implements BaseColumns, StreamItemsColumns {
            public static final String CONTENT_DIRECTORY = "stream_items";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "354370F6EFAA994E1B0309101BC73A16")
            @DSModeled(DSC.SAFE)
            private StreamItems() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class DisplayPhoto {
            public static final String CONTENT_DIRECTORY = "display_photo";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "E301244D8E4F99AA0567061D7FED0A7C")
            @DSModeled(DSC.SAFE)
            private DisplayPhoto() {
                // ---------- Original Method ----------
            }

            
        }


        
        private static class EntityIteratorImpl extends CursorEntityIterator {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.189 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "3B59B4CAFFC6405C709C46CE9ED84B82")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                dsTaint.addTaint(cursor.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.190 -0400", hash_original_method = "BE255AFD270DEBC5451268E05A1F1326", hash_generated_method = "D19B71975F17EB9B499C518729625D6A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                dsTaint.addTaint(cursor.dsTaint);
                final int columnRawContactId;
                columnRawContactId = cursor.getColumnIndexOrThrow(RawContacts._ID);
                final long rawContactId;
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
                        boolean varB99BF263731FCDD1B7D97568AF1A5FAF_1243302452 = (rawContactId != cursor.getLong(columnRawContactId));
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
                        String key = DATA_KEYS[0];
                        {
                            final int columnIndex;
                            columnIndex = cursor.getColumnIndexOrThrow(key);
                            {
                                Object varEC1574263D651B776F9708DA9F11928E_789113990 = (cursor.getType(columnIndex));
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
                    boolean var916090E1B2D032E1EC67FFC8B3451FBE_608381955 = (cursor.moveToNext());
                } //End collapsed parenthetic
                return (android.content.Entity)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    public static final class StreamItems implements BaseColumns, StreamItemsColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "stream_items");
        public static final Uri CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
        public static final Uri CONTENT_LIMIT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "stream_items_limit");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        public static final String MAX_ITEMS = "max_items";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.190 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "354370F6EFAA994E1B0309101BC73A16")
        @DSModeled(DSC.SAFE)
        private StreamItems() {
            // ---------- Original Method ----------
        }

        
        public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
            public static final String CONTENT_DIRECTORY = "photo";
            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";
            public static final String CONTENT_ITEM_TYPE
                    = "vnd.android.cursor.item/stream_item_photo";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.190 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "08A160F26688984D392632DE59456E55")
            @DSModeled(DSC.SAFE)
            private StreamItemPhotos() {
                // ---------- Original Method ----------
            }

            
        }


        
    }


    
    public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
        public static final String PHOTO = "photo";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.190 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "08A160F26688984D392632DE59456E55")
        @DSModeled(DSC.SAFE)
        private StreamItemPhotos() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class PhotoFiles implements BaseColumns, PhotoFilesColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.190 -0400", hash_original_method = "68B58AFB95B4CB9CF9AA43D4A8112325", hash_generated_method = "94D2384E080CBF934AC2B02D797E6182")
        @DSModeled(DSC.SAFE)
        private PhotoFiles() {
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class Data implements DataColumnsWithJoins {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "data");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "DE7A34A900372B7572DE779BBF70EB12")
        @DSModeled(DSC.SAFE)
        private Data() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "0B01F4FFA9092B5AD574B1F239B48F30", hash_generated_method = "AEC79E50439816765945FD5849DA7650")
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

        
    }


    
    public final static class RawContactsEntity implements BaseColumns, DataColumns, RawContactsColumns {
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "raw_contact_entities");
        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
        public static final String FOR_EXPORT_ONLY = "for_export_only";
        public static final String DATA_ID = "data_id";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "F8C55B41037119D58D30171BDB7F39D2", hash_generated_method = "B9621E6A5F68F73AE2176EFD48C98C7B")
        @DSModeled(DSC.SAFE)
        private RawContactsEntity() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class PhoneLookup implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {
        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "phone_lookup");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "D1B05D947AED4866E4130EF727A894C9", hash_generated_method = "0E37383C881421367FB764E354AD890C")
        @DSModeled(DSC.SAFE)
        private PhoneLookup() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static class StatusUpdates implements StatusColumns, PresenceColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "status_updates");
        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "5AF8C140309DC273491B33B4E92E1FA7", hash_generated_method = "C4E17EFF92E8B4DEE8FDEFF7605D695A")
        @DSModeled(DSC.SAFE)
        private StatusUpdates() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "446C58B7C43E87E7412C64E179FEA5CC", hash_generated_method = "FEA2EB291A0761BEC2E482F505CD797B")
        public static final int getPresenceIconResourceId(int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "039C6EEFF77EBB58265A91F8AD87418B", hash_generated_method = "00CFC14E581A7183DBDB4EA053649282")
        public static final int getPresencePrecedence(int status) {
            return status;
        }

        
    }


    
    public static final class Presence extends StatusUpdates {
        
    }


    
    public static class SearchSnippetColumns {
        public static final String SNIPPET = "snippet";
        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
        
    }


    
    public static final class CommonDataKinds {
        public static final String PACKAGE_COMMON = "common";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "3EB47618DCA126249F6622B558B44C8E", hash_generated_method = "D67CA9FACE645E16235A5A9CF03ED0D0")
        @DSModeled(DSC.SAFE)
        private CommonDataKinds() {
            // ---------- Original Method ----------
        }

        
        public static final class StructuredName implements DataColumnsWithJoins {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "3FC3D91ED9F213084C3DE2075E5DC6AD", hash_generated_method = "6A1F3342D9AFC65EDB522A71322179F7")
            @DSModeled(DSC.SAFE)
            private StructuredName() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Nickname implements DataColumnsWithJoins, CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            public static final int TYPE_DEFAULT = 1;
            public static final int TYPE_OTHER_NAME = 2;
            public static final int TYPE_MAIDEN_NAME = 3;
            @Deprecated
            public static final int TYPE_MAINDEN_NAME = 3;
            public static final int TYPE_SHORT_NAME = 4;
            public static final int TYPE_INITIALS = 5;
            public static final String NAME = DATA;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.191 -0400", hash_original_method = "C2B5C7987B903EB42CE1EDEA1961E0EA", hash_generated_method = "FCCEDE5C46B02C5DEF1E35025E6FBA02")
            @DSModeled(DSC.SAFE)
            private Nickname() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Phone implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "8C72E3409D1DFC404D9CBFEE30B178A0", hash_generated_method = "99567417F8DD76150A67183757743A01")
            @DSModeled(DSC.SAFE)
            private Phone() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "EDF764EB0E7CD97EABC22A940CB89180", hash_generated_method = "E36ABE3BDA6AAD825A671925C6585D0B")
            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label, CharSequence[] labelArray) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "9A10A12FCE02DEF77AEA0F0D7AE31554", hash_generated_method = "94E05A3692E1861476EF4BD15F819DAD")
            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "A6D4C160D00AA3D36D5417E79FCE7BE2", hash_generated_method = "519BDFA1CF1FDA85ED2C90BFCB4EAA27")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "DB726CF4AF0A68CE45AE4CC8697A8990", hash_generated_method = "16C263C0668F5C7F953A2DE5737E1ECD")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if ((type == TYPE_CUSTOM || type == TYPE_ASSISTANT) && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Email implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "4685E1971C120F244FF83B34E469953F", hash_generated_method = "65F6B10BB1ED51A92B90C5C9BAC77EA1")
            @DSModeled(DSC.SAFE)
            private Email() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "E7DA05307A110C99CAAC7B66439AA912", hash_generated_method = "3AC091B7B77748F12E12FDDA82CBE6AC")
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.emailTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.emailTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.emailTypeOther;
                    case TYPE_MOBILE: return com.android.internal.R.string.emailTypeMobile;
                    default: return com.android.internal.R.string.emailTypeCustom;
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class StructuredPostal implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.192 -0400", hash_original_method = "C8D888449545672CEC46DD26E7BDDD9A", hash_generated_method = "E068EF38C09A88D110AF449424738557")
            @DSModeled(DSC.SAFE)
            private StructuredPostal() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "5BF2306E301E46F8BD771E4EFD0EBA38", hash_generated_method = "0222ACA728765DEA2E42F4BB1C03A29A")
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.postalTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.postalTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.postalTypeOther;
                    default: return com.android.internal.R.string.postalTypeCustom;
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Im implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "7F43853CDED9232ACA3765709B5C5CC7", hash_generated_method = "9F792EDCCD4BB87BF48243FA7DF53E47")
            @DSModeled(DSC.SAFE)
            private Im() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "DB933F4CCE4B2417E3234A3CAF5584A5", hash_generated_method = "A6E4D3E4D827895C2D526B84B05B7EC5")
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.imTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.imTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.imTypeOther;
                    default: return com.android.internal.R.string.imTypeCustom;
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "2439B316AC02293F1C1BC72135D6806F", hash_generated_method = "7601F5260A424E1A642596C53EDA9D8A")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "719F720CCBDAB5B3884CB87DEE9715B5", hash_generated_method = "05C319BA1E315915AA4D439E1FDBD977")
            public static final CharSequence getProtocolLabel(Resources res, int type,
                    CharSequence label) {
                if (type == PROTOCOL_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getProtocolLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Organization implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "DB9E0507E0CFF6D3A6878FC813F638FB", hash_generated_method = "86CDC8DAAC9D24725921B75CFB0152DA")
            @DSModeled(DSC.SAFE)
            private Organization() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "3DA16CECB36036B59D78BB88E80196B3", hash_generated_method = "91AD13C9A65F98147CABF426F48DD4E5")
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_WORK: return com.android.internal.R.string.orgTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.orgTypeOther;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.193 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Relation implements DataColumnsWithJoins, CommonColumns {
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "AB820511C2318175DFB023ADDE00500D", hash_generated_method = "16C413ED0611D3B2A916528F29365204")
            @DSModeled(DSC.SAFE)
            private Relation() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "DC92F7F77AD275BC3178229A766744FB", hash_generated_method = "51A27705782CDA7F0811032820233425")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Event implements DataColumnsWithJoins, CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            public static final int TYPE_ANNIVERSARY = 1;
            public static final int TYPE_OTHER = 2;
            public static final int TYPE_BIRTHDAY = 3;
            public static final String START_DATE = DATA;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "D3DDD15A13BA6EC1D9CD48C2CCCFE0B4", hash_generated_method = "8E618CD2B3C8E3CA2B7F98B80459403A")
            @DSModeled(DSC.SAFE)
            private Event() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "44A585035560330F504A000D56682C48", hash_generated_method = "D17577314C62A57FCC47AE3081A84877")
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

            
        }


        
        public static final class Photo implements DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            public static final String PHOTO_FILE_ID = DATA14;
            public static final String PHOTO = DATA15;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "2D85DD80A144D36F33275D4A6419D75B")
            @DSModeled(DSC.SAFE)
            private Photo() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Note implements DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            public static final String NOTE = DATA1;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "EBAE52FCFF9289B17EA2262C75B6F6C0", hash_generated_method = "68E52E195DA567961D08E76AC31625A3")
            @DSModeled(DSC.SAFE)
            private Note() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class GroupMembership implements DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/group_membership";
            public static final String GROUP_ROW_ID = DATA1;
            public static final String GROUP_SOURCE_ID = "group_sourceid";
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "6455CBCB097771EA280C661AD3A32623")
            @DSModeled(DSC.SAFE)
            private GroupMembership() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class Website implements DataColumnsWithJoins, CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            public static final int TYPE_HOMEPAGE = 1;
            public static final int TYPE_BLOG = 2;
            public static final int TYPE_PROFILE = 3;
            public static final int TYPE_HOME = 4;
            public static final int TYPE_WORK = 5;
            public static final int TYPE_FTP = 6;
            public static final int TYPE_OTHER = 7;
            public static final String URL = DATA;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.194 -0400", hash_original_method = "CC2DAF060546DD565E4193F5085BC2F2", hash_generated_method = "F6C6D617268CA92026A827B818CF4A68")
            @DSModeled(DSC.SAFE)
            private Website() {
                // ---------- Original Method ----------
            }

            
        }


        
        public static final class SipAddress implements DataColumnsWithJoins, CommonColumns {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            public static final int TYPE_HOME = 1;
            public static final int TYPE_WORK = 2;
            public static final int TYPE_OTHER = 3;
            public static final String SIP_ADDRESS = DATA1;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "7307A74E42B27B76827D43357DA8B367", hash_generated_method = "7464EC37FCB0CCF8EDADE93313863056")
            @DSModeled(DSC.SAFE)
            private SipAddress() {
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "D9A58CDEECC9F427DB69C45B7BC2621A", hash_generated_method = "3A09EC7B1D8BD60AEA44FE340DA1D020")
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.sipAddressTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.sipAddressTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.sipAddressTypeOther;
                    default: return com.android.internal.R.string.sipAddressTypeCustom;
                }
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
        }


        
        public static final class Identity implements DataColumnsWithJoins {
            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            public static final String IDENTITY = DataColumns.DATA1;
            public static final String NAMESPACE = DataColumns.DATA2;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "CB97BE8665681C1FD82290A9CE03A1A5", hash_generated_method = "BFE1C69B5E11F43EE8F56892C31FB4CF")
            @DSModeled(DSC.SAFE)
            private Identity() {
                // ---------- Original Method ----------
            }

            
        }


        
        public interface BaseTypes {
            
            public static int TYPE_CUSTOM = 0;
        }
        
        protected interface CommonColumns extends BaseTypes {
            
            public static final String DATA = DataColumns.DATA1;

            
            public static final String TYPE = DataColumns.DATA2;

            
            public static final String LABEL = DataColumns.DATA3;
        }
        
    }


    
    public static final class Groups implements BaseColumns, GroupsColumns, SyncColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "groups");
        public static final Uri CONTENT_SUMMARY_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "groups_summary");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "E58712013FF7B36A6658A1494B5BFC26")
        @DSModeled(DSC.SAFE)
        private Groups() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "7C8784537648600B4251C9E262BFEFC5", hash_generated_method = "9F167F07FC0CADA08203BAA255DB9A81")
        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "3B59B4CAFFC6405C709C46CE9ED84B82")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                dsTaint.addTaint(cursor.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.195 -0400", hash_original_method = "DDAF6836AC46D694049E3DD971FAB2B5", hash_generated_method = "5F916ABCAC8C36214B32F75EA1881674")
            @DSModeled(DSC.SAFE)
            @Override
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                dsTaint.addTaint(cursor.dsTaint);
                final ContentValues values;
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
                return (Entity)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
    }


    
    public static final class AggregationExceptions implements BaseColumns {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "AEC5F5D30A84CFEC2D9D1903833FB78B", hash_generated_method = "171321AF6B201B2E625585662DDA8C29")
        @DSModeled(DSC.SAFE)
        private AggregationExceptions() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Settings implements SettingsColumns {
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "settings");
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "365127D9A7AD23806BCE93C671023170")
        @DSModeled(DSC.SAFE)
        private Settings() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class ProviderStatus {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "795A4A88B7E0FFCBF277CCA1899F11E6", hash_generated_method = "BBEE064010E6EDA8B135501C35456E66")
        @DSModeled(DSC.SAFE)
        private ProviderStatus() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class DataUsageFeedback {
        public static final Uri FEEDBACK_URI =
                Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
        public static final String USAGE_TYPE = "type";
        public static final String USAGE_TYPE_CALL = "call";
        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
        
    }


    
    public static final class QuickContact {
        public static final String ACTION_QUICK_CONTACT =
                "com.android.contacts.action.QUICK_CONTACT";
        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
        public static final String EXTRA_MODE = "mode";
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        public static final int MODE_SMALL = 1;
        public static final int MODE_MEDIUM = 2;
        public static final int MODE_LARGE = 3;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "718CFEA83C0A766BFE63C0D34638CAC0", hash_generated_method = "3CF162F58BF77AD3CD38447E706C37BE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "55973817E502F758AB5135D809FEAF34", hash_generated_method = "6291C2EA61D352DD30F6A4846A421DB6")
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

        
    }


    
    public static final class DisplayPhoto {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "display_photo");
        public static final Uri CONTENT_MAX_DIMENSIONS_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "photo_dimensions");
        public static final String DISPLAY_MAX_DIM = "display_max_dim";
        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.196 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "E301244D8E4F99AA0567061D7FED0A7C")
        @DSModeled(DSC.SAFE)
        private DisplayPhoto() {
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class Intents {
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
        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
        @Deprecated
        public static final String EXTRA_MODE = "mode";
        @Deprecated
        public static final int MODE_SMALL = 1;
        @Deprecated
        public static final int MODE_MEDIUM = 2;
        @Deprecated
        public static final int MODE_LARGE = 3;
        @Deprecated
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        
        public static final class UI {
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
    
}


