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


package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class DHParameterSpec implements AlgorithmParameterSpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.101 -0500", hash_original_field = "36A2346422FAB1A0484079E02615C501", hash_generated_field = "0E1745DDBCB8E3192EFA76F952746D75")

    private  BigInteger p;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.103 -0500", hash_original_field = "12F45ECD0F75F4702B861E1DEFDA99B3", hash_generated_field = "5E2139CE4CF026F837A4AD7B2D5946CD")

    private  BigInteger g;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.106 -0500", hash_original_field = "A0C0C721AA9DC7F55C8ABAA304DE8300", hash_generated_field = "79426B8570FE3512AB32B66CEA5A4180")

    private  int l;

    /**
     * Creates a new <code>DHParameterSpec</code> instance with the specified
     * <i>prime modulus</i> and <i>base generator</i>.
     *
     * @param p
     *            the prime modulus.
     * @param g
     *            the base generator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.108 -0500", hash_original_method = "F8E48B54378C41D41344A45EFE5DEAF0", hash_generated_method = "74983045D137E9350FBFD97EE97DADED")
    
public DHParameterSpec(BigInteger p, BigInteger g) {
        this.p = p;
        this.g = g;
        this.l = 0;
    }

    /**
     * Creates a new <code>DHParameterSpec</code> instance with the specified
     * <i>prime modulus</i>, <i>base generator</i> and size (in bits) of the
     * <i>random exponent</i>.
     *
     * @param p
     *            the prime modulus.
     * @param g
     *            the base generator.
     * @param l
     *            the size of the random exponent (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.112 -0500", hash_original_method = "ACD960FD5413B931010CFE492BF9890E", hash_generated_method = "E4393AFD6958329A32860BFDC2E67D73")
    
public DHParameterSpec(BigInteger p, BigInteger g, int l) {
        this.p = p;
        this.g = g;
        this.l = l;
    }

    /**
     * Returns the <i>prime modulus</i> of this parameter specification.
     *
     * @return the prime modulus.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.114 -0500", hash_original_method = "451C630A2F5A52BD2AE63729BE355876", hash_generated_method = "FA39994F0F567A64C38613032682F7D7")
    
public BigInteger getP() {
        return p;
    }

    /**
     * Returns the <i>base generator</i> of this parameter specification.
     *
     * @return the base generator.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.116 -0500", hash_original_method = "8C38F55FA5DB902C3D9409517AA217E2", hash_generated_method = "FBDB40C3059FF68266098ECF54AD2FB6")
    
public BigInteger getG() {
        return g;
    }

    /**
     * Returns the size (in bits) of the <i>random exponent</i>.
     *
     * @return the size (in bits) of the random exponent.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:55.118 -0500", hash_original_method = "657EAD8DC5C96D72590F45704DE7ABCD", hash_generated_method = "F51E52098F0714102B2F5862DD458995")
    
public int getL() {
        return l;
    }
    
}

