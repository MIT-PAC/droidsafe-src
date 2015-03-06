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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface X509ObjectIdentifiers
{
    
    
    
    static final String                 id                      = "2.5.4";

    static final ASN1ObjectIdentifier    commonName              = new ASN1ObjectIdentifier(id + ".3");
    static final ASN1ObjectIdentifier    countryName             = new ASN1ObjectIdentifier(id + ".6");
    static final ASN1ObjectIdentifier    localityName            = new ASN1ObjectIdentifier(id + ".7");
    static final ASN1ObjectIdentifier    stateOrProvinceName     = new ASN1ObjectIdentifier(id + ".8");
    static final ASN1ObjectIdentifier    organization            = new ASN1ObjectIdentifier(id + ".10");
    static final ASN1ObjectIdentifier    organizationalUnitName  = new ASN1ObjectIdentifier(id + ".11");

    static final ASN1ObjectIdentifier    id_at_telephoneNumber   = new ASN1ObjectIdentifier("2.5.4.20");
    static final ASN1ObjectIdentifier    id_at_name              = new ASN1ObjectIdentifier(id + ".41");

    
    
    static final ASN1ObjectIdentifier    id_SHA1                 = new ASN1ObjectIdentifier("1.3.14.3.2.26");

    
    
    
    
    static final ASN1ObjectIdentifier    ripemd160               = new ASN1ObjectIdentifier("1.3.36.3.2.1");

    
    
    
    
    static final ASN1ObjectIdentifier    ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2");


    static final ASN1ObjectIdentifier    id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1");
    
    
    static final ASN1ObjectIdentifier id_pkix = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");

    
    
    
    static final ASN1ObjectIdentifier  id_pe = new ASN1ObjectIdentifier(id_pkix + ".1");

    
    
    
    static final ASN1ObjectIdentifier  id_ad = new ASN1ObjectIdentifier(id_pkix + ".48");
    static final ASN1ObjectIdentifier  id_ad_caIssuers = new ASN1ObjectIdentifier(id_ad + ".2");
    static final ASN1ObjectIdentifier  id_ad_ocsp = new ASN1ObjectIdentifier(id_ad + ".1");

    
    
    
    static final ASN1ObjectIdentifier ocspAccessMethod = id_ad_ocsp;
    static final ASN1ObjectIdentifier crlAccessMethod = id_ad_caIssuers;
}
