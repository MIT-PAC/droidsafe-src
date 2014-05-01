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
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.util.Log;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.StringTokenizer;

/**
 * An Equalizer is used to alter the frequency response of a particular music source or of the main
 * output mix.
 * <p>An application creates an Equalizer object to instantiate and control an Equalizer engine
 * in the audio framework. The application can either simply use predefined presets or have a more
 * precise control of the gain in each frequency band controlled by the equalizer.
 * <p>The methods, parameter types and units exposed by the Equalizer implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLEqualizerItf interface. Please refer to this specification for more details.
 * <p>To attach the Equalizer to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the Equalizer.
 * <p>NOTE: attaching an Equalizer to the global audio output mix by use of session 0 is deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling audio
 * effects.
 */

public class Equalizer extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.692 -0400", hash_original_field = "2289CEFF9E5E6AD3CB7BD0405E45EFD8", hash_generated_field = "D047B63ACFB15B2A42C5A7913527AF3D")

    private final static String TAG = "Equalizer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.694 -0400", hash_original_field = "45533A2D78E7CB805002090A0BDD800C", hash_generated_field = "3C561BE627C03D9EABA8C5306ED81930")

    // frameworks/base/include/media/EffectEqualizerApi.h
    /**
     * Number of bands. Parameter ID for OnParameterChangeListener
     */
    public static final int PARAM_NUM_BANDS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.696 -0400", hash_original_field = "2606A1192F558CD5C77B2D8387F95D3E", hash_generated_field = "194A1DD40DB27BF2E2E3CB16403ED357")

    public static final int PARAM_LEVEL_RANGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.698 -0400", hash_original_field = "1C4778910389E965B3822E780C3D1838", hash_generated_field = "640AC989F07E7911B70325DEE5C0E91F")

    public static final int PARAM_BAND_LEVEL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.700 -0400", hash_original_field = "7737FC72FE03B8D87C4A89FDE5FC5A5A", hash_generated_field = "00E34BFFB14F70477F515DA88FB60502")

    public static final int PARAM_CENTER_FREQ = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.702 -0400", hash_original_field = "DF331AA273BAB0A439B9C849FD0D1DF8", hash_generated_field = "EC05EE158963CDF8CAE607E2FE633983")

    public static final int PARAM_BAND_FREQ_RANGE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.704 -0400", hash_original_field = "2F6359B91140400E5CD478E131F89CE2", hash_generated_field = "B274F2B19A12591D3993CA0314B76D1F")

    public static final int PARAM_GET_BAND = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.706 -0400", hash_original_field = "446FD994B8567816E16E73E01BA33D75", hash_generated_field = "F61522D5782F7D647AF2631A9B2826E7")

    public static final int PARAM_CURRENT_PRESET = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.707 -0400", hash_original_field = "402363D239B3668FCA4029457F242FCB", hash_generated_field = "A468AE47CFC9DAAD8A7E7D06FBD74EC8")

    public static final int PARAM_GET_NUM_OF_PRESETS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.710 -0400", hash_original_field = "0B4C7A2B1D25A977EC188CA0930F51A3", hash_generated_field = "E4E3D3852E7E348AFAF436AE64C00B61")

    public static final int PARAM_GET_PRESET_NAME = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.711 -0400", hash_original_field = "BE73E45810762F05F07E792E8B0D158A", hash_generated_field = "2F6E9CC643B4F836B9FEF401E82EFEF1")

    private static final int PARAM_PROPERTIES = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.714 -0400", hash_original_field = "E0AF10C7D202388D9F498949E8283FEC", hash_generated_field = "4115676F4EEB0CC4C2568F2E0376EEB4")

    public static final int PARAM_STRING_SIZE_MAX = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.715 -0400", hash_original_field = "184999F1D224F7F4144485746425FF92", hash_generated_field = "C5DAAE19153EFB29EFD12985356909B5")

    private short mNumBands = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.717 -0400", hash_original_field = "DF3C48565456B7ECAAC937C07557DA97", hash_generated_field = "B46B3874BEC813F7C58EF4F8307A0186")

    private int mNumPresets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.718 -0400", hash_original_field = "CCBD305B8ABDC7C9792CE4C716E9E384", hash_generated_field = "5A285D852CDEB80A18BF2FE2A88B8CF5")

    private String[] mPresetNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.720 -0400", hash_original_field = "2E2B05E7EF469AE4E8BB908F4A865479", hash_generated_field = "95416CDBA48505554B696D0275F8F405")

    private OnParameterChangeListener mParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.722 -0400", hash_original_field = "CD6325FB9FC281254824DD2841A3250F", hash_generated_field = "ADD9DF28553977A37F99E63E4FBB5FF6")

    private BaseParameterListener mBaseParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.723 -0400", hash_original_field = "E110C4655C125DC0BD0C3B91841408F1", hash_generated_field = "1004B26395DEA9DB0250344109FCA5F2")

    private final Object mParamListenerLock = new Object();

    /**
     * Class constructor.
     * @param priority the priority level requested by the application for controlling the Equalizer
     * engine. As the same engine can be shared by several applications, this parameter indicates
     * how much the requesting application needs control of effect parameters. The normal priority
     * is 0, above normal is a positive number, below normal a negative number.
     * @param audioSession  system wide unique audio session identifier. The Equalizer will be
     * attached to the MediaPlayer or AudioTrack in the same audio session.
     *
     * @throws java.lang.IllegalStateException
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.725 -0400", hash_original_method = "1A45871C0F9467BE24CAC072F2612DB6", hash_generated_method = "3CAC7C0E066216D20B1B78B3EB80DEF8")
    
public Equalizer(int priority, int audioSession)
    throws IllegalStateException, IllegalArgumentException,
           UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_EQUALIZER, EFFECT_TYPE_NULL, priority, audioSession);

        if (audioSession == 0) {
            Log.w(TAG, "WARNING: attaching an Equalizer to global output mix is deprecated!");
        }

        getNumberOfBands();

        mNumPresets = (int)getNumberOfPresets();

        if (mNumPresets != 0) {
            mPresetNames = new String[mNumPresets];
            byte[] value = new byte[PARAM_STRING_SIZE_MAX];
            int[] param = new int[2];
            param[0] = PARAM_GET_PRESET_NAME;
            for (int i = 0; i < mNumPresets; i++) {
                param[1] = i;
                checkStatus(getParameter(param, value));
                int length = 0;
                while (value[length] != 0) length++;
                try {
                    mPresetNames[i] = new String(value, 0, length, "ISO-8859-1");
                } catch (java.io.UnsupportedEncodingException e) {
                    Log.e(TAG, "preset name decode error");
                }
            }
        }
    }

    /**
     * Gets the number of frequency bands supported by the Equalizer engine.
     * @return the number of bands
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.727 -0400", hash_original_method = "7F77156828076E455CCE6902D905160C", hash_generated_method = "5FC5A05727081391269F533F148815F5")
    
public short getNumberOfBands()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (mNumBands != 0) {
            return mNumBands;
        }
        int[] param = new int[1];
        param[0] = PARAM_NUM_BANDS;
        short[] result = new short[1];
        checkStatus(getParameter(param, result));
        mNumBands = result[0];
        return mNumBands;
    }

    /**
     * Gets the level range for use by {@link #setBandLevel(short,short)}. The level is expressed in
     * milliBel.
     * @return the band level range in an array of short integers. The first element is the lower
     * limit of the range, the second element the upper limit.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.729 -0400", hash_original_method = "DD9441325DACA667B1D198EA73C9F6D9", hash_generated_method = "18CFEDE4D93EECC4F7056F9D2216AB02")
    
public short[] getBandLevelRange()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] result = new short[2];
        checkStatus(getParameter(PARAM_LEVEL_RANGE, result));
        return result;
    }

    /**
     * Sets the given equalizer band to the given gain value.
     * @param band frequency band that will have the new gain. The numbering of the bands starts
     * from 0 and ends at (number of bands - 1).
     * @param level new gain in millibels that will be set to the given band. getBandLevelRange()
     * will define the maximum and minimum values.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     * @see #getNumberOfBands()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.731 -0400", hash_original_method = "79CE080CE812535CE36C1023E4F7F504", hash_generated_method = "0D82E68547C6A384C90DA989CCE723F9")
    
public void setBandLevel(short band, short level)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] param = new int[2];
        short[] value = new short[1];

        param[0] = PARAM_BAND_LEVEL;
        param[1] = (int)band;
        value[0] = level;
        checkStatus(setParameter(param, value));
    }

    /**
     * Gets the gain set for the given equalizer band.
     * @param band frequency band whose gain is requested. The numbering of the bands starts
     * from 0 and ends at (number of bands - 1).
     * @return the gain in millibels of the given band.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.733 -0400", hash_original_method = "D914D5BB4730C8614696B05559ECB377", hash_generated_method = "2632E28295DB4CCAB5D57E9C7975FFEE")
    
public short getBandLevel(short band)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] param = new int[2];
        short[] result = new short[1];

        param[0] = PARAM_BAND_LEVEL;
        param[1] = (int)band;
        checkStatus(getParameter(param, result));

        return result[0];
    }

    /**
     * Gets the center frequency of the given band.
     * @param band frequency band whose center frequency is requested. The numbering of the bands
     * starts from 0 and ends at (number of bands - 1).
     * @return the center frequency in milliHertz
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.735 -0400", hash_original_method = "4AEE249B445F86C908512513521CBDA7", hash_generated_method = "74F0B5701B5E8B4137C359C91A3F7A1B")
    
public int getCenterFreq(short band)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] param = new int[2];
        int[] result = new int[1];

        param[0] = PARAM_CENTER_FREQ;
        param[1] = (int)band;
        checkStatus(getParameter(param, result));

        return result[0];
    }

    /**
     * Gets the frequency range of the given frequency band.
     * @param band frequency band whose frequency range is requested. The numbering of the bands
     * starts from 0 and ends at (number of bands - 1).
     * @return the frequency range in millHertz in an array of integers. The first element is the
     * lower limit of the range, the second element the upper limit.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.736 -0400", hash_original_method = "0A3EC51D176EF38F1F71727F17815903", hash_generated_method = "A23BD50779A426A136EE65FD99A89FD1")
    
public int[] getBandFreqRange(short band)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] param = new int[2];
        int[] result = new int[2];
        param[0] = PARAM_BAND_FREQ_RANGE;
        param[1] = (int)band;
        checkStatus(getParameter(param, result));

        return result;
    }

    /**
     * Gets the band that has the most effect on the given frequency.
     * @param frequency frequency in milliHertz which is to be equalized via the returned band.
     * @return the frequency band that has most effect on the given frequency.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.738 -0400", hash_original_method = "F04FE379C3D1DF5CD2E0B89174CDB672", hash_generated_method = "D959B491E25D91E7CB3437596D7B300C")
    
public short getBand(int frequency)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        int[] param = new int[2];
        short[] result = new short[1];

        param[0] = PARAM_GET_BAND;
        param[1] = frequency;
        checkStatus(getParameter(param, result));

        return result[0];
    }

    /**
     * Gets current preset.
     * @return the preset that is set at the moment.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.740 -0400", hash_original_method = "C58ADCFC3466426928293617E461D1AB", hash_generated_method = "604F3C80D4FA69CB3FA7E0C31AE6945C")
    
public short getCurrentPreset()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] result = new short[1];
        checkStatus(getParameter(PARAM_CURRENT_PRESET, result));
        return result[0];
    }

    /**
     * Sets the equalizer according to the given preset.
     * @param preset new preset that will be taken into use. The valid range is [0,
     * number of presets-1].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     * @see #getNumberOfPresets()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.742 -0400", hash_original_method = "E997A2317157379803AA519FC5C11B66", hash_generated_method = "99626EA882D8DCBA81DC1A90313DB7FE")
    
public void usePreset(short preset)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_CURRENT_PRESET, preset));
    }

    /**
     * Gets the total number of presets the equalizer supports. The presets will have indices
     * [0, number of presets-1].
     * @return the number of presets the equalizer supports.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.743 -0400", hash_original_method = "2DDFC398389001AB6EC367575AE09929", hash_generated_method = "56B5DDFF29C1541D4685AABBA7853521")
    
public short getNumberOfPresets()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] result = new short[1];
        checkStatus(getParameter(PARAM_GET_NUM_OF_PRESETS, result));
        return result[0];
    }

    /**
     * Gets the preset name based on the index.
     * @param preset index of the preset. The valid range is [0, number of presets-1].
     * @return a string containing the name of the given preset.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.745 -0400", hash_original_method = "8240369BD4099628403C8D67F72C32FD", hash_generated_method = "6480E626D7FA38C5C53EFF0511124EFC")
    
public String getPresetName(short preset)
    {
        if (preset >= 0 && preset < mNumPresets) {
            return mPresetNames[preset];
        } else {
            return "";
        }
    }

    /**
     * The OnParameterChangeListener interface defines a method called by the Equalizer when a
     * parameter value has changed.
     */
    public interface OnParameterChangeListener  {
        /**
         * Method called when a parameter value has changed. The method is called only if the
         * parameter was changed by another application having the control of the same
         * Equalizer engine.
         * @param effect the Equalizer on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param1 ID of the modified parameter. See {@link #PARAM_BAND_LEVEL} ...
         * @param param2 additional parameter qualifier (e.g the band for band level parameter).
         * @param value the new parameter value.
         */
        void onParameterChange(Equalizer effect, int status, int param1, int param2, int value);
    }

    /**
     * Listener used internally to receive unformatted parameter change events from AudioEffect
     * super class.
     */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.749 -0400", hash_original_method = "9FA8987EB3F89D504F2D03489A50FB50", hash_generated_method = "66FD07CD2ED00DBCFA69A2FD6240DAA5")
        
