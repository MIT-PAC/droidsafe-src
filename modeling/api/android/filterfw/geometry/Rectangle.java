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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.filterfw.geometry;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.geometry.Point;
import android.filterfw.geometry.Quad;

/**
 * @hide
 */
public class Rectangle extends Quad {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.106 -0400", hash_original_method = "E146EE4919993902437539A4C42E40C9", hash_generated_method = "FB8FA1A71CC0B1C4C73AA200E497C1A4")
    
public static Rectangle fromRotatedRect(Point center, Point size, float rotation) {
        Point p0 = new Point(center.x - size.x/2f, center.y - size.y/2f);
        Point p1 = new Point(center.x + size.x/2f, center.y - size.y/2f);
        Point p2 = new Point(center.x - size.x/2f, center.y + size.y/2f);
        Point p3 = new Point(center.x + size.x/2f, center.y + size.y/2f);
        return new Rectangle(p0.rotatedAround(center, rotation),
                             p1.rotatedAround(center, rotation),
                             p2.rotatedAround(center, rotation),
                             p3.rotatedAround(center, rotation));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.110 -0400", hash_original_method = "95EBD6E16F0D1AD2BCB519F3DCFB8163", hash_generated_method = "B2907BA8C0852E1EA33A874ADA6B7D1F")
    
public static Rectangle fromCenterVerticalAxis(Point center, Point vAxis, Point size) {
        Point dy = vAxis.scaledTo(size.y / 2.0f);
        Point dx = vAxis.rotated90(1).scaledTo(size.x / 2.0f);
        return new Rectangle(center.minus(dx).minus(dy),
                             center.plus(dx).minus(dy),
                             center.minus(dx).plus(dy),
                             center.plus(dx).plus(dy));
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.099 -0400", hash_original_method = "7D3811CB1678D30D8D27D4A02039CDAE", hash_generated_method = "5AB663F6126041E31DF8F10097075BA9")
    
public Rectangle() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.101 -0400", hash_original_method = "17E391508E2366144F00E38A9D89046B", hash_generated_method = "73BC6F384F00E77476F02A8009B80321")
    
public Rectangle(float x, float y, float width, float height) {
        super(new Point(x, y),
              new Point(x + width, y),
              new Point(x, y + height),
              new Point(x + width, y + height));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.103 -0400", hash_original_method = "4E5D2E5D9C503B6028A2B16EE67CB603", hash_generated_method = "AE763DB89F2A80850B60D74A8AF7218C")
    
public Rectangle(Point origin, Point size) {
        super(origin,
              origin.plus(size.x, 0.0f),
              origin.plus(0.0f, size.y),
              origin.plus(size.x, size.y));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.108 -0400", hash_original_method = "745C9F573860A5560480BCC132021800", hash_generated_method = "46E35B1F23FF03F249DC610DEB5897DD")
    
private Rectangle(Point p0, Point p1, Point p2, Point p3) {
        super(p0, p1, p2, p3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.111 -0400", hash_original_method = "658363618CC6EACB0226546FAD5BF4FF", hash_generated_method = "72D6685F428C89BB09923E6FD30CD28D")
    
public float getWidth() {
        return p1.minus(p0).length();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.113 -0400", hash_original_method = "59A1F6D498A22F4457DCBEEA926F3D30", hash_generated_method = "E6A3BC2880B0BEEB50A2A8F36994ECEC")
    
public float getHeight() {
        return p2.minus(p0).length();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.115 -0400", hash_original_method = "622214E29C2F01FB54B5B8B9E4F4D602", hash_generated_method = "49ECB95787067EFE75735DBE49EB8808")
    
public Point center() {
        return p0.plus(p1).plus(p2).plus(p3).times(0.25f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.117 -0400", hash_original_method = "2299D78A7AE4DC1D67D64756EEDC8C76", hash_generated_method = "F591FD91F47C29BDCAE13A118FBD9A8F")
    
@Override
    public Rectangle scaled(float s) {
        return new Rectangle(p0.times(s), p1.times(s), p2.times(s), p3.times(s));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.119 -0400", hash_original_method = "F53F9D21F8B26925DAEFDA10B19AA2F8", hash_generated_method = "073C1D209F6E26187778244A5B624387")
    
@Override
    public Rectangle scaled(float x, float y) {
        return new Rectangle(p0.mult(x, y), p1.mult(x, y), p2.mult(x, y), p3.mult(x, y));
    }

    //public Rectangle rotated(float radians) {
      // TODO: Implement this.
    //}

}
