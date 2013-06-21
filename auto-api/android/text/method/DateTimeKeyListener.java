package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.InputType;
import android.view.KeyEvent;

public class DateTimeKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.249 -0400", hash_original_method = "229E30869609547A39891D286F80F3C8", hash_generated_method = "229E30869609547A39891D286F80F3C8")
        public DateTimeKeyListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.250 -0400", hash_original_method = "25727FE9AFE9AFBCFB0652DF45BFCF89", hash_generated_method = "B5027660FA4DA0D2F6B56A02B14ECD62")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.250 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "61C8E7B8858459A83CC3206E283F36CA")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DateTimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateTimeKeyListener();
        return sInstance;
    }

    
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':', '/', '-', ' '
        };
    private static DateTimeKeyListener sInstance;
}

