package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.InputType;
import android.text.Spannable;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;

public class DialerKeyListener extends NumberKeyListener {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.636 -0500", hash_original_method = "AE7C568B1FC945A3D62D83ECB6AACC3F", hash_generated_method = "0AA2BB67796C4A68DB2BDF94AD1A65E8")
    
public static DialerKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new DialerKeyListener();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.645 -0500", hash_original_field = "AEC9CBB1D414240D581BAAD5516855F0", hash_generated_field = "4EF1E1883C2FEAA834D956A6C02634B3")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*',
            '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.648 -0500", hash_original_field = "CF91476473FDE63475D47E5A7BFC6493", hash_generated_field = "056A87FCF20D35A01976664357B66FF4")

    private static DialerKeyListener sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.200 -0400", hash_original_method = "DB0B81FF92CA7DAE82B6AED220522587", hash_generated_method = "DB0B81FF92CA7DAE82B6AED220522587")
    public DialerKeyListener ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.633 -0500", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "C8829E311180669DC917FA428AC766DB")
    
@Override
    protected char[] getAcceptedChars()
    {
        return CHARACTERS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.638 -0500", hash_original_method = "CF04961F3F1B69C39A5779241DF2A6D8", hash_generated_method = "CA7F189DF334696BDCB37FC8D67ACEB2")
    
public int getInputType() {
        return InputType.TYPE_CLASS_PHONE;
    }
    
    /**
     * Overrides the superclass's lookup method to prefer the number field
     * from the KeyEvent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.642 -0500", hash_original_method = "660AADB0BB44A0CB147F8CE16CBE33CA", hash_generated_method = "FC81125965E3EF690D9FFFE6CF20E937")
    
protected int lookup(KeyEvent event, Spannable content) {
        int meta = event.getMetaState() | getMetaState(content);
        int number = event.getNumber();

        /*
         * Prefer number if no meta key is active, or if it produces something
         * valid and the meta lookup does not.
         */
        if ((meta & (MetaKeyKeyListener.META_ALT_ON | MetaKeyKeyListener.META_SHIFT_ON)) == 0) {
            if (number != 0) {
                return number;
            }
        }

        int match = super.lookup(event, content);

        if (match != 0) {
            return match;
        } else {
            /*
             * If a meta key is active but the lookup with the meta key
             * did not produce anything, try some other meta keys, because
             * the user might have pressed SHIFT when they meant ALT,
             * or vice versa.
             */

            if (meta != 0) {
                KeyData kd = new KeyData();
                char[] accepted = getAcceptedChars();

                if (event.getKeyData(kd)) {
                    for (int i = 1; i < kd.meta.length; i++) {
                        if (ok(accepted, kd.meta[i])) {
                            return kd.meta[i];
                        }
                    }
                }
            }

            /*
             * Otherwise, use the number associated with the key, since
             * whatever they wanted to do with the meta key does not
             * seem to be valid here.
             */

            return number;
        }
    }
}

