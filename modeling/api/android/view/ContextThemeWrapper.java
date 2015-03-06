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

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.ContextImpl;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;

public class ContextThemeWrapper extends ContextWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.279 -0500", hash_original_field = "45A1FAFEC6ED7EF70B481175C79188A0", hash_generated_field = "D02AE2F3F4DE111CB9F997E29A53A060")

    private Context mBase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.281 -0500", hash_original_field = "161AF02869E770259B20B21155478DDE", hash_generated_field = "711AE5DF944659E06F58697BBCB3BF0C")

    private int mThemeResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.284 -0500", hash_original_field = "FE80D7E6E1A3E40CD8C770E45A00F5D5", hash_generated_field = "816C159D6BCE886092ECEFD2959C8CB8")

    private Resources.Theme mTheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.286 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public ContextThemeWrapper() {
        super(new ContextImpl());
    }
    
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    public ContextThemeWrapper(Context base, int themeres) {        
        super(base);        
        mBase = base;
        mThemeResource = themeres;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.295 -0500", hash_original_method = "78AA434171DBBE0A89D0F8DC1618D34C", hash_generated_method = "A3E53F65C4B9CCA66AC69BAB2FC338EC")
    
@Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        mBase = newBase;
    }
    
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @Override public void setTheme(int resid) {
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public int getThemeResId() {
        return -1;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @Override public Resources.Theme getTheme() {
        if (mTheme != null) {
            return mTheme;
        }

        mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                getApplicationInfo().targetSdkVersion);
        initializeTheme();

        return mTheme;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @Override
    
    public Object getSystemService(String name) {
        return super.getSystemService(name);
    }
    
    /**
     * Called by {@link #setTheme} and {@link #getTheme} to apply a theme
     * resource to the current Theme object.  Can override to change the
     * default (simple) behavior.  This method will not be called in multiple
     * threads simultaneously.
     *
     * @param theme The Theme object being modified.
     * @param resid The theme style resource being applied to <var>theme</var>.
     * @param first Set to true if this is the first time a style is being
     *              applied to <var>theme</var>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.308 -0500", hash_original_method = "8FCBAFBE19793DC1F6F481E8EF635F38", hash_generated_method = "4ADD98AE789941368E56BFC983506800")
    
protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        theme.applyStyle(resid, true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:59.310 -0500", hash_original_method = "274E46830CAE6261C7392F8B8EF11DA4", hash_generated_method = "0D45EC997A7E9836F3D441BCF2050F00")
    
private void initializeTheme() {
        final boolean first = mTheme == null;
        if (first) {
            mTheme = getResources().newTheme();
            Resources.Theme theme = mBase.getTheme();
            if (theme != null) {
                mTheme.setTo(theme);
            }
        }
        onApplyThemeResource(mTheme, mThemeResource, first);
    }
    
}

