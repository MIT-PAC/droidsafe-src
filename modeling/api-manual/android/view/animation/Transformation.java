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


package android.view.animation;
import java.io.PrintWriter;

import android.graphics.Matrix;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
public class Transformation {
    public static int TYPE_IDENTITY = 0x0;
    public static int TYPE_ALPHA = 0x1;
    public static int TYPE_MATRIX = 0x2;
    public static int TYPE_BOTH = TYPE_ALPHA | TYPE_MATRIX;
    protected Matrix mMatrix;
    protected float mAlpha;
    protected int mTransformationType;
    
    @DSModeled(DSC.SAFE)
    public Transformation() {
        mMatrix = new Matrix();
    }
    
    public void clear() {
        mAlpha = 1.0f;
        mTransformationType = TYPE_BOTH;
        mMatrix.reset();
        addTaint(mAlpha);
        addTaint(mTransformationType);
    }
    
    public int getTransformationType() {
        return mTransformationType;
    }
    
    public void setTransformationType(int transformationType) {
        mTransformationType = transformationType;
    }
    public void set(Transformation t) {
        mAlpha = t.getAlpha();
        mMatrix.set(t.getMatrix());
        mTransformationType = t.getTransformationType();
    }
    public void compose(Transformation t) {
        mAlpha *= t.getAlpha();
        mMatrix.preConcat(t.getMatrix());
    }
    public Matrix getMatrix() {
        return mMatrix;
    }
    public void setAlpha(float alpha) {
        mAlpha = alpha;
    }
    public float getAlpha() {
        return mAlpha;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Transformation");
        toShortString(sb);
        return sb.toString();
    }
    public String toShortString() {
        StringBuilder sb = new StringBuilder(64);
        toShortString(sb);
        return sb.toString();
    }
    public void toShortString(StringBuilder sb) {
        sb.append("{alpha="); sb.append(mAlpha);
        sb.append(" matrix="); mMatrix.toShortString(sb);
        sb.append('}');
    }
    public void printShortString(PrintWriter pw) {
        pw.print("{alpha="); pw.print(mAlpha);
        pw.print(" matrix=");
        mMatrix.printShortString(pw);
        pw.print('}');
    }
}
