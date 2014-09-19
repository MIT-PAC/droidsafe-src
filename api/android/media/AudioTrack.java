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

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;


/**
 * The AudioTrack class manages and plays a single audio resource for Java applications.
 * It allows streaming of PCM audio buffers to the audio sink for playback. This is
 * achieved by "pushing" the data to the AudioTrack object using one of the
 *  {@link #write(byte[], int, int)} and {@link #write(short[], int, int)} methods.
 *
 * <p>An AudioTrack instance can operate under two modes: static or streaming.<br>
 * In Streaming mode, the application writes a continuous stream of data to the AudioTrack, using
 * one of the {@code write()} methods. These are blocking and return when the data has been
 * transferred from the Java layer to the native layer and queued for playback. The streaming
 * mode is most useful when playing blocks of audio data that for instance are:
 *
 * <ul>
 *   <li>too big to fit in memory because of the duration of the sound to play,</li>
 *   <li>too big to fit in memory because of the characteristics of the audio data
 *         (high sampling rate, bits per sample ...)</li>
 *   <li>received or generated while previously queued audio is playing.</li>
 * </ul>
 *
 * The static mode should be chosen when dealing with short sounds that fit in memory and
 * that need to be played with the smallest latency possible. The static mode will
 * therefore be preferred for UI and game sounds that are played often, and with the
 * smallest overhead possible.
 *
 * <p>Upon creation, an AudioTrack object initializes its associated audio buffer.
 * The size of this buffer, specified during the construction, determines how long an AudioTrack
 * can play before running out of data.<br>
 * For an AudioTrack using the static mode, this size is the maximum size of the sound that can
 * be played from it.<br>
 * For the streaming mode, data will be written to the audio sink in chunks of
 * sizes less than or equal to the total buffer size.
 *
 * AudioTrack is not final and thus permits subclasses, but such use is not recommended.
 */
