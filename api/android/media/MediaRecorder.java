package android.media;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class MediaRecorder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "4FF8A42CAE4591AC91206314B4192EA4")

    @SuppressWarnings("unused") private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "76C3E3B9188F3B101287AE8BD0308DA5", hash_generated_field = "CF56B07A79F79E335B5E31194908A4ED")

    @SuppressWarnings("unused") private Surface mSurface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "E2307FD862BA74C9C9C26ACA0B7E5364", hash_generated_field = "D884398030F13C93CE57AAFBDAC2F9A3")

    private FileDescriptor mFd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "8E38E8F2821E37DC1388D37AC12A00C5", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.374 -0400", hash_original_field = "A7BB806605AE0AF35AD87648479DCA6F", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.375 -0400", hash_original_method = "506D5AE1E4700103A96E723E2F623CDF", hash_generated_method = "2E21B28EC3593EB078DC5BF40EA1788C")
    public  MediaRecorder() {
        Looper looper;
    if((looper = Looper.myLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } 
        else
    if((looper = Looper.getMainLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } 
        else
        {
            mEventHandler = null;
        } 
        native_setup(new WeakReference<MediaRecorder>(this));
        
        
        
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.375 -0400", hash_original_method = "ABDAB49B7FE2D6558157D548CA69CDD8", hash_generated_method = "C62F29ED3BE34C79C8935033785D9F08")
    public void setCamera(Camera c) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.376 -0400", hash_original_method = "9D12D44BFB2D2426E5261AD40C8A6399", hash_generated_method = "5F5616EC15839F62209B7DDD41139649")
    public void setPreviewDisplay(Surface sv) {
        mSurface = sv;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.376 -0400", hash_original_method = "A371021B9F589CE697BF3A2D834DE3D5", hash_generated_method = "D99CDB6B4B5CFD54011DEE450366ABC1")
    public void setAudioSource(int audio_source) throws IllegalStateException {
    }

    
        public static final int getAudioSourceMax() {
        return AudioSource.VOICE_COMMUNICATION;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.376 -0400", hash_original_method = "95828B107E82D883B2C1CA5CFF39AF89", hash_generated_method = "7DC66B4101958A7F8DCA9F71E12D62F0")
    public void setVideoSource(int video_source) throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.377 -0400", hash_original_method = "C41941EDDC1BA172E48D383432866025", hash_generated_method = "EA0883B7DD7BF1E78DBBB6A767774F67")
    public void setProfile(CamcorderProfile profile) {
        addTaint(profile.getTaint());
        setOutputFormat(profile.fileFormat);
        setVideoFrameRate(profile.videoFrameRate);
        setVideoSize(profile.videoFrameWidth, profile.videoFrameHeight);
        setVideoEncodingBitRate(profile.videoBitRate);
        setVideoEncoder(profile.videoCodec);
    if(profile.quality >= CamcorderProfile.QUALITY_TIME_LAPSE_LOW &&
             profile.quality <= CamcorderProfile.QUALITY_TIME_LAPSE_QVGA)        
        {
            setParameter(String.format("time-lapse-enable=1"));
        } 
        else
        {
            setAudioEncodingBitRate(profile.audioBitRate);
            setAudioChannels(profile.audioChannels);
            setAudioSamplingRate(profile.audioSampleRate);
            setAudioEncoder(profile.audioCodec);
        } 
        
        
        
        
        
        
        
             
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.378 -0400", hash_original_method = "01590CA235372AAAE94DCADBCD3DAA8F", hash_generated_method = "6064683A2F96F5BB98E80985F8AF41BD")
    public void setCaptureRate(double fps) {
        addTaint(fps);
        double timeBetweenFrameCapture = 1 / fps;
        int timeBetweenFrameCaptureMs = (int) (1000 * timeBetweenFrameCapture);
        setParameter(String.format("time-between-time-lapse-frame-capture=%d",
                    timeBetweenFrameCaptureMs));
        
        
        
        
                    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.378 -0400", hash_original_method = "FFEAE3173573A6FB2AF430882DE311CC", hash_generated_method = "90FD177981FABCAB4FC22B6A47A797DB")
    public void setOrientationHint(int degrees) {
        addTaint(degrees);
    if(degrees != 0   &&
            degrees != 90  &&
            degrees != 180 &&
            degrees != 270)        
        {
            IllegalArgumentException var44080591B8B13B6C21BFD98883B08501_1024956902 = new IllegalArgumentException("Unsupported angle: " + degrees);
            var44080591B8B13B6C21BFD98883B08501_1024956902.addTaint(taint);
            throw var44080591B8B13B6C21BFD98883B08501_1024956902;
        } 
        setParameter("video-param-rotation-angle-degrees=" + degrees);
        
        
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.379 -0400", hash_original_method = "95876148111FCD378C0A7171639D46C7", hash_generated_method = "DCF16BCEF110FC7905459C185DEF0288")
    public void setLocation(float latitude, float longitude) {
        addTaint(longitude);
        addTaint(latitude);
        int latitudex10000 = (int) (latitude * 10000 + 0.5);
        int longitudex10000 = (int) (longitude * 10000 + 0.5);
    if(latitudex10000 > 900000 || latitudex10000 < -900000)        
        {
            String msg = "Latitude: " + latitude + " out of range.";
            IllegalArgumentException varBF1DE0EBB10945813AF140C2533CC7FB_49090134 = new IllegalArgumentException(msg);
            varBF1DE0EBB10945813AF140C2533CC7FB_49090134.addTaint(taint);
            throw varBF1DE0EBB10945813AF140C2533CC7FB_49090134;
        } 
    if(longitudex10000 > 1800000 || longitudex10000 < -1800000)        
        {
            String msg = "Longitude: " + longitude + " out of range";
            IllegalArgumentException varBF1DE0EBB10945813AF140C2533CC7FB_1325144122 = new IllegalArgumentException(msg);
            varBF1DE0EBB10945813AF140C2533CC7FB_1325144122.addTaint(taint);
            throw varBF1DE0EBB10945813AF140C2533CC7FB_1325144122;
        } 
        setParameter("param-geotag-latitude=" + latitudex10000);
        setParameter("param-geotag-longitude=" + longitudex10000);
        
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.379 -0400", hash_original_method = "16B1291E62A33A134EF60F37C7D2CCB8", hash_generated_method = "F0DB7B5B0530417259C232AB1266B1EB")
    public void setOutputFormat(int output_format) throws IllegalStateException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.379 -0400", hash_original_method = "71A5DAEC76B8523A4C4E858FBAE085E2", hash_generated_method = "714F37A0A7FD7CD477077D9AEBBFA0E2")
    public void setVideoSize(int width, int height) throws IllegalStateException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.380 -0400", hash_original_method = "4711F19464352F93232DA12822C7FDFE", hash_generated_method = "CA3360721243781B824AEC6DEE401679")
    public void setVideoFrameRate(int rate) throws IllegalStateException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.380 -0400", hash_original_method = "B668CBA366084C55F47F6ED4964FF898", hash_generated_method = "F8C6E88E05EC572B64D25C575D25FEA1")
    public void setMaxDuration(int max_duration_ms) throws IllegalArgumentException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.380 -0400", hash_original_method = "A50E13690D0D35FC40A0268A3FC87BD5", hash_generated_method = "86641D9D4B0514DCC04D76FDE8B2AD78")
    public void setMaxFileSize(long max_filesize_bytes) throws IllegalArgumentException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.381 -0400", hash_original_method = "1CF1181ABC96941035EF958A99727050", hash_generated_method = "6A3A5B178BE37A3212BEDC346A89B044")
    public void setAudioEncoder(int audio_encoder) throws IllegalStateException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.381 -0400", hash_original_method = "ABD82A110412540080E22D800F212AD9", hash_generated_method = "6A0EA86A8C6F8FAEBF01009084CE3D79")
    public void setVideoEncoder(int video_encoder) throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.382 -0400", hash_original_method = "A30D5A78BCFDD0EC33430FA69AAB0135", hash_generated_method = "DC912852D5F2EABCA259C8F567138224")
    public void setAudioSamplingRate(int samplingRate) {
        addTaint(samplingRate);
    if(samplingRate <= 0)        
        {
            IllegalArgumentException var175D308EEF77C8867F2D05EC7B31AA50_2078868022 = new IllegalArgumentException("Audio sampling rate is not positive");
            var175D308EEF77C8867F2D05EC7B31AA50_2078868022.addTaint(taint);
            throw var175D308EEF77C8867F2D05EC7B31AA50_2078868022;
        } 
        setParameter("audio-param-sampling-rate=" + samplingRate);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.382 -0400", hash_original_method = "6F6BACC54031B00DCF8168A950EA33D9", hash_generated_method = "97D659C087AB5F34CFA237B26B61AE6B")
    public void setAudioChannels(int numChannels) {
        addTaint(numChannels);
    if(numChannels <= 0)        
        {
            IllegalArgumentException var1CFCCB3DC08E264BD9B205524F8EEAB0_1660196004 = new IllegalArgumentException("Number of channels is not positive");
            var1CFCCB3DC08E264BD9B205524F8EEAB0_1660196004.addTaint(taint);
            throw var1CFCCB3DC08E264BD9B205524F8EEAB0_1660196004;
        } 
        setParameter("audio-param-number-of-channels=" + numChannels);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.383 -0400", hash_original_method = "3786AB4A2177EE063AA4F526AF23E799", hash_generated_method = "CF71E3733E08F523C4715512BC1C8709")
    public void setAudioEncodingBitRate(int bitRate) {
        addTaint(bitRate);
    if(bitRate <= 0)        
        {
            IllegalArgumentException var2C3D07B8F1364484018D091477343E17_1482802705 = new IllegalArgumentException("Audio encoding bit rate is not positive");
            var2C3D07B8F1364484018D091477343E17_1482802705.addTaint(taint);
            throw var2C3D07B8F1364484018D091477343E17_1482802705;
        } 
        setParameter("audio-param-encoding-bitrate=" + bitRate);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.383 -0400", hash_original_method = "1B43BF8F9E62EF0E8125F105BE9509D7", hash_generated_method = "7918DA0A9D77D6B4F975B245FED3154F")
    public void setVideoEncodingBitRate(int bitRate) {
        addTaint(bitRate);
    if(bitRate <= 0)        
        {
            IllegalArgumentException var1E05488F04493BF106383CD7797CD8DC_190223228 = new IllegalArgumentException("Video encoding bit rate is not positive");
            var1E05488F04493BF106383CD7797CD8DC_190223228.addTaint(taint);
            throw var1E05488F04493BF106383CD7797CD8DC_190223228;
        } 
        setParameter("video-param-encoding-bitrate=" + bitRate);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.384 -0400", hash_original_method = "A0B41C1DE963DD2616BE7FC07860DC3A", hash_generated_method = "F9ED9DF6F92CC32C9A66BD87F2715733")
    public void setAuxiliaryOutputFile(FileDescriptor fd) {
        addTaint(fd.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.384 -0400", hash_original_method = "8F81BCAE7FDFB44AAC23771364E7255A", hash_generated_method = "AAD3CF3C79CF1F5A00C1B6681DB3A216")
    public void setAuxiliaryOutputFile(String path) {
        addTaint(path.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.385 -0400", hash_original_method = "FA1E1C8AC397C2513A8C4BBA9653310E", hash_generated_method = "58002DD5C7357E5293C6369D49CE59B9")
    public void setOutputFile(FileDescriptor fd) throws IllegalStateException {
        mPath = null;
        mFd = fd;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.385 -0400", hash_original_method = "6471C594BC35F434C75030DABF9E1236", hash_generated_method = "E4F79276AA1501CD7F5EECB78A818C10")
    public void setOutputFile(String path) throws IllegalStateException {
        mFd = null;
        mPath = path;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.385 -0400", hash_original_method = "2C3645C01F64B8B930F730173F6904DB", hash_generated_method = "F84ACA8CCCE4058BD15A45193910AC38")
    private void _setOutputFile(FileDescriptor fd, long offset, long length) throws IllegalStateException, IOException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.386 -0400", hash_original_method = "E491231BBA55EF515861E8AF21F37CD9", hash_generated_method = "F0AF919CE47AB66A413EAFFF98A697CA")
    private void _prepare() throws IllegalStateException, IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.386 -0400", hash_original_method = "7733A0B67510DBD5B4C9708918E65D9C", hash_generated_method = "3711EE034134C1CC9C9338C73D3EFF9D")
    public void prepare() throws IllegalStateException, IOException {
    if(mPath != null)        
        {
            FileOutputStream fos = new FileOutputStream(mPath);
            try 
            {
                _setOutputFile(fos.getFD(), 0, 0);
            } 
            finally 
            {
                fos.close();
            } 
        } 
        else
    if(mFd != null)        
        {
            _setOutputFile(mFd, 0, 0);
        } 
        else
        {
            IOException var00C2BD90EB572444AC32E0AED22E6D5F_663115286 = new IOException("No valid output file");
            var00C2BD90EB572444AC32E0AED22E6D5F_663115286.addTaint(taint);
            throw var00C2BD90EB572444AC32E0AED22E6D5F_663115286;
        } 
        _prepare();
        
        
            
            
                
            
                
            
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.387 -0400", hash_original_method = "90417EDC9CEDC2FF729AF34E20BAF720", hash_generated_method = "09CCB07F360AB024F02D74DF25B2B096")
    public void start() throws IllegalStateException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.387 -0400", hash_original_method = "1A5D84AB4E95B4764520ADCE25158630", hash_generated_method = "C37260719D5C7AD3799BFDB704DE9E51")
    public void stop() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.387 -0400", hash_original_method = "67287397491424481E1944D5BA3B8E5C", hash_generated_method = "79ECFE2A177A18F252BA9C1D46E1CAD0")
    public void reset() {
        native_reset();
        mEventHandler.removeCallbacksAndMessages(null);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.387 -0400", hash_original_method = "AD3447507B75200ED00AEACF3A5CF9B9", hash_generated_method = "EE98BA7D4CA1DF8A6E8C27E6B5C21C55")
    private void native_reset() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.388 -0400", hash_original_method = "F99C2454D7AEDF4869DBA0C6020BA633", hash_generated_method = "9BCE54AEF44E385813D0D1E80027EAD2")
    public int getMaxAmplitude() throws IllegalStateException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568675123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568675123;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.388 -0400", hash_original_method = "1D9D4DF006E463AA131E1079BD21BB23", hash_generated_method = "F76228A81F30849808D6699A5C1AC6AA")
    public void setOnErrorListener(OnErrorListener l) {
        mOnErrorListener = l;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.388 -0400", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "CC22DF79C368D299CC0E0400ABB99A07")
    public void setOnInfoListener(OnInfoListener listener) {
        mOnInfoListener = listener;
        
        
    }

    
        private static void postEventFromNative(Object mediarecorder_ref,
                                            int what, int arg1, int arg2, Object obj) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.389 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "41B8B73906B263B02861ABB4EEE712F2")
    public void release() {
    }

    
    private static final void native_init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.389 -0400", hash_original_method = "BCB4106EE2D8724832D2515EFBDE53A4", hash_generated_method = "7BD86FE3D42C7ED0FD9D21C1CF2294C8")
    private final void native_setup(Object mediarecorder_this) throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.390 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "BE94CB6DE9EDBEEF7D151AA52A7096EC")
    private final void native_finalize() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.390 -0400", hash_original_method = "53992B87F33D5F26EA62BF7D01DBCD08", hash_generated_method = "A37318CD0353B217F398410D61395DC1")
    private void setParameter(String nameValuePair) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.390 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    @Override
    protected void finalize() {
        native_finalize();
        
        
    }

    
    public final class AudioSource {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_method = "1914278202FF0C4E3ADF5F5B470D9B6D", hash_generated_method = "F20A029D5D262C5111647D9E6D0AA478")
        private  AudioSource() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "B31BC3FD460B53ECB6E0C557DD8CA0EB", hash_generated_field = "89465F0654A0491F34195BE641F9DB65")

        public static final int MIC = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "CB4AEEB8032E096212E1C12530CEBB3B", hash_generated_field = "90A17892BF97A29B5BD446CAFBF897DD")

        public static final int VOICE_UPLINK = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "399B5A5906D318A38E3796C38DE9B3BB", hash_generated_field = "5EEB68744FCF8348A75188E44BE76169")

        public static final int VOICE_DOWNLINK = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "38EAB10734656F65424D5D160A255330", hash_generated_field = "49BFB3D7BE309D83437E28457BAFC976")

        public static final int VOICE_CALL = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "6C1DECCC4D51A4F12256ED1634419BA4", hash_generated_field = "8DC1158A9D233DC7FFF69B2EDFDD704F")

        public static final int CAMCORDER = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "C0BF7DCB26F3CC982B1CF5B51A722D0E", hash_generated_field = "45CFD7F8EA7E41DAF76DC8ED3970A004")

        public static final int VOICE_RECOGNITION = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "0B1A1CC21476C0CFE9109D15BCC39019", hash_generated_field = "B397F140ED8B28D51364DD3E05636498")

        public static final int VOICE_COMMUNICATION = 7;
    }


    
    public final class VideoSource {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_method = "E9434F68306FDA3E7486EA51EADD9FCF", hash_generated_method = "69815C0E42EBCBCEB6A0DE4A890DB903")
        private  VideoSource() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.391 -0400", hash_original_field = "4DC16EEF397E768957D0E1E0E69A305F", hash_generated_field = "7CE3D21269D301A2E86C74E7AF7A5300")

        public static final int CAMERA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "06E68E745127C0A2129FC82C25A606CD", hash_generated_field = "3C4EF62B1980A32AE72BB139DFCD5FA1")

        public static final int GRALLOC_BUFFER = 2;
    }


    
    public final class OutputFormat {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_method = "9E0C1C4960BAFFDB241CC667DA1146ED", hash_generated_method = "553275D8A28B3F06BA2AAF766D2B6DD6")
        private  OutputFormat() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "0198BE37F0B1F9C626F593979BFF2A22", hash_generated_field = "D3770F2D73F1C6B56C130215D63C9BAE")

        public static final int THREE_GPP = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "1E9CE8CA732396291AEDEF96D9150615", hash_generated_field = "5DD4510459A97D677E4E2D2492A4FF61")

        public static final int MPEG_4 = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "B6585C9FFBA6B555BCCACBC7B3D68FFE", hash_generated_field = "B866DF9FD45EA3608336C73AADADDFC3")

        public static final int RAW_AMR = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "A7AF9FE1740F297C36880B4D574C541D", hash_generated_field = "443A5AF6FEA7E0B4365B35CF3CB9DB0F")

        public static final int AMR_NB = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "5BA05D109F724BFA14F8B6726ED8ABC9", hash_generated_field = "91F81A7C4280DDD1E763B5B23680538E")

        public static final int AMR_WB = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "A7C819B3789BD466154D900FC5899E48", hash_generated_field = "A5FAEB630071211D41D30C0892D7F176")

        public static final int AAC_ADIF = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "8F3C1E1FE86BC65DCCF053CD72431F3E", hash_generated_field = "C6EBD2555D415844ACBED557BA29B9CA")

        public static final int AAC_ADTS = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.392 -0400", hash_original_field = "F66C812537BCC31E47CDADDFB6774E16", hash_generated_field = "95D428AD2AB2062B94DDBBEC532A44F1")

        public static final int OUTPUT_FORMAT_RTP_AVP = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "2F8745786C02283045DC0C8E0C4F9BA3", hash_generated_field = "B9EE92CB38D37A7660BFF79E60563FC2")

        public static final int OUTPUT_FORMAT_MPEG2TS = 8;
    }


    
    public final class AudioEncoder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_method = "E3F3678601E82E2E28134E86FEA86320", hash_generated_method = "9B57A224E45CD93012FC1AF25BD670F0")
        private  AudioEncoder() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "E5AF671D1D8897BF337E9FF2FF9197A6", hash_generated_field = "4E63B8106CD34244D82CF25D0E726F85")

        public static final int AMR_NB = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "1B2AB24E82D110E50FB05DA6E02E590F", hash_generated_field = "95FBA6B812FAACD86EC4EF8BA1FA7706")

        public static final int AMR_WB = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "22B6AB09E03D6CD8B9264A051A6EDB36", hash_generated_field = "58DC9CF32D4FC8D9B7A661DD16864FD5")

        public static final int AAC = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "A12EFE607EA11D8D1DE1A62C0AB02AEA", hash_generated_field = "2B595A2DB28339B6C02B5452F0DD4A53")

        public static final int AAC_PLUS = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_field = "668FA58EB5181DDFB92151ADF067B55E", hash_generated_field = "FBDB211B6AAFD51E6666396ED7C56525")

        public static final int EAAC_PLUS = 5;
    }


    
    public final class VideoEncoder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.393 -0400", hash_original_method = "EADA6CD287D24DC0909ED37DE6E606B1", hash_generated_method = "23BF99383FCE5E43D5D78B8BE02688CD")
        private  VideoEncoder() {
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "F5A513FC09A88F617602B5914AAD8A90")

        public static final int DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_field = "FAAF29CF17F93CB23FB2C4B104428A18", hash_generated_field = "3A5D211A19ED8C27BA0AC58B828A4D79")

        public static final int H263 = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_field = "5EC8B394575CC46B196C8C4C31CC9F24", hash_generated_field = "92F9DF765E4F53703221A3C3DE50E581")

        public static final int H264 = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_field = "A65B395EE78EB403C8B3C1B89C90F30E", hash_generated_field = "CCEF3196B331149C17DD0C3668A71318")

        public static final int MPEG_4_SP = 3;
    }


    
    private class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_field = "8039EBA0A52E8CC0376F0D24C0F90ABC", hash_generated_field = "526675EDFD2DC4635351394443EC2399")

        private MediaRecorder mMediaRecorder;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.394 -0400", hash_original_method = "BC989655A6094FBF6B2474E845244153", hash_generated_method = "6F3FA053C9E13DE303FE44826536ADF2")
        public  EventHandler(MediaRecorder mr, Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            mMediaRecorder = mr;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_method = "86EEE127740FDFEE4F0B3E353E660995", hash_generated_method = "2BCD28D764BA89C00B38E8931A6D4D04")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mMediaRecorder.mNativeContext == 0)            
            {
                return;
            } 
