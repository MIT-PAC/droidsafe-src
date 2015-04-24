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


package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;

public abstract class KeyPairGeneratorSpi {
    /**
     * Constructs a new instance of {@code KeyPairGeneratorSpi}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.645 -0500", hash_original_method = "CDF881F5D78C7440721315183DA160B5", hash_generated_method = "7175B6D3A50E38748B9545E8BAA15E45")
    
public KeyPairGeneratorSpi() {
    }

    /**
     * Computes and returns a new unique {@code KeyPair} each time this method
     * is called.
     *
     * @return a new unique {@code KeyPair} each time this method is called.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.648 -0500", hash_original_method = "D7450E1FCF116D6D34B6E19514AE2619", hash_generated_method = "120CECF0AA3746501E45C5FCB09D710C")
    
public abstract KeyPair generateKeyPair();

    /**
     * Initializes this {@code KeyPairGeneratorSpi} with the given key size and
     * the given {@code SecureRandom}. The default parameter set will be used.
     *
     * @param keysize
     *            the key size (number of bits).
     * @param random
     *            the source of randomness.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.650 -0500", hash_original_method = "6D427E576964585CD602010869E8BB6D", hash_generated_method = "6D6C69B4AAFD6A809A8B3BC78ED1D67E")
    
public abstract void initialize(int keysize, SecureRandom random);

    /**
     * Initializes this {@code KeyPairGeneratorSpi} with the given {@code
     * AlgorithmParameterSpec} and the given {@code SecureRandom}.
     *
     * @param params
     *            the parameters to use.
     * @param random
     *            the source of randomness.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.653 -0500", hash_original_method = "C370D2A572FDE8D7C9214C2A1EC5BB2B", hash_generated_method = "798EA52CBC686B13F5E315A9B465F33C")
    
public void initialize(AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }
    
}

