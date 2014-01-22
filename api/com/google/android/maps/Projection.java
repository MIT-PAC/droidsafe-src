package com.google.android.maps;
     
import android.graphics.Point;

import droidsafe.annotations.*;

public interface Projection {

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public GeoPoint fromPixels(int x, int y);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public float metersToEquatorPixels(float meters);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Point toPixels(GeoPoint in, Point out);
    
}