private BaseParameterListener() {

        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.751 -0400", hash_original_method = "191A7B4EE1DA852A4CC522325B8CB082", hash_generated_method = "9416BF0DB71E7E6258CE9D4234AC34B0")
        
public void onParameterChange(AudioEffect effect, int status, byte[] param, byte[] value) {
            OnParameterChangeListener l = null;

            synchronized (mParamListenerLock) {
                if (mParamListener != null) {
                    l = mParamListener;
                }
            }
            if (l != null) {
                int p1 = -1;
                int p2 = -1;
                int v = -1;

                if (param.length >= 4) {
                    p1 = byteArrayToInt(param, 0);
                    if (param.length >= 8) {
                        p2 = byteArrayToInt(param, 4);
                    }
                }
                if (value.length == 2) {
                    v = (int)byteArrayToShort(value, 0);;
                } else if (value.length == 4) {
                    v = byteArrayToInt(value, 0);
                }

                if (p1 != -1 && v != -1) {
                    l.onParameterChange(Equalizer.this, status, p1, p2, v);
                }
            }
        }
    }

    /**
     * Registers an OnParameterChangeListener interface.
     * @param listener OnParameterChangeListener interface registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.754 -0400", hash_original_method = "0055015932E0C4AC564122B5477C52E3", hash_generated_method = "E1FA55A6EC170589DAD58B149D391DB4")
    
public void setParameterListener(OnParameterChangeListener listener) {
        synchronized (mParamListenerLock) {
            if (mParamListener == null) {
                mParamListener = listener;
                mBaseParamListener = new BaseParameterListener();
                super.setParameterListener(mBaseParamListener);
            }
        }
    }

    /**
     * The Settings class regroups all equalizer parameters. It is used in
     * conjuntion with getProperties() and setProperties() methods to backup and restore
     * all parameters in a single call.
     */
    public static class Settings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.757 -0400", hash_original_field = "62269381447DC3FA3270F5AFB0D334F1", hash_generated_field = "3E1C125F78DAFE1F9C1B9670B547B255")

        public short curPreset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.758 -0400", hash_original_field = "057B8C49D07A3137D6FC2E6047B70515", hash_generated_field = "4EC76522FB82490CB3F8E17C89ED5EDA")

        public short numBands = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.760 -0400", hash_original_field = "84ED520AE45A3763717648EB53882422", hash_generated_field = "0735FFC5ACB0AD9B6949E7E3C4EC031F")

        public short[] bandLevels = null;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.761 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        
