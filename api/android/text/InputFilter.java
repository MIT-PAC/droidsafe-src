package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface InputFilter
{
    
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend);
    
    public static class AllCaps implements InputFilter {
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.429 -0500", hash_original_method = "392236ADF541238A40DFC3B3753C1658", hash_generated_method = "7E863F0DA57571D45D4D2F551974AA1A")
        
public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                if (Character.isLowerCase(source.charAt(i))) {
                    char[] v = new char[end - start];
                    TextUtils.getChars(source, start, end, v, 0);
                    String s = new String(v).toUpperCase();

                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(s);
                        TextUtils.copySpansFrom((Spanned) source,
                                                start, end, null, sp, 0);
                        return sp;
                    } else {
                        return s;
                    }
                }
            }

            return null; // keep original
        }
    }
    
    public static class LengthFilter implements InputFilter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.440 -0500", hash_original_field = "643806E929E292CCE314B6AD18027C00", hash_generated_field = "A1BFCC57A6BC96010A1D330EF07F3F34")

        private int mMax;
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.434 -0500", hash_original_method = "4BD8849ECCC45157F027B9AF525845B3", hash_generated_method = "9FC707840500FFDDE513A05D62105AF1")
        
public LengthFilter(int max) {
            mMax = max;
        }

        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:03.437 -0500", hash_original_method = "2770965FD66252C6276892DF71DEBA78", hash_generated_method = "6C028445C288B55693557E488059FF77")
        
public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            int keep = mMax - (dest.length() - (dend - dstart));

            if (keep <= 0) {
                return "";
            } else if (keep >= end - start) {
                return null; // keep original
            } else {
                keep += start;
                if (Character.isHighSurrogate(source.charAt(keep - 1))) {
                    --keep;
                    if (keep == start) {
                        return "";
                    }
                }
                return source.subSequence(start, keep);
            }
        }
    }
}
