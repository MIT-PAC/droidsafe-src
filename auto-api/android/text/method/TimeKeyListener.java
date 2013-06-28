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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.587 -0400", hash_original_method = "B9206F846F22DC573861D1007C9C3102", hash_generated_method = "B9206F846F22DC573861D1007C9C3102")
    public TimeKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.588 -0400", hash_original_method = "F4BD69BECB4A0F93AC68BF98F9909696", hash_generated_method = "EA56203D5149C4E554675C770FF5813B")
    public int getInputType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410975102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410975102;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
        //| InputType.TYPE_DATETIME_VARIATION_TIME;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.588 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "C3FE695B5701C2707FF45D15868D5F08")
    @Override
    protected char[] getAcceptedChars() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_322206677 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_322206677;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    public static TimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new TimeKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.589 -0400", hash_original_field = "DEA1215DA20ECE3BA7009C3B4A86A901", hash_generated_field = "03D6010F82701EA810C482FC784D2E6D")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.589 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "33355AAAF3221ACB9E3222BB6726B57D")

    private static TimeKeyListener sInstance;
}

