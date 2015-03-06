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


package org.bouncycastle.asn1.bc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.DERObjectIdentifier;

public interface BCObjectIdentifiers
{
    
    public static final DERObjectIdentifier bc = new DERObjectIdentifier("1.3.6.1.4.1.22554");

    
    public static final DERObjectIdentifier bc_pbe = new DERObjectIdentifier(bc.getId() + ".1");

    
    public static final DERObjectIdentifier bc_pbe_sha1 = new DERObjectIdentifier(bc_pbe.getId() + ".1");

    
    public static final DERObjectIdentifier bc_pbe_sha256 = new DERObjectIdentifier(bc_pbe.getId() + ".2.1");
    public static final DERObjectIdentifier bc_pbe_sha384 = new DERObjectIdentifier(bc_pbe.getId() + ".2.2");
    public static final DERObjectIdentifier bc_pbe_sha512 = new DERObjectIdentifier(bc_pbe.getId() + ".2.3");
    public static final DERObjectIdentifier bc_pbe_sha224 = new DERObjectIdentifier(bc_pbe.getId() + ".2.4");

    
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs5 = new DERObjectIdentifier(bc_pbe_sha1.getId() + ".1");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12 = new DERObjectIdentifier(bc_pbe_sha1.getId() + ".2");

    public static final DERObjectIdentifier bc_pbe_sha256_pkcs5 = new DERObjectIdentifier(bc_pbe_sha256.getId() + ".1");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12 = new DERObjectIdentifier(bc_pbe_sha256.getId() + ".2");

    
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc = new DERObjectIdentifier(bc_pbe_sha1_pkcs12.getId() + ".1.2");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc = new DERObjectIdentifier(bc_pbe_sha1_pkcs12.getId() + ".1.22");
    public static final DERObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc = new DERObjectIdentifier(bc_pbe_sha1_pkcs12.getId() + ".1.42");

    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc = new DERObjectIdentifier(bc_pbe_sha256_pkcs12.getId() + ".1.2");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc = new DERObjectIdentifier(bc_pbe_sha256_pkcs12.getId() + ".1.22");
    public static final DERObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc = new DERObjectIdentifier(bc_pbe_sha256_pkcs12.getId() + ".1.42");
}
