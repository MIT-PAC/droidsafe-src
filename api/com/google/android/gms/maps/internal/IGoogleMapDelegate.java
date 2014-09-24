package com.google.android.gms.maps.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Location;

public abstract interface IGoogleMapDelegate extends android.os.IInterface
{
	public abstract void setPadding(int  i0, int  i1, int  i2, int  i3) throws android.os.RemoteException;

    public abstract boolean isBuildingsEnabled() throws android.os.RemoteException;

    public abstract void setBuildingsEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setWatermarkEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void stopAnimation() throws android.os.RemoteException;

    public abstract float getMaxZoomLevel() throws android.os.RemoteException;

    public abstract float getMinZoomLevel() throws android.os.RemoteException;


    

    public abstract void clear() throws android.os.RemoteException;

    public abstract int getMapType() throws android.os.RemoteException;

    public abstract void setMapType(int  i0) throws android.os.RemoteException;

    public abstract boolean isTrafficEnabled() throws android.os.RemoteException;

    public abstract void setTrafficEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract boolean isIndoorEnabled() throws android.os.RemoteException;
    public abstract boolean setIndoorEnabled(boolean  z0) throws android.os.RemoteException;
    public abstract boolean isMyLocationEnabled() throws android.os.RemoteException;
    public abstract void setMyLocationEnabled(boolean  z0) throws android.os.RemoteException;
    public abstract android.location.Location getMyLocation() throws android.os.RemoteException;

    /*
    public abstract void setLocationSource(com.google.android.gms.maps.internal.ILocationSourceDelegate  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.internal.IUiSettingsDelegate getUiSettings() throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.internal.IProjectionDelegate getProjection() throws android.os.RemoteException;

    public abstract void setOnCameraChangeListener(com.google.android.gms.maps.internal.e  r0) throws android.os.RemoteException;

    public abstract void setOnMapClickListener(com.google.android.gms.maps.internal.i  r0) throws android.os.RemoteException;

    public abstract void setOnMapLongClickListener(com.google.android.gms.maps.internal.k  r0) throws android.os.RemoteException;

    public abstract void setOnMarkerClickListener(com.google.android.gms.maps.internal.l  r0) throws android.os.RemoteException;

    public abstract void setOnMarkerDragListener(com.google.android.gms.maps.internal.m  r0) throws android.os.RemoteException;

    public abstract void setOnInfoWindowClickListener(com.google.android.gms.maps.internal.g  r0) throws android.os.RemoteException;

    public abstract void setInfoWindowAdapter(com.google.android.gms.maps.internal.d  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d getTestingHelper() throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.b addCircle(com.google.android.gms.maps.model.CircleOptions  r0) throws android.os.RemoteException;

    public abstract void setOnMyLocationChangeListener(com.google.android.gms.maps.internal.o  r0) throws android.os.RemoteException;

    public abstract void setOnMyLocationButtonClickListener(com.google.android.gms.maps.internal.n  r0) throws android.os.RemoteException;

    public abstract void snapshot(com.google.android.gms.maps.internal.s  r0, com.google.android.gms.dynamic.d  r1) throws android.os.RemoteException;

    
    public abstract void setOnIndoorStateChangeListener(com.google.android.gms.maps.internal.f  r0) throws android.os.RemoteException;
    public abstract com.google.android.gms.maps.model.CameraPosition getCameraPosition() throws android.os.RemoteException;
    public abstract void setOnMapLoadedCallback(com.google.android.gms.maps.internal.j  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.d getFocusedBuilding() throws android.os.RemoteException;
 public abstract void moveCamera(com.google.android.gms.dynamic.d  r0) throws android.os.RemoteException;

    public abstract void animateCamera(com.google.android.gms.dynamic.d  r0) throws android.os.RemoteException;

    public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.d  r0, com.google.android.gms.maps.internal.b  r1) throws android.os.RemoteException;

    public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d  r0, int  i1, com.google.android.gms.maps.internal.b  r2) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.IPolylineDelegate addPolyline(com.google.android.gms.maps.model.PolylineOptions  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.g addPolygon(com.google.android.gms.maps.model.PolygonOptions  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.f addMarker(com.google.android.gms.maps.model.MarkerOptions  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.c addGroundOverlay(com.google.android.gms.maps.model.GroundOverlayOptions  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.maps.model.internal.h addTileOverlay(com.google.android.gms.maps.model.TileOverlayOptions  r0) throws android.os.RemoteException; 
    
    */
}
