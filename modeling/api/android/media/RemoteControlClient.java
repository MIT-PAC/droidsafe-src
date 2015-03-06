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


package android.media;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.Log;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * RemoteControlClient enables exposing information meant to be consumed by remote controls
 * capable of displaying metadata, artwork and media transport control buttons.
 *
 * <p>A remote control client object is associated with a media button event receiver. This
 * event receiver must have been previously registered with
 * {@link AudioManager#registerMediaButtonEventReceiver(ComponentName)} before the
 * RemoteControlClient can be registered through
 * {@link AudioManager#registerRemoteControlClient(RemoteControlClient)}.
 *
 * <p>Here is an example of creating a RemoteControlClient instance after registering a media
 * button event receiver:
 * <pre>ComponentName myEventReceiver = new ComponentName(getPackageName(), MyRemoteControlEventReceiver.class.getName());
 * AudioManager myAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
 * myAudioManager.registerMediaButtonEventReceiver(myEventReceiver);
 * // build the PendingIntent for the remote control client
 * Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
 * mediaButtonIntent.setComponent(myEventReceiver);
 * PendingIntent mediaPendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, mediaButtonIntent, 0);
 * // create and register the remote control client
 * RemoteControlClient myRemoteControlClient = new RemoteControlClient(mediaPendingIntent);
 * myAudioManager.registerRemoteControlClient(myRemoteControlClient);</pre>
 */
public class RemoteControlClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.902 -0500", hash_original_field = "E22E47E8FFC08F064AD196F239D78BDD", hash_generated_field = "2BE2B9C77FA549F039F405BEB17D9487")

    private final static String TAG = "RemoteControlClient";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.906 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.909 -0500", hash_original_field = "6159E93C4A023E06760DDE1E24E5263F", hash_generated_field = "F4D3F848A6E915802E08F3A2E5F1F53B")

    public final static int PLAYSTATE_STOPPED            = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.912 -0500", hash_original_field = "3DA0DF4889A81BD77048D42D99468104", hash_generated_field = "B88C1E8F7B840BB920E884E441877169")

    public final static int PLAYSTATE_PAUSED             = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.915 -0500", hash_original_field = "2DF25C64E9166AD1D2F31D2B53CDDEDD", hash_generated_field = "88F962CE51D407CF120388E614DE441E")

    public final static int PLAYSTATE_PLAYING            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.922 -0500", hash_original_field = "7240323EBBBE244E39376B8054F63F3F", hash_generated_field = "3BE856E2C7FB5313A81FB5745940F465")

    public final static int PLAYSTATE_FAST_FORWARDING    = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.925 -0500", hash_original_field = "771BD5A02744EF0A57080CABE0608826", hash_generated_field = "DF462EA5CD01B99AD41758C41F4F8E63")

    public final static int PLAYSTATE_REWINDING          = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.928 -0500", hash_original_field = "2F39FB087F798E8EA3B531A918CAFFC2", hash_generated_field = "35E136D27B02C2075FEAF30610947F93")

    public final static int PLAYSTATE_SKIPPING_FORWARDS  = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.931 -0500", hash_original_field = "DC7388DD65D49A7F42AE8529BF358ACB", hash_generated_field = "66CB7FA527A0829DAAFBA60CE93D1385")

    public final static int PLAYSTATE_SKIPPING_BACKWARDS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.934 -0500", hash_original_field = "AFAF8BD3E5F9A8DA7CD1E81FEDBE0A57", hash_generated_field = "CF7819B197FB94121B302B9141F6961C")

    public final static int PLAYSTATE_BUFFERING          = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.937 -0500", hash_original_field = "ED059DF863694A37EA8E2C925675994D", hash_generated_field = "6CAACC1CF95FAD80651991CB4C906A4D")

    public final static int PLAYSTATE_ERROR              = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.940 -0500", hash_original_field = "E431013F91395532CC0181AD1D95079B", hash_generated_field = "61319DA85C97420F017C045A9C1729C8")

    public final static int PLAYSTATE_NONE               = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.943 -0500", hash_original_field = "F396896B253DA02DE35173A8DAE0E653", hash_generated_field = "931215A39F00B68E217366A4C8AA9303")

    public final static int PLAYBACK_TYPE_LOCAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.946 -0500", hash_original_field = "D72AD28E171A7C9DD0DDCC1A7E898F0B", hash_generated_field = "C4D0A558124A6777CB02202E7632B51B")

    public final static int PLAYBACK_TYPE_REMOTE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.949 -0500", hash_original_field = "F42321BBC403D931D33BBFD3763DEF3B", hash_generated_field = "A84693D72CAC0C64C7C956385F7F1223")

    private final static int PLAYBACK_TYPE_MIN = PLAYBACK_TYPE_LOCAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.952 -0500", hash_original_field = "48BFA16423C0F7DB1641DF8A61A047EE", hash_generated_field = "B8F30B4AFF6458E1596250BA9C7D0A48")

    private final static int PLAYBACK_TYPE_MAX = PLAYBACK_TYPE_REMOTE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.955 -0500", hash_original_field = "1D781395108501371306C0DB283F1862", hash_generated_field = "81612D5F5D691C4EB45CBA1684B7ED88")

    public final static int PLAYBACK_VOLUME_FIXED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.958 -0500", hash_original_field = "A05090A8BA8E22CE13DE8638D2327761", hash_generated_field = "5664201DCAA1A0D003FFDBB963135DC7")

    public final static int PLAYBACK_VOLUME_VARIABLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.961 -0500", hash_original_field = "98A96881B97CB6918FD66C84E88A7AB5", hash_generated_field = "A139C5513BB9C3755875F23328B9F3D6")

    public final static int PLAYBACKINFO_INVALID_VALUE = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.963 -0500", hash_original_field = "A7B015A7CC1597AFAAE839247E9F79E4", hash_generated_field = "ABCB139E68797E241A9F400A55D6FC9E")

    public final static long PLAYBACK_POSITION_INVALID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.966 -0500", hash_original_field = "96AF65EB1123FDAA8F4549CC13E87164", hash_generated_field = "B56E59D160C3BCE7B8640A9BC94051D4")

    public final static long PLAYBACK_POSITION_ALWAYS_UNKNOWN = 0x8019771980198300L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.969 -0500", hash_original_field = "E4D1A46275756D5EA8B4DBB054E3C3FC", hash_generated_field = "1CE2895C09220E3F0ED8045EF282D9ED")

    public final static float PLAYBACK_SPEED_1X = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.972 -0500", hash_original_field = "5EB073E4817E6082144F268CB91D4B80", hash_generated_field = "45B27EAFBB564B687BAE49E5F14E3FD6")

    // Public keys for playback information
    /**
     * @hide
     * Playback information that defines the type of playback associated with this
     * RemoteControlClient. See {@link #PLAYBACK_TYPE_LOCAL} and {@link #PLAYBACK_TYPE_REMOTE}.
     */
    public final static int PLAYBACKINFO_PLAYBACK_TYPE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.976 -0500", hash_original_field = "084E4C5630E56C8BFBBDDDAD6B8FC332", hash_generated_field = "DD3338F9C15D5A8E5149769AB08A6C1E")

    public final static int PLAYBACKINFO_VOLUME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.978 -0500", hash_original_field = "9A0FCC657BA98B4BAA55B2690A8C23D9", hash_generated_field = "ECF85B9D5BB03F50A53AE2B77110C3EA")

    public final static int PLAYBACKINFO_VOLUME_MAX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.981 -0500", hash_original_field = "02B944336C338E51213CEFE93DA2C76B", hash_generated_field = "B17A9800C6EAEF6EDE29A6F58CD2FB0A")

    public final static int PLAYBACKINFO_VOLUME_HANDLING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.991 -0500", hash_original_field = "24E674F4C5CEDB93EECA5F6E2BC2882E", hash_generated_field = "6E6C3E47E8FB096EF5D6D8AE8F3F8869")

    public final static int PLAYBACKINFO_USES_STREAM = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.994 -0500", hash_original_field = "24A7BA8AD75D6BFFF8A3D2AE0E3DD869", hash_generated_field = "0636C7623841B4DBE3F9186BE3AAD877")

    // Public flags for the supported transport control capabilities
    /**
     * Flag indicating a RemoteControlClient makes use of the "previous" media key.
     *
     * @see #setTransportControlFlags(int)
     * @see android.view.KeyEvent#KEYCODE_MEDIA_PREVIOUS
     */
    public final static int FLAG_KEY_MEDIA_PREVIOUS = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:05.997 -0500", hash_original_field = "3A34DDEF07A947F37D764775E986333F", hash_generated_field = "E60961DC3DFBE2A350F7E65CD95479FA")

    public final static int FLAG_KEY_MEDIA_REWIND = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.000 -0500", hash_original_field = "10D81DEBFDC5B25B467B55D94BAC3B2F", hash_generated_field = "C4AADE8FFD83074B2941C8BB305E5194")

    public final static int FLAG_KEY_MEDIA_PLAY = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.003 -0500", hash_original_field = "B2E2A48447193CE2E9EFB7950FA941D0", hash_generated_field = "A50B60387E829EE960A6C24801483960")

    public final static int FLAG_KEY_MEDIA_PLAY_PAUSE = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.006 -0500", hash_original_field = "1A8255712733CAE58873BD693566AAEA", hash_generated_field = "3037539F2A50CCC54FEF961DB8032CE3")

    public final static int FLAG_KEY_MEDIA_PAUSE = 1 << 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.009 -0500", hash_original_field = "4C791594D621D22CB5BB863725B8F5EA", hash_generated_field = "EB951276E4926A00C8B2D0185D744968")

    public final static int FLAG_KEY_MEDIA_STOP = 1 << 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.012 -0500", hash_original_field = "A40BF8CFE6CE428B085EFC1E483E947B", hash_generated_field = "727BB4258CAB824CD82070CC756209D0")

    public final static int FLAG_KEY_MEDIA_FAST_FORWARD = 1 << 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.014 -0500", hash_original_field = "D6CE591284C44F4CB225B911AEA655DA", hash_generated_field = "AA28402D84BB64B0BBA8663A9933668C")

    public final static int FLAG_KEY_MEDIA_NEXT = 1 << 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.017 -0500", hash_original_field = "08B1126374CE2B49576542CBFF4A23B9", hash_generated_field = "0C66C128CA92056095533110B2ABC1D2")

    public final static int FLAG_KEY_MEDIA_POSITION_UPDATE = 1 << 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.021 -0500", hash_original_field = "55DA9E39A228781415C37CB6B83DAB88", hash_generated_field = "69F8ECB2680C2648C44FFD84EC8F50D3")

    public final static int FLAGS_KEY_MEDIA_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.024 -0500", hash_original_field = "9EFDE1B76B963D38A60973864F6DC1C8", hash_generated_field = "9E8AFBDC008F82D3058F352782A0E928")

    public final static int FLAG_INFORMATION_REQUEST_METADATA = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.027 -0500", hash_original_field = "B91643F1BD775667646F5B7F888E553F", hash_generated_field = "78AAB419BAA72EC0F3DF7F385ECF46E0")

    public final static int FLAG_INFORMATION_REQUEST_KEY_MEDIA = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.029 -0500", hash_original_field = "EA543F91046F53C1E0C98B15A20C9FAD", hash_generated_field = "3B5B3AE1258E6EDAA51221A3AED72F72")

    public final static int FLAG_INFORMATION_REQUEST_PLAYSTATE = 1 << 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.032 -0500", hash_original_field = "14993273CD22D5F283A9712134CB0E4A", hash_generated_field = "28B78930FAA93C3B508BFC7444D9B284")

    public final static int FLAG_INFORMATION_REQUEST_ALBUM_ART = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.043 -0500", hash_original_field = "C601146C90701E3A7B0C92D4A446C090", hash_generated_field = "0FD52E847D577969F790EF01F30CA0E3")

    private static final int[] METADATA_KEYS_TYPE_STRING = {
        MediaMetadataRetriever.METADATA_KEY_ALBUM,
        MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_ARTIST,
        MediaMetadataRetriever.METADATA_KEY_AUTHOR,
        MediaMetadataRetriever.METADATA_KEY_COMPILATION,
        MediaMetadataRetriever.METADATA_KEY_COMPOSER,
        MediaMetadataRetriever.METADATA_KEY_DATE,
        MediaMetadataRetriever.METADATA_KEY_GENRE,
        MediaMetadataRetriever.METADATA_KEY_TITLE,
        MediaMetadataRetriever.METADATA_KEY_WRITER };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.046 -0500", hash_original_field = "FCB31370F436C268F4C564FBC75B71C1", hash_generated_field = "C58FCF18F5F9EC50B35A59C6AC7F2853")

    private static final int[] METADATA_KEYS_TYPE_LONG = {
        MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
        MediaMetadataRetriever.METADATA_KEY_DURATION };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.119 -0500", hash_original_field = "D906EF439EF6090A2427FEB29B136CBA", hash_generated_field = "7ADC319D707568ADBA15B0FC744D6A36")

    public static int MEDIA_POSITION_READABLE = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.122 -0500", hash_original_field = "DA8D73A5BEF963C4D542A8C3E13E5EA5", hash_generated_field = "ADF6C741FC69EF275FA32A5A8C38F8AA")

    public static int MEDIA_POSITION_WRITABLE = 1 << 1;

    /**
     * Class used to modify metadata in a {@link RemoteControlClient} object.
     * Use {@link RemoteControlClient#editMetadata(boolean)} to create an instance of an editor,
     * on which you set the metadata for the RemoteControlClient instance. Once all the information
     * has been set, use {@link #apply()} to make it the new metadata that should be displayed
     * for the associated client. Once the metadata has been "applied", you cannot reuse this
     * instance of the MetadataEditor.
     */
    public class MetadataEditor {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.066 -0500", hash_original_field = "798C73B48C1720DC8E87ACAC7237A8A4", hash_generated_field = "483347541B59F8DFA8B12B3C1A84C12D")

        public final static int BITMAP_KEY_ARTWORK = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.070 -0500", hash_original_field = "CF9F190073A64E67C9896B6B34E508C6", hash_generated_field = "B8846CA5BE8D5CB94BBEF3C2B4B1EC50")

        public final static int METADATA_KEY_ARTWORK = BITMAP_KEY_ARTWORK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.049 -0500", hash_original_field = "622108C3E9B8EFAF8ED6C5165A1A6ABC", hash_generated_field = "B4345E59801D3DC5F4E85DD85D29A43C")

        protected boolean mMetadataChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.052 -0500", hash_original_field = "C2BC508F235068F2A96D1F238CADD5F5", hash_generated_field = "ECD34150F8B85611F271E6014D9D883D")

        protected boolean mArtworkChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.054 -0500", hash_original_field = "8A39F1373D6A94D088EC79F3B656DA96", hash_generated_field = "0EF4A2673652F896972F4DB3B96FB334")

        protected Bitmap mEditorArtwork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.057 -0500", hash_original_field = "903D0AF6CE9BFD67885C9AFA85CCBD5F", hash_generated_field = "85DB44FBC7E40E567386653DF585C1CB")

        protected Bundle mEditorMetadata;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.059 -0500", hash_original_field = "40BAEC93188E536D15CF2B2337719433", hash_generated_field = "FDEB24494AE0377307265E3205B5F5A1")

        private boolean mApplied = false;

        // only use RemoteControlClient.editMetadata() to get a MetadataEditor instance
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.061 -0500", hash_original_method = "35489133548A4653F80D8552B0E58378", hash_generated_method = "D23F08C438C4A5D443103A3BB522D763")
        
private MetadataEditor() { }
        /**
         * @hide
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.064 -0500", hash_original_method = "3FF219DE1407B1650498BA4CB70E771E", hash_generated_method = "141020EC3D770673B593D9DD4405C05B")
        
public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        /**
         * Adds textual information to be displayed.
         * Note that none of the information added after {@link #apply()} has been called,
         * will be displayed.
         * @param key The identifier of a the metadata field to set. Valid values are
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUM},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUMARTIST},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ARTIST},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_AUTHOR},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPILATION},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPOSER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DATE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_GENRE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_WRITER}.
         * @param value The text for the given key, or {@code null} to signify there is no valid
         *      information for the field.
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.073 -0500", hash_original_method = "DC698BF42DF290A93E2069AFDF9D8834", hash_generated_method = "9D6C1D30EF87D2D281AFDF9C8033C1D2")
        
public synchronized MetadataEditor putString(int key, String value)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (!validTypeForKey(key, METADATA_KEYS_TYPE_STRING)) {
                throw(new IllegalArgumentException("Invalid type 'String' for key "+ key));
            }
            mEditorMetadata.putString(String.valueOf(key), value);
            mMetadataChanged = true;
            return this;
        }

        /**
         * Adds numerical information to be displayed.
         * Note that none of the information added after {@link #apply()} has been called,
         * will be displayed.
         * @param key the identifier of a the metadata field to set. Valid values are
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_CD_TRACK_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DISC_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} (with a value
         *      expressed in milliseconds),
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_YEAR}.
         * @param value The long value for the given key
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         * @throws IllegalArgumentException
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.076 -0500", hash_original_method = "59EE363FF7F9B37AD6A675925DC53A2A", hash_generated_method = "7524C4B555C421A3B5F0BEC02CB74913")
        
public synchronized MetadataEditor putLong(int key, long value)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (!validTypeForKey(key, METADATA_KEYS_TYPE_LONG)) {
                throw(new IllegalArgumentException("Invalid type 'long' for key "+ key));
            }
            mEditorMetadata.putLong(String.valueOf(key), value);
            mMetadataChanged = true;
            return this;
        }

        /**
         * Sets the album / artwork picture to be displayed on the remote control.
         * @param key the identifier of the bitmap to set. The only valid value is
         *      {@link #BITMAP_KEY_ARTWORK}
         * @param bitmap The bitmap for the artwork, or null if there isn't any.
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         * @throws IllegalArgumentException
         * @see android.graphics.Bitmap
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.078 -0500", hash_original_method = "F0A3063E9CA42E9B77AAE9D5A9FC2424", hash_generated_method = "4DAB0BF9FED768F2B88066A80EC615E9")
        
public synchronized MetadataEditor putBitmap(int key, Bitmap bitmap)
                throws IllegalArgumentException {
            if (mApplied) {
                Log.e(TAG, "Can't edit a previously applied MetadataEditor");
                return this;
            }
            if (key != BITMAP_KEY_ARTWORK) {
                throw(new IllegalArgumentException("Invalid type 'Bitmap' for key "+ key));
            }
            mEditorArtwork = bitmap;
            mArtworkChanged = true;
            return this;
        }

        /**
         * Clears all the metadata that has been set since the MetadataEditor instance was
         *     created with {@link RemoteControlClient#editMetadata(boolean)}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.081 -0500", hash_original_method = "0A0B775C77CB462F6342E4F76031A7F3", hash_generated_method = "9AAB45E22978F7BF8C40BB995418B766")
        
public synchronized void clear() {
            if (mApplied) {
                Log.e(TAG, "Can't clear a previously applied MetadataEditor");
                return;
            }
            mEditorMetadata.clear();
            mEditorArtwork = null;
        }

        /**
         * Associates all the metadata that has been set since the MetadataEditor instance was
         *     created with {@link RemoteControlClient#editMetadata(boolean)}, or since
         *     {@link #clear()} was called, with the RemoteControlClient. Once "applied",
         *     this MetadataEditor cannot be reused to edit the RemoteControlClient's metadata.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.084 -0500", hash_original_method = "651FB34EA4BE9D05D45A6EE1EEE51E2F", hash_generated_method = "8DFC2225FFB0E30358AECD44B4D14CDD")
        
public synchronized void apply() {
            if (mApplied) {
                Log.e(TAG, "Can't apply a previously applied MetadataEditor");
                return;
            }
            synchronized(mCacheLock) {
                // assign the edited data
                mMetadata = new Bundle(mEditorMetadata);
                if ((mOriginalArtwork != null) && (!mOriginalArtwork.equals(mEditorArtwork))) {
                    mOriginalArtwork.recycle();
                }
                mOriginalArtwork = mEditorArtwork;
                mEditorArtwork = null;
                if (mMetadataChanged & mArtworkChanged) {
                    // send to remote control display if conditions are met
                    sendMetadataWithArtwork_syncCacheLock();
                } else if (mMetadataChanged) {
                    // send to remote control display if conditions are met
                    sendMetadata_syncCacheLock();
                } else if (mArtworkChanged) {
                    // send to remote control display if conditions are met
                    sendArtwork_syncCacheLock();
                }
                mApplied = true;
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.126 -0500", hash_original_field = "DBA3992B2BB1E980D0B29A3F4F1AF5E8", hash_generated_field = "1AF4E9AADA5AEF555C774C9EEBEA7239")

    public final static int DEFAULT_PLAYBACK_VOLUME_HANDLING = PLAYBACK_VOLUME_VARIABLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.129 -0500", hash_original_field = "99C0592146924C22CE226774CFA7CF05", hash_generated_field = "A62C14FD1426F8E9D04E0FC7F0C79853")

    // hard-coded to the same number of steps as AudioService.MAX_STREAM_VOLUME[STREAM_MUSIC]
    public final static int DEFAULT_PLAYBACK_VOLUME = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.215 -0500", hash_original_field = "473BAB714903F4EA684EFB8AD5EB634C", hash_generated_field = "232BFE3C28B9AC1191DB9B9E1D3ADDFF")

    public final static int RCSE_ID_UNREGISTERED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.225 -0500", hash_original_field = "058C0A51BF09FFB24D96AF52AC8E1F71", hash_generated_field = "AACFB6D022148421C2F0C7D1E8331E7D")

    private final static int MSG_REQUEST_PLAYBACK_STATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.227 -0500", hash_original_field = "62E60A0A32E2FBE0FF2C13EB57A06D0D", hash_generated_field = "04F84EAB3F4DEDCC1CA54ADDFD303582")

    private final static int MSG_REQUEST_METADATA = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.230 -0500", hash_original_field = "2624290044AED7467B5724DCBCEABFCF", hash_generated_field = "D37436C8088C6C0DD8728AB37ADE0846")

    private final static int MSG_REQUEST_TRANSPORTCONTROL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.232 -0500", hash_original_field = "01CE1389D1A3924C43716129ABB42833", hash_generated_field = "8B1638BE5F1799455DA931602163CF68")

    private final static int MSG_REQUEST_ARTWORK = 4;

    /**
     * Interface definition for a callback to be invoked when the media playback position is
     * requested to be updated.
     * @see RemoteControlClient#FLAG_KEY_MEDIA_POSITION_UPDATE
     */
    public interface OnPlaybackPositionUpdateListener {
        /**
         * Called on the implementer to notify it that the playback head should be set at the given
         * position. If the position can be changed from its current value, the implementor of
         * the interface must also update the playback position using
         * {@link #setPlaybackState(int, long, float)} to reflect the actual new
         * position being used, regardless of whether it differs from the requested position.
         * Failure to do so would cause the system to not know the new actual playback position,
         * and user interface components would fail to show the user where playback resumed after
         * the position was updated.
         * @param newPositionMs the new requested position in the current media, expressed in ms.
         */
        void onPlaybackPositionUpdate(long newPositionMs);
    }

    /**
     * Interface definition for a callback to be invoked when the media playback position is
     * queried.
     * @see RemoteControlClient#FLAG_KEY_MEDIA_POSITION_UPDATE
     */
    public interface OnGetPlaybackPositionListener {
        /**
         * Called on the implementer of the interface to query the current playback position.
         * @return a negative value if the current playback position (or the last valid playback
         *     position) is not known, or a zero or positive value expressed in ms indicating the
         *     current position, or the last valid known position.
         */
        long onGetPlaybackPosition();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.235 -0500", hash_original_field = "732479C843AD0CB020B8A5E91D71F508", hash_generated_field = "92F3229CC0658FD8B22E0EDEA145897F")

    private final static int MSG_NEW_INTERNAL_CLIENT_GEN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.238 -0500", hash_original_field = "2E46A1AF067AAB4AD15EA72C67A52961", hash_generated_field = "29900B94B2A6D2360A16D8FD28735F4E")

    private final static int MSG_NEW_CURRENT_CLIENT_GEN = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.241 -0500", hash_original_field = "093AFE698B5AAA44F7B27A16E3F80F9E", hash_generated_field = "E8EBAAC9849DE665CC38834147B90E01")

    private final static int MSG_PLUG_DISPLAY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.243 -0500", hash_original_field = "6CAD6F879E7686E071B2F1BE0DF47AE3", hash_generated_field = "9A2D676D79FDA0EEDBD63F1D0F038755")

    private final static int MSG_UNPLUG_DISPLAY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.245 -0500", hash_original_field = "704B659AF4F5C20614BF51E0ECA489DC", hash_generated_field = "6273DCB153FDE8F581CCC6599C920CB5")

    private final static int MSG_UPDATE_DISPLAY_ARTWORK_SIZE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.247 -0500", hash_original_field = "9F70D03568E612754A62B56E8B5B2DEA", hash_generated_field = "6B1D4A92A9F6C1154C837E3D80689CBE")

    private final static int MSG_SEEK_TO = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.250 -0500", hash_original_field = "5A71E7435189BD1D9D08B54468F15CB8", hash_generated_field = "8388D755BAF6D12BEDA3CA85CEC69784")

    private final static int MSG_POSITION_DRIFT_CHECK = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.252 -0500", hash_original_field = "AB52603A00EC48332660C8980B603291", hash_generated_field = "CCD8C260D561F14B66192536A86D268B")

    private final static int MSG_DISPLAY_WANTS_POS_SYNC = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.273 -0500", hash_original_field = "84E547D659D421C1515D62D6E0D7BBA4", hash_generated_field = "811AAD989A24C4717C6C5DFCA85945C4")

    // Communication with AudioService

    private static IAudioService sService;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.276 -0500", hash_original_method = "4C7645D232D763BA4F570538A2273FAB", hash_generated_method = "167786996F36B4A84FAE42E57D8CB72B")
    
private static IAudioService getService()
    {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService(Context.AUDIO_SERVICE);
        sService = IAudioService.Stub.asInterface(b);
        return sService;
    }

    /**
     *  Fast routine to go through an array of allowed keys and return whether the key is part
     *  of that array
     * @param key the key value
     * @param validKeys the array of valid keys for a given type
     * @return true if the key is part of the array, false otherwise
     */
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.304 -0500", hash_original_method = "4A0DB7CDD8D20C21F04F248D2D66CAA9", hash_generated_method = "3E21B50F1D5A689AD570BCD1BFAD30C6")
    
private static boolean validTypeForKey(int key, int[] validKeys) {
        try {
            for (int i = 0 ; ; i++) {
                if (key == validKeys[i]) {
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Returns whether, for the given playback state, the playback position is expected to
     * be changing.
     * @param playstate the playback state to evaluate
     * @return true during any form of playback, false if it's not playing anything while in this
     *     playback state
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.306 -0500", hash_original_method = "B03F4A99C18FA0994CE7B5B916449626", hash_generated_method = "A2EDE2EC0FB01F4648DD165B30235360")
    
private static boolean playbackPositionShouldMove(int playstate) {
        switch(playstate) {
            case PLAYSTATE_STOPPED:
            case PLAYSTATE_PAUSED:
            case PLAYSTATE_BUFFERING:
            case PLAYSTATE_ERROR:
            case PLAYSTATE_SKIPPING_FORWARDS:
            case PLAYSTATE_SKIPPING_BACKWARDS:
                return false;
            case PLAYSTATE_PLAYING:
            case PLAYSTATE_FAST_FORWARDING:
            case PLAYSTATE_REWINDING:
            default:
                return true;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.308 -0500", hash_original_field = "0B23C8917AB26F091E1810340774CA22", hash_generated_field = "D4566987E9E3A442346222408714FAA0")

    private final static long POSITION_REFRESH_PERIOD_PLAYING_MS = 15000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.310 -0500", hash_original_field = "A80EB62C2C74A47A7D6AFFA8005C7195", hash_generated_field = "94383450083D62E8D9DC7748CCE9B01A")

    private final static long POSITION_REFRESH_PERIOD_MIN_MS = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.312 -0500", hash_original_field = "6BC1549293D34D868A086F202454D5E9", hash_generated_field = "877BC8FEB066F39E6F6B6C5622BBCAD6")

    private final static long POSITION_DRIFT_MAX_MS = 500;
    /**
     * Compute the period at which the estimated playback position should be compared against the
     * actual playback position. Is a funciton of playback speed.
     * @param speed 1.0f is normal playback speed
     * @return the period in ms
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.314 -0500", hash_original_method = "A0BD117903590E30F2132CDFF7F894BF", hash_generated_method = "08E9D64FE972882CE1139F61A0569961")
    
private static long getCheckPeriodFromSpeed(float speed) {
        if (Math.abs(speed) <= 1.0f) {
            return POSITION_REFRESH_PERIOD_PLAYING_MS;
        } else {
            return Math.max((long)(POSITION_REFRESH_PERIOD_PLAYING_MS / Math.abs(speed)),
                    POSITION_REFRESH_PERIOD_MIN_MS);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.123 -0500", hash_original_field = "A26943EDCC726073A72AEF13033B09B7", hash_generated_field = "6DCD245AC6F8AF8A6BB59C87E6B5DBC1")

    private int mPlaybackPositionCapabilities = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.131 -0500", hash_original_field = "61F0263B82AF0AE4BB811E8F436549B3", hash_generated_field = "7BD1FC11970DCD099EB8CC3E5E04DD85")

    private int mPlaybackType = PLAYBACK_TYPE_LOCAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.134 -0500", hash_original_field = "36A839C94352ED622BB41BBE2A5B6D36", hash_generated_field = "D1A4566443DDE39DC865CD8987D4F520")

    private int mPlaybackVolumeMax = DEFAULT_PLAYBACK_VOLUME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.136 -0500", hash_original_field = "4AC66BD1623B98FA2169002B34B46523", hash_generated_field = "EE998310CA7F724A9E46CD3D566335AE")

    private int mPlaybackVolume = DEFAULT_PLAYBACK_VOLUME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.138 -0500", hash_original_field = "BC28BB36A9DCFF7A0C93FDC0353C61CB", hash_generated_field = "745C50FB619819333F20838B558F64C2")

    private int mPlaybackVolumeHandling = DEFAULT_PLAYBACK_VOLUME_HANDLING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.141 -0500", hash_original_field = "BD26282B61613DEFDF62950F9BD78D11", hash_generated_field = "8F2A7D5EE4DD1C45CB798391A6DDAC66")

    private int mPlaybackStream = AudioManager.STREAM_MUSIC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.148 -0500", hash_original_field = "D67B76FEB675AA6CF283F5022BA1C7D3", hash_generated_field = "84304313B5BE2FAF3B60D13295A73C77")

    private final Object mCacheLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.150 -0500", hash_original_field = "F04F146DFFBE1A936AF53FC8A346992B", hash_generated_field = "4614F38337BAA651A52883AEA4B73289")

    private int mPlaybackState = PLAYSTATE_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.152 -0500", hash_original_field = "38263EE2508C61CD923AB317CAEC020F", hash_generated_field = "1BEC69AD7A22658EBADD97D1E5E40CB0")

    private long mPlaybackStateChangeTimeMs = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.155 -0500", hash_original_field = "D0A567E832FD808D27E93A759E04377E", hash_generated_field = "ADC32D5CAD0298C95B74A28AFEA8A275")

    private long mPlaybackPositionMs = PLAYBACK_POSITION_INVALID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.157 -0500", hash_original_field = "F8435F60379096AAE7B5994733CA2AC3", hash_generated_field = "E593D6280D81AA79F3C428B1E7FF88DA")

    private float mPlaybackSpeed = PLAYBACK_SPEED_1X;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.159 -0500", hash_original_field = "EDDFAAEBA46214ED61341152149A0A96", hash_generated_field = "E2BD65CE1D60BCD65A221193E442356E")

    private Bitmap mOriginalArtwork;

    /**
     * A class to encapsulate all the information about a remote control display.
     * A RemoteControlClient's metadata and state may be displayed on multiple IRemoteControlDisplay
     */
    private class DisplayInfoForClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.178 -0500", hash_original_field = "FF3481DE069C9A568B0BD73FBAC6FE4F", hash_generated_field = "6F5BD225EE2017EE2B9E17B1141913F9")

        private IRemoteControlDisplay mRcDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.180 -0500", hash_original_field = "60F88B48E216975A74546F205FD90301", hash_generated_field = "170BA927F0DB911790EF821CB02D58B6")

        private int mArtworkExpectedWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.182 -0500", hash_original_field = "3A0505C48704B33992BA577192BEACCE", hash_generated_field = "84E4D8A3C76C9A6CD2E79D9F2B1F741A")

        private int mArtworkExpectedHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.184 -0500", hash_original_field = "949D0E8BD857F104BCAD56570E34C14E", hash_generated_field = "31760B281F20A772828535E8D30C594E")

        private boolean mWantsPositionSync = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.186 -0500", hash_original_method = "37998D1947B42CFDC5496F9E6CEC0D02", hash_generated_method = "37998D1947B42CFDC5496F9E6CEC0D02")
        
DisplayInfoForClient(IRemoteControlDisplay rcd, int w, int h) {
            mRcDisplay = rcd;
            mArtworkExpectedWidth = w;
            mArtworkExpectedHeight = h;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.161 -0500", hash_original_field = "2F98E79D6B1DD013C7751A7FEB56F3D3", hash_generated_field = "D886D0C4ACF243C5481BBD5AAC40B711")

    private int mTransportControlFlags = FLAGS_KEY_MEDIA_NONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.163 -0500", hash_original_field = "054167D3EF3FA02F61C449EC8EBE98A2", hash_generated_field = "DA6670A1846875744AFAE7AA4DEC9FDF")

    private Bundle mMetadata = new Bundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.165 -0500", hash_original_field = "B02A285148BDE55BC4D45A270C03DF66", hash_generated_field = "F475F2FFB4C022E1C8DA616CC1C4F3B0")

    private OnPlaybackPositionUpdateListener mPositionUpdateListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.167 -0500", hash_original_field = "936C4979F97943DCA672BEBC87957D00", hash_generated_field = "F83B7BB374C7CB065390C650C2936408")

    private OnGetPlaybackPositionListener mPositionProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.168 -0500", hash_original_field = "121007215D74BDEA1A80A488684D35AD", hash_generated_field = "9EB4244C60785911067FC7413E2DE31B")

    private int mCurrentClientGenId = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.170 -0500", hash_original_field = "BB478E8A062D1E115C20298ADBCFD276", hash_generated_field = "14D22A774763FE83A163754E1995815C")

    private int mInternalClientGenId = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.173 -0500", hash_original_field = "ABD800CAE01FE6B1027F1A977B19C1C2", hash_generated_field = "0D33962CDFCC7D569FC4E814D31B5DFB")

    private  PendingIntent mRcMediaIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.175 -0500", hash_original_field = "220F9DE7E178F61CBADF3BFB0968FC30", hash_generated_field = "28BB57546D7E4E22AC2DF0EC1C5D9EB3")

    // TODO consider using a ref count for IRemoteControlDisplay requiring sync instead
    private boolean mNeedsPositionSync = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.189 -0500", hash_original_field = "0BB8CA81728EF369BEEE121D4EB79417", hash_generated_field = "491F9B401A14028C266414CFF25CE87C")

    private ArrayList<DisplayInfoForClient> mRcDisplays = new ArrayList<DisplayInfoForClient>(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.212 -0500", hash_original_field = "EC9693D6783521EA3861F4270B23E007", hash_generated_field = "5FC89095C44D894AD4BEF52B731801D1")

    private final IRemoteControlClient mIRCC = new IRemoteControlClient.Stub() {

        public void onInformationRequested(int generationId, int infoFlags) {
            // only post messages, we can't block here
            if (mEventHandler != null) {
                // signal new client
                mEventHandler.removeMessages(MSG_NEW_INTERNAL_CLIENT_GEN);
                mEventHandler.sendMessage(
                        mEventHandler.obtainMessage(MSG_NEW_INTERNAL_CLIENT_GEN,
                                /*arg1*/ generationId, /*arg2, ignored*/ 0));
                // send the information
                mEventHandler.removeMessages(MSG_REQUEST_PLAYBACK_STATE);
                mEventHandler.removeMessages(MSG_REQUEST_METADATA);
                mEventHandler.removeMessages(MSG_REQUEST_TRANSPORTCONTROL);
                mEventHandler.removeMessages(MSG_REQUEST_ARTWORK);
                mEventHandler.sendMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_PLAYBACK_STATE));
                mEventHandler.sendMessage(
                        mEventHandler.obtainMessage(MSG_REQUEST_TRANSPORTCONTROL));
                mEventHandler.sendMessage(mEventHandler.obtainMessage(MSG_REQUEST_METADATA));
                mEventHandler.sendMessage(mEventHandler.obtainMessage(MSG_REQUEST_ARTWORK));
            }
        }

        public void setCurrentClientGenerationId(int clientGeneration) {
            // only post messages, we can't block here
            if (mEventHandler != null) {
                mEventHandler.removeMessages(MSG_NEW_CURRENT_CLIENT_GEN);
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_NEW_CURRENT_CLIENT_GEN, clientGeneration, 0/*ignored*/));
            }
        }

        public void plugRemoteControlDisplay(IRemoteControlDisplay rcd, int w, int h) {
            // only post messages, we can't block here
            if ((mEventHandler != null) && (rcd != null)) {
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_PLUG_DISPLAY, w, h, rcd));
            }
        }

        public void unplugRemoteControlDisplay(IRemoteControlDisplay rcd) {
            // only post messages, we can't block here
            if ((mEventHandler != null) && (rcd != null)) {
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_UNPLUG_DISPLAY, rcd));
            }
        }

        public void setBitmapSizeForDisplay(IRemoteControlDisplay rcd, int w, int h) {
            // only post messages, we can't block here
            if ((mEventHandler != null) && (rcd != null)) {
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_UPDATE_DISPLAY_ARTWORK_SIZE, w, h, rcd));
            }
        }

        public void setWantsSyncForDisplay(IRemoteControlDisplay rcd, boolean wantsSync) {
            // only post messages, we can't block here
            if ((mEventHandler != null) && (rcd != null)) {
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_DISPLAY_WANTS_POS_SYNC, wantsSync ? 1 : 0, 0/*arg2 ignored*/, rcd));
            }
        }

        public void seekTo(int generationId, long timeMs) {
            // only post messages, we can't block here
            if (mEventHandler != null) {
                mEventHandler.removeMessages(MSG_SEEK_TO);
                mEventHandler.sendMessage(mEventHandler.obtainMessage(
                        MSG_SEEK_TO, generationId /* arg1 */, 0 /* arg2, ignored */,
                        new Long(timeMs)));
            }
        }

        @Override
        public void onInformationRequested(int generationId, int infoFlags,
                int artWidth, int artHeight) throws RemoteException {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void plugRemoteControlDisplay(IRemoteControlDisplay rcd)
                throws RemoteException {
            // TODO Auto-generated method stub
            
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.216 -0500", hash_original_field = "AB9947891CEFBFBDC34B201DA84DDDA2", hash_generated_field = "8356A5D9AC9419CD1F4B2428DC5448C9")

    private int mRcseId = RCSE_ID_UNREGISTERED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.222 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;

    /**
     * Class constructor.
     * @param mediaButtonIntent The intent that will be sent for the media button events sent
     *     by remote controls.
     *     This intent needs to have been constructed with the {@link Intent#ACTION_MEDIA_BUTTON}
     *     action, and have a component that will handle the intent (set with
     *     {@link Intent#setComponent(ComponentName)}) registered with
     *     {@link AudioManager#registerMediaButtonEventReceiver(ComponentName)}
     *     before this new RemoteControlClient can itself be registered with
     *     {@link AudioManager#registerRemoteControlClient(RemoteControlClient)}.
     * @see AudioManager#registerMediaButtonEventReceiver(ComponentName)
     * @see AudioManager#registerRemoteControlClient(RemoteControlClient)
     */
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.036 -0500", hash_original_method = "AD6CCD9D9B436D492F90BC57466F8BB6", hash_generated_method = "28D4AB3908D0D540BF76A156E34290C8")
    
public RemoteControlClient(PendingIntent mediaButtonIntent) {
        mRcMediaIntent = mediaButtonIntent;

        Looper looper;
        if ((looper = Looper.myLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else if ((looper = Looper.getMainLooper()) != null) {
            mEventHandler = new EventHandler(this, looper);
        } else {
            mEventHandler = null;
            Log.e(TAG, "RemoteControlClient() couldn't find main application thread");
        }
    }

    /**
     * Class constructor for a remote control client whose internal event handling
     * happens on a user-provided Looper.
     * @param mediaButtonIntent The intent that will be sent for the media button events sent
     *     by remote controls.
     *     This intent needs to have been constructed with the {@link Intent#ACTION_MEDIA_BUTTON}
     *     action, and have a component that will handle the intent (set with
     *     {@link Intent#setComponent(ComponentName)}) registered with
     *     {@link AudioManager#registerMediaButtonEventReceiver(ComponentName)}
     *     before this new RemoteControlClient can itself be registered with
     *     {@link AudioManager#registerRemoteControlClient(RemoteControlClient)}.
     * @param looper The Looper running the event loop.
     * @see AudioManager#registerMediaButtonEventReceiver(ComponentName)
     * @see AudioManager#registerRemoteControlClient(RemoteControlClient)
     */
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.039 -0500", hash_original_method = "BBCB02942EAA4463B06F3A8D8D85915D", hash_generated_method = "7765B7729477EAF97C8D70200FCA521F")
    
public RemoteControlClient(PendingIntent mediaButtonIntent, Looper looper) {
        mRcMediaIntent = mediaButtonIntent;

        mEventHandler = new EventHandler(this, looper);
    }

    /**
     * Creates a {@link MetadataEditor}.
     * @param startEmpty Set to false if you want the MetadataEditor to contain the metadata that
     *     was previously applied to the RemoteControlClient, or true if it is to be created empty.
     * @return a new MetadataEditor instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.095 -0500", hash_original_method = "E1294EEEF2805C32D5A390412C991F9A", hash_generated_method = "6978562DA86A6A1E6878E5ED81296715")
    
public MetadataEditor editMetadata(boolean startEmpty) {
        MetadataEditor editor = new MetadataEditor();
        if (startEmpty) {
            editor.mEditorMetadata = new Bundle();
            editor.mEditorArtwork = null;
            editor.mMetadataChanged = true;
            editor.mArtworkChanged = true;
        } else {
            editor.mEditorMetadata = new Bundle(mMetadata);
            editor.mEditorArtwork = mOriginalArtwork;
            editor.mMetadataChanged = false;
            editor.mArtworkChanged = false;
        }
        return editor;
    }

    /**
     * Sets the current playback state.
     * @param state The current playback state, one of the following values:
     *       {@link #PLAYSTATE_STOPPED},
     *       {@link #PLAYSTATE_PAUSED},
     *       {@link #PLAYSTATE_PLAYING},
     *       {@link #PLAYSTATE_FAST_FORWARDING},
     *       {@link #PLAYSTATE_REWINDING},
     *       {@link #PLAYSTATE_SKIPPING_FORWARDS},
     *       {@link #PLAYSTATE_SKIPPING_BACKWARDS},
     *       {@link #PLAYSTATE_BUFFERING},
     *       {@link #PLAYSTATE_ERROR}.
     */
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.096 -0500", hash_original_method = "D38A15416CE332DCCFDCF1A5EC6FC0CD", hash_generated_method = "E0CBFDA35DA6885C16682FAA32BB6C7A")
    
public void setPlaybackState(int state) {
        setPlaybackStateInt(state, PLAYBACK_POSITION_ALWAYS_UNKNOWN, PLAYBACK_SPEED_1X,
                false /* legacy API, converting to method with position and speed */);
    }

    /**
     * Sets the current playback state and the matching media position for the current playback
     *   speed.
     * @param state The current playback state, one of the following values:
     *       {@link #PLAYSTATE_STOPPED},
     *       {@link #PLAYSTATE_PAUSED},
     *       {@link #PLAYSTATE_PLAYING},
     *       {@link #PLAYSTATE_FAST_FORWARDING},
     *       {@link #PLAYSTATE_REWINDING},
     *       {@link #PLAYSTATE_SKIPPING_FORWARDS},
     *       {@link #PLAYSTATE_SKIPPING_BACKWARDS},
     *       {@link #PLAYSTATE_BUFFERING},
     *       {@link #PLAYSTATE_ERROR}.
     * @param timeInMs a 0 or positive value for the current media position expressed in ms
     *    (same unit as for when sending the media duration, if applicable, with
     *    {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} in the
     *    {@link RemoteControlClient.MetadataEditor}). Negative values imply that position is not
     *    known (e.g. listening to a live stream of a radio) or not applicable (e.g. when state
     *    is {@link #PLAYSTATE_BUFFERING} and nothing had played yet).
     * @param playbackSpeed a value expressed as a ratio of 1x playback: 1.0f is normal playback,
     *    2.0f is 2x, 0.5f is half-speed, -2.0f is rewind at 2x speed. 0.0f means nothing is
     *    playing (e.g. when state is {@link #PLAYSTATE_ERROR}).
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.098 -0500", hash_original_method = "8B2AAF40BC5CC46CB9E02D7DF06C2F85", hash_generated_method = "48BCE842BAB23808F5C78DBDF2872E6E")
    
public void setPlaybackState(int state, long timeInMs, float playbackSpeed) {
        setPlaybackStateInt(state, timeInMs, playbackSpeed, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.101 -0500", hash_original_method = "50F6FBF04BC7347A7CC26CC048932D94", hash_generated_method = "CE99EF5E104A4D85B5B2BB94ADA4F377")
    
private void setPlaybackStateInt(int state, long timeInMs, float playbackSpeed,
            boolean hasPosition) {
        synchronized(mCacheLock) {
            if ((mPlaybackState != state) || (mPlaybackPositionMs != timeInMs)
                    || (mPlaybackSpeed != playbackSpeed)) {
                // store locally
                mPlaybackState = state;
                // distinguish between an application not knowing the current playback position
                // at the moment and an application using the API where only the playback state
                // is passed, not the playback position.
                if (hasPosition) {
                    if (timeInMs < 0) {
                        mPlaybackPositionMs = PLAYBACK_POSITION_INVALID;
                    } else {
                        mPlaybackPositionMs = timeInMs;
                    }
                } else {
                    mPlaybackPositionMs = PLAYBACK_POSITION_ALWAYS_UNKNOWN;
                }
                mPlaybackSpeed = playbackSpeed;
                // keep track of when the state change occurred
                mPlaybackStateChangeTimeMs = SystemClock.elapsedRealtime();

                // send to remote control display if conditions are met
                sendPlaybackState_syncCacheLock();
                // update AudioService
                sendAudioServiceNewPlaybackState_syncCacheLock();

                // handle automatic playback position refreshes
                initiateCheckForDrift_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.103 -0500", hash_original_method = "9E790D05AD07D7A0B41EA339AAB53A12", hash_generated_method = "9487AC917303D7F7D1B51E3EBDD76AB5")
    
private void initiateCheckForDrift_syncCacheLock() {
        if (mEventHandler == null) {
            return;
        }
        mEventHandler.removeMessages(MSG_POSITION_DRIFT_CHECK);
        if (!mNeedsPositionSync) {
            return;
        }
        if (mPlaybackPositionMs < 0) {
            // the current playback state has no known playback position, it's no use
            // trying to see if there is any drift at this point
            // (this also bypasses this mechanism for older apps that use the old
            //  setPlaybackState(int) API)
            return;
        }
        if (playbackPositionShouldMove(mPlaybackState)) {
            // playback position moving, schedule next position drift check
            mEventHandler.sendMessageDelayed(
                    mEventHandler.obtainMessage(MSG_POSITION_DRIFT_CHECK),
                    getCheckPeriodFromSpeed(mPlaybackSpeed));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.106 -0500", hash_original_method = "4532726F29C33E582A0AE3362CAF4BAE", hash_generated_method = "CD8DC1F39E42D7025FEC8A9B63BF5B08")
    
private void onPositionDriftCheck() {
        if (DEBUG) { Log.d(TAG, "onPositionDriftCheck()"); }
        synchronized(mCacheLock) {
            if ((mEventHandler == null) || (mPositionProvider == null) || !mNeedsPositionSync) {
                return;
            }
            if ((mPlaybackPositionMs < 0) || (mPlaybackSpeed == 0.0f)) {
                if (DEBUG) { Log.d(TAG, " no valid position or 0 speed, no check needed"); }
                return;
            }
            long estPos = mPlaybackPositionMs + (long)
                    ((SystemClock.elapsedRealtime() - mPlaybackStateChangeTimeMs) / mPlaybackSpeed);
            long actPos = mPositionProvider.onGetPlaybackPosition();
            if (actPos >= 0) {
                if (Math.abs(estPos - actPos) > POSITION_DRIFT_MAX_MS) {
                    // drift happened, report the new position
                    if (DEBUG) { Log.w(TAG, " drift detected: actual=" +actPos +"  est=" +estPos); }
                    setPlaybackState(mPlaybackState, actPos, mPlaybackSpeed);
                } else {
                    if (DEBUG) { Log.d(TAG, " no drift: actual=" + actPos +"  est=" + estPos); }
                    // no drift, schedule the next drift check
                    mEventHandler.sendMessageDelayed(
                            mEventHandler.obtainMessage(MSG_POSITION_DRIFT_CHECK),
                            getCheckPeriodFromSpeed(mPlaybackSpeed));
                }
            } else {
                // invalid position (negative value), can't check for drift
                mEventHandler.removeMessages(MSG_POSITION_DRIFT_CHECK);
            }
        }
    }

    /**
     * Sets the flags for the media transport control buttons that this client supports.
     * @param transportControlFlags A combination of the following flags:
     *      {@link #FLAG_KEY_MEDIA_PREVIOUS},
     *      {@link #FLAG_KEY_MEDIA_REWIND},
     *      {@link #FLAG_KEY_MEDIA_PLAY},
     *      {@link #FLAG_KEY_MEDIA_PLAY_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_PAUSE},
     *      {@link #FLAG_KEY_MEDIA_STOP},
     *      {@link #FLAG_KEY_MEDIA_FAST_FORWARD},
     *      {@link #FLAG_KEY_MEDIA_NEXT},
     *      {@link #FLAG_KEY_MEDIA_POSITION_UPDATE}
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.108 -0500", hash_original_method = "C71F899B9BE4AD8D52D6967222484942", hash_generated_method = "F6B841C205EC730B27C66813CE21E2A0")
    
public void setTransportControlFlags(int transportControlFlags) {
        synchronized(mCacheLock) {
            // store locally
            mTransportControlFlags = transportControlFlags;

            // send to remote control display if conditions are met
            sendTransportControlInfo_syncCacheLock();
        }
    }

    private class EventHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.255 -0500", hash_original_method = "E835DA7FA2605C7661321C420AF4C36C", hash_generated_method = "A8646DD88D641F31D499C91D3ED39A40")
        
public EventHandler(RemoteControlClient rcc, Looper looper) {
            super(looper);
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.257 -0500", hash_original_method = "A42F550C0A33AF3FDEBB42B214E14777", hash_generated_method = "00C15A487A6C470EC84F4EE0858DA75C")
        
@Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case MSG_REQUEST_PLAYBACK_STATE:
                    synchronized (mCacheLock) {
                        sendPlaybackState_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_METADATA:
                    synchronized (mCacheLock) {
                        sendMetadata_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_TRANSPORTCONTROL:
                    synchronized (mCacheLock) {
                        sendTransportControlInfo_syncCacheLock();
                    }
                    break;
                case MSG_REQUEST_ARTWORK:
                    synchronized (mCacheLock) {
                        sendArtwork_syncCacheLock();
                    }
                    break;
                case MSG_NEW_INTERNAL_CLIENT_GEN:
                    onNewInternalClientGen(msg.arg1);
                    break;
                case MSG_NEW_CURRENT_CLIENT_GEN:
                    onNewCurrentClientGen(msg.arg1);
                    break;
                case MSG_PLUG_DISPLAY:
                    onPlugDisplay((IRemoteControlDisplay)msg.obj, msg.arg1, msg.arg2);
                    break;
                case MSG_UNPLUG_DISPLAY:
                    onUnplugDisplay((IRemoteControlDisplay)msg.obj);
                    break;
                case MSG_UPDATE_DISPLAY_ARTWORK_SIZE:
                    onUpdateDisplayArtworkSize((IRemoteControlDisplay)msg.obj, msg.arg1, msg.arg2);
                    break;
                case MSG_SEEK_TO:
                    onSeekTo(msg.arg1, ((Long)msg.obj).longValue());
                    break;
                case MSG_POSITION_DRIFT_CHECK:
                    onPositionDriftCheck();
                    break;
                case MSG_DISPLAY_WANTS_POS_SYNC:
                    onDisplayWantsSync((IRemoteControlDisplay)msg.obj, msg.arg1 == 1);
                    break;
                default:
                    Log.e(TAG, "Unknown event " + msg.what + " in RemoteControlClient handler");
            }
        }
    }

    /**
     * Sets the listener to be called whenever the media playback position is requested
     * to be updated.
     * Notifications will be received in the same thread as the one in which RemoteControlClient
     * was created.
     * @param l the position update listener to be called
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.115 -0500", hash_original_method = "1028FC247361AB07F56CE699BFB3519A", hash_generated_method = "9AC6C2C334EE5FD669719418BBE887A8")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setPlaybackPositionUpdateListener(OnPlaybackPositionUpdateListener l) {
        synchronized(mCacheLock) {
            int oldCapa = mPlaybackPositionCapabilities;
            if (l != null) {
                mPlaybackPositionCapabilities |= MEDIA_POSITION_WRITABLE;
            } else {
                mPlaybackPositionCapabilities &= ~MEDIA_POSITION_WRITABLE;
            }
            mPositionUpdateListener = l;
            if (oldCapa != mPlaybackPositionCapabilities) {
                // tell RCDs that this RCC's playback position capabilities have changed
                sendTransportControlInfo_syncCacheLock();
            }
        }
        if (l != null) {
            l.onPlaybackPositionUpdate(DSUtils.FAKE_INT);
        }
    }

    /**
     * Sets the listener to be called whenever the media current playback position is needed.
     * Queries will be received in the same thread as the one in which RemoteControlClient
     * was created.
     * @param l the listener to be called to retrieve the playback position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.117 -0500", hash_original_method = "4FCD66E9AFB95B79C117581EE6D52583", hash_generated_method = "66A03C155766E98B5FF7DC0371A1C7F7")
    @DSVerified("callback modeled")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnGetPlaybackPositionListener(OnGetPlaybackPositionListener l) {
        if (l != null) {
            l.onGetPlaybackPosition();
        }
        synchronized(mCacheLock) {
            int oldCapa = mPlaybackPositionCapabilities;
            if (l != null) {
                mPlaybackPositionCapabilities |= MEDIA_POSITION_READABLE;
            } else {
                mPlaybackPositionCapabilities &= ~MEDIA_POSITION_READABLE;
            }
            mPositionProvider = l;
            if (oldCapa != mPlaybackPositionCapabilities) {
                // tell RCDs that this RCC's playback position capabilities have changed
                sendTransportControlInfo_syncCacheLock();
            }
            if ((mPositionProvider != null) && (mEventHandler != null)
                    && playbackPositionShouldMove(mPlaybackState)) {
                // playback position is already moving, but now we have a position provider,
                // so schedule a drift check right now
                mEventHandler.sendMessageDelayed(
                        mEventHandler.obtainMessage(MSG_POSITION_DRIFT_CHECK),
                        0 /*check now*/);
            }
        }
    }

    /**
     * @hide
     * Set information describing information related to the playback of media so the system
     * can implement additional behavior to handle non-local playback usecases.
     * @param what a key to specify the type of information to set. Valid keys are
     *        {@link #PLAYBACKINFO_PLAYBACK_TYPE},
     *        {@link #PLAYBACKINFO_USES_STREAM},
     *        {@link #PLAYBACKINFO_VOLUME},
     *        {@link #PLAYBACKINFO_VOLUME_MAX},
     *        and {@link #PLAYBACKINFO_VOLUME_HANDLING}.
     * @param value the value for the supplied information to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.144 -0500", hash_original_method = "CA3590F9A5F82F4976905BF0F036B18B", hash_generated_method = "09D3A4E71CB8703C840815041298B017")
    
public void setPlaybackInformation(int what, int value) {
        synchronized(mCacheLock) {
            switch (what) {
                case PLAYBACKINFO_PLAYBACK_TYPE:
                    if ((value >= PLAYBACK_TYPE_MIN) && (value <= PLAYBACK_TYPE_MAX)) {
                        if (mPlaybackType != value) {
                            mPlaybackType = value;
                            sendAudioServiceNewPlaybackInfo_syncCacheLock(what, value);
                        }
                    } else {
                        Log.w(TAG, "using invalid value for PLAYBACKINFO_PLAYBACK_TYPE");
                    }
                    break;
                case PLAYBACKINFO_VOLUME:
                    if ((value > -1) && (value <= mPlaybackVolumeMax)) {
                        if (mPlaybackVolume != value) {
                            mPlaybackVolume = value;
                            sendAudioServiceNewPlaybackInfo_syncCacheLock(what, value);
                        }
                    } else {
                        Log.w(TAG, "using invalid value for PLAYBACKINFO_VOLUME");
                    }
                    break;
                case PLAYBACKINFO_VOLUME_MAX:
                    if (value > 0) {
                        if (mPlaybackVolumeMax != value) {
                            mPlaybackVolumeMax = value;
                            sendAudioServiceNewPlaybackInfo_syncCacheLock(what, value);
                        }
                    } else {
                        Log.w(TAG, "using invalid value for PLAYBACKINFO_VOLUME_MAX");
                    }
                    break;
                case PLAYBACKINFO_USES_STREAM:
                    if ((value >= 0) && (value < AudioSystem.getNumStreamTypes())) {
                        mPlaybackStream = value;
                    } else {
                        Log.w(TAG, "using invalid value for PLAYBACKINFO_USES_STREAM");
                    }
                    break;
                case PLAYBACKINFO_VOLUME_HANDLING:
                    if ((value >= PLAYBACK_VOLUME_FIXED) && (value <= PLAYBACK_VOLUME_VARIABLE)) {
                        if (mPlaybackVolumeHandling != value) {
                            mPlaybackVolumeHandling = value;
                            sendAudioServiceNewPlaybackInfo_syncCacheLock(what, value);
                        }
                    } else {
                        Log.w(TAG, "using invalid value for PLAYBACKINFO_VOLUME_HANDLING");
                    }
                    break;
                default:
                    // not throwing an exception or returning an error if more keys are to be
                    // supported in the future
                    Log.w(TAG, "setPlaybackInformation() ignoring unknown key " + what);
                    break;
            }
        }
    }

    /**
     * @hide
     * Return playback information represented as an integer value.
     * @param what a key to specify the type of information to retrieve. Valid keys are
     *        {@link #PLAYBACKINFO_PLAYBACK_TYPE},
     *        {@link #PLAYBACKINFO_USES_STREAM},
     *        {@link #PLAYBACKINFO_VOLUME},
     *        {@link #PLAYBACKINFO_VOLUME_MAX},
     *        and {@link #PLAYBACKINFO_VOLUME_HANDLING}.
     * @return the current value for the given information type, or
     *   {@link #PLAYBACKINFO_INVALID_VALUE} if an error occurred or the request is invalid, or
     *   the value is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.146 -0500", hash_original_method = "3714225B8D0D43879332F0396A694F6F", hash_generated_method = "D7C1368B360B47CC18B03D84EF8D1926")
    
public int getIntPlaybackInformation(int what) {
        synchronized(mCacheLock) {
            switch (what) {
                case PLAYBACKINFO_PLAYBACK_TYPE:
                    return mPlaybackType;
                case PLAYBACKINFO_VOLUME:
                    return mPlaybackVolume;
                case PLAYBACKINFO_VOLUME_MAX:
                    return mPlaybackVolumeMax;
                case PLAYBACKINFO_USES_STREAM:
                    return mPlaybackStream;
                case PLAYBACKINFO_VOLUME_HANDLING:
                    return mPlaybackVolumeHandling;
                default:
                    Log.e(TAG, "getIntPlaybackInformation() unknown key " + what);
                    return PLAYBACKINFO_INVALID_VALUE;
            }
        }
    }

    /**
     * @hide
     * Accessor to media button intent description (includes target component)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.191 -0500", hash_original_method = "2C35ADA55DC65E9D8CCC19BDAA7D2B4B", hash_generated_method = "BBC7396E72B1D443036DEB203F92FE1D")
    
public PendingIntent getRcMediaIntent() {
        return mRcMediaIntent;
    }
    /**
     * @hide
     * Accessor to IRemoteControlClient
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.193 -0500", hash_original_method = "6031DEC176ACCB06C28473E7885E0907", hash_generated_method = "007775DBD88021AF731B42BCC3999D7F")
    
public IRemoteControlClient getIRemoteControlClient() {
        return mIRCC;
    }
    /**
     * @hide
     * To be only used by AudioManager after it has received the unique id from
     * IAudioService.registerRemoteControlClient()
     * @param id the unique identifier of the RemoteControlStackEntry in AudioService with which
     *              this RemoteControlClient is associated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.218 -0500", hash_original_method = "13ED42497C17D799985BF1807376F329", hash_generated_method = "9B444891E8057F09A4EE152A0479F8F8")
    
public void setRcseId(int id) {
        mRcseId = id;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.220 -0500", hash_original_method = "2223D1CF47FDE1DD7F8BA363D1B42D1E", hash_generated_method = "89F463DD921D358FD727A10ECE698FBA")
    
public int getRcseId() {
        return mRcseId;
    }

    //===========================================================
    // Communication with the IRemoteControlDisplay (the displays known to the system)

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.261 -0500", hash_original_method = "5867AA3C1424A54F7C4BC60A042B5812", hash_generated_method = "F861F0CAD85158EC2F8A10AF7DA0DDAF")
    
private void sendPlaybackState_syncCacheLock() {
        if (mCurrentClientGenId == mInternalClientGenId) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                /*
                try {
                    di.mRcDisplay.setPlaybackState(mInternalClientGenId,
                            mPlaybackState, mPlaybackStateChangeTimeMs, mPlaybackPositionMs,
                            mPlaybackSpeed);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error in setPlaybackState(), dead display " + di.mRcDisplay, e);
                    displayIterator.remove();
                }
                */
            }
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.263 -0500", hash_original_method = "2461580840E3BC06B1FBAD565CDCA812", hash_generated_method = "FF510CB142666F796E685E1D0047C60E")
    
