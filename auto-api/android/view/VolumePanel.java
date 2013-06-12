package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.R;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioService;
import android.media.AudioSystem;
import android.media.RingtoneManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.Vibrator;
import android.provider.Settings;
import android.provider.Settings.System;
import android.util.Log;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import java.util.HashMap;

public class VolumePanel extends Handler implements OnSeekBarChangeListener, View.OnClickListener {
    private static final String TAG = "VolumePanel";
    private static boolean LOGD = false;
    public static final int PLAY_SOUND_DELAY = 300;
    public static final int VIBRATE_DELAY = 300;
    private static final int VIBRATE_DURATION = 300;
    private static final int BEEP_DURATION = 150;
    private static final int MAX_VOLUME = 100;
    private static final int FREE_DELAY = 10000;
    private static final int TIMEOUT_DELAY = 3000;
    private static final int MSG_VOLUME_CHANGED = 0;
    private static final int MSG_FREE_RESOURCES = 1;
    private static final int MSG_PLAY_SOUND = 2;
    private static final int MSG_STOP_SOUNDS = 3;
    private static final int MSG_VIBRATE = 4;
    private static final int MSG_TIMEOUT = 5;
    private static final int MSG_RINGER_MODE_CHANGED = 6;
    protected Context mContext;
    private AudioManager mAudioManager;
    protected AudioService mAudioService;
    private boolean mRingIsSilent;
    private boolean mShowCombinedVolumes;
    private boolean mVoiceCapable;
    private final Dialog mDialog;
    private final View mView;
    private final ViewGroup mPanel;
    private final ViewGroup mSliderGroup;
    private final View mMoreButton;
    private final View mDivider;
    private int mActiveStreamType = -1;
    private HashMap<Integer,StreamControl> mStreamControls;
    private static final StreamResources[] STREAMS = {
        StreamResources.BluetoothSCOStream,
        StreamResources.RingerStream,
        StreamResources.VoiceStream,
        StreamResources.MediaStream,
        StreamResources.NotificationStream,
        StreamResources.AlarmStream
    };
    private ToneGenerator mToneGenerators[];
    private Vibrator mVibrator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.813 -0400", hash_original_method = "4A5AEF640252D539310848D45D133D8B", hash_generated_method = "6CE0778818717F4812C47A90122EB9A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public VolumePanel(final Context context, AudioService volumeService) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(volumeService.dsTaint);
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        view = mView = inflater.inflate(R.layout.volume_adjust, null);
        mView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                resetTimeout();
                return false;
            }
        });
        mPanel = (ViewGroup) mView.findViewById(R.id.visible_panel);
        mSliderGroup = (ViewGroup) mView.findViewById(R.id.slider_group);
        mMoreButton = (ImageView) mView.findViewById(R.id.expand_button);
        mDivider = (ImageView) mView.findViewById(R.id.expand_button_divider);
        mDialog = new Dialog(context, R.style.Theme_Panel_Volume) {
            public boolean onTouchEvent(MotionEvent event) {
                if (isShowing() && event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    forceTimeout();
                    return true;
                }
                return false;
            }
        };
        mDialog.setTitle("Volume control");
        mDialog.setContentView(mView);
        mDialog.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                mActiveStreamType = -1;
                mAudioManager.forceVolumeControlStream(mActiveStreamType);
            }
        });
        Window window;
        window = mDialog.getWindow();
        window.setGravity(Gravity.TOP);
        LayoutParams lp;
        lp = window.getAttributes();
        lp.token = null;
        lp.y = mContext.getResources().getDimensionPixelOffset(
                com.android.internal.R.dimen.volume_panel_top);
        lp.type = LayoutParams.TYPE_VOLUME_OVERLAY;
        lp.width = LayoutParams.WRAP_CONTENT;
        lp.height = LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.addFlags(LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_NOT_TOUCH_MODAL
                | LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);
        mToneGenerators = new ToneGenerator[AudioSystem.getNumStreamTypes()];
        mVibrator = new Vibrator();
        mVoiceCapable = context.getResources().getBoolean(R.bool.config_voice_capable);
        mShowCombinedVolumes = !mVoiceCapable;
        {
            mMoreButton.setVisibility(View.GONE);
            mDivider.setVisibility(View.GONE);
        } //End block
        {
            mMoreButton.setOnClickListener(this);
        } //End block
        listenToRingerMode();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.813 -0400", hash_original_method = "80B4332481FBFCB6F8E2DB1A91C74690", hash_generated_method = "AAB9B8AD4B28B40DCD51A82A61C7B25A")
    @DSModeled(DSC.SAFE)
    private void listenToRingerMode() {
        final IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(AudioManager.RINGER_MODE_CHANGED_ACTION);
        mContext.registerReceiver(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                final String action = intent.getAction();
                if (AudioManager.RINGER_MODE_CHANGED_ACTION.equals(action)) {
                    removeMessages(MSG_RINGER_MODE_CHANGED);
                    sendMessage(obtainMessage(MSG_RINGER_MODE_CHANGED));
                }
            }
        }, filter);
        // ---------- Original Method ----------
        //final IntentFilter filter = new IntentFilter();
        //filter.addAction(AudioManager.RINGER_MODE_CHANGED_ACTION);
        //mContext.registerReceiver(new BroadcastReceiver() {
            //public void onReceive(Context context, Intent intent) {
                //final String action = intent.getAction();
                //if (AudioManager.RINGER_MODE_CHANGED_ACTION.equals(action)) {
                    //removeMessages(MSG_RINGER_MODE_CHANGED);
                    //sendMessage(obtainMessage(MSG_RINGER_MODE_CHANGED));
                //}
            //}
        //}, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.813 -0400", hash_original_method = "494F3BEC5E3FC4F5DFE3A8E269600BB4", hash_generated_method = "9AB9EF8DC6963D1B769571979679E98A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isMuted(int streamType) {
        dsTaint.addTaint(streamType);
        boolean var6B7BD9365F237A4F5B63C65EA770AFF9_684532703 = (mAudioManager.isStreamMute(streamType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAudioManager.isStreamMute(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.814 -0400", hash_original_method = "3EA3EB23F41675A24E880EEE4E39DDC5", hash_generated_method = "EDFC94E849D350153D718868CC8A5D75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createSliders() {
        LayoutInflater inflater;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mStreamControls = new HashMap<Integer, StreamControl>(STREAMS.length);
        Resources res;
        res = mContext.getResources();
        {
            int i;
            i = 0;
            {
                StreamResources streamRes;
                streamRes = STREAMS[i];
                int streamType;
                streamType = streamRes.streamType;
                {
                    streamRes = StreamResources.RingerStream;
                } //End block
                StreamControl sc;
                sc = new StreamControl();
                sc.streamType = streamType;
                sc.group = (ViewGroup) inflater.inflate(R.layout.volume_adjust_item, null);
                sc.group.setTag(sc);
                sc.icon = (ImageView) sc.group.findViewById(R.id.stream_icon);
                sc.icon.setTag(sc);
                sc.icon.setContentDescription(res.getString(streamRes.descRes));
                sc.iconRes = streamRes.iconRes;
                sc.iconMuteRes = streamRes.iconMuteRes;
                sc.icon.setImageResource(sc.iconRes);
                sc.seekbarView = (SeekBar) sc.group.findViewById(R.id.seekbar);
                int plusOne;
                plusOne = 1;
                plusOne = 0;
                sc.seekbarView.setMax(mAudioManager.getStreamMaxVolume(streamType) + plusOne);
                sc.seekbarView.setOnSeekBarChangeListener(this);
                sc.seekbarView.setTag(sc);
                mStreamControls.put(streamType, sc);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.814 -0400", hash_original_method = "6503001070AD2649DBCC4F70D128BA4E", hash_generated_method = "BE257B8D03A8784CBC9619B95843C780")
    @DSModeled(DSC.SAFE)
    private void reorderSliders(int activeStreamType) {
        dsTaint.addTaint(activeStreamType);
        mSliderGroup.removeAllViews();
        StreamControl active;
        active = mStreamControls.get(activeStreamType);
        {
            mActiveStreamType = -1;
        } //End block
        {
            mSliderGroup.addView(active.group);
            active.group.setVisibility(View.VISIBLE);
            updateSlider(active);
        } //End block
        addOtherVolumes();
        // ---------- Original Method ----------
        //mSliderGroup.removeAllViews();
        //StreamControl active = mStreamControls.get(activeStreamType);
        //if (active == null) {
            //Log.e("VolumePanel", "Missing stream type! - " + activeStreamType);
            //mActiveStreamType = -1;
        //} else {
            //mSliderGroup.addView(active.group);
            //mActiveStreamType = activeStreamType;
            //active.group.setVisibility(View.VISIBLE);
            //updateSlider(active);
        //}
        //addOtherVolumes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.814 -0400", hash_original_method = "00CC8C785FEB904890C9FE41BE98C5A3", hash_generated_method = "49A0508B2BC05C7502D7AE6BA06D7E54")
    @DSModeled(DSC.SAFE)
    private void addOtherVolumes() {
        {
            int i;
            i = 0;
            {
                final int streamType;
                streamType = STREAMS[i].streamType;
                StreamControl sc;
                sc = mStreamControls.get(streamType);
                mSliderGroup.addView(sc.group);
                updateSlider(sc);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mShowCombinedVolumes) return;
        //for (int i = 0; i < STREAMS.length; i++) {
            //final int streamType = STREAMS[i].streamType;
            //if (!STREAMS[i].show || streamType == mActiveStreamType) {
                //continue;
            //}
            //StreamControl sc = mStreamControls.get(streamType);
            //mSliderGroup.addView(sc.group);
            //updateSlider(sc);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.814 -0400", hash_original_method = "99B5E1DB9BCC92DD40B8A5C38777EBBA", hash_generated_method = "B932FA18377A8D957D805548197E5FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSlider(StreamControl sc) {
        dsTaint.addTaint(sc.dsTaint);
        sc.seekbarView.setProgress(mAudioManager.getLastAudibleStreamVolume(sc.streamType));
        final boolean muted;
        muted = isMuted(sc.streamType);
        sc.icon.setImageResource(muted ? sc.iconMuteRes : sc.iconRes);
        {
            boolean var243BF66B9BF4A8CEC8D1599059A35CFE_1855487960 = (sc.streamType == AudioManager.STREAM_RING && muted
                && mAudioManager.shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER));
            {
                sc.icon.setImageResource(R.drawable.ic_audio_ring_notif_vibrate);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //sc.seekbarView.setProgress(mAudioManager.getLastAudibleStreamVolume(sc.streamType));
        //final boolean muted = isMuted(sc.streamType);
        //sc.icon.setImageResource(muted ? sc.iconMuteRes : sc.iconRes);
        //if (sc.streamType == AudioManager.STREAM_RING && muted
                //&& mAudioManager.shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER)) {
            //sc.icon.setImageResource(R.drawable.ic_audio_ring_notif_vibrate);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.814 -0400", hash_original_method = "F77628C641751A75EE2C26D5E581D65C", hash_generated_method = "67B911E5E6BE2EB7DA30F9D67C061229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isExpanded() {
        boolean varF3188D55978545F91BC41CECED8F8F9D_1997537469 = (mMoreButton.getVisibility() != View.VISIBLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mMoreButton.getVisibility() != View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.815 -0400", hash_original_method = "7863106B90E3C9CB78339FE1FB0E27DE", hash_generated_method = "F21FD870E8C62115F0ECD476C9AB97B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void expand() {
        final int count;
        count = mSliderGroup.getChildCount();
        {
            int i;
            i = 0;
            {
                mSliderGroup.getChildAt(i).setVisibility(View.VISIBLE);
            } //End block
        } //End collapsed parenthetic
        mMoreButton.setVisibility(View.INVISIBLE);
        mDivider.setVisibility(View.INVISIBLE);
        // ---------- Original Method ----------
        //final int count = mSliderGroup.getChildCount();
        //for (int i = 0; i < count; i++) {
            //mSliderGroup.getChildAt(i).setVisibility(View.VISIBLE);
        //}
        //mMoreButton.setVisibility(View.INVISIBLE);
        //mDivider.setVisibility(View.INVISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.815 -0400", hash_original_method = "2D20263850EE481595DB4B0B69C9C1DB", hash_generated_method = "A11E67743BB8D704451EF5C09D4D38B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void collapse() {
        mMoreButton.setVisibility(View.VISIBLE);
        mDivider.setVisibility(View.VISIBLE);
        final int count;
        count = mSliderGroup.getChildCount();
        {
            int i;
            i = 1;
            {
                mSliderGroup.getChildAt(i).setVisibility(View.GONE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mMoreButton.setVisibility(View.VISIBLE);
        //mDivider.setVisibility(View.VISIBLE);
        //final int count = mSliderGroup.getChildCount();
        //for (int i = 1; i < count; i++) {
            //mSliderGroup.getChildAt(i).setVisibility(View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.815 -0400", hash_original_method = "1E169D1EA6FBCD5E220E528ED502D575", hash_generated_method = "F3EB12BE33A8511E4419C9811748EF0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateStates() {
        final int count;
        count = mSliderGroup.getChildCount();
        {
            int i;
            i = 0;
            {
                StreamControl sc;
                sc = (StreamControl) mSliderGroup.getChildAt(i).getTag();
                updateSlider(sc);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mSliderGroup.getChildCount();
        //for (int i = 0; i < count; i++) {
            //StreamControl sc = (StreamControl) mSliderGroup.getChildAt(i).getTag();
            //updateSlider(sc);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.815 -0400", hash_original_method = "81CB41456070F5A083253A401A40FA12", hash_generated_method = "2D9AE3F1DF7074157D99AEB1AC5B5D80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void postVolumeChanged(int streamType, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        {
            boolean var0AD30AEF7C3A7A61741D7791D40909B4_840428431 = (hasMessages(MSG_VOLUME_CHANGED));
        } //End collapsed parenthetic
        {
            createSliders();
        } //End block
        removeMessages(MSG_FREE_RESOURCES);
        obtainMessage(MSG_VOLUME_CHANGED, streamType, flags).sendToTarget();
        // ---------- Original Method ----------
        //if (hasMessages(MSG_VOLUME_CHANGED)) return;
        //if (mStreamControls == null) {
            //createSliders();
        //}
        //removeMessages(MSG_FREE_RESOURCES);
        //obtainMessage(MSG_VOLUME_CHANGED, streamType, flags).sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.815 -0400", hash_original_method = "509641D8CCDD74F9B6C12A5855E9034C", hash_generated_method = "72EC72ACEA5AD44A621ADF99CB7A3FFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onVolumeChanged(int streamType, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        Log.d(TAG, "onVolumeChanged(streamType: " + streamType + ", flags: " + flags + ")");
        {
            {
                reorderSliders(streamType);
            } //End block
            onShowVolumeChanged(streamType, flags);
        } //End block
        {
            removeMessages(MSG_PLAY_SOUND);
            sendMessageDelayed(obtainMessage(MSG_PLAY_SOUND, streamType, flags), PLAY_SOUND_DELAY);
        } //End block
        {
            removeMessages(MSG_PLAY_SOUND);
            removeMessages(MSG_VIBRATE);
            onStopSounds();
        } //End block
        removeMessages(MSG_FREE_RESOURCES);
        sendMessageDelayed(obtainMessage(MSG_FREE_RESOURCES), FREE_DELAY);
        resetTimeout();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.816 -0400", hash_original_method = "1FE0E8376B871D58C58B361657F85017", hash_generated_method = "77C07561609FCD5B6ACAA0E82DB43B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onShowVolumeChanged(int streamType, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        int index;
        boolean var91EB7B50560A82937129453E7326CBAF_1617419391 = (mAudioService.isStreamMute(streamType));
        index = mAudioService.getLastAudibleStreamVolume(streamType);
        index = mAudioService.getStreamVolume(streamType);
        mRingIsSilent = false;
        {
            Log.d(TAG, "onShowVolumeChanged(streamType: " + streamType
                    + ", flags: " + flags + "), index: " + index);
        } //End block
        int max;
        max = mAudioService.getStreamMaxVolume(streamType);
        //Begin case AudioManager.STREAM_RING 
        {
            Uri ringuri;
            ringuri = RingtoneManager.getActualDefaultRingtoneUri(
                        mContext, RingtoneManager.TYPE_RINGTONE);
            {
                mRingIsSilent = true;
            } //End block
        } //End block
        //End case AudioManager.STREAM_RING 
        //Begin case AudioManager.STREAM_MUSIC 
        {
            {
                boolean var89CB2F78E81E12AAF267126B4A05F41A_221308375 = ((mAudioManager.getDevicesForStream(AudioManager.STREAM_MUSIC) &
                        (AudioManager.DEVICE_OUT_BLUETOOTH_A2DP |
                        AudioManager.DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES |
                        AudioManager.DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER)) != 0);
                {
                    setMusicIcon(R.drawable.ic_audio_bt, R.drawable.ic_audio_bt_mute);
                } //End block
                {
                    setMusicIcon(R.drawable.ic_audio_vol, R.drawable.ic_audio_vol_mute);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case AudioManager.STREAM_MUSIC 
        //Begin case AudioManager.STREAM_VOICE_CALL 
        {
            index++;
            max++;
        } //End block
        //End case AudioManager.STREAM_VOICE_CALL 
        //Begin case AudioManager.STREAM_NOTIFICATION 
        {
            Uri ringuri;
            ringuri = RingtoneManager.getActualDefaultRingtoneUri(
                        mContext, RingtoneManager.TYPE_NOTIFICATION);
            {
                mRingIsSilent = true;
            } //End block
        } //End block
        //End case AudioManager.STREAM_NOTIFICATION 
        //Begin case AudioManager.STREAM_BLUETOOTH_SCO 
        {
            index++;
            max++;
        } //End block
        //End case AudioManager.STREAM_BLUETOOTH_SCO 
        StreamControl sc;
        sc = mStreamControls.get(streamType);
        {
            {
                boolean varF06B6AC39F89A7ED6D2434140D66CBC3_2044232224 = (sc.seekbarView.getMax() != max);
                {
                    sc.seekbarView.setMax(max);
                } //End block
            } //End collapsed parenthetic
            sc.seekbarView.setProgress(index);
        } //End block
        {
            boolean var82E8D066D5F16B2684A7A5AD4F03D6FD_1348217694 = (!mDialog.isShowing());
            {
                mAudioManager.forceVolumeControlStream(streamType);
                mDialog.setContentView(mView);
                {
                    collapse();
                } //End block
                mDialog.show();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6F9FB81F5DFCEB0ED37A5ED268967B6A_291798589 = ((flags & AudioManager.FLAG_VIBRATE) != 0 &&
                mAudioService.isStreamAffectedByRingerMode(streamType) &&
                mAudioService.getRingerMode() == AudioManager.RINGER_MODE_VIBRATE &&
                mAudioService.shouldVibrate(AudioManager.VIBRATE_TYPE_RINGER));
            {
                sendMessageDelayed(obtainMessage(MSG_VIBRATE), VIBRATE_DELAY);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.816 -0400", hash_original_method = "071A05A7A2CA1EC4817693B727B26BA6", hash_generated_method = "E1DACB1F0FB2AF0165A8B8098199DDE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onPlaySound(int streamType, int flags) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        {
            boolean var69C50700212624022B13EB798549220A_1423324058 = (hasMessages(MSG_STOP_SOUNDS));
            {
                removeMessages(MSG_STOP_SOUNDS);
                onStopSounds();
            } //End block
        } //End collapsed parenthetic
        {
            ToneGenerator toneGen;
            toneGen = getOrCreateToneGenerator(streamType);
            {
                toneGen.startTone(ToneGenerator.TONE_PROP_BEEP);
                sendMessageDelayed(obtainMessage(MSG_STOP_SOUNDS), BEEP_DURATION);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (hasMessages(MSG_STOP_SOUNDS)) {
            //removeMessages(MSG_STOP_SOUNDS);
            //onStopSounds();
        //}
        //synchronized (this) {
            //ToneGenerator toneGen = getOrCreateToneGenerator(streamType);
            //if (toneGen != null) {
                //toneGen.startTone(ToneGenerator.TONE_PROP_BEEP);
                //sendMessageDelayed(obtainMessage(MSG_STOP_SOUNDS), BEEP_DURATION);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.816 -0400", hash_original_method = "3A91BF2A95CD330FD799A7FC04D2B737", hash_generated_method = "02A9A00BF171F74E7CA02C4672909E77")
    @DSModeled(DSC.SAFE)
    protected void onStopSounds() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int numStreamTypes;
            numStreamTypes = AudioSystem.getNumStreamTypes();
            {
                int i;
                i = numStreamTypes - 1;
                {
                    ToneGenerator toneGen;
                    toneGen = mToneGenerators[i];
                    {
                        toneGen.stopTone();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //int numStreamTypes = AudioSystem.getNumStreamTypes();
            //for (int i = numStreamTypes - 1; i >= 0; i--) {
                //ToneGenerator toneGen = mToneGenerators[i];
                //if (toneGen != null) {
                    //toneGen.stopTone();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.816 -0400", hash_original_method = "7BAEA80687A45FAB6609F3185B3BC63C", hash_generated_method = "7463E770936781847117BB9635277574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void onVibrate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var408DB75634C13980FCDBA6C30F5206A2_1382943433 = (mAudioService.getRingerMode() != AudioManager.RINGER_MODE_VIBRATE);
        } //End collapsed parenthetic
        mVibrator.vibrate(VIBRATE_DURATION);
        // ---------- Original Method ----------
        //if (mAudioService.getRingerMode() != AudioManager.RINGER_MODE_VIBRATE) {
            //return;
        //}
        //mVibrator.vibrate(VIBRATE_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "A846E6B6772008780CB2163E8713AADD", hash_generated_method = "884B48D9EE078DCD83662EFDFB06BD33")
    @DSModeled(DSC.SAFE)
    private ToneGenerator getOrCreateToneGenerator(int streamType) {
        dsTaint.addTaint(streamType);
        {
            {
                try 
                {
                    mToneGenerators[streamType] = new ToneGenerator(streamType, MAX_VOLUME);
                } //End block
                catch (RuntimeException e)
                {
                    {
                        Log.d(TAG, "ToneGenerator constructor failed with "
                                + "RuntimeException: " + e);
                    } //End block
                } //End block
            } //End block
        } //End block
        return (ToneGenerator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mToneGenerators[streamType] == null) {
                //try {
                    //mToneGenerators[streamType] = new ToneGenerator(streamType, MAX_VOLUME);
                //} catch (RuntimeException e) {
                    //if (LOGD) {
                        //Log.d(TAG, "ToneGenerator constructor failed with "
                                //+ "RuntimeException: " + e);
                    //}
                //}
            //}
            //return mToneGenerators[streamType];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "EA63BF0B69DA203938FE73FDEA4C6986", hash_generated_method = "DD9125EFF3EEF1F6AFC3E7AF9C2845E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setMusicIcon(int resId, int resMuteId) {
        dsTaint.addTaint(resMuteId);
        dsTaint.addTaint(resId);
        StreamControl sc;
        sc = mStreamControls.get(AudioManager.STREAM_MUSIC);
        {
            sc.iconRes = resId;
            sc.iconMuteRes = resMuteId;
            sc.icon.setImageResource(isMuted(sc.streamType) ? sc.iconMuteRes : sc.iconRes);
        } //End block
        // ---------- Original Method ----------
        //StreamControl sc = mStreamControls.get(AudioManager.STREAM_MUSIC);
        //if (sc != null) {
            //sc.iconRes = resId;
            //sc.iconMuteRes = resMuteId;
            //sc.icon.setImageResource(isMuted(sc.streamType) ? sc.iconMuteRes : sc.iconRes);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "4EC7D342F774B6AB6E6884EDC92ED465", hash_generated_method = "213278811FC5213EBD501E2320F35F86")
    @DSModeled(DSC.SAFE)
    protected void onFreeResources() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                int i;
                i = mToneGenerators.length - 1;
                {
                    {
                        mToneGenerators[i].release();
                    } //End block
                    mToneGenerators[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //for (int i = mToneGenerators.length - 1; i >= 0; i--) {
                //if (mToneGenerators[i] != null) {
                    //mToneGenerators[i].release();
                //}
                //mToneGenerators[i] = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "184D239D26EB0F9F34588D70B6395D2E", hash_generated_method = "3DAB5B5949AF21EBB5CD0CA195B1605E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case MSG_VOLUME_CHANGED 
        {
            onVolumeChanged(msg.arg1, msg.arg2);
        } //End block
        //End case MSG_VOLUME_CHANGED 
        //Begin case MSG_FREE_RESOURCES 
        {
            onFreeResources();
        } //End block
        //End case MSG_FREE_RESOURCES 
        //Begin case MSG_STOP_SOUNDS 
        {
            onStopSounds();
        } //End block
        //End case MSG_STOP_SOUNDS 
        //Begin case MSG_PLAY_SOUND 
        {
            onPlaySound(msg.arg1, msg.arg2);
        } //End block
        //End case MSG_PLAY_SOUND 
        //Begin case MSG_VIBRATE 
        {
            onVibrate();
        } //End block
        //End case MSG_VIBRATE 
        //Begin case MSG_TIMEOUT 
        {
            {
                boolean varF8196D83F5A3C93B2ABC6B4E75153B7C_422788954 = (mDialog.isShowing());
                {
                    mDialog.dismiss();
                    mActiveStreamType = -1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MSG_TIMEOUT 
        //Begin case MSG_RINGER_MODE_CHANGED 
        {
            {
                boolean varF8196D83F5A3C93B2ABC6B4E75153B7C_517054975 = (mDialog.isShowing());
                {
                    updateStates();
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MSG_RINGER_MODE_CHANGED 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "632FD54223BA7384D0A36EA1637D6AC2", hash_generated_method = "D1BBF4793699999DF8127BAFA5CDFE96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetTimeout() {
        removeMessages(MSG_TIMEOUT);
        sendMessageDelayed(obtainMessage(MSG_TIMEOUT), TIMEOUT_DELAY);
        // ---------- Original Method ----------
        //removeMessages(MSG_TIMEOUT);
        //sendMessageDelayed(obtainMessage(MSG_TIMEOUT), TIMEOUT_DELAY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "3618884CB6272FA118042C452E26B599", hash_generated_method = "A42C83F01E864BC801B96B022E6717FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void forceTimeout() {
        removeMessages(MSG_TIMEOUT);
        sendMessage(obtainMessage(MSG_TIMEOUT));
        // ---------- Original Method ----------
        //removeMessages(MSG_TIMEOUT);
        //sendMessage(obtainMessage(MSG_TIMEOUT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.817 -0400", hash_original_method = "B54092C06C9B1642B77428FE0EED5273", hash_generated_method = "D0946590D3C8B977C9C74C1F67C59DB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(progress);
        dsTaint.addTaint(fromUser);
        dsTaint.addTaint(seekBar.dsTaint);
        final Object tag;
        tag = seekBar.getTag();
        {
            StreamControl sc;
            sc = (StreamControl) tag;
            {
                boolean var35B16CD848364A0DFB968BBEA24D2D70_262336361 = (mAudioManager.getStreamVolume(sc.streamType) != progress);
                {
                    mAudioManager.setStreamVolume(sc.streamType, progress, 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        resetTimeout();
        // ---------- Original Method ----------
        //final Object tag = seekBar.getTag();
        //if (fromUser && tag instanceof StreamControl) {
            //StreamControl sc = (StreamControl) tag;
            //if (mAudioManager.getStreamVolume(sc.streamType) != progress) {
                //mAudioManager.setStreamVolume(sc.streamType, progress, 0);
            //}
        //}
        //resetTimeout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.818 -0400", hash_original_method = "2AA527194913C37BEA165C65412DCCE8", hash_generated_method = "2E17B354C590488C0A45681FDBC682D6")
    @DSModeled(DSC.SAFE)
    public void onStartTrackingTouch(SeekBar seekBar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(seekBar.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.818 -0400", hash_original_method = "C24E4B96F44CFDB259B35294D494CEA8", hash_generated_method = "C8EB8D4C672770521463E8A1D5A7DAD8")
    @DSModeled(DSC.SAFE)
    public void onStopTrackingTouch(SeekBar seekBar) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(seekBar.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:06.818 -0400", hash_original_method = "F7591FEC1DF4AEAA4B86797E560ECE67", hash_generated_method = "C527B0824E1FA7690C85ABB87DC54DB0")
    @DSModeled(DSC.SAFE)
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            expand();
        } //End block
        resetTimeout();
        // ---------- Original Method ----------
        //if (v == mMoreButton) {
            //expand();
        //}
        //resetTimeout();
    }

    
    private enum StreamResources {
        BluetoothSCOStream(AudioManager.STREAM_BLUETOOTH_SCO,
                R.string.volume_icon_description_bluetooth,
                R.drawable.ic_audio_bt,
                R.drawable.ic_audio_bt,
                false),
        RingerStream(AudioManager.STREAM_RING,
                R.string.volume_icon_description_ringer,
                R.drawable.ic_audio_ring_notif,
                R.drawable.ic_audio_ring_notif_mute,
                false),
        VoiceStream(AudioManager.STREAM_VOICE_CALL,
                R.string.volume_icon_description_incall,
                R.drawable.ic_audio_phone,
                R.drawable.ic_audio_phone,
                false),
        AlarmStream(AudioManager.STREAM_ALARM,
                R.string.volume_alarm,
                R.drawable.ic_audio_alarm,
                R.drawable.ic_audio_alarm_mute,
                false),
        MediaStream(AudioManager.STREAM_MUSIC,
                R.string.volume_icon_description_media,
                R.drawable.ic_audio_vol,
                R.drawable.ic_audio_vol_mute,
                true),
        NotificationStream(AudioManager.STREAM_NOTIFICATION,
                R.string.volume_icon_description_notification,
                R.drawable.ic_audio_notification,
                R.drawable.ic_audio_notification_mute,
                true);
        int streamType;
        int descRes;
        int iconRes;
        int iconMuteRes;
        boolean show;
        StreamResources(int streamType, int descRes, int iconRes, int iconMuteRes, boolean show) {
            this.streamType = streamType;
            this.descRes = descRes;
            this.iconRes = iconRes;
            this.iconMuteRes = iconMuteRes;
            this.show = show;
        }
    }

    
    private class StreamControl {
        int streamType;
        ViewGroup group;
        ImageView icon;
        SeekBar seekbarView;
        int iconRes;
        int iconMuteRes;
        
    }


    
}


