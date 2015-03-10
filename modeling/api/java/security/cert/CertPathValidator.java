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
 * This class provides the functionality for validating certification paths
 * (certificate chains) establishing a trust chain from a certificate to a trust
 * anchor.
 */
public class CertPathValidator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.203 -0400", hash_original_field = "2C042234A323E23D67B721B6C80192FF", hash_generated_field = "07AD9EE167EC6D33852ECF0BFF299428")

    private static final String SERVICE = "CertPathValidator";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.204 -0400", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.206 -0400", hash_original_field = "6A76CC35B2F5A3801A7D853BEA3170B6", hash_generated_field = "13ED9B49BAB699A0048FEC7D679C4B06")

    private static final String PROPERTYNAME = "certpathvalidator.type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.210 -0400", hash_original_field = "F4A90B598507F6DB6CD852CF3588ED3C", hash_generated_field = "4C828EA9AAA3EEC481E9FAC0D42F1238")

    // property is not defined in java.security file
    private static final String DEFAULTPROPERTY = "PKIX";

    /**
     * Returns a new certification path validator for the specified algorithm.
     *
     * @param algorithm
     *            the algorithm name.
     * @return a certification path validator for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if no installed provider provides the specified algorithm.
     * @throws NullPointerException
     *             if algorithm is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.222 -0400", hash_original_method = "593AF38EECAFABEE6EE4822D1F00E049", hash_generated_method = "F9FC64C648CB6EE5A46246B79C62EF43")
    
public static CertPathValidator getInstance(String algorithm)
            throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new CertPathValidator((CertPathValidatorSpi) sap.spi, sap.provider, algorithm);
    }

    /**
     * Returns a new certification path validator for the specified algorithm
     * from the specified provider.
     *
     * @param algorithm
     *            the algorithm name.
     * @param provider
     *            the security provider name.
     * @return a certification path validator for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified security provider cannot provide the
     *             requested algorithm.
     * @throws NoSuchProviderException
     *             if no provider with the specified name can be found.
     * @throws NullPointerException
     *             if algorithm is {@code null}.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.223 -0400", hash_original_method = "EDEA3B93EAAE186AD57AFE139CB96FA5", hash_generated_method = "761FF7B50A7922B4EE299FBED63F970C")
    
public static CertPathValidator getInstance(String algorithm,
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
     * Returns a new certification path validator for the specified algorithm
     * from the specified provider.
     *
     * @param algorithm
     *            the algorithm name.
     * @param provider
     *            the security provider name.
     * @return a certification path validator for the requested algorithm.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             algorithm.
     * @throws IllegalArgumentException if {@code provider == null}
     * @throws NullPointerException
     *             if algorithm is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.225 -0400", hash_original_method = "97A0D6ECA1592A509528A76A166D5EBB", hash_generated_method = "DC1700F44FEAD48FC23F02D71A0F67BB")
    
public static CertPathValidator getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new CertPathValidator((CertPathValidatorSpi) spi, provider, algorithm);
    }

    /**
     * Returns the default {@code CertPathValidator} type from the <i>Security
     * Properties</i>.
     *
     * @return the default {@code CertPathValidator} type from the <i>Security
     *         Properties</i>, or the string {@code "PKIX"} if it cannot be
     *         determined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.228 -0400", hash_original_method = "C573737DC81D174BB614406CF5CA400D", hash_generated_method = "61010172C3A92A4A891073165E1CA30B")
    
public static final String getDefaultType() {
        String defaultType = Security.getProperty(PROPERTYNAME);
        return (defaultType != null ? defaultType : DEFAULTPROPERTY);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.212 -0400", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.213 -0400", hash_original_field = "6318A6505A6692AAA8EF040D431D943A", hash_generated_field = "6ABCB0A2DB2F543C8FA8349CBA515C84")

    private  CertPathValidatorSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.215 -0400", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private  String algorithm;

    /**
     * Creates a new {@code CertPathValidator} instance.
     *
     * @param validatorSpi
     *            the implementation delegate.
     * @param provider
     *            the security provider.
     * @param algorithm
     *            the name of the algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.216 -0400", hash_original_method = "F31AA3B2B86863E0185FB299892A43FA", hash_generated_method = "67706897D985AB3E84C5A8EA3EE5E60F")
    
protected CertPathValidator(CertPathValidatorSpi validatorSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = validatorSpi;
    }

    /**
     * Returns the certification path algorithm name.
     *
     * @return the certification path algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.218 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
    
public final String getAlgorithm() {
        return algorithm;
    }

    /**
     * Returns the security provider.
     *
     * @return the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.220 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Validates the {@code CertPath} with the algorithm of this {@code
     * CertPathValidator} using the specified algorithm parameters.
     *
     * @param certPath
     *            the certification path to be validated.
     * @param params
     *            the certification path validator algorithm parameters.
     * @return the validation result.
     * @throws CertPathValidatorException
     *             if the validation fails, or the algorithm of the specified
     *             certification path cannot be validated using the algorithm of
     *             this instance.
     * @throws InvalidAlgorithmParameterException
     *             if the specified algorithm parameters cannot be used with
     *             this algorithm.
     * @see CertPathValidatorResult
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.226 -0400", hash_original_method = "C33A772429EDA319AB300718AD2BC1EC", hash_generated_method = "7A2AE516F4574CF4A4A676DC0C2A42FD")
    
public final CertPathValidatorResult validate(CertPath certPath,
            CertPathParameters params) throws CertPathValidatorException,
            InvalidAlgorithmParameterException {
        return spiImpl.engineValidate(certPath, params);
    }
}
