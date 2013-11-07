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

    @DSModeled(DSC.SAFE)
    public Overlay() {
        mMapView = new MapView(null, "");
        this.onTouchEvent(new MotionEvent(), mMapView);
        this.onTrackballEvent(new MotionEvent(), mMapView);
        this.onKeyUp(0, new KeyEvent(), mMapView);
        this.onTap(new GeoPoint(), mMapView);
    }
    
    @DSModeled(DSC.SAFE)
    protected static void drawAt(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, boolean paramBoolean)
    {
        
    } 

    @DSModeled(DSC.SAFE)
    public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView) { 
        return getTaintBoolean();
    } 

    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent paramMotionEvent, MapView paramMapView) { 
        return getTaintBoolean();
        
    }
    @DSModeled(DSC.SAFE)
    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent, MapView paramMapView) {
        return getTaintBoolean();
    } 
    @DSModeled(DSC.SAFE)
    public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView) { 
        return getTaintBoolean();
    } 
    @DSModeled(DSC.SAFE)
    public void draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean) {
        mMapView = paramMapView;
    }
    @DSModeled(DSC.SAFE)
    public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong) { 
        mMapView = paramMapView;
        return getTaintBoolean();
    }
    @DSModeled(DSC.SAFE)
    public static abstract interface Snappable
    {
        public abstract boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView);
    }
}
