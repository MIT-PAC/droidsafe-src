package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.ServiceManager;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.VolumePanel;
import java.util.Iterator;
import java.util.HashMap;

public class AudioManager {
    private Context mContext;
    private Handler mHandler;
    private long mVolumeKeyUpTime;
    private int  mVolumeControlStream = -1;
    private HashMap<String, OnAudioFocusChangeListener> mAudioFocusIdListenerMap =
            new HashMap<String, OnAudioFocusChangeListener>();
    private Object mFocusListenerLock = new Object();
    private FocusEventHandlerDelegate mAudioFocusEventHandlerDelegate =
            new FocusEventHandlerDelegate();
    private IAudioFocusDispatcher mAudioFocusDispatcher = new IAudioFocusDispatcher.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.036 -0400", hash_original_method = "D05EBA6AEC20F9D8CACE6E9B169AF75D", hash_generated_method = "7B645626B3ADE8D69EB7A8E42E255DBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchAudioFocusChange(int focusChange, String id) {
            dsTaint.addTaint(id);
            dsTaint.addTaint(focusChange);
            Message m;
            m = mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(focusChange, id);
            mAudioFocusEventHandlerDelegate.getHandler().sendMessage(m);
            // ---------- Original Method ----------
            //Message m = mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(focusChange, id);
            //mAudioFocusEventHandlerDelegate.getHandler().sendMessage(m);
        }

        
}; //Transformed anonymous class
    private IBinder mICallBack = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.036 -0400", hash_original_method = "42BDED457A05AA4B5FB652FAAB5F6EE7", hash_generated_method = "396A3FAC7B0BF6C7F9BC83645F8E0F6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AudioManager(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mHandler = new Handler(context.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = new Handler(context.getMainLooper());
    }

    
        private static IAudioService getService() {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService(Context.AUDIO_SERVICE);
        sService = IAudioService.Stub.asInterface(b);
        return sService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.036 -0400", hash_original_method = "F1E14361B214327A2A0E751697355D64", hash_generated_method = "149DA70CF308C6560A8FCC5B3C83CE19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void preDispatchKeyEvent(int keyCode, int stream) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(stream);
        {
            boolean varD725F128FDBBDBC4888D495683ADA59A_605570688 = (keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                && keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                && mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        > SystemClock.uptimeMillis());
            {
                adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                //&& keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                //&& mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        //> SystemClock.uptimeMillis()) {
            //adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        //stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.037 -0400", hash_original_method = "CE7E2CE8B01D9CBEAD319BD036F134E9", hash_generated_method = "F6E63C1795DC0FC42B24B1CCE94FBF54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleKeyDown(int keyCode, int stream) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(stream);
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        int flags;
        flags = FLAG_SHOW_UI | FLAG_VIBRATE;
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } //End block
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        adjustSuggestedStreamVolume(
                        keyCode == KeyEvent.KEYCODE_VOLUME_UP
                                ? ADJUST_RAISE
                                : ADJUST_LOWER,
                        stream,
                        flags);
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        // ---------- Original Method ----------
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_VOLUME_UP:
            //case KeyEvent.KEYCODE_VOLUME_DOWN:
                //int flags = FLAG_SHOW_UI | FLAG_VIBRATE;
                //if (mVolumeControlStream != -1) {
                    //stream = mVolumeControlStream;
                    //flags |= FLAG_FORCE_STREAM;
                //}
                //adjustSuggestedStreamVolume(
                        //keyCode == KeyEvent.KEYCODE_VOLUME_UP
                                //? ADJUST_RAISE
                                //: ADJUST_LOWER,
                        //stream,
                        //flags);
                //break;
            //case KeyEvent.KEYCODE_VOLUME_MUTE:
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.037 -0400", hash_original_method = "4690E566A0F7A4762BD0C4814376C399", hash_generated_method = "ED1D9453C7C583C73E655CE05D227974")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleKeyUp(int keyCode, int stream) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(stream);
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        int flags;
        flags = FLAG_PLAY_SOUND;
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } //End block
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        adjustSuggestedStreamVolume(
                        ADJUST_SAME,
                        stream,
                        flags);
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        //Begin case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        mVolumeKeyUpTime = SystemClock.uptimeMillis();
        //End case KeyEvent.KEYCODE_VOLUME_UP KeyEvent.KEYCODE_VOLUME_DOWN 
        // ---------- Original Method ----------
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_VOLUME_UP:
            //case KeyEvent.KEYCODE_VOLUME_DOWN:
                //int flags = FLAG_PLAY_SOUND;
                //if (mVolumeControlStream != -1) {
                    //stream = mVolumeControlStream;
                    //flags |= FLAG_FORCE_STREAM;
                //}
                //adjustSuggestedStreamVolume(
                        //ADJUST_SAME,
                        //stream,
                        //flags);
                //mVolumeKeyUpTime = SystemClock.uptimeMillis();
                //break;
            //case KeyEvent.KEYCODE_VOLUME_MUTE:
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.037 -0400", hash_original_method = "C38595EDF7BD63128B5AA309C4B33E8C", hash_generated_method = "942938DB424ACDCB3FF5E2941227793A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustStreamVolume(int streamType, int direction, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            service.adjustStreamVolume(streamType, direction, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustStreamVolume(streamType, direction, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustStreamVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.038 -0400", hash_original_method = "C22839B58F1A4FE03A5B8DC3C5604E6D", hash_generated_method = "F68312D9050F39437FE9DBE5598C1316")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustVolume(int direction, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(direction);
        IAudioService service;
        service = getService();
        try 
        {
            service.adjustVolume(direction, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustVolume(direction, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.038 -0400", hash_original_method = "A437B9342B9C9807FDB6D5AE81B79F65", hash_generated_method = "87D1D13A67E834DEF44A37537DC4C812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(suggestedStreamType);
        dsTaint.addTaint(direction);
        IAudioService service;
        service = getService();
        try 
        {
            service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.038 -0400", hash_original_method = "A5416468537A862277C3CD80415076F6", hash_generated_method = "B57D8B080F87022375EF01E5BA7DEBF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRingerMode() {
        IAudioService service;
        service = getService();
        try 
        {
            int var0265EE3720DE05FD1A1C293F7AF4883E_1821290428 = (service.getRingerMode());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getRingerMode();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getRingerMode", e);
            //return RINGER_MODE_NORMAL;
        //}
    }

    
        public static boolean isValidRingerMode(int ringerMode) {
        if (ringerMode < 0 || ringerMode > RINGER_MODE_MAX) {
            return false;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.039 -0400", hash_original_method = "87CF12BF10581D3FEA634AA8128A64C7", hash_generated_method = "409F24630569A8422D6F4A31EC870EA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStreamMaxVolume(int streamType) {
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            int varFCCDB31A2F17500880C400E4E2074C92_559933480 = (service.getStreamMaxVolume(streamType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getStreamMaxVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getStreamMaxVolume", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.039 -0400", hash_original_method = "E78E6899167FF196E0675E8746CEB32F", hash_generated_method = "7E0F7CE0B229F406214FA5DEAFFBA868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getStreamVolume(int streamType) {
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            int var4F88A0A8966E778EEDC728EA3FAB0491_868991644 = (service.getStreamVolume(streamType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getStreamVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getStreamVolume", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.039 -0400", hash_original_method = "16B6103C3931EF2B68A7F288EB86CE17", hash_generated_method = "CF4AE1A8FAE38A76A55A3503CD033934")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLastAudibleStreamVolume(int streamType) {
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            int var27F02EDE47E03B5C632EFF5C758045A9_1531599641 = (service.getLastAudibleStreamVolume(streamType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getLastAudibleStreamVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getLastAudibleStreamVolume", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.040 -0400", hash_original_method = "3C2FC6CE4E6D1CA9BA044809D37E86F6", hash_generated_method = "05558B7DA8A53BEE48C7BD5A1F4637E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRingerMode(int ringerMode) {
        dsTaint.addTaint(ringerMode);
        {
            boolean varCC03F4E2DB9431712F2901B2E0057122_884329155 = (!isValidRingerMode(ringerMode));
        } //End collapsed parenthetic
        IAudioService service;
        service = getService();
        try 
        {
            service.setRingerMode(ringerMode);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (!isValidRingerMode(ringerMode)) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.setRingerMode(ringerMode);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setRingerMode", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.040 -0400", hash_original_method = "3749020B5128F4562E7A795FA2ED06F0", hash_generated_method = "8380C00DBA0F1AE157B94E7BBF384F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamVolume(int streamType, int index, int flags) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            service.setStreamVolume(streamType, index, flags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamVolume(streamType, index, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.040 -0400", hash_original_method = "68979401C5E5A9876842A31A718D3CC1", hash_generated_method = "558A38F76F33EE082040DFCDF2E9DE36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamSolo(int streamType, boolean state) {
        dsTaint.addTaint(state);
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            service.setStreamSolo(streamType, state, mICallBack);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamSolo(streamType, state, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamSolo", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.041 -0400", hash_original_method = "D5FC01CA83C5AD93EBE0673BD699E427", hash_generated_method = "B0F2DCF2DAFE43FC54BAD729DDF0D761")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStreamMute(int streamType, boolean state) {
        dsTaint.addTaint(state);
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            service.setStreamMute(streamType, state, mICallBack);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamMute(streamType, state, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamMute", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.041 -0400", hash_original_method = "740B30F7577C3CCB183F4420A2F982C5", hash_generated_method = "280144E5419BD892D7797E60C17C8FF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStreamMute(int streamType) {
        dsTaint.addTaint(streamType);
        IAudioService service;
        service = getService();
        try 
        {
            boolean var64F9D8692C002372BA2AEB0C83405725_302996992 = (service.isStreamMute(streamType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isStreamMute(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isStreamMute", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.041 -0400", hash_original_method = "7B6A5349C22F082B0BD2BFA86A0EB11D", hash_generated_method = "87B1A7FCC74D9D8F21804E459CD6D080")
    @DSModeled(DSC.SAFE)
    public void forceVolumeControlStream(int streamType) {
        dsTaint.addTaint(streamType);
        // ---------- Original Method ----------
        //mVolumeControlStream = streamType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.041 -0400", hash_original_method = "F2CA732281E7EDA686D9C1A3A9E04423", hash_generated_method = "5FDE604DF29DDDB5461D302F750AAE06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldVibrate(int vibrateType) {
        dsTaint.addTaint(vibrateType);
        IAudioService service;
        service = getService();
        try 
        {
            boolean varF8973DA33ACFA219453A555E62E2AB3F_302577118 = (service.shouldVibrate(vibrateType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.shouldVibrate(vibrateType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in shouldVibrate", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.042 -0400", hash_original_method = "8D15AC5DC8AF10C8514FCDAE7CA188DE", hash_generated_method = "889827E4ADD7D53B0526F28B22053014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVibrateSetting(int vibrateType) {
        dsTaint.addTaint(vibrateType);
        IAudioService service;
        service = getService();
        try 
        {
            int varF37E1046BA5FAE28CC96262CCEACF0AF_172711652 = (service.getVibrateSetting(vibrateType));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getVibrateSetting(vibrateType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getVibrateSetting", e);
            //return VIBRATE_SETTING_OFF;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.042 -0400", hash_original_method = "1BAA841F73A90E0BDF1DD9E6546FAE92", hash_generated_method = "05849A91ED4ED6FAA00AD4751444A773")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        dsTaint.addTaint(vibrateSetting);
        dsTaint.addTaint(vibrateType);
        IAudioService service;
        service = getService();
        try 
        {
            service.setVibrateSetting(vibrateType, vibrateSetting);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setVibrateSetting(vibrateType, vibrateSetting);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setVibrateSetting", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.042 -0400", hash_original_method = "4CC8C4119BF3E8CF0A2DBE18005271BE", hash_generated_method = "D1D7E2B2CE7F09C3E76F4CC932FF0831")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpeakerphoneOn(boolean on) {
        dsTaint.addTaint(on);
        IAudioService service;
        service = getService();
        try 
        {
            service.setSpeakerphoneOn(on);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setSpeakerphoneOn(on);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setSpeakerphoneOn", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.043 -0400", hash_original_method = "87629A828DADB356D60EBD8A4600C927", hash_generated_method = "F283C24E1E8663618C3BFED4FC12A9F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSpeakerphoneOn() {
        IAudioService service;
        service = getService();
        try 
        {
            boolean var87598D078D83248449B547D4AD6978ED_1314467737 = (service.isSpeakerphoneOn());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isSpeakerphoneOn();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isSpeakerphoneOn", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.043 -0400", hash_original_method = "AE17A85066353D3FDC3B454F62E84055", hash_generated_method = "5B2A40B68F596C439676005F368A3BF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBluetoothScoAvailableOffCall() {
        boolean var28BBC54E2E2172CDA0560999010643E5_258684588 = (mContext.getResources().getBoolean(
               com.android.internal.R.bool.config_bluetooth_sco_off_call));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mContext.getResources().getBoolean(
               //com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.043 -0400", hash_original_method = "7A79304FA4E978214D78F6217FAAF967", hash_generated_method = "2E17606A56010968533237D3F1388705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void startBluetoothSco() {
        IAudioService service;
        service = getService();
        try 
        {
            service.startBluetoothSco(mICallBack);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.startBluetoothSco(mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in startBluetoothSco", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.043 -0400", hash_original_method = "CADB6B26FDAB5A2B15E67AB780A2BFA8", hash_generated_method = "4768D39C037D55DCE93A74A8BE7D2726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopBluetoothSco() {
        IAudioService service;
        service = getService();
        try 
        {
            service.stopBluetoothSco(mICallBack);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.stopBluetoothSco(mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in stopBluetoothSco", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.044 -0400", hash_original_method = "606F2494E176D702B95CCB0A4567DEDE", hash_generated_method = "526FEAFF453B55584B1A6BF8E34481F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBluetoothScoOn(boolean on) {
        dsTaint.addTaint(on);
        IAudioService service;
        service = getService();
        try 
        {
            service.setBluetoothScoOn(on);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setBluetoothScoOn(on);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setBluetoothScoOn", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.044 -0400", hash_original_method = "F2AF5947C2E51F8D76A34ACBB4A97B98", hash_generated_method = "8986206813372426A6A328DB8E85F81B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBluetoothScoOn() {
        IAudioService service;
        service = getService();
        try 
        {
            boolean varD16DA93890CC6D6662396482754120D6_369895036 = (service.isBluetoothScoOn());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isBluetoothScoOn();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isBluetoothScoOn", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.045 -0400", hash_original_method = "6E721A6BE84D0B991FC9D97F8410EE50", hash_generated_method = "288D5830F81AA05B6AE59ED2AF42B89C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setBluetoothA2dpOn(boolean on) {
        dsTaint.addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.045 -0400", hash_original_method = "61CE342F240529F54025E3EC55BEFF02", hash_generated_method = "EF8BA29AB68F0F1B1B885C5C36D6C976")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isBluetoothA2dpOn() {
        {
            boolean varEAC0D32A41CA6AC905ECBAD8C8AE1480_2125376101 = (AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            == AudioSystem.DEVICE_STATE_UNAVAILABLE);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            //== AudioSystem.DEVICE_STATE_UNAVAILABLE) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.045 -0400", hash_original_method = "9CDD23DC97597F87B0409849BA69DD8F", hash_generated_method = "A0B191A20AE09506067FCD7A1C7E92C3")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setWiredHeadsetOn(boolean on) {
        dsTaint.addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.046 -0400", hash_original_method = "602A1375ADE38071033B07AD6C9212C8", hash_generated_method = "24911078E6EFC42DD2771A2EB1A3FCA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWiredHeadsetOn() {
        {
            boolean var436B2F3F802D0573E5A579194F0921D4_936881272 = (AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADSET,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE &&
            AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADPHONE,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADSET,"")
                //== AudioSystem.DEVICE_STATE_UNAVAILABLE &&
            //AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADPHONE,"")
                //== AudioSystem.DEVICE_STATE_UNAVAILABLE) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.047 -0400", hash_original_method = "5FCC6D659A56B470BF76AF68D12DD9BE", hash_generated_method = "D7AE78264A3B90D861183AC260EB75E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMicrophoneMute(boolean on) {
        dsTaint.addTaint(on);
        AudioSystem.muteMicrophone(on);
        // ---------- Original Method ----------
        //AudioSystem.muteMicrophone(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.047 -0400", hash_original_method = "82EFB94D4DB567BF9AF21B9F2B827F69", hash_generated_method = "383CBA784AB807835A8300A9A19A848F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMicrophoneMute() {
        boolean var737D58D89436BE5BB1B80F4899D1D4C5_217728413 = (AudioSystem.isMicrophoneMuted());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return AudioSystem.isMicrophoneMuted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.047 -0400", hash_original_method = "FB0F50379150B9BD346003DA9FF4B8A5", hash_generated_method = "F451D38D52F66841B054914EA725B9F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMode(int mode) {
        dsTaint.addTaint(mode);
        IAudioService service;
        service = getService();
        try 
        {
            service.setMode(mode, mICallBack);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setMode(mode, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setMode", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.047 -0400", hash_original_method = "F6FC0C8FF20094842E05491DBD00A26F", hash_generated_method = "87995175241E29F84584C4B92B5C66CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMode() {
        IAudioService service;
        service = getService();
        try 
        {
            int varF42853430CB015AAB3A7FD991D8D0A71_1967676150 = (service.getMode());
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getMode();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getMode", e);
            //return MODE_INVALID;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.048 -0400", hash_original_method = "646817F3B93E4871A7A7D1BE098C87AE", hash_generated_method = "FA8FA4A6D59FF0685C8180B4C13B9FA6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setRouting(int mode, int routes, int mask) {
        dsTaint.addTaint(routes);
        dsTaint.addTaint(mask);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.048 -0400", hash_original_method = "6C4959DBE0B2C4B0BA15108AAD8EE45D", hash_generated_method = "2F4EF857B5D5722EB01F2D9348F3062C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public int getRouting(int mode) {
        dsTaint.addTaint(mode);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.048 -0400", hash_original_method = "AF4716567EA0644FB4FB307583193A2C", hash_generated_method = "41A5F2170BBA460052B77A6E25DFBD29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMusicActive() {
        boolean var454E243CB980889645FE5E60C7CE53B3_1505490587 = (AudioSystem.isStreamActive(STREAM_MUSIC, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return AudioSystem.isStreamActive(STREAM_MUSIC, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.048 -0400", hash_original_method = "FB00D8D09EE0A42D5615E8AEAC323753", hash_generated_method = "41739F36363842985E752EFB5462F53E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setParameter(String key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        setParameters(key+"="+value);
        // ---------- Original Method ----------
        //setParameters(key+"="+value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.049 -0400", hash_original_method = "18224FDA7DBAF634E3113700EF6FFA3D", hash_generated_method = "38885D166981084FDEE0A308C4783A35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setParameters(String keyValuePairs) {
        dsTaint.addTaint(keyValuePairs);
        AudioSystem.setParameters(keyValuePairs);
        // ---------- Original Method ----------
        //AudioSystem.setParameters(keyValuePairs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.049 -0400", hash_original_method = "9B4E69B0951CD7555E74053B3F2A7F5E", hash_generated_method = "052AB5C2403DC904F3AFB9727B4F3B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameters(String keys) {
        dsTaint.addTaint(keys);
        String varF1F6B642F09C7761D738E4B20D517A74_1795717742 = (AudioSystem.getParameters(keys));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return AudioSystem.getParameters(keys);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.049 -0400", hash_original_method = "68694F707C94BF6E0AD2DC63190ED9B5", hash_generated_method = "30B4899DC4E240FF4BA57900EA714EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSoundEffect(int effectType) {
        dsTaint.addTaint(effectType);
        {
            boolean var4EBE86F0D61A6E6B6BD9C7B99A8C271C_1564179436 = (!querySoundEffectsEnabled());
        } //End collapsed parenthetic
        IAudioService service;
        service = getService();
        try 
        {
            service.playSoundEffect(effectType);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (effectType < 0 || effectType >= NUM_SOUND_EFFECTS) {
            //return;
        //}
        //if (!querySoundEffectsEnabled()) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.playSoundEffect(effectType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in playSoundEffect"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.049 -0400", hash_original_method = "F681C40806C862BA65FB1368E5E3540A", hash_generated_method = "180833841333C13D6B67364AC0DE442B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSoundEffect(int effectType, float volume) {
        dsTaint.addTaint(volume);
        dsTaint.addTaint(effectType);
        IAudioService service;
        service = getService();
        try 
        {
            service.playSoundEffectVolume(effectType, volume);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (effectType < 0 || effectType >= NUM_SOUND_EFFECTS) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.playSoundEffectVolume(effectType, volume);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in playSoundEffect"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.050 -0400", hash_original_method = "91B9C921984750C333F4A3D84250AE14", hash_generated_method = "EEA226EAF62DAC569D0203AA75332C0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean querySoundEffectsEnabled() {
        boolean varC6898D694DDE6B1CE555B5FF02F0D604_1161655135 = (Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.050 -0400", hash_original_method = "A7E0D93492C6E9A5A55D1B76418A0B14", hash_generated_method = "79DDD0E649E8FA53255E4BBADD7A5B11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadSoundEffects() {
        IAudioService service;
        service = getService();
        try 
        {
            service.loadSoundEffects();
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.loadSoundEffects();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in loadSoundEffects"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.050 -0400", hash_original_method = "43A5029AD1D52804D92188712F1A67B5", hash_generated_method = "988A2FC8DF5A89FD9A3DB5E4F03830BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unloadSoundEffects() {
        IAudioService service;
        service = getService();
        try 
        {
            service.unloadSoundEffects();
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.unloadSoundEffects();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unloadSoundEffects"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.050 -0400", hash_original_method = "19FA7B2AF0BC01FED1DAA16E011C492D", hash_generated_method = "CF96084B0D0A43E6E4DAE8B54E647A5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private OnAudioFocusChangeListener findFocusListener(String id) {
        dsTaint.addTaint(id);
        OnAudioFocusChangeListener var0F566F4EE03FBA6A6E3EEABCC4A32970_1251286614 = (mAudioFocusIdListenerMap.get(id));
        return (OnAudioFocusChangeListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAudioFocusIdListenerMap.get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.051 -0400", hash_original_method = "F0553D3D8E69373BA6CE7B065E0EBE95", hash_generated_method = "21C244B29B0AD3C8B20EE4BF7F15FEAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getIdForAudioFocusListener(OnAudioFocusChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            String var83473DA4453582E10D40D5E1107A8182_1097820622 = (new String(this.toString()));
        } //End block
        {
            String varC71BF4381E5AD075E9FD89E1389B40EC_1550000862 = (new String(this.toString() + l.toString()));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (l == null) {
            //return new String(this.toString());
        //} else {
            //return new String(this.toString() + l.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.051 -0400", hash_original_method = "C22DD0E9B28263E867F443548BB38A4B", hash_generated_method = "86D481A2F73BA468293A26E2EE06E6EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerAudioFocusListener(OnAudioFocusChangeListener l) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(l.dsTaint);
        {
            {
                boolean varED576F6536DA5AC2AA8A2B585F375863_1462848904 = (mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(l)));
            } //End collapsed parenthetic
            mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(l), l);
        } //End block
        // ---------- Original Method ----------
        //synchronized(mFocusListenerLock) {
            //if (mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(l))) {
                //return;
            //}
            //mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(l), l);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.052 -0400", hash_original_method = "A69B5FF5652C2B6DCC8DE23DBE317A35", hash_generated_method = "918B04A4FE303EF256F882891881A0CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterAudioFocusListener(OnAudioFocusChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        {
            mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        } //End block
        // ---------- Original Method ----------
        //synchronized(mFocusListenerLock) {
            //mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.053 -0400", hash_original_method = "15F0A18D8B83DF0E5C3CD27FFCEED082", hash_generated_method = "376E24D8783D9E0361D29DFF11BFD15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int requestAudioFocus(OnAudioFocusChangeListener l, int streamType, int durationHint) {
        dsTaint.addTaint(durationHint);
        dsTaint.addTaint(streamType);
        dsTaint.addTaint(l.dsTaint);
        int status;
        status = AUDIOFOCUS_REQUEST_FAILED;
        registerAudioFocusListener(l);
        IAudioService service;
        service = getService();
        try 
        {
            status = service.requestAudioFocus(streamType, durationHint, mICallBack,
                    mAudioFocusDispatcher, getIdForAudioFocusListener(l),
                    mContext.getPackageName() );
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int status = AUDIOFOCUS_REQUEST_FAILED;
        //if ((durationHint < AUDIOFOCUS_GAIN) || (durationHint > AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK))
        //{
            //Log.e(TAG, "Invalid duration hint, audio focus request denied");
            //return status;
        //}
        //registerAudioFocusListener(l);
        //IAudioService service = getService();
        //try {
            //status = service.requestAudioFocus(streamType, durationHint, mICallBack,
                    //mAudioFocusDispatcher, getIdForAudioFocusListener(l),
                    //mContext.getPackageName() );
        //} catch (RemoteException e) {
            //Log.e(TAG, "Can't call requestAudioFocus() from AudioService due to "+e);
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.054 -0400", hash_original_method = "32D2590B7FC8AFB5DC09D66E2CA73EB1", hash_generated_method = "94280DF1D324626A4A91A63227AF2BAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int abandonAudioFocus(OnAudioFocusChangeListener l) {
        dsTaint.addTaint(l.dsTaint);
        int status;
        status = AUDIOFOCUS_REQUEST_FAILED;
        unregisterAudioFocusListener(l);
        IAudioService service;
        service = getService();
        try 
        {
            status = service.abandonAudioFocus(mAudioFocusDispatcher,
                    getIdForAudioFocusListener(l));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int status = AUDIOFOCUS_REQUEST_FAILED;
        //unregisterAudioFocusListener(l);
        //IAudioService service = getService();
        //try {
            //status = service.abandonAudioFocus(mAudioFocusDispatcher,
                    //getIdForAudioFocusListener(l));
        //} catch (RemoteException e) {
            //Log.e(TAG, "Can't call abandonAudioFocus() from AudioService due to "+e);
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.054 -0400", hash_original_method = "50EC2C592ADEFE7D217B837E9C2D3748", hash_generated_method = "03DF9454BAEF3CCA5DB3CCAAA093E3F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerMediaButtonEventReceiver(ComponentName eventReceiver) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(eventReceiver.dsTaint);
        {
            boolean varC555D2093F680D7AB7ABB6EF095D9D3C_51115705 = (!eventReceiver.getPackageName().equals(mContext.getPackageName()));
        } //End collapsed parenthetic
        Intent mediaButtonIntent;
        mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi;
        pi = PendingIntent.getBroadcast(mContext,
                0, mediaButtonIntent, 0);
        registerMediaButtonIntent(pi, eventReceiver);
        // ---------- Original Method ----------
        //if (eventReceiver == null) {
            //return;
        //}
        //if (!eventReceiver.getPackageName().equals(mContext.getPackageName())) {
            //Log.e(TAG, "registerMediaButtonEventReceiver() error: " +
                    //"receiver and context package names don't match");
            //return;
        //}
        //Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        //mediaButtonIntent.setComponent(eventReceiver);
        //PendingIntent pi = PendingIntent.getBroadcast(mContext,
                //0, mediaButtonIntent, 0);
        //registerMediaButtonIntent(pi, eventReceiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.055 -0400", hash_original_method = "F3457417B719B94CC07450473FCEA34B", hash_generated_method = "270FBE34F98654C97DE9E6E32EAF07E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(eventReceiver.dsTaint);
        dsTaint.addTaint(pi.dsTaint);
        IAudioService service;
        service = getService();
        try 
        {
            service.registerMediaButtonIntent(pi, eventReceiver);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if ((pi == null) || (eventReceiver == null)) {
            //Log.e(TAG, "Cannot call registerMediaButtonIntent() with a null parameter");
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.registerMediaButtonIntent(pi, eventReceiver);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in registerMediaButtonIntent"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.055 -0400", hash_original_method = "50FCC009A55C4B527D3EADAFCCF926C2", hash_generated_method = "5BBF916B2E41A3B04D20F6D7C958FBC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterMediaButtonEventReceiver(ComponentName eventReceiver) {
        dsTaint.addTaint(eventReceiver.dsTaint);
        Intent mediaButtonIntent;
        mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi;
        pi = PendingIntent.getBroadcast(mContext,
                0, mediaButtonIntent, 0);
        unregisterMediaButtonIntent(pi, eventReceiver);
        // ---------- Original Method ----------
        //if (eventReceiver == null) {
            //return;
        //}
        //Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        //mediaButtonIntent.setComponent(eventReceiver);
        //PendingIntent pi = PendingIntent.getBroadcast(mContext,
                //0, mediaButtonIntent, 0);
        //unregisterMediaButtonIntent(pi, eventReceiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.055 -0400", hash_original_method = "FD1680BE817579074A9AB3657CE1A622", hash_generated_method = "4B9E420946CD904FDB255C0AF7121A8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        dsTaint.addTaint(eventReceiver.dsTaint);
        dsTaint.addTaint(pi.dsTaint);
        IAudioService service;
        service = getService();
        try 
        {
            service.unregisterMediaButtonIntent(pi, eventReceiver);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.unregisterMediaButtonIntent(pi, eventReceiver);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unregisterMediaButtonIntent"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.055 -0400", hash_original_method = "226F7C4DEEA463C35DD22DDAE8FCA983", hash_generated_method = "3906F1745944084521560EB7FAB12A98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerRemoteControlClient(RemoteControlClient rcClient) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcClient.dsTaint);
        {
            boolean varB5E6ECFDFA3896796F661CCDFBFE1678_1655952001 = ((rcClient == null) || (rcClient.getRcMediaIntent() == null));
        } //End collapsed parenthetic
        IAudioService service;
        service = getService();
        try 
        {
            service.registerRemoteControlClient(rcClient.getRcMediaIntent(),   
                    rcClient.getIRemoteControlClient(),                        
                    mContext.getPackageName());
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if ((rcClient == null) || (rcClient.getRcMediaIntent() == null)) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.registerRemoteControlClient(rcClient.getRcMediaIntent(),   
                    //rcClient.getIRemoteControlClient(),                        
                    //mContext.getPackageName());                                
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in registerRemoteControlClient"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.056 -0400", hash_original_method = "61965062F9C113F5A501568B9F9D00FE", hash_generated_method = "59BE429E09C55AD5F924A3E7F90F3BD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterRemoteControlClient(RemoteControlClient rcClient) {
        dsTaint.addTaint(rcClient.dsTaint);
        {
            boolean varB5E6ECFDFA3896796F661CCDFBFE1678_428828448 = ((rcClient == null) || (rcClient.getRcMediaIntent() == null));
        } //End collapsed parenthetic
        IAudioService service;
        service = getService();
        try 
        {
            service.unregisterRemoteControlClient(rcClient.getRcMediaIntent(), 
                    rcClient.getIRemoteControlClient());
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if ((rcClient == null) || (rcClient.getRcMediaIntent() == null)) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.unregisterRemoteControlClient(rcClient.getRcMediaIntent(), 
                    //rcClient.getIRemoteControlClient());                       
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unregisterRemoteControlClient"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.056 -0400", hash_original_method = "F5BDE54913D135C31C9BD838A5D1535F", hash_generated_method = "86B0C7784FCA6BF2A84B71A3B3E4C13B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerRemoteControlDisplay(IRemoteControlDisplay rcd) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(rcd.dsTaint);
        IAudioService service;
        service = getService();
        try 
        {
            service.registerRemoteControlDisplay(rcd);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (rcd == null) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.registerRemoteControlDisplay(rcd);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in registerRemoteControlDisplay " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.056 -0400", hash_original_method = "0BDA4E172FD98A7582B88621FA3E6CCD", hash_generated_method = "4B5CC012B63D9528754047E5ED4C19BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay rcd) {
        dsTaint.addTaint(rcd.dsTaint);
        IAudioService service;
        service = getService();
        try 
        {
            service.unregisterRemoteControlDisplay(rcd);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (rcd == null) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.unregisterRemoteControlDisplay(rcd);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unregisterRemoteControlDisplay " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.057 -0400", hash_original_method = "2551461E9D10B148584E49E52F82D704", hash_generated_method = "9002B5DB8E2010D71D33AE648D9AE29A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay rcd, int w, int h) {
        dsTaint.addTaint(w);
        dsTaint.addTaint(rcd.dsTaint);
        dsTaint.addTaint(h);
        IAudioService service;
        service = getService();
        try 
        {
            service.remoteControlDisplayUsesBitmapSize(rcd, w, h);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (rcd == null) {
            //return;
        //}
        //IAudioService service = getService();
        //try {
            //service.remoteControlDisplayUsesBitmapSize(rcd, w, h);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in remoteControlDisplayUsesBitmapSize " + e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.057 -0400", hash_original_method = "CCB01AEEA7F61A25F19F08696D9B58D5", hash_generated_method = "55CF2B8A3B07F0CB016EEC9DD1DE9F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reloadAudioSettings() {
        IAudioService service;
        service = getService();
        try 
        {
            service.reloadAudioSettings();
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.reloadAudioSettings();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in reloadAudioSettings"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.057 -0400", hash_original_method = "0E7D5155727C2E176622AABD0BAF6345", hash_generated_method = "AD58B77AE78726B065B5149325165769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSilentMode() {
        int ringerMode;
        ringerMode = getRingerMode();
        boolean silentMode;
        silentMode = (ringerMode == RINGER_MODE_SILENT) ||
            (ringerMode == RINGER_MODE_VIBRATE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int ringerMode = getRingerMode();
        //boolean silentMode =
            //(ringerMode == RINGER_MODE_SILENT) ||
            //(ringerMode == RINGER_MODE_VIBRATE);
        //return silentMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.057 -0400", hash_original_method = "039E984EE545D8462E074EC6768B62D9", hash_generated_method = "842A3D4F845C20FDA0385BA51421B8F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDevicesForStream(int streamType) {
        dsTaint.addTaint(streamType);
        //Begin case STREAM_VOICE_CALL STREAM_SYSTEM STREAM_RING STREAM_MUSIC STREAM_ALARM STREAM_NOTIFICATION STREAM_DTMF 
        int var62CA9E8E5CFD4E876A4269DEBC806814_1996632577 = (AudioSystem.getDevicesForStream(streamType));
        //End case STREAM_VOICE_CALL STREAM_SYSTEM STREAM_RING STREAM_MUSIC STREAM_ALARM STREAM_NOTIFICATION STREAM_DTMF 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (streamType) {
        //case STREAM_VOICE_CALL:
        //case STREAM_SYSTEM:
        //case STREAM_RING:
        //case STREAM_MUSIC:
        //case STREAM_ALARM:
        //case STREAM_NOTIFICATION:
        //case STREAM_DTMF:
            //return AudioSystem.getDevicesForStream(streamType);
        //default:
            //return 0;
        //}
    }

    
    private class FocusEventHandlerDelegate {
        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.058 -0400", hash_original_method = "655176F98C4DE876C8B3DFC6C8BC6CB4", hash_generated_method = "1746F6C318D080EDBFFAE3A1E511DEB6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FocusEventHandlerDelegate() {
            Looper looper;
            {
                boolean varE905F74B73C9447F656F9E57A8E7CAD4_442511331 = ((looper = Looper.myLooper()) == null);
                {
                    looper = Looper.getMainLooper();
                } //End block
            } //End collapsed parenthetic
            {
                mHandler = new Handler(looper) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.058 -0400", hash_original_method = "30B5FC3AB937951C0E4F92A6F6EC4647", hash_generated_method = "6663D4D32A4839E0F30C8EC3074E8810")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void handleMessage(Message msg) {
                        dsTaint.addTaint(msg.dsTaint);
                        OnAudioFocusChangeListener listener;
                        listener = null;
                        {
                            listener = findFocusListener((String)msg.obj);
                        } //End block
                        {
                            listener.onAudioFocusChange(msg.what);
                        } //End block
                        // ---------- Original Method ----------
                        //OnAudioFocusChangeListener listener = null;
                        //synchronized(mFocusListenerLock) {
                            //listener = findFocusListener((String)msg.obj);
                        //}
                        //if (listener != null) {
                            //listener.onAudioFocusChange(msg.what);
                        //}
                    }
};
            } //End block
            {
                mHandler = null;
            } //End block
            // ---------- Original Method ----------
            //Looper looper;
            //if ((looper = Looper.myLooper()) == null) {
                //looper = Looper.getMainLooper();
            //}
            //if (looper != null) {
                //mHandler = new Handler(looper) {
                    //@Override
                    //public void handleMessage(Message msg) {
                        //OnAudioFocusChangeListener listener = null;
                        //synchronized(mFocusListenerLock) {
                            //listener = findFocusListener((String)msg.obj);
                        //}
                        //if (listener != null) {
                            //listener.onAudioFocusChange(msg.what);
                        //}
                    //}
                //};
            //} else {
                //mHandler = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.058 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "D3E19AD51BB736BACE29345C61715E5A")
        @DSModeled(DSC.SAFE)
         Handler getHandler() {
            return (Handler)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mHandler;
        }

        
    }


    
    public interface OnAudioFocusChangeListener {
        
        public void onAudioFocusChange(int focusChange);
    }
    
    private static String TAG = "AudioManager";
    private static boolean localLOGV = false;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String EXTRA_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_VOLUME_STREAM_VALUE";
    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    public static final int STREAM_VOICE_CALL = AudioSystem.STREAM_VOICE_CALL;
    public static final int STREAM_SYSTEM = AudioSystem.STREAM_SYSTEM;
    public static final int STREAM_RING = AudioSystem.STREAM_RING;
    public static final int STREAM_MUSIC = AudioSystem.STREAM_MUSIC;
    public static final int STREAM_ALARM = AudioSystem.STREAM_ALARM;
    public static final int STREAM_NOTIFICATION = AudioSystem.STREAM_NOTIFICATION;
    public static final int STREAM_BLUETOOTH_SCO = AudioSystem.STREAM_BLUETOOTH_SCO;
    public static final int STREAM_SYSTEM_ENFORCED = AudioSystem.STREAM_SYSTEM_ENFORCED;
    public static final int STREAM_DTMF = AudioSystem.STREAM_DTMF;
    public static final int STREAM_TTS = AudioSystem.STREAM_TTS;
    @Deprecated public static final int NUM_STREAMS = AudioSystem.NUM_STREAMS;
    public static final int[] DEFAULT_STREAM_VOLUME = new int[] {
        4,  
        7,  
        5,  
        11, 
        6,  
        5,  
        7,  
        7,  
        11, 
        11  
    };
    public static final int ADJUST_RAISE = 1;
    public static final int ADJUST_LOWER = -1;
    public static final int ADJUST_SAME = 0;
    public static final int FLAG_SHOW_UI = 1 << 0;
    public static final int FLAG_ALLOW_RINGER_MODES = 1 << 1;
    public static final int FLAG_PLAY_SOUND = 1 << 2;
    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 1 << 3;
    public static final int FLAG_VIBRATE = 1 << 4;
    public static final int FLAG_FORCE_STREAM = 1 << 5;
    public static final int RINGER_MODE_SILENT = 0;
    public static final int RINGER_MODE_VIBRATE = 1;
    public static final int RINGER_MODE_NORMAL = 2;
    private static final int RINGER_MODE_MAX = RINGER_MODE_NORMAL;
    public static final int VIBRATE_TYPE_RINGER = 0;
    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
    public static final int VIBRATE_SETTING_OFF = 0;
    public static final int VIBRATE_SETTING_ON = 1;
    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
    public static final int USE_DEFAULT_STREAM_TYPE = Integer.MIN_VALUE;
    private static IAudioService sService;
    @Deprecated @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SCO_AUDIO_STATE_CHANGED =
            "android.media.SCO_AUDIO_STATE_CHANGED";
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_SCO_AUDIO_STATE_UPDATED =
            "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    public static final String EXTRA_SCO_AUDIO_STATE =
            "android.media.extra.SCO_AUDIO_STATE";
    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE =
            "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
    public static final int SCO_AUDIO_STATE_ERROR = -1;
    public static final int MODE_INVALID            = AudioSystem.MODE_INVALID;
    public static final int MODE_CURRENT            = AudioSystem.MODE_CURRENT;
    public static final int MODE_NORMAL             = AudioSystem.MODE_NORMAL;
    public static final int MODE_RINGTONE           = AudioSystem.MODE_RINGTONE;
    public static final int MODE_IN_CALL            = AudioSystem.MODE_IN_CALL;
    public static final int MODE_IN_COMMUNICATION   = AudioSystem.MODE_IN_COMMUNICATION;
    @Deprecated public static final int ROUTE_EARPIECE          = AudioSystem.ROUTE_EARPIECE;
    @Deprecated public static final int ROUTE_SPEAKER           = AudioSystem.ROUTE_SPEAKER;
    @Deprecated public static final int ROUTE_BLUETOOTH = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @Deprecated public static final int ROUTE_HEADSET           = AudioSystem.ROUTE_HEADSET;
    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = AudioSystem.ROUTE_BLUETOOTH_A2DP;
    @Deprecated public static final int ROUTE_ALL               = AudioSystem.ROUTE_ALL;
    public static final int FX_KEY_CLICK = 0;
    public static final int FX_FOCUS_NAVIGATION_UP = 1;
    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
    public static final int FX_KEYPRESS_STANDARD = 5;
    public static final int FX_KEYPRESS_SPACEBAR = 6;
    public static final int FX_KEYPRESS_DELETE = 7;
    public static final int FX_KEYPRESS_RETURN = 8;
    public static final int NUM_SOUND_EFFECTS = 9;
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    public static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK =
            -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    public static final String REMOTE_CONTROL_CLIENT_CHANGED =
            "android.media.REMOTE_CONTROL_CLIENT_CHANGED";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_GENERATION =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_GENERATION";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_NAME =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_NAME";
    public static final String EXTRA_REMOTE_CONTROL_EVENT_RECEIVER =
            "android.media.EXTRA_REMOTE_CONTROL_EVENT_RECEIVER";
    public static final String EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED";
    public static final int DEVICE_OUT_EARPIECE = AudioSystem.DEVICE_OUT_EARPIECE;
    public static final int DEVICE_OUT_SPEAKER = AudioSystem.DEVICE_OUT_SPEAKER;
    public static final int DEVICE_OUT_WIRED_HEADSET = AudioSystem.DEVICE_OUT_WIRED_HEADSET;
    public static final int DEVICE_OUT_WIRED_HEADPHONE = AudioSystem.DEVICE_OUT_WIRED_HEADPHONE;
    public static final int DEVICE_OUT_BLUETOOTH_SCO = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_HEADSET;
    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_CARKIT;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP = AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES;
    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER;
    public static final int DEVICE_OUT_AUX_DIGITAL = AudioSystem.DEVICE_OUT_AUX_DIGITAL;
    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET;
    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET;
    public static final int DEVICE_OUT_DEFAULT = AudioSystem.DEVICE_OUT_DEFAULT;
}

