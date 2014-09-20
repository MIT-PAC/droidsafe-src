/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.security.spec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;

/**
 * A Point on an Elliptic Curve in barycentric (or affine) coordinates.
 */
public class ECPoint {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.162 -0400", hash_original_field = "6EE7DD5B69F8AA9AB5BF4BAFBFD82A08", hash_generated_field = "8A4B146619BC46F5FA3A97B28F270084")

    public static final ECPoint POINT_INFINITY = new ECPoint();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.164 -0400", hash_original_field = "FE0DDF2637344DC202B963B2141F3DB2", hash_generated_field = "FB40B838FF8E8DA7FAC7AF4B33395942")

    private  BigInteger affineX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.165 -0400", hash_original_field = "2CFD2408A6BAF2E60F98984E9405510F", hash_generated_field = "E06C943AB45C1DC501C737E046653C42")

    private  BigInteger affineY;

    // Private ctor for POINT_INFINITY
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.167 -0400", hash_original_method = "EE0DD98AF733060B49D806CAE0E8E595", hash_generated_method = "C4CF4256E6BDD64976D73C507AC4ACC2")
    
private ECPoint() {
        affineX = null;
        affineY = null;
    }

    /**
     * Creates a new point at the specified coordinates.
     *
     * @param affineX
     *            the x-coordinate.
     * @param affineY
     *            the y-coordinate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.169 -0400", hash_original_method = "095C28C2641D09706C8F3E3F55199644", hash_generated_method = "0FA57FCE419C0BC454B10D298F0D72F1")
    
public ECPoint(BigInteger affineX, BigInteger affineY) {
        this.affineX = affineX;
        if (this.affineX == null) {
            throw new NullPointerException("affineX == null");
        }
        this.affineY = affineY;
        if (this.affineY == null) {
            throw new NullPointerException("affineY == null");
        }
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate, or {@code null} for the infinite point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.170 -0400", hash_original_method = "8BF4809EEBCF8613EAAFA0303B4EEF5E", hash_generated_method = "BE87FDCA6B06AB6841832DCA006E371D")
    
public BigInteger getAffineX() {
        return affineX;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate, or {@code null} fot the infinite point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.171 -0400", hash_original_method = "23D7238F99D75219754803A7F2104977", hash_generated_method = "8F26A7973A42D9778B5CD0DE116F96E9")
    
public BigInteger getAffineY() {
        return affineY;
    }

    /**
     * Returns whether the specified object and this elliptic curve point are
     * equal.
     *
     * @param other
     *            the object to compare.
     * @return {@code true} if the specified object and this elliptic curve
     *         point are equal, otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.173 -0400", hash_original_method = "ED767277BE9B9353BA6E55E45B5D3046", hash_generated_method = "429FF00105B18AA2FB2F0680DF2B3118")
    
public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ECPoint) {
            if (this.affineX != null) {
                ECPoint otherPoint = (ECPoint)other;
                // no need to check for null in this case
                return this.affineX.equals(otherPoint.affineX) &&
                       this.affineY.equals(otherPoint.affineY);
            } else {
                return other == POINT_INFINITY;
            }
        }
        return false;
    }

    /**
     * Returns the hashcode of this elliptic curve point.
     *
     * @return the hashcode of this elliptic curve point.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.174 -0400", hash_original_method = "7D0802AE058B69373C9211777848E4E9", hash_generated_method = "F281A6306CBBA78FDB94CB7DC874597E")
    
public int hashCode() {
        if (this.affineX != null) {
            return affineX.hashCode() * 31 + affineY.hashCode();
        }
        return 11;
    }
}
