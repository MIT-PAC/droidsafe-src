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
    
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        
    }
    
    public MapView(Context paramContext, String paramString)
    {
        super(paramContext);
    }
    
    public MapView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }
    
    public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }
    
    public void displayZoomControls(boolean paramBoolean) { addTaint(paramBoolean);}
    
    public boolean canCoverCenter() { return getTaintBoolean();}
    
    public void preLoad() {  }
    
    public int getZoomLevel() { return getTaintInt(); }
    
    public void setSatellite(boolean paramBoolean) { addTaint(paramBoolean); }
    
    public boolean isSatellite() { return getTaintBoolean();}
    
    public void setTraffic(boolean paramBoolean) { addTaint(paramBoolean); }
    
    public boolean isTraffic() { return getTaintBoolean(); }

    @Deprecated
    
    public void setStreetView(boolean paramBoolean) { addTaint(paramBoolean); }
    
    public boolean isStreetView() { return getTaintBoolean(); }
    
    public GeoPoint getMapCenter() { return new GeoPoint(); }
    
    public MapController getController() { 
        return new MapController();
    }
    
    public final List<Overlay> getOverlays() {
        return overlays;
    }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public int getLatitudeSpan() { return getTaintInt(); }
    
    @DSSource({DSSourceKind.LOCATION_INFORMATION})
    public int getLongitudeSpan() { return getTaintInt();}
    
    public void setReticleDrawMode(ReticleDrawMode paramReticleDrawMode) {  }
    
    public int getMaxZoomLevel() { return getTaintInt(); }
    
    public View getZoomControls() { return this; }
    
    public ZoomButtonsController getZoomButtonsController() { 
        return new ZoomButtonsController(this);
    }
    
    public void setBuiltInZoomControls(boolean paramBoolean) { addTaint(paramBoolean); }
    
    public Projection getProjection() { return new DroidSafeProjection(); }

    public static enum ReticleDrawMode
    {
    }
}
       
