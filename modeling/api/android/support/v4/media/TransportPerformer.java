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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.SystemClock;
import android.view.KeyEvent;

/**
 * Implemented by the playback side of the media system, to respond to
 * requests to perform actions and to retrieve its current state.  These
 * requests may either come from key events dispatched directly to your UI, or
 * events sent over a media button event receiver that this class keeps active
 * while your window is in focus.
 */
public abstract class TransportPerformer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.192 -0400", hash_original_field = "42E99C962239F2E87F628A70876C3CF7", hash_generated_field = "DB2F12588A238BE36CBF3EF3A5542BDB")

    static final int AUDIOFOCUS_GAIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.197 -0400", hash_original_field = "07327AD11AE49EAFF9ADD9AA63AF06F8", hash_generated_field = "331E5771BE84C5C5E6431D31214ADC42")

    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.202 -0400", hash_original_field = "9A2C357FAEE16E449A7617700348DE37", hash_generated_field = "6355C6C43030C977ABF89D9FED0E84D9")

    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.207 -0400", hash_original_field = "192BB54EF104EB5D859B73B73D2DB335", hash_generated_field = "93E2FE3C546F9AAC3DFA8C8FE58EBBA6")

    static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.212 -0400", hash_original_field = "FA6B99C4BE12B06232762E8E6E280012", hash_generated_field = "F3D295F1DC2EAAC3596CECFE2D0D74F0")

    static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.218 -0400", hash_original_field = "B3AC4E2770C2EFFD08B939CADE9CBAEF", hash_generated_field = "3ACD57C92E253E197BA15E01DAFF1811")

    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK =
            -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
    /**
     * Request to start playback on the media, resuming from whatever current state
     * (position etc) it is in.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.138 -0400", hash_original_method = "FEC44E6D1791554E43062F6BCFB340F5", hash_generated_method = "870184E7F8F66051862AC1D316A75639")
    
public abstract void onStart();

    /**
     * Request to pause playback of the media, staying at the current playback position
     * and other state so a later call to {@link #onStart()} will resume at the same place.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.143 -0400", hash_original_method = "93D75B4880B81945CD5B8AD194FEF306", hash_generated_method = "E88B3E2A943DC0C17AF3E3B2BBD2B169")
    
public abstract void onPause();

    /**
     * Request to completely stop playback of the media, clearing whatever state the
     * player thinks is appropriate.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.148 -0400", hash_original_method = "21B71D5BA1BEE107197F9887737DACA6", hash_generated_method = "256844E3585575AA39D94F5B2218A88B")
    
public abstract void onStop();

    /**
     * Request to return the duration of the current media, in milliseconds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.152 -0400", hash_original_method = "D0D2C599EBE03B1A123C4B17F2F6854C", hash_generated_method = "B0FC04F8233DF4FC40161FE21629ACF8")
    
public abstract long onGetDuration();

    /**
     * Request to return the current playback position, in milliseconds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.156 -0400", hash_original_method = "728891FF0040F26821F2D819D52DD8B5", hash_generated_method = "E836C06BC561395E46BF643C0B90C9C3")
    
public abstract long onGetCurrentPosition();

    /**
     * Request to move the current playback position.
     * @param pos New position to move to, in milliseconds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.162 -0400", hash_original_method = "75F22500398F5C218D1BAEFECA5C8BB8", hash_generated_method = "941FF25340BB91D27014C3DA45710BC5")
    
public abstract void onSeekTo(long pos);

    /**
     * Request to find out whether the player is currently playing its media.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.167 -0400", hash_original_method = "8182EF85E2AE30CFA2C2EBBC0825365D", hash_generated_method = "D96B9CD3D491D4833DEB559324483098")
    
public abstract boolean onIsPlaying();

    /**
     * Request to find out how much of the media has been buffered on the local device.
     * @return Return a percentage (0-100) indicating how much of the total data
     * has been buffered.  The default implementation returns 100, meaning the content
     * is always on the local device.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.171 -0400", hash_original_method = "D25CBA0C37F66E90C4CC1ED3F6471534", hash_generated_method = "C0333C63A2A06569DA6C50D7B0B32674")
    
public int onGetBufferPercentage() {
        return 100;
    }

    /**
     * Retrieves the flags for the media transport control buttons that this transport supports.
     * Result is a combination of the following flags:
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_REWIND},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PAUSE},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_STOP},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_NEXT}
     *
     * <p>The default implementation returns:
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PAUSE}, and
     *      {@link TransportMediator#FLAG_KEY_MEDIA_STOP}</p>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.176 -0400", hash_original_method = "A45EF0906B13788173BF6A9A15A7A835", hash_generated_method = "6D006AC62A66DDB21A84AD1F2E08C919")
    
public int onGetTransportControlFlags() {
        return TransportMediator.FLAG_KEY_MEDIA_PLAY
                | TransportMediator.FLAG_KEY_MEDIA_PLAY_PAUSE
                | TransportMediator.FLAG_KEY_MEDIA_PAUSE
                | TransportMediator.FLAG_KEY_MEDIA_STOP;
    }

    /**
     * Report that a media button has been pressed.  This is like
     * {@link android.view.KeyEvent.Callback#onKeyDown(int, android.view.KeyEvent)} but
     * will only deliver media keys.  The default implementation handles these keys:
     * <ul>
     *     <li>KEYCODE_MEDIA_PLAY: call {@link #onStart}</li>
     *     <li>KEYCODE_MEDIA_PAUSE: call {@link #onPause}</li>
     *     <li>KEYCODE_MEDIA_STOP: call {@link #onStop}</li>
     *     <li>KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK: call {@link #onPause}
     *          if {@link #onIsPlaying()} returns true, otherwise call {@link #onStart}</li>
     * </ul>
     * @param keyCode The code of the media key.
     * @param event The full key event.
     * @return Indicate whether the key has been consumed.  The default
     * implementation always returns true.  This only matters for keys
     * being dispatched here from
     * {@link TransportMediator#dispatchKeyEvent(android.view.KeyEvent)
     * TransportController.dispatchKeyEvent}, and determines whether the key
     * continues on to its default key handling (which for media keys means
     * being delivered to the current media remote control, which should
     * be us).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.181 -0400", hash_original_method = "84610781F7CC32F78EBD23816A149F47", hash_generated_method = "6DE8F0793D6D010919CF4788F48822AB")
    
public boolean onMediaButtonDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case TransportMediator.KEYCODE_MEDIA_PLAY:
                onStart();
                return true;
            case TransportMediator.KEYCODE_MEDIA_PAUSE:
                onPause();
                return true;
            case KeyEvent.KEYCODE_MEDIA_STOP:
                onStop();
                return true;
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
                if (onIsPlaying()) {
                    onPause();
                } else {
                    onStart();
                }
        }
        return true;
    }

    /**
     * Report that a media button has been released.  This is like
     * {@link KeyEvent.Callback#onKeyUp(int, android.view.KeyEvent)} but
     * will only deliver media keys.  The default implementation does nothing.
     * @param keyCode The code of the media key.
     * @param event The full key event.
     * @return Indicate whether the key has been consumed.  The default
     * implementation always returns true.  This only matters for keys
     * being dispatched here from
     * {@link TransportMediator#dispatchKeyEvent(android.view.KeyEvent)
     * TransportController.dispatchKeyEvent}, and determines whether the key
     * continues on to its default key handling (which for media keys means
     * being delivered to the current media remote control, which should
     * be us).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.187 -0400", hash_original_method = "D686C77908272516DD83F6CBBB18FC98", hash_generated_method = "F821659BBE06B7981D45DFF8754A4830")
    
public boolean onMediaButtonUp(int keyCode, KeyEvent event) {
        return true;
    }

    /**
     * Report that audio focus has changed on the app.  This only happens if
     * you have indicated you have started playing with
     * {@link TransportMediator#startPlaying TransportController.startPlaying},
     * which takes audio focus for you.
     * @param focusChange The type of focus change, as per
     * {@link android.media.AudioManager.OnAudioFocusChangeListener#onAudioFocusChange(int)
     * OnAudioFocusChangeListener.onAudioFocusChange}.  The default implementation will
     * deliver a {@link KeyEvent#KEYCODE_MEDIA_STOP}
     * when receiving {@link android.media.AudioManager#AUDIOFOCUS_LOSS}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:09:00.225 -0400", hash_original_method = "C0641D64987776FEBDA306BB7BBBD8C1", hash_generated_method = "1FF783996D263A647B27C62E69BFC583")
    
public void onAudioFocusChange(int focusChange) {
        int keyCode = 0;
        switch (focusChange) {
            case AUDIOFOCUS_LOSS:
                // This will cause us to stop playback, which means we drop audio focus
                // so we will not get any further audio focus gain.
                keyCode = TransportMediator.KEYCODE_MEDIA_PAUSE;
                break;
        }
        if (keyCode != 0) {
            final long now = SystemClock.uptimeMillis();
            onMediaButtonDown(keyCode, new KeyEvent(now, now, KeyEvent.ACTION_DOWN, keyCode, 0));
            onMediaButtonUp(keyCode, new KeyEvent(now, now, KeyEvent.ACTION_UP, keyCode, 0));
        }
    }
}
