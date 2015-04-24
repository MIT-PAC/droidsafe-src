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

package com.google.android.maps;

import droidsafe.annotations.*;
     
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
     
public abstract class Overlay
{
    protected static final float SHADOW_X_SKEW = -0.9F;
    protected static final float SHADOW_Y_SCALE = 0.5F;

    protected MapView mMapView;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public Overlay() {
        mMapView = new MapView(null, "");
        this.onTouchEvent(new MotionEvent(), mMapView);
        this.onTrackballEvent(new MotionEvent(), mMapView);
        this.onKeyUp(0, new KeyEvent(), mMapView);
        this.onTap(new GeoPoint(), mMapView);
    }
    
    protected static void drawAt(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
    {
        
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView) { 
        return getTaintBoolean();
    }
    
    public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView) { 
        return getTaintBoolean();
        
    }
    
    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView) {
        return getTaintBoolean();
    }
    
    public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView) { 
        return getTaintBoolean();
    }
    
    public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean) {
        mMapView = paramMapView;
    }
    
    public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong) { 
        mMapView = paramMapView;
        return getTaintBoolean();
    }
    @DSModeled(DSC.SAFE)
    public static abstract interface Snappable
    {
        public abstract @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView);
    }
}
