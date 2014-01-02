package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;





public class MediaRecorder {

    /**
     * Gets the maximum value for audio sources.
     * @see android.media.MediaRecorder.AudioSource
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.695 -0500", hash_original_method = "AE8B9D0BAF1949AC0D1E2F329A15E5A4", hash_generated_method = "7423A75675172FE805FDDCBC7C47DDDA")
    
public static final int getAudioSourceMax() { return AudioSource.VOICE_COMMUNICATION; }

    /**
     * Called from native code when an interesting event happens.  This method
     * just uses the EventHandler system to post the event back to the main app thread.
     * We use a weak reference to the original MediaRecorder object so that the native
     * code is safe from the object disappearing from underneath it.  (This is
     * the cookie passed to native_setup().)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.871 -0500", hash_original_method = "97DCA2C2A68FF577895DB2733D579418", hash_generated_method = "C1194E01FF583CCEF73CC624991E8EF7")
    
private static void postEventFromNative(Object mediarecorder_ref,
                                            int what, int arg1, int arg2, Object obj)
    {
        MediaRecorder mr = (MediaRecorder)((WeakReference)mediarecorder_ref).get();
        if (mr == null) {
            return;
        }

        if (mr.mEventHandler != null) {
            Message m = mr.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            mr.mEventHandler.sendMessage(m);
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static final void native_init() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.549 -0500", hash_original_field = "53D9A4726774219B19D0F6C3285BC5F8", hash_generated_field = "9E43FF77760065A7AB714E624C6D69AB")

    private final static String TAG = "MediaRecorder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.786 -0500", hash_original_field = "8AD29CD0407FD200FFC3CBF627E2DD07", hash_generated_field = "0522FEE035420728D0E81B047AC21651")

    /** Unspecified media recorder error.
     * @see android.media.MediaRecorder.OnErrorListener
     */
    public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.794 -0500", hash_original_field = "C54578A2BF556EBBA3D56F0CDF329476", hash_generated_field = "C0CB74366937E0F0F1A424569F1A859D")

    /** Unspecified media recorder error.
     * @see android.media.MediaRecorder.OnInfoListener
     */
    public static final int MEDIA_RECORDER_INFO_UNKNOWN              = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.796 -0500", hash_original_field = "9BCA1CB522DEAAC0330F48E2BD55701F", hash_generated_field = "04EAFD1B3BFD1A45EAE65B296BD6769C")

    public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.799 -0500", hash_original_field = "CB7BE3AEFD2D17D55ABC144172F26036", hash_generated_field = "CAA6A66648565C81318827AC26143889")

    public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.801 -0500", hash_original_field = "4B48A566B0782913D3A298894988DB09", hash_generated_field = "1AA2399DCC90B28574227B0FE4AF7F61")

    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_START        = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.805 -0500", hash_original_field = "F7AECFC1E1D16145C8A15AB13393E713", hash_generated_field = "66A653CE8B76D184FB603AFBB295456A")

    public static final int MEDIA_RECORDER_TRACK_INFO_COMPLETION_STATUS = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.807 -0500", hash_original_field = "6D8FE3E42A8953B7687255EA57D5C299", hash_generated_field = "86E5ECC98E07406B87D502E73DF7799B")

    public static final int MEDIA_RECORDER_TRACK_INFO_PROGRESS_IN_TIME  = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.810 -0500", hash_original_field = "636BA12A7021689D057179F20C6562D7", hash_generated_field = "FD2EC5286FF04A861353CCB083E74A8D")

    public static final int MEDIA_RECORDER_TRACK_INFO_TYPE              = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.812 -0500", hash_original_field = "C2136589894CC53D8DE8699FE7907E55", hash_generated_field = "6B9258FC4BFFC05F7B0C562674BF9762")

    public static final int MEDIA_RECORDER_TRACK_INFO_DURATION_MS       = 1003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.815 -0500", hash_original_field = "C3B19DF50FB9AAD60FA01069ACFF514F", hash_generated_field = "6DE76F50962E226685A8D7A25FF0114D")

    public static final int MEDIA_RECORDER_TRACK_INFO_MAX_CHUNK_DUR_MS  = 1004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.817 -0500", hash_original_field = "8065A52A123E862DCF4CA99F8BF64134", hash_generated_field = "F6496C2AEAE4201C20530F93BDF9ACA5")

    public static final int MEDIA_RECORDER_TRACK_INFO_ENCODED_FRAMES    = 1005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.820 -0500", hash_original_field = "D9FA3E9756A8972D850ECD3ABFBE5BAB", hash_generated_field = "8DD93EADADBCCBE26625A903591CE508")

    public static final int MEDIA_RECORDER_TRACK_INTER_CHUNK_TIME_MS    = 1006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.823 -0500", hash_original_field = "39915C10DF312121C8F9E869EBCBCFC9", hash_generated_field = "D5496C27C5DE15FBD32DE93EEB4CE21B")

    public static final int MEDIA_RECORDER_TRACK_INFO_INITIAL_DELAY_MS  = 1007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.825 -0500", hash_original_field = "207561C993D6EE537821EDDA70AA847E", hash_generated_field = "C85D8AED28AD002D83E2D1124AA8BA79")

    public static final int MEDIA_RECORDER_TRACK_INFO_START_OFFSET_MS   = 1008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.827 -0500", hash_original_field = "93A575F06DAE79FCB2ADC9B6C44AD511", hash_generated_field = "F7AB76A0D807EEF4276DAF5A09D4850B")

