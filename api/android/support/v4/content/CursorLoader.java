package android.support.v4.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "A5AC746DA3DB38EE93C6D4B7204AA2CB")

    ForceLoadContentObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "49226456B4CE4E55A779249DE3DC63D4")

    Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "B539ADB6655DA3802F6EA50CDAB7182B", hash_generated_field = "B4F1557AF588ACBB7C63054FC5A3DB24")

    String[] mProjection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "A4B52CC7E044C58A043A90E441AE3148")

    String mSelection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "BAEA1B6F996F3986EF68E88ECD2F5469", hash_generated_field = "471921CCB7416C473522085BE246B845")

    String[] mSelectionArgs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "755C32BCA9E2E8B7F7116F3D5757A350", hash_generated_field = "1BF7E89DEAE629187129D35BF5C673FE")

    String mSortOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.289 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "4A85E902ED72E65A9AF8F6ED265E4F89")

    Cursor mCursor;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.290 -0400", hash_original_method = "A99DE5BAB8D49A9F22F0BBB80DAABBC5", hash_generated_method = "9EF8844A713C5AB4279066B2701877A1")
    public  CursorLoader(Context context) {
        super(context);
        addTaint(context.getTaint());
        mObserver = new ForceLoadContentObserver();
        // ---------- Original Method ----------
        //mObserver = new ForceLoadContentObserver();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.290 -0400", hash_original_method = "E85CFBB14C85DBDBF43218DB60311B9E", hash_generated_method = "A5D059C6DDFA88FF863DBA7E23D0D50C")
    public  CursorLoader(Context context, Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        super(context);
        addTaint(context.getTaint());
        mObserver = new ForceLoadContentObserver();
        mUri = uri;
        mProjection = projection;
        mSelection = selection;
        mSelectionArgs = selectionArgs;
        mSortOrder = sortOrder;
        // ---------- Original Method ----------
        //mObserver = new ForceLoadContentObserver();
        //mUri = uri;
        //mProjection = projection;
        //mSelection = selection;
        //mSelectionArgs = selectionArgs;
        //mSortOrder = sortOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.290 -0400", hash_original_method = "F9FA66289F481A177ACDB3A6ED9AD777", hash_generated_method = "1BF0842FE8AA4CA42E19CD00C76A2BD4")
    @Override
    public Cursor loadInBackground() {
        Cursor cursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                mSelectionArgs, mSortOrder);
    if(cursor != null)        
        {
            cursor.getCount();
            registerContentObserver(cursor, mObserver);
        } //End block
Cursor varADA3C208DF1628BA935498FB38A6BBD3_419348845 =         cursor;
        varADA3C208DF1628BA935498FB38A6BBD3_419348845.addTaint(taint);
        return varADA3C208DF1628BA935498FB38A6BBD3_419348845;
        // ---------- Original Method ----------
        //Cursor cursor = getContext().getContentResolver().query(mUri, mProjection, mSelection,
                //mSelectionArgs, mSortOrder);
        //if (cursor != null) {
            //cursor.getCount();
            //registerContentObserver(cursor, mObserver);
        //}
        //return cursor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.290 -0400", hash_original_method = "020E778E16877AE64A0EC7CA895AF414", hash_generated_method = "7BA456F7598ADADE1D7DC029F04032B1")
     void registerContentObserver(Cursor cursor, ContentObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        addTaint(cursor.getTaint());
        cursor.registerContentObserver(mObserver);
        // ---------- Original Method ----------
        //cursor.registerContentObserver(mObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.290 -0400", hash_original_method = "37FD37E6CF73F613BFDCC98E888F8BCC", hash_generated_method = "A376C5282E799966540D172580181656")
    @Override
    public void deliverResult(Cursor cursor) {
    if(isReset())        
        {
    if(cursor != null)            
            {
                cursor.close();
            } //End block
            return;
        } //End block
        Cursor oldCursor = mCursor;
        mCursor = cursor;
    if(isStarted())        
        {
            super.deliverResult(cursor);
        } //End block
    if(oldCursor != null && oldCursor != cursor && !oldCursor.isClosed())        
        {
            oldCursor.close();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.291 -0400", hash_original_method = "FEDEC1668E99CC7AC8B63903F046C2E4", hash_generated_method = "0E2C6A803AEE61B43E99FEDB1510D146")
    @Override
    protected void onStartLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mCursor != null)        
        {
            deliverResult(mCursor);
        } //End block
    if(takeContentChanged() || mCursor == null)        
        {
            forceLoad();
        } //End block
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //deliverResult(mCursor);
        //}
        //if (takeContentChanged() || mCursor == null) {
            //forceLoad();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.291 -0400", hash_original_method = "9D6573E0227A73E2122897AF91440AD0", hash_generated_method = "81B3A186E0433BEB205EBEDD3D384C02")
    @Override
    protected void onStopLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelLoad();
        // ---------- Original Method ----------
        //cancelLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.291 -0400", hash_original_method = "880E0574E2EB66A6B5B217A64A77BCD6", hash_generated_method = "1367F0488E8518F1895B5C6C647BBD24")
    @Override
    public void onCanceled(Cursor cursor) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cursor.getTaint());
    if(cursor != null && !cursor.isClosed())        
        {
            cursor.close();
        } //End block
        // ---------- Original Method ----------
        //if (cursor != null && !cursor.isClosed()) {
            //cursor.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.291 -0400", hash_original_method = "CBB8B33455486DDE9DE82F5D7E5B319A", hash_generated_method = "54C1532D8B9D01064C512600AA52A611")
    @Override
    protected void onReset() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onReset();
        onStopLoading();
    if(mCursor != null && !mCursor.isClosed())        
        {
            mCursor.close();
        } //End block
        mCursor = null;
        // ---------- Original Method ----------
        //super.onReset();
        //onStopLoading();
        //if (mCursor != null && !mCursor.isClosed()) {
            //mCursor.close();
        //}
        //mCursor = null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.291 -0400", hash_original_method = "225259AA593B6A59F476A2C569F1B075", hash_generated_method = "8EE402C532CA1BAD83A94E43830F8ABA")
    public Uri getUri() {
Uri var7D41D50876117CE5D7DFAD684A455037_1234663718 =         mUri;
        var7D41D50876117CE5D7DFAD684A455037_1234663718.addTaint(taint);
        return var7D41D50876117CE5D7DFAD684A455037_1234663718;
        // ---------- Original Method ----------
        //return mUri;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "9C60EE9BABBE4846A09E69FDD9525C9D", hash_generated_method = "1565E698950E459B40FC6B1A30301330")
    public void setUri(Uri uri) {
        mUri = uri;
        // ---------- Original Method ----------
        //mUri = uri;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "F735C138868E0AFA154B3EDF3AAC6C8C", hash_generated_method = "5A72E7800EFAF4FCFFC7F451DE1A0DAF")
    public String[] getProjection() {
String[] var0986C59C60122C06A59D656D519E9977_1282021629 =         mProjection;
        var0986C59C60122C06A59D656D519E9977_1282021629.addTaint(taint);
        return var0986C59C60122C06A59D656D519E9977_1282021629;
        // ---------- Original Method ----------
        //return mProjection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "1FD0FB2AA6253DF2D0DE4351259B7D6A", hash_generated_method = "2307E179C952E8EDFB6BBB5646F927A1")
    public void setProjection(String[] projection) {
        mProjection = projection;
        // ---------- Original Method ----------
        //mProjection = projection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "E01933AA37B8BF932A93A806A1D37FFC", hash_generated_method = "571CA353989BACE3BF4876AA71B1686A")
    public String getSelection() {
String var3671EDECB8744C1A02C621F61390B726_2008835873 =         mSelection;
        var3671EDECB8744C1A02C621F61390B726_2008835873.addTaint(taint);
        return var3671EDECB8744C1A02C621F61390B726_2008835873;
        // ---------- Original Method ----------
        //return mSelection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "0D04EAE992D5BEBB5A3775930987740E", hash_generated_method = "8D0C01BC2FD4DA64EC5DFEE4B4BFFFB5")
    public void setSelection(String selection) {
        mSelection = selection;
        // ---------- Original Method ----------
        //mSelection = selection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "9B3363CD5FA3C0407FC101CCC97AC74F", hash_generated_method = "C28C625C6249E7EC32F15B88A28F0627")
    public String[] getSelectionArgs() {
String[] varDBA0D6591B6C7829463FE09B1460B708_1578262572 =         mSelectionArgs;
        varDBA0D6591B6C7829463FE09B1460B708_1578262572.addTaint(taint);
        return varDBA0D6591B6C7829463FE09B1460B708_1578262572;
        // ---------- Original Method ----------
        //return mSelectionArgs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "5DE6373B4434A7D0B0150E5FA1A41F4D", hash_generated_method = "2749EDEF8949EF1FF35A2BA90D360659")
    public void setSelectionArgs(String[] selectionArgs) {
        mSelectionArgs = selectionArgs;
        // ---------- Original Method ----------
        //mSelectionArgs = selectionArgs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.292 -0400", hash_original_method = "E54D82A1039D474135177094E296D0BE", hash_generated_method = "1C6D5B1B8CF751CCFA47E7E477DA6400")
    public String getSortOrder() {
String var7F16D2B7DBEF42F7E6C1432220526EB5_1677632559 =         mSortOrder;
        var7F16D2B7DBEF42F7E6C1432220526EB5_1677632559.addTaint(taint);
        return var7F16D2B7DBEF42F7E6C1432220526EB5_1677632559;
        // ---------- Original Method ----------
        //return mSortOrder;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.293 -0400", hash_original_method = "5BFD82EE872F667FB5FE226A7761A7D3", hash_generated_method = "C543040F89A1BDC3496BD90EA95223A3")
    public void setSortOrder(String sortOrder) {
        mSortOrder = sortOrder;
        // ---------- Original Method ----------
        //mSortOrder = sortOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.293 -0400", hash_original_method = "F4CED264AFFA6312AA112E1BE872302C", hash_generated_method = "CDC5A1E2EE5B5215E9C55F7BBD9A557D")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
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

