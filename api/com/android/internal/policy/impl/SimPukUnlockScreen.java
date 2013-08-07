package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.ProgressDialog;
import com.android.internal.R;
import android.app.Dialog;
import android.util.Log;
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
public class SimPukUnlockScreen extends LinearLayout implements KeyguardScreen, View.OnClickListener, View.OnFocusChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.205 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.205 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "CA3AE29687B50BD85F0CB06CCFB84E11", hash_generated_field = "D443E37F869F21F4F6889602CFB5CE23")

    private KeyguardStatusViewManager mKeyguardStatusViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "92E07B2B1A0E8699FA0FC2D997A04F18", hash_generated_field = "B4C6489DF78DED408503A9F978A2B5C8")

    private TextView mHeaderText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "D90CCD6DB6A074628FB39D9550F0AFE2", hash_generated_field = "BB51816C5FEF152E9C49802838626D34")

    private TextView mPukText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "3D24E93F5593A49B182C57D7F80BAAB8", hash_generated_field = "C5DB28CAF27EC266D800F31C4E8176B9")

    private TextView mPinText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "D336F7ABD2D13CD3B8AE99B6C7B77376", hash_generated_field = "B1416998F7D47AB5E8CDD624A9DD6B1B")

    private TextView mFocusedEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "66CBB0A8F64AC511DE1CFBE71543AA6F", hash_generated_field = "66CA31A5F9465DF0FD8DE67DD0F1DBC6")

    private View mOkButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.206 -0400", hash_original_field = "DAB742F04F35BD3EBDCC8F8AB6360F2C", hash_generated_field = "416CE6A5DC2D698D3FCF723B09B3C542")

    private View mDelPukButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.207 -0400", hash_original_field = "59842E6E148CBB10A212D845DF83C73B", hash_generated_field = "E69E687A79E4FADC08CFA14861CEEDB2")

    private View mDelPinButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.207 -0400", hash_original_field = "37BDB22916B17AF99E84E7FFD6D7CE26", hash_generated_field = "B714BA463D7EBA4FA60F87C6272A6DDF")

    private ProgressDialog mSimUnlockProgressDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.207 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.207 -0400", hash_original_field = "8650EFA3EAFF9E8580ED2BAF39D373A4", hash_generated_field = "D4F52B2DF2B3F133070FDB68D5444936")

    private int mCreationOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.207 -0400", hash_original_field = "DBC9BD3F128308E3E39537030A1C88EF", hash_generated_field = "69947A686D730ED6BFB8241A3DBF0C42")

    private int mKeyboardHidden;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.208 -0400", hash_original_method = "48285B0DBA9AAC144A8E77A77DA521F9", hash_generated_method = "2ECDE5F4F1270770E5CF015D8C05AAE6")
    public  SimPukUnlockScreen(Context context, Configuration configuration,
            KeyguardUpdateMonitor updateMonitor, KeyguardScreenCallback callback,
            LockPatternUtils lockpatternutils) {
        super(context);
        addTaint(lockpatternutils.getTaint());
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mUpdateMonitor=updateMonitormCallback=callback        ;
mCreationOrientation=configuration.orientationmKeyboardHidden=configuration.hardKeyboardHiddenmLockPatternUtils=lockpatternutils        LayoutInflater inflater = LayoutInflater.from(context);
        if(mKeyboardHidden==Configuration.HARDKEYBOARDHIDDEN_NO)        
        {
inflater.inflate(R.layout.keyguard_screen_sim_puk_landscape, this, true)
        } //End block
        else
        {
inflater.inflate(R.layout.keyguard_screen_sim_puk_portrait, this, true)new TouchInput()
        } //End block
mHeaderText=(TextView) findViewById(R.id.headerText)mPukText=(TextView) findViewById(R.id.pukDisplay)mPinText=(TextView) findViewById(R.id.pinDisplay)mDelPukButton=findViewById(R.id.pukDel)mDelPinButton=findViewById(R.id.pinDel)mOkButton=findViewById(R.id.ok)mDelPinButton.setOnClickListener(this)mDelPukButton.setOnClickListener(this)mOkButton.setOnClickListener(this)mHeaderText.setText(R.string.keyguard_password_enter_puk_code)mHeaderText.setSelected(true)mKeyguardStatusViewManager=new KeyguardStatusViewManager(this, updateMonitor, lockpatternutils, callback, true)mPinText.setFocusableInTouchMode(true)mPinText.setOnFocusChangeListener(this)mPukText.setFocusableInTouchMode(true)mPukText.setOnFocusChangeListener(this)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.209 -0400", hash_original_method = "DF5F83115DF90D07C5FFC8E05F96ABEA", hash_generated_method = "B0FB205A989B288E97004EDD2CC7B6C9")
    public boolean needsInput() {
        boolean var68934A3E9455FA72420237EB05902327_1640645020 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284370633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_284370633;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.209 -0400", hash_original_method = "440CB18BD14857ECDCCCF4D80E037E23", hash_generated_method = "E02E07154151F9B60B5BF671FBC9F1FB")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mKeyguardStatusViewManager.onPause()
        // ---------- Original Method ----------
        //mKeyguardStatusViewManager.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.210 -0400", hash_original_method = "C092BCA9E840100D365199BACE832637", hash_generated_method = "71B5DFE724C5D7B9033B1A2DD1E0AD43")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mHeaderText.setText(R.string.keyguard_password_enter_puk_code)mKeyguardStatusViewManager.onResume()
        // ---------- Original Method ----------
        //mHeaderText.setText(R.string.keyguard_password_enter_puk_code);
        //mKeyguardStatusViewManager.onResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.210 -0400", hash_original_method = "4F56B8371F6E4189658A07455244C5AE", hash_generated_method = "B34EE96BECB6D2417C55345722D03167")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.211 -0400", hash_original_method = "785BC332E61B97B55F59A6AA8CB33455", hash_generated_method = "C7F85C59AE5FBB2484B4F9AB185080D5")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(v==mDelPukButton)        
        {
            if(mFocusedEntry!=mPukText)            
mPukText.requestFocus()
            final Editable digits = mPukText.getEditableText();
            final int len = digits.length();
            if(len>0)            
            {
digits.delete(len-1, len)
            } //End block
        } //End block
        else
        if(v==mDelPinButton)        
        {
            if(mFocusedEntry!=mPinText)            
mPinText.requestFocus()
            final Editable digits = mPinText.getEditableText();
            final int len = digits.length();
            if(len>0)            
            {
digits.delete(len-1, len)
            } //End block
        } //End block
        else
        if(v==mOkButton)        
        {
checkPuk()
        } //End block
mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS)
        // ---------- Original Method ----------
        //if (v == mDelPukButton) {
            //if (mFocusedEntry != mPukText)
                //mPukText.requestFocus();
            //final Editable digits = mPukText.getEditableText();
            //final int len = digits.length();
            //if (len > 0) {
                //digits.delete(len-1, len);
            //}
        //} else if (v == mDelPinButton) {
            //if (mFocusedEntry != mPinText)
                //mPinText.requestFocus();
            //final Editable digits = mPinText.getEditableText();
            //final int len = digits.length();
            //if (len > 0) {
                //digits.delete(len-1, len);
            //}
        //} else if (v == mOkButton) {
            //checkPuk();
        //}
        //mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.212 -0400", hash_original_method = "70480B71946BA44E68E3790BD6651051", hash_generated_method = "49ABF1DD9F6385D99F6AA3AD25D526FE")
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        addTaint(v.getTaint());
        if(hasFocus)        
mFocusedEntry=(TextView) v
        // ---------- Original Method ----------
        //if (hasFocus)
            //mFocusedEntry = (TextView)v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.212 -0400", hash_original_method = "93BC6D4938B62F663C4EEE0C7C888414", hash_generated_method = "39216FD92E51418EDA5588433CC8E2E6")
    private Dialog getSimUnlockProgressDialog() {
        if(mSimUnlockProgressDialog==null)        
        {
mSimUnlockProgressDialog=new ProgressDialog(mContext)mSimUnlockProgressDialog.setMessage(mContext.getString(R.string.lockscreen_sim_unlock_progress_dialog_message))mSimUnlockProgressDialog.setIndeterminate(true)mSimUnlockProgressDialog.setCancelable(false)mSimUnlockProgressDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)
        } //End block
Dialog var8EA120C784E35FF1CB5979BAFDCF5288_2105558820 = mSimUnlockProgressDialog        var8EA120C784E35FF1CB5979BAFDCF5288_2105558820.addTaint(taint);
        return var8EA120C784E35FF1CB5979BAFDCF5288_2105558820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.214 -0400", hash_original_method = "8935420EB0FF04EB3805A8E1E0154031", hash_generated_method = "5478D43F002A2B0326DF143D00F9301A")
    private void checkPuk() {
        if(mPukText.getText().length()<8)        
        {
mHeaderText.setText(R.string.invalidPuk)mPukText.setText("")            return;
        } //End block
        if(mPinText.getText().length()<4||mPinText.getText().length()>8)        
        {
mHeaderText.setText(R.string.invalidPin)mPinText.setText("")            return;
        } //End block
getSimUnlockProgressDialog().show()new CheckSimPuk(mPukText.getText().toString(), mPinText.getText().toString())        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.214 -0400", hash_original_method = "9C06501B9F43E608B98F2E4B44090CE1", hash_generated_method = "3ABDF08D289E4E59FEF60833E3E35B24")
         void onSimLockChangedResponse(final boolean success) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(success);
mPinText.post(new Runnable()            {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.213 -0400", hash_original_method = "9618897BBF79FA8DE9F3FBAB8E1F4ADD", hash_generated_method = "45F026AAC1660E82875DD3525F7AE4EA")
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
mHeaderText.setText(R.string.badPuk)mPukText.setText("")mPinText.setText("")
                } //End block
                // ---------- Original Method ----------
                //if (mSimUnlockProgressDialog != null) {
                            //mSimUnlockProgressDialog.hide();
                        //}
                //if (success) {
                            //mUpdateMonitor.reportSimUnlocked();
                            //mCallback.goToUnlockScreen();
                        //} else {
                            //mHeaderText.setText(R.string.badPuk);
                            //mPukText.setText("");
                            //mPinText.setText("");
                        //}
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
                            //mHeaderText.setText(R.string.badPuk);
                            //mPukText.setText("");
                            //mPinText.setText("");
                        //}
                    //}
                //});
        }
        }
.start()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.216 -0400", hash_original_method = "3095AB8D8D1976EF670BD563D4E2C075", hash_generated_method = "FE122D39DA47A2AADB5304E7C5FA9C89")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(keyCode==KeyEvent.KEYCODE_BACK)        
        {
mCallback.goToLockScreen()            boolean varB326B5062B2F0E69046810717534CB09_1684702427 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043921492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043921492;
        } //End block
        final char match = event.getMatch(DIGITS);
        if(match!=0)        
        {
reportDigit(match-'0')            boolean varB326B5062B2F0E69046810717534CB09_2039330130 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536343696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536343696;
        } //End block
        if(keyCode==KeyEvent.KEYCODE_DEL)        
        {
mFocusedEntry.onKeyDown(keyCode, event)            final Editable digits = mFocusedEntry.getEditableText();
            final int len = digits.length();
            if(len>0)            
            {
digits.delete(len-1, len)
            } //End block
mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS)            boolean varB326B5062B2F0E69046810717534CB09_786076479 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064309661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064309661;
        } //End block
        if(keyCode==KeyEvent.KEYCODE_ENTER)        
        {
checkPuk()            boolean varB326B5062B2F0E69046810717534CB09_1785177385 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984916165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984916165;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_313316549 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847523924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847523924;
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
            //mFocusedEntry.onKeyDown(keyCode, event);
            //final Editable digits = mFocusedEntry.getEditableText();
            //final int len = digits.length();
            //if (len > 0) {
                //digits.delete(len-1, len);
            //}
            //mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS);
            //return true;
        //}
        //if (keyCode == KeyEvent.KEYCODE_ENTER) {
            //checkPuk();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.216 -0400", hash_original_method = "667844B849064832C485B2213C7FBF07", hash_generated_method = "3BDC1DDF1C31B0C7AA504A92D182F121")
    private void reportDigit(int digit) {
        addTaint(digit);
mFocusedEntry.append(Integer.toString(digit))
        // ---------- Original Method ----------
        //mFocusedEntry.append(Integer.toString(digit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.217 -0400", hash_original_method = "D4B9104CADA59D7BAADC35CDF7FBF220", hash_generated_method = "7040F95F0849E5F6DC43698A32A5F469")
     void updateConfiguration() {
        Configuration newConfig = getResources().getConfiguration();
        if(newConfig.orientation!=mCreationOrientation)        
        {
mCallback.recreateMe(newConfig)
        } //End block
        else
        if(newConfig.hardKeyboardHidden!=mKeyboardHidden)        
        {
mKeyboardHidden=newConfig.hardKeyboardHidden            final boolean isKeyboardOpen = (mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO);
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
            //final boolean isKeyboardOpen =
                //(mKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO);
            //if (mUpdateMonitor.isKeyguardBypassEnabled() && isKeyboardOpen) {
                //mCallback.goToUnlockScreen();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.218 -0400", hash_original_method = "E7F73F1E191D080E861374107822BFF8", hash_generated_method = "A02206B11CE530408DF7C22177D29146")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()updateConfiguration()
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //updateConfiguration();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.218 -0400", hash_original_method = "CCF1649CF176D23C806E95BA37EDA775", hash_generated_method = "26F4329ED1EDA2C251E72145D5EEFFE5")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
super.onConfigurationChanged(newConfig)updateConfiguration()
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //updateConfiguration();
    }

    
    private abstract class CheckSimPuk extends Thread {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.218 -0400", hash_original_field = "EB8FAD311CED38386108197E392740D9", hash_generated_field = "A6F34DC94F414DB1B049A8884958096B")

        private String mPin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.219 -0400", hash_original_field = "93C57A33D0903E1A46DCEC5201440E9C", hash_generated_field = "BB13A6303335C1D988F5C9BFA9353B62")

        private String mPuk;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.219 -0400", hash_original_method = "EAA320FDB2286C4289CEC569A7525BC1", hash_generated_method = "D6652569D41B030AD5B21D47A675BC1D")
        protected  CheckSimPuk(String puk, String pin) {
            addTaint(pin.getTaint());
            addTaint(puk.getTaint());
mPuk=pukmPin=pin
            // ---------- Original Method ----------
            //mPuk = puk;
            //mPin = pin;
        }

        
        abstract void onSimLockChangedResponse(boolean success);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.220 -0400", hash_original_method = "948B747BA747D308B3FBCE7850AF63AF", hash_generated_method = "4AB731B3082A9D6F8129258D58CA33BC")
        @Override
        public void run() {
            try 
            {
                final boolean result = ITelephony.Stub.asInterface(ServiceManager
                        .checkService("phone")).supplyPuk(mPuk, mPin);
post(new Runnable()                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.220 -0400", hash_original_method = "02EBAD4EA20E5711FCA197250D1A0381", hash_generated_method = "F0710E3A79D48F8D12B1A17F1AFD5D08")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.220 -0400", hash_original_method = "61B6BC35F7A7D7E3509CA6E358F730CD", hash_generated_method = "A2B025616395086C29E0E3BDD6F79953")
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
                        //.checkService("phone")).supplyPuk(mPuk, mPin);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.221 -0400", hash_original_field = "C63C6B76368DAC7979AA9D9AFE0B3A2D", hash_generated_field = "EE0A2D443669C92F53C6741AD6F90D75")

        private TextView mZero;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.221 -0400", hash_original_field = "8FE4AEB4DF81D5A6CE2F3BA50967C8D8", hash_generated_field = "636AA545DFB4F935FCA14ED968F0C609")

        private TextView mOne;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.221 -0400", hash_original_field = "80B6DD0A5B8C1156ECE2B04CFA4398C0", hash_generated_field = "F8204CC9863C93BBACA229D1EF9A0654")

        private TextView mTwo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "2BBBA2C1ABFDB0FE73CB7B15C440D370", hash_generated_field = "CCD04F344821DC22A0F51AF2805761CC")

        private TextView mThree;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "B992712E753F1AD84E198C2645781B65", hash_generated_field = "58D2EC8B9D3BBC6E1AC3F5AD40B8D636")

        private TextView mFour;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "8ED65EDA0947680418EE285BD7A8DFF3", hash_generated_field = "66FC22D3BBB08F3D469C7E0F9BAFF23E")

        private TextView mFive;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "B6670FB9CC11C98C9231FFED107AED1E", hash_generated_field = "951B96A3E116F7C952BC7F080A9D12C6")

        private TextView mSix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "CD594A6DAABEFE3852D43FFE7000ADC2", hash_generated_field = "F8925D1BB4FEE008124AD92E93F7D097")

        private TextView mSeven;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "089E38035F745A85138C5ED9D744023B", hash_generated_field = "0AD293AB032CAFBBE80B216AF44EAEC4")

        private TextView mEight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "F20A3D86E1E054024C3C9760786C3F76", hash_generated_field = "BCE7D67E4884387C7867F643313598B3")

        private TextView mNine;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.222 -0400", hash_original_field = "3351AD49475624461A9BF79E94A4220C", hash_generated_field = "A1CC26AEC5D3C076806149BBEB6C087D")

        private TextView mCancelButton;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.224 -0400", hash_original_method = "D8E8009D30176300186AF87BCF813DD3", hash_generated_method = "187075C26178697D45D4D51B4410B3EE")
        private  TouchInput() {
mZero=(TextView) findViewById(R.id.zero)mOne=(TextView) findViewById(R.id.one)mTwo=(TextView) findViewById(R.id.two)mThree=(TextView) findViewById(R.id.three)mFour=(TextView) findViewById(R.id.four)mFive=(TextView) findViewById(R.id.five)mSix=(TextView) findViewById(R.id.six)mSeven=(TextView) findViewById(R.id.seven)mEight=(TextView) findViewById(R.id.eight)mNine=(TextView) findViewById(R.id.nine)mCancelButton=(TextView) findViewById(R.id.cancel)mZero.setText("0")mOne.setText("1")mTwo.setText("2")mThree.setText("3")mFour.setText("4")mFive.setText("5")mSix.setText("6")mSeven.setText("7")mEight.setText("8")mNine.setText("9")mZero.setOnClickListener(this)mOne.setOnClickListener(this)mTwo.setOnClickListener(this)mThree.setOnClickListener(this)mFour.setOnClickListener(this)mFive.setOnClickListener(this)mSix.setOnClickListener(this)mSeven.setOnClickListener(this)mEight.setOnClickListener(this)mNine.setOnClickListener(this)mCancelButton.setOnClickListener(this)
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.224 -0400", hash_original_method = "A3CABECC632D1CEA7FC571B7A508A553", hash_generated_method = "2BD0644D71DDCA5A169DD384E9E0A448")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
            if(v==mCancelButton)            
            {
mPinText.setText("")mPukText.setText("")mCallback.goToLockScreen()                return;
            } //End block
            final int digit = checkDigit(v);
            if(digit>=0)            
            {
mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS)reportDigit(digit)
            } //End block
            // ---------- Original Method ----------
            //if (v == mCancelButton) {
                //mPinText.setText("");
                //mPukText.setText("");
                //mCallback.goToLockScreen();
                //return;
            //}
            //final int digit = checkDigit(v);
            //if (digit >= 0) {
                //mCallback.pokeWakelock(DIGIT_PRESS_WAKE_MILLIS);
                //reportDigit(digit);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.225 -0400", hash_original_method = "022F9C7B4452B66E5DE78358FFA617CE", hash_generated_method = "4A9B1BE0165028789469848A2D9F4AAC")
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
            int var29A1470067B045281DEAF936A75D8C06_781512660 = (digit);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747359413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747359413;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.227 -0400", hash_original_field = "9DEB65DC868B6D4014CB8AED608C5D2F", hash_generated_field = "689CCE02A1CB6D4BB3DD367FA88297C9")

    private static final int DIGIT_PRESS_WAKE_MILLIS = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.227 -0400", hash_original_field = "3CF9ACD76EF50C171A670D4A33699DF9", hash_generated_field = "D6161A3D00BD06416711F0953500E972")

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };
}

