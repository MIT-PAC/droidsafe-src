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


package javax.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.harmony.security.fortress.Engine;

public class KeyGenerator {

    /**
     * Creates a new {@code KeyGenerator} instance that provides the specified
     * key algorithm,
     *
     * @param algorithm
     *            the name of the requested key algorithm
     * @return the new {@code KeyGenerator} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not available by any provider.
     * @throws NullPointerException
     *             if {@code algorithm} is {@code null}.
     */
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.569 -0500", hash_original_method = "BD816AE4DD995E718D0C3792E2DEE981", hash_generated_method = "9FDCB6AC7C447C2E6ECDC9987EE6B3C2")
    
public static final KeyGenerator getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new KeyGenerator((KeyGeneratorSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code KeyGenerator} instance that provides the specified
     * key algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested key algorithm.
     * @param provider
     *            the name of the provider that is providing the algorithm.
     * @return the new {@code KeyGenerator} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not provided by the specified
     *             provider.
     * @throws NoSuchProviderException
     *             if the specified provider is not available.
     * @throws IllegalArgumentException
     *             if the specified provider is name is {@code null} or empty.
     * @throws NullPointerException
     *             if the specified algorithm name is {@code null}.
     */
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.571 -0500", hash_original_method = "60BC696F85209D3194EC66CFB6C6D37C", hash_generated_method = "69FD95E465632B746ABB88C13A7FFC1F")
    
public static final KeyGenerator getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    /**
     * Creates a new {@code KeyGenerator} instance that provides the specified
     * key algorithm from the specified provider.
     *
     * @param algorithm
     *            the name of the requested key algorithm.
     * @param provider
     *            the provider that is providing the algorithm
     * @return the new {@code KeyGenerator} instance.
     * @throws NoSuchAlgorithmException
     *             if the specified algorithm is not provided by the specified
     *             provider.
     * @throws IllegalArgumentException
     *             if the specified provider is {@code null}.
     * @throws NullPointerException
     *             if the specified algorithm name is {@code null}.
     */
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.574 -0500", hash_original_method = "7A51885CAA1E3FF01634B7B94D0044CF", hash_generated_method = "95A782347D859F680A496CB921C67A1D")
    
public static final KeyGenerator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new KeyGenerator((KeyGeneratorSpi) spi, provider, algorithm);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.549 -0500", hash_original_field = "96FCEC0355612CE8110C2C970F8B903C", hash_generated_field = "94DDEF4E1FF385576E6D52DD87DBDCAD")

    private static final Engine ENGINE = new Engine("KeyGenerator");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.552 -0500", hash_original_field = "FDD9E227182999EA06EE5AF5CE50D8B1", hash_generated_field = "971A4862B04E3FBF4A69F43F59DCA289")

    private static final SecureRandom RANDOM = new SecureRandom();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.554 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.556 -0500", hash_original_field = "FFA2B316304F9491BBE9890283DFE0A3", hash_generated_field = "062ACE2CCE472120F5290B09DE19D1CD")

    private  KeyGeneratorSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.558 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code KeyGenerator} instance.
     *
     * @param keyGenSpi
     *            the implementation delegate.
     * @param provider
     *            the implementation provider.
     * @param algorithm
     *            the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.562 -0500", hash_original_method = "CDE5B5D4C1159ABF8B3201BF166F4FB3", hash_generated_method = "DAAA4EECD85002FA3E4D6A00CBF85402")
    
protected KeyGenerator(KeyGeneratorSpi keyGenSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = keyGenSpi;
    }

    /**
     * Returns the name of the key generation algorithm.
     *
     * @return the name of the key generation algorithm.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.564 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider of this {@code KeyGenerator} instance.
     *
     * @return the provider of this {@code KeyGenerator} instance.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.566 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Generates a secret key.
     *
     * @return the generated secret key.
     */
    @DSSource({DSSourceKind.SECURITY_INFO})
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.576 -0500", hash_original_method = "0D649746A13B62933617343FF6CF66A5", hash_generated_method = "C9900E7F2C4B294CA337B2E78AED3438")
    
public final SecretKey generateKey() {
        return spiImpl.engineGenerateKey();
    }

    /**
     * Initializes this {@code KeyGenerator} instance with the specified
     * algorithm parameters.
     *
     * @param params
     *            the parameters for the key generation algorithm.
     * @throws InvalidAlgorithmParameterException
     *             if the parameters cannot be used to initialize this key
     *             generator algorithm.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.579 -0500", hash_original_method = "17294700B35C898F2BBCFAFBE5495088", hash_generated_method = "22F17F8B9B11D838E7098469B6639866")
    
public final void init(AlgorithmParameterSpec params)
            throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(params, RANDOM);//new SecureRandom());
    }

    /**
     * Initializes this {@code KeyGenerator} instance with the specified
     * algorithm parameters and randomness source.
     *
     * @param params
     *            the parameters for the key generation algorithm.
     * @param random
     *            the randomness source for any random bytes.
     * @throws InvalidAlgorithmParameterException
     *             if the parameters cannot be uses to initialize this key
     *             generator algorithm.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.581 -0500", hash_original_method = "EA2F3DD217CBA336387110AFDED2F185", hash_generated_method = "BC184BF751405A3AC5726456D0AE1BE6")
    
public final void init(AlgorithmParameterSpec params, SecureRandom random)
            throws InvalidAlgorithmParameterException {
        spiImpl.engineInit(params, random);
    }

    /**
     * Initializes this {@code KeyGenerator} instance for the specified key size
     * (in bits).
     *
     * @param keysize
     *            the size of the key (in bits).
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.584 -0500", hash_original_method = "6A1F56561EFECC925D99D4402BD46267", hash_generated_method = "1DC649CB72FB63644D761193EC6CB48E")
    
public final void init(int keysize) {
        spiImpl.engineInit(keysize, RANDOM);//new SecureRandom());
    }

    /**
     * Initializes this {@code KeyGenerator} instance for the specified key size
     * (in bits) using the specified randomness source.
     *
     * @param keysize
     *            the size of the key (in bits).
     * @param random
     *            the randomness source for any random bytes.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.586 -0500", hash_original_method = "CF9BC038E48C7FD5928A7551030B0A46", hash_generated_method = "CBCD5E53E82B92399C96E4C7B8FC625E")
    
public final void init(int keysize, SecureRandom random) {
        spiImpl.engineInit(keysize, random);
    }

    /**
     * Initializes this {@code KeyGenerator} with the specified randomness
     * source.
     *
     * @param random
     *            the randomness source for any random bytes.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.589 -0500", hash_original_method = "E0B65F149BDE3033A715A5DC9A4C8256", hash_generated_method = "D9779A2987BF40D7E7EE8F748325FA5F")
    
public final void init(SecureRandom random) {
        spiImpl.engineInit(random);
    }
}

