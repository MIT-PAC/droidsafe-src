package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;

public class Ringtone {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.964 -0500", hash_original_method = "7C7E876780A603240D42A5BB96522037", hash_generated_method = "EAAD1702E472810FAA2CF3F810517246")
    
private static String getTitle(Context context, Uri uri, boolean followSettingsUri) {
        Cursor cursor = null;
        ContentResolver res = context.getContentResolver();
        
        String title = null;

        if (uri != null) {
            String authority = uri.getAuthority();

            if (Settings.AUTHORITY.equals(authority)) {
                if (followSettingsUri) {
                    Uri actualUri = RingtoneManager.getActualDefaultRingtoneUri(context,
                            RingtoneManager.getDefaultType(uri));
                    String actualTitle = getTitle(context, actualUri, false);
                    title = context
                            .getString(com.android.internal.R.string.ringtone_default_with_actual,
                                    actualTitle);
                }
            } else {
                
                if (DrmStore.AUTHORITY.equals(authority)) {
                    cursor = res.query(uri, DRM_COLUMNS, null, null, null);
                } else if (MediaStore.AUTHORITY.equals(authority)) {
                    cursor = res.query(uri, MEDIA_COLUMNS, null, null, null);
                }
                
                try {
                    if (cursor != null && cursor.getCount() == 1) {
                        cursor.moveToFirst();
                        return cursor.getString(2);
                    } else {
                        title = uri.getLastPathSegment();
                    }
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }

        if (title == null) {
            title = context.getString(com.android.internal.R.string.ringtone_unknown);
            
            if (title == null) {
                title = "";
            }
        }
        
        return title;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.927 -0500", hash_original_field = "F291506CBE2EA90D9EA25E6AD0A4EEA0", hash_generated_field = "E713CD010BF5D6DDAFC0491CA9A150F9")

    private static String TAG = "Ringtone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.929 -0500", hash_original_field = "560B665A142B68230F4465A1C59C24C9", hash_generated_field = "9C933AC05E3167A254DFD7049D6C5A3D")

    private static final String[] MEDIA_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.DATA,
        MediaStore.Audio.Media.TITLE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.932 -0500", hash_original_field = "49CF46E8760538BC04BCF36CF117C555", hash_generated_field = "12C48621F14CD9EBFF2B9F5D2C5B747B")

    private static final String[] DRM_COLUMNS = new String[] {
        DrmStore.Audio._ID,
        DrmStore.Audio.DATA,
        DrmStore.Audio.TITLE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.934 -0500", hash_original_field = "114D6930502EB051599FDF53068B5EF9", hash_generated_field = "29CF01719F6820D08330DF490C891644")

    private MediaPlayer mAudio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.936 -0500", hash_original_field = "49226456B4CE4E55A779249DE3DC63D4", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.938 -0500", hash_original_field = "16E0C5A3FE98D2D22AD69EC7A123442F", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

    private String mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.941 -0500", hash_original_field = "3DDF6F67F19B0814E8DAB7B3CFFED3B7", hash_generated_field = "58A1B3A123725E48931BD35C0EB2D4CB")

    private FileDescriptor mFileDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.943 -0500", hash_original_field = "3AD3C99572C02A10C19EE987B38F31EB", hash_generated_field = "42013BEA58DB5CF2CBDDDD7864338432")

    private AssetFileDescriptor mAssetFileDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.946 -0500", hash_original_field = "60852FBB34E58AF261BF32523C542C38", hash_generated_field = "6500983E788303EA2D93C21805BCE618")

    private int mStreamType = AudioManager.STREAM_RING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.948 -0500", hash_original_field = "81931559493F052ED78BA000FD1BC717", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.950 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.953 -0500", hash_original_method = "6365B663239886F10DC7E25536BA8CE2", hash_generated_method = "6365B663239886F10DC7E25536BA8CE2")
    
Ringtone(Context context) {
        mContext = context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    }

    /**
     * Sets the stream type where this ringtone will be played.
     * 
     * @param streamType The stream, see {@link AudioManager}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.955 -0500", hash_original_method = "F5CC923451A07D4657129E70BA4A3BAD", hash_generated_method = "EDAD9F39DFEA1BCA5B89200BCF36CAA0")
    
public void setStreamType(int streamType) {
        mStreamType = streamType;
        
        if (mAudio != null) {
            /*
             * The stream type has to be set before the media player is
             * prepared. Re-initialize it.
             */
            try {
                openMediaPlayer();
            } catch (IOException e) {
                Log.w(TAG, "Couldn't set the stream type", e);
            }
        }
    }

