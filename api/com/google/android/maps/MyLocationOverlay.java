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
    @DSModeled(DSC.SAFE)
    public MyLocationOverlay(Context context, MapView mapview) {
        super();
        this.mMapView = mapview;
    }
    @DSModeled(DSC.SAFE)
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
    @DSModeled(DSC.SAFE)
    public synchronized void disableCompass() {  } 
    @DSModeled(DSC.SAFE)
    public boolean isCompassEnabled() { return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
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
    @DSModeled(DSC.SAFE)
    public synchronized void disableMyLocation() {  } 
    @DSModeled(DSC.SAFE)
    public synchronized void onSensorChanged(int paramInt, float[] paramArrayOfFloat) {  } 
    @DSModeled(DSC.SAFE)
    public synchronized void onLocationChanged(Location paramLocation) {  } 
    @DSModeled(DSC.SAFE)
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {  } 
    @DSModeled(DSC.SAFE)
    public void onProviderEnabled(String paramString) { 
        onSensorChanged(0, new float[]{0.0f});
        onLocationChanged(new Location("GPS"));
        onProviderEnabled("GPS");
        onProviderDisabled("GPS");
        onSnapToItem(0, 0, new Point(), mMapView);
        onTap(new GeoPoint(), mMapView);
        dispatchTap();
    } 

    @DSModeled(DSC.SAFE)
    public void onProviderDisabled(String paramString) {  } 
    @DSModeled(DSC.SAFE)
    public boolean onSnapToItem(int paramInt1, int paramInt2, Point paramPoint, MapView paramMapView) { mMapView = paramMapView; return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView) {  addTaint(paramGeoPoint.getTaint()); mMapView = paramMapView; return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    protected boolean dispatchTap() { return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public synchronized boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong) {  
        mMapView = paramMapView;
        return getTaintBoolean();
    } 
    @DSModeled(DSC.SAFE)
    protected void drawMyLocation(Canvas paramCanvas, MapView paramMapView, Location paramLocation, GeoPoint paramGeoPoint, long paramLong) { 
        addTaint(paramGeoPoint.getTaint());
        mMapView = paramMapView;
    } 
    @DSModeled(DSC.SAFE)
    protected void drawCompass(Canvas paramCanvas, float paramFloat) {  } 
    @DSModeled(DSC.SAFE)
    public GeoPoint getMyLocation() { return new GeoPoint(); } 
    @DSModeled(DSC.SAFE)
    public Location getLastFix() { return new Location("GPS"); } 
    @DSModeled(DSC.SAFE)
    public float getOrientation() { return getTaintFloat(); } 
    @DSModeled(DSC.SAFE)
    public boolean isMyLocationEnabled() { return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public synchronized boolean runOnFirstFix(Runnable paramRunnable) { paramRunnable.run(); return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public void onAccuracyChanged(int paramInt1, int paramInt2) { 
    }
}
       
