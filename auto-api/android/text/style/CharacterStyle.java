package android.text.style;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.text.TextPaint;

public abstract class CharacterStyle {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.715 -0400", hash_original_method = "41D29785B7D143A249368B9153DB6D45", hash_generated_method = "41D29785B7D143A249368B9153DB6D45")
    public CharacterStyle ()
    {
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.716 -0400", hash_original_method = "2ADDE7DAB4ECDACBF15B0CE8CBCF2C82", hash_generated_method = "05E213D7BDA4915A7C59A56863471867")
    public CharacterStyle getUnderlying() {
        CharacterStyle varB4EAC82CA7396A68D541C85D26508E83_615117266 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_615117266 = this;
        varB4EAC82CA7396A68D541C85D26508E83_615117266.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_615117266;
        
        
    }

    
    private static class Passthrough extends CharacterStyle {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.716 -0400", hash_original_field = "16896C9E7463BF6DF9DB6B58257F1327", hash_generated_field = "2988350718410D955D2EDCC422F9259B")

        private CharacterStyle mStyle;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.716 -0400", hash_original_method = "CAC991CB238644E494D2A55B9FB554CC", hash_generated_method = "7C4191215C179AED62D69BA1F57E231B")
        public  Passthrough(CharacterStyle cs) {
            mStyle = cs;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.716 -0400", hash_original_method = "813F80F60D9F0493A35140828DCD41CA", hash_generated_method = "369E67E127669AEDB585086F2FB25E48")
        @Override
        public void updateDrawState(TextPaint tp) {
            mStyle.updateDrawState(tp);
            addTaint(tp.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.717 -0400", hash_original_method = "1F67DF9DEB8C0E16558BBAAD1B5FDCCE", hash_generated_method = "F72237DA7CB16163587A3E05AB2F7156")
        @Override
        public CharacterStyle getUnderlying() {
            CharacterStyle varB4EAC82CA7396A68D541C85D26508E83_1083474636 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1083474636 = mStyle.getUnderlying();
            varB4EAC82CA7396A68D541C85D26508E83_1083474636.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1083474636;
            
            
        }

        
    }


    
}

