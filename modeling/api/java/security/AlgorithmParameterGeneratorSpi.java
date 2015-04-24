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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.spec.AlgorithmParameterSpec;

/**
 * {@code AlgorithmParameterGeneratorSpi} is the Service Provider Interface
 * (SPI) definition for {@code AlgorithmParameterGenerator}.
 *
 * @see AlgorithmParameterGenerator
 */
public abstract class AlgorithmParameterGeneratorSpi {

    /**
     * Constructs a new instance of {@code AlgorithmParameterGeneratorSpi} .
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.394 -0400", hash_original_method = "64F57FCD9EF315E47121C7DB5C214046", hash_generated_method = "C1205895F94E4E373F7AECBB14B7AD71")
    
public AlgorithmParameterGeneratorSpi() {
    }

    /**
     * Initializes this {@code AlgorithmParameterGeneratorSpi} with the given
     * size and the given {@code SecureRandom}. The default parameter set
     * will be used.
     *
     * @param size
     *            the size (in number of bits).
     * @param random
     *            the source of randomness.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.395 -0400", hash_original_method = "E9E9073B84940479F35F545D88793BBB", hash_generated_method = "CB5A52FA30E66F8ACD78C2F2CE858C78")
    
protected abstract void engineInit(int size, SecureRandom random);

    /**
     * Initializes this {@code AlgorithmParameterGeneratorSpi} with the given
     * {@code AlgorithmParameterSpec} and the given {@code SecureRandom}.
     *
     * @param genParamSpec
     *            the parameters to use.
     * @param random
     *            the source of randomness.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.396 -0400", hash_original_method = "376AACA226B7D73DACD3A31100A66925", hash_generated_method = "DE1BFBAABEED02C167F6D5E638F38EDA")
    
protected abstract void engineInit(AlgorithmParameterSpec genParamSpec,
            SecureRandom random) throws InvalidAlgorithmParameterException;

    /**
     * Computes and returns {@code AlgorithmParameters} for this generator's
     * algorithm.
     *
     * @return {@code AlgorithmParameters} for this generator's algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.398 -0400", hash_original_method = "783E1DC7CFB3A364F9BEC08552C3787A", hash_generated_method = "6BA9D9194B24FC2FA9954E69304E1B3F")
    
protected abstract AlgorithmParameters engineGenerateParameters();
}
