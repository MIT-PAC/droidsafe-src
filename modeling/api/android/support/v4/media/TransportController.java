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

/**
 * Base interface to controlling a media transport.  This is the
 * interface for implementing things like on-screen controls: it
 * allows them to request changes in playback, retrieve the current
 * playback state, and monitor for changes to the playback state.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class TransportController {
    /**
     * Start listening to changes in playback state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.366 -0400", hash_original_method = "BDFC45E89B9BEFB1C5480D7B1644E38C", hash_generated_method = "EC904D3067C4973DC5125A05E62442F4")
    
public abstract void registerStateListener(TransportStateListener listener);

    /**
     * Stop listening to changes in playback state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.372 -0400", hash_original_method = "2F9BC34C83A0EF34B30041AD94711A79", hash_generated_method = "B63BB1C85D133CC93F5828C7B42A5A40")
    
public abstract void unregisterStateListener(TransportStateListener listener);

    /**
     * Request that the player start its playback at its current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.377 -0400", hash_original_method = "2B05CC4AB1D15B40795BB6C0FF559784", hash_generated_method = "941E69A0BFBF08F63B3DAAA3F6C9432D")
    
public abstract void startPlaying();

    /**
     * Request that the player pause its playback and stay at its current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.382 -0400", hash_original_method = "33B41C28F4749C6D1605E4A6D2D5375E", hash_generated_method = "112F104D65E005B7238F1BA8522312E3")
    
public abstract void pausePlaying();

    /**
     * Request that the player stop its playback; it may clear its state in whatever
     * way is appropriate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.387 -0400", hash_original_method = "3DF52153E81314DE55DFF445F3F004B3", hash_generated_method = "6B61FC0DAEC44750F0E06709A3F72D8F")
    
public abstract void stopPlaying();

    /**
     * Retrieve the total duration of the media stream, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.392 -0400", hash_original_method = "13809D2532E5FA38EF98BEB630AAB08D", hash_generated_method = "FF9278407590D9A00164135C344715E5")
    
public abstract long getDuration();

    /**
     * Retrieve the current playback location in the media stream, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.397 -0400", hash_original_method = "9DD76779B5F2E59E7368911E8A68CF04", hash_generated_method = "F063C5040C5A35787B77EA6E0D3B70CB")
    
public abstract long getCurrentPosition();

    /**
     * Move to a new location in the media stream.
     * @param pos Position to move to, in milliseconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.403 -0400", hash_original_method = "2C48BAC838AD9D3D50EE8F8F29254FE7", hash_generated_method = "E356859431098BFF7FEE0CA9FD26334F")
    
public abstract void seekTo(long pos);

    /**
     * Return whether the player is currently playing its stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.410 -0400", hash_original_method = "F383FE244E24C0C545B5D975B4462316", hash_generated_method = "0F06E074007AC28F9E93ECD1FA5748A5")
    
public abstract boolean isPlaying();

    /**
     * Retrieve amount, in percentage (0-100), that the media stream has been buffered
     * on to the local device.  Return 100 if the stream is always local.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.415 -0400", hash_original_method = "674807512A10718887E0925B3B91C2B9", hash_generated_method = "17608A4AFEA95798DCEC425002E82661")
    
public abstract int getBufferPercentage();

    /**
     * Retrieve the flags for the media transport control buttons that this transport supports.
     * Result is a combination of the following flags:
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_REWIND},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_PAUSE},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_STOP},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link TransportMediator#FLAG_KEY_MEDIA_NEXT}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:58.420 -0400", hash_original_method = "B9475CA6189B34501952F35F9EFABF9E", hash_generated_method = "B484827C247042F72F92E2215B178884")
    
public abstract int getTransportControlFlags();
}
