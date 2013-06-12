package android.view;

// Droidsafe Imports
import android.os.RemoteException;
import android.util.AndroidRuntimeException;
import android.util.SparseArray;
import android.util.SparseIntArray;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class KeyCharacterMap {
    @Deprecated
    public static final int BUILT_IN_KEYBOARD = 0;
    public static final int VIRTUAL_KEYBOARD = -1;
    public static final int NUMERIC = 1;
    public static final int PREDICTIVE = 2;
    public static final int ALPHA = 3;
    public static final int FULL = 4;
    public static final int SPECIAL_FUNCTION = 5;
    public static final char HEX_INPUT = '\uEF00';
    public static final char PICKER_DIALOG_INPUT = '\uEF01';
    public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
    public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;
    private static SparseArray<KeyCharacterMap> sInstances = new SparseArray<KeyCharacterMap>();
    private final int mDeviceId;
    private int mPtr;
    private static SparseIntArray COMBINING = new SparseIntArray();
    private static SparseIntArray DEAD = new SparseIntArray();
    private static final int ACUTE = '\u00B4' << 16;
    private static final int GRAVE = '`' << 16;
    private static final int CIRCUMFLEX = '^' << 16;
    private static final int TILDE = '~' << 16;
    private static final int UMLAUT = '\u00A8' << 16;
    public static final int COMBINING_ACCENT = 0x80000000;
    public static final int COMBINING_ACCENT_MASK = 0x7FFFFFFF;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "F25FFC35847D9654A71D98E78C4759D8", hash_generated_method = "F7936DEC00DC5CD941EEBB57C028B1B9")
    @DSModeled(DSC.SAFE)
    private KeyCharacterMap(int deviceId, int ptr) {
        dsTaint.addTaint(deviceId);
        dsTaint.addTaint(ptr);
        mDeviceId = deviceId;

        // ---------- Original Method ----------
        //mDeviceId = deviceId;
        //mPtr = ptr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "411AD3071A91572F7B81942058D5D570", hash_generated_method = "368014337130CE663556A45C89CA26BC")
    private static int nativeLoad(String file) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "62D22E54D2287BCFB12AF53C33B4CDAE", hash_generated_method = "E31DEE0DEB4DDCFCF415ECA9533B7C2A")
    private static void nativeDispose(int ptr) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "AC617B6A468EF60FB326247BA76E8515", hash_generated_method = "9F5E30C03242781B5804338EBD5D554E")
    private static char nativeGetCharacter(int ptr, int keyCode, int metaState) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "93405439419D7F040B7E704E9670BD2A", hash_generated_method = "7A66E8868D6A8DCB9DB4243F34BE666C")
    private static boolean nativeGetFallbackAction(int ptr, int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "67F82152BBCBB6214B8E986E43FCD3FA", hash_generated_method = "DFBF2FF5B18CA2F8046DEABF8294DBF6")
    private static char nativeGetNumber(int ptr, int keyCode) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "7FF55A2A6E3FA70141AB81C94AAA8E0C", hash_generated_method = "A5756D49850E6D29F219C762AC7EFFA6")
    private static char nativeGetMatch(int ptr, int keyCode, char[] chars, int metaState) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "D2ABC738F574A9392CD60F7386727B58", hash_generated_method = "FA771FFB55EFCB0D9B751BA1C7EA8865")
    private static char nativeGetDisplayLabel(int ptr, int keyCode) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_CHAR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "0BCA58A795A71F8E738F7EC958F12901", hash_generated_method = "645FB926E465B174DACD29C95F9D05E8")
    private static int nativeGetKeyboardType(int ptr) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "7B494903DDF4BD8240B85C3A0A7B3708", hash_generated_method = "DC63ACBEFC1D95D7AC69561E6684825F")
    private static KeyEvent[] nativeGetEvents(int ptr, int deviceId, char[] chars) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new KeyEvent[] {new KeyEvent()};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "C46984664DD9459250D6B9D7539380FB", hash_generated_method = "50E3177E00C992CA2D85E6F946B4284B")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        {
            nativeDispose(mPtr);
            mPtr = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mPtr != 0) {
            //nativeDispose(mPtr);
            //mPtr = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "55A25C535CCD0059748A82385B0A19D3", hash_generated_method = "42925E07996DB339E2781FAEA153B4F2")
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
                int ptr = nativeLoad(kcm); 
                map = new KeyCharacterMap(deviceId, ptr);
                sInstances.put(deviceId, map);
            }
            return map;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.301 -0400", hash_original_method = "9130955DF84228D9EE103102BFA3B17A", hash_generated_method = "BB0D661AD022B520F691AAF146544EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(int keyCode, int metaState) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(metaState);
        metaState = KeyEvent.normalizeMetaState(metaState);
        char ch;
        ch = nativeGetCharacter(mPtr, keyCode, metaState);
        int map;
        map = COMBINING.get(ch);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //metaState = KeyEvent.normalizeMetaState(metaState);
        //char ch = nativeGetCharacter(mPtr, keyCode, metaState);
        //int map = COMBINING.get(ch);
        //if (map != 0) {
            //return map;
        //} else {
            //return ch;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "5701A82EAD1DE3F7E3AD5DC604F1A78C", hash_generated_method = "9092DB8861E561BF6FFE26814A57DE8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFallbackAction(int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(outFallbackAction.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fallbackAction must not be null");
        } //End block
        metaState = KeyEvent.normalizeMetaState(metaState);
        boolean varCE3900304199253D1A24A3B82C990EE8_22488787 = (nativeGetFallbackAction(mPtr, keyCode, metaState, outFallbackAction));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (outFallbackAction == null) {
            //throw new IllegalArgumentException("fallbackAction must not be null");
        //}
        //metaState = KeyEvent.normalizeMetaState(metaState);
        //return nativeGetFallbackAction(mPtr, keyCode, metaState, outFallbackAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "6DABCB0117446A751E56C996ECEF0096", hash_generated_method = "289C6339FD44ECC787331EC3A772E80F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getNumber(int keyCode) {
        dsTaint.addTaint(keyCode);
        char varDF198814D68AB4A952E3ABC833B9B8A4_757283201 = (nativeGetNumber(mPtr, keyCode));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return nativeGetNumber(mPtr, keyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "BB5B7EBB644AED6B3730BD9151F78F69", hash_generated_method = "371E1447876E824BDD2B31A8952BDF74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getMatch(int keyCode, char[] chars) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(chars);
        char var9F0B8F7534FA815F4917D99B8DF1A026_1145118394 = (getMatch(keyCode, chars, 0));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getMatch(keyCode, chars, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "41D073D91107291EA05310027D49190C", hash_generated_method = "1AB615126B322E7802820395F097376E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getMatch(int keyCode, char[] chars, int metaState) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(metaState);
        dsTaint.addTaint(chars);
        {
            if (DroidSafeAndroidRuntime.control)  throw new IllegalArgumentException("chars must not be null.");
        } //End block
        metaState = KeyEvent.normalizeMetaState(metaState);
        char var1E3A75249CA35C8B1285237F1D55E97D_277087647 = (nativeGetMatch(mPtr, keyCode, chars, metaState));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (chars == null) {
            //throw new IllegalArgumentException("chars must not be null.");
        //}
        //metaState = KeyEvent.normalizeMetaState(metaState);
        //return nativeGetMatch(mPtr, keyCode, chars, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "6DD5621B8D7662BB0D5EEF29B875BDA1", hash_generated_method = "E04F4BBF1C78F594BEFD0CD067D456F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getDisplayLabel(int keyCode) {
        dsTaint.addTaint(keyCode);
        char var90AE32CAD5C582E5138E2843AD421D47_59866497 = (nativeGetDisplayLabel(mPtr, keyCode));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return nativeGetDisplayLabel(mPtr, keyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "C6F5470D92A32D0EFDBBA89CAC321185", hash_generated_method = "2AE83191FAC6404F3E8E4CE7A1860567")
    public static int getDeadChar(int accent, int c) {
        return DEAD.get((accent << 16) | c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "76D58BCFCDB16C229BEE46626C0804EB", hash_generated_method = "56BC00AB5AF3D2FEBD71B21076AAC0B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public boolean getKeyData(int keyCode, KeyData results) {
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(results.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(
                    "results.meta.length must be >= " + KeyData.META_LENGTH);
        } //End block
        char displayLabel;
        displayLabel = nativeGetDisplayLabel(mPtr, keyCode);
        results.displayLabel = displayLabel;
        results.number = nativeGetNumber(mPtr, keyCode);
        results.meta[0] = nativeGetCharacter(mPtr, keyCode, 0);
        results.meta[1] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_SHIFT_ON);
        results.meta[2] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_ALT_ON);
        results.meta[3] = nativeGetCharacter(mPtr, keyCode,
                KeyEvent.META_ALT_ON | KeyEvent.META_SHIFT_ON);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (results.meta.length < KeyData.META_LENGTH) {
            //throw new IndexOutOfBoundsException(
                    //"results.meta.length must be >= " + KeyData.META_LENGTH);
        //}
        //char displayLabel = nativeGetDisplayLabel(mPtr, keyCode);
        //if (displayLabel == 0) {
            //return false;
        //}
        //results.displayLabel = displayLabel;
        //results.number = nativeGetNumber(mPtr, keyCode);
        //results.meta[0] = nativeGetCharacter(mPtr, keyCode, 0);
        //results.meta[1] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_SHIFT_ON);
        //results.meta[2] = nativeGetCharacter(mPtr, keyCode, KeyEvent.META_ALT_ON);
        //results.meta[3] = nativeGetCharacter(mPtr, keyCode,
                //KeyEvent.META_ALT_ON | KeyEvent.META_SHIFT_ON);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "75C550EBD18DF5C6523832F5B0CC290D", hash_generated_method = "038BF37E4A955A25729D334BB687A39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyEvent[] getEvents(char[] chars) {
        dsTaint.addTaint(chars);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("chars must not be null.");
        } //End block
        KeyEvent[] var79B16E446F0C956CCED11EF9AD5A052D_1802417361 = (nativeGetEvents(mPtr, mDeviceId, chars));
        return (KeyEvent[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (chars == null) {
            //throw new IllegalArgumentException("chars must not be null.");
        //}
        //return nativeGetEvents(mPtr, mDeviceId, chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.302 -0400", hash_original_method = "3285F5CD7518CBF681F7E4DAED1719BF", hash_generated_method = "D78C4B8315CB1BFA84F91C7D42B70490")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrintingKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        int type;
        type = Character.getType(nativeGetDisplayLabel(mPtr, keyCode));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int type = Character.getType(nativeGetDisplayLabel(mPtr, keyCode));
        //switch (type)
        //{
            //case Character.SPACE_SEPARATOR:
            //case Character.LINE_SEPARATOR:
            //case Character.PARAGRAPH_SEPARATOR:
            //case Character.CONTROL:
            //case Character.FORMAT:
                //return false;
            //default:
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.303 -0400", hash_original_method = "BA716E54E3F5777C121637287957F9E5", hash_generated_method = "5ABC7A1F7BDC299055D16939E4D164EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getKeyboardType() {
        int var5804746570F479E54666D84988DB57C1_172540328 = (nativeGetKeyboardType(mPtr));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nativeGetKeyboardType(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.303 -0400", hash_original_method = "1B54B22E072CCA54689C03A0F5698E81", hash_generated_method = "54EC505453EDFDFDF1609865232EE420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifierBehavior() {
        {
            Object var6F1F68E94BE9EBA81DD665AD4038DA31_2126142708 = (getKeyboardType());
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (getKeyboardType()) {
            //case FULL:
            //case SPECIAL_FUNCTION:
                //return MODIFIER_BEHAVIOR_CHORDED;
            //default:
                //return MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.303 -0400", hash_original_method = "5B0230A7CB9028DEE893C06E012A9969", hash_generated_method = "9D4ADA81181CFE7F31BF5887FFE36856")
    public static boolean deviceHasKey(int keyCode) {
        int[] codeArray = new int[1];
        codeArray[0] = keyCode;
        boolean[] ret = deviceHasKeys(codeArray);
        return ret[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.303 -0400", hash_original_method = "52B0D1EECC647FA8F40C23BBC67E314D", hash_generated_method = "2AF9DDF5E00135038AB14E9C66D0B9AC")
    public static boolean[] deviceHasKeys(int[] keyCodes) {
        boolean[] ret = new boolean[keyCodes.length];
        IWindowManager wm = Display.getWindowManager();
        try {
            wm.hasKeys(keyCodes, ret);
        } catch (RemoteException e) {
        }
        return ret;
    }

    
    public static class KeyData {
        public static final int META_LENGTH = 4;
        public char displayLabel;
        public char number;
        public char[] meta = new char[META_LENGTH];
        
    }


    
    public static class UnavailableException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:05.303 -0400", hash_original_method = "463842D1BF3FEF123617A569E3B89D0B", hash_generated_method = "CA82ACD793A580E4249BD68C85BBCE0C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public UnavailableException(String msg) {
            super(msg);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class FallbackAction {
        public int keyCode;
        public int metaState;
        
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


