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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.550 -0400", hash_original_method = "09F9B6EA4C38704CC9648D105D359284", hash_generated_method = "09F9B6EA4C38704CC9648D105D359284")
    public DateKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.551 -0400", hash_original_method = "FAAA10DF871CFF7A2AF0FCDCA83E30F3", hash_generated_method = "A6CDD083D4C950540808AA56B25A4AFC")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672127281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672127281;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_DATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.551 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "58FC95B635F9B1B32ECE603F7E11820B")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1596364437 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1596364437;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DateKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.551 -0400", hash_original_field = "5540D0A9AFB5BB5B1D50DF52A28BFDFC", hash_generated_field = "6417CC602ED83242D282A9E4E0224150")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '/', '-', '.'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:41.551 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "6773A635B34EF84E192EA12F2E9E0C08")

    private static DateKeyListener sInstance;
}

