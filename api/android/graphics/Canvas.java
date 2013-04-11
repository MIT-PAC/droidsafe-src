/*
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

package android.graphics;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

import javax.microedition.khronos.opengles.GL;

/**
 * The Canvas class holds the "draw" calls. To draw something, you need
 * 4 basic components: A Bitmap to hold the pixels, a Canvas to host
 * the draw calls (writing into the bitmap), a drawing primitive (e.g. Rect,
 * Path, text, Bitmap), and a paint (to describe the colors and styles for the
 * drawing).
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use Canvas, read the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html">
 * Canvas and Drawables</a> developer guide.</p></div>
 */
public class Canvas {
	final int mNativeCanvas = 0;
	// This field is used to finalize the native Canvas properly
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled
    public Canvas() {
    	//Do Nothing
    }
    
    /**
     * Draw a line segment with the specified start and stop x,y coordinates,
     * using the specified paint. NOTE: since a line is always "framed", the
     * Style is ignored in the paint.
     *
     * @param startX The x-coordinate of the start point of the line
     * @param startY The y-coordinate of the start point of the line
     * @param paint  The paint used to draw the line
     */
    @DSModeled(value = DSC.SAFE)
    public void drawLine(float startX, float startY, float stopX, float stopY,
                         Paint paint) {
    	dsTaint.addTaints(startX, startY, stopX, stopY, paint);
    	/*
        native_drawLine(mNativeCanvas, startX, startY, stopX, stopY,
                        paint.mNativePaint);
        */
    }
	
	@DSModeled(DSC.SAFE)
	public void drawColor(int i) {
		dsTaint.addTaints(i);
	}
	
	@DSModeled(DSC.SAFE)
	public int save(int i) {
		dsTaint.addTaint(i);
		return dsTaint.getTaintInt();
	}
}
