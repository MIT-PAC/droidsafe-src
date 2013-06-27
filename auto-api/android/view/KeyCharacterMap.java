package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.method.MetaKeyKeyListener;
import android.util.AndroidRuntimeException;
import android.util.SparseIntArray;
import android.os.RemoteException;
import android.util.SparseArray;
import java.lang.Character;

public class KeyCharacterMap {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.783 -0400", hash_original_field = "DD9A3A8FAD85AE1264DE035645B54BEC", hash_generated_field = "AE8D59B3F804A7C4665D164A31D2B414")

    private int mDeviceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.783 -0400", hash_original_field = "34F930F150EAEEFF27D6C0C8E4629911", hash_generated_field = "E9A8054C2C57C0CE861FDCA982433D1A")

    private int mPtr;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.783 -0400", hash_original_method = "F25FFC35847D9654A71D98E78C4759D8", hash_generated_method = "BA7BA688730B5A8F24D16B2D5566D72A")
    private  KeyCharacterMap(int deviceId, int ptr) {
        mDeviceId = deviceId;
        mPtr = ptr;
        // ---------- Original Method ----------
        //mDeviceId = deviceId;
        //mPtr = ptr;
    }

    
        private static int nativeLoad(String file) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void nativeDispose(int ptr) {
    }

    
        private static char nativeGetCharacter(int ptr, int keyCode, int metaState) {
        return DSUtils.UNKNOWN_CHAR;
    }

    
        private static boolean nativeGetFallbackAction(int ptr, int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static char nativeGetNumber(int ptr, int keyCode) {
        return DSUtils.UNKNOWN_CHAR;
    }

    
        private static char nativeGetMatch(int ptr, int keyCode, char[] chars, int metaState) {
        return DSUtils.UNKNOWN_CHAR;
    }

    
        private static char nativeGetDisplayLabel(int ptr, int keyCode) {
        return DSUtils.UNKNOWN_CHAR;
    }

    
        private static int nativeGetKeyboardType(int ptr) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static KeyEvent[] nativeGetEvents(int ptr, int deviceId, char[] chars) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.801 -0400", hash_original_method = "C46984664DD9459250D6B9D7539380FB", hash_generated_method = "5308CBB561764EEE98811339213C570B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.802 -0400", hash_original_method = "9130955DF84228D9EE103102BFA3B17A", hash_generated_method = "86EE012166D76B7F25180BAAC062715D")
    public int get(int keyCode, int metaState) {
        metaState = KeyEvent.normalizeMetaState(metaState);
        char ch;
        ch = nativeGetCharacter(mPtr, keyCode, metaState);
        int map;
        map = COMBINING.get(ch);
        addTaint(keyCode);
        addTaint(metaState);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055803940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1055803940;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.813 -0400", hash_original_method = "5701A82EAD1DE3F7E3AD5DC604F1A78C", hash_generated_method = "4F132742B2D92D467F20229E068BB66E")
    public boolean getFallbackAction(int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("fallbackAction must not be null");
        } //End block
        metaState = KeyEvent.normalizeMetaState(metaState);
        boolean varCE3900304199253D1A24A3B82C990EE8_2137924457 = (nativeGetFallbackAction(mPtr, keyCode, metaState, outFallbackAction));
        addTaint(keyCode);
        addTaint(metaState);
        addTaint(outFallbackAction.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488404389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488404389;
        // ---------- Original Method ----------
        //if (outFallbackAction == null) {
            //throw new IllegalArgumentException("fallbackAction must not be null");
        //}
        //metaState = KeyEvent.normalizeMetaState(metaState);
        //return nativeGetFallbackAction(mPtr, keyCode, metaState, outFallbackAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.813 -0400", hash_original_method = "6DABCB0117446A751E56C996ECEF0096", hash_generated_method = "E4484D26B81D1D7774788ACB181D95B7")
    public char getNumber(int keyCode) {
        char varDF198814D68AB4A952E3ABC833B9B8A4_1296483301 = (nativeGetNumber(mPtr, keyCode));
        addTaint(keyCode);
        char varA87DEB01C5F539E6BDA34829C8EF2368_921503651 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_921503651;
        // ---------- Original Method ----------
        //return nativeGetNumber(mPtr, keyCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.814 -0400", hash_original_method = "BB5B7EBB644AED6B3730BD9151F78F69", hash_generated_method = "06694A5D9613A109FBA7D809EE9248A1")
    public char getMatch(int keyCode, char[] chars) {
        char var9F0B8F7534FA815F4917D99B8DF1A026_1505914926 = (getMatch(keyCode, chars, 0));
        addTaint(keyCode);
        addTaint(chars[0]);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1423444927 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1423444927;
        // ---------- Original Method ----------
        //return getMatch(keyCode, chars, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.814 -0400", hash_original_method = "41D073D91107291EA05310027D49190C", hash_generated_method = "8ED4385DC2EB00C20C0097F0CBCB7292")
    public char getMatch(int keyCode, char[] chars, int metaState) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("chars must not be null.");
        } //End block
        metaState = KeyEvent.normalizeMetaState(metaState);
        char var1E3A75249CA35C8B1285237F1D55E97D_1829248088 = (nativeGetMatch(mPtr, keyCode, chars, metaState));
        addTaint(keyCode);
        addTaint(chars[0]);
        addTaint(metaState);
        char varA87DEB01C5F539E6BDA34829C8EF2368_19485231 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_19485231;
        // ---------- Original Method ----------
        //if (chars == null) {
            //throw new IllegalArgumentException("chars must not be null.");
        //}
        //metaState = KeyEvent.normalizeMetaState(metaState);
        //return nativeGetMatch(mPtr, keyCode, chars, metaState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.814 -0400", hash_original_method = "6DD5621B8D7662BB0D5EEF29B875BDA1", hash_generated_method = "3F00F54346E043F7825E042718E01DBF")
    public char getDisplayLabel(int keyCode) {
        char var90AE32CAD5C582E5138E2843AD421D47_1411505718 = (nativeGetDisplayLabel(mPtr, keyCode));
        addTaint(keyCode);
        char varA87DEB01C5F539E6BDA34829C8EF2368_562975239 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_562975239;
        // ---------- Original Method ----------
        //return nativeGetDisplayLabel(mPtr, keyCode);
    }

    
        public static int getDeadChar(int accent, int c) {
        return DEAD.get((accent << 16) | c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.816 -0400", hash_original_method = "76D58BCFCDB16C229BEE46626C0804EB", hash_generated_method = "70E8CBE3A70F221BB1855FC42028A937")
    @Deprecated
    public boolean getKeyData(int keyCode, KeyData results) {
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
        addTaint(keyCode);
        addTaint(results.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207248923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207248923;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.834 -0400", hash_original_method = "75C550EBD18DF5C6523832F5B0CC290D", hash_generated_method = "29E08855F4C035923F5D34C77E2ED3BD")
    public KeyEvent[] getEvents(char[] chars) {
        KeyEvent[] varB4EAC82CA7396A68D541C85D26508E83_1857520502 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("chars must not be null.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1857520502 = nativeGetEvents(mPtr, mDeviceId, chars);
        addTaint(chars[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1857520502.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1857520502;
        // ---------- Original Method ----------
        //if (chars == null) {
            //throw new IllegalArgumentException("chars must not be null.");
        //}
        //return nativeGetEvents(mPtr, mDeviceId, chars);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.834 -0400", hash_original_method = "3285F5CD7518CBF681F7E4DAED1719BF", hash_generated_method = "999E1288C3C107B86B93902FB941FC6F")
    public boolean isPrintingKey(int keyCode) {
        int type;
        type = Character.getType(nativeGetDisplayLabel(mPtr, keyCode));
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343918881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343918881;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.835 -0400", hash_original_method = "BA716E54E3F5777C121637287957F9E5", hash_generated_method = "0F7E6044B384397F13BCEED11C88A465")
    public int getKeyboardType() {
        int var5804746570F479E54666D84988DB57C1_1619419518 = (nativeGetKeyboardType(mPtr));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228426075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_228426075;
        // ---------- Original Method ----------
        //return nativeGetKeyboardType(mPtr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.835 -0400", hash_original_method = "1B54B22E072CCA54689C03A0F5698E81", hash_generated_method = "D47FA93F1E3147E4685EECF430A3673A")
    public int getModifierBehavior() {
        {
            Object var6F1F68E94BE9EBA81DD665AD4038DA31_755624669 = (getKeyboardType());
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945982215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945982215;
        // ---------- Original Method ----------
        //switch (getKeyboardType()) {
            //case FULL:
            //case SPECIAL_FUNCTION:
                //return MODIFIER_BEHAVIOR_CHORDED;
            //default:
                //return MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED;
        //}
    }

    
        public static boolean deviceHasKey(int keyCode) {
        int[] codeArray = new int[1];
        codeArray[0] = keyCode;
        boolean[] ret = deviceHasKeys(codeArray);
        return ret[0];
    }

    
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "EDD7E5ACED959081EE73D67CD32E0437", hash_generated_field = "10206615040C9B5E0B40E86C5E399A28")

        public char displayLabel;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "B1BC248A7FF2B2E95569F56DE68615DF", hash_generated_field = "C53E6ECAD71F4994DDB600BCB7228E67")

        public char number;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "31298D406F99FA910E1BB450CB1210C9", hash_generated_field = "B234B5BEA612AD563CF4084101F5BF63")

        public char[] meta = new char[META_LENGTH];
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_method = "AA20F851FEA58DFB4FCE42162FC7E15E", hash_generated_method = "AA20F851FEA58DFB4FCE42162FC7E15E")
        public KeyData ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "605E432175D9C11171F588C24F0372F3", hash_generated_field = "B7B5BF1414600355D7BF1611E9967D65")

        public static final int META_LENGTH = 4;
    }


    
    public static class UnavailableException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_method = "463842D1BF3FEF123617A569E3B89D0B", hash_generated_method = "1BCAB3A4C9C611B069ED152144702993")
        public  UnavailableException(String msg) {
            super(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class FallbackAction {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "B96BEB1FB95F7FA45257BB48942AEF8A", hash_generated_field = "000F6935635EB02934CE0DE5E09F2D3E")

        public int keyCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "A862CA74D6E47B766A6CD7CA4CED384B", hash_generated_field = "5236106FD9BFBDE1EF13C213F3E14407")

        public int metaState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_method = "789B682B3FBE45C1858DC98A8C26817D", hash_generated_method = "789B682B3FBE45C1858DC98A8C26817D")
        public FallbackAction ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "F572C81B0A403AEC5D7042E8DEBF3A2D", hash_generated_field = "59B4829C2D65190B8B4C0FA33230C1E4")

    @Deprecated
    public static final int BUILT_IN_KEYBOARD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "79AA03C4AB09A8A3584C1579611E8AE6", hash_generated_field = "C3770B577FF433B8BFF698D5F722014E")

    public static final int VIRTUAL_KEYBOARD = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "E1852BD6E1BE8C53AE1ED4B95FE0BF31", hash_generated_field = "81DDA812F0A0EF21C694BF5A82F81EE3")

    public static final int NUMERIC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.836 -0400", hash_original_field = "2AF081D98CE272B14B51F84FAA0E87C0", hash_generated_field = "CD3F247AFA1F26ABAD74821769ACFB70")

    public static final int PREDICTIVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.850 -0400", hash_original_field = "93AFCF8B39F04B6FD85150B6E11FA2E9", hash_generated_field = "157B02842601F7C0DED5E95134F38522")

    public static final int ALPHA = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.850 -0400", hash_original_field = "B2A3B389720B89BD78EBD0055A7BDCD2", hash_generated_field = "20E85A6090C38DE3E8C1E3AF96C136F0")

    public static final int FULL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "3B09F063BC168781F3052CA607AD8EE8", hash_generated_field = "89216B40F08E21779835E6D1681D3FBA")

    public static final int SPECIAL_FUNCTION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "43842CE63B7074FC29B707577200F6D1", hash_generated_field = "E6D8ABAEC54AD7FE6AC0637BE6B60C20")

    public static final char HEX_INPUT = '\uEF00';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "DF5D1D35865F8EB5AE22157081925B9F", hash_generated_field = "C292F8608784160E386A6728D1ED3563")

    public static final char PICKER_DIALOG_INPUT = '\uEF01';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "43DD74A09CA1EDEE1CEFB3139D14A179", hash_generated_field = "B89E5758383255A9C827FA145DE8507A")

    public static final int MODIFIER_BEHAVIOR_CHORDED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "F46E5533C1B26A9D7420A875D97AEA38", hash_generated_field = "616FB0D0098A2547A5B190478FA72B55")

