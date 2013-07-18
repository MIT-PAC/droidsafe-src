package android.text;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.164 -0400", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "20E1E75AF107D5F8E163BB49702D5024")
    public  SpannableString(CharSequence source) {
        super(source, 0, source.length());
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.164 -0400", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "A900290735F98D1C9E24F41AD67768A1")
    private  SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
        addTaint(end);
        addTaint(start);
        addTaint(source.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.165 -0400", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "2361D7D328A7F3BF1F9ECD27B2116ADB")
    public void setSpan(Object what, int start, int end, int flags) {
        addTaint(flags);
        addTaint(end);
        addTaint(start);
        addTaint(what.getTaint());
        super.setSpan(what, start, end, flags);
        // ---------- Original Method ----------
        //super.setSpan(what, start, end, flags);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.165 -0400", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "F2752D37D80B46081044EB4AE497BB9C")
    public void removeSpan(Object what) {
        addTaint(what.getTaint());
        super.removeSpan(what);
        // ---------- Original Method ----------
        //super.removeSpan(what);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:37.166 -0400", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "CF8513136D86C3297E9B6E17F5D3220D")
    public final CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var27949C1B6C468F63F8F1B1AFE2B5C1F4_1601050839 =         new SpannableString(this, start, end);
        var27949C1B6C468F63F8F1B1AFE2B5C1F4_1601050839.addTaint(taint);
        return var27949C1B6C468F63F8F1B1AFE2B5C1F4_1601050839;
        // ---------- Original Method ----------
        //return new SpannableString(this, start, end);
    }

    
}

