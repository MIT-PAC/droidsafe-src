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
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.CloneNotSupportedException;

import android.content.res.AssetFileDescriptor;
import android.os.Looper;
import android.os.Handler;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.util.Log;

/**
 * JetPlayer provides access to JET content playback and control.
 * 
 * <p>Please refer to the JET Creator User Manual for a presentation of the JET interactive
 * music concept and how to use the JetCreator tool to create content to be player by JetPlayer.
 * 
 * <p>Use of the JetPlayer class is based around the playback of a number of JET segments
 * sequentially added to a playback FIFO queue. The rendering of the MIDI content stored in each
 * segment can be dynamically affected by two mechanisms:
 * <ul>
 * <li>tracks in a segment can be muted or unmuted at any moment, individually or through
 *    a mask (to change the mute state of multiple tracks at once)</li>
 * <li>parts of tracks in a segment can be played at predefined points in the segment, in order
 *    to maintain synchronization with the other tracks in the segment. This is achieved through
 *    the notion of "clips", which can be triggered at any time, but that will play only at the
 *    right time, as authored in the corresponding JET file.</li>
 * </ul>
 * As a result of the rendering and playback of the JET segments, the user of the JetPlayer instance
 * can receive notifications from the JET engine relative to:
 * <ul>
 * <li>the playback state,</li>
 * <li>the number of segments left to play in the queue,</li>
 * <li>application controller events (CC80-83) to mark points in the MIDI segments.</li>
 * </ul>
 * Use {@link #getJetPlayer()} to construct a JetPlayer instance. JetPlayer is a singleton class.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use JetPlayer, read the
 * <a href="{@docRoot}guide/topics/media/jetplayer.html">JetPlayer</a> developer guide.</p></div>
 */
