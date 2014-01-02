package android.hardware;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;




import droidsafe.helpers.DSUtils;

public class Camera {

    
    @DSModeled(DSC.SAFE)
    public static int getNumberOfCameras() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962180813 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962180813;
    }

    
    @DSModeled(DSC.SAFE)
    public static void getCameraInfo(int cameraId, CameraInfo cameraInfo) {
    }

    /**
     * Creates a new Camera object to access a particular hardware camera.
     *
     * <p>You must call {@link #release()} when you are done using the camera,
     * otherwise it will remain locked and be unavailable to other applications.
     *
     * <p>Your application should only have one Camera object active at a time
     * for a particular hardware camera.
     *
     * <p>Callbacks from other methods are delivered to the event loop of the
     * thread which called open().  If this thread has no event loop, then
     * callbacks are delivered to the main application event loop.  If there
     * is no main application event loop, callbacks are not delivered.
     *
     * <p class="caution"><b>Caution:</b> On some devices, this method may
     * take a long time to complete.  It is best to call this method from a
     * worker thread (possibly using {@link android.os.AsyncTask}) to avoid
     * blocking the main application UI thread.
     *
     * @param cameraId the hardware camera to access, between 0 and
     *     {@link #getNumberOfCameras()}-1.
     * @return a new Camera object, connected, locked and ready for use.
     * @throws RuntimeException if connection to the camera service fails (for
     *     example, if the camera is in use by another process or device policy
     *     manager has disabled the camera).
     * @see android.app.admin.DevicePolicyManager#getCameraDisabled(android.content.ComponentName)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.948 -0500", hash_original_method = "2A0CFD4121D3240A1038F27609A15A50", hash_generated_method = "5D6C36992E7408DB78D61CD6B4A1E83C")
    
public static Camera open(int cameraId) {
        return new Camera(cameraId);
    }

    /**
     * Creates a new Camera object to access the first back-facing camera on the
     * device. If the device does not have a back-facing camera, this returns
     * null.
     * @see #open(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.950 -0500", hash_original_method = "63363EF59CBDC715469D9E4641621AAD", hash_generated_method = "C573B0DB7C682FB2FA5CA94E0989A330")
    
public static Camera open() {
        int numberOfCameras = getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
                return new Camera(i);
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.082 -0500", hash_original_method = "1EA1301E64E0C8CFC2BB26397453FA76", hash_generated_method = "2BD54FA446C220D053A015A132669A6C")
    
private static void postEventFromNative(Object camera_ref,
                                            int what, int arg1, int arg2, Object obj)
    {
        Camera c = (Camera)((WeakReference)camera_ref).get();
        if (c == null)
            return;

        if (c.mEventHandler != null) {
            Message m = c.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            c.mEventHandler.sendMessage(m);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.828 -0500", hash_original_field = "F1A9E7D0FC38D56E7224D2CAEE212352", hash_generated_field = "02E9F8D8947522EA0B1D0F936D5F51D9")

    private static final String TAG = "Camera";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.832 -0500", hash_original_field = "E1D922E17229AF642A628DA6E243ED11", hash_generated_field = "864C40349C3F6ED7968BE5037B8A58BE")

    private static final int CAMERA_MSG_ERROR            = 0x001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.834 -0500", hash_original_field = "2E54CAF4B69119472F9434B1C79B7201", hash_generated_field = "A0D3044C862F492CABD037557C4356E5")

    private static final int CAMERA_MSG_SHUTTER          = 0x002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.837 -0500", hash_original_field = "0C2D1143A06CB189DB45C2CDBE37CC4F", hash_generated_field = "1CC87C7E513C55AFEA40D6B58223F049")

    private static final int CAMERA_MSG_FOCUS            = 0x004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.840 -0500", hash_original_field = "FD82CA68A71D0679DFC10CFC9FD9A380", hash_generated_field = "3AC9227541ECA8B6C4F7A524FF51963D")

    private static final int CAMERA_MSG_ZOOM             = 0x008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.843 -0500", hash_original_field = "8CA2BE762D03816B9B6D22BFA8783299", hash_generated_field = "DF747366CAC9DC8C3F1B75EA97E0F364")

    private static final int CAMERA_MSG_PREVIEW_FRAME    = 0x010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.845 -0500", hash_original_field = "5D204B4FE34FCCDF709BB6DCCC9455FB", hash_generated_field = "E39F19091102976AE938C92513376E25")

    private static final int CAMERA_MSG_VIDEO_FRAME      = 0x020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.848 -0500", hash_original_field = "D6C86F0440309487EF33D2EC701BC52C", hash_generated_field = "567B1B810B0DCB5D3713BEB9AD8D7EA2")

    private static final int CAMERA_MSG_POSTVIEW_FRAME   = 0x040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.850 -0500", hash_original_field = "12B0B617FFC82ED5DF67452D06D20255", hash_generated_field = "5CD9DDD605A4024A3E951CDC20E43AEF")

    private static final int CAMERA_MSG_RAW_IMAGE        = 0x080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.853 -0500", hash_original_field = "AA2860279BBE619CEC002CFE4E9F048E", hash_generated_field = "0463751886A103B9611A3B38C0279191")

    private static final int CAMERA_MSG_COMPRESSED_IMAGE = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.855 -0500", hash_original_field = "8BBF48A6FBDC4644ABF3D2BF95EB0EB4", hash_generated_field = "A0783EFE4CC45CAC229036A3E7DFD838")

    private static final int CAMERA_MSG_RAW_IMAGE_NOTIFY = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.858 -0500", hash_original_field = "7EA197C64F1671A66D6DA64857279C85", hash_generated_field = "307FB97583A9348BD1160DF5FBAED9A9")

    private static final int CAMERA_MSG_PREVIEW_METADATA = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.861 -0500", hash_original_field = "EC7FF4E0491315309031D29C790E0D3E", hash_generated_field = "8C72DF6F017F0CE4BE46C676039FB751")

    private static final int CAMERA_MSG_ALL_MSGS         = 0x4FF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.902 -0500", hash_original_field = "18D6CF962FA635B6AC4C031A04A68C32", hash_generated_field = "D4E4CA13249A4EAD7580C42B69878FB8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.908 -0500", hash_original_field = "FFACE53160266D01CA7CFFEBB6C9AAC0", hash_generated_field = "DEE638FC175DD320F91C4207F3E75F9D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.912 -0500", hash_original_field = "6A63BEFD1ACB2B3115FD465142A67EA7", hash_generated_field = "78E81A63FAC2D79C891F3E2F7E1BF572")

    private static final int CAMERA_FACE_DETECTION_HW = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.917 -0500", hash_original_field = "DAC6124595DB217F256E532BEB37EA8F", hash_generated_field = "71E736DACBC5B540CA91B239F0B06ED0")

    private static final int CAMERA_FACE_DETECTION_SW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.209 -0500", hash_original_field = "69C8D21B6C34F6900BF85F80D3EF43F5", hash_generated_field = "83FCA880D50D00A4444F4E4B8534B09E")


    /**
     * Unspecified camera error.
     * @see Camera.ErrorCallback
     */
    public static final int CAMERA_ERROR_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.215 -0500", hash_original_field = "76E382B1807F9A38AB001657DC56636E", hash_generated_field = "37D8A15D38047CBC9CADB52FD4CD0C23")

    public static final int CAMERA_ERROR_SERVER_DIED = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.864 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")


    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.866 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.869 -0500", hash_original_field = "064A9ACB23DE98E64A954F8F21491B70", hash_generated_field = "D009E04C803F5D76BAB1D3969A4463B9")

    private ShutterCallback mShutterCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.871 -0500", hash_original_field = "76466429B31A33F26EEB4C803FD95843", hash_generated_field = "19A070C045E003058CB192AE3163D351")

    private PictureCallback mRawImageCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.873 -0500", hash_original_field = "8FB087C9E3E8A2E4AA2CFB07434C5CF3", hash_generated_field = "1BA267B982566E41875431F7773841F4")

    private PictureCallback mJpegCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.876 -0500", hash_original_field = "0A7E7290F5A3741C160DBA8470E40429", hash_generated_field = "778F38A24844833E46C1979570DC1E50")

    private PreviewCallback mPreviewCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.878 -0500", hash_original_field = "2CDA99D860D7064F8A3F9EF082F66385", hash_generated_field = "ECFD4AA8B611C615D3B911048EAEB57B")

    private PictureCallback mPostviewCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.881 -0500", hash_original_field = "C0E0189A32E8F239EC220A3C678940A1", hash_generated_field = "A4A4C6811EE167B308393226F4E8B402")

    private AutoFocusCallback mAutoFocusCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.883 -0500", hash_original_field = "5C03F80DDC72A20FC03485D3A3BD49DD", hash_generated_field = "6526D6B6F8D2DB99A1A016F005A8C367")

    private OnZoomChangeListener mZoomListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.885 -0500", hash_original_field = "9BAF640081155E4C29E6DD3E29ED4923", hash_generated_field = "2E6A5285613B44B8FED63E54A4AEE629")

    private FaceDetectionListener mFaceListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.888 -0500", hash_original_field = "9675E0D45065C18F07BE6D8299914033", hash_generated_field = "C0DACDDFAA2BE6B21362B18164C095DF")

    private ErrorCallback mErrorCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.892 -0500", hash_original_field = "BEC82D6FC788818DE0308F568563DEFD", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

    private boolean mOneShot;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.896 -0500", hash_original_field = "1C965CD3110194B24D1520A31C27710F", hash_generated_field = "56579DD297763A4F71BB0065F0275C33")

    private boolean mWithBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.899 -0500", hash_original_field = "2F8CE99C84B45DCDB770016A050F1017", hash_generated_field = "520274A32C7AFB94A6468A258B55BD75")

    private boolean mFaceDetectionRunning = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.953 -0500", hash_original_method = "49A6C7700AD76B9B3871368B13D8BEFB", hash_generated_method = "49A6C7700AD76B9B3871368B13D8BEFB")
    
