package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;

import droidsafe.helpers.DSUtils;

public class CamcorderProfile {

    /**
     * Returns the camcorder profile for the first back-facing camera on the
     * device at the given quality level. If the device has no back-facing
     * camera, this returns null.
     * @param quality the target quality level for the camcorder profile
     * @see #get(int, int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.192 -0500", hash_original_method = "5E5331AEC013D39A506E19EAE2F37AD8", hash_generated_method = "579756CAB675A5F5EA6467434B34CB80")
    
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

    /**
     * Returns the camcorder profile for the given camera at the given
     * quality level.
     *
     * Quality levels QUALITY_LOW, QUALITY_HIGH are guaranteed to be supported, while
     * other levels may or may not be supported. The supported levels can be checked using
     * {@link #hasProfile(int, int)}.
     * QUALITY_LOW refers to the lowest quality available, while QUALITY_HIGH refers to
     * the highest quality available.
     * QUALITY_LOW/QUALITY_HIGH have to match one of qcif, cif, 480p, 720p, or 1080p.
     * E.g. if the device supports 480p, 720p, and 1080p, then low is 480p and high is
     * 1080p.
     *
     * The same is true for time lapse quality levels, i.e. QUALITY_TIME_LAPSE_LOW,
     * QUALITY_TIME_LAPSE_HIGH are guaranteed to be supported and have to match one of
     * qcif, cif, 480p, 720p, or 1080p.
     *
     * A camcorder recording session with higher quality level usually has higher output
     * bit rate, better video and/or audio recording quality, larger video frame
     * resolution and higher audio sampling rate, etc, than those with lower quality
     * level.
     *
     * @param cameraId the id for the camera
     * @param quality the target quality level for the camcorder profile.
     * @see #QUALITY_LOW
     * @see #QUALITY_HIGH
     * @see #QUALITY_QCIF
     * @see #QUALITY_CIF
     * @see #QUALITY_480P
     * @see #QUALITY_720P
     * @see #QUALITY_1080P
     * @see #QUALITY_TIME_LAPSE_LOW
     * @see #QUALITY_TIME_LAPSE_HIGH
     * @see #QUALITY_TIME_LAPSE_QCIF
     * @see #QUALITY_TIME_LAPSE_CIF
     * @see #QUALITY_TIME_LAPSE_480P
     * @see #QUALITY_TIME_LAPSE_720P
     * @see #QUALITY_TIME_LAPSE_1080P
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.194 -0500", hash_original_method = "6B9D019B026CD2FEEBB04778D01FE79E", hash_generated_method = "568DB9C14F83B5F9D1AE11EA1CCBCFFC")
    
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

    /**
     * Returns true if camcorder profile exists for the first back-facing
     * camera at the given quality level.
     * @param quality the target quality level for the camcorder profile
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.197 -0500", hash_original_method = "8C5F759C4AF4AEC08D993539B9258E9A", hash_generated_method = "B47E30D69F5477AD7A446E48D70712A0")
    
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

    /**
     * Returns true if camcorder profile exists for the given camera at
     * the given quality level.
     * @param cameraId the id for the camera
     * @param quality the target quality level for the camcorder profile
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.200 -0500", hash_original_method = "EF06F871596109554BFA30CB482E733E", hash_generated_method = "833CC0C79D6688AE2596AC3F7A274F9C")
    
public static boolean hasProfile(int cameraId, int quality) {
        return native_has_camcorder_profile(cameraId, quality);
    }
    
    private static final void native_init() {
    }
    
    private static final CamcorderProfile native_get_camcorder_profile(
            int cameraId, int quality) {
    	CamcorderProfile cp = new CamcorderProfile(DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT,
    			DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT, DSUtils.UNKNOWN_INT);
    	cp.addTaint(cameraId);
    	cp.addTaint(quality);
    	return cp;
    }
    
    private static final boolean native_has_camcorder_profile(
            int cameraId, int quality) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356549571 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356549571;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.113 -0500", hash_original_field = "120BD91DC6CD0AF8818AEBC6C6E92345", hash_generated_field = "C2F9FE5E90015935D35BC3387778951D")

    // in include/media/MediaProfiles.h!

    /**
     * Quality level corresponding to the lowest available resolution.
     */
    public static final int QUALITY_LOW  = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.116 -0500", hash_original_field = "A33E267EE8C054FB484A15B273245326", hash_generated_field = "C282F7CCA862DCCF06ED38CDBA91726F")

    public static final int QUALITY_HIGH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.118 -0500", hash_original_field = "BE4AFA9887540500409DBC7E41D1D193", hash_generated_field = "2F81C517543B06A7436BBAFE81DCB12D")

    public static final int QUALITY_QCIF = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.120 -0500", hash_original_field = "E041255CE25464BCD2B2D4EBE64EF48F", hash_generated_field = "E65B2743FB4B7C334B2D6C172986DE9C")

    public static final int QUALITY_CIF = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.123 -0500", hash_original_field = "B70D23C7F3AB1139F4DD7D029F95825D", hash_generated_field = "70B65D04FD6744CCA3B9D814349367BD")

    public static final int QUALITY_480P = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.125 -0500", hash_original_field = "3A2C3E015868F8DBDA9F12623B6283B4", hash_generated_field = "3020F2FD4CEAAF02CE17B7BA48EE09D7")

    public static final int QUALITY_720P = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.127 -0500", hash_original_field = "6F8DBA43AAF4AEA51B1F1456F181369C", hash_generated_field = "1BB14959838B50D7E3EDD5BD10AAC209")

    public static final int QUALITY_1080P = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.130 -0500", hash_original_field = "BCD21A7F30E0FFF84AF67B4647A5621D", hash_generated_field = "3E696A98DA32163BA1AFFD41C3D4E664")

