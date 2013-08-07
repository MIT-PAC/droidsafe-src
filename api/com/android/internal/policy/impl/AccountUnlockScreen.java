package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.accounts.OperationCanceledException;
import android.graphics.Rect;
import android.app.ProgressDialog;
import com.android.internal.R;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.view.View;
import android.accounts.AccountManager;
import java.io.IOException;
import android.text.LoginFilter;
import com.android.internal.widget.LockPatternUtils;
import android.accounts.Account;
import android.content.Intent;
import android.view.KeyEvent;
import android.accounts.AccountManagerFuture;
import android.accounts.AccountManagerCallback;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.accounts.AuthenticatorException;
import android.app.Dialog;
import android.widget.TextView;
import android.text.Editable;
import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.widget.EditText;
import android.widget.RelativeLayout;
public class AccountUnlockScreen extends RelativeLayout implements KeyguardScreen, View.OnClickListener, TextWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.845 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.846 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.846 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.849 -0400", hash_original_field = "8D25D795C34B80C135349EF880911CFE", hash_generated_field = "31BE3CC88F4235DFCA32EEB41C1CBE39")

    private TextView mTopHeader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.849 -0400", hash_original_field = "B67911D259C1C3D24C452C93BEC486E6", hash_generated_field = "7DCBE56AD7135C7E94F09CA04B6BFEA0")

    private TextView mInstructions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.850 -0400", hash_original_field = "F7DD455B50FCC1CE8D961FB8406A35A4", hash_generated_field = "08C7149F01F76732402D6168C405AAC6")

    private EditText mLogin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.850 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "6779ECA96810CA72BFE362C069663010")

    private EditText mPassword;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.850 -0400", hash_original_field = "A2A9C4750FCD3106D09BA1FEDAC7A674", hash_generated_field = "545C4A873F7F2CE02C727C7D662ED41D")

    private Button mOk;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.850 -0400", hash_original_field = "E2436700C848DAB3C192E101BE0A14D0", hash_generated_field = "278D024976A155375AEE868D464D635B")

    private ProgressDialog mCheckingDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.851 -0400", hash_original_field = "CA3AE29687B50BD85F0CB06CCFB84E11", hash_generated_field = "D443E37F869F21F4F6889602CFB5CE23")

    private KeyguardStatusViewManager mKeyguardStatusViewManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.852 -0400", hash_original_method = "F1D428F398B9371721BEAACAFE313AFF", hash_generated_method = "18A5C93FECEF345704AF5DD824541FEB")
    public  AccountUnlockScreen(Context context, Configuration configuration,
            KeyguardUpdateMonitor updateMonitor, KeyguardScreenCallback callback,
            LockPatternUtils lockPatternUtils) {
        super(context);
        addTaint(lockPatternUtils.getTaint());
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mCallback=callbackmLockPatternUtils=lockPatternUtilsLayoutInflater.from(context).inflate(R.layout.keyguard_screen_glogin_unlock, this, true)mTopHeader=(TextView) findViewById(R.id.topHeader)mTopHeader.setText(mLockPatternUtils.isPermanentlyLocked()?R.string.lockscreen_glogin_too_many_attempts:R.string.lockscreen_glogin_too_many_attempts)mInstructions=(TextView) findViewById(R.id.instructions)mLogin=(EditText) findViewById(R.id.login)mLogin.setFilters(new InputFilter)mLogin.addTextChangedListener(this)mPassword=(EditText) findViewById(R.id.password)mPassword.addTextChangedListener(this)mOk=(Button) findViewById(R.id.ok)mOk.setOnClickListener(this)mUpdateMonitor=updateMonitormKeyguardStatusViewManager=new KeyguardStatusViewManager(this, updateMonitor, lockPatternUtils, callback, true)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.856 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
    public void afterTextChanged(Editable s) {
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.858 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "63445082BCC7E22464CE7B1B497FEB87")
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        addTaint(after);
        addTaint(count);
        addTaint(start);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.859 -0400", hash_original_method = "A400A7B426E2FBF88FAAD980E3C613A5", hash_generated_method = "5197A6AAA0EF6CD5D8E6DEB88DA41F14")
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(count);
        addTaint(before);
        addTaint(start);
        addTaint(s.getTaint());
mCallback.pokeWakelock(AWAKE_POKE_MILLIS)
        // ---------- Original Method ----------
        //mCallback.pokeWakelock(AWAKE_POKE_MILLIS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.860 -0400", hash_original_method = "FE3B820C31811FAAA4B28A6722C99076", hash_generated_method = "332C241C372A5F624C78103B706A6019")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        boolean var821B0B369922B0FEB00A35AAC547FC4A_1288408653 = (mLogin.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100750498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100750498;
        // ---------- Original Method ----------
        //return mLogin.requestFocus(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.861 -0400", hash_original_method = "03417B513FCDBDE5BF931CF3F9740388", hash_generated_method = "E98704E8547594FA2127521C49C256EE")
    public boolean needsInput() {
        boolean varB326B5062B2F0E69046810717534CB09_822782384 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861309873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861309873;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.862 -0400", hash_original_method = "440CB18BD14857ECDCCCF4D80E037E23", hash_generated_method = "E02E07154151F9B60B5BF671FBC9F1FB")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mKeyguardStatusViewManager.onPause()
        // ---------- Original Method ----------
        //mKeyguardStatusViewManager.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.863 -0400", hash_original_method = "5F330E827F424B2FC2E3C528E0E7E97D", hash_generated_method = "651C90CD51B350A70DED5E230B24A561")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mLogin.setText("")mPassword.setText("")mLogin.requestFocus()mKeyguardStatusViewManager.onResume()
        // ---------- Original Method ----------
        //mLogin.setText("");
        //mPassword.setText("");
        //mLogin.requestFocus();
        //mKeyguardStatusViewManager.onResume();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.863 -0400", hash_original_method = "A660827A5130488F81F0406096AC052B", hash_generated_method = "C815B7DDEE4ED7E5761F036741DF3706")
    public void cleanUp() {
        if(mCheckingDialog!=null)        
        {
mCheckingDialog.hide()
        } //End block
mUpdateMonitor.removeCallback(this)mCallback=nullmLockPatternUtils=nullmUpdateMonitor=null
        // ---------- Original Method ----------
        //if (mCheckingDialog != null) {
            //mCheckingDialog.hide();
        //}
        //mUpdateMonitor.removeCallback(this);
        //mCallback = null;
        //mLockPatternUtils = null;
        //mUpdateMonitor = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.864 -0400", hash_original_method = "6439944681A56721652060E67CF26B0F", hash_generated_method = "7D489AAD9C083041119A898F487ADF83")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
mCallback.pokeWakelock()        if(v==mOk)        
        {
asyncCheckPassword()
        } //End block
        // ---------- Original Method ----------
        //mCallback.pokeWakelock();
        //if (v == mOk) {
            //asyncCheckPassword();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.870 -0400", hash_original_method = "474832D4E52F5B6D84EA97D6E470CABA", hash_generated_method = "C417A6B63CFF075E2D74EC065F1947F3")
    private void postOnCheckPasswordResult(final boolean success) {
        addTaint(success);
mLogin.post(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.866 -0400", hash_original_method = "003034568A9EE54F3CD5850A0CE8A88E", hash_generated_method = "771EB204EA9E5EBBA0F7934E5908AE50")
        public void run() {
            if(success)            
            {
mLockPatternUtils.setPermanentlyLocked(false)mLockPatternUtils.setLockPatternEnabled(false)mLockPatternUtils.saveLockPattern(null)                Intent intent = new Intent();
intent.setClassName(LOCK_PATTERN_PACKAGE, LOCK_PATTERN_CLASS)intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)mContext.startActivity(intent)mCallback.reportSuccessfulUnlockAttempt()mCallback.keyguardDone(true)
            } //End block
            else
            {
mInstructions.setText(R.string.lockscreen_glogin_invalid_input)mPassword.setText("")mCallback.reportFailedUnlockAttempt()
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.872 -0400", hash_original_method = "8271340E3D3DCD0DF2B85170B1A3AA06", hash_generated_method = "264A6751EB3D8DC056A212B7DF74D5C4")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        if(event.getAction()==KeyEvent.ACTION_DOWN&&event.getKeyCode()==KeyEvent.KEYCODE_BACK)        
        {
            if(mLockPatternUtils.isPermanentlyLocked())            
            {
mCallback.goToLockScreen()
            } //End block
            else
            {
mCallback.forgotPattern(false)
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1414794011 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568231120 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568231120;
        } //End block
        boolean var639DD27D10E8FF69097B1398D445D1B9_1260177007 = (super.dispatchKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471503338 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471503338;
        // ---------- Original Method ----------
        //if (event.getAction() == KeyEvent.ACTION_DOWN
                //&& event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            //if (mLockPatternUtils.isPermanentlyLocked()) {
                //mCallback.goToLockScreen();
            //} else {
                //mCallback.forgotPattern(false);
            //}
            //return true;
        //}
        //return super.dispatchKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.878 -0400", hash_original_method = "11F98E26BCBA090B8DC8A67314671F0E", hash_generated_method = "58C2E4E73868C399CA1E678C971CD751")
    private Account findIntendedAccount(String username) {
        addTaint(username.getTaint());
        Account[] accounts = AccountManager.get(mContext).getAccountsByType("com.google");
        Account bestAccount = null;
        int bestScore = 0;
for(Account a : accounts)
        {
            int score = 0;
            if(username.equals(a.name))            
            {
score=4
            } //End block
            else
            if(username.equalsIgnoreCase(a.name))            
            {
score=3
            } //End block
            else
            if(username.indexOf('@')<0)            
            {
                int i = a.name.indexOf('@');
                if(i>=0)                
                {
                    String aUsername = a.name.substring(0, i);
                    if(username.equals(aUsername))                    
                    {
score=2
                    } //End block
                    else
                    if(username.equalsIgnoreCase(aUsername))                    
                    {
score=1
                    } //End block
                } //End block
            } //End block
            if(score>bestScore)            
            {
bestAccount=abestScore=score
            } //End block
            else
            if(score==bestScore)            
            {
bestAccount=null
            } //End block
        } //End block
Account var8EFD2F68F0C589CCD77E45288A1BD810_1820302016 = bestAccount        var8EFD2F68F0C589CCD77E45288A1BD810_1820302016.addTaint(taint);
        return var8EFD2F68F0C589CCD77E45288A1BD810_1820302016;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.893 -0400", hash_original_method = "54C2CA42A49169CCF4EE079B2015C8DE", hash_generated_method = "7D297F130E3BFAEA2A2390E006E2FE11")
    private void asyncCheckPassword() {
mCallback.pokeWakelock(AWAKE_POKE_MILLIS)        final String login = mLogin.getText().toString();
        final String password = mPassword.getText().toString();
        Account account = findIntendedAccount(login);
        if(account==null)        
        {
postOnCheckPasswordResult(false)            return;
        } //End block
getProgressDialog().show()        Bundle options = new Bundle();
options.putString(AccountManager.KEY_PASSWORD, password)AccountManager.get(mContext).confirmCredentials(account, options, null, new AccountManagerCallback<Bundle>()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.892 -0400", hash_original_method = "0E8793C95A33589394DA3E57746D029C", hash_generated_method = "BBE456E17E6143EDC60D0A5D282FBB79")
        public void run(AccountManagerFuture<Bundle> future) {
            addTaint(future.getTaint());
            try 
            {
mCallback.pokeWakelock(AWAKE_POKE_MILLIS)                final Bundle result = future.getResult();
                final boolean verified = result.getBoolean(AccountManager.KEY_BOOLEAN_RESULT);
postOnCheckPasswordResult(verified)
            } //End block
            catch (OperationCanceledException e)
            {
postOnCheckPasswordResult(false)
            } //End block
            catch (IOException e)
            {
postOnCheckPasswordResult(false)
            } //End block
            catch (AuthenticatorException e)
            {
postOnCheckPasswordResult(false)
            } //End block
            finally 
            {
mLogin.post(new Runnable()                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.891 -0400", hash_original_method = "DAD8AF03D5A0989D99C892241A3A95B7", hash_generated_method = "D1A24EC4D14F98B1DA835BBBBE859F2F")
            public void run() {
getProgressDialog().hide()
                // ---------- Original Method ----------
                //getProgressDialog().hide();
            }
                }
)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
, null)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.896 -0400", hash_original_method = "08D5706019E0FE5B4101FB2FC3B430B1", hash_generated_method = "A05D6F5714D364B2DA9FC0B693277249")
    private Dialog getProgressDialog() {
        if(mCheckingDialog==null)        
        {
mCheckingDialog=new ProgressDialog(mContext)mCheckingDialog.setMessage(mContext.getString(R.string.lockscreen_glogin_checking_password))mCheckingDialog.setIndeterminate(true)mCheckingDialog.setCancelable(false)mCheckingDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)
        } //End block
Dialog var4AC0D9171234DFB025ACA45A15B1194A_1078948136 = mCheckingDialog        var4AC0D9171234DFB025ACA45A15B1194A_1078948136.addTaint(taint);
        return var4AC0D9171234DFB025ACA45A15B1194A_1078948136;
        // ---------- Original Method ----------
        //if (mCheckingDialog == null) {
            //mCheckingDialog = new ProgressDialog(mContext);
            //mCheckingDialog.setMessage(
                    //mContext.getString(R.string.lockscreen_glogin_checking_password));
            //mCheckingDialog.setIndeterminate(true);
            //mCheckingDialog.setCancelable(false);
            //mCheckingDialog.getWindow().setType(
                    //WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        //}
        //return mCheckingDialog;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.897 -0400", hash_original_field = "806335AFBE11DAC97EED80CFF0961B12", hash_generated_field = "ED95D7A8948B527B4690B1200CDFB1B1")

    private static final String LOCK_PATTERN_PACKAGE = "com.android.settings";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.898 -0400", hash_original_field = "92A72A7F86C00424B6D83374B8DA9A23", hash_generated_field = "3EFED490508BC15264DADE6DE54C8D09")

    private static final String LOCK_PATTERN_CLASS = LOCK_PATTERN_PACKAGE+".ChooseLockGeneric";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.899 -0400", hash_original_field = "7EC11FEE97BA53199AD4CDB977E9F1BA", hash_generated_field = "342B25FE9D23C85AFCA516E9E867F3BA")

    private static final int AWAKE_POKE_MILLIS = 30000;
}

