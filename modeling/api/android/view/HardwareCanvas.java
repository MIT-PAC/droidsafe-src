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
 * Copyright (C) 2010 The Android Open Source Project
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
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public abstract class HardwareCanvas extends Canvas {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:42.414 -0400", hash_original_method = "B9875B3DDCC23B593D0FCAB83616982C", hash_generated_method = "B9875B3DDCC23B593D0FCAB83616982C")
    public HardwareCanvas ()
    {
        //Synthesized constructor
    }
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.733 -0500", hash_original_method = "BD882F06CCC6AC9974E10A9883BC45CA", hash_generated_method = "D5EC6C0B703014653E7A2F1A2C6287F1")
    
@Override
    public boolean isHardwareAccelerated() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.735 -0500", hash_original_method = "09BF352B013BE09D7407EC81EDFAD3C9", hash_generated_method = "6B21C1AA6160CD3506F803B9A1DF3D26")
    
@Override
    public void setBitmap(Bitmap bitmap) {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Invoked before any drawing operation is performed in this canvas.
     * 
     * @param dirty The dirty rectangle to update, can be null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.737 -0500", hash_original_method = "6628E6E05E732E5162E850E6ACFA8590", hash_generated_method = "1334D3E461C34BD91F1B89EC09EC96F2")
    
abstract void onPreDraw(Rect dirty);

    /**
     * Invoked after all drawing operation have been performed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.739 -0500", hash_original_method = "5F45C4E9E5B2681580338AD088B6A374", hash_generated_method = "CDD0DA66B0A7BEF0544C1017A3149661")
    
abstract void onPostDraw();
    
    /**
     * Draws the specified display list onto this canvas.
     * 
     * @param displayList The display list to replay.
     * @param width The width of the display list.
     * @param height The height of the display list.
     * @param dirty The dirty region to redraw in the next pass, matters only
     *        if this method returns true, can be null.
     * 
     * @return True if the content of the display list requires another
     *         drawing pass (invalidate()), false otherwise
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.742 -0500", hash_original_method = "1A5F4EDA260F50588638E746220BCFA8", hash_generated_method = "2879EE7343419789CF8029A9E0E612F5")
    
abstract boolean drawDisplayList(DisplayList displayList, int width, int height, Rect dirty);

    /**
     * Outputs the specified display list to the log. This method exists for use by
     * tools to output display lists for selected nodes to the log.
     *
     * @param displayList The display list to be logged.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.744 -0500", hash_original_method = "E6D6819B683A7919CCCD821CAF2B58A2", hash_generated_method = "53008257BE7EC8316E5875698761961C")
    
abstract void outputDisplayList(DisplayList displayList);

    /**
     * Draws the specified layer onto this canvas.
     *
     * @param layer The layer to composite on this canvas
     * @param x The left coordinate of the layer
     * @param y The top coordinate of the layer
     * @param paint The paint used to draw the layer
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.747 -0500", hash_original_method = "083DEA6E913A4D80EEE59AE65B4A7F49", hash_generated_method = "D6E360CC3D94987802CFF82BDAE8D904")
    
abstract void drawHardwareLayer(HardwareLayer layer, float x, float y, Paint paint);

    /**
     * Calls the function specified with the drawGLFunction function pointer. This is
     * functionality used by webkit for calling into their renderer from our display lists.
     * This function may return true if an invalidation is needed after the call.
     *
     * @param drawGLFunction A native function pointer
     * @return true if an invalidate is needed after the call, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:45.749 -0500", hash_original_method = "0FE8E55D6D4280D2FC5B882C82F13271", hash_generated_method = "1A540BE4D20122FACBBACA9BC42021CE")
    
public boolean callDrawGLFunction(int drawGLFunction) {
        // Noop - this is done in the display list recorder subclass
        return false;
    }
    
}