public class JetPlayer
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.565 -0400", hash_original_field = "E68025AFF846631F9DDD6F97DBD763AB", hash_generated_field = "AA783EB062EDA447FB12F5515F8BA677")

    // Constants
    //------------------------
    /**
     * The maximum number of simultaneous tracks. Use {@link #getMaxTracks()} to
     * access this value.
     */
    private static int MAXTRACKS = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.567 -0400", hash_original_field = "AC1527B195A2E85BEF50DD059E3C7FF6", hash_generated_field = "5B52188BCA7B5D0C6603132AD9627BA2")

    // defined in frameworks/base/include/media/JetPlayer.h
    private static final int JET_EVENT                   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.569 -0400", hash_original_field = "6B5CA4D199446C7CACCFDCD6F0118FD0", hash_generated_field = "E597F3F21F8FABB46D6C2D0F9A36677B")

    private static final int JET_USERID_UPDATE           = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.571 -0400", hash_original_field = "3A74A36CC282CBAF3B7FA6E8E0D3F500", hash_generated_field = "52685B2D74D86FB10D30B30C00FABF5E")

    private static final int JET_NUMQUEUEDSEGMENT_UPDATE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.573 -0400", hash_original_field = "F1B80FDE73B0C5D846EA53F76479DC48", hash_generated_field = "C9397165608F19B01FF209306182BD72")

    private static final int JET_PAUSE_UPDATE            = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.576 -0400", hash_original_field = "2DC37EF84C40D24B2C99735A06F2202D", hash_generated_field = "7E99DA9E100AEBB174D5D25DBC032481")

    // Encoding of event information on 32 bits
    private static final int JET_EVENT_VAL_MASK    = 0x0000007f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.578 -0400", hash_original_field = "7132BD447AA08E7AFFBA66E57FAF8C93", hash_generated_field = "6AFBE82AA2A764ADAF8A9B276466DD88")

    private static final int JET_EVENT_CTRL_MASK   = 0x00003f80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.580 -0400", hash_original_field = "043D372407F62D51AB14BA875F0B606E", hash_generated_field = "BD2B31C72F0F001E5AABC755FE6DE764")

    private static final int JET_EVENT_CHAN_MASK   = 0x0003c000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.582 -0400", hash_original_field = "85DDE9860B18CE85FCD6D191D39719F4", hash_generated_field = "D550839839766E56EBE3804D908B5D38")

    private static final int JET_EVENT_TRACK_MASK  = 0x00fc0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.584 -0400", hash_original_field = "A169D0DC8B2FF5A37FAB60BA9F0F1E5A", hash_generated_field = "DF82AF084A03AD2744D63444CC6D43DF")

    private static final int JET_EVENT_SEG_MASK    = 0xff000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.586 -0400", hash_original_field = "9E804D25333CD03E5B819AE0BB3E8BB8", hash_generated_field = "B7B4D5BFE93920BC1B4053A111BD4C84")

    private static final int JET_EVENT_CTRL_SHIFT  = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.588 -0400", hash_original_field = "20F426C3D03A3839C3C0B3547D75981C", hash_generated_field = "8DCCBA0B048EAFDFE4D77BF8BAFD319D")

    private static final int JET_EVENT_CHAN_SHIFT  = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.591 -0400", hash_original_field = "8F4A9368E3709EB907F4132339752DAC", hash_generated_field = "3C73738FE5D6301A1A4D17BFEAB3A268")

    private static final int JET_EVENT_TRACK_SHIFT = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.593 -0400", hash_original_field = "5A5593193BDA46FAE62109854D17AC6A", hash_generated_field = "369CE5196BF1DF8A5F228ED14EC544AB")

    private static final int JET_EVENT_SEG_SHIFT   = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.595 -0400", hash_original_field = "439F7310E727F238FB6A37AECDDE0163", hash_generated_field = "1D456669D0FBC84C0F88F7F36136FD11")
    
    // to keep in sync with values used in external/sonivox/arm-wt-22k/Android.mk
    // Jet rendering audio parameters
    private static final int JET_OUTPUT_RATE = 22050;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.597 -0400", hash_original_field = "041EC0739C81714B21DEEBB43D856801", hash_generated_field = "C529593420054BC4B14FCB4D689BAB07")

    private static final int JET_OUTPUT_CHANNEL_CONFIG =
            AudioFormat.CHANNEL_OUT_STEREO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.606 -0400", hash_original_field = "483A2AF7D4FEC5505C677E0967FC0287", hash_generated_field = "08A7D69B264701FB4C7139A1CBF7D967")
    
    private static JetPlayer singletonRef;
    
    //--------------------------------------------
    // Constructor, finalize
    //------------------------
    /**
     * Factory method for the JetPlayer class.
     * @return the singleton JetPlayer instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.610 -0400", hash_original_method = "67524DFF425AD85BEF7609BD2E98B59C", hash_generated_method = "60699F58612739A3BD6408540BE10733")
    
public static JetPlayer getJetPlayer() {
        if (singletonRef == null) {
            singletonRef = new JetPlayer();
        }
        return singletonRef;
    }
    
    //--------------------------------------------
    // Getters
    //------------------------
    /**
     * Returns the maximum number of simultaneous MIDI tracks supported by JetPlayer
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.620 -0400", hash_original_method = "0D1A047032D0BF4489F7BDCED77B5900", hash_generated_method = "7DD5699B446D53F801E8BC61EDC28AFF")
    
public static int getMaxTracks() {
        return JetPlayer.MAXTRACKS;
    }
    
    //---------------------------------------------------------
    // Called exclusively by native code
    //--------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.698 -0400", hash_original_method = "191F0A1515218983B7DDC8DA7F45B650", hash_generated_method = "87712C761E9A93C17F512712E1FAC0F9")
    
@SuppressWarnings("unused")
    private static void postEventFromNative(Object jetplayer_ref,
            int what, int arg1, int arg2) {
        //logd("Event posted from the native side: event="+ what + " args="+ arg1+" "+arg2);
        JetPlayer jet = (JetPlayer)((WeakReference)jetplayer_ref).get();

        if ((jet != null) && (jet.mEventHandler != null)) {
            Message m = 
                jet.mEventHandler.obtainMessage(what, arg1, arg2, null);
            jet.mEventHandler.sendMessage(m);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.700 -0400", hash_original_field = "9DA7180FF723FEA02A3D1E9C48A56918", hash_generated_field = "8CD1C49C6CA25C8F40C4096E25624941")

    // Utils
    //--------------------
    private final static String TAG = "JetPlayer-J";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.702 -0400", hash_original_method = "74C17587BE7C6B1D505C1F9D1E160AF0", hash_generated_method = "79BA00734B1A7B27D4A9D18F865D3890")
    
private static void logd(String msg) {
        Log.d(TAG, "[ android.media.JetPlayer ] " + msg);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.704 -0400", hash_original_method = "DB3A315E83EC221E3ABA76D5BC2F8130", hash_generated_method = "04DC75F781ED440742984C7B26E70A92")
    
private static void loge(String msg) {
        Log.e(TAG, "[ android.media.JetPlayer ] " + msg);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.599 -0400", hash_original_field = "29698EFF4BDA1A12C2604E1C6C5D984E", hash_generated_field = "E9F3B7E4A638D5CE6466FC09BA9A11CF")
    
    //--------------------------------------------
    // Member variables
    //------------------------
    /**
     * Handler for jet events and status updates coming from the native code
     */
    private NativeEventHandler mEventHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.600 -0400", hash_original_field = "D63D01423B881C701A523B73DD4B6259", hash_generated_field = "4A391BD92B92CAB783355948007D2481")

    private Looper mInitializationLooper = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.602 -0400", hash_original_field = "811B5243853F132AAC458CD83F86CC0E", hash_generated_field = "FB818FBD00DBB8A6DBB5012643C472B7")

    private final Object mEventListenerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.604 -0400", hash_original_field = "8CD68628E7ADF52F4951CEB6E7F9FF01", hash_generated_field = "1600516CBE96A7E27DAAB07D89499276")
    
    private OnJetEventListener mJetEventListener = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.608 -0400", hash_original_field = "0192CB31F1FF2639C1A2220C6BF03F75", hash_generated_field = "C24CA9C5A7613664D10DF63528987822")

    // Used exclusively by native code
    //--------------------
    /** 
     * Accessed by native methods: provides access to C++ JetPlayer object 
     */
    @SuppressWarnings("unused")
    private int mNativePlayerInJavaObj;

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.614 -0400", hash_original_method = "9447B9206AACDF5876AD405FE8D8E739", hash_generated_method = "FBD9D904E131D53CB6FC8CBDE8F78381")
    
