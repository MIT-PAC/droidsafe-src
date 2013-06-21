package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Paint;
import android.text.TextPaint;

public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.887 -0400", hash_original_method = "7B522B7071675157A69FBA789DE610E3", hash_generated_method = "7B522B7071675157A69FBA789DE610E3")
        public MetricAffectingSpan ()
    {
    }


    public abstract void updateMeasureState(TextPaint p);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.887 -0400", hash_original_method = "A42CCA74DCEA4DF7BFE10765D4FB4AEF", hash_generated_method = "F9D0432E719C8CAA0987A248D22A1615")
    @DSModeled(DSC.SAFE)
    @Override
    public MetricAffectingSpan getUnderlying() {
        return (MetricAffectingSpan)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    static class Passthrough extends MetricAffectingSpan {
        private MetricAffectingSpan mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.888 -0400", hash_original_method = "E5C4C18A2D9007D25412D59B1295CF18", hash_generated_method = "315AC392DAA2AB4F74C15F6F42EBAC5D")
        @DSModeled(DSC.SAFE)
        public Passthrough(MetricAffectingSpan cs) {
            dsTaint.addTaint(cs.dsTaint);
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.888 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "0D947C76B3853EC9A9B3AEAABC5DE2B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateDrawState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.888 -0400", hash_original_method = "9605D4D5DDCA8BDD205A07667048DFB8", hash_generated_method = "0785AB1B741AB9C09692FA5E393BDC61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateMeasureState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateMeasureState(tp);
            // ---------- Original Method ----------
            //mStyle.updateMeasureState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.891 -0400", hash_original_method = "7E9DC1976758CC762B32217CDDCBF09C", hash_generated_method = "7DCB260E313F2B673D7CB0B3BA263243")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public MetricAffectingSpan getUnderlying() {
            MetricAffectingSpan varA2CC679CE5B8D13CD0277BDEBCBD5DC3_770369729 = (mStyle.getUnderlying());
            return (MetricAffectingSpan)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

