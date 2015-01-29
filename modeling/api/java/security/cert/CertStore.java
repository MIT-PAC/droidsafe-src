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

package java.security.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import org.apache.harmony.security.fortress.Engine;

/**
 * This class provides the functionality to retrieve {@code Certificate}s and
 * {@code CRL}s from a read-only repository. This repository may be very large
 * and may store trusted as well as untrusted certificates.
 */
public class CertStore {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.340 -0400", hash_original_field = "B8ECB04A874EEE06880546F50C86E060", hash_generated_field = "6C51DBE054CD002D43AF74BF8E22E9AE")

    private static final String SERVICE = "CertStore";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.342 -0400", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.343 -0400", hash_original_field = "AA91040EF9CEFA9D07B0A6B9D493526A", hash_generated_field = "4681082F7D27D6F8901841E4FA5A861F")

    private static final String PROPERTYNAME = "certstore.type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.345 -0400", hash_original_field = "497FA12AE72CE1494558D4532169CBC6", hash_generated_field = "520780CD25BB8CB02388629C51B8EF2D")

    // property is not defined in java.security file
    private static final String DEFAULTPROPERTY = "LDAP";

    /**
     * Creates a new {@code CertStore} instance with the specified type and
     * initialized with the specified parameters.
     *
     * @param type
     *            the certificate store type.
     * @param params
     *            the certificate store parameters (may be {@code null}).
     * @return the new certificate store instance.
     * @throws NoSuchAlgorithmException
     *             if no provider can provide the specified certificate store
     *             type.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to initialize this
     *             certificate store instance.
     * @throws NullPointerException if {@code type == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.355 -0400", hash_original_method = "926BB63D909DEEBADD133415648CA4FC", hash_generated_method = "EE84EA4EAB8B083294D2976BC496A37A")
    
public static CertStore getInstance(String type, CertStoreParameters params)
            throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Engine.SpiAndProvider sap = ENGINE.getInstance(type, params);
            return new CertStore((CertStoreSpi) sap.spi, sap.provider, type, params);
        } catch (NoSuchAlgorithmException e) {
            Throwable th = e.getCause();
            if (th == null) {
                throw e;
            } else {
                throw new InvalidAlgorithmParameterException(e.getMessage(), th);
            }
        }
    }

    /**
     * Creates a new {@code CertStore} instance from the specified provider with
     * the specified type and initialized with the specified parameters.
     *
     * @param type
     *            the certificate store type.
     * @param params
     *            the certificate store parameters (may be {@code null}).
     * @param provider
     *            the name of the provider.
     * @return the new certificate store instance.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             certificate store type.
     * @throws NoSuchProviderException
     *             if no provider with the specified name can be found.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to initialize this
     *             certificate store instance.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     * @throws NullPointerException
     *             if {@code type} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.356 -0400", hash_original_method = "66A982866371A3030A61D039B18F7545", hash_generated_method = "4874B0D6B88DF7329C67C0FC286C9755")
    
public static CertStore getInstance(String type,
            CertStoreParameters params, String provider)
            throws InvalidAlgorithmParameterException,
            NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(type, params, impProvider);
    }

    /**
     * Creates a new {@code CertStore} instance from the specified provider with
     * the specified type and initialized with the specified parameters.
     * @param type
     *            the certificate store type.
     * @param params
     *            the certificate store parameters (may be {@code null}).
     * @param provider
     *            the name of the provider.
     * @return the new certificate store instance.
     * @throws NoSuchAlgorithmException
     *             if the specified provider cannot provide the requested
     *             certificate store type.
     * @throws InvalidAlgorithmParameterException
     *             if the specified parameters cannot be used to initialize this
     *             certificate store instance.
     * @throws IllegalArgumentException if {@code provider == null}
     * @throws NullPointerException if {@code type == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.358 -0400", hash_original_method = "E126CBA9C85C9508CE0B56ADBD5907ED", hash_generated_method = "8802DFF94BD09329A1615EA17A38F1B7")
    
public static CertStore getInstance(String type,
            CertStoreParameters params, Provider provider)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Object spi = ENGINE.getInstance(type, provider, params);
            return new CertStore((CertStoreSpi) spi, provider, type, params);
        } catch (NoSuchAlgorithmException e) {
            Throwable th = e.getCause();
            if (th == null) {
                throw e;
            } else {
                throw new InvalidAlgorithmParameterException(e.getMessage(), th);
            }
        }
    }

    /**
     * Returns the default {@code CertStore} type from the <i>Security
     * Properties</i>.
     *
     * @return the default {@code CertStore} type from the <i>Security
     *         Properties</i>, or the string {@code "LDAP"} if it cannot be
     *         determined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.367 -0400", hash_original_method = "C45930E76388EEF7CEACC441581D107B", hash_generated_method = "02BA60B42411BB0097FFD441E0F4BE31")
    
public static final String getDefaultType() {
        String defaultType = Security.getProperty(PROPERTYNAME);
        return (defaultType == null ? DEFAULTPROPERTY : defaultType);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.346 -0400", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.348 -0400", hash_original_field = "65B8D7C08749AFC01837DA8AFBF18D6F", hash_generated_field = "854E88F40A47B0B8E20DE13F0CF0B2A7")

    private  CertStoreSpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.350 -0400", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.351 -0400", hash_original_field = "E1625F0F89BB1D86FE52D7EF858462DA", hash_generated_field = "8C3EDC9DCD0708C03BD360BE46836CBC")

    private  CertStoreParameters certStoreParams;

    /**
     * Creates a new {@code CertStore} instance.
     *
     * @param storeSpi
     *            the implementation delegate.
     * @param provider
     *            the security provider.
     * @param type
     *            the certificate store type.
     * @param params
     *            the certificate store parameters (may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.353 -0400", hash_original_method = "8E4C1A459048B2233257AC10A81DD661", hash_generated_method = "6A0F56C1B6A86F0BD251B160ED4E7D6F")
    
protected CertStore(CertStoreSpi storeSpi, Provider provider, String type,
            CertStoreParameters params) {
        this.provider = provider;
        this.type = type;
        this.spiImpl = storeSpi;
        this.certStoreParams = params;
    }

    /**
     * Returns the certificate store type.
     *
     * @return the certificate store type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.360 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
    
public final String getType() {
        return type;
    }

    /**
     * Returns the security provider.
     *
     * @return the security provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.361 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    
public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns a copy of the certificate store parameters that were used to
     * initialize this instance.
     *
     * @return a copy of the certificate store parameters or {@code null} if
     *         none were specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.362 -0400", hash_original_method = "2783A957399B9863B5738ACD7D34A3AD", hash_generated_method = "9F982E8A42AA9F31879D0D31119A529B")
    
public final CertStoreParameters getCertStoreParameters() {
        if (certStoreParams == null) {
            return null;
        } else {
            return (CertStoreParameters) certStoreParams.clone();
        }
    }

    /**
     * Returns the list of {@code Certificate}s for the specified {@code
     * CertSelector} from this certificate store.
     *
     * @param selector
     *            the selector containing the criteria to search for
     *            certificates in this certificate store.
     * @return the list of {@code Certificate}s that match the criteria of the
     *         specified selector.
     * @throws CertStoreException
     *             if error(s) occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.364 -0400", hash_original_method = "EE4EFED6D35CF2EABFAC8D0BFE41CF13", hash_generated_method = "3875B427B06FD2B0D55C8318C101855E")
    
public final Collection<? extends Certificate> getCertificates(CertSelector selector)
            throws CertStoreException {
        return spiImpl.engineGetCertificates(selector);
    }

    /**
     * Returns the list of {@code CRL}s for the specified {@code CRLSelector}
     * from this certificate store.
     *
     * @param selector
     *            the selector containing the criteria to search for certificate
     *            revocation lists in this store.
     * @return the list of {@code CRL}s that match the criteria of the specified
     *         selector
     * @throws CertStoreException
     *             if error(s) occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:15.365 -0400", hash_original_method = "F7268DF78B0B038B65B848F168EBC3AE", hash_generated_method = "BA6C1A27D64ACD01EAA695A3FD1C2EFE")
    
public final Collection<? extends CRL> getCRLs(CRLSelector selector)
            throws CertStoreException {
        return spiImpl.engineGetCRLs(selector);
    }
}
