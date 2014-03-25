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
 * A sound generated within a room travels in many directions. The listener first hears the direct
 * sound from the source itself. Later, he or she hears discrete echoes caused by sound bouncing off
 * nearby walls, the ceiling and the floor. As sound waves arrive after undergoing more and more
 * reflections, individual reflections become indistinguishable and the listener hears continuous
 * reverberation that decays over time.
 * Reverb is vital for modeling a listener's environment. It can be used in music applications
 * to simulate music being played back in various environments, or in games to immerse the
 * listener within the game's environment.
 * The EnvironmentalReverb class allows an application to control each reverb engine property in a
 * global reverb environment and is more suitable for games. For basic control, more suitable for
 * music applications, it is recommended to use the
 * {@link android.media.audiofx.PresetReverb} class.
 * <p>An application creates a EnvironmentalReverb object to instantiate and control a reverb engine
 * in the audio framework.
 * <p>The methods, parameter types and units exposed by the EnvironmentalReverb implementation are
 * directly mapping those defined by the OpenSL ES 1.0.1 Specification
 * (http://www.khronos.org/opensles/) for the SLEnvironmentalReverbItf interface.
 * Please refer to this specification for more details.
 * <p>The EnvironmentalReverb is an output mix auxiliary effect and should be created on
 * Audio session 0. In order for a MediaPlayer or AudioTrack to be fed into this effect,
 * they must be explicitely attached to it and a send level must be specified. Use the effect ID
 * returned by getId() method to designate this particular effect when attaching it to the
 * MediaPlayer or AudioTrack.
 * <p>Creating a reverb on the output mix (audio session 0) requires permission
 * {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}
 * <p>See {@link android.media.audiofx.AudioEffect} class for more details on controlling
 * audio effects.
 */

public class EnvironmentalReverb extends AudioEffect {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.084 -0400", hash_original_field = "9E2D0E4C37D49C8EE120913D834FC514", hash_generated_field = "55E787782ED4323A5B9425B4FD4940D6")


    private final static String TAG = "EnvironmentalReverb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.086 -0400", hash_original_field = "EDEC1AE0D72DCDDCF07545BDCADD71D9", hash_generated_field = "ECF78CECF5DB8AE47B9E00F68A7E461E")

    // frameworks/base/include/media/EffectEnvironmentalReverbApi.h

    /**
     * Room level. Parameter ID for OnParameterChangeListener
     */
    public static final int PARAM_ROOM_LEVEL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.088 -0400", hash_original_field = "6E760B1FAF36CE1A026A520981B96A37", hash_generated_field = "479EDA6BEFA92813FBD9D96633241168")

    public static final int PARAM_ROOM_HF_LEVEL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.090 -0400", hash_original_field = "9D2F9A9337E9CAC86BF228EB19097EAF", hash_generated_field = "DA018D4B5F33250603F633DD05C53B31")

    public static final int PARAM_DECAY_TIME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.092 -0400", hash_original_field = "FDD8EFA910518FF7815EE6050739E90A", hash_generated_field = "F00AE5A12598839C75C9DE8F230830A0")

    public static final int PARAM_DECAY_HF_RATIO = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.094 -0400", hash_original_field = "EA75587466FF7323BAF4618AB4906A30", hash_generated_field = "F3BFC21BD9296FE11ADD7FA80C27B295")

    public static final int PARAM_REFLECTIONS_LEVEL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.096 -0400", hash_original_field = "BFD58137192BD5295D59B85722B3463A", hash_generated_field = "96961A6EB7A8EBDFBC26A86EDC743192")

    public static final int PARAM_REFLECTIONS_DELAY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.098 -0400", hash_original_field = "D5B57BA140CEAA39BC1D7452B523859B", hash_generated_field = "3DA1DCAB972C738E3486FB2EE41F18A2")

    public static final int PARAM_REVERB_LEVEL = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.100 -0400", hash_original_field = "59E5F8584C99D57565843231055C5105", hash_generated_field = "5B47FD137744F9B064059AAACBF21877")

    public static final int PARAM_REVERB_DELAY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.102 -0400", hash_original_field = "18785B9B98DD0FE3513581B9892D043C", hash_generated_field = "1C71B392B3C9F1A12445412C8F963EA9")

    public static final int PARAM_DIFFUSION = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.104 -0400", hash_original_field = "2EB9F07375C51F19EF0075A2143402FB", hash_generated_field = "B3C22A74741EA8EC61BCD1E4AB6FC35D")

    public static final int PARAM_DENSITY = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.106 -0400", hash_original_field = "2619AB3D72691FAC1660C31E9D9B5834", hash_generated_field = "5E76D5A2413DD7A796065F28E49AA7E1")

    private static final int PARAM_PROPERTIES = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.190 -0400", hash_original_field = "DA2324F49A92FC599E7A8607AA845539", hash_generated_field = "5611A715A8A85D9E94871ED1E2CA0AC7")

    // frameworks/base/include/media/EffectEnvironmentalReverbApi.h
    static private int PROPERTY_SIZE = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.108 -0400", hash_original_field = "2E2B05E7EF469AE4E8BB908F4A865479", hash_generated_field = "95416CDBA48505554B696D0275F8F405")

    private OnParameterChangeListener mParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.110 -0400", hash_original_field = "CD6325FB9FC281254824DD2841A3250F", hash_generated_field = "ADD9DF28553977A37F99E63E4FBB5FF6")

    private BaseParameterListener mBaseParamListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.112 -0400", hash_original_field = "E110C4655C125DC0BD0C3B91841408F1", hash_generated_field = "1004B26395DEA9DB0250344109FCA5F2")

    private final Object mParamListenerLock = new Object();

    /**
     * Class constructor.
     * @param priority the priority level requested by the application for controlling the
     * EnvironmentalReverb engine. As the same engine can be shared by several applications, this
     * parameter indicates how much the requesting application needs control of effect parameters.
     * The normal priority is 0, above normal is a positive number, below normal a negative number.
     * @param audioSession  system wide unique audio session identifier. If audioSession
     *  is not 0, the EnvironmentalReverb will be attached to the MediaPlayer or AudioTrack in the
     *  same audio session. Otherwise, the EnvironmentalReverb will apply to the output mix.
     *  As the EnvironmentalReverb is an auxiliary effect it is recommended to instantiate it on
     *  audio session 0 and to attach it to the MediaPLayer auxiliary output.
     *
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.114 -0400", hash_original_method = "74F172C901DC6C2898C765B46C9A0045", hash_generated_method = "E63628C111E196A936E94BE6133326C4")
    
public EnvironmentalReverb(int priority, int audioSession)
    throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_ENV_REVERB, EFFECT_TYPE_NULL, priority, audioSession);
    }

    /**
     * Sets the master volume level of the environmental reverb effect.
     * @param room room level in millibels. The valid range is [-9000, 0].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.115 -0400", hash_original_method = "91E27486FBD11916AA3EF8E52D17AAB5", hash_generated_method = "D814DC8FE853D66C2A0F897FC1D285DD")
    
public void setRoomLevel(short room)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(room);
        checkStatus(setParameter(PARAM_ROOM_LEVEL, param));
    }

    /**
     * Gets the master volume level of the environmental reverb effect.
     * @return the room level in millibels.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.117 -0400", hash_original_method = "79037987A95E6559BE9BA80C11ECD11B", hash_generated_method = "6EE0B3CD8DBADCABF4E129FAF7A3A6AD")
    
public short getRoomLevel()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_ROOM_LEVEL, param));
        return byteArrayToShort(param);
    }

    /**
     * Sets the volume level at 5 kHz relative to the volume level at low frequencies of the
     * overall reverb effect.
     * <p>This controls a low-pass filter that will reduce the level of the high-frequency.
     * @param roomHF high frequency attenuation level in millibels. The valid range is [-9000, 0].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.119 -0400", hash_original_method = "E68C13A979F07F2F3B46CE1A381EFD69", hash_generated_method = "0242F3B4EC2239C36B03A62DBFDF71D0")
    
public void setRoomHFLevel(short roomHF)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(roomHF);
        checkStatus(setParameter(PARAM_ROOM_HF_LEVEL, param));
    }

    /**
     * Gets the room HF level.
     * @return the room HF level in millibels.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.121 -0400", hash_original_method = "B2F07EA2AEB1E8B5341FFF560E30A5BF", hash_generated_method = "E4DF0CF0B10845BE22F14853B34EA071")
    
public short getRoomHFLevel()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_ROOM_HF_LEVEL, param));
        return byteArrayToShort(param);
    }

    /**
     * Sets the time taken for the level of reverberation to decay by 60 dB.
     * @param decayTime decay time in milliseconds. The valid range is [100, 20000].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.122 -0400", hash_original_method = "1C4071831716AD4B2A1B18FB734678C9", hash_generated_method = "D76F14865432B3D3EB5ABAF5DC2BAF36")
    
public void setDecayTime(int decayTime)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = intToByteArray(decayTime);
        checkStatus(setParameter(PARAM_DECAY_TIME, param));
    }

    /**
     * Gets the decay time.
     * @return the decay time in milliseconds.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.125 -0400", hash_original_method = "B78A6C3122288E0D666CCA564074DC39", hash_generated_method = "B74AB3CD1DEC695BC26E6328B44F90B8")
    
public int getDecayTime()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(PARAM_DECAY_TIME, param));
        return byteArrayToInt(param);
    }

    /**
     * Sets the ratio of high frequency decay time (at 5 kHz) relative to the decay time at low
     * frequencies.
     * @param decayHFRatio high frequency decay ratio using a permille scale. The valid range is
     * [100, 2000]. A ratio of 1000 indicates that all frequencies decay at the same rate.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.126 -0400", hash_original_method = "DE10D88CBA7DFCF8F86EC7114963CBFD", hash_generated_method = "E6F1057DF642E6E054C6850DC90D7215")
    
public void setDecayHFRatio(short decayHFRatio)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(decayHFRatio);
        checkStatus(setParameter(PARAM_DECAY_HF_RATIO, param));
    }

    /**
     * Gets the ratio of high frequency decay time (at 5 kHz) relative to low frequencies.
     * @return the decay HF ration. See {@link #setDecayHFRatio(short)} for units.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.128 -0400", hash_original_method = "76AD74E60BBB116A923C69E902F0F78E", hash_generated_method = "3DE07EBA8ADB4E7499AB09F07AD952BA")
    
public short getDecayHFRatio()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_DECAY_HF_RATIO, param));
        return byteArrayToShort(param);
    }

    /**
     * Sets the volume level of the early reflections.
     * <p>This level is combined with the overall room level
     * (set using {@link #setRoomLevel(short)}).
     * @param reflectionsLevel reflection level in millibels. The valid range is [-9000, 1000].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.130 -0400", hash_original_method = "6A2616404CED43E990540D5FC092122D", hash_generated_method = "E4E31D11C68E4832E138B0B2EC75D7FA")
    
public void setReflectionsLevel(short reflectionsLevel)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(reflectionsLevel);
        checkStatus(setParameter(PARAM_REFLECTIONS_LEVEL, param));
    }

    /**
     * Gets the volume level of the early reflections.
     * @return the early reflections level in millibels.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.132 -0400", hash_original_method = "32274B98D4D32EA8E493ED78BD1AE25E", hash_generated_method = "4BAC6E3358744D44CEB4A706DBC7A022")
    
public short getReflectionsLevel()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_REFLECTIONS_LEVEL, param));
        return byteArrayToShort(param);
    }

    /**
     * Sets the delay time for the early reflections.
     * <p>This method sets the time between when the direct path is heard and when the first
     * reflection is heard.
     * @param reflectionsDelay reflections delay in milliseconds. The valid range is [0, 300].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.134 -0400", hash_original_method = "EDA4B1DD301500ECF0C0BC811A1AD364", hash_generated_method = "E9707CDB5D5A967702A30F0A9AAE12A2")
    
public void setReflectionsDelay(int reflectionsDelay)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = intToByteArray(reflectionsDelay);
        checkStatus(setParameter(PARAM_REFLECTIONS_DELAY, param));
    }

    /**
     * Gets the reflections delay.
     * @return the early reflections delay in milliseconds.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.136 -0400", hash_original_method = "7DC4EA67E23E40BBEC1E01E71D392CCE", hash_generated_method = "C711862CA4CC5F33A2C64316562F3508")
    
public int getReflectionsDelay()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(PARAM_REFLECTIONS_DELAY, param));
        return byteArrayToInt(param);
    }

    /**
     * Sets the volume level of the late reverberation.
     * <p>This level is combined with the overall room level (set using {@link #setRoomLevel(short)}).
     * @param reverbLevel reverb level in millibels. The valid range is [-9000, 2000].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.137 -0400", hash_original_method = "BA147A00D94306E9CE34B77A3AFABA3F", hash_generated_method = "4477D51A54E624FDF312590496F2543A")
    
public void setReverbLevel(short reverbLevel)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(reverbLevel);
        checkStatus(setParameter(PARAM_REVERB_LEVEL, param));
    }

    /**
     * Gets the reverb level.
     * @return the reverb level in millibels.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.139 -0400", hash_original_method = "AFA3BBABBD80A71AB2355345BC9DE6E6", hash_generated_method = "8D699BE58362DE444ABE4FAC90F4A5CB")
    
public short getReverbLevel()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_REVERB_LEVEL, param));
        return byteArrayToShort(param);
    }

    /**
     * Sets the time between the first reflection and the reverberation.
     * @param reverbDelay reverb delay in milliseconds. The valid range is [0, 100].
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.141 -0400", hash_original_method = "FE9B9B27FA7FE1373CC99E6D5EE79E8E", hash_generated_method = "78759F0818171825AED08C748AED15D5")
    
public void setReverbDelay(int reverbDelay)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = intToByteArray(reverbDelay);
        checkStatus(setParameter(PARAM_REVERB_DELAY, param));
    }

    /**
     * Gets the reverb delay.
     * @return the reverb delay in milliseconds.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.143 -0400", hash_original_method = "610B01E5D4A3D53B4BB17133693A633A", hash_generated_method = "EC200916E439A2B280F7F8E6CB2A364A")
    
public int getReverbDelay()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(PARAM_REVERB_DELAY, param));
        return byteArrayToInt(param);
    }

    /**
     * Sets the echo density in the late reverberation decay.
     * <p>The scale should approximately map linearly to the perceived change in reverberation.
     * @param diffusion diffusion specified using a permille scale. The diffusion valid range is
     * [0, 1000]. A value of 1000 o/oo indicates a smooth reverberation decay.
     * Values below this level give a more <i>grainy</i> character.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.144 -0400", hash_original_method = "6A2A41EA043F65D545813FFAEDE66912", hash_generated_method = "CBDF107E9F0926F1609D38152B53F39C")
    
public void setDiffusion(short diffusion)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(diffusion);
        checkStatus(setParameter(PARAM_DIFFUSION, param));
    }

    /**
     * Gets diffusion level.
     * @return the diffusion level. See {@link #setDiffusion(short)} for units.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.146 -0400", hash_original_method = "466DDD533F0E16572ACA96136A1EC4F7", hash_generated_method = "354FC80B1903174061578148D8E3D4C6")
    
public short getDiffusion()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_DIFFUSION, param));
        return byteArrayToShort(param);
    }


    /**
     * Controls the modal density of the late reverberation decay.
     * <p> The scale should approximately map linearly to the perceived change in reverberation.
     * A lower density creates a hollow sound that is useful for simulating small reverberation
     * spaces such as bathrooms.
     * @param density density specified using a permille scale. The valid range is [0, 1000].
     * A value of 1000 o/oo indicates a natural sounding reverberation. Values below this level
     * produce a more colored effect.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.148 -0400", hash_original_method = "8A7400A6AA4021AAE83017526C243712", hash_generated_method = "51C41989689975B36C43B0AEA351A839")
    
public void setDensity(short density)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = shortToByteArray(density);
        checkStatus(setParameter(PARAM_DENSITY, param));
    }


    /**
     * The OnParameterChangeListener interface defines a method called by the EnvironmentalReverb
     * when a parameter value has changed.
     */
    public interface OnParameterChangeListener  {
        /**
         * Method called when a parameter value has changed. The method is called only if the
         * parameter was changed by another application having the control of the same
         * EnvironmentalReverb engine.
         * @param effect the EnvironmentalReverb on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param ID of the modified parameter. See {@link #PARAM_ROOM_LEVEL} ...
         * @param value the new parameter value.
         */
        void onParameterChange(EnvironmentalReverb effect, int status, int param, int value);
    }

    /**
     * Listener used internally to receive unformatted parameter change events from AudioEffect
     * super class.
     */
    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.154 -0400", hash_original_method = "9FA8987EB3F89D504F2D03489A50FB50", hash_generated_method = "66FD07CD2ED00DBCFA69A2FD6240DAA5")
        
private BaseParameterListener() {

        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.157 -0400", hash_original_method = "D3A64B2FC59E69A8F87A214F9FCCD1E6", hash_generated_method = "5DFDF41336A0225C6B87D9190FA0199A")
        
public void onParameterChange(AudioEffect effect, int status, byte[] param, byte[] value) {
            OnParameterChangeListener l = null;

            synchronized (mParamListenerLock) {
                if (mParamListener != null) {
                    l = mParamListener;
                }
            }
            if (l != null) {
                int p = -1;
                int v = -1;

                if (param.length == 4) {
                    p = byteArrayToInt(param, 0);
                }
                if (value.length == 2) {
                    v = (int)byteArrayToShort(value, 0);
                } else if (value.length == 4) {
                    v = byteArrayToInt(value, 0);
                }
                if (p != -1 && v != -1) {
                    l.onParameterChange(EnvironmentalReverb.this, status, p, v);
                }
            }
        }
    }

    /**
     * Gets the density level.
     * @return the density level. See {@link #setDiffusion(short)} for units.
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.150 -0400", hash_original_method = "8551B9A7AE354C8B1FA8144FAC81E170", hash_generated_method = "E2D7C43F4477F19D06008A8D5B9E2929")
    
public short getDensity()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(PARAM_DENSITY, param));
        return byteArrayToShort(param);
    }

    /**
     * The Settings class regroups all environmental reverb parameters. It is used in
     * conjuntion with getProperties() and setProperties() methods to backup and restore
     * all parameters in a single call.
     */
    public static class Settings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.162 -0400", hash_original_field = "EF6651EE8114FC1C95FD22EE6E53189B", hash_generated_field = "DD9D97406331033A902DA1F81F16EC44")

        public short roomLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.164 -0400", hash_original_field = "B415AF6F71C6BC0804EC81DEABB998DF", hash_generated_field = "B2B24D1FB6757405237BBB92F50BFE6C")

        public short roomHFLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.165 -0400", hash_original_field = "82EE60C9E2B8858F7F687275484E85AB", hash_generated_field = "8DD305813869C495EE238C9BF065F014")

        public int decayTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.167 -0400", hash_original_field = "9EF65A6012B7186FF218406F127A380E", hash_generated_field = "82AB38A293B6997F117E7D2D8A6E37D6")

        public short decayHFRatio;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.169 -0400", hash_original_field = "984B300056DD547E9F7672FE980EB472", hash_generated_field = "A9318353DCE13F60E3D27CC41AD6B0CC")

        public short reflectionsLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.171 -0400", hash_original_field = "D8CACB087975D805394341E641A83576", hash_generated_field = "843FFADAAF9FB09C8B5D4438FF762CD5")

        public int reflectionsDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.173 -0400", hash_original_field = "EF8950D93B51EB8FB03982D976E238FD", hash_generated_field = "0EFAE9E2B3BCB5EFC2B5676B5C307858")

        public short reverbLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.174 -0400", hash_original_field = "02977FBC30D9BDF7FD3F7868DEF901AD", hash_generated_field = "57749EEB4D73F260159B87238CBF8659")

        public int reverbDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.176 -0400", hash_original_field = "69435301EED57F07048D0CA4BB8577ED", hash_generated_field = "F32D1D4D9D71A285ED56DDE7BB592315")

        public short diffusion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.178 -0400", hash_original_field = "642AF8DCBDA5E41A9F63FF28DA08786D", hash_generated_field = "0863936AA2BC8DA97604245825417444")

        public short density;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.180 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "9E9C65F3ECED90949A3BED36B52A3064")
        
