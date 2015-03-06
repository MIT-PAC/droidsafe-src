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
 * Copyright (C) 2008-2009 The Android Open Source Project
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


package android.gesture;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.graphics.Matrix;
import android.graphics.Path;

/**
 * An oriented bounding box
 */
public class OrientedBoundingBox {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.922 -0500", hash_original_field = "448DCAFA3C287E22893C5252221624D1", hash_generated_field = "024B4ECC4DF1DAEC8F28B2D237DB029E")

    public  float squareness;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.926 -0500", hash_original_field = "D23D9A67F8299D5DAAA6B25918BF7C7B", hash_generated_field = "4021A82EA4D5DCEEFB1A814668F53A5E")


    public  float width;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.930 -0500", hash_original_field = "109A17233B9FCB1F743345BD21930852", hash_generated_field = "9F669264CA550A21AA8D110F732C6233")

    public  float height;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.934 -0500", hash_original_field = "561CD1342085838FE8F7DB10295A4BFB", hash_generated_field = "054A1E23DAAFDEC28AE3DA031EECF136")


    public  float orientation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.939 -0500", hash_original_field = "C192575851F18C6031821BD28768F10A", hash_generated_field = "C9D26B39425D1A6E7C9061306DC253EF")
 

    public  float centerX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.943 -0500", hash_original_field = "C45247A79212132AB16F3C4E63FA9778", hash_generated_field = "299747302444EDD63AC04065BCEA3527")

    public  float centerY;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.948 -0500", hash_original_method = "2A87915C39BF152B3047983009AE7D32", hash_generated_method = "2A87915C39BF152B3047983009AE7D32")
    
OrientedBoundingBox(float angle, float cx, float cy, float w, float h) {
        orientation = angle;
        width = w;
        height = h;
        centerX = cx;
        centerY = cy;
        float ratio = w / h;
        if (ratio > 1) {
            squareness = 1 / ratio;
        } else {
            squareness = ratio;
        }
    }

    /**
     * Currently used for debugging purpose only.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 13:04:41.954 -0500", hash_original_method = "F31F235B9BB042EFEA7068DFA90BA302", hash_generated_method = "9B6ED1818CC1E09851A53170CD8008B7")
    
public Path toPath() {
        Path path = new Path();
        float[] point = new float[2];
        point[0] = -width / 2;
        point[1] = height / 2;
        Matrix matrix = new Matrix();
        matrix.setRotate(orientation);
        matrix.postTranslate(centerX, centerY);
        matrix.mapPoints(point);
        path.moveTo(point[0], point[1]);

        point[0] = -width / 2;
        point[1] = -height / 2;
        matrix.mapPoints(point);
        path.lineTo(point[0], point[1]);

        point[0] = width / 2;
        point[1] = -height / 2;
        matrix.mapPoints(point);
        path.lineTo(point[0], point[1]);

        point[0] = width / 2;
        point[1] = height / 2;
        matrix.mapPoints(point);
        path.lineTo(point[0], point[1]);

        path.close();

        return path;
    }
}