    public static final int MEDIA_RECORDER_TRACK_INFO_DATA_KBYTES       = 1009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.830 -0500", hash_original_field = "3313B2E0EFFAA81E9410D17D2557AF79", hash_generated_field = "DB7CDEC5A013B6508139A4976174D84E")

    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_END          = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.552 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "4FF8A42CAE4591AC91206314B4192EA4")

    @SuppressWarnings("unused")
    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.554 -0500", hash_original_field = "718CD3BE0BDD64302FC8F6AC61AA9980", hash_generated_field = "CF56B07A79F79E335B5E31194908A4ED")


    @SuppressWarnings("unused")
    private Surface mSurface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.556 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")


    private String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.558 -0500", hash_original_field = "527F974C28D82C3D0AB3A51D40023765", hash_generated_field = "D884398030F13C93CE57AAFBDAC2F9A3")

    private FileDescriptor mFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.560 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.563 -0500", hash_original_field = "C38C52334F0DC8BAE5DDF67054F8F272", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.566 -0500", hash_original_field = "31E70E6AB1204402EDA8B1303830B586", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.569 -0500", hash_original_method = "506D5AE1E4700103A96E723E2F623CDF", hash_generated_method = "13BF1EBB65DB4371328F028432A43C99")
    
public MediaRecorder() {

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
        native_setup(new WeakReference<MediaRecorder>(this));
    }

    /**
     * Sets a Camera to use for recording. Use this function to switch
     * quickly between preview and capture mode without a teardown of
     * the camera object. {@link android.hardware.Camera#unlock()} should be
     * called before this. Must call before prepare().
     *
     * @param c the Camera to use for recording
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.572 -0500", hash_original_method = "ABDAB49B7FE2D6558157D548CA69CDD8", hash_generated_method = "E9418463AED0C2A483AB8E4400CE5C82")
    
    public void setCamera(Camera c){
    	//Formerly a native method
    	addTaint(c.getTaint());
    }


    /**
     * Sets a Surface to show a preview of recorded media (video). Calls this
     * before prepare() to make sure that the desirable preview display is
     * set.
     *
     * @param sv the Surface to use for the preview
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.575 -0500", hash_original_method = "9D12D44BFB2D2426E5261AD40C8A6399", hash_generated_method = "2055335BBC888EB71DF7ABAEF1C7874E")
    
public void setPreviewDisplay(Surface sv) {
        mSurface = sv;
    }

    /**
     * Sets the audio source to be used for recording. If this method is not
     * called, the output file will not contain an audio track. The source needs
     * to be specified before setting recording-parameters or encoders. Call
     * this only before setOutputFormat().
     *
     * @param audio_source the audio source to use
     * @throws IllegalStateException if it is called after setOutputFormat()
     * @see android.media.MediaRecorder.AudioSource
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.692 -0500", hash_original_method = "A371021B9F589CE697BF3A2D834DE3D5", hash_generated_method = "8D6A5BBBF1E8F6463F169491C01E9C02")
    
    public void setAudioSource(int audio_source)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(audio_source);
    }


    /**
     * Sets the video source to be used for recording. If this method is not
     * called, the output file will not contain an video track. The source needs
     * to be specified before setting recording-parameters or encoders. Call
     * this only before setOutputFormat().
     *
     * @param video_source the video source to use
     * @throws IllegalStateException if it is called after setOutputFormat()
     * @see android.media.MediaRecorder.VideoSource
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.698 -0500", hash_original_method = "95828B107E82D883B2C1CA5CFF39AF89", hash_generated_method = "E96565FB9BF347FE9A321AF4A60EE43E")
    
    public void setVideoSource(int video_source)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(video_source);
    }


    /**
     * Uses the settings from a CamcorderProfile object for recording. This method should
     * be called after the video AND audio sources are set, and before setOutputFile().
     *
     * @param profile the CamcorderProfile to use
     * @see android.media.CamcorderProfile
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.701 -0500", hash_original_method = "C41941EDDC1BA172E48D383432866025", hash_generated_method = "DBA2E76270F6FBE67F68B62F5122F887")
    
public void setProfile(CamcorderProfile profile) {
        setOutputFormat(profile.fileFormat);
        setVideoFrameRate(profile.videoFrameRate);
        setVideoSize(profile.videoFrameWidth, profile.videoFrameHeight);
        setVideoEncodingBitRate(profile.videoBitRate);
        setVideoEncoder(profile.videoCodec);
        if (profile.quality >= CamcorderProfile.QUALITY_TIME_LAPSE_LOW &&
             profile.quality <= CamcorderProfile.QUALITY_TIME_LAPSE_QVGA) {
            // Enable time lapse. Also don't set audio for time lapse.
            setParameter(String.format("time-lapse-enable=1"));
        } else {
            setAudioEncodingBitRate(profile.audioBitRate);
            setAudioChannels(profile.audioChannels);
            setAudioSamplingRate(profile.audioSampleRate);
            setAudioEncoder(profile.audioCodec);
        }
    }

    /**
     * Set video frame capture rate. This can be used to set a different video frame capture
     * rate than the recorded video's playback rate. Currently this works only for time lapse mode.
     *
     * @param fps Rate at which frames should be captured in frames per second.
     * The fps can go as low as desired. However the fastest fps will be limited by the hardware.
     * For resolutions that can be captured by the video camera, the fastest fps can be computed using
     * {@link android.hardware.Camera.Parameters#getPreviewFpsRange(int[])}. For higher
     * resolutions the fastest fps may be more restrictive.
     * Note that the recorder cannot guarantee that frames will be captured at the
     * given rate due to camera/encoder limitations. However it tries to be as close as
     * possible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.704 -0500", hash_original_method = "01590CA235372AAAE94DCADBCD3DAA8F", hash_generated_method = "E2053F72246244DC29705FCAA9160588")
    
public void setCaptureRate(double fps) {
        double timeBetweenFrameCapture = 1 / fps;
        int timeBetweenFrameCaptureMs = (int) (1000 * timeBetweenFrameCapture);
        setParameter(String.format("time-between-time-lapse-frame-capture=%d",
                    timeBetweenFrameCaptureMs));
    }

    /**
     * Sets the orientation hint for output video playback.
     * This method should be called before prepare(). This method will not
     * trigger the source video frame to rotate during video recording, but to
     * add a composition matrix containing the rotation angle in the output
     * video if the output format is OutputFormat.THREE_GPP or
     * OutputFormat.MPEG_4 so that a video player can choose the proper
     * orientation for playback. Note that some video players may choose
     * to ignore the compostion matrix in a video during playback.
     *
     * @param degrees the angle to be rotated clockwise in degrees.
     * The supported angles are 0, 90, 180, and 270 degrees.
     * @throws IllegalArgumentException if the angle is not supported.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.706 -0500", hash_original_method = "FFEAE3173573A6FB2AF430882DE311CC", hash_generated_method = "40D2B9D8F8DB8B88EF43ADA706ED8C3F")
    
public void setOrientationHint(int degrees) {
        if (degrees != 0   &&
            degrees != 90  &&
            degrees != 180 &&
            degrees != 270) {
            throw new IllegalArgumentException("Unsupported angle: " + degrees);
        }
        setParameter("video-param-rotation-angle-degrees=" + degrees);
    }

    /**
     * Set and store the geodata (latitude and longitude) in the output file.
     * This method should be called before prepare(). The geodata is
     * stored in udta box if the output format is OutputFormat.THREE_GPP
     * or OutputFormat.MPEG_4, and is ignored for other output formats.
     * The geodata is stored according to ISO-6709 standard.
     *
     * @param latitude latitude in degrees. Its value must be in the
     * range [-90, 90].
     * @param longitude longitude in degrees. Its value must be in the
     * range [-180, 180].
     *
     * @throws IllegalArgumentException if the given latitude or
     * longitude is out of range.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.709 -0500", hash_original_method = "95876148111FCD378C0A7171639D46C7", hash_generated_method = "1B9BB420437BA066111BA9FE9F4C456D")
    
public void setLocation(float latitude, float longitude) {
        int latitudex10000  = (int) (latitude * 10000 + 0.5);
        int longitudex10000 = (int) (longitude * 10000 + 0.5);

        if (latitudex10000 > 900000 || latitudex10000 < -900000) {
            String msg = "Latitude: " + latitude + " out of range.";
            throw new IllegalArgumentException(msg);
        }
        if (longitudex10000 > 1800000 || longitudex10000 < -1800000) {
            String msg = "Longitude: " + longitude + " out of range";
            throw new IllegalArgumentException(msg);
        }

        setParameter("param-geotag-latitude=" + latitudex10000);
        setParameter("param-geotag-longitude=" + longitudex10000);
    }

    /**
     * Sets the format of the output file produced during recording. Call this
     * after setAudioSource()/setVideoSource() but before prepare().
     *
     * <p>It is recommended to always use 3GP format when using the H.263
     * video encoder and AMR audio encoder. Using an MPEG-4 container format
     * may confuse some desktop players.</p>
     *
     * @param output_format the output format to use. The output format
     * needs to be specified before setting recording-parameters or encoders.
     * @throws IllegalStateException if it is called after prepare() or before
     * setAudioSource()/setVideoSource().
     * @see android.media.MediaRecorder.OutputFormat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.713 -0500", hash_original_method = "16B1291E62A33A134EF60F37C7D2CCB8", hash_generated_method = "D980BF01D82197C5CCD2F6C89D0437DA")
    
    public void setOutputFormat(int output_format)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(output_format);
    }


    /**
     * Sets the width and height of the video to be captured.  Must be called
     * after setVideoSource(). Call this after setOutFormat() but before
     * prepare().
     *
     * @param width the width of the video to be captured
     * @param height the height of the video to be captured
     * @throws IllegalStateException if it is called after
     * prepare() or before setOutputFormat()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.717 -0500", hash_original_method = "71A5DAEC76B8523A4C4E858FBAE085E2", hash_generated_method = "4A579644DC68C338D756D7DBEDBE8DF0")
    
    public void setVideoSize(int width, int height)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(width);
    	addTaint(height);
    }


    /**
     * Sets the frame rate of the video to be captured.  Must be called
     * after setVideoSource(). Call this after setOutFormat() but before
     * prepare().
     *
     * @param rate the number of frames per second of video to capture
     * @throws IllegalStateException if it is called after
     * prepare() or before setOutputFormat().
     *
     * NOTE: On some devices that have auto-frame rate, this sets the
     * maximum frame rate, not a constant frame rate. Actual frame rate
     * will vary according to lighting conditions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.721 -0500", hash_original_method = "4711F19464352F93232DA12822C7FDFE", hash_generated_method = "250F4128ED436843B6BBA166E857F8DA")
    
    public void setVideoFrameRate(int rate) throws IllegalStateException{
    	//Formerly a native method
    	addTaint(rate);
    }


    /**
     * Sets the maximum duration (in ms) of the recording session.
     * Call this after setOutFormat() but before prepare().
     * After recording reaches the specified duration, a notification
     * will be sent to the {@link android.media.MediaRecorder.OnInfoListener}
     * with a "what" code of {@link #MEDIA_RECORDER_INFO_MAX_DURATION_REACHED}
     * and recording will be stopped. Stopping happens asynchronously, there
     * is no guarantee that the recorder will have stopped by the time the
     * listener is notified.
     *
     * @param max_duration_ms the maximum duration in ms (if zero or negative, disables the duration limit)
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.725 -0500", hash_original_method = "B668CBA366084C55F47F6ED4964FF898", hash_generated_method = "9CBBA649156D4F578728A55D210BCDD3")
    
    public void setMaxDuration(int max_duration_ms) throws IllegalArgumentException{
    	//Formerly a native method
    	addTaint(max_duration_ms);
    }


    /**
     * Sets the maximum filesize (in bytes) of the recording session.
     * Call this after setOutFormat() but before prepare().
     * After recording reaches the specified filesize, a notification
     * will be sent to the {@link android.media.MediaRecorder.OnInfoListener}
     * with a "what" code of {@link #MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED}
     * and recording will be stopped. Stopping happens asynchronously, there
     * is no guarantee that the recorder will have stopped by the time the
     * listener is notified.
     *
     * @param max_filesize_bytes the maximum filesize in bytes (if zero or negative, disables the limit)
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.728 -0500", hash_original_method = "A50E13690D0D35FC40A0268A3FC87BD5", hash_generated_method = "EF7122C444F75B3DBAEA5562F3B0D319")
    
    public void setMaxFileSize(long max_filesize_bytes) throws IllegalArgumentException{
    	//Formerly a native method
    	addTaint(max_filesize_bytes);
    }


    /**
     * Sets the audio encoder to be used for recording. If this method is not
     * called, the output file will not contain an audio track. Call this after
     * setOutputFormat() but before prepare().
     *
     * @param audio_encoder the audio encoder to use.
     * @throws IllegalStateException if it is called before
     * setOutputFormat() or after prepare().
     * @see android.media.MediaRecorder.AudioEncoder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.733 -0500", hash_original_method = "1CF1181ABC96941035EF958A99727050", hash_generated_method = "6438AF6C2C7E41BBA63EFDD117B77299")
    
    public void setAudioEncoder(int audio_encoder)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(audio_encoder);
    }


    /**
     * Sets the video encoder to be used for recording. If this method is not
     * called, the output file will not contain an video track. Call this after
     * setOutputFormat() and before prepare().
     *
     * @param video_encoder the video encoder to use.
     * @throws IllegalStateException if it is called before
     * setOutputFormat() or after prepare()
     * @see android.media.MediaRecorder.VideoEncoder
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.737 -0500", hash_original_method = "ABD82A110412540080E22D800F212AD9", hash_generated_method = "EFB205858D726411929D01957784679E")
    
    public void setVideoEncoder(int video_encoder)
                throws IllegalStateException{
    	//Formerly a native method
    	addTaint(video_encoder);
    }


    /**
     * Sets the audio sampling rate for recording. Call this method before prepare().
     * Prepare() may perform additional checks on the parameter to make sure whether
     * the specified audio sampling rate is applicable. The sampling rate really depends
     * on the format for the audio recording, as well as the capabilities of the platform.
     * For instance, the sampling rate supported by AAC audio coding standard ranges
     * from 8 to 96 kHz, the sampling rate supported by AMRNB is 8kHz, and the sampling
     * rate supported by AMRWB is 16kHz. Please consult with the related audio coding
     * standard for the supported audio sampling rate.
     *
     * @param samplingRate the sampling rate for audio in samples per second.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.739 -0500", hash_original_method = "A30D5A78BCFDD0EC33430FA69AAB0135", hash_generated_method = "F195D5B399071C2C18E786C6B6A8F069")
    
public void setAudioSamplingRate(int samplingRate) {
        if (samplingRate <= 0) {
            throw new IllegalArgumentException("Audio sampling rate is not positive");
        }
        setParameter("audio-param-sampling-rate=" + samplingRate);
    }

    /**
     * Sets the number of audio channels for recording. Call this method before prepare().
     * Prepare() may perform additional checks on the parameter to make sure whether the
     * specified number of audio channels are applicable.
     *
     * @param numChannels the number of audio channels. Usually it is either 1 (mono) or 2
     * (stereo).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.741 -0500", hash_original_method = "6F6BACC54031B00DCF8168A950EA33D9", hash_generated_method = "FB9AD655B137DC8463C1B26B0138AEB5")
    
public void setAudioChannels(int numChannels) {
        if (numChannels <= 0) {
            throw new IllegalArgumentException("Number of channels is not positive");
        }
        setParameter("audio-param-number-of-channels=" + numChannels);
    }

    /**
     * Sets the audio encoding bit rate for recording. Call this method before prepare().
     * Prepare() may perform additional checks on the parameter to make sure whether the
     * specified bit rate is applicable, and sometimes the passed bitRate will be clipped
     * internally to ensure the audio recording can proceed smoothly based on the
     * capabilities of the platform.
     *
     * @param bitRate the audio encoding bit rate in bits per second.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.743 -0500", hash_original_method = "3786AB4A2177EE063AA4F526AF23E799", hash_generated_method = "C74D09A9246C5353CAB89C925DC2B28B")
    
public void setAudioEncodingBitRate(int bitRate) {
        if (bitRate <= 0) {
            throw new IllegalArgumentException("Audio encoding bit rate is not positive");
        }
        setParameter("audio-param-encoding-bitrate=" + bitRate);
    }

    /**
     * Sets the video encoding bit rate for recording. Call this method before prepare().
     * Prepare() may perform additional checks on the parameter to make sure whether the
     * specified bit rate is applicable, and sometimes the passed bitRate will be
     * clipped internally to ensure the video recording can proceed smoothly based on
     * the capabilities of the platform.
     *
     * @param bitRate the video encoding bit rate in bits per second.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.746 -0500", hash_original_method = "1B43BF8F9E62EF0E8125F105BE9509D7", hash_generated_method = "2E4B236D77DB8201A6989B7DB2AF8A73")
    
public void setVideoEncodingBitRate(int bitRate) {
        if (bitRate <= 0) {
            throw new IllegalArgumentException("Video encoding bit rate is not positive");
        }
        setParameter("video-param-encoding-bitrate=" + bitRate);
    }

    /**
     * Currently not implemented. It does nothing.
     * @deprecated Time lapse mode video recording using camera still image capture
     * is not desirable, and will not be supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.749 -0500", hash_original_method = "A0B41C1DE963DD2616BE7FC07860DC3A", hash_generated_method = "11EFEF95E368DAB504150D8F68D13C90")
    
public void setAuxiliaryOutputFile(FileDescriptor fd)
    {
        Log.w(TAG, "setAuxiliaryOutputFile(FileDescriptor) is no longer supported.");
    }

    /**
     * Currently not implemented. It does nothing.
     * @deprecated Time lapse mode video recording using camera still image capture
     * is not desirable, and will not be supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.751 -0500", hash_original_method = "8F81BCAE7FDFB44AAC23771364E7255A", hash_generated_method = "EB63C4A65BE0D6BB1C1D0136FA2F9670")
    
public void setAuxiliaryOutputFile(String path)
    {
        Log.w(TAG, "setAuxiliaryOutputFile(String) is no longer supported.");
    }

    
    public final class AudioSource {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.581 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.583 -0500", hash_original_field = "90B550F18429BECB7743997470854499", hash_generated_field = "89465F0654A0491F34195BE641F9DB65")

        public static final int MIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.586 -0500", hash_original_field = "BA46962DFEB7ED7C1F09E88EB913E6E6", hash_generated_field = "90A17892BF97A29B5BD446CAFBF897DD")

        public static final int VOICE_UPLINK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.589 -0500", hash_original_field = "867CF961310DF8C43DE8D6C36E4186CC", hash_generated_field = "5EEB68744FCF8348A75188E44BE76169")

        public static final int VOICE_DOWNLINK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.591 -0500", hash_original_field = "D2895EA10BC2BBC8BCC90B7F172E21DE", hash_generated_field = "49BFB3D7BE309D83437E28457BAFC976")

        public static final int VOICE_CALL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.595 -0500", hash_original_field = "5CA74D21CBBC739C15EF683344AB4007", hash_generated_field = "8DC1158A9D233DC7FFF69B2EDFDD704F")

        public static final int CAMCORDER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.598 -0500", hash_original_field = "56A2882DB552893ECF57B9DFF037C6A8", hash_generated_field = "45CFD7F8EA7E41DAF76DC8ED3970A004")

        public static final int VOICE_RECOGNITION = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.600 -0500", hash_original_field = "BFF75FA3AA5E4BC6F5019FD09B64B851", hash_generated_field = "B397F140ED8B28D51364DD3E05636498")

        public static final int VOICE_COMMUNICATION = 7;
      /* Do not change these values without updating their counterparts
       * in include/media/mediarecorder.h!
       */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.578 -0500", hash_original_method = "1914278202FF0C4E3ADF5F5B470D9B6D", hash_generated_method = "DFFF6D74457B27C8BA98DDF58C3CB34B")
        
