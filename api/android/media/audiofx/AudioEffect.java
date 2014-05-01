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
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * AudioEffect is the base class for controlling audio effects provided by the android audio
 * framework.
 * <p>Applications should not use the AudioEffect class directly but one of its derived classes to
 * control specific effects:
 * <ul>
 *   <li> {@link android.media.audiofx.Equalizer}</li>
 *   <li> {@link android.media.audiofx.Virtualizer}</li>
 *   <li> {@link android.media.audiofx.BassBoost}</li>
 *   <li> {@link android.media.audiofx.PresetReverb}</li>
 *   <li> {@link android.media.audiofx.EnvironmentalReverb}</li>
 * </ul>
 * <p>To apply the audio effect to a specific AudioTrack or MediaPlayer instance,
 * the application must specify the audio session ID of that instance when creating the AudioEffect.
 * (see {@link android.media.MediaPlayer#getAudioSessionId()} for details on audio sessions).
 * <p>NOTE: attaching insert effects (equalizer, bass boost, virtualizer) to the global audio output
 * mix by use of session 0 is deprecated.
 * <p>Creating an AudioEffect object will create the corresponding effect engine in the audio
 * framework if no instance of the same effect type exists in the specified audio session.
 * If one exists, this instance will be used.
 * <p>The application creating the AudioEffect object (or a derived class) will either receive
 * control of the effect engine or not depending on the priority parameter. If priority is higher
 * than the priority used by the current effect engine owner, the control will be transfered to the
 * new object. Otherwise control will remain with the previous object. In this case, the new
 * application will be notified of changes in effect engine state or control ownership by the
 * appropiate listener.
 */

public class AudioEffect {
    static {
        System.loadLibrary("audioeffect_jni");
        native_init();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.796 -0400", hash_original_field = "12CCD8ADFAD6FB496A9EABA876975CF0", hash_generated_field = "B8E63CF79C51AD4740E4B3809B928B78")

    private final static String TAG = "AudioEffect-JAVA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.798 -0400", hash_original_field = "BAAD236793835E93954C8FF209B52129", hash_generated_field = "2F9E8B2FA7089DBE0AC79578B4A78001")

    /**
     * The following UUIDs define effect types corresponding to standard audio
     * effects whose implementation and interface conform to the OpenSL ES
     * specification. The definitions match the corresponding interface IDs in
     * OpenSLES_IID.h
     */

    /**
     * UUID for environmental reverb effect
     * @hide
     */
    public static final UUID EFFECT_TYPE_ENV_REVERB = UUID
            .fromString("c2e5d5f0-94bd-4763-9cac-4e234d06839e");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.800 -0400", hash_original_field = "CE59BA847F6854A6B15B946CFF7E9D8E", hash_generated_field = "72E0755CEB65FFCED0EBF09E39F54CD0")

    public static final UUID EFFECT_TYPE_PRESET_REVERB = UUID
            .fromString("47382d60-ddd8-11db-bf3a-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.802 -0400", hash_original_field = "65258D57A61BF9A542A069657FC37EEB", hash_generated_field = "82382FC3F78B8F553336152CB83CF0E3")

    public static final UUID EFFECT_TYPE_EQUALIZER = UUID
            .fromString("0bed4300-ddd6-11db-8f34-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.805 -0400", hash_original_field = "F5F8B71F8B54034F058AC5951B2D53AC", hash_generated_field = "BD01E97CE4DF3B76EE1AEF2DD2976662")

    public static final UUID EFFECT_TYPE_BASS_BOOST = UUID
            .fromString("0634f220-ddd4-11db-a0fc-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.806 -0400", hash_original_field = "6D111E8547777C52C0DCE67500453ABB", hash_generated_field = "569268F429C1E8206B4F4C262A913707")

    public static final UUID EFFECT_TYPE_VIRTUALIZER = UUID
            .fromString("37cc2c00-dddd-11db-8577-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.808 -0400", hash_original_field = "786742344E3033EF4B62A6E2CC6C63D9", hash_generated_field = "A41AEC9F3FF31104FCD835D282B80F25")

    public static final UUID EFFECT_TYPE_AGC = UUID
            .fromString("0a8abfe0-654c-11e0-ba26-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.810 -0400", hash_original_field = "7DDC2C8B5E1BD317ED84C5626E3CA00C", hash_generated_field = "970CCC3EE6960C8E4DE9C90E092D8EF6")

    public static final UUID EFFECT_TYPE_AEC = UUID
            .fromString("7b491460-8d4d-11e0-bd61-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.812 -0400", hash_original_field = "EB97CE31B50DA03B06262C44DE28105C", hash_generated_field = "8A2EA0C7A3CB8A8936289E4B87ED1CA7")

    public static final UUID EFFECT_TYPE_NS = UUID
            .fromString("58b4b260-8e06-11e0-aa8e-0002a5d5c51b");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.814 -0400", hash_original_field = "5DF9E5DE9945AD829B6BCCB300AE0B67", hash_generated_field = "A71A9333F329D69F3A4B0E36C9D831D4")

    public static final UUID EFFECT_TYPE_NULL = UUID
            .fromString("ec7178ec-e5e1-4432-a3f4-4657e6795210");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.816 -0400", hash_original_field = "DADF89E4937FB007E11FCD2CF7BDDE2E", hash_generated_field = "ABD8681944D12EB0761E4A01DCCA64A7")

    public static final int STATE_UNINITIALIZED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.818 -0400", hash_original_field = "02EF6A6792F741D2888A16AA95F5BE68", hash_generated_field = "528069025EBD3248613210FDC5DD79AC")

    public static final int STATE_INITIALIZED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.821 -0400", hash_original_field = "1DB9C7000663CD847F5652A74812CDA9", hash_generated_field = "2899DAF5C09D2792019D727CD763CD45")

    // frameworks/base/include/media/AudioEffect.h
    /**
     * Event id for engine control ownership change notification.
     * @hide
     */
    public static final int NATIVE_EVENT_CONTROL_STATUS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.823 -0400", hash_original_field = "4F4438810681F885FC25C68E07E2082D", hash_generated_field = "A2DE076C61A0B4170E0EB721E6A7645C")

    public static final int NATIVE_EVENT_ENABLED_STATUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.826 -0400", hash_original_field = "7BF895DD82C2ABAE174CA714908F8F98", hash_generated_field = "45F4D2F154D72F3102052460577F0297")

    public static final int NATIVE_EVENT_PARAMETER_CHANGED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.828 -0400", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.830 -0400", hash_original_field = "060BE1B4136BE1AC2BFF57541DF9E977", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.832 -0400", hash_original_field = "9E4E19F09F93BF4E3C21FF5D5C0C91EF", hash_generated_field = "680981E7196324CF93EF7B0044554156")

    public static final int ALREADY_EXISTS = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.834 -0400", hash_original_field = "E10E685436960177FDF6620067D8B3FE", hash_generated_field = "58A0D8C61F32DC39E8B8823C0AEF971A")

    public static final int ERROR_NO_INIT = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.836 -0400", hash_original_field = "98B490381D4BFC4035E8CC6DF0013B79", hash_generated_field = "852CE03AC32991EC9528F95A24EC62C2")

    public static final int ERROR_BAD_VALUE = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.838 -0400", hash_original_field = "F0176A8DFFDFC603D40E0A83A464086F", hash_generated_field = "37EF1CCCB4A226E3C7C703FF094A5521")

    public static final int ERROR_INVALID_OPERATION = -5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.840 -0400", hash_original_field = "D18A11BCA69548EFADC6EA51CDDFA3DC", hash_generated_field = "1C35338ED607C808DB91CBCD3933AC24")

    public static final int ERROR_NO_MEMORY = -6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.842 -0400", hash_original_field = "8A6981B6921F3B84AD0A63146A46A9C0", hash_generated_field = "1D2CD88BB5300E6721806199841B283E")

    public static final int ERROR_DEAD_OBJECT = -7;

    /**
     * The effect descriptor contains information on a particular effect implemented in the
     * audio framework:<br>
     * <ul>
     *  <li>type: UUID corresponding to the OpenSL ES interface implemented by this effect</li>
     *  <li>uuid: UUID for this particular implementation</li>
     *  <li>connectMode: {@link #EFFECT_INSERT}, {@link #EFFECT_AUXILIARY} or
     *  {at_link #EFFECT_PRE_PROCESSING}</li>
     *  <li>name: human readable effect name</li>
     *  <li>implementor: human readable effect implementor name</li>
     * </ul>
     * The method {@link #queryEffects()} returns an array of Descriptors to facilitate effects
     * enumeration.
     */
    public static class Descriptor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.848 -0400", hash_original_field = "82D24E8C468DAE94A9665445250D26AD", hash_generated_field = "E74F24AA3E853D7A851C55AF7A21CC4A")

        public UUID type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.850 -0400", hash_original_field = "7F0D3E106C4186D49F5A032C595DAB7F", hash_generated_field = "7BCEBB59C72493A4171C129F8BF3BCC8")

        public UUID uuid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.852 -0400", hash_original_field = "9AC230686CAB1066B8CFEC2E8FD6CFCB", hash_generated_field = "ED8519F70D54E98B3C89CB08FC72DBFA")

        public String connectMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.854 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.855 -0400", hash_original_field = "877F32DED6F16AFD533F1320544096D0", hash_generated_field = "7CFFE6797A0716524096EE6C42832465")

        public String implementor;

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.844 -0400", hash_original_method = "9B72BF45C1BBE88E29AA7545C060A95C", hash_generated_method = "09BE698700CDABD0979D60778213573F")
        
public Descriptor() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.846 -0400", hash_original_method = "AF246B07E41CA8FF36266A86BCCA0E1D", hash_generated_method = "7DA887D1629A6591E7E7A879664F3022")
        
public Descriptor(String type, String uuid, String connectMode,
                String name, String implementor) {
            this.type = UUID.fromString(type);
            this.uuid = UUID.fromString(uuid);
            this.connectMode = connectMode;
            this.name = name;
            this.implementor = implementor;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.859 -0400", hash_original_field = "3255CEB46DB075FB75179C345A1C7E1C", hash_generated_field = "C63E1D7BA2B6248F218C44D610DE4D18")

    public static final String EFFECT_INSERT = "Insert";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.861 -0400", hash_original_field = "0F907F9A221568F951B036FAF739B4A6", hash_generated_field = "0E102F671BB5B14B957328E6050442AB")

    public static final String EFFECT_AUXILIARY = "Auxiliary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.863 -0400", hash_original_field = "B291B701792AAE608C5909AE3E1145F4", hash_generated_field = "4D63ED441EF0C39948DA0F9F54637099")

    public static final String EFFECT_PRE_PROCESSING = "Pre Processing";

    // --------------------------------------------------------------------------
    // Effects Enumeration
    // --------------------

    /**
     * Query all effects available on the platform. Returns an array of
     * {@link android.media.audiofx.AudioEffect.Descriptor} objects
     *
     * @throws IllegalStateException
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.892 -0400", hash_original_method = "9AFFC333FFAC3C96C44D9BE6E72ADDE0", hash_generated_method = "F3EE692CA842E22560DA35A469B76F54")
    
static public Descriptor[] queryEffects() {
        return (Descriptor[]) native_query_effects();
    }

    /**
     * Query all audio pre processing effects applied to the AudioRecord with the supplied
     * audio session ID. Returns an array of {@link android.media.audiofx.AudioEffect.Descriptor}
     * objects.
     * @param audioSession system wide unique audio session identifier.
     * @throws IllegalStateException
     * @hide
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.895 -0400", hash_original_method = "D18A0E19DF342723C4D77761FEFF292C", hash_generated_method = "73F3801D23F87698CA6A087604E1FD28")
    
static public Descriptor[] queryPreProcessings(int audioSession) {
        return (Descriptor[]) native_query_pre_processing(audioSession);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.944 -0400", hash_original_field = "F9F0EC9155B984EB0967107D99547175", hash_generated_field = "4ED727B2FCDA4806923B145D936A98B7")

    // Audio Effect Control panel intents
    // -------------------------------------------------------------------------

    /**
     *  Intent to launch an audio effect control panel UI.
     *  <p>The goal of this intent is to enable separate implementations of music/media player
     *  applications and audio effect control application or services.
     *  This will allow platform vendors to offer more advanced control options for standard effects
     *  or control for platform specific effects.
     *  <p>The intent carries a number of extras used by the player application to communicate
     *  necessary pieces of information to the control panel application.
     *  <p>The calling application must use the
     *  {@link android.app.Activity#startActivityForResult(Intent, int)} method to launch the
     *  control panel so that its package name is indicated and used by the control panel
     *  application to keep track of changes for this particular application.
     *  <p>The {@link #EXTRA_AUDIO_SESSION} extra will indicate an audio session to which the
     *  audio effects should be applied. If no audio session is specified, either one of the
     *  follownig will happen:
     *  <p>- If an audio session was previously opened by the calling application with
     *  {@link #ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION} intent, the effect changes will
     *  be applied to that session.
     *  <p>- If no audio session is opened, the changes will be stored in the package specific
     *  storage area and applied whenever a new audio session is opened by this application.
     *  <p>The {@link #EXTRA_CONTENT_TYPE} extra will help the control panel application
     *  customize both the UI layout and the default audio effect settings if none are already
     *  stored for the calling application.
     */
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL =
        "android.media.action.DISPLAY_AUDIO_EFFECT_CONTROL_PANEL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.947 -0400", hash_original_field = "4CEAC791DFB1235D37ADEE699269C61A", hash_generated_field = "59F807EE4CF6206822AADE3FF440F620")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_OPEN_AUDIO_EFFECT_CONTROL_SESSION =
        "android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.949 -0400", hash_original_field = "3FB08EF4BAF27BF6C90F8E206DF96A2A", hash_generated_field = "0B61008FB3909D11E857B4CF9DA79988")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_CLOSE_AUDIO_EFFECT_CONTROL_SESSION =
        "android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.951 -0400", hash_original_field = "52E67C3B90D6188579C0AC718AF24B40", hash_generated_field = "0AD096874EF18793E43623B75710FFB4")

     public static final String EXTRA_AUDIO_SESSION = "android.media.extra.AUDIO_SESSION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.953 -0400", hash_original_field = "08DAD673EB5CDA09C51E8E5452CC1C06", hash_generated_field = "7D7712DF5EBA180C736D85C2D963400D")

    public static final String EXTRA_PACKAGE_NAME = "android.media.extra.PACKAGE_NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.956 -0400", hash_original_field = "2A8D36820E977CBECA4BCEFCB7C0FEE1", hash_generated_field = "1009AC91868849A81BB5D5C253AE54EB")

    public static final String EXTRA_CONTENT_TYPE = "android.media.extra.CONTENT_TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.958 -0400", hash_original_field = "61F2C42F79DD6F1226B897007397F3D7", hash_generated_field = "5F2F615FE255DE74CE6D32D1711496A1")

    public static final int  CONTENT_TYPE_MUSIC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.960 -0400", hash_original_field = "95E64774CEF650CA658BDE0A9DED1F17", hash_generated_field = "DECEB06B14EE653572D0C9D5053CAD7F")

    public static final int  CONTENT_TYPE_MOVIE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.962 -0400", hash_original_field = "02D5096A514B36CF21CCF7A75AB31CD0", hash_generated_field = "08FFC5BA7EC3CCFE2C1D25C244587C77")

    public static final int  CONTENT_TYPE_GAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.964 -0400", hash_original_field = "BCBD33E28CAB7F44BE0ED9872C963918", hash_generated_field = "954B1B9BA5001EE6F8E8991F32045624")

    public static final int  CONTENT_TYPE_VOICE = 3;

    // ---------------------------------------------------------
    // Java methods called from the native side
    // --------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.974 -0400", hash_original_method = "02A2AEA8ACD3AC4F16660C36EFBABF7A", hash_generated_method = "1FD15A87BCE2F5E22E8CE299B6394C89")
    
