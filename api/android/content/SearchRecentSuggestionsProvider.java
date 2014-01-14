package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.app.SearchManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;

public class SearchRecentSuggestionsProvider extends ContentProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.273 -0500", hash_original_field = "99D462A983ED8807DC3FD5EF474B4F2C", hash_generated_field = "B0E1D7C3FF742238FED651F73F9C940A")

    private static final String TAG = "SuggestionsProvider";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.284 -0500", hash_original_field = "5C129B925E633152CFBD7ABE76C90ED7", hash_generated_field = "48D2DF6A8AEC894ADA5705E319C23EAE")

    private static final String sDatabaseName = "suggestions.db";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.286 -0500", hash_original_field = "8C53FA3D2B2810205042447C97E34377", hash_generated_field = "57F77DA6F947E6544C7754D90AC8B874")

    private static final String sSuggestions = "suggestions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.289 -0500", hash_original_field = "CB402A0518E9D7A2A76CFB4A4091D87B", hash_generated_field = "8E4DC53338B9A8C9461F6C695ACB0AD0")

    private static final String ORDER_BY = "date DESC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.291 -0500", hash_original_field = "B306C2D2BD30651CB725CD5AEC52F136", hash_generated_field = "340612B392192217455628392DBD44D6")

    private static final String NULL_COLUMN = "query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.294 -0500", hash_original_field = "3687FA5906181799EE91A72470A6F734", hash_generated_field = "73936EAB54B9E2FB7D018B9F201FA540")

    // NOTE:  These version values are shifted left 8 bits (x 256) in order to create space for
    // a small set of mode bitflags in the version int.
    //
    // 1      original implementation with queries, and 1 or 2 display columns
    // 1->2   added UNIQUE constraint to display1 column
    private static final int DATABASE_VERSION = 2 * 256;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.296 -0500", hash_original_field = "0072A49E60196ECCB358F3B5341C4B2C", hash_generated_field = "E35B80185FCB1D4B9E5E92D2D867212A")

    public static final int DATABASE_MODE_QUERIES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.298 -0500", hash_original_field = "565222A4C289DB10696C6136A31A4BFC", hash_generated_field = "A1D1955602EC18263FD6A326A5386D33")

    public static final int DATABASE_MODE_2LINES = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.301 -0500", hash_original_field = "2B6D6C0F7035FE880F6B793A82419D3D", hash_generated_field = "11E4D2BF5D0DD08F8B44D57153614D99")

    private static final int URI_MATCH_SUGGEST = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.275 -0500", hash_original_field = "BC4522E788A053F96319766AEE95ACCB", hash_generated_field = "5E9A5C7D075BBF710B4D594B2F64B868")

    private String mAuthority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.277 -0500", hash_original_field = "556F09336B3BD1BEFE7C8BF0B32BAF35", hash_generated_field = "B9E13EBC2196F570555262A42E5818EF")

    private int mMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.279 -0500", hash_original_field = "671000407E7D4220CBD952C076CC82E3", hash_generated_field = "9C78137A5E34C9818D08D92469A7DDDE")

    private boolean mTwoLineDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.281 -0500", hash_original_field = "659852B664125C87A616C9075D12A8A4", hash_generated_field = "A3AB1DCCDB0859AC3C99EF131C021999")

    private SQLiteOpenHelper mOpenHelper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.303 -0500", hash_original_field = "EDAEBB8E2B258706A464C373C3F3FEF0", hash_generated_field = "474B06C5F572DACCF7230DB8072DB33C")
    
    private Uri mSuggestionsUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.305 -0500", hash_original_field = "F8487BE5320E665AECB6706984C45078", hash_generated_field = "2FC625BBB545DBD2933174B07F6C1795")

    private UriMatcher mUriMatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.307 -0500", hash_original_field = "15C04798C042CAF231F2A354D2CDE48B", hash_generated_field = "BC8EF6A22053F5C6D2A036FACDF0B4A4")
    
    private String mSuggestSuggestionClause;
    
    private static class DatabaseHelper extends SQLiteOpenHelper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.312 -0500", hash_original_field = "DFB46BFB455BC2DB80FA7B3ECF0B7992", hash_generated_field = "E37741801665C28F1D0231A69288300D")
        
        private int mNewVersion;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.316 -0500", hash_original_method = "B1DAC55CA2505DC3136A6C56FC8EE7EF", hash_generated_method = "22C5A75C9BF722D665D01DD9818E5036")
        
