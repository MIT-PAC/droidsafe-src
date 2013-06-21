package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.text.InputType;

public class TimeKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.736 -0400", hash_original_method = "ECD715E30449C0E68E0F39C92E20F629", hash_generated_method = "ECD715E30449C0E68E0F39C92E20F629")
        public TimeKeyListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.745 -0400", hash_original_method = "F4BD69BECB4A0F93AC68BF98F9909696", hash_generated_method = "C0003A2CBC2A336F0720F66E5C3561A1")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
        //| InputType.TYPE_DATETIME_VARIATION_TIME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.746 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "61C8E7B8858459A83CC3206E283F36CA")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static TimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new TimeKeyListener();
        return sInstance;
    }

    
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':'
        };
    private static TimeKeyListener sInstance;
}

