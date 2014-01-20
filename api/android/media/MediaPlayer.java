package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;

import droidsafe.helpers.DSUtils;

public class MediaPlayer {

    /**
     * Convenience method to create a MediaPlayer for a given Uri.
     * On success, {@link #prepare()} will already have been called and must not be called again.
     * <p>When done with the MediaPlayer, you should call  {@link #release()},
     * to free the resources. If not released, too many MediaPlayer instances will
     * result in an exception.</p>
     *
     * @param context the Context to use
     * @param uri the Uri from which to get the datasource
     * @return a MediaPlayer object, or null if creation failed
     */
    @DSComment("Media source is remote")
    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.637 -0500", hash_original_method = "88A45C64C97A87F55B3C35AEDBC4AEE9", hash_generated_method = "54928E1D9B77BF22D6A2D9FC63E0FB4A")
    
public static MediaPlayer create(Context context, Uri uri) {
        return create (context, uri, null);
    }

    /**
     * Convenience method to create a MediaPlayer for a given Uri.
     * On success, {@link #prepare()} will already have been called and must not be called again.
     * <p>When done with the MediaPlayer, you should call  {@link #release()},
     * to free the resources. If not released, too many MediaPlayer instances will
     * result in an exception.</p>
     *
     * @param context the Context to use
     * @param uri the Uri from which to get the datasource
     * @param holder the SurfaceHolder to use for displaying the video
     * @return a MediaPlayer object, or null if creation failed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.640 -0500", hash_original_method = "F1EC723DE0CD6316DF7D958E77DE1A55", hash_generated_method = "A6620CEC06F6001100387B20DEA57015")
    
public static MediaPlayer create(Context context, Uri uri, SurfaceHolder holder) {

        try {
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(context, uri);
            if (holder != null) {
                mp.setDisplay(holder);
            }
            mp.prepare();
            return mp;
        } catch (IOException ex) {
            Log.d(TAG, "create failed:", ex);
            // fall through
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "create failed:", ex);
            // fall through
        } catch (SecurityException ex) {
            Log.d(TAG, "create failed:", ex);
            // fall through
        }

        return null;
    }

    // Note no convenience method to create a MediaPlayer with SurfaceTexture sink.

    /**
     * Convenience method to create a MediaPlayer for a given resource id.
     * On success, {@link #prepare()} will already have been called and must not be called again.
     * <p>When done with the MediaPlayer, you should call  {@link #release()},
     * to free the resources. If not released, too many MediaPlayer instances will
     * result in an exception.</p>
     *
     * @param context the Context to use
     * @param resid the raw resource id (<var>R.raw.&lt;something></var>) for
     *              the resource to use as the datasource
     * @return a MediaPlayer object, or null if creation failed
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.643 -0500", hash_original_method = "1847FF960BCBE3D985D6E04CB323491E", hash_generated_method = "DF793324D9BE34784BB9E5DC61A87520")
    
public static MediaPlayer create(Context context, int resid) {
        try {
            AssetFileDescriptor afd = context.getResources().openRawResourceFd(resid);
            if (afd == null) return null;

            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
            return mp;
        } catch (IOException ex) {
            Log.d(TAG, "create failed:", ex);
            // fall through
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "create failed:", ex);
           // fall through
        } catch (SecurityException ex) {
            Log.d(TAG, "create failed:", ex);
            // fall through
        }
        return null;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static final void native_init() {
    }
    
    public static int native_pullBatteryData(Parcel reply) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814873156 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814873156;
    }

    /**
     * Called from native code when an interesting event happens.  This method
     * just uses the EventHandler system to post the event back to the main app thread.
     * We use a weak reference to the original MediaPlayer object so that the native
     * code is safe from the object disappearing from underneath it.  (This is
     * the cookie passed to native_setup().)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.880 -0500", hash_original_method = "A7F65D4E00F48E2B72FBD6803EA17170", hash_generated_method = "B03C9160831FCD35FC247A8908F2BA13")
    
private static void postEventFromNative(Object mediaplayer_ref,
                                            int what, int arg1, int arg2, Object obj)
    {
        MediaPlayer mp = (MediaPlayer)((WeakReference)mediaplayer_ref).get();
        if (mp == null) {
            return;
        }

        if (mp.mEventHandler != null) {
            Message m = mp.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            mp.mEventHandler.sendMessage(m);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.586 -0500", hash_original_field = "F8D759D5C1DB6CDC8EF8598DF87B9438", hash_generated_field = "E5A643B1D418726D99E5A8F3970E5556")

    public static final boolean METADATA_UPDATE_ONLY = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.589 -0500", hash_original_field = "44EB053EF5DAC9D8BFEF39AD45069AB4", hash_generated_field = "C4299F59C35DA7B075841FA52A06DF72")

    public static final boolean METADATA_ALL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.591 -0500", hash_original_field = "79480FE673F06D109380A57C843B39BC", hash_generated_field = "0F0666F4EEF61F70AF44DC91825D4969")

    public static final boolean APPLY_METADATA_FILTER = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.593 -0500", hash_original_field = "4B1E92003651561489E644B10CB1BF9F", hash_generated_field = "1049A3BBD43F92B7A4632827C73A789E")

    public static final boolean BYPASS_METADATA_FILTER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.597 -0500", hash_original_field = "739379B9AAF735D2681CAD67704A9686", hash_generated_field = "8BF0B63CF7DC67F5CB722C0B4A64DFA2")

    private final static String TAG = "MediaPlayer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.599 -0500", hash_original_field = "20E745C649C92FB4F897B08A70A91034", hash_generated_field = "19F3745DB30ADAF56D8234C37E7E1A86")

    // in sync with the 2nd parameter of the IMPLEMENT_META_INTERFACE
    // macro invocation in IMediaPlayer.cpp
    private final static String IMEDIA_PLAYER = "android.media.IMediaPlayer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.776 -0500", hash_original_field = "2F78BDF5E0AE11FC22FEA04CC992DA86", hash_generated_field = "D4D8022A6EA73EAAAB61C91C462CC810")

    /*
     * Key used in setParameter method.
     * Indicates the index of the timed text track to be enabled/disabled.
     * The index includes both the in-band and out-of-band timed text.
     * The index should start from in-band text if any. Application can retrieve the number
     * of in-band text tracks by using MediaMetadataRetriever::extractMetadata().
     * Note it might take a few hundred ms to scan an out-of-band text file
     * before displaying it.
     */
    private static final int KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.779 -0500", hash_original_field = "0E95B73625334C0273B5840D1AEA3F10", hash_generated_field = "978C74E4442A5A8AD4D9D557896E347A")

    private static final int KEY_PARAMETER_TIMED_TEXT_ADD_OUT_OF_BAND_SOURCE = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.843 -0500", hash_original_field = "90F7B1342CB80DABCFC829EC4A3E3EFA", hash_generated_field = "7F291BAD9387D41B6A164A1BFA75315A")

    private static final int MEDIA_NOP = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.846 -0500", hash_original_field = "523CCE9CB8CB441C194617B0AB82D4D0", hash_generated_field = "E329E69C41FA2733486EBCEC7C114412")

