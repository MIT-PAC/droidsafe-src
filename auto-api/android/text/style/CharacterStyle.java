package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.TextPaint;

public abstract class CharacterStyle {
    
    public abstract void updateDrawState(TextPaint tp);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.300 -0400", hash_original_method = "46FD3049FFDEA6A9F7272E8860D8996C", hash_generated_method = "1F3D2CA3D63B80A74836D378DF6D34AD")
    public static CharacterStyle wrap(CharacterStyle cs) {
        if (cs instanceof MetricAffectingSpan) {
            return new MetricAffectingSpan.Passthrough((MetricAffectingSpan) cs);
        } else {
            return new Passthrough(cs);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.300 -0400", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "280EBF3F88CA94F7053B37ACD0129097")
    @DSModeled(DSC.SAFE)
    public CharacterStyle getUnderlying() {
        return (CharacterStyle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    private static class Passthrough extends CharacterStyle {
        private CharacterStyle mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.301 -0400", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "D3F71B8019DB684257311EC700892E37")
        @DSModeled(DSC.SAFE)
        public Passthrough(CharacterStyle cs) {
            dsTaint.addTaint(cs.dsTaint);
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.301 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "7930B665CDBD48FC47727250062097A5")
        @DSModeled(DSC.SAFE)
        @Override
        public void updateDrawState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.301 -0400", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "3740B3D9665C09B26E2CAE6592B89112")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharacterStyle getUnderlying() {
            CharacterStyle varA2CC679CE5B8D13CD0277BDEBCBD5DC3_441888873 = (mStyle.getUnderlying());
            return (CharacterStyle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}


