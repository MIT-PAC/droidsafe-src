package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.graphics.Paint;
import android.text.TextPaint;

public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {
    
    public abstract void updateMeasureState(TextPaint p);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.306 -0400", hash_original_method = "A42CCA74DCEA4DF7BFE10765D4FB4AEF", hash_generated_method = "2669DBB4398CB99E701DB472B600FA13")
    @DSModeled(DSC.SAFE)
    @Override
    public MetricAffectingSpan getUnderlying() {
        return (MetricAffectingSpan)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    static class Passthrough extends MetricAffectingSpan {
        private MetricAffectingSpan mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.306 -0400", hash_original_method = "E5C4C18A2D9007D25412D59B1295CF18", hash_generated_method = "3B94BFFD6CFF79B903EAD80A8AC7E72F")
        @DSModeled(DSC.SAFE)
        public Passthrough(MetricAffectingSpan cs) {
            dsTaint.addTaint(cs.dsTaint);
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.306 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "7930B665CDBD48FC47727250062097A5")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateDrawState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.306 -0400", hash_original_method = "9605D4D5DDCA8BDD205A07667048DFB8", hash_generated_method = "E7F8CDB7D13B8F0D889A300865A730EA")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateMeasureState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateMeasureState(tp);
            // ---------- Original Method ----------
            //mStyle.updateMeasureState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.306 -0400", hash_original_method = "7E9DC1976758CC762B32217CDDCBF09C", hash_generated_method = "3635EA86DFE0FB0CA4FE1C7179700494")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public MetricAffectingSpan getUnderlying() {
            MetricAffectingSpan varA2CC679CE5B8D13CD0277BDEBCBD5DC3_1523972093 = (mStyle.getUnderlying());
            return (MetricAffectingSpan)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}


