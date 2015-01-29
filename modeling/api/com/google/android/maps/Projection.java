package com.google.android.maps;
     
import android.graphics.Point;

import droidsafe.annotations.*;

public interface Projection {

    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public GeoPoint fromPixels(int x, int y);
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public float metersToEquatorPixels(float meters);
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    public Point toPixels(GeoPoint in, Point out);
    
}