public Settings() {
        }

        /**
         * Settings class constructor from a key=value; pairs formatted string. The string is
         * typically returned by Settings.toString() method.
         * @throws IllegalArgumentException if the string is not correctly formatted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.764 -0400", hash_original_method = "133ACF572A651287A08248DD9AE81925", hash_generated_method = "68D37CE75CAD62DAF9B8A1BD67527A26")
        
public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int tokens = st.countTokens();
            if (st.countTokens() < 5) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals("Equalizer")) {
                throw new IllegalArgumentException(
                        "invalid settings for Equalizer: " + key);
            }
            try {
                key = st.nextToken();
                if (!key.equals("curPreset")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                curPreset = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("numBands")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                numBands = Short.parseShort(st.nextToken());
                if (st.countTokens() != numBands*2) {
                    throw new IllegalArgumentException("settings: " + settings);
                }
                bandLevels = new short[numBands];
                for (int i = 0; i < numBands; i++) {
                    key = st.nextToken();
                    if (!key.equals("band"+(i+1)+"Level")) {
                        throw new IllegalArgumentException("invalid key name: " + key);
                    }
                    bandLevels[i] = Short.parseShort(st.nextToken());
                }
             } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.766 -0400", hash_original_method = "9A2C469484B5DCD84D744335DDEF8045", hash_generated_method = "A6288F825712C7DE937CFF2D3DB060B0")
        
@Override
        public String toString() {

            String str = new String (
                    "Equalizer"+
                    ";curPreset="+Short.toString(curPreset)+
                    ";numBands="+Short.toString(numBands)
                    );
            for (int i = 0; i < numBands; i++) {
                str = str.concat(";band"+(i+1)+"Level="+Short.toString(bandLevels[i]));
            }
            return str;
        }
    };

    /**
     * Gets the equalizer properties. This method is useful when a snapshot of current
     * equalizer settings must be saved by the application.
     * @return an Equalizer.Settings object containing all current parameters values
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.769 -0400", hash_original_method = "7D3FDCB608844108B6666E5031BCB36A", hash_generated_method = "6CE0B5B1446B08003939AB3B1825D05B")
    
public Equalizer.Settings getProperties()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4 + mNumBands * 2];
        checkStatus(getParameter(PARAM_PROPERTIES, param));
        Settings settings = new Settings();
        settings.curPreset = byteArrayToShort(param, 0);
        settings.numBands = byteArrayToShort(param, 2);
        settings.bandLevels = new short[mNumBands];
        for (int i = 0; i < mNumBands; i++) {
            settings.bandLevels[i] = byteArrayToShort(param, 4 + 2*i);
        }
        return settings;
    }

    /**
     * Sets the equalizer properties. This method is useful when equalizer settings have to
     * be applied from a previous backup.
     * @param settings an Equalizer.Settings object containing the properties to apply
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.771 -0400", hash_original_method = "EA87EF4DCCA62C65D4F416F976CF6FDD", hash_generated_method = "B40ACCD1FBD31495A6910F7E3DDB0ED4")
    
public void setProperties(Equalizer.Settings settings)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (settings.numBands != settings.bandLevels.length ||
            settings.numBands != mNumBands) {
            throw new IllegalArgumentException("settings invalid band count: " +settings.numBands);
        }

        byte[] param = concatArrays(shortToByteArray(settings.curPreset),
                                    shortToByteArray(mNumBands));
        for (int i = 0; i < mNumBands; i++) {
            param = concatArrays(param,
                                 shortToByteArray(settings.bandLevels[i]));
        }
        checkStatus(setParameter(PARAM_PROPERTIES, param));
    }
}
