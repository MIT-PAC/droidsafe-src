package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:54.484 -0500", hash_original_method = "539B49F662680760BC9E86A48FB585E9", hash_generated_method = "4ED06D04757C54CAA39EF392479C6391")
    public static SpannedString valueOf(CharSequence source) {
        if (source instanceof SpannedString) {
            return (SpannedString) source;
        } else {
            return new SpannedString(source);
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:54.482 -0500", hash_original_method = "9F76D9B76481417FB492CEBE18B667F5", hash_generated_method = "4A6488348E6324B35658B4E995BF6910")
    public SpannedString(CharSequence source) {
        super(source, 0, source.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:54.483 -0500", hash_original_method = "E05868F8FE8E68E6279EDAD3C69CD063", hash_generated_method = "F1BEC7681F02C2BE4351DC910D58F398")
    private SpannedString(CharSequence source, int start, int end) {
        super(source, start, end);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:54.484 -0500", hash_original_method = "5C8F718730EE97469BD91F870902B78A", hash_generated_method = "394B3DAE1CFF0E25780BD36113DBEC45")
    public CharSequence subSequence(int start, int end) {
        return new SpannedString(this, start, end);
    }

    @DSModeled(DSC.SAFE)
    public int getSpanEnd(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanEnd(what);
    }
    
    @DSModeled(DSC.SAFE)
    public int getSpanFlags(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanFlags(what);
    }
    
    @DSModeled(DSC.SAFE)
    public int getSpanStart(Object what) {
    	addTaint(what.getTaint());
    	return super.getSpanStart(what);
    }
    
    @DSModeled(DSC.SAFE)
    public int nextSpanTransition(int start, int limit, Class kind) {
    	addTaint(start);
    	addTaint(limit);
    	addTaint(kind.getTaint());
    	return super.nextSpanTransition(start, limit, kind);
    }
    
    @DSModeled(DSC.SAFE)
    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> kind) {
    	addTaint(queryStart);
    	addTaint(queryEnd);
    	addTaint(kind.getTaint());
    	return super.getSpans(queryStart, queryEnd, kind);
    }
}

