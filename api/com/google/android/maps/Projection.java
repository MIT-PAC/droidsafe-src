package com.google.android.maps;
     
import android.graphics.Point;

import droidsafe.annotations.*;     

public interface Projection {

    public GeoPoint fromPixels(int x, int y);
    public float metersToEquatorPixels(float meters);
    public Point toPixels(GeoPoint in, Point out);
    
}