    private static final int MEDIA_PREPARED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.848 -0500", hash_original_field = "B350E9C55B896894DB2AC70997A167D7", hash_generated_field = "B132F9D1D22009420456C651590B4249")

    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.851 -0500", hash_original_field = "56056A3F39B9D0E67A775B13D2A4198A", hash_generated_field = "9CA74E4A66FE346F84987525C845EC7E")

    private static final int MEDIA_BUFFERING_UPDATE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.854 -0500", hash_original_field = "D061A1FD2949F8AA7586183834B3BF33", hash_generated_field = "923E906B8ACFD14F8396ED27A8F08EDD")

    private static final int MEDIA_SEEK_COMPLETE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.856 -0500", hash_original_field = "0F3CC154DA93D657093CFEF98EB4EC1F", hash_generated_field = "AB0BF930EEED5A3AD843B20DB5F3114D")

    private static final int MEDIA_SET_VIDEO_SIZE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.859 -0500", hash_original_field = "CD9A371D928D25420EBBDC7BF7DDC5A0", hash_generated_field = "0A95E910FACE7EC2BFA9D61726C0240D")

    private static final int MEDIA_TIMED_TEXT = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.861 -0500", hash_original_field = "68994A5BC0674073D81FA642C1813636", hash_generated_field = "5510672F996C033C929341BBDB0954D2")

    private static final int MEDIA_ERROR = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.864 -0500", hash_original_field = "EE022DFA22110D7E9068CDE7CAC07444", hash_generated_field = "AD695ED20EBD55D4F24DCFBB2D7498FB")

    private static final int MEDIA_INFO = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.925 -0500", hash_original_field = "D1F82C74C61809F6B7D5C603C1BCEE3A", hash_generated_field = "5146607E2259E7A1BDAEC4FA2E2BF168")

    /** Unspecified media player error.
     * @see android.media.MediaPlayer.OnErrorListener
     */
    public static final int MEDIA_ERROR_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.927 -0500", hash_original_field = "7376BF00C11AA452B95716B77D846779", hash_generated_field = "DB95F5B0F907621EE3C274E114EE5AD1")

    public static final int MEDIA_ERROR_SERVER_DIED = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.930 -0500", hash_original_field = "58DE5B22A4B5168A83A65B15909C715B", hash_generated_field = "06C2C428D805E0A67D6BAD19B365C91C")

    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.939 -0500", hash_original_field = "62FC1553652B8BEC3961D834BA035CAB", hash_generated_field = "531DDAA8347EC1CEE00EC0B9419F6F66")

    /** Unspecified media player info.
     * @see android.media.MediaPlayer.OnInfoListener
     */
    public static final int MEDIA_INFO_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.942 -0500", hash_original_field = "DD0A3214D5FCB27A224BC504BAC638EF", hash_generated_field = "C514B988C6EE0C70B1A7903973F10397")

    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.944 -0500", hash_original_field = "12B109AAE4958B5B86D9697926B4D060", hash_generated_field = "C18AAAC03D3E808C49320185870D0BAE")

    public static final int MEDIA_INFO_BUFFERING_START = 701;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.947 -0500", hash_original_field = "93A4218739A82FC26705B0747DE86397", hash_generated_field = "607F18EB2223B97FD6DA02FA3195836F")

    public static final int MEDIA_INFO_BUFFERING_END = 702;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.949 -0500", hash_original_field = "0000F701EC7BC27528A8C91DDFAFFD9E", hash_generated_field = "86017CADB92B26DE78EEC620504FE574")

    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.952 -0500", hash_original_field = "D36F5F2C5013E106D8D4B7B3CDB2EBA2", hash_generated_field = "06DD5F069EB77262680FEF74A227A7D4")

    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.955 -0500", hash_original_field = "80430CB28C0B9BAE2E4B49150E85CC22", hash_generated_field = "A307F706DBE6E89451A83E6E4C58505E")

    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.601 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.604 -0500", hash_original_field = "5DE561E5C08686952994313D287A7260", hash_generated_field = "E4C872FF50935D400555417B96D7DB8B")

    private int mNativeSurfaceTexture;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.606 -0500", hash_original_field = "FE5F6B598EF4F8714FDA4762225778F2", hash_generated_field = "A6AFD67537F59D7EDA48AC0935CEB2EB")

    private int mListenerContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.609 -0500", hash_original_field = "B9C6888DFD95D342322F39CD4B6FC01D", hash_generated_field = "89B6C7956CC59129C12F3A4CE408B773")

    private SurfaceHolder mSurfaceHolder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.611 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.613 -0500", hash_original_field = "4B362D420A3317EC0538385C6875B6B5", hash_generated_field = "2CC8C155682313371D14B1061F526A1E")

    private PowerManager.WakeLock mWakeLock = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.615 -0500", hash_original_field = "43CD53F6CB6A6CC00F41ABE8D000F54D", hash_generated_field = "B2A729676011F53A18FA54544A74160B")

    private boolean mScreenOnWhilePlaying;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.617 -0500", hash_original_field = "ECB378C521D017B01D79BF31DD4E7DA3", hash_generated_field = "21432D6ADD88A429FB2470D3D66606D0")

    private boolean mStayAwake;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.886 -0500", hash_original_field = "C7D5F5974B7D55BD6A40A9DEFCD5C541", hash_generated_field = "A2852387273CF168455EF7C99DC77C4A")

    private OnPreparedListener mOnPreparedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.893 -0500", hash_original_field = "06A6FF6127C3C38B2E227EA62CA452A2", hash_generated_field = "EC9BCCBF3C86489E298221F5D4476C58")

    private OnCompletionListener mOnCompletionListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.900 -0500", hash_original_field = "6A14E1C8B44382DB3357EF024F3AE973", hash_generated_field = "0091D0B159C1300DEBA144C3752FC48B")

    private OnBufferingUpdateListener mOnBufferingUpdateListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.907 -0500", hash_original_field = "AE19EBFFFE42A7CFBB4350CE68358C91", hash_generated_field = "2403596CEA6AA0A7A2E7B136A5284A81")

    private OnSeekCompleteListener mOnSeekCompleteListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.915 -0500", hash_original_field = "0B03AF7448EFC1D254247AF351562B3C", hash_generated_field = "8E3213E6DC01DA241A4C3F8027EB24E5")

    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.922 -0500", hash_original_field = "5C497D2165BB1CA9A5FD8691837D33C9", hash_generated_field = "CF913FD08AF8A12FA8042BA315C5F119")

    private OnTimedTextListener mOnTimedTextListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.936 -0500", hash_original_field = "C38C52334F0DC8BAE5DDF67054F8F272", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.961 -0500", hash_original_field = "31E70E6AB1204402EDA8B1303830B586", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;

