package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;

import com.android.internal.database.SortCursor;






public class RingtoneManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")

    private Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "E8B3B323AFAD714BCA91D2EB1DAF5DB9", hash_generated_field = "4CBCEBAF01C88051929B10818FF66937")

    private int mType = TYPE_RINGTONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "6DE331B0F0075E0357653C29CEC84164", hash_generated_field = "2E1F7E6AFE9515754C5EDB99981F24C8")

    private List<String> mFilterColumns = new ArrayList<String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.124 -0400", hash_original_field = "13430E793C61AADBFB74FDC43D232756", hash_generated_field = "F30049F1DB4460139DD5C5858E52950F")

    private boolean mStopPreviousRingtone = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.125 -0400", hash_original_field = "DB6405CCCB060CBB368995D06C0903D9", hash_generated_field = "C4ECD4547B5F1082232499A5FFF0E4E3")

    private Ringtone mPreviousRingtone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.125 -0400", hash_original_field = "E2BB809370A9738D99D955B8499EB4DB", hash_generated_field = "BB569023441C69981692423BFE009466")

    private boolean mIncludeDrm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.125 -0400", hash_original_method = "2A8A1FC42FD49A3D281BB8A7356537D2", hash_generated_method = "B9773C3517CE5FC6AD1344332AEF24E8")
    public  RingtoneManager(Activity activity) {
        mContext = mActivity = activity;
        setType(mType);
        // ---------- Original Method ----------
        //mContext = mActivity = activity;
        //setType(mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.126 -0400", hash_original_method = "AEFBB2F4D30FA9949534E3B15FD9C787", hash_generated_method = "A3DD75F8D24AFFAA37CC596EBF7CC885")
    public  RingtoneManager(Context context) {
        mContext = context;
        setType(mType);
        // ---------- Original Method ----------
        //mContext = context;
        //setType(mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.126 -0400", hash_original_method = "9DE86AC52EF0C8E8314EB0C63463BFAA", hash_generated_method = "FF47E50866774B9B8538B0D569CC0703")
    public void setType(int type) {
        if(mCursor != null)        
        {
            IllegalStateException varE30B04B05BECE00C66C72178A884E444_1442405329 = new IllegalStateException(
                    "Setting filter columns should be done before querying for ringtones.");
            varE30B04B05BECE00C66C72178A884E444_1442405329.addTaint(taint);
            throw varE30B04B05BECE00C66C72178A884E444_1442405329;
        } //End block
        mType = type;
        setFilterColumnsList(type);
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //throw new IllegalStateException(
                    //"Setting filter columns should be done before querying for ringtones.");
        //}
        //mType = type;
        //setFilterColumnsList(type);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.127 -0400", hash_original_method = "26C25231B8EE38423D74AE317EB8CDCC", hash_generated_method = "6FF98EBC907016C294ACD4D1CC4B677F")
    public int inferStreamType() {
switch(mType){
        case TYPE_ALARM:
        int var6B9C80404974D8BACD3D5F4CD05390E3_214081734 = (AudioManager.STREAM_ALARM);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309010401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309010401;
        case TYPE_NOTIFICATION:
        int varFB6D894A619068AC12D5723166BB0BDB_138136044 = (AudioManager.STREAM_NOTIFICATION);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066631963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2066631963;
        default:
        int var52D1226918B681B1820BA70F7623DAB3_1516727661 = (AudioManager.STREAM_RING);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818537648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_818537648;
}
        // ---------- Original Method ----------
        //switch (mType) {
            //case TYPE_ALARM:
                //return AudioManager.STREAM_ALARM;
            //case TYPE_NOTIFICATION:
                //return AudioManager.STREAM_NOTIFICATION;
            //default:
                //return AudioManager.STREAM_RING;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.128 -0400", hash_original_method = "A35CDF85342D56F6EFBA8853AE857D3A", hash_generated_method = "A319332DE37A3B6466CE25846A7922D3")
    public void setStopPreviousRingtone(boolean stopPreviousRingtone) {
        mStopPreviousRingtone = stopPreviousRingtone;
        // ---------- Original Method ----------
        //mStopPreviousRingtone = stopPreviousRingtone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.129 -0400", hash_original_method = "0B3E7FCD199769A7D560D3943A8B1B23", hash_generated_method = "0D7D39D0F1DA75FE0A1FCA10197AE0D0")
    public boolean getStopPreviousRingtone() {
        boolean var6E1EF126CABB9337F9B6F4F268DFDCC7_42978918 = (mStopPreviousRingtone);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286911612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286911612;
        // ---------- Original Method ----------
        //return mStopPreviousRingtone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.129 -0400", hash_original_method = "A83DE0FFAA4D869AA2ED1763D4647132", hash_generated_method = "0B3EA5CA78F6A306861FEFD4A6EC892D")
    public void stopPreviousRingtone() {
        if(mPreviousRingtone != null)        
        {
            mPreviousRingtone.stop();
        } //End block
        // ---------- Original Method ----------
        //if (mPreviousRingtone != null) {
            //mPreviousRingtone.stop();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.130 -0400", hash_original_method = "9F2D30C6202871DC182E5AD2A88B91B1", hash_generated_method = "7342817D0DC391EF53EEEAFC2269A5B1")
    public boolean getIncludeDrm() {
        boolean varE2BB809370A9738D99D955B8499EB4DB_1628082517 = (mIncludeDrm);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177507876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177507876;
        // ---------- Original Method ----------
        //return mIncludeDrm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.131 -0400", hash_original_method = "9AE3415FBA2FD0FC22ED2C93FA9F8016", hash_generated_method = "7524A5DEEE7B1595BB0B2B13A3C596AD")
    public void setIncludeDrm(boolean includeDrm) {
        mIncludeDrm = includeDrm;
        // ---------- Original Method ----------
        //mIncludeDrm = includeDrm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.132 -0400", hash_original_method = "890985AD9BCFC1049E02A6DFBECAA43E", hash_generated_method = "1457A35B92823862203A5B8E4170766B")
    public Cursor getCursor() {
        if(mCursor != null && mCursor.requery())        
        {
Cursor var2D697C95C6440211C70889796F0139B0_1514188495 =             mCursor;
            var2D697C95C6440211C70889796F0139B0_1514188495.addTaint(taint);
            return var2D697C95C6440211C70889796F0139B0_1514188495;
        } //End block
        final Cursor internalCursor = getInternalRingtones();
        final Cursor drmCursor = mIncludeDrm ? getDrmRingtones() : null;
        final Cursor mediaCursor = getMediaRingtones();
Cursor var61A6DC9612A061EF7F8E8FA220F1F6AE_990300085 =         mCursor = new SortCursor(new Cursor[] { internalCursor, drmCursor, mediaCursor },
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        var61A6DC9612A061EF7F8E8FA220F1F6AE_990300085.addTaint(taint);
        return var61A6DC9612A061EF7F8E8FA220F1F6AE_990300085;
        // ---------- Original Method ----------
        //if (mCursor != null && mCursor.requery()) {
            //return mCursor;
        //}
        //final Cursor internalCursor = getInternalRingtones();
        //final Cursor drmCursor = mIncludeDrm ? getDrmRingtones() : null;
        //final Cursor mediaCursor = getMediaRingtones();
        //return mCursor = new SortCursor(new Cursor[] { internalCursor, drmCursor, mediaCursor },
                //MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.133 -0400", hash_original_method = "6FCC5829E72C1DEF0426E1D999C80198", hash_generated_method = "9E55A43DCBFDFF4A221EDF9A4A0788C3")
    public Ringtone getRingtone(int position) {
        if(mStopPreviousRingtone && mPreviousRingtone != null)        
        {
            mPreviousRingtone.stop();
        } //End block
        mPreviousRingtone = getRingtone(mContext, getRingtoneUri(position), inferStreamType());
Ringtone varE3841A3D763ABF5CA41C4E2D0700A62A_278076852 =         mPreviousRingtone;
        varE3841A3D763ABF5CA41C4E2D0700A62A_278076852.addTaint(taint);
        return varE3841A3D763ABF5CA41C4E2D0700A62A_278076852;
        // ---------- Original Method ----------
        //if (mStopPreviousRingtone && mPreviousRingtone != null) {
            //mPreviousRingtone.stop();
        //}
        //mPreviousRingtone = getRingtone(mContext, getRingtoneUri(position), inferStreamType());
        //return mPreviousRingtone;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.134 -0400", hash_original_method = "4D2A1FDA5FCE10764EC2653DD3811CF2", hash_generated_method = "CA0CDD4DAFE80D8CB44E43B2251AA8E6")
    public Uri getRingtoneUri(int position) {
        addTaint(position);
        final Cursor cursor = getCursor();
        if(!cursor.moveToPosition(position))        
        {
Uri var540C13E9E156B687226421B24F2DF178_816862863 =             null;
            var540C13E9E156B687226421B24F2DF178_816862863.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_816862863;
        } //End block
Uri var2A644E3E4254A7B4229AC3F3F0E82486_859401017 =         getUriFromCursor(cursor);
        var2A644E3E4254A7B4229AC3F3F0E82486_859401017.addTaint(taint);
        return var2A644E3E4254A7B4229AC3F3F0E82486_859401017;
        // ---------- Original Method ----------
        //final Cursor cursor = getCursor();
        //if (!cursor.moveToPosition(position)) {
            //return null;
        //}
        //return getUriFromCursor(cursor);
    }

    
    @DSModeled(DSC.BAN)
    private static Uri getUriFromCursor(Cursor cursor) {
        return ContentUris.withAppendedId(Uri.parse(cursor.getString(URI_COLUMN_INDEX)), cursor
                .getLong(ID_COLUMN_INDEX));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.135 -0400", hash_original_method = "ED1F9D5C280AF9E93D506709043225B3", hash_generated_method = "0E68494C3DE8A317AAF01924B8A5B59E")
    public int getRingtonePosition(Uri ringtoneUri) {
        addTaint(ringtoneUri.getTaint());
        if(ringtoneUri == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1495668377 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556432628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_556432628;
        }
        final Cursor cursor = getCursor();
        final int cursorCount = cursor.getCount();
        if(!cursor.moveToFirst())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_209799972 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57508973 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57508973;
        } //End block
        Uri currentUri = null;
        String previousUriString = null;
for(int i = 0;i < cursorCount;i++)
        {
            String uriString = cursor.getString(URI_COLUMN_INDEX);
            if(currentUri == null || !uriString.equals(previousUriString))            
            {
                currentUri = Uri.parse(uriString);
            } //End block
            if(ringtoneUri.equals(ContentUris.withAppendedId(currentUri, cursor
                    .getLong(ID_COLUMN_INDEX))))            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1043073994 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597559240 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1597559240;
            } //End block
            cursor.move(1);
            previousUriString = uriString;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_332760388 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573766934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573766934;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri getValidRingtoneUri(Context context) {
        final RingtoneManager rm = new RingtoneManager(context);
        Uri uri = getValidRingtoneUriFromCursorAndClose(context, rm.getInternalRingtones());
        if (uri == null) {
            uri = getValidRingtoneUriFromCursorAndClose(context, rm.getMediaRingtones());
        }
        if (uri == null) {
            uri = getValidRingtoneUriFromCursorAndClose(context, rm.getDrmRingtones());
        }
        return uri;
    }

    
    @DSModeled(DSC.BAN)
    private static Uri getValidRingtoneUriFromCursorAndClose(Context context, Cursor cursor) {
        if (cursor != null) {
            Uri uri = null;
            if (cursor.moveToFirst()) {
                uri = getUriFromCursor(cursor);
            }
            cursor.close();
            return uri;
        } else {
            return null;
        }
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.136 -0400", hash_original_method = "110261102C7F5AFCA1139D9C233B8EDA", hash_generated_method = "FD91F80208D4777232954CB4CBEEF440")
    private Cursor getInternalRingtones() {
Cursor varD4117AB3E5F8CEF89663189BA800770F_1705425305 =         query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS,
                constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm),
                null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        varD4117AB3E5F8CEF89663189BA800770F_1705425305.addTaint(taint);
        return varD4117AB3E5F8CEF89663189BA800770F_1705425305;
        // ---------- Original Method ----------
        //return query(
                //MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS,
                //constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm),
                //null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.136 -0400", hash_original_method = "39880916742952A44000639C81C1DE13", hash_generated_method = "5292F3059AA94B71E24783FF1DEF44B5")
    private Cursor getDrmRingtones() {
Cursor var47CD44F0D9BC63FBCFE2300FDD4C6E5D_164776683 =         query(
                DrmStore.Audio.CONTENT_URI, DRM_COLUMNS,
                null, null, DrmStore.Audio.TITLE);
        var47CD44F0D9BC63FBCFE2300FDD4C6E5D_164776683.addTaint(taint);
        return var47CD44F0D9BC63FBCFE2300FDD4C6E5D_164776683;
        // ---------- Original Method ----------
        //return query(
                //DrmStore.Audio.CONTENT_URI, DRM_COLUMNS,
                //null, null, DrmStore.Audio.TITLE);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.137 -0400", hash_original_method = "2B8B74EFBA4661DD0239B341E05A9848", hash_generated_method = "73655EBF1F9B1C16AC82836A6A424B1E")
    private Cursor getMediaRingtones() {
        final String status = Environment.getExternalStorageState();
Cursor var4FD924592E964437FE0D0841E451D08B_1516967560 =         (status.equals(Environment.MEDIA_MOUNTED) ||
                    status.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
                ? query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS,
                    constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER)
                : null;
        var4FD924592E964437FE0D0841E451D08B_1516967560.addTaint(taint);
        return var4FD924592E964437FE0D0841E451D08B_1516967560;
        // ---------- Original Method ----------
        //final String status = Environment.getExternalStorageState();
        //return (status.equals(Environment.MEDIA_MOUNTED) ||
                    //status.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
                //? query(
                    //MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS,
                    //constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null,
                    //MediaStore.Audio.Media.DEFAULT_SORT_ORDER)
                //: null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.137 -0400", hash_original_method = "395BF736796D6FE27621FD0BAFF0C552", hash_generated_method = "D125AF7F13E9CF87215C4B3152A14638")
    private void setFilterColumnsList(int type) {
        addTaint(type);
        List<String> columns = mFilterColumns;
        columns.clear();
        if((type & TYPE_RINGTONE) != 0)        
        {
            columns.add(MediaStore.Audio.AudioColumns.IS_RINGTONE);
        } //End block
        if((type & TYPE_NOTIFICATION) != 0)        
        {
            columns.add(MediaStore.Audio.AudioColumns.IS_NOTIFICATION);
        } //End block
        if((type & TYPE_ALARM) != 0)        
        {
            columns.add(MediaStore.Audio.AudioColumns.IS_ALARM);
        } //End block
        // ---------- Original Method ----------
        //List<String> columns = mFilterColumns;
        //columns.clear();
        //if ((type & TYPE_RINGTONE) != 0) {
            //columns.add(MediaStore.Audio.AudioColumns.IS_RINGTONE);
        //}
        //if ((type & TYPE_NOTIFICATION) != 0) {
            //columns.add(MediaStore.Audio.AudioColumns.IS_NOTIFICATION);
        //}
        //if ((type & TYPE_ALARM) != 0) {
            //columns.add(MediaStore.Audio.AudioColumns.IS_ALARM);
        //}
    }

    
    @DSModeled(DSC.BAN)
    private static String constructBooleanTrueWhereClause(List<String> columns, boolean includeDrm) {
        if (columns == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = columns.size() - 1; i >= 0; i--) {
            sb.append(columns.get(i)).append("=1 or ");
        }
        if (columns.size() > 0) {
            sb.setLength(sb.length() - 4);
        }
        sb.append(")");
        if (!includeDrm) {
            sb.append(" and ");
            sb.append(MediaStore.MediaColumns.IS_DRM);
            sb.append("=0");
        }
        return sb.toString();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.139 -0400", hash_original_method = "4C1ED3200DB68E8363398CACE6114D33", hash_generated_method = "FFFC14B61F0AB83ED4245BF932319070")
    private Cursor query(Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        addTaint(sortOrder.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(uri.getTaint());
        if(mActivity != null)        
        {
Cursor var0CB94611966AFE0FC2A81B8A6B87045B_389684187 =             mActivity.managedQuery(uri, projection, selection, selectionArgs, sortOrder);
            var0CB94611966AFE0FC2A81B8A6B87045B_389684187.addTaint(taint);
            return var0CB94611966AFE0FC2A81B8A6B87045B_389684187;
        } //End block
        else
        {
Cursor varF51A46FC56B71DD50496E6BDEB727135_842273843 =             mContext.getContentResolver().query(uri, projection, selection, selectionArgs,
                    sortOrder);
            varF51A46FC56B71DD50496E6BDEB727135_842273843.addTaint(taint);
            return varF51A46FC56B71DD50496E6BDEB727135_842273843;
        } //End block
        // ---------- Original Method ----------
        //if (mActivity != null) {
            //return mActivity.managedQuery(uri, projection, selection, selectionArgs, sortOrder);
        //} else {
            //return mContext.getContentResolver().query(uri, projection, selection, selectionArgs,
                    //sortOrder);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    public static Ringtone getRingtone(final Context context, Uri ringtoneUri) {
        return getRingtone(context, ringtoneUri, -1);
    }

    
    @DSModeled(DSC.BAN)
    private static Ringtone getRingtone(final Context context, Uri ringtoneUri, int streamType) {
        try {
            Ringtone r = new Ringtone(context);
            if (streamType >= 0) {
                r.setStreamType(streamType);
            }
            r.open(ringtoneUri);
            return r;
        } catch (Exception ex) {
            Log.e(TAG, "Failed to open ringtone " + ringtoneUri);
        }
        return null;
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri getActualDefaultRingtoneUri(Context context, int type) {
        String setting = getSettingForType(type);
        if (setting == null) return null;
        final String uriString = Settings.System.getString(context.getContentResolver(), setting);
        return uriString != null ? Uri.parse(uriString) : null;
    }

    
    @DSModeled(DSC.SPEC)
    public static void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri) {
        String setting = getSettingForType(type);
        if (setting == null) return;
        Settings.System.putString(context.getContentResolver(), setting,
                ringtoneUri != null ? ringtoneUri.toString() : null);
    }

    
    @DSModeled(DSC.BAN)
    private static String getSettingForType(int type) {
        if ((type & TYPE_RINGTONE) != 0) {
            return Settings.System.RINGTONE;
        } else if ((type & TYPE_NOTIFICATION) != 0) {
            return Settings.System.NOTIFICATION_SOUND;
        } else if ((type & TYPE_ALARM) != 0) {
            return Settings.System.ALARM_ALERT;
        } else {
            return null;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean isDefault(Uri ringtoneUri) {
        return getDefaultType(ringtoneUri) != -1;
    }

    
    @DSModeled(DSC.SPEC)
    public static int getDefaultType(Uri defaultRingtoneUri) {
        if (defaultRingtoneUri == null) {
            return -1;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_RINGTONE_URI)) {
            return TYPE_RINGTONE;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
            return TYPE_NOTIFICATION;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_ALARM_ALERT_URI)) {
            return TYPE_ALARM;
        } else {
            return -1;
        }
    }

    
    @DSModeled(DSC.SPEC)
    public static Uri getDefaultUri(int type) {
        if ((type & TYPE_RINGTONE) != 0) {
            return Settings.System.DEFAULT_RINGTONE_URI;
        } else if ((type & TYPE_NOTIFICATION) != 0) {
            return Settings.System.DEFAULT_NOTIFICATION_URI;
        } else if ((type & TYPE_ALARM) != 0) {
            return Settings.System.DEFAULT_ALARM_ALERT_URI;
        } else {
            return null;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "A63116A0AD852471BBC62B1BE4D8E6C8", hash_generated_field = "3A6444404274E3DC8241965FB9932525")

    private static final String TAG = "RingtoneManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "436EA14184EBD4EA391647C9A1E3F366", hash_generated_field = "36AED4F7DACD7CC957251A67871BE640")

    public static final int TYPE_RINGTONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "FAA1628676E432F21F1A7DAB10136DEB", hash_generated_field = "029B501B321A75F003C8674A558A6A13")

    public static final int TYPE_NOTIFICATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "9AE155DC8DA981FF99D27280578E3166", hash_generated_field = "BBCA5A500FD53711269D32A2F6D1328A")

    public static final int TYPE_ALARM = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "C174A45E82FF02BD6C15CA3B24C627B1", hash_generated_field = "8B2416B9294AA23758C14C3C826B84A5")

    public static final int TYPE_ALL = TYPE_RINGTONE | TYPE_NOTIFICATION | TYPE_ALARM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.144 -0400", hash_original_field = "51F60B57D5A9748FF8EB258BB426BAEF", hash_generated_field = "4AA1B144EE9940BF925D60E76162F115")

    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "3BE86149B4E1CF719CFB07707EC5242B", hash_generated_field = "15B90050645A4B0ACA78D8B694436F94")

    public static final String EXTRA_RINGTONE_SHOW_DEFAULT =
            "android.intent.extra.ringtone.SHOW_DEFAULT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "D240AED19EA92F6F4B4B5010E589A90C", hash_generated_field = "566FBEBBF846BAC920B7D536448DA17F")

    public static final String EXTRA_RINGTONE_SHOW_SILENT =
            "android.intent.extra.ringtone.SHOW_SILENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "DC0D40037C7EFC955A620068CAE9FF35", hash_generated_field = "49C6E1F26784A85592AF2845B4B011A9")

    public static final String EXTRA_RINGTONE_INCLUDE_DRM =
            "android.intent.extra.ringtone.INCLUDE_DRM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "500248B5EB39B32F9C589025C086A487", hash_generated_field = "DD32E8C9C7605B6A0427DEBE5FB6649F")

    public static final String EXTRA_RINGTONE_EXISTING_URI =
            "android.intent.extra.ringtone.EXISTING_URI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "B79A5B7320F4333281CC13ADE79B0BCC", hash_generated_field = "2F864E5D7B1AA877297A60228AA9A231")

    public static final String EXTRA_RINGTONE_DEFAULT_URI =
            "android.intent.extra.ringtone.DEFAULT_URI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "526676E057185896D9BDF37F6F857016", hash_generated_field = "C886712EA1AD4EE9A27BB53E4D5C1193")

    public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "785E8F91312069A1825D750757F040BD", hash_generated_field = "C7EE82D78FAE0B28774C006E7072A1B3")

    public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "35553B6CFDB441DEE74228049A56F818", hash_generated_field = "D3C599A283BEDF7A8196BE7FBEA4D16A")

    public static final String EXTRA_RINGTONE_PICKED_URI =
            "android.intent.extra.ringtone.PICKED_URI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "034CF8A517D1F11D3686816A21D2DDE0", hash_generated_field = "61278DEB030EFDDB9C797A60BD51DDC9")

    private static final String[] INTERNAL_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.INTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "2578E0599C45134A6800272F01A3B36C", hash_generated_field = "F0072927626BA463B81C1FE14BA8DBE2")

    private static final String[] DRM_COLUMNS = new String[] {
        DrmStore.Audio._ID, DrmStore.Audio.TITLE,
        "\"" + DrmStore.Audio.CONTENT_URI + "\"",
        DrmStore.Audio.TITLE + " AS " + MediaStore.Audio.Media.TITLE_KEY
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "3467A42E43ECA1BA29DCB6CFED360435", hash_generated_field = "A46619D87F6A6621C78234992B75AC16")

    private static final String[] MEDIA_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "1CBAAE6A7EA2073B4356188DDFBA3FBC", hash_generated_field = "1A310793E4749C0228E19D15A9145CA7")

    public static final int ID_COLUMN_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "2EFBE5D3411F97D73EDE7025F975E79A", hash_generated_field = "E6A1D3DFD42B4AC10515625F810A6BAD")

    public static final int TITLE_COLUMN_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:17.145 -0400", hash_original_field = "0AB66C1BDC76EDA721C6C59A156F0946", hash_generated_field = "D5F147507D1EF1CAC5885574BB55F033")

    public static final int URI_COLUMN_INDEX = 2;
}

