package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;

public class Ringtone {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "1485DC20EE331C508F2D09C5AE35FE29", hash_generated_field = "29CF01719F6820D08330DF490C891644")

    private MediaPlayer mAudio;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "5FBE3730DCFF234F97B15868D5CE649D", hash_generated_field = "04FA8EB5D9FB8AC4AAE6453BCF1BBF82")

    private Uri mUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "F874AFA927FA7D19042AF93F53067D66")

    private String mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "D118306A98C1E7C12AA828417A60A6F6", hash_generated_field = "58A1B3A123725E48931BD35C0EB2D4CB")

    private FileDescriptor mFileDescriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "28CC083CE5A0F97D22B3E19E1925252A", hash_generated_field = "42013BEA58DB5CF2CBDDDD7864338432")

    private AssetFileDescriptor mAssetFileDescriptor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "17B126C8F3D819883BBD73D9CDD16EDC", hash_generated_field = "6500983E788303EA2D93C21805BCE618")

    private int mStreamType = AudioManager.STREAM_RING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.586 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.587 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.587 -0400", hash_original_method = "6365B663239886F10DC7E25536BA8CE2", hash_generated_method = "5B775A5D7612956A62F1637BA30F4B99")
      Ringtone(Context context) {
        mContext = context;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        // ---------- Original Method ----------
        //mContext = context;
        //mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.588 -0400", hash_original_method = "F5CC923451A07D4657129E70BA4A3BAD", hash_generated_method = "D68CC9926AC4D62AAE420C3D681D49E6")
    public void setStreamType(int streamType) {
        mStreamType = streamType;
    if(mAudio != null)        
        {
            try 
            {
                openMediaPlayer();
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mStreamType = streamType;
        //if (mAudio != null) {
            //try {
                //openMediaPlayer();
            //} catch (IOException e) {
                //Log.w(TAG, "Couldn't set the stream type", e);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.588 -0400", hash_original_method = "216E9F6C8E5136791318AC3D24F88326", hash_generated_method = "710C3B13AF8327A887699CA3A281AB64")
    public int getStreamType() {
        int var783FA5525F6B978FF64D8BA5B67966D9_1012808579 = (mStreamType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242008449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242008449;
        // ---------- Original Method ----------
        //return mStreamType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.589 -0400", hash_original_method = "9AA0FF99679830890209304DA3B8D69B", hash_generated_method = "75E2991060467CB21ABA7D71435AC380")
    public String getTitle(Context context) {
    if(mTitle != null)        
        {
String var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1971714670 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1971714670.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_1971714670;
        }
String varD044B7BC8179EF64E9AD64248361B60E_417355270 =         mTitle = getTitle(context, mUri, true);
        varD044B7BC8179EF64E9AD64248361B60E_417355270.addTaint(taint);
        return varD044B7BC8179EF64E9AD64248361B60E_417355270;
        // ---------- Original Method ----------
        //if (mTitle != null) return mTitle;
        //return mTitle = getTitle(context, mUri, true);
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.591 -0400", hash_original_method = "3D9FD67EE5212878A40EB00FDD255FB4", hash_generated_method = "A249507B0B721A08A8869CA1AFA98B5A")
    private void openMediaPlayer() throws IOException {
    if(mAudio != null)        
        {
            mAudio.release();
        } //End block
        mAudio = new MediaPlayer();
    if(mUri != null)        
        {
            mAudio.setDataSource(mContext, mUri);
        } //End block
        else
    if(mFileDescriptor != null)        
        {
            mAudio.setDataSource(mFileDescriptor);
        } //End block
        else
    if(mAssetFileDescriptor != null)        
        {
    if(mAssetFileDescriptor.getDeclaredLength() < 0)            
            {
                mAudio.setDataSource(mAssetFileDescriptor.getFileDescriptor());
            } //End block
            else
            {
                mAudio.setDataSource(mAssetFileDescriptor.getFileDescriptor(),
                        mAssetFileDescriptor.getStartOffset(),
                        mAssetFileDescriptor.getDeclaredLength());
            } //End block
        } //End block
        else
        {
            IOException var05ADE79C1C912CC1630305AC8B172C70_27938703 = new IOException("No data source set.");
            var05ADE79C1C912CC1630305AC8B172C70_27938703.addTaint(taint);
            throw var05ADE79C1C912CC1630305AC8B172C70_27938703;
        } //End block
        mAudio.setAudioStreamType(mStreamType);
        mAudio.prepare();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.592 -0400", hash_original_method = "CD193C4ECAE3F3E852CEEC2F9F6DE33F", hash_generated_method = "6E440128979DE1B556EC96677E628E72")
     void open(FileDescriptor fd) throws IOException {
        mFileDescriptor = fd;
        openMediaPlayer();
        // ---------- Original Method ----------
        //mFileDescriptor = fd;
        //openMediaPlayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.592 -0400", hash_original_method = "5CEC2029E42F2A9E18E70ED996F72E6E", hash_generated_method = "FE4C6631E2E7414EFF0FC6D38B9FC9D8")
     void open(AssetFileDescriptor fd) throws IOException {
        mAssetFileDescriptor = fd;
        openMediaPlayer();
        // ---------- Original Method ----------
        //mAssetFileDescriptor = fd;
        //openMediaPlayer();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.593 -0400", hash_original_method = "B6A9AEC7559EAFEEA670C63D280E78C6", hash_generated_method = "CC871095B008BACC4821A90FC2E0903B")
     void open(Uri uri) throws IOException {
        mUri = uri;
        openMediaPlayer();
        // ---------- Original Method ----------
        //mUri = uri;
        //openMediaPlayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.593 -0400", hash_original_method = "F9F3FD902406E9F982D2A30CB15B8CC4", hash_generated_method = "025993BE21D0804BE2BB6B81447DD549")
    public void play() {
    if(mAudio == null)        
        {
            try 
            {
                openMediaPlayer();
            } //End block
            catch (Exception ex)
            {
                mAudio = null;
            } //End block
        } //End block
    if(mAudio != null)        
        {
    if(mAudioManager.getStreamVolume(mStreamType) != 0)            
            {
                mAudio.start();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAudio == null) {
            //try {
                //openMediaPlayer();
            //} catch (Exception ex) {
                //Log.e(TAG, "play() caught ", ex);
                //mAudio = null;
            //}
        //}
        //if (mAudio != null) {
            //if (mAudioManager.getStreamVolume(mStreamType) != 0) {
                //mAudio.start();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.594 -0400", hash_original_method = "25B57E3869C6FCC0565FBD24EEAB9FA0", hash_generated_method = "EC664D09CC4243E364C4FCA09072AE6B")
    public void stop() {
    if(mAudio != null)        
        {
            mAudio.reset();
            mAudio.release();
            mAudio = null;
        } //End block
        // ---------- Original Method ----------
        //if (mAudio != null) {
            //mAudio.reset();
            //mAudio.release();
            //mAudio = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.594 -0400", hash_original_method = "0CA36CF7485684069EDD095AE8455157", hash_generated_method = "4E9118F96C4BA58D8145BDF1CAE1F021")
    public boolean isPlaying() {
        boolean var9F7141D2644A06BB137EBA742B0EA563_1744200801 = (mAudio != null && mAudio.isPlaying());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274209529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274209529;
        // ---------- Original Method ----------
        //return mAudio != null && mAudio.isPlaying();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.594 -0400", hash_original_method = "A4C423176AB11C87E288F89C31FDE32A", hash_generated_method = "AE61B60E95D4F73DC4620FEAE2B8EF54")
     void setTitle(String title) {
        mTitle = title;
        // ---------- Original Method ----------
        //mTitle = title;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.595 -0400", hash_original_field = "52E314C4A9F9011B8CF9C3E02D05FB4F", hash_generated_field = "E713CD010BF5D6DDAFC0491CA9A150F9")

    private static String TAG = "Ringtone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.595 -0400", hash_original_field = "ED30326A6779F797CECF2465408CE865", hash_generated_field = "9C933AC05E3167A254DFD7049D6C5A3D")

    private static final String[] MEDIA_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID,
        MediaStore.Audio.Media.DATA,
        MediaStore.Audio.Media.TITLE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.595 -0400", hash_original_field = "F80260C14244D8A6AB91459C5D03CAB4", hash_generated_field = "12C48621F14CD9EBFF2B9F5D2C5B747B")

    private static final String[] DRM_COLUMNS = new String[] {
        DrmStore.Audio._ID,
        DrmStore.Audio.DATA,
        DrmStore.Audio.TITLE
    };
}

