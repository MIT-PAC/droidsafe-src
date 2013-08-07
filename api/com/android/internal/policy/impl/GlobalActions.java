package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import com.android.internal.telephony.TelephonyIntents;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.util.Log;
import android.os.Message;
import android.view.WindowManager;
import android.view.View;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.app.Activity;
import com.android.internal.telephony.TelephonyProperties;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import android.os.Handler;
import android.telephony.ServiceState;
import com.google.android.collect.Lists;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.os.SystemProperties;
import android.telephony.PhoneStateListener;
import android.widget.BaseAdapter;
import android.provider.Settings;
import android.widget.TextView;
import android.content.IntentFilter;
import com.android.internal.app.ShutdownThread;
import android.app.AlertDialog;
import android.content.Context;
import android.view.ViewGroup;
class GlobalActions implements DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.928 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.928 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.929 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "991C9045D562C191172A8A33540FC7A7")

    private ArrayList<Action> mItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.929 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "F83602A20E99C2560EE913CF62B217D5")

    private AlertDialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.929 -0400", hash_original_field = "6AFCCEA23A7BDAEF573CA05B21D34CF7", hash_generated_field = "70DD3E5721E473AB3B1E965BF2A348FC")

    private SilentModeAction mSilentModeAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.930 -0400", hash_original_field = "8C504242F2B547C371C6C85847A69220", hash_generated_field = "59667AAFDE41556371EE081B9ABD4942")

    private ToggleAction mAirplaneModeOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.930 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "C86692372A718139971A36D54668FD95")

    private MyAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.930 -0400", hash_original_field = "9FE62CDE1FF1BFC19707076F1254117C", hash_generated_field = "8708616AD0AFF67557B5F4FD73F2058D")

    private boolean mKeyguardShowing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.931 -0400", hash_original_field = "4BE086D9F8E78DEB09418CA3B2FCB75D", hash_generated_field = "A26CE4CC91C10D7426A5E39ED64992DF")

    private boolean mDeviceProvisioned = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.931 -0400", hash_original_field = "71476B84E1BC59C809EC8C02FDA04D4B", hash_generated_field = "E759844A6215B6BF5565AD780472E318")

    private ToggleAction.State mAirplaneState = ToggleAction.State.Off;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.931 -0400", hash_original_field = "EB76BD34D4CB7F770C848420E5C872E4", hash_generated_field = "8CA8C4EB7A7D3129D5F7275729893072")

    private boolean mIsWaitingForEcmExit = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.933 -0400", hash_original_field = "34115D2264AB2CACC59AA7CD5E054E4A", hash_generated_field = "04CBAD2654BFA80A922667E0205063EF")

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.932 -0400", hash_original_method = "56E2A00C1AE30698A378079D64C569F0", hash_generated_method = "73C81E64F6B246A0C28151D33244F667")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            String action = intent.getAction();
            if(Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)||Intent.ACTION_SCREEN_OFF.equals(action))            
            {
                String reason = intent.getStringExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY);
                if(!PhoneWindowManager.SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS.equals(reason))                
                {
mHandler.sendEmptyMessage(MESSAGE_DISMISS)
                } //End block
            } //End block
            else
            if(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED.equals(action))            
            {
                if(!(intent.getBooleanExtra("PHONE_IN_ECM_STATE", false))&&mIsWaitingForEcmExit)                
                {
mIsWaitingForEcmExit=falsechangeAirplaneModeSystemSetting(true)
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.937 -0400", hash_original_field = "27EA9505A80B91BF9E0541F40539C3D0", hash_generated_field = "2C2A4C7B6090758F1F2FEA0FF40BF449")

    PhoneStateListener mPhoneStateListener = new PhoneStateListener()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.936 -0400", hash_original_method = "EC1E9B666C7C741F646E2518580B662C", hash_generated_method = "D05AA980741CAADF20A76169F937815D")
        @Override
        public void onServiceStateChanged(ServiceState serviceState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(serviceState.getTaint());
            final boolean inAirplaneMode = serviceState.getState() == ServiceState.STATE_POWER_OFF;
mAirplaneState=inAirplaneMode?ToggleAction.State.On:ToggleAction.State.OnmAirplaneModeOn.updateState(mAirplaneState)mAdapter.notifyDataSetChanged()
            // ---------- Original Method ----------
            //final boolean inAirplaneMode = serviceState.getState() == ServiceState.STATE_POWER_OFF;
            //mAirplaneState = inAirplaneMode ? ToggleAction.State.On : ToggleAction.State.Off;
            //mAirplaneModeOn.updateState(mAirplaneState);
            //mAdapter.notifyDataSetChanged();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.939 -0400", hash_original_field = "8DF8E54F00C21381A48D061302005AFA", hash_generated_field = "B7038B1F014EB6946A5C38D770B34178")

    private BroadcastReceiver mRingerModeReceiver = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.938 -0400", hash_original_method = "F0420285FA37C7304D7EDBC61E0EC3E6", hash_generated_method = "E29936978BE88F956B86B53F8FF5BFDE")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            if(intent.getAction().equals(AudioManager.RINGER_MODE_CHANGED_ACTION))            
            {
mHandler.sendEmptyMessage(MESSAGE_REFRESH)
            } //End block
            // ---------- Original Method ----------
            //if (intent.getAction().equals(AudioManager.RINGER_MODE_CHANGED_ACTION)) {
                //mHandler.sendEmptyMessage(MESSAGE_REFRESH);
            //}
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.947 -0400", hash_original_field = "F83A2F7624770A12AD82A952C03E89FE", hash_generated_field = "51F883CA1A861BEFB9C4889211105F86")

    private Handler mHandler = new Handler()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.941 -0400", hash_original_method = "E9EB5EAA47B7A37F226EFB9AA8D3BD04", hash_generated_method = "04CFFFA4BD1EC4895781DC86C626FEC6")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            if(msg.what==MESSAGE_DISMISS)            
            {
                if(mDialog!=null)                
                {
mDialog.dismiss()
                } //End block
            } //End block
            else
            if(msg.what==MESSAGE_REFRESH)            
            {
mAdapter.notifyDataSetChanged()
            } //End block
            // ---------- Original Method ----------
            //if (msg.what == MESSAGE_DISMISS) {
                //if (mDialog != null) {
                    //mDialog.dismiss();
                //}
            //} else if (msg.what == MESSAGE_REFRESH) {
                //mAdapter.notifyDataSetChanged();
            //}
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.949 -0400", hash_original_method = "DEB5C91F546961587C8EB473CE767047", hash_generated_method = "234F7D22AE1EFAA8E2889BF3A2889504")
    public  GlobalActions(Context context) {
        addTaint(context.getTaint());
mContext=contextmAudioManager=(AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE)        IntentFilter filter = new IntentFilter();
filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)filter.addAction(Intent.ACTION_SCREEN_OFF)filter.addAction(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED)context.registerReceiver(mBroadcastReceiver, filter)        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
telephonyManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_SERVICE_STATE)
        // ---------- Original Method ----------
        //mContext = context;
        //mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        //filter.addAction(Intent.ACTION_SCREEN_OFF);
        //filter.addAction(TelephonyIntents.ACTION_EMERGENCY_CALLBACK_MODE_CHANGED);
        //context.registerReceiver(mBroadcastReceiver, filter);
        //TelephonyManager telephonyManager =
                //(TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        //telephonyManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_SERVICE_STATE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.951 -0400", hash_original_method = "005BA974FD98A85FE165252ACB292400", hash_generated_method = "0201EE4B4276ADA3D4E2794EBAD1AB07")
    public void showDialog(boolean keyguardShowing, boolean isDeviceProvisioned) {
        addTaint(isDeviceProvisioned);
        addTaint(keyguardShowing);
mKeyguardShowing=keyguardShowingmDeviceProvisioned=isDeviceProvisioned        if(mDialog==null)        
        {
mDialog=createDialog()
        } //End block
prepareDialog()mDialog.show()mDialog.getWindow().getDecorView().setSystemUiVisibility(View.STATUS_BAR_DISABLE_EXPAND)
        // ---------- Original Method ----------
        //mKeyguardShowing = keyguardShowing;
        //mDeviceProvisioned = isDeviceProvisioned;
        //if (mDialog == null) {
            //mDialog = createDialog();
        //}
        //prepareDialog();
        //mDialog.show();
        //mDialog.getWindow().getDecorView().setSystemUiVisibility(View.STATUS_BAR_DISABLE_EXPAND);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.968 -0400", hash_original_method = "47DF68A7A2C053848A9419FE3382D5D2", hash_generated_method = "8C47FE01D8F762A7608C45DF7E645155")
    private AlertDialog createDialog() {
mSilentModeAction=new SilentModeAction(mAudioManager, mHandler)mAirplaneModeOn=new ToggleAction(R.drawable.ic_lock_airplane_mode, R.drawable.ic_lock_airplane_mode_off, R.string.global_actions_toggle_airplane_mode, R.string.global_actions_airplane_mode_on_status, R.string.global_actions_airplane_mode_off_status)        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.955 -0400", hash_original_method = "D7C33A484D79DDA9B1103758B63D5E7C", hash_generated_method = "9A4B0F0BEF6695F0D4F84472E438F341")
         void onToggle(boolean on) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(on);
            if(Boolean.parseBoolean(SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE)))            
            {
mIsWaitingForEcmExit=true                Intent ecmDialogIntent = new Intent(TelephonyIntents.ACTION_SHOW_NOTICE_ECM_BLOCK_OTHERS, null);
ecmDialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)mContext.startActivity(ecmDialogIntent)
            } //End block
            else
            {
changeAirplaneModeSystemSetting(on)
            } //End block
            // ---------- Original Method ----------
            //if (Boolean.parseBoolean(
                        //SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE))) {
                    //mIsWaitingForEcmExit = true;
                    //Intent ecmDialogIntent =
                            //new Intent(TelephonyIntents.ACTION_SHOW_NOTICE_ECM_BLOCK_OTHERS, null);
                    //ecmDialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //mContext.startActivity(ecmDialogIntent);
                //} else {
                    //changeAirplaneModeSystemSetting(on);
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.957 -0400", hash_original_method = "8190F365B266A2D22FF1E7F29EB229EF", hash_generated_method = "6F34C0B0DBFEA47AC7343247B5E451EB")
        @Override
        protected void changeStateFromPress(boolean buttonOn) {
            addTaint(buttonOn);
            if(!(Boolean.parseBoolean(SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE))))            
            {
mState=buttonOn?State.TurningOn:State.TurningOnmAirplaneState=mState
            } //End block
            // ---------- Original Method ----------
            //if (!(Boolean.parseBoolean(
                        //SystemProperties.get(TelephonyProperties.PROPERTY_INECM_MODE)))) {
                    //mState = buttonOn ? State.TurningOn : State.TurningOff;
                    //mAirplaneState = mState;
                //}
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.959 -0400", hash_original_method = "46B6D032210F2AB7DD71FD8985AA9778", hash_generated_method = "56F82551382D1D232A0371F1F8B45427")
        public boolean showDuringKeyguard() {
            boolean varB326B5062B2F0E69046810717534CB09_668881528 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031907901 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031907901;
            // ---------- Original Method ----------
            //return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.961 -0400", hash_original_method = "2F54C90FEA61DB4CA665617A617EB71D", hash_generated_method = "AA49F81FFD25F8AD20F3B679C21F4903")
        public boolean showBeforeProvisioning() {
            boolean var68934A3E9455FA72420237EB05902327_1824636696 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2027988021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2027988021;
            // ---------- Original Method ----------
            //return false;
        }
        }
mItems=new ArrayList<Action>()mItems.add(new SinglePressAction(com.android.internal.R.drawable.ic_lock_power_off, R.string.global_action_power_off)        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.963 -0400", hash_original_method = "26BBD2D6E1BE46D79447BBB8B8E84C01", hash_generated_method = "9AC62E15A1793C784CA71F1B72F4DA4F")
        public void onPress() {
            //DSFIXME:  CODE0009: Possible callback target function detected
ShutdownThread.shutdown(mContext, true)
            // ---------- Original Method ----------
            //ShutdownThread.shutdown(mContext, true);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.964 -0400", hash_original_method = "46B6D032210F2AB7DD71FD8985AA9778", hash_generated_method = "23CEBBB6E713D5DDF6CEA2A4982A30DC")
        public boolean showDuringKeyguard() {
            boolean varB326B5062B2F0E69046810717534CB09_359426775 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571117954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_571117954;
            // ---------- Original Method ----------
            //return true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.966 -0400", hash_original_method = "ECF65790B622E13F1DA735ADCC699AAF", hash_generated_method = "99C112237F4D6BA2B1CA09F1341150C7")
        public boolean showBeforeProvisioning() {
            boolean varB326B5062B2F0E69046810717534CB09_1888731255 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289848443 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_289848443;
            // ---------- Original Method ----------
            //return true;
        }
        }
)mItems.add(mAirplaneModeOn)        if(SHOW_SILENT_TOGGLE)        
        {
mItems.add(mSilentModeAction)
        } //End block
mAdapter=new MyAdapter()        final AlertDialog.Builder ab = new AlertDialog.Builder(mContext);
ab.setAdapter(mAdapter, this).setInverseBackgroundForced(true)        final AlertDialog dialog = ab.create();
dialog.getListView().setItemsCanFocus(true)dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG)dialog.setOnDismissListener(this)AlertDialog varE19892282EF70932DF3A147A213BE89D_1512729542 = dialog        varE19892282EF70932DF3A147A213BE89D_1512729542.addTaint(taint);
        return varE19892282EF70932DF3A147A213BE89D_1512729542;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.972 -0400", hash_original_method = "9B6CD430B1AB32D6D129A48AC54544E9", hash_generated_method = "289D43816DA3A667F77DB9CF39D32AF3")
    private void prepareDialog() {
        final boolean silentModeOn = mAudioManager.getRingerMode() != AudioManager.RINGER_MODE_NORMAL;
mAirplaneModeOn.updateState(mAirplaneState)mAdapter.notifyDataSetChanged()        if(mKeyguardShowing)        
        {
mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)
        } //End block
        else
        {
mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG)
        } //End block
        if(SHOW_SILENT_TOGGLE)        
        {
            IntentFilter filter = new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION);
mContext.registerReceiver(mRingerModeReceiver, filter)
        } //End block
        // ---------- Original Method ----------
        //final boolean silentModeOn =
                //mAudioManager.getRingerMode() != AudioManager.RINGER_MODE_NORMAL;
        //mAirplaneModeOn.updateState(mAirplaneState);
        //mAdapter.notifyDataSetChanged();
        //if (mKeyguardShowing) {
            //mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        //} else {
            //mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
        //}
        //if (SHOW_SILENT_TOGGLE) {
            //IntentFilter filter = new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION);
            //mContext.registerReceiver(mRingerModeReceiver, filter);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.974 -0400", hash_original_method = "C267B5C28BB9B87766D056F9B9162399", hash_generated_method = "466EA797EA5B8A77093A463B6CF8A458")
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
        if(SHOW_SILENT_TOGGLE)        
        {
mContext.unregisterReceiver(mRingerModeReceiver)
        } //End block
        // ---------- Original Method ----------
        //if (SHOW_SILENT_TOGGLE) {
            //mContext.unregisterReceiver(mRingerModeReceiver);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.976 -0400", hash_original_method = "411AFF963F359E4411A80D634922E7B8", hash_generated_method = "758EFD49D4A1956A95A16335667FBF7D")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(which);
        addTaint(dialog.getTaint());
        if(!(mAdapter.getItem(which) instanceof SilentModeAction))        
        {
dialog.dismiss()
        } //End block
