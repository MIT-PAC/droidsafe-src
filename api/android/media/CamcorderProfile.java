package android.media;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;




import droidsafe.helpers.DSUtils;

public class CamcorderProfile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.092 -0400", hash_original_field = "B85EC314BF443B797EF8A66B3B03F8A4", hash_generated_field = "03D68F198241F87D194EF4F749A352FA")

    public int duration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.092 -0400", hash_original_field = "D66636B253CB346DBB6240E30DEF3618", hash_generated_field = "43C217A0108E75A6C1BC11D1267B3409")

    public int quality;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.092 -0400", hash_original_field = "B55C6F03C6BC3880AC5C60D34CC0F92D", hash_generated_field = "50EB95915C23FA604671A7C923B5D113")

    public int fileFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.092 -0400", hash_original_field = "83F750DAD796991600637176C1082775", hash_generated_field = "907FD8B91D0EFFCA949AF43BEABCFE44")

    public int videoCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "C229F7916BC12B8A053A7141EC80A03F", hash_generated_field = "E29F4332AE6A815CAEAF82A530F86247")

    public int videoBitRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "4A0AA6EFFF8A4FB018F6C69F6F4F9327", hash_generated_field = "D0D9519E6A39F97FE425255F4A0CD7CC")

    public int videoFrameRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "0244D8903B8C1C47592543663277176A", hash_generated_field = "9330438547DA2E3CF0446C40C19C7809")

    public int videoFrameWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "6B4F0E9398A29ECBC27A8DD4DED00D5C", hash_generated_field = "A2CC7AD21C2940CE73D05602E9FB6C90")

    public int videoFrameHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "9CFDA60DC2D74795DCAF174712CE751C", hash_generated_field = "BE0B3F8DAE9FC29E0A378FCCC539766C")

    public int audioCodec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "882CE717EF1059CD0DC593A986028CDD", hash_generated_field = "7F25A1D50B22B23DF73815AF5B11042C")

    public int audioBitRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "4CA9B834D4F5679E578960F37C34C716", hash_generated_field = "6B4B7CCEC34BFF27747EBFA853DD3F42")

    public int audioSampleRate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.093 -0400", hash_original_field = "37EAD040A8BF8E2E80245A38689B7BF1", hash_generated_field = "63A76D9C17F743263C2E7B8A7DCD0FB5")

    public int audioChannels;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.094 -0400", hash_original_method = "90038C05C514B802B5EF0BEF919C1051", hash_generated_method = "C3818218D2A2A98B65BF2018248FE056")
    private  CamcorderProfile(int duration,
                             int quality,
                             int fileFormat,
                             int videoCodec,
                             int videoBitRate,
                             int videoFrameRate,
                             int videoWidth,
                             int videoHeight,
                             int audioCodec,
                             int audioBitRate,
                             int audioSampleRate,
                             int audioChannels) {
        this.duration         = duration;
        this.quality          = quality;
        this.fileFormat       = fileFormat;
        this.videoCodec       = videoCodec;
        this.videoBitRate     = videoBitRate;
        this.videoFrameRate   = videoFrameRate;
        this.videoFrameWidth  = videoWidth;
        this.videoFrameHeight = videoHeight;
        this.audioCodec       = audioCodec;
        this.audioBitRate     = audioBitRate;
        this.audioSampleRate  = audioSampleRate;
        this.audioChannels    = audioChannels;
        // ---------- Original Method ----------
        //this.duration         = duration;
        //this.quality          = quality;
        //this.fileFormat       = fileFormat;
        //this.videoCodec       = videoCodec;
        //this.videoBitRate     = videoBitRate;
        //this.videoFrameRate   = videoFrameRate;
        //this.videoFrameWidth  = videoWidth;
        //this.videoFrameHeight = videoHeight;
        //this.audioCodec       = audioCodec;
        //this.audioBitRate     = audioBitRate;
        //this.audioSampleRate  = audioSampleRate;
        //this.audioChannels    = audioChannels;
    }

    
    public static CamcorderProfile get(int quality) {
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
                return get(i, quality);
            }
        }
        return null;
    }

    
    public static CamcorderProfile get(int cameraId, int quality) {
        if (!((quality >= QUALITY_LIST_START &&
               quality <= QUALITY_LIST_END) ||
              (quality >= QUALITY_TIME_LAPSE_LIST_START &&
               quality <= QUALITY_TIME_LAPSE_LIST_END))) {
            String errMessage = "Unsupported quality level: " + quality;
            throw new IllegalArgumentException(errMessage);
        }
        return native_get_camcorder_profile(cameraId, quality);
    }

    
    public static boolean hasProfile(int quality) {
        int numberOfCameras = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
                return hasProfile(i, quality);
            }
        }
        return false;
    }

    
    public static boolean hasProfile(int cameraId, int quality) {
        return native_has_camcorder_profile(cameraId, quality);
    }

    
    @DSModeled(DSC.SAFE)
    private static final void native_init() {
    }

    
    @DSModeled(DSC.SAFE)
    private static final CamcorderProfile native_get_camcorder_profile(
            int cameraId, int quality) {
    	CamcorderProfile cp = new CamcorderProfile(DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT);
    	cp.addTaint(cameraId);
    	cp.addTaint(quality);
    	return cp;
    }

    
    @DSModeled(DSC.SAFE)
    private static final boolean native_has_camcorder_profile(
            int cameraId, int quality) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356549571 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356549571;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.095 -0400", hash_original_field = "711782877747A95BF14094AE92209830", hash_generated_field = "1212862E51E04EFAFE045506CA7F33BF")

    public static final int QUALITY_LOW  = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "F0C8AE55044BA230F0631C8A38D6FB7A", hash_generated_field = "C282F7CCA862DCCF06ED38CDBA91726F")

    public static final int QUALITY_HIGH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "DE616C8CC8661995E0604DB14AF754B0", hash_generated_field = "2F81C517543B06A7436BBAFE81DCB12D")

    public static final int QUALITY_QCIF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "B7A7707B578A0421779CDD4D5E15A821", hash_generated_field = "E65B2743FB4B7C334B2D6C172986DE9C")

    public static final int QUALITY_CIF = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "B8CA70F1DAF3E2A4354645F325612954", hash_generated_field = "70B65D04FD6744CCA3B9D814349367BD")

    public static final int QUALITY_480P = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "055F8ABE9A292F103E7FAF0BF1FA1352", hash_generated_field = "3020F2FD4CEAAF02CE17B7BA48EE09D7")

    public static final int QUALITY_720P = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "A731296AA056AB9FBCDDB9F2AA466745", hash_generated_field = "1BB14959838B50D7E3EDD5BD10AAC209")

    public static final int QUALITY_1080P = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "50C9AF39489E5DBA4F97351DA1BF5CA7", hash_generated_field = "3E696A98DA32163BA1AFFD41C3D4E664")

    public static final int QUALITY_QVGA = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "D4FE5900A110BC0EC0D16D994CC1980A", hash_generated_field = "E6382018CF78476BDF95E689FFD662D5")

    private static final int QUALITY_LIST_START = QUALITY_LOW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "73A082E35750847CD6D07D17BE096741", hash_generated_field = "308DD9EEE578877378D4A208E58D8792")

    private static final int QUALITY_LIST_END = QUALITY_QVGA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "F9ED1495E4E6FA1696F603E2BA9449A4", hash_generated_field = "2A8FD87FA35850736A26B280B2656367")

    public static final int QUALITY_TIME_LAPSE_LOW  = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "8D5088284DE7056D74B8AC7028D9B8AF", hash_generated_field = "64F34967F5C0F56E652ED501651C526A")

    public static final int QUALITY_TIME_LAPSE_HIGH = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "B24F4AB61AC25C1EDA85DEC08A222CB6", hash_generated_field = "AF341E8C073BB268863F41DE195C8F1B")

    public static final int QUALITY_TIME_LAPSE_QCIF = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "2958AF030249A07F62C2851F4C350909", hash_generated_field = "DB6CBD97393DE99A932574CCFD00E679")

    public static final int QUALITY_TIME_LAPSE_CIF = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.096 -0400", hash_original_field = "6F11638F094C634C583B6FC205798EF4", hash_generated_field = "D4A500D18F4F5D8CEF9E17DF7CF3AA57")

    public static final int QUALITY_TIME_LAPSE_480P = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.097 -0400", hash_original_field = "851ED94C675A485FF7B6AD4FE37BB3A0", hash_generated_field = "429CF3E22A118CC82093367DA116C7B3")

    public static final int QUALITY_TIME_LAPSE_720P = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.097 -0400", hash_original_field = "A77A0B463AA0084E814548AC884167F1", hash_generated_field = "494890F709C120D438A02B4C45C87951")

    public static final int QUALITY_TIME_LAPSE_1080P = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.097 -0400", hash_original_field = "0DEFC118835C0C067F8C9096561341EA", hash_generated_field = "3066CE4BF3D4DC140897EBD7A74CACFD")

    public static final int QUALITY_TIME_LAPSE_QVGA = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.097 -0400", hash_original_field = "6FA8E75149A3DFD25310C5766DDB8D2D", hash_generated_field = "EC7E143969E7AC44E33DBBC1A714E13F")

    private static final int QUALITY_TIME_LAPSE_LIST_START = QUALITY_TIME_LAPSE_LOW;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.097 -0400", hash_original_field = "A67587D70649D435EF5E95BC6D337F41", hash_generated_field = "B650A06A2EDB378E5BFBA92E5200C0CB")

    private static final int QUALITY_TIME_LAPSE_LIST_END = QUALITY_TIME_LAPSE_QVGA;
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
}

