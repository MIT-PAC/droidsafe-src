package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.020 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.020 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.020 -0400", hash_original_field = "4E3CE2FB89AE8790564F7953A1F5389B", hash_generated_field = "5A0BAF05F67CAB3B2C4D272BECF49076")

    private long mVolumeKeyUpTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.020 -0400", hash_original_field = "00300946A98DC6B5FC615DF24CB1D779", hash_generated_field = "AB49906111B3804858E19BBFBE77F9B2")

    private int mVolumeControlStream = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.021 -0400", hash_original_field = "9C54D6A91593BF2EC8FCFEB994BBFDE0", hash_generated_field = "55E428528E5E7A11729F2BB805880E0B")

    private HashMap<String, OnAudioFocusChangeListener> mAudioFocusIdListenerMap = new HashMap<String, OnAudioFocusChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.021 -0400", hash_original_field = "782AAA43CAE2AEE4708C5AF18BCA50BC", hash_generated_field = "94B4DBA462511DBB55ED9EA27E7B7245")

    private final Object mFocusListenerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.021 -0400", hash_original_field = "5892CFFE01680BC3BE5B60DFC7E68A48", hash_generated_field = "B50AA15FB2D552CBF712655325DCFDE6")

    private FocusEventHandlerDelegate mAudioFocusEventHandlerDelegate = new FocusEventHandlerDelegate();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_field = "A0F7F05A34E84AB7313662AF35BB555F", hash_generated_field = "308C8A66E7A89D62F744DA6B62C1EE85")

    private IAudioFocusDispatcher mAudioFocusDispatcher = new IAudioFocusDispatcher.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_method = "D05EBA6AEC20F9D8CACE6E9B169AF75D", hash_generated_method = "812F9AC3246FC9072EFFC96531C82079")
        public void dispatchAudioFocusChange(int focusChange, String id) {
            Message m = mAudioFocusEventHandlerDelegate.getHandler().obtainMessage(focusChange, id);
            mAudioFocusEventHandlerDelegate.getHandler().sendMessage(m);
            addTaint(focusChange);
            addTaint(id.getTaint());
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.021 -0400", hash_original_field = "05163E3C5F31AC0F871D72347FD33243", hash_generated_field = "F0463229CC92165D569BCDFE5CB835D0")

    private IBinder mICallBack = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.022 -0400", hash_original_method = "42BDED457A05AA4B5FB652FAAB5F6EE7", hash_generated_method = "53D81A41BE30830265A3A3C7E43BFA2F")
    public  AudioManager(Context context) {
        mContext = context;
        mHandler = new Handler(context.getMainLooper());
        // ---------- Original Method ----------
        //mContext = context;
        //mHandler = new Handler(context.getMainLooper());
    }

    
    @DSModeled(DSC.SPEC)
    private static IAudioService getService() {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService(Context.AUDIO_SERVICE);
        sService = IAudioService.Stub.asInterface(b);
        return sService;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.024 -0400", hash_original_method = "F1E14361B214327A2A0E751697355D64", hash_generated_method = "93E7042DC59C6447A160431FAEAF78D7")
    public void preDispatchKeyEvent(int keyCode, int stream) {
        addTaint(stream);
        addTaint(keyCode);
        if(keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                && keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                && mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        > SystemClock.uptimeMillis())        
        {
            adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        } //End block
        // ---------- Original Method ----------
        //if (keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                //&& keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                //&& mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        //> SystemClock.uptimeMillis()) {
            //adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        //stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.024 -0400", hash_original_method = "CE7E2CE8B01D9CBEAD319BD036F134E9", hash_generated_method = "1CFCCD38F01A2E74BC905D91B1239BB1")
    public void handleKeyDown(int keyCode, int stream) {
        addTaint(stream);
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        int flags = FLAG_SHOW_UI | FLAG_VIBRATE;
        if(mVolumeControlStream != -1)        
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } //End block
        adjustSuggestedStreamVolume(
                        keyCode == KeyEvent.KEYCODE_VOLUME_UP
                                ? ADJUST_RAISE
                                : ADJUST_LOWER,
                        stream,
                        flags);
        break;
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        break;
}
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.024 -0400", hash_original_method = "4690E566A0F7A4762BD0C4814376C399", hash_generated_method = "0BD8243AAE0632D27712628A1FB0841C")
    public void handleKeyUp(int keyCode, int stream) {
        addTaint(stream);
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        int flags = FLAG_PLAY_SOUND;
        if(mVolumeControlStream != -1)        
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } //End block
        adjustSuggestedStreamVolume(
                        ADJUST_SAME,
                        stream,
                        flags);
        mVolumeKeyUpTime = SystemClock.uptimeMillis();
        break;
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        break;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.025 -0400", hash_original_method = "C38595EDF7BD63128B5AA309C4B33E8C", hash_generated_method = "F8321D7757AD44690FB1CCFE145A2AEA")
    public void adjustStreamVolume(int streamType, int direction, int flags) {
        addTaint(flags);
        addTaint(direction);
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            service.adjustStreamVolume(streamType, direction, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustStreamVolume(streamType, direction, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustStreamVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.025 -0400", hash_original_method = "C22839B58F1A4FE03A5B8DC3C5604E6D", hash_generated_method = "774A62C82698E5827A6785230EBEDAA9")
    public void adjustVolume(int direction, int flags) {
        addTaint(flags);
        addTaint(direction);
        IAudioService service = getService();
        try 
        {
            service.adjustVolume(direction, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustVolume(direction, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.025 -0400", hash_original_method = "A437B9342B9C9807FDB6D5AE81B79F65", hash_generated_method = "6A9D64CD6BA77DAC81C6D9C0F9073172")
    public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        addTaint(flags);
        addTaint(suggestedStreamType);
        addTaint(direction);
        IAudioService service = getService();
        try 
        {
            service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in adjustVolume", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.025 -0400", hash_original_method = "A5416468537A862277C3CD80415076F6", hash_generated_method = "7A68AACFCB22D5712BF15297A84118FE")
    public int getRingerMode() {
        IAudioService service = getService();
        try 
        {
            int varF68053F04C717E7FD8CC22B3867B0AA4_2054785682 = (service.getRingerMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350294568 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1350294568;
        } //End block
        catch (RemoteException e)
        {
            int var1E5A4197B9DAD92FF6EF7B43F684193C_786205847 = (RINGER_MODE_NORMAL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72619331 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_72619331;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getRingerMode();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getRingerMode", e);
            //return RINGER_MODE_NORMAL;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isValidRingerMode(int ringerMode) {
        if (ringerMode < 0 || ringerMode > RINGER_MODE_MAX) {
            return false;
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.026 -0400", hash_original_method = "87CF12BF10581D3FEA634AA8128A64C7", hash_generated_method = "570EBDC507884EF44AF11EEB271C4954")
    public int getStreamMaxVolume(int streamType) {
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            int var932EE9CE7B61C4F898374B73C0457231_2056662538 = (service.getStreamMaxVolume(streamType));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709738534 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709738534;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_895445779 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582968575 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_582968575;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getStreamMaxVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getStreamMaxVolume", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.026 -0400", hash_original_method = "E78E6899167FF196E0675E8746CEB32F", hash_generated_method = "27F1ECE506E1F0A08F0CDAE0E4E4A382")
    public int getStreamVolume(int streamType) {
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            int var5ED1D81A114DBFC3CE54031F29B5B69B_616205209 = (service.getStreamVolume(streamType));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86038390 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_86038390;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1470634745 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361053264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_361053264;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getStreamVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getStreamVolume", e);
            //return 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.026 -0400", hash_original_method = "16B6103C3931EF2B68A7F288EB86CE17", hash_generated_method = "D3E272CB260BB30EDBB05C946E7C2A63")
    public int getLastAudibleStreamVolume(int streamType) {
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            int var7B9DF0AEE5924204D862B75DEAF86EE9_1551314563 = (service.getLastAudibleStreamVolume(streamType));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729282469 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_729282469;
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1348884382 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955798755 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955798755;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getLastAudibleStreamVolume(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getLastAudibleStreamVolume", e);
            //return 0;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.027 -0400", hash_original_method = "3C2FC6CE4E6D1CA9BA044809D37E86F6", hash_generated_method = "E59AEB05BF9579AA0892C2A61BBDD278")
    public void setRingerMode(int ringerMode) {
        addTaint(ringerMode);
        if(!isValidRingerMode(ringerMode))        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.setRingerMode(ringerMode);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.027 -0400", hash_original_method = "3749020B5128F4562E7A795FA2ED06F0", hash_generated_method = "925D953ACB5115819FE512009F87E82D")
    public void setStreamVolume(int streamType, int index, int flags) {
        addTaint(flags);
        addTaint(index);
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            service.setStreamVolume(streamType, index, flags);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamVolume(streamType, index, flags);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamVolume", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.027 -0400", hash_original_method = "68979401C5E5A9876842A31A718D3CC1", hash_generated_method = "6B581214504FE38AD87EE3E6C42A7479")
    public void setStreamSolo(int streamType, boolean state) {
        addTaint(state);
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            service.setStreamSolo(streamType, state, mICallBack);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamSolo(streamType, state, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamSolo", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.027 -0400", hash_original_method = "D5FC01CA83C5AD93EBE0673BD699E427", hash_generated_method = "30F6391D19CF3BFF0EE6A4E8E0DB2236")
    public void setStreamMute(int streamType, boolean state) {
        addTaint(state);
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            service.setStreamMute(streamType, state, mICallBack);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setStreamMute(streamType, state, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setStreamMute", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.028 -0400", hash_original_method = "740B30F7577C3CCB183F4420A2F982C5", hash_generated_method = "B17047A106DE87A1D48A2DBBA9558191")
    public boolean isStreamMute(int streamType) {
        addTaint(streamType);
        IAudioService service = getService();
        try 
        {
            boolean var1FC6862ADBA4D7C0DCE793C35E22CE7E_1125743806 = (service.isStreamMute(streamType));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724665576 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_724665576;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1548485191 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398128364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398128364;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isStreamMute(streamType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isStreamMute", e);
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.028 -0400", hash_original_method = "7B6A5349C22F082B0BD2BFA86A0EB11D", hash_generated_method = "F0344FF33A696923D229AEAEBE4CF048")
    public void forceVolumeControlStream(int streamType) {
        mVolumeControlStream = streamType;
        // ---------- Original Method ----------
        //mVolumeControlStream = streamType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.028 -0400", hash_original_method = "F2CA732281E7EDA686D9C1A3A9E04423", hash_generated_method = "918496E1DFEE6C98C95826AE155878C2")
    public boolean shouldVibrate(int vibrateType) {
        addTaint(vibrateType);
        IAudioService service = getService();
        try 
        {
            boolean var6B2191E34AAF67ED354EFC68B9A5C7A5_1072320367 = (service.shouldVibrate(vibrateType));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012757500 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012757500;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_211357963 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68197128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68197128;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.shouldVibrate(vibrateType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in shouldVibrate", e);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.028 -0400", hash_original_method = "8D15AC5DC8AF10C8514FCDAE7CA188DE", hash_generated_method = "C7E8411C7CA73A2C4E072D5B4610A249")
    public int getVibrateSetting(int vibrateType) {
        addTaint(vibrateType);
        IAudioService service = getService();
        try 
        {
            int varE8EB2C0AF44000709531968D3430F1A1_2103811458 = (service.getVibrateSetting(vibrateType));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327669965 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_327669965;
        } //End block
        catch (RemoteException e)
        {
            int var3746FA72837488B04B802F4C5E55AA67_1923885209 = (VIBRATE_SETTING_OFF);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116577282 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116577282;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getVibrateSetting(vibrateType);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getVibrateSetting", e);
            //return VIBRATE_SETTING_OFF;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.028 -0400", hash_original_method = "1BAA841F73A90E0BDF1DD9E6546FAE92", hash_generated_method = "584CC49EB5B17DAAB16448E74F074959")
    public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        addTaint(vibrateSetting);
        addTaint(vibrateType);
        IAudioService service = getService();
        try 
        {
            service.setVibrateSetting(vibrateType, vibrateSetting);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setVibrateSetting(vibrateType, vibrateSetting);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setVibrateSetting", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.029 -0400", hash_original_method = "4CC8C4119BF3E8CF0A2DBE18005271BE", hash_generated_method = "A1805C1B63E465FE29CF9ED7085A9FC6")
    public void setSpeakerphoneOn(boolean on) {
        addTaint(on);
        IAudioService service = getService();
        try 
        {
            service.setSpeakerphoneOn(on);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setSpeakerphoneOn(on);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setSpeakerphoneOn", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.029 -0400", hash_original_method = "87629A828DADB356D60EBD8A4600C927", hash_generated_method = "7E458B404245806CDCEE475E62A7CBC8")
    public boolean isSpeakerphoneOn() {
        IAudioService service = getService();
        try 
        {
            boolean var6F3ABBC32B62D921CAF6A0C35B94035A_2098095655 = (service.isSpeakerphoneOn());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256622591 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_256622591;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_959222687 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591278247 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_591278247;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isSpeakerphoneOn();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isSpeakerphoneOn", e);
            //return false;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.029 -0400", hash_original_method = "AE17A85066353D3FDC3B454F62E84055", hash_generated_method = "D1757B33E81CF5677D8157BDB3B5A95B")
    public boolean isBluetoothScoAvailableOffCall() {
        boolean var9129E6DC7332618B5A13D086113FD058_1340362524 = (mContext.getResources().getBoolean(
               com.android.internal.R.bool.config_bluetooth_sco_off_call));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940176775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940176775;
        // ---------- Original Method ----------
        //return mContext.getResources().getBoolean(
               //com.android.internal.R.bool.config_bluetooth_sco_off_call);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.029 -0400", hash_original_method = "7A79304FA4E978214D78F6217FAAF967", hash_generated_method = "3A7F1183C7A3F99FAD16F15B0152F3DC")
    public void startBluetoothSco() {
        IAudioService service = getService();
        try 
        {
            service.startBluetoothSco(mICallBack);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.startBluetoothSco(mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in startBluetoothSco", e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.029 -0400", hash_original_method = "CADB6B26FDAB5A2B15E67AB780A2BFA8", hash_generated_method = "5018E1FDA3C1A6773C39F9CCCF7052E4")
    public void stopBluetoothSco() {
        IAudioService service = getService();
        try 
        {
            service.stopBluetoothSco(mICallBack);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.stopBluetoothSco(mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in stopBluetoothSco", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.030 -0400", hash_original_method = "606F2494E176D702B95CCB0A4567DEDE", hash_generated_method = "0ADB8A3D77413B4F11BE689DCB722030")
    public void setBluetoothScoOn(boolean on) {
        addTaint(on);
        IAudioService service = getService();
        try 
        {
            service.setBluetoothScoOn(on);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setBluetoothScoOn(on);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setBluetoothScoOn", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.030 -0400", hash_original_method = "F2AF5947C2E51F8D76A34ACBB4A97B98", hash_generated_method = "C33BEA438A0E876A177EA9469881970E")
    public boolean isBluetoothScoOn() {
        IAudioService service = getService();
        try 
        {
            boolean varFCA1992C4DABBB4940A7B6E3803844D1_922549940 = (service.isBluetoothScoOn());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834609332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_834609332;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_485070415 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221362455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221362455;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.isBluetoothScoOn();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in isBluetoothScoOn", e);
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.030 -0400", hash_original_method = "6E721A6BE84D0B991FC9D97F8410EE50", hash_generated_method = "A22C4661A6A1CFE6E9E75075FF7C7D3F")
    @Deprecated
    public void setBluetoothA2dpOn(boolean on) {
        addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.030 -0400", hash_original_method = "61CE342F240529F54025E3EC55BEFF02", hash_generated_method = "FFD6AEF360E86BC6EF653B3562EDD7EC")
    public boolean isBluetoothA2dpOn() {
        if(AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            == AudioSystem.DEVICE_STATE_UNAVAILABLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1338033964 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401480546 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401480546;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1415928812 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376483308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_376483308;
        } //End block
        // ---------- Original Method ----------
        //if (AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            //== AudioSystem.DEVICE_STATE_UNAVAILABLE) {
            //return false;
        //} else {
            //return true;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.031 -0400", hash_original_method = "9CDD23DC97597F87B0409849BA69DD8F", hash_generated_method = "0DF92E1DD80E7C02712C4E6F80598AED")
    @Deprecated
    public void setWiredHeadsetOn(boolean on) {
        addTaint(on);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.031 -0400", hash_original_method = "602A1375ADE38071033B07AD6C9212C8", hash_generated_method = "57E6DD45D578C7E00FE46E3F8864ED6F")
    public boolean isWiredHeadsetOn() {
        if(AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADSET,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE &&
            AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADPHONE,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1374724285 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349588844 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_349588844;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1073956772 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814148536 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_814148536;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.031 -0400", hash_original_method = "5FCC6D659A56B470BF76AF68D12DD9BE", hash_generated_method = "CD038916FD77E44F30B3BA58750D9A8A")
    public void setMicrophoneMute(boolean on) {
        addTaint(on);
        AudioSystem.muteMicrophone(on);
        // ---------- Original Method ----------
        //AudioSystem.muteMicrophone(on);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.031 -0400", hash_original_method = "82EFB94D4DB567BF9AF21B9F2B827F69", hash_generated_method = "E21D5BFD2AE1AF994728D132AD65C4FB")
    public boolean isMicrophoneMute() {
        boolean var641C621E451DDCF4205ADB892BE116DE_333541732 = (AudioSystem.isMicrophoneMuted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459603770 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459603770;
        // ---------- Original Method ----------
        //return AudioSystem.isMicrophoneMuted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.031 -0400", hash_original_method = "FB0F50379150B9BD346003DA9FF4B8A5", hash_generated_method = "C63016B41337F8087495D8FAA786F587")
    public void setMode(int mode) {
        addTaint(mode);
        IAudioService service = getService();
        try 
        {
            service.setMode(mode, mICallBack);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.setMode(mode, mICallBack);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in setMode", e);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "F6FC0C8FF20094842E05491DBD00A26F", hash_generated_method = "E5EA1F67F64279E67793CD4FD0A0D4FB")
    public int getMode() {
        IAudioService service = getService();
        try 
        {
            int var5F1F36EE41681FDDAFBB87FD180949EB_382706643 = (service.getMode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171600680 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171600680;
        } //End block
        catch (RemoteException e)
        {
            int varA97464B14C0AE1932823651A514BF933_1274902647 = (MODE_INVALID);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719992246 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719992246;
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //return service.getMode();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in getMode", e);
            //return MODE_INVALID;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "646817F3B93E4871A7A7D1BE098C87AE", hash_generated_method = "0508A541253A84E41E3D03BE46947E9C")
    @Deprecated
    public void setRouting(int mode, int routes, int mask) {
        addTaint(mask);
        addTaint(routes);
        addTaint(mode);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "6C4959DBE0B2C4B0BA15108AAD8EE45D", hash_generated_method = "CD004F075CAFE4EFA2020DA565AE5E45")
    @Deprecated
    public int getRouting(int mode) {
        addTaint(mode);
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1743404859 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199474743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199474743;
        // ---------- Original Method ----------
        //return -1;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "AF4716567EA0644FB4FB307583193A2C", hash_generated_method = "A473A58BCD2047FA36881674E2293573")
    public boolean isMusicActive() {
        boolean varE4186DB45E39EF5A172D5BF825C8F75A_45707679 = (AudioSystem.isStreamActive(STREAM_MUSIC, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338517553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338517553;
        // ---------- Original Method ----------
        //return AudioSystem.isStreamActive(STREAM_MUSIC, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "FB00D8D09EE0A42D5615E8AEAC323753", hash_generated_method = "FB45A70665C308E6B6629B3B0ADAEE6C")
    @Deprecated
    public void setParameter(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        setParameters(key+"="+value);
        // ---------- Original Method ----------
        //setParameters(key+"="+value);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "18224FDA7DBAF634E3113700EF6FFA3D", hash_generated_method = "2EE5CEA309CDE85866695CEDE8433D8A")
    public void setParameters(String keyValuePairs) {
        addTaint(keyValuePairs.getTaint());
        AudioSystem.setParameters(keyValuePairs);
        // ---------- Original Method ----------
        //AudioSystem.setParameters(keyValuePairs);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.032 -0400", hash_original_method = "9B4E69B0951CD7555E74053B3F2A7F5E", hash_generated_method = "DCCBF771625A733EDAC94D8C1F5DE6D7")
    public String getParameters(String keys) {
        addTaint(keys.getTaint());
String var08287DC451D1CC3521112D759BA21CFC_850931796 =         AudioSystem.getParameters(keys);
        var08287DC451D1CC3521112D759BA21CFC_850931796.addTaint(taint);
        return var08287DC451D1CC3521112D759BA21CFC_850931796;
        // ---------- Original Method ----------
        //return AudioSystem.getParameters(keys);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "68694F707C94BF6E0AD2DC63190ED9B5", hash_generated_method = "0C10E59174355758530B8DCEFD51A7B6")
    public void playSoundEffect(int effectType) {
        addTaint(effectType);
        if(effectType < 0 || effectType >= NUM_SOUND_EFFECTS)        
        {
            return;
        } //End block
        if(!querySoundEffectsEnabled())        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.playSoundEffect(effectType);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "F681C40806C862BA65FB1368E5E3540A", hash_generated_method = "9AE1265C1A8A38BF474697FC8191A21C")
    public void playSoundEffect(int effectType, float volume) {
        addTaint(volume);
        addTaint(effectType);
        if(effectType < 0 || effectType >= NUM_SOUND_EFFECTS)        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.playSoundEffectVolume(effectType, volume);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "91B9C921984750C333F4A3D84250AE14", hash_generated_method = "8CCAC163CFA014F328CFD41569368BF3")
    private boolean querySoundEffectsEnabled() {
        boolean var9B4F972891AEAA68B2C06EE10E2823FB_1011640793 = (Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114132845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114132845;
        // ---------- Original Method ----------
        //return Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "A7E0D93492C6E9A5A55D1B76418A0B14", hash_generated_method = "0559BE889AD089256B3EC2CABAA73EED")
    public void loadSoundEffects() {
        IAudioService service = getService();
        try 
        {
            service.loadSoundEffects();
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.loadSoundEffects();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in loadSoundEffects"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "43A5029AD1D52804D92188712F1A67B5", hash_generated_method = "B9994A39F23D3C9FB9B556BA71E4A90C")
    public void unloadSoundEffects() {
        IAudioService service = getService();
        try 
        {
            service.unloadSoundEffects();
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.unloadSoundEffects();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unloadSoundEffects"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.033 -0400", hash_original_method = "19FA7B2AF0BC01FED1DAA16E011C492D", hash_generated_method = "74B01FDC530C6782AD6178CFAA19C66D")
    private OnAudioFocusChangeListener findFocusListener(String id) {
        addTaint(id.getTaint());
OnAudioFocusChangeListener varE98DA20F913E1F55E3FD9128257B23DB_2048942170 =         mAudioFocusIdListenerMap.get(id);
        varE98DA20F913E1F55E3FD9128257B23DB_2048942170.addTaint(taint);
        return varE98DA20F913E1F55E3FD9128257B23DB_2048942170;
        // ---------- Original Method ----------
        //return mAudioFocusIdListenerMap.get(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.034 -0400", hash_original_method = "F0553D3D8E69373BA6CE7B065E0EBE95", hash_generated_method = "8BAE6A94C816F711D6E416BD2CC229D0")
    private String getIdForAudioFocusListener(OnAudioFocusChangeListener l) {
        addTaint(l.getTaint());
        if(l == null)        
        {
String varD06C80AEB2FFBDEF2A8B90BE585B30E0_1141378724 =             new String(this.toString());
            varD06C80AEB2FFBDEF2A8B90BE585B30E0_1141378724.addTaint(taint);
            return varD06C80AEB2FFBDEF2A8B90BE585B30E0_1141378724;
        } //End block
        else
        {
String var13669F214C200BA093DD1A2B01F6F83B_1906501343 =             new String(this.toString() + l.toString());
            var13669F214C200BA093DD1A2B01F6F83B_1906501343.addTaint(taint);
            return var13669F214C200BA093DD1A2B01F6F83B_1906501343;
        } //End block
        // ---------- Original Method ----------
        //if (l == null) {
            //return new String(this.toString());
        //} else {
            //return new String(this.toString() + l.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.036 -0400", hash_original_method = "C22DD0E9B28263E867F443548BB38A4B", hash_generated_method = "CF7A840B9C6E802DD2AC6A31DF9EAB2B")
    public void registerAudioFocusListener(OnAudioFocusChangeListener l) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(l.getTaint());
        synchronized
(mFocusListenerLock)        {
            if(mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(l)))            
            {
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.036 -0400", hash_original_method = "A69B5FF5652C2B6DCC8DE23DBE317A35", hash_generated_method = "B8359F18C4988353E6F940EC0380DEB8")
    public void unregisterAudioFocusListener(OnAudioFocusChangeListener l) {
        addTaint(l.getTaint());
        synchronized
(mFocusListenerLock)        {
            mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        } //End block
        // ---------- Original Method ----------
        //synchronized(mFocusListenerLock) {
            //mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.036 -0400", hash_original_method = "15F0A18D8B83DF0E5C3CD27FFCEED082", hash_generated_method = "1B68C1A9D2EAEE52935B41F3A195D126")
    public int requestAudioFocus(OnAudioFocusChangeListener l, int streamType, int durationHint) {
        addTaint(durationHint);
        addTaint(streamType);
        addTaint(l.getTaint());
        int status = AUDIOFOCUS_REQUEST_FAILED;
        if((durationHint < AUDIOFOCUS_GAIN) || (durationHint > AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK))        
        {
            int var9ACB44549B41563697BB490144EC6258_731330846 = (status);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533912163 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533912163;
        } //End block
        registerAudioFocusListener(l);
        IAudioService service = getService();
        try 
        {
            status = service.requestAudioFocus(streamType, durationHint, mICallBack,
                    mAudioFocusDispatcher, getIdForAudioFocusListener(l),
                    mContext.getPackageName() );
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var9ACB44549B41563697BB490144EC6258_1876298548 = (status);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833798066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833798066;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.036 -0400", hash_original_method = "32D2590B7FC8AFB5DC09D66E2CA73EB1", hash_generated_method = "D081A9DB817EE289EEB4A3CA32C72173")
    public int abandonAudioFocus(OnAudioFocusChangeListener l) {
        addTaint(l.getTaint());
        int status = AUDIOFOCUS_REQUEST_FAILED;
        unregisterAudioFocusListener(l);
        IAudioService service = getService();
        try 
        {
            status = service.abandonAudioFocus(mAudioFocusDispatcher,
                    getIdForAudioFocusListener(l));
        } //End block
        catch (RemoteException e)
        {
        } //End block
        int var9ACB44549B41563697BB490144EC6258_254907001 = (status);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962767252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962767252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.037 -0400", hash_original_method = "50EC2C592ADEFE7D217B837E9C2D3748", hash_generated_method = "95D12FD7AF12B6D2C9FC7F5EA85D3AAE")
    public void registerMediaButtonEventReceiver(ComponentName eventReceiver) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(eventReceiver.getTaint());
        if(eventReceiver == null)        
        {
            return;
        } //End block
        if(!eventReceiver.getPackageName().equals(mContext.getPackageName()))        
        {
            return;
        } //End block
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.038 -0400", hash_original_method = "F3457417B719B94CC07450473FCEA34B", hash_generated_method = "7E68B55B54B143BCD8C2D5643C42CE16")
    public void registerMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(eventReceiver.getTaint());
        addTaint(pi.getTaint());
        if((pi == null) || (eventReceiver == null))        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.registerMediaButtonIntent(pi, eventReceiver);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.038 -0400", hash_original_method = "50FCC009A55C4B527D3EADAFCCF926C2", hash_generated_method = "5D7C82B74BA243F4FAFC2BE1D1990B70")
    public void unregisterMediaButtonEventReceiver(ComponentName eventReceiver) {
        addTaint(eventReceiver.getTaint());
        if(eventReceiver == null)        
        {
            return;
        } //End block
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.038 -0400", hash_original_method = "FD1680BE817579074A9AB3657CE1A622", hash_generated_method = "6F3BB75A6498A908F37B232AF5C667EC")
    public void unregisterMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        addTaint(eventReceiver.getTaint());
        addTaint(pi.getTaint());
        IAudioService service = getService();
        try 
        {
            service.unregisterMediaButtonIntent(pi, eventReceiver);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.unregisterMediaButtonIntent(pi, eventReceiver);
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in unregisterMediaButtonIntent"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.039 -0400", hash_original_method = "226F7C4DEEA463C35DD22DDAE8FCA983", hash_generated_method = "5F59579EBAC1204FD3464BA6731F4739")
    public void registerRemoteControlClient(RemoteControlClient rcClient) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(rcClient.getTaint());
        if((rcClient == null) || (rcClient.getRcMediaIntent() == null))        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.registerRemoteControlClient(rcClient.getRcMediaIntent(),   
                    rcClient.getIRemoteControlClient(),                        
                    mContext.getPackageName());
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.039 -0400", hash_original_method = "61965062F9C113F5A501568B9F9D00FE", hash_generated_method = "B7613AB99DB3631A239DE2D570F1C49B")
    public void unregisterRemoteControlClient(RemoteControlClient rcClient) {
        addTaint(rcClient.getTaint());
        if((rcClient == null) || (rcClient.getRcMediaIntent() == null))        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.unregisterRemoteControlClient(rcClient.getRcMediaIntent(), 
                    rcClient.getIRemoteControlClient());
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.039 -0400", hash_original_method = "F5BDE54913D135C31C9BD838A5D1535F", hash_generated_method = "9CD422B175C17D2EC9DA115A21C703EA")
    public void registerRemoteControlDisplay(IRemoteControlDisplay rcd) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(rcd.getTaint());
        if(rcd == null)        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.registerRemoteControlDisplay(rcd);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.040 -0400", hash_original_method = "0BDA4E172FD98A7582B88621FA3E6CCD", hash_generated_method = "A3CD4D638F643B312388041075C54F5D")
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay rcd) {
        addTaint(rcd.getTaint());
        if(rcd == null)        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.unregisterRemoteControlDisplay(rcd);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.041 -0400", hash_original_method = "2551461E9D10B148584E49E52F82D704", hash_generated_method = "64C491C99E4BA72402BDFEE5A126FE70")
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay rcd, int w, int h) {
        addTaint(h);
        addTaint(w);
        addTaint(rcd.getTaint());
        if(rcd == null)        
        {
            return;
        } //End block
        IAudioService service = getService();
        try 
        {
            service.remoteControlDisplayUsesBitmapSize(rcd, w, h);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.041 -0400", hash_original_method = "CCB01AEEA7F61A25F19F08696D9B58D5", hash_generated_method = "D6EF82AFFFC3D875170494B313DE97F2")
    public void reloadAudioSettings() {
        IAudioService service = getService();
        try 
        {
            service.reloadAudioSettings();
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //IAudioService service = getService();
        //try {
            //service.reloadAudioSettings();
        //} catch (RemoteException e) {
            //Log.e(TAG, "Dead object in reloadAudioSettings"+e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.041 -0400", hash_original_method = "0E7D5155727C2E176622AABD0BAF6345", hash_generated_method = "8DB92697EBF38CA8C2DF33F113679474")
    public boolean isSilentMode() {
        int ringerMode = getRingerMode();
        boolean silentMode = (ringerMode == RINGER_MODE_SILENT) ||
            (ringerMode == RINGER_MODE_VIBRATE);
        boolean varEE0D5224250E89AB3B8030527B1526DD_583074125 = (silentMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910001139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910001139;
        // ---------- Original Method ----------
        //int ringerMode = getRingerMode();
        //boolean silentMode =
            //(ringerMode == RINGER_MODE_SILENT) ||
            //(ringerMode == RINGER_MODE_VIBRATE);
        //return silentMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.041 -0400", hash_original_method = "039E984EE545D8462E074EC6768B62D9", hash_generated_method = "E61C9E43B7A43F8A4C83B966C20B5BC1")
    public int getDevicesForStream(int streamType) {
        addTaint(streamType);
switch(streamType){
        case STREAM_VOICE_CALL:
        case STREAM_SYSTEM:
        case STREAM_RING:
        case STREAM_MUSIC:
        case STREAM_ALARM:
        case STREAM_NOTIFICATION:
        case STREAM_DTMF:
        int varDD5A0C464956D6DDDC7DB203CE65FCBD_76471301 = (AudioSystem.getDevicesForStream(streamType));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846308565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1846308565;
        default:
        int varCFCD208495D565EF66E7DFF9F98764DA_1086052217 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338316071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1338316071;
}
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.041 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_method = "655176F98C4DE876C8B3DFC6C8BC6CB4", hash_generated_method = "F3555F7F044E4C8B191C74B932027DB3")
          FocusEventHandlerDelegate() {
            Looper looper;
            if((looper = Looper.myLooper()) == null)            
            {
                looper = Looper.getMainLooper();
            } //End block
            if(looper != null)            
            {
                mHandler = new Handler(looper) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.045 -0400", hash_original_method = "30B5FC3AB937951C0E4F92A6F6EC4647", hash_generated_method = "A6A72A92E8A4AE5E0EE2B522B721F921")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                OnAudioFocusChangeListener listener = null;
                synchronized
(mFocusListenerLock)                {
                    listener = findFocusListener((String)msg.obj);
                } //End block
                if(listener != null)                
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
            else
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "A873B418D799553267CC230E04B39E8D")
         Handler getHandler() {
Handler varF60F4C595C5EF9EE40FAD1FE8119479B_1095723651 =             mHandler;
            varF60F4C595C5EF9EE40FAD1FE8119479B_1095723651.addTaint(taint);
            return varF60F4C595C5EF9EE40FAD1FE8119479B_1095723651;
            // ---------- Original Method ----------
            //return mHandler;
        }

        
    }


    
    public interface OnAudioFocusChangeListener {
        
        public void onAudioFocusChange(int focusChange);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "20E83A9306A5736CFA1BB1457A466EF8", hash_generated_field = "EA464CE610E64C107F0AE63BEF486884")

    private static String TAG = "AudioManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "2CAC9A13987ECF08A4F21FF3E2AD9AA1", hash_generated_field = "3B419F3B582C47DDFE050BC2915123CA")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "17C28C44CEAE0BF97AC9310674064704", hash_generated_field = "82FD8649C65A8CF3532DA13370F1BA7D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "15A7E500864B92D6FF20750A6FA9A577", hash_generated_field = "224A6B231CEB60121D4D26857CDB53A5")

    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "227F431D50F5817EAAB380A042DB346A", hash_generated_field = "CACD1A5245F7950B257F0D4DBC5F7355")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "B243DADF41954501A46800A7800E1DA5", hash_generated_field = "BC5B119582962733F44A97FF95D9FFE5")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "CE6052DBACAB0AE1831D4853F0AECC26", hash_generated_field = "51E87800B3F480A44745265DB1A8B0A3")

    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "ADA1BE4E3A6978DB31C683793AE4481B", hash_generated_field = "A915326453E39AE5D00D8FC37F9C4409")

    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "C1EECBA689575E3C34E5A67024E19C7A", hash_generated_field = "9FD0D907F0CD51DF1DB106EECBD6E9C3")

    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.046 -0400", hash_original_field = "AEF75AEF62FC34E183FF2D96906B966F", hash_generated_field = "9349DEF2B660FADDEEF1B5E130A7E048")

    public static final String EXTRA_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_VOLUME_STREAM_VALUE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "FA373E51FA4D25A4E7161C341AD7D848", hash_generated_field = "526505C0CAFCE5C52F34243604D6DCFA")

    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "59EC91962EF1D3EC8C41C6309A452FBE", hash_generated_field = "31DA6CA9D350A5C1500EAB368D53C36E")

    public static final int STREAM_VOICE_CALL = AudioSystem.STREAM_VOICE_CALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "353606BAF4270D751D34A47A56EFCA37", hash_generated_field = "4E6B4BD7DB17D08DD4B7DA5B936BD4D4")

    public static final int STREAM_SYSTEM = AudioSystem.STREAM_SYSTEM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "CC7ED0932A6B434F8074BBBBEBF940CA", hash_generated_field = "7E52EEF3A9F3F78B8DB4024C9ABD30A9")

    public static final int STREAM_RING = AudioSystem.STREAM_RING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "0B8CEC57305FB97A2E9286FD498663E0", hash_generated_field = "EED8B59EA13FC4896CC2F9343483263F")

    public static final int STREAM_MUSIC = AudioSystem.STREAM_MUSIC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "AD4E7B71860075F45694B4F65EE85888", hash_generated_field = "E333B8A140BD1179FF221381CD837DFE")

    public static final int STREAM_ALARM = AudioSystem.STREAM_ALARM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "C746226985B06CF152DD08D86B1A48FB", hash_generated_field = "71EF53B6668807C856EFBEF9825ECFA0")

    public static final int STREAM_NOTIFICATION = AudioSystem.STREAM_NOTIFICATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "0D9F20F7953EBE3F4691A8230C7BB6BE", hash_generated_field = "D735EBDC384DC7A926CBC88947191DB1")

    public static final int STREAM_BLUETOOTH_SCO = AudioSystem.STREAM_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "917E4BDDCC7FFFB079C7B216A5E826DB", hash_generated_field = "915B268BBDC4A53AC54878DC5E88D5A3")

    public static final int STREAM_SYSTEM_ENFORCED = AudioSystem.STREAM_SYSTEM_ENFORCED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "3FA2FC7BE21478756A033EF8796586F8", hash_generated_field = "50AD1DD144B476A92BCF3C54F214BBF7")

    public static final int STREAM_DTMF = AudioSystem.STREAM_DTMF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "03B915D9001E24DCD7B90E82D802741B", hash_generated_field = "0367B1DD22E5CBAA04B4868362ADCDD8")

    public static final int STREAM_TTS = AudioSystem.STREAM_TTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "9C0700F5CF15600949BCBC65F16381BC", hash_generated_field = "EFF9B2522110CD0C7A7477D89D0693A1")

    @Deprecated public static final int NUM_STREAMS = AudioSystem.NUM_STREAMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "FD4A9FEFFFF4D4D46C2745C68B1B8CB1", hash_generated_field = "F45CC9A685E67B21A51ED114CC84665E")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "4369B3D8B267DD6B732B986B985447F8", hash_generated_field = "39E2EEE47548F14D86DF84B8B634D67C")

    public static final int ADJUST_RAISE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "44961653BCF592271048000C377DF719", hash_generated_field = "06BE000BF1CE74FF300973D26EDD9CCC")

    public static final int ADJUST_LOWER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "35EBD0A111CA75C2426D193AC686EB6C", hash_generated_field = "790B73E28F46DC84449E1CC5892A2D1D")

    public static final int ADJUST_SAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "DF56CA398A1570CBC3AE853122FC6F8F", hash_generated_field = "C01617A7FF540256CD5CD3CC52836403")

    public static final int FLAG_SHOW_UI = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "933BFB90A3906EA8604A691D840AABE4", hash_generated_field = "EDBE1C6A970E116625702809E63BF00C")

    public static final int FLAG_ALLOW_RINGER_MODES = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "A226CB027D327C98F643AF2990719CAE", hash_generated_field = "1D52CF8A5130FFDCD6B413FE5A64D5C4")

    public static final int FLAG_PLAY_SOUND = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.047 -0400", hash_original_field = "61659A98C678003C9CB737153D502047", hash_generated_field = "FD125539FD3EE63843F3520B6EE0274B")

    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "55EC8B98515734A742EA5E1946F1AF77", hash_generated_field = "2B2FC04AD3CAEDF49651FD851423D6C4")

    public static final int FLAG_VIBRATE = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "F05F53A5BDE50D8B1078BB7714FEA07F", hash_generated_field = "45725751A8AF13B150CECD05C3003DC1")

    public static final int FLAG_FORCE_STREAM = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "16B9184BFB8526ED96AD7FF1A669DC9B", hash_generated_field = "168D021BDAA46D07A61D7B1EBCDDB53C")

    public static final int RINGER_MODE_SILENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "9B2462E65AFA10B2613D5D49DF8DB5B7", hash_generated_field = "F3C65C70B216A9A16710313BAFE6E5BB")

    public static final int RINGER_MODE_VIBRATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "99BEB41D7543DEE5869A50F8BFDC0E8B", hash_generated_field = "91CA816E423F22422D47B3B82C943A68")

    public static final int RINGER_MODE_NORMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "E636C5A1A36D2F4A1D37F3AFC423325F", hash_generated_field = "46620B2E8AE72554737A1DFE483BB5C5")

    private static final int RINGER_MODE_MAX = RINGER_MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "79C58357D9362F257B943BE01A6348A4", hash_generated_field = "A7E9F8C96B6DB2781912159B457B77B2")

    public static final int VIBRATE_TYPE_RINGER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "8486D7FD8D3C52B58BCFEF0870550E60", hash_generated_field = "E39C772C4AD66D76048A1561BA2537C0")

    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "92DAEB9EE6C8304034553D2280376FB1", hash_generated_field = "97CBF0237199BFD95F4B3796B121DB7A")

    public static final int VIBRATE_SETTING_OFF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "62B9C9C5956ABCDD1F44ABF9D31BAC93", hash_generated_field = "36A1A77239700641916E355FAE6C05CC")

    public static final int VIBRATE_SETTING_ON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "128911C0F3321F65FE0B471E62F432D6", hash_generated_field = "49863BA7BB9B018EBD15616831E16BF7")

    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "259604552E875A882D7CD8E2CFF250B1", hash_generated_field = "07C5C486F2A741CB9A37D58EAD3271C6")

    public static final int USE_DEFAULT_STREAM_TYPE = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "7D19457E3AE9FEB13C4F40FE79C55E2E")

    private static IAudioService sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.048 -0400", hash_original_field = "8C24ADBCB61F74CDE77492B1CBF403AF", hash_generated_field = "BDEA2A70E495CBAF5E748EF9975DCC87")

    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_CHANGED =
            "android.media.SCO_AUDIO_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "524A0ECB2DB96281CD4264B117FE641E", hash_generated_field = "F3166319F9207DF19FD2E9CFDAAA5A72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_UPDATED =
            "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "1C3E80947497049DC037CB0D864CC77C", hash_generated_field = "32FA7228E6E3D4D2E77A75BF18A610E6")

    public static final String EXTRA_SCO_AUDIO_STATE =
            "android.media.extra.SCO_AUDIO_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "6F620FD78C54945860CB0CFDE74529FF", hash_generated_field = "0622BB79817581AD352373308DBDB593")

    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE =
            "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "42F8D6364B79DE1DF57D4543785B23CE", hash_generated_field = "5E74ACBB33EE191822BB57DF0F81B6B2")

    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "5852539169E023A39E0550FAB5C0E899", hash_generated_field = "AE5318710A7CFA0C1F39C3D317710563")

    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "7E3CD44B473759B6D1B7498096D64FFD", hash_generated_field = "304672883C84724BF04B4DA579DFE5FC")

    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "EC097514B0EFCFE6FB926A81B71D0CBD", hash_generated_field = "F47DB376AA7C1FD07279222484B48ABF")

    public static final int SCO_AUDIO_STATE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "644777789892DC36D49149F7CB0C389F", hash_generated_field = "DB75CEE8F475CAED7AAA62F911E832A0")

    public static final int MODE_INVALID            = AudioSystem.MODE_INVALID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "DEFA6D18C225BB4385AA482511E43789", hash_generated_field = "259EA8BFEB6837EF7E97885CAC8959D1")

    public static final int MODE_CURRENT            = AudioSystem.MODE_CURRENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "3E937BB56F82A43A57DF3C5CD2AE2B52", hash_generated_field = "E42A9AACEEEF54C680DA2CB0F408B1AB")

    public static final int MODE_NORMAL             = AudioSystem.MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "614FB074CC7B1B4C87AD6086C8C9F2D7", hash_generated_field = "EE90B81F058177AB332C6C3C562A5933")

    public static final int MODE_RINGTONE           = AudioSystem.MODE_RINGTONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "F33DCDE6C1F90E40DC81EEAA7876AADC", hash_generated_field = "4CF349F6E441825259B2E10E96F041E3")

    public static final int MODE_IN_CALL            = AudioSystem.MODE_IN_CALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "564760EA2F04F056C7576F8FE76FF546", hash_generated_field = "434899DAA6585E4FD846D710E77D536B")

    public static final int MODE_IN_COMMUNICATION   = AudioSystem.MODE_IN_COMMUNICATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "BDC5B3E9254860F141747721B008B9AD", hash_generated_field = "70B8E8324A943FB211827626305D7B34")

    @Deprecated public static final int ROUTE_EARPIECE          = AudioSystem.ROUTE_EARPIECE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "7461F34B55FA346564FDAF53FB906403", hash_generated_field = "E2FDF0262BFAC843B291B6443B31346A")

    @Deprecated public static final int ROUTE_SPEAKER           = AudioSystem.ROUTE_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "62AA483272C57D745DC764F25FEF9438", hash_generated_field = "E9BBBA7FC483766285967936E5E858BE")

    @Deprecated public static final int ROUTE_BLUETOOTH = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "806C425814A4EEF020E90CBF85BAE6A4", hash_generated_field = "3C9DBD8E86562E2D420F48D99E3AF6C7")

    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "31D5238382125794C2C59C90EF6A470A", hash_generated_field = "9A404516ED0F3D498C08B7D46BA009B8")

    @Deprecated public static final int ROUTE_HEADSET           = AudioSystem.ROUTE_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "6A972EA7E913FD6C86FB203D38E563AF", hash_generated_field = "1083E9F1E7B36963C23113631B1A07AE")

    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = AudioSystem.ROUTE_BLUETOOTH_A2DP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "5F1267777916EB1D20E4F75A2B7BCF23", hash_generated_field = "A433F5AE2654D66600E8F02A7060BE7D")

    @Deprecated public static final int ROUTE_ALL               = AudioSystem.ROUTE_ALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "2D75E5724D70089E18CE209567FCB80F", hash_generated_field = "61871C08102B2C27DE0A6A884FBD04C8")

    public static final int FX_KEY_CLICK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "027B2A93F2BD757F05FACE4B2D9B6E21", hash_generated_field = "9B1C422735AA23C6564D3A25E067CCCD")

    public static final int FX_FOCUS_NAVIGATION_UP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.049 -0400", hash_original_field = "9620C0422DE0CFB6F98F7E4CB8C4BE48", hash_generated_field = "236FF916CEC7EE68DAA532ED561496C7")

    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "B44092AD653E0AAC0247D6680774F2D2", hash_generated_field = "CAA9DED10A96B1789EB8A05BCEA06EC3")

    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "8D26157BCDCB5FE10B720B8A1B8508FF", hash_generated_field = "507E5ACB5A3B0B2C1461339C057377B4")

    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "62F0219F5A77C725E4AB3EA9F53950BA", hash_generated_field = "F5ED1ACF7069D4ADA865EA192688F916")

    public static final int FX_KEYPRESS_STANDARD = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "4877111153D3F7C9A29A741A4821AAC0", hash_generated_field = "7F35EE68E6EF23414295B81D6D5519E8")

    public static final int FX_KEYPRESS_SPACEBAR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "12672196F423D4B7A5453301DBBE6239", hash_generated_field = "7F15B1B0A87277F3E076311AB3C08BE4")

    public static final int FX_KEYPRESS_DELETE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "7D576AD51AC10382259E36A7EF776FD6", hash_generated_field = "C665DE812B57F58CB0283896A6829103")

    public static final int FX_KEYPRESS_RETURN = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "55CB94C882E45652B87258C68EA47887", hash_generated_field = "64E2DFA9698F8C924F1476F0A0C29567")

    public static final int NUM_SOUND_EFFECTS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "A7FEA4266BA74E9BAA3E58B43E875A60", hash_generated_field = "322B7C042AB9183F8D195E48CE22838E")

    public static final int AUDIOFOCUS_GAIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "07DFBF69A40F15A979FF33F093B5BC6B", hash_generated_field = "BB6569D7168A2B68AC704A047DCB1B3D")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "A2DEA6C2EBC4F7D685910D6096EE3423", hash_generated_field = "261801A1158E5414AFF80E5C998CDA23")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "D66FC19054A8C84C11E536F9BF22BF56", hash_generated_field = "1FDFD24111A3D8158394B4436A3323CC")

    public static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "AD7FCADF3EF773A2ADBCC97D0554EAEC", hash_generated_field = "7CC773DE0572889733DA498CCA178236")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "67EAA4247C3D9DD9FA8094672616CD79", hash_generated_field = "9CC322B2833D90555FD6EC3A873AF969")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK =
            -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "10B706C9ED9929AAB401BF66E26D2750", hash_generated_field = "D8A159EEDAE6693D921247329EA8C396")

    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "7E9672199FB289A94FD9A4696CA773A3", hash_generated_field = "1FD5D2DAD8907D4E83DD8E910708874E")

    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "1D03745B75D1995B06588647E586B8C1", hash_generated_field = "E4DDE7D9421C2AEC76D663CBDE2815AB")

    public static final String REMOTE_CONTROL_CLIENT_CHANGED =
            "android.media.REMOTE_CONTROL_CLIENT_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "B46E0BCF54E768E039E84F8581DE6E8F", hash_generated_field = "33E4E0F43F4DCCA5D8A75610CF8E15D6")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_GENERATION =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_GENERATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "3236807831D320ECADF902F72DBD2617", hash_generated_field = "A1AE731951F7414BC47CA9F114761CCE")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_NAME =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "C69AEFB0A9C79886FEBB755902162286", hash_generated_field = "3CB942DE68C520A2E338E02E7BF82DCE")

    public static final String EXTRA_REMOTE_CONTROL_EVENT_RECEIVER =
            "android.media.EXTRA_REMOTE_CONTROL_EVENT_RECEIVER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.050 -0400", hash_original_field = "A42BEA1653473123D3004DB945EF3AB1", hash_generated_field = "F321773E0491C7DAA2BCCE7EB1026979")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "CCC0CA9C3BF559AEB345DEF0A2FF4370", hash_generated_field = "AAD20155A673DB356E6CB0A818206A9F")

    public static final int DEVICE_OUT_EARPIECE = AudioSystem.DEVICE_OUT_EARPIECE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "F2522109F85C4E7CFE66579741552D74", hash_generated_field = "D6227080EB7A997BCE1FA46E8B968DD8")

    public static final int DEVICE_OUT_SPEAKER = AudioSystem.DEVICE_OUT_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "16F9524C7F435733D608D1F7663EFACC", hash_generated_field = "55E7491E06DE5E01ED3B33ABA5AD336F")

    public static final int DEVICE_OUT_WIRED_HEADSET = AudioSystem.DEVICE_OUT_WIRED_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "2CC0E0536A10DD8C43D7B8676290FB2E", hash_generated_field = "1B89915F1B98545F2783E803858F696C")

    public static final int DEVICE_OUT_WIRED_HEADPHONE = AudioSystem.DEVICE_OUT_WIRED_HEADPHONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "109ED2E183CC8FBCA199D582D715C3B9", hash_generated_field = "CE4CF86E062571787BAB33CD873F9233")

    public static final int DEVICE_OUT_BLUETOOTH_SCO = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "79FF18D4D945226665984B63BBABCF68", hash_generated_field = "EEC370A857A75EAA819FF7441AFA8414")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "85A7AE3DDCE90CDB58EBC41226720C80", hash_generated_field = "6220ACBA4790166A2A6FE5A9A1526D27")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_CARKIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "99A9AFDC6BCC3CD96A905677822B20DE", hash_generated_field = "93F1DA1DBC6FA9F31FD9460CBB32E624")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP = AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "DA797B45B712ABA374AF6A3BE520058A", hash_generated_field = "56A1F5C12B7E16CCC85E48AAE7D99AB9")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "E0B9561D56E78A6D2BBCE2F2F9F618BD", hash_generated_field = "FC91812C450C9B07D2EBFCD6DE58B3B4")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "F7CED2811596E0C87A3433945556F74F", hash_generated_field = "337695F485738D53E0DA0ED866F46B0F")

    public static final int DEVICE_OUT_AUX_DIGITAL = AudioSystem.DEVICE_OUT_AUX_DIGITAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "9A826AB0535F62F1A4223EF9DD7D0D04", hash_generated_field = "16C5FBEE95A069FA4DED88AC7221272C")

    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "EE9C1D4491082A0194FC4DE4CDB22421", hash_generated_field = "53732908F8993B64E8D515F061714ED0")

    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.051 -0400", hash_original_field = "164A0FB2C6D42900AB0BC60F3C6EB9D9", hash_generated_field = "98E3296F457805159505EB36AB5F258D")

    public static final int DEVICE_OUT_DEFAULT = AudioSystem.DEVICE_OUT_DEFAULT;
}

