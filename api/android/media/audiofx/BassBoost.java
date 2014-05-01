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
 * Bass boost is an audio effect to boost or amplify low frequencies of the sound. It is comparable
 * to a simple equalizer but limited to one band amplification in the low frequency range.
 * <p>An application creates a BassBoost object to instantiate and control a bass boost engine in
 * the audio framework.
 * <p>The methods, parameter types and units exposed by the BassBoost implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLBassBoostItf interface. Please refer to this specification for more details.
 * <p>To attach the BassBoost to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the BassBoost.
 * <p>NOTE: attaching a BassBoost to the global audio output mix by use of session 0 is deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on
 * controlling audio effects.
 */

public class BassBoost extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.407 -0400", hash_original_field = "E0E097620E7CAC4775D590F62BF2B9B6", hash_generated_field = "C80423C39C9E9D1A789B8C2BB17D9A71")

    private final static String TAG = "BassBoost";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.409 -0400", hash_original_field = "10C80B2446C45AB94FF87C713A1C0A82", hash_generated_field = "061D688B287B2CA8CEC8C1629A106A37")

    // frameworks/base/include/media/EffectBassBoostApi.h
    /**
     * Is strength parameter supported by bass boost engine. Parameter ID for getParameter().
     */
    public static final int PARAM_STRENGTH_SUPPORTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.411 -0400", hash_original_field = "5CFA5ADF46A7487EB867A38FA20B4C6B", hash_generated_field = "49C87DB3380F4F352CD00636531EB90B")

    public static final int PARAM_STRENGTH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.412 -0400", hash_original_field = "775D53746AE29D66547860767A9BEF55", hash_generated_field = "69E31B4801688303B8ADEE4AC4F183E4")

    private boolean mStrengthSupported = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.414 -0400", hash_original_field = "2E2B05E7EF469AE4E8BB908F4A865479", hash_generated_field = "95416CDBA48505554B696D0275F8F405")

    private OnParameterChangeListener mParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.415 -0400", hash_original_field = "CD6325FB9FC281254824DD2841A3250F", hash_generated_field = "ADD9DF28553977A37F99E63E4FBB5FF6")

    private BaseParameterListener mBaseParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.417 -0400", hash_original_field = "E110C4655C125DC0BD0C3B91841408F1", hash_generated_field = "1004B26395DEA9DB0250344109FCA5F2")

    private final Object mParamListenerLock = new Object();

    /**
     * Class constructor.
     * @param priority the priority level requested by the application for controlling the BassBoost
     * engine. As the same engine can be shared by several applications, this parameter indicates
     * how much the requesting application needs control of effect parameters. The normal priority
     * is 0, above normal is a positive number, below normal a negative number.
     * @param audioSession system wide unique audio session identifier. The BassBoost will be
     * attached to the MediaPlayer or AudioTrack in the same audio session.
     *
     * @throws java.lang.IllegalStateException
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.420 -0400", hash_original_method = "CEE26D91B29494B3EB17B5B069E67E17", hash_generated_method = "5218FAAAA4FEF8D2C78E267D59BE90DF")
    
public BassBoost(int priority, int audioSession)
    throws IllegalStateException, IllegalArgumentException,
           UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_BASS_BOOST, EFFECT_TYPE_NULL, priority, audioSession);

        if (audioSession == 0) {
            Log.w(TAG, "WARNING: attaching a BassBoost to global output mix is deprecated!");
        }

        int[] value = new int[1];
        checkStatus(getParameter(PARAM_STRENGTH_SUPPORTED, value));
        mStrengthSupported = (value[0] != 0);
    }

    /**
     * Indicates whether setting strength is supported. If this method returns false, only one
     * strength is supported and the setStrength() method always rounds to that value.
     * @return true is strength parameter is supported, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.422 -0400", hash_original_method = "53C8E562A3C7D7DB53A91ECB9C68C34A", hash_generated_method = "A79003A8C5091431503626D7084CFCE8")
    
public boolean getStrengthSupported() {
       return mStrengthSupported;
    }

    /**
     * Sets the strength of the bass boost effect. If the implementation does not support per mille
     * accuracy for setting the strength, it is allowed to round the given strength to the nearest
     * supported value. You can use the {@link #getRoundedStrength()} method to query the
     * (possibly rounded) value that was actually set.
     * @param strength strength of the effect. The valid range for strength strength is [0, 1000],
     * where 0 per mille designates the mildest effect and 1000 per mille designates the strongest.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.424 -0400", hash_original_method = "F42557C11691EA8C3FA611EFD411F87F", hash_generated_method = "27367471DDB100D8E4CE81785F12552F")
    
public void setStrength(short strength)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_STRENGTH, strength));
    }

    /**
     * Gets the current strength of the effect.
     * @return the strength of the effect. The valid range for strength is [0, 1000], where 0 per
     * mille designates the mildest effect and 1000 per mille the strongest
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.425 -0400", hash_original_method = "18E25C92BF5235C52A9D4BF54C298F65", hash_generated_method = "DC95F8B2BA47B57AFD6E20668E518C7C")
    
public short getRoundedStrength()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_STRENGTH, value));
        return value[0];
    }

    /**
     * The OnParameterChangeListener interface defines a method called by the BassBoost when a
     * parameter value has changed.
     */
    public interface OnParameterChangeListener  {
        /**
         * Method called when a parameter value has changed. The method is called only if the
         * parameter was changed by another application having the control of the same
         * BassBoost engine.
         * @param effect the BassBoost on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param ID of the modified parameter. See {@link #PARAM_STRENGTH} ...
         * @param value the new parameter value.
         */
        void onParameterChange(BassBoost effect, int status, int param, short value);
    }

    /**
     * Listener used internally to receive unformatted parameter change events from AudioEffect
     * super class.
     */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.429 -0400", hash_original_method = "9FA8987EB3F89D504F2D03489A50FB50", hash_generated_method = "66FD07CD2ED00DBCFA69A2FD6240DAA5")
        