private void sendMetadata_syncCacheLock() {
        if (mCurrentClientGenId == mInternalClientGenId) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                try {
                    di.mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error in setMetadata(), dead display " + di.mRcDisplay, e);
                    displayIterator.remove();
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.265 -0500", hash_original_method = "02D8C42387FB07C419FF06BE69528757", hash_generated_method = "DD27B7C7210DA4AE737708E722D2333E")
    
private void sendTransportControlInfo_syncCacheLock() {
        if (mCurrentClientGenId == mInternalClientGenId) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                /*
                try {
                    di.mRcDisplay.setTransportControlInfo(mInternalClientGenId,
                            mTransportControlFlags, mPlaybackPositionCapabilities);
                } catch (RemoteException e) {
                    Log.e(TAG, "Error in setTransportControlFlags(), dead display " + di.mRcDisplay,
                            e);
                    displayIterator.remove();
                }
                */
            }
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.267 -0500", hash_original_method = "565BF22C95D07FA61EB6E5BFBA9E2426", hash_generated_method = "5233F0C1519ED93F39CC75784BA0FFE0")
    
private void sendArtwork_syncCacheLock() {
        // FIXME modify to cache all requested sizes?
        if (mCurrentClientGenId == mInternalClientGenId) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                if (!sendArtworkToDisplay((DisplayInfoForClient) displayIterator.next())) {
                    displayIterator.remove();
                }
            }
        }
    }

    /**
     * Send artwork to an IRemoteControlDisplay.
     * @param di encapsulates the IRemoteControlDisplay that will receive the artwork, and its
     *    dimension requirements.
     * @return false if there was an error communicating with the IRemoteControlDisplay.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.269 -0500", hash_original_method = "B8AA68B6B6E796C4C5C77F9B9DE9F09A", hash_generated_method = "408BD193EBCAFFFFBE99D9652102E7B6")
    
private boolean sendArtworkToDisplay(DisplayInfoForClient di) {
        if ((di.mArtworkExpectedWidth > 0) && (di.mArtworkExpectedHeight > 0)) {
            Bitmap artwork = scaleBitmapIfTooBig(mOriginalArtwork,
                    di.mArtworkExpectedWidth, di.mArtworkExpectedHeight);
            try {
                di.mRcDisplay.setArtwork(mInternalClientGenId, artwork);
            } catch (RemoteException e) {
                Log.e(TAG, "Error in sendArtworkToDisplay(), dead display " + di.mRcDisplay, e);
                return false;
            }
        }
        return true;
    }

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.271 -0500", hash_original_method = "FD1C4D1548B30348A6DB0A4CF80EFABC", hash_generated_method = "4304A3DA5260D55E511B11DED4E38DE6")
    
private void sendMetadataWithArtwork_syncCacheLock() {
        // FIXME modify to cache all requested sizes?
        if (mCurrentClientGenId == mInternalClientGenId) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                try {
                    if ((di.mArtworkExpectedWidth > 0) && (di.mArtworkExpectedHeight > 0)) {
                        Bitmap artwork = scaleBitmapIfTooBig(mOriginalArtwork,
                                di.mArtworkExpectedWidth, di.mArtworkExpectedHeight);
                        di.mRcDisplay.setAllMetadata(mInternalClientGenId, mMetadata, artwork);
                    } else {
                        di.mRcDisplay.setMetadata(mInternalClientGenId, mMetadata);
                    }
                } catch (RemoteException e) {
                    Log.e(TAG, "Error when setting metadata, dead display " + di.mRcDisplay, e);
                    displayIterator.remove();
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.278 -0500", hash_original_method = "23B02993B3AE28F13F23665FBC065607", hash_generated_method = "8AAFDDF8884663A09720BA76A5BBFD87")
    
private void sendAudioServiceNewPlaybackInfo_syncCacheLock(int what, int value) {
        if (mRcseId == RCSE_ID_UNREGISTERED) {
            return;
        }
        //Log.d(TAG, "sending to AudioService key=" + what + ", value=" + value);
        IAudioService service = getService();
        /*
        try {
            service.setPlaybackInfoForRcc(mRcseId, what, value);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setPlaybackInfoForRcc", e);
        }
        */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.280 -0500", hash_original_method = "19553EE3A365EF9B01F88083C60B858A", hash_generated_method = "BBA3940381455747414A6118322D6DD5")
    
