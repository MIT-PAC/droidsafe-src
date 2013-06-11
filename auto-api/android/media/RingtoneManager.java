package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.database.SortCursor;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;
import android.provider.Settings.System;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class RingtoneManager {
    private static final String TAG = "RingtoneManager";
    public static final int TYPE_RINGTONE = 1;
    public static final int TYPE_NOTIFICATION = 2;
    public static final int TYPE_ALARM = 4;
    public static final int TYPE_ALL = TYPE_RINGTONE | TYPE_NOTIFICATION | TYPE_ALARM;
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
    public static final String EXTRA_RINGTONE_SHOW_DEFAULT =
            "android.intent.extra.ringtone.SHOW_DEFAULT";
    public static final String EXTRA_RINGTONE_SHOW_SILENT =
            "android.intent.extra.ringtone.SHOW_SILENT";
    public static final String EXTRA_RINGTONE_INCLUDE_DRM =
            "android.intent.extra.ringtone.INCLUDE_DRM";
    public static final String EXTRA_RINGTONE_EXISTING_URI =
            "android.intent.extra.ringtone.EXISTING_URI";
    public static final String EXTRA_RINGTONE_DEFAULT_URI =
            "android.intent.extra.ringtone.DEFAULT_URI";
    public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
    public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
    public static final String EXTRA_RINGTONE_PICKED_URI =
            "android.intent.extra.ringtone.PICKED_URI";
    private static final String[] INTERNAL_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.INTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
    private static final String[] DRM_COLUMNS = new String[] {
        DrmStore.Audio._ID, DrmStore.Audio.TITLE,
        "\"" + DrmStore.Audio.CONTENT_URI + "\"",
        DrmStore.Audio.TITLE + " AS " + MediaStore.Audio.Media.TITLE_KEY
    };
    private static final String[] MEDIA_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
    public static final int ID_COLUMN_INDEX = 0;
    public static final int TITLE_COLUMN_INDEX = 1;
    public static final int URI_COLUMN_INDEX = 2;
    private Activity mActivity;
    private Context mContext;
    private Cursor mCursor;
    private int mType = TYPE_RINGTONE;
    private List<String> mFilterColumns = new ArrayList<String>();
    private boolean mStopPreviousRingtone = true;
    private Ringtone mPreviousRingtone;
    private boolean mIncludeDrm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.958 -0400", hash_original_method = "2A8A1FC42FD49A3D281BB8A7356537D2", hash_generated_method = "17C4551055CB1A1BA00EF15B2DFDAE49")
    @DSModeled(DSC.SAFE)
    public RingtoneManager(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        mContext = mActivity = activity;
        setType(mType);
        // ---------- Original Method ----------
        //mContext = mActivity = activity;
        //setType(mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.959 -0400", hash_original_method = "AEFBB2F4D30FA9949534E3B15FD9C787", hash_generated_method = "E9ABA2DCCB7AA6FA0136C5970FB22B5C")
    @DSModeled(DSC.SAFE)
    public RingtoneManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        setType(mType);
        // ---------- Original Method ----------
        //mContext = context;
        //setType(mType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.959 -0400", hash_original_method = "9DE86AC52EF0C8E8314EB0C63463BFAA", hash_generated_method = "D0CED2797D45B4DA4E5560A638016D9A")
    @DSModeled(DSC.SAFE)
    public void setType(int type) {
        dsTaint.addTaint(type);
        {
            throw new IllegalStateException(
                    "Setting filter columns should be done before querying for ringtones.");
        } //End block
        setFilterColumnsList(type);
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //throw new IllegalStateException(
                    //"Setting filter columns should be done before querying for ringtones.");
        //}
        //mType = type;
        //setFilterColumnsList(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "26C25231B8EE38423D74AE317EB8CDCC", hash_generated_method = "32255359BF2522D1F05760C974583BA9")
    @DSModeled(DSC.SAFE)
    public int inferStreamType() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "A35CDF85342D56F6EFBA8853AE857D3A", hash_generated_method = "24328B3806E5EBDF6BE90FA751B87792")
    @DSModeled(DSC.SAFE)
    public void setStopPreviousRingtone(boolean stopPreviousRingtone) {
        dsTaint.addTaint(stopPreviousRingtone);
        // ---------- Original Method ----------
        //mStopPreviousRingtone = stopPreviousRingtone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "0B3E7FCD199769A7D560D3943A8B1B23", hash_generated_method = "0F3B4999DA3CAE350681D548DE92A751")
    @DSModeled(DSC.SAFE)
    public boolean getStopPreviousRingtone() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStopPreviousRingtone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "A83DE0FFAA4D869AA2ED1763D4647132", hash_generated_method = "598DB9DB7C7FC5E940A65B6AB07B416A")
    @DSModeled(DSC.SAFE)
    public void stopPreviousRingtone() {
        {
            mPreviousRingtone.stop();
        } //End block
        // ---------- Original Method ----------
        //if (mPreviousRingtone != null) {
            //mPreviousRingtone.stop();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "9F2D30C6202871DC182E5AD2A88B91B1", hash_generated_method = "18442C3914D5BC84D617EED5B15EA0D1")
    @DSModeled(DSC.SAFE)
    public boolean getIncludeDrm() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIncludeDrm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "9AE3415FBA2FD0FC22ED2C93FA9F8016", hash_generated_method = "570ABD7866227328AD0CCDA0B7BF69F5")
    @DSModeled(DSC.SAFE)
    public void setIncludeDrm(boolean includeDrm) {
        dsTaint.addTaint(includeDrm);
        // ---------- Original Method ----------
        //mIncludeDrm = includeDrm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "890985AD9BCFC1049E02A6DFBECAA43E", hash_generated_method = "FBA6DC874ECFD0ACC2267BB95A05A739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Cursor getCursor() {
        {
            boolean var56F133B1E4E26D8C4503BB0313204B00_1006959593 = (mCursor != null && mCursor.requery());
        } //End collapsed parenthetic
        final Cursor internalCursor;
        internalCursor = getInternalRingtones();
        final Cursor drmCursor;
        drmCursor = getDrmRingtones();
        drmCursor = null;
        final Cursor mediaCursor;
        mediaCursor = getMediaRingtones();
        Cursor var724F8A75704A5D6E2945FF4DCE809969_1677735320 = (mCursor = new SortCursor(new Cursor[] { internalCursor, drmCursor, mediaCursor },
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER));
        return (Cursor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.960 -0400", hash_original_method = "6FCC5829E72C1DEF0426E1D999C80198", hash_generated_method = "18347C3C5557722EAA0E1FAD5D2C7510")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Ringtone getRingtone(int position) {
        dsTaint.addTaint(position);
        {
            mPreviousRingtone.stop();
        } //End block
        mPreviousRingtone = getRingtone(mContext, getRingtoneUri(position), inferStreamType());
        return (Ringtone)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mStopPreviousRingtone && mPreviousRingtone != null) {
            //mPreviousRingtone.stop();
        //}
        //mPreviousRingtone = getRingtone(mContext, getRingtoneUri(position), inferStreamType());
        //return mPreviousRingtone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "4D2A1FDA5FCE10764EC2653DD3811CF2", hash_generated_method = "9D95C53032699423BC6BE4DB3213E0DA")
    @DSModeled(DSC.SPEC)
    public Uri getRingtoneUri(int position) {
        dsTaint.addTaint(position);
        final Cursor cursor;
        cursor = getCursor();
        {
            boolean var8019D5C6E1152EBC78C83E0BD4AB416F_1800364881 = (!cursor.moveToPosition(position));
        } //End collapsed parenthetic
        Uri var307CC7C61E9DD7EA4E79FC968B1EC36C_1746620894 = (getUriFromCursor(cursor));
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Cursor cursor = getCursor();
        //if (!cursor.moveToPosition(position)) {
            //return null;
        //}
        //return getUriFromCursor(cursor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "DBC47BF2F28DE087272A0362AE49A9BD", hash_generated_method = "39659D7CC381EF0219D84A11D816E499")
    private static Uri getUriFromCursor(Cursor cursor) {
        return ContentUris.withAppendedId(Uri.parse(cursor.getString(URI_COLUMN_INDEX)), cursor
                .getLong(ID_COLUMN_INDEX));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "ED1F9D5C280AF9E93D506709043225B3", hash_generated_method = "AD04F8A729024E5EF72DA92B0015CA4E")
    @DSModeled(DSC.SPEC)
    public int getRingtonePosition(Uri ringtoneUri) {
        dsTaint.addTaint(ringtoneUri.dsTaint);
        final Cursor cursor;
        cursor = getCursor();
        final int cursorCount;
        cursorCount = cursor.getCount();
        {
            boolean var8CA1A59F12E68FA1385EF044160891FD_2000176261 = (!cursor.moveToFirst());
        } //End collapsed parenthetic
        Uri currentUri;
        currentUri = null;
        String previousUriString;
        previousUriString = null;
        {
            int i;
            i = 0;
            {
                String uriString;
                uriString = cursor.getString(URI_COLUMN_INDEX);
                {
                    boolean varC997FC1837D72A7AF153F761133B4012_1752954177 = (currentUri == null || !uriString.equals(previousUriString));
                    {
                        currentUri = Uri.parse(uriString);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var00B6CE91FBF9F9AE2288DFAF9A20C9A4_360098258 = (ringtoneUri.equals(ContentUris.withAppendedId(currentUri, cursor
                    .getLong(ID_COLUMN_INDEX))));
                } //End collapsed parenthetic
                cursor.move(1);
                previousUriString = uriString;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "1192D831CE26227FD11FFFE1931A718B", hash_generated_method = "466760483F9E9AACC037C910489C8077")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "6D36BC3A825A2854EC540CE79E0ECBCE", hash_generated_method = "EF8061E2A5A3CB2651093307549053D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.961 -0400", hash_original_method = "110261102C7F5AFCA1139D9C233B8EDA", hash_generated_method = "9C901B67251A5E8CE30597413C41FDFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Cursor getInternalRingtones() {
        Cursor var4361E63CBCFC344E4C4D33E55175A61A_243398522 = (query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS,
                constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm),
                null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(
                //MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS,
                //constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm),
                //null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "39880916742952A44000639C81C1DE13", hash_generated_method = "BF9DC294BD8A3414D50A41882F8DDB56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Cursor getDrmRingtones() {
        Cursor var094CBB968069157D64CCEC69A2FC85A9_727121056 = (query(
                DrmStore.Audio.CONTENT_URI, DRM_COLUMNS,
                null, null, DrmStore.Audio.TITLE));
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return query(
                //DrmStore.Audio.CONTENT_URI, DRM_COLUMNS,
                //null, null, DrmStore.Audio.TITLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "2B8B74EFBA4661DD0239B341E05A9848", hash_generated_method = "BC7581BB57F1679DCA2E731F75D89676")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Cursor getMediaRingtones() {
        final String status;
        status = Environment.getExternalStorageState();
        {
            boolean var99B4DD84D94C7A5EB0ED3A96F7F42C53_96408521 = ((status.equals(Environment.MEDIA_MOUNTED) ||
                    status.equals(Environment.MEDIA_MOUNTED_READ_ONLY)));
            Object varAE5D269A50649CB96432B77BF6598AD5_1125870830 = (query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS,
                    constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER));
        } //End flattened ternary
        return (Cursor)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "395BF736796D6FE27621FD0BAFF0C552", hash_generated_method = "38642269B942CF2FA1D642928E9AC499")
    @DSModeled(DSC.SAFE)
    private void setFilterColumnsList(int type) {
        dsTaint.addTaint(type);
        List<String> columns;
        columns = mFilterColumns;
        columns.clear();
        {
            columns.add(MediaStore.Audio.AudioColumns.IS_RINGTONE);
        } //End block
        {
            columns.add(MediaStore.Audio.AudioColumns.IS_NOTIFICATION);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "ABDE2603E3E0183A07EE30B4903BA6A9", hash_generated_method = "A88E459FD9754E8601A429B50E4098A2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "4C1ED3200DB68E8363398CACE6114D33", hash_generated_method = "C61B56CAF3A4DB33A9EDD635E28F8568")
    @DSModeled(DSC.SPEC)
    private Cursor query(Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        dsTaint.addTaint(selectionArgs);
        dsTaint.addTaint(sortOrder);
        dsTaint.addTaint(projection);
        dsTaint.addTaint(uri.dsTaint);
        dsTaint.addTaint(selection);
        {
            Cursor var9D24961727BCCDD87C99E89A32CE072B_791207498 = (mActivity.managedQuery(uri, projection, selection, selectionArgs, sortOrder));
        } //End block
        {
            Cursor var7927E9F6548753ED426C442B3E05C155_2085914849 = (mContext.getContentResolver().query(uri, projection, selection, selectionArgs,
                    sortOrder));
        } //End block
        return (Cursor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActivity != null) {
            //return mActivity.managedQuery(uri, projection, selection, selectionArgs, sortOrder);
        //} else {
            //return mContext.getContentResolver().query(uri, projection, selection, selectionArgs,
                    //sortOrder);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "2EEAD7205454E4D34A279A8E10F02588", hash_generated_method = "CA4129FB5DA793FFFAED68FF384DFCF1")
    public static Ringtone getRingtone(final Context context, Uri ringtoneUri) {
        return getRingtone(context, ringtoneUri, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.962 -0400", hash_original_method = "BAE78D92DE6F84ECF15BBF8C83F31BAC", hash_generated_method = "FCF2D9662DD529F86BACBE6E446EFBB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "ADF1ADA5ADFEAE953CF8C758A8A3E876", hash_generated_method = "432781D47D54B0365C059BF27B31EDE0")
    public static Uri getActualDefaultRingtoneUri(Context context, int type) {
        String setting = getSettingForType(type);
        if (setting == null) return null;
        final String uriString = Settings.System.getString(context.getContentResolver(), setting);
        return uriString != null ? Uri.parse(uriString) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "7F35A6FA4FCD4A3BDBAD3E9C2A20C1FB", hash_generated_method = "D114430764B3B3ED4C9F3C4F7A8FBEC1")
    public static void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri) {
        String setting = getSettingForType(type);
        if (setting == null) return;
        Settings.System.putString(context.getContentResolver(), setting,
                ringtoneUri != null ? ringtoneUri.toString() : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "80EF3F46842B7A46317143BED17C21C8", hash_generated_method = "4CDBD97CED152A19231DA6FCA29BBEDB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "A5F67B0DE383F4D74803ECD8836ECBBD", hash_generated_method = "07A0F4F4C6159FCAA99C5030B2808C03")
    public static boolean isDefault(Uri ringtoneUri) {
        return getDefaultType(ringtoneUri) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "7F2381BA185DA4A8E1D41167C61F9114", hash_generated_method = "5440D566E4F3C1ADAE4D1F50416CC394")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.963 -0400", hash_original_method = "C50204A078065E3CC44987C7DD4E9366", hash_generated_method = "BA0EBD10CA93FA259E6B3A424544ABA1")
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

    
}


