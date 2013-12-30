package android.text.style;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.TextPaint;





public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.048 -0400", hash_original_method = "9C185298DCF08F9282BECADE276ABE7A", hash_generated_method = "9C185298DCF08F9282BECADE276ABE7A")
    public MetricAffectingSpan ()
    {
        //Synthesized constructor
    }

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.558 -0500", hash_original_method = "23B402BA1AC5AB3AD12F9524531B1603", hash_generated_method = "BBBACCDADC484D812AFC0022A1AAAF9F")
    
public abstract void updateMeasureState(TextPaint p);

    /**
     * Returns "this" for most MetricAffectingSpans, but for 
     * MetricAffectingSpans that were generated by {@link #wrap},
     * returns the underlying MetricAffectingSpan.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.561 -0500", hash_original_method = "A42CCA74DCEA4DF7BFE10765D4FB4AEF", hash_generated_method = "6A7724B956EB53DBBFA5B080D513BA05")
    
@Override
    public MetricAffectingSpan getUnderlying() {
        return this;
    }

    
    static class Passthrough extends MetricAffectingSpan {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.565 -0500", hash_original_field = "4991F7907A57E8835E40475FDF76A731", hash_generated_field = "3023077BCF3DF01F7D77DA3B9595077A")

        private MetricAffectingSpan mStyle;
        
        /**
         * Creates a new Passthrough of the specfied MetricAffectingSpan.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.568 -0500", hash_original_method = "E5C4C18A2D9007D25412D59B1295CF18", hash_generated_method = "2A50B41D7C22AC32B8DC7CC92F924DC1")
        
public Passthrough(MetricAffectingSpan cs) {
            mStyle = cs;
        }

        /**
         * Passes updateDrawState through to the underlying MetricAffectingSpan.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.571 -0500", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "6A424092A6CF9170B611DF2FD945343C")
        
@Override
        public void updateDrawState(TextPaint tp) {
            mStyle.updateDrawState(tp);
        }

        /**
         * Passes updateMeasureState through to the underlying MetricAffectingSpan.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.574 -0500", hash_original_method = "9605D4D5DDCA8BDD205A07667048DFB8", hash_generated_method = "11A6672E131FD63B9302B23E1FF74E41")
        
@Override
        public void updateMeasureState(TextPaint tp) {
            mStyle.updateMeasureState(tp);
        }
    
        /**
         * Returns the MetricAffectingSpan underlying this one, or the one
         * underlying it if it too is a Passthrough.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:07.577 -0500", hash_original_method = "7E9DC1976758CC762B32217CDDCBF09C", hash_generated_method = "033A37ADBB7AA8262C39A629F24AC131")
        
@Override
        public MetricAffectingSpan getUnderlying() {
            return mStyle.getUnderlying();
        }

        
    }


    
}

