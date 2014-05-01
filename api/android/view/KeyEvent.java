package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import java.util.Random;

import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.method.MetaKeyKeyListener;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyCharacterMap.KeyData;

public class KeyEvent extends InputEvent implements Parcelable {

    /*
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public static KeyEvent droidsafeObtainEvent() {
        Random rand = new Random();
        KeyEvent ev = new KeyEvent(rand.nextInt(), rand.nextInt(), rand.nextInt(),
                                   rand.nextInt(), rand.nextInt(), rand.nextInt());
        return ev;
    }
    */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.923 -0500", hash_original_method = "CD92FE183731A7A6D1227776EFB98684", hash_generated_method = "FF01DC7C6BA6162970DE0E4EE19F724E")
    @DSVerified 
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

    /**
     * Returns the maximum keycode.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.046 -0500", hash_original_method = "614589E01471857DE8F1E319B98003E1", hash_generated_method = "B92157AD6E2E8B05A5BC2AB788256A02")
    
public static int getMaxKeyCode() {
        return LAST_KEYCODE;
    }

    /**
     * Get the character that is produced by putting accent on the character
     * c.
     * For example, getDeadChar('`', 'e') returns &egrave;.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.049 -0500", hash_original_method = "C83D831A5A9EB8B736462C632F518B23", hash_generated_method = "C0DFA835834F4A22A1CC7288085B7FC6")
    
public static int getDeadChar(int accent, int c) {
        return KeyCharacterMap.getDeadChar(accent, c);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.132 -0500", hash_original_method = "58E59A5E4DC50E1553DDF37B64C67560", hash_generated_method = "6DB8B414A3B1D97047BD316D4D64DB2B")
    
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
    
    public static KeyEvent droidsafeGetEvent() {
        return new KeyEvent();
    }

    /**
     * Obtains a (potentially recycled) key event.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.136 -0500", hash_original_method = "84E3C64DB453EB975FDFF6528E6DEC99", hash_generated_method = "EF6AC8337DADE7E99601163E522D57F9")
    
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

    /**
     * Obtains a (potentially recycled) copy of another key event.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.139 -0500", hash_original_method = "28B101371AA0B74FD18784A263CF6B82", hash_generated_method = "22B76F88B274143A3AEED3E3F4DA71C6")
    
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

    /**
     * Create a new key event that is the same as the given one, but whose
     * event time and repeat count are replaced with the given value.
     * 
     * @param event The existing event to be copied.  This is not modified.
     * @param eventTime The new event time
     * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
     * @param newRepeat The new repeat count of the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.147 -0500", hash_original_method = "C25C7F546DD04EB1B82F3297087F7A42", hash_generated_method = "E5DE2572CD42712DA7D8A05C01E7A0A1")
    
public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime,
            int newRepeat) {
        return new KeyEvent(event, eventTime, newRepeat);
    }
    
    /**
     * Create a new key event that is the same as the given one, but whose
     * event time and repeat count are replaced with the given value.
     * 
     * @param event The existing event to be copied.  This is not modified.
     * @param eventTime The new event time
     * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
     * @param newRepeat The new repeat count of the event.
     * @param newFlags New flags for the event, replacing the entire value
     * in the original event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.149 -0500", hash_original_method = "C67B6193689F2E6B547ED5F53D4C3961", hash_generated_method = "5A03F765D1AF5C16CA7458202AE8658D")
    
public static KeyEvent changeTimeRepeat(KeyEvent event, long eventTime,
            int newRepeat, int newFlags) {
        KeyEvent ret = new KeyEvent(event);
        ret.mEventTime = eventTime;
        ret.mRepeatCount = newRepeat;
        ret.mFlags = newFlags;
        return ret;
    }

    /**
     * Create a new key event that is the same as the given one, but whose
     * action is replaced with the given value.
     * 
     * @param event The existing event to be copied.  This is not modified.
     * @param action The new action code of the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.155 -0500", hash_original_method = "7C4A14AA8117C425C6BD057463B9EF5E", hash_generated_method = "8FF2DD087198F18C9F0803AE68A3A20A")
    
public static KeyEvent changeAction(KeyEvent event, int action) {
        return new KeyEvent(event, action);
    }
    
    /**
     * Create a new key event that is the same as the given one, but whose
     * flags are replaced with the given value.
     * 
     * @param event The existing event to be copied.  This is not modified.
     * @param flags The new flags constant.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.157 -0500", hash_original_method = "8FF2881A28BE22477C4696F5F0F62F5F", hash_generated_method = "B47196D13243D38743CB3129567E0268")
    
public static KeyEvent changeFlags(KeyEvent event, int flags) {
        event = new KeyEvent(event);
        event.mFlags = flags;
        return event;
    }

    /**
     * Returns true if the specified keycode is a gamepad button.
     * @return True if the keycode is a gamepad button, such as {@link #KEYCODE_BUTTON_A}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.175 -0500", hash_original_method = "02D200EA07EEDD4104DB45B438B7898E", hash_generated_method = "6D9140BFDA938295FFEE94023624770C")
    
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

    /**
     * Gets a mask that includes all valid modifier key meta state bits.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, the mask specifically excludes
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p>
     *
     * @return The modifier meta state mask which is a combination of
     * {@link #META_SHIFT_ON}, {@link #META_SHIFT_LEFT_ON}, {@link #META_SHIFT_RIGHT_ON},
     * {@link #META_ALT_ON}, {@link #META_ALT_LEFT_ON}, {@link #META_ALT_RIGHT_ON},
     * {@link #META_CTRL_ON}, {@link #META_CTRL_LEFT_ON}, {@link #META_CTRL_RIGHT_ON},
     * {@link #META_META_ON}, {@link #META_META_LEFT_ON}, {@link #META_META_RIGHT_ON},
     * {@link #META_SYM_ON}, {@link #META_FUNCTION_ON}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.208 -0500", hash_original_method = "0B3E09A0C4EB9D0DDCD587A22D4E1BD5", hash_generated_method = "548864271838F8EAFC9DE770EFBBE267")
    
public static int getModifierMetaStateMask() {
        return META_MODIFIER_MASK;
    }

    /**
     * Returns true if this key code is a modifier key.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function return false
     * for those keys.
     * </p>
     *
     * @return True if the key code is one of
     * {@link #KEYCODE_SHIFT_LEFT} {@link #KEYCODE_SHIFT_RIGHT},
     * {@link #KEYCODE_ALT_LEFT}, {@link #KEYCODE_ALT_RIGHT},
     * {@link #KEYCODE_CTRL_LEFT}, {@link #KEYCODE_CTRL_RIGHT},
     * {@link #KEYCODE_META_LEFT}, or {@link #KEYCODE_META_RIGHT},
     * {@link #KEYCODE_SYM}, {@link #KEYCODE_NUM}, {@link #KEYCODE_FUNCTION}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.211 -0500", hash_original_method = "2E2CB392CCF36FB5123148047881583D", hash_generated_method = "D507B94BADA6A4A981675465BE7593AC")
    
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

    /**
     * Normalizes the specified meta state.
     * <p>
     * The meta state is normalized such that if either the left or right modifier meta state
     * bits are set then the result will also include the universal bit for that modifier.
     * </p><p>
     * If the specified meta state contains {@link #META_ALT_LEFT_ON} then
     * the result will also contain {@link #META_ALT_ON} in addition to {@link #META_ALT_LEFT_ON}
     * and the other bits that were specified in the input.  The same is process is
     * performed for shift, control and meta.
     * </p><p>
     * If the specified meta state contains synthetic meta states defined by
     * {@link MetaKeyKeyListener}, then those states are translated here and the original
     * synthetic meta states are removed from the result.
     * {@link MetaKeyKeyListener#META_CAP_LOCKED} is translated to {@link #META_CAPS_LOCK_ON}.
     * {@link MetaKeyKeyListener#META_ALT_LOCKED} is translated to {@link #META_ALT_ON}.
     * {@link MetaKeyKeyListener#META_SYM_LOCKED} is translated to {@link #META_SYM_ON}.
     * </p><p>
     * Undefined meta state bits are removed.
     * </p>
     *
     * @param metaState The meta state.
     * @return The normalized meta state.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.214 -0500", hash_original_method = "FF10B1355184AC33BC9231DF2B9CE844", hash_generated_method = "70396B0C1D137396605B4EA5F4340D54")
    
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

    /**
     * Returns true if no modifiers keys are pressed according to the specified meta state.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function ignores
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p><p>
     * The meta state is normalized prior to comparison using {@link #normalizeMetaState(int)}.
     * </p>
     *
     * @param metaState The meta state to consider.
     * @return True if no modifier keys are pressed.
     * @see #hasNoModifiers()
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.217 -0500", hash_original_method = "39D9C16C68B6F41FF034537B98CA7050", hash_generated_method = "6ED68D3D6D1147E4BF5835F1709BF84F")
    
public static boolean metaStateHasNoModifiers(int metaState) {
        return (normalizeMetaState(metaState) & META_MODIFIER_MASK) == 0;
    }

    /**
     * Returns true if only the specified modifier keys are pressed according to
     * the specified meta state.  Returns false if a different combination of modifier
     * keys are pressed.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function ignores
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p><p>
     * If the specified modifier mask includes directional modifiers, such as
     * {@link #META_SHIFT_LEFT_ON}, then this method ensures that the
     * modifier is pressed on that side.
     * If the specified modifier mask includes non-directional modifiers, such as
     * {@link #META_SHIFT_ON}, then this method ensures that the modifier
     * is pressed on either side.
     * If the specified modifier mask includes both directional and non-directional modifiers
     * for the same type of key, such as {@link #META_SHIFT_ON} and {@link #META_SHIFT_LEFT_ON},
     * then this method throws an illegal argument exception.
     * </p>
     *
     * @param metaState The meta state to consider.
     * @param modifiers The meta state of the modifier keys to check.  May be a combination
     * of modifier meta states as defined by {@link #getModifierMetaStateMask()}.  May be 0 to
     * ensure that no modifier keys are pressed.
     * @return True if only the specified modifier keys are pressed.
     * @throws IllegalArgumentException if the modifiers parameter contains invalid modifiers
     * @see #hasModifiers
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.219 -0500", hash_original_method = "D72AA7105D31CF87A5590A7971CE1BB6", hash_generated_method = "BC6A634685E84C95F80919A71C2522FF")
    
public static boolean metaStateHasModifiers(int metaState, int modifiers) {
        // Note: For forward compatibility, we allow the parameter to contain meta states
        //       that we do not recognize but we explicitly disallow meta states that
        //       are not valid modifiers.
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.222 -0500", hash_original_method = "0F5319E42F82F111649B35879EBEED8A", hash_generated_method = "DDCC3B9D87138042780FDE99EBA6BB8A")
    
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

    /**
     * Returns a string that represents the symbolic name of the specified action
     * such as "ACTION_DOWN", or an equivalent numeric constant such as "35" if unknown.
     *
     * @param action The action.
     * @return The symbolic name of the specified action.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.341 -0500", hash_original_method = "3D5E6119433135AF9DDABA7F04E80C85", hash_generated_method = "45AD7585A9D47F04E4ECA68F18D3F909")
    
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

    /**
     * Returns a string that represents the symbolic name of the specified keycode
     * such as "KEYCODE_A", "KEYCODE_DPAD_UP", or an equivalent numeric constant
     * such as "1001" if unknown.
     *
     * @param keyCode The key code.
     * @return The symbolic name of the specified keycode.
     *
     * @see KeyCharacterMap#getDisplayLabel
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.344 -0500", hash_original_method = "DA23610AE555B2CB3A277DFD70BA19BB", hash_generated_method = "33A08149134A2F005B6E3580FAE97CB6")
    
public static String keyCodeToString(int keyCode) {
        String symbolicName = KEYCODE_SYMBOLIC_NAMES.get(keyCode);
        return symbolicName != null ? symbolicName : Integer.toString(keyCode);
    }

    /**
     * Gets a keycode by its symbolic name such as "KEYCODE_A" or an equivalent
     * numeric constant such as "1001".
     *
     * @param symbolicName The symbolic name of the keycode.
     * @return The keycode or {@link #KEYCODE_UNKNOWN} if not found.
     * @see #keycodeToString
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.347 -0500", hash_original_method = "13AD7F303C94E61D634409DA2DD00C20", hash_generated_method = "5FEA7DEB25DCE2FFB0EEEE860B15755A")
    
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

    /**
     * Returns a string that represents the symbolic name of the specified combined meta
     * key modifier state flags such as "0", "META_SHIFT_ON",
     * "META_ALT_ON|META_SHIFT_ON" or an equivalent numeric constant such as "0x10000000"
     * if unknown.
     *
     * @param metaState The meta state.
     * @return The symbolic name of the specified combined meta state flags.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.350 -0500", hash_original_method = "D533D03BD57DBED6F15F29CF317A4313", hash_generated_method = "CAFE34C7FA97939A7FB9539A701877E6")
    
public static String metaStateToString(int metaState) {
        if (metaState == 0) {
            return "0";
        }
        StringBuilder result = null;
        int i = 0;
        while (metaState != 0) {
            final boolean isSet = (metaState & 1) != 0;
            metaState >>>= 1; // unsigned shift!
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
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.363 -0500", hash_original_method = "26FD2082C0C6B65E4B0E835BD909C812", hash_generated_method = "BF0D06F42918705174191890D6042397")
    
public static KeyEvent createFromParcelBody(Parcel in) {
        return new KeyEvent(in);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.367 -0500", hash_original_field = "AD375DB19D6DCDEB85AED945DC1E654A", hash_generated_field = "7285BB49865BB7A73FF82101A3618DE1")

    public static final int KEYCODE_UNKNOWN         = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.370 -0500", hash_original_field = "08E0A287B86C7BC3F578F4FC70263848", hash_generated_field = "7C94641EF03C02ADAA58756441C6C3DC")

    public static final int KEYCODE_SOFT_LEFT       = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.372 -0500", hash_original_field = "AD3D45835C756C099BC02259B357132E", hash_generated_field = "CDC3B877D47F9C4322369F86769479DF")

    public static final int KEYCODE_SOFT_RIGHT      = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.375 -0500", hash_original_field = "CB8F4B27E99F05DE086017D0DCA1A0D3", hash_generated_field = "490508F022A786B3EA83848442FC843B")

    public static final int KEYCODE_HOME            = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.377 -0500", hash_original_field = "AE8C2B59A788EADB390462375D05A5E0", hash_generated_field = "D51C0A862C052245BF825EB6384D52D3")

    public static final int KEYCODE_BACK            = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.379 -0500", hash_original_field = "9650DE8EAB5F056430CAB2EDE57618FC", hash_generated_field = "7A2223A55DC7CFA24F10E735748D6955")

    public static final int KEYCODE_CALL            = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.382 -0500", hash_original_field = "90A5A97FFA6294BA4711E04B9ADA1700", hash_generated_field = "D17C9FC1460345D0952CF048AE61FC1D")

    public static final int KEYCODE_ENDCALL         = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.385 -0500", hash_original_field = "A799F36CA76D275AC582697A1EB2924F", hash_generated_field = "1D30FD9FE8BC56040C49FEACE88B364B")

    public static final int KEYCODE_0               = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.388 -0500", hash_original_field = "88AB29E4AD25AB6FA3AD56A0616264B7", hash_generated_field = "85B7AB842FD71F17EC7BCE1C46BEA181")

    public static final int KEYCODE_1               = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.390 -0500", hash_original_field = "AF852AEBF8731EEFCF7F3F916D237645", hash_generated_field = "65E61E691D4B7B19C63C5CB0B28ABB0C")

    public static final int KEYCODE_2               = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.393 -0500", hash_original_field = "19CC8A82F34A71F746A298C2692D5044", hash_generated_field = "C7CABEBDC8381CC68FA0AFA9C9A9AC8A")

    public static final int KEYCODE_3               = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.395 -0500", hash_original_field = "4920DBCCEF27AE9AB9F58986F9FBB2A4", hash_generated_field = "152E6E4B19FD84F863F773B3D7DD591F")

    public static final int KEYCODE_4               = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.398 -0500", hash_original_field = "89B130363CB8175CB35DF67420D24871", hash_generated_field = "5DC1004D18DE0F68128F0FA6D852BEC9")

    public static final int KEYCODE_5               = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.400 -0500", hash_original_field = "57AD97A622CBB5E90E099A0F9B256986", hash_generated_field = "98EC3BCE189B3CFEC215F21C596DDE37")

    public static final int KEYCODE_6               = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.403 -0500", hash_original_field = "CB486CEE80C2E8E329AF1C8FFA78BADB", hash_generated_field = "5BCB95B1E2B3E9F6B32FF504407798FD")

    public static final int KEYCODE_7               = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.405 -0500", hash_original_field = "63962CAC4950D7C94558A212D66075BB", hash_generated_field = "C6E1E1B256D66AD2FFC4B747DD3DCF28")

    public static final int KEYCODE_8               = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.408 -0500", hash_original_field = "B2F36C382056138E1A5852319BF91096", hash_generated_field = "B26610D4BD1A1148B7FF394910B8E769")

    public static final int KEYCODE_9               = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.411 -0500", hash_original_field = "ACED6CFA10268D92F05C2BF878B7A84F", hash_generated_field = "35594CC183F814819274A30608387241")

    public static final int KEYCODE_STAR            = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.413 -0500", hash_original_field = "B307CC721244DB770392B5C1A6A04734", hash_generated_field = "3A83FF10010434AFB5C188D35CE06EEF")

    public static final int KEYCODE_POUND           = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.417 -0500", hash_original_field = "DC8496451528987F73E47407B3FD97F5", hash_generated_field = "9EE316237E281C65C81D00C07CAD1F2D")

    public static final int KEYCODE_DPAD_UP         = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.419 -0500", hash_original_field = "F5DBD0581B1AB1C427A4B5C40BFBA929", hash_generated_field = "F86065A07D76E85025B22C214604C6C5")

    public static final int KEYCODE_DPAD_DOWN       = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.422 -0500", hash_original_field = "E99C2ACDC489FE058A7B36A748A223F5", hash_generated_field = "0D538E6811634082007F1A4295E6C282")

    public static final int KEYCODE_DPAD_LEFT       = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.424 -0500", hash_original_field = "1C29F86B8D107AB89E17CAB1D2EE43D4", hash_generated_field = "FC7106DDBEDEB52317C17161A149088A")

    public static final int KEYCODE_DPAD_RIGHT      = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.426 -0500", hash_original_field = "ECA35290BF17286E2B7B1F67FB488BD1", hash_generated_field = "B6D3FD572D96FBBE59F70C08DCA24F50")

    public static final int KEYCODE_DPAD_CENTER     = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.429 -0500", hash_original_field = "086988E4D9BC6D034A92A04074A31F59", hash_generated_field = "54FA1F0CEC07AE8A01E68E49B9F28087")

    public static final int KEYCODE_VOLUME_UP       = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.432 -0500", hash_original_field = "AFF39C31A721C7B21C69E9D30EE80FDA", hash_generated_field = "46079CFC3B8D06A0548408784301F54B")

    public static final int KEYCODE_VOLUME_DOWN     = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.435 -0500", hash_original_field = "B5073C5672DCB12768B8681286E8A0D8", hash_generated_field = "F77782D70F9385D92475B42E50FAED8A")

    public static final int KEYCODE_POWER           = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.437 -0500", hash_original_field = "4C32F5D122597A4DD96821EAA677051D", hash_generated_field = "3D168BC1F37F3F611FAEC12DDA098EC7")

    public static final int KEYCODE_CAMERA          = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.440 -0500", hash_original_field = "697A4229E53F47D7F2BF37825C63B938", hash_generated_field = "5BDED08FAC40D8A5FFB67E26E2DEECBB")

    public static final int KEYCODE_CLEAR           = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.442 -0500", hash_original_field = "1C0DFE1A2E9CF2442DF1C126DC4FE1FC", hash_generated_field = "FE6BDB290A385F201E149C95B493321F")

    public static final int KEYCODE_A               = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.445 -0500", hash_original_field = "04D432C623793A338ECCE1A5EA4212AD", hash_generated_field = "B878ACCC0EA947028E1990E04A14A80D")

    public static final int KEYCODE_B               = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.447 -0500", hash_original_field = "4263452A987844D7B2C4BF186876AD86", hash_generated_field = "4BFB53E29798EB5EAB1B3D9D2AF34377")

    public static final int KEYCODE_C               = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.450 -0500", hash_original_field = "F7859264502E5A8CA73B100BF57329F9", hash_generated_field = "118423EFBA4BA6597CF3C5E45BFA3C03")

    public static final int KEYCODE_D               = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.452 -0500", hash_original_field = "F06B7334182D293F047C35D0222DA4C0", hash_generated_field = "83E5F896260F3B178E1FB9A921F7BC77")

    public static final int KEYCODE_E               = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.455 -0500", hash_original_field = "2E29C95F0474A20EFD44ED058F96649C", hash_generated_field = "F2B36B8817B8073D273D2B89786A1980")

    public static final int KEYCODE_F               = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.457 -0500", hash_original_field = "363522EAAF366F196245072454155894", hash_generated_field = "C8AE23D8C939614D68040178CC4290CF")

    public static final int KEYCODE_G               = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.460 -0500", hash_original_field = "FE0A165B3BDA94358E473C9289A0AA5E", hash_generated_field = "9F44E015730522E58C7AE884E596EF6E")

    public static final int KEYCODE_H               = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.462 -0500", hash_original_field = "2733D08DF796A841DC47412DFD0D7063", hash_generated_field = "332CA0C3BAD0871B2C2CE5A5518B0C35")

    public static final int KEYCODE_I               = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.465 -0500", hash_original_field = "0A4BBA653C726675A6906116108EB95E", hash_generated_field = "0C49414BFBC1377D44DE62C18FBEFAD7")

    public static final int KEYCODE_J               = 38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.467 -0500", hash_original_field = "B061FA7055C94A3BE39D34CA290EECD3", hash_generated_field = "4C2DD393199B77C3F47233B85DBA315C")

    public static final int KEYCODE_K               = 39;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.470 -0500", hash_original_field = "5405AB014A2D0E2966E95BCA1F7245CD", hash_generated_field = "E700B923990CC2A17011E8A425314C44")

    public static final int KEYCODE_L               = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.473 -0500", hash_original_field = "4109FF568572F911D038E29F5AC03E07", hash_generated_field = "E2F7A047CD31666C570BD7BD9B03E77B")

    public static final int KEYCODE_M               = 41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.476 -0500", hash_original_field = "19D4F1FADE1D79C237822B41A984ACA4", hash_generated_field = "4A71C779109CE37B1DFB63D93E695137")

    public static final int KEYCODE_N               = 42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.478 -0500", hash_original_field = "ACE58E19EFA0FCCFE70CAD7843E20E26", hash_generated_field = "7158648ECE23F4F4522AC2F0706C3080")

    public static final int KEYCODE_O               = 43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.481 -0500", hash_original_field = "4409A96B6C0D7DBF97CBADC2082B29A4", hash_generated_field = "0033F43B24F3947978DACE045A3E65E4")

    public static final int KEYCODE_P               = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.483 -0500", hash_original_field = "61BB7EA403173B5D501E70AF2F9A0A9E", hash_generated_field = "3E823547FE71C57DE86DB081D500914B")

    public static final int KEYCODE_Q               = 45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.486 -0500", hash_original_field = "D2166C1F8A4CB4F2FB55151BDFF555D1", hash_generated_field = "61B0804BF3D4901BE26F11EF9D7039A4")

    public static final int KEYCODE_R               = 46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.488 -0500", hash_original_field = "2C38E7D12FFB8927571649BBA817043B", hash_generated_field = "200A247ABD753B6E6E960DA4C25B5B7B")

    public static final int KEYCODE_S               = 47;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.491 -0500", hash_original_field = "D9A057BE4FC0C451453F8BE4CCEA583F", hash_generated_field = "EAA1B9FE12EB2ED1730ACB1A0D91C211")

    public static final int KEYCODE_T               = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.493 -0500", hash_original_field = "A6D8421994761B304537A739C9ED4173", hash_generated_field = "58F43F94C037443F111AF28601BE9AA2")

    public static final int KEYCODE_U               = 49;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.496 -0500", hash_original_field = "EE4D8AD9C0BFE7CAF527038931C17E91", hash_generated_field = "855DF147DB773B49A665B52450F2E47D")

    public static final int KEYCODE_V               = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.498 -0500", hash_original_field = "E7548AA3B03A0D4472A353EF193C19BF", hash_generated_field = "CA0A4E443CFFC3386FDB6C5AB42409C6")

    public static final int KEYCODE_W               = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.501 -0500", hash_original_field = "A05175DA5FABD52D61E8DF9014CAEFCE", hash_generated_field = "D40E20635512C63E43B31D31AA08B920")

    public static final int KEYCODE_X               = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.504 -0500", hash_original_field = "C1159AF8CA282AE28FB8B976196AB34B", hash_generated_field = "CE471BD86397F96881C51C568105E4C9")

    public static final int KEYCODE_Y               = 53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.507 -0500", hash_original_field = "1F34F8B4FCFD7A4A30B893390748F7CD", hash_generated_field = "383E7871BB1F3CA11EF8025CF6526545")

    public static final int KEYCODE_Z               = 54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.509 -0500", hash_original_field = "D84BD070DFC40362984E3A6DE4073A94", hash_generated_field = "BA57A8D20C6D43BACE8889F796360C4F")

    public static final int KEYCODE_COMMA           = 55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.512 -0500", hash_original_field = "C49A4965AFB632A8AD43E986C5D6C1EC", hash_generated_field = "3727260E91B3CA590B88910781CA940D")

    public static final int KEYCODE_PERIOD          = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.514 -0500", hash_original_field = "6313F129A94C2565D19F3DEC581387D5", hash_generated_field = "6546DB257EAFA6DFBF70E229C73FF202")

    public static final int KEYCODE_ALT_LEFT        = 57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.516 -0500", hash_original_field = "44618135D64D9486C8C526FB6C69830A", hash_generated_field = "60981BFA4690AB877C41BC68417F70A6")

    public static final int KEYCODE_ALT_RIGHT       = 58;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.519 -0500", hash_original_field = "159C0E4B8E7CC3D6B08C2C6256AC0662", hash_generated_field = "0E7262B2253D96CFB6646A353A9F5034")

    public static final int KEYCODE_SHIFT_LEFT      = 59;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.522 -0500", hash_original_field = "96B193FC5E0701AB08E14127E8FD77A1", hash_generated_field = "21947052029CA662950C510189D038C4")

    public static final int KEYCODE_SHIFT_RIGHT     = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.524 -0500", hash_original_field = "01AAA03F75AC670B73F309A403C501E9", hash_generated_field = "72FCC53488031C604837189A2CCD509D")

    public static final int KEYCODE_TAB             = 61;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.527 -0500", hash_original_field = "A1D8029CBC8ED50F1805F76DAC12C6B1", hash_generated_field = "EBC570BDF039A249897CB707213F0B35")

    public static final int KEYCODE_SPACE           = 62;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.529 -0500", hash_original_field = "E23607D5D9F95C187F189A57962A4BF4", hash_generated_field = "459B4EB126A209BEBFDEBF8457D8291E")

    public static final int KEYCODE_SYM             = 63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.532 -0500", hash_original_field = "6D242FD7B26B752E03496510C36C0FAF", hash_generated_field = "CB2185E6C3C26A135A1C9FAC3DE78E13")

    public static final int KEYCODE_EXPLORER        = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.534 -0500", hash_original_field = "68FB34DB3CA16FC85BF8DA4EFDC416FF", hash_generated_field = "5B5E0AE53DEC1768D4A030E3BF1C213C")

    public static final int KEYCODE_ENVELOPE        = 65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.537 -0500", hash_original_field = "D54F1BC287F0927885762F0404C9AA5E", hash_generated_field = "9E2401D49F830A30BCBEB327A12CE3D1")

    public static final int KEYCODE_ENTER           = 66;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.539 -0500", hash_original_field = "E5F3679815E58248DF491CBA337E2330", hash_generated_field = "88F86DAE4F7A5F033CA9AE19421E94DF")

    public static final int KEYCODE_DEL             = 67;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.543 -0500", hash_original_field = "2E5DBB87CB930CAC28249B64FE6B3348", hash_generated_field = "463F9E92E5AFA54674F2C6C72E5028FA")

    public static final int KEYCODE_GRAVE           = 68;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.545 -0500", hash_original_field = "4057989EE3CE9217D9FE8501170B58E8", hash_generated_field = "5CEAB35A1DC86C4F3DBF02F70F6A674B")

    public static final int KEYCODE_MINUS           = 69;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.548 -0500", hash_original_field = "FD63250C1F4273836706C8A03C8027BD", hash_generated_field = "13CF728FEB0FCC69D9173C1DF9788E94")

    public static final int KEYCODE_EQUALS          = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.550 -0500", hash_original_field = "D7C4312D2C8B1293A9B3D963F75661EE", hash_generated_field = "83FF22F63EDAB467B7E351713DF703E4")

    public static final int KEYCODE_LEFT_BRACKET    = 71;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.553 -0500", hash_original_field = "47762673ACBB5D63D656E84F19B208E6", hash_generated_field = "E4DCE8B34CA7CCA10B47674F0D250F44")

    public static final int KEYCODE_RIGHT_BRACKET   = 72;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.556 -0500", hash_original_field = "6DAB2F6BAED8ABB0B2A47C478B02DFCA", hash_generated_field = "5CD0FEFC7C4F9B1D4F2451A7E61C1E1C")

    public static final int KEYCODE_BACKSLASH       = 73;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.558 -0500", hash_original_field = "4F30F97915214DB31DD3BD8ECEEE630E", hash_generated_field = "6D3C43937A11F119AE384B24165D8BF4")

    public static final int KEYCODE_SEMICOLON       = 74;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.560 -0500", hash_original_field = "9F05F9CF87C6A8D29E81BD25801C05B1", hash_generated_field = "BC269C9B8A7BF1C78781BFC2675D16D1")

    public static final int KEYCODE_APOSTROPHE      = 75;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.563 -0500", hash_original_field = "ABF4EC7B83F3D24E406BDCA59085D8A7", hash_generated_field = "C915146C0867D19CACED2D4EADFEF8A0")

    public static final int KEYCODE_SLASH           = 76;
    
    public static class DispatcherState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.312 -0500", hash_original_field = "09E1F61D6927630107A1B08B0819BA0E", hash_generated_field = "09E1F61D6927630107A1B08B0819BA0E")

        int mDownKeyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.316 -0500", hash_original_field = "5B628734B79397D95D8B3A85BB9AD1CB", hash_generated_field = "5B628734B79397D95D8B3A85BB9AD1CB")

        Object mDownTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.318 -0500", hash_original_field = "EFB3A6F42762D745C780E8C741E6202A", hash_generated_field = "EFB3A6F42762D745C780E8C741E6202A")

        SparseIntArray mActiveLongPresses = new SparseIntArray();
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.353 -0400", hash_original_method = "6A42904977F799CF06B04A57C142AD90", hash_generated_method = "6A42904977F799CF06B04A57C142AD90")
        public DispatcherState ()
        {
            //Synthesized constructor
        }
        
        /**
         * Reset back to initial state.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.320 -0500", hash_original_method = "554562900865028A00C4676EE39BA2E0", hash_generated_method = "254635D352F549751DDFE71F4D7E7035")
        
public void reset() {
            if (DEBUG) Log.v(TAG, "Reset: " + this);
            mDownKeyCode = 0;
            mDownTarget = null;
            mActiveLongPresses.clear();
        }
        
        /**
         * Stop any tracking associated with this target.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.323 -0500", hash_original_method = "7A446B7A655E4D7578F3AEB4F96BA0A4", hash_generated_method = "955E15E89844F14F86C95E1FD6BCB90D")
        
public void reset(Object target) {
            if (mDownTarget == target) {
                if (DEBUG) Log.v(TAG, "Reset in " + target + ": " + this);
                mDownKeyCode = 0;
                mDownTarget = null;
            }
        }
        
        /**
         * Start tracking the key code associated with the given event.  This
         * can only be called on a key down.  It will allow you to see any
         * long press associated with the key, and will result in
         * {@link KeyEvent#isTracking} return true on the long press and up
         * events.
         * 
         * <p>This is only needed if you are directly dispatching events, rather
         * than handling them in {@link Callback#onKeyDown}.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.326 -0500", hash_original_method = "F359109F6941FCC4380DDA2E2CA9E676", hash_generated_method = "915D81D324F7B39734380B66EFBED977")
        
public void startTracking(KeyEvent event, Object target) {
            if (event.getAction() != ACTION_DOWN) {
                throw new IllegalArgumentException(
                        "Can only start tracking on a down event");
            }
            if (DEBUG) Log.v(TAG, "Start trackingt in " + target + ": " + this);
            mDownKeyCode = event.getKeyCode();
            mDownTarget = target;
        }
        
        /**
         * Return true if the key event is for a key code that is currently
         * being tracked by the dispatcher.
         */
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.328 -0500", hash_original_method = "07F4929E2B3E025FC2215EF8E614ABBF", hash_generated_method = "DA8BE213587217DB451EF8ED183187C5")
        
public boolean isTracking(KeyEvent event) {
            return mDownKeyCode == event.getKeyCode();
        }
        