private AudioSource() {}
    }


    
    public final class VideoSource {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.608 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.611 -0500", hash_original_field = "A57B5C3A415D03BE754BC2B323E0E332", hash_generated_field = "7CE3D21269D301A2E86C74E7AF7A5300")

        public static final int CAMERA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.613 -0500", hash_original_field = "2AA54F1923B7FAF39E4AF8BA18C1E315", hash_generated_field = "3C4EF62B1980A32AE72BB139DFCD5FA1")

        public static final int GRALLOC_BUFFER = 2;
      /* Do not change these values without updating their counterparts
       * in include/media/mediarecorder.h!
       */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.605 -0500", hash_original_method = "E9434F68306FDA3E7486EA51EADD9FCF", hash_generated_method = "CA49AC3B5BDDB09CFF112195AB2BE75A")
        
private VideoSource() {}
    }


    
    public final class OutputFormat {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.622 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.624 -0500", hash_original_field = "46F8E06EB3012DA062A485839471A64F", hash_generated_field = "D3770F2D73F1C6B56C130215D63C9BAE")

        public static final int THREE_GPP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.627 -0500", hash_original_field = "2C2860B5078554F6C3033677421C4C0D", hash_generated_field = "5DD4510459A97D677E4E2D2492A4FF61")

        public static final int MPEG_4 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.629 -0500", hash_original_field = "F1602A853BE848457682081C3408CF24", hash_generated_field = "E8252C052C93D6E303FCD352172EB067")

        /** @deprecated  Deprecated in favor of AMR_NB */
        /** Deprecated in favor of MediaRecorder.OutputFormat.AMR_NB */
        /** AMR NB file format */
        public static final int RAW_AMR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.632 -0500", hash_original_field = "75B913DE33424C2B11627538D37853D0", hash_generated_field = "443A5AF6FEA7E0B4365B35CF3CB9DB0F")

        public static final int AMR_NB = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.635 -0500", hash_original_field = "63D7792A5E21DF17F9974780ABA7CA49", hash_generated_field = "91F81A7C4280DDD1E763B5B23680538E")

        public static final int AMR_WB = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.637 -0500", hash_original_field = "F9501A96064E19F70A2CB14875DEF788", hash_generated_field = "A5FAEB630071211D41D30C0892D7F176")

        public static final int AAC_ADIF = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.640 -0500", hash_original_field = "1870EF0093ADE3239BBFED1D4F9170FE", hash_generated_field = "C6EBD2555D415844ACBED557BA29B9CA")

        public static final int AAC_ADTS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.643 -0500", hash_original_field = "E1EB47BB402EC1D11987F573CFBA2A23", hash_generated_field = "95D428AD2AB2062B94DDBBEC532A44F1")

        public static final int OUTPUT_FORMAT_RTP_AVP = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.645 -0500", hash_original_field = "CBCE21809A3F39F8C6BE741054754B5E", hash_generated_field = "B9EE92CB38D37A7660BFF79E60563FC2")

        public static final int OUTPUT_FORMAT_MPEG2TS = 8;
      /* Do not change these values without updating their counterparts
       * in include/media/mediarecorder.h!
       */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.618 -0500", hash_original_method = "9E0C1C4960BAFFDB241CC667DA1146ED", hash_generated_method = "BBA664158A82D4EAC4B2B8B9589E38FD")
        
private OutputFormat() {}
    }


    
    public final class AudioEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.658 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.660 -0500", hash_original_field = "F716C119FEE124980540C9DB9B292BB8", hash_generated_field = "4E63B8106CD34244D82CF25D0E726F85")

        public static final int AMR_NB = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.663 -0500", hash_original_field = "071FA89964204225AC216DA0C638A273", hash_generated_field = "95FBA6B812FAACD86EC4EF8BA1FA7706")

        public static final int AMR_WB = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.666 -0500", hash_original_field = "B854F53749D4BF9A31965815CF43E89D", hash_generated_field = "58DC9CF32D4FC8D9B7A661DD16864FD5")

        public static final int AAC = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.668 -0500", hash_original_field = "3265B1F4075F31C6A129FA4B607A53C7", hash_generated_field = "2B595A2DB28339B6C02B5452F0DD4A53")

        public static final int AAC_PLUS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.671 -0500", hash_original_field = "3EB8BB96DBFFC6FB7540528AAA6598D2", hash_generated_field = "FBDB211B6AAFD51E6666396ED7C56525")

        public static final int EAAC_PLUS = 5;
      /* Do not change these values without updating their counterparts
       * in include/media/mediarecorder.h!
       */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.654 -0500", hash_original_method = "E3F3678601E82E2E28134E86FEA86320", hash_generated_method = "4905571D68B41322B360661A30C9AA73")
        
