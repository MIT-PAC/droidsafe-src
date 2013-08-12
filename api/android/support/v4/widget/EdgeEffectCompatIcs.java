package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;


class EdgeEffectCompatIcs {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.027 -0400", hash_original_method = "2ED7C9E04D60E9925816E3B452B1FB7F", hash_generated_method = "2ED7C9E04D60E9925816E3B452B1FB7F")
    public EdgeEffectCompatIcs ()
    {
        //Synthesized constructor
    }


    public static Object newEdgeEffect(Context context) {
        return new EdgeEffect(context);
    }

    
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
        //DSFIXME:  CODE0009: Possible callback target function detected
        ((EdgeEffect) edgeEffect).onPull(deltaDistance);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean onRelease(Object edgeEffect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        EdgeEffect eff = (EdgeEffect) edgeEffect;
        eff.onRelease();
        return eff.isFinished();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean onAbsorb(Object edgeEffect, int velocity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ((EdgeEffect) edgeEffect).onAbsorb(velocity);
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean draw(Object edgeEffect, Canvas canvas) {
        return ((EdgeEffect) edgeEffect).draw(canvas);
    }

    
}

