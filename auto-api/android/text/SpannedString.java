package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.497 -0400", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "BC6263CB797A4009A1244A036B105D5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannedString(CharSequence source) {
        super(source, 0, source.length());
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.497 -0400", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "ABD6982C18DF09003144B8AE197E5108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
        dsTaint.addTaint(source);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.497 -0400", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "8CF8BB9706F8D4467CBFCBA328BCC221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence var33C4681454ADC1D135B7B3741BCD3506_1723733819 = (new SpannedString(this, start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new SpannedString(this, start, end);
    }

    
        public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }

    
}

