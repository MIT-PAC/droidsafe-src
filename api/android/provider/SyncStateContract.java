package android.provider;

// Droidsafe Imports
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.727 -0400", hash_original_method = "E59499DF9DD0978456F50DA5893CC8F6", hash_generated_method = "E59499DF9DD0978456F50DA5893CC8F6")
        public Constants ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.727 -0400", hash_original_field = "A3998A2226F391887143F6182498BE88", hash_generated_field = "FA8A31E4C831AAEF706E8EC3EE0F6F62")

        public static final String CONTENT_DIRECTORY = "syncstate";
    }


    
    public static final class Helpers {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.728 -0400", hash_original_method = "9749A8A424C5761B245394E68B42F39B", hash_generated_method = "9749A8A424C5761B245394E68B42F39B")
        public Helpers ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        public static byte[] get(ContentProviderClient provider, Uri uri,
                Account account) throws RemoteException {
            Cursor c = provider.query(uri, DATA_PROJECTION, SELECT_BY_ACCOUNT,
                    new String[]{account.name, account.type}, null);
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

        
        @DSModeled(DSC.SPEC)
        public static void set(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            provider.insert(uri, values);
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri insert(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            return provider.insert(uri, values);
        }

        
        @DSModeled(DSC.SPEC)
        public static void update(ContentProviderClient provider, Uri uri, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            provider.update(uri, values, null, null);
        }

        
        @DSModeled(DSC.SPEC)
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

        
        @DSModeled(DSC.SPEC)
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

        
        @DSModeled(DSC.SPEC)
        public static ContentProviderOperation newUpdateOperation(Uri uri, byte[] data) {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            return ContentProviderOperation
                    .newUpdate(uri)
                    .withValues(values)
                    .build();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.729 -0400", hash_original_field = "67466F5088A2454BA84DE190FF255DB2", hash_generated_field = "16F80F154C043273B4490EE306B3A865")

        private static final String[] DATA_PROJECTION = new String[]{Columns.DATA, Columns._ID};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.729 -0400", hash_original_field = "B50704C91C2FA0071A2DE9645CF6C0F4", hash_generated_field = "CC8FA1F4EE7228ACC08A945BFBF3437B")

        private static final String SELECT_BY_ACCOUNT = Columns.ACCOUNT_NAME + "=? AND " + Columns.ACCOUNT_TYPE + "=?";
    }


    
    public interface Columns extends BaseColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String DATA = "data";
    }
    
}

