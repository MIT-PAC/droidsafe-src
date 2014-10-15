/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.media.audiofx;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.io.IOException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * The Visualizer class enables application to retrieve part of the currently playing audio for
 * visualization purpose. It is not an audio recording interface and only returns partial and low
 * quality audio content. However, to protect privacy of certain audio data (e.g voice mail) the use
 * of the visualizer requires the permission android.permission.RECORD_AUDIO.
 * <p>The audio session ID passed to the constructor indicates which audio content should be
 * visualized:<br>
 * <ul>
 *   <li>If the session is 0, the audio output mix is visualized</li>
 *   <li>If the session is not 0, the audio from a particular {@link android.media.MediaPlayer} or
 *   {@link android.media.AudioTrack}
 *   using this audio session is visualized </li>
 * </ul>
 * <p>Two types of representation of audio content can be captured: <br>
 * <ul>
 *   <li>Waveform data: consecutive 8-bit (unsigned) mono samples by using the
 *   {@link #getWaveForm(byte[])} method</li>
 *   <li>Frequency data: 8-bit magnitude FFT by using the {@link #getFft(byte[])} method</li>
 * </ul>
 * <p>The length of the capture can be retrieved or specified by calling respectively
 * {@link #getCaptureSize()} and {@link #setCaptureSize(int)} methods. The capture size must be a
 * power of 2 in the range returned by {@link #getCaptureSizeRange()}.
 * <p>In addition to the polling capture mode described above with {@link #getWaveForm(byte[])} and
 *  {@link #getFft(byte[])} methods, a callback mode is also available by installing a listener by
 *  use of the {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
 *  The rate at which the listener capture method is called as well as the type of data returned is
 *  specified.
 * <p>Before capturing data, the Visualizer must be enabled by calling the
 * {@link #setEnabled(boolean)} method.
 * When data capture is not needed any more, the Visualizer should be disabled.
 * <p>It is good practice to call the {@link #release()} method when the Visualizer is not used
 * anymore to free up native resources associated to the Visualizer instance.
 * <p>Creating a Visualizer on the output mix (audio session 0) requires permission
 * {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}
 */

public class Visualizer {

    static {
        System.loadLibrary("audioeffect_jni");
        native_init();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.276 -0400", hash_original_field = "65F6BFF80E5B935381A9955FED724BC3", hash_generated_field = "89A002C16FAAD5779C2B237C40B0F26D")

    private final static String TAG = "Visualizer-JAVA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.278 -0400", hash_original_field = "DADF89E4937FB007E11FCD2CF7BDDE2E", hash_generated_field = "ABD8681944D12EB0761E4A01DCCA64A7")

    public static final int STATE_UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.280 -0400", hash_original_field = "02EF6A6792F741D2888A16AA95F5BE68", hash_generated_field = "528069025EBD3248613210FDC5DD79AC")

    public static final int STATE_INITIALIZED   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.282 -0400", hash_original_field = "7D79D68B1C9EC5A6B30A40E03FC3F40F", hash_generated_field = "22306AB0A761AE720B8D499F6F38BC66")

    public static final int STATE_ENABLED   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.284 -0400", hash_original_field = "C80296724EAC7286A4971E9A6844CBDB", hash_generated_field = "71CC9E1A5C334B1CA5B3C48D8466D2AA")

    private static final int NATIVE_EVENT_PCM_CAPTURE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.286 -0400", hash_original_field = "681E0B0BF0E5199F10F44C3EB1449CF9", hash_generated_field = "6738002057021F7014204B7727BCF343")

    private static final int NATIVE_EVENT_FFT_CAPTURE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.287 -0400", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "CC5022FB4B20625C216D9F73D3FF3EA3")

    /**
     * Successful operation.
     */
    public  static final int SUCCESS              = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.289 -0400", hash_original_field = "060BE1B4136BE1AC2BFF57541DF9E977", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public  static final int ERROR                = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.290 -0400", hash_original_field = "9E4E19F09F93BF4E3C21FF5D5C0C91EF", hash_generated_field = "680981E7196324CF93EF7B0044554156")

    public  static final int ALREADY_EXISTS       = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.292 -0400", hash_original_field = "E10E685436960177FDF6620067D8B3FE", hash_generated_field = "58A0D8C61F32DC39E8B8823C0AEF971A")

    public  static final int ERROR_NO_INIT              = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.294 -0400", hash_original_field = "98B490381D4BFC4035E8CC6DF0013B79", hash_generated_field = "852CE03AC32991EC9528F95A24EC62C2")

    public  static final int ERROR_BAD_VALUE            = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.295 -0400", hash_original_field = "F0176A8DFFDFC603D40E0A83A464086F", hash_generated_field = "37EF1CCCB4A226E3C7C703FF094A5521")

    public  static final int ERROR_INVALID_OPERATION    = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.297 -0400", hash_original_field = "D18A11BCA69548EFADC6EA51CDDFA3DC", hash_generated_field = "1C35338ED607C808DB91CBCD3933AC24")

    public  static final int ERROR_NO_MEMORY            = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.299 -0400", hash_original_field = "8A6981B6921F3B84AD0A63146A46A9C0", hash_generated_field = "1D2CD88BB5300E6721806199841B283E")

    public  static final int ERROR_DEAD_OBJECT          = -7;

    /**
     * Returns the capture size range.
     * @return the mininum capture size is returned in first array element and the maximum in second
     * array element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:51.148 -0400", hash_original_method = "C7E7366E6F8E1A6767FA4E613894E60F", hash_generated_method = "F1C31C6EC295A42659686D636D04D3A3")
    
    public static int[] getCaptureSizeRange(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	int[] retObj = new int[1]; 
    	retObj[0] = (int)taintDouble;
    	return retObj;
    }

    /**
     * Returns the maximum capture rate for the callback capture method. This is the maximum value
     * for the rate parameter of the
     * {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
     * @return the maximum capture rate expressed in milliHertz
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:51.150 -0400", hash_original_method = "0AE7A288B4103A4150DE36593EFEAB85", hash_generated_method = "88FFEBC584ADE9BA089E0EE73A8719B5")
    
    public static int getMaxCaptureRate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    //---------------------------------------------------------
    // Interface definitions
    //--------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.342 -0400", hash_original_method = "9DACEB091913AFFD29EB0CE9882462AB", hash_generated_method = "0F83FA23DF600A99662CB2DCA62BFB26")
    
    private static final void native_init(){
    	//Formerly a native method
    }

    //---------------------------------------------------------
    // Java methods called from the native side
    //--------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.367 -0400", hash_original_method = "D091602B652E4D0C4F6C99EDAF977ED4", hash_generated_method = "C0FCE8B4AD7367933DA75DF59215ACCE")
    
@SuppressWarnings("unused")
    private static void postEventFromNative(Object effect_ref,
            int what, int arg1, int arg2, Object obj) {
        Visualizer visu = (Visualizer)((WeakReference)effect_ref).get();
        if (visu == null) {
            return;
        }

        if (visu.mNativeEventHandler != null) {
            Message m = visu.mNativeEventHandler.obtainMessage(what, arg1, arg2, obj);
            visu.mNativeEventHandler.sendMessage(m);
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.300 -0400", hash_original_field = "78622F071E041CCB5EEFF5A3BEF9AB78", hash_generated_field = "427D86508C9EBBE925096715EF90FD04")

    // Member variables
    //--------------------
    /**
     * Indicates the state of the Visualizer instance
     */
    private int mState = STATE_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.301 -0400", hash_original_field = "DB8F7F3C2498170622A06B3E94FD6EE0", hash_generated_field = "C7931A0BEAB38320A08BDF3E39CD65DA")

    private final Object mStateLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.303 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.304 -0400", hash_original_field = "BB69DF3FD62D97D9C1B852C5B017E79B", hash_generated_field = "BD6AE53879F57C559FFFAC4F579767BC")

    private final Object mListenerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.305 -0400", hash_original_field = "A66ACE8F39ECFCBCDABD1068522C9535", hash_generated_field = "0C28E3E1ECBA01C6806CE9A358D9A264")

    private NativeEventHandler mNativeEventHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.307 -0400", hash_original_field = "9AE6B29EC87275F2003D8ED73CAF3CFD", hash_generated_field = "8194AE3D7875A7080BF7D317B4878137")

    private OnDataCaptureListener mCaptureListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.308 -0400", hash_original_field = "88B2DBF68E56AFACCBBBA23FE55262AA", hash_generated_field = "AE8835FBA750D4E5991338F2DAA44EC2")

    private int mNativeVisualizer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.310 -0400", hash_original_field = "CD27E77ABE959434B144B34D81D41594", hash_generated_field = "2042284B36B7A02EA029B5A72AE30FF2")

    private int mJniData;

    //--------------------------------------------------------------------------
    // Constructor, Finalize
    //--------------------
    /**
     * Class constructor.
     * @param audioSession system wide unique audio session identifier. If audioSession
     *  is not 0, the visualizer will be attached to the MediaPlayer or AudioTrack in the
     *  same audio session. Otherwise, the Visualizer will apply to the output mix.
     *
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.312 -0400", hash_original_method = "021AE1C90916379199DE730AADA2B506", hash_generated_method = "AB47689752A8FD32B959C5D7E51D09F9")
    
public Visualizer(int audioSession)
    throws UnsupportedOperationException, RuntimeException {
        int[] id = new int[1];

        synchronized (mStateLock) {
            mState = STATE_UNINITIALIZED;
            // native initialization
            int result = native_setup(new WeakReference<Visualizer>(this), audioSession, id);
            if (result != SUCCESS && result != ALREADY_EXISTS) {
                Log.e(TAG, "Error code "+result+" when initializing Visualizer.");
                switch (result) {
                case ERROR_INVALID_OPERATION:
                    throw (new UnsupportedOperationException("Effect library not loaded"));
                default:
                    throw (new RuntimeException("Cannot initialize Visualizer engine, error: "
                            +result));
                }
            }
            mId = id[0];
            if (native_getEnabled()) {
                mState = STATE_ENABLED;
            } else {
                mState = STATE_INITIALIZED;
            }
        }
    }

    /**
     * Releases the native Visualizer resources. It is a good practice to release the
     * visualization engine when not in use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.313 -0400", hash_original_method = "419AE57F1F4F3771FE7C034911087106", hash_generated_method = "AC815385DD29FED51EAF380C6278E8B3")
    
public void release() {
        synchronized (mStateLock) {
            native_release();
            mState = STATE_UNINITIALIZED;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.315 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() {
        native_finalize();
    }

    /**
     * Enable or disable the visualization engine.
     * @param enabled requested enable state
     * @return {@link #SUCCESS} in case of success,
     * {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT} in case of failure.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.316 -0400", hash_original_method = "F11C6B90D4697EBEDA9B65300EF2CD46", hash_generated_method = "3E1D4DB7554038BCE666CCCA10115640")
    
public int setEnabled(boolean enabled)
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState == STATE_UNINITIALIZED) {
                throw(new IllegalStateException("setEnabled() called in wrong state: "+mState));
            }
            int status = SUCCESS;
            if ((enabled && (mState == STATE_INITIALIZED)) ||
                    (!enabled && (mState == STATE_ENABLED))) {
                status = native_setEnabled(enabled);
                if (status == SUCCESS) {
                    mState = enabled ? STATE_ENABLED : STATE_INITIALIZED;
                }
            }
            return status;
        }
    }

    /**
     * Get current activation state of the visualizer.
     * @return true if the visualizer is active, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.319 -0400", hash_original_method = "9AB7D12E8F3AB77EEDA4D8D776F0D37F", hash_generated_method = "32AA2C22F0356554962C266D82E0A782")
    
public boolean getEnabled()
    {
        synchronized (mStateLock) {
            if (mState == STATE_UNINITIALIZED) {
                throw(new IllegalStateException("getEnabled() called in wrong state: "+mState));
            }
            return native_getEnabled();
        }
    }

    /**
     * Sets the capture size, i.e. the number of bytes returned by {@link #getWaveForm(byte[])} and
     * {@link #getFft(byte[])} methods. The capture size must be a power of 2 in the range returned
     * by {@link #getCaptureSizeRange()}.
     * This method must not be called when the Visualizer is enabled.
     * @param size requested capture size
     * @return {@link #SUCCESS} in case of success,
     * {@link #ERROR_BAD_VALUE} in case of failure.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.324 -0400", hash_original_method = "5EBDED2A3B184A8E9B2B210383011D54", hash_generated_method = "AE411DE358D1C36178C1BEE55163D23C")
    
public int setCaptureSize(int size)
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState != STATE_INITIALIZED) {
                throw(new IllegalStateException("setCaptureSize() called in wrong state: "+mState));
            }
            return native_setCaptureSize(size);
        }
    }

    /**
     * Returns current capture size.
     * @return the capture size in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.326 -0400", hash_original_method = "5F7E47539D0EE8735F12311833691406", hash_generated_method = "D4591426ADE5842E1D4DE9C118B1875D")
    
public int getCaptureSize()
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState == STATE_UNINITIALIZED) {
                throw(new IllegalStateException("getCaptureSize() called in wrong state: "+mState));
            }
            return native_getCaptureSize();
        }
    }

    /**
     * Returns the sampling rate of the captured audio.
     * @return the sampling rate in milliHertz.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.327 -0400", hash_original_method = "46D4B607C7F5E9EFC868298E1DC09D3F", hash_generated_method = "1F51EBD5DBCB64F2A9858AD564879930")
    
public int getSamplingRate()
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState == STATE_UNINITIALIZED) {
                throw(new IllegalStateException("getSamplingRate() called in wrong state: "+mState));
            }
            return native_getSamplingRate();
        }
    }

    //---------------------------------------------------------
    // Interface definitions
    //--------------------
    /**
     * The OnDataCaptureListener interface defines methods called by the Visualizer to periodically
     * update the audio visualization capture.
     * The client application can implement this interface and register the listener with the
     * {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
     */
    public interface OnDataCaptureListener  {
        /**
         * Method called when a new waveform capture is available.
         * @param visualizer Visualizer object on which the listener is registered.
         * @param waveform array of bytes containing the waveform representation.
         * @param samplingRate sampling rate of the audio visualized.
         */
        void onWaveFormDataCapture(Visualizer visualizer, byte[] waveform, int samplingRate);

        /**
         * Method called when a new frequency capture is available.
         * @param visualizer Visualizer object on which the listener is registered.
         * @param fft array of bytes containing the frequency representation.
         * @param samplingRate sampling rate of the audio visualized.
         */
        void onFftDataCapture(Visualizer visualizer, byte[] fft, int samplingRate);
    }

    /**
     * Returns a waveform capture of currently playing audio content. The capture consists in
     * a number of consecutive 8-bit (unsigned) mono PCM samples equal to the capture size returned
     * by {@link #getCaptureSize()}.
     * <p>This method must be called when the Visualizer is enabled.
     * @param waveform array of bytes where the waveform should be returned
     * @return {@link #SUCCESS} in case of success,
     * {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT}
     * in case of failure.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.329 -0400", hash_original_method = "85454A3678047320A9E51F9783095183", hash_generated_method = "02F07C135E46CF5679FCE1487B33BCA3")
    
public int getWaveForm(byte[] waveform)
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState != STATE_ENABLED) {
                throw(new IllegalStateException("getWaveForm() called in wrong state: "+mState));
            }
            return native_getWaveForm(waveform);
        }
    }

    /**
     * Helper class to handle the forwarding of native events to the appropriate listeners
     */
    private class NativeEventHandler extends Handler
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.335 -0400", hash_original_field = "3EF2F32AEBF64C718809DF40DE1E0FBC", hash_generated_field = "B72AF902CA032E52BD2220977894793A")

        private Visualizer mVisualizer;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.337 -0400", hash_original_method = "2999FA71D70C19728CDBFF49A8A1C383", hash_generated_method = "76B8A8C3D687FD128977BB4BDD90D5D2")
        
public NativeEventHandler(Visualizer v, Looper looper) {
            super(looper);
            mVisualizer = v;
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.339 -0400", hash_original_method = "96F169B520F6500397539A8755B7E979", hash_generated_method = "7318D51A74A50506B3FF6A417F2EDFD1")
        
@Override
        public void handleMessage(Message msg) {
            if (mVisualizer == null) {
                return;
            }
            OnDataCaptureListener l = null;
            synchronized (mListenerLock) {
                l = mVisualizer.mCaptureListener;
            }

            if (l != null) {
                byte[] data = (byte[])msg.obj;
                int samplingRate = msg.arg1;
                switch(msg.what) {
                case NATIVE_EVENT_PCM_CAPTURE:
                    l.onWaveFormDataCapture(mVisualizer, data, samplingRate);
                    break;
                case NATIVE_EVENT_FFT_CAPTURE:
                    l.onFftDataCapture(mVisualizer, data, samplingRate);
                    break;
                default:
                    Log.e(TAG,"Unknown native event: "+msg.what);
                    break;
                }
            }
        }
    }
    /**
     * Returns a frequency capture of currently playing audio content.
     * <p>This method must be called when the Visualizer is enabled.
     * <p>The capture is an 8-bit magnitude FFT, the frequency range covered being 0 (DC) to half of
     * the sampling rate returned by {@link #getSamplingRate()}. The capture returns the real and
     * imaginary parts of a number of frequency points equal to half of the capture size plus one.
     * <p>Note: only the real part is returned for the first point (DC) and the last point
     * (sampling frequency / 2).
     * <p>The layout in the returned byte array is as follows:
     * <ul>
     *   <li> n is the capture size returned by getCaptureSize()</li>
     *   <li> Rfk, Ifk are respectively  the real and imaginary parts of the kth frequency
     *   component</li>
     *   <li> If Fs is the sampling frequency retuned by getSamplingRate() the kth frequency is:
     *   (k*Fs)/(n/2) </li>
     * </ul>
     * <table border="0" cellspacing="0" cellpadding="0">
     * <tr><td>Index </p></td>
     *     <td>0 </p></td>
     *     <td>1 </p></td>
     *     <td>2 </p></td>
     *     <td>3 </p></td>
     *     <td>4 </p></td>
     *     <td>5 </p></td>
     *     <td>... </p></td>
     *     <td>n - 2 </p></td>
     *     <td>n - 1 </p></td></tr>
     * <tr><td>Data </p></td>
     *     <td>Rf0 </p></td>
     *     <td>Rf(n/2) </p></td>
     *     <td>Rf1 </p></td>
     *     <td>If1 </p></td>
     *     <td>Rf2 </p></td>
     *     <td>If2 </p></td>
     *     <td>... </p></td>
     *     <td>Rf(n-1)/2 </p></td>
     *     <td>If(n-1)/2 </p></td></tr>
     * </table>
     * @param fft array of bytes where the FFT should be returned
     * @return {@link #SUCCESS} in case of success,
     * {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT}
     * in case of failure.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.330 -0400", hash_original_method = "300954E92B58A58C6DB5C860DEC45362", hash_generated_method = "9B32CAEB91D493C0A1AE6B5E7BE7B6DC")
    
public int getFft(byte[] fft)
    throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState != STATE_ENABLED) {
                throw(new IllegalStateException("getFft() called in wrong state: "+mState));
            }
            return native_getFft(fft);
        }
    }

    /**
     * Registers an OnDataCaptureListener interface and specifies the rate at which the capture
     * should be updated as well as the type of capture requested.
     * <p>Call this method with a null listener to stop receiving the capture updates.
     * @param listener OnDataCaptureListener registered
     * @param rate rate in milliHertz at which the capture should be updated
     * @param waveform true if a waveform capture is requested: the onWaveFormDataCapture()
     * method will be called on the OnDataCaptureListener interface.
     * @param fft true if a frequency capture is requested: the onFftDataCapture() method will be
     * called on the OnDataCaptureListener interface.
     * @return {@link #SUCCESS} in case of success,
     * {@link #ERROR_NO_INIT} or {@link #ERROR_BAD_VALUE} in case of failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.333 -0400", hash_original_method = "9C1AC58B5B7BA3E1E8FE5BC464A3ABC7", hash_generated_method = "C2E82154F05F025540230616590EACAC")
    
public int setDataCaptureListener(OnDataCaptureListener listener,
            int rate, boolean waveform, boolean fft) {
        synchronized (mListenerLock) {
            mCaptureListener = listener;
        }
        if (listener == null) {
            // make sure capture callback is stopped in native code
            waveform = false;
            fft = false;
        }
        int status = native_setPeriodicCapture(rate, waveform, fft);
        if (status == SUCCESS) {
            if ((listener != null) && (mNativeEventHandler == null)) {
                Looper looper;
                if ((looper = Looper.myLooper()) != null) {
                    mNativeEventHandler = new NativeEventHandler(this, looper);
                } else if ((looper = Looper.getMainLooper()) != null) {
                    mNativeEventHandler = new NativeEventHandler(this, looper);
                } else {
                    mNativeEventHandler = null;
                    status = ERROR_NO_INIT;
                }
            }
        }
        return status;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:29.071 -0400", hash_original_method = "9F616C262373223F7C19A96C9804A019", hash_generated_method = "ED47D9F520B5CC2CF0357F25686E0D7A")
    
    private final int native_setup(Object audioeffect_this,
                                              int audioSession,
                                              int[] id){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += audioeffect_this.getTaintInt();
    	taintDouble += audioSession;
    	taintDouble += id[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:02.634 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:02.637 -0400", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
    
    private final void native_release(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:01.134 -0400", hash_original_method = "8872A9008E31C58C242D4CD0A2B35F1D", hash_generated_method = "6AC133F2EB7938350B7CB15E3D6BE052")
    
    private final int native_setEnabled(boolean enabled){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((enabled) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:51.188 -0400", hash_original_method = "2AFB9A522158996345CFEAF824256F69", hash_generated_method = "1D026D1C1A92C3AAEEBB96B2B79A68C7")
    
    private final boolean native_getEnabled(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:29.090 -0400", hash_original_method = "EC22AA8EEA04A40F54E298919530920A", hash_generated_method = "BE2754679FD3EF93799F55DCBAECF5B1")
    
    private final int native_setCaptureSize(int size){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += size;
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:51.193 -0400", hash_original_method = "BB59ECCEE06EB45E4826B6A9337068F9", hash_generated_method = "C3F4ECA2F9754EAE09793A0D6CD42430")
    
    private final int native_getCaptureSize(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:51.195 -0400", hash_original_method = "811140457282587FBB6EA82E5142947C", hash_generated_method = "614B39334BC0E497A1C9EF25F850F43F")
    
    private final int native_getSamplingRate(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:29.101 -0400", hash_original_method = "DD13C778DFD9A8CCEB68CCA8D8EA96A1", hash_generated_method = "E1CE8CB1835C53A20FA9190528483A68")
    
    private final int native_getWaveForm(byte[] waveform){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += waveform[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:29.105 -0400", hash_original_method = "3EA178C8ADC23C4E3D57A9C08EB404A7", hash_generated_method = "890CC51A983D576040AAFA5FB1211917")
    
    private final int native_getFft(byte[] fft){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += fft[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:39:01.154 -0400", hash_original_method = "EA454108FFD399E26F795AF3AD81C428", hash_generated_method = "0983838BC197D1CDB8DF65A6BFC7721E")
    
    private final int native_setPeriodicCapture(int rate, boolean waveForm, boolean fft){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += rate;
    	taintDouble += ((waveForm) ? 1 : 0);
    	taintDouble += ((fft) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

}