    public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "617ADA7708849339281DA72258A7638A", hash_generated_field = "A41BDDB2AF8DD199AC0801E6FA90000D")

    private static SparseArray<KeyCharacterMap> sInstances = new SparseArray<KeyCharacterMap>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "F3D0BF4B53FA5387C07DF0D7E5CFC53E", hash_generated_field = "11B1384F451F38AFF9AFE2392F709751")

    private static SparseIntArray COMBINING = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "24A19292524D0E6F5DC1B44038CDFDE6", hash_generated_field = "B76722FF851A78D583E0DFB3CE65DF2C")

    private static SparseIntArray DEAD = new SparseIntArray();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "E9F57DCC8A8CBAAFECFFEDA39105551C", hash_generated_field = "03F9AD52905A4B975E4C385CC62F4DE5")

    private static int ACUTE = '\u00B4' << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "392D216BCCB4771711DCDAD9FEFA0B04", hash_generated_field = "52B7F0B160B990838F3ACFB12B19C14D")

    private static int GRAVE = '`' << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "FD9819D70B388EB80DFBC874095B0617", hash_generated_field = "C2F32333D4B5714775DFA30A651D1219")

    private static int CIRCUMFLEX = '^' << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "C46C28DB7553734742BEB4717E1B81D4", hash_generated_field = "302B9CDBF18C7EC59EFEEFDF4B67E1EA")

    private static int TILDE = '~' << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "07A28FFCC7E8F1DF227B0987F964832B", hash_generated_field = "DF88278089B2BB63E27B5170D564AC2B")

    private static int UMLAUT = '\u00A8' << 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "5FC5405C81FA99B46E753C2A887CD287", hash_generated_field = "0E06608D3648E37E5411DA551501463D")

    public static final int COMBINING_ACCENT = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:49.851 -0400", hash_original_field = "273265AF6A4B0BAA1779280BF7CEBFC6", hash_generated_field = "0F27E21C7E3F6FCD749479852C67E791")

    public static final int COMBINING_ACCENT_MASK = 0x7FFFFFFF;
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