private AudioEncoder() {}
    }


    
    public final class VideoEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.678 -0500", hash_original_field = "83EA75ECA2D71F21AD72E47BF00B465F", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.682 -0500", hash_original_field = "CD1D1E6810DD8613A23310504FD218D3", hash_generated_field = "3A5D211A19ED8C27BA0AC58B828A4D79")

        public static final int H263 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.684 -0500", hash_original_field = "45328F552E68FD123B931A1BE05A165B", hash_generated_field = "92F9DF765E4F53703221A3C3DE50E581")

        public static final int H264 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.687 -0500", hash_original_field = "0469BEC6905D5C048CE4685F93A8D420", hash_generated_field = "CCEF3196B331149C17DD0C3668A71318")

        public static final int MPEG_4_SP = 3;
      /* Do not change these values without updating their counterparts
       * in include/media/mediarecorder.h!
       */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.676 -0500", hash_original_method = "EADA6CD287D24DC0909ED37DE6E606B1", hash_generated_method = "5887FDC6854B832C59D60F3F2C02880F")
        
private VideoEncoder() {}
    }


    
    private class EventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.843 -0500", hash_original_field = "45C88812154FF5D629B54069A694BAB3", hash_generated_field = "9C109692EDE5D079034090A3A5B32D69")

        private static final int MEDIA_RECORDER_EVENT_LIST_START = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.846 -0500", hash_original_field = "6A23448DF4F4B4460583ED7DF93FA6DF", hash_generated_field = "886088AD5E952313162F484786CA15C4")

        private static final int MEDIA_RECORDER_EVENT_ERROR      = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.848 -0500", hash_original_field = "AB0E06E22392CC8099A7ACA56BFD462B", hash_generated_field = "792B775348EBFCDD938E145916D10B36")

        private static final int MEDIA_RECORDER_EVENT_INFO       = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.852 -0500", hash_original_field = "A2FED54EE72F33AAFFF1DAD86FED029E", hash_generated_field = "844D02ED01F59BE4DBBF6DEF39558879")

        private static final int MEDIA_RECORDER_EVENT_LIST_END   = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.855 -0500", hash_original_field = "36A9FCE6F52EB08D2E60917EA25E8498", hash_generated_field = "9B3C84A58039FECDE0C2C87D311D208C")

        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_START = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.858 -0500", hash_original_field = "06521468407A4B4923110D6EF4EB6291", hash_generated_field = "395C4990FFB280E2C07E3928F8CFD1E1")

        private static final int MEDIA_RECORDER_TRACK_EVENT_ERROR      = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.861 -0500", hash_original_field = "998FBA9863F7C5C367F45DC7DC67EAE0", hash_generated_field = "93E934C8F6153B902CFD4A663646FFE5")

        private static final int MEDIA_RECORDER_TRACK_EVENT_INFO       = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.864 -0500", hash_original_field = "A1F4C7AC9AF8404F5A0829BB07CE0177", hash_generated_field = "1C4918095A47ABC837FD22C73A72E61B")

        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_END   = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.837 -0500", hash_original_field = "0B03B34457A233BCD764BAB404EE317E", hash_generated_field = "526675EDFD2DC4635351394443EC2399")

        private MediaRecorder mMediaRecorder;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.841 -0500", hash_original_method = "BC989655A6094FBF6B2474E845244153", hash_generated_method = "40649CE9B5A9B3F221A019290F4CD3A5")
        
