package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import android.graphics.Rect;
import com.android.internal.R;
import android.text.method.TextKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.text.TextWatcher;
import android.view.View;
import android.view.Gravity;
import com.android.internal.widget.LockPatternUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.KeyEvent;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Space;
import android.app.admin.DevicePolicyManager;
import android.widget.LinearLayout;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import com.android.internal.widget.PasswordEntryKeyboardView;
import com.android.internal.widget.PasswordEntryKeyboardHelper;
import android.view.ViewGroup.LayoutParams;
import java.util.List;
import android.provider.Settings;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.TextView;
import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.security.KeyStore;
import android.view.inputmethod.EditorInfo;
import android.os.CountDownTimer;
import android.content.Context;
import android.widget.EditText;
import android.text.InputType;
public class PasswordUnlockScreen extends LinearLayout implements KeyguardScreen, OnEditorActionListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.041 -0400", hash_original_field = "E8A7E633D99E3BACB8ADFBBABB173D14", hash_generated_field = "22DCE3AFB482F86E6B2E96F873097CE0")

    private KeyguardUpdateMonitor mUpdateMonitor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.041 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "56BFB4929FFB5B85E16CE5933F964A09")

    private KeyguardScreenCallback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "6863FFF65A46A970964BFEF5BA891E15", hash_generated_field = "077B7FF1E58015626B1EB55644883141")

    private boolean mIsAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "856EAD15AE6305292AA512FE37994C47", hash_generated_field = "1AD6137DCB1DFB9E3D2E5A003A6498C3")

    private EditText mPasswordEntry;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "EAA1758ACB8C3815224ED7417E5328B5", hash_generated_field = "FB69BB5EA99FF1AC6B151A37F4FEA26C")

    private LockPatternUtils mLockPatternUtils;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "74BC2460FFE04FD4A6428538C62CC058", hash_generated_field = "7DF653FAA6BC5872B1AECC1DEF7714DA")

    private PasswordEntryKeyboardView mKeyboardView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "73B225A6152D7381E6ED432963F9D47C", hash_generated_field = "9BDF9D491EE71604C1D93F9F211CDFFE")

    private PasswordEntryKeyboardHelper mKeyboardHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.042 -0400", hash_original_field = "8650EFA3EAFF9E8580ED2BAF39D373A4", hash_generated_field = "D4F52B2DF2B3F133070FDB68D5444936")

    private int mCreationOrientation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.043 -0400", hash_original_field = "A4925DB071B9C7660F4B1C3990855FAE", hash_generated_field = "B84AB35BEDD4B18A30C1CDB0289334C1")

    private int mCreationHardKeyboardHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.043 -0400", hash_original_field = "8A1A7BF80985C1BAE77D52C5BE41E88F", hash_generated_field = "70CA6DA7CBDF33F352C6E3B7572B9A7F")

    private KeyguardStatusViewManager mStatusViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.043 -0400", hash_original_field = "BFDD8B290D478B9260665FB1EB8C5EE1", hash_generated_field = "E478FCF51A77A30899F1DCAA3265B9F8")

    private final boolean mUseSystemIME = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.043 -0400", hash_original_field = "6D8BC2BED8A8C9069256DC11E6F21DF8", hash_generated_field = "C63BE6B6ED31A6F9A52210CA8A330A13")

    private boolean mResuming;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.053 -0400", hash_original_method = "7DC85DE86200CE05C5CC896479D249FE", hash_generated_method = "47372A2CD8825DAF4A74302B46464072")
    public  PasswordUnlockScreen(Context context, Configuration configuration,
            LockPatternUtils lockPatternUtils, KeyguardUpdateMonitor updateMonitor,
            KeyguardScreenCallback callback) {
        super(context);
        addTaint(callback.getTaint());
        addTaint(updateMonitor.getTaint());
        addTaint(lockPatternUtils.getTaint());
        addTaint(configuration.getTaint());
        addTaint(context.getTaint());
mCreationHardKeyboardHidden=configuration.hardKeyboardHiddenmCreationOrientation=configuration.orientationmUpdateMonitor=updateMonitormCallback=callbackmLockPatternUtils=lockPatternUtils        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if(mCreationOrientation!=Configuration.ORIENTATION_LANDSCAPE)        
        {
layoutInflater.inflate(R.layout.keyguard_screen_password_portrait, this, true)
        } //End block
        else
        {
layoutInflater.inflate(R.layout.keyguard_screen_password_landscape, this, true)
        } //End block
mStatusViewManager=new KeyguardStatusViewManager(this, mUpdateMonitor, mLockPatternUtils, mCallback, true)        final int quality = lockPatternUtils.getKeyguardStoredPasswordQuality();
mIsAlpha=DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC==quality||DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC==quality||DevicePolicyManager.PASSWORD_QUALITY_COMPLEX==qualitymKeyboardView=(PasswordEntryKeyboardView) findViewById(R.id.keyboard)mPasswordEntry=(EditText) findViewById(R.id.passwordEntry)mPasswordEntry.setOnEditorActionListener(this)mKeyboardHelper=new PasswordEntryKeyboardHelper(context, mKeyboardView, this, false)mKeyboardHelper.setEnableHaptics(Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.LOCK_PATTERN_TACTILE_FEEDBACK_ENABLED, 0)!=0)        boolean imeOrDeleteButtonVisible = false;
        if(mIsAlpha)        
        {
mKeyboardHelper.setKeyboardMode(PasswordEntryKeyboardHelper.KEYBOARD_MODE_ALPHA)mKeyboardView.setVisibility(View.GONE)
        } //End block
        else
        {
mKeyboardHelper.setKeyboardMode(PasswordEntryKeyboardHelper.KEYBOARD_MODE_NUMERIC)mKeyboardView.setVisibility(mCreationHardKeyboardHidden==Configuration.HARDKEYBOARDHIDDEN_NO?View.INVISIBLE:View.INVISIBLE)            View pinDelete = findViewById(R.id.pinDel);
            if(pinDelete!=null)            
            {
pinDelete.setVisibility(View.VISIBLE)imeOrDeleteButtonVisible=truepinDelete.setOnClickListener(new OnClickListener()                {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.045 -0400", hash_original_method = "A96CA55029DA1CA89A64FEF1C4D5E428", hash_generated_method = "0E2AC8B7B2176865C63A8610707DAB6E")
        @Override
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
mKeyboardHelper.handleBackspace()
            // ---------- Original Method ----------
            //mKeyboardHelper.handleBackspace();
        }
                }
)
            } //End block
        } //End block
