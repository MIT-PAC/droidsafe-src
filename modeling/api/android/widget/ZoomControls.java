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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;

import com.android.internal.R;

public class ZoomControls extends LinearLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.774 -0500", hash_original_field = "590BB0711F9F5F376B267E11F07C4EA2", hash_generated_field = "7116DE4A12D2EB2034E69BBBF12212DA")

    private  ZoomButton mZoomIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.776 -0500", hash_original_field = "1C1355247C11A55FE6AE148525E68936", hash_generated_field = "E64AF7300F8D4E214346AF3EA47CF57E")

    private  ZoomButton mZoomOut;
        
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.778 -0500", hash_original_method = "10F3E3D1A11DC20FE44EEC423922BDF4", hash_generated_method = "279325BDB5D027EAB92B07192EE1F979")
    
public ZoomControls(Context context) {
        this(context, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.781 -0500", hash_original_method = "EEE1D0E353F6E8D1719CC2CAB69CDDDF", hash_generated_method = "E7F1E612271E33BA336A0C0059655608")
    
public ZoomControls(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFocusable(false);
        
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.zoom_controls, this, // we are the parent
                true);
        
        mZoomIn = (ZoomButton) findViewById(R.id.zoomIn);
        mZoomOut = (ZoomButton) findViewById(R.id.zoomOut);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.783 -0500", hash_original_method = "BB515265AEE98A63EEEF9DCF76B8616A", hash_generated_method = "FE6FB833513CC80567644BE99FA0F042")
    
public void setOnZoomInClickListener(OnClickListener listener) {
        mZoomIn.setOnClickListener(listener);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.785 -0500", hash_original_method = "35622AF1D6D5327607A99B20A992A9B1", hash_generated_method = "247AF07575176B5E8BB4134323AF5C39")
    
public void setOnZoomOutClickListener(OnClickListener listener) {
        mZoomOut.setOnClickListener(listener);
    }
    
    /*
     * Sets how fast you get zoom events when the user holds down the
     * zoom in/out buttons.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.788 -0500", hash_original_method = "A6640A96361603BAC2F17D8F8F5DC89E", hash_generated_method = "198C61133DF94E746FFAB5EED3434EB1")
    
public void setZoomSpeed(long speed) {
        mZoomIn.setZoomSpeed(speed);
        mZoomOut.setZoomSpeed(speed);
    }
    
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.790 -0500", hash_original_method = "D87B32C51AD302A4F9341AA86337AE33", hash_generated_method = "42CEF1B8356646B0110B20CB45E3D9E7")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {
        
        /* Consume all touch events so they don't get dispatched to the view
         * beneath this view.
         */
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.793 -0500", hash_original_method = "C11451C1AB4E567449CD07B5E594E725", hash_generated_method = "5D542CD6018B333B57C7CF8984F83CD5")
    
public void show() {
        fade(View.VISIBLE, 0.0f, 1.0f);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.795 -0500", hash_original_method = "E5A5304131EA7BA6BF2FB03B8454E0A2", hash_generated_method = "16FA1262CF10C46FD07E860BAAC2C55F")
    
public void hide() {
        fade(View.GONE, 1.0f, 0.0f);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.797 -0500", hash_original_method = "9BED0A47A1FCF93930F77C8CDDC09D0D", hash_generated_method = "5E0237000E83E41CCCE02FCD67078FC1")
    
private void fade(int visibility, float startAlpha, float endAlpha) {
        AlphaAnimation anim = new AlphaAnimation(startAlpha, endAlpha);
        anim.setDuration(500);
        startAnimation(anim);
        setVisibility(visibility);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.799 -0500", hash_original_method = "2126F62859134DF2EBC550B9718A317B", hash_generated_method = "3D5477A5B89E3921BCC086840A1575C3")
    
public void setIsZoomInEnabled(boolean isEnabled) {
        mZoomIn.setEnabled(isEnabled);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.801 -0500", hash_original_method = "45416B0BE009A28B7DBB8DCE0047833B", hash_generated_method = "2E12C64FF756D73EC359C4F86A395936")
    
public void setIsZoomOutEnabled(boolean isEnabled) {
        mZoomOut.setEnabled(isEnabled);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:39.803 -0500", hash_original_method = "627B89961C8BD752C151F14A1A83054C", hash_generated_method = "1DE89AEF970F6AE725F523A10C9602CC")
    
@Override
    public boolean hasFocus() {
        return mZoomIn.hasFocus() || mZoomOut.hasFocus();
    }
    
}

