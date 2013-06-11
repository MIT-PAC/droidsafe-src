package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.219 -0400", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "7F4D38F2551FA89A2756671892164FD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannedString(CharSequence source) {
        super(source, 0, source.length());
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.219 -0400", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "2A4DB47D4980DBE4C8E359A4FEA2B694")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
        dsTaint.addTaint(source);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.219 -0400", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "61B4A63BB1B231C118DDA48450528FD3")
    @DSModeled(DSC.SAFE)
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new SpannedString(this, start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.219 -0400", hash_original_method = "539B49F662680760BC9E86A48FB585E9", hash_generated_method = "4ED06D04757C54CAA39EF392479C6391")
    public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }

    
}


