package android.support.v4.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;





public class CursorLoader extends AsyncTaskLoader<Cursor> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.718 -0500", hash_original_field = "A5AC746DA3DB38EE93C6D4B7204AA2CB", hash_generated_field = "A5AC746DA3DB38EE93C6D4B7204AA2CB")

     ForceLoadContentObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.719 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "49226456B4CE4E55A779249DE3DC63D4")


    Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.720 -0500", hash_original_field = "B4F1557AF588ACBB7C63054FC5A3DB24", hash_generated_field = "B4F1557AF588ACBB7C63054FC5A3DB24")

    String[] mProjection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.721 -0500", hash_original_field = "A4B52CC7E044C58A043A90E441AE3148", hash_generated_field = "A4B52CC7E044C58A043A90E441AE3148")

    String mSelection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.721 -0500", hash_original_field = "471921CCB7416C473522085BE246B845", hash_generated_field = "471921CCB7416C473522085BE246B845")

    String[] mSelectionArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.722 -0500", hash_original_field = "1BF7E89DEAE629187129D35BF5C673FE", hash_generated_field = "1BF7E89DEAE629187129D35BF5C673FE")

    String mSortOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.723 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "4A85E902ED72E65A9AF8F6ED265E4F89")


    Cursor mCursor;

    /**
     * Creates an empty unspecified CursorLoader.  You must follow this with
     * calls to {@link #setUri(Uri)}, {@link #setSelection(String)}, etc
     * to specify the query to perform.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.726 -0500", hash_original_method = "A99DE5BAB8D49A9F22F0BBB80DAABBC5", hash_generated_method = "E52D0E8348980DDE35C82B8F0307B0D5")
    public CursorLoader(Context context) {
        super(context);
        mObserver = new ForceLoadContentObserver();
    }

    /**
     * Creates a fully-specified CursorLoader.  See
     * {@link android.content.ContentResolver#query(Uri, String[], String, String[], String)
     * ContentResolver.query()} for documentation on the meaning of the
     * parameters.  These will be passed as-is to that call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.727 -0500", hash_original_method = "E85CFBB14C85DBDBF43218DB60311B9E", hash_generated_method = "F92AFFBE22E62DC9F767A897D15DF7CF")
    public CursorLoader(Context context, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        super(context);
        mObserver = new ForceLoadContentObserver();
        mUri = uri;
        mProjection = projection;
        mSelection = selection;
        mSelectionArgs = selectionArgs;
        mSortOrder = sortOrder;
    }

    /* Runs on a worker thread */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.724 -0500", hash_original_method = "F9FA66289F481A177ACDB3A6ED9AD777", hash_generated_method = "84B0A27B8A893C643D749B604AF5B21C")
    @Override
public Cursor loadInBackground() {
        Cursor cursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                mSelectionArgs, mSortOrder);
        if (cursor != null) {
            // Ensure the cursor window is filled
            cursor.getCount();
            registerContentObserver(cursor, mObserver);
        }
        return cursor;
    }

    /**
     * Registers an observer to get notifications from the content provider
     * when the cursor needs to be refreshed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.724 -0500", hash_original_method = "020E778E16877AE64A0EC7CA895AF414", hash_generated_method = "020E778E16877AE64A0EC7CA895AF414")
    void registerContentObserver(Cursor cursor, ContentObserver observer) {
        cursor.registerContentObserver(mObserver);
    }

    /* Runs on the UI thread */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.725 -0500", hash_original_method = "37FD37E6CF73F613BFDCC98E888F8BCC", hash_generated_method = "8FE3F2116195103EB694A26B1AEB3EB6")
    @Override
