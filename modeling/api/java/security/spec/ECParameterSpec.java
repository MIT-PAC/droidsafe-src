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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.security.spec;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.math.BigInteger;

/**
 * The parameter specification used with Elliptic Curve Cryptography (ECC).
 */
public class ECParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.118 -0400", hash_original_field = "B89F7FD03C4C3459370C462964ADC80E", hash_generated_field = "251B1EE3538DA1E2FC898F728B158180")

    private  EllipticCurve curve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.120 -0400", hash_original_field = "5ECC9BE706C904243B48DF55F5A40204", hash_generated_field = "53AC47CD1155FEDB3EB7917E75F81794")

    private  ECPoint generator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.121 -0400", hash_original_field = "96D2DE8DA407AD47A553BE74D6878E9C", hash_generated_field = "EF7D95923B4A093BDBF5432FA05D3C82")

    private  BigInteger order;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.122 -0400", hash_original_field = "5CA5E156070E483F5DCE5CBFFEC4B038", hash_generated_field = "5B2AA4874C80BD3F55AA15E390E854E6")

    private  int cofactor;

    /**
     * Creates a new {@code ECParameterSpec} with the specified elliptic curve,
     * the base point, the order of the generator (or base point) and the
     * co-factor.
     *
     * @param curve
     *            the elliptic curve.
     * @param generator
     *            the generator (or base point).
     * @param order
     *            the order of the generator.
     * @param cofactor
     *            the co-factor.
     * @throws IllegalArgumentException
     *             if {@code order <= zero} or {@code cofactor <= zero}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.124 -0400", hash_original_method = "96CEAA4E27F622D3AC0592E70E55C9DA", hash_generated_method = "EE7CC06C0994E6505601AAE66AFF826C")
    
public ECParameterSpec(EllipticCurve curve, ECPoint generator,
            BigInteger order, int cofactor) {
        this.curve = curve;
        this.generator = generator;
        this.order = order;
        this.cofactor = cofactor;
        // throw NullPointerException if curve, generator or order is null
        if (this.curve == null) {
            throw new NullPointerException("curve == null");
        }
        if (this.generator == null) {
            throw new NullPointerException("generator == null");
        }
        if (this.order == null) {
            throw new NullPointerException("order == null");
        }
        // throw IllegalArgumentException if order or cofactor is not positive
        if (!(this.order.compareTo(BigInteger.ZERO) > 0)) {
            throw new IllegalArgumentException("order <= 0");
        }
        if (!(this.cofactor > 0)) {
            throw new IllegalArgumentException("cofactor <= 0");
        }
    }

    /**
     * Returns the {@code cofactor}.
     *
     * @return the {@code cofactor}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.125 -0400", hash_original_method = "C711AAEC7FC341151D3C6C4D5B2D29CD", hash_generated_method = "2F746B275FE739025A78CFF0672B2EB4")
    
public int getCofactor() {
        return cofactor;
    }

    /**
     * Returns the elliptic curve.
     *
     * @return the elliptic curve.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.127 -0400", hash_original_method = "9807BB4D9209EDE70D905890B9EA39EC", hash_generated_method = "030CDE395E8A99D9D9518E554FD8B25F")
    
public EllipticCurve getCurve() {
        return curve;
    }

    /**
     * Returns the generator (or base point).
     *
     * @return the generator (or base point).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.128 -0400", hash_original_method = "D827C75FF831696BC94F9E675EFC7A51", hash_generated_method = "E5E55646434B6C5E287F4E83026F2376")
    
public ECPoint getGenerator() {
        return generator;
    }

    /**
     * Returns the order of the generator.
     *
     * @return the order of the generator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:17.129 -0400", hash_original_method = "8BD662F4762CEA0007E497F460479AE8", hash_generated_method = "F3078AB43D342E40B42639744D788FEA")
    
public BigInteger getOrder() {
        return order;
    }
}
