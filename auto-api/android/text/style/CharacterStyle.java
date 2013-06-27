package android.text.style;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextPaint;

public abstract class CharacterStyle {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.525 -0400", hash_original_method = "41D29785B7D143A249368B9153DB6D45", hash_generated_method = "41D29785B7D143A249368B9153DB6D45")
    public CharacterStyle ()
    {
        //Synthesized constructor
    }


    public abstract void updateDrawState(TextPaint tp);

    
        public static CharacterStyle wrap(CharacterStyle cs) {
        if (cs instanceof MetricAffectingSpan) {
            return new MetricAffectingSpan.Passthrough((MetricAffectingSpan) cs);
        } else {
            return new Passthrough(cs);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.527 -0400", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "F9E4DDBB39C0E735EC894FBBBDAE4B75")
    public CharacterStyle getUnderlying() {
        CharacterStyle varB4EAC82CA7396A68D541C85D26508E83_1231119795 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1231119795 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1231119795.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1231119795;
        // ---------- Original Method ----------
        //return this;
    }

    
    private static class Passthrough extends CharacterStyle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.527 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2988350718410D955D2EDCC422F9259B")

        private CharacterStyle mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.527 -0400", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "7C4191215C179AED62D69BA1F57E231B")
        public  Passthrough(CharacterStyle cs) {
            mStyle = cs;
            // ---------- Original Method ----------
            //mStyle = cs;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.528 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "369E67E127669AEDB585086F2FB25E48")
        @Override
        public void updateDrawState(TextPaint tp) {
            mStyle.updateDrawState(tp);
            addTaint(tp.getTaint());
            // ---------- Original Method ----------
            //mStyle.updateDrawState(tp);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:43.528 -0400", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "335272AFFA7B7469C683413CA8CAD4CE")
        @Override
        public CharacterStyle getUnderlying() {
            CharacterStyle varB4EAC82CA7396A68D541C85D26508E83_1135112688 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1135112688 = mStyle.getUnderlying();
            varB4EAC82CA7396A68D541C85D26508E83_1135112688.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1135112688;
            // ---------- Original Method ----------
            //return mStyle.getUnderlying();
        }

        
    }


    
}