Camera(int cameraId) {
        mShutterCallback = null;
        mRawImageCallback = null;
        mJpegCallback = null;
        mPreviewCallback = null;
        mPostviewCallback = null;
        mZoomListener = null;

        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            mEventHandler = null;
        }

        native_setup(new WeakReference<Camera>(this), cameraId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.956 -0500", hash_original_method = "52F53B59AD091F99DC7C4D49031A27E5", hash_generated_method = "9A6AA3EE3AA1630FAE214B52E6DCE99D")
    
protected void finalize() {
        release();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.961 -0500", hash_original_method = "5EC3DC8FB8D66F2C808C7799A0BBD6C8", hash_generated_method = "1BC48BC576F8F6BA036FE8D3ECCCF945")
    
    private final void native_setup(Object camera_this, int cameraId){
    	//Formerly a native method
    	addTaint(camera_this.getTaint());
    	addTaint(cameraId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.965 -0500", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
    
    private final void native_release(){
    	//Formerly a native method
    }



    /**
     * Disconnects and releases the Camera object resources.
     *
     * <p>You must call this as soon as you're done with the Camera object.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.968 -0500", hash_original_method = "4B0BDA2F6C7B983609E1F519CAFAFE92", hash_generated_method = "5B0807539A32E762718C72FE86F9D29B")
    
public final void release() {
        native_release();
        mFaceDetectionRunning = false;
    }

    /**
     * Unlocks the camera to allow another process to access it.
     * Normally, the camera is locked to the process with an active Camera
     * object until {@link #release()} is called.  To allow rapid handoff
     * between processes, you can call this method to release the camera
     * temporarily for another process to use; once the other process is done
     * you can call {@link #reconnect()} to reclaim the camera.
     *
     * <p>This must be done before calling
     * {@link android.media.MediaRecorder#setCamera(Camera)}. This cannot be
     * called after recording starts.
     *
     * <p>If you are not recording video, you probably do not need this method.
     *
     * @throws RuntimeException if the camera cannot be unlocked.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.974 -0500", hash_original_method = "9CD4FD3F3067AEDE0513365636CF8BFB", hash_generated_method = "26D1FC1DF3A0AF594F23113DE877786E")
    
    public final void unlock(){
    	//Formerly a native method
    }


    /**
     * Re-locks the camera to prevent other processes from accessing it.
     * Camera objects are locked by default unless {@link #unlock()} is
     * called.  Normally {@link #reconnect()} is used instead.
     *
     * <p>Since API level 14, camera is automatically locked for applications in
     * {@link android.media.MediaRecorder#start()}. Applications can use the
     * camera (ex: zoom) after recording starts. There is no need to call this
     * after recording starts or stops.
     *
     * <p>If you are not recording video, you probably do not need this method.
     *
     * @throws RuntimeException if the camera cannot be re-locked (for
     *     example, if the camera is still in use by another process).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.980 -0500", hash_original_method = "EA3188FC5C2FE364141E1E027A72F754", hash_generated_method = "98A7F7ACE660114588EC97BF48D59BF3")
    
    public final void lock(){
    	//Formerly a native method
    }


    /**
     * Reconnects to the camera service after another process used it.
     * After {@link #unlock()} is called, another process may use the
     * camera; when the process is done, you must reconnect to the camera,
     * which will re-acquire the lock and allow you to continue using the
     * camera.
     *
     * <p>Since API level 14, camera is automatically locked for applications in
     * {@link android.media.MediaRecorder#start()}. Applications can use the
     * camera (ex: zoom) after recording starts. There is no need to call this
     * after recording starts or stops.
     *
     * <p>If you are not recording video, you probably do not need this method.
     *
     * @throws IOException if a connection cannot be re-established (for
     *     example, if the camera is still in use by another process).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.986 -0500", hash_original_method = "AE5D3A84E8844CCCAC3E25422B8D0B4B", hash_generated_method = "3BBE05FB4EB624F7E0D7F87CAE3285F4")
    
    public final void reconnect() throws IOException{
    	//Formerly a native method
    }


    /**
     * Sets the {@link Surface} to be used for live preview.
     * Either a surface or surface texture is necessary for preview, and
     * preview is necessary to take pictures.  The same surface can be re-set
     * without harm.  Setting a preview surface will un-set any preview surface
     * texture that was set via {@link #setPreviewTexture}.
     *
     * <p>The {@link SurfaceHolder} must already contain a surface when this
     * method is called.  If you are using {@link android.view.SurfaceView},
     * you will need to register a {@link SurfaceHolder.Callback} with
     * {@link SurfaceHolder#addCallback(SurfaceHolder.Callback)} and wait for
     * {@link SurfaceHolder.Callback#surfaceCreated(SurfaceHolder)} before
     * calling setPreviewDisplay() or starting preview.
     *
     * <p>This method must be called before {@link #startPreview()}.  The
     * one exception is that if the preview surface is not set (or set to null)
     * before startPreview() is called, then this method may be called once
     * with a non-null parameter to set the preview surface.  (This allows
     * camera setup and surface creation to happen in parallel, saving time.)
     * The preview surface may not otherwise change while preview is running.
     *
     * @param holder containing the Surface on which to place the preview,
     *     or null to remove the preview surface
     * @throws IOException if the method fails (for example, if the surface
     *     is unavailable or unsuitable).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.989 -0500", hash_original_method = "438AEF66D8FD926A08ECF42411561F99", hash_generated_method = "D34D61B29C27EC88E84C8C6AE22E0094")
    
public final void setPreviewDisplay(SurfaceHolder holder) throws IOException {
        if (holder != null) {
            setPreviewDisplay(holder.getSurface());
        } else {
            setPreviewDisplay((Surface)null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.997 -0500", hash_original_method = "0997F7F636D30A698007C9D53ABFEAA8", hash_generated_method = "9ABCF32B86C6BEE0917FCE8FE808440A")
    
    private final void setPreviewDisplay(Surface surface) throws IOException{
    	//Formerly a native method
    	addTaint(surface.getTaint());
    }


    /**
     * Sets the {@link SurfaceTexture} to be used for live preview.
     * Either a surface or surface texture is necessary for preview, and
     * preview is necessary to take pictures.  The same surface texture can be
     * re-set without harm.  Setting a preview surface texture will un-set any
     * preview surface that was set via {@link #setPreviewDisplay}.
     *
     * <p>This method must be called before {@link #startPreview()}.  The
     * one exception is that if the preview surface texture is not set (or set
     * to null) before startPreview() is called, then this method may be called
     * once with a non-null parameter to set the preview surface.  (This allows
     * camera setup and surface creation to happen in parallel, saving time.)
     * The preview surface texture may not otherwise change while preview is
     * running.
     *
     * <p>The timestamps provided by {@link SurfaceTexture#getTimestamp()} for a
     * SurfaceTexture set as the preview texture have an unspecified zero point,
     * and cannot be directly compared between different cameras or different
     * instances of the same camera, or across multiple runs of the same
     * program.
     *
     * @param surfaceTexture the {@link SurfaceTexture} to which the preview
     *     images are to be sent or null to remove the current preview surface
     *     texture
     * @throws IOException if the method fails (for example, if the surface
     *     texture is unavailable or unsuitable).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.003 -0500", hash_original_method = "896582DEF98D5E1EC5488A60A996492A", hash_generated_method = "7BF40E752D2445E87422C78650B47911")
    
    public final void setPreviewTexture(SurfaceTexture surfaceTexture) throws IOException{
    	//Formerly a native method
    	addTaint(surfaceTexture.getTaint());
    }


    /**
     * Starts capturing and drawing preview frames to the screen.
     * Preview will not actually start until a surface is supplied
     * with {@link #setPreviewDisplay(SurfaceHolder)} or
     * {@link #setPreviewTexture(SurfaceTexture)}.
     *
     * <p>If {@link #setPreviewCallback(Camera.PreviewCallback)},
     * {@link #setOneShotPreviewCallback(Camera.PreviewCallback)}, or
     * {@link #setPreviewCallbackWithBuffer(Camera.PreviewCallback)} were
     * called, {@link Camera.PreviewCallback#onPreviewFrame(byte[], Camera)}
     * will be called when preview data becomes available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.012 -0500", hash_original_method = "D546ACB03B4B785C233CEA5A53219FBD", hash_generated_method = "7D397AF0F12954C2802059FCACE8BAFC")
    
    public final void startPreview(){
    	//Formerly a native method
    }


    /**
     * Stops capturing and drawing preview frames to the surface, and
     * resets the camera for a future call to {@link #startPreview()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.016 -0500", hash_original_method = "AB430C8006DC0097BE399D3294C32B82", hash_generated_method = "348BD7EE6391416F69A418759AE37CE5")
    
public final void stopPreview() {
        _stopPreview();
        mFaceDetectionRunning = false;

        mShutterCallback = null;
        mRawImageCallback = null;
        mPostviewCallback = null;
        mJpegCallback = null;
        mAutoFocusCallback = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.023 -0500", hash_original_method = "5C6CC4130952C356AFFCDA8182FC7947", hash_generated_method = "B38C6BA65B9A448510F7A18546EFE817")
    
    private final void _stopPreview(){
    	//Formerly a native method
    }


    /**
     * Return current preview state.
     *
     * FIXME: Unhide before release
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.030 -0500", hash_original_method = "05AF9970C538CB01E0CE4F8451A5B5A5", hash_generated_method = "46AED2AF25E754CCD033555C21A5DBD1")
    
    public final boolean previewEnabled(){
    	//Formerly a native method
    	return getTaintBoolean();
    }


    /**
     * Installs a callback to be invoked for every preview frame in addition
     * to displaying them on the screen.  The callback will be repeatedly called
     * for as long as preview is active.  This method can be called at any time,
     * even while preview is live.  Any other preview callbacks are overridden.
     *
     * @param cb a callback object that receives a copy of each preview frame,
     *     or null to stop receiving callbacks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.036 -0500", hash_original_method = "2F9DAB75D6DAF4C7768888E00FFEEEC7", hash_generated_method = "CA84C4F6DAD03324062BD9123CDE94E5")
    
public final void setPreviewCallback(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = false;
        mWithBuffer = false;
        // Always use one-shot mode. We fake camera preview mode by
        // doing one-shot preview continuously.
        setHasPreviewCallback(cb != null, false);
    }

    /**
     * Installs a callback to be invoked for the next preview frame in addition
     * to displaying it on the screen.  After one invocation, the callback is
     * cleared. This method can be called any time, even when preview is live.
     * Any other preview callbacks are overridden.
     *
     * @param cb a callback object that receives a copy of the next preview frame,
     *     or null to stop receiving callbacks.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.041 -0500", hash_original_method = "24870DBDAFF44FBB695A42B8C4F5E47B", hash_generated_method = "238A27BA52E4944675D6A53FB91F2CF4")
    
public final void setOneShotPreviewCallback(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = true;
        mWithBuffer = false;
        setHasPreviewCallback(cb != null, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.048 -0500", hash_original_method = "F92B1FC9B77C310C88F7762A3FF0D1F1", hash_generated_method = "7BED76AF1420A84DB7166263B583B1B9")
    
    private final void setHasPreviewCallback(boolean installed, boolean manualBuffer){
    	//Formerly a native method
    	addTaint(installed);
    	addTaint(manualBuffer);
    }


    /**
     * Installs a callback to be invoked for every preview frame, using buffers
     * supplied with {@link #addCallbackBuffer(byte[])}, in addition to
     * displaying them on the screen.  The callback will be repeatedly called
     * for as long as preview is active and buffers are available.
     * Any other preview callbacks are overridden.
     *
     * <p>The purpose of this method is to improve preview efficiency and frame
     * rate by allowing preview frame memory reuse.  You must call
     * {@link #addCallbackBuffer(byte[])} at some point -- before or after
     * calling this method -- or no callbacks will received.
     *
     * The buffer queue will be cleared if this method is called with a null
     * callback, {@link #setPreviewCallback(Camera.PreviewCallback)} is called,
     * or {@link #setOneShotPreviewCallback(Camera.PreviewCallback)} is called.
     *
     * @param cb a callback object that receives a copy of the preview frame,
     *     or null to stop receiving callbacks and clear the buffer queue.
     * @see #addCallbackBuffer(byte[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.052 -0500", hash_original_method = "D6843334713D07AAF210EACBD6CFBFF4", hash_generated_method = "0F2A86A0477236DFAB416425D80EA147")
    
public final void setPreviewCallbackWithBuffer(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = false;
        mWithBuffer = true;
        setHasPreviewCallback(cb != null, true);
    }

    /**
     * Adds a pre-allocated buffer to the preview callback buffer queue.
     * Applications can add one or more buffers to the queue. When a preview
     * frame arrives and there is still at least one available buffer, the
     * buffer will be used and removed from the queue. Then preview callback is
     * invoked with the buffer. If a frame arrives and there is no buffer left,
     * the frame is discarded. Applications should add buffers back when they
     * finish processing the data in them.
     *
     * <p>The size of the buffer is determined by multiplying the preview
     * image width, height, and bytes per pixel. The width and height can be
     * read from {@link Camera.Parameters#getPreviewSize()}. Bytes per pixel
     * can be computed from
     * {@link android.graphics.ImageFormat#getBitsPerPixel(int)} / 8,
     * using the image format from {@link Camera.Parameters#getPreviewFormat()}.
     *
     * <p>This method is only necessary when
     * {@link #setPreviewCallbackWithBuffer(PreviewCallback)} is used. When
     * {@link #setPreviewCallback(PreviewCallback)} or
     * {@link #setOneShotPreviewCallback(PreviewCallback)} are used, buffers
     * are automatically allocated. When a supplied buffer is too small to
     * hold the preview frame data, preview callback will return null and
     * the buffer will be removed from the buffer queue.
     *
     * @param callbackBuffer the buffer to add to the queue.
     *     The size should be width * height * bits_per_pixel / 8.
     * @see #setPreviewCallbackWithBuffer(PreviewCallback)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.055 -0500", hash_original_method = "A09D93E5FEF9D0285B72182191BE3D88", hash_generated_method = "8A89D1F13B389F0BA38B6B2490761D37")
    
public final void addCallbackBuffer(byte[] callbackBuffer)
    {
        _addCallbackBuffer(callbackBuffer, CAMERA_MSG_PREVIEW_FRAME);
    }

    /**
     * Adds a pre-allocated buffer to the raw image callback buffer queue.
     * Applications can add one or more buffers to the queue. When a raw image
     * frame arrives and there is still at least one available buffer, the
     * buffer will be used to hold the raw image data and removed from the
     * queue. Then raw image callback is invoked with the buffer. If a raw
     * image frame arrives but there is no buffer left, the frame is
     * discarded. Applications should add buffers back when they finish
     * processing the data in them by calling this method again in order
     * to avoid running out of raw image callback buffers.
     *
     * <p>The size of the buffer is determined by multiplying the raw image
     * width, height, and bytes per pixel. The width and height can be
     * read from {@link Camera.Parameters#getPictureSize()}. Bytes per pixel
     * can be computed from
     * {@link android.graphics.ImageFormat#getBitsPerPixel(int)} / 8,
     * using the image format from {@link Camera.Parameters#getPreviewFormat()}.
     *
     * <p>This method is only necessary when the PictureCallbck for raw image
     * is used while calling {@link #takePicture(Camera.ShutterCallback,
     * Camera.PictureCallback, Camera.PictureCallback, Camera.PictureCallback)}.
     *
     * <p>Please note that by calling this method, the mode for
     * application-managed callback buffers is triggered. If this method has
     * never been called, null will be returned by the raw image callback since
     * there is no image callback buffer available. Furthermore, When a supplied
     * buffer is too small to hold the raw image data, raw image callback will
     * return null and the buffer will be removed from the buffer queue.
     *
     * @param callbackBuffer the buffer to add to the raw image callback buffer
     *     queue. The size should be width * height * (bits per pixel) / 8. An
     *     null callbackBuffer will be ignored and won't be added to the queue.
     *
     * @see #takePicture(Camera.ShutterCallback,
     * Camera.PictureCallback, Camera.PictureCallback, Camera.PictureCallback)}.
     *
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.058 -0500", hash_original_method = "DF16904A59ADE37251DD7B5F971D59DA", hash_generated_method = "62C44C17F6A34FE31F55C4E5C0854352")
    
public final void addRawImageCallbackBuffer(byte[] callbackBuffer)
    {
        addCallbackBuffer(callbackBuffer, CAMERA_MSG_RAW_IMAGE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.061 -0500", hash_original_method = "391D3A52EC92D78C4E563BC291F66937", hash_generated_method = "3E04A41784B725D24517D1713EA0CD3A")
    
private final void addCallbackBuffer(byte[] callbackBuffer, int msgType)
    {
        // CAMERA_MSG_VIDEO_FRAME may be allowed in the future.
        if (msgType != CAMERA_MSG_PREVIEW_FRAME &&
            msgType != CAMERA_MSG_RAW_IMAGE) {
            throw new IllegalArgumentException(
                            "Unsupported message type: " + msgType);
        }

        _addCallbackBuffer(callbackBuffer, msgType);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.065 -0500", hash_original_method = "D4768D01937D37185DEEEF1DE89AE1E9", hash_generated_method = "90371F8E7E514C28982E8F85BF34CA60")
    
    private final void _addCallbackBuffer(
                                    byte[] callbackBuffer, int msgType){
    	//Formerly a native method
    	addTaint(callbackBuffer[0]);
    	addTaint(msgType);
    }


    /**
     * Starts camera auto-focus and registers a callback function to run when
     * the camera is focused.  This method is only valid when preview is active
     * (between {@link #startPreview()} and before {@link #stopPreview()}).
     *
     * <p>Callers should check
     * {@link android.hardware.Camera.Parameters#getFocusMode()} to determine if
     * this method should be called. If the camera does not support auto-focus,
     * it is a no-op and {@link AutoFocusCallback#onAutoFocus(boolean, Camera)}
     * callback will be called immediately.
     *
     * <p>If your application should not be installed
     * on devices without auto-focus, you must declare that your application
     * uses auto-focus with the
     * <a href="{@docRoot}guide/topics/manifest/uses-feature-element.html">&lt;uses-feature></a>
     * manifest element.</p>
     *
     * <p>If the current flash mode is not
     * {@link android.hardware.Camera.Parameters#FLASH_MODE_OFF}, flash may be
     * fired during auto-focus, depending on the driver and camera hardware.<p>
     *
     * <p>Auto-exposure lock {@link android.hardware.Camera.Parameters#getAutoExposureLock()}
     * and auto-white balance locks {@link android.hardware.Camera.Parameters#getAutoWhiteBalanceLock()}
     * do not change during and after autofocus. But auto-focus routine may stop
     * auto-exposure and auto-white balance transiently during focusing.
     *
     * <p>Stopping preview with {@link #stopPreview()}, or triggering still
     * image capture with {@link #takePicture(Camera.ShutterCallback,
     * Camera.PictureCallback, Camera.PictureCallback)}, will not change the
     * the focus position. Applications must call cancelAutoFocus to reset the
     * focus.</p>
     *
     * @param cb the callback to run
     * @see #cancelAutoFocus()
     * @see android.hardware.Camera.Parameters#setAutoExposureLock(boolean)
     * @see android.hardware.Camera.Parameters#setAutoWhiteBalanceLock(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.091 -0500", hash_original_method = "0E3CC922487DC63C4A5A24CA78FD017D", hash_generated_method = "F212B5C068D6E01BFE37F56DFF4A43E1")
    
public final void autoFocus(AutoFocusCallback cb)
    {
        mAutoFocusCallback = cb;
        native_autoFocus();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.098 -0500", hash_original_method = "CBF6350AD6916ADF364820AEE02A4625", hash_generated_method = "A02A440B3407A99E3B2FF8EF3BE76B0D")
    
    private final void native_autoFocus(){
    	//Formerly a native method
    }


    
    public static class CameraInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.933 -0500", hash_original_field = "7A4C5E454B574102D35D1E7A744EAD49", hash_generated_field = "858969BC557B8C41F748B73BC5BF335A")

        public static final int CAMERA_FACING_BACK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.937 -0500", hash_original_field = "A49AA17359B267E78A7144732C2D3D61", hash_generated_field = "DA2E8C78AD23CF4E48B5EB9C8BB0C1BF")

        public static final int CAMERA_FACING_FRONT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.940 -0500", hash_original_field = "6CFD822F3B9753F94EFDC4FE4DFA7F49", hash_generated_field = "25D2EC7372795E4CF4CE9BD768162F29")

        public int facing;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:54.942 -0500", hash_original_field = "3DED072A8BFAA06C394A37F331F7C0C9", hash_generated_field = "039D4A8EAE0AA6D0501E4B6BB899CCE8")

        public int orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:13.092 -0400", hash_original_method = "53549141AB7280F9D01DADAF7B2BE301", hash_generated_method = "53549141AB7280F9D01DADAF7B2BE301")
        public CameraInfo ()
        {
            //Synthesized constructor
        }
    }


    
    private class EventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.069 -0500", hash_original_field = "14235C9A65820E9F0369D65E8689BCC5", hash_generated_field = "342D730EDD2CEF78B671539580251722")

        private Camera mCamera;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.073 -0500", hash_original_method = "34C18DB36AC676A5AD3395F8999AED0E", hash_generated_method = "B55364E664C1B6A610D1BE4641434056")
        
public EventHandler(Camera c, Looper looper) {
            super(looper);
            mCamera = c;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.076 -0500", hash_original_method = "527FC94310988CAD6A04936940B6C036", hash_generated_method = "B8B8CDA90359B11441833BAAA6F39D89")
        
@Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
            case CAMERA_MSG_SHUTTER:
                if (mShutterCallback != null) {
                    mShutterCallback.onShutter();
                }
                return;

            case CAMERA_MSG_RAW_IMAGE:
                if (mRawImageCallback != null) {
                    mRawImageCallback.onPictureTaken((byte[])msg.obj, mCamera);
                }
                return;

            case CAMERA_MSG_COMPRESSED_IMAGE:
                if (mJpegCallback != null) {
                    mJpegCallback.onPictureTaken((byte[])msg.obj, mCamera);
                }
                return;

            case CAMERA_MSG_PREVIEW_FRAME:
                if (mPreviewCallback != null) {
                    PreviewCallback cb = mPreviewCallback;
                    if (mOneShot) {
                        // Clear the callback variable before the callback
                        // in case the app calls setPreviewCallback from
                        // the callback function
                        mPreviewCallback = null;
                    } else if (!mWithBuffer) {
                        // We're faking the camera preview mode to prevent
                        // the app from being flooded with preview frames.
                        // Set to oneshot mode again.
                        setHasPreviewCallback(true, false);
                    }
                    cb.onPreviewFrame((byte[])msg.obj, mCamera);
                }
                return;

            case CAMERA_MSG_POSTVIEW_FRAME:
                if (mPostviewCallback != null) {
                    mPostviewCallback.onPictureTaken((byte[])msg.obj, mCamera);
                }
                return;

            case CAMERA_MSG_FOCUS:
                if (mAutoFocusCallback != null) {
                    mAutoFocusCallback.onAutoFocus(msg.arg1 == 0 ? false : true, mCamera);
                }
                return;

            case CAMERA_MSG_ZOOM:
                if (mZoomListener != null) {
                    mZoomListener.onZoomChange(msg.arg1, msg.arg2 != 0, mCamera);
                }
                return;

            case CAMERA_MSG_PREVIEW_METADATA:
                if (mFaceListener != null) {
                    mFaceListener.onFaceDetection((Face[])msg.obj, mCamera);
                }
                return;

            case CAMERA_MSG_ERROR :
                Log.e(TAG, "Error " + msg.arg1);
                if (mErrorCallback != null) {
                    mErrorCallback.onError(msg.arg1, mCamera);
                }
                return;

            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
        }

        
    }


    
    public static class Face {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.189 -0500", hash_original_field = "49FA87EDE6ACB8E667EAE50801575AA3", hash_generated_field = "6F2D83EE0E930D3F0DDD170A74A8B967")

        public Rect rect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.192 -0500", hash_original_field = "2A69D9BC38799AF00B54784DA5490F24", hash_generated_field = "597E48275902E31CE4704100ED960A91")

        public int score;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.195 -0500", hash_original_field = "9C60234C1B0C939B183B72F153EC56FD", hash_generated_field = "893C408272A867D7D8E53504CF16C51D")

        public int id = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.197 -0500", hash_original_field = "46D56B4CA830978DFB6649CCE6312CFE", hash_generated_field = "0DDAD1A72ADB57EB54106245C5583D87")

        public Point leftEye = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.200 -0500", hash_original_field = "81E5C36A107598DBDB5F5BCC70B49BBC", hash_generated_field = "65B1A72E8914E2C3527E23F7B661DF01")

        public Point rightEye = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.202 -0500", hash_original_field = "D683E1DD2E9B9B790E53F30B421F7D06", hash_generated_field = "5C5BC93671E3C9D8BBE06B8E52E14C9D")

        public Point mouth = null;
        /**
         * Create an empty face.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.186 -0500", hash_original_method = "AEF29885362690B7E7A5098C2C347237", hash_generated_method = "E38E5D01E4BE3229837151E9655E5BA0")
        
public Face() {
        }

        
    }


    
    public class Size {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.245 -0500", hash_original_field = "1589F848FE4FF192F7CCE1B9F9E85747", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.247 -0500", hash_original_field = "CE84F1587D182C1F0A32D7CD44443A18", hash_generated_field = "7F76BED9760D410D06D1D8D13D91425A")

        public int height;
        /**
         * Sets the dimensions for pictures.
         *
         * @param w the photo width (pixels)
         * @param h the photo height (pixels)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.237 -0500", hash_original_method = "8D5275DA61B4D745CED801D3C3D010F4", hash_generated_method = "1D67BF036811FB8505B83073D7F158D6")
        
public Size(int w, int h) {
            width = w;
            height = h;
        }
        /**
         * Compares {@code obj} to this size.
         *
         * @param obj the object to compare this size with.
         * @return {@code true} if the width and height of {@code obj} is the
         *         same as those of this size. {@code false} otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.240 -0500", hash_original_method = "C0E6580734A50AA28FE29C092058ED66", hash_generated_method = "32EB0060E2EC38CDBC32F5433D101D17")
        
@Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Size)) {
                return false;
            }
            Size s = (Size) obj;
            return width == s.width && height == s.height;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.242 -0500", hash_original_method = "B5BC5866A74569F21D19CEA2ED84BAAB", hash_generated_method = "D607F0AF6A00B331C8962E0BC00D1A6E")
        
@Override
        public int hashCode() {
            return width * 32713 + height;
        }

        
    }


    
    public static class Area {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.260 -0500", hash_original_field = "49FA87EDE6ACB8E667EAE50801575AA3", hash_generated_field = "6F2D83EE0E930D3F0DDD170A74A8B967")

        public Rect rect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.262 -0500", hash_original_field = "089E32B9D48132D4E405877F337C1166", hash_generated_field = "EB9C9E5835DB061A8FF1A7ADDB6DF6F5")

        public int weight;
        /**
         * Create an area with specified rectangle and weight.
         *
         * @param rect the bounds of the area.
         * @param weight the weight of the area.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.254 -0500", hash_original_method = "E9625E9CC5B81192600D71D662CB25CE", hash_generated_method = "40B5832F3F526A05E05E19C39FD872F2")
        
public Area(Rect rect, int weight) {
            this.rect = rect;
            this.weight = weight;
        }
        /**
         * Compares {@code obj} to this area.
         *
         * @param obj the object to compare this area with.
         * @return {@code true} if the rectangle and weight of {@code obj} is
         *         the same as those of this area. {@code false} otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.257 -0500", hash_original_method = "79D1F56CDDD7107B76CC69CE709FE4A7", hash_generated_method = "FB9029B60062E93FAB58E352D151ED36")
        
@Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Area)) {
                return false;
            }
            Area a = (Area) obj;
            if (rect == null) {
                if (a.rect != null) return false;
            } else {
                if (!rect.equals(a.rect)) return false;
            }
            return weight == a.weight;
        }

        
    }


    
    public class Parameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.268 -0500", hash_original_field = "5125477CF20E669DEC4335EC05F678CE", hash_generated_field = "D491AB03C9D5CDF50C31726C71EFC373")

        private static final String KEY_PREVIEW_SIZE = "preview-size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.271 -0500", hash_original_field = "D388BB05705BCBEC1E3F5A1032C1D39C", hash_generated_field = "DC175C134F5AABAAA6C719670C4E4180")

        private static final String KEY_PREVIEW_FORMAT = "preview-format";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.274 -0500", hash_original_field = "CFA01BB6BE3327CA4FDD76FBBC162CA0", hash_generated_field = "B219EAECDC5170DE98D35419286AECE8")

        private static final String KEY_PREVIEW_FRAME_RATE = "preview-frame-rate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.277 -0500", hash_original_field = "DE7921BB4BFAD3711BB5EB18DEE5F438", hash_generated_field = "74F3B640C7EAFF26E406B69723EA551B")

        private static final String KEY_PREVIEW_FPS_RANGE = "preview-fps-range";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.280 -0500", hash_original_field = "1D712B2F033C9D3B1EF1151FF838E7B0", hash_generated_field = "3D582F98C61ED0E162006F497463C753")

        private static final String KEY_PICTURE_SIZE = "picture-size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.283 -0500", hash_original_field = "8AC9A7FABD2887E854381A72615CDBA1", hash_generated_field = "10400A8146BFB9F72C58033CA87DE7BF")

        private static final String KEY_PICTURE_FORMAT = "picture-format";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.286 -0500", hash_original_field = "47FBE842A44DBA11F1037306C3E8B887", hash_generated_field = "50E7E755B0F420ABB26EACB8C6133164")

        private static final String KEY_JPEG_THUMBNAIL_SIZE = "jpeg-thumbnail-size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.291 -0500", hash_original_field = "67FC5967C26708A3A6D40D769D2B43FC", hash_generated_field = "667A7861D91B4D8007E90557D5A16FD2")

        private static final String KEY_JPEG_THUMBNAIL_WIDTH = "jpeg-thumbnail-width";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.296 -0500", hash_original_field = "2F5D00EA9A1BDDA5BE668CAB5439D2CD", hash_generated_field = "AC50E2B1C45E146A019611E3988C45C7")

        private static final String KEY_JPEG_THUMBNAIL_HEIGHT = "jpeg-thumbnail-height";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.301 -0500", hash_original_field = "53D49F23EECAF73E8FDD19C962BF1789", hash_generated_field = "A56671B8066E1B9614E1B6F330D6AF70")

        private static final String KEY_JPEG_THUMBNAIL_QUALITY = "jpeg-thumbnail-quality";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.306 -0500", hash_original_field = "BD64CF1BDB7627336B2046F33150347F", hash_generated_field = "82B8FC468F5234449996990D32952165")

        private static final String KEY_JPEG_QUALITY = "jpeg-quality";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.309 -0500", hash_original_field = "2DDB682C506908C811CAB7B4788D32A0", hash_generated_field = "E636E626CA26E33C3006C4B70CC58CA8")

        private static final String KEY_ROTATION = "rotation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.312 -0500", hash_original_field = "848456039E38FB2E9495FFF295560E2B", hash_generated_field = "5C909353766B94F9EC6F17E43CE5A8AC")

        private static final String KEY_GPS_LATITUDE = "gps-latitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.315 -0500", hash_original_field = "A755C398FC2346594FA5B585CA1BA82F", hash_generated_field = "F5A5C9C2DEFD10E1E3A78A8A5DFE652C")

        private static final String KEY_GPS_LONGITUDE = "gps-longitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.318 -0500", hash_original_field = "EDB424178397BE9EEA04CCBF0BFC3CED", hash_generated_field = "7CAE4FA36B21C9B4E804DC781700FD0D")

        private static final String KEY_GPS_ALTITUDE = "gps-altitude";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.321 -0500", hash_original_field = "AF0E889705AC56D6C7053F40C8D7913F", hash_generated_field = "2566DFC02723461942EF5C7FF3B29FC6")

        private static final String KEY_GPS_TIMESTAMP = "gps-timestamp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.324 -0500", hash_original_field = "8276DA49B904124BAA8BCD1F10419DF4", hash_generated_field = "AD2C634E0515AEEE5013AFD9364A99A8")

        private static final String KEY_GPS_PROCESSING_METHOD = "gps-processing-method";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.328 -0500", hash_original_field = "31EBE0B7C1A8E89A1B64ED65F0EBD427", hash_generated_field = "067DD1F44F9FD815C40A853E46520698")

        private static final String KEY_WHITE_BALANCE = "whitebalance";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.331 -0500", hash_original_field = "13206E3D099F42A0ED82E333B719CE3F", hash_generated_field = "07D3090933D2247400CB4DD90BBE2CF3")

        private static final String KEY_EFFECT = "effect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.334 -0500", hash_original_field = "F4A22C11FF5C38E3A657C689A2C0BBDC", hash_generated_field = "AC7E92C69721E943C03503B6749192D5")

        private static final String KEY_ANTIBANDING = "antibanding";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.337 -0500", hash_original_field = "CC21EBDAEB818C2910C9F04DF856C6FE", hash_generated_field = "0D608AA8C1BC8141D1A4CCCDD3D58720")

        private static final String KEY_SCENE_MODE = "scene-mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.341 -0500", hash_original_field = "CC7EBDA68750DA01E7C087A549436D26", hash_generated_field = "EF1962EE75721A9D115A77E3707CCA17")

        private static final String KEY_FLASH_MODE = "flash-mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.344 -0500", hash_original_field = "C717AE75679988F2B0A83FE0670B7B68", hash_generated_field = "F02D1C9A44CD0C790EED9C45761E49CC")

        private static final String KEY_FOCUS_MODE = "focus-mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.347 -0500", hash_original_field = "58B91EAAF1F8317C0347210AA4E24F7B", hash_generated_field = "7A02A051640E2CF5592FFE9117F2E6BB")

        private static final String KEY_FOCUS_AREAS = "focus-areas";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.350 -0500", hash_original_field = "298E18600BDC73D404FB1A0233D1CD4A", hash_generated_field = "10132BDF5E8D4637023407A7EA849BF6")

        private static final String KEY_MAX_NUM_FOCUS_AREAS = "max-num-focus-areas";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.353 -0500", hash_original_field = "8996149827D99290524A852DAB9244BE", hash_generated_field = "16AA73495A23F198A7A9AA7EF0879EA3")

        private static final String KEY_FOCAL_LENGTH = "focal-length";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.356 -0500", hash_original_field = "60636DB925F45F2D08E4A73AF2A6BDA7", hash_generated_field = "4417527EDBD6DF25AE76DCDFE5C0FB9C")

        private static final String KEY_HORIZONTAL_VIEW_ANGLE = "horizontal-view-angle";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.359 -0500", hash_original_field = "8C8E1B5A53E6E4A12ACD12B2897CDD24", hash_generated_field = "84F041A9903525A7EF539C104EA8C35A")

        private static final String KEY_VERTICAL_VIEW_ANGLE = "vertical-view-angle";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.363 -0500", hash_original_field = "223F2BAF67638A6B8B2BB729E6865FDB", hash_generated_field = "B3ED21B28AB90021D9B633B07B95EFC1")

        private static final String KEY_EXPOSURE_COMPENSATION = "exposure-compensation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.366 -0500", hash_original_field = "4554CA010D945F39D49036CB9D47769A", hash_generated_field = "24A0F50C593A59D044069D6D64EA7DCB")

        private static final String KEY_MAX_EXPOSURE_COMPENSATION = "max-exposure-compensation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.369 -0500", hash_original_field = "936EBCBF38561511DF43C6400FC09BBD", hash_generated_field = "A9D1D588ABC24E65433FF4BAFAFA7377")

        private static final String KEY_MIN_EXPOSURE_COMPENSATION = "min-exposure-compensation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.374 -0500", hash_original_field = "10651971619B69FE8E794B76B0DFBD1A", hash_generated_field = "F6BEEA8E3E18E018F158EF0671306DFB")

        private static final String KEY_EXPOSURE_COMPENSATION_STEP = "exposure-compensation-step";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.377 -0500", hash_original_field = "7A9D7381E99432938BA2FCF4D4A80278", hash_generated_field = "C0A58533450D3BD2F9F2C6A65853CD35")

        private static final String KEY_AUTO_EXPOSURE_LOCK = "auto-exposure-lock";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.382 -0500", hash_original_field = "5E2F6B65368B8BC4DC6E13527513DE3A", hash_generated_field = "9A93AF97FAA0A401A7A579992029D47F")

        private static final String KEY_AUTO_EXPOSURE_LOCK_SUPPORTED = "auto-exposure-lock-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.387 -0500", hash_original_field = "64B0D7D7A280A41AF189B81C03007B85", hash_generated_field = "5B9320952E6A4A095AD226C292EBB29C")

        private static final String KEY_AUTO_WHITEBALANCE_LOCK = "auto-whitebalance-lock";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.391 -0500", hash_original_field = "7DE5F47597D65C0B9AD7C0E8A7A524FC", hash_generated_field = "4F1DF25CACD22E806B96C006293BCE6F")

        private static final String KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED = "auto-whitebalance-lock-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.396 -0500", hash_original_field = "7E173AA5D8525A050DA7BB3888FA612B", hash_generated_field = "95F19A3DA489A3853346B571754602C2")

        private static final String KEY_METERING_AREAS = "metering-areas";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.400 -0500", hash_original_field = "508737D2FFB20DF7EECD1FBA5C2C2789", hash_generated_field = "BC95B3D1B028EF5583174317913E4F0E")

        private static final String KEY_MAX_NUM_METERING_AREAS = "max-num-metering-areas";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.405 -0500", hash_original_field = "C54670D8026EBF4D04769AAEC5BA7BA6", hash_generated_field = "1002BF2523EBE4E3169C9A5DA3A80856")

        private static final String KEY_ZOOM = "zoom";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.411 -0500", hash_original_field = "7B1C1D9217F328EE2E7873CAA325C304", hash_generated_field = "72FAE2D3486243494F915785B367AB79")

        private static final String KEY_MAX_ZOOM = "max-zoom";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.415 -0500", hash_original_field = "D798988F522EE8006132A43AA8B83446", hash_generated_field = "3DF6FFAEC9EA9E8373739C8D293BE9F3")

        private static final String KEY_ZOOM_RATIOS = "zoom-ratios";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.420 -0500", hash_original_field = "520C0910C673F143CF05D730EBABB390", hash_generated_field = "949FC2BF295832C9A84DCD3D74B75C15")

        private static final String KEY_ZOOM_SUPPORTED = "zoom-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.424 -0500", hash_original_field = "937538C77016DC2B0DAF335CE0BABBC8", hash_generated_field = "9FE4DB72B2949B29724C8D47EB13B4F6")

        private static final String KEY_SMOOTH_ZOOM_SUPPORTED = "smooth-zoom-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.427 -0500", hash_original_field = "22B72F9CE530A0C96CA1AA470EF8501D", hash_generated_field = "42E9716388BA25211007B38C61DC0132")

        private static final String KEY_FOCUS_DISTANCES = "focus-distances";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.431 -0500", hash_original_field = "2E7539A6A1C2041454A3A5968E58BC03", hash_generated_field = "D91113563BD671E8FAF937BC58E562D2")

        private static final String KEY_VIDEO_SIZE = "video-size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.436 -0500", hash_original_field = "E69EF4632C9081EFF6E7BCA00B7D6AE4", hash_generated_field = "80600862D70199F1FCCB07655A60F155")

        private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO =
                                            "preferred-preview-size-for-video";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.441 -0500", hash_original_field = "6CEF815C6CF89D555D95CB16DFA20997", hash_generated_field = "F12FDFBDBFD8E81D938A84466DD627DF")

        private static final String KEY_MAX_NUM_DETECTED_FACES_HW = "max-num-detected-faces-hw";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.446 -0500", hash_original_field = "C76C923DF24EBDBB337CBB55A8D74D56", hash_generated_field = "539D0AC241B90F91518FAB8586DE1673")

        private static final String KEY_MAX_NUM_DETECTED_FACES_SW = "max-num-detected-faces-sw";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.449 -0500", hash_original_field = "C8958BDDD5CCE1CFABA2E9CC00815D1F", hash_generated_field = "3C6B013BC256CBB0D9D78AD1E732C834")

        private static final String KEY_RECORDING_HINT = "recording-hint";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.452 -0500", hash_original_field = "B2CEF056B2A24D13B005D9BF1C6FC14E", hash_generated_field = "D8D3997018C04FDA8DECAE870EAA9F3F")

        private static final String KEY_VIDEO_SNAPSHOT_SUPPORTED = "video-snapshot-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.455 -0500", hash_original_field = "7209384D1C2047080498954B4C8B8351", hash_generated_field = "4D968037B9A0DC8DFC94EA97BE2D2EC2")

        private static final String KEY_VIDEO_STABILIZATION = "video-stabilization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.458 -0500", hash_original_field = "94F4B3337808BCC50D1601BF9929E6D1", hash_generated_field = "F97FCEBC75E2BE1DF13A56C997BB28B6")

        private static final String KEY_VIDEO_STABILIZATION_SUPPORTED = "video-stabilization-supported";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.462 -0500", hash_original_field = "358E207DD0C5485F851DC6E730766C4F", hash_generated_field = "EEF1BB2F71494B1EEDDDCC03A15370CA")

        private static final String SUPPORTED_VALUES_SUFFIX = "-values";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.465 -0500", hash_original_field = "9241CAFDFDD3A2DB1D652A142755F2E6", hash_generated_field = "4C28D6B128C36B4FC74A84DF6340DC46")


        private static final String TRUE = "true";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.468 -0500", hash_original_field = "8D8F1E6261DF9835D31AEB47FD3CE677", hash_generated_field = "C1316565886B4D13708E85372F0C7E25")

        private static final String FALSE = "false";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.470 -0500", hash_original_field = "9D7D60675D63EFC1AE24D3AC0299E405", hash_generated_field = "50B715D5181F8AD71E164A05DA246A18")

        public static final String WHITE_BALANCE_AUTO = "auto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.473 -0500", hash_original_field = "B01A3B9C4364F91A05915479B2343A03", hash_generated_field = "4C146C5C7A496C7575B4626817D4C6B5")

        public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.477 -0500", hash_original_field = "CF3C7EA0ED2D33F0F65C6DC32C125D0F", hash_generated_field = "775F94EB7534AB79944D9751B2B9B170")

        public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.481 -0500", hash_original_field = "4597CB3FF6E3502EFB8C000071FBD631", hash_generated_field = "B227D5F67DCA562CD1298A6C50102C03")

        public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.484 -0500", hash_original_field = "FB6361AC0293B2184B120DA899EE4E6C", hash_generated_field = "77803AB352A9E6323F78C1F28A2EF38D")

        public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.488 -0500", hash_original_field = "32067B20D79AF02131B62F947BB0984C", hash_generated_field = "B0F65C41CCFA93ED2F8508B5A7611B95")

        public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.491 -0500", hash_original_field = "A35AE74B753FECE867CDEB5B6270C466", hash_generated_field = "70BA2854EB9812B93557D0952D78CED8")

        public static final String WHITE_BALANCE_TWILIGHT = "twilight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.494 -0500", hash_original_field = "FBFD525DB74F16CFDBB9319FFF485F0E", hash_generated_field = "712EE0266774EA0149DD397B346D8F99")

        public static final String WHITE_BALANCE_SHADE = "shade";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.500 -0500", hash_original_field = "418F361994B5D5475E79354218A3CCA6", hash_generated_field = "1534A949E3A751B6FFED0DEADC1805F0")

        public static final String EFFECT_NONE = "none";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.504 -0500", hash_original_field = "DD5E5415B6D81278F800C4622571865D", hash_generated_field = "C1A04AE9C80EBB8083EB4AF0B0BBE630")

        public static final String EFFECT_MONO = "mono";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.507 -0500", hash_original_field = "EDD0B18E140512CE5AC97047C9BE8DA9", hash_generated_field = "24A530BA794CB5B7AF627B93F7B7B167")

        public static final String EFFECT_NEGATIVE = "negative";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.510 -0500", hash_original_field = "D589069AEBEFBA4569EFB434314B5A01", hash_generated_field = "11DD47673984636C7D173471C2E61124")

        public static final String EFFECT_SOLARIZE = "solarize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.513 -0500", hash_original_field = "AADFB087AE1FEFCC3C0CD977FBA7ADF6", hash_generated_field = "B2874F0A689E4A31970BD92237B2FCCD")

        public static final String EFFECT_SEPIA = "sepia";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.516 -0500", hash_original_field = "1313B4615CFDE5CB99F06D166DF124F7", hash_generated_field = "23312E048FAF4F448698C46B06BFCC85")

        public static final String EFFECT_POSTERIZE = "posterize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.518 -0500", hash_original_field = "550885B14DE501BE673C51E84BA2F047", hash_generated_field = "AD66305933BAA31E46015B0CD98A6050")

        public static final String EFFECT_WHITEBOARD = "whiteboard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.522 -0500", hash_original_field = "706F29FA366B20FA1AFCA3D2E6792B7D", hash_generated_field = "DD56FE7E4A011E39698ED1592661B2BC")

        public static final String EFFECT_BLACKBOARD = "blackboard";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.525 -0500", hash_original_field = "A5CA78828158344D0BE85657D9064FEA", hash_generated_field = "32142C632F158B8A8AD260EB1955D4C1")

        public static final String EFFECT_AQUA = "aqua";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.528 -0500", hash_original_field = "B3041912C70929C6F91669B024C36BF8", hash_generated_field = "991E49D017F1E0184846A36DBB6FD3E7")

        public static final String ANTIBANDING_AUTO = "auto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.531 -0500", hash_original_field = "9BB1B1040955561D01908ECD613F3C6E", hash_generated_field = "6911788C1BC58FDB61685C53964D1812")

        public static final String ANTIBANDING_50HZ = "50hz";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.533 -0500", hash_original_field = "CFBB56480FAA8D069992152397B0062C", hash_generated_field = "07BA19A2E1A4BA2C21E985EC438BC383")

        public static final String ANTIBANDING_60HZ = "60hz";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.536 -0500", hash_original_field = "A197E182A63C7A67AA8B888AD75F7ED1", hash_generated_field = "BE98B3A51772EA40ADCC5ADAD78BAAF3")

        public static final String ANTIBANDING_OFF = "off";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.539 -0500", hash_original_field = "4FF329785E8463A6EA2DE0E0D144F239", hash_generated_field = "8773B3BDF7303595CF483698D54112C2")

        /**
         * Flash will not be fired.
         */
        public static final String FLASH_MODE_OFF = "off";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.542 -0500", hash_original_field = "0D5BAEEA9AA90C04A55C46EB4FCD7300", hash_generated_field = "A3927DA7E1A34824581D9C20F125D6DF")

        public static final String FLASH_MODE_AUTO = "auto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.545 -0500", hash_original_field = "87707B2B7AB7769A6F35386FC577F28D", hash_generated_field = "DBC42260A1C88C4F752747A7D8214BE6")

        public static final String FLASH_MODE_ON = "on";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.548 -0500", hash_original_field = "98A185221B2EB73F00D00485A740783A", hash_generated_field = "4AA92A8434A0292EFE01E2DB4B64C8A2")

        public static final String FLASH_MODE_RED_EYE = "red-eye";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.551 -0500", hash_original_field = "75AE51C1E90677C1A8F9F36936F03A6A", hash_generated_field = "0DAB3003B917316F329F457B0212F936")

        public static final String FLASH_MODE_TORCH = "torch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.555 -0500", hash_original_field = "159A7E4CDEE68B6B2C16F0A26874CE8C", hash_generated_field = "F1634906DAF1C34C3A2A4CA6B8F718F4")

        public static final String SCENE_MODE_AUTO = "auto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.557 -0500", hash_original_field = "A61CF9BF06DA9229F0B61A0348D0367D", hash_generated_field = "9D3DA8A21BE69B06856C608B2AD32DFD")

        public static final String SCENE_MODE_ACTION = "action";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.560 -0500", hash_original_field = "99D63D788BE3F4C7922AD840A508AE33", hash_generated_field = "A37EFADE329921AF2451E99C3F4C7663")

        public static final String SCENE_MODE_PORTRAIT = "portrait";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.564 -0500", hash_original_field = "9088264C203302DE9235528DB3F6A1A0", hash_generated_field = "1C1DD492750269C6EC53EB96F95E7C07")

        public static final String SCENE_MODE_LANDSCAPE = "landscape";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.569 -0500", hash_original_field = "00C2DCDC1F3CE8DA96C937A46911D2F0", hash_generated_field = "CCF17FDE8811D586EAF34BD720C846B9")

        public static final String SCENE_MODE_NIGHT = "night";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.573 -0500", hash_original_field = "79FEEF3AFC8D62A3B23A4A4238EFF67C", hash_generated_field = "2C0B389CF7B25C4CF277D8EF6F2FBFFB")

        public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.577 -0500", hash_original_field = "9B6A1F4CA854D0ED86AA4E99F3C38E41", hash_generated_field = "ACD4ADB245B9338695698D748E07629A")

        public static final String SCENE_MODE_THEATRE = "theatre";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.581 -0500", hash_original_field = "90C2128F744A9F9232C37075A7C330BF", hash_generated_field = "E50050DDB6861F9C9AE50A61BDA45091")

        public static final String SCENE_MODE_BEACH = "beach";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.583 -0500", hash_original_field = "FAB9AFCBBAE4B0F729137899AE219990", hash_generated_field = "58FAEBA2840CEFA9C7F02339BA333C2E")

        public static final String SCENE_MODE_SNOW = "snow";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.586 -0500", hash_original_field = "ADF6D17EBC76D55279F83CA4534A7429", hash_generated_field = "837137813C12F691A0F6C3E6666DA3D8")

        public static final String SCENE_MODE_SUNSET = "sunset";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.589 -0500", hash_original_field = "EA4580AD37CA6BDFC6CCF6BAA15CB590", hash_generated_field = "7B5398D0F15B358277A7910CB360F8C2")

        public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.591 -0500", hash_original_field = "9A68A405A929D7F67FB4E7B23F8FC8C3", hash_generated_field = "60FD3F32E2416CFF43F721FCC7065063")

        public static final String SCENE_MODE_FIREWORKS = "fireworks";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.595 -0500", hash_original_field = "3CA58BF55194F2865A67ED406FF383E8", hash_generated_field = "52B55A7C344960073C7C8A0DA258FFA5")

        public static final String SCENE_MODE_SPORTS = "sports";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.598 -0500", hash_original_field = "11A0751A8808CCACC04BD1D561DAD04C", hash_generated_field = "4A7279C0AAB5979938DA40ED562D1F96")

        public static final String SCENE_MODE_PARTY = "party";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.601 -0500", hash_original_field = "A25301E11BC4ABE86ADC8E248213147A", hash_generated_field = "FF32A3BB976D19D61E4D6BB208602288")

        public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.604 -0500", hash_original_field = "E11CB91BF16093F35AB29674E865CB79", hash_generated_field = "2F612EEE316679E1ABA746C7062DF5D7")

        public static final String SCENE_MODE_BARCODE = "barcode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.607 -0500", hash_original_field = "E43F92D1DFF96B76C766BEB06E82B7E0", hash_generated_field = "805CC8DAE505AEE8F5DD932734150515")

        public static final String FOCUS_MODE_AUTO = "auto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.609 -0500", hash_original_field = "CB2052FEAECDCE2069E0DB79FB17D81E", hash_generated_field = "96314B23098998AC9C385910C6FA79AE")

        public static final String FOCUS_MODE_INFINITY = "infinity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.612 -0500", hash_original_field = "00E00725D7B376FCD687CBFC8E6B5564", hash_generated_field = "69E30265FB0EA71DC03F2587BCDADC5C")

        public static final String FOCUS_MODE_MACRO = "macro";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.615 -0500", hash_original_field = "BA9D72331A7BE01C17F66C4AB2E207C4", hash_generated_field = "211A0897FF17C0BD57C024FD4DDB82FF")

        public static final String FOCUS_MODE_FIXED = "fixed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.618 -0500", hash_original_field = "BF157E3333921287E6AF42B766042C5B", hash_generated_field = "0A54BDEC9604E0744ED4B3DC0D45DC6E")

        public static final String FOCUS_MODE_EDOF = "edof";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.621 -0500", hash_original_field = "25646AE2140EFF85AA28AFFFFA466936", hash_generated_field = "8EF526DF7D2C63F915412D52FDA6E999")

        public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.624 -0500", hash_original_field = "FC29431D3F69EB15A2956A785D5037A2", hash_generated_field = "C9EB0EBBB4F39D48C30B2443D3F1339E")

        public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.627 -0500", hash_original_field = "CF217696E65A0CE77E2D2A603E514504", hash_generated_field = "A4CE43E537376D2527BE12D56F096104")

        /**
         * The array index of near focus distance for use with
         * {@link #getFocusDistances(float[])}.
         */
        public static final int FOCUS_DISTANCE_NEAR_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.630 -0500", hash_original_field = "F2EB19685A7BE8421A0C402AABD4311C", hash_generated_field = "6467B36D6D4D60B6B320ABF8923415C4")

        public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.633 -0500", hash_original_field = "870FAA49D05A2BCAF00400933F491CFC", hash_generated_field = "C65652EC03CD2D15504CA27DDF003943")

        public static final int FOCUS_DISTANCE_FAR_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.636 -0500", hash_original_field = "2DCF27988F5D2D153E91ED55F579EB64", hash_generated_field = "E6A046FA5AD79AE5F731217D0E0DDD59")

        public static final int PREVIEW_FPS_MIN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.639 -0500", hash_original_field = "90D9897CC39576DB218016933716EB85", hash_generated_field = "EEEB5F7BE20582E1074F30E2EF425229")

        public static final int PREVIEW_FPS_MAX_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.642 -0500", hash_original_field = "FE5A06C063D903AE1A9ACE7A6D484063", hash_generated_field = "8D60D52E7DE6B58C2CD1CEB8461DCCB9")

        private static final String PIXEL_FORMAT_YUV422SP = "yuv422sp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.645 -0500", hash_original_field = "DAD2B7CB22F62A42C5C2FD43B4B2AD19", hash_generated_field = "CE201652177FAB6261B08E1238B606B1")

        private static final String PIXEL_FORMAT_YUV420SP = "yuv420sp";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.648 -0500", hash_original_field = "117303BAB3059BB58F4F40CCF1467675", hash_generated_field = "6741DF679FEF77AE5C23A481F6FD37CD")

        private static final String PIXEL_FORMAT_YUV422I = "yuv422i-yuyv";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.651 -0500", hash_original_field = "AF600D453D2C303C74A99AAF6D700962", hash_generated_field = "08B945A037890C999CA445CA4C953DDB")

        private static final String PIXEL_FORMAT_YUV420P = "yuv420p";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.654 -0500", hash_original_field = "FDDF7C68E75524E71B35E134D82BDD6A", hash_generated_field = "D508AD3FB4143F712106A7FD31E5D49C")

        private static final String PIXEL_FORMAT_RGB565 = "rgb565";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.657 -0500", hash_original_field = "568AD01A1709F46109F200457317BA71", hash_generated_field = "F0A6FC78605F8DC8C7CF568389F9C104")

        private static final String PIXEL_FORMAT_JPEG = "jpeg";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.660 -0500", hash_original_field = "444DAEEACC69575D07F052D4DE1105E9", hash_generated_field = "7871494F4A04FAF3BC57702E8CF732FB")

        private static final String PIXEL_FORMAT_BAYER_RGGB = "bayer-rggb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.663 -0500", hash_original_field = "3C050D8270DD8F7F3264D019CFA52FEC", hash_generated_field = "739CA7FE9531E7B12F38763AC7E52A02")


        private HashMap<String, String> mMap;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.666 -0500", hash_original_method = "4F2FCD993800C5D9B02C3E73A4276618", hash_generated_method = "98BAE95648571F244CFDEDFCD9E3B7C3")
        
