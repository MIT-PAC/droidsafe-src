package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.Uri;
import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.accounts.Account;
import android.database.Cursor;
import android.os.RemoteException;
import android.util.Pair;

public class SyncStateContract {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.008 -0400", hash_original_method = "B24E0234ACB6CF872DFA47329BAAF4B6", hash_generated_method = "B24E0234ACB6CF872DFA47329BAAF4B6")
        public SyncStateContract ()
    {
    }


    public static class Constants implements Columns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.008 -0400", hash_original_method = "404BF387A93CDF279F9DC8890EE31A59", hash_generated_method = "404BF387A93CDF279F9DC8890EE31A59")
                public Constants ()
        {
        }


        public static final String CONTENT_DIRECTORY = "syncstate";
    }


    
    public static final class Helpers {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.008 -0400", hash_original_method = "25F5BA4AE912F3F3CD855478D073B471", hash_generated_method = "25F5BA4AE912F3F3CD855478D073B471")
                public Helpers ()
        {
        }


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

        
                public static void set(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            provider.insert(uri, values);
        }

        
                public static Uri insert(ContentProviderClient provider, Uri uri,
                Account account, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            values.put(Columns.ACCOUNT_NAME, account.name);
            values.put(Columns.ACCOUNT_TYPE, account.type);
            return provider.insert(uri, values);
        }

        
                public static void update(ContentProviderClient provider, Uri uri, byte[] data) throws RemoteException {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            provider.update(uri, values, null, null);
        }

        
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

        
                public static ContentProviderOperation newUpdateOperation(Uri uri, byte[] data) {
            ContentValues values = new ContentValues();
            values.put(Columns.DATA, data);
            return ContentProviderOperation
                    .newUpdate(uri)
                    .withValues(values)
                    .build();
        }

        
        private static final String[] DATA_PROJECTION = new String[]{Columns.DATA, Columns._ID};
        private static final String SELECT_BY_ACCOUNT =
                Columns.ACCOUNT_NAME + "=? AND " + Columns.ACCOUNT_TYPE + "=?";
    }


    
    public interface Columns extends BaseColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String DATA = "data";
    }
    
}

