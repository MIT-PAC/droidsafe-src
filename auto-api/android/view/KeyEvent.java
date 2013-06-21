package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyCharacterMap;
import android.view.KeyCharacterMap.KeyData;

public class KeyEvent extends InputEvent implements Parcelable {
    private KeyEvent mNext;
    private boolean mRecycled;
    private int mDeviceId;
    private int mSource;
    private int mMetaState;
    private int mAction;
    private int mKeyCode;
    private int mScanCode;
    private int mRepeatCount;
    private int mFlags;
    private long mDownTime;
    private long mEventTime;
    private String mCharacters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.004 -0400", hash_original_method = "E1777BC70B96D5008D693732650D9927", hash_generated_method = "560F8A7FDE8C5C12025FD3A840761BDA")
    @DSModeled(DSC.SAFE)
    private KeyEvent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.004 -0400", hash_original_method = "CD3F04ECBB2EC92C58F1141FB07383F6", hash_generated_method = "B4BB376BC6E7B5F64E8EF8D8206F95E8")
    @DSModeled(DSC.SAFE)
    public KeyEvent(int action, int code) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(code);
        mRepeatCount = 0;
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
        // ---------- Original Method ----------
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = 0;
        //mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.004 -0400", hash_original_method = "460E02BA0A36D9C6A0F4AFF64D96FF32", hash_generated_method = "3CB32913CD236E6A2D2C280EB0A75BC5")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(repeat);
        dsTaint.addTaint(code);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(downTime);
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
        // ---------- Original Method ----------
        //mDownTime = downTime;
        //mEventTime = eventTime;
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = repeat;
        //mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.005 -0400", hash_original_method = "25AD2761B1583202D71C2F5EBFFC872D", hash_generated_method = "5DA5153C4F6EC6644754B23BA1E2AAA6")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(action);
        dsTaint.addTaint(repeat);
        dsTaint.addTaint(code);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(downTime);
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
        // ---------- Original Method ----------
        //mDownTime = downTime;
        //mEventTime = eventTime;
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = repeat;
        //mMetaState = metaState;
        //mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.005 -0400", hash_original_method = "A71C4CD2E48CE8A2B595D45DAD40720E", hash_generated_method = "A7BD9B2BA23A42DA33FE0CDED37F2BF0")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode) {
        dsTaint.addTaint(scancode);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(action);
        dsTaint.addTaint(repeat);
        dsTaint.addTaint(code);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(deviceId);
        dsTaint.addTaint(downTime);
        // ---------- Original Method ----------
        //mDownTime = downTime;
        //mEventTime = eventTime;
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = repeat;
        //mMetaState = metaState;
        //mDeviceId = deviceId;
        //mScanCode = scancode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.005 -0400", hash_original_method = "8535C41697CC0C68061B8A72D476CEA4", hash_generated_method = "2F88C942C516DBE62FBA705B4B9A6A57")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode, int flags) {
        dsTaint.addTaint(scancode);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(action);
        dsTaint.addTaint(repeat);
        dsTaint.addTaint(code);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(deviceId);
        dsTaint.addTaint(downTime);
        // ---------- Original Method ----------
        //mDownTime = downTime;
        //mEventTime = eventTime;
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = repeat;
        //mMetaState = metaState;
        //mDeviceId = deviceId;
        //mScanCode = scancode;
        //mFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.005 -0400", hash_original_method = "7235AB46A09763BE60DBC1995AF7FBA4", hash_generated_method = "FADFBB67D3903743C4721F0E7CED4FCB")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode, int flags, int source) {
        dsTaint.addTaint(scancode);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(source);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(action);
        dsTaint.addTaint(repeat);
        dsTaint.addTaint(code);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(deviceId);
        dsTaint.addTaint(downTime);
        // ---------- Original Method ----------
        //mDownTime = downTime;
        //mEventTime = eventTime;
        //mAction = action;
        //mKeyCode = code;
        //mRepeatCount = repeat;
        //mMetaState = metaState;
        //mDeviceId = deviceId;
        //mScanCode = scancode;
        //mFlags = flags;
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.006 -0400", hash_original_method = "6373116C9B5FF479EB0DF8409EEE5FFB", hash_generated_method = "AD37A4C34AFF78ADBA87204A8CC80F7C")
    @DSModeled(DSC.SAFE)
    public KeyEvent(long time, String characters, int deviceId, int flags) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(deviceId);
        dsTaint.addTaint(characters);
        mAction = ACTION_MULTIPLE;
        mKeyCode = KEYCODE_UNKNOWN;
        mRepeatCount = 0;
        mSource = InputDevice.SOURCE_KEYBOARD;
        // ---------- Original Method ----------
        //mDownTime = time;
        //mEventTime = time;
        //mCharacters = characters;
        //mAction = ACTION_MULTIPLE;
        //mKeyCode = KEYCODE_UNKNOWN;
        //mRepeatCount = 0;
        //mDeviceId = deviceId;
        //mFlags = flags;
        //mSource = InputDevice.SOURCE_KEYBOARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.006 -0400", hash_original_method = "DBCE0965BBC4352F0EBDFBB71CBA04FA", hash_generated_method = "6D1A1CEDD667C6EA869E207BEB520301")
    @DSModeled(DSC.SAFE)
    public KeyEvent(KeyEvent origEvent) {
        dsTaint.addTaint(origEvent.dsTaint);
        mDownTime = origEvent.mDownTime;
        mEventTime = origEvent.mEventTime;
        mAction = origEvent.mAction;
        mKeyCode = origEvent.mKeyCode;
        mRepeatCount = origEvent.mRepeatCount;
        mMetaState = origEvent.mMetaState;
        mDeviceId = origEvent.mDeviceId;
        mSource = origEvent.mSource;
        mScanCode = origEvent.mScanCode;
        mFlags = origEvent.mFlags;
        mCharacters = origEvent.mCharacters;
        // ---------- Original Method ----------
        //mDownTime = origEvent.mDownTime;
        //mEventTime = origEvent.mEventTime;
        //mAction = origEvent.mAction;
        //mKeyCode = origEvent.mKeyCode;
        //mRepeatCount = origEvent.mRepeatCount;
        //mMetaState = origEvent.mMetaState;
        //mDeviceId = origEvent.mDeviceId;
        //mSource = origEvent.mSource;
        //mScanCode = origEvent.mScanCode;
        //mFlags = origEvent.mFlags;
        //mCharacters = origEvent.mCharacters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.006 -0400", hash_original_method = "1712784D81B05F738E3678B0ED7626EA", hash_generated_method = "C90A905C1AFAF63B632D3305D448953E")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public KeyEvent(KeyEvent origEvent, long eventTime, int newRepeat) {
        dsTaint.addTaint(origEvent.dsTaint);
        dsTaint.addTaint(eventTime);
        dsTaint.addTaint(newRepeat);
        mDownTime = origEvent.mDownTime;
        mAction = origEvent.mAction;
        mKeyCode = origEvent.mKeyCode;
        mMetaState = origEvent.mMetaState;
        mDeviceId = origEvent.mDeviceId;
        mSource = origEvent.mSource;
        mScanCode = origEvent.mScanCode;
        mFlags = origEvent.mFlags;
        mCharacters = origEvent.mCharacters;
        // ---------- Original Method ----------
        //mDownTime = origEvent.mDownTime;
        //mEventTime = eventTime;
        //mAction = origEvent.mAction;
        //mKeyCode = origEvent.mKeyCode;
        //mRepeatCount = newRepeat;
        //mMetaState = origEvent.mMetaState;
        //mDeviceId = origEvent.mDeviceId;
        //mSource = origEvent.mSource;
        //mScanCode = origEvent.mScanCode;
        //mFlags = origEvent.mFlags;
        //mCharacters = origEvent.mCharacters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.007 -0400", hash_original_method = "5AF6098C2FF410C0A9EE2BEE9470EC38", hash_generated_method = "6E1D0B0D85AD45F4C2DDB372B6CBCCB1")
    @DSModeled(DSC.SAFE)
    private KeyEvent(KeyEvent origEvent, int action) {
        dsTaint.addTaint(origEvent.dsTaint);
        dsTaint.addTaint(action);
        mDownTime = origEvent.mDownTime;
        mEventTime = origEvent.mEventTime;
        mKeyCode = origEvent.mKeyCode;
        mRepeatCount = origEvent.mRepeatCount;
        mMetaState = origEvent.mMetaState;
        mDeviceId = origEvent.mDeviceId;
        mSource = origEvent.mSource;
        mScanCode = origEvent.mScanCode;
        mFlags = origEvent.mFlags;
        // ---------- Original Method ----------
        //mDownTime = origEvent.mDownTime;
        //mEventTime = origEvent.mEventTime;
        //mAction = action;
        //mKeyCode = origEvent.mKeyCode;
        //mRepeatCount = origEvent.mRepeatCount;
        //mMetaState = origEvent.mMetaState;
        //mDeviceId = origEvent.mDeviceId;
        //mSource = origEvent.mSource;
        //mScanCode = origEvent.mScanCode;
        //mFlags = origEvent.mFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.007 -0400", hash_original_method = "6CD21CCD9028EF5AE389AE8F77253E73", hash_generated_method = "C7C5B201F8D4545BC8BC1E6B8CC503E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private KeyEvent(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mDeviceId = in.readInt();
        mSource = in.readInt();
        mAction = in.readInt();
        mKeyCode = in.readInt();
        mRepeatCount = in.readInt();
        mMetaState = in.readInt();
        mScanCode = in.readInt();
        mFlags = in.readInt();
        mDownTime = in.readLong();
        mEventTime = in.readLong();
        // ---------- Original Method ----------
        //mDeviceId = in.readInt();
        //mSource = in.readInt();
        //mAction = in.readInt();
        //mKeyCode = in.readInt();
        //mRepeatCount = in.readInt();
        //mMetaState = in.readInt();
        //mScanCode = in.readInt();
        //mFlags = in.readInt();
        //mDownTime = in.readLong();
        //mEventTime = in.readLong();
    }

    
        private static void populateKeycodeSymbolicNames() {
        SparseArray<String> names = KEYCODE_SYMBOLIC_NAMES;
        names.append(KEYCODE_UNKNOWN, "KEYCODE_UNKNOWN");
        names.append(KEYCODE_SOFT_LEFT, "KEYCODE_SOFT_LEFT");
        names.append(KEYCODE_SOFT_RIGHT, "KEYCODE_SOFT_RIGHT");
        names.append(KEYCODE_HOME, "KEYCODE_HOME");
        names.append(KEYCODE_BACK, "KEYCODE_BACK");
        names.append(KEYCODE_CALL, "KEYCODE_CALL");
        names.append(KEYCODE_ENDCALL, "KEYCODE_ENDCALL");
        names.append(KEYCODE_0, "KEYCODE_0");
        names.append(KEYCODE_1, "KEYCODE_1");
        names.append(KEYCODE_2, "KEYCODE_2");
        names.append(KEYCODE_3, "KEYCODE_3");
        names.append(KEYCODE_4, "KEYCODE_4");
        names.append(KEYCODE_5, "KEYCODE_5");
        names.append(KEYCODE_6, "KEYCODE_6");
        names.append(KEYCODE_7, "KEYCODE_7");
        names.append(KEYCODE_8, "KEYCODE_8");
        names.append(KEYCODE_9, "KEYCODE_9");
        names.append(KEYCODE_STAR, "KEYCODE_STAR");
        names.append(KEYCODE_POUND, "KEYCODE_POUND");
        names.append(KEYCODE_DPAD_UP, "KEYCODE_DPAD_UP");
        names.append(KEYCODE_DPAD_DOWN, "KEYCODE_DPAD_DOWN");
        names.append(KEYCODE_DPAD_LEFT, "KEYCODE_DPAD_LEFT");
        names.append(KEYCODE_DPAD_RIGHT, "KEYCODE_DPAD_RIGHT");
        names.append(KEYCODE_DPAD_CENTER, "KEYCODE_DPAD_CENTER");
        names.append(KEYCODE_VOLUME_UP, "KEYCODE_VOLUME_UP");
        names.append(KEYCODE_VOLUME_DOWN, "KEYCODE_VOLUME_DOWN");
        names.append(KEYCODE_POWER, "KEYCODE_POWER");
        names.append(KEYCODE_CAMERA, "KEYCODE_CAMERA");
        names.append(KEYCODE_CLEAR, "KEYCODE_CLEAR");
        names.append(KEYCODE_A, "KEYCODE_A");
        names.append(KEYCODE_B, "KEYCODE_B");
        names.append(KEYCODE_C, "KEYCODE_C");
        names.append(KEYCODE_D, "KEYCODE_D");
        names.append(KEYCODE_E, "KEYCODE_E");
        names.append(KEYCODE_F, "KEYCODE_F");
        names.append(KEYCODE_G, "KEYCODE_G");
        names.append(KEYCODE_H, "KEYCODE_H");
        names.append(KEYCODE_I, "KEYCODE_I");
        names.append(KEYCODE_J, "KEYCODE_J");
        names.append(KEYCODE_K, "KEYCODE_K");
        names.append(KEYCODE_L, "KEYCODE_L");
        names.append(KEYCODE_M, "KEYCODE_M");
        names.append(KEYCODE_N, "KEYCODE_N");
        names.append(KEYCODE_O, "KEYCODE_O");
        names.append(KEYCODE_P, "KEYCODE_P");
        names.append(KEYCODE_Q, "KEYCODE_Q");
        names.append(KEYCODE_R, "KEYCODE_R");
        names.append(KEYCODE_S, "KEYCODE_S");
        names.append(KEYCODE_T, "KEYCODE_T");
        names.append(KEYCODE_U, "KEYCODE_U");
        names.append(KEYCODE_V, "KEYCODE_V");
        names.append(KEYCODE_W, "KEYCODE_W");
        names.append(KEYCODE_X, "KEYCODE_X");
        names.append(KEYCODE_Y, "KEYCODE_Y");
        names.append(KEYCODE_Z, "KEYCODE_Z");
        names.append(KEYCODE_COMMA, "KEYCODE_COMMA");
        names.append(KEYCODE_PERIOD, "KEYCODE_PERIOD");
        names.append(KEYCODE_ALT_LEFT, "KEYCODE_ALT_LEFT");
        names.append(KEYCODE_ALT_RIGHT, "KEYCODE_ALT_RIGHT");
        names.append(KEYCODE_SHIFT_LEFT, "KEYCODE_SHIFT_LEFT");
        names.append(KEYCODE_SHIFT_RIGHT, "KEYCODE_SHIFT_RIGHT");
        names.append(KEYCODE_TAB, "KEYCODE_TAB");
        names.append(KEYCODE_SPACE, "KEYCODE_SPACE");
        names.append(KEYCODE_SYM, "KEYCODE_SYM");
        names.append(KEYCODE_EXPLORER, "KEYCODE_EXPLORER");
        names.append(KEYCODE_ENVELOPE, "KEYCODE_ENVELOPE");
        names.append(KEYCODE_ENTER, "KEYCODE_ENTER");
        names.append(KEYCODE_DEL, "KEYCODE_DEL");
        names.append(KEYCODE_GRAVE, "KEYCODE_GRAVE");
        names.append(KEYCODE_MINUS, "KEYCODE_MINUS");
        names.append(KEYCODE_EQUALS, "KEYCODE_EQUALS");
        names.append(KEYCODE_LEFT_BRACKET, "KEYCODE_LEFT_BRACKET");
        names.append(KEYCODE_RIGHT_BRACKET, "KEYCODE_RIGHT_BRACKET");
        names.append(KEYCODE_BACKSLASH, "KEYCODE_BACKSLASH");
        names.append(KEYCODE_SEMICOLON, "KEYCODE_SEMICOLON");
        names.append(KEYCODE_APOSTROPHE, "KEYCODE_APOSTROPHE");
        names.append(KEYCODE_SLASH, "KEYCODE_SLASH");
        names.append(KEYCODE_AT, "KEYCODE_AT");
        names.append(KEYCODE_NUM, "KEYCODE_NUM");
        names.append(KEYCODE_HEADSETHOOK, "KEYCODE_HEADSETHOOK");
        names.append(KEYCODE_FOCUS, "KEYCODE_FOCUS");
        names.append(KEYCODE_PLUS, "KEYCODE_PLUS");
        names.append(KEYCODE_MENU, "KEYCODE_MENU");
        names.append(KEYCODE_NOTIFICATION, "KEYCODE_NOTIFICATION");
        names.append(KEYCODE_SEARCH, "KEYCODE_SEARCH");
        names.append(KEYCODE_MEDIA_PLAY_PAUSE, "KEYCODE_MEDIA_PLAY_PAUSE");
        names.append(KEYCODE_MEDIA_STOP, "KEYCODE_MEDIA_STOP");
        names.append(KEYCODE_MEDIA_NEXT, "KEYCODE_MEDIA_NEXT");
        names.append(KEYCODE_MEDIA_PREVIOUS, "KEYCODE_MEDIA_PREVIOUS");
        names.append(KEYCODE_MEDIA_REWIND, "KEYCODE_MEDIA_REWIND");
        names.append(KEYCODE_MEDIA_FAST_FORWARD, "KEYCODE_MEDIA_FAST_FORWARD");
        names.append(KEYCODE_MUTE, "KEYCODE_MUTE");
        names.append(KEYCODE_PAGE_UP, "KEYCODE_PAGE_UP");
        names.append(KEYCODE_PAGE_DOWN, "KEYCODE_PAGE_DOWN");
        names.append(KEYCODE_PICTSYMBOLS, "KEYCODE_PICTSYMBOLS");
        names.append(KEYCODE_SWITCH_CHARSET, "KEYCODE_SWITCH_CHARSET");
        names.append(KEYCODE_BUTTON_A, "KEYCODE_BUTTON_A");
        names.append(KEYCODE_BUTTON_B, "KEYCODE_BUTTON_B");
        names.append(KEYCODE_BUTTON_C, "KEYCODE_BUTTON_C");
        names.append(KEYCODE_BUTTON_X, "KEYCODE_BUTTON_X");
        names.append(KEYCODE_BUTTON_Y, "KEYCODE_BUTTON_Y");
        names.append(KEYCODE_BUTTON_Z, "KEYCODE_BUTTON_Z");
        names.append(KEYCODE_BUTTON_L1, "KEYCODE_BUTTON_L1");
        names.append(KEYCODE_BUTTON_R1, "KEYCODE_BUTTON_R1");
        names.append(KEYCODE_BUTTON_L2, "KEYCODE_BUTTON_L2");
        names.append(KEYCODE_BUTTON_R2, "KEYCODE_BUTTON_R2");
        names.append(KEYCODE_BUTTON_THUMBL, "KEYCODE_BUTTON_THUMBL");
        names.append(KEYCODE_BUTTON_THUMBR, "KEYCODE_BUTTON_THUMBR");
        names.append(KEYCODE_BUTTON_START, "KEYCODE_BUTTON_START");
        names.append(KEYCODE_BUTTON_SELECT, "KEYCODE_BUTTON_SELECT");
        names.append(KEYCODE_BUTTON_MODE, "KEYCODE_BUTTON_MODE");
        names.append(KEYCODE_ESCAPE, "KEYCODE_ESCAPE");
        names.append(KEYCODE_FORWARD_DEL, "KEYCODE_FORWARD_DEL");
        names.append(KEYCODE_CTRL_LEFT, "KEYCODE_CTRL_LEFT");
        names.append(KEYCODE_CTRL_RIGHT, "KEYCODE_CTRL_RIGHT");
        names.append(KEYCODE_CAPS_LOCK, "KEYCODE_CAPS_LOCK");
        names.append(KEYCODE_SCROLL_LOCK, "KEYCODE_SCROLL_LOCK");
        names.append(KEYCODE_META_LEFT, "KEYCODE_META_LEFT");
        names.append(KEYCODE_META_RIGHT, "KEYCODE_META_RIGHT");
        names.append(KEYCODE_FUNCTION, "KEYCODE_FUNCTION");
        names.append(KEYCODE_SYSRQ, "KEYCODE_SYSRQ");
        names.append(KEYCODE_BREAK, "KEYCODE_BREAK");
        names.append(KEYCODE_MOVE_HOME, "KEYCODE_MOVE_HOME");
        names.append(KEYCODE_MOVE_END, "KEYCODE_MOVE_END");
        names.append(KEYCODE_INSERT, "KEYCODE_INSERT");
        names.append(KEYCODE_FORWARD, "KEYCODE_FORWARD");
        names.append(KEYCODE_MEDIA_PLAY, "KEYCODE_MEDIA_PLAY");
        names.append(KEYCODE_MEDIA_PAUSE, "KEYCODE_MEDIA_PAUSE");
        names.append(KEYCODE_MEDIA_CLOSE, "KEYCODE_MEDIA_CLOSE");
        names.append(KEYCODE_MEDIA_EJECT, "KEYCODE_MEDIA_EJECT");
        names.append(KEYCODE_MEDIA_RECORD, "KEYCODE_MEDIA_RECORD");
        names.append(KEYCODE_F1, "KEYCODE_F1");
        names.append(KEYCODE_F2, "KEYCODE_F2");
        names.append(KEYCODE_F3, "KEYCODE_F3");
        names.append(KEYCODE_F4, "KEYCODE_F4");
        names.append(KEYCODE_F5, "KEYCODE_F5");
        names.append(KEYCODE_F6, "KEYCODE_F6");
        names.append(KEYCODE_F7, "KEYCODE_F7");
        names.append(KEYCODE_F8, "KEYCODE_F8");
        names.append(KEYCODE_F9, "KEYCODE_F9");
        names.append(KEYCODE_F10, "KEYCODE_F10");
        names.append(KEYCODE_F11, "KEYCODE_F11");
        names.append(KEYCODE_F12, "KEYCODE_F12");
        names.append(KEYCODE_NUM_LOCK, "KEYCODE_NUM_LOCK");
        names.append(KEYCODE_NUMPAD_0, "KEYCODE_NUMPAD_0");
        names.append(KEYCODE_NUMPAD_1, "KEYCODE_NUMPAD_1");
        names.append(KEYCODE_NUMPAD_2, "KEYCODE_NUMPAD_2");
        names.append(KEYCODE_NUMPAD_3, "KEYCODE_NUMPAD_3");
        names.append(KEYCODE_NUMPAD_4, "KEYCODE_NUMPAD_4");
        names.append(KEYCODE_NUMPAD_5, "KEYCODE_NUMPAD_5");
        names.append(KEYCODE_NUMPAD_6, "KEYCODE_NUMPAD_6");
        names.append(KEYCODE_NUMPAD_7, "KEYCODE_NUMPAD_7");
        names.append(KEYCODE_NUMPAD_8, "KEYCODE_NUMPAD_8");
        names.append(KEYCODE_NUMPAD_9, "KEYCODE_NUMPAD_9");
        names.append(KEYCODE_NUMPAD_DIVIDE, "KEYCODE_NUMPAD_DIVIDE");
        names.append(KEYCODE_NUMPAD_MULTIPLY, "KEYCODE_NUMPAD_MULTIPLY");
        names.append(KEYCODE_NUMPAD_SUBTRACT, "KEYCODE_NUMPAD_SUBTRACT");
        names.append(KEYCODE_NUMPAD_ADD, "KEYCODE_NUMPAD_ADD");
        names.append(KEYCODE_NUMPAD_DOT, "KEYCODE_NUMPAD_DOT");
        names.append(KEYCODE_NUMPAD_COMMA, "KEYCODE_NUMPAD_COMMA");
        names.append(KEYCODE_NUMPAD_ENTER, "KEYCODE_NUMPAD_ENTER");
        names.append(KEYCODE_NUMPAD_EQUALS, "KEYCODE_NUMPAD_EQUALS");
        names.append(KEYCODE_NUMPAD_LEFT_PAREN, "KEYCODE_NUMPAD_LEFT_PAREN");
        names.append(KEYCODE_NUMPAD_RIGHT_PAREN, "KEYCODE_NUMPAD_RIGHT_PAREN");
        names.append(KEYCODE_VOLUME_MUTE, "KEYCODE_VOLUME_MUTE");
        names.append(KEYCODE_INFO, "KEYCODE_INFO");
        names.append(KEYCODE_CHANNEL_UP, "KEYCODE_CHANNEL_UP");
        names.append(KEYCODE_CHANNEL_DOWN, "KEYCODE_CHANNEL_DOWN");
        names.append(KEYCODE_ZOOM_IN, "KEYCODE_ZOOM_IN");
        names.append(KEYCODE_ZOOM_OUT, "KEYCODE_ZOOM_OUT");
        names.append(KEYCODE_TV, "KEYCODE_TV");
        names.append(KEYCODE_WINDOW, "KEYCODE_WINDOW");
        names.append(KEYCODE_GUIDE, "KEYCODE_GUIDE");
        names.append(KEYCODE_DVR, "KEYCODE_DVR");
        names.append(KEYCODE_BOOKMARK, "KEYCODE_BOOKMARK");
        names.append(KEYCODE_CAPTIONS, "KEYCODE_CAPTIONS");
        names.append(KEYCODE_SETTINGS, "KEYCODE_SETTINGS");
        names.append(KEYCODE_TV_POWER, "KEYCODE_TV_POWER");
        names.append(KEYCODE_TV_INPUT, "KEYCODE_TV_INPUT");
        names.append(KEYCODE_STB_INPUT, "KEYCODE_STB_INPUT");
        names.append(KEYCODE_STB_POWER, "KEYCODE_STB_POWER");
        names.append(KEYCODE_AVR_POWER, "KEYCODE_AVR_POWER");
        names.append(KEYCODE_AVR_INPUT, "KEYCODE_AVR_INPUT");
        names.append(KEYCODE_PROG_RED, "KEYCODE_PROG_RED");
        names.append(KEYCODE_PROG_GREEN, "KEYCODE_PROG_GREEN");
        names.append(KEYCODE_PROG_YELLOW, "KEYCODE_PROG_YELLOW");
        names.append(KEYCODE_PROG_BLUE, "KEYCODE_PROG_BLUE");
        names.append(KEYCODE_APP_SWITCH, "KEYCODE_APP_SWITCH");
        names.append(KEYCODE_BUTTON_1, "KEYCODE_BUTTON_1");
        names.append(KEYCODE_BUTTON_2, "KEYCODE_BUTTON_2");
        names.append(KEYCODE_BUTTON_3, "KEYCODE_BUTTON_3");
        names.append(KEYCODE_BUTTON_4, "KEYCODE_BUTTON_4");
        names.append(KEYCODE_BUTTON_5, "KEYCODE_BUTTON_5");
        names.append(KEYCODE_BUTTON_6, "KEYCODE_BUTTON_6");
        names.append(KEYCODE_BUTTON_7, "KEYCODE_BUTTON_7");
        names.append(KEYCODE_BUTTON_8, "KEYCODE_BUTTON_8");
        names.append(KEYCODE_BUTTON_9, "KEYCODE_BUTTON_9");
        names.append(KEYCODE_BUTTON_10, "KEYCODE_BUTTON_10");
        names.append(KEYCODE_BUTTON_11, "KEYCODE_BUTTON_11");
        names.append(KEYCODE_BUTTON_12, "KEYCODE_BUTTON_12");
        names.append(KEYCODE_BUTTON_13, "KEYCODE_BUTTON_13");
        names.append(KEYCODE_BUTTON_14, "KEYCODE_BUTTON_14");
        names.append(KEYCODE_BUTTON_15, "KEYCODE_BUTTON_15");
        names.append(KEYCODE_BUTTON_16, "KEYCODE_BUTTON_16");
        names.append(KEYCODE_LANGUAGE_SWITCH, "KEYCODE_LANGUAGE_SWITCH");
        names.append(KEYCODE_MANNER_MODE, "KEYCODE_MANNER_MODE");
        names.append(KEYCODE_3D_MODE, "KEYCODE_3D_MODE");
        names.append(KEYCODE_CONTACTS, "KEYCODE_CONTACTS");
        names.append(KEYCODE_CALENDAR, "KEYCODE_CALENDAR");
        names.append(KEYCODE_MUSIC, "KEYCODE_MUSIC");
        names.append(KEYCODE_CALCULATOR, "KEYCODE_CALCULATOR");
    }

    
        public static int getMaxKeyCode() {
        return LAST_KEYCODE;
    }

    
        public static int getDeadChar(int accent, int c) {
        return KeyCharacterMap.getDeadChar(accent, c);
    }

    
        private static KeyEvent obtain() {
        final KeyEvent ev;
        synchronized (gRecyclerLock) {
            ev = gRecyclerTop;
            if (ev == null) {
                return new KeyEvent();
            }
            gRecyclerTop = ev.mNext;
            gRecyclerUsed -= 1;
        }
        ev.mRecycled = false;
        ev.mNext = null;
        return ev;
    }

    
        public static KeyEvent obtain(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode, int flags, int source, String characters) {
        KeyEvent ev = obtain();
        ev.mDownTime = downTime;
        ev.mEventTime = eventTime;
        ev.mAction = action;
        ev.mKeyCode = code;
        ev.mRepeatCount = repeat;
        ev.mMetaState = metaState;
        ev.mDeviceId = deviceId;
        ev.mScanCode = scancode;
        ev.mFlags = flags;
        ev.mSource = source;
        ev.mCharacters = characters;
        return ev;
    }

    
        public static KeyEvent obtain(KeyEvent other) {
        KeyEvent ev = obtain();
        ev.mDownTime = other.mDownTime;
        ev.mEventTime = other.mEventTime;
        ev.mAction = other.mAction;
        ev.mKeyCode = other.mKeyCode;
        ev.mRepeatCount = other.mRepeatCount;
        ev.mMetaState = other.mMetaState;
        ev.mDeviceId = other.mDeviceId;
        ev.mScanCode = other.mScanCode;
        ev.mFlags = other.mFlags;
        ev.mSource = other.mSource;
        ev.mCharacters = other.mCharacters;
        return ev;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.008 -0400", hash_original_method = "71F28D5E8589FEEEB25F09C6B26D40EA", hash_generated_method = "00A059F6FCF26E4ECAC808DC3B980ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public KeyEvent copy() {
        KeyEvent var3FF1A9B3CCF4C4B5A71D5E31BC77BEB8_751434913 = (obtain(this));
        return (KeyEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.009 -0400", hash_original_method = "6B64621545DE4A3A123816F2DEDFC8C2", hash_generated_method = "90A8807665A99578518572ED178F8D6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void recycle() {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!");
        } //End block
        mRecycled = true;
        mCharacters = null;
        {
            {
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mRecycled) {
            //throw new RuntimeException(toString() + " recycled twice!");
        //}
        //mRecycled = true;
        //mCharacters = null;
        //synchronized (gRecyclerLock) {
            //if (gRecyclerUsed < MAX_RECYCLED) {
                //gRecyclerUsed++;
                //mNext = gRecyclerTop;
                //gRecyclerTop = this;
            //}
        //}
    }

    
        public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime,
            int newRepeat) {
        return new KeyEvent(event, eventTime, newRepeat);
    }

    
        public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime,
            int newRepeat, int newFlags) {
        KeyEvent ret = new KeyEvent(event);
        ret.mEventTime = eventTime;
        ret.mRepeatCount = newRepeat;
        ret.mFlags = newFlags;
        return ret;
    }

    
        public static KeyEvent changeAction(KeyEvent event, int action) {
        return new KeyEvent(event, action);
    }

    
        public static KeyEvent changeFlags(KeyEvent event, int flags) {
        event = new KeyEvent(event);
        event.mFlags = flags;
        return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "F86D8C7B1180DE3A66C7F2BDF135A8B2", hash_generated_method = "F6C80180795FBEB483A77EF4967B4461")
    @DSModeled(DSC.SAFE)
    @Override
    public final boolean isTainted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags & FLAG_TAINTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "BF13334B6C13BDDF4754612AD733986A", hash_generated_method = "0E764F86881FAA7D37254BF460FA3931")
    @DSModeled(DSC.SAFE)
    @Override
    public final void setTainted(boolean tainted) {
        dsTaint.addTaint(tainted);
        mFlags = tainted ? mFlags | FLAG_TAINTED : mFlags & ~FLAG_TAINTED;
        // ---------- Original Method ----------
        //mFlags = tainted ? mFlags | FLAG_TAINTED : mFlags & ~FLAG_TAINTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "CB44DB443D68CB8A4DB0177D0C026F61", hash_generated_method = "75BE5C5984415138DFE94F42E6E19AB2")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final boolean isDown() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAction == ACTION_DOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "CAD37C193D4DCF9F544C4B94A265DB37", hash_generated_method = "A7BBFB9125E1DADA8C7F25D5897D8A3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isSystem() {
        boolean varE6AE4855DF83EA7EFECC7D1592082189_936050522 = (native_isSystemKey(mKeyCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_isSystemKey(mKeyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "FEBEE3014E41544B75A2E175FCF48721", hash_generated_method = "809983BA83C7FD50C2D274F00D1DFEE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasDefaultAction() {
        boolean var3700A8CA622BABEEE0834C3658EDA3E8_563571711 = (native_hasDefaultAction(mKeyCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return native_hasDefaultAction(mKeyCode);
    }

    
        public static final boolean isGamepadButton(int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BUTTON_A:
            case KeyEvent.KEYCODE_BUTTON_B:
            case KeyEvent.KEYCODE_BUTTON_C:
            case KeyEvent.KEYCODE_BUTTON_X:
            case KeyEvent.KEYCODE_BUTTON_Y:
            case KeyEvent.KEYCODE_BUTTON_Z:
            case KeyEvent.KEYCODE_BUTTON_L1:
            case KeyEvent.KEYCODE_BUTTON_R1:
            case KeyEvent.KEYCODE_BUTTON_L2:
            case KeyEvent.KEYCODE_BUTTON_R2:
            case KeyEvent.KEYCODE_BUTTON_THUMBL:
            case KeyEvent.KEYCODE_BUTTON_THUMBR:
            case KeyEvent.KEYCODE_BUTTON_START:
            case KeyEvent.KEYCODE_BUTTON_SELECT:
            case KeyEvent.KEYCODE_BUTTON_MODE:
            case KeyEvent.KEYCODE_BUTTON_1:
            case KeyEvent.KEYCODE_BUTTON_2:
            case KeyEvent.KEYCODE_BUTTON_3:
            case KeyEvent.KEYCODE_BUTTON_4:
            case KeyEvent.KEYCODE_BUTTON_5:
            case KeyEvent.KEYCODE_BUTTON_6:
            case KeyEvent.KEYCODE_BUTTON_7:
            case KeyEvent.KEYCODE_BUTTON_8:
            case KeyEvent.KEYCODE_BUTTON_9:
            case KeyEvent.KEYCODE_BUTTON_10:
            case KeyEvent.KEYCODE_BUTTON_11:
            case KeyEvent.KEYCODE_BUTTON_12:
            case KeyEvent.KEYCODE_BUTTON_13:
            case KeyEvent.KEYCODE_BUTTON_14:
            case KeyEvent.KEYCODE_BUTTON_15:
            case KeyEvent.KEYCODE_BUTTON_16:
                return true;
            default:
                return false;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.010 -0400", hash_original_method = "7BF185CA9C1C463FC99CEDE50E8D63D5", hash_generated_method = "D6A1B9D8A41BADABD620F00423A0A146")
    @DSModeled(DSC.SAFE)
    @Override
    public final int getDeviceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDeviceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.011 -0400", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "8F92C4A48FFC014CE9E8EE4550060300")
    @DSModeled(DSC.SAFE)
    @Override
    public final int getSource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.011 -0400", hash_original_method = "38516F33934E20A73DA8FE7BA747BA99", hash_generated_method = "F4FD9C45ECD80A11438F696180BE8BFB")
    @DSModeled(DSC.SAFE)
    @Override
    public final void setSource(int source) {
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
        //mSource = source;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.011 -0400", hash_original_method = "8A0F7162152E6ECED85F47A14B4B5FFC", hash_generated_method = "92289BBD5327C03F4C4D61123862F2B2")
    @DSModeled(DSC.SAFE)
    public final int getMetaState() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMetaState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.011 -0400", hash_original_method = "B496E7302AF88C4E63C665D5FB521FB2", hash_generated_method = "4F4B15B190BB04EFDDE95A8081B5D910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getModifiers() {
        int varBE1D060D57A6403B56DE9C919712B4F7_2066699873 = (normalizeMetaState(mMetaState) & META_MODIFIER_MASK);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return normalizeMetaState(mMetaState) & META_MODIFIER_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.011 -0400", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "A3C3000384E74AFAEE5FD003584A7020")
    @DSModeled(DSC.SAFE)
    public final int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFlags;
    }

    
        public static int getModifierMetaStateMask() {
        return META_MODIFIER_MASK;
    }

    
        public static boolean isModifierKey(int keyCode) {
        switch (keyCode) {
            case KEYCODE_SHIFT_LEFT:
            case KEYCODE_SHIFT_RIGHT:
            case KEYCODE_ALT_LEFT:
            case KEYCODE_ALT_RIGHT:
            case KEYCODE_CTRL_LEFT:
            case KEYCODE_CTRL_RIGHT:
            case KEYCODE_META_LEFT:
            case KEYCODE_META_RIGHT:
            case KEYCODE_SYM:
            case KEYCODE_NUM:
            case KEYCODE_FUNCTION:
                return true;
            default:
                return false;
        }
    }

    
        public static int normalizeMetaState(int metaState) {
        if ((metaState & (META_SHIFT_LEFT_ON | META_SHIFT_RIGHT_ON)) != 0) {
            metaState |= META_SHIFT_ON;
        }
        if ((metaState & (META_ALT_LEFT_ON | META_ALT_RIGHT_ON)) != 0) {
            metaState |= META_ALT_ON;
        }
        if ((metaState & (META_CTRL_LEFT_ON | META_CTRL_RIGHT_ON)) != 0) {
            metaState |= META_CTRL_ON;
        }
        if ((metaState & (META_META_LEFT_ON | META_META_RIGHT_ON)) != 0) {
            metaState |= META_META_ON;
        }
        if ((metaState & MetaKeyKeyListener.META_CAP_LOCKED) != 0) {
            metaState |= META_CAPS_LOCK_ON;
        }
        if ((metaState & MetaKeyKeyListener.META_ALT_LOCKED) != 0) {
            metaState |= META_ALT_ON;
        }
        if ((metaState & MetaKeyKeyListener.META_SYM_LOCKED) != 0) {
            metaState |= META_SYM_ON;
        }
        return metaState & META_ALL_MASK;
    }

    
        public static boolean metaStateHasNoModifiers(int metaState) {
        return (normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0;
    }

    
        public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        if ((modifiers & META_INVALID_MODIFIER_MASK) != 0) {
            throw new IllegalArgumentException("modifiers must not contain "
                    + "META_CAPS_LOCK_ON, META_NUM_LOCK_ON, META_SCROLL_LOCK_ON, "
                    + "META_CAP_LOCKED, META_ALT_LOCKED, META_SYM_LOCKED, "
                    + "or META_SELECTING");
        }
        metaState = normalizeMetaState(metaState) & META_MODIFIER_MASK;
        metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                META_SHIFT_ON, META_SHIFT_LEFT_ON, META_SHIFT_RIGHT_ON);
        metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                META_ALT_ON, META_ALT_LEFT_ON, META_ALT_RIGHT_ON);
        metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                META_CTRL_ON, META_CTRL_LEFT_ON, META_CTRL_RIGHT_ON);
        metaState = metaStateFilterDirectionalModifiers(metaState, modifiers,
                META_META_ON, META_META_LEFT_ON, META_META_RIGHT_ON);
        return metaState == modifiers;
    }

    
        private static int metaStateFilterDirectionalModifiers(int metaState,
            int modifiers, int basic, int left, int right) {
        final boolean wantBasic = (modifiers & basic) != 0;
        final int directional = left | right;
        final boolean wantLeftOrRight = (modifiers & directional) != 0;
        if (wantBasic) {
            if (wantLeftOrRight) {
                throw new IllegalArgumentException("modifiers must not contain "
                        + metaStateToString(basic) + " combined with "
                        + metaStateToString(left) + " or " + metaStateToString(right));
            }
            return metaState & ~directional;
        } else if (wantLeftOrRight) {
            return metaState & ~basic;
        } else {
            return metaState;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.012 -0400", hash_original_method = "D8034B11074E9047AA16AF8491DBD005", hash_generated_method = "579E76D1AB459BAB7723B1FDBB20D3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasNoModifiers() {
        boolean var2EA5825E3B6BAF4D435678EE4FA290B6_358770688 = (metaStateHasNoModifiers(mMetaState));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return metaStateHasNoModifiers(mMetaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.012 -0400", hash_original_method = "4E7169ABB8BE0091A9032E5C93093788", hash_generated_method = "FA3C7C1A6DEEE412B6AAD0B22DA68412")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasModifiers(int modifiers) {
        dsTaint.addTaint(modifiers);
        boolean var648F7A9F0962E8E4161828F1E8BA6E46_1758002090 = (metaStateHasModifiers(mMetaState, modifiers));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return metaStateHasModifiers(mMetaState, modifiers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "97586FBB5F886A3B61BF136A6C082407", hash_generated_method = "5E4DE093A9C636BD1F61E095CE03B8B8")
    @DSModeled(DSC.SAFE)
    public final boolean isAltPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_ALT_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "CCAFE012B2273AEF4F41D4D6D0D204B5", hash_generated_method = "A791CD6B268DB05FE6CD9D5C1401C0DC")
    @DSModeled(DSC.SAFE)
    public final boolean isShiftPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_SHIFT_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "FD9A49039B892920252DA37B3D678A2D", hash_generated_method = "BD34C6213E495BB3D70ED3AE28F8C0D4")
    @DSModeled(DSC.SAFE)
    public final boolean isSymPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_SYM_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "3C82500C516E1BE610D84AED68B433EB", hash_generated_method = "89A52D48E6480A60B654469F4CDB83D3")
    @DSModeled(DSC.SAFE)
    public final boolean isCtrlPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_CTRL_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "465B8FC61E3DBB23D441220EDBBD9D13", hash_generated_method = "3BCCFA951D66085FCFA6D6C9D90E6E34")
    @DSModeled(DSC.SAFE)
    public final boolean isMetaPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_META_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.013 -0400", hash_original_method = "86852117C33E9887622BE81AA6AFA717", hash_generated_method = "1EDAD3380D9A51BA97E3577295CFD566")
    @DSModeled(DSC.SAFE)
    public final boolean isFunctionPressed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_FUNCTION_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "201DC9EDE3268FF70DC9BB453F3746A4", hash_generated_method = "8C50E9230A50E347D3396649A1344409")
    @DSModeled(DSC.SAFE)
    public final boolean isCapsLockOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_CAPS_LOCK_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "F23D7F96DFD52760380CADC49A40315B", hash_generated_method = "ADB1B5B6D7DE37AC112247274429DB1C")
    @DSModeled(DSC.SAFE)
    public final boolean isNumLockOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_NUM_LOCK_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "F7BF6BCE6DBC769F104CFC5352A06C66", hash_generated_method = "674FAAA19AF5F890E3E11E2F28DA0312")
    @DSModeled(DSC.SAFE)
    public final boolean isScrollLockOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mMetaState & META_SCROLL_LOCK_ON) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "C7B83CF54D36DAE78A8BAAE43AC68F85")
    @DSModeled(DSC.SAFE)
    public final int getAction() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "67F2F19B4B996A0666B0A05E347C8968", hash_generated_method = "B1441E0D1F5DEF4FFFBE0CCB52203234")
    @DSModeled(DSC.SAFE)
    public final boolean isCanceled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags&FLAG_CANCELED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "27796C2FEC9179970B535474C3BFAAB9", hash_generated_method = "2EE0466AB5C2F2727C33F7700B8007CE")
    @DSModeled(DSC.SAFE)
    public final void startTracking() {
        mFlags |= FLAG_START_TRACKING;
        // ---------- Original Method ----------
        //mFlags |= FLAG_START_TRACKING;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.014 -0400", hash_original_method = "D30D10CBEE1B4F7DBBD65FEDA5F644C1", hash_generated_method = "C6366175C68F65D392873D77DCD3D414")
    @DSModeled(DSC.SAFE)
    public final boolean isTracking() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags&FLAG_TRACKING) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.015 -0400", hash_original_method = "AC7740C0A8B7B97C4388CB1808E16854", hash_generated_method = "5B96DF77126289ADD01DA82AEA056140")
    @DSModeled(DSC.SAFE)
    public final boolean isLongPress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mFlags&FLAG_LONG_PRESS) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.015 -0400", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "185F66065DD35BD0A475357C78CE283D")
    @DSModeled(DSC.SAFE)
    public final int getKeyCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mKeyCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.015 -0400", hash_original_method = "E7E0F27294714D41CE9B0DB8FACE7352", hash_generated_method = "05A9F680D9ED722C307E65940164D9F0")
    @DSModeled(DSC.SAFE)
    public final String getCharacters() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCharacters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.015 -0400", hash_original_method = "C59C82C828E55FB1935E12A0581D4304", hash_generated_method = "566E1E82D4794E78748B1946FF209A2F")
    @DSModeled(DSC.SAFE)
    public final int getScanCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScanCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.015 -0400", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "DB22FCD87CC62A9D96E8FEF2FE06D8B5")
    @DSModeled(DSC.SAFE)
    public final int getRepeatCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mRepeatCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.016 -0400", hash_original_method = "78B33B0396971A0CFD2DA3075372AEE4", hash_generated_method = "E04309FB2BF698C6157375A17AF4E188")
    @DSModeled(DSC.SAFE)
    public final long getDownTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDownTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.016 -0400", hash_original_method = "9909149D86C7172035BFD4D31C880F99", hash_generated_method = "33846E75308D6DF8A5983E67CBB1395F")
    @DSModeled(DSC.SAFE)
    public final long getEventTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mEventTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.016 -0400", hash_original_method = "E19EE848225D9E04BF4931E6C8BABFAF", hash_generated_method = "026E070DCA0F7DBBACD7851A46CC3FFA")
    @DSModeled(DSC.SAFE)
    @Override
    public final long getEventTimeNano() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mEventTime * 1000000L;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.016 -0400", hash_original_method = "DAE3D173E797B2BC058CC137FF578309", hash_generated_method = "9056A3DDE008D1F2CE3136148500F831")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final int getKeyboardDevice() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDeviceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.016 -0400", hash_original_method = "E25038BBE92ACBB5F3F6678AD9978C07", hash_generated_method = "860678ACE86E19F37180C15DEF286A9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final KeyCharacterMap getKeyCharacterMap() {
        KeyCharacterMap varBC0AD1CB5BEA5213ACCA573EB70C7169_932136155 = (KeyCharacterMap.load(mDeviceId));
        return (KeyCharacterMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return KeyCharacterMap.load(mDeviceId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.017 -0400", hash_original_method = "709AF61B9CAC868190EE8F0D7699E677", hash_generated_method = "2CC9677C65D05F4878AD71E7E1829A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getDisplayLabel() {
        char var402815CACAA9DDFAEFEDC0C125FB2994_215376646 = (getKeyCharacterMap().getDisplayLabel(mKeyCode));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().getDisplayLabel(mKeyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.017 -0400", hash_original_method = "057CF77E1E85F6DA27F89D2E60B0B1BA", hash_generated_method = "546F69E1A30876E9E3262086803FFBE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getUnicodeChar() {
        int var1A789D027C8A5A0C16264D8FE1C23A29_178305222 = (getUnicodeChar(mMetaState));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getUnicodeChar(mMetaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.017 -0400", hash_original_method = "BE11FB783D347EE88A5E4A6075D1C256", hash_generated_method = "C96689D6959D1148C6796FE7240022C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getUnicodeChar(int metaState) {
        dsTaint.addTaint(metaState);
        int varF80F7315F1665EF264F4B56CCC263B71_1918882190 = (getKeyCharacterMap().get(mKeyCode, metaState));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().get(mKeyCode, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.017 -0400", hash_original_method = "81320F663D2FF6F236DC3275D51EA69E", hash_generated_method = "4F79BBE20DEA410E3101B7E5E46D5F1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean getKeyData(KeyData results) {
        dsTaint.addTaint(results.dsTaint);
        boolean var9311F07A06D0009CABF0BB59BF9F1F37_446715912 = (getKeyCharacterMap().getKeyData(mKeyCode, results));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().getKeyData(mKeyCode, results);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.017 -0400", hash_original_method = "BA318507FAF878809BC342F154CE9211", hash_generated_method = "A40331EF9AFB57992B76623A87975445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getMatch(char[] chars) {
        dsTaint.addTaint(chars[0]);
        char varB7872EAEFF997D9A111291989861AD62_634064406 = (getMatch(chars, 0));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getMatch(chars, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.018 -0400", hash_original_method = "37D22A361AC08A8D1E1BFBF631093A43", hash_generated_method = "8799F41D47D8E1B11AEC83B9B9B10F9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getMatch(char[] chars, int metaState) {
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(chars[0]);
        char varB61CD108FAACC946B9AA0DE89FD2060B_2076046495 = (getKeyCharacterMap().getMatch(mKeyCode, chars, metaState));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().getMatch(mKeyCode, chars, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.018 -0400", hash_original_method = "8EE0DA8E3FFF6281CC8C4E46B5174FE9", hash_generated_method = "1B9240E4C9C03E4E35B873682F98DE3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getNumber() {
        char varB4F648281DAF3DD70FE46CEDEBEDC863_112665892 = (getKeyCharacterMap().getNumber(mKeyCode));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().getNumber(mKeyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.018 -0400", hash_original_method = "FD8BA26A71313E51F3A862B0A656FF64", hash_generated_method = "9F2C312E3B375BF08B00A1AAECC94C1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrintingKey() {
        boolean varF8D3C8E19AA06F294286F3275CCB7518_2004803271 = (getKeyCharacterMap().isPrintingKey(mKeyCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getKeyCharacterMap().isPrintingKey(mKeyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.018 -0400", hash_original_method = "1A3310CD4FC6031A54E66A6FF268F76E", hash_generated_method = "C6672594233FB000624E95A519F3D33B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final boolean dispatch(Callback receiver) {
        dsTaint.addTaint(receiver.dsTaint);
        boolean varC90D4E641E4ACDB8930DA9EB1973CAAD_356650280 = (dispatch(receiver, null, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return dispatch(receiver, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.019 -0400", hash_original_method = "486AD389F69CA9E805DF428CF28467C4", hash_generated_method = "AF4A06817EA5626262A8935BA2337CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean dispatch(Callback receiver, DispatcherState state,
            Object target) {
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(target.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        //Begin case ACTION_DOWN 
        {
            mFlags &= ~FLAG_START_TRACKING;
            boolean res;
            res = receiver.onKeyDown(mKeyCode, this);
            {
                {
                    state.startTracking(this, target);
                } //End block
                {
                    boolean var15107DBA9F13C4EA3AFAF1BF65D7423F_930110898 = (isLongPress() && state.isTracking(this));
                    {
                        try 
                        {
                            {
                                boolean varEA4A626A3C3882CC4284F222EB564648_908661321 = (receiver.onKeyLongPress(mKeyCode, this));
                                {
                                    state.performedLongPress(this);
                                    res = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        catch (AbstractMethodError e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        //End case ACTION_DOWN 
        //Begin case ACTION_UP 
        {
            state.handleUpEvent(this);
        } //End block
        //End case ACTION_UP 
        //Begin case ACTION_UP 
        boolean var6AE796001B04D3F5946E38C8232FB430_1492916082 = (receiver.onKeyUp(mKeyCode, this));
        //End case ACTION_UP 
        //Begin case ACTION_MULTIPLE 
        int count;
        count = mRepeatCount;
        //End case ACTION_MULTIPLE 
        //Begin case ACTION_MULTIPLE 
        int code;
        code = mKeyCode;
        //End case ACTION_MULTIPLE 
        //Begin case ACTION_MULTIPLE 
        {
            boolean varCD86412E58971559452CF2B6E9A652F6_1476324172 = (receiver.onKeyMultiple(code, count, this));
        } //End collapsed parenthetic
        //End case ACTION_MULTIPLE 
        //Begin case ACTION_MULTIPLE 
        {
            mAction = ACTION_DOWN;
            mRepeatCount = 0;
            boolean handled;
            handled = receiver.onKeyDown(code, this);
            {
                mAction = ACTION_UP;
                receiver.onKeyUp(code, this);
            } //End block
            mAction = ACTION_MULTIPLE;
            mRepeatCount = count;
        } //End block
        //End case ACTION_MULTIPLE 
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.020 -0400", hash_original_method = "EC719782A5F2654811BE56A8456234B4", hash_generated_method = "48F23E54CED6BFA13A4A089C0020A3FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder msg;
        msg = new StringBuilder();
        msg.append("KeyEvent { action=").append(actionToString(mAction));
        msg.append(", keyCode=").append(keyCodeToString(mKeyCode));
        msg.append(", scanCode=").append(mScanCode);
        {
            msg.append(", characters=\"").append(mCharacters).append("\"");
        } //End block
        msg.append(", metaState=").append(metaStateToString(mMetaState));
        msg.append(", flags=0x").append(Integer.toHexString(mFlags));
        msg.append(", repeatCount=").append(mRepeatCount);
        msg.append(", eventTime=").append(mEventTime);
        msg.append(", downTime=").append(mDownTime);
        msg.append(", deviceId=").append(mDeviceId);
        msg.append(", source=0x").append(Integer.toHexString(mSource));
        msg.append(" }");
        String varDF7768E9135E0359312ABB41620E333A_1476348791 = (msg.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static String actionToString(int action) {
        switch (action) {
            case ACTION_DOWN:
                return "ACTION_DOWN";
            case ACTION_UP:
                return "ACTION_UP";
            case ACTION_MULTIPLE:
                return "ACTION_MULTIPLE";
            default:
                return Integer.toString(action);
        }
    }

    
        public static String keyCodeToString(int keyCode) {
        String symbolicName = KEYCODE_SYMBOLIC_NAMES.get(keyCode);
        return symbolicName != null ? symbolicName : Integer.toString(keyCode);
    }

    
        public static int keyCodeFromString(String symbolicName) {
        if (symbolicName == null) {
            throw new IllegalArgumentException("symbolicName must not be null");
        }
        final int count = KEYCODE_SYMBOLIC_NAMES.size();
        for (int i = 0; i < count; i++) {
            if (symbolicName.equals(KEYCODE_SYMBOLIC_NAMES.valueAt(i))) {
                return i;
            }
        }
        try {
            return Integer.parseInt(symbolicName, 10);
        } catch (NumberFormatException ex) {
            return KEYCODE_UNKNOWN;
        }
    }

    
        public static String metaStateToString(int metaState) {
        if (metaState == 0) {
            return "0";
        }
        StringBuilder result = null;
        int i = 0;
        while (metaState != 0) {
            final boolean isSet = (metaState & 1) != 0;
            metaState >>>= 1; 
            if (isSet) {
                final String name = META_SYMBOLIC_NAMES[i];
                if (result == null) {
                    if (metaState == 0) {
                        return name;
                    }
                    result = new StringBuilder(name);
                } else {
                    result.append('|');
                    result.append(name);
                }
            }
            i += 1;
        }
        return result.toString();
    }

    
        public static KeyEvent createFromParcelBody(Parcel in) {
        return new KeyEvent(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.021 -0400", hash_original_method = "12273F2E4594D26AD686DE1D2B663F84", hash_generated_method = "134C89B31FFCB4751733C1E31D4D44A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeInt(PARCEL_TOKEN_KEY_EVENT);
        out.writeInt(mDeviceId);
        out.writeInt(mSource);
        out.writeInt(mAction);
        out.writeInt(mKeyCode);
        out.writeInt(mRepeatCount);
        out.writeInt(mMetaState);
        out.writeInt(mScanCode);
        out.writeInt(mFlags);
        out.writeLong(mDownTime);
        out.writeLong(mEventTime);
        // ---------- Original Method ----------
        //out.writeInt(PARCEL_TOKEN_KEY_EVENT);
        //out.writeInt(mDeviceId);
        //out.writeInt(mSource);
        //out.writeInt(mAction);
        //out.writeInt(mKeyCode);
        //out.writeInt(mRepeatCount);
        //out.writeInt(mMetaState);
        //out.writeInt(mScanCode);
        //out.writeInt(mFlags);
        //out.writeLong(mDownTime);
        //out.writeLong(mEventTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.021 -0400", hash_original_method = "7ECA2477AC40357C7C5AFE00DC4BDA17", hash_generated_method = "6F0CD49E2C664D249C6940DEE4784794")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_isSystemKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.021 -0400", hash_original_method = "B29C954784C1F1FDE17D757BB04FDB3D", hash_generated_method = "CF3514AFA4B4A3478768A918401F1A2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean native_hasDefaultAction(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
    }

    
    public static class DispatcherState {
        int mDownKeyCode;
        Object mDownTarget;
        SparseIntArray mActiveLongPresses = new SparseIntArray();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.022 -0400", hash_original_method = "FDE2D25AD2D5154643209A1E07AB0DAA", hash_generated_method = "FDE2D25AD2D5154643209A1E07AB0DAA")
                public DispatcherState ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.022 -0400", hash_original_method = "554562900865028A00C4676EE39BA2E0", hash_generated_method = "CDE218CCBC4461C402BEA9142A3F1C83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void reset() {
            mDownKeyCode = 0;
            mDownTarget = null;
            mActiveLongPresses.clear();
            // ---------- Original Method ----------
            //if (DEBUG) Log.v(TAG, "Reset: " + this);
            //mDownKeyCode = 0;
            //mDownTarget = null;
            //mActiveLongPresses.clear();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.022 -0400", hash_original_method = "7A446B7A655E4D7578F3AEB4F96BA0A4", hash_generated_method = "1B48988EF1EAFF933FD47066F160F8C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void reset(Object target) {
            dsTaint.addTaint(target.dsTaint);
            {
                mDownKeyCode = 0;
                mDownTarget = null;
            } //End block
            // ---------- Original Method ----------
            //if (mDownTarget == target) {
                //if (DEBUG) Log.v(TAG, "Reset in " + target + ": " + this);
                //mDownKeyCode = 0;
                //mDownTarget = null;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.022 -0400", hash_original_method = "F359109F6941FCC4380DDA2E2CA9E676", hash_generated_method = "9EBCF39CCA7B5DF6D95C695006581C58")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void startTracking(KeyEvent event, Object target) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(target.dsTaint);
            {
                boolean varEFF761F3EEED65C62FBA77AF5B033178_539200379 = (event.getAction() != ACTION_DOWN);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "Can only start tracking on a down event");
                } //End block
            } //End collapsed parenthetic
            mDownKeyCode = event.getKeyCode();
            // ---------- Original Method ----------
            //if (event.getAction() != ACTION_DOWN) {
                //throw new IllegalArgumentException(
                        //"Can only start tracking on a down event");
            //}
            //if (DEBUG) Log.v(TAG, "Start trackingt in " + target + ": " + this);
            //mDownKeyCode = event.getKeyCode();
            //mDownTarget = target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.023 -0400", hash_original_method = "07F4929E2B3E025FC2215EF8E614ABBF", hash_generated_method = "2BB3146C87DB9844E2E6F49F374FCCA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isTracking(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            boolean var296CB63EF97B12631998C71582F3F238_1888473677 = (mDownKeyCode == event.getKeyCode());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mDownKeyCode == event.getKeyCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.023 -0400", hash_original_method = "2266BAE243819DE7EACEEEA38A1E3CF0", hash_generated_method = "F3CB62A657A671E1FEF2DA77377C545C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void performedLongPress(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            mActiveLongPresses.put(event.getKeyCode(), 1);
            // ---------- Original Method ----------
            //mActiveLongPresses.put(event.getKeyCode(), 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.023 -0400", hash_original_method = "4EC5A9A4246B9BB19D03F0E0F2DEA552", hash_generated_method = "AAFAB82A7A798BDE3AF3F20CDC86C52F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleUpEvent(KeyEvent event) {
            dsTaint.addTaint(event.dsTaint);
            int keyCode;
            keyCode = event.getKeyCode();
            int index;
            index = mActiveLongPresses.indexOfKey(keyCode);
            {
                event.mFlags |= FLAG_CANCELED | FLAG_CANCELED_LONG_PRESS;
                mActiveLongPresses.removeAt(index);
            } //End block
            {
                event.mFlags |= FLAG_TRACKING;
                mDownKeyCode = 0;
                mDownTarget = null;
            } //End block
            // ---------- Original Method ----------
            //final int keyCode = event.getKeyCode();
            //if (DEBUG) Log.v(TAG, "Handle key up " + event + ": " + this);
            //int index = mActiveLongPresses.indexOfKey(keyCode);
            //if (index >= 0) {
                //if (DEBUG) Log.v(TAG, "  Index: " + index);
                //event.mFlags |= FLAG_CANCELED | FLAG_CANCELED_LONG_PRESS;
                //mActiveLongPresses.removeAt(index);
            //}
            //if (mDownKeyCode == keyCode) {
                //if (DEBUG) Log.v(TAG, "  Tracking!");
                //event.mFlags |= FLAG_TRACKING;
                //mDownKeyCode = 0;
                //mDownTarget = null;
            //}
        }

        
    }


    
    public interface Callback {
        
        boolean onKeyDown(int keyCode, KeyEvent event);

        
        boolean onKeyLongPress(int keyCode, KeyEvent event);

        
        boolean onKeyUp(int keyCode, KeyEvent event);

        
        boolean onKeyMultiple(int keyCode, int count, KeyEvent event);
    }
    
    public static final int KEYCODE_UNKNOWN         = 0;
    public static final int KEYCODE_SOFT_LEFT       = 1;
    public static final int KEYCODE_SOFT_RIGHT      = 2;
    public static final int KEYCODE_HOME            = 3;
    public static final int KEYCODE_BACK            = 4;
    public static final int KEYCODE_CALL            = 5;
    public static final int KEYCODE_ENDCALL         = 6;
    public static final int KEYCODE_0               = 7;
    public static final int KEYCODE_1               = 8;
    public static final int KEYCODE_2               = 9;
    public static final int KEYCODE_3               = 10;
    public static final int KEYCODE_4               = 11;
    public static final int KEYCODE_5               = 12;
    public static final int KEYCODE_6               = 13;
    public static final int KEYCODE_7               = 14;
    public static final int KEYCODE_8               = 15;
    public static final int KEYCODE_9               = 16;
    public static final int KEYCODE_STAR            = 17;
    public static final int KEYCODE_POUND           = 18;
    public static final int KEYCODE_DPAD_UP         = 19;
    public static final int KEYCODE_DPAD_DOWN       = 20;
    public static final int KEYCODE_DPAD_LEFT       = 21;
    public static final int KEYCODE_DPAD_RIGHT      = 22;
    public static final int KEYCODE_DPAD_CENTER     = 23;
    public static final int KEYCODE_VOLUME_UP       = 24;
    public static final int KEYCODE_VOLUME_DOWN     = 25;
    public static final int KEYCODE_POWER           = 26;
    public static final int KEYCODE_CAMERA          = 27;
    public static final int KEYCODE_CLEAR           = 28;
    public static final int KEYCODE_A               = 29;
    public static final int KEYCODE_B               = 30;
    public static final int KEYCODE_C               = 31;
    public static final int KEYCODE_D               = 32;
    public static final int KEYCODE_E               = 33;
    public static final int KEYCODE_F               = 34;
    public static final int KEYCODE_G               = 35;
    public static final int KEYCODE_H               = 36;
    public static final int KEYCODE_I               = 37;
    public static final int KEYCODE_J               = 38;
    public static final int KEYCODE_K               = 39;
    public static final int KEYCODE_L               = 40;
    public static final int KEYCODE_M               = 41;
    public static final int KEYCODE_N               = 42;
    public static final int KEYCODE_O               = 43;
    public static final int KEYCODE_P               = 44;
    public static final int KEYCODE_Q               = 45;
    public static final int KEYCODE_R               = 46;
    public static final int KEYCODE_S               = 47;
    public static final int KEYCODE_T               = 48;
    public static final int KEYCODE_U               = 49;
    public static final int KEYCODE_V               = 50;
    public static final int KEYCODE_W               = 51;
    public static final int KEYCODE_X               = 52;
    public static final int KEYCODE_Y               = 53;
    public static final int KEYCODE_Z               = 54;
    public static final int KEYCODE_COMMA           = 55;
    public static final int KEYCODE_PERIOD          = 56;
    public static final int KEYCODE_ALT_LEFT        = 57;
    public static final int KEYCODE_ALT_RIGHT       = 58;
    public static final int KEYCODE_SHIFT_LEFT      = 59;
    public static final int KEYCODE_SHIFT_RIGHT     = 60;
    public static final int KEYCODE_TAB             = 61;
    public static final int KEYCODE_SPACE           = 62;
    public static final int KEYCODE_SYM             = 63;
    public static final int KEYCODE_EXPLORER        = 64;
    public static final int KEYCODE_ENVELOPE        = 65;
    public static final int KEYCODE_ENTER           = 66;
    public static final int KEYCODE_DEL             = 67;
    public static final int KEYCODE_GRAVE           = 68;
    public static final int KEYCODE_MINUS           = 69;
    public static final int KEYCODE_EQUALS          = 70;
    public static final int KEYCODE_LEFT_BRACKET    = 71;
    public static final int KEYCODE_RIGHT_BRACKET   = 72;
    public static final int KEYCODE_BACKSLASH       = 73;
    public static final int KEYCODE_SEMICOLON       = 74;
    public static final int KEYCODE_APOSTROPHE      = 75;
    public static final int KEYCODE_SLASH           = 76;
    public static final int KEYCODE_AT              = 77;
    public static final int KEYCODE_NUM             = 78;
    public static final int KEYCODE_HEADSETHOOK     = 79;
    public static final int KEYCODE_FOCUS           = 80;
    public static final int KEYCODE_PLUS            = 81;
    public static final int KEYCODE_MENU            = 82;
    public static final int KEYCODE_NOTIFICATION    = 83;
    public static final int KEYCODE_SEARCH          = 84;
    public static final int KEYCODE_MEDIA_PLAY_PAUSE= 85;
    public static final int KEYCODE_MEDIA_STOP      = 86;
    public static final int KEYCODE_MEDIA_NEXT      = 87;
    public static final int KEYCODE_MEDIA_PREVIOUS  = 88;
    public static final int KEYCODE_MEDIA_REWIND    = 89;
    public static final int KEYCODE_MEDIA_FAST_FORWARD = 90;
    public static final int KEYCODE_MUTE            = 91;
    public static final int KEYCODE_PAGE_UP         = 92;
    public static final int KEYCODE_PAGE_DOWN       = 93;
    public static final int KEYCODE_PICTSYMBOLS     = 94;
    public static final int KEYCODE_SWITCH_CHARSET  = 95;
    public static final int KEYCODE_BUTTON_A        = 96;
    public static final int KEYCODE_BUTTON_B        = 97;
    public static final int KEYCODE_BUTTON_C        = 98;
    public static final int KEYCODE_BUTTON_X        = 99;
    public static final int KEYCODE_BUTTON_Y        = 100;
    public static final int KEYCODE_BUTTON_Z        = 101;
    public static final int KEYCODE_BUTTON_L1       = 102;
    public static final int KEYCODE_BUTTON_R1       = 103;
    public static final int KEYCODE_BUTTON_L2       = 104;
    public static final int KEYCODE_BUTTON_R2       = 105;
    public static final int KEYCODE_BUTTON_THUMBL   = 106;
    public static final int KEYCODE_BUTTON_THUMBR   = 107;
    public static final int KEYCODE_BUTTON_START    = 108;
    public static final int KEYCODE_BUTTON_SELECT   = 109;
    public static final int KEYCODE_BUTTON_MODE     = 110;
    public static final int KEYCODE_ESCAPE          = 111;
    public static final int KEYCODE_FORWARD_DEL     = 112;
    public static final int KEYCODE_CTRL_LEFT       = 113;
    public static final int KEYCODE_CTRL_RIGHT      = 114;
    public static final int KEYCODE_CAPS_LOCK       = 115;
    public static final int KEYCODE_SCROLL_LOCK     = 116;
    public static final int KEYCODE_META_LEFT       = 117;
    public static final int KEYCODE_META_RIGHT      = 118;
    public static final int KEYCODE_FUNCTION        = 119;
    public static final int KEYCODE_SYSRQ           = 120;
    public static final int KEYCODE_BREAK           = 121;
    public static final int KEYCODE_MOVE_HOME       = 122;
    public static final int KEYCODE_MOVE_END        = 123;
    public static final int KEYCODE_INSERT          = 124;
    public static final int KEYCODE_FORWARD         = 125;
    public static final int KEYCODE_MEDIA_PLAY      = 126;
    public static final int KEYCODE_MEDIA_PAUSE     = 127;
    public static final int KEYCODE_MEDIA_CLOSE     = 128;
    public static final int KEYCODE_MEDIA_EJECT     = 129;
    public static final int KEYCODE_MEDIA_RECORD    = 130;
    public static final int KEYCODE_F1              = 131;
    public static final int KEYCODE_F2              = 132;
    public static final int KEYCODE_F3              = 133;
    public static final int KEYCODE_F4              = 134;
    public static final int KEYCODE_F5              = 135;
    public static final int KEYCODE_F6              = 136;
    public static final int KEYCODE_F7              = 137;
    public static final int KEYCODE_F8              = 138;
    public static final int KEYCODE_F9              = 139;
    public static final int KEYCODE_F10             = 140;
    public static final int KEYCODE_F11             = 141;
    public static final int KEYCODE_F12             = 142;
    public static final int KEYCODE_NUM_LOCK        = 143;
    public static final int KEYCODE_NUMPAD_0        = 144;
    public static final int KEYCODE_NUMPAD_1        = 145;
    public static final int KEYCODE_NUMPAD_2        = 146;
    public static final int KEYCODE_NUMPAD_3        = 147;
    public static final int KEYCODE_NUMPAD_4        = 148;
    public static final int KEYCODE_NUMPAD_5        = 149;
    public static final int KEYCODE_NUMPAD_6        = 150;
    public static final int KEYCODE_NUMPAD_7        = 151;
    public static final int KEYCODE_NUMPAD_8        = 152;
    public static final int KEYCODE_NUMPAD_9        = 153;
    public static final int KEYCODE_NUMPAD_DIVIDE   = 154;
    public static final int KEYCODE_NUMPAD_MULTIPLY = 155;
    public static final int KEYCODE_NUMPAD_SUBTRACT = 156;
    public static final int KEYCODE_NUMPAD_ADD      = 157;
    public static final int KEYCODE_NUMPAD_DOT      = 158;
    public static final int KEYCODE_NUMPAD_COMMA    = 159;
    public static final int KEYCODE_NUMPAD_ENTER    = 160;
    public static final int KEYCODE_NUMPAD_EQUALS   = 161;
    public static final int KEYCODE_NUMPAD_LEFT_PAREN = 162;
    public static final int KEYCODE_NUMPAD_RIGHT_PAREN = 163;
    public static final int KEYCODE_VOLUME_MUTE     = 164;
    public static final int KEYCODE_INFO            = 165;
    public static final int KEYCODE_CHANNEL_UP      = 166;
    public static final int KEYCODE_CHANNEL_DOWN    = 167;
    public static final int KEYCODE_ZOOM_IN         = 168;
    public static final int KEYCODE_ZOOM_OUT        = 169;
    public static final int KEYCODE_TV              = 170;
    public static final int KEYCODE_WINDOW          = 171;
    public static final int KEYCODE_GUIDE           = 172;
    public static final int KEYCODE_DVR             = 173;
    public static final int KEYCODE_BOOKMARK        = 174;
    public static final int KEYCODE_CAPTIONS        = 175;
    public static final int KEYCODE_SETTINGS        = 176;
    public static final int KEYCODE_TV_POWER        = 177;
    public static final int KEYCODE_TV_INPUT        = 178;
    public static final int KEYCODE_STB_POWER       = 179;
    public static final int KEYCODE_STB_INPUT       = 180;
    public static final int KEYCODE_AVR_POWER       = 181;
    public static final int KEYCODE_AVR_INPUT       = 182;
    public static final int KEYCODE_PROG_RED        = 183;
    public static final int KEYCODE_PROG_GREEN      = 184;
    public static final int KEYCODE_PROG_YELLOW     = 185;
    public static final int KEYCODE_PROG_BLUE       = 186;
    public static final int KEYCODE_APP_SWITCH      = 187;
    public static final int KEYCODE_BUTTON_1        = 188;
    public static final int KEYCODE_BUTTON_2        = 189;
    public static final int KEYCODE_BUTTON_3        = 190;
    public static final int KEYCODE_BUTTON_4        = 191;
    public static final int KEYCODE_BUTTON_5        = 192;
    public static final int KEYCODE_BUTTON_6        = 193;
    public static final int KEYCODE_BUTTON_7        = 194;
    public static final int KEYCODE_BUTTON_8        = 195;
    public static final int KEYCODE_BUTTON_9        = 196;
    public static final int KEYCODE_BUTTON_10       = 197;
    public static final int KEYCODE_BUTTON_11       = 198;
    public static final int KEYCODE_BUTTON_12       = 199;
    public static final int KEYCODE_BUTTON_13       = 200;
    public static final int KEYCODE_BUTTON_14       = 201;
    public static final int KEYCODE_BUTTON_15       = 202;
    public static final int KEYCODE_BUTTON_16       = 203;
    public static final int KEYCODE_LANGUAGE_SWITCH = 204;
    public static final int KEYCODE_MANNER_MODE     = 205;
    public static final int KEYCODE_3D_MODE         = 206;
    public static final int KEYCODE_CONTACTS        = 207;
    public static final int KEYCODE_CALENDAR        = 208;
    public static final int KEYCODE_MUSIC           = 209;
    public static final int KEYCODE_CALCULATOR      = 210;
    private static final int LAST_KEYCODE           = KEYCODE_CALCULATOR;
    private static final SparseArray<String> KEYCODE_SYMBOLIC_NAMES = new SparseArray<String>();
    private static final String[] META_SYMBOLIC_NAMES = new String[] {
        "META_SHIFT_ON",
        "META_ALT_ON",
        "META_SYM_ON",
        "META_FUNCTION_ON",
        "META_ALT_LEFT_ON",
        "META_ALT_RIGHT_ON",
        "META_SHIFT_LEFT_ON",
        "META_SHIFT_RIGHT_ON",
        "META_CAP_LOCKED",
        "META_ALT_LOCKED",
        "META_SYM_LOCKED",
        "0x00000800",
        "META_CTRL_ON",
        "META_CTRL_LEFT_ON",
        "META_CTRL_RIGHT_ON",
        "0x00008000",
        "META_META_ON",
        "META_META_LEFT_ON",
        "META_META_RIGHT_ON",
        "0x00080000",
        "META_CAPS_LOCK_ON",
        "META_NUM_LOCK_ON",
        "META_SCROLL_LOCK_ON",
        "0x00800000",
        "0x01000000",
        "0x02000000",
        "0x04000000",
        "0x08000000",
        "0x10000000",
        "0x20000000",
        "0x40000000",
        "0x80000000",
    };
    @Deprecated public static final int MAX_KEYCODE             = 84;
    public static final int ACTION_DOWN             = 0;
    public static final int ACTION_UP               = 1;
    public static final int ACTION_MULTIPLE         = 2;
    public static final int META_CAP_LOCKED = 0x100;
    public static final int META_ALT_LOCKED = 0x200;
    public static final int META_SYM_LOCKED = 0x400;
    public static final int META_SELECTING = 0x800;
    public static final int META_ALT_ON = 0x02;
    public static final int META_ALT_LEFT_ON = 0x10;
    public static final int META_ALT_RIGHT_ON = 0x20;
    public static final int META_SHIFT_ON = 0x1;
    public static final int META_SHIFT_LEFT_ON = 0x40;
    public static final int META_SHIFT_RIGHT_ON = 0x80;
    public static final int META_SYM_ON = 0x4;
    public static final int META_FUNCTION_ON = 0x8;
    public static final int META_CTRL_ON = 0x1000;
    public static final int META_CTRL_LEFT_ON = 0x2000;
    public static final int META_CTRL_RIGHT_ON = 0x4000;
    public static final int META_META_ON = 0x10000;
    public static final int META_META_LEFT_ON = 0x20000;
    public static final int META_META_RIGHT_ON = 0x40000;
    public static final int META_CAPS_LOCK_ON = 0x100000;
    public static final int META_NUM_LOCK_ON = 0x200000;
    public static final int META_SCROLL_LOCK_ON = 0x400000;
    public static final int META_SHIFT_MASK = META_SHIFT_ON
            | META_SHIFT_LEFT_ON | META_SHIFT_RIGHT_ON;
    public static final int META_ALT_MASK = META_ALT_ON
            | META_ALT_LEFT_ON | META_ALT_RIGHT_ON;
    public static final int META_CTRL_MASK = META_CTRL_ON
            | META_CTRL_LEFT_ON | META_CTRL_RIGHT_ON;
    public static final int META_META_MASK = META_META_ON
            | META_META_LEFT_ON | META_META_RIGHT_ON;
    public static final int FLAG_WOKE_HERE = 0x1;
    public static final int FLAG_SOFT_KEYBOARD = 0x2;
    public static final int FLAG_KEEP_TOUCH_MODE = 0x4;
    public static final int FLAG_FROM_SYSTEM = 0x8;
    public static final int FLAG_EDITOR_ACTION = 0x10;
    public static final int FLAG_CANCELED = 0x20;
    public static final int FLAG_VIRTUAL_HARD_KEY = 0x40;
    public static final int FLAG_LONG_PRESS = 0x80;
    public static final int FLAG_CANCELED_LONG_PRESS = 0x100;
    public static final int FLAG_TRACKING = 0x200;
    public static final int FLAG_FALLBACK = 0x400;
    public static final int FLAG_START_TRACKING = 0x40000000;
    public static final int FLAG_TAINTED = 0x80000000;
    static final boolean DEBUG = false;
    static final String TAG = "KeyEvent";
    private static final int MAX_RECYCLED = 10;
    private static final Object gRecyclerLock = new Object();
    private static int gRecyclerUsed;
    private static KeyEvent gRecyclerTop;
    static {
        populateKeycodeSymbolicNames();
    }
    
    private static final int META_MODIFIER_MASK =
            META_SHIFT_ON | META_SHIFT_LEFT_ON | META_SHIFT_RIGHT_ON
            | META_ALT_ON | META_ALT_LEFT_ON | META_ALT_RIGHT_ON
            | META_CTRL_ON | META_CTRL_LEFT_ON | META_CTRL_RIGHT_ON
            | META_META_ON | META_META_LEFT_ON | META_META_RIGHT_ON
            | META_SYM_ON | META_FUNCTION_ON;
    private static final int META_LOCK_MASK =
            META_CAPS_LOCK_ON | META_NUM_LOCK_ON | META_SCROLL_LOCK_ON;
    private static final int META_ALL_MASK = META_MODIFIER_MASK | META_LOCK_MASK;
    private static final int META_SYNTHETIC_MASK =
            META_CAP_LOCKED | META_ALT_LOCKED | META_SYM_LOCKED | META_SELECTING;
    private static final int META_INVALID_MODIFIER_MASK =
            META_LOCK_MASK | META_SYNTHETIC_MASK;
    public static final Parcelable.Creator<KeyEvent> CREATOR = new Parcelable.Creator<KeyEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.025 -0400", hash_original_method = "2DC2AF23C7704D73E5416E3B81DAA881", hash_generated_method = "F95E5C7043A88D495733542CB06F3A54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public KeyEvent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            in.readInt();
            KeyEvent var03AF82A7FA5057C19F378563FCB46039_1376370768 = (KeyEvent.createFromParcelBody(in));
            return (KeyEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //in.readInt();
            //return KeyEvent.createFromParcelBody(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:59.026 -0400", hash_original_method = "E80AF5B6F571FF175C6A1543B8645012", hash_generated_method = "209449A69A3303971B480FA60F76B81B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public KeyEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            KeyEvent[] var16A4FC268A4F3E2083930BBA8C342474_1042102916 = (new KeyEvent[size]);
            return (KeyEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new KeyEvent[size];
        }

        
}; //Transformed anonymous class
}

