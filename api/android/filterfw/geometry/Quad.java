/*
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

package android.filterfw.geometry;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.filterfw.geometry.Point;

import java.lang.Float;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @hide
 */
public class Quad {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.975 -0400", hash_original_field = "BBA76B717567CC37DBA239BA64988B33", hash_generated_field = "ABD4A0A69CD7BB8E6E5734D8B7392636")

    public Point p0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.977 -0400", hash_original_field = "4B3043BDDCF823402C5220BE06C543A5", hash_generated_field = "7B91C914A0039DA78C8EA504C6EA072C")

    public Point p1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.979 -0400", hash_original_field = "F90651D2CAC0012D6CDE5201F6834888", hash_generated_field = "7902C0BC65B78AF99DD0A36CB0F83C72")

    public Point p2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.981 -0400", hash_original_field = "7A3684CE819C6182853DE5735DCD4886", hash_generated_field = "F5DD4F092214D94A9E568883868EB88E")

    public Point p3;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.982 -0400", hash_original_method = "71C10F40874C2D5B9F6AD58AC815F12B", hash_generated_method = "9265B039FE721481C0E98D530DF1D27D")
    
public Quad() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.985 -0400", hash_original_method = "0C26683148E88EE130842691720445E1", hash_generated_method = "8DD2073EC0AB73687B5168BEB71AE66E")
    
public Quad(Point p0, Point p1, Point p2, Point p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.987 -0400", hash_original_method = "B25C20749442A0EC94B9BF5D7B329A00", hash_generated_method = "23760091CB492B9EB89B52AF51F9A0A8")
    
public boolean IsInUnitRange() {
        return p0.IsInUnitRange() &&
               p1.IsInUnitRange() &&
               p2.IsInUnitRange() &&
               p3.IsInUnitRange();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.989 -0400", hash_original_method = "62A50D36FC47754B691AFC2D5236FCAC", hash_generated_method = "99C18A8D62929AD425E1D52A7816D349")
    
public Quad translated(Point t) {
        return new Quad(p0.plus(t), p1.plus(t), p2.plus(t), p3.plus(t));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.991 -0400", hash_original_method = "B829ED67F503FA4902CAA93C371F8B3D", hash_generated_method = "8CB2F62496F1B008A09CD37047ACA699")
    
public Quad translated(float x, float y) {
        return new Quad(p0.plus(x, y), p1.plus(x, y), p2.plus(x, y), p3.plus(x, y));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.993 -0400", hash_original_method = "7CE6558A29DDA8BF916D7F1C9A699526", hash_generated_method = "59E9FA96D7E0E8C6B90FC2B82891AFDE")
    
public Quad scaled(float s) {
        return new Quad(p0.times(s), p1.times(s), p2.times(s), p3.times(s));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.994 -0400", hash_original_method = "5059AA94C8F6E5EEC573C67B456909E9", hash_generated_method = "C520ED7F1F56F0D1AD5F4CAF9856347D")
    
public Quad scaled(float x, float y) {
        return new Quad(p0.mult(x, y), p1.mult(x, y), p2.mult(x, y), p3.mult(x, y));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.996 -0400", hash_original_method = "DC5AD1EFDB0EE1F5B0C41B161821DA7F", hash_generated_method = "A4501C3100BD24F24C7D6354F9AA6998")
    
public Rectangle boundingBox() {
        List<Float> xs = Arrays.asList(p0.x, p1.x, p2.x, p3.x);
        List<Float> ys = Arrays.asList(p0.y, p1.y, p2.y, p3.y);
        float x0 = Collections.min(xs);
        float y0 = Collections.min(ys);
        float x1 = Collections.max(xs);
        float y1 = Collections.max(ys);
        return new Rectangle(x0, y0, x1 - x0, y1 - y0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.999 -0400", hash_original_method = "9A8A6B8F580C564EFBC15D3A4A67D1D4", hash_generated_method = "801441DFDD9641C59D94FEED20DAD892")
    
public float getBoundingWidth() {
        List<Float> xs = Arrays.asList(p0.x, p1.x, p2.x, p3.x);
        return Collections.max(xs) - Collections.min(xs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.001 -0400", hash_original_method = "8D0DE5129CC5B350897E6E9A171B2175", hash_generated_method = "C9F9E2C1DBA705674B50501691508F39")
    
public float getBoundingHeight() {
        List<Float> ys = Arrays.asList(p0.y, p1.y, p2.y, p3.y);
        return Collections.max(ys) - Collections.min(ys);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.003 -0400", hash_original_method = "9B62DF2AC55D694C2B325E458D6BF5E8", hash_generated_method = "791A82AFF47F770C0DACC6BF590D7F13")
    
@Override
    public String toString() {
        return "{" + p0 + ", " + p1 + ", " + p2 + ", " + p3 + "}";
    }
}
