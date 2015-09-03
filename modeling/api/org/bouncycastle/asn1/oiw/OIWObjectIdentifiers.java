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


package org.bouncycastle.asn1.oiw;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface OIWObjectIdentifiers
{
    
    
    static final ASN1ObjectIdentifier    md4WithRSA              = new ASN1ObjectIdentifier("1.3.14.3.2.2");
    static final ASN1ObjectIdentifier    md5WithRSA              = new ASN1ObjectIdentifier("1.3.14.3.2.3");
    static final ASN1ObjectIdentifier    md4WithRSAEncryption    = new ASN1ObjectIdentifier("1.3.14.3.2.4");
    
    static final ASN1ObjectIdentifier    desECB                  = new ASN1ObjectIdentifier("1.3.14.3.2.6");
    static final ASN1ObjectIdentifier    desCBC                  = new ASN1ObjectIdentifier("1.3.14.3.2.7");
    static final ASN1ObjectIdentifier    desOFB                  = new ASN1ObjectIdentifier("1.3.14.3.2.8");
    static final ASN1ObjectIdentifier    desCFB                  = new ASN1ObjectIdentifier("1.3.14.3.2.9");

    static final ASN1ObjectIdentifier    desEDE                  = new ASN1ObjectIdentifier("1.3.14.3.2.17");
    
    static final ASN1ObjectIdentifier    idSHA1                  = new ASN1ObjectIdentifier("1.3.14.3.2.26");

    static final ASN1ObjectIdentifier    dsaWithSHA1             = new ASN1ObjectIdentifier("1.3.14.3.2.27");

    static final ASN1ObjectIdentifier    sha1WithRSA             = new ASN1ObjectIdentifier("1.3.14.3.2.29");
    
    
    
    
    static final ASN1ObjectIdentifier    elGamalAlgorithm        = new ASN1ObjectIdentifier("1.3.14.7.2.1.1");

}
