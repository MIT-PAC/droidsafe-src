package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.741 -0400", hash_original_method = "074F6C7ED6DAD038000402E905AE4BC7", hash_generated_method = "074F6C7ED6DAD038000402E905AE4BC7")
    public PagerTitleStripIcs ()
    {
        
    }


    public static void setSingleLineAllCaps(TextView text) {
        text.setTransformationMethod(new SingleLineAllCapsTransform(text.getContext()));
    }

    
    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.743 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

        private Locale mLocale;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.745 -0400", hash_original_method = "4C2D06E04273338AC4EC5853A2EDD665", hash_generated_method = "4C6AABE92D596FF9D5C5396F62BCD445")
        public  SingleLineAllCapsTransform(Context context) {
            mLocale = context.getResources().getConfiguration().locale;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.750 -0400", hash_original_method = "D86D9A1AA103AB45F13A7134C7371BA5", hash_generated_method = "F391397154C9B778654C1F21E92AC7E5")
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1204676340 = null; 
            source = super.getTransformation(source, view);
            varB4EAC82CA7396A68D541C85D26508E83_1204676340 = source != null ? source.toString().toUpperCase(mLocale) : null;
            addTaint(source.getTaint());
            addTaint(view.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1204676340.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1204676340;
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.751 -0400", hash_original_field = "BB7C8B3FA1A8F6BCD850FAFE77BCC804", hash_generated_field = "BA38CB17745A316A682DD1807824423A")

        private static final String TAG = "SingleLineAllCapsTransform";
    }


    
}

