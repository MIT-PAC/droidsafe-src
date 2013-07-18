package android.text.style;

// Droidsafe Imports
import android.text.TextPaint;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.048 -0400", hash_original_method = "9C185298DCF08F9282BECADE276ABE7A", hash_generated_method = "9C185298DCF08F9282BECADE276ABE7A")
    public MetricAffectingSpan ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void updateMeasureState(TextPaint p);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.048 -0400", hash_original_method = "A42CCA74DCEA4DF7BFE10765D4FB4AEF", hash_generated_method = "C923AC1ACE9BB079441A96E6D87108C6")
    @Override
    public MetricAffectingSpan getUnderlying() {
MetricAffectingSpan var72A74007B2BE62B849F475C7BDA4658B_1480144706 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1480144706.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1480144706;
        // ---------- Original Method ----------
        //return this;
    }

    
    static class Passthrough extends MetricAffectingSpan {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.049 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "3023077BCF3DF01F7D77DA3B9595077A")

        private MetricAffectingSpan mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.049 -0400", hash_original_method = "E5C4C18A2D9007D25412D59B1295CF18", hash_generated_method = "75C2CC207212A07203A3BA36C4AE0A96")
        public  Passthrough(MetricAffectingSpan cs) {
            mStyle = cs;
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.049 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "3A3D6E74F3849EDBCC3DCC67692ECFF5")
        @Override
        public void updateDrawState(TextPaint tp) {
            addTaint(tp.getTaint());
            mStyle.updateDrawState(tp);
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.050 -0400", hash_original_method = "9605D4D5DDCA8BDD205A07667048DFB8", hash_generated_method = "083C6A7FF9C64E54D4B0FB944A0FE568")
        @Override
        public void updateMeasureState(TextPaint tp) {
            addTaint(tp.getTaint());
            mStyle.updateMeasureState(tp);
            // ---------- Original Method ----------
            //mStyle.updateMeasureState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.050 -0400", hash_original_method = "7E9DC1976758CC762B32217CDDCBF09C", hash_generated_method = "5D2E9495280E3A623429CE13B2D223F0")
        @Override
        public MetricAffectingSpan getUnderlying() {
MetricAffectingSpan varA3CF534B61190E20D264779841BB2C63_944194829 =             mStyle.getUnderlying();
            varA3CF534B61190E20D264779841BB2C63_944194829.addTaint(taint);
            return varA3CF534B61190E20D264779841BB2C63_944194829;
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

