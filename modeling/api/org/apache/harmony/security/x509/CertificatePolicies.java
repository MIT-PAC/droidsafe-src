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

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class CertificatePolicies extends ExtensionValue {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.218 -0500", hash_original_method = "DC44CF52860484CAD2DBA77AF7318FF9", hash_generated_method = "BE5F1D718329979E0707634D244A77A5")
    
public static CertificatePolicies decode(byte[] encoding) throws IOException {
        CertificatePolicies cps = ((CertificatePolicies) ASN1.decode(encoding));
        cps.encoding = encoding;
        return cps;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.952 -0400", hash_original_field = "513989838E566B722E0AE48FE445DE0C", hash_generated_field = "C5B8ADE8005B79F0446643932F6EFA0A")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(PolicyInformation.ASN1) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.233 -0500", hash_original_method = "457342872C7F92CB7E191C0BDCD7A375", hash_generated_method = "786DA4CE0CC88A458B725FFD82275D44")
        
@Override public Object getDecodedObject(BerInputStream in) {
            return new CertificatePolicies((List<PolicyInformation>) in.content, in.getEncoded());
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.236 -0500", hash_original_method = "563F4100455C194AB82610E48FB026CF", hash_generated_method = "C22E0B5D2039FB737EDE953AC64BEACB")
        
@Override public Collection getValues(Object object) {
            CertificatePolicies cps = (CertificatePolicies) object;
            return cps.policyInformations;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.211 -0500", hash_original_field = "D7154010CA73EBC692833293BF18127E", hash_generated_field = "29ED1BA56666577354DE7DACD9A96978")

    private List<PolicyInformation> policyInformations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.213 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    /**
     * Constructs an object representing the value of CertificatePolicies.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.216 -0500", hash_original_method = "C31E4B8F2A567252600FDAE2EEE40805", hash_generated_method = "4CD365A78323C4BB36D47418BB273373")
    
public CertificatePolicies() {}

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.221 -0500", hash_original_method = "96307D3270AEFEAD70E1FBA0E6122CDE", hash_generated_method = "3D44680DA2DFBACB6C01B668A744797F")
    
private CertificatePolicies(List<PolicyInformation> policyInformations, byte[] encoding) {
        this.policyInformations = policyInformations;
        this.encoding = encoding;
    }

    /**
     * Returns the values of policyInformation field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.223 -0500", hash_original_method = "183BA6590E2DC5B6BD268518AC8D5EF9", hash_generated_method = "11677BD68D1BD97D14F77EF37A9260A2")
    
public List<PolicyInformation> getPolicyInformations() {
        return new ArrayList<PolicyInformation>(policyInformations);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.225 -0500", hash_original_method = "A02C1EF38503FEE398CFC051AC7B3321", hash_generated_method = "46F1380A0B7A63350A01721B694437E7")
    
public CertificatePolicies addPolicyInformation(PolicyInformation policyInformation) {
        encoding = null;
        if (policyInformations == null) {
            policyInformations = new ArrayList<PolicyInformation>();
        }
        policyInformations.add(policyInformation);
        return this;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 CertificatePolicies value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.228 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "552F71A862C62513AAC32037F4D2FC1B")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.230 -0500", hash_original_method = "B37538291358B4289176EF26A3BFC720", hash_generated_method = "11675135B8D5FD981EE6CBC6E3BF12F5")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CertificatePolicies [\n");
        for (PolicyInformation policyInformation : policyInformations) {
            sb.append(prefix);
            sb.append("  ");
            policyInformation.dumpValue(sb);
            sb.append('\n');
        }
        sb.append(prefix).append("]\n");
    }
}

