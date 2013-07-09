package android.media;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.986 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.986 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.986 -0400", hash_original_field = "4E3CE2FB89AE8790564F7953A1F5389B", hash_generated_field = "5A0BAF05F67CAB3B2C4D272BECF49076")

    private long mVolumeKeyUpTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.986 -0400", hash_original_field = "00300946A98DC6B5FC615DF24CB1D779", hash_generated_field = "AB49906111B3804858E19BBFBE77F9B2")

    private int mVolumeControlStream = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_field = "9C54D6A91593BF2EC8FCFEB994BBFDE0", hash_generated_field = "55E428528E5E7A11729F2BB805880E0B")

    private HashMap<String, OnAudioFocusChangeListener> mAudioFocusIdListenerMap = new HashMap<String, OnAudioFocusChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_field = "782AAA43CAE2AEE4708C5AF18BCA50BC", hash_generated_field = "94B4DBA462511DBB55ED9EA27E7B7245")

    private final Object mFocusListenerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.987 -0400", hash_original_field = "5892CFFE01680BC3BE5B60DFC7E68A48", hash_generated_field = "B50AA15FB2D552CBF712655325DCFDE6")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.988 -0400", hash_original_field = "05163E3C5F31AC0F871D72347FD33243", hash_generated_field = "F0463229CC92165D569BCDFE5CB835D0")

    private IBinder mICallBack = new Binder();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.988 -0400", hash_original_method = "42BDED457A05AA4B5FB652FAAB5F6EE7", hash_generated_method = "53D81A41BE30830265A3A3C7E43BFA2F")
    public  AudioManager(Context context) {
        mContext = context;
        mHandler = new Handler(context.getMainLooper());
        
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static IAudioService getService() {
        if (sService != null) {
            return sService;
        }
        IBinder b = ServiceManager.getService(Context.AUDIO_SERVICE);
        sService = IAudioService.Stub.asInterface(b);
        return sService;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.989 -0400", hash_original_method = "F1E14361B214327A2A0E751697355D64", hash_generated_method = "934F962B3AE6A69BE7F11B43384397F5")
    public void preDispatchKeyEvent(int keyCode, int stream) {
        {
            boolean varD725F128FDBBDBC4888D495683ADA59A_418830670 = (keyCode != KeyEvent.KEYCODE_VOLUME_DOWN && keyCode != KeyEvent.KEYCODE_VOLUME_UP
                && keyCode != KeyEvent.KEYCODE_VOLUME_MUTE
                && mVolumeKeyUpTime + VolumePanel.PLAY_SOUND_DELAY
                        > SystemClock.uptimeMillis());
            {
                adjustSuggestedStreamVolume(AudioManager.ADJUST_SAME,
                        stream, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            } 
        } 
        addTaint(keyCode);
        addTaint(stream);
        
        
                
                
                        
            
                        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.989 -0400", hash_original_method = "CE7E2CE8B01D9CBEAD319BD036F134E9", hash_generated_method = "2439AD6671F3E5F26D4065B90888FC3B")
    public void handleKeyDown(int keyCode, int stream) {
        
        int flags = FLAG_SHOW_UI | FLAG_VIBRATE;
        
        
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } 
        
        
        adjustSuggestedStreamVolume(
                        keyCode == KeyEvent.KEYCODE_VOLUME_UP
                                ? ADJUST_RAISE
                                : ADJUST_LOWER,
                        stream,
                        flags);
        
        addTaint(keyCode);
        addTaint(stream);
        
        
            
            
                
                
                    
                    
                
                
                        
                                
                                
                        
                        
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.990 -0400", hash_original_method = "4690E566A0F7A4762BD0C4814376C399", hash_generated_method = "375A6D156DBA5909F066F7FC4857C61F")
    public void handleKeyUp(int keyCode, int stream) {
        
        int flags = FLAG_PLAY_SOUND;
        
        
        {
            stream = mVolumeControlStream;
            flags |= FLAG_FORCE_STREAM;
        } 
        
        
        adjustSuggestedStreamVolume(
                        ADJUST_SAME,
                        stream,
                        flags);
        
        
        mVolumeKeyUpTime = SystemClock.uptimeMillis();
        
        addTaint(keyCode);
        addTaint(stream);
        
        
            
            
                
                
                    
                    
                
                
                        
                        
                        
                
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.991 -0400", hash_original_method = "C38595EDF7BD63128B5AA309C4B33E8C", hash_generated_method = "465CDAEF9F43599ACDBEF48E90C581A4")
    public void adjustStreamVolume(int streamType, int direction, int flags) {
        IAudioService service = getService();
        try 
        {
            service.adjustStreamVolume(streamType, direction, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        addTaint(direction);
        addTaint(flags);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.991 -0400", hash_original_method = "C22839B58F1A4FE03A5B8DC3C5604E6D", hash_generated_method = "8B9758A45613053E74664B7209A037FC")
    public void adjustVolume(int direction, int flags) {
        IAudioService service = getService();
        try 
        {
            service.adjustVolume(direction, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(direction);
        addTaint(flags);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.992 -0400", hash_original_method = "A437B9342B9C9807FDB6D5AE81B79F65", hash_generated_method = "C571BD3FE8B2BD203D419DB90DC86F0B")
    public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        IAudioService service = getService();
        try 
        {
            service.adjustSuggestedStreamVolume(direction, suggestedStreamType, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(direction);
        addTaint(suggestedStreamType);
        addTaint(flags);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.992 -0400", hash_original_method = "A5416468537A862277C3CD80415076F6", hash_generated_method = "4482AFB41232813D488CCA52B35F24BB")
    public int getRingerMode() {
        IAudioService service = getService();
        try 
        {
            int var0265EE3720DE05FD1A1C293F7AF4883E_1256757541 = (service.getRingerMode());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016433472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016433472;
        
        
        
            
        
            
            
        
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isValidRingerMode(int ringerMode) {
        if (ringerMode < 0 || ringerMode > RINGER_MODE_MAX) {
            return false;
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.993 -0400", hash_original_method = "87CF12BF10581D3FEA634AA8128A64C7", hash_generated_method = "74BDAEA6FCF1486DCC4EBBAC84A773A2")
    public int getStreamMaxVolume(int streamType) {
        IAudioService service = getService();
        try 
        {
            int varFCCDB31A2F17500880C400E4E2074C92_1397769956 = (service.getStreamMaxVolume(streamType));
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422884245 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422884245;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.993 -0400", hash_original_method = "E78E6899167FF196E0675E8746CEB32F", hash_generated_method = "3054F1F1DCE88CAB608C3BFB5A196DDC")
    public int getStreamVolume(int streamType) {
        IAudioService service = getService();
        try 
        {
            int var4F88A0A8966E778EEDC728EA3FAB0491_1471986809 = (service.getStreamVolume(streamType));
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191378717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1191378717;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.994 -0400", hash_original_method = "16B6103C3931EF2B68A7F288EB86CE17", hash_generated_method = "25767B1FB666A98DCA34B1A8948DB559")
    public int getLastAudibleStreamVolume(int streamType) {
        IAudioService service = getService();
        try 
        {
            int var27F02EDE47E03B5C632EFF5C758045A9_1190953321 = (service.getLastAudibleStreamVolume(streamType));
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166217970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166217970;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.994 -0400", hash_original_method = "3C2FC6CE4E6D1CA9BA044809D37E86F6", hash_generated_method = "52FB8E0DD1DD3B63BE00352D4FC08B18")
    public void setRingerMode(int ringerMode) {
        {
            boolean varCC03F4E2DB9431712F2901B2E0057122_1901201988 = (!isValidRingerMode(ringerMode));
        } 
        IAudioService service = getService();
        try 
        {
            service.setRingerMode(ringerMode);
        } 
        catch (RemoteException e)
        { }
        addTaint(ringerMode);
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.994 -0400", hash_original_method = "3749020B5128F4562E7A795FA2ED06F0", hash_generated_method = "2B8DEF4E35707B52DF99EA1CC4C54E33")
    public void setStreamVolume(int streamType, int index, int flags) {
        IAudioService service = getService();
        try 
        {
            service.setStreamVolume(streamType, index, flags);
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        addTaint(index);
        addTaint(flags);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.995 -0400", hash_original_method = "68979401C5E5A9876842A31A718D3CC1", hash_generated_method = "FC18E0EC87C91B6550FBC69070A149B7")
    public void setStreamSolo(int streamType, boolean state) {
        IAudioService service = getService();
        try 
        {
            service.setStreamSolo(streamType, state, mICallBack);
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        addTaint(state);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.995 -0400", hash_original_method = "D5FC01CA83C5AD93EBE0673BD699E427", hash_generated_method = "791AB6138E351546BC3787E73198A5F8")
    public void setStreamMute(int streamType, boolean state) {
        IAudioService service = getService();
        try 
        {
            service.setStreamMute(streamType, state, mICallBack);
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        addTaint(state);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.996 -0400", hash_original_method = "740B30F7577C3CCB183F4420A2F982C5", hash_generated_method = "D6908152912CECE5DB56BDD82CB25F7E")
    public boolean isStreamMute(int streamType) {
        IAudioService service = getService();
        try 
        {
            boolean var64F9D8692C002372BA2AEB0C83405725_892485814 = (service.isStreamMute(streamType));
        } 
        catch (RemoteException e)
        { }
        addTaint(streamType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905056092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905056092;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.996 -0400", hash_original_method = "7B6A5349C22F082B0BD2BFA86A0EB11D", hash_generated_method = "F0344FF33A696923D229AEAEBE4CF048")
    public void forceVolumeControlStream(int streamType) {
        mVolumeControlStream = streamType;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.996 -0400", hash_original_method = "F2CA732281E7EDA686D9C1A3A9E04423", hash_generated_method = "D7DA7B757D62466676E78DA41E560078")
    public boolean shouldVibrate(int vibrateType) {
        IAudioService service = getService();
        try 
        {
            boolean varF8973DA33ACFA219453A555E62E2AB3F_1498349111 = (service.shouldVibrate(vibrateType));
        } 
        catch (RemoteException e)
        { }
        addTaint(vibrateType);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746888652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746888652;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.997 -0400", hash_original_method = "8D15AC5DC8AF10C8514FCDAE7CA188DE", hash_generated_method = "4E7B29DB5A5AAC8BECE5D8AFECFF400A")
    public int getVibrateSetting(int vibrateType) {
        IAudioService service = getService();
        try 
        {
            int varF37E1046BA5FAE28CC96262CCEACF0AF_322103086 = (service.getVibrateSetting(vibrateType));
        } 
        catch (RemoteException e)
        { }
        addTaint(vibrateType);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200332676 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200332676;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.997 -0400", hash_original_method = "1BAA841F73A90E0BDF1DD9E6546FAE92", hash_generated_method = "0CAAB4528413EB1BD3B3C49A9923D370")
    public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        IAudioService service = getService();
        try 
        {
            service.setVibrateSetting(vibrateType, vibrateSetting);
        } 
        catch (RemoteException e)
        { }
        addTaint(vibrateType);
        addTaint(vibrateSetting);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.997 -0400", hash_original_method = "4CC8C4119BF3E8CF0A2DBE18005271BE", hash_generated_method = "2B65013DFADCDA9F8E3D2DE3C16B1A7B")
    public void setSpeakerphoneOn(boolean on) {
        IAudioService service = getService();
        try 
        {
            service.setSpeakerphoneOn(on);
        } 
        catch (RemoteException e)
        { }
        addTaint(on);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.998 -0400", hash_original_method = "87629A828DADB356D60EBD8A4600C927", hash_generated_method = "6E155BAB7712DFD94975236C7C627C7C")
    public boolean isSpeakerphoneOn() {
        IAudioService service = getService();
        try 
        {
            boolean var87598D078D83248449B547D4AD6978ED_326593385 = (service.isSpeakerphoneOn());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267595457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267595457;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.998 -0400", hash_original_method = "AE17A85066353D3FDC3B454F62E84055", hash_generated_method = "85520EB370359EE7AFB1209DDB13370C")
    public boolean isBluetoothScoAvailableOffCall() {
        boolean var28BBC54E2E2172CDA0560999010643E5_365311815 = (mContext.getResources().getBoolean(
               com.android.internal.R.bool.config_bluetooth_sco_off_call));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_576322697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_576322697;
        
        
               
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.998 -0400", hash_original_method = "7A79304FA4E978214D78F6217FAAF967", hash_generated_method = "65D909E349ED04C3363E4D36A5D0F87C")
    public void startBluetoothSco() {
        IAudioService service = getService();
        try 
        {
            service.startBluetoothSco(mICallBack);
        } 
        catch (RemoteException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.999 -0400", hash_original_method = "CADB6B26FDAB5A2B15E67AB780A2BFA8", hash_generated_method = "B348D95B927B742938387F39752E8FF3")
    public void stopBluetoothSco() {
        IAudioService service = getService();
        try 
        {
            service.stopBluetoothSco(mICallBack);
        } 
        catch (RemoteException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.999 -0400", hash_original_method = "606F2494E176D702B95CCB0A4567DEDE", hash_generated_method = "CB0436D1AC0ADE3CE6F8974EE5943198")
    public void setBluetoothScoOn(boolean on) {
        IAudioService service = getService();
        try 
        {
            service.setBluetoothScoOn(on);
        } 
        catch (RemoteException e)
        { }
        addTaint(on);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.000 -0400", hash_original_method = "F2AF5947C2E51F8D76A34ACBB4A97B98", hash_generated_method = "4A022E188BFD02E77D3E4857DCE8C0A9")
    public boolean isBluetoothScoOn() {
        IAudioService service = getService();
        try 
        {
            boolean varD16DA93890CC6D6662396482754120D6_1114853770 = (service.isBluetoothScoOn());
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669317564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_669317564;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.000 -0400", hash_original_method = "6E721A6BE84D0B991FC9D97F8410EE50", hash_generated_method = "A22C4661A6A1CFE6E9E75075FF7C7D3F")
    @Deprecated
    public void setBluetoothA2dpOn(boolean on) {
        addTaint(on);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.001 -0400", hash_original_method = "61CE342F240529F54025E3EC55BEFF02", hash_generated_method = "C6D2CEA7EDC34702FAFA9DA1898343BC")
    public boolean isBluetoothA2dpOn() {
        {
            boolean varEAC0D32A41CA6AC905ECBAD8C8AE1480_1462002883 = (AudioSystem.getDeviceConnectionState(DEVICE_OUT_BLUETOOTH_A2DP,"")
            == AudioSystem.DEVICE_STATE_UNAVAILABLE);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361356105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361356105;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.001 -0400", hash_original_method = "9CDD23DC97597F87B0409849BA69DD8F", hash_generated_method = "0DF92E1DD80E7C02712C4E6F80598AED")
    @Deprecated
    public void setWiredHeadsetOn(boolean on) {
        addTaint(on);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.002 -0400", hash_original_method = "602A1375ADE38071033B07AD6C9212C8", hash_generated_method = "A3839D6567139AE907AE286320B6916D")
    public boolean isWiredHeadsetOn() {
        {
            boolean var436B2F3F802D0573E5A579194F0921D4_269043686 = (AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADSET,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE &&
            AudioSystem.getDeviceConnectionState(DEVICE_OUT_WIRED_HEADPHONE,"")
                == AudioSystem.DEVICE_STATE_UNAVAILABLE);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901295497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901295497;
        
        
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.003 -0400", hash_original_method = "5FCC6D659A56B470BF76AF68D12DD9BE", hash_generated_method = "DF6E38A9DAEFF01CC0FF67CDB62A417A")
    public void setMicrophoneMute(boolean on) {
        AudioSystem.muteMicrophone(on);
        addTaint(on);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.003 -0400", hash_original_method = "82EFB94D4DB567BF9AF21B9F2B827F69", hash_generated_method = "31CD64DC00788ADA44E86BFAF34CAF27")
    public boolean isMicrophoneMute() {
        boolean var737D58D89436BE5BB1B80F4899D1D4C5_19481825 = (AudioSystem.isMicrophoneMuted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001133039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001133039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.004 -0400", hash_original_method = "FB0F50379150B9BD346003DA9FF4B8A5", hash_generated_method = "5BC2BC5EA6B2535EEE5A191A4ACF4095")
    public void setMode(int mode) {
        IAudioService service = getService();
        try 
        {
            service.setMode(mode, mICallBack);
        } 
        catch (RemoteException e)
        { }
        addTaint(mode);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.004 -0400", hash_original_method = "F6FC0C8FF20094842E05491DBD00A26F", hash_generated_method = "1112719EA76B24A510EE645F36B8D452")
    public int getMode() {
        IAudioService service = getService();
        try 
        {
            int varF42853430CB015AAB3A7FD991D8D0A71_332901381 = (service.getMode());
        } 
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084571374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084571374;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.005 -0400", hash_original_method = "646817F3B93E4871A7A7D1BE098C87AE", hash_generated_method = "E1D8B1DBD2FE79C7D2D08E3E6E28C662")
    @Deprecated
    public void setRouting(int mode, int routes, int mask) {
        addTaint(mode);
        addTaint(routes);
        addTaint(mask);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.005 -0400", hash_original_method = "6C4959DBE0B2C4B0BA15108AAD8EE45D", hash_generated_method = "0D2E214A6C928D38EA00888801BB0804")
    @Deprecated
    public int getRouting(int mode) {
        addTaint(mode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276510328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1276510328;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.005 -0400", hash_original_method = "AF4716567EA0644FB4FB307583193A2C", hash_generated_method = "58B4BDBF56DB81FEAC31570B8EC86516")
    public boolean isMusicActive() {
        boolean var454E243CB980889645FE5E60C7CE53B3_696334808 = (AudioSystem.isStreamActive(STREAM_MUSIC, 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1514815228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1514815228;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.006 -0400", hash_original_method = "FB00D8D09EE0A42D5615E8AEAC323753", hash_generated_method = "5EBEF85316A32D0CAEA6EF64DC131743")
    @Deprecated
    public void setParameter(String key, String value) {
        setParameters(key+"="+value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.006 -0400", hash_original_method = "18224FDA7DBAF634E3113700EF6FFA3D", hash_generated_method = "44C066D14AFE5C4AD57C0B4D5B6CB1F3")
    public void setParameters(String keyValuePairs) {
        AudioSystem.setParameters(keyValuePairs);
        addTaint(keyValuePairs.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.006 -0400", hash_original_method = "9B4E69B0951CD7555E74053B3F2A7F5E", hash_generated_method = "AAA168A94D204906FD7FCF280F7AB295")
    public String getParameters(String keys) {
        String varB4EAC82CA7396A68D541C85D26508E83_401607986 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_401607986 = AudioSystem.getParameters(keys);
        addTaint(keys.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_401607986.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_401607986;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.007 -0400", hash_original_method = "68694F707C94BF6E0AD2DC63190ED9B5", hash_generated_method = "0D75A75D2F03359CF3691BD13C77F675")
    public void playSoundEffect(int effectType) {
        {
            boolean var4EBE86F0D61A6E6B6BD9C7B99A8C271C_950382801 = (!querySoundEffectsEnabled());
        } 
        IAudioService service = getService();
        try 
        {
            service.playSoundEffect(effectType);
        } 
        catch (RemoteException e)
        { }
        addTaint(effectType);
        
        
            
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.007 -0400", hash_original_method = "F681C40806C862BA65FB1368E5E3540A", hash_generated_method = "F07AC74CF82AAEDC056F2DB540DDBFC0")
    public void playSoundEffect(int effectType, float volume) {
        IAudioService service = getService();
        try 
        {
            service.playSoundEffectVolume(effectType, volume);
        } 
        catch (RemoteException e)
        { }
        addTaint(effectType);
        addTaint(volume);
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.008 -0400", hash_original_method = "91B9C921984750C333F4A3D84250AE14", hash_generated_method = "4CAB7042028B505191D0AD3482CDE04E")
    private boolean querySoundEffectsEnabled() {
        boolean varC6898D694DDE6B1CE555B5FF02F0D604_444976256 = (Settings.System.getInt(mContext.getContentResolver(), Settings.System.SOUND_EFFECTS_ENABLED, 0) != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57259964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57259964;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.008 -0400", hash_original_method = "A7E0D93492C6E9A5A55D1B76418A0B14", hash_generated_method = "351D311DA1A5561CA7AAE5CBCD17FE4E")
    public void loadSoundEffects() {
        IAudioService service = getService();
        try 
        {
            service.loadSoundEffects();
        } 
        catch (RemoteException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.008 -0400", hash_original_method = "43A5029AD1D52804D92188712F1A67B5", hash_generated_method = "8484DBDCCEA3FDD7E53D85DD4197470F")
    public void unloadSoundEffects() {
        IAudioService service = getService();
        try 
        {
            service.unloadSoundEffects();
        } 
        catch (RemoteException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.009 -0400", hash_original_method = "19FA7B2AF0BC01FED1DAA16E011C492D", hash_generated_method = "A836D1F03BEDBA5B4ACF6B49F14513CD")
    private OnAudioFocusChangeListener findFocusListener(String id) {
        OnAudioFocusChangeListener varB4EAC82CA7396A68D541C85D26508E83_1540539653 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1540539653 = mAudioFocusIdListenerMap.get(id);
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1540539653.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1540539653;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.010 -0400", hash_original_method = "F0553D3D8E69373BA6CE7B065E0EBE95", hash_generated_method = "5DE219DD0CAEC4A836D4E1D743098AF8")
    private String getIdForAudioFocusListener(OnAudioFocusChangeListener l) {
        String varB4EAC82CA7396A68D541C85D26508E83_136992278 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_916997769 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_136992278 = new String(this.toString());
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_916997769 = new String(this.toString() + l.toString());
        } 
        addTaint(l.getTaint());
        String varA7E53CE21691AB073D9660D615818899_241156330; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_241156330 = varB4EAC82CA7396A68D541C85D26508E83_136992278;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_241156330 = varB4EAC82CA7396A68D541C85D26508E83_916997769;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_241156330.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_241156330;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.010 -0400", hash_original_method = "C22DD0E9B28263E867F443548BB38A4B", hash_generated_method = "7BA7D01381AB43A0C27A6F977D5EE611")
    public void registerAudioFocusListener(OnAudioFocusChangeListener l) {
        
        {
            {
                boolean varED576F6536DA5AC2AA8A2B585F375863_240377958 = (mAudioFocusIdListenerMap.containsKey(getIdForAudioFocusListener(l)));
            } 
            mAudioFocusIdListenerMap.put(getIdForAudioFocusListener(l), l);
        } 
        addTaint(l.getTaint());
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.011 -0400", hash_original_method = "A69B5FF5652C2B6DCC8DE23DBE317A35", hash_generated_method = "68D9CB2147E0CDE938B4760C6B66417B")
    public void unregisterAudioFocusListener(OnAudioFocusChangeListener l) {
        {
            mAudioFocusIdListenerMap.remove(getIdForAudioFocusListener(l));
        } 
        addTaint(l.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.012 -0400", hash_original_method = "15F0A18D8B83DF0E5C3CD27FFCEED082", hash_generated_method = "C3A489C7858CDD0BA19349AA22871D5A")
    public int requestAudioFocus(OnAudioFocusChangeListener l, int streamType, int durationHint) {
        int status = AUDIOFOCUS_REQUEST_FAILED;
        registerAudioFocusListener(l);
        IAudioService service = getService();
        try 
        {
            status = service.requestAudioFocus(streamType, durationHint, mICallBack,
                    mAudioFocusDispatcher, getIdForAudioFocusListener(l),
                    mContext.getPackageName() );
        } 
        catch (RemoteException e)
        { }
        addTaint(l.getTaint());
        addTaint(streamType);
        addTaint(durationHint);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745282157 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1745282157;
        
        
        
        
            
            
        
        
        
        
            
                    
                    
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.013 -0400", hash_original_method = "32D2590B7FC8AFB5DC09D66E2CA73EB1", hash_generated_method = "F2C89B1863378A987FE9BC1341CF259D")
    public int abandonAudioFocus(OnAudioFocusChangeListener l) {
        int status = AUDIOFOCUS_REQUEST_FAILED;
        unregisterAudioFocusListener(l);
        IAudioService service = getService();
        try 
        {
            status = service.abandonAudioFocus(mAudioFocusDispatcher,
                    getIdForAudioFocusListener(l));
        } 
        catch (RemoteException e)
        { }
        addTaint(l.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684014955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684014955;
        
        
        
        
        
            
                    
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.014 -0400", hash_original_method = "50EC2C592ADEFE7D217B837E9C2D3748", hash_generated_method = "E100C59CDCBD59046AAF0C7EEE41ECFC")
    public void registerMediaButtonEventReceiver(ComponentName eventReceiver) {
        
        {
            boolean varC555D2093F680D7AB7ABB6EF095D9D3C_1479947543 = (!eventReceiver.getPackageName().equals(mContext.getPackageName()));
        } 
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
                0, mediaButtonIntent, 0);
        registerMediaButtonIntent(pi, eventReceiver);
        addTaint(eventReceiver.getTaint());
        
        
            
        
        
            
                    
            
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.014 -0400", hash_original_method = "F3457417B719B94CC07450473FCEA34B", hash_generated_method = "C9C7A30F2CE88B33AD1E1BAB13352FD0")
    public void registerMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        
        IAudioService service = getService();
        try 
        {
            service.registerMediaButtonIntent(pi, eventReceiver);
        } 
        catch (RemoteException e)
        { }
        addTaint(pi.getTaint());
        addTaint(eventReceiver.getTaint());
        
        
            
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.015 -0400", hash_original_method = "50FCC009A55C4B527D3EADAFCCF926C2", hash_generated_method = "0E5B5824FE66BC47542E19690245A459")
    public void unregisterMediaButtonEventReceiver(ComponentName eventReceiver) {
        Intent mediaButtonIntent = new Intent(Intent.ACTION_MEDIA_BUTTON);
        mediaButtonIntent.setComponent(eventReceiver);
        PendingIntent pi = PendingIntent.getBroadcast(mContext,
                0, mediaButtonIntent, 0);
        unregisterMediaButtonIntent(pi, eventReceiver);
        addTaint(eventReceiver.getTaint());
        
        
            
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.015 -0400", hash_original_method = "FD1680BE817579074A9AB3657CE1A622", hash_generated_method = "A9692DF8CB8841F2424CF8E159F192C2")
    public void unregisterMediaButtonIntent(PendingIntent pi, ComponentName eventReceiver) {
        IAudioService service = getService();
        try 
        {
            service.unregisterMediaButtonIntent(pi, eventReceiver);
        } 
        catch (RemoteException e)
        { }
        addTaint(pi.getTaint());
        addTaint(eventReceiver.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.016 -0400", hash_original_method = "226F7C4DEEA463C35DD22DDAE8FCA983", hash_generated_method = "54FC05341EF13B00F1EBDDB8B6208F09")
    public void registerRemoteControlClient(RemoteControlClient rcClient) {
        
        {
            boolean varB5E6ECFDFA3896796F661CCDFBFE1678_237008662 = ((rcClient == null) || (rcClient.getRcMediaIntent() == null));
        } 
        IAudioService service = getService();
        try 
        {
            service.registerRemoteControlClient(rcClient.getRcMediaIntent(),   
                    rcClient.getIRemoteControlClient(),                        
                    mContext.getPackageName());
        } 
        catch (RemoteException e)
        { }
        addTaint(rcClient.getTaint());
        
        
            
        
        
        
            
                    
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.016 -0400", hash_original_method = "61965062F9C113F5A501568B9F9D00FE", hash_generated_method = "554F459AB7D759079512181E9C9D28D6")
    public void unregisterRemoteControlClient(RemoteControlClient rcClient) {
        {
            boolean varB5E6ECFDFA3896796F661CCDFBFE1678_600912368 = ((rcClient == null) || (rcClient.getRcMediaIntent() == null));
        } 
        IAudioService service = getService();
        try 
        {
            service.unregisterRemoteControlClient(rcClient.getRcMediaIntent(), 
                    rcClient.getIRemoteControlClient());
        } 
        catch (RemoteException e)
        { }
        addTaint(rcClient.getTaint());
        
        
            
        
        
        
            
                    
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.016 -0400", hash_original_method = "F5BDE54913D135C31C9BD838A5D1535F", hash_generated_method = "7E5ADAB9D208ED216D191AB0E6119068")
    public void registerRemoteControlDisplay(IRemoteControlDisplay rcd) {
        
        IAudioService service = getService();
        try 
        {
            service.registerRemoteControlDisplay(rcd);
        } 
        catch (RemoteException e)
        { }
        addTaint(rcd.getTaint());
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.017 -0400", hash_original_method = "0BDA4E172FD98A7582B88621FA3E6CCD", hash_generated_method = "3F5EB7FFA57B631B1198CFA22BDAE058")
    public void unregisterRemoteControlDisplay(IRemoteControlDisplay rcd) {
        IAudioService service = getService();
        try 
        {
            service.unregisterRemoteControlDisplay(rcd);
        } 
        catch (RemoteException e)
        { }
        addTaint(rcd.getTaint());
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.017 -0400", hash_original_method = "2551461E9D10B148584E49E52F82D704", hash_generated_method = "D92745D0C4125FC2D9847FD107416397")
    public void remoteControlDisplayUsesBitmapSize(IRemoteControlDisplay rcd, int w, int h) {
        IAudioService service = getService();
        try 
        {
            service.remoteControlDisplayUsesBitmapSize(rcd, w, h);
        } 
        catch (RemoteException e)
        { }
        addTaint(rcd.getTaint());
        addTaint(w);
        addTaint(h);
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.017 -0400", hash_original_method = "CCB01AEEA7F61A25F19F08696D9B58D5", hash_generated_method = "8E26CCD8AE45B89624A38ED8BD5472C9")
    public void reloadAudioSettings() {
        IAudioService service = getService();
        try 
        {
            service.reloadAudioSettings();
        } 
        catch (RemoteException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.018 -0400", hash_original_method = "0E7D5155727C2E176622AABD0BAF6345", hash_generated_method = "20DCF3D51C1D855227DE5D5C8E99361F")
    public boolean isSilentMode() {
        int ringerMode = getRingerMode();
        boolean silentMode = (ringerMode == RINGER_MODE_SILENT) ||
            (ringerMode == RINGER_MODE_VIBRATE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_741332127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_741332127;
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.018 -0400", hash_original_method = "039E984EE545D8462E074EC6768B62D9", hash_generated_method = "0CCE4BC813FF8D72FA08E91174D0A0C7")
    public int getDevicesForStream(int streamType) {
        
        int var62CA9E8E5CFD4E876A4269DEBC806814_47278644 = (AudioSystem.getDevicesForStream(streamType));
        
        addTaint(streamType);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189174035 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189174035;
        
        
        
        
        
        
        
        
        
            
        
            
        
    }

    
    private class FocusEventHandlerDelegate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.018 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.019 -0400", hash_original_method = "655176F98C4DE876C8B3DFC6C8BC6CB4", hash_generated_method = "C0A5C843ADBE893337096F1F7DCD4608")
          FocusEventHandlerDelegate() {
            Looper looper;
            {
                boolean varE905F74B73C9447F656F9E57A8E7CAD4_923617638 = ((looper = Looper.myLooper()) == null);
                {
                    looper = Looper.getMainLooper();
                } 
            } 
            {
                mHandler = new Handler(looper) {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.019 -0400", hash_original_method = "30B5FC3AB937951C0E4F92A6F6EC4647", hash_generated_method = "23EFE528F5DEBE90332324FA6CF39CFC")
                    @Override
                    public void handleMessage(Message msg) {
                        OnAudioFocusChangeListener listener = null;
                        {
                            listener = findFocusListener((String)msg.obj);
                        } 
                        {
                            listener.onAudioFocusChange(msg.what);
                        } 
                        addTaint(msg.getTaint());
                        
                        
                        
                            
                        
                        
                            
                        
                    }
};
            } 
            {
                mHandler = null;
            } 
            
            
            
                
            
            
                
                    
                    
                        
                        
                            
                        
                        
                            
                        
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.020 -0400", hash_original_method = "10E7D4FA7AE5C5A4DFE91478AE111D01", hash_generated_method = "29536E3AF83BA457DDBAC562FF8B2D83")
         Handler getHandler() {
            Handler varB4EAC82CA7396A68D541C85D26508E83_902991881 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_902991881 = mHandler;
            varB4EAC82CA7396A68D541C85D26508E83_902991881.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_902991881;
            
            
        }

        
    }


    
    public interface OnAudioFocusChangeListener {
        
        public void onAudioFocusChange(int focusChange);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.020 -0400", hash_original_field = "20E83A9306A5736CFA1BB1457A466EF8", hash_generated_field = "EA464CE610E64C107F0AE63BEF486884")

    private static String TAG = "AudioManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.020 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "318E208AAF5321A27E7D01AA2760853C")

    private static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.020 -0400", hash_original_field = "2CAC9A13987ECF08A4F21FF3E2AD9AA1", hash_generated_field = "3B419F3B582C47DDFE050BC2915123CA")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_AUDIO_BECOMING_NOISY = "android.media.AUDIO_BECOMING_NOISY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "17C28C44CEAE0BF97AC9310674064704", hash_generated_field = "82FD8649C65A8CF3532DA13370F1BA7D")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String RINGER_MODE_CHANGED_ACTION = "android.media.RINGER_MODE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "15A7E500864B92D6FF20750A6FA9A577", hash_generated_field = "224A6B231CEB60121D4D26857CDB53A5")

    public static final String EXTRA_RINGER_MODE = "android.media.EXTRA_RINGER_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "227F431D50F5817EAAB380A042DB346A", hash_generated_field = "CACD1A5245F7950B257F0D4DBC5F7355")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VIBRATE_SETTING_CHANGED_ACTION = "android.media.VIBRATE_SETTING_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "B243DADF41954501A46800A7800E1DA5", hash_generated_field = "BC5B119582962733F44A97FF95D9FFE5")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "CE6052DBACAB0AE1831D4853F0AECC26", hash_generated_field = "51E87800B3F480A44745265DB1A8B0A3")

    public static final String EXTRA_VIBRATE_SETTING = "android.media.EXTRA_VIBRATE_SETTING";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "ADA1BE4E3A6978DB31C683793AE4481B", hash_generated_field = "A915326453E39AE5D00D8FC37F9C4409")

    public static final String EXTRA_VIBRATE_TYPE = "android.media.EXTRA_VIBRATE_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "C1EECBA689575E3C34E5A67024E19C7A", hash_generated_field = "9FD0D907F0CD51DF1DB106EECBD6E9C3")

    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "AEF75AEF62FC34E183FF2D96906B966F", hash_generated_field = "9349DEF2B660FADDEEF1B5E130A7E048")

    public static final String EXTRA_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_VOLUME_STREAM_VALUE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "FA373E51FA4D25A4E7161C341AD7D848", hash_generated_field = "526505C0CAFCE5C52F34243604D6DCFA")

    public static final String EXTRA_PREV_VOLUME_STREAM_VALUE =
        "android.media.EXTRA_PREV_VOLUME_STREAM_VALUE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "59EC91962EF1D3EC8C41C6309A452FBE", hash_generated_field = "31DA6CA9D350A5C1500EAB368D53C36E")

    public static final int STREAM_VOICE_CALL = AudioSystem.STREAM_VOICE_CALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "353606BAF4270D751D34A47A56EFCA37", hash_generated_field = "4E6B4BD7DB17D08DD4B7DA5B936BD4D4")

    public static final int STREAM_SYSTEM = AudioSystem.STREAM_SYSTEM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "CC7ED0932A6B434F8074BBBBEBF940CA", hash_generated_field = "7E52EEF3A9F3F78B8DB4024C9ABD30A9")

    public static final int STREAM_RING = AudioSystem.STREAM_RING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "0B8CEC57305FB97A2E9286FD498663E0", hash_generated_field = "EED8B59EA13FC4896CC2F9343483263F")

    public static final int STREAM_MUSIC = AudioSystem.STREAM_MUSIC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "AD4E7B71860075F45694B4F65EE85888", hash_generated_field = "E333B8A140BD1179FF221381CD837DFE")

    public static final int STREAM_ALARM = AudioSystem.STREAM_ALARM;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "C746226985B06CF152DD08D86B1A48FB", hash_generated_field = "71EF53B6668807C856EFBEF9825ECFA0")

    public static final int STREAM_NOTIFICATION = AudioSystem.STREAM_NOTIFICATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "0D9F20F7953EBE3F4691A8230C7BB6BE", hash_generated_field = "D735EBDC384DC7A926CBC88947191DB1")

    public static final int STREAM_BLUETOOTH_SCO = AudioSystem.STREAM_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "917E4BDDCC7FFFB079C7B216A5E826DB", hash_generated_field = "915B268BBDC4A53AC54878DC5E88D5A3")

    public static final int STREAM_SYSTEM_ENFORCED = AudioSystem.STREAM_SYSTEM_ENFORCED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "3FA2FC7BE21478756A033EF8796586F8", hash_generated_field = "50AD1DD144B476A92BCF3C54F214BBF7")

    public static final int STREAM_DTMF = AudioSystem.STREAM_DTMF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "03B915D9001E24DCD7B90E82D802741B", hash_generated_field = "0367B1DD22E5CBAA04B4868362ADCDD8")

    public static final int STREAM_TTS = AudioSystem.STREAM_TTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "9C0700F5CF15600949BCBC65F16381BC", hash_generated_field = "EFF9B2522110CD0C7A7477D89D0693A1")

    @Deprecated public static final int NUM_STREAMS = AudioSystem.NUM_STREAMS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "FD4A9FEFFFF4D4D46C2745C68B1B8CB1", hash_generated_field = "F45CC9A685E67B21A51ED114CC84665E")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "4369B3D8B267DD6B732B986B985447F8", hash_generated_field = "39E2EEE47548F14D86DF84B8B634D67C")

    public static final int ADJUST_RAISE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "44961653BCF592271048000C377DF719", hash_generated_field = "06BE000BF1CE74FF300973D26EDD9CCC")

    public static final int ADJUST_LOWER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "35EBD0A111CA75C2426D193AC686EB6C", hash_generated_field = "790B73E28F46DC84449E1CC5892A2D1D")

    public static final int ADJUST_SAME = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "DF56CA398A1570CBC3AE853122FC6F8F", hash_generated_field = "C01617A7FF540256CD5CD3CC52836403")

    public static final int FLAG_SHOW_UI = 1 << 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "933BFB90A3906EA8604A691D840AABE4", hash_generated_field = "EDBE1C6A970E116625702809E63BF00C")

    public static final int FLAG_ALLOW_RINGER_MODES = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "A226CB027D327C98F643AF2990719CAE", hash_generated_field = "1D52CF8A5130FFDCD6B413FE5A64D5C4")

    public static final int FLAG_PLAY_SOUND = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "61659A98C678003C9CB737153D502047", hash_generated_field = "FD125539FD3EE63843F3520B6EE0274B")

    public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "55EC8B98515734A742EA5E1946F1AF77", hash_generated_field = "2B2FC04AD3CAEDF49651FD851423D6C4")

    public static final int FLAG_VIBRATE = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "F05F53A5BDE50D8B1078BB7714FEA07F", hash_generated_field = "45725751A8AF13B150CECD05C3003DC1")

    public static final int FLAG_FORCE_STREAM = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.021 -0400", hash_original_field = "16B9184BFB8526ED96AD7FF1A669DC9B", hash_generated_field = "168D021BDAA46D07A61D7B1EBCDDB53C")

    public static final int RINGER_MODE_SILENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "9B2462E65AFA10B2613D5D49DF8DB5B7", hash_generated_field = "F3C65C70B216A9A16710313BAFE6E5BB")

    public static final int RINGER_MODE_VIBRATE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "99BEB41D7543DEE5869A50F8BFDC0E8B", hash_generated_field = "91CA816E423F22422D47B3B82C943A68")

    public static final int RINGER_MODE_NORMAL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "E636C5A1A36D2F4A1D37F3AFC423325F", hash_generated_field = "46620B2E8AE72554737A1DFE483BB5C5")

    private static final int RINGER_MODE_MAX = RINGER_MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "79C58357D9362F257B943BE01A6348A4", hash_generated_field = "A7E9F8C96B6DB2781912159B457B77B2")

    public static final int VIBRATE_TYPE_RINGER = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "8486D7FD8D3C52B58BCFEF0870550E60", hash_generated_field = "E39C772C4AD66D76048A1561BA2537C0")

    public static final int VIBRATE_TYPE_NOTIFICATION = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "92DAEB9EE6C8304034553D2280376FB1", hash_generated_field = "97CBF0237199BFD95F4B3796B121DB7A")

    public static final int VIBRATE_SETTING_OFF = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "62B9C9C5956ABCDD1F44ABF9D31BAC93", hash_generated_field = "36A1A77239700641916E355FAE6C05CC")

    public static final int VIBRATE_SETTING_ON = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "128911C0F3321F65FE0B471E62F432D6", hash_generated_field = "49863BA7BB9B018EBD15616831E16BF7")

    public static final int VIBRATE_SETTING_ONLY_SILENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "259604552E875A882D7CD8E2CFF250B1", hash_generated_field = "07C5C486F2A741CB9A37D58EAD3271C6")

    public static final int USE_DEFAULT_STREAM_TYPE = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "7D19457E3AE9FEB13C4F40FE79C55E2E")

    private static IAudioService sService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "8C24ADBCB61F74CDE77492B1CBF403AF", hash_generated_field = "BDEA2A70E495CBAF5E748EF9975DCC87")

    @Deprecated
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_CHANGED =
            "android.media.SCO_AUDIO_STATE_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "524A0ECB2DB96281CD4264B117FE641E", hash_generated_field = "F3166319F9207DF19FD2E9CFDAAA5A72")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_SCO_AUDIO_STATE_UPDATED =
            "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "1C3E80947497049DC037CB0D864CC77C", hash_generated_field = "32FA7228E6E3D4D2E77A75BF18A610E6")

    public static final String EXTRA_SCO_AUDIO_STATE =
            "android.media.extra.SCO_AUDIO_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "6F620FD78C54945860CB0CFDE74529FF", hash_generated_field = "0622BB79817581AD352373308DBDB593")

    public static final String EXTRA_SCO_AUDIO_PREVIOUS_STATE =
            "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "42F8D6364B79DE1DF57D4543785B23CE", hash_generated_field = "5E74ACBB33EE191822BB57DF0F81B6B2")

    public static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "5852539169E023A39E0550FAB5C0E899", hash_generated_field = "AE5318710A7CFA0C1F39C3D317710563")

    public static final int SCO_AUDIO_STATE_CONNECTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "7E3CD44B473759B6D1B7498096D64FFD", hash_generated_field = "304672883C84724BF04B4DA579DFE5FC")

    public static final int SCO_AUDIO_STATE_CONNECTING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "EC097514B0EFCFE6FB926A81B71D0CBD", hash_generated_field = "F47DB376AA7C1FD07279222484B48ABF")

    public static final int SCO_AUDIO_STATE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "644777789892DC36D49149F7CB0C389F", hash_generated_field = "DB75CEE8F475CAED7AAA62F911E832A0")

    public static final int MODE_INVALID            = AudioSystem.MODE_INVALID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "DEFA6D18C225BB4385AA482511E43789", hash_generated_field = "259EA8BFEB6837EF7E97885CAC8959D1")

    public static final int MODE_CURRENT            = AudioSystem.MODE_CURRENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "3E937BB56F82A43A57DF3C5CD2AE2B52", hash_generated_field = "E42A9AACEEEF54C680DA2CB0F408B1AB")

    public static final int MODE_NORMAL             = AudioSystem.MODE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "614FB074CC7B1B4C87AD6086C8C9F2D7", hash_generated_field = "EE90B81F058177AB332C6C3C562A5933")

    public static final int MODE_RINGTONE           = AudioSystem.MODE_RINGTONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "F33DCDE6C1F90E40DC81EEAA7876AADC", hash_generated_field = "4CF349F6E441825259B2E10E96F041E3")

    public static final int MODE_IN_CALL            = AudioSystem.MODE_IN_CALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "564760EA2F04F056C7576F8FE76FF546", hash_generated_field = "434899DAA6585E4FD846D710E77D536B")

    public static final int MODE_IN_COMMUNICATION   = AudioSystem.MODE_IN_COMMUNICATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "BDC5B3E9254860F141747721B008B9AD", hash_generated_field = "70B8E8324A943FB211827626305D7B34")

    @Deprecated public static final int ROUTE_EARPIECE          = AudioSystem.ROUTE_EARPIECE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "7461F34B55FA346564FDAF53FB906403", hash_generated_field = "E2FDF0262BFAC843B291B6443B31346A")

    @Deprecated public static final int ROUTE_SPEAKER           = AudioSystem.ROUTE_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "62AA483272C57D745DC764F25FEF9438", hash_generated_field = "E9BBBA7FC483766285967936E5E858BE")

    @Deprecated public static final int ROUTE_BLUETOOTH = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.022 -0400", hash_original_field = "806C425814A4EEF020E90CBF85BAE6A4", hash_generated_field = "3C9DBD8E86562E2D420F48D99E3AF6C7")

    @Deprecated public static final int ROUTE_BLUETOOTH_SCO     = AudioSystem.ROUTE_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "31D5238382125794C2C59C90EF6A470A", hash_generated_field = "9A404516ED0F3D498C08B7D46BA009B8")

    @Deprecated public static final int ROUTE_HEADSET           = AudioSystem.ROUTE_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "6A972EA7E913FD6C86FB203D38E563AF", hash_generated_field = "1083E9F1E7B36963C23113631B1A07AE")

    @Deprecated public static final int ROUTE_BLUETOOTH_A2DP    = AudioSystem.ROUTE_BLUETOOTH_A2DP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "5F1267777916EB1D20E4F75A2B7BCF23", hash_generated_field = "A433F5AE2654D66600E8F02A7060BE7D")

    @Deprecated public static final int ROUTE_ALL               = AudioSystem.ROUTE_ALL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "2D75E5724D70089E18CE209567FCB80F", hash_generated_field = "61871C08102B2C27DE0A6A884FBD04C8")

    public static final int FX_KEY_CLICK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "027B2A93F2BD757F05FACE4B2D9B6E21", hash_generated_field = "9B1C422735AA23C6564D3A25E067CCCD")

    public static final int FX_FOCUS_NAVIGATION_UP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "9620C0422DE0CFB6F98F7E4CB8C4BE48", hash_generated_field = "236FF916CEC7EE68DAA532ED561496C7")

    public static final int FX_FOCUS_NAVIGATION_DOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "B44092AD653E0AAC0247D6680774F2D2", hash_generated_field = "CAA9DED10A96B1789EB8A05BCEA06EC3")

    public static final int FX_FOCUS_NAVIGATION_LEFT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "8D26157BCDCB5FE10B720B8A1B8508FF", hash_generated_field = "507E5ACB5A3B0B2C1461339C057377B4")

    public static final int FX_FOCUS_NAVIGATION_RIGHT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "62F0219F5A77C725E4AB3EA9F53950BA", hash_generated_field = "F5ED1ACF7069D4ADA865EA192688F916")

    public static final int FX_KEYPRESS_STANDARD = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "4877111153D3F7C9A29A741A4821AAC0", hash_generated_field = "7F35EE68E6EF23414295B81D6D5519E8")

    public static final int FX_KEYPRESS_SPACEBAR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "12672196F423D4B7A5453301DBBE6239", hash_generated_field = "7F15B1B0A87277F3E076311AB3C08BE4")

    public static final int FX_KEYPRESS_DELETE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "7D576AD51AC10382259E36A7EF776FD6", hash_generated_field = "C665DE812B57F58CB0283896A6829103")

    public static final int FX_KEYPRESS_RETURN = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "55CB94C882E45652B87258C68EA47887", hash_generated_field = "64E2DFA9698F8C924F1476F0A0C29567")

    public static final int NUM_SOUND_EFFECTS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "A7FEA4266BA74E9BAA3E58B43E875A60", hash_generated_field = "322B7C042AB9183F8D195E48CE22838E")

    public static final int AUDIOFOCUS_GAIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "07DFBF69A40F15A979FF33F093B5BC6B", hash_generated_field = "BB6569D7168A2B68AC704A047DCB1B3D")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "A2DEA6C2EBC4F7D685910D6096EE3423", hash_generated_field = "261801A1158E5414AFF80E5C998CDA23")

    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "D66FC19054A8C84C11E536F9BF22BF56", hash_generated_field = "1FDFD24111A3D8158394B4436A3323CC")

    public static final int AUDIOFOCUS_LOSS = -1 * AUDIOFOCUS_GAIN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "AD7FCADF3EF773A2ADBCC97D0554EAEC", hash_generated_field = "7CC773DE0572889733DA498CCA178236")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT = -1 * AUDIOFOCUS_GAIN_TRANSIENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "67EAA4247C3D9DD9FA8094672616CD79", hash_generated_field = "9CC322B2833D90555FD6EC3A873AF969")

    public static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK =
            -1 * AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "10B706C9ED9929AAB401BF66E26D2750", hash_generated_field = "D8A159EEDAE6693D921247329EA8C396")

    public static final int AUDIOFOCUS_REQUEST_FAILED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "7E9672199FB289A94FD9A4696CA773A3", hash_generated_field = "1FD5D2DAD8907D4E83DD8E910708874E")

    public static final int AUDIOFOCUS_REQUEST_GRANTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "1D03745B75D1995B06588647E586B8C1", hash_generated_field = "E4DDE7D9421C2AEC76D663CBDE2815AB")

    public static final String REMOTE_CONTROL_CLIENT_CHANGED =
            "android.media.REMOTE_CONTROL_CLIENT_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "B46E0BCF54E768E039E84F8581DE6E8F", hash_generated_field = "33E4E0F43F4DCCA5D8A75610CF8E15D6")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_GENERATION =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_GENERATION";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "3236807831D320ECADF902F72DBD2617", hash_generated_field = "A1AE731951F7414BC47CA9F114761CCE")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_NAME =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "C69AEFB0A9C79886FEBB755902162286", hash_generated_field = "3CB942DE68C520A2E338E02E7BF82DCE")

    public static final String EXTRA_REMOTE_CONTROL_EVENT_RECEIVER =
            "android.media.EXTRA_REMOTE_CONTROL_EVENT_RECEIVER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "A42BEA1653473123D3004DB945EF3AB1", hash_generated_field = "F321773E0491C7DAA2BCCE7EB1026979")

    public static final String EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED =
            "android.media.EXTRA_REMOTE_CONTROL_CLIENT_INFO_CHANGED";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "CCC0CA9C3BF559AEB345DEF0A2FF4370", hash_generated_field = "AAD20155A673DB356E6CB0A818206A9F")

    public static final int DEVICE_OUT_EARPIECE = AudioSystem.DEVICE_OUT_EARPIECE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "F2522109F85C4E7CFE66579741552D74", hash_generated_field = "D6227080EB7A997BCE1FA46E8B968DD8")

    public static final int DEVICE_OUT_SPEAKER = AudioSystem.DEVICE_OUT_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "16F9524C7F435733D608D1F7663EFACC", hash_generated_field = "55E7491E06DE5E01ED3B33ABA5AD336F")

    public static final int DEVICE_OUT_WIRED_HEADSET = AudioSystem.DEVICE_OUT_WIRED_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "2CC0E0536A10DD8C43D7B8676290FB2E", hash_generated_field = "1B89915F1B98545F2783E803858F696C")

    public static final int DEVICE_OUT_WIRED_HEADPHONE = AudioSystem.DEVICE_OUT_WIRED_HEADPHONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "109ED2E183CC8FBCA199D582D715C3B9", hash_generated_field = "CE4CF86E062571787BAB33CD873F9233")

    public static final int DEVICE_OUT_BLUETOOTH_SCO = AudioSystem.DEVICE_OUT_BLUETOOTH_SCO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "79FF18D4D945226665984B63BBABCF68", hash_generated_field = "EEC370A857A75EAA819FF7441AFA8414")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_HEADSET =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.023 -0400", hash_original_field = "85A7AE3DDCE90CDB58EBC41226720C80", hash_generated_field = "6220ACBA4790166A2A6FE5A9A1526D27")

    public static final int DEVICE_OUT_BLUETOOTH_SCO_CARKIT =
            AudioSystem.DEVICE_OUT_BLUETOOTH_SCO_CARKIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "99A9AFDC6BCC3CD96A905677822B20DE", hash_generated_field = "93F1DA1DBC6FA9F31FD9460CBB32E624")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP = AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "DA797B45B712ABA374AF6A3BE520058A", hash_generated_field = "56A1F5C12B7E16CCC85E48AAE7D99AB9")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "E0B9561D56E78A6D2BBCE2F2F9F618BD", hash_generated_field = "FC91812C450C9B07D2EBFCD6DE58B3B4")

    public static final int DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER =
            AudioSystem.DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "F7CED2811596E0C87A3433945556F74F", hash_generated_field = "337695F485738D53E0DA0ED866F46B0F")

    public static final int DEVICE_OUT_AUX_DIGITAL = AudioSystem.DEVICE_OUT_AUX_DIGITAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "9A826AB0535F62F1A4223EF9DD7D0D04", hash_generated_field = "16C5FBEE95A069FA4DED88AC7221272C")

    public static final int DEVICE_OUT_ANLG_DOCK_HEADSET = AudioSystem.DEVICE_OUT_ANLG_DOCK_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "EE9C1D4491082A0194FC4DE4CDB22421", hash_generated_field = "53732908F8993B64E8D515F061714ED0")

    public static final int DEVICE_OUT_DGTL_DOCK_HEADSET = AudioSystem.DEVICE_OUT_DGTL_DOCK_HEADSET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.024 -0400", hash_original_field = "164A0FB2C6D42900AB0BC60F3C6EB9D9", hash_generated_field = "98E3296F457805159505EB36AB5F258D")

    public static final int DEVICE_OUT_DEFAULT = AudioSystem.DEVICE_OUT_DEFAULT;
}