        /**
         * Keep track of the given event's key code as having performed an
         * action with a long press, so no action should occur on the up.
         * <p>This is only needed if you are directly dispatching events, rather
         * than handling them in {@link Callback#onKeyLongPress}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.331 -0500", hash_original_method = "2266BAE243819DE7EACEEEA38A1E3CF0", hash_generated_method = "A62A8D4A1657A6089CE155A43B48054D")
        
public void performedLongPress(KeyEvent event) {
            mActiveLongPresses.put(event.getKeyCode(), 1);
        }
        
        /**
         * Handle key up event to stop tracking.  This resets the dispatcher state,
         * and updates the key event state based on it.
         * <p>This is only needed if you are directly dispatching events, rather
         * than handling them in {@link Callback#onKeyUp}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.334 -0500", hash_original_method = "4EC5A9A4246B9BB19D03F0E0F2DEA552", hash_generated_method = "822AE88FAF3B978CB7DB6D8D57F8465C")
        
public void handleUpEvent(KeyEvent event) {
            final int keyCode = event.getKeyCode();
            if (DEBUG) Log.v(TAG, "Handle key up " + event + ": " + this);
            int index = mActiveLongPresses.indexOfKey(keyCode);
            if (index >= 0) {
                if (DEBUG) Log.v(TAG, "  Index: " + index);
                event.mFlags |= FLAG_CANCELED | FLAG_CANCELED_LONG_PRESS;
                mActiveLongPresses.removeAt(index);
            }
            if (mDownKeyCode == keyCode) {
                if (DEBUG) Log.v(TAG, "  Tracking!");
                event.mFlags |= FLAG_TRACKING;
                mDownKeyCode = 0;
                mDownTarget = null;
            }
        }
        
    }
    
    public interface Callback {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onKeyDown(int keyCode, KeyEvent event);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onKeyLongPress(int keyCode, KeyEvent event);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onKeyUp(int keyCode, KeyEvent event);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onKeyMultiple(int keyCode, int count, KeyEvent event);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.566 -0500", hash_original_field = "DB1C717642A56E965480673F3F05386B", hash_generated_field = "86DB665B33F8C0F0EAF3A4B3E3D86A09")

    public static final int KEYCODE_AT              = 77;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.568 -0500", hash_original_field = "52A3D5BC25EAFFC989EBF26571312385", hash_generated_field = "A37C5151BD531FB2DDA5C5347CAB0BEA")

    public static final int KEYCODE_NUM             = 78;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.571 -0500", hash_original_field = "160039AB7A5C3EB1FB1B65770E2D9E39", hash_generated_field = "03898CD293C180DAF97F9B4681F10016")

    public static final int KEYCODE_HEADSETHOOK     = 79;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.573 -0500", hash_original_field = "BC42928C636791EB601943E3003B0176", hash_generated_field = "EC2FD7E482A8BEB9CEBBB333421D09D0")

    public static final int KEYCODE_FOCUS           = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.576 -0500", hash_original_field = "DDDBD07C3E711E3C6F70BFCA639DDBE9", hash_generated_field = "3FB359C48D8BAC4588C3FC2D4CDE0521")

    /** Key code constant: '+' key. */
    public static final int KEYCODE_PLUS            = 81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.578 -0500", hash_original_field = "6272919941B746D5FFE6434B7C81E560", hash_generated_field = "55CB6E70448A2CA2DB215FAE50D85E2C")