switch(msg.what){
            case MEDIA_RECORDER_EVENT_ERROR:
            case MEDIA_RECORDER_TRACK_EVENT_ERROR:
    if(mOnErrorListener != null)            
            mOnErrorListener.onError(mMediaRecorder, msg.arg1, msg.arg2);
            return;
            case MEDIA_RECORDER_EVENT_INFO:
            case MEDIA_RECORDER_TRACK_EVENT_INFO:
    if(mOnInfoListener != null)            
            mOnInfoListener.onInfo(mMediaRecorder, msg.arg1, msg.arg2);
            return;
            default:
            return;
}
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "3FDA4D3DF7BD5028EFD7239CFC21B670", hash_generated_field = "9C109692EDE5D079034090A3A5B32D69")

        private static final int MEDIA_RECORDER_EVENT_LIST_START = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "356CE648374C3D3523AC6B06E915EAAC", hash_generated_field = "886088AD5E952313162F484786CA15C4")

        private static final int MEDIA_RECORDER_EVENT_ERROR = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "60E955755188E9013460B4C2D30B8FDF", hash_generated_field = "792B775348EBFCDD938E145916D10B36")

        private static final int MEDIA_RECORDER_EVENT_INFO = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "8BE7E85A1E0E1E525A1AB196F3C24B51", hash_generated_field = "844D02ED01F59BE4DBBF6DEF39558879")

        private static final int MEDIA_RECORDER_EVENT_LIST_END = 99;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "256D1B26FB995C3A33A85F783C4A506C", hash_generated_field = "9B3C84A58039FECDE0C2C87D311D208C")

        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_START = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "150004610A13260840D642B797D71819", hash_generated_field = "395C4990FFB280E2C07E3928F8CFD1E1")

        private static final int MEDIA_RECORDER_TRACK_EVENT_ERROR = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.395 -0400", hash_original_field = "6DB83AE99E453F142C82CC7F49ED3D89", hash_generated_field = "93E934C8F6153B902CFD4A663646FFE5")

        private static final int MEDIA_RECORDER_TRACK_EVENT_INFO = 101;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "FE9E67281D2EA7A83E6B60FD173E852E", hash_generated_field = "1C4918095A47ABC837FD22C73A72E61B")

        private static final int MEDIA_RECORDER_TRACK_EVENT_LIST_END = 1000;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "6E959B5F5733DB5AD7773CCAE1539959", hash_generated_field = "9E43FF77760065A7AB714E624C6D69AB")

    private final static String TAG = "MediaRecorder";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "BB16199AF5453FB362A48E86817503FE", hash_generated_field = "97555EA64399E0289DCBF5DD47FC29B4")

    public static final int MEDIA_RECORDER_ERROR_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "FB7CA55A3934CCEAD58715662CE9E55E", hash_generated_field = "0B6CAE5A52FF0ECFA787E46572776715")

    public static final int MEDIA_RECORDER_INFO_UNKNOWN              = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "C2DD44155A628B7AAB46D14D8E16CFEF", hash_generated_field = "04EAFD1B3BFD1A45EAE65B296BD6769C")

    public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "758FBE9E4E584AF0942DF64F5394AB64", hash_generated_field = "CAA6A66648565C81318827AC26143889")

    public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "45B39736C781A7650B609B521884DEF1", hash_generated_field = "1AA2399DCC90B28574227B0FE4AF7F61")

    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_START        = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "40920D5926CBDE23895CC517632CBD96", hash_generated_field = "66A653CE8B76D184FB603AFBB295456A")

    public static final int MEDIA_RECORDER_TRACK_INFO_COMPLETION_STATUS = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "D9344029B0DDC945F0954ABD144FC88D", hash_generated_field = "86E5ECC98E07406B87D502E73DF7799B")

    public static final int MEDIA_RECORDER_TRACK_INFO_PROGRESS_IN_TIME  = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "FD3099DF8491DFB575EC5E479C23D7D5", hash_generated_field = "FD2EC5286FF04A861353CCB083E74A8D")

    public static final int MEDIA_RECORDER_TRACK_INFO_TYPE              = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "FA6F218BF79DC3C47F73E3F8B8AD515C", hash_generated_field = "6B9258FC4BFFC05F7B0C562674BF9762")

    public static final int MEDIA_RECORDER_TRACK_INFO_DURATION_MS       = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "63451E3308EC24BD7657A346E39B5F76", hash_generated_field = "6DE76F50962E226685A8D7A25FF0114D")

    public static final int MEDIA_RECORDER_TRACK_INFO_MAX_CHUNK_DUR_MS  = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "E21484A60484DDF7DE7533FBC5C95279", hash_generated_field = "F6496C2AEAE4201C20530F93BDF9ACA5")

    public static final int MEDIA_RECORDER_TRACK_INFO_ENCODED_FRAMES    = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "C6F919E25CA7699400C51CC35386CD6B", hash_generated_field = "8DD93EADADBCCBE26625A903591CE508")

    public static final int MEDIA_RECORDER_TRACK_INTER_CHUNK_TIME_MS    = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.396 -0400", hash_original_field = "29245CE0C6D21A5640254F26EF98A66B", hash_generated_field = "D5496C27C5DE15FBD32DE93EEB4CE21B")

    public static final int MEDIA_RECORDER_TRACK_INFO_INITIAL_DELAY_MS  = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.397 -0400", hash_original_field = "D6AC43B652FC6777DF8D10EBB2863A1A", hash_generated_field = "C85D8AED28AD002D83E2D1124AA8BA79")

    public static final int MEDIA_RECORDER_TRACK_INFO_START_OFFSET_MS   = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.397 -0400", hash_original_field = "FE330892ABD1B9D666A9A67C61895343", hash_generated_field = "F7AB76A0D807EEF4276DAF5A09D4850B")

    public static final int MEDIA_RECORDER_TRACK_INFO_DATA_KBYTES       = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.397 -0400", hash_original_field = "96E14D7C1794CDA0B81D37E2550A781E", hash_generated_field = "DB7CDEC5A013B6508139A4976174D84E")

    public static final int MEDIA_RECORDER_TRACK_INFO_LIST_END          = 2000;
}

