package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;

public abstract class ContentProvider implements ComponentCallbacks2 {

    /**
     * Given an IContentProvider, try to coerce it back to the real
     * ContentProvider object if it is running in the local process.  This can
     * be used if you know you are running in the same process as a provider,
     * and want to get direct access to its implementation details.  Most
     * clients should not nor have a reason to use it.
     *
     * @param abstractInterface The ContentProvider interface that is to be
     *              coerced.
     * @return If the IContentProvider is non-null and local, returns its actual
     * ContentProvider instance.  Otherwise returns null.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.665 -0500", hash_original_method = "78A656DFF4A6B0DA3835B9463B1DFC23", hash_generated_method = "18651F5EF5004371CFE478157CEAA5FB")
    
public static ContentProvider coerceToLocalContentProvider(
            IContentProvider abstractInterface) {
        if (abstractInterface instanceof Transport) {
            return ((Transport)abstractInterface).getContentProvider();
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.642 -0500", hash_original_field = "F47248520F047763F9F5FB6872AE78D0", hash_generated_field = "DA15E6471BF02EF7674EB3675F3C058F")

    private static final String TAG = "ContentProvider";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.644 -0500", hash_original_field = "03913333DF6D90B31124AA237C7E0708", hash_generated_field = "64C2E29345D1A72D78C884235FF4120B")

    private Context mContext = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.646 -0500", hash_original_field = "635588DF3C0CEE4FAA84410695C60BE1", hash_generated_field = "BAE02AD4841B16814759F68D3AA9D00B")

    private int mMyUid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.648 -0500", hash_original_field = "0B7B2AB1443DB02C5890E2A60E4ADF39", hash_generated_field = "F91CBC541AE5EA168107190D1A494CD8")

    private String mReadPermission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.651 -0500", hash_original_field = "0AE0E3A6ECCA53A0F777E2FEEBA3D79B", hash_generated_field = "02101D3B9ECFAAEB0689EF2DAEF4A808")

    private String mWritePermission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.653 -0500", hash_original_field = "580D562B2B2CECCCBFF826DDC1ECFA8D", hash_generated_field = "15E0F7E05B281A905081D65ED9192FDD")

    private PathPermission[] mPathPermissions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.655 -0500", hash_original_field = "AF811E4BF583CA40A521EDC5C05528AC", hash_generated_field = "5F31C09AB3C1B6A6E2600C83F2928ABF")

    private boolean mExported;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.657 -0500", hash_original_field = "2D5E29FC7BC3EDC39507E0A8AD5A6CDE", hash_generated_field = "B996B8C49C2307FDF0CA3803832CA9DC")

    private Transport mTransport = new Transport();

    /**
     * Construct a ContentProvider instance.  Content providers must be
     * <a href="{@docRoot}guide/topics/manifest/provider-element.html">declared
     * in the manifest</a>, accessed with {@link ContentResolver}, and created
     * automatically by the system, so applications usually do not create
     * ContentProvider instances directly.
     *
     * <p>At construction time, the object is uninitialized, and most fields and
     * methods are unavailable.  Subclasses should initialize themselves in
     * {@link #onCreate}, not the constructor.
     *
     * <p>Content providers are created on the application main thread at
     * application launch time.  The constructor must not perform lengthy
     * operations, or application startup will be delayed.
     */
    @DSComment("Interface/abstract method")
    @DSSpec(DSCat.TO_MODEL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.659 -0500", hash_original_method = "F039A73ADD81439EFEE4572A926905FF", hash_generated_method = "95D9FE26934D919F164145BD4B52277D")
    
public ContentProvider() {
    }

    /**
     * Constructor just for mocking.
     *
     * @param context A Context object which should be some mock instance (like the
     * instance of {@link android.test.mock.MockContext}).
     * @param readPermission The read permision you want this instance should have in the
     * test, which is available via {@link #getReadPermission()}.
     * @param writePermission The write permission you want this instance should have
     * in the test, which is available via {@link #getWritePermission()}.
     * @param pathPermissions The PathPermissions you want this instance should have
     * in the test, which is available via {@link #getPathPermissions()}.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.662 -0500", hash_original_method = "40393AF8078D8D6FEE29B00460ADF530", hash_generated_method = "2503DC7072D31FA560B9D85C6DD1B595")
    
public ContentProvider(
            Context context,
            String readPermission,
            String writePermission,
            PathPermission[] pathPermissions) {
        mContext = context;
        mReadPermission = readPermission;
        mWritePermission = writePermission;
        mPathPermissions = pathPermissions;
    }

    /**
     * Retrieves the Context this provider is running in.  Only available once
     * {@link #onCreate} has been called -- this will return null in the
     * constructor.
     */
    @DSComment("not sensitive, get get member variable")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.712 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DDB999668EFCAD36DFA58D5D665B592E")
    
public final Context getContext() {
        return mContext;
    }

    /**
     * Change the permission required to read data from the content
     * provider.  This is normally set for you from its manifest information
     * when the provider is first created.
     *
     * @param permission Name of the permission required for read-only access.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.715 -0500", hash_original_method = "C738A12EDF7704A3BEC0DFE17330C819", hash_generated_method = "82F267FFBAE4532B7D9DAA2198E71A91")
    
protected final void setReadPermission(String permission) {
        mReadPermission = permission;
    }

    /**
     * Return the name of the permission required for read-only access to
     * this content provider.  This method can be called from multiple
     * threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.717 -0500", hash_original_method = "5C94FD95ADD3C0054247C1BF6F500E4F", hash_generated_method = "96E0D1B36B11378092A878FC95D0CD31")
    
public final String getReadPermission() {
        return mReadPermission;
    }

    /**
     * Change the permission required to read and write data in the content
     * provider.  This is normally set for you from its manifest information
     * when the provider is first created.
     *
     * @param permission Name of the permission required for read/write access.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.720 -0500", hash_original_method = "6A71B3652F16CF9160129E3EF306B0DC", hash_generated_method = "28B4137B8E687A8D615858576F02CD04")
    
protected final void setWritePermission(String permission) {
        mWritePermission = permission;
    }

    /**
     * Return the name of the permission required for read/write access to
     * this content provider.  This method can be called from multiple
     * threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.722 -0500", hash_original_method = "7A0A16A9FA1EB10AD9D087C65A3EFFB1", hash_generated_method = "F58F04DF68E541FB73F002F72197DB0A")
    
public final String getWritePermission() {
        return mWritePermission;
    }

    /**
     * Change the path-based permission required to read and/or write data in
     * the content provider.  This is normally set for you from its manifest
     * information when the provider is first created.
     *
     * @param permissions Array of path permission descriptions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.724 -0500", hash_original_method = "16570AF799E31BB65FFA9254DA0AB517", hash_generated_method = "BED16E516A20E36CBDF7DA3DAFBB6E94")
    
protected final void setPathPermissions(PathPermission[] permissions) {
        mPathPermissions = permissions;
    }

    /**
     * Return the path-based permissions required for read and/or write access to
     * this content provider.  This method can be called from multiple
     * threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.726 -0500", hash_original_method = "E38FFC0E115EF293B9FB9C6179B78AA8", hash_generated_method = "1248898CD45F16517D5C9C4A7DD4C0D0")
    
public final PathPermission[] getPathPermissions() {
        return mPathPermissions;
    }

    /**
     * Implement this to initialize your content provider on startup.
     * This method is called for all registered content providers on the
     * application main thread at application launch time.  It must not perform
     * lengthy operations, or application startup will be delayed.
     *
     * <p>You should defer nontrivial initialization (such as opening,
     * upgrading, and scanning databases) until the content provider is used
     * (via {@link #query}, {@link #insert}, etc).  Deferred initialization
     * keeps application startup fast, avoids unnecessary work if the provider
     * turns out not to be needed, and stops database errors (such as a full
     * disk) from halting application launch.
     *
     * <p>If you use SQLite, {@link android.database.sqlite.SQLiteOpenHelper}
     * is a helpful utility class that makes it easy to manage databases,
     * and will automatically defer opening until first use.  If you do use
     * SQLiteOpenHelper, make sure to avoid calling
     * {@link android.database.sqlite.SQLiteOpenHelper#getReadableDatabase} or
     * {@link android.database.sqlite.SQLiteOpenHelper#getWritableDatabase}
     * from this method.  (Instead, override
     * {@link android.database.sqlite.SQLiteOpenHelper#onOpen} to initialize the
     * database when it is first opened.)
     *
     * @return true if the provider was successfully loaded, false otherwise
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.729 -0500", hash_original_method = "78AC53FE8458AA47A6209768E85AFA18", hash_generated_method = "915CAB1C7F690011FFEC68CBE5589F8A")
    
public abstract boolean onCreate();

    /**
     * {@inheritDoc}
     * This method is always called on the application main thread, and must
     * not perform lengthy operations.
     *
     * <p>The default content provider implementation does nothing.
     * Override this method to take appropriate action.
     * (Content providers do not usually care about things like screen
     * orientation, but may want to know about locale changes.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.731 -0500", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "7225E52F3A5BCFC0B4421616E52468C0")
    
public void onConfigurationChanged(Configuration newConfig) {
    }

    /**
     * {@inheritDoc}
     * This method is always called on the application main thread, and must
     * not perform lengthy operations.
     *
     * <p>The default content provider implementation does nothing.
     * Subclasses may override this method to take appropriate action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.733 -0500", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "79F592DC22C7A97AE301DB7CC367A921")
    
public void onLowMemory() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.735 -0500", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "447804E40C3F002F4A06D23D7AFAFD46")
    
public void onTrimMemory(int level) {
    }

    /**
     * Implement this to handle query requests from clients.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     * <p>
     * Example client call:<p>
     * <pre>// Request a specific record.
     * Cursor managedCursor = managedQuery(
                ContentUris.withAppendedId(Contacts.People.CONTENT_URI, 2),
                projection,    // Which columns to return.
                null,          // WHERE clause.
                null,          // WHERE clause value substitution
                People.NAME + " ASC");   // Sort order.</pre>
     * Example implementation:<p>
     * <pre>// SQLiteQueryBuilder is a helper class that creates the
        // proper SQL syntax for us.
        SQLiteQueryBuilder qBuilder = new SQLiteQueryBuilder();

        // Set the table we're querying.
        qBuilder.setTables(DATABASE_TABLE_NAME);

        // If the query ends in a specific record number, we're
        // being asked for a specific record, so set the
        // WHERE clause in our query.
        if((URI_MATCHER.match(uri)) == SPECIFIC_MESSAGE){
            qBuilder.appendWhere("_id=" + uri.getPathLeafId());
        }

        // Make the query.
        Cursor c = qBuilder.query(mDb,
                projection,
                selection,
                selectionArgs,
                groupBy,
                having,
                sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;</pre>
     *
     * @param uri The URI to query. This will be the full URI sent by the client;
     *      if the client is requesting a specific record, the URI will end in a record number
     *      that the implementation should parse and add to a WHERE or HAVING clause, specifying
     *      that _id value.
     * @param projection The list of columns to put into the cursor. If
     *      null all columns are included.
     * @param selection A selection criteria to apply when filtering rows.
     *      If null then all rows are included.
     * @param selectionArgs You may include ?s in selection, which will be replaced by
     *      the values from selectionArgs, in order that they appear in the selection.
     *      The values will be bound as Strings.
     * @param sortOrder How the rows in the cursor should be sorted.
     *      If null then the provider is free to define the sort order.
     * @return a Cursor or null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.737 -0500", hash_original_method = "F21BE52F6A5EF05F42ABB1A7CA8B045D", hash_generated_method = "394B9B61A7DAB44FF481367A59510784")
    
public abstract Cursor query(Uri uri, String[] projection,
            String selection, String[] selectionArgs, String sortOrder);

    /**
     * Implement this to handle requests for the MIME type of the data at the
     * given URI.  The returned MIME type should start with
     * <code>vnd.android.cursor.item</code> for a single record,
     * or <code>vnd.android.cursor.dir/</code> for multiple items.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * <p>Note that there are no permissions needed for an application to
     * access this information; if your content provider requires read and/or
     * write permissions, or is not exported, all applications can still call
     * this method regardless of their access permissions.  This allows them
     * to retrieve the MIME type for a URI when dispatching intents.
     *
     * @param uri the URI to query.
     * @return a MIME type string, or null if there is no type.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.739 -0500", hash_original_method = "A4398D9B92EECDCA04DBE4333E6E1CA3", hash_generated_method = "F60EB5723300ACB30027945838009E82")
    
public abstract String getType(Uri uri);

    /**
     * Implement this to handle requests to insert a new row.
     * As a courtesy, call {@link ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver) notifyChange()}
     * after inserting.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     * @param uri The content:// URI of the insertion request.
     * @param values A set of column_name/value pairs to add to the database.
     * @return The URI for the newly inserted item.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.742 -0500", hash_original_method = "B4DEB75D711E59EC126B5AA1EC87337F", hash_generated_method = "A947EC9D331AF38EAB8C36385181C769")
    
public abstract Uri insert(Uri uri, ContentValues values);

    /**
     * Override this to handle requests to insert a set of new rows, or the
     * default implementation will iterate over the values and call
     * {@link #insert} on each of them.
     * As a courtesy, call {@link ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver) notifyChange()}
     * after inserting.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * @param uri The content:// URI of the insertion request.
     * @param values An array of sets of column_name/value pairs to add to the database.
     * @return The number of values that were inserted.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.744 -0500", hash_original_method = "C678349FF8875CB9D22305FF9A5474DD", hash_generated_method = "DB10E22D5FFB11F9E085FB4F782D17D3")
    
public int bulkInsert(Uri uri, ContentValues[] values) {
        int numValues = values.length;
        for (int i = 0; i < numValues; i++) {
            insert(uri, values[i]);
        }
        return numValues;
    }

    /**
     * Implement this to handle requests to delete one or more rows.
     * The implementation should apply the selection clause when performing
     * deletion, allowing the operation to affect multiple rows in a directory.
     * As a courtesy, call {@link ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver) notifyDelete()}
     * after deleting.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * <p>The implementation is responsible for parsing out a row ID at the end
     * of the URI, if a specific row is being deleted. That is, the client would
     * pass in <code>content://contacts/people/22</code> and the implementation is
     * responsible for parsing the record number (22) when creating a SQL statement.
     *
     * @param uri The full URI to query, including a row ID (if a specific record is requested).
     * @param selection An optional restriction to apply to rows when deleting.
     * @return The number of rows affected.
     * @throws SQLException
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.746 -0500", hash_original_method = "E44ADC3F69A5B9F650B7F634DA106EF4", hash_generated_method = "1ACE593BD8B128A106D7B3E5FDA132DB")
    
public abstract int delete(Uri uri, String selection, String[] selectionArgs);

    /**
     * Implement this to handle requests to update one or more rows.
     * The implementation should update all rows matching the selection
     * to set the columns according to the provided values map.
     * As a courtesy, call {@link ContentResolver#notifyChange(android.net.Uri ,android.database.ContentObserver) notifyChange()}
     * after updating.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * @param uri The URI to query. This can potentially have a record ID if this
     * is an update request for a specific record.
     * @param values A Bundle mapping from column names to new column values (NULL is a
     *               valid value).
     * @param selection An optional filter to match rows to update.
     * @return the number of rows affected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.748 -0500", hash_original_method = "848ED1B601C77FEA6ED8D03E747F824C", hash_generated_method = "B8DAF275BB400A7B883E6875C5F854FA")
    
public abstract int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs);

    /**
     * Override this to handle requests to open a file blob.
     * The default implementation always throws {@link FileNotFoundException}.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * <p>This method returns a ParcelFileDescriptor, which is returned directly
     * to the caller.  This way large data (such as images and documents) can be
     * returned without copying the content.
     *
     * <p>The returned ParcelFileDescriptor is owned by the caller, so it is
     * their responsibility to close it when done.  That is, the implementation
     * of this method should create a new ParcelFileDescriptor for each call.
     *
     * @param uri The URI whose file is to be opened.
     * @param mode Access mode for the file.  May be "r" for read-only access,
     * "rw" for read and write access, or "rwt" for read and write access
     * that truncates any existing file.
     *
     * @return Returns a new ParcelFileDescriptor which you can use to access
     * the file.
     *
     * @throws FileNotFoundException Throws FileNotFoundException if there is
     * no file associated with the given URI or the mode is invalid.
     * @throws SecurityException Throws SecurityException if the caller does
     * not have permission to access the file.
     *
     * @see #openAssetFile(Uri, String)
     * @see #openFileHelper(Uri, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.750 -0500", hash_original_method = "DCC5B23EAE3536B2EEFB8F5A1AA89B13", hash_generated_method = "84165A880D6CDF9D2F7DE7F768E3AB8F")
    
public ParcelFileDescriptor openFile(Uri uri, String mode)
            throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at "
                + uri);
    }

    /**
     * This is like {@link #openFile}, but can be implemented by providers
     * that need to be able to return sub-sections of files, often assets
     * inside of their .apk.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * <p>If you implement this, your clients must be able to deal with such
     * file slices, either directly with
     * {@link ContentResolver#openAssetFileDescriptor}, or by using the higher-level
     * {@link ContentResolver#openInputStream ContentResolver.openInputStream}
     * or {@link ContentResolver#openOutputStream ContentResolver.openOutputStream}
     * methods.
     *
     * <p class="note">If you are implementing this to return a full file, you
     * should create the AssetFileDescriptor with
     * {@link AssetFileDescriptor#UNKNOWN_LENGTH} to be compatible with
     * applications that can not handle sub-sections of files.</p>
     *
     * @param uri The URI whose file is to be opened.
     * @param mode Access mode for the file.  May be "r" for read-only access,
     * "w" for write-only access (erasing whatever data is currently in
     * the file), "wa" for write-only access to append to any existing data,
     * "rw" for read and write access on any existing data, and "rwt" for read
     * and write access that truncates any existing file.
     *
     * @return Returns a new AssetFileDescriptor which you can use to access
     * the file.
     *
     * @throws FileNotFoundException Throws FileNotFoundException if there is
     * no file associated with the given URI or the mode is invalid.
     * @throws SecurityException Throws SecurityException if the caller does
     * not have permission to access the file.
     * 
     * @see #openFile(Uri, String)
     * @see #openFileHelper(Uri, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.752 -0500", hash_original_method = "58BEA9E66A4FD3FC19246F4A2CA5B928", hash_generated_method = "A6089BB0E944391C03BA06D5D029DD00")
    
public AssetFileDescriptor openAssetFile(Uri uri, String mode)
            throws FileNotFoundException {
        ParcelFileDescriptor fd = openFile(uri, mode);
        return fd != null ? new AssetFileDescriptor(fd, 0, -1) : null;
    }

    /**
     * Convenience for subclasses that wish to implement {@link #openFile}
     * by looking up a column named "_data" at the given URI.
     *
     * @param uri The URI to be opened.
     * @param mode The file mode.  May be "r" for read-only access,
     * "w" for write-only access (erasing whatever data is currently in
     * the file), "wa" for write-only access to append to any existing data,
     * "rw" for read and write access on any existing data, and "rwt" for read
     * and write access that truncates any existing file.
     *
     * @return Returns a new ParcelFileDescriptor that can be used by the
     * client to access the file.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.756 -0500", hash_original_method = "B77C082B2FC41ABB2AC9CAAF0861BB6A", hash_generated_method = "15E279E4CA599D4F9A2A194A376208B5")
    
protected final ParcelFileDescriptor openFileHelper(Uri uri,
            String mode) throws FileNotFoundException {
        Cursor c = query(uri, new String[]{"_data"}, null, null, null);
        int count = (c != null) ? c.getCount() : 0;
        if (count != 1) {
            // If there is not exactly one result, throw an appropriate
            // exception.
            if (c != null) {
                c.close();
            }
            if (count == 0) {
                throw new FileNotFoundException("No entry for " + uri);
            }
            throw new FileNotFoundException("Multiple items at " + uri);
        }

        c.moveToFirst();
        int i = c.getColumnIndex("_data");
        String path = (i >= 0 ? c.getString(i) : null);
        c.close();
        if (path == null) {
            throw new FileNotFoundException("Column _data not found.");
        }

        int modeBits = ContentResolver.modeToMode(uri, mode);
        return ParcelFileDescriptor.open(new File(path), modeBits);
    }

    /**
     * Called by a client to determine the types of data streams that this
     * content provider supports for the given URI.  The default implementation
     * returns null, meaning no types.  If your content provider stores data
     * of a particular type, return that MIME type if it matches the given
     * mimeTypeFilter.  If it can perform type conversions, return an array
     * of all supported MIME types that match mimeTypeFilter.
     *
     * @param uri The data in the content provider being queried.
     * @param mimeTypeFilter The type of data the client desires.  May be
     * a pattern, such as *\/* to retrieve all possible data types.
     * @return Returns null if there are no possible data streams for the
     * given mimeTypeFilter.  Otherwise returns an array of all available
     * concrete MIME types.
     *
     * @see #getType(Uri)
     * @see #openTypedAssetFile(Uri, String, Bundle)
     * @see ClipDescription#compareMimeTypes(String, String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.758 -0500", hash_original_method = "BEF8B956D915C9CD914319D11D9F55DF", hash_generated_method = "ECED8D109C81BADA2FF3CB79B0E8F176")
    
public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
        return null;
    }

    /**
     * Called by a client to open a read-only stream containing data of a
     * particular MIME type.  This is like {@link #openAssetFile(Uri, String)},
     * except the file can only be read-only and the content provider may
     * perform data conversions to generate data of the desired type.
     *
     * <p>The default implementation compares the given mimeType against the
     * result of {@link #getType(Uri)} and, if the match, simple calls
     * {@link #openAssetFile(Uri, String)}.
     *
     * <p>See {@link ClipData} for examples of the use and implementation
     * of this method.
     *
     * @param uri The data in the content provider being queried.
     * @param mimeTypeFilter The type of data the client desires.  May be
     * a pattern, such as *\/*, if the caller does not have specific type
     * requirements; in this case the content provider will pick its best
     * type matching the pattern.
     * @param opts Additional options from the client.  The definitions of
     * these are specific to the content provider being called.
     *
     * @return Returns a new AssetFileDescriptor from which the client can
     * read data of the desired type.
     *
     * @throws FileNotFoundException Throws FileNotFoundException if there is
     * no file associated with the given URI or the mode is invalid.
     * @throws SecurityException Throws SecurityException if the caller does
     * not have permission to access the data.
     * @throws IllegalArgumentException Throws IllegalArgumentException if the
     * content provider does not support the requested MIME type.
     *
     * @see #getStreamTypes(Uri, String)
     * @see #openAssetFile(Uri, String)
     * @see ClipDescription#compareMimeTypes(String, String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.761 -0500", hash_original_method = "4E83B7632E2F0C6C101685B3A453F6C7", hash_generated_method = "E154058D1651C11A0B7BFCB07D29F74C")
    
public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeTypeFilter, Bundle opts)
            throws FileNotFoundException {
        if ("*/*".equals(mimeTypeFilter)) {
            // If they can take anything, the untyped open call is good enough.
            return openAssetFile(uri, "r");
        }
        String baseType = getType(uri);
        if (baseType != null && ClipDescription.compareMimeTypes(baseType, mimeTypeFilter)) {
            // Use old untyped open call if this provider has a type for this
            // URI and it matches the request.
            return openAssetFile(uri, "r");
        }
        throw new FileNotFoundException("Can't open " + uri + " as type " + mimeTypeFilter);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.801 -0400", hash_original_method = "BC63CE555A1B156ABB3D2B022F0E90CE", hash_generated_method = "1600271E293F4C12749AC8508682DA08")
    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String mimeType,
            final Bundle opts, final T args, final PipeDataWriter<T> func) throws FileNotFoundException {
        addTaint(func.getTaint());
        addTaint(args.getTaint());
        addTaint(opts.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(uri.getTaint());
        try 
        {
            final ParcelFileDescriptor[] fds = ParcelFileDescriptor.createPipe();
            AsyncTask<Object, Object, Object> task = new AsyncTask<Object, Object, Object>() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.767 -0500", hash_original_method = "1746844A1D50FB8C8EBE4A7E980B01F9", hash_generated_method = "D9BDFD50AE3DB5C42BE3C71A8F210FA8")
                
@Override
                protected Object doInBackground(Object... params) {
                    func.writeDataToPipe(fds[1], uri, mimeType, opts, args);
                    try {
                        fds[1].close();
                    } catch (IOException e) {
                        Log.w(TAG, "Failure closing pipe", e);
                    }
                    return null;
                }
            };
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])null);
ParcelFileDescriptor var0A32740862433E6F4A2B631AD9C65F9E_1518019049 =             fds[0];
            var0A32740862433E6F4A2B631AD9C65F9E_1518019049.addTaint(taint);
            return var0A32740862433E6F4A2B631AD9C65F9E_1518019049;
        } //End block
        catch (IOException e)
        {
            FileNotFoundException var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959 = new FileNotFoundException("failure making pipe");
            var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959.addTaint(taint);
            throw var9BBB3DDA0FD7526E4D3B8A7AF6DADB25_861167959;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Returns true if this instance is a temporary content provider.
     * @return true if this instance is a temporary content provider
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.771 -0500", hash_original_method = "5727E4CF3A64759CEEBA62DE047537C3", hash_generated_method = "2E80B7E7F9B64B6B0B8C77F2C7EDC658")
    
protected boolean isTemporary() {
        return false;
    }

    /**
     * Returns the Binder object for this provider.
     *
     * @return the Binder object for this provider
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.773 -0500", hash_original_method = "883A061900350051FBA62F6F6FD9E085", hash_generated_method = "01677C8C73DD72384BF638D4A5102678")
    
public IContentProvider getIContentProvider() {
        return mTransport;
    }

    /**
     * After being instantiated, this is called to tell the content provider
     * about itself.
     *
     * @param context The context this provider is running in
     * @param info Registered information about this content provider
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.775 -0500", hash_original_method = "0A143494E98F1D73DE768E656190D91A", hash_generated_method = "9FAD0985A1BE43AFFAAC4D530C393AE6")
    
public void attachInfo(Context context, ProviderInfo info) {
        /*
         * We may be using AsyncTask from binder threads.  Make it init here
         * so its static handler is on the main thread.
         */
        AsyncTask.init();

        /*
         * Only allow it to be set once, so after the content service gives
         * this to us clients can't change it.
         */
        if (mContext == null) {
            mContext = context;
            mMyUid = Process.myUid();
            if (info != null) {
                setReadPermission(info.readPermission);
                setWritePermission(info.writePermission);
                setPathPermissions(info.pathPermissions);
                mExported = info.exported;
            }
            ContentProvider.this.onCreate();
        }
    }

    /**
     * Override this to handle requests to perform a batch of operations, or the
     * default implementation will iterate over the operations and call
     * {@link ContentProviderOperation#apply} on each of them.
     * If all calls to {@link ContentProviderOperation#apply} succeed
     * then a {@link ContentProviderResult} array with as many
     * elements as there were operations will be returned.  If any of the calls
     * fail, it is up to the implementation how many of the others take effect.
     * This method can be called from multiple threads, as described in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html#Threads">Processes
     * and Threads</a>.
     *
     * @param operations the operations to apply
     * @return the results of the applications
     * @throws OperationApplicationException thrown if any operation fails.
     * @see ContentProviderOperation#apply
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.777 -0500", hash_original_method = "E0DAC3050A9BAD12465D5076F1EE0420", hash_generated_method = "5E5EB1E9AE59FBDF718D6BE7226D411C")
    
public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations)
            throws OperationApplicationException {
        final int numOperations = operations.size();
        final ContentProviderResult[] results = new ContentProviderResult[numOperations];
        for (int i = 0; i < numOperations; i++) {
            results[i] = operations.get(i).apply(this, results, i);
        }
        return results;
    }

    /**
     * Call a provider-defined method.  This can be used to implement
     * interfaces that are cheaper and/or unnatural for a table-like
     * model.
     *
     * @param method method name to call.  Opaque to framework, but should not be null.
     * @param arg provider-defined String argument.  May be null.
     * @param extras provider-defined Bundle argument.  May be null.
     * @return provider-defined return value.  May be null.  Null is also
     *   the default for providers which don't implement any call methods.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.780 -0500", hash_original_method = "FDEF25FCA992321C96D9ED3D525FD124", hash_generated_method = "657B396BB7AFF64A38FC1384C839E2F8")
    
public Bundle call(String method, String arg, Bundle extras) {
        return null;
    }
    
    class Transport extends ContentProviderNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.808 -0400", hash_original_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F", hash_generated_method = "E8AA98EC6BE3CDFD6C8382F7CC9C6C6F")
        public Transport ()
        {
            //Synthesized constructor
        }
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.667 -0500", hash_original_method = "D85CC82248E7B34649DA1C02380D9E2C", hash_generated_method = "D85CC82248E7B34649DA1C02380D9E2C")
        
ContentProvider getContentProvider() {
            return ContentProvider.this;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.670 -0500", hash_original_method = "157A3AC2CED86E999B16E7CDFBD5AE31", hash_generated_method = "5E5952EDC976C3AAA9BEA2B1A81A08F7")
        
@Override
        public String getProviderName() {
            return getContentProvider().getClass().getName();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.672 -0500", hash_original_method = "C07C2CC52F2EA8ADD199B18CF964D47B", hash_generated_method = "92C9B98D23FEE24EAC2A672A27059E31")
        
public Cursor query(Uri uri, String[] projection,
                String selection, String[] selectionArgs, String sortOrder) {
            enforceReadPermission(uri);
            return ContentProvider.this.query(uri, projection, selection,
                    selectionArgs, sortOrder);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.674 -0500", hash_original_method = "BE9D1875DBA635C7BA04B42A3E893DA2", hash_generated_method = "F7F9ADB0E834AECC90BB268DEAA25DBF")
        
public String getType(Uri uri) {
            return ContentProvider.this.getType(uri);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.676 -0500", hash_original_method = "2D883DF9190F17ADC9F3F05EDAD4CA9E", hash_generated_method = "FFBAD1A55B0D0BCB03580CCC52A126FB")
        
public Uri insert(Uri uri, ContentValues initialValues) {
            enforceWritePermission(uri);
            return ContentProvider.this.insert(uri, initialValues);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.678 -0500", hash_original_method = "9C9FBE82EEDFD6251BF8F9B258727CC2", hash_generated_method = "19B6712A67243DBBDF3F204C1BD19343")
        
public int bulkInsert(Uri uri, ContentValues[] initialValues) {
            enforceWritePermission(uri);
            return ContentProvider.this.bulkInsert(uri, initialValues);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.681 -0500", hash_original_method = "8198345EE7E6B486A1CABFB05410D25E", hash_generated_method = "FE61C1B8B0CD6AA41C73DEC46BB548CF")
        
public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations)
                throws OperationApplicationException {
            for (ContentProviderOperation operation : operations) {
                if (operation.isReadOperation()) {
                    enforceReadPermission(operation.getUri());
                }

                if (operation.isWriteOperation()) {
                    enforceWritePermission(operation.getUri());
                }
            }
            return ContentProvider.this.applyBatch(operations);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.684 -0500", hash_original_method = "9F536F247E1CDAAB23A0513292709CB1", hash_generated_method = "C8C3FD7D9AC45416E200D5BBD9CCA9DC")
        
public int delete(Uri uri, String selection, String[] selectionArgs) {
            enforceWritePermission(uri);
            return ContentProvider.this.delete(uri, selection, selectionArgs);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.686 -0500", hash_original_method = "A4C580D76A4BE435F05FDF3658D031E7", hash_generated_method = "FCC88624F446656B38EFA01DA02B728E")
        
public int update(Uri uri, ContentValues values, String selection,
                String[] selectionArgs) {
            enforceWritePermission(uri);
            return ContentProvider.this.update(uri, values, selection, selectionArgs);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.689 -0500", hash_original_method = "A3B5DD3A6EF0BED7F3109E14959CA5EF", hash_generated_method = "F9B080E61BE06619E555CC6875519C55")
        
public ParcelFileDescriptor openFile(Uri uri, String mode)
                throws FileNotFoundException {
            if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            else enforceReadPermission(uri);
            return ContentProvider.this.openFile(uri, mode);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.691 -0500", hash_original_method = "9FC3CF0D01502503E6A8E959789D91E0", hash_generated_method = "BADD8B63F628F6CE2BDAB329A64578C7")
        
public AssetFileDescriptor openAssetFile(Uri uri, String mode)
                throws FileNotFoundException {
            if (mode != null && mode.startsWith("rw")) enforceWritePermission(uri);
            else enforceReadPermission(uri);
            return ContentProvider.this.openAssetFile(uri, mode);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.693 -0500", hash_original_method = "F8D45B029854B0071CB25BB646C6653D", hash_generated_method = "6A525E17BF33EED69D6DFA6E9C07CAC4")
        
public Bundle call(String method, String arg, Bundle extras) {
            return ContentProvider.this.call(method, arg, extras);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.696 -0500", hash_original_method = "8E1F3128EE5808B485D05EE809576B99", hash_generated_method = "C2FEDAFBDE2266AE7019559A2ADFA50B")
        
@Override
        public String[] getStreamTypes(Uri uri, String mimeTypeFilter) {
            return ContentProvider.this.getStreamTypes(uri, mimeTypeFilter);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.698 -0500", hash_original_method = "C18E75C38B25261EF8CFA8F7B83C6E2D", hash_generated_method = "50697919CC01A802904EEFB0DC7C1670")
        
@Override
        public AssetFileDescriptor openTypedAssetFile(Uri uri, String mimeType, Bundle opts)
                throws FileNotFoundException {
            enforceReadPermission(uri);
            return ContentProvider.this.openTypedAssetFile(uri, mimeType, opts);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.701 -0500", hash_original_method = "E57399204B1619B526E92C84388A407F", hash_generated_method = "78C032BED64CF5659D0FED4082567782")
        
private void enforceReadPermission(Uri uri) {
            final int uid = Binder.getCallingUid();
            if (uid == mMyUid) {
                return;
            }
            
            final Context context = getContext();
            final String rperm = getReadPermission();
            final int pid = Binder.getCallingPid();
            if (mExported && (rperm == null
                    || context.checkPermission(rperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED)) {
                return;
            }
            
            PathPermission[] pps = getPathPermissions();
            if (pps != null) {
                final String path = uri.getPath();
                int i = pps.length;
                while (i > 0) {
                    i--;
                    final PathPermission pp = pps[i];
                    final String pprperm = pp.getReadPermission();
                    if (pprperm != null && pp.match(path)) {
                        if (context.checkPermission(pprperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                    }
                }
            }
            
            if (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED) {
                return;
            }
            
            String msg = "Permission Denial: reading "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + rperm;
            throw new SecurityException(msg);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.704 -0500", hash_original_method = "329C06E4068EEDF4ECCAEC3BA5AB45CE", hash_generated_method = "CA8226431C1430D5E16C52B8B9C13EB3")
        
private boolean hasWritePermission(Uri uri) {
            final int uid = Binder.getCallingUid();
            if (uid == mMyUid) {
                return true;
            }
            
            final Context context = getContext();
            final String wperm = getWritePermission();
            final int pid = Binder.getCallingPid();
            if (mExported && (wperm == null
                    || context.checkPermission(wperm, pid, uid)
                    == PackageManager.PERMISSION_GRANTED)) {
                return true;
            }
            
            PathPermission[] pps = getPathPermissions();
            if (pps != null) {
                final String path = uri.getPath();
                int i = pps.length;
                while (i > 0) {
                    i--;
                    final PathPermission pp = pps[i];
                    final String ppwperm = pp.getWritePermission();
                    if (ppwperm != null && pp.match(path)) {
                        if (context.checkPermission(ppwperm, pid, uid)
                                == PackageManager.PERMISSION_GRANTED) {
                            return true;
                        }
                    }
                }
            }
            
            if (context.checkUriPermission(uri, pid, uid,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            
            return false;
        }
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.706 -0500", hash_original_method = "7CEC600BB70206A61DA89C0C0D2014C1", hash_generated_method = "F9AEE33E48A303A32C44D9DA7544D465")
        
private void enforceWritePermission(Uri uri) {
            if (hasWritePermission(uri)) {
                return;
            }
            
            String msg = "Permission Denial: writing "
                    + ContentProvider.this.getClass().getName()
                    + " uri " + uri + " from pid=" + Binder.getCallingPid()
                    + ", uid=" + Binder.getCallingUid()
                    + " requires " + getWritePermission();
            throw new SecurityException(msg);
        }
        
    }
    
    public interface PipeDataWriter<T> {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void writeDataToPipe(ParcelFileDescriptor output, Uri uri, String mimeType,
                Bundle opts, T args);
    }

    /**
     * Implement this to shut down the ContentProvider instance. You can then
     * invoke this method in unit tests.
     * 
     * <p>
     * Android normally handles ContentProvider startup and shutdown
     * automatically. You do not need to start up or shut down a
     * ContentProvider. When you invoke a test method on a ContentProvider,
     * however, a ContentProvider instance is started and keeps running after
     * the test finishes, even if a succeeding test instantiates another
     * ContentProvider. A conflict develops because the two instances are
     * usually running against the same underlying data source (for example, an
     * sqlite database).
     * </p>
     * <p>
     * Implementing shutDown() avoids this conflict by providing a way to
     * terminate the ContentProvider. This method can also prevent memory leaks
     * from multiple instantiations of the ContentProvider, and it can ensure
     * unit test isolation by allowing you to completely clean up the test
     * fixture before moving on to the next test.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:27.782 -0500", hash_original_method = "D03BEE67B09D4B1E8C6E9290C7758C5F", hash_generated_method = "F6A9F9CF151A4BD2D1CC37E8D2EC7281")
    
public void shutdown() {
        Log.w(TAG, "implement ContentProvider shutdown() to make sure all database " +
                "connections are gracefully shutdown");
    }
}

