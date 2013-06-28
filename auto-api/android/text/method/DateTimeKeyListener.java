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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.098 -0400", hash_original_method = "A2664B73E6BC35FEDCFE12F8374A7DD3", hash_generated_method = "A2664B73E6BC35FEDCFE12F8374A7DD3")
    public DateTimeKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.099 -0400", hash_original_method = "25727FE9AFE9AFBCFB0652DF45BFCF89", hash_generated_method = "C4038243DAFB326B588EEAAD291E7FE1")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273757891 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273757891;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_NORMAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.099 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "5D2BCB14A9E7257382CB28EB6072C601")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_322276856 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_322276856;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    public static DateTimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateTimeKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.099 -0400", hash_original_field = "0CDC8D5B282A7B731F0F316B9C3CD5D4", hash_generated_field = "CC28C7351EEFBCCFD2A5481C9E11D592")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':', '/', '-', ' '
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.100 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "A08939C26C7FAC41D21C88327D28A913")

    private static DateTimeKeyListener sInstance;
}