mPasswordEntry.requestFocus()        if(mIsAlpha)        
        {
mPasswordEntry.setKeyListener(TextKeyListener.getInstance())mPasswordEntry.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)
        } //End block
        else
        {
mPasswordEntry.setKeyListener(DigitsKeyListener.getInstance())mPasswordEntry.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_NUMBER_VARIATION_PASSWORD)
        } //End block
mPasswordEntry.setOnClickListener(new OnClickListener()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.047 -0400", hash_original_method = "4E269A6CC719369D163F4B85E6AED204", hash_generated_method = "7643014EB900168276143F6415943320")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
mCallback.pokeWakelock()
            // ---------- Original Method ----------
            //mCallback.pokeWakelock();
        }
        }
)mPasswordEntry.addTextChangedListener(new TextWatcher()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.049 -0400", hash_original_method = "65C508C8ABB6ACC44B70A081DD077416", hash_generated_method = "A21233C596673F70242F69FE5FA27133")
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(count);
            addTaint(before);
            addTaint(start);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.050 -0400", hash_original_method = "46932DA0618614AAF15434EFCC9FAF04", hash_generated_method = "63445082BCC7E22464CE7B1B497FEB87")
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            addTaint(after);
            addTaint(count);
            addTaint(start);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.051 -0400", hash_original_method = "F1BB1CFE28412322975C6392B6BB4EF4", hash_generated_method = "20FBFE4C93E928C1AC4C4CE6390C5692")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            if(!mResuming)            
            {
mCallback.pokeWakelock()
            } //End block
            // ---------- Original Method ----------
            //if (!mResuming) {
                    //mCallback.pokeWakelock();
                //}
        }
        }
)        View switchImeButton = findViewById(R.id.switch_ime_button);
        final InputMethodManager imm = (InputMethodManager) getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        if(mIsAlpha&&switchImeButton!=null&&hasMultipleEnabledIMEsOrSubtypes(imm, false))        
        {
switchImeButton.setVisibility(View.VISIBLE)imeOrDeleteButtonVisible=trueswitchImeButton.setOnClickListener(new OnClickListener()            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.052 -0400", hash_original_method = "701159E8B5046D51F52E00856F901974", hash_generated_method = "8EB08027C39E8847F3FA799BDF047195")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
mCallback.pokeWakelock()imm.showInputMethodPicker()
            // ---------- Original Method ----------
            //mCallback.pokeWakelock();
            //imm.showInputMethodPicker();
        }
            }
)
        } //End block
        if(!imeOrDeleteButtonVisible)        
        {
            android.view.ViewGroup.LayoutParams params = mPasswordEntry.getLayoutParams();
            if(params instanceof MarginLayoutParams)            
            {
((MarginLayoutParams)params).leftMargin=0mPasswordEntry.setLayoutParams(params)
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.058 -0400", hash_original_method = "E24120E569CFEF8899F1E83BC0E9D098", hash_generated_method = "33CE378201F31C3FFB584B0FF2429D0D")
    private boolean hasMultipleEnabledIMEsOrSubtypes(InputMethodManager imm,
            final boolean shouldIncludeAuxiliarySubtypes) {
        addTaint(shouldIncludeAuxiliarySubtypes);
        addTaint(imm.getTaint());
        final List<InputMethodInfo> enabledImis = imm.getEnabledInputMethodList();
        int filteredImisCount = 0;
for(InputMethodInfo imi : enabledImis)
        {
            if(filteredImisCount>1)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1816209403 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456344291 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_456344291;
            }
            final List<InputMethodSubtype> subtypes = imm.getEnabledInputMethodSubtypeList(imi, true);
            if(subtypes.isEmpty())            
            {
++filteredImisCount                continue;
            } //End block
            int auxCount = 0;
for(InputMethodSubtype subtype : subtypes)
            {
                if(subtype.isAuxiliary())                
                {
++auxCount
                } //End block
            } //End block
            final int nonAuxCount = subtypes.size() - auxCount;
            if(nonAuxCount>0||(shouldIncludeAuxiliarySubtypes&&auxCount>1))            
            {
++filteredImisCount                continue;
            } //End block
        } //End block
        boolean var4A5D7B86187ABA002C6BCD2DDA05E0D0_1454832185 = (filteredImisCount>1||imm.getEnabledInputMethodSubtypeList(null, false).size()>1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735410476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735410476;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.060 -0400", hash_original_method = "0B040D042050E09045B124A26382D7A2", hash_generated_method = "4CB1BBF54426E139E434D76F1EC37523")
    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        boolean var5E24265E5BB0D32F0F8B4C8FCF31414F_1631010037 = (mPasswordEntry.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116643259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116643259;
        // ---------- Original Method ----------
        //return mPasswordEntry.requestFocus(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.061 -0400", hash_original_method = "976CD814A870B00DF5FFF708E5C3F054", hash_generated_method = "279AC6461F3D45CE847397740C07D5ED")
    public boolean needsInput() {
        boolean var7C439E7FD5CD91285A1B00BE39D0A18C_1050944445 = (mUseSystemIME&&mIsAlpha);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777866230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777866230;
        // ---------- Original Method ----------
        //return mUseSystemIME && mIsAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.063 -0400", hash_original_method = "6D41C0C66FD3229BA3DBD4397B030BB8", hash_generated_method = "BA2ECE9ABD52642F5B0EE068C82229A7")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mStatusViewManager.onPause()
        // ---------- Original Method ----------
        //mStatusViewManager.onPause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.064 -0400", hash_original_method = "00376063ADBD2C2D618FD8F49D4A4E44", hash_generated_method = "B5849857D4442436E2E2DEAC971950DB")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
mResuming=truemStatusViewManager.onResume()mPasswordEntry.setText("")mPasswordEntry.requestFocus()        long deadline = mLockPatternUtils.getLockoutAttemptDeadline();
        if(deadline!=0)        
        {
handleAttemptLockout(deadline)
        } //End block
mResuming=false
        // ---------- Original Method ----------
        //mResuming = true;
        //mStatusViewManager.onResume();
        //mPasswordEntry.setText("");
        //mPasswordEntry.requestFocus();
        //long deadline = mLockPatternUtils.getLockoutAttemptDeadline();
        //if (deadline != 0) {
            //handleAttemptLockout(deadline);
        //}
        //mResuming = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.065 -0400", hash_original_method = "57900FE7FBA4EA3B12052220A0763A9A", hash_generated_method = "8CF28E63B6D1A9E7451E042DF023F024")
    public void cleanUp() {
mUpdateMonitor.removeCallback(this)
        // ---------- Original Method ----------
        //mUpdateMonitor.removeCallback(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.066 -0400", hash_original_method = "8EDF9875C6100DD5685F0606235979C6", hash_generated_method = "FD1E326F37594CCE85D4C426EFDE1326")
    private void verifyPasswordAndUnlock() {
        String entry = mPasswordEntry.getText().toString();
        if(mLockPatternUtils.checkPassword(entry))        
        {
mCallback.keyguardDone(true)mCallback.reportSuccessfulUnlockAttempt()mStatusViewManager.setInstructionText(null)KeyStore.getInstance().password(entry)
        } //End block
        else
        if(entry.length()>MINIMUM_PASSWORD_LENGTH_BEFORE_REPORT)        
        {
mCallback.reportFailedUnlockAttempt()            if(0==(mUpdateMonitor.getFailedAttempts()%LockPatternUtils.FAILED_ATTEMPTS_BEFORE_TIMEOUT))            
            {
                long deadline = mLockPatternUtils.setLockoutAttemptDeadline();
handleAttemptLockout(deadline)
            } //End block
mStatusViewManager.setInstructionText(mContext.getString(R.string.lockscreen_password_wrong))
        } //End block
        else
        if(entry.length()>0)        
        {
mStatusViewManager.setInstructionText(mContext.getString(R.string.lockscreen_password_wrong))
        } //End block
mPasswordEntry.setText("")
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.072 -0400", hash_original_method = "FBA41A8FB53B1665066767B15443D76A", hash_generated_method = "D5EFCDD319BDC68BFC54475C540F4751")
    private void handleAttemptLockout(long elapsedRealtimeDeadline) {
        addTaint(elapsedRealtimeDeadline);
mPasswordEntry.setEnabled(false)mKeyboardView.setEnabled(false)        long elapsedRealtime = SystemClock.elapsedRealtime();
new CountDownTimer(elapsedRealtimeDeadline-elapsedRealtime, 1000)        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.070 -0400", hash_original_method = "E7F0A4121BC197A59802342A8430EDD8", hash_generated_method = "B88B7EDA3886246D9646DC0DD1A2AA8F")
        @Override
        public void onTick(long millisUntilFinished) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(millisUntilFinished);
            int secondsRemaining = (int) (millisUntilFinished / 1000);
            String instructions = getContext().getString(
                        R.string.lockscreen_too_many_failed_attempts_countdown,
                        secondsRemaining);
mStatusViewManager.setInstructionText(instructions)
            // ---------- Original Method ----------
            //int secondsRemaining = (int) (millisUntilFinished / 1000);
            //String instructions = getContext().getString(
                        //R.string.lockscreen_too_many_failed_attempts_countdown,
                        //secondsRemaining);
            //mStatusViewManager.setInstructionText(instructions);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.071 -0400", hash_original_method = "0BAFEC69252BA27DEF90B31AB0ACBFB7", hash_generated_method = "B31426F0AC1497739A2590AB75F7B4E9")
        @Override
        public void onFinish() {
            //DSFIXME:  CODE0009: Possible callback target function detected
mPasswordEntry.setEnabled(true)mKeyboardView.setEnabled(true)mStatusViewManager.resetStatusInfo()
            // ---------- Original Method ----------
            //mPasswordEntry.setEnabled(true);
            //mKeyboardView.setEnabled(true);
            //mStatusViewManager.resetStatusInfo();
        }
        }
.start()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.073 -0400", hash_original_method = "EB2EDD55DC028A965A3D8DF51D31F924", hash_generated_method = "B9F743FC2A073D4D227B900BCBE91578")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
mCallback.pokeWakelock()        boolean var68934A3E9455FA72420237EB05902327_380654913 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414192792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_414192792;
        // ---------- Original Method ----------
        //mCallback.pokeWakelock();
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.075 -0400", hash_original_method = "4B120575EACBAB9CB7EB009D738B2EFF", hash_generated_method = "217E7891E88F90BE3096E01A1C9E53F1")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onAttachedToWindow()        Configuration config = getResources().getConfiguration();
        if(config.orientation!=mCreationOrientation||config.hardKeyboardHidden!=mCreationHardKeyboardHidden)        
        {
mCallback.recreateMe(config)
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //Configuration config = getResources().getConfiguration();
        //if (config.orientation != mCreationOrientation
                //|| config.hardKeyboardHidden != mCreationHardKeyboardHidden) {
            //mCallback.recreateMe(config);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.077 -0400", hash_original_method = "838F10E0FF29B1159C5E4DD02B729A48", hash_generated_method = "D4254D4FAC94401B62E0DAE47B79A935")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
super.onConfigurationChanged(newConfig)        if(newConfig.orientation!=mCreationOrientation||newConfig.hardKeyboardHidden!=mCreationHardKeyboardHidden)        
        {
mCallback.recreateMe(newConfig)
        } //End block
        // ---------- Original Method ----------
        //super.onConfigurationChanged(newConfig);
        //if (newConfig.orientation != mCreationOrientation
                //|| newConfig.hardKeyboardHidden != mCreationHardKeyboardHidden) {
            //mCallback.recreateMe(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.078 -0400", hash_original_method = "4AC476A570C4B7CCC26577615256A403", hash_generated_method = "2A0A9010A1D2464D48971BB5758F8154")
    public void onKeyboardChange(boolean isKeyboardOpen) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(isKeyboardOpen);
mKeyboardView.setVisibility(isKeyboardOpen?View.INVISIBLE:View.INVISIBLE)
        // ---------- Original Method ----------
        //mKeyboardView.setVisibility(isKeyboardOpen ? View.INVISIBLE : View.VISIBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.080 -0400", hash_original_method = "FEE550C5572AD3048A2EA64F3A4E1A0C", hash_generated_method = "965F1D70415299566543E51B109A2766")
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(actionId);
        addTaint(v.getTaint());
        if(actionId==EditorInfo.IME_NULL||actionId==EditorInfo.IME_ACTION_DONE||actionId==EditorInfo.IME_ACTION_NEXT)        
        {
verifyPasswordAndUnlock()            boolean varB326B5062B2F0E69046810717534CB09_1907106772 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123596411 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123596411;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_965661453 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52630448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52630448;
        // ---------- Original Method ----------
        //if (actionId == EditorInfo.IME_NULL || actionId == EditorInfo.IME_ACTION_DONE
                //|| actionId == EditorInfo.IME_ACTION_NEXT) {
            //verifyPasswordAndUnlock();
            //return true;
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.080 -0400", hash_original_field = "7F6A9A559FF08C2D11980EB9E4BFF6D2", hash_generated_field = "5CED7ED952C4211816064623FEBC904C")

    private static final String TAG = "PasswordUnlockScreen";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:42.081 -0400", hash_original_field = "F2E14277D63F5315991B79192489C9DD", hash_generated_field = "7D58356270E93F434B035593799F202F")

    private static final int MINIMUM_PASSWORD_LENGTH_BEFORE_REPORT = 3;
}

