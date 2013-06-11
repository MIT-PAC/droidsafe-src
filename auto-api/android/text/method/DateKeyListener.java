package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.view.KeyEvent;
import android.text.InputType;

public class DateKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '/', '-', '.'
        };
    private static DateKeyListener sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.039 -0400", hash_original_method = "FAAA10DF871CFF7A2AF0FCDCA83E30F3", hash_generated_method = "F2F1D3A71038962244C9DFA5F0B813B7")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_DATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.039 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "E6C46870770ED289B98202DA6B510228")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.039 -0400", hash_original_method = "C1FF2F03ED98B7DB4C979A07E5F21A3F", hash_generated_method = "CDBA412E6107F33E828C513B6AD48AC7")
    public static DateKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateKeyListener();
        return sInstance;
    }

    
}


