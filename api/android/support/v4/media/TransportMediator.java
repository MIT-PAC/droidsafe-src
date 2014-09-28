/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.support.v4.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Helper for implementing a media transport control (with play, pause, skip, and
 * other media actions).  Takes care of both key events and advanced features
 * like {@link android.media.RemoteControlClient}.  This class is intended to
 * serve as an intermediary between transport controls (whether they be on-screen
 * controls, hardware buttons, remote controls) and the actual player.  The player
 * is represented by a single {@link TransportPerformer} that must be supplied to
 * this class.  On-screen controls that want to control and show the state of the
 * player should do this through calls to the {@link TransportController} interface.
 *
 * <p>Here is a simple but fairly complete sample of a video player that is built
 * around this class.  Note that the MediaController class used here is not the one
 * included in the standard Android framework, but a custom implementation.  Real
 * applications often implement their own transport controls, or you can copy the
 * implementation here out of Support4Demos.</p>
 *
 * {@sample development/samples/Support4Demos/src/com/example/android/supportv4/media/TransportControllerActivity.java
 *      complete}
 */
public class TransportMediator extends TransportController {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.047 -0400", hash_original_field = "457D8CC34754D8191A76F7237884E1F8", hash_generated_field = "9441A62B74F22725D4E5C7392C8E6558")

    public static final int KEYCODE_MEDIA_PLAY = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.054 -0400", hash_original_field = "0A648676245ED2215612BC8EAE0354CC", hash_generated_field = "753187519748D9D0BAB26C6880E1DB28")

    public static final int KEYCODE_MEDIA_PAUSE = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.060 -0400", hash_original_field = "6A375B60122605CB04C333EADEB5E83D", hash_generated_field = "D0B7C1441F43A2FC8490E55B0453C41D")

