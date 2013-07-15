package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.Semaphore;

public class SearchRecentSuggestions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.484 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.484 -0400", hash_original_field = "2325EF4ABFCA50C092A123BB59FD3F59", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private String mAuthority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.484 -0400", hash_original_field = "2C0B9C980126BA4B48753CA9AA0C4331", hash_generated_field = "9C78137A5E34C9818D08D92469A7DDDE")

    private boolean mTwoLineDisplay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.484 -0400", hash_original_field = "6130C8CF316BD3D09A82233C1E227CAE", hash_generated_field = "474B06C5F572DACCF7230DB8072DB33C")

    private Uri mSuggestionsUri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.485 -0400", hash_original_method = "8094D07E48B5062E08836B26658019CD", hash_generated_method = "C25C2495D9946C63CC9BF73265E0F6C6")
    public  SearchRecentSuggestions(Context context, String authority, int mode) {
    if(TextUtils.isEmpty(authority) ||
                ((mode & SearchRecentSuggestionsProvider.DATABASE_MODE_QUERIES) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_905153999 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_905153999.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_905153999;
        } //End block
        mTwoLineDisplay = (0 != (mode & SearchRecentSuggestionsProvider.DATABASE_MODE_2LINES));
        mContext = context;
        mAuthority = new String(authority);
        mSuggestionsUri = Uri.parse("content://" + mAuthority + "/suggestions");
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority) ||
                //((mode & SearchRecentSuggestionsProvider.DATABASE_MODE_QUERIES) == 0)) {
            //throw new IllegalArgumentException();
        //}
        //mTwoLineDisplay = (0 != (mode & SearchRecentSuggestionsProvider.DATABASE_MODE_2LINES));
        //mContext = context;
        //mAuthority = new String(authority);
        //mSuggestionsUri = Uri.parse("content://" + mAuthority + "/suggestions");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.486 -0400", hash_original_method = "70A1E3C233B875F18C99CFE4264D2F59", hash_generated_method = "163FB5ADD23AA3144F197824AF04B91F")
    public void saveRecentQuery(final String queryString, final String line2) {
        addTaint(line2.getTaint());
        addTaint(queryString.getTaint());
    if(TextUtils.isEmpty(queryString))        
        {
            return;
        } //End block
    if(!mTwoLineDisplay && !TextUtils.isEmpty(line2))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_397939953 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_397939953.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_397939953;
        } //End block
        new Thread("saveRecentQuery") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.486 -0400", hash_original_method = "37361BD815F5FBC7B1A0E9F475B6E93E", hash_generated_method = "90166BB735A77A535840B0E240FF56FA")
        @Override
        public void run() {
            saveRecentQueryBlocking(queryString, line2);
            sWritesInProgress.release();
            // ---------- Original Method ----------
            //saveRecentQueryBlocking(queryString, line2);
            //sWritesInProgress.release();
        }
}.start();
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(queryString)) {
            //return;
        //}
        //if (!mTwoLineDisplay && !TextUtils.isEmpty(line2)) {
            //throw new IllegalArgumentException();
        //}
        //new Thread("saveRecentQuery") {
            //@Override
            //public void run() {
                //saveRecentQueryBlocking(queryString, line2);
                //sWritesInProgress.release();
            //}
        //}.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.486 -0400", hash_original_method = "CEDACB2E58AE40EFB4E2590521E9B487", hash_generated_method = "D05E0A9C5F9AA06C6F19147252F3A696")
     void waitForSave() {
        do {
            {
                sWritesInProgress.acquireUninterruptibly();
            } //End block
} while (sWritesInProgress.availablePermits() > 0);
        // ---------- Original Method ----------
        //do {
            //sWritesInProgress.acquireUninterruptibly();
        //} while (sWritesInProgress.availablePermits() > 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.487 -0400", hash_original_method = "9709D87DB23792EAEE277FC562FC04A5", hash_generated_method = "CDF09F4156F281117FB3595CD621FAAC")
    private void saveRecentQueryBlocking(String queryString, String line2) {
        addTaint(line2.getTaint());
        addTaint(queryString.getTaint());
        ContentResolver cr = mContext.getContentResolver();
        long now = System.currentTimeMillis();
        try 
        {
            ContentValues values = new ContentValues();
            values.put(SuggestionColumns.DISPLAY1, queryString);
    if(mTwoLineDisplay)            
            {
                values.put(SuggestionColumns.DISPLAY2, line2);
            } //End block
            values.put(SuggestionColumns.QUERY, queryString);
            values.put(SuggestionColumns.DATE, now);
            cr.insert(mSuggestionsUri, values);
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        truncateHistory(cr, MAX_HISTORY_COUNT);
        // ---------- Original Method ----------
        //ContentResolver cr = mContext.getContentResolver();
        //long now = System.currentTimeMillis();
        //try {
            //ContentValues values = new ContentValues();
            //values.put(SuggestionColumns.DISPLAY1, queryString);
            //if (mTwoLineDisplay) {
                //values.put(SuggestionColumns.DISPLAY2, line2);
            //}
            //values.put(SuggestionColumns.QUERY, queryString);
            //values.put(SuggestionColumns.DATE, now);
            //cr.insert(mSuggestionsUri, values);
        //} catch (RuntimeException e) {
            //Log.e(LOG_TAG, "saveRecentQuery", e);
        //}
        //truncateHistory(cr, MAX_HISTORY_COUNT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.487 -0400", hash_original_method = "9379C31AF46289752B20FFA616A8CEEF", hash_generated_method = "B8F96B3A0E4F00BD02EA1C8229565130")
    public void clearHistory() {
        ContentResolver cr = mContext.getContentResolver();
        truncateHistory(cr, 0);
        // ---------- Original Method ----------
        //ContentResolver cr = mContext.getContentResolver();
        //truncateHistory(cr, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.488 -0400", hash_original_method = "0EFC2C7DB10B5AB62D9BC5D8C29D3C9A", hash_generated_method = "2941B0C0AE91707F373DD1D8FEA67EB4")
    protected void truncateHistory(ContentResolver cr, int maxEntries) {
        addTaint(maxEntries);
        addTaint(cr.getTaint());
    if(maxEntries < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_786456988 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_786456988.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_786456988;
        } //End block
        try 
        {
            String selection = null;
    if(maxEntries > 0)            
            {
                selection = "_id IN " +
                        "(SELECT _id FROM suggestions" +
                        " ORDER BY " + SuggestionColumns.DATE + " DESC" +
                        " LIMIT -1 OFFSET " + String.valueOf(maxEntries) + ")";
            } //End block
            cr.delete(mSuggestionsUri, selection, null);
        } //End block
        catch (RuntimeException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (maxEntries < 0) {
            //throw new IllegalArgumentException();
        //}
        //try {
            //String selection = null;
            //if (maxEntries > 0) {
                //selection = "_id IN " +
                        //"(SELECT _id FROM suggestions" +
                        //" ORDER BY " + SuggestionColumns.DATE + " DESC" +
                        //" LIMIT -1 OFFSET " + String.valueOf(maxEntries) + ")";
            //}
            //cr.delete(mSuggestionsUri, selection, null);
        //} catch (RuntimeException e) {
            //Log.e(LOG_TAG, "truncateHistory", e);
        //}
    }

    
    private static class SuggestionColumns implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.489 -0400", hash_original_method = "BB858C1043D81D8CD66DDE6CA07AE15D", hash_generated_method = "BB858C1043D81D8CD66DDE6CA07AE15D")
        public SuggestionColumns ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.489 -0400", hash_original_field = "D40A7924385E296986673FD4BB39A1EC", hash_generated_field = "4C20FFD88D15FE183A2FD7C689BC4C8E")

        public static final String DISPLAY1 = "display1";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "2D453E5E728A346FB067BDFF7A4FC18B", hash_generated_field = "6E0628EA9C10950E8DF8845FF414EE62")

        public static final String DISPLAY2 = "display2";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "E9573A331B8428DA480FB44E27613F57", hash_generated_field = "61C7143C9AFD93657C9BFDDC418E3D13")

        public static final String QUERY = "query";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "F0E69C8EA78964FE5493D0AE61D90B08", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "777871676F036C648D0537AE2DCC6237", hash_generated_field = "83CF5D93D7647E05E9E9EB88C1379A3E")

    private static final String LOG_TAG = "SearchSuggestions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "61817BBCE268A8E939167B00F32EB6A8", hash_generated_field = "8948CD79ABAE3891E9B2D20427361862")

    public static final String[] QUERIES_PROJECTION_1LINE = new String[] {
        SuggestionColumns._ID,
        SuggestionColumns.DATE,
        SuggestionColumns.QUERY,
        SuggestionColumns.DISPLAY1,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.490 -0400", hash_original_field = "D85B4326153EC3DF94AAD7681ECBED61", hash_generated_field = "9B30C6D2D52C3F0BF9D830C830B02CD1")

    public static final String[] QUERIES_PROJECTION_2LINE = new String[] {
        SuggestionColumns._ID,
        SuggestionColumns.DATE,
        SuggestionColumns.QUERY,
        SuggestionColumns.DISPLAY1,
        SuggestionColumns.DISPLAY2,
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "BB4CBEEB8AD84FB32C6D6064EBF46CF6", hash_generated_field = "6B56243E2411B8C7ABB9F2B342A51A17")

    public static final int QUERIES_PROJECTION_DATE_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "FD1520E5B36C9CBC2BB5185CB1F71D0A", hash_generated_field = "4096D68BBB16F0235E9688143E1E6746")

    public static final int QUERIES_PROJECTION_QUERY_INDEX = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "9AE2AF2B71EF679A8F28A562BC7790FD", hash_generated_field = "C196F013DFC7347A79C9051D8233C1FB")

    public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "7C04DE6845241BD31B5FEF5D363DC167", hash_generated_field = "7CB1EB71CBC2BEDF603E06F68C40E535")

    public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "2AAA1497EC54D64B6CA370EB4B59B53C", hash_generated_field = "BF6486DDBD625F035F5DD77BB5F2FE07")

    private static final int MAX_HISTORY_COUNT = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:36.491 -0400", hash_original_field = "B1E2B6202C36AAFA2CB63178007F9799", hash_generated_field = "10A476FD002C06ABCB4B050247C842C7")

    private static final Semaphore sWritesInProgress = new Semaphore(0);
}