private void sendAudioServiceNewPlaybackState_syncCacheLock() {
        if (mRcseId == RCSE_ID_UNREGISTERED) {
            return;
        }
        IAudioService service = getService();
        /*
        try {
            service.setPlaybackStateForRcc(mRcseId,
                    mPlaybackState, mPlaybackPositionMs, mPlaybackSpeed);
        } catch (RemoteException e) {
            Log.e(TAG, "Dead object in setPlaybackStateForRcc", e);
        }
        */
    }

    //===========================================================
    // Message handlers

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.282 -0500", hash_original_method = "5D9294821C1943CFADA8918C2B590FAD", hash_generated_method = "9039B29DF52B66B2892A5C9A285B15D9")
    
private void onNewInternalClientGen(int clientGeneration) {
        synchronized (mCacheLock) {
            // this remote control client is told it is the "focused" one:
            // it implies that now (mCurrentClientGenId == mInternalClientGenId) is true
            mInternalClientGenId = clientGeneration;
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.284 -0500", hash_original_method = "6CA13622614E338BD9C3EB3C00B6EAD4", hash_generated_method = "E8745FF83CA44504DC617ADEC2967446")
    
private void onNewCurrentClientGen(int clientGeneration) {
        synchronized (mCacheLock) {
            mCurrentClientGenId = clientGeneration;
        }
    }

    /** pre-condition rcd != null */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.286 -0500", hash_original_method = "AA1E433AEEF1AD73F6AD524389681864", hash_generated_method = "1D7E48CA35980B3926C4BBF324CCD19A")
    
private void onPlugDisplay(IRemoteControlDisplay rcd, int w, int h) {
        synchronized(mCacheLock) {
            // do we have this display already?
            boolean displayKnown = false;
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext() && !displayKnown) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                displayKnown = di.mRcDisplay.asBinder().equals(rcd.asBinder());
                if (displayKnown) {
                    // this display was known but the change in artwork size will cause the
                    // artwork to be refreshed
                    if ((di.mArtworkExpectedWidth != w) || (di.mArtworkExpectedHeight != h)) {
                        di.mArtworkExpectedWidth = w;
                        di.mArtworkExpectedHeight = h;
                        if (!sendArtworkToDisplay(di)) {
                            displayIterator.remove();
                        }
                    }
                }
            }
            if (!displayKnown) {
                mRcDisplays.add(new DisplayInfoForClient(rcd, w, h));
            }
        }
    }

    /** pre-condition rcd != null */
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.293 -0500", hash_original_method = "C05B04228C08498C9A191ED0DAB2E4AC", hash_generated_method = "900433EA2DDC3ADAD8E0E024E339F8EA")
    
