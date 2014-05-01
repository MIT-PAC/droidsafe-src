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
import java.util.StringTokenizer;

/**
 * A sound generated within a room travels in many directions. The listener first hears the
 * direct sound from the source itself. Later, he or she hears discrete echoes caused by sound
 * bouncing off nearby walls, the ceiling and the floor. As sound waves arrive after
 * undergoing more and more reflections, individual reflections become indistinguishable and
 * the listener hears continuous reverberation that decays over time.
 * Reverb is vital for modeling a listener's environment. It can be used in music applications
 * to simulate music being played back in various environments, or in games to immerse the
 * listener within the game's environment.
 * The PresetReverb class allows an application to configure the global reverb using a reverb preset.
 * This is primarily used for adding some reverb in a music playback context. Applications
 * requiring control over a more advanced environmental reverb are advised to use the
 * {@link android.media.audiofx.EnvironmentalReverb} class.
 * <p>An application creates a PresetReverb object to instantiate and control a reverb engine in the
 * audio framework.
 * <p>The methods, parameter types and units exposed by the PresetReverb implementation are
 * directly mapping those defined by the OpenSL ES 1.0.1 Specification
 * (http://www.khronos.org/opensles/) for the SLPresetReverbItf interface.
 * Please refer to this specification for more details.
 * <p>The PresetReverb is an output mix auxiliary effect and should be created on
 * Audio session 0. In order for a MediaPlayer or AudioTrack to be fed into this effect,
 * they must be explicitely attached to it and a send level must be specified. Use the effect ID
 * returned by getId() method to designate this particular effect when attaching it to the
 * MediaPlayer or AudioTrack.
 * <p>Creating a reverb on the output mix (audio session 0) requires permission
 * {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling
 * audio effects.
 */

public class PresetReverb extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.955 -0400", hash_original_field = "CFB548D2597D5DE56161CCA91329E2D9", hash_generated_field = "BD6E75A2A8F29EED4F602E6C9E9093EF")

    private final static String TAG = "PresetReverb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.956 -0400", hash_original_field = "0C848B968B354528CE96237C3035BA2F", hash_generated_field = "84FEB2714B24EE99C52635D7C26DE93F")

    // frameworks/base/include/media/EffectPresetReverbApi.h

    /**
     * Preset. Parameter ID for
     * {@link android.media.audiofx.PresetReverb.OnParameterChangeListener}
     */
    public static final int PARAM_PRESET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.958 -0400", hash_original_field = "BB6C11F0BFE0F363C2A05E60983F9DC2", hash_generated_field = "EBA55D69D76B66AF0BFD1BECA947C5F6")

    public static final short PRESET_NONE        = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.960 -0400", hash_original_field = "6EA0431028BF64D04FFEB6D2443A3B90", hash_generated_field = "9DA2A2BBFE8FA2BBD8D3D32C73C84175")

    public static final short PRESET_SMALLROOM   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.961 -0400", hash_original_field = "BD1AAF3A69C7C45BE97E83CE550C1AD6", hash_generated_field = "64D3EF7C89510337FED7AF30A8C4DB2E")

    public static final short PRESET_MEDIUMROOM  = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.963 -0400", hash_original_field = "50DA1064E153C53CBA1D38099535B15E", hash_generated_field = "6B81F87C834427B8C488540064D17AA4")

    public static final short PRESET_LARGEROOM   = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.965 -0400", hash_original_field = "30F015E217217173A2F3B178B0385AD1", hash_generated_field = "71227BA03D405848A3F6B3C8C36301EF")

    public static final short PRESET_MEDIUMHALL  = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.967 -0400", hash_original_field = "C53E55F600DDFE9C8D200A763F97A8C0", hash_generated_field = "A2CB18015BC50194400D8F9FF568C53E")

    public static final short PRESET_LARGEHALL   = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.969 -0400", hash_original_field = "381E39B89EE226723354682CAAF1C06D", hash_generated_field = "BA729F5B6081BDA4B69D120C4E4452FF")

    public static final short PRESET_PLATE       = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.970 -0400", hash_original_field = "2E2B05E7EF469AE4E8BB908F4A865479", hash_generated_field = "95416CDBA48505554B696D0275F8F405")

    private OnParameterChangeListener mParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.972 -0400", hash_original_field = "CD6325FB9FC281254824DD2841A3250F", hash_generated_field = "ADD9DF28553977A37F99E63E4FBB5FF6")

    private BaseParameterListener mBaseParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.973 -0400", hash_original_field = "E110C4655C125DC0BD0C3B91841408F1", hash_generated_field = "1004B26395DEA9DB0250344109FCA5F2")

    private final Object mParamListenerLock = new Object();

    /**
     * Class constructor.
     * @param priority the priority level requested by the application for controlling the
     * PresetReverb engine. As the same engine can be shared by several applications, this
     * parameter indicates how much the requesting application needs control of effect parameters.
     * The normal priority is 0, above normal is a positive number, below normal a negative number.
     * @param audioSession  system wide unique audio session identifier. If audioSession
     *  is not 0, the PresetReverb will be attached to the MediaPlayer or AudioTrack in the
     *  same audio session. Otherwise, the PresetReverb will apply to the output mix.
     *  As the PresetReverb is an auxiliary effect it is recommended to instantiate it on
     *  audio session 0 and to attach it to the MediaPLayer auxiliary output.
     *
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.975 -0400", hash_original_method = "DA04CC991929EE8EE3FC4D6F0CEDB9D5", hash_generated_method = "135F1786AC42D691F727A3426372D7CA")
    
public PresetReverb(int priority, int audioSession)
    throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_PRESET_REVERB, EFFECT_TYPE_NULL, priority, audioSession);
    }

    /**
     *  Enables a preset on the reverb.
     *  <p>The reverb PRESET_NONE disables any reverb from the current output but does not free the
     *  resources associated with the reverb. For an application to signal to the implementation
     *  to free the resources, it must call the release() method.
     * @param preset this must be one of the the preset constants defined in this class.
     * e.g. {@link #PRESET_SMALLROOM}
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.976 -0400", hash_original_method = "B0E35A220F5E81F7CE5954696F769829", hash_generated_method = "E19B696E1A12D4177BFC49056164DAC6")
    
public void setPreset(short preset)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_PRESET, preset));
    }

    /**
     * Gets current reverb preset.
     * @return the preset that is set at the moment.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.978 -0400", hash_original_method = "91C7CC79334C6B90B0DC6245813B3D93", hash_generated_method = "EB90BB7FFFB2F73E9A265B287FCDBF22")
    
public short getPreset()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_PRESET, value));
        return value[0];
    }

    /**
     * The OnParameterChangeListener interface defines a method called by the PresetReverb
     * when a parameter value has changed.
     */
    public interface OnParameterChangeListener  {
        /**
         * Method called when a parameter value has changed. The method is called only if the
         * parameter was changed by another application having the control of the same
         * PresetReverb engine.
         * @param effect the PresetReverb on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param ID of the modified parameter. See {@link #PARAM_PRESET} ...
         * @param value the new parameter value.
         */
        void onParameterChange(PresetReverb effect, int status, int param, short value);
    }

    /**
     * Listener used internally to receive unformatted parameter change events from AudioEffect
     * super class.
     */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.982 -0400", hash_original_method = "9FA8987EB3F89D504F2D03489A50FB50", hash_generated_method = "66FD07CD2ED00DBCFA69A2FD6240DAA5")
        
