package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.text.InputType;

public class DateKeyListener extends NumberKeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.453 -0400", hash_original_method = "09F9B6EA4C38704CC9648D105D359284", hash_generated_method = "09F9B6EA4C38704CC9648D105D359284")
    public DateKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.453 -0400", hash_original_method = "FAAA10DF871CFF7A2AF0FCDCA83E30F3", hash_generated_method = "B20C8A7628FD65A1968FDDF8D62A3CE1")
    public int getInputType() {
        int var91A319F19AC580743036D8D08FB7B325_1702874678 = (InputType.TYPE_CLASS_DATETIME
                | InputType.TYPE_DATETIME_VARIATION_DATE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604172762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604172762;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_DATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.454 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "2E38334B4D922250DDD8440BECE1D8B4")
    @Override
    protected char[] getAcceptedChars() {
        char[] varDC0FB426D37848B5E7EB694843212E7A_461717685 = (CHARACTERS);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1772903520 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1772903520;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        public static DateKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.454 -0400", hash_original_field = "5540D0A9AFB5BB5B1D50DF52A28BFDFC", hash_generated_field = "6417CC602ED83242D282A9E4E0224150")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '/', '-', '.'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.454 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "6773A635B34EF84E192EA12F2E9E0C08")

    private static DateKeyListener sInstance;
}

