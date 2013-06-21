package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.239 -0400", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "8EA846BC8746A41ED704658F52711F61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableString(CharSequence source) {
        super(source, 0, source.length());
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.239 -0400", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "C7B5187D91336C60FB670D7BBE3F9F8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
        dsTaint.addTaint(source);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
        public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.240 -0400", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "E5C3FFBC320D8846DB3DAD920E132E62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSpan(Object what, int start, int end, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(start);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(end);
        super.setSpan(what, start, end, flags);
        // ---------- Original Method ----------
        //super.setSpan(what, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.240 -0400", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "0772DDA8BA5578C265C3C310A014441E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeSpan(Object what) {
        dsTaint.addTaint(what.dsTaint);
        super.removeSpan(what);
        // ---------- Original Method ----------
        //super.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:56.240 -0400", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "924E8080EF66AF6FDFFD320F97681B83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence var018F0F34B67AF6A8A82A7A770EF8D2D4_156615841 = (new SpannableString(this, start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new SpannableString(this, start, end);
    }

    
}

