package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.TextPaint;

public abstract class CharacterStyle {

    /**
     * A given CharacterStyle can only applied to a single region of a given
     * Spanned.  If you need to attach the same CharacterStyle to multiple
     * regions, you can use this method to wrap it with a new object that
     * will have the same effect but be a distinct object so that it can
     * also be attached without conflict.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.025 -0500", hash_original_method = "46FD3049FFDEA6A9F7272E8860D8996C", hash_generated_method = "1F3D2CA3D63B80A74836D378DF6D34AD")
    
public static CharacterStyle wrap(CharacterStyle cs) {
        if (cs instanceof MetricAffectingSpan) {
            return new MetricAffectingSpan.Passthrough((MetricAffectingSpan) cs);
        } else {
            return new Passthrough(cs);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.946 -0400", hash_original_method = "41D29785B7D143A249368B9153DB6D45", hash_generated_method = "41D29785B7D143A249368B9153DB6D45")
    public CharacterStyle ()
    {
        //Synthesized constructor
    }
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.023 -0500", hash_original_method = "A7CB129018CAB1D6E00B4257A5DD40C7", hash_generated_method = "E9239D9CBE9B8539B1706DDB833ED8BE")
    
public abstract void updateDrawState(TextPaint tp);

    /**
     * Returns "this" for most CharacterStyles, but for CharacterStyles
     * that were generated by {@link #wrap}, returns the underlying
     * CharacterStyle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.028 -0500", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "1ED4DD8B25B170A8C5BABD6026A42346")
    
public CharacterStyle getUnderlying() {
        return this;
    }
    
    private static class Passthrough extends CharacterStyle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.031 -0500", hash_original_field = "2D4714C83DB3A38025A4471E85EE4610", hash_generated_field = "2988350718410D955D2EDCC422F9259B")

        private CharacterStyle mStyle;

        /**
         * Creates a new Passthrough of the specfied CharacterStyle.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.035 -0500", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "446DCE067274841E410E3AC8D6D8208B")
        
public Passthrough(CharacterStyle cs) {
            mStyle = cs;
        }

        /**
         * Passes updateDrawState through to the underlying CharacterStyle.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.037 -0500", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "6A424092A6CF9170B611DF2FD945343C")
        
@Override
        public void updateDrawState(TextPaint tp) {
            mStyle.updateDrawState(tp);
        }

        /**
         * Returns the CharacterStyle underlying this one, or the one
         * underlying it if it too is a Passthrough.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:08.040 -0500", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "6917F786A55D3D8FD11FDADEE6AEC4AF")
        
@Override
        public CharacterStyle getUnderlying() {
            return mStyle.getUnderlying();
        }
        
    }
    
}

