/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


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
 * An audio virtualizer is a general name for an effect to spatialize audio channels. The exact
 * behavior of this effect is dependent on the number of audio input channels and the types and
 * number of audio output channels of the device. For example, in the case of a stereo input and
 * stereo headphone output, a stereo widening effect is used when this effect is turned on.
 * <p>An application creates a Virtualizer object to instantiate and control a virtualizer engine
 * in the audio framework.
 * <p>The methods, parameter types and units exposed by the Virtualizer implementation are directly
 * mapping those defined by the OpenSL ES 1.0.1 Specification (http://www.khronos.org/opensles/)
 * for the SLVirtualizerItf interface. Please refer to this specification for more details.
 * <p>To attach the Virtualizer to a particular AudioTrack or MediaPlayer, specify the audio session
 * ID of this AudioTrack or MediaPlayer when constructing the Virtualizer.
 * <p>NOTE: attaching a Virtualizer to the global audio output mix by use of session 0 is
 * deprecated.
 * <p>See {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling
 * audio effects.
 */

public class Virtualizer extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.101 -0400", hash_original_field = "A8DF41F4FB520CF4BBA2B9A1E3DB48E8", hash_generated_field = "B6FCC0B34D27D42A687B998D4D525745")

    private final static String TAG = "Virtualizer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.103 -0400", hash_original_field = "10C80B2446C45AB94FF87C713A1C0A82", hash_generated_field = "AC00C83CA53C1ACE3CD627AD44D330A1")

    /**
     * Is strength parameter supported by virtualizer engine. Parameter ID for getParameter().
     */
    public static final int PARAM_STRENGTH_SUPPORTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.105 -0400", hash_original_field = "5CFA5ADF46A7487EB867A38FA20B4C6B", hash_generated_field = "49C87DB3380F4F352CD00636531EB90B")

    public static final int PARAM_STRENGTH = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.107 -0400", hash_original_field = "775D53746AE29D66547860767A9BEF55", hash_generated_field = "69E31B4801688303B8ADEE4AC4F183E4")

    private boolean mStrengthSupported = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.109 -0400", hash_original_field = "2E2B05E7EF469AE4E8BB908F4A865479", hash_generated_field = "95416CDBA48505554B696D0275F8F405")

    private OnParameterChangeListener mParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.111 -0400", hash_original_field = "CD6325FB9FC281254824DD2841A3250F", hash_generated_field = "ADD9DF28553977A37F99E63E4FBB5FF6")

    private BaseParameterListener mBaseParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.112 -0400", hash_original_field = "E110C4655C125DC0BD0C3B91841408F1", hash_generated_field = "1004B26395DEA9DB0250344109FCA5F2")

    private final Object mParamListenerLock = new Object();

    /**
     * Class constructor.
     * @param priority the priority level requested by the application for controlling the Virtualizer
     * engine. As the same engine can be shared by several applications, this parameter indicates
     * how much the requesting application needs control of effect parameters. The normal priority
     * is 0, above normal is a positive number, below normal a negative number.
     * @param audioSession  system wide unique audio session identifier. The Virtualizer will
     * be attached to the MediaPlayer or AudioTrack in the same audio session.
     *
     * @throws java.lang.IllegalStateException
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.114 -0400", hash_original_method = "8A1926F1E27AE9F8B3F94826171E5368", hash_generated_method = "7ECC4B491E656FDD1D7335CF1BC66FDD")
    
public Virtualizer(int priority, int audioSession)
    throws IllegalStateException, IllegalArgumentException,
           UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_VIRTUALIZER, EFFECT_TYPE_NULL, priority, audioSession);

        if (audioSession == 0) {
            Log.w(TAG, "WARNING: attaching a Virtualizer to global output mix is deprecated!");
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.116 -0400", hash_original_method = "53C8E562A3C7D7DB53A91ECB9C68C34A", hash_generated_method = "A79003A8C5091431503626D7084CFCE8")
    
public boolean getStrengthSupported() {
       return mStrengthSupported;
    }

    /**
     * Sets the strength of the virtualizer effect. If the implementation does not support per mille
     * accuracy for setting the strength, it is allowed to round the given strength to the nearest
     * supported value. You can use the {@link #getRoundedStrength()} method to query the
     * (possibly rounded) value that was actually set.
     * @param strength strength of the effect. The valid range for strength strength is [0, 1000],
     * where 0 per mille designates the mildest effect and 1000 per mille designates the strongest.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.118 -0400", hash_original_method = "F42557C11691EA8C3FA611EFD411F87F", hash_generated_method = "27367471DDB100D8E4CE81785F12552F")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.120 -0400", hash_original_method = "18E25C92BF5235C52A9D4BF54C298F65", hash_generated_method = "DC95F8B2BA47B57AFD6E20668E518C7C")
    
public short getRoundedStrength()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_STRENGTH, value));
        return value[0];
    }

    /**
     * The OnParameterChangeListener interface defines a method called by the Virtualizer when a
     * parameter value has changed.
     */
    public interface OnParameterChangeListener  {
        /**
         * Method called when a parameter value has changed. The method is called only if the
         * parameter was changed by another application having the control of the same
         * Virtualizer engine.
         * @param effect the Virtualizer on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param ID of the modified parameter. See {@link #PARAM_STRENGTH} ...
         * @param value the new parameter value.
         */
        void onParameterChange(Virtualizer effect, int status, int param, short value);
    }

    /**
     * Listener used internally to receive unformatted parameter change events from AudioEffect
     * super class.
     */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.123 -0400", hash_original_method = "9FA8987EB3F89D504F2D03489A50FB50", hash_generated_method = "66FD07CD2ED00DBCFA69A2FD6240DAA5")
        
private BaseParameterListener() {

        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.125 -0400", hash_original_method = "67E72BB4A51D8F3617D323F120BA258E", hash_generated_method = "8D862DEB69A96940F6B2590B1BF2C031")
        
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
                    l.onParameterChange(Virtualizer.this, status, p, v);
                }
            }
        }
    }

    /**
     * Registers an OnParameterChangeListener interface.
     * @param listener OnParameterChangeListener interface registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.128 -0400", hash_original_method = "0055015932E0C4AC564122B5477C52E3", hash_generated_method = "E1FA55A6EC170589DAD58B149D391DB4")
    
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
     * The Settings class regroups all virtualizer parameters. It is used in
     * conjuntion with getProperties() and setProperties() methods to backup and restore
     * all parameters in a single call.
     */
    public static class Settings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.130 -0400", hash_original_field = "19C6BD8961FF0501A899E8E3353B3CB9", hash_generated_field = "2AF6BFD17D788807E65A204D31A7B6D1")

        public short strength;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.132 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        
