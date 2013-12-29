package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;





public class SurfaceTexture {

    /**
     * This method is invoked from native code only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.126 -0500", hash_original_method = "7431FEB98B9B53A93696C76CA47D5EA1", hash_generated_method = "69433486C6A90FD2E8F6D5B7F9676837")
    @SuppressWarnings({"UnusedDeclaration"})
private static void postEventFromNative(Object selfRef) {
        WeakReference weakSelf = (WeakReference)selfRef;
        SurfaceTexture st = (SurfaceTexture)weakSelf.get();
        if (st == null) {
            return;
        }

        if (st.mEventHandler != null) {
            Message m = st.mEventHandler.obtainMessage();
            st.mEventHandler.sendMessage(m);
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClassInit() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.109 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")


    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.110 -0500", hash_original_field = "8C003C2DD0140FDBFDC288A6D938BB1D", hash_generated_field = "294E295D0012756EF3396CAF3BBC347B")

    private OnFrameAvailableListener mOnFrameAvailableListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.111 -0500", hash_original_field = "C6CA11D143B3BE5541E68C1CA04184AA", hash_generated_field = "F8463E29CE0C76463ADFD57642F32BDF")

    private int mSurfaceTexture;

    /**
     * Construct a new SurfaceTexture to stream images to a given OpenGL texture.
     *
     * @param texName the OpenGL texture object name (e.g. generated via glGenTextures)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.116 -0500", hash_original_method = "C7158DCB4D3EE755177A25DCF0F3004D", hash_generated_method = "A24CBD1F9A1F7D16EF6B35AAB3A9D352")
    public SurfaceTexture(int texName) {
        this(texName, false);
    }

    /**
     * Construct a new SurfaceTexture to stream images to a given OpenGL texture.
     *
     * @param texName the OpenGL texture object name (e.g. generated via glGenTextures)
     * @param allowSynchronousMode whether the SurfaceTexture can run in the synchronous mode.
     *      When the image stream comes from OpenGL, SurfaceTexture may run in the synchronous
     *      mode where the producer side may be blocked to avoid skipping frames. To avoid the
     *      thread block, set allowSynchronousMode to false.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.117 -0500", hash_original_method = "67BB7F3D4FE9BE0028412949F77419AD", hash_generated_method = "9ABC9F2B4FD0E24AD5B94DB6747A5505")
    public SurfaceTexture(int texName, boolean allowSynchronousMode) {
        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mEventHandler = new EventHandler(looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mEventHandler = new EventHandler(looper);
        } else {
            mEventHandler = null;
        }
        nativeInit(texName, new WeakReference<SurfaceTexture>(this), allowSynchronousMode);
    }

    /**
     * Register a callback to be invoked when a new image frame becomes available to the
     * SurfaceTexture.  Note that this callback may be called on an arbitrary thread, so it is not
     * safe to call {@link #updateTexImage} without first binding the OpenGL ES context to the
     * thread invoking the callback.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.117 -0500", hash_original_method = "D25F82A74C11430669962AA7817D10FE", hash_generated_method = "9455E84E45EBCFB7D27BC2051D82EDE2")
    public void setOnFrameAvailableListener(OnFrameAvailableListener l) {
        mOnFrameAvailableListener = l;
    }

    /**
     * Set the default size of the image buffers.  The image producer may override the buffer size,
     * in which case the producer-set buffer size will be used, not the default size set by this
     * method.  Both video and camera based image producers do override the size.  This method may
     * be used to set the image size when producing images with {@link android.graphics.Canvas} (via
     * {@link android.view.Surface#lockCanvas}), or OpenGL ES (via an EGLSurface).
     *
     * The new default buffer size will take effect the next time the image producer requests a
     * buffer to fill.  For {@link android.graphics.Canvas} this will be the next time {@link
     * android.view.Surface#lockCanvas} is called.  For OpenGL ES, the EGLSurface should be
     * destroyed (via eglDestroySurface), made not-current (via eglMakeCurrent), and then recreated
     * (via eglCreateWindowSurface) to ensure that the new default size has taken effect.
     * 
     * The width and height parameters must be no greater than the minimum of
     * GL_MAX_VIEWPORT_DIMS and GL_MAX_TEXTURE_SIZE (see 
     * {@link javax.microedition.khronos.opengles.GL10#glGetIntegerv glGetIntegerv}).
     * An error due to invalid dimensions might not be reported until
     * updateTexImage() is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.118 -0500", hash_original_method = "73040EC5A717DD03B1E2713EBAC256DF", hash_generated_method = "2D2F3EB45AF1663225A76358B63576B4")
    public void setDefaultBufferSize(int width, int height) {
        nativeSetDefaultBufferSize(width, height);
    }

    /**
     * Update the texture image to the most recent frame from the image stream.  This may only be
     * called while the OpenGL ES context that owns the texture is bound to the thread.  It will
     * implicitly bind its texture to the GL_TEXTURE_EXTERNAL_OES texture target.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.119 -0500", hash_original_method = "2A6ADC9927C563F3FF4AF28D3226D576", hash_generated_method = "317C38ACA8E063E398F91B80AECBFD6B")
    public void updateTexImage() {
        int err = nativeUpdateTexImage(); 
        if (err != 0) {
            throw new RuntimeException("Error during updateTexImage (see logs)");
        }
    }

    /**
     * Retrieve the 4x4 texture coordinate transform matrix associated with the texture image set by
     * the most recent call to updateTexImage.
     *
     * This transform matrix maps 2D homogeneous texture coordinates of the form (s, t, 0, 1) with s
     * and t in the inclusive range [0, 1] to the texture coordinate that should be used to sample
     * that location from the texture.  Sampling the texture outside of the range of this transform
     * is undefined.
     *
     * The matrix is stored in column-major order so that it may be passed directly to OpenGL ES via
     * the glLoadMatrixf or glUniformMatrix4fv functions.
     *
     * @param mtx the array into which the 4x4 matrix will be stored.  The array must have exactly
     *     16 elements.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.120 -0500", hash_original_method = "BB625075136BE4BF04377676D5DA464A", hash_generated_method = "27D55C911CB0CE7CE93875B78D620B2C")
    public void getTransformMatrix(float[] mtx) {
        // Note we intentionally don't check mtx for null, so this will result in a
        // NullPointerException. But it's safe because it happens before the call to native.
        if (mtx.length != 16) {
            throw new IllegalArgumentException();
        }
        nativeGetTransformMatrix(mtx);
    }

    /**
     * Retrieve the timestamp associated with the texture image set by the most recent call to
     * updateTexImage.
     *
     * This timestamp is in nanoseconds, and is normally monotonically increasing. The timestamp
     * should be unaffected by time-of-day adjustments, and for a camera should be strictly
     * monotonic but for a MediaPlayer may be reset when the position is set.  The
     * specific meaning and zero point of the timestamp depends on the source providing images to
     * the SurfaceTexture. Unless otherwise specified by the image source, timestamps cannot
     * generally be compared across SurfaceTexture instances, or across multiple program
     * invocations. It is mostly useful for determining time offsets between subsequent frames.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.121 -0500", hash_original_method = "1E06887ADD0CA49D5969AE26836E85A4", hash_generated_method = "36978C2484E3480C52E7A3E8D343B4CB")
    public long getTimestamp() {
        return nativeGetTimestamp();
    }

    /**
     * release() frees all the buffers and puts the SurfaceTexture into the
     * 'abandoned' state. Once put in this state the SurfaceTexture can never
     * leave it. When in the 'abandoned' state, all methods of the
     * ISurfaceTexture interface will fail with the NO_INIT error.
     *
     * Note that while calling this method causes all the buffers to be freed
     * from the perspective of the the SurfaceTexture, if there are additional
     * references on the buffers (e.g. if a buffer is referenced by a client or
     * by OpenGL ES as a texture) then those buffer will remain allocated.
     *
     * Always call this method when you are done with SurfaceTexture. Failing
     * to do so may delay resource deallocation for a significant amount of
     * time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.121 -0500", hash_original_method = "D25304D195F58D125972FA32527A0B4B", hash_generated_method = "A94D89DDFD071587A7C0C810B4E00E1F")
    public void release() {
        nativeRelease();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.122 -0500", hash_original_method = "9BBDD5FE82DE1D04FB6B805CB455ABD6", hash_generated_method = "44F25DA0144A33F12DDE6F91A36A9A67")
    protected void finalize() throws Throwable {
        try {
            nativeFinalize();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.938 -0500", hash_original_method = "C6EC796BAFF87019C29023815C189B5A", hash_generated_method = "AA42D469F56573A8757A23225C322018")
    private native void nativeInit(int texName, Object weakSelf, boolean allowSynchronousMode);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.940 -0500", hash_original_method = "46D026C452E34CB5D17D4D7413C83210", hash_generated_method = "78C5016E7109D19F8AD63CF42C68ACE4")
    private native void nativeFinalize();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.941 -0500", hash_original_method = "39631901C5E9C156F840F3431C1EB6A3", hash_generated_method = "4B09D83A7536E3E547C5B7CD2CB8556D")
    private native void nativeGetTransformMatrix(float[] mtx);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.942 -0500", hash_original_method = "F440D167BF3058541215FA5D0CFEDE56", hash_generated_method = "5B9D958209E2F3E2846115634ADCDFA4")
    private native long nativeGetTimestamp();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.943 -0500", hash_original_method = "777FDD0379AC4E914563AFAE47F93745", hash_generated_method = "0BD631231AF930E1C6DADD2FF3B3AEEA")
    private native void nativeSetDefaultBufferSize(int width, int height);
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.945 -0500", hash_original_method = "5F79841CB1993D78C92BE65FFA4E3E7E", hash_generated_method = "24A081577BE4423DF5FF32A0497E283D")
    private native int nativeUpdateTexImage();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.946 -0500", hash_original_method = "7EC2703D346B1354B6934AD09D0B787F", hash_generated_method = "FA9248084B9433E253EDEEC3BE125919")
    private native int nativeGetQueuedCount();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:38.947 -0500", hash_original_method = "2D7DB035F92C7747E201CDD180CCEB34", hash_generated_method = "CB05CC8EFF649931CA852F9EE5CE05B2")
    private native void nativeRelease();

    
    public static class OutOfResourcesException extends Exception {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.113 -0500", hash_original_method = "61F4EF1E830289140B20E24C64AAB8C1", hash_generated_method = "61E15EE14C5CBDE674C8414A5D82F699")
        public OutOfResourcesException() {
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.114 -0500", hash_original_method = "939C993D5367F7A0F0B43DA6997565C5", hash_generated_method = "8B56E09EC06DA5D20A9DD318E0B09E28")
        public OutOfResourcesException(String name) {
            super(name);
        }

        
    }


    
    private class EventHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.123 -0500", hash_original_method = "4C7A877E4BE32D4145A967F6B988F2F0", hash_generated_method = "47CCB5A82C902FC2B6115310FA279718")
        public EventHandler(Looper looper) {
            super(looper);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:56.124 -0500", hash_original_method = "30D4E35B8AF7291102AD4322AA39CBBD", hash_generated_method = "256536D23D3E1206033725D38B3D6FBA")
        @Override
public void handleMessage(Message msg) {
            if (mOnFrameAvailableListener != null) {
                mOnFrameAvailableListener.onFrameAvailable(SurfaceTexture.this);
            }
        }

        
    }


    
    public interface OnFrameAvailableListener {
        void onFrameAvailable(SurfaceTexture surfaceTexture);
    }
    
    static { nativeClassInit(); }
    
}

