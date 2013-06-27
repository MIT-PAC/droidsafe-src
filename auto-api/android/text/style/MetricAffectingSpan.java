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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.693 -0400", hash_original_method = "9C185298DCF08F9282BECADE276ABE7A", hash_generated_method = "9C185298DCF08F9282BECADE276ABE7A")
    public MetricAffectingSpan ()
    {
        //Synthesized constructor
    }


    public abstract void updateMeasureState(TextPaint p);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.693 -0400", hash_original_method = "A42CCA74DCEA4DF7BFE10765D4FB4AEF", hash_generated_method = "E2464C6F86430AC04B166E865C7B0354")
    @Override
    public MetricAffectingSpan getUnderlying() {
        MetricAffectingSpan varB4EAC82CA7396A68D541C85D26508E83_128804508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_128804508 = this;
        varB4EAC82CA7396A68D541C85D26508E83_128804508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128804508;
        // ---------- Original Method ----------
        //return this;
    }

    
    static class Passthrough extends MetricAffectingSpan {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.694 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "3023077BCF3DF01F7D77DA3B9595077A")

        private MetricAffectingSpan mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.694 -0400", hash_original_method = "E5C4C18A2D9007D25412D59B1295CF18", hash_generated_method = "75C2CC207212A07203A3BA36C4AE0A96")
        public  Passthrough(MetricAffectingSpan cs) {
            mStyle = cs;
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.694 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "369E67E127669AEDB585086F2FB25E48")
        @Override
        public void updateDrawState(TextPaint tp) {
            mStyle.updateDrawState(tp);
            addTaint(tp.getTaint());
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.695 -0400", hash_original_method = "9605D4D5DDCA8BDD205A07667048DFB8", hash_generated_method = "23DB25234E9C3317B2CDB48546F5BAFD")
        @Override
        public void updateMeasureState(TextPaint tp) {
            mStyle.updateMeasureState(tp);
            addTaint(tp.getTaint());
            // ---------- Original Method ----------
            //mStyle.updateMeasureState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:45.696 -0400", hash_original_method = "7E9DC1976758CC762B32217CDDCBF09C", hash_generated_method = "55D1EBDB9C29DE90B774F33FE3D7342F")
        @Override
        public MetricAffectingSpan getUnderlying() {
            MetricAffectingSpan varB4EAC82CA7396A68D541C85D26508E83_1043205667 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1043205667 = mStyle.getUnderlying();
            varB4EAC82CA7396A68D541C85D26508E83_1043205667.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1043205667;
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