    /**
     * Gets the stream type where this ringtone will be played.
     * 
     * @return The stream type, see {@link AudioManager}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.958 -0500", hash_original_method = "216E9F6C8E5136791318AC3D24F88326", hash_generated_method = "F7BEAF5998981A9DDFFDF515BD2883C7")
    
public int getStreamType() {
        return mStreamType;
    }

    /**
     * Returns a human-presentable title for ringtone. Looks in media and DRM
     * content providers. If not in either, uses the filename
     * 
     * @param context A context used for querying. 
     */
    @DSComment("Droidsafe will catch when app does something with the getTitle")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.960 -0500", hash_original_method = "9AA0FF99679830890209304DA3B8D69B", hash_generated_method = "6E3AD98B144BB627B392050A53FFE9BE")
    
public String getTitle(Context context) {
        if (mTitle != null) return mTitle;
        return mTitle = getTitle(context, mUri, true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.967 -0500", hash_original_method = "3D9FD67EE5212878A40EB00FDD255FB4", hash_generated_method = "64022A1AA54923F2F5BCB6D43B903CE2")
    
private void openMediaPlayer() throws IOException {
        if (mAudio != null) {
            mAudio.release();
        }
        mAudio = new MediaPlayer();
        if (mUri != null) {
            mAudio.setDataSource(mContext, mUri);
        } else if (mFileDescriptor != null) {
            mAudio.setDataSource(mFileDescriptor);
        } else if (mAssetFileDescriptor != null) {
            // Note: using getDeclaredLength so that our behavior is the same
            // as previous versions when the content provider is returning
            // a full file.
            if (mAssetFileDescriptor.getDeclaredLength() < 0) {
                mAudio.setDataSource(mAssetFileDescriptor.getFileDescriptor());
            } else {
                mAudio.setDataSource(mAssetFileDescriptor.getFileDescriptor(),
                        mAssetFileDescriptor.getStartOffset(),
                        mAssetFileDescriptor.getDeclaredLength());
            }
        } else {
            throw new IOException("No data source set.");
        }
        mAudio.setAudioStreamType(mStreamType);
        mAudio.prepare();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.969 -0500", hash_original_method = "CD193C4ECAE3F3E852CEEC2F9F6DE33F", hash_generated_method = "CD193C4ECAE3F3E852CEEC2F9F6DE33F")
    
void open(FileDescriptor fd) throws IOException {
        mFileDescriptor = fd;
        openMediaPlayer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.972 -0500", hash_original_method = "5CEC2029E42F2A9E18E70ED996F72E6E", hash_generated_method = "5CEC2029E42F2A9E18E70ED996F72E6E")
    
void open(AssetFileDescriptor fd) throws IOException {
        mAssetFileDescriptor = fd;
        openMediaPlayer();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.974 -0500", hash_original_method = "B6A9AEC7559EAFEEA670C63D280E78C6", hash_generated_method = "B6A9AEC7559EAFEEA670C63D280E78C6")
    
void open(Uri uri) throws IOException {
        mUri = uri;
        openMediaPlayer();
    }

    /**
     * Plays the ringtone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.977 -0500", hash_original_method = "F9F3FD902406E9F982D2A30CB15B8CC4", hash_generated_method = "D19C91221B1080DB646063B49CD92AD8")
    
public void play() {
        if (mAudio == null) {
            try {
                openMediaPlayer();
            } catch (Exception ex) {
                Log.e(TAG, "play() caught ", ex);
                mAudio = null;
            }
        }
        if (mAudio != null) {
            // do not ringtones if stream volume is 0
            // (typically because ringer mode is silent).
            if (mAudioManager.getStreamVolume(mStreamType) != 0) {
                mAudio.start();
            }
        }
    }

    /**
     * Stops a playing ringtone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.979 -0500", hash_original_method = "25B57E3869C6FCC0565FBD24EEAB9FA0", hash_generated_method = "D54276E98CE38A3B15A1D16585CD8968")
    
public void stop() {
        if (mAudio != null) {
            mAudio.reset();
            mAudio.release();
            mAudio = null;
        }
    }

    /**
     * Whether this ringtone is currently playing.
     * 
     * @return True if playing, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.981 -0500", hash_original_method = "0CA36CF7485684069EDD095AE8455157", hash_generated_method = "113EE03FEC2AB5B9B31E6309FF6709D4")
    
public boolean isPlaying() {
        return mAudio != null && mAudio.isPlaying();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:26.983 -0500", hash_original_method = "A4C423176AB11C87E288F89C31FDE32A", hash_generated_method = "A4C423176AB11C87E288F89C31FDE32A")
    
void setTitle(String title) {
        mTitle = title;
    }
}

