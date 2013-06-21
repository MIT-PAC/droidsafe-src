package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextPaint;

public abstract class CharacterStyle {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.827 -0400", hash_original_method = "839A8E46E465181FCE6461B2975F7AFA", hash_generated_method = "839A8E46E465181FCE6461B2975F7AFA")
        public CharacterStyle ()
    {
    }


    public abstract void updateDrawState(TextPaint tp);

    
        public static CharacterStyle wrap(CharacterStyle cs) {
        if (cs instanceof MetricAffectingSpan) {
            return new MetricAffectingSpan.Passthrough((MetricAffectingSpan) cs);
        } else {
            return new Passthrough(cs);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.828 -0400", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "BBF890D271B5763B96F346544B50460C")
    @DSModeled(DSC.SAFE)
    public CharacterStyle getUnderlying() {
        return (CharacterStyle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this;
    }

    
    private static class Passthrough extends CharacterStyle {
        private CharacterStyle mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.828 -0400", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "8895CAC943D5C790A5EEC260C14D17EE")
        @DSModeled(DSC.SAFE)
        public Passthrough(CharacterStyle cs) {
            dsTaint.addTaint(cs.dsTaint);
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.828 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "0D947C76B3853EC9A9B3AEAABC5DE2B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void updateDrawState(TextPaint tp) {
            dsTaint.addTaint(tp.dsTaint);
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.829 -0400", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "4997C80DE04D8588CE3E8471241A0626")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public CharacterStyle getUnderlying() {
            CharacterStyle varA2CC679CE5B8D13CD0277BDEBCBD5DC3_435034832 = (mStyle.getUnderlying());
            return (CharacterStyle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

