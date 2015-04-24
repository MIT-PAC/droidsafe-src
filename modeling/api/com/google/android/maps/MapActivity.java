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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
     
public abstract class MapActivity extends Activity
{
    @DSVerified
    @DSSafe(DSCat.GUI)
    public MapActivity() {
        
    }
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
    }
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public abstract boolean isRouteDisplayed();
   
    @DSVerified
    @DSSafe(DSCat.GUI)
    public boolean isLocationDisplayed() { 
        return true;
    }

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public int onGetMapDataSource() { 
        return 0;
    }
    
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override
    public void droidsafeSubActivityCallbackHook() {
        super.droidsafeSubActivityCallbackHook();
        onGetMapDataSource();
    }
}
