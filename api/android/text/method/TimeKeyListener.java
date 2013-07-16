package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.text.InputType;

public class TimeKeyListener extends NumberKeyListener {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.976 -0400", hash_original_method = "B9206F846F22DC573861D1007C9C3102", hash_generated_method = "B9206F846F22DC573861D1007C9C3102")
    public TimeKeyListener ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.976 -0400", hash_original_method = "F4BD69BECB4A0F93AC68BF98F9909696", hash_generated_method = "7DFDFA387C6D2074EEED5985DBE39B02")
    public int getInputType() {
        int varD246EFE5F276BE1F0BEC3AD30E675F9C_496056513 = (InputType.TYPE_CLASS_DATETIME
        | InputType.TYPE_DATETIME_VARIATION_TIME);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595513194 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595513194;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
        //| InputType.TYPE_DATETIME_VARIATION_TIME;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.976 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "2E27BBDBCDC3FA8254028214206C9CCC")
    @Override
    protected char[] getAcceptedChars() {
        char[] varDC0FB426D37848B5E7EB694843212E7A_1067929551 = (CHARACTERS);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1921055522 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1921055522;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
        @DSModeled(DSC.SAFE)
    public static TimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new TimeKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.977 -0400", hash_original_field = "DEA1215DA20ECE3BA7009C3B4A86A901", hash_generated_field = "03D6010F82701EA810C482FC784D2E6D")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':'
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.977 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "33355AAAF3221ACB9E3222BB6726B57D")

    private static TimeKeyListener sInstance;
}

