package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.ProgressDialog;
import com.android.internal.R;
import android.app.Dialog;
import android.view.WindowManager;
import android.view.View;
import android.widget.TextView;
import com.android.internal.telephony.ITelephony;
import android.text.Editable;
import android.widget.Button;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.widget.LockPatternUtils;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.content.res.Configuration;
import android.view.LayoutInflater;
public class SimUnlockScreen extends LinearLayout implements KeyguardScreen, View.OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.244 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.244 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.244 -0400", hash_original_field = "92E07B2B1A0E8699FA0FC2D997A04F18", hash_generated_field = "B4C6489DF78DED408503A9F978A2B5C8")

    private TextView mHeaderText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.245 -0400", hash_original_field = "3D24E93F5593A49B182C57D7F80BAAB8", hash_generated_field = "C5DB28CAF27EC266D800F31C4E8176B9")

    private TextView mPinText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.245 -0400", hash_original_field = "66CBB0A8F64AC511DE1CFBE71543AA6F", hash_generated_field = "7E99E9C2A01A9C26004B89316DA44113")

    private TextView mOkButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.245 -0400", hash_original_field = "54AFFAC28D246CA359D70D4A87B23241", hash_generated_field = "8D8276632DD9149D88D7A39CC40A43E6")

    private View mBackSpaceButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.245 -0400", hash_original_field = "03D8832082987DD9651C455F66760515", hash_generated_field = "6CC244B117906FE05F048E2EE615DD66")

    private final int[] mEnteredPin = {0, 0, 0, 0, 0, 0, 0, 0, };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.245 -0400", hash_original_field = "3247CDD5B4959B5636D3C491A32DB69E", hash_generated_field = "B74212FC8CEF1D0FB9FE872E8F5AC880")

    private int mEnteredDigits = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.246 -0400", hash_original_field = "37BDB22916B17AF99E84E7FFD6D7CE26", hash_generated_field = "B714BA463D7EBA4FA60F87C6272A6DDF")

    private ProgressDialog mSimUnlockProgressDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.246 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.246 -0400", hash_original_field = "8650EFA3EAFF9E8580ED2BAF39D373A4", hash_generated_field = "D4F52B2DF2B3F133070FDB68D5444936")

    private int mCreationOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.246 -0400", hash_original_field = "DBC9BD3F128308E3E39537030A1C88EF", hash_generated_field = "69947A686D730ED6BFB8241A3DBF0C42")

    private int mKeyboardHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.246 -0400", hash_original_field = "CA3AE29687B50BD85F0CB06CCFB84E11", hash_generated_field = "D443E37F869F21F4F6889602CFB5CE23")

    private KeyguardStatusViewManager mKeyguardStatusViewManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.247 -0400", hash_original_method = "184340062F421CA303DEE6225B9843B3", hash_generated_method = "7F37C1970BCD3AEA02AE5C102E9D0631")
    public  SimUnlockScreen(Context context, Configuration configuration,
            KeyguardUpdateMonitor updateMonitor, KeyguardScreenCallback callback,
            LockPatternUtils lockpatternutils) {
        super(context);
        addTaint(lockpatternutils.getTaint());
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mUpdateMonitor=updateMonitormCallback=callbackmCreationOrientation=configuration.orientationmKeyboardHidden=configuration.hardKeyboardHiddenmLockPatternUtils=lockpatternutils        LayoutInflater inflater = LayoutInflater.from(context);
        if(mKeyboardHidden==Configuration.HARDKEYBOARDHIDDEN_NO)        
        {
inflater.inflate(R.layout.keyguard_screen_sim_pin_landscape, this, true)
        } //End block
        else
        {
inflater.inflate(R.layout.keyguard_screen_sim_pin_portrait, this, true)new TouchInput()
        } //End block
mHeaderText=(TextView) findViewById(R.id.headerText)mPinText=(TextView) findViewById(R.id.pinDisplay)mBackSpaceButton=findViewById(R.id.backspace)mBackSpaceButton.setOnClickListener(this)mOkButton=(TextView) findViewById(R.id.ok)mHeaderText.setText(R.string.keyguard_password_enter_pin_code)mPinText.setFocusable(false)mOkButton.setOnClickListener(this)mKeyguardStatusViewManager=new KeyguardStatusViewManager(this, updateMonitor, lockpatternutils, callback, false)setFocusableInTouchMode(true)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.248 -0400", hash_original_method = "03417B513FCDBDE5BF931CF3F9740388", hash_generated_method = "9CEBC445953833FAAE517946EB910275")
    public boolean needsInput() {
        boolean varB326B5062B2F0E69046810717534CB09_230228973 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434081592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434081592;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.248 -0400", hash_original_method = "440CB18BD14857ECDCCCF4D80E037E23", hash_generated_method = "E02E07154151F9B60B5BF671FBC9F1FB")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mKeyguardStatusViewManager.onPause()
        // ---------- Original Method ----------
        //mKeyguardStatusViewManager.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.248 -0400", hash_original_method = "9506E2163949EE029EE22700E99D72B0", hash_generated_method = "2ACEF1C7C743BC6F8C590C2AE5BDE287")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mHeaderText.setText(R.string.keyguard_password_enter_pin_code)mPinText.setText("")mEnteredDigits=0mKeyguardStatusViewManager.onResume()
        // ---------- Original Method ----------
        //mHeaderText.setText(R.string.keyguard_password_enter_pin_code);
        //mPinText.setText("");
        //mEnteredDigits = 0;
        //mKeyguardStatusViewManager.onResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.249 -0400", hash_original_method = "4F56B8371F6E4189658A07455244C5AE", hash_generated_method = "B34EE96BECB6D2417C55345722D03167")
    public void cleanUp() {
        if(mSimUnlockProgressDialog!=null)        
        {
mSimUnlockProgressDialog.dismiss()mSimUnlockProgressDialog=null
        } //End block
mUpdateMonitor.removeCallback(this)
        // ---------- Original Method ----------
        //if (mSimUnlockProgressDialog != null) {
            //mSimUnlockProgressDialog.dismiss();
            //mSimUnlockProgressDialog = null;
        //}
        //mUpdateMonitor.removeCallback(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.250 -0400", hash_original_method = "94EDED705A0B25E95A2EF49A56A81273", hash_generated_method = "C96960E16F780E07835697C383708D40")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(v==mBackSpaceButton)        
        {
            final Editable digits = mPinText.getEditableText();
            final int len = digits.length();
            if(len>0)            
            {
digits.delete(len-1, len)mEnteredDigits
            } //End block
mCallback.pokeWakelock()
        } //End block
        else
        if(v==mOkButton)        
        {
checkPin()
        } //End block
        // ---------- Original Method ----------
        //if (v == mBackSpaceButton) {
            //final Editable digits = mPinText.getEditableText();
            //final int len = digits.length();
            //if (len > 0) {
                //digits.delete(len-1, len);
                //mEnteredDigits--;
            //}
            //mCallback.pokeWakelock();
        //} else if (v == mOkButton) {
            //checkPin();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.250 -0400", hash_original_method = "93BC6D4938B62F663C4EEE0C7C888414", hash_generated_method = "444CC8E7BCE41BA6A4201ADF60C24EF3")
    private Dialog getSimUnlockProgressDialog() {
        if(mSimUnlockProgressDialog==null)        
        {
mSimUnlockProgressDialog=new ProgressDialog(mContext)mSimUnlockProgressDialog.setMessage(mContext.getString(R.string.lockscreen_sim_unlock_progress_dialog_message))mSimUnlockProgressDialog.setIndeterminate(true)mSimUnlockProgressDialog.setCancelable(false)mSimUnlockProgressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)
        } //End block
Dialog var8EA120C784E35FF1CB5979BAFDCF5288_1945880436 = mSimUnlockProgressDialog        var8EA120C784E35FF1CB5979BAFDCF5288_1945880436.addTaint(taint);
        return var8EA120C784E35FF1CB5979BAFDCF5288_1945880436;
        // ---------- Original Method ----------
        //if (mSimUnlockProgressDialog == null) {
            //mSimUnlockProgressDialog = new ProgressDialog(mContext);
            //mSimUnlockProgressDialog.setMessage(
                    //mContext.getString(R.string.lockscreen_sim_unlock_progress_dialog_message));
            //mSimUnlockProgressDialog.setIndeterminate(true);
            //mSimUnlockProgressDialog.setCancelable(false);
            //mSimUnlockProgressDialog.getWindow().setType(
                    //WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        //}
        //return mSimUnlockProgressDialog;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.252 -0400", hash_original_method = "9352580049DCA0D29FA6D2489DD68DA5", hash_generated_method = "913CD443D255D054448190584CF48725")
    private void checkPin() {
        if(mEnteredDigits<4)        
        {
mHeaderText.setText(R.string.invalidPin)mPinText.setText("")mEnteredDigits=0mCallback.pokeWakelock()            return;
        } //End block
getSimUnlockProgressDialog().show()new CheckSimPin(mPinText.getText().toString())        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.252 -0400", hash_original_method = "9DF8224F15C32CD2879A2212C7EC8C96", hash_generated_method = "CC24CA9C3D493EC50CB2B5F2E1CE282B")
         void onSimLockChangedResponse(final boolean success) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(success);
mPinText.post(new Runnable()            {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.252 -0400", hash_original_method = "72E374BCCC7E6995D2BF732257950E9C", hash_generated_method = "F168F4764C865CB7FA304537378FD370")
            public void run() {
                if(mSimUnlockProgressDialog!=null)                
                {
mSimUnlockProgressDialog.hide()
                } //End block
                if(success)                
                {
mUpdateMonitor.reportSimUnlocked()mCallback.goToUnlockScreen()
                } //End block
                else
                {
mHeaderText.setText(R.string.keyguard_password_wrong_pin_code)mPinText.setText("")mEnteredDigits=0
                } //End block
mCallback.pokeWakelock()
                // ---------- Original Method ----------
                //if (mSimUnlockProgressDialog != null) {
                            //mSimUnlockProgressDialog.hide();
                        //}
                //if (success) {
                            //mUpdateMonitor.reportSimUnlocked();
                            //mCallback.goToUnlockScreen();
                        //} else {
                            //mHeaderText.setText(R.string.keyguard_password_wrong_pin_code);
                            //mPinText.setText("");
                            //mEnteredDigits = 0;
                        //}
                //mCallback.pokeWakelock();
            }
            }
)
            // ---------- Original Method ----------
            //mPinText.post(new Runnable() {
                    //public void run() {
                        //if (mSimUnlockProgressDialog != null) {
                            //mSimUnlockProgressDialog.hide();
                        //}
                        //if (success) {
                            //mUpdateMonitor.reportSimUnlocked();
                            //mCallback.goToUnlockScreen();
                        //} else {
                            //mHeaderText.setText(R.string.keyguard_password_wrong_pin_code);
                            //mPinText.setText("");
                            //mEnteredDigits = 0;
                        //}
                        //mCallback.pokeWakelock();
                    //}
                //});
        }
        }
.start()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.254 -0400", hash_original_method = "EE9F9F0215A6BD0F26A33094F367031C", hash_generated_method = "04D7D1D53A88E18141BBBC9A7853693B")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode==KeyEvent.KEYCODE_BACK)        
        {
mCallback.goToLockScreen()            boolean varB326B5062B2F0E69046810717534CB09_1459217583 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634150773 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634150773;
        } //End block
        final char match = event.getMatch(DIGITS);
        if(match!=0)        
        {
reportDigit(match-'0')            boolean varB326B5062B2F0E69046810717534CB09_1417786898 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112430084 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112430084;
        } //End block
        if(keyCode==KeyEvent.KEYCODE_DEL)        
        {
            if(mEnteredDigits>0)            
            {
mPinText.onKeyDown(keyCode, event)mEnteredDigits
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_76647752 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234491706 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234491706;
        } //End block
        if(keyCode==KeyEvent.KEYCODE_ENTER)        
        {
checkPin()            boolean varB326B5062B2F0E69046810717534CB09_79779438 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684893044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684893044;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_382655821 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89121522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89121522;
        // ---------- Original Method ----------
        //if (keyCode == KeyEvent.KEYCODE_BACK) {
            //mCallback.goToLockScreen();
            //return true;
        //}
        //final char match = event.getMatch(DIGITS);
        //if (match != 0) {
            //reportDigit(match - '0');
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_DEL) {
            //if (mEnteredDigits > 0) {
                //mPinText.onKeyDown(keyCode, event);
                //mEnteredDigits--;
            //}
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_ENTER) {
            //checkPin();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.255 -0400", hash_original_method = "6AE07C4FD48DF490F07469CD803CBE9B", hash_generated_method = "536E73DB5899049DC7D371E5A7215E9E")
    private void reportDigit(int digit) {
        addTaint(digit);
        if(mEnteredDigits==0)        
        {
mPinText.setText("")
        } //End block
        if(mEnteredDigits==8)        
        {
            return;
        } //End block
mPinText.append(Integer.toString(digit))mEnteredPin[mEnteredDigits++]=digit
        // ---------- Original Method ----------
        //if (mEnteredDigits == 0) {
            //mPinText.setText("");
        //}
        //if (mEnteredDigits == 8) {
            //return;
        //}
        //mPinText.append(Integer.toString(digit));
        //mEnteredPin[mEnteredDigits++] = digit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.255 -0400", hash_original_method = "41FD104E5C88C6B282E84F54A5E345DD", hash_generated_method = "8FFA7AEB4CFD6FF4761C77BFE69E66B3")
     void updateConfiguration() {
        Configuration newConfig = getResources().getConfiguration();
        if(newConfig.orientation!=mCreationOrientation)        
        {
mCallback.recreateMe(newConfig)
        } //End block
        else
        if(newConfig.hardKeyboardHidden!=mKeyboardHidden)        
        {
mKeyboardHidden=newConfig.hardKeyboardHidden            final boolean isKeyboardOpen = mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO;
            if(mUpdateMonitor.isKeyguardBypassEnabled()&&isKeyboardOpen)            
            {
mCallback.goToUnlockScreen()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Configuration newConfig = getResources().getConfiguration();
        //if (newConfig.orientation != mCreationOrientation) {
            //mCallback.recreateMe(newConfig);
        //} else if (newConfig.hardKeyboardHidden != mKeyboardHidden) {
            //mKeyboardHidden = newConfig.hardKeyboardHidden;
            //final boolean isKeyboardOpen = mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO;
            //if (mUpdateMonitor.isKeyguardBypassEnabled() && isKeyboardOpen) {
                //mCallback.goToUnlockScreen();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.256 -0400", hash_original_method = "E7F73F1E191D080E861374107822BFF8", hash_generated_method = "A02206B11CE530408DF7C22177D29146")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()updateConfiguration()
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //updateConfiguration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.256 -0400", hash_original_method = "CCF1649CF176D23C806E95BA37EDA775", hash_generated_method = "26F4329ED1EDA2C251E72145D5EEFFE5")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
super.onConfigurationChanged(newConfig)updateConfiguration()
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //updateConfiguration();
    }

    
    private abstract class CheckSimPin extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.256 -0400", hash_original_field = "EB8FAD311CED38386108197E392740D9", hash_generated_field = "A6F34DC94F414DB1B049A8884958096B")

        private String mPin;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.257 -0400", hash_original_method = "3AD5DAB85DA14FC05FBEA3180EC77FE6", hash_generated_method = "DBAD615363974D60E036E5EBDB41593D")
        protected  CheckSimPin(String pin) {
            addTaint(pin.getTaint());
mPin=pin
            // ---------- Original Method ----------
            //mPin = pin;
        }

        
        abstract void onSimLockChangedResponse(boolean success);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.258 -0400", hash_original_method = "E81B85376EB67486021C431B445A9D94", hash_generated_method = "D296BCD5D3A181B107299C1BA4C42E30")
        @Override
        public void run() {
            try 
            {
                final boolean result = ITelephony.Stub.asInterface(ServiceManager
                        .checkService("phone")).supplyPin(mPin);
post(new Runnable()                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.258 -0400", hash_original_method = "02EBAD4EA20E5711FCA197250D1A0381", hash_generated_method = "F0710E3A79D48F8D12B1A17F1AFD5D08")
            public void run() {
onSimLockChangedResponse(result)
                // ---------- Original Method ----------
                //onSimLockChangedResponse(result);
            }
                }
)
            } //End block
            catch (RemoteException e)
            {
post(new Runnable()                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.258 -0400", hash_original_method = "61B6BC35F7A7D7E3509CA6E358F730CD", hash_generated_method = "A2B025616395086C29E0E3BDD6F79953")
            public void run() {
onSimLockChangedResponse(false)
                // ---------- Original Method ----------
                //onSimLockChangedResponse(false);
            }
                }
)
            } //End block
            // ---------- Original Method ----------
            //try {
                //final boolean result = ITelephony.Stub.asInterface(ServiceManager
                        //.checkService("phone")).supplyPin(mPin);
                //post(new Runnable() {
                    //public void run() {
                        //onSimLockChangedResponse(result);
                    //}
                //});
            //} catch (RemoteException e) {
                //post(new Runnable() {
                    //public void run() {
                        //onSimLockChangedResponse(false);
                    //}
                //});
            //}
        }

        
    }


    
    private class TouchInput implements View.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "C63C6B76368DAC7979AA9D9AFE0B3A2D", hash_generated_field = "EE0A2D443669C92F53C6741AD6F90D75")

        private TextView mZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "8FE4AEB4DF81D5A6CE2F3BA50967C8D8", hash_generated_field = "636AA545DFB4F935FCA14ED968F0C609")

        private TextView mOne;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "80B6DD0A5B8C1156ECE2B04CFA4398C0", hash_generated_field = "F8204CC9863C93BBACA229D1EF9A0654")

        private TextView mTwo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "2BBBA2C1ABFDB0FE73CB7B15C440D370", hash_generated_field = "CCD04F344821DC22A0F51AF2805761CC")

        private TextView mThree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "B992712E753F1AD84E198C2645781B65", hash_generated_field = "58D2EC8B9D3BBC6E1AC3F5AD40B8D636")

        private TextView mFour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.259 -0400", hash_original_field = "8ED65EDA0947680418EE285BD7A8DFF3", hash_generated_field = "66FC22D3BBB08F3D469C7E0F9BAFF23E")

        private TextView mFive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.260 -0400", hash_original_field = "B6670FB9CC11C98C9231FFED107AED1E", hash_generated_field = "951B96A3E116F7C952BC7F080A9D12C6")

        private TextView mSix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.260 -0400", hash_original_field = "CD594A6DAABEFE3852D43FFE7000ADC2", hash_generated_field = "F8925D1BB4FEE008124AD92E93F7D097")

        private TextView mSeven;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.260 -0400", hash_original_field = "089E38035F745A85138C5ED9D744023B", hash_generated_field = "0AD293AB032CAFBBE80B216AF44EAEC4")

        private TextView mEight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.260 -0400", hash_original_field = "F20A3D86E1E054024C3C9760786C3F76", hash_generated_field = "BCE7D67E4884387C7867F643313598B3")

        private TextView mNine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.260 -0400", hash_original_field = "3351AD49475624461A9BF79E94A4220C", hash_generated_field = "A1CC26AEC5D3C076806149BBEB6C087D")

        private TextView mCancelButton;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.261 -0400", hash_original_method = "D8E8009D30176300186AF87BCF813DD3", hash_generated_method = "187075C26178697D45D4D51B4410B3EE")
        private  TouchInput() {
mZero=(TextView) findViewById(R.id.zero)mOne=(TextView) findViewById(R.id.one)mTwo=(TextView) findViewById(R.id.two)mThree=(TextView) findViewById(R.id.three)mFour=(TextView) findViewById(R.id.four)mFive=(TextView) findViewById(R.id.five)mSix=(TextView) findViewById(R.id.six)mSeven=(TextView) findViewById(R.id.seven)mEight=(TextView) findViewById(R.id.eight)mNine=(TextView) findViewById(R.id.nine)mCancelButton=(TextView) findViewById(R.id.cancel)mZero.setText("0")mOne.setText("1")mTwo.setText("2")mThree.setText("3")mFour.setText("4")mFive.setText("5")mSix.setText("6")mSeven.setText("7")mEight.setText("8")mNine.setText("9")mZero.setOnClickListener(this)mOne.setOnClickListener(this)mTwo.setOnClickListener(this)mThree.setOnClickListener(this)mFour.setOnClickListener(this)mFive.setOnClickListener(this)mSix.setOnClickListener(this)mSeven.setOnClickListener(this)mEight.setOnClickListener(this)mNine.setOnClickListener(this)mCancelButton.setOnClickListener(this)
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.262 -0400", hash_original_method = "75E43406FFCA173351949926E1243916", hash_generated_method = "E98010CACFD565A7463C1104A14040E0")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            if(v==mCancelButton)            
            {
mPinText.setText("")mCallback.goToLockScreen()                return;
            } //End block
            final int digit = checkDigit(v);
            if(digit>=0)            
            {
mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS)reportDigit(digit)
            } //End block
            // ---------- Original Method ----------
            //if (v == mCancelButton) {
                //mPinText.setText(""); 
                //mCallback.goToLockScreen();
                //return;
            //}
            //final int digit = checkDigit(v);
            //if (digit >= 0) {
                //mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS);
                //reportDigit(digit);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.263 -0400", hash_original_method = "022F9C7B4452B66E5DE78358FFA617CE", hash_generated_method = "4F0D04876D86C8B61F5BF7ECF5A29E2E")
        private int checkDigit(View v) {
            addTaint(v.getTaint());
            int digit = -1;
            if(v==mZero)            
            {
digit=0
            } //End block
            else
            if(v==mOne)            
            {
digit=1
            } //End block
            else
            if(v==mTwo)            
            {
digit=2
            } //End block
            else
            if(v==mThree)            
            {
digit=3
            } //End block
            else
            if(v==mFour)            
            {
digit=4
            } //End block
            else
            if(v==mFive)            
            {
digit=5
            } //End block
            else
            if(v==mSix)            
            {
digit=6
            } //End block
            else
            if(v==mSeven)            
            {
digit=7
            } //End block
            else
            if(v==mEight)            
            {
digit=8
            } //End block
            else
            if(v==mNine)            
            {
digit=9
            } //End block
            int var29A1470067B045281DEAF936A75D8C06_1057576238 = (digit);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017623553 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017623553;
            // ---------- Original Method ----------
            //int digit = -1;
            //if (v == mZero) {
                //digit = 0;
            //} else if (v == mOne) {
                //digit = 1;
            //} else if (v == mTwo) {
                //digit = 2;
            //} else if (v == mThree) {
                //digit = 3;
            //} else if (v == mFour) {
                //digit = 4;
            //} else if (v == mFive) {
                //digit = 5;
            //} else if (v == mSix) {
                //digit = 6;
            //} else if (v == mSeven) {
                //digit = 7;
            //} else if (v == mEight) {
                //digit = 8;
            //} else if (v == mNine) {
                //digit = 9;
            //}
            //return digit;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.263 -0400", hash_original_field = "9DEB65DC868B6D4014CB8AED608C5D2F", hash_generated_field = "689CCE02A1CB6D4BB3DD367FA88297C9")

    private static final int DIGIT_PRESS_WAKE_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.264 -0400", hash_original_field = "3CF9ACD76EF50C171A670D4A33699DF9", hash_generated_field = "D6161A3D00BD06416711F0953500E972")

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };
}

