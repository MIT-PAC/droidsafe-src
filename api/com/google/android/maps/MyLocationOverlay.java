package com.google.android.maps;
     
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.hardware.SensorListener;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import droidsafe.annotations.*;

public class MyLocationOverlay extends Overlay
    implements SensorListener, LocationListener, Overlay.Snappable
{
    
    public MyLocationOverlay(Context context, MapView mapview) {
        super();
        this.mMapView = mapview;
    }
    
    public synchronized boolean enableCompass()
    {
        onSensorChanged(0, new float[]{0.0f});
        onLocationChanged(new Location("GPS"));
        onProviderEnabled("GPS");
        onProviderDisabled("GPS");
        onSnapToItem(0, 0, new Point(), mMapView);
        onTap(new GeoPoint(), mMapView);
        dispatchTap();

        return getTaintBoolean();
    }
    
    public synchronized void disableCompass() {  }
    
    public boolean isCompassEnabled() { return getTaintBoolean(); }
    
    public synchronized boolean enableMyLocation() { 
        onSensorChanged(0, new float[]{0.0f});
        onLocationChanged(new Location("GPS"));
        onProviderEnabled("GPS");
        onProviderDisabled("GPS");
        onSnapToItem(0, 0, new Point(), mMapView);
        onTap(new GeoPoint(), mMapView);
        dispatchTap();
        
        return getTaintBoolean(); 
    }
    
    public synchronized void disableMyLocation() {  }
    
    public synchronized void onSensorChanged(int paramInt, float[] paramArrayOfFloat) {  }
    
    @DSSafe(DSCat.SAFE_LIST)
    public synchronized void onLocationChanged(Location paramLocation) {  }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {  }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void onProviderEnabled(String paramString) { 
        onSensorChanged(0, new float[]{0.0f});
        onLocationChanged(new Location("GPS"));
        onProviderEnabled("GPS");
        onProviderDisabled("GPS");
        onSnapToItem(0, 0, new Point(), mMapView);
        onTap(new GeoPoint(), mMapView);
        dispatchTap();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void onProviderDisabled(String paramString) {  }
    
    public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView) { mMapView = paramMapView; return getTaintBoolean(); }
    
    public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView) {  addTaint(paramGeoPoint.getTaint()); mMapView = paramMapView; return getTaintBoolean(); }
    
    protected boolean dispatchTap() { return getTaintBoolean(); }
    
    public synchronized boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong) {  
        mMapView = paramMapView;
        return getTaintBoolean();
    }
    
    protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong) { 
        addTaint(paramGeoPoint.getTaint());
        mMapView = paramMapView;
    }
    
    protected void drawCompass(Canvas paramCanvas, float paramFloat) {  }
    
    public GeoPoint getMyLocation() { return new GeoPoint(); }
    
    public Location getLastFix() { return new Location("GPS"); }
    
    @DSSource({DSSourceKind.LOCATION})
    public float getOrientation() { return getTaintFloat(); }
    
    public boolean isMyLocationEnabled() { return getTaintBoolean(); }
    
    public synchronized boolean runOnFirstFix(Runnable paramRunnable) { paramRunnable.run(); return getTaintBoolean(); }
    
    public void onAccuracyChanged(int paramInt1, int paramInt2) { 
    }
}
       
