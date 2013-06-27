package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

class PagerTitleStripIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.892 -0400", hash_original_method = "074F6C7ED6DAD038000402E905AE4BC7", hash_generated_method = "074F6C7ED6DAD038000402E905AE4BC7")
    public PagerTitleStripIcs ()
    {
        //Synthesized constructor
    }


        public static void setSingleLineAllCaps(TextView text) {
        text.setTransformationMethod(new SingleLineAllCapsTransform(text.getContext()));
    }

    
    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.897 -0400", hash_original_field = "CF3890B8F9E27793E741F9D9569D3C34", hash_generated_field = "1A21143DB168F6FB0629A178DF0F089E")

        private Locale mLocale;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.906 -0400", hash_original_method = "4C2D06E04273338AC4EC5853A2EDD665", hash_generated_method = "4C6AABE92D596FF9D5C5396F62BCD445")
        public  SingleLineAllCapsTransform(Context context) {
            mLocale = context.getResources().getConfiguration().locale;
            // ---------- Original Method ----------
            //mLocale = context.getResources().getConfiguration().locale;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.908 -0400", hash_original_method = "D86D9A1AA103AB45F13A7134C7371BA5", hash_generated_method = "EB8CBC486D1CEA8386B4A69350CFD175")
        @Override
        public CharSequence getTransformation(CharSequence source, View view) {
            CharSequence varB4EAC82CA7396A68D541C85D26508E83_1077345013 = null; //Variable for return #1
            source = super.getTransformation(source, view);
            varB4EAC82CA7396A68D541C85D26508E83_1077345013 = source != null ? source.toString().toUpperCase(mLocale) : null;
            addTaint(source.getTaint());
            addTaint(view.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1077345013.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1077345013;
            // ---------- Original Method ----------
            //source = super.getTransformation(source, view);
            //return source != null ? source.toString().toUpperCase(mLocale) : null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.908 -0400", hash_original_field = "BB7C8B3FA1A8F6BCD850FAFE77BCC804", hash_generated_field = "83C914A2A16204259AEA0676C1D66B1D")

        private static String TAG = "SingleLineAllCapsTransform";
    }


    
}

