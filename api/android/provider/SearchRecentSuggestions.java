package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.concurrent.Semaphore;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.net.Uri;
import android.text.TextUtils;

public class SearchRecentSuggestions {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.965 -0500", hash_original_field = "DE2A394F7B6C2556435D3DDBACC95E2C", hash_generated_field = "83CF5D93D7647E05E9E9EB88C1379A3E")

    private static final String LOG_TAG = "SearchSuggestions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.980 -0500", hash_original_field = "FBFB92C55AD066E0B85285653E596473", hash_generated_field = "3B7FD1627016148392C3DD3385EC693A")

    /**
     * This is the database projection that can be used to view saved queries, when
     * configured for one-line operation.
     */
    public static final String[] QUERIES_PROJECTION_1LINE = new String[] {
        SuggestionColumns._ID,
        SuggestionColumns.DATE,
        SuggestionColumns.QUERY,
        SuggestionColumns.DISPLAY1,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.982 -0500", hash_original_field = "4762377235A80FA4BDF1D00417E34C84", hash_generated_field = "84ADE51B6A2C9C17BB13DC56E3A55A39")

    /**
     * This is the database projection that can be used to view saved queries, when
     * configured for two-line operation.
     */
    public static final String[] QUERIES_PROJECTION_2LINE = new String[] {
        SuggestionColumns._ID,
        SuggestionColumns.DATE,
        SuggestionColumns.QUERY,
        SuggestionColumns.DISPLAY1,
        SuggestionColumns.DISPLAY2,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.985 -0500", hash_original_field = "73269E3BAF5F38D48FF6F56B486D4313", hash_generated_field = "7B5DF2211EC0974DD32B448A0535485E")

    /** Index into the provided query projections.  For use with Cursor.update methods. */
    public static final int QUERIES_PROJECTION_DATE_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.988 -0500", hash_original_field = "0B727DE61B1E406829A1F293C4480A15", hash_generated_field = "4096D68BBB16F0235E9688143E1E6746")

    public static final int QUERIES_PROJECTION_QUERY_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.990 -0500", hash_original_field = "AF9AAC27FAC772014A9B39AEC9B86D37", hash_generated_field = "C196F013DFC7347A79C9051D8233C1FB")

    public static final int QUERIES_PROJECTION_DISPLAY1_INDEX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.993 -0500", hash_original_field = "132606B3D3398630EF25CEBD041807A3", hash_generated_field = "7CB1EB71CBC2BEDF603E06F68C40E535")

    public static final int QUERIES_PROJECTION_DISPLAY2_INDEX = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.995 -0500", hash_original_field = "C82910879C292C21BA69457BB73148F8", hash_generated_field = "FF675A23123BD79B2D764781FDE6166C")

    /*
     * Set a cap on the count of items in the suggestions table, to
     * prevent db and layout operations from dragging to a crawl. Revisit this
     * cap when/if db/layout performance improvements are made.
     */
    private static final int MAX_HISTORY_COUNT = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.006 -0500", hash_original_field = "1E8EB0344CC41644AAD8FE28A89758B0", hash_generated_field = "10A476FD002C06ABCB4B050247C842C7")

    private static final Semaphore sWritesInProgress = new Semaphore(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.997 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
    
    private static class SuggestionColumns implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.969 -0500", hash_original_field = "1F02AE2A2A3698D98A835DE2FB2A3AD8", hash_generated_field = "4C20FFD88D15FE183A2FD7C689BC4C8E")

        public static final String DISPLAY1 = "display1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.971 -0500", hash_original_field = "8036F3C197B403D71E096416D1F32339", hash_generated_field = "6E0628EA9C10950E8DF8845FF414EE62")

        public static final String DISPLAY2 = "display2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.973 -0500", hash_original_field = "A973C6A881D51091815AA2E1EB8D05BB", hash_generated_field = "61C7143C9AFD93657C9BFDDC418E3D13")

        public static final String QUERY = "query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.976 -0500", hash_original_field = "5B6FCEF8C44CB783DFFC37049083A6ED", hash_generated_field = "FDAA1E4DCD8393137807C1AA22ED16F2")

        public static final String DATE = "date";
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.510 -0400", hash_original_method = "BB858C1043D81D8CD66DDE6CA07AE15D", hash_generated_method = "BB858C1043D81D8CD66DDE6CA07AE15D")
        public SuggestionColumns ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:02.999 -0500", hash_original_field = "BC4522E788A053F96319766AEE95ACCB", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private  String mAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.001 -0500", hash_original_field = "671000407E7D4220CBD952C076CC82E3", hash_generated_field = "9C78137A5E34C9818D08D92469A7DDDE")

    private  boolean mTwoLineDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.003 -0500", hash_original_field = "EDAEBB8E2B258706A464C373C3F3FEF0", hash_generated_field = "474B06C5F572DACCF7230DB8072DB33C")

    private  Uri mSuggestionsUri;
    
    @DSComment("accessing search suggestion DB")
    @DSSpec(DSCat.SECURITY)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.504 -0400", hash_original_method = "8094D07E48B5062E08836B26658019CD", hash_generated_method = "42BF0D6891589DF34793D10264472060")
    public  SearchRecentSuggestions(Context context, String authority, int mode) {
        if(TextUtils.isEmpty(authority) ||
                ((mode & SearchRecentSuggestionsProvider.DATABASE_MODE_QUERIES) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_112960440 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_112960440.addTaint(getTaint());
            throw var5783EF97022AA508B74A1E3EA38534AF_112960440;
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

    /**
     * Add a query to the recent queries list.  Returns immediately, performing the save
     * in the background.
     *
     * @param queryString The string as typed by the user.  This string will be displayed as
     * the suggestion, and if the user clicks on the suggestion, this string will be sent to your
     * searchable activity (as a new search query).
     * @param line2 If you have configured your recent suggestions provider with
     * {@link android.content.SearchRecentSuggestionsProvider#DATABASE_MODE_2LINES}, you can
     * pass a second line of text here.  It will be shown in a smaller font, below the primary
     * suggestion.  When typing, matches in either line of text will be displayed in the list.
     * If you did not configure two-line mode, or if a given suggestion does not have any
     * additional text to display, you can pass null here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.014 -0500", hash_original_method = "70A1E3C233B875F18C99CFE4264D2F59", hash_generated_method = "32E7D90A3ECA61D592C2E9D49A110CAD")
    
public void saveRecentQuery(final String queryString, final String line2) {
        if (TextUtils.isEmpty(queryString)) {
            return;
        }
        if (!mTwoLineDisplay && !TextUtils.isEmpty(line2)) {
            throw new IllegalArgumentException();
        }

        new Thread("saveRecentQuery") {
            @Override
            public void run() {
                saveRecentQueryBlocking(queryString, line2);
                sWritesInProgress.release();
            }
        }.start();
    }

    // Visible for testing.
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.016 -0500", hash_original_method = "CEDACB2E58AE40EFB4E2590521E9B487", hash_generated_method = "5CB8BDED8225B2ACE71C54BBA8B1237C")
    
void waitForSave() {
        // Acquire writes semaphore until there is nothing available.
        // This is to clean up after any previous callers to saveRecentQuery
        // who did not also call waitForSave().
        do {
            sWritesInProgress.acquireUninterruptibly();
        } while (sWritesInProgress.availablePermits() > 0);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.019 -0500", hash_original_method = "9709D87DB23792EAEE277FC562FC04A5", hash_generated_method = "FC6F5F01764156C7D856570F5C5CCFE4")
    
private void saveRecentQueryBlocking(String queryString, String line2) {
        ContentResolver cr = mContext.getContentResolver();
        long now = System.currentTimeMillis();

        // Use content resolver (not cursor) to insert/update this query
        try {
            ContentValues values = new ContentValues();
            values.put(SuggestionColumns.DISPLAY1, queryString);
            if (mTwoLineDisplay) {
                values.put(SuggestionColumns.DISPLAY2, line2);
            }
            values.put(SuggestionColumns.QUERY, queryString);
            values.put(SuggestionColumns.DATE, now);
            cr.insert(mSuggestionsUri, values);
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "saveRecentQuery", e);
        }

        // Shorten the list (if it has become too long)
        truncateHistory(cr, MAX_HISTORY_COUNT);
    }

    /**
     * Completely delete the history.  Use this call to implement a "clear history" UI.
     *
     * Any application that implements search suggestions based on previous actions (such as
     * recent queries, page/items viewed, etc.) should provide a way for the user to clear the
     * history.  This gives the user a measure of privacy, if they do not wish for their recent
     * searches to be replayed by other users of the device (via suggestions).
     */
    @DSComment("clear history, could be the hidden one")
    @DSSpec(DSCat.SECURITY)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.021 -0500", hash_original_method = "9379C31AF46289752B20FFA616A8CEEF", hash_generated_method = "61FE23FE6BF777E9A110DE8EC3BB1869")
    
public void clearHistory() {
        ContentResolver cr = mContext.getContentResolver();
        truncateHistory(cr, 0);
    }

    /**
     * Reduces the length of the history table, to prevent it from growing too large.
     *
     * @param cr Convenience copy of the content resolver.
     * @param maxEntries Max entries to leave in the table. 0 means remove all entries.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:03.023 -0500", hash_original_method = "0EFC2C7DB10B5AB62D9BC5D8C29D3C9A", hash_generated_method = "4CC284166F1D9E8EDAD728C9AB1ED2BD")
    
protected void truncateHistory(ContentResolver cr, int maxEntries) {
        if (maxEntries < 0) {
            throw new IllegalArgumentException();
        }

        try {
            // null means "delete all".  otherwise "delete but leave n newest"
            String selection = null;
            if (maxEntries > 0) {
                selection = "_id IN " +
                        "(SELECT _id FROM suggestions" +
                        " ORDER BY " + SuggestionColumns.DATE + " DESC" +
                        " LIMIT -1 OFFSET " + String.valueOf(maxEntries) + ")";
            }
            cr.delete(mSuggestionsUri, selection, null);
        } catch (RuntimeException e) {
            Log.e(LOG_TAG, "truncateHistory", e);
        }
    }
}

