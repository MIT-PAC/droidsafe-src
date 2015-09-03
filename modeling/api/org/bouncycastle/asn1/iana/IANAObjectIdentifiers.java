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


package org.bouncycastle.asn1.iana;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface IANAObjectIdentifiers
{
    
    
    

    static final ASN1ObjectIdentifier    isakmpOakley  = new ASN1ObjectIdentifier("1.3.6.1.5.5.8.1");

    static final ASN1ObjectIdentifier    hmacMD5       = new ASN1ObjectIdentifier(isakmpOakley + ".1");
    static final ASN1ObjectIdentifier    hmacSHA1     = new ASN1ObjectIdentifier(isakmpOakley + ".2");
    
    static final ASN1ObjectIdentifier    hmacTIGER     = new ASN1ObjectIdentifier(isakmpOakley + ".3");
    
    static final ASN1ObjectIdentifier    hmacRIPEMD160 = new ASN1ObjectIdentifier(isakmpOakley + ".4");

}
