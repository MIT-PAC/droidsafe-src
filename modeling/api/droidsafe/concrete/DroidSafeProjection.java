/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
