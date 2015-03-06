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

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
     
public final class MapController
    implements View.OnKeyListener
{
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    MapController() {

    }
    
    @DSSafe(DSCat.GUI)
    public void stopPanning()
    {
        
    }
    
    public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {addTaint(paramInt); return getTaintBoolean(); }
    
    @DSSafe(DSCat.GUI)
    public void animateTo(GeoPoint paramGeoPoint) {  }
    
    @DSSafe(DSCat.GUI)
    public void animateTo(GeoPoint paramGeoPoint, Message paramMessage) { }
    
    @DSSafe(DSCat.GUI)
    public void animateTo(GeoPoint paramGeoPoint, Runnable paramRunnable) { 
        paramRunnable.run();
    }
    
    @DSSafe(DSCat.GUI)
    public void scrollBy(int paramInt1, int paramInt2) { throw new RuntimeException("stub"); }
    
    @DSSafe(DSCat.GUI)
    public void setCenter(GeoPoint paramGeoPoint) { throw new RuntimeException("stub"); }
    
    @DSSafe(DSCat.GUI)
    public void stopAnimation(boolean paramBoolean) { throw new RuntimeException("stub"); }
    
    @DSSafe(DSCat.GUI)
    public int setZoom(int paramInt) { return getTaintInt(); }
    
    @DSSafe(DSCat.GUI)
    public void zoomToSpan(int paramInt1, int paramInt2) { addTaint(paramInt1); addTaint(paramInt2); }
    
    @DSSafe(DSCat.GUI)
    public boolean zoomIn() { return getTaintBoolean();}
    
    @DSSafe(DSCat.GUI)
    public boolean zoomOut() { return getTaintBoolean(); }
    
    @DSSafe(DSCat.GUI)
    public boolean zoomInFixing(int paramInt1, int paramInt2) { 
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    }
    
    @DSSafe(DSCat.GUI)
    public boolean zoomOutFixing(int paramInt1, int paramInt2) {
        addTaint(paramInt1); addTaint(paramInt2);
        return getTaintBoolean();
    }
}