    public static final int KEYCODE_MENU            = 82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.581 -0500", hash_original_field = "BAF56295290C484E530550E2609BD5FD", hash_generated_field = "7D2FB2ECF44C4EB9FEC258BBBCF02284")

    public static final int KEYCODE_NOTIFICATION    = 83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.584 -0500", hash_original_field = "7E40F727C9F6DD75019B6FBCCEE14E96", hash_generated_field = "F32CD743E8C746123EFB275F5D823E38")

    public static final int KEYCODE_SEARCH          = 84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.586 -0500", hash_original_field = "291A26238320AA0CC18B2D6EB77B7E77", hash_generated_field = "8FDBA2D86C71775735575861A79349BD")

    public static final int KEYCODE_MEDIA_PLAY_PAUSE= 85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.589 -0500", hash_original_field = "BFE43ADFEF5828CF67C4CD5886FABB97", hash_generated_field = "06435042A6EE1EB03FBB8EB37EB2933E")

    public static final int KEYCODE_MEDIA_STOP      = 86;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.591 -0500", hash_original_field = "EA2B36D1DE71A37FEEBEC827DB660AC6", hash_generated_field = "1AD92793390C3B243F92413ADE0CBF79")

    public static final int KEYCODE_MEDIA_NEXT      = 87;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.594 -0500", hash_original_field = "643BF5826D71858BF7B5A40C08231DEF", hash_generated_field = "D15805A59182DF2676AE6606BD4B3E86")

    public static final int KEYCODE_MEDIA_PREVIOUS  = 88;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.597 -0500", hash_original_field = "8B6A9158885F014FF7EEE61FD02FB56D", hash_generated_field = "2C1D13D83AD6AF6C4CFFB61B2D3ECDBD")

    public static final int KEYCODE_MEDIA_REWIND    = 89;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.599 -0500", hash_original_field = "8DB8FBBA31174658BBEF14A6A605B437", hash_generated_field = "14ED8936291432095F0B6CA9194F32D0")

    public static final int KEYCODE_MEDIA_FAST_FORWARD = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.602 -0500", hash_original_field = "51985D04C9FCD5A06B5DC25A1C62C45C", hash_generated_field = "8793EA7B43310482F68FFC6CFE4D6B73")

    public static final int KEYCODE_MUTE            = 91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.604 -0500", hash_original_field = "D57080093222D9DCB664FAC6E8BB993D", hash_generated_field = "0E5DB3E164CCD49A57181C42098C77D0")

    public static final int KEYCODE_PAGE_UP         = 92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.606 -0500", hash_original_field = "80B400DFAF03B93AE5898BFC5539BAE8", hash_generated_field = "5DE8822E84BF868BFBF6060D5AF39742")

    public static final int KEYCODE_PAGE_DOWN       = 93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.609 -0500", hash_original_field = "55E8C3BFB50A97D66D411F49F4214E48", hash_generated_field = "4939F900B57DD2A2CB368B2E7DFAA14E")

    public static final int KEYCODE_PICTSYMBOLS     = 94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.612 -0500", hash_original_field = "02BC8DBB645A8616E574D4D31FED9344", hash_generated_field = "84E585F2B7264F0386BF5EFA123FDE9D")

    /** Key code constant: Switch Charset modifier key.
     * Used to switch character sets (Kanji, Katakana). */
    public static final int KEYCODE_SWITCH_CHARSET  = 95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.614 -0500", hash_original_field = "78DA4617439E3F7AB75CF950956F7C84", hash_generated_field = "AD11ED56CCED6561A9EF115F3E4B8B4F")

    /** Key code constant: A Button key.
     * On a game controller, the A button should be either the button labeled A
     * or the first button on the upper row of controller buttons. */
    public static final int KEYCODE_BUTTON_A        = 96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.617 -0500", hash_original_field = "BC11CDC0F93A4E3B3DA6FFD16C6AFE1A", hash_generated_field = "74B06ED1D5A60607361ACE3A03F23DE9")

    public static final int KEYCODE_BUTTON_B        = 97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.619 -0500", hash_original_field = "5BC92511B402B9ABC18F878D51A14AD7", hash_generated_field = "3FABA08469D4ACF5666CC93B0BD53B24")

    public static final int KEYCODE_BUTTON_C        = 98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.623 -0500", hash_original_field = "243380F1E9F3AD5B8CF62946F07FE5B6", hash_generated_field = "4F3E753216AE38FEB637D5151C82AADC")

    public static final int KEYCODE_BUTTON_X        = 99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.625 -0500", hash_original_field = "4FB9D6ACFA0D8CBD0ED865CF5957BA54", hash_generated_field = "9C8F8431CEE390286A73BF0AB1C37E4F")

    public static final int KEYCODE_BUTTON_Y        = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.628 -0500", hash_original_field = "7B428129B7CB3E6F78D4D822E8A9F542", hash_generated_field = "3298AA6F86A769AE7AB38C61A5573A0C")

    public static final int KEYCODE_BUTTON_Z        = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.630 -0500", hash_original_field = "8290138DE9AAA70BE0939BB23812B618", hash_generated_field = "16DADBC94B67672FDAA9AF8C91C72F08")

    public static final int KEYCODE_BUTTON_L1       = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.633 -0500", hash_original_field = "84105FDFDC824E346409B333B2E47F28", hash_generated_field = "8833176B01A40CE2306604C72D80EA1B")

    public static final int KEYCODE_BUTTON_R1       = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.635 -0500", hash_original_field = "19EAA79023B690F1664FFB4CEB0368AE", hash_generated_field = "070B93128C57985068EF6869F2854AD1")

    public static final int KEYCODE_BUTTON_L2       = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.638 -0500", hash_original_field = "21B7E2DADFA5A3B4DE821D3762E6A7F9", hash_generated_field = "9B2850E56B8C96CC90F7B4262C092BAA")

    public static final int KEYCODE_BUTTON_R2       = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.641 -0500", hash_original_field = "59D25887CE4870DBAC52C71E1E77820D", hash_generated_field = "7BB77401B48782C1DA22536A6D1ACFC2")

    public static final int KEYCODE_BUTTON_THUMBL   = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.643 -0500", hash_original_field = "E98143BC2ADFDA8EC29033E393C91FC0", hash_generated_field = "957F71B0CEFC89FA603F7B7F9496E40C")

    public static final int KEYCODE_BUTTON_THUMBR   = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.645 -0500", hash_original_field = "5A2441B9CCE2C2EEE2459A7E627DD61A", hash_generated_field = "3C2147BFD0A352215AED1CDDE74C4927")

    public static final int KEYCODE_BUTTON_START    = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.647 -0500", hash_original_field = "F913E5EDC4C67A3808D58B8DF539603E", hash_generated_field = "486C95C9C17D5CE2FB5701AD2312165E")

    public static final int KEYCODE_BUTTON_SELECT   = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.650 -0500", hash_original_field = "C4B5F067B7DFC63B65F0EAA22F24F6C2", hash_generated_field = "91A92EDCBF3439CA7154016DBF6DBD31")

    public static final int KEYCODE_BUTTON_MODE     = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.652 -0500", hash_original_field = "1DEA18F706C77D6BCB76ACD4B7C6648F", hash_generated_field = "F4D8109F1A4C02A1F11832D4C39A453A")

    public static final int KEYCODE_ESCAPE          = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.655 -0500", hash_original_field = "E0F4DE94F7801B387D6BC970DED2073C", hash_generated_field = "0C1FC00B20C1E1A8C80ECA4CF560EA57")

    public static final int KEYCODE_FORWARD_DEL     = 112;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.658 -0500", hash_original_field = "7A3FB57E9F65ECD21BEBF2F9693B85EF", hash_generated_field = "7E6EC03CC110CB99368B7D6529B31AAF")

    public static final int KEYCODE_CTRL_LEFT       = 113;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.660 -0500", hash_original_field = "EE31DB0B740B30642F0BF293E26A2FE8", hash_generated_field = "839FB9FFAB710CAB2E67757DBCEE6C07")

    public static final int KEYCODE_CTRL_RIGHT      = 114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.663 -0500", hash_original_field = "5FC58DD4D3B2ACE8D08AB533CEC6EF54", hash_generated_field = "2C34DA128A3F93DD3EE287703E784C7E")

    public static final int KEYCODE_CAPS_LOCK       = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.665 -0500", hash_original_field = "2013D513DB164F30AAEFC45F7FA713B4", hash_generated_field = "BFCBAA8C83B614BE3E433B4596A6E2CA")

    public static final int KEYCODE_SCROLL_LOCK     = 116;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.668 -0500", hash_original_field = "49F6F849822DF9B14CA7467DD34C12AD", hash_generated_field = "0D4F3DB8F853DCD8828E4B5EDD90AFC3")

    public static final int KEYCODE_META_LEFT       = 117;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.671 -0500", hash_original_field = "C4A8FDD23F70B659DDE07E4F23E77837", hash_generated_field = "F19FD8B2678E56118E9099A490A3EF43")

    public static final int KEYCODE_META_RIGHT      = 118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.674 -0500", hash_original_field = "0569B57ABEFF0FDF6D4E9A97D6A81CBA", hash_generated_field = "43EB65D1D46A2DB6037A79F135F647F0")

    public static final int KEYCODE_FUNCTION        = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.676 -0500", hash_original_field = "F81C6DBAF234536F2427C07288C0D128", hash_generated_field = "85A06C31533BD455AED0EBFACAAF99F6")

    public static final int KEYCODE_SYSRQ           = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.679 -0500", hash_original_field = "FC82995B35CFF9CD11F2F48773C5CE1B", hash_generated_field = "24E6F76F09E3DBA66C6E78E1AC0D6377")