public void deliverResult(Cursor cursor) {
        if (isReset()) {
            // An async query came in while the loader is stopped
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        Cursor oldCursor = mCursor;
        mCursor = cursor;

        if (isStarted()) {
            super.deliverResult(cursor);
        }

        if (oldCursor != null && oldCursor != cursor && !oldCursor.isClosed()) {
            oldCursor.close();
        }
    }

    /**
     * Starts an asynchronous load of the contacts list data. When the result is ready the callbacks
     * will be called on the UI thread. If a previous load has been completed and is still valid
     * the result may be passed to the callbacks immediately.
     *
     * Must be called from the UI thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.728 -0500", hash_original_method = "FEDEC1668E99CC7AC8B63903F046C2E4", hash_generated_method = "270B33800028B49BD2EC75D7757AD67D")
    @Override
protected void onStartLoading() {
        if (mCursor != null) {
            deliverResult(mCursor);
        }
        if (takeContentChanged() || mCursor == null) {
            forceLoad();
        }
    }

    /**
     * Must be called from the UI thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.729 -0500", hash_original_method = "9D6573E0227A73E2122897AF91440AD0", hash_generated_method = "F511E4B7EE637E5BAD99C2CE0F97AB45")
    @Override
protected void onStopLoading() {
        // Attempt to cancel the current load task if possible.
        cancelLoad();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.730 -0500", hash_original_method = "880E0574E2EB66A6B5B217A64A77BCD6", hash_generated_method = "4247A5254EAD005A6D3F5B6172EF4717")
    @Override
public void onCanceled(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.731 -0500", hash_original_method = "CBB8B33455486DDE9DE82F5D7E5B319A", hash_generated_method = "13010ABD9857D09EDAA4093213956033")
    @Override
protected void onReset() {
        super.onReset();
        
        // Ensure the loader is stopped
        onStopLoading();

        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        mCursor = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.731 -0500", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "A1B996311564AA1668AF8C1FC49818A0")
    public Uri getUri() {
        return mUri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.732 -0500", hash_original_method = "9C60EE9BABBE4846A09E69FDD9525C9D", hash_generated_method = "FD70051E3CE83044C02BEB8B8C8B793A")
    public void setUri(Uri uri) {
        mUri = uri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.733 -0500", hash_original_method = "F735C138868E0AFA154B3EDF3AAC6C8C", hash_generated_method = "A4415DDE5EA54B7212BBAA4683713BC3")
    public String[] getProjection() {
        return mProjection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.734 -0500", hash_original_method = "1FD0FB2AA6253DF2D0DE4351259B7D6A", hash_generated_method = "57B6D9961369F9596BD154E5D3CA8233")
    public void setProjection(String[] projection) {
        mProjection = projection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.734 -0500", hash_original_method = "E01933AA37B8BF932A93A806A1D37FFC", hash_generated_method = "84F5F72F05959F562313783A8780700C")
    public String getSelection() {
        return mSelection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.735 -0500", hash_original_method = "0D04EAE992D5BEBB5A3775930987740E", hash_generated_method = "559B73F924C15281B0D896B6D9499557")
    public void setSelection(String selection) {
        mSelection = selection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.736 -0500", hash_original_method = "9B3363CD5FA3C0407FC101CCC97AC74F", hash_generated_method = "FA65D5675FFE3937E9DC1ED5B2B934BC")
    public String[] getSelectionArgs() {
        return mSelectionArgs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.737 -0500", hash_original_method = "5DE6373B4434A7D0B0150E5FA1A41F4D", hash_generated_method = "077E703E703945E3B47EDDDA82AFEF8E")
    public void setSelectionArgs(String[] selectionArgs) {
        mSelectionArgs = selectionArgs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.737 -0500", hash_original_method = "E54D82A1039D474135177094E296D0BE", hash_generated_method = "493950C0BE27E1C7559B008A1D154B29")
    public String getSortOrder() {
        return mSortOrder;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.738 -0500", hash_original_method = "5BFD82EE872F667FB5FE226A7761A7D3", hash_generated_method = "D6FEC6A8AD3ED99E8A9C14438128AFD0")
    public void setSortOrder(String sortOrder) {
        mSortOrder = sortOrder;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:36.739 -0500", hash_original_method = "F4CED264AFFA6312AA112E1BE872302C", hash_generated_method = "180D303CC0A14CD1C11DC938DA32F769")
    @Override
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        writer.print(prefix); writer.print("mUri="); writer.println(mUri);
        writer.print(prefix); writer.print("mProjection=");
                writer.println(Arrays.toString(mProjection));
        writer.print(prefix); writer.print("mSelection="); writer.println(mSelection);
        writer.print(prefix); writer.print("mSelectionArgs=");
                writer.println(Arrays.toString(mSelectionArgs));
        writer.print(prefix); writer.print("mSortOrder="); writer.println(mSortOrder);
        writer.print(prefix); writer.print("mCursor="); writer.println(mCursor);
        writer.print(prefix); writer.print("mContentChanged="); writer.println(mContentChanged);
    }

    
}

