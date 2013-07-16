package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.text.TextPaint;

public abstract class CharacterStyle {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.148 -0400", hash_original_method = "41D29785B7D143A249368B9153DB6D45", hash_generated_method = "41D29785B7D143A249368B9153DB6D45")
    public CharacterStyle ()
    {
        //Synthesized constructor
    }


    public abstract void updateDrawState(TextPaint tp);

    
        @DSModeled(DSC.SAFE)
    public static CharacterStyle wrap(CharacterStyle cs) {
        if (cs instanceof MetricAffectingSpan) {
            return new MetricAffectingSpan.Passthrough((MetricAffectingSpan) cs);
        } else {
            return new Passthrough(cs);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.148 -0400", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "6882906D4A442EBD06DAA7C81918E299")
    public CharacterStyle getUnderlying() {
CharacterStyle var72A74007B2BE62B849F475C7BDA4658B_857289039 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_857289039.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_857289039;
        // ---------- Original Method ----------
        //return this;
    }

    
    private static class Passthrough extends CharacterStyle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.149 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2988350718410D955D2EDCC422F9259B")

        private CharacterStyle mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.149 -0400", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "7C4191215C179AED62D69BA1F57E231B")
        public  Passthrough(CharacterStyle cs) {
            mStyle = cs;
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.149 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "3A3D6E74F3849EDBCC3DCC67692ECFF5")
        @Override
        public void updateDrawState(TextPaint tp) {
            addTaint(tp.getTaint());
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.150 -0400", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "1120D2D5C445CFC6C9287FA2C9DE50ED")
        @Override
        public CharacterStyle getUnderlying() {
CharacterStyle varA3CF534B61190E20D264779841BB2C63_2037012502 =             mStyle.getUnderlying();
            varA3CF534B61190E20D264779841BB2C63_2037012502.addTaint(taint);
            return varA3CF534B61190E20D264779841BB2C63_2037012502;
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