public class AudioTrack
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.808 -0400", hash_original_field = "9431F3CCF6E65F9A905EDAEAE19F29E7", hash_generated_field = "5D58A982A9F9E1F9CDFB1E567E9579A7")

    // Constants
    //--------------------
    /** Minimum value for a channel volume */
    private static final float VOLUME_MIN = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.818 -0400", hash_original_field = "087270867C72798B4D71234048C7A2F9", hash_generated_field = "C7F658C45BCFB81A24834C00F760E7C4")

    private static final float VOLUME_MAX = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.825 -0400", hash_original_field = "EFD94D52989C3BADB1A7913B2A3AECF3", hash_generated_field = "C36A28CD3A640C40834326250E52B24C")

    private static final int SAMPLE_RATE_HZ_MIN = 4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.832 -0400", hash_original_field = "5929887CD6BE96733E75450B6A404423", hash_generated_field = "7BEF1DA50FEB235032A9B5C12CDD6976")

    private static final int SAMPLE_RATE_HZ_MAX = 48000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.839 -0400", hash_original_field = "6159E93C4A023E06760DDE1E24E5263F", hash_generated_field = "0F9B42D29800C2F98EF6F1129E36F2C8")

    public static final int PLAYSTATE_STOPPED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.858 -0400", hash_original_field = "3DA0DF4889A81BD77048D42D99468104", hash_generated_field = "37EEBC1D6C79B90A7546D5DCECFF38EB")

    /** indicates AudioTrack state is paused */
    public static final int PLAYSTATE_PAUSED  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.865 -0400", hash_original_field = "2DF25C64E9166AD1D2F31D2B53CDDEDD", hash_generated_field = "6AA7B08FA9202E1DDDE39DD245138353")

    /** indicates AudioTrack state is playing */
    public static final int PLAYSTATE_PLAYING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.874 -0400", hash_original_field = "B1E3897703D5B668F4C0CB85695C3A15", hash_generated_field = "B7FE3FD8493EA9AE772433355AC3EA3E")


    // keep these values in sync with android_media_AudioTrack.cpp
    /**
     * Creation mode where audio data is transferred from Java to the native layer
     * only once before the audio starts playing.
     */
    public static final int MODE_STATIC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.881 -0400", hash_original_field = "4EB5372088FAB82DA847A87AA9493F8C", hash_generated_field = "EC03F2450A5A916848FD69F515B9D507")

    public static final int MODE_STREAM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.889 -0400", hash_original_field = "DADF89E4937FB007E11FCD2CF7BDDE2E", hash_generated_field = "ABD8681944D12EB0761E4A01DCCA64A7")

    public static final int STATE_UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.896 -0400", hash_original_field = "02EF6A6792F741D2888A16AA95F5BE68", hash_generated_field = "528069025EBD3248613210FDC5DD79AC")

    public static final int STATE_INITIALIZED   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.904 -0400", hash_original_field = "AD20BF9015B8B2A0EC6396AD8A8FE817", hash_generated_field = "CFF77F07E4340CBAD677CED7076311EF")

    public static final int STATE_NO_STATIC_DATA = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.912 -0400", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "40C896799751610295DD6D365D6ADA78")

    // to keep in sync with frameworks/base/core/jni/android_media_AudioTrack.cpp
    /**
     * Denotes a successful operation.
     */
    public  static final int SUCCESS                               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.919 -0400", hash_original_field = "060BE1B4136BE1AC2BFF57541DF9E977", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public  static final int ERROR                                 = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.926 -0400", hash_original_field = "6F2894C7BCB6B8B432BE715537A9CE56", hash_generated_field = "05AC081A695792BED8D5C6DC79C8ED03")

    public  static final int ERROR_BAD_VALUE                       = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.934 -0400", hash_original_field = "A252B7DDCD404D293C8DF8ECBD41F9D1", hash_generated_field = "FD247E88C1E85F7AE30BA22773BF6A3B")

    public  static final int ERROR_INVALID_OPERATION               = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.941 -0400", hash_original_field = "D1611737F7BB73B113FD3BAD589F38C8", hash_generated_field = "EF8F3204AEAB15FB20E045B2CB108D6B")


    private static final int ERROR_NATIVESETUP_AUDIOSYSTEM         = -16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.948 -0400", hash_original_field = "71C28C8BD1AA03D9F209776A366499CA", hash_generated_field = "684292468E1E7FEA4C2142B000A03CCC")

    private static final int ERROR_NATIVESETUP_INVALIDCHANNELMASK  = -17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.956 -0400", hash_original_field = "092A359EE2A00F3726B29E434D6142A4", hash_generated_field = "F4BD56117804B2AD974B3FBF1CEEB6FE")

    private static final int ERROR_NATIVESETUP_INVALIDFORMAT       = -18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.967 -0400", hash_original_field = "29B3C066FDD47815F0E1AC9E00FE93BA", hash_generated_field = "4FB15AF70E28B06BC01B3FB6FCE80B33")

    private static final int ERROR_NATIVESETUP_INVALIDSTREAMTYPE   = -19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.974 -0400", hash_original_field = "795CA94CBF0141908F6029CEA4B16E92", hash_generated_field = "912E13D0A0D8287BAA9D96C46C487A07")

    private static final int ERROR_NATIVESETUP_NATIVEINITFAILED    = -20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.981 -0400", hash_original_field = "2DF0BA52376B19AA57842CC559A20998", hash_generated_field = "EDCBA3BE2EF9D9100DB72E8C41F38F45")

    // to keep in sync with frameworks/av/include/media/AudioTrack.h
    /**
     * Event id denotes when playback head has reached a previously set marker.
     */
    private static final int NATIVE_EVENT_MARKER  = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.990 -0400", hash_original_field = "C239EEFA52E24EE7550E56D730FAFB9B", hash_generated_field = "F917F37692849E6176E3A143E3397406")

    private static final int NATIVE_EVENT_NEW_POS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:48.999 -0400", hash_original_field = "E5CEC44E9F8972BC146B7A1AD3ECC52A", hash_generated_field = "4C5D30ACB5F26E8DD41C912073D18ACD")


    private final static String TAG = "android.media.AudioTrack";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.147 -0400", hash_original_field = "9D21E493CB69F912C8913F48EAA9C8DE", hash_generated_field = "AF4FBCF37437710B83BE85C4A77E96A5")

    private static final int SUPPORTED_OUT_CHANNELS =
            AudioFormat.CHANNEL_OUT_FRONT_LEFT |
            AudioFormat.CHANNEL_OUT_FRONT_RIGHT |
            AudioFormat.CHANNEL_OUT_FRONT_CENTER |
            AudioFormat.CHANNEL_OUT_LOW_FREQUENCY |
            AudioFormat.CHANNEL_OUT_BACK_LEFT |
            AudioFormat.CHANNEL_OUT_BACK_RIGHT |
            AudioFormat.CHANNEL_OUT_BACK_CENTER;

    /**
     * Convenience method to check that the channel configuration (a.k.a channel mask) is supported
     * @param channelConfig the mask to validate
     * @return false if the AudioTrack can't be used with such a mask
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.185 -0400", hash_original_method = "B55A65ED6AE2594199F866D74B0219D8", hash_generated_method = "8934D02CB84691FEB9CBB1B337E93AFF")
    
private static boolean isMultichannelConfigSupported(int channelConfig) {
        // check for unsupported channels
        if ((channelConfig & SUPPORTED_OUT_CHANNELS) != channelConfig) {
            loge("Channel configuration features unsupported channels");
            return false;
        }
        // check for unsupported multichannel combinations:
        // - FL/FR must be present
        // - L/R channels must be paired (e.g. no single L channel)
        final int frontPair =
                AudioFormat.CHANNEL_OUT_FRONT_LEFT | AudioFormat.CHANNEL_OUT_FRONT_RIGHT;
        if ((channelConfig & frontPair) != frontPair) {
                loge("Front channels must be present in multichannel configurations");
                return false;
        }
        final int backPair =
                AudioFormat.CHANNEL_OUT_BACK_LEFT | AudioFormat.CHANNEL_OUT_BACK_RIGHT;
        if ((channelConfig & backPair) != 0) {
            if ((channelConfig & backPair) != backPair) {
                loge("Rear channels can't be used independently");
                return false;
            }
        }
        return true;
    }

    //--------------------------------------------------------------------------
    // Getters
    //--------------------
    /**
     * Returns the minimum valid volume value. Volume values set under this one will
     * be clamped at this value.
     * @return the minimum volume expressed as a linear attenuation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.217 -0400", hash_original_method = "8CB9A2B2ED36239D1596C1C91B899ED6", hash_generated_method = "DFB21FD95E3A4BCD13461A7660FEE90A")
    
static public float getMinVolume() {
        return VOLUME_MIN;
    }

    /**
     * Returns the maximum valid volume value. Volume values set above this one will
     * be clamped at this value.
     * @return the maximum volume expressed as a linear attenuation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.223 -0400", hash_original_method = "C272DD5AC21C1596355C254144FC5B01", hash_generated_method = "10B950B1B9ECC907DCD69CB95B67C977")
    
static public float getMaxVolume() {
        return VOLUME_MAX;
    }

    /**
     *  Returns the output sample rate in Hz for the specified stream type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.298 -0400", hash_original_method = "FBD512D4888D42EA8D0F6D13B1D7A3A4", hash_generated_method = "4A119A66DF7CFD350400DD659843B11E")
    
static public int getNativeOutputSampleRate(int streamType) {
        return native_get_output_sample_rate(streamType);
    }

    /**
     * Returns the minimum buffer size required for the successful creation of an AudioTrack
     * object to be created in the {@link #MODE_STREAM} mode. Note that this size doesn't
     * guarantee a smooth playback under load, and higher values should be chosen according to
     * the expected frequency at which the buffer will be refilled with additional data to play.
     * For example, if you intend to dynamically set the source sample rate of an AudioTrack
     * to a higher value than the initial source sample rate, be sure to configure the buffer size
     * based on the highest planned sample rate.
     * @param sampleRateInHz the source sample rate expressed in Hz.
     * @param channelConfig describes the configuration of the audio channels.
     *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
     *   {@link AudioFormat#CHANNEL_OUT_STEREO}
     * @param audioFormat the format in which the audio data is represented.
     *   See {@link AudioFormat#ENCODING_PCM_16BIT} and
     *   {@link AudioFormat#ENCODING_PCM_8BIT}
     * @return {@link #ERROR_BAD_VALUE} if an invalid parameter was passed,
     *   or {@link #ERROR} if unable to query for output properties,
     *   or the minimum buffer size expressed in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.308 -0400", hash_original_method = "275BD1B1B779E55C5C1071CDEA2E350B", hash_generated_method = "DF548C6D2B9F83AEF7E051EF94064388")
    
static public int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) {
        int channelCount = 0;
        switch(channelConfig) {
        case AudioFormat.CHANNEL_OUT_MONO:
        case AudioFormat.CHANNEL_CONFIGURATION_MONO:
            channelCount = 1;
            break;
        case AudioFormat.CHANNEL_OUT_STEREO:
        case AudioFormat.CHANNEL_CONFIGURATION_STEREO:
            channelCount = 2;
            break;
        default:
            if ((channelConfig & SUPPORTED_OUT_CHANNELS) != channelConfig) {
                // input channel configuration features unsupported channels
                loge("getMinBufferSize(): Invalid channel configuration.");
                return ERROR_BAD_VALUE;
            } else {
                channelCount = Integer.bitCount(channelConfig);
            }
        }

        if ((audioFormat != AudioFormat.ENCODING_PCM_16BIT)
            && (audioFormat != AudioFormat.ENCODING_PCM_8BIT)) {
            loge("getMinBufferSize(): Invalid audio format.");
            return ERROR_BAD_VALUE;
        }

        // sample rate, note these values are subject to change
        if ( (sampleRateInHz < SAMPLE_RATE_HZ_MIN) || (sampleRateInHz > SAMPLE_RATE_HZ_MAX) ) {
            loge("getMinBufferSize(): " + sampleRateInHz + " Hz is not a supported sample rate.");
            return ERROR_BAD_VALUE;
        }

        int size = native_get_min_buff_size(sampleRateInHz, channelCount, audioFormat);
        if (size <= 0) {
            loge("getMinBufferSize(): error querying hardware");
            return ERROR;
        }
        else {
            return size;
        }
    }


    //---------------------------------------------------------
    // Java methods called from the native side
    //--------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.482 -0400", hash_original_method = "8E43A732B53BAE0AB55AB6ED6902C3FE", hash_generated_method = "FE5091BFEE3758B278A0630E543A1A59")
        
@SuppressWarnings("unused")
    private static void postEventFromNative(Object audiotrack_ref,
            int what, int arg1, int arg2, Object obj) {
        //logd("Event posted from the native side: event="+ what + " args="+ arg1+" "+arg2);
        AudioTrack track = (AudioTrack)((WeakReference)audiotrack_ref).get();
        if (track == null) {
            return;
        }

        NativeEventHandlerDelegate delegate = track.mEventHandlerDelegate;
        if (delegate != null) {
            Handler handler = delegate.getHandler();
            if (handler != null) {
                Message m = handler.obtainMessage(what, arg1, arg2, obj);
                handler.sendMessage(m);
            }
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.652 -0400", hash_original_method = "C1E7DFA5DD3DFE290D454DB94EC5D821", hash_generated_method = "6B4C50F94F963B14E96F251B0C3B85C9")
        
        static private final int native_get_output_sample_rate(int streamType){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += streamType;
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.664 -0400", hash_original_method = "45A0563AB86221A6C1FDAB4684933170", hash_generated_method = "7C19433A2AAE3D0AAF63478D3EC44861")
        
        static private final int native_get_min_buff_size(
                    int sampleRateInHz, int channelConfig, int audioFormat){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += sampleRateInHz;
        	taintDouble += channelConfig;
        	taintDouble += audioFormat;
        
        	return (int)taintDouble;
        }


    //---------------------------------------------------------
    // Utility methods
    //------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.682 -0400", hash_original_method = "FA70A5071AA93EBC680559A41E7E05E6", hash_generated_method = "1C8EFB4EAF399D8A8E8471ED8B22B625")
        
private static void logd(String msg) {
        Log.d(TAG, msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.687 -0400", hash_original_method = "A4EA4CEBE74E4D0F1B7B6A89C1BE6ADF", hash_generated_method = "E6D4FE20849E0CD84B3E93EF79787C93")
        
private static void loge(String msg) {
        Log.e(TAG, msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.006 -0400", hash_original_field = "78622F071E041CCB5EEFF5A3BEF9AB78", hash_generated_field = "D63F7876C544C3E37C44E4B248F42E61")

    // Member variables
    //--------------------
    /**
     * Indicates the state of the AudioTrack instance.
     */
    private int mState = STATE_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.014 -0400", hash_original_field = "A3050E924CCF2E0C85D8C81DE1DE1E19", hash_generated_field = "D0066083B0BCE5BE9700AA3CC5C0BA11")

    private int mPlayState = PLAYSTATE_STOPPED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.021 -0400", hash_original_field = "AAE88FC966145394945949476E8B9044", hash_generated_field = "F61241CD2055AD98996FDCAEC4A1BE77")

    private final Object mPlayStateLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.027 -0400", hash_original_field = "ABF00CECE279EA2A29D6CCB6A9CB2062", hash_generated_field = "9E730889F1E9D34B5E932A2BCB5ABA73")

    private int mNativeBufferSizeInBytes = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.034 -0400", hash_original_field = "98258FFB430E44C5C59364A5ABB0C943", hash_generated_field = "C66368DFCC8B392DD642929D8ADC597A")

    private int mNativeBufferSizeInFrames = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.040 -0400", hash_original_field = "14A551D696772C5F573034CD60610463", hash_generated_field = "FD8EF1B64F12CF1E744221C1B495BB8C")

    private NativeEventHandlerDelegate mEventHandlerDelegate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.048 -0400", hash_original_field = "6A82E34A9FB1170AE1C09F5F8BA72C13", hash_generated_field = "A480BABFF87AC12E4371CDCE794509B0")

    private  Looper mInitializationLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.054 -0400", hash_original_field = "1B75864085633CA21F9147BBF45F67AE", hash_generated_field = "BE376E6E4BD10675600CC7DC38F1CCBD")

    private int mSampleRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.060 -0400", hash_original_field = "273A26627E6E4547D11EA77C438B598B", hash_generated_field = "657608A01B5720BDC479F678A04221BF")

    /**
     * The number of audio output channels (1 is mono, 2 is stereo).
     */
    private int mChannelCount = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.067 -0400", hash_original_field = "7C111A4D7A38AD025EF062067CFBDE9D", hash_generated_field = "2594B7002C3A10BCB07F610BDF0A1B7E")

    private int mChannels = AudioFormat.CHANNEL_OUT_MONO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.073 -0400", hash_original_field = "2A603574686617598A2D6BE4C9F35AE4", hash_generated_field = "ADD6E597543D4D0C7996B0A22979B561")

    private int mStreamType = AudioManager.STREAM_MUSIC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.079 -0400", hash_original_field = "C078774E65DD870645F10C9F93872B52", hash_generated_field = "D5525F5A996EB1AD994259FBB5914C13")

    private int mDataLoadMode = MODE_STREAM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.086 -0400", hash_original_field = "87D1D50D7DDEB6BD88FF6B5C8DB01054", hash_generated_field = "3761819615AA9F38316D3561EBA30F54")

    private int mChannelConfiguration = AudioFormat.CHANNEL_OUT_MONO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.092 -0400", hash_original_field = "637DC6BCFF8548AF0D398690E740248D", hash_generated_field = "940DDB3265E50FFFB96C08F7DF1A20A4")

    private int mAudioFormat = AudioFormat.ENCODING_PCM_16BIT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.098 -0400", hash_original_field = "96DA9DBEF56845CF194EB4963AC3A578", hash_generated_field = "9819DAE9B4A1C1CF08947B1FB28E9731")

    private int mSessionId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.105 -0400", hash_original_field = "6D3665C407841F9A1E470BD1738B47EE", hash_generated_field = "5334B8685CB60AC2A2976C322DFC645E")

    // Used exclusively by native code
    //--------------------
    /**
     * Accessed by native methods: provides access to C++ AudioTrack object.
     */
    @SuppressWarnings("unused")
    private int mNativeTrackInJavaObj;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.111 -0400", hash_original_field = "CD27E77ABE959434B144B34D81D41594", hash_generated_field = "4F4E37791AA06EE746E606488E423B84")

    @SuppressWarnings("unused")
    private int mJniData;


    //--------------------------------------------------------------------------
    // Constructor, Finalize
    //--------------------
    /**
     * Class constructor.
     * @param streamType the type of the audio stream. See
     *   {@link AudioManager#STREAM_VOICE_CALL}, {@link AudioManager#STREAM_SYSTEM},
     *   {@link AudioManager#STREAM_RING}, {@link AudioManager#STREAM_MUSIC},
     *   {@link AudioManager#STREAM_ALARM}, and {@link AudioManager#STREAM_NOTIFICATION}.
     * @param sampleRateInHz the initial source sample rate expressed in Hz.
     * @param channelConfig describes the configuration of the audio channels.
     *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
     *   {@link AudioFormat#CHANNEL_OUT_STEREO}
     * @param audioFormat the format in which the audio data is represented.
     *   See {@link AudioFormat#ENCODING_PCM_16BIT} and
     *   {@link AudioFormat#ENCODING_PCM_8BIT}
     * @param bufferSizeInBytes the total size (in bytes) of the internal buffer where audio data is
     *   read from for playback.
     *   If track's creation mode is {@link #MODE_STREAM}, you can write data into
     *   this buffer in chunks less than or equal to this size, and it is typical to use
     *   chunks of 1/2 of the total size to permit double-buffering.
     *   If the track's creation mode is {@link #MODE_STATIC},
     *   this is the maximum length sample, or audio clip, that can be played by this instance.
     *   See {@link #getMinBufferSize(int, int, int)} to determine the minimum required buffer size
     *   for the successful creation of an AudioTrack instance in streaming mode. Using values
     *   smaller than getMinBufferSize() will result in an initialization failure.
     * @param mode streaming or static buffer. See {@link #MODE_STATIC} and {@link #MODE_STREAM}
     * @throws java.lang.IllegalArgumentException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.121 -0400", hash_original_method = "1FB2C04D2E4B3F64A63CBC27BFD2D9FE", hash_generated_method = "C1CAB975E2F3E3F732033B87F0813A33")
    
public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat,
            int bufferSizeInBytes, int mode)
    throws IllegalArgumentException {
        this(streamType, sampleRateInHz, channelConfig, audioFormat,
                bufferSizeInBytes, mode, 0 /*session*/);
    }

    /**
     * Class constructor with audio session. Use this constructor when the AudioTrack must be
     * attached to a particular audio session. The primary use of the audio session ID is to
     * associate audio effects to a particular instance of AudioTrack: if an audio session ID
     * is provided when creating an AudioEffect, this effect will be applied only to audio tracks
     * and media players in the same session and not to the output mix.
     * When an AudioTrack is created without specifying a session, it will create its own session
     * which can be retrieved by calling the {@link #getAudioSessionId()} method.
     * If a non-zero session ID is provided, this AudioTrack will share effects attached to this
     * session
     * with all other media players or audio tracks in the same session, otherwise a new session
     * will be created for this track if none is supplied.
     * @param streamType the type of the audio stream. See
     *   {@link AudioManager#STREAM_VOICE_CALL}, {@link AudioManager#STREAM_SYSTEM},
     *   {@link AudioManager#STREAM_RING}, {@link AudioManager#STREAM_MUSIC},
     *   {@link AudioManager#STREAM_ALARM}, and {@link AudioManager#STREAM_NOTIFICATION}.
     * @param sampleRateInHz the initial source sample rate expressed in Hz.
     * @param channelConfig describes the configuration of the audio channels.
     *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
     *   {@link AudioFormat#CHANNEL_OUT_STEREO}
     * @param audioFormat the format in which the audio data is represented.
     *   See {@link AudioFormat#ENCODING_PCM_16BIT} and
     *   {@link AudioFormat#ENCODING_PCM_8BIT}
     * @param bufferSizeInBytes the total size (in bytes) of the buffer where audio data is read
     *   from for playback. If using the AudioTrack in streaming mode, you can write data into
     *   this buffer in smaller chunks than this size. If using the AudioTrack in static mode,
     *   this is the maximum size of the sound that will be played for this instance.
     *   See {@link #getMinBufferSize(int, int, int)} to determine the minimum required buffer size
     *   for the successful creation of an AudioTrack instance in streaming mode. Using values
     *   smaller than getMinBufferSize() will result in an initialization failure.
     * @param mode streaming or static buffer. See {@link #MODE_STATIC} and {@link #MODE_STREAM}
     * @param sessionId Id of audio session the AudioTrack must be attached to
     * @throws java.lang.IllegalArgumentException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.137 -0400", hash_original_method = "69CE54B1A848B8E2CEEC3234FCC5A765", hash_generated_method = "85220A9084494E9E2D8D1C16A8C4CE67")
    
public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat,
            int bufferSizeInBytes, int mode, int sessionId)
    throws IllegalArgumentException {
        // mState already == STATE_UNINITIALIZED

        // remember which looper is associated with the AudioTrack instantiation
        Looper looper;
        if ((looper = Looper.myLooper()) == null) {
            looper = Looper.getMainLooper();
        }
        mInitializationLooper = looper;

        audioParamCheck(streamType, sampleRateInHz, channelConfig, audioFormat, mode);

        audioBuffSizeCheck(bufferSizeInBytes);

        if (sessionId < 0) {
            throw new IllegalArgumentException("Invalid audio session ID: "+sessionId);
        }

        int[] session = new int[1];
        session[0] = sessionId;
        // native initialization
        int initResult = native_setup(new WeakReference<AudioTrack>(this),
                mStreamType, mSampleRate, mChannels, mAudioFormat,
                mNativeBufferSizeInBytes, mDataLoadMode, session);
        if (initResult != SUCCESS) {
            loge("Error code "+initResult+" when initializing AudioTrack.");
            return; // with mState == STATE_UNINITIALIZED
        }

        mSessionId = session[0];

        if (mDataLoadMode == MODE_STATIC) {
            mState = STATE_NO_STATIC_DATA;
        } else {
            mState = STATE_INITIALIZED;
        }
    }

    // Convenience method for the constructor's parameter checks.
    // This is where constructor IllegalArgumentException-s are thrown
    // postconditions:
    //    mStreamType is valid
    //    mChannelCount is valid
    //    mChannels is valid
    //    mAudioFormat is valid
    //    mSampleRate is valid
    //    mDataLoadMode is valid
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.174 -0400", hash_original_method = "E77B58E5D22EB7EEBEE8153CA2D63EEC", hash_generated_method = "84F4137E4A4BFDBE55F24D6A6C188C02")
    
private void audioParamCheck(int streamType, int sampleRateInHz,
                                 int channelConfig, int audioFormat, int mode) {

        //--------------
        // stream type
        if( (streamType != AudioManager.STREAM_ALARM) && (streamType != AudioManager.STREAM_MUSIC)
           && (streamType != AudioManager.STREAM_RING) && (streamType != AudioManager.STREAM_SYSTEM)
           && (streamType != AudioManager.STREAM_VOICE_CALL)
           && (streamType != AudioManager.STREAM_NOTIFICATION)
           && (streamType != AudioManager.STREAM_BLUETOOTH_SCO)
           && (streamType != AudioManager.STREAM_DTMF)) {
            throw new IllegalArgumentException("Invalid stream type.");
        }
        mStreamType = streamType;

        //--------------
        // sample rate, note these values are subject to change
        if ( (sampleRateInHz < 4000) || (sampleRateInHz > 48000) ) {
            throw new IllegalArgumentException(sampleRateInHz
                    + "Hz is not a supported sample rate.");
        }
        mSampleRate = sampleRateInHz;

        //--------------
        // channel config
        mChannelConfiguration = channelConfig;

        switch (channelConfig) {
        case AudioFormat.CHANNEL_OUT_DEFAULT: //AudioFormat.CHANNEL_CONFIGURATION_DEFAULT
        case AudioFormat.CHANNEL_OUT_MONO:
        case AudioFormat.CHANNEL_CONFIGURATION_MONO:
            mChannelCount = 1;
            mChannels = AudioFormat.CHANNEL_OUT_MONO;
            break;
        case AudioFormat.CHANNEL_OUT_STEREO:
        case AudioFormat.CHANNEL_CONFIGURATION_STEREO:
            mChannelCount = 2;
            mChannels = AudioFormat.CHANNEL_OUT_STEREO;
            break;
        default:
            if (!isMultichannelConfigSupported(channelConfig)) {
                // input channel configuration features unsupported channels
                throw new IllegalArgumentException("Unsupported channel configuration.");
            }
            mChannels = channelConfig;
            mChannelCount = Integer.bitCount(channelConfig);
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
            throw new IllegalArgumentException("Unsupported sample encoding."
                + " Should be ENCODING_PCM_8BIT or ENCODING_PCM_16BIT.");
        }

        //--------------
        // audio load mode
        if ( (mode != MODE_STREAM) && (mode != MODE_STATIC) ) {
            throw new IllegalArgumentException("Invalid mode.");
        }
        mDataLoadMode = mode;
    }


    // Convenience method for the constructor's audio buffer size check.
    // preconditions:
    //    mChannelCount is valid
    //    mAudioFormat is valid
    // postcondition:
    //    mNativeBufferSizeInBytes is valid (multiple of frame size, positive)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.197 -0400", hash_original_method = "DDF4184C6A179C34326843192AAFD7DE", hash_generated_method = "2918087D58ED0EEFF0A0A2B6B63C4C65")
    
private void audioBuffSizeCheck(int audioBufferSize) {
        // NB: this section is only valid with PCM data.
        //     To update when supporting compressed formats
        int frameSizeInBytes = mChannelCount
                * (mAudioFormat == AudioFormat.ENCODING_PCM_8BIT ? 1 : 2);
        if ((audioBufferSize % frameSizeInBytes != 0) || (audioBufferSize < 1)) {
            throw new IllegalArgumentException("Invalid audio buffer size.");
        }

        mNativeBufferSizeInBytes = audioBufferSize;
        mNativeBufferSizeInFrames = audioBufferSize / frameSizeInBytes;
    }


    /**
     * Releases the native AudioTrack resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.204 -0400", hash_original_method = "6BAFEF4B56071398EF886C8BE9B37DAC", hash_generated_method = "2FB365AE76F9A9A2EA48AC0B4A3DFFBA")
    
public void release() {
        // even though native_release() stops the native AudioTrack, we need to stop
        // AudioTrack subclasses too.
        try {
            stop();
        } catch(IllegalStateException ise) {
            // don't raise an exception, we're releasing the resources.
        }
        native_release();
        mState = STATE_UNINITIALIZED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.211 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() {
        native_finalize();
    }

    /**
     * Returns the configured audio data sample rate in Hz
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.229 -0400", hash_original_method = "5666B4191766587ED45008EA1D23BF73", hash_generated_method = "82B2B8B776281A57F731F434FB352AEA")
    
public int getSampleRate() {
        return mSampleRate;
    }

    /**
     * Returns the current playback rate in Hz.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.235 -0400", hash_original_method = "7448AA3120064A02C022D3227DD24EA0", hash_generated_method = "B1DCC3253D21E906914115B69E9E9FC4")
    
public int getPlaybackRate() {
        return native_get_playback_rate();
    }

    /**
     * Returns the configured audio data format. See {@link AudioFormat#ENCODING_PCM_16BIT}
     * and {@link AudioFormat#ENCODING_PCM_8BIT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.241 -0400", hash_original_method = "5A66EC85178A602201DB62AF4CF855B2", hash_generated_method = "4DA4B2BABC9EFDDB0A8BA3A9D19F7A62")
    
public int getAudioFormat() {
        return mAudioFormat;
    }

    /**
     * Returns the type of audio stream this AudioTrack is configured for.
     * Compare the result against {@link AudioManager#STREAM_VOICE_CALL},
     * {@link AudioManager#STREAM_SYSTEM}, {@link AudioManager#STREAM_RING},
     * {@link AudioManager#STREAM_MUSIC}, {@link AudioManager#STREAM_ALARM},
     * {@link AudioManager#STREAM_NOTIFICATION}, or {@link AudioManager#STREAM_DTMF}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.246 -0400", hash_original_method = "216E9F6C8E5136791318AC3D24F88326", hash_generated_method = "F7BEAF5998981A9DDFFDF515BD2883C7")
    
public int getStreamType() {
        return mStreamType;
    }

    /**
     * Returns the configured channel configuration.
     * See {@link AudioFormat#CHANNEL_OUT_MONO}
     * and {@link AudioFormat#CHANNEL_OUT_STEREO}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.252 -0400", hash_original_method = "F508150A03B79B95360C824777E3A183", hash_generated_method = "34A8B08C5585242A539E6A8F61B4CC8C")
    
public int getChannelConfiguration() {
        return mChannelConfiguration;
    }

    /**
     * Returns the configured number of channels.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.257 -0400", hash_original_method = "FEFFD01780A1669D04A31D0DCFF637B3", hash_generated_method = "A1C7DA9DBD6CF5F9B126098C3EC42F5B")
    
public int getChannelCount() {
        return mChannelCount;
    }

    /**
     * Returns the state of the AudioTrack instance. This is useful after the
     * AudioTrack instance has been created to check if it was initialized
     * properly. This ensures that the appropriate resources have been acquired.
     * @see #STATE_INITIALIZED
     * @see #STATE_NO_STATIC_DATA
     * @see #STATE_UNINITIALIZED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.262 -0400", hash_original_method = "10E9373648D5DF4EE43B4904732E3886", hash_generated_method = "4C50D1866B5E804CF0B05EFBD6788B97")
    
public int getState() {
        return mState;
    }

    /**
     * Returns the playback state of the AudioTrack instance.
     * @see #PLAYSTATE_STOPPED
     * @see #PLAYSTATE_PAUSED
     * @see #PLAYSTATE_PLAYING
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.267 -0400", hash_original_method = "73E2E51D9753919453D1B4769B16523A", hash_generated_method = "637493A327C16DD372A0CDFD55956A42")
    
public int getPlayState() {
        synchronized (mPlayStateLock) {
            return mPlayState;
        }
    }

    /**
     *  Returns the "native frame count", derived from the bufferSizeInBytes specified at
     *  creation time and converted to frame units.
     *  If track's creation mode is {@link #MODE_STATIC},
     *  it is equal to the specified bufferSizeInBytes converted to frame units.
     *  If track's creation mode is {@link #MODE_STREAM},
     *  it is typically greater than or equal to the specified bufferSizeInBytes converted to frame
     *  units; it may be rounded up to a larger value if needed by the target device implementation.
     *  @deprecated Only accessible by subclasses, which are not recommended for AudioTrack.
     *  See {@link AudioManager#getProperty(String)} for key
     *  {@link AudioManager#PROPERTY_OUTPUT_FRAMES_PER_BUFFER}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.272 -0400", hash_original_method = "6CBE5E133503E09638CA1D97C4AF4612", hash_generated_method = "89F2BE840DF83326E8239C0A8103B610")
    
@Deprecated
    protected int getNativeFrameCount() {
        return native_get_native_frame_count();
    }

    /**
     * Returns marker position expressed in frames.
     * @return marker position in wrapping frame units similar to {@link #getPlaybackHeadPosition},
     * or zero if marker is disabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.277 -0400", hash_original_method = "C6C1E05020531B50D8603501A67817E5", hash_generated_method = "072C38CF4C9722AD8FE550E8B6E6ACFE")
    
public int getNotificationMarkerPosition() {
        return native_get_marker_pos();
    }

    /**
     * Returns the notification update period expressed in frames.
     * Zero means that no position update notifications are being delivered.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.282 -0400", hash_original_method = "1FDDF97C8404166C9612F23F2CAA5241", hash_generated_method = "B8B95AABD8AC029CDE913AC4653A4871")
    
public int getPositionNotificationPeriod() {
        return native_get_pos_update_period();
    }

    /**
     * Returns the playback head position expressed in frames.
     * Though the "int" type is signed 32-bits, the value should be reinterpreted as if it is
     * unsigned 32-bits.  That is, the next position after 0x7FFFFFFF is (int) 0x80000000.
     * This is a continuously advancing counter.  It will wrap (overflow) periodically,
     * for example approximately once every 27:03:11 hours:minutes:seconds at 44.1 kHz.
     * It is reset to zero by flush(), reload(), and stop().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.287 -0400", hash_original_method = "340B619E1E15356002EB3B3B7313F990", hash_generated_method = "E6CABFC67051001DA3E22043107B9916")
    
public int getPlaybackHeadPosition() {
        return native_get_position();
    }

    /**
     * Returns this track's estimated latency in milliseconds. This includes the latency due
     * to AudioTrack buffer size, AudioMixer (if any) and audio hardware driver.
     *
     * DO NOT UNHIDE. The existing approach for doing A/V sync has too many problems. We need
     * a better solution.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.292 -0400", hash_original_method = "1E70CE6182546FCADE5CA31536F163C6", hash_generated_method = "CE407E69EFCCFB0D5A8EAA3370BE3FA3")
    
public int getLatency() {
        return native_get_latency();
    }

    /**
     * Returns the audio session ID.
     *
     * @return the ID of the audio session this AudioTrack belongs to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.313 -0400", hash_original_method = "1268BAA460260961FDCDB1561D6C79F7", hash_generated_method = "9074931D99C969561F1125836F878477")
    
public int getAudioSessionId() {
        return mSessionId;
    }

   /**
    * Poll for a timestamp on demand.
    *
    * Use if you need to get the most recent timestamp outside of the event callback handler.
    * Calling this method too often may be inefficient;
    * if you need a high-resolution mapping between frame position and presentation time,
    * consider implementing that at application level, based on low-resolution timestamps.
    * The audio data at the returned position may either already have been
    * presented, or may have not yet been presented but is committed to be presented.
    * It is not possible to request the time corresponding to a particular position,
    * or to request the (fractional) position corresponding to a particular time.
    * If you need such features, consider implementing them at application level.
    *
    * @param timestamp a reference to a non-null AudioTimestamp instance allocated
    *        and owned by caller.
    * @return true if a timestamp is available, or false if no timestamp is available.
    *         If a timestamp if available,
    *         the AudioTimestamp instance is filled in with a position in frame units, together
    *         with the estimated time when that frame was presented or is committed to
    *         be presented.
    *         In the case that no timestamp is available, any supplied instance is left unaltered.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.321 -0400", hash_original_method = "C01EB55A7FE86C7885768E7892889004", hash_generated_method = "641CD8E94E4390EF7BA3E1678F6148A9")
    
public boolean getTimestamp(AudioTimestamp timestamp)
    {
        if (timestamp == null) {
            throw new IllegalArgumentException();
        }
        // It's unfortunate, but we have to either create garbage every time or use synchronized
        long[] longArray = new long[2];
        int ret = native_get_timestamp(longArray);
        if (ret != SUCCESS) {
            return false;
        }
        timestamp.framePosition = longArray[0];
        timestamp.nanoTime = longArray[1];
        return true;
    }


    //--------------------------------------------------------------------------
    // Initialization / configuration
    //--------------------
    /**
     * Sets the listener the AudioTrack notifies when a previously set marker is reached or
     * for each periodic playback head position update.
     * Notifications will be received in the same thread as the one in which the AudioTrack
     * instance was created.
     * @param listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.326 -0400", hash_original_method = "09BB557FE80E5AA66FACECDD6F88B928", hash_generated_method = "93959B17A272253467AB6F7B0FBE3786")
    
public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener listener) {
        setPlaybackPositionUpdateListener(listener, null);
    }

    /**
     * Sets the listener the AudioTrack notifies when a previously set marker is reached or
     * for each periodic playback head position update.
     * Use this method to receive AudioTrack events in the Handler associated with another
     * thread than the one in which you created the AudioTrack instance.
     * @param listener
     * @param handler the Handler that will receive the event notification messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.332 -0400", hash_original_method = "306CFE2E840FEE5E5A96A6AC5258356A", hash_generated_method = "5E910B99202D065495CFDCBC2479BB84")
    
public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener listener,
                                                    Handler handler) {
        if (listener != null) {
            mEventHandlerDelegate = new NativeEventHandlerDelegate(this, listener, handler);
        } else {
            mEventHandlerDelegate = null;
        }
    }



     /**
     * Sets the specified left/right output volume values on the AudioTrack. Values are clamped
     * to the ({@link #getMinVolume()}, {@link #getMaxVolume()}) interval if outside this range.
     * @param leftVolume output attenuation for the left channel. A value of 0.0f is silence,
     *      a value of 1.0f is no attenuation.
     * @param rightVolume output attenuation for the right channel
     * @return error code or success, see {@link #SUCCESS},
     *    {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.339 -0400", hash_original_method = "02D9AF4D963F648EF0E9188B2D2CDBBD", hash_generated_method = "A0C0ED80CA7DACB591FD5C1D7915BFF8")
    
public int setStereoVolume(float leftVolume, float rightVolume) {
        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }

        // clamp the volumes
        if (leftVolume < getMinVolume()) {
            leftVolume = getMinVolume();
        }
        if (leftVolume > getMaxVolume()) {
            leftVolume = getMaxVolume();
        }
        if (rightVolume < getMinVolume()) {
            rightVolume = getMinVolume();
        }
        if (rightVolume > getMaxVolume()) {
            rightVolume = getMaxVolume();
        }

        native_setVolume(leftVolume, rightVolume);

        return SUCCESS;
    }


    /**
     * Similar, except set volume of all channels to same value.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.345 -0400", hash_original_method = "CBCE458C9F2A5C9E8D38BE2FE1E49F0B", hash_generated_method = "1C4750AFED887E35CDCB0BDBE8C760D3")
    
public int setVolume(float volume) {
        return setStereoVolume(volume, volume);
    }


    /**
     * Sets the playback sample rate for this track. This sets the sampling rate at which
     * the audio data will be consumed and played back
     * (as set by the sampleRateInHz parameter in the
     * {@link #AudioTrack(int, int, int, int, int, int)} constructor),
     * not the original sampling rate of the
     * content. For example, setting it to half the sample rate of the content will cause the
     * playback to last twice as long, but will also result in a pitch shift down by one octave.
     * The valid sample rate range is from 1 Hz to twice the value returned by
     * {@link #getNativeOutputSampleRate(int)}.
     * @param sampleRateInHz the sample rate expressed in Hz
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *    {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.352 -0400", hash_original_method = "A9308CA43581E22439B824F61680DB07", hash_generated_method = "45B011088D7A89D5F678A9B5F1DE4282")
    
public int setPlaybackRate(int sampleRateInHz) {
        if (mState != STATE_INITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        if (sampleRateInHz <= 0) {
            return ERROR_BAD_VALUE;
        }
        return native_set_playback_rate(sampleRateInHz);
    }


    /**
     * Sets the position of the notification marker.  At most one marker can be active.
     * @param markerInFrames marker position in wrapping frame units similar to
     * {@link #getPlaybackHeadPosition}, or zero to disable the marker.
     * To set a marker at a position which would appear as zero due to wraparound,
     * a workaround is to use a non-zero position near zero, such as -1 or 1.
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *  {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.358 -0400", hash_original_method = "3C9CF5C1F3E8756EC025DBDBB48CF3C2", hash_generated_method = "152A6FB2ACC41F7BBD147BC766BCBED2")
    
public int setNotificationMarkerPosition(int markerInFrames) {
        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        return native_set_marker_pos(markerInFrames);
    }


    /**
     * Sets the period for the periodic notification event.
     * @param periodInFrames update period expressed in frames
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.363 -0400", hash_original_method = "BC63DD10EFC3D7AD7E5CF69CF68390B4", hash_generated_method = "7D10C6A117B67A793DEB9A157453DF47")
    
public int setPositionNotificationPeriod(int periodInFrames) {
        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        return native_set_pos_update_period(periodInFrames);
    }


    /**
     * Sets the playback head position.
     * The track must be stopped or paused for the position to be changed,
     * and must use the {@link #MODE_STATIC} mode.
     * @param positionInFrames playback head position expressed in frames
     * Zero corresponds to start of buffer.
     * The position must not be greater than the buffer size in frames, or negative.
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *    {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.370 -0400", hash_original_method = "C13F6C5EAC87044AAAFC6655A17873CE", hash_generated_method = "8F8F1CAE3590D15B20CA0ABBC4AC8DBF")
    
public int setPlaybackHeadPosition(int positionInFrames) {
        if (mDataLoadMode == MODE_STREAM || mState != STATE_INITIALIZED ||
                getPlayState() == PLAYSTATE_PLAYING) {
            return ERROR_INVALID_OPERATION;
        }
        if (!(0 <= positionInFrames && positionInFrames <= mNativeBufferSizeInFrames)) {
            return ERROR_BAD_VALUE;
        }
        return native_set_position(positionInFrames);
    }

    /**
     * Sets the loop points and the loop count. The loop can be infinite.
     * Similarly to setPlaybackHeadPosition,
     * the track must be stopped or paused for the loop points to be changed,
     * and must use the {@link #MODE_STATIC} mode.
     * @param startInFrames loop start marker expressed in frames
     * Zero corresponds to start of buffer.
     * The start marker must not be greater than or equal to the buffer size in frames, or negative.
     * @param endInFrames loop end marker expressed in frames
     * The total buffer size in frames corresponds to end of buffer.
     * The end marker must not be greater than the buffer size in frames.
     * For looping, the end marker must not be less than or equal to the start marker,
     * but to disable looping
     * it is permitted for start marker, end marker, and loop count to all be 0.
     * @param loopCount the number of times the loop is looped.
     *    A value of -1 means infinite looping, and 0 disables looping.
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *    {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.376 -0400", hash_original_method = "F914930601F70C9F66BDF4830ABFB0E7", hash_generated_method = "4B5779DEABCAA8DF572C673D693D6787")
    
public int setLoopPoints(int startInFrames, int endInFrames, int loopCount) {
        if (mDataLoadMode == MODE_STREAM || mState != STATE_INITIALIZED ||
                getPlayState() == PLAYSTATE_PLAYING) {
            return ERROR_INVALID_OPERATION;
        }
        if (loopCount == 0) {
            ;   // explicitly allowed as an exception to the loop region range check
        } else if (!(0 <= startInFrames && startInFrames < mNativeBufferSizeInFrames &&
                startInFrames < endInFrames && endInFrames <= mNativeBufferSizeInFrames)) {
            return ERROR_BAD_VALUE;
        }
        return native_set_loop(startInFrames, endInFrames, loopCount);
    }

    /**
     * Sets the initialization state of the instance. This method was originally intended to be used
     * in an AudioTrack subclass constructor to set a subclass-specific post-initialization state.
     * However, subclasses of AudioTrack are no longer recommended, so this method is obsolete.
     * @param state the state of the AudioTrack instance
     * @deprecated Only accessible by subclasses, which are not recommended for AudioTrack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.381 -0400", hash_original_method = "B2257FFBD3B79161D70D00C92F5BABD5", hash_generated_method = "B41001B615BC2D5F9EBE46070674FF95")
    
@Deprecated
    protected void setState(int state) {
        mState = state;
    }


    //---------------------------------------------------------
    // Transport control methods
    //--------------------
    /**
     * Starts playing an AudioTrack.
     * If track's creation mode is {@link #MODE_STATIC}, you must have called write() prior.
     *
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.387 -0400", hash_original_method = "B742CCFAC0E2C4E046C1756AF5956D03", hash_generated_method = "1A0D8D3EB449F508D9C6E85637D3BE1A")
    
public void play()
    throws IllegalStateException {
        if (mState != STATE_INITIALIZED) {
            throw new IllegalStateException("play() called on uninitialized AudioTrack.");
        }

        synchronized(mPlayStateLock) {
            native_start();
            mPlayState = PLAYSTATE_PLAYING;
        }
    }

    /**
     * Stops playing the audio data.
     * When used on an instance created in {@link #MODE_STREAM} mode, audio will stop playing
     * after the last buffer that was written has been played. For an immediate stop, use
     * {@link #pause()}, followed by {@link #flush()} to discard audio data that hasn't been played
     * back yet.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.394 -0400", hash_original_method = "A82C2EC72F91D20478E3955EA6BD1AEF", hash_generated_method = "25200B267672D477375868DDAD3CE155")
    
public void stop()
    throws IllegalStateException {
        if (mState != STATE_INITIALIZED) {
            throw new IllegalStateException("stop() called on uninitialized AudioTrack.");
        }

        // stop playing
        synchronized(mPlayStateLock) {
            native_stop();
            mPlayState = PLAYSTATE_STOPPED;
        }
    }

    /**
     * Pauses the playback of the audio data. Data that has not been played
     * back will not be discarded. Subsequent calls to {@link #play} will play
     * this data back. See {@link #flush()} to discard this data.
     *
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.400 -0400", hash_original_method = "FF9FB81ABD276ADB56AB97A4C3F27C7D", hash_generated_method = "386F7A2B03D0E0B4899C098CB023CB58")
    
public void pause()
    throws IllegalStateException {
        if (mState != STATE_INITIALIZED) {
            throw new IllegalStateException("pause() called on uninitialized AudioTrack.");
        }
        //logd("pause()");

        // pause playback
        synchronized(mPlayStateLock) {
            native_pause();
            mPlayState = PLAYSTATE_PAUSED;
        }
    }


    //---------------------------------------------------------
    // Audio data supply
    //--------------------

    /**
     * Flushes the audio data currently queued for playback. Any data that has
     * not been played back will be discarded.  No-op if not stopped or paused,
     * or if the track's creation mode is not {@link #MODE_STREAM}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.404 -0400", hash_original_method = "FBB7E7FAEE03127E8B575DDB2F75AA18", hash_generated_method = "A06896ECB4B40441EF35010259627F84")
    
public void flush() {
        if (mState == STATE_INITIALIZED) {
            // flush the data in native layer
            native_flush();
        }

    }

    //---------------------------------------------------------
    // Interface definitions
    //--------------------
    /**
     * Interface definition for a callback to be invoked when the playback head position of
     * an AudioTrack has reached a notification marker or has increased by a certain period.
     */
    public interface OnPlaybackPositionUpdateListener  {
        /**
         * Called on the listener to notify it that the previously set marker has been reached
         * by the playback head.
         */
        void onMarkerReached(AudioTrack track);

        /**
         * Called on the listener to periodically notify it that the playback head has reached
         * a multiple of the notification period.
         */
        void onPeriodicNotification(AudioTrack track);
    }


    //---------------------------------------------------------
    // Inner classes
    //--------------------
    /**
     * Helper class to handle the forwarding of native events to the appropriate listener
     * (potentially) handled in a different thread
     */
    private class NativeEventHandlerDelegate {
        private final Handler mHandler;

        NativeEventHandlerDelegate(final AudioTrack track,
                                   final OnPlaybackPositionUpdateListener listener,
                                   Handler handler) {
            // find the looper for our new event handler
            Looper looper;
            if (handler != null) {
                looper = handler.getLooper();
            } else {
                // no given handler, use the looper the AudioTrack was created in
                looper = mInitializationLooper;
            }

            // construct the event handler with this looper
            if (looper != null) {
                // implement the event handler delegate
                mHandler = new Handler(looper) {
                    @Override
                    public void handleMessage(Message msg) {
                        if (track == null) {
                            return;
                        }
                        switch(msg.what) {
                        case NATIVE_EVENT_MARKER:
                            if (listener != null) {
                                listener.onMarkerReached(track);
                            }
                            break;
                        case NATIVE_EVENT_NEW_POS:
                            if (listener != null) {
                                listener.onPeriodicNotification(track);
                            }
                            break;
                        default:
                            loge("Unknown native event type: " + msg.what);
                            break;
                        }
                    }
                };
            } else {
                mHandler = null;
            }
        }

        Handler getHandler() {
            return mHandler;
        }
    }

    /**
     * Writes the audio data to the audio sink for playback (streaming mode),
     * or copies audio data for later playback (static buffer mode).
     * In streaming mode, will block until all data has been written to the audio sink.
     * In static buffer mode, copies the data to the buffer starting at offset 0.
     * Note that the actual playback of this data might occur after this function
     * returns. This function is thread safe with respect to {@link #stop} calls,
     * in which case all of the specified data might not be written to the audio sink.
     *
     * @param audioData the array that holds the data to play.
     * @param offsetInBytes the offset expressed in bytes in audioData where the data to play
     *    starts.
     * @param sizeInBytes the number of bytes to read in audioData after the offset.
     * @return the number of bytes that were written or {@link #ERROR_INVALID_OPERATION}
     *    if the object wasn't properly initialized, or {@link #ERROR_BAD_VALUE} if
     *    the parameters don't resolve to valid data and indexes.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.411 -0400", hash_original_method = "D257E38FA403C41669D187B497C344E5", hash_generated_method = "F11C03C85465F6A8C038C5B7BEC43A33")
    
public int write(byte[] audioData, int offsetInBytes, int sizeInBytes) {

        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }

        if ( (audioData == null) || (offsetInBytes < 0 ) || (sizeInBytes < 0)
                || (offsetInBytes + sizeInBytes < 0)    // detect integer overflow
                || (offsetInBytes + sizeInBytes > audioData.length)) {
            return ERROR_BAD_VALUE;
        }

        int ret = native_write_byte(audioData, offsetInBytes, sizeInBytes, mAudioFormat);

        if ((mDataLoadMode == MODE_STATIC)
                && (mState == STATE_NO_STATIC_DATA)
                && (ret > 0)) {
            // benign race with respect to other APIs that read mState
            mState = STATE_INITIALIZED;
        }

        return ret;
    }


    /**
     * Writes the audio data to the audio sink for playback (streaming mode),
     * or copies audio data for later playback (static buffer mode).
     * In streaming mode, will block until all data has been written to the audio sink.
     * In static buffer mode, copies the data to the buffer starting at offset 0.
     * Note that the actual playback of this data might occur after this function
     * returns. This function is thread safe with respect to {@link #stop} calls,
     * in which case all of the specified data might not be written to the audio sink.
     *
     * @param audioData the array that holds the data to play.
     * @param offsetInShorts the offset expressed in shorts in audioData where the data to play
     *     starts.
     * @param sizeInShorts the number of shorts to read in audioData after the offset.
     * @return the number of shorts that were written or {@link #ERROR_INVALID_OPERATION}
      *    if the object wasn't properly initialized, or {@link #ERROR_BAD_VALUE} if
      *    the parameters don't resolve to valid data and indexes.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.418 -0400", hash_original_method = "09F54318E1103198487E1A11C5D2A9AF", hash_generated_method = "D86C64B85B15657574053C19E423A48E")
    
public int write(short[] audioData, int offsetInShorts, int sizeInShorts) {

        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }

        if ( (audioData == null) || (offsetInShorts < 0 ) || (sizeInShorts < 0)
                || (offsetInShorts + sizeInShorts < 0)  // detect integer overflow
                || (offsetInShorts + sizeInShorts > audioData.length)) {
            return ERROR_BAD_VALUE;
        }

        int ret = native_write_short(audioData, offsetInShorts, sizeInShorts, mAudioFormat);

        if ((mDataLoadMode == MODE_STATIC)
                && (mState == STATE_NO_STATIC_DATA)
                && (ret > 0)) {
            // benign race with respect to other APIs that read mState
            mState = STATE_INITIALIZED;
        }

        return ret;
    }


    /**
     * Notifies the native resource to reuse the audio data already loaded in the native
     * layer, that is to rewind to start of buffer.
     * The track's creation mode must be {@link #MODE_STATIC}.
     * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
     *  {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.423 -0400", hash_original_method = "7527644C4328E12F7FF0871063FF601D", hash_generated_method = "9D3DE521E42EB9AEE6671B3C47295A98")
    
public int reloadStaticData() {
        if (mDataLoadMode == MODE_STREAM || mState != STATE_INITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        return native_reload_static();
    }

    //--------------------------------------------------------------------------
    // Audio effects management
    //--------------------

    /**
     * Attaches an auxiliary effect to the audio track. A typical auxiliary
     * effect is a reverberation effect which can be applied on any sound source
     * that directs a certain amount of its energy to this effect. This amount
     * is defined by setAuxEffectSendLevel().
     * {@see #setAuxEffectSendLevel(float)}.
     * <p>After creating an auxiliary effect (e.g.
     * {@link android.media.audiofx.EnvironmentalReverb}), retrieve its ID with
     * {@link android.media.audiofx.AudioEffect#getId()} and use it when calling
     * this method to attach the audio track to the effect.
     * <p>To detach the effect from the audio track, call this method with a
     * null effect id.
     *
     * @param effectId system wide unique id of the effect to attach
     * @return error code or success, see {@link #SUCCESS},
     *    {@link #ERROR_INVALID_OPERATION}, {@link #ERROR_BAD_VALUE}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.428 -0400", hash_original_method = "637012C780DCFFEF853351D24C855A03", hash_generated_method = "53FAF9E3D89EC480F4899BC8C37372C5")
    
public int attachAuxEffect(int effectId) {
        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        return native_attachAuxEffect(effectId);
    }

    /**
     * Sets the send level of the audio track to the attached auxiliary effect
     * {@link #attachAuxEffect(int)}.  The level value range is 0.0f to 1.0f.
     * Values are clamped to the (0.0f, 1.0f) interval if outside this range.
     * <p>By default the send level is 0.0f, so even if an effect is attached to the player
     * this method must be called for the effect to be applied.
     * <p>Note that the passed level value is a raw scalar. UI controls should be scaled
     * logarithmically: the gain applied by audio framework ranges from -72dB to 0dB,
     * so an appropriate conversion from linear UI input x to level is:
     * x == 0 -&gt; level = 0
     * 0 &lt; x &lt;= R -&gt; level = 10^(72*(x-R)/20/R)
     *
     * @param level send level scalar
     * @return error code or success, see {@link #SUCCESS},
     *    {@link #ERROR_INVALID_OPERATION}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.434 -0400", hash_original_method = "0B475B040D722198A793062F7AF23366", hash_generated_method = "9C950789A9AC6A4566B6C6DDCEAE8E4A")
    
public int setAuxEffectSendLevel(float level) {
        if (mState == STATE_UNINITIALIZED) {
            return ERROR_INVALID_OPERATION;
        }
        // clamp the level
        if (level < getMinVolume()) {
            level = getMinVolume();
        }
        if (level > getMaxVolume()) {
            level = getMaxVolume();
        }
        native_setAuxEffectSendLevel(level);
        return SUCCESS;
    }


    //---------------------------------------------------------
    // Native methods called from the Java side
    //--------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.495 -0400", hash_original_method = "26C126F1BBE1159A6C6D90A4B23E34E1", hash_generated_method = "4D041F80E4B6805BF29A81AE25B78FB1")
        
        private final int native_setup(Object audiotrack_this,
                    int streamType, int sampleRate, int nbChannels, int audioFormat,
                    int buffSizeInBytes, int mode, int[] sessionId){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += audiotrack_this.getTaintInt();
        	taintDouble += streamType;
        	taintDouble += sampleRate;
        	taintDouble += nbChannels;
        	taintDouble += audioFormat;
        	taintDouble += buffSizeInBytes;
        	taintDouble += mode;
        	taintDouble += sessionId[0];
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.502 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
        
        private final void native_finalize(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.508 -0400", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
        
        private final void native_release(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.514 -0400", hash_original_method = "FE287DC093068CDFD422E77973344726", hash_generated_method = "2A33473761D740B1148AF505C51C47C3")
        
        private final void native_start(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.521 -0400", hash_original_method = "7AE7BD386DE7186B97622AE5A757DF71", hash_generated_method = "2C001E290E4F435149A59F53766E71EF")
        
        private final void native_stop(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.528 -0400", hash_original_method = "A98E8C6ADEAC42F42E6DC838DC0BDA10", hash_generated_method = "D3C20D8D321A573B28219A456EEEC30D")
        
        private final void native_pause(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.535 -0400", hash_original_method = "58FCC57770A746317BCD678DF765D11A", hash_generated_method = "71D107C5B6DDE1ED70F809DC7A0F9803")
        
        private final void native_flush(){
        	//Formerly a native method
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.543 -0400", hash_original_method = "7772F16F949869F701337FF74EC58123", hash_generated_method = "788CA5D2610BB5AD6380EB5F845898E5")
        
        private final int native_write_byte(byte[] audioData,
                                                       int offsetInBytes, int sizeInBytes, int format){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += audioData[0];
        	taintDouble += offsetInBytes;
        	taintDouble += sizeInBytes;
        	taintDouble += format;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.552 -0400", hash_original_method = "F53EDB047EE09ADA3FC90CE1417EF2AF", hash_generated_method = "E50BAB81515E2AD3569D0A42239DA3F5")
        
        private final int native_write_short(short[] audioData,
                                                        int offsetInShorts, int sizeInShorts, int format){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += audioData[0];
        	taintDouble += offsetInShorts;
        	taintDouble += sizeInShorts;
        	taintDouble += format;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.557 -0400", hash_original_method = "7E7F5A8C796FD35DDE72AFEEA9729295", hash_generated_method = "9B4F0E353F0E2FE2498AFF7DF69676C5")
        
        private final int native_reload_static(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.564 -0400", hash_original_method = "14D5874126982FBA8C0211E602E8913B", hash_generated_method = "3A9C06B9B14E2015AF7AA07E1B2DF35E")
        
        private final int native_get_native_frame_count(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.571 -0400", hash_original_method = "FBF09C03E89480BC4A3E4322CD0C7BE9", hash_generated_method = "0FFED305828D11E3C47F3A008106FB29")
        
        private final void native_setVolume(float leftVolume, float rightVolume){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += leftVolume;
        	taintDouble += rightVolume;
        	addTaint(taintDouble);
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.578 -0400", hash_original_method = "DE95EEDA726FD19B9E994AB625954674", hash_generated_method = "DF17576D5D22105C6026600FDE9E7A20")
        
        private final int native_set_playback_rate(int sampleRateInHz){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += sampleRateInHz;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.584 -0400", hash_original_method = "44D97E28BF4AAB9CF6445428CB0B66EF", hash_generated_method = "9D8CB53872743BE7AE58FCD6DCE80994")
        
        private final int native_get_playback_rate(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.591 -0400", hash_original_method = "F88EF7916D562385F7AC5D5313AEC7D2", hash_generated_method = "5CFFC29010694905C1A82AD8368F580B")
        
        private final int native_set_marker_pos(int marker){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += marker;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.598 -0400", hash_original_method = "079AA872B3C965E7290B33BFA53DAFCE", hash_generated_method = "E62C89DDDDFD1D965609C50EC797E66D")
        
        private final int native_get_marker_pos(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.604 -0400", hash_original_method = "076BD1361A73CF54CF958B5360137DB5", hash_generated_method = "67E2E6141AC5B03D4EB9F43EFF48C971")
        
        private final int native_set_pos_update_period(int updatePeriod){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += updatePeriod;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.611 -0400", hash_original_method = "E830C73D77E18E89E4E2DC076D5B24C6", hash_generated_method = "99EDD3D8C0F260E0AD950158084A6696")
        
        private final int native_get_pos_update_period(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.618 -0400", hash_original_method = "830248836BF70797A7CB3FA2D895D11D", hash_generated_method = "07AF689FFAF4E1773083C1360B142467")
        
        private final int native_set_position(int position){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += position;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.624 -0400", hash_original_method = "F315E673A054BA0C2AB1E691DA75E1BE", hash_generated_method = "158E8F4EA66F316B1EFD205C5B55CE90")
        
        private final int native_get_position(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.629 -0400", hash_original_method = "7283545FA55AD45A9EDF0B64789F2A02", hash_generated_method = "61D93B834458A869DE3A71680A577917")
        
        private final int native_get_latency(){
        	//Formerly a native method
        	double taintDouble = 0;
        
        	return (int)taintDouble;
        }


    // longArray must be a non-null array of length >= 2
    // [0] is assigned the frame position
    // [1] is assigned the time in CLOCK_MONOTONIC nanoseconds
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.636 -0400", hash_original_method = "84DC63F384F7502AD808354C256D4B8B", hash_generated_method = "192F778F7AB19AEF7F9CA4887F1BBF98")
        
        private final int native_get_timestamp(long[] longArray){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += longArray[0];
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.645 -0400", hash_original_method = "590B00378CA8E2C052FAB5759AEB2D13", hash_generated_method = "08B898D97765B8AF6511A75392498A19")
        
        private final int native_set_loop(int start, int end, int loopCount){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += start;
        	taintDouble += end;
        	taintDouble += loopCount;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.671 -0400", hash_original_method = "E21157C395E2D7E2071F7E02030D3ED5", hash_generated_method = "8D8B604B131D7E4AFEFC82602D1868D0")
        
        private final int native_attachAuxEffect(int effectId){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += effectId;
        	addTaint(taintDouble);
        
        	return (int)taintDouble;
        }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-18 14:37:49.678 -0400", hash_original_method = "56BB7BE071045D28DF54F7920DF53331", hash_generated_method = "A4F3CE372A83350B9C09B580EA807296")
        
        private final void native_setAuxEffectSendLevel(float level){
        	//Formerly a native method
        	double taintDouble = 0;
        	taintDouble += level;
        	addTaint(taintDouble);
        }


}