    public static final int KEYCODE_BREAK           = 121;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.681 -0500", hash_original_field = "E8E3857E843D1204B8DB6CAC70D91FD0", hash_generated_field = "40D11295ADF4AEFA4139EA8DA0E1629C")

    public static final int KEYCODE_MOVE_HOME       = 122;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.684 -0500", hash_original_field = "1903F4276367AF1B6BD8AC998277D8FD", hash_generated_field = "637D1DD3C96A0EBA62B9B18A0D077502")

    public static final int KEYCODE_MOVE_END        = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.687 -0500", hash_original_field = "18F7E440078E20F663C4C9C53F9EE9B6", hash_generated_field = "D5553617443672385F8B5FA58E06D02B")

    public static final int KEYCODE_INSERT          = 124;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.689 -0500", hash_original_field = "11B80F96C8423850F602A4321296C86E", hash_generated_field = "D89013950B1A88C29D00CB29B82B6CFE")

    public static final int KEYCODE_FORWARD         = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.691 -0500", hash_original_field = "457D8CC34754D8191A76F7237884E1F8", hash_generated_field = "9441A62B74F22725D4E5C7392C8E6558")

    public static final int KEYCODE_MEDIA_PLAY      = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.694 -0500", hash_original_field = "0A648676245ED2215612BC8EAE0354CC", hash_generated_field = "753187519748D9D0BAB26C6880E1DB28")

    public static final int KEYCODE_MEDIA_PAUSE     = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.696 -0500", hash_original_field = "78139CD76C58885B24FF54B5F194FE87", hash_generated_field = "E6DA4C66BA0A5A5C45F3B73A169E7B05")

    public static final int KEYCODE_MEDIA_CLOSE     = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.698 -0500", hash_original_field = "C877826E993B6E42E22E4F1275FE481F", hash_generated_field = "53167516014E93CC3BEA619AB4DCCF8A")

    public static final int KEYCODE_MEDIA_EJECT     = 129;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.701 -0500", hash_original_field = "6A375B60122605CB04C333EADEB5E83D", hash_generated_field = "D0B7C1441F43A2FC8490E55B0453C41D")

    public static final int KEYCODE_MEDIA_RECORD    = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.704 -0500", hash_original_field = "CFE5A87E028B3EFF1EF271F165D71170", hash_generated_field = "41935DB4FFE35F9FB36E8223813D9051")

    public static final int KEYCODE_F1              = 131;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.707 -0500", hash_original_field = "5E22EFC873CB9AF8CA7BC5AC54396984", hash_generated_field = "78E7EA48B4D9AC8D3E63E3A78FAF5869")

    public static final int KEYCODE_F2              = 132;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.709 -0500", hash_original_field = "E68328C49F1807B65B3F0C36A00247A8", hash_generated_field = "418F881409ED2E93669C68C71F8D4CA5")

    public static final int KEYCODE_F3              = 133;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.711 -0500", hash_original_field = "BA8EAD1A6B1BE41B169CBAD8D3BA8227", hash_generated_field = "E1AA61F15EEC5BA34FB6680DCE14397F")

    public static final int KEYCODE_F4              = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.714 -0500", hash_original_field = "2AEE1D6B2C553BB485382B875BD182C2", hash_generated_field = "97880C228CCAAB5352F34A43F284B38D")

    public static final int KEYCODE_F5              = 135;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.716 -0500", hash_original_field = "A3B8864B40F60735AF1BBB0CA41BB4D2", hash_generated_field = "9A8A20B5B0ABE1C469ECB076ED7621AE")

    public static final int KEYCODE_F6              = 136;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.720 -0500", hash_original_field = "912DAB018E82BFAABD107F2D8CBD736F", hash_generated_field = "8628B16B71353158721690BA70FBFDA8")

    public static final int KEYCODE_F7              = 137;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.722 -0500", hash_original_field = "E7826DBFEEC96806A59E2993044CBC8F", hash_generated_field = "1C3DF38BEEEA1277B43E74D535408577")

    public static final int KEYCODE_F8              = 138;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.725 -0500", hash_original_field = "29513D4C48673DAEF2B6F04756836894", hash_generated_field = "AF49243EFD749B272F992886A023C12E")

    public static final int KEYCODE_F9              = 139;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.727 -0500", hash_original_field = "71E2C635EB3595A0C10D9D9BE2F502D4", hash_generated_field = "2640BE5CBBF315157DFFD20FABA57503")

    public static final int KEYCODE_F10             = 140;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.730 -0500", hash_original_field = "50B6AF232AC9FBAA41B1E5A333E1AD88", hash_generated_field = "4721BBD295F0D13396182FD908941315")

    public static final int KEYCODE_F11             = 141;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.733 -0500", hash_original_field = "4995BB6ED248C28AB046DBFA1B8D1024", hash_generated_field = "EE0801DED18F1D0BCA459E861020D3AA")

    public static final int KEYCODE_F12             = 142;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.735 -0500", hash_original_field = "BB7F0A5AFB94E5B0363A6F6DC67165B1", hash_generated_field = "E7B1297F34D10527EC47E93A01689239")

    public static final int KEYCODE_NUM_LOCK        = 143;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.737 -0500", hash_original_field = "A64130C8941C0B0BDEEE340FE865DDDF", hash_generated_field = "F178ECA9E4F082BE7EBCF84C65804A50")

    public static final int KEYCODE_NUMPAD_0        = 144;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.740 -0500", hash_original_field = "D14C85B63C3BE4ABB4E6E52E65D2169A", hash_generated_field = "6A4E2CC78971158C3C56AC8B6D25EEF8")

    public static final int KEYCODE_NUMPAD_1        = 145;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.742 -0500", hash_original_field = "536F81F62C954F617905D18960A376BC", hash_generated_field = "E64AEFD095100DAD616C739D73D20747")

    public static final int KEYCODE_NUMPAD_2        = 146;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.745 -0500", hash_original_field = "88159F0B943AC0D4A34E9BC30177F23B", hash_generated_field = "C7962CF9464774D67F44699F98A1A98E")

    public static final int KEYCODE_NUMPAD_3        = 147;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.748 -0500", hash_original_field = "34461206BCB59CF9FC5DA9F7DD93CDCA", hash_generated_field = "8174485E99FB498712D104900B1FA6E1")

    public static final int KEYCODE_NUMPAD_4        = 148;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.750 -0500", hash_original_field = "355E2C325BA13AE8CAD137FC76BF1DB1", hash_generated_field = "E53C1BAB7566E6112738FD7E6FC54FB2")

    public static final int KEYCODE_NUMPAD_5        = 149;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.753 -0500", hash_original_field = "6FA61E271CF68211DACAD9E8699AFECB", hash_generated_field = "A099EA06B10BE4F4FEB8E1BAAF314943")

    public static final int KEYCODE_NUMPAD_6        = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.755 -0500", hash_original_field = "5F20611D8AC793F2E0169DD99E6005D9", hash_generated_field = "1C41733DF0F6DBE275EAE20CFBE7F850")

    public static final int KEYCODE_NUMPAD_7        = 151;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.758 -0500", hash_original_field = "D55E54E8F528632FBC723270BFB699A0", hash_generated_field = "D1114D54C9C9F46CF14FD0A8461B695B")

    public static final int KEYCODE_NUMPAD_8        = 152;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.760 -0500", hash_original_field = "8935B0711C901A0E2A694E0B641669E0", hash_generated_field = "4C2190A91FDEA2A65F9B1BCDCF30B7DA")

    public static final int KEYCODE_NUMPAD_9        = 153;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.763 -0500", hash_original_field = "5D002FABD433385C40FEEBD4C5470316", hash_generated_field = "95DA8633DB38C5B1079227DD1899F78D")

    public static final int KEYCODE_NUMPAD_DIVIDE   = 154;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.765 -0500", hash_original_field = "792789A7A4D7CF14F449D83A176E0078", hash_generated_field = "2C99929BF9155401C81D0E1DC9128D97")

    public static final int KEYCODE_NUMPAD_MULTIPLY = 155;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.768 -0500", hash_original_field = "E5CA7A2321AE1FF370915AA345A968B6", hash_generated_field = "B83DCBE2EC5839402F13B659FFA984B4")

    public static final int KEYCODE_NUMPAD_SUBTRACT = 156;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.771 -0500", hash_original_field = "38B09A9F12B81FCC3290EAA16676742E", hash_generated_field = "B37C36B8275B78CEDE9DE8E119AB99F8")

    public static final int KEYCODE_NUMPAD_ADD      = 157;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.774 -0500", hash_original_field = "1C77B0C5FE2BFCACD14BF31B190CD100", hash_generated_field = "DEB55AB3EEFECF2A2D3A6C7BAD086204")

    public static final int KEYCODE_NUMPAD_DOT      = 158;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.776 -0500", hash_original_field = "8C0456BFF1B58B4DCE18DEB13F2210B3", hash_generated_field = "E7BA1246B397A372C303FB6BEDA05C41")

    public static final int KEYCODE_NUMPAD_COMMA    = 159;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.779 -0500", hash_original_field = "FC26452E6AB21FDEC0B2AC5096100057", hash_generated_field = "3AA10B522839DE0B8A23508939F4F2F7")

    public static final int KEYCODE_NUMPAD_ENTER    = 160;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.781 -0500", hash_original_field = "82A8C5ADF21061DB2CF7F533456DD12B", hash_generated_field = "51C0B98952976BE77EFEC636079D030F")

    public static final int KEYCODE_NUMPAD_EQUALS   = 161;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.783 -0500", hash_original_field = "B198147DEB7F0523F4290F12EA0173A1", hash_generated_field = "80E3CB8500CE46B418C48285FAD32650")

    public static final int KEYCODE_NUMPAD_LEFT_PAREN = 162;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.786 -0500", hash_original_field = "3A599430E70841FC42DA0D1A86BBE4CD", hash_generated_field = "30EA1399B053CF5467F3CAB56CAFB91F")

    public static final int KEYCODE_NUMPAD_RIGHT_PAREN = 163;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.788 -0500", hash_original_field = "4D0BE407235AA7E4003B6329D27EAB1F", hash_generated_field = "382A5F2BB6F20D95E6A69A8D3A50C50C")

    public static final int KEYCODE_VOLUME_MUTE     = 164;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.791 -0500", hash_original_field = "288FBC3B71B46A32D2B4CDDF92A1436B", hash_generated_field = "CBC37F179A59326D26BA9D193835C780")

    public static final int KEYCODE_INFO            = 165;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.794 -0500", hash_original_field = "DE3FA768FDD6E3C2720DBEFE3AD2D019", hash_generated_field = "77C337F3E2FE3B1CC7653C583F48419D")

    public static final int KEYCODE_CHANNEL_UP      = 166;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.796 -0500", hash_original_field = "02DCB3AA447A1C32867907F57F3DF6EF", hash_generated_field = "FEBA0DDC25D9B460E8DF9B89F63B7D25")

    public static final int KEYCODE_CHANNEL_DOWN    = 167;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.799 -0500", hash_original_field = "8FBE26F814B7C722D7A3CDE0815B442D", hash_generated_field = "B37DF083E60B13A38E1D935192F269CF")

    public static final int KEYCODE_ZOOM_IN         = 168;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.801 -0500", hash_original_field = "D49B4DC355816F00D75D435B3A3A54C7", hash_generated_field = "510DA9083E038F4EC2A860508BAF4CD3")

    public static final int KEYCODE_ZOOM_OUT        = 169;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.805 -0500", hash_original_field = "AD1D9EFFA83C73AF233B86417166B671", hash_generated_field = "6DFE075DCEDF47B1E7FC81E18088A542")

    public static final int KEYCODE_TV              = 170;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.807 -0500", hash_original_field = "FA9A3864AB759AB7DD7BB54C6313F6B7", hash_generated_field = "FC8ACE3FC1F2DAF77B12E57AEB880469")

    public static final int KEYCODE_WINDOW          = 171;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.810 -0500", hash_original_field = "28236B0A3E9EE197618D2CC4FC648FA5", hash_generated_field = "A7E4A2067FE83390E6363A0018E64AE6")

    public static final int KEYCODE_GUIDE           = 172;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.812 -0500", hash_original_field = "5E3B08D1C0D2B956B0A31D144200F185", hash_generated_field = "DC8596C92C6C18BF2291A38EBDBEF3E7")

    public static final int KEYCODE_DVR             = 173;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.815 -0500", hash_original_field = "12A6F2D4151B29737A21DB789DE76FE5", hash_generated_field = "249CFB3940E57A5FC9C7538CF3B16777")

    public static final int KEYCODE_BOOKMARK        = 174;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.817 -0500", hash_original_field = "C031AD9695BE2D19AA1701F57B1F6838", hash_generated_field = "10994FBFB90379026F33E31E9F8676B3")

    public static final int KEYCODE_CAPTIONS        = 175;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.819 -0500", hash_original_field = "F88E98320939E0BB6F770C744F769F27", hash_generated_field = "32117231F7825C9D433CE589AA172F4C")

    public static final int KEYCODE_SETTINGS        = 176;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.823 -0500", hash_original_field = "68CD1131BBDF26B72DE5CC871A295B6F", hash_generated_field = "A563350C89DBA71E50BF90DEACEA7F8C")

    public static final int KEYCODE_TV_POWER        = 177;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.825 -0500", hash_original_field = "E5721BEAD55055AD8C88CD096E9E01F6", hash_generated_field = "8995A1762AC3B5C128D0D0EB2647BC85")

    public static final int KEYCODE_TV_INPUT        = 178;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.828 -0500", hash_original_field = "EE404D2DF9B5D631A3430F993CC3738E", hash_generated_field = "F8E75E7F7661E5FFB14404D9A734B047")

    public static final int KEYCODE_STB_POWER       = 179;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.830 -0500", hash_original_field = "E647A024F7B49F40E438C66D0E365293", hash_generated_field = "157837C488907EA0EBB9A89CD330F134")

    public static final int KEYCODE_STB_INPUT       = 180;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.833 -0500", hash_original_field = "82D847F213F6262C0E7880B4B3364368", hash_generated_field = "A8AF59437CC132191126B9326C7BB59F")

    public static final int KEYCODE_AVR_POWER       = 181;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.835 -0500", hash_original_field = "374BA041407F3A862570E3ED879793E0", hash_generated_field = "1BF31BF57DD668AE53ECC723B318781F")

    public static final int KEYCODE_AVR_INPUT       = 182;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.838 -0500", hash_original_field = "7AA3B6FFB1B0608AB9DD9F36CB1192D6", hash_generated_field = "C50055D2B0BE732D1ADCFE5E60E7F48F")

    public static final int KEYCODE_PROG_RED        = 183;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.840 -0500", hash_original_field = "E87D0DA1DF6A17AA34EC2A83DC7B204D", hash_generated_field = "F736C071D2AF124120A411A9E9BD4341")

    public static final int KEYCODE_PROG_GREEN      = 184;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.843 -0500", hash_original_field = "43F0EDEDEB25F5F6B7CB8FBBD9ECD15C", hash_generated_field = "00097C9C73776DDF440E171BB4786E11")

    public static final int KEYCODE_PROG_YELLOW     = 185;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.846 -0500", hash_original_field = "21D8120C96B3A607831ED18672662DCF", hash_generated_field = "AFE34EF29109971BC3FAE3DD327EA71B")

    public static final int KEYCODE_PROG_BLUE       = 186;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.849 -0500", hash_original_field = "B20F938FF3052F76267804B8B0D30B1B", hash_generated_field = "F32E5CCA62E47DA5CB6ED768F6984529")