private void onUnplugDisplay(IRemoteControlDisplay rcd) {
        synchronized(mCacheLock) {
            Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                if (di.mRcDisplay.asBinder().equals(rcd.asBinder())) {
                    displayIterator.remove();
                    break;
                }
            }
            // list of RCDs has changed, reevaluate whether position check is still needed
            boolean oldNeedsPositionSync = mNeedsPositionSync;
            boolean newNeedsPositionSync = false;
            displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                if (di.mWantsPositionSync) {
                    newNeedsPositionSync = true;
                    break;
                }
            }
            mNeedsPositionSync = newNeedsPositionSync;
            if (oldNeedsPositionSync != mNeedsPositionSync) {
                // update needed?
                initiateCheckForDrift_syncCacheLock();
            }
        }
    }

    /** pre-condition rcd != null */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.295 -0500", hash_original_method = "074B664BDCFDE2FF1D8E9C15DF082349", hash_generated_method = "6BD58ABCEE3A6CF97DCD0C1B3E4D5F98")
    
private void onUpdateDisplayArtworkSize(IRemoteControlDisplay rcd, int w, int h) {
        synchronized(mCacheLock) {
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                if (di.mRcDisplay.asBinder().equals(rcd.asBinder()) &&
                        ((di.mArtworkExpectedWidth != w) || (di.mArtworkExpectedHeight != h))) {
                    di.mArtworkExpectedWidth = w;
                    di.mArtworkExpectedHeight = h;
                    if (!sendArtworkToDisplay(di)) {
                        displayIterator.remove();
                    }
                    break;
                }
            }
        }
    }

    /** pre-condition rcd != null */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.298 -0500", hash_original_method = "24F4C2A341115FC0F2EF5A11B5EB9CA3", hash_generated_method = "FA254BAE756F12490D77307496776902")
    
