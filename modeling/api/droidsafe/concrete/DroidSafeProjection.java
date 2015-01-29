package droidsafe.concrete;

import android.graphics.Point;
import com.google.android.maps.*;

import droidsafe.annotations.*;

public class DroidSafeProjection implements Projection {
    
    @DSSafe(DSCat.GUI)
    public DroidSafeProjection() {
    }

    @DSSafe(DSCat.GUI)
    public GeoPoint fromPixels(int x, int y) {
        return new GeoPoint();
    }
    
    @DSSafe(DSCat.GUI)
    @DSSource(DSSourceKind.LOCATION)
    public float metersToEquatorPixels(float meters) { 
        addTaint(meters);
        return getTaintFloat();
    }
    
    @DSSafe(DSCat.GUI)
    public Point toPixels(GeoPoint in, Point out) {
        Point point = new Point();
        out.addTaint(in.getTaint());
        
        in.addTaint(out.getTaint());

        point.addTaint(out.getTaint());
        //transfer location taint from geopoint
        point.set(in.getLatitudeE6() + out.x,
                  in.getLongitudeE6() + out.y);

        return point;
    }
    
}
