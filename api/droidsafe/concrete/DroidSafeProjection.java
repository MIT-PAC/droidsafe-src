package droidsafe.concrete;

import android.graphics.Point;
import com.google.android.maps.*;

import droidsafe.annotations.*;     

public class DroidSafeProjection implements Projection {

    @DSModeled(DSC.SAFE)
    public DroidSafeProjection() {
    }

    @DSModeled(DSC.SAFE)
    public GeoPoint fromPixels(int x, int y) {
        return new GeoPoint();
    }

    @DSModeled(DSC.SAFE)
    public float metersToEquatorPixels(float meters) { 
        addTaint(meters);
        return getTaintFloat();
    }

    @DSModeled(DSC.SAFE)
    public Point toPixels(GeoPoint in, Point out) {
        Point point = new Point();
        out.addTaint(in.getTaint());
        
        in.addTaint(out.getTaint());

        point.addTaint(out.getTaint());

        return point;
    }
    
}
