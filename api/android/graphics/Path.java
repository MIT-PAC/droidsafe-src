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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/**
 * The Path class encapsulates compound (multiple contour) geometric paths
 * consisting of straight line segments, quadratic curves, and cubic curves.
 * It can be drawn with canvas.drawPath(path, paint), either filled or stroked
 * (based on the paint's Style), or it can be used for clipping or to draw
 * text on a path.
 */
public class Path {


    @DSModeled(DSC.SAFE)
    public Path() {}

    @DSModeled(DSC.SAFE)
    public Path(Path src) {
        // src.mNativePath is passed through init2() and the result is stored
        // within this object's mNativePath.  init2 is a native call,
        // so I conseratively assume this object's mNativePath is tainted 
        // with src.mNativePath 
        addTaint(src.getTaint());
    }
   
    @DSModeled(DSC.SAFE) 
    public void arcTo(RectF oval, float startAngle, float sweepAngle) {
        addTaint(oval.getTaint());
        addTaint(startAngle.getTaint());
        addTaint(sweepAngle.getTaint());
    }

    @DSModeled()
    final int ni() {
        return getTaintInt(); 
    }

    @DSModeled(DSC.SAFE)
    protected void finalize() {}
}

