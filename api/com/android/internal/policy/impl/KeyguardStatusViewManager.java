package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import com.android.internal.R;
import libcore.util.MutableInt;
import android.view.View.OnClickListener;
import android.util.Log;
import com.android.internal.telephony.IccCard;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import java.util.Date;
import com.android.internal.telephony.IccCard.State;
import android.widget.Button;
import android.text.TextUtils;
import com.android.internal.policy.impl.KeyguardUpdateMonitor.SimStateCallback;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.TransportControlView;
import android.content.Context;
import android.text.format.DateFormat;
import android.content.ContentResolver;
class KeyguardStatusViewManager implements OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.118 -0400", hash_original_field = "08A70BE073C070052231C5D6655B200E", hash_generated_field = "673C08723E594FCC09EA7DE6E1332CEA")

    private StatusMode mStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.118 -0400", hash_original_field = "22974F45F92F569FB27C8B1BD90BE1AA", hash_generated_field = "5046C521032D29CE66D7DCFDDB366C94")

    private String mDateFormatString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.119 -0400", hash_original_field = "5D1A52F0117A09594E760A7CFA20F943", hash_generated_field = "065CFAE739DFFDE354E36D211939A478")

    private TransientTextManager mTransientTextManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.119 -0400", hash_original_field = "894838971E0AB7062E2FA0303D9AFB60", hash_generated_field = "BCBCB72D461E4C41BDAA98441455B1F5")

    private TextView mCarrierView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.120 -0400", hash_original_field = "828992A429ACB19453C4099D02C2A268", hash_generated_field = "5A4A4A8CD82E5162DF471713B491D513")

    private TextView mDateView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.120 -0400", hash_original_field = "A0EAB5619D878D36D7DA8EFE1A1F9921", hash_generated_field = "C17614462B7B0C92E18E9C8CCB708CE7")

    private TextView mStatus1View;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.120 -0400", hash_original_field = "B44D7A65F5814232838ED6023DEA9490", hash_generated_field = "0D0C541BEF5CE18C8EA8994538D75217")

    private TextView mOwnerInfoView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.120 -0400", hash_original_field = "826AA8324B032D3EA774201DF8D5C6F5", hash_generated_field = "127EA8C86C706E39D1284EA9E3A5C89B")

    private TextView mAlarmStatusView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.121 -0400", hash_original_field = "8A12B5B4646F6AA5C203E59A7DDB914A", hash_generated_field = "D839E45A78215B8409E10CB29FEFFB66")

    private TransportControlView mTransportView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.121 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "94A47CD5A7D614CBC4B444356DB6203E")

    private View mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.121 -0400", hash_original_field = "C0D1B14A6C862A58EC6794A664429156", hash_generated_field = "C0C09AB687854B6A3D6C144C524E08FE")

    private boolean mShowingBatteryInfo = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.121 -0400", hash_original_field = "3B7BE72BAC28A2BFEB0100D0E72DB395", hash_generated_field = "9F98991AB41D9B5957FE78C24E5F0460")

    private boolean mPluggedIn = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.122 -0400", hash_original_field = "1FAFFEF712D651E16E27D22A5327962C", hash_generated_field = "5A824746A30D680692165FF7F16FA3AB")

    private int mBatteryLevel = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.122 -0400", hash_original_field = "61B1199AB7E2A71A9204920B67B0F5CB", hash_generated_field = "09C9714BA7E63AE57E2D52FB01FE98A9")

    protected State mSimState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.122 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.122 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.122 -0400", hash_original_field = "35F148DAD68226EFC0FBB77E62BE1F8F", hash_generated_field = "89AEAC095345615E069E744AAF0A234F")

    private Button mEmergencyCallButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "85BB4A8C4007D866A1CB6E319AC52AA8", hash_generated_field = "F987FB2B1552B72DD778CAC3401C8345")

    private boolean mEmergencyButtonEnabledBecauseSimLocked;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "54F9890D9EB6B12634429EF87D72A709", hash_generated_field = "DE6E79FC1CC98C16CEE7DD090AFDBEDB")

    private CharSequence mCarrierText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "3A5B0B3D654A846F94677B953E40176B", hash_generated_field = "B6350F4C68BDA3556BEA7272865DA805")

    private CharSequence mCarrierHelpText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "23D74BFEFF9C30F31BF418DB022A43DC", hash_generated_field = "8241F7BFBED7AF681D25292484C4222C")

    private String mHelpMessageText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "905C9D766599DDD53600D05DBFE10C72", hash_generated_field = "8E90CF9DA6A31859FBE1FD9FE873CA75")

    private String mInstructionText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.123 -0400", hash_original_field = "258C12DF9EE013A0825A5DB2929ED38F", hash_generated_field = "0B3AA4EE68FEF1DF7BEBA57CD7C75DA6")

    private CharSequence mOwnerInfoText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "D39A5FEDFCD2065636A58C3C4B5B55F0", hash_generated_field = "ECD119DC9718B553F2234545EC22BA22")

    private boolean mShowingStatus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "08B4508B5692245704D9A77DE9CEE5F1", hash_generated_field = "5293923D566F149018DA4160675832F9")

    private boolean mEmergencyCallButtonEnabledInScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "0CC356ECF78F7DFAE70968CD3E9A7877", hash_generated_field = "21B64E443BC1BF1BEA85F9265D07BF58")

    private CharSequence mPlmn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "B08B0FAEE6DFFCF8522E4885E0EEBCCA", hash_generated_field = "DB4A9FA4ADD5145615FEEA3FF5154475")

    private CharSequence mSpn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.124 -0400", hash_original_field = "7AC0737DCEF621593084D09C0D6B7D3F", hash_generated_field = "1C4948430288070588F4043A7708D662")

    protected int mPhoneState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.129 -0400", hash_original_field = "8B60E6E220D705A574760FE0A78811D7", hash_generated_field = "CD2EF0C3226F46345F34E58A0B10F4C9")

    private KeyguardUpdateMonitor.InfoCallback mInfoCallback = new KeyguardUpdateMonitor.InfoCallback()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.125 -0400", hash_original_method = "287CBCDD74B3D7E0990F6E31A00DE82E", hash_generated_method = "ECB2C3D2A730204193D2EC05F7C7D022")
        public void onRefreshBatteryInfo(boolean showBatteryInfo, boolean pluggedIn,
                int batteryLevel) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(batteryLevel);
            addTaint(pluggedIn);
            addTaint(showBatteryInfo);
