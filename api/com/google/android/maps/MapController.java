package com.google.android.maps;
     
import droidsafe.annotations.*;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
     
public final class MapController
    implements View.OnKeyListener
{
    
    MapController() {

    }
    
    public void stopPanning()
    {
        
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {addTaint(paramInt); return getTaintBoolean(); }
    
    public void animateTo(GeoPoint paramGeoPoint) {  }
    
    public void animateTo(GeoPoint paramGeoPoint, Message paramMessage) { }
    
    public void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable) { 
        paramRunnable.run();
    }
    
    public void scrollBy(int paramInt1, int paramInt2) { throw new RuntimeException("stub"); }
    
    public void setCenter(GeoPoint paramGeoPoint) { throw new RuntimeException("stub"); }
    
    public void stopAnimation(boolean paramBoolean) { throw new RuntimeException("stub"); }
    
    public int setZoom(int paramInt) { return getTaintInt(); }
    
    public void zoomToSpan(int paramInt1, int paramInt2) { addTaint(paramInt1); addTaint(paramInt2); }
    
    public boolean zoomIn() { return getTaintBoolean();}
    
    public boolean zoomOut() { return getTaintBoolean(); }
    
    public boolean zoomInFixing(int paramInt1, int paramInt2) { 
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    }
    
    public boolean zoomOutFixing(int paramInt1, int paramInt2) {
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    }
}
