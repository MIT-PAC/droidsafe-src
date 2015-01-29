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
import java.lang.Math;

/**
 * @hide
 */
public class Point {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.807 -0400", hash_original_field = "EED2933541FCCE7155092AF77A402EA9", hash_generated_field = "0CC4A8770822EF2A4B3BD536BBF6C113")

    public float x;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.809 -0400", hash_original_field = "531E5158163E3809C8650CC9FEEE1C8C", hash_generated_field = "E8D9A0915E4274087E59C025C4DCDA11")

    public float y;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.811 -0400", hash_original_method = "D4552E1315F6D591F9A42261DB9D057B", hash_generated_method = "8FFCC2F5EFA8C2EC3A4BF6EFD301796D")
    
public Point() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.813 -0400", hash_original_method = "D3CF02A7F6B10EDCE2F8C86106C35D63", hash_generated_method = "81EF156A8E38336E58C87736BCB5052A")
    
public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.815 -0400", hash_original_method = "F7BA2399A270106D49FE9F3CEDD1B64C", hash_generated_method = "D17A7EDF98D2C5664D504C92508BA930")
    
public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.817 -0400", hash_original_method = "125574BA78D4F221A137D9013D0281F1", hash_generated_method = "E99DD0769EC623E47985CAC278390F69")
    
public boolean IsInUnitRange() {
        return x >= 0.0f && x <= 1.0f &&
               y >= 0.0f && y <= 1.0f;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.819 -0400", hash_original_method = "4EB5521867170528EE61152501361E14", hash_generated_method = "8F357C2D6E4FF6677753C163F1362273")
    
public Point plus(float x, float y) {
        return new Point(this.x + x, this.y + y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.821 -0400", hash_original_method = "4DFFE34D345FAB6B63C8BF9D1561D553", hash_generated_method = "4BFD5E910DF59A9786953FD6B6C1D2EA")
    
public Point plus(Point point) {
        return this.plus(point.x, point.y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.823 -0400", hash_original_method = "29F9A77158968FBEDA250EFEEDFDA1B7", hash_generated_method = "2C3280861D378F571FDC0A6D79D6272A")
    
public Point minus(float x, float y) {
        return new Point(this.x - x, this.y - y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.824 -0400", hash_original_method = "486C2F188880348C918C451195113665", hash_generated_method = "522D5944BF0E996ABDC3F7B5062A68FA")
    
public Point minus(Point point) {
        return this.minus(point.x, point.y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.826 -0400", hash_original_method = "68A2DAC5567666DDBD8350464949AF92", hash_generated_method = "25E231100DF1A3CF7356C4D9A0E85F8B")
    
public Point times(float s) {
        return new Point(this.x * s, this.y * s);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.828 -0400", hash_original_method = "3DF766877927AE7A96B78121505A290C", hash_generated_method = "EEF8899EAC077E69501A9A1A2F13F25A")
    
public Point mult(float x, float y) {
        return new Point(this.x * x, this.y * y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.830 -0400", hash_original_method = "86E9CEC69DFBDE4C511394B2EF034E3B", hash_generated_method = "47AEB49E6123F2AFDF71BBBBA7B206D6")
    
public float length() {
        return (float)Math.sqrt(x*x + y*y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.832 -0400", hash_original_method = "D4473670603F50E4A48BD00E926E7CC3", hash_generated_method = "68F6E6F0B9DDE3D061F6FB034CB195EB")
    
public float distanceTo(Point p) {
        return p.minus(this).length();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.836 -0400", hash_original_method = "A73381EAB64B2E22491F495EF33A41E8", hash_generated_method = "4BD48354CA2DB90BF77E2BEAE2D287E6")
    
public Point scaledTo(float length) {
        return this.times(length / this.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.838 -0400", hash_original_method = "31F4E7A45578C875FC2449C514E4DEED", hash_generated_method = "45F1B191CBDE14ABCE1546C59ED9798C")
    
public Point normalize() {
        return this.scaledTo(1.0f);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.840 -0400", hash_original_method = "1564556504B734DBDC2C2F6EDE3F5347", hash_generated_method = "958511B1256F8E70D742C6F1651568A3")
    
public Point rotated90(int count) {
        float nx = this.x;
        float ny = this.y;
        for (int i = 0; i < count; ++i) {
            float ox = nx;
            nx = ny;
            ny = -ox;
        }
        return new Point(nx, ny);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.842 -0400", hash_original_method = "C663BE769BDA9250A705D77625E77C9D", hash_generated_method = "425A45736091487E5B9A0A89EB7E4A5D")
    
public Point rotated(float radians) {
        // TODO(renn): Optimize: Keep cache of cos/sin values
        return new Point((float)(Math.cos(radians) * x - Math.sin(radians) * y),
                         (float)(Math.sin(radians) * x + Math.cos(radians) * y));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.844 -0400", hash_original_method = "9B107FE9451933490912D95F9499532D", hash_generated_method = "AAAAEEC69F39177D36622FDC189BAF27")
    
public Point rotatedAround(Point center, float radians) {
        return this.minus(center).rotated(radians).plus(center);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:12.846 -0400", hash_original_method = "3BCCF680E1B810A4245E3918FEC22C41", hash_generated_method = "A8D303659B7806D632D7EBFB975AC50A")
    
@Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
