/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.ref.WeakReference;
import java.io.OutputStream;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Thread;
import java.nio.ByteBuffer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * The AudioRecord class manages the audio resources for Java applications
 * to record audio from the audio input hardware of the platform. This is
 * achieved by "pulling" (reading) the data from the AudioRecord object. The
 * application is responsible for polling the AudioRecord object in time using one of 
 * the following three methods:  {@link #read(byte[],int, int)}, {@link #read(short[], int, int)}
 * or {@link #read(ByteBuffer, int)}. The choice of which method to use will be based 
 * on the audio data storage format that is the most convenient for the user of AudioRecord.
 * <p>Upon creation, an AudioRecord object initializes its associated audio buffer that it will
 * fill with the new audio data. The size of this buffer, specified during the construction, 
 * determines how long an AudioRecord can record before "over-running" data that has not
 * been read yet. Data should be read from the audio hardware in chunks of sizes inferior to
 * the total recording buffer size.
 */
public class AudioRecord
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.368 -0500", hash_original_field = "DADF89E4937FB007E11FCD2CF7BDDE2E", hash_generated_field = "A76910B4EA51F1C880C65FC411FE0846")

    // Constants
    //--------------------
    /**
     *  indicates AudioRecord state is not successfully initialized. 
     */
    public static final int STATE_UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.380 -0500", hash_original_field = "02EF6A6792F741D2888A16AA95F5BE68", hash_generated_field = "528069025EBD3248613210FDC5DD79AC")

    public static final int STATE_INITIALIZED   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.390 -0500", hash_original_field = "8CBDFB4633E7F4622C95AF8A938B7E22", hash_generated_field = "F0837B826FBEC6F12C233B030C946C80")

    public static final int RECORDSTATE_STOPPED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.399 -0500", hash_original_field = "88285FA3B96CC5ABF6CD48306424437A", hash_generated_field = "66DD6EAB726ABF2312354AFF4B4C78C2")

    /**
     * indicates AudioRecord recording state is recording 
     */
    public static final int RECORDSTATE_RECORDING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.409 -0500", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "D368C87D4B8D849294C5B2BFA9F26133")


    // Error codes:
    // to keep in sync with frameworks/base/core/jni/android_media_AudioRecord.cpp
    /**
     * Denotes a successful operation.
     */
    public static final int SUCCESS                 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.431 -0500", hash_original_field = "060BE1B4136BE1AC2BFF57541DF9E977", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR                   = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.443 -0500", hash_original_field = "6F2894C7BCB6B8B432BE715537A9CE56", hash_generated_field = "05AC081A695792BED8D5C6DC79C8ED03")

    public static final int ERROR_BAD_VALUE         = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.451 -0500", hash_original_field = "A252B7DDCD404D293C8DF8ECBD41F9D1", hash_generated_field = "FD247E88C1E85F7AE30BA22773BF6A3B")

    public static final int ERROR_INVALID_OPERATION = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.461 -0500", hash_original_field = "21F94D1EAC43E93365D901EE02902323", hash_generated_field = "BF93E21576A3B2CA77860393ECCD0417")

    
    private static final int AUDIORECORD_ERROR_SETUP_ZEROFRAMECOUNT      = -16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.471 -0500", hash_original_field = "B4A3F5415584880E34B6FF10B2006DB4", hash_generated_field = "FA13E41AF4927D38BD807F679267AFEB")

    private static final int AUDIORECORD_ERROR_SETUP_INVALIDCHANNELMASK  = -17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.502 -0500", hash_original_field = "CCD1C862502E08789E0F00637A0A8729", hash_generated_field = "9153AB35EAFBE50F0B4932712A03CC17")

    private static final int AUDIORECORD_ERROR_SETUP_INVALIDFORMAT       = -18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.550 -0500", hash_original_field = "F5ABF2BD9F361925221920F3ADCA02E7", hash_generated_field = "F13B051E775775E30F576A549C7D2661")

    private static final int AUDIORECORD_ERROR_SETUP_INVALIDSOURCE       = -19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.559 -0500", hash_original_field = "17E777C12F05D25695D043BD4D764B38", hash_generated_field = "E76C98880DBB1B560F920DF0EF28A218")

    private static final int AUDIORECORD_ERROR_SETUP_NATIVEINITFAILED    = -20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.568 -0500", hash_original_field = "63F9C876894E5F7F6036A7AEAB8CB9E6", hash_generated_field = "C10DD4F0045F5B11B055B53A2D2C72C7")

    // to keep in sync with frameworks/base/include/media/AudioRecord.h 
    /**
     * Event id denotes when record head has reached a previously set marker.
     */
    private static final int NATIVE_EVENT_MARKER  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.577 -0500", hash_original_field = "3414BF7E5036A87BD8DC3DEDF174332D", hash_generated_field = "AD251A20E248B439EF7E86844538835C")

    private static final int NATIVE_EVENT_NEW_POS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.585 -0500", hash_original_field = "7F9A0061087988706A825661F6580CAC", hash_generated_field = "963E58A81FACA9BA2A3C11F65FF70C13")

    
    private final static String TAG = "AudioRecord-Java";

    /**
     * Returns the minimum buffer size required for the successful creation of an AudioRecord
     * object.
     * Note that this size doesn't guarantee a smooth recording under load, and higher values
     * should be chosen according to the expected frequency at which the AudioRecord instance
     * will be polled for new data.
     * @param sampleRateInHz the sample rate expressed in Hertz.
     * @param channelConfig describes the configuration of the audio channels. 
     *   See {@link AudioFormat#CHANNEL_IN_MONO} and
     *   {@link AudioFormat#CHANNEL_IN_STEREO}
     * @param audioFormat the format in which the audio data is represented. 
     *   See {@link AudioFormat#ENCODING_PCM_16BIT}.
     * @return {@link #ERROR_BAD_VALUE} if the recording parameters are not supported by the 
     *  hardware, or an invalid parameter was passed,
     *  or {@link #ERROR} if the implementation was unable to query the hardware for its 
     *  output properties, 
     *   or the minimum buffer size expressed in bytes.
     * @see #AudioRecord(int, int, int, int, int) for more information on valid
     *   configuration values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.833 -0500", hash_original_method = "B7DABA2E81D02B8062A7854407A79CD2", hash_generated_method = "28BB795A590A2F9B32970386B2E85535")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
static public int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) {
        int channelCount = 0;
        switch(channelConfig) {
        case AudioFormat.CHANNEL_IN_DEFAULT: // AudioFormat.CHANNEL_CONFIGURATION_DEFAULT
        case AudioFormat.CHANNEL_IN_MONO:
        case AudioFormat.CHANNEL_CONFIGURATION_MONO:
            channelCount = 1;
            break;
        case AudioFormat.CHANNEL_IN_STEREO:
        case AudioFormat.CHANNEL_CONFIGURATION_STEREO:
            channelCount = 2;
            break;
        case AudioFormat.CHANNEL_INVALID:
        default:
            loge("getMinBufferSize(): Invalid channel configuration.");
            return AudioRecord.ERROR_BAD_VALUE;
        }
        
        // PCM_8BIT is not supported at the moment
        if (audioFormat != AudioFormat.ENCODING_PCM_16BIT) {
            loge("getMinBufferSize(): Invalid audio format.");
            return AudioRecord.ERROR_BAD_VALUE;
        }
        
        int size = native_get_min_buff_size(sampleRateInHz, channelCount, audioFormat);
        if (size == 0) {
            return AudioRecord.ERROR_BAD_VALUE;
        } 
        else if (size == -1) {
            return AudioRecord.ERROR;
        }
        else {
            return size;
        }
    }
    
    
    //---------------------------------------------------------
    // Java methods called from the native side
    //--------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.946 -0500", hash_original_method = "1E72093FB949B24FD44FC8E0BCCE333C", hash_generated_method = "0E5D3E69F322501D5880E8C8DE202157")
    
@SuppressWarnings("unused")
    private static void postEventFromNative(Object audiorecord_ref,
            int what, int arg1, int arg2, Object obj) {
        //logd("Event posted from the native side: event="+ what + " args="+ arg1+" "+arg2);
        AudioRecord recorder = (AudioRecord)((WeakReference)audiorecord_ref).get();
        if (recorder == null) {
            return;
        }
        
        if (recorder.mEventHandler != null) {
            Message m = 
                recorder.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            recorder.mEventHandler.sendMessage(m);
        }

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.071 -0500", hash_original_method = "B58723AC8A06330DB518FE874415CDC1", hash_generated_method = "AA49D321012562E9189BD4F7C2309138")
    
    static private final int native_get_min_buff_size(
                int sampleRateInHz, int channelCount, int audioFormat){
    	//Formerly a native method
    	addTaint(sampleRateInHz);
    	addTaint(channelCount);
    	addTaint(audioFormat);
    	return getTaintInt();
    }


    
    //---------------------------------------------------------
    // Utility methods
    //------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.077 -0500", hash_original_method = "A9DBD4C329B31439CE2C6FB14DFF379F", hash_generated_method = "33E3EBE9D875BA62D4B9074AC1EC51A0")
    
private static void logd(String msg) {
        Log.d(TAG, "[ android.media.AudioRecord ] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.083 -0500", hash_original_method = "75CA5EAAC0C8354AF1081433384842E6", hash_generated_method = "980C32A2B4CD058ECF02424AE3C20082")
    
private static void loge(String msg) {
        Log.e(TAG, "[ android.media.AudioRecord ] " + msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.593 -0500", hash_original_field = "FD9A085B565F5CA37ACA0E450534C912", hash_generated_field = "17DEC6039397426B16BB5DC2B719D8E1")

    // Used exclusively by native code
    //--------------------
    /** 
     * Accessed by native methods: provides access to C++ AudioRecord object 
     */
    @SuppressWarnings("unused")
    private int mNativeRecorderInJavaObj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.601 -0500", hash_original_field = "FF0A7214D3AF7A4AACAD532D3D93F275", hash_generated_field = "191E93003CD5BF38E9122CF3A6340F28")

    @SuppressWarnings("unused")
    private int mNativeCallbackCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.608 -0500", hash_original_field = "FF7D55545A4A6EDC43A63C5B25A4912F", hash_generated_field = "A1F0EB1D43B3C3C2B5B48DBA58A763FB")

    // Member variables
    //--------------------    
    /**
     * The audio data sampling rate in Hz.
     */
    private int mSampleRate = 22050;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.615 -0500", hash_original_field = "273A26627E6E4547D11EA77C438B598B", hash_generated_field = "FB49A190C1952F8CF78F136523D18523")

    private int mChannelCount = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.622 -0500", hash_original_field = "D73B8F9DD9B694F8F4051CEA510A2824", hash_generated_field = "E40E31D76BC35DDD42032DE328DC50B8")

    private int mChannels = AudioFormat.CHANNEL_IN_MONO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.630 -0500", hash_original_field = "575266F71E6EA49A2C034179D04BE57D", hash_generated_field = "657D31CC986D1D3AAE1FBD7E168A57BE")

    private int mChannelConfiguration = AudioFormat.CHANNEL_IN_MONO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.636 -0500", hash_original_field = "637DC6BCFF8548AF0D398690E740248D", hash_generated_field = "940DDB3265E50FFFB96C08F7DF1A20A4")

    private int mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.644 -0500", hash_original_field = "4B3E38F9216A5F902A9794B45C874AC2", hash_generated_field = "A56052E9660EAB8A02CF51852BF2D9AE")

    private int mRecordSource = MediaRecorder.AudioSource.DEFAULT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.651 -0500", hash_original_field = "78622F071E041CCB5EEFF5A3BEF9AB78", hash_generated_field = "73C839BCBA784BA2B3C16F5875CD50F9")

    private int mState = STATE_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.658 -0500", hash_original_field = "0D132471999DAFDAFCC9581534FD19DD", hash_generated_field = "C2C5E342C40484F7BEFA9F918054CDE9")

    private int mRecordingState = RECORDSTATE_STOPPED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.665 -0500", hash_original_field = "58E46E6DAF3A7CDFA6A3F87D73997378", hash_generated_field = "32325631C2C22334EA361ED836438DE3")

    private Object mRecordingStateLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.672 -0500", hash_original_field = "8C10B6608DDEFA1A1CC65B0B669031AA", hash_generated_field = "A01772C496551632C741F43BD26DD641")

    private OnRecordPositionUpdateListener mPositionListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.680 -0500", hash_original_field = "BBA57B0CFAE7921CBB08B6AA6A99BCF1", hash_generated_field = "349D3D0F006A78CB25D005086E0D57B4")

    private final Object mPositionListenerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.688 -0500", hash_original_field = "29698EFF4BDA1A12C2604E1C6C5D984E", hash_generated_field = "AF2C00A048F0DE16640D09D5729846D2")

    private NativeEventHandler mEventHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.694 -0500", hash_original_field = "D63D01423B881C701A523B73DD4B6259", hash_generated_field = "4A391BD92B92CAB783355948007D2481")

    private Looper mInitializationLooper = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.701 -0500", hash_original_field = "ABF00CECE279EA2A29D6CCB6A9CB2062", hash_generated_field = "9E730889F1E9D34B5E932A2BCB5ABA73")

    private int mNativeBufferSizeInBytes = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.707 -0500", hash_original_field = "96DA9DBEF56845CF194EB4963AC3A578", hash_generated_field = "9819DAE9B4A1C1CF08947B1FB28E9731")

    private int mSessionId = 0;

    //---------------------------------------------------------
    // Constructor, Finalize
    //--------------------
    /**
     * Class constructor.
     * @param audioSource the recording source. See {@link MediaRecorder.AudioSource} for
     *    recording source definitions.
     * @param sampleRateInHz the sample rate expressed in Hertz. 44100Hz is currently the only
     *   rate that is guaranteed to work on all devices, but other rates such as 22050,
     *   16000, and 11025 may work on some devices.
     * @param channelConfig describes the configuration of the audio channels. 
     *   See {@link AudioFormat#CHANNEL_IN_MONO} and
     *   {@link AudioFormat#CHANNEL_IN_STEREO}.  {@link AudioFormat#CHANNEL_IN_MONO} is guaranteed
     *   to work on all devices.
     * @param audioFormat the format in which the audio data is represented. 
     *   See {@link AudioFormat#ENCODING_PCM_16BIT} and 
     *   {@link AudioFormat#ENCODING_PCM_8BIT}
     * @param bufferSizeInBytes the total size (in bytes) of the buffer where audio data is written
     *   to during the recording. New audio data can be read from this buffer in smaller chunks 
     *   than this size. See {@link #getMinBufferSize(int, int, int)} to determine the minimum
     *   required buffer size for the successful creation of an AudioRecord instance. Using values
     *   smaller than getMinBufferSize() will result in an initialization failure.
     * @throws java.lang.IllegalArgumentException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.723 -0500", hash_original_method = "3C0277EA886F5E2649AAEC29D08588E3", hash_generated_method = "B191A9060F3E4D09622EA5E6E2E45C62")
    
public AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, 
            int bufferSizeInBytes)
    throws IllegalArgumentException {   
        mState = STATE_UNINITIALIZED;
        mRecordingState = RECORDSTATE_STOPPED;
        
        // remember which looper is associated with the AudioRecord instanciation
        if ((mInitializationLooper = Looper.myLooper()) == null) {
            mInitializationLooper = Looper.getMainLooper();
        }

        audioParamCheck(audioSource, sampleRateInHz, channelConfig, audioFormat);

        audioBuffSizeCheck(bufferSizeInBytes);

        // native initialization
        int[] session = new int[1];
        session[0] = 0;
        //TODO: update native initialization when information about hardware init failure
        //      due to capture device already open is available.
        int initResult = native_setup( new WeakReference<AudioRecord>(this), 
                mRecordSource, mSampleRate, mChannels, mAudioFormat, mNativeBufferSizeInBytes,
                session);
        if (initResult != SUCCESS) {
            loge("Error code "+initResult+" when initializing native AudioRecord object.");
            return; // with mState == STATE_UNINITIALIZED
        }

        mSessionId = session[0];

        mState = STATE_INITIALIZED;
    }


    // Convenience method for the constructor's parameter checks.
    // This is where constructor IllegalArgumentException-s are thrown
    // postconditions:
    //    mRecordSource is valid
    //    mChannelCount is valid
    //    mChannels is valid
    //    mAudioFormat is valid
    //    mSampleRate is valid
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.740 -0500", hash_original_method = "5B2B7645F87C274AF9290323AA69F269", hash_generated_method = "838CC77A65ECDC20D2ED4A935F534E97")
    
private void audioParamCheck(int audioSource, int sampleRateInHz, 
                                 int channelConfig, int audioFormat) {

        //--------------
        // audio source
        if ( (audioSource < MediaRecorder.AudioSource.DEFAULT) ||
             (audioSource > MediaRecorder.getAudioSourceMax()) )  {
            throw (new IllegalArgumentException("Invalid audio source."));
        } else {
            mRecordSource = audioSource;
        }
        
        //--------------
        // sample rate
        if ( (sampleRateInHz < 4000) || (sampleRateInHz > 48000) ) {
            throw (new IllegalArgumentException(sampleRateInHz
                    + "Hz is not a supported sample rate."));
        } else { 
            mSampleRate = sampleRateInHz;
        }

        //--------------
        // channel config
        mChannelConfiguration = channelConfig;

        switch (channelConfig) {
        case AudioFormat.CHANNEL_IN_DEFAULT: // AudioFormat.CHANNEL_CONFIGURATION_DEFAULT
        case AudioFormat.CHANNEL_IN_MONO:
        case AudioFormat.CHANNEL_CONFIGURATION_MONO:
            mChannelCount = 1;
            mChannels = AudioFormat.CHANNEL_IN_MONO;
            break;
        case AudioFormat.CHANNEL_IN_STEREO:
        case AudioFormat.CHANNEL_CONFIGURATION_STEREO:
            mChannelCount = 2;
            mChannels = AudioFormat.CHANNEL_IN_STEREO;
            break;
        default:
            mChannelCount = 0;
            mChannels = AudioFormat.CHANNEL_INVALID;
            mChannelConfiguration = AudioFormat.CHANNEL_INVALID;
            throw (new IllegalArgumentException("Unsupported channel configuration."));
        }

        //--------------
        // audio format
        switch (audioFormat) {
        case AudioFormat.ENCODING_DEFAULT:
            mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;
            break;
        case AudioFormat.ENCODING_PCM_16BIT:
        case AudioFormat.ENCODING_PCM_8BIT:
            mAudioFormat = audioFormat;
            break;
        default:
            mAudioFormat = AudioFormat.ENCODING_INVALID;
        throw (new IllegalArgumentException("Unsupported sample encoding." 
                + " Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT."));
        }
    }


    // Convenience method for the contructor's audio buffer size check.
    // preconditions:
    //    mChannelCount is valid
    //    mAudioFormat is AudioFormat.ENCODING_PCM_8BIT OR AudioFormat.ENCODING_PCM_16BIT
    // postcondition:
    //    mNativeBufferSizeInBytes is valid (multiple of frame size, positive)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.748 -0500", hash_original_method = "342FD6C6403871C2F1242F4EC054CF23", hash_generated_method = "A6E872FC7C188849AF054ECEAA441407")
    
private void audioBuffSizeCheck(int audioBufferSize) {
        // NB: this section is only valid with PCM data. 
        // To update when supporting compressed formats
        int frameSizeInBytes = mChannelCount 
            * (mAudioFormat == AudioFormat.ENCODING_PCM_8BIT ? 1 : 2);
        if ((audioBufferSize % frameSizeInBytes != 0) || (audioBufferSize < 1)) {
            throw (new IllegalArgumentException("Invalid audio buffer size."));
        }

        mNativeBufferSizeInBytes = audioBufferSize;
    }    



    /**
     * Releases the native AudioRecord resources.
     * The object can no longer be used and the reference should be set to null
     * after a call to release()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.758 -0500", hash_original_method = "6BAFEF4B56071398EF886C8BE9B37DAC", hash_generated_method = "0CB0E51B886DD97EA89E4DF7048B042A")
    
public void release() {
        try {
            stop();
        } catch(IllegalStateException ise) { 
            // don't raise an exception, we're releasing the resources.
        }
        native_release();
        mState = STATE_UNINITIALIZED;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.766 -0500", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() {
        native_finalize();
    } 


    //--------------------------------------------------------------------------
    // Getters
    //--------------------
    /**
     * Returns the configured audio data sample rate in Hz
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.772 -0500", hash_original_method = "5666B4191766587ED45008EA1D23BF73", hash_generated_method = "82B2B8B776281A57F731F434FB352AEA")
    
public int getSampleRate() {
        return mSampleRate;
    }
    
    /**
     * Returns the audio recording source. 
     * @see MediaRecorder.AudioSource
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.780 -0500", hash_original_method = "B1EA7F895295D38556969E1F084BB16D", hash_generated_method = "8999A47BDC11219947D89A5F5AFEB9C2")
    
public int getAudioSource() {
        return mRecordSource;
    }

    /**
     * Returns the configured audio data format. See {@link AudioFormat#ENCODING_PCM_16BIT}
     * and {@link AudioFormat#ENCODING_PCM_8BIT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.786 -0500", hash_original_method = "5A66EC85178A602201DB62AF4CF855B2", hash_generated_method = "4DA4B2BABC9EFDDB0A8BA3A9D19F7A62")
    
public int getAudioFormat() {
        return mAudioFormat;
    }

    /**
     * Returns the configured channel configuration. 
     * See {@link AudioFormat#CHANNEL_IN_MONO}
     * and {@link AudioFormat#CHANNEL_IN_STEREO}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.792 -0500", hash_original_method = "F508150A03B79B95360C824777E3A183", hash_generated_method = "34A8B08C5585242A539E6A8F61B4CC8C")
    
public int getChannelConfiguration() {
        return mChannelConfiguration;
    }

    /**
     * Returns the configured number of channels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.799 -0500", hash_original_method = "FEFFD01780A1669D04A31D0DCFF637B3", hash_generated_method = "A1C7DA9DBD6CF5F9B126098C3EC42F5B")
    
public int getChannelCount() {
        return mChannelCount;
    }

    /**
     * Returns the state of the AudioRecord instance. This is useful after the
     * AudioRecord instance has been created to check if it was initialized 
     * properly. This ensures that the appropriate hardware resources have been
     * acquired.
     * @see AudioRecord#STATE_INITIALIZED
     * @see AudioRecord#STATE_UNINITIALIZED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.805 -0500", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "4C50D1866B5E804CF0B05EFBD6788B97")
    
public int getState() {
        return mState;
    }

    /**
     * Returns the recording state of the AudioRecord instance.
     * @see AudioRecord#RECORDSTATE_STOPPED
     * @see AudioRecord#RECORDSTATE_RECORDING
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.812 -0500", hash_original_method = "30351EEEA427C13C715E217D315ACE64", hash_generated_method = "71996B4C0BA2B95C1D26F263F9090BF2")
    
public int getRecordingState() {
        return mRecordingState;
    }

    /**
     * Returns the notification marker position expressed in frames.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.818 -0500", hash_original_method = "C6C1E05020531B50D8603501A67817E5", hash_generated_method = "072C38CF4C9722AD8FE550E8B6E6ACFE")
    
public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    /**
     * Returns the notification update period expressed in frames.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.824 -0500", hash_original_method = "1FDDF97C8404166C9612F23F2CAA5241", hash_generated_method = "B8B95AABD8AC029CDE913AC4653A4871")
    
public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    /**
     * Returns the audio session ID.
     *
     * @return the ID of the audio session this AudioRecord belongs to.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.839 -0500", hash_original_method = "1268BAA460260961FDCDB1561D6C79F7", hash_generated_method = "9074931D99C969561F1125836F878477")
    
public int getAudioSessionId() {
        return mSessionId;
    }

    //---------------------------------------------------------
    // Transport control methods
    //--------------------
    /**
     * Starts recording from the AudioRecord instance. 
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.847 -0500", hash_original_method = "D5E9AE9E0E11D1DB437CBB352D957E8A", hash_generated_method = "9A9E9BB9FCCCB393EF8EBAF1029769B6")
   
    
    @DSSpec(DSCat.AUDIO_RECORDING)
public void startRecording()
    throws IllegalStateException {
        if (mState != STATE_INITIALIZED) {
            throw(new IllegalStateException("startRecording() called on an "
                    +"uninitialized AudioRecord."));
        }

        // start recording
        synchronized(mRecordingStateLock) {
            if (native_start() == SUCCESS) {
                mRecordingState = RECORDSTATE_RECORDING;
            }
        }
    }



    /**
     * Stops recording.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.854 -0500", hash_original_method = "DCED7C3D485614A25886EC95E815652B", hash_generated_method = "43A56A783FA9D3770C7E7A10A09AF11F")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void stop()
    throws IllegalStateException {
        if (mState != STATE_INITIALIZED) {
            throw(new IllegalStateException("stop() called on an uninitialized AudioRecord."));
        }

        // stop recording
        synchronized(mRecordingStateLock) {
            native_stop();
            mRecordingState = RECORDSTATE_STOPPED;
        }
    }


    //---------------------------------------------------------
    // Audio data supply
    //--------------------
    /**
     * Reads audio data from the audio hardware for recording into a buffer.
     * @param audioData the array to which the recorded audio data is written.
     * @param offsetInBytes index in audioData from which the data is written expressed in bytes.
     * @param sizeInBytes the number of requested bytes.
     * @return the number of bytes that were read or or {@link #ERROR_INVALID_OPERATION}
     *    if the object wasn't properly initialized, or {@link #ERROR_BAD_VALUE} if
     *    the parameters don't resolve to valid data and indexes.
     *    The number of bytes will not exceed sizeInBytes.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.862 -0500", hash_original_method = "B2BF87214356B1865A95A687C4A6B1B8", hash_generated_method = "46C02CDEC81CE567375CF0A8C8480E97")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(byte[] audioData, int offsetInBytes, int sizeInBytes) {
        if (mState != STATE_INITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        
        if ( (audioData == null) || (offsetInBytes < 0 ) || (sizeInBytes < 0) 
                || (offsetInBytes + sizeInBytes > audioData.length)) {
            return ERROR_BAD_VALUE;
        }

        return native_read_in_byte_array(audioData, offsetInBytes, sizeInBytes);
    }


    /**
     * Reads audio data from the audio hardware for recording into a buffer.
     * @param audioData the array to which the recorded audio data is written.
     * @param offsetInShorts index in audioData from which the data is written expressed in shorts.
     * @param sizeInShorts the number of requested shorts.
     * @return the number of shorts that were read or or {@link #ERROR_INVALID_OPERATION}
     *    if the object wasn't properly initialized, or {@link #ERROR_BAD_VALUE} if
     *    the parameters don't resolve to valid data and indexes.
     *    The number of shorts will not exceed sizeInShorts.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.868 -0500", hash_original_method = "31830FEBBB69B42EDEDE540E14955C0E", hash_generated_method = "3B938B52E7C2B587F334F201EFCCD73C")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(short[] audioData, int offsetInShorts, int sizeInShorts) {
        if (mState != STATE_INITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        
        if ( (audioData == null) || (offsetInShorts < 0 ) || (sizeInShorts < 0) 
                || (offsetInShorts + sizeInShorts > audioData.length)) {
            return ERROR_BAD_VALUE;
        }

        return native_read_in_short_array(audioData, offsetInShorts, sizeInShorts);
    }


    /**
     * Reads audio data from the audio hardware for recording into a direct buffer. If this buffer
     * is not a direct buffer, this method will always return 0.
     * @param audioBuffer the direct buffer to which the recorded audio data is written.
     * @param sizeInBytes the number of requested bytes.
     * @return the number of bytes that were read or or {@link #ERROR_INVALID_OPERATION}
     *    if the object wasn't properly initialized, or {@link #ERROR_BAD_VALUE} if
     *    the parameters don't resolve to valid data and indexes.
     *    The number of bytes will not exceed sizeInBytes.
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.875 -0500", hash_original_method = "2CBF0F4953E69C144CF30A698A24018A", hash_generated_method = "E84D426E817ED34BC874E8108047567F")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(ByteBuffer audioBuffer, int sizeInBytes) {
        if (mState != STATE_INITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        
        if ( (audioBuffer == null) || (sizeInBytes < 0) ) {
            return ERROR_BAD_VALUE;
        }

        return native_read_in_direct_buffer(audioBuffer, sizeInBytes);
    }


    //---------------------------------------------------------
    // Interface definitions
    //--------------------
    /**
     * Interface definition for a callback to be invoked when an AudioRecord has
     * reached a notification marker set by {@link AudioRecord#setNotificationMarkerPosition(int)}
     * or for periodic updates on the progress of the record head, as set by
     * {@link AudioRecord#setPositionNotificationPeriod(int)}.
     */
    public interface OnRecordPositionUpdateListener  {
        /**
         * Called on the listener to notify it that the previously set marker has been reached
         * by the recording head.
         */
        void onMarkerReached(AudioRecord recorder);
        
        /**
         * Called on the listener to periodically notify it that the record head has reached
         * a multiple of the notification period.
         */
        void onPeriodicNotification(AudioRecord recorder);
    }



    //---------------------------------------------------------
    // Inner classes
    //--------------------
      
    /**
     * Helper class to handle the forwarding of native events to the appropriate listener
     * (potentially) handled in a different thread
     */  
    private class NativeEventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.918 -0500", hash_original_field = "2B54E5191104C9CC662749AFFFB72F6D", hash_generated_field = "D02B153A39B137A767FAF29879DD86F9")

        
        private  AudioRecord mAudioRecord;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.925 -0500", hash_original_method = "F18DAD95A7878C391E5FD9E872819B0D", hash_generated_method = "F18DAD95A7878C391E5FD9E872819B0D")
        
NativeEventHandler(AudioRecord recorder, Looper looper) {
            super(looper);
            mAudioRecord = recorder;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.933 -0500", hash_original_method = "A027355AC274B858A19853667EAC27C7", hash_generated_method = "A3326C9B2A55B050AAE1F2CAE174D46D")
        
@Override
        public void handleMessage(Message msg) {
            OnRecordPositionUpdateListener listener = null;
            synchronized (mPositionListenerLock) {
                listener = mAudioRecord.mPositionListener;
            }
            
            switch(msg.what) {
            case NATIVE_EVENT_MARKER:
                if (listener != null) {
                    listener.onMarkerReached(mAudioRecord);
                }
                break;
            case NATIVE_EVENT_NEW_POS:
                if (listener != null) {
                    listener.onPeriodicNotification(mAudioRecord);
                }
                break;
            default:
                Log.e(TAG, "[ android.media.AudioRecord.NativeEventHandler ] " +
                        "Unknown event type: " + msg.what);
            break;
            }
        }
    };


    //--------------------------------------------------------------------------
    // Initialization / configuration
    //--------------------  
    /**
     * Sets the listener the AudioRecord notifies when a previously set marker is reached or
     * for each periodic record head position update.
     * @param listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.882 -0500", hash_original_method = "F908EA66CD754BB92B02DD1779229699", hash_generated_method = "B5353FCFF5D2010097167596264C834B")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener listener) {
        setRecordPositionUpdateListener(listener, null);
    }

    /**
     * Sets the listener the AudioRecord notifies when a previously set marker is reached or
     * for each periodic record head position update.
     * Use this method to receive AudioRecord events in the Handler associated with another
     * thread than the one in which you created the AudioTrack instance.
     * @param listener
     * @param handler the Handler that will receive the event notification messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.888 -0500", hash_original_method = "96E62F3A41242C90AF3EA521048E8CC0", hash_generated_method = "E56D16961C452057812DAB7B769B282C")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setRecordPositionUpdateListener(OnRecordPositionUpdateListener listener, 
                                                    Handler handler) {
        synchronized (mPositionListenerLock) {
            
            mPositionListener = listener;
            
            if (listener != null) {
                if (handler != null) {
                    mEventHandler = new NativeEventHandler(this, handler.getLooper());
                } else {
                    // no given handler, use the looper the AudioRecord was created in
                    mEventHandler = new NativeEventHandler(this, mInitializationLooper);
                }
                listener.onPeriodicNotification(this);
                listener.onMarkerReached(this);
            } else {
                mEventHandler = null;
            }
        }
        
    }


    /**
     * Sets the marker position at which the listener is called, if set with 
     * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener)} or 
     * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener, Handler)}.
     * @param markerInFrames marker position expressed in frames
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *  {@link #ERROR_INVALID_OPERATION} 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.895 -0500", hash_original_method = "EBFE5793D63A3BF1E8F4DCCCA4BD55D7", hash_generated_method = "FD6B88362CE1F601C5400C52E3EC9C53")
    @DSSafe(DSCat.SAFE_OTHERS)
public int setNotificationMarkerPosition(int markerInFrames) {
        return native_set_marker_pos(markerInFrames);
    }


    /**
     * Sets the period at which the listener is called, if set with
     * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener)} or 
     * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener, Handler)}.
     * @param periodInFrames update period expressed in frames
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.901 -0500", hash_original_method = "8031AA2EED361124B038CC6BED4C4F70", hash_generated_method = "8CC13E4DFE1322AB0A55FFE30C29B25A")
    @DSSafe(DSCat.SAFE_OTHERS)
public int setPositionNotificationPeriod(int periodInFrames) {
        return native_set_pos_update_period(periodInFrames);
    }
    

    //---------------------------------------------------------
    // Native methods called from the Java side
    //--------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.957 -0500", hash_original_method = "9E6669D3AF5F8BD6A2E29849C50D26ED", hash_generated_method = "EF32F3B80ADB2F08E7B5AACB7AD11D9E")
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_setup(Object audiorecord_this, 
                int recordSource, int sampleRate, int nbChannels, int audioFormat,
                int buffSizeInBytes, int[] sessionId){
    	//Formerly a native method
    	addTaint(audiorecord_this.getTaint());
    	addTaint(recordSource);
    	addTaint(sampleRate);
    	addTaint(nbChannels);
    	addTaint(audioFormat);
    	addTaint(buffSizeInBytes);
    	addTaint(sessionId[0]);
    	return getTaintInt();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.967 -0500", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final void native_finalize(){
    	//Formerly a native method
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.977 -0500", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final void native_release(){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.986 -0500", hash_original_method = "018663B9BA68CEE6215D6C2D6CDF1E24", hash_generated_method = "3CF50098215D70CBF36D1000DAFEBC9C")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_start(){
    	//Formerly a native method
    	return getTaintInt();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:28.995 -0500", hash_original_method = "7AE7BD386DE7186B97622AE5A757DF71", hash_generated_method = "2C001E290E4F435149A59F53766E71EF")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final void native_stop(){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.005 -0500", hash_original_method = "B4EE445EBADFD07C3061F8995AE09F29", hash_generated_method = "53497DC50E746DA235F26B12A8B0F56D")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_read_in_byte_array(byte[] audioData, 
                int offsetInBytes, int sizeInBytes){
    	//Formerly a native method
    	addTaint(audioData[0]);
    	addTaint(offsetInBytes);
    	addTaint(sizeInBytes);
    	audioData.addTaint(getTaint());
    	return getTaintInt();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.015 -0500", hash_original_method = "8D6C27C905BCFDE7BA929DF2BC9FB650", hash_generated_method = "0800FA1D748523AF83CCF0FBFCD95AA7")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_read_in_short_array(short[] audioData, 
                int offsetInShorts, int sizeInShorts){
    	//Formerly a native method
    	addTaint(audioData[0]);
    	addTaint(offsetInShorts);
    	addTaint(sizeInShorts);
    	audioData.addTaint(getTaint());
    	return getTaintInt();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.023 -0500", hash_original_method = "EF368B7B52F9547D11C0B896AAED364B", hash_generated_method = "FE76904AC45B69622E584D79F589AFA8")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_read_in_direct_buffer(Object jBuffer, int sizeInBytes){
    	//Formerly a native method
    	addTaint(jBuffer.getTaint());
    	addTaint(sizeInBytes);
    	jBuffer.addTaint(getTaint());
    	return getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.033 -0500", hash_original_method = "F88EF7916D562385F7AC5D5313AEC7D2", hash_generated_method = "C85D747757429FD805A8DB37CB223ADC")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    private final int native_set_marker_pos(int marker){
    	//Formerly a native method
    	addTaint(marker);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.042 -0500", hash_original_method = "079AA872B3C965E7290B33BFA53DAFCE", hash_generated_method = "7F25AF0F5861B501BA9D976FE714694D")
    
    private final int native_get_marker_pos(){
    	//Formerly a native method
    	return getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.052 -0500", hash_original_method = "076BD1361A73CF54CF958B5360137DB5", hash_generated_method = "4057A75CA90D38FD797BCC4CEB825877")
    
    private final int native_set_pos_update_period(int updatePeriod){
    	//Formerly a native method
    	addTaint(updatePeriod);
    	return getTaintInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:40:29.060 -0500", hash_original_method = "E830C73D77E18E89E4E2DC076D5B24C6", hash_generated_method = "46A8232D207DD0785A35E5479E8CB1A6")
    
    private final int native_get_pos_update_period(){
    	//Formerly a native method
    	return getTaintInt();
    }


}