private Parameters() {
            mMap = new HashMap<String, String>();
        }

        /**
         * Writes the current Parameters to the log.
         * @hide
         * @deprecated
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.668 -0500", hash_original_method = "D034C07CEE631373421F512D5E686FA4", hash_generated_method = "CBE5B203A34C8BEB55D01EB9FF3AD436")
        
public void dump() {
            Log.e(TAG, "dump: size=" + mMap.size());
            for (String k : mMap.keySet()) {
                Log.e(TAG, "dump: " + k + "=" + mMap.get(k));
            }
        }

        /**
         * Creates a single string with all the parameters set in
         * this Parameters object.
         * <p>The {@link #unflatten(String)} method does the reverse.</p>
         *
         * @return a String with all values from this Parameters object, in
         *         semi-colon delimited key-value pairs
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.672 -0500", hash_original_method = "E90C6E0F7F8E9CA9BC2EBC890074459A", hash_generated_method = "46D3C956E7D272874CD3790DC1C377E9")
        
public String flatten() {
            StringBuilder flattened = new StringBuilder();
            for (String k : mMap.keySet()) {
                flattened.append(k);
                flattened.append("=");
                flattened.append(mMap.get(k));
                flattened.append(";");
            }
            // chop off the extra semicolon at the end
            flattened.deleteCharAt(flattened.length()-1);
            return flattened.toString();
        }

        /**
         * Takes a flattened string of parameters and adds each one to
         * this Parameters object.
         * <p>The {@link #flatten()} method does the reverse.</p>
         *
         * @param flattened a String of parameters (key-value paired) that
         *                  are semi-colon delimited
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.675 -0500", hash_original_method = "5AA143467542BDE17D4CF17C4A163B7B", hash_generated_method = "12D2A58A9AE022CC9795E3DA8FBD2EE8")
        
public void unflatten(String flattened) {
            mMap.clear();

            StringTokenizer tokenizer = new StringTokenizer(flattened, ";");
            while (tokenizer.hasMoreElements()) {
                String kv = tokenizer.nextToken();
                int pos = kv.indexOf('=');
                if (pos == -1) {
                    continue;
                }
                String k = kv.substring(0, pos);
                String v = kv.substring(pos + 1);
                mMap.put(k, v);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.677 -0500", hash_original_method = "BEF3CDE9B4B41831DEDE5E8321E4E9B4", hash_generated_method = "E2E85DE724113176B69C7E443F0A8F9D")
        
public void remove(String key) {
            mMap.remove(key);
        }

        /**
         * Sets a String parameter.
         *
         * @param key   the key name for the parameter
         * @param value the String value of the parameter
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.680 -0500", hash_original_method = "9906E3CA2524241D923FE8CC5604496C", hash_generated_method = "DA159FF0D51109E26C5D52C200A68F33")
        
public void set(String key, String value) {
            if (key.indexOf('=') != -1 || key.indexOf(';') != -1) {
                Log.e(TAG, "Key \"" + key + "\" contains invalid character (= or ;)");
                return;
            }
            if (value.indexOf('=') != -1 || value.indexOf(';') != -1) {
                Log.e(TAG, "Value \"" + value + "\" contains invalid character (= or ;)");
                return;
            }

            mMap.put(key, value);
        }

        /**
         * Sets an integer parameter.
         *
         * @param key   the key name for the parameter
         * @param value the int value of the parameter
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.682 -0500", hash_original_method = "DBCF0186D288029EB50A796A20F8A1EF", hash_generated_method = "364A017ADED4A0C02371C2CE3587A597")
        
public void set(String key, int value) {
            mMap.put(key, Integer.toString(value));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.686 -0500", hash_original_method = "FA0E250AABDDF6BDEB5118FEC7A9E23B", hash_generated_method = "63972096D8FF1414B952CAC11158DF74")
        
private void set(String key, List<Area> areas) {
            if (areas == null) {
                set(key, "(0,0,0,0,0)");
            } else {
                StringBuilder buffer = new StringBuilder();
                for (int i = 0; i < areas.size(); i++) {
                    Area area = areas.get(i);
                    Rect rect = area.rect;
                    buffer.append('(');
                    buffer.append(rect.left);
                    buffer.append(',');
                    buffer.append(rect.top);
                    buffer.append(',');
                    buffer.append(rect.right);
                    buffer.append(',');
                    buffer.append(rect.bottom);
                    buffer.append(',');
                    buffer.append(area.weight);
                    buffer.append(')');
                    if (i != areas.size() - 1) buffer.append(',');
                }
                set(key, buffer.toString());
            }
        }

        /**
         * Returns the value of a String parameter.
         *
         * @param key the key name for the parameter
         * @return the String value of the parameter
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.689 -0500", hash_original_method = "4BCD400EF6A3BABD5D1A20005C4F1016", hash_generated_method = "18B107DAE4FFDF7E7BECAC8E7CDF40D9")
        
public String get(String key) {
            return mMap.get(key);
        }

        /**
         * Returns the value of an integer parameter.
         *
         * @param key the key name for the parameter
         * @return the int value of the parameter
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.692 -0500", hash_original_method = "D98874905E79EBB2CF3B083E3C25C47A", hash_generated_method = "4C892BC34DA85BC898569013D71BECEC")
        
public int getInt(String key) {
            return Integer.parseInt(mMap.get(key));
        }

        /**
         * Sets the dimensions for preview pictures. If the preview has already
         * started, applications should stop the preview first before changing
         * preview size.
         *
         * The sides of width and height are based on camera orientation. That
         * is, the preview size is the size before it is rotated by display
         * orientation. So applications need to consider the display orientation
         * while setting preview size. For example, suppose the camera supports
         * both 480x320 and 320x480 preview sizes. The application wants a 3:2
         * preview ratio. If the display orientation is set to 0 or 180, preview
         * size should be set to 480x320. If the display orientation is set to
         * 90 or 270, preview size should be set to 320x480. The display
         * orientation should also be considered while setting picture size and
         * thumbnail size.
         *
         * @param width  the width of the pictures, in pixels
         * @param height the height of the pictures, in pixels
         * @see #setDisplayOrientation(int)
         * @see #getCameraInfo(int, CameraInfo)
         * @see #setPictureSize(int, int)
         * @see #setJpegThumbnailSize(int, int)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.695 -0500", hash_original_method = "6987138C4F07A5DAB158AF960652B331", hash_generated_method = "1DBF0D0FEE6E5153176543EA49CE334B")
        
public void setPreviewSize(int width, int height) {
            String v = Integer.toString(width) + "x" + Integer.toString(height);
            set(KEY_PREVIEW_SIZE, v);
        }

        /**
         * Returns the dimensions setting for preview pictures.
         *
         * @return a Size object with the width and height setting
         *          for the preview picture
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.697 -0500", hash_original_method = "FFDCE2F5212818E42781ADE1E098D0AA", hash_generated_method = "00593D158FF5EA5E6F06422C6C8C5283")
        
public Size getPreviewSize() {
            String pair = get(KEY_PREVIEW_SIZE);
            return strToSize(pair);
        }

        /**
         * Gets the supported preview sizes.
         *
         * @return a list of Size object. This method will always return a list
         *         with at least one element.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.700 -0500", hash_original_method = "8D352EB4757BE2304D2B4A3F288B091E", hash_generated_method = "10BD92853DE2D1C349711DDA43CAE9EE")
        
public List<Size> getSupportedPreviewSizes() {
            String str = get(KEY_PREVIEW_SIZE + SUPPORTED_VALUES_SUFFIX);
            return splitSize(str);
        }

        /**
         * <p>Gets the supported video frame sizes that can be used by
         * MediaRecorder.</p>
         *
         * <p>If the returned list is not null, the returned list will contain at
         * least one Size and one of the sizes in the returned list must be
         * passed to MediaRecorder.setVideoSize() for camcorder application if
         * camera is used as the video source. In this case, the size of the
         * preview can be different from the resolution of the recorded video
         * during video recording.</p>
         *
         * @return a list of Size object if camera has separate preview and
         *         video output; otherwise, null is returned.
         * @see #getPreferredPreviewSizeForVideo()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.702 -0500", hash_original_method = "419751D51666FF4E07A42C54765653DD", hash_generated_method = "7539CB456FECA20EB144AF10F46998A8")
        
public List<Size> getSupportedVideoSizes() {
            String str = get(KEY_VIDEO_SIZE + SUPPORTED_VALUES_SUFFIX);
            return splitSize(str);
        }

        /**
         * Returns the preferred or recommended preview size (width and height)
         * in pixels for video recording. Camcorder applications should
         * set the preview size to a value that is not larger than the
         * preferred preview size. In other words, the product of the width
         * and height of the preview size should not be larger than that of
         * the preferred preview size. In addition, we recommend to choose a
         * preview size that has the same aspect ratio as the resolution of
         * video to be recorded.
         *
         * @return the preferred preview size (width and height) in pixels for
         *         video recording if getSupportedVideoSizes() does not return
         *         null; otherwise, null is returned.
         * @see #getSupportedVideoSizes()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.705 -0500", hash_original_method = "476173E7CF96CBAAF95B36BF5A6B6193", hash_generated_method = "E77A042801EC17405DA4BAC11E227ED9")
        
public Size getPreferredPreviewSizeForVideo() {
            String pair = get(KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO);
            return strToSize(pair);
        }

        /**
         * <p>Sets the dimensions for EXIF thumbnail in Jpeg picture. If
         * applications set both width and height to 0, EXIF will not contain
         * thumbnail.</p>
         *
         * <p>Applications need to consider the display orientation. See {@link
         * #setPreviewSize(int,int)} for reference.</p>
         *
         * @param width  the width of the thumbnail, in pixels
         * @param height the height of the thumbnail, in pixels
         * @see #setPreviewSize(int,int)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.707 -0500", hash_original_method = "2AB80AB00FA241259D83FB9D6F5E9551", hash_generated_method = "DBA465C2EDEF61C1AEE61311D2EF43DC")
        
public void setJpegThumbnailSize(int width, int height) {
            set(KEY_JPEG_THUMBNAIL_WIDTH, width);
            set(KEY_JPEG_THUMBNAIL_HEIGHT, height);
        }

        /**
         * Returns the dimensions for EXIF thumbnail in Jpeg picture.
         *
         * @return a Size object with the height and width setting for the EXIF
         *         thumbnails
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.710 -0500", hash_original_method = "97782C5666FA5508071C4A4BBC2C021F", hash_generated_method = "15EF59A5775D2C2EFD1869C56C1FEA56")
        
public Size getJpegThumbnailSize() {
            return new Size(getInt(KEY_JPEG_THUMBNAIL_WIDTH),
                            getInt(KEY_JPEG_THUMBNAIL_HEIGHT));
        }

        /**
         * Gets the supported jpeg thumbnail sizes.
         *
         * @return a list of Size object. This method will always return a list
         *         with at least two elements. Size 0,0 (no thumbnail) is always
         *         supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.713 -0500", hash_original_method = "F3667EFF578F1A2BAF2D6378DF0D62F7", hash_generated_method = "9DF7BA7861CEB692D91CAB685E3F28AC")
        
public List<Size> getSupportedJpegThumbnailSizes() {
            String str = get(KEY_JPEG_THUMBNAIL_SIZE + SUPPORTED_VALUES_SUFFIX);
            return splitSize(str);
        }

        /**
         * Sets the quality of the EXIF thumbnail in Jpeg picture.
         *
         * @param quality the JPEG quality of the EXIF thumbnail. The range is 1
         *                to 100, with 100 being the best.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.715 -0500", hash_original_method = "D45FD8A4693A979494C68F5349AB982C", hash_generated_method = "5AF9D9F31E73CE832CF23EC6E5A821B6")
        
public void setJpegThumbnailQuality(int quality) {
            set(KEY_JPEG_THUMBNAIL_QUALITY, quality);
        }

        /**
         * Returns the quality setting for the EXIF thumbnail in Jpeg picture.
         *
         * @return the JPEG quality setting of the EXIF thumbnail.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.718 -0500", hash_original_method = "AB1C60CFC56F7C5F4F17D7289D5CF367", hash_generated_method = "ED9E65DE2EEC829461BCC61BB2F0F302")
        
public int getJpegThumbnailQuality() {
            return getInt(KEY_JPEG_THUMBNAIL_QUALITY);
        }

        /**
         * Sets Jpeg quality of captured picture.
         *
         * @param quality the JPEG quality of captured picture. The range is 1
         *                to 100, with 100 being the best.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.720 -0500", hash_original_method = "93253D80DE36A3D3B74304A7DEF0F5F5", hash_generated_method = "A4701A4595A94E984B10B2AE8F2C0409")
        
public void setJpegQuality(int quality) {
            set(KEY_JPEG_QUALITY, quality);
        }

        /**
         * Returns the quality setting for the JPEG picture.
         *
         * @return the JPEG picture quality setting.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.722 -0500", hash_original_method = "1D0E1BB86FE6D9E935C1A2619011DCB7", hash_generated_method = "1573F32B47839198F34F04EA7E00E3E0")
        
public int getJpegQuality() {
            return getInt(KEY_JPEG_QUALITY);
        }

        /**
         * Sets the rate at which preview frames are received. This is the
         * target frame rate. The actual frame rate depends on the driver.
         *
         * @param fps the frame rate (frames per second)
         * @deprecated replaced by {@link #setPreviewFpsRange(int,int)}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.725 -0500", hash_original_method = "B0B2C8D52537728343380388CD5075DA", hash_generated_method = "AC08DE7400B8697D3BD9594CE38CC405")
        
@Deprecated
        public void setPreviewFrameRate(int fps) {
            set(KEY_PREVIEW_FRAME_RATE, fps);
        }

        /**
         * Returns the setting for the rate at which preview frames are
         * received. This is the target frame rate. The actual frame rate
         * depends on the driver.
         *
         * @return the frame rate setting (frames per second)
         * @deprecated replaced by {@link #getPreviewFpsRange(int[])}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.727 -0500", hash_original_method = "C0E05BF1AAC7EB32A80D6F26752FF1EF", hash_generated_method = "ECB547098083472AA4C1043EB21FF60C")
        
@Deprecated
        public int getPreviewFrameRate() {
            return getInt(KEY_PREVIEW_FRAME_RATE);
        }

        /**
         * Gets the supported preview frame rates.
         *
         * @return a list of supported preview frame rates. null if preview
         *         frame rate setting is not supported.
         * @deprecated replaced by {@link #getSupportedPreviewFpsRange()}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.731 -0500", hash_original_method = "C09404C88F71AC7FB4B866C390BFE007", hash_generated_method = "BCE771F8FFFA0C83840872445DE6F031")
        
@Deprecated
        public List<Integer> getSupportedPreviewFrameRates() {
            String str = get(KEY_PREVIEW_FRAME_RATE + SUPPORTED_VALUES_SUFFIX);
            return splitInt(str);
        }

        /**
         * Sets the maximum and maximum preview fps. This controls the rate of
         * preview frames received in {@link PreviewCallback}. The minimum and
         * maximum preview fps must be one of the elements from {@link
         * #getSupportedPreviewFpsRange}.
         *
         * @param min the minimum preview fps (scaled by 1000).
         * @param max the maximum preview fps (scaled by 1000).
         * @throws RuntimeException if fps range is invalid.
         * @see #setPreviewCallbackWithBuffer(Camera.PreviewCallback)
         * @see #getSupportedPreviewFpsRange()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.733 -0500", hash_original_method = "6968DA252510074FDC520CD1B2513339", hash_generated_method = "9C70C9496F6BB96D13D47D0BCC4A3B68")
        
public void setPreviewFpsRange(int min, int max) {
            set(KEY_PREVIEW_FPS_RANGE, "" + min + "," + max);
        }

        /**
         * Returns the current minimum and maximum preview fps. The values are
         * one of the elements returned by {@link #getSupportedPreviewFpsRange}.
         *
         * @return range the minimum and maximum preview fps (scaled by 1000).
         * @see #PREVIEW_FPS_MIN_INDEX
         * @see #PREVIEW_FPS_MAX_INDEX
         * @see #getSupportedPreviewFpsRange()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.737 -0500", hash_original_method = "694B13D03BD40D12B87F5E9E7F0CCA71", hash_generated_method = "1C53DEE1661FC57FE5EEFB37EFEC6687")
        
public void getPreviewFpsRange(int[] range) {
            if (range == null || range.length != 2) {
                throw new IllegalArgumentException(
                        "range must be an array with two elements.");
            }
            splitInt(get(KEY_PREVIEW_FPS_RANGE), range);
        }

        /**
         * Gets the supported preview fps (frame-per-second) ranges. Each range
         * contains a minimum fps and maximum fps. If minimum fps equals to
         * maximum fps, the camera outputs frames in fixed frame rate. If not,
         * the camera outputs frames in auto frame rate. The actual frame rate
         * fluctuates between the minimum and the maximum. The values are
         * multiplied by 1000 and represented in integers. For example, if frame
         * rate is 26.623 frames per second, the value is 26623.
         *
         * @return a list of supported preview fps ranges. This method returns a
         *         list with at least one element. Every element is an int array
         *         of two values - minimum fps and maximum fps. The list is
         *         sorted from small to large (first by maximum fps and then
         *         minimum fps).
         * @see #PREVIEW_FPS_MIN_INDEX
         * @see #PREVIEW_FPS_MAX_INDEX
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.740 -0500", hash_original_method = "37F4ABC3F60B37AD6F5647AB4E5273E8", hash_generated_method = "324E8645B0571B0588B13481475ABFB4")
        
public List<int[]> getSupportedPreviewFpsRange() {
            String str = get(KEY_PREVIEW_FPS_RANGE + SUPPORTED_VALUES_SUFFIX);
            return splitRange(str);
        }

        /**
         * Sets the image format for preview pictures.
         * <p>If this is never called, the default format will be
         * {@link android.graphics.ImageFormat#NV21}, which
         * uses the NV21 encoding format.</p>
         *
         * @param pixel_format the desired preview picture format, defined
         *   by one of the {@link android.graphics.ImageFormat} constants.
         *   (E.g., <var>ImageFormat.NV21</var> (default),
         *                      <var>ImageFormat.RGB_565</var>, or
         *                      <var>ImageFormat.JPEG</var>)
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.742 -0500", hash_original_method = "266AF7A67C96051E3828B919A653DC3F", hash_generated_method = "2C4CBB4ADA21779FCCA790EA9F19C8D3")
        
public void setPreviewFormat(int pixel_format) {
            String s = cameraFormatForPixelFormat(pixel_format);
            if (s == null) {
                throw new IllegalArgumentException(
                        "Invalid pixel_format=" + pixel_format);
            }

            set(KEY_PREVIEW_FORMAT, s);
        }

        /**
         * Returns the image format for preview frames got from
         * {@link PreviewCallback}.
         *
         * @return the preview format.
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.745 -0500", hash_original_method = "5798A7DE9C51B68E051BB876E894EF7F", hash_generated_method = "CFCC713E680A68CD208A35414B689537")
        
public int getPreviewFormat() {
            return pixelFormatForCameraFormat(get(KEY_PREVIEW_FORMAT));
        }

        /**
         * Gets the supported preview formats. {@link android.graphics.ImageFormat#NV21}
         * is always supported. {@link android.graphics.ImageFormat#YV12}
         * is always supported since API level 12.
         *
         * @return a list of supported preview formats. This method will always
         *         return a list with at least one element.
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.747 -0500", hash_original_method = "9C734A4D54DE4CD84D92E542612908A6", hash_generated_method = "C094563DE8F2484512C9F8465FD56499")
        
public List<Integer> getSupportedPreviewFormats() {
            String str = get(KEY_PREVIEW_FORMAT + SUPPORTED_VALUES_SUFFIX);
            ArrayList<Integer> formats = new ArrayList<Integer>();
            for (String s : split(str)) {
                int f = pixelFormatForCameraFormat(s);
                if (f == ImageFormat.UNKNOWN) continue;
                formats.add(f);
            }
            return formats;
        }

        /**
         * <p>Sets the dimensions for pictures.</p>
         *
         * <p>Applications need to consider the display orientation. See {@link
         * #setPreviewSize(int,int)} for reference.</p>
         *
         * @param width  the width for pictures, in pixels
         * @param height the height for pictures, in pixels
         * @see #setPreviewSize(int,int)
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.750 -0500", hash_original_method = "57116AEDE3770C6B0E8CE3250234439E", hash_generated_method = "9BF5DF2760F01B3B959CA6E9400D4A7A")
        
public void setPictureSize(int width, int height) {
            String v = Integer.toString(width) + "x" + Integer.toString(height);
            set(KEY_PICTURE_SIZE, v);
        }

        /**
         * Returns the dimension setting for pictures.
         *
         * @return a Size object with the height and width setting
         *          for pictures
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.753 -0500", hash_original_method = "7749C7A1B5F399C08E7379DC16E3083C", hash_generated_method = "EB6BA6EF8A78EA01B88DA92B07B3E126")
        
public Size getPictureSize() {
            String pair = get(KEY_PICTURE_SIZE);
            return strToSize(pair);
        }

        /**
         * Gets the supported picture sizes.
         *
         * @return a list of supported picture sizes. This method will always
         *         return a list with at least one element.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.755 -0500", hash_original_method = "8278131A0AA2D5B7AD51AB1A690AF2B9", hash_generated_method = "13981A906B3900EE45F1C54CD40F3333")
        
public List<Size> getSupportedPictureSizes() {
            String str = get(KEY_PICTURE_SIZE + SUPPORTED_VALUES_SUFFIX);
            return splitSize(str);
        }

        /**
         * Sets the image format for pictures.
         *
         * @param pixel_format the desired picture format
         *                     (<var>ImageFormat.NV21</var>,
         *                      <var>ImageFormat.RGB_565</var>, or
         *                      <var>ImageFormat.JPEG</var>)
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.758 -0500", hash_original_method = "51599A9895DB2449268569860164A951", hash_generated_method = "50B3C0A0C84BFAEFC01A6506ABD334E6")
        
public void setPictureFormat(int pixel_format) {
            String s = cameraFormatForPixelFormat(pixel_format);
            if (s == null) {
                throw new IllegalArgumentException(
                        "Invalid pixel_format=" + pixel_format);
            }

            set(KEY_PICTURE_FORMAT, s);
        }

        /**
         * Returns the image format for pictures.
         *
         * @return the picture format
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.761 -0500", hash_original_method = "646428F81142C769B950C6203EFA7A27", hash_generated_method = "FB49DF9DA815A28E26BBA13B94EA00A8")
        
public int getPictureFormat() {
            return pixelFormatForCameraFormat(get(KEY_PICTURE_FORMAT));
        }

        /**
         * Gets the supported picture formats.
         *
         * @return supported picture formats. This method will always return a
         *         list with at least one element.
         * @see android.graphics.ImageFormat
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.764 -0500", hash_original_method = "4F9B3ED6FF7CCA02CA0E3B13006D79AD", hash_generated_method = "6BF7D3C6215C87EDAF75B4B7562DC3F5")
        
public List<Integer> getSupportedPictureFormats() {
            String str = get(KEY_PICTURE_FORMAT + SUPPORTED_VALUES_SUFFIX);
            ArrayList<Integer> formats = new ArrayList<Integer>();
            for (String s : split(str)) {
                int f = pixelFormatForCameraFormat(s);
                if (f == ImageFormat.UNKNOWN) continue;
                formats.add(f);
            }
            return formats;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.766 -0500", hash_original_method = "0D21EA7C9C6F68B56031C051598A724A", hash_generated_method = "53575DDF4E031CC533F76C1BD0255940")
        
private String cameraFormatForPixelFormat(int pixel_format) {
            switch(pixel_format) {
            case ImageFormat.NV16:      return PIXEL_FORMAT_YUV422SP;
            case ImageFormat.NV21:      return PIXEL_FORMAT_YUV420SP;
            case ImageFormat.YUY2:      return PIXEL_FORMAT_YUV422I;
            case ImageFormat.YV12:      return PIXEL_FORMAT_YUV420P;
            case ImageFormat.RGB_565:   return PIXEL_FORMAT_RGB565;
            case ImageFormat.JPEG:      return PIXEL_FORMAT_JPEG;
            case ImageFormat.BAYER_RGGB: return PIXEL_FORMAT_BAYER_RGGB;
            default:                    return null;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.769 -0500", hash_original_method = "0B875F69B968394282E409325FD17632", hash_generated_method = "2A808DBF1C7811103F2D31FBAA9927C0")
        
private int pixelFormatForCameraFormat(String format) {
            if (format == null)
                return ImageFormat.UNKNOWN;

            if (format.equals(PIXEL_FORMAT_YUV422SP))
                return ImageFormat.NV16;

            if (format.equals(PIXEL_FORMAT_YUV420SP))
                return ImageFormat.NV21;

            if (format.equals(PIXEL_FORMAT_YUV422I))
                return ImageFormat.YUY2;

            if (format.equals(PIXEL_FORMAT_YUV420P))
                return ImageFormat.YV12;

            if (format.equals(PIXEL_FORMAT_RGB565))
                return ImageFormat.RGB_565;

            if (format.equals(PIXEL_FORMAT_JPEG))
                return ImageFormat.JPEG;

            return ImageFormat.UNKNOWN;
        }

        /**
         * Sets the rotation angle in degrees relative to the orientation of
         * the camera. This affects the pictures returned from JPEG {@link
         * PictureCallback}. The camera driver may set orientation in the
         * EXIF header without rotating the picture. Or the driver may rotate
         * the picture and the EXIF thumbnail. If the Jpeg picture is rotated,
         * the orientation in the EXIF header will be missing or 1 (row #0 is
         * top and column #0 is left side).
         *
         * <p>If applications want to rotate the picture to match the orientation
         * of what users see, apps should use {@link
         * android.view.OrientationEventListener} and {@link CameraInfo}.
         * The value from OrientationEventListener is relative to the natural
         * orientation of the device. CameraInfo.orientation is the angle
         * between camera orientation and natural device orientation. The sum
         * of the two is the rotation angle for back-facing camera. The
         * difference of the two is the rotation angle for front-facing camera.
         * Note that the JPEG pictures of front-facing cameras are not mirrored
         * as in preview display.
         *
         * <p>For example, suppose the natural orientation of the device is
         * portrait. The device is rotated 270 degrees clockwise, so the device
         * orientation is 270. Suppose a back-facing camera sensor is mounted in
         * landscape and the top side of the camera sensor is aligned with the
         * right edge of the display in natural orientation. So the camera
         * orientation is 90. The rotation should be set to 0 (270 + 90).
         *
         * <p>The reference code is as follows.
         *
         * <pre>
         * public void onOrientationChanged(int orientation) {
         *     if (orientation == ORIENTATION_UNKNOWN) return;
         *     android.hardware.Camera.CameraInfo info =
         *            new android.hardware.Camera.CameraInfo();
         *     android.hardware.Camera.getCameraInfo(cameraId, info);
         *     orientation = (orientation + 45) / 90 * 90;
         *     int rotation = 0;
         *     if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
         *         rotation = (info.orientation - orientation + 360) % 360;
         *     } else {  // back-facing camera
         *         rotation = (info.orientation + orientation) % 360;
         *     }
         *     mParameters.setRotation(rotation);
         * }
         * </pre>
         *
         * @param rotation The rotation angle in degrees relative to the
         *                 orientation of the camera. Rotation can only be 0,
         *                 90, 180 or 270.
         * @throws IllegalArgumentException if rotation value is invalid.
         * @see android.view.OrientationEventListener
         * @see #getCameraInfo(int, CameraInfo)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.771 -0500", hash_original_method = "7F1F8FE07039060100EB7EAEC293220B", hash_generated_method = "F3875D2F4F1C5F577C65AB5F82BC30E8")
        
public void setRotation(int rotation) {
            if (rotation == 0 || rotation == 90 || rotation == 180
                    || rotation == 270) {
                set(KEY_ROTATION, Integer.toString(rotation));
            } else {
                throw new IllegalArgumentException(
                        "Invalid rotation=" + rotation);
            }
        }

        /**
         * Sets GPS latitude coordinate. This will be stored in JPEG EXIF
         * header.
         *
         * @param latitude GPS latitude coordinate.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.774 -0500", hash_original_method = "BEFE742BAEEA8C90DDA5ADB3E09F2E6F", hash_generated_method = "B4A2DBD30E863CEAD97D7F68268A00DA")
        
public void setGpsLatitude(double latitude) {
            set(KEY_GPS_LATITUDE, Double.toString(latitude));
        }

        /**
         * Sets GPS longitude coordinate. This will be stored in JPEG EXIF
         * header.
         *
         * @param longitude GPS longitude coordinate.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.778 -0500", hash_original_method = "15D67DC442B59D8C20F49D295A03B9C3", hash_generated_method = "3A1A7257F4BECF4A9D22F92517AAEDDF")
        
public void setGpsLongitude(double longitude) {
            set(KEY_GPS_LONGITUDE, Double.toString(longitude));
        }

        /**
         * Sets GPS altitude. This will be stored in JPEG EXIF header.
         *
         * @param altitude GPS altitude in meters.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.780 -0500", hash_original_method = "D37B20DFD4F471A556A1A3948D012F6F", hash_generated_method = "4190722456224BB6A9DE82AD946A3F32")
        
public void setGpsAltitude(double altitude) {
            set(KEY_GPS_ALTITUDE, Double.toString(altitude));
        }

        /**
         * Sets GPS timestamp. This will be stored in JPEG EXIF header.
         *
         * @param timestamp GPS timestamp (UTC in seconds since January 1,
         *                  1970).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.783 -0500", hash_original_method = "E7E121605EA7F31AA54C4E2FEA0A633A", hash_generated_method = "4FD7F924D21E8330AA976AC57A6DD10F")
        
public void setGpsTimestamp(long timestamp) {
            set(KEY_GPS_TIMESTAMP, Long.toString(timestamp));
        }

        /**
         * Sets GPS processing method. It will store up to 32 characters
         * in JPEG EXIF header.
         *
         * @param processing_method The processing method to get this location.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.786 -0500", hash_original_method = "EB21E6C6306284106B5612462912EE4A", hash_generated_method = "07CEC522E3A5B37FDAC9AA98F0765619")
        
public void setGpsProcessingMethod(String processing_method) {
            set(KEY_GPS_PROCESSING_METHOD, processing_method);
        }

        /**
         * Removes GPS latitude, longitude, altitude, and timestamp from the
         * parameters.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.789 -0500", hash_original_method = "DB2725AB8B49886BA5EC1CA9683A5411", hash_generated_method = "7BF47AD305BCEE204C66C3B78519985D")
        
public void removeGpsData() {
            remove(KEY_GPS_LATITUDE);
            remove(KEY_GPS_LONGITUDE);
            remove(KEY_GPS_ALTITUDE);
            remove(KEY_GPS_TIMESTAMP);
            remove(KEY_GPS_PROCESSING_METHOD);
        }

        /**
         * Gets the current white balance setting.
         *
         * @return current white balance. null if white balance setting is not
         *         supported.
         * @see #WHITE_BALANCE_AUTO
         * @see #WHITE_BALANCE_INCANDESCENT
         * @see #WHITE_BALANCE_FLUORESCENT
         * @see #WHITE_BALANCE_WARM_FLUORESCENT
         * @see #WHITE_BALANCE_DAYLIGHT
         * @see #WHITE_BALANCE_CLOUDY_DAYLIGHT
         * @see #WHITE_BALANCE_TWILIGHT
         * @see #WHITE_BALANCE_SHADE
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.791 -0500", hash_original_method = "F88C937231FAAF4C00547B817FC6B121", hash_generated_method = "593DA397ADA5D8B2B41405D1F11C8B68")
        
public String getWhiteBalance() {
            return get(KEY_WHITE_BALANCE);
        }

        /**
         * Sets the white balance. Changing the setting will release the
         * auto-white balance lock. It is recommended not to change white
         * balance and AWB lock at the same time.
         *
         * @param value new white balance.
         * @see #getWhiteBalance()
         * @see #setAutoWhiteBalanceLock(boolean)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.794 -0500", hash_original_method = "F368B7E42EFB4E89424B346F78A99160", hash_generated_method = "E76701CDA212D195315DD91CD02A95CA")
        
public void setWhiteBalance(String value) {
            String oldValue = get(KEY_WHITE_BALANCE);
            if (same(value, oldValue)) return;
            set(KEY_WHITE_BALANCE, value);
            set(KEY_AUTO_WHITEBALANCE_LOCK, FALSE);
        }

        /**
         * Gets the supported white balance.
         *
         * @return a list of supported white balance. null if white balance
         *         setting is not supported.
         * @see #getWhiteBalance()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.797 -0500", hash_original_method = "6BD64FEF1410D0D6447FCBDB1167D9B6", hash_generated_method = "15F7079C469DF7449B57732125752535")
        
public List<String> getSupportedWhiteBalance() {
            String str = get(KEY_WHITE_BALANCE + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }

        /**
         * Gets the current color effect setting.
         *
         * @return current color effect. null if color effect
         *         setting is not supported.
         * @see #EFFECT_NONE
         * @see #EFFECT_MONO
         * @see #EFFECT_NEGATIVE
         * @see #EFFECT_SOLARIZE
         * @see #EFFECT_SEPIA
         * @see #EFFECT_POSTERIZE
         * @see #EFFECT_WHITEBOARD
         * @see #EFFECT_BLACKBOARD
         * @see #EFFECT_AQUA
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.799 -0500", hash_original_method = "EBDE73BA19867EBFCE22D321F450F04C", hash_generated_method = "60CD23ED292B48B8C6C23BECBF7F7192")
        
public String getColorEffect() {
            return get(KEY_EFFECT);
        }

        /**
         * Sets the current color effect setting.
         *
         * @param value new color effect.
         * @see #getColorEffect()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.802 -0500", hash_original_method = "0DAF9E55870C866B1D9028B63F9B1051", hash_generated_method = "08EAA4356B2FBD8419F87D628512BD41")
        
public void setColorEffect(String value) {
            set(KEY_EFFECT, value);
        }

        /**
         * Gets the supported color effects.
         *
         * @return a list of supported color effects. null if color effect
         *         setting is not supported.
         * @see #getColorEffect()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.805 -0500", hash_original_method = "17E8CABB5939F7293955A7E6B8E9706B", hash_generated_method = "2C0E927348936C6C3776C79A0F363098")
        
public List<String> getSupportedColorEffects() {
            String str = get(KEY_EFFECT + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }


        /**
         * Gets the current antibanding setting.
         *
         * @return current antibanding. null if antibanding setting is not
         *         supported.
         * @see #ANTIBANDING_AUTO
         * @see #ANTIBANDING_50HZ
         * @see #ANTIBANDING_60HZ
         * @see #ANTIBANDING_OFF
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.808 -0500", hash_original_method = "BF4FDA8351654C2EB61A4F54B91D348E", hash_generated_method = "50F9E996357968EA0972F91EEAF41BFC")
        
public String getAntibanding() {
            return get(KEY_ANTIBANDING);
        }

        /**
         * Sets the antibanding.
         *
         * @param antibanding new antibanding value.
         * @see #getAntibanding()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.810 -0500", hash_original_method = "985E6B38FF8AC0EB85AFEB9A2D7D5D97", hash_generated_method = "FB0A9B406095BE2FEE07D90F8E9A1F9C")
        
public void setAntibanding(String antibanding) {
            set(KEY_ANTIBANDING, antibanding);
        }

        /**
         * Gets the supported antibanding values.
         *
         * @return a list of supported antibanding values. null if antibanding
         *         setting is not supported.
         * @see #getAntibanding()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.813 -0500", hash_original_method = "2747115FB870E356DAC02162754EC48E", hash_generated_method = "4F606B50503E3D82FC87507C75A85BE5")
        
public List<String> getSupportedAntibanding() {
            String str = get(KEY_ANTIBANDING + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }

        /**
         * Gets the current scene mode setting.
         *
         * @return one of SCENE_MODE_XXX string constant. null if scene mode
         *         setting is not supported.
         * @see #SCENE_MODE_AUTO
         * @see #SCENE_MODE_ACTION
         * @see #SCENE_MODE_PORTRAIT
         * @see #SCENE_MODE_LANDSCAPE
         * @see #SCENE_MODE_NIGHT
         * @see #SCENE_MODE_NIGHT_PORTRAIT
         * @see #SCENE_MODE_THEATRE
         * @see #SCENE_MODE_BEACH
         * @see #SCENE_MODE_SNOW
         * @see #SCENE_MODE_SUNSET
         * @see #SCENE_MODE_STEADYPHOTO
         * @see #SCENE_MODE_FIREWORKS
         * @see #SCENE_MODE_SPORTS
         * @see #SCENE_MODE_PARTY
         * @see #SCENE_MODE_CANDLELIGHT
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.815 -0500", hash_original_method = "392D4B71E895D4140EEFD980EB15B5EB", hash_generated_method = "691DA46143DA9BF9938A86839D45704C")
        
public String getSceneMode() {
            return get(KEY_SCENE_MODE);
        }

        /**
         * Sets the scene mode. Changing scene mode may override other
         * parameters (such as flash mode, focus mode, white balance). For
         * example, suppose originally flash mode is on and supported flash
         * modes are on/off. In night scene mode, both flash mode and supported
         * flash mode may be changed to off. After setting scene mode,
         * applications should call getParameters to know if some parameters are
         * changed.
         *
         * @param value scene mode.
         * @see #getSceneMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.817 -0500", hash_original_method = "F340D9AF77CABF3FCAC1513FFFE1B10A", hash_generated_method = "9BA5915BA5E81E16DD36AD91AAE89DF0")
        
public void setSceneMode(String value) {
            set(KEY_SCENE_MODE, value);
        }

        /**
         * Gets the supported scene modes.
         *
         * @return a list of supported scene modes. null if scene mode setting
         *         is not supported.
         * @see #getSceneMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.820 -0500", hash_original_method = "AB0AD307D147C1A6D4713ECB3D12ACCF", hash_generated_method = "9F2E42C9F7D53169DE36AC9173B23BA3")
        
public List<String> getSupportedSceneModes() {
            String str = get(KEY_SCENE_MODE + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }

        /**
         * Gets the current flash mode setting.
         *
         * @return current flash mode. null if flash mode setting is not
         *         supported.
         * @see #FLASH_MODE_OFF
         * @see #FLASH_MODE_AUTO
         * @see #FLASH_MODE_ON
         * @see #FLASH_MODE_RED_EYE
         * @see #FLASH_MODE_TORCH
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.823 -0500", hash_original_method = "7750780C979B83A925E226C6EFF8842D", hash_generated_method = "E83475C7B7538A7AE276AD39CA15EA70")
        
public String getFlashMode() {
            return get(KEY_FLASH_MODE);
        }

        /**
         * Sets the flash mode.
         *
         * @param value flash mode.
         * @see #getFlashMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.825 -0500", hash_original_method = "C9F8B5AECF6107B196C9E01FA7C3624E", hash_generated_method = "5B25B77173D426BAB2F628CE784BFCBA")
        
public void setFlashMode(String value) {
            set(KEY_FLASH_MODE, value);
        }

        /**
         * Gets the supported flash modes.
         *
         * @return a list of supported flash modes. null if flash mode setting
         *         is not supported.
         * @see #getFlashMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.828 -0500", hash_original_method = "9F7096D0E359D5569731888F2DB333B8", hash_generated_method = "FAD1C14B30051AA4ED799F4063F11D5E")
        
public List<String> getSupportedFlashModes() {
            String str = get(KEY_FLASH_MODE + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }

        /**
         * Gets the current focus mode setting.
         *
         * @return current focus mode. This method will always return a non-null
         *         value. Applications should call {@link
         *         #autoFocus(AutoFocusCallback)} to start the focus if focus
         *         mode is FOCUS_MODE_AUTO or FOCUS_MODE_MACRO.
         * @see #FOCUS_MODE_AUTO
         * @see #FOCUS_MODE_INFINITY
         * @see #FOCUS_MODE_MACRO
         * @see #FOCUS_MODE_FIXED
         * @see #FOCUS_MODE_EDOF
         * @see #FOCUS_MODE_CONTINUOUS_VIDEO
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.831 -0500", hash_original_method = "E2184619B509409238D8385BD3A054E5", hash_generated_method = "F6449A4CBF51EDCBF2AC20B6A387F80E")
        
public String getFocusMode() {
            return get(KEY_FOCUS_MODE);
        }

        /**
         * Sets the focus mode.
         *
         * @param value focus mode.
         * @see #getFocusMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.833 -0500", hash_original_method = "7416CBC128B7B3D1CBE2DFA875979AFE", hash_generated_method = "87FECA6DF3FC52B36F1AD507E4EC5FFA")
        
public void setFocusMode(String value) {
            set(KEY_FOCUS_MODE, value);
        }

        /**
         * Gets the supported focus modes.
         *
         * @return a list of supported focus modes. This method will always
         *         return a list with at least one element.
         * @see #getFocusMode()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.836 -0500", hash_original_method = "87EBF137327885002F74E14885E0F854", hash_generated_method = "CC849BFF1A0DB8B865F34DAEA25187FF")
        
public List<String> getSupportedFocusModes() {
            String str = get(KEY_FOCUS_MODE + SUPPORTED_VALUES_SUFFIX);
            return split(str);
        }

        /**
         * Gets the focal length (in millimeter) of the camera.
         *
         * @return the focal length. This method will always return a valid
         *         value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.838 -0500", hash_original_method = "280C651533E602E83169E9949FF56CC5", hash_generated_method = "9ECD59C1B6DCEC23F2F1D3B70978AA50")
        
public float getFocalLength() {
            return Float.parseFloat(get(KEY_FOCAL_LENGTH));
        }

        /**
         * Gets the horizontal angle of view in degrees.
         *
         * @return horizontal angle of view. This method will always return a
         *         valid value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.841 -0500", hash_original_method = "E095E3B11FF628CF893AB471782FDC45", hash_generated_method = "E4141CAA0C2DD8A466931F904610D5D5")
        
public float getHorizontalViewAngle() {
            return Float.parseFloat(get(KEY_HORIZONTAL_VIEW_ANGLE));
        }

        /**
         * Gets the vertical angle of view in degrees.
         *
         * @return vertical angle of view. This method will always return a
         *         valid value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.843 -0500", hash_original_method = "A3A0BD560F956F2DE67EDBBDC96AF08A", hash_generated_method = "E7FA8F296C02D0D42BEA5B13984E7D0E")
        
public float getVerticalViewAngle() {
            return Float.parseFloat(get(KEY_VERTICAL_VIEW_ANGLE));
        }

        /**
         * Gets the current exposure compensation index.
         *
         * @return current exposure compensation index. The range is {@link
         *         #getMinExposureCompensation} to {@link
         *         #getMaxExposureCompensation}. 0 means exposure is not
         *         adjusted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.846 -0500", hash_original_method = "5FCFE536B3898D346449D108449D390F", hash_generated_method = "BFD7464C646A695F80942FB1CDACF74D")
        
public int getExposureCompensation() {
            return getInt(KEY_EXPOSURE_COMPENSATION, 0);
        }

        /**
         * Sets the exposure compensation index.
         *
         * @param value exposure compensation index. The valid value range is
         *        from {@link #getMinExposureCompensation} (inclusive) to {@link
         *        #getMaxExposureCompensation} (inclusive). 0 means exposure is
         *        not adjusted. Application should call
         *        getMinExposureCompensation and getMaxExposureCompensation to
         *        know if exposure compensation is supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.848 -0500", hash_original_method = "111B767E933C2CD9576CD967C7CB52EF", hash_generated_method = "2EB79FABFD9C0A01B5FDD9366985D416")
        
public void setExposureCompensation(int value) {
            set(KEY_EXPOSURE_COMPENSATION, value);
        }

        /**
         * Gets the maximum exposure compensation index.
         *
         * @return maximum exposure compensation index (>=0). If both this
         *         method and {@link #getMinExposureCompensation} return 0,
         *         exposure compensation is not supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.852 -0500", hash_original_method = "075FA30D94BD252A505071BE80B3A2DE", hash_generated_method = "A1699AD07848A0FFDE06486DB87DDB6A")
        
public int getMaxExposureCompensation() {
            return getInt(KEY_MAX_EXPOSURE_COMPENSATION, 0);
        }

        /**
         * Gets the minimum exposure compensation index.
         *
         * @return minimum exposure compensation index (<=0). If both this
         *         method and {@link #getMaxExposureCompensation} return 0,
         *         exposure compensation is not supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.854 -0500", hash_original_method = "B03007C077325F58AA26E52D0D9C3FEA", hash_generated_method = "BE4FAD1065457AFBE725279D9F9D3823")
        
public int getMinExposureCompensation() {
            return getInt(KEY_MIN_EXPOSURE_COMPENSATION, 0);
        }

        /**
         * Gets the exposure compensation step.
         *
         * @return exposure compensation step. Applications can get EV by
         *         multiplying the exposure compensation index and step. Ex: if
         *         exposure compensation index is -6 and step is 0.333333333, EV
         *         is -2.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.857 -0500", hash_original_method = "9B0A72FE96E27833E9483AB189C9FCA2", hash_generated_method = "38C1BA754F74F5FDA22DCE3572B06AD5")
        
public float getExposureCompensationStep() {
            return getFloat(KEY_EXPOSURE_COMPENSATION_STEP, 0);
        }

        /**
         * <p>Sets the auto-exposure lock state. Applications should check
         * {@link #isAutoExposureLockSupported} before using this method.</p>
         *
         * <p>If set to true, the camera auto-exposure routine will immediately
         * pause until the lock is set to false. Exposure compensation settings
         * changes will still take effect while auto-exposure is locked.</p>
         *
         * <p>If auto-exposure is already locked, setting this to true again has
         * no effect (the driver will not recalculate exposure values).</p>
         *
         * <p>Stopping preview with {@link #stopPreview()}, or triggering still
         * image capture with {@link #takePicture(Camera.ShutterCallback,
         * Camera.PictureCallback, Camera.PictureCallback)}, will not change the
         * lock.</p>
         *
         * <p>Exposure compensation, auto-exposure lock, and auto-white balance
         * lock can be used to capture an exposure-bracketed burst of images,
         * for example.</p>
         *
         * <p>Auto-exposure state, including the lock state, will not be
         * maintained after camera {@link #release()} is called.  Locking
         * auto-exposure after {@link #open()} but before the first call to
         * {@link #startPreview()} will not allow the auto-exposure routine to
         * run at all, and may result in severely over- or under-exposed
         * images.</p>
         *
         * @param toggle new state of the auto-exposure lock. True means that
         *        auto-exposure is locked, false means that the auto-exposure
         *        routine is free to run normally.
         *
         * @see #getAutoExposureLock()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.859 -0500", hash_original_method = "FB8CC317CA960BD5E74A2557DE2CFB32", hash_generated_method = "4C9479D41F73B7EAA149F39EF538D889")
        
public void setAutoExposureLock(boolean toggle) {
            set(KEY_AUTO_EXPOSURE_LOCK, toggle ? TRUE : FALSE);
        }

        /**
         * Gets the state of the auto-exposure lock. Applications should check
         * {@link #isAutoExposureLockSupported} before using this method. See
         * {@link #setAutoExposureLock} for details about the lock.
         *
         * @return State of the auto-exposure lock. Returns true if
         *         auto-exposure is currently locked, and false otherwise.
         *
         * @see #setAutoExposureLock(boolean)
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.862 -0500", hash_original_method = "1B30FBAE422A22E9908E62CE6CA17AA9", hash_generated_method = "375D32038517DBAAD9E790C34D52936B")
        
public boolean getAutoExposureLock() {
            String str = get(KEY_AUTO_EXPOSURE_LOCK);
            return TRUE.equals(str);
        }

        /**
         * Returns true if auto-exposure locking is supported. Applications
         * should call this before trying to lock auto-exposure. See
         * {@link #setAutoExposureLock} for details about the lock.
         *
         * @return true if auto-exposure lock is supported.
         * @see #setAutoExposureLock(boolean)
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.864 -0500", hash_original_method = "E05124C1C1E1A7B4964E51C638A3C3B5", hash_generated_method = "B12EE3EB705123EDDD589B207AC14A07")
        
public boolean isAutoExposureLockSupported() {
            String str = get(KEY_AUTO_EXPOSURE_LOCK_SUPPORTED);
            return TRUE.equals(str);
        }

        /**
         * <p>Sets the auto-white balance lock state. Applications should check
         * {@link #isAutoWhiteBalanceLockSupported} before using this
         * method.</p>
         *
         * <p>If set to true, the camera auto-white balance routine will
         * immediately pause until the lock is set to false.</p>
         *
         * <p>If auto-white balance is already locked, setting this to true
         * again has no effect (the driver will not recalculate white balance
         * values).</p>
         *
         * <p>Stopping preview with {@link #stopPreview()}, or triggering still
         * image capture with {@link #takePicture(Camera.ShutterCallback,
         * Camera.PictureCallback, Camera.PictureCallback)}, will not change the
         * the lock.</p>
         *
         * <p> Changing the white balance mode with {@link #setWhiteBalance}
         * will release the auto-white balance lock if it is set.</p>
         *
         * <p>Exposure compensation, AE lock, and AWB lock can be used to
         * capture an exposure-bracketed burst of images, for example.
         * Auto-white balance state, including the lock state, will not be
         * maintained after camera {@link #release()} is called.  Locking
         * auto-white balance after {@link #open()} but before the first call to
         * {@link #startPreview()} will not allow the auto-white balance routine
         * to run at all, and may result in severely incorrect color in captured
         * images.</p>
         *
         * @param toggle new state of the auto-white balance lock. True means
         *        that auto-white balance is locked, false means that the
         *        auto-white balance routine is free to run normally.
         *
         * @see #getAutoWhiteBalanceLock()
         * @see #setWhiteBalance(String)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.867 -0500", hash_original_method = "9FBB2F0BD63C7724B00563EB3EE35866", hash_generated_method = "B39630F479CD9B270B533C376699DBE3")
        
public void setAutoWhiteBalanceLock(boolean toggle) {
            set(KEY_AUTO_WHITEBALANCE_LOCK, toggle ? TRUE : FALSE);
        }

        /**
         * Gets the state of the auto-white balance lock. Applications should
         * check {@link #isAutoWhiteBalanceLockSupported} before using this
         * method. See {@link #setAutoWhiteBalanceLock} for details about the
         * lock.
         *
         * @return State of the auto-white balance lock. Returns true if
         *         auto-white balance is currently locked, and false
         *         otherwise.
         *
         * @see #setAutoWhiteBalanceLock(boolean)
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.870 -0500", hash_original_method = "DB49969BE763FDBEDE4F85AE81AF7414", hash_generated_method = "05BAAFB0D39E57854C84775B0D0A6AFE")
        
public boolean getAutoWhiteBalanceLock() {
            String str = get(KEY_AUTO_WHITEBALANCE_LOCK);
            return TRUE.equals(str);
        }

        /**
         * Returns true if auto-white balance locking is supported. Applications
         * should call this before trying to lock auto-white balance. See
         * {@link #setAutoWhiteBalanceLock} for details about the lock.
         *
         * @return true if auto-white balance lock is supported.
         * @see #setAutoWhiteBalanceLock(boolean)
         *
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.873 -0500", hash_original_method = "582DA557975EDBC4031144342808C588", hash_generated_method = "6573619E1D398E1635C8F9E4AD0A67FD")
        
public boolean isAutoWhiteBalanceLockSupported() {
            String str = get(KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED);
            return TRUE.equals(str);
        }

        /**
         * Gets current zoom value. This also works when smooth zoom is in
         * progress. Applications should check {@link #isZoomSupported} before
         * using this method.
         *
         * @return the current zoom value. The range is 0 to {@link
         *         #getMaxZoom}. 0 means the camera is not zoomed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.875 -0500", hash_original_method = "3CA678C8AE8E3F66428134128CE7EEC9", hash_generated_method = "6D30BEAF19965DB197F1AF9EBC491D4A")
        
public int getZoom() {
            return getInt(KEY_ZOOM, 0);
        }

        /**
         * Sets current zoom value. If the camera is zoomed (value > 0), the
         * actual picture size may be smaller than picture size setting.
         * Applications can check the actual picture size after picture is
         * returned from {@link PictureCallback}. The preview size remains the
         * same in zoom. Applications should check {@link #isZoomSupported}
         * before using this method.
         *
         * @param value zoom value. The valid range is 0 to {@link #getMaxZoom}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.878 -0500", hash_original_method = "4C7A1B4E8D019C0A8169E6EC8AF83500", hash_generated_method = "809429A3F9B65A95969FFFF807B2F0E6")
        
public void setZoom(int value) {
            set(KEY_ZOOM, value);
        }

        /**
         * Returns true if zoom is supported. Applications should call this
         * before using other zoom methods.
         *
         * @return true if zoom is supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.881 -0500", hash_original_method = "9BC52CB9DEDB85378C3A87D204A88D43", hash_generated_method = "98B2CF35010B673DD2533F885BD40C0A")
        
public boolean isZoomSupported() {
            String str = get(KEY_ZOOM_SUPPORTED);
            return TRUE.equals(str);
        }

        /**
         * Gets the maximum zoom value allowed for snapshot. This is the maximum
         * value that applications can set to {@link #setZoom(int)}.
         * Applications should call {@link #isZoomSupported} before using this
         * method. This value may change in different preview size. Applications
         * should call this again after setting preview size.
         *
         * @return the maximum zoom value supported by the camera.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.883 -0500", hash_original_method = "047686B9E00911FFF108E905AC4D01AC", hash_generated_method = "3A8D842E7721C072A7B76CF6D70330A0")
        
public int getMaxZoom() {
            return getInt(KEY_MAX_ZOOM, 0);
        }

        /**
         * Gets the zoom ratios of all zoom values. Applications should check
         * {@link #isZoomSupported} before using this method.
         *
         * @return the zoom ratios in 1/100 increments. Ex: a zoom of 3.2x is
         *         returned as 320. The number of elements is {@link
         *         #getMaxZoom} + 1. The list is sorted from small to large. The
         *         first element is always 100. The last element is the zoom
         *         ratio of the maximum zoom value.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.886 -0500", hash_original_method = "3F0D9961D3094722470195F17ED59ED1", hash_generated_method = "F67F8F8064995736DACE7B0A8038B37C")
        
public List<Integer> getZoomRatios() {
            return splitInt(get(KEY_ZOOM_RATIOS));
        }

        /**
         * Returns true if smooth zoom is supported. Applications should call
         * this before using other smooth zoom methods.
         *
         * @return true if smooth zoom is supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.889 -0500", hash_original_method = "A25EF2BBFA6ADFE30D398F5593DBFB40", hash_generated_method = "1C39E07151121CC4293A1DF1DF03DB42")
        
public boolean isSmoothZoomSupported() {
            String str = get(KEY_SMOOTH_ZOOM_SUPPORTED);
            return TRUE.equals(str);
        }

        /**
         * <p>Gets the distances from the camera to where an object appears to be
         * in focus. The object is sharpest at the optimal focus distance. The
         * depth of field is the far focus distance minus near focus distance.</p>
         *
         * <p>Focus distances may change after calling {@link
         * #autoFocus(AutoFocusCallback)}, {@link #cancelAutoFocus}, or {@link
         * #startPreview()}. Applications can call {@link #getParameters()}
         * and this method anytime to get the latest focus distances. If the
         * focus mode is FOCUS_MODE_CONTINUOUS_VIDEO, focus distances may change
         * from time to time.</p>
         *
         * <p>This method is intended to estimate the distance between the camera
         * and the subject. After autofocus, the subject distance may be within
         * near and far focus distance. However, the precision depends on the
         * camera hardware, autofocus algorithm, the focus area, and the scene.
         * The error can be large and it should be only used as a reference.</p>
         *
         * <p>Far focus distance >= optimal focus distance >= near focus distance.
         * If the focus distance is infinity, the value will be
         * {@code Float.POSITIVE_INFINITY}.</p>
         *
         * @param output focus distances in meters. output must be a float
         *        array with three elements. Near focus distance, optimal focus
         *        distance, and far focus distance will be filled in the array.
         * @see #FOCUS_DISTANCE_NEAR_INDEX
         * @see #FOCUS_DISTANCE_OPTIMAL_INDEX
         * @see #FOCUS_DISTANCE_FAR_INDEX
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.892 -0500", hash_original_method = "DB1A67BAD99765C9966F6C6DFD16815F", hash_generated_method = "B3D9189E0F2A9A031717A0AB34D8B08B")
        
public void getFocusDistances(float[] output) {
            if (output == null || output.length != 3) {
                throw new IllegalArgumentException(
                        "output must be an float array with three elements.");
            }
            splitFloat(get(KEY_FOCUS_DISTANCES), output);
        }

        /**
         * Gets the maximum number of focus areas supported. This is the maximum
         * length of the list in {@link #setFocusAreas(List)} and
         * {@link #getFocusAreas()}.
         *
         * @return the maximum number of focus areas supported by the camera.
         * @see #getFocusAreas()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.894 -0500", hash_original_method = "B9C518AE022CEE0A2E16335F0D4F42AA", hash_generated_method = "A230E4F6004AD9F358682A9EC42DF8B0")
        
public int getMaxNumFocusAreas() {
            return getInt(KEY_MAX_NUM_FOCUS_AREAS, 0);
        }

        /**
         * <p>Gets the current focus areas. Camera driver uses the areas to decide
         * focus.</p>
         *
         * <p>Before using this API or {@link #setFocusAreas(List)}, apps should
         * call {@link #getMaxNumFocusAreas()} to know the maximum number of
         * focus areas first. If the value is 0, focus area is not supported.</p>
         *
         * <p>Each focus area is a rectangle with specified weight. The direction
         * is relative to the sensor orientation, that is, what the sensor sees.
         * The direction is not affected by the rotation or mirroring of
         * {@link #setDisplayOrientation(int)}. Coordinates of the rectangle
         * range from -1000 to 1000. (-1000, -1000) is the upper left point.
         * (1000, 1000) is the lower right point. The width and height of focus
         * areas cannot be 0 or negative.</p>
         *
         * <p>The weight must range from 1 to 1000. The weight should be
         * interpreted as a per-pixel weight - all pixels in the area have the
         * specified weight. This means a small area with the same weight as a
         * larger area will have less influence on the focusing than the larger
         * area. Focus areas can partially overlap and the driver will add the
         * weights in the overlap region.</p>
         *
         * <p>A special case of a {@code null} focus area list means the driver is
         * free to select focus targets as it wants. For example, the driver may
         * use more signals to select focus areas and change them
         * dynamically. Apps can set the focus area list to {@code null} if they
         * want the driver to completely control focusing.</p>
         *
         * <p>Focus areas are relative to the current field of view
         * ({@link #getZoom()}). No matter what the zoom level is, (-1000,-1000)
         * represents the top of the currently visible camera frame. The focus
         * area cannot be set to be outside the current field of view, even
         * when using zoom.</p>
         *
         * <p>Focus area only has effect if the current focus mode is
         * {@link #FOCUS_MODE_AUTO}, {@link #FOCUS_MODE_MACRO},
         * {@link #FOCUS_MODE_CONTINUOUS_VIDEO}, or
         * {@link #FOCUS_MODE_CONTINUOUS_PICTURE}.</p>
         *
         * @return a list of current focus areas
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.897 -0500", hash_original_method = "1F7F1457F62663F3FBD9FCD39F49FAC0", hash_generated_method = "92A35D538949BD35F19D090AD392FD32")
        
public List<Area> getFocusAreas() {
            return splitArea(get(KEY_FOCUS_AREAS));
        }

        /**
         * Sets focus areas. See {@link #getFocusAreas()} for documentation.
         *
         * @param focusAreas the focus areas
         * @see #getFocusAreas()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.901 -0500", hash_original_method = "282CBAFBAC13AEC2BEC36481C427E569", hash_generated_method = "C3D1760DB5A86F79D064AC4A5C13B872")
        
public void setFocusAreas(List<Area> focusAreas) {
            set(KEY_FOCUS_AREAS, focusAreas);
        }

        /**
         * Gets the maximum number of metering areas supported. This is the
         * maximum length of the list in {@link #setMeteringAreas(List)} and
         * {@link #getMeteringAreas()}.
         *
         * @return the maximum number of metering areas supported by the camera.
         * @see #getMeteringAreas()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.903 -0500", hash_original_method = "A4B96F518C484696647FE84A6B3DFFDC", hash_generated_method = "1E7CBB1A1D4C9EE3513A78F9CE481888")
        
public int getMaxNumMeteringAreas() {
            return getInt(KEY_MAX_NUM_METERING_AREAS, 0);
        }

        /**
         * <p>Gets the current metering areas. Camera driver uses these areas to
         * decide exposure.</p>
         *
         * <p>Before using this API or {@link #setMeteringAreas(List)}, apps should
         * call {@link #getMaxNumMeteringAreas()} to know the maximum number of
         * metering areas first. If the value is 0, metering area is not
         * supported.</p>
         *
         * <p>Each metering area is a rectangle with specified weight. The
         * direction is relative to the sensor orientation, that is, what the
         * sensor sees. The direction is not affected by the rotation or
         * mirroring of {@link #setDisplayOrientation(int)}. Coordinates of the
         * rectangle range from -1000 to 1000. (-1000, -1000) is the upper left
         * point. (1000, 1000) is the lower right point. The width and height of
         * metering areas cannot be 0 or negative.</p>
         *
         * <p>The weight must range from 1 to 1000, and represents a weight for
         * every pixel in the area. This means that a large metering area with
         * the same weight as a smaller area will have more effect in the
         * metering result.  Metering areas can partially overlap and the driver
         * will add the weights in the overlap region.</p>
         *
         * <p>A special case of a {@code null} metering area list means the driver
         * is free to meter as it chooses. For example, the driver may use more
         * signals to select metering areas and change them dynamically. Apps
         * can set the metering area list to {@code null} if they want the
         * driver to completely control metering.</p>
         *
         * <p>Metering areas are relative to the current field of view
         * ({@link #getZoom()}). No matter what the zoom level is, (-1000,-1000)
         * represents the top of the currently visible camera frame. The
         * metering area cannot be set to be outside the current field of view,
         * even when using zoom.</p>
         *
         * <p>No matter what metering areas are, the final exposure are compensated
         * by {@link #setExposureCompensation(int)}.</p>
         *
         * @return a list of current metering areas
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.906 -0500", hash_original_method = "4184DAADE6BD6ABC78AAB559556E3679", hash_generated_method = "8377C8001BBA4F651374F15163D6B253")
        
public List<Area> getMeteringAreas() {
            return splitArea(get(KEY_METERING_AREAS));
        }

        /**
         * Sets metering areas. See {@link #getMeteringAreas()} for
         * documentation.
         *
         * @param meteringAreas the metering areas
         * @see #getMeteringAreas()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.908 -0500", hash_original_method = "EDE536DB365D3616ED4EF1065A695BCF", hash_generated_method = "A77AE423EE815FD593F476FD2570F0D5")
        
public void setMeteringAreas(List<Area> meteringAreas) {
            set(KEY_METERING_AREAS, meteringAreas);
        }

        /**
         * Gets the maximum number of detected faces supported. This is the
         * maximum length of the list returned from {@link FaceDetectionListener}.
         * If the return value is 0, face detection of the specified type is not
         * supported.
         *
         * @return the maximum number of detected face supported by the camera.
         * @see #startFaceDetection()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.911 -0500", hash_original_method = "A3F920DAF0FA1FD5B4F8D56BF37CB7C9", hash_generated_method = "3114AB9CDDAC5353B5544B55C1B4EEEA")
        
public int getMaxNumDetectedFaces() {
            return getInt(KEY_MAX_NUM_DETECTED_FACES_HW, 0);
        }

        /**
         * Sets recording mode hint. This tells the camera that the intent of
         * the application is to record videos {@link
         * android.media.MediaRecorder#start()}, not to take still pictures
         * {@link #takePicture(Camera.ShutterCallback, Camera.PictureCallback,
         * Camera.PictureCallback, Camera.PictureCallback)}. Using this hint can
         * allow MediaRecorder.start() to start faster or with fewer glitches on
         * output. This should be called before starting preview for the best
         * result, but can be changed while the preview is active. The default
         * value is false.
         *
         * The app can still call takePicture() when the hint is true or call
         * MediaRecorder.start() when the hint is false. But the performance may
         * be worse.
         *
         * @param hint true if the apps intend to record videos using
         *             {@link android.media.MediaRecorder}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.914 -0500", hash_original_method = "77706BF984161454A07D20CFA20843D2", hash_generated_method = "AC1CA2DC1F6BEF7C047960161D7D51F1")
        
public void setRecordingHint(boolean hint) {
            set(KEY_RECORDING_HINT, hint ? TRUE : FALSE);
        }

        /**
         * Returns true if video snapshot is supported. That is, applications
         * can call {@link #takePicture(Camera.ShutterCallback,
         * Camera.PictureCallback, Camera.PictureCallback, Camera.PictureCallback)}
         * during recording. Applications do not need to call {@link
         * #startPreview()} after taking a picture. The preview will be still
         * active. Other than that, taking a picture during recording is
         * identical to taking a picture normally. All settings and methods
         * related to takePicture work identically. Ex: {@link
         * #getPictureSize()}, {@link #getSupportedPictureSizes()}, {@link
         * #setJpegQuality(int)}, {@link #setRotation(int)}, and etc. The
         * picture will have an EXIF header. {@link #FLASH_MODE_AUTO} and {@link
         * #FLASH_MODE_ON} also still work, but the video will record the flash.
         *
         * Applications can set shutter callback as null to avoid the shutter
         * sound. It is also recommended to set raw picture and post view
         * callbacks to null to avoid the interrupt of preview display.
         *
         * Field-of-view of the recorded video may be different from that of the
         * captured pictures.
         *
         * @return true if video snapshot is supported.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.917 -0500", hash_original_method = "0F8567B579C137B716477627D7F3A934", hash_generated_method = "2A0CEBF0D7759CAEDC9E17DC6CAF0993")
        
public boolean isVideoSnapshotSupported() {
            String str = get(KEY_VIDEO_SNAPSHOT_SUPPORTED);
            return TRUE.equals(str);
        }

        /**
         * <p>Enables and disables video stabilization. Use
         * {@link #isVideoStabilizationSupported} to determine if calling this
         * method is valid.</p>
         *
         * <p>Video stabilization reduces the shaking due to the motion of the
         * camera in both the preview stream and in recorded videos, including
         * data received from the preview callback. It does not reduce motion
         * blur in images captured with
         * {@link Camera#takePicture takePicture}.</p>
         *
         * <p>Video stabilization can be enabled and disabled while preview or
         * recording is active, but toggling it may cause a jump in the video
         * stream that may be undesirable in a recorded video.</p>
         *
         * @param toggle Set to true to enable video stabilization, and false to
         * disable video stabilization.
         * @see #isVideoStabilizationSupported()
         * @see #getVideoStabilization()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.919 -0500", hash_original_method = "9F60C08F2ED5DD6FF6AE5E03CD68E34B", hash_generated_method = "047EF69BB2F5615B6406A11E040D9922")
        
public void setVideoStabilization(boolean toggle) {
            set(KEY_VIDEO_STABILIZATION, toggle ? TRUE : FALSE);
        }

        /**
         * Get the current state of video stabilization. See
         * {@link #setVideoStabilization} for details of video stabilization.
         *
         * @return true if video stabilization is enabled
         * @see #isVideoStabilizationSupported()
         * @see #setVideoStabilization(boolean)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.923 -0500", hash_original_method = "206980091DCF06EE02F8F95474290B64", hash_generated_method = "8F88BB22621EFC71E6A9431C87163017")
        
public boolean getVideoStabilization() {
            String str = get(KEY_VIDEO_STABILIZATION);
            return TRUE.equals(str);
        }

        /**
         * Returns true if video stabilization is supported. See
         * {@link #setVideoStabilization} for details of video stabilization.
         *
         * @return true if video stabilization is supported
         * @see #setVideoStabilization(boolean)
         * @see #getVideoStabilization()
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.925 -0500", hash_original_method = "7565DC492C39C0F6D368D835BD28A381", hash_generated_method = "6786179B938DFDBC6BDB28B183BB7E3D")
        
public boolean isVideoStabilizationSupported() {
            String str = get(KEY_VIDEO_STABILIZATION_SUPPORTED);
            return TRUE.equals(str);
        }

        // Splits a comma delimited string to an ArrayList of String.
        // Return null if the passing string is null or the size is 0.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.928 -0500", hash_original_method = "7DB6EA73F79E9017B4C9B1640096A943", hash_generated_method = "0D8DCB1AAF5E839228276128672C8C75")
        
private ArrayList<String> split(String str) {
            if (str == null) return null;

            // Use StringTokenizer because it is faster than split.
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<String> substrings = new ArrayList<String>();
            while (tokenizer.hasMoreElements()) {
                substrings.add(tokenizer.nextToken());
            }
            return substrings;
        }

        // Splits a comma delimited string to an ArrayList of Integer.
        // Return null if the passing string is null or the size is 0.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.931 -0500", hash_original_method = "5A3E8F077877CF7C521516BE6C2EF1CA", hash_generated_method = "444925080B91C9CC89AD2800BB9FDD59")
        
private ArrayList<Integer> splitInt(String str) {
            if (str == null) return null;

            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<Integer> substrings = new ArrayList<Integer>();
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                substrings.add(Integer.parseInt(token));
            }
            if (substrings.size() == 0) return null;
            return substrings;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.934 -0500", hash_original_method = "DBE0F4460205976847C38EA4BE2E4232", hash_generated_method = "0D65FA305A7E967CD5AEA8B82CEB99F6")
        
private void splitInt(String str, int[] output) {
            if (str == null) return;

            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            int index = 0;
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                output[index++] = Integer.parseInt(token);
            }
        }

        // Splits a comma delimited string to an ArrayList of Float.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.936 -0500", hash_original_method = "2EDF646B69F6A8ADE910B245928A49CF", hash_generated_method = "C593531974FDF451852FDB4663CE8C9F")
        
private void splitFloat(String str, float[] output) {
            if (str == null) return;

            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            int index = 0;
            while (tokenizer.hasMoreElements()) {
                String token = tokenizer.nextToken();
                output[index++] = Float.parseFloat(token);
            }
        }

        // Returns the value of a float parameter.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.939 -0500", hash_original_method = "32BB9C0678FCAB5D5E885CB3C8B58074", hash_generated_method = "842D6C1BAD35E2DE74B670A329B8B0A5")
        
private float getFloat(String key, float defaultValue) {
            try {
                return Float.parseFloat(mMap.get(key));
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }

        // Returns the value of a integer parameter.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.942 -0500", hash_original_method = "E02D965FA231D61DD75FA13C6C4B926A", hash_generated_method = "F05C1AA206ED22549A9B8AD0551802DB")
        
private int getInt(String key, int defaultValue) {
            try {
                return Integer.parseInt(mMap.get(key));
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }

        // Splits a comma delimited string to an ArrayList of Size.
        // Return null if the passing string is null or the size is 0.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.944 -0500", hash_original_method = "E566E7E786C257334A0A0BEDDD18D728", hash_generated_method = "F791113D7F5DEBDFF24B54131C8E0BFC")
        
private ArrayList<Size> splitSize(String str) {
            if (str == null) return null;

            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<Size> sizeList = new ArrayList<Size>();
            while (tokenizer.hasMoreElements()) {
                Size size = strToSize(tokenizer.nextToken());
                if (size != null) sizeList.add(size);
            }
            if (sizeList.size() == 0) return null;
            return sizeList;
        }

        // Parses a string (ex: "480x320") to Size object.
        // Return null if the passing string is null.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.947 -0500", hash_original_method = "864DD200C5D193B819BF575556422CF5", hash_generated_method = "5CA96F42563374110E045D0E89BAC229")
        
private Size strToSize(String str) {
            if (str == null) return null;

            int pos = str.indexOf('x');
            if (pos != -1) {
                String width = str.substring(0, pos);
                String height = str.substring(pos + 1);
                return new Size(Integer.parseInt(width),
                                Integer.parseInt(height));
            }
            Log.e(TAG, "Invalid size parameter string=" + str);
            return null;
        }

        // Splits a comma delimited string to an ArrayList of int array.
        // Example string: "(10000,26623),(10000,30000)". Return null if the
        // passing string is null or the size is 0.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.950 -0500", hash_original_method = "F39DEDF83E61AF664CA09AF99218A1A8", hash_generated_method = "408DC1C554049C0055201E759DF14B68")
        
private ArrayList<int[]> splitRange(String str) {
            if (str == null || str.charAt(0) != '('
                    || str.charAt(str.length() - 1) != ')') {
                Log.e(TAG, "Invalid range list string=" + str);
                return null;
            }

            ArrayList<int[]> rangeList = new ArrayList<int[]>();
            int endIndex, fromIndex = 1;
            do {
                int[] range = new int[2];
                endIndex = str.indexOf("),(", fromIndex);
                if (endIndex == -1) endIndex = str.length() - 1;
                splitInt(str.substring(fromIndex, endIndex), range);
                rangeList.add(range);
                fromIndex = endIndex + 3;
            } while (endIndex != str.length() - 1);

            if (rangeList.size() == 0) return null;
            return rangeList;
        }

        // Splits a comma delimited string to an ArrayList of Area objects.
        // Example string: "(-10,-10,0,0,300),(0,0,10,10,700)". Return null if
        // the passing string is null or the size is 0 or (0,0,0,0,0).
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.953 -0500", hash_original_method = "9274EBB4EF409FF45187E570A4176C77", hash_generated_method = "7E3376C648E9E400FDA2025594C8EB4A")
        
private ArrayList<Area> splitArea(String str) {
            if (str == null || str.charAt(0) != '('
                    || str.charAt(str.length() - 1) != ')') {
                Log.e(TAG, "Invalid area string=" + str);
                return null;
            }

            ArrayList<Area> result = new ArrayList<Area>();
            int endIndex, fromIndex = 1;
            int[] array = new int[5];
            do {
                endIndex = str.indexOf("),(", fromIndex);
                if (endIndex == -1) endIndex = str.length() - 1;
                splitInt(str.substring(fromIndex, endIndex), array);
                Rect rect = new Rect(array[0], array[1], array[2], array[3]);
                result.add(new Area(rect, array[4]));
                fromIndex = endIndex + 3;
            } while (endIndex != str.length() - 1);

            if (result.size() == 0) return null;

            if (result.size() == 1) {
                Area area = result.get(0);
                Rect rect = area.rect;
                if (rect.left == 0 && rect.top == 0 && rect.right == 0
                        && rect.bottom == 0 && area.weight == 0) {
                    return null;
                }
            }

            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.956 -0500", hash_original_method = "B277D938849565024C8C9B7FCA3C644C", hash_generated_method = "ECC08C172A9A23F03C37664075F521D5")
        
private boolean same(String s1, String s2) {
            if (s1 == null && s2 == null) return true;
            if (s1 != null && s1.equals(s2)) return true;
            return false;
        }
    }


    
    public interface PreviewCallback
    {
        
        void onPreviewFrame(byte[] data, Camera camera);
    }
    
    public interface AutoFocusCallback
    {
        
        void onAutoFocus(boolean success, Camera camera);
    }
    
    public interface ShutterCallback
    {
        
        void onShutter();
    }
    
    public interface PictureCallback {
        
        void onPictureTaken(byte[] data, Camera camera);
    }
    
    public interface OnZoomChangeListener
    {
        
        void onZoomChange(int zoomValue, boolean stopped, Camera camera);
    }
    
    public interface FaceDetectionListener
    {
        
        void onFaceDetection(Face[] faces, Camera camera);
    }
    
    public interface ErrorCallback
    {
        
        void onError(int error, Camera camera);
    }

    /**
     * Cancels any auto-focus function in progress.
     * Whether or not auto-focus is currently in progress,
     * this function will return the focus position to the default.
     * If the camera does not support auto-focus, this is a no-op.
     *
     * @see #autoFocus(Camera.AutoFocusCallback)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.103 -0500", hash_original_method = "2EF0F393A3D655AFB514BFE787466093", hash_generated_method = "9BBCA5F1368C0129438B0C03CF2B16E1")
    
public final void cancelAutoFocus()
    {
        mAutoFocusCallback = null;
        native_cancelAutoFocus();
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.109 -0500", hash_original_method = "627E1E0A1BA298FD1B675A29D70F6408", hash_generated_method = "0B9EB2ADB27936076B423CACE0255EBE")
    
    private final void native_cancelAutoFocus(){
    	//Formerly a native method
    }


    /**
     * Equivalent to takePicture(shutter, raw, null, jpeg).
     *
     * @see #takePicture(ShutterCallback, PictureCallback, PictureCallback, PictureCallback)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.123 -0500", hash_original_method = "C601C1FA969C1E17CA36D3767A4885D3", hash_generated_method = "EA36C589A809EACEC2FC187BEE5DD428")
    
public final void takePicture(ShutterCallback shutter, PictureCallback raw,
            PictureCallback jpeg) {
        takePicture(shutter, raw, null, jpeg);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.130 -0500", hash_original_method = "9DA1D6832E2DF57D49D73BC5F1630045", hash_generated_method = "BBC27BBD94E08B48D8758C1A6E326374")
    
    private final void native_takePicture(int msgType){
    	//Formerly a native method
    	addTaint(msgType);
    }


    /**
     * Triggers an asynchronous image capture. The camera service will initiate
     * a series of callbacks to the application as the image capture progresses.
     * The shutter callback occurs after the image is captured. This can be used
     * to trigger a sound to let the user know that image has been captured. The
     * raw callback occurs when the raw image data is available (NOTE: the data
     * will be null if there is no raw image callback buffer available or the
     * raw image callback buffer is not large enough to hold the raw image).
     * The postview callback occurs when a scaled, fully processed postview
     * image is available (NOTE: not all hardware supports this). The jpeg
     * callback occurs when the compressed image is available. If the
     * application does not need a particular callback, a null can be passed
     * instead of a callback method.
     *
     * <p>This method is only valid when preview is active (after
     * {@link #startPreview()}).  Preview will be stopped after the image is
     * taken; callers must call {@link #startPreview()} again if they want to
     * re-start preview or take more pictures. This should not be called between
     * {@link android.media.MediaRecorder#start()} and
     * {@link android.media.MediaRecorder#stop()}.
     *
     * <p>After calling this method, you must not call {@link #startPreview()}
     * or take another picture until the JPEG callback has returned.
     *
     * @param shutter   the callback for image capture moment, or null
     * @param raw       the callback for raw (uncompressed) image data, or null
     * @param postview  callback with postview image data, may be null
     * @param jpeg      the callback for JPEG image data, or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.135 -0500", hash_original_method = "A653181D2B77C1AA9A58A11AAAA145B5", hash_generated_method = "6F225A00AB5ED66CF435DD59A9A26BCE")
    
public final void takePicture(ShutterCallback shutter, PictureCallback raw,
            PictureCallback postview, PictureCallback jpeg) {
        mShutterCallback = shutter;
        mRawImageCallback = raw;
        mPostviewCallback = postview;
        mJpegCallback = jpeg;

        // If callback is not set, do not send me callbacks.
        int msgType = 0;
        if (mShutterCallback != null) {
            msgType |= CAMERA_MSG_SHUTTER;
        }
        if (mRawImageCallback != null) {
            msgType |= CAMERA_MSG_RAW_IMAGE;
        }
        if (mPostviewCallback != null) {
            msgType |= CAMERA_MSG_POSTVIEW_FRAME;
        }
        if (mJpegCallback != null) {
            msgType |= CAMERA_MSG_COMPRESSED_IMAGE;
        }

        native_takePicture(msgType);
    }

    /**
     * Zooms to the requested value smoothly. The driver will notify {@link
     * OnZoomChangeListener} of the zoom value and whether zoom is stopped at
     * the time. For example, suppose the current zoom is 0 and startSmoothZoom
     * is called with value 3. The
     * {@link Camera.OnZoomChangeListener#onZoomChange(int, boolean, Camera)}
     * method will be called three times with zoom values 1, 2, and 3.
     * Applications can call {@link #stopSmoothZoom} to stop the zoom earlier.
     * Applications should not call startSmoothZoom again or change the zoom
     * value before zoom stops. If the supplied zoom value equals to the current
     * zoom value, no zoom callback will be generated. This method is supported
     * if {@link android.hardware.Camera.Parameters#isSmoothZoomSupported}
     * returns true.
     *
     * @param value zoom value. The valid range is 0 to {@link
     *              android.hardware.Camera.Parameters#getMaxZoom}.
     * @throws IllegalArgumentException if the zoom value is invalid.
     * @throws RuntimeException if the method fails.
     * @see #setZoomChangeListener(OnZoomChangeListener)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.142 -0500", hash_original_method = "CB85955AE7ECC872C16FD259F78D1283", hash_generated_method = "B04ACCE23970D05D0A5A39958119B987")
    
    public final void startSmoothZoom(int value){
    	//Formerly a native method
    	addTaint(value);
    }


    /**
     * Stops the smooth zoom. Applications should wait for the {@link
     * OnZoomChangeListener} to know when the zoom is actually stopped. This
     * method is supported if {@link
     * android.hardware.Camera.Parameters#isSmoothZoomSupported} is true.
     *
     * @throws RuntimeException if the method fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.149 -0500", hash_original_method = "6E23FCC9E3F0853162C9ABD237B3E263", hash_generated_method = "39DA8C0AC5375B23BA5430DAFB55FE8E")
    
    public final void stopSmoothZoom(){
    	//Formerly a native method
    }


    /**
     * Set the clockwise rotation of preview display in degrees. This affects
     * the preview frames and the picture displayed after snapshot. This method
     * is useful for portrait mode applications. Note that preview display of
     * front-facing cameras is flipped horizontally before the rotation, that
     * is, the image is reflected along the central vertical axis of the camera
     * sensor. So the users can see themselves as looking into a mirror.
     *
     * <p>This does not affect the order of byte array passed in {@link
     * PreviewCallback#onPreviewFrame}, JPEG pictures, or recorded videos. This
     * method is not allowed to be called during preview.
     *
     * <p>If you want to make the camera image show in the same orientation as
     * the display, you can use the following code.
     * <pre>
     * public static void setCameraDisplayOrientation(Activity activity,
     *         int cameraId, android.hardware.Camera camera) {
     *     android.hardware.Camera.CameraInfo info =
     *             new android.hardware.Camera.CameraInfo();
     *     android.hardware.Camera.getCameraInfo(cameraId, info);
     *     int rotation = activity.getWindowManager().getDefaultDisplay()
     *             .getRotation();
     *     int degrees = 0;
     *     switch (rotation) {
     *         case Surface.ROTATION_0: degrees = 0; break;
     *         case Surface.ROTATION_90: degrees = 90; break;
     *         case Surface.ROTATION_180: degrees = 180; break;
     *         case Surface.ROTATION_270: degrees = 270; break;
     *     }
     *
     *     int result;
     *     if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
     *         result = (info.orientation + degrees) % 360;
     *         result = (360 - result) % 360;  // compensate the mirror
     *     } else {  // back-facing
     *         result = (info.orientation - degrees + 360) % 360;
     *     }
     *     camera.setDisplayOrientation(result);
     * }
     * </pre>
     *
     * <p>Starting from API level 14, this method can be called when preview is
     * active.
     *
     * @param degrees the angle that the picture will be rotated clockwise.
     *                Valid values are 0, 90, 180, and 270. The starting
     *                position is 0 (landscape).
     * @see #setPreviewDisplay(SurfaceHolder)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.156 -0500", hash_original_method = "4194592279C5F487807EC326C09E0EDE", hash_generated_method = "DC9DF9A8B6356F0DFB9E48FFC5E87F4D")
    
    public final void setDisplayOrientation(int degrees){
    	//Formerly a native method
    	addTaint(degrees);
    }


    /**
     * Registers a listener to be notified when the zoom value is updated by the
     * camera driver during smooth zoom.
     *
     * @param listener the listener to notify
     * @see #startSmoothZoom(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.163 -0500", hash_original_method = "6480531FCD656465921BBC33792E6355", hash_generated_method = "398559D7AC1FBABA3FD815E8FC745967")
    
public final void setZoomChangeListener(OnZoomChangeListener listener)
    {
        mZoomListener = listener;
    }

    /**
     * Registers a listener to be notified about the faces detected in the
     * preview frame.
     *
     * @param listener the listener to notify
     * @see #startFaceDetection()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.168 -0500", hash_original_method = "72125974AAC05BF0DED9497DD0672E75", hash_generated_method = "6879C994282C7BBE6C99285B62AC2B6A")
    
public final void setFaceDetectionListener(FaceDetectionListener listener)
    {
        mFaceListener = listener;
    }

    /**
     * Starts the face detection. This should be called after preview is started.
     * The camera will notify {@link FaceDetectionListener} of the detected
     * faces in the preview frame. The detected faces may be the same as the
     * previous ones. Applications should call {@link #stopFaceDetection} to
     * stop the face detection. This method is supported if {@link
     * Parameters#getMaxNumDetectedFaces()} returns a number larger than 0.
     * If the face detection has started, apps should not call this again.
     *
     * <p>When the face detection is running, {@link Parameters#setWhiteBalance(String)},
     * {@link Parameters#setFocusAreas(List)}, and {@link Parameters#setMeteringAreas(List)}
     * have no effect. The camera uses the detected faces to do auto-white balance,
     * auto exposure, and autofocus.
     *
     * <p>If the apps call {@link #autoFocus(AutoFocusCallback)}, the camera
     * will stop sending face callbacks. The last face callback indicates the
     * areas used to do autofocus. After focus completes, face detection will
     * resume sending face callbacks. If the apps call {@link
     * #cancelAutoFocus()}, the face callbacks will also resume.</p>
     *
     * <p>After calling {@link #takePicture(Camera.ShutterCallback, Camera.PictureCallback,
     * Camera.PictureCallback)} or {@link #stopPreview()}, and then resuming
     * preview with {@link #startPreview()}, the apps should call this method
     * again to resume face detection.</p>
     *
     * @throws IllegalArgumentException if the face detection is unsupported.
     * @throws RuntimeException if the method fails or the face detection is
     *         already running.
     * @see FaceDetectionListener
     * @see #stopFaceDetection()
     * @see Parameters#getMaxNumDetectedFaces()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.171 -0500", hash_original_method = "589FE294AB7893E2AD7EE0261AFFC1FF", hash_generated_method = "05FCAE5AB5F4D075CCF21749CB9F8BB0")
    
public final void startFaceDetection() {
        if (mFaceDetectionRunning) {
            throw new RuntimeException("Face detection is already running");
        }
        _startFaceDetection(CAMERA_FACE_DETECTION_HW);
        mFaceDetectionRunning = true;
    }

    /**
     * Stops the face detection.
     *
     * @see #startFaceDetection()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.174 -0500", hash_original_method = "1658BFC488D62D85A32E58C8EE9C8382", hash_generated_method = "8347A4DA154B45F3C921DE106FFFF4F4")
    
public final void stopFaceDetection() {
        _stopFaceDetection();
        mFaceDetectionRunning = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.178 -0500", hash_original_method = "44CAC56F9FD022B772605806F720BF7E", hash_generated_method = "C7E6262EF7BA0CF7A91FBC6CD42CAEAF")
    
    private final void _startFaceDetection(int type){
    	//Formerly a native method
    	addTaint(type);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.182 -0500", hash_original_method = "A44256EE80ABD488101E1B754E2222A4", hash_generated_method = "0433152B56851AE82550BC75B8E92751")
    
    private final void _stopFaceDetection(){
    	//Formerly a native method
    }


    /**
     * Registers a callback to be invoked when an error occurs.
     * @param cb The callback to run
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.220 -0500", hash_original_method = "BE99CE61E82474B676C6D48791CDF52E", hash_generated_method = "E8F9DCE0049C9BD39A9C9C4CBACE5946")
    
public final void setErrorCallback(ErrorCallback cb)
    {
        mErrorCallback = cb;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.224 -0500", hash_original_method = "62874E13510D0FD5D23BE793A7BF66C4", hash_generated_method = "B96917EBD7D1653FC025DB4499DC22AA")
    
    private final void native_setParameters(String params){
    	//Formerly a native method
    	addTaint(params.getTaint());
    }


    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.245 -0400", hash_original_method = "3CEFEC9BC04BFA67886C8721C375B2BF", hash_generated_method = "7CDFCD53AAB21A45E6D03778B4CC52A9")
    private final String native_getParameters() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    /**
     * Changes the settings for this Camera service.
     *
     * @param params the Parameters to use for this Camera service
     * @throws RuntimeException if any parameter is invalid or not supported.
     * @see #getParameters()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.231 -0500", hash_original_method = "626488C7E8947ED02FA722E13C8A89F1", hash_generated_method = "504C86AD096C8F6E5F3DAD232986015D")
    
public void setParameters(Parameters params) {
        native_setParameters(params.flatten());
    }

    /**
     * Returns the current settings for this Camera service.
     * If modifications are made to the returned Parameters, they must be passed
     * to {@link #setParameters(Camera.Parameters)} to take effect.
     *
     * @see #setParameters(Camera.Parameters)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:55.233 -0500", hash_original_method = "5DDAD998A9057F14B2A0711CFDC833B3", hash_generated_method = "07CF34F07E8C2D025541953C51E476D3")
    
public Parameters getParameters() {
        Parameters p = new Parameters();
        String s = native_getParameters();
        p.unflatten(s);
        return p;
    }
}

