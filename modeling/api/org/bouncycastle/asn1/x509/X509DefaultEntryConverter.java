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
import java.io.IOException;

import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.011 -0400", hash_original_method = "685C200736A0E688088DFBD6E10169A1", hash_generated_method = "685C200736A0E688088DFBD6E10169A1")
    public X509DefaultEntryConverter ()
    {
        //Synthesized constructor
    }
    /**
     * Apply default coversion for the given value depending on the oid
     * and the character range of the value.
     * 
     * @param oid the object identifier for the DN entry
     * @param value the value associated with it
     * @return the ASN.1 equivalent for the string value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.190 -0500", hash_original_method = "E0075DF75B4E99D6DCA984CA2F76B1C5", hash_generated_method = "65C23488AA7B25DC20A14CAB8DE26F94")
    
public DERObject getConvertedValue(
        DERObjectIdentifier  oid,
        String               value)
    {
        if (value.length() != 0 && value.charAt(0) == '#')
        {
            try
            {
                return convertHexEncoded(value, 1);
            }
            catch (IOException e)
            {
                throw new RuntimeException("can't recode value for oid " + oid.getId());
            }
        }
        else
        {
            if (value.length() != 0 && value.charAt(0) == '\\')
            {
                value = value.substring(1);
            }
            if (oid.equals(X509Name.EmailAddress) || oid.equals(X509Name.DC))
            {
                return new DERIA5String(value);
            }
            else if (oid.equals(X509Name.DATE_OF_BIRTH))  // accept time string as well as # (for compatibility)
            {
                return new DERGeneralizedTime(value);
            }
            else if (oid.equals(X509Name.C) || oid.equals(X509Name.SN) || oid.equals(X509Name.DN_QUALIFIER)
                || oid.equals(X509Name.TELEPHONE_NUMBER))
            {
                 return new DERPrintableString(value);
            }
        }
        
        return new DERUTF8String(value);
    }
    
}