    /**
     * Default constructor. Consider using one of the create() methods for
     * synchronously instantiating a MediaPlayer from a Uri or resource.
     * <p>When done with the MediaPlayer, you should call  {@link #release()},
     * to free the resources. If not released, too many MediaPlayer instances may
     * result in an exception.</p>
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.620 -0500", hash_original_method = "2C929CFD6011D1A8428ADCC5A270A92B", hash_generated_method = "16B7B2D5FA47F9A8C49D18D274F85689")
    
public MediaPlayer() {

        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            mEventHandler = null;
        }

        /* Native setup requires a weak reference to our object.
         * It's easier to create it here than in C++.
         */
        native_setup(new WeakReference<MediaPlayer>(this));
    }

    /*
     * Update the MediaPlayer SurfaceTexture.
     * Call after setting a new display surface.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.625 -0500", hash_original_method = "53B8A3255E430D9C87E415235A089C4A", hash_generated_method = "9F3C694A9F0DD605EDBC3062A06FF2D8")
    
    private void _setVideoSurface(Surface surface){
    	//Formerly a native method
    	addTaint(surface.getTaint());
    }

    /**
     * Create a request parcel which can be routed to the native media
     * player using {@link #invoke(Parcel, Parcel)}. The Parcel
     * returned has the proper InterfaceToken set. The caller should
     * not overwrite that token, i.e it can only append data to the
     * Parcel.
     *
     * @return A parcel suitable to hold a request for the native
     * player.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.628 -0500", hash_original_method = "9BA2A59C2D2CF14D2B23AE59BE37DCE6", hash_generated_method = "B49B4379F83A7521B7B9B51D8CC361F8")
    
public Parcel newRequest() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken(IMEDIA_PLAYER);
        return parcel;
    }

    /**
     * Invoke a generic method on the native player using opaque
     * parcels for the request and reply. Both payloads' format is a
     * convention between the java caller and the native player.
     * Must be called after setDataSource to make sure a native player
     * exists.
     *
     * @param request Parcel with the data for the extension. The
     * caller must use {@link #newRequest()} to get one.
     *
     * @param reply Output parcel with the data returned by the
     * native player.
     *
     * @return The status code see utils/Errors.h
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.630 -0500", hash_original_method = "F1F9A39481AD241B93A7EFA7B112C8A9", hash_generated_method = "0C82BD5451F0529DFBC2CC129F7E62AF")
    
public int invoke(Parcel request, Parcel reply) {
        int retcode = native_invoke(request, reply);
        reply.setDataPosition(0);
        return retcode;
    }

    /**
     * Sets the {@link SurfaceHolder} to use for displaying the video
     * portion of the media.
     *
     * Either a surface holder or surface must be set if a display or video sink
     * is needed.  Not calling this method or {@link #setSurface(Surface)}
     * when playing back a video will result in only the audio track being played.
     * A null surface holder or surface will result in only the audio track being
     * played.
     *
     * @param sh the SurfaceHolder to use for video display
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.632 -0500", hash_original_method = "936E4BA5EFE5EFD7E502D57ADB83F5AB", hash_generated_method = "FEB9A09EB87D773C0D41C0E53C6A34C7")
    
public void setDisplay(SurfaceHolder sh) {
        mSurfaceHolder = sh;
        Surface surface;
        if (sh != null) {
            surface = sh.getSurface();
        } else {
            surface = null;
        }
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    /**
     * Sets the {@link Surface} to be used as the sink for the video portion of
     * the media. This is similar to {@link #setDisplay(SurfaceHolder)}, but
     * does not support {@link #setScreenOnWhilePlaying(boolean)}.  Setting a
     * Surface will un-set any Surface or SurfaceHolder that was previously set.
     * A null surface will result in only the audio track being played.
     *
     * If the Surface sends frames to a {@link SurfaceTexture}, the timestamps
     * returned from {@link SurfaceTexture#getTimestamp()} will have an
     * unspecified zero point.  These timestamps cannot be directly compared
     * between different media sources, different instances of the same media
     * source, or multiple runs of the same program.  The timestamp is normally
     * monotonically increasing and is unaffected by time-of-day adjustments,
     * but it is reset when the position is set.
     *
     * @param surface The {@link Surface} to be used for the video portion of
     * the media.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.635 -0500", hash_original_method = "E1CEE3A46E058530408C5094E8A255A4", hash_generated_method = "CE38D253EE5685E066E66777FBFC0052")
    
public void setSurface(Surface surface) {
        if (mScreenOnWhilePlaying && surface != null) {
            Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    /**
     * Sets the data source as a content Uri.
     *
     * @param context the Context to use when resolving the Uri
     * @param uri the Content URI of the data you want to play
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.645 -0500", hash_original_method = "40ED5E4D3E36120D5E7C77AB85EB12F0", hash_generated_method = "49BBD7F1F5C7FC9EFF80CE77FB20CBF6")
    
public void setDataSource(Context context, Uri uri)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    /**
     * Sets the data source as a content Uri.
     *
     * @param context the Context to use when resolving the Uri
     * @param uri the Content URI of the data you want to play
     * @param headers the headers to be sent together with the request for the data
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.648 -0500", hash_original_method = "0C532A10BBEED73B371000A59C797624", hash_generated_method = "B5589E8A03EB9B6B5348414CBA69A953")
    
public void setDataSource(Context context, Uri uri, Map<String, String> headers)
        throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {

        String scheme = uri.getScheme();
        if(scheme == null || scheme.equals("file")) {
            setDataSource(uri.getPath());
            return;
        }

        AssetFileDescriptor fd = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            fd = resolver.openAssetFileDescriptor(uri, "r");
            if (fd == null) {
                return;
            }
            // Note: using getDeclaredLength so that our behavior is the same
            // as previous versions when the content provider is returning
            // a full file.
            if (fd.getDeclaredLength() < 0) {
                setDataSource(fd.getFileDescriptor());
            } else {
                setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getDeclaredLength());
            }
            return;
        } catch (SecurityException ex) {
        } catch (IOException ex) {
        } finally {
            if (fd != null) {
                fd.close();
            }
        }

        Log.d(TAG, "Couldn't open file on client side, trying server side");
        setDataSource(uri.toString(), headers);
        return;
    }

    /**
     * Sets the data source (file-path or http/rtsp URL) to use.
     *
     * @param path the path of the file, or the http/rtsp URL of the stream you want to play
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.652 -0500", hash_original_method = "70B5385C7A556D37595F97E42F2F2DFE", hash_generated_method = "6626A2BDF4397DFEA415ACCA7CB59089")
    
    public void setDataSource(String path)
                throws IOException, IllegalArgumentException, SecurityException, IllegalStateException{
    	//Formerly a native method
    	addTaint(path.getTaint());
    }

    /**
     * Sets the data source (file-path or http/rtsp URL) to use.
     *
     * @param path the path of the file, or the http/rtsp URL of the stream you want to play
     * @param headers the headers associated with the http request for the stream you want to play
     * @throws IllegalStateException if it is called in an invalid state
     * @hide pending API council
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.655 -0500", hash_original_method = "21A95B4BC3854510C509CF1B7B37D46D", hash_generated_method = "77957DCFCCF9D67F2710FFEB1E1A6307")
    
public void setDataSource(String path, Map<String, String> headers)
            throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        String[] keys = null;
        String[] values = null;

        if (headers != null) {
            keys = new String[headers.size()];
            values = new String[headers.size()];

            int i = 0;
            for (Map.Entry<String, String> entry: headers.entrySet()) {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                ++i;
            }
        }
        _setDataSource(path, keys, values);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.659 -0500", hash_original_method = "35737102382ABAAE0A83F0ED650DE965", hash_generated_method = "EB79CD88419ECB25044C93776C72D84F")
    
    private void _setDataSource(
            String path, String[] keys, String[] values)
            throws IOException, IllegalArgumentException, SecurityException, IllegalStateException{
    	//Formerly a native method
    	addTaint(path.getTaint());
    	addTaint(keys[0].getTaint());
    	addTaint(values[0].getTaint());
    }

    /**
     * Sets the data source (FileDescriptor) to use. It is the caller's responsibility
     * to close the file descriptor. It is safe to do so as soon as this call returns.
     *
     * @param fd the FileDescriptor for the file you want to play
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.662 -0500", hash_original_method = "67ED0EB071685F0AFDAFB2EFB1BC8776", hash_generated_method = "E3CC19B9EAB5FBB628ECA65729102A6F")
    
public void setDataSource(FileDescriptor fd)
            throws IOException, IllegalArgumentException, IllegalStateException {
        // intentionally less than LONG_MAX
        setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    /**
     * Sets the data source (FileDescriptor) to use.  The FileDescriptor must be
     * seekable (N.B. a LocalSocket is not seekable). It is the caller's responsibility
     * to close the file descriptor. It is safe to do so as soon as this call returns.
     *
     * @param fd the FileDescriptor for the file you want to play
     * @param offset the offset into the file where the data to be played starts, in bytes
     * @param length the length in bytes of the data to be played
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.666 -0500", hash_original_method = "CF807E4C5554BB2848F7651782391DCD", hash_generated_method = "ABE27D0C9FE0AA103EA081E4FA884B12")
    
    public void setDataSource(FileDescriptor fd, long offset, long length)
                throws IOException, IllegalArgumentException, IllegalStateException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(offset);
    	addTaint(length);
    }

    /**
     * Prepares the player for playback, synchronously.
     *
     * After setting the datasource and the display surface, you need to either
     * call prepare() or prepareAsync(). For files, it is OK to call prepare(),
     * which blocks until MediaPlayer is ready for playback.
     *
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.669 -0500", hash_original_method = "BE634EB7B5A47DD549B3D4698CE7CD0F", hash_generated_method = "972B65EE06DAE4FE0CB9C8995A2A0788")
    
    public void prepare() throws IOException, IllegalStateException{
    	//Formerly a native method
    }

    /**
     * Prepares the player for playback, asynchronously.
     *
     * After setting the datasource and the display surface, you need to either
     * call prepare() or prepareAsync(). For streams, you should call prepareAsync(),
     * which returns immediately, rather than blocking until enough data has been
     * buffered.
     *
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.673 -0500", hash_original_method = "9BEAA7388253BD2C3E319E2E43B2453F", hash_generated_method = "399F44ABCE1AAD6D227544722231E141")
    
    public void prepareAsync() throws IllegalStateException{
    	//Formerly a native method
    }

    /**
     * Starts or resumes playback. If playback had previously been paused,
     * playback will continue from where it was paused. If playback had
     * been stopped, or never started before, playback will start at the
     * beginning.
     *
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.676 -0500", hash_original_method = "40DE58868CCCFC32104AEA08DBC3B0CD", hash_generated_method = "DFF14EA76743D54BC360A3F44818B943")
    
public  void start() throws IllegalStateException {
        stayAwake(true);
        _start();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.679 -0500", hash_original_method = "6DEDFC534300C5310A66033260D8A31E", hash_generated_method = "24C32B9BB3A1A3C2499D04DC4BF3823E")
    
    private void _start() throws IllegalStateException{
    	//Formerly a native method
    }

    /**
     * Stops playback after playback has been stopped or paused.
     *
     * @throws IllegalStateException if the internal player engine has not been
     * initialized.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.681 -0500", hash_original_method = "09E3A57706D9EF8F79E07C48FA7F3A4D", hash_generated_method = "F22CE3D6933C89833361E940C5BF78A8")
    
public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.685 -0500", hash_original_method = "7A254901D3417D112F523A3CB4C0BACF", hash_generated_method = "D820D1EA49A5DE01B3DD42B2C8BD1C42")
    
    private void _stop() throws IllegalStateException{
    	//Formerly a native method
    }

    /**
     * Pauses playback. Call start() to resume.
     *
     * @throws IllegalStateException if the internal player engine has not been
     * initialized.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.688 -0500", hash_original_method = "857D1517B1757951DF038ED3088FF3B2", hash_generated_method = "03A1A3D932EC3E3AE69969FBABFA6F3C")
    
public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.691 -0500", hash_original_method = "3CFA64AA4FE31303B150AAAF6D2A439E", hash_generated_method = "D6F32858063809E7AE4EA8738C50CE77")
    
    private void _pause() throws IllegalStateException{
    	//Formerly a native method
    }

    /**
     * Set the low-level power management behavior for this MediaPlayer.  This
     * can be used when the MediaPlayer is not playing through a SurfaceHolder
     * set with {@link #setDisplay(SurfaceHolder)} and thus can use the
     * high-level {@link #setScreenOnWhilePlaying(boolean)} feature.
     *
     * <p>This function has the MediaPlayer access the low-level power manager
     * service to control the device's power usage while playing is occurring.
     * The parameter is a combination of {@link android.os.PowerManager} wake flags.
     * Use of this method requires {@link android.Manifest.permission#WAKE_LOCK}
     * permission.
     * By default, no attempt is made to keep the device awake during playback.
     *
     * @param context the Context to use
     * @param mode    the power/wake mode to set
     * @see android.os.PowerManager
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.694 -0500", hash_original_method = "2C98FD0B2087D81FFC1D38F1403791EF", hash_generated_method = "F56733D416E412CF850F20FF00920AD5")
    
public void setWakeMode(Context context, int mode) {
        boolean washeld = false;
        if (mWakeLock != null) {
            if (mWakeLock.isHeld()) {
                washeld = true;
                mWakeLock.release();
            }
            mWakeLock = null;
        }

        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(mode|PowerManager.ON_AFTER_RELEASE, MediaPlayer.class.getName());
        mWakeLock.setReferenceCounted(false);
        if (washeld) {
            mWakeLock.acquire();
        }
    }

    /**
     * Control whether we should use the attached SurfaceHolder to keep the
     * screen on while video playback is occurring.  This is the preferred
     * method over {@link #setWakeMode} where possible, since it doesn't
     * require that the application have permission for low-level wake lock
     * access.
     *
     * @param screenOn Supply true to keep the screen on, false to allow it
     * to turn off.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.697 -0500", hash_original_method = "1D2643121E0BBACA918AEEFF16FB1665", hash_generated_method = "904EC6066D11935C1F68B7236317467F")
    
public void setScreenOnWhilePlaying(boolean screenOn) {
        if (mScreenOnWhilePlaying != screenOn) {
            if (screenOn && mSurfaceHolder == null) {
                Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            mScreenOnWhilePlaying = screenOn;
            updateSurfaceScreenOn();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.699 -0500", hash_original_method = "02316AFDA0A1E822630D7CE99583BEE5", hash_generated_method = "327F83A2A4F21F5D31530C01C1219237")
    
private void stayAwake(boolean awake) {
        if (mWakeLock != null) {
            if (awake && !mWakeLock.isHeld()) {
                mWakeLock.acquire();
            } else if (!awake && mWakeLock.isHeld()) {
                mWakeLock.release();
            }
        }
        mStayAwake = awake;
        updateSurfaceScreenOn();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.702 -0500", hash_original_method = "D56BBB45DF467B2DAD5698BBF1920DD6", hash_generated_method = "E395CA529E80495E2CD879DFAF1CF06B")
    
private void updateSurfaceScreenOn() {
        if (mSurfaceHolder != null) {
            mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        }
    }

    /**
     * Returns the width of the video.
     *
     * @return the width of the video, or 0 if there is no video,
     * no display surface was set, or the width has not been determined
     * yet. The OnVideoSizeChangedListener can be registered via
     * {@link #setOnVideoSizeChangedListener(OnVideoSizeChangedListener)}
     * to provide a notification when the width is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.705 -0500", hash_original_method = "33D5C83ED46D1CA5E488AF592A477814", hash_generated_method = "21D98AB9D7986307EEDFA924C7FB2E1A")
    
    public int getVideoWidth(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Returns the height of the video.
     *
     * @return the height of the video, or 0 if there is no video,
     * no display surface was set, or the height has not been determined
     * yet. The OnVideoSizeChangedListener can be registered via
     * {@link #setOnVideoSizeChangedListener(OnVideoSizeChangedListener)}
     * to provide a notification when the height is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.709 -0500", hash_original_method = "AA8703DABD049C78A6839F5E3DDBB949", hash_generated_method = "18B731279637C0892F4FCD9577EB6123")
    
    public int getVideoHeight(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Checks whether the MediaPlayer is playing.
     *
     * @return true if currently playing, false otherwise
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.712 -0500", hash_original_method = "F383FE244E24C0C545B5D975B4462316", hash_generated_method = "AE8AFBA8F320061FEDF7FC75CB1400FF")
    
    public boolean isPlaying(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Seeks to specified time position.
     *
     * @param msec the offset in milliseconds from the start to seek to
     * @throws IllegalStateException if the internal player engine has not been
     * initialized
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.717 -0500", hash_original_method = "97A3BCAAD25A5F0CCA6DBA135F05FFD4", hash_generated_method = "619D78BA95B04D04B7764ECEACAE3BF8")
    
    public void seekTo(int msec) throws IllegalStateException{
    	//Formerly a native method
    	addTaint(msec);
    }

    /**
     * Gets the current playback position.
     *
     * @return the current position in milliseconds
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.721 -0500", hash_original_method = "540585A22AA6C1E9C18EA05D71ACEBDE", hash_generated_method = "BF21B840E4AAAC6665C172E56A7F131C")
    
    public int getCurrentPosition(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Gets the duration of the file.
     *
     * @return the duration in milliseconds
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.725 -0500", hash_original_method = "5FCC06EDC9BF2D1AEA92A44CF2A2F31E", hash_generated_method = "2FC17533677ADF0C26434C75FB5C9069")
    
    public int getDuration(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Gets the media metadata.
     *
     * @param update_only controls whether the full set of available
     * metadata is returned or just the set that changed since the
     * last call. See {@see #METADATA_UPDATE_ONLY} and {@see
     * #METADATA_ALL}.
     *
     * @param apply_filter if true only metadata that matches the
     * filter is returned. See {@see #APPLY_METADATA_FILTER} and {@see
     * #BYPASS_METADATA_FILTER}.
     *
     * @return The metadata, possibly empty. null if an error occured.
     // FIXME: unhide.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.728 -0500", hash_original_method = "62D59DE780FDA113D7200968BD4DD768", hash_generated_method = "67EA97B325E703D1534F67899C9919E5")
    
public Metadata getMetadata(final boolean update_only,
                                final boolean apply_filter) {
        Parcel reply = Parcel.obtain();
        Metadata data = new Metadata();

        if (!native_getMetadata(update_only, apply_filter, reply)) {
            reply.recycle();
            return null;
        }

        // Metadata takes over the parcel, don't recycle it unless
        // there is an error.
        if (!data.parse(reply)) {
            reply.recycle();
            return null;
        }
        return data;
    }

    /**
     * Set a filter for the metadata update notification and update
     * retrieval. The caller provides 2 set of metadata keys, allowed
     * and blocked. The blocked set always takes precedence over the
     * allowed one.
     * Metadata.MATCH_ALL and Metadata.MATCH_NONE are 2 sets available as
     * shorthands to allow/block all or no metadata.
     *
     * By default, there is no filter set.
     *
     * @param allow Is the set of metadata the client is interested
     *              in receiving new notifications for.
     * @param block Is the set of metadata the client is not interested
     *              in receiving new notifications for.
     * @return The call status code.
     *
     // FIXME: unhide.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.730 -0500", hash_original_method = "B0BBED6481EDE7F10FEA4CF182EBE3D1", hash_generated_method = "0ABA64F4512FF3ED1236F7462DCFB211")
    
public int setMetadataFilter(Set<Integer> allow, Set<Integer> block) {
        // Do our serialization manually instead of calling
        // Parcel.writeArray since the sets are made of the same type
        // we avoid paying the price of calling writeValue (used by
        // writeArray) which burns an extra int per element to encode
        // the type.
        Parcel request =  newRequest();

        // The parcel starts already with an interface token. There
        // are 2 filters. Each one starts with a 4bytes number to
        // store the len followed by a number of int (4 bytes as well)
        // representing the metadata type.
        int capacity = request.dataSize() + 4 * (1 + allow.size() + 1 + block.size());

        if (request.dataCapacity() < capacity) {
            request.setDataCapacity(capacity);
        }

        request.writeInt(allow.size());
        for(Integer t: allow) {
            request.writeInt(t);
        }
        request.writeInt(block.size());
        for(Integer t: block) {
            request.writeInt(t);
        }
        return native_setMetadataFilter(request);
    }

    /**
     * Releases resources associated with this MediaPlayer object.
     * It is considered good practice to call this method when you're
     * done using the MediaPlayer. In particular, whenever an Activity
     * of an application is paused (its onPause() method is called),
     * or stopped (its onStop() method is called), this method should be
     * invoked to release the MediaPlayer object, unless the application
     * has a special need to keep the object around. In addition to
     * unnecessary resources (such as memory and instances of codecs)
     * being held, failure to call this method immediately if a
     * MediaPlayer object is no longer needed may also lead to
     * continuous battery consumption for mobile devices, and playback
     * failure for other applications if no multiple instances of the
     * same codec are supported on a device. Even if multiple instances
     * of the same codec are supported, some performance degradation
     * may be expected when unnecessary multiple instances are used
     * at the same time.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.733 -0500", hash_original_method = "40ADFE91226CE43AA5B2CBEBA3591229", hash_generated_method = "3B1709695F4492C6A125DDC174E4F177")
    
public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        mOnPreparedListener = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnSeekCompleteListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnVideoSizeChangedListener = null;
        mOnTimedTextListener = null;
        _release();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.737 -0500", hash_original_method = "D6ED0B9EBF82A338F6093204ADC2E481", hash_generated_method = "7CD823498624B7D2D76B55292DBA6BF3")
    
    private void _release(){
    	//Formerly a native method
    }

    /**
     * Resets the MediaPlayer to its uninitialized state. After calling
     * this method, you will have to initialize it again by setting the
     * data source and calling prepare().
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.739 -0500", hash_original_method = "0163217153F6E824039D5121A760EBE0", hash_generated_method = "469D9FA20EF1D0738AB1606E178B89CF")
    
public void reset() {
        stayAwake(false);
        _reset();
        // make sure none of the listeners get called anymore
        mEventHandler.removeCallbacksAndMessages(null);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.743 -0500", hash_original_method = "3FFFF13DAAD4B409C984414CD8318D6D", hash_generated_method = "CD929057B611DBCFE32F16C5F956E9FD")
    
    private void _reset(){
    	//Formerly a native method
    }

    /**
     * Sets the audio stream type for this MediaPlayer. See {@link AudioManager}
     * for a list of stream types. Must call this method before prepare() or
     * prepareAsync() in order for the target stream type to become effective
     * thereafter.
     *
     * @param streamtype the audio stream type
     * @see android.media.AudioManager
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.747 -0500", hash_original_method = "7EA0CD9F896B971C851CD4CA96BFE5FA", hash_generated_method = "CD4A30775F2D640F0E5D728EB6B56B0A")
    
    public void setAudioStreamType(int streamtype){
    	//Formerly a native method
    	addTaint(streamtype);
    }

    /**
     * Sets the player to be looping or non-looping.
     *
     * @param looping whether to loop or not
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.750 -0500", hash_original_method = "4C3A78CA2E07F71A05B213D4CFF64128", hash_generated_method = "9A99D137708EEDC801722D00FF2A4F76")
    
    public void setLooping(boolean looping){
    	//Formerly a native method
    	addTaint(looping);
    }

    /**
     * Checks whether the MediaPlayer is looping or non-looping.
     *
     * @return true if the MediaPlayer is currently looping, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.753 -0500", hash_original_method = "0D67125EE341895F5558E4CEF076C5C6", hash_generated_method = "8FE82BFF6FEC50C3DCFC5A1B1A99C494")
    
    public boolean isLooping(){
    	//Formerly a native method
    	return getTaintBoolean();
    }

    /**
     * Sets the volume on this player.
     * This API is recommended for balancing the output of audio streams
     * within an application. Unless you are writing an application to
     * control user settings, this API should be used in preference to
     * {@link AudioManager#setStreamVolume(int, int, int)} which sets the volume of ALL streams of
     * a particular type. Note that the passed volume values are raw scalars.
     * UI controls should be scaled logarithmically.
     *
     * @param leftVolume left volume scalar
     * @param rightVolume right volume scalar
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.758 -0500", hash_original_method = "BE4EAA7A7DB479C280C8B84C90E58238", hash_generated_method = "89EBEFD4DBA8777486B4ED42D974F9F4")
    
    public void setVolume(float leftVolume, float rightVolume){
    	//Formerly a native method
    	addTaint(leftVolume);
    	addTaint(rightVolume);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.387 -0400", hash_original_method = "E7BF05B3622AAF2F5F3BF2C4557A0B3B", hash_generated_method = "BE7FFC2E098F8066660793B3DA145138")
    public Bitmap getFrameAt(int msec) throws IllegalStateException {
        Bitmap bm = new Bitmap();
        bm.addTaint(this.taint);
        return bm;
    }

    /**
     * Sets the audio session ID.
     *
     * @param sessionId the audio session ID.
     * The audio session ID is a system wide unique identifier for the audio stream played by
     * this MediaPlayer instance.
     * The primary use of the audio session ID  is to associate audio effects to a particular
     * instance of MediaPlayer: if an audio session ID is provided when creating an audio effect,
     * this effect will be applied only to the audio content of media players within the same
     * audio session and not to the output mix.
     * When created, a MediaPlayer instance automatically generates its own audio session ID.
     * However, it is possible to force this player to be part of an already existing audio session
     * by calling this method.
     * This method must be called before one of the overloaded <code> setDataSource </code> methods.
     * @throws IllegalStateException if it is called in an invalid state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.766 -0500", hash_original_method = "63928D15D2C6CC99F2E8386267D06FF3", hash_generated_method = "2D7DEDC865BD7B175764FE0992A92FD1")
    
    public void setAudioSessionId(int sessionId)  throws IllegalArgumentException, IllegalStateException{
    	//Formerly a native method
    	addTaint(sessionId);
    }
    
    private class EventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.867 -0500", hash_original_field = "65FD88AA6A32847BBC1610BA37C74F17", hash_generated_field = "8CCD253E1D8FDE10357015F7795C2D1A")

        private MediaPlayer mMediaPlayer;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.870 -0500", hash_original_method = "9E040026EAD08DF6FC1B72FC06387530", hash_generated_method = "734068849D5FC8E45C2AE41E48E4AC90")
        
public EventHandler(MediaPlayer mp, Looper looper) {
            super(looper);
            mMediaPlayer = mp;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.874 -0500", hash_original_method = "D299385F381B46BF939056A8A39EEDB2", hash_generated_method = "BFDF69607BEB414412E340768387BB1B")
        
@Override
        public void handleMessage(Message msg) {
            if (mMediaPlayer.mNativeContext == 0) {
                Log.w(TAG, "mediaplayer went away with unhandled events");
                return;
            }
            switch(msg.what) {
            case MEDIA_PREPARED:
                if (mOnPreparedListener != null)
                    mOnPreparedListener.onPrepared(mMediaPlayer);
                return;

            case MEDIA_PLAYBACK_COMPLETE:
                if (mOnCompletionListener != null)
                    mOnCompletionListener.onCompletion(mMediaPlayer);
                stayAwake(false);
                return;

            case MEDIA_BUFFERING_UPDATE:
                if (mOnBufferingUpdateListener != null)
                    mOnBufferingUpdateListener.onBufferingUpdate(mMediaPlayer, msg.arg1);
                return;

            case MEDIA_SEEK_COMPLETE:
              if (mOnSeekCompleteListener != null)
                  mOnSeekCompleteListener.onSeekComplete(mMediaPlayer);
              return;

            case MEDIA_SET_VIDEO_SIZE:
              if (mOnVideoSizeChangedListener != null)
                  mOnVideoSizeChangedListener.onVideoSizeChanged(mMediaPlayer, msg.arg1, msg.arg2);
              return;

            case MEDIA_ERROR:
                // For PV specific error values (msg.arg2) look in
                // opencore/pvmi/pvmf/include/pvmf_return_codes.h
                Log.e(TAG, "Error (" + msg.arg1 + "," + msg.arg2 + ")");
                boolean error_was_handled = false;
                if (mOnErrorListener != null) {
                    error_was_handled = mOnErrorListener.onError(mMediaPlayer, msg.arg1, msg.arg2);
                }
                if (mOnCompletionListener != null && ! error_was_handled) {
                    mOnCompletionListener.onCompletion(mMediaPlayer);
                }
                stayAwake(false);
                return;

            case MEDIA_INFO:
                if (msg.arg1 != MEDIA_INFO_VIDEO_TRACK_LAGGING) {
                    Log.i(TAG, "Info (" + msg.arg1 + "," + msg.arg2 + ")");
                }
                if (mOnInfoListener != null) {
                    mOnInfoListener.onInfo(mMediaPlayer, msg.arg1, msg.arg2);
                }
                // No real default action so far.
                return;
            case MEDIA_TIMED_TEXT:
                if (mOnTimedTextListener != null) {
                    if (msg.obj == null) {
                        mOnTimedTextListener.onTimedText(mMediaPlayer, null);
                    } else {
                        if (msg.obj instanceof byte[]) {
                            TimedText text = new TimedText((byte[])(msg.obj));
                            mOnTimedTextListener.onTimedText(mMediaPlayer, text);
                        }
                    }
                }
                return;

            case MEDIA_NOP: // interface test message - ignore
                break;

            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
        }
        
    }
    
    public interface OnPreparedListener
    {
        
        void onPrepared(MediaPlayer mp);
    }
    
    public interface OnCompletionListener
    {
        
        void onCompletion(MediaPlayer mp);
    }
    
    public interface OnBufferingUpdateListener
    {
        
        void onBufferingUpdate(MediaPlayer mp, int percent);
    }
    
    public interface OnSeekCompleteListener
    {
        
        public void onSeekComplete(MediaPlayer mp);
    }
    
    public interface OnVideoSizeChangedListener
    {
        
        public void onVideoSizeChanged(MediaPlayer mp, int width, int height);
    }
    
    public interface OnTimedTextListener
    {
        
        public void onTimedText(MediaPlayer mp, TimedText text);
    }
    
    public interface OnErrorListener
    {
        
        boolean onError(MediaPlayer mp, int what, int extra);
    }
    
    public interface OnInfoListener
    {
        
        boolean onInfo(MediaPlayer mp, int what, int extra);
    }

    /**
     * Returns the audio session ID.
     *
     * @return the audio session ID. {@see #setAudioSessionId(int)}
     * Note that the audio session ID is 0 only if a problem occured when the MediaPlayer was contructed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.770 -0500", hash_original_method = "A9F7BB2486256FFAA61FE97D99C9B85E", hash_generated_method = "E4B2BAF3BBC9E31AA7A25D394FB14B41")
    
    public int getAudioSessionId(){
    	//Formerly a native method
    	return getTaintInt();
    }

    /**
     * Attaches an auxiliary effect to the player. A typical auxiliary effect is a reverberation
     * effect which can be applied on any sound source that directs a certain amount of its
     * energy to this effect. This amount is defined by setAuxEffectSendLevel().
     * {@see #setAuxEffectSendLevel(float)}.
     * <p>After creating an auxiliary effect (e.g.
     * {@link android.media.audiofx.EnvironmentalReverb}), retrieve its ID with
     * {@link android.media.audiofx.AudioEffect#getId()} and use it when calling this method
     * to attach the player to the effect.
     * <p>To detach the effect from the player, call this method with a null effect id.
     * <p>This method must be called after one of the overloaded <code> setDataSource </code>
     * methods.
     * @param effectId system wide unique id of the effect to attach
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.774 -0500", hash_original_method = "267B75456E03BDFBAB6FC1F227BFBD27", hash_generated_method = "3117BB4CBF64E520A85A6645830D75E5")
    
    public void attachAuxEffect(int effectId){
    	//Formerly a native method
    	addTaint(effectId);
    }

    // There are currently no defined keys usable from Java with get*Parameter.
    // But if any keys are defined, the order must be kept in sync with include/media/mediaplayer.h.
    // private static final int KEY_PARAMETER_... = ...;

    /**
     * Sets the parameter indicated by key.
     * @param key key indicates the parameter to be set.
     * @param value value of the parameter to be set.
     * @return true if the parameter is set successfully, false otherwise
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.783 -0500", hash_original_method = "4D1DAD410063C63E8C280A1116B73E03", hash_generated_method = "6952C0082C79CDB24DB685E87077D724")
    
    public boolean setParameter(int key, Parcel value){
    	//Formerly a native method
    	addTaint(key);
    	addTaint(value.getTaint());
    	return getTaintBoolean();
    }

    /**
     * Sets the parameter indicated by key.
     * @param key key indicates the parameter to be set.
     * @param value value of the parameter to be set.
     * @return true if the parameter is set successfully, false otherwise
     * {@hide}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.785 -0500", hash_original_method = "007895DA6F9E8604D81FFE810C3D87FB", hash_generated_method = "1E40FE01B4028E74216A34A4D71B06A4")
    
public boolean setParameter(int key, String value) {
        Parcel p = Parcel.obtain();
        p.writeString(value);
        boolean ret = setParameter(key, p);
        p.recycle();
        return ret;
    }
    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    /**
     * Sets the parameter indicated by key.
     * @param key key indicates the parameter to be set.
     * @param value value of the parameter to be set.
     * @return true if the parameter is set successfully, false otherwise
     * {@hide}
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.788 -0500", hash_original_method = "42E72BE22D4EC0A8F92EA2FFF9A1B8CD", hash_generated_method = "53FA53BACD5928D4D57808F15F48B7F4")
    
public boolean setParameter(int key, int value) {
        Parcel p = Parcel.obtain();
        p.writeInt(value);
        boolean ret = setParameter(key, p);
        p.recycle();
        return ret;
    }

    /**
     * Gets the value of the parameter indicated by key.
     * @param key key indicates the parameter to get.
     * @param reply value of the parameter to get.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.792 -0500", hash_original_method = "331C8FC44967717E7E0670FCEDE9BFD0", hash_generated_method = "BBCB7B4CBCCCCE85FC2478DB8823195A")
    
    private void getParameter(int key, Parcel reply){
    	//Formerly a native method
    	addTaint(key);
    	addTaint(reply.getTaint());
    }

    /**
     * Gets the value of the parameter indicated by key.
     * The caller is responsible for recycling the returned parcel.
     * @param key key indicates the parameter to get.
     * @return value of the parameter.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.794 -0500", hash_original_method = "5EBE9A62BAE86EE2E5C065958EFCD9CF", hash_generated_method = "A628E7F322598BE5B924C7FD36DB3FD5")
    
public Parcel getParcelParameter(int key) {
        Parcel p = Parcel.obtain();
        getParameter(key, p);
        return p;
    }

    /**
     * Gets the value of the parameter indicated by key.
     * @param key key indicates the parameter to get.
     * @return value of the parameter.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.796 -0500", hash_original_method = "E362F946FCE7F90CCCD629666B73E43A", hash_generated_method = "CDC35BE7FB4BB10283A6011E5EE96090")
    
public String getStringParameter(int key) {
        Parcel p = Parcel.obtain();
        getParameter(key, p);
        String ret = p.readString();
        p.recycle();
        return ret;
    }

    /**
     * Gets the value of the parameter indicated by key.
     * @param key key indicates the parameter to get.
     * @return value of the parameter.
     * {@hide}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.798 -0500", hash_original_method = "6CEECAB43DB86BAC5EC65D39A3A924D5", hash_generated_method = "FE648F3532CBCB21B22D30390105E7D4")
    
public int getIntParameter(int key) {
        Parcel p = Parcel.obtain();
        getParameter(key, p);
        int ret = p.readInt();
        p.recycle();
        return ret;
    }

    /**
     * Sets the send level of the player to the attached auxiliary effect
     * {@see #attachAuxEffect(int)}. The level value range is 0 to 1.0.
     * <p>By default the send level is 0, so even if an effect is attached to the player
     * this method must be called for the effect to be applied.
     * <p>Note that the passed level value is a raw scalar. UI controls should be scaled
     * logarithmically: the gain applied by audio framework ranges from -72dB to 0dB,
     * so an appropriate conversion from linear UI input x to level is:
     * x == 0 -> level = 0
     * 0 < x <= R -> level = 10^(72*(x-R)/20/R)
     * @param level send level scalar
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.802 -0500", hash_original_method = "D28173AB681B94731B1FF3947E2DFEF3", hash_generated_method = "E437BE622BEF0EDD019B9AE6AE23B32F")
    
    public void setAuxEffectSendLevel(float level){
    	//Formerly a native method
    	addTaint(level);
    }

    /**
     * @param request Parcel destinated to the media player. The
     *                Interface token must be set to the IMediaPlayer
     *                one to be routed correctly through the system.
     * @param reply[out] Parcel that will contain the reply.
     * @return The status code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.807 -0500", hash_original_method = "4B4989130AC0D9F13A471859CBC524C2", hash_generated_method = "31EBB0F410464AAE78D72042AF5C171E")
    
    private final int native_invoke(Parcel request, Parcel reply){
    	//Formerly a native method
    	addTaint(request.getTaint());
    	addTaint(reply.getTaint());
    	return getTaintInt();
    }

    /**
     * @param update_only If true fetch only the set of metadata that have
     *                    changed since the last invocation of getMetadata.
     *                    The set is built using the unfiltered
     *                    notifications the native player sent to the
     *                    MediaPlayerService during that period of
     *                    time. If false, all the metadatas are considered.
     * @param apply_filter  If true, once the metadata set has been built based on
     *                     the value update_only, the current filter is applied.
     * @param reply[out] On return contains the serialized
     *                   metadata. Valid only if the call was successful.
     * @return The status code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.811 -0500", hash_original_method = "226F7D6B434A382FD3304895D8BD3523", hash_generated_method = "EA199453DE9DD7B28E6149DC3B5BD206")
    
    private final boolean native_getMetadata(boolean update_only,
                                                        boolean apply_filter,
                                                        Parcel reply){
    	//Formerly a native method
    	addTaint(update_only);
    	addTaint(apply_filter);
    	addTaint(reply.getTaint());
    	return getTaintBoolean();
    }

    /**
     * @param request Parcel with the 2 serialized lists of allowed
     *                metadata types followed by the one to be
     *                dropped. Each list starts with an integer
     *                indicating the number of metadata type elements.
     * @return The status code.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.815 -0500", hash_original_method = "DFB5479CBB8EF2503AE55C0DE7F21BA6", hash_generated_method = "F03A1BC7D6797F20FF196E14E3E519F7")
    
    private final int native_setMetadataFilter(Parcel request){
    	//Formerly a native method
    	addTaint(request.getTaint());
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.823 -0500", hash_original_method = "B3ECC5C677CF7E418546A8C45CAC4774", hash_generated_method = "DE2C6D1A3E77E5AAAF04163578D75741")
    
    private final void native_setup(Object mediaplayer_this){
    	//Formerly a native method
    	addTaint(mediaplayer_this.getTaint());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.827 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    /**
     * @param index The index of the text track to be turned on.
     * @return true if the text track is enabled successfully.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.830 -0500", hash_original_method = "BB295A571473D1F777DD0CCBCDDABC95", hash_generated_method = "F44172BC4783993262F0BADFB657BF96")
    
public boolean enableTimedTextTrackIndex(int index) {
        if (index < 0) {
            return false;
        }
        return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index);
    }

    /**
     * Enables the first timed text track if any.
     * @return true if the text track is enabled successfully
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.832 -0500", hash_original_method = "74C1C7D2920140BDBE1C5FB72709063E", hash_generated_method = "A7324CF385A95BB11E648F5C9A3211EB")
    
public boolean enableTimedText() {
        return enableTimedTextTrackIndex(0);
    }

    /**
     * Disables timed text display.
     * @return true if the text track is disabled successfully.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.834 -0500", hash_original_method = "D4D5A570D263843DA145431C05408526", hash_generated_method = "58B8DA57D468999899FE4676D2AFAE77")
    
public boolean disableTimedText() {
        return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.841 -0500", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() { native_finalize(); }

    /**
     * Register a callback to be invoked when the media source is ready
     * for playback.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.884 -0500", hash_original_method = "652A10B898FA76BB677D4E34679A7B5D", hash_generated_method = "121E0B182C491C4B2C85FD6119D834A3")
    
public void setOnPreparedListener(OnPreparedListener listener)
    {
        mOnPreparedListener = listener;
    }

    /**
     * Register a callback to be invoked when the end of a media source
     * has been reached during playback.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.891 -0500", hash_original_method = "6CC4251EDF834484FDBD6F0A122C65D9", hash_generated_method = "E954F08D090C618317924314D4864513")
    
public void setOnCompletionListener(OnCompletionListener listener)
    {
        mOnCompletionListener = listener;
    }

    /**
     * Register a callback to be invoked when the status of a network
     * stream's buffer has changed.
     *
     * @param listener the callback that will be run.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.898 -0500", hash_original_method = "DDA62D9965B414E96A3CCD5D800217D1", hash_generated_method = "2B4819AD18CCC7D63B86E05B68963846")
    
public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener)
    {
        mOnBufferingUpdateListener = listener;
    }

    /**
     * Register a callback to be invoked when a seek operation has been
     * completed.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.905 -0500", hash_original_method = "E6C283B9723E51C1AAC734ADC41F741F", hash_generated_method = "4262AB45F75AAFC3EC462BDF90628F01")
    
public void setOnSeekCompleteListener(OnSeekCompleteListener listener)
    {
        mOnSeekCompleteListener = listener;
    }

    /**
     * Register a callback to be invoked when the video size is
     * known or updated.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.913 -0500", hash_original_method = "8379FC1073131EA9347F12938BFC14C4", hash_generated_method = "585B5722D9D3FAEBE0BE1317C7E26203")
    
public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener)
    {
        mOnVideoSizeChangedListener = listener;
    }

    /**
     * Register a callback to be invoked when a timed text is available
     * for display.
     *
     * @param listener the callback that will be run
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.920 -0500", hash_original_method = "EF2D264E164B28DBC06EEC6D3EBE8B23", hash_generated_method = "B27FFF2A432702BB6491BF0FAFA01D32")
    
public void setOnTimedTextListener(OnTimedTextListener listener)
    {
        mOnTimedTextListener = listener;
    }

    /**
     * Register a callback to be invoked when an error has happened
     * during an asynchronous operation.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.934 -0500", hash_original_method = "606EB06B64A07407B83CA5CBEBF309C3", hash_generated_method = "3EEA30E1A38917AA79DA96D8939B5641")
    
public void setOnErrorListener(OnErrorListener listener)
    {
        mOnErrorListener = listener;
    }

    /**
     * Register a callback to be invoked when an info/warning is available.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:25.959 -0500", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "00A764E9A5F73CCD36593277E2A3C417")
    
public void setOnInfoListener(OnInfoListener listener)
    {
        mOnInfoListener = listener;
    }
}

