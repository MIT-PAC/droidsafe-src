package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.RemoteException;
import android.util.AndroidRuntimeException;
import android.util.SparseArray;
import android.util.SparseIntArray;

import droidsafe.helpers.DSUtils;

public class KeyCharacterMap {
    
    private static int nativeLoad(String file) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123601077 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123601077;
    }
    
    private static void nativeDispose(int ptr) {
    }
    
    private static char nativeGetCharacter(int ptr, int keyCode, int metaState) {
                char varA87DEB01C5F539E6BDA34829C8EF2368_1244637250 = DSUtils.UNKNOWN_CHAR;
        return varA87DEB01C5F539E6BDA34829C8EF2368_1244637250;
    }
    
    private static boolean nativeGetFallbackAction(int ptr, int keyCode, int metaState,
            FallbackAction outFallbackAction) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185696657 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_185696657;
    }
    
    private static char nativeGetNumber(int ptr, int keyCode) {
                char varA87DEB01C5F539E6BDA34829C8EF2368_1984588844 = DSUtils.UNKNOWN_CHAR;
        return varA87DEB01C5F539E6BDA34829C8EF2368_1984588844;
    }
    
    private static char nativeGetMatch(int ptr, int keyCode, char[] chars, int metaState) {
                char varA87DEB01C5F539E6BDA34829C8EF2368_1376476993 = DSUtils.UNKNOWN_CHAR;
        return varA87DEB01C5F539E6BDA34829C8EF2368_1376476993;
    }
    
    private static char nativeGetDisplayLabel(int ptr, int keyCode) {
                char varA87DEB01C5F539E6BDA34829C8EF2368_1718283332 = DSUtils.UNKNOWN_CHAR;
        return varA87DEB01C5F539E6BDA34829C8EF2368_1718283332;
    }
    
    private static int nativeGetKeyboardType(int ptr) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471314073 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471314073;
    }
    
    private static KeyEvent[] nativeGetEvents(int ptr, int deviceId, char[] chars) {
    	KeyEvent[] k = new KeyEvent[1];
    	return  k;
    }

    /**
     * Loads the key character maps for the keyboard with the specified device id.
     *
     * @param deviceId The device id of the keyboard.
     * @return The associated key character map.
     * @throws {@link UnavailableException} if the key character map
     * could not be loaded because it was malformed or the default key character map
     * is missing from the system.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.794 -0500", hash_original_method = "55A25C535CCD0059748A82385B0A19D3", hash_generated_method = "A58F77895EF8459FD95FA9B4DF308629")
    
public static KeyCharacterMap load(int deviceId) {
        synchronized (sInstances) {
            KeyCharacterMap map = sInstances.get(deviceId);
            if (map == null) {
                String kcm = null;
                if (deviceId != VIRTUAL_KEYBOARD) {
                    InputDevice device = InputDevice.getDevice(deviceId);
                    if (device != null) {
                        kcm = device.getKeyCharacterMapFile();
                    }
                }
                if (kcm == null || kcm.length() == 0) {
                    kcm = "/system/usr/keychars/Virtual.kcm";
                }
                int ptr = nativeLoad(kcm); // might throw
                map = new KeyCharacterMap(deviceId, ptr);
                sInstances.put(deviceId, map);
            }
            return map;
        }
    }

    /**
     * Get the character that is produced by putting accent on the character c.
     * For example, getDeadChar('`', 'e') returns &egrave;.
     *
     * @param accent The accent character.  eg. '`'
     * @param c The basic character.
     * @return The combined character, or 0 if the characters cannot be combined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.812 -0500", hash_original_method = "C6F5470D92A32D0EFDBBA89CAC321185", hash_generated_method = "2AE83191FAC6404F3E8E4CE7A1860567")
    
public static int getDeadChar(int accent, int c) {
        return DEAD.get((accent << 16) | c);
    }

    /**
     * Queries the framework about whether any physical keys exist on the
     * any keyboard attached to the device that are capable of producing the given key code.
     *
     * @param keyCode The key code to query.
     * @return True if at least one attached keyboard supports the specified key code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.841 -0500", hash_original_method = "5B0230A7CB9028DEE893C06E012A9969", hash_generated_method = "9D4ADA81181CFE7F31BF5887FFE36856")
    
public static boolean deviceHasKey(int keyCode) {
        int[] codeArray = new int[1];
        codeArray[0] = keyCode;
        boolean[] ret = deviceHasKeys(codeArray);
        return ret[0];
    }

    /**
     * Queries the framework about whether any physical keys exist on the
     * any keyboard attached to the device that are capable of producing the given
     * array of key codes.
     *
     * @param keyCodes The array of key codes to query.
     * @return A new array of the same size as the key codes array whose elements
     * are set to true if at least one attached keyboard supports the corresponding key code
     * at the same index in the key codes array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.844 -0500", hash_original_method = "52B0D1EECC647FA8F40C23BBC67E314D", hash_generated_method = "FE7E0E800654C4370BADD7C037353FD1")
    
public static boolean[] deviceHasKeys(int[] keyCodes) {
        boolean[] ret = new boolean[keyCodes.length];
        IWindowManager wm = Display.getWindowManager();
        try {
            wm.hasKeys(keyCodes, ret);
        } catch (RemoteException e) {
            // no fallback; just return the empty array
        }
        return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.712 -0500", hash_original_field = "463AF7F5F8CE67C03683C8FD97632C5A", hash_generated_field = "59B4829C2D65190B8B4C0FA33230C1E4")

    @Deprecated
    public static final int BUILT_IN_KEYBOARD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.715 -0500", hash_original_field = "CB4C464F7AB408B073C4B78261441C74", hash_generated_field = "C3770B577FF433B8BFF698D5F722014E")

    public static final int VIRTUAL_KEYBOARD = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.718 -0500", hash_original_field = "30E514E35C23C41C84769C8EA90336C5", hash_generated_field = "81DDA812F0A0EF21C694BF5A82F81EE3")

    public static final int NUMERIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.721 -0500", hash_original_field = "A20FCA0A13AABAC57FC159D2BA60078E", hash_generated_field = "CD3F247AFA1F26ABAD74821769ACFB70")

    public static final int PREDICTIVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.723 -0500", hash_original_field = "2011A20AE286D1676E7CB74BDBF9C864", hash_generated_field = "157B02842601F7C0DED5E95134F38522")

    public static final int ALPHA = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.726 -0500", hash_original_field = "A60B0C81AEC721E3AB800B8FBA59A02D", hash_generated_field = "20E85A6090C38DE3E8C1E3AF96C136F0")

    public static final int FULL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.729 -0500", hash_original_field = "530A1F84DD0263B0F4DC21DC3F916DF9", hash_generated_field = "89216B40F08E21779835E6D1681D3FBA")

    public static final int SPECIAL_FUNCTION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.732 -0500", hash_original_field = "8F28236648FFF8ADAC85BE9101D64D00", hash_generated_field = "E6D8ABAEC54AD7FE6AC0637BE6B60C20")

    public static final char HEX_INPUT = '\uEF00';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.734 -0500", hash_original_field = "8A8F71F7A3B876AA7C1BE39495FC5A81", hash_generated_field = "C292F8608784160E386A6728D1ED3563")

    public static final char PICKER_DIALOG_INPUT = '\uEF01';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.737 -0500", hash_original_field = "2A7FFB99AC9BE5CCECB3E11383771551", hash_generated_field = "B89E5758383255A9C827FA145DE8507A")

    public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.739 -0500", hash_original_field = "F5AABE172D9059DED9949A5CA09AD407", hash_generated_field = "616FB0D0098A2547A5B190478FA72B55")

    public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.741 -0500", hash_original_field = "65E14CBA7CCCF9D8B2FCC49DA88A3227", hash_generated_field = "A41BDDB2AF8DD199AC0801E6FA90000D")

    private static SparseArray<KeyCharacterMap> sInstances = new SparseArray<KeyCharacterMap>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.846 -0500", hash_original_field = "4AF8DA2BCB82FF845E7161D3C609B79D", hash_generated_field = "11B1384F451F38AFF9AFE2392F709751")

    private static SparseIntArray COMBINING = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.849 -0500", hash_original_field = "34ACC00F8AB0D196C3E5A5718B2B4F47", hash_generated_field = "B76722FF851A78D583E0DFB3CE65DF2C")

    private static SparseIntArray DEAD = new SparseIntArray();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.852 -0500", hash_original_field = "A854142F03CFDE8432625F3B51B2CDEB", hash_generated_field = "4F036169C638098B73313599D908CEB4")

    private static final int ACUTE = '\u00B4' << 16;
    
    public static class KeyData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.815 -0500", hash_original_field = "0CE8BAF2BE88BD999E28B3599817EA44", hash_generated_field = "B7B5BF1414600355D7BF1611E9967D65")

        public static final int META_LENGTH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.817 -0500", hash_original_field = "60A0E21E470E822C3C68798A3655C7D2", hash_generated_field = "10206615040C9B5E0B40E86C5E399A28")

        public char displayLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.819 -0500", hash_original_field = "2A342E00BA82548C723595EA8F3EDFB2", hash_generated_field = "C53E6ECAD71F4994DDB600BCB7228E67")

        public char number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.822 -0500", hash_original_field = "0F417CC95B1717ED8F8F39877AC1E407", hash_generated_field = "B234B5BEA612AD563CF4084101F5BF63")

        public char[] meta = new char[META_LENGTH];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.182 -0400", hash_original_method = "AA20F851FEA58DFB4FCE42162FC7E15E", hash_generated_method = "AA20F851FEA58DFB4FCE42162FC7E15E")
        public KeyData ()
        {
            //Synthesized constructor
        }
    }
    
    public static class UnavailableException extends AndroidRuntimeException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.877 -0500", hash_original_method = "463842D1BF3FEF123617A569E3B89D0B", hash_generated_method = "C9A1C51EC97A12950DBCAD76008DE8A1")
        
public UnavailableException(String msg) {
            super(msg);
        }
        
    }
    
    public static final class FallbackAction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.882 -0500", hash_original_field = "AF3F60A45836C339EA3C11B5C54720AC", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.884 -0500", hash_original_field = "B181A1DE7DB05CE3DC182354F918E505", hash_generated_field = "5236106FD9BFBDE1EF13C213F3E14407")

        public int metaState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:43.182 -0400", hash_original_method = "789B682B3FBE45C1858DC98A8C26817D", hash_generated_method = "789B682B3FBE45C1858DC98A8C26817D")
        public FallbackAction ()
        {
            //Synthesized constructor
        }

    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.854 -0500", hash_original_field = "3F3BDB109C209513958B4A39E13F9DDC", hash_generated_field = "637F3AC3B0EEC3847F5FCA990AF1E992")

    private static final int GRAVE = '`' << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.857 -0500", hash_original_field = "5B8F676DFC9442F63A44A6C7D5E21B96", hash_generated_field = "0586C62B883B7B85634E30B0C82D3317")

    private static final int CIRCUMFLEX = '^' << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.859 -0500", hash_original_field = "8F2BE7DF37075299F090F74494A9ED9F", hash_generated_field = "CDA4A85433A132193E004843C63F5FED")

    private static final int TILDE = '~' << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.863 -0500", hash_original_field = "3E3C58EFD203A799486A2F88A03ADA38", hash_generated_field = "FA6505A20CF02AAC8A961E3468EEEFEB")

    private static final int UMLAUT = '\u00A8' << 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.868 -0500", hash_original_field = "C5F0FFB6D5762CB9909F419C5D8F0A79", hash_generated_field = "0E06608D3648E37E5411DA551501463D")

    public static final int COMBINING_ACCENT = 0x80000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.871 -0500", hash_original_field = "E5E5FA60D1294CE2E95676B2C8946565", hash_generated_field = "0F27E21C7E3F6FCD749479852C67E791")

    public static final int COMBINING_ACCENT_MASK = 0x7FFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.744 -0500", hash_original_field = "9C5D5B4697BA4F2BAA6617B930737C8B", hash_generated_field = "AE8D59B3F804A7C4665D164A31D2B414")

    private  int mDeviceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.747 -0500", hash_original_field = "42C21A18FB5976D4C67962413781C35D", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.788 -0500", hash_original_method = "F25FFC35847D9654A71D98E78C4759D8", hash_generated_method = "EF6675F56F37A7ADCCBF26107C109900")
    
private KeyCharacterMap(int deviceId, int ptr) {
        mDeviceId = deviceId;
        mPtr = ptr;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.791 -0500", hash_original_method = "C46984664DD9459250D6B9D7539380FB", hash_generated_method = "4E3AA0EA035CE457B89BA83140F5FD0C")
    
@Override
    protected void finalize() throws Throwable {
        if (mPtr != 0) {
            nativeDispose(mPtr);
            mPtr = 0;
        }
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
     * If the return value has bit {@link #COMBINING_ACCENT} set, the
     * key is a "dead key" that should be combined with another to
     * actually produce a character -- see {@link #getDeadChar} --
     * after masking with {@link #COMBINING_ACCENT_MASK}.
     * </p>
     *
     * @param keyCode The key code.
     * @param metaState The meta key modifier state.
     * @return The associated character or combining accent, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.796 -0500", hash_original_method = "9130955DF84228D9EE103102BFA3B17A", hash_generated_method = "95DBC8174377B728E7B9CD47D1EE7503")
    
public int get(int keyCode, int metaState) {
        metaState = KeyEvent.normalizeMetaState(metaState);
        char ch = nativeGetCharacter(mPtr, keyCode, metaState);

        int map = COMBINING.get(ch);
        if (map != 0) {
            return map;
        } else {
            return ch;
        }
    }

    /**
     * Gets the fallback action to perform if the application does not
     * handle the specified key.
     * <p>
     * When an application does not handle a particular key, the system may
     * translate the key to an alternate fallback key (specified in the
     * fallback action) and dispatch it to the application.
     * The event containing the fallback key is flagged
     * with {@link KeyEvent#FLAG_FALLBACK}.
     * </p>
     *
     * @param keyCode The key code.
     * @param metaState The meta key modifier state.
     * @param outFallbackAction The fallback action object to populate.
     * @return True if a fallback action was found, false otherwise.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.799 -0500", hash_original_method = "5701A82EAD1DE3F7E3AD5DC604F1A78C", hash_generated_method = "C8AD97FEFFAC4CC2809AEE9D3AC592B3")
    
public boolean getFallbackAction(int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        if (outFallbackAction == null) {
            throw new IllegalArgumentException("fallbackAction must not be null");
        }

        metaState = KeyEvent.normalizeMetaState(metaState);
        return nativeGetFallbackAction(mPtr, keyCode, metaState, outFallbackAction);
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
     * @param keyCode The key code.
     * @return The associated numeric or symbolic character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.801 -0500", hash_original_method = "6DABCB0117446A751E56C996ECEF0096", hash_generated_method = "5F76969C0A8A0FCEADEFDE23621138C4")
    
public char getNumber(int keyCode) {
        return nativeGetNumber(mPtr, keyCode);
    }

    /**
     * Gets the first character in the character array that can be generated
     * by the specified key code.
     * <p>
     * This is a convenience function that returns the same value as
     * {@link #getMatch(int,char[],int) getMatch(keyCode, chars, 0)}.
     * </p>
     *
     * @param keyCode The keycode.
     * @param chars The array of matching characters to consider.
     * @return The matching associated character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.804 -0500", hash_original_method = "BB5B7EBB644AED6B3730BD9151F78F69", hash_generated_method = "1E3A1D349365A4F4AD6D1A185C63C70D")
    
public char getMatch(int keyCode, char[] chars) {
        return getMatch(keyCode, chars, 0);
    }

    /**
     * Gets the first character in the character array that can be generated
     * by the specified key code.  If there are multiple choices, prefers
     * the one that would be generated with the specified meta key modifier state.
     *
     * @param keyCode The key code.
     * @param chars The array of matching characters to consider.
     * @param metaState The preferred meta key modifier state.
     * @return The matching associated character, or 0 if none.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.807 -0500", hash_original_method = "41D073D91107291EA05310027D49190C", hash_generated_method = "864F7C53F01A376E8CC647D468667FDF")
    
public char getMatch(int keyCode, char[] chars, int metaState) {
        if (chars == null) {
            throw new IllegalArgumentException("chars must not be null.");
        }

        metaState = KeyEvent.normalizeMetaState(metaState);
        return nativeGetMatch(mPtr, keyCode, chars, metaState);
    }

    /**
     * Gets the primary character for this key.
     * In other words, the label that is physically printed on it.
     *
     * @param keyCode The key code.
     * @return The display label character, or 0 if none (eg. for non-printing keys).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.809 -0500", hash_original_method = "6DD5621B8D7662BB0D5EEF29B875BDA1", hash_generated_method = "D5B10648A10DEBE7C9F0083D1A39CEE2")
    
public char getDisplayLabel(int keyCode) {
        return nativeGetDisplayLabel(mPtr, keyCode);
    }

    /**
     * Get the character conversion data for a given key code.
     *
     * @param keyCode The keyCode to query.
     * @param results A {@link KeyData} instance that will be filled with the results.
     * @return True if the key was mapped.  If the key was not mapped, results is not modified.
     *
     * @deprecated instead use {@link KeyCharacterMap#getDisplayLabel(int)},
     * {@link KeyCharacterMap#getNumber(int)} or {@link KeyCharacterMap#get(int, int)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.827 -0500", hash_original_method = "76D58BCFCDB16C229BEE46626C0804EB", hash_generated_method = "BA54A28691A5B4DF2F46BD4A7A5DC37B")
    
@Deprecated
    public boolean getKeyData(int keyCode, KeyData results) {
        if (results.meta.length < KeyData.META_LENGTH) {
            throw new IndexOutOfBoundsException(
                    "results.meta.length must be >= " + KeyData.META_LENGTH);
        }

        char displayLabel = nativeGetDisplayLabel(mPtr, keyCode);
        if (displayLabel == 0) {
            return false;
        }

        results.displayLabel = displayLabel;
        results.number = nativeGetNumber(mPtr, keyCode);
        results.meta[0] = nativeGetCharacter(mPtr, keyCode, 0);
        results.meta[1] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_SHIFT_ON);
        results.meta[2] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_ALT_ON);
        results.meta[3] = nativeGetCharacter(mPtr, keyCode,
                KeyEvent.META_ALT_ON | KeyEvent.META_SHIFT_ON);
        return true;
    }

    /**
     * Get an array of KeyEvent objects that if put into the input stream
     * could plausibly generate the provided sequence of characters.  It is
     * not guaranteed that the sequence is the only way to generate these
     * events or that it is optimal.
     * <p>
     * This function is primarily offered for instrumentation and testing purposes.
     * It may fail to map characters to key codes.  In particular, the key character
     * map for the {@link #BUILT_IN_KEYBOARD built-in keyboard} device id may be empty.
     * Consider using the key character map associated with the
     * {@link #VIRTUAL_KEYBOARD virtual keyboard} device id instead.
     * </p><p>
     * For robust text entry, do not use this function.  Instead construct a
     * {@link KeyEvent} with action code {@link KeyEvent#ACTION_MULTIPLE} that contains
     * the desired string using {@link KeyEvent#KeyEvent(long, String, int, int)}.
     * </p>
     *
     * @param chars The sequence of characters to generate.
     * @return An array of {@link KeyEvent} objects, or null if the given char array
     *         can not be generated using the current key character map.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.830 -0500", hash_original_method = "75C550EBD18DF5C6523832F5B0CC290D", hash_generated_method = "394B6C4094D20194266ECC24C5A8F978")
    
public KeyEvent[] getEvents(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("chars must not be null.");
        }
        return nativeGetEvents(mPtr, mDeviceId, chars);
    }

    /**
     * Returns true if the specified key produces a glyph.
     *
     * @param keyCode The key code.
     * @return True if the key is a printing key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.832 -0500", hash_original_method = "3285F5CD7518CBF681F7E4DAED1719BF", hash_generated_method = "6622D8E9E7B498EBE1B33BBE19E6566A")
    
public boolean isPrintingKey(int keyCode) {
        int type = Character.getType(nativeGetDisplayLabel(mPtr, keyCode));

        switch (type)
        {
            case Character.SPACE_SEPARATOR:
            case Character.LINE_SEPARATOR:
            case Character.PARAGRAPH_SEPARATOR:
            case Character.CONTROL:
            case Character.FORMAT:
                return false;
            default:
                return true;
        }
    }

    /**
     * Gets the keyboard type.
     * Returns {@link #NUMERIC}, {@link #PREDICTIVE}, {@link #ALPHA} or {@link #FULL}.
     * <p>
     * Different keyboard types have different semantics.  Refer to the documentation
     * associated with the keyboard type constants for details.
     * </p>
     *
     * @return The keyboard type.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.835 -0500", hash_original_method = "BA716E54E3F5777C121637287957F9E5", hash_generated_method = "FE100288A2D20E0D214B24C766084AAA")
    
public int getKeyboardType() {
        return nativeGetKeyboardType(mPtr);
    }

    /**
     * Gets a constant that describes the behavior of this keyboard's modifier keys
     * such as {@link KeyEvent#KEYCODE_SHIFT_LEFT}.
     * <p>
     * Currently there are two behaviors that may be combined:
     * </p>
     * <ul>
     * <li>Chorded behavior: When the modifier key is pressed together with one or more
     * character keys, the keyboard inserts the modified keys and
     * then resets the modifier state when the modifier key is released.</li>
     * <li>Toggled behavior: When the modifier key is pressed and released on its own
     * it first toggles into a latched state.  When latched, the modifier will apply
     * to next character key that is pressed and will then reset itself to the initial state.
     * If the modifier is already latched and the modifier key is pressed and release on
     * its own again, then it toggles into a locked state.  When locked, the modifier will
     * apply to all subsequent character keys that are pressed until unlocked by pressing
     * the modifier key on its own one more time to reset it to the initial state.
     * Toggled behavior is useful for small profile keyboards designed for thumb typing.
     * </ul>
     * <p>
     * This function currently returns {@link #MODIFIER_BEHAVIOR_CHORDED} when the
     * {@link #getKeyboardType() keyboard type} is {@link #FULL} or {@link #SPECIAL_FUNCTION} and
     * {@link #MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED} otherwise.
     * In the future, the function may also take into account global keyboard
     * accessibility settings, other user preferences, or new device capabilities.
     * </p>
     *
     * @return The modifier behavior for this keyboard.
     *
     * @see {@link #MODIFIER_BEHAVIOR_CHORDED}
     * @see {@link #MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED}
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:58.837 -0500", hash_original_method = "1B54B22E072CCA54689C03A0F5698E81", hash_generated_method = "C0C6529640A4872EA7A78E5ACE87222F")
    
public int getModifierBehavior() {
        switch (getKeyboardType()) {
            case FULL:
            case SPECIAL_FUNCTION:
                return MODIFIER_BEHAVIOR_CHORDED;
            default:
                return MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED;
        }
    }
    static {
        COMBINING.put('\u0300', (GRAVE >> 16) | COMBINING_ACCENT);
        COMBINING.put('\u0301', (ACUTE >> 16) | COMBINING_ACCENT);
        COMBINING.put('\u0302', (CIRCUMFLEX >> 16) | COMBINING_ACCENT);
        COMBINING.put('\u0303', (TILDE >> 16) | COMBINING_ACCENT);
        COMBINING.put('\u0308', (UMLAUT >> 16) | COMBINING_ACCENT);
        DEAD.put(ACUTE | 'A', '\u00C1');
        DEAD.put(ACUTE | 'C', '\u0106');
        DEAD.put(ACUTE | 'E', '\u00C9');
        DEAD.put(ACUTE | 'G', '\u01F4');
        DEAD.put(ACUTE | 'I', '\u00CD');
        DEAD.put(ACUTE | 'K', '\u1E30');
        DEAD.put(ACUTE | 'L', '\u0139');
        DEAD.put(ACUTE | 'M', '\u1E3E');
        DEAD.put(ACUTE | 'N', '\u0143');
        DEAD.put(ACUTE | 'O', '\u00D3');
        DEAD.put(ACUTE | 'P', '\u1E54');
        DEAD.put(ACUTE | 'R', '\u0154');
        DEAD.put(ACUTE | 'S', '\u015A');
        DEAD.put(ACUTE | 'U', '\u00DA');
        DEAD.put(ACUTE | 'W', '\u1E82');
        DEAD.put(ACUTE | 'Y', '\u00DD');
        DEAD.put(ACUTE | 'Z', '\u0179');
        DEAD.put(ACUTE | 'a', '\u00E1');
        DEAD.put(ACUTE | 'c', '\u0107');
        DEAD.put(ACUTE | 'e', '\u00E9');
        DEAD.put(ACUTE | 'g', '\u01F5');
        DEAD.put(ACUTE | 'i', '\u00ED');
        DEAD.put(ACUTE | 'k', '\u1E31');
        DEAD.put(ACUTE | 'l', '\u013A');
        DEAD.put(ACUTE | 'm', '\u1E3F');
        DEAD.put(ACUTE | 'n', '\u0144');
        DEAD.put(ACUTE | 'o', '\u00F3');
        DEAD.put(ACUTE | 'p', '\u1E55');
        DEAD.put(ACUTE | 'r', '\u0155');
        DEAD.put(ACUTE | 's', '\u015B');
        DEAD.put(ACUTE | 'u', '\u00FA');
        DEAD.put(ACUTE | 'w', '\u1E83');
        DEAD.put(ACUTE | 'y', '\u00FD');
        DEAD.put(ACUTE | 'z', '\u017A');
        DEAD.put(CIRCUMFLEX | 'A', '\u00C2');
        DEAD.put(CIRCUMFLEX | 'C', '\u0108');
        DEAD.put(CIRCUMFLEX | 'E', '\u00CA');
        DEAD.put(CIRCUMFLEX | 'G', '\u011C');
        DEAD.put(CIRCUMFLEX | 'H', '\u0124');
        DEAD.put(CIRCUMFLEX | 'I', '\u00CE');
        DEAD.put(CIRCUMFLEX | 'J', '\u0134');
        DEAD.put(CIRCUMFLEX | 'O', '\u00D4');
        DEAD.put(CIRCUMFLEX | 'S', '\u015C');
        DEAD.put(CIRCUMFLEX | 'U', '\u00DB');
        DEAD.put(CIRCUMFLEX | 'W', '\u0174');
        DEAD.put(CIRCUMFLEX | 'Y', '\u0176');
        DEAD.put(CIRCUMFLEX | 'Z', '\u1E90');
        DEAD.put(CIRCUMFLEX | 'a', '\u00E2');
        DEAD.put(CIRCUMFLEX | 'c', '\u0109');
        DEAD.put(CIRCUMFLEX | 'e', '\u00EA');
        DEAD.put(CIRCUMFLEX | 'g', '\u011D');
        DEAD.put(CIRCUMFLEX | 'h', '\u0125');
        DEAD.put(CIRCUMFLEX | 'i', '\u00EE');
        DEAD.put(CIRCUMFLEX | 'j', '\u0135');
        DEAD.put(CIRCUMFLEX | 'o', '\u00F4');
        DEAD.put(CIRCUMFLEX | 's', '\u015D');
        DEAD.put(CIRCUMFLEX | 'u', '\u00FB');
        DEAD.put(CIRCUMFLEX | 'w', '\u0175');
        DEAD.put(CIRCUMFLEX | 'y', '\u0177');
        DEAD.put(CIRCUMFLEX | 'z', '\u1E91');
        DEAD.put(GRAVE | 'A', '\u00C0');
        DEAD.put(GRAVE | 'E', '\u00C8');
        DEAD.put(GRAVE | 'I', '\u00CC');
        DEAD.put(GRAVE | 'N', '\u01F8');
        DEAD.put(GRAVE | 'O', '\u00D2');
        DEAD.put(GRAVE | 'U', '\u00D9');
        DEAD.put(GRAVE | 'W', '\u1E80');
        DEAD.put(GRAVE | 'Y', '\u1EF2');
        DEAD.put(GRAVE | 'a', '\u00E0');
        DEAD.put(GRAVE | 'e', '\u00E8');
        DEAD.put(GRAVE | 'i', '\u00EC');
        DEAD.put(GRAVE | 'n', '\u01F9');
        DEAD.put(GRAVE | 'o', '\u00F2');
        DEAD.put(GRAVE | 'u', '\u00F9');
        DEAD.put(GRAVE | 'w', '\u1E81');
        DEAD.put(GRAVE | 'y', '\u1EF3');
        DEAD.put(TILDE | 'A', '\u00C3');
        DEAD.put(TILDE | 'E', '\u1EBC');
        DEAD.put(TILDE | 'I', '\u0128');
        DEAD.put(TILDE | 'N', '\u00D1');
        DEAD.put(TILDE | 'O', '\u00D5');
        DEAD.put(TILDE | 'U', '\u0168');
        DEAD.put(TILDE | 'V', '\u1E7C');
        DEAD.put(TILDE | 'Y', '\u1EF8');
        DEAD.put(TILDE | 'a', '\u00E3');
        DEAD.put(TILDE | 'e', '\u1EBD');
        DEAD.put(TILDE | 'i', '\u0129');
        DEAD.put(TILDE | 'n', '\u00F1');
        DEAD.put(TILDE | 'o', '\u00F5');
        DEAD.put(TILDE | 'u', '\u0169');
        DEAD.put(TILDE | 'v', '\u1E7D');
        DEAD.put(TILDE | 'y', '\u1EF9');
        DEAD.put(UMLAUT | 'A', '\u00C4');
        DEAD.put(UMLAUT | 'E', '\u00CB');
        DEAD.put(UMLAUT | 'H', '\u1E26');
        DEAD.put(UMLAUT | 'I', '\u00CF');
        DEAD.put(UMLAUT | 'O', '\u00D6');
        DEAD.put(UMLAUT | 'U', '\u00DC');
        DEAD.put(UMLAUT | 'W', '\u1E84');
        DEAD.put(UMLAUT | 'X', '\u1E8C');
        DEAD.put(UMLAUT | 'Y', '\u0178');
        DEAD.put(UMLAUT | 'a', '\u00E4');
        DEAD.put(UMLAUT | 'e', '\u00EB');
        DEAD.put(UMLAUT | 'h', '\u1E27');
        DEAD.put(UMLAUT | 'i', '\u00EF');
        DEAD.put(UMLAUT | 'o', '\u00F6');
        DEAD.put(UMLAUT | 't', '\u1E97');
        DEAD.put(UMLAUT | 'u', '\u00FC');
        DEAD.put(UMLAUT | 'w', '\u1E85');
        DEAD.put(UMLAUT | 'x', '\u1E8D');
        DEAD.put(UMLAUT | 'y', '\u00FF');
    }
    
}

