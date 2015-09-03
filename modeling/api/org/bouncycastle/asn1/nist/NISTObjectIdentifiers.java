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


package org.bouncycastle.asn1.nist;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface NISTObjectIdentifiers
{
    
    
    

    
    
    
    static final ASN1ObjectIdentifier    nistAlgorithm          = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");

    static final ASN1ObjectIdentifier    id_sha256               = nistAlgorithm.branch("2.1");
    static final ASN1ObjectIdentifier    id_sha384               = nistAlgorithm.branch("2.2");
    static final ASN1ObjectIdentifier    id_sha512               = nistAlgorithm.branch("2.3");
    static final ASN1ObjectIdentifier    id_sha224               = nistAlgorithm.branch("2.4");
    
    static final ASN1ObjectIdentifier    aes                     =  nistAlgorithm.branch("1");
    
    static final ASN1ObjectIdentifier    id_aes128_ECB           = aes.branch("1"); 
    static final ASN1ObjectIdentifier    id_aes128_CBC           = aes.branch("2");
    static final ASN1ObjectIdentifier    id_aes128_OFB           = aes.branch("3"); 
    static final ASN1ObjectIdentifier    id_aes128_CFB           = aes.branch("4"); 
    static final ASN1ObjectIdentifier    id_aes128_wrap          = aes.branch("5");
    static final ASN1ObjectIdentifier    id_aes128_GCM           = aes.branch("6");
    static final ASN1ObjectIdentifier    id_aes128_CCM           = aes.branch("7");
    
    static final ASN1ObjectIdentifier    id_aes192_ECB           = aes.branch("21"); 
    static final ASN1ObjectIdentifier    id_aes192_CBC           = aes.branch("22"); 
    static final ASN1ObjectIdentifier    id_aes192_OFB           = aes.branch("23"); 
    static final ASN1ObjectIdentifier    id_aes192_CFB           = aes.branch("24"); 
    static final ASN1ObjectIdentifier    id_aes192_wrap          = aes.branch("25");
    static final ASN1ObjectIdentifier    id_aes192_GCM           = aes.branch("26");
    static final ASN1ObjectIdentifier    id_aes192_CCM           = aes.branch("27");
    
    static final ASN1ObjectIdentifier    id_aes256_ECB           = aes.branch("41"); 
    static final ASN1ObjectIdentifier    id_aes256_CBC           = aes.branch("42");
    static final ASN1ObjectIdentifier    id_aes256_OFB           = aes.branch("43"); 
    static final ASN1ObjectIdentifier    id_aes256_CFB           = aes.branch("44"); 
    static final ASN1ObjectIdentifier    id_aes256_wrap          = aes.branch("45"); 
    static final ASN1ObjectIdentifier    id_aes256_GCM           = aes.branch("46");
    static final ASN1ObjectIdentifier    id_aes256_CCM           = aes.branch("47");

    
    
    
    static final ASN1ObjectIdentifier    id_dsa_with_sha2        = nistAlgorithm.branch("3");

    static final ASN1ObjectIdentifier    dsa_with_sha224         = id_dsa_with_sha2.branch("1");
    static final ASN1ObjectIdentifier    dsa_with_sha256         = id_dsa_with_sha2.branch("2");
    static final ASN1ObjectIdentifier    dsa_with_sha384         = id_dsa_with_sha2.branch("3");
    static final ASN1ObjectIdentifier    dsa_with_sha512         = id_dsa_with_sha2.branch("4");
}
