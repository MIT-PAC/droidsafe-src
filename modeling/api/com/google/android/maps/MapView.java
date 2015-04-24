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

    @DSSafe(DSCat.GUI)
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        
    }
    
    @DSSafe(DSCat.GUI)
    public MapView(Context paramContext, String paramString)
    {
        super(paramContext);
    }
    
    @DSSafe(DSCat.GUI)
    public MapView(Context paramContext, AttributeSet paramAttributeSet)
    {
        super(paramContext, paramAttributeSet);
    }
    
    @DSSafe(DSCat.GUI)
    public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
        super(paramContext, paramAttributeSet, paramInt);
    }
    
    @DSSafe(DSCat.GUI)
    public void displayZoomControls(boolean paramBoolean) { addTaint(paramBoolean);}
    
    @DSSafe(DSCat.GUI)
    public boolean canCoverCenter() { return getTaintBoolean();}
    
    @DSSafe(DSCat.GUI)
    public void preLoad() {  }
    
    @DSSafe(DSCat.GUI)
    public int getZoomLevel() { return getTaintInt(); }
    
    @DSSafe(DSCat.GUI)
    public void setSatellite(boolean paramBoolean) { addTaint(paramBoolean); }
    
    @DSSafe(DSCat.GUI)
    public boolean isSatellite() { return getTaintBoolean();}
    
    @DSSafe(DSCat.GUI)
    public void setTraffic(boolean paramBoolean) { addTaint(paramBoolean); }
    
    @DSSafe(DSCat.GUI)
    public boolean isTraffic() { return getTaintBoolean(); }

    @Deprecated
    @DSSafe(DSCat.GUI)
    public void setStreetView(boolean paramBoolean) { addTaint(paramBoolean); }

    @DSSafe(DSCat.GUI)
    public boolean isStreetView() { return getTaintBoolean(); }

    @DSSafe(DSCat.GUI)
    public GeoPoint getMapCenter() { return new GeoPoint(); }


    @DSSafe(DSCat.GUI)
    public MapController getController() { 
        return new MapController();
    }
    
    @DSSafe(DSCat.GUI)
    public final List<Overlay> getOverlays() {
        return overlays;
    }

    @DSSafe(DSCat.SOURCE)    
    @DSSource({DSSourceKind.LOCATION})
    public int getLatitudeSpan() { return getTaintInt(); }
    
    @DSSafe(DSCat.SOURCE)    
    @DSSource({DSSourceKind.LOCATION})
    public int getLongitudeSpan() { return getTaintInt();}
    
    @DSSafe(DSCat.GUI)
    public void setReticleDrawMode(ReticleDrawMode paramReticleDrawMode) {  }
    
    @DSSafe(DSCat.GUI)
    public int getMaxZoomLevel() { return getTaintInt(); }
    
    @DSSafe(DSCat.GUI)
    public View getZoomControls() { return this; }
    
    @DSSafe(DSCat.GUI)
    public ZoomButtonsController getZoomButtonsController() { 
        return new ZoomButtonsController(this);
    }
    
    @DSSafe(DSCat.GUI)
    public void setBuiltInZoomControls(boolean paramBoolean) { addTaint(paramBoolean); }
    
    @DSSafe(DSCat.GUI)
    public Projection getProjection() { return new DroidSafeProjection(); }

    public static enum ReticleDrawMode
    {
    }
}
       
