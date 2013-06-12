package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.InputType;
import android.view.KeyEvent;

public class DateTimeKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':', '/', '-', ' '
        };
    private static DateTimeKeyListener sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.040 -0400", hash_original_method = "25727FE9AFE9AFBCFB0652DF45BFCF89", hash_generated_method = "486C430EF50B65D74CE3E10DDBABF788")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.040 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "E6C46870770ED289B98202DA6B510228")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.040 -0400", hash_original_method = "274B4DE16BC594B6FC9A8F011B07B7B9", hash_generated_method = "EB46540C8FA44FCAF90CACA2D50FEE90")
    public static DateTimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateTimeKeyListener();
        return sInstance;
    }

    
}


