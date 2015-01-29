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
 * The parameters specifying an Elliptic Curve (EC) private key.
 */
public class ECPrivateKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.197 -0400", hash_original_field = "426FAAF7032CD560A9A3A3756AA46D58", hash_generated_field = "9A4185EA9BB79466709B635429E32798")

    private  BigInteger s;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.198 -0400", hash_original_field = "896DDC513F684A9A0CFEFD8A99B1FEA4", hash_generated_field = "2CEBEAAE316EB9539C033FEE599C6FE2")

    private  ECParameterSpec params;

    /**
     * Creates a new {@code ECPrivateKeySpec} with the specified private value
     * {@code S} and parameter specification.
     *
     * @param s
     *            the private value {@code S}.
     * @param params
     *            the domain parameter specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.201 -0400", hash_original_method = "FBCEAFCAC66B3E616505827469697D53", hash_generated_method = "BC86B8EB7987FFEE7F23A815D2CC796B")
    
public ECPrivateKeySpec(BigInteger s, ECParameterSpec params) {
        this.s = s;
        this.params = params;
        // throw NullPointerException if s or params is null
        if (this.s == null) {
            throw new NullPointerException("s == null");
        }
        if (this.params == null) {
            throw new NullPointerException("params == null");
        }
    }

    /**
     * Returns the domain parameter specification.
     *
     * @return the domain parameter specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.202 -0400", hash_original_method = "F4FB024BDF2F767FE1F38E77064EA4B2", hash_generated_method = "A45CF0667299631529075FF4C57C967A")
    
public ECParameterSpec getParams() {
        return params;
    }

    /**
     * Returns the private value {@code S}.
     *
     * @return the private value {@code S}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.204 -0400", hash_original_method = "E53DECEF42FF76233575CC8357CE48F6", hash_generated_method = "847CFB7AC0517B051073B851A5234C79")
    
public BigInteger getS() {
        return s;
    }
}
