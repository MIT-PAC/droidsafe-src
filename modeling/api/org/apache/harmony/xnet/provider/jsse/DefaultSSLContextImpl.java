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


package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class DefaultSSLContextImpl extends OpenSSLContextImpl {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.088 -0500", hash_original_field = "597F586052EA4DB698A92860AAA2AFE9", hash_generated_field = "566D6B41A10785704C5DA62CA709142C")

    private static KeyManager[] KEY_MANAGERS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.091 -0500", hash_original_field = "7E240F6BB967D0B3E4E647159202C0AC", hash_generated_field = "1EC7739BDEC2CA831D3D4FE81BA648C0")

    private static TrustManager[] TRUST_MANAGERS;

    /**
     * DefaultSSLContextImpl delegates the work to the super class
     * since there is no way to put a synchronized around both the
     * call to super and the rest of this constructor to guarantee
     * that we don't have races in creating the state shared between
     * all default SSLContexts.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.093 -0500", hash_original_method = "09005AB24FD7DF4C7BE4D5BB1BAB63A4", hash_generated_method = "96BEC411EC28BE38E6E384F8FA7CAE60")
    
public DefaultSSLContextImpl() throws GeneralSecurityException, IOException {
        super(null);
    }

    // TODO javax.net.ssl.keyStoreProvider system property
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.096 -0500", hash_original_method = "E512CF487829C633B2731FE964DEE240", hash_generated_method = "EAC19B8B4FD5A1F1B311A095D42F2FC7")
    
KeyManager[] getKeyManagers () throws GeneralSecurityException, IOException {
        if (KEY_MANAGERS != null) {
            return KEY_MANAGERS;
        }
        // find KeyStore, KeyManagers
        String keystore = System.getProperty("javax.net.ssl.keyStore");
        if (keystore == null) {
            return null;
        }
        String keystorepwd = System.getProperty("javax.net.ssl.keyStorePassword");
        char[] pwd = (keystorepwd == null) ? null : keystorepwd.toCharArray();

        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } finally {
            if (is != null) {
                is.close();
            }
        }

        String kmfAlg = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (kmfAlg == null) {
            kmfAlg = "SunX509";
        }

        KeyManagerFactory kmf = KeyManagerFactory.getInstance(kmfAlg);
        kmf.init(ks, pwd);
        KEY_MANAGERS = kmf.getKeyManagers();
        return KEY_MANAGERS;
    }

    // TODO javax.net.ssl.trustStoreProvider system property
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.099 -0500", hash_original_method = "06C43D579C0D6CACEEC14574641391C0", hash_generated_method = "91D2689A479083E2E70C28999FAAC745")
    
TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
        if (TRUST_MANAGERS != null) {
            return TRUST_MANAGERS;
        }

        // find TrustStore, TrustManagers
        String keystore = System.getProperty("javax.net.ssl.trustStore");
        if (keystore == null) {
            return null;
        }
        String keystorepwd = System.getProperty("javax.net.ssl.trustStorePassword");
        char[] pwd = (keystorepwd == null) ? null : keystorepwd.toCharArray();

        // TODO Defaults: jssecacerts; cacerts
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } finally {
            if (is != null) {
                is.close();
            }
        }
        String tmfAlg = Security.getProperty("ssl.TrustManagerFactory.algorithm");
        if (tmfAlg == null) {
            tmfAlg = "PKIX";
        }

        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlg);
        tmf.init(ks);
        TRUST_MANAGERS = tmf.getTrustManagers();
        return TRUST_MANAGERS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.101 -0500", hash_original_method = "C6A638FBF6A76AC1A136D02168ED58AC", hash_generated_method = "951FB07C60CD35D97FFE5CC3AEB3C84B")
    
@Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        throw new KeyManagementException("Do not init() the default SSLContext ");
    }
}

