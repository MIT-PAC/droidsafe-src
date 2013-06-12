package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    final ForceLoadContentObserver mObserver;
    Uri mUri;
    String[] mProjection;
    String mSelection;
    String[] mSelectionArgs;
    String mSortOrder;
    Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.523 -0400", hash_original_method = "A99DE5BAB8D49A9F22F0BBB80DAABBC5", hash_generated_method = "F6F4188B284D8C184C75F4716BB3E572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorLoader(Context context) {
        super(context);
        dsTaint.addTaint(context.dsTaint);
        mObserver = new ForceLoadContentObserver();
        // ---------- Original Method ----------
        //mObserver = new ForceLoadContentObserver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.524 -0400", hash_original_method = "E85CFBB14C85DBDBF43218DB60311B9E", hash_generated_method = "274E146B6765DDC86C88570902A4F507")
    @DSModeled(DSC.SPEC)
    public CursorLoader(Context context, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        super(context);
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        mObserver = new ForceLoadContentObserver();
        // ---------- Original Method ----------
        //mObserver = new ForceLoadContentObserver();
        //mUri = uri;
        //mProjection = projection;
        //mSelection = selection;
        //mSelectionArgs = selectionArgs;
        //mSortOrder = sortOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.524 -0400", hash_original_method = "F9FA66289F481A177ACDB3A6ED9AD777", hash_generated_method = "874ED277ADC6BA5BA71C56523F42488C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Cursor loadInBackground() {
        Cursor cursor;
        cursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                mSelectionArgs, mSortOrder);
        {
            cursor.getCount();
            registerContentObserver(cursor, mObserver);
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Cursor cursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                //mSelectionArgs, mSortOrder);
        //if (cursor != null) {
            //cursor.getCount();
            //registerContentObserver(cursor, mObserver);
        //}
        //return cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.524 -0400", hash_original_method = "020E778E16877AE64A0EC7CA895AF414", hash_generated_method = "863ABEF42A411C36A493EAB8FEDE1E01")
    @DSModeled(DSC.SAFE)
     void registerContentObserver(Cursor cursor, ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(observer.dsTaint);
        cursor.registerContentObserver(mObserver);
        // ---------- Original Method ----------
        //cursor.registerContentObserver(mObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.525 -0400", hash_original_method = "37FD37E6CF73F613BFDCC98E888F8BCC", hash_generated_method = "73143B9885EFFFE5ACAE66E789675F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void deliverResult(Cursor cursor) {
        dsTaint.addTaint(cursor.dsTaint);
        {
            boolean var396A4E20A18F0CB5EA1A247530F4A1CC_1303580466 = (isReset());
            {
                {
                    cursor.close();
                } //End block
            } //End block
        } //End collapsed parenthetic
        Cursor oldCursor;
        oldCursor = mCursor;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_1311905911 = (isStarted());
            {
                super.deliverResult(cursor);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFD2F6599D37EB07EC4E591DC6274604E_1870048966 = (oldCursor != null && oldCursor != cursor && !oldCursor.isClosed());
            {
                oldCursor.close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isReset()) {
            //if (cursor != null) {
                //cursor.close();
            //}
            //return;
        //}
        //Cursor oldCursor = mCursor;
        //mCursor = cursor;
        //if (isStarted()) {
            //super.deliverResult(cursor);
        //}
        //if (oldCursor != null && oldCursor != cursor && !oldCursor.isClosed()) {
            //oldCursor.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.525 -0400", hash_original_method = "FEDEC1668E99CC7AC8B63903F046C2E4", hash_generated_method = "A700DC269C190AC6FE657D27BCF5B8EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onStartLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            deliverResult(mCursor);
        } //End block
        {
            boolean var97F909A67ECD7ED4B7826F327C77B4CA_853307757 = (takeContentChanged() || mCursor == null);
            {
                forceLoad();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //deliverResult(mCursor);
        //}
        //if (takeContentChanged() || mCursor == null) {
            //forceLoad();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.525 -0400", hash_original_method = "9D6573E0227A73E2122897AF91440AD0", hash_generated_method = "153542BAB600BF30986A0DBF88EB6807")
    @DSModeled(DSC.SAFE)
    @Override
    protected void onStopLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelLoad();
        // ---------- Original Method ----------
        //cancelLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.525 -0400", hash_original_method = "880E0574E2EB66A6B5B217A64A77BCD6", hash_generated_method = "651A00A35CE97BED9D93180B163BD2B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onCanceled(Cursor cursor) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cursor.dsTaint);
        {
            boolean var6E557A405E573C015C30C74BDB9F539B_1846936108 = (cursor != null && !cursor.isClosed());
            {
                cursor.close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (cursor != null && !cursor.isClosed()) {
            //cursor.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.526 -0400", hash_original_method = "CBB8B33455486DDE9DE82F5D7E5B319A", hash_generated_method = "AB2E176A0E77E9C6738E49529109D02E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onReset() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onReset();
        onStopLoading();
        {
            boolean var17C3122DB48F8D9C899DB59BBA71A4FB_1397205203 = (mCursor != null && !mCursor.isClosed());
            {
                mCursor.close();
            } //End block
        } //End collapsed parenthetic
        mCursor = null;
        // ---------- Original Method ----------
        //super.onReset();
        //onStopLoading();
        //if (mCursor != null && !mCursor.isClosed()) {
            //mCursor.close();
        //}
        //mCursor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.526 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "94C4A5FE659081F708F6FF00E69FFC4B")
    @DSModeled(DSC.SPEC)
    public Uri getUri() {
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.526 -0400", hash_original_method = "9C60EE9BABBE4846A09E69FDD9525C9D", hash_generated_method = "FB99EA3959F83003237C12B3B5251338")
    @DSModeled(DSC.SPEC)
    public void setUri(Uri uri) {
        dsTaint.addTaint(uri.dsTaint);
        // ---------- Original Method ----------
        //mUri = uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.526 -0400", hash_original_method = "F735C138868E0AFA154B3EDF3AAC6C8C", hash_generated_method = "01AC75FC0E67A014CBC449627A2E855B")
    @DSModeled(DSC.SAFE)
    public String[] getProjection() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mProjection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.527 -0400", hash_original_method = "1FD0FB2AA6253DF2D0DE4351259B7D6A", hash_generated_method = "BF514505A4B6CD8D16CD41886C4FD2D3")
    @DSModeled(DSC.SAFE)
    public void setProjection(String[] projection) {
        dsTaint.addTaint(projection);
        // ---------- Original Method ----------
        //mProjection = projection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.527 -0400", hash_original_method = "E01933AA37B8BF932A93A806A1D37FFC", hash_generated_method = "F8F1859F6EB6E80C5389000F8853F75E")
    @DSModeled(DSC.SAFE)
    public String getSelection() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSelection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.527 -0400", hash_original_method = "0D04EAE992D5BEBB5A3775930987740E", hash_generated_method = "57B5FE048BD2FE1D56FDA06655846986")
    @DSModeled(DSC.SAFE)
    public void setSelection(String selection) {
        dsTaint.addTaint(selection);
        // ---------- Original Method ----------
        //mSelection = selection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.527 -0400", hash_original_method = "9B3363CD5FA3C0407FC101CCC97AC74F", hash_generated_method = "99EBA9DCCD9C20347F2AC302920847C4")
    @DSModeled(DSC.SAFE)
    public String[] getSelectionArgs() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mSelectionArgs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.527 -0400", hash_original_method = "5DE6373B4434A7D0B0150E5FA1A41F4D", hash_generated_method = "98B2B1C829FF4ADA52E7A99A4676CA37")
    @DSModeled(DSC.SAFE)
    public void setSelectionArgs(String[] selectionArgs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selectionArgs);
        // ---------- Original Method ----------
        //mSelectionArgs = selectionArgs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.528 -0400", hash_original_method = "E54D82A1039D474135177094E296D0BE", hash_generated_method = "C6EC4F69FCF30C433519274AD49B6867")
    @DSModeled(DSC.SAFE)
    public String getSortOrder() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSortOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.528 -0400", hash_original_method = "5BFD82EE872F667FB5FE226A7761A7D3", hash_generated_method = "0648A3F9F043FD358806C97D01B3381E")
    @DSModeled(DSC.SAFE)
    public void setSortOrder(String sortOrder) {
        dsTaint.addTaint(sortOrder);
        // ---------- Original Method ----------
        //mSortOrder = sortOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.528 -0400", hash_original_method = "F4CED264AFFA6312AA112E1BE872302C", hash_generated_method = "CB2CC7373E239D30FE8CAD2E7ADAD830")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(writer.dsTaint);
        super.dump(prefix, fd, writer, args);
        writer.print(prefix);
        writer.print("mUri=");
        writer.println(mUri);
        writer.print(prefix);
        writer.print("mProjection=");
        writer.println(Arrays.toString(mProjection));
        writer.print(prefix);
        writer.print("mSelection=");
        writer.println(mSelection);
        writer.print(prefix);
        writer.print("mSelectionArgs=");
        writer.println(Arrays.toString(mSelectionArgs));
        writer.print(prefix);
        writer.print("mSortOrder=");
        writer.println(mSortOrder);
        writer.print(prefix);
        writer.print("mCursor=");
        writer.println(mCursor);
        writer.print(prefix);
        writer.print("mContentChanged=");
        writer.println(mContentChanged);
        // ---------- Original Method ----------
        //super.dump(prefix, fd, writer, args);
        //writer.print(prefix);
        //writer.print("mUri=");
        //writer.println(mUri);
        //writer.print(prefix);
        //writer.print("mProjection=");
        //writer.println(Arrays.toString(mProjection));
        //writer.print(prefix);
        //writer.print("mSelection=");
        //writer.println(mSelection);
        //writer.print(prefix);
        //writer.print("mSelectionArgs=");
        //writer.println(Arrays.toString(mSelectionArgs));
        //writer.print(prefix);
        //writer.print("mSortOrder=");
        //writer.println(mSortOrder);
        //writer.print(prefix);
        //writer.print("mCursor=");
        //writer.println(mCursor);
        //writer.print(prefix);
        //writer.print("mContentChanged=");
        //writer.println(mContentChanged);
    }

    
}