    public static final int KEYCODE_APP_SWITCH      = 187;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.851 -0500", hash_original_field = "164F1868BC76210262EAD2FE47749F0A", hash_generated_field = "394AABDA6023425CD4A041238C00EC95")

    public static final int KEYCODE_BUTTON_1        = 188;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.854 -0500", hash_original_field = "0C5DF44CEC72868FB3DC21BA2C6C83D1", hash_generated_field = "4B69486DC6094DAF12CF39F02C4C1052")

    public static final int KEYCODE_BUTTON_2        = 189;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.856 -0500", hash_original_field = "4377773AC34BCC43931AB6F3E50A5A23", hash_generated_field = "6D9A2A53F672CC3E9A65CD2252190367")

    public static final int KEYCODE_BUTTON_3        = 190;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.859 -0500", hash_original_field = "6008E4C1DC2015A79327AB9A39577C10", hash_generated_field = "25702203559C5D54F4F4A0DB3D8F8069")

    public static final int KEYCODE_BUTTON_4        = 191;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.861 -0500", hash_original_field = "03E2B0B5DDD446D429FB29EEC15165AC", hash_generated_field = "E7F3149F308CC7E53E8F65DF25A94826")

    public static final int KEYCODE_BUTTON_5        = 192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.863 -0500", hash_original_field = "2E955CE20539B80DDD0FC6E98D8615AF", hash_generated_field = "1ED6FBDFA01DB2E15B0C713B5BEE0F55")

    public static final int KEYCODE_BUTTON_6        = 193;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.867 -0500", hash_original_field = "95C7D2722CD08543A3DE6DF5EB809E31", hash_generated_field = "D7B145850B009706A332264366F86FEA")

    public static final int KEYCODE_BUTTON_7        = 194;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.869 -0500", hash_original_field = "E828C2DFCF128248B820C5EA8A718B45", hash_generated_field = "F09F97296ECAA6FD5149C4FED332A8D7")

    public static final int KEYCODE_BUTTON_8        = 195;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.872 -0500", hash_original_field = "6909E0AE19E77AA47E534EC1442F20EF", hash_generated_field = "C5727DD8C40C5292179B5DF787AEA2DB")

    public static final int KEYCODE_BUTTON_9        = 196;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.874 -0500", hash_original_field = "2E3AB46152BFFA2DD0D09D7D4B52A6AE", hash_generated_field = "84293B771FF9DE8D9E1245F7EC542F63")

    public static final int KEYCODE_BUTTON_10       = 197;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.877 -0500", hash_original_field = "8F138174184C06946C7EFB2E3B732E7E", hash_generated_field = "81D4E1C463B6C0F0967232AD38E8EC39")

    public static final int KEYCODE_BUTTON_11       = 198;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.879 -0500", hash_original_field = "3B7104327574619F0469ED9189487B95", hash_generated_field = "1ECD308FB87691D0645793B4A75D7821")

    public static final int KEYCODE_BUTTON_12       = 199;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.882 -0500", hash_original_field = "350A1ED08EC8DD25E361E2B2BB1F63B8", hash_generated_field = "DA3BDD17899EF863BCD79EE0A93CE72F")

    public static final int KEYCODE_BUTTON_13       = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.884 -0500", hash_original_field = "C0DF6064A60E767FB7A0598B5A664B33", hash_generated_field = "C8792BF5955A6121B7C0CF8AFB860F09")

    public static final int KEYCODE_BUTTON_14       = 201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.887 -0500", hash_original_field = "FF20EF83C45A081E4978C7C59514EE48", hash_generated_field = "64703277F4C1BAB4CF65A279AF576ADF")

    public static final int KEYCODE_BUTTON_15       = 202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.890 -0500", hash_original_field = "2C0B84971D547892615D68A2A8A04F1A", hash_generated_field = "0230AFBBAF9CA38EAA2F93E60AD0FCFD")

    public static final int KEYCODE_BUTTON_16       = 203;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.892 -0500", hash_original_field = "90D7E7C4304A9E52C5D1144C7889DC3C", hash_generated_field = "01404943ABD1AC6B853136A1B47F1E3F")

    public static final int KEYCODE_LANGUAGE_SWITCH = 204;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.896 -0500", hash_original_field = "D9F6DFE6BC46FC220D3A5C00CCE6ADAD", hash_generated_field = "06EE9D2655D6C3A1A58CD05F94F7F499")

    public static final int KEYCODE_MANNER_MODE     = 205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.898 -0500", hash_original_field = "4B38429B96BF7A7066A42FE9D3104E85", hash_generated_field = "AC75AB32E54ED39910C713F0FF962C61")

    public static final int KEYCODE_3D_MODE         = 206;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.901 -0500", hash_original_field = "936CC1BD71F231B505C611A5E1CC79C3", hash_generated_field = "81393C443A769E5D0B9E2DE5EEA55C0D")

    public static final int KEYCODE_CONTACTS        = 207;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.903 -0500", hash_original_field = "DB8B9FD806DE5498CBAC7E135871972F", hash_generated_field = "71E25264E1D04E84E8942BF044327976")

    public static final int KEYCODE_CALENDAR        = 208;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.906 -0500", hash_original_field = "F0E3AC4D25E070685F01299A2EC2F6F8", hash_generated_field = "BF3C88E39135CC744209FEEC149C2ADF")

    public static final int KEYCODE_MUSIC           = 209;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.908 -0500", hash_original_field = "1C35A891FAEF7C549622ABB08FE4CFED", hash_generated_field = "C851640BB715C434DC738BA9253808FE")

    public static final int KEYCODE_CALCULATOR      = 210;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.911 -0500", hash_original_field = "21A478F95F691051EB15FCFF1D2A65CC", hash_generated_field = "F6A5DDFA8DC9C9559DA427D14D84C374")

    private static final int LAST_KEYCODE           = KEYCODE_CALCULATOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.914 -0500", hash_original_field = "FB7824F14F73D8E48637BF91D1ED5916", hash_generated_field = "8FB8DEEC7F201D8A94FE7147ACCBC029")

    //  isSystem()
    //  native/include/android/keycodes.h
    //  frameworks/base/include/ui/KeycodeLabels.h
    //  external/webkit/WebKit/android/plugins/ANPKeyCodes.h
    //  frameworks/base/core/res/res/values/attrs.xml
    //  emulator?
    //  LAST_KEYCODE
    //  KEYCODE_SYMBOLIC_NAMES
    //
    //  Also Android currently does not reserve code ranges for vendor-
    //  specific key codes.  If you have new key codes to have, you
    //  MUST contribute a patch to the open source project to define
    //  those new codes.  This is intended to maintain a consistent
    //  set of key code definitions across all Android devices.

    // Symbolic names of all key codes.
    private static final SparseArray<String> KEYCODE_SYMBOLIC_NAMES = new SparseArray<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.927 -0500", hash_original_field = "5605792DE5968238799E7692E7CADEBF", hash_generated_field = "2CA79EBA6974370C6F71E4201B235475")

    // Accordingly there are exactly 32 values in this table.
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.930 -0500", hash_original_field = "83670C03A2FB55F459EA219E0BBC22C4", hash_generated_field = "E29CFE04FAF452760D39B1555E3DA539")

    @Deprecated
    public static final int MAX_KEYCODE             = 84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.933 -0500", hash_original_field = "CE75AB6924C9E0A7F48169E5F0A2A68F", hash_generated_field = "B56FBABE5CC8DDE909CEA8CDE98BA93D")

    public static final int ACTION_DOWN             = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.937 -0500", hash_original_field = "FA982872F36C4639DC991EEF44D99302", hash_generated_field = "E9419BD1576C4C89CB972C93BF43E7C5")

    public static final int ACTION_UP               = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.940 -0500", hash_original_field = "B4E46473DC1265732F44F75352452BF1", hash_generated_field = "5280768339B678D3C0B5FC81EC5E3F1B")

    public static final int ACTION_MULTIPLE         = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.943 -0500", hash_original_field = "20525763C57949B29A3449B2A9B808C4", hash_generated_field = "6D1E08C6A5AE4E524201967D95640DD1")

    public static final int META_CAP_LOCKED = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.945 -0500", hash_original_field = "BD56F4544E81DA3BCD594695A435924E", hash_generated_field = "BAEF4E0228894ED6E6042DD5E283E3A8")

    public static final int META_ALT_LOCKED = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.948 -0500", hash_original_field = "C646D438A8136F80AF31CD7EC06C34E3", hash_generated_field = "5E488E5021CBDD9609C595AF0D84DAF8")

    public static final int META_SYM_LOCKED = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.950 -0500", hash_original_field = "82BA9006B3C349ABB35B5A8CC3E9D4E7", hash_generated_field = "9E11181A5D6AD5CF1D060BED4D53A38D")

    public static final int META_SELECTING = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.952 -0500", hash_original_field = "ED6784EB333AD5CB08A25DF55C273B77", hash_generated_field = "6710F5CF1A580C4BA908F9DE44D69269")

    public static final int META_ALT_ON = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.956 -0500", hash_original_field = "9AAB61A6AB22688B678C9F0FEAF1503B", hash_generated_field = "038950DB00ED30A0C2A6EA7CA387D802")

    public static final int META_ALT_LEFT_ON = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.958 -0500", hash_original_field = "DBEFA10091325E9238BAB10CEC737FBF", hash_generated_field = "2B7E2AEDA8A317216170029679D5FA3B")

    public static final int META_ALT_RIGHT_ON = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.961 -0500", hash_original_field = "DDEB2B8F5AF0EA17B425E2AC37007353", hash_generated_field = "CEF865A9A153704AB01AF0D53AFCB33B")

    public static final int META_SHIFT_ON = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.964 -0500", hash_original_field = "464B515B80B5438D89CCECE22CD688F5", hash_generated_field = "B691B04D5E9486C5D8DD77F810B6D4EB")

    public static final int META_SHIFT_LEFT_ON = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.967 -0500", hash_original_field = "BBF0550E47822C885C823B96692FA30F", hash_generated_field = "F1C6A0212FB21D9CEB1B9A92A9AAE09D")

    public static final int META_SHIFT_RIGHT_ON = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.969 -0500", hash_original_field = "340AAF1DE749609DC9C2C0F0EF755C67", hash_generated_field = "2FFDEC1D74A3F5599FE14C730D69BAA9")

    public static final int META_SYM_ON = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.972 -0500", hash_original_field = "2C98365870383FABB4C78BB627D3BDEC", hash_generated_field = "0C8C00C9836FBE3A682E91CE0D062118")

    public static final int META_FUNCTION_ON = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.975 -0500", hash_original_field = "3BD04A29EFB8DC921002E821E27997CD", hash_generated_field = "88C890EE21FF18ADBC8647F084CDC393")

    public static final int META_CTRL_ON = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.977 -0500", hash_original_field = "4C4535B07CA7AD53D4411F1F8BDDE239", hash_generated_field = "53ECB17B3D0175AF5F54E47B6597826A")

    public static final int META_CTRL_LEFT_ON = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.980 -0500", hash_original_field = "938C03DE3B66AB9B17A315DF7EE786F7", hash_generated_field = "AEE5A230C75D01795A35ABF1D0FE8129")

    public static final int META_CTRL_RIGHT_ON = 0x4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.983 -0500", hash_original_field = "6C9B243024CBCD1D733DE685DF1A36FF", hash_generated_field = "0AF47D16A49D9527E899DA14710C07E3")

    public static final int META_META_ON = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.986 -0500", hash_original_field = "F92F0F9D8834AFAFA7747E1176A511BB", hash_generated_field = "EA7EB2ABE6119E9E6AD87D0B0F5FAE53")

    public static final int META_META_LEFT_ON = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.988 -0500", hash_original_field = "CCEABB8A59EE98B2FABFA9B87FA1E933", hash_generated_field = "86E858445C20D225D6860403B12B6724")

    public static final int META_META_RIGHT_ON = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.991 -0500", hash_original_field = "CF4E68AC1F5620F00FD8A2E37015A6D2", hash_generated_field = "16BD993D31F187559A9D13A65F4B9FB7")

    public static final int META_CAPS_LOCK_ON = 0x100000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.993 -0500", hash_original_field = "C25531B976A7529F4CCBC1E1869CCD25", hash_generated_field = "4ABBC2D97836A92B9D6819070A70931F")

    public static final int META_NUM_LOCK_ON = 0x200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.996 -0500", hash_original_field = "122F84333F3016D3E0FE59F21A9FBB86", hash_generated_field = "248E0ED8289417F079704439322EB8B7")

    public static final int META_SCROLL_LOCK_ON = 0x400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:22.998 -0500", hash_original_field = "0002BF1DA1C3DD9F9D44C3DBC4975A1D", hash_generated_field = "A36A2D0A7C1D1324359E0C1FDFBF546A")

    public static final int META_SHIFT_MASK = META_SHIFT_ON
            | META_SHIFT_LEFT_ON | META_SHIFT_RIGHT_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.003 -0500", hash_original_field = "E6E48845F8D8E489133D78BDAC6AF51E", hash_generated_field = "F6655C8725A6A6600D70749777DF2F82")

    public static final int META_ALT_MASK = META_ALT_ON
            | META_ALT_LEFT_ON | META_ALT_RIGHT_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.006 -0500", hash_original_field = "DD803730C24A8C31D2CBBD4C46A22DB2", hash_generated_field = "0FFC07F5B5FF9D8EB2A9866831C8FDB9")

    public static final int META_CTRL_MASK = META_CTRL_ON
            | META_CTRL_LEFT_ON | META_CTRL_RIGHT_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.009 -0500", hash_original_field = "0FF93748D5BB5B050A8CB5FFAA8CB934", hash_generated_field = "BA47AFEFD3071E7C8C6529EB84FCC3B7")

    public static final int META_META_MASK = META_META_ON
            | META_META_LEFT_ON | META_META_RIGHT_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.011 -0500", hash_original_field = "A7FBEBACAFCC6F2BF501017D9AEBE985", hash_generated_field = "A300CC160CFE79419B3DEDCC06E71097")

    public static final int FLAG_WOKE_HERE = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.014 -0500", hash_original_field = "D8D64BAA13776B0B47F31E1F71829D1E", hash_generated_field = "4B4F9480F930564F31898860F0906503")

    public static final int FLAG_SOFT_KEYBOARD = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.016 -0500", hash_original_field = "B0871E8DD5E28B8D30A9296A8ADCBA61", hash_generated_field = "6E5F9B07C4A519AEF8BA6A06CC07768C")

    public static final int FLAG_KEEP_TOUCH_MODE = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.019 -0500", hash_original_field = "EB5FFB41E3091CC331BE3C8B60E630D1", hash_generated_field = "FC43BB2783BD04152DC976F3B0A2AEA8")

    public static final int FLAG_FROM_SYSTEM = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.022 -0500", hash_original_field = "EB645AF85D35AF423DD8B16B14311E5E", hash_generated_field = "7353455EAF673B88CA53AE815C1A8C90")

    public static final int FLAG_EDITOR_ACTION = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.025 -0500", hash_original_field = "BC4ABD76155C8F1D4C24A4580357250A", hash_generated_field = "536AAEA70D5496A245CAC1E6EDD36D4F")

    public static final int FLAG_CANCELED = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.027 -0500", hash_original_field = "B34214EA658444A141C383728E2DEF17", hash_generated_field = "D2A6E6C2D49FF41694FCFD1ECD9D9A50")

    public static final int FLAG_VIRTUAL_HARD_KEY = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.031 -0500", hash_original_field = "732C0A6A4107A8AFD0A5D2B22D19C9A6", hash_generated_field = "B994C337526288FB9487BB0BF0A7BF38")

