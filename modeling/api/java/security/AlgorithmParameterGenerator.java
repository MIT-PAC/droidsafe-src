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
import org.apache.harmony.security.fortress.Engine;

/**
 * {@code AlgorithmParameterGenerator} is an engine class which is capable of
 * generating parameters for the algorithm it was initialized with.
 */
public class AlgorithmParameterGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.336 -0400", hash_original_field = "27BD5A5F8F0250C224AB7645E14C76A3", hash_generated_field = "704CD5F595F59EB577921602B4102029")

    private static final String SERVICE = "AlgorithmParameterGenerator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.337 -0400", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.339 -0400", hash_original_field = "FDD9E227182999EA06EE5AF5CE50D8B1", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Returns a new instance of {@code AlgorithmParameterGenerator} for the
     * specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @return a new instance of {@code AlgorithmParameterGenerator} for the
     *         specified algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.348 -0400", hash_original_method = "F05F70F97362DCE1A7A274D970490BB7", hash_generated_method = "8821C4E9DEF91076487CB016A513C498")
    
public static AlgorithmParameterGenerator getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new AlgorithmParameterGenerator((AlgorithmParameterGeneratorSpi) sap.spi,
                                               sap.provider, algorithm);
    }

    /**
     * Returns a new instance of {@code AlgorithmParameterGenerator} from the
     * specified provider for the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            name of the provider of the {@code
     *            AlgorithmParameterGenerator}.
     * @return a new instance of {@code AlgorithmParameterGenerator} for the
     *         specified algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.350 -0400", hash_original_method = "673CE1EB5C81102817415A019C0A7905", hash_generated_method = "E57894E0F7C3196D7389E0166EAFB51B")
    
public static AlgorithmParameterGenerator getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Returns a new instance of {@code AlgorithmParameterGenerator} from the
     * specified provider for the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm to use.
     * @param provider
     *            the provider of the {@code AlgorithmParameterGenerator}.
     * @return a new instance of {@code AlgorithmParameterGenerator} for the
     *         specified algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.352 -0400", hash_original_method = "D062867B568FC0CB66B213130421D9AB", hash_generated_method = "B2049CB5DB4DC124B04ECD4B92C2B8B6")
    
public static AlgorithmParameterGenerator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new AlgorithmParameterGenerator((AlgorithmParameterGeneratorSpi) spi, provider,
                                               algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.340 -0400", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.342 -0400", hash_original_field = "EB0CC5C2C1EC579B502041FCDC6AF865", hash_generated_field = "E0526EAFD3E3754C216176B29780645C")

    private  AlgorithmParameterGeneratorSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.343 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Constructs a new instance of {@code AlgorithmParameterGenerator} with the
     * given arguments.
     *
     * @param paramGenSpi
     *            a concrete implementation, this engine instance delegates to.
     * @param provider
     *            the provider.
     * @param algorithm
     *            the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.345 -0400", hash_original_method = "D37B8F3930B26C7604F7F2D0463ABEAC", hash_generated_method = "B0203980C334B16BDD72C60EA0C147A5")
    
protected AlgorithmParameterGenerator(
            AlgorithmParameterGeneratorSpi paramGenSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = paramGenSpi;
    }

    /**
     * Returns the name of the algorithm.
     *
     * @return the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.346 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider associated with this {@code
     * AlgorithmParameterGenerator}.
     *
     * @return the provider associated with this {@code
     *         AlgorithmParameterGenerator}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.353 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Initializes this {@code AlgorithmParameterGenerator} with the given size.
     * The default parameter set and a default {@code SecureRandom} instance
     * will be used.
     *
     * @param size
     *            the size (in number of bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.355 -0400", hash_original_method = "DB470C04A2F89FB0CA21C518B2B10B84", hash_generated_method = "EB6299CDF6D5666240070728FA7D98FF")
    
public final void init(int size) {
        spiImpl.engineInit(size, RANDOM);
    }

    /**
     * Initializes this {@code AlgorithmParameterGenerator} with the given size
     * and the given {@code SecureRandom}. The default parameter set will be
     * used.
     *
     * @param size
     *            the size (in number of bits).
     * @param random
     *            the source of randomness.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.356 -0400", hash_original_method = "145DDEA25279FA9847F794BFF33A01F9", hash_generated_method = "C2F933661EC9A64EEF55407868B2F4B0")
    
public final void init(int size, SecureRandom random) {
        spiImpl.engineInit(size, random);
    }

    /**
     * Initializes this {@code AlgorithmParameterGenerator} with the given {@code
     * AlgorithmParameterSpec}. A default {@code SecureRandom} instance will be
     * used.
     *
     * @param genParamSpec
     *            the parameters to use.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.358 -0400", hash_original_method = "F5DCDBAD9A4CF97C9AD7D6AF20BF3FAB", hash_generated_method = "40CE5657F91E95A50EF7D411594B5E1D")
    
public final void init(AlgorithmParameterSpec genParamSpec)
            throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(genParamSpec, RANDOM);
    }

    /**
     * Initializes this {@code AlgorithmParameterGenerator} with the given
     * {@code AlgorithmParameterSpec} and the given {@code SecureRandom}.
     *
     * @param genParamSpec
     *            the parameters to use.
     * @param random
     *            the source of randomness.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters are not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.359 -0400", hash_original_method = "DA16091E7463AE8C1F280D01766CBA2C", hash_generated_method = "77F6B63DC5935ED47B22018D971AADE6")
    
public final void init(AlgorithmParameterSpec genParamSpec,
            SecureRandom random) throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(genParamSpec, random);
    }

    /**
     * Computes and returns {@code AlgorithmParameters} for this generator's
     * algorithm.
     *
     * @return {@code AlgorithmParameters} for this generator's algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.361 -0400", hash_original_method = "7D5E0F187B43CA022A922DFEDE4A9C5A", hash_generated_method = "F4445D3E262CEE76CF369E5006FA405D")
    
public final AlgorithmParameters generateParameters() {
        return spiImpl.engineGenerateParameters();
    }
}
