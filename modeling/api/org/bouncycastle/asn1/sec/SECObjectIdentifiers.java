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


package org.bouncycastle.asn1.sec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;

public interface SECObjectIdentifiers
{
    
    static final ASN1ObjectIdentifier ellipticCurve = new ASN1ObjectIdentifier("1.3.132.0");

    static final ASN1ObjectIdentifier sect163k1 = ellipticCurve.branch("1");
    static final ASN1ObjectIdentifier sect163r1 = ellipticCurve.branch("2");
    static final ASN1ObjectIdentifier sect239k1 = ellipticCurve.branch("3");
    static final ASN1ObjectIdentifier sect113r1 = ellipticCurve.branch("4");
    static final ASN1ObjectIdentifier sect113r2 = ellipticCurve.branch("5");
    static final ASN1ObjectIdentifier secp112r1 = ellipticCurve.branch("6");
    static final ASN1ObjectIdentifier secp112r2 = ellipticCurve.branch("7");
    static final ASN1ObjectIdentifier secp160r1 = ellipticCurve.branch("8");
    static final ASN1ObjectIdentifier secp160k1 = ellipticCurve.branch("9");
    static final ASN1ObjectIdentifier secp256k1 = ellipticCurve.branch("10");
    static final ASN1ObjectIdentifier sect163r2 = ellipticCurve.branch("15");
    static final ASN1ObjectIdentifier sect283k1 = ellipticCurve.branch("16");
    static final ASN1ObjectIdentifier sect283r1 = ellipticCurve.branch("17");
    static final ASN1ObjectIdentifier sect131r1 = ellipticCurve.branch("22");
    static final ASN1ObjectIdentifier sect131r2 = ellipticCurve.branch("23");
    static final ASN1ObjectIdentifier sect193r1 = ellipticCurve.branch("24");
    static final ASN1ObjectIdentifier sect193r2 = ellipticCurve.branch("25");
    static final ASN1ObjectIdentifier sect233k1 = ellipticCurve.branch("26");
    static final ASN1ObjectIdentifier sect233r1 = ellipticCurve.branch("27");
    static final ASN1ObjectIdentifier secp128r1 = ellipticCurve.branch("28");
    static final ASN1ObjectIdentifier secp128r2 = ellipticCurve.branch("29");
    static final ASN1ObjectIdentifier secp160r2 = ellipticCurve.branch("30");
    static final ASN1ObjectIdentifier secp192k1 = ellipticCurve.branch("31");
    static final ASN1ObjectIdentifier secp224k1 = ellipticCurve.branch("32");
    static final ASN1ObjectIdentifier secp224r1 = ellipticCurve.branch("33");
    static final ASN1ObjectIdentifier secp384r1 = ellipticCurve.branch("34");
    static final ASN1ObjectIdentifier secp521r1 = ellipticCurve.branch("35");
    static final ASN1ObjectIdentifier sect409k1 = ellipticCurve.branch("36");
    static final ASN1ObjectIdentifier sect409r1 = ellipticCurve.branch("37");
    static final ASN1ObjectIdentifier sect571k1 = ellipticCurve.branch("38");
    static final ASN1ObjectIdentifier sect571r1 = ellipticCurve.branch("39");

    static final ASN1ObjectIdentifier secp192r1 = X9ObjectIdentifiers.prime192v1;
    static final ASN1ObjectIdentifier secp256r1 = X9ObjectIdentifiers.prime256v1;

}
