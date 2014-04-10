package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.112 -0500", hash_original_method = "539B49F662680760BC9E86A48FB585E9", hash_generated_method = "4ED06D04757C54CAA39EF392479C6391")
    
public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.104 -0500", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "4A6488348E6324B35658B4E995BF6910")
    
public SpannedString(CharSequence source) {
        super(source, 0, source.length());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.107 -0500", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "F1BEC7681F02C2BE4351DC910D58F398")
    
private SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:16.109 -0500", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "394B3DAE1CFF0E25780BD36113DBEC45")
    
public CharSequence subSequence(int start, int end) {
        return new SpannedString(this, start, end);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanEnd(Object what) {
    	return super.getSpanEnd(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanFlags(Object what) {
    	return super.getSpanFlags(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getSpanStart(Object what) {
    	return super.getSpanStart(what);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public int nextSpanTransition(int start, int limit, Class kind) {
    	return super.nextSpanTransition(start, limit, kind);
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
    	return super.getSpans(queryStart, queryEnd, kind);
    }
}

