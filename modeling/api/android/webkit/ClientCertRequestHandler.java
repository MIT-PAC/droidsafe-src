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
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import org.apache.harmony.xnet.provider.jsse.NativeCrypto;

public final class ClientCertRequestHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.613 -0500", hash_original_field = "3FC88C05AF84F1DA5801895C1A5E2AA9", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private  BrowserFrame mBrowserFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.615 -0500", hash_original_field = "BE4FBA339B8964B0ABF1E6F625B8029F", hash_generated_field = "24C6DFC54244C0ECB3E13AC2BDE66375")

    private  int mHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.617 -0500", hash_original_field = "30FDD9F1C15A7F7AF107048EC31A5B17", hash_generated_field = "906B3EAB5ED48B1D91170F5670978988")

    private  String mHostAndPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.620 -0500", hash_original_field = "98449DF5F308CC416E08C87F002F786A", hash_generated_field = "CEA12ECAAA37536F06C699DA1C7C1084")

    private  SslClientCertLookupTable mTable;
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.623 -0500", hash_original_method = "AEE151B717737CBCB7A587EF1854CBAA", hash_generated_method = "AEE151B717737CBCB7A587EF1854CBAA")
    
ClientCertRequestHandler(BrowserFrame browserFrame,
                             int handle,
                             String host_and_port,
                             SslClientCertLookupTable table) {
        mBrowserFrame = browserFrame;
        mHandle = handle;
        mHostAndPort = host_and_port;
        mTable = table;
    }

    /**
     * Proceed with the specified private key and client certificate chain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.625 -0500", hash_original_method = "FD9D9C54290793DEF25EE96780FA43D9", hash_generated_method = "0D823BB8817086852D9CC56BB148DF51")
    
public void proceed(PrivateKey privateKey, X509Certificate[] chain) {
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[][] chainBytes;
        try {
            chainBytes = NativeCrypto.encodeCertificates(chain);
        } catch (CertificateEncodingException e) {
            mBrowserFrame.nativeSslClientCert(mHandle, null, null);
            return;
        }
        mTable.Allow(mHostAndPort, privateKeyBytes, chainBytes);
        mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
    }

    /**
     * Igore the request for now, the user may be prompted again.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.628 -0500", hash_original_method = "FA404A4E1A97322F22CB23ECA9545548", hash_generated_method = "3AADC2C31F442BC0C036CF279DEA7EC9")
    
public void ignore() {
        mBrowserFrame.nativeSslClientCert(mHandle, null, null);
    }

    /**
     * Cancel this request, remember the users negative choice.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.630 -0500", hash_original_method = "E250E51CEC55FC558312A1D8553D2784", hash_generated_method = "16E4B6B0FCD735FE4AE16227A8A11C24")
    
public void cancel() {
        mTable.Deny(mHostAndPort);
        mBrowserFrame.nativeSslClientCert(mHandle, null, null);
    }
    
}

