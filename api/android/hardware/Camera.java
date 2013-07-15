package android.hardware;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Camera {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.223 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "2A143FC2E147E1EC62176406FA59CB8A", hash_generated_field = "D009E04C803F5D76BAB1D3969A4463B9")

    private ShutterCallback mShutterCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "E0313B6812F2892683FB042963EC4D7C", hash_generated_field = "19A070C045E003058CB192AE3163D351")

    private PictureCallback mRawImageCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "E2B815A042551A68A2B8B881CD79BD0B", hash_generated_field = "1BA267B982566E41875431F7773841F4")

    private PictureCallback mJpegCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "4B7016678916368676CF391DF81EA0FA", hash_generated_field = "778F38A24844833E46C1979570DC1E50")

    private PreviewCallback mPreviewCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "9A3B76E87BAA15646EF933FC3F7DF039", hash_generated_field = "ECFD4AA8B611C615D3B911048EAEB57B")

    private PictureCallback mPostviewCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "2100749285D01F11099290A77DB05A04", hash_generated_field = "A4A4C6811EE167B308393226F4E8B402")

    private AutoFocusCallback mAutoFocusCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "F7EE5951C5890C7385245537302DC446", hash_generated_field = "6526D6B6F8D2DB99A1A016F005A8C367")

    private OnZoomChangeListener mZoomListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "5EAA3869B1B61D3ADA3BC55CAA7739AB", hash_generated_field = "2E6A5285613B44B8FED63E54A4AEE629")

    private FaceDetectionListener mFaceListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "A2AED1B3A262AF1E8391B7FFF1C1D98F", hash_generated_field = "C0DACDDFAA2BE6B21362B18164C095DF")

    private ErrorCallback mErrorCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "BFA6EEFE0C30E0A93CA19234400247B7", hash_generated_field = "90E32900694EFB9D3548ACF4940301BF")

    private boolean mOneShot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.224 -0400", hash_original_field = "BBA773760660344CB5D6974B3E033CEF", hash_generated_field = "56579DD297763A4F71BB0065F0275C33")

    private boolean mWithBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.225 -0400", hash_original_field = "EA8D9C994CB84D827E80119BBE281E35", hash_generated_field = "520274A32C7AFB94A6468A258B55BD75")

    private boolean mFaceDetectionRunning = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.226 -0400", hash_original_method = "49A6C7700AD76B9B3871368B13D8BEFB", hash_generated_method = "AC1F82E33ED01046C9D11E858A80A309")
      Camera(int cameraId) {
        addTaint(cameraId);
        mShutterCallback = null;
        mRawImageCallback = null;
        mJpegCallback = null;
        mPreviewCallback = null;
        mPostviewCallback = null;
        mZoomListener = null;
        Looper looper;
    if((looper = Looper.myLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
    if((looper = Looper.getMainLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
        {
            mEventHandler = null;
        } //End block
        native_setup(new WeakReference<Camera>(this), cameraId);
        // ---------- Original Method ----------
        //mShutterCallback = null;
        //mRawImageCallback = null;
        //mJpegCallback = null;
        //mPreviewCallback = null;
        //mPostviewCallback = null;
        //mZoomListener = null;
        //Looper looper;
        //if ((looper = Looper.myLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else if ((looper = Looper.getMainLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else {
            //mEventHandler = null;
        //}
        //native_setup(new WeakReference<Camera>(this), cameraId);
    }

    
    public static int getNumberOfCameras() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962180813 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962180813;
    }

    
    public static void getCameraInfo(int cameraId, CameraInfo cameraInfo) {
    }

    
        public static Camera open(int cameraId) {
        return new Camera(cameraId);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.228 -0400", hash_original_method = "52F53B59AD091F99DC7C4D49031A27E5", hash_generated_method = "8FAC9FF85A1EF0848C18BB309D51EC09")
    protected void finalize() {
        release();
        // ---------- Original Method ----------
        //release();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.228 -0400", hash_original_method = "5EC3DC8FB8D66F2C808C7799A0BBD6C8", hash_generated_method = "7A2CAC3C88EAC4EF88983C193D49A66B")
    private final void native_setup(Object camera_this, int cameraId) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.229 -0400", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "DECB120BA12617A8FCE4E151C1A70393")
    private final void native_release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.229 -0400", hash_original_method = "4B0BDA2F6C7B983609E1F519CAFAFE92", hash_generated_method = "7B90471909AB0590E05CC6809E026943")
    public final void release() {
        native_release();
        mFaceDetectionRunning = false;
        // ---------- Original Method ----------
        //native_release();
        //mFaceDetectionRunning = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.229 -0400", hash_original_method = "9CD4FD3F3067AEDE0513365636CF8BFB", hash_generated_method = "644BAC8922C2051F6944ED26C842A1E3")
    public final void unlock() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.229 -0400", hash_original_method = "EA3188FC5C2FE364141E1E027A72F754", hash_generated_method = "07004BFA887EFF8E222FA1066C0AEBA7")
    public final void lock() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.230 -0400", hash_original_method = "AE5D3A84E8844CCCAC3E25422B8D0B4B", hash_generated_method = "B0E083E7EEB5CCA1699F6C8C358B792D")
    public final void reconnect() throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.230 -0400", hash_original_method = "438AEF66D8FD926A08ECF42411561F99", hash_generated_method = "A47D0555AFDEF3133D9AD8514DE58443")
    public final void setPreviewDisplay(SurfaceHolder holder) throws IOException {
        addTaint(holder.getTaint());
    if(holder != null)        
        {
            setPreviewDisplay(holder.getSurface());
        } //End block
        else
        {
            setPreviewDisplay((Surface)null);
        } //End block
        // ---------- Original Method ----------
        //if (holder != null) {
            //setPreviewDisplay(holder.getSurface());
        //} else {
            //setPreviewDisplay((Surface)null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.230 -0400", hash_original_method = "0997F7F636D30A698007C9D53ABFEAA8", hash_generated_method = "0A87F82979CA2AE58A3CCBB68EA0E742")
    private final void setPreviewDisplay(Surface surface) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.231 -0400", hash_original_method = "896582DEF98D5E1EC5488A60A996492A", hash_generated_method = "D52550820994977BCCE52091FCBE50D0")
    public final void setPreviewTexture(SurfaceTexture surfaceTexture) throws IOException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.231 -0400", hash_original_method = "D546ACB03B4B785C233CEA5A53219FBD", hash_generated_method = "9157CC02B426305A20464237BD9F3D49")
    public final void startPreview() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.231 -0400", hash_original_method = "AB430C8006DC0097BE399D3294C32B82", hash_generated_method = "24B22349549CB3C13F0F67D33080E2E5")
    public final void stopPreview() {
        _stopPreview();
        mFaceDetectionRunning = false;
        mShutterCallback = null;
        mRawImageCallback = null;
        mPostviewCallback = null;
        mJpegCallback = null;
        mAutoFocusCallback = null;
        // ---------- Original Method ----------
        //_stopPreview();
        //mFaceDetectionRunning = false;
        //mShutterCallback = null;
        //mRawImageCallback = null;
        //mPostviewCallback = null;
        //mJpegCallback = null;
        //mAutoFocusCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.232 -0400", hash_original_method = "5C6CC4130952C356AFFCDA8182FC7947", hash_generated_method = "3F43F3EC3660148943C1B4911DBD8295")
    private final void _stopPreview() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.232 -0400", hash_original_method = "05AF9970C538CB01E0CE4F8451A5B5A5", hash_generated_method = "43185AA9CB5800237A7DE73004AC2EEA")
    public final boolean previewEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117489925 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117489925;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.232 -0400", hash_original_method = "2F9DAB75D6DAF4C7768888E00FFEEEC7", hash_generated_method = "093DCD58CF92AB3AA77F2FA685E98BD1")
    public final void setPreviewCallback(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = false;
        mWithBuffer = false;
        setHasPreviewCallback(cb != null, false);
        // ---------- Original Method ----------
        //mPreviewCallback = cb;
        //mOneShot = false;
        //mWithBuffer = false;
        //setHasPreviewCallback(cb != null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.233 -0400", hash_original_method = "24870DBDAFF44FBB695A42B8C4F5E47B", hash_generated_method = "66ABA6103145EEDDB8CDA9B7FC38CA62")
    public final void setOneShotPreviewCallback(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = true;
        mWithBuffer = false;
        setHasPreviewCallback(cb != null, false);
        // ---------- Original Method ----------
        //mPreviewCallback = cb;
        //mOneShot = true;
        //mWithBuffer = false;
        //setHasPreviewCallback(cb != null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.233 -0400", hash_original_method = "F92B1FC9B77C310C88F7762A3FF0D1F1", hash_generated_method = "610BB4E79761448F8769061FA12D8078")
    private final void setHasPreviewCallback(boolean installed, boolean manualBuffer) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.234 -0400", hash_original_method = "D6843334713D07AAF210EACBD6CFBFF4", hash_generated_method = "CE86813034D0B90DF8AAE504FF6AAFE8")
    public final void setPreviewCallbackWithBuffer(PreviewCallback cb) {
        mPreviewCallback = cb;
        mOneShot = false;
        mWithBuffer = true;
        setHasPreviewCallback(cb != null, true);
        // ---------- Original Method ----------
        //mPreviewCallback = cb;
        //mOneShot = false;
        //mWithBuffer = true;
        //setHasPreviewCallback(cb != null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.234 -0400", hash_original_method = "A09D93E5FEF9D0285B72182191BE3D88", hash_generated_method = "313D3F1DF3B8D666F73EEFD58200226E")
    public final void addCallbackBuffer(byte[] callbackBuffer) {
        addTaint(callbackBuffer[0]);
        _addCallbackBuffer(callbackBuffer, CAMERA_MSG_PREVIEW_FRAME);
        // ---------- Original Method ----------
        //_addCallbackBuffer(callbackBuffer, CAMERA_MSG_PREVIEW_FRAME);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.235 -0400", hash_original_method = "DF16904A59ADE37251DD7B5F971D59DA", hash_generated_method = "0A15BEFD59BD7BE1D06156B2329CB1F1")
    public final void addRawImageCallbackBuffer(byte[] callbackBuffer) {
        addTaint(callbackBuffer[0]);
        addCallbackBuffer(callbackBuffer, CAMERA_MSG_RAW_IMAGE);
        // ---------- Original Method ----------
        //addCallbackBuffer(callbackBuffer, CAMERA_MSG_RAW_IMAGE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.235 -0400", hash_original_method = "391D3A52EC92D78C4E563BC291F66937", hash_generated_method = "6E637B112C533685C820138539221A30")
    private final void addCallbackBuffer(byte[] callbackBuffer, int msgType) {
        addTaint(msgType);
        addTaint(callbackBuffer[0]);
    if(msgType != CAMERA_MSG_PREVIEW_FRAME &&
            msgType != CAMERA_MSG_RAW_IMAGE)        
        {
            IllegalArgumentException var86C76D973BD473D74ED5177C71996BC1_553546041 = new IllegalArgumentException(
                            "Unsupported message type: " + msgType);
            var86C76D973BD473D74ED5177C71996BC1_553546041.addTaint(taint);
            throw var86C76D973BD473D74ED5177C71996BC1_553546041;
        } //End block
        _addCallbackBuffer(callbackBuffer, msgType);
        // ---------- Original Method ----------
        //if (msgType != CAMERA_MSG_PREVIEW_FRAME &&
            //msgType != CAMERA_MSG_RAW_IMAGE) {
            //throw new IllegalArgumentException(
                            //"Unsupported message type: " + msgType);
        //}
        //_addCallbackBuffer(callbackBuffer, msgType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.235 -0400", hash_original_method = "D4768D01937D37185DEEEF1DE89AE1E9", hash_generated_method = "AA5075F8AA33EF21C16B481195B01F8A")
    private final void _addCallbackBuffer(
                                byte[] callbackBuffer, int msgType) {
    }

    
        private static void postEventFromNative(Object camera_ref,
                                            int what, int arg1, int arg2, Object obj) {
        Camera c = (Camera)((WeakReference)camera_ref).get();
        if (c == null)
            return;
        if (c.mEventHandler != null) {
            Message m = c.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            c.mEventHandler.sendMessage(m);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.236 -0400", hash_original_method = "0E3CC922487DC63C4A5A24CA78FD017D", hash_generated_method = "2F2C47E48F64B691AF903180A014B298")
    public final void autoFocus(AutoFocusCallback cb) {
        mAutoFocusCallback = cb;
        native_autoFocus();
        // ---------- Original Method ----------
        //mAutoFocusCallback = cb;
        //native_autoFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.236 -0400", hash_original_method = "CBF6350AD6916ADF364820AEE02A4625", hash_generated_method = "197FE47938204FF0DBD059150FC6ED11")
    private final void native_autoFocus() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.237 -0400", hash_original_method = "2EF0F393A3D655AFB514BFE787466093", hash_generated_method = "A0A1E9110083A131EA1307E57DBB4D06")
    public final void cancelAutoFocus() {
        mAutoFocusCallback = null;
        native_cancelAutoFocus();
        // ---------- Original Method ----------
        //mAutoFocusCallback = null;
        //native_cancelAutoFocus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.237 -0400", hash_original_method = "627E1E0A1BA298FD1B675A29D70F6408", hash_generated_method = "5F6074482B634128C81E118DEA3B6416")
    private final void native_cancelAutoFocus() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.237 -0400", hash_original_method = "C601C1FA969C1E17CA36D3767A4885D3", hash_generated_method = "F95E8D08B6D066DE8C4BB83222DC5B69")
    public final void takePicture(ShutterCallback shutter, PictureCallback raw,
            PictureCallback jpeg) {
        addTaint(jpeg.getTaint());
        addTaint(raw.getTaint());
        addTaint(shutter.getTaint());
        takePicture(shutter, raw, null, jpeg);
        // ---------- Original Method ----------
        //takePicture(shutter, raw, null, jpeg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.238 -0400", hash_original_method = "9DA1D6832E2DF57D49D73BC5F1630045", hash_generated_method = "6F42544A74B15B7C28F6B928BB89DB3C")
    private final void native_takePicture(int msgType) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.239 -0400", hash_original_method = "A653181D2B77C1AA9A58A11AAAA145B5", hash_generated_method = "8C6960793D20EA25088B61D8883DDE1B")
    public final void takePicture(ShutterCallback shutter, PictureCallback raw,
            PictureCallback postview, PictureCallback jpeg) {
        mShutterCallback = shutter;
        mRawImageCallback = raw;
        mPostviewCallback = postview;
        mJpegCallback = jpeg;
        int msgType = 0;
    if(mShutterCallback != null)        
        {
            msgType |= CAMERA_MSG_SHUTTER;
        } //End block
    if(mRawImageCallback != null)        
        {
            msgType |= CAMERA_MSG_RAW_IMAGE;
        } //End block
    if(mPostviewCallback != null)        
        {
            msgType |= CAMERA_MSG_POSTVIEW_FRAME;
        } //End block
    if(mJpegCallback != null)        
        {
            msgType |= CAMERA_MSG_COMPRESSED_IMAGE;
        } //End block
        native_takePicture(msgType);
        // ---------- Original Method ----------
        //mShutterCallback = shutter;
        //mRawImageCallback = raw;
        //mPostviewCallback = postview;
        //mJpegCallback = jpeg;
        //int msgType = 0;
        //if (mShutterCallback != null) {
            //msgType |= CAMERA_MSG_SHUTTER;
        //}
        //if (mRawImageCallback != null) {
            //msgType |= CAMERA_MSG_RAW_IMAGE;
        //}
        //if (mPostviewCallback != null) {
            //msgType |= CAMERA_MSG_POSTVIEW_FRAME;
        //}
        //if (mJpegCallback != null) {
            //msgType |= CAMERA_MSG_COMPRESSED_IMAGE;
        //}
        //native_takePicture(msgType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.240 -0400", hash_original_method = "CB85955AE7ECC872C16FD259F78D1283", hash_generated_method = "F7DBACC9F636CDEF7C593352BEE8991E")
    public final void startSmoothZoom(int value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.240 -0400", hash_original_method = "6E23FCC9E3F0853162C9ABD237B3E263", hash_generated_method = "D4B293AFC15EB30940FB50D65DE46239")
    public final void stopSmoothZoom() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.241 -0400", hash_original_method = "4194592279C5F487807EC326C09E0EDE", hash_generated_method = "24CE678D5B3632462E30C688391798E1")
    public final void setDisplayOrientation(int degrees) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.242 -0400", hash_original_method = "6480531FCD656465921BBC33792E6355", hash_generated_method = "B412D3AC937FF3C3E1CA348431559085")
    public final void setZoomChangeListener(OnZoomChangeListener listener) {
        mZoomListener = listener;
        // ---------- Original Method ----------
        //mZoomListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.243 -0400", hash_original_method = "72125974AAC05BF0DED9497DD0672E75", hash_generated_method = "7CC0F5FEC0100DF2CE46B4097D204789")
    public final void setFaceDetectionListener(FaceDetectionListener listener) {
        mFaceListener = listener;
        // ---------- Original Method ----------
        //mFaceListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.243 -0400", hash_original_method = "589FE294AB7893E2AD7EE0261AFFC1FF", hash_generated_method = "611FDDA60F89940AF06BD5635107EE7C")
    public final void startFaceDetection() {
    if(mFaceDetectionRunning)        
        {
            RuntimeException varC861A025B7DB4E0FEBBAA55D1A196985_368037840 = new RuntimeException("Face detection is already running");
            varC861A025B7DB4E0FEBBAA55D1A196985_368037840.addTaint(taint);
            throw varC861A025B7DB4E0FEBBAA55D1A196985_368037840;
        } //End block
        _startFaceDetection(CAMERA_FACE_DETECTION_HW);
        mFaceDetectionRunning = true;
        // ---------- Original Method ----------
        //if (mFaceDetectionRunning) {
            //throw new RuntimeException("Face detection is already running");
        //}
        //_startFaceDetection(CAMERA_FACE_DETECTION_HW);
        //mFaceDetectionRunning = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.244 -0400", hash_original_method = "1658BFC488D62D85A32E58C8EE9C8382", hash_generated_method = "9CD2859583E95E9914109782A81F2911")
    public final void stopFaceDetection() {
        _stopFaceDetection();
        mFaceDetectionRunning = false;
        // ---------- Original Method ----------
        //_stopFaceDetection();
        //mFaceDetectionRunning = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.244 -0400", hash_original_method = "44CAC56F9FD022B772605806F720BF7E", hash_generated_method = "8F98B1A9B9CA2664A3A0A913739E5418")
    private final void _startFaceDetection(int type) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.244 -0400", hash_original_method = "A44256EE80ABD488101E1B754E2222A4", hash_generated_method = "00606921D3802A9C645F3A0AE0F773FE")
    private final void _stopFaceDetection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.245 -0400", hash_original_method = "BE99CE61E82474B676C6D48791CDF52E", hash_generated_method = "E63A5FF66AB2916340CBB5CA49FBE157")
    public final void setErrorCallback(ErrorCallback cb) {
        mErrorCallback = cb;
        // ---------- Original Method ----------
        //mErrorCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.245 -0400", hash_original_method = "62874E13510D0FD5D23BE793A7BF66C4", hash_generated_method = "862AA1BCBF2DF45964633CC4C184143F")
    private final void native_setParameters(String params) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.245 -0400", hash_original_method = "3CEFEC9BC04BFA67886C8721C375B2BF", hash_generated_method = "7CDFCD53AAB21A45E6D03778B4CC52A9")
    private final String native_getParameters() {
    	String s = new String();
    	s.addTaint(this.taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.245 -0400", hash_original_method = "626488C7E8947ED02FA722E13C8A89F1", hash_generated_method = "A702BECC57EFB4D0981E1635212A1439")
    public void setParameters(Parameters params) {
        addTaint(params.getTaint());
        native_setParameters(params.flatten());
        // ---------- Original Method ----------
        //native_setParameters(params.flatten());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_method = "5DDAD998A9057F14B2A0711CFDC833B3", hash_generated_method = "B52A1A64CE4B104812DF9569542CB208")
    public Parameters getParameters() {
        Parameters p = new Parameters();
        String s = native_getParameters();
        p.unflatten(s);
Parameters var74E4690D9F2A026504928C017944E149_1083043458 =         p;
        var74E4690D9F2A026504928C017944E149_1083043458.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1083043458;
        // ---------- Original Method ----------
        //Parameters p = new Parameters();
        //String s = native_getParameters();
        //p.unflatten(s);
        //return p;
    }

    
    public static class CameraInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_field = "E3867C79F8F02D7C2580D9F9FD01EB64", hash_generated_field = "25D2EC7372795E4CF4CE9BD768162F29")

        public int facing;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_field = "DA1639422AD8F355D2371428471379B5", hash_generated_field = "039D4A8EAE0AA6D0501E4B6BB899CCE8")

        public int orientation;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_method = "53549141AB7280F9D01DADAF7B2BE301", hash_generated_method = "53549141AB7280F9D01DADAF7B2BE301")
        public CameraInfo ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_field = "6356D052080640F8D597A720C9512CA8", hash_generated_field = "858969BC557B8C41F748B73BC5BF335A")

        public static final int CAMERA_FACING_BACK = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_field = "285223F2810B47B6EFB467EFCF7A28C5", hash_generated_field = "DA2E8C78AD23CF4E48B5EB9C8BB0C1BF")

        public static final int CAMERA_FACING_FRONT = 1;
    }


    
    private class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_field = "0C244E054A0D21A6C5F429625D0324BF", hash_generated_field = "342D730EDD2CEF78B671539580251722")

        private Camera mCamera;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.246 -0400", hash_original_method = "34C18DB36AC676A5AD3395F8999AED0E", hash_generated_method = "4BF1F191A097B8728B832E59A7469B35")
        public  EventHandler(Camera c, Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            mCamera = c;
            // ---------- Original Method ----------
            //mCamera = c;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.247 -0400", hash_original_method = "527FC94310988CAD6A04936940B6C036", hash_generated_method = "21AD122B86F47B068EC94AF98247DB0A")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case CAMERA_MSG_SHUTTER:
    if(mShutterCallback != null)            
            {
                mShutterCallback.onShutter();
            } //End block
            return;
            case CAMERA_MSG_RAW_IMAGE:
    if(mRawImageCallback != null)            
            {
                mRawImageCallback.onPictureTaken((byte[])msg.obj, mCamera);
            } //End block
            return;
            case CAMERA_MSG_COMPRESSED_IMAGE:
    if(mJpegCallback != null)            
            {
                mJpegCallback.onPictureTaken((byte[])msg.obj, mCamera);
            } //End block
            return;
            case CAMERA_MSG_PREVIEW_FRAME:
    if(mPreviewCallback != null)            
            {
                PreviewCallback cb = mPreviewCallback;
    if(mOneShot)                
                {
                    mPreviewCallback = null;
                } //End block
                else
    if(!mWithBuffer)                
                {
                    setHasPreviewCallback(true, false);
                } //End block
                cb.onPreviewFrame((byte[])msg.obj, mCamera);
            } //End block
            return;
            case CAMERA_MSG_POSTVIEW_FRAME:
    if(mPostviewCallback != null)            
            {
                mPostviewCallback.onPictureTaken((byte[])msg.obj, mCamera);
            } //End block
            return;
            case CAMERA_MSG_FOCUS:
    if(mAutoFocusCallback != null)            
            {
                mAutoFocusCallback.onAutoFocus(msg.arg1 == 0 ? false : true, mCamera);
            } //End block
            return;
            case CAMERA_MSG_ZOOM:
    if(mZoomListener != null)            
            {
                mZoomListener.onZoomChange(msg.arg1, msg.arg2 != 0, mCamera);
            } //End block
            return;
            case CAMERA_MSG_PREVIEW_METADATA:
    if(mFaceListener != null)            
            {
                mFaceListener.onFaceDetection((Face[])msg.obj, mCamera);
            } //End block
            return;
            case CAMERA_MSG_ERROR :
    if(mErrorCallback != null)            
            {
                mErrorCallback.onError(msg.arg1, mCamera);
            } //End block
            return;
            default:
            return;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public static class Face {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "2676D7B68FF2C97C5776C6E5DA218C01", hash_generated_field = "6F2D83EE0E930D3F0DDD170A74A8B967")

        public Rect rect;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "CA1CD3C3055991BF20499EE86739F7E2", hash_generated_field = "597E48275902E31CE4704100ED960A91")

        public int score;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "316E3AEB13F749D37F6D3AE9F0939552", hash_generated_field = "893C408272A867D7D8E53504CF16C51D")

        public int id = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "82792BB7282B98546607C29AB3734AE8", hash_generated_field = "0DDAD1A72ADB57EB54106245C5583D87")

        public Point leftEye = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "074C510909F0C7F8AD57D5147324CD21", hash_generated_field = "65B1A72E8914E2C3527E23F7B661DF01")

        public Point rightEye = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "3C58D6F19638F9CBA8F3647973CFB696", hash_generated_field = "5C5BC93671E3C9D8BBE06B8E52E14C9D")

        public Point mouth = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_method = "AEF29885362690B7E7A5098C2C347237", hash_generated_method = "0DF9184788C0A0AD5CEBB07DA8C829FC")
        public  Face() {
            // ---------- Original Method ----------
        }

        
    }


    
    public class Size {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.248 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "6FAF64E7577371F06EC12EBE94C8466B")

        public int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.249 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "7F76BED9760D410D06D1D8D13D91425A")

        public int height;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.249 -0400", hash_original_method = "8D5275DA61B4D745CED801D3C3D010F4", hash_generated_method = "7EB558DAEC3AA223CE4E69E9FAECE48D")
        public  Size(int w, int h) {
            width = w;
            height = h;
            // ---------- Original Method ----------
            //width = w;
            //height = h;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.249 -0400", hash_original_method = "C0E6580734A50AA28FE29C092058ED66", hash_generated_method = "2C20E038FA77344D75A01434C1F869B5")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof Size))            
            {
                boolean var68934A3E9455FA72420237EB05902327_276613685 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811787110 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_811787110;
            } //End block
            Size s = (Size) obj;
            boolean var1EBE203A85A934681C2C3B951EFEBD35_1883206644 = (width == s.width && height == s.height);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123983458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123983458;
            // ---------- Original Method ----------
            //if (!(obj instanceof Size)) {
                //return false;
            //}
            //Size s = (Size) obj;
            //return width == s.width && height == s.height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.250 -0400", hash_original_method = "B5BC5866A74569F21D19CEA2ED84BAAB", hash_generated_method = "3D7BF84CDA72096B7218C04B119F611B")
        @Override
        public int hashCode() {
            int var3CDE4CC1D496387B11F295C85E8985FD_833524101 = (width * 32713 + height);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769571669 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769571669;
            // ---------- Original Method ----------
            //return width * 32713 + height;
        }

        
    }


    
    public static class Area {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.250 -0400", hash_original_field = "2676D7B68FF2C97C5776C6E5DA218C01", hash_generated_field = "6F2D83EE0E930D3F0DDD170A74A8B967")

        public Rect rect;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.250 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "EB9C9E5835DB061A8FF1A7ADDB6DF6F5")

        public int weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.251 -0400", hash_original_method = "E9625E9CC5B81192600D71D662CB25CE", hash_generated_method = "6FE1CDCA08E1957F3466D3CA360F65F7")
        public  Area(Rect rect, int weight) {
            this.rect = rect;
            this.weight = weight;
            // ---------- Original Method ----------
            //this.rect = rect;
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.251 -0400", hash_original_method = "79D1F56CDDD7107B76CC69CE709FE4A7", hash_generated_method = "E551F4177054AC490C791AB404F4BB05")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof Area))            
            {
                boolean var68934A3E9455FA72420237EB05902327_136960182 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041000235 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041000235;
            } //End block
            Area a = (Area) obj;
    if(rect == null)            
            {
    if(a.rect != null)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1053825058 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_588072743 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_588072743;
                }
            } //End block
            else
            {
    if(!rect.equals(a.rect))                
                {
                boolean var68934A3E9455FA72420237EB05902327_1377864975 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851446050 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851446050;
                }
            } //End block
            boolean varC0E5FA79E201CD48FE736B452141D39C_419316832 = (weight == a.weight);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517240497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517240497;
            // ---------- Original Method ----------
            //if (!(obj instanceof Area)) {
                //return false;
            //}
            //Area a = (Area) obj;
            //if (rect == null) {
                //if (a.rect != null) return false;
            //} else {
                //if (!rect.equals(a.rect)) return false;
            //}
            //return weight == a.weight;
        }

        
    }


    
    public class Parameters {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.254 -0400", hash_original_field = "47CB5CD11AAE7A0AB09FB37CAC0E4D7D", hash_generated_field = "739CA7FE9531E7B12F38763AC7E52A02")

        private HashMap<String, String> mMap;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.254 -0400", hash_original_method = "4F2FCD993800C5D9B02C3E73A4276618", hash_generated_method = "9E43DE2A4307A690FF8F265C4E4CD891")
        private  Parameters() {
            mMap = new HashMap<String, String>();
            // ---------- Original Method ----------
            //mMap = new HashMap<String, String>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.254 -0400", hash_original_method = "D034C07CEE631373421F512D5E686FA4", hash_generated_method = "4868844A0730723D65DE326AF69BEF27")
        public void dump() {
for(String k : mMap.keySet())
            {
            } //End block
            // ---------- Original Method ----------
            //Log.e(TAG, "dump: size=" + mMap.size());
            //for (String k : mMap.keySet()) {
                //Log.e(TAG, "dump: " + k + "=" + mMap.get(k));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.255 -0400", hash_original_method = "E90C6E0F7F8E9CA9BC2EBC890074459A", hash_generated_method = "F8CEC5B29446CA393F1D237F137D067F")
        public String flatten() {
            StringBuilder flattened = new StringBuilder();
for(String k : mMap.keySet())
            {
                flattened.append(k);
                flattened.append("=");
                flattened.append(mMap.get(k));
                flattened.append(";");
            } //End block
            flattened.deleteCharAt(flattened.length()-1);
String var9557D146B68D5206BC412EBE575062A0_276144634 =             flattened.toString();
            var9557D146B68D5206BC412EBE575062A0_276144634.addTaint(taint);
            return var9557D146B68D5206BC412EBE575062A0_276144634;
            // ---------- Original Method ----------
            //StringBuilder flattened = new StringBuilder();
            //for (String k : mMap.keySet()) {
                //flattened.append(k);
                //flattened.append("=");
                //flattened.append(mMap.get(k));
                //flattened.append(";");
            //}
            //flattened.deleteCharAt(flattened.length()-1);
            //return flattened.toString();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.255 -0400", hash_original_method = "5AA143467542BDE17D4CF17C4A163B7B", hash_generated_method = "7DF5F4DE430945EE30486D50ED56D28C")
        public void unflatten(String flattened) {
            addTaint(flattened.getTaint());
            mMap.clear();
            StringTokenizer tokenizer = new StringTokenizer(flattened, ";");
            while
(tokenizer.hasMoreElements())            
            {
                String kv = tokenizer.nextToken();
                int pos = kv.indexOf('=');
    if(pos == -1)                
                {
                    continue;
                } //End block
                String k = kv.substring(0, pos);
                String v = kv.substring(pos + 1);
                mMap.put(k, v);
            } //End block
            // ---------- Original Method ----------
            //mMap.clear();
            //StringTokenizer tokenizer = new StringTokenizer(flattened, ";");
            //while (tokenizer.hasMoreElements()) {
                //String kv = tokenizer.nextToken();
                //int pos = kv.indexOf('=');
                //if (pos == -1) {
                    //continue;
                //}
                //String k = kv.substring(0, pos);
                //String v = kv.substring(pos + 1);
                //mMap.put(k, v);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.256 -0400", hash_original_method = "BEF3CDE9B4B41831DEDE5E8321E4E9B4", hash_generated_method = "55B9F036B866CDD68B11330777AF683B")
        public void remove(String key) {
            addTaint(key.getTaint());
            mMap.remove(key);
            // ---------- Original Method ----------
            //mMap.remove(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.256 -0400", hash_original_method = "9906E3CA2524241D923FE8CC5604496C", hash_generated_method = "1BB1E2E6582089E16EE2A185E153A709")
        public void set(String key, String value) {
            addTaint(value.getTaint());
            addTaint(key.getTaint());
    if(key.indexOf('=') != -1 || key.indexOf(';') != -1)            
            {
                return;
            } //End block
    if(value.indexOf('=') != -1 || value.indexOf(';') != -1)            
            {
                return;
            } //End block
            mMap.put(key, value);
            // ---------- Original Method ----------
            //if (key.indexOf('=') != -1 || key.indexOf(';') != -1) {
                //Log.e(TAG, "Key \"" + key + "\" contains invalid character (= or ;)");
                //return;
            //}
            //if (value.indexOf('=') != -1 || value.indexOf(';') != -1) {
                //Log.e(TAG, "Value \"" + value + "\" contains invalid character (= or ;)");
                //return;
            //}
            //mMap.put(key, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.256 -0400", hash_original_method = "DBCF0186D288029EB50A796A20F8A1EF", hash_generated_method = "166D5515072A4E5C95741B0F1FB70E60")
        public void set(String key, int value) {
            addTaint(value);
            addTaint(key.getTaint());
            mMap.put(key, Integer.toString(value));
            // ---------- Original Method ----------
            //mMap.put(key, Integer.toString(value));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.257 -0400", hash_original_method = "FA0E250AABDDF6BDEB5118FEC7A9E23B", hash_generated_method = "50522582FBFBDAFF0EA06ADE679BED2F")
        private void set(String key, List<Area> areas) {
            addTaint(areas.getTaint());
            addTaint(key.getTaint());
    if(areas == null)            
            {
                set(key, "(0,0,0,0,0)");
            } //End block
            else
            {
                StringBuilder buffer = new StringBuilder();
for(int i = 0;i < areas.size();i++)
                {
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
    if(i != areas.size() - 1)                    
                    buffer.append(',');
                } //End block
                set(key, buffer.toString());
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.257 -0400", hash_original_method = "4BCD400EF6A3BABD5D1A20005C4F1016", hash_generated_method = "E7BA34F177918E065CD65422E0174CF0")
        public String get(String key) {
            addTaint(key.getTaint());
String var854B7A61C03CF753466A11AD5A6F683C_2035508482 =             mMap.get(key);
            var854B7A61C03CF753466A11AD5A6F683C_2035508482.addTaint(taint);
            return var854B7A61C03CF753466A11AD5A6F683C_2035508482;
            // ---------- Original Method ----------
            //return mMap.get(key);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.258 -0400", hash_original_method = "D98874905E79EBB2CF3B083E3C25C47A", hash_generated_method = "997B69A3EC4209E642AD15E86588B845")
        public int getInt(String key) {
            addTaint(key.getTaint());
            int var065A0EC7C05D7BFA29A33E9C4D5F409A_1945143983 = (Integer.parseInt(mMap.get(key)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080355152 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080355152;
            // ---------- Original Method ----------
            //return Integer.parseInt(mMap.get(key));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.258 -0400", hash_original_method = "6987138C4F07A5DAB158AF960652B331", hash_generated_method = "7C3688B9C9FED73FFC4A7F0047BAB4B9")
        public void setPreviewSize(int width, int height) {
            addTaint(height);
            addTaint(width);
            String v = Integer.toString(width) + "x" + Integer.toString(height);
            set(KEY_PREVIEW_SIZE, v);
            // ---------- Original Method ----------
            //String v = Integer.toString(width) + "x" + Integer.toString(height);
            //set(KEY_PREVIEW_SIZE, v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.258 -0400", hash_original_method = "FFDCE2F5212818E42781ADE1E098D0AA", hash_generated_method = "EDBB8ADB748307EBBAA25A5629D9A3B1")
        public Size getPreviewSize() {
            String pair = get(KEY_PREVIEW_SIZE);
Size var0F26D7FD907B045F9ED53A530D120DCD_692238938 =             strToSize(pair);
            var0F26D7FD907B045F9ED53A530D120DCD_692238938.addTaint(taint);
            return var0F26D7FD907B045F9ED53A530D120DCD_692238938;
            // ---------- Original Method ----------
            //String pair = get(KEY_PREVIEW_SIZE);
            //return strToSize(pair);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.259 -0400", hash_original_method = "8D352EB4757BE2304D2B4A3F288B091E", hash_generated_method = "A08B680324D6014B608A51B6CCFFBCD1")
        public List<Size> getSupportedPreviewSizes() {
            String str = get(KEY_PREVIEW_SIZE + SUPPORTED_VALUES_SUFFIX);
List<Size> var2BF79BBAE173763A0E8792E86A8D3BC4_1741494790 =             splitSize(str);
            var2BF79BBAE173763A0E8792E86A8D3BC4_1741494790.addTaint(taint);
            return var2BF79BBAE173763A0E8792E86A8D3BC4_1741494790;
            // ---------- Original Method ----------
            //String str = get(KEY_PREVIEW_SIZE + SUPPORTED_VALUES_SUFFIX);
            //return splitSize(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.259 -0400", hash_original_method = "419751D51666FF4E07A42C54765653DD", hash_generated_method = "123D81D54BF4C6A216080ECC6B20740E")
        public List<Size> getSupportedVideoSizes() {
            String str = get(KEY_VIDEO_SIZE + SUPPORTED_VALUES_SUFFIX);
List<Size> var2BF79BBAE173763A0E8792E86A8D3BC4_1724067622 =             splitSize(str);
            var2BF79BBAE173763A0E8792E86A8D3BC4_1724067622.addTaint(taint);
            return var2BF79BBAE173763A0E8792E86A8D3BC4_1724067622;
            // ---------- Original Method ----------
            //String str = get(KEY_VIDEO_SIZE + SUPPORTED_VALUES_SUFFIX);
            //return splitSize(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.259 -0400", hash_original_method = "476173E7CF96CBAAF95B36BF5A6B6193", hash_generated_method = "568B665B4000F8BE1EF8428D1B737195")
        public Size getPreferredPreviewSizeForVideo() {
            String pair = get(KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO);
Size var0F26D7FD907B045F9ED53A530D120DCD_2058747595 =             strToSize(pair);
            var0F26D7FD907B045F9ED53A530D120DCD_2058747595.addTaint(taint);
            return var0F26D7FD907B045F9ED53A530D120DCD_2058747595;
            // ---------- Original Method ----------
            //String pair = get(KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO);
            //return strToSize(pair);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.260 -0400", hash_original_method = "2AB80AB00FA241259D83FB9D6F5E9551", hash_generated_method = "DD0EA9C372F9A1AAD2AC437592A8E76C")
        public void setJpegThumbnailSize(int width, int height) {
            addTaint(height);
            addTaint(width);
            set(KEY_JPEG_THUMBNAIL_WIDTH, width);
            set(KEY_JPEG_THUMBNAIL_HEIGHT, height);
            // ---------- Original Method ----------
            //set(KEY_JPEG_THUMBNAIL_WIDTH, width);
            //set(KEY_JPEG_THUMBNAIL_HEIGHT, height);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.260 -0400", hash_original_method = "97782C5666FA5508071C4A4BBC2C021F", hash_generated_method = "8184899F42E6B3E1E8D193012B225746")
        public Size getJpegThumbnailSize() {
Size varDC26E918812CA4BF8A54557A2D24C424_1958122033 =             new Size(getInt(KEY_JPEG_THUMBNAIL_WIDTH),
                            getInt(KEY_JPEG_THUMBNAIL_HEIGHT));
            varDC26E918812CA4BF8A54557A2D24C424_1958122033.addTaint(taint);
            return varDC26E918812CA4BF8A54557A2D24C424_1958122033;
            // ---------- Original Method ----------
            //return new Size(getInt(KEY_JPEG_THUMBNAIL_WIDTH),
                            //getInt(KEY_JPEG_THUMBNAIL_HEIGHT));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.260 -0400", hash_original_method = "F3667EFF578F1A2BAF2D6378DF0D62F7", hash_generated_method = "E2619BD90A4D92D5D94E141943674021")
        public List<Size> getSupportedJpegThumbnailSizes() {
            String str = get(KEY_JPEG_THUMBNAIL_SIZE + SUPPORTED_VALUES_SUFFIX);
List<Size> var2BF79BBAE173763A0E8792E86A8D3BC4_1900811778 =             splitSize(str);
            var2BF79BBAE173763A0E8792E86A8D3BC4_1900811778.addTaint(taint);
            return var2BF79BBAE173763A0E8792E86A8D3BC4_1900811778;
            // ---------- Original Method ----------
            //String str = get(KEY_JPEG_THUMBNAIL_SIZE + SUPPORTED_VALUES_SUFFIX);
            //return splitSize(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.260 -0400", hash_original_method = "D45FD8A4693A979494C68F5349AB982C", hash_generated_method = "C7C142278E43E21A176A52F0D4B95324")
        public void setJpegThumbnailQuality(int quality) {
            addTaint(quality);
            set(KEY_JPEG_THUMBNAIL_QUALITY, quality);
            // ---------- Original Method ----------
            //set(KEY_JPEG_THUMBNAIL_QUALITY, quality);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.261 -0400", hash_original_method = "AB1C60CFC56F7C5F4F17D7289D5CF367", hash_generated_method = "E33464C065C1D9841FEFEB4CD77DD6F7")
        public int getJpegThumbnailQuality() {
            int var7EAC6CC1F1D15EE179944D3E2FCC47D8_616642563 = (getInt(KEY_JPEG_THUMBNAIL_QUALITY));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320056136 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1320056136;
            // ---------- Original Method ----------
            //return getInt(KEY_JPEG_THUMBNAIL_QUALITY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.261 -0400", hash_original_method = "93253D80DE36A3D3B74304A7DEF0F5F5", hash_generated_method = "BEB48838508D247E6BCD5A531416A2B8")
        public void setJpegQuality(int quality) {
            addTaint(quality);
            set(KEY_JPEG_QUALITY, quality);
            // ---------- Original Method ----------
            //set(KEY_JPEG_QUALITY, quality);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.261 -0400", hash_original_method = "1D0E1BB86FE6D9E935C1A2619011DCB7", hash_generated_method = "02C31CA6A5EC69B2166BB9A333B34714")
        public int getJpegQuality() {
            int var61E1B4CA5ADD581AE121E7C25D7F36BB_1268084184 = (getInt(KEY_JPEG_QUALITY));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831258727 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831258727;
            // ---------- Original Method ----------
            //return getInt(KEY_JPEG_QUALITY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.262 -0400", hash_original_method = "B0B2C8D52537728343380388CD5075DA", hash_generated_method = "D320738A72AD238473273B0C99942A98")
        @Deprecated
        public void setPreviewFrameRate(int fps) {
            addTaint(fps);
            set(KEY_PREVIEW_FRAME_RATE, fps);
            // ---------- Original Method ----------
            //set(KEY_PREVIEW_FRAME_RATE, fps);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.262 -0400", hash_original_method = "C0E05BF1AAC7EB32A80D6F26752FF1EF", hash_generated_method = "37591A3137172AEA1ED5BEF2BD55B2EF")
        @Deprecated
        public int getPreviewFrameRate() {
            int varBAD8E256AFD0DBD8F9FEBF1E5505BEE7_1570547661 = (getInt(KEY_PREVIEW_FRAME_RATE));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889313037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889313037;
            // ---------- Original Method ----------
            //return getInt(KEY_PREVIEW_FRAME_RATE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.262 -0400", hash_original_method = "C09404C88F71AC7FB4B866C390BFE007", hash_generated_method = "A94A58C34E8BDEB4513BB4DE8CDB1E8C")
        @Deprecated
        public List<Integer> getSupportedPreviewFrameRates() {
            String str = get(KEY_PREVIEW_FRAME_RATE + SUPPORTED_VALUES_SUFFIX);
List<Integer> varE282670370ED9B453B08E507F538F35D_1876495700 =             splitInt(str);
            varE282670370ED9B453B08E507F538F35D_1876495700.addTaint(taint);
            return varE282670370ED9B453B08E507F538F35D_1876495700;
            // ---------- Original Method ----------
            //String str = get(KEY_PREVIEW_FRAME_RATE + SUPPORTED_VALUES_SUFFIX);
            //return splitInt(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.262 -0400", hash_original_method = "6968DA252510074FDC520CD1B2513339", hash_generated_method = "8C867256811766697E657019EC07B18C")
        public void setPreviewFpsRange(int min, int max) {
            addTaint(max);
            addTaint(min);
            set(KEY_PREVIEW_FPS_RANGE, "" + min + "," + max);
            // ---------- Original Method ----------
            //set(KEY_PREVIEW_FPS_RANGE, "" + min + "," + max);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.263 -0400", hash_original_method = "694B13D03BD40D12B87F5E9E7F0CCA71", hash_generated_method = "D505FF60CD87FCAA0B5DEE4D41074854")
        public void getPreviewFpsRange(int[] range) {
            addTaint(range[0]);
    if(range == null || range.length != 2)            
            {
                IllegalArgumentException var5C42CE534AB1FAE6D875D7353A31C74F_256853233 = new IllegalArgumentException(
                        "range must be an array with two elements.");
                var5C42CE534AB1FAE6D875D7353A31C74F_256853233.addTaint(taint);
                throw var5C42CE534AB1FAE6D875D7353A31C74F_256853233;
            } //End block
            splitInt(get(KEY_PREVIEW_FPS_RANGE), range);
            // ---------- Original Method ----------
            //if (range == null || range.length != 2) {
                //throw new IllegalArgumentException(
                        //"range must be an array with two elements.");
            //}
            //splitInt(get(KEY_PREVIEW_FPS_RANGE), range);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.263 -0400", hash_original_method = "37F4ABC3F60B37AD6F5647AB4E5273E8", hash_generated_method = "B3D57B85596FC351D7146C9F6B535286")
        public List<int[]> getSupportedPreviewFpsRange() {
            String str = get(KEY_PREVIEW_FPS_RANGE + SUPPORTED_VALUES_SUFFIX);
List<int[]> var4A6C832A566C4A15D5702E9355FC60D9_827990729 =             splitRange(str);
            var4A6C832A566C4A15D5702E9355FC60D9_827990729.addTaint(taint);
            return var4A6C832A566C4A15D5702E9355FC60D9_827990729;
            // ---------- Original Method ----------
            //String str = get(KEY_PREVIEW_FPS_RANGE + SUPPORTED_VALUES_SUFFIX);
            //return splitRange(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.264 -0400", hash_original_method = "266AF7A67C96051E3828B919A653DC3F", hash_generated_method = "416A6375C827D42021EB8B4BDEC5D79E")
        public void setPreviewFormat(int pixel_format) {
            addTaint(pixel_format);
            String s = cameraFormatForPixelFormat(pixel_format);
    if(s == null)            
            {
                IllegalArgumentException var3ACC6B0DBFEC010305006879F93977BD_1751238650 = new IllegalArgumentException(
                        "Invalid pixel_format=" + pixel_format);
                var3ACC6B0DBFEC010305006879F93977BD_1751238650.addTaint(taint);
                throw var3ACC6B0DBFEC010305006879F93977BD_1751238650;
            } //End block
            set(KEY_PREVIEW_FORMAT, s);
            // ---------- Original Method ----------
            //String s = cameraFormatForPixelFormat(pixel_format);
            //if (s == null) {
                //throw new IllegalArgumentException(
                        //"Invalid pixel_format=" + pixel_format);
            //}
            //set(KEY_PREVIEW_FORMAT, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.264 -0400", hash_original_method = "5798A7DE9C51B68E051BB876E894EF7F", hash_generated_method = "70562533732A5526797179D370C3A8A2")
        public int getPreviewFormat() {
            int varC553DE502D5E91F715898211C4467B01_696122013 = (pixelFormatForCameraFormat(get(KEY_PREVIEW_FORMAT)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086577848 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086577848;
            // ---------- Original Method ----------
            //return pixelFormatForCameraFormat(get(KEY_PREVIEW_FORMAT));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.264 -0400", hash_original_method = "9C734A4D54DE4CD84D92E542612908A6", hash_generated_method = "A1C30EDEDFD8F109F568351441E9435F")
        public List<Integer> getSupportedPreviewFormats() {
            String str = get(KEY_PREVIEW_FORMAT + SUPPORTED_VALUES_SUFFIX);
            ArrayList<Integer> formats = new ArrayList<Integer>();
for(String s : split(str))
            {
                int f = pixelFormatForCameraFormat(s);
    if(f == ImageFormat.UNKNOWN)                
                continue;
                formats.add(f);
            } //End block
List<Integer> varA6C147B71359DA5475968801A9984115_685143207 =             formats;
            varA6C147B71359DA5475968801A9984115_685143207.addTaint(taint);
            return varA6C147B71359DA5475968801A9984115_685143207;
            // ---------- Original Method ----------
            //String str = get(KEY_PREVIEW_FORMAT + SUPPORTED_VALUES_SUFFIX);
            //ArrayList<Integer> formats = new ArrayList<Integer>();
            //for (String s : split(str)) {
                //int f = pixelFormatForCameraFormat(s);
                //if (f == ImageFormat.UNKNOWN) continue;
                //formats.add(f);
            //}
            //return formats;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.265 -0400", hash_original_method = "57116AEDE3770C6B0E8CE3250234439E", hash_generated_method = "B54AD9DE20077E1CE72CA006288365D8")
        public void setPictureSize(int width, int height) {
            addTaint(height);
            addTaint(width);
            String v = Integer.toString(width) + "x" + Integer.toString(height);
            set(KEY_PICTURE_SIZE, v);
            // ---------- Original Method ----------
            //String v = Integer.toString(width) + "x" + Integer.toString(height);
            //set(KEY_PICTURE_SIZE, v);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.265 -0400", hash_original_method = "7749C7A1B5F399C08E7379DC16E3083C", hash_generated_method = "A4CEF660CB3CCBAD1A81097F910CC00E")
        public Size getPictureSize() {
            String pair = get(KEY_PICTURE_SIZE);
Size var0F26D7FD907B045F9ED53A530D120DCD_1401907979 =             strToSize(pair);
            var0F26D7FD907B045F9ED53A530D120DCD_1401907979.addTaint(taint);
            return var0F26D7FD907B045F9ED53A530D120DCD_1401907979;
            // ---------- Original Method ----------
            //String pair = get(KEY_PICTURE_SIZE);
            //return strToSize(pair);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.265 -0400", hash_original_method = "8278131A0AA2D5B7AD51AB1A690AF2B9", hash_generated_method = "A544AC030058D5550CD0E8C7261EBAD6")
        public List<Size> getSupportedPictureSizes() {
            String str = get(KEY_PICTURE_SIZE + SUPPORTED_VALUES_SUFFIX);
List<Size> var2BF79BBAE173763A0E8792E86A8D3BC4_1255052406 =             splitSize(str);
            var2BF79BBAE173763A0E8792E86A8D3BC4_1255052406.addTaint(taint);
            return var2BF79BBAE173763A0E8792E86A8D3BC4_1255052406;
            // ---------- Original Method ----------
            //String str = get(KEY_PICTURE_SIZE + SUPPORTED_VALUES_SUFFIX);
            //return splitSize(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.265 -0400", hash_original_method = "51599A9895DB2449268569860164A951", hash_generated_method = "3E916B8C63FC2088622415A1ACE1D465")
        public void setPictureFormat(int pixel_format) {
            addTaint(pixel_format);
            String s = cameraFormatForPixelFormat(pixel_format);
    if(s == null)            
            {
                IllegalArgumentException var3ACC6B0DBFEC010305006879F93977BD_866777965 = new IllegalArgumentException(
                        "Invalid pixel_format=" + pixel_format);
                var3ACC6B0DBFEC010305006879F93977BD_866777965.addTaint(taint);
                throw var3ACC6B0DBFEC010305006879F93977BD_866777965;
            } //End block
            set(KEY_PICTURE_FORMAT, s);
            // ---------- Original Method ----------
            //String s = cameraFormatForPixelFormat(pixel_format);
            //if (s == null) {
                //throw new IllegalArgumentException(
                        //"Invalid pixel_format=" + pixel_format);
            //}
            //set(KEY_PICTURE_FORMAT, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.266 -0400", hash_original_method = "646428F81142C769B950C6203EFA7A27", hash_generated_method = "2F14C0AF3F8D6D1B5246BE0AB2BA834A")
        public int getPictureFormat() {
            int var3925C55973D3676FB3D6D9AA10B68E59_1031215885 = (pixelFormatForCameraFormat(get(KEY_PICTURE_FORMAT)));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124369418 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124369418;
            // ---------- Original Method ----------
            //return pixelFormatForCameraFormat(get(KEY_PICTURE_FORMAT));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.266 -0400", hash_original_method = "4F9B3ED6FF7CCA02CA0E3B13006D79AD", hash_generated_method = "BE5D560E4DCE7D0FAA28CD7452FD6C95")
        public List<Integer> getSupportedPictureFormats() {
            String str = get(KEY_PICTURE_FORMAT + SUPPORTED_VALUES_SUFFIX);
            ArrayList<Integer> formats = new ArrayList<Integer>();
for(String s : split(str))
            {
                int f = pixelFormatForCameraFormat(s);
    if(f == ImageFormat.UNKNOWN)                
                continue;
                formats.add(f);
            } //End block
List<Integer> varA6C147B71359DA5475968801A9984115_2068856042 =             formats;
            varA6C147B71359DA5475968801A9984115_2068856042.addTaint(taint);
            return varA6C147B71359DA5475968801A9984115_2068856042;
            // ---------- Original Method ----------
            //String str = get(KEY_PICTURE_FORMAT + SUPPORTED_VALUES_SUFFIX);
            //ArrayList<Integer> formats = new ArrayList<Integer>();
            //for (String s : split(str)) {
                //int f = pixelFormatForCameraFormat(s);
                //if (f == ImageFormat.UNKNOWN) continue;
                //formats.add(f);
            //}
            //return formats;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.266 -0400", hash_original_method = "0D21EA7C9C6F68B56031C051598A724A", hash_generated_method = "B7F187A420227170303CE71F94A8D99A")
        private String cameraFormatForPixelFormat(int pixel_format) {
            addTaint(pixel_format);
switch(pixel_format){
            case ImageFormat.NV16:
String var2B4614EC86D06BA3ED48B39645981C46_677403489 =             PIXEL_FORMAT_YUV422SP;
            var2B4614EC86D06BA3ED48B39645981C46_677403489.addTaint(taint);
            return var2B4614EC86D06BA3ED48B39645981C46_677403489;
            case ImageFormat.NV21:
String var5933D6D7F8505DB41818F1554F068474_223975511 =             PIXEL_FORMAT_YUV420SP;
            var5933D6D7F8505DB41818F1554F068474_223975511.addTaint(taint);
            return var5933D6D7F8505DB41818F1554F068474_223975511;
            case ImageFormat.YUY2:
String var278AE29D9EE53BFF4BF1078214BCD4A0_442981760 =             PIXEL_FORMAT_YUV422I;
            var278AE29D9EE53BFF4BF1078214BCD4A0_442981760.addTaint(taint);
            return var278AE29D9EE53BFF4BF1078214BCD4A0_442981760;
            case ImageFormat.YV12:
String var9FCEC410889654439609393862AB7C7D_1904155746 =             PIXEL_FORMAT_YUV420P;
            var9FCEC410889654439609393862AB7C7D_1904155746.addTaint(taint);
            return var9FCEC410889654439609393862AB7C7D_1904155746;
            case ImageFormat.RGB_565:
String var71138D62768150772C679525187DED75_990966220 =             PIXEL_FORMAT_RGB565;
            var71138D62768150772C679525187DED75_990966220.addTaint(taint);
            return var71138D62768150772C679525187DED75_990966220;
            case ImageFormat.JPEG:
String varEF303409A2B5F2966C8AC1C00475691B_1059532681 =             PIXEL_FORMAT_JPEG;
            varEF303409A2B5F2966C8AC1C00475691B_1059532681.addTaint(taint);
            return varEF303409A2B5F2966C8AC1C00475691B_1059532681;
            case ImageFormat.BAYER_RGGB:
String varB7D6FF046880C0E9FD7F6C36B0DD021B_1314152371 =             PIXEL_FORMAT_BAYER_RGGB;
            varB7D6FF046880C0E9FD7F6C36B0DD021B_1314152371.addTaint(taint);
            return varB7D6FF046880C0E9FD7F6C36B0DD021B_1314152371;
            default:
String var540C13E9E156B687226421B24F2DF178_1265620360 =             null;
            var540C13E9E156B687226421B24F2DF178_1265620360.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1265620360;
}
            // ---------- Original Method ----------
            //switch(pixel_format) {
            //case ImageFormat.NV16:      return PIXEL_FORMAT_YUV422SP;
            //case ImageFormat.NV21:      return PIXEL_FORMAT_YUV420SP;
            //case ImageFormat.YUY2:      return PIXEL_FORMAT_YUV422I;
            //case ImageFormat.YV12:      return PIXEL_FORMAT_YUV420P;
            //case ImageFormat.RGB_565:   return PIXEL_FORMAT_RGB565;
            //case ImageFormat.JPEG:      return PIXEL_FORMAT_JPEG;
            //case ImageFormat.BAYER_RGGB: return PIXEL_FORMAT_BAYER_RGGB;
            //default:                    return null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.267 -0400", hash_original_method = "0B875F69B968394282E409325FD17632", hash_generated_method = "AAFD16BF019C981AD6ABE35709D9E53C")
        private int pixelFormatForCameraFormat(String format) {
            addTaint(format.getTaint());
    if(format == null)            
            {
            int var4A587B014D93EFAF8B09D309C03708AA_205184549 = (ImageFormat.UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210293161 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210293161;
            }
    if(format.equals(PIXEL_FORMAT_YUV422SP))            
            {
            int varFBCA4C6F7EDE5DFFC346AC9B425BF98B_763191883 = (ImageFormat.NV16);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99209069 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_99209069;
            }
    if(format.equals(PIXEL_FORMAT_YUV420SP))            
            {
            int var12323E7D9D19807E5CB574D21ABEC576_1864772568 = (ImageFormat.NV21);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234885427 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_234885427;
            }
    if(format.equals(PIXEL_FORMAT_YUV422I))            
            {
            int var6DADF48CBA2BCA079AB449A87D1C50A2_1328336872 = (ImageFormat.YUY2);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603776336 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603776336;
            }
    if(format.equals(PIXEL_FORMAT_YUV420P))            
            {
            int varA6C4020056706F2DAF2CA2CA461669C1_1569739070 = (ImageFormat.YV12);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110660241 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110660241;
            }
    if(format.equals(PIXEL_FORMAT_RGB565))            
            {
            int var8FCC381C7F10402FBA43E4CF309854F8_1826628751 = (ImageFormat.RGB_565);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37235211 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_37235211;
            }
    if(format.equals(PIXEL_FORMAT_JPEG))            
            {
            int var5DF011C1E971B2B7C3AAE7B308679740_302566996 = (ImageFormat.JPEG);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922095037 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922095037;
            }
            int var4A587B014D93EFAF8B09D309C03708AA_1127303025 = (ImageFormat.UNKNOWN);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41727142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41727142;
            // ---------- Original Method ----------
            //if (format == null)
                //return ImageFormat.UNKNOWN;
            //if (format.equals(PIXEL_FORMAT_YUV422SP))
                //return ImageFormat.NV16;
            //if (format.equals(PIXEL_FORMAT_YUV420SP))
                //return ImageFormat.NV21;
            //if (format.equals(PIXEL_FORMAT_YUV422I))
                //return ImageFormat.YUY2;
            //if (format.equals(PIXEL_FORMAT_YUV420P))
                //return ImageFormat.YV12;
            //if (format.equals(PIXEL_FORMAT_RGB565))
                //return ImageFormat.RGB_565;
            //if (format.equals(PIXEL_FORMAT_JPEG))
                //return ImageFormat.JPEG;
            //return ImageFormat.UNKNOWN;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.267 -0400", hash_original_method = "7F1F8FE07039060100EB7EAEC293220B", hash_generated_method = "0537E4AF6AD3F313BABD35E9EC10234B")
        public void setRotation(int rotation) {
            addTaint(rotation);
    if(rotation == 0 || rotation == 90 || rotation == 180
                    || rotation == 270)            
            {
                set(KEY_ROTATION, Integer.toString(rotation));
            } //End block
            else
            {
                IllegalArgumentException var8FBCDCFF7DB4524B9C1CC780FDC2BA5C_1176081018 = new IllegalArgumentException(
                        "Invalid rotation=" + rotation);
                var8FBCDCFF7DB4524B9C1CC780FDC2BA5C_1176081018.addTaint(taint);
                throw var8FBCDCFF7DB4524B9C1CC780FDC2BA5C_1176081018;
            } //End block
            // ---------- Original Method ----------
            //if (rotation == 0 || rotation == 90 || rotation == 180
                    //|| rotation == 270) {
                //set(KEY_ROTATION, Integer.toString(rotation));
            //} else {
                //throw new IllegalArgumentException(
                        //"Invalid rotation=" + rotation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.267 -0400", hash_original_method = "BEFE742BAEEA8C90DDA5ADB3E09F2E6F", hash_generated_method = "CCF41D016DA9A48B7D81A1263905F2EA")
        public void setGpsLatitude(double latitude) {
            addTaint(latitude);
            set(KEY_GPS_LATITUDE, Double.toString(latitude));
            // ---------- Original Method ----------
            //set(KEY_GPS_LATITUDE, Double.toString(latitude));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "15D67DC442B59D8C20F49D295A03B9C3", hash_generated_method = "12C61D708922285D9EE510672C4B9DD6")
        public void setGpsLongitude(double longitude) {
            addTaint(longitude);
            set(KEY_GPS_LONGITUDE, Double.toString(longitude));
            // ---------- Original Method ----------
            //set(KEY_GPS_LONGITUDE, Double.toString(longitude));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "D37B20DFD4F471A556A1A3948D012F6F", hash_generated_method = "C26297EEC346BE50B2715E0F46766663")
        public void setGpsAltitude(double altitude) {
            addTaint(altitude);
            set(KEY_GPS_ALTITUDE, Double.toString(altitude));
            // ---------- Original Method ----------
            //set(KEY_GPS_ALTITUDE, Double.toString(altitude));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "E7E121605EA7F31AA54C4E2FEA0A633A", hash_generated_method = "CF784F3A2C1E765687B724D0AE7167D2")
        public void setGpsTimestamp(long timestamp) {
            addTaint(timestamp);
            set(KEY_GPS_TIMESTAMP, Long.toString(timestamp));
            // ---------- Original Method ----------
            //set(KEY_GPS_TIMESTAMP, Long.toString(timestamp));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "EB21E6C6306284106B5612462912EE4A", hash_generated_method = "7CF4C7593C4484453CA0DCC8A28FEDEC")
        public void setGpsProcessingMethod(String processing_method) {
            addTaint(processing_method.getTaint());
            set(KEY_GPS_PROCESSING_METHOD, processing_method);
            // ---------- Original Method ----------
            //set(KEY_GPS_PROCESSING_METHOD, processing_method);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "DB2725AB8B49886BA5EC1CA9683A5411", hash_generated_method = "1504AD03D103CAF115A573FEFFF23B29")
        public void removeGpsData() {
            remove(KEY_GPS_LATITUDE);
            remove(KEY_GPS_LONGITUDE);
            remove(KEY_GPS_ALTITUDE);
            remove(KEY_GPS_TIMESTAMP);
            remove(KEY_GPS_PROCESSING_METHOD);
            // ---------- Original Method ----------
            //remove(KEY_GPS_LATITUDE);
            //remove(KEY_GPS_LONGITUDE);
            //remove(KEY_GPS_ALTITUDE);
            //remove(KEY_GPS_TIMESTAMP);
            //remove(KEY_GPS_PROCESSING_METHOD);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.268 -0400", hash_original_method = "F88C937231FAAF4C00547B817FC6B121", hash_generated_method = "FAEF2AF395DF41F714F9F2D36E6E980E")
        public String getWhiteBalance() {
String var162FDB752A2DCFC7BB9979E380308C6A_1723174366 =             get(KEY_WHITE_BALANCE);
            var162FDB752A2DCFC7BB9979E380308C6A_1723174366.addTaint(taint);
            return var162FDB752A2DCFC7BB9979E380308C6A_1723174366;
            // ---------- Original Method ----------
            //return get(KEY_WHITE_BALANCE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "F368B7E42EFB4E89424B346F78A99160", hash_generated_method = "9E7ADED03C0091F0AC0B82A32A297A56")
        public void setWhiteBalance(String value) {
            addTaint(value.getTaint());
            String oldValue = get(KEY_WHITE_BALANCE);
    if(same(value, oldValue))            
            return;
            set(KEY_WHITE_BALANCE, value);
            set(KEY_AUTO_WHITEBALANCE_LOCK, FALSE);
            // ---------- Original Method ----------
            //String oldValue = get(KEY_WHITE_BALANCE);
            //if (same(value, oldValue)) return;
            //set(KEY_WHITE_BALANCE, value);
            //set(KEY_AUTO_WHITEBALANCE_LOCK, FALSE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "6BD64FEF1410D0D6447FCBDB1167D9B6", hash_generated_method = "08AF831B849622B0B9A7594299A5C964")
        public List<String> getSupportedWhiteBalance() {
            String str = get(KEY_WHITE_BALANCE + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_928949368 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_928949368.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_928949368;
            // ---------- Original Method ----------
            //String str = get(KEY_WHITE_BALANCE + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "EBDE73BA19867EBFCE22D321F450F04C", hash_generated_method = "87CF3C1AA3E8DB95D7B63B055C2A7E7B")
        public String getColorEffect() {
String var65843531F47CE0B77B7A873D32DD3BE3_809958851 =             get(KEY_EFFECT);
            var65843531F47CE0B77B7A873D32DD3BE3_809958851.addTaint(taint);
            return var65843531F47CE0B77B7A873D32DD3BE3_809958851;
            // ---------- Original Method ----------
            //return get(KEY_EFFECT);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "0DAF9E55870C866B1D9028B63F9B1051", hash_generated_method = "D120736935866895D820A261C6BCF523")
        public void setColorEffect(String value) {
            addTaint(value.getTaint());
            set(KEY_EFFECT, value);
            // ---------- Original Method ----------
            //set(KEY_EFFECT, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "17E8CABB5939F7293955A7E6B8E9706B", hash_generated_method = "5B2CB451B03B1F3E2E5EE72916F6097C")
        public List<String> getSupportedColorEffects() {
            String str = get(KEY_EFFECT + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_1955536546 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_1955536546.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_1955536546;
            // ---------- Original Method ----------
            //String str = get(KEY_EFFECT + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.269 -0400", hash_original_method = "BF4FDA8351654C2EB61A4F54B91D348E", hash_generated_method = "BF82B402C5BA4F099C26525CC4A0BB5A")
        public String getAntibanding() {
String varA462095878216C7A9E438AABF75860C4_1892393455 =             get(KEY_ANTIBANDING);
            varA462095878216C7A9E438AABF75860C4_1892393455.addTaint(taint);
            return varA462095878216C7A9E438AABF75860C4_1892393455;
            // ---------- Original Method ----------
            //return get(KEY_ANTIBANDING);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "985E6B38FF8AC0EB85AFEB9A2D7D5D97", hash_generated_method = "E9A54503FB3861130DE890A18DB5AF5F")
        public void setAntibanding(String antibanding) {
            addTaint(antibanding.getTaint());
            set(KEY_ANTIBANDING, antibanding);
            // ---------- Original Method ----------
            //set(KEY_ANTIBANDING, antibanding);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "2747115FB870E356DAC02162754EC48E", hash_generated_method = "43BC9D22A567CEAF1955BC28F9103972")
        public List<String> getSupportedAntibanding() {
            String str = get(KEY_ANTIBANDING + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_1217999912 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_1217999912.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_1217999912;
            // ---------- Original Method ----------
            //String str = get(KEY_ANTIBANDING + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "392D4B71E895D4140EEFD980EB15B5EB", hash_generated_method = "788346022E2CBC929036C59D9D2E09F3")
        public String getSceneMode() {
String varD3E1C982A4F0598916971CC6D80CBF43_872303368 =             get(KEY_SCENE_MODE);
            varD3E1C982A4F0598916971CC6D80CBF43_872303368.addTaint(taint);
            return varD3E1C982A4F0598916971CC6D80CBF43_872303368;
            // ---------- Original Method ----------
            //return get(KEY_SCENE_MODE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "F340D9AF77CABF3FCAC1513FFFE1B10A", hash_generated_method = "F167AD8B422EBA866D0F6E4E02BD0C78")
        public void setSceneMode(String value) {
            addTaint(value.getTaint());
            set(KEY_SCENE_MODE, value);
            // ---------- Original Method ----------
            //set(KEY_SCENE_MODE, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "AB0AD307D147C1A6D4713ECB3D12ACCF", hash_generated_method = "EF906F443498331DC704C3D580D5F3BD")
        public List<String> getSupportedSceneModes() {
            String str = get(KEY_SCENE_MODE + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_407665531 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_407665531.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_407665531;
            // ---------- Original Method ----------
            //String str = get(KEY_SCENE_MODE + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.270 -0400", hash_original_method = "7750780C979B83A925E226C6EFF8842D", hash_generated_method = "AAFC9FE72D4AE214AE7017C1C719E667")
        public String getFlashMode() {
String var61D441CA751E53F2847CE8BE75431A6E_1950669089 =             get(KEY_FLASH_MODE);
            var61D441CA751E53F2847CE8BE75431A6E_1950669089.addTaint(taint);
            return var61D441CA751E53F2847CE8BE75431A6E_1950669089;
            // ---------- Original Method ----------
            //return get(KEY_FLASH_MODE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.271 -0400", hash_original_method = "C9F8B5AECF6107B196C9E01FA7C3624E", hash_generated_method = "C6805E1DBB9B0A62F1D0C14C4E2D4696")
        public void setFlashMode(String value) {
            addTaint(value.getTaint());
            set(KEY_FLASH_MODE, value);
            // ---------- Original Method ----------
            //set(KEY_FLASH_MODE, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.271 -0400", hash_original_method = "9F7096D0E359D5569731888F2DB333B8", hash_generated_method = "4CF05729A2EA8040AD95A5F15BD13DC2")
        public List<String> getSupportedFlashModes() {
            String str = get(KEY_FLASH_MODE + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_497461257 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_497461257.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_497461257;
            // ---------- Original Method ----------
            //String str = get(KEY_FLASH_MODE + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.271 -0400", hash_original_method = "E2184619B509409238D8385BD3A054E5", hash_generated_method = "9A029E5AFF341B0F0C70A8B9AB8534E0")
        public String getFocusMode() {
String var2FF80F6BB95EAF11398DF7E074C52CD5_1600275202 =             get(KEY_FOCUS_MODE);
            var2FF80F6BB95EAF11398DF7E074C52CD5_1600275202.addTaint(taint);
            return var2FF80F6BB95EAF11398DF7E074C52CD5_1600275202;
            // ---------- Original Method ----------
            //return get(KEY_FOCUS_MODE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.271 -0400", hash_original_method = "7416CBC128B7B3D1CBE2DFA875979AFE", hash_generated_method = "E6AD61BDE3E1592253469BC28BDCE5FD")
        public void setFocusMode(String value) {
            addTaint(value.getTaint());
            set(KEY_FOCUS_MODE, value);
            // ---------- Original Method ----------
            //set(KEY_FOCUS_MODE, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.271 -0400", hash_original_method = "87EBF137327885002F74E14885E0F854", hash_generated_method = "E2A083ADA78B71763250F3502BEF283A")
        public List<String> getSupportedFocusModes() {
            String str = get(KEY_FOCUS_MODE + SUPPORTED_VALUES_SUFFIX);
List<String> varC955949883608661A3A13ACB6D16DDF1_100233098 =             split(str);
            varC955949883608661A3A13ACB6D16DDF1_100233098.addTaint(taint);
            return varC955949883608661A3A13ACB6D16DDF1_100233098;
            // ---------- Original Method ----------
            //String str = get(KEY_FOCUS_MODE + SUPPORTED_VALUES_SUFFIX);
            //return split(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "280C651533E602E83169E9949FF56CC5", hash_generated_method = "28A6EBBD781B343310D2CF205DF3F0E9")
        public float getFocalLength() {
            float var9AF59BC54DFEEC3D27B5CAEE9A7711FC_1788144428 = (Float.parseFloat(get(KEY_FOCAL_LENGTH)));
                        float var546ADE640B6EDFBC8A086EF31347E768_202119985 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_202119985;
            // ---------- Original Method ----------
            //return Float.parseFloat(get(KEY_FOCAL_LENGTH));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "E095E3B11FF628CF893AB471782FDC45", hash_generated_method = "F7E1A2FD8EFAF0B9CF7D7451D20D09B4")
        public float getHorizontalViewAngle() {
            float var4776DC17A20BEE60E22B4FBB3AF30D1D_1458731585 = (Float.parseFloat(get(KEY_HORIZONTAL_VIEW_ANGLE)));
                        float var546ADE640B6EDFBC8A086EF31347E768_1402437543 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1402437543;
            // ---------- Original Method ----------
            //return Float.parseFloat(get(KEY_HORIZONTAL_VIEW_ANGLE));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "A3A0BD560F956F2DE67EDBBDC96AF08A", hash_generated_method = "FBA36078558F7A98A7673DBA94012071")
        public float getVerticalViewAngle() {
            float var993558305157555D80BBC32814E96751_2040761473 = (Float.parseFloat(get(KEY_VERTICAL_VIEW_ANGLE)));
                        float var546ADE640B6EDFBC8A086EF31347E768_946072157 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_946072157;
            // ---------- Original Method ----------
            //return Float.parseFloat(get(KEY_VERTICAL_VIEW_ANGLE));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "5FCFE536B3898D346449D108449D390F", hash_generated_method = "0CCACB1B0CE158034A328694DA16D542")
        public int getExposureCompensation() {
            int var2F36DF993F69D423B4A4D8A4CC086A44_594204674 = (getInt(KEY_EXPOSURE_COMPENSATION, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607893539 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607893539;
            // ---------- Original Method ----------
            //return getInt(KEY_EXPOSURE_COMPENSATION, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "111B767E933C2CD9576CD967C7CB52EF", hash_generated_method = "F0E6E5605A20A8CF353CD04EC9BBF601")
        public void setExposureCompensation(int value) {
            addTaint(value);
            set(KEY_EXPOSURE_COMPENSATION, value);
            // ---------- Original Method ----------
            //set(KEY_EXPOSURE_COMPENSATION, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "075FA30D94BD252A505071BE80B3A2DE", hash_generated_method = "E29118EF7BEC1A3953976A3E2F92B816")
        public int getMaxExposureCompensation() {
            int var5580EA1EF51FF4ACBFB9866486EAABFC_1907269402 = (getInt(KEY_MAX_EXPOSURE_COMPENSATION, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299626831 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299626831;
            // ---------- Original Method ----------
            //return getInt(KEY_MAX_EXPOSURE_COMPENSATION, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.272 -0400", hash_original_method = "B03007C077325F58AA26E52D0D9C3FEA", hash_generated_method = "DDF5424B7A0CF8DF2F466DD72683DD81")
        public int getMinExposureCompensation() {
            int var15452B3016748F670AB1D8431279E8B1_2080116362 = (getInt(KEY_MIN_EXPOSURE_COMPENSATION, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964564668 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_964564668;
            // ---------- Original Method ----------
            //return getInt(KEY_MIN_EXPOSURE_COMPENSATION, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "9B0A72FE96E27833E9483AB189C9FCA2", hash_generated_method = "32EB3E7B4A2E0774AC4B32D9D80CCEC4")
        public float getExposureCompensationStep() {
            float var9707E11E3A752DE22ADAA6CFB38C9F26_483376840 = (getFloat(KEY_EXPOSURE_COMPENSATION_STEP, 0));
                        float var546ADE640B6EDFBC8A086EF31347E768_197519405 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_197519405;
            // ---------- Original Method ----------
            //return getFloat(KEY_EXPOSURE_COMPENSATION_STEP, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "FB8CC317CA960BD5E74A2557DE2CFB32", hash_generated_method = "B5BC6E0700ED763E23D257D2E2603543")
        public void setAutoExposureLock(boolean toggle) {
            addTaint(toggle);
            set(KEY_AUTO_EXPOSURE_LOCK, toggle ? TRUE : FALSE);
            // ---------- Original Method ----------
            //set(KEY_AUTO_EXPOSURE_LOCK, toggle ? TRUE : FALSE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "1B30FBAE422A22E9908E62CE6CA17AA9", hash_generated_method = "D6773D90417A9FFCB5B4E2582BB7568E")
        public boolean getAutoExposureLock() {
            String str = get(KEY_AUTO_EXPOSURE_LOCK);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_1568383970 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659415726 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659415726;
            // ---------- Original Method ----------
            //String str = get(KEY_AUTO_EXPOSURE_LOCK);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "E05124C1C1E1A7B4964E51C638A3C3B5", hash_generated_method = "5A9736931FAFB89D20DD9749BD33F0E6")
        public boolean isAutoExposureLockSupported() {
            String str = get(KEY_AUTO_EXPOSURE_LOCK_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_967618182 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725871087 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725871087;
            // ---------- Original Method ----------
            //String str = get(KEY_AUTO_EXPOSURE_LOCK_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "9FBB2F0BD63C7724B00563EB3EE35866", hash_generated_method = "8807F78965D99C82C41EF69ACB0640D0")
        public void setAutoWhiteBalanceLock(boolean toggle) {
            addTaint(toggle);
            set(KEY_AUTO_WHITEBALANCE_LOCK, toggle ? TRUE : FALSE);
            // ---------- Original Method ----------
            //set(KEY_AUTO_WHITEBALANCE_LOCK, toggle ? TRUE : FALSE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "DB49969BE763FDBEDE4F85AE81AF7414", hash_generated_method = "77D6CBA2AB9ACF3EBD6A4E0A48F0D0FB")
        public boolean getAutoWhiteBalanceLock() {
            String str = get(KEY_AUTO_WHITEBALANCE_LOCK);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_1437060763 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951829669 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_951829669;
            // ---------- Original Method ----------
            //String str = get(KEY_AUTO_WHITEBALANCE_LOCK);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.273 -0400", hash_original_method = "582DA557975EDBC4031144342808C588", hash_generated_method = "7660338487EB3BC448CCE5359735EF37")
        public boolean isAutoWhiteBalanceLockSupported() {
            String str = get(KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_1509663250 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141921237 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141921237;
            // ---------- Original Method ----------
            //String str = get(KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "3CA678C8AE8E3F66428134128CE7EEC9", hash_generated_method = "7CE83DA1833D197D0BB31A24AEE23019")
        public int getZoom() {
            int var97E1F5E4E13A918691C935EE7835BCD0_1836486667 = (getInt(KEY_ZOOM, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001289460 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001289460;
            // ---------- Original Method ----------
            //return getInt(KEY_ZOOM, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "4C7A1B4E8D019C0A8169E6EC8AF83500", hash_generated_method = "62087358B2E6464694A644DFD1227C67")
        public void setZoom(int value) {
            addTaint(value);
            set(KEY_ZOOM, value);
            // ---------- Original Method ----------
            //set(KEY_ZOOM, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "9BC52CB9DEDB85378C3A87D204A88D43", hash_generated_method = "64645D693EC58416E68800C147915F91")
        public boolean isZoomSupported() {
            String str = get(KEY_ZOOM_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_2007370904 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564690922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_564690922;
            // ---------- Original Method ----------
            //String str = get(KEY_ZOOM_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "047686B9E00911FFF108E905AC4D01AC", hash_generated_method = "4425E620FE693029974170237DDEA502")
        public int getMaxZoom() {
            int var38488DDE37E3757F52939BD8115E6C88_1331821939 = (getInt(KEY_MAX_ZOOM, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606450185 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606450185;
            // ---------- Original Method ----------
            //return getInt(KEY_MAX_ZOOM, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "3F0D9961D3094722470195F17ED59ED1", hash_generated_method = "C422D09DFA04A217CDDB5F0DF3DFFF1B")
        public List<Integer> getZoomRatios() {
List<Integer> var277071CC198676A413FE15E1C36BE02C_1767475697 =             splitInt(get(KEY_ZOOM_RATIOS));
            var277071CC198676A413FE15E1C36BE02C_1767475697.addTaint(taint);
            return var277071CC198676A413FE15E1C36BE02C_1767475697;
            // ---------- Original Method ----------
            //return splitInt(get(KEY_ZOOM_RATIOS));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "A25EF2BBFA6ADFE30D398F5593DBFB40", hash_generated_method = "7BB5945FA450917489F6AC1FB5952AC0")
        public boolean isSmoothZoomSupported() {
            String str = get(KEY_SMOOTH_ZOOM_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_247908485 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776865202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_776865202;
            // ---------- Original Method ----------
            //String str = get(KEY_SMOOTH_ZOOM_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.274 -0400", hash_original_method = "DB1A67BAD99765C9966F6C6DFD16815F", hash_generated_method = "5DB7D2102A30CA20840B6AF27E88C047")
        public void getFocusDistances(float[] output) {
            addTaint(output[0]);
    if(output == null || output.length != 3)            
            {
                IllegalArgumentException var36B50C462E18C2116145E4065674987D_1802809155 = new IllegalArgumentException(
                        "output must be an float array with three elements.");
                var36B50C462E18C2116145E4065674987D_1802809155.addTaint(taint);
                throw var36B50C462E18C2116145E4065674987D_1802809155;
            } //End block
            splitFloat(get(KEY_FOCUS_DISTANCES), output);
            // ---------- Original Method ----------
            //if (output == null || output.length != 3) {
                //throw new IllegalArgumentException(
                        //"output must be an float array with three elements.");
            //}
            //splitFloat(get(KEY_FOCUS_DISTANCES), output);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "B9C518AE022CEE0A2E16335F0D4F42AA", hash_generated_method = "B7C906B3F86F66E825904D7F446CC013")
        public int getMaxNumFocusAreas() {
            int varA30074CD5351368C4CD5F278BC57D3AD_1631344028 = (getInt(KEY_MAX_NUM_FOCUS_AREAS, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141062880 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141062880;
            // ---------- Original Method ----------
            //return getInt(KEY_MAX_NUM_FOCUS_AREAS, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "1F7F1457F62663F3FBD9FCD39F49FAC0", hash_generated_method = "B2E0509E237B93760FC67ED93517BE69")
        public List<Area> getFocusAreas() {
List<Area> var9D78619BA378A541FE659CA695E6A871_284574242 =             splitArea(get(KEY_FOCUS_AREAS));
            var9D78619BA378A541FE659CA695E6A871_284574242.addTaint(taint);
            return var9D78619BA378A541FE659CA695E6A871_284574242;
            // ---------- Original Method ----------
            //return splitArea(get(KEY_FOCUS_AREAS));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "282CBAFBAC13AEC2BEC36481C427E569", hash_generated_method = "C726D3E9844CE8FB86530C0955CC6192")
        public void setFocusAreas(List<Area> focusAreas) {
            addTaint(focusAreas.getTaint());
            set(KEY_FOCUS_AREAS, focusAreas);
            // ---------- Original Method ----------
            //set(KEY_FOCUS_AREAS, focusAreas);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "A4B96F518C484696647FE84A6B3DFFDC", hash_generated_method = "C67A211659EFE29971546AD190A0E336")
        public int getMaxNumMeteringAreas() {
            int var420D3296D03562E6D48DF7BF51B21EC7_1779180805 = (getInt(KEY_MAX_NUM_METERING_AREAS, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519605685 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_519605685;
            // ---------- Original Method ----------
            //return getInt(KEY_MAX_NUM_METERING_AREAS, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "4184DAADE6BD6ABC78AAB559556E3679", hash_generated_method = "2663F7DF43238A34A190F5BCA90215C2")
        public List<Area> getMeteringAreas() {
List<Area> varBC04EAEB3D8321B0BA2D46492A405A0B_1011834471 =             splitArea(get(KEY_METERING_AREAS));
            varBC04EAEB3D8321B0BA2D46492A405A0B_1011834471.addTaint(taint);
            return varBC04EAEB3D8321B0BA2D46492A405A0B_1011834471;
            // ---------- Original Method ----------
            //return splitArea(get(KEY_METERING_AREAS));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.275 -0400", hash_original_method = "EDE536DB365D3616ED4EF1065A695BCF", hash_generated_method = "1836286A47D464455E37BEFCF31B96C6")
        public void setMeteringAreas(List<Area> meteringAreas) {
            addTaint(meteringAreas.getTaint());
            set(KEY_METERING_AREAS, meteringAreas);
            // ---------- Original Method ----------
            //set(KEY_METERING_AREAS, meteringAreas);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "A3F920DAF0FA1FD5B4F8D56BF37CB7C9", hash_generated_method = "E96A84C8BD487C0D8FBFA409A79CA92D")
        public int getMaxNumDetectedFaces() {
            int varE7F2EFD40AA609FDF21E8692EDB8B6AD_1007641768 = (getInt(KEY_MAX_NUM_DETECTED_FACES_HW, 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831883779 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1831883779;
            // ---------- Original Method ----------
            //return getInt(KEY_MAX_NUM_DETECTED_FACES_HW, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "77706BF984161454A07D20CFA20843D2", hash_generated_method = "047EAFC7F83064A17E9E94052D44FCFD")
        public void setRecordingHint(boolean hint) {
            addTaint(hint);
            set(KEY_RECORDING_HINT, hint ? TRUE : FALSE);
            // ---------- Original Method ----------
            //set(KEY_RECORDING_HINT, hint ? TRUE : FALSE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "0F8567B579C137B716477627D7F3A934", hash_generated_method = "6DCF4A162B5EF2F31214F89A166C5304")
        public boolean isVideoSnapshotSupported() {
            String str = get(KEY_VIDEO_SNAPSHOT_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_206922677 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829256246 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829256246;
            // ---------- Original Method ----------
            //String str = get(KEY_VIDEO_SNAPSHOT_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "9F60C08F2ED5DD6FF6AE5E03CD68E34B", hash_generated_method = "5728AB633799C3FF8B93119E9DA36D20")
        public void setVideoStabilization(boolean toggle) {
            addTaint(toggle);
            set(KEY_VIDEO_STABILIZATION, toggle ? TRUE : FALSE);
            // ---------- Original Method ----------
            //set(KEY_VIDEO_STABILIZATION, toggle ? TRUE : FALSE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "206980091DCF06EE02F8F95474290B64", hash_generated_method = "FB6EBD3D3623FB58E6B0D41D3F3B47A7")
        public boolean getVideoStabilization() {
            String str = get(KEY_VIDEO_STABILIZATION);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_1747061795 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624458532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624458532;
            // ---------- Original Method ----------
            //String str = get(KEY_VIDEO_STABILIZATION);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.276 -0400", hash_original_method = "7565DC492C39C0F6D368D835BD28A381", hash_generated_method = "FA2FE9095756E64B5B1BC9022261EAE4")
        public boolean isVideoStabilizationSupported() {
            String str = get(KEY_VIDEO_STABILIZATION_SUPPORTED);
            boolean varFA87CDAED7021F7E68E32E30368B61C6_750636630 = (TRUE.equals(str));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740444296 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740444296;
            // ---------- Original Method ----------
            //String str = get(KEY_VIDEO_STABILIZATION_SUPPORTED);
            //return TRUE.equals(str);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.277 -0400", hash_original_method = "7DB6EA73F79E9017B4C9B1640096A943", hash_generated_method = "40ECB1D6A22584BF85B08605FC71AAC7")
        private ArrayList<String> split(String str) {
            addTaint(str.getTaint());
    if(str == null)            
            {
ArrayList<String> var540C13E9E156B687226421B24F2DF178_451736139 =             null;
            var540C13E9E156B687226421B24F2DF178_451736139.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_451736139;
            }
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<String> substrings = new ArrayList<String>();
            while
(tokenizer.hasMoreElements())            
            {
                substrings.add(tokenizer.nextToken());
            } //End block
ArrayList<String> varF0ABD9677D3E9B56568CE72C8E5EBEE5_1955398408 =             substrings;
            varF0ABD9677D3E9B56568CE72C8E5EBEE5_1955398408.addTaint(taint);
            return varF0ABD9677D3E9B56568CE72C8E5EBEE5_1955398408;
            // ---------- Original Method ----------
            //if (str == null) return null;
            //StringTokenizer tokenizer = new StringTokenizer(str, ",");
            //ArrayList<String> substrings = new ArrayList<String>();
            //while (tokenizer.hasMoreElements()) {
                //substrings.add(tokenizer.nextToken());
            //}
            //return substrings;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.277 -0400", hash_original_method = "5A3E8F077877CF7C521516BE6C2EF1CA", hash_generated_method = "9DB20F4C1852FCEB3D08C97EDC3AF5E8")
        private ArrayList<Integer> splitInt(String str) {
            addTaint(str.getTaint());
    if(str == null)            
            {
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_73398169 =             null;
            var540C13E9E156B687226421B24F2DF178_73398169.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_73398169;
            }
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<Integer> substrings = new ArrayList<Integer>();
            while
(tokenizer.hasMoreElements())            
            {
                String token = tokenizer.nextToken();
                substrings.add(Integer.parseInt(token));
            } //End block
    if(substrings.size() == 0)            
            {
ArrayList<Integer> var540C13E9E156B687226421B24F2DF178_1567392804 =             null;
            var540C13E9E156B687226421B24F2DF178_1567392804.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1567392804;
            }
ArrayList<Integer> varF0ABD9677D3E9B56568CE72C8E5EBEE5_1105228748 =             substrings;
            varF0ABD9677D3E9B56568CE72C8E5EBEE5_1105228748.addTaint(taint);
            return varF0ABD9677D3E9B56568CE72C8E5EBEE5_1105228748;
            // ---------- Original Method ----------
            //if (str == null) return null;
            //StringTokenizer tokenizer = new StringTokenizer(str, ",");
            //ArrayList<Integer> substrings = new ArrayList<Integer>();
            //while (tokenizer.hasMoreElements()) {
                //String token = tokenizer.nextToken();
                //substrings.add(Integer.parseInt(token));
            //}
            //if (substrings.size() == 0) return null;
            //return substrings;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.277 -0400", hash_original_method = "DBE0F4460205976847C38EA4BE2E4232", hash_generated_method = "F1A5A4F3FEDFD60C15A2BC22FAC21662")
        private void splitInt(String str, int[] output) {
            addTaint(output[0]);
            addTaint(str.getTaint());
    if(str == null)            
            return;
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            int index = 0;
            while
(tokenizer.hasMoreElements())            
            {
                String token = tokenizer.nextToken();
                output[index++] = Integer.parseInt(token);
            } //End block
            // ---------- Original Method ----------
            //if (str == null) return;
            //StringTokenizer tokenizer = new StringTokenizer(str, ",");
            //int index = 0;
            //while (tokenizer.hasMoreElements()) {
                //String token = tokenizer.nextToken();
                //output[index++] = Integer.parseInt(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.277 -0400", hash_original_method = "2EDF646B69F6A8ADE910B245928A49CF", hash_generated_method = "705C7A4CD08E5D5E4024B1AA974372AD")
        private void splitFloat(String str, float[] output) {
            addTaint(output[0]);
            addTaint(str.getTaint());
    if(str == null)            
            return;
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            int index = 0;
            while
(tokenizer.hasMoreElements())            
            {
                String token = tokenizer.nextToken();
                output[index++] = Float.parseFloat(token);
            } //End block
            // ---------- Original Method ----------
            //if (str == null) return;
            //StringTokenizer tokenizer = new StringTokenizer(str, ",");
            //int index = 0;
            //while (tokenizer.hasMoreElements()) {
                //String token = tokenizer.nextToken();
                //output[index++] = Float.parseFloat(token);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.278 -0400", hash_original_method = "32BB9C0678FCAB5D5E885CB3C8B58074", hash_generated_method = "AE606B29226F4A67971EDBB497281902")
        private float getFloat(String key, float defaultValue) {
            addTaint(defaultValue);
            addTaint(key.getTaint());
            try 
            {
                float var2FE0D90AC1B13160EB180E1A53D1D9F1_151104044 = (Float.parseFloat(mMap.get(key)));
                                float var546ADE640B6EDFBC8A086EF31347E768_547026389 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_547026389;
            } //End block
            catch (NumberFormatException ex)
            {
                float var16830A58E1E33A4163524366BA7B701B_2024787622 = (defaultValue);
                                float var546ADE640B6EDFBC8A086EF31347E768_1499216859 = getTaintFloat();
                return var546ADE640B6EDFBC8A086EF31347E768_1499216859;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return Float.parseFloat(mMap.get(key));
            //} catch (NumberFormatException ex) {
                //return defaultValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.278 -0400", hash_original_method = "E02D965FA231D61DD75FA13C6C4B926A", hash_generated_method = "718091B3E8651751A416287ACB8E5828")
        private int getInt(String key, int defaultValue) {
            addTaint(defaultValue);
            addTaint(key.getTaint());
            try 
            {
                int var065A0EC7C05D7BFA29A33E9C4D5F409A_253321687 = (Integer.parseInt(mMap.get(key)));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540610550 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540610550;
            } //End block
            catch (NumberFormatException ex)
            {
                int var16830A58E1E33A4163524366BA7B701B_1419117064 = (defaultValue);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108821171 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108821171;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return Integer.parseInt(mMap.get(key));
            //} catch (NumberFormatException ex) {
                //return defaultValue;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.278 -0400", hash_original_method = "E566E7E786C257334A0A0BEDDD18D728", hash_generated_method = "34BFDB5C1394ED00353CCB4AF1EA1611")
        private ArrayList<Size> splitSize(String str) {
            addTaint(str.getTaint());
    if(str == null)            
            {
ArrayList<Size> var540C13E9E156B687226421B24F2DF178_1766545059 =             null;
            var540C13E9E156B687226421B24F2DF178_1766545059.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1766545059;
            }
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            ArrayList<Size> sizeList = new ArrayList<Size>();
            while
(tokenizer.hasMoreElements())            
            {
                Size size = strToSize(tokenizer.nextToken());
    if(size != null)                
                sizeList.add(size);
            } //End block
    if(sizeList.size() == 0)            
            {
ArrayList<Size> var540C13E9E156B687226421B24F2DF178_854329344 =             null;
            var540C13E9E156B687226421B24F2DF178_854329344.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_854329344;
            }
ArrayList<Size> var0109ED1127796FF3F24C24AF57D9DD4A_768482516 =             sizeList;
            var0109ED1127796FF3F24C24AF57D9DD4A_768482516.addTaint(taint);
            return var0109ED1127796FF3F24C24AF57D9DD4A_768482516;
            // ---------- Original Method ----------
            //if (str == null) return null;
            //StringTokenizer tokenizer = new StringTokenizer(str, ",");
            //ArrayList<Size> sizeList = new ArrayList<Size>();
            //while (tokenizer.hasMoreElements()) {
                //Size size = strToSize(tokenizer.nextToken());
                //if (size != null) sizeList.add(size);
            //}
            //if (sizeList.size() == 0) return null;
            //return sizeList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.278 -0400", hash_original_method = "864DD200C5D193B819BF575556422CF5", hash_generated_method = "B99ECD7D72D61F59CE915B8A47C16302")
        private Size strToSize(String str) {
            addTaint(str.getTaint());
    if(str == null)            
            {
Size var540C13E9E156B687226421B24F2DF178_1872633930 =             null;
            var540C13E9E156B687226421B24F2DF178_1872633930.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1872633930;
            }
            int pos = str.indexOf('x');
    if(pos != -1)            
            {
                String width = str.substring(0, pos);
                String height = str.substring(pos + 1);
Size varF1A431BF4DE48CB2CAB419C60122AB11_1584421377 =                 new Size(Integer.parseInt(width),
                                Integer.parseInt(height));
                varF1A431BF4DE48CB2CAB419C60122AB11_1584421377.addTaint(taint);
                return varF1A431BF4DE48CB2CAB419C60122AB11_1584421377;
            } //End block
Size var540C13E9E156B687226421B24F2DF178_497317448 =             null;
            var540C13E9E156B687226421B24F2DF178_497317448.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_497317448;
            // ---------- Original Method ----------
            //if (str == null) return null;
            //int pos = str.indexOf('x');
            //if (pos != -1) {
                //String width = str.substring(0, pos);
                //String height = str.substring(pos + 1);
                //return new Size(Integer.parseInt(width),
                                //Integer.parseInt(height));
            //}
            //Log.e(TAG, "Invalid size parameter string=" + str);
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.279 -0400", hash_original_method = "F39DEDF83E61AF664CA09AF99218A1A8", hash_generated_method = "90A5B4B939816E75447CF9D809EEDE0A")
        private ArrayList<int[]> splitRange(String str) {
            addTaint(str.getTaint());
    if(str == null || str.charAt(0) != '('
                    || str.charAt(str.length() - 1) != ')')            
            {
ArrayList<int[]> var540C13E9E156B687226421B24F2DF178_327587449 =                 null;
                var540C13E9E156B687226421B24F2DF178_327587449.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_327587449;
            } //End block
            ArrayList<int[]> rangeList = new ArrayList<int[]>();
            int endIndex;
            int fromIndex = 1;
            do {
                {
                    int[] range = new int[2];
                    endIndex = str.indexOf("),(", fromIndex);
    if(endIndex == -1)                    
                    endIndex = str.length() - 1;
                    splitInt(str.substring(fromIndex, endIndex), range);
                    rangeList.add(range);
                    fromIndex = endIndex + 3;
                } //End block
} while (endIndex != str.length() - 1);
    if(rangeList.size() == 0)            
            {
ArrayList<int[]> var540C13E9E156B687226421B24F2DF178_1990345141 =             null;
            var540C13E9E156B687226421B24F2DF178_1990345141.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1990345141;
            }
ArrayList<int[]> var747F178C24DED81A7324DAF447AA8FF7_342790327 =             rangeList;
            var747F178C24DED81A7324DAF447AA8FF7_342790327.addTaint(taint);
            return var747F178C24DED81A7324DAF447AA8FF7_342790327;
            // ---------- Original Method ----------
            //if (str == null || str.charAt(0) != '('
                    //|| str.charAt(str.length() - 1) != ')') {
                //Log.e(TAG, "Invalid range list string=" + str);
                //return null;
            //}
            //ArrayList<int[]> rangeList = new ArrayList<int[]>();
            //int endIndex, fromIndex = 1;
            //do {
                //int[] range = new int[2];
                //endIndex = str.indexOf("),(", fromIndex);
                //if (endIndex == -1) endIndex = str.length() - 1;
                //splitInt(str.substring(fromIndex, endIndex), range);
                //rangeList.add(range);
                //fromIndex = endIndex + 3;
            //} while (endIndex != str.length() - 1);
            //if (rangeList.size() == 0) return null;
            //return rangeList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.279 -0400", hash_original_method = "9274EBB4EF409FF45187E570A4176C77", hash_generated_method = "48D1B64F0F12EED69F650F56414C6701")
        private ArrayList<Area> splitArea(String str) {
            addTaint(str.getTaint());
    if(str == null || str.charAt(0) != '('
                    || str.charAt(str.length() - 1) != ')')            
            {
ArrayList<Area> var540C13E9E156B687226421B24F2DF178_1274261486 =                 null;
                var540C13E9E156B687226421B24F2DF178_1274261486.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1274261486;
            } //End block
            ArrayList<Area> result = new ArrayList<Area>();
            int endIndex;
            int fromIndex = 1;
            int[] array = new int[5];
            do {
                {
                    endIndex = str.indexOf("),(", fromIndex);
    if(endIndex == -1)                    
                    endIndex = str.length() - 1;
                    splitInt(str.substring(fromIndex, endIndex), array);
                    Rect rect = new Rect(array[0], array[1], array[2], array[3]);
                    result.add(new Area(rect, array[4]));
                    fromIndex = endIndex + 3;
                } //End block
} while (endIndex != str.length() - 1);
    if(result.size() == 0)            
            {
ArrayList<Area> var540C13E9E156B687226421B24F2DF178_1082813706 =             null;
            var540C13E9E156B687226421B24F2DF178_1082813706.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1082813706;
            }
    if(result.size() == 1)            
            {
                Area area = result.get(0);
                Rect rect = area.rect;
    if(rect.left == 0 && rect.top == 0 && rect.right == 0
                        && rect.bottom == 0 && area.weight == 0)                
                {
ArrayList<Area> var540C13E9E156B687226421B24F2DF178_530720404 =                     null;
                    var540C13E9E156B687226421B24F2DF178_530720404.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_530720404;
                } //End block
            } //End block
ArrayList<Area> varDC838461EE2FA0CA4C9BBB70A15456B0_1117339067 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1117339067.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1117339067;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_method = "B277D938849565024C8C9B7FCA3C644C", hash_generated_method = "29AEA3AB02B206C0D14F532DB2E35721")
        private boolean same(String s1, String s2) {
            addTaint(s2.getTaint());
            addTaint(s1.getTaint());
    if(s1 == null && s2 == null)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_326459229 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051935206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051935206;
            }
    if(s1 != null && s1.equals(s2))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1705759649 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080205397 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080205397;
            }
            boolean var68934A3E9455FA72420237EB05902327_294649296 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966247305 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966247305;
            // ---------- Original Method ----------
            //if (s1 == null && s2 == null) return true;
            //if (s1 != null && s1.equals(s2)) return true;
            //return false;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "2EE1099A0BC5B7445B4E8C4146EDC8C1", hash_generated_field = "D491AB03C9D5CDF50C31726C71EFC373")

        private static final String KEY_PREVIEW_SIZE = "preview-size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "BF1FC78F8BF94A80704510FF1FF393E4", hash_generated_field = "DC175C134F5AABAAA6C719670C4E4180")

        private static final String KEY_PREVIEW_FORMAT = "preview-format";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "EA27D75ED26979367BF1FAD682573202", hash_generated_field = "B219EAECDC5170DE98D35419286AECE8")

        private static final String KEY_PREVIEW_FRAME_RATE = "preview-frame-rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "80B1C09C598B338D931B3FA79F7EAFB7", hash_generated_field = "74F3B640C7EAFF26E406B69723EA551B")

        private static final String KEY_PREVIEW_FPS_RANGE = "preview-fps-range";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "35F5E74453CF52785F98BA7DFA957299", hash_generated_field = "3D582F98C61ED0E162006F497463C753")

        private static final String KEY_PICTURE_SIZE = "picture-size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "2A6480463DFD3BF7CACD018215FCD36E", hash_generated_field = "10400A8146BFB9F72C58033CA87DE7BF")

        private static final String KEY_PICTURE_FORMAT = "picture-format";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "67A44D48AC1F4B09603519DF44ED62A6", hash_generated_field = "50E7E755B0F420ABB26EACB8C6133164")

        private static final String KEY_JPEG_THUMBNAIL_SIZE = "jpeg-thumbnail-size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "ED99BD5891A49A6045BA23CF40C14A0D", hash_generated_field = "667A7861D91B4D8007E90557D5A16FD2")

        private static final String KEY_JPEG_THUMBNAIL_WIDTH = "jpeg-thumbnail-width";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "6D819223089F6B32A8BBFA0E419B634B", hash_generated_field = "AC50E2B1C45E146A019611E3988C45C7")

        private static final String KEY_JPEG_THUMBNAIL_HEIGHT = "jpeg-thumbnail-height";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "B833BD02CAEC461165120CF1355AF556", hash_generated_field = "A56671B8066E1B9614E1B6F330D6AF70")

        private static final String KEY_JPEG_THUMBNAIL_QUALITY = "jpeg-thumbnail-quality";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "DC5B90D42147FBDF778A6418985E8B54", hash_generated_field = "82B8FC468F5234449996990D32952165")

        private static final String KEY_JPEG_QUALITY = "jpeg-quality";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "C0CAEB6EF3A7D01861B2D466A177C438", hash_generated_field = "E636E626CA26E33C3006C4B70CC58CA8")

        private static final String KEY_ROTATION = "rotation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "6DC5D96983468B0FB2CBF27837F55353", hash_generated_field = "5C909353766B94F9EC6F17E43CE5A8AC")

        private static final String KEY_GPS_LATITUDE = "gps-latitude";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.280 -0400", hash_original_field = "ED6DB05AFBE06188F518D82F026E575F", hash_generated_field = "F5A5C9C2DEFD10E1E3A78A8A5DFE652C")

        private static final String KEY_GPS_LONGITUDE = "gps-longitude";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "199532A8042D8C7F1D234C795374D07D", hash_generated_field = "7CAE4FA36B21C9B4E804DC781700FD0D")

        private static final String KEY_GPS_ALTITUDE = "gps-altitude";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "9AC193F3ED55957149BFB1F3E4893182", hash_generated_field = "2566DFC02723461942EF5C7FF3B29FC6")

        private static final String KEY_GPS_TIMESTAMP = "gps-timestamp";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "F295484EF6D4E1B01FF50495F8ED38E7", hash_generated_field = "AD2C634E0515AEEE5013AFD9364A99A8")

        private static final String KEY_GPS_PROCESSING_METHOD = "gps-processing-method";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "1ECC90287E34C06C4D70A458070B2E0B", hash_generated_field = "067DD1F44F9FD815C40A853E46520698")

        private static final String KEY_WHITE_BALANCE = "whitebalance";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "6237079FFA4FF67448D36B4822B2F220", hash_generated_field = "07D3090933D2247400CB4DD90BBE2CF3")

        private static final String KEY_EFFECT = "effect";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "D0B6C9072AD6088AF84E85F6AB5EC552", hash_generated_field = "AC7E92C69721E943C03503B6749192D5")

        private static final String KEY_ANTIBANDING = "antibanding";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "83DF0C05F8B836C9A3B7777B2BC27EEF", hash_generated_field = "0D608AA8C1BC8141D1A4CCCDD3D58720")

        private static final String KEY_SCENE_MODE = "scene-mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "F079E9CD06AF0288ED91FC9CA5440E3A", hash_generated_field = "EF1962EE75721A9D115A77E3707CCA17")

        private static final String KEY_FLASH_MODE = "flash-mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "A0400D644E552A42CC10E23C6769037F", hash_generated_field = "F02D1C9A44CD0C790EED9C45761E49CC")

        private static final String KEY_FOCUS_MODE = "focus-mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "6A2CEE729B669D1FBEB15C8E271B42C7", hash_generated_field = "7A02A051640E2CF5592FFE9117F2E6BB")

        private static final String KEY_FOCUS_AREAS = "focus-areas";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "7CC5BCCF430F6BE22F0E8BA808A43DFC", hash_generated_field = "10132BDF5E8D4637023407A7EA849BF6")

        private static final String KEY_MAX_NUM_FOCUS_AREAS = "max-num-focus-areas";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "8E556F64A34257F2F4312C7DDB1D2F06", hash_generated_field = "16AA73495A23F198A7A9AA7EF0879EA3")

        private static final String KEY_FOCAL_LENGTH = "focal-length";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "A5B3B19D76B38F01AA2F0643E8220228", hash_generated_field = "4417527EDBD6DF25AE76DCDFE5C0FB9C")

        private static final String KEY_HORIZONTAL_VIEW_ANGLE = "horizontal-view-angle";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "40971CE230DC90C4B34C00CF92BE3375", hash_generated_field = "84F041A9903525A7EF539C104EA8C35A")

        private static final String KEY_VERTICAL_VIEW_ANGLE = "vertical-view-angle";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "0804518EB7210D0A3ECC36D1301D40E9", hash_generated_field = "B3ED21B28AB90021D9B633B07B95EFC1")

        private static final String KEY_EXPOSURE_COMPENSATION = "exposure-compensation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "84BB24DA2B5E2E7FB98A978F3FF48BBF", hash_generated_field = "24A0F50C593A59D044069D6D64EA7DCB")

        private static final String KEY_MAX_EXPOSURE_COMPENSATION = "max-exposure-compensation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "3CB70FCA57292A57C836EA84525B6EC8", hash_generated_field = "A9D1D588ABC24E65433FF4BAFAFA7377")

        private static final String KEY_MIN_EXPOSURE_COMPENSATION = "min-exposure-compensation";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.281 -0400", hash_original_field = "6F9D13C388D61CA6035EC23DA6631AF2", hash_generated_field = "F6BEEA8E3E18E018F158EF0671306DFB")

        private static final String KEY_EXPOSURE_COMPENSATION_STEP = "exposure-compensation-step";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "08DD5AD106CD5D0FA77782289B5F9181", hash_generated_field = "C0A58533450D3BD2F9F2C6A65853CD35")

        private static final String KEY_AUTO_EXPOSURE_LOCK = "auto-exposure-lock";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "5DB8211363C2C41CCF53AFE6099B0104", hash_generated_field = "9A93AF97FAA0A401A7A579992029D47F")

        private static final String KEY_AUTO_EXPOSURE_LOCK_SUPPORTED = "auto-exposure-lock-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "B3530D8185698E9BB34F1DC90B313C31", hash_generated_field = "5B9320952E6A4A095AD226C292EBB29C")

        private static final String KEY_AUTO_WHITEBALANCE_LOCK = "auto-whitebalance-lock";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "B48F5102EE264D60972917317C36FC5E", hash_generated_field = "4F1DF25CACD22E806B96C006293BCE6F")

        private static final String KEY_AUTO_WHITEBALANCE_LOCK_SUPPORTED = "auto-whitebalance-lock-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "27A1B4D898CDE8B74606172BAB8FFF8C", hash_generated_field = "95F19A3DA489A3853346B571754602C2")

        private static final String KEY_METERING_AREAS = "metering-areas";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "E35C79492EFEFF33AC167BFD13FF9111", hash_generated_field = "BC95B3D1B028EF5583174317913E4F0E")

        private static final String KEY_MAX_NUM_METERING_AREAS = "max-num-metering-areas";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "3C2548B6FB96090E2F83D0D6A1A0EF6E", hash_generated_field = "1002BF2523EBE4E3169C9A5DA3A80856")

        private static final String KEY_ZOOM = "zoom";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "0EC1652172389B994A2BA9992A83222E", hash_generated_field = "72FAE2D3486243494F915785B367AB79")

        private static final String KEY_MAX_ZOOM = "max-zoom";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "3647768C96211FDAB2A5C87BE884F306", hash_generated_field = "3DF6FFAEC9EA9E8373739C8D293BE9F3")

        private static final String KEY_ZOOM_RATIOS = "zoom-ratios";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "20FAA08CB27EC605C52099C21988188F", hash_generated_field = "949FC2BF295832C9A84DCD3D74B75C15")

        private static final String KEY_ZOOM_SUPPORTED = "zoom-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "FDDEAEBA30599119A8DE9912151E09B3", hash_generated_field = "9FE4DB72B2949B29724C8D47EB13B4F6")

        private static final String KEY_SMOOTH_ZOOM_SUPPORTED = "smooth-zoom-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "B4A1509792B23A7E916A269FF0EA4B69", hash_generated_field = "42E9716388BA25211007B38C61DC0132")

        private static final String KEY_FOCUS_DISTANCES = "focus-distances";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "4DF4D8404896BD7E29E414149E7E439B", hash_generated_field = "D91113563BD671E8FAF937BC58E562D2")

        private static final String KEY_VIDEO_SIZE = "video-size";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "EA6139C9F2BBAA7E64CA8EA4A8AA9E89", hash_generated_field = "80600862D70199F1FCCB07655A60F155")

        private static final String KEY_PREFERRED_PREVIEW_SIZE_FOR_VIDEO = "preferred-preview-size-for-video";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "D47D749F690F09658FF56765665CCC19", hash_generated_field = "F12FDFBDBFD8E81D938A84466DD627DF")

        private static final String KEY_MAX_NUM_DETECTED_FACES_HW = "max-num-detected-faces-hw";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "8D985B322AEF81A28E06CA1737E10B46", hash_generated_field = "539D0AC241B90F91518FAB8586DE1673")

        private static final String KEY_MAX_NUM_DETECTED_FACES_SW = "max-num-detected-faces-sw";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.282 -0400", hash_original_field = "6378F009D433744431684FA2EB988C8C", hash_generated_field = "3C6B013BC256CBB0D9D78AD1E732C834")

        private static final String KEY_RECORDING_HINT = "recording-hint";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "C1FEFE7C192370370D58EEA6F06D1600", hash_generated_field = "D8D3997018C04FDA8DECAE870EAA9F3F")

        private static final String KEY_VIDEO_SNAPSHOT_SUPPORTED = "video-snapshot-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "34BB1718AE6913853F0851837F5277AA", hash_generated_field = "4D968037B9A0DC8DFC94EA97BE2D2EC2")

        private static final String KEY_VIDEO_STABILIZATION = "video-stabilization";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "29935C3452F6D861C5F6AEC23EC6F134", hash_generated_field = "F97FCEBC75E2BE1DF13A56C997BB28B6")

        private static final String KEY_VIDEO_STABILIZATION_SUPPORTED = "video-stabilization-supported";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "53DC3BBF592C6551782B717DA429F821", hash_generated_field = "EEF1BB2F71494B1EEDDDCC03A15370CA")

        private static final String SUPPORTED_VALUES_SUFFIX = "-values";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "4A5D6DD8F1946E8DBB347732ABB36769", hash_generated_field = "4C28D6B128C36B4FC74A84DF6340DC46")

        private static final String TRUE = "true";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "84CFF2B73BD78066F8C4DC69027BD0CC", hash_generated_field = "C1316565886B4D13708E85372F0C7E25")

        private static final String FALSE = "false";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "F28057AECE2BD970B9D80D33D7C863E8", hash_generated_field = "50B715D5181F8AD71E164A05DA246A18")

        public static final String WHITE_BALANCE_AUTO = "auto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "24D4F0F916AB9B4970E832E88491484C", hash_generated_field = "4C146C5C7A496C7575B4626817D4C6B5")

        public static final String WHITE_BALANCE_INCANDESCENT = "incandescent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "DE8BFE98964022A4D654C3F26C8C39A8", hash_generated_field = "775F94EB7534AB79944D9751B2B9B170")

        public static final String WHITE_BALANCE_FLUORESCENT = "fluorescent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "9AFCA759C484FD2EABE2035514D7A56D", hash_generated_field = "B227D5F67DCA562CD1298A6C50102C03")

        public static final String WHITE_BALANCE_WARM_FLUORESCENT = "warm-fluorescent";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "58333FEAF9F2218248A751D7EA3C2F7E", hash_generated_field = "77803AB352A9E6323F78C1F28A2EF38D")

        public static final String WHITE_BALANCE_DAYLIGHT = "daylight";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "F99184EDA3FD1ED091711E349865A086", hash_generated_field = "B0F65C41CCFA93ED2F8508B5A7611B95")

        public static final String WHITE_BALANCE_CLOUDY_DAYLIGHT = "cloudy-daylight";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "6F210565F062CA193401556155C79282", hash_generated_field = "70BA2854EB9812B93557D0952D78CED8")

        public static final String WHITE_BALANCE_TWILIGHT = "twilight";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "5D55B109C0B66F23E155E35BD7B450A5", hash_generated_field = "712EE0266774EA0149DD397B346D8F99")

        public static final String WHITE_BALANCE_SHADE = "shade";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "1A2FE8366676195602980E8542F800B2", hash_generated_field = "1534A949E3A751B6FFED0DEADC1805F0")

        public static final String EFFECT_NONE = "none";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "694BE8F722C3BEC236F8195AF3192791", hash_generated_field = "C1A04AE9C80EBB8083EB4AF0B0BBE630")

        public static final String EFFECT_MONO = "mono";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "0E549C67C58419E5D6CA255E6A137453", hash_generated_field = "24A530BA794CB5B7AF627B93F7B7B167")

        public static final String EFFECT_NEGATIVE = "negative";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.283 -0400", hash_original_field = "551CBE127B02488E982A5316E7D8C99D", hash_generated_field = "11DD47673984636C7D173471C2E61124")

        public static final String EFFECT_SOLARIZE = "solarize";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "B176CDF3ED0BF076130AE54B00E5B918", hash_generated_field = "B2874F0A689E4A31970BD92237B2FCCD")

        public static final String EFFECT_SEPIA = "sepia";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "EEFC11ECA372920B497B3A7B55856D2D", hash_generated_field = "23312E048FAF4F448698C46B06BFCC85")

        public static final String EFFECT_POSTERIZE = "posterize";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "6BC44F3217AB0A7375F959973A58B84A", hash_generated_field = "AD66305933BAA31E46015B0CD98A6050")

        public static final String EFFECT_WHITEBOARD = "whiteboard";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "FB4278BB3FFFAAC7D7229DC18FBC1B33", hash_generated_field = "DD56FE7E4A011E39698ED1592661B2BC")

        public static final String EFFECT_BLACKBOARD = "blackboard";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "ACD655520BA919B04473658199D468DB", hash_generated_field = "32142C632F158B8A8AD260EB1955D4C1")

        public static final String EFFECT_AQUA = "aqua";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "9306F6AB9A3FBA7E9E127640F84D8AD0", hash_generated_field = "991E49D017F1E0184846A36DBB6FD3E7")

        public static final String ANTIBANDING_AUTO = "auto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "92FD64541B5C271851D0564F13D0F424", hash_generated_field = "6911788C1BC58FDB61685C53964D1812")

        public static final String ANTIBANDING_50HZ = "50hz";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "316B699886BF7C769BE647910C09C6CE", hash_generated_field = "07BA19A2E1A4BA2C21E985EC438BC383")

        public static final String ANTIBANDING_60HZ = "60hz";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "29BB064B435EC7F7FDE53E4EE3A3B875", hash_generated_field = "BE98B3A51772EA40ADCC5ADAD78BAAF3")

        public static final String ANTIBANDING_OFF = "off";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "3C35D036C343671F1F951F95DA899252", hash_generated_field = "690FF110E93344F6704A04FDEC800A2F")

        public static final String FLASH_MODE_OFF = "off";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "80815988829CE59D1777C78A8C449840", hash_generated_field = "A3927DA7E1A34824581D9C20F125D6DF")

        public static final String FLASH_MODE_AUTO = "auto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "AF257D98E5472B951B52FA85FB7E50F2", hash_generated_field = "DBC42260A1C88C4F752747A7D8214BE6")

        public static final String FLASH_MODE_ON = "on";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "39832DEAE923E6FA46D606309390A330", hash_generated_field = "4AA92A8434A0292EFE01E2DB4B64C8A2")

        public static final String FLASH_MODE_RED_EYE = "red-eye";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "CC8B1462BC10D7FEA73FF8B6C35BFFC5", hash_generated_field = "0DAB3003B917316F329F457B0212F936")

        public static final String FLASH_MODE_TORCH = "torch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "83E073F76D8E86BEABB620B119A51F11", hash_generated_field = "F1634906DAF1C34C3A2A4CA6B8F718F4")

        public static final String SCENE_MODE_AUTO = "auto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "176788DE5B1D9FE606200C8589A6482B", hash_generated_field = "9D3DA8A21BE69B06856C608B2AD32DFD")

        public static final String SCENE_MODE_ACTION = "action";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "36E1E45F807E8A55FDA8F280BFC75838", hash_generated_field = "A37EFADE329921AF2451E99C3F4C7663")

        public static final String SCENE_MODE_PORTRAIT = "portrait";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "52A2C6C269AB2E5EC09440E2FAF08273", hash_generated_field = "1C1DD492750269C6EC53EB96F95E7C07")

        public static final String SCENE_MODE_LANDSCAPE = "landscape";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "072DF533FF104473B3B15E116FD5FF89", hash_generated_field = "CCF17FDE8811D586EAF34BD720C846B9")

        public static final String SCENE_MODE_NIGHT = "night";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "6EA98B5E033A59C6538FBABC3889AE12", hash_generated_field = "2C0B389CF7B25C4CF277D8EF6F2FBFFB")

        public static final String SCENE_MODE_NIGHT_PORTRAIT = "night-portrait";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "94C9F18CF6E73E303593C24FDB4C8512", hash_generated_field = "ACD4ADB245B9338695698D748E07629A")

        public static final String SCENE_MODE_THEATRE = "theatre";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "FCFE792D5F3CAE08AA30BC3DD7332B58", hash_generated_field = "E50050DDB6861F9C9AE50A61BDA45091")

        public static final String SCENE_MODE_BEACH = "beach";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "6327EC813432935D64FD9CC0C5BE538A", hash_generated_field = "58FAEBA2840CEFA9C7F02339BA333C2E")

        public static final String SCENE_MODE_SNOW = "snow";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "013C7116FDB07A3839C3AFCFBB338136", hash_generated_field = "837137813C12F691A0F6C3E6666DA3D8")

        public static final String SCENE_MODE_SUNSET = "sunset";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "361F4562D6D16B7F03A2A1CD1B813196", hash_generated_field = "7B5398D0F15B358277A7910CB360F8C2")

        public static final String SCENE_MODE_STEADYPHOTO = "steadyphoto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "6FEF9946D5662B7E1313C73F6484B777", hash_generated_field = "60FD3F32E2416CFF43F721FCC7065063")

        public static final String SCENE_MODE_FIREWORKS = "fireworks";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.284 -0400", hash_original_field = "B99F1A5FF22A38093B2A0B58185B15C4", hash_generated_field = "52B55A7C344960073C7C8A0DA258FFA5")

        public static final String SCENE_MODE_SPORTS = "sports";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "5DB95B3DF967091BFCB529C81C69A1A0", hash_generated_field = "4A7279C0AAB5979938DA40ED562D1F96")

        public static final String SCENE_MODE_PARTY = "party";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "2DCA2E5B3E4354BD5B77CFAEAF6CD027", hash_generated_field = "FF32A3BB976D19D61E4D6BB208602288")

        public static final String SCENE_MODE_CANDLELIGHT = "candlelight";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "A52B0538289550D3CD5A8CC133002FB9", hash_generated_field = "2F612EEE316679E1ABA746C7062DF5D7")

        public static final String SCENE_MODE_BARCODE = "barcode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "F332165F468DA125A390275ABEB429B0", hash_generated_field = "805CC8DAE505AEE8F5DD932734150515")

        public static final String FOCUS_MODE_AUTO = "auto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "3CCDAB1076C52EB6A49AC87D5DB60D0B", hash_generated_field = "96314B23098998AC9C385910C6FA79AE")

        public static final String FOCUS_MODE_INFINITY = "infinity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "69E10DDF84DC6FBE0898B0731F896252", hash_generated_field = "69E30265FB0EA71DC03F2587BCDADC5C")

        public static final String FOCUS_MODE_MACRO = "macro";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "F3A966CC205CEF146F1D74047AA4F2AD", hash_generated_field = "211A0897FF17C0BD57C024FD4DDB82FF")

        public static final String FOCUS_MODE_FIXED = "fixed";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "52F18002DCE72FFFCCDDB34810D52D12", hash_generated_field = "0A54BDEC9604E0744ED4B3DC0D45DC6E")

        public static final String FOCUS_MODE_EDOF = "edof";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "10E21C1BB5EF8AD4729AEFB83EBB6A19", hash_generated_field = "8EF526DF7D2C63F915412D52FDA6E999")

        public static final String FOCUS_MODE_CONTINUOUS_VIDEO = "continuous-video";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "FB465D290ADD1C3524F8A4E7A7B5A3FD", hash_generated_field = "C9EB0EBBB4F39D48C30B2443D3F1339E")

        public static final String FOCUS_MODE_CONTINUOUS_PICTURE = "continuous-picture";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "348125B72CFB090FF007839B7535B0B2", hash_generated_field = "C2A0FF12F554CDE1FB4DC3A89839F78A")

        public static final int FOCUS_DISTANCE_NEAR_INDEX = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "FB0ECC5AD1653CF5705CFEA1A962EBAA", hash_generated_field = "6467B36D6D4D60B6B320ABF8923415C4")

        public static final int FOCUS_DISTANCE_OPTIMAL_INDEX = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "DBA5F27AE7EE718BF37E4DD203C4BCA3", hash_generated_field = "C65652EC03CD2D15504CA27DDF003943")

        public static final int FOCUS_DISTANCE_FAR_INDEX = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "0BC26BA935B6F883339C053B49E490A0", hash_generated_field = "E6A046FA5AD79AE5F731217D0E0DDD59")

        public static final int PREVIEW_FPS_MIN_INDEX = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "8347A9D60B5B10D289AFB0C32807278C", hash_generated_field = "EEEB5F7BE20582E1074F30E2EF425229")

        public static final int PREVIEW_FPS_MAX_INDEX = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "08349848C33229988941D4838B7B8D91", hash_generated_field = "8D60D52E7DE6B58C2CD1CEB8461DCCB9")

        private static final String PIXEL_FORMAT_YUV422SP = "yuv422sp";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "55E0F2A39DD24767FEEDF08CD99DBA41", hash_generated_field = "CE201652177FAB6261B08E1238B606B1")

        private static final String PIXEL_FORMAT_YUV420SP = "yuv420sp";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "676AF2CCFE5BED6BD4415A246884E95F", hash_generated_field = "6741DF679FEF77AE5C23A481F6FD37CD")

        private static final String PIXEL_FORMAT_YUV422I = "yuv422i-yuyv";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.285 -0400", hash_original_field = "CB66FB475BBAEB2FB9397CDFBC9EBDE3", hash_generated_field = "08B945A037890C999CA445CA4C953DDB")

        private static final String PIXEL_FORMAT_YUV420P = "yuv420p";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "16B62C40CB897CD6E74849945929926B", hash_generated_field = "D508AD3FB4143F712106A7FD31E5D49C")

        private static final String PIXEL_FORMAT_RGB565 = "rgb565";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "BFB6355A400B4BBB7A20F5D9968F4FC6", hash_generated_field = "F0A6FC78605F8DC8C7CF568389F9C104")

        private static final String PIXEL_FORMAT_JPEG = "jpeg";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "36553AFE04AB8240063AE6F3521CD1AF", hash_generated_field = "7871494F4A04FAF3BC57702E8CF732FB")

        private static final String PIXEL_FORMAT_BAYER_RGGB = "bayer-rggb";
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "B951BCAC970104BF8B8FC59C0755A255", hash_generated_field = "02E9F8D8947522EA0B1D0F936D5F51D9")

    private static final String TAG = "Camera";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "564082AC0FC62EF078799BCC5F71E61E", hash_generated_field = "864C40349C3F6ED7968BE5037B8A58BE")

    private static final int CAMERA_MSG_ERROR = 0x001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "C28DBD641447A07EBA91EACD05921494", hash_generated_field = "A0D3044C862F492CABD037557C4356E5")

    private static final int CAMERA_MSG_SHUTTER = 0x002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "2B1CF8C7E32248A898F60A660DC11BA9", hash_generated_field = "1CC87C7E513C55AFEA40D6B58223F049")

    private static final int CAMERA_MSG_FOCUS = 0x004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "1033ED1525EE2CD832F58870DEAA7154", hash_generated_field = "3AC9227541ECA8B6C4F7A524FF51963D")

    private static final int CAMERA_MSG_ZOOM = 0x008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "5B7A614B0AE615B7591329F91A15E0DE", hash_generated_field = "DF747366CAC9DC8C3F1B75EA97E0F364")

    private static final int CAMERA_MSG_PREVIEW_FRAME = 0x010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "F11F9D6CB5ADDD7CA98F97EF8733B299", hash_generated_field = "E39F19091102976AE938C92513376E25")

    private static final int CAMERA_MSG_VIDEO_FRAME = 0x020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "85FF5033A261CA212B0B21E11DAB41AB", hash_generated_field = "567B1B810B0DCB5D3713BEB9AD8D7EA2")

    private static final int CAMERA_MSG_POSTVIEW_FRAME = 0x040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.286 -0400", hash_original_field = "E61E66DCF5B4151E8A435FDDEF21C79C", hash_generated_field = "5CD9DDD605A4024A3E951CDC20E43AEF")

    private static final int CAMERA_MSG_RAW_IMAGE = 0x080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "0090DF200408B342E2A167600DBA9817", hash_generated_field = "0463751886A103B9611A3B38C0279191")

    private static final int CAMERA_MSG_COMPRESSED_IMAGE = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "8A7CED71B2BF34BE290F059EFB325BAE", hash_generated_field = "A0783EFE4CC45CAC229036A3E7DFD838")

    private static final int CAMERA_MSG_RAW_IMAGE_NOTIFY = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "19E31E7CF4C9086FA8D1F8AF599CCFBC", hash_generated_field = "307FB97583A9348BD1160DF5FBAED9A9")

    private static final int CAMERA_MSG_PREVIEW_METADATA = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "AA602FDD9D25B890A568E70D6982D823", hash_generated_field = "8C72DF6F017F0CE4BE46C676039FB751")

    private static final int CAMERA_MSG_ALL_MSGS = 0x4FF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "E451DD7E4C96B8716CBDE77147E48097", hash_generated_field = "D4E4CA13249A4EAD7580C42B69878FB8")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_PICTURE = "android.hardware.action.NEW_PICTURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "B93BE1490FC87FE52D1F929AA2D12865", hash_generated_field = "DEE638FC175DD320F91C4207F3E75F9D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_NEW_VIDEO = "android.hardware.action.NEW_VIDEO";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "3A85DD52CB99A39BF9EFD722D302F147", hash_generated_field = "78E81A63FAC2D79C891F3E2F7E1BF572")

    private static final int CAMERA_FACE_DETECTION_HW = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "52927BD6EB69FA33937E9939D8B920B0", hash_generated_field = "71E736DACBC5B540CA91B239F0B06ED0")

    private static final int CAMERA_FACE_DETECTION_SW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "EFB30D0EA8F7B4DBB43C16D9AFA54C17", hash_generated_field = "B124F183A9261E178079DDAEED64C982")

    public static final int CAMERA_ERROR_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:21.287 -0400", hash_original_field = "8A018B9B85F901D8B57E95975371B915", hash_generated_field = "37D8A15D38047CBC9CADB52FD4CD0C23")

    public static final int CAMERA_ERROR_SERVER_DIED = 100;
}

