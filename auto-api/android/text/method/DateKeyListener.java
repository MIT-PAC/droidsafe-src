package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.text.InputType;

public class DateKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.248 -0400", hash_original_method = "5ED9C17AC2C763DF46AA447C7259D26F", hash_generated_method = "5ED9C17AC2C763DF46AA447C7259D26F")
        public DateKeyListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.248 -0400", hash_original_method = "FAAA10DF871CFF7A2AF0FCDCA83E30F3", hash_generated_method = "B9664FE7989E39C46F52C6050B2BE54E")
    @DSModeled(DSC.SAFE)
    public int getInputType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_DATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.248 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "61C8E7B8858459A83CC3206E283F36CA")
    @DSModeled(DSC.SAFE)
    @Override
    protected char[] getAcceptedChars() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DateKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateKeyListener();
        return sInstance;
    }

    
    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '/', '-', '.'
        };
    private static DateKeyListener sInstance;
}

