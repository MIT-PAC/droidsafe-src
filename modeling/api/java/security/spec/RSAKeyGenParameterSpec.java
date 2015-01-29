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
 * The parameter specification for generating an RSA key pair.
 */
public class RSAKeyGenParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.417 -0400", hash_original_field = "109A3F125677EF5457CA2A94A8C4A2FD", hash_generated_field = "110039A41BB6C2E0B4E72DF8E49D21C3")

    public static final BigInteger F0 = BigInteger.valueOf(3L);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.418 -0400", hash_original_field = "A7F8AF6980722C2D7E7FBF9790E795B2", hash_generated_field = "CB0485863BD5B8FBC915DD2BE8CD1F4F")

    public static final BigInteger F4 = BigInteger.valueOf(65537L);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.420 -0400", hash_original_field = "C96CC91B2AEE467E4784ABFF977B727B", hash_generated_field = "1B19E6F989BA387FF06F4AEBD085E094")

    private  int keysize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.421 -0400", hash_original_field = "DB6D44C8A44BDBF62F098CD0EF0F38F6", hash_generated_field = "79B82A8776BB04757B8A80F0464419F4")

    private  BigInteger publicExponent;

    /**
     * Creates a new {@code RSAKeyGenParameterSpec} with the specified key size
     * and public exponent.
     *
     * @param keysize
     *            the size of the modulus (number of bits).
     * @param publicExponent
     *            the value of the public exponent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.422 -0400", hash_original_method = "4663EB24835EE805F4479EA858E7D839", hash_generated_method = "1CCA4342958C2F62018263BF0209CF81")
    
public RSAKeyGenParameterSpec(int keysize, BigInteger publicExponent) {
        this.keysize = keysize;
        this.publicExponent = publicExponent;
    }

    /**
     * Returns the size of the modulus (number of bits).
     *
     * @return the size of the modulus (number of bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.424 -0400", hash_original_method = "656FA8EF468913A383607EB6352430B8", hash_generated_method = "6C6A3C6D2A4301966A00779532DBE1F5")
    
public int getKeysize() {
        return keysize;
    }

    /**
     * Returns the value of the public exponent.
     *
     * @return the value of the public exponent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.425 -0400", hash_original_method = "32183112217BF048572A8B0F43293474", hash_generated_method = "CDD9969A60E00BAEF22FCCEA56318047")
    
public BigInteger getPublicExponent() {
        return publicExponent;
    }
}
