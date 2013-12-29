package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Pair;





public class SyncStateContract {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.727 -0400", hash_original_method = "57D9D9CBA9A7CAF29AF0EFFDD8322E47", hash_generated_method = "57D9D9CBA9A7CAF29AF0EFFDD8322E47")
    public SyncStateContract ()
    {
        //Synthesized constructor
    }


    public static class Constants implements Columns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.974 -0500", hash_original_field = "651555897195CAF1D909B047C60B8BCF", hash_generated_field = "FA8A31E4C831AAEF706E8EC3EE0F6F62")

        public static final String CONTENT_DIRECTORY = "syncstate";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.727 -0400", hash_original_method = "E59499DF9DD0978456F50DA5893CC8F6", hash_generated_method = "E59499DF9DD0978456F50DA5893CC8F6")
        public Constants ()
        {
            //Synthesized constructor
        }
    }


    
    public static final class Helpers {

        /**
         * Get the sync state that is associated with the account or null.
         * @param provider the {@link ContentProviderClient} that is to be used to communicate
         * with the {@link android.content.ContentProvider} that contains the sync state.
         * @param uri the uri of the sync state
         * @param account the {@link Account} whose sync state should be returned
         * @return the sync state or null if there is no sync state associated with the account
         * @throws RemoteException if there is a failure communicating with the remote
         * {@link android.content.ContentProvider}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.978 -0500", hash_original_method = "5BAEEA9617C0AA3B35E4E6BB2B33ED19", hash_generated_method = "6A48469F02BB96E63D13AB49D1B5431B")
        public static byte[] get(ContentProviderClient provider, Uri uri,
                Account account) throws RemoteException {
            Cursor c = provider.query(uri, DATA_PROJECTION, SELECT_BY_ACCOUNT,
                    new String[]{account.name, account.type}, null);

            // Unable to query the provider
            if (c == null) {
                throw new RemoteException();
            }

            try {
                if (c.moveToNext()) {
                    return c.getBlob(c.getColumnIndexOrThrow(Columns.DATA));
                }
            } finally {
                c.close();
            }
            return null;
        }

        /**
         * Assigns the data array as the sync state for the given account.
         * @param provider the {@link ContentProviderClient} that is to be used to communicate
         * with the {@link android.content.ContentProvider} that contains the sync state.
         * @param uri the uri of the sync state
         * @param account the {@link Account} whose sync state should be set
         * @param data the byte[] that contains the sync state
         * @throws RemoteException if there is a failure communicating with the remote
         * {@link android.content.ContentProvider}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.979 -0500", hash_original_method = "7175BBC1400E9B9ACF4AC9D742700EC1", hash_generated_method = "2A3FEA68CF5F65D576C531538A0704F2")
        public static void set(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            provider.insert(uri, values);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.980 -0500", hash_original_method = "D67AD736719565B401F7D635C42166E8", hash_generated_method = "AC105E9966F6FEFD78C648C972E83070")
        public static Uri insert(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            return provider.insert(uri, values);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.981 -0500", hash_original_method = "6B723E445C051D3A95A305F12C554D39", hash_generated_method = "5365CA6B8E077F8FB400EE376B2EA021")
        public static void update(ContentProviderClient provider, Uri uri, byte[] data)
                throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            provider.update(uri, values, null, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.982 -0500", hash_original_method = "59C36C2A4187FE21080DCE61B12EC2C5", hash_generated_method = "0FCB2EFB8728B15169BFE14097E5AA6A")
        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Uri uri,
                Account account) throws RemoteException {
            Cursor c = provider.query(uri, DATA_PROJECTION, SELECT_BY_ACCOUNT,
                    new String[]{account.name, account.type}, null);

            if (c == null) {
                throw new RemoteException();
            }

            try {
                if (c.moveToNext()) {
                    long rowId = c.getLong(1);
                    byte[] blob = c.getBlob(c.getColumnIndexOrThrow(Columns.DATA));
                    return Pair.create(ContentUris.withAppendedId(uri, rowId), blob);
                }
            } finally {
                c.close();
            }
            return null;
        }

        /**
         * Creates and returns a ContentProviderOperation that assigns the data array as the
         * sync state for the given account.
         * @param uri the uri of the sync state
         * @param account the {@link Account} whose sync state should be set
         * @param data the byte[] that contains the sync state
         * @return the new ContentProviderOperation that assigns the data array as the
         * account's sync state
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.983 -0500", hash_original_method = "79826C36B2AA82EB741C6DACEAF05E13", hash_generated_method = "6C63AFB549C6A2DEB4BDFF0FC1F8CCE1")
        public static ContentProviderOperation newSetOperation(Uri uri,
                Account account, byte[] data) {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            return ContentProviderOperation
                    .newInsert(uri)
                    .withValue(Columns.ACCOUNT_NAME, account.name)
                    .withValue(Columns.ACCOUNT_TYPE, account.type)
                    .withValues(values)
                    .build();
        }

        /**
         * Creates and returns a ContentProviderOperation that assigns the data array as the
         * sync state for the given account.
         * @param uri the uri of the specific sync state to set
         * @param data the byte[] that contains the sync state
         * @return the new ContentProviderOperation that assigns the data array as the
         * account's sync state
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.984 -0500", hash_original_method = "03ED4805F1B71684BC51E366A02690AE", hash_generated_method = "6FA53809A465BFB793C30C8A79112408")
        public static ContentProviderOperation newUpdateOperation(Uri uri, byte[] data) {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            return ContentProviderOperation
                    .newUpdate(uri)
                    .withValues(values)
                    .build();
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.976 -0500", hash_original_field = "8E3B6E5B5B6C1C46EF7E5E8AF66B7835", hash_generated_field = "16F80F154C043273B4490EE306B3A865")

        private static final String[] DATA_PROJECTION = new String[]{Columns.DATA, Columns._ID};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:45.977 -0500", hash_original_field = "0CF736763CCB8427EEB4E54AF4D3539B", hash_generated_field = "CC8FA1F4EE7228ACC08A945BFBF3437B")

        private static final String SELECT_BY_ACCOUNT =
                Columns.ACCOUNT_NAME + "=? AND " + Columns.ACCOUNT_TYPE + "=?";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.728 -0400", hash_original_method = "9749A8A424C5761B245394E68B42F39B", hash_generated_method = "9749A8A424C5761B245394E68B42F39B")
        public Helpers ()
        {
            //Synthesized constructor
        }
    }


    
    public interface Columns extends BaseColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String DATA = "data";
    }
    
}