private BaseParameterListener() {

        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.983 -0400", hash_original_method = "0B2C835EE7DA6C6A879C8EC90D9AD768", hash_generated_method = "076362680D1D8FB84A6A4B61CA5CA4BC")
        
public void onParameterChange(AudioEffect effect, int status, byte[] param, byte[] value) {
            OnParameterChangeListener l = null;

            synchronized (mParamListenerLock) {
                if (mParamListener != null) {
                    l = mParamListener;
                }
            }
            if (l != null) {
                int p = -1;
                short v = -1;

                if (param.length == 4) {
                    p = byteArrayToInt(param, 0);
                }
                if (value.length == 2) {
                    v = byteArrayToShort(value, 0);
                }
                if (p != -1 && v != -1) {
                    l.onParameterChange(PresetReverb.this, status, p, v);
                }
            }
        }
    }

    /**
     * Registers an OnParameterChangeListener interface.
     * @param listener OnParameterChangeListener interface registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.986 -0400", hash_original_method = "0055015932E0C4AC564122B5477C52E3", hash_generated_method = "E1FA55A6EC170589DAD58B149D391DB4")
    
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
     * The Settings class regroups all preset reverb parameters. It is used in
     * conjuntion with getProperties() and setProperties() methods to backup and restore
     * all parameters in a single call.
     */
    public static class Settings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.988 -0400", hash_original_field = "713AB209FB7B78B4455D91735B3BB581", hash_generated_field = "87F0FC53E5646DF709EF9216D198845E")

        public short preset;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.990 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        
public Settings() {
        }

        /**
         * Settings class constructor from a key=value; pairs formatted string. The string is
         * typically returned by Settings.toString() method.
         * @throws IllegalArgumentException if the string is not correctly formatted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.992 -0400", hash_original_method = "28FC1E8B176D4656A09BE0129475E72A", hash_generated_method = "12101B7D9C4D565FBC0DC04A6CB05581")
        
public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int tokens = st.countTokens();
            if (st.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals("PresetReverb")) {
                throw new IllegalArgumentException(
                        "invalid settings for PresetReverb: " + key);
            }
            try {
                key = st.nextToken();
                if (!key.equals("preset")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                preset = Short.parseShort(st.nextToken());
             } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.994 -0400", hash_original_method = "532F37BF21EEBC01C21CA7E1F97E5857", hash_generated_method = "6C74935CB973FA5D2005655C4A53412C")
        
@Override
        public String toString() {
            String str = new String (
                    "PresetReverb"+
                    ";preset="+Short.toString(preset)
                    );
            return str;
        }
    };

    /**
     * Gets the preset reverb properties. This method is useful when a snapshot of current
     * preset reverb settings must be saved by the application.
     * @return a PresetReverb.Settings object containing all current parameters values
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.997 -0400", hash_original_method = "65387F440EC8E02EC0672F4B815227D6", hash_generated_method = "D6EAB1BF87C9778E05329DCFE966154C")
    
public PresetReverb.Settings getProperties()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_PRESET, value));
        settings.preset = value[0];
        return settings;
    }

    /**
     * Sets the preset reverb properties. This method is useful when preset reverb settings have to
     * be applied from a previous backup.
     * @param settings a PresetReverb.Settings object containing the properties to apply
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.999 -0400", hash_original_method = "24A2ACC9331FB16DF53A58A2D61A8A8F", hash_generated_method = "2FEE2EF6DCE152D9A42CB1CFC7C89062")
    
public void setProperties(PresetReverb.Settings settings)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_PRESET, settings.preset));
    }
}