mShowingBatteryInfo=showBatteryInfomPluggedIn=pluggedInmBatteryLevel=batteryLevel            final MutableInt tmpIcon = new MutableInt(0);
update(BATTERY_INFO, getAltTextMessage(tmpIcon))
            // ---------- Original Method ----------
            //mShowingBatteryInfo = showBatteryInfo;
            //mPluggedIn = pluggedIn;
            //mBatteryLevel = batteryLevel;
            //final MutableInt tmpIcon = new MutableInt(0);
            //update(BATTERY_INFO, getAltTextMessage(tmpIcon));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.126 -0400", hash_original_method = "ED8E9A7D38A7BE93FBAF03966B369E0D", hash_generated_method = "0A2D1B11DBFF871A8932C942A52D82EC")
        public void onTimeChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
refreshDate()
            // ---------- Original Method ----------
            //refreshDate();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.127 -0400", hash_original_method = "174A0765981FC166FADF24904A6ACCA6", hash_generated_method = "BE33B0431BBFBD52136901F7E415E024")
        public void onRefreshCarrierInfo(CharSequence plmn, CharSequence spn) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(spn.getTaint());
            addTaint(plmn.getTaint());
mPlmn=plmnmSpn=spnupdateCarrierStateWithSimStatus(mSimState)
            // ---------- Original Method ----------
            //mPlmn = plmn;
            //mSpn = spn;
            //updateCarrierStateWithSimStatus(mSimState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.127 -0400", hash_original_method = "BA0B67437B81C41F05DFFCECF2CA0F9A", hash_generated_method = "2BE7F90954C478572E0F6B2C4C1C7AF7")
        public void onRingerModeChanged(int state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.128 -0400", hash_original_method = "EFE2A04679C46BD18CE2F50E1BD51D3C", hash_generated_method = "AC1FF5A2B0C7AE484F93C2FE8F4EDF07")
        public void onPhoneStateChanged(int phoneState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(phoneState);
mPhoneState=phoneStateupdateEmergencyCallButtonState(phoneState)
            // ---------- Original Method ----------
            //mPhoneState = phoneState;
            //updateEmergencyCallButtonState(phoneState);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.128 -0400", hash_original_method = "A594812E5C61425FBF654CA49CDC455A", hash_generated_method = "3F25FC61F3F1624FFAD51FB2133914DA")
        public void onClockVisibilityChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.129 -0400", hash_original_method = "7F2CD05A8542D375736A3C5ABB1CBE6D", hash_generated_method = "9A18A3502DD7FF764DF3CFA65CD5682A")
        public void onDeviceProvisioned() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.131 -0400", hash_original_field = "DA6E24740AAF46183A547203E300CE4D", hash_generated_field = "065572874BC3B7FE8D0D8D2D5F6157F3")

    private SimStateCallback mSimStateCallback = new SimStateCallback()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.130 -0400", hash_original_method = "B995874A1BCDC5AB006484982139ECD5", hash_generated_method = "0C2A6371F37C5DB565078774863C12CB")
        public void onSimStateChanged(State simState) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(simState.getTaint());
updateCarrierStateWithSimStatus(simState)
            // ---------- Original Method ----------
            //updateCarrierStateWithSimStatus(simState);
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.132 -0400", hash_original_method = "31601E81B86D37BE10DDE433C646FC67", hash_generated_method = "7A5EC1991C6B5A47468381F39E0A40E4")
    public  KeyguardStatusViewManager(View view, KeyguardUpdateMonitor updateMonitor,
                LockPatternUtils lockPatternUtils, KeyguardScreenCallback callback,
                boolean emergencyButtonEnabledInScreen) {
        addTaint(emergencyButtonEnabledInScreen);
        addTaint(callback.getTaint());
        addTaint(lockPatternUtils.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(view.getTaint());
        if(DEBUG){ }mContainer=viewmDateFormatString=getContext().getString(R.string.abbrev_wday_month_day_no_year)mLockPatternUtils=lockPatternUtilsmUpdateMonitor=updateMonitormCallback=callbackmCarrierView=(TextView) findViewById(R.id.carrier)mDateView=(TextView) findViewById(R.id.date)mStatus1View=(TextView) findViewById(R.id.status1)mAlarmStatusView=(TextView) findViewById(R.id.alarm_status)mOwnerInfoView=(TextView) findViewById(R.id.propertyOf)mTransportView=(TransportControlView) findViewById(R.id.transport)mEmergencyCallButton=(Button) findViewById(R.id.emergencyCallButton)mEmergencyCallButtonEnabledInScreen=emergencyButtonEnabledInScreen        if(mTransportView!=null)        
        {
mTransportView.setVisibility(View.GONE)
        } //End block
        if(mEmergencyCallButton!=null)        
        {
mEmergencyCallButton.setText(R.string.lockscreen_emergency_call)mEmergencyCallButton.setOnClickListener(this)mEmergencyCallButton.setFocusable(false)
        } //End block
mTransientTextManager=new TransientTextManager(mCarrierView)mUpdateMonitor.registerInfoCallback(mInfoCallback)mUpdateMonitor.registerSimStateCallback(mSimStateCallback)resetStatusInfo()refreshDate()updateOwnerInfo()        final View scrollableViews[] = { mCarrierView, mDateView, mStatus1View, mOwnerInfoView,
                mAlarmStatusView };
for(View v : scrollableViews)
        {
            if(v!=null)            
            {
v.setSelected(true)
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.134 -0400", hash_original_method = "5EE6B7E7C84E02354D2F4239B877CB3F", hash_generated_method = "7EDAF332518259AEEBC26AE64F8BA8F7")
    private boolean inWidgetMode() {
        boolean varF44E7FADC7BE86F3C0285B3D09EE5117_2119452128 = (mTransportView!=null&&mTransportView.getVisibility()==View.VISIBLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568580687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568580687;
        // ---------- Original Method ----------
        //return mTransportView != null && mTransportView.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.135 -0400", hash_original_method = "01D8FAF8225BB904B0E11E3766FAD976", hash_generated_method = "488EEA6B58E9027D708076A1CE7D3743")
     void setInstructionText(String string) {
        addTaint(string.getTaint());
mInstructionText=stringupdate(INSTRUCTION_TEXT, string)
        // ---------- Original Method ----------
        //mInstructionText = string;
        //update(INSTRUCTION_TEXT, string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.136 -0400", hash_original_method = "0C879B7AEFB783C4FCF9DD990D1461D4", hash_generated_method = "E9281981867D05B355A071AFC0184E85")
     void setCarrierText(CharSequence string) {
        addTaint(string.getTaint());
mCarrierText=stringupdate(CARRIER_TEXT, string)
        // ---------- Original Method ----------
        //mCarrierText = string;
        //update(CARRIER_TEXT, string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.137 -0400", hash_original_method = "E29B7C80ECE09EB517D7A494F242387E", hash_generated_method = "9B7D9DD4013AC0890DB97DC0B52692AF")
     void setOwnerInfo(CharSequence string) {
        addTaint(string.getTaint());
mOwnerInfoText=stringupdate(OWNER_INFO, string)
        // ---------- Original Method ----------
        //mOwnerInfoText = string;
        //update(OWNER_INFO, string);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.138 -0400", hash_original_method = "496A212771870CC1DF50FBC14CE00B9C", hash_generated_method = "6301AC0FA22E05E85FBF1F4802C11DBD")
    public void setCarrierHelpText(int resId) {
        addTaint(resId);
mCarrierHelpText=getText(resId)update(CARRIER_HELP_TEXT, mCarrierHelpText)
        // ---------- Original Method ----------
        //mCarrierHelpText = getText(resId);
        //update(CARRIER_HELP_TEXT, mCarrierHelpText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.139 -0400", hash_original_method = "8F25B7A7E7109001C0A035E40B08489A", hash_generated_method = "CDC1BCD1714D86F89890C09C1AA8B5AD")
    private CharSequence getText(int resId) {
        addTaint(resId);
CharSequence var89CA7E21784070C63EAFF638BECC939F_1653701972 = resId==0?null:null        var89CA7E21784070C63EAFF638BECC939F_1653701972.addTaint(taint);
        return var89CA7E21784070C63EAFF638BECC939F_1653701972;
        // ---------- Original Method ----------
        //return resId == 0 ? null : getContext().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.140 -0400", hash_original_method = "77349F87796159D0B7B302CDA3B219E9", hash_generated_method = "0FF1F1F12D801FF9C2F7A17F7229083E")
    public void setHelpMessage(int textResId, int lockIcon) {
        addTaint(lockIcon);
        addTaint(textResId);
        final CharSequence tmp = getText(textResId);
mHelpMessageText=tmp==null?null:nullupdate(HELP_MESSAGE_TEXT, mHelpMessageText)
        // ---------- Original Method ----------
        //final CharSequence tmp = getText(textResId);
        //mHelpMessageText = tmp == null ? null : tmp.toString();
        //update(HELP_MESSAGE_TEXT, mHelpMessageText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.141 -0400", hash_original_method = "1B37C976F6E7886BF5588C593A283EDD", hash_generated_method = "95A5F31F6CF1CC5EB87BF06A6250BE79")
    private void update(int what, CharSequence string) {
        addTaint(string.getTaint());
        addTaint(what);
        if(inWidgetMode())        
        {
            if(DEBUG){ }            switch(what){
            case INSTRUCTION_TEXT:
            case CARRIER_HELP_TEXT:
            case HELP_MESSAGE_TEXT:
            case BATTERY_INFO:
mTransientTextManager.post(string, 0, INSTRUCTION_RESET_DELAY)            break;
            case OWNER_INFO:
            case CARRIER_TEXT:
            default:
            if(DEBUG){ }}
        } //End block
        else
        {
updateStatusLines(mShowingStatus)
        } //End block
        // ---------- Original Method ----------
        //if (inWidgetMode()) {
            //if (DEBUG) Log.v(TAG, "inWidgetMode() is true");
            //switch (what) {
                //case INSTRUCTION_TEXT:
                //case CARRIER_HELP_TEXT:
                //case HELP_MESSAGE_TEXT:
                //case BATTERY_INFO:
                    //mTransientTextManager.post(string, 0, INSTRUCTION_RESET_DELAY);
                    //break;
                //case OWNER_INFO:
                //case CARRIER_TEXT:
                //default:
                    //if (DEBUG) Log.w(TAG, "Not showing message id " + what + ", str=" + string);
            //}
        //} else {
            //updateStatusLines(mShowingStatus);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.142 -0400", hash_original_method = "050EBC4996B2350B2E6FF8A9F65CADBB", hash_generated_method = "D6A4B367954FCC26F17EBA0ADAA9E962")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG){ }mUpdateMonitor.removeCallback(mInfoCallback)mUpdateMonitor.removeCallback(mSimStateCallback)
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "onPause()");
        //mUpdateMonitor.removeCallback(mInfoCallback);
        //mUpdateMonitor.removeCallback(mSimStateCallback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.142 -0400", hash_original_method = "65CFD317A0DFDA0C94A487AB476116F9", hash_generated_method = "892C618D3B68BB96A50BBA54CA77DA0F")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(DEBUG){ }mUpdateMonitor.registerInfoCallback(mInfoCallback)mUpdateMonitor.registerSimStateCallback(mSimStateCallback)resetStatusInfo()
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "onResume()");
        //mUpdateMonitor.registerInfoCallback(mInfoCallback);
        //mUpdateMonitor.registerSimStateCallback(mSimStateCallback);
        //resetStatusInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.143 -0400", hash_original_method = "B42C6C3534528146E7C51CBD5B4712D7", hash_generated_method = "3AFEBE1164BA7A655B2FB04E36426C21")
     void resetStatusInfo() {
mInstructionText=nullmShowingBatteryInfo=mUpdateMonitor.shouldShowBatteryInfo()mPluggedIn=mUpdateMonitor.isDevicePluggedIn()mBatteryLevel=mUpdateMonitor.getBatteryLevel()updateStatusLines(true)
        // ---------- Original Method ----------
        //mInstructionText = null;
        //mShowingBatteryInfo = mUpdateMonitor.shouldShowBatteryInfo();
        //mPluggedIn = mUpdateMonitor.isDevicePluggedIn();
        //mBatteryLevel = mUpdateMonitor.getBatteryLevel();
        //updateStatusLines(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.144 -0400", hash_original_method = "F251353B3EC05011C60D5DF0A2B651CE", hash_generated_method = "7C264A1846CE47A2E7DA37BFEC4E430D")
     void updateStatusLines(boolean showStatusLines) {
        addTaint(showStatusLines);
        if(DEBUG){ }mShowingStatus=showStatusLinesupdateAlarmInfo()updateOwnerInfo()updateStatus1()updateCarrierText()
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "updateStatusLines(" + showStatusLines + ")");
        //mShowingStatus = showStatusLines;
        //updateAlarmInfo();
        //updateOwnerInfo();
        //updateStatus1();
        //updateCarrierText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.145 -0400", hash_original_method = "31E188D33D825D11A5F613B53D871D17", hash_generated_method = "59C78D7E3D5BAFBBCC6BC3C431A15997")
    private void updateAlarmInfo() {
        if(mAlarmStatusView!=null)        
        {
            String nextAlarm = mLockPatternUtils.getNextAlarm();
            boolean showAlarm = mShowingStatus && !TextUtils.isEmpty(nextAlarm);
mAlarmStatusView.setText(nextAlarm)mAlarmStatusView.setCompoundDrawablesWithIntrinsicBounds(ALARM_ICON, 0, 0, 0)mAlarmStatusView.setVisibility(showAlarm?View.VISIBLE:View.VISIBLE)
        } //End block
        // ---------- Original Method ----------
        //if (mAlarmStatusView != null) {
            //String nextAlarm = mLockPatternUtils.getNextAlarm();
            //boolean showAlarm = mShowingStatus && !TextUtils.isEmpty(nextAlarm);
            //mAlarmStatusView.setText(nextAlarm);
            //mAlarmStatusView.setCompoundDrawablesWithIntrinsicBounds(ALARM_ICON, 0, 0, 0);
            //mAlarmStatusView.setVisibility(showAlarm ? View.VISIBLE : View.GONE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.146 -0400", hash_original_method = "65258C83A3104F091E1C5757CBA0E6D5", hash_generated_method = "8F7A6BABA72ACB4AF6F03377C296EBCC")
    private void updateOwnerInfo() {
        final ContentResolver res = getContext().getContentResolver();
        final boolean ownerInfoEnabled = Settings.Secure.getInt(res,
                Settings.Secure.LOCK_SCREEN_OWNER_INFO_ENABLED, 1) != 0;
mOwnerInfoText=ownerInfoEnabled?Settings.Secure.getString(res, Settings.Secure.LOCK_SCREEN_OWNER_INFO):Settings.Secure.getString(res, Settings.Secure.LOCK_SCREEN_OWNER_INFO)        if(mOwnerInfoView!=null)        
        {
mOwnerInfoView.setText(mOwnerInfoText)mOwnerInfoView.setVisibility(TextUtils.isEmpty(mOwnerInfoText)?View.GONE:View.GONE)
        } //End block
        // ---------- Original Method ----------
        //final ContentResolver res = getContext().getContentResolver();
        //final boolean ownerInfoEnabled = Settings.Secure.getInt(res,
                //Settings.Secure.LOCK_SCREEN_OWNER_INFO_ENABLED, 1) != 0;
        //mOwnerInfoText = ownerInfoEnabled ?
                //Settings.Secure.getString(res, Settings.Secure.LOCK_SCREEN_OWNER_INFO) : null;
        //if (mOwnerInfoView != null) {
            //mOwnerInfoView.setText(mOwnerInfoText);
            //mOwnerInfoView.setVisibility(TextUtils.isEmpty(mOwnerInfoText) ? View.GONE:View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.147 -0400", hash_original_method = "6E5AB375483BC379EF0B5586B35D26F7", hash_generated_method = "CBC53BA8F18246D3B76DD0F85F5E0258")
    private void updateStatus1() {
        if(mStatus1View!=null)        
        {
            MutableInt icon = new MutableInt(0);
            CharSequence string = getPriorityTextMessage(icon);
mStatus1View.setText(string)mStatus1View.setCompoundDrawablesWithIntrinsicBounds(icon.value, 0, 0, 0)mStatus1View.setVisibility(mShowingStatus?View.VISIBLE:View.VISIBLE)
        } //End block
        // ---------- Original Method ----------
        //if (mStatus1View != null) {
            //MutableInt icon = new MutableInt(0);
            //CharSequence string = getPriorityTextMessage(icon);
            //mStatus1View.setText(string);
            //mStatus1View.setCompoundDrawablesWithIntrinsicBounds(icon.value, 0, 0, 0);
            //mStatus1View.setVisibility(mShowingStatus ? View.VISIBLE : View.INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.148 -0400", hash_original_method = "C5B34A24EB59DECFB29CC6C2DF9D2BC7", hash_generated_method = "5906B7DC2F48501DFB0DB2CBDF5A2867")
    private void updateCarrierText() {
        if(!inWidgetMode()&&mCarrierView!=null)        
        {
mCarrierView.setText(mCarrierText)
        } //End block
        // ---------- Original Method ----------
        //if (!inWidgetMode() && mCarrierView != null) {
            //mCarrierView.setText(mCarrierText);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.150 -0400", hash_original_method = "BC587D42AEA99F87961A43106CBF197F", hash_generated_method = "9FA66DD39045E535DEDDF73B8285198F")
    private CharSequence getAltTextMessage(MutableInt icon) {
        addTaint(icon.getTaint());
        CharSequence string = null;
        if(mShowingBatteryInfo)        
        {
            if(mPluggedIn)            
            {
                if(mUpdateMonitor.isDeviceCharged())                
                {
string=getContext().getString(R.string.lockscreen_charged)
                } //End block
                else
                {
string=getContext().getString(R.string.lockscreen_plugged_in, mBatteryLevel)
                } //End block
icon.value=CHARGING_ICON
            } //End block
            else
            if(mBatteryLevel<KeyguardUpdateMonitor.LOW_BATTERY_THRESHOLD)            
            {
string=getContext().getString(R.string.lockscreen_low_battery)icon.value=BATTERY_LOW_ICON
            } //End block
        } //End block
        else
        {
string=mCarrierText
        } //End block
CharSequence varDCF8A90B03379D9C1C8BF337A3879E0C_2002625610 = string        varDCF8A90B03379D9C1C8BF337A3879E0C_2002625610.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_2002625610;
        // ---------- Original Method ----------
        //CharSequence string = null;
        //if (mShowingBatteryInfo) {
            //if (mPluggedIn) {
                //if (mUpdateMonitor.isDeviceCharged()) {
                    //string = getContext().getString(R.string.lockscreen_charged);
                //} else {
                    //string = getContext().getString(R.string.lockscreen_plugged_in, mBatteryLevel);
                //}
                //icon.value = CHARGING_ICON;
            //} else if (mBatteryLevel < KeyguardUpdateMonitor.LOW_BATTERY_THRESHOLD) {
                //string = getContext().getString(R.string.lockscreen_low_battery);
                //icon.value = BATTERY_LOW_ICON;
            //}
        //} else {
            //string = mCarrierText;
        //}
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.152 -0400", hash_original_method = "29AF6D60894BDEEE0E55CEC530592B3E", hash_generated_method = "3D74D0F703278D8EADD219665110E6D9")
    private CharSequence getPriorityTextMessage(MutableInt icon) {
        addTaint(icon.getTaint());
        CharSequence string = null;
        if(!TextUtils.isEmpty(mInstructionText))        
        {
string=mInstructionTexticon.value=LOCK_ICON
        } //End block
        else
        if(mShowingBatteryInfo)        
        {
            if(mPluggedIn)            
            {
                if(mUpdateMonitor.isDeviceCharged())                
                {
string=getContext().getString(R.string.lockscreen_charged)
                } //End block
                else
                {
string=getContext().getString(R.string.lockscreen_plugged_in, mBatteryLevel)
                } //End block
icon.value=CHARGING_ICON
            } //End block
            else
            if(mBatteryLevel<KeyguardUpdateMonitor.LOW_BATTERY_THRESHOLD)            
            {
string=getContext().getString(R.string.lockscreen_low_battery)icon.value=BATTERY_LOW_ICON
            } //End block
        } //End block
        else
        if(!inWidgetMode()&&mOwnerInfoView==null&&mOwnerInfoText!=null)        
        {
string=mOwnerInfoText
        } //End block
CharSequence varDCF8A90B03379D9C1C8BF337A3879E0C_1801449832 = string        varDCF8A90B03379D9C1C8BF337A3879E0C_1801449832.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_1801449832;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.153 -0400", hash_original_method = "66AD4FC6C63879FC6AD36B3CF52CE386", hash_generated_method = "CC5C7E5DB4F8CAEFA4E017DC40D146BA")
     void refreshDate() {
        if(mDateView!=null)        
        {
mDateView.setText(DateFormat.format(mDateFormatString, new Date()))
        } //End block
        // ---------- Original Method ----------
        //if (mDateView != null) {
            //mDateView.setText(DateFormat.format(mDateFormatString, new Date()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.155 -0400", hash_original_method = "D345C0D13A323FFD5D1BBD085AFAAD57", hash_generated_method = "152D83D660F7FE70029C951C9BD782B1")
    public StatusMode getStatusForIccState(IccCard.State simState) {
        addTaint(simState.getTaint());
        if(simState==null)        
        {
StatusMode var74689AD7CB0D7A50401D144AE6840142_1154956583 = StatusMode.Normal            var74689AD7CB0D7A50401D144AE6840142_1154956583.addTaint(taint);
            return var74689AD7CB0D7A50401D144AE6840142_1154956583;
        } //End block
        final boolean missingAndNotProvisioned = (!mUpdateMonitor.isDeviceProvisioned()
                && (simState == IccCard.State.ABSENT || simState == IccCard.State.PERM_DISABLED));
simState=missingAndNotProvisioned?State.NETWORK_LOCKED:State.NETWORK_LOCKED        switch(simState){
        case ABSENT:
StatusMode var055731ECFEA7E9AE3FF4D8BF246E580B_993263700 = StatusMode.SimMissing        var055731ECFEA7E9AE3FF4D8BF246E580B_993263700.addTaint(taint);
        return var055731ECFEA7E9AE3FF4D8BF246E580B_993263700;
        case NETWORK_LOCKED:
StatusMode var465A6F7B521794277070AB366FDBBD37_676784587 = StatusMode.SimMissingLocked        var465A6F7B521794277070AB366FDBBD37_676784587.addTaint(taint);
        return var465A6F7B521794277070AB366FDBBD37_676784587;
        case NOT_READY:
StatusMode var055731ECFEA7E9AE3FF4D8BF246E580B_468648569 = StatusMode.SimMissing        var055731ECFEA7E9AE3FF4D8BF246E580B_468648569.addTaint(taint);
        return var055731ECFEA7E9AE3FF4D8BF246E580B_468648569;
        case PIN_REQUIRED:
StatusMode varF07175C45998B94FFF6179657ADF0F23_1763958298 = StatusMode.SimLocked        varF07175C45998B94FFF6179657ADF0F23_1763958298.addTaint(taint);
        return varF07175C45998B94FFF6179657ADF0F23_1763958298;
        case PUK_REQUIRED:
StatusMode varCF820DB2903EA747AB5AC8E489B0AF03_215950282 = StatusMode.SimPukLocked        varCF820DB2903EA747AB5AC8E489B0AF03_215950282.addTaint(taint);
        return varCF820DB2903EA747AB5AC8E489B0AF03_215950282;
        case READY:
StatusMode var74689AD7CB0D7A50401D144AE6840142_780555261 = StatusMode.Normal        var74689AD7CB0D7A50401D144AE6840142_780555261.addTaint(taint);
        return var74689AD7CB0D7A50401D144AE6840142_780555261;
        case PERM_DISABLED:
StatusMode var59C91FA7BC8766649B2AD561A705BF6F_2041051339 = StatusMode.SimPermDisabled        var59C91FA7BC8766649B2AD561A705BF6F_2041051339.addTaint(taint);
        return var59C91FA7BC8766649B2AD561A705BF6F_2041051339;
        case UNKNOWN:
StatusMode var055731ECFEA7E9AE3FF4D8BF246E580B_169878406 = StatusMode.SimMissing        var055731ECFEA7E9AE3FF4D8BF246E580B_169878406.addTaint(taint);
        return var055731ECFEA7E9AE3FF4D8BF246E580B_169878406;
}StatusMode var055731ECFEA7E9AE3FF4D8BF246E580B_1159996998 = StatusMode.SimMissing        var055731ECFEA7E9AE3FF4D8BF246E580B_1159996998.addTaint(taint);
        return var055731ECFEA7E9AE3FF4D8BF246E580B_1159996998;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.156 -0400", hash_original_method = "0C160F3151520CCAEE281805B105D856", hash_generated_method = "6224AD344A2127E08B4D0D1C82C26B42")
    private Context getContext() {
Context var28512C57E29860CAFFE386FB17531C31_770492991 = mContainer.getContext()        var28512C57E29860CAFFE386FB17531C31_770492991.addTaint(taint);
        return var28512C57E29860CAFFE386FB17531C31_770492991;
        // ---------- Original Method ----------
        //return mContainer.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.159 -0400", hash_original_method = "1B73943EF9A620CE50EA64B09638FFD8", hash_generated_method = "06E7770D3F7ECBC32A20C3464267B213")
    private void updateCarrierStateWithSimStatus(State simState) {
        addTaint(simState.getTaint());
        if(DEBUG)        
Log.d(TAG, "updateCarrierTextWithSimStatus(), simState = "+simState)
        CharSequence carrierText = null;
        int carrierHelpTextId = 0;
mEmergencyButtonEnabledBecauseSimLocked=falsemStatus=getStatusForIccState(simState)mSimState=simState        switch(mStatus){
        case Normal:
carrierText=makeCarierString(mPlmn, mSpn)        break;
        case NetworkLocked:
carrierText=makeCarrierStringOnEmergencyCapable(getContext().getText(R.string.lockscreen_network_locked_message), mPlmn)carrierHelpTextId=R.string.lockscreen_instructions_when_pattern_disabled        break;
        case SimMissing:
carrierText=makeCarrierStringOnEmergencyCapable(getContext().getText(R.string.lockscreen_missing_sim_message_short), mPlmn)carrierHelpTextId=R.string.lockscreen_missing_sim_instructions_long        break;
        case SimPermDisabled:
carrierText=getContext().getText(R.string.lockscreen_missing_sim_message_short)carrierHelpTextId=R.string.lockscreen_permanent_disabled_sim_instructionsmEmergencyButtonEnabledBecauseSimLocked=true        break;
        case SimMissingLocked:
carrierText=makeCarrierStringOnEmergencyCapable(getContext().getText(R.string.lockscreen_missing_sim_message_short), mPlmn)carrierHelpTextId=R.string.lockscreen_missing_sim_instructionsmEmergencyButtonEnabledBecauseSimLocked=true        break;
        case SimLocked:
carrierText=makeCarrierStringOnEmergencyCapable(getContext().getText(R.string.lockscreen_sim_locked_message), mPlmn)mEmergencyButtonEnabledBecauseSimLocked=true        break;
        case SimPukLocked:
carrierText=makeCarrierStringOnEmergencyCapable(getContext().getText(R.string.lockscreen_sim_puk_locked_message), mPlmn)        if(!mLockPatternUtils.isPukUnlockScreenEnable())        
        {
mEmergencyButtonEnabledBecauseSimLocked=true
        } //End block
        break;
}setCarrierText(carrierText)setCarrierHelpText(carrierHelpTextId)updateEmergencyCallButtonState(mPhoneState)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.160 -0400", hash_original_method = "610E2AAE64679BFC4776C5E9909C5A61", hash_generated_method = "C4D866D27E957E1D745090B8BF556729")
    private CharSequence makeCarrierStringOnEmergencyCapable(
            CharSequence simMessage, CharSequence emergencyCallMessage) {
        addTaint(emergencyCallMessage.getTaint());
        addTaint(simMessage.getTaint());
        if(mLockPatternUtils.isEmergencyCallCapable())        
        {
CharSequence varBCA9FE289536EEE43DE50097A43E66B3_991115842 = makeCarierString(simMessage, emergencyCallMessage)            varBCA9FE289536EEE43DE50097A43E66B3_991115842.addTaint(taint);
            return varBCA9FE289536EEE43DE50097A43E66B3_991115842;
        } //End block
CharSequence var6D3C4BDAFE503C917CBF4FC6E14B0CA7_1771463767 = simMessage        var6D3C4BDAFE503C917CBF4FC6E14B0CA7_1771463767.addTaint(taint);
        return var6D3C4BDAFE503C917CBF4FC6E14B0CA7_1771463767;
        // ---------- Original Method ----------
        //if (mLockPatternUtils.isEmergencyCallCapable()) {
            //return makeCarierString(simMessage, emergencyCallMessage);
        //}
        //return simMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.162 -0400", hash_original_method = "964F9F52788590B964A5724A32323B3B", hash_generated_method = "05503250EDFF08E06F77A58F0620FBCD")
    private View findViewById(int id) {
        addTaint(id);
View var340D4B852DDA928E863464B34373AFBE_384745613 = mContainer.findViewById(id)        var340D4B852DDA928E863464B34373AFBE_384745613.addTaint(taint);
        return var340D4B852DDA928E863464B34373AFBE_384745613;
        // ---------- Original Method ----------
        //return mContainer.findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.163 -0400", hash_original_method = "DB5879746E80604C064133E42EFCC4AC", hash_generated_method = "17FAFE4266095540016269945329E5DC")
    private void updateEmergencyCallButtonState(int phoneState) {
        addTaint(phoneState);
        if(mEmergencyCallButton!=null)        
        {
            boolean enabledBecauseSimLocked = mLockPatternUtils.isEmergencyCallEnabledWhileSimLocked()
                    && mEmergencyButtonEnabledBecauseSimLocked;
            boolean shown = mEmergencyCallButtonEnabledInScreen || enabledBecauseSimLocked;
mLockPatternUtils.updateEmergencyCallButtonState(mEmergencyCallButton, phoneState, shown)
        } //End block
        // ---------- Original Method ----------
        //if (mEmergencyCallButton != null) {
            //boolean enabledBecauseSimLocked =
                    //mLockPatternUtils.isEmergencyCallEnabledWhileSimLocked()
                    //&& mEmergencyButtonEnabledBecauseSimLocked;
            //boolean shown = mEmergencyCallButtonEnabledInScreen || enabledBecauseSimLocked;
            //mLockPatternUtils.updateEmergencyCallButtonState(mEmergencyCallButton,
                    //phoneState, shown);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.164 -0400", hash_original_method = "1FC57D5B36FE4D779CF1DC67BCC2E605", hash_generated_method = "CBDF4DB74D659153520F3B21AE87AEFB")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(v==mEmergencyCallButton)        
        {
mCallback.takeEmergencyCallAction()
        } //End block
        // ---------- Original Method ----------
        //if (v == mEmergencyCallButton) {
            //mCallback.takeEmergencyCallAction();
        //}
    }

    
        private static CharSequence makeCarierString(CharSequence plmn, CharSequence spn) {
        final boolean plmnValid = !TextUtils.isEmpty(plmn);
        final boolean spnValid = !TextUtils.isEmpty(spn);
        if (plmnValid && spnValid) {
            return plmn + "|" + spn;
        } else if (plmnValid) {
            return plmn;
        } else if (spnValid) {
            return spn;
        } else {
            return "";
        }
    }

    
    private class TransientTextManager {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.165 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

        private TextView mTextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.165 -0400", hash_original_field = "46E3018F20FB3053BF3C9C98CE1FA559", hash_generated_field = "7702118D41EE2A2C4881C132D7F0DCAD")

        private ArrayList<Data> mMessages = new ArrayList<Data>(5);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.166 -0400", hash_original_method = "53B8EF79044E71835691CCA050C113E9", hash_generated_method = "D7EAF1B498DAF2A7484C07FF83C0182C")
          TransientTextManager(TextView textView) {
            addTaint(textView.getTaint());
mTextView=textView
            // ---------- Original Method ----------
            //mTextView = textView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.169 -0400", hash_original_method = "F0404BE7F945E6EFDCDCAC622C63C303", hash_generated_method = "50073F5910288B2504F85C9A95215CFC")
         void post(final CharSequence message, final int icon, long duration) {
            addTaint(duration);
            addTaint(icon);
            addTaint(message.getTaint());
            if(mTextView==null)            
            {
                return;
            } //End block
mTextView.setText(message)mTextView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)            final Data data = new Data(message, icon);
mContainer.postDelayed(new Runnable()            {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.168 -0400", hash_original_method = "A0A30C020D410BB77E1723847482451F", hash_generated_method = "E94FF5A5EB762921A574ADC0186E176E")
            public void run() {
mMessages.remove(data)                int last = mMessages.size() - 1;
                CharSequence lastText;
                int lastIcon;
                if(last>0)                
                {
                    final Data oldData = mMessages.get(last);
lastText=oldData.textlastIcon=oldData.icon
                } //End block
                else
                {
                    final MutableInt tmpIcon = new MutableInt(0);
lastText=getAltTextMessage(tmpIcon)lastIcon=tmpIcon.value
                } //End block
mTextView.setText(lastText)mTextView.setCompoundDrawablesWithIntrinsicBounds(lastIcon, 0, 0, 0)
                // ---------- Original Method ----------
                //mMessages.remove(data);
                //int last = mMessages.size() - 1;
                //final CharSequence lastText;
                //final int lastIcon;
                //if (last > 0) {
                        //final Data oldData = mMessages.get(last);
                        //lastText = oldData.text;
                        //lastIcon = oldData.icon;
                    //} else {
                        //final MutableInt tmpIcon = new MutableInt(0);
                        //lastText = getAltTextMessage(tmpIcon);
                        //lastIcon = tmpIcon.value;
                    //}
                //mTextView.setText(lastText);
                //mTextView.setCompoundDrawablesWithIntrinsicBounds(lastIcon, 0, 0, 0);
            }
            }
, duration)
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class Data {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.170 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "107298D9FB7BD66B47A702264D3B04F5")

            int icon;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.170 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "0F26345BF87C16C80BAC76779863E330")

            CharSequence text;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.172 -0400", hash_original_method = "9E158BF0EBFFBA127B98D872E2157647", hash_generated_method = "716C6E20A7462BF0665DDFCABCD969C5")
              Data(CharSequence t, int i) {
                addTaint(i);
                addTaint(t.getTaint());
text=ticon=i
                // ---------- Original Method ----------
                //text = t;
                //icon = i;
            }

            
        }


        
    }


    
    enum StatusMode {
        Normal(true),
        NetworkLocked(true),
        SimMissing(false),
        SimMissingLocked(false),
        SimPukLocked(false),
        SimLocked(true),
        SimPermDisabled(false);
        private final boolean mShowStatusLines;
        StatusMode(boolean mShowStatusLines) {
            this.mShowStatusLines = mShowStatusLines;
        }
        public boolean shouldShowStatusLines() {
            return mShowStatusLines;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.173 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:41.174 -0400", hash_original_field = "D7D78CE7E80F6C5E661E56966321B2D5", hash_generated_field = "94D3CF35CABF03EA4CF73BF70EB3E96F")

    private static final String TAG = "KeyguardStatusView";

