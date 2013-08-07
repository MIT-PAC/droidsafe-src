package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import com.android.internal.R;
import android.os.Vibrator;
import android.util.Log;
import android.provider.Settings;
import android.inputmethodservice.Keyboard;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.HapticFeedbackConstants;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.content.Context;
import android.view.ViewGroup;
import android.view.KeyEvent;
import android.view.KeyCharacterMap;
import android.os.Handler;
import android.inputmethodservice.KeyboardView;
import android.content.res.Resources;
public class PasswordEntryKeyboardHelper implements OnKeyboardActionListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.146 -0400", hash_original_field = "FD532A0282F5E66B90DBB79D4143A5EC", hash_generated_field = "FCF043104D7DB05122FF6273D29FFC22")

    private int mKeyboardMode = KEYBOARD_MODE_ALPHA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.146 -0400", hash_original_field = "7F65482349A36057966B9D3BB57F46A4", hash_generated_field = "48E7FD28D8B0B21BF859D7B7434DFA24")

    private int mKeyboardState = KEYBOARD_STATE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "928C9B96FDE86B46218BFAD1DDB4FB8E", hash_generated_field = "08CBF7F888E46DA6B750AEE95AB34DA4")

    private PasswordEntryKeyboard mQwertyKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "4F77126566B71491BF0A4D642107DCBD", hash_generated_field = "64F48CC8FF020022E08D76A9D9B6118F")

    private PasswordEntryKeyboard mQwertyKeyboardShifted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "A8DC6B24B396B6A6A7AB60B5F0213770", hash_generated_field = "55718FEFF4800ED77BF0E812A6CE7B96")

    private PasswordEntryKeyboard mSymbolsKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "412F1B96D2DA6F0210C7E271DEB31E93", hash_generated_field = "F2DE32CD803E2A1B178CCC7A4CF9AACB")

    private PasswordEntryKeyboard mSymbolsKeyboardShifted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "9B4C9319CF3A85797B9D0C056644076D", hash_generated_field = "66EC72B7626A90D3A617C4530B512EB3")

    private PasswordEntryKeyboard mNumericKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "4FDD02795CD9F6B3D3D1A34A14720073", hash_generated_field = "EF1B6CBC9C15828C133DC7668A7693EA")

    private View mTargetView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.147 -0400", hash_original_field = "74BC2460FFE04FD4A6428538C62CC058", hash_generated_field = "EA39A9C511737D138BA88B0C5ED89869")

    private KeyboardView mKeyboardView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.148 -0400", hash_original_field = "E3C87B1FFC864A9A5902F8C34531C90A", hash_generated_field = "431D243F117535D55F73371B3C7224A4")

    private long[] mVibratePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.148 -0400", hash_original_field = "8B9AFF2ADBC7576CDDFD97F2FF13C05E", hash_generated_field = "56B7545E4817897474E0C3E66E03826A")

    private boolean mEnableHaptics = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.148 -0400", hash_original_method = "5412E0DAB09592884A325EA40C779381", hash_generated_method = "4899D3EC98DC5D6D7A513E928695D72F")
    public  PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardView, View targetView) {
        this(context, keyboardView, targetView, true);
        addTaint(targetView.getTaint());
        addTaint(keyboardView.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.150 -0400", hash_original_method = "00992D208B7C3D2D0EDDFE98B9D8CC9F", hash_generated_method = "22F69AB8C70EF1D3130ABA3F42317091")
    public  PasswordEntryKeyboardHelper(Context context, KeyboardView keyboardView, View targetView,
            boolean useFullScreenWidth) {
        addTaint(useFullScreenWidth);
        addTaint(targetView.getTaint());
        addTaint(keyboardView.getTaint());
        addTaint(context.getTaint());
mContext=contextmTargetView=targetViewmKeyboardView=keyboardView        if(useFullScreenWidth||mKeyboardView.getLayoutParams().width==ViewGroup.LayoutParams.MATCH_PARENT)        
        {
createKeyboards()
        } //End block
        else
        {
createKeyboardsWithSpecificSize(mKeyboardView.getLayoutParams().width, mKeyboardView.getLayoutParams().height)
        } //End block
mKeyboardView.setOnKeyboardActionListener(this)
        // ---------- Original Method ----------
        //mContext = context;
        //mTargetView = targetView;
        //mKeyboardView = keyboardView;
        //if (useFullScreenWidth
                //|| mKeyboardView.getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT) {
            //createKeyboards();
        //} else {
            //createKeyboardsWithSpecificSize(mKeyboardView.getLayoutParams().width,
                    //mKeyboardView.getLayoutParams().height);
        //}
        //mKeyboardView.setOnKeyboardActionListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.151 -0400", hash_original_method = "4B7F84D758BDFBDEB1296EB3669841C5", hash_generated_method = "A6DD4B165717FD42A2E7C1464D56E3CA")
    public void setEnableHaptics(boolean enabled) {
        addTaint(enabled);
mEnableHaptics=enabled
        // ---------- Original Method ----------
        //mEnableHaptics = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.151 -0400", hash_original_method = "A11DF93FB5FF24ECB06377A3B09949CE", hash_generated_method = "85402EECBA975959E8632C00C41DA5A8")
    public boolean isAlpha() {
        boolean var04262FC08A48FFC5678279184348342E_1201567796 = (mKeyboardMode==KEYBOARD_MODE_ALPHA);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645467427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645467427;
        // ---------- Original Method ----------
        //return mKeyboardMode == KEYBOARD_MODE_ALPHA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.152 -0400", hash_original_method = "96673172D647AE3A56F042E86E877F03", hash_generated_method = "712F0D9C81100EDB4777B935FF9D6E05")
    private void createKeyboardsWithSpecificSize(int viewWidth, int viewHeight) {
        addTaint(viewHeight);
        addTaint(viewWidth);
mNumericKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_numeric, viewWidth, viewHeight)mQwertyKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_qwerty, R.id.mode_normal, viewWidth, viewHeight)mQwertyKeyboard.enableShiftLock()mQwertyKeyboardShifted=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_qwerty_shifted, R.id.mode_normal, viewWidth, viewHeight)mQwertyKeyboardShifted.enableShiftLock()mQwertyKeyboardShifted.setShifted(true)mSymbolsKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_symbols, viewWidth, viewHeight)mSymbolsKeyboard.enableShiftLock()mSymbolsKeyboardShifted=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_symbols_shift, viewWidth, viewHeight)mSymbolsKeyboardShifted.enableShiftLock()mSymbolsKeyboardShifted.setShifted(true)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.153 -0400", hash_original_method = "61B2BC8A5C36B18AD1A162FF276C79AC", hash_generated_method = "F0D101C3C9CC300B2D9A0424041EB2B3")
    private void createKeyboards() {
mNumericKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_numeric)mQwertyKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_qwerty, R.id.mode_normal)mQwertyKeyboard.enableShiftLock()mQwertyKeyboardShifted=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_qwerty_shifted, R.id.mode_normal)mQwertyKeyboardShifted.enableShiftLock()mQwertyKeyboardShifted.setShifted(true)mSymbolsKeyboard=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_symbols)mSymbolsKeyboard.enableShiftLock()mSymbolsKeyboardShifted=new PasswordEntryKeyboard(mContext, R.xml.password_kbd_symbols_shift)mSymbolsKeyboardShifted.enableShiftLock()mSymbolsKeyboardShifted.setShifted(true)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.154 -0400", hash_original_method = "7E355FEE2E17AE88BE1FA7D203797CC6", hash_generated_method = "4BAFA2B1ADF498BBE0B794BA3C81076D")
    public void setKeyboardMode(int mode) {
        addTaint(mode);
        switch(mode){
        case KEYBOARD_MODE_ALPHA:
mKeyboardView.setKeyboard(mQwertyKeyboard)mKeyboardState=KEYBOARD_STATE_NORMAL        final boolean visiblePassword = Settings.System.getInt(
                        mContext.getContentResolver(),
                        Settings.System.TEXT_SHOW_PASSWORD, 1) != 0;
        final boolean enablePreview = false;
mKeyboardView.setPreviewEnabled(visiblePassword&&enablePreview)        break;
        case KEYBOARD_MODE_NUMERIC:
mKeyboardView.setKeyboard(mNumericKeyboard)mKeyboardState=KEYBOARD_STATE_NORMALmKeyboardView.setPreviewEnabled(false)        break;
}mKeyboardMode=mode
        // ---------- Original Method ----------
        //switch (mode) {
            //case KEYBOARD_MODE_ALPHA:
                //mKeyboardView.setKeyboard(mQwertyKeyboard);
                //mKeyboardState = KEYBOARD_STATE_NORMAL;
                //final boolean visiblePassword = Settings.System.getInt(
                        //mContext.getContentResolver(),
                        //Settings.System.TEXT_SHOW_PASSWORD, 1) != 0;
                //final boolean enablePreview = false; 
                //mKeyboardView.setPreviewEnabled(visiblePassword && enablePreview);
                //break;
            //case KEYBOARD_MODE_NUMERIC:
                //mKeyboardView.setKeyboard(mNumericKeyboard);
                //mKeyboardState = KEYBOARD_STATE_NORMAL;
                //mKeyboardView.setPreviewEnabled(false); 
                //break;
        //}
        //mKeyboardMode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.155 -0400", hash_original_method = "DBF670C38C01C38987778E8FEFACEEB7", hash_generated_method = "812F9E4F51E91CB04234FDC7007CB2A8")
    private void sendKeyEventsToTarget(int character) {
        addTaint(character);
        Handler handler = mTargetView.getHandler();
        KeyEvent[] events = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD).getEvents(
                new char[] { (char) character });
        if(events!=null)        
        {
            final int N = events.length;
for(int i=0;i<N;i)
            {
                KeyEvent event = events[i];
event=KeyEvent.changeFlags(event, event.getFlags()|KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE)handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY, event))
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Handler handler = mTargetView.getHandler();
        //KeyEvent[] events = KeyCharacterMap.load(KeyCharacterMap.VIRTUAL_KEYBOARD).getEvents(
                //new char[] { (char) character });
        //if (events != null) {
            //final int N = events.length;
            //for (int i=0; i<N; i++) {
                //KeyEvent event = events[i];
                //event = KeyEvent.changeFlags(event, event.getFlags()
                        //| KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE);
                //handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY, event));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.155 -0400", hash_original_method = "B9408470416AF36FD5531E53D392954E", hash_generated_method = "DC3A1CEE5BCBFB9DB86FB0938DCD843E")
    public void sendDownUpKeyEvents(int keyEventCode) {
        addTaint(keyEventCode);
        long eventTime = SystemClock.uptimeMillis();
        Handler handler = mTargetView.getHandler();
handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME, new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE)))handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME, new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE)))
        // ---------- Original Method ----------
        //long eventTime = SystemClock.uptimeMillis();
        //Handler handler = mTargetView.getHandler();
        //handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                //new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, keyEventCode, 0, 0,
                        //KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                    //KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE)));
        //handler.sendMessage(handler.obtainMessage(ViewRootImpl.DISPATCH_KEY_FROM_IME,
                //new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_UP, keyEventCode, 0, 0,
                        //KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                        //KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.156 -0400", hash_original_method = "D9FD67C8FD34EBFE479BC23B7A4DBC3B", hash_generated_method = "1C01CB35C850C61B87E91B2B6933D8C1")
    public void onKey(int primaryCode, int[] keyCodes) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCodes[0]);
        addTaint(primaryCode);
        if(primaryCode==Keyboard.KEYCODE_DELETE)        
        {
handleBackspace()
        } //End block
        else
        if(primaryCode==Keyboard.KEYCODE_SHIFT)        
        {
handleShift()
        } //End block
        else
        if(primaryCode==Keyboard.KEYCODE_CANCEL)        
        {
handleClose()            return;
        } //End block
        else
        if(primaryCode==Keyboard.KEYCODE_MODE_CHANGE&&mKeyboardView!=null)        
        {
handleModeChange()
        } //End block
        else
        {
handleCharacter(primaryCode, keyCodes)            if(mKeyboardState==KEYBOARD_STATE_SHIFTED)            
            {
mKeyboardState=KEYBOARD_STATE_CAPSLOCKhandleShift()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (primaryCode == Keyboard.KEYCODE_DELETE) {
            //handleBackspace();
        //} else if (primaryCode == Keyboard.KEYCODE_SHIFT) {
            //handleShift();
        //} else if (primaryCode == Keyboard.KEYCODE_CANCEL) {
            //handleClose();
            //return;
        //} else if (primaryCode == Keyboard.KEYCODE_MODE_CHANGE && mKeyboardView != null) {
            //handleModeChange();
        //} else {
            //handleCharacter(primaryCode, keyCodes);
            //if (mKeyboardState == KEYBOARD_STATE_SHIFTED) {
                //mKeyboardState = KEYBOARD_STATE_CAPSLOCK;
                //handleShift();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.157 -0400", hash_original_method = "CC915A5B7826BC771AD71F56DC73BD74", hash_generated_method = "C1551565143EA42FCAA705674D482DE1")
    public void setVibratePattern(int id) {
        addTaint(id);
        int[] tmpArray = null;
        try 
        {
tmpArray=mContext.getResources().getIntArray(id)
        } //End block
        catch (Resources.NotFoundException e)
        {
            if(id!=0)            
            {
            } //End block
        } //End block
        if(tmpArray==null)        
        {
mVibratePattern=null            return;
        } //End block
mVibratePattern=new longfor(int i = 0;i<tmpArray.length;i)
        {
mVibratePattern[i]=tmpArray[i]
        } //End block
        // ---------- Original Method ----------
        //int[] tmpArray = null;
        //try {
            //tmpArray = mContext.getResources().getIntArray(id);
        //} catch (Resources.NotFoundException e) {
            //if (id != 0) {
                //Log.e(TAG, "Vibrate pattern missing", e);
            //}
        //}
        //if (tmpArray == null) {
            //mVibratePattern = null;
            //return;
        //}
        //mVibratePattern = new long[tmpArray.length];
        //for (int i = 0; i < tmpArray.length; i++) {
            //mVibratePattern[i] = tmpArray[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.158 -0400", hash_original_method = "08C26F2EB9440DBD36E6045944CCE786", hash_generated_method = "131D104AEAF2326040B2F251317904BF")
    private void handleModeChange() {
        final Keyboard current = mKeyboardView.getKeyboard();
        Keyboard next = null;
        if(current==mQwertyKeyboard||current==mQwertyKeyboardShifted)        
        {
next=mSymbolsKeyboard
        } //End block
        else
        if(current==mSymbolsKeyboard||current==mSymbolsKeyboardShifted)        
        {
next=mQwertyKeyboard
        } //End block
        if(next!=null)        
        {
mKeyboardView.setKeyboard(next)mKeyboardState=KEYBOARD_STATE_NORMAL
        } //End block
        // ---------- Original Method ----------
        //final Keyboard current = mKeyboardView.getKeyboard();
        //Keyboard next = null;
        //if (current == mQwertyKeyboard || current == mQwertyKeyboardShifted) {
            //next = mSymbolsKeyboard;
        //} else if (current == mSymbolsKeyboard || current == mSymbolsKeyboardShifted) {
            //next = mQwertyKeyboard;
        //}
        //if (next != null) {
            //mKeyboardView.setKeyboard(next);
            //mKeyboardState = KEYBOARD_STATE_NORMAL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.158 -0400", hash_original_method = "4BA55DA0A9BDB49445AA81A32095F0E9", hash_generated_method = "A328D76593EFC9D1763B327FFF8F736F")
    public void handleBackspace() {
sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL)performHapticFeedback()
        // ---------- Original Method ----------
        //sendDownUpKeyEvents(KeyEvent.KEYCODE_DEL);
        //performHapticFeedback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.159 -0400", hash_original_method = "3F1B5DE1475908013249A9D8D0F3A4D5", hash_generated_method = "960986AC0AC0237490AFD4B1635D6C3E")
    private void handleShift() {
        if(mKeyboardView==null)        
        {
            return;
        } //End block
        Keyboard current = mKeyboardView.getKeyboard();
        PasswordEntryKeyboard next = null;
        final boolean isAlphaMode = current == mQwertyKeyboard
                || current == mQwertyKeyboardShifted;
        if(mKeyboardState==KEYBOARD_STATE_NORMAL)        
        {
mKeyboardState=isAlphaMode?KEYBOARD_STATE_SHIFTED:KEYBOARD_STATE_SHIFTEDnext=isAlphaMode?mQwertyKeyboardShifted:mQwertyKeyboardShifted
        } //End block
        else
        if(mKeyboardState==KEYBOARD_STATE_SHIFTED)        
        {
mKeyboardState=KEYBOARD_STATE_CAPSLOCKnext=isAlphaMode?mQwertyKeyboardShifted:mQwertyKeyboardShifted
        } //End block
        else
        if(mKeyboardState==KEYBOARD_STATE_CAPSLOCK)        
        {
mKeyboardState=KEYBOARD_STATE_NORMALnext=isAlphaMode?mQwertyKeyboard:mQwertyKeyboard
        } //End block
        if(next!=null)        
        {
            if(next!=current)            
            {
mKeyboardView.setKeyboard(next)
            } //End block
next.setShiftLocked(mKeyboardState==KEYBOARD_STATE_CAPSLOCK)mKeyboardView.setShifted(mKeyboardState!=KEYBOARD_STATE_NORMAL)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.159 -0400", hash_original_method = "7725F3C1EEE5065A781B50ADDB7EDA22", hash_generated_method = "1EBD9C78954384C51ACCF61E87786C4B")
    private void handleCharacter(int primaryCode, int[] keyCodes) {
        addTaint(keyCodes[0]);
        addTaint(primaryCode);
        if(mKeyboardView.isShifted()&&primaryCode!=' '&&primaryCode!='\n')        
        {
primaryCode=Character.toUpperCase(primaryCode)
        } //End block
sendKeyEventsToTarget(primaryCode)
        // ---------- Original Method ----------
        //if (mKeyboardView.isShifted() && primaryCode != ' ' && primaryCode != '\n') {
            //primaryCode = Character.toUpperCase(primaryCode);
        //}
        //sendKeyEventsToTarget(primaryCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.159 -0400", hash_original_method = "A8F0DE52E23085E7EEF58DFB51B1C9C8", hash_generated_method = "05DA7BB5E4A6087A9A10E668D628E820")
    private void handleClose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.160 -0400", hash_original_method = "65782C4B5CF8A75FC57539E7CE03F684", hash_generated_method = "8FD350691F50DA8D436B7D0BBD695B2A")
    public void onPress(int primaryCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(primaryCode);
performHapticFeedback()
        // ---------- Original Method ----------
        //performHapticFeedback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.160 -0400", hash_original_method = "04D808292EA4C9E08942D771B56249C3", hash_generated_method = "4F4D03BA7CBF3D6206958801FDB2B03B")
    private void performHapticFeedback() {
        if(mEnableHaptics)        
        {
mKeyboardView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING|HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING)
        } //End block
        // ---------- Original Method ----------
        //if (mEnableHaptics) {
            //mKeyboardView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY,
                    //HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING
                    //| HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.160 -0400", hash_original_method = "05811468331AF2D4B20ADD7C77D53C83", hash_generated_method = "DEA02500E2D7C0C6C526C702B735225B")
    public void onRelease(int primaryCode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(primaryCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.161 -0400", hash_original_method = "15964EA60114F3A36022187F05F53276", hash_generated_method = "6E2FF6F5ED3C74C8AA45AB950D6D408C")
    public void onText(CharSequence text) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(text.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.161 -0400", hash_original_method = "C6986FC144FCB0133646C59896DFDCFE", hash_generated_method = "D3F84C631847D5CC2999D71BB193BBDF")
    public void swipeDown() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.161 -0400", hash_original_method = "A10E1DAC2EDBC7020DC2F7E4D98A3F64", hash_generated_method = "5F976117E69399C87D4A18BFE51CD3C6")
    public void swipeLeft() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.161 -0400", hash_original_method = "39C1073E449F390D664997ABE62AF951", hash_generated_method = "9CFB46C083FF396E413B5AD87FB897D1")
    public void swipeRight() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:52.162 -0400", hash_original_method = "E518075537708F9E99955A7C3231B70D", hash_generated_method = "96CDAE0D4D8413EF27D65DA19B3BF2F8")
    public void swipeUp() {
        // ---------- Original Method ----------
    }

    

