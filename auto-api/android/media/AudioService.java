package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import static android.media.AudioManager.RINGER_MODE_NORMAL;
import static android.media.AudioManager.RINGER_MODE_SILENT;
import static android.media.AudioManager.RINGER_MODE_VIBRATE;
import android.app.ActivityManagerNative;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.VolumePanel;
import com.android.internal.telephony.ITelephony;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

public class AudioService extends IAudioService.Stub {
    private static final String TAG = "AudioService";
    protected static final boolean DEBUG_RC = false;
    private static final int PERSIST_DELAY = 3000;
    private Context mContext;
    private ContentResolver mContentResolver;
    private boolean mVoiceCapable;
    private VolumePanel mVolumePanel;
    private static final int SHARED_MSG = -1;
    private static final int SENDMSG_REPLACE = 0;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int MSG_SET_SYSTEM_VOLUME = 0;
    private static final int MSG_PERSIST_VOLUME = 1;
    private static final int MSG_PERSIST_RINGER_MODE = 3;
    private static final int MSG_PERSIST_VIBRATE_SETTING = 4;
    private static final int MSG_MEDIA_SERVER_DIED = 5;
    private static final int MSG_MEDIA_SERVER_STARTED = 6;
    private static final int MSG_PLAY_SOUND_EFFECT = 7;
    private static final int MSG_BTA2DP_DOCK_TIMEOUT = 8;
    private static final int MSG_LOAD_SOUND_EFFECTS = 9;
    private static final int MSG_SET_FORCE_USE = 10;
    private static final int MSG_PERSIST_MEDIABUTTONRECEIVER = 11;
    private static final int MSG_BT_HEADSET_CNCT_FAILED = 12;
    private static final int MSG_RCDISPLAY_CLEAR = 13;
    private static final int MSG_RCDISPLAY_UPDATE = 14;
    private static final int BTA2DP_DOCK_TIMEOUT_MILLIS = 8000;
    private static final int BT_HEADSET_CNCT_TIMEOUT_MS = 3000;
    private AudioSystemThread mAudioSystemThread;
    private AudioHandler mAudioHandler;
    private VolumeStreamState[] mStreamStates;
    private SettingsObserver mSettingsObserver;
    private int mMode;
    private Object mSettingsLock = new Object();
    private boolean mMediaServerOk;
    private SoundPool mSoundPool;
    private Object mSoundEffectsLock = new Object();
    private static final int NUM_SOUNDPOOL_CHANNELS = 4;
    private static final int SOUND_EFFECT_VOLUME = 1000;
    private static final String SOUND_EFFECTS_PATH = "/media/audio/ui/";
    private static final String[] SOUND_EFFECT_FILES = new String[] {
        "Effect_Tick.ogg",
        "KeypressStandard.ogg",
        "KeypressSpacebar.ogg",
        "KeypressDelete.ogg",
        "KeypressReturn.ogg"
    };
    private int[][] SOUND_EFFECT_FILES_MAP = new int[][] {
        {0, -1},  
        {0, -1},  
        {0, -1},  
        {0, -1},  
        {0, -1},  
        {1, -1},  
        {2, -1},  
        {3, -1},  
        {4, -1}   
    };
    private int[] MAX_STREAM_VOLUME = new int[] {
        5,  
        7,  
        7,  
        15, 
        7,  
        7,  
        15, 
        7,  
        15, 
        15  
    };
    private int[] STREAM_VOLUME_ALIAS = new int[] {
        AudioSystem.STREAM_VOICE_CALL,  
        AudioSystem.STREAM_SYSTEM,  
        AudioSystem.STREAM_RING,  
        AudioSystem.STREAM_MUSIC, 
        AudioSystem.STREAM_ALARM,  
        AudioSystem.STREAM_RING,   
        AudioSystem.STREAM_BLUETOOTH_SCO, 
        AudioSystem.STREAM_SYSTEM,  
        AudioSystem.STREAM_VOICE_CALL, 
        AudioSystem.STREAM_MUSIC  
    };
    private AudioSystem.ErrorCallback mAudioSystemCallback = new AudioSystem.ErrorCallback() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.869 -0400", hash_original_method = "D8AACF60590CDC2D140F6CE405C9A0F9", hash_generated_method = "39D1CE3A6F83C2B84E323736FE8BCC7F")
        @DSModeled(DSC.SAFE)
        public void onError(int error) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(error);
            //Begin case AudioSystem.AUDIO_STATUS_SERVER_DIED 
            {
                sendMsg(mAudioHandler, MSG_MEDIA_SERVER_DIED, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                            null, 1500);
                mMediaServerOk = false;
            } //End block
            //End case AudioSystem.AUDIO_STATUS_SERVER_DIED 
            //Begin case AudioSystem.AUDIO_STATUS_OK 
            {
                sendMsg(mAudioHandler, MSG_MEDIA_SERVER_STARTED, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                            null, 0);
                mMediaServerOk = true;
            } //End block
            //End case AudioSystem.AUDIO_STATUS_OK 
            // ---------- Original Method ----------
            //switch (error) {
            //case AudioSystem.AUDIO_STATUS_SERVER_DIED:
                //if (mMediaServerOk) {
                    //sendMsg(mAudioHandler, MSG_MEDIA_SERVER_DIED, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                            //null, 1500);
                    //mMediaServerOk = false;
                //}
                //break;
            //case AudioSystem.AUDIO_STATUS_OK:
                //if (!mMediaServerOk) {
                    //sendMsg(mAudioHandler, MSG_MEDIA_SERVER_STARTED, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                            //null, 0);
                    //mMediaServerOk = true;
                //}
                //break;
            //default:
                //break;
            //}
        }

        
}; //Transformed anonymous class
    private int mRingerMode;
    private int mRingerModeAffectedStreams;
    private int mRingerModeMutedStreams;
    private int mMuteAffectedStreams;
    private int mVibrateSetting;
    private final BroadcastReceiver mReceiver = new AudioServiceBroadcastReceiver();
    private final BroadcastReceiver mMediaButtonReceiver = new MediaButtonBroadcastReceiver();
    private boolean mIsRinging = false;
    private HashMap <Integer, String> mConnectedDevices = new HashMap <Integer, String>();
    private int mForcedUseForComm;
    private ArrayList <SetModeDeathHandler> mSetModeDeathHandlers = new ArrayList <SetModeDeathHandler>();
    private ArrayList <ScoClient> mScoClients = new ArrayList <ScoClient>();
    private BluetoothHeadset mBluetoothHeadset;
    private BluetoothDevice mBluetoothHeadsetDevice;
    private int mScoAudioState;
    private static final int SCO_STATE_INACTIVE = 0;
    private static final int SCO_STATE_ACTIVATE_REQ = 1;
    private static final int SCO_STATE_ACTIVE_INTERNAL = 3;
    private static final int SCO_STATE_DEACTIVATE_REQ = 5;
    private static final int SCO_STATE_ACTIVE_EXTERNAL = 2;
    private static final int SCO_STATE_DEACTIVATE_EXT_REQ = 4;
    private int mScoConnectionState;
    private boolean mBootCompleted;
    private SoundPoolCallback mSoundPoolCallBack;
    private SoundPoolListenerThread mSoundPoolListenerThread;
    private Looper mSoundPoolLooper = null;
    private static final int SOUND_EFFECT_DEFAULT_VOLUME_DB = -20;
    private int SOUND_EFFECT_VOLUME_DB;
    private static final int NOTIFICATION_VOLUME_DELAY_MS = 5000;
    private int mPrevVolDirection = AudioManager.ADJUST_SAME;
    private KeyguardManager mKeyguardManager;
    private BluetoothProfile.ServiceListener mBluetoothProfileServiceListener = new BluetoothProfile.ServiceListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.870 -0400", hash_original_method = "E6C0EF65E04427B2B252E8B38C21C0E1", hash_generated_method = "982DFBD88370BB9FF8B6AA98A655D47F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(proxy.dsTaint);
            dsTaint.addTaint(profile);
            BluetoothDevice btDevice;
            List<BluetoothDevice> deviceList;
            //Begin case BluetoothProfile.A2DP 
            BluetoothA2dp a2dp;
            a2dp = (BluetoothA2dp) proxy;
            //End case BluetoothProfile.A2DP 
            //Begin case BluetoothProfile.A2DP 
            deviceList = a2dp.getConnectedDevices();
            //End case BluetoothProfile.A2DP 
            //Begin case BluetoothProfile.A2DP 
            {
                boolean var70DD5F79E9BAC4DD9B6CE26AF17A342C_145650380 = (deviceList.size() > 0);
                {
                    btDevice = deviceList.get(0);
                    handleA2dpConnectionStateChange(btDevice, a2dp.getConnectionState(btDevice));
                } //End block
            } //End collapsed parenthetic
            //End case BluetoothProfile.A2DP 
            //Begin case BluetoothProfile.HEADSET 
            {
                mAudioHandler.removeMessages(MSG_BT_HEADSET_CNCT_FAILED);
                mBluetoothHeadset = (BluetoothHeadset) proxy;
                deviceList = mBluetoothHeadset.getConnectedDevices();
                {
                    boolean varA0468FD6E8C37B5310A27E826086BE62_850217314 = (deviceList.size() > 0);
                    {
                        mBluetoothHeadsetDevice = deviceList.get(0);
                    } //End block
                    {
                        mBluetoothHeadsetDevice = null;
                    } //End block
                } //End collapsed parenthetic
                checkScoAudioState();
                {
                    boolean status;
                    status = false;
                    {
                        //Begin case SCO_STATE_ACTIVATE_REQ 
                        mScoAudioState = SCO_STATE_ACTIVE_INTERNAL;
                        //End case SCO_STATE_ACTIVATE_REQ 
                        //Begin case SCO_STATE_ACTIVATE_REQ 
                        status = mBluetoothHeadset.startScoUsingVirtualVoiceCall(
                                        mBluetoothHeadsetDevice);
                        //End case SCO_STATE_ACTIVATE_REQ 
                        //Begin case SCO_STATE_DEACTIVATE_REQ 
                        status = mBluetoothHeadset.stopScoUsingVirtualVoiceCall(
                                        mBluetoothHeadsetDevice);
                        //End case SCO_STATE_DEACTIVATE_REQ 
                        //Begin case SCO_STATE_DEACTIVATE_EXT_REQ 
                        status = mBluetoothHeadset.stopVoiceRecognition(
                                        mBluetoothHeadsetDevice);
                        //End case SCO_STATE_DEACTIVATE_EXT_REQ 
                    } //End block
                    {
                        sendMsg(mAudioHandler, MSG_BT_HEADSET_CNCT_FAILED, 0,
                                    SENDMSG_REPLACE, 0, 0, null, 0);
                    } //End block
                } //End block
            } //End block
            //End case BluetoothProfile.HEADSET 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.870 -0400", hash_original_method = "310A0767F544B2867BA151E1537BCBE0", hash_generated_method = "AEDEC0BAD9ED307A29AA2D10C0C82FFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceDisconnected(int profile) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(profile);
            //Begin case BluetoothProfile.A2DP 
            {
                {
                    boolean var1718CF551E1995D8564FC6A01649B7A0_836918185 = (mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP));
                    {
                        makeA2dpDeviceUnavailableNow(
                                mConnectedDevices.get(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case BluetoothProfile.A2DP 
            //Begin case BluetoothProfile.HEADSET 
            {
                mBluetoothHeadset = null;
            } //End block
            //End case BluetoothProfile.HEADSET 
            // ---------- Original Method ----------
            //switch(profile) {
            //case BluetoothProfile.A2DP:
                //synchronized (mConnectedDevices) {
                    //if (mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP)) {
                        //makeA2dpDeviceUnavailableNow(
                                //mConnectedDevices.get(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP));
                    //}
                //}
                //break;
            //case BluetoothProfile.HEADSET:
                //synchronized (mScoClients) {
                    //mBluetoothHeadset = null;
                //}
                //break;
            //default:
                //break;
            //}
        }

        
}; //Transformed anonymous class
    private String mDockAddress;
    private final static String IN_VOICE_COMM_FOCUS_ID = "AudioFocus_For_Phone_Ring_And_Calls";
    private final static Object mAudioFocusLock = new Object();
    private final static Object mRingingLock = new Object();
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.870 -0400", hash_original_method = "87888BFC78A7C715F3CFD5BCB10B21CE", hash_generated_method = "606475B69C08C24C17114E2026E00C86")
        @DSModeled(DSC.SAFE)
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(state);
            dsTaint.addTaint(incomingNumber);
            {
                {
                    mIsRinging = true;
                } //End block
            } //End block
            {
                {
                    mIsRinging = false;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (state == TelephonyManager.CALL_STATE_RINGING) {
                //synchronized(mRingingLock) {
                    //mIsRinging = true;
                //}
            //} else if ((state == TelephonyManager.CALL_STATE_OFFHOOK)
                    //|| (state == TelephonyManager.CALL_STATE_IDLE)) {
                //synchronized(mRingingLock) {
                    //mIsRinging = false;
                //}
            //}
        }

        
}; //Transformed anonymous class
    private Stack<FocusStackEntry> mFocusStack = new Stack<FocusStackEntry>();
    private final Object mCurrentRcLock = new Object();
    private IRemoteControlClient mCurrentRcClient = null;
    private final static int RC_INFO_NONE = 0;
    private final static int RC_INFO_ALL =
        RemoteControlClient.FLAG_INFORMATION_REQUEST_ALBUM_ART |
        RemoteControlClient.FLAG_INFORMATION_REQUEST_KEY_MEDIA |
        RemoteControlClient.FLAG_INFORMATION_REQUEST_METADATA |
        RemoteControlClient.FLAG_INFORMATION_REQUEST_PLAYSTATE;
    private int mCurrentRcClientGen = 0;
    private Stack<RemoteControlStackEntry> mRCStack = new Stack<RemoteControlStackEntry>();
    private IRemoteControlDisplay mRcDisplay;
    private RcDisplayDeathHandler mRcDisplayDeathHandler;
    private int mArtworkExpectedWidth = -1;
    private int mArtworkExpectedHeight = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.871 -0400", hash_original_method = "BD105D1998AD00FABF86BC497AB8A4A2", hash_generated_method = "11FC6D3D3058F2E9C74CEA780F5A2847")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioService(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mContentResolver = context.getContentResolver();
        mVoiceCapable = mContext.getResources().getBoolean(
                com.android.internal.R.bool.config_voice_capable);
        MAX_STREAM_VOLUME[AudioSystem.STREAM_VOICE_CALL] = SystemProperties.getInt(
            "ro.config.vc_call_vol_steps",
           MAX_STREAM_VOLUME[AudioSystem.STREAM_VOICE_CALL]);
        SOUND_EFFECT_VOLUME_DB = SystemProperties.getInt(
                "ro.config.sound_fx_volume",
                SOUND_EFFECT_DEFAULT_VOLUME_DB);
        mVolumePanel = new VolumePanel(context, this);
        mForcedUseForComm = AudioSystem.FORCE_NONE;
        createAudioSystemThread();
        readPersistedSettings();
        mSettingsObserver = new SettingsObserver();
        createStreamStates();
        mMode = AudioSystem.MODE_NORMAL;
        mMediaServerOk = true;
        mRingerModeMutedStreams = 0;
        setRingerModeInt(getRingerMode(), false);
        AudioSystem.setErrorCallback(mAudioSystemCallback);
        IntentFilter intentFilter;
        intentFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        intentFilter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED);
        intentFilter.addAction(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED);
        intentFilter.addAction(Intent.ACTION_DOCK_EVENT);
        intentFilter.addAction(Intent.ACTION_USB_ANLG_HEADSET_PLUG);
        intentFilter.addAction(Intent.ACTION_USB_DGTL_HEADSET_PLUG);
        intentFilter.addAction(Intent.ACTION_HDMI_AUDIO_PLUG);
        intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        context.registerReceiver(mReceiver, intentFilter);
        IntentFilter pkgFilter;
        pkgFilter = new IntentFilter();
        pkgFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        pkgFilter.addDataScheme("package");
        context.registerReceiver(mReceiver, pkgFilter);
        intentFilter = new IntentFilter(Intent.ACTION_MEDIA_BUTTON);
        intentFilter.setPriority(Integer.MAX_VALUE);
        context.registerReceiver(mMediaButtonReceiver, intentFilter);
        TelephonyManager tmgr;
        tmgr = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        tmgr.listen(mPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.871 -0400", hash_original_method = "2347CFBC63E6DA78297F9D6DE666B41A", hash_generated_method = "4FB3BCB8C392A21B80C11C531EB06000")
    @DSModeled(DSC.SAFE)
    private void createAudioSystemThread() {
        mAudioSystemThread = new AudioSystemThread();
        mAudioSystemThread.start();
        waitForAudioHandlerCreation();
        // ---------- Original Method ----------
        //mAudioSystemThread = new AudioSystemThread();
        //mAudioSystemThread.start();
        //waitForAudioHandlerCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.871 -0400", hash_original_method = "6C316BFF925354B19AE1650E2D9621E7", hash_generated_method = "BC3249B47F11E9F084015D5B43F74147")
    @DSModeled(DSC.SAFE)
    private void waitForAudioHandlerCreation() {
        {
            {
                try 
                {
                    wait(); 
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //while (mAudioHandler == null) {
                //try {
                    //wait();
                //} catch (InterruptedException e) {
                    //Log.e(TAG, "Interrupted while waiting on volume handler.");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.871 -0400", hash_original_method = "5E5A334C1AC4CEDD84EC0F0C4776C87C", hash_generated_method = "CD7F5AA4DD86C893C0B6270764F6FC83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createStreamStates() {
        int numStreamTypes;
        numStreamTypes = AudioSystem.getNumStreamTypes();
        VolumeStreamState[] streams;
        streams = mStreamStates = new VolumeStreamState[numStreamTypes];
        {
            int i;
            i = 0;
            {
                streams[i] = new VolumeStreamState(System.VOLUME_SETTINGS[STREAM_VOLUME_ALIAS[i]], i);
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            {
                {
                    int index;
                    index = rescaleIndex(streams[i].mIndex, STREAM_VOLUME_ALIAS[i], i);
                    streams[i].mIndex = streams[i].getValidIndex(index);
                    setStreamVolumeIndex(i, index);
                    index = rescaleIndex(streams[i].mLastAudibleIndex, STREAM_VOLUME_ALIAS[i], i);
                    streams[i].mLastAudibleIndex = streams[i].getValidIndex(index);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.872 -0400", hash_original_method = "E67E5E9843D5938DC2BCA4A6EBEAA79A", hash_generated_method = "339C4938849DD177D909B97BD630D63C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readPersistedSettings() {
        final ContentResolver cr;
        cr = mContentResolver;
        mRingerMode = System.getInt(cr, System.MODE_RINGER, AudioManager.RINGER_MODE_NORMAL);
        {
            boolean var132D6DC36007B3D4E014152399AEB25F_1121849742 = (!AudioManager.isValidRingerMode(mRingerMode));
            {
                mRingerMode = AudioManager.RINGER_MODE_NORMAL;
                System.putInt(cr, System.MODE_RINGER, mRingerMode);
            } //End block
        } //End collapsed parenthetic
        mVibrateSetting = System.getInt(cr, System.VIBRATE_ON, 0);
        mRingerModeAffectedStreams = Settings.System.getInt(cr,
                Settings.System.MODE_RINGER_STREAMS_AFFECTED,
                ((1 << AudioSystem.STREAM_RING)|(1 << AudioSystem.STREAM_NOTIFICATION)|
                 (1 << AudioSystem.STREAM_SYSTEM)|(1 << AudioSystem.STREAM_SYSTEM_ENFORCED)));
        {
            mRingerModeAffectedStreams &= ~(1 << AudioSystem.STREAM_MUSIC);
        } //End block
        {
            mRingerModeAffectedStreams |= (1 << AudioSystem.STREAM_MUSIC);
        } //End block
        Settings.System.putInt(cr,
                Settings.System.MODE_RINGER_STREAMS_AFFECTED, mRingerModeAffectedStreams);
        mMuteAffectedStreams = System.getInt(cr,
                System.MUTE_STREAMS_AFFECTED,
                ((1 << AudioSystem.STREAM_MUSIC)|(1 << AudioSystem.STREAM_RING)|(1 << AudioSystem.STREAM_SYSTEM)));
        broadcastRingerMode();
        broadcastVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER);
        broadcastVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION);
        restoreMediaButtonReceiver();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.872 -0400", hash_original_method = "7012C1A674471AA73D1B9DCE1304C183", hash_generated_method = "235BA3B8EE80E34F89C7E3F9FE709FED")
    @DSModeled(DSC.SAFE)
    private void setStreamVolumeIndex(int stream, int index) {
        dsTaint.addTaint(stream);
        dsTaint.addTaint(index);
        AudioSystem.setStreamVolumeIndex(stream, (index + 5)/10);
        // ---------- Original Method ----------
        //AudioSystem.setStreamVolumeIndex(stream, (index + 5)/10);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.872 -0400", hash_original_method = "9045448D0182963E77D64CFD2A65EA0A", hash_generated_method = "4D95DEF2B15274659EBDE49A370AA376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int rescaleIndex(int index, int srcStream, int dstStream) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(dstStream);
        dsTaint.addTaint(srcStream);
        int var946A6795FBBB7FF44DC60BEE7ADDDE70_293200653 = ((index * mStreamStates[dstStream].getMaxIndex() + mStreamStates[srcStream].getMaxIndex() / 2) / mStreamStates[srcStream].getMaxIndex());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (index * mStreamStates[dstStream].getMaxIndex() + mStreamStates[srcStream].getMaxIndex() / 2) / mStreamStates[srcStream].getMaxIndex();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.872 -0400", hash_original_method = "59AF09AB331F4141B5BEA5E0292FDA5C", hash_generated_method = "9BB955C657ADBCF276C605C0A00534F6")
    @DSModeled(DSC.SAFE)
    public void adjustVolume(int direction, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(direction);
        adjustSuggestedStreamVolume(direction, AudioManager.USE_DEFAULT_STREAM_TYPE, flags);
        // ---------- Original Method ----------
        //adjustSuggestedStreamVolume(direction, AudioManager.USE_DEFAULT_STREAM_TYPE, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.872 -0400", hash_original_method = "10E722A8AA7E97AD5EFF367DBF2B8BA8", hash_generated_method = "8CB378BD822A73109F70DF77758B135E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(suggestedStreamType);
        int streamType;
        {
            streamType = suggestedStreamType;
        } //End block
        {
            streamType = getActiveStreamType(suggestedStreamType);
        } //End block
        {
            boolean var2C7C3BBF2042D53172AAE731E570ABB7_1039110431 = ((flags & AudioManager.FLAG_PLAY_SOUND) != 0 &&
                ((STREAM_VOLUME_ALIAS[streamType] != AudioSystem.STREAM_RING)
                 || (mKeyguardManager != null && mKeyguardManager.isKeyguardLocked())));
            {
                flags &= ~AudioManager.FLAG_PLAY_SOUND;
            } //End block
        } //End collapsed parenthetic
        adjustStreamVolume(streamType, direction, flags);
        // ---------- Original Method ----------
        //int streamType;
        //if ((flags & AudioManager.FLAG_FORCE_STREAM) != 0) {
            //streamType = suggestedStreamType;
        //} else {
            //streamType = getActiveStreamType(suggestedStreamType);
        //}
        //if ((flags & AudioManager.FLAG_PLAY_SOUND) != 0 &&
                //((STREAM_VOLUME_ALIAS[streamType] != AudioSystem.STREAM_RING)
                 //|| (mKeyguardManager != null && mKeyguardManager.isKeyguardLocked()))) {
            //flags &= ~AudioManager.FLAG_PLAY_SOUND;
        //}
        //adjustStreamVolume(streamType, direction, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.873 -0400", hash_original_method = "0572467E98D236AE0588C396AEA849F2", hash_generated_method = "2BA321D49C68E3A95AD59ACBC4FB6032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustStreamVolume(int streamType, int direction, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(streamType);
        ensureValidDirection(direction);
        ensureValidStreamType(streamType);
        int streamTypeAlias;
        streamTypeAlias = STREAM_VOLUME_ALIAS[streamType];
        VolumeStreamState streamState;
        streamState = mStreamStates[streamTypeAlias];
        int oldIndex;
        boolean var4340C4FA9354C586C76453C24B5F0773_1595507238 = ((streamState.muteCount() != 0));
        oldIndex = streamState.mLastAudibleIndex;
        oldIndex = streamState.mIndex;
        boolean adjustVolume;
        adjustVolume = true;
        {
            {
                flags &= ~AudioManager.FLAG_VIBRATE;
            } //End block
            adjustVolume = checkForRingerModeChange(oldIndex, direction, streamTypeAlias);
        } //End block
        int index;
        {
            boolean var4E6551E8AECB08A5A7F51F9D655174DF_2011254038 = (streamState.muteCount() != 0);
            {
                {
                    int numStreamTypes;
                    numStreamTypes = AudioSystem.getNumStreamTypes();
                    {
                        int i;
                        i = numStreamTypes - 1;
                        {
                            {
                                VolumeStreamState s;
                                s = mStreamStates[i];
                                s.adjustLastAudibleIndex(direction);
                                sendMsg(mAudioHandler, MSG_PERSIST_VOLUME, i,
                                SENDMSG_REPLACE, 0, 1, s, PERSIST_DELAY);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                index = streamState.mLastAudibleIndex;
            } //End block
            {
                {
                    boolean var9E88563EEA29390005C3C15223C4CBA0_645779352 = (adjustVolume && streamState.adjustIndex(direction));
                    {
                        sendMsg(mAudioHandler, MSG_SET_SYSTEM_VOLUME, streamTypeAlias, SENDMSG_NOOP, 0, 0,
                        streamState, 0);
                    } //End block
                } //End collapsed parenthetic
                index = streamState.mIndex;
            } //End block
        } //End collapsed parenthetic
        sendVolumeUpdate(streamType, oldIndex, index, flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.873 -0400", hash_original_method = "530356777F30DF88D8F9BE3EF262D69F", hash_generated_method = "4A275CAC8ACEE5FECE40B363354A7BB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamVolume(int streamType, int index, int flags) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        ensureValidStreamType(streamType);
        VolumeStreamState streamState;
        streamState = mStreamStates[STREAM_VOLUME_ALIAS[streamType]];
        int oldIndex;
        boolean var4340C4FA9354C586C76453C24B5F0773_1841933975 = ((streamState.muteCount() != 0));
        oldIndex = streamState.mLastAudibleIndex;
        oldIndex = streamState.mIndex;
        {
            int newRingerMode;
            newRingerMode = mRingerMode;
            {
                newRingerMode = System.getInt(mContentResolver, System.VIBRATE_IN_SILENT, 1) == 1
                    ? AudioManager.RINGER_MODE_VIBRATE
                    : AudioManager.RINGER_MODE_SILENT;
                setStreamVolumeInt(STREAM_VOLUME_ALIAS[streamType], index, false, true);
            } //End block
            {
                newRingerMode = AudioManager.RINGER_MODE_NORMAL;
            } //End block
            {
                setRingerMode(newRingerMode);
            } //End block
        } //End block
        index = rescaleIndex(index * 10, streamType, STREAM_VOLUME_ALIAS[streamType]);
        setStreamVolumeInt(STREAM_VOLUME_ALIAS[streamType], index, false, true);
        index = (streamState.muteCount() != 0) ? streamState.mLastAudibleIndex : streamState.mIndex;
        sendVolumeUpdate(streamType, oldIndex, index, flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.874 -0400", hash_original_method = "61F5AE03200D277A532F56DA200CD329", hash_generated_method = "CB6917930E22BE67BA8C66660CAF8DAC")
    @DSModeled(DSC.SAFE)
    private void sendVolumeUpdate(int streamType, int oldIndex, int index, int flags) {
        dsTaint.addTaint(oldIndex);
        dsTaint.addTaint(index);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        {
            streamType = AudioSystem.STREAM_NOTIFICATION;
        } //End block
        mVolumePanel.postVolumeChanged(streamType, flags);
        oldIndex = (oldIndex + 5) / 10;
        index = (index + 5) / 10;
        Intent intent;
        intent = new Intent(AudioManager.VOLUME_CHANGED_ACTION);
        intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, streamType);
        intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, index);
        intent.putExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, oldIndex);
        mContext.sendBroadcast(intent);
        // ---------- Original Method ----------
        //if (!mVoiceCapable && (streamType == AudioSystem.STREAM_RING)) {
            //streamType = AudioSystem.STREAM_NOTIFICATION;
        //}
        //mVolumePanel.postVolumeChanged(streamType, flags);
        //oldIndex = (oldIndex + 5) / 10;
        //index = (index + 5) / 10;
        //Intent intent = new Intent(AudioManager.VOLUME_CHANGED_ACTION);
        //intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, streamType);
        //intent.putExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, index);
        //intent.putExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, oldIndex);
        //mContext.sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.874 -0400", hash_original_method = "4B77530EC72F55454D0FBB027E5B0C0A", hash_generated_method = "17CB98C3D01F76AB15E78EE1A25516DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setStreamVolumeInt(int streamType, int index, boolean force, boolean lastAudible) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(force);
        dsTaint.addTaint(lastAudible);
        VolumeStreamState streamState;
        streamState = mStreamStates[streamType];
        {
            boolean var4E6551E8AECB08A5A7F51F9D655174DF_650777074 = (streamState.muteCount() != 0);
            {
                {
                    streamState.setLastAudibleIndex(index);
                    sendMsg(mAudioHandler, MSG_PERSIST_VOLUME, streamType,
                        SENDMSG_REPLACE, 0, 1, streamState, PERSIST_DELAY);
                } //End block
            } //End block
            {
                {
                    boolean var9F6F676AA601F90BF037412C50A8C4CD_1688604553 = (streamState.setIndex(index, lastAudible) || force);
                    {
                        sendMsg(mAudioHandler, MSG_SET_SYSTEM_VOLUME, streamType, SENDMSG_NOOP, 0, 0,
                        streamState, 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //VolumeStreamState streamState = mStreamStates[streamType];
        //if (streamState.muteCount() != 0) {
            //if (index != 0) {
                //streamState.setLastAudibleIndex(index);
                //sendMsg(mAudioHandler, MSG_PERSIST_VOLUME, streamType,
                        //SENDMSG_REPLACE, 0, 1, streamState, PERSIST_DELAY);
            //}
        //} else {
            //if (streamState.setIndex(index, lastAudible) || force) {
                //sendMsg(mAudioHandler, MSG_SET_SYSTEM_VOLUME, streamType, SENDMSG_NOOP, 0, 0,
                        //streamState, 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.874 -0400", hash_original_method = "7A644CF23D303238C8EEC18B835D2161", hash_generated_method = "722AC5618EB5176B8C810C8995E989B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamSolo(int streamType, boolean state, IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(state);
        {
            int stream;
            stream = 0;
            {
                {
                    boolean varF4FCBA3DD198C5F28FD10C8FDEC01B13_1880091311 = (!isStreamAffectedByMute(stream) || stream == streamType);
                } //End collapsed parenthetic
                mStreamStates[stream].mute(cb, state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int stream = 0; stream < mStreamStates.length; stream++) {
            //if (!isStreamAffectedByMute(stream) || stream == streamType) continue;
            //mStreamStates[stream].mute(cb, state);
         //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.874 -0400", hash_original_method = "A55BE3F41DE4D6B0AE8F05D153DC3192", hash_generated_method = "F2D8CCD06742C3E901465EE840D68B5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamMute(int streamType, boolean state, IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(state);
        {
            boolean varFDE49EF1457EDEA2C8E8956AEB26F39D_944156530 = (isStreamAffectedByMute(streamType));
            {
                mStreamStates[streamType].mute(cb, state);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isStreamAffectedByMute(streamType)) {
            //mStreamStates[streamType].mute(cb, state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "419347680D7DE0F7F0F0915907536534", hash_generated_method = "3A2C45D45E0FF30985E2D9768404E99A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStreamMute(int streamType) {
        dsTaint.addTaint(streamType);
        boolean var6C3AA33E198533FC87BB4844156B9D4E_1466127799 = ((mStreamStates[streamType].muteCount() != 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mStreamStates[streamType].muteCount() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "29558DD197D70C5BCC51302B629C215F", hash_generated_method = "20D84BE74D661E2A143CBB49A99A16D9")
    @DSModeled(DSC.SAFE)
    public int getStreamVolume(int streamType) {
        dsTaint.addTaint(streamType);
        ensureValidStreamType(streamType);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureValidStreamType(streamType);
        //return (mStreamStates[streamType].mIndex + 5) / 10;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "D75543A77024F868A960AF8C745ADAF6", hash_generated_method = "DD5CEC6BD73126ED1BEB68D90F118D4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStreamMaxVolume(int streamType) {
        dsTaint.addTaint(streamType);
        ensureValidStreamType(streamType);
        int var0CD666956568159AD5F2874FD8340168_1348240112 = ((mStreamStates[streamType].getMaxIndex() + 5) / 10);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureValidStreamType(streamType);
        //return (mStreamStates[streamType].getMaxIndex() + 5) / 10;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "32BB624F4178422279DEE8D77512CCF1", hash_generated_method = "038ADD663F2CA84EAF8FC0AC090F93D9")
    @DSModeled(DSC.SAFE)
    public int getLastAudibleStreamVolume(int streamType) {
        dsTaint.addTaint(streamType);
        ensureValidStreamType(streamType);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ensureValidStreamType(streamType);
        //return (mStreamStates[streamType].mLastAudibleIndex + 5) / 10;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "94B32A230A8BA9254F6B1BE347C8B980", hash_generated_method = "DAB7C405672C88C367E4EAACAD3909D2")
    @DSModeled(DSC.SAFE)
    public int getRingerMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRingerMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.875 -0400", hash_original_method = "97BE8F3AFB9FDDF39300D73EB7DE5DE5", hash_generated_method = "EF933AE7C582098C21B9A73504C54348")
    @DSModeled(DSC.SAFE)
    public void setRingerMode(int ringerMode) {
        dsTaint.addTaint(ringerMode);
        {
            {
                setRingerModeInt(ringerMode, true);
                broadcastRingerMode();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSettingsLock) {
            //if (ringerMode != mRingerMode) {
                //setRingerModeInt(ringerMode, true);
                //broadcastRingerMode();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.876 -0400", hash_original_method = "9A764BA6B9B4D2EF4E939EC04444F53C", hash_generated_method = "9D07E25CCCFE3B3536AB9DF7855C9949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setRingerModeInt(int ringerMode, boolean persist) {
        dsTaint.addTaint(ringerMode);
        dsTaint.addTaint(persist);
        int numStreamTypes;
        numStreamTypes = AudioSystem.getNumStreamTypes();
        {
            int streamType;
            streamType = numStreamTypes - 1;
            {
                {
                    boolean var67BFE05E857C98CA0D40A351242A329A_1970866422 = (isStreamMutedByRingerMode(streamType));
                    {
                        {
                            boolean varE1963897F6E6EA711383139AE64B0520_1501427083 = (!isStreamAffectedByRingerMode(streamType) ||
                    mRingerMode == AudioManager.RINGER_MODE_NORMAL);
                            {
                                {
                                    mStreamStates[streamType].mLastAudibleIndex = 10;
                                } //End block
                                mStreamStates[streamType].mute(null, false);
                                mRingerModeMutedStreams &= ~(1 << streamType);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varD370A25F9074BCBB11B3AB929DEE36FE_784323226 = (isStreamAffectedByRingerMode(streamType) &&
                    mRingerMode != AudioManager.RINGER_MODE_NORMAL);
                            {
                                mStreamStates[streamType].mute(null, true);
                                mRingerModeMutedStreams |= (1 << streamType);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            sendMsg(mAudioHandler, MSG_PERSIST_RINGER_MODE, SHARED_MSG,
                    SENDMSG_REPLACE, 0, 0, null, PERSIST_DELAY);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.876 -0400", hash_original_method = "755E747555DB1E49819DD7F227819F97", hash_generated_method = "78BEC578CF541D6C7BA71942FEB447AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldVibrate(int vibrateType) {
        dsTaint.addTaint(vibrateType);
        {
            Object varB0CABCCE14EFC824E04C56CC31361F9C_1139833482 = (getVibrateSetting(vibrateType));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (getVibrateSetting(vibrateType)) {
            //case AudioManager.VIBRATE_SETTING_ON:
                //return mRingerMode != AudioManager.RINGER_MODE_SILENT;
            //case AudioManager.VIBRATE_SETTING_ONLY_SILENT:
                //return mRingerMode == AudioManager.RINGER_MODE_VIBRATE;
            //case AudioManager.VIBRATE_SETTING_OFF:
                //return false;
            //default:
                //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.877 -0400", hash_original_method = "CA2FCAD3A921E37E6F8BB176EA8C62F2", hash_generated_method = "45559E506A0FCCBA584D39FB5DAACDC0")
    @DSModeled(DSC.SAFE)
    public int getVibrateSetting(int vibrateType) {
        dsTaint.addTaint(vibrateType);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (mVibrateSetting >> (vibrateType * 2)) & 3;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.877 -0400", hash_original_method = "6C7E8F6E98AAB33ECE1B33E22DBCF262", hash_generated_method = "D59E599BF1BBF94800C09D0AE326E5CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        dsTaint.addTaint(vibrateType);
        dsTaint.addTaint(vibrateSetting);
        mVibrateSetting = getValueForVibrateSetting(mVibrateSetting, vibrateType, vibrateSetting);
        broadcastVibrateSetting(vibrateType);
        sendMsg(mAudioHandler, MSG_PERSIST_VIBRATE_SETTING, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                null, 0);
        // ---------- Original Method ----------
        //mVibrateSetting = getValueForVibrateSetting(mVibrateSetting, vibrateType, vibrateSetting);
        //broadcastVibrateSetting(vibrateType);
        //sendMsg(mAudioHandler, MSG_PERSIST_VIBRATE_SETTING, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                //null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.877 -0400", hash_original_method = "EEDC2EC97F489A1CBEAED49FFA01E32E", hash_generated_method = "ED4B3F0432B3BB8ECFDE1B83EAED70DA")
    public static int getValueForVibrateSetting(int existingValue, int vibrateType,
            int vibrateSetting) {
        existingValue &= ~(3 << (vibrateType * 2));
        existingValue |= (vibrateSetting & 3) << (vibrateType * 2);
        return existingValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.877 -0400", hash_original_method = "4C3A5D06EDF21461238A456680F4295A", hash_generated_method = "CCC0D71FF37E854035EAA5E1EA3CF37D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(int mode, IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(mode);
        {
            boolean varD3890590CF537F9AF4B9FA2038F4B771_822909865 = (!checkAudioSettingsPermission("setMode()"));
        } //End collapsed parenthetic
        int newModeOwnerPid;
        newModeOwnerPid = 0;
        {
            {
                mode = mMode;
            } //End block
            newModeOwnerPid = setModeInt(mode, cb, Binder.getCallingPid());
        } //End block
        {
            disconnectBluetoothSco(newModeOwnerPid);
        } //End block
        // ---------- Original Method ----------
        //if (!checkAudioSettingsPermission("setMode()")) {
            //return;
        //}
        //if (mode < AudioSystem.MODE_CURRENT || mode >= AudioSystem.NUM_MODES) {
            //return;
        //}
        //int newModeOwnerPid = 0;
        //synchronized(mSetModeDeathHandlers) {
            //if (mode == AudioSystem.MODE_CURRENT) {
                //mode = mMode;
            //}
            //newModeOwnerPid = setModeInt(mode, cb, Binder.getCallingPid());
        //}
        //if (newModeOwnerPid != 0) {
             //disconnectBluetoothSco(newModeOwnerPid);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.878 -0400", hash_original_method = "214D3A3E78B7320AE675DF2350F01FFD", hash_generated_method = "52288218363744D4F35301778E96B29A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int setModeInt(int mode, IBinder cb, int pid) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(mode);
        int newModeOwnerPid;
        newModeOwnerPid = 0;
        SetModeDeathHandler hdlr;
        hdlr = null;
        Iterator iter;
        iter = mSetModeDeathHandlers.iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1604063157 = (iter.hasNext());
            {
                SetModeDeathHandler h;
                h = (SetModeDeathHandler)iter.next();
                {
                    boolean var9412962A3CBC4A37CE6D72F8948ADD4B_1524407649 = (h.getPid() == pid);
                    {
                        hdlr = h;
                        iter.remove();
                        hdlr.getBinder().unlinkToDeath(hdlr, 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int status;
        status = AudioSystem.AUDIO_STATUS_OK;
        {
            {
                {
                    boolean var470B0DB4EEEBF820AA02092413724910_507569209 = (!mSetModeDeathHandlers.isEmpty());
                    {
                        hdlr = mSetModeDeathHandlers.get(0);
                        cb = hdlr.getBinder();
                        mode = hdlr.getMode();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    hdlr = new SetModeDeathHandler(cb, pid);
                } //End block
                try 
                {
                    cb.linkToDeath(hdlr, 0);
                } //End block
                catch (RemoteException e)
                { }
                mSetModeDeathHandlers.add(0, hdlr);
                hdlr.setMode(mode);
            } //End block
            {
                status = AudioSystem.setPhoneState(mode);
                {
                    handleFocusForCalls(mMode, mode, cb);
                } //End block
                {
                    {
                        mSetModeDeathHandlers.remove(hdlr);
                        cb.unlinkToDeath(hdlr, 0);
                    } //End block
                    mode = AudioSystem.MODE_NORMAL;
                } //End block
            } //End block
            {
                status = AudioSystem.AUDIO_STATUS_OK;
            } //End block
        } //End block
        {
            boolean var93040102AF182B7978E920313901AEFB_687059185 = (status != AudioSystem.AUDIO_STATUS_OK && !mSetModeDeathHandlers.isEmpty());
        } //End collapsed parenthetic
        {
            {
                {
                    boolean varFCF7207B32D2FD57561D852B27367FD5_1656778812 = (mSetModeDeathHandlers.isEmpty());
                    {
                        newModeOwnerPid = mSetModeDeathHandlers.get(0).getPid();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int streamType;
            streamType = getActiveStreamType(AudioManager.USE_DEFAULT_STREAM_TYPE);
            int index;
            index = mStreamStates[STREAM_VOLUME_ALIAS[streamType]].mIndex;
            setStreamVolumeInt(STREAM_VOLUME_ALIAS[streamType], index, true, false);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.879 -0400", hash_original_method = "4F3AA070B34B90E3AC52A8BE2865B8F8", hash_generated_method = "4BF73E39D89FDFB5F4D9B836B9A2E38D")
    @DSModeled(DSC.SAFE)
    private void handleFocusForCalls(int oldMode, int newMode, IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(oldMode);
        dsTaint.addTaint(newMode);
        {
            int ringVolume;
            ringVolume = AudioService.this.getStreamVolume(AudioManager.STREAM_RING);
            {
                requestAudioFocus(AudioManager.STREAM_RING,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT, cb,
                        null ,
                        IN_VOICE_COMM_FOCUS_ID ,
                        "system");
            } //End block
        } //End block
        {
            requestAudioFocus(AudioManager.STREAM_RING,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT, cb,
                    null ,
                    IN_VOICE_COMM_FOCUS_ID ,
                    "system");
        } //End block
        {
            abandonAudioFocus(null, IN_VOICE_COMM_FOCUS_ID);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.879 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "CD5645CD4FC965CE17B38E67F6DA3C8D")
    @DSModeled(DSC.SAFE)
    public int getMode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.879 -0400", hash_original_method = "D25C9BBDFC30FC7A7A572BDD5251DA8D", hash_generated_method = "0CBF10C5BCBDB64157AA87B0C32D5AFD")
    @DSModeled(DSC.SAFE)
    public void playSoundEffect(int effectType) {
        dsTaint.addTaint(effectType);
        sendMsg(mAudioHandler, MSG_PLAY_SOUND_EFFECT, SHARED_MSG, SENDMSG_NOOP,
                effectType, -1, null, 0);
        // ---------- Original Method ----------
        //sendMsg(mAudioHandler, MSG_PLAY_SOUND_EFFECT, SHARED_MSG, SENDMSG_NOOP,
                //effectType, -1, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.879 -0400", hash_original_method = "EB85537E610CFE638D5179CE0C3E1502", hash_generated_method = "FC89A2133BCC9ED49B15B32E5D11B734")
    @DSModeled(DSC.SAFE)
    public void playSoundEffectVolume(int effectType, float volume) {
        dsTaint.addTaint(volume);
        dsTaint.addTaint(effectType);
        loadSoundEffects();
        sendMsg(mAudioHandler, MSG_PLAY_SOUND_EFFECT, SHARED_MSG, SENDMSG_NOOP,
                effectType, (int) (volume * 1000), null, 0);
        // ---------- Original Method ----------
        //loadSoundEffects();
        //sendMsg(mAudioHandler, MSG_PLAY_SOUND_EFFECT, SHARED_MSG, SENDMSG_NOOP,
                //effectType, (int) (volume * 1000), null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.880 -0400", hash_original_method = "56BAEC35F60B2BCD6595152C8703BDE9", hash_generated_method = "2D0FCA243773B045DC7F50D6D6B09046")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean loadSoundEffects() {
        int status;
        {
            mSoundPool = new SoundPool(NUM_SOUNDPOOL_CHANNELS, AudioSystem.STREAM_SYSTEM, 0);
            try 
            {
                mSoundPoolCallBack = null;
                mSoundPoolListenerThread = new SoundPoolListenerThread();
                mSoundPoolListenerThread.start();
                mSoundEffectsLock.wait();
            } //End block
            catch (InterruptedException e)
            { }
            {
                {
                    mSoundPoolLooper.quit();
                    mSoundPoolLooper = null;
                } //End block
                mSoundPoolListenerThread = null;
                mSoundPool.release();
                mSoundPool = null;
            } //End block
            int[] poolId;
            poolId = new int[SOUND_EFFECT_FILES.length];
            {
                int fileIdx;
                fileIdx = 0;
                {
                    poolId[fileIdx] = -1;
                } //End block
            } //End collapsed parenthetic
            int lastSample;
            lastSample = 0;
            {
                int effect;
                effect = 0;
                {
                    {
                        String filePath;
                        filePath = Environment.getRootDirectory()
                            + SOUND_EFFECTS_PATH
                            + SOUND_EFFECT_FILES[SOUND_EFFECT_FILES_MAP[effect][0]];
                        int sampleId;
                        sampleId = mSoundPool.load(filePath, 0);
                        {
                            SOUND_EFFECT_FILES_MAP[effect][1] = sampleId;
                            poolId[SOUND_EFFECT_FILES_MAP[effect][0]] = sampleId;
                            lastSample = sampleId;
                        } //End block
                    } //End block
                    {
                        SOUND_EFFECT_FILES_MAP[effect][1] = poolId[SOUND_EFFECT_FILES_MAP[effect][0]];
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                mSoundPoolCallBack.setLastSample(lastSample);
                try 
                {
                    mSoundEffectsLock.wait();
                    status = mSoundPoolCallBack.status();
                } //End block
                catch (java.lang.InterruptedException e)
                {
                    status = -1;
                } //End block
            } //End block
            {
                status = -1;
            } //End block
            {
                mSoundPoolLooper.quit();
                mSoundPoolLooper = null;
            } //End block
            mSoundPoolListenerThread = null;
            {
                {
                    int effect;
                    effect = 0;
                    {
                        {
                            SOUND_EFFECT_FILES_MAP[effect][1] = -1;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mSoundPool.release();
                mSoundPool = null;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.881 -0400", hash_original_method = "A760314FEE234AF974221C91558E9A03", hash_generated_method = "FA842A19719A2C2A666750EF1C0D9825")
    @DSModeled(DSC.SAFE)
    public void unloadSoundEffects() {
        {
            mAudioHandler.removeMessages(MSG_LOAD_SOUND_EFFECTS);
            mAudioHandler.removeMessages(MSG_PLAY_SOUND_EFFECT);
            int[] poolId;
            poolId = new int[SOUND_EFFECT_FILES.length];
            {
                int fileIdx;
                fileIdx = 0;
                {
                    poolId[fileIdx] = 0;
                } //End block
            } //End collapsed parenthetic
            {
                int effect;
                effect = 0;
                {
                    {
                        mSoundPool.unload(SOUND_EFFECT_FILES_MAP[effect][1]);
                        SOUND_EFFECT_FILES_MAP[effect][1] = -1;
                        poolId[SOUND_EFFECT_FILES_MAP[effect][0]] = -1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mSoundPool.release();
            mSoundPool = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.882 -0400", hash_original_method = "A39E76F576FDC92A2B9E7877E0C2480B", hash_generated_method = "CE3291DEF00DE102051D30747FDE4BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reloadAudioSettings() {
        readPersistedSettings();
        int numStreamTypes;
        numStreamTypes = AudioSystem.getNumStreamTypes();
        {
            int streamType;
            streamType = 0;
            {
                VolumeStreamState streamState;
                streamState = mStreamStates[streamType];
                String settingName;
                settingName = System.VOLUME_SETTINGS[STREAM_VOLUME_ALIAS[streamType]];
                String lastAudibleSettingName;
                lastAudibleSettingName = settingName + System.APPEND_FOR_LAST_AUDIBLE;
                int index;
                index = Settings.System.getInt(mContentResolver,
                                           settingName,
                                           AudioManager.DEFAULT_STREAM_VOLUME[streamType]);
                {
                    index = rescaleIndex(index * 10, STREAM_VOLUME_ALIAS[streamType], streamType);
                } //End block
                {
                    index *= 10;
                } //End block
                streamState.mIndex = streamState.getValidIndex(index);
                index = (index + 5) / 10;
                index = Settings.System.getInt(mContentResolver,
                                            lastAudibleSettingName,
                                            (index > 0) ? index : AudioManager.DEFAULT_STREAM_VOLUME[streamType]);
                {
                    index = rescaleIndex(index * 10, STREAM_VOLUME_ALIAS[streamType], streamType);
                } //End block
                {
                    index *= 10;
                } //End block
                streamState.mLastAudibleIndex = streamState.getValidIndex(index);
                {
                    boolean varC15E26D012B1B9E852DBC9691A894BD6_5261081 = (streamState.muteCount() != 0 && !isStreamAffectedByMute(streamType));
                    {
                        int size;
                        size = streamState.mDeathHandlers.size();
                        {
                            int i;
                            i = 0;
                            {
                                streamState.mDeathHandlers.get(i).mMuteCount = 1;
                                streamState.mDeathHandlers.get(i).mute(false);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var9ACE072EC3C199A34E25410B259F2A71_898467424 = (streamState.muteCount() == 0);
                    {
                        setStreamVolumeIndex(streamType, streamState.mIndex);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        setRingerModeInt(getRingerMode(), false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.882 -0400", hash_original_method = "3219ADD1A8948E8C52E7C59AA3E623D8", hash_generated_method = "182E51B6DE1BE1BBF4B0386B5BF639F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpeakerphoneOn(boolean on) {
        dsTaint.addTaint(on);
        {
            boolean var35AAAF191BB03DBB47467FCD5EE54694_1307912609 = (!checkAudioSettingsPermission("setSpeakerphoneOn()"));
        } //End collapsed parenthetic
        mForcedUseForComm = on ? AudioSystem.FORCE_SPEAKER : AudioSystem.FORCE_NONE;
        sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                AudioSystem.FOR_COMMUNICATION, mForcedUseForComm, null, 0);
        // ---------- Original Method ----------
        //if (!checkAudioSettingsPermission("setSpeakerphoneOn()")) {
            //return;
        //}
        //mForcedUseForComm = on ? AudioSystem.FORCE_SPEAKER : AudioSystem.FORCE_NONE;
        //sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                //AudioSystem.FOR_COMMUNICATION, mForcedUseForComm, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.882 -0400", hash_original_method = "2243C187988CBB15ECBFBA8CAD4C52A9", hash_generated_method = "63BFB48A6E49C58208B5DCF447D5AA02")
    @DSModeled(DSC.SAFE)
    public boolean isSpeakerphoneOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mForcedUseForComm == AudioSystem.FORCE_SPEAKER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.883 -0400", hash_original_method = "2CB40E85434F5F8D74E24F7C673CF836", hash_generated_method = "8BE62CB7A2BA4437AFF40738D1FADDB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBluetoothScoOn(boolean on) {
        dsTaint.addTaint(on);
        {
            boolean var84954E06EF7CAB8D89138D916827DD5A_1711387251 = (!checkAudioSettingsPermission("setBluetoothScoOn()"));
        } //End collapsed parenthetic
        mForcedUseForComm = on ? AudioSystem.FORCE_BT_SCO : AudioSystem.FORCE_NONE;
        sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                AudioSystem.FOR_COMMUNICATION, mForcedUseForComm, null, 0);
        sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                AudioSystem.FOR_RECORD, mForcedUseForComm, null, 0);
        // ---------- Original Method ----------
        //if (!checkAudioSettingsPermission("setBluetoothScoOn()")) {
            //return;
        //}
        //mForcedUseForComm = on ? AudioSystem.FORCE_BT_SCO : AudioSystem.FORCE_NONE;
        //sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                //AudioSystem.FOR_COMMUNICATION, mForcedUseForComm, null, 0);
        //sendMsg(mAudioHandler, MSG_SET_FORCE_USE, SHARED_MSG, SENDMSG_QUEUE,
                //AudioSystem.FOR_RECORD, mForcedUseForComm, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.883 -0400", hash_original_method = "7C4D5BAB3FE0B1E60C52546FC1C7600E", hash_generated_method = "1D9295F94D04D27DEDA664FBA0015612")
    @DSModeled(DSC.SAFE)
    public boolean isBluetoothScoOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mForcedUseForComm == AudioSystem.FORCE_BT_SCO);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.883 -0400", hash_original_method = "30662328CBDD4472F0FD53BD24D575B5", hash_generated_method = "7005066BB72F1ABAB1857A43EFB3FEF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startBluetoothSco(IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        {
            boolean var219331DC4843AC9DC028E4FBB0B686FA_1413664803 = (!checkAudioSettingsPermission("startBluetoothSco()") ||
                !mBootCompleted);
        } //End collapsed parenthetic
        ScoClient client;
        client = getScoClient(cb, true);
        client.incCount();
        // ---------- Original Method ----------
        //if (!checkAudioSettingsPermission("startBluetoothSco()") ||
                //!mBootCompleted) {
            //return;
        //}
        //ScoClient client = getScoClient(cb, true);
        //client.incCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.883 -0400", hash_original_method = "EB0899C013684194C97623A21558AFD5", hash_generated_method = "E7437EABB12B004C92DB90E2CD3A0FFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopBluetoothSco(IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        {
            boolean var63711DF0A573B878D9184C66C20CF1F9_1348237643 = (!checkAudioSettingsPermission("stopBluetoothSco()") ||
                !mBootCompleted);
        } //End collapsed parenthetic
        ScoClient client;
        client = getScoClient(cb, false);
        {
            client.decCount();
        } //End block
        // ---------- Original Method ----------
        //if (!checkAudioSettingsPermission("stopBluetoothSco()") ||
                //!mBootCompleted) {
            //return;
        //}
        //ScoClient client = getScoClient(cb, false);
        //if (client != null) {
            //client.decCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.883 -0400", hash_original_method = "82080372AE690478E0626485E18571A3", hash_generated_method = "5130F7F5E6D77144CB24542D675C9ABD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkScoAudioState() {
        {
            boolean varB238A14762830B7B039F246459305D78_151558660 = (mBluetoothHeadset != null && mBluetoothHeadsetDevice != null &&
                mScoAudioState == SCO_STATE_INACTIVE &&
                mBluetoothHeadset.getAudioState(mBluetoothHeadsetDevice)
                != BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
            {
                mScoAudioState = SCO_STATE_ACTIVE_EXTERNAL;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mBluetoothHeadset != null && mBluetoothHeadsetDevice != null &&
                //mScoAudioState == SCO_STATE_INACTIVE &&
                //mBluetoothHeadset.getAudioState(mBluetoothHeadsetDevice)
                //!= BluetoothHeadset.STATE_AUDIO_DISCONNECTED) {
            //mScoAudioState = SCO_STATE_ACTIVE_EXTERNAL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.884 -0400", hash_original_method = "290595728FD4F00B09BAF3695B34CF72", hash_generated_method = "788DD4DB5BECEA91D13A9BB0C8694AA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ScoClient getScoClient(IBinder cb, boolean create) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(create);
        {
            ScoClient client;
            client = null;
            int size;
            size = mScoClients.size();
            {
                int i;
                i = 0;
                {
                    client = mScoClients.get(i);
                    {
                        boolean var1498363D8400D352ABAED802E2FA3371_283273056 = (client.getBinder() == cb);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                client = new ScoClient(cb);
                mScoClients.add(client);
            } //End block
        } //End block
        return (ScoClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized(mScoClients) {
            //ScoClient client = null;
            //int size = mScoClients.size();
            //for (int i = 0; i < size; i++) {
                //client = mScoClients.get(i);
                //if (client.getBinder() == cb)
                    //return client;
            //}
            //if (create) {
                //client = new ScoClient(cb);
                //mScoClients.add(client);
            //}
            //return client;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.884 -0400", hash_original_method = "6B264707110541D594A587E4A66781FC", hash_generated_method = "223E9BBF7E614E3A9977FDC916C6382E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearAllScoClients(int exceptPid, boolean stopSco) {
        dsTaint.addTaint(stopSco);
        dsTaint.addTaint(exceptPid);
        {
            ScoClient savedClient;
            savedClient = null;
            int size;
            size = mScoClients.size();
            {
                int i;
                i = 0;
                {
                    ScoClient cl;
                    cl = mScoClients.get(i);
                    {
                        boolean varCECB27A289725882729AD10B984A81AF_684707363 = (cl.getPid() != exceptPid);
                        {
                            cl.clearCount(stopSco);
                        } //End block
                        {
                            savedClient = cl;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mScoClients.clear();
            {
                mScoClients.add(savedClient);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(mScoClients) {
            //ScoClient savedClient = null;
            //int size = mScoClients.size();
            //for (int i = 0; i < size; i++) {
                //ScoClient cl = mScoClients.get(i);
                //if (cl.getPid() != exceptPid) {
                    //cl.clearCount(stopSco);
                //} else {
                    //savedClient = cl;
                //}
            //}
            //mScoClients.clear();
            //if (savedClient != null) {
                //mScoClients.add(savedClient);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.884 -0400", hash_original_method = "2F0C032C2CC0F6A6BFEA4FA1612E869C", hash_generated_method = "D6F2BCB0009F4A892BAE8F841C07783B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getBluetoothHeadset() {
        boolean result;
        result = false;
        BluetoothAdapter adapter;
        adapter = BluetoothAdapter.getDefaultAdapter();
        {
            result = adapter.getProfileProxy(mContext, mBluetoothProfileServiceListener,
                                    BluetoothProfile.HEADSET);
        } //End block
        sendMsg(mAudioHandler, MSG_BT_HEADSET_CNCT_FAILED, 0,
                SENDMSG_REPLACE, 0, 0, null, result ? BT_HEADSET_CNCT_TIMEOUT_MS : 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean result = false;
        //BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        //if (adapter != null) {
            //result = adapter.getProfileProxy(mContext, mBluetoothProfileServiceListener,
                                    //BluetoothProfile.HEADSET);
        //}
        //sendMsg(mAudioHandler, MSG_BT_HEADSET_CNCT_FAILED, 0,
                //SENDMSG_REPLACE, 0, 0, null, result ? BT_HEADSET_CNCT_TIMEOUT_MS : 0);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.885 -0400", hash_original_method = "364A6CDCC8546F3798232717EE25ED40", hash_generated_method = "D8B989FC66631045317F5B7236D20EE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void disconnectBluetoothSco(int exceptPid) {
        dsTaint.addTaint(exceptPid);
        {
            checkScoAudioState();
            {
                {
                    {
                        {
                            boolean var81E9BEC12C9B8A19A22A6A77924DB2B0_173553930 = (!mBluetoothHeadset.stopVoiceRecognition(
                                mBluetoothHeadsetDevice));
                            {
                                sendMsg(mAudioHandler, MSG_BT_HEADSET_CNCT_FAILED, 0,
                                    SENDMSG_REPLACE, 0, 0, null, 0);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var6C7AAE13F231D3FB3E3209BCBF4D1758_1283277981 = (mScoAudioState == SCO_STATE_ACTIVE_EXTERNAL &&
                            getBluetoothHeadset());
                        {
                            mScoAudioState = SCO_STATE_DEACTIVATE_EXT_REQ;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                clearAllScoClients(exceptPid, true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.885 -0400", hash_original_method = "F91F47E1B48CFAE55C920F7C6C7C8685", hash_generated_method = "A9A8E75CFBD1D9C6105522592BF8FDAF")
    @DSModeled(DSC.SAFE)
    private void resetBluetoothSco() {
        {
            clearAllScoClients(0, false);
            mScoAudioState = SCO_STATE_INACTIVE;
            broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mScoClients) {
            //clearAllScoClients(0, false);
            //mScoAudioState = SCO_STATE_INACTIVE;
            //broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.885 -0400", hash_original_method = "5A16DFDAAF685B35A32A79FA1FC3BA1F", hash_generated_method = "AB1C2A1CAFDAF442B1D719D95178AC29")
    @DSModeled(DSC.SAFE)
    private void broadcastScoConnectionState(int state) {
        dsTaint.addTaint(state);
        {
            Intent newIntent;
            newIntent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
            newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, state);
            newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_PREVIOUS_STATE,
                    mScoConnectionState);
            mContext.sendStickyBroadcast(newIntent);
        } //End block
        // ---------- Original Method ----------
        //if (state != mScoConnectionState) {
            //Intent newIntent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
            //newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, state);
            //newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_PREVIOUS_STATE,
                    //mScoConnectionState);
            //mContext.sendStickyBroadcast(newIntent);
            //mScoConnectionState = state;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.885 -0400", hash_original_method = "AF01445960AE2C1F829D7FDD365F9A31", hash_generated_method = "3C852A1E56D234D580E2551F13134B2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean checkForRingerModeChange(int oldIndex, int direction, int streamType) {
        dsTaint.addTaint(oldIndex);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(streamType);
        boolean adjustVolumeIndex;
        adjustVolumeIndex = true;
        int newRingerMode;
        newRingerMode = mRingerMode;
        int uiIndex;
        uiIndex = (oldIndex + 5) / 10;
        boolean vibeInSilent;
        vibeInSilent = System.getInt(mContentResolver, System.VIBRATE_IN_SILENT, 1) == 1;
        {
            {
                {
                    newRingerMode = vibeInSilent ? RINGER_MODE_VIBRATE : RINGER_MODE_SILENT;
                } //End block
                {
                    adjustVolumeIndex = false;
                } //End block
            } //End block
        } //End block
        {
            {
                {
                    newRingerMode = RINGER_MODE_SILENT;
                } //End block
            } //End block
            {
                newRingerMode = RINGER_MODE_NORMAL;
            } //End block
            adjustVolumeIndex = false;
        } //End block
        {
            {
                newRingerMode = vibeInSilent ? RINGER_MODE_VIBRATE : RINGER_MODE_NORMAL;
            } //End block
            adjustVolumeIndex = false;
        } //End block
        {
            setRingerMode(newRingerMode);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "5120AD81DF267C5C781D1F44A49B9F35", hash_generated_method = "29977E3A3254BA7F2A0BE17F0FB68D78")
    @DSModeled(DSC.SAFE)
    public boolean isStreamAffectedByRingerMode(int streamType) {
        dsTaint.addTaint(streamType);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mRingerModeAffectedStreams & (1 << streamType)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "B4B9F3DA1A0BE96DBC6BFCA2545138B0", hash_generated_method = "598A2ACBD453E3AA27F56254CF773391")
    @DSModeled(DSC.SAFE)
    private boolean isStreamMutedByRingerMode(int streamType) {
        dsTaint.addTaint(streamType);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mRingerModeMutedStreams & (1 << streamType)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "5EC7A17C0B65DF7DC310FFC40C645E1E", hash_generated_method = "8FBA8076BE8077DDDED06993BE12FC9E")
    @DSModeled(DSC.SAFE)
    public boolean isStreamAffectedByMute(int streamType) {
        dsTaint.addTaint(streamType);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMuteAffectedStreams & (1 << streamType)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "22084B468E84D6C8E1422817470E26D9", hash_generated_method = "450FFD4009CE9D8D1E2B2F408213A84D")
    @DSModeled(DSC.SAFE)
    private void ensureValidDirection(int direction) {
        dsTaint.addTaint(direction);
        {
            throw new IllegalArgumentException("Bad direction " + direction);
        } //End block
        // ---------- Original Method ----------
        //if (direction < AudioManager.ADJUST_LOWER || direction > AudioManager.ADJUST_RAISE) {
            //throw new IllegalArgumentException("Bad direction " + direction);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "F2D82075EE0DD0E5FC93F663E39DB5CF", hash_generated_method = "7A07ECBE2DE655294A99B5A7A0D1DB74")
    @DSModeled(DSC.SAFE)
    private void ensureValidStreamType(int streamType) {
        dsTaint.addTaint(streamType);
        {
            throw new IllegalArgumentException("Bad stream type " + streamType);
        } //End block
        // ---------- Original Method ----------
        //if (streamType < 0 || streamType >= mStreamStates.length) {
            //throw new IllegalArgumentException("Bad stream type " + streamType);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.886 -0400", hash_original_method = "85FB26224615F2E2892AD5005070BD3F", hash_generated_method = "B80BA327F20420FB6312BBFCBC7A17D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getActiveStreamType(int suggestedStreamType) {
        dsTaint.addTaint(suggestedStreamType);
        {
            boolean isOffhook;
            isOffhook = false;
            try 
            {
                ITelephony phone;
                phone = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
                isOffhook = phone.isOffhook();
            } //End block
            catch (RemoteException e)
            { }
            {
                boolean var23EEE3DB546800DE21A1D5CAE0462F9B_861624460 = (isOffhook || getMode() == AudioManager.MODE_IN_COMMUNICATION);
                {
                    {
                        boolean var662B24927595DD213C96EE19D489C50F_299234131 = (AudioSystem.getForceUse(AudioSystem.FOR_COMMUNICATION)
                        == AudioSystem.FORCE_BT_SCO);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean varDC8E80E51851CBC5746B7F9FEE74F453_44326887 = (AudioSystem.isStreamActive(AudioSystem.STREAM_MUSIC, 0));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var4D9C5D55B8E915CCCC478C76FD062CE8_1289886976 = (getMode() == AudioManager.MODE_IN_COMMUNICATION);
                {
                    {
                        boolean var662B24927595DD213C96EE19D489C50F_941828453 = (AudioSystem.getForceUse(AudioSystem.FOR_COMMUNICATION)
                        == AudioSystem.FORCE_BT_SCO);
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var34BA9173F7C67858D81E8C0A606C411C_1875420272 = (AudioSystem.isStreamActive(AudioSystem.STREAM_NOTIFICATION,
                            NOTIFICATION_VOLUME_DELAY_MS) ||
                       AudioSystem.isStreamActive(AudioSystem.STREAM_RING,
                            NOTIFICATION_VOLUME_DELAY_MS));
                    {
                        boolean var4C6FC1E2A8F7EF246C486A7F2ADA6B3E_982190399 = (AudioSystem.isStreamActive(AudioSystem.STREAM_MUSIC, 0) ||
                       (suggestedStreamType == AudioManager.USE_DEFAULT_STREAM_TYPE));
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "054F88596AB420DBBD4BDAB8B15F3A77", hash_generated_method = "4D31A934B8D3E0E4F89A750FE65F6801")
    @DSModeled(DSC.SAFE)
    private void broadcastRingerMode() {
        Intent broadcast;
        broadcast = new Intent(AudioManager.RINGER_MODE_CHANGED_ACTION);
        broadcast.putExtra(AudioManager.EXTRA_RINGER_MODE, mRingerMode);
        broadcast.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT
                | Intent.FLAG_RECEIVER_REPLACE_PENDING);
        long origCallerIdentityToken;
        origCallerIdentityToken = Binder.clearCallingIdentity();
        mContext.sendStickyBroadcast(broadcast);
        Binder.restoreCallingIdentity(origCallerIdentityToken);
        // ---------- Original Method ----------
        //Intent broadcast = new Intent(AudioManager.RINGER_MODE_CHANGED_ACTION);
        //broadcast.putExtra(AudioManager.EXTRA_RINGER_MODE, mRingerMode);
        //broadcast.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT
                //| Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //long origCallerIdentityToken = Binder.clearCallingIdentity();
        //mContext.sendStickyBroadcast(broadcast);
        //Binder.restoreCallingIdentity(origCallerIdentityToken);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "F1BFDE20B7AA7210C915D67F8EEB4083", hash_generated_method = "3025E39457E05D52D009BE45EE188E1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void broadcastVibrateSetting(int vibrateType) {
        dsTaint.addTaint(vibrateType);
        {
            boolean varFCECCE13D2E496CDA1471159CA5DA33F_1193234549 = (ActivityManagerNative.isSystemReady());
            {
                Intent broadcast;
                broadcast = new Intent(AudioManager.VIBRATE_SETTING_CHANGED_ACTION);
                broadcast.putExtra(AudioManager.EXTRA_VIBRATE_TYPE, vibrateType);
                broadcast.putExtra(AudioManager.EXTRA_VIBRATE_SETTING, getVibrateSetting(vibrateType));
                mContext.sendBroadcast(broadcast);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (ActivityManagerNative.isSystemReady()) {
            //Intent broadcast = new Intent(AudioManager.VIBRATE_SETTING_CHANGED_ACTION);
            //broadcast.putExtra(AudioManager.EXTRA_VIBRATE_TYPE, vibrateType);
            //broadcast.putExtra(AudioManager.EXTRA_VIBRATE_SETTING, getVibrateSetting(vibrateType));
            //mContext.sendBroadcast(broadcast);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "AC456E7C111FF2599D53C26BB4026890", hash_generated_method = "4A1BD6BA8FE747C79604356B2EACC355")
    private static int getMsg(int baseMsg, int streamType) {
        return (baseMsg & 0xffff) | streamType << 16;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "A81000AA032295D5C3A0A134AF0F2A7B", hash_generated_method = "9341DCDD33A29DA01B3206DEC32E7D12")
    private static int getMsgBase(int msg) {
        return msg & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "97C4ACE75B5A7B7EE5BD43D61AF190CB", hash_generated_method = "D4871A0C6002FD64B0914169FB66023A")
    private static void sendMsg(Handler handler, int baseMsg, int streamType,
            int existingMsgPolicy, int arg1, int arg2, Object obj, int delay) {
        int msg = (streamType == SHARED_MSG) ? baseMsg : getMsg(baseMsg, streamType);
        if (existingMsgPolicy == SENDMSG_REPLACE) {
            handler.removeMessages(msg);
        } else if (existingMsgPolicy == SENDMSG_NOOP && handler.hasMessages(msg)) {
            return;
        }
        handler
                .sendMessageDelayed(handler.obtainMessage(msg, arg1, arg2, obj), delay);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.887 -0400", hash_original_method = "008738E75C6AAAB989D80309B9E4302F", hash_generated_method = "A08D7A09A992258A3FAC1977AA6A57A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean checkAudioSettingsPermission(String method) {
        dsTaint.addTaint(method);
        {
            boolean var9435D24EB939A3B7ECC5FEC1DE2615F6_1712960539 = (mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS")
                == PackageManager.PERMISSION_GRANTED);
        } //End collapsed parenthetic
        String msg;
        msg = "Audio Settings Permission Denial: " + method + " from pid="
                + Binder.getCallingPid()
                + ", uid=" + Binder.getCallingUid();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS")
                //== PackageManager.PERMISSION_GRANTED) {
            //return true;
        //}
        //String msg = "Audio Settings Permission Denial: " + method + " from pid="
                //+ Binder.getCallingPid()
                //+ ", uid=" + Binder.getCallingUid();
        //Log.w(TAG, msg);
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "14B2637D259AA15188BB87C9F8B4C857", hash_generated_method = "B28B25F8D76210ADFEDF23391989D6BB")
    @DSModeled(DSC.SAFE)
    private void makeA2dpDeviceAvailable(String address) {
        dsTaint.addTaint(address);
        AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP,
                AudioSystem.DEVICE_STATE_AVAILABLE,
                address);
        AudioSystem.setParameters("A2dpSuspended=false");
        mConnectedDevices.put( new Integer(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP),
                address);
        // ---------- Original Method ----------
        //AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP,
                //AudioSystem.DEVICE_STATE_AVAILABLE,
                //address);
        //AudioSystem.setParameters("A2dpSuspended=false");
        //mConnectedDevices.put( new Integer(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP),
                //address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "AB7046D13471CE4A760AB83FC207C33E", hash_generated_method = "BD8477FB4593C7BC4D06FB5A8784C3D3")
    @DSModeled(DSC.SAFE)
    private void makeA2dpDeviceUnavailableNow(String address) {
        dsTaint.addTaint(address);
        Intent noisyIntent;
        noisyIntent = new Intent(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        mContext.sendBroadcast(noisyIntent);
        AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP,
                AudioSystem.DEVICE_STATE_UNAVAILABLE,
                address);
        mConnectedDevices.remove(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP);
        // ---------- Original Method ----------
        //Intent noisyIntent = new Intent(AudioManager.ACTION_AUDIO_BECOMING_NOISY);
        //mContext.sendBroadcast(noisyIntent);
        //AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP,
                //AudioSystem.DEVICE_STATE_UNAVAILABLE,
                //address);
        //mConnectedDevices.remove(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "91293F1D83252DF65FCBEEA7DCCB8C4F", hash_generated_method = "8BD32F8EA72C95DB166FC6A7C070D506")
    @DSModeled(DSC.SAFE)
    private void makeA2dpDeviceUnavailableLater(String address) {
        dsTaint.addTaint(address);
        AudioSystem.setParameters("A2dpSuspended=true");
        mConnectedDevices.remove(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP);
        Message msg;
        msg = mAudioHandler.obtainMessage(MSG_BTA2DP_DOCK_TIMEOUT, address);
        mAudioHandler.sendMessageDelayed(msg, BTA2DP_DOCK_TIMEOUT_MILLIS);
        // ---------- Original Method ----------
        //AudioSystem.setParameters("A2dpSuspended=true");
        //mConnectedDevices.remove(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP);
        //Message msg = mAudioHandler.obtainMessage(MSG_BTA2DP_DOCK_TIMEOUT, address);
        //mAudioHandler.sendMessageDelayed(msg, BTA2DP_DOCK_TIMEOUT_MILLIS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "F501D216C8B36C291A1F2C75AE59E351", hash_generated_method = "FDBEA45711987F0A702FC309A9721721")
    @DSModeled(DSC.SAFE)
    private void cancelA2dpDeviceTimeout() {
        mAudioHandler.removeMessages(MSG_BTA2DP_DOCK_TIMEOUT);
        // ---------- Original Method ----------
        //mAudioHandler.removeMessages(MSG_BTA2DP_DOCK_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "2A1B49933D0D428B86F1F5C64BD34626", hash_generated_method = "7DDF79B9E3B69DA43FDA644C981A3138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasScheduledA2dpDockTimeout() {
        boolean var60205FAA3FCC22A9B0D11339E4419512_1463537655 = (mAudioHandler.hasMessages(MSG_BTA2DP_DOCK_TIMEOUT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAudioHandler.hasMessages(MSG_BTA2DP_DOCK_TIMEOUT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.888 -0400", hash_original_method = "6D29A5111398682FB5BC4154770EBC57", hash_generated_method = "0AB31D58236835F195998AA14D70779B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleA2dpConnectionStateChange(BluetoothDevice btDevice, int state) {
        dsTaint.addTaint(btDevice.dsTaint);
        dsTaint.addTaint(state);
        String address;
        address = btDevice.getAddress();
        {
            boolean varD73B4433999E31B5BD12C61E2C084961_921586113 = (!BluetoothAdapter.checkBluetoothAddress(address));
            {
                address = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean isConnected;
            isConnected = (mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP) &&
                 mConnectedDevices.get(AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP).equals(address));
            {
                {
                    boolean varD2EC1FB6B114513763ECF53D11B7E84C_1388639367 = (btDevice.isBluetoothDock());
                    {
                        {
                            makeA2dpDeviceUnavailableLater(address);
                        } //End block
                    } //End block
                    {
                        makeA2dpDeviceUnavailableNow(address);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varD2EC1FB6B114513763ECF53D11B7E84C_21172046 = (btDevice.isBluetoothDock());
                    {
                        cancelA2dpDeviceTimeout();
                        mDockAddress = address;
                    } //End block
                    {
                        {
                            boolean varD2FD51D853498D5BCE00A2A9ADABC491_1371359998 = (hasScheduledA2dpDockTimeout());
                            {
                                cancelA2dpDeviceTimeout();
                                makeA2dpDeviceUnavailableNow(mDockAddress);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                makeA2dpDeviceAvailable(address);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.889 -0400", hash_original_method = "AF9B7D1AB66952823A9B7139F659E54C", hash_generated_method = "3363898F54FEDEB859CB7F98817619EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyTopOfAudioFocusStack() {
        {
            boolean varCB393BEFDA3A4667B7C9F03D602848EF_1970102319 = (!mFocusStack.empty() && (mFocusStack.peek().mFocusDispatcher != null));
            {
                {
                    boolean varE337CD00750E7BDF6CD74DB9F93FF004_1608871350 = (canReassignAudioFocus());
                    {
                        try 
                        {
                            mFocusStack.peek().mFocusDispatcher.dispatchAudioFocusChange(
                            AudioManager.AUDIOFOCUS_GAIN, mFocusStack.peek().mClientId);
                        } //End block
                        catch (RemoteException e)
                        {
                            e.printStackTrace();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mFocusStack.empty() && (mFocusStack.peek().mFocusDispatcher != null)) {
            //if (canReassignAudioFocus()) {
                //try {
                    //mFocusStack.peek().mFocusDispatcher.dispatchAudioFocusChange(
                            //AudioManager.AUDIOFOCUS_GAIN, mFocusStack.peek().mClientId);
                //} catch (RemoteException e) {
                    //Log.e(TAG, "Failure to signal gain of audio control focus due to "+ e);
                    //e.printStackTrace();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.889 -0400", hash_original_method = "E1D0B358AC62856EDCC9B2EBF813B9BB", hash_generated_method = "14F6162DA5938745364DE5335FC54984")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpFocusStack(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        pw.println("\nAudio Focus stack entries:");
        {
            Iterator<FocusStackEntry> stackIterator;
            stackIterator = mFocusStack.iterator();
            {
                boolean varA85FAA9DD28D9DB3D1658EF4CA41ECCA_1620156680 = (stackIterator.hasNext());
                {
                    FocusStackEntry fse;
                    fse = stackIterator.next();
                    pw.println("     source:" + fse.mSourceRef + " -- client: " + fse.mClientId
                        + " -- duration: " + fse.mFocusChangeType
                        + " -- uid: " + fse.mCallingUid);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //pw.println("\nAudio Focus stack entries:");
        //synchronized(mAudioFocusLock) {
            //Iterator<FocusStackEntry> stackIterator = mFocusStack.iterator();
            //while(stackIterator.hasNext()) {
                //FocusStackEntry fse = stackIterator.next();
                //pw.println("     source:" + fse.mSourceRef + " -- client: " + fse.mClientId
                        //+ " -- duration: " + fse.mFocusChangeType
                        //+ " -- uid: " + fse.mCallingUid);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.889 -0400", hash_original_method = "90139EDDA0D8F54758715BEB616CBB56", hash_generated_method = "DF52FC4767F96062492C5329DF8CD5E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFocusStackEntry(String clientToRemove, boolean signal) {
        dsTaint.addTaint(clientToRemove);
        dsTaint.addTaint(signal);
        {
            boolean varCCFA1FB628900F2EBA61CC11215F4467_1724739986 = (!mFocusStack.empty() && mFocusStack.peek().mClientId.equals(clientToRemove));
            {
                FocusStackEntry fse;
                fse = mFocusStack.pop();
                fse.unlinkToDeath();
                {
                    notifyTopOfAudioFocusStack();
                    {
                        checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
                    } //End block
                } //End block
            } //End block
            {
                Iterator<FocusStackEntry> stackIterator;
                stackIterator = mFocusStack.iterator();
                {
                    boolean var161EA925C338D7908A8E0DB56816336B_495211925 = (stackIterator.hasNext());
                    {
                        FocusStackEntry fse;
                        fse = (FocusStackEntry)stackIterator.next();
                        {
                            boolean varA1775A024596A4A9C735C248638A0E4A_1595368849 = (fse.mClientId.equals(clientToRemove));
                            {
                                stackIterator.remove();
                                fse.unlinkToDeath();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.889 -0400", hash_original_method = "9628B4DC6119A85AAE88C4C1BE62A21E", hash_generated_method = "D0267065A2A73A88DBFBC13D17B975A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeFocusStackEntryForClient(IBinder cb) {
        dsTaint.addTaint(cb.dsTaint);
        boolean isTopOfStackForClientToRemove;
        isTopOfStackForClientToRemove = !mFocusStack.isEmpty() &&
                mFocusStack.peek().mSourceRef.equals(cb);
        Iterator<FocusStackEntry> stackIterator;
        stackIterator = mFocusStack.iterator();
        {
            boolean varE6A2E17AE77D5E29E1CA5317E1DC7BE5_1309150612 = (stackIterator.hasNext());
            {
                FocusStackEntry fse;
                fse = (FocusStackEntry)stackIterator.next();
                {
                    boolean var4E3AC1E7995FFA609045E37A853616E0_724203364 = (fse.mSourceRef.equals(cb));
                    {
                        stackIterator.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            notifyTopOfAudioFocusStack();
            {
                checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.890 -0400", hash_original_method = "1C7326B0F69E7A8C57D64655C753C45A", hash_generated_method = "42E40D67D567E21A95CF72CBF5C9CEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean canReassignAudioFocus() {
        {
            boolean var2D25122242E7E1F25E8545C5091DE0EB_2088566528 = (!mFocusStack.isEmpty() && IN_VOICE_COMM_FOCUS_ID.equals(mFocusStack.peek().mClientId));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mFocusStack.isEmpty() && IN_VOICE_COMM_FOCUS_ID.equals(mFocusStack.peek().mClientId)) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.890 -0400", hash_original_method = "B05E189CCC0BC2D41E290CA53A44E4DE", hash_generated_method = "4E77BC8FD8ECAAB2C909B851A167945B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int requestAudioFocus(int mainStreamType, int focusChangeHint, IBinder cb,
            IAudioFocusDispatcher fd, String clientId, String callingPackageName) {
        dsTaint.addTaint(mainStreamType);
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(callingPackageName);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(clientId);
        dsTaint.addTaint(focusChangeHint);
        {
            boolean var395DA6B445C295658F82979388C368C1_100240904 = (!cb.pingBinder());
        } //End collapsed parenthetic
        {
            {
                boolean var238609F8AD801824DB16C3C2ED70DBED_1808230307 = (!canReassignAudioFocus());
            } //End collapsed parenthetic
            AudioFocusDeathHandler afdh;
            afdh = new AudioFocusDeathHandler(cb);
            try 
            {
                cb.linkToDeath(afdh, 0);
            } //End block
            catch (RemoteException e)
            { }
            {
                boolean var27B8446FF1D42606F589778595088278_1134325919 = (!mFocusStack.empty() && mFocusStack.peek().mClientId.equals(clientId));
                {
                    {
                        boolean var2AADE73DFC60998C908C8AA2A67B3E81_720961728 = (mFocusStack.peek().mFocusChangeType == focusChangeHint);
                        {
                            cb.unlinkToDeath(afdh, 0);
                        } //End block
                    } //End collapsed parenthetic
                    FocusStackEntry fse;
                    fse = mFocusStack.pop();
                    fse.unlinkToDeath();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var476D52CB632D0FAED7615542BE12FA47_1507944476 = (!mFocusStack.empty() && (mFocusStack.peek().mFocusDispatcher != null));
                {
                    try 
                    {
                        mFocusStack.peek().mFocusDispatcher.dispatchAudioFocusChange(
                            -1 * focusChangeHint, 
                            mFocusStack.peek().mClientId);
                    } //End block
                    catch (RemoteException e)
                    {
                        e.printStackTrace();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            removeFocusStackEntry(clientId, false );
            mFocusStack.push(new FocusStackEntry(mainStreamType, focusChangeHint, fd, cb,
                    clientId, afdh, callingPackageName, Binder.getCallingUid()));
            {
                checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.890 -0400", hash_original_method = "9D7A6A3C4CD2496466EB0B049660E10A", hash_generated_method = "FA234C0D4B99BF0576A1F3CAD5A98A33")
    @DSModeled(DSC.SAFE)
    public int abandonAudioFocus(IAudioFocusDispatcher fl, String clientId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(fl.dsTaint);
        dsTaint.addTaint(clientId);
        try 
        {
            {
                removeFocusStackEntry(clientId, true);
            } //End block
        } //End block
        catch (java.util.ConcurrentModificationException cme)
        {
            cme.printStackTrace();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Log.i(TAG, " AudioFocus  abandonAudioFocus() from " + clientId);
        //try {
            //synchronized(mAudioFocusLock) {
                //removeFocusStackEntry(clientId, true);
            //}
        //} catch (java.util.ConcurrentModificationException cme) {
            //Log.e(TAG, "FATAL EXCEPTION AudioFocus  abandonAudioFocus() caused " + cme);
            //cme.printStackTrace();
        //}
        //return AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.890 -0400", hash_original_method = "12970BC274CD7A33FD5254FFA7FC9AC3", hash_generated_method = "8209248BC49A8EEBB73E172E938D980C")
    @DSModeled(DSC.SAFE)
    public void unregisterAudioFocusClient(String clientId) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(clientId);
        {
            removeFocusStackEntry(clientId, false);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mAudioFocusLock) {
            //removeFocusStackEntry(clientId, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.891 -0400", hash_original_method = "CD156DB6944E3D4FF5DE419CBF4243EB", hash_generated_method = "ACF5CE9F2C4953B7CC7DE0447A063C85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpRCStack(PrintWriter pw) {
        dsTaint.addTaint(pw.dsTaint);
        pw.println("\nRemote Control stack entries:");
        {
            Iterator<RemoteControlStackEntry> stackIterator;
            stackIterator = mRCStack.iterator();
            {
                boolean varA85FAA9DD28D9DB3D1658EF4CA41ECCA_1347508100 = (stackIterator.hasNext());
                {
                    RemoteControlStackEntry rcse;
                    rcse = stackIterator.next();
                    pw.println("  pi: " + rcse.mMediaIntent +
                        "  -- ercvr: " + rcse.mReceiverComponent +
                        "  -- client: " + rcse.mRcClient +
                        "  -- uid: " + rcse.mCallingUid);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //pw.println("\nRemote Control stack entries:");
        //synchronized(mRCStack) {
            //Iterator<RemoteControlStackEntry> stackIterator = mRCStack.iterator();
            //while(stackIterator.hasNext()) {
                //RemoteControlStackEntry rcse = stackIterator.next();
                //pw.println("  pi: " + rcse.mMediaIntent +
                        //"  -- ercvr: " + rcse.mReceiverComponent +
                        //"  -- client: " + rcse.mRcClient +
                        //"  -- uid: " + rcse.mCallingUid);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.891 -0400", hash_original_method = "E015DCD224A50CEC92D04E1C7558945B", hash_generated_method = "D510CD7E22F8FC765C0FCA7CF2037CE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeMediaButtonReceiverForPackage(String packageName) {
        dsTaint.addTaint(packageName);
        {
            {
                boolean var89449DAC110157CABCFB0F349B53277D_1479272653 = (mRCStack.empty());
                {
                    RemoteControlStackEntry oldTop;
                    oldTop = mRCStack.peek();
                    Iterator<RemoteControlStackEntry> stackIterator;
                    stackIterator = mRCStack.iterator();
                    {
                        boolean var6B77D866610EE4E14845418DC7118B0D_2118720786 = (stackIterator.hasNext());
                        {
                            RemoteControlStackEntry rcse;
                            rcse = (RemoteControlStackEntry)stackIterator.next();
                            {
                                boolean var918502ADC684FCC7771521810F13D0AF_2139712534 = (packageName.equalsIgnoreCase(rcse.mReceiverComponent.getPackageName()));
                                {
                                    stackIterator.remove();
                                    rcse.unlinkToRcClientDeath();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var01C1E7687AE6EE20824F63C2FD06D582_1996188425 = (mRCStack.empty());
                        {
                            mAudioHandler.sendMessage(
                            mAudioHandler.obtainMessage(MSG_PERSIST_MEDIABUTTONRECEIVER, 0, 0,
                                    null));
                        } //End block
                        {
                            boolean var39515D6E31134C2E35B856162273F6A2_2020410395 = (oldTop != mRCStack.peek());
                            {
                                mAudioHandler.sendMessage(
                            mAudioHandler.obtainMessage(MSG_PERSIST_MEDIABUTTONRECEIVER, 0, 0,
                                    mRCStack.peek().mReceiverComponent));
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.891 -0400", hash_original_method = "701A4F5204ADBF8307D552124C361BB6", hash_generated_method = "E3E11A1B8F2166BBF985C78235234873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void restoreMediaButtonReceiver() {
        String receiverName;
        receiverName = Settings.System.getString(mContentResolver,
                Settings.System.MEDIA_BUTTON_RECEIVER);
        {
            boolean varB882A9808A3FDEAC3A5A9543D1A4EF0A_1020141392 = ((null != receiverName) && !receiverName.isEmpty());
            {
                ComponentName eventReceiver;
                eventReceiver = ComponentName.unflattenFromString(receiverName);
                Intent mediaButtonIntent;
                mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
                mediaButtonIntent.setComponent(eventReceiver);
                PendingIntent pi;
                pi = PendingIntent.getBroadcast(mContext,
                    0, mediaButtonIntent, 0);
                registerMediaButtonIntent(pi, eventReceiver);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String receiverName = Settings.System.getString(mContentResolver,
                //Settings.System.MEDIA_BUTTON_RECEIVER);
        //if ((null != receiverName) && !receiverName.isEmpty()) {
            //ComponentName eventReceiver = ComponentName.unflattenFromString(receiverName);
            //Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
            //mediaButtonIntent.setComponent(eventReceiver);
            //PendingIntent pi = PendingIntent.getBroadcast(mContext,
                    //0, mediaButtonIntent, 0);
            //registerMediaButtonIntent(pi, eventReceiver);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.892 -0400", hash_original_method = "16FA61F8D6A2AC7B09C2B4775353FEC1", hash_generated_method = "8B38E35D71B1C450DC5981E36B7BB171")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void pushMediaButtonReceiver(PendingIntent mediaIntent, ComponentName target) {
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(mediaIntent.dsTaint);
        {
            boolean varF57AD491F2F7E207BF275C0B7CBBDBD2_1169130499 = (!mRCStack.empty() && mRCStack.peek().mMediaIntent.equals(mediaIntent));
        } //End collapsed parenthetic
        Iterator<RemoteControlStackEntry> stackIterator;
        stackIterator = mRCStack.iterator();
        RemoteControlStackEntry rcse;
        rcse = null;
        boolean wasInsideStack;
        wasInsideStack = false;
        {
            boolean varE6A2E17AE77D5E29E1CA5317E1DC7BE5_231881660 = (stackIterator.hasNext());
            {
                rcse = (RemoteControlStackEntry)stackIterator.next();
                {
                    boolean var0C37258D66A4011988FC2620D7EA7BE1_1102429953 = (rcse.mMediaIntent.equals(mediaIntent));
                    {
                        wasInsideStack = true;
                        stackIterator.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            rcse = new RemoteControlStackEntry(mediaIntent, target);
        } //End block
        mRCStack.push(rcse);
        mAudioHandler.sendMessage( mAudioHandler.obtainMessage(
                MSG_PERSIST_MEDIABUTTONRECEIVER, 0, 0, target) );
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.892 -0400", hash_original_method = "CDB4975C9680E19B4CCC19C38306E120", hash_generated_method = "B99CCB17D73D109616FE00B351D0866C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeMediaButtonReceiver(PendingIntent pi) {
        dsTaint.addTaint(pi.dsTaint);
        Iterator<RemoteControlStackEntry> stackIterator;
        stackIterator = mRCStack.iterator();
        {
            boolean varE6A2E17AE77D5E29E1CA5317E1DC7BE5_862487621 = (stackIterator.hasNext());
            {
                RemoteControlStackEntry rcse;
                rcse = (RemoteControlStackEntry)stackIterator.next();
                {
                    boolean varCA2E89E21D7220D7BF2D994EF3899EAD_22314484 = (rcse.mMediaIntent.equals(pi));
                    {
                        stackIterator.remove();
                        rcse.unlinkToRcClientDeath();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<RemoteControlStackEntry> stackIterator = mRCStack.iterator();
        //while(stackIterator.hasNext()) {
            //RemoteControlStackEntry rcse = (RemoteControlStackEntry)stackIterator.next();
            //if(rcse.mMediaIntent.equals(pi)) {
                //stackIterator.remove();
                //rcse.unlinkToRcClientDeath();
                //break;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.892 -0400", hash_original_method = "9388DC631EFBDD2E0B2EEA2E0556B2BE", hash_generated_method = "2205F9818FB7155A460564E307F560C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isCurrentRcController(PendingIntent pi) {
        dsTaint.addTaint(pi.dsTaint);
        {
            boolean var2224FDEFCDC69D1DAA350735A26DB965_64912721 = (!mRCStack.empty() && mRCStack.peek().mMediaIntent.equals(pi));
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!mRCStack.empty() && mRCStack.peek().mMediaIntent.equals(pi)) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.892 -0400", hash_original_method = "C6F28674BB4840DDC51C1A5C49999D78", hash_generated_method = "2C559F5415A1A481FF423F1C245EA588")
    @DSModeled(DSC.SAFE)
    private void setNewRcClientOnDisplays_syncRcsCurrc(int newClientGeneration,
            PendingIntent newMediaIntent, boolean clearing) {
        dsTaint.addTaint(newMediaIntent.dsTaint);
        dsTaint.addTaint(clearing);
        dsTaint.addTaint(newClientGeneration);
        {
            try 
            {
                mRcDisplay.setCurrentClientId(
                        newClientGeneration, newMediaIntent, clearing);
            } //End block
            catch (RemoteException e)
            {
                rcDisplay_stopDeathMonitor_syncRcStack();
                mRcDisplay = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mRcDisplay != null) {
            //try {
                //mRcDisplay.setCurrentClientId(
                        //newClientGeneration, newMediaIntent, clearing);
            //} catch (RemoteException e) {
                //Log.e(TAG, "Dead display in setNewRcClientOnDisplays_syncRcsCurrc() "+e);
                //rcDisplay_stopDeathMonitor_syncRcStack();
                //mRcDisplay = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.892 -0400", hash_original_method = "34FC3ECAF02CB32414B5D86281291982", hash_generated_method = "104354D4AFAAB168A8F1CAE2D4430385")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setNewRcClientGenerationOnClients_syncRcsCurrc(int newClientGeneration) {
        dsTaint.addTaint(newClientGeneration);
        Iterator<RemoteControlStackEntry> stackIterator;
        stackIterator = mRCStack.iterator();
        {
            boolean varE6A2E17AE77D5E29E1CA5317E1DC7BE5_1274424780 = (stackIterator.hasNext());
            {
                RemoteControlStackEntry se;
                se = stackIterator.next();
                {
                    try 
                    {
                        se.mRcClient.setCurrentClientGenerationId(newClientGeneration);
                    } //End block
                    catch (RemoteException e)
                    {
                        stackIterator.remove();
                        se.unlinkToRcClientDeath();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<RemoteControlStackEntry> stackIterator = mRCStack.iterator();
        //while(stackIterator.hasNext()) {
            //RemoteControlStackEntry se = stackIterator.next();
            //if ((se != null) && (se.mRcClient != null)) {
                //try {
                    //se.mRcClient.setCurrentClientGenerationId(newClientGeneration);
                //} catch (RemoteException e) {
                    //Log.w(TAG, "Dead client in setNewRcClientGenerationOnClients_syncRcsCurrc()"+e);
                    //stackIterator.remove();
                    //se.unlinkToRcClientDeath();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "D07351795D442A61F462BDAB20B241FF", hash_generated_method = "0B0C4F5F05907C9C66901D5AFDBF1425")
    @DSModeled(DSC.SAFE)
    private void setNewRcClient_syncRcsCurrc(int newClientGeneration,
            PendingIntent newMediaIntent, boolean clearing) {
        dsTaint.addTaint(newMediaIntent.dsTaint);
        dsTaint.addTaint(clearing);
        dsTaint.addTaint(newClientGeneration);
        setNewRcClientOnDisplays_syncRcsCurrc(newClientGeneration, newMediaIntent, clearing);
        setNewRcClientGenerationOnClients_syncRcsCurrc(newClientGeneration);
        // ---------- Original Method ----------
        //setNewRcClientOnDisplays_syncRcsCurrc(newClientGeneration, newMediaIntent, clearing);
        //setNewRcClientGenerationOnClients_syncRcsCurrc(newClientGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "F554BB52DFFC064E944D65CEC232E7D7", hash_generated_method = "070E1507977700A88D9B157223762A5F")
    @DSModeled(DSC.SAFE)
    private void onRcDisplayClear() {
        {
            {
                mCurrentRcClientGen++;
                setNewRcClient_syncRcsCurrc(mCurrentRcClientGen,
                        null , true );
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_RC) Log.i(TAG, "Clear remote control display");
        //synchronized(mRCStack) {
            //synchronized(mCurrentRcLock) {
                //mCurrentRcClientGen++;
                //setNewRcClient_syncRcsCurrc(mCurrentRcClientGen,
                        //null , true );
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "99721A762800000565F75840EFEFC5B2", hash_generated_method = "EB96E7B26590747EE1A67293EAB201FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onRcDisplayUpdate(RemoteControlStackEntry rcse, int flags ) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(rcse.dsTaint);
        {
            {
                {
                    boolean var6566B56BBAB64C5399D73DF12BD63289_1312749209 = ((mCurrentRcClient != null) && (mCurrentRcClient.equals(rcse.mRcClient)));
                    {
                        mCurrentRcClientGen++;
                        setNewRcClient_syncRcsCurrc(mCurrentRcClientGen,
                            rcse.mMediaIntent ,
                            false );
                        try 
                        {
                            mCurrentRcClient.onInformationRequested(mCurrentRcClientGen,
                                flags, mArtworkExpectedWidth, mArtworkExpectedHeight);
                        } //End block
                        catch (RemoteException e)
                        {
                            mCurrentRcClient = null;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "1431F2C82698B44747ED7C73FF441A4B", hash_generated_method = "69015EB436ABECF79E020D56320F2B47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearRemoteControlDisplay_syncAfRcs() {
        {
            mCurrentRcClient = null;
        } //End block
        mAudioHandler.sendMessage( mAudioHandler.obtainMessage(MSG_RCDISPLAY_CLEAR) );
        // ---------- Original Method ----------
        //synchronized(mCurrentRcLock) {
            //mCurrentRcClient = null;
        //}
        //mAudioHandler.sendMessage( mAudioHandler.obtainMessage(MSG_RCDISPLAY_CLEAR) );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "6744C64B3F04DC4759EA0AB233BA9F51", hash_generated_method = "E12E1804EC4DF10C21E692CA7EE5A5F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateRemoteControlDisplay_syncAfRcs(int infoChangedFlags) {
        dsTaint.addTaint(infoChangedFlags);
        RemoteControlStackEntry rcse;
        rcse = mRCStack.peek();
        int infoFlagsAboutToBeUsed;
        infoFlagsAboutToBeUsed = infoChangedFlags;
        {
            clearRemoteControlDisplay_syncAfRcs();
        } //End block
        {
            {
                boolean var11D90C25E2736FFBB82A7FFD9629CA0D_932892431 = (!rcse.mRcClient.equals(mCurrentRcClient));
                {
                    infoFlagsAboutToBeUsed = RC_INFO_ALL;
                } //End block
            } //End collapsed parenthetic
            mCurrentRcClient = rcse.mRcClient;
        } //End block
        mAudioHandler.sendMessage( mAudioHandler.obtainMessage(MSG_RCDISPLAY_UPDATE,
                infoFlagsAboutToBeUsed , 0, rcse ) );
        // ---------- Original Method ----------
        //RemoteControlStackEntry rcse = mRCStack.peek();
        //int infoFlagsAboutToBeUsed = infoChangedFlags;
        //if (rcse.mRcClient == null) {
            //clearRemoteControlDisplay_syncAfRcs();
            //return;
        //}
        //synchronized(mCurrentRcLock) {
            //if (!rcse.mRcClient.equals(mCurrentRcClient)) {
                //infoFlagsAboutToBeUsed = RC_INFO_ALL;
            //}
            //mCurrentRcClient = rcse.mRcClient;
        //}
        //mAudioHandler.sendMessage( mAudioHandler.obtainMessage(MSG_RCDISPLAY_UPDATE,
                //infoFlagsAboutToBeUsed , 0, rcse ) );
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.893 -0400", hash_original_method = "016893A97040B0E870176B4954E4FB54", hash_generated_method = "006723AB4BD4CC853D7750E273188F4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkUpdateRemoteControlDisplay_syncAfRcs(int infoChangedFlags) {
        dsTaint.addTaint(infoChangedFlags);
        {
            boolean varA835BD38ACEB60267ADD8608AE073BA9_1338403853 = (mRCStack.isEmpty() || mFocusStack.isEmpty());
            {
                clearRemoteControlDisplay_syncAfRcs();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3E0B9DA448A8A7B2D8A06B3C4221DB5B_1025016333 = ((mRCStack.peek().mCallingPackageName != null)
                && (mFocusStack.peek().mPackageName != null)
                && !(mRCStack.peek().mCallingPackageName.compareTo(
                        mFocusStack.peek().mPackageName) == 0));
            {
                clearRemoteControlDisplay_syncAfRcs();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB4B8F06704E714E3E6A12185F6D6A8B4_982610900 = (mRCStack.peek().mCallingUid != mFocusStack.peek().mCallingUid);
            {
                clearRemoteControlDisplay_syncAfRcs();
            } //End block
        } //End collapsed parenthetic
        updateRemoteControlDisplay_syncAfRcs(infoChangedFlags);
        // ---------- Original Method ----------
        //if (mRCStack.isEmpty() || mFocusStack.isEmpty()) {
            //clearRemoteControlDisplay_syncAfRcs();
            //return;
        //}
        //if ((mRCStack.peek().mCallingPackageName != null)
                //&& (mFocusStack.peek().mPackageName != null)
                //&& !(mRCStack.peek().mCallingPackageName.compareTo(
                        //mFocusStack.peek().mPackageName) == 0)) {
            //clearRemoteControlDisplay_syncAfRcs();
            //return;
        //}
        //if (mRCStack.peek().mCallingUid != mFocusStack.peek().mCallingUid) {
            //clearRemoteControlDisplay_syncAfRcs();
            //return;
        //}
        //updateRemoteControlDisplay_syncAfRcs(infoChangedFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.894 -0400", hash_original_method = "4568621EDE2771605B517BBB9AC2FD83", hash_generated_method = "5A2BA539329F01CE9CE545A718FC42DA")
    @DSModeled(DSC.SAFE)
    public void registerMediaButtonIntent(PendingIntent mediaIntent, ComponentName eventReceiver) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(eventReceiver.dsTaint);
        dsTaint.addTaint(mediaIntent.dsTaint);
        {
            {
                pushMediaButtonReceiver(mediaIntent, eventReceiver);
                checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Log.i(TAG, "  Remote Control   registerMediaButtonIntent() for " + mediaIntent);
        //synchronized(mAudioFocusLock) {
            //synchronized(mRCStack) {
                //pushMediaButtonReceiver(mediaIntent, eventReceiver);
                //checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.894 -0400", hash_original_method = "425F4C7BDA57DE74ADBAE3967CF3C3EF", hash_generated_method = "127E6CFF9E74A146E43D7677B74FA2E5")
    @DSModeled(DSC.SAFE)
    public void unregisterMediaButtonIntent(PendingIntent mediaIntent, ComponentName eventReceiver) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(eventReceiver.dsTaint);
        dsTaint.addTaint(mediaIntent.dsTaint);
        {
            {
                boolean topOfStackWillChange;
                topOfStackWillChange = isCurrentRcController(mediaIntent);
                removeMediaButtonReceiver(mediaIntent);
                {
                    checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Log.i(TAG, "  Remote Control   unregisterMediaButtonIntent() for " + mediaIntent);
        //synchronized(mAudioFocusLock) {
            //synchronized(mRCStack) {
                //boolean topOfStackWillChange = isCurrentRcController(mediaIntent);
                //removeMediaButtonReceiver(mediaIntent);
                //if (topOfStackWillChange) {
                    //checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.894 -0400", hash_original_method = "9F276868E7BB4E52FB99A6312C537859", hash_generated_method = "C5B83A5C8B3AF480E62A077F5B78130E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerRemoteControlClient(PendingIntent mediaIntent,
            IRemoteControlClient rcClient, String callingPackageName) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcClient.dsTaint);
        dsTaint.addTaint(callingPackageName);
        dsTaint.addTaint(mediaIntent.dsTaint);
        {
            {
                Iterator<RemoteControlStackEntry> stackIterator;
                stackIterator = mRCStack.iterator();
                {
                    boolean var161EA925C338D7908A8E0DB56816336B_1853776519 = (stackIterator.hasNext());
                    {
                        RemoteControlStackEntry rcse;
                        rcse = stackIterator.next();
                        {
                            boolean varF98DFC32B6219062F4917841EF6C4CF3_1469222224 = (rcse.mMediaIntent.equals(mediaIntent));
                            {
                                {
                                    rcse.unlinkToRcClientDeath();
                                } //End block
                                rcse.mRcClient = rcClient;
                                rcse.mCallingPackageName = callingPackageName;
                                rcse.mCallingUid = Binder.getCallingUid();
                                {
                                    try 
                                    {
                                        rcse.mRcClient.plugRemoteControlDisplay(mRcDisplay);
                                    } //End block
                                    catch (RemoteException e)
                                    {
                                        e.printStackTrace();
                                    } //End block
                                } //End block
                                IBinder b;
                                b = rcse.mRcClient.asBinder();
                                RcClientDeathHandler rcdh;
                                rcdh = new RcClientDeathHandler(b, rcse.mMediaIntent);
                                try 
                                {
                                    b.linkToDeath(rcdh, 0);
                                } //End block
                                catch (RemoteException e)
                                {
                                    rcse.mRcClient = null;
                                } //End block
                                rcse.mRcClientDeathHandler = rcdh;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var11E112C92A36E07226F878F8A2E4E935_2012314540 = (isCurrentRcController(mediaIntent));
                    {
                        checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.895 -0400", hash_original_method = "56613040E5207243C2AF13E366F50BE5", hash_generated_method = "1AFBD9AD96DF2DA82EC192F555DD463B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterRemoteControlClient(PendingIntent mediaIntent,
            IRemoteControlClient rcClient) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcClient.dsTaint);
        dsTaint.addTaint(mediaIntent.dsTaint);
        {
            {
                Iterator<RemoteControlStackEntry> stackIterator;
                stackIterator = mRCStack.iterator();
                {
                    boolean var161EA925C338D7908A8E0DB56816336B_1851700466 = (stackIterator.hasNext());
                    {
                        RemoteControlStackEntry rcse;
                        rcse = stackIterator.next();
                        {
                            boolean varAE6D3FFD32FC68C9CCE86476A3305A79_950175145 = ((rcse.mMediaIntent.equals(mediaIntent))
                            && rcClient.equals(rcse.mRcClient));
                            {
                                rcse.unlinkToRcClientDeath();
                                rcse.mRcClient = null;
                                rcse.mCallingPackageName = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized(mAudioFocusLock) {
            //synchronized(mRCStack) {
                //Iterator<RemoteControlStackEntry> stackIterator = mRCStack.iterator();
                //while(stackIterator.hasNext()) {
                    //RemoteControlStackEntry rcse = stackIterator.next();
                    //if ((rcse.mMediaIntent.equals(mediaIntent))
                            //&& rcClient.equals(rcse.mRcClient)) {
                        //rcse.unlinkToRcClientDeath();
                        //rcse.mRcClient = null;
                        //rcse.mCallingPackageName = null;
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.895 -0400", hash_original_method = "A801E43BC1C1E950FDF2461BC62264B3", hash_generated_method = "728EBDC548BA0E47F4B77369D8DA22FC")
    @DSModeled(DSC.SAFE)
    private void rcDisplay_stopDeathMonitor_syncRcStack() {
        {
            mRcDisplayDeathHandler.unlinkToRcDisplayDeath();
        } //End block
        // ---------- Original Method ----------
        //if (mRcDisplay != null) { 
            //mRcDisplayDeathHandler.unlinkToRcDisplayDeath();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.895 -0400", hash_original_method = "459031E8ED9F0FA5DEADEA1E19A4D5E7", hash_generated_method = "00A432137A98056BFB2BFD4C09A2E278")
    @DSModeled(DSC.SAFE)
    private void rcDisplay_startDeathMonitor_syncRcStack() {
        {
            IBinder b;
            b = mRcDisplay.asBinder();
            mRcDisplayDeathHandler = new RcDisplayDeathHandler(b);
            try 
            {
                b.linkToDeath(mRcDisplayDeathHandler, 0);
            } //End block
            catch (RemoteException e)
            {
                mRcDisplay = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mRcDisplay != null) {
            //IBinder b = mRcDisplay.asBinder();
            //mRcDisplayDeathHandler = new RcDisplayDeathHandler(b);
            //try {
                //b.linkToDeath(mRcDisplayDeathHandler, 0);
            //} catch (RemoteException e) {
                //Log.w(TAG, "registerRemoteControlDisplay() has a dead client " + b);
                //mRcDisplay = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.895 -0400", hash_original_method = "7381AB32703F9E082D272DC1D086AB1F", hash_generated_method = "E550287EAC4ECC2C2CBA569E116982D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerRemoteControlDisplay(IRemoteControlDisplay rcd) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcd.dsTaint);
        Log.d(TAG, ">>> registerRemoteControlDisplay("+rcd+")");
        {
            {
                rcDisplay_stopDeathMonitor_syncRcStack();
                rcDisplay_startDeathMonitor_syncRcStack();
                Iterator<RemoteControlStackEntry> stackIterator;
                stackIterator = mRCStack.iterator();
                {
                    boolean var161EA925C338D7908A8E0DB56816336B_1696493835 = (stackIterator.hasNext());
                    {
                        RemoteControlStackEntry rcse;
                        rcse = stackIterator.next();
                        {
                            try 
                            {
                                rcse.mRcClient.plugRemoteControlDisplay(mRcDisplay);
                            } //End block
                            catch (RemoteException e)
                            {
                                e.printStackTrace();
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                checkUpdateRemoteControlDisplay_syncAfRcs(RC_INFO_ALL);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "9F8E759F488658CFC59A0F6648CC4A50", hash_generated_method = "24B76F715D0F35924B43A1B781523D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay rcd) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcd.dsTaint);
        Log.d(TAG, "<<< unregisterRemoteControlDisplay("+rcd+")");
        {
            rcDisplay_stopDeathMonitor_syncRcStack();
            mRcDisplay = null;
            Iterator<RemoteControlStackEntry> stackIterator;
            stackIterator = mRCStack.iterator();
            {
                boolean varA85FAA9DD28D9DB3D1658EF4CA41ECCA_1195653564 = (stackIterator.hasNext());
                {
                    RemoteControlStackEntry rcse;
                    rcse = stackIterator.next();
                    {
                        try 
                        {
                            rcse.mRcClient.unplugRemoteControlDisplay(rcd);
                        } //End block
                        catch (RemoteException e)
                        {
                            e.printStackTrace();
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "AA055FCB389BF70E9E28A1D12CB23757", hash_generated_method = "10D4C40A591B31834E8BFCE4577B8DB0")
    @DSModeled(DSC.SAFE)
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay rcd, int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(rcd.dsTaint);
        dsTaint.addTaint(h);
        // ---------- Original Method ----------
        //synchronized(mRCStack) {
            //mArtworkExpectedWidth = w;
            //mArtworkExpectedHeight = h;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "50D9424AA9E90B39F715C28DC853CEF0", hash_generated_method = "C9646A432DF8ABED4C855C33530B5091")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        dsTaint.addTaint(args);
        dsTaint.addTaint(pw.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        dumpFocusStack(pw);
        dumpRCStack(pw);
        // ---------- Original Method ----------
        //dumpFocusStack(pw);
        //dumpRCStack(pw);
    }

    
    private class SetModeDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        private int mPid;
        private int mMode = AudioSystem.MODE_NORMAL;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "7F14B330DBBCA6D61A14DE601FBF034C", hash_generated_method = "03985DE956C3D1D02AF3DF7CB744C410")
        @DSModeled(DSC.SAFE)
         SetModeDeathHandler(IBinder cb, int pid) {
            dsTaint.addTaint(cb.dsTaint);
            dsTaint.addTaint(pid);
            // ---------- Original Method ----------
            //mCb = cb;
            //mPid = pid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "9EAA35E716DA643FE73911638177A400", hash_generated_method = "E48D856D05BE1209D3DD738A1915906E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void binderDied() {
            int newModeOwnerPid;
            newModeOwnerPid = 0;
            {
                int index;
                index = mSetModeDeathHandlers.indexOf(this);
                {
                    newModeOwnerPid = setModeInt(AudioSystem.MODE_NORMAL, mCb, mPid);
                } //End block
            } //End block
            {
                disconnectBluetoothSco(newModeOwnerPid);
            } //End block
            // ---------- Original Method ----------
            //int newModeOwnerPid = 0;
            //synchronized(mSetModeDeathHandlers) {
                //Log.w(TAG, "setMode() client died");
                //int index = mSetModeDeathHandlers.indexOf(this);
                //if (index < 0) {
                    //Log.w(TAG, "unregistered setMode() client died");
                //} else {
                    //newModeOwnerPid = setModeInt(AudioSystem.MODE_NORMAL, mCb, mPid);
                //}
            //}
            //if (newModeOwnerPid != 0) {
                 //disconnectBluetoothSco(newModeOwnerPid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.896 -0400", hash_original_method = "30E9EE034B82B89E2430B9CA08B3CDF3", hash_generated_method = "FCACF9EC5A20BDF107FC0737DA634962")
        @DSModeled(DSC.SAFE)
        public int getPid() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mPid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "C53916769C52220D8629BAC10DAD9869", hash_generated_method = "88C69ED1C89D7E37B907D8BC6D50B068")
        @DSModeled(DSC.SAFE)
        public void setMode(int mode) {
            dsTaint.addTaint(mode);
            // ---------- Original Method ----------
            //mMode = mode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "46CDEAEE57FC46504BB8BB611AFCF88D", hash_generated_method = "CD5645CD4FC965CE17B38E67F6DA3C8D")
        @DSModeled(DSC.SAFE)
        public int getMode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "C6836F87D1645C18ED0EAAF0FAE1DA4D", hash_generated_method = "A4EEFC28D5F5D95C7D6AF7F5195D0FC7")
        @DSModeled(DSC.SAFE)
        public IBinder getBinder() {
            return (IBinder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCb;
        }

        
    }


    
    class SoundPoolListenerThread extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "E3E41969AA302A1CA9CE0B27A306D36C", hash_generated_method = "B6E7AD912E107E365B3AB3BA1FBFEBEA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SoundPoolListenerThread() {
            super("SoundPoolListenerThread");
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "5C0B287FC08A07EEAA7900228B27D373", hash_generated_method = "FAD1A00786CEE28C27BFC728EB760AC1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            Looper.prepare();
            mSoundPoolLooper = Looper.myLooper();
            {
                {
                    mSoundPoolCallBack = new SoundPoolCallback();
                    mSoundPool.setOnLoadCompleteListener(mSoundPoolCallBack);
                } //End block
                mSoundEffectsLock.notify();
            } //End block
            Looper.loop();
            // ---------- Original Method ----------
            //Looper.prepare();
            //mSoundPoolLooper = Looper.myLooper();
            //synchronized (mSoundEffectsLock) {
                //if (mSoundPool != null) {
                    //mSoundPoolCallBack = new SoundPoolCallback();
                    //mSoundPool.setOnLoadCompleteListener(mSoundPoolCallBack);
                //}
                //mSoundEffectsLock.notify();
            //}
            //Looper.loop();
        }

        
    }


    
    private final class SoundPoolCallback implements android.media.SoundPool.OnLoadCompleteListener {
        int mStatus;
        int mLastSample;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "30543FFB5CBF19B2DFD9E14280A0CE7B", hash_generated_method = "D116AD7C678E1D5195913F91EAA2371A")
        @DSModeled(DSC.SAFE)
        public int status() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mStatus;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "CCD48945055B3004581EECF5D1607F50", hash_generated_method = "3DE64E41D31A06F4FAF354A016F4A65D")
        @DSModeled(DSC.SAFE)
        public void setLastSample(int sample) {
            dsTaint.addTaint(sample);
            // ---------- Original Method ----------
            //mLastSample = sample;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.897 -0400", hash_original_method = "509295D01E5A8920EF14825202D3DD08", hash_generated_method = "7A9BF83C8256E88B6D1AF75978F56AED")
        @DSModeled(DSC.SAFE)
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(soundPool.dsTaint);
            dsTaint.addTaint(status);
            dsTaint.addTaint(sampleId);
            {
                {
                    mSoundEffectsLock.notify();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mSoundEffectsLock) {
                //if (status != 0) {
                    //mStatus = status;
                //}
                //if (sampleId == mLastSample) {
                    //mSoundEffectsLock.notify();
                //}
            //}
        }

        
    }


    
    private class ScoClient implements IBinder.DeathRecipient {
        private IBinder mCb;
        private int mCreatorPid;
        private int mStartcount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "CC4F6F494A4FD27109322856F6191EF4", hash_generated_method = "1C38C84D3DFCB1AD47EB4A8E35D8AFD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ScoClient(IBinder cb) {
            dsTaint.addTaint(cb.dsTaint);
            mCreatorPid = Binder.getCallingPid();
            mStartcount = 0;
            // ---------- Original Method ----------
            //mCb = cb;
            //mCreatorPid = Binder.getCallingPid();
            //mStartcount = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "9C363BC5EECA83E1B16A92E8A239BE37", hash_generated_method = "ED4BB1793DA14122060FEC1A6573EC47")
        @DSModeled(DSC.SAFE)
        public void binderDied() {
            {
                int index;
                index = mScoClients.indexOf(this);
                {
                    clearCount(true);
                    mScoClients.remove(this);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(mScoClients) {
                //Log.w(TAG, "SCO client died");
                //int index = mScoClients.indexOf(this);
                //if (index < 0) {
                    //Log.w(TAG, "unregistered SCO client died");
                //} else {
                    //clearCount(true);
                    //mScoClients.remove(this);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "8952C5E3322EE9EC3F2865AD9757990E", hash_generated_method = "B2E354B84284AB0F8EDF428DAA257F23")
        @DSModeled(DSC.SAFE)
        public void incCount() {
            {
                requestScoState(BluetoothHeadset.STATE_AUDIO_CONNECTED);
                {
                    try 
                    {
                        mCb.linkToDeath(this, 0);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                mStartcount++;
            } //End block
            // ---------- Original Method ----------
            //synchronized(mScoClients) {
                //requestScoState(BluetoothHeadset.STATE_AUDIO_CONNECTED);
                //if (mStartcount == 0) {
                    //try {
                        //mCb.linkToDeath(this, 0);
                    //} catch (RemoteException e) {
                        //Log.w(TAG, "ScoClient  incCount() could not link to "+mCb+" binder death");
                    //}
                //}
                //mStartcount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "23D00C9CC07DF544B7797E70803C7770", hash_generated_method = "DFBE021445318D335F4D9340343A7DC6")
        @DSModeled(DSC.SAFE)
        public void decCount() {
            {
                {
                    mStartcount--;
                    {
                        try 
                        {
                            mCb.unlinkToDeath(this, 0);
                        } //End block
                        catch (NoSuchElementException e)
                        { }
                    } //End block
                    requestScoState(BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(mScoClients) {
                //if (mStartcount == 0) {
                    //Log.w(TAG, "ScoClient.decCount() already 0");
                //} else {
                    //mStartcount--;
                    //if (mStartcount == 0) {
                        //try {
                            //mCb.unlinkToDeath(this, 0);
                        //} catch (NoSuchElementException e) {
                            //Log.w(TAG, "decCount() going to 0 but not registered to binder");
                        //}
                    //}
                    //requestScoState(BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "53D53F51D681D7FA1C0787F7AFFBF0FB", hash_generated_method = "C2358BABB4B4A6C108037B39E27EFEE9")
        @DSModeled(DSC.SAFE)
        public void clearCount(boolean stopSco) {
            dsTaint.addTaint(stopSco);
            {
                {
                    try 
                    {
                        mCb.unlinkToDeath(this, 0);
                    } //End block
                    catch (NoSuchElementException e)
                    { }
                } //End block
                mStartcount = 0;
                {
                    requestScoState(BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(mScoClients) {
                //if (mStartcount != 0) {
                    //try {
                        //mCb.unlinkToDeath(this, 0);
                    //} catch (NoSuchElementException e) {
                        //Log.w(TAG, "clearCount() mStartcount: "+mStartcount+" != 0 but not registered to binder");
                    //}
                //}
                //mStartcount = 0;
                //if (stopSco) {
                    //requestScoState(BluetoothHeadset.STATE_AUDIO_DISCONNECTED);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "292A03EB14CD3372223F2A7BAE7C4062", hash_generated_method = "74D047854737D354D7C4B710162B758C")
        @DSModeled(DSC.SAFE)
        public int getCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mStartcount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.898 -0400", hash_original_method = "C6836F87D1645C18ED0EAAF0FAE1DA4D", hash_generated_method = "A4EEFC28D5F5D95C7D6AF7F5195D0FC7")
        @DSModeled(DSC.SAFE)
        public IBinder getBinder() {
            return (IBinder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.899 -0400", hash_original_method = "47D14AEFEE51F7B7CD5AF4FF3E5468BB", hash_generated_method = "3A71155240E59560A88BB70A05B5B1FD")
        @DSModeled(DSC.SAFE)
        public int getPid() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mCreatorPid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.899 -0400", hash_original_method = "B4DB8B6B596CBB8D621BCA09EF950BB8", hash_generated_method = "4FC76665F8C65A5C8F8B3E302C6DCBE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int totalCount() {
            {
                int count;
                count = 0;
                int size;
                size = mScoClients.size();
                {
                    int i;
                    i = 0;
                    {
                        count += mScoClients.get(i).getCount();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized(mScoClients) {
                //int count = 0;
                //int size = mScoClients.size();
                //for (int i = 0; i < size; i++) {
                    //count += mScoClients.get(i).getCount();
                //}
                //return count;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.899 -0400", hash_original_method = "4BD3B72D682DB84560FF72258CEDF467", hash_generated_method = "CB8645A8A2E165765FEB381B46CA1584")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void requestScoState(int state) {
            dsTaint.addTaint(state);
            checkScoAudioState();
            {
                boolean var55F7553E6362470E51185682B62C8C2C_282459273 = (totalCount() == 0);
                {
                    {
                        broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_CONNECTING);
                        {
                            {
                                boolean var219D736FC25165A5A51D710B0496627E_1483024236 = ((mSetModeDeathHandlers.isEmpty() ||
                                mSetModeDeathHandlers.get(0).getPid() == mCreatorPid) &&
                                (mScoAudioState == SCO_STATE_INACTIVE ||
                                 mScoAudioState == SCO_STATE_DEACTIVATE_REQ));
                                {
                                    {
                                        {
                                            {
                                                boolean var94D07534F82151C37EBBE960F60F4D87_2013373366 = (mBluetoothHeadset.startScoUsingVirtualVoiceCall(
                                            mBluetoothHeadsetDevice));
                                                {
                                                    mScoAudioState = SCO_STATE_ACTIVE_INTERNAL;
                                                } //End block
                                                {
                                                    broadcastScoConnectionState(
                                                AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var813EBEB14993C243534025156912225E_1926922214 = (getBluetoothHeadset());
                                            {
                                                mScoAudioState = SCO_STATE_ACTIVATE_REQ;
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    {
                                        mScoAudioState = SCO_STATE_ACTIVE_INTERNAL;
                                        broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_CONNECTED);
                                    } //End block
                                } //End block
                                {
                                    broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        {
                            {
                                {
                                    boolean varDADE28BCA9B73C1FA4FCA0BE09A850CF_2037263222 = (!mBluetoothHeadset.stopScoUsingVirtualVoiceCall(
                                    mBluetoothHeadsetDevice));
                                    {
                                        mScoAudioState = SCO_STATE_INACTIVE;
                                        broadcastScoConnectionState(
                                        AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var46A27BBA039417E4F00E9CD13F36B7AC_669701014 = (getBluetoothHeadset());
                                {
                                    mScoAudioState = SCO_STATE_DEACTIVATE_REQ;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            mScoAudioState = SCO_STATE_INACTIVE;
                            broadcastScoConnectionState(AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public class VolumeStreamState {
        private final int mStreamType;
        private String mVolumeIndexSettingName;
        private String mLastAudibleVolumeIndexSettingName;
        private int mIndexMax;
        private int mIndex;
        private int mLastAudibleIndex;
        private ArrayList<VolumeDeathHandler> mDeathHandlers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "C09844C847A62FFD2E71FBC0BFE2011B", hash_generated_method = "A737137C88B7116A8549625BDCCABF9B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private VolumeStreamState(String settingName, int streamType) {
            dsTaint.addTaint(settingName);
            dsTaint.addTaint(streamType);
            mStreamType = streamType;
            setVolumeIndexSettingName(settingName);
            final ContentResolver cr;
            cr = mContentResolver;
            mIndexMax = MAX_STREAM_VOLUME[streamType];
            mIndex = Settings.System.getInt(cr,
                                            mVolumeIndexSettingName,
                                            AudioManager.DEFAULT_STREAM_VOLUME[streamType]);
            mLastAudibleIndex = Settings.System.getInt(cr,
                                                       mLastAudibleVolumeIndexSettingName,
                                                       (mIndex > 0) ? mIndex : AudioManager.DEFAULT_STREAM_VOLUME[streamType]);
            AudioSystem.initStreamVolume(streamType, 0, mIndexMax);
            mIndexMax *= 10;
            mIndex = getValidIndex(10 * mIndex);
            mLastAudibleIndex = getValidIndex(10 * mLastAudibleIndex);
            setStreamVolumeIndex(streamType, mIndex);
            mDeathHandlers = new ArrayList<VolumeDeathHandler>();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "DFC5B62EAFEA13265C7203A57400333D", hash_generated_method = "D9BE4BFB27889DD2035104DEF8E7AA52")
        @DSModeled(DSC.SAFE)
        public void setVolumeIndexSettingName(String settingName) {
            dsTaint.addTaint(settingName);
            mLastAudibleVolumeIndexSettingName = settingName + System.APPEND_FOR_LAST_AUDIBLE;
            // ---------- Original Method ----------
            //mVolumeIndexSettingName = settingName;
            //mLastAudibleVolumeIndexSettingName = settingName + System.APPEND_FOR_LAST_AUDIBLE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "44C5F23F7D49C978B9C75B9C354D7F6D", hash_generated_method = "F516391EC5E9ACC2334ADD55C69229C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean adjustIndex(int deltaIndex) {
            dsTaint.addTaint(deltaIndex);
            boolean varC7A1B23D9C4C229941DA230553073144_1597043273 = (setIndex(mIndex + deltaIndex * 10, true));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return setIndex(mIndex + deltaIndex * 10, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "0E7AE9FE64EF47B631D9F83FB9301730", hash_generated_method = "66EE5581487827F61E12AA718B60F4C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean setIndex(int index, boolean lastAudible) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(lastAudible);
            int oldIndex;
            oldIndex = mIndex;
            mIndex = getValidIndex(index);
            {
                {
                    mLastAudibleIndex = mIndex;
                } //End block
                int numStreamTypes;
                numStreamTypes = AudioSystem.getNumStreamTypes();
                {
                    int streamType;
                    streamType = numStreamTypes - 1;
                    {
                        {
                            mStreamStates[streamType].setIndex(rescaleIndex(mIndex, mStreamType, streamType), lastAudible);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //int oldIndex = mIndex;
            //mIndex = getValidIndex(index);
            //if (oldIndex != mIndex) {
                //if (lastAudible) {
                    //mLastAudibleIndex = mIndex;
                //}
                //int numStreamTypes = AudioSystem.getNumStreamTypes();
                //for (int streamType = numStreamTypes - 1; streamType >= 0; streamType--) {
                    //if (streamType != mStreamType && STREAM_VOLUME_ALIAS[streamType] == mStreamType) {
                        //mStreamStates[streamType].setIndex(rescaleIndex(mIndex, mStreamType, streamType), lastAudible);
                    //}
                //}
                //return true;
            //} else {
                //return false;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "7A636700416D4B3345590527EDD59D22", hash_generated_method = "09AD1E4B8A77233E3425E2178A0D6588")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setLastAudibleIndex(int index) {
            dsTaint.addTaint(index);
            mLastAudibleIndex = getValidIndex(index);
            // ---------- Original Method ----------
            //mLastAudibleIndex = getValidIndex(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.900 -0400", hash_original_method = "124D752F57F14768C9083B803E52554B", hash_generated_method = "477F93B6D55F150373D540D76D7B35EE")
        @DSModeled(DSC.SAFE)
        public void adjustLastAudibleIndex(int deltaIndex) {
            dsTaint.addTaint(deltaIndex);
            setLastAudibleIndex(mLastAudibleIndex + deltaIndex * 10);
            // ---------- Original Method ----------
            //setLastAudibleIndex(mLastAudibleIndex + deltaIndex * 10);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "FE1986BC5B1AEFABC058BFB7A5FA757B", hash_generated_method = "CA2D981267497E73AEFF50B1A107E0A8")
        @DSModeled(DSC.SAFE)
        public int getMaxIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mIndexMax;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "BC317E1907132EC00253288D4BA05394", hash_generated_method = "73EE5502E0956680BCC56AC798692BC2")
        @DSModeled(DSC.SAFE)
        public void mute(IBinder cb, boolean state) {
            dsTaint.addTaint(cb.dsTaint);
            dsTaint.addTaint(state);
            VolumeDeathHandler handler;
            handler = getDeathHandler(cb, state);
            handler.mute(state);
            // ---------- Original Method ----------
            //VolumeDeathHandler handler = getDeathHandler(cb, state);
            //if (handler == null) {
                //Log.e(TAG, "Could not get client death handler for stream: "+mStreamType);
                //return;
            //}
            //handler.mute(state);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "CA94816FCB17D284B4B8A3C843F495E9", hash_generated_method = "E57DC1D0837E040A8464D077AB81DCEC")
        @DSModeled(DSC.SAFE)
        private int getValidIndex(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (index < 0) {
                //return 0;
            //} else if (index > mIndexMax) {
                //return mIndexMax;
            //}
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "ED28FB8F430F19215CFB054F6B0CEE9C", hash_generated_method = "BFB329109D9BA5C684DFEA6BD9A0E1E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int muteCount() {
            int count;
            count = 0;
            int size;
            size = mDeathHandlers.size();
            {
                int i;
                i = 0;
                {
                    count += mDeathHandlers.get(i).mMuteCount;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int count = 0;
            //int size = mDeathHandlers.size();
            //for (int i = 0; i < size; i++) {
                //count += mDeathHandlers.get(i).mMuteCount;
            //}
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "08DCDDD857521B6C13854C2B2DCDB3CC", hash_generated_method = "44B7D4F76AB80DE505D8B59621B33F0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private VolumeDeathHandler getDeathHandler(IBinder cb, boolean state) {
            dsTaint.addTaint(cb.dsTaint);
            dsTaint.addTaint(state);
            {
                VolumeDeathHandler handler;
                int size;
                size = mDeathHandlers.size();
                {
                    int i;
                    i = 0;
                    {
                        handler = mDeathHandlers.get(i);
                    } //End block
                } //End collapsed parenthetic
                {
                    handler = new VolumeDeathHandler(cb);
                } //End block
                {
                    handler = null;
                } //End block
            } //End block
            return (VolumeDeathHandler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized(mDeathHandlers) {
                //VolumeDeathHandler handler;
                //int size = mDeathHandlers.size();
                //for (int i = 0; i < size; i++) {
                    //handler = mDeathHandlers.get(i);
                    //if (cb == handler.mICallback) {
                        //return handler;
                    //}
                //}
                //if (state) {
                    //handler = new VolumeDeathHandler(cb);
                //} else {
                    //Log.w(TAG, "stream was not muted by this client");
                    //handler = null;
                //}
                //return handler;
            //}
        }

        
        private class VolumeDeathHandler implements IBinder.DeathRecipient {
            private IBinder mICallback;
            private int mMuteCount;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.901 -0400", hash_original_method = "8E2A4C1685C16EB0D2A79A75EDA4183A", hash_generated_method = "A824A940CC961FC6A5404681EE041B03")
            @DSModeled(DSC.SAFE)
             VolumeDeathHandler(IBinder cb) {
                dsTaint.addTaint(cb.dsTaint);
                // ---------- Original Method ----------
                //mICallback = cb;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.902 -0400", hash_original_method = "E16E7F260CC1254CC33DE4821403A754", hash_generated_method = "C8486CC2D9826341BB66F210C1E2CA91")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void mute(boolean state) {
                dsTaint.addTaint(state);
                {
                    {
                        {
                            try 
                            {
                                {
                                    mICallback.linkToDeath(this, 0);
                                } //End block
                                mDeathHandlers.add(this);
                                {
                                    boolean var48795525AD50A62DC2386C25907AF4FA_596034624 = (muteCount() == 0);
                                    {
                                        setIndex(0, false);
                                        sendMsg(mAudioHandler, MSG_SET_SYSTEM_VOLUME, mStreamType, SENDMSG_NOOP, 0, 0,
                                            VolumeStreamState.this, 0);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            catch (RemoteException e)
                            {
                                binderDied();
                                mDeathHandlers.notify();
                            } //End block
                        } //End block
                        mMuteCount++;
                    } //End block
                    {
                        {
                            mMuteCount--;
                            {
                                mDeathHandlers.remove(this);
                                {
                                    mICallback.unlinkToDeath(this, 0);
                                } //End block
                                {
                                    boolean var48795525AD50A62DC2386C25907AF4FA_2069612833 = (muteCount() == 0);
                                    {
                                        {
                                            boolean var43B4BBA543DDBD592C477802F22AC440_2119895119 = (!isStreamAffectedByRingerMode(mStreamType) || mRingerMode == AudioManager.RINGER_MODE_NORMAL);
                                            {
                                                setIndex(mLastAudibleIndex, false);
                                                sendMsg(mAudioHandler, MSG_SET_SYSTEM_VOLUME, mStreamType, SENDMSG_NOOP, 0, 0,
                                                VolumeStreamState.this, 0);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End block
                    mDeathHandlers.notify();
                } //End block
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.902 -0400", hash_original_method = "939D0F12FA89B47BF77B849D2BAD3C80", hash_generated_method = "CC9D9942548A6D8795D762CDAEE9C13E")
            @DSModeled(DSC.SAFE)
            public void binderDied() {
                {
                    mMuteCount = 1;
                    mute(false);
                } //End block
                // ---------- Original Method ----------
                //Log.w(TAG, "Volume service client died for stream: "+mStreamType);
                //if (mMuteCount != 0) {
                    //mMuteCount = 1;
                    //mute(false);
                //}
            }

            
        }


        
    }


    
    private class AudioSystemThread extends Thread {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.902 -0400", hash_original_method = "884E5228236C4174339C3169303139DE", hash_generated_method = "E6B70BF84626F8FC39DE5368D903A889")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AudioSystemThread() {
            super("AudioService");
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.902 -0400", hash_original_method = "9987955C7104D620D02F7190CDD1A5A4", hash_generated_method = "B46431B8874EA4BAD979FFDF69A81A73")
        @DSModeled(DSC.SAFE)
        @Override
        public void run() {
            Looper.prepare();
            {
                mAudioHandler = new AudioHandler();
                AudioService.this.notify();
            } //End block
            Looper.loop();
            // ---------- Original Method ----------
            //Looper.prepare();
            //synchronized(AudioService.this) {
                //mAudioHandler = new AudioHandler();
                //AudioService.this.notify();
            //}
            //Looper.loop();
        }

        
    }


    
    private class AudioHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.902 -0400", hash_original_method = "1C77E2D23440E5B85069A5684B58B44F", hash_generated_method = "41657AF76A89692788A8EF6044AB3A19")
        @DSModeled(DSC.SAFE)
        private void setSystemVolume(VolumeStreamState streamState) {
            dsTaint.addTaint(streamState.dsTaint);
            setStreamVolumeIndex(streamState.mStreamType, streamState.mIndex);
            int numStreamTypes;
            numStreamTypes = AudioSystem.getNumStreamTypes();
            {
                int streamType;
                streamType = numStreamTypes - 1;
                {
                    {
                        setStreamVolumeIndex(streamType, mStreamStates[streamType].mIndex);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            sendMsg(mAudioHandler, MSG_PERSIST_VOLUME, streamState.mStreamType,
                    SENDMSG_REPLACE, 1, 1, streamState, PERSIST_DELAY);
            // ---------- Original Method ----------
            //setStreamVolumeIndex(streamState.mStreamType, streamState.mIndex);
            //int numStreamTypes = AudioSystem.getNumStreamTypes();
            //for (int streamType = numStreamTypes - 1; streamType >= 0; streamType--) {
                //if (streamType != streamState.mStreamType &&
                    //STREAM_VOLUME_ALIAS[streamType] == streamState.mStreamType) {
                    //setStreamVolumeIndex(streamType, mStreamStates[streamType].mIndex);
                //}
            //}
            //sendMsg(mAudioHandler, MSG_PERSIST_VOLUME, streamState.mStreamType,
                    //SENDMSG_REPLACE, 1, 1, streamState, PERSIST_DELAY);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.903 -0400", hash_original_method = "174B78EED78885FD6CBB55617F4D934C", hash_generated_method = "049FE7213F5DE66F4BC11562ED485880")
        @DSModeled(DSC.SAFE)
        private void persistVolume(VolumeStreamState streamState, boolean current, boolean lastAudible) {
            dsTaint.addTaint(current);
            dsTaint.addTaint(lastAudible);
            dsTaint.addTaint(streamState.dsTaint);
            {
                System.putInt(mContentResolver, streamState.mVolumeIndexSettingName,
                              (streamState.mIndex + 5)/ 10);
            } //End block
            {
                System.putInt(mContentResolver, streamState.mLastAudibleVolumeIndexSettingName,
                    (streamState.mLastAudibleIndex + 5) / 10);
            } //End block
            // ---------- Original Method ----------
            //if (current) {
                //System.putInt(mContentResolver, streamState.mVolumeIndexSettingName,
                              //(streamState.mIndex + 5)/ 10);
            //}
            //if (lastAudible) {
                //System.putInt(mContentResolver, streamState.mLastAudibleVolumeIndexSettingName,
                    //(streamState.mLastAudibleIndex + 5) / 10);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.903 -0400", hash_original_method = "EA74161405D16A488BB1693550F7C3DA", hash_generated_method = "2D9EE685FFBCE1B2AA78C269D63E7909")
        @DSModeled(DSC.SAFE)
        private void persistRingerMode() {
            System.putInt(mContentResolver, System.MODE_RINGER, mRingerMode);
            // ---------- Original Method ----------
            //System.putInt(mContentResolver, System.MODE_RINGER, mRingerMode);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.903 -0400", hash_original_method = "2BE9A369BD0106620186850BEBF93A78", hash_generated_method = "F4067560306ADCF6882D86159F000101")
        @DSModeled(DSC.SAFE)
        private void persistVibrateSetting() {
            System.putInt(mContentResolver, System.VIBRATE_ON, mVibrateSetting);
            // ---------- Original Method ----------
            //System.putInt(mContentResolver, System.VIBRATE_ON, mVibrateSetting);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.903 -0400", hash_original_method = "2AEDEDE40129C77AC25A4490AAE797B9", hash_generated_method = "96812A2D62C38FEA2E4FC060027B8055")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void playSoundEffect(int effectType, int volume) {
            dsTaint.addTaint(volume);
            dsTaint.addTaint(effectType);
            {
                float volFloat;
                {
                    volFloat = (float)Math.pow(10, SOUND_EFFECT_VOLUME_DB/20);
                } //End block
                {
                    volFloat = (float) volume / 1000.0f;
                } //End block
                {
                    mSoundPool.play(SOUND_EFFECT_FILES_MAP[effectType][1], volFloat, volFloat, 0, 0, 1.0f);
                } //End block
                {
                    MediaPlayer mediaPlayer;
                    mediaPlayer = new MediaPlayer();
                    {
                        try 
                        {
                            String filePath;
                            filePath = Environment.getRootDirectory() + SOUND_EFFECTS_PATH + SOUND_EFFECT_FILES[SOUND_EFFECT_FILES_MAP[effectType][0]];
                            mediaPlayer.setDataSource(filePath);
                            mediaPlayer.setAudioStreamType(AudioSystem.STREAM_SYSTEM);
                            mediaPlayer.prepare();
                            mediaPlayer.setVolume(volFloat, volFloat);
                            mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                                public void onCompletion(MediaPlayer mp) {
                                    cleanupPlayer(mp);
                                }
                            });
                            mediaPlayer.setOnErrorListener(new OnErrorListener() {
                                public boolean onError(MediaPlayer mp, int what, int extra) {
                                    cleanupPlayer(mp);
                                    return true;
                                }
                            });
                            mediaPlayer.start();
                        } //End block
                        catch (IOException ex)
                        { }
                        catch (IllegalArgumentException ex)
                        { }
                        catch (IllegalStateException ex)
                        { }
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.903 -0400", hash_original_method = "912C65902EE0D6F52225E667A91304C3", hash_generated_method = "FE686923ACB16AB83D17E5515493F9E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void onHandlePersistMediaButtonReceiver(ComponentName receiver) {
            dsTaint.addTaint(receiver.dsTaint);
            Settings.System.putString(mContentResolver, Settings.System.MEDIA_BUTTON_RECEIVER,
                    receiver == null ? "" : receiver.flattenToString());
            // ---------- Original Method ----------
            //Settings.System.putString(mContentResolver, Settings.System.MEDIA_BUTTON_RECEIVER,
                    //receiver == null ? "" : receiver.flattenToString());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.904 -0400", hash_original_method = "3EB2AE7D674FFD4F0B30CE591B3A29F7", hash_generated_method = "4C61DDEEEEAC65D3632DA0F335D88379")
        @DSModeled(DSC.SAFE)
        private void cleanupPlayer(MediaPlayer mp) {
            dsTaint.addTaint(mp.dsTaint);
            {
                try 
                {
                    mp.stop();
                    mp.release();
                } //End block
                catch (IllegalStateException ex)
                { }
            } //End block
            // ---------- Original Method ----------
            //if (mp != null) {
                //try {
                    //mp.stop();
                    //mp.release();
                //} catch (IllegalStateException ex) {
                    //Log.w(TAG, "MediaPlayer IllegalStateException: "+ex);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.904 -0400", hash_original_method = "6499BC06F6506FB984151A957C432178", hash_generated_method = "ADCAA66E01F1B8E29F5A1F25FFCE3CDF")
        @DSModeled(DSC.SAFE)
        private void setForceUse(int usage, int config) {
            dsTaint.addTaint(usage);
            dsTaint.addTaint(config);
            AudioSystem.setForceUse(usage, config);
            // ---------- Original Method ----------
            //AudioSystem.setForceUse(usage, config);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.904 -0400", hash_original_method = "F55036B009534BD65AC9C95004F24158", hash_generated_method = "FF7FD59444164847EEFF80FF2E92E38A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            int baseMsgWhat;
            baseMsgWhat = getMsgBase(msg.what);
            //Begin case MSG_SET_SYSTEM_VOLUME 
            setSystemVolume((VolumeStreamState) msg.obj);
            //End case MSG_SET_SYSTEM_VOLUME 
            //Begin case MSG_PERSIST_VOLUME 
            persistVolume((VolumeStreamState) msg.obj, (msg.arg1 != 0), (msg.arg2 != 0));
            //End case MSG_PERSIST_VOLUME 
            //Begin case MSG_PERSIST_RINGER_MODE 
            persistRingerMode();
            //End case MSG_PERSIST_RINGER_MODE 
            //Begin case MSG_PERSIST_VIBRATE_SETTING 
            persistVibrateSetting();
            //End case MSG_PERSIST_VIBRATE_SETTING 
            //Begin case MSG_MEDIA_SERVER_DIED 
            {
                AudioSystem.setErrorCallback(mAudioSystemCallback);
                sendMsg(mAudioHandler, MSG_MEDIA_SERVER_DIED, SHARED_MSG, SENDMSG_NOOP, 0, 0,
                                null, 500);
            } //End block
            //End case MSG_MEDIA_SERVER_DIED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            AudioSystem.setParameters("restarting=true");
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            {
                Set set;
                set = mConnectedDevices.entrySet();
                Iterator i;
                i = set.iterator();
                {
                    boolean var048C390D087BEDAABDA4F669A9DA628E_464011681 = (i.hasNext());
                    {
                        Map.Entry device;
                        device = (Map.Entry)i.next();
                        AudioSystem.setDeviceConnectionState(
                                                            ((Integer)device.getKey()).intValue(),
                                                            AudioSystem.DEVICE_STATE_AVAILABLE,
                                                            (String)device.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            AudioSystem.setPhoneState(mMode);
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            AudioSystem.setForceUse(AudioSystem.FOR_COMMUNICATION, mForcedUseForComm);
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            AudioSystem.setForceUse(AudioSystem.FOR_RECORD, mForcedUseForComm);
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            int numStreamTypes;
            numStreamTypes = AudioSystem.getNumStreamTypes();
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            {
                int streamType;
                streamType = numStreamTypes - 1;
                {
                    int index;
                    VolumeStreamState streamState;
                    streamState = mStreamStates[streamType];
                    AudioSystem.initStreamVolume(streamType, 0, (streamState.mIndexMax + 5) / 10);
                    {
                        boolean var0CBDDCD769D385E75A4C70015B2328D3_764137355 = (streamState.muteCount() == 0);
                        {
                            index = streamState.mIndex;
                        } //End block
                        {
                            index = 0;
                        } //End block
                    } //End collapsed parenthetic
                    setStreamVolumeIndex(streamType, index);
                } //End block
            } //End collapsed parenthetic
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            setRingerModeInt(getRingerMode(), false);
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_MEDIA_SERVER_STARTED 
            AudioSystem.setParameters("restarting=false");
            //End case MSG_MEDIA_SERVER_STARTED 
            //Begin case MSG_LOAD_SOUND_EFFECTS 
            loadSoundEffects();
            //End case MSG_LOAD_SOUND_EFFECTS 
            //Begin case MSG_PLAY_SOUND_EFFECT 
            playSoundEffect(msg.arg1, msg.arg2);
            //End case MSG_PLAY_SOUND_EFFECT 
            //Begin case MSG_BTA2DP_DOCK_TIMEOUT 
            {
                makeA2dpDeviceUnavailableNow( (String) msg.obj );
            } //End block
            //End case MSG_BTA2DP_DOCK_TIMEOUT 
            //Begin case MSG_SET_FORCE_USE 
            setForceUse(msg.arg1, msg.arg2);
            //End case MSG_SET_FORCE_USE 
            //Begin case MSG_PERSIST_MEDIABUTTONRECEIVER 
            onHandlePersistMediaButtonReceiver( (ComponentName) msg.obj );
            //End case MSG_PERSIST_MEDIABUTTONRECEIVER 
            //Begin case MSG_RCDISPLAY_CLEAR 
            onRcDisplayClear();
            //End case MSG_RCDISPLAY_CLEAR 
            //Begin case MSG_RCDISPLAY_UPDATE 
            onRcDisplayUpdate( (RemoteControlStackEntry) msg.obj, msg.arg1);
            //End case MSG_RCDISPLAY_UPDATE 
            //Begin case MSG_BT_HEADSET_CNCT_FAILED 
            resetBluetoothSco();
            //End case MSG_BT_HEADSET_CNCT_FAILED 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class SettingsObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.905 -0400", hash_original_method = "35D652B20DAAE7466CBE0326FE0F1C91", hash_generated_method = "B19D6C20E39E3F06E8D5D2957897F405")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SettingsObserver() {
            super(new Handler());
            mContentResolver.registerContentObserver(Settings.System.getUriFor(
                Settings.System.MODE_RINGER_STREAMS_AFFECTED), false, this);
            // ---------- Original Method ----------
            //mContentResolver.registerContentObserver(Settings.System.getUriFor(
                //Settings.System.MODE_RINGER_STREAMS_AFFECTED), false, this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.905 -0400", hash_original_method = "73BCC2076377A11CCC1BCC9D6EF2CE0D", hash_generated_method = "B3DB2CDD57B19EC87BF32A0176DAD7BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            super.onChange(selfChange);
            {
                int ringerModeAffectedStreams;
                ringerModeAffectedStreams = Settings.System.getInt(mContentResolver,
                       Settings.System.MODE_RINGER_STREAMS_AFFECTED,
                       ((1 << AudioSystem.STREAM_RING)|(1 << AudioSystem.STREAM_NOTIFICATION)|
                       (1 << AudioSystem.STREAM_SYSTEM)|(1 << AudioSystem.STREAM_SYSTEM_ENFORCED)));
                {
                    ringerModeAffectedStreams &= ~(1 << AudioSystem.STREAM_MUSIC);
                } //End block
                {
                    ringerModeAffectedStreams |= (1 << AudioSystem.STREAM_MUSIC);
                } //End block
                {
                    mRingerModeAffectedStreams = ringerModeAffectedStreams;
                    setRingerModeInt(getRingerMode(), false);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class AudioServiceBroadcastReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.908 -0400", hash_original_method = "4C2E4E6D87414FFD7087C51B534E9532", hash_generated_method = "0D5C9AD5A972FC9B94F76F06E9D4798F")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            {
                boolean var5996E1074DBB1E1F680E65F09D51B5C9_1285372451 = (action.equals(Intent.ACTION_DOCK_EVENT));
                {
                    int dockState;
                    dockState = intent.getIntExtra(Intent.EXTRA_DOCK_STATE,
                        Intent.EXTRA_DOCK_STATE_UNDOCKED);
                    int config;
                    //Begin case Intent.EXTRA_DOCK_STATE_DESK 
                    config = AudioSystem.FORCE_BT_DESK_DOCK;
                    //End case Intent.EXTRA_DOCK_STATE_DESK 
                    //Begin case Intent.EXTRA_DOCK_STATE_CAR 
                    config = AudioSystem.FORCE_BT_CAR_DOCK;
                    //End case Intent.EXTRA_DOCK_STATE_CAR 
                    //Begin case Intent.EXTRA_DOCK_STATE_LE_DESK 
                    config = AudioSystem.FORCE_ANALOG_DOCK;
                    //End case Intent.EXTRA_DOCK_STATE_LE_DESK 
                    //Begin case Intent.EXTRA_DOCK_STATE_HE_DESK 
                    config = AudioSystem.FORCE_DIGITAL_DOCK;
                    //End case Intent.EXTRA_DOCK_STATE_HE_DESK 
                    //Begin case Intent.EXTRA_DOCK_STATE_UNDOCKED default 
                    config = AudioSystem.FORCE_NONE;
                    //End case Intent.EXTRA_DOCK_STATE_UNDOCKED default 
                    AudioSystem.setForceUse(AudioSystem.FOR_DOCK, config);
                } //End block
                {
                    boolean var073D69B7C02A3662073C57E38D25E7A9_600912152 = (action.equals(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED));
                    {
                        int state;
                        state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE,
                                               BluetoothProfile.STATE_DISCONNECTED);
                        BluetoothDevice btDevice;
                        btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        handleA2dpConnectionStateChange(btDevice, state);
                    } //End block
                    {
                        boolean varC238EF266D8AEAC33C35601CEE2CC6BB_60352267 = (action.equals(BluetoothHeadset.ACTION_CONNECTION_STATE_CHANGED));
                        {
                            int state;
                            state = intent.getIntExtra(BluetoothProfile.EXTRA_STATE,
                                               BluetoothProfile.STATE_DISCONNECTED);
                            int device;
                            device = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO;
                            String address;
                            address = null;
                            BluetoothDevice btDevice;
                            btDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                            address = btDevice.getAddress();
                            BluetoothClass btClass;
                            btClass = btDevice.getBluetoothClass();
                            {
                                {
                                    Object var90DA9AD92E90E1DC7A85AB6D84217460_1393545802 = (btClass.getDeviceClass());
                                    //Begin case BluetoothClass.Device.AUDIO_VIDEO_WEARABLE_HEADSET BluetoothClass.Device.AUDIO_VIDEO_HANDSFREE 
                                    device = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_HEADSET;
                                    //End case BluetoothClass.Device.AUDIO_VIDEO_WEARABLE_HEADSET BluetoothClass.Device.AUDIO_VIDEO_HANDSFREE 
                                    //Begin case BluetoothClass.Device.AUDIO_VIDEO_CAR_AUDIO 
                                    device = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_CARKIT;
                                    //End case BluetoothClass.Device.AUDIO_VIDEO_CAR_AUDIO 
                                } //End collapsed parenthetic
                            } //End block
                            {
                                boolean var3E8ED2BA5033A012F22ECB6276795AFF_251199804 = (!BluetoothAdapter.checkBluetoothAddress(address));
                                {
                                    address = "";
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean isConnected;
                                isConnected = (mConnectedDevices.containsKey(device) &&
                                           mConnectedDevices.get(device).equals(address));
                                {
                                    {
                                        AudioSystem.setDeviceConnectionState(device,
                                                             AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                                             address);
                                        mConnectedDevices.remove(device);
                                        mBluetoothHeadsetDevice = null;
                                        resetBluetoothSco();
                                    } //End block
                                    {
                                        AudioSystem.setDeviceConnectionState(device,
                                                                 AudioSystem.DEVICE_STATE_AVAILABLE,
                                                                 address);
                                        mConnectedDevices.put(new Integer(device), address);
                                        mBluetoothHeadsetDevice = btDevice;
                                    } //End block
                                } //End block
                            } //End block
                        } //End block
                        {
                            boolean var29AF8FAA6D24E760BB24F52365B3492D_2137906429 = (action.equals(Intent.ACTION_HEADSET_PLUG));
                            {
                                int state;
                                state = intent.getIntExtra("state", 0);
                                int microphone;
                                microphone = intent.getIntExtra("microphone", 0);
                                {
                                    {
                                        boolean isConnected;
                                        isConnected = mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_WIRED_HEADSET);
                                        {
                                            AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_WIRED_HEADSET,
                                    AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                    "");
                                            mConnectedDevices.remove(AudioSystem.DEVICE_OUT_WIRED_HEADSET);
                                        } //End block
                                        {
                                            AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_WIRED_HEADSET,
                                    AudioSystem.DEVICE_STATE_AVAILABLE,
                                    "");
                                            mConnectedDevices.put(
                                    new Integer(AudioSystem.DEVICE_OUT_WIRED_HEADSET), "");
                                        } //End block
                                    } //End block
                                    {
                                        boolean isConnected;
                                        isConnected = mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_WIRED_HEADPHONE);
                                        {
                                            AudioSystem.setDeviceConnectionState(
                                    AudioSystem.DEVICE_OUT_WIRED_HEADPHONE,
                                    AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                    "");
                                            mConnectedDevices.remove(AudioSystem.DEVICE_OUT_WIRED_HEADPHONE);
                                        } //End block
                                        {
                                            AudioSystem.setDeviceConnectionState(
                                    AudioSystem.DEVICE_OUT_WIRED_HEADPHONE,
                                    AudioSystem.DEVICE_STATE_AVAILABLE,
                                    "");
                                            mConnectedDevices.put(
                                    new Integer(AudioSystem.DEVICE_OUT_WIRED_HEADPHONE), "");
                                        } //End block
                                    } //End block
                                } //End block
                            } //End block
                            {
                                boolean var94698E1E7453DBD54AC3C88C60006E89_1412823563 = (action.equals(Intent.ACTION_USB_ANLG_HEADSET_PLUG));
                                {
                                    int state;
                                    state = intent.getIntExtra("state", 0);
                                    {
                                        boolean isConnected;
                                        isConnected = mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET);
                                        {
                                            AudioSystem.setDeviceConnectionState(
                                                        AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET,
                                                        AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                                        "");
                                            mConnectedDevices.remove(AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET);
                                        } //End block
                                        {
                                            AudioSystem.setDeviceConnectionState(
                                                        AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET,
                                                        AudioSystem.DEVICE_STATE_AVAILABLE,
                                                        "");
                                            mConnectedDevices.put(
                                new Integer(AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET), "");
                                        } //End block
                                    } //End block
                                } //End block
                                {
                                    boolean var72B4472178F4A14C9A245533A87B2128_474357859 = (action.equals(Intent.ACTION_HDMI_AUDIO_PLUG));
                                    {
                                        int state;
                                        state = intent.getIntExtra("state", 0);
                                        {
                                            boolean isConnected;
                                            isConnected = mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_AUX_DIGITAL);
                                            {
                                                AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_AUX_DIGITAL,
                                                             AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                                             "");
                                                mConnectedDevices.remove(AudioSystem.DEVICE_OUT_AUX_DIGITAL);
                                            } //End block
                                            {
                                                AudioSystem.setDeviceConnectionState(AudioSystem.DEVICE_OUT_AUX_DIGITAL,
                                                             AudioSystem.DEVICE_STATE_AVAILABLE,
                                                             "");
                                                mConnectedDevices.put( new Integer(AudioSystem.DEVICE_OUT_AUX_DIGITAL), "");
                                            } //End block
                                        } //End block
                                    } //End block
                                    {
                                        boolean varF14FAC54014C6E15F81435CBE5F8CDEC_67709505 = (action.equals(Intent.ACTION_USB_DGTL_HEADSET_PLUG));
                                        {
                                            int state;
                                            state = intent.getIntExtra("state", 0);
                                            {
                                                boolean isConnected;
                                                isConnected = mConnectedDevices.containsKey(AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET);
                                                {
                                                    AudioSystem.setDeviceConnectionState(
                                                         AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET,
                                                         AudioSystem.DEVICE_STATE_UNAVAILABLE,
                                                         "");
                                                    mConnectedDevices.remove(AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET);
                                                } //End block
                                                {
                                                    AudioSystem.setDeviceConnectionState(
                                                         AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET,
                                                         AudioSystem.DEVICE_STATE_AVAILABLE,
                                                         "");
                                                    mConnectedDevices.put(
                                new Integer(AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET), "");
                                                } //End block
                                            } //End block
                                        } //End block
                                        {
                                            boolean varF48D839612EDA0769DC8E02782913268_109618182 = (action.equals(BluetoothHeadset.ACTION_AUDIO_STATE_CHANGED));
                                            {
                                                boolean broadcast;
                                                broadcast = false;
                                                int state;
                                                state = AudioManager.SCO_AUDIO_STATE_ERROR;
                                                {
                                                    int btState;
                                                    btState = intent.getIntExtra(BluetoothProfile.EXTRA_STATE, -1);
                                                    {
                                                        boolean var41B3136A973E03D27C2266642D4410A0_429954572 = (!mScoClients.isEmpty() &&
                            (mScoAudioState == SCO_STATE_ACTIVE_INTERNAL ||
                             mScoAudioState == SCO_STATE_ACTIVATE_REQ ||
                             mScoAudioState == SCO_STATE_DEACTIVATE_REQ));
                                                        {
                                                            broadcast = true;
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_CONNECTED 
                                                    state = AudioManager.SCO_AUDIO_STATE_CONNECTED;
                                                    //End case BluetoothHeadset.STATE_AUDIO_CONNECTED 
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_CONNECTED 
                                                    {
                                                        mScoAudioState = SCO_STATE_ACTIVE_EXTERNAL;
                                                    } //End block
                                                    //End case BluetoothHeadset.STATE_AUDIO_CONNECTED 
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    state = AudioManager.SCO_AUDIO_STATE_DISCONNECTED;
                                                    //End case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    mScoAudioState = SCO_STATE_INACTIVE;
                                                    //End case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    clearAllScoClients(0, false);
                                                    //End case BluetoothHeadset.STATE_AUDIO_DISCONNECTED 
                                                    //Begin case BluetoothHeadset.STATE_AUDIO_CONNECTING 
                                                    {
                                                        mScoAudioState = SCO_STATE_ACTIVE_EXTERNAL;
                                                    } //End block
                                                    //End case BluetoothHeadset.STATE_AUDIO_CONNECTING 
                                                    //Begin case default 
                                                    broadcast = false;
                                                    //End case default 
                                                } //End block
                                                {
                                                    broadcastScoConnectionState(state);
                                                    Intent newIntent;
                                                    newIntent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED);
                                                    newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, state);
                                                    mContext.sendStickyBroadcast(newIntent);
                                                } //End block
                                            } //End block
                                            {
                                                boolean var2607BB4B921F5453FB3630EDE011634B_1239628886 = (action.equals(Intent.ACTION_BOOT_COMPLETED));
                                                {
                                                    mBootCompleted = true;
                                                    sendMsg(mAudioHandler, MSG_LOAD_SOUND_EFFECTS, SHARED_MSG, SENDMSG_NOOP,
                        0, 0, null, 0);
                                                    mKeyguardManager =
                        (KeyguardManager) mContext.getSystemService(Context.KEYGUARD_SERVICE);
                                                    mScoConnectionState = AudioManager.SCO_AUDIO_STATE_ERROR;
                                                    resetBluetoothSco();
                                                    getBluetoothHeadset();
                                                    Intent newIntent;
                                                    newIntent = new Intent(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED);
                                                    newIntent.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE,
                        AudioManager.SCO_AUDIO_STATE_DISCONNECTED);
                                                    mContext.sendStickyBroadcast(newIntent);
                                                    BluetoothAdapter adapter;
                                                    adapter = BluetoothAdapter.getDefaultAdapter();
                                                    {
                                                        adapter.getProfileProxy(mContext, mBluetoothProfileServiceListener,
                                            BluetoothProfile.A2DP);
                                                    } //End block
                                                } //End block
                                                {
                                                    boolean varBA84BE8887BC1B56CEC3583EB6FDE48C_53491897 = (action.equals(Intent.ACTION_PACKAGE_REMOVED));
                                                    {
                                                        {
                                                            boolean varC6411CF682CAA7CFD8C943390D76A674_2132176882 = (!intent.getBooleanExtra(Intent.EXTRA_REPLACING, false));
                                                            {
                                                                String packageName;
                                                                packageName = intent.getData().getSchemeSpecificPart();
                                                                {
                                                                    removeMediaButtonReceiverForPackage(packageName);
                                                                } //End block
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End block
                                                    {
                                                        boolean var1050E5481508F5222C3028BF4D64430B_439135926 = (action.equals(Intent.ACTION_SCREEN_ON));
                                                        {
                                                            AudioSystem.setParameters("screen_state=on");
                                                        } //End block
                                                        {
                                                            boolean var84F4952B87A3FFE02E4B19E229B4612F_774590388 = (action.equals(Intent.ACTION_SCREEN_OFF));
                                                            {
                                                                AudioSystem.setParameters("screen_state=off");
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class FocusStackEntry {
        public int mStreamType = -1;
        public IAudioFocusDispatcher mFocusDispatcher = null;
        public IBinder mSourceRef = null;
        public String mClientId;
        public int mFocusChangeType;
        public AudioFocusDeathHandler mHandler;
        public String mPackageName;
        public int mCallingUid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.909 -0400", hash_original_method = "87870776133CFC464A94FD101F4CFC0E", hash_generated_method = "96EB13673E8BFF6723B68F7AE28DFC5F")
        @DSModeled(DSC.SAFE)
        public FocusStackEntry() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.909 -0400", hash_original_method = "1A31B55D1497736F987223A6782B17D5", hash_generated_method = "FD809A4EBA1F7B79833423E28BD1D94C")
        @DSModeled(DSC.SAFE)
        public FocusStackEntry(int streamType, int duration,
                IAudioFocusDispatcher afl, IBinder source, String id, AudioFocusDeathHandler hdlr,
                String pn, int uid) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(uid);
            dsTaint.addTaint(duration);
            dsTaint.addTaint(source.dsTaint);
            dsTaint.addTaint(hdlr.dsTaint);
            dsTaint.addTaint(streamType);
            dsTaint.addTaint(pn);
            dsTaint.addTaint(afl.dsTaint);
            // ---------- Original Method ----------
            //mStreamType = streamType;
            //mFocusDispatcher = afl;
            //mSourceRef = source;
            //mClientId = id;
            //mFocusChangeType = duration;
            //mHandler = hdlr;
            //mPackageName = pn;
            //mCallingUid = uid;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.909 -0400", hash_original_method = "A501D20EE37EEDBC1092BA7EB34B00FF", hash_generated_method = "3354B71723A37479B6D1755177781D83")
        @DSModeled(DSC.SAFE)
        public void unlinkToDeath() {
            try 
            {
                {
                    mSourceRef.unlinkToDeath(mHandler, 0);
                    mHandler = null;
                } //End block
            } //End block
            catch (java.util.NoSuchElementException e)
            { }
            // ---------- Original Method ----------
            //try {
                //if (mSourceRef != null && mHandler != null) {
                    //mSourceRef.unlinkToDeath(mHandler, 0);
                    //mHandler = null;
                //}
            //} catch (java.util.NoSuchElementException e) {
                //Log.e(TAG, "Encountered " + e + " in FocusStackEntry.unlinkToDeath()");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "A455D3F5D1F57B467C33C1BF8B5031E4", hash_generated_method = "1AA337079C195820359698D4B71919AF")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            unlinkToDeath();
            super.finalize();
            // ---------- Original Method ----------
            //unlinkToDeath();
            //super.finalize();
        }

        
    }


    
    private class AudioFocusDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "178D9055ACE052A0791F7A95A9973718", hash_generated_method = "1002F2662DF22E65079C3BB706F0CBB7")
        @DSModeled(DSC.SAFE)
         AudioFocusDeathHandler(IBinder cb) {
            dsTaint.addTaint(cb.dsTaint);
            // ---------- Original Method ----------
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "15AC7DE6D10EC2A782DA8E67D1D449E2", hash_generated_method = "FD6D7E71984CB497DBB24C5B7C5FC4A1")
        @DSModeled(DSC.SAFE)
        public void binderDied() {
            {
                removeFocusStackEntryForClient(mCb);
            } //End block
            // ---------- Original Method ----------
            //synchronized(mAudioFocusLock) {
                //Log.w(TAG, "  AudioFocus   audio focus client died");
                //removeFocusStackEntryForClient(mCb);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "C6836F87D1645C18ED0EAAF0FAE1DA4D", hash_generated_method = "A4EEFC28D5F5D95C7D6AF7F5195D0FC7")
        @DSModeled(DSC.SAFE)
        public IBinder getBinder() {
            return (IBinder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCb;
        }

        
    }


    
    private class MediaButtonBroadcastReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "761EB9DE2C438D03738877848A0DAB92", hash_generated_method = "EC04E01DE5983589FAB96584932A797A")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            String action;
            action = intent.getAction();
            {
                boolean varD89B6EB1A2378892B39B954229D87B3D_2080201806 = (!Intent.ACTION_MEDIA_BUTTON.equals(action));
            } //End collapsed parenthetic
            KeyEvent event;
            event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            {
                {
                    {
                        boolean var99A1165FF8F0DE419901C55333E8C921_2007032793 = (mIsRinging || (getMode() == AudioSystem.MODE_IN_CALL) ||
                            (getMode() == AudioSystem.MODE_IN_COMMUNICATION) ||
                            (getMode() == AudioSystem.MODE_RINGTONE));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var49C116AF9A914320D45446687563512E_1630773975 = (!mRCStack.empty());
                        {
                            Intent targetedIntent;
                            targetedIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
                            Bundle extras;
                            extras = intent.getExtras();
                            {
                                targetedIntent.putExtras(extras);
                                abortBroadcast();
                                try 
                                {
                                    mRCStack.peek().mMediaIntent.send(context, 0, targetedIntent);
                                } //End block
                                catch (CanceledException e)
                                {
                                    e.printStackTrace();
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class RcClientDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        private PendingIntent mMediaIntent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.910 -0400", hash_original_method = "B78563431DC099FEC434B003B081AA01", hash_generated_method = "298A0C143BECFECB3513E526EC911A18")
        @DSModeled(DSC.SAFE)
         RcClientDeathHandler(IBinder cb, PendingIntent pi) {
            dsTaint.addTaint(cb.dsTaint);
            dsTaint.addTaint(pi.dsTaint);
            // ---------- Original Method ----------
            //mCb = cb;
            //mMediaIntent = pi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "DCE4E3C3CD481047236B60FD17E7A7A9", hash_generated_method = "8447154816F716AD4D7D00DD7FE14C16")
        @DSModeled(DSC.SAFE)
        public void binderDied() {
            registerRemoteControlClient(mMediaIntent, null, null);
            // ---------- Original Method ----------
            //Log.w(TAG, "  RemoteControlClient died");
            //registerRemoteControlClient(mMediaIntent, null, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "C6836F87D1645C18ED0EAAF0FAE1DA4D", hash_generated_method = "A4EEFC28D5F5D95C7D6AF7F5195D0FC7")
        @DSModeled(DSC.SAFE)
        public IBinder getBinder() {
            return (IBinder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mCb;
        }

        
    }


    
    private static class RemoteControlStackEntry {
        public PendingIntent mMediaIntent;
        public ComponentName mReceiverComponent;
        public String mCallingPackageName;
        public int mCallingUid;
        public IRemoteControlClient mRcClient;
        public RcClientDeathHandler mRcClientDeathHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "7A08D0256AE9D80DF25EA4958218D6A5", hash_generated_method = "08D26ED4079E7C4C4B3024461DFA3590")
        @DSModeled(DSC.SAFE)
        public RemoteControlStackEntry(PendingIntent mediaIntent, ComponentName eventReceiver) {
            dsTaint.addTaint(eventReceiver.dsTaint);
            dsTaint.addTaint(mediaIntent.dsTaint);
            mCallingUid = -1;
            mRcClient = null;
            // ---------- Original Method ----------
            //mMediaIntent = mediaIntent;
            //mReceiverComponent = eventReceiver;
            //mCallingUid = -1;
            //mRcClient = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "E214621EACC4B91C8699D1A833B19501", hash_generated_method = "380B2A9DB26D9819F26B6E6577AF98D7")
        @DSModeled(DSC.SAFE)
        public void unlinkToRcClientDeath() {
            {
                try 
                {
                    mRcClientDeathHandler.mCb.unlinkToDeath(mRcClientDeathHandler, 0);
                    mRcClientDeathHandler = null;
                } //End block
                catch (java.util.NoSuchElementException e)
                {
                    e.printStackTrace();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if ((mRcClientDeathHandler != null) && (mRcClientDeathHandler.mCb != null)) {
                //try {
                    //mRcClientDeathHandler.mCb.unlinkToDeath(mRcClientDeathHandler, 0);
                    //mRcClientDeathHandler = null;
                //} catch (java.util.NoSuchElementException e) {
                    //Log.e(TAG, "Encountered " + e + " in unlinkToRcClientDeath()");
                    //e.printStackTrace();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "8FE798CFFBBAC1D3D802BDA77531752A", hash_generated_method = "C218C3CE085D87909A07D97E5D588E99")
        @DSModeled(DSC.SAFE)
        @Override
        protected void finalize() throws Throwable {
            unlinkToRcClientDeath();
            super.finalize();
            // ---------- Original Method ----------
            //unlinkToRcClientDeath();
            //super.finalize();
        }

        
    }


    
    private class RcDisplayDeathHandler implements IBinder.DeathRecipient {
        private IBinder mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "A366524A3ED96887E7B3A1F6F53E6D06", hash_generated_method = "46A37A5B77CFF7207806922E3F451506")
        @DSModeled(DSC.SAFE)
        public RcDisplayDeathHandler(IBinder b) {
            dsTaint.addTaint(b.dsTaint);
            // ---------- Original Method ----------
            //if (DEBUG_RC) Log.i(TAG, "new RcDisplayDeathHandler for "+b);
            //mCb = b;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "ABA951E1182077CCCC0036113825CBE9", hash_generated_method = "570B8C9C2C4DA84FFE071B5AE6291AD3")
        @DSModeled(DSC.SAFE)
        public void binderDied() {
            {
                mRcDisplay = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized(mRCStack) {
                //Log.w(TAG, "RemoteControl: display died");
                //mRcDisplay = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:01.911 -0400", hash_original_method = "83D0A52CEE401D74287F06FE3C296C89", hash_generated_method = "E92E432A9A4B90CADE66C52944D42C4B")
        @DSModeled(DSC.SAFE)
        public void unlinkToRcDisplayDeath() {
            try 
            {
                mCb.unlinkToDeath(this, 0);
            } //End block
            catch (java.util.NoSuchElementException e)
            {
                e.printStackTrace();
            } //End block
            // ---------- Original Method ----------
            //if (DEBUG_RC) Log.i(TAG, "unlinkToRcDisplayDeath for "+mCb);
            //try {
                //mCb.unlinkToDeath(this, 0);
            //} catch (java.util.NoSuchElementException e) {
                //Log.e(TAG, "Encountered " + e + " in unlinkToRcDisplayDeath()");
                //e.printStackTrace();
            //}
        }

        
    }


    
}


