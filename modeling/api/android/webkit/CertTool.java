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
 * Copyright (C) 2009 The Android Open Source Project
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
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.netscape.NetscapeCertRequest;
import org.bouncycastle.util.encoders.Base64;

import android.content.Context;
import android.security.Credentials;
import android.security.KeyChain;
import android.util.Log;

final class CertTool {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.011 -0500", hash_original_method = "CB2D35D966CD710A64E9BD9F45549511", hash_generated_method = "16A514B58BB4148859FC4ED301091CD7")
    
static String[] getKeyStrengthList() {
        return new String[] {"High Grade", "Medium Grade"};
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.014 -0500", hash_original_method = "0C31F22EE5605896C042A9554E5E2F85", hash_generated_method = "D56FBDE3293A63C7B233422532D7DC04")
    
static String getSignedPublicKey(Context context, int index, String challenge) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize((index == 0) ? 2048 : 1024);
            KeyPair pair = generator.genKeyPair();

            NetscapeCertRequest request = new NetscapeCertRequest(challenge,
                    MD5_WITH_RSA, pair.getPublic());
            request.sign(pair.getPrivate());
            byte[] signed = request.toASN1Object().getDEREncoded();

            Credentials.getInstance().install(context, pair);
            return new String(Base64.encode(signed));
        } catch (Exception e) {
            Log.w(LOGTAG, e);
        }
        return null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.016 -0500", hash_original_method = "7A8048437C17E24F9A892E4FDE33D0BB", hash_generated_method = "61BC1E53B23D221FD5FE580A86EE5C50")
    
static void addCertificate(Context context, String type, byte[] value) {
        Credentials.getInstance().install(context, type, value);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.018 -0500", hash_original_method = "D4AF6F68FC296225D479C322C857B353", hash_generated_method = "1491190F75D0EB25846273129E9B3152")
    
static String getCertType(String mimeType) {
        return sCertificateTypeMap.get(mimeType);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.004 -0500", hash_original_field = "39E2DED3B53A8EDEC2FD565F9B8E87E0", hash_generated_field = "205D15FAC42FD8B1401CE817A71B270D")

    private static final String LOGTAG = "CertTool";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.006 -0500", hash_original_field = "C922C1E0E587BAE42337D813D01973D3", hash_generated_field = "CD5933C3A9B5A26C387D6522BB21C57D")

    private static final AlgorithmIdentifier MD5_WITH_RSA =
            new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.009 -0500", hash_original_field = "38906D82A9901FB743C573D20E88064E", hash_generated_field = "4B6102789B0D3F567AE83CB481B398FF")

    private static HashMap<String, String> sCertificateTypeMap;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.021 -0500", hash_original_method = "1838D0FEFA9E4F93A3624A1092DC54F1", hash_generated_method = "FD3B0B368FFB59B33F5C094D6E914C6F")
    
private CertTool() {}
    static {
        sCertificateTypeMap = new HashMap<String, String>();
        sCertificateTypeMap.put("application/x-x509-ca-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-x509-user-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-pkcs12", KeyChain.EXTRA_PKCS12);
    }
    
}

