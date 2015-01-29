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

/**
 * The parameters specifying an Elliptic Curve (EC) public key.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ECPublicKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.220 -0400", hash_original_field = "4D0D4E3434F38C5C381DE3A648588089", hash_generated_field = "D9C9E8ABEFD271A17FF40A4EA029203A")

    private  ECPoint w;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.221 -0400", hash_original_field = "896DDC513F684A9A0CFEFD8A99B1FEA4", hash_generated_field = "2CEBEAAE316EB9539C033FEE599C6FE2")

    private  ECParameterSpec params;

    /**
     * Creates a new {@code ECPublicKey} with the specified public elliptic
     * curve point and parameter specification.
     *
     * @param w
     *            the public elliptic curve point {@code W}.
     * @param params
     *            the domain parameter specification.
     * @throws IllegalArgumentException
     *             if the specified point {@code W} is at infinity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.223 -0400", hash_original_method = "7679AFAC207852A5BD0157E081E13AA5", hash_generated_method = "374574C138816BA243C51CF08C0C3EC6")
    
public ECPublicKeySpec(ECPoint w, ECParameterSpec params) {
        this.w = w;
        this.params = params;
        // throw NullPointerException if w or params is null
        if (this.w == null) {
            throw new NullPointerException("w == null");
        }
        if (this.params == null) {
            throw new NullPointerException("params == null");
        }
        // throw IllegalArgumentException if w is point at infinity
        if (this.w.equals(ECPoint.POINT_INFINITY)) {
            throw new IllegalArgumentException("the w parameter is point at infinity");
        }
    }

    /**
     * Returns the domain parameter specification.
     *
     * @return the domain parameter specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.224 -0400", hash_original_method = "F4FB024BDF2F767FE1F38E77064EA4B2", hash_generated_method = "A45CF0667299631529075FF4C57C967A")
    
public ECParameterSpec getParams() {
        return params;
    }

    /**
     * Returns the public elliptic curve point {@code W}.
     *
     * @return the public elliptic curve point {@code W}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.225 -0400", hash_original_method = "A9627E993B2FC4BA1244966E9406150E", hash_generated_method = "500FE28A5359A8A58C1EE65B1926A196")
    
public ECPoint getW() {
        return w;
    }
}