private JetPlayer() {

        // remember which looper is associated with the JetPlayer instanciation
        if ((mInitializationLooper = Looper.myLooper()) == null) {
            mInitializationLooper = Looper.getMainLooper();
        }
        
        int buffSizeInBytes = AudioTrack.getMinBufferSize(JET_OUTPUT_RATE,
                JET_OUTPUT_CHANNEL_CONFIG, AudioFormat.ENCODING_PCM_16BIT);
        
        if ((buffSizeInBytes != AudioTrack.ERROR) 
                && (buffSizeInBytes != AudioTrack.ERROR_BAD_VALUE)) {
                            
            native_setup(new WeakReference<JetPlayer>(this),
                    JetPlayer.getMaxTracks(),
                    // bytes to frame conversion: sample format is ENCODING_PCM_16BIT, 2 channels
                    // 1200 == minimum buffer size in frames on generation 1 hardware
                    Math.max(1200, buffSizeInBytes / 4));
        }
    }
    
    /**
     * Cloning a JetPlayer instance is not supported. Calling clone() will generate an exception.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.611 -0400", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "05FBB24ED3DB076130C8C063B3ADBEA0")
    
public Object clone() throws CloneNotSupportedException {
        // JetPlayer is a singleton class,
        // so you can't clone a JetPlayer instance
        throw new CloneNotSupportedException();    
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.616 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "0B0876BF1ABAEEEA48DBC201644DDC0B")
    
protected void finalize() { 
        native_finalize(); 
    }
    
    /**
     * Stops the current JET playback, and releases all associated native resources.
     * The object can no longer be used and the reference should be set to null
     * after a call to release().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.618 -0400", hash_original_method = "040A36AC2B3E716253E1C957C2D6F22A", hash_generated_method = "92A8A0885A69F9A2781EF855757FB475")
    
public void release() {
        native_release();
        singletonRef = null;
    }
    
    //--------------------------------------------
    // Jet functionality
    //------------------------
    /**
     * Loads a .jet file from a given path.
     * @param path the path to the .jet file, for instance "/sdcard/mygame/music.jet".
     * @return true if loading the .jet file was successful, false if loading failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.622 -0400", hash_original_method = "F1A202FE670A69AB5BFF576337BF2A02", hash_generated_method = "C123B5F4D2DE638A3EAD9F2D77E841D3")
    
public boolean loadJetFile(String path) {
        return native_loadJetFromFile(path);
    }
    
    /**
     * Loads a .jet file from an asset file descriptor.
     * @param afd the asset file descriptor.
     * @return true if loading the .jet file was successful, false if loading failed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.623 -0400", hash_original_method = "909147BE468DDE23FD3056A893F5D854", hash_generated_method = "F24F136550894004C19954CD13B4054D")
    
public boolean loadJetFile(AssetFileDescriptor afd) {
        long len = afd.getLength();
        if (len < 0) {
            throw new AndroidRuntimeException("no length for fd");
        }
        return native_loadJetFromFileD(
                afd.getFileDescriptor(), afd.getStartOffset(), len);
    }
    
    /**
     * Closes the resource containing the JET content.
     * @return true if successfully closed, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.625 -0400", hash_original_method = "7EDB7731854CABA88D3CFAC4B970559A", hash_generated_method = "E22E4A16EE5C6B31C7C7CAEADEDF18FA")
    
public boolean closeJetFile() {
        return native_closeJetFile();
    }
    
    /**
     * Starts playing the JET segment queue.
     * @return true if rendering and playback is successfully started, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.627 -0400", hash_original_method = "3A9178950D6B0DB7F601D54DD4A9B7E9", hash_generated_method = "CDE646108CB7174D37223199E0AA542E")
    
public boolean play() {
        return native_playJet();
    }
    
    /**
     * Pauses the playback of the JET segment queue.
     * @return true if rendering and playback is successfully paused, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.629 -0400", hash_original_method = "30A21695CF6ED9BB29E1F2059CBD86DB", hash_generated_method = "01FA89075E9A4956B99CE69BE3C26EE5")
    
public boolean pause() {
        return native_pauseJet();
    }
    
    /**
     * Queues the specified segment in the JET queue.
     * @param segmentNum the identifier of the segment.
     * @param libNum the index of the sound bank associated with the segment. Use -1 to indicate
     *    that no sound bank (DLS file) is associated with this segment, in which case JET will use
     *    the General MIDI library.
     * @param repeatCount the number of times the segment will be repeated. 0 means the segment will
     *    only play once. -1 means the segment will repeat indefinitely.
     * @param transpose the amount of pitch transposition. Set to 0 for normal playback. 
     *    Range is -12 to +12.
     * @param muteFlags a bitmask to specify which MIDI tracks will be muted during playback. Bit 0
     *    affects track 0, bit 1 affects track 1 etc.
     * @param userID a value specified by the application that uniquely identifies the segment. 
     *    this value is received in the
     *    {@link OnJetEventListener#onJetUserIdUpdate(JetPlayer, int, int)} event listener method.
     *    Normally, the application will keep a byte value that is incremented each time a new
     *    segment is queued up. This can be used to look up any special characteristics of that
     *    track including trigger clips and mute flags.
     * @return true if the segment was successfully queued, false if the queue is full or if the
     *    parameters are invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.630 -0400", hash_original_method = "07DB301DAF4247493E7C63B7BCAA4B8C", hash_generated_method = "9CE8CABCF3B408579060A94BD202B8B2")
    
public boolean queueJetSegment(int segmentNum, int libNum, int repeatCount,
        int transpose, int muteFlags, byte userID) {
        return native_queueJetSegment(segmentNum, libNum, repeatCount, 
                transpose, muteFlags, userID);
    }
    
    /**
     * Queues the specified segment in the JET queue.
     * @param segmentNum the identifier of the segment.
     * @param libNum the index of the soundbank associated with the segment. Use -1 to indicate that
     *    no sound bank (DLS file) is associated with this segment, in which case JET will use
     *    the General MIDI library.
     * @param repeatCount the number of times the segment will be repeated. 0 means the segment will
     *    only play once. -1 means the segment will repeat indefinitely.
     * @param transpose the amount of pitch transposition. Set to 0 for normal playback. 
     *    Range is -12 to +12.
     * @param muteArray an array of booleans to specify which MIDI tracks will be muted during
     *    playback. The value at index 0 affects track 0, value at index 1 affects track 1 etc. 
     *    The length of the array must be {@link #getMaxTracks()} for the call to succeed.
     * @param userID a value specified by the application that uniquely identifies the segment. 
     *    this value is received in the
     *    {@link OnJetEventListener#onJetUserIdUpdate(JetPlayer, int, int)} event listener method.
     *    Normally, the application will keep a byte value that is incremented each time a new
     *    segment is queued up. This can be used to look up any special characteristics of that
     *    track including trigger clips and mute flags.
     * @return true if the segment was successfully queued, false if the queue is full or if the
     *    parameters are invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.632 -0400", hash_original_method = "039FA3D57DE3158D406C6E7D05E7BE13", hash_generated_method = "C65FEEFB6359563C19CD7438E6712064")
    
public boolean queueJetSegmentMuteArray(int segmentNum, int libNum, int repeatCount,
            int transpose, boolean[] muteArray, byte userID) {
        if (muteArray.length != JetPlayer.getMaxTracks()) {
            return false;
        }
        return native_queueJetSegmentMuteArray(segmentNum, libNum, repeatCount,
                transpose, muteArray, userID);
    }
    
    /**
     * Modifies the mute flags.
     * @param muteFlags a bitmask to specify which MIDI tracks are muted. Bit 0 affects track 0,
     *    bit 1 affects track 1 etc.
     * @param sync if false, the new mute flags will be applied as soon as possible by the JET
     *    render and playback engine. If true, the mute flags will be updated at the start of the
     *    next segment. If the segment is repeated, the flags will take effect the next time 
     *    segment is repeated.
     * @return true if the mute flags were successfully updated, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.634 -0400", hash_original_method = "7E9E21553EB076CA1B806E8B78B80810", hash_generated_method = "D80F3BD709A36DE105C29E31210208B8")
    
public boolean setMuteFlags(int muteFlags, boolean sync) {
        return native_setMuteFlags(muteFlags, sync);
    }
     
    //---------------------------------------------------------
    // Internal class to handle events posted from native code
    //------------------------
    private class NativeEventHandler extends Handler
    {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.643 -0400", hash_original_field = "608EA2E85B899774F8DDE10418FAEA46", hash_generated_field = "DA3D4DCF1C489E6F570C9EAA6DF2A86B")

        private JetPlayer mJet;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.645 -0400", hash_original_method = "8C9AAD696750EE98401E96EF65E66150", hash_generated_method = "FAB16E9FD2F5021DCBB17570A5080A50")
        
public NativeEventHandler(JetPlayer jet, Looper looper) {
            super(looper);
            mJet = jet;
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.648 -0400", hash_original_method = "CF423150F7C4812B4D67B8A2C2A7CD9F", hash_generated_method = "D02B9AEDF3B32BFD273FA851AA826C7E")
        
@Override
        public void handleMessage(Message msg) {
            OnJetEventListener listener = null;
            synchronized (mEventListenerLock) {
                listener = mJet.mJetEventListener;
            }
            switch(msg.what) {
            case JET_EVENT:
                if (listener != null) {
                    // call the appropriate listener after decoding the event parameters
                    // encoded in msg.arg1
                    mJetEventListener.onJetEvent(
                            mJet,
                            (short)((msg.arg1 & JET_EVENT_SEG_MASK)   >> JET_EVENT_SEG_SHIFT),
                            (byte) ((msg.arg1 & JET_EVENT_TRACK_MASK) >> JET_EVENT_TRACK_SHIFT),
                            // JETCreator channel numbers start at 1, but the index starts at 0
                            // in the .jet files
                            (byte)(((msg.arg1 & JET_EVENT_CHAN_MASK)  >> JET_EVENT_CHAN_SHIFT) + 1),
                            (byte) ((msg.arg1 & JET_EVENT_CTRL_MASK)  >> JET_EVENT_CTRL_SHIFT),
                            (byte)  (msg.arg1 & JET_EVENT_VAL_MASK) );
                }
                return;
            case JET_USERID_UPDATE:
                if (listener != null) {
                    listener.onJetUserIdUpdate(mJet, msg.arg1, msg.arg2);
                }
                return;
            case JET_NUMQUEUEDSEGMENT_UPDATE:
                if (listener != null) {
                    listener.onJetNumQueuedSegmentUpdate(mJet, msg.arg1);
                }
                return;
            case JET_PAUSE_UPDATE:
                if (listener != null)
                    listener.onJetPauseUpdate(mJet, msg.arg1);
                return;

            default:
                loge("Unknown message type " + msg.what);
                return;
            }
        }
    }
    
    /**
     * Modifies the mute flags for the current active segment.
     * @param muteArray an array of booleans to specify which MIDI tracks are muted. The value at
     *    index 0 affects track 0, value at index 1 affects track 1 etc. 
     *    The length of the array must be {@link #getMaxTracks()} for the call to succeed.
     * @param sync if false, the new mute flags will be applied as soon as possible by the JET
     *    render and playback engine. If true, the mute flags will be updated at the start of the
     *    next segment. If the segment is repeated, the flags will take effect the next time 
     *    segment is repeated.
     * @return true if the mute flags were successfully updated, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.636 -0400", hash_original_method = "81FF7A6F4DA516FAC7F2AF10A22CD19B", hash_generated_method = "186E88EF7ADFB62157F35EA97C3E3643")
    
public boolean setMuteArray(boolean[] muteArray, boolean sync) {
        if(muteArray.length != JetPlayer.getMaxTracks())
            return false;
        return native_setMuteArray(muteArray, sync);
    }
    
    /**
     * Mutes or unmutes a single track.
     * @param trackId the index of the track to mute.
     * @param muteFlag set to true to mute, false to unmute.
     * @param sync if false, the new mute flags will be applied as soon as possible by the JET
     *    render and playback engine. If true, the mute flag will be updated at the start of the
     *    next segment. If the segment is repeated, the flag will take effect the next time 
     *    segment is repeated.
     * @return true if the mute flag was successfully updated, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.637 -0400", hash_original_method = "4D8701F58E27E917D331CCF9A1BBA329", hash_generated_method = "BB6F7647B63F7A117F39EE2E62D82FC8")
    
public boolean setMuteFlag(int trackId, boolean muteFlag, boolean sync) {
        return native_setMuteFlag(trackId, muteFlag, sync);
    }
    
    /**
     * Handles the notification when the JET engine generates an event.
     */
    public interface OnJetEventListener {
        /**
         * Callback for when the JET engine generates a new event.
         * 
         * @param player the JET player the event is coming from
         * @param segment 8 bit unsigned value
         * @param track 6 bit unsigned value
         * @param channel 4 bit unsigned value
         * @param controller 7 bit unsigned value
         * @param value 7 bit unsigned value
         */
        void onJetEvent(JetPlayer player,
                short segment, byte track, byte channel, byte controller, byte value);
        /**
         * Callback for when JET's currently playing segment's userID is updated.
         * 
         * @param player the JET player the status update is coming from
         * @param userId the ID of the currently playing segment
         * @param repeatCount the repetition count for the segment (0 means it plays once)
         */
        void onJetUserIdUpdate(JetPlayer player, int userId, int repeatCount);
        
        /**
         * Callback for when JET's number of queued segments is updated.
         * 
         * @param player the JET player the status update is coming from
         * @param nbSegments the number of segments in the JET queue
         */
        void onJetNumQueuedSegmentUpdate(JetPlayer player, int nbSegments);
        
        /**
         * Callback for when JET pause state is updated.
         * 
         * @param player the JET player the status update is coming from
         * @param paused indicates whether JET is paused (1) or not (0)
         */
        void onJetPauseUpdate(JetPlayer player, int paused);
    }
    
    /**
     * Schedules the playback of a clip.
     * This will automatically update the mute flags in sync with the JET Clip Marker (controller 
     * 103). The parameter clipID must be in the range of 0-63. After the call to triggerClip, when
     * JET next encounters a controller event 103 with bits 0-5 of the value equal to clipID and 
     * bit 6 set to 1, it will automatically unmute the track containing the controller event.
     * When JET encounters the complementary controller event 103 with bits 0-5 of the value equal
     * to clipID and bit 6 set to 0, it will mute the track again.
     * @param clipId the identifier of the clip to trigger.
     * @return true if the clip was successfully triggered, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.639 -0400", hash_original_method = "C0BD7E4E2CBF1DFF4D6A54976CCD8B51", hash_generated_method = "EFF9411BC376EA897618A21FB2D4E939")
    
public boolean triggerClip(int clipId) {
        return native_triggerClip(clipId);
    }
    
    /**
     * Empties the segment queue, and clears all clips that are scheduled for playback.
     * @return true if the queue was successfully cleared, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.641 -0400", hash_original_method = "2E059D33130805E67059143933849725", hash_generated_method = "49641EC59C228F229A332C534FD66940")
    
public boolean clearQueue() {
        return native_clearQueue();
    }
    
    //--------------------------------------------
    // Jet event listener
    //------------------------
    /**
     * Sets the listener JetPlayer notifies when a JET event is generated by the rendering and
     * playback engine.
     * Notifications will be received in the same thread as the one in which the JetPlayer
     * instance was created.
     * @param listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.652 -0400", hash_original_method = "DC41E7D8C5125A549ACFDC1374C1B15B", hash_generated_method = "EF32DE9F95E761558208F3BC2ABA780F")
    
public void setEventListener(OnJetEventListener listener) {
        setEventListener(listener, null);
    }
    
    /**
     * Sets the listener JetPlayer notifies when a JET event is generated by the rendering and
     * playback engine.
     * Use this method to receive JET events in the Handler associated with another
     * thread than the one in which you created the JetPlayer instance.
     * @param listener
     * @param handler the Handler that will receive the event notification messages.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.654 -0400", hash_original_method = "147D359920D6E5AC43538CAF4829F587", hash_generated_method = "AF12D7B34BBF3DD451905DBDD5086AE6")
    
public void setEventListener(OnJetEventListener listener, Handler handler) {
        synchronized(mEventListenerLock) {
            
            mJetEventListener = listener;
            
            if (listener != null) {
                if (handler != null) {
                    mEventHandler = new NativeEventHandler(this, handler.getLooper());
                } else {
                    // no given handler, use the looper the AudioTrack was created in
                    mEventHandler = new NativeEventHandler(this, mInitializationLooper);
                }
            } else {
                mEventHandler = null;
            }
            
        }
    }
    
    //--------------------------------------------
    // Native methods
    //------------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.547 -0400", hash_original_method = "0EB7C774FCC291A717DF9259C5EF04AF", hash_generated_method = "AD3CC46EDFD39DE187FF04639443B26B")
    
    private final boolean native_setup(Object Jet_this,
                    int maxTracks, int trackBufferSize){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += Jet_this.getTaintInt();
    	taintDouble += maxTracks;
    	taintDouble += trackBufferSize;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:59.052 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void    native_finalize(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:59.055 -0400", hash_original_method = "29EBD7A2FE8EDC8D2C10EA00B5293031", hash_generated_method = "8E05B7AB4B85F0BA21E048043C2032E1")
    
    private final void    native_release(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.558 -0400", hash_original_method = "213E36FD97A620D7ADFF881F9825BC99", hash_generated_method = "A2CF5810D64DFBE371D8D149343A6C45")
    
    private final boolean native_loadJetFromFile(String pathToJetFile){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pathToJetFile.getTaintInt();
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.563 -0400", hash_original_method = "9687809347122C52F95F18CED1CAC545", hash_generated_method = "31F9D47C9C6835792655DA871B8B0AE5")
    
    private final boolean native_loadJetFromFileD(FileDescriptor fd, long offset, long len){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += fd.getTaintInt();
    	taintDouble += offset;
    	taintDouble += len;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:47.650 -0400", hash_original_method = "35827CF8B6E41385AB0C10883E47A097", hash_generated_method = "95A1EE9F4D4A2E51AC7B80C24E16D965")
    
    private final boolean native_closeJetFile(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:47.654 -0400", hash_original_method = "9765DB84F64F7ED2114A283E849E138B", hash_generated_method = "9CC0B1CC3CFD512A672EFB886D07C438")
    
    private final boolean native_playJet(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:47.657 -0400", hash_original_method = "763093B87D1B57159D1C410854619849", hash_generated_method = "BEA645CEC327B85176FD0226910B29E3")
    
    private final boolean native_pauseJet(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.579 -0400", hash_original_method = "36A18D7794B4AF7C18E21A1C8DD303FE", hash_generated_method = "0E672690FCCB8E10C6069BEA79CCD53A")
    
    private final boolean native_queueJetSegment(int segmentNum, int libNum,
                int repeatCount, int transpose, int muteFlags, byte userID){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += segmentNum;
    	taintDouble += libNum;
    	taintDouble += repeatCount;
    	taintDouble += transpose;
    	taintDouble += muteFlags;
    	taintDouble += userID;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:57.687 -0400", hash_original_method = "764AC5309CEF6D945E53C81CE1760E49", hash_generated_method = "28589546A6B44D28EE0310BDC617E4D6")
    
    private final boolean native_queueJetSegmentMuteArray(int segmentNum, int libNum, 
                int repeatCount, int transpose, boolean[] muteArray, byte userID){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += segmentNum;
    	taintDouble += libNum;
    	taintDouble += repeatCount;
    	taintDouble += transpose;
    	taintDouble += ((muteArray[0]) ? 1 : 0);
    	taintDouble += userID;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:57.690 -0400", hash_original_method = "FC4C019E40F2D81322CA45FCE167178F", hash_generated_method = "292BDA8522A3302618F7BE5441F0D632")
    
    private final boolean native_setMuteFlags(int muteFlags, boolean sync){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += muteFlags;
    	taintDouble += ((sync) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:57.693 -0400", hash_original_method = "7965B80BB9CFEEDC942DF71457568BD4", hash_generated_method = "FBFC0CFFA1C995E9E242168DE12E1D2A")
    
    private final boolean native_setMuteArray(boolean[]muteArray, boolean sync){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ((muteArray[0]) ? 1 : 0);
    	taintDouble += ((sync) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:38:57.696 -0400", hash_original_method = "63886ABBB0AA0A2A6090A23CC71C7C92", hash_generated_method = "5AA8CCFC7D67D951D580DA8A977E4C0C")
    
    private final boolean native_setMuteFlag(int trackId, boolean muteFlag, boolean sync){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += trackId;
    	taintDouble += ((muteFlag) ? 1 : 0);
    	taintDouble += ((sync) ? 1 : 0);
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:25.599 -0400", hash_original_method = "A83C9A030FE24E78D0EF202E36F789B6", hash_generated_method = "667369581D1D397BC0290D071620D539")
    
    private final boolean native_triggerClip(int clipId){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += clipId;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:24:47.678 -0400", hash_original_method = "C73BFE4788EA844AE10AD9C37F3FCE8E", hash_generated_method = "5C2BB589096CFF8F060F579E801B8DF6")
    
    private final boolean native_clearQueue(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return ((taintDouble) == 1);
    }
 
}