@SuppressWarnings("unused")
    private static void postEventFromNative(Object effect_ref, int what,
            int arg1, int arg2, Object obj) {
        AudioEffect effect = (AudioEffect) ((WeakReference) effect_ref).get();
        if (effect == null) {
            return;
        }
        if (effect.mNativeEventHandler != null) {
            Message m = effect.mNativeEventHandler.obtainMessage(what, arg1,
                    arg2, obj);
            effect.mNativeEventHandler.sendMessage(m);
        }

    }

    // ---------------------------------------------------------
    // Native methods called from the Java side
    // --------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.977 -0400", hash_original_method = "9DACEB091913AFFD29EB0CE9882462AB", hash_generated_method = "0F83FA23DF600A99662CB2DCA62BFB26")
    
    private static final void native_init(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:48.830 -0400", hash_original_method = "BCE9F9041FEF8ABC6EDFF277AA2FC9D9", hash_generated_method = "682771B6E949BA0C778066C8952695D9")
    
    private static Object[] native_query_effects(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	Object[] retObj = new Object[1]; 
    	retObj[0] = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.753 -0400", hash_original_method = "5C7D3E066BE9994BE3BD3F27F596E58B", hash_generated_method = "1557CE409B69242E0702638EDDC0981E")
    
    private static Object[] native_query_pre_processing(int audioSession){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += audioSession;
    
    	Object[] retObj = new Object[1]; 
    	retObj[0] = new Object(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.011 -0400", hash_original_method = "1FD132332E51B48CB684923C840A3EFB", hash_generated_method = "820095CF22E6D47FB78EE1319E240A6C")
    
public static boolean isError(int status) {
        return (status < 0);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.865 -0400", hash_original_field = "78622F071E041CCB5EEFF5A3BEF9AB78", hash_generated_field = "2BA4F13CE00354FC34619529BEC989D1")

    // Member variables
    // --------------------
    /**
     * Indicates the state of the AudioEffect instance
     */
    private int mState = STATE_UNINITIALIZED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.867 -0400", hash_original_field = "DB8F7F3C2498170622A06B3E94FD6EE0", hash_generated_field = "C7931A0BEAB38320A08BDF3E39CD65DA")

    private final Object mStateLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.869 -0400", hash_original_field = "9F66E723E60E4F10157FDA7C23C67293", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.871 -0400", hash_original_field = "70FC3714E468160D50CB5D366C29FE71", hash_generated_field = "15D0B86FBAD8C76CE4ADF0932C7553D1")

    private int mNativeAudioEffect;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.872 -0400", hash_original_field = "CD27E77ABE959434B144B34D81D41594", hash_generated_field = "2042284B36B7A02EA029B5A72AE30FF2")

    private int mJniData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.874 -0400", hash_original_field = "546C5EA1F7125CB2A0BA959508CA43E3", hash_generated_field = "21C6CE8B4567A4FBFFD63726D7D05020")

    private Descriptor mDescriptor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.876 -0400", hash_original_field = "4A583CEB2F59452343E693AE6E0048A4", hash_generated_field = "96E4AC3359ED8F77154250D62BFF92E3")

    private OnEnableStatusChangeListener mEnableStatusChangeListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.878 -0400", hash_original_field = "4D8E667C0A957440172384A7327B7BE7", hash_generated_field = "6C177A57E8C9CA86AD3EF83845A6E5ED")

    private OnControlStatusChangeListener mControlChangeStatusListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.879 -0400", hash_original_field = "9AFAE484D6D19FC8C85FE7A0017F514A", hash_generated_field = "32C878BD06C04B5276112E305FB2FAD8")

    private OnParameterChangeListener mParameterChangeListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.881 -0400", hash_original_field = "BB69DF3FD62D97D9C1B852C5B017E79B", hash_generated_field = "F9560BD3B20816BED179F8E7096E7F5B")

    public final Object mListenerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.883 -0400", hash_original_field = "A66ACE8F39ECFCBCDABD1068522C9535", hash_generated_field = "9BFB078EACEA2C6A00BB1F39FD9E10D9")

    public NativeEventHandler mNativeEventHandler = null;

    // --------------------------------------------------------------------------
    // Constructor, Finalize
    // --------------------
    /**
     * Class constructor.
     *
     * @param type type of effect engine created. See {@link #EFFECT_TYPE_ENV_REVERB},
     *            {@link #EFFECT_TYPE_EQUALIZER} ... Types corresponding to
     *            built-in effects are defined by AudioEffect class. Other types
     *            can be specified provided they correspond an existing OpenSL
     *            ES interface ID and the corresponsing effect is available on
     *            the platform. If an unspecified effect type is requested, the
     *            constructor with throw the IllegalArgumentException. This
     *            parameter can be set to {@link #EFFECT_TYPE_NULL} in which
     *            case only the uuid will be used to select the effect.
     * @param uuid unique identifier of a particular effect implementation.
     *            Must be specified if the caller wants to use a particular
     *            implementation of an effect type. This parameter can be set to
     *            {@link #EFFECT_TYPE_NULL} in which case only the type will
     *            be used to select the effect.
     * @param priority the priority level requested by the application for
     *            controlling the effect engine. As the same effect engine can
     *            be shared by several applications, this parameter indicates
     *            how much the requesting application needs control of effect
     *            parameters. The normal priority is 0, above normal is a
     *            positive number, below normal a negative number.
     * @param audioSession system wide unique audio session identifier.
     *            The effect will be attached to the MediaPlayer or AudioTrack in
     *            the same audio session.
     *
     * @throws java.lang.IllegalArgumentException
     * @throws java.lang.UnsupportedOperationException
     * @throws java.lang.RuntimeException
     * @hide
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.885 -0400", hash_original_method = "4B8F4671DB050940FAF45CA383464E3B", hash_generated_method = "28B413AA240F37B8266560C626F2DB39")
    
public AudioEffect(UUID type, UUID uuid, int priority, int audioSession)
            throws IllegalArgumentException, UnsupportedOperationException,
            RuntimeException {
        int[] id = new int[1];
        Descriptor[] desc = new Descriptor[1];
        // native initialization
        int initResult = native_setup(new WeakReference<AudioEffect>(this),
                type.toString(), uuid.toString(), priority, audioSession, id,
                desc);
        if (initResult != SUCCESS && initResult != ALREADY_EXISTS) {
            Log.e(TAG, "Error code " + initResult
                    + " when initializing AudioEffect.");
            switch (initResult) {
            case ERROR_BAD_VALUE:
                throw (new IllegalArgumentException("Effect type: " + type
                        + " not supported."));
            case ERROR_INVALID_OPERATION:
                throw (new UnsupportedOperationException(
                        "Effect library not loaded"));
            default:
                throw (new RuntimeException(
                        "Cannot initialize effect engine for type: " + type
                                + "Error: " + initResult));
            }
        }
        mId = id[0];
        mDescriptor = desc[0];
        synchronized (mStateLock) {
            mState = STATE_INITIALIZED;
        }
    }

    /**
     * Releases the native AudioEffect resources. It is a good practice to
     * release the effect engine when not in use as control can be returned to
     * other applications or the native resources released.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.887 -0400", hash_original_method = "419AE57F1F4F3771FE7C034911087106", hash_generated_method = "AC815385DD29FED51EAF380C6278E8B3")
    
public void release() {
        synchronized (mStateLock) {
            native_release();
            mState = STATE_UNINITIALIZED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.889 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() {
        native_finalize();
    }

    /**
     * Get the effect descriptor.
     *
     * @see android.media.audiofx.AudioEffect.Descriptor
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.891 -0400", hash_original_method = "138D3C15A25FFD08EDB3FB2E418884CF", hash_generated_method = "8AFEF3B6602425845499964BA05D680A")
    
public Descriptor getDescriptor() throws IllegalStateException {
        checkState("getDescriptor()");
        return mDescriptor;
    }

    // --------------------------------------------------------------------------
    // Control methods
    // --------------------

    /**
     * Enable or disable the effect.
     * Creating an audio effect does not automatically apply this effect on the audio source. It
     * creates the resources necessary to process this effect but the audio signal is still bypassed
     * through the effect engine. Calling this method will make that the effect is actually applied
     * or not to the audio content being played in the corresponding audio session.
     *
     * @param enabled the requested enable state
     * @return {@link #SUCCESS} in case of success, {@link #ERROR_INVALID_OPERATION}
     *         or {@link #ERROR_DEAD_OBJECT} in case of failure.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.896 -0400", hash_original_method = "7C8121286F60453C4FA9DF17C766AD9C", hash_generated_method = "4D6B2B47056E60C85B86458283D9C065")
    
public int setEnabled(boolean enabled) throws IllegalStateException {
        checkState("setEnabled()");
        return native_setEnabled(enabled);
    }

    /**
     * Set effect parameter. The setParameter method is provided in several
     * forms addressing most common parameter formats. This form is the most
     * generic one where the parameter and its value are both specified as an
     * array of bytes. The parameter and value type and length are therefore
     * totally free. For standard effect defined by OpenSL ES, the parameter
     * format and values must match the definitions in the corresponding OpenSL
     * ES interface.
     *
     * @param param the identifier of the parameter to set
     * @param value the new value for the specified parameter
     * @return {@link #SUCCESS} in case of success, {@link #ERROR_BAD_VALUE},
     *         {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or
     *         {@link #ERROR_DEAD_OBJECT} in case of failure
     * @throws IllegalStateException
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.898 -0400", hash_original_method = "409524C3D1B05CF5AACE8F87436EAEE1", hash_generated_method = "C72525C882D478A2C757303AD58CBDED")
    
public int setParameter(byte[] param, byte[] value)
            throws IllegalStateException {
        checkState("setParameter()");
        return native_setParameter(param.length, param, value.length, value);
    }

    /**
     * Set effect parameter. The parameter and its value are integers.
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.900 -0400", hash_original_method = "B1C5CEF07F2AB47C68E197CF4C686C81", hash_generated_method = "4D5C7F401216ADC980F5680C29096631")
    
public int setParameter(int param, int value) throws IllegalStateException {
        byte[] p = intToByteArray(param);
        byte[] v = intToByteArray(value);
        return setParameter(p, v);
    }

    /**
     * Set effect parameter. The parameter is an integer and the value is a
     * short integer.
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.902 -0400", hash_original_method = "2DC02BB021008AFD8B50585CBF965675", hash_generated_method = "B0978944ACC0B52AC75CE9F1227140B0")
    
public int setParameter(int param, short value)
            throws IllegalStateException {
        byte[] p = intToByteArray(param);
        byte[] v = shortToByteArray(value);
        return setParameter(p, v);
    }

    /**
     * Set effect parameter. The parameter is an integer and the value is an
     * array of bytes.
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.904 -0400", hash_original_method = "086B464E8750581574662B3C75679252", hash_generated_method = "6BECEA94643F975E318F303F94722CC6")
    
public int setParameter(int param, byte[] value)
            throws IllegalStateException {
        byte[] p = intToByteArray(param);
        return setParameter(p, value);
    }

    /**
     * Set effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is also an array of 1 or 2 integers
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.906 -0400", hash_original_method = "34342DBFC017444B67A0DBE66B6437EF", hash_generated_method = "BC17849C10FE56882E5BD5F81DC367A7")
    
public int setParameter(int[] param, int[] value)
            throws IllegalStateException {
        if (param.length > 2 || value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }
        byte[] v = intToByteArray(value[0]);
        if (value.length > 1) {
            byte[] v2 = intToByteArray(value[1]);
            v = concatArrays(v, v2);
        }
        return setParameter(p, v);
    }

    /**
     * Set effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is an array of 1 or 2 short integers
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.907 -0400", hash_original_method = "AE94FC31AD0EAA9FB7348B09499E1BE8", hash_generated_method = "3188BE9EF88DF710ABA66C94332B43F3")
    
public int setParameter(int[] param, short[] value)
            throws IllegalStateException {
        if (param.length > 2 || value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }

        byte[] v = shortToByteArray(value[0]);
        if (value.length > 1) {
            byte[] v2 = shortToByteArray(value[1]);
            v = concatArrays(v, v2);
        }
        return setParameter(p, v);
    }

    /**
     * Set effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is an array of bytes
     *
     * @see #setParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.910 -0400", hash_original_method = "93D5F756A38520287DAD333ECFDB8695", hash_generated_method = "C27F011826C0626D8F7F27541E4789CE")
    
public int setParameter(int[] param, byte[] value)
            throws IllegalStateException {
        if (param.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }
        return setParameter(p, value);
    }

    // ---------------------------------------------------------
    // Interface definitions
    // --------------------
    /**
     * The OnEnableStatusChangeListener interface defines a method called by the AudioEffect
     * when a the enabled state of the effect engine was changed by the controlling application.
     */
    public interface OnEnableStatusChangeListener {
        /**
         * Called on the listener to notify it that the effect engine has been
         * enabled or disabled.
         * @param effect the effect on which the interface is registered.
         * @param enabled new effect state.
         */
        void onEnableStatusChange(AudioEffect effect, boolean enabled);
    }

    /**
     * The OnControlStatusChangeListener interface defines a method called by the AudioEffect
     * when a the control of the effect engine is gained or lost by the application
     */
    public interface OnControlStatusChangeListener {
        /**
         * Called on the listener to notify it that the effect engine control
         * has been taken or returned.
         * @param effect the effect on which the interface is registered.
         * @param controlGranted true if the application has been granted control of the effect
         * engine, false otherwise.
         */
        void onControlStatusChange(AudioEffect effect, boolean controlGranted);
    }

    /**
     * The OnParameterChangeListener interface defines a method called by the AudioEffect
     * when a parameter is changed in the effect engine by the controlling application.
     * @hide
     */
    public interface OnParameterChangeListener {
        /**
         * Called on the listener to notify it that a parameter value has changed.
         * @param effect the effect on which the interface is registered.
         * @param status status of the set parameter operation.
         * @param param ID of the modified parameter.
         * @param value the new parameter value.
         */
        void onParameterChange(AudioEffect effect, int status, byte[] param,
                byte[] value);
    }

    /**
     * Get effect parameter. The getParameter method is provided in several
     * forms addressing most common parameter formats. This form is the most
     * generic one where the parameter and its value are both specified as an
     * array of bytes. The parameter and value type and length are therefore
     * totally free.
     *
     * @param param the identifier of the parameter to set
     * @param value the new value for the specified parameter
     * @return the number of meaningful bytes in value array in case of success or
     *  {@link #ERROR_BAD_VALUE}, {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION}
     *  or {@link #ERROR_DEAD_OBJECT} in case of failure.
     * @throws IllegalStateException
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.912 -0400", hash_original_method = "700977294ADFE70496ACC5DF2BF576D1", hash_generated_method = "0FF2463DD4BAE33C586C1540CFE3D6AA")
    
public int getParameter(byte[] param, byte[] value)
            throws IllegalStateException {
        checkState("getParameter()");
        return native_getParameter(param.length, param, value.length, value);
    }

    /**
     * Get effect parameter. The parameter is an integer and the value is an
     * array of bytes.
     *
     * @see #getParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.913 -0400", hash_original_method = "43A488A35686D01AD57C707A1A891DBD", hash_generated_method = "ADB3D53C6E9FC8E7BC56FA4E6FA3D5C0")
    
public int getParameter(int param, byte[] value)
            throws IllegalStateException {
        byte[] p = intToByteArray(param);

        return getParameter(p, value);
    }

    /**
     * Get effect parameter. The parameter is an integer and the value is an
     * array of 1 or 2 integers
     *
     * @see #getParameter(byte[], byte[])
     * In case of success, returns the number of meaningful integers in value array.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.915 -0400", hash_original_method = "D8BBD37EFE262940B51D9F9C68B696DE", hash_generated_method = "C79E66CE99A47D58EFC6F57A4ED9CE54")
    
public int getParameter(int param, int[] value)
            throws IllegalStateException {
        if (value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param);

        byte[] v = new byte[value.length * 4];

        int status = getParameter(p, v);

        if (status == 4 || status == 8) {
            value[0] = byteArrayToInt(v);
            if (status == 8) {
                value[1] = byteArrayToInt(v, 4);
            }
            status /= 4;
        } else {
            status = ERROR;
        }
        return status;
    }

    /**
     * Get effect parameter. The parameter is an integer and the value is an
     * array of 1 or 2 short integers
     *
     * @see #getParameter(byte[], byte[])
     * In case of success, returns the number of meaningful short integers in value array.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.918 -0400", hash_original_method = "E0C54C5485DA652D5D0AC77997EE695E", hash_generated_method = "8D6EEF7704EF0DA5F6552CC966798B4A")
    
public int getParameter(int param, short[] value)
            throws IllegalStateException {
        if (value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param);

        byte[] v = new byte[value.length * 2];

        int status = getParameter(p, v);

        if (status == 2 || status == 4) {
            value[0] = byteArrayToShort(v);
            if (status == 4) {
                value[1] = byteArrayToShort(v, 2);
            }
            status /= 2;
        } else {
            status = ERROR;
        }
        return status;
    }

    /**
     * Get effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is also an array of 1 or 2 integers
     *
     * @see #getParameter(byte[], byte[])
     * In case of success, the returns the number of meaningful integers in value array.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.920 -0400", hash_original_method = "FBE653594AB11EFD942A23D0F42E6BDF", hash_generated_method = "DB9B3EAAA961FF5D50918406A2F115FC")
    
public int getParameter(int[] param, int[] value)
            throws IllegalStateException {
        if (param.length > 2 || value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }
        byte[] v = new byte[value.length * 4];

        int status = getParameter(p, v);

        if (status == 4 || status == 8) {
            value[0] = byteArrayToInt(v);
            if (status == 8) {
                value[1] = byteArrayToInt(v, 4);
            }
            status /= 4;
        } else {
            status = ERROR;
        }
        return status;
    }

    /**
     * Get effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is an array of 1 or 2 short integers
     *
     * @see #getParameter(byte[], byte[])
     * In case of success, returns the number of meaningful short integers in value array.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.922 -0400", hash_original_method = "E14D6EA28E3B68E68AA67A6059D7316D", hash_generated_method = "ED9EF4944A5D75113AF7B680CD6DD273")
    
public int getParameter(int[] param, short[] value)
            throws IllegalStateException {
        if (param.length > 2 || value.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }
        byte[] v = new byte[value.length * 2];

        int status = getParameter(p, v);

        if (status == 2 || status == 4) {
            value[0] = byteArrayToShort(v);
            if (status == 4) {
                value[1] = byteArrayToShort(v, 2);
            }
            status /= 2;
        } else {
            status = ERROR;
        }
        return status;
    }

    /**
     * Get effect parameter. The parameter is an array of 1 or 2 integers and
     * the value is an array of bytes
     *
     * @see #getParameter(byte[], byte[])
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.924 -0400", hash_original_method = "A0D6AE624583D66B8994CE41D29686A1", hash_generated_method = "DC1467259719B888DB0E108BEEF70B4F")
    
public int getParameter(int[] param, byte[] value)
            throws IllegalStateException {
        if (param.length > 2) {
            return ERROR_BAD_VALUE;
        }
        byte[] p = intToByteArray(param[0]);
        if (param.length > 1) {
            byte[] p2 = intToByteArray(param[1]);
            p = concatArrays(p, p2);
        }

        return getParameter(p, value);
    }

    /**
     * Send a command to the effect engine. This method is intended to send
     * proprietary commands to a particular effect implementation.
     * In case of success, returns the number of meaningful bytes in reply array.
     * In case of failure, the returned value is negative and implementation specific.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.926 -0400", hash_original_method = "2D8F1F190AC6544C78D8AFB140AECD58", hash_generated_method = "EEDF1A90063CF48AD2A66942559AE294")
    
public int command(int cmdCode, byte[] command, byte[] reply)
            throws IllegalStateException {
        checkState("command()");
        return native_command(cmdCode, command.length, command, reply.length, reply);
    }

    // --------------------------------------------------------------------------
    // Getters
    // --------------------

    /**
     * Returns effect unique identifier. This system wide unique identifier can
     * be used to attach this effect to a MediaPlayer or an AudioTrack when the
     * effect is an auxiliary effect (Reverb)
     *
     * @return the effect identifier.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.927 -0400", hash_original_method = "831367E372322474A43BA4F9F454D5B7", hash_generated_method = "1252F58F587092ABFA3C5AB3383843DC")
    
public int getId() throws IllegalStateException {
        checkState("getId()");
        return mId;
    }

    /**
     * Returns effect enabled state
     *
     * @return true if the effect is enabled, false otherwise.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.929 -0400", hash_original_method = "DCB1708901B64725A76C0649F5C405F4", hash_generated_method = "549D215ECD29B71ABC2C6DE1C747A0E9")
    
public boolean getEnabled() throws IllegalStateException {
        checkState("getEnabled()");
        return native_getEnabled();
    }

    // ---------------------------------------------------------
    // Inner classes
    // --------------------
    /**
     * Helper class to handle the forwarding of native events to the appropriate
     * listeners
     */
    private class NativeEventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.966 -0400", hash_original_field = "1AD5281A9E3814B3722CEA0D8B23D05E", hash_generated_field = "7E376175DA9B1ED434B5079DBE674AB5")

        private AudioEffect mAudioEffect;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.968 -0400", hash_original_method = "3A548E11F6204DE2EC0DBFF36EFCFF01", hash_generated_method = "A61DF62E3F52956AB69221E36C58999E")
        
public NativeEventHandler(AudioEffect ae, Looper looper) {
            super(looper);
            mAudioEffect = ae;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.971 -0400", hash_original_method = "C289DC395E4E26362FC1998C3447C245", hash_generated_method = "D142DA7ABE6DA323BDA789EE9C977D14")
        
@Override
        public void handleMessage(Message msg) {
            if (mAudioEffect == null) {
                return;
            }
            switch (msg.what) {
            case NATIVE_EVENT_ENABLED_STATUS:
                OnEnableStatusChangeListener enableStatusChangeListener = null;
                synchronized (mListenerLock) {
                    enableStatusChangeListener = mAudioEffect.mEnableStatusChangeListener;
                }
                if (enableStatusChangeListener != null) {
                    enableStatusChangeListener.onEnableStatusChange(
                            mAudioEffect, (boolean) (msg.arg1 != 0));
                }
                break;
            case NATIVE_EVENT_CONTROL_STATUS:
                OnControlStatusChangeListener controlStatusChangeListener = null;
                synchronized (mListenerLock) {
                    controlStatusChangeListener = mAudioEffect.mControlChangeStatusListener;
                }
                if (controlStatusChangeListener != null) {
                    controlStatusChangeListener.onControlStatusChange(
                            mAudioEffect, (boolean) (msg.arg1 != 0));
                }
                break;
            case NATIVE_EVENT_PARAMETER_CHANGED:
                OnParameterChangeListener parameterChangeListener = null;
                synchronized (mListenerLock) {
                    parameterChangeListener = mAudioEffect.mParameterChangeListener;
                }
                if (parameterChangeListener != null) {
                    // arg1 contains offset of parameter value from start of
                    // byte array
                    int vOffset = msg.arg1;
                    byte[] p = (byte[]) msg.obj;
                    // See effect_param_t in EffectApi.h for psize and vsize
                    // fields offsets
                    int status = byteArrayToInt(p, 0);
                    int psize = byteArrayToInt(p, 4);
                    int vsize = byteArrayToInt(p, 8);
                    byte[] param = new byte[psize];
                    byte[] value = new byte[vsize];
                    System.arraycopy(p, 12, param, 0, psize);
                    System.arraycopy(p, vOffset, value, 0, vsize);

                    parameterChangeListener.onParameterChange(mAudioEffect,
                            status, param, value);
                }
                break;

            default:
                Log.e(TAG, "handleMessage() Unknown event type: " + msg.what);
                break;
            }
        }
    }

    /**
     * Checks if this AudioEffect object is controlling the effect engine.
     *
     * @return true if this instance has control of effect engine, false
     *         otherwise.
     * @throws IllegalStateException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.931 -0400", hash_original_method = "48463A559B9DBAAC92594F70F7C217BA", hash_generated_method = "25344FFB99768FD4CAAD74E54E331E3A")
    
public boolean hasControl() throws IllegalStateException {
        checkState("hasControl()");
        return native_hasControl();
    }

    // --------------------------------------------------------------------------
    // Initialization / configuration
    // --------------------
    /**
     * Sets the listener AudioEffect notifies when the effect engine is enabled
     * or disabled.
     *
     * @param listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.932 -0400", hash_original_method = "A2F0E0ACB6B9D1A474C4232A753CA919", hash_generated_method = "B931F5CCA9A98B2167EF6E9BD83A277B")
    
public void setEnableStatusListener(OnEnableStatusChangeListener listener) {
        synchronized (mListenerLock) {
            mEnableStatusChangeListener = listener;
        }
        if ((listener != null) && (mNativeEventHandler == null)) {
            createNativeEventHandler();
        }
    }

    /**
     * Sets the listener AudioEffect notifies when the effect engine control is
     * taken or returned.
     *
     * @param listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.934 -0400", hash_original_method = "B30B7812B780CE37728EE90993757261", hash_generated_method = "06A050C7282AF623762BBB39A6077A96")
    
public void setControlStatusListener(OnControlStatusChangeListener listener) {
        synchronized (mListenerLock) {
            mControlChangeStatusListener = listener;
        }
        if ((listener != null) && (mNativeEventHandler == null)) {
            createNativeEventHandler();
        }
    }

    /**
     * Sets the listener AudioEffect notifies when a parameter is changed.
     *
     * @param listener
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.936 -0400", hash_original_method = "07594D8AEB5CAA92E79983707D19AA80", hash_generated_method = "6C27C1D13B657E7CD0162DDF3470CCA9")
    
public void setParameterListener(OnParameterChangeListener listener) {
        synchronized (mListenerLock) {
            mParameterChangeListener = listener;
        }
        if ((listener != null) && (mNativeEventHandler == null)) {
            createNativeEventHandler();
        }
    }

    // Convenience method for the creation of the native event handler
    // It is called only when a non-null event listener is set.
    // precondition:
    // mNativeEventHandler is null
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.937 -0400", hash_original_method = "7F02F354668B855EFF5919F9CB2BC11F", hash_generated_method = "8E4C43F412BECD15C1062214B4F06FB0")
    
private void createNativeEventHandler() {
        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mNativeEventHandler = new NativeEventHandler(this, looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mNativeEventHandler = new NativeEventHandler(this, looper);
        } else {
            mNativeEventHandler = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.713 -0400", hash_original_method = "5D6CD1A30C17C3ACA370A9DD3B54636D", hash_generated_method = "00FE8E1F4E4FB46D0522310785219892")
    
    private final int native_setup(Object audioeffect_this, String type,
                String uuid, int priority, int audioSession, int[] id, Object[] desc){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += audioeffect_this.getTaintInt();
    	taintDouble += type.getTaintInt();
    	taintDouble += uuid.getTaintInt();
    	taintDouble += priority;
    	taintDouble += audioSession;
    	taintDouble += id[0];
    	taintDouble += desc[0].getTaintInt();
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:00.203 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:00.205 -0400", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
    
    private final void native_release(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:58.806 -0400", hash_original_method = "8872A9008E31C58C242D4CD0A2B35F1D", hash_generated_method = "6AC133F2EB7938350B7CB15E3D6BE052")
    
    private final int native_setEnabled(boolean enabled){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += toTaintInt(enabled);
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:48.815 -0400", hash_original_method = "2AFB9A522158996345CFEAF824256F69", hash_generated_method = "1D026D1C1A92C3AAEEBB96B2B79A68C7")
    
    private final boolean native_getEnabled(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:48.818 -0400", hash_original_method = "E8B71D39962D5FE9E08B8EAE5FFF8FCD", hash_generated_method = "3C579DE3694F25FC8AFA44571273A968")
    
    private final boolean native_hasControl(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.737 -0400", hash_original_method = "5898858D61B878A2FF924C9A717767D0", hash_generated_method = "8EA4383B0E5C79D993423BEF795C939F")
    
    private final int native_setParameter(int psize, byte[] param,
                int vsize, byte[] value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += psize;
    	taintDouble += param[0];
    	taintDouble += vsize;
    	taintDouble += value[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.741 -0400", hash_original_method = "7B0B65B6D131A87ABD3AF9287F1A89AF", hash_generated_method = "ED70136A22EA84A541DB1B0B0AA4D463")
    
    private final int native_getParameter(int psize, byte[] param,
                int vsize, byte[] value){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += psize;
    	taintDouble += param[0];
    	taintDouble += vsize;
    	taintDouble += value[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.745 -0400", hash_original_method = "27A0B8B4CE0CEAD0376392AAEE9A2F1A", hash_generated_method = "7CF45BC46090FCD219E8379574A1F6A2")
    
    private final int native_command(int cmdCode, int cmdSize,
                byte[] cmdData, int repSize, byte[] repData){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += cmdCode;
    	taintDouble += cmdSize;
    	taintDouble += cmdData[0];
    	taintDouble += repSize;
    	taintDouble += repData[0];
    	addTaint(taintDouble);
    
    	return (int)taintDouble;
    }

    // ---------------------------------------------------------
    // Utility methods
    // ------------------

    /**
    * @hide
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.007 -0400", hash_original_method = "9CCAD0A0808E141A9BF1EC65BFA1E916", hash_generated_method = "F944BB1E858EE5A08605BF7B65A2F0C6")
    
public void checkState(String methodName) throws IllegalStateException {
        synchronized (mStateLock) {
            if (mState != STATE_INITIALIZED) {
                throw (new IllegalStateException(methodName
                        + " called on uninitialized AudioEffect."));
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.009 -0400", hash_original_method = "C1C655C5D849522018D702DE17BAF9DA", hash_generated_method = "100D4D528D50910E8377402586552E94")
    
public void checkStatus(int status) {
        if (isError(status)) {
            switch (status) {
            case AudioEffect.ERROR_BAD_VALUE:
                throw (new IllegalArgumentException(
                        "AudioEffect: bad parameter value"));
            case AudioEffect.ERROR_INVALID_OPERATION:
                throw (new UnsupportedOperationException(
                        "AudioEffect: invalid parameter operation"));
            default:
                throw (new RuntimeException("AudioEffect: set/get parameter error"));
            }
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.013 -0400", hash_original_method = "73B0287734A51BD9F7B9CAB56F3A8079", hash_generated_method = "30CCA69916B24F1705880056431C2787")
    
public int byteArrayToInt(byte[] valueBuf) {
        return byteArrayToInt(valueBuf, 0);

    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.015 -0400", hash_original_method = "DE04BA9DF85F47DD9ABD886D778BDAB2", hash_generated_method = "476C4282954816CB05C7699BD6B917F4")
    
public int byteArrayToInt(byte[] valueBuf, int offset) {
        ByteBuffer converter = ByteBuffer.wrap(valueBuf);
        converter.order(ByteOrder.nativeOrder());
        return converter.getInt(offset);

    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.017 -0400", hash_original_method = "BE85815F7A9637CC75F8561F9D6AD013", hash_generated_method = "84D3F5183DBDA5D45A21CF37FB2373C8")
    
public byte[] intToByteArray(int value) {
        ByteBuffer converter = ByteBuffer.allocate(4);
        converter.order(ByteOrder.nativeOrder());
        converter.putInt(value);
        return converter.array();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.018 -0400", hash_original_method = "ACA427178AA2D48AC3EDEDD28183F911", hash_generated_method = "11FC95CF08314108BEC8390730D76A51")
    
public short byteArrayToShort(byte[] valueBuf) {
        return byteArrayToShort(valueBuf, 0);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.020 -0400", hash_original_method = "482140EA08661FDFF03578D54E85BDBB", hash_generated_method = "C3D53774A736C543296A91A078ED4214")
    
public short byteArrayToShort(byte[] valueBuf, int offset) {
        ByteBuffer converter = ByteBuffer.wrap(valueBuf);
        converter.order(ByteOrder.nativeOrder());
        return converter.getShort(offset);

    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.022 -0400", hash_original_method = "4DF1FD6194EECDC72FC6689E782D2F4C", hash_generated_method = "37340C17407F3FE4BE2A48E2DC078D72")
    
public byte[] shortToByteArray(short value) {
        ByteBuffer converter = ByteBuffer.allocate(2);
        converter.order(ByteOrder.nativeOrder());
        short sValue = (short) value;
        converter.putShort(sValue);
        return converter.array();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:16.024 -0400", hash_original_method = "EF98A698EB746B3CB9898D7860214C85", hash_generated_method = "FE511A4F2A9D9FEA46E54DB074BD4BCA")
    
public byte[] concatArrays(byte[]... arrays) {
        int len = 0;
        for (byte[] a : arrays) {
            len += a.length;
        }
        byte[] b = new byte[len];

        int offs = 0;
        for (byte[] a : arrays) {
            System.arraycopy(a, 0, b, offs, a.length);
            offs += a.length;
        }
        return b;
    }
}
