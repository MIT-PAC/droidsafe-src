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
 * Copyright (C) 2011 The Android Open Source Project
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

/**
 * Automatic Gain Control (AGC).
 * <p>Automatic Gain Control (AGC) is an audio pre-processing which automatically normalizes the
 * output of the captured signal by boosting or lowering input from the microphone to match a preset
 * level so that that the output signal level is virtually constant.
 * AGC can be used by applications where the input signal dynamic range is not important but where
 * a constant strong capture level is desired.
 * <p>An application creates a AutomaticGainControl object to instantiate and control an AGC
 * engine in the audio framework.
 * <p>To attach the AutomaticGainControl to a particular {@link android.media.AudioRecord},
 * specify the audio session ID of this AudioRecord when constructing the AutomaticGainControl.
 * The audio session is retrieved by calling
 * {@link android.media.AudioRecord#getAudioSessionId()} on the AudioRecord instance.
 * <p>On some devices, an AGC can be inserted by default in the capture path by the platform
 * according to the {@link android.media.MediaRecorder.AudioSource} used. The application can
 * query which pre-processings are currently applied to an AudioRecord instance by calling
 * {@link android.media.audiofx.AudioEffect#queryPreProcessings(int)} with the audio session of the
 * AudioRecord.
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on
 * controlling audio effects.
 * @hide
 */

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class AutomaticGainControl extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.339 -0400", hash_original_field = "3FF311AF829A66EB622F22E1B6639476", hash_generated_field = "AD88489F5BA1CEA1DDC75E6BEC8E8598")


    private final static String TAG = "AutomaticGainControl";

    /**
     * Class constructor.
     * <p> The application must catch exceptions when creating an AutomaticGainControl as the
     * constructor is not guarantied to succeed:
     * <ul>
     *  <li>IllegalArgumentException is thrown if the device does not implement an AGC</li>
     *  <li>UnsupportedOperationException is thrown is the resources allocated to audio
     *  pre-procesing are currently exceeded.</li>
     * </ul>
     *
     * @param audioSession system wide unique audio session identifier. The AutomaticGainControl
     * will be applied to the AudioRecord with the same audio session.
     *
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.341 -0400", hash_original_method = "B773BF9523D90386E50EECD40408B550", hash_generated_method = "D084B8208DDA390C99394E75B033B141")
    
public AutomaticGainControl(int audioSession)
            throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_AGC, EFFECT_TYPE_NULL, 0, audioSession);
    }
}