private BaseParameterListener() {

        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.432 -0400", hash_original_method = "C33AD56C5DDE98BDF7E804A6A384C84D", hash_generated_method = "DF3574E565A9201908525A425525220B")
        
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
                    l.onParameterChange(BassBoost.this, status, p, v);
                }
            }
        }
    }

    /**
     * Registers an OnParameterChangeListener interface.
     * @param listener OnParameterChangeListener interface registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.435 -0400", hash_original_method = "0055015932E0C4AC564122B5477C52E3", hash_generated_method = "E1FA55A6EC170589DAD58B149D391DB4")
    
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
     * The Settings class regroups all bass boost parameters. It is used in
     * conjuntion with getProperties() and setProperties() methods to backup and restore
     * all parameters in a single call.
     */
    public static class Settings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.437 -0400", hash_original_field = "19C6BD8961FF0501A899E8E3353B3CB9", hash_generated_field = "2AF6BFD17D788807E65A204D31A7B6D1")

        public short strength;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.439 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        
public Settings() {
        }

        /**
         * Settings class constructor from a key=value; pairs formatted string. The string is
         * typically returned by Settings.toString() method.
         * @throws IllegalArgumentException if the string is not correctly formatted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.442 -0400", hash_original_method = "24E8566DC75360A12F825B9054E86D90", hash_generated_method = "120629EA2EA8C495B31A34EDB7BB5EAE")
        
public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int tokens = st.countTokens();
            if (st.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals("BassBoost")) {
                throw new IllegalArgumentException(
                        "invalid settings for BassBoost: " + key);
            }
            try {
                key = st.nextToken();
                if (!key.equals("strength")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                strength = Short.parseShort(st.nextToken());
             } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.444 -0400", hash_original_method = "732AFE0BBA09268198C1B830E4C67C0B", hash_generated_method = "BFF0EB4AD610519D03144B7501D53F5B")
        
@Override
        public String toString() {
            String str = new String (
                    "BassBoost"+
                    ";strength="+Short.toString(strength)
                    );
            return str;
        }
    };

    /**
     * Gets the bass boost properties. This method is useful when a snapshot of current
     * bass boost settings must be saved by the application.
     * @return a BassBoost.Settings object containing all current parameters values
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.447 -0400", hash_original_method = "C39420EBB3BC7000E83082FD2C311E9A", hash_generated_method = "32A1345155315641794926F95BA20483")
    
public BassBoost.Settings getProperties()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_STRENGTH, value));
        settings.strength = value[0];
        return settings;
    }

    /**
     * Sets the bass boost properties. This method is useful when bass boost settings have to
     * be applied from a previous backup.
     * @param settings a BassBoost.Settings object containing the properties to apply
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.448 -0400", hash_original_method = "E7807DC1DE2B2B0B686E1E82A20FE8F5", hash_generated_method = "8D366D1B158390657CF379E8E40C58A0")
    
public void setProperties(BassBoost.Settings settings)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_STRENGTH, settings.strength));
    }
}
