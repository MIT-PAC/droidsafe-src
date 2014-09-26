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
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;

class TransportMediatorJellybeanMR2
        implements RemoteControlClient.OnGetPlaybackPositionListener,
        RemoteControlClient.OnPlaybackPositionUpdateListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.672 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.677 -0400", hash_original_field = "81931559493F052ED78BA000FD1BC717", hash_generated_field = "81931559493F052ED78BA000FD1BC717")

     AudioManager mAudioManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.682 -0400", hash_original_field = "97ACD18EF4B48BDC424981A4C6E55C66", hash_generated_field = "97ACD18EF4B48BDC424981A4C6E55C66")

     View mTargetView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.687 -0400", hash_original_field = "B7A8E3A435EF031CE8363CD3D10C160D", hash_generated_field = "B7A8E3A435EF031CE8363CD3D10C160D")

     TransportMediatorCallback mTransportCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.692 -0400", hash_original_field = "942EDB9D82E724393F2D49C82904807F", hash_generated_field = "942EDB9D82E724393F2D49C82904807F")

     String mReceiverAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.696 -0400", hash_original_field = "24730B73E03514C37D2A80F57710CB47", hash_generated_field = "24730B73E03514C37D2A80F57710CB47")

     IntentFilter mReceiverFilter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.701 -0400", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "1811495D939DB843870F6315E04555CC")

     Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.717 -0400", hash_original_field = "CCE764083EE6B7F4D1EF4ACA40EA4CCA", hash_generated_field = "21AB3E738DE23BBAB067C93DBAA9EA26")

    final ViewTreeObserver.OnWindowAttachListener mWindowAttachListener =
            new ViewTreeObserver.OnWindowAttachListener() {
                @Override
                public void onWindowAttached() {
                    windowAttached();
                }
                @Override
                public void onWindowDetached() {
                    windowDetached();
                }
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.729 -0400", hash_original_field = "80451B031383646D056C99FB3D261138", hash_generated_field = "71AE3001E2EFB44108B4653EC4A037B6")

    final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusListener =
            new ViewTreeObserver.OnWindowFocusChangeListener() {
                @Override
                public void onWindowFocusChanged(boolean hasFocus) {
                    if (hasFocus) gainFocus();
                    else loseFocus();
                }
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.743 -0400", hash_original_field = "5E8F8231312845798C114DE2C93AAF90", hash_generated_field = "F6C4131C857E48651734E232F0BC3DBF")

    final BroadcastReceiver mMediaButtonReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                mTransportCallback.handleKey(event);
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.754 -0400", hash_original_field = "80B7F350987D15F810E9ED92D35E5650", hash_generated_field = "80B7F350987D15F810E9ED92D35E5650")

    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener
            = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            mTransportCallback.handleAudioFocusChange(focusChange);
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.758 -0400", hash_original_field = "7B47F6D668EAC8B29A4C2C64F0EA44AC", hash_generated_field = "7B47F6D668EAC8B29A4C2C64F0EA44AC")

    PendingIntent mPendingIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.763 -0400", hash_original_field = "70B2B6E08660750F625703F0205886F0", hash_generated_field = "70B2B6E08660750F625703F0205886F0")

    RemoteControlClient mRemoteControl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.766 -0400", hash_original_field = "933E7D9DFE518977F97F5D88C1F2C6C8", hash_generated_field = "933E7D9DFE518977F97F5D88C1F2C6C8")

    boolean mFocused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.773 -0400", hash_original_field = "865B28CDF4AC1618EBA96F76C7985BC7", hash_generated_field = "865B28CDF4AC1618EBA96F76C7985BC7")

    int mPlayState = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.777 -0400", hash_original_field = "71B4B15C72F6D29E01BBC749E52F63BA", hash_generated_field = "71B4B15C72F6D29E01BBC749E52F63BA")

    boolean mAudioFocused;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.785 -0400", hash_original_method = "7547096BB1E293E2DD4BD5620038C342", hash_generated_method = "CFF5E258805145F76C80C05F1A7D231D")
    
public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager,
            View view, TransportMediatorCallback transportCallback) {
        mContext = context;
        mAudioManager = audioManager;
        mTargetView = view;
        mTransportCallback = transportCallback;
        mReceiverAction = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        mIntent = new Intent(mReceiverAction);
        mIntent.setPackage(context.getPackageName());
        mReceiverFilter = new IntentFilter();
        mReceiverFilter.addAction(mReceiverAction);
        mTargetView.getViewTreeObserver().addOnWindowAttachListener(mWindowAttachListener);
        mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(mWindowFocusListener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.790 -0400", hash_original_method = "0BB2C1D5E39EACE5AE12CFF6FCF02813", hash_generated_method = "AFA4D1DDA6015BD5FD86417F763EE715")
    
public Object getRemoteControlClient() {
        return mRemoteControl;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.795 -0400", hash_original_method = "7F4B3BFCA1B0CA9B62E02B6F5CCA6E83", hash_generated_method = "BEDC4F3418B427D4C676C589272A880E")
    
public void destroy() {
        windowDetached();
        mTargetView.getViewTreeObserver().removeOnWindowAttachListener(mWindowAttachListener);
        //mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(mWindowFocusListener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.800 -0400", hash_original_method = "10768445EB951FE5442174B2BD534C5A", hash_generated_method = "10768445EB951FE5442174B2BD534C5A")
    
void windowAttached() {
        mContext.registerReceiver(mMediaButtonReceiver, mReceiverFilter);
        mPendingIntent = PendingIntent.getBroadcast(mContext, 0, mIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        mRemoteControl = new RemoteControlClient(mPendingIntent);
        mRemoteControl.setOnGetPlaybackPositionListener(this);
        mRemoteControl.setPlaybackPositionUpdateListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.804 -0400", hash_original_method = "3B4A51E8F28D6E804B5B56B055A08141", hash_generated_method = "3B4A51E8F28D6E804B5B56B055A08141")
    
void gainFocus() {
        if (!mFocused) {
            mFocused = true;
            mAudioManager.registerMediaButtonEventReceiver(mPendingIntent);
            mAudioManager.registerRemoteControlClient(mRemoteControl);
            if (mPlayState == RemoteControlClient.PLAYSTATE_PLAYING) {
                takeAudioFocus();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.809 -0400", hash_original_method = "3103108A8D5A088BBEC63FBBFE8B1FF4", hash_generated_method = "3103108A8D5A088BBEC63FBBFE8B1FF4")
    
void takeAudioFocus() {
        if (!mAudioFocused) {
            mAudioFocused = true;
            mAudioManager.requestAudioFocus(mAudioFocusChangeListener,
                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.813 -0400", hash_original_method = "3F5BE999A20E57B0E8BF6D722B3D4753", hash_generated_method = "2E3AF89ACFB1C18DB71B9D89E981E225")
    
public void startPlaying() {
        if (mPlayState != RemoteControlClient.PLAYSTATE_PLAYING) {
            mPlayState = RemoteControlClient.PLAYSTATE_PLAYING;
            mRemoteControl.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
        }
        if (mFocused) {
            takeAudioFocus();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.818 -0400", hash_original_method = "00EDEFAEE28425462568018CFE1936FB", hash_generated_method = "A9CED3C17449E0EE8A04A5872E5E1C44")
    
@Override
    public long onGetPlaybackPosition() {
        return mTransportCallback.getPlaybackPosition();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.823 -0400", hash_original_method = "A10C6CC7AA50AFF811AA6C334DF758B3", hash_generated_method = "F4B4C855653C7AECE6F30A176C132127")
    
@Override
    public void onPlaybackPositionUpdate(long newPositionMs) {
        mTransportCallback.playbackPositionUpdate(newPositionMs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.828 -0400", hash_original_method = "FBD67BA8A31809EAFA4A4846B6495AC8", hash_generated_method = "5D502D63DC62689F301DF7738FAC1186")
    
public void refreshState(boolean playing, long position, int transportControls) {
        if (mRemoteControl != null) {
            mRemoteControl.setPlaybackState(playing ? RemoteControlClient.PLAYSTATE_PLAYING
                    : RemoteControlClient.PLAYSTATE_STOPPED, position, playing ? 1 : 0);
            mRemoteControl.setTransportControlFlags(transportControls);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.833 -0400", hash_original_method = "5DA49539E8680FE60FAAD6F624FBFDB0", hash_generated_method = "7C6891C8F120C6270A278069115DB3F4")
    
public void pausePlaying() {
        if (mPlayState == RemoteControlClient.PLAYSTATE_PLAYING) {
            mPlayState = RemoteControlClient.PLAYSTATE_PAUSED;
            mRemoteControl.setPlaybackState(RemoteControlClient.PLAYSTATE_PAUSED);
        }
        dropAudioFocus();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.837 -0400", hash_original_method = "62E6A9788C24EA78B3AF9770D2D5214C", hash_generated_method = "6B28F14149016E43A63BDD8EE33770F8")
    
public void stopPlaying() {
        if (mPlayState != RemoteControlClient.PLAYSTATE_STOPPED) {
            mPlayState = RemoteControlClient.PLAYSTATE_STOPPED;
            mRemoteControl.setPlaybackState(RemoteControlClient.PLAYSTATE_STOPPED);
        }
        dropAudioFocus();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.842 -0400", hash_original_method = "A055FEE32C59123FF3DDAD9441282612", hash_generated_method = "A055FEE32C59123FF3DDAD9441282612")
    
void dropAudioFocus() {
        if (mAudioFocused) {
            mAudioFocused = false;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.846 -0400", hash_original_method = "C9E2EDEF98B099E11080C94F711AA2E8", hash_generated_method = "C9E2EDEF98B099E11080C94F711AA2E8")
    
void loseFocus() {
        dropAudioFocus();
        if (mFocused) {
            mFocused = false;
            mAudioManager.unregisterRemoteControlClient(mRemoteControl);
            mAudioManager.unregisterMediaButtonEventReceiver(mPendingIntent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-17 15:08:59.851 -0400", hash_original_method = "65BEE818776ACB3C08D6ED5800ABD703", hash_generated_method = "65BEE818776ACB3C08D6ED5800ABD703")
    
void windowDetached() {
        loseFocus();
        if (mPendingIntent != null) {
            mContext.unregisterReceiver(mMediaButtonReceiver);
            mPendingIntent.cancel();
            mPendingIntent = null;
            mRemoteControl = null;
        }
    }
}
