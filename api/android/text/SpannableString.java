package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.067 -0500", hash_original_method = "90012DFD660EB52D22F0B732AA7864A9", hash_generated_method = "E865D88B944D0050BC86EF2B1CE2F561")
    
public static SpannableString valueOf(CharSequence source) {
        if (source instanceof SpannableString) {
            return (SpannableString) source;
        } else {
            return new SpannableString(source);
        }
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.061 -0500", hash_original_method = "E921164C349820CE913ADCB9FC3ECE8D", hash_generated_method = "E7827C9A51F3947C52363F7F7A63868F")
    
public SpannableString(CharSequence source) {
        super(source, 0, source.length());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.064 -0500", hash_original_method = "CFA97E25B40B182279BF16FEA76606C4", hash_generated_method = "5E9A332CDC5FDCFABB848DE886135BBA")
    
private SpannableString(CharSequence source, int start, int end) {
        super(source, start, end);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.069 -0500", hash_original_method = "703A4E3A5DC432A077E52C12DF31C39D", hash_generated_method = "981E2E06E7D4115A0BFC2D189CC2436C")
    
public void setSpan(Object what, int start, int end, int flags) {
        super.setSpan(what, start, end, flags);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.072 -0500", hash_original_method = "A032FB453304A8E0F8BC7978F037ECF6", hash_generated_method = "AAC83A74F207840707B5FE26AE6DE953")
    
public void removeSpan(Object what) {
        super.removeSpan(what);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:14.075 -0500", hash_original_method = "2D77EB0B8B2B37960A9B77E6DDEED655", hash_generated_method = "7D96E1C66DED8CD342ADC6C1F18B8170")
    
public final CharSequence subSequence(int start, int end) {
        return new SpannableString(this, start, end);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanEnd(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanEnd(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanFlags(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanFlags(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanStart(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanStart(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public int nextSpanTransition(int start, int limit, Class kind) {
    	addTaint(start);
    	addTaint(limit);
    	addTaint(kind.getTaint());
    	return super.nextSpanTransition(start, limit, kind);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
    	addTaint(queryStart);
    	addTaint(queryEnd);
    	addTaint(kind.getTaint());
    	return super.getSpans(queryStart, queryEnd, kind);
    }
}