public EventHandler(MediaRecorder mr, Looper looper) {
            super(looper);
            mMediaRecorder = mr;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.867 -0500", hash_original_method = "86EEE127740FDFEE4F0B3E353E660995", hash_generated_method = "735214346EF0755B5287857357227450")
        
@Override
        public void handleMessage(Message msg) {
            if (mMediaRecorder.mNativeContext == 0) {
                Log.w(TAG, "mediarecorder went away with unhandled events");
                return;
            }
            switch(msg.what) {
            case MEDIA_RECORDER_EVENT_ERROR:
            case MEDIA_RECORDER_TRACK_EVENT_ERROR:
                if (mOnErrorListener != null)
                    mOnErrorListener.onError(mMediaRecorder, msg.arg1, msg.arg2);

                return;

            case MEDIA_RECORDER_EVENT_INFO:
            case MEDIA_RECORDER_TRACK_EVENT_INFO:
                if (mOnInfoListener != null)
                    mOnInfoListener.onInfo(mMediaRecorder, msg.arg1, msg.arg2);

                return;

            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
        }
    }


    
    public interface OnErrorListener
    {
        
        void onError(MediaRecorder mr, int what, int extra);
    }
    
    public interface OnInfoListener
    {
        
        void onInfo(MediaRecorder mr, int what, int extra);
    }
    
    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    /**
     * Pass in the file descriptor of the file to be written. Call this after
     * setOutputFormat() but before prepare().
     *
     * @param fd an open file descriptor to be written into.
     * @throws IllegalStateException if it is called before
     * setOutputFormat() or after prepare()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.753 -0500", hash_original_method = "FA1E1C8AC397C2513A8C4BBA9653310E", hash_generated_method = "20129432203CB4522BC7B5624FBDB421")
    
public void setOutputFile(FileDescriptor fd) throws IllegalStateException
    {
        mPath = null;
        mFd = fd;
    }

    /**
     * Sets the path of the output file to be produced. Call this after
     * setOutputFormat() but before prepare().
     *
     * @param path The pathname to use.
     * @throws IllegalStateException if it is called before
     * setOutputFormat() or after prepare()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.756 -0500", hash_original_method = "6471C594BC35F434C75030DABF9E1236", hash_generated_method = "F163D610DEC881F8C19F64DA9DD9F649")
    
public void setOutputFile(String path) throws IllegalStateException
    {
        mFd = null;
        mPath = path;
    }

    // native implementation
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.760 -0500", hash_original_method = "2C3645C01F64B8B930F730173F6904DB", hash_generated_method = "224DB2A0B75AE3A5424A5128F85F36EF")
    
    private void _setOutputFile(FileDescriptor fd, long offset, long length)
            throws IllegalStateException, IOException{
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(offset);
    	addTaint(length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.763 -0500", hash_original_method = "E491231BBA55EF515861E8AF21F37CD9", hash_generated_method = "DE8DCBC67F8D616E500889732F057EEF")
    
    private void _prepare() throws IllegalStateException, IOException{
    	//Formerly a native method
    }


    /**
     * Prepares the recorder to begin capturing and encoding data. This method
     * must be called after setting up the desired audio and video sources,
     * encoders, file format, etc., but before start().
     *
     * @throws IllegalStateException if it is called after
     * start() or before setOutputFormat().
     * @throws IOException if prepare fails otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.766 -0500", hash_original_method = "7733A0B67510DBD5B4C9708918E65D9C", hash_generated_method = "119195F284072448E9B84AEEE88AFDF9")
    
public void prepare() throws IllegalStateException, IOException
    {
        if (mPath != null) {
            FileOutputStream fos = new FileOutputStream(mPath);
            try {
                _setOutputFile(fos.getFD(), 0, 0);
            } finally {
                fos.close();
            }
        } else if (mFd != null) {
            _setOutputFile(mFd, 0, 0);
        } else {
            throw new IOException("No valid output file");
        }

        _prepare();
    }

    /**
     * Begins capturing and encoding data to the file specified with
     * setOutputFile(). Call this after prepare().
     *
     * <p>Since API level 13, if applications set a camera via
     * {@link #setCamera(Camera)}, the apps can use the camera after this method
     * call. The apps do not need to lock the camera again. However, if this
     * method fails, the apps should still lock the camera back. The apps should
     * not start another recording session during recording.
     *
     * @throws IllegalStateException if it is called before
     * prepare().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.770 -0500", hash_original_method = "90417EDC9CEDC2FF729AF34E20BAF720", hash_generated_method = "E1969946DB5A9D768E401BA7A78BBDBA")
    
    public void start() throws IllegalStateException{
    	//Formerly a native method
    }


    /**
     * Stops recording. Call this after start(). Once recording is stopped,
     * you will have to configure it again as if it has just been constructed.
     * Note that a RuntimeException is intentionally thrown to the
     * application, if no valid audio/video data has been received when stop()
     * is called. This happens if stop() is called immediately after
     * start(). The failure lets the application take action accordingly to
     * clean up the output file (delete the output file, for instance), since
     * the output file is not properly constructed when this happens.
     *
     * @throws IllegalStateException if it is called before start()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.774 -0500", hash_original_method = "1A5D84AB4E95B4764520ADCE25158630", hash_generated_method = "385DEB438D351260B720EB353DA8EA98")
    
    public void stop() throws IllegalStateException{
    	//Formerly a native method
    }


    /**
     * Restarts the MediaRecorder to its idle state. After calling
     * this method, you will have to configure it again as if it had just been
     * constructed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.777 -0500", hash_original_method = "67287397491424481E1944D5BA3B8E5C", hash_generated_method = "388AF94EBCD41EBAAA15B5C85A60D9C0")
    
public void reset() {
        native_reset();

        // make sure none of the listeners get called anymore
        mEventHandler.removeCallbacksAndMessages(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.780 -0500", hash_original_method = "AD3447507B75200ED00AEACF3A5CF9B9", hash_generated_method = "F805CC6BEAD82A7BA5217CBF0FC80649")
    
    private void native_reset(){
    	//Formerly a native method
    }


    /**
     * Returns the maximum absolute amplitude that was sampled since the last
     * call to this method. Call this only after the setAudioSource().
     *
     * @return the maximum absolute amplitude measured since the last call, or
     * 0 when called for the first time
     * @throws IllegalStateException if it is called before
     * the audio source has been set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.784 -0500", hash_original_method = "F99C2454D7AEDF4869DBA0C6020BA633", hash_generated_method = "069BFC61935E2DBE3DE1D3742E1C3129")
    
    public int getMaxAmplitude() throws IllegalStateException{
    	//Formerly a native method
    	return getTaintInt();
    }


    /**
     * Register a callback to be invoked when an error occurs while
     * recording.
     *
     * @param l the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.791 -0500", hash_original_method = "1D9D4DF006E463AA131E1079BD21BB23", hash_generated_method = "D2226C2AEE46E386CEEAE20829BB160C")
    
public void setOnErrorListener(OnErrorListener l)
    {
        mOnErrorListener = l;
    }

    /**
     * Register a callback to be invoked when an informational event occurs while
     * recording.
     *
     * @param listener the callback that will be run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.834 -0500", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "00A764E9A5F73CCD36593277E2A3C417")
    
public void setOnInfoListener(OnInfoListener listener)
    {
        mOnInfoListener = listener;
    }

    /**
     * Releases resources associated with this MediaRecorder object.
     * It is good practice to call this method when you're done
     * using the MediaRecorder. In particular, whenever an Activity
     * of an application is paused (its onPause() method is called),
     * or stopped (its onStop() method is called), this method should be
     * invoked to release the MediaRecorder object, unless the application
     * has a special need to keep the object around. In addition to
     * unnecessary resources (such as memory and instances of codecs)
     * being held, failure to call this method immediately if a
     * MediaRecorder object is no longer needed may also lead to
     * continuous battery consumption for mobile devices, and recording
     * failure for other applications if no multiple instances of the
     * same codec are supported on a device. Even if multiple instances
     * of the same codec are supported, some performance degradation
     * may be expected when unnecessary multiple instances are used
     * at the same time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.874 -0500", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "278A7E53643DE73F8A80E1A85A107DD5")
    
    public void release(){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.884 -0500", hash_original_method = "BCB4106EE2D8724832D2515EFBDE53A4", hash_generated_method = "DCCBFCF985F5394E4853A6A7FE9607CC")
    
    private final void native_setup(Object mediarecorder_this) throws IllegalStateException{
    	//Formerly a native method
    	addTaint(mediarecorder_this.getTaint());
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.887 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.891 -0500", hash_original_method = "53992B87F33D5F26EA62BF7D01DBCD08", hash_generated_method = "4E9F2B2D4042AF088A97D4F6280C62E8")
    
    private void setParameter(String nameValuePair){
    	//Formerly a native method
    	addTaint(nameValuePair.getTaint());
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.893 -0500", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() { native_finalize(); }
}

