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
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.view;

import android.app.ContextImpl;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/**
 * A ContextWrapper that allows you to modify the theme from what is in the 
 * wrapped context. 
 */
public class ContextThemeWrapper extends ContextWrapper {
	private Context mBase;
   
    @DSModeled
    public ContextThemeWrapper() {
        super(new ContextImpl());
    }
    
    public ContextThemeWrapper(Context base, int themeres) {
        super(base);
        addTaint(themeres);
        /*
        mBase = base;
        mThemeResource = themeres;
        */
    }
    
    @Override public void setTheme(int resid) {
    
    }
    
    protected void onApplyThemeResource(android.content.res.Resources.Theme theme,
    		int resid, boolean b) {
    	
    }
    
    /** @hide */
    @Override
    public int getThemeResId() {
        return -1;
    }

    @Override public Resources.Theme getTheme() {
   
        return null;
    }
    
    
    @DSModeled(DSC.SAFE)
    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
    }
    
    @Override 
    @DSModeled(DSC.SAFE)
    public Object getSystemService(String name) {
        return super.getSystemService(name);
    }
}