mAdapter.getItem(which).onPress()
        // ---------- Original Method ----------
        //if (!(mAdapter.getItem(which) instanceof SilentModeAction)) {
            //dialog.dismiss();
        //}
        //mAdapter.getItem(which).onPress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.979 -0400", hash_original_method = "73355F1C3C7F1EE9FD8417E7D1E6DF1D", hash_generated_method = "B401274F99D840C16168770B1ACAA8FB")
    private void changeAirplaneModeSystemSetting(boolean on) {
        addTaint(on);
Settings.System.putInt(mContext.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, on?1:1)        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING)intent.putExtra("state", on)mContext.sendBroadcast(intent)
        // ---------- Original Method ----------
        //Settings.System.putInt(
                //mContext.getContentResolver(),
                //Settings.System.AIRPLANE_MODE_ON,
                //on ? 1 : 0);
        //Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        //intent.putExtra("state", on);
        //mContext.sendBroadcast(intent);
    }

    
    private class MyAdapter extends BaseAdapter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.980 -0400", hash_original_method = "7B50F72AE73878889ADEE6B288A49764", hash_generated_method = "7B50F72AE73878889ADEE6B288A49764")
        public MyAdapter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.981 -0400", hash_original_method = "E12C5CC2ABA490E78BD88B205736859B", hash_generated_method = "C60EF34CADEEF1A63588AE2A52BDE552")
        public int getCount() {
            int count = 0;
for(int i = 0;i<mItems.size();i)
            {
                final Action action = mItems.get(i);
                if(mKeyguardShowing&&!action.showDuringKeyguard())                
                {
                    continue;
                } //End block
                if(!mDeviceProvisioned&&!action.showBeforeProvisioning())                
                {
                    continue;
                } //End block
count
            } //End block
            int varE2942A04780E223B215EB8B663CF5353_676697659 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086144092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086144092;
            // ---------- Original Method ----------
            //int count = 0;
            //for (int i = 0; i < mItems.size(); i++) {
                //final Action action = mItems.get(i);
                //if (mKeyguardShowing && !action.showDuringKeyguard()) {
                    //continue;
                //}
                //if (!mDeviceProvisioned && !action.showBeforeProvisioning()) {
                    //continue;
                //}
                //count++;
            //}
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.983 -0400", hash_original_method = "91DD75CD5B827FDA5339C19368FE8F48", hash_generated_method = "15A5444E1035C556CEABF8E7ADF3B1C6")
        @Override
        public boolean isEnabled(int position) {
            addTaint(position);
            boolean varC768A6E01827EBD203A4200739836CFF_1140056438 = (getItem(position).isEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369819353 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369819353;
            // ---------- Original Method ----------
            //return getItem(position).isEnabled();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.984 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "4CEEF933B8287AC331E82842A4C48A17")
        @Override
        public boolean areAllItemsEnabled() {
            boolean var68934A3E9455FA72420237EB05902327_153135717 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753142767 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_753142767;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.987 -0400", hash_original_method = "6616024A52881C0495A45A7D256208A3", hash_generated_method = "69ACCCDC682FEDAF08DF51AE118A3AA9")
        public Action getItem(int position) {
            addTaint(position);
            int filteredPos = 0;
for(int i = 0;i<mItems.size();i)
            {
                final Action action = mItems.get(i);
                if(mKeyguardShowing&&!action.showDuringKeyguard())                
                {
                    continue;
                } //End block
                if(!mDeviceProvisioned&&!action.showBeforeProvisioning())                
                {
                    continue;
                } //End block
                if(filteredPos==position)                
                {
Action varDA87B99183D712E308A5FB2D10F06F10_2025399780 = action                    varDA87B99183D712E308A5FB2D10F06F10_2025399780.addTaint(taint);
                    return varDA87B99183D712E308A5FB2D10F06F10_2025399780;
                } //End block
filteredPos
            } //End block
            IllegalArgumentException var3EC1C3C24DBAD54EAA89B7376D4D33B8_2090044525 = new IllegalArgumentException("position " + position
                    + " out of range of showable actions"
                    + ", filtered count=" + getCount()
                    + ", keyguardshowing=" + mKeyguardShowing
                    + ", provisioned=" + mDeviceProvisioned);
            var3EC1C3C24DBAD54EAA89B7376D4D33B8_2090044525.addTaint(taint);
            throw var3EC1C3C24DBAD54EAA89B7376D4D33B8_2090044525;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.989 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "07D30B612ED0102925A7FDA4D27A59F6")
        public long getItemId(int position) {
            addTaint(position);
            long var4757FE07FD492A8BE0EA6A760D683D6E_1467771085 = (position);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1004727122 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1004727122;
            // ---------- Original Method ----------
            //return position;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.990 -0400", hash_original_method = "EF8AE9D54EA4C89673B2CCAA6E0D0895", hash_generated_method = "DB78575AB6128F20A7F9A8C10DD23E14")
        public View getView(int position, View convertView, ViewGroup parent) {
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(position);
            Action action = getItem(position);
View var26E0B3F95FD293809D3BB5402F40374C_2101664497 = action.create(mContext, convertView, parent, LayoutInflater.from(mContext))            var26E0B3F95FD293809D3BB5402F40374C_2101664497.addTaint(taint);
            return var26E0B3F95FD293809D3BB5402F40374C_2101664497;
            // ---------- Original Method ----------
            //Action action = getItem(position);
            //return action.create(mContext, convertView, parent, LayoutInflater.from(mContext));
        }

        
    }


    
    private static abstract class SinglePressAction implements Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.991 -0400", hash_original_field = "0F522D56B85B081BF02F698ECADD7AFE", hash_generated_field = "7DAEA4581257F07E76CD939CD24A2FD7")

        private int mIconResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.992 -0400", hash_original_field = "77786F1CE5A9857485EDA95AADFEDD3C", hash_generated_field = "E04292941B00F22C135AE8F72E295603")

        private int mMessageResId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.993 -0400", hash_original_method = "367807EF94A715788C04E888F0387028", hash_generated_method = "76B6356199F945BBEC25F18F09F40E99")
        protected  SinglePressAction(int iconResId, int messageResId) {
            addTaint(messageResId);
            addTaint(iconResId);
mIconResId=iconResIdmMessageResId=messageResId
            // ---------- Original Method ----------
            //mIconResId = iconResId;
            //mMessageResId = messageResId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.995 -0400", hash_original_method = "F47A932FD238729963C0D6F99B4D6296", hash_generated_method = "0DA1AF49EFC7B6678EF2491FC07E69E8")
        public boolean isEnabled() {
            boolean varB326B5062B2F0E69046810717534CB09_1074908494 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695511739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_695511739;
            // ---------- Original Method ----------
            //return true;
        }

        
        abstract public void onPress();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.997 -0400", hash_original_method = "3F072EB74D855A00AB743A1727114A46", hash_generated_method = "143DD6522F05CF035051AED25EC8A2F3")
        public View create(
                Context context, View convertView, ViewGroup parent, LayoutInflater inflater) {
            addTaint(inflater.getTaint());
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(context.getTaint());
            View v = inflater.inflate(R.layout.global_actions_item, parent, false);
            ImageView icon = (ImageView) v.findViewById(R.id.icon);
            TextView messageView = (TextView) v.findViewById(R.id.message);
v.findViewById(R.id.status).setVisibility(View.GONE)icon.setImageDrawable(context.getResources().getDrawable(mIconResId))messageView.setText(mMessageResId)View var6DC76BC51820DD65E8396280E884AA78_2143171766 = v            var6DC76BC51820DD65E8396280E884AA78_2143171766.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_2143171766;
            // ---------- Original Method ----------
            //View v = inflater.inflate(R.layout.global_actions_item, parent, false);
            //ImageView icon = (ImageView) v.findViewById(R.id.icon);
            //TextView messageView = (TextView) v.findViewById(R.id.message);
            //v.findViewById(R.id.status).setVisibility(View.GONE);
            //icon.setImageDrawable(context.getResources().getDrawable(mIconResId));
            //messageView.setText(mMessageResId);
            //return v;
        }

        
    }


    
    private static abstract class ToggleAction implements Action {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.998 -0400", hash_original_field = "21C0889AB9AF845C3B7EE0A30EE93D9A", hash_generated_field = "B9D8A48DE974865924C4037624994625")

        protected State mState = State.Off;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.999 -0400", hash_original_field = "1C8C259E8D703C1C1204210732B75917", hash_generated_field = "B0F2B26386C41552E83433BEE2E30F78")

        protected int mEnabledIconResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.999 -0400", hash_original_field = "27945967B5C953501D61F80FD4A00A31", hash_generated_field = "310215221487213CAAA5AC143921B2D8")

        protected int mDisabledIconResid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.000 -0400", hash_original_field = "77786F1CE5A9857485EDA95AADFEDD3C", hash_generated_field = "C0354969D94A74F0E56D90F4EDEEE496")

        protected int mMessageResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.001 -0400", hash_original_field = "7F1A5855C330417AE858EBB185780EA0", hash_generated_field = "8B8CA859BC5EB859D865E5304B872909")

        protected int mEnabledStatusMessageResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.001 -0400", hash_original_field = "28F4625B95037A84FDBB58009B2432AA", hash_generated_field = "45E5C8AF50D4FAB63EC67ABBA76D388B")

        protected int mDisabledStatusMessageResId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.003 -0400", hash_original_method = "BEE88743FCC6E981DC54BA4D9EC9AFBA", hash_generated_method = "66BE915DB4508196B1167550702C0218")
        public  ToggleAction(int enabledIconResId,
                int disabledIconResid,
                int essage,
                int enabledStatusMessageResId,
                int disabledStatusMessageResId) {
            addTaint(disabledStatusMessageResId);
            addTaint(enabledStatusMessageResId);
            addTaint(essage);
            addTaint(disabledIconResid);
            addTaint(enabledIconResId);
mEnabledIconResId=enabledIconResIdmDisabledIconResid=disabledIconResidmMessageResId=essagemEnabledStatusMessageResId=enabledStatusMessageResIdmDisabledStatusMessageResId=disabledStatusMessageResId
            // ---------- Original Method ----------
            //mEnabledIconResId = enabledIconResId;
            //mDisabledIconResid = disabledIconResid;
            //mMessageResId = essage;
            //mEnabledStatusMessageResId = enabledStatusMessageResId;
            //mDisabledStatusMessageResId = disabledStatusMessageResId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.004 -0400", hash_original_method = "81AAE6DFC09B0C30ABB55DA70BA13989", hash_generated_method = "FA70A747FEF18BEE54255B158A3D0540")
         void willCreate() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.007 -0400", hash_original_method = "DFFB310872429C611A84F4AB36A5A86F", hash_generated_method = "7E762BC4E1213AB47D05DB2DD0287889")
        public View create(Context context, View convertView, ViewGroup parent,
                LayoutInflater inflater) {
            addTaint(inflater.getTaint());
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(context.getTaint());
willCreate()            View v = inflater.inflate(R
                            .layout.global_actions_item, parent, false);
            ImageView icon = (ImageView) v.findViewById(R.id.icon);
            TextView messageView = (TextView) v.findViewById(R.id.message);
            TextView statusView = (TextView) v.findViewById(R.id.status);
            final boolean enabled = isEnabled();
            if(messageView!=null)            
            {
messageView.setText(mMessageResId)messageView.setEnabled(enabled)
            } //End block
            boolean on = ((mState == State.On) || (mState == State.TurningOn));
            if(icon!=null)            
            {
icon.setImageDrawable(context.getResources().getDrawable((on?mEnabledIconResId:mEnabledIconResId)))icon.setEnabled(enabled)
            } //End block
            if(statusView!=null)            
            {
statusView.setText(on?mEnabledStatusMessageResId:mEnabledStatusMessageResId)statusView.setVisibility(View.VISIBLE)statusView.setEnabled(enabled)
            } //End block
v.setEnabled(enabled)View var6DC76BC51820DD65E8396280E884AA78_538129557 = v            var6DC76BC51820DD65E8396280E884AA78_538129557.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_538129557;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.010 -0400", hash_original_method = "F83B974F3A605ECD4F8052282F6FA078", hash_generated_method = "2C902C9E48D8386A32F4075E1ECBB489")
        public final void onPress() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if(mState.inTransition())            
            {
                return;
            } //End block
            final boolean nowOn = !(mState == State.On);
onToggle(nowOn)changeStateFromPress(nowOn)
            // ---------- Original Method ----------
            //if (mState.inTransition()) {
                //Log.w(TAG, "shouldn't be able to toggle when in transition");
                //return;
            //}
            //final boolean nowOn = !(mState == State.On);
            //onToggle(nowOn);
            //changeStateFromPress(nowOn);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.011 -0400", hash_original_method = "CE0BC8D7B384D876A3AEB25A9974E36E", hash_generated_method = "CF84E9B78A7F2E6276CDAAB7A872BE68")
        public boolean isEnabled() {
            boolean var91E2A26DC3060346B130023EC3919704_1880346420 = (!mState.inTransition());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763991058 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763991058;
            // ---------- Original Method ----------
            //return !mState.inTransition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.013 -0400", hash_original_method = "008E5460225F3ABE0CE1DA55FB0D130E", hash_generated_method = "F320EEEC6E700E4A1D32C9B323B62022")
        protected void changeStateFromPress(boolean buttonOn) {
            addTaint(buttonOn);
mState=buttonOn?State.On:State.On
            // ---------- Original Method ----------
            //mState = buttonOn ? State.On : State.Off;
        }

        
        abstract void onToggle(boolean on);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.015 -0400", hash_original_method = "BA44592B705789364F3A853739BBF9F4", hash_generated_method = "17FEC83970EA70C33D523DCABED82D4C")
        public void updateState(State state) {
            addTaint(state.getTaint());
mState=state
            // ---------- Original Method ----------
            //mState = state;
        }

        
        enum State {
            Off(false),
            TurningOn(true),
            TurningOff(true),
            On(false);
            private final boolean inTransition;
            State(boolean intermediate) {
                inTransition = intermediate;
            }
            public boolean inTransition() {
                return inTransition;
            }
        }

        
    }


    
    private static class SilentModeAction implements Action, View.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.016 -0400", hash_original_field = "03A163F2C6E79576026922558C007C1F", hash_generated_field = "48D9A0F48772E76EBACB8D0E8ECFD91F")

        private final int[] ITEM_IDS = {R.id.option1, R.id.option2, R.id.option3, };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.017 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

        private AudioManager mAudioManager;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.018 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.020 -0400", hash_original_method = "9589454E52027259FF368DE0637B90B0", hash_generated_method = "26D93F3D33B6348A8F5419AF0B9F54A0")
          SilentModeAction(AudioManager audioManager, Handler handler) {
            addTaint(handler.getTaint());
            addTaint(audioManager.getTaint());
mAudioManager=audioManagermHandler=handler
            // ---------- Original Method ----------
            //mAudioManager = audioManager;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.022 -0400", hash_original_method = "D0AD74E8AE7C46F995149BA56229A80D", hash_generated_method = "35B67D24653C29F6EDA70AC2DD0A99BA")
        private int ringerModeToIndex(int ringerMode) {
            addTaint(ringerMode);
            int varE777418207E182DED7095C89A81850E6_1844485544 = (ringerMode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062220056 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062220056;
            // ---------- Original Method ----------
            //return ringerMode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.024 -0400", hash_original_method = "FB421A39983565DDF2136BE960D3CC51", hash_generated_method = "EAE4F0177B2429531C5A58E5256755E4")
        private int indexToRingerMode(int index) {
            addTaint(index);
            int var6A992D5529F459A44FEE58C733255E86_1898308512 = (index);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119342467 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119342467;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.026 -0400", hash_original_method = "50EE52AB4449380E4F0648CF2AD8A173", hash_generated_method = "28569F138A11EDADBD8BB767A297FA00")
        public View create(Context context, View convertView, ViewGroup parent,
                LayoutInflater inflater) {
            addTaint(inflater.getTaint());
            addTaint(parent.getTaint());
            addTaint(convertView.getTaint());
            addTaint(context.getTaint());
            View v = inflater.inflate(R.layout.global_actions_silent_mode, parent, false);
            int selectedIndex = ringerModeToIndex(mAudioManager.getRingerMode());
for(int i = 0;i<3;i)
            {
                View itemView = v.findViewById(ITEM_IDS[i]);
itemView.setSelected(selectedIndex==i)itemView.setTag(i)itemView.setOnClickListener(this)
            } //End block
View var6DC76BC51820DD65E8396280E884AA78_886725452 = v            var6DC76BC51820DD65E8396280E884AA78_886725452.addTaint(taint);
            return var6DC76BC51820DD65E8396280E884AA78_886725452;
            // ---------- Original Method ----------
            //View v = inflater.inflate(R.layout.global_actions_silent_mode, parent, false);
            //int selectedIndex = ringerModeToIndex(mAudioManager.getRingerMode());
            //for (int i = 0; i < 3; i++) {
                //View itemView = v.findViewById(ITEM_IDS[i]);
                //itemView.setSelected(selectedIndex == i);
                //itemView.setTag(i);
                //itemView.setOnClickListener(this);
            //}
            //return v;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.028 -0400", hash_original_method = "D4DB120323C01F18747B781682702C8A", hash_generated_method = "F8CC30AE9323EE12D0EAB162FF07504A")
        public void onPress() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.030 -0400", hash_original_method = "46B6D032210F2AB7DD71FD8985AA9778", hash_generated_method = "11E950009943FF135443A790F0E9EAF7")
        public boolean showDuringKeyguard() {
            boolean varB326B5062B2F0E69046810717534CB09_1330358755 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533725580 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_533725580;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.032 -0400", hash_original_method = "2F54C90FEA61DB4CA665617A617EB71D", hash_generated_method = "79130E45BE1A74D56EA9F76AA687C872")
        public boolean showBeforeProvisioning() {
            boolean var68934A3E9455FA72420237EB05902327_1485856694 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899052177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899052177;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.033 -0400", hash_original_method = "F47A932FD238729963C0D6F99B4D6296", hash_generated_method = "7B9A9E3CB22B3919FEF19BB16EB6280C")
        public boolean isEnabled() {
            boolean varB326B5062B2F0E69046810717534CB09_174012983 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013972115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013972115;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.034 -0400", hash_original_method = "81AAE6DFC09B0C30ABB55DA70BA13989", hash_generated_method = "FA70A747FEF18BEE54255B158A3D0540")
         void willCreate() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.036 -0400", hash_original_method = "3E179E27807D3F38380EA95FF45A5AD3", hash_generated_method = "B9FD9D9A0C3F01F6F71BE8A0D383A607")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            if(!(v.getTag() instanceof Integer))            
            return;
            int index = (Integer) v.getTag();
mAudioManager.setRingerMode(indexToRingerMode(index))mHandler.sendEmptyMessageDelayed(MESSAGE_DISMISS, DIALOG_DISMISS_DELAY)
            // ---------- Original Method ----------
            //if (!(v.getTag() instanceof Integer)) return;
            //int index = (Integer) v.getTag();
            //mAudioManager.setRingerMode(indexToRingerMode(index));
            //mHandler.sendEmptyMessageDelayed(MESSAGE_DISMISS, DIALOG_DISMISS_DELAY);
        }

        
    }


    
    private interface Action {
        View create(Context context, View convertView, ViewGroup parent, LayoutInflater inflater);

        void onPress();

        
        boolean showDuringKeyguard();

        
        boolean showBeforeProvisioning();

        boolean isEnabled();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.037 -0400", hash_original_field = "7BA5F312E52664BA4F86AA9FA0926DC7", hash_generated_field = "76E91418A7ABFEF5E73C293003024630")

    private static final String TAG = "GlobalActions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.037 -0400", hash_original_field = "73679AAE5E034EC64B7202C5B38438EF", hash_generated_field = "68E0A68F322CD6FEF7D064B8ACDAFA97")

    private static final boolean SHOW_SILENT_TOGGLE = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.038 -0400", hash_original_field = "9CF50A804B3DE552D1C444B5753E460D", hash_generated_field = "8D56A58CBEAA6FDD28FC5D65E1DB767D")

    private static final int MESSAGE_DISMISS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.039 -0400", hash_original_field = "C9E168C1DC5D41B0D96721272A9ED81A", hash_generated_field = "D5B033E3713E71A399CA63386F570BBB")

    private static final int MESSAGE_REFRESH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.039 -0400", hash_original_field = "D604C9CB09DA848D513D7D83FBACE892", hash_generated_field = "4F07600CBAD1FC7E441E6D6D3D8F8429")

    private static final int DIALOG_DISMISS_DELAY = 300;
}

