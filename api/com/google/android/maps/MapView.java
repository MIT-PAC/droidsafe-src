package com.google.android.maps;
     
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ZoomButtonsController;
import java.util.List;
import java.util.LinkedList;
     
import droidsafe.annotations.*;     

import droidsafe.concrete.*;


public class MapView extends ViewGroup
{
    List<Overlay> overlays = new LinkedList<Overlay>();
    
    @DSModeled(DSC.SAFE)
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        
    }


    @DSModeled(DSC.SAFE)
    public MapView(Context paramContext, String paramString)
    {
        super(paramContext);
    }
     
    @DSModeled(DSC.SAFE)
    public MapView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }
     
    @DSModeled(DSC.SAFE)
    public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }

    @DSModeled(DSC.SAFE)
    public void displayZoomControls(boolean paramBoolean) { addTaint(paramBoolean);} 

    @DSModeled(DSC.SAFE)
    public boolean canCoverCenter() { return getTaintBoolean();}

    @DSModeled(DSC.SAFE)
    public void preLoad() {  } 

    @DSModeled(DSC.SAFE)
    public int getZoomLevel() { return getTaintInt(); } 

    @DSModeled(DSC.SAFE)
    public void setSatellite(boolean paramBoolean) { addTaint(paramBoolean); } 

    @DSModeled(DSC.SAFE)
    public boolean isSatellite() { return getTaintBoolean();} 

    @DSModeled(DSC.SAFE)
    public void setTraffic(boolean paramBoolean) { addTaint(paramBoolean); } 

    @DSModeled(DSC.SAFE)
    public boolean isTraffic() { return getTaintBoolean(); } 

    @Deprecated
    @DSModeled(DSC.SAFE)
    public void setStreetView(boolean paramBoolean) { addTaint(paramBoolean); } 

    @DSModeled(DSC.SAFE)
    public boolean isStreetView() { return getTaintBoolean(); } 

    @DSModeled(DSC.SAFE)
    public GeoPoint getMapCenter() { return new GeoPoint(); } 
    @DSModeled(DSC.SAFE)
    public MapController getController() { 
        return new MapController();
    } 
    @DSModeled(DSC.SAFE)
    public final List<Overlay> getOverlays() {
        return overlays;
    } 
    @DSModeled(DSC.SAFE)
    public int getLatitudeSpan() { return getTaintInt(); } 
    @DSModeled(DSC.SAFE)
    public int getLongitudeSpan() { return getTaintInt();} 
    @DSModeled(DSC.SAFE)
    public void setReticleDrawMode(ReticleDrawMode paramReticleDrawMode) {  } 
    @DSModeled(DSC.SAFE)
    public int getMaxZoomLevel() { return getTaintInt(); } 
    @DSModeled(DSC.SAFE)
    public View getZoomControls() { return this; } 
    @DSModeled(DSC.SAFE)
    public ZoomButtonsController getZoomButtonsController() { 
        return new ZoomButtonsController(this);
    } 
    @DSModeled(DSC.SAFE)
    public void setBuiltInZoomControls(boolean paramBoolean) { addTaint(paramBoolean); } 
    @DSModeled(DSC.SAFE)
    public Projection getProjection() { return new DroidSafeProjection(); } 

    public static enum ReticleDrawMode
    {
    }
}
       