    public static final int FLAG_LONG_PRESS = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.033 -0500", hash_original_field = "CE9FE4C2C0217ED5234D7F814E373F89", hash_generated_field = "F84442B2F3037477A654E80B75714AB9")

    public static final int FLAG_CANCELED_LONG_PRESS = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.036 -0500", hash_original_field = "C06923DC4A89D9561F72F77AE6B8AF7E", hash_generated_field = "9AC62BA5DB308EA7E59CBB8DB7167B2F")

    public static final int FLAG_TRACKING = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.038 -0500", hash_original_field = "F13192778AAD15AEC9660AA5AAD0F9FD", hash_generated_field = "7AAB31488E327D5468CB5B93A3457D06")

    public static final int FLAG_FALLBACK = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.041 -0500", hash_original_field = "AAEAB04F0AA24859AD3C4928631CE326", hash_generated_field = "FF3FE95397D860480C18423499F713D3")

    public static final int FLAG_START_TRACKING = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.043 -0500", hash_original_field = "85A63D3EE365696E199B23FBFFDAF4DD", hash_generated_field = "22C757AFB129CA98FC86BD04BEE94F98")

    public static final int FLAG_TAINTED = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.051 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")
    
    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.054 -0500", hash_original_field = "D6BC418CAB7808E9368D3E1A4A00B8B3", hash_generated_field = "0966EC22C56233A6511F81074732B996")