    public static final int KEYCODE_MEDIA_RECORD = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.066 -0400", hash_original_field = "24A7BA8AD75D6BFFF8A3D2AE0E3DD869", hash_generated_field = "D9C2B7C797239CFADF59DF6E95F1B111")

    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.072 -0400", hash_original_field = "3A34DDEF07A947F37D764775E986333F", hash_generated_field = "E60961DC3DFBE2A350F7E65CD95479FA")

    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.078 -0400", hash_original_field = "10D81DEBFDC5B25B467B55D94BAC3B2F", hash_generated_field = "C4AADE8FFD83074B2941C8BB305E5194")

    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.084 -0400", hash_original_field = "B2E2A48447193CE2E9EFB7950FA941D0", hash_generated_field = "A50B60387E829EE960A6C24801483960")

    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.090 -0400", hash_original_field = "1A8255712733CAE58873BD693566AAEA", hash_generated_field = "3037539F2A50CCC54FEF961DB8032CE3")

    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.098 -0400", hash_original_field = "4C791594D621D22CB5BB863725B8F5EA", hash_generated_field = "EB951276E4926A00C8B2D0185D744968")

    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.105 -0400", hash_original_field = "A40BF8CFE6CE428B085EFC1E483E947B", hash_generated_field = "727BB4258CAB824CD82070CC756209D0")

    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.111 -0400", hash_original_field = "D6CE591284C44F4CB225B911AEA655DA", hash_generated_field = "AA28402D84BB64B0BBA8663A9933668C")

    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.119 -0400", hash_original_method = "2AAD7E34FCCB772FC0546DD31C4AB75A", hash_generated_method = "3A05002EFFA92F0CD783A43892235B3A")
    
static boolean isMediaKey(int keyCode) {
        switch (keyCode) {
            case KEYCODE_MEDIA_PLAY:
            case KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_MUTE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
            case KeyEvent.KEYCODE_MEDIA_STOP:
            case KeyEvent.KEYCODE_MEDIA_NEXT:
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
            case KeyEvent.KEYCODE_MEDIA_REWIND:
            case KEYCODE_MEDIA_RECORD:
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD: {
                return true;
            }
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.974 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.979 -0400", hash_original_field = "28FDB8EB4AF98FF7195CA5DA1D6EA457", hash_generated_field = "28FDB8EB4AF98FF7195CA5DA1D6EA457")

     TransportPerformer mCallbacks;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.984 -0400", hash_original_field = "81931559493F052ED78BA000FD1BC717", hash_generated_field = "81931559493F052ED78BA000FD1BC717")

     AudioManager mAudioManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.989 -0400", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

     View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.996 -0400", hash_original_field = "C07BA912536DECB764983C9A8EB902BA", hash_generated_field = "C07BA912536DECB764983C9A8EB902BA")

     Object mDispatcherState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.002 -0400", hash_original_field = "0B01ED616000486EC5DEC910BF353215", hash_generated_field = "0B01ED616000486EC5DEC910BF353215")

     TransportMediatorJellybeanMR2 mController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.008 -0400", hash_original_field = "49EFD069F195776F9023C42CE7C04F4D", hash_generated_field = "288FFA68F953B4EC574D1908559C49D5")

    final ArrayList<TransportStateListener> mListeners
            = new ArrayList<TransportStateListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.040 -0400", hash_original_field = "F00AC6F22702A7D3A615677F0DD51E29", hash_generated_field = "643FB77D09546D590941C567EB2ED688")

    final TransportMediatorCallback mTransportKeyCallback
            = new TransportMediatorCallback() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void handleKey(KeyEvent key) {
            key.dispatch(mKeyEventCallback);
        }
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void handleAudioFocusChange(int focusChange) {
            mCallbacks.onAudioFocusChange(focusChange);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public long getPlaybackPosition() {
            return mCallbacks.onGetCurrentPosition();
        }

        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void playbackPositionUpdate(long newPositionMs) {
            mCallbacks.onSeekTo(newPositionMs);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.151 -0400", hash_original_field = "FE718FA38C5E519A779B06B524D16D24", hash_generated_field = "57508295FCB4AB902075A78ABC06242B")

    final KeyEvent.Callback mKeyEventCallback = new KeyEvent.Callback() {
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return isMediaKey(keyCode) ? mCallbacks.onMediaButtonDown(keyCode, event) : false;
        }

        public boolean onKeyLongPress(int keyCode, KeyEvent event) {
            return false;
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            return isMediaKey(keyCode) ? mCallbacks.onMediaButtonUp(keyCode, event) : false;
        }

        @Override
        public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
            return false;
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.156 -0400", hash_original_method = "7A14BB20A5036CBCFAC3090FE3B280AA", hash_generated_method = "2BBB3F1F9B7107CE1D83772F2247A627")
    
public TransportMediator(Activity activity, TransportPerformer callbacks) {
        this(activity, null, callbacks);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.161 -0400", hash_original_method = "C3FE786B0A503FF5C14D901E6DBC5C78", hash_generated_method = "BCB7F660494EB4A628CF55AEE1E7F96F")
    
public TransportMediator(View view, TransportPerformer callbacks) {
        this(null, view, callbacks);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.169 -0400", hash_original_method = "1633007CCC58A8E243ACCF8DD64AFA10", hash_generated_method = "3BCF5EFC018D66818E9BF7885E3415A4")
    
private TransportMediator(Activity activity, View view, TransportPerformer callbacks) {
        mContext = activity != null ? activity : view.getContext();
        mCallbacks = callbacks;
        mAudioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        mView = activity != null ? activity.getWindow().getDecorView() : view;

        //mDispatcherState = KeyEventCompat.getKeyDispatcherState(mView);

        if (Build.VERSION.SDK_INT >= 18) { // JellyBean MR2
            mController = new TransportMediatorJellybeanMR2(mContext, mAudioManager,
                    mView, mTransportKeyCallback);
        } else {
            mController = null;
        }
    }

    /**
     * Return the {@link android.media.RemoteControlClient} associated with this transport.
     * This returns a generic Object since the RemoteControlClient is not availble before
     * {@link android.os.Build.VERSION_CODES#ICE_CREAM_SANDWICH}.  Further, this class
     * will not use RemoteControlClient in its implementation until
     * {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}.  You should always check for
     * null here and not do anything with the RemoteControlClient if none is given; this
     * way you don't need to worry about the current platform API version.
     *
     * <p>Note that this class takes possession of the
     * {@link android.media.RemoteControlClient.OnGetPlaybackPositionListener} and
     * {@link android.media.RemoteControlClient.OnPlaybackPositionUpdateListener} callbacks;
     * you will interact with these through
     * {@link TransportPerformer#onGetCurrentPosition() TransportPerformer.onGetCurrentPosition} and
     * {@link TransportPerformer#onSeekTo TransportPerformer.onSeekTo}, respectively.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.174 -0400", hash_original_method = "73F5915A5B4BF95E65B38CD5B0A50A56", hash_generated_method = "377C2E916AD18C1D5E27DC970CD2AE43")
    
public Object getRemoteControlClient() {
        return mController != null ? mController.getRemoteControlClient() : null;
    }

    /**
     * Must call from {@link Activity#dispatchKeyEvent Activity.dispatchKeyEvent} to give
     * the transport an opportunity to intercept media keys.  Any such keys will show up
     * in {@link TransportPerformer}.
     * @param event
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.178 -0400", hash_original_method = "0DD873A85870BEE0A2CC76FAEBD6A097", hash_generated_method = "D110ACD0C2D85B62C112F29E39C3EFF1")
    
public boolean dispatchKeyEvent(KeyEvent event) {
        return KeyEventCompat.dispatch(event, mKeyEventCallback, mDispatcherState, this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.183 -0400", hash_original_method = "25379B34D037948C94DB39A89307DC51", hash_generated_method = "E780833851FA2D891C61B4AFAFA472F5")
    
public void registerStateListener(TransportStateListener listener) {
        mListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.188 -0400", hash_original_method = "7E87E554FE3929ABC77E37AC28B1A7E1", hash_generated_method = "CB3DF5DD049A93F235D0AF577F801D5D")
    
public void unregisterStateListener(TransportStateListener listener) {
        mListeners.remove(listener);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.194 -0400", hash_original_method = "4501A4957BDF52B4E3ACEB7865C4407C", hash_generated_method = "EE6757D62F15FB7208313044B50A9B61")
    
private TransportStateListener[] getListeners() {
        if (mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener listeners[] = new TransportStateListener[mListeners.size()];
        mListeners.toArray(listeners);
        return listeners;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.199 -0400", hash_original_method = "8F9E5E249CE3B57418C2F22FC95D9D9D", hash_generated_method = "64B0AAB98EEADFEA1CE174C63E46D2B4")
    
private void reportPlayingChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener listener : listeners) {
                listener.onPlayingChanged(this);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.204 -0400", hash_original_method = "C10480DAD5C4DFFB3BCC3890493E5651", hash_generated_method = "E7E682192B744D9D1A59C5798CACFEC8")
    
private void reportTransportControlsChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener listener : listeners) {
                listener.onTransportControlsChanged(this);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.209 -0400", hash_original_method = "3F48A9A676FBDCEDDB4B6AA91BAD5A4B", hash_generated_method = "CE61BE9EFECF3E197204205BAD5A17E6")
    
private void pushControllerState() {
        if (mController != null) {
            mController.refreshState(mCallbacks.onIsPlaying(),
                    mCallbacks.onGetCurrentPosition(),
                    mCallbacks.onGetTransportControlFlags());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.213 -0400", hash_original_method = "CF33F857FB8F20D110341BF7D4F253B0", hash_generated_method = "EDBE7FD048B7523D9A55AFEE063AB7EB")
    
public void refreshState() {
        pushControllerState();
        reportPlayingChanged();
        reportTransportControlsChanged();
    }

    /**
     * Move the controller into the playing state.  This updates the remote control
     * client to indicate it is playing, and takes audio focus for the app.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.219 -0400", hash_original_method = "874731EDFCED1A8665C096D10E95F40B", hash_generated_method = "1ED29EB5723546E5CBA8D93FCE8A8CF0")
    
@Override
    public void startPlaying() {
        if (mController != null) {
            mController.startPlaying();
        }
        mCallbacks.onStart();
        pushControllerState();
        reportPlayingChanged();
    }

    /**
     * Move the controller into the paused state.  This updates the remote control
     * client to indicate it is paused, but keeps audio focus.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.224 -0400", hash_original_method = "D1D6E23E6FCCB7AA9014CE6645AEC3D5", hash_generated_method = "B841C2E95C7A796ECCC7650BF6D7087D")
    
@Override
    public void pausePlaying() {
        if (mController != null) {
            mController.pausePlaying();
        }
        mCallbacks.onPause();
        pushControllerState();
        reportPlayingChanged();
    }

    /**
     * Move the controller into the stopped state.  This updates the remote control
     * client to indicate it is stopped, and removes audio focus from the app.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.228 -0400", hash_original_method = "DFC901DE62C4EA9C58F2B11CF295DE5A", hash_generated_method = "BD1BFEC1E57D0BC882F071C7491A18CC")
    
@Override
    public void stopPlaying() {
        if (mController != null) {
            mController.stopPlaying();
        }
        mCallbacks.onStop();
        pushControllerState();
        reportPlayingChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.233 -0400", hash_original_method = "FBED8D7117219F02B5072605600436D6", hash_generated_method = "949599CE777E08F0C28D6EC6774D835A")
    
@Override
    public long getDuration() {
        return mCallbacks.onGetDuration();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.238 -0400", hash_original_method = "5CE45D299611EB8161D2B24D5716E9BB", hash_generated_method = "C7A90FB4A4DD612BDB192033264DC7F8")
    
@Override
    public long getCurrentPosition() {
        return mCallbacks.onGetCurrentPosition();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.242 -0400", hash_original_method = "3B9697420FF9FB9F6397C495C547E827", hash_generated_method = "4CCB87E53EB27B9E15EFB731C9BA5B37")
    
@Override
    public void seekTo(long pos) {
        mCallbacks.onSeekTo(pos);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.246 -0400", hash_original_method = "75B2A44DB2651262364BA9036ACA1273", hash_generated_method = "69C0D2FD154103AC3EC08F5DCD291EF0")
    
@Override
    public boolean isPlaying() {
        return mCallbacks.onIsPlaying();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.251 -0400", hash_original_method = "7FACFCF8DE7CF92C54DC43152DFA0C6E", hash_generated_method = "B85AEAC02408489BA20DEC5BC8100647")
    
@Override
    public int getBufferPercentage() {
        return mCallbacks.onGetBufferPercentage();
    }

    /**
     * Retrieves the flags for the media transport control buttons that this transport supports.
     * Result is a combination of the following flags:
     *      {@link #FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link #FLAG_KEY_MEDIA_REWIND},
     *      {@link #FLAG_KEY_MEDIA_PLAY},
     *      {@link #FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_STOP},
     *      {@link #FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link #FLAG_KEY_MEDIA_NEXT}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.255 -0400", hash_original_method = "4B96CE12FB1748C3D12E054B9535CC67", hash_generated_method = "89A01C0B3501553151BB3AD64FE171F7")
    
public int getTransportControlFlags() {
        return mCallbacks.onGetTransportControlFlags();
    }

    /**
     * Optionally call when no longer using the TransportController.  Its resources
     * will also be automatically cleaned up when your activity/view is detached from
     * its window, so you don't normally need to call this explicitly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.259 -0400", hash_original_method = "F725D1AA4BDF18078F2DC945203943DC", hash_generated_method = "E187DC80A61A50381DCBE40A79776C54")
    
public void destroy() {
        mController.destroy();
    }
}