    public static final int QUALITY_QVGA = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.133 -0500", hash_original_field = "87A9889AE19BA33127A94A827FE7F8A2", hash_generated_field = "E6382018CF78476BDF95E689FFD662D5")

    private static final int QUALITY_LIST_START = QUALITY_LOW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.135 -0500", hash_original_field = "482DD07013FE8B59A8E67376123DB4FA", hash_generated_field = "308DD9EEE578877378D4A208E58D8792")

    private static final int QUALITY_LIST_END = QUALITY_QVGA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.138 -0500", hash_original_field = "0A06D40835134AC3E61F40DCD2572882", hash_generated_field = "2A8FD87FA35850736A26B280B2656367")

    public static final int QUALITY_TIME_LAPSE_LOW  = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.141 -0500", hash_original_field = "E7F85CA55F61B244C6AAF8C02614B5D9", hash_generated_field = "64F34967F5C0F56E652ED501651C526A")

    public static final int QUALITY_TIME_LAPSE_HIGH = 1001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.144 -0500", hash_original_field = "260E060D89A4813B800CA42CE5D4F1FA", hash_generated_field = "AF341E8C073BB268863F41DE195C8F1B")

    public static final int QUALITY_TIME_LAPSE_QCIF = 1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.146 -0500", hash_original_field = "4C5AEF232C57CCE55185FD6512A6C5BE", hash_generated_field = "DB6CBD97393DE99A932574CCFD00E679")

    public static final int QUALITY_TIME_LAPSE_CIF = 1003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.148 -0500", hash_original_field = "22727B02FA4335C010C880F8E1826625", hash_generated_field = "D4A500D18F4F5D8CEF9E17DF7CF3AA57")

    public static final int QUALITY_TIME_LAPSE_480P = 1004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.151 -0500", hash_original_field = "1E9180A0435980297E1C5551F656194F", hash_generated_field = "429CF3E22A118CC82093367DA116C7B3")

    public static final int QUALITY_TIME_LAPSE_720P = 1005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.153 -0500", hash_original_field = "25F92F18515B6AA2E565A4D29D18B104", hash_generated_field = "494890F709C120D438A02B4C45C87951")

    public static final int QUALITY_TIME_LAPSE_1080P = 1006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.156 -0500", hash_original_field = "2D412D96671B56AAFB85C27A963EB866", hash_generated_field = "3066CE4BF3D4DC140897EBD7A74CACFD")

    public static final int QUALITY_TIME_LAPSE_QVGA = 1007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.159 -0500", hash_original_field = "44AA97940A57AB4CA075E6FE3C23B6DC", hash_generated_field = "EC7E143969E7AC44E33DBBC1A714E13F")

    private static final int QUALITY_TIME_LAPSE_LIST_START = QUALITY_TIME_LAPSE_LOW;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.161 -0500", hash_original_field = "9A3E6B3A9D8F55619DE613966FE66A03", hash_generated_field = "B650A06A2EDB378E5BFBA92E5200C0CB")

    private static final int QUALITY_TIME_LAPSE_LIST_END = QUALITY_TIME_LAPSE_QVGA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.163 -0500", hash_original_field = "948523FC6472C94FEADCB46CDAA0D368", hash_generated_field = "03D68F198241F87D194EF4F749A352FA")

    public int duration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.165 -0500", hash_original_field = "C31C310C0498499B5F6149C953E931B7", hash_generated_field = "43C217A0108E75A6C1BC11D1267B3409")

    public int quality;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.168 -0500", hash_original_field = "F4C78D395970A0E89110826A2E649D14", hash_generated_field = "50EB95915C23FA604671A7C923B5D113")

    public int fileFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.170 -0500", hash_original_field = "FEA36B35C19A4307F46D7E6E40370F6E", hash_generated_field = "907FD8B91D0EFFCA949AF43BEABCFE44")

    public int videoCodec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.172 -0500", hash_original_field = "583E0709E76865E38349602BCCDC3E67", hash_generated_field = "E29F4332AE6A815CAEAF82A530F86247")

    public int videoBitRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.174 -0500", hash_original_field = "9773C1D78FB2E32FF668C5D9B9FE67DA", hash_generated_field = "D0D9519E6A39F97FE425255F4A0CD7CC")

    public int videoFrameRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.177 -0500", hash_original_field = "718DDEF4E7DC42E7F212A7B9825DAB7F", hash_generated_field = "9330438547DA2E3CF0446C40C19C7809")

    public int videoFrameWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.180 -0500", hash_original_field = "1C8580D39566CD5869C58F491658448E", hash_generated_field = "A2CC7AD21C2940CE73D05602E9FB6C90")

    public int videoFrameHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.182 -0500", hash_original_field = "0414E517B9608B5E7A97707F08B6E668", hash_generated_field = "BE0B3F8DAE9FC29E0A378FCCC539766C")

    public int audioCodec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.185 -0500", hash_original_field = "C0D6CE1498AA00FF48674414A978F7A2", hash_generated_field = "7F25A1D50B22B23DF73815AF5B11042C")

    public int audioBitRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.187 -0500", hash_original_field = "1F27750991EA589BCA14E2DAC9396660", hash_generated_field = "6B4B7CCEC34BFF27747EBFA853DD3F42")

    public int audioSampleRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.189 -0500", hash_original_field = "DCAB05BA480DEAA6CD04D5A351BB46F0", hash_generated_field = "63A76D9C17F743263C2E7B8A7DCD0FB5")

    public int audioChannels;

    // Private constructor called by JNI
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:34.203 -0500", hash_original_method = "90038C05C514B802B5EF0BEF919C1051", hash_generated_method = "EB83460A361121A6ED6780C735F2461B")
    
private CamcorderProfile(int duration,
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
    }
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
}