public Settings() {
        }

        /**
         * Settings class constructor from a key=value; pairs formatted string. The string is
         * typically returned by Settings.toString() method.
         * @throws IllegalArgumentException if the string is not correctly formatted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.135 -0400", hash_original_method = "5EF0DFDA5F630B85F5AA10FBA554AD2F", hash_generated_method = "F76489AA3C3B402DCC727AAC8C880255")
        
public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int tokens = st.countTokens();
            if (st.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals("Virtualizer")) {
                throw new IllegalArgumentException(
                        "invalid settings for Virtualizer: " + key);
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

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.136 -0400", hash_original_method = "B682B76D546A4CEBF5D04D5E3FF007F1", hash_generated_method = "2A1A9658FDDBE99EA0FE96B7857903D7")
        
@Override
        public String toString() {
            String str = new String (
                    "Virtualizer"+
                    ";strength="+Short.toString(strength)
                    );
            return str;
        }
    };

    /**
     * Gets the virtualizer properties. This method is useful when a snapshot of current
     * virtualizer settings must be saved by the application.
     * @return a Virtualizer.Settings object containing all current parameters values
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.139 -0400", hash_original_method = "447D768BACC14ABD1C463408932DD2C3", hash_generated_method = "3C25177CB5D42294E179A12CC4BD5532")
    
public Virtualizer.Settings getProperties()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short[] value = new short[1];
        checkStatus(getParameter(PARAM_STRENGTH, value));
        settings.strength = value[0];
        return settings;
    }

    /**
     * Sets the virtualizer properties. This method is useful when virtualizer settings have to
     * be applied from a previous backup.
     * @param settings a Virtualizer.Settings object containing the properties to apply
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.141 -0400", hash_original_method = "7E43C51217F6977F9299835D5E6B106F", hash_generated_method = "A3931A61B391CCEA898C8D8B94A56722")
    
public void setProperties(Virtualizer.Settings settings)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(PARAM_STRENGTH, settings.strength));
    }
}