private void onDisplayWantsSync(IRemoteControlDisplay rcd, boolean wantsSync) {
        synchronized(mCacheLock) {
            boolean oldNeedsPositionSync = mNeedsPositionSync;
            boolean newNeedsPositionSync = false;
            final Iterator<DisplayInfoForClient> displayIterator = mRcDisplays.iterator();
            // go through the list of RCDs and for each entry, check both whether this is the RCD
            //  that gets upated, and whether the list has one entry that wants position sync
            while (displayIterator.hasNext()) {
                final DisplayInfoForClient di = (DisplayInfoForClient) displayIterator.next();
                if (di.mRcDisplay.asBinder().equals(rcd.asBinder())) {
                    di.mWantsPositionSync = wantsSync;
                }
                if (di.mWantsPositionSync) {
                    newNeedsPositionSync = true;
                }
            }
            mNeedsPositionSync = newNeedsPositionSync;
            if (oldNeedsPositionSync != mNeedsPositionSync) {
                // update needed?
                initiateCheckForDrift_syncCacheLock();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.299 -0500", hash_original_method = "0BF107668066039BA003E9F54704435C", hash_generated_method = "105EE4BE43E28C7EA5D0FDE67EBFC4AF")
    
private void onSeekTo(int generationId, long timeMs) {
        synchronized (mCacheLock) {
            if ((mCurrentClientGenId == generationId) && (mPositionUpdateListener != null)) {
                mPositionUpdateListener.onPlaybackPositionUpdate(timeMs);
            }
        }
    }

    //===========================================================
    // Internal utilities

    /**
     * Scale a bitmap to fit the smallest dimension by uniformly scaling the incoming bitmap.
     * If the bitmap fits, then do nothing and return the original.
     *
     * @param bitmap
     * @param maxWidth
     * @param maxHeight
     * @return
     */

    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 12:25:06.302 -0500", hash_original_method = "0841AB803D3236AC9E8D0C0490B02E68", hash_generated_method = "92C0D72A6FED873346AA3979854F17B2")
    
private Bitmap scaleBitmapIfTooBig(Bitmap bitmap, int maxWidth, int maxHeight) {
        if (bitmap != null) {
            final int width = bitmap.getWidth();
            final int height = bitmap.getHeight();
            if (width > maxWidth || height > maxHeight) {
                float scale = Math.min((float) maxWidth / width, (float) maxHeight / height);
                int newWidth = Math.round(scale * width);
                int newHeight = Math.round(scale * height);
                Bitmap.Config newConfig = bitmap.getConfig();
                if (newConfig == null) {
                    newConfig = Bitmap.Config.ARGB_8888;
                }
                Bitmap outBitmap = Bitmap.createBitmap(newWidth, newHeight, newConfig);
                Canvas canvas = new Canvas(outBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(bitmap, null,
                        new RectF(0, 0, outBitmap.getWidth(), outBitmap.getHeight()), paint);
                bitmap = outBitmap;
            }
        }
        return bitmap;
    }
}
