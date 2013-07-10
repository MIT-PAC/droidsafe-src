package android.support.v4.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

class EdgeEffectCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.324 -0400", hash_original_method = "2ED7C9E04D60E9925816E3B452B1FB7F", hash_generated_method = "2ED7C9E04D60E9925816E3B452B1FB7F")
    public EdgeEffectCompatIcs ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static Object newEdgeEffect(Context context) {
        return new EdgeEffect(context);
    }

    
        @DSModeled(DSC.SAFE)
    public static void setSize(Object edgeEffect, int width, int height) {
        ((EdgeEffect) edgeEffect).setSize(width, height);
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean isFinished(Object edgeEffect) {
        return ((EdgeEffect) edgeEffect).isFinished();
    }

    
        @DSModeled(DSC.SAFE)
    public static void finish(Object edgeEffect) {
        ((EdgeEffect) edgeEffect).finish();
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean onPull(Object edgeEffect, float deltaDistance) {
        
        ((EdgeEffect) edgeEffect).onPull(deltaDistance);
        return true;
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean onRelease(Object edgeEffect) {
        
        EdgeEffect eff = (EdgeEffect) edgeEffect;
        eff.onRelease();
        return eff.isFinished();
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean onAbsorb(Object edgeEffect, int velocity) {
        
        ((EdgeEffect) edgeEffect).onAbsorb(velocity);
        return true;
    }

    
        @DSModeled(DSC.SAFE)
    public static boolean draw(Object edgeEffect, Canvas canvas) {
        return ((EdgeEffect) edgeEffect).draw(canvas);
    }

    
}

