package android.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.141 -0400", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "A7E6614F4BEE6464EAD8FB28B8D449AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpannableString(CharSequence source) {
        super(source, 0, source.length());
        dsTaint.addTaint(source);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.141 -0400", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "2A202C955024B1536DF4431911CBE468")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
        dsTaint.addTaint(source);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.142 -0400", hash_original_method = "90012DFD660EB52D22F0B732AA7864A9", hash_generated_method = "E865D88B944D0050BC86EF2B1CE2F561")
    public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.142 -0400", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "3FDFCFEA2F39D2B4F6AB1ACBCE87F91C")
    @DSModeled(DSC.SAFE)
    public void setSpan(Object what, int start, int end, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(what.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        super.setSpan(what, start, end, flags);
        // ---------- Original Method ----------
        //super.setSpan(what, start, end, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.142 -0400", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "C257C42F3987A52971DFD11B737A0915")
    @DSModeled(DSC.SAFE)
    public void removeSpan(Object what) {
        dsTaint.addTaint(what.dsTaint);
        super.removeSpan(what);
        // ---------- Original Method ----------
        //super.removeSpan(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.142 -0400", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "368FB3729B02D4A48FAA58F28A6B6942")
    @DSModeled(DSC.SAFE)
    public final CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return new SpannableString(this, start, end);
    }

    
}