public DatabaseHelper(Context context, int newVersion) {
            super(context, sDatabaseName, null, newVersion);
            mNewVersion = newVersion;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.318 -0500", hash_original_method = "E06D1FEB96F210607100333501CDD83C", hash_generated_method = "B44680B161F7820D72CF93C685862590")
        
@Override
        public void onCreate(SQLiteDatabase db) {
            StringBuilder builder = new StringBuilder();
            builder.append("CREATE TABLE suggestions (" +
                    "_id INTEGER PRIMARY KEY" +
                    ",display1 TEXT UNIQUE ON CONFLICT REPLACE");
            if (0 != (mNewVersion & DATABASE_MODE_2LINES)) {
                builder.append(",display2 TEXT");
            }
            builder.append(",query TEXT" +
                    ",date LONG" +
                    ");");
            db.execSQL(builder.toString());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.321 -0500", hash_original_method = "2B559659D3FF90972195D37AA84A3E73", hash_generated_method = "0A6E17F1C5499604943C45262A35419F")
        
@Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS suggestions");
            onCreate(db);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.309 -0500", hash_original_field = "30277FB1D57ED24A73776A5B7FAA67C0", hash_generated_field = "A57E41BCBB900DBD0AC3878DC7781CBD")

    private String[] mSuggestionProjection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.785 -0400", hash_original_method = "0A26B49425F8122D436D3AFA62ACEDE1", hash_generated_method = "0A26B49425F8122D436D3AFA62ACEDE1")
    public SearchRecentSuggestionsProvider ()
    {
        //Synthesized constructor
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.789 -0400", hash_original_method = "E16CA3DFE54EBEC32586C921FDE66A1B", hash_generated_method = "9FEFF2961B2F4BBD03A4AA7D913329B1")
    protected void setupSuggestions(String authority, int mode) {
        if(TextUtils.isEmpty(authority) || 
                ((mode & DATABASE_MODE_QUERIES) == 0))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1093189208 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1093189208.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1093189208;
        } //End block
        mTwoLineDisplay = (0 != (mode & DATABASE_MODE_2LINES));
        mAuthority = new String(authority);
        mMode = mode;
        mSuggestionsUri = Uri.parse("content://" + mAuthority + "/suggestions");
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(mAuthority, SearchManager.SUGGEST_URI_PATH_QUERY, URI_MATCH_SUGGEST);
        if(mTwoLineDisplay)        
        {
            mSuggestSuggestionClause = "display1 LIKE ? OR display2 LIKE ?";
            mSuggestionProjection = new String [] {
                    "0 AS " + SearchManager.SUGGEST_COLUMN_FORMAT,
                    "'android.resource://system/"
                            + com.android.internal.R.drawable.ic_menu_recent_history + "' AS "
                            + SearchManager.SUGGEST_COLUMN_ICON_1,
                    "display1 AS " + SearchManager.SUGGEST_COLUMN_TEXT_1,
                    "display2 AS " + SearchManager.SUGGEST_COLUMN_TEXT_2,
                    "query AS " + SearchManager.SUGGEST_COLUMN_QUERY,
                    "_id"
            };
        } //End block
        else
        {
            mSuggestSuggestionClause = "display1 LIKE ?";
            mSuggestionProjection = new String [] {
                    "0 AS " + SearchManager.SUGGEST_COLUMN_FORMAT,
                    "'android.resource://system/"
                            + com.android.internal.R.drawable.ic_menu_recent_history + "' AS "
                            + SearchManager.SUGGEST_COLUMN_ICON_1,
                    "display1 AS " + SearchManager.SUGGEST_COLUMN_TEXT_1,
                    "query AS " + SearchManager.SUGGEST_COLUMN_QUERY,
                    "_id"
            };
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.328 -0500", hash_original_method = "7D0F511FF715F3B1AC0B77B3BBE41D35", hash_generated_method = "C81206D625A5153C836324BB767FFA60")
    
@Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        final int length = uri.getPathSegments().size();
        if (length != 1) {
            throw new IllegalArgumentException("Unknown Uri");
        }

        final String base = uri.getPathSegments().get(0);
        int count = 0;
        if (base.equals(sSuggestions)) {
            count = db.delete(sSuggestions, selection, selectionArgs);
        } else {
            throw new IllegalArgumentException("Unknown Uri");
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.330 -0500", hash_original_method = "ACCB8C00D81DE098BA99F6628F676962", hash_generated_method = "4AE0395EC9DF9A83EA80402F451D08B3")
    
@Override
    public String getType(Uri uri) {
        if (mUriMatcher.match(uri) == URI_MATCH_SUGGEST) {
            return SearchManager.SUGGEST_MIME_TYPE;
        }
        int length = uri.getPathSegments().size();
        if (length >= 1) {
            String base = uri.getPathSegments().get(0);
            if (base.equals(sSuggestions)) {
                if (length == 1) {
                    return "vnd.android.cursor.dir/suggestion";
                } else if (length == 2) {
                    return "vnd.android.cursor.item/suggestion";
                }
            }
        }            
        throw new IllegalArgumentException("Unknown Uri");
    }

    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.333 -0500", hash_original_method = "FF93685A731F041589830914387F684E", hash_generated_method = "DAE8DAF97A43F3074EF7328285694A01")
    
@Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();

        int length = uri.getPathSegments().size();
        if (length < 1) {
            throw new IllegalArgumentException("Unknown Uri");
        }
        // Note:  This table has on-conflict-replace semantics, so insert() may actually replace()
        long rowID = -1;
        String base = uri.getPathSegments().get(0);
        Uri newUri = null;
        if (base.equals(sSuggestions)) {
            if (length == 1) {
                rowID = db.insert(sSuggestions, NULL_COLUMN, values);
                if (rowID > 0) {
                    newUri = Uri.withAppendedPath(mSuggestionsUri, String.valueOf(rowID));
                }
            }
        }
        if (rowID < 0) {
            throw new IllegalArgumentException("Unknown Uri");
        }
        getContext().getContentResolver().notifyChange(newUri, null);
        return newUri;
    }

    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.336 -0500", hash_original_method = "B13C0C999B2C074C09328C18BB8361D9", hash_generated_method = "99D5ADBFBB3091B574273ECDB20FDE01")
    
@Override
    public boolean onCreate() {
        if (mAuthority == null || mMode == 0) {
            throw new IllegalArgumentException("Provider not configured");
        }
        int mWorkingDbVersion = DATABASE_VERSION + mMode;
        mOpenHelper = new DatabaseHelper(getContext(), mWorkingDbVersion);
        
        return true;
    }

    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    // TODO: Confirm no injection attacks here, or rewrite.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.341 -0500", hash_original_method = "16EE4F46EB7789D35890A8E3BA57F4D4", hash_generated_method = "463FD15163F5D67D8EDFE23F03AFFBAD")
    
@Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, 
            String sortOrder) {
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        
        // special case for actual suggestions (from search manager)
        if (mUriMatcher.match(uri) == URI_MATCH_SUGGEST) {
            String suggestSelection;
            String[] myArgs;
            if (TextUtils.isEmpty(selectionArgs[0])) {
                suggestSelection = null;
                myArgs = null;
            } else {
                String like = "%" + selectionArgs[0] + "%";
                if (mTwoLineDisplay) {
                    myArgs = new String [] { like, like };
                } else {
                    myArgs = new String [] { like };
                }
                suggestSelection = mSuggestSuggestionClause;
            }
            // Suggestions are always performed with the default sort order
            Cursor c = db.query(sSuggestions, mSuggestionProjection,
                    suggestSelection, myArgs, null, null, ORDER_BY, null);
            c.setNotificationUri(getContext().getContentResolver(), uri);
            return c;
        }

        // otherwise process arguments and perform a standard query
        int length = uri.getPathSegments().size();
        if (length != 1 && length != 2) {
            throw new IllegalArgumentException("Unknown Uri");
        }

        String base = uri.getPathSegments().get(0);
        if (!base.equals(sSuggestions)) {
            throw new IllegalArgumentException("Unknown Uri");
        }

        String[] useProjection = null;
        if (projection != null && projection.length > 0) {
            useProjection = new String[projection.length + 1];
            System.arraycopy(projection, 0, useProjection, 0, projection.length);
            useProjection[projection.length] = "_id AS _id";
        }

        StringBuilder whereClause = new StringBuilder(256);
        if (length == 2) {
            whereClause.append("(_id = ").append(uri.getPathSegments().get(1)).append(")");
        }

        // Tack on the user's selection, if present
        if (selection != null && selection.length() > 0) {
            if (whereClause.length() > 0) {
                whereClause.append(" AND ");
            }

            whereClause.append('(');
            whereClause.append(selection);
            whereClause.append(')');
        }
        
        // And perform the generic query as requested
        Cursor c = db.query(base, useProjection, whereClause.toString(),
                selectionArgs, null, null, sortOrder,
                null);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    /**
     * This method is provided for use by the ContentResolver.  Do not override, or directly
     * call from your own code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:28.343 -0500", hash_original_method = "55DFD7752393168BC8C4EABC7763F14D", hash_generated_method = "75244C1F8C529C54B3B1868ED3701E91")
    
@Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implemented");
    }
}