public Settings() {
        }

        /**
         * Settings class constructor from a key=value; pairs formatted string. The string is
         * typically returned by Settings.toString() method.
         * @throws IllegalArgumentException if the string is not correctly formatted.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.184 -0400", hash_original_method = "6401D4260B8E9501834C8CFE735A6F88", hash_generated_method = "A416D02176E2A926CEA33883B7C5FF53")
        
public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int tokens = st.countTokens();
            if (st.countTokens() != 21) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals("EnvironmentalReverb")) {
                throw new IllegalArgumentException(
                        "invalid settings for EnvironmentalReverb: " + key);
            }

            try {
                key = st.nextToken();
                if (!key.equals("roomLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                roomLevel = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("roomHFLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                roomHFLevel = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("decayTime")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                decayTime = Integer.parseInt(st.nextToken());
                key = st.nextToken();
                if (!key.equals("decayHFRatio")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                decayHFRatio = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("reflectionsLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                reflectionsLevel = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("reflectionsDelay")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                reflectionsDelay = Integer.parseInt(st.nextToken());
                key = st.nextToken();
                if (!key.equals("reverbLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                reverbLevel = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("reverbDelay")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                reverbDelay = Integer.parseInt(st.nextToken());
                key = st.nextToken();
                if (!key.equals("diffusion")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                diffusion = Short.parseShort(st.nextToken());
                key = st.nextToken();
                if (!key.equals("density")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                density = Short.parseShort(st.nextToken());
             } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.186 -0400", hash_original_method = "7B883B025B618E2F4AF9A255DE55FF8D", hash_generated_method = "17FC30141341CDA13019616B3F9F26D2")
        
@Override
        public String toString() {
            return new String (
                    "EnvironmentalReverb"+
                    ";roomLevel="+Short.toString(roomLevel)+
                    ";roomHFLevel="+Short.toString(roomHFLevel)+
                    ";decayTime="+Integer.toString(decayTime)+
                    ";decayHFRatio="+Short.toString(decayHFRatio)+
                    ";reflectionsLevel="+Short.toString(reflectionsLevel)+
                    ";reflectionsDelay="+Integer.toString(reflectionsDelay)+
                    ";reverbLevel="+Short.toString(reverbLevel)+
                    ";reverbDelay="+Integer.toString(reverbDelay)+
                    ";diffusion="+Short.toString(diffusion)+
                    ";density="+Short.toString(density)
                    );
        }
    };

    /**
     * Registers an OnParameterChangeListener interface.
     * @param listener OnParameterChangeListener interface registered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.160 -0400", hash_original_method = "0055015932E0C4AC564122B5477C52E3", hash_generated_method = "E1FA55A6EC170589DAD58B149D391DB4")
    
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
     * Gets the environmental reverb properties. This method is useful when a snapshot of current
     * reverb settings must be saved by the application.
     * @return an EnvironmentalReverb.Settings object containing all current parameters values
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.192 -0400", hash_original_method = "259E5F82209A13107E1AD5D4F9066A82", hash_generated_method = "EAF38931841BA3C780A5ABE82DA19629")
    
public EnvironmentalReverb.Settings getProperties()
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[PROPERTY_SIZE];
        checkStatus(getParameter(PARAM_PROPERTIES, param));
        Settings settings = new Settings();
        settings.roomLevel = byteArrayToShort(param, 0);
        settings.roomHFLevel = byteArrayToShort(param, 2);
        settings.decayTime = byteArrayToInt(param, 4);
        settings.decayHFRatio = byteArrayToShort(param, 8);
        settings.reflectionsLevel = byteArrayToShort(param, 10);
        settings.reflectionsDelay = byteArrayToInt(param, 12);
        settings.reverbLevel = byteArrayToShort(param, 16);
        settings.reverbDelay = byteArrayToInt(param, 18);
        settings.diffusion = byteArrayToShort(param, 22);
        settings.density = byteArrayToShort(param, 24);
        return settings;
    }

    /**
     * Sets the environmental reverb properties. This method is useful when reverb settings have to
     * be applied from a previous backup.
     * @param settings a EnvironmentalReverb.Settings object containing the properties to apply
     * @throws IllegalStateException
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:17.195 -0400", hash_original_method = "71ABE9BCFBE14C65DDB245C0165975F7", hash_generated_method = "8ADD50825BF776E0CAD70CFDF5E374B8")
    
public void setProperties(EnvironmentalReverb.Settings settings)
    throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {

        byte[] param = concatArrays(shortToByteArray(settings.roomLevel),
                                    shortToByteArray(settings.roomHFLevel),
                                    intToByteArray(settings.decayTime),
                                    shortToByteArray(settings.decayHFRatio),
                                    shortToByteArray(settings.reflectionsLevel),
                                    intToByteArray(settings.reflectionsDelay),
                                    shortToByteArray(settings.reverbLevel),
                                    intToByteArray(settings.reverbDelay),
                                    shortToByteArray(settings.diffusion),
                                    shortToByteArray(settings.density));

        checkStatus(setParameter(PARAM_PROPERTIES, param));
    }
}
