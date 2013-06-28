package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompatHC {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.796 -0400", hash_original_method = "BF0DFCE0766A40E3A6C3B46FD195E8FC", hash_generated_method = "BF0DFCE0766A40E3A6C3B46FD195E8FC")
    public ViewCompatHC ()
    {
        //Synthesized constructor
    }


        static long getFrameTime() {
        return ValueAnimator.getFrameDelay();
    }

    
        public static void setLayerType(View view, int layerType, Paint paint) {
        view.setLayerType(layerType, paint);
    }

    
        public static int getLayerType(View view) {
        return view.getLayerType();
    }

    
}

