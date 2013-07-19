package android.text.method;

// Droidsafe Imports
import android.text.InputType;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DateTimeKeyListener extends NumberKeyListener {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.188 -0400", hash_original_method = "A2664B73E6BC35FEDCFE12F8374A7DD3", hash_generated_method = "A2664B73E6BC35FEDCFE12F8374A7DD3")
    public DateTimeKeyListener ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.188 -0400", hash_original_method = "25727FE9AFE9AFBCFB0652DF45BFCF89", hash_generated_method = "B1164289316386EB8C7BCC6D5093A946")
    public int getInputType() {
        int varA329F8A6663354FA4ADE4A33C0BDC051_1334000847 = (InputType.TYPE_CLASS_DATETIME
                | InputType.TYPE_DATETIME_VARIATION_NORMAL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930027830 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1930027830;
        // ---------- Original Method ----------
        //return InputType.TYPE_CLASS_DATETIME
                //| InputType.TYPE_DATETIME_VARIATION_NORMAL;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.189 -0400", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "DC2855547957DD9E0D8229F664A50520")
    @Override
    protected char[] getAcceptedChars() {
        char[] varDC0FB426D37848B5E7EB694843212E7A_233159960 = (CHARACTERS);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_543024551 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_543024551;
        // ---------- Original Method ----------
        //return CHARACTERS;
    }

    
    @DSModeled(DSC.SAFE)
    public static DateTimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new DateTimeKeyListener();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.189 -0400", hash_original_field = "0CDC8D5B282A7B731F0F316B9C3CD5D4", hash_generated_field = "CC28C7351EEFBCCFD2A5481C9E11D592")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':', '/', '-', ' '
        };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.190 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "A08939C26C7FAC41D21C88327D28A913")

    private static DateTimeKeyListener sInstance;
}

