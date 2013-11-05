package com.google.android.maps;
     
import droidsafe.annotations.*;     

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
     
public final class MapController
    implements View.OnKeyListener
{

    @DSModeled(DSC.SAFE)
    MapController() {

    }

    @DSModeled(DSC.SAFE)
    public void stopPanning()
    {
        
    } 
    @DSModeled(DSC.SAFE)
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {addTaint(paramInt); return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public void animateTo(GeoPoint paramGeoPoint) {  } 
    @DSModeled(DSC.SAFE)
    public void animateTo(GeoPoint paramGeoPoint, Message paramMessage) { } 
    @DSModeled(DSC.SAFE)
    public void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable) { 
        paramRunnable.run();
    } 
    @DSModeled(DSC.SAFE)
    public void scrollBy(int paramInt1, int paramInt2) { throw new RuntimeException("stub"); } 
    @DSModeled(DSC.SAFE)
    public void setCenter(GeoPoint paramGeoPoint) { throw new RuntimeException("stub"); } 
    @DSModeled(DSC.SAFE)
    public void stopAnimation(boolean paramBoolean) { throw new RuntimeException("stub"); } 
    @DSModeled(DSC.SAFE)
    public int setZoom(int paramInt) { return getTaintInt(); } 
    @DSModeled(DSC.SAFE)
    public void zoomToSpan(int paramInt1, int paramInt2) { addTaint(paramInt1); addTaint(paramInt2); } 
    @DSModeled(DSC.SAFE)
    public boolean zoomIn() { return getTaintBoolean();} 
    @DSModeled(DSC.SAFE)
    public boolean zoomOut() { return getTaintBoolean(); } 
    @DSModeled(DSC.SAFE)
    public boolean zoomInFixing(int paramInt1, int paramInt2) { 
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    } 
    @DSModeled(DSC.SAFE)
    public boolean zoomOutFixing(int paramInt1, int paramInt2) {
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    }
}
