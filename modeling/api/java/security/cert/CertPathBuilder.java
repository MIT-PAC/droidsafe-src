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


package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.apache.harmony.security.fortress.Engine;

/**
 * This class implements the functionality of a builder for an unverified
 * <i>Certification Path</i>s from a specified certificate to a trust anchor.
 */
public class CertPathBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.100 -0400", hash_original_field = "F4C83D239BACE38B22DF793C2B70C598", hash_generated_field = "D372B326C4303B55EE3D05F6DB26E86D")

    private static final String SERVICE = "CertPathBuilder";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.102 -0400", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.103 -0400", hash_original_field = "4899587AC2C40504CD68A01583BF1EA9", hash_generated_field = "25C33066DA839BFB77A922C7990886BA")

    private static final String PROPERTYNAME = "certpathbuilder.type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.105 -0400", hash_original_field = "F4A90B598507F6DB6CD852CF3588ED3C", hash_generated_field = "4C828EA9AAA3EEC481E9FAC0D42F1238")

    // property is not defined in java.security file
    private static final String DEFAULTPROPERTY = "PKIX";

    /**
     * Creates a new {@code CertPathBuilder} instance with the specified
     * algorithm.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @return a builder for the requested algorithm.
     * @throws NullPointerException
     *             if the algorithm is {@code null}.
     * @throws NoSuchAlgorithmException
     *             if no installed provider can provide the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.114 -0400", hash_original_method = "7F4357C4F775B6EA75A746D0CE5141C2", hash_generated_method = "EDDA027703F0275F7308907C2D59F27D")
    
public static CertPathBuilder getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new CertPathBuilder((CertPathBuilderSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Creates a new {@code CertPathBuilder} instance from the specified
     * provider providing the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @param provider
     *            the name of the provider.
     * @return a builder for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the algorithm.
     * @throws NoSuchProviderException
     *             if no provider with the specified name can be found.
     * @throws NullPointerException
     *             if algorithm is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.117 -0400", hash_original_method = "A2078EBAAA52FFF5E9FDC470A11B0CDC", hash_generated_method = "41FCAEEF7A6990A8B66AAF85FFD7AD8D")
    
public static CertPathBuilder getInstance(String algorithm, String provider)
            throws NoSuchAlgorithmException, NoSuchProviderException {
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
     * Creates a new {@code CertPathBuilder} instance from the specified
     * provider providing the specified algorithm.
     *
     * @param algorithm
     *            the name of the algorithm.
     * @param provider
     *            the provider.
     * @return a builder for the requested algorithm
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the algorithm.
     * @throws IllegalArgumentException if {@code provider == null}
     * @throws NullPointerException
     *             if algorithm is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.118 -0400", hash_original_method = "AD0E06342A748729AFCDFA2F2CE5165A", hash_generated_method = "8571EF584466D391C85D1C0F216F1173")
    
public static CertPathBuilder getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new CertPathBuilder((CertPathBuilderSpi) spi, provider, algorithm);
    }

    /**
     * Returns the default {@code CertPathBuilder} type from the <i>Security
     * Properties</i>.
     *
     * @return the default {@code CertPathBuilder} type from the <i>Security
     *         Properties</i>, or the string "{@code PKIX}" if it cannot be
     *         determined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.122 -0400", hash_original_method = "C573737DC81D174BB614406CF5CA400D", hash_generated_method = "61010172C3A92A4A891073165E1CA30B")
    
public static final String getDefaultType() {
        String defaultType = Security.getProperty(PROPERTYNAME);
        return (defaultType != null ? defaultType : DEFAULTPROPERTY);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.106 -0400", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.107 -0400", hash_original_field = "54EA98693B01A96055D7975D56F44D7B", hash_generated_field = "EDA61213C497291971F1E8ACBB1A5618")

    private  CertPathBuilderSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.109 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code CertPathBuilder}.
     *
     * @param builderSpi
     *            the implementation delegate.
     * @param provider
     *            the provider.
     * @param algorithm
     *            the desired algorithm available at the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.110 -0400", hash_original_method = "90613DC60183834A09A7C1C017FF89D9", hash_generated_method = "CA4B4F435178E0A553035C5C10D895DE")
    
protected CertPathBuilder(CertPathBuilderSpi builderSpi, Provider provider,
            String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = builderSpi;
    }

    /**
     * Returns the algorithm name of this instance.
     *
     * @return the algorithm name of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.112 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the provider of this instance.
     *
     * @return the provider of this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.113 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Builds a certification path with the specified algorithm parameters.
     *
     * @param params
     *            the algorithm parameters.
     * @return the built certification path.
     * @throws CertPathBuilderException
     *             if the build fails.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to build with this
     *             builder.
     * @see CertPathBuilderResult
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.120 -0400", hash_original_method = "1385A79841FD2756C1AA471B7F04FD3A", hash_generated_method = "6F6CC5571BB7844B8125B8A828B86574")
    
public final CertPathBuilderResult build(CertPathParameters params)
            throws CertPathBuilderException, InvalidAlgorithmParameterException {
        return spiImpl.engineBuild(params);
    }
}
