package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.KeyEvent;
import android.text.InputType;

public class TimeKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':'
        };
    private static TimeKeyListener sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.114 -0400", hash_original_method = "F4BD69BECB4A0F93AC68BF98F9909696", hash_generated_method = "00F5B6B88AD75458805AAEDEFB6A9C8D")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
        //| InputType.TYPE_DATETIME_VARIATION_TIME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.114 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "E6C46870770ED289B98202DA6B510228")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.114 -0400", hash_original_method = "E3D1D19A4F0AD3BF112656171BB40F7B", hash_generated_method = "775E9E8EEAE8BFB1441E2E40A07E5EA3")
    public static TimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new TimeKeyListener();
        return sInstance;
    }

    
}