    static final String TAG = "KeyEvent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.056 -0500", hash_original_field = "F593DBD4ACC5DC484D76C0656C0FB27F", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.060 -0500", hash_original_field = "383C33CA63B8C16F39C24669AA7A3D08", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.062 -0500", hash_original_field = "58D63F887B2FB3C0CAE7920E9516E0C7", hash_generated_field = "695DE00CD65E15FE07938D99F2CA2696")

    private static int gRecyclerUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.064 -0500", hash_original_field = "4C8B776E11A03D7014A441AF333B826E", hash_generated_field = "1BA0711EC13B8219450F3570393E04FA")

    private static KeyEvent gRecyclerTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.194 -0500", hash_original_field = "C7978BFEE8136BCD7BDC951C4958AE05", hash_generated_field = "4521CD29BB46C30E1234E050C94D91D3")

    private static final int META_MODIFIER_MASK =
            META_SHIFT_ON | META_SHIFT_LEFT_ON | META_SHIFT_RIGHT_ON
            | META_ALT_ON | META_ALT_LEFT_ON | META_ALT_RIGHT_ON
            | META_CTRL_ON | META_CTRL_LEFT_ON | META_CTRL_RIGHT_ON
            | META_META_ON | META_META_LEFT_ON | META_META_RIGHT_ON
            | META_SYM_ON | META_FUNCTION_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.197 -0500", hash_original_field = "BFBE83381AC7CAF35C879F7D47B25ED8", hash_generated_field = "13B4B4D519F7489A4442F0417B9A2780")

    private static final int META_LOCK_MASK =
            META_CAPS_LOCK_ON | META_NUM_LOCK_ON | META_SCROLL_LOCK_ON;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.199 -0500", hash_original_field = "943CDDDC87EE8ECFC8CBFCCA3889EEFA", hash_generated_field = "6022559E1CCBA0F15118AA24C069C1ED")

    private static final int META_ALL_MASK = META_MODIFIER_MASK | META_LOCK_MASK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.202 -0500", hash_original_field = "27EC0F81E0DF97792FB503F6CE74E74F", hash_generated_field = "F5415C610CBE5460977125C384D5D5DE")

    // historical uses in MetaKeyKeyListener.
    private static final int META_SYNTHETIC_MASK =
            META_CAP_LOCKED | META_ALT_LOCKED | META_SYM_LOCKED | META_SELECTING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.205 -0500", hash_original_field = "F95D0F56BFA087AA8E274B57568E30CF", hash_generated_field = "88955F8F01A4EC1A0EF40D31E5C7F11C")

    // These bits are known to be used for purposes other than specifying modifiers.
    private static final int META_INVALID_MODIFIER_MASK =
            META_LOCK_MASK | META_SYNTHETIC_MASK;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.367 -0400", hash_original_field = "920C4A52D38CBE7E6A6542C0F9E0E2D9", hash_generated_field = "BB18ED46A8F92913C2C2DD003C5E50AA")

    public static final Parcelable.Creator<KeyEvent> CREATOR
            = new Parcelable.Creator<KeyEvent>() {
    	
        public KeyEvent createFromParcel(Parcel in) {
    		addTaint(in.getTaint());
            in.readInt(); 
            KeyEvent retVal = KeyEvent.createFromParcelBody(in);
    		retVal.addTaint(getTaint());
            return retVal;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.357 -0500", hash_original_method = "E80AF5B6F571FF175C6A1543B8645012", hash_generated_method = "7543369443460D188D22745732ABA234")
        
public KeyEvent[] newArray(int size) {
            return new KeyEvent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.067 -0500", hash_original_field = "7281A38783B56E66F896B056FE68BC9E", hash_generated_field = "A21260B04ED5B32DBDB0093B175D9F6A")

    private KeyEvent mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.069 -0500", hash_original_field = "54377D1FA2AD41427FB83B9E454546B7", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.071 -0500", hash_original_field = "9C5D5B4697BA4F2BAA6617B930737C8B", hash_generated_field = "AE8D59B3F804A7C4665D164A31D2B414")

    private int mDeviceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.074 -0500", hash_original_field = "11DA1CE39E46044FC7D0DA0865E06F43", hash_generated_field = "D564CAA4C2DB0DC0AAAD32F1767ED66A")

    private int mSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.076 -0500", hash_original_field = "2707C27F30BB3421B24DB98367DD2B08", hash_generated_field = "5788BD80C680CA2939C7A313728CCB63")

    private int mMetaState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.079 -0500", hash_original_field = "87F72266090A426F9B25050359B17309", hash_generated_field = "3956BA6D0CE8EE1BF5FC1D59E23F807A")

    private int mAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.081 -0500", hash_original_field = "775BFC50F46781234F24C3F19B2FA89F", hash_generated_field = "6029AC817F6EE7A2286BA05155E91FE2")

    private int mKeyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.083 -0500", hash_original_field = "87BC6EA925BFCD06DCF9DF8989E3E12F", hash_generated_field = "CE155A0F438E428C3DB8864C35950D08")

    private int mScanCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.085 -0500", hash_original_field = "7AD638399407A3C8C04B60544AD7C050", hash_generated_field = "5BB8D24C9FBE77141A5AB3C9B511ACFF")

    private int mRepeatCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.088 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "43F71E9173849705E01112D0229448B4")

    private int mFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.091 -0500", hash_original_field = "97A1F85F424A59AC2C3BE90DCD16D4EA", hash_generated_field = "81CDF43B84B5DBDAAD8AA19BDADDFBB2")

    private long mDownTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.094 -0500", hash_original_field = "235018A2B2200C1EFF286CCDC9DEE735", hash_generated_field = "D6C2226ACD561C7062177E3F0AB4BB2A")

    private long mEventTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.096 -0500", hash_original_field = "3FF6DDEFCA2B5DBF237642E16E9B7195", hash_generated_field = "1B791AACABCED1A688CA7D7F3414CCF4")

    private String mCharacters;
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.320 -0400", hash_original_method = "E1777BC70B96D5008D693732650D9927", hash_generated_method = "560F8A7FDE8C5C12025FD3A840761BDA")
    public  KeyEvent() {
        // ---------- Original Method ----------
    }

    /**
     * Create a new key event.
     * 
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.105 -0500", hash_original_method = "CD3F04ECBB2EC92C58F1141FB07383F6", hash_generated_method = "7509218E07DB23DEEBB2B9ADF8607D42")
    
public KeyEvent(int action, int code) {
        mAction = action;
        mKeyCode = code;
        mRepeatCount = 0;
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    /**
     * Create a new key event.
     * 
     * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this key code originally went down.
     * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event happened.
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     * @param repeat A repeat count for down events (> 0 if this is after the
     * initial down) or event count for multiple events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.108 -0500", hash_original_method = "460E02BA0A36D9C6A0F4AFF64D96FF32", hash_generated_method = "094D22C3B8409EF949D76183C15D479D")
    
public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat) {
        mDownTime = downTime;
        mEventTime = eventTime;
        mAction = action;
        mKeyCode = code;
        mRepeatCount = repeat;
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    /**
     * Create a new key event.
     * 
     * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this key code originally went down.
     * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event happened.
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     * @param repeat A repeat count for down events (> 0 if this is after the
     * initial down) or event count for multiple events.
     * @param metaState Flags indicating which meta keys are currently pressed.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.111 -0500", hash_original_method = "25AD2761B1583202D71C2F5EBFFC872D", hash_generated_method = "69582AB8397B519D69D2F4FAB99E0C11")
    
public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState) {
        mDownTime = downTime;
        mEventTime = eventTime;
        mAction = action;
        mKeyCode = code;
        mRepeatCount = repeat;
        mMetaState = metaState;
        mDeviceId = KeyCharacterMap.VIRTUAL_KEYBOARD;
    }

    /**
     * Create a new key event.
     * 
     * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this key code originally went down.
     * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event happened.
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     * @param repeat A repeat count for down events (> 0 if this is after the
     * initial down) or event count for multiple events.
     * @param metaState Flags indicating which meta keys are currently pressed.
     * @param deviceId The device ID that generated the key event.
     * @param scancode Raw device scan code of the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.114 -0500", hash_original_method = "A71C4CD2E48CE8A2B595D45DAD40720E", hash_generated_method = "03FAAE89FE9FB669C2159708F7671EA3")
    
public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode) {
        mDownTime = downTime;
        mEventTime = eventTime;
        mAction = action;
        mKeyCode = code;
        mRepeatCount = repeat;
        mMetaState = metaState;
        mDeviceId = deviceId;
        mScanCode = scancode;
    }

    /**
     * Create a new key event.
     * 
     * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this key code originally went down.
     * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event happened.
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     * @param repeat A repeat count for down events (> 0 if this is after the
     * initial down) or event count for multiple events.
     * @param metaState Flags indicating which meta keys are currently pressed.
     * @param deviceId The device ID that generated the key event.
     * @param scancode Raw device scan code of the event.
     * @param flags The flags for this key event
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.117 -0500", hash_original_method = "8535C41697CC0C68061B8A72D476CEA4", hash_generated_method = "732D65DCC53B82935E7ECEFEAD22E169")
    
public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode, int flags) {
        mDownTime = downTime;
        mEventTime = eventTime;
        mAction = action;
        mKeyCode = code;
        mRepeatCount = repeat;
        mMetaState = metaState;
        mDeviceId = deviceId;
        mScanCode = scancode;
        mFlags = flags;
    }

    /**
     * Create a new key event.
     * 
     * @param downTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this key code originally went down.
     * @param eventTime The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event happened.
     * @param action Action code: either {@link #ACTION_DOWN},
     * {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * @param code The key code.
     * @param repeat A repeat count for down events (> 0 if this is after the
     * initial down) or event count for multiple events.
     * @param metaState Flags indicating which meta keys are currently pressed.
     * @param deviceId The device ID that generated the key event.
     * @param scancode Raw device scan code of the event.
     * @param flags The flags for this key event
     * @param source The input source such as {@link InputDevice#SOURCE_KEYBOARD}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.120 -0500", hash_original_method = "7235AB46A09763BE60DBC1995AF7FBA4", hash_generated_method = "9C543A2ADBDB20E5C24730882C83C053")
    
public KeyEvent(long downTime, long eventTime, int action,
                    int code, int repeat, int metaState,
                    int deviceId, int scancode, int flags, int source) {
        mDownTime = downTime;
        mEventTime = eventTime;
        mAction = action;
        mKeyCode = code;
        mRepeatCount = repeat;
        mMetaState = metaState;
        mDeviceId = deviceId;
        mScanCode = scancode;
        mFlags = flags;
        mSource = source;
    }

    /**
     * Create a new key event for a string of characters.  The key code,
     * action, repeat count and source will automatically be set to
     * {@link #KEYCODE_UNKNOWN}, {@link #ACTION_MULTIPLE}, 0, and
     * {@link InputDevice#SOURCE_KEYBOARD} for you.
     * 
     * @param time The time (in {@link android.os.SystemClock#uptimeMillis})
     * at which this event occured.
     * @param characters The string of characters.
     * @param deviceId The device ID that generated the key event.
     * @param flags The flags for this key event
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.123 -0500", hash_original_method = "6373116C9B5FF479EB0DF8409EEE5FFB", hash_generated_method = "8130CC4F0475CF1231A7C3AC6006E004")
    
public KeyEvent(long time, String characters, int deviceId, int flags) {
        mDownTime = time;
        mEventTime = time;
        mCharacters = characters;
        mAction = ACTION_MULTIPLE;
        mKeyCode = KEYCODE_UNKNOWN;
        mRepeatCount = 0;
        mDeviceId = deviceId;
        mFlags = flags;
        mSource = InputDevice.SOURCE_KEYBOARD;
    }

    /**
     * Make an exact copy of an existing key event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.126 -0500", hash_original_method = "DBCE0965BBC4352F0EBDFBB71CBA04FA", hash_generated_method = "023355A25F5463CF69A111C0003A1512")
    
public KeyEvent(KeyEvent origEvent) {
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
    }

    /**
     * Copy an existing key event, modifying its time and repeat count.
     * 
     * @deprecated Use {@link #changeTimeRepeat(KeyEvent, long, int)}
     * instead.
     * 
     * @param origEvent The existing event to be copied.
     * @param eventTime The new event time
     * (in {@link android.os.SystemClock#uptimeMillis}) of the event.
     * @param newRepeat The new repeat count of the event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.129 -0500", hash_original_method = "1712784D81B05F738E3678B0ED7626EA", hash_generated_method = "1E7AE76B1D9B3816AC5455E7F221B646")
    
@Deprecated
    public KeyEvent(KeyEvent origEvent, long eventTime, int newRepeat) {
        mDownTime = origEvent.mDownTime;
        mEventTime = eventTime;
        mAction = origEvent.mAction;
        mKeyCode = origEvent.mKeyCode;
        mRepeatCount = newRepeat;
        mMetaState = origEvent.mMetaState;
        mDeviceId = origEvent.mDeviceId;
        mSource = origEvent.mSource;
        mScanCode = origEvent.mScanCode;
        mFlags = origEvent.mFlags;
        mCharacters = origEvent.mCharacters;
    }
    
    /**
     * Copy an existing key event, modifying its action.
     * 
     * @param origEvent The existing event to be copied.
     * @param action The new action code of the event.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.152 -0500", hash_original_method = "5AF6098C2FF410C0A9EE2BEE9470EC38", hash_generated_method = "5F4343F14C0E163B76CF16F46FC93D8E")
    
private KeyEvent(KeyEvent origEvent, int action) {
        mDownTime = origEvent.mDownTime;
        mEventTime = origEvent.mEventTime;
        mAction = action;
        mKeyCode = origEvent.mKeyCode;
        mRepeatCount = origEvent.mRepeatCount;
        mMetaState = origEvent.mMetaState;
        mDeviceId = origEvent.mDeviceId;
        mSource = origEvent.mSource;
        mScanCode = origEvent.mScanCode;
        mFlags = origEvent.mFlags;
        // Don't copy mCharacters, since one way or the other we'll lose it
        // when changing the action.
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.366 -0500", hash_original_method = "6CD21CCD9028EF5AE389AE8F77253E73", hash_generated_method = "BC486B529C1ABEDFC019C5195C47ECA9")
    
private KeyEvent(Parcel in) {
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
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.142 -0500", hash_original_method = "71F28D5E8589FEEEB25F09C6B26D40EA", hash_generated_method = "0DC7255C830BF95B7E80E0682969324B")
    
@Override
    public KeyEvent copy() {
        return obtain(this);
    }

    /**
     * Recycles a key event.
     * Key events should only be recycled if they are owned by the system since user
     * code expects them to be essentially immutable, "tracking" notwithstanding.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.144 -0500", hash_original_method = "6B64621545DE4A3A123816F2DEDFC8C2", hash_generated_method = "311EF9D923328349C899A3F659837300")
    
public final void recycle() {
    /*    if (mRecycled) {
            throw new RuntimeException(toString() + " recycled twice!");
        }
        mRecycled = true;
        mCharacters = null;

        synchronized (gRecyclerLock) {
            if (gRecyclerUsed < MAX_RECYCLED) {
                gRecyclerUsed++;
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            }
        }*/
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.161 -0500", hash_original_method = "F86D8C7B1180DE3A66C7F2BDF135A8B2", hash_generated_method = "49DB4EA975B1A17E5B371079B2010931")
    
@Override
    public final boolean isTainted() {
        return (mFlags & FLAG_TAINTED) != 0;
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.164 -0500", hash_original_method = "BF13334B6C13BDDF4754612AD733986A", hash_generated_method = "85F9A34EFE22DA19FEBE1D016802192E")
    
@Override
    public final void setTainted(boolean tainted) {
        mFlags = tainted ? mFlags | FLAG_TAINTED : mFlags & ~FLAG_TAINTED;
    }

    /**
     * Don't use in new code, instead explicitly check
     * {@link #getAction()}.
     * 
     * @return If the action is ACTION_DOWN, returns true; else false.
     *
     * @deprecated
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.167 -0500", hash_original_method = "CB44DB443D68CB8A4DB0177D0C026F61", hash_generated_method = "C4F9DFBC6591548338A15429C14ACB03")
    
@Deprecated public final boolean isDown() {
        return mAction == ACTION_DOWN;
    }

    /**
     * Is this a system key?  System keys can not be used for menu shortcuts.
     * 
     * TODO: this information should come from a table somewhere.
     * TODO: should the dpad keys be here?  arguably, because they also shouldn't be menu shortcuts
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.169 -0500", hash_original_method = "CAD37C193D4DCF9F544C4B94A265DB37", hash_generated_method = "1BE15F1ADD63B4667DF238781E8B6812")
    
public final boolean isSystem() {
        return native_isSystemKey(mKeyCode);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.171 -0500", hash_original_method = "FEBEE3014E41544B75A2E175FCF48721", hash_generated_method = "1BD96449B02255CBA097A2EF1DBEEE38")
    
public final boolean hasDefaultAction() {
        return native_hasDefaultAction(mKeyCode);
    }

    /** {@inheritDoc} */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.177 -0500", hash_original_method = "7BF185CA9C1C463FC99CEDE50E8D63D5", hash_generated_method = "0B4A00C0A40FF6327D681F173F9B5FBC")
    
@Override
    public final int getDeviceId() {
        return mDeviceId;
    }

    /** {@inheritDoc} */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.180 -0500", hash_original_method = "7037355E864C633C32E117AF9FFED93E", hash_generated_method = "ABE9C5FC45AFA595DED1F34B199308DE")
    
@Override
    public final int getSource() {
        return mSource;
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.183 -0500", hash_original_method = "38516F33934E20A73DA8FE7BA747BA99", hash_generated_method = "D638318F0D688A899AFCA554AFF53B8A")
    
@Override
    public final void setSource(int source) {
        mSource = source;
    }

    /**
     * <p>Returns the state of the meta keys.</p>
     *
     * @return an integer in which each bit set to 1 represents a pressed
     *         meta key
     *
     * @see #isAltPressed()
     * @see #isShiftPressed()
     * @see #isSymPressed()
     * @see #isCtrlPressed()
     * @see #isMetaPressed()
     * @see #isFunctionPressed()
     * @see #isCapsLockOn()
     * @see #isNumLockOn()
     * @see #isScrollLockOn()
     * @see #META_ALT_ON
     * @see #META_ALT_LEFT_ON
     * @see #META_ALT_RIGHT_ON
     * @see #META_SHIFT_ON
     * @see #META_SHIFT_LEFT_ON
     * @see #META_SHIFT_RIGHT_ON
     * @see #META_SYM_ON
     * @see #META_FUNCTION_ON
     * @see #META_CTRL_ON
     * @see #META_CTRL_LEFT_ON
     * @see #META_CTRL_RIGHT_ON
     * @see #META_META_ON
     * @see #META_META_LEFT_ON
     * @see #META_META_RIGHT_ON
     * @see #META_CAPS_LOCK_ON
     * @see #META_NUM_LOCK_ON
     * @see #META_SCROLL_LOCK_ON
     * @see #getModifiers
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.185 -0500", hash_original_method = "8A0F7162152E6ECED85F47A14B4B5FFC", hash_generated_method = "78D86D905B6385129B1C9EEB9CFA8449")
    
public final int getMetaState() {
        return mMetaState;
    }

    /**
     * Returns the state of the modifier keys.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function specifically masks out
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p><p>
     * The value returned consists of the meta state (from {@link #getMetaState})
     * normalized using {@link #normalizeMetaState(int)} and then masked with
     * {@link #getModifierMetaStateMask} so that only valid modifier bits are retained.
     * </p>
     *
     * @return An integer in which each bit set to 1 represents a pressed modifier key.
     * @see #getMetaState
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.188 -0500", hash_original_method = "B496E7302AF88C4E63C665D5FB521FB2", hash_generated_method = "84EBAB4E34F233EBE7A28D858231D4A0")
    
public final int getModifiers() {
        return normalizeMetaState(mMetaState) & META_MODIFIER_MASK;
    }

    /**
     * Returns the flags for this key event.
     *
     * @see #FLAG_WOKE_HERE
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.191 -0500", hash_original_method = "CE8F8E5E4A30C515D6BD9049A49703B9", hash_generated_method = "3A2F6A67E8ED8BF6BEBC7DB17273651D")
    
public final int getFlags() {
        return mFlags;
    }

    /**
     * Returns true if no modifier keys are pressed.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function ignores
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p><p>
     * The meta state is normalized prior to comparison using {@link #normalizeMetaState(int)}.
     * </p>
     *
     * @return True if no modifier keys are pressed.
     * @see #metaStateHasNoModifiers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.225 -0500", hash_original_method = "D8034B11074E9047AA16AF8491DBD005", hash_generated_method = "AFA1AD9D1526A22EA60FE226EDBE91C1")
    
public final boolean hasNoModifiers() {
        return metaStateHasNoModifiers(mMetaState);
    }

    /**
     * Returns true if only the specified modifiers keys are pressed.
     * Returns false if a different combination of modifier keys are pressed.
     * <p>
     * For the purposes of this function, {@link #KEYCODE_CAPS_LOCK},
     * {@link #KEYCODE_SCROLL_LOCK}, and {@link #KEYCODE_NUM_LOCK} are
     * not considered modifier keys.  Consequently, this function ignores
     * {@link #META_CAPS_LOCK_ON}, {@link #META_SCROLL_LOCK_ON} and {@link #META_NUM_LOCK_ON}.
     * </p><p>
     * If the specified modifier mask includes directional modifiers, such as
     * {@link #META_SHIFT_LEFT_ON}, then this method ensures that the
     * modifier is pressed on that side.
     * If the specified modifier mask includes non-directional modifiers, such as
     * {@link #META_SHIFT_ON}, then this method ensures that the modifier
     * is pressed on either side.
     * If the specified modifier mask includes both directional and non-directional modifiers
     * for the same type of key, such as {@link #META_SHIFT_ON} and {@link #META_SHIFT_LEFT_ON},
     * then this method throws an illegal argument exception.
     * </p>
     *
     * @param modifiers The meta state of the modifier keys to check.  May be a combination
     * of modifier meta states as defined by {@link #getModifierMetaStateMask()}.  May be 0 to
     * ensure that no modifier keys are pressed.
     * @return True if only the specified modifier keys are pressed.
     * @throws IllegalArgumentException if the modifiers parameter contains invalid modifiers
     * @see #metaStateHasModifiers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.228 -0500", hash_original_method = "4E7169ABB8BE0091A9032E5C93093788", hash_generated_method = "C6B8E64BB572C51D948C8CE3E5CC9DF4")
    
public final boolean hasModifiers(int modifiers) {
        return metaStateHasModifiers(mMetaState, modifiers);
    }

    /**
     * <p>Returns the pressed state of the ALT meta key.</p>
     *
     * @return true if the ALT key is pressed, false otherwise
     *
     * @see #KEYCODE_ALT_LEFT
     * @see #KEYCODE_ALT_RIGHT
     * @see #META_ALT_ON
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.230 -0500", hash_original_method = "97586FBB5F886A3B61BF136A6C082407", hash_generated_method = "7B0913A521E93CC952C8B98D17B0A583")
    
public final boolean isAltPressed() {
        return (mMetaState & META_ALT_ON) != 0;
    }

    /**
     * <p>Returns the pressed state of the SHIFT meta key.</p>
     *
     * @return true if the SHIFT key is pressed, false otherwise
     *
     * @see #KEYCODE_SHIFT_LEFT
     * @see #KEYCODE_SHIFT_RIGHT
     * @see #META_SHIFT_ON
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.233 -0500", hash_original_method = "CCAFE012B2273AEF4F41D4D6D0D204B5", hash_generated_method = "1CCA673789072683B3CF10664704A170")
    
public final boolean isShiftPressed() {
        return (mMetaState & META_SHIFT_ON) != 0;
    }

    /**
     * <p>Returns the pressed state of the SYM meta key.</p>
     *
     * @return true if the SYM key is pressed, false otherwise
     *
     * @see #KEYCODE_SYM
     * @see #META_SYM_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.235 -0500", hash_original_method = "FD9A49039B892920252DA37B3D678A2D", hash_generated_method = "7CD7EF126D3C5739B4100EC6444C0006")
    
public final boolean isSymPressed() {
        return (mMetaState & META_SYM_ON) != 0;
    }

    /**
     * <p>Returns the pressed state of the CTRL meta key.</p>
     *
     * @return true if the CTRL key is pressed, false otherwise
     *
     * @see #KEYCODE_CTRL_LEFT
     * @see #KEYCODE_CTRL_RIGHT
     * @see #META_CTRL_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.237 -0500", hash_original_method = "3C82500C516E1BE610D84AED68B433EB", hash_generated_method = "98DC315D01D68214ACAB70C36A61DE51")
    
public final boolean isCtrlPressed() {
        return (mMetaState & META_CTRL_ON) != 0;
    }

    /**
     * <p>Returns the pressed state of the META meta key.</p>
     *
     * @return true if the META key is pressed, false otherwise
     *
     * @see #KEYCODE_META_LEFT
     * @see #KEYCODE_META_RIGHT
     * @see #META_META_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.240 -0500", hash_original_method = "465B8FC61E3DBB23D441220EDBBD9D13", hash_generated_method = "307449BD3ACB0E47DCD5ECD304DC8DDB")
    
public final boolean isMetaPressed() {
        return (mMetaState & META_META_ON) != 0;
    }

    /**
     * <p>Returns the pressed state of the FUNCTION meta key.</p>
     *
     * @return true if the FUNCTION key is pressed, false otherwise
     *
     * @see #KEYCODE_FUNCTION
     * @see #META_FUNCTION_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.243 -0500", hash_original_method = "86852117C33E9887622BE81AA6AFA717", hash_generated_method = "930B22DA23019246BE887C67EDD62B21")
    
public final boolean isFunctionPressed() {
        return (mMetaState & META_FUNCTION_ON) != 0;
    }

    /**
     * <p>Returns the locked state of the CAPS LOCK meta key.</p>
     *
     * @return true if the CAPS LOCK key is on, false otherwise
     *
     * @see #KEYCODE_CAPS_LOCK
     * @see #META_CAPS_LOCK_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.245 -0500", hash_original_method = "201DC9EDE3268FF70DC9BB453F3746A4", hash_generated_method = "BD44F516E5F7EF59A04348D7AD62BF57")
    
public final boolean isCapsLockOn() {
        return (mMetaState & META_CAPS_LOCK_ON) != 0;
    }

    /**
     * <p>Returns the locked state of the NUM LOCK meta key.</p>
     *
     * @return true if the NUM LOCK key is on, false otherwise
     *
     * @see #KEYCODE_NUM_LOCK
     * @see #META_NUM_LOCK_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.247 -0500", hash_original_method = "F23D7F96DFD52760380CADC49A40315B", hash_generated_method = "79889CCBD44E0EC15C5BA261576D5510")
    
public final boolean isNumLockOn() {
        return (mMetaState & META_NUM_LOCK_ON) != 0;
    }

    /**
     * <p>Returns the locked state of the SCROLL LOCK meta key.</p>
     *
     * @return true if the SCROLL LOCK key is on, false otherwise
     *
     * @see #KEYCODE_SCROLL_LOCK
     * @see #META_SCROLL_LOCK_ON
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.249 -0500", hash_original_method = "F7BF6BCE6DBC769F104CFC5352A06C66", hash_generated_method = "61FAF8EFD28D88B53CCF0A0108EE1E40")
    
public final boolean isScrollLockOn() {
        return (mMetaState & META_SCROLL_LOCK_ON) != 0;
    }

    /**
     * Retrieve the action of this key event.  May be either
     * {@link #ACTION_DOWN}, {@link #ACTION_UP}, or {@link #ACTION_MULTIPLE}.
     * 
     * @return The event action: ACTION_DOWN, ACTION_UP, or ACTION_MULTIPLE.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.251 -0500", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "76861B724DE778DC880D3D0375E21B8D")
    
public final int getAction() {
        return mAction;
    }

    /**
     * For {@link #ACTION_UP} events, indicates that the event has been
     * canceled as per {@link #FLAG_CANCELED}.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.254 -0500", hash_original_method = "67F2F19B4B996A0666B0A05E347C8968", hash_generated_method = "73A43E898178BA57C38A48FDF2CA8C20")
    
public final boolean isCanceled() {
        return (mFlags&FLAG_CANCELED) != 0;
    }
    
    /**
     * Call this during {@link Callback#onKeyDown} to have the system track
     * the key through its final up (possibly including a long press).  Note
     * that only one key can be tracked at a time -- if another key down
     * event is received while a previous one is being tracked, tracking is
     * stopped on the previous event.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.257 -0500", hash_original_method = "27796C2FEC9179970B535474C3BFAAB9", hash_generated_method = "6071FAB17E9EF98C52C9B45C7AF05744")
    
public final void startTracking() {
        mFlags |= FLAG_START_TRACKING;
    }
    
    /**
     * For {@link #ACTION_UP} events, indicates that the event is still being
     * tracked from its initial down event as per
     * {@link #FLAG_TRACKING}.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.260 -0500", hash_original_method = "D30D10CBEE1B4F7DBBD65FEDA5F644C1", hash_generated_method = "DBE0A3A4DB9003B3AFA7090D6FE625D7")
    
public final boolean isTracking() {
        return (mFlags&FLAG_TRACKING) != 0;
    }
    
    /**
     * For {@link #ACTION_DOWN} events, indicates that the event has been
     * canceled as per {@link #FLAG_LONG_PRESS}.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.262 -0500", hash_original_method = "AC7740C0A8B7B97C4388CB1808E16854", hash_generated_method = "D9615C8625B57D85D394106FAA71C912")
    
public final boolean isLongPress() {
        return (mFlags&FLAG_LONG_PRESS) != 0;
    }
    
    /**
     * Retrieve the key code of the key event.  This is the physical key that
     * was pressed, <em>not</em> the Unicode character.
     * 
     * @return The key code of the event.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.265 -0500", hash_original_method = "AA2A4756B9F9E3EBD53F7A185B310C03", hash_generated_method = "5529A683B3D9F1E49CF91B4CB6E54CBC")
    
public final int getKeyCode() {
        return mKeyCode;
    }

    /**
     * For the special case of a {@link #ACTION_MULTIPLE} event with key
     * code of {@link #KEYCODE_UNKNOWN}, this is a raw string of characters
     * associated with the event.  In all other cases it is null.
     * 
     * @return Returns a String of 1 or more characters associated with
     * the event.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.267 -0500", hash_original_method = "E7E0F27294714D41CE9B0DB8FACE7352", hash_generated_method = "7EEF7FA6F099A474C3BC1AD761880753")
    
public final String getCharacters() {
        return mCharacters;
    }
    
    /**
     * Retrieve the hardware key id of this key event.  These values are not
     * reliable and vary from device to device.
     *
     * {@more}
     * Mostly this is here for debugging purposes.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.270 -0500", hash_original_method = "C59C82C828E55FB1935E12A0581D4304", hash_generated_method = "2007E406BBAE950CFEE9A9D624D4458C")
    
public final int getScanCode() {
        return mScanCode;
    }

    /**
     * Retrieve the repeat count of the event.  For both key up and key down
     * events, this is the number of times the key has repeated with the first
     * down starting at 0 and counting up from there.  For multiple key
     * events, this is the number of down/up pairs that have occurred.
     * 
     * @return The number of times the key has repeated.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.272 -0500", hash_original_method = "4FE747AC8B0667617AE307ECFC6ED74A", hash_generated_method = "BF1FFFF7864A26F75F1F53545CCD4C5A")
    
public final int getRepeatCount() {
        return mRepeatCount;
    }

    /**
     * Retrieve the time of the most recent key down event,
     * in the {@link android.os.SystemClock#uptimeMillis} time base.  If this
     * is a down event, this will be the same as {@link #getEventTime()}.
     * Note that when chording keys, this value is the down time of the
     * most recently pressed key, which may <em>not</em> be the same physical
     * key of this event.
     * 
     * @return Returns the most recent key down time, in the
     * {@link android.os.SystemClock#uptimeMillis} time base
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.274 -0500", hash_original_method = "78B33B0396971A0CFD2DA3075372AEE4", hash_generated_method = "1E18E7D44158952E23CA627C30EE7909")
    
public final long getDownTime() {
        return mDownTime;
    }

    /**
     * Retrieve the time this event occurred, 
     * in the {@link android.os.SystemClock#uptimeMillis} time base.
     * 
     * @return Returns the time this event occurred, 
     * in the {@link android.os.SystemClock#uptimeMillis} time base.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.277 -0500", hash_original_method = "9909149D86C7172035BFD4D31C880F99", hash_generated_method = "FFD024D4791F2C5768014ED38CE2494E")
    
public final long getEventTime() {
        return mEventTime;
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.279 -0500", hash_original_method = "E19EE848225D9E04BF4931E6C8BABFAF", hash_generated_method = "EDEDB87272C4B1BDD7DF4140A9B1E9BB")
    
@Override
    public final long getEventTimeNano() {
        return mEventTime * 1000000L;
    }

    /**
     * Renamed to {@link #getDeviceId}.
     * 
     * @hide
     * @deprecated use {@link #getDeviceId()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.282 -0500", hash_original_method = "DAE3D173E797B2BC058CC137FF578309", hash_generated_method = "81F0E0D78AA47DE812A82693A542D0DE")
    
@Deprecated
    public final int getKeyboardDevice() {
        return mDeviceId;
    }

    /**
     * Gets the {@link KeyCharacterMap} associated with the keyboard device.
     *
     * @return The associated key character map.
     * @throws {@link KeyCharacterMap.UnavailableException} if the key character map
     * could not be loaded because it was malformed or the default key character map
     * is missing from the system.
     *
     * @see KeyCharacterMap#load
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.284 -0500", hash_original_method = "E25038BBE92ACBB5F3F6678AD9978C07", hash_generated_method = "BF6AA37F226163A9412E47744BE1920D")
    
public final KeyCharacterMap getKeyCharacterMap() {
        return KeyCharacterMap.load(mDeviceId);
    }

    /**
     * Gets the primary character for this key.
     * In other words, the label that is physically printed on it.
     *
     * @return The display label character, or 0 if none (eg. for non-printing keys).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.287 -0500", hash_original_method = "709AF61B9CAC868190EE8F0D7699E677", hash_generated_method = "E98422D9353029B80B7959DC4F844319")
    
public char getDisplayLabel() {
        return getKeyCharacterMap().getDisplayLabel(mKeyCode);
    }
    
    /**
     * Gets the Unicode character generated by the specified key and meta
     * key state combination.
     * <p>
     * Returns the Unicode character that the specified key would produce
     * when the specified meta bits (see {@link MetaKeyKeyListener})
     * were active.
     * </p><p>
     * Returns 0 if the key is not one that is used to type Unicode
     * characters.
     * </p><p>
     * If the return value has bit {@link KeyCharacterMap#COMBINING_ACCENT} set, the
     * key is a "dead key" that should be combined with another to
     * actually produce a character -- see {@link KeyCharacterMap#getDeadChar} --
     * after masking with {@link KeyCharacterMap#COMBINING_ACCENT_MASK}.
     * </p>
     *
     * @return The associated character or combining accent, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.289 -0500", hash_original_method = "057CF77E1E85F6DA27F89D2E60B0B1BA", hash_generated_method = "4DFD6AFF77D5FB7569A3D60D43BEF66D")
    
public int getUnicodeChar() {
        return getUnicodeChar(mMetaState);
    }
    
    /**
     * Gets the Unicode character generated by the specified key and meta
     * key state combination.
     * <p>
     * Returns the Unicode character that the specified key would produce
     * when the specified meta bits (see {@link MetaKeyKeyListener})
     * were active.
     * </p><p>
     * Returns 0 if the key is not one that is used to type Unicode
     * characters.
     * </p><p>
     * If the return value has bit {@link KeyCharacterMap#COMBINING_ACCENT} set, the
     * key is a "dead key" that should be combined with another to
     * actually produce a character -- see {@link KeyCharacterMap#getDeadChar} --
     * after masking with {@link KeyCharacterMap#COMBINING_ACCENT_MASK}.
     * </p>
     *
     * @param metaState The meta key modifier state.
     * @return The associated character or combining accent, or 0 if none.
     */
    @DSComment("data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.291 -0500", hash_original_method = "BE11FB783D347EE88A5E4A6075D1C256", hash_generated_method = "DF5709942362126343272935B1D1CC5E")
    
public int getUnicodeChar(int metaState) {
        return getKeyCharacterMap().get(mKeyCode, metaState);
    }
    
    /**
     * Get the character conversion data for a given key code.
     *
     * @param results A {@link KeyCharacterMap.KeyData} instance that will be
     * filled with the results.
     * @return True if the key was mapped.  If the key was not mapped, results is not modified.
     *
     * @deprecated instead use {@link #getDisplayLabel()},
     * {@link #getNumber()} or {@link #getUnicodeChar(int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.294 -0500", hash_original_method = "81320F663D2FF6F236DC3275D51EA69E", hash_generated_method = "D7345B209749D15645A4A435083714E9")
    
@Deprecated
    public boolean getKeyData(KeyData results) {
        return getKeyCharacterMap().getKeyData(mKeyCode, results);
    }
    
    /**
     * Gets the first character in the character array that can be generated
     * by the specified key code.
     * <p>
     * This is a convenience function that returns the same value as
     * {@link #getMatch(char[],int) getMatch(chars, 0)}.
     * </p>
     *
     * @param chars The array of matching characters to consider.
     * @return The matching associated character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.296 -0500", hash_original_method = "BA318507FAF878809BC342F154CE9211", hash_generated_method = "3B628DD8A12CEC5701D84D780D4E9283")
    
public char getMatch(char[] chars) {
        return getMatch(chars, 0);
    }
    
    /**
     * Gets the first character in the character array that can be generated
     * by the specified key code.  If there are multiple choices, prefers
     * the one that would be generated with the specified meta key modifier state.
     *
     * @param chars The array of matching characters to consider.
     * @param metaState The preferred meta key modifier state.
     * @return The matching associated character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.298 -0500", hash_original_method = "37D22A361AC08A8D1E1BFBF631093A43", hash_generated_method = "E042118E235B800177537C4F85817395")
    
public char getMatch(char[] chars, int metaState) {
        return getKeyCharacterMap().getMatch(mKeyCode, chars, metaState);
    }
    
    /**
     * Gets the number or symbol associated with the key.
     * <p>
     * The character value is returned, not the numeric value.
     * If the key is not a number, but is a symbol, the symbol is retuned.
     * </p><p>
     * This method is intended to to support dial pads and other numeric or
     * symbolic entry on keyboards where certain keys serve dual function
     * as alphabetic and symbolic keys.  This method returns the number
     * or symbol associated with the key independent of whether the user
     * has pressed the required modifier.
     * </p><p>
     * For example, on one particular keyboard the keys on the top QWERTY row generate
     * numbers when ALT is pressed such that ALT-Q maps to '1'.  So for that keyboard
     * when {@link #getNumber} is called with {@link KeyEvent#KEYCODE_Q} it returns '1'
     * so that the user can type numbers without pressing ALT when it makes sense.
     * </p>
     *
     * @return The associated numeric or symbolic character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.301 -0500", hash_original_method = "8EE0DA8E3FFF6281CC8C4E46B5174FE9", hash_generated_method = "258AB9D5DB83D1ACF7169B6B20C3F432")
    
public char getNumber() {
        return getKeyCharacterMap().getNumber(mKeyCode);
    }
    
    /**
     * Returns true if this key produces a glyph.
     *
     * @return True if the key is a printing key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.303 -0500", hash_original_method = "FD8BA26A71313E51F3A862B0A656FF64", hash_generated_method = "33E789FEF86241FBAA8D986BBCA038F7")
    
public boolean isPrintingKey() {
        return getKeyCharacterMap().isPrintingKey(mKeyCode);
    }
    static {
        populateKeycodeSymbolicNames();
    }
    
    /**
     * @deprecated Use {@link #dispatch(Callback, DispatcherState, Object)} instead.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.306 -0500", hash_original_method = "1A3310CD4FC6031A54E66A6FF268F76E", hash_generated_method = "5B26E47846EAE8380053C5447857FA9A")
    
@Deprecated
    public final boolean dispatch(Callback receiver) {
        return dispatch(receiver, null, null);
    }
    
    /**
     * Deliver this key event to a {@link Callback} interface.  If this is
     * an ACTION_MULTIPLE event and it is not handled, then an attempt will
     * be made to deliver a single normal event.
     * 
     * @param receiver The Callback that will be given the event.
     * @param state State information retained across events.
     * @param target The target of the dispatch, for use in tracking.
     * 
     * @return The return value from the Callback method that was called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.309 -0500", hash_original_method = "486AD389F69CA9E805DF428CF28467C4", hash_generated_method = "27BD5748E6BAFC465DCAD4D67218DD05")
    @DSVerified("Callback dispatching")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    
public final boolean dispatch(Callback receiver, DispatcherState state,
            Object target) {
        switch (mAction) {
            case ACTION_DOWN: {
                mFlags &= ~FLAG_START_TRACKING;
                if (DEBUG) Log.v(TAG, "Key down to " + target + " in " + state
                        + ": " + this);
                boolean res = receiver.onKeyDown(mKeyCode, this);
                if (state != null) {
                    if (res && mRepeatCount == 0 && (mFlags&FLAG_START_TRACKING) != 0) {
                        if (DEBUG) Log.v(TAG, "  Start tracking!");
                        state.startTracking(this, target);
                    } else if (isLongPress() && state.isTracking(this)) {
                        try {
                            if (receiver.onKeyLongPress(mKeyCode, this)) {
                                if (DEBUG) Log.v(TAG, "  Clear from long press!");
                                state.performedLongPress(this);
                                res = true;
                            }
                        } catch (AbstractMethodError e) {
                        }
                    }
                }
                return res;
            }
            case ACTION_UP:
                if (DEBUG) Log.v(TAG, "Key up to " + target + " in " + state
                        + ": " + this);
                if (state != null) {
                    state.handleUpEvent(this);
                }
                return receiver.onKeyUp(mKeyCode, this);
            case ACTION_MULTIPLE:
                final int count = mRepeatCount;
                final int code = mKeyCode;
                if (receiver.onKeyMultiple(code, count, this)) {
                    return true;
                }
                if (code != KeyEvent.KEYCODE_UNKNOWN) {
                    mAction = ACTION_DOWN;
                    mRepeatCount = 0;
                    boolean handled = receiver.onKeyDown(code, this);
                    if (handled) {
                        mAction = ACTION_UP;
                        receiver.onKeyUp(code, this);
                    }
                    mAction = ACTION_MULTIPLE;
                    mRepeatCount = count;
                    return handled;
                }
                return false;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.339 -0500", hash_original_method = "EC719782A5F2654811BE56A8456234B4", hash_generated_method = "F90E826AA8ED616E80B602C6A49E7245")
    
@Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("KeyEvent { action=").append(actionToString(mAction));
        msg.append(", keyCode=").append(keyCodeToString(mKeyCode));
        msg.append(", scanCode=").append(mScanCode);
        if (mCharacters != null) {
            msg.append(", characters=\"").append(mCharacters).append("\"");
        }
        msg.append(", metaState=").append(metaStateToString(mMetaState));
        msg.append(", flags=0x").append(Integer.toHexString(mFlags));
        msg.append(", repeatCount=").append(mRepeatCount);
        msg.append(", eventTime=").append(mEventTime);
        msg.append(", downTime=").append(mDownTime);
        msg.append(", deviceId=").append(mDeviceId);
        msg.append(", source=0x").append(Integer.toHexString(mSource));
        msg.append(" }");
        return msg.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.368 -0500", hash_original_method = "12273F2E4594D26AD686DE1D2B663F84", hash_generated_method = "171B9DA3FCBDACD10F94911E65EA6A4D")
    
public void writeToParcel(Parcel out, int flags) {
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.373 -0500", hash_original_method = "7ECA2477AC40357C7C5AFE00DC4BDA17", hash_generated_method = "71117048333AFB2A09CB84CA82577A12")
    
    private boolean native_isSystemKey(int keyCode){
    	//Formerly a native method
    	addTaint(keyCode);
    	return getTaintBoolean();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:23.377 -0500", hash_original_method = "B29C954784C1F1FDE17D757BB04FDB3D", hash_generated_method = "AFBD9E7A82DE5C56EDF5BB8104037EC1")
    
    private boolean native_hasDefaultAction(int keyCode){
    	//Formerly a native method
    	addTaint(keyCode);
    	return getTaintBoolean();
    }

    /*
    // orphaned legacy method
    public KeyEvent[] newArray(int size) {
            return new KeyEvent[size];
        }
    
    // orphaned legacy method
    public KeyEvent createFromParcel(Parcel in) {
            in.readInt(); 
            return KeyEvent.createFromParcelBody(in);
        }
    */
}

